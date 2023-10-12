package net.time4j.calendar.astro;

import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.CalendarUnit;
import net.time4j.ClockUnit;
import net.time4j.Moment;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.PlainTimestamp;
import net.time4j.base.MathUtils;
import net.time4j.base.ResourceLoader;
import net.time4j.engine.CalendarDate;
import net.time4j.engine.ChronoCondition;
import net.time4j.engine.ChronoException;
import net.time4j.engine.ChronoFunction;
import net.time4j.engine.EpochDays;
import net.time4j.scale.LeapSeconds;
import net.time4j.scale.TimeScale;
import net.time4j.scale.UniversalTime;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.ZonalOffset;

public final class SolarTime implements GeoLocation, Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final double ARC_MIN = 0.016666666666666666d;
    /* access modifiers changed from: private */
    public static final ConcurrentMap<String, Calculator> CALCULATORS;
    static final String DECLINATION = "declination";
    /* access modifiers changed from: private */
    public static final Calculator DEFAULT_CALCULATOR;
    private static final SolarTime JERUSALEM = ofLocation().easternLongitude(35, 14, 5.0d).northernLatitude(31, 46, 44.0d).atAltitude(721).usingCalculator((Calculator) StdSolarCalculator.TIME4J).build();
    private static final SolarTime MECCA = ofLocation().easternLongitude(39, 49, 34.06d).northernLatitude(21, 25, 21.22d).atAltitude(298).usingCalculator((Calculator) StdSolarCalculator.TIME4J).build();
    static final String RIGHT_ASCENSION = "right-ascension";
    static final double STD_REFRACTION = 34.0d;
    static final double STD_ZENITH = 90.83333333333333d;
    static final double SUN_RADIUS = 16.0d;
    private static final long serialVersionUID = -4816619838743247977L;
    private final int altitude;
    /* access modifiers changed from: private */
    public final String calculator;
    /* access modifiers changed from: private */
    public final double latitude;
    /* access modifiers changed from: private */
    public final double longitude;
    private final TZID observerZoneID;

    public interface Calculator {
        double equationOfTime(double d);

        double getFeature(double d, String str);

        double getGeodeticAngle(double d, int i);

        double getZenithAngle(double d, int i);

        String name();

        Moment sunrise(CalendarDate calendarDate, double d, double d2, double d3);

        Moment sunset(CalendarDate calendarDate, double d, double d2, double d3);
    }

    static {
        r0 = null;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (S s : ResourceLoader.getInstance().services(Calculator.class)) {
            concurrentHashMap.put(s.name(), s);
        }
        for (StdSolarCalculator stdSolarCalculator : StdSolarCalculator.values()) {
            concurrentHashMap.put(stdSolarCalculator.name(), stdSolarCalculator);
        }
        CALCULATORS = concurrentHashMap;
        if (s == null) {
            s = StdSolarCalculator.NOAA;
        }
        DEFAULT_CALCULATOR = s;
    }

    private SolarTime(double d, double d2, int i, String str, TZID tzid) {
        this.latitude = d;
        this.longitude = d2;
        this.altitude = i;
        this.calculator = str;
        this.observerZoneID = tzid;
    }

    public static Builder ofLocation() {
        return new Builder();
    }

    public static SolarTime ofLocation(double d, double d2) {
        return ofLocation(d, d2, 0, DEFAULT_CALCULATOR);
    }

    public static SolarTime ofLocation(double d, double d2, int i, String str) {
        check(d, d2, i, str);
        return new SolarTime(d, d2, i, str, (TZID) null);
    }

    public static SolarTime ofLocation(double d, double d2, int i, Calculator calculator2) {
        String name = calculator2.name();
        CALCULATORS.putIfAbsent(name, calculator2);
        check(d, d2, i, name);
        return new SolarTime(d, d2, i, name, (TZID) null);
    }

    public static SolarTime ofJerusalem() {
        return JERUSALEM;
    }

    public static SolarTime ofMecca() {
        return MECCA;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public int getAltitude() {
        return this.altitude;
    }

    public Calculator getCalculator() {
        return (Calculator) CALCULATORS.get(this.calculator);
    }

    public TZID getObserverZoneID() {
        return this.observerZoneID;
    }

    public ChronoFunction<CalendarDate, Moment> sunrise() {
        return new ChronoFunction<CalendarDate, Moment>() {
            public Moment apply(CalendarDate calendarDate) {
                return SolarTime.this.getCalculator().sunrise(SolarTime.this.toLMT(calendarDate), SolarTime.this.latitude, SolarTime.this.longitude, SolarTime.this.zenithAngle());
            }
        };
    }

    public ChronoFunction<CalendarDate, Moment> sunrise(Twilight twilight) {
        final double geodeticAngle = geodeticAngle() + 90.0d + twilight.getAngle();
        return new ChronoFunction<CalendarDate, Moment>() {
            public Moment apply(CalendarDate calendarDate) {
                return SolarTime.this.getCalculator().sunrise(SolarTime.this.toLMT(calendarDate), SolarTime.this.latitude, SolarTime.this.longitude, geodeticAngle);
            }
        };
    }

    public ChronoFunction<CalendarDate, Moment> sunset() {
        return new ChronoFunction<CalendarDate, Moment>() {
            public Moment apply(CalendarDate calendarDate) {
                return SolarTime.this.getCalculator().sunset(SolarTime.this.toLMT(calendarDate), SolarTime.this.latitude, SolarTime.this.longitude, SolarTime.this.zenithAngle());
            }
        };
    }

    public ChronoFunction<CalendarDate, Moment> sunset(Twilight twilight) {
        final double geodeticAngle = geodeticAngle() + 90.0d + twilight.getAngle();
        return new ChronoFunction<CalendarDate, Moment>() {
            public Moment apply(CalendarDate calendarDate) {
                return SolarTime.this.getCalculator().sunset(SolarTime.this.toLMT(calendarDate), SolarTime.this.latitude, SolarTime.this.longitude, geodeticAngle);
            }
        };
    }

    public ChronoFunction<CalendarDate, Sunshine> sunshine(final TZID tzid) {
        return new ChronoFunction<CalendarDate, Sunshine>() {
            public Sunshine apply(CalendarDate calendarDate) {
                PlainDate gregorian = SolarTime.toGregorian(SolarTime.this.toLMT(calendarDate));
                Calculator calculator = SolarTime.this.getCalculator();
                double access$400 = SolarTime.this.zenithAngle();
                Calculator calculator2 = calculator;
                CalendarDate calendarDate2 = calendarDate;
                double d = access$400;
                Moment sunrise = calculator2.sunrise(calendarDate2, SolarTime.this.latitude, SolarTime.this.longitude, d);
                Moment sunset = calculator2.sunset(calendarDate2, SolarTime.this.latitude, SolarTime.this.longitude, d);
                return new Sunshine(gregorian, sunrise, sunset, tzid, sunrise == null && sunset == null && Double.compare(SolarTime.this.getHighestElevationOfSun(gregorian), 90.0d - access$400) < 0);
            }
        };
    }

    public ChronoCondition<CalendarDate> polarNight() {
        return new ChronoCondition<CalendarDate>() {
            public boolean test(CalendarDate calendarDate) {
                if (Double.compare(Math.abs(SolarTime.this.latitude), 66.0d) < 0) {
                    return false;
                }
                PlainDate gregorian = SolarTime.toGregorian(SolarTime.this.toLMT(calendarDate));
                Calculator calculator = SolarTime.this.getCalculator();
                double access$400 = SolarTime.this.zenithAngle();
                CalendarDate calendarDate2 = calendarDate;
                double d = access$400;
                Moment sunrise = calculator.sunrise(calendarDate2, SolarTime.this.latitude, SolarTime.this.longitude, d);
                Moment sunset = calculator.sunset(calendarDate2, SolarTime.this.latitude, SolarTime.this.longitude, d);
                if (sunrise == null && sunset == null && Double.compare(SolarTime.this.getHighestElevationOfSun(gregorian), 90.0d - access$400) < 0) {
                    return true;
                }
                return false;
            }
        };
    }

    public ChronoCondition<CalendarDate> midnightSun() {
        return new ChronoCondition<CalendarDate>() {
            public boolean test(CalendarDate calendarDate) {
                if (Double.compare(Math.abs(SolarTime.this.latitude), 66.0d) < 0) {
                    return false;
                }
                PlainDate gregorian = SolarTime.toGregorian(SolarTime.this.toLMT(calendarDate));
                Calculator calculator = SolarTime.this.getCalculator();
                double access$400 = SolarTime.this.zenithAngle();
                CalendarDate calendarDate2 = calendarDate;
                double d = access$400;
                Moment sunrise = calculator.sunrise(calendarDate2, SolarTime.this.latitude, SolarTime.this.longitude, d);
                Moment sunset = calculator.sunset(calendarDate2, SolarTime.this.latitude, SolarTime.this.longitude, d);
                if (sunrise == null && sunset == null && Double.compare(SolarTime.this.getHighestElevationOfSun(gregorian), 90.0d - access$400) > 0) {
                    return true;
                }
                return false;
            }
        };
    }

    public ChronoFunction<CalendarDate, Moment> transitAtNoon() {
        return new ChronoFunction<CalendarDate, Moment>() {
            public Moment apply(CalendarDate calendarDate) {
                return SolarTime.transitAtNoon(SolarTime.this.toLMT(calendarDate), SolarTime.this.longitude, SolarTime.this.calculator);
            }
        };
    }

    public ChronoFunction<CalendarDate, Moment> transitAtMidnight() {
        return new ChronoFunction<CalendarDate, Moment>() {
            public Moment apply(CalendarDate calendarDate) {
                return SolarTime.transitAtMidnight(SolarTime.this.toLMT(calendarDate), SolarTime.this.longitude, SolarTime.this.calculator);
            }
        };
    }

    public ChronoFunction<CalendarDate, Moment> timeOfShadowBeforeNoon(double d, double d2) {
        checkShadow(d, d2);
        final double d3 = d;
        final double d4 = d2;
        return new ChronoFunction<CalendarDate, Moment>() {
            public Moment apply(CalendarDate calendarDate) {
                return SolarTime.this.timeOfShadow(calendarDate, false, d3, d4);
            }
        };
    }

    public ChronoFunction<CalendarDate, Moment> timeOfShadowAfterNoon(double d, double d2) {
        checkShadow(d, d2);
        final double d3 = d;
        final double d4 = d2;
        return new ChronoFunction<CalendarDate, Moment>() {
            public Moment apply(CalendarDate calendarDate) {
                return SolarTime.this.timeOfShadow(calendarDate, true, d3, d4);
            }
        };
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SolarTime)) {
            return false;
        }
        SolarTime solarTime = (SolarTime) obj;
        if (this.calculator.equals(solarTime.calculator) && Double.compare(this.latitude, solarTime.latitude) == 0 && Double.compare(this.longitude, solarTime.longitude) == 0 && this.altitude == solarTime.altitude && equalZones(this.observerZoneID, solarTime.observerZoneID)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.calculator.hashCode() + (AstroUtils.hashCode(this.latitude) * 7) + (AstroUtils.hashCode(this.longitude) * 31) + (this.altitude * 37);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SolarTime[latitude=");
        sb.append(this.latitude);
        sb.append(",longitude=");
        sb.append(this.longitude);
        if (this.altitude != 0) {
            sb.append(",altitude=");
            sb.append(this.altitude);
        }
        if (!this.calculator.equals(DEFAULT_CALCULATOR.name())) {
            sb.append(",calculator=");
            sb.append(this.calculator);
        }
        if (this.observerZoneID != null) {
            sb.append(",observerZoneID=");
            sb.append(this.observerZoneID.canonical());
        }
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public static ChronoFunction<Moment, PlainTimestamp> apparentAt(final ZonalOffset zonalOffset) {
        return new ChronoFunction<Moment, PlainTimestamp>() {
            public PlainTimestamp apply(Moment moment) {
                PlainTimestamp access$1000 = SolarTime.onAverage(moment, zonalOffset);
                double equationOfTime = SolarTime.equationOfTime(moment);
                long floor = (long) Math.floor(equationOfTime);
                return (PlainTimestamp) ((PlainTimestamp) access$1000.plus(floor, ClockUnit.SECONDS)).plus((long) ((int) ((equationOfTime - ((double) floor)) * 1.0E9d)), ClockUnit.NANOS);
            }
        };
    }

    public static ChronoFunction<Moment, PlainTimestamp> apparentAt(final ZonalOffset zonalOffset, final String str) {
        return new ChronoFunction<Moment, PlainTimestamp>() {
            public PlainTimestamp apply(Moment moment) {
                PlainTimestamp access$1000 = SolarTime.onAverage(moment, zonalOffset);
                double equationOfTime = SolarTime.equationOfTime(moment, str);
                long floor = (long) Math.floor(equationOfTime);
                return (PlainTimestamp) ((PlainTimestamp) access$1000.plus(floor, ClockUnit.SECONDS)).plus((long) ((int) ((equationOfTime - ((double) floor)) * 1.0E9d)), ClockUnit.NANOS);
            }
        };
    }

    public static ChronoFunction<Moment, PlainTimestamp> onAverage(final ZonalOffset zonalOffset) {
        return new ChronoFunction<Moment, PlainTimestamp>() {
            public PlainTimestamp apply(Moment moment) {
                return SolarTime.onAverage(moment, zonalOffset);
            }
        };
    }

    public static double equationOfTime(Moment moment) {
        return DEFAULT_CALCULATOR.equationOfTime(JulianDay.getValue(moment, TimeScale.TT));
    }

    public static double equationOfTime(Moment moment, String str) {
        Objects.requireNonNull(str, "Missing calculator parameter.");
        ConcurrentMap<String, Calculator> concurrentMap = CALCULATORS;
        if (concurrentMap.containsKey(str)) {
            return ((Calculator) concurrentMap.get(str)).equationOfTime(JulianDay.getValue(moment, TimeScale.TT));
        }
        throw new IllegalArgumentException("Unknown calculator: " + str);
    }

    /* access modifiers changed from: package-private */
    public double getHighestElevationOfSun(PlainDate plainDate) {
        double radians = Math.toRadians(getCalculator().getFeature(JulianDay.getValue((Moment) plainDate.get(transitAtNoon()), TimeScale.TT), DECLINATION));
        double radians2 = Math.toRadians(this.latitude);
        double degrees = Math.toDegrees(Math.asin((Math.sin(radians2) * Math.sin(radians)) + (Math.cos(radians2) * Math.cos(radians))));
        if (!Double.isNaN(degrees)) {
            return degrees;
        }
        throw new UnsupportedOperationException("Solar declination not supported by: " + getCalculator().name());
    }

    static PlainDate toGregorian(CalendarDate calendarDate) {
        if (calendarDate instanceof PlainDate) {
            return (PlainDate) calendarDate;
        }
        return PlainDate.of(calendarDate.getDaysSinceEpochUTC(), EpochDays.UTC);
    }

    static Moment fromLocalEvent(CalendarDate calendarDate, int i, double d, String str) {
        Calculator calculator2 = (Calculator) CALCULATORS.get(str);
        double daysSinceEpochUTC = ((double) ((calendarDate.getDaysSinceEpochUTC() * 86400) + ((long) (i * NikonType2MakernoteDirectory.TAG_NIKON_SCAN)))) - (d * 240.0d);
        long floor = (long) Math.floor(daysSinceEpochUTC);
        int i2 = (int) ((daysSinceEpochUTC - ((double) floor)) * 1.0E9d);
        TimeScale timeScale = TimeScale.UT;
        if (!LeapSeconds.getInstance().isEnabled()) {
            floor += 63072000;
            timeScale = TimeScale.POSIX;
        }
        Moment of = Moment.of(floor, i2, timeScale);
        double equationOfTime = calculator2.equationOfTime(JulianDay.getValue(of, TimeScale.TT));
        long floor2 = (long) Math.floor(equationOfTime);
        double equationOfTime2 = calculator2.equationOfTime(JulianDay.getValue((Moment) ((Moment) of.minus(floor2, TimeUnit.SECONDS)).minus((long) ((int) ((equationOfTime - ((double) floor2)) * 1.0E9d)), TimeUnit.NANOSECONDS), TimeScale.TT));
        long floor3 = (long) Math.floor(equationOfTime2);
        return (Moment) ((Moment) of.minus(floor3, TimeUnit.SECONDS)).minus((long) ((int) ((equationOfTime2 - ((double) floor3)) * 1.0E9d)), TimeUnit.NANOSECONDS);
    }

    /* access modifiers changed from: private */
    public static PlainTimestamp onAverage(Moment moment, ZonalOffset zonalOffset) {
        return Moment.of(moment.getElapsedTime(TimeScale.UT) + 63072000, moment.getNanosecond(TimeScale.UT), TimeScale.POSIX).toZonalTimestamp((TZID) zonalOffset);
    }

    /* access modifiers changed from: private */
    public static Moment transitAtNoon(CalendarDate calendarDate, double d, String str) {
        return (Moment) fromLocalEvent(calendarDate, 12, d, str).with(Moment.PRECISION, precision(str));
    }

    /* access modifiers changed from: private */
    public static Moment transitAtMidnight(CalendarDate calendarDate, double d, String str) {
        return (Moment) fromLocalEvent(calendarDate, 0, d, str).with(Moment.PRECISION, precision(str));
    }

    private void checkShadow(double d, double d2) {
        if (Double.isInfinite(d) || Double.isNaN(d) || d <= 0.0d) {
            throw new IllegalArgumentException("Object height must be finite and positive.");
        } else if (Double.isInfinite(d2) || Double.isNaN(d2) || d2 < 0.0d) {
            throw new IllegalArgumentException("Length of shadow must be finite and not negative.");
        } else if (Math.abs(this.latitude) > 66.0d) {
            throw new UnsupportedOperationException("Cannot calculate time of shadow for polar regions.");
        }
    }

    /* access modifiers changed from: private */
    public Moment timeOfShadow(CalendarDate calendarDate, boolean z, double d, double d2) {
        double d3;
        PlainDate gregorian = toGregorian(toLMT(calendarDate));
        Moment moment = (Moment) gregorian.get(z ? sunset() : sunrise());
        Moment moment2 = (Moment) gregorian.get(transitAtNoon());
        double elevation = SunPosition.at(moment2, this).getElevation();
        if (elevation <= ARC_MIN) {
            return moment;
        }
        if (d2 == 0.0d) {
            d3 = 90.0d;
        } else {
            d3 = Math.toDegrees(Math.atan(d / d2));
        }
        double d4 = d3;
        if (d4 > elevation + ARC_MIN) {
            return null;
        }
        return timeOfShadow(moment.getPosixTime(), moment2.getPosixTime(), d4);
    }

    private Moment timeOfShadow(long j, long j2, double d) {
        double d2 = d;
        Moment of = Moment.of(MathUtils.safeAdd(j, j2) / 2, TimeScale.POSIX);
        double elevation = SunPosition.at(of, this).getElevation();
        if (Math.abs(elevation - d2) < ARC_MIN) {
            return of;
        }
        if (((double) Double.compare(d2, elevation)) > 0.0d) {
            return timeOfShadow(of.getPosixTime(), j2, d);
        }
        return timeOfShadow(j, of.getPosixTime(), d);
    }

    private static TimeUnit precision(String str) {
        return str.equals(StdSolarCalculator.SIMPLE.name()) ? TimeUnit.MINUTES : TimeUnit.SECONDS;
    }

    private double geodeticAngle() {
        return getCalculator().getGeodeticAngle(this.latitude, this.altitude);
    }

    /* access modifiers changed from: private */
    public double zenithAngle() {
        return getCalculator().getZenithAngle(this.latitude, this.altitude);
    }

    private static void check(double d, double d2, int i, String str) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException("Latitude must be a finite value: " + d);
        } else if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException("Longitude must be a finite value: " + d2);
        } else if (Double.compare(d, 90.0d) > 0 || Double.compare(d, -90.0d) < 0) {
            throw new IllegalArgumentException("Degrees out of range -90.0 <= latitude <= +90.0: " + d);
        } else if (Double.compare(d2, 180.0d) >= 0 || Double.compare(d2, -180.0d) < 0) {
            throw new IllegalArgumentException("Degrees out of range -180.0 <= longitude < +180.0: " + d2);
        } else {
            double d3 = (double) i;
            if (Double.isNaN(d3) || Double.isInfinite(d3)) {
                throw new IllegalArgumentException("Altitude must be finite: " + i);
            } else if (i < 0 || i >= 11000) {
                throw new IllegalArgumentException("Meters out of range 0 <= altitude < +11,000: " + i);
            } else if (str.isEmpty()) {
                throw new IllegalArgumentException("Missing calculator.");
            } else if (!CALCULATORS.containsKey(str)) {
                throw new IllegalArgumentException("Unknown calculator: " + str);
            }
        }
    }

    /* access modifiers changed from: private */
    public CalendarDate toLMT(CalendarDate calendarDate) {
        if (this.observerZoneID == null || Math.abs(this.longitude) < 150.0d) {
            return calendarDate;
        }
        PlainTimestamp at = toGregorian(calendarDate).at(PlainTime.of(12));
        if (at.isValid(this.observerZoneID)) {
            return at.inTimezone(this.observerZoneID).toZonalTimestamp((TZID) ZonalOffset.atLongitude(new BigDecimal(this.longitude))).getCalendarDate();
        }
        throw new ChronoException("Calendar date does not exist in zone: " + calendarDate + " (" + this.observerZoneID.canonical() + ")");
    }

    private static boolean equalZones(TZID tzid, TZID tzid2) {
        if (tzid == null) {
            return tzid2 == null;
        }
        if (tzid2 == null) {
            return false;
        }
        return tzid.canonical().equals(tzid2.canonical());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        check(this.latitude, this.longitude, this.altitude, this.calculator);
    }

    public static class Builder {
        private int altitude;
        private String calculator;
        private double latitude;
        private double longitude;
        private TZID observerZoneID;

        private Builder() {
            this.latitude = Double.NaN;
            this.longitude = Double.NaN;
            this.altitude = 0;
            this.calculator = SolarTime.DEFAULT_CALCULATOR.name();
            this.observerZoneID = null;
        }

        public Builder northernLatitude(int i, int i2, double d) {
            check(i, i2, d, 90);
            if (Double.isNaN(this.latitude)) {
                this.latitude = ((double) i) + (((double) i2) / 60.0d) + (d / 3600.0d);
                return this;
            }
            throw new IllegalStateException("Latitude has already been set.");
        }

        public Builder southernLatitude(int i, int i2, double d) {
            check(i, i2, d, 90);
            if (Double.isNaN(this.latitude)) {
                this.latitude = (((double) i) + (((double) i2) / 60.0d) + (d / 3600.0d)) * -1.0d;
                return this;
            }
            throw new IllegalStateException("Latitude has already been set.");
        }

        public Builder easternLongitude(int i, int i2, double d) {
            check(i, i2, d, 179);
            if (Double.isNaN(this.longitude)) {
                this.longitude = ((double) i) + (((double) i2) / 60.0d) + (d / 3600.0d);
                return this;
            }
            throw new IllegalStateException("Longitude has already been set.");
        }

        public Builder westernLongitude(int i, int i2, double d) {
            check(i, i2, d, 180);
            if (Double.isNaN(this.longitude)) {
                this.longitude = (((double) i) + (((double) i2) / 60.0d) + (d / 3600.0d)) * -1.0d;
                return this;
            }
            throw new IllegalStateException("Longitude has already been set.");
        }

        public Builder atAltitude(int i) {
            double d = (double) i;
            if (Double.isInfinite(d) || Double.isNaN(d)) {
                throw new IllegalArgumentException("Altitude must be finite: " + i);
            } else if (i < 0 || i >= 11000) {
                throw new IllegalArgumentException("Meters out of range 0 <= altitude < +11,000: " + i);
            } else {
                this.altitude = i;
                return this;
            }
        }

        public Builder usingCalculator(String str) {
            if (str.isEmpty()) {
                throw new IllegalArgumentException("Missing calculator.");
            } else if (SolarTime.CALCULATORS.containsKey(str)) {
                this.calculator = str;
                return this;
            } else {
                throw new IllegalArgumentException("Unknown calculator: " + str);
            }
        }

        public Builder usingCalculator(Calculator calculator2) {
            SolarTime.CALCULATORS.putIfAbsent(calculator2.name(), calculator2);
            this.calculator = calculator2.name();
            return this;
        }

        public Builder inTimezone(TZID tzid) {
            Objects.requireNonNull(tzid, "Missing timezone identifier.");
            this.observerZoneID = tzid;
            return this;
        }

        public SolarTime build() {
            if (Double.isNaN(this.latitude)) {
                throw new IllegalStateException("Latitude was not yet set.");
            } else if (!Double.isNaN(this.longitude)) {
                return new SolarTime(this.latitude, this.longitude, this.altitude, this.calculator, this.observerZoneID);
            } else {
                throw new IllegalStateException("Longitude was not yet set.");
            }
        }

        private static void check(int i, int i2, double d, int i3) {
            if (i < 0 || i > i3 || (i == i3 && i3 != 179 && (i2 > 0 || Double.compare(d, 0.0d) > 0))) {
                double d2 = ((double) i) + (((double) i2) / 60.0d) + (d / 3600.0d);
                throw new IllegalArgumentException("Degrees out of range: " + i + " (decimal=" + d2 + ")");
            } else if (i2 < 0 || i2 >= 60) {
                throw new IllegalArgumentException("Arc minutes out of range: " + i2);
            } else if (Double.isNaN(d) || Double.isInfinite(d)) {
                throw new IllegalArgumentException("Arc seconds must be finite.");
            } else if (Double.compare(d, 0.0d) < 0 || Double.compare(d, 60.0d) >= 0) {
                throw new IllegalArgumentException("Arc seconds out of range: " + d);
            }
        }
    }

    public static class Sunshine {
        private final PlainTimestamp endLocal;
        private final Moment endUTC;
        private final PlainTimestamp startLocal;
        private final Moment startUTC;

        private Sunshine(PlainDate plainDate, Moment moment, Moment moment2, TZID tzid, boolean z) {
            Timezone of = Timezone.of(tzid);
            boolean z2 = of.getHistory() != null;
            if (z) {
                this.startUTC = null;
                this.endUTC = null;
                this.startLocal = null;
                this.endLocal = null;
            } else if (moment != null) {
                this.startUTC = moment;
                this.startLocal = moment.toZonalTimestamp(tzid);
                if (moment2 != null) {
                    this.endUTC = moment2;
                    this.endLocal = moment2.toZonalTimestamp(tzid);
                } else if (z2) {
                    PlainDate plainDate2 = (PlainDate) plainDate.plus(1, CalendarUnit.DAYS);
                    this.endUTC = plainDate2.atFirstMoment(tzid);
                    this.endLocal = plainDate2.atStartOfDay(tzid);
                } else {
                    Moment in = ((PlainDate) plainDate.plus(1, CalendarUnit.DAYS)).atStartOfDay().in(of);
                    this.endUTC = in;
                    this.endLocal = in.toZonalTimestamp(tzid);
                }
            } else if (moment2 != null) {
                if (z2) {
                    this.startUTC = plainDate.atFirstMoment(tzid);
                    this.startLocal = plainDate.atStartOfDay(tzid);
                    this.endUTC = moment2;
                    this.endLocal = moment2.toZonalTimestamp(tzid);
                    return;
                }
                Moment in2 = plainDate.atStartOfDay().in(of);
                this.startUTC = in2;
                this.startLocal = in2.toZonalTimestamp(tzid);
                this.endUTC = moment2;
                this.endLocal = moment2.toZonalTimestamp(tzid);
            } else if (z2) {
                this.startUTC = plainDate.atFirstMoment(tzid);
                this.startLocal = plainDate.atStartOfDay(tzid);
                PlainDate plainDate3 = (PlainDate) plainDate.plus(1, CalendarUnit.DAYS);
                this.endUTC = plainDate3.atFirstMoment(tzid);
                this.endLocal = plainDate3.atStartOfDay(tzid);
            } else {
                Moment in3 = plainDate.atStartOfDay().in(of);
                this.startUTC = in3;
                this.startLocal = in3.toZonalTimestamp(tzid);
                Moment in4 = ((PlainDate) plainDate.plus(1, CalendarUnit.DAYS)).atStartOfDay().in(of);
                this.endUTC = in4;
                this.endLocal = in4.toZonalTimestamp(tzid);
            }
        }

        public Moment startUTC() {
            return (Moment) checkAndGet(this.startUTC);
        }

        public Moment endUTC() {
            return (Moment) checkAndGet(this.endUTC);
        }

        public PlainTimestamp startLocal() {
            return (PlainTimestamp) checkAndGet(this.startLocal);
        }

        public PlainTimestamp endLocal() {
            return (PlainTimestamp) checkAndGet(this.endLocal);
        }

        public boolean isPresent(Moment moment) {
            if (!isAbsent() && !this.startUTC.isAfter((UniversalTime) moment) && moment.isBefore((UniversalTime) this.endUTC)) {
                return true;
            }
            return false;
        }

        public boolean isPresent(PlainTimestamp plainTimestamp) {
            if (!isAbsent() && !this.startLocal.isAfter(plainTimestamp) && plainTimestamp.isBefore(this.endLocal)) {
                return true;
            }
            return false;
        }

        public boolean isAbsent() {
            return this.startUTC == null;
        }

        public int length() {
            if (isAbsent()) {
                return 0;
            }
            return (int) this.startUTC.until(this.endUTC, TimeUnit.SECONDS);
        }

        public String toString() {
            if (isAbsent()) {
                return "Polar night";
            }
            StringBuilder sb = new StringBuilder(128);
            sb.append("Sunshine[");
            sb.append("utc=");
            sb.append(this.startUTC);
            sb.append('/');
            sb.append(this.endUTC);
            sb.append(",local=");
            sb.append(this.startLocal);
            sb.append('/');
            sb.append(this.endLocal);
            sb.append(",length=");
            sb.append(length());
            sb.append(AbstractJsonLexerKt.END_LIST);
            return sb.toString();
        }

        private static <T> T checkAndGet(T t) {
            if (t != null) {
                return t;
            }
            throw new IllegalStateException("Sunshine is absent (polar night).");
        }
    }
}
