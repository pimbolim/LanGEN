package net.time4j;

import androidx.compose.animation.core.AnimationKt;
import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import net.time4j.base.GregorianDate;
import net.time4j.base.MathUtils;
import net.time4j.base.UnixTime;
import net.time4j.base.WallTime;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.BridgeChronology;
import net.time4j.engine.CalendarDate;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoException;
import net.time4j.engine.ChronoExtension;
import net.time4j.engine.ChronoMerger;
import net.time4j.engine.Chronology;
import net.time4j.engine.Converter;
import net.time4j.engine.DisplayStyle;
import net.time4j.engine.ElementRule;
import net.time4j.engine.EpochDays;
import net.time4j.engine.Normalizer;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.Temporal;
import net.time4j.engine.TimeAxis;
import net.time4j.engine.TimeMetric;
import net.time4j.engine.TimePoint;
import net.time4j.engine.TimeSpan;
import net.time4j.engine.UnitRule;
import net.time4j.format.CalendarText;
import net.time4j.format.CalendarType;
import net.time4j.format.DisplayMode;
import net.time4j.format.LocalizedPatternSupport;
import net.time4j.format.TemporalFormatter;
import net.time4j.scale.TimeScale;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.TransitionStrategy;
import net.time4j.tz.ZonalOffset;

@CalendarType("iso8601")
public final class PlainTimestamp extends TimePoint<IsoUnit, PlainTimestamp> implements GregorianDate, WallTime, Temporal<PlainTimestamp>, Normalizer<IsoUnit>, LocalizedPatternSupport {
    /* access modifiers changed from: private */
    public static final Map<Object, ChronoElement<?>> CHILDREN;
    /* access modifiers changed from: private */
    public static final TimeAxis<IsoUnit, PlainTimestamp> ENGINE;
    private static final PlainTimestamp MAX;
    private static final PlainTimestamp MIN;
    private static final int MRD = 1000000000;
    private static final TimeMetric<IsoUnit, Duration<IsoUnit>> STD_METRIC = Duration.in((U[]) new IsoUnit[]{CalendarUnit.YEARS, CalendarUnit.MONTHS, CalendarUnit.DAYS, ClockUnit.HOURS, ClockUnit.MINUTES, ClockUnit.SECONDS, ClockUnit.NANOS});
    private static final long serialVersionUID = 7458380065762437714L;
    /* access modifiers changed from: private */
    public final transient PlainDate date;
    /* access modifiers changed from: private */
    public final transient PlainTime time;

    /* access modifiers changed from: protected */
    public PlainTimestamp getContext() {
        return this;
    }

    static {
        PlainTimestamp plainTimestamp = new PlainTimestamp(PlainDate.MIN, PlainTime.MIN);
        MIN = plainTimestamp;
        PlainTimestamp plainTimestamp2 = new PlainTimestamp(PlainDate.MAX, PlainTime.WALL_TIME.getDefaultMaximum());
        MAX = plainTimestamp2;
        HashMap hashMap = new HashMap();
        hashMap.put(PlainDate.CALENDAR_DATE, PlainTime.WALL_TIME);
        hashMap.put(PlainDate.YEAR, PlainDate.MONTH_AS_NUMBER);
        hashMap.put(PlainDate.YEAR_OF_WEEKDATE, Weekmodel.ISO.weekOfYear());
        hashMap.put(PlainDate.QUARTER_OF_YEAR, PlainDate.DAY_OF_QUARTER);
        hashMap.put(PlainDate.MONTH_OF_YEAR, PlainDate.DAY_OF_MONTH);
        hashMap.put(PlainDate.MONTH_AS_NUMBER, PlainDate.DAY_OF_MONTH);
        hashMap.put(PlainDate.DAY_OF_MONTH, PlainTime.WALL_TIME);
        hashMap.put(PlainDate.DAY_OF_WEEK, PlainTime.WALL_TIME);
        hashMap.put(PlainDate.DAY_OF_YEAR, PlainTime.WALL_TIME);
        hashMap.put(PlainDate.DAY_OF_QUARTER, PlainTime.WALL_TIME);
        hashMap.put(PlainDate.WEEKDAY_IN_MONTH, PlainTime.WALL_TIME);
        hashMap.put(PlainTime.AM_PM_OF_DAY, PlainTime.DIGITAL_HOUR_OF_AMPM);
        hashMap.put(PlainTime.CLOCK_HOUR_OF_AMPM, PlainTime.MINUTE_OF_HOUR);
        hashMap.put(PlainTime.CLOCK_HOUR_OF_DAY, PlainTime.MINUTE_OF_HOUR);
        hashMap.put(PlainTime.DIGITAL_HOUR_OF_AMPM, PlainTime.MINUTE_OF_HOUR);
        hashMap.put(PlainTime.DIGITAL_HOUR_OF_DAY, PlainTime.MINUTE_OF_HOUR);
        hashMap.put(PlainTime.HOUR_FROM_0_TO_24, PlainTime.MINUTE_OF_HOUR);
        hashMap.put(PlainTime.MINUTE_OF_HOUR, PlainTime.SECOND_OF_MINUTE);
        hashMap.put(PlainTime.MINUTE_OF_DAY, PlainTime.SECOND_OF_MINUTE);
        hashMap.put(PlainTime.SECOND_OF_MINUTE, PlainTime.NANO_OF_SECOND);
        hashMap.put(PlainTime.SECOND_OF_DAY, PlainTime.NANO_OF_SECOND);
        CHILDREN = Collections.unmodifiableMap(hashMap);
        TimeAxis.Builder appendElement = TimeAxis.Builder.setUp(IsoUnit.class, PlainTimestamp.class, new Merger((AnonymousClass1) null), plainTimestamp, plainTimestamp2).appendElement(PlainDate.CALENDAR_DATE, FieldRule.of(PlainDate.CALENDAR_DATE), CalendarUnit.DAYS).appendElement(PlainDate.YEAR, FieldRule.of(PlainDate.YEAR), CalendarUnit.YEARS).appendElement(PlainDate.YEAR_OF_WEEKDATE, FieldRule.of(PlainDate.YEAR_OF_WEEKDATE), Weekcycle.YEARS).appendElement(PlainDate.QUARTER_OF_YEAR, FieldRule.of(PlainDate.QUARTER_OF_YEAR), CalendarUnit.QUARTERS).appendElement(PlainDate.MONTH_OF_YEAR, FieldRule.of(PlainDate.MONTH_OF_YEAR), CalendarUnit.MONTHS).appendElement(PlainDate.MONTH_AS_NUMBER, FieldRule.of(PlainDate.MONTH_AS_NUMBER), CalendarUnit.MONTHS).appendElement(PlainDate.DAY_OF_MONTH, FieldRule.of(PlainDate.DAY_OF_MONTH), CalendarUnit.DAYS).appendElement(PlainDate.DAY_OF_WEEK, FieldRule.of(PlainDate.DAY_OF_WEEK), CalendarUnit.DAYS).appendElement(PlainDate.DAY_OF_YEAR, FieldRule.of(PlainDate.DAY_OF_YEAR), CalendarUnit.DAYS).appendElement(PlainDate.DAY_OF_QUARTER, FieldRule.of(PlainDate.DAY_OF_QUARTER), CalendarUnit.DAYS).appendElement(PlainDate.WEEKDAY_IN_MONTH, FieldRule.of(PlainDate.WEEKDAY_IN_MONTH), CalendarUnit.WEEKS).appendElement((ChronoElement) PlainTime.WALL_TIME, (ElementRule) FieldRule.of(PlainTime.WALL_TIME)).appendElement((ChronoElement) PlainTime.AM_PM_OF_DAY, (ElementRule) FieldRule.of(PlainTime.AM_PM_OF_DAY)).appendElement(PlainTime.CLOCK_HOUR_OF_AMPM, FieldRule.of(PlainTime.CLOCK_HOUR_OF_AMPM), ClockUnit.HOURS).appendElement(PlainTime.CLOCK_HOUR_OF_DAY, FieldRule.of(PlainTime.CLOCK_HOUR_OF_DAY), ClockUnit.HOURS).appendElement(PlainTime.DIGITAL_HOUR_OF_AMPM, FieldRule.of(PlainTime.DIGITAL_HOUR_OF_AMPM), ClockUnit.HOURS).appendElement(PlainTime.DIGITAL_HOUR_OF_DAY, FieldRule.of(PlainTime.DIGITAL_HOUR_OF_DAY), ClockUnit.HOURS).appendElement(PlainTime.HOUR_FROM_0_TO_24, FieldRule.of(PlainTime.HOUR_FROM_0_TO_24), ClockUnit.HOURS).appendElement(PlainTime.MINUTE_OF_HOUR, FieldRule.of(PlainTime.MINUTE_OF_HOUR), ClockUnit.MINUTES).appendElement(PlainTime.MINUTE_OF_DAY, FieldRule.of(PlainTime.MINUTE_OF_DAY), ClockUnit.MINUTES).appendElement(PlainTime.SECOND_OF_MINUTE, FieldRule.of(PlainTime.SECOND_OF_MINUTE), ClockUnit.SECONDS).appendElement(PlainTime.SECOND_OF_DAY, FieldRule.of(PlainTime.SECOND_OF_DAY), ClockUnit.SECONDS).appendElement(PlainTime.MILLI_OF_SECOND, FieldRule.of(PlainTime.MILLI_OF_SECOND), ClockUnit.MILLIS).appendElement(PlainTime.MICRO_OF_SECOND, FieldRule.of(PlainTime.MICRO_OF_SECOND), ClockUnit.MICROS).appendElement(PlainTime.NANO_OF_SECOND, FieldRule.of(PlainTime.NANO_OF_SECOND), ClockUnit.NANOS).appendElement(PlainTime.MILLI_OF_DAY, FieldRule.of(PlainTime.MILLI_OF_DAY), ClockUnit.MILLIS).appendElement(PlainTime.MICRO_OF_DAY, FieldRule.of(PlainTime.MICRO_OF_DAY), ClockUnit.MICROS).appendElement(PlainTime.NANO_OF_DAY, FieldRule.of(PlainTime.NANO_OF_DAY), ClockUnit.NANOS).appendElement((ChronoElement) PlainTime.DECIMAL_HOUR, (ElementRule) new DecimalRule(PlainTime.DECIMAL_HOUR)).appendElement((ChronoElement) PlainTime.DECIMAL_MINUTE, (ElementRule) new DecimalRule(PlainTime.DECIMAL_MINUTE)).appendElement((ChronoElement) PlainTime.DECIMAL_SECOND, (ElementRule) new DecimalRule(PlainTime.DECIMAL_SECOND)).appendElement((ChronoElement) PlainTime.PRECISION, (ElementRule) FieldRule.of(PlainTime.PRECISION));
        registerCalendarUnits(appendElement);
        registerClockUnits(appendElement);
        registerExtensions(appendElement);
        ENGINE = appendElement.build();
    }

    private PlainTimestamp(PlainDate plainDate, PlainTime plainTime) {
        if (plainTime.getHour() == 24) {
            this.date = (PlainDate) plainDate.plus(1, CalendarUnit.DAYS);
            this.time = PlainTime.MIN;
            return;
        }
        Objects.requireNonNull(plainDate, "Missing date.");
        this.date = plainDate;
        this.time = plainTime;
    }

    public static PlainTimestamp of(PlainDate plainDate, PlainTime plainTime) {
        return new PlainTimestamp(plainDate, plainTime);
    }

    public static PlainTimestamp of(int i, int i2, int i3, int i4, int i5) {
        return of(i, i2, i3, i4, i5, 0);
    }

    public static PlainTimestamp of(int i, int i2, int i3, int i4, int i5, int i6) {
        return of(PlainDate.of(i, i2, i3), PlainTime.of(i4, i5, i6));
    }

    public static PlainTimestamp nowInSystemTime() {
        return ZonalClock.ofSystem().now();
    }

    public PlainDate getCalendarDate() {
        return this.date;
    }

    public PlainTime getWallTime() {
        return this.time;
    }

    public int getYear() {
        return this.date.getYear();
    }

    public int getMonth() {
        return this.date.getMonth();
    }

    public int getDayOfMonth() {
        return this.date.getDayOfMonth();
    }

    public int getHour() {
        return this.time.getHour();
    }

    public int getMinute() {
        return this.time.getMinute();
    }

    public int getSecond() {
        return this.time.getSecond();
    }

    public int getNanosecond() {
        return this.time.getNanosecond();
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [net.time4j.ElementOperator<?>, net.time4j.ElementOperator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.time4j.PlainTimestamp with(net.time4j.ElementOperator<?> r1) {
        /*
            r0 = this;
            net.time4j.engine.ChronoOperator r1 = r1.onTimestamp()
            net.time4j.engine.ChronoEntity r1 = r0.with(r1)
            net.time4j.PlainTimestamp r1 = (net.time4j.PlainTimestamp) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.PlainTimestamp.with(net.time4j.ElementOperator):net.time4j.PlainTimestamp");
    }

    public PlainTimestamp with(PlainDate plainDate) {
        return (PlainTimestamp) with(PlainDate.CALENDAR_DATE, plainDate);
    }

    public PlainTimestamp with(PlainTime plainTime) {
        return (PlainTimestamp) with(PlainTime.WALL_TIME, plainTime);
    }

    public boolean isBefore(PlainTimestamp plainTimestamp) {
        return compareTo(plainTimestamp) < 0;
    }

    public boolean isAfter(PlainTimestamp plainTimestamp) {
        return compareTo(plainTimestamp) > 0;
    }

    public boolean isSimultaneous(PlainTimestamp plainTimestamp) {
        return compareTo(plainTimestamp) == 0;
    }

    public int compareTo(PlainTimestamp plainTimestamp) {
        if (this.date.isAfter((CalendarDate) plainTimestamp.date)) {
            return 1;
        }
        if (this.date.isBefore((CalendarDate) plainTimestamp.date)) {
            return -1;
        }
        return this.time.compareTo(plainTimestamp.time);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlainTimestamp)) {
            return false;
        }
        PlainTimestamp plainTimestamp = (PlainTimestamp) obj;
        if (!this.date.equals(plainTimestamp.date) || !this.time.equals(plainTimestamp.time)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.date.hashCode() * 13) + (this.time.hashCode() * 37);
    }

    public String toString() {
        return this.date.toString() + this.time.toString();
    }

    public PlainDate toDate() {
        return this.date;
    }

    public PlainTime toTime() {
        return this.time;
    }

    public String print(TemporalFormatter<PlainTimestamp> temporalFormatter) {
        return temporalFormatter.print(this);
    }

    public static PlainTimestamp parse(String str, TemporalFormatter<PlainTimestamp> temporalFormatter) {
        try {
            return temporalFormatter.parse(str);
        } catch (ParseException e) {
            throw new ChronoException(e.getMessage(), e);
        }
    }

    public static TimeAxis<IsoUnit, PlainTimestamp> axis() {
        return ENGINE;
    }

    public static <S> Chronology<S> axis(Converter<S, PlainTimestamp> converter) {
        return new BridgeChronology(converter, ENGINE);
    }

    public Moment atUTC() {
        return at(ZonalOffset.UTC);
    }

    public Moment at(ZonalOffset zonalOffset) {
        long safeMultiply = MathUtils.safeMultiply(this.date.getDaysSinceUTC() + 730, 86400) + ((long) (this.time.getHour() * NikonType2MakernoteDirectory.TAG_NIKON_SCAN)) + ((long) (this.time.getMinute() * 60)) + ((long) this.time.getSecond());
        int nanosecond = this.time.getNanosecond();
        long integralAmount = safeMultiply - ((long) zonalOffset.getIntegralAmount());
        int fractionalAmount = nanosecond - zonalOffset.getFractionalAmount();
        if (fractionalAmount < 0) {
            fractionalAmount += MRD;
            integralAmount--;
        } else if (fractionalAmount >= MRD) {
            fractionalAmount -= MRD;
            integralAmount++;
        }
        return Moment.of(integralAmount, fractionalAmount, TimeScale.POSIX);
    }

    public Moment inStdTimezone() {
        return in(Timezone.ofSystem());
    }

    public Moment inTimezone(TZID tzid) {
        return in(Timezone.of(tzid));
    }

    public Moment in(Timezone timezone) {
        if (timezone.isFixed()) {
            return at(timezone.getOffset(this.date, this.time));
        }
        TransitionStrategy strategy = timezone.getStrategy();
        long resolve = strategy.resolve(this.date, this.time, timezone);
        Moment of = Moment.of(resolve, this.time.getNanosecond(), TimeScale.POSIX);
        if (strategy == Timezone.STRICT_MODE) {
            Moment.checkNegativeLS(resolve, this);
        }
        return of;
    }

    public ZonalDateTime inLocalView() {
        return inZonalView(Timezone.ofSystem());
    }

    public ZonalDateTime inZonalView(Timezone timezone) {
        return ZonalDateTime.of(in(timezone), timezone);
    }

    public boolean isValid(TZID tzid) {
        if (tzid == null) {
            return false;
        }
        return !Timezone.of(tzid).isInvalid(this.date, this.time);
    }

    public Duration<IsoUnit> normalize(TimeSpan<? extends IsoUnit> timeSpan) {
        return (Duration) until(plus(timeSpan), STD_METRIC);
    }

    /* access modifiers changed from: protected */
    public TimeAxis<IsoUnit, PlainTimestamp> getChronology() {
        return ENGINE;
    }

    static PlainTimestamp from(UnixTime unixTime, ZonalOffset zonalOffset) {
        long posixTime = unixTime.getPosixTime() + ((long) zonalOffset.getIntegralAmount());
        int nanosecond = unixTime.getNanosecond() + zonalOffset.getFractionalAmount();
        if (nanosecond < 0) {
            nanosecond += MRD;
            posixTime--;
        } else if (nanosecond >= MRD) {
            nanosecond -= MRD;
            posixTime++;
        }
        PlainDate of = PlainDate.of(MathUtils.floorDivide(posixTime, 86400), EpochDays.UNIX);
        int floorModulo = MathUtils.floorModulo(posixTime, 86400);
        int i = floorModulo % 60;
        int i2 = floorModulo / 60;
        return of(of, PlainTime.of(i2 / 60, i2 % 60, i, nanosecond));
    }

    private static void registerCalendarUnits(TimeAxis.Builder<IsoUnit, PlainTimestamp> builder) {
        EnumSet range = EnumSet.range(CalendarUnit.MILLENNIA, CalendarUnit.MONTHS);
        EnumSet range2 = EnumSet.range(CalendarUnit.WEEKS, CalendarUnit.DAYS);
        for (CalendarUnit calendarUnit : CalendarUnit.values()) {
            builder.appendUnit(calendarUnit, new CompositeUnitRule(calendarUnit), calendarUnit.getLength(), calendarUnit.compareTo(CalendarUnit.WEEKS) < 0 ? range : range2);
        }
    }

    private static void registerClockUnits(TimeAxis.Builder<IsoUnit, PlainTimestamp> builder) {
        for (ClockUnit clockUnit : ClockUnit.values()) {
            builder.appendUnit(clockUnit, new CompositeUnitRule(clockUnit), clockUnit.getLength(), EnumSet.allOf(ClockUnit.class));
        }
    }

    private static void registerExtensions(TimeAxis.Builder<IsoUnit, PlainTimestamp> builder) {
        for (ChronoExtension appendExtension : PlainDate.axis().getExtensions()) {
            builder.appendExtension(appendExtension);
        }
        for (ChronoExtension appendExtension2 : PlainTime.axis().getExtensions()) {
            builder.appendExtension(appendExtension2);
        }
    }

    private Object writeReplace() {
        return new SPX(this, 8);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private static class Merger implements ChronoMerger<PlainTimestamp> {
        public ChronoDisplay preformat(PlainTimestamp plainTimestamp, AttributeQuery attributeQuery) {
            return plainTimestamp;
        }

        public Chronology<?> preparser() {
            return null;
        }

        private Merger() {
        }

        /* synthetic */ Merger(AnonymousClass1 r1) {
            this();
        }

        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            DisplayMode ofStyle = DisplayMode.ofStyle(displayStyle.getStyleValue());
            return CalendarText.patternForTimestamp(ofStyle, ofStyle, locale);
        }

        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.MIDNIGHT;
        }

        public int getDefaultPivotYear() {
            return PlainDate.axis().getDefaultPivotYear();
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [net.time4j.base.TimeSource, net.time4j.base.TimeSource<?>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.PlainTimestamp createFrom(net.time4j.base.TimeSource<?> r3, net.time4j.engine.AttributeQuery r4) {
            /*
                r2 = this;
                net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r0 = net.time4j.format.Attributes.TIMEZONE_ID
                boolean r0 = r4.contains(r0)
                if (r0 == 0) goto L_0x0015
                net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r0 = net.time4j.format.Attributes.TIMEZONE_ID
                java.lang.Object r4 = r4.get(r0)
                net.time4j.tz.TZID r4 = (net.time4j.tz.TZID) r4
                net.time4j.tz.Timezone r4 = net.time4j.tz.Timezone.of((net.time4j.tz.TZID) r4)
                goto L_0x0029
            L_0x0015:
                net.time4j.engine.AttributeKey<net.time4j.format.Leniency> r0 = net.time4j.format.Attributes.LENIENCY
                net.time4j.format.Leniency r1 = net.time4j.format.Leniency.SMART
                java.lang.Object r4 = r4.get(r0, r1)
                net.time4j.format.Leniency r4 = (net.time4j.format.Leniency) r4
                boolean r4 = r4.isLax()
                if (r4 == 0) goto L_0x0036
                net.time4j.tz.Timezone r4 = net.time4j.tz.Timezone.ofSystem()
            L_0x0029:
                net.time4j.base.UnixTime r3 = r3.currentTime()
                net.time4j.tz.ZonalOffset r4 = r4.getOffset(r3)
                net.time4j.PlainTimestamp r3 = net.time4j.PlainTimestamp.from(r3, r4)
                return r3
            L_0x0036:
                r3 = 0
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.PlainTimestamp.Merger.createFrom(net.time4j.base.TimeSource, net.time4j.engine.AttributeQuery):net.time4j.PlainTimestamp");
        }

        /* JADX WARNING: type inference failed for: r7v10, types: [net.time4j.engine.TimePoint] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.PlainTimestamp createFrom(net.time4j.engine.ChronoEntity<?> r5, net.time4j.engine.AttributeQuery r6, boolean r7, boolean r8) {
            /*
                r4 = this;
                boolean r0 = r5 instanceof net.time4j.base.UnixTime
                if (r0 == 0) goto L_0x0032
                net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r8 = net.time4j.format.Attributes.TIMEZONE_ID
                boolean r8 = r6.contains(r8)
                if (r8 == 0) goto L_0x0015
                net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r7 = net.time4j.format.Attributes.TIMEZONE_ID
                java.lang.Object r6 = r6.get(r7)
                net.time4j.tz.TZID r6 = (net.time4j.tz.TZID) r6
                goto L_0x0019
            L_0x0015:
                if (r7 == 0) goto L_0x002a
                net.time4j.tz.ZonalOffset r6 = net.time4j.tz.ZonalOffset.UTC
            L_0x0019:
                java.lang.Class<net.time4j.base.UnixTime> r7 = net.time4j.base.UnixTime.class
                java.lang.Object r5 = r7.cast(r5)
                net.time4j.base.UnixTime r5 = (net.time4j.base.UnixTime) r5
                net.time4j.Moment r5 = net.time4j.Moment.from(r5)
                net.time4j.PlainTimestamp r5 = r5.toZonalTimestamp((net.time4j.tz.TZID) r6)
                return r5
            L_0x002a:
                java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
                java.lang.String r6 = "Missing timezone attribute for type conversion."
                r5.<init>(r6)
                throw r5
            L_0x0032:
                r0 = 0
                if (r8 == 0) goto L_0x0041
                net.time4j.ProportionalElement<java.lang.Integer, net.time4j.PlainTime> r8 = net.time4j.PlainTime.SECOND_OF_MINUTE
                int r8 = r5.getInt(r8)
                r1 = 60
                if (r8 != r1) goto L_0x0041
                r8 = 1
                goto L_0x0042
            L_0x0041:
                r8 = 0
            L_0x0042:
                if (r8 == 0) goto L_0x004b
                net.time4j.ProportionalElement<java.lang.Integer, net.time4j.PlainTime> r1 = net.time4j.PlainTime.SECOND_OF_MINUTE
                r2 = 59
                r5.with((net.time4j.engine.ChronoElement<java.lang.Integer>) r1, (int) r2)
            L_0x004b:
                net.time4j.engine.ChronoElement<net.time4j.PlainDate> r1 = net.time4j.PlainDate.CALENDAR_DATE
                boolean r1 = r5.contains(r1)
                if (r1 == 0) goto L_0x005c
                net.time4j.engine.ChronoElement<net.time4j.PlainDate> r1 = net.time4j.PlainDate.CALENDAR_DATE
                java.lang.Object r1 = r5.get(r1)
                net.time4j.PlainDate r1 = (net.time4j.PlainDate) r1
                goto L_0x0066
            L_0x005c:
                net.time4j.engine.TimeAxis r1 = net.time4j.PlainDate.axis()
                net.time4j.engine.TimePoint r1 = r1.createFrom((net.time4j.engine.ChronoEntity) r5, (net.time4j.engine.AttributeQuery) r6, (boolean) r7, (boolean) r0)
                net.time4j.PlainDate r1 = (net.time4j.PlainDate) r1
            L_0x0066:
                r2 = 0
                if (r1 != 0) goto L_0x006a
                return r2
            L_0x006a:
                net.time4j.engine.ChronoElement<net.time4j.PlainTime> r3 = net.time4j.PlainTime.WALL_TIME
                boolean r3 = r5.contains(r3)
                if (r3 == 0) goto L_0x007b
                net.time4j.engine.ChronoElement<net.time4j.PlainTime> r6 = net.time4j.PlainTime.WALL_TIME
                java.lang.Object r6 = r5.get(r6)
                net.time4j.PlainTime r6 = (net.time4j.PlainTime) r6
                goto L_0x008b
            L_0x007b:
                net.time4j.engine.TimeAxis r3 = net.time4j.PlainTime.axis()
                net.time4j.engine.TimePoint r6 = r3.createFrom((net.time4j.engine.ChronoEntity) r5, (net.time4j.engine.AttributeQuery) r6, (boolean) r7, (boolean) r0)
                net.time4j.PlainTime r6 = (net.time4j.PlainTime) r6
                if (r6 != 0) goto L_0x008b
                if (r7 == 0) goto L_0x008b
                net.time4j.PlainTime r6 = net.time4j.PlainTime.MIN
            L_0x008b:
                if (r6 != 0) goto L_0x008e
                return r2
            L_0x008e:
                net.time4j.engine.ChronoElement<java.lang.Long> r7 = net.time4j.LongElement.DAY_OVERFLOW
                boolean r7 = r5.contains(r7)
                if (r7 == 0) goto L_0x00ab
                net.time4j.engine.ChronoElement<java.lang.Long> r7 = net.time4j.LongElement.DAY_OVERFLOW
                java.lang.Object r7 = r5.get(r7)
                java.lang.Long r7 = (java.lang.Long) r7
                long r2 = r7.longValue()
                net.time4j.CalendarUnit r7 = net.time4j.CalendarUnit.DAYS
                net.time4j.engine.TimePoint r7 = r1.plus(r2, r7)
                r1 = r7
                net.time4j.PlainDate r1 = (net.time4j.PlainDate) r1
            L_0x00ab:
                if (r8 == 0) goto L_0x00be
                net.time4j.engine.FlagElement r7 = net.time4j.engine.FlagElement.LEAP_SECOND
                java.lang.Boolean r8 = java.lang.Boolean.TRUE
                boolean r7 = r5.isValid(r7, r8)
                if (r7 == 0) goto L_0x00be
                net.time4j.engine.FlagElement r7 = net.time4j.engine.FlagElement.LEAP_SECOND
                java.lang.Boolean r8 = java.lang.Boolean.TRUE
                r5.with(r7, r8)
            L_0x00be:
                net.time4j.PlainTimestamp r5 = net.time4j.PlainTimestamp.of(r1, r6)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.PlainTimestamp.Merger.createFrom(net.time4j.engine.ChronoEntity, net.time4j.engine.AttributeQuery, boolean, boolean):net.time4j.PlainTimestamp");
        }
    }

    private static class FieldRule<V> implements ElementRule<PlainTimestamp, V> {
        /* access modifiers changed from: private */
        public final ChronoElement<V> element;

        /* synthetic */ FieldRule(ChronoElement chronoElement, AnonymousClass1 r2) {
            this(chronoElement);
        }

        private FieldRule(ChronoElement<V> chronoElement) {
            this.element = chronoElement;
        }

        static <V> FieldRule<V> of(ChronoElement<V> chronoElement) {
            return new FieldRule<>(chronoElement);
        }

        public V getValue(PlainTimestamp plainTimestamp) {
            if (this.element.isDateElement()) {
                return plainTimestamp.date.get(this.element);
            }
            if (this.element.isTimeElement()) {
                return plainTimestamp.time.get(this.element);
            }
            throw new ChronoException("Missing rule for: " + this.element.name());
        }

        public V getMinimum(PlainTimestamp plainTimestamp) {
            if (this.element.isDateElement()) {
                return plainTimestamp.date.getMinimum(this.element);
            }
            if (this.element.isTimeElement()) {
                return this.element.getDefaultMinimum();
            }
            throw new ChronoException("Missing rule for: " + this.element.name());
        }

        public V getMaximum(PlainTimestamp plainTimestamp) {
            if (this.element.isDateElement()) {
                return plainTimestamp.date.getMaximum(this.element);
            }
            if (this.element.isTimeElement()) {
                return this.element.getDefaultMaximum();
            }
            throw new ChronoException("Missing rule for: " + this.element.name());
        }

        public boolean isValid(PlainTimestamp plainTimestamp, V v) {
            if (v == null) {
                return false;
            }
            if (this.element.isDateElement()) {
                return plainTimestamp.date.isValid(this.element, v);
            }
            if (!this.element.isTimeElement()) {
                throw new ChronoException("Missing rule for: " + this.element.name());
            } else if (Number.class.isAssignableFrom(this.element.getType())) {
                long number = toNumber(this.element.getDefaultMinimum());
                long number2 = toNumber(this.element.getDefaultMaximum());
                long number3 = toNumber(v);
                if (number > number3 || number2 < number3) {
                    return false;
                }
                return true;
            } else if (!this.element.equals(PlainTime.WALL_TIME) || !PlainTime.MAX.equals(v)) {
                return plainTimestamp.time.isValid(this.element, v);
            } else {
                return false;
            }
        }

        public PlainTimestamp withValue(PlainTimestamp plainTimestamp, V v, boolean z) {
            if (v == null) {
                throw new IllegalArgumentException("Missing element value.");
            } else if (v.equals(getValue(plainTimestamp))) {
                return plainTimestamp;
            } else {
                if (z) {
                    return (PlainTimestamp) plainTimestamp.plus(MathUtils.safeSubtract(toNumber(v), toNumber(getValue(plainTimestamp))), (IsoUnit) PlainTimestamp.ENGINE.getBaseUnit(this.element));
                } else if (this.element.isDateElement()) {
                    return PlainTimestamp.of((PlainDate) plainTimestamp.date.with(this.element, v), plainTimestamp.time);
                } else {
                    if (this.element.isTimeElement()) {
                        if (Number.class.isAssignableFrom(this.element.getType())) {
                            long number = toNumber(this.element.getDefaultMinimum());
                            long number2 = toNumber(this.element.getDefaultMaximum());
                            long number3 = toNumber(v);
                            if (number > number3 || number2 < number3) {
                                throw new IllegalArgumentException("Out of range: " + v);
                            }
                        } else if (this.element.equals(PlainTime.WALL_TIME) && v.equals(PlainTime.MAX)) {
                            throw new IllegalArgumentException("Out of range: " + v);
                        }
                        return PlainTimestamp.of(plainTimestamp.date, (PlainTime) plainTimestamp.time.with(this.element, v));
                    }
                    throw new ChronoException("Missing rule for: " + this.element.name());
                }
            }
        }

        public ChronoElement<?> getChildAtFloor(PlainTimestamp plainTimestamp) {
            return (ChronoElement) PlainTimestamp.CHILDREN.get(this.element);
        }

        public ChronoElement<?> getChildAtCeiling(PlainTimestamp plainTimestamp) {
            return (ChronoElement) PlainTimestamp.CHILDREN.get(this.element);
        }

        private long toNumber(V v) {
            return Number.class.cast(v).longValue();
        }
    }

    private static class DecimalRule extends FieldRule<BigDecimal> {
        DecimalRule(ChronoElement<BigDecimal> chronoElement) {
            super(chronoElement, (AnonymousClass1) null);
        }

        public boolean isValid(PlainTimestamp plainTimestamp, BigDecimal bigDecimal) {
            if (bigDecimal == null) {
                return false;
            }
            BigDecimal bigDecimal2 = (BigDecimal) this.element.getDefaultMaximum();
            if (((BigDecimal) this.element.getDefaultMinimum()).compareTo(bigDecimal) > 0 || bigDecimal.compareTo(bigDecimal2) > 0) {
                return false;
            }
            return true;
        }

        public PlainTimestamp withValue(PlainTimestamp plainTimestamp, BigDecimal bigDecimal, boolean z) {
            if (isValid(plainTimestamp, bigDecimal)) {
                return PlainTimestamp.of(plainTimestamp.date, (PlainTime) plainTimestamp.time.with(this.element, bigDecimal));
            }
            throw new IllegalArgumentException("Out of range: " + bigDecimal);
        }
    }

    private static class CompositeUnitRule implements UnitRule<PlainTimestamp> {
        private final CalendarUnit calendarUnit;
        private final ClockUnit clockUnit;

        CompositeUnitRule(CalendarUnit calendarUnit2) {
            this.calendarUnit = calendarUnit2;
            this.clockUnit = null;
        }

        CompositeUnitRule(ClockUnit clockUnit2) {
            this.calendarUnit = null;
            this.clockUnit = clockUnit2;
        }

        public PlainTimestamp addTo(PlainTimestamp plainTimestamp, long j) {
            PlainDate plainDate;
            PlainTime plainTime;
            if (this.calendarUnit != null) {
                plainDate = (PlainDate) plainTimestamp.date.plus(j, this.calendarUnit);
                plainTime = plainTimestamp.time;
            } else {
                DayCycles roll = plainTimestamp.time.roll(j, this.clockUnit);
                PlainTime wallTime = roll.getWallTime();
                plainDate = (PlainDate) plainTimestamp.date.plus(roll.getDayOverflow(), CalendarUnit.DAYS);
                plainTime = wallTime;
            }
            return PlainTimestamp.of(plainDate, plainTime);
        }

        public long between(PlainTimestamp plainTimestamp, PlainTimestamp plainTimestamp2) {
            long j;
            CalendarUnit calendarUnit2 = this.calendarUnit;
            if (calendarUnit2 != null) {
                long between = calendarUnit2.between(plainTimestamp.date, plainTimestamp2.date);
                int i = (between > 0 ? 1 : (between == 0 ? 0 : -1));
                if (i == 0) {
                    return between;
                }
                boolean z = true;
                if (!(this.calendarUnit == CalendarUnit.DAYS || ((PlainDate) plainTimestamp.date.plus(between, this.calendarUnit)).compareByTime(plainTimestamp2.date) == 0)) {
                    z = false;
                }
                if (!z) {
                    return between;
                }
                PlainTime access$200 = plainTimestamp.time;
                PlainTime access$2002 = plainTimestamp2.time;
                if (i > 0 && access$200.isAfter(access$2002)) {
                    return between - 1;
                }
                if (i >= 0 || !access$200.isBefore(access$2002)) {
                    return between;
                }
                return between + 1;
            } else if (plainTimestamp.date.isAfter((CalendarDate) plainTimestamp2.date)) {
                return -between(plainTimestamp2, plainTimestamp);
            } else {
                long until = plainTimestamp.date.until(plainTimestamp2.date, CalendarUnit.DAYS);
                if (until == 0) {
                    return this.clockUnit.between(plainTimestamp.time, plainTimestamp2.time);
                }
                if (this.clockUnit.compareTo(ClockUnit.SECONDS) <= 0) {
                    long safeAdd = MathUtils.safeAdd(MathUtils.safeMultiply(until, 86400), MathUtils.safeSubtract(((Integer) plainTimestamp2.time.get(PlainTime.SECOND_OF_DAY)).longValue(), ((Integer) plainTimestamp.time.get(PlainTime.SECOND_OF_DAY)).longValue()));
                    if (plainTimestamp.time.getNanosecond() > plainTimestamp2.time.getNanosecond()) {
                        safeAdd--;
                    }
                    j = safeAdd;
                } else {
                    j = MathUtils.safeAdd(MathUtils.safeMultiply(until, 86400000000000L), MathUtils.safeSubtract(((Long) plainTimestamp2.time.get(PlainTime.NANO_OF_DAY)).longValue(), ((Long) plainTimestamp.time.get(PlainTime.NANO_OF_DAY)).longValue()));
                }
                switch (AnonymousClass1.$SwitchMap$net$time4j$ClockUnit[this.clockUnit.ordinal()]) {
                    case 1:
                        return j / 3600;
                    case 2:
                        return j / 60;
                    case 3:
                    case 6:
                        return j;
                    case 4:
                        return j / AnimationKt.MillisToNanos;
                    case 5:
                        return j / 1000;
                    default:
                        throw new UnsupportedOperationException(this.clockUnit.name());
                }
            }
        }
    }

    /* renamed from: net.time4j.PlainTimestamp$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$ClockUnit;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                net.time4j.ClockUnit[] r0 = net.time4j.ClockUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$ClockUnit = r0
                net.time4j.ClockUnit r1 = net.time4j.ClockUnit.HOURS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$ClockUnit     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.ClockUnit r1 = net.time4j.ClockUnit.MINUTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$ClockUnit     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.ClockUnit r1 = net.time4j.ClockUnit.SECONDS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$net$time4j$ClockUnit     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.ClockUnit r1 = net.time4j.ClockUnit.MILLIS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$net$time4j$ClockUnit     // Catch:{ NoSuchFieldError -> 0x003e }
                net.time4j.ClockUnit r1 = net.time4j.ClockUnit.MICROS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$net$time4j$ClockUnit     // Catch:{ NoSuchFieldError -> 0x0049 }
                net.time4j.ClockUnit r1 = net.time4j.ClockUnit.NANOS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.PlainTimestamp.AnonymousClass1.<clinit>():void");
        }
    }
}
