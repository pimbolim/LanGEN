package net.time4j.calendar.astro;

import com.nimbusds.jose.shaded.ow2asm.Opcodes;
import net.time4j.Moment;
import net.time4j.scale.LeapSeconds;
import net.time4j.scale.TimeScale;
import net.time4j.scale.UniversalTime;
import net.time4j.tz.TZID;
import net.time4j.tz.ZonalOffset;

public enum AstronomicalSeason {
    VERNAL_EQUINOX,
    SUMMER_SOLSTICE,
    AUTUMNAL_EQUINOX,
    WINTER_SOLSTICE;
    
    private static final int[] A = null;
    private static final double[] B = null;
    private static final double[] C = null;

    public AstronomicalSeason onNorthernHemisphere() {
        return this;
    }

    static {
        A = new int[]{485, 203, Opcodes.IFNONNULL, 182, 156, 136, 77, 74, 70, 58, 52, 50, 45, 44, 29, 18, 17, 16, 14, 12, 12, 12, 9, 8};
        B = new double[]{324.96d, 337.23d, 342.08d, 27.85d, 73.14d, 171.52d, 222.54d, 296.72d, 243.58d, 119.81d, 297.17d, 21.02d, 247.54d, 325.15d, 60.93d, 155.12d, 288.79d, 198.04d, 199.76d, 95.39d, 287.11d, 320.81d, 227.73d, 15.45d};
        C = new double[]{1934.136d, 32964.467d, 20.186d, 445267.112d, 45036.886d, 22518.443d, 65928.934d, 3034.906d, 9037.513d, 33718.147d, 150.678d, 2281.226d, 29929.562d, 31555.956d, 4443.417d, 67555.328d, 4562.452d, 62894.029d, 31436.921d, 14577.848d, 31931.756d, 34777.259d, 1222.114d, 16859.074d};
    }

    public static AstronomicalSeason of(Moment moment) {
        int year = moment.toZonalTimestamp((TZID) ZonalOffset.UTC).getYear();
        checkYear(year);
        AstronomicalSeason astronomicalSeason = VERNAL_EQUINOX;
        if (moment.isBefore((UniversalTime) astronomicalSeason.inYear(year))) {
            return WINTER_SOLSTICE;
        }
        AstronomicalSeason astronomicalSeason2 = SUMMER_SOLSTICE;
        if (moment.isBefore((UniversalTime) astronomicalSeason2.inYear(year))) {
            return astronomicalSeason;
        }
        AstronomicalSeason astronomicalSeason3 = AUTUMNAL_EQUINOX;
        if (moment.isBefore((UniversalTime) astronomicalSeason3.inYear(year))) {
            return astronomicalSeason2;
        }
        AstronomicalSeason astronomicalSeason4 = WINTER_SOLSTICE;
        return moment.isBefore((UniversalTime) astronomicalSeason4.inYear(year)) ? astronomicalSeason3 : astronomicalSeason4;
    }

    public Moment inYear(int i) {
        TimeScale timeScale;
        double d;
        checkYear(i);
        double jdEphemerisDays = (jdEphemerisDays(i) - 2441317.5d) * 86400.0d;
        boolean isEnabled = LeapSeconds.getInstance().isEnabled();
        if (!isEnabled || i < 1972) {
            d = jdEphemerisDays - TimeScale.deltaT(i, (ordinal() + 1) * 3);
            timeScale = TimeScale.UT;
        } else {
            d = jdEphemerisDays - 42.184d;
            timeScale = TimeScale.UTC;
        }
        long floor = (long) Math.floor(d);
        int i2 = (int) ((d - ((double) floor)) * 1.0E9d);
        if (!isEnabled) {
            floor += 63072000;
            timeScale = TimeScale.POSIX;
        }
        return Moment.of(floor, i2, timeScale);
    }

    public JulianDay julianDay(int i) {
        checkYear(i);
        return JulianDay.ofEphemerisTime(jdEphemerisDays(i));
    }

    public AstronomicalSeason onSouthernHemisphere() {
        return values()[(ordinal() + 2) % 4];
    }

    private static void checkYear(int i) {
        if (i < -2000 || i > 3000) {
            throw new IllegalArgumentException("Year out of supported range: -2000 <= " + i + " <= +3000");
        }
    }

    private double jdEphemerisDays(int i) {
        double jdMean = jdMean(i);
        double d = (jdMean - 2451545.0d) / 36525.0d;
        double d2 = (35999.373d * d) - 2.47d;
        return jdMean + ((periodic24(d) * 1.0E-5d) / (((cos(d2) * 0.0334d) + 1.0d) + (cos(d2 * 2.0d) * 7.0E-4d)));
    }

    /* renamed from: net.time4j.calendar.astro.AstronomicalSeason$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$calendar$astro$AstronomicalSeason = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                net.time4j.calendar.astro.AstronomicalSeason[] r0 = net.time4j.calendar.astro.AstronomicalSeason.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$calendar$astro$AstronomicalSeason = r0
                net.time4j.calendar.astro.AstronomicalSeason r1 = net.time4j.calendar.astro.AstronomicalSeason.VERNAL_EQUINOX     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$calendar$astro$AstronomicalSeason     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.calendar.astro.AstronomicalSeason r1 = net.time4j.calendar.astro.AstronomicalSeason.SUMMER_SOLSTICE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$calendar$astro$AstronomicalSeason     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.calendar.astro.AstronomicalSeason r1 = net.time4j.calendar.astro.AstronomicalSeason.AUTUMNAL_EQUINOX     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$net$time4j$calendar$astro$AstronomicalSeason     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.calendar.astro.AstronomicalSeason r1 = net.time4j.calendar.astro.AstronomicalSeason.WINTER_SOLSTICE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.astro.AstronomicalSeason.AnonymousClass1.<clinit>():void");
        }
    }

    private double jdMean(int i) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        double d11;
        if (i < 1000) {
            d = ((double) i) / 1000.0d;
            int i2 = AnonymousClass1.$SwitchMap$net$time4j$calendar$astro$AstronomicalSeason[ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    d7 = 1721233.25401d;
                    d8 = 365241.72562d;
                    d9 = -0.05323d;
                    d10 = 0.00907d;
                    d11 = 2.5E-4d;
                } else if (i2 == 3) {
                    d7 = 1721325.70455d;
                    d8 = 365242.49558d;
                    d9 = -0.11677d;
                    d10 = -0.00297d;
                    d11 = 7.4E-4d;
                } else if (i2 == 4) {
                    d2 = 1721414.39987d;
                    d3 = 365242.88257d;
                    d4 = -0.00769d;
                    d5 = -0.00933d;
                    d6 = 6.0E-5d;
                } else {
                    throw new AssertionError(this);
                }
                return (((((((d11 * d) + d10) * d) + d9) * d) + d8) * d) + d7;
            }
            d2 = 1721139.29189d;
            d3 = 365242.1374d;
            d4 = 0.06134d;
            d5 = 0.00111d;
            d6 = 7.1E-4d;
        } else {
            d = ((double) (i - 2000)) / 1000.0d;
            int i3 = AnonymousClass1.$SwitchMap$net$time4j$calendar$astro$AstronomicalSeason[ordinal()];
            if (i3 == 1) {
                d2 = 2451623.80984d;
                d3 = 365242.37404d;
                d4 = 0.05169d;
                d5 = -0.00411d;
                d6 = 5.7E-4d;
            } else if (i3 != 2) {
                if (i3 == 3) {
                    d7 = 2451810.21715d;
                    d8 = 365242.01767d;
                    d9 = -0.11575d;
                    d10 = 0.00337d;
                    d11 = 7.8E-4d;
                } else if (i3 == 4) {
                    d7 = 2451900.05952d;
                    d8 = 365242.74049d;
                    d9 = -0.06223d;
                    d10 = -0.00823d;
                    d11 = 3.2E-4d;
                } else {
                    throw new AssertionError(this);
                }
                return (((((((d11 * d) + d10) * d) + d9) * d) + d8) * d) + d7;
            } else {
                d2 = 2451716.56767d;
                d3 = 365241.62603d;
                d4 = 0.00325d;
                d5 = 0.00888d;
                d6 = 3.0E-4d;
            }
        }
        return ((((((d5 - (d6 * d)) * d) + d4) * d) + d3) * d) + d2;
    }

    private static double periodic24(double d) {
        double d2 = 0.0d;
        for (int i = 0; i < 24; i++) {
            d2 += ((double) A[i]) * cos(B[i] + (C[i] * d));
        }
        return d2;
    }

    private static double cos(double d) {
        return Math.cos((d * 3.141592653589793d) / 180.0d);
    }
}
