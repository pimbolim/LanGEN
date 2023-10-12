package net.time4j.calendar.astro;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.CalendarUnit;
import net.time4j.Moment;
import net.time4j.PlainDate;
import net.time4j.PlainTimestamp;
import net.time4j.scale.UniversalTime;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;

public final class LunarTime implements GeoLocation, Serializable {
    private static final int MRD = 1000000000;
    private static final long serialVersionUID = -8029871830105935048L;
    private final int altitude;
    private final double latitude;
    private final double longitude;
    private final TZID observerZoneID;

    private static double toJulianCenturies(double d) {
        return (d - 51544.5d) / 36525.0d;
    }

    private LunarTime(double d, double d2, int i, TZID tzid) {
        check(d, d2, i, tzid);
        this.latitude = d;
        this.longitude = d2;
        this.altitude = i;
        this.observerZoneID = tzid;
    }

    public static Builder ofLocation(TZID tzid) {
        Objects.requireNonNull(tzid, "Missing observer timezone.");
        return new Builder(tzid);
    }

    public static LunarTime ofLocation(TZID tzid, double d, double d2) {
        return ofLocation(tzid, d, d2, 0);
    }

    public static LunarTime ofLocation(TZID tzid, double d, double d2, int i) {
        return new LunarTime(d, d2, i, tzid);
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

    public TZID getObserverZoneID() {
        return this.observerZoneID;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LunarTime)) {
            return false;
        }
        LunarTime lunarTime = (LunarTime) obj;
        if (this.altitude == lunarTime.altitude && Double.compare(this.latitude, lunarTime.latitude) == 0 && Double.compare(this.longitude, lunarTime.longitude) == 0 && this.observerZoneID.canonical().equals(lunarTime.observerZoneID.canonical())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (AstroUtils.hashCode(this.latitude) * 7) + (AstroUtils.hashCode(this.longitude) * 31) + (this.altitude * 37);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LunarTime[");
        sb.append(",observer-tz=");
        sb.append(this.observerZoneID.canonical());
        sb.append(",latitude=");
        sb.append(this.latitude);
        sb.append(",longitude=");
        sb.append(this.longitude);
        if (this.altitude != 0) {
            sb.append(",altitude=");
            sb.append(this.altitude);
        }
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0135, code lost:
        if (r4.toZonalTimestamp(r0.observerZoneID).getCalendarDate().equals(r2) == false) goto L_0x0137;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.time4j.calendar.astro.LunarTime.Moonlight on(net.time4j.engine.CalendarDate r54) {
        /*
            r53 = this;
            r0 = r53
            net.time4j.PlainDate r2 = net.time4j.calendar.astro.SolarTime.toGregorian(r54)
            net.time4j.tz.TZID r1 = r0.observerZoneID
            net.time4j.tz.Timezone r1 = net.time4j.tz.Timezone.of((net.time4j.tz.TZID) r1)
            net.time4j.tz.TransitionHistory r3 = r1.getHistory()
            if (r3 != 0) goto L_0x001f
            net.time4j.PlainTime r3 = net.time4j.PlainTime.midnightAtStartOfDay()
            net.time4j.PlainTimestamp r3 = r2.at(r3)
            net.time4j.Moment r1 = r3.in(r1)
            goto L_0x0025
        L_0x001f:
            net.time4j.tz.TZID r1 = r0.observerZoneID
            net.time4j.Moment r1 = r2.atFirstMoment((net.time4j.tz.TZID) r1)
        L_0x0025:
            net.time4j.calendar.astro.JulianDay r3 = net.time4j.calendar.astro.JulianDay.ofMeanSolarTime((net.time4j.Moment) r1)
            double r20 = r3.getMJD()
            double r3 = r0.longitude
            double r22 = java.lang.Math.toRadians(r3)
            double r3 = r0.latitude
            double r3 = java.lang.Math.toRadians(r3)
            double r24 = java.lang.Math.cos(r3)
            double r3 = r0.latitude
            double r3 = java.lang.Math.toRadians(r3)
            double r26 = java.lang.Math.sin(r3)
            net.time4j.calendar.astro.StdSolarCalculator r3 = net.time4j.calendar.astro.StdSolarCalculator.TIME4J
            double r4 = r0.latitude
            int r6 = r0.altitude
            double r28 = r3.getGeodeticAngle(r4, r6)
            int r3 = r0.altitude
            double r3 = net.time4j.calendar.astro.AstroUtils.refractionFactorOfStdAtmosphere(r3)
            r5 = 4629981891913580544(0x4041000000000000, double:34.0)
            double r3 = r3 * r5
            r5 = 4633641066610819072(0x404e000000000000, double:60.0)
            double r30 = r3 / r5
            double r32 = net.time4j.scale.TimeScale.deltaT(r2)
            r6 = 0
            r4 = r20
            r8 = r22
            r10 = r24
            r12 = r26
            r14 = r28
            r16 = r30
            r18 = r32
            double r3 = sinAlt(r4, r6, r8, r10, r12, r14, r16, r18)
            r5 = 4
            double[] r14 = new double[r5]
            r5 = 0
            r34 = 0
            r15 = 1
            int r6 = (r3 > r34 ? 1 : (r3 == r34 ? 0 : -1))
            if (r6 <= 0) goto L_0x0085
            r36 = 1
            goto L_0x0087
        L_0x0085:
            r36 = 0
        L_0x0087:
            r6 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            r37 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r39 = r3
            r42 = r6
            r44 = r42
            r46 = r37
            r3 = 0
            r41 = 0
        L_0x0096:
            r4 = r20
            r6 = r46
            r8 = r22
            r10 = r24
            r12 = r26
            r54 = r3
            r48 = r14
            r3 = 1
            r14 = r28
            r16 = r30
            r18 = r32
            double r49 = sinAlt(r4, r6, r8, r10, r12, r14, r16, r18)
            double r6 = r46 + r37
            double r4 = sinAlt(r4, r6, r8, r10, r12, r14, r16, r18)
            r6 = r39
            r8 = r49
            r10 = r4
            r12 = r48
            int r6 = interpolate(r6, r8, r10, r12)
            r7 = 3
            r8 = 2
            if (r6 != r3) goto L_0x00dd
            r8 = r48[r8]
            boolean r6 = java.lang.Double.isNaN(r8)
            if (r6 == 0) goto L_0x00ce
            r8 = r48[r7]
        L_0x00ce:
            int r6 = (r39 > r34 ? 1 : (r39 == r34 ? 0 : -1))
            if (r6 >= 0) goto L_0x00d6
            double r42 = r46 + r8
            r15 = 1
            goto L_0x0101
        L_0x00d6:
            double r44 = r46 + r8
            r15 = r54
            r41 = 1
            goto L_0x0101
        L_0x00dd:
            if (r6 != r8) goto L_0x00ff
            r9 = r48[r3]
            int r6 = (r9 > r34 ? 1 : (r9 == r34 ? 0 : -1))
            if (r6 >= 0) goto L_0x00ee
            r6 = r48[r7]
            double r6 = r46 + r6
            r8 = r48[r8]
            double r8 = r46 + r8
            goto L_0x00fb
        L_0x00ee:
            r8 = r48[r8]
            double r8 = r46 + r8
            r6 = r48[r7]
            double r6 = r46 + r6
            r51 = r6
            r6 = r8
            r8 = r51
        L_0x00fb:
            r15 = 1
            r41 = 1
            goto L_0x0105
        L_0x00ff:
            r15 = r54
        L_0x0101:
            r6 = r42
            r8 = r44
        L_0x0105:
            r10 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r46 = r46 + r10
            r10 = 4627730092099895296(0x4039000000000000, double:25.0)
            int r12 = (r46 > r10 ? 1 : (r46 == r10 ? 0 : -1))
            if (r12 > 0) goto L_0x0120
            if (r15 == 0) goto L_0x0114
            if (r41 == 0) goto L_0x0114
            goto L_0x0120
        L_0x0114:
            r39 = r4
            r42 = r6
            r44 = r8
            r3 = r15
            r14 = r48
            r15 = 1
            goto L_0x0096
        L_0x0120:
            r3 = 0
            if (r15 == 0) goto L_0x0137
            net.time4j.Moment r4 = add(r1, r6)
            net.time4j.tz.TZID r5 = r0.observerZoneID
            net.time4j.PlainTimestamp r5 = r4.toZonalTimestamp((net.time4j.tz.TZID) r5)
            net.time4j.PlainDate r5 = r5.getCalendarDate()
            boolean r5 = r5.equals(r2)
            if (r5 != 0) goto L_0x0138
        L_0x0137:
            r4 = r3
        L_0x0138:
            if (r41 == 0) goto L_0x0151
            net.time4j.Moment r1 = add(r1, r8)
            net.time4j.tz.TZID r5 = r0.observerZoneID
            net.time4j.PlainTimestamp r5 = r1.toZonalTimestamp((net.time4j.tz.TZID) r5)
            net.time4j.PlainDate r5 = r5.getCalendarDate()
            boolean r5 = r5.equals(r2)
            if (r5 != 0) goto L_0x014f
            goto L_0x0151
        L_0x014f:
            r5 = r1
            goto L_0x0152
        L_0x0151:
            r5 = r3
        L_0x0152:
            net.time4j.calendar.astro.LunarTime$Moonlight r8 = new net.time4j.calendar.astro.LunarTime$Moonlight
            net.time4j.tz.TZID r3 = r0.observerZoneID
            r7 = 0
            r1 = r8
            r6 = r36
            r1.<init>(r2, r3, r4, r5, r6)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.astro.LunarTime.on(net.time4j.engine.CalendarDate):net.time4j.calendar.astro.LunarTime$Moonlight");
    }

    private static Moment add(Moment moment, double d) {
        double d2 = d * 3600.0d;
        long floor = (long) Math.floor(d2);
        return (Moment) ((Moment) ((Moment) moment.plus(floor, TimeUnit.SECONDS)).plus((long) ((d2 - ((double) floor)) * 1.0E9d), TimeUnit.NANOSECONDS)).with(Moment.PRECISION, TimeUnit.SECONDS);
    }

    private static double sinAlt(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        double d9 = (d2 / 24.0d) + d;
        double[] calculateMeeus47 = MoonPosition.calculateMeeus47(toJulianCenturies((d8 / 86400.0d) + d9));
        double gmst = ((AstroUtils.gmst(d9) + Math.toRadians(calculateMeeus47[0] * Math.cos(Math.toRadians(calculateMeeus47[1])))) + d3) - Math.toRadians(calculateMeeus47[2]);
        double radians = Math.toRadians(calculateMeeus47[3]);
        return ((Math.sin(radians) * d5) + ((Math.cos(radians) * d4) * Math.cos(gmst))) - Math.sin(Math.toRadians(((getHorizontalParallax(calculateMeeus47[4]) * 0.7275d) - d7) - d6));
    }

    private static int interpolate(double d, double d2, double d3, double[] dArr) {
        double d4;
        int i;
        double d5 = ((d3 + d) * 0.5d) - d2;
        double d6 = (d3 - d) * 0.5d;
        double d7 = (-d6) / (2.0d * d5);
        double d8 = (((d5 * d7) + d6) * d7) + d2;
        double d9 = (d6 * d6) - ((4.0d * d5) * d2);
        double d10 = Double.NaN;
        if (d9 >= 0.0d) {
            double sqrt = (Math.sqrt(d9) * 0.5d) / Math.abs(d5);
            double d11 = d7 - sqrt;
            if (Math.abs(d11) <= 1.0d) {
                i = 1;
            } else {
                d11 = Double.NaN;
                i = 0;
            }
            d4 = sqrt + d7;
            if (Math.abs(d4) <= 1.0d) {
                i++;
            } else {
                d4 = Double.NaN;
            }
            d10 = d11;
        } else {
            d4 = Double.NaN;
            i = 0;
        }
        dArr[0] = d7;
        dArr[1] = d8;
        dArr[2] = d10;
        dArr[3] = d4;
        return i;
    }

    private static double getHorizontalParallax(double d) {
        return Math.toDegrees(Math.asin(6378.14d / d));
    }

    private static void check(double d, double d2, int i, TZID tzid) {
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
            } else {
                Timezone.of(tzid);
            }
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        check(this.latitude, this.longitude, this.altitude, this.observerZoneID);
    }

    public static class Builder {
        private int altitude;
        private double latitude;
        private double longitude;
        private final TZID observerZoneID;

        private Builder(TZID tzid) {
            this.latitude = Double.NaN;
            this.longitude = Double.NaN;
            this.altitude = 0;
            this.observerZoneID = tzid;
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

        public LunarTime build() {
            if (Double.isNaN(this.latitude)) {
                throw new IllegalStateException("Latitude was not yet set.");
            } else if (!Double.isNaN(this.longitude)) {
                return new LunarTime(this.latitude, this.longitude, this.altitude, this.observerZoneID);
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

    public static class Moonlight {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final boolean above;
        private final Moment endOfDay;
        private final Moment moonrise;
        private final Moment moonset;
        private final TZID observerZoneID;
        private final Moment startOfDay;

        static {
            Class<LunarTime> cls = LunarTime.class;
        }

        private Moonlight(PlainDate plainDate, TZID tzid, Moment moment, Moment moment2, boolean z) {
            this.observerZoneID = tzid;
            Timezone of = Timezone.of(tzid);
            PlainDate plainDate2 = (PlainDate) plainDate.plus(1, CalendarUnit.DAYS);
            if (of.getHistory() == null) {
                this.startOfDay = plainDate.atStartOfDay().in(of);
                this.endOfDay = plainDate2.atStartOfDay().in(of);
            } else {
                this.startOfDay = plainDate.atFirstMoment(tzid);
                this.endOfDay = plainDate2.atFirstMoment(tzid);
            }
            this.moonrise = moment;
            this.moonset = moment2;
            this.above = z;
        }

        public Moment moonrise() {
            return this.moonrise;
        }

        public PlainTimestamp moonriseLocal() {
            Moment moment = this.moonrise;
            if (moment == null) {
                return null;
            }
            return moment.toZonalTimestamp(this.observerZoneID);
        }

        public PlainTimestamp moonrise(TZID tzid) {
            Moment moment = this.moonrise;
            if (moment == null) {
                return null;
            }
            return moment.toZonalTimestamp(tzid);
        }

        public Moment moonset() {
            return this.moonset;
        }

        public PlainTimestamp moonsetLocal() {
            Moment moment = this.moonset;
            if (moment == null) {
                return null;
            }
            return moment.toZonalTimestamp(this.observerZoneID);
        }

        public PlainTimestamp moonset(TZID tzid) {
            Moment moment = this.moonset;
            if (moment == null) {
                return null;
            }
            return moment.toZonalTimestamp(tzid);
        }

        public boolean isPresent(Moment moment) {
            if (moment.isBefore((UniversalTime) this.startOfDay) || !moment.isBefore((UniversalTime) this.endOfDay)) {
                return false;
            }
            Moment moment2 = this.moonrise;
            if (moment2 == null) {
                Moment moment3 = this.moonset;
                if (moment3 == null) {
                    return this.above;
                }
                return moment.isBefore((UniversalTime) moment3);
            }
            Moment moment4 = this.moonset;
            if (moment4 == null) {
                return !moment.isBefore((UniversalTime) moment2);
            }
            if (moment2.isBefore((UniversalTime) moment4)) {
                if (moment.isBefore((UniversalTime) this.moonrise) || !moment.isBefore((UniversalTime) this.moonset)) {
                    return false;
                }
                return true;
            } else if (moment.isBefore((UniversalTime) this.moonset) || !moment.isBefore((UniversalTime) this.moonrise)) {
                return true;
            } else {
                return false;
            }
        }

        public boolean isPresentAllDay() {
            return this.above && this.moonrise == null && this.moonset == null;
        }

        public boolean isAbsent() {
            return length() == 0;
        }

        public int length() {
            long until;
            Moment moment = this.moonrise;
            if (moment == null) {
                Moment moment2 = this.moonset;
                if (moment2 != null) {
                    until = this.startOfDay.until(moment2, TimeUnit.SECONDS);
                } else if (!this.above) {
                    return 0;
                } else {
                    until = this.startOfDay.until(this.endOfDay, TimeUnit.SECONDS);
                }
            } else {
                Moment moment3 = this.moonset;
                if (moment3 == null) {
                    until = moment.until(this.endOfDay, TimeUnit.SECONDS);
                } else if (moment.isBefore((UniversalTime) moment3)) {
                    until = this.moonrise.until(this.moonset, TimeUnit.SECONDS);
                } else {
                    until = this.startOfDay.until(this.moonset, TimeUnit.SECONDS) + this.moonrise.until(this.endOfDay, TimeUnit.SECONDS);
                }
            }
            return (int) until;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Moonlight[");
            sb.append("tz=");
            sb.append(this.observerZoneID.canonical());
            sb.append(" | ");
            Moment moment = this.moonrise;
            if (moment != null) {
                Moment moment2 = this.moonset;
                if (moment2 == null) {
                    sb.append("moonrise=");
                    sb.append(this.moonrise.toZonalTimestamp(this.observerZoneID));
                } else if (moment.isBefore((UniversalTime) moment2)) {
                    sb.append("moonrise=");
                    sb.append(this.moonrise.toZonalTimestamp(this.observerZoneID));
                    sb.append(" | moonset=");
                    sb.append(this.moonset.toZonalTimestamp(this.observerZoneID));
                } else {
                    sb.append("moonset=");
                    sb.append(this.moonset.toZonalTimestamp(this.observerZoneID));
                    sb.append(" | moonrise=");
                    sb.append(this.moonrise.toZonalTimestamp(this.observerZoneID));
                }
            } else if (this.moonset == null) {
                sb.append("always ");
                sb.append(this.above ? "up" : "down");
            } else {
                sb.append("moonset=");
                sb.append(this.moonset.toZonalTimestamp(this.observerZoneID));
            }
            sb.append(" | length=");
            sb.append(length());
            sb.append(AbstractJsonLexerKt.END_LIST);
            return sb.toString();
        }
    }
}
