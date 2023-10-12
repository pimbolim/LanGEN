package net.time4j.tz.model;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.Moment;
import net.time4j.base.GregorianDate;
import net.time4j.base.GregorianMath;
import net.time4j.base.MathUtils;
import net.time4j.base.UnixTime;
import net.time4j.base.WallTime;
import net.time4j.engine.EpochDays;
import net.time4j.format.CalendarText;
import net.time4j.tz.ZonalOffset;
import net.time4j.tz.ZonalTransition;

final class RuleBasedTransitionModel extends TransitionModel {
    private static final int LAST_CACHED_YEAR = GregorianMath.readYear(GregorianMath.toPackedDate(EpochDays.MODIFIED_JULIAN_DATE.transform(TransitionModel.getFutureMoment(100), EpochDays.UNIX)));
    private static final long serialVersionUID = 2456700806862862287L;
    private final transient boolean gregorian;
    private final transient ZonalTransition initial;
    private final transient List<DaylightSavingRule> rules;
    private final transient List<ZonalTransition> stdTransitions;
    private final transient ConcurrentMap<Integer, List<ZonalTransition>> tCache;

    RuleBasedTransitionModel(ZonalOffset zonalOffset, List<DaylightSavingRule> list) {
        this(zonalOffset, list, true);
    }

    RuleBasedTransitionModel(ZonalOffset zonalOffset, List<DaylightSavingRule> list, boolean z) {
        this(new ZonalTransition(Long.MIN_VALUE, zonalOffset.getIntegralAmount(), zonalOffset.getIntegralAmount(), 0), list, z);
    }

    RuleBasedTransitionModel(ZonalTransition zonalTransition, List<DaylightSavingRule> list, boolean z) {
        ZonalTransition zonalTransition2;
        this.tCache = new ConcurrentHashMap();
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Missing daylight saving rules.");
        } else if (list.size() < 128) {
            list = z ? new ArrayList<>(list) : list;
            Collections.sort(list, RuleComparator.INSTANCE);
            String str = null;
            if (list.size() > 1) {
                for (DaylightSavingRule next : list) {
                    if (str == null) {
                        str = next.getCalendarType();
                    } else if (!str.equals(next.getCalendarType())) {
                        throw new IllegalArgumentException("Rules with different calendar systems not permitted.");
                    }
                }
            }
            this.gregorian = CalendarText.ISO_CALENDAR_TYPE.equals(str);
            if (zonalTransition.getPosixTime() != Long.MIN_VALUE) {
                if (zonalTransition.getTotalOffset() == getNextTransition(zonalTransition.getPosixTime(), zonalTransition, list).getPreviousOffset()) {
                    zonalTransition2 = zonalTransition;
                } else {
                    throw new IllegalArgumentException("Inconsistent model: " + zonalTransition + " / " + list);
                }
            } else if (zonalTransition.getDaylightSavingOffset() == 0) {
                zonalTransition2 = new ZonalTransition(Moment.axis().getMinimum().getPosixTime(), zonalTransition.getStandardOffset(), zonalTransition.getStandardOffset(), 0);
            } else {
                throw new IllegalArgumentException("Initial transition must not have any dst-offset: " + zonalTransition);
            }
            this.initial = zonalTransition2;
            List<DaylightSavingRule> unmodifiableList = Collections.unmodifiableList(list);
            this.rules = unmodifiableList;
            this.stdTransitions = getTransitions(zonalTransition2, unmodifiableList, 0, TransitionModel.getFutureMoment(1));
        } else {
            throw new IllegalArgumentException("Too many daylight saving rules: " + list);
        }
    }

    public ZonalOffset getInitialOffset() {
        return ZonalOffset.ofTotalSeconds(this.initial.getTotalOffset());
    }

    public ZonalTransition getStartTransition(UnixTime unixTime) {
        ZonalTransition zonalTransition;
        long posixTime = this.initial.getPosixTime();
        ZonalTransition zonalTransition2 = null;
        if (unixTime.getPosixTime() <= posixTime) {
            return null;
        }
        int standardOffset = this.initial.getStandardOffset();
        int size = this.rules.size();
        int i = 0;
        DaylightSavingRule daylightSavingRule = this.rules.get(0);
        int i2 = size - 1;
        int year = getYear(daylightSavingRule, unixTime.getPosixTime() + ((long) getShift(daylightSavingRule, standardOffset, this.rules.get(i2).getSavings())));
        List<ZonalTransition> transitions = getTransitions(year);
        while (i < size) {
            ZonalTransition zonalTransition3 = transitions.get(i);
            long posixTime2 = zonalTransition3.getPosixTime();
            if (unixTime.getPosixTime() >= posixTime2) {
                if (posixTime2 > posixTime) {
                    zonalTransition2 = zonalTransition3;
                }
                i++;
            } else if (zonalTransition2 != null) {
                return zonalTransition2;
            } else {
                if (i == 0) {
                    zonalTransition = getTransitions(year - 1).get(i2);
                } else {
                    zonalTransition = transitions.get(i - 1);
                }
                return zonalTransition.getPosixTime() > posixTime ? zonalTransition : zonalTransition2;
            }
        }
        return zonalTransition2;
    }

    public ZonalTransition getConflictTransition(GregorianDate gregorianDate, WallTime wallTime) {
        return getConflictTransition(gregorianDate, TransitionModel.toLocalSecs(gregorianDate, wallTime));
    }

    public ZonalTransition getNextTransition(UnixTime unixTime) {
        return getNextTransition(unixTime.getPosixTime(), this.initial, this.rules);
    }

    public List<ZonalOffset> getValidOffsets(GregorianDate gregorianDate, WallTime wallTime) {
        return getValidOffsets(gregorianDate, TransitionModel.toLocalSecs(gregorianDate, wallTime));
    }

    public List<ZonalTransition> getStdTransitions() {
        return this.stdTransitions;
    }

    public List<ZonalTransition> getTransitions(UnixTime unixTime, UnixTime unixTime2) {
        return getTransitions(this.initial, this.rules, unixTime.getPosixTime(), unixTime2.getPosixTime());
    }

    public boolean hasNegativeDST() {
        for (DaylightSavingRule savings : this.rules) {
            if (savings.getSavings() < 0) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RuleBasedTransitionModel)) {
            return false;
        }
        RuleBasedTransitionModel ruleBasedTransitionModel = (RuleBasedTransitionModel) obj;
        if (!this.initial.equals(ruleBasedTransitionModel.initial) || !this.rules.equals(ruleBasedTransitionModel.rules)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.initial.hashCode() * 17) + (this.rules.hashCode() * 37);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(256);
        sb.append(getClass().getName());
        sb.append("[initial=");
        sb.append(this.initial);
        sb.append(",rules=");
        sb.append(this.rules);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public void dump(Appendable appendable) throws IOException {
        appendable.append("*** Last rules:").append(NEW_LINE);
        for (DaylightSavingRule obj : this.rules) {
            appendable.append(">>> ").append(obj.toString()).append(NEW_LINE);
        }
    }

    /* access modifiers changed from: package-private */
    public ZonalTransition getInitialTransition() {
        return this.initial;
    }

    /* access modifiers changed from: package-private */
    public List<DaylightSavingRule> getRules() {
        return this.rules;
    }

    /* access modifiers changed from: package-private */
    public ZonalTransition getConflictTransition(GregorianDate gregorianDate, long j) {
        if (j <= this.initial.getPosixTime() + ((long) Math.max(this.initial.getPreviousOffset(), this.initial.getTotalOffset()))) {
            return null;
        }
        for (ZonalTransition next : getTransitions(gregorianDate)) {
            long posixTime = next.getPosixTime();
            if (next.isGap()) {
                if (j < ((long) next.getPreviousOffset()) + posixTime) {
                    return null;
                }
                if (j < posixTime + ((long) next.getTotalOffset())) {
                    return next;
                }
            } else if (!next.isOverlap()) {
                continue;
            } else if (j < ((long) next.getTotalOffset()) + posixTime) {
                return null;
            } else {
                if (j < posixTime + ((long) next.getPreviousOffset())) {
                    return next;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public List<ZonalOffset> getValidOffsets(GregorianDate gregorianDate, long j) {
        long posixTime = this.initial.getPosixTime();
        int totalOffset = this.initial.getTotalOffset();
        if (j <= posixTime + ((long) Math.max(this.initial.getPreviousOffset(), totalOffset))) {
            return TransitionModel.toList(totalOffset);
        }
        for (ZonalTransition next : getTransitions(gregorianDate)) {
            long posixTime2 = next.getPosixTime();
            int totalOffset2 = next.getTotalOffset();
            if (next.isGap()) {
                if (j < ((long) next.getPreviousOffset()) + posixTime2) {
                    return TransitionModel.toList(next.getPreviousOffset());
                }
                if (j < posixTime2 + ((long) totalOffset2)) {
                    return Collections.emptyList();
                }
            } else if (!next.isOverlap()) {
                continue;
            } else if (j < ((long) totalOffset2) + posixTime2) {
                return TransitionModel.toList(next.getPreviousOffset());
            } else {
                if (j < posixTime2 + ((long) next.getPreviousOffset())) {
                    return TransitionModel.toList(totalOffset2, next.getPreviousOffset());
                }
            }
            totalOffset = totalOffset2;
        }
        return TransitionModel.toList(totalOffset);
    }

    static List<ZonalTransition> getTransitions(ZonalTransition zonalTransition, List<DaylightSavingRule> list, long j, long j2) {
        int i;
        List<DaylightSavingRule> list2 = list;
        long j3 = j;
        long posixTime = zonalTransition.getPosixTime();
        int i2 = (j3 > j2 ? 1 : (j3 == j2 ? 0 : -1));
        if (i2 > 0) {
            throw new IllegalArgumentException("Start after end.");
        } else if (j2 <= posixTime || i2 == 0) {
            return Collections.emptyList();
        } else {
            ArrayList arrayList = new ArrayList();
            int i3 = Integer.MIN_VALUE;
            int size = list.size();
            int i4 = 0;
            int standardOffset = zonalTransition.getStandardOffset();
            while (true) {
                int i5 = i4 % size;
                DaylightSavingRule daylightSavingRule = list2.get(i5);
                DaylightSavingRule daylightSavingRule2 = list2.get(((i4 - 1) + size) % size);
                int shift = getShift(daylightSavingRule, standardOffset, daylightSavingRule2.getSavings());
                if (i4 == 0) {
                    i = size;
                    i3 = getYear(daylightSavingRule, Math.max(j3, posixTime) + ((long) shift));
                } else {
                    i = size;
                    if (i5 == 0) {
                        i3++;
                    }
                }
                long transitionTime = getTransitionTime(daylightSavingRule, i3, shift);
                i4++;
                if (transitionTime >= j2) {
                    return Collections.unmodifiableList(arrayList);
                }
                if (transitionTime >= j3 && transitionTime > posixTime) {
                    arrayList.add(new ZonalTransition(transitionTime, standardOffset + daylightSavingRule2.getSavings(), standardOffset + daylightSavingRule.getSavings(), daylightSavingRule.getSavings()));
                }
                size = i;
            }
        }
    }

    private static ZonalTransition getNextTransition(long j, ZonalTransition zonalTransition, List<DaylightSavingRule> list) {
        List<DaylightSavingRule> list2 = list;
        long max = Math.max(j, zonalTransition.getPosixTime());
        int standardOffset = zonalTransition.getStandardOffset();
        int size = list.size();
        int i = Integer.MIN_VALUE;
        ZonalTransition zonalTransition2 = null;
        int i2 = 0;
        while (zonalTransition2 == null) {
            int i3 = i2 % size;
            DaylightSavingRule daylightSavingRule = list2.get(i3);
            DaylightSavingRule daylightSavingRule2 = list2.get(((i2 - 1) + size) % size);
            int shift = getShift(daylightSavingRule, standardOffset, daylightSavingRule2.getSavings());
            if (i2 == 0) {
                i = getYear(daylightSavingRule, ((long) shift) + max);
            } else if (i3 == 0) {
                i++;
            }
            long transitionTime = getTransitionTime(daylightSavingRule, i, shift);
            if (transitionTime > max) {
                zonalTransition2 = new ZonalTransition(transitionTime, standardOffset + daylightSavingRule2.getSavings(), standardOffset + daylightSavingRule.getSavings(), daylightSavingRule.getSavings());
            }
            i2++;
        }
        return zonalTransition2;
    }

    private static int getShift(DaylightSavingRule daylightSavingRule, int i, int i2) {
        OffsetIndicator indicator = daylightSavingRule.getIndicator();
        int i3 = AnonymousClass1.$SwitchMap$net$time4j$tz$model$OffsetIndicator[indicator.ordinal()];
        if (i3 == 1) {
            return 0;
        }
        if (i3 == 2) {
            return i;
        }
        if (i3 == 3) {
            return i + i2;
        }
        throw new UnsupportedOperationException(indicator.name());
    }

    /* renamed from: net.time4j.tz.model.RuleBasedTransitionModel$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$tz$model$OffsetIndicator;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                net.time4j.tz.model.OffsetIndicator[] r0 = net.time4j.tz.model.OffsetIndicator.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$tz$model$OffsetIndicator = r0
                net.time4j.tz.model.OffsetIndicator r1 = net.time4j.tz.model.OffsetIndicator.UTC_TIME     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$tz$model$OffsetIndicator     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.tz.model.OffsetIndicator r1 = net.time4j.tz.model.OffsetIndicator.STANDARD_TIME     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$tz$model$OffsetIndicator     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.tz.model.OffsetIndicator r1 = net.time4j.tz.model.OffsetIndicator.WALL_TIME     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.tz.model.RuleBasedTransitionModel.AnonymousClass1.<clinit>():void");
        }
    }

    private static long getTransitionTime(DaylightSavingRule daylightSavingRule, int i, int i2) {
        return daylightSavingRule.getDate(i).at(daylightSavingRule.getTimeOfDay()).at(ZonalOffset.ofTotalSeconds(i2)).getPosixTime();
    }

    private List<ZonalTransition> getTransitions(GregorianDate gregorianDate) {
        return getTransitions(this.rules.get(0).toCalendarYear(gregorianDate));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0070, code lost:
        r1 = r0.tCache.putIfAbsent(r2, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<net.time4j.tz.ZonalTransition> getTransitions(int r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)
            java.util.concurrent.ConcurrentMap<java.lang.Integer, java.util.List<net.time4j.tz.ZonalTransition>> r3 = r0.tCache
            java.lang.Object r3 = r3.get(r2)
            java.util.List r3 = (java.util.List) r3
            if (r3 != 0) goto L_0x007b
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            net.time4j.tz.ZonalTransition r4 = r0.initial
            int r4 = r4.getStandardOffset()
            r5 = 0
            java.util.List<net.time4j.tz.model.DaylightSavingRule> r6 = r0.rules
            int r6 = r6.size()
        L_0x0024:
            if (r5 >= r6) goto L_0x0064
            java.util.List<net.time4j.tz.model.DaylightSavingRule> r7 = r0.rules
            java.lang.Object r7 = r7.get(r5)
            net.time4j.tz.model.DaylightSavingRule r7 = (net.time4j.tz.model.DaylightSavingRule) r7
            java.util.List<net.time4j.tz.model.DaylightSavingRule> r8 = r0.rules
            int r9 = r5 + -1
            int r9 = r9 + r6
            int r9 = r9 % r6
            java.lang.Object r8 = r8.get(r9)
            net.time4j.tz.model.DaylightSavingRule r8 = (net.time4j.tz.model.DaylightSavingRule) r8
            int r9 = r8.getSavings()
            int r9 = getShift(r7, r4, r9)
            net.time4j.tz.ZonalTransition r15 = new net.time4j.tz.ZonalTransition
            long r11 = getTransitionTime(r7, r1, r9)
            int r8 = r8.getSavings()
            int r13 = r4 + r8
            int r8 = r7.getSavings()
            int r14 = r4 + r8
            int r7 = r7.getSavings()
            r10 = r15
            r8 = r15
            r15 = r7
            r10.<init>(r11, r13, r14, r15)
            r3.add(r8)
            int r5 = r5 + 1
            goto L_0x0024
        L_0x0064:
            java.util.List r3 = java.util.Collections.unmodifiableList(r3)
            int r4 = LAST_CACHED_YEAR
            if (r1 > r4) goto L_0x007b
            boolean r1 = r0.gregorian
            if (r1 == 0) goto L_0x007b
            java.util.concurrent.ConcurrentMap<java.lang.Integer, java.util.List<net.time4j.tz.ZonalTransition>> r1 = r0.tCache
            java.lang.Object r1 = r1.putIfAbsent(r2, r3)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x007b
            r3 = r1
        L_0x007b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.tz.model.RuleBasedTransitionModel.getTransitions(int):java.util.List");
    }

    private static int getYear(DaylightSavingRule daylightSavingRule, long j) {
        return daylightSavingRule.toCalendarYear(EpochDays.MODIFIED_JULIAN_DATE.transform(MathUtils.floorDivide(j, 86400), EpochDays.UNIX));
    }

    private Object writeReplace() {
        return new SPX(this, 125);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }
}
