package net.time4j;

import androidx.compose.animation.core.AnimationKt;
import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.base.GregorianDate;
import net.time4j.base.GregorianMath;
import net.time4j.base.MathUtils;
import net.time4j.base.UnixTime;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.BridgeChronology;
import net.time4j.engine.CalendarFamily;
import net.time4j.engine.CalendarVariant;
import net.time4j.engine.Calendrical;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.ChronoMerger;
import net.time4j.engine.ChronoOperator;
import net.time4j.engine.Chronology;
import net.time4j.engine.Converter;
import net.time4j.engine.DisplayStyle;
import net.time4j.engine.ElementRule;
import net.time4j.engine.EpochDays;
import net.time4j.engine.FlagElement;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.Temporal;
import net.time4j.engine.TimeAxis;
import net.time4j.engine.TimeLine;
import net.time4j.engine.TimePoint;
import net.time4j.engine.UnitRule;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.CalendarType;
import net.time4j.format.DisplayMode;
import net.time4j.format.TemporalFormatter;
import net.time4j.scale.LeapSecondEvent;
import net.time4j.scale.LeapSeconds;
import net.time4j.scale.TimeScale;
import net.time4j.scale.UniversalTime;
import net.time4j.tz.OverlapResolver;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.TransitionStrategy;
import net.time4j.tz.ZonalOffset;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

@CalendarType("iso8601")
public final class Moment extends TimePoint<TimeUnit, Moment> implements UniversalTime, Temporal<UniversalTime> {
    private static final TimeAxis<TimeUnit, Moment> ENGINE;
    public static final ChronoElement<Integer> FRACTION = IntElement.FRACTION;
    /* access modifiers changed from: private */
    public static final Set<ChronoElement<?>> HIGH_TIME_ELEMENTS;
    /* access modifiers changed from: private */
    public static final Map<ChronoElement<?>, Integer> LOW_TIME_ELEMENTS;
    private static final Moment MAX;
    /* access modifiers changed from: private */
    public static final long MAX_LIMIT;
    private static final Moment MIN;
    /* access modifiers changed from: private */
    public static final long MIN_LIMIT;
    private static final int MIO = 1000000;
    private static final int MRD = 1000000000;
    private static final ChronoOperator<Moment> NEXT_LS = new NextLS((AnonymousClass1) null);
    private static final int POSITIVE_LEAP_MASK = 1073741824;
    private static final long POSIX_GPS_DELTA = 315964800;
    public static final ChronoElement<Long> POSIX_TIME = LongElement.POSIX_TIME;
    private static final long POSIX_UTC_DELTA = 63072000;
    public static final ChronoElement<TimeUnit> PRECISION = PrecisionElement.TIME_PRECISION;
    /* access modifiers changed from: private */
    public static final Moment START_LS_CHECK = new Moment(63158400, 0, TimeScale.POSIX);
    private static final Map<TimeUnit, Double> UNIT_LENGTHS;
    public static final Moment UNIX_EPOCH = new Moment(0, 0, TimeScale.POSIX);
    private static final long UTC_GPS_DELTA = 252892809;
    private static final long UTC_TAI_DELTA = 441763200;
    private static final long serialVersionUID = -3192884724477742274L;
    private final transient int fraction;
    /* access modifiers changed from: private */
    public final transient long posixTime;

    /* access modifiers changed from: protected */
    public Moment getContext() {
        return this;
    }

    /* synthetic */ Moment(int i, long j, AnonymousClass1 r4) {
        this(i, j);
    }

    static {
        long mjd = GregorianMath.toMJD(-999999999, 1, 1);
        long mjd2 = GregorianMath.toMJD(999999999, 12, 31);
        long transform = EpochDays.UNIX.transform(mjd, EpochDays.MODIFIED_JULIAN_DATE) * 86400;
        MIN_LIMIT = transform;
        long transform2 = (EpochDays.UNIX.transform(mjd2, EpochDays.MODIFIED_JULIAN_DATE) * 86400) + 86399;
        MAX_LIMIT = transform2;
        Moment moment = new Moment(transform, 0, TimeScale.POSIX);
        MIN = moment;
        Moment moment2 = new Moment(transform2, 999999999, TimeScale.POSIX);
        MAX = moment2;
        HashSet hashSet = new HashSet();
        hashSet.add(PlainTime.HOUR_FROM_0_TO_24);
        hashSet.add(PlainTime.DIGITAL_HOUR_OF_DAY);
        hashSet.add(PlainTime.DIGITAL_HOUR_OF_AMPM);
        hashSet.add(PlainTime.CLOCK_HOUR_OF_DAY);
        hashSet.add(PlainTime.CLOCK_HOUR_OF_AMPM);
        hashSet.add(PlainTime.AM_PM_OF_DAY);
        hashSet.add(PlainTime.MINUTE_OF_HOUR);
        hashSet.add(PlainTime.MINUTE_OF_DAY);
        HIGH_TIME_ELEMENTS = Collections.unmodifiableSet(hashSet);
        HashMap hashMap = new HashMap();
        hashMap.put(PlainTime.SECOND_OF_MINUTE, 1);
        hashMap.put(PlainTime.SECOND_OF_DAY, 1);
        hashMap.put(PlainTime.MILLI_OF_SECOND, 1000);
        hashMap.put(PlainTime.MILLI_OF_DAY, 1000);
        hashMap.put(PlainTime.MICRO_OF_SECOND, 1000000);
        hashMap.put(PlainTime.MICRO_OF_DAY, 1000000);
        ProportionalElement<Integer, PlainTime> proportionalElement = PlainTime.NANO_OF_SECOND;
        Integer valueOf = Integer.valueOf(MRD);
        hashMap.put(proportionalElement, valueOf);
        hashMap.put(PlainTime.NANO_OF_DAY, valueOf);
        LOW_TIME_ELEMENTS = Collections.unmodifiableMap(hashMap);
        EnumMap enumMap = new EnumMap(TimeUnit.class);
        enumMap.put(TimeUnit.DAYS, Double.valueOf(86400.0d));
        enumMap.put(TimeUnit.HOURS, Double.valueOf(3600.0d));
        enumMap.put(TimeUnit.MINUTES, Double.valueOf(60.0d));
        enumMap.put(TimeUnit.SECONDS, Double.valueOf(1.0d));
        enumMap.put(TimeUnit.MILLISECONDS, Double.valueOf(0.001d));
        enumMap.put(TimeUnit.MICROSECONDS, Double.valueOf(1.0E-6d));
        enumMap.put(TimeUnit.NANOSECONDS, Double.valueOf(1.0E-9d));
        UNIT_LENGTHS = Collections.unmodifiableMap(enumMap);
        TimeAxis.Builder<U, Moment> up = TimeAxis.Builder.setUp(TimeUnit.class, Moment.class, new Merger((AnonymousClass1) null), moment, moment2);
        for (TimeUnit timeUnit : TimeUnit.values()) {
            TimeUnitRule timeUnitRule = new TimeUnitRule(timeUnit);
            Map<TimeUnit, Double> map = UNIT_LENGTHS;
            up.appendUnit(timeUnit, timeUnitRule, map.get(timeUnit).doubleValue(), map.keySet());
        }
        up.appendElement(LongElement.POSIX_TIME, LongElement.POSIX_TIME, TimeUnit.SECONDS);
        up.appendElement(IntElement.FRACTION, IntElement.FRACTION, TimeUnit.NANOSECONDS);
        up.appendElement((ChronoElement) PrecisionElement.TIME_PRECISION, (ElementRule) new PrecisionRule((AnonymousClass1) null));
        ENGINE = up.withTimeLine(new GlobalTimeLine((AnonymousClass1) null)).build();
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0187  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Moment(long r18, int r20, net.time4j.scale.TimeScale r21) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r3 = r20
            r4 = r21
            r17.<init>()
            net.time4j.scale.TimeScale r5 = net.time4j.scale.TimeScale.POSIX
            if (r4 != r5) goto L_0x0015
            r0.posixTime = r1
            r0.fraction = r3
            goto L_0x018a
        L_0x0015:
            net.time4j.scale.LeapSeconds r5 = net.time4j.scale.LeapSeconds.getInstance()
            boolean r6 = r5.isEnabled()
            if (r6 == 0) goto L_0x01ae
            net.time4j.scale.TimeScale r6 = net.time4j.scale.TimeScale.UTC
            r7 = 1
            r9 = 0
            if (r4 != r6) goto L_0x0029
            goto L_0x0121
        L_0x0029:
            net.time4j.scale.TimeScale r6 = net.time4j.scale.TimeScale.TAI
            r13 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
            r11 = 1000000000(0x3b9aca00, float:0.0047237873)
            r12 = 184000000(0xaf79e00, float:2.3844668E-32)
            if (r4 != r6) goto L_0x00a3
            int r4 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r4 < 0) goto L_0x008c
            r15 = 441763200(0x1a54c580, double:2.182600207E-315)
            int r4 = (r1 > r15 ? 1 : (r1 == r15 ? 0 : -1))
            if (r4 >= 0) goto L_0x0081
            r9 = -441763168(0xffffffffe5ab3aa0, double:NaN)
            long r9 = net.time4j.base.MathUtils.safeAdd((long) r1, (long) r9)
            int r3 = net.time4j.base.MathUtils.safeAdd((int) r3, (int) r12)
            if (r3 < r11) goto L_0x0058
            long r9 = net.time4j.base.MathUtils.safeAdd((long) r9, (long) r7)
            int r3 = net.time4j.base.MathUtils.safeSubtract((int) r3, (int) r11)
        L_0x0058:
            double r9 = (double) r9
            double r3 = (double) r3
            double r3 = r3 / r13
            double r9 = r9 + r3
            r3 = 4631133687518280548(0x4045178d4fdf3b64, double:42.184)
            double r3 = r9 - r3
            long r3 = (long) r3
            r6 = 86400(0x15180, float:1.21072E-40)
            long r3 = net.time4j.base.MathUtils.floorDivide((long) r3, (int) r6)
            net.time4j.engine.EpochDays r6 = net.time4j.engine.EpochDays.UTC
            net.time4j.PlainDate r3 = net.time4j.PlainDate.of((long) r3, (net.time4j.engine.EpochDays) r6)
            double r3 = net.time4j.scale.TimeScale.deltaT(r3)
            double r9 = r9 - r3
            double r3 = java.lang.Math.floor(r9)
            long r3 = (long) r3
            int r6 = toNanos(r9, r3)
            goto L_0x0149
        L_0x0081:
            r9 = 441763210(0x1a54c58a, double:2.182600257E-315)
            long r9 = net.time4j.base.MathUtils.safeSubtract((long) r1, (long) r9)
            r6 = r3
            r3 = r9
            goto L_0x0149
        L_0x008c:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "TAI not supported before 1958-01-01: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r3.<init>(r1)
            throw r3
        L_0x00a3:
            net.time4j.scale.TimeScale r6 = net.time4j.scale.TimeScale.GPS
            if (r4 != r6) goto L_0x00cd
            r9 = 252892809(0xf12d689, double:1.24945649E-315)
            long r11 = net.time4j.base.MathUtils.safeAdd((long) r1, (long) r9)
            int r4 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r4 < 0) goto L_0x00b6
            r6 = r3
            r3 = r11
            goto L_0x0149
        L_0x00b6:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "GPS not supported before 1980-01-06: "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r3.<init>(r1)
            throw r3
        L_0x00cd:
            net.time4j.scale.TimeScale r6 = net.time4j.scale.TimeScale.TT
            if (r4 != r6) goto L_0x0117
            r9 = 42
            int r4 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r4 < 0) goto L_0x00ef
            if (r4 != 0) goto L_0x00dc
            if (r3 >= r12) goto L_0x00dc
            goto L_0x00ef
        L_0x00dc:
            long r1 = net.time4j.base.MathUtils.safeSubtract((long) r1, (long) r9)
            int r3 = net.time4j.base.MathUtils.safeSubtract((int) r3, (int) r12)
            if (r3 >= 0) goto L_0x0121
            long r1 = net.time4j.base.MathUtils.safeSubtract((long) r1, (long) r7)
            int r3 = net.time4j.base.MathUtils.safeAdd((int) r3, (int) r11)
            goto L_0x0121
        L_0x00ef:
            double r9 = (double) r1
            double r3 = (double) r3
            double r3 = r3 / r13
            double r9 = r9 + r3
            r3 = 4631133687518280548(0x4045178d4fdf3b64, double:42.184)
            double r3 = r9 - r3
            long r3 = (long) r3
            r6 = 86400(0x15180, float:1.21072E-40)
            long r3 = net.time4j.base.MathUtils.floorDivide((long) r3, (int) r6)
            net.time4j.engine.EpochDays r6 = net.time4j.engine.EpochDays.UTC
            net.time4j.PlainDate r3 = net.time4j.PlainDate.of((long) r3, (net.time4j.engine.EpochDays) r6)
            double r3 = net.time4j.scale.TimeScale.deltaT(r3)
            double r9 = r9 - r3
            double r3 = java.lang.Math.floor(r9)
            long r3 = (long) r3
            int r6 = toNanos(r9, r3)
            goto L_0x0149
        L_0x0117:
            net.time4j.scale.TimeScale r6 = net.time4j.scale.TimeScale.UT
            if (r4 != r6) goto L_0x0193
            r9 = 0
            int r4 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r4 >= 0) goto L_0x0124
        L_0x0121:
            r6 = r3
            r3 = r1
            goto L_0x0149
        L_0x0124:
            r4 = 86400(0x15180, float:1.21072E-40)
            long r9 = net.time4j.base.MathUtils.floorDivide((long) r1, (int) r4)
            net.time4j.engine.EpochDays r4 = net.time4j.engine.EpochDays.UTC
            net.time4j.PlainDate r4 = net.time4j.PlainDate.of((long) r9, (net.time4j.engine.EpochDays) r4)
            double r9 = (double) r1
            double r11 = (double) r3
            double r11 = r11 / r13
            double r9 = r9 + r11
            double r3 = net.time4j.scale.TimeScale.deltaT(r4)
            double r9 = r9 + r3
            r3 = 4631133687518280548(0x4045178d4fdf3b64, double:42.184)
            double r9 = r9 - r3
            double r3 = java.lang.Math.floor(r9)
            long r3 = (long) r3
            int r6 = toNanos(r9, r3)
        L_0x0149:
            long r9 = r5.strip(r3)
            long r11 = r5.enhance(r9)
            long r3 = r3 - r11
            r0.posixTime = r9
            r11 = 0
            int r5 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r5 == 0) goto L_0x0187
            long r11 = MAX_LIMIT
            int r5 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r5 != 0) goto L_0x0161
            goto L_0x0187
        L_0x0161:
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x016b
            r1 = 1073741824(0x40000000, float:2.0)
            r1 = r1 | r6
            r0.fraction = r1
            goto L_0x0189
        L_0x016b:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Cannot handle leap shift of "
            r4.append(r5)
            r4.append(r1)
            java.lang.String r1 = "."
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r3.<init>(r1)
            throw r3
        L_0x0187:
            r0.fraction = r6
        L_0x0189:
            r3 = r6
        L_0x018a:
            long r1 = r0.posixTime
            checkUnixTime(r1)
            checkFraction(r3)
            return
        L_0x0193:
            java.lang.UnsupportedOperationException r1 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Not yet implemented: "
            r2.append(r3)
            java.lang.String r3 = r21.name()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x01ae:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Leap seconds are not supported by configuration."
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.Moment.<init>(long, int, net.time4j.scale.TimeScale):void");
    }

    private Moment(int i, long j) {
        checkUnixTime(j);
        this.posixTime = j;
        this.fraction = i;
    }

    public static Moment of(long j, TimeScale timeScale) {
        return of(j, 0, timeScale);
    }

    public static Moment of(long j, int i, TimeScale timeScale) {
        if (j == 0 && i == 0 && timeScale == TimeScale.POSIX) {
            return UNIX_EPOCH;
        }
        return new Moment(j, i, timeScale);
    }

    public static Moment nowInSystemTime() {
        return SystemClock.INSTANCE.currentTime();
    }

    public static Moment from(UnixTime unixTime) {
        if (unixTime instanceof Moment) {
            return Moment.class.cast(unixTime);
        }
        if (!(unixTime instanceof UniversalTime) || !LeapSeconds.getInstance().isEnabled()) {
            return of(unixTime.getPosixTime(), unixTime.getNanosecond(), TimeScale.POSIX);
        }
        UniversalTime cast = UniversalTime.class.cast(unixTime);
        return of(cast.getElapsedTime(TimeScale.UTC), cast.getNanosecond(TimeScale.UTC), TimeScale.UTC);
    }

    public long getPosixTime() {
        return this.posixTime;
    }

    public long getElapsedTime(TimeScale timeScale) {
        long j;
        int i;
        switch (AnonymousClass1.$SwitchMap$net$time4j$scale$TimeScale[timeScale.ordinal()]) {
            case 1:
                return this.posixTime;
            case 2:
                return getElapsedTimeUTC();
            case 3:
                if (getElapsedTimeUTC() < 0) {
                    double deltaT = TimeScale.deltaT(getDateUTC()) + ((double) (this.posixTime - POSIX_UTC_DELTA)) + (((double) getNanosecond()) / 1.0E9d);
                    long floor = (long) Math.floor(deltaT);
                    if (Double.compare(1.0E9d - ((deltaT - ((double) floor)) * 1.0E9d), 1.0d) < 0) {
                        floor++;
                        i = 0;
                    } else {
                        i = toNanos(deltaT, floor);
                    }
                    j = (floor - 32) + UTC_TAI_DELTA;
                    if (i - 184000000 < 0) {
                        j--;
                    }
                } else {
                    j = getElapsedTimeUTC() + UTC_TAI_DELTA + 10;
                }
                if (j >= 0) {
                    return j;
                }
                throw new IllegalArgumentException("TAI not supported before 1958-01-01: " + this);
            case 4:
                long elapsedTimeUTC = getElapsedTimeUTC();
                if (LeapSeconds.getInstance().strip(elapsedTimeUTC) >= POSIX_GPS_DELTA) {
                    if (!LeapSeconds.getInstance().isEnabled()) {
                        elapsedTimeUTC += 9;
                    }
                    return elapsedTimeUTC - UTC_GPS_DELTA;
                }
                throw new IllegalArgumentException("GPS not supported before 1980-01-06: " + this);
            case 5:
                if (this.posixTime < POSIX_UTC_DELTA) {
                    double deltaT2 = TimeScale.deltaT(getDateUTC()) + ((double) (this.posixTime - POSIX_UTC_DELTA)) + (((double) getNanosecond()) / 1.0E9d);
                    long floor2 = (long) Math.floor(deltaT2);
                    return Double.compare(1.0E9d - ((deltaT2 - ((double) floor2)) * 1.0E9d), 1.0d) < 0 ? floor2 + 1 : floor2;
                }
                long elapsedTimeUTC2 = getElapsedTimeUTC() + 42;
                return getNanosecond() + 184000000 >= MRD ? elapsedTimeUTC2 + 1 : elapsedTimeUTC2;
            case 6:
                long j2 = this.posixTime;
                if (j2 < POSIX_UTC_DELTA) {
                    return j2 - POSIX_UTC_DELTA;
                }
                return (long) Math.floor(getModernUT());
            default:
                throw new UnsupportedOperationException("Not yet implemented: " + timeScale);
        }
    }

    public int getNanosecond() {
        return this.fraction & -1073741825;
    }

    public int getNanosecond(TimeScale timeScale) {
        long j;
        int i;
        int i2;
        switch (AnonymousClass1.$SwitchMap$net$time4j$scale$TimeScale[timeScale.ordinal()]) {
            case 1:
            case 2:
                return getNanosecond();
            case 3:
                if (getElapsedTimeUTC() < 0) {
                    double deltaT = TimeScale.deltaT(getDateUTC()) + ((double) (this.posixTime - POSIX_UTC_DELTA)) + (((double) getNanosecond()) / 1.0E9d);
                    long floor = (long) Math.floor(deltaT);
                    if (Double.compare(1.0E9d - ((deltaT - ((double) floor)) * 1.0E9d), 1.0d) < 0) {
                        floor++;
                        i2 = 0;
                    } else {
                        i2 = toNanos(deltaT, floor);
                    }
                    j = (floor - 32) + UTC_TAI_DELTA;
                    i = i2 - 184000000;
                    if (i < 0) {
                        j--;
                        i += MRD;
                    }
                } else {
                    j = getElapsedTimeUTC() + UTC_TAI_DELTA;
                    i = getNanosecond();
                }
                if (j >= 0) {
                    return i;
                }
                throw new IllegalArgumentException("TAI not supported before 1958-01-01: " + this);
            case 4:
                if (LeapSeconds.getInstance().strip(getElapsedTimeUTC()) >= POSIX_GPS_DELTA) {
                    return getNanosecond();
                }
                throw new IllegalArgumentException("GPS not supported before 1980-01-06: " + this);
            case 5:
                if (this.posixTime < POSIX_UTC_DELTA) {
                    double deltaT2 = TimeScale.deltaT(getDateUTC()) + ((double) (this.posixTime - POSIX_UTC_DELTA)) + (((double) getNanosecond()) / 1.0E9d);
                    long floor2 = (long) Math.floor(deltaT2);
                    if (Double.compare(1.0E9d - ((deltaT2 - ((double) floor2)) * 1.0E9d), 1.0d) < 0) {
                        return 0;
                    }
                    return toNanos(deltaT2, floor2);
                }
                int nanosecond = getNanosecond() + 184000000;
                return nanosecond >= MRD ? nanosecond - MRD : nanosecond;
            case 6:
                if (this.posixTime < POSIX_UTC_DELTA) {
                    return getNanosecond();
                }
                double modernUT = getModernUT();
                return toNanos(modernUT, (long) Math.floor(modernUT));
            default:
                throw new UnsupportedOperationException("Not yet implemented: " + timeScale);
        }
    }

    public boolean isLeapSecond() {
        return isPositiveLS() && LeapSeconds.getInstance().isEnabled();
    }

    public static ChronoOperator<Moment> nextLeapSecond() {
        return NEXT_LS;
    }

    public BigDecimal transform(TimeScale timeScale) {
        return new BigDecimal(getElapsedTime(timeScale)).setScale(9, RoundingMode.UNNECESSARY).add(new BigDecimal(getNanosecond(timeScale)).movePointLeft(9));
    }

    public boolean isAfter(UniversalTime universalTime) {
        return compareTo(from(universalTime)) > 0;
    }

    public boolean isBefore(UniversalTime universalTime) {
        return compareTo(from(universalTime)) < 0;
    }

    public boolean isSimultaneous(UniversalTime universalTime) {
        return compareTo(from(universalTime)) == 0;
    }

    public PlainTimestamp toLocalTimestamp() {
        return in(Timezone.ofSystem());
    }

    public PlainTimestamp toZonalTimestamp(TZID tzid) {
        return in(Timezone.of(tzid));
    }

    public PlainTimestamp toZonalTimestamp(String str) {
        return in(Timezone.of(str));
    }

    public <C extends Calendrical<?, C>> GeneralTimestamp<C> toGeneralTimestamp(Chronology<C> chronology, TZID tzid, StartOfDay startOfDay) {
        PlainTimestamp zonalTimestamp = toZonalTimestamp(tzid);
        return GeneralTimestamp.of(((PlainTimestamp) zonalTimestamp.minus((long) startOfDay.getDeviation(zonalTimestamp.getCalendarDate(), tzid), ClockUnit.SECONDS)).getCalendarDate().transform(chronology.getChronoType()), zonalTimestamp.getWallTime());
    }

    public <C extends CalendarVariant<C>> GeneralTimestamp<C> toGeneralTimestamp(CalendarFamily<C> calendarFamily, String str, TZID tzid, StartOfDay startOfDay) {
        PlainTimestamp zonalTimestamp = toZonalTimestamp(tzid);
        return GeneralTimestamp.of(((PlainTimestamp) zonalTimestamp.minus((long) startOfDay.getDeviation(zonalTimestamp.getCalendarDate(), tzid), ClockUnit.SECONDS)).getCalendarDate().transform(calendarFamily.getChronoType(), str), zonalTimestamp.getWallTime());
    }

    public ZonalDateTime inLocalView() {
        return ZonalDateTime.of(this, Timezone.ofSystem());
    }

    public ZonalDateTime inZonalView(TZID tzid) {
        return ZonalDateTime.of(this, Timezone.of(tzid));
    }

    public ZonalDateTime inZonalView(String str) {
        return ZonalDateTime.of(this, Timezone.of(str));
    }

    public Moment plus(long j, SI si) {
        Moment moment;
        check1972(this);
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return this;
        }
        try {
            int i2 = AnonymousClass1.$SwitchMap$net$time4j$SI[si.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    long safeAdd = MathUtils.safeAdd((long) getNanosecond(), j);
                    int floorModulo = MathUtils.floorModulo(safeAdd, (int) MRD);
                    long floorDivide = MathUtils.floorDivide(safeAdd, (int) MRD);
                    if (LeapSeconds.getInstance().isEnabled()) {
                        moment = new Moment(MathUtils.safeAdd(getElapsedTimeUTC(), floorDivide), floorModulo, TimeScale.UTC);
                    } else {
                        moment = of(MathUtils.safeAdd(this.posixTime, floorDivide), floorModulo, TimeScale.POSIX);
                    }
                } else {
                    throw new UnsupportedOperationException();
                }
            } else if (LeapSeconds.getInstance().isEnabled()) {
                moment = new Moment(MathUtils.safeAdd(getElapsedTimeUTC(), j), getNanosecond(), TimeScale.UTC);
            } else {
                moment = of(MathUtils.safeAdd(this.posixTime, j), getNanosecond(), TimeScale.POSIX);
            }
            if (i < 0) {
                check1972(moment);
            }
            return moment;
        } catch (IllegalArgumentException e) {
            ArithmeticException arithmeticException = new ArithmeticException("Result beyond boundaries of time axis.");
            arithmeticException.initCause(e);
            throw arithmeticException;
        }
    }

    public Moment plus(MachineTime<SI> machineTime) {
        return plus(machineTime.getSeconds(), SI.SECONDS).plus((long) machineTime.getFraction(), SI.NANOSECONDS);
    }

    public Moment minus(long j, SI si) {
        return plus(MathUtils.safeNegate(j), si);
    }

    public Moment minus(MachineTime<SI> machineTime) {
        return minus(machineTime.getSeconds(), SI.SECONDS).minus((long) machineTime.getFraction(), SI.NANOSECONDS);
    }

    public long until(Moment moment, SI si) {
        return si.between(this, moment);
    }

    public String print(TemporalFormatter<Moment> temporalFormatter) {
        return temporalFormatter.print(this);
    }

    public static Moment parse(String str, TemporalFormatter<Moment> temporalFormatter) {
        try {
            return temporalFormatter.parse(str);
        } catch (ParseException e) {
            throw new ChronoException(e.getMessage(), e);
        }
    }

    public int compareTo(Moment moment) {
        int nanosecond;
        int i = (getElapsedTimeUTC() > moment.getElapsedTimeUTC() ? 1 : (getElapsedTimeUTC() == moment.getElapsedTimeUTC() ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        if (i > 0 || (nanosecond = getNanosecond() - moment.getNanosecond()) > 0) {
            return 1;
        }
        if (nanosecond < 0) {
            return -1;
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Moment)) {
            return false;
        }
        Moment moment = (Moment) obj;
        if (this.posixTime != moment.posixTime) {
            return false;
        }
        if (LeapSeconds.getInstance().isEnabled()) {
            if (this.fraction == moment.fraction) {
                return true;
            }
            return false;
        } else if (getNanosecond() == moment.getNanosecond()) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        long j = this.posixTime;
        return (((int) (j ^ (j >>> 32))) * 19) + (getNanosecond() * 37);
    }

    public String toString() {
        return toStringUTC(true);
    }

    public String toString(TimeScale timeScale) {
        StringBuilder sb = new StringBuilder(50);
        sb.append(timeScale.name());
        sb.append(SignatureVisitor.SUPER);
        switch (AnonymousClass1.$SwitchMap$net$time4j$scale$TimeScale[timeScale.ordinal()]) {
            case 1:
                sb.append(PlainTimestamp.from(this, ZonalOffset.UTC));
                sb.append(Matrix.MATRIX_TYPE_ZERO);
                break;
            case 2:
                sb.append(toStringUTC(false));
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(PlainTimestamp.from(transformForPrint(timeScale), ZonalOffset.UTC));
                sb.append(Matrix.MATRIX_TYPE_ZERO);
                break;
            default:
                throw new UnsupportedOperationException(timeScale.name());
        }
        return sb.toString();
    }

    public static TimeAxis<TimeUnit, Moment> axis() {
        return ENGINE;
    }

    public static <S> Chronology<S> axis(Converter<S, Moment> converter) {
        return new BridgeChronology(converter, ENGINE);
    }

    /* access modifiers changed from: protected */
    public TimeAxis<TimeUnit, Moment> getChronology() {
        return ENGINE;
    }

    static void checkNegativeLS(long j, PlainTimestamp plainTimestamp) {
        LeapSeconds instance = LeapSeconds.getInstance();
        if (instance.supportsNegativeLS() && instance.strip(instance.enhance(j)) > j) {
            throw new ChronoException("Illegal local timestamp due to negative leap second: " + plainTimestamp);
        }
    }

    static void check1972(Moment moment) {
        if (moment.posixTime < POSIX_UTC_DELTA) {
            throw new UnsupportedOperationException("Cannot calculate SI-duration before 1972-01-01.");
        }
    }

    private String toStringUTC(boolean z) {
        PlainDate dateUTC = getDateUTC();
        int timeOfDay = getTimeOfDay(this);
        int i = timeOfDay / 60;
        int i2 = i / 60;
        int i3 = i % 60;
        int shift = (timeOfDay % 60) + LeapSeconds.getInstance().getShift(getElapsedTimeUTC());
        int nanosecond = getNanosecond();
        StringBuilder sb = new StringBuilder(50);
        sb.append(dateUTC);
        sb.append('T');
        format(i2, 2, sb);
        if (z || (i3 | shift | nanosecond) != 0) {
            sb.append(AbstractJsonLexerKt.COLON);
            format(i3, 2, sb);
            if (z || (shift | nanosecond) != 0) {
                sb.append(AbstractJsonLexerKt.COLON);
                format(shift, 2, sb);
                if (nanosecond > 0) {
                    sb.append(AbstractJsonLexerKt.COMMA);
                    format(nanosecond, 9, sb);
                }
            }
        }
        sb.append(Matrix.MATRIX_TYPE_ZERO);
        return sb.toString();
    }

    private long getElapsedTimeUTC() {
        if (!LeapSeconds.getInstance().isEnabled()) {
            return this.posixTime - POSIX_UTC_DELTA;
        }
        long enhance = LeapSeconds.getInstance().enhance(this.posixTime);
        return isPositiveLS() ? enhance + 1 : enhance;
    }

    /* access modifiers changed from: private */
    public PlainDate getDateUTC() {
        return PlainDate.of(MathUtils.floorDivide(this.posixTime, 86400), EpochDays.UNIX);
    }

    /* access modifiers changed from: private */
    public PlainTime getTimeUTC() {
        int timeOfDay = getTimeOfDay(this);
        int i = timeOfDay / 60;
        return PlainTime.of(i / 60, i % 60, timeOfDay % 60, getNanosecond());
    }

    private double getModernUT() {
        double elapsedTimeUTC = ((((double) getElapsedTimeUTC()) + 42.184d) + (((double) getNanosecond()) / 1.0E9d)) - TimeScale.deltaT(getDateUTC());
        long floor = (long) Math.floor(elapsedTimeUTC);
        return Double.compare(1.0E9d - ((elapsedTimeUTC - ((double) floor)) * 1.0E9d), 1.0d) < 0 ? (double) (floor + 1) : elapsedTimeUTC;
    }

    private static int toNanos(double d, long j) {
        try {
            return (int) ((d * 1.0E9d) - ((double) MathUtils.safeMultiply(j, 1000000000)));
        } catch (ArithmeticException unused) {
            return (int) ((d - ((double) j)) * 1.0E9d);
        }
    }

    /* access modifiers changed from: private */
    public boolean isPositiveLS() {
        return (this.fraction >>> 30) != 0;
    }

    /* access modifiers changed from: private */
    public boolean isNegativeLS() {
        LeapSeconds instance = LeapSeconds.getInstance();
        if (!instance.supportsNegativeLS()) {
            return false;
        }
        long j = this.posixTime;
        if (instance.strip(instance.enhance(j)) > j) {
            return true;
        }
        return false;
    }

    private static void checkUnixTime(long j) {
        if (j > MAX_LIMIT || j < MIN_LIMIT) {
            throw new IllegalArgumentException("UNIX time (UT) out of supported range: " + j);
        }
    }

    private static void checkFraction(int i) {
        if (i >= MRD || i < 0) {
            throw new IllegalArgumentException("Nanosecond out of range: " + i);
        }
    }

    /* access modifiers changed from: private */
    public Moment transformForPrint(TimeScale timeScale) {
        switch (AnonymousClass1.$SwitchMap$net$time4j$scale$TimeScale[timeScale.ordinal()]) {
            case 1:
                return isLeapSecond() ? new Moment(getNanosecond(), this.posixTime) : this;
            case 2:
                return this;
            case 3:
                return new Moment(getNanosecond(timeScale), MathUtils.safeAdd(getElapsedTime(timeScale), -378691200));
            case 4:
                return new Moment(getNanosecond(), MathUtils.safeAdd(getElapsedTime(TimeScale.GPS), (long) POSIX_GPS_DELTA));
            case 5:
            case 6:
                return new Moment(getNanosecond(timeScale), MathUtils.safeAdd(getElapsedTime(timeScale), (long) POSIX_UTC_DELTA));
            default:
                throw new UnsupportedOperationException(timeScale.name());
        }
    }

    /* access modifiers changed from: private */
    public Moment transformForParse(TimeScale timeScale) {
        if (timeScale == TimeScale.UTC) {
            return this;
        }
        if (!isLeapSecond()) {
            int i = AnonymousClass1.$SwitchMap$net$time4j$scale$TimeScale[timeScale.ordinal()];
            if (i == 1) {
                return this;
            }
            if (i == 3) {
                return new Moment(MathUtils.safeSubtract(this.posixTime, -378691200), getNanosecond(), timeScale);
            }
            if (i == 4) {
                return new Moment(MathUtils.safeSubtract(this.posixTime, (long) POSIX_GPS_DELTA), getNanosecond(), timeScale);
            }
            if (i == 5 || i == 6) {
                return new Moment(MathUtils.safeSubtract(this.posixTime, (long) POSIX_UTC_DELTA), getNanosecond(), timeScale);
            }
            throw new UnsupportedOperationException(timeScale.name());
        }
        throw new IllegalArgumentException("Leap seconds do not exist on continuous time scale: " + timeScale);
    }

    private static void format(int i, int i2, StringBuilder sb) {
        int i3 = 1;
        for (int i4 = 0; i4 < i2 - 1; i4++) {
            i3 *= 10;
        }
        while (i < i3 && i3 >= 10) {
            sb.append('0');
            i3 /= 10;
        }
        sb.append(String.valueOf(i));
    }

    private static int getTimeOfDay(Moment moment) {
        return MathUtils.floorModulo(moment.posixTime, 86400);
    }

    /* access modifiers changed from: private */
    public static Moment moveEventuallyToLS(Moment moment) {
        PlainDate dateUTC = moment.getDateUTC();
        PlainTime timeUTC = moment.getTimeUTC();
        return (LeapSeconds.getInstance().getShift((GregorianDate) dateUTC) == 1 && timeUTC.getHour() == 23 && timeUTC.getMinute() == 59 && timeUTC.getSecond() == 59) ? moment.plus(1, SI.SECONDS) : moment;
    }

    /* access modifiers changed from: private */
    public PlainTimestamp in(Timezone timezone) {
        return PlainTimestamp.from(this, timezone.getOffset(this));
    }

    /* access modifiers changed from: private */
    public static int getMaxSecondOfMinute(Moment moment) {
        int timeOfDay = getTimeOfDay(moment) / 60;
        if (timeOfDay / 60 != 23 || timeOfDay % 60 != 59) {
            return 59;
        }
        return 59 + LeapSeconds.getInstance().getShift((GregorianDate) moment.getDateUTC());
    }

    private Object writeReplace() {
        return new SPX(this, 4);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    /* access modifiers changed from: package-private */
    public void writeTimestamp(DataOutput dataOutput) throws IOException {
        int i = isPositiveLS() ? 65 : 64;
        int nanosecond = getNanosecond();
        if (nanosecond > 0) {
            i |= 2;
        }
        dataOutput.writeByte(i);
        dataOutput.writeLong(this.posixTime);
        if (nanosecond > 0) {
            dataOutput.writeInt(nanosecond);
        }
    }

    static Moment readTimestamp(DataInput dataInput, boolean z, boolean z2) throws IOException {
        long readLong = dataInput.readLong();
        int readInt = z2 ? dataInput.readInt() : 0;
        if (readLong == 0) {
            if (z) {
                throw new InvalidObjectException("UTC epoch is no leap second.");
            } else if (readInt == 0) {
                return UNIX_EPOCH;
            }
        }
        if (readLong == MIN_LIMIT && readInt == 0) {
            if (!z) {
                return MIN;
            }
            throw new InvalidObjectException("Minimum is no leap second.");
        } else if (readLong != MAX_LIMIT || readInt != 999999999) {
            checkFraction(readInt);
            if (z) {
                LeapSeconds instance = LeapSeconds.getInstance();
                if (!instance.isEnabled() || instance.isPositiveLS(instance.enhance(readLong) + 1)) {
                    readInt |= 1073741824;
                } else {
                    long packedDate = GregorianMath.toPackedDate(readLong);
                    int readMonth = GregorianMath.readMonth(packedDate);
                    int readDayOfMonth = GregorianMath.readDayOfMonth(packedDate);
                    StringBuilder sb = new StringBuilder();
                    sb.append("Not registered as leap second event: ");
                    sb.append(GregorianMath.readYear(packedDate));
                    sb.append("-");
                    String str = "0";
                    sb.append(readMonth < 10 ? str : "");
                    sb.append(readMonth);
                    if (readDayOfMonth >= 10) {
                        str = "";
                    }
                    sb.append(str);
                    sb.append(readDayOfMonth);
                    sb.append(" [Please check leap second configurations ");
                    sb.append("either of emitter vm or this target vm]");
                    throw new InvalidObjectException(sb.toString());
                }
            }
            return new Moment(readInt, readLong);
        } else if (!z) {
            return MAX;
        } else {
            throw new InvalidObjectException("Maximum is no leap second.");
        }
    }

    static final class Operator implements ChronoOperator<Moment> {
        private final ChronoOperator<PlainTimestamp> delegate;
        private final ChronoElement<?> element;
        private final int type;
        private final Timezone tz;

        Operator(ChronoOperator<PlainTimestamp> chronoOperator, ChronoElement<?> chronoElement, int i) {
            this.delegate = chronoOperator;
            this.element = chronoElement;
            this.type = i;
            this.tz = null;
        }

        Operator(ChronoOperator<PlainTimestamp> chronoOperator, ChronoElement<?> chronoElement, int i, Timezone timezone) {
            this.delegate = chronoOperator;
            this.element = chronoElement;
            this.type = i;
            this.tz = timezone;
        }

        public Moment apply(Moment moment) {
            int i;
            Timezone timezone = this.tz;
            if (timezone == null) {
                timezone = Timezone.ofSystem();
            }
            if (!moment.isLeapSecond() || !isNonIsoOffset(timezone, moment)) {
                long j = 1;
                if (moment.isAfter((UniversalTime) Moment.START_LS_CHECK)) {
                    if (this.element == PlainTime.SECOND_OF_MINUTE && this.type == -1 && extractValue() == 60) {
                        if (moment.isLeapSecond()) {
                            return moment;
                        }
                        if (isNonIsoOffset(timezone, moment)) {
                            throw new IllegalArgumentException("Leap second can only be set  with timezone-offset in full minutes: " + timezone.getOffset(moment));
                        } else if (Moment.getMaxSecondOfMinute(moment) == 60) {
                            return moment.plus(MathUtils.safeSubtract(60, extractOld(moment)), SI.SECONDS);
                        } else {
                            throw new IllegalArgumentException("Leap second invalid in context: " + moment);
                        }
                    } else if (Moment.LOW_TIME_ELEMENTS.containsKey(this.element) && ((i = this.type) == 2 || i == 3 || i == 6)) {
                        int intValue = ((Integer) Moment.LOW_TIME_ELEMENTS.get(this.element)).intValue();
                        int i2 = this.type;
                        if (i2 == 2) {
                            j = -1;
                        } else if (i2 == 6) {
                            j = MathUtils.safeSubtract(extractValue(), extractOld(moment));
                        }
                        if (intValue == 1) {
                            return moment.plus(j, SI.SECONDS);
                        }
                        if (intValue == 1000) {
                            return moment.plus(MathUtils.safeMultiply((long) AnimationKt.MillisToNanos, j), SI.NANOSECONDS);
                        }
                        if (intValue == 1000000) {
                            return moment.plus(MathUtils.safeMultiply(1000, j), SI.NANOSECONDS);
                        }
                        if (intValue == Moment.MRD) {
                            return moment.plus(j, SI.NANOSECONDS);
                        }
                        throw new AssertionError();
                    }
                }
                PlainTimestamp plainTimestamp = (PlainTimestamp) moment.in(timezone).with(this.delegate);
                Moment in = plainTimestamp.in(timezone);
                if (this.type == 4) {
                    return in;
                }
                if (in.isNegativeLS()) {
                    if (this.tz.getStrategy() != Timezone.STRICT_MODE) {
                        return in;
                    }
                    throw new ChronoException("Illegal local timestamp due to negative leap second: " + plainTimestamp);
                } else if (this.element.isDateElement() || Moment.HIGH_TIME_ELEMENTS.contains(this.element)) {
                    if (moment.isLeapSecond() || this.type == 5) {
                        return Moment.moveEventuallyToLS(in);
                    }
                    return in;
                } else if (this.element == PlainTime.SECOND_OF_MINUTE) {
                    int i3 = this.type;
                    if (i3 == 1 || i3 == 5) {
                        return Moment.moveEventuallyToLS(in);
                    }
                    return in;
                } else if (this.element != PlainTime.MILLI_OF_SECOND && this.element != PlainTime.MICRO_OF_SECOND && this.element != PlainTime.NANO_OF_SECOND) {
                    return in;
                } else {
                    int i4 = this.type;
                    return ((i4 == -1 || i4 == 0 || i4 == 1 || i4 == 5) && moment.isLeapSecond()) ? in.plus(1, SI.SECONDS) : in;
                }
            } else {
                throw new IllegalArgumentException("Leap second can only be adjusted  with timezone-offset in full minutes: " + timezone.getOffset(moment));
            }
        }

        private long extractOld(Moment moment) {
            return Number.class.cast(moment.getTimeUTC().get(this.element)).longValue();
        }

        private long extractValue() {
            Object value = ValueOperator.class.cast(this.delegate).getValue();
            if (value != null) {
                return Number.class.cast(value).longValue();
            }
            throw new IllegalArgumentException("Missing new element value.");
        }

        private static boolean isNonIsoOffset(Timezone timezone, Moment moment) {
            ZonalOffset offset = timezone.getOffset(moment);
            return (offset.getFractionalAmount() == 0 && offset.getAbsoluteSeconds() % 60 == 0) ? false : true;
        }
    }

    private static class TimeUnitRule implements UnitRule<Moment> {
        private final TimeUnit unit;

        TimeUnitRule(TimeUnit timeUnit) {
            this.unit = timeUnit;
        }

        public Moment addTo(Moment moment, long j) {
            if (this.unit.compareTo(TimeUnit.SECONDS) >= 0) {
                return Moment.of(MathUtils.safeAdd(moment.getPosixTime(), MathUtils.safeMultiply(j, this.unit.toSeconds(1))), moment.getNanosecond(), TimeScale.POSIX);
            }
            long safeAdd = MathUtils.safeAdd((long) moment.getNanosecond(), MathUtils.safeMultiply(j, this.unit.toNanos(1)));
            return Moment.of(MathUtils.safeAdd(moment.getPosixTime(), MathUtils.floorDivide(safeAdd, (int) Moment.MRD)), MathUtils.floorModulo(safeAdd, (int) Moment.MRD), TimeScale.POSIX);
        }

        public long between(Moment moment, Moment moment2) {
            long j;
            if (this.unit.compareTo(TimeUnit.SECONDS) >= 0) {
                j = moment2.getPosixTime() - moment.getPosixTime();
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i < 0) {
                    if (moment2.getNanosecond() > moment.getNanosecond()) {
                        j++;
                    }
                } else if (i > 0 && moment2.getNanosecond() < moment.getNanosecond()) {
                    j--;
                }
            } else {
                j = MathUtils.safeAdd(MathUtils.safeMultiply(MathUtils.safeSubtract(moment2.getPosixTime(), moment.getPosixTime()), 1000000000), (long) (moment2.getNanosecond() - moment.getNanosecond()));
            }
            switch (AnonymousClass1.$SwitchMap$java$util$concurrent$TimeUnit[this.unit.ordinal()]) {
                case 1:
                    return j / 86400;
                case 2:
                    return j / 3600;
                case 3:
                    return j / 60;
                case 4:
                case 7:
                    return j;
                case 5:
                    return j / AnimationKt.MillisToNanos;
                case 6:
                    return j / 1000;
                default:
                    throw new UnsupportedOperationException(this.unit.name());
            }
        }
    }

    /* renamed from: net.time4j.Moment$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$util$concurrent$TimeUnit;
        static final /* synthetic */ int[] $SwitchMap$net$time4j$SI;
        static final /* synthetic */ int[] $SwitchMap$net$time4j$scale$TimeScale;

        /* JADX WARNING: Can't wrap try/catch for region: R(35:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|(2:17|18)|19|21|22|23|24|25|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Can't wrap try/catch for region: R(39:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0065 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0080 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x008a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0094 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00a8 */
        static {
            /*
                java.util.concurrent.TimeUnit[] r0 = java.util.concurrent.TimeUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$java$util$concurrent$TimeUnit = r0
                r1 = 1
                java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.DAYS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$java$util$concurrent$TimeUnit     // Catch:{ NoSuchFieldError -> 0x001d }
                java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.HOURS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$java$util$concurrent$TimeUnit     // Catch:{ NoSuchFieldError -> 0x0028 }
                java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MINUTES     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$java$util$concurrent$TimeUnit     // Catch:{ NoSuchFieldError -> 0x0033 }
                java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = $SwitchMap$java$util$concurrent$TimeUnit     // Catch:{ NoSuchFieldError -> 0x003e }
                java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = $SwitchMap$java$util$concurrent$TimeUnit     // Catch:{ NoSuchFieldError -> 0x0049 }
                java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.MICROSECONDS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r6 = $SwitchMap$java$util$concurrent$TimeUnit     // Catch:{ NoSuchFieldError -> 0x0054 }
                java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r8 = 7
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                net.time4j.SI[] r6 = net.time4j.SI.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                $SwitchMap$net$time4j$SI = r6
                net.time4j.SI r7 = net.time4j.SI.SECONDS     // Catch:{ NoSuchFieldError -> 0x0065 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                r6[r7] = r1     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                int[] r6 = $SwitchMap$net$time4j$SI     // Catch:{ NoSuchFieldError -> 0x006f }
                net.time4j.SI r7 = net.time4j.SI.NANOSECONDS     // Catch:{ NoSuchFieldError -> 0x006f }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r6[r7] = r0     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                net.time4j.scale.TimeScale[] r6 = net.time4j.scale.TimeScale.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                $SwitchMap$net$time4j$scale$TimeScale = r6
                net.time4j.scale.TimeScale r7 = net.time4j.scale.TimeScale.POSIX     // Catch:{ NoSuchFieldError -> 0x0080 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0080 }
                r6[r7] = r1     // Catch:{ NoSuchFieldError -> 0x0080 }
            L_0x0080:
                int[] r1 = $SwitchMap$net$time4j$scale$TimeScale     // Catch:{ NoSuchFieldError -> 0x008a }
                net.time4j.scale.TimeScale r6 = net.time4j.scale.TimeScale.UTC     // Catch:{ NoSuchFieldError -> 0x008a }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x008a }
                r1[r6] = r0     // Catch:{ NoSuchFieldError -> 0x008a }
            L_0x008a:
                int[] r0 = $SwitchMap$net$time4j$scale$TimeScale     // Catch:{ NoSuchFieldError -> 0x0094 }
                net.time4j.scale.TimeScale r1 = net.time4j.scale.TimeScale.TAI     // Catch:{ NoSuchFieldError -> 0x0094 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0094 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0094 }
            L_0x0094:
                int[] r0 = $SwitchMap$net$time4j$scale$TimeScale     // Catch:{ NoSuchFieldError -> 0x009e }
                net.time4j.scale.TimeScale r1 = net.time4j.scale.TimeScale.GPS     // Catch:{ NoSuchFieldError -> 0x009e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009e }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x009e }
            L_0x009e:
                int[] r0 = $SwitchMap$net$time4j$scale$TimeScale     // Catch:{ NoSuchFieldError -> 0x00a8 }
                net.time4j.scale.TimeScale r1 = net.time4j.scale.TimeScale.TT     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$net$time4j$scale$TimeScale     // Catch:{ NoSuchFieldError -> 0x00b2 }
                net.time4j.scale.TimeScale r1 = net.time4j.scale.TimeScale.UT     // Catch:{ NoSuchFieldError -> 0x00b2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b2 }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x00b2 }
            L_0x00b2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.Moment.AnonymousClass1.<clinit>():void");
        }
    }

    private enum LongElement implements ChronoElement<Long>, ElementRule<Moment, Long> {
        POSIX_TIME;

        public char getSymbol() {
            return 0;
        }

        public boolean isDateElement() {
            return false;
        }

        public boolean isLenient() {
            return false;
        }

        public boolean isTimeElement() {
            return false;
        }

        public Class<Long> getType() {
            return Long.class;
        }

        public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
            return ((Long) chronoDisplay.get(this)).compareTo((Long) chronoDisplay2.get(this));
        }

        public Long getDefaultMinimum() {
            return Long.valueOf(Moment.MIN_LIMIT);
        }

        public Long getDefaultMaximum() {
            return Long.valueOf(Moment.MAX_LIMIT);
        }

        public String getDisplayName(Locale locale) {
            return name();
        }

        public Long getValue(Moment moment) {
            return Long.valueOf(moment.getPosixTime());
        }

        public Long getMinimum(Moment moment) {
            return Long.valueOf(Moment.MIN_LIMIT);
        }

        public Long getMaximum(Moment moment) {
            return Long.valueOf(Moment.MAX_LIMIT);
        }

        public boolean isValid(Moment moment, Long l) {
            if (l == null) {
                return false;
            }
            long longValue = l.longValue();
            if (longValue < Moment.MIN_LIMIT || longValue > Moment.MAX_LIMIT) {
                return false;
            }
            return true;
        }

        public Moment withValue(Moment moment, Long l, boolean z) {
            if (l != null) {
                return Moment.of(l.longValue(), moment.getNanosecond(), TimeScale.POSIX);
            }
            throw new IllegalArgumentException("Missing elapsed seconds.");
        }

        public ChronoElement<?> getChildAtFloor(Moment moment) {
            return IntElement.FRACTION;
        }

        public ChronoElement<?> getChildAtCeiling(Moment moment) {
            return IntElement.FRACTION;
        }
    }

    private enum IntElement implements ChronoElement<Integer>, ElementRule<Moment, Integer> {
        FRACTION;

        public ChronoElement<?> getChildAtCeiling(Moment moment) {
            return null;
        }

        public ChronoElement<?> getChildAtFloor(Moment moment) {
            return null;
        }

        public char getSymbol() {
            return 0;
        }

        public boolean isDateElement() {
            return false;
        }

        public boolean isLenient() {
            return false;
        }

        public boolean isTimeElement() {
            return false;
        }

        public Class<Integer> getType() {
            return Integer.class;
        }

        public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
            return ((Integer) chronoDisplay.get(this)).compareTo((Integer) chronoDisplay2.get(this));
        }

        public Integer getDefaultMinimum() {
            return 0;
        }

        public Integer getDefaultMaximum() {
            return 999999999;
        }

        public String getDisplayName(Locale locale) {
            return name();
        }

        public Integer getValue(Moment moment) {
            return Integer.valueOf(moment.getNanosecond());
        }

        public Integer getMinimum(Moment moment) {
            return getDefaultMinimum();
        }

        public Integer getMaximum(Moment moment) {
            return getDefaultMaximum();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
            r3 = r3.intValue();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isValid(net.time4j.Moment r2, java.lang.Integer r3) {
            /*
                r1 = this;
                r2 = 0
                if (r3 != 0) goto L_0x0004
                return r2
            L_0x0004:
                int r3 = r3.intValue()
                if (r3 < 0) goto L_0x0010
                r0 = 1000000000(0x3b9aca00, float:0.0047237873)
                if (r3 >= r0) goto L_0x0010
                r2 = 1
            L_0x0010:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.Moment.IntElement.isValid(net.time4j.Moment, java.lang.Integer):boolean");
        }

        public Moment withValue(Moment moment, Integer num, boolean z) {
            if (num == null) {
                throw new IllegalArgumentException("Missing fraction value.");
            } else if (LeapSeconds.getInstance().isEnabled()) {
                return Moment.of(moment.getElapsedTime(TimeScale.UTC), num.intValue(), TimeScale.UTC);
            } else {
                return Moment.of(moment.getPosixTime(), num.intValue(), TimeScale.POSIX);
            }
        }
    }

    private static class Merger implements ChronoMerger<Moment> {
        private Merger() {
        }

        /* synthetic */ Merger(AnonymousClass1 r1) {
            this();
        }

        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            DisplayMode ofStyle = DisplayMode.ofStyle(displayStyle.getStyleValue());
            return CalendarText.patternForMoment(ofStyle, ofStyle, locale);
        }

        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.MIDNIGHT;
        }

        public int getDefaultPivotYear() {
            return PlainDate.axis().getDefaultPivotYear();
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [net.time4j.base.TimeSource, net.time4j.base.TimeSource<?>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.Moment createFrom(net.time4j.base.TimeSource<?> r1, net.time4j.engine.AttributeQuery r2) {
            /*
                r0 = this;
                net.time4j.base.UnixTime r1 = r1.currentTime()
                net.time4j.Moment r1 = net.time4j.Moment.from(r1)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.Moment.Merger.createFrom(net.time4j.base.TimeSource, net.time4j.engine.AttributeQuery):net.time4j.Moment");
        }

        public Moment createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            PlainTimestamp plainTimestamp;
            TZID tzid;
            Moment moment;
            ZonalOffset zonalOffset;
            Moment moment2;
            TimeScale timeScale = (TimeScale) attributeQuery.get(Attributes.TIME_SCALE, TimeScale.UTC);
            if (chronoEntity instanceof UnixTime) {
                return Moment.from(UnixTime.class.cast(chronoEntity)).transformForParse(timeScale);
            }
            int i = 0;
            if (chronoEntity.contains(LongElement.POSIX_TIME)) {
                long longValue = ((Long) chronoEntity.get((ChronoElement<V>) LongElement.POSIX_TIME)).longValue();
                if (chronoEntity.contains(IntElement.FRACTION)) {
                    i = ((Integer) chronoEntity.get((ChronoElement<V>) IntElement.FRACTION)).intValue();
                }
                return Moment.of(longValue, i, TimeScale.POSIX).transformForParse(timeScale);
            }
            if (chronoEntity.contains(FlagElement.LEAP_SECOND)) {
                i = 1;
                chronoEntity.with((ChronoElement<Integer>) PlainTime.SECOND_OF_MINUTE, 60);
            }
            ChronoElement element = PlainTimestamp.axis().element();
            if (chronoEntity.contains(element)) {
                plainTimestamp = (PlainTimestamp) chronoEntity.get((ChronoElement<V>) element);
            } else {
                plainTimestamp = (PlainTimestamp) PlainTimestamp.axis().createFrom((ChronoEntity) chronoEntity, attributeQuery, z, z2);
            }
            if (plainTimestamp == null) {
                return null;
            }
            if (chronoEntity.hasTimezone()) {
                tzid = chronoEntity.getTimezone();
            } else {
                tzid = attributeQuery.contains(Attributes.TIMEZONE_ID) ? (TZID) attributeQuery.get(Attributes.TIMEZONE_ID) : null;
            }
            if (tzid == null) {
                moment = null;
            } else if (chronoEntity.contains(FlagElement.DAYLIGHT_SAVING)) {
                moment = plainTimestamp.in(Timezone.of(tzid).with(((TransitionStrategy) attributeQuery.get(Attributes.TRANSITION_STRATEGY, Timezone.DEFAULT_CONFLICT_STRATEGY)).using(((Boolean) chronoEntity.get((ChronoElement<V>) FlagElement.DAYLIGHT_SAVING)).booleanValue() ? OverlapResolver.EARLIER_OFFSET : OverlapResolver.LATER_OFFSET)));
            } else if (attributeQuery.contains(Attributes.TRANSITION_STRATEGY)) {
                moment = plainTimestamp.in(Timezone.of(tzid).with((TransitionStrategy) attributeQuery.get(Attributes.TRANSITION_STRATEGY)));
            } else {
                moment = plainTimestamp.inTimezone(tzid);
            }
            if (moment == null) {
                return null;
            }
            if (i != 0) {
                if (tzid instanceof ZonalOffset) {
                    zonalOffset = (ZonalOffset) tzid;
                } else {
                    zonalOffset = Timezone.of(tzid).getOffset(moment);
                }
                if (zonalOffset.getFractionalAmount() == 0 && zonalOffset.getAbsoluteSeconds() % 60 == 0) {
                    if (moment.getDateUTC().getYear() >= 1972) {
                        moment2 = moment.plus(1, SI.SECONDS);
                    } else {
                        moment2 = new Moment(moment.getNanosecond(), moment.getPosixTime() + 1, (AnonymousClass1) null);
                    }
                    if (!z) {
                        if (LeapSeconds.getInstance().isEnabled()) {
                            if (!moment2.isPositiveLS()) {
                                throw new IllegalArgumentException("SECOND_OF_MINUTE parsed as invalid leapsecond before " + moment2);
                            }
                        }
                    }
                    moment = moment2;
                } else {
                    throw new IllegalArgumentException("Leap second is only allowed  with timezone-offset in full minutes: " + zonalOffset);
                }
            }
            return moment.transformForParse(timeScale);
        }

        public ChronoDisplay preformat(Moment moment, AttributeQuery attributeQuery) {
            if (attributeQuery.contains(Attributes.TIMEZONE_ID)) {
                return moment.transformForPrint((TimeScale) attributeQuery.get(Attributes.TIME_SCALE, TimeScale.UTC)).inZonalView((TZID) attributeQuery.get(Attributes.TIMEZONE_ID));
            }
            throw new IllegalArgumentException("Cannot print moment without timezone.");
        }

        public Chronology<?> preparser() {
            return PlainTimestamp.axis();
        }
    }

    private static class GlobalTimeLine implements TimeLine<Moment> {
        public boolean isCalendrical() {
            return false;
        }

        private GlobalTimeLine() {
        }

        /* synthetic */ GlobalTimeLine(AnonymousClass1 r1) {
            this();
        }

        public Moment stepForward(Moment moment) {
            try {
                if (useSI(moment)) {
                    return moment.plus(1, SI.NANOSECONDS);
                }
                return (Moment) moment.plus(1, TimeUnit.NANOSECONDS);
            } catch (ArithmeticException unused) {
                return null;
            }
        }

        public Moment stepBackwards(Moment moment) {
            try {
                if (useSI(moment)) {
                    return moment.minus(1, SI.NANOSECONDS);
                }
                return (Moment) moment.minus(1, TimeUnit.NANOSECONDS);
            } catch (ArithmeticException unused) {
                return null;
            }
        }

        public int compare(Moment moment, Moment moment2) {
            return moment.compareTo(moment2);
        }

        private static boolean useSI(Moment moment) {
            return moment.posixTime > Moment.POSIX_UTC_DELTA && LeapSeconds.getInstance().isEnabled();
        }
    }

    private static class NextLS implements ChronoOperator<Moment> {
        private NextLS() {
        }

        /* synthetic */ NextLS(AnonymousClass1 r1) {
            this();
        }

        public Moment apply(Moment moment) {
            LeapSecondEvent nextEvent;
            LeapSeconds instance = LeapSeconds.getInstance();
            if (!instance.isEnabled() || (nextEvent = instance.getNextEvent(moment.getElapsedTime(TimeScale.UTC))) == null) {
                return null;
            }
            return PlainDate.from(nextEvent.getDate()).atTime(23, 59, 59).atUTC().plus((long) nextEvent.getShift(), SI.SECONDS);
        }
    }

    private static class PrecisionRule implements ElementRule<Moment, TimeUnit> {
        public ChronoElement<?> getChildAtCeiling(Moment moment) {
            return null;
        }

        public ChronoElement<?> getChildAtFloor(Moment moment) {
            return null;
        }

        public boolean isValid(Moment moment, TimeUnit timeUnit) {
            return timeUnit != null;
        }

        private PrecisionRule() {
        }

        /* synthetic */ PrecisionRule(AnonymousClass1 r1) {
            this();
        }

        public TimeUnit getValue(Moment moment) {
            int nanosecond = moment.getNanosecond();
            if (nanosecond == 0) {
                long access$1900 = moment.posixTime;
                if (MathUtils.floorModulo(access$1900, 86400) == 0) {
                    return TimeUnit.DAYS;
                }
                if (MathUtils.floorModulo(access$1900, (int) NikonType2MakernoteDirectory.TAG_NIKON_SCAN) == 0) {
                    return TimeUnit.HOURS;
                }
                if (MathUtils.floorModulo(access$1900, 60) == 0) {
                    return TimeUnit.MINUTES;
                }
                return TimeUnit.SECONDS;
            } else if (nanosecond % 1000000 == 0) {
                return TimeUnit.MILLISECONDS;
            } else {
                if (nanosecond % 1000 == 0) {
                    return TimeUnit.MICROSECONDS;
                }
                return TimeUnit.NANOSECONDS;
            }
        }

        public Moment withValue(Moment moment, TimeUnit timeUnit, boolean z) {
            Moment moment2;
            if (timeUnit != null) {
                switch (AnonymousClass1.$SwitchMap$java$util$concurrent$TimeUnit[timeUnit.ordinal()]) {
                    case 1:
                        return Moment.of(MathUtils.floorDivide(moment.posixTime, 86400) * 86400, TimeScale.POSIX);
                    case 2:
                        return Moment.of(MathUtils.floorDivide(moment.posixTime, (int) NikonType2MakernoteDirectory.TAG_NIKON_SCAN) * 3600, TimeScale.POSIX);
                    case 3:
                        return Moment.of(MathUtils.floorDivide(moment.posixTime, 60) * 60, TimeScale.POSIX);
                    case 4:
                        moment2 = Moment.of(moment.posixTime, 0, TimeScale.POSIX);
                        break;
                    case 5:
                        moment2 = Moment.of(moment.posixTime, (moment.getNanosecond() / 1000000) * 1000000, TimeScale.POSIX);
                        break;
                    case 6:
                        moment2 = Moment.of(moment.posixTime, (moment.getNanosecond() / 1000) * 1000, TimeScale.POSIX);
                        break;
                    case 7:
                        return moment;
                    default:
                        throw new UnsupportedOperationException(timeUnit.name());
                }
                return (!moment.isLeapSecond() || !LeapSeconds.getInstance().isEnabled()) ? moment2 : moment2.plus(1, SI.SECONDS);
            }
            throw new IllegalArgumentException("Missing precision.");
        }

        public TimeUnit getMinimum(Moment moment) {
            return TimeUnit.DAYS;
        }

        public TimeUnit getMaximum(Moment moment) {
            return TimeUnit.NANOSECONDS;
        }
    }
}
