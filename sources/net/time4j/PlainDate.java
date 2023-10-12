package net.time4j;

import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.CalendarUnit;
import net.time4j.base.GregorianDate;
import net.time4j.base.GregorianMath;
import net.time4j.base.MathUtils;
import net.time4j.base.ResourceLoader;
import net.time4j.base.UnixTime;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.BridgeChronology;
import net.time4j.engine.CalendarDate;
import net.time4j.engine.CalendarEra;
import net.time4j.engine.CalendarSystem;
import net.time4j.engine.Calendrical;
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
import net.time4j.engine.EpochDays;
import net.time4j.engine.FormattableElement;
import net.time4j.engine.IntElementRule;
import net.time4j.engine.Normalizer;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.TimeAxis;
import net.time4j.engine.TimeSpan;
import net.time4j.engine.ValidationElement;
import net.time4j.format.CalendarText;
import net.time4j.format.CalendarType;
import net.time4j.format.DisplayMode;
import net.time4j.format.LocalizedPatternSupport;
import net.time4j.format.TemporalFormatter;
import net.time4j.scale.TimeScale;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.TransitionHistory;
import net.time4j.tz.ZonalOffset;
import net.time4j.tz.ZonalTransition;

@CalendarType("iso8601")
public final class PlainDate extends Calendrical<IsoDateUnit, PlainDate> implements GregorianDate, Normalizer<CalendarUnit>, LocalizedPatternSupport {
    static final ChronoElement<PlainDate> CALENDAR_DATE;
    public static final CalendarDateElement COMPONENT = DateElement.INSTANCE;
    private static final int[] DAY_OF_LEAP_YEAR_PER_MONTH;
    @FormattableElement(format = "d")
    public static final ProportionalElement<Integer, PlainDate> DAY_OF_MONTH;
    public static final ProportionalElement<Integer, PlainDate> DAY_OF_QUARTER;
    @FormattableElement(format = "E")
    public static final NavigableElement<Weekday> DAY_OF_WEEK;
    @FormattableElement(format = "D")
    public static final ProportionalElement<Integer, PlainDate> DAY_OF_YEAR;
    private static final int[] DAY_OF_YEAR_PER_MONTH;
    private static final Map<String, Object> ELEMENTS;
    /* access modifiers changed from: private */
    public static final TimeAxis<IsoDateUnit, PlainDate> ENGINE;
    /* access modifiers changed from: private */
    public static final Integer LEAP_YEAR_LEN = 366;
    static final PlainDate MAX = new PlainDate(999999999, 12, 31);
    static final Integer MAX_YEAR = 999999999;
    static final PlainDate MIN = new PlainDate(-999999999, 1, 1);
    static final Integer MIN_YEAR = -999999999;
    @FormattableElement(format = "M")
    public static final ProportionalElement<Integer, PlainDate> MONTH_AS_NUMBER;
    @FormattableElement(alt = "L", format = "M")
    public static final NavigableElement<Month> MONTH_OF_YEAR;
    @FormattableElement(alt = "q", format = "Q")
    public static final NavigableElement<Quarter> QUARTER_OF_YEAR;
    /* access modifiers changed from: private */
    public static final Integer STD_YEAR_LEN = 365;
    /* access modifiers changed from: private */
    public static final CalendarSystem<PlainDate> TRANSFORMER;
    /* access modifiers changed from: private */
    public static final Integer VALUE_1 = 1;
    /* access modifiers changed from: private */
    public static final Integer VALUE_12 = 12;
    @FormattableElement(format = "F")
    public static final OrdinalWeekdayElement WEEKDAY_IN_MONTH;
    private static final int WIM_INDEX = 19;
    @FormattableElement(format = "u")
    public static final AdjustableElement<Integer, PlainDate> YEAR;
    @FormattableElement(format = "Y")
    public static final AdjustableElement<Integer, PlainDate> YEAR_OF_WEEKDATE;
    private static final long serialVersionUID = -6698431452072325688L;
    /* access modifiers changed from: private */
    public final transient byte dayOfMonth;
    /* access modifiers changed from: private */
    public final transient byte month;
    /* access modifiers changed from: private */
    public final transient int year;

    /* access modifiers changed from: protected */
    public PlainDate getContext() {
        return this;
    }

    static {
        Class cls = PlainDate.class;
        int[] iArr = new int[12];
        DAY_OF_YEAR_PER_MONTH = iArr;
        int[] iArr2 = new int[12];
        DAY_OF_LEAP_YEAR_PER_MONTH = iArr2;
        iArr[0] = 31;
        iArr[1] = 59;
        iArr[2] = 90;
        iArr[3] = 120;
        iArr[4] = 151;
        iArr[5] = 181;
        iArr[6] = 212;
        iArr[7] = 243;
        iArr[8] = 273;
        iArr[9] = 304;
        iArr[10] = 334;
        iArr[11] = 365;
        iArr2[0] = 31;
        iArr2[1] = 60;
        iArr2[2] = 91;
        iArr2[3] = 121;
        iArr2[4] = 152;
        iArr2[5] = 182;
        iArr2[6] = 213;
        iArr2[7] = 244;
        iArr2[8] = 274;
        iArr2[9] = 305;
        iArr2[10] = 335;
        iArr2[11] = 366;
        DateElement dateElement = DateElement.INSTANCE;
        CALENDAR_DATE = dateElement;
        IntegerDateElement create = IntegerDateElement.create("YEAR", 14, -999999999, 999999999, AbstractJsonLexerKt.UNICODE_ESC);
        YEAR = create;
        YOWElement yOWElement = YOWElement.INSTANCE;
        YEAR_OF_WEEKDATE = yOWElement;
        EnumElement enumElement = new EnumElement("QUARTER_OF_YEAR", Quarter.class, Quarter.Q1, Quarter.Q4, 103, 'Q');
        QUARTER_OF_YEAR = enumElement;
        EnumElement enumElement2 = new EnumElement("MONTH_OF_YEAR", Month.class, Month.JANUARY, Month.DECEMBER, 101, 'M');
        MONTH_OF_YEAR = enumElement2;
        IntegerDateElement create2 = IntegerDateElement.create("MONTH_AS_NUMBER", 15, 1, 12, 'M');
        MONTH_AS_NUMBER = create2;
        IntegerDateElement create3 = IntegerDateElement.create("DAY_OF_MONTH", 16, 1, 31, 'd');
        DAY_OF_MONTH = create3;
        EnumElement enumElement3 = r11;
        EnumElement enumElement4 = new EnumElement("DAY_OF_WEEK", Weekday.class, Weekday.MONDAY, Weekday.SUNDAY, 102, 'E');
        DAY_OF_WEEK = enumElement3;
        IntegerDateElement create4 = IntegerDateElement.create("DAY_OF_YEAR", 17, 1, 365, 'D');
        DAY_OF_YEAR = create4;
        IntegerDateElement create5 = IntegerDateElement.create("DAY_OF_QUARTER", 18, 1, 92, 0);
        DAY_OF_QUARTER = create5;
        WeekdayInMonthElement weekdayInMonthElement = WeekdayInMonthElement.INSTANCE;
        WEEKDAY_IN_MONTH = weekdayInMonthElement;
        HashMap hashMap = new HashMap();
        fill(hashMap, dateElement);
        fill(hashMap, create);
        fill(hashMap, yOWElement);
        fill(hashMap, enumElement);
        fill(hashMap, enumElement2);
        fill(hashMap, create2);
        fill(hashMap, create3);
        fill(hashMap, enumElement3);
        fill(hashMap, create4);
        fill(hashMap, create5);
        fill(hashMap, weekdayInMonthElement);
        ELEMENTS = Collections.unmodifiableMap(hashMap);
        Transformer transformer = new Transformer((AnonymousClass1) null);
        TRANSFORMER = transformer;
        TimeAxis.Builder<U, D> appendElement = TimeAxis.Builder.setUp(IsoDateUnit.class, cls, new Merger((AnonymousClass1) null), transformer).appendElement(dateElement, new DateElementRule((AnonymousClass1) null), CalendarUnit.DAYS).appendElement(create, new IntegerElementRule(create), CalendarUnit.YEARS).appendElement(yOWElement, YOWElement.elementRule(cls), Weekcycle.YEARS).appendElement(enumElement, EnumElementRule.of(enumElement), CalendarUnit.QUARTERS).appendElement(enumElement2, EnumElementRule.of(enumElement2), CalendarUnit.MONTHS).appendElement(create2, new IntegerElementRule(create2), CalendarUnit.MONTHS).appendElement(create3, new IntegerElementRule(create3), CalendarUnit.DAYS).appendElement(enumElement3, EnumElementRule.of(enumElement3), CalendarUnit.DAYS).appendElement(create4, new IntegerElementRule(create4), CalendarUnit.DAYS).appendElement(create5, new IntegerElementRule(create5), CalendarUnit.DAYS).appendElement(weekdayInMonthElement, new IntegerElementRule(19, weekdayInMonthElement), CalendarUnit.WEEKS);
        registerUnits(appendElement);
        registerExtensions(appendElement);
        ENGINE = appendElement.build();
    }

    private PlainDate(int i, int i2, int i3) {
        this.year = i;
        this.month = (byte) i2;
        this.dayOfMonth = (byte) i3;
    }

    public static PlainDate of(int i, int i2, int i3) {
        return of(i, i2, i3, true);
    }

    public static PlainDate of(int i, Month month2, int i2) {
        return of(i, month2.getValue(), i2, true);
    }

    public static PlainDate of(int i, int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException("Day of year out of range: " + i2);
        } else if (i2 <= 31) {
            return of(i, 1, i2);
        } else {
            int[] iArr = GregorianMath.isLeapYear(i) ? DAY_OF_LEAP_YEAR_PER_MONTH : DAY_OF_YEAR_PER_MONTH;
            for (int i3 = i2 > iArr[6] ? 7 : 1; i3 < 12; i3++) {
                if (i2 <= iArr[i3]) {
                    return of(i, i3 + 1, i2 - iArr[i3 - 1], false);
                }
            }
            throw new IllegalArgumentException("Day of year out of range: " + i2);
        }
    }

    public static PlainDate of(int i, int i2, Weekday weekday) {
        return of(i, i2, weekday, true);
    }

    public static PlainDate of(long j, EpochDays epochDays) {
        return TRANSFORMER.transform(EpochDays.UTC.transform(j, epochDays));
    }

    public static PlainDate nowInSystemTime() {
        return ZonalClock.ofSystem().today();
    }

    public static PlainDate from(GregorianDate gregorianDate) {
        if (gregorianDate instanceof PlainDate) {
            return (PlainDate) gregorianDate;
        }
        return of(gregorianDate.getYear(), gregorianDate.getMonth(), gregorianDate.getDayOfMonth());
    }

    public PlainTimestamp atStartOfDay() {
        return at(PlainTime.MIN);
    }

    public PlainTimestamp atStartOfDay(TZID tzid) {
        return atStartOfDay(Timezone.of(tzid).getHistory());
    }

    public PlainTimestamp atStartOfDay(String str) {
        return atStartOfDay(Timezone.of(str).getHistory());
    }

    public Moment atFirstMoment(TZID tzid) {
        return atFirstMoment(Timezone.of(tzid));
    }

    public Moment atFirstMoment(String str) {
        return atFirstMoment(Timezone.of(str));
    }

    public PlainTimestamp at(PlainTime plainTime) {
        return PlainTimestamp.of(this, plainTime);
    }

    public PlainTimestamp atTime(int i, int i2) {
        return at(PlainTime.of(i, i2));
    }

    public PlainTimestamp atTime(int i, int i2, int i3) {
        return at(PlainTime.of(i, i2, i3));
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public Weekday getDayOfWeek() {
        return Weekday.valueOf(GregorianMath.getDayOfWeek(this.year, this.month, this.dayOfMonth));
    }

    public int getDayOfYear() {
        byte b = this.month;
        if (b != 1) {
            return b != 2 ? DAY_OF_YEAR_PER_MONTH[b - 2] + this.dayOfMonth + (GregorianMath.isLeapYear(this.year) ? 1 : 0) : this.dayOfMonth + 31;
        }
        return this.dayOfMonth;
    }

    public int lengthOfMonth() {
        return GregorianMath.getLengthOfMonth(this.year, this.month);
    }

    public int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    public boolean isLeapYear() {
        return GregorianMath.isLeapYear(this.year);
    }

    public boolean isWeekend(Locale locale) {
        return matches(Weekmodel.of(locale).weekend());
    }

    public static boolean isValid(int i, int i2, int i3) {
        return GregorianMath.isValid(i, i2, i3);
    }

    public String print(TemporalFormatter<PlainDate> temporalFormatter) {
        return temporalFormatter.print(this);
    }

    public static PlainDate parse(String str, TemporalFormatter<PlainDate> temporalFormatter) {
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
        if (!(obj instanceof PlainDate)) {
            return false;
        }
        PlainDate plainDate = (PlainDate) obj;
        if (this.dayOfMonth == plainDate.dayOfMonth && this.month == plainDate.month && this.year == plainDate.year) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.year;
        return (((i << 11) + (this.month << 6)) + this.dayOfMonth) ^ (i & -2048);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        formatYear(sb, this.year);
        format2Digits(sb, this.month);
        format2Digits(sb, this.dayOfMonth);
        return sb.toString();
    }

    public Duration<CalendarUnit> normalize(TimeSpan<? extends CalendarUnit> timeSpan) {
        return (Duration) until(plus(timeSpan), Duration.inYearsMonthsDays());
    }

    public static TimeAxis<IsoDateUnit, PlainDate> axis() {
        return ENGINE;
    }

    public static <S> Chronology<S> axis(Converter<S, PlainDate> converter) {
        return new BridgeChronology(converter, ENGINE);
    }

    /* access modifiers changed from: protected */
    public TimeAxis<IsoDateUnit, PlainDate> getChronology() {
        return ENGINE;
    }

    /* access modifiers changed from: protected */
    public int compareByTime(CalendarDate calendarDate) {
        if (!(calendarDate instanceof PlainDate)) {
            return super.compareByTime(calendarDate);
        }
        PlainDate plainDate = (PlainDate) calendarDate;
        int i = this.year - plainDate.year;
        if (i != 0) {
            return i;
        }
        int i2 = this.month - plainDate.month;
        return i2 == 0 ? this.dayOfMonth - plainDate.dayOfMonth : i2;
    }

    /* access modifiers changed from: package-private */
    public long getDaysSinceUTC() {
        return TRANSFORMER.transform(this);
    }

    /* access modifiers changed from: package-private */
    public PlainDate withDaysSinceUTC(long j) {
        return TRANSFORMER.transform(j);
    }

    static PlainDate from(UnixTime unixTime, ZonalOffset zonalOffset) {
        long posixTime = unixTime.getPosixTime() + ((long) zonalOffset.getIntegralAmount());
        int nanosecond = unixTime.getNanosecond() + zonalOffset.getFractionalAmount();
        if (nanosecond < 0) {
            posixTime--;
        } else if (nanosecond >= 1000000000) {
            posixTime++;
        }
        long packedDate = GregorianMath.toPackedDate(EpochDays.MODIFIED_JULIAN_DATE.transform(MathUtils.floorDivide(posixTime, 86400), EpochDays.UNIX));
        return of(GregorianMath.readYear(packedDate), GregorianMath.readMonth(packedDate), GregorianMath.readDayOfMonth(packedDate));
    }

    static Object lookupElement(String str) {
        return ELEMENTS.get(str);
    }

    static PlainDate doAdd(CalendarUnit calendarUnit, PlainDate plainDate, long j, int i) {
        switch (AnonymousClass1.$SwitchMap$net$time4j$CalendarUnit[calendarUnit.ordinal()]) {
            case 1:
                return doAdd(CalendarUnit.MONTHS, plainDate, MathUtils.safeMultiply(j, 12000), i);
            case 2:
                return doAdd(CalendarUnit.MONTHS, plainDate, MathUtils.safeMultiply(j, 1200), i);
            case 3:
                return doAdd(CalendarUnit.MONTHS, plainDate, MathUtils.safeMultiply(j, 120), i);
            case 4:
                return doAdd(CalendarUnit.MONTHS, plainDate, MathUtils.safeMultiply(j, 12), i);
            case 5:
                return doAdd(CalendarUnit.MONTHS, plainDate, MathUtils.safeMultiply(j, 3), i);
            case 6:
                return fromEpochMonths(plainDate, MathUtils.safeAdd(plainDate.getEpochMonths(), j), plainDate.dayOfMonth, i);
            case 7:
                return doAdd(CalendarUnit.DAYS, plainDate, MathUtils.safeMultiply(j, 7), i);
            case 8:
                return addDays(plainDate, j);
            default:
                throw new UnsupportedOperationException(calendarUnit.name());
        }
    }

    /* access modifiers changed from: package-private */
    public long getEpochMonths() {
        return ((((long) (this.year - 1970)) * 12) + ((long) this.month)) - 1;
    }

    /* access modifiers changed from: package-private */
    public int getWeekOfYear() {
        return ((Integer) get(Weekmodel.ISO.weekOfYear())).intValue();
    }

    private PlainTimestamp atStartOfDay(TransitionHistory transitionHistory) {
        if (transitionHistory != null) {
            ZonalTransition conflictTransition = transitionHistory.getConflictTransition(this, PlainTime.MIN);
            if (conflictTransition == null || !conflictTransition.isGap()) {
                return at(PlainTime.MIN);
            }
            long posixTime = conflictTransition.getPosixTime() + ((long) conflictTransition.getTotalOffset());
            PlainDate of = of(MathUtils.floorDivide(posixTime, 86400), EpochDays.UNIX);
            int floorModulo = MathUtils.floorModulo(posixTime, 86400);
            int i = floorModulo % 60;
            int i2 = floorModulo / 60;
            return PlainTimestamp.of(of, PlainTime.of(i2 / 60, i2 % 60, i));
        }
        throw new UnsupportedOperationException("Timezone repository does not expose its transition history: " + Timezone.getProviderInfo());
    }

    private Moment atFirstMoment(Timezone timezone) {
        TransitionHistory history = timezone.getHistory();
        if (history != null) {
            ZonalTransition conflictTransition = history.getConflictTransition(this, PlainTime.MIN);
            if (conflictTransition == null || !conflictTransition.isGap()) {
                return at(PlainTime.MIN).in(timezone);
            }
            return Moment.of(conflictTransition.getPosixTime(), TimeScale.POSIX);
        }
        throw new UnsupportedOperationException("Timezone repository does not expose its transition history: " + Timezone.getProviderInfo());
    }

    /* access modifiers changed from: private */
    public int getDayOfQuarter() {
        switch (this.month) {
            case 1:
            case 4:
            case 7:
            case 10:
                return this.dayOfMonth;
            case 2:
            case 8:
            case 11:
                return this.dayOfMonth + 31;
            case 3:
                return (GregorianMath.isLeapYear(this.year) ? (byte) 60 : 59) + this.dayOfMonth;
            case 5:
                return this.dayOfMonth + 30;
            case 6:
            case 12:
                return this.dayOfMonth + 61;
            case 9:
                return this.dayOfMonth + 62;
            default:
                throw new AssertionError("Unknown month: " + this.month);
        }
    }

    /* access modifiers changed from: private */
    public PlainDate withYear(int i) {
        if (this.year == i) {
            return this;
        }
        return of(i, (int) this.month, Math.min(GregorianMath.getLengthOfMonth(i, this.month), this.dayOfMonth));
    }

    /* access modifiers changed from: private */
    public PlainDate withMonth(int i) {
        if (this.month == i) {
            return this;
        }
        return of(this.year, i, Math.min(GregorianMath.getLengthOfMonth(this.year, i), this.dayOfMonth));
    }

    /* access modifiers changed from: private */
    public PlainDate withDayOfMonth(int i) {
        if (this.dayOfMonth == i) {
            return this;
        }
        return of(this.year, (int) this.month, i);
    }

    /* access modifiers changed from: private */
    public PlainDate withDayOfWeek(Weekday weekday) {
        Weekday dayOfWeek = getDayOfWeek();
        if (dayOfWeek == weekday) {
            return this;
        }
        return TRANSFORMER.transform(MathUtils.safeAdd(getDaysSinceUTC(), (long) (weekday.getValue() - dayOfWeek.getValue())));
    }

    /* access modifiers changed from: private */
    public PlainDate withDayOfYear(int i) {
        if (getDayOfYear() == i) {
            return this;
        }
        return of(this.year, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0079, code lost:
        if (r11 == 2) goto L_0x007b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static net.time4j.PlainDate fromEpochMonths(net.time4j.PlainDate r7, long r8, int r10, int r11) {
        /*
            r0 = 2
            r1 = 5
            if (r11 != r1) goto L_0x000d
            byte r1 = r7.dayOfMonth
            int r2 = r7.lengthOfMonth()
            if (r1 != r2) goto L_0x000d
            r11 = 2
        L_0x000d:
            r1 = 12
            long r2 = net.time4j.base.MathUtils.floorDivide((long) r8, (int) r1)
            r4 = 1970(0x7b2, double:9.733E-321)
            long r2 = net.time4j.base.MathUtils.safeAdd((long) r2, (long) r4)
            int r2 = net.time4j.base.MathUtils.safeCast(r2)
            int r1 = net.time4j.base.MathUtils.floorModulo((long) r8, (int) r1)
            r3 = 1
            int r1 = r1 + r3
            int r4 = net.time4j.base.GregorianMath.getLengthOfMonth(r2, r1)
            if (r10 <= r4) goto L_0x0077
            r5 = 1
            switch(r11) {
                case 0: goto L_0x007b;
                case 1: goto L_0x006e;
                case 2: goto L_0x007b;
                case 3: goto L_0x0064;
                case 4: goto L_0x0045;
                case 5: goto L_0x007b;
                case 6: goto L_0x007b;
                default: goto L_0x002e;
            }
        L_0x002e:
            java.lang.UnsupportedOperationException r7 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "Overflow policy not implemented: "
            r8.append(r9)
            r8.append(r11)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x0045:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r8 = 32
            r7.<init>(r8)
            java.lang.String r8 = "Day of month out of range: "
            r7.append(r8)
            formatYear(r7, r2)
            format2Digits(r7, r1)
            format2Digits(r7, r10)
            net.time4j.engine.ChronoException r8 = new net.time4j.engine.ChronoException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        L_0x0064:
            long r8 = net.time4j.base.MathUtils.safeAdd((long) r8, (long) r5)
            int r10 = r10 - r4
            net.time4j.PlainDate r7 = fromEpochMonths(r7, r8, r10, r11)
            return r7
        L_0x006e:
            long r8 = net.time4j.base.MathUtils.safeAdd((long) r8, (long) r5)
            net.time4j.PlainDate r7 = fromEpochMonths(r7, r8, r3, r11)
            return r7
        L_0x0077:
            if (r10 >= r4) goto L_0x007c
            if (r11 != r0) goto L_0x007c
        L_0x007b:
            r10 = r4
        L_0x007c:
            net.time4j.PlainDate r7 = of((int) r2, (int) r1, (int) r10)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.PlainDate.fromEpochMonths(net.time4j.PlainDate, long, int, int):net.time4j.PlainDate");
    }

    private static PlainDate addDays(PlainDate plainDate, long j) {
        long safeAdd = MathUtils.safeAdd((long) plainDate.dayOfMonth, j);
        if (safeAdd >= 1 && safeAdd <= 28) {
            return of(plainDate.year, (int) plainDate.month, (int) safeAdd);
        }
        long safeAdd2 = MathUtils.safeAdd((long) plainDate.getDayOfYear(), j);
        if (safeAdd2 >= 1 && safeAdd2 <= 365) {
            return of(plainDate.year, (int) safeAdd2);
        }
        return TRANSFORMER.transform(MathUtils.safeAdd(plainDate.getDaysSinceUTC(), j));
    }

    private static void fill(Map<String, Object> map, ChronoElement<?> chronoElement) {
        map.put(chronoElement.name(), chronoElement);
    }

    private static void formatYear(StringBuilder sb, int i) {
        int i2;
        if (i < 0) {
            sb.append(SignatureVisitor.SUPER);
            i2 = MathUtils.safeNegate(i);
        } else {
            i2 = i;
        }
        if (i2 >= 10000) {
            if (i > 0) {
                sb.append(SignatureVisitor.EXTENDS);
            }
        } else if (i2 < 1000) {
            sb.append('0');
            if (i2 < 100) {
                sb.append('0');
                if (i2 < 10) {
                    sb.append('0');
                }
            }
        }
        sb.append(i2);
    }

    private static void format2Digits(StringBuilder sb, int i) {
        sb.append(SignatureVisitor.SUPER);
        if (i < 10) {
            sb.append('0');
        }
        sb.append(i);
    }

    private static void registerExtensions(TimeAxis.Builder<IsoDateUnit, PlainDate> builder) {
        for (S s : ResourceLoader.getInstance().services(ChronoExtension.class)) {
            if (s.accept(PlainDate.class)) {
                builder.appendExtension((ChronoExtension) s);
            }
        }
        builder.appendExtension((ChronoExtension) new WeekExtension());
    }

    private static void registerUnits(TimeAxis.Builder<IsoDateUnit, PlainDate> builder) {
        EnumSet range = EnumSet.range(CalendarUnit.MILLENNIA, CalendarUnit.MONTHS);
        EnumSet range2 = EnumSet.range(CalendarUnit.WEEKS, CalendarUnit.DAYS);
        for (CalendarUnit calendarUnit : CalendarUnit.values()) {
            builder.appendUnit(calendarUnit, new CalendarUnit.Rule(calendarUnit), calendarUnit.getLength(), calendarUnit.compareTo(CalendarUnit.WEEKS) < 0 ? range : range2);
        }
    }

    /* access modifiers changed from: private */
    public static PlainDate of(int i, int i2, Weekday weekday, boolean z) {
        if (i2 < 1 || i2 > 53) {
            if (!z) {
                return null;
            }
            throw new IllegalArgumentException(woyFailed(i2));
        } else if (!z || (i >= MIN_YEAR.intValue() && i <= MAX_YEAR.intValue())) {
            int value = Weekday.valueOf(GregorianMath.getDayOfWeek(i, 1, 1)).getValue();
            int value2 = (((value <= 4 ? 2 - value : 9 - value) + ((i2 - 1) * 7)) + weekday.getValue()) - 1;
            int i3 = 366;
            if (value2 <= 0) {
                i--;
                if (!GregorianMath.isLeapYear(i)) {
                    i3 = 365;
                }
                value2 += i3;
            } else {
                if (!GregorianMath.isLeapYear(i)) {
                    i3 = 365;
                }
                if (value2 > i3) {
                    value2 -= i3;
                    i++;
                }
            }
            PlainDate of = of(i, value2);
            if (i2 != 53 || of.getWeekOfYear() == 53) {
                return of;
            }
            if (!z) {
                return null;
            }
            throw new IllegalArgumentException(woyFailed(i2));
        } else {
            throw new IllegalArgumentException(yowFailed(i));
        }
    }

    /* access modifiers changed from: private */
    public static String yowFailed(int i) {
        return "YEAR_OF_WEEKDATE (ISO) out of range: " + i;
    }

    /* access modifiers changed from: private */
    public static String woyFailed(int i) {
        return "WEEK_OF_YEAR (ISO) out of range: " + i;
    }

    /* access modifiers changed from: private */
    public static PlainDate of(int i, int i2, int i3, boolean z) {
        if (z) {
            GregorianMath.checkDate(i, i2, i3);
        }
        return new PlainDate(i, i2, i3);
    }

    private Object writeReplace() {
        return new SPX(this, 1);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private static class Merger implements ChronoMerger<PlainDate> {
        private static final int DEFAULT_PIVOT_YEAR = (GregorianMath.readYear(GregorianMath.toPackedDate(EpochDays.MODIFIED_JULIAN_DATE.transform(MathUtils.floorDivide(System.currentTimeMillis(), 86400000), EpochDays.UNIX))) + 20);

        public ChronoDisplay preformat(PlainDate plainDate, AttributeQuery attributeQuery) {
            return plainDate;
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
            return CalendarText.patternForDate(DisplayMode.ofStyle(displayStyle.getStyleValue()), locale);
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [net.time4j.base.TimeSource, net.time4j.base.TimeSource<?>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.PlainDate createFrom(net.time4j.base.TimeSource<?> r3, net.time4j.engine.AttributeQuery r4) {
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
                net.time4j.PlainDate r3 = net.time4j.PlainDate.from(r3, r4)
                return r3
            L_0x0036:
                r3 = 0
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.PlainDate.Merger.createFrom(net.time4j.base.TimeSource, net.time4j.engine.AttributeQuery):net.time4j.PlainDate");
        }

        public PlainDate createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            Weekday weekday;
            int i;
            if (chronoEntity.contains(PlainDate.CALENDAR_DATE)) {
                return (PlainDate) chronoEntity.get((ChronoElement<V>) PlainDate.CALENDAR_DATE);
            }
            int i2 = chronoEntity.getInt(PlainDate.YEAR);
            if (i2 != Integer.MIN_VALUE) {
                int i3 = chronoEntity.getInt(PlainDate.MONTH_AS_NUMBER);
                if (i3 == Integer.MIN_VALUE && chronoEntity.contains(PlainDate.MONTH_OF_YEAR)) {
                    i3 = ((Month) chronoEntity.get((ChronoElement<V>) PlainDate.MONTH_OF_YEAR)).getValue();
                }
                if (i3 == Integer.MIN_VALUE || (i = chronoEntity.getInt(PlainDate.DAY_OF_MONTH)) == Integer.MIN_VALUE) {
                    int i4 = chronoEntity.getInt(PlainDate.DAY_OF_YEAR);
                    if (i4 == Integer.MIN_VALUE) {
                        int i5 = chronoEntity.getInt(PlainDate.DAY_OF_QUARTER);
                        if (i5 != Integer.MIN_VALUE && chronoEntity.contains(PlainDate.QUARTER_OF_YEAR)) {
                            Quarter quarter = (Quarter) chronoEntity.get((ChronoElement<V>) PlainDate.QUARTER_OF_YEAR);
                            boolean isLeapYear = GregorianMath.isLeapYear(i2);
                            int i6 = (isLeapYear ? 91 : 90) + i5;
                            if (quarter == Quarter.Q1) {
                                i6 = i5;
                            } else if (quarter == Quarter.Q3) {
                                i6 += 91;
                            } else if (quarter == Quarter.Q4) {
                                i6 += 183;
                            }
                            if (z) {
                                return (PlainDate) PlainDate.of(i2, 1).with(PlainDate.DAY_OF_YEAR.setLenient(Integer.valueOf(i6)));
                            }
                            if (!validateYear(chronoEntity, i2) || !validateDayOfQuarter(chronoEntity, isLeapYear, quarter, i5)) {
                                return null;
                            }
                            return PlainDate.of(i2, i6);
                        }
                    } else if (z) {
                        return (PlainDate) PlainDate.of(i2, 1).with(PlainDate.DAY_OF_YEAR.setLenient(Integer.valueOf(i4)));
                    } else {
                        if (!validateYear(chronoEntity, i2) || !validateDayOfYear(chronoEntity, i2, i4)) {
                            return null;
                        }
                        return PlainDate.of(i2, i4);
                    }
                } else if (z) {
                    return (PlainDate) ((PlainDate) PlainDate.of(i2, 1, 1).with(PlainDate.MONTH_AS_NUMBER.setLenient(Integer.valueOf(i3)))).with(PlainDate.DAY_OF_MONTH.setLenient(Integer.valueOf(i)));
                } else {
                    if (!validateYear(chronoEntity, i2) || !validateMonth(chronoEntity, i3) || !validateDayOfMonth(chronoEntity, i2, i3, i)) {
                        return null;
                    }
                    return PlainDate.of(i2, i3, i, false);
                }
            }
            int i7 = chronoEntity.getInt(PlainDate.YEAR_OF_WEEKDATE);
            if (i7 != Integer.MIN_VALUE && chronoEntity.contains(Weekmodel.ISO.weekOfYear())) {
                int intValue = ((Integer) chronoEntity.get((ChronoElement<V>) Weekmodel.ISO.weekOfYear())).intValue();
                if (chronoEntity.contains(PlainDate.DAY_OF_WEEK)) {
                    weekday = (Weekday) chronoEntity.get((ChronoElement<V>) PlainDate.DAY_OF_WEEK);
                } else {
                    if (chronoEntity.contains(Weekmodel.ISO.localDayOfWeek())) {
                        weekday = (Weekday) chronoEntity.get((ChronoElement<V>) Weekmodel.ISO.localDayOfWeek());
                    }
                    return null;
                }
                if (i7 < -999999999 || i7 > 999999999) {
                    flagValidationError(chronoEntity, PlainDate.yowFailed(i7));
                    return null;
                }
                PlainDate access$500 = PlainDate.of(i7, intValue, weekday, false);
                if (access$500 == null) {
                    flagValidationError(chronoEntity, PlainDate.woyFailed(intValue));
                }
                return access$500;
            } else if (chronoEntity.contains(EpochDays.MODIFIED_JULIAN_DATE)) {
                return (PlainDate) PlainDate.TRANSFORMER.transform(EpochDays.UTC.transform(((Long) chronoEntity.get((ChronoElement<V>) EpochDays.MODIFIED_JULIAN_DATE)).longValue(), EpochDays.MODIFIED_JULIAN_DATE));
            } else if (chronoEntity instanceof UnixTime) {
                return ((PlainTimestamp) PlainTimestamp.axis().createFrom((ChronoEntity) chronoEntity, attributeQuery, z, z2)).getCalendarDate();
            } else {
                return null;
            }
        }

        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.MIDNIGHT;
        }

        public int getDefaultPivotYear() {
            return DEFAULT_PIVOT_YEAR;
        }

        private static boolean validateYear(ChronoEntity<?> chronoEntity, int i) {
            if (i >= -999999999 && i <= 999999999) {
                return true;
            }
            flagValidationError(chronoEntity, "YEAR out of range: " + i);
            return false;
        }

        private static boolean validateMonth(ChronoEntity<?> chronoEntity, int i) {
            if (i >= 1 && i <= 12) {
                return true;
            }
            flagValidationError(chronoEntity, "MONTH_OF_YEAR out of range: " + i);
            return false;
        }

        private static boolean validateDayOfMonth(ChronoEntity<?> chronoEntity, int i, int i2, int i3) {
            if (i3 >= 1 && (i3 <= 28 || i3 <= GregorianMath.getLengthOfMonth(i, i2))) {
                return true;
            }
            flagValidationError(chronoEntity, "DAY_OF_MONTH out of range: " + i3);
            return false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
            if (r4 > r1) goto L_0x0013;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean validateDayOfYear(net.time4j.engine.ChronoEntity<?> r2, int r3, int r4) {
            /*
                r0 = 1
                if (r4 < r0) goto L_0x0013
                r1 = 365(0x16d, float:5.11E-43)
                if (r4 <= r1) goto L_0x0012
                boolean r3 = net.time4j.base.GregorianMath.isLeapYear(r3)
                if (r3 == 0) goto L_0x000f
                r1 = 366(0x16e, float:5.13E-43)
            L_0x000f:
                if (r4 <= r1) goto L_0x0012
                goto L_0x0013
            L_0x0012:
                return r0
            L_0x0013:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r0 = "DAY_OF_YEAR out of range: "
                r3.append(r0)
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                flagValidationError(r2, r3)
                r2 = 0
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.PlainDate.Merger.validateDayOfYear(net.time4j.engine.ChronoEntity, int, int):boolean");
        }

        private static boolean validateDayOfQuarter(ChronoEntity<?> chronoEntity, boolean z, Quarter quarter, int i) {
            int i2 = AnonymousClass1.$SwitchMap$net$time4j$Quarter[quarter.ordinal()];
            int i3 = 91;
            if (i2 != 1) {
                if (i2 != 2) {
                    i3 = 92;
                }
            } else if (!z) {
                i3 = 90;
            }
            if (i >= 1 && i <= i3) {
                return true;
            }
            flagValidationError(chronoEntity, "DAY_OF_QUARTER out of range: " + i);
            return false;
        }

        private static void flagValidationError(ChronoEntity<?> chronoEntity, String str) {
            if (chronoEntity.isValid((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, str)) {
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, str);
            }
        }
    }

    /* renamed from: net.time4j.PlainDate$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$CalendarUnit;
        static final /* synthetic */ int[] $SwitchMap$net$time4j$Quarter;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0038 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006f */
        static {
            /*
                net.time4j.Quarter[] r0 = net.time4j.Quarter.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$Quarter = r0
                r1 = 1
                net.time4j.Quarter r2 = net.time4j.Quarter.Q1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$net$time4j$Quarter     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.Quarter r3 = net.time4j.Quarter.Q2     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                net.time4j.CalendarUnit[] r2 = net.time4j.CalendarUnit.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$net$time4j$CalendarUnit = r2
                net.time4j.CalendarUnit r3 = net.time4j.CalendarUnit.MILLENNIA     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x0038 }
                net.time4j.CalendarUnit r2 = net.time4j.CalendarUnit.CENTURIES     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x0043 }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.DECADES     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x004e }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.YEARS     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x0059 }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.QUARTERS     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x0064 }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.MONTHS     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x006f }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.WEEKS     // Catch:{ NoSuchFieldError -> 0x006f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x007b }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.DAYS     // Catch:{ NoSuchFieldError -> 0x007b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.PlainDate.AnonymousClass1.<clinit>():void");
        }
    }

    private static class Transformer implements CalendarSystem<PlainDate> {
        private static final long MAX_LONG = 365241779741L;
        private static final long MIN_LONG = -365243219892L;

        public long getMaximumSinceUTC() {
            return MAX_LONG;
        }

        public long getMinimumSinceUTC() {
            return MIN_LONG;
        }

        private Transformer() {
        }

        /* synthetic */ Transformer(AnonymousClass1 r1) {
            this();
        }

        public PlainDate transform(long j) {
            if (j == MIN_LONG) {
                return PlainDate.MIN;
            }
            if (j == MAX_LONG) {
                return PlainDate.MAX;
            }
            long packedDate = GregorianMath.toPackedDate(EpochDays.MODIFIED_JULIAN_DATE.transform(j, EpochDays.UTC));
            return PlainDate.of(GregorianMath.readYear(packedDate), GregorianMath.readMonth(packedDate), GregorianMath.readDayOfMonth(packedDate));
        }

        public long transform(PlainDate plainDate) {
            return EpochDays.UTC.transform(GregorianMath.toMJD(plainDate), EpochDays.MODIFIED_JULIAN_DATE);
        }

        public List<CalendarEra> getEras() {
            return Collections.emptyList();
        }
    }

    private static class DateElementRule implements ElementRule<PlainDate, PlainDate> {
        public ChronoElement<?> getChildAtCeiling(PlainDate plainDate) {
            return null;
        }

        public ChronoElement<?> getChildAtFloor(PlainDate plainDate) {
            return null;
        }

        public PlainDate getValue(PlainDate plainDate) {
            return plainDate;
        }

        public boolean isValid(PlainDate plainDate, PlainDate plainDate2) {
            return plainDate2 != null;
        }

        private DateElementRule() {
        }

        /* synthetic */ DateElementRule(AnonymousClass1 r1) {
            this();
        }

        public PlainDate withValue(PlainDate plainDate, PlainDate plainDate2, boolean z) {
            if (plainDate2 != null) {
                return plainDate2;
            }
            throw new IllegalArgumentException("Missing date value.");
        }

        public PlainDate getMinimum(PlainDate plainDate) {
            return PlainDate.MIN;
        }

        public PlainDate getMaximum(PlainDate plainDate) {
            return PlainDate.MAX;
        }
    }

    private static class IntegerElementRule implements IntElementRule<PlainDate> {
        private final int index;
        private final String name;
        private final ChronoElement<?> ref;

        IntegerElementRule(ChronoElement<Integer> chronoElement) {
            this(((IntegerDateElement) chronoElement).getIndex(), chronoElement);
        }

        IntegerElementRule(int i, ChronoElement<?> chronoElement) {
            this.ref = chronoElement;
            this.name = chronoElement.name();
            this.index = i;
        }

        public Integer getValue(PlainDate plainDate) {
            return Integer.valueOf(getInt(plainDate));
        }

        public int getInt(PlainDate plainDate) {
            switch (this.index) {
                case 14:
                    return plainDate.year;
                case 15:
                    return plainDate.month;
                case 16:
                    return plainDate.dayOfMonth;
                case 17:
                    return plainDate.getDayOfYear();
                case 18:
                    return plainDate.getDayOfQuarter();
                case 19:
                    return ((plainDate.dayOfMonth - 1) / 7) + 1;
                default:
                    throw new UnsupportedOperationException(this.name);
            }
        }

        public PlainDate withValue(PlainDate plainDate, Integer num, boolean z) {
            if (num != null) {
                return withValue(plainDate, num.intValue(), z);
            }
            throw new IllegalArgumentException("Missing element value.");
        }

        public PlainDate withValue(PlainDate plainDate, int i, boolean z) {
            if (z) {
                return (PlainDate) plainDate.plus((long) MathUtils.safeSubtract(i, getInt(plainDate)), (IsoDateUnit) PlainDate.ENGINE.getBaseUnit(this.ref));
            }
            switch (this.index) {
                case 14:
                    return plainDate.withYear(i);
                case 15:
                    return plainDate.withMonth(i);
                case 16:
                    return plainDate.withDayOfMonth(i);
                case 17:
                    return plainDate.withDayOfYear(i);
                case 18:
                    if (i >= 1 && i <= getMaximumOfQuarterDay(plainDate)) {
                        return (PlainDate) plainDate.plus((long) (i - plainDate.getDayOfQuarter()), CalendarUnit.DAYS);
                    }
                    throw new IllegalArgumentException("Out of range: " + i);
                case 19:
                    if (z || (i >= 1 && i <= getMaximumOfWIM(plainDate))) {
                        return (PlainDate) plainDate.plus((long) (i - (((plainDate.dayOfMonth - 1) / 7) + 1)), CalendarUnit.WEEKS);
                    }
                    throw new IllegalArgumentException("Out of range: " + i);
                default:
                    throw new UnsupportedOperationException(this.name);
            }
        }

        public boolean isValid(PlainDate plainDate, Integer num) {
            return num != null && isValid(plainDate, num.intValue());
        }

        public boolean isValid(PlainDate plainDate, int i) {
            switch (this.index) {
                case 14:
                    if (i < -999999999 || i > 999999999) {
                        return false;
                    }
                    return true;
                case 15:
                    if (i < 1 || i > 12) {
                        return false;
                    }
                    return true;
                case 16:
                    if (i < 1 || i > GregorianMath.getLengthOfMonth(plainDate.year, plainDate.month)) {
                        return false;
                    }
                    return true;
                case 17:
                    if (i < 1) {
                        return false;
                    }
                    if (i <= (GregorianMath.isLeapYear(plainDate.year) ? 366 : 365)) {
                        return true;
                    }
                    return false;
                case 18:
                    if (i < 1 || i > getMaximumOfQuarterDay(plainDate)) {
                        return false;
                    }
                    return true;
                case 19:
                    if (i < 1 || i > getMaximumOfWIM(plainDate)) {
                        return false;
                    }
                    return true;
                default:
                    throw new UnsupportedOperationException(this.name);
            }
        }

        public Integer getMinimum(PlainDate plainDate) {
            switch (this.index) {
                case 14:
                    return PlainDate.MIN_YEAR;
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    return PlainDate.VALUE_1;
                default:
                    throw new UnsupportedOperationException(this.name);
            }
        }

        public Integer getMaximum(PlainDate plainDate) {
            switch (this.index) {
                case 14:
                    return PlainDate.MAX_YEAR;
                case 15:
                    return PlainDate.VALUE_12;
                case 16:
                    return Integer.valueOf(GregorianMath.getLengthOfMonth(plainDate.year, plainDate.month));
                case 17:
                    return GregorianMath.isLeapYear(plainDate.year) ? PlainDate.LEAP_YEAR_LEN : PlainDate.STD_YEAR_LEN;
                case 18:
                    return Integer.valueOf(getMaximumOfQuarterDay(plainDate));
                case 19:
                    return Integer.valueOf(getMaximumOfWIM(plainDate));
                default:
                    throw new UnsupportedOperationException(this.name);
            }
        }

        public ChronoElement<?> getChildAtFloor(PlainDate plainDate) {
            return getChild();
        }

        public ChronoElement<?> getChildAtCeiling(PlainDate plainDate) {
            return getChild();
        }

        private ChronoElement<?> getChild() {
            switch (this.index) {
                case 14:
                    return PlainDate.MONTH_AS_NUMBER;
                case 15:
                    return PlainDate.DAY_OF_MONTH;
                case 16:
                case 17:
                case 18:
                case 19:
                    return null;
                default:
                    throw new UnsupportedOperationException(this.name);
            }
        }

        private static int getMaximumOfQuarterDay(PlainDate plainDate) {
            int access$900 = ((plainDate.month - 1) / 3) + 1;
            if (access$900 == 1) {
                if (GregorianMath.isLeapYear(plainDate.year)) {
                    return 91;
                }
                return 90;
            } else if (access$900 == 2) {
                return 91;
            } else {
                return 92;
            }
        }

        private int getMaximumOfWIM(PlainDate plainDate) {
            int lengthOfMonth = GregorianMath.getLengthOfMonth(plainDate.year, plainDate.month);
            byte access$1000 = plainDate.dayOfMonth;
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if ((i2 * 7) + access$1000 > lengthOfMonth) {
                    return (((access$1000 + (i * 7)) - 1) / 7) + 1;
                }
                i = i2;
            }
        }
    }

    private static class EnumElementRule<V extends Enum<V>> implements ElementRule<PlainDate, V> {
        private final int index;
        private final V max;
        private final V min;
        private final String name;
        private final Class<V> type;

        EnumElementRule(String str, Class<V> cls, V v, V v2, int i) {
            this.name = str;
            this.type = cls;
            this.min = v;
            this.max = v2;
            this.index = i;
        }

        static <V extends Enum<V>> EnumElementRule<V> of(ChronoElement<V> chronoElement) {
            return new EnumElementRule(chronoElement.name(), chronoElement.getType(), (Enum) chronoElement.getDefaultMinimum(), (Enum) chronoElement.getDefaultMaximum(), ((EnumElement) chronoElement).getIndex());
        }

        public V getValue(PlainDate plainDate) {
            Object obj;
            switch (this.index) {
                case 101:
                    obj = Month.valueOf((int) plainDate.month);
                    break;
                case 102:
                    obj = plainDate.getDayOfWeek();
                    break;
                case 103:
                    obj = Quarter.valueOf(((plainDate.month - 1) / 3) + 1);
                    break;
                default:
                    throw new UnsupportedOperationException(this.name);
            }
            return (Enum) this.type.cast(obj);
        }

        public V getMinimum(PlainDate plainDate) {
            return this.min;
        }

        public V getMaximum(PlainDate plainDate) {
            if (this.index == 102 && plainDate.year == 999999999 && plainDate.month == 12 && plainDate.dayOfMonth >= 27) {
                return (Enum) this.type.cast(Weekday.FRIDAY);
            }
            return this.max;
        }

        public boolean isValid(PlainDate plainDate, V v) {
            if (v == null) {
                return false;
            }
            if (this.index != 102 || plainDate.year != 999999999) {
                return true;
            }
            try {
                withValue(plainDate, v, false);
                return true;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }

        public PlainDate withValue(PlainDate plainDate, V v, boolean z) {
            if (v != null) {
                switch (this.index) {
                    case 101:
                        return plainDate.withMonth(Month.class.cast(v).getValue());
                    case 102:
                        return plainDate.withDayOfWeek(Weekday.class.cast(v));
                    case 103:
                        return (PlainDate) plainDate.plus((long) (Quarter.class.cast(v).getValue() - (((plainDate.month - 1) / 3) + 1)), CalendarUnit.QUARTERS);
                    default:
                        throw new UnsupportedOperationException(this.name);
                }
            } else {
                throw new IllegalArgumentException("Missing element value.");
            }
        }

        public ChronoElement<?> getChildAtFloor(PlainDate plainDate) {
            return getChild();
        }

        public ChronoElement<?> getChildAtCeiling(PlainDate plainDate) {
            return getChild();
        }

        private ChronoElement<?> getChild() {
            switch (this.index) {
                case 101:
                    return PlainDate.DAY_OF_MONTH;
                case 102:
                    return null;
                case 103:
                    return PlainDate.DAY_OF_QUARTER;
                default:
                    throw new UnsupportedOperationException(this.name);
            }
        }
    }
}
