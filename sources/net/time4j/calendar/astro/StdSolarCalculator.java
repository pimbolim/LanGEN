package net.time4j.calendar.astro;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import net.time4j.Moment;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.PlainTimestamp;
import net.time4j.calendar.astro.SolarTime;
import net.time4j.engine.CalendarDate;
import net.time4j.engine.EpochDays;
import net.time4j.scale.LeapSeconds;
import net.time4j.scale.TimeScale;
import net.time4j.tz.TZID;
import net.time4j.tz.ZonalOffset;

public enum StdSolarCalculator implements SolarTime.Calculator {
    SIMPLE {
        public double getGeodeticAngle(double d, int i) {
            return 0.0d;
        }

        public Moment sunrise(CalendarDate calendarDate, double d, double d2, double d3) {
            return event(calendarDate, d, d2, d3, true);
        }

        public Moment sunset(CalendarDate calendarDate, double d, double d2, double d3) {
            return event(calendarDate, d, d2, d3, false);
        }

        public double equationOfTime(double d) {
            double time0 = time0(d);
            return ((Math.sin(Math.toRadians((0.9856d * time0) - 3.8d)) * -7.66d) - (Math.sin(Math.toRadians((time0 * 1.9712d) + 17.96d)) * 9.78d)) * 60.0d;
        }

        public double getZenithAngle(double d, int i) {
            return getGeodeticAngle(d, i) + 90.83333333333333d;
        }

        public double declination(double d) {
            return Math.toDegrees(Math.asin(Math.sin(Math.toRadians(trueLongitudeOfSunInDegrees(time0(d)))) * 0.39782d));
        }

        public double rightAscension(double d) {
            double trueLongitudeOfSunInDegrees = trueLongitudeOfSunInDegrees(time0(d));
            double range_0_360 = AstroUtils.toRange_0_360(Math.toDegrees(Math.atan(Math.tan(Math.toRadians(trueLongitudeOfSunInDegrees)) * 0.91764d)));
            return (range_0_360 + (Math.floor(trueLongitudeOfSunInDegrees / 90.0d) * 90.0d)) - (Math.floor(range_0_360 / 90.0d) * 90.0d);
        }

        private double time0(double d) {
            PlainTimestamp zonalTimestamp = JulianDay.ofEphemerisTime(d).toMoment().toZonalTimestamp((TZID) ZonalOffset.UTC);
            return ((double) zonalTimestamp.getCalendarDate().getDayOfYear()) + (((double) ((Integer) zonalTimestamp.getWallTime().get(PlainTime.SECOND_OF_DAY)).intValue()) / 86400.0d);
        }

        private double trueLongitudeOfSunInDegrees(double d) {
            double d2 = (d * 0.9856d) - 3.289d;
            return AstroUtils.toRange_0_360((Math.sin(Math.toRadians(d2)) * 1.916d) + d2 + (Math.sin(Math.toRadians(d2) * 2.0d) * 0.02d) + 282.634d);
        }

        private Moment event(CalendarDate calendarDate, double d, double d2, double d3, boolean z) {
            PlainDate gregorian = SolarTime.toGregorian(calendarDate);
            double d4 = d2 / 15.0d;
            double dayOfYear = ((double) gregorian.getDayOfYear()) + ((((double) (z ? 6 : 18)) - d4) / 24.0d);
            double trueLongitudeOfSunInDegrees = trueLongitudeOfSunInDegrees(dayOfYear);
            double range_0_360 = AstroUtils.toRange_0_360(Math.toDegrees(Math.atan(Math.tan(Math.toRadians(trueLongitudeOfSunInDegrees)) * 0.91764d)));
            double floor = (range_0_360 + ((Math.floor(trueLongitudeOfSunInDegrees / 90.0d) * 90.0d) - (Math.floor(range_0_360 / 90.0d) * 90.0d))) / 15.0d;
            double sin = Math.sin(Math.toRadians(trueLongitudeOfSunInDegrees)) * 0.39782d;
            double cos = Math.cos(Math.asin(sin));
            double radians = Math.toRadians(d);
            double cos2 = (Math.cos(Math.toRadians(d3)) - (sin * Math.sin(radians))) / (cos * Math.cos(radians));
            if (Double.compare(cos2, 1.0d) > 0 || Double.compare(cos2, -1.0d) < 0) {
                return null;
            }
            double degrees = Math.toDegrees(Math.acos(cos2));
            if (z) {
                degrees = 360.0d - degrees;
            }
            double d5 = (((degrees / 15.0d) + floor) - (dayOfYear * 0.06571d)) - 6.622d;
            if (Double.compare(0.0d, d5) > 0) {
                d5 += 24.0d;
            } else if (Double.compare(24.0d, d5) <= 0) {
                d5 -= 24.0d;
            }
            long longValue = (((Long) gregorian.get(EpochDays.UTC)).longValue() * 86400) + ((long) ((int) Math.floor((d5 - d4) * 3600.0d)));
            TimeScale timeScale = TimeScale.UT;
            if (!LeapSeconds.getInstance().isEnabled()) {
                longValue += 63072000;
                timeScale = TimeScale.POSIX;
            }
            return (Moment) Moment.of(Math.round(((double) longValue) / 60.0d) * 60, timeScale).with(Moment.PRECISION, TimeUnit.MINUTES);
        }
    },
    NOAA {
        private double excentricity(double d) {
            return 0.016708634d - (((1.267E-7d * d) + 4.2037E-5d) * d);
        }

        private double meanAnomaly(double d) {
            return ((35999.05029d - (1.537E-4d * d)) * d) + 357.52911d;
        }

        private double meanLongitude(double d) {
            return ((((3.032E-4d * d) + 36000.76983d) * d) + 280.46646d) % 360.0d;
        }

        public double getGeodeticAngle(double d, int i) {
            return 0.0d;
        }

        public Moment sunrise(CalendarDate calendarDate, double d, double d2, double d3) {
            return event(true, calendarDate, d, d2, d3);
        }

        public Moment sunset(CalendarDate calendarDate, double d, double d2, double d3) {
            return event(false, calendarDate, d, d2, d3);
        }

        public double equationOfTime(double d) {
            double access$100 = StdSolarCalculator.toJulianCenturies(d);
            double tan = Math.tan(Math.toRadians(obliquity(access$100) / 2.0d));
            double d2 = tan * tan;
            double radians = Math.toRadians(meanLongitude(access$100) * 2.0d);
            double excentricity = excentricity(access$100);
            double radians2 = Math.toRadians(meanAnomaly(access$100));
            double sin = Math.sin(radians2);
            return Math.toDegrees(((((Math.sin(radians) * d2) - ((excentricity * 2.0d) * sin)) + ((((excentricity * 4.0d) * d2) * sin) * Math.cos(radians))) - (((d2 * d2) * Math.sin(radians * 2.0d)) / 2.0d)) - ((((5.0d * excentricity) * excentricity) * Math.sin(radians2 * 2.0d)) / 4.0d)) * 240.0d;
        }

        public double declination(double d) {
            return Math.toDegrees(declinationRad(StdSolarCalculator.toJulianCenturies(d)));
        }

        public double getZenithAngle(double d, int i) {
            return getGeodeticAngle(d, i) + 90.83333333333333d;
        }

        public double rightAscension(double d) {
            double access$100 = StdSolarCalculator.toJulianCenturies(d);
            double radians = Math.toRadians(solarLongitude(access$100));
            return AstroUtils.toRange_0_360(Math.toDegrees(Math.atan2(Math.cos(Math.toRadians(obliquity(access$100))) * Math.sin(radians), Math.cos(radians))));
        }

        private Moment event(boolean z, CalendarDate calendarDate, double d, double d2, double d3) {
            Moment fromLocalEvent = SolarTime.fromLocalEvent(calendarDate, 12, d2, name());
            double value = JulianDay.getValue(fromLocalEvent, TimeScale.TT);
            double localHourAngle = localHourAngle(z, value, d, d3);
            if (Double.isNaN(localHourAngle)) {
                return null;
            }
            double localHourAngle2 = localHourAngle(z, value + (localHourAngle / 86400.0d), d, d3);
            if (Double.isNaN(localHourAngle2)) {
                return null;
            }
            long floor = (long) Math.floor(localHourAngle2);
            return (Moment) ((Moment) ((Moment) fromLocalEvent.plus(floor, TimeUnit.SECONDS)).plus((long) ((int) ((localHourAngle2 - ((double) floor)) * 1.0E9d)), TimeUnit.NANOSECONDS)).with(Moment.PRECISION, TimeUnit.SECONDS);
        }

        private double localHourAngle(boolean z, double d, double d2, double d3) {
            double localHourAngle = localHourAngle(StdSolarCalculator.toJulianCenturies(d), d2, d3);
            if (Double.isNaN(localHourAngle)) {
                return Double.NaN;
            }
            return z ? -localHourAngle : localHourAngle;
        }

        private double obliquity(double d) {
            return (((((((0.001813d * d) - 7338.72128d) * d) - 0.096064453125d) * d) + 21.448d) / 3600.0d) + 23.433333333333334d + (Math.cos(Math.toRadians(125.04d - (d * 1934.136d))) * 0.00256d);
        }

        private double localHourAngle(double d, double d2, double d3) {
            double radians = Math.toRadians(d2);
            double declinationRad = declinationRad(d);
            double cos = (Math.cos(Math.toRadians(d3)) - (Math.sin(declinationRad) * Math.sin(radians))) / (Math.cos(declinationRad) * Math.cos(radians));
            if (Double.compare(cos, 1.0d) > 0 || Double.compare(cos, -1.0d) < 0) {
                return Double.NaN;
            }
            return Math.toDegrees(Math.acos(cos)) * 240.0d;
        }

        private double declinationRad(double d) {
            return Math.asin(Math.sin(Math.toRadians(obliquity(d))) * Math.sin(Math.toRadians(solarLongitude(d))));
        }

        private double solarLongitude(double d) {
            return ((meanLongitude(d) + equationOfCenter(d)) - 0.00569d) - (Math.sin(Math.toRadians(125.04d - (d * 1934.136d))) * 0.00478d);
        }

        private double equationOfCenter(double d) {
            double radians = Math.toRadians(meanAnomaly(d));
            return (Math.sin(radians) * (1.914602d - (((1.4E-5d * d) + 0.004817d) * d))) + (Math.sin(2.0d * radians) * (0.019993d - (d * 1.01E-4d))) + (Math.sin(radians * 3.0d) * 2.89E-4d);
        }
    },
    CC {
        private double excentricity(double d) {
            return 0.016708617d - (((1.236E-7d * d) + 4.2037E-5d) * d);
        }

        private double meanAnomaly(double d) {
            return (((((4.8E-7d * d) - 28227.4562048d) * d) + 35999.0503d) * d) + 357.5291d;
        }

        private double meanLongitude(double d) {
            return ((((3.032E-4d * d) + 36000.76983d) * d) + 280.46645d) % 360.0d;
        }

        private double obliquity(double d) {
            return (((((((0.001813d * d) - 7338.72128d) * d) - 0.096064453125d) * d) + 21.448d) / 3600.0d) + 23.433333333333334d;
        }

        public Moment sunrise(CalendarDate calendarDate, double d, double d2, double d3) {
            return event(true, calendarDate, d, d2, d3);
        }

        public Moment sunset(CalendarDate calendarDate, double d, double d2, double d3) {
            return event(false, calendarDate, d, d2, d3);
        }

        private Moment event(boolean z, CalendarDate calendarDate, double d, double d2, double d3) {
            double transform = ((double) EpochDays.JULIAN_DAY_NUMBER.transform(calendarDate.getDaysSinceEpochUTC(), EpochDays.UTC)) + (z ? 0.25d : 0.75d);
            double integralAmount = (((double) ZonalOffset.atLongitude(new BigDecimal(d2)).getIntegralAmount()) - (TimeScale.deltaT(SolarTime.toGregorian(calendarDate)) - 43200.0d)) / 86400.0d;
            double momentOfDepression = momentOfDepression(transform, d, integralAmount, d3 - 90.0d, z);
            if (Double.isNaN(momentOfDepression)) {
                return null;
            }
            return (Moment) JulianDay.ofEphemerisTime(momentOfDepression - integralAmount).toMoment().with(Moment.PRECISION, TimeUnit.SECONDS);
        }

        public double equationOfTime(double d) {
            double access$100 = StdSolarCalculator.toJulianCenturies(d);
            double tan = Math.tan(Math.toRadians(obliquity(access$100) / 2.0d));
            double d2 = tan * tan;
            double radians = Math.toRadians(meanLongitude(access$100) * 2.0d);
            double excentricity = excentricity(access$100);
            double radians2 = Math.toRadians(meanAnomaly(access$100));
            double sin = Math.sin(radians2);
            return Math.toDegrees(((((Math.sin(radians) * d2) - ((excentricity * 2.0d) * sin)) + ((((excentricity * 4.0d) * d2) * sin) * Math.cos(radians))) - (((d2 * d2) * Math.sin(radians * 2.0d)) / 2.0d)) - ((((5.0d * excentricity) * excentricity) * Math.sin(radians2 * 2.0d)) / 4.0d)) * 240.0d;
        }

        public double declination(double d) {
            return getFeature(d, "declination");
        }

        public double rightAscension(double d) {
            return getFeature(d, "right-ascension");
        }

        public double getFeature(double d, String str) {
            double access$100 = StdSolarCalculator.toJulianCenturies(d);
            if (str.equals("declination")) {
                return Math.toDegrees(declinationRad(access$100));
            }
            if (str.equals("right-ascension")) {
                double radians = Math.toRadians(StdSolarCalculator.apparentSolarLongitude(access$100, nutation(access$100)));
                return AstroUtils.toRange_0_360(Math.toDegrees(Math.atan2(Math.cos(Math.toRadians(obliquity(access$100))) * Math.sin(radians), Math.cos(radians))));
            } else if (str.equals("nutation")) {
                return nutation(access$100);
            } else {
                if (str.equals("obliquity")) {
                    return obliquity(access$100);
                }
                if (str.equals("mean-anomaly")) {
                    return meanAnomaly(access$100);
                }
                if (str.equals("solar-longitude")) {
                    return StdSolarCalculator.apparentSolarLongitude(access$100, nutation(access$100));
                }
                return str.equals("solar-latitude") ? 0.0d : Double.NaN;
            }
        }

        public double getGeodeticAngle(double d, int i) {
            if (i == 0) {
                return 0.0d;
            }
            double d2 = (double) i;
            return Math.toDegrees(Math.acos(6372000.0d / (d2 + 6372000.0d))) + (Math.sqrt(d2) * 0.005277777777777778d);
        }

        public double getZenithAngle(double d, int i) {
            return getGeodeticAngle(d, i) + 90.83333333333333d;
        }

        private double momentOfDepression(double d, double d2, double d3, double d4, boolean z) {
            double approxMomentOfDepression = approxMomentOfDepression(d, d2, d3, d4, z);
            if (Double.isNaN(approxMomentOfDepression)) {
                return Double.NaN;
            }
            if (Math.abs(d - approxMomentOfDepression) * 86400.0d < 30.0d) {
                return approxMomentOfDepression;
            }
            return momentOfDepression(approxMomentOfDepression, d2, d3, d4, z);
        }

        private double approxMomentOfDepression(double d, double d2, double d3, double d4, boolean z) {
            double d5;
            long floor = (long) Math.floor(d);
            double sineOffset = sineOffset(d - d3, d2, d4);
            if (d4 >= 0.0d) {
                d5 = (double) (z ? floor : 1 + floor);
            } else {
                d5 = ((double) floor) + 0.5d;
            }
            if (Math.abs(sineOffset) > 1.0d) {
                sineOffset = sineOffset(d5 - d3, d2, d4);
            }
            if (Math.abs(sineOffset) <= 1.0d) {
                double degrees = (((double) (z ? -1 : 1)) * ((((Math.toDegrees(Math.asin(sineOffset)) / 360.0d) + 0.5d) % 1.0d) - 0.25d)) + ((double) floor) + 0.5d;
                return degrees - (equationOfTime(degrees - d3) / 86400.0d);
            }
            return Double.NaN;
        }

        private double sineOffset(double d, double d2, double d3) {
            double access$100 = StdSolarCalculator.toJulianCenturies(d);
            double radians = Math.toRadians(d2);
            double declinationRad = declinationRad(access$100);
            return (Math.tan(radians) * Math.tan(declinationRad)) + (Math.sin(Math.toRadians(d3)) / (Math.cos(declinationRad) * Math.cos(radians)));
        }

        private double declinationRad(double d) {
            return Math.asin(Math.sin(Math.toRadians(obliquity(d))) * Math.sin(Math.toRadians(StdSolarCalculator.apparentSolarLongitude(d, nutation(d)))));
        }

        private double nutation(double d) {
            return (Math.sin(Math.toRadians((((0.002063d * d) - 0.002170307159423828d) * d) + 124.9d)) * -0.004778d) - (Math.sin(Math.toRadians((((5.7E-4d * d) + 72001.5377d) * d) + 201.11d)) * 3.667E-4d);
        }
    },
    TIME4J {
        private double excentricity(double d) {
            return 0.016708634d - (((1.267E-7d * d) + 4.2037E-5d) * d);
        }

        private double meanAnomaly(double d) {
            return ((35999.05029d - (1.537E-4d * d)) * d) + 357.52911d;
        }

        private double meanLongitude(double d) {
            return ((((3.032E-4d * d) + 36000.76983d) * d) + 280.46646d) % 360.0d;
        }

        public Moment sunrise(CalendarDate calendarDate, double d, double d2, double d3) {
            return event(true, calendarDate, d, d2, d3);
        }

        public Moment sunset(CalendarDate calendarDate, double d, double d2, double d3) {
            return event(false, calendarDate, d, d2, d3);
        }

        public double equationOfTime(double d) {
            double access$100 = StdSolarCalculator.toJulianCenturies(d);
            double tan = Math.tan(Math.toRadians(trueObliquity(access$100) / 2.0d));
            double d2 = tan * tan;
            double radians = Math.toRadians(meanLongitude(access$100) * 2.0d);
            double excentricity = excentricity(access$100);
            double radians2 = Math.toRadians(meanAnomaly(access$100));
            double sin = Math.sin(radians2);
            return Math.toDegrees(((((Math.sin(radians) * d2) - ((excentricity * 2.0d) * sin)) + ((((excentricity * 4.0d) * d2) * sin) * Math.cos(radians))) - (((d2 * d2) * Math.sin(radians * 2.0d)) / 2.0d)) - ((((5.0d * excentricity) * excentricity) * Math.sin(radians2 * 2.0d)) / 4.0d)) * 240.0d;
        }

        public double declination(double d) {
            return getFeature(d, "declination");
        }

        public double rightAscension(double d) {
            return getFeature(d, "right-ascension");
        }

        public double getFeature(double d, String str) {
            double access$100 = StdSolarCalculator.toJulianCenturies(d);
            if (str.equals("declination")) {
                return Math.toDegrees(declinationRad(access$100));
            }
            if (str.equals("right-ascension")) {
                double[] dArr = new double[2];
                nutations(access$100, dArr);
                double radians = Math.toRadians(StdSolarCalculator.apparentSolarLongitude(access$100, dArr[0]));
                return AstroUtils.toRange_0_360(Math.toDegrees(Math.atan2(Math.cos(Math.toRadians(meanObliquity(access$100) + dArr[1])) * Math.sin(radians), Math.cos(radians))));
            } else if (str.equals("nutation")) {
                double[] dArr2 = new double[2];
                nutations(access$100, dArr2);
                return dArr2[0];
            } else if (str.equals("obliquity")) {
                double[] dArr3 = new double[2];
                nutations(access$100, dArr3);
                return meanObliquity(access$100) + dArr3[1];
            } else if (str.equals("mean-anomaly")) {
                return meanAnomaly(access$100);
            } else {
                if (!str.equals("solar-longitude")) {
                    return str.equals("solar-latitude") ? 0.0d : Double.NaN;
                }
                double[] dArr4 = new double[2];
                nutations(access$100, dArr4);
                return StdSolarCalculator.apparentSolarLongitude(access$100, dArr4[0]);
            }
        }

        public double getGeodeticAngle(double d, int i) {
            if (i == 0) {
                return 0.0d;
            }
            double radians = Math.toRadians(d);
            double cos = Math.cos(radians) * StdSolarCalculator.EQUATORIAL_RADIUS;
            double sin = Math.sin(radians) * StdSolarCalculator.POLAR_RADIUS;
            double sqrt = 4.0680631590769E13d / Math.sqrt((cos * cos) + (sin * sin));
            return Math.toDegrees(Math.acos(sqrt / (((double) i) + sqrt)));
        }

        public double getZenithAngle(double d, int i) {
            if (i == 0) {
                return 90.83333333333333d;
            }
            return getGeodeticAngle(d, i) + 90.0d + (((AstroUtils.refractionFactorOfStdAtmosphere(i) * 34.0d) + 16.0d) / 60.0d);
        }

        private Moment event(boolean z, CalendarDate calendarDate, double d, double d2, double d3) {
            Moment fromLocalEvent = SolarTime.fromLocalEvent(calendarDate, 12, d2, name());
            double value = JulianDay.getValue(fromLocalEvent, TimeScale.TT);
            double d4 = 0.0d;
            while (true) {
                double localHourAngle = localHourAngle(z, value + (d4 / 86400.0d), d, d3);
                if (Double.isNaN(localHourAngle)) {
                    return null;
                }
                if (Math.abs(localHourAngle - d4) < 15.0d) {
                    long floor = (long) Math.floor(localHourAngle);
                    return (Moment) ((Moment) ((Moment) fromLocalEvent.plus(floor, TimeUnit.SECONDS)).plus((long) ((int) ((localHourAngle - ((double) floor)) * 1.0E9d)), TimeUnit.NANOSECONDS)).with(Moment.PRECISION, TimeUnit.SECONDS);
                }
                d4 = localHourAngle;
            }
        }

        private double localHourAngle(boolean z, double d, double d2, double d3) {
            double access$100 = StdSolarCalculator.toJulianCenturies(d);
            double radians = Math.toRadians(d2);
            double declinationRad = declinationRad(access$100);
            double cos = (Math.cos(Math.toRadians(d3)) - (Math.sin(declinationRad) * Math.sin(radians))) / (Math.cos(declinationRad) * Math.cos(radians));
            if (Double.compare(cos, 1.0d) > 0 || Double.compare(cos, -1.0d) < 0) {
                return Double.NaN;
            }
            double degrees = Math.toDegrees(Math.acos(cos)) * 240.0d;
            return z ? -degrees : degrees;
        }

        private double declinationRad(double d) {
            double[] dArr = new double[2];
            nutations(d, dArr);
            return Math.asin(Math.sin(Math.toRadians(meanObliquity(d) + dArr[1])) * Math.sin(Math.toRadians(StdSolarCalculator.apparentSolarLongitude(d, dArr[0]))));
        }

        private double trueObliquity(double d) {
            return meanObliquity(d) + (Math.cos(Math.toRadians(125.04d - (d * 1934.136d))) * 0.00256d);
        }
    };
    
    private static final int[] DG_X = null;
    private static final double[] DG_Y = null;
    private static final double[] DG_Z = null;
    private static final double EQUATORIAL_RADIUS = 6378137.0d;
    private static final int MEAN_EARTH_RADIUS = 6372000;
    private static final double POLAR_RADIUS = 6356752.3d;
    private static final double[][] TABLE_22A = null;

    static double meanObliquity(double d) {
        return (((((((0.001813d * d) - 7338.72128d) * d) - 0.096064453125d) * d) + 21.448d) / 3600.0d) + 23.433333333333334d;
    }

    /* access modifiers changed from: private */
    public static double toJulianCenturies(double d) {
        return (d - 2451545.0d) / 36525.0d;
    }

    static {
        DG_X = new int[]{403406, 195207, 119433, 112392, 3891, 2819, 1721, 660, 350, 334, 314, 268, 242, 234, 158, 132, 129, 114, 99, 93, 86, 78, 72, 68, 64, 46, 38, 37, 32, 29, 28, 27, 27, 25, 24, 21, 21, 20, 18, 17, 14, 13, 13, 13, 12, 10, 10, 10, 10};
        DG_Y = new double[]{270.54861d, 340.19128d, 63.91854d, 331.2622d, 317.843d, 86.631d, 240.052d, 310.26d, 247.23d, 260.87d, 297.82d, 343.14d, 166.79d, 81.53d, 3.5d, 132.75d, 182.95d, 162.03d, 29.8d, 266.4d, 249.2d, 157.6d, 257.8d, 185.1d, 69.9d, 8.0d, 197.1d, 250.4d, 65.3d, 162.7d, 341.5d, 291.6d, 98.5d, 146.7d, 110.0d, 5.2d, 342.6d, 230.9d, 256.1d, 45.3d, 242.9d, 115.2d, 151.8d, 285.3d, 53.3d, 126.6d, 205.7d, 85.9d, 146.1d};
        DG_Z = new double[]{0.9287892d, 35999.1376958d, 35999.4089666d, 35998.7287385d, 71998.20261d, 71998.4403d, 36000.35726d, 71997.4812d, 32964.4678d, -19.441d, 445267.1117d, 45036.884d, 3.1008d, 22518.4434d, -19.9739d, 65928.9345d, 9038.0293d, 3034.7684d, 33718.148d, 3034.448d, -2280.773d, 29929.992d, 31556.493d, 149.588d, 9037.75d, 107997.405d, -4444.176d, 151.771d, 67555.316d, 31556.08d, -4561.54d, 107996.706d, 1221.655d, 62894.167d, 31437.369d, 14578.298d, -31931.757d, 34777.243d, 1221.999d, 62894.511d, -4442.039d, 107997.909d, 119.066d, 16859.071d, -4.578d, 26895.292d, -39.127d, 12297.536d, 90073.778d};
        TABLE_22A = new double[][]{new double[]{0.0d, 0.0d, 0.0d, 0.0d, 1.0d, -171996.0d, -174.2d, 92025.0d, 8.9d}, new double[]{-2.0d, 0.0d, 0.0d, 2.0d, 2.0d, -13187.0d, -1.6d, 5736.0d, -3.1d}, new double[]{0.0d, 0.0d, 0.0d, 2.0d, 2.0d, -2274.0d, -0.2d, 977.0d, -0.5d}, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 2.0d, 2062.0d, 0.2d, -895.0d, 0.5d}, new double[]{0.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1426.0d, -3.4d, 54.0d, -0.1d}, new double[]{0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 712.0d, 0.1d, -7.0d, 0.0d}, new double[]{-2.0d, 1.0d, 0.0d, 2.0d, 2.0d, -517.0d, 1.2d, 224.0d, -0.6d}, new double[]{0.0d, 0.0d, 0.0d, 2.0d, 1.0d, -386.0d, -0.4d, 200.0d, 0.0d}, new double[]{0.0d, 0.0d, 1.0d, 2.0d, 2.0d, -301.0d, 0.0d, 129.0d, -0.1d}, new double[]{-2.0d, -1.0d, 0.0d, 2.0d, 2.0d, 217.0d, -0.5d, -95.0d, 0.3d}, new double[]{-2.0d, 0.0d, 1.0d, 0.0d, 0.0d, -158.0d, 0.0d, 0.0d, 0.0d}, new double[]{-2.0d, 0.0d, 0.0d, 2.0d, 1.0d, 129.0d, 0.1d, -70.0d, 0.0d}, new double[]{0.0d, 0.0d, -1.0d, 2.0d, 2.0d, 123.0d, 0.0d, -53.0d, 0.0d}, new double[]{2.0d, 0.0d, 0.0d, 0.0d, 0.0d, 63.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 1.0d, 0.0d, 1.0d, 63.0d, 0.1d, -33.0d, 0.0d}, new double[]{2.0d, 0.0d, -1.0d, 2.0d, 2.0d, -59.0d, 0.0d, 26.0d, 0.0d}, new double[]{0.0d, 0.0d, -1.0d, 0.0d, 1.0d, -58.0d, -0.1d, 32.0d, 0.0d}, new double[]{0.0d, 0.0d, 1.0d, 2.0d, 1.0d, -51.0d, 0.0d, 27.0d, 0.0d}, new double[]{-2.0d, 0.0d, 2.0d, 0.0d, 0.0d, 48.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, -2.0d, 2.0d, 1.0d, 46.0d, 0.0d, -24.0d, 0.0d}, new double[]{2.0d, 0.0d, 0.0d, 2.0d, 2.0d, -38.0d, 0.0d, 16.0d, 0.0d}, new double[]{0.0d, 0.0d, 2.0d, 2.0d, 2.0d, -31.0d, 0.0d, 13.0d, 0.0d}, new double[]{0.0d, 0.0d, 2.0d, 0.0d, 0.0d, 29.0d, 0.0d, 0.0d, 0.0d}, new double[]{-2.0d, 0.0d, 1.0d, 2.0d, 2.0d, 29.0d, 0.0d, -12.0d, 0.0d}, new double[]{0.0d, 0.0d, 0.0d, 2.0d, 0.0d, 26.0d, 0.0d, 0.0d, 0.0d}, new double[]{-2.0d, 0.0d, 0.0d, 2.0d, 0.0d, -22.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, -1.0d, 2.0d, 1.0d, 21.0d, 0.0d, -10.0d, 0.0d}, new double[]{0.0d, 2.0d, 0.0d, 0.0d, 0.0d, 17.0d, -0.1d, 0.0d, 0.0d}, new double[]{2.0d, 0.0d, -1.0d, 0.0d, 1.0d, 16.0d, 0.0d, -8.0d, 0.0d}, new double[]{-2.0d, 2.0d, 0.0d, 2.0d, 2.0d, -16.0d, 0.1d, 7.0d, 0.0d}, new double[]{0.0d, 1.0d, 0.0d, 0.0d, 1.0d, -15.0d, 0.0d, 9.0d, 0.0d}, new double[]{-2.0d, 0.0d, 1.0d, 0.0d, 1.0d, -13.0d, 0.0d, 7.0d, 0.0d}, new double[]{0.0d, -1.0d, 0.0d, 0.0d, 1.0d, -12.0d, 0.0d, 6.0d, 0.0d}, new double[]{0.0d, 0.0d, 2.0d, -2.0d, 0.0d, 11.0d, 0.0d, 0.0d, 0.0d}, new double[]{2.0d, 0.0d, -1.0d, 2.0d, 1.0d, -10.0d, 0.0d, 5.0d, 0.0d}, new double[]{2.0d, 0.0d, 1.0d, 2.0d, 2.0d, -8.0d, 0.0d, 3.0d, 0.0d}, new double[]{0.0d, 1.0d, 0.0d, 2.0d, 2.0d, 7.0d, 0.0d, -3.0d, 0.0d}, new double[]{-2.0d, 1.0d, 1.0d, 0.0d, 0.0d, -7.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, -1.0d, 0.0d, 2.0d, 2.0d, -7.0d, 0.0d, 3.0d, 0.0d}, new double[]{2.0d, 0.0d, 0.0d, 2.0d, 1.0d, -7.0d, 0.0d, 3.0d, 0.0d}, new double[]{2.0d, 0.0d, 1.0d, 0.0d, 0.0d, 6.0d, 0.0d, 0.0d, 0.0d}, new double[]{-2.0d, 0.0d, 2.0d, 2.0d, 2.0d, 6.0d, 0.0d, -3.0d, 0.0d}, new double[]{-2.0d, 0.0d, 1.0d, 2.0d, 1.0d, 6.0d, 0.0d, -3.0d, 0.0d}, new double[]{2.0d, 0.0d, -2.0d, 0.0d, 1.0d, -6.0d, 0.0d, 3.0d, 0.0d}, new double[]{2.0d, 0.0d, 0.0d, 0.0d, 1.0d, -6.0d, 0.0d, 3.0d, 0.0d}, new double[]{0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 5.0d, 0.0d, 0.0d, 0.0d}, new double[]{-2.0d, -1.0d, 0.0d, 2.0d, 1.0d, -5.0d, 0.0d, 3.0d, 0.0d}, new double[]{-2.0d, 0.0d, 0.0d, 0.0d, 1.0d, -5.0d, 0.0d, 3.0d, 0.0d}, new double[]{0.0d, 0.0d, 2.0d, 2.0d, 1.0d, -5.0d, 0.0d, 3.0d, 0.0d}, new double[]{-2.0d, 0.0d, 2.0d, 0.0d, 1.0d, 4.0d, 0.0d, 0.0d, 0.0d}, new double[]{-2.0d, 1.0d, 0.0d, 2.0d, 1.0d, 4.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 1.0d, -2.0d, 0.0d, 4.0d, 0.0d, 0.0d, 0.0d}, new double[]{-1.0d, 0.0d, 1.0d, 0.0d, 0.0d, -4.0d, 0.0d, 0.0d, 0.0d}, new double[]{-2.0d, 1.0d, 0.0d, 0.0d, 0.0d, -4.0d, 0.0d, 0.0d, 0.0d}, new double[]{1.0d, 0.0d, 0.0d, 0.0d, 0.0d, -4.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 1.0d, 2.0d, 0.0d, 3.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, -2.0d, 2.0d, 2.0d, -3.0d, 0.0d, 0.0d, 0.0d}, new double[]{-1.0d, -1.0d, 1.0d, 0.0d, 0.0d, -3.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 1.0d, 1.0d, 0.0d, 0.0d, -3.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, -1.0d, 1.0d, 2.0d, 2.0d, -3.0d, 0.0d, 0.0d, 0.0d}, new double[]{2.0d, -1.0d, -1.0d, 2.0d, 2.0d, -3.0d, 0.0d, 0.0d, 0.0d}, new double[]{0.0d, 0.0d, 3.0d, 2.0d, 2.0d, -3.0d, 0.0d, 0.0d, 0.0d}, new double[]{2.0d, -1.0d, 0.0d, 2.0d, 2.0d, -3.0d, 0.0d, 0.0d, 0.0d}};
    }

    public double declination(double d) {
        throw new AbstractMethodError();
    }

    public double rightAscension(double d) {
        throw new AbstractMethodError();
    }

    public double getFeature(double d, String str) {
        if (str.equals("declination")) {
            return declination(d);
        }
        if (str.equals("right-ascension")) {
            return rightAscension(d);
        }
        return Double.NaN;
    }

    static void nutations(double d, double[] dArr) {
        double radians = Math.toRadians((((((5.277768981496142E-6d * d) - 2129.6316416d) * d) + 445267.11148d) * d) + 297.85036d);
        double radians2 = Math.toRadians((((((-3.3333333333333333E-6d * d) - 27636.8982016d) * d) + 35999.05034d) * d) + 357.52772d);
        double radians3 = Math.toRadians((((((1.7777777777777779E-4d * d) + 0.0086972d) * d) + 477198.867398d) * d) + 134.96298d);
        double radians4 = Math.toRadians((((((3.0555810187307116E-6d * d) - 1141.30944d) * d) + 483202.017538d) * d) + 93.27191d);
        double radians5 = Math.toRadians((((((2.222222222222222E-6d * d) + 0.0020708d) * d) - 0.002170302846908569d) * d) + 125.04452d);
        double d2 = 0.0d;
        double d3 = 0.0d;
        for (int length = TABLE_22A.length - 1; length >= 0; length--) {
            double[] dArr2 = TABLE_22A[length];
            double d4 = (dArr2[0] * radians) + (dArr2[1] * radians2) + (dArr2[2] * radians3) + (dArr2[3] * radians4) + (dArr2[4] * radians5);
            d2 += Math.sin(d4) * (dArr2[5] + (dArr2[6] * d));
            d3 += Math.cos(d4) * (dArr2[7] + (dArr2[8] * d));
        }
        dArr[0] = (d2 * 1.0E-4d) / 3600.0d;
        dArr[1] = (d3 * 1.0E-4d) / 3600.0d;
    }

    /* access modifiers changed from: private */
    public static double apparentSolarLongitude(double d, double d2) {
        double d3 = 0.0d;
        for (int length = DG_X.length - 1; length >= 0; length--) {
            d3 += ((double) DG_X[length]) * Math.sin(Math.toRadians(DG_Y[length] + (DG_Z[length] * d)));
        }
        double aberration = (((((36000.76953744d * d) + 282.7771834d) + ((d3 * 5.729577951308232d) / 1000000.0d)) + aberration(d)) + d2) / 360.0d;
        return (aberration - Math.floor(aberration)) * 360.0d;
    }

    private static double aberration(double d) {
        return (Math.cos(Math.toRadians((d * 35999.01848d) + 177.63d)) * 9.74E-5d) - 0.005575d;
    }
}
