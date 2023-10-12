package net.time4j;

import androidx.compose.animation.core.AnimationKt;
import java.util.ArrayList;
import java.util.Comparator;
import net.time4j.IsoUnit;
import net.time4j.base.MathUtils;
import net.time4j.engine.ChronoUnit;
import net.time4j.engine.Normalizer;
import net.time4j.engine.TimeSpan;

class StdNormalizer<U extends IsoUnit> implements Normalizer<U>, Comparator<TimeSpan.Item<? extends ChronoUnit>> {
    private static final int MIO = 1000000;
    private static final int MRD = 1000000000;
    private final boolean mixed;

    private StdNormalizer(boolean z) {
        this.mixed = z;
    }

    static StdNormalizer<IsoUnit> ofMixedUnits() {
        return new StdNormalizer<>(true);
    }

    static StdNormalizer<CalendarUnit> ofCalendarUnits() {
        return new StdNormalizer<>(false);
    }

    static StdNormalizer<ClockUnit> ofClockUnits() {
        return new StdNormalizer<>(false);
    }

    static Comparator<TimeSpan.Item<? extends ChronoUnit>> comparator() {
        return new StdNormalizer(false);
    }

    public int compare(TimeSpan.Item<? extends ChronoUnit> item, TimeSpan.Item<? extends ChronoUnit> item2) {
        return compare((ChronoUnit) item.getUnit(), (ChronoUnit) item2.getUnit());
    }

    public Duration<U> normalize(TimeSpan<? extends U> timeSpan) {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        int size = timeSpan.getTotalLength().size();
        ArrayList arrayList = new ArrayList(size);
        int i = 0;
        long j9 = 0;
        long j10 = 0;
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        long j14 = 0;
        long j15 = 0;
        long j16 = 0;
        while (i < size) {
            TimeSpan.Item item = timeSpan.getTotalLength().get(i);
            long j17 = j12;
            j12 = item.getAmount();
            IsoUnit isoUnit = (IsoUnit) item.getUnit();
            int i2 = size;
            long j18 = j10;
            if (isoUnit instanceof CalendarUnit) {
                switch (AnonymousClass1.$SwitchMap$net$time4j$CalendarUnit[CalendarUnit.class.cast(isoUnit).ordinal()]) {
                    case 1:
                        j9 = MathUtils.safeAdd(MathUtils.safeMultiply(j12, 1000), j9);
                        break;
                    case 2:
                        j9 = MathUtils.safeAdd(MathUtils.safeMultiply(j12, 100), j9);
                        break;
                    case 3:
                        j9 = MathUtils.safeAdd(MathUtils.safeMultiply(j12, 10), j9);
                        break;
                    case 4:
                        j9 = MathUtils.safeAdd(j12, j9);
                        break;
                    case 5:
                        j8 = MathUtils.safeAdd(MathUtils.safeMultiply(j12, 3), j14);
                        break;
                    case 6:
                        j8 = MathUtils.safeAdd(j12, j14);
                        break;
                    case 7:
                        j16 = j12;
                        break;
                    case 8:
                        j15 = j12;
                        break;
                    default:
                        throw new UnsupportedOperationException(isoUnit.toString());
                }
                j14 = j8;
            } else if (isoUnit instanceof ClockUnit) {
                switch (AnonymousClass1.$SwitchMap$net$time4j$ClockUnit[ClockUnit.class.cast(isoUnit).ordinal()]) {
                    case 1:
                        j10 = j12;
                        j12 = j17;
                        continue;
                    case 2:
                        j11 = j12;
                        break;
                    case 3:
                        break;
                    case 4:
                        j13 = MathUtils.safeAdd(MathUtils.safeMultiply(j12, (long) AnimationKt.MillisToNanos), j13);
                        break;
                    case 5:
                        j13 = MathUtils.safeAdd(MathUtils.safeMultiply(j12, 1000), j13);
                        break;
                    case 6:
                        j13 = MathUtils.safeAdd(j12, j13);
                        break;
                    default:
                        throw new UnsupportedOperationException(isoUnit.toString());
                }
            } else {
                arrayList.add(TimeSpan.Item.of(j12, isoUnit));
            }
            j12 = j17;
            j10 = j18;
            continue;
            i++;
            size = i2;
        }
        long j19 = j10;
        long j20 = j12;
        if ((j19 | j11 | j20 | j13) != 0) {
            long j21 = j13 % 1000000000;
            long safeAdd = MathUtils.safeAdd(j20, j13 / 1000000000);
            j2 = safeAdd % 60;
            long safeAdd2 = MathUtils.safeAdd(j11, safeAdd / 60);
            j4 = safeAdd2 % 60;
            j5 = MathUtils.safeAdd(j19, safeAdd2 / 60);
            if (this.mixed) {
                j3 = MathUtils.safeAdd(j15, j5 / 24);
                j = j21;
                j5 %= 24;
            } else {
                j3 = j15;
                j = j21;
            }
        } else {
            j3 = j15;
            j5 = 0;
            j4 = 0;
            j2 = 0;
            j = 0;
        }
        if ((j9 | j14 | j3) != 0) {
            j6 = j2;
            long safeAdd3 = MathUtils.safeAdd(j9, j14 / 12);
            long j22 = j14 % 12;
            j7 = j4;
            long safeAdd4 = MathUtils.safeAdd(MathUtils.safeMultiply(j16, 7), j3);
            if (safeAdd3 != 0) {
                arrayList.add(TimeSpan.Item.of(safeAdd3, CalendarUnit.YEARS));
            }
            if (j22 != 0) {
                arrayList.add(TimeSpan.Item.of(j22, CalendarUnit.MONTHS));
            }
            if (safeAdd4 != 0) {
                arrayList.add(TimeSpan.Item.of(safeAdd4, CalendarUnit.DAYS));
            }
        } else {
            j7 = j4;
            j6 = j2;
            long j23 = j16;
            if (j23 != 0) {
                arrayList.add(TimeSpan.Item.of(j23, CalendarUnit.WEEKS));
            }
        }
        if (j5 != 0) {
            arrayList.add(TimeSpan.Item.of(j5, ClockUnit.HOURS));
        }
        if (j7 != 0) {
            arrayList.add(TimeSpan.Item.of(j7, ClockUnit.MINUTES));
        }
        if (j6 != 0) {
            arrayList.add(TimeSpan.Item.of(j6, ClockUnit.SECONDS));
        }
        long j24 = j;
        if (j24 != 0) {
            arrayList.add(TimeSpan.Item.of(j24, ClockUnit.NANOS));
        }
        return new Duration<>(arrayList, timeSpan.isNegative());
    }

    /* renamed from: net.time4j.StdNormalizer$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
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
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.StdNormalizer.AnonymousClass1.<clinit>():void");
        }
    }

    static int compare(ChronoUnit chronoUnit, ChronoUnit chronoUnit2) {
        int compare = Double.compare(chronoUnit2.getLength(), chronoUnit.getLength());
        if (compare != 0 || chronoUnit.equals(chronoUnit2)) {
            return compare;
        }
        throw new IllegalArgumentException("Mixing different units of same length not allowed.");
    }
}
