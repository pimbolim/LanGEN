package net.time4j.calendar;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.io.DataInputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.text.ParsePosition;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import net.time4j.GeneralTimestamp;
import net.time4j.Month;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.SystemClock;
import net.time4j.Weekday;
import net.time4j.Weekmodel;
import net.time4j.base.GregorianMath;
import net.time4j.base.MathUtils;
import net.time4j.base.ResourceLoader;
import net.time4j.calendar.Nengo;
import net.time4j.calendar.service.GenericDatePatterns;
import net.time4j.calendar.service.StdIntegerDateElement;
import net.time4j.calendar.service.StdWeekdayElement;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.CalendarDate;
import net.time4j.engine.CalendarEra;
import net.time4j.engine.CalendarSystem;
import net.time4j.engine.Calendrical;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.ChronoFunction;
import net.time4j.engine.ChronoMerger;
import net.time4j.engine.ChronoOperator;
import net.time4j.engine.ChronoUnit;
import net.time4j.engine.Chronology;
import net.time4j.engine.DisplayStyle;
import net.time4j.engine.ElementRule;
import net.time4j.engine.EpochDays;
import net.time4j.engine.FormattableElement;
import net.time4j.engine.IntElementRule;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.TimeAxis;
import net.time4j.engine.UnitRule;
import net.time4j.engine.ValidationElement;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.CalendarType;
import net.time4j.format.Leniency;
import net.time4j.format.LocalizedPatternSupport;
import net.time4j.format.NumberSystem;
import net.time4j.format.OutputContext;
import net.time4j.format.TextElement;
import net.time4j.format.TextWidth;
import net.time4j.format.internal.DualFormatElement;
import net.time4j.format.internal.DualFormatHelper;

@CalendarType("japanese")
public final class JapaneseCalendar extends Calendrical<Unit, JapaneseCalendar> implements LocalizedPatternSupport {
    /* access modifiers changed from: private */
    public static final Transformer CALSYS;
    @FormattableElement(format = "d")
    public static final StdCalendarElement<Integer, JapaneseCalendar> DAY_OF_MONTH;
    private static final int DAY_OF_MONTH_INDEX = 2;
    @FormattableElement(format = "E")
    public static final StdCalendarElement<Weekday, JapaneseCalendar> DAY_OF_WEEK;
    @FormattableElement(format = "D")
    public static final StdCalendarElement<Integer, JapaneseCalendar> DAY_OF_YEAR;
    private static final int DAY_OF_YEAR_INDEX = 3;
    /* access modifiers changed from: private */
    public static final TimeAxis<Unit, JapaneseCalendar> ENGINE;
    private static final long EPOCH_1873 = -36158;
    @FormattableElement(format = "G")
    public static final TextElement<Nengo> ERA;
    private static final int KOKI_INDEX = 5;
    public static final ChronoElement<Integer> KOKI_YEAR;
    /* access modifiers changed from: private */
    public static final byte[] LEAP_INDICATORS;
    private static final int[] LUNISOLAR_MONTHS;
    public static final StdCalendarElement<Integer, JapaneseCalendar> MONTH_AS_ORDINAL;
    private static final int MONTH_AS_ORDINAL_INDEX = 1;
    @FormattableElement(alt = "L", format = "M")
    public static final TextElement<EastAsianMonth> MONTH_OF_YEAR;
    private static final int MRD = 1000000000;
    private static final int RELATED_GREGORIAN_YEAR_INDEX = 4;
    /* access modifiers changed from: private */
    public static final long[] START_OF_YEAR;
    @FormattableElement(format = "F")
    public static final OrdinalWeekdayElement<JapaneseCalendar> WEEKDAY_IN_MONTH;
    private static final WeekdayInMonthElement<JapaneseCalendar> WIM_ELEMENT;
    @FormattableElement(format = "y")
    public static final StdCalendarElement<Integer, JapaneseCalendar> YEAR_OF_ERA;
    private static final int YEAR_OF_NENGO_INDEX = 0;
    private static final long serialVersionUID = -153630575450868922L;
    /* access modifiers changed from: private */
    public final transient int dayOfMonth;
    /* access modifiers changed from: private */
    public final transient int dayOfYear;
    /* access modifiers changed from: private */
    public final transient EastAsianMonth month;
    /* access modifiers changed from: private */
    public final transient Nengo nengo;
    /* access modifiers changed from: private */
    public final transient int relgregyear;

    /* access modifiers changed from: protected */
    public JapaneseCalendar getContext() {
        return this;
    }

    static {
        Class<JapaneseCalendar> cls = JapaneseCalendar.class;
        InputStream load = ResourceLoader.getInstance().load(ResourceLoader.getInstance().locate("calendar", cls, "data/tsuchihashi.data"), true);
        if (load == null) {
            try {
                load = ResourceLoader.getInstance().load(cls, "data/tsuchihashi.data", true);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            } catch (Throwable th) {
                Throwable th2 = th;
                if (load != null) {
                    try {
                        load.close();
                    } catch (IOException e2) {
                        e2.printStackTrace(System.err);
                    }
                }
                throw th2;
            }
        }
        DataInputStream dataInputStream = new DataInputStream(load);
        long j = -464176;
        byte[] bArr = new byte[1172];
        int[] iArr = new int[1172];
        long[] jArr = new long[1172];
        int i = 0;
        for (int i2 = 1172; i < i2; i2 = 1172) {
            byte readByte = dataInputStream.readByte();
            int readShort = dataInputStream.readShort();
            bArr[i] = readByte;
            iArr[i] = readShort;
            jArr[i] = j;
            int i3 = 1;
            int i4 = 0;
            while (true) {
                if (i3 > (readByte == 0 ? 12 : 13)) {
                    break;
                }
                i4 += (readShort & 1) == 1 ? 30 : 29;
                readShort >>>= 1;
                i3++;
            }
            j += (long) i4;
            i++;
        }
        LEAP_INDICATORS = bArr;
        LUNISOLAR_MONTHS = iArr;
        START_OF_YEAR = jArr;
        if (load != null) {
            try {
                load.close();
            } catch (IOException e3) {
                e3.printStackTrace(System.err);
            }
        }
        Nengo.Element element = Nengo.Element.SINGLETON;
        ERA = element;
        YearOfNengoElement yearOfNengoElement = new YearOfNengoElement();
        YEAR_OF_ERA = yearOfNengoElement;
        StdIntegerDateElement stdIntegerDateElement = new StdIntegerDateElement("KOKI_YEAR", JapaneseCalendar.class, 1361, 1000000659, 0, (ChronoOperator) null, (ChronoOperator) null);
        KOKI_YEAR = stdIntegerDateElement;
        MonthPrimitiveElement monthPrimitiveElement = new MonthPrimitiveElement();
        MONTH_OF_YEAR = monthPrimitiveElement;
        StdIntegerDateElement stdIntegerDateElement2 = new StdIntegerDateElement("MONTH_AS_ORDINAL", JapaneseCalendar.class, 1, 12, 0, (ChronoOperator) null, (ChronoOperator) null);
        MONTH_AS_ORDINAL = stdIntegerDateElement2;
        StdIntegerDateElement stdIntegerDateElement3 = new StdIntegerDateElement("DAY_OF_MONTH", JapaneseCalendar.class, 1, 31, 'd');
        DAY_OF_MONTH = stdIntegerDateElement3;
        StdIntegerDateElement stdIntegerDateElement4 = new StdIntegerDateElement("DAY_OF_YEAR", JapaneseCalendar.class, 1, 365, 'D');
        DAY_OF_YEAR = stdIntegerDateElement4;
        StdWeekdayElement stdWeekdayElement = new StdWeekdayElement(cls, getDefaultWeekmodel());
        DAY_OF_WEEK = stdWeekdayElement;
        WeekdayInMonthElement<JapaneseCalendar> weekdayInMonthElement = new WeekdayInMonthElement<>(cls, stdIntegerDateElement3, stdWeekdayElement);
        WIM_ELEMENT = weekdayInMonthElement;
        WEEKDAY_IN_MONTH = weekdayInMonthElement;
        Transformer transformer = new Transformer();
        CALSYS = transformer;
        ENGINE = TimeAxis.Builder.setUp(Unit.class, cls, new Merger(), transformer).appendElement(element, new NengoRule(), Unit.ERAS).appendElement(yearOfNengoElement, new IntegerRule(0), Unit.YEARS).appendElement(monthPrimitiveElement, MonthPrimitiveElement.SINGLETON_JP, Unit.MONTHS).appendElement(stdIntegerDateElement2, new IntegerRule(1), Unit.MONTHS).appendElement(stdIntegerDateElement3, new IntegerRule(2), Unit.DAYS).appendElement(stdIntegerDateElement4, new IntegerRule(3), Unit.DAYS).appendElement(stdWeekdayElement, new WeekdayRule(getDefaultWeekmodel(), new ChronoFunction<JapaneseCalendar, CalendarSystem<JapaneseCalendar>>() {
            public CalendarSystem<JapaneseCalendar> apply(JapaneseCalendar japaneseCalendar) {
                return JapaneseCalendar.CALSYS;
            }
        }), Unit.DAYS).appendElement((ChronoElement) weekdayInMonthElement, (ElementRule) WeekdayInMonthElement.getRule(weekdayInMonthElement)).appendElement(stdIntegerDateElement, new IntegerRule(5), Unit.YEARS).appendElement((ChronoElement) CommonElements.RELATED_GREGORIAN_YEAR, (ElementRule) new IntegerRule(4)).appendUnit(Unit.ERAS, new JapaneseUnitRule(Unit.ERAS), Unit.ERAS.getLength()).appendUnit(Unit.YEARS, new JapaneseUnitRule(Unit.YEARS), Unit.YEARS.getLength()).appendUnit(Unit.MONTHS, new JapaneseUnitRule(Unit.MONTHS), Unit.MONTHS.getLength()).appendUnit(Unit.WEEKS, new JapaneseUnitRule(Unit.WEEKS), Unit.WEEKS.getLength(), Collections.singleton(Unit.DAYS)).appendUnit(Unit.DAYS, new JapaneseUnitRule(Unit.DAYS), Unit.DAYS.getLength(), Collections.singleton(Unit.WEEKS)).build();
    }

    private JapaneseCalendar(Nengo nengo2, int i, int i2) {
        this(nengo2, i, i2, getMonth(i, i2), getDayOfMonth(i, i2));
    }

    private JapaneseCalendar(Nengo nengo2, int i, int i2, EastAsianMonth eastAsianMonth, int i3) {
        this.nengo = nengo2;
        this.relgregyear = i;
        this.dayOfYear = i2;
        this.month = eastAsianMonth;
        this.dayOfMonth = i3;
    }

    public static JapaneseCalendar ofGregorian(Nengo nengo2, int i, int i2, int i3) {
        if (nengo2.isModern() && (nengo2 != Nengo.MEIJI || i >= 6)) {
            return of(nengo2, i, EastAsianMonth.valueOf(i2), i3, Leniency.SMART);
        }
        throw new IllegalArgumentException("Cannot create modern calendar with lunisolar calendar year.");
    }

    public static JapaneseCalendar of(Nengo nengo2, int i, EastAsianMonth eastAsianMonth, int i2) {
        return of(nengo2, i, eastAsianMonth, i2, Leniency.SMART);
    }

    public static JapaneseCalendar of(Nengo nengo2, int i, EastAsianMonth eastAsianMonth, int i2, Leniency leniency) {
        Nengo nengo3;
        if (i < 1) {
            throw new IllegalArgumentException("Year of nengo smaller than 1: " + i);
        } else if (i2 >= 1) {
            int firstRelatedGregorianYear = (nengo2.getFirstRelatedGregorianYear() + i) - 1;
            Nengo findNext = nengo2.findNext();
            if (findNext == null || findNext.getFirstRelatedGregorianYear() >= firstRelatedGregorianYear) {
                int i3 = 0;
                if (firstRelatedGregorianYear < 1873) {
                    int i4 = firstRelatedGregorianYear - 701;
                    int i5 = LUNISOLAR_MONTHS[i4];
                    int monthIndex = getMonthIndex(firstRelatedGregorianYear, eastAsianMonth);
                    if (!eastAsianMonth.isLeap() || monthIndex == LEAP_INDICATORS[i4]) {
                        for (int i6 = 1; i6 <= monthIndex; i6++) {
                            int i7 = (i5 & 1) == 1 ? 30 : 29;
                            if (i6 != monthIndex) {
                                i3 += i7;
                                i5 >>>= 1;
                            } else if (i2 <= i7) {
                                i3 += i2;
                            } else {
                                throw new IllegalArgumentException("Day of month out of range: " + i2);
                            }
                        }
                    } else {
                        throw new IllegalArgumentException("Invalid leap month: " + eastAsianMonth);
                    }
                } else if (eastAsianMonth.isLeap()) {
                    throw new IllegalArgumentException("Lunisolar leap month not valid in modern times: " + eastAsianMonth);
                } else if (i2 <= GregorianMath.getLengthOfMonth(firstRelatedGregorianYear, eastAsianMonth.getNumber())) {
                    int number = eastAsianMonth.getNumber();
                    for (int i8 = 1; i8 < number; i8++) {
                        i3 += GregorianMath.getLengthOfMonth(firstRelatedGregorianYear, i8);
                    }
                    i3 += i2;
                } else {
                    throw new IllegalArgumentException("Day of month out of range: " + i2);
                }
                int i9 = i3;
                if (firstRelatedGregorianYear != 1872 || eastAsianMonth.getNumber() != 12 || i2 < 3) {
                    long transform = transform(firstRelatedGregorianYear, i9);
                    CALSYS.check(transform);
                    Nengo findBestNengo = findBestNengo(nengo2.matches(Nengo.Selector.NORTHERN_COURT), firstRelatedGregorianYear, transform);
                    int i10 = AnonymousClass2.$SwitchMap$net$time4j$format$Leniency[leniency.ordinal()];
                    if (i10 != 1) {
                        if (i10 == 2) {
                            nengo3 = findBestNengo;
                            return new JapaneseCalendar(nengo3, firstRelatedGregorianYear, i9, eastAsianMonth, i2);
                        }
                    } else if (findBestNengo != nengo2) {
                        throw new IllegalArgumentException("Nengo should be: " + findBestNengo + ", but was: " + nengo2);
                    }
                    nengo3 = nengo2;
                    return new JapaneseCalendar(nengo3, firstRelatedGregorianYear, i9, eastAsianMonth, i2);
                } else if (!leniency.isStrict()) {
                    int i11 = i2 - 2;
                    return new JapaneseCalendar(Nengo.MEIJI, 1873, i11, EastAsianMonth.valueOf(1), i11);
                } else {
                    throw new IllegalArgumentException("Last month of lunisolar calendar had only 2 days.");
                }
            } else {
                throw new IllegalArgumentException("Year of nengo out of range: " + nengo2 + "/" + i);
            }
        } else {
            throw new IllegalArgumentException("Day of month smaller than 1: " + i2);
        }
    }

    public static JapaneseCalendar nowInSystemTime() {
        return (JapaneseCalendar) SystemClock.inLocalView().now(axis());
    }

    public Nengo getEra() {
        return this.nengo;
    }

    public int getYear() {
        return (this.relgregyear - this.nengo.getFirstRelatedGregorianYear()) + 1;
    }

    public EastAsianMonth getMonth() {
        return this.month;
    }

    public int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public Weekday getDayOfWeek() {
        return Weekday.valueOf(MathUtils.floorModulo(CALSYS.transform(this) + 5, 7) + 1);
    }

    public int getDayOfYear() {
        return this.dayOfYear;
    }

    public int lengthOfMonth() {
        return getLengthOfMonth(this.relgregyear, this.month);
    }

    public int lengthOfYear() {
        return getLengthOfYear(this.relgregyear);
    }

    public boolean isLeapYear() {
        int i = this.relgregyear;
        if (i >= 1873) {
            return GregorianMath.isLeapYear(i);
        }
        return LEAP_INDICATORS[i + -701] > 0;
    }

    public GeneralTimestamp<JapaneseCalendar> at(PlainTime plainTime) {
        return GeneralTimestamp.of(this, plainTime);
    }

    public GeneralTimestamp<JapaneseCalendar> atTime(int i, int i2) {
        return at(PlainTime.of(i, i2));
    }

    public int compareTo(JapaneseCalendar japaneseCalendar) {
        int compareTo = super.compareTo(japaneseCalendar);
        if (compareTo != 0) {
            return compareTo;
        }
        int value = this.nengo.getValue() - japaneseCalendar.nengo.getValue();
        if (value != 0) {
            return value;
        }
        boolean matches = this.nengo.matches(Nengo.Selector.NORTHERN_COURT);
        boolean matches2 = japaneseCalendar.nengo.matches(Nengo.Selector.NORTHERN_COURT);
        if (matches || !matches2) {
            return (!matches || matches2) ? 0 : 1;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JapaneseCalendar)) {
            return false;
        }
        JapaneseCalendar japaneseCalendar = (JapaneseCalendar) obj;
        if (this.relgregyear == japaneseCalendar.relgregyear && this.dayOfYear == japaneseCalendar.dayOfYear && this.nengo == japaneseCalendar.nengo && this.dayOfMonth == japaneseCalendar.dayOfMonth && this.month.equals(japaneseCalendar.month)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.relgregyear * 17) + (this.dayOfYear * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.nengo.getDisplayName(Locale.ROOT));
        sb.append(SignatureVisitor.SUPER);
        sb.append(getYear());
        sb.append('(');
        sb.append(this.relgregyear);
        sb.append(")-");
        if (this.month.isLeap()) {
            sb.append('*');
        }
        int number = this.month.getNumber();
        if (this.relgregyear >= 1873 && number < 10) {
            sb.append('0');
        }
        sb.append(number);
        sb.append(SignatureVisitor.SUPER);
        int dayOfMonth2 = getDayOfMonth();
        if (dayOfMonth2 < 10) {
            sb.append('0');
        }
        sb.append(dayOfMonth2);
        return sb.toString();
    }

    public static Weekmodel getDefaultWeekmodel() {
        return Weekmodel.of(Locale.JAPAN);
    }

    public static TimeAxis<Unit, JapaneseCalendar> axis() {
        return ENGINE;
    }

    /* access modifiers changed from: protected */
    public TimeAxis<Unit, JapaneseCalendar> getChronology() {
        return ENGINE;
    }

    /* access modifiers changed from: protected */
    public int compareByTime(CalendarDate calendarDate) {
        JapaneseCalendar japaneseCalendar;
        if (calendarDate instanceof JapaneseCalendar) {
            japaneseCalendar = JapaneseCalendar.class.cast(calendarDate);
        } else {
            japaneseCalendar = CALSYS.transform(calendarDate.getDaysSinceEpochUTC());
        }
        int i = this.relgregyear;
        int i2 = japaneseCalendar.relgregyear;
        if (i < i2) {
            return -1;
        }
        if (i > i2) {
            return 1;
        }
        int i3 = this.dayOfYear;
        int i4 = japaneseCalendar.dayOfYear;
        if (i3 < i4) {
            return -1;
        }
        if (i3 > i4) {
            return 1;
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public JapaneseCalendar tryWithNorthernCourt() {
        int i = this.relgregyear;
        if (i < 1332 || i >= 1394) {
            return this;
        }
        Nengo ofRelatedGregorianYear = Nengo.ofRelatedGregorianYear(i, Nengo.Selector.NORTHERN_COURT);
        while (ofRelatedGregorianYear.getStartAsDaysSinceEpochUTC() > getDaysSinceEpochUTC()) {
            ofRelatedGregorianYear = ofRelatedGregorianYear.findPrevious();
        }
        return new JapaneseCalendar(ofRelatedGregorianYear, this.relgregyear, this.dayOfYear, this.month, this.dayOfMonth);
    }

    /* access modifiers changed from: private */
    public static Nengo findBestNengo(boolean z, int i, long j) {
        Nengo nengo2;
        Nengo findPrevious;
        if (!z || i < 1332 || i >= 1394) {
            nengo2 = Nengo.ofRelatedGregorianYear(i, Nengo.Selector.OFFICIAL);
        } else {
            nengo2 = Nengo.ofRelatedGregorianYear(i, Nengo.Selector.NORTHERN_COURT);
        }
        while (nengo2.getStartAsDaysSinceEpochUTC() > j && (findPrevious = nengo2.findPrevious()) != null) {
            nengo2 = findPrevious;
        }
        return nengo2;
    }

    /* access modifiers changed from: private */
    public static EastAsianMonth getMonth(int i, int i2) {
        if (i2 >= 1) {
            int i3 = 12;
            int i4 = 0;
            if (i >= 1873) {
                for (int i5 = 1; i5 <= 12; i5++) {
                    i4 += GregorianMath.getLengthOfMonth(i, i5);
                    if (i4 >= i2) {
                        return EastAsianMonth.valueOf(i5);
                    }
                }
            } else {
                int i6 = i - 701;
                byte b = LEAP_INDICATORS[i6];
                int i7 = LUNISOLAR_MONTHS[i6];
                if (b != 0) {
                    i3 = 13;
                }
                int i8 = 1;
                while (i8 <= i3) {
                    i4 += (i7 & 1) == 1 ? 30 : 29;
                    i7 >>>= 1;
                    if (i4 >= i2) {
                        EastAsianMonth valueOf = EastAsianMonth.valueOf((b <= 0 || b > i8) ? i8 : i8 - 1);
                        return i8 == b ? valueOf.withLeap() : valueOf;
                    }
                    i8++;
                }
            }
        }
        throw new IllegalArgumentException("Day of year out of range: " + i2);
    }

    /* access modifiers changed from: private */
    public static int getLengthOfMonth(int i, EastAsianMonth eastAsianMonth) {
        if (i >= 1873) {
            return GregorianMath.getLengthOfMonth(i, eastAsianMonth.getNumber());
        }
        if (i == 1872 && eastAsianMonth.getNumber() == 12) {
            return 2;
        }
        int monthIndex = getMonthIndex(i, eastAsianMonth);
        int i2 = LUNISOLAR_MONTHS[i - 701];
        for (int i3 = 1; i3 <= monthIndex; i3++) {
            if (i3 == monthIndex) {
                return (i2 & 1) == 1 ? 30 : 29;
            }
            i2 >>>= 1;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    public static int getLengthOfYear(int i) {
        if (i >= 1873) {
            return GregorianMath.isLeapYear(i) ? 366 : 365;
        }
        if (i == 1872) {
            return (int) (EPOCH_1873 - START_OF_YEAR[1171]);
        }
        int i2 = i - 701;
        int i3 = LUNISOLAR_MONTHS[i2];
        int i4 = 0;
        int i5 = LEAP_INDICATORS[i2] == 0 ? 12 : 13;
        for (int i6 = 1; i6 <= i5; i6++) {
            i4 += (i3 & 1) == 1 ? 30 : 29;
            i3 >>>= 1;
        }
        return i4;
    }

    /* access modifiers changed from: private */
    public static int getMonthIndex(int i, EastAsianMonth eastAsianMonth) {
        int number = eastAsianMonth.getNumber();
        if (i >= 1873) {
            return number;
        }
        byte b = LEAP_INDICATORS[i - 701];
        return (eastAsianMonth.isLeap() || (b > 0 && number >= b)) ? number + 1 : number;
    }

    /* access modifiers changed from: private */
    public static int getDayOfMonth(int i, int i2) {
        EastAsianMonth month2 = getMonth(i, i2);
        if (i >= 1873) {
            int number = month2.getNumber();
            for (int i3 = 1; i3 < number; i3++) {
                i2 -= GregorianMath.getLengthOfMonth(i, i3);
            }
        } else {
            int monthIndex = getMonthIndex(i, month2);
            int i4 = LUNISOLAR_MONTHS[i - 701];
            for (int i5 = 1; i5 < monthIndex; i5++) {
                i2 -= (i4 & 1) == 1 ? 30 : 29;
                i4 >>>= 1;
            }
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public static int getArrayIndex(long j) {
        int length = START_OF_YEAR.length - 1;
        int i = 0;
        while (i <= length) {
            int i2 = (i + length) >> 1;
            if (START_OF_YEAR[i2] <= j) {
                i = i2 + 1;
            } else {
                length = i2 - 1;
            }
        }
        return i - 1;
    }

    static long transform(int i, int i2) {
        if (i >= 1873) {
            return PlainDate.of(i, i2).getDaysSinceEpochUTC();
        }
        return (START_OF_YEAR[i - 701] + ((long) i2)) - 1;
    }

    /* access modifiers changed from: private */
    public static JapaneseCalendar create(JapaneseCalendar japaneseCalendar, int i, EastAsianMonth eastAsianMonth, int i2) {
        Nengo ofRelatedGregorianYear = Nengo.ofRelatedGregorianYear(i);
        JapaneseCalendar of = of(ofRelatedGregorianYear, (i - ofRelatedGregorianYear.getFirstRelatedGregorianYear()) + 1, eastAsianMonth, i2, Leniency.SMART);
        return japaneseCalendar.nengo.matches(Nengo.Selector.NORTHERN_COURT) ? of.tryWithNorthernCourt() : of;
    }

    private Object writeReplace() {
        return new SPX(this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    public enum Unit implements ChronoUnit {
        ERAS(2.147483647E9d),
        YEARS(3.1556952E7d),
        MONTHS(2592000.0d),
        WEEKS(604800.0d),
        DAYS(86400.0d);
        
        private final transient double length;

        public boolean isCalendrical() {
            return true;
        }

        private Unit(double d) {
            this.length = d;
        }

        public double getLength() {
            return this.length;
        }

        public long between(JapaneseCalendar japaneseCalendar, JapaneseCalendar japaneseCalendar2) {
            return japaneseCalendar.until(japaneseCalendar2, this);
        }
    }

    private static class Transformer implements CalendarSystem<JapaneseCalendar> {
        public long getMaximumSinceUTC() {
            return 365241779741L;
        }

        private Transformer() {
        }

        public JapaneseCalendar transform(long j) {
            if (j >= JapaneseCalendar.EPOCH_1873) {
                PlainDate of = PlainDate.of(j, EpochDays.UTC);
                int year = of.getYear();
                return new JapaneseCalendar(JapaneseCalendar.findBestNengo(false, year, j), year, of.getDayOfYear(), EastAsianMonth.valueOf(of.getMonth()), of.getDayOfMonth());
            }
            int access$800 = JapaneseCalendar.getArrayIndex(j);
            if (access$800 >= 0) {
                int i = access$800 + TypedValues.TransitionType.TYPE_FROM;
                return new JapaneseCalendar(JapaneseCalendar.findBestNengo(false, i, j), i, (int) ((j - JapaneseCalendar.START_OF_YEAR[access$800]) + 1));
            }
            throw new IllegalArgumentException("Out of bounds: " + j);
        }

        public long transform(JapaneseCalendar japaneseCalendar) {
            return JapaneseCalendar.transform(japaneseCalendar.relgregyear, japaneseCalendar.dayOfYear);
        }

        public long getMinimumSinceUTC() {
            return JapaneseCalendar.START_OF_YEAR[0];
        }

        public List<CalendarEra> getEras() {
            return Nengo.list();
        }

        /* access modifiers changed from: package-private */
        public void check(long j) {
            if (j < getMinimumSinceUTC() || j > getMaximumSinceUTC()) {
                throw new IllegalArgumentException("Japanese calendar out of supported range.");
            }
        }
    }

    private static class JapaneseUnitRule implements UnitRule<JapaneseCalendar> {
        private final Unit unit;

        JapaneseUnitRule(Unit unit2) {
            this.unit = unit2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:60:0x00f5 A[Catch:{ IndexOutOfBoundsException -> 0x010a }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.calendar.JapaneseCalendar addTo(net.time4j.calendar.JapaneseCalendar r12, long r13) {
            /*
                r11 = this;
                int[] r0 = net.time4j.calendar.JapaneseCalendar.AnonymousClass2.$SwitchMap$net$time4j$calendar$JapaneseCalendar$Unit
                net.time4j.calendar.JapaneseCalendar$Unit r1 = r11.unit
                int r1 = r1.ordinal()
                r0 = r0[r1]
                r1 = 1
                if (r0 == r1) goto L_0x0160
                r2 = 2
                r3 = 1873(0x751, float:2.625E-42)
                if (r0 == r2) goto L_0x0111
                r2 = 3
                if (r0 == r2) goto L_0x0053
                r1 = 4
                if (r0 == r1) goto L_0x0028
                r1 = 5
                if (r0 != r1) goto L_0x001c
                goto L_0x002e
            L_0x001c:
                java.lang.UnsupportedOperationException r12 = new java.lang.UnsupportedOperationException
                net.time4j.calendar.JapaneseCalendar$Unit r13 = r11.unit
                java.lang.String r13 = r13.name()
                r12.<init>(r13)
                throw r12
            L_0x0028:
                r0 = 7
                long r13 = net.time4j.base.MathUtils.safeMultiply((long) r13, (long) r0)
            L_0x002e:
                net.time4j.calendar.JapaneseCalendar$Transformer r0 = net.time4j.calendar.JapaneseCalendar.CALSYS
                long r0 = r0.transform((net.time4j.calendar.JapaneseCalendar) r12)
                long r13 = net.time4j.base.MathUtils.safeAdd((long) r0, (long) r13)
                net.time4j.calendar.JapaneseCalendar$Transformer r0 = net.time4j.calendar.JapaneseCalendar.CALSYS
                net.time4j.calendar.JapaneseCalendar r13 = r0.transform((long) r13)
                net.time4j.calendar.Nengo r12 = r12.nengo
                net.time4j.calendar.Nengo$Selector r14 = net.time4j.calendar.Nengo.Selector.NORTHERN_COURT
                boolean r12 = r12.matches(r14)
                if (r12 == 0) goto L_0x0052
                net.time4j.calendar.JapaneseCalendar r13 = r13.tryWithNorthernCourt()
            L_0x0052:
                return r13
            L_0x0053:
                checkAmountOfMonths(r13)     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                int r0 = r12.relgregyear     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                net.time4j.calendar.EastAsianMonth r2 = r12.month     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                int r2 = net.time4j.calendar.JapaneseCalendar.getMonthIndex(r0, r2)     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                r4 = 0
                int r6 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
                if (r6 <= 0) goto L_0x006a
                r6 = 1
                goto L_0x006b
            L_0x006a:
                r6 = -1
            L_0x006b:
                int r7 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
                if (r7 == 0) goto L_0x00b3
                int r2 = r2 + r6
                r7 = 12
                r8 = 13
                if (r0 < r3) goto L_0x0091
                if (r2 != 0) goto L_0x008b
                int r0 = r0 + -1
                if (r0 >= r3) goto L_0x0089
                byte[] r2 = net.time4j.calendar.JapaneseCalendar.LEAP_INDICATORS     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                int r9 = r0 + -701
                byte r2 = r2[r9]     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                if (r2 != 0) goto L_0x0087
                goto L_0x0089
            L_0x0087:
                r7 = 13
            L_0x0089:
                r2 = r7
                goto L_0x00b0
            L_0x008b:
                if (r2 != r8) goto L_0x00b0
            L_0x008d:
                int r0 = r0 + 1
                r2 = 1
                goto L_0x00b0
            L_0x0091:
                if (r2 != 0) goto L_0x00a0
                int r0 = r0 + -1
                byte[] r2 = net.time4j.calendar.JapaneseCalendar.LEAP_INDICATORS     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                int r9 = r0 + -701
                byte r2 = r2[r9]     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                if (r2 != 0) goto L_0x0087
                goto L_0x0089
            L_0x00a0:
                byte[] r9 = net.time4j.calendar.JapaneseCalendar.LEAP_INDICATORS     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                int r10 = r0 + -701
                byte r9 = r9[r10]     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                if (r9 != 0) goto L_0x00ab
                goto L_0x00ad
            L_0x00ab:
                r7 = 13
            L_0x00ad:
                if (r2 <= r7) goto L_0x00b0
                goto L_0x008d
            L_0x00b0:
                long r7 = (long) r6     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                long r13 = r13 - r7
                goto L_0x006b
            L_0x00b3:
                if (r0 < r3) goto L_0x00d8
                net.time4j.calendar.Nengo$Selector r13 = net.time4j.calendar.Nengo.Selector.MODERN     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                net.time4j.calendar.Nengo r13 = net.time4j.calendar.Nengo.ofRelatedGregorianYear(r0, r13)     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                net.time4j.calendar.EastAsianMonth r14 = net.time4j.calendar.EastAsianMonth.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                int r12 = r12.dayOfMonth     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                int r2 = net.time4j.calendar.JapaneseCalendar.getLengthOfMonth(r0, r14)     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                int r12 = java.lang.Math.min(r12, r2)     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                int r2 = r13.getFirstRelatedGregorianYear()     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                int r0 = r0 - r2
                int r0 = r0 + r1
                net.time4j.format.Leniency r1 = net.time4j.format.Leniency.SMART     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                net.time4j.calendar.JapaneseCalendar r12 = net.time4j.calendar.JapaneseCalendar.of(r13, r0, r14, r12, r1)     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                return r12
            L_0x00d8:
                r13 = 0
                byte[] r14 = net.time4j.calendar.JapaneseCalendar.LEAP_INDICATORS     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                int r3 = r0 + -701
                byte r14 = r14[r3]     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                if (r14 <= 0) goto L_0x00ee
                if (r14 > r2) goto L_0x00e8
                int r3 = r2 + -1
                goto L_0x00e9
            L_0x00e8:
                r3 = r2
            L_0x00e9:
                if (r14 != r2) goto L_0x00ed
                r2 = r3
                goto L_0x00ef
            L_0x00ed:
                r2 = r3
            L_0x00ee:
                r1 = 0
            L_0x00ef:
                net.time4j.calendar.EastAsianMonth r13 = net.time4j.calendar.EastAsianMonth.valueOf(r2)     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                if (r1 == 0) goto L_0x00f9
                net.time4j.calendar.EastAsianMonth r13 = r13.withLeap()     // Catch:{ IndexOutOfBoundsException -> 0x010a }
            L_0x00f9:
                int r14 = r12.dayOfMonth     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                int r1 = net.time4j.calendar.JapaneseCalendar.getLengthOfMonth(r0, r13)     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                int r14 = java.lang.Math.min(r14, r1)     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                net.time4j.calendar.JapaneseCalendar r12 = net.time4j.calendar.JapaneseCalendar.create(r12, r0, r13, r14)     // Catch:{ IndexOutOfBoundsException -> 0x010a }
                return r12
            L_0x010a:
                r12 = move-exception
                java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
                r13.<init>(r12)
                throw r13
            L_0x0111:
                int r0 = r12.relgregyear     // Catch:{ IndexOutOfBoundsException -> 0x0159 }
                int r13 = net.time4j.base.MathUtils.safeCast(r13)     // Catch:{ IndexOutOfBoundsException -> 0x0159 }
                int r13 = net.time4j.base.MathUtils.safeAdd((int) r0, (int) r13)     // Catch:{ IndexOutOfBoundsException -> 0x0159 }
                net.time4j.calendar.EastAsianMonth r14 = r12.month     // Catch:{ IndexOutOfBoundsException -> 0x0159 }
                int r0 = r14.getNumber()     // Catch:{ IndexOutOfBoundsException -> 0x0159 }
                if (r13 < r3) goto L_0x0132
                boolean r1 = r14.isLeap()     // Catch:{ IndexOutOfBoundsException -> 0x0159 }
                if (r1 == 0) goto L_0x0148
                net.time4j.calendar.EastAsianMonth r14 = net.time4j.calendar.EastAsianMonth.valueOf(r0)     // Catch:{ IndexOutOfBoundsException -> 0x0159 }
                goto L_0x0148
            L_0x0132:
                boolean r1 = r14.isLeap()     // Catch:{ IndexOutOfBoundsException -> 0x0159 }
                if (r1 == 0) goto L_0x0148
                byte[] r1 = net.time4j.calendar.JapaneseCalendar.LEAP_INDICATORS     // Catch:{ IndexOutOfBoundsException -> 0x0159 }
                int r2 = r13 + -701
                byte r1 = r1[r2]     // Catch:{ IndexOutOfBoundsException -> 0x0159 }
                int r2 = r0 + 1
                if (r1 == r2) goto L_0x0148
                net.time4j.calendar.EastAsianMonth r14 = net.time4j.calendar.EastAsianMonth.valueOf(r0)     // Catch:{ IndexOutOfBoundsException -> 0x0159 }
            L_0x0148:
                int r0 = r12.dayOfMonth     // Catch:{ IndexOutOfBoundsException -> 0x0159 }
                int r1 = net.time4j.calendar.JapaneseCalendar.getLengthOfMonth(r13, r14)     // Catch:{ IndexOutOfBoundsException -> 0x0159 }
                int r0 = java.lang.Math.min(r0, r1)     // Catch:{ IndexOutOfBoundsException -> 0x0159 }
                net.time4j.calendar.JapaneseCalendar r12 = net.time4j.calendar.JapaneseCalendar.create(r12, r13, r14, r0)     // Catch:{ IndexOutOfBoundsException -> 0x0159 }
                return r12
            L_0x0159:
                r12 = move-exception
                java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
                r13.<init>(r12)
                throw r13
            L_0x0160:
                net.time4j.calendar.JapaneseCalendar r12 = erasAdded(r12, r13)     // Catch:{ IndexOutOfBoundsException -> 0x0165 }
                return r12
            L_0x0165:
                r12 = move-exception
                java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
                r13.<init>(r12)
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.JapaneseCalendar.JapaneseUnitRule.addTo(net.time4j.calendar.JapaneseCalendar, long):net.time4j.calendar.JapaneseCalendar");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a1, code lost:
            if (net.time4j.calendar.JapaneseCalendar.access$1400()[r3 - 701] != 0) goto L_0x00b9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b6, code lost:
            if (net.time4j.calendar.JapaneseCalendar.access$1400()[r3 - 701] == 0) goto L_0x00bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b9, code lost:
            r8 = 13;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long between(net.time4j.calendar.JapaneseCalendar r12, net.time4j.calendar.JapaneseCalendar r13) {
            /*
                r11 = this;
                int[] r0 = net.time4j.calendar.JapaneseCalendar.AnonymousClass2.$SwitchMap$net$time4j$calendar$JapaneseCalendar$Unit
                net.time4j.calendar.JapaneseCalendar$Unit r1 = r11.unit
                int r1 = r1.ordinal()
                r0 = r0[r1]
                r1 = 1
                if (r0 == r1) goto L_0x0120
                r2 = 2
                if (r0 == r2) goto L_0x00d3
                r2 = 3
                if (r0 == r2) goto L_0x0041
                r1 = 4
                if (r0 == r1) goto L_0x0037
                r1 = 5
                if (r0 != r1) goto L_0x002b
                net.time4j.calendar.JapaneseCalendar$Transformer r0 = net.time4j.calendar.JapaneseCalendar.CALSYS
                long r0 = r0.transform((net.time4j.calendar.JapaneseCalendar) r13)
                net.time4j.calendar.JapaneseCalendar$Transformer r13 = net.time4j.calendar.JapaneseCalendar.CALSYS
                long r12 = r13.transform((net.time4j.calendar.JapaneseCalendar) r12)
                long r0 = r0 - r12
                return r0
            L_0x002b:
                java.lang.UnsupportedOperationException r12 = new java.lang.UnsupportedOperationException
                net.time4j.calendar.JapaneseCalendar$Unit r13 = r11.unit
                java.lang.String r13 = r13.name()
                r12.<init>(r13)
                throw r12
            L_0x0037:
                net.time4j.calendar.JapaneseCalendar$Unit r0 = net.time4j.calendar.JapaneseCalendar.Unit.DAYS
                long r12 = r0.between(r12, r13)
                r0 = 7
                long r12 = r12 / r0
                return r12
            L_0x0041:
                int r0 = r13.relgregyear
                int r2 = r13.relgregyear
                net.time4j.calendar.EastAsianMonth r3 = r13.month
                int r2 = net.time4j.calendar.JapaneseCalendar.getMonthIndex(r2, r3)
                int r3 = r12.relgregyear
                int r4 = r12.relgregyear
                net.time4j.calendar.EastAsianMonth r5 = r12.month
                int r4 = net.time4j.calendar.JapaneseCalendar.getMonthIndex(r4, r5)
                int r5 = r13.compareByTime(r12)
                r6 = 0
            L_0x0066:
                if (r3 != r0) goto L_0x008a
                if (r4 == r2) goto L_0x006b
                goto L_0x008a
            L_0x006b:
                if (r6 <= 0) goto L_0x007a
                int r0 = r12.dayOfMonth
                int r1 = r13.dayOfMonth
                if (r0 <= r1) goto L_0x007a
                int r6 = r6 + -1
                goto L_0x0088
            L_0x007a:
                if (r6 >= 0) goto L_0x0088
                int r12 = r12.dayOfMonth
                int r13 = r13.dayOfMonth
                if (r12 >= r13) goto L_0x0088
                int r6 = r6 + 1
            L_0x0088:
                long r12 = (long) r6
                return r12
            L_0x008a:
                int r4 = r4 + r5
                r7 = 1873(0x751, float:2.625E-42)
                r8 = 12
                r9 = 13
                if (r3 < r7) goto L_0x00aa
                if (r4 != 0) goto L_0x00a4
                int r3 = r3 + -1
                if (r3 >= r7) goto L_0x00bb
                byte[] r4 = net.time4j.calendar.JapaneseCalendar.LEAP_INDICATORS
                int r7 = r3 + -701
                byte r4 = r4[r7]
                if (r4 != 0) goto L_0x00b9
                goto L_0x00bb
            L_0x00a4:
                if (r4 != r9) goto L_0x00cd
            L_0x00a6:
                int r3 = r3 + 1
                r4 = 1
                goto L_0x00cd
            L_0x00aa:
                if (r4 != 0) goto L_0x00bd
                int r3 = r3 + -1
                byte[] r4 = net.time4j.calendar.JapaneseCalendar.LEAP_INDICATORS
                int r7 = r3 + -701
                byte r4 = r4[r7]
                if (r4 != 0) goto L_0x00b9
                goto L_0x00bb
            L_0x00b9:
                r8 = 13
            L_0x00bb:
                r4 = r8
                goto L_0x00cd
            L_0x00bd:
                byte[] r7 = net.time4j.calendar.JapaneseCalendar.LEAP_INDICATORS
                int r10 = r3 + -701
                byte r7 = r7[r10]
                if (r7 != 0) goto L_0x00c8
                goto L_0x00ca
            L_0x00c8:
                r8 = 13
            L_0x00ca:
                if (r4 <= r8) goto L_0x00cd
                goto L_0x00a6
            L_0x00cd:
                int r6 = r6 + r5
                long r7 = (long) r6
                checkAmountOfMonths(r7)
                goto L_0x0066
            L_0x00d3:
                int r0 = r13.relgregyear
                int r1 = r12.relgregyear
                int r0 = r0 - r1
                if (r0 != 0) goto L_0x00e1
                r12 = 0
                return r12
            L_0x00e1:
                int r1 = r13.relgregyear
                net.time4j.calendar.EastAsianMonth r2 = r13.month
                int r1 = net.time4j.calendar.JapaneseCalendar.getMonthIndex(r1, r2)
                int r2 = r12.relgregyear
                net.time4j.calendar.EastAsianMonth r3 = r12.month
                int r2 = net.time4j.calendar.JapaneseCalendar.getMonthIndex(r2, r3)
                if (r0 <= 0) goto L_0x010c
                if (r2 > r1) goto L_0x0109
                if (r2 != r1) goto L_0x011e
                int r12 = r12.dayOfMonth
                int r13 = r13.dayOfMonth
                if (r12 <= r13) goto L_0x011e
            L_0x0109:
                int r0 = r0 + -1
                goto L_0x011e
            L_0x010c:
                if (r0 >= 0) goto L_0x011e
                if (r2 < r1) goto L_0x011c
                if (r2 != r1) goto L_0x011e
                int r12 = r12.dayOfMonth
                int r13 = r13.dayOfMonth
                if (r12 >= r13) goto L_0x011e
            L_0x011c:
                int r0 = r0 + 1
            L_0x011e:
                long r12 = (long) r0
                return r12
            L_0x0120:
                int r12 = erasBetween(r12, r13)
                long r12 = (long) r12
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.JapaneseCalendar.JapaneseUnitRule.between(net.time4j.calendar.JapaneseCalendar, net.time4j.calendar.JapaneseCalendar):long");
        }

        private static JapaneseCalendar erasAdded(JapaneseCalendar japaneseCalendar, long j) {
            int firstRelatedGregorianYear;
            Nengo access$1900 = japaneseCalendar.nengo;
            int year = japaneseCalendar.getYear();
            EastAsianMonth access$1300 = japaneseCalendar.month;
            int access$1500 = japaneseCalendar.dayOfMonth;
            if (access$1900.matches(Nengo.Selector.NORTHERN_COURT)) {
                access$1900 = Nengo.ofRelatedGregorianYear(japaneseCalendar.relgregyear);
                year = (japaneseCalendar.relgregyear - access$1900.getFirstRelatedGregorianYear()) + 1;
            }
            Nengo ofIndexOfficial = Nengo.ofIndexOfficial(MathUtils.safeAdd(access$1900.getIndexOfficial(), MathUtils.safeCast(j)));
            Nengo findNext = ofIndexOfficial.findNext();
            if (findNext != null && year > (firstRelatedGregorianYear = (findNext.getFirstRelatedGregorianYear() - ofIndexOfficial.getFirstRelatedGregorianYear()) + 1)) {
                year = firstRelatedGregorianYear;
            }
            int firstRelatedGregorianYear2 = (year - 1) + ofIndexOfficial.getFirstRelatedGregorianYear();
            if (firstRelatedGregorianYear2 >= 1873) {
                if (access$1300.isLeap()) {
                    access$1300 = EastAsianMonth.valueOf(access$1300.getNumber());
                }
            } else if (access$1300.isLeap() && JapaneseCalendar.LEAP_INDICATORS[firstRelatedGregorianYear2 - 701] == 0) {
                access$1300 = EastAsianMonth.valueOf(access$1300.getNumber());
            }
            int access$1600 = JapaneseCalendar.getLengthOfMonth(firstRelatedGregorianYear2, access$1300);
            if (access$1500 > access$1600) {
                access$1500 = access$1600;
            }
            return JapaneseCalendar.of(ofIndexOfficial, year, access$1300, access$1500);
        }

        private static int erasBetween(JapaneseCalendar japaneseCalendar, JapaneseCalendar japaneseCalendar2) {
            Nengo access$1900 = japaneseCalendar.nengo;
            int year = japaneseCalendar.getYear();
            int access$1800 = JapaneseCalendar.getMonthIndex(japaneseCalendar.relgregyear, japaneseCalendar.month);
            int access$1500 = japaneseCalendar.dayOfMonth;
            if (access$1900.matches(Nengo.Selector.NORTHERN_COURT)) {
                access$1900 = Nengo.ofRelatedGregorianYear(japaneseCalendar.relgregyear);
                year = (japaneseCalendar.relgregyear - access$1900.getFirstRelatedGregorianYear()) + 1;
            }
            Nengo access$19002 = japaneseCalendar2.nengo;
            int year2 = japaneseCalendar2.getYear();
            int access$18002 = JapaneseCalendar.getMonthIndex(japaneseCalendar2.relgregyear, japaneseCalendar2.month);
            int access$15002 = japaneseCalendar2.dayOfMonth;
            if (access$19002.matches(Nengo.Selector.NORTHERN_COURT)) {
                access$19002 = Nengo.ofRelatedGregorianYear(japaneseCalendar2.relgregyear);
                year2 = (japaneseCalendar2.relgregyear - access$19002.getFirstRelatedGregorianYear()) + 1;
            }
            int indexOfficial = access$19002.getIndexOfficial() - access$1900.getIndexOfficial();
            if (indexOfficial > 0) {
                if (year <= year2) {
                    if (year != year2) {
                        return indexOfficial;
                    }
                    if (access$1800 <= access$18002 && (access$1800 != access$18002 || access$1500 <= access$15002)) {
                        return indexOfficial;
                    }
                }
                return indexOfficial - 1;
            } else if (indexOfficial >= 0) {
                return indexOfficial;
            } else {
                if (year >= year2) {
                    if (year != year2) {
                        return indexOfficial;
                    }
                    if (access$1800 >= access$18002 && (access$1800 != access$18002 || access$1500 >= access$15002)) {
                        return indexOfficial;
                    }
                }
                return indexOfficial + 1;
            }
        }

        private static void checkAmountOfMonths(long j) {
            if (Math.abs(j) >= 25000) {
                throw new ArithmeticException("Month arithmetic limited to delta smaller than 25000.");
            }
        }
    }

    /* renamed from: net.time4j.calendar.JapaneseCalendar$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$calendar$JapaneseCalendar$Unit;
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$Leniency;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|15|16|17|18|20) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|5|6|7|8|9|10|11|12|13|15|16|17|18|20) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0028 */
        static {
            /*
                net.time4j.calendar.JapaneseCalendar$Unit[] r0 = net.time4j.calendar.JapaneseCalendar.Unit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$calendar$JapaneseCalendar$Unit = r0
                r1 = 1
                net.time4j.calendar.JapaneseCalendar$Unit r2 = net.time4j.calendar.JapaneseCalendar.Unit.ERAS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$net$time4j$calendar$JapaneseCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.calendar.JapaneseCalendar$Unit r3 = net.time4j.calendar.JapaneseCalendar.Unit.YEARS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r2 = $SwitchMap$net$time4j$calendar$JapaneseCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.calendar.JapaneseCalendar$Unit r3 = net.time4j.calendar.JapaneseCalendar.Unit.MONTHS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r4 = 3
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r2 = $SwitchMap$net$time4j$calendar$JapaneseCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.calendar.JapaneseCalendar$Unit r3 = net.time4j.calendar.JapaneseCalendar.Unit.WEEKS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4 = 4
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r2 = $SwitchMap$net$time4j$calendar$JapaneseCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x003e }
                net.time4j.calendar.JapaneseCalendar$Unit r3 = net.time4j.calendar.JapaneseCalendar.Unit.DAYS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r4 = 5
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                net.time4j.format.Leniency[] r2 = net.time4j.format.Leniency.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$net$time4j$format$Leniency = r2
                net.time4j.format.Leniency r3 = net.time4j.format.Leniency.STRICT     // Catch:{ NoSuchFieldError -> 0x004f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r1 = $SwitchMap$net$time4j$format$Leniency     // Catch:{ NoSuchFieldError -> 0x0059 }
                net.time4j.format.Leniency r2 = net.time4j.format.Leniency.SMART     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.JapaneseCalendar.AnonymousClass2.<clinit>():void");
        }
    }

    private static class NengoRule implements ElementRule<JapaneseCalendar, Nengo> {
        public boolean isValid(JapaneseCalendar japaneseCalendar, Nengo nengo) {
            return nengo != null;
        }

        private NengoRule() {
        }

        public Nengo getValue(JapaneseCalendar japaneseCalendar) {
            return japaneseCalendar.nengo;
        }

        public Nengo getMinimum(JapaneseCalendar japaneseCalendar) {
            return JapaneseCalendar.ERA.getDefaultMinimum();
        }

        public Nengo getMaximum(JapaneseCalendar japaneseCalendar) {
            return JapaneseCalendar.ERA.getDefaultMaximum();
        }

        public JapaneseCalendar withValue(JapaneseCalendar japaneseCalendar, Nengo nengo, boolean z) {
            int firstRelatedGregorianYear;
            int year = japaneseCalendar.getYear();
            EastAsianMonth access$1300 = japaneseCalendar.month;
            int access$1500 = japaneseCalendar.dayOfMonth;
            Nengo findNext = nengo.findNext();
            if (findNext != null && year > (firstRelatedGregorianYear = (findNext.getFirstRelatedGregorianYear() - nengo.getFirstRelatedGregorianYear()) + 1)) {
                year = firstRelatedGregorianYear;
            }
            int firstRelatedGregorianYear2 = (year - 1) + nengo.getFirstRelatedGregorianYear();
            if (firstRelatedGregorianYear2 >= 1873) {
                if (access$1300.isLeap()) {
                    access$1300 = EastAsianMonth.valueOf(access$1300.getNumber());
                }
            } else if (access$1300.isLeap() && JapaneseCalendar.LEAP_INDICATORS[firstRelatedGregorianYear2 - 701] == 0) {
                access$1300 = EastAsianMonth.valueOf(access$1300.getNumber());
            }
            int access$1600 = JapaneseCalendar.getLengthOfMonth(firstRelatedGregorianYear2, access$1300);
            if (access$1500 > access$1600) {
                access$1500 = access$1600;
            }
            return JapaneseCalendar.of(nengo, year, access$1300, access$1500, z ? Leniency.LAX : Leniency.SMART);
        }

        public ChronoElement<?> getChildAtFloor(JapaneseCalendar japaneseCalendar) {
            return JapaneseCalendar.YEAR_OF_ERA;
        }

        public ChronoElement<?> getChildAtCeiling(JapaneseCalendar japaneseCalendar) {
            return JapaneseCalendar.YEAR_OF_ERA;
        }
    }

    private static class IntegerRule implements IntElementRule<JapaneseCalendar> {
        private final int index;

        IntegerRule(int i) {
            this.index = i;
        }

        public int getInt(JapaneseCalendar japaneseCalendar) {
            int i = this.index;
            if (i == 0) {
                return japaneseCalendar.getYear();
            }
            if (i == 1) {
                return JapaneseCalendar.getMonthIndex(japaneseCalendar.relgregyear, japaneseCalendar.month);
            }
            if (i == 2) {
                return japaneseCalendar.dayOfMonth;
            }
            if (i == 3) {
                return japaneseCalendar.dayOfYear;
            }
            if (i == 4) {
                return japaneseCalendar.relgregyear;
            }
            if (i == 5) {
                return japaneseCalendar.relgregyear + 660;
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        /* access modifiers changed from: package-private */
        public int getMin() {
            int i = this.index;
            if (i == 0 || i == 1 || i == 2 || i == 3) {
                return 1;
            }
            if (i == 4) {
                return TypedValues.TransitionType.TYPE_FROM;
            }
            if (i == 5) {
                return 1361;
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        /* access modifiers changed from: package-private */
        public int getMax(JapaneseCalendar japaneseCalendar) {
            int i = this.index;
            if (i == 0) {
                Nengo access$1900 = japaneseCalendar.nengo;
                Nengo findNext = access$1900.findNext();
                if (findNext != null) {
                    return (findNext.getFirstRelatedGregorianYear() - access$1900.getFirstRelatedGregorianYear()) + 1;
                }
                return JapaneseCalendar.MRD - Nengo.Element.SINGLETON.getDefaultMaximum().getFirstRelatedGregorianYear();
            } else if (i == 1) {
                return (japaneseCalendar.relgregyear >= 1873 || JapaneseCalendar.LEAP_INDICATORS[japaneseCalendar.relgregyear + -701] == 0) ? 12 : 13;
            } else {
                if (i == 2) {
                    return JapaneseCalendar.getLengthOfMonth(japaneseCalendar.relgregyear, japaneseCalendar.month);
                }
                if (i == 3) {
                    return JapaneseCalendar.getLengthOfYear(japaneseCalendar.relgregyear);
                }
                if (i == 4) {
                    return 999999999;
                }
                if (i == 5) {
                    return 1000000659;
                }
                throw new UnsupportedOperationException("Unknown element index: " + this.index);
            }
        }

        public boolean isValid(JapaneseCalendar japaneseCalendar, int i) {
            int i2 = this.index;
            if (!(i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3)) {
                if (i2 != 4) {
                    if (i2 != 5) {
                        throw new UnsupportedOperationException("Unknown element index: " + this.index);
                    }
                } else if (japaneseCalendar.relgregyear == i) {
                    return true;
                } else {
                    return false;
                }
            }
            if (i < 1 || i > getMax(japaneseCalendar)) {
                return false;
            }
            return true;
        }

        public JapaneseCalendar withValue(JapaneseCalendar japaneseCalendar, int i, boolean z) {
            EastAsianMonth eastAsianMonth;
            if (isValid(japaneseCalendar, i)) {
                int i2 = this.index;
                if (i2 == 0) {
                    return yearsAdded(japaneseCalendar, (japaneseCalendar.nengo.getFirstRelatedGregorianYear() + i) - 1);
                }
                if (i2 == 1) {
                    if (japaneseCalendar.relgregyear >= 1873) {
                        eastAsianMonth = EastAsianMonth.valueOf(i);
                    } else {
                        byte b = JapaneseCalendar.LEAP_INDICATORS[japaneseCalendar.relgregyear - 701];
                        if (b == 0 || b > i) {
                            eastAsianMonth = EastAsianMonth.valueOf(i);
                        } else if (i == b) {
                            eastAsianMonth = EastAsianMonth.valueOf(i - 1).withLeap();
                        } else {
                            eastAsianMonth = EastAsianMonth.valueOf(i - 1);
                        }
                    }
                    return (JapaneseCalendar) japaneseCalendar.with(JapaneseCalendar.MONTH_OF_YEAR, eastAsianMonth);
                } else if (i2 == 2) {
                    return JapaneseCalendar.create(japaneseCalendar, japaneseCalendar.relgregyear, japaneseCalendar.month, i);
                } else {
                    if (i2 == 3) {
                        return new JapaneseCalendar(japaneseCalendar.nengo, japaneseCalendar.relgregyear, i);
                    }
                    if (i2 == 4) {
                        return japaneseCalendar;
                    }
                    if (i2 == 5) {
                        return yearsAdded(japaneseCalendar, i - 660);
                    }
                    throw new UnsupportedOperationException("Unknown element index: " + this.index);
                }
            } else if (this.index == 4) {
                throw new IllegalArgumentException("The related gregorian year is read-only.");
            } else {
                throw new IllegalArgumentException("Out of range: " + i);
            }
        }

        public Integer getValue(JapaneseCalendar japaneseCalendar) {
            return Integer.valueOf(getInt(japaneseCalendar));
        }

        public Integer getMinimum(JapaneseCalendar japaneseCalendar) {
            return Integer.valueOf(getMin());
        }

        public Integer getMaximum(JapaneseCalendar japaneseCalendar) {
            return Integer.valueOf(getMax(japaneseCalendar));
        }

        public boolean isValid(JapaneseCalendar japaneseCalendar, Integer num) {
            return num != null && isValid(japaneseCalendar, num.intValue());
        }

        public JapaneseCalendar withValue(JapaneseCalendar japaneseCalendar, Integer num, boolean z) {
            if (num != null) {
                return withValue(japaneseCalendar, num.intValue(), z);
            }
            throw new IllegalArgumentException("Not nullable.");
        }

        public ChronoElement<?> getChildAtFloor(JapaneseCalendar japaneseCalendar) {
            int i = this.index;
            if (i == 0) {
                return JapaneseCalendar.MONTH_OF_YEAR;
            }
            if (i == 1) {
                return JapaneseCalendar.DAY_OF_MONTH;
            }
            if (i == 2 || i == 3 || i == 4 || i == 5) {
                return null;
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public ChronoElement<?> getChildAtCeiling(JapaneseCalendar japaneseCalendar) {
            return getChildAtFloor(japaneseCalendar);
        }

        private static JapaneseCalendar yearsAdded(JapaneseCalendar japaneseCalendar, int i) {
            EastAsianMonth access$1300 = japaneseCalendar.month;
            int number = access$1300.getNumber();
            if (i >= 1873) {
                if (access$1300.isLeap()) {
                    access$1300 = EastAsianMonth.valueOf(access$1300.getNumber());
                }
            } else if (access$1300.isLeap() && JapaneseCalendar.LEAP_INDICATORS[i - 701] != number + 1) {
                access$1300 = EastAsianMonth.valueOf(access$1300.getNumber());
            }
            return JapaneseCalendar.create(japaneseCalendar, i, access$1300, Math.min(japaneseCalendar.dayOfMonth, JapaneseCalendar.getLengthOfMonth(i, access$1300)));
        }
    }

    private static class YearOfNengoElement extends StdIntegerDateElement<JapaneseCalendar> implements DualFormatElement {
        private static final long serialVersionUID = -8502388572788955989L;

        private YearOfNengoElement() {
            super("YEAR_OF_ERA", JapaneseCalendar.class, 1, JapaneseCalendar.MRD - Nengo.Element.SINGLETON.getDefaultMaximum().getFirstRelatedGregorianYear(), 'y', (ChronoOperator) null, (ChronoOperator) null);
        }

        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
            char c;
            char charAt;
            NumberSystem numberSystem = (NumberSystem) attributeQuery.get(Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC);
            if (attributeQuery.contains(Attributes.ZERO_DIGIT)) {
                charAt = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT)).charValue();
            } else if (numberSystem.isDecimal()) {
                charAt = numberSystem.getDigits().charAt(0);
            } else {
                c = '0';
                print(chronoDisplay, appendable, attributeQuery, numberSystem, c, 1, 9);
            }
            c = charAt;
            print(chronoDisplay, appendable, attributeQuery, numberSystem, c, 1, 9);
        }

        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, NumberSystem numberSystem, char c, int i, int i2) throws IOException, ChronoException {
            int i3 = chronoDisplay.getInt(this);
            if (i3 == 1 && numberSystem == NumberSystem.ARABIC && ((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT)).getLanguage().equals("ja")) {
                appendable.append(20803);
                return;
            }
            String numeral = numberSystem.toNumeral(i3);
            if (numberSystem.isDecimal()) {
                int length = i - numeral.length();
                for (int i4 = 0; i4 < length; i4++) {
                    appendable.append(c);
                }
            }
            appendable.append(numeral);
        }

        public Integer parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
            char c;
            int i;
            NumberSystem numberSystem = (NumberSystem) attributeQuery.get(Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC);
            int index = parsePosition.getIndex();
            if (numberSystem == NumberSystem.ARABIC && charSequence.charAt(index) == 20803 && ((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT)).getLanguage().equals("ja")) {
                parsePosition.setIndex(index + 1);
                return 1;
            }
            int i2 = 0;
            if (attributeQuery.contains(Attributes.ZERO_DIGIT)) {
                c = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT)).charValue();
            } else {
                c = numberSystem.isDecimal() ? numberSystem.getDigits().charAt(0) : '0';
            }
            Leniency leniency = numberSystem.isDecimal() ? Leniency.SMART : (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART);
            if (numberSystem.isDecimal()) {
                int min = Math.min(index + 9, charSequence.length());
                int i3 = index;
                i = i3;
                while (i3 < min) {
                    int charAt = charSequence.charAt(i3) - c;
                    if (charAt < 0 || charAt > 9) {
                        break;
                    }
                    i2 = (i2 * 10) + charAt;
                    i++;
                    i3++;
                }
            } else {
                int length = charSequence.length();
                int i4 = index;
                int i5 = 0;
                while (i4 < length && numberSystem.contains(charSequence.charAt(i4))) {
                    i5++;
                    i4++;
                }
                if (i5 > 0) {
                    i = index + i5;
                    i2 = numberSystem.toInteger(charSequence.subSequence(index, i).toString(), leniency);
                } else {
                    i = index;
                }
            }
            if (i == index) {
                parsePosition.setErrorIndex(index);
                return null;
            }
            parsePosition.setIndex(i);
            return Integer.valueOf(i2);
        }

        public Integer parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery, ChronoEntity<?> chronoEntity) {
            return parse(charSequence, parsePosition, attributeQuery);
        }
    }

    private static class MonthPrimitiveElement extends EastAsianME implements ElementRule<JapaneseCalendar, EastAsianMonth> {
        static final MonthPrimitiveElement SINGLETON_JP = new MonthPrimitiveElement();
        private static final long serialVersionUID = -2978966174642315851L;

        private MonthPrimitiveElement() {
        }

        public EastAsianMonth getValue(JapaneseCalendar japaneseCalendar) {
            return japaneseCalendar.month;
        }

        public EastAsianMonth getMinimum(JapaneseCalendar japaneseCalendar) {
            return EastAsianMonth.valueOf(1);
        }

        public EastAsianMonth getMaximum(JapaneseCalendar japaneseCalendar) {
            EastAsianMonth valueOf = EastAsianMonth.valueOf(12);
            return (japaneseCalendar.relgregyear >= 1873 || JapaneseCalendar.LEAP_INDICATORS[japaneseCalendar.relgregyear + -701] != 13) ? valueOf : valueOf.withLeap();
        }

        public boolean isValid(JapaneseCalendar japaneseCalendar, EastAsianMonth eastAsianMonth) {
            if (eastAsianMonth == null) {
                return false;
            }
            if (japaneseCalendar.relgregyear >= 1873) {
                return !eastAsianMonth.isLeap();
            }
            if (!eastAsianMonth.isLeap() || JapaneseCalendar.LEAP_INDICATORS[japaneseCalendar.relgregyear - 701] == eastAsianMonth.getNumber() + 1) {
                return true;
            }
            return false;
        }

        public JapaneseCalendar withValue(JapaneseCalendar japaneseCalendar, EastAsianMonth eastAsianMonth, boolean z) {
            if (isValid(japaneseCalendar, eastAsianMonth)) {
                return JapaneseCalendar.create(japaneseCalendar, japaneseCalendar.relgregyear, eastAsianMonth, Math.min(japaneseCalendar.dayOfMonth, JapaneseCalendar.getLengthOfMonth(japaneseCalendar.relgregyear, eastAsianMonth)));
            }
            throw new IllegalArgumentException("Invalid month: " + eastAsianMonth);
        }

        public ChronoElement<?> getChildAtFloor(JapaneseCalendar japaneseCalendar) {
            return JapaneseCalendar.DAY_OF_MONTH;
        }

        public ChronoElement<?> getChildAtCeiling(JapaneseCalendar japaneseCalendar) {
            return JapaneseCalendar.DAY_OF_MONTH;
        }

        /* access modifiers changed from: protected */
        public Object readResolve() throws ObjectStreamException {
            return SINGLETON_JP;
        }

        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
            if (((Integer) chronoDisplay.get(CommonElements.RELATED_GREGORIAN_YEAR)).intValue() >= 1873) {
                int intValue = ((Integer) attributeQuery.get(DualFormatElement.COUNT_OF_PATTERN_SYMBOLS, 0)).intValue();
                int number = ((EastAsianMonth) chronoDisplay.get(JapaneseCalendar.MONTH_OF_YEAR)).getNumber();
                if (intValue == 0) {
                    appendable.append(CalendarText.getIsoInstance((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT)).getStdMonths((TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE), (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT)).print(Month.valueOf(number)));
                    return;
                }
                NumberSystem numberSystem = (NumberSystem) attributeQuery.get(Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC);
                char charValue = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, Character.valueOf(numberSystem.getDigits().charAt(0)))).charValue();
                String numeral = DualFormatHelper.toNumeral(numberSystem, charValue, number);
                if (numberSystem.isDecimal()) {
                    for (int length = intValue - numeral.length(); length > 0; length--) {
                        appendable.append(charValue);
                    }
                }
                appendable.append(numeral);
                return;
            }
            super.print(chronoDisplay, appendable, attributeQuery);
        }

        public EastAsianMonth parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
            Locale locale = (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT);
            int intValue = ((Integer) attributeQuery.get(DualFormatElement.COUNT_OF_PATTERN_SYMBOLS, 0)).intValue();
            int index = parsePosition.getIndex();
            if (intValue == 0) {
                Month month = (Month) CalendarText.getIsoInstance(locale).getStdMonths((TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE), (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT)).parse(charSequence, parsePosition, Month.class, attributeQuery);
                if (month != null) {
                    return EastAsianMonth.valueOf(month.getValue());
                }
                parsePosition.setIndex(index);
                parsePosition.setErrorIndex(-1);
            }
            return super.parse(charSequence, parsePosition, attributeQuery);
        }
    }

    private static class Merger implements ChronoMerger<JapaneseCalendar> {
        public int getDefaultPivotYear() {
            return 100;
        }

        public ChronoDisplay preformat(JapaneseCalendar japaneseCalendar, AttributeQuery attributeQuery) {
            return japaneseCalendar;
        }

        public Chronology<?> preparser() {
            return null;
        }

        private Merger() {
        }

        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            return GenericDatePatterns.get("japanese", displayStyle, locale);
        }

        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.MIDNIGHT;
        }

        /* JADX WARNING: type inference failed for: r4v0, types: [net.time4j.base.TimeSource, net.time4j.base.TimeSource<?>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.calendar.JapaneseCalendar createFrom(net.time4j.base.TimeSource<?> r4, net.time4j.engine.AttributeQuery r5) {
            /*
                r3 = this;
                net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r0 = net.time4j.format.Attributes.TIMEZONE_ID
                boolean r0 = r5.contains(r0)
                if (r0 == 0) goto L_0x0011
                net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r0 = net.time4j.format.Attributes.TIMEZONE_ID
                java.lang.Object r0 = r5.get(r0)
                net.time4j.tz.TZID r0 = (net.time4j.tz.TZID) r0
                goto L_0x0029
            L_0x0011:
                net.time4j.engine.AttributeKey<net.time4j.format.Leniency> r0 = net.time4j.format.Attributes.LENIENCY
                net.time4j.format.Leniency r1 = net.time4j.format.Leniency.SMART
                java.lang.Object r0 = r5.get(r0, r1)
                net.time4j.format.Leniency r0 = (net.time4j.format.Leniency) r0
                boolean r0 = r0.isLax()
                if (r0 == 0) goto L_0x004c
                net.time4j.tz.Timezone r0 = net.time4j.tz.Timezone.ofSystem()
                net.time4j.tz.TZID r0 = r0.getID()
            L_0x0029:
                net.time4j.engine.AttributeKey<net.time4j.engine.StartOfDay> r1 = net.time4j.format.Attributes.START_OF_DAY
                net.time4j.engine.StartOfDay r2 = r3.getDefaultStartOfDay()
                java.lang.Object r5 = r5.get(r1, r2)
                net.time4j.engine.StartOfDay r5 = (net.time4j.engine.StartOfDay) r5
                net.time4j.base.UnixTime r4 = r4.currentTime()
                net.time4j.Moment r4 = net.time4j.Moment.from(r4)
                net.time4j.engine.TimeAxis r1 = net.time4j.calendar.JapaneseCalendar.ENGINE
                net.time4j.GeneralTimestamp r4 = r4.toGeneralTimestamp(r1, r0, r5)
                java.lang.Object r4 = r4.toDate()
                net.time4j.calendar.JapaneseCalendar r4 = (net.time4j.calendar.JapaneseCalendar) r4
                return r4
            L_0x004c:
                r4 = 0
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.JapaneseCalendar.Merger.createFrom(net.time4j.base.TimeSource, net.time4j.engine.AttributeQuery):net.time4j.calendar.JapaneseCalendar");
        }

        public JapaneseCalendar createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            EastAsianMonth eastAsianMonth;
            Leniency leniency;
            Leniency leniency2;
            Nengo nengo = (Nengo) chronoEntity.get((ChronoElement<V>) JapaneseCalendar.ERA);
            if (nengo == null) {
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Missing Japanese nengo/era.");
                return null;
            }
            int i = chronoEntity.getInt(JapaneseCalendar.YEAR_OF_ERA);
            if (i == Integer.MIN_VALUE) {
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Missing Japanese year.");
                return null;
            }
            int firstRelatedGregorianYear = (nengo.getFirstRelatedGregorianYear() + i) - 1;
            if (chronoEntity.contains(JapaneseCalendar.MONTH_OF_YEAR)) {
                eastAsianMonth = (EastAsianMonth) chronoEntity.get((ChronoElement<V>) JapaneseCalendar.MONTH_OF_YEAR);
            } else if (chronoEntity.contains(JapaneseCalendar.MONTH_AS_ORDINAL)) {
                int i2 = chronoEntity.getInt(JapaneseCalendar.MONTH_AS_ORDINAL);
                if (firstRelatedGregorianYear >= 1873) {
                    eastAsianMonth = EastAsianMonth.valueOf(i2);
                } else {
                    byte b = JapaneseCalendar.LEAP_INDICATORS[firstRelatedGregorianYear - 701];
                    if (i2 == b) {
                        eastAsianMonth = EastAsianMonth.valueOf(i2 - 1).withLeap();
                    } else {
                        eastAsianMonth = i2 > b ? EastAsianMonth.valueOf(i2 - 1) : EastAsianMonth.valueOf(i2);
                    }
                }
            } else {
                eastAsianMonth = null;
            }
            if (eastAsianMonth != null) {
                int i3 = chronoEntity.getInt(JapaneseCalendar.DAY_OF_MONTH);
                if (i3 == Integer.MIN_VALUE) {
                    chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Missing Japanese day of month.");
                    return null;
                }
                if (z) {
                    leniency2 = Leniency.LAX;
                } else {
                    leniency2 = (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART);
                }
                return JapaneseCalendar.of(nengo, i, eastAsianMonth, i3, leniency2);
            }
            int i4 = chronoEntity.getInt(JapaneseCalendar.DAY_OF_YEAR);
            if (i4 != Integer.MIN_VALUE && i4 <= JapaneseCalendar.getLengthOfYear(firstRelatedGregorianYear)) {
                try {
                    EastAsianMonth access$2300 = JapaneseCalendar.getMonth(firstRelatedGregorianYear, i4);
                    int access$2400 = JapaneseCalendar.getDayOfMonth(firstRelatedGregorianYear, i4);
                    if (z) {
                        leniency = Leniency.LAX;
                    } else {
                        leniency = (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART);
                    }
                    return JapaneseCalendar.of(nengo, i, access$2300, access$2400, leniency);
                } catch (IllegalArgumentException unused) {
                    chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Invalid Japanese date.");
                }
            }
            return null;
        }
    }

    private static class SPX implements Externalizable {
        private static final int JAPANESE = 9;
        private static final long serialVersionUID = 1;
        private transient Object obj;

        public SPX() {
        }

        SPX(Object obj2) {
            this.obj = obj2;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeByte(9);
            writeJapanese(objectOutput);
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            if (objectInput.readByte() == 9) {
                this.obj = readJapanese(objectInput);
                return;
            }
            throw new InvalidObjectException("Unknown calendar type.");
        }

        private Object readResolve() throws ObjectStreamException {
            return this.obj;
        }

        private void writeJapanese(ObjectOutput objectOutput) throws IOException {
            JapaneseCalendar japaneseCalendar = (JapaneseCalendar) this.obj;
            objectOutput.writeInt((japaneseCalendar.getYear() - 1) + japaneseCalendar.getEra().getFirstRelatedGregorianYear());
            objectOutput.writeInt(japaneseCalendar.getDayOfYear());
        }

        private JapaneseCalendar readJapanese(ObjectInput objectInput) throws IOException {
            return JapaneseCalendar.axis().getCalendarSystem().transform(JapaneseCalendar.transform(objectInput.readInt(), objectInput.readInt()));
        }
    }
}
