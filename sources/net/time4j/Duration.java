package net.time4j;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.IsoUnit;
import net.time4j.base.GregorianDate;
import net.time4j.base.MathUtils;
import net.time4j.base.WallTime;
import net.time4j.engine.AbstractDuration;
import net.time4j.engine.AbstractMetric;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoUnit;
import net.time4j.engine.Normalizer;
import net.time4j.engine.TimeMetric;
import net.time4j.engine.TimePoint;
import net.time4j.engine.TimeSpan;
import net.time4j.format.TimeSpanFormatter;
import net.time4j.tz.Timezone;
import org.apache.commons.lang3.ClassUtils;

public final class Duration<U extends IsoUnit> extends AbstractDuration<U> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CALENDAR_TYPE = 0;
    private static final Formatter<CalendarUnit> CF_BAS_CAL = createAlternativeDateFormat(false, false);
    private static final Formatter<CalendarUnit> CF_BAS_ORD = createAlternativeDateFormat(false, true);
    private static final Formatter<CalendarUnit> CF_EXT_CAL = createAlternativeDateFormat(true, false);
    private static final Formatter<CalendarUnit> CF_EXT_ORD = createAlternativeDateFormat(true, true);
    private static final TimeMetric<ClockUnit, Duration<ClockUnit>> CLOCK_METRIC = in((U[]) new ClockUnit[]{ClockUnit.HOURS, ClockUnit.MINUTES, ClockUnit.SECONDS, ClockUnit.NANOS});
    private static final int CLOCK_TYPE = 1;
    private static final char ISO_DECIMAL_SEPARATOR = (Boolean.getBoolean("net.time4j.format.iso.decimal.dot") ? ClassUtils.PACKAGE_SEPARATOR_CHAR : AbstractJsonLexerKt.COMMA);
    private static final Comparator<TimeSpan.Item<? extends ChronoUnit>> ITEM_COMPARATOR = StdNormalizer.comparator();
    private static final long MIO = 1000000;
    private static final long MRD = 1000000000;
    private static final int PRINT_STYLE_ISO = 1;
    private static final int PRINT_STYLE_NORMAL = 0;
    private static final int PRINT_STYLE_XML = 2;
    public static Normalizer<CalendarUnit> STD_CALENDAR_PERIOD = StdNormalizer.ofCalendarUnits();
    public static Normalizer<ClockUnit> STD_CLOCK_PERIOD = StdNormalizer.ofClockUnits();
    public static Normalizer<IsoUnit> STD_PERIOD = StdNormalizer.ofMixedUnits();
    private static final int SUPER_TYPE = -1;
    private static final Formatter<ClockUnit> TF_BAS = createAlternativeTimeFormat(false);
    private static final Formatter<ClockUnit> TF_EXT = createAlternativeTimeFormat(true);
    private static final TimeMetric<IsoDateUnit, Duration<IsoDateUnit>> WEEK_BASED_METRIC = in((U[]) new IsoDateUnit[]{CalendarUnit.weekBasedYears(), CalendarUnit.WEEKS, CalendarUnit.DAYS});
    private static final int WEEK_BASED_TYPE = 2;
    private static final TimeMetric<CalendarUnit, Duration<CalendarUnit>> YMD_METRIC = in((U[]) new CalendarUnit[]{CalendarUnit.YEARS, CalendarUnit.MONTHS, CalendarUnit.DAYS});
    private static final Duration ZERO = new Duration();
    private static final long serialVersionUID = -6321211763598951499L;
    private final transient List<TimeSpan.Item<U>> items;
    private final transient boolean negative;

    private static <T> T cast(Object obj) {
        return obj;
    }

    private static boolean hasMixedSigns(long j, long j2) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        return (i < 0 && j2 > 0) || (i > 0 && j2 < 0);
    }

    Duration(List<TimeSpan.Item<U>> list, boolean z) {
        boolean isEmpty = list.isEmpty();
        if (isEmpty) {
            this.items = Collections.emptyList();
        } else {
            Collections.sort(list, ITEM_COMPARATOR);
            this.items = Collections.unmodifiableList(list);
        }
        this.negative = !isEmpty && z;
    }

    private Duration(Duration<U> duration, boolean z) {
        this.items = duration.items;
        boolean z2 = duration.negative;
        this.negative = z ? !z2 : z2;
    }

    private Duration() {
        this.items = Collections.emptyList();
        this.negative = false;
    }

    public static <U extends IsoUnit> Duration<U> ofZero() {
        return ZERO;
    }

    public static <U extends IsoUnit> Duration<U> of(long j, U u) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return ofZero();
        }
        if (i < 0) {
            j = MathUtils.safeNegate(j);
        }
        if (u instanceof ClockUnit) {
            char symbol = u.getSymbol();
            if (symbol == '3') {
                u = (IsoUnit) cast(ClockUnit.NANOS);
                j = MathUtils.safeMultiply(j, 1000000);
            } else if (symbol == '6') {
                u = (IsoUnit) cast(ClockUnit.NANOS);
                j = MathUtils.safeMultiply(j, 1000);
            }
        }
        boolean z = true;
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(TimeSpan.Item.of(j, u));
        if (i >= 0) {
            z = false;
        }
        return new Duration<>(arrayList, z);
    }

    public static Builder ofPositive() {
        return new Builder(false);
    }

    public static Builder ofNegative() {
        return new Builder(true);
    }

    public static Duration<CalendarUnit> ofCalendarUnits(int i, int i2, int i3) {
        return ofCalendarUnits((long) i, (long) i2, (long) i3, false);
    }

    public static Duration<ClockUnit> ofClockUnits(int i, int i2, int i3) {
        return ofClockUnits((long) i, (long) i2, (long) i3, 0, false);
    }

    public static <U extends IsoUnit> TimeMetric<U, Duration<U>> in(U... uArr) {
        return new Metric((IsoUnit[]) uArr);
    }

    public static <U extends IsoUnit> TimeMetric<U, Duration<U>> in(Collection<? extends U> collection) {
        return new Metric((Collection) collection);
    }

    public static TimeMetric<CalendarUnit, Duration<CalendarUnit>> inYearsMonthsDays() {
        return YMD_METRIC;
    }

    public static TimeMetric<ClockUnit, Duration<ClockUnit>> inClockUnits() {
        return CLOCK_METRIC;
    }

    public static TimeMetric<IsoDateUnit, Duration<IsoDateUnit>> inWeekBasedUnits() {
        return WEEK_BASED_METRIC;
    }

    public static TimeMetric<IsoUnit, Duration<IsoUnit>> in(Timezone timezone, IsoUnit... isoUnitArr) {
        return new ZonalMetric(timezone, isoUnitArr);
    }

    public List<TimeSpan.Item<U>> getTotalLength() {
        return this.items;
    }

    public boolean isNegative() {
        return this.negative;
    }

    public boolean contains(IsoUnit isoUnit) {
        if (isoUnit == null) {
            return false;
        }
        boolean isFractionUnit = isFractionUnit(isoUnit);
        int size = this.items.size();
        int i = 0;
        while (i < size) {
            TimeSpan.Item item = this.items.get(i);
            IsoUnit isoUnit2 = (IsoUnit) item.getUnit();
            if (!isoUnit2.equals(isoUnit) && (!isFractionUnit || !isFractionUnit(isoUnit2))) {
                i++;
            } else if (item.getAmount() > 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public long getPartialAmount(IsoUnit isoUnit) {
        if (isoUnit == null) {
            return 0;
        }
        boolean isFractionUnit = isFractionUnit(isoUnit);
        int size = this.items.size();
        int i = 0;
        while (i < size) {
            TimeSpan.Item item = this.items.get(i);
            IsoUnit isoUnit2 = (IsoUnit) item.getUnit();
            if (isoUnit2.equals(isoUnit)) {
                return item.getAmount();
            }
            if (!isFractionUnit || !isFractionUnit(isoUnit2)) {
                i++;
            } else {
                int symbol = isoUnit2.getSymbol() - '0';
                int symbol2 = isoUnit.getSymbol() - '0';
                int i2 = 1;
                for (int i3 = 0; i3 < Math.abs(symbol - symbol2); i3++) {
                    i2 *= 10;
                }
                if (symbol >= symbol2) {
                    return item.getAmount() / ((long) i2);
                }
                return item.getAmount() * ((long) i2);
            }
        }
        return 0;
    }

    public static <U extends IsoUnit, T extends TimePoint<U, T>> Comparator<Duration<? extends U>> comparator(T t) {
        return new LengthComparator(t);
    }

    public static Comparator<Duration<ClockUnit>> comparatorOnClock() {
        return new Comparator<Duration<ClockUnit>>() {
            public int compare(Duration<ClockUnit> duration, Duration<ClockUnit> duration2) {
                int i = (Duration.lengthInSeconds(duration) > Duration.lengthInSeconds(duration2) ? 1 : (Duration.lengthInSeconds(duration) == Duration.lengthInSeconds(duration2) ? 0 : -1));
                if (i < 0) {
                    return -1;
                }
                if (i > 0) {
                    return 1;
                }
                long partialAmount = duration.getPartialAmount((ChronoUnit) ClockUnit.NANOS) % Duration.MRD;
                long partialAmount2 = duration2.getPartialAmount((ChronoUnit) ClockUnit.NANOS) % Duration.MRD;
                if (duration.isNegative()) {
                    partialAmount = MathUtils.safeNegate(partialAmount);
                }
                if (duration2.isNegative()) {
                    partialAmount2 = MathUtils.safeNegate(partialAmount2);
                }
                int i2 = (partialAmount > partialAmount2 ? 1 : (partialAmount == partialAmount2 ? 0 : -1));
                if (i2 < 0) {
                    return -1;
                }
                return i2 > 0 ? 1 : 0;
            }
        };
    }

    public Duration<U> plus(long j, U u) {
        long j2;
        boolean z;
        U u2;
        U u3 = u;
        Objects.requireNonNull(u3, "Missing chronological unit.");
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return this;
        }
        if (i < 0) {
            j2 = MathUtils.safeNegate(j);
            z = true;
        } else {
            j2 = j;
            z = false;
        }
        ArrayList arrayList = new ArrayList(getTotalLength());
        TimeSpan.Item replaceFraction = replaceFraction(j2, u3);
        if (replaceFraction != null) {
            j2 = replaceFraction.getAmount();
            u2 = (IsoUnit) replaceFraction.getUnit();
        } else {
            u2 = u3;
        }
        if (isEmpty()) {
            if (replaceFraction == null) {
                replaceFraction = TimeSpan.Item.of(j2, u2);
            }
            arrayList.add(replaceFraction);
            return new Duration<>(arrayList, z);
        }
        int index = getIndex(u2);
        boolean isNegative = isNegative();
        if (index >= 0) {
            long safeAdd = MathUtils.safeAdd(MathUtils.safeMultiply(((TimeSpan.Item) arrayList.get(index)).getAmount(), (long) (isNegative() ? -1 : 1)), MathUtils.safeMultiply(j2, (long) (z ? -1 : 1)));
            int i2 = (safeAdd > 0 ? 1 : (safeAdd == 0 ? 0 : -1));
            if (i2 == 0) {
                arrayList.remove(index);
            } else {
                if (count() != 1) {
                    if (isNegative() != (i2 < 0)) {
                        return plus(of(j, u));
                    }
                }
                if (i2 < 0) {
                    safeAdd = MathUtils.safeNegate(safeAdd);
                }
                arrayList.set(index, TimeSpan.Item.of(safeAdd, u2));
                isNegative = i2 < 0;
            }
        } else if (isNegative() != z) {
            return plus(of(j, u));
        } else {
            arrayList.add(TimeSpan.Item.of(j2, u2));
        }
        return new Duration<>(arrayList, isNegative);
    }

    public Duration<U> plus(TimeSpan<? extends U> timeSpan) {
        long j;
        long j2;
        long j3;
        TimeSpan<? extends U> timeSpan2 = timeSpan;
        Duration<U> merge = merge(this, timeSpan);
        if (merge != null) {
            return merge;
        }
        long[] jArr = {0, 0, 0, 0};
        if (summarize(this, jArr) && summarize(timeSpan2, jArr)) {
            boolean z = false;
            long j4 = jArr[0];
            long j5 = jArr[1];
            long j6 = jArr[2];
            long j7 = jArr[3];
            long j8 = 0;
            if (j7 != 0) {
                j = j5;
                j2 = j7;
            } else if (j6 != 0) {
                j = j5;
                j2 = j6;
            } else {
                j = j5;
                j2 = j;
            }
            if (!hasMixedSigns(j4, j2)) {
                if (j4 < 0 || j2 < 0) {
                    z = true;
                }
                if (z) {
                    j4 = MathUtils.safeNegate(j4);
                    j3 = MathUtils.safeNegate(j);
                    j6 = MathUtils.safeNegate(j6);
                    j7 = MathUtils.safeNegate(j7);
                } else {
                    j3 = j;
                }
                long j9 = j4 / 12;
                long j10 = j4 % 12;
                if (j7 != 0) {
                    j8 = j7 % MRD;
                    j6 = j7 / MRD;
                }
                long j11 = j6 / 3600;
                long j12 = j6 % 3600;
                HashMap hashMap = new HashMap();
                hashMap.put(CalendarUnit.YEARS, Long.valueOf(j9));
                hashMap.put(CalendarUnit.MONTHS, Long.valueOf(j10));
                hashMap.put(CalendarUnit.DAYS, Long.valueOf(j3));
                hashMap.put(ClockUnit.HOURS, Long.valueOf(j11));
                hashMap.put(ClockUnit.MINUTES, Long.valueOf(j12 / 60));
                hashMap.put(ClockUnit.SECONDS, Long.valueOf(j12 % 60));
                hashMap.put(ClockUnit.NANOS, Long.valueOf(j8));
                return create(hashMap, z);
            }
        }
        throw new IllegalStateException("Mixed signs in result time span not allowed: " + this + " PLUS " + timeSpan2);
    }

    public Duration<U> with(long j, U u) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            j = MathUtils.safeNegate(j);
        }
        TimeSpan.Item replaceFraction = replaceFraction(j, u);
        if (replaceFraction != null) {
            j = replaceFraction.getAmount();
            u = (IsoUnit) replaceFraction.getUnit();
        }
        long partialAmount = getPartialAmount((IsoUnit) u);
        long j2 = -1;
        long safeMultiply = MathUtils.safeMultiply(j, i < 0 ? -1 : 1);
        if (!isNegative()) {
            j2 = 1;
        }
        return plus(MathUtils.safeSubtract(safeMultiply, MathUtils.safeMultiply(partialAmount, j2)), u);
    }

    public Duration<U> abs() {
        return isNegative() ? inverse() : this;
    }

    public Duration<U> inverse() {
        return multipliedBy(-1);
    }

    public Duration<U> multipliedBy(int i) {
        if (!isEmpty()) {
            boolean z = true;
            if (i != 1) {
                if (i == 0) {
                    return ofZero();
                }
                if (i == -1) {
                    return new Duration<>(this, true);
                }
                ArrayList arrayList = new ArrayList(count());
                int abs = Math.abs(i);
                int count = count();
                for (int i2 = 0; i2 < count; i2++) {
                    TimeSpan.Item item = (TimeSpan.Item) getTotalLength().get(i2);
                    arrayList.add(TimeSpan.Item.of(MathUtils.safeMultiply(item.getAmount(), (long) abs), item.getUnit()));
                }
                if (i >= 0) {
                    z = isNegative();
                } else if (isNegative()) {
                    z = false;
                }
                return new Duration<>(arrayList, z);
            }
        }
        return this;
    }

    public List<Duration<U>> union(TimeSpan<? extends U> timeSpan) {
        Duration<? extends U> merge = merge(this, timeSpan);
        if (merge != null) {
            return Collections.singletonList(merge);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        arrayList.add(ofZero().plus(timeSpan));
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [net.time4j.Duration<net.time4j.ClockUnit>, net.time4j.engine.TimeSpan] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.time4j.Duration<net.time4j.IsoUnit> compose(net.time4j.Duration<net.time4j.CalendarUnit> r1, net.time4j.Duration<net.time4j.ClockUnit> r2) {
        /*
            net.time4j.Duration r0 = ofZero()
            net.time4j.Duration r1 = r0.plus(r1)
            net.time4j.Duration r1 = r1.plus(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.Duration.compose(net.time4j.Duration, net.time4j.Duration):net.time4j.Duration");
    }

    public Duration<CalendarUnit> toCalendarPeriod() {
        if (isEmpty()) {
            return ofZero();
        }
        ArrayList arrayList = new ArrayList();
        for (TimeSpan.Item next : this.items) {
            if (next.getUnit() instanceof CalendarUnit) {
                arrayList.add(TimeSpan.Item.of(next.getAmount(), CalendarUnit.class.cast(next.getUnit())));
            }
        }
        if (arrayList.isEmpty()) {
            return ofZero();
        }
        return new Duration<>(arrayList, isNegative());
    }

    public Duration<ClockUnit> toClockPeriod() {
        if (isEmpty()) {
            return ofZero();
        }
        ArrayList arrayList = new ArrayList();
        for (TimeSpan.Item next : this.items) {
            if (next.getUnit() instanceof ClockUnit) {
                arrayList.add(TimeSpan.Item.of(next.getAmount(), ClockUnit.class.cast(next.getUnit())));
            }
        }
        if (arrayList.isEmpty()) {
            return ofZero();
        }
        return new Duration<>(arrayList, isNegative());
    }

    public Duration<ClockUnit> toClockPeriodWithDaysAs24Hours() {
        if (isEmpty()) {
            return ofZero();
        }
        ArrayList arrayList = new ArrayList();
        long j = 0;
        for (TimeSpan.Item next : this.items) {
            if (next.getUnit() instanceof ClockUnit) {
                arrayList.add(TimeSpan.Item.of(next.getAmount(), ClockUnit.class.cast(next.getUnit())));
            } else if (((IsoUnit) next.getUnit()).equals(CalendarUnit.DAYS)) {
                j = MathUtils.safeMultiply(next.getAmount(), 24);
            }
        }
        if (j != 0) {
            int size = arrayList.size();
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                TimeSpan.Item item = (TimeSpan.Item) arrayList.get(i);
                if (item.getUnit() == ClockUnit.HOURS) {
                    arrayList.set(i, TimeSpan.Item.of(MathUtils.safeAdd(item.getAmount(), j), ClockUnit.HOURS));
                    z = true;
                    break;
                }
                i++;
            }
            if (!z) {
                arrayList.add(TimeSpan.Item.of(j, ClockUnit.HOURS));
            }
        } else if (arrayList.isEmpty()) {
            return ofZero();
        }
        return new Duration<>(arrayList, isNegative());
    }

    public Duration<U> with(Normalizer<U> normalizer) {
        return convert(normalizer.normalize(this));
    }

    public Duration<U> truncatedTo(U u) {
        if (isEmpty()) {
            return ofZero();
        }
        double length = u.getLength();
        ArrayList arrayList = new ArrayList();
        for (TimeSpan.Item next : this.items) {
            if (Double.compare(((IsoUnit) next.getUnit()).getLength(), length) < 0) {
                break;
            }
            arrayList.add(next);
        }
        if (arrayList.isEmpty()) {
            return ofZero();
        }
        return new Duration<>(arrayList, isNegative());
    }

    public static Normalizer<IsoUnit> approximateHours(int i) {
        return new ApproximateNormalizer(i, ClockUnit.HOURS);
    }

    public static Normalizer<IsoUnit> approximateMinutes(int i) {
        return new ApproximateNormalizer(i, ClockUnit.MINUTES);
    }

    public static Normalizer<IsoUnit> approximateSeconds(int i) {
        return new ApproximateNormalizer(i, ClockUnit.SECONDS);
    }

    public static Normalizer<IsoUnit> approximateMaxUnitOnly() {
        return new ApproximateNormalizer(false);
    }

    public static Normalizer<IsoUnit> approximateMaxUnitOrWeeks() {
        return new ApproximateNormalizer(true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Duration)) {
            return false;
        }
        Duration cast = Duration.class.cast(obj);
        if (this.negative != cast.negative || !getTotalLength().equals(cast.getTotalLength())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = getTotalLength().hashCode();
        return this.negative ? hashCode ^ hashCode : hashCode;
    }

    public String toString() {
        return toString(0);
    }

    public String toStringISO() {
        return toString(1);
    }

    public String toStringXML() {
        return toString(2);
    }

    public static Duration<IsoUnit> parsePeriod(String str) throws ParseException {
        return parsePeriod(str, IsoUnit.class);
    }

    public static Duration<CalendarUnit> parseCalendarPeriod(String str) throws ParseException {
        return parsePeriod(str, CalendarUnit.class);
    }

    public static Duration<ClockUnit> parseClockPeriod(String str) throws ParseException {
        return parsePeriod(str, ClockUnit.class);
    }

    public static Duration<IsoDateUnit> parseWeekBasedPeriod(String str) throws ParseException {
        return parsePeriod(str, IsoDateUnit.class);
    }

    public static Formatter<IsoUnit> formatter(String str) {
        return Formatter.ofPattern(str);
    }

    public static <U extends IsoUnit> Formatter<U> formatter(Class<U> cls, String str) {
        return Formatter.ofPattern(cls, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0111, code lost:
        r1 = r15;
     */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0171  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String toString(int r23) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = 1
            if (r1 != r2) goto L_0x0016
            boolean r3 = r22.isNegative()
            if (r3 != 0) goto L_0x000e
            goto L_0x0016
        L_0x000e:
            net.time4j.engine.ChronoException r1 = new net.time4j.engine.ChronoException
            java.lang.String r2 = "Negative sign not allowed in ISO-8601."
            r1.<init>(r2)
            throw r1
        L_0x0016:
            boolean r3 = r22.isEmpty()
            if (r3 == 0) goto L_0x001f
            java.lang.String r1 = "PT0S"
            return r1
        L_0x001f:
            r3 = 2
            if (r1 != r3) goto L_0x0024
            r3 = 1
            goto L_0x0025
        L_0x0024:
            r3 = 0
        L_0x0025:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            boolean r6 = r22.isNegative()
            if (r6 == 0) goto L_0x0035
            r6 = 45
            r5.append(r6)
        L_0x0035:
            r6 = 80
            r5.append(r6)
            int r6 = r22.count()
            r7 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r15 = 0
        L_0x0047:
            if (r9 >= r6) goto L_0x0180
            java.util.List r2 = r22.getTotalLength()
            java.lang.Object r2 = r2.get(r9)
            net.time4j.engine.TimeSpan$Item r2 = (net.time4j.engine.TimeSpan.Item) r2
            java.lang.Object r19 = r2.getUnit()
            r4 = r19
            net.time4j.IsoUnit r4 = (net.time4j.IsoUnit) r4
            if (r12 != 0) goto L_0x006c
            boolean r19 = r4.isCalendrical()
            if (r19 != 0) goto L_0x006c
            r12 = 84
            r5.append(r12)
            r20 = r13
            r14 = 1
            goto L_0x006f
        L_0x006c:
            r20 = r13
            r14 = r12
        L_0x006f:
            long r12 = r2.getAmount()
            char r2 = r4.getSymbol()
            r19 = r14
            net.time4j.Weekcycle r14 = net.time4j.Weekcycle.YEARS
            if (r4 != r14) goto L_0x0081
            r14 = 48
            r15 = 1
            goto L_0x0083
        L_0x0081:
            r14 = 48
        L_0x0083:
            if (r2 <= r14) goto L_0x008f
            r14 = 57
            if (r2 > r14) goto L_0x008f
            r10 = r12
            r1 = r15
        L_0x008b:
            r13 = r20
            goto L_0x0176
        L_0x008f:
            r14 = 83
            if (r2 != r14) goto L_0x0097
            r13 = r12
            r1 = r15
            goto L_0x0176
        L_0x0097:
            if (r3 != 0) goto L_0x00a3
            r14 = 1
            if (r1 != r14) goto L_0x009d
            goto L_0x00a3
        L_0x009d:
            r5.append(r12)
        L_0x00a0:
            r1 = r15
            goto L_0x0160
        L_0x00a3:
            r14 = 72
            r18 = 68
            r1 = 89
            if (r2 == r14) goto L_0x0115
            r14 = 73
            if (r2 == r14) goto L_0x0152
            r14 = 77
            if (r2 == r14) goto L_0x0115
            r14 = 81
            if (r2 == r14) goto L_0x0145
            r14 = 87
            if (r2 == r14) goto L_0x0117
            if (r2 == r1) goto L_0x0115
            switch(r2) {
                case 67: goto L_0x0107;
                case 68: goto L_0x00f6;
                case 69: goto L_0x00eb;
                default: goto L_0x00c0;
            }
        L_0x00c0:
            if (r3 == 0) goto L_0x00c5
            java.lang.String r1 = "XML"
            goto L_0x00c7
        L_0x00c5:
            java.lang.String r1 = "ISO"
        L_0x00c7:
            net.time4j.engine.ChronoException r2 = new net.time4j.engine.ChronoException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Special units cannot be output in "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = "-mode: "
            r3.append(r1)
            r14 = 0
            java.lang.String r1 = r0.toString(r14)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L_0x00eb:
            r14 = 0
            r1 = 10
            long r1 = net.time4j.base.MathUtils.safeMultiply((long) r12, (long) r1)
            r5.append(r1)
            goto L_0x0111
        L_0x00f6:
            r14 = 0
            r16 = 0
            int r1 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r1 == 0) goto L_0x0103
            long r12 = net.time4j.base.MathUtils.safeAdd((long) r12, (long) r7)
            r7 = 0
        L_0x0103:
            r5.append(r12)
            goto L_0x00a0
        L_0x0107:
            r14 = 0
            r1 = 100
            long r1 = net.time4j.base.MathUtils.safeMultiply((long) r12, (long) r1)
            r5.append(r1)
        L_0x0111:
            r1 = r15
        L_0x0112:
            r2 = 89
            goto L_0x0160
        L_0x0115:
            r1 = r15
            goto L_0x015d
        L_0x0117:
            r1 = r15
            r14 = 1
            if (r6 != r14) goto L_0x012d
            if (r3 == 0) goto L_0x0129
            r14 = 7
            long r12 = net.time4j.base.MathUtils.safeMultiply((long) r12, (long) r14)
            r5.append(r12)
            r2 = 68
            goto L_0x0160
        L_0x0129:
            r5.append(r12)
            goto L_0x0160
        L_0x012d:
            r14 = 7
            long r7 = net.time4j.base.MathUtils.safeMultiply((long) r12, (long) r14)
            net.time4j.CalendarUnit r2 = net.time4j.CalendarUnit.DAYS
            boolean r2 = r0.contains((net.time4j.IsoUnit) r2)
            if (r2 == 0) goto L_0x013d
            goto L_0x008b
        L_0x013d:
            r5.append(r7)
            r2 = 68
            r7 = 0
            goto L_0x0160
        L_0x0145:
            r1 = r15
            r14 = 3
            long r12 = net.time4j.base.MathUtils.safeMultiply((long) r12, (long) r14)
            r5.append(r12)
            r2 = 77
            goto L_0x0160
        L_0x0152:
            r1 = r15
            r14 = 1000(0x3e8, double:4.94E-321)
            long r12 = net.time4j.base.MathUtils.safeMultiply((long) r12, (long) r14)
            r5.append(r12)
            goto L_0x0112
        L_0x015d:
            r5.append(r12)
        L_0x0160:
            if (r2 != 0) goto L_0x0171
            r2 = 123(0x7b, float:1.72E-43)
            r5.append(r2)
            r5.append(r4)
            r2 = 125(0x7d, float:1.75E-43)
            r5.append(r2)
            goto L_0x008b
        L_0x0171:
            r5.append(r2)
            goto L_0x008b
        L_0x0176:
            int r9 = r9 + 1
            r15 = r1
            r12 = r19
            r2 = 1
            r1 = r23
            goto L_0x0047
        L_0x0180:
            r20 = r13
            r1 = 0
            int r4 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x01bf
            r1 = 1000000000(0x3b9aca00, double:4.94065646E-315)
            long r6 = r10 / r1
            r13 = r20
            long r6 = net.time4j.base.MathUtils.safeAdd((long) r13, (long) r6)
            r5.append(r6)
            if (r3 == 0) goto L_0x019b
            r3 = 46
            goto L_0x019d
        L_0x019b:
            char r3 = ISO_DECIMAL_SEPARATOR
        L_0x019d:
            r5.append(r3)
            long r10 = r10 % r1
            java.lang.String r1 = java.lang.String.valueOf(r10)
            int r2 = r1.length()
            int r2 = 9 - r2
            r3 = 0
        L_0x01ac:
            if (r3 >= r2) goto L_0x01b6
            r4 = 48
            r5.append(r4)
            int r3 = r3 + 1
            goto L_0x01ac
        L_0x01b6:
            r5.append(r1)
            r1 = 83
            r5.append(r1)
            goto L_0x01cf
        L_0x01bf:
            r13 = r20
            r1 = 83
            r2 = 0
            int r4 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x01cf
            r5.append(r13)
            r5.append(r1)
        L_0x01cf:
            if (r15 == 0) goto L_0x020b
            r1 = 1
            r1 = r1 ^ r12
            if (r1 == 0) goto L_0x01fb
            int r2 = r22.count()
            r3 = 0
        L_0x01da:
            if (r3 >= r2) goto L_0x01fb
            java.util.List r4 = r22.getTotalLength()
            java.lang.Object r4 = r4.get(r3)
            net.time4j.engine.TimeSpan$Item r4 = (net.time4j.engine.TimeSpan.Item) r4
            java.lang.Object r4 = r4.getUnit()
            net.time4j.Weekcycle r6 = net.time4j.Weekcycle.YEARS
            if (r4 == r6) goto L_0x01f8
            net.time4j.CalendarUnit r6 = net.time4j.CalendarUnit.WEEKS
            if (r4 == r6) goto L_0x01f8
            net.time4j.CalendarUnit r6 = net.time4j.CalendarUnit.DAYS
            if (r4 == r6) goto L_0x01f8
            r4 = 0
            goto L_0x01fc
        L_0x01f8:
            int r3 = r3 + 1
            goto L_0x01da
        L_0x01fb:
            r4 = r1
        L_0x01fc:
            if (r4 != 0) goto L_0x020b
            java.lang.String r1 = "Y"
            int r1 = r5.indexOf(r1)
            int r2 = r1 + 1
            java.lang.String r3 = "{WEEK_BASED_YEARS}"
            r5.replace(r1, r2, r3)
        L_0x020b:
            java.lang.String r1 = r5.toString()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.Duration.toString(int):java.lang.String");
    }

    private int count() {
        return getTotalLength().size();
    }

    private static <U> boolean isEmpty(TimeSpan<U> timeSpan) {
        List<TimeSpan.Item<U>> totalLength = timeSpan.getTotalLength();
        int size = totalLength.size();
        for (int i = 0; i < size; i++) {
            if (totalLength.get(i).getAmount() > 0) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static long lengthInSeconds(Duration<ClockUnit> duration) {
        long safeAdd = MathUtils.safeAdd(MathUtils.safeAdd(MathUtils.safeAdd(MathUtils.safeMultiply(duration.getPartialAmount((ChronoUnit) ClockUnit.HOURS), 3600), MathUtils.safeMultiply(duration.getPartialAmount((ChronoUnit) ClockUnit.MINUTES), 60)), duration.getPartialAmount((ChronoUnit) ClockUnit.SECONDS)), duration.getPartialAmount((ChronoUnit) ClockUnit.NANOS) / MRD);
        return duration.isNegative() ? MathUtils.safeNegate(safeAdd) : safeAdd;
    }

    private static Duration<CalendarUnit> ofCalendarUnits(long j, long j2, long j3, boolean z) {
        ArrayList arrayList = new ArrayList(3);
        if (j != 0) {
            arrayList.add(TimeSpan.Item.of(j, CalendarUnit.YEARS));
        }
        if (j2 != 0) {
            arrayList.add(TimeSpan.Item.of(j2, CalendarUnit.MONTHS));
        }
        if (j3 != 0) {
            arrayList.add(TimeSpan.Item.of(j3, CalendarUnit.DAYS));
        }
        return new Duration<>(arrayList, z);
    }

    private static Duration<ClockUnit> ofClockUnits(long j, long j2, long j3, long j4, boolean z) {
        ArrayList arrayList = new ArrayList(4);
        if (j != 0) {
            arrayList.add(TimeSpan.Item.of(j, ClockUnit.HOURS));
        }
        if (j2 != 0) {
            arrayList.add(TimeSpan.Item.of(j2, ClockUnit.MINUTES));
        }
        if (j3 != 0) {
            arrayList.add(TimeSpan.Item.of(j3, ClockUnit.SECONDS));
        }
        if (j4 != 0) {
            arrayList.add(TimeSpan.Item.of(j4, ClockUnit.NANOS));
        }
        return new Duration<>(arrayList, z);
    }

    /* access modifiers changed from: private */
    public static <U extends IsoUnit> Duration<U> create(Map<U, Long> map, boolean z) {
        if (map.isEmpty()) {
            return ofZero();
        }
        ArrayList arrayList = new ArrayList(map.size());
        long j = 0;
        for (Map.Entry next : map.entrySet()) {
            long longValue = ((Long) next.getValue()).longValue();
            if (longValue != 0) {
                IsoUnit isoUnit = (IsoUnit) next.getKey();
                if (isoUnit == ClockUnit.MILLIS) {
                    j = MathUtils.safeAdd(j, MathUtils.safeMultiply(longValue, 1000000));
                } else if (isoUnit == ClockUnit.MICROS) {
                    j = MathUtils.safeAdd(j, MathUtils.safeMultiply(longValue, 1000));
                } else if (isoUnit == ClockUnit.NANOS) {
                    j = MathUtils.safeAdd(j, longValue);
                } else {
                    arrayList.add(TimeSpan.Item.of(longValue, isoUnit));
                }
            }
        }
        if (j != 0) {
            arrayList.add(TimeSpan.Item.of(j, (IsoUnit) cast(ClockUnit.NANOS)));
        } else if (arrayList.isEmpty()) {
            return ofZero();
        }
        return new Duration<>(arrayList, z);
    }

    private int getIndex(ChronoUnit chronoUnit) {
        return getIndex(chronoUnit, getTotalLength());
    }

    private static <U extends ChronoUnit> int getIndex(ChronoUnit chronoUnit, List<TimeSpan.Item<U>> list) {
        int size = list.size() - 1;
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            int compare = StdNormalizer.compare((ChronoUnit) list.get(i2).getUnit(), chronoUnit);
            if (compare < 0) {
                i = i2 + 1;
            } else if (compare <= 0) {
                return i2;
            } else {
                size = i2 - 1;
            }
        }
        return -1;
    }

    private static <U extends IsoUnit> TimeSpan.Item<U> replaceFraction(long j, U u) {
        IsoUnit isoUnit;
        long j2;
        if (u.equals(ClockUnit.MILLIS)) {
            j2 = MathUtils.safeMultiply(j, 1000000);
            isoUnit = (IsoUnit) cast(ClockUnit.NANOS);
        } else if (!u.equals(ClockUnit.MICROS)) {
            return null;
        } else {
            j2 = MathUtils.safeMultiply(j, 1000);
            isoUnit = (IsoUnit) cast(ClockUnit.NANOS);
        }
        return TimeSpan.Item.of(j2, isoUnit);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v25, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: net.time4j.IsoUnit} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <U extends net.time4j.IsoUnit> net.time4j.Duration<U> merge(net.time4j.Duration<U> r16, net.time4j.engine.TimeSpan<? extends U> r17) {
        /*
            boolean r0 = r16.isEmpty()
            if (r0 == 0) goto L_0x001a
            boolean r0 = isEmpty(r17)
            if (r0 == 0) goto L_0x000d
            return r16
        L_0x000d:
            r0 = r17
            boolean r1 = r0 instanceof net.time4j.Duration
            if (r1 == 0) goto L_0x001c
            java.lang.Object r0 = cast(r17)
            net.time4j.Duration r0 = (net.time4j.Duration) r0
            return r0
        L_0x001a:
            r0 = r17
        L_0x001c:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            int r2 = r16.count()
            r3 = 0
            r4 = 0
        L_0x0027:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L_0x0054
            java.util.List r7 = r16.getTotalLength()
            java.lang.Object r7 = r7.get(r4)
            net.time4j.engine.TimeSpan$Item r7 = (net.time4j.engine.TimeSpan.Item) r7
            java.lang.Object r8 = r7.getUnit()
            long r9 = r7.getAmount()
            boolean r7 = r16.isNegative()
            if (r7 == 0) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            r5 = 1
        L_0x0045:
            long r5 = (long) r5
            long r5 = net.time4j.base.MathUtils.safeMultiply((long) r9, (long) r5)
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r1.put(r8, r5)
            int r4 = r4 + 1
            goto L_0x0027
        L_0x0054:
            boolean r2 = r17.isNegative()
            java.util.List r4 = r17.getTotalLength()
            int r4 = r4.size()
            r7 = 0
        L_0x0061:
            if (r7 >= r4) goto L_0x00c2
            java.util.List r8 = r17.getTotalLength()
            java.lang.Object r8 = r8.get(r7)
            net.time4j.engine.TimeSpan$Item r8 = (net.time4j.engine.TimeSpan.Item) r8
            java.lang.Object r9 = r8.getUnit()
            net.time4j.IsoUnit r9 = (net.time4j.IsoUnit) r9
            long r10 = r8.getAmount()
            net.time4j.engine.TimeSpan$Item r8 = replaceFraction(r10, r9)
            if (r8 == 0) goto L_0x0088
            long r10 = r8.getAmount()
            java.lang.Object r8 = r8.getUnit()
            r9 = r8
            net.time4j.IsoUnit r9 = (net.time4j.IsoUnit) r9
        L_0x0088:
            boolean r8 = r1.containsKey(r9)
            if (r8 == 0) goto L_0x00ae
            java.lang.Object r8 = r1.get(r9)
            java.lang.Long r8 = (java.lang.Long) r8
            long r12 = r8.longValue()
            if (r2 == 0) goto L_0x009c
            r8 = -1
            goto L_0x009d
        L_0x009c:
            r8 = 1
        L_0x009d:
            long r14 = (long) r8
            long r10 = net.time4j.base.MathUtils.safeMultiply((long) r10, (long) r14)
            long r10 = net.time4j.base.MathUtils.safeAdd((long) r12, (long) r10)
            java.lang.Long r8 = java.lang.Long.valueOf(r10)
            r1.put(r9, r8)
            goto L_0x00bf
        L_0x00ae:
            if (r2 == 0) goto L_0x00b2
            r8 = -1
            goto L_0x00b3
        L_0x00b2:
            r8 = 1
        L_0x00b3:
            long r12 = (long) r8
            long r10 = net.time4j.base.MathUtils.safeMultiply((long) r10, (long) r12)
            java.lang.Long r8 = java.lang.Long.valueOf(r10)
            r1.put(r9, r8)
        L_0x00bf:
            int r7 = r7 + 1
            goto L_0x0061
        L_0x00c2:
            boolean r0 = r16.isNegative()
            r4 = 0
            if (r0 != r2) goto L_0x00cb
            goto L_0x00fb
        L_0x00cb:
            java.util.Set r0 = r1.entrySet()
            java.util.Iterator r0 = r0.iterator()
            r2 = 0
            r7 = 1
        L_0x00d5:
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L_0x00fb
            java.lang.Object r8 = r0.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            java.lang.Object r8 = r8.getValue()
            java.lang.Long r8 = (java.lang.Long) r8
            long r8 = r8.longValue()
            int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r10 >= 0) goto L_0x00f1
            r8 = 1
            goto L_0x00f2
        L_0x00f1:
            r8 = 0
        L_0x00f2:
            if (r7 == 0) goto L_0x00f7
            r2 = r8
            r7 = 0
            goto L_0x00d5
        L_0x00f7:
            if (r2 == r8) goto L_0x00d5
            r0 = 0
            return r0
        L_0x00fb:
            if (r2 == 0) goto L_0x012f
            java.util.Set r0 = r1.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0105:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x012f
            java.lang.Object r3 = r0.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r6 = r3.getValue()
            java.lang.Long r6 = (java.lang.Long) r6
            long r6 = r6.longValue()
            java.lang.Object r3 = r3.getKey()
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 >= 0) goto L_0x0127
            long r6 = net.time4j.base.MathUtils.safeNegate((long) r6)
        L_0x0127:
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            r1.put(r3, r6)
            goto L_0x0105
        L_0x012f:
            net.time4j.Duration r0 = create(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.Duration.merge(net.time4j.Duration, net.time4j.engine.TimeSpan):net.time4j.Duration");
    }

    private static <U extends IsoUnit> boolean summarize(TimeSpan<? extends U> timeSpan, long[] jArr) {
        long j;
        long j2;
        long j3;
        long j4 = jArr[0];
        long j5 = jArr[1];
        long j6 = jArr[2];
        long j7 = jArr[3];
        for (TimeSpan.Item next : timeSpan.getTotalLength()) {
            IsoUnit isoUnit = (IsoUnit) next.getUnit();
            long amount = next.getAmount();
            if (timeSpan.isNegative()) {
                amount = MathUtils.safeNegate(amount);
            }
            long j8 = j6;
            long j9 = amount;
            if (isoUnit instanceof CalendarUnit) {
                CalendarUnit cast = CalendarUnit.class.cast(isoUnit);
                switch (AnonymousClass2.$SwitchMap$net$time4j$CalendarUnit[cast.ordinal()]) {
                    case 1:
                        j4 = MathUtils.safeAdd(j4, MathUtils.safeMultiply(j9, 12000));
                        break;
                    case 2:
                        j4 = MathUtils.safeAdd(j4, MathUtils.safeMultiply(j9, 1200));
                        break;
                    case 3:
                        j4 = MathUtils.safeAdd(j4, MathUtils.safeMultiply(j9, 120));
                        break;
                    case 4:
                        j4 = MathUtils.safeAdd(j4, MathUtils.safeMultiply(j9, 12));
                        break;
                    case 5:
                        j4 = MathUtils.safeAdd(j4, MathUtils.safeMultiply(j9, 3));
                        break;
                    case 6:
                        j4 = MathUtils.safeAdd(j4, j9);
                        break;
                    case 7:
                        j5 = MathUtils.safeAdd(j5, MathUtils.safeMultiply(j9, 7));
                        break;
                    case 8:
                        j5 = MathUtils.safeAdd(j5, j9);
                        break;
                    default:
                        throw new UnsupportedOperationException(cast.name());
                }
            } else if (!(isoUnit instanceof ClockUnit)) {
                return false;
            } else {
                ClockUnit cast2 = ClockUnit.class.cast(isoUnit);
                switch (AnonymousClass2.$SwitchMap$net$time4j$ClockUnit[cast2.ordinal()]) {
                    case 1:
                        j3 = j5;
                        j6 = MathUtils.safeAdd(j8, MathUtils.safeMultiply(j9, 3600));
                        continue;
                    case 2:
                        j3 = j5;
                        j6 = MathUtils.safeAdd(j8, MathUtils.safeMultiply(j9, 60));
                        continue;
                    case 3:
                        j6 = MathUtils.safeAdd(j8, j9);
                        break;
                    case 4:
                        j7 = MathUtils.safeAdd(j7, MathUtils.safeMultiply(j9, 1000000));
                        break;
                    case 5:
                        j7 = MathUtils.safeAdd(j7, MathUtils.safeMultiply(j9, 1000));
                        break;
                    case 6:
                        j7 = MathUtils.safeAdd(j7, j9);
                        break;
                    default:
                        throw new UnsupportedOperationException(cast2.name());
                }
            }
            j6 = j8;
            j3 = j5;
            j5 = j3;
        }
        long j10 = j5;
        long j11 = j6;
        long j12 = 0;
        if (j7 != 0) {
            j = j4;
            j7 = MathUtils.safeAdd(MathUtils.safeAdd(j7, MathUtils.safeMultiply(j10, 86400000000000L)), MathUtils.safeMultiply(j11, (long) MRD));
            j2 = 0;
        } else {
            j = j4;
            long j13 = j10;
            if (j11 != 0) {
                j2 = MathUtils.safeAdd(j11, MathUtils.safeMultiply(j13, 86400));
            } else {
                j12 = j13;
                j2 = j11;
            }
        }
        jArr[0] = j;
        jArr[1] = j12;
        jArr[2] = j2;
        jArr[3] = j7;
        return true;
    }

    /* renamed from: net.time4j.Duration$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$CalendarUnit;
        static final /* synthetic */ int[] $SwitchMap$net$time4j$ClockUnit;

        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|28|29|30|31|32|33|34|35|36|37|38|(3:39|40|42)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0097 */
        static {
            /*
                net.time4j.ClockUnit[] r0 = net.time4j.ClockUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$ClockUnit = r0
                r1 = 1
                net.time4j.ClockUnit r2 = net.time4j.ClockUnit.HOURS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$net$time4j$ClockUnit     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.ClockUnit r3 = net.time4j.ClockUnit.MINUTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$net$time4j$ClockUnit     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.ClockUnit r4 = net.time4j.ClockUnit.SECONDS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$net$time4j$ClockUnit     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.ClockUnit r5 = net.time4j.ClockUnit.MILLIS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = $SwitchMap$net$time4j$ClockUnit     // Catch:{ NoSuchFieldError -> 0x003e }
                net.time4j.ClockUnit r6 = net.time4j.ClockUnit.MICROS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = $SwitchMap$net$time4j$ClockUnit     // Catch:{ NoSuchFieldError -> 0x0049 }
                net.time4j.ClockUnit r7 = net.time4j.ClockUnit.NANOS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                net.time4j.CalendarUnit[] r6 = net.time4j.CalendarUnit.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                $SwitchMap$net$time4j$CalendarUnit = r6
                net.time4j.CalendarUnit r7 = net.time4j.CalendarUnit.MILLENNIA     // Catch:{ NoSuchFieldError -> 0x005a }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r6[r7] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r1 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x0064 }
                net.time4j.CalendarUnit r6 = net.time4j.CalendarUnit.CENTURIES     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r1[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x006e }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.DECADES     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x0078 }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.YEARS     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x0082 }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.QUARTERS     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x008c }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.MONTHS     // Catch:{ NoSuchFieldError -> 0x008c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x0097 }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.WEEKS     // Catch:{ NoSuchFieldError -> 0x0097 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0097 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0097 }
            L_0x0097:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x00a3 }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.DAYS     // Catch:{ NoSuchFieldError -> 0x00a3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a3 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a3 }
            L_0x00a3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.Duration.AnonymousClass2.<clinit>():void");
        }
    }

    private static <U extends IsoUnit> Duration<U> convert(TimeSpan<U> timeSpan) {
        if (timeSpan instanceof Duration) {
            return (Duration) cast(timeSpan);
        }
        return ofZero().plus(timeSpan);
    }

    private boolean isFractionUnit(IsoUnit isoUnit) {
        char symbol = isoUnit.getSymbol();
        return symbol >= '1' && symbol <= '9';
    }

    private static <U extends IsoUnit> Duration<U> parsePeriod(String str, Class<U> cls) throws ParseException {
        boolean z;
        int i;
        int i2;
        boolean z2;
        int i3 = 0;
        if (str.length() != 0) {
            if (str.charAt(0) == '-') {
                i = 1;
                z = true;
            } else {
                i = 0;
                z = false;
            }
            try {
                if (str.charAt(i) == 'P') {
                    int i4 = i + 1;
                    ArrayList arrayList = new ArrayList();
                    int indexOf = str.indexOf(84, i4);
                    boolean z3 = indexOf == -1;
                    if (cls == CalendarUnit.class) {
                        i2 = 0;
                    } else if (cls == ClockUnit.class) {
                        i2 = 1;
                    } else {
                        i2 = cls == IsoDateUnit.class ? 2 : -1;
                    }
                    if (!z3) {
                        if (indexOf <= i4) {
                            z2 = false;
                        } else if (i2 != 1) {
                            z2 = parse(str.substring(0, indexOf), i4, indexOf, 0, arrayList);
                        } else {
                            throw new ParseException("Unexpected date component found: " + str, i4);
                        }
                        if (cls == CalendarUnit.class) {
                            throw new ParseException("Unexpected time component found: " + str, indexOf);
                        } else if (z2) {
                            parseAlt(str, indexOf + 1, str.length(), false, arrayList);
                        } else {
                            parse(str, indexOf + 1, str.length(), 1, arrayList);
                        }
                    } else if (i2 != 1) {
                        int length = str.length();
                        if (i2 != -1) {
                            i3 = i2;
                        }
                        parse(str, i4, length, i3, arrayList);
                    } else {
                        throw new ParseException("Format symbol 'T' expected: " + str, i4);
                    }
                    return new Duration<>(arrayList, z);
                }
                throw new ParseException("Format symbol 'P' expected: " + str, i);
            } catch (IndexOutOfBoundsException e) {
                ParseException parseException = new ParseException("Unexpected termination of period string: " + str, i);
                parseException.initCause(e);
                throw parseException;
            }
        } else {
            throw new ParseException("Empty period string.", 0);
        }
    }

    private static <U extends ChronoUnit> boolean parse(String str, int i, int i2, int i3, List<TimeSpan.Item<U>> list) throws ParseException {
        int i4;
        int i5;
        ChronoUnit chronoUnit;
        String str2 = str;
        int i6 = i;
        int i7 = i2;
        int i8 = i3;
        char charAt = str2.charAt(i7 - 1);
        char c = '9';
        char c2 = '0';
        boolean z = false;
        if (charAt < '0' || charAt > '9' || i8 == 2) {
            List<TimeSpan.Item<U>> list2 = list;
            if (i6 != i7) {
                int i9 = i6;
                int i10 = i9;
                ChronoUnit chronoUnit2 = null;
                StringBuilder sb = null;
                boolean z2 = false;
                boolean z3 = false;
                while (i10 < i7) {
                    char charAt2 = str2.charAt(i10);
                    if (charAt2 >= c2 && charAt2 <= c) {
                        if (sb == null) {
                            sb = new StringBuilder();
                            i9 = i10;
                            z2 = false;
                        }
                        sb.append(charAt2);
                        i4 = i10;
                    } else if (charAt2 == ',' || charAt2 == '.') {
                        i4 = i10;
                        int i11 = i9;
                        if (sb == null || i8 != 1) {
                            throw new ParseException("Decimal separator misplaced: " + str2, i4);
                        }
                        chronoUnit2 = addParsedItem(ClockUnit.SECONDS, chronoUnit2, parseAmount(str2, sb.toString(), i11), str, i4, list);
                        i9 = i11;
                        sb = null;
                        z2 = true;
                        z3 = true;
                    } else if (!z2) {
                        if (!z3) {
                            i5 = i9;
                            i4 = i10;
                            long parseAmount = parseAmount(str2, sb == null ? String.valueOf(charAt2) : sb.toString(), i5);
                            if (i8 == 1) {
                                chronoUnit = parseTimeSymbol(charAt2, str2, i4);
                            } else if (i8 == 2) {
                                chronoUnit = parseWeekBasedSymbol(charAt2, str2, i4);
                            } else {
                                chronoUnit = parseDateSymbol(charAt2, str2, i4);
                            }
                            chronoUnit2 = addParsedItem(chronoUnit, chronoUnit2, parseAmount, str, i4, list);
                        } else if (charAt2 != 'S') {
                            throw new ParseException("Second symbol expected: " + str2, i10);
                        } else if (sb != null) {
                            if (sb.length() > 9) {
                                sb.delete(9, sb.length());
                            }
                            for (int length = sb.length(); length < 9; length++) {
                                sb.append(c2);
                            }
                            i5 = i9;
                            i4 = i10;
                            chronoUnit2 = addParsedItem(ClockUnit.NANOS, chronoUnit2, parseAmount(str2, sb.toString(), i9), str, i10, list);
                        } else {
                            throw new ParseException("Decimal separator misplaced: " + str2, i10 - 1);
                        }
                        i9 = i5;
                        sb = null;
                        z2 = true;
                    } else {
                        throw new ParseException("Unexpected char '" + charAt2 + "' found: " + str2, i10);
                    }
                    i10 = i4 + 1;
                    c = '9';
                    c2 = '0';
                }
                if (z2) {
                    return false;
                }
                throw new ParseException("Unit symbol expected: " + str2, i7);
            }
            throw new ParseException(str2, i6);
        }
        List<TimeSpan.Item<U>> list3 = list;
        if (i8 == 0) {
            z = true;
        }
        parseAlt(str2, i6, i7, z, list3);
        return true;
    }

    private static <U extends ChronoUnit> void parseAlt(String str, int i, int i2, boolean z, List<TimeSpan.Item<U>> list) throws ParseException {
        long j;
        long j2;
        String str2 = str;
        int i3 = i;
        int i4 = i2;
        List<TimeSpan.Item<U>> list2 = list;
        int i5 = 2;
        boolean z2 = true;
        if (z) {
            int i6 = i3 + 4;
            boolean z3 = i6 < i4 && str2.charAt(i6) == '-';
            if (!z3 ? i3 + 7 != i4 : i3 + 8 != i4) {
                z2 = false;
            }
            Duration duration = (Duration) getAlternativeDateFormat(z3, z2).parse(str2, i3);
            long partialAmount = duration.getPartialAmount((IsoUnit) CalendarUnit.YEARS);
            if (z2) {
                j2 = duration.getPartialAmount((IsoUnit) CalendarUnit.DAYS);
                j = 0;
            } else {
                j = duration.getPartialAmount((IsoUnit) CalendarUnit.MONTHS);
                long partialAmount2 = duration.getPartialAmount((IsoUnit) CalendarUnit.DAYS);
                if (j > 12) {
                    throw new ParseException("ISO-8601 prohibits months-part > 12: " + str2, i6 + (z3 ? 1 : 0));
                } else if (partialAmount2 > 30) {
                    String str3 = "ISO-8601 prohibits days-part > 30: " + str2;
                    int i7 = i3 + 6;
                    if (!z3) {
                        i5 = 0;
                    }
                    throw new ParseException(str3, i7 + i5);
                } else {
                    j2 = partialAmount2;
                }
            }
            if (partialAmount > 0) {
                list2.add(TimeSpan.Item.of(partialAmount, (ChronoUnit) cast(CalendarUnit.YEARS)));
            }
            if (j > 0) {
                list2.add(TimeSpan.Item.of(j, (ChronoUnit) cast(CalendarUnit.MONTHS)));
            }
            if (j2 > 0) {
                list2.add(TimeSpan.Item.of(j2, (ChronoUnit) cast(CalendarUnit.DAYS)));
                return;
            }
            return;
        }
        int i8 = i3 + 2;
        if (i8 >= i4 || str2.charAt(i8) != ':') {
            z2 = false;
        }
        Duration duration2 = (Duration) getAlternativeTimeFormat(z2).parse(str2, i3);
        long partialAmount3 = duration2.getPartialAmount((IsoUnit) ClockUnit.HOURS);
        if (partialAmount3 > 0) {
            if (partialAmount3 <= 24) {
                list2.add(TimeSpan.Item.of(partialAmount3, (ChronoUnit) cast(ClockUnit.HOURS)));
            } else {
                throw new ParseException("ISO-8601 prohibits hours-part > 24: " + str2, i3);
            }
        }
        long partialAmount4 = duration2.getPartialAmount((IsoUnit) ClockUnit.MINUTES);
        if (partialAmount4 > 0) {
            if (partialAmount4 > 60) {
                throw new ParseException("ISO-8601 prohibits minutes-part > 60: " + str2, i8 + (z2 ? 1 : 0));
            }
            list2.add(TimeSpan.Item.of(partialAmount4, (ChronoUnit) cast(ClockUnit.MINUTES)));
        }
        long partialAmount5 = duration2.getPartialAmount((IsoUnit) ClockUnit.SECONDS);
        if (partialAmount5 > 0) {
            if (partialAmount5 > 60) {
                String str4 = "ISO-8601 prohibits seconds-part > 60: " + str2;
                int i9 = i3 + 4;
                if (!z2) {
                    i5 = 0;
                }
                throw new ParseException(str4, i9 + i5);
            }
            list2.add(TimeSpan.Item.of(partialAmount5, (ChronoUnit) cast(ClockUnit.SECONDS)));
        }
        long partialAmount6 = duration2.getPartialAmount((IsoUnit) ClockUnit.NANOS);
        if (partialAmount6 > 0) {
            list2.add(TimeSpan.Item.of(partialAmount6, (ChronoUnit) cast(ClockUnit.NANOS)));
        }
    }

    private static Formatter<CalendarUnit> createAlternativeDateFormat(boolean z, boolean z2) {
        return Formatter.ofPattern(CalendarUnit.class, z ? z2 ? "YYYY-DDD" : "YYYY-MM-DD" : z2 ? "YYYYDDD" : "YYYYMMDD");
    }

    private static Formatter<CalendarUnit> getAlternativeDateFormat(boolean z, boolean z2) {
        return z ? z2 ? CF_EXT_ORD : CF_EXT_CAL : z2 ? CF_BAS_ORD : CF_BAS_CAL;
    }

    private static Formatter<ClockUnit> createAlternativeTimeFormat(boolean z) {
        return Formatter.ofPattern(ClockUnit.class, z ? "hh[:mm[:ss[,fffffffff]]]" : "hh[mm[ss[,fffffffff]]]");
    }

    private static Formatter<ClockUnit> getAlternativeTimeFormat(boolean z) {
        return z ? TF_EXT : TF_BAS;
    }

    private static CalendarUnit parseDateSymbol(char c, String str, int i) throws ParseException {
        if (c == 'I') {
            return CalendarUnit.MILLENNIA;
        }
        if (c == 'M') {
            return CalendarUnit.MONTHS;
        }
        if (c == 'Q') {
            return CalendarUnit.QUARTERS;
        }
        if (c == 'W') {
            return CalendarUnit.WEEKS;
        }
        if (c == 'Y') {
            return CalendarUnit.YEARS;
        }
        switch (c) {
            case 'C':
                return CalendarUnit.CENTURIES;
            case 'D':
                return CalendarUnit.DAYS;
            case 'E':
                return CalendarUnit.DECADES;
            default:
                throw new ParseException("Symbol '" + c + "' not supported: " + str, i);
        }
    }

    private static ClockUnit parseTimeSymbol(char c, String str, int i) throws ParseException {
        if (c == 'H') {
            return ClockUnit.HOURS;
        }
        if (c == 'M') {
            return ClockUnit.MINUTES;
        }
        if (c == 'S') {
            return ClockUnit.SECONDS;
        }
        throw new ParseException("Symbol '" + c + "' not supported: " + str, i);
    }

    private static IsoDateUnit parseWeekBasedSymbol(char c, String str, int i) throws ParseException {
        if (c == 'D') {
            return CalendarUnit.DAYS;
        }
        if (c == 'W') {
            return CalendarUnit.WEEKS;
        }
        if (c == 'Y') {
            return CalendarUnit.weekBasedYears();
        }
        throw new ParseException("Symbol '" + c + "' not supported: " + str, i);
    }

    private static <U extends ChronoUnit> ChronoUnit addParsedItem(ChronoUnit chronoUnit, ChronoUnit chronoUnit2, long j, String str, int i, List<TimeSpan.Item<U>> list) throws ParseException {
        if (chronoUnit2 == null || Double.compare(chronoUnit.getLength(), chronoUnit2.getLength()) < 0) {
            if (j != 0) {
                list.add(TimeSpan.Item.of(j, (ChronoUnit) cast(chronoUnit)));
            }
            return chronoUnit;
        } else if (Double.compare(chronoUnit.getLength(), chronoUnit2.getLength()) == 0) {
            throw new ParseException("Duplicate unit items: " + str, i);
        } else {
            throw new ParseException("Wrong order of unit items: " + str, i);
        }
    }

    private static long parseAmount(String str, String str2, int i) throws ParseException {
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException e) {
            ParseException parseException = new ParseException(str, i);
            parseException.initCause(e);
            throw parseException;
        }
    }

    private Object writeReplace() {
        return new SPX(this, 6);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    public static class Builder {
        private final List<TimeSpan.Item<IsoUnit>> items = new ArrayList(10);
        private boolean microsSet = false;
        private boolean millisSet = false;
        private boolean nanosSet = false;
        private final boolean negative;

        Builder(boolean z) {
            this.negative = z;
        }

        public Builder years(int i) {
            set((long) i, CalendarUnit.YEARS);
            return this;
        }

        public Builder months(int i) {
            set((long) i, CalendarUnit.MONTHS);
            return this;
        }

        public Builder days(int i) {
            set((long) i, CalendarUnit.DAYS);
            return this;
        }

        public Builder hours(int i) {
            set((long) i, ClockUnit.HOURS);
            return this;
        }

        public Builder minutes(int i) {
            set((long) i, ClockUnit.MINUTES);
            return this;
        }

        public Builder seconds(int i) {
            set((long) i, ClockUnit.SECONDS);
            return this;
        }

        public Builder millis(int i) {
            millisCalled();
            update((long) i, 1000000);
            return this;
        }

        public Builder micros(int i) {
            microsCalled();
            update((long) i, 1000);
            return this;
        }

        public Builder nanos(int i) {
            nanosCalled();
            update((long) i, 1);
            return this;
        }

        public Duration<IsoUnit> build() {
            if (!this.items.isEmpty()) {
                return new Duration<>(this.items, this.negative);
            }
            throw new IllegalStateException("Not set any amount and unit.");
        }

        private Builder set(long j, IsoUnit isoUnit) {
            int size = this.items.size();
            int i = 0;
            while (i < size) {
                if (this.items.get(i).getUnit() != isoUnit) {
                    i++;
                } else {
                    throw new IllegalStateException("Already registered: " + isoUnit);
                }
            }
            if (j != 0) {
                this.items.add(TimeSpan.Item.of(j, isoUnit));
            }
            return this;
        }

        private void update(long j, long j2) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i >= 0) {
                ClockUnit clockUnit = ClockUnit.NANOS;
                for (int size = this.items.size() - 1; size >= 0; size--) {
                    TimeSpan.Item item = this.items.get(size);
                    if (((IsoUnit) item.getUnit()).equals(ClockUnit.NANOS)) {
                        this.items.set(size, TimeSpan.Item.of(MathUtils.safeAdd(MathUtils.safeMultiply(j, j2), item.getAmount()), clockUnit));
                        return;
                    }
                }
                if (i != 0) {
                    this.items.add(TimeSpan.Item.of(MathUtils.safeMultiply(j, j2), clockUnit));
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Illegal negative amount: " + j);
        }

        private void millisCalled() {
            if (!this.millisSet) {
                this.millisSet = true;
                return;
            }
            throw new IllegalStateException("Called twice for: " + ClockUnit.MILLIS.name());
        }

        private void microsCalled() {
            if (!this.microsSet) {
                this.microsSet = true;
                return;
            }
            throw new IllegalStateException("Called twice for: " + ClockUnit.MICROS.name());
        }

        private void nanosCalled() {
            if (!this.nanosSet) {
                this.nanosSet = true;
                return;
            }
            throw new IllegalStateException("Called twice for: " + ClockUnit.NANOS.name());
        }
    }

    private static class ZonalMetric implements TimeMetric<IsoUnit, Duration<IsoUnit>> {
        private final TimeMetric<IsoUnit, Duration<IsoUnit>> metric;
        private final Timezone tz;

        private ZonalMetric(Timezone timezone, IsoUnit... isoUnitArr) {
            Objects.requireNonNull(timezone, "Missing timezone.");
            this.tz = timezone;
            this.metric = new Metric(isoUnitArr);
        }

        public <T extends TimePoint<? super IsoUnit, T>> Duration<IsoUnit> between(T t, T t2) {
            boolean z;
            if (t.compareTo(t2) > 0) {
                z = true;
                T t3 = t2;
                t2 = t;
                t = t3;
            } else {
                z = false;
            }
            Duration<IsoUnit> between = this.metric.between(t, t2.plus((long) (getOffset(t) - getOffset(t2)), ClockUnit.SECONDS));
            return z ? between.inverse() : between;
        }

        public TimeMetric<IsoUnit, Duration<IsoUnit>> reversible() {
            throw new UnsupportedOperationException("Not reversible.");
        }

        private int getOffset(ChronoEntity<?> chronoEntity) {
            return this.tz.getStrategy().getOffset((GregorianDate) chronoEntity.get((ChronoElement<V>) PlainDate.COMPONENT), (WallTime) chronoEntity.get((ChronoElement<V>) PlainTime.COMPONENT), this.tz).getIntegralAmount();
        }
    }

    public static final class Formatter<U extends IsoUnit> extends TimeSpanFormatter<U, Duration<U>> {
        private static final String JODA_PATTERN = "'P'[-#################Y'Y'][-#################M'M'][-#################W'W'][-#################D'D']['T'[-#################h'H'][-#################m'M'][-#################s'S'[.fffffffff]]]";

        private Formatter(Class<U> cls, String str) {
            super(cls, str);
        }

        public static Formatter<IsoUnit> ofJodaStyle() {
            return ofPattern(IsoUnit.class, JODA_PATTERN);
        }

        public static Formatter<IsoUnit> ofPattern(String str) {
            return ofPattern(IsoUnit.class, str);
        }

        public static <U extends IsoUnit> Formatter<U> ofPattern(Class<U> cls, String str) {
            return new Formatter<>(cls, str);
        }

        /* access modifiers changed from: protected */
        public Duration<U> convert(Map<U, Long> map, boolean z) {
            return Duration.create(map, z);
        }

        /* access modifiers changed from: protected */
        public U getUnit(char c) {
            if (c == 'I') {
                return CalendarUnit.MILLENNIA;
            }
            if (c == 'M') {
                return CalendarUnit.MONTHS;
            }
            if (c == 'Q') {
                return CalendarUnit.QUARTERS;
            }
            if (c == 'W') {
                return CalendarUnit.WEEKS;
            }
            if (c == 'Y') {
                return CalendarUnit.YEARS;
            }
            if (c == 'f') {
                return ClockUnit.NANOS;
            }
            if (c == 'h') {
                return ClockUnit.HOURS;
            }
            if (c == 'm') {
                return ClockUnit.MINUTES;
            }
            if (c == 's') {
                return ClockUnit.SECONDS;
            }
            switch (c) {
                case 'C':
                    return CalendarUnit.CENTURIES;
                case 'D':
                    return CalendarUnit.DAYS;
                case 'E':
                    return CalendarUnit.DECADES;
                default:
                    throw new IllegalArgumentException("Unsupported pattern symbol: " + c);
            }
        }
    }

    private static class Metric<U extends IsoUnit> extends AbstractMetric<U, Duration<U>> {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private Metric(U... uArr) {
            super(uArr.length <= 1 ? false : true, uArr);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private Metric(Collection<? extends U> collection) {
            super(collection.size() <= 1 ? false : true, collection);
        }

        /* access modifiers changed from: protected */
        public Duration<U> createEmptyTimeSpan() {
            return Duration.ofZero();
        }

        /* access modifiers changed from: protected */
        public Duration<U> createTimeSpan(List<TimeSpan.Item<U>> list, boolean z) {
            return new Duration<>(list, z);
        }

        /* access modifiers changed from: protected */
        public TimeSpan.Item<U> resolve(TimeSpan.Item<U> item) {
            IsoUnit isoUnit = (IsoUnit) item.getUnit();
            if (isoUnit.equals(ClockUnit.MILLIS)) {
                return TimeSpan.Item.of(MathUtils.safeMultiply(item.getAmount(), 1000000), ClockUnit.NANOS);
            }
            return isoUnit.equals(ClockUnit.MICROS) ? TimeSpan.Item.of(MathUtils.safeMultiply(item.getAmount(), 1000), ClockUnit.NANOS) : item;
        }
    }

    private static class LengthComparator<U extends IsoUnit, T extends TimePoint<U, T>> implements Comparator<Duration<? extends U>> {
        private final T base;

        private LengthComparator(T t) {
            Objects.requireNonNull(t, "Missing base time point.");
            this.base = t;
        }

        public int compare(Duration<? extends U> duration, Duration<? extends U> duration2) {
            boolean isNegative = duration.isNegative();
            boolean isNegative2 = duration2.isNegative();
            if (isNegative && !isNegative2) {
                return -1;
            }
            if (!isNegative && isNegative2) {
                return 1;
            }
            if (!duration.isEmpty() || !duration2.isEmpty()) {
                return this.base.plus(duration).compareTo(this.base.plus(duration2));
            }
            return 0;
        }
    }

    private static class ApproximateNormalizer implements Normalizer<IsoUnit> {
        private final boolean daysToWeeks;
        private final int steps;
        private final ClockUnit unit;

        ApproximateNormalizer(boolean z) {
            this.daysToWeeks = z;
            this.steps = 1;
            this.unit = null;
        }

        ApproximateNormalizer(int i, ClockUnit clockUnit) {
            if (i < 1) {
                throw new IllegalArgumentException("Step width is not positive: " + i);
            } else if (clockUnit.compareTo(ClockUnit.SECONDS) <= 0) {
                this.daysToWeeks = false;
                this.steps = i;
                this.unit = clockUnit;
            } else {
                throw new IllegalArgumentException("Unsupported unit.");
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:40:0x015a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.Duration<net.time4j.IsoUnit> normalize(net.time4j.engine.TimeSpan<? extends net.time4j.IsoUnit> r14) {
            /*
                r13 = this;
                java.util.List r0 = r14.getTotalLength()
                int r0 = r0.size()
                r1 = 1
                r2 = 0
                r3 = 0
                r5 = 0
            L_0x000d:
                if (r5 >= r0) goto L_0x0039
                java.util.List r6 = r14.getTotalLength()
                java.lang.Object r6 = r6.get(r5)
                net.time4j.engine.TimeSpan$Item r6 = (net.time4j.engine.TimeSpan.Item) r6
                long r7 = r6.getAmount()
                double r7 = (double) r7
                java.lang.Object r9 = r6.getUnit()
                net.time4j.IsoUnit r9 = (net.time4j.IsoUnit) r9
                double r9 = r9.getLength()
                double r7 = r7 * r9
                double r3 = r3 + r7
                long r6 = r6.getAmount()
                r8 = 0
                int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r10 <= 0) goto L_0x0036
                r1 = 0
            L_0x0036:
                int r5 = r5 + 1
                goto L_0x000d
            L_0x0039:
                if (r1 == 0) goto L_0x0040
                net.time4j.Duration r14 = net.time4j.Duration.ofZero()
                return r14
            L_0x0040:
                net.time4j.ClockUnit r0 = r13.unit
                if (r0 != 0) goto L_0x0048
                net.time4j.IsoUnit r0 = maxUnit(r3)
            L_0x0048:
                double r0 = r0.getLength()
                int r5 = r13.steps
                double r5 = (double) r5
                double r0 = r0 * r5
                r5 = 4611686018427387904(0x4000000000000000, double:2.0)
                double r5 = r0 / r5
                double r3 = r3 + r5
                long r3 = (long) r3
                double r0 = java.lang.Math.floor(r0)
                int r0 = (int) r0
                long r3 = net.time4j.base.MathUtils.floorDivide((long) r3, (int) r0)
                long r0 = (long) r0
                long r3 = r3 * r0
                double r0 = (double) r3
                net.time4j.CalendarUnit r3 = net.time4j.CalendarUnit.YEARS
                double r3 = r3.getLength()
                double r3 = r0 / r3
                int r3 = safeCast(r3)
                double r4 = (double) r3
                net.time4j.CalendarUnit r6 = net.time4j.CalendarUnit.YEARS
                double r6 = r6.getLength()
                double r4 = r4 * r6
                double r0 = r0 - r4
                long r0 = (long) r0
                double r0 = (double) r0
                net.time4j.CalendarUnit r4 = net.time4j.CalendarUnit.MONTHS
                double r4 = r4.getLength()
                double r4 = r0 / r4
                int r4 = safeCast(r4)
                double r5 = (double) r4
                net.time4j.CalendarUnit r7 = net.time4j.CalendarUnit.MONTHS
                double r7 = r7.getLength()
                double r5 = r5 * r7
                double r0 = r0 - r5
                long r0 = (long) r0
                double r0 = (double) r0
                net.time4j.CalendarUnit r5 = net.time4j.CalendarUnit.WEEKS
                double r5 = r5.getLength()
                double r5 = r0 / r5
                int r5 = safeCast(r5)
                double r6 = (double) r5
                net.time4j.CalendarUnit r8 = net.time4j.CalendarUnit.WEEKS
                double r8 = r8.getLength()
                double r6 = r6 * r8
                double r0 = r0 - r6
                long r0 = (long) r0
                double r0 = (double) r0
                net.time4j.CalendarUnit r6 = net.time4j.CalendarUnit.DAYS
                double r6 = r6.getLength()
                double r6 = r0 / r6
                int r6 = safeCast(r6)
                double r7 = (double) r6
                net.time4j.CalendarUnit r9 = net.time4j.CalendarUnit.DAYS
                double r9 = r9.getLength()
                double r7 = r7 * r9
                double r0 = r0 - r7
                long r0 = (long) r0
                double r0 = (double) r0
                net.time4j.ClockUnit r7 = net.time4j.ClockUnit.HOURS
                double r7 = r7.getLength()
                double r7 = r0 / r7
                int r7 = safeCast(r7)
                net.time4j.ClockUnit r8 = net.time4j.ClockUnit.HOURS
                net.time4j.ClockUnit r9 = r13.unit
                boolean r8 = r8.equals(r9)
                if (r8 == 0) goto L_0x00e2
                int r0 = r13.steps
                int r7 = r7 / r0
                int r7 = r7 * r0
                r0 = 0
                r8 = 0
                goto L_0x0127
            L_0x00e2:
                double r8 = (double) r7
                net.time4j.ClockUnit r10 = net.time4j.ClockUnit.HOURS
                double r10 = r10.getLength()
                double r8 = r8 * r10
                double r0 = r0 - r8
                long r0 = (long) r0
                double r0 = (double) r0
                net.time4j.ClockUnit r8 = net.time4j.ClockUnit.MINUTES
                double r8 = r8.getLength()
                double r8 = r0 / r8
                int r8 = safeCast(r8)
                net.time4j.ClockUnit r9 = net.time4j.ClockUnit.MINUTES
                net.time4j.ClockUnit r10 = r13.unit
                boolean r9 = r9.equals(r10)
                if (r9 == 0) goto L_0x010b
                int r0 = r13.steps
                int r8 = r8 / r0
                int r8 = r8 * r0
                r0 = 0
                goto L_0x0127
            L_0x010b:
                double r9 = (double) r8
                net.time4j.ClockUnit r11 = net.time4j.ClockUnit.MINUTES
                double r11 = r11.getLength()
                double r9 = r9 * r11
                double r0 = r0 - r9
                long r0 = (long) r0
                double r0 = (double) r0
                net.time4j.ClockUnit r9 = net.time4j.ClockUnit.SECONDS
                double r9 = r9.getLength()
                double r0 = r0 / r9
                int r0 = safeCast(r0)
                int r1 = r13.steps
                int r0 = r0 / r1
                int r0 = r0 * r1
            L_0x0127:
                r1 = 7
                int r5 = r5 * 7
                int r6 = r6 + r5
                net.time4j.ClockUnit r5 = r13.unit
                if (r5 != 0) goto L_0x016b
                if (r3 <= 0) goto L_0x0137
                r0 = 0
                r4 = 0
            L_0x0133:
                r6 = 0
            L_0x0134:
                r7 = 0
            L_0x0135:
                r8 = 0
                goto L_0x0158
            L_0x0137:
                if (r4 <= 0) goto L_0x013b
                r0 = 0
                goto L_0x0133
            L_0x013b:
                if (r6 <= 0) goto L_0x0151
                if (r6 < r1) goto L_0x014d
                boolean r0 = r13.daysToWeeks
                if (r0 == 0) goto L_0x014d
                double r0 = (double) r6
                r5 = 4615063718147915776(0x400c000000000000, double:3.5)
                double r0 = r0 + r5
                r5 = 4619567317775286272(0x401c000000000000, double:7.0)
                double r0 = r0 / r5
                int r0 = (int) r0
                r6 = 0
                goto L_0x014e
            L_0x014d:
                r0 = 0
            L_0x014e:
                r2 = r0
                r0 = 0
                goto L_0x0134
            L_0x0151:
                if (r7 <= 0) goto L_0x0155
                r0 = 0
                goto L_0x0135
            L_0x0155:
                if (r8 <= 0) goto L_0x0158
                r0 = 0
            L_0x0158:
                if (r2 <= 0) goto L_0x016b
                net.time4j.CalendarUnit r0 = net.time4j.CalendarUnit.WEEKS
                boolean r14 = r14.isNegative()
                if (r14 == 0) goto L_0x0165
                int r14 = -r2
                long r1 = (long) r14
                goto L_0x0166
            L_0x0165:
                long r1 = (long) r2
            L_0x0166:
                net.time4j.Duration r14 = net.time4j.Duration.of(r1, r0)
                return r14
            L_0x016b:
                net.time4j.Duration$Builder r1 = net.time4j.Duration.ofPositive()
                net.time4j.Duration$Builder r1 = r1.years(r3)
                net.time4j.Duration$Builder r1 = r1.months(r4)
                net.time4j.Duration$Builder r1 = r1.days(r6)
                net.time4j.Duration$Builder r1 = r1.hours(r7)
                net.time4j.Duration$Builder r1 = r1.minutes(r8)
                net.time4j.Duration$Builder r0 = r1.seconds(r0)
                net.time4j.Duration r0 = r0.build()
                boolean r14 = r14.isNegative()
                if (r14 == 0) goto L_0x0195
                net.time4j.Duration r0 = r0.inverse()
            L_0x0195:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.Duration.ApproximateNormalizer.normalize(net.time4j.engine.TimeSpan):net.time4j.Duration");
        }

        private static int safeCast(double d) {
            if (d >= -2.147483648E9d && d <= 2.147483647E9d) {
                return (int) d;
            }
            throw new ArithmeticException("Out of range: " + d);
        }

        private static IsoUnit maxUnit(double d) {
            for (IsoUnit isoUnit : Arrays.asList(new Enum[]{CalendarUnit.YEARS, CalendarUnit.MONTHS, CalendarUnit.DAYS, ClockUnit.HOURS, ClockUnit.MINUTES})) {
                if (d >= isoUnit.getLength()) {
                    return isoUnit;
                }
            }
            return ClockUnit.SECONDS;
        }
    }
}
