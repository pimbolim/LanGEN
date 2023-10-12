package net.time4j.tz;

import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.base.GregorianDate;
import net.time4j.base.GregorianMath;
import net.time4j.base.MathUtils;
import net.time4j.base.WallTime;

final class TransitionResolver implements TransitionStrategy, Serializable {
    private static final Map<Integer, TransitionResolver> INSTANCES = new HashMap();
    private static final String NO_HISTORY = "Timezone provider does not expose its transition history.";
    private static final long serialVersionUID = 1790434289322009750L;
    private final transient GapResolver gapResolver;
    private final transient OverlapResolver overlapResolver;

    static {
        for (GapResolver gapResolver2 : GapResolver.values()) {
            for (OverlapResolver overlapResolver2 : OverlapResolver.values()) {
                INSTANCES.put(Integer.valueOf((gapResolver2.ordinal() * 2) + overlapResolver2.ordinal()), new TransitionResolver(gapResolver2, overlapResolver2));
            }
        }
    }

    private TransitionResolver(GapResolver gapResolver2, OverlapResolver overlapResolver2) {
        this.gapResolver = gapResolver2;
        this.overlapResolver = overlapResolver2;
    }

    public long resolve(GregorianDate gregorianDate, WallTime wallTime, Timezone timezone) {
        long localSeconds;
        int integralAmount;
        long localSeconds2;
        int totalOffset;
        GregorianDate gregorianDate2 = gregorianDate;
        WallTime wallTime2 = wallTime;
        int year = gregorianDate.getYear();
        int month = gregorianDate.getMonth();
        int dayOfMonth = gregorianDate.getDayOfMonth();
        int hour = wallTime.getHour();
        int minute = wallTime.getMinute();
        int second = wallTime.getSecond();
        TransitionHistory history = timezone.getHistory();
        if (history == null && this.overlapResolver == OverlapResolver.LATER_OFFSET && (this.gapResolver == GapResolver.PUSH_FORWARD || this.gapResolver == GapResolver.ABORT)) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone(timezone.getID().canonical()));
            gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
            gregorianCalendar.set(14, 0);
            GregorianCalendar gregorianCalendar2 = gregorianCalendar;
            gregorianCalendar.set(year, month - 1, dayOfMonth, hour, minute, second);
            int i = gregorianCalendar2.get(1);
            int i2 = gregorianCalendar2.get(2) + 1;
            int i3 = gregorianCalendar2.get(5);
            int i4 = gregorianCalendar2.get(11);
            int i5 = gregorianCalendar2.get(12);
            int i6 = gregorianCalendar2.get(13);
            if (this.gapResolver == GapResolver.ABORT && !(year == i && month == i2 && dayOfMonth == i3 && hour == i4 && minute == i5 && second == i6)) {
                throwInvalidException(gregorianDate, wallTime, timezone);
            }
            localSeconds = toLocalSeconds(i, i2, i3, i4, i5, i6);
            integralAmount = timezone.getOffset(gregorianDate, wallTime2).getIntegralAmount();
        } else {
            Timezone timezone2 = timezone;
            if (history != null) {
                ZonalTransition conflictTransition = history.getConflictTransition(gregorianDate2, wallTime2);
                if (conflictTransition != null) {
                    if (conflictTransition.isGap()) {
                        int i7 = AnonymousClass1.$SwitchMap$net$time4j$tz$GapResolver[this.gapResolver.ordinal()];
                        if (i7 == 1) {
                            localSeconds2 = toLocalSeconds(year, month, dayOfMonth, hour, minute, second) + ((long) conflictTransition.getSize());
                            totalOffset = conflictTransition.getTotalOffset();
                        } else if (i7 == 2) {
                            return conflictTransition.getPosixTime();
                        } else {
                            if (i7 == 3) {
                                throwInvalidException(gregorianDate, wallTime, timezone);
                            } else {
                                throw new UnsupportedOperationException(this.gapResolver.name());
                            }
                        }
                    } else if (conflictTransition.isOverlap()) {
                        localSeconds2 = toLocalSeconds(year, month, dayOfMonth, hour, minute, second);
                        totalOffset = conflictTransition.getTotalOffset();
                        if (this.overlapResolver == OverlapResolver.EARLIER_OFFSET) {
                            totalOffset = conflictTransition.getPreviousOffset();
                        }
                    }
                    return localSeconds2 - ((long) totalOffset);
                }
                localSeconds = toLocalSeconds(year, month, dayOfMonth, hour, minute, second);
                integralAmount = history.getValidOffsets(gregorianDate2, wallTime2).get(0).getIntegralAmount();
            } else {
                throw new UnsupportedOperationException(NO_HISTORY);
            }
        }
        return localSeconds - ((long) integralAmount);
    }

    /* renamed from: net.time4j.tz.TransitionResolver$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$tz$GapResolver;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                net.time4j.tz.GapResolver[] r0 = net.time4j.tz.GapResolver.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$tz$GapResolver = r0
                net.time4j.tz.GapResolver r1 = net.time4j.tz.GapResolver.PUSH_FORWARD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$tz$GapResolver     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.tz.GapResolver r1 = net.time4j.tz.GapResolver.NEXT_VALID_TIME     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$tz$GapResolver     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.tz.GapResolver r1 = net.time4j.tz.GapResolver.ABORT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.tz.TransitionResolver.AnonymousClass1.<clinit>():void");
        }
    }

    public ZonalOffset getOffset(GregorianDate gregorianDate, WallTime wallTime, Timezone timezone) {
        TransitionHistory history = timezone.getHistory();
        if (history == null && this.overlapResolver == OverlapResolver.LATER_OFFSET && (this.gapResolver == GapResolver.PUSH_FORWARD || this.gapResolver == GapResolver.ABORT)) {
            if (this.gapResolver == GapResolver.ABORT && timezone.isInvalid(gregorianDate, wallTime)) {
                throwInvalidException(gregorianDate, wallTime, timezone);
            }
            return timezone.getOffset(gregorianDate, wallTime);
        } else if (history != null) {
            ZonalTransition conflictTransition = history.getConflictTransition(gregorianDate, wallTime);
            if (conflictTransition != null) {
                int totalOffset = conflictTransition.getTotalOffset();
                if (conflictTransition.isGap()) {
                    if (this.gapResolver != GapResolver.ABORT) {
                        return ZonalOffset.ofTotalSeconds(totalOffset);
                    }
                    throwInvalidException(gregorianDate, wallTime, timezone);
                } else if (conflictTransition.isOverlap()) {
                    if (this.overlapResolver == OverlapResolver.EARLIER_OFFSET) {
                        totalOffset = conflictTransition.getPreviousOffset();
                    }
                    return ZonalOffset.ofTotalSeconds(totalOffset);
                }
            }
            return history.getValidOffsets(gregorianDate, wallTime).get(0);
        } else {
            throw new UnsupportedOperationException(NO_HISTORY);
        }
    }

    public TransitionStrategy using(OverlapResolver overlapResolver2) {
        if (overlapResolver2 == this.overlapResolver) {
            return this;
        }
        return this.gapResolver.and(overlapResolver2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(getClass().getName());
        sb.append(":[gap=");
        sb.append(this.gapResolver);
        sb.append(",overlap=");
        sb.append(this.overlapResolver);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    static TransitionResolver of(GapResolver gapResolver2, OverlapResolver overlapResolver2) {
        return INSTANCES.get(Integer.valueOf((gapResolver2.ordinal() * 2) + overlapResolver2.ordinal()));
    }

    /* access modifiers changed from: package-private */
    public int getKey() {
        return (this.gapResolver.ordinal() * 2) + this.overlapResolver.ordinal();
    }

    private static long toLocalSeconds(int i, int i2, int i3, int i4, int i5, int i6) {
        return MathUtils.safeMultiply(MathUtils.safeSubtract(GregorianMath.toMJD(i, i2, i3), 40587), 86400) + ((long) ((i4 * NikonType2MakernoteDirectory.TAG_NIKON_SCAN) + (i5 * 60) + i6));
    }

    private static void throwInvalidException(GregorianDate gregorianDate, WallTime wallTime, Timezone timezone) {
        throw new IllegalArgumentException("Invalid local timestamp due to timezone transition: local-date=" + gregorianDate + ", local-time=" + wallTime + " [" + timezone.getID().canonical() + "]");
    }

    private Object writeReplace() {
        return new SPX(this, 13);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Serialization proxy required.");
    }
}
