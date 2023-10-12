package net.time4j;

import androidx.compose.animation.core.AnimationKt;
import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.DayPeriod;
import net.time4j.base.MathUtils;
import net.time4j.base.ResourceLoader;
import net.time4j.base.UnixTime;
import net.time4j.base.WallTime;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.BridgeChronology;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.ChronoExtension;
import net.time4j.engine.ChronoMerger;
import net.time4j.engine.Chronology;
import net.time4j.engine.Converter;
import net.time4j.engine.DisplayStyle;
import net.time4j.engine.ElementRule;
import net.time4j.engine.FormattableElement;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.Temporal;
import net.time4j.engine.TimeAxis;
import net.time4j.engine.TimePoint;
import net.time4j.engine.UnitRule;
import net.time4j.engine.ValidationElement;
import net.time4j.format.CalendarText;
import net.time4j.format.CalendarType;
import net.time4j.format.DisplayMode;
import net.time4j.format.LocalizedPatternSupport;
import net.time4j.format.TemporalFormatter;
import net.time4j.tz.ZonalOffset;
import org.apache.commons.lang3.ClassUtils;

@CalendarType("iso8601")
public final class PlainTime extends TimePoint<IsoTimeUnit, PlainTime> implements WallTime, Temporal<PlainTime>, LocalizedPatternSupport {
    @FormattableElement(format = "a")
    public static final ZonalElement<Meridiem> AM_PM_OF_DAY;
    @FormattableElement(format = "h")
    public static final AdjustableElement<Integer, PlainTime> CLOCK_HOUR_OF_AMPM;
    @FormattableElement(format = "k")
    public static final AdjustableElement<Integer, PlainTime> CLOCK_HOUR_OF_DAY;
    public static final WallTimeElement COMPONENT = TimeElement.INSTANCE;
    private static final BigDecimal DECIMAL_23_9 = new BigDecimal("23.999999999999999");
    /* access modifiers changed from: private */
    public static final BigDecimal DECIMAL_24_0 = new BigDecimal("24");
    /* access modifiers changed from: private */
    public static final BigDecimal DECIMAL_3600 = new BigDecimal(NikonType2MakernoteDirectory.TAG_NIKON_SCAN);
    private static final BigDecimal DECIMAL_59_9 = new BigDecimal("59.999999999999999");
    /* access modifiers changed from: private */
    public static final BigDecimal DECIMAL_60 = new BigDecimal(60);
    public static final ZonalElement<BigDecimal> DECIMAL_HOUR;
    public static final ZonalElement<BigDecimal> DECIMAL_MINUTE;
    /* access modifiers changed from: private */
    public static final BigDecimal DECIMAL_MRD = new BigDecimal(MRD);
    public static final ZonalElement<BigDecimal> DECIMAL_SECOND;
    @FormattableElement(format = "K")
    public static final ProportionalElement<Integer, PlainTime> DIGITAL_HOUR_OF_AMPM;
    @FormattableElement(format = "H")
    public static final ProportionalElement<Integer, PlainTime> DIGITAL_HOUR_OF_DAY;
    private static final Map<String, Object> ELEMENTS;
    private static final TimeAxis<IsoTimeUnit, PlainTime> ENGINE;
    private static final PlainTime[] HOURS = new PlainTime[25];
    public static final ProportionalElement<Integer, PlainTime> HOUR_FROM_0_TO_24;
    private static final ElementRule<PlainTime, BigDecimal> H_DECIMAL_RULE;
    static final char ISO_DECIMAL_SEPARATOR = (Boolean.getBoolean("net.time4j.format.iso.decimal.dot") ? ClassUtils.PACKAGE_SEPARATOR_CHAR : AbstractJsonLexerKt.COMMA);
    private static final int KILO = 1000;
    static final PlainTime MAX;
    public static final ProportionalElement<Long, PlainTime> MICRO_OF_DAY;
    public static final ProportionalElement<Integer, PlainTime> MICRO_OF_SECOND;
    @FormattableElement(format = "A")
    public static final ProportionalElement<Integer, PlainTime> MILLI_OF_DAY;
    public static final ProportionalElement<Integer, PlainTime> MILLI_OF_SECOND;
    static final PlainTime MIN;
    public static final ProportionalElement<Integer, PlainTime> MINUTE_OF_DAY;
    @FormattableElement(format = "m")
    public static final ProportionalElement<Integer, PlainTime> MINUTE_OF_HOUR;
    private static final int MIO = 1000000;
    private static final int MRD = 1000000000;
    /* access modifiers changed from: private */
    public static final ElementRule<PlainTime, BigDecimal> M_DECIMAL_RULE;
    public static final ProportionalElement<Long, PlainTime> NANO_OF_DAY;
    @FormattableElement(format = "S")
    public static final ProportionalElement<Integer, PlainTime> NANO_OF_SECOND;
    public static final ChronoElement<ClockUnit> PRECISION;
    public static final ProportionalElement<Integer, PlainTime> SECOND_OF_DAY;
    @FormattableElement(format = "s")
    public static final ProportionalElement<Integer, PlainTime> SECOND_OF_MINUTE;
    /* access modifiers changed from: private */
    public static final ElementRule<PlainTime, BigDecimal> S_DECIMAL_RULE;
    static final ChronoElement<PlainTime> WALL_TIME;
    private static final long serialVersionUID = 2780881537313863339L;
    /* access modifiers changed from: private */
    public final transient byte hour;
    /* access modifiers changed from: private */
    public final transient byte minute;
    /* access modifiers changed from: private */
    public final transient int nano;
    /* access modifiers changed from: private */
    public final transient byte second;

    /* access modifiers changed from: protected */
    public PlainTime getContext() {
        return this;
    }

    static {
        for (int i = 0; i <= 24; i++) {
            HOURS[i] = new PlainTime(i, 0, 0, 0, false);
        }
        PlainTime[] plainTimeArr = HOURS;
        PlainTime plainTime = plainTimeArr[0];
        MIN = plainTime;
        PlainTime plainTime2 = plainTimeArr[24];
        MAX = plainTime2;
        TimeElement timeElement = TimeElement.INSTANCE;
        WALL_TIME = timeElement;
        AmPmElement amPmElement = AmPmElement.AM_PM_OF_DAY;
        AM_PM_OF_DAY = amPmElement;
        IntegerTimeElement createClockElement = IntegerTimeElement.createClockElement("CLOCK_HOUR_OF_AMPM", false);
        CLOCK_HOUR_OF_AMPM = createClockElement;
        IntegerTimeElement createClockElement2 = IntegerTimeElement.createClockElement("CLOCK_HOUR_OF_DAY", true);
        CLOCK_HOUR_OF_DAY = createClockElement2;
        IntegerTimeElement createTimeElement = IntegerTimeElement.createTimeElement("DIGITAL_HOUR_OF_AMPM", 3, 0, 11, 'K');
        DIGITAL_HOUR_OF_AMPM = createTimeElement;
        IntegerTimeElement createTimeElement2 = IntegerTimeElement.createTimeElement("DIGITAL_HOUR_OF_DAY", 4, 0, 23, 'H');
        DIGITAL_HOUR_OF_DAY = createTimeElement2;
        IntegerTimeElement createTimeElement3 = IntegerTimeElement.createTimeElement("HOUR_FROM_0_TO_24", 5, 0, 23, 'H');
        HOUR_FROM_0_TO_24 = createTimeElement3;
        IntegerTimeElement createTimeElement4 = IntegerTimeElement.createTimeElement("MINUTE_OF_HOUR", 6, 0, 59, 'm');
        MINUTE_OF_HOUR = createTimeElement4;
        IntegerTimeElement createTimeElement5 = IntegerTimeElement.createTimeElement("MINUTE_OF_DAY", 7, 0, 1439, 0);
        MINUTE_OF_DAY = createTimeElement5;
        IntegerTimeElement createTimeElement6 = IntegerTimeElement.createTimeElement("SECOND_OF_MINUTE", 8, 0, 59, 's');
        SECOND_OF_MINUTE = createTimeElement6;
        IntegerTimeElement createTimeElement7 = IntegerTimeElement.createTimeElement("SECOND_OF_DAY", 9, 0, 86399, 0);
        SECOND_OF_DAY = createTimeElement7;
        PlainTime plainTime3 = plainTime2;
        IntegerTimeElement createTimeElement8 = IntegerTimeElement.createTimeElement("MILLI_OF_SECOND", 10, 0, 999, 0);
        MILLI_OF_SECOND = createTimeElement8;
        PlainTime plainTime4 = plainTime;
        IntegerTimeElement createTimeElement9 = IntegerTimeElement.createTimeElement("MICRO_OF_SECOND", 11, 0, 999999, 0);
        MICRO_OF_SECOND = createTimeElement9;
        IntegerTimeElement integerTimeElement = createTimeElement9;
        IntegerTimeElement integerTimeElement2 = createTimeElement8;
        IntegerTimeElement createTimeElement10 = IntegerTimeElement.createTimeElement("NANO_OF_SECOND", 12, 0, 999999999, 'S');
        NANO_OF_SECOND = createTimeElement10;
        IntegerTimeElement integerTimeElement3 = createTimeElement10;
        IntegerTimeElement createTimeElement11 = IntegerTimeElement.createTimeElement("MILLI_OF_DAY", 13, 0, 86399999, 'A');
        MILLI_OF_DAY = createTimeElement11;
        IntegerTimeElement integerTimeElement4 = createTimeElement7;
        LongElement create = LongElement.create("MICRO_OF_DAY", 0, 86399999999L);
        MICRO_OF_DAY = create;
        LongElement longElement = create;
        LongElement create2 = LongElement.create("NANO_OF_DAY", 0, 86399999999999L);
        NANO_OF_DAY = create2;
        DecimalTimeElement decimalTimeElement = new DecimalTimeElement("DECIMAL_HOUR", DECIMAL_23_9);
        DECIMAL_HOUR = decimalTimeElement;
        BigDecimal bigDecimal = DECIMAL_59_9;
        DecimalTimeElement decimalTimeElement2 = new DecimalTimeElement("DECIMAL_MINUTE", bigDecimal);
        DECIMAL_MINUTE = decimalTimeElement2;
        DecimalTimeElement decimalTimeElement3 = decimalTimeElement2;
        DecimalTimeElement decimalTimeElement4 = new DecimalTimeElement("DECIMAL_SECOND", bigDecimal);
        DECIMAL_SECOND = decimalTimeElement4;
        ChronoElement<ClockUnit> chronoElement = PrecisionElement.CLOCK_PRECISION;
        PRECISION = chronoElement;
        ChronoElement<ClockUnit> chronoElement2 = chronoElement;
        HashMap hashMap = new HashMap();
        fill(hashMap, timeElement);
        fill(hashMap, amPmElement);
        fill(hashMap, createClockElement);
        fill(hashMap, createClockElement2);
        fill(hashMap, createTimeElement);
        fill(hashMap, createTimeElement2);
        fill(hashMap, createTimeElement3);
        fill(hashMap, createTimeElement4);
        fill(hashMap, createTimeElement5);
        fill(hashMap, createTimeElement6);
        IntegerTimeElement integerTimeElement5 = createTimeElement6;
        fill(hashMap, integerTimeElement4);
        fill(hashMap, integerTimeElement2);
        fill(hashMap, integerTimeElement);
        IntegerTimeElement integerTimeElement6 = integerTimeElement3;
        fill(hashMap, integerTimeElement6);
        fill(hashMap, createTimeElement11);
        IntegerTimeElement integerTimeElement7 = createTimeElement11;
        LongElement longElement2 = longElement;
        fill(hashMap, longElement2);
        fill(hashMap, create2);
        fill(hashMap, decimalTimeElement);
        LongElement longElement3 = create2;
        DecimalTimeElement decimalTimeElement5 = decimalTimeElement3;
        fill(hashMap, decimalTimeElement5);
        fill(hashMap, decimalTimeElement4);
        ELEMENTS = Collections.unmodifiableMap(hashMap);
        LongElement longElement4 = longElement2;
        BigDecimalElementRule bigDecimalElementRule = new BigDecimalElementRule(decimalTimeElement, DECIMAL_24_0);
        H_DECIMAL_RULE = bigDecimalElementRule;
        BigDecimalElementRule bigDecimalElementRule2 = new BigDecimalElementRule(decimalTimeElement5, bigDecimal);
        M_DECIMAL_RULE = bigDecimalElementRule2;
        DecimalTimeElement decimalTimeElement6 = decimalTimeElement5;
        BigDecimalElementRule bigDecimalElementRule3 = new BigDecimalElementRule(decimalTimeElement4, bigDecimal);
        S_DECIMAL_RULE = bigDecimalElementRule3;
        TimeAxis.Builder appendElement = TimeAxis.Builder.setUp(IsoTimeUnit.class, PlainTime.class, new Merger((AnonymousClass1) null), plainTime4, plainTime3).appendElement((ChronoElement) timeElement, (ElementRule) new TimeRule((AnonymousClass1) null)).appendElement((ChronoElement) amPmElement, (ElementRule) new MeridiemRule((AnonymousClass1) null)).appendElement(createClockElement, new IntegerElementRule(createClockElement, 1, 12), ClockUnit.HOURS).appendElement(createClockElement2, new IntegerElementRule(createClockElement2, 1, 24), ClockUnit.HOURS).appendElement(createTimeElement, new IntegerElementRule(createTimeElement, 0, 11), ClockUnit.HOURS).appendElement(createTimeElement2, new IntegerElementRule(createTimeElement2, 0, 23), ClockUnit.HOURS).appendElement(createTimeElement3, new IntegerElementRule(createTimeElement3, 0, 24), ClockUnit.HOURS).appendElement(createTimeElement4, new IntegerElementRule(createTimeElement4, 0, 59), ClockUnit.MINUTES).appendElement(createTimeElement5, new IntegerElementRule(createTimeElement5, 0, 1440), ClockUnit.MINUTES);
        IntegerTimeElement integerTimeElement8 = integerTimeElement5;
        TimeAxis.Builder appendElement2 = appendElement.appendElement(integerTimeElement8, new IntegerElementRule(integerTimeElement8, 0, 59), ClockUnit.SECONDS);
        IntegerTimeElement integerTimeElement9 = integerTimeElement4;
        IntegerTimeElement integerTimeElement10 = integerTimeElement2;
        TimeAxis.Builder appendElement3 = appendElement2.appendElement(integerTimeElement9, new IntegerElementRule(integerTimeElement9, 0, 86400), ClockUnit.SECONDS).appendElement(integerTimeElement10, new IntegerElementRule(integerTimeElement10, 0, 999), ClockUnit.MILLIS);
        IntegerTimeElement integerTimeElement11 = integerTimeElement;
        IntegerTimeElement integerTimeElement12 = integerTimeElement7;
        DecimalTimeElement decimalTimeElement7 = decimalTimeElement4;
        ChronoElement<ClockUnit> chronoElement3 = chronoElement2;
        TimeAxis.Builder appendElement4 = appendElement3.appendElement(integerTimeElement11, new IntegerElementRule(integerTimeElement11, 0, 999999), ClockUnit.MICROS).appendElement(integerTimeElement6, new IntegerElementRule(integerTimeElement6, 0, 999999999), ClockUnit.NANOS).appendElement(integerTimeElement12, new IntegerElementRule(integerTimeElement12, 0, 86400000), ClockUnit.MILLIS).appendElement(longElement4, new LongElementRule(longElement4, 0, 86400000000L), ClockUnit.MICROS).appendElement(longElement3, new LongElementRule(longElement3, 0, 86400000000000L), ClockUnit.NANOS).appendElement((ChronoElement) decimalTimeElement, (ElementRule) bigDecimalElementRule).appendElement((ChronoElement) decimalTimeElement6, (ElementRule) bigDecimalElementRule2).appendElement((ChronoElement) decimalTimeElement7, (ElementRule) bigDecimalElementRule3).appendElement((ChronoElement) chronoElement3, (ElementRule) new PrecisionRule((AnonymousClass1) null));
        registerExtensions(appendElement4);
        registerUnits(appendElement4);
        ENGINE = appendElement4.build();
    }

    private PlainTime(int i, int i2, int i3, int i4, boolean z) {
        if (z) {
            checkHour((long) i);
            checkMinute((long) i2);
            checkSecond((long) i3);
            checkNano(i4);
            if (i == 24 && (i2 | i3 | i4) != 0) {
                throw new IllegalArgumentException("T24:00:00 exceeded.");
            }
        }
        this.hour = (byte) i;
        this.minute = (byte) i2;
        this.second = (byte) i3;
        this.nano = i4;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    public int getNanosecond() {
        return this.nano;
    }

    public static PlainTime midnightAtStartOfDay() {
        return MIN;
    }

    public static PlainTime midnightAtEndOfDay() {
        return MAX;
    }

    public static PlainTime of(int i) {
        checkHour((long) i);
        return HOURS[i];
    }

    public static PlainTime of(int i, int i2) {
        if (i2 == 0) {
            return of(i);
        }
        return new PlainTime(i, i2, 0, 0, true);
    }

    public static PlainTime of(int i, int i2, int i3) {
        if ((i2 | i3) == 0) {
            return of(i);
        }
        return new PlainTime(i, i2, i3, 0, true);
    }

    public static PlainTime of(int i, int i2, int i3, int i4) {
        return of(i, i2, i3, i4, true);
    }

    public static PlainTime of(BigDecimal bigDecimal) {
        return H_DECIMAL_RULE.withValue(null, bigDecimal, false);
    }

    public static PlainTime nowInSystemTime() {
        return ZonalClock.ofSystem().now().toTime();
    }

    public static PlainTime from(WallTime wallTime) {
        if (wallTime instanceof PlainTime) {
            return (PlainTime) wallTime;
        }
        if (wallTime instanceof PlainTimestamp) {
            return ((PlainTimestamp) wallTime).getWallTime();
        }
        return of(wallTime.getHour(), wallTime.getMinute(), wallTime.getSecond(), wallTime.getNanosecond());
    }

    public DayCycles roll(long j, ClockUnit clockUnit) {
        return ClockUnitRule.addToWithOverflow(this, j, clockUnit);
    }

    public String print(TemporalFormatter<PlainTime> temporalFormatter) {
        return temporalFormatter.print(this);
    }

    public static PlainTime parse(String str, TemporalFormatter<PlainTime> temporalFormatter) {
        try {
            return temporalFormatter.parse(str);
        } catch (ParseException e) {
            throw new ChronoException(e.getMessage(), e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlainTime)) {
            return false;
        }
        PlainTime plainTime = (PlainTime) obj;
        if (this.hour == plainTime.hour && this.minute == plainTime.minute && this.second == plainTime.second && this.nano == plainTime.nano) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.hour + (this.minute * 60) + (this.second * Tnaf.POW_2_WIDTH) + (this.nano * 37);
    }

    public boolean isBefore(PlainTime plainTime) {
        return compareTo(plainTime) < 0;
    }

    public boolean isAfter(PlainTime plainTime) {
        return compareTo(plainTime) > 0;
    }

    public boolean isSimultaneous(PlainTime plainTime) {
        return compareTo(plainTime) == 0;
    }

    public boolean isMidnight() {
        return isFullHour() && this.hour % 24 == 0;
    }

    public int compareTo(PlainTime plainTime) {
        int i = this.hour - plainTime.hour;
        if (i == 0 && (i = this.minute - plainTime.minute) == 0 && (i = this.second - plainTime.second) == 0) {
            i = this.nano - plainTime.nano;
        }
        if (i < 0) {
            return -1;
        }
        return i == 0 ? 0 : 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(19);
        sb.append('T');
        append2Digits(this.hour, sb);
        if ((this.minute | this.second | this.nano) != 0) {
            sb.append(AbstractJsonLexerKt.COLON);
            append2Digits(this.minute, sb);
            if ((this.second | this.nano) != 0) {
                sb.append(AbstractJsonLexerKt.COLON);
                append2Digits(this.second, sb);
                int i = this.nano;
                if (i != 0) {
                    printNanos(sb, i);
                }
            }
        }
        return sb.toString();
    }

    public static TimeAxis<IsoTimeUnit, PlainTime> axis() {
        return ENGINE;
    }

    public static <S> Chronology<S> axis(Converter<S, PlainTime> converter) {
        return new BridgeChronology(converter, ENGINE);
    }

    /* access modifiers changed from: protected */
    public TimeAxis<IsoTimeUnit, PlainTime> getChronology() {
        return ENGINE;
    }

    static void printNanos(StringBuilder sb, int i) {
        int i2;
        sb.append(ISO_DECIMAL_SEPARATOR);
        String num = Integer.toString(i);
        if (i % 1000000 == 0) {
            i2 = 3;
        } else {
            i2 = i % 1000 == 0 ? 6 : 9;
        }
        for (int length = num.length(); length < 9; length++) {
            sb.append('0');
        }
        int length2 = (i2 + num.length()) - 9;
        for (int i3 = 0; i3 < length2; i3++) {
            sb.append(num.charAt(i3));
        }
    }

    static PlainTime from(UnixTime unixTime, ZonalOffset zonalOffset) {
        long posixTime = unixTime.getPosixTime() + ((long) zonalOffset.getIntegralAmount());
        int nanosecond = unixTime.getNanosecond() + zonalOffset.getFractionalAmount();
        if (nanosecond < 0) {
            nanosecond += MRD;
            posixTime--;
        } else if (nanosecond >= MRD) {
            nanosecond -= MRD;
            posixTime++;
        }
        int floorModulo = MathUtils.floorModulo(posixTime, 86400);
        int i = floorModulo % 60;
        int i2 = floorModulo / 60;
        return of(i2 / 60, i2 % 60, i, nanosecond);
    }

    static Object lookupElement(String str) {
        return ELEMENTS.get(str);
    }

    /* access modifiers changed from: package-private */
    public boolean hasReducedRange(ChronoElement<?> chronoElement) {
        return (chronoElement == MILLI_OF_DAY && this.nano % 1000000 != 0) || (chronoElement == HOUR_FROM_0_TO_24 && !isFullHour()) || ((chronoElement == MINUTE_OF_DAY && !isFullMinute()) || ((chronoElement == SECOND_OF_DAY && this.nano != 0) || (chronoElement == MICRO_OF_DAY && this.nano % 1000 != 0)));
    }

    /* access modifiers changed from: private */
    public static PlainTime of(int i, int i2, int i3, int i4, boolean z) {
        if ((i2 | i3 | i4) != 0) {
            return new PlainTime(i, i2, i3, i4, z);
        }
        if (z) {
            return of(i);
        }
        return HOURS[i];
    }

    private static void fill(Map<String, Object> map, ChronoElement<?> chronoElement) {
        map.put(chronoElement.name(), chronoElement);
    }

    private static void append2Digits(int i, StringBuilder sb) {
        if (i < 10) {
            sb.append('0');
        }
        sb.append(i);
    }

    private static void checkHour(long j) {
        if (j < 0 || j > 24) {
            throw new IllegalArgumentException("HOUR_OF_DAY out of range: " + j);
        }
    }

    /* access modifiers changed from: private */
    public static void checkMinute(long j) {
        if (j < 0 || j > 59) {
            throw new IllegalArgumentException("MINUTE_OF_HOUR out of range: " + j);
        }
    }

    /* access modifiers changed from: private */
    public static void checkSecond(long j) {
        if (j < 0 || j > 59) {
            throw new IllegalArgumentException("SECOND_OF_MINUTE out of range: " + j);
        }
    }

    private static void checkNano(int i) {
        if (i < 0 || i >= MRD) {
            throw new IllegalArgumentException("NANO_OF_SECOND out of range: " + i);
        }
    }

    /* access modifiers changed from: private */
    public static PlainTime createFromMillis(int i, int i2) {
        int i3 = ((i % 1000) * 1000000) + i2;
        int i4 = i / 1000;
        int i5 = i4 % 60;
        int i6 = i4 / 60;
        return of(i6 / 60, i6 % 60, i5, i3);
    }

    /* access modifiers changed from: private */
    public static PlainTime createFromMicros(long j, int i) {
        int i2 = (((int) (j % AnimationKt.MillisToNanos)) * 1000) + i;
        int i3 = (int) (j / AnimationKt.MillisToNanos);
        int i4 = i3 % 60;
        int i5 = i3 / 60;
        return of(i5 / 60, i5 % 60, i4, i2);
    }

    /* access modifiers changed from: private */
    public static PlainTime createFromNanos(long j) {
        int i = (int) (j / 1000000000);
        int i2 = i % 60;
        int i3 = i / 60;
        int i4 = i3 % 60;
        return of(i3 / 60, i4, i2, (int) (j % 1000000000));
    }

    /* access modifiers changed from: private */
    public long getNanoOfDay() {
        return ((long) this.nano) + (((long) this.second) * 1000000000) + (((long) this.minute) * 60 * 1000000000) + (((long) this.hour) * 3600 * 1000000000);
    }

    /* access modifiers changed from: private */
    public boolean isFullHour() {
        return ((this.minute | this.second) | this.nano) == 0;
    }

    /* access modifiers changed from: private */
    public boolean isFullMinute() {
        return (this.second | this.nano) == 0;
    }

    private static void registerExtensions(TimeAxis.Builder<IsoTimeUnit, PlainTime> builder) {
        for (S s : ResourceLoader.getInstance().services(ChronoExtension.class)) {
            if (s.accept(PlainTime.class)) {
                builder.appendExtension((ChronoExtension) s);
            }
        }
        builder.appendExtension((ChronoExtension) new DayPeriod.Extension());
    }

    private static void registerUnits(TimeAxis.Builder<IsoTimeUnit, PlainTime> builder) {
        EnumSet<E> allOf = EnumSet.allOf(ClockUnit.class);
        for (ClockUnit clockUnit : ClockUnit.values()) {
            builder.appendUnit(clockUnit, new ClockUnitRule(clockUnit, (AnonymousClass1) null), clockUnit.getLength(), allOf);
        }
    }

    /* access modifiers changed from: private */
    public static long floorMod(long j, long j2) {
        long j3 = j >= 0 ? j / j2 : ((j + 1) / j2) - 1;
        Long.signum(j2);
        return j - (j2 * j3);
    }

    /* access modifiers changed from: private */
    public static long floorDiv(long j, long j2) {
        if (j >= 0) {
            return j / j2;
        }
        return ((j + 1) / j2) - 1;
    }

    private Object writeReplace() {
        return new SPX(this, 2);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private static class ClockUnitRule implements UnitRule<PlainTime> {
        private final ClockUnit unit;

        /* synthetic */ ClockUnitRule(ClockUnit clockUnit, AnonymousClass1 r2) {
            this(clockUnit);
        }

        private ClockUnitRule(ClockUnit clockUnit) {
            this.unit = clockUnit;
        }

        public PlainTime addTo(PlainTime plainTime, long j) {
            return j == 0 ? plainTime : (PlainTime) doAdd(PlainTime.class, this.unit, plainTime, j);
        }

        public long between(PlainTime plainTime, PlainTime plainTime2) {
            long j;
            long access$600 = plainTime2.getNanoOfDay() - plainTime.getNanoOfDay();
            switch (AnonymousClass1.$SwitchMap$net$time4j$ClockUnit[this.unit.ordinal()]) {
                case 1:
                    j = 3600000000000L;
                    break;
                case 2:
                    j = 60000000000L;
                    break;
                case 3:
                    j = 1000000000;
                    break;
                case 4:
                    j = AnimationKt.MillisToNanos;
                    break;
                case 5:
                    j = 1000;
                    break;
                case 6:
                    j = 1;
                    break;
                default:
                    throw new UnsupportedOperationException(this.unit.name());
            }
            return access$600 / j;
        }

        /* access modifiers changed from: private */
        public static DayCycles addToWithOverflow(PlainTime plainTime, long j, ClockUnit clockUnit) {
            if (j != 0 || plainTime.hour >= 24) {
                return (DayCycles) doAdd(DayCycles.class, clockUnit, plainTime, j);
            }
            return new DayCycles(0, plainTime);
        }

        private static <R> R doAdd(Class<R> cls, ClockUnit clockUnit, PlainTime plainTime, long j) {
            long j2;
            PlainTime plainTime2;
            int access$800 = plainTime.minute;
            int access$900 = plainTime.second;
            int access$1000 = plainTime.nano;
            switch (AnonymousClass1.$SwitchMap$net$time4j$ClockUnit[clockUnit.ordinal()]) {
                case 1:
                    j2 = MathUtils.safeAdd((long) plainTime.hour, j);
                    break;
                case 2:
                    long safeAdd = MathUtils.safeAdd((long) plainTime.minute, j);
                    j2 = MathUtils.safeAdd((long) plainTime.hour, MathUtils.floorDivide(safeAdd, 60));
                    access$800 = MathUtils.floorModulo(safeAdd, 60);
                    break;
                case 3:
                    long safeAdd2 = MathUtils.safeAdd((long) plainTime.second, j);
                    long safeAdd3 = MathUtils.safeAdd((long) plainTime.minute, MathUtils.floorDivide(safeAdd2, 60));
                    j2 = MathUtils.safeAdd((long) plainTime.hour, MathUtils.floorDivide(safeAdd3, 60));
                    int floorModulo = MathUtils.floorModulo(safeAdd3, 60);
                    access$900 = MathUtils.floorModulo(safeAdd2, 60);
                    access$800 = floorModulo;
                    break;
                case 4:
                    return doAdd(cls, ClockUnit.NANOS, plainTime, MathUtils.safeMultiply(j, (long) AnimationKt.MillisToNanos));
                case 5:
                    return doAdd(cls, ClockUnit.NANOS, plainTime, MathUtils.safeMultiply(j, 1000));
                case 6:
                    long safeAdd4 = MathUtils.safeAdd((long) plainTime.nano, j);
                    long safeAdd5 = MathUtils.safeAdd((long) plainTime.second, MathUtils.floorDivide(safeAdd4, (int) PlainTime.MRD));
                    long safeAdd6 = MathUtils.safeAdd((long) plainTime.minute, MathUtils.floorDivide(safeAdd5, 60));
                    j2 = MathUtils.safeAdd((long) plainTime.hour, MathUtils.floorDivide(safeAdd6, 60));
                    int floorModulo2 = MathUtils.floorModulo(safeAdd6, 60);
                    int floorModulo3 = MathUtils.floorModulo(safeAdd5, 60);
                    int floorModulo4 = MathUtils.floorModulo(safeAdd4, (int) PlainTime.MRD);
                    access$800 = floorModulo2;
                    access$900 = floorModulo3;
                    access$1000 = floorModulo4;
                    break;
                default:
                    throw new UnsupportedOperationException(clockUnit.name());
            }
            int floorModulo5 = MathUtils.floorModulo(j2, 24);
            if ((floorModulo5 | access$800 | access$900 | access$1000) == 0) {
                plainTime2 = (j <= 0 || cls != PlainTime.class) ? PlainTime.MIN : PlainTime.MAX;
            } else {
                plainTime2 = PlainTime.of(floorModulo5, access$800, access$900, access$1000);
            }
            if (cls == PlainTime.class) {
                return cls.cast(plainTime2);
            }
            return cls.cast(new DayCycles(MathUtils.floorDivide(j2, 24), plainTime2));
        }
    }

    /* renamed from: net.time4j.PlainTime$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.PlainTime.AnonymousClass1.<clinit>():void");
        }
    }

    private static class TimeRule implements ElementRule<PlainTime, PlainTime> {
        public ChronoElement<?> getChildAtCeiling(PlainTime plainTime) {
            return null;
        }

        public ChronoElement<?> getChildAtFloor(PlainTime plainTime) {
            return null;
        }

        public PlainTime getValue(PlainTime plainTime) {
            return plainTime;
        }

        public boolean isValid(PlainTime plainTime, PlainTime plainTime2) {
            return plainTime2 != null;
        }

        private TimeRule() {
        }

        /* synthetic */ TimeRule(AnonymousClass1 r1) {
            this();
        }

        public PlainTime withValue(PlainTime plainTime, PlainTime plainTime2, boolean z) {
            if (plainTime2 != null) {
                return plainTime2;
            }
            throw new IllegalArgumentException("Missing time value.");
        }

        public PlainTime getMinimum(PlainTime plainTime) {
            return PlainTime.MIN;
        }

        public PlainTime getMaximum(PlainTime plainTime) {
            return PlainTime.MAX;
        }
    }

    private static class PrecisionRule implements ElementRule<PlainTime, ClockUnit> {
        public ChronoElement<?> getChildAtCeiling(PlainTime plainTime) {
            return null;
        }

        public ChronoElement<?> getChildAtFloor(PlainTime plainTime) {
            return null;
        }

        public boolean isValid(PlainTime plainTime, ClockUnit clockUnit) {
            return clockUnit != null;
        }

        private PrecisionRule() {
        }

        /* synthetic */ PrecisionRule(AnonymousClass1 r1) {
            this();
        }

        public ClockUnit getValue(PlainTime plainTime) {
            if (plainTime.nano != 0) {
                if (plainTime.nano % 1000000 == 0) {
                    return ClockUnit.MILLIS;
                }
                if (plainTime.nano % 1000 == 0) {
                    return ClockUnit.MICROS;
                }
                return ClockUnit.NANOS;
            } else if (plainTime.second != 0) {
                return ClockUnit.SECONDS;
            } else {
                if (plainTime.minute != 0) {
                    return ClockUnit.MINUTES;
                }
                return ClockUnit.HOURS;
            }
        }

        public PlainTime withValue(PlainTime plainTime, ClockUnit clockUnit, boolean z) {
            if (clockUnit == null) {
                throw new IllegalArgumentException("Missing precision value.");
            } else if (clockUnit.ordinal() >= getValue(plainTime).ordinal()) {
                return plainTime;
            } else {
                switch (AnonymousClass1.$SwitchMap$net$time4j$ClockUnit[clockUnit.ordinal()]) {
                    case 1:
                        return PlainTime.of((int) plainTime.hour);
                    case 2:
                        return PlainTime.of(plainTime.hour, plainTime.minute);
                    case 3:
                        return PlainTime.of(plainTime.hour, plainTime.minute, plainTime.second);
                    case 4:
                        return PlainTime.of(plainTime.hour, plainTime.minute, plainTime.second, (plainTime.nano / 1000000) * 1000000);
                    case 5:
                        return PlainTime.of(plainTime.hour, plainTime.minute, plainTime.second, (plainTime.nano / 1000) * 1000);
                    case 6:
                        return plainTime;
                    default:
                        throw new UnsupportedOperationException(clockUnit.name());
                }
            }
        }

        public ClockUnit getMinimum(PlainTime plainTime) {
            return ClockUnit.HOURS;
        }

        public ClockUnit getMaximum(PlainTime plainTime) {
            return ClockUnit.NANOS;
        }
    }

    private static class MeridiemRule implements ElementRule<PlainTime, Meridiem> {
        public boolean isValid(PlainTime plainTime, Meridiem meridiem) {
            return meridiem != null;
        }

        private MeridiemRule() {
        }

        /* synthetic */ MeridiemRule(AnonymousClass1 r1) {
            this();
        }

        public Meridiem getValue(PlainTime plainTime) {
            return Meridiem.ofHour(plainTime.hour);
        }

        public PlainTime withValue(PlainTime plainTime, Meridiem meridiem, boolean z) {
            int access$700 = plainTime.hour == 24 ? 0 : plainTime.hour;
            if (meridiem != null) {
                if (meridiem == Meridiem.AM) {
                    if (access$700 >= 12) {
                        access$700 -= 12;
                    }
                } else if (meridiem == Meridiem.PM && access$700 < 12) {
                    access$700 += 12;
                }
                return PlainTime.of(access$700, plainTime.minute, plainTime.second, plainTime.nano);
            }
            throw new IllegalArgumentException("Missing am/pm-value.");
        }

        public Meridiem getMinimum(PlainTime plainTime) {
            return Meridiem.AM;
        }

        public Meridiem getMaximum(PlainTime plainTime) {
            return Meridiem.PM;
        }

        public ChronoElement<?> getChildAtFloor(PlainTime plainTime) {
            return PlainTime.DIGITAL_HOUR_OF_AMPM;
        }

        public ChronoElement<?> getChildAtCeiling(PlainTime plainTime) {
            return PlainTime.DIGITAL_HOUR_OF_AMPM;
        }
    }

    private static class IntegerElementRule implements ElementRule<PlainTime, Integer> {
        private final ChronoElement<Integer> element;
        private final int index;
        private final int max;
        private final int min;

        IntegerElementRule(ChronoElement<Integer> chronoElement, int i, int i2) {
            this.element = chronoElement;
            if (chronoElement instanceof IntegerTimeElement) {
                this.index = ((IntegerTimeElement) chronoElement).getIndex();
            } else {
                this.index = -1;
            }
            this.min = i;
            this.max = i2;
        }

        public Integer getValue(PlainTime plainTime) {
            byte b;
            int i;
            int i2 = 24;
            switch (this.index) {
                case 1:
                    i2 = plainTime.hour % 12;
                    if (i2 == 0) {
                        i2 = 12;
                        break;
                    }
                    break;
                case 2:
                    int access$700 = plainTime.hour % 24;
                    if (access$700 != 0) {
                        i2 = access$700;
                        break;
                    }
                    break;
                case 3:
                    i2 = plainTime.hour % 12;
                    break;
                case 4:
                    i2 = plainTime.hour % 24;
                    break;
                case 5:
                    i2 = plainTime.hour;
                    break;
                case 6:
                    i2 = plainTime.minute;
                    break;
                case 7:
                    i = plainTime.hour * 60;
                    b = plainTime.minute;
                    break;
                case 8:
                    i2 = plainTime.second;
                    break;
                case 9:
                    i = (plainTime.hour * Tnaf.POW_2_WIDTH) + (plainTime.minute * 60);
                    b = plainTime.second;
                    break;
                case 10:
                    i2 = plainTime.nano / 1000000;
                    break;
                case 11:
                    i2 = plainTime.nano / 1000;
                    break;
                case 12:
                    i2 = plainTime.nano;
                    break;
                case 13:
                    i2 = (int) (plainTime.getNanoOfDay() / AnimationKt.MillisToNanos);
                    break;
                default:
                    throw new UnsupportedOperationException(this.element.name());
            }
            i2 = i + b;
            return Integer.valueOf(i2);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0058, code lost:
            r2 = r8 + r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0073, code lost:
            if (isAM(r7) != false) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0076, code lost:
            r8 = r8 + 12;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0088, code lost:
            if (isAM(r7) != false) goto L_0x006d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x008f, code lost:
            return net.time4j.PlainTime.of(r9, r0, r1, r2);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.PlainTime withValue(net.time4j.PlainTime r7, java.lang.Integer r8, boolean r9) {
            /*
                r6 = this;
                if (r8 == 0) goto L_0x00a7
                if (r9 == 0) goto L_0x000d
                int r8 = r8.intValue()
                net.time4j.PlainTime r7 = r6.withValueInLenientMode(r7, r8)
                return r7
            L_0x000d:
                boolean r9 = r6.isValid((net.time4j.PlainTime) r7, (java.lang.Integer) r8)
                if (r9 == 0) goto L_0x0090
                byte r9 = r7.hour
                byte r0 = r7.minute
                byte r1 = r7.second
                int r2 = r7.nano
                int r8 = r8.intValue()
                int r3 = r6.index
                r4 = 0
                r5 = 1000000(0xf4240, float:1.401298E-39)
                switch(r3) {
                    case 1: goto L_0x007f;
                    case 2: goto L_0x0079;
                    case 3: goto L_0x006f;
                    case 4: goto L_0x006d;
                    case 5: goto L_0x006d;
                    case 6: goto L_0x006b;
                    case 7: goto L_0x0066;
                    case 8: goto L_0x0064;
                    case 9: goto L_0x005b;
                    case 10: goto L_0x0051;
                    case 11: goto L_0x0048;
                    case 12: goto L_0x0046;
                    case 13: goto L_0x003c;
                    default: goto L_0x0030;
                }
            L_0x0030:
                java.lang.UnsupportedOperationException r7 = new java.lang.UnsupportedOperationException
                net.time4j.engine.ChronoElement<java.lang.Integer> r8 = r6.element
                java.lang.String r8 = r8.name()
                r7.<init>(r8)
                throw r7
            L_0x003c:
                int r7 = r7.nano
                int r7 = r7 % r5
                net.time4j.PlainTime r7 = net.time4j.PlainTime.createFromMillis(r8, r7)
                return r7
            L_0x0046:
                r2 = r8
                goto L_0x008b
            L_0x0048:
                int r8 = r8 * 1000
                int r7 = r7.nano
                int r7 = r7 % 1000
                goto L_0x0058
            L_0x0051:
                int r8 = r8 * r5
                int r7 = r7.nano
                int r7 = r7 % r5
            L_0x0058:
                int r2 = r8 + r7
                goto L_0x008b
            L_0x005b:
                int r9 = r8 / 3600
                int r8 = r8 % 3600
                int r0 = r8 / 60
                int r1 = r8 % 60
                goto L_0x008b
            L_0x0064:
                r1 = r8
                goto L_0x008b
            L_0x0066:
                int r9 = r8 / 60
                int r0 = r8 % 60
                goto L_0x008b
            L_0x006b:
                r0 = r8
                goto L_0x008b
            L_0x006d:
                r9 = r8
                goto L_0x008b
            L_0x006f:
                boolean r7 = isAM(r7)
                if (r7 == 0) goto L_0x0076
                goto L_0x006d
            L_0x0076:
                int r8 = r8 + 12
                goto L_0x006d
            L_0x0079:
                r7 = 24
                if (r8 != r7) goto L_0x006d
                r9 = 0
                goto L_0x008b
            L_0x007f:
                r9 = 12
                if (r8 != r9) goto L_0x0084
                r8 = 0
            L_0x0084:
                boolean r7 = isAM(r7)
                if (r7 == 0) goto L_0x0076
                goto L_0x006d
            L_0x008b:
                net.time4j.PlainTime r7 = net.time4j.PlainTime.of(r9, r0, r1, r2)
                return r7
            L_0x0090:
                java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r0 = "Value out of range: "
                r9.append(r0)
                r9.append(r8)
                java.lang.String r8 = r9.toString()
                r7.<init>(r8)
                throw r7
            L_0x00a7:
                java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
                java.lang.String r8 = "Missing element value."
                r7.<init>(r8)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.PlainTime.IntegerElementRule.withValue(net.time4j.PlainTime, java.lang.Integer, boolean):net.time4j.PlainTime");
        }

        public boolean isValid(PlainTime plainTime, Integer num) {
            int intValue;
            int i;
            if (num == null || (intValue = num.intValue()) < this.min || intValue > (i = this.max)) {
                return false;
            }
            if (intValue == i) {
                int i2 = this.index;
                if (i2 == 5) {
                    return plainTime.isFullHour();
                }
                if (i2 == 7) {
                    return plainTime.isFullMinute();
                }
                if (i2 != 9) {
                    if (i2 == 13) {
                        if (plainTime.nano % 1000000 == 0) {
                            return true;
                        }
                        return false;
                    }
                } else if (plainTime.nano == 0) {
                    return true;
                } else {
                    return false;
                }
            }
            if (plainTime.hour == 24) {
                switch (this.index) {
                    case 6:
                    case 8:
                    case 10:
                    case 11:
                    case 12:
                        if (intValue == 0) {
                            return true;
                        }
                        return false;
                }
            }
            return true;
        }

        public Integer getMinimum(PlainTime plainTime) {
            return Integer.valueOf(this.min);
        }

        public Integer getMaximum(PlainTime plainTime) {
            if (plainTime.hour == 24) {
                switch (this.index) {
                    case 6:
                    case 8:
                    case 10:
                    case 11:
                    case 12:
                        return 0;
                }
            }
            if (plainTime.hasReducedRange(this.element)) {
                return Integer.valueOf(this.max - 1);
            }
            return Integer.valueOf(this.max);
        }

        public ChronoElement<?> getChildAtFloor(PlainTime plainTime) {
            return getChild(plainTime);
        }

        public ChronoElement<?> getChildAtCeiling(PlainTime plainTime) {
            return getChild(plainTime);
        }

        private ChronoElement<?> getChild(PlainTime plainTime) {
            switch (this.index) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    return PlainTime.MINUTE_OF_HOUR;
                case 6:
                case 7:
                    return PlainTime.SECOND_OF_MINUTE;
                case 8:
                case 9:
                    return PlainTime.NANO_OF_SECOND;
                default:
                    return null;
            }
        }

        private PlainTime withValueInLenientMode(PlainTime plainTime, int i) {
            if (this.element == PlainTime.HOUR_FROM_0_TO_24 || this.element == PlainTime.DIGITAL_HOUR_OF_DAY || this.element == PlainTime.DIGITAL_HOUR_OF_AMPM) {
                return (PlainTime) plainTime.plus((long) MathUtils.safeSubtract(i, ((Integer) plainTime.get(this.element)).intValue()), ClockUnit.HOURS);
            }
            if (this.element == PlainTime.MINUTE_OF_HOUR) {
                return (PlainTime) plainTime.plus((long) MathUtils.safeSubtract(i, (int) plainTime.minute), ClockUnit.MINUTES);
            }
            if (this.element == PlainTime.SECOND_OF_MINUTE) {
                return (PlainTime) plainTime.plus((long) MathUtils.safeSubtract(i, (int) plainTime.second), ClockUnit.SECONDS);
            }
            if (this.element == PlainTime.MILLI_OF_SECOND) {
                return (PlainTime) plainTime.plus((long) MathUtils.safeSubtract(i, ((Integer) plainTime.get(PlainTime.MILLI_OF_SECOND)).intValue()), ClockUnit.MILLIS);
            }
            if (this.element == PlainTime.MICRO_OF_SECOND) {
                return (PlainTime) plainTime.plus((long) MathUtils.safeSubtract(i, ((Integer) plainTime.get(PlainTime.MICRO_OF_SECOND)).intValue()), ClockUnit.MICROS);
            }
            if (this.element == PlainTime.NANO_OF_SECOND) {
                return (PlainTime) plainTime.plus((long) MathUtils.safeSubtract(i, plainTime.nano), ClockUnit.NANOS);
            }
            if (this.element == PlainTime.MILLI_OF_DAY) {
                int floorModulo = MathUtils.floorModulo(i, 86400000);
                int access$1000 = plainTime.nano % 1000000;
                if (floorModulo == 0 && access$1000 == 0) {
                    return i > 0 ? PlainTime.MAX : PlainTime.MIN;
                }
                return PlainTime.createFromMillis(floorModulo, access$1000);
            } else if (this.element == PlainTime.MINUTE_OF_DAY) {
                int floorModulo2 = MathUtils.floorModulo(i, 1440);
                if (floorModulo2 != 0 || !plainTime.isFullMinute()) {
                    return withValue(plainTime, Integer.valueOf(floorModulo2), false);
                }
                return i > 0 ? PlainTime.MAX : PlainTime.MIN;
            } else if (this.element == PlainTime.SECOND_OF_DAY) {
                int floorModulo3 = MathUtils.floorModulo(i, 86400);
                if (floorModulo3 == 0 && plainTime.nano == 0) {
                    return i > 0 ? PlainTime.MAX : PlainTime.MIN;
                }
                return withValue(plainTime, Integer.valueOf(floorModulo3), false);
            } else {
                throw new UnsupportedOperationException(this.element.name());
            }
        }

        private static boolean isAM(PlainTime plainTime) {
            return plainTime.hour < 12 || plainTime.hour == 24;
        }
    }

    private static class LongElementRule implements ElementRule<PlainTime, Long> {
        private final ChronoElement<Long> element;
        private final long max;
        private final long min;

        public ChronoElement<?> getChildAtCeiling(PlainTime plainTime) {
            return null;
        }

        public ChronoElement<?> getChildAtFloor(PlainTime plainTime) {
            return null;
        }

        LongElementRule(ChronoElement<Long> chronoElement, long j, long j2) {
            this.element = chronoElement;
            this.min = j;
            this.max = j2;
        }

        public Long getValue(PlainTime plainTime) {
            long j;
            if (this.element == PlainTime.MICRO_OF_DAY) {
                j = plainTime.getNanoOfDay() / 1000;
            } else {
                j = plainTime.getNanoOfDay();
            }
            return Long.valueOf(j);
        }

        public PlainTime withValue(PlainTime plainTime, Long l, boolean z) {
            if (l == null) {
                throw new IllegalArgumentException("Missing element value.");
            } else if (z) {
                return withValueInLenientMode(plainTime, l.longValue());
            } else {
                if (isValid(plainTime, l)) {
                    long longValue = l.longValue();
                    if (this.element == PlainTime.MICRO_OF_DAY) {
                        return PlainTime.createFromMicros(longValue, plainTime.nano % 1000);
                    }
                    return PlainTime.createFromNanos(longValue);
                }
                throw new IllegalArgumentException("Value out of range: " + l);
            }
        }

        public boolean isValid(PlainTime plainTime, Long l) {
            if (l == null) {
                return false;
            }
            if (this.element == PlainTime.MICRO_OF_DAY && l.longValue() == this.max) {
                if (plainTime.nano % 1000 == 0) {
                    return true;
                }
                return false;
            } else if (this.min > l.longValue() || l.longValue() > this.max) {
                return false;
            } else {
                return true;
            }
        }

        public Long getMinimum(PlainTime plainTime) {
            return Long.valueOf(this.min);
        }

        public Long getMaximum(PlainTime plainTime) {
            if (this.element != PlainTime.MICRO_OF_DAY || plainTime.nano % 1000 == 0) {
                return Long.valueOf(this.max);
            }
            return Long.valueOf(this.max - 1);
        }

        private PlainTime withValueInLenientMode(PlainTime plainTime, long j) {
            if (this.element == PlainTime.MICRO_OF_DAY) {
                long access$1600 = PlainTime.floorMod(j, 86400000000L);
                int access$1000 = plainTime.nano % 1000;
                if (access$1600 == 0 && access$1000 == 0 && j > 0) {
                    return PlainTime.MAX;
                }
                return PlainTime.createFromMicros(access$1600, access$1000);
            }
            long access$16002 = PlainTime.floorMod(j, 86400000000000L);
            if (access$16002 != 0 || j <= 0) {
                return PlainTime.createFromNanos(access$16002);
            }
            return PlainTime.MAX;
        }
    }

    private static class BigDecimalElementRule implements ElementRule<PlainTime, BigDecimal> {
        private final ChronoElement<BigDecimal> element;
        private final BigDecimal max;

        public ChronoElement<?> getChildAtCeiling(PlainTime plainTime) {
            return null;
        }

        public ChronoElement<?> getChildAtFloor(PlainTime plainTime) {
            return null;
        }

        BigDecimalElementRule(ChronoElement<BigDecimal> chronoElement, BigDecimal bigDecimal) {
            this.element = chronoElement;
            this.max = bigDecimal;
        }

        public BigDecimal getValue(PlainTime plainTime) {
            BigDecimal bigDecimal;
            if (this.element == PlainTime.DECIMAL_HOUR) {
                if (plainTime.equals(PlainTime.MIN)) {
                    return BigDecimal.ZERO;
                }
                if (plainTime.hour == 24) {
                    return PlainTime.DECIMAL_24_0;
                }
                bigDecimal = BigDecimal.valueOf((long) plainTime.hour).add(div(BigDecimal.valueOf((long) plainTime.minute), PlainTime.DECIMAL_60)).add(div(BigDecimal.valueOf((long) plainTime.second), PlainTime.DECIMAL_3600)).add(div(BigDecimal.valueOf((long) plainTime.nano), PlainTime.DECIMAL_3600.multiply(PlainTime.DECIMAL_MRD)));
            } else if (this.element == PlainTime.DECIMAL_MINUTE) {
                if (plainTime.isFullHour()) {
                    return BigDecimal.ZERO;
                }
                bigDecimal = BigDecimal.valueOf((long) plainTime.minute).add(div(BigDecimal.valueOf((long) plainTime.second), PlainTime.DECIMAL_60)).add(div(BigDecimal.valueOf((long) plainTime.nano), PlainTime.DECIMAL_60.multiply(PlainTime.DECIMAL_MRD)));
            } else if (this.element != PlainTime.DECIMAL_SECOND) {
                throw new UnsupportedOperationException(this.element.name());
            } else if (plainTime.isFullMinute()) {
                return BigDecimal.ZERO;
            } else {
                bigDecimal = BigDecimal.valueOf((long) plainTime.second).add(div(BigDecimal.valueOf((long) plainTime.nano), PlainTime.DECIMAL_MRD));
            }
            return bigDecimal.setScale(15, RoundingMode.FLOOR).stripTrailingZeros();
        }

        public PlainTime withValue(PlainTime plainTime, BigDecimal bigDecimal, boolean z) {
            int i;
            long j;
            int i2;
            int i3;
            int i4;
            int i5;
            if (bigDecimal != null) {
                if (this.element == PlainTime.DECIMAL_HOUR) {
                    BigDecimal scale = bigDecimal.setScale(0, RoundingMode.FLOOR);
                    BigDecimal multiply = bigDecimal.subtract(scale).multiply(PlainTime.DECIMAL_60);
                    BigDecimal scale2 = multiply.setScale(0, RoundingMode.FLOOR);
                    BigDecimal multiply2 = multiply.subtract(scale2).multiply(PlainTime.DECIMAL_60);
                    BigDecimal scale3 = multiply2.setScale(0, RoundingMode.FLOOR);
                    j = scale.longValueExact();
                    i = scale2.intValue();
                    i2 = scale3.intValue();
                    i3 = toNano(multiply2.subtract(scale3));
                } else if (this.element == PlainTime.DECIMAL_MINUTE) {
                    BigDecimal scale4 = bigDecimal.setScale(0, RoundingMode.FLOOR);
                    BigDecimal multiply3 = bigDecimal.subtract(scale4).multiply(PlainTime.DECIMAL_60);
                    BigDecimal scale5 = multiply3.setScale(0, RoundingMode.FLOOR);
                    int intValue = scale5.intValue();
                    int nano = toNano(multiply3.subtract(scale5));
                    long longValueExact = scale4.longValueExact();
                    long access$700 = (long) plainTime.hour;
                    if (z) {
                        access$700 += MathUtils.floorDivide(longValueExact, 60);
                        i = MathUtils.floorModulo(longValueExact, 60);
                    } else {
                        PlainTime.checkMinute(longValueExact);
                        i = (int) longValueExact;
                    }
                    i3 = nano;
                    i2 = intValue;
                    j = access$700;
                } else if (this.element == PlainTime.DECIMAL_SECOND) {
                    BigDecimal scale6 = bigDecimal.setScale(0, RoundingMode.FLOOR);
                    int nano2 = toNano(bigDecimal.subtract(scale6));
                    long longValueExact2 = scale6.longValueExact();
                    long access$7002 = (long) plainTime.hour;
                    int access$800 = plainTime.minute;
                    if (z) {
                        i5 = MathUtils.floorModulo(longValueExact2, 60);
                        long floorDivide = ((long) access$800) + MathUtils.floorDivide(longValueExact2, 60);
                        access$7002 += MathUtils.floorDivide(floorDivide, 60);
                        access$800 = MathUtils.floorModulo(floorDivide, 60);
                    } else {
                        PlainTime.checkSecond(longValueExact2);
                        i5 = (int) longValueExact2;
                    }
                    j = access$7002;
                    int i6 = nano2;
                    i2 = i5;
                    i3 = i6;
                } else {
                    throw new UnsupportedOperationException(this.element.name());
                }
                if (z) {
                    i4 = MathUtils.floorModulo(j, 24);
                    if (j > 0 && (i4 | i | i2 | i3) == 0) {
                        return PlainTime.MAX;
                    }
                } else if (j < 0 || j > 24) {
                    throw new IllegalArgumentException("Value out of range: " + bigDecimal);
                } else {
                    i4 = (int) j;
                }
                return PlainTime.of(i4, i, i2, i3);
            }
            throw new IllegalArgumentException("Missing element value.");
        }

        public boolean isValid(PlainTime plainTime, BigDecimal bigDecimal) {
            if (bigDecimal == null) {
                return false;
            }
            if (plainTime.hour == 24 && (this.element == PlainTime.DECIMAL_MINUTE || this.element == PlainTime.DECIMAL_SECOND)) {
                if (BigDecimal.ZERO.compareTo(bigDecimal) == 0) {
                    return true;
                }
                return false;
            } else if (BigDecimal.ZERO.compareTo(bigDecimal) > 0 || this.max.compareTo(bigDecimal) < 0) {
                return false;
            } else {
                return true;
            }
        }

        public BigDecimal getMinimum(PlainTime plainTime) {
            return BigDecimal.ZERO;
        }

        public BigDecimal getMaximum(PlainTime plainTime) {
            if (plainTime.hour == 24 && (this.element == PlainTime.DECIMAL_MINUTE || this.element == PlainTime.DECIMAL_SECOND)) {
                return BigDecimal.ZERO;
            }
            return this.max;
        }

        private static BigDecimal div(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            return bigDecimal.divide(bigDecimal2, 16, RoundingMode.FLOOR);
        }

        private static int toNano(BigDecimal bigDecimal) {
            return Math.min(999999999, bigDecimal.movePointRight(9).setScale(0, RoundingMode.HALF_UP).intValue());
        }
    }

    private static class Merger implements ChronoMerger<PlainTime> {
        public ChronoDisplay preformat(PlainTime plainTime, AttributeQuery attributeQuery) {
            return plainTime;
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
            return CalendarText.patternForTime(DisplayMode.ofStyle(displayStyle.getStyleValue()), locale);
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [net.time4j.base.TimeSource, net.time4j.base.TimeSource<?>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.PlainTime createFrom(net.time4j.base.TimeSource<?> r3, net.time4j.engine.AttributeQuery r4) {
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
                net.time4j.PlainTime r3 = net.time4j.PlainTime.from(r3, r4)
                return r3
            L_0x0036:
                r3 = 0
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.PlainTime.Merger.createFrom(net.time4j.base.TimeSource, net.time4j.engine.AttributeQuery):net.time4j.PlainTime");
        }

        public PlainTime createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            if (chronoEntity instanceof UnixTime) {
                return ((PlainTimestamp) PlainTimestamp.axis().createFrom((ChronoEntity) chronoEntity, attributeQuery, z, z2)).getWallTime();
            }
            if (chronoEntity.contains(PlainTime.WALL_TIME)) {
                return (PlainTime) chronoEntity.get((ChronoElement<V>) PlainTime.WALL_TIME);
            }
            if (chronoEntity.contains(PlainTime.DECIMAL_HOUR)) {
                return PlainTime.of((BigDecimal) chronoEntity.get((ChronoElement<V>) PlainTime.DECIMAL_HOUR));
            }
            int i = chronoEntity.getInt(PlainTime.HOUR_FROM_0_TO_24);
            if (i == Integer.MIN_VALUE) {
                i = readHour(chronoEntity);
                if (i == Integer.MIN_VALUE) {
                    return readSpecialCases(chronoEntity);
                }
                if (i == -1 || i == -2) {
                    if (z) {
                        i = i == -1 ? 0 : 12;
                    } else {
                        flagValidationError(chronoEntity, "Clock hour cannot be zero.");
                        return null;
                    }
                } else if (i == 24 && !z) {
                    flagValidationError(chronoEntity, "Time 24:00 not allowed, use lax mode or element HOUR_FROM_0_TO_24 instead.");
                    return null;
                }
            }
            if (chronoEntity.contains(PlainTime.DECIMAL_MINUTE)) {
                return (PlainTime) PlainTime.M_DECIMAL_RULE.withValue(PlainTime.of(i), chronoEntity.get((ChronoElement<V>) PlainTime.DECIMAL_MINUTE), false);
            }
            int i2 = chronoEntity.getInt(PlainTime.MINUTE_OF_HOUR);
            if (i2 == Integer.MIN_VALUE) {
                i2 = 0;
            }
            if (chronoEntity.contains(PlainTime.DECIMAL_SECOND)) {
                return (PlainTime) PlainTime.S_DECIMAL_RULE.withValue(PlainTime.of(i, i2), chronoEntity.get((ChronoElement<V>) PlainTime.DECIMAL_SECOND), false);
            }
            int i3 = chronoEntity.getInt(PlainTime.SECOND_OF_MINUTE);
            if (i3 == Integer.MIN_VALUE) {
                i3 = 0;
            }
            int i4 = chronoEntity.getInt(PlainTime.NANO_OF_SECOND);
            if (i4 == Integer.MIN_VALUE) {
                int i5 = chronoEntity.getInt(PlainTime.MICRO_OF_SECOND);
                if (i5 == Integer.MIN_VALUE) {
                    int i6 = chronoEntity.getInt(PlainTime.MILLI_OF_SECOND);
                    if (i6 == Integer.MIN_VALUE) {
                        i4 = 0;
                    } else {
                        i4 = MathUtils.safeMultiply(i6, 1000000);
                    }
                } else {
                    i4 = MathUtils.safeMultiply(i5, 1000);
                }
            }
            if (z) {
                long safeAdd = MathUtils.safeAdd(MathUtils.safeMultiply(MathUtils.safeAdd(MathUtils.safeAdd(MathUtils.safeMultiply((long) i, 3600), MathUtils.safeMultiply((long) i2, 60)), (long) i3), 1000000000), (long) i4);
                long access$1600 = PlainTime.floorMod(safeAdd, 86400000000000L);
                long access$2500 = PlainTime.floorDiv(safeAdd, 86400000000000L);
                int i7 = (access$2500 > 0 ? 1 : (access$2500 == 0 ? 0 : -1));
                if (i7 != 0 && chronoEntity.isValid(LongElement.DAY_OVERFLOW, access$2500)) {
                    chronoEntity.with(LongElement.DAY_OVERFLOW, access$2500);
                }
                if (access$1600 != 0 || i7 <= 0) {
                    return PlainTime.createFromNanos(access$1600);
                }
                return PlainTime.MAX;
            } else if ((i >= 0 && i2 >= 0 && i3 >= 0 && i4 >= 0 && i == 24 && (i2 | i3 | i4) == 0) || (i < 24 && i2 <= 59 && i3 <= 59 && i4 <= PlainTime.MRD)) {
                return PlainTime.of(i, i2, i3, i4, false);
            } else {
                flagValidationError(chronoEntity, "Time component out of range.");
                return null;
            }
        }

        private static int readHour(ChronoEntity<?> chronoEntity) {
            int i = chronoEntity.getInt(PlainTime.DIGITAL_HOUR_OF_DAY);
            if (i != Integer.MIN_VALUE) {
                return i;
            }
            int i2 = chronoEntity.getInt(PlainTime.CLOCK_HOUR_OF_DAY);
            if (i2 == 0) {
                return -1;
            }
            int i3 = 0;
            if (i2 == 24) {
                return 0;
            }
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (chronoEntity.contains(PlainTime.AM_PM_OF_DAY)) {
                Meridiem meridiem = (Meridiem) chronoEntity.get((ChronoElement<V>) PlainTime.AM_PM_OF_DAY);
                int i4 = chronoEntity.getInt(PlainTime.CLOCK_HOUR_OF_AMPM);
                if (i4 == Integer.MIN_VALUE) {
                    int i5 = chronoEntity.getInt(PlainTime.DIGITAL_HOUR_OF_AMPM);
                    if (i5 != Integer.MIN_VALUE) {
                        return meridiem == Meridiem.AM ? i5 : i5 + 12;
                    }
                } else if (i4 != 0) {
                    if (i4 != 12) {
                        i3 = i4;
                    }
                    return meridiem == Meridiem.AM ? i3 : i3 + 12;
                } else if (meridiem == Meridiem.AM) {
                    return -1;
                } else {
                    return -2;
                }
            }
            return Integer.MIN_VALUE;
        }

        private static PlainTime readSpecialCases(ChronoEntity<?> chronoEntity) {
            int i;
            int i2;
            if (chronoEntity.contains(PlainTime.NANO_OF_DAY)) {
                long longValue = ((Long) chronoEntity.get((ChronoElement<V>) PlainTime.NANO_OF_DAY)).longValue();
                if (longValue >= 0 && longValue <= 86400000000000L) {
                    return PlainTime.createFromNanos(longValue);
                }
                flagValidationError(chronoEntity, "NANO_OF_DAY out of range: " + longValue);
                return null;
            }
            int i3 = 0;
            if (chronoEntity.contains(PlainTime.MICRO_OF_DAY)) {
                if (chronoEntity.contains(PlainTime.NANO_OF_SECOND)) {
                    i3 = ((Integer) chronoEntity.get((ChronoElement<V>) PlainTime.NANO_OF_SECOND)).intValue() % 1000;
                }
                return PlainTime.createFromMicros(((Long) chronoEntity.get((ChronoElement<V>) PlainTime.MICRO_OF_DAY)).longValue(), i3);
            } else if (chronoEntity.contains(PlainTime.MILLI_OF_DAY)) {
                if (chronoEntity.contains(PlainTime.NANO_OF_SECOND)) {
                    int intValue = ((Integer) chronoEntity.get((ChronoElement<V>) PlainTime.NANO_OF_SECOND)).intValue();
                    if (intValue < 0 || intValue >= PlainTime.MRD) {
                        flagValidationError(chronoEntity, "NANO_OF_SECOND out of range: " + intValue);
                        return null;
                    }
                    i3 = intValue % 1000000;
                } else if (chronoEntity.contains(PlainTime.MICRO_OF_SECOND)) {
                    int intValue2 = ((Integer) chronoEntity.get((ChronoElement<V>) PlainTime.MICRO_OF_SECOND)).intValue();
                    if (intValue2 < 0 || intValue2 >= 1000000) {
                        flagValidationError(chronoEntity, "MICRO_OF_SECOND out of range: " + intValue2);
                        return null;
                    }
                    i3 = intValue2 % 1000;
                }
                int intValue3 = ((Integer) chronoEntity.get((ChronoElement<V>) PlainTime.MILLI_OF_DAY)).intValue();
                if (intValue3 >= 0 && intValue3 <= 86400000) {
                    return PlainTime.createFromMillis(intValue3, i3);
                }
                flagValidationError(chronoEntity, "MILLI_OF_DAY out of range: " + intValue3);
                return null;
            } else if (chronoEntity.contains(PlainTime.SECOND_OF_DAY)) {
                if (chronoEntity.contains(PlainTime.NANO_OF_SECOND)) {
                    i2 = ((Integer) chronoEntity.get((ChronoElement<V>) PlainTime.NANO_OF_SECOND)).intValue();
                } else if (chronoEntity.contains(PlainTime.MICRO_OF_SECOND)) {
                    i2 = ((Integer) chronoEntity.get((ChronoElement<V>) PlainTime.MICRO_OF_SECOND)).intValue() * 1000;
                } else {
                    i2 = chronoEntity.contains(PlainTime.MILLI_OF_SECOND) ? ((Integer) chronoEntity.get((ChronoElement<V>) PlainTime.MILLI_OF_SECOND)).intValue() * 1000000 : 0;
                }
                return (PlainTime) PlainTime.of(0, 0, 0, i2).with(PlainTime.SECOND_OF_DAY, chronoEntity.get((ChronoElement<V>) PlainTime.SECOND_OF_DAY));
            } else if (!chronoEntity.contains(PlainTime.MINUTE_OF_DAY)) {
                return null;
            } else {
                if (chronoEntity.contains(PlainTime.NANO_OF_SECOND)) {
                    i = ((Integer) chronoEntity.get((ChronoElement<V>) PlainTime.NANO_OF_SECOND)).intValue();
                } else if (chronoEntity.contains(PlainTime.MICRO_OF_SECOND)) {
                    i = ((Integer) chronoEntity.get((ChronoElement<V>) PlainTime.MICRO_OF_SECOND)).intValue() * 1000;
                } else {
                    i = chronoEntity.contains(PlainTime.MILLI_OF_SECOND) ? ((Integer) chronoEntity.get((ChronoElement<V>) PlainTime.MILLI_OF_SECOND)).intValue() * 1000000 : 0;
                }
                return (PlainTime) PlainTime.of(0, 0, chronoEntity.contains(PlainTime.SECOND_OF_MINUTE) ? ((Integer) chronoEntity.get((ChronoElement<V>) PlainTime.SECOND_OF_MINUTE)).intValue() : 0, i).with(PlainTime.MINUTE_OF_DAY, chronoEntity.get((ChronoElement<V>) PlainTime.MINUTE_OF_DAY));
            }
        }

        private static void flagValidationError(ChronoEntity<?> chronoEntity, String str) {
            if (chronoEntity.isValid((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, str)) {
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, str);
            }
        }

        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.MIDNIGHT;
        }

        public int getDefaultPivotYear() {
            return PlainDate.axis().getDefaultPivotYear();
        }
    }
}
