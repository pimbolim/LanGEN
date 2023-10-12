package net.time4j.calendar;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.time4j.base.MathUtils;
import net.time4j.engine.CalendarEra;
import net.time4j.engine.VariantSource;

public enum HijriAlgorithm implements VariantSource {
    EAST_ISLAMIC_CIVIL("islamic-eastc", new int[]{2, 5, 7, 10, 13, 15, 18, 21, 24, 26, 29}, true),
    EAST_ISLAMIC_ASTRO("islamic-easta", new int[]{2, 5, 7, 10, 13, 15, 18, 21, 24, 26, 29}, false),
    WEST_ISLAMIC_CIVIL("islamic-civil", new int[]{2, 5, 7, 10, 13, 16, 18, 21, 24, 26, 29}, true),
    WEST_ISLAMIC_ASTRO("islamic-tbla", new int[]{2, 5, 7, 10, 13, 16, 18, 21, 24, 26, 29}, false),
    FATIMID_CIVIL("islamic-fatimidc", new int[]{2, 5, 8, 10, 13, 16, 19, 21, 24, 27, 29}, true),
    FATIMID_ASTRO("islamic-fatimida", new int[]{2, 5, 8, 10, 13, 16, 19, 21, 24, 27, 29}, false),
    HABASH_AL_HASIB_CIVIL("islamic-habashalhasibc", new int[]{2, 5, 8, 11, 13, 16, 19, 21, 24, 27, 30}, true),
    HABASH_AL_HASIB_ASTRO("islamic-habashalhasiba", new int[]{2, 5, 8, 11, 13, 16, 19, 21, 24, 27, 30}, false);
    
    /* access modifiers changed from: private */
    public static final long ASTRO_1600_12_29 = 0;
    /* access modifiers changed from: private */
    public static final long CIVIL_1600_12_29 = 0;
    /* access modifiers changed from: private */
    public static final long LENGTH_OF_30_YEAR_CYCLE = 0;
    /* access modifiers changed from: private */
    public static final int MAX_YEAR = 0;
    /* access modifiers changed from: private */
    public static final long START_622_07_15 = 0;
    /* access modifiers changed from: private */
    public static final long START_622_07_16 = 0;
    private final transient Transformer calsys;

    static {
        LENGTH_OF_30_YEAR_CYCLE = 10631;
        START_622_07_15 = -492879;
        START_622_07_16 = -492879 + 1;
        MAX_YEAR = 1600;
        ASTRO_1600_12_29 = 74106;
        CIVIL_1600_12_29 = 74106 + 1;
    }

    private HijriAlgorithm(String str, int[] iArr, boolean z) {
        this.calsys = new Transformer(str, iArr, z, 0);
    }

    public String getVariant() {
        return this.calsys.variant;
    }

    /* access modifiers changed from: package-private */
    public EraYearMonthDaySystem<HijriCalendar> getCalendarSystem(int i) {
        if (i == 0) {
            return this.calsys;
        }
        return new Transformer(HijriAdjustment.of(getVariant(), i).getVariant(), this.calsys.intercalaries, this.calsys.civil, i);
    }

    private static class Transformer implements EraYearMonthDaySystem<HijriCalendar> {
        private final int adjustment;
        /* access modifiers changed from: private */
        public final boolean civil;
        /* access modifiers changed from: private */
        public final int[] intercalaries;
        /* access modifiers changed from: private */
        public final String variant;

        Transformer(String str, int[] iArr, boolean z, int i) {
            this.variant = str;
            this.intercalaries = iArr;
            this.civil = z;
            this.adjustment = i;
        }

        public boolean isValid(CalendarEra calendarEra, int i, int i2, int i3) {
            if (calendarEra != HijriEra.ANNO_HEGIRAE || i < 1 || i > HijriAlgorithm.MAX_YEAR || i2 < 1 || i2 > 12 || i3 < 1 || i3 > getLengthOfMonth(calendarEra, i, i2)) {
                return false;
            }
            return true;
        }

        public int getLengthOfMonth(CalendarEra calendarEra, int i, int i2) {
            if (calendarEra != HijriEra.ANNO_HEGIRAE) {
                throw new IllegalArgumentException("Wrong era: " + calendarEra);
            } else if (i < 1 || i > HijriAlgorithm.MAX_YEAR || i2 < 1 || i2 > 12) {
                throw new IllegalArgumentException("Out of bounds: " + i + "/" + i2);
            } else if (i2 == 12) {
                if (Arrays.binarySearch(this.intercalaries, ((i - 1) % 30) + 1) >= 0) {
                    return 30;
                }
                return 29;
            } else if (i2 % 2 == 1) {
                return 30;
            } else {
                return 29;
            }
        }

        public int getLengthOfYear(CalendarEra calendarEra, int i) {
            if (calendarEra != HijriEra.ANNO_HEGIRAE) {
                throw new IllegalArgumentException("Wrong era: " + calendarEra);
            } else if (i < 1 || i > HijriAlgorithm.MAX_YEAR) {
                throw new IllegalArgumentException("Out of bounds: yearOfEra=" + i);
            } else {
                return Arrays.binarySearch(this.intercalaries, ((i - 1) % 30) + 1) >= 0 ? 355 : 354;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0082, code lost:
            if (java.util.Arrays.binarySearch(r7.intercalaries, ((r0 - 1) % 30) + 1) >= 0) goto L_0x008c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x008a, code lost:
            if ((r3 % 2) == 1) goto L_0x008c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.calendar.HijriCalendar transform(long r8) {
            /*
                r7 = this;
                int r0 = r7.adjustment
                long r0 = (long) r0
                long r0 = net.time4j.base.MathUtils.safeAdd((long) r8, (long) r0)
                boolean r2 = r7.civil
                if (r2 == 0) goto L_0x0010
                long r2 = net.time4j.calendar.HijriAlgorithm.START_622_07_16
                goto L_0x0014
            L_0x0010:
                long r2 = net.time4j.calendar.HijriAlgorithm.START_622_07_15
            L_0x0014:
                int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r4 < 0) goto L_0x00a0
                boolean r4 = r7.civil
                if (r4 == 0) goto L_0x0021
                long r4 = net.time4j.calendar.HijriAlgorithm.CIVIL_1600_12_29
                goto L_0x0025
            L_0x0021:
                long r4 = net.time4j.calendar.HijriAlgorithm.ASTRO_1600_12_29
            L_0x0025:
                int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
                if (r6 > 0) goto L_0x00a0
                long r8 = net.time4j.base.MathUtils.safeSubtract((long) r0, (long) r2)
                long r0 = net.time4j.calendar.HijriAlgorithm.LENGTH_OF_30_YEAR_CYCLE
                long r0 = r8 / r0
                r2 = 30
                long r0 = r0 * r2
                int r0 = net.time4j.base.MathUtils.safeCast(r0)
                r1 = 1
                int r0 = r0 + r1
                long r2 = net.time4j.calendar.HijriAlgorithm.LENGTH_OF_30_YEAR_CYCLE
                long r8 = r8 % r2
                int r9 = (int) r8
                r8 = 1
            L_0x0044:
                r2 = 30
                if (r8 >= r2) goto L_0x005c
                r3 = 354(0x162, float:4.96E-43)
                int[] r4 = r7.intercalaries
                int r4 = java.util.Arrays.binarySearch(r4, r8)
                if (r4 < 0) goto L_0x0054
                r3 = 355(0x163, float:4.97E-43)
            L_0x0054:
                if (r9 <= r3) goto L_0x005c
                int r9 = r9 - r3
                int r0 = r0 + 1
                int r8 = r8 + 1
                goto L_0x0044
            L_0x005c:
                r8 = 1
                r3 = 1
            L_0x005e:
                r4 = 29
                r5 = 12
                if (r8 >= r5) goto L_0x0075
                int r6 = r8 % 2
                if (r6 != 0) goto L_0x006b
                r6 = 29
                goto L_0x006d
            L_0x006b:
                r6 = 30
            L_0x006d:
                if (r9 <= r6) goto L_0x0075
                int r9 = r9 - r6
                int r3 = r3 + 1
                int r8 = r8 + 1
                goto L_0x005e
            L_0x0075:
                int r9 = r9 + r1
                if (r3 != r5) goto L_0x0088
                int r8 = r0 + -1
                int r8 = r8 % r2
                int r8 = r8 + r1
                int[] r6 = r7.intercalaries
                int r8 = java.util.Arrays.binarySearch(r6, r8)
                if (r8 < 0) goto L_0x0085
                goto L_0x008c
            L_0x0085:
                r2 = 29
                goto L_0x008c
            L_0x0088:
                int r8 = r3 % 2
                if (r8 != r1) goto L_0x0085
            L_0x008c:
                if (r9 <= r2) goto L_0x0098
                int r3 = r3 + 1
                if (r3 <= r5) goto L_0x0095
                int r0 = r0 + 1
                goto L_0x0096
            L_0x0095:
                r1 = r3
            L_0x0096:
                r9 = 1
                goto L_0x0099
            L_0x0098:
                r1 = r3
            L_0x0099:
                java.lang.String r8 = r7.variant
                net.time4j.calendar.HijriCalendar r8 = net.time4j.calendar.HijriCalendar.of((java.lang.String) r8, (int) r0, (int) r1, (int) r9)
                return r8
            L_0x00a0:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Out of supported range: "
                r1.append(r2)
                r1.append(r8)
                java.lang.String r8 = r1.toString()
                r0.<init>(r8)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.HijriAlgorithm.Transformer.transform(long):net.time4j.calendar.HijriCalendar");
        }

        public long transform(HijriCalendar hijriCalendar) {
            int year = hijriCalendar.getYear();
            int value = hijriCalendar.getMonth().getValue();
            int dayOfMonth = hijriCalendar.getDayOfMonth();
            if (year < 1 || year > HijriAlgorithm.MAX_YEAR || value < 1 || value > 12 || dayOfMonth < 1 || dayOfMonth > 30) {
                throw new IllegalArgumentException("Out of supported range: " + hijriCalendar);
            }
            int i = year - 1;
            long access$800 = ((long) (i / 30)) * HijriAlgorithm.LENGTH_OF_30_YEAR_CYCLE;
            int i2 = (i % 30) + 1;
            for (int i3 = 1; i3 < i2; i3++) {
                access$800 += Arrays.binarySearch(this.intercalaries, i3) >= 0 ? 355 : 354;
            }
            for (int i4 = 1; i4 < value; i4++) {
                access$800 += i4 % 2 == 0 ? 29 : 30;
            }
            if (dayOfMonth != 30 || ((value != 12 || Arrays.binarySearch(this.intercalaries, i2) >= 0) && (value == 12 || value % 2 != 0))) {
                return MathUtils.safeSubtract(((this.civil ? HijriAlgorithm.START_622_07_16 : HijriAlgorithm.START_622_07_15) + (access$800 + ((long) dayOfMonth))) - 1, (long) this.adjustment);
            }
            throw new IllegalArgumentException("Invalid day-of-month: " + hijriCalendar);
        }

        public long getMinimumSinceUTC() {
            return MathUtils.safeSubtract(this.civil ? HijriAlgorithm.START_622_07_16 : HijriAlgorithm.START_622_07_15, (long) this.adjustment);
        }

        public long getMaximumSinceUTC() {
            return MathUtils.safeSubtract(this.civil ? HijriAlgorithm.CIVIL_1600_12_29 : HijriAlgorithm.ASTRO_1600_12_29, (long) this.adjustment);
        }

        public List<CalendarEra> getEras() {
            return Collections.singletonList(HijriEra.ANNO_HEGIRAE);
        }
    }
}
