package net.time4j.calendar;

import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import net.time4j.GeneralTimestamp;
import net.time4j.Month;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.SystemClock;
import net.time4j.Weekday;
import net.time4j.Weekmodel;
import net.time4j.base.MathUtils;
import net.time4j.calendar.CommonElements;
import net.time4j.calendar.service.GenericDatePatterns;
import net.time4j.calendar.service.StdIntegerDateElement;
import net.time4j.calendar.service.StdWeekdayElement;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.CalendarDays;
import net.time4j.engine.CalendarEra;
import net.time4j.engine.CalendarSystem;
import net.time4j.engine.Calendrical;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoExtension;
import net.time4j.engine.ChronoFunction;
import net.time4j.engine.ChronoMerger;
import net.time4j.engine.ChronoUnit;
import net.time4j.engine.Chronology;
import net.time4j.engine.DisplayStyle;
import net.time4j.engine.ElementRule;
import net.time4j.engine.FormattableElement;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.TimeAxis;
import net.time4j.engine.UnitRule;
import net.time4j.engine.ValidationElement;
import net.time4j.format.CalendarType;
import net.time4j.format.LocalizedPatternSupport;
import net.time4j.format.TextElement;
import net.time4j.history.ChronoHistory;
import net.time4j.history.HistoricDate;
import net.time4j.history.HistoricEra;

@CalendarType("julian")
public final class JulianCalendar extends Calendrical<Unit, JulianCalendar> implements LocalizedPatternSupport {
    /* access modifiers changed from: private */
    public static final EraYearMonthDaySystem<JulianCalendar> CALSYS;
    public static final ChronoElement<HistoricDate> DATE;
    @FormattableElement(format = "d")
    public static final ChronoElement<Integer> DAY_OF_MONTH;
    private static final int DAY_OF_MONTH_INDEX = 2;
    @FormattableElement(format = "E")
    public static final ChronoElement<Weekday> DAY_OF_WEEK;
    @FormattableElement(format = "D")
    public static final ChronoElement<Integer> DAY_OF_YEAR;
    private static final int DAY_OF_YEAR_INDEX = 3;
    /* access modifiers changed from: private */
    public static final TimeAxis<Unit, JulianCalendar> ENGINE;
    @FormattableElement(format = "G")
    public static final ChronoElement<HistoricEra> ERA;
    @FormattableElement(alt = "L", format = "M")
    public static final TextElement<Integer> MONTH_OF_YEAR;
    private static final int OFFSET = 720200;
    @FormattableElement(format = "F")
    public static final OrdinalWeekdayElement<JulianCalendar> WEEKDAY_IN_MONTH;
    private static final WeekdayInMonthElement<JulianCalendar> WIM_ELEMENT;
    private static final int YEAR_INDEX = 0;
    @FormattableElement(format = "y")
    public static final ChronoElement<Integer> YEAR_OF_ERA;
    private static final int YMAX = 999999999;
    private static final long serialVersionUID = 3038883058279104976L;
    /* access modifiers changed from: private */
    public final transient int dom;
    /* access modifiers changed from: private */
    public final transient int month;
    /* access modifiers changed from: private */
    public final transient int prolepticYear;

    /* access modifiers changed from: protected */
    public JulianCalendar getContext() {
        return this;
    }

    static {
        Class<JulianCalendar> cls = JulianCalendar.class;
        ChronoElement<HistoricDate> date = ChronoHistory.PROLEPTIC_JULIAN.date();
        DATE = date;
        ChronoElement<HistoricEra> era = ChronoHistory.PROLEPTIC_JULIAN.era();
        ERA = era;
        TextElement<Integer> yearOfEra = ChronoHistory.PROLEPTIC_JULIAN.yearOfEra();
        YEAR_OF_ERA = yearOfEra;
        TextElement<Integer> month2 = ChronoHistory.PROLEPTIC_JULIAN.month();
        MONTH_OF_YEAR = month2;
        ChronoElement<Integer> dayOfMonth = ChronoHistory.PROLEPTIC_JULIAN.dayOfMonth();
        DAY_OF_MONTH = dayOfMonth;
        StdIntegerDateElement stdIntegerDateElement = new StdIntegerDateElement("DAY_OF_YEAR", JulianCalendar.class, 1, 365, 'D');
        DAY_OF_YEAR = stdIntegerDateElement;
        StdWeekdayElement stdWeekdayElement = new StdWeekdayElement(cls, getDefaultWeekmodel());
        DAY_OF_WEEK = stdWeekdayElement;
        WeekdayInMonthElement<JulianCalendar> weekdayInMonthElement = new WeekdayInMonthElement<>(cls, dayOfMonth, stdWeekdayElement);
        WIM_ELEMENT = weekdayInMonthElement;
        WEEKDAY_IN_MONTH = weekdayInMonthElement;
        Transformer transformer = new Transformer();
        CALSYS = transformer;
        ENGINE = TimeAxis.Builder.setUp(Unit.class, cls, new Merger(), transformer).appendElement((ChronoElement) date, (ElementRule) new DateRule()).appendElement((ChronoElement) era, (ElementRule) new EraRule()).appendElement(yearOfEra, new IntegerRule(0), Unit.YEARS).appendElement(month2, new MonthRule(), Unit.MONTHS).appendElement(dayOfMonth, new IntegerRule(2), Unit.DAYS).appendElement(stdIntegerDateElement, new IntegerRule(3), Unit.DAYS).appendElement(stdWeekdayElement, new WeekdayRule(getDefaultWeekmodel(), new ChronoFunction<JulianCalendar, CalendarSystem<JulianCalendar>>() {
            public CalendarSystem<JulianCalendar> apply(JulianCalendar julianCalendar) {
                return JulianCalendar.CALSYS;
            }
        }), Unit.DAYS).appendElement((ChronoElement) weekdayInMonthElement, (ElementRule) WeekdayInMonthElement.getRule(weekdayInMonthElement)).appendElement((ChronoElement) CommonElements.RELATED_GREGORIAN_YEAR, (ElementRule) new RelatedGregorianYearRule(transformer, (ChronoElement<Integer>) stdIntegerDateElement)).appendUnit(Unit.YEARS, new JulianUnitRule(Unit.YEARS), Unit.YEARS.getLength(), Collections.singleton(Unit.MONTHS)).appendUnit(Unit.MONTHS, new JulianUnitRule(Unit.MONTHS), Unit.MONTHS.getLength(), Collections.singleton(Unit.YEARS)).appendUnit(Unit.WEEKS, new JulianUnitRule(Unit.WEEKS), Unit.WEEKS.getLength(), Collections.singleton(Unit.DAYS)).appendUnit(Unit.DAYS, new JulianUnitRule(Unit.DAYS), Unit.DAYS.getLength(), Collections.singleton(Unit.WEEKS)).appendExtension((ChronoExtension) new CommonElements.Weekengine(cls, dayOfMonth, stdIntegerDateElement, getDefaultWeekmodel())).build();
    }

    private JulianCalendar(int i, int i2, int i3) {
        this.prolepticYear = i;
        this.month = i2;
        this.dom = i3;
    }

    public static JulianCalendar of(HistoricEra historicEra, int i, int i2, int i3) {
        Objects.requireNonNull(historicEra, "Missing Julian era.");
        if (!CALSYS.isValid(historicEra, i, i2, i3)) {
            throw new IllegalArgumentException("Out of bounds: " + toString(historicEra, i, i2, i3));
        } else if (historicEra == HistoricEra.AD) {
            return new JulianCalendar(i, i2, i3);
        } else {
            return new JulianCalendar(MathUtils.safeSubtract(1, i), i2, i3);
        }
    }

    public static JulianCalendar of(HistoricEra historicEra, int i, Month month2, int i2) {
        return of(historicEra, i, month2.getValue(), i2);
    }

    public static JulianCalendar nowInSystemTime() {
        return (JulianCalendar) SystemClock.inLocalView().now(axis());
    }

    public HistoricEra getEra() {
        return this.prolepticYear >= 1 ? HistoricEra.AD : HistoricEra.BC;
    }

    public int getYear() {
        int i = this.prolepticYear;
        return i >= 1 ? i : MathUtils.safeSubtract(1, i);
    }

    public Month getMonth() {
        return Month.valueOf(this.month);
    }

    public int getDayOfMonth() {
        return this.dom;
    }

    public Weekday getDayOfWeek() {
        return Weekday.valueOf(MathUtils.floorModulo(CALSYS.transform(this) + 5, 7) + 1);
    }

    public int getDayOfYear() {
        return ((Integer) get(DAY_OF_YEAR)).intValue();
    }

    public int lengthOfMonth() {
        return lengthOfMonth(this.prolepticYear, this.month);
    }

    public int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    public boolean isLeapYear() {
        return this.prolepticYear % 4 == 0;
    }

    public static boolean isValid(HistoricEra historicEra, int i, int i2, int i3) {
        return CALSYS.isValid(historicEra, i, i2, i3);
    }

    public GeneralTimestamp<JulianCalendar> at(PlainTime plainTime) {
        return GeneralTimestamp.of(this, plainTime);
    }

    public GeneralTimestamp<JulianCalendar> atTime(int i, int i2) {
        return at(PlainTime.of(i, i2));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JulianCalendar)) {
            return false;
        }
        JulianCalendar julianCalendar = (JulianCalendar) obj;
        if (this.dom == julianCalendar.dom && this.month == julianCalendar.month && this.prolepticYear == julianCalendar.prolepticYear) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.dom * 17) + (this.month * 31) + (this.prolepticYear * 37);
    }

    public String toString() {
        return toString(getEra(), getYear(), this.month, this.dom);
    }

    public static Weekmodel getDefaultWeekmodel() {
        return Weekmodel.of(Weekday.SUNDAY, 1);
    }

    public static TimeAxis<Unit, JulianCalendar> axis() {
        return ENGINE;
    }

    /* access modifiers changed from: protected */
    public TimeAxis<Unit, JulianCalendar> getChronology() {
        return ENGINE;
    }

    /* access modifiers changed from: package-private */
    public int getProlepticYear() {
        return this.prolepticYear;
    }

    private static String toString(CalendarEra calendarEra, int i, int i2, int i3) {
        StringBuilder sb = new StringBuilder(32);
        sb.append("JULIAN-");
        sb.append(calendarEra.name());
        sb.append(SignatureVisitor.SUPER);
        String valueOf = String.valueOf(i);
        for (int length = valueOf.length(); length < 4; length++) {
            sb.append('0');
        }
        sb.append(valueOf);
        sb.append(SignatureVisitor.SUPER);
        if (i2 < 10) {
            sb.append('0');
        }
        sb.append(i2);
        sb.append(SignatureVisitor.SUPER);
        if (i3 < 10) {
            sb.append('0');
        }
        sb.append(i3);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public static int lengthOfMonth(int i, int i2) {
        return i2 != 2 ? (i2 == 4 || i2 == 6 || i2 == 9 || i2 == 11) ? 30 : 31 : i % 4 == 0 ? 29 : 28;
    }

    private Object writeReplace() {
        return new SPX(this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    public enum Unit implements ChronoUnit {
        YEARS(3.15576E7d),
        MONTHS(2629800.0d),
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

        public int between(JulianCalendar julianCalendar, JulianCalendar julianCalendar2) {
            return MathUtils.safeCast(julianCalendar.until(julianCalendar2, this));
        }
    }

    private static class Transformer implements EraYearMonthDaySystem<JulianCalendar> {
        private Transformer() {
        }

        public boolean isValid(CalendarEra calendarEra, int i, int i2, int i3) {
            int i4;
            if (calendarEra == HistoricEra.AD) {
                i4 = i;
            } else if (calendarEra != HistoricEra.BC) {
                return false;
            } else {
                i4 = MathUtils.safeSubtract(1, i);
            }
            if (i < 1 || i > 999999999 || i2 < 1 || i2 > 12 || i3 < 1 || i3 > JulianCalendar.lengthOfMonth(i4, i2)) {
                return false;
            }
            return true;
        }

        public int getLengthOfMonth(CalendarEra calendarEra, int i, int i2) {
            int i3;
            if (calendarEra == HistoricEra.AD) {
                i3 = i;
            } else if (calendarEra == HistoricEra.BC) {
                i3 = MathUtils.safeSubtract(1, i);
            } else {
                throw new IllegalArgumentException("Invalid era: " + calendarEra);
            }
            if (i >= 1 && i <= 999999999 && i2 >= 1 && i2 <= 12) {
                return JulianCalendar.lengthOfMonth(i3, i2);
            }
            throw new IllegalArgumentException("Out of bounds: year=" + i + ", month=" + i2);
        }

        public int getLengthOfYear(CalendarEra calendarEra, int i) {
            int i2;
            if (calendarEra == HistoricEra.AD) {
                i2 = i;
            } else if (calendarEra == HistoricEra.BC) {
                i2 = MathUtils.safeSubtract(1, i);
            } else {
                throw new IllegalArgumentException("Invalid era: " + calendarEra);
            }
            if (i >= 1 && i <= 999999999) {
                return i2 % 4 == 0 ? 366 : 365;
            }
            throw new IllegalArgumentException("Out of bounds: year=" + i);
        }

        public JulianCalendar transform(long j) {
            int i;
            long j2;
            try {
                long safeAdd = MathUtils.safeAdd(j, 720200);
                long floorDivide = MathUtils.floorDivide(safeAdd, 1461);
                int floorModulo = MathUtils.floorModulo(safeAdd, 1461);
                int i2 = 2;
                if (floorModulo == 1460) {
                    j2 = (floorDivide + 1) * 4;
                    i = 29;
                } else {
                    int i3 = floorModulo / 365;
                    int i4 = floorModulo % 365;
                    j2 = (floorDivide * 4) + ((long) i3);
                    i2 = 2 + (((i4 + 31) * 5) / 153);
                    i = (i4 - (((i2 + 1) * 153) / 5)) + 123;
                    if (i2 > 12) {
                        j2++;
                        i2 -= 12;
                    }
                }
                int i5 = (j2 > 1 ? 1 : (j2 == 1 ? 0 : -1));
                HistoricEra historicEra = i5 >= 0 ? HistoricEra.AD : HistoricEra.BC;
                if (i5 < 0) {
                    j2 = MathUtils.safeSubtract(1, j2);
                }
                return JulianCalendar.of(historicEra, MathUtils.safeCast(j2), i2, i);
            } catch (ArithmeticException e) {
                throw new IllegalArgumentException(e);
            }
        }

        public long transform(JulianCalendar julianCalendar) {
            long access$700 = (long) julianCalendar.prolepticYear;
            int access$800 = julianCalendar.month;
            if (access$800 < 3) {
                access$700--;
                access$800 += 12;
            }
            return (((((365 * access$700) + MathUtils.floorDivide(access$700, 4)) + ((long) (((access$800 + 1) * 153) / 5))) - 123) + ((long) julianCalendar.dom)) - 720200;
        }

        public long getMinimumSinceUTC() {
            return transform(new JulianCalendar(-999999998, 1, 1));
        }

        public long getMaximumSinceUTC() {
            return transform(new JulianCalendar(999999999, 12, 31));
        }

        public List<CalendarEra> getEras() {
            return Collections.unmodifiableList(Arrays.asList(new CalendarEra[]{HistoricEra.BC, HistoricEra.AD}));
        }
    }

    private static class IntegerRule implements ElementRule<JulianCalendar, Integer> {
        private final int index;

        IntegerRule(int i) {
            this.index = i;
        }

        public Integer getValue(JulianCalendar julianCalendar) {
            int i = this.index;
            if (i == 0) {
                return Integer.valueOf(julianCalendar.getYear());
            }
            if (i == 2) {
                return Integer.valueOf(julianCalendar.dom);
            }
            if (i == 3) {
                int i2 = 0;
                for (int i3 = 1; i3 < julianCalendar.month; i3++) {
                    i2 += JulianCalendar.lengthOfMonth(julianCalendar.prolepticYear, i3);
                }
                return Integer.valueOf(i2 + julianCalendar.dom);
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public Integer getMinimum(JulianCalendar julianCalendar) {
            int i = this.index;
            if (i == 0 || i == 2 || i == 3) {
                return 1;
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public Integer getMaximum(JulianCalendar julianCalendar) {
            int i = this.index;
            if (i == 0) {
                return 999999999;
            }
            if (i == 2) {
                return Integer.valueOf(JulianCalendar.lengthOfMonth(julianCalendar.prolepticYear, julianCalendar.month));
            }
            if (i == 3) {
                return Integer.valueOf(julianCalendar.prolepticYear % 4 == 0 ? 366 : 365);
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public boolean isValid(JulianCalendar julianCalendar, Integer num) {
            if (num == null) {
                return false;
            }
            Integer minimum = getMinimum(julianCalendar);
            Integer maximum = getMaximum(julianCalendar);
            if (minimum.compareTo(num) > 0 || maximum.compareTo(num) < 0) {
                return false;
            }
            return true;
        }

        public JulianCalendar withValue(JulianCalendar julianCalendar, Integer num, boolean z) {
            if (num != null) {
                int i = this.index;
                if (i == 0) {
                    int intValue = num.intValue();
                    return JulianCalendar.of(julianCalendar.getEra(), intValue, julianCalendar.month, Math.min(julianCalendar.dom, JulianCalendar.lengthOfMonth(julianCalendar.getEra() == HistoricEra.AD ? intValue : MathUtils.safeSubtract(1, intValue), julianCalendar.month)));
                } else if (i == 2) {
                    return JulianCalendar.of(julianCalendar.getEra(), julianCalendar.getYear(), julianCalendar.month, num.intValue());
                } else {
                    if (i == 3) {
                        int intValue2 = num.intValue();
                        if (intValue2 >= 1 && intValue2 <= julianCalendar.lengthOfYear()) {
                            return (JulianCalendar) julianCalendar.plus(CalendarDays.of((long) (num.intValue() - getValue(julianCalendar).intValue())));
                        }
                        throw new IllegalArgumentException("Invalid day of year: " + num);
                    }
                    throw new UnsupportedOperationException("Unknown element index: " + this.index);
                }
            } else {
                throw new IllegalArgumentException("Missing element value.");
            }
        }

        public ChronoElement<?> getChildAtFloor(JulianCalendar julianCalendar) {
            if (this.index == 0) {
                return JulianCalendar.MONTH_OF_YEAR;
            }
            return null;
        }

        public ChronoElement<?> getChildAtCeiling(JulianCalendar julianCalendar) {
            if (this.index == 0) {
                return JulianCalendar.MONTH_OF_YEAR;
            }
            return null;
        }
    }

    private static class MonthRule implements ElementRule<JulianCalendar, Integer> {
        private MonthRule() {
        }

        public Integer getValue(JulianCalendar julianCalendar) {
            return Integer.valueOf(julianCalendar.month);
        }

        public Integer getMinimum(JulianCalendar julianCalendar) {
            return 1;
        }

        public Integer getMaximum(JulianCalendar julianCalendar) {
            return 12;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
            r4 = r4.intValue();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isValid(net.time4j.calendar.JulianCalendar r3, java.lang.Integer r4) {
            /*
                r2 = this;
                r3 = 0
                if (r4 != 0) goto L_0x0004
                return r3
            L_0x0004:
                int r4 = r4.intValue()
                r0 = 1
                if (r4 < r0) goto L_0x0010
                r1 = 12
                if (r4 > r1) goto L_0x0010
                r3 = 1
            L_0x0010:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.JulianCalendar.MonthRule.isValid(net.time4j.calendar.JulianCalendar, java.lang.Integer):boolean");
        }

        public JulianCalendar withValue(JulianCalendar julianCalendar, Integer num, boolean z) {
            if (num != null) {
                int intValue = num.intValue();
                return new JulianCalendar(julianCalendar.prolepticYear, intValue, Math.min(julianCalendar.dom, JulianCalendar.lengthOfMonth(julianCalendar.prolepticYear, intValue)));
            }
            throw new IllegalArgumentException("Missing month.");
        }

        public ChronoElement<?> getChildAtFloor(JulianCalendar julianCalendar) {
            return JulianCalendar.DAY_OF_MONTH;
        }

        public ChronoElement<?> getChildAtCeiling(JulianCalendar julianCalendar) {
            return JulianCalendar.DAY_OF_MONTH;
        }
    }

    private static class EraRule implements ElementRule<JulianCalendar, HistoricEra> {
        private EraRule() {
        }

        public HistoricEra getValue(JulianCalendar julianCalendar) {
            return julianCalendar.getEra();
        }

        public HistoricEra getMinimum(JulianCalendar julianCalendar) {
            return HistoricEra.BC;
        }

        public HistoricEra getMaximum(JulianCalendar julianCalendar) {
            return HistoricEra.AD;
        }

        public boolean isValid(JulianCalendar julianCalendar, HistoricEra historicEra) {
            return julianCalendar.getEra().equals(historicEra);
        }

        public JulianCalendar withValue(JulianCalendar julianCalendar, HistoricEra historicEra, boolean z) {
            if (isValid(julianCalendar, historicEra)) {
                return julianCalendar;
            }
            throw new IllegalArgumentException("Julian era cannot be changed.");
        }

        public ChronoElement<?> getChildAtFloor(JulianCalendar julianCalendar) {
            return JulianCalendar.YEAR_OF_ERA;
        }

        public ChronoElement<?> getChildAtCeiling(JulianCalendar julianCalendar) {
            return JulianCalendar.YEAR_OF_ERA;
        }
    }

    private static class DateRule implements ElementRule<JulianCalendar, HistoricDate> {
        public ChronoElement<?> getChildAtCeiling(JulianCalendar julianCalendar) {
            return null;
        }

        public ChronoElement<?> getChildAtFloor(JulianCalendar julianCalendar) {
            return null;
        }

        private DateRule() {
        }

        public HistoricDate getValue(JulianCalendar julianCalendar) {
            return HistoricDate.of(julianCalendar.getEra(), julianCalendar.getYear(), julianCalendar.month, julianCalendar.dom);
        }

        public HistoricDate getMinimum(JulianCalendar julianCalendar) {
            return HistoricDate.of(HistoricEra.BC, 999999999, 1, 1);
        }

        public HistoricDate getMaximum(JulianCalendar julianCalendar) {
            return HistoricDate.of(HistoricEra.AD, 999999999, 12, 31);
        }

        public boolean isValid(JulianCalendar julianCalendar, HistoricDate historicDate) {
            if (historicDate == null) {
                return false;
            }
            return JulianCalendar.CALSYS.isValid(historicDate.getEra(), historicDate.getYearOfEra(), historicDate.getMonth(), historicDate.getDayOfMonth());
        }

        public JulianCalendar withValue(JulianCalendar julianCalendar, HistoricDate historicDate, boolean z) {
            if (historicDate != null) {
                return JulianCalendar.of(historicDate.getEra(), historicDate.getYearOfEra(), historicDate.getMonth(), historicDate.getDayOfMonth());
            }
            throw new IllegalArgumentException("Missing historic date value.");
        }
    }

    private static class Merger implements ChronoMerger<JulianCalendar> {
        public ChronoDisplay preformat(JulianCalendar julianCalendar, AttributeQuery attributeQuery) {
            return julianCalendar;
        }

        public Chronology<?> preparser() {
            return null;
        }

        private Merger() {
        }

        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            return GenericDatePatterns.get("generic", displayStyle, locale);
        }

        /* JADX WARNING: type inference failed for: r4v0, types: [net.time4j.base.TimeSource, net.time4j.base.TimeSource<?>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.calendar.JulianCalendar createFrom(net.time4j.base.TimeSource<?> r4, net.time4j.engine.AttributeQuery r5) {
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
                net.time4j.engine.TimeAxis r1 = net.time4j.calendar.JulianCalendar.ENGINE
                net.time4j.GeneralTimestamp r4 = r4.toGeneralTimestamp(r1, r0, r5)
                java.lang.Object r4 = r4.toDate()
                net.time4j.calendar.JulianCalendar r4 = (net.time4j.calendar.JulianCalendar) r4
                return r4
            L_0x004c:
                r4 = 0
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.JulianCalendar.Merger.createFrom(net.time4j.base.TimeSource, net.time4j.engine.AttributeQuery):net.time4j.calendar.JulianCalendar");
        }

        public JulianCalendar createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            int i;
            if (!chronoEntity.contains(JulianCalendar.ERA)) {
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Missing Julian era.");
                return null;
            }
            HistoricEra historicEra = (HistoricEra) chronoEntity.get((ChronoElement<V>) JulianCalendar.ERA);
            int i2 = chronoEntity.getInt(JulianCalendar.YEAR_OF_ERA);
            if (i2 == Integer.MIN_VALUE) {
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Missing Julian year.");
                return null;
            }
            int i3 = chronoEntity.getInt(JulianCalendar.MONTH_OF_YEAR);
            if (!(i3 == Integer.MIN_VALUE || (i = chronoEntity.getInt(JulianCalendar.DAY_OF_MONTH)) == Integer.MIN_VALUE)) {
                if (JulianCalendar.CALSYS.isValid(historicEra, i2, i3, i)) {
                    return JulianCalendar.of(historicEra, i2, i3, i);
                }
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Invalid Julian date.");
            }
            int i4 = chronoEntity.getInt(JulianCalendar.DAY_OF_YEAR);
            if (i4 != Integer.MIN_VALUE) {
                if (i4 > 0) {
                    int i5 = 1;
                    int safeSubtract = historicEra == HistoricEra.AD ? i2 : MathUtils.safeSubtract(1, i2);
                    int i6 = 0;
                    while (i5 <= 12) {
                        int access$600 = JulianCalendar.lengthOfMonth(safeSubtract, i5) + i6;
                        if (i4 <= access$600) {
                            return JulianCalendar.of(historicEra, i2, i5, i4 - i6);
                        }
                        i5++;
                        i6 = access$600;
                    }
                }
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Invalid Julian date.");
            }
            return null;
        }

        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.MIDNIGHT;
        }

        public int getDefaultPivotYear() {
            return PlainDate.axis().getDefaultPivotYear();
        }
    }

    private static class JulianUnitRule implements UnitRule<JulianCalendar> {
        private final Unit unit;

        JulianUnitRule(Unit unit2) {
            this.unit = unit2;
        }

        public JulianCalendar addTo(JulianCalendar julianCalendar, long j) {
            int i = AnonymousClass2.$SwitchMap$net$time4j$calendar$JulianCalendar$Unit[this.unit.ordinal()];
            if (i == 1) {
                j = MathUtils.safeMultiply(j, 12);
            } else if (i != 2) {
                if (i == 3) {
                    j = MathUtils.safeMultiply(j, 7);
                } else if (i != 4) {
                    throw new UnsupportedOperationException(this.unit.name());
                }
                return (JulianCalendar) JulianCalendar.CALSYS.transform(MathUtils.safeAdd(JulianCalendar.CALSYS.transform(julianCalendar), j));
            }
            long safeAdd = MathUtils.safeAdd(ymValue(julianCalendar), j);
            int safeCast = MathUtils.safeCast(MathUtils.floorDivide(safeAdd, 12));
            int floorModulo = MathUtils.floorModulo(safeAdd, 12) + 1;
            int min = Math.min(julianCalendar.dom, JulianCalendar.lengthOfMonth(safeCast, floorModulo));
            HistoricEra historicEra = safeCast >= 1 ? HistoricEra.AD : HistoricEra.BC;
            if (safeCast < 1) {
                safeCast = MathUtils.safeSubtract(1, safeCast);
            }
            return JulianCalendar.of(historicEra, safeCast, floorModulo, min);
        }

        public long between(JulianCalendar julianCalendar, JulianCalendar julianCalendar2) {
            int i = AnonymousClass2.$SwitchMap$net$time4j$calendar$JulianCalendar$Unit[this.unit.ordinal()];
            if (i == 1) {
                return julianCalendar.until(julianCalendar2, Unit.MONTHS) / 12;
            }
            if (i == 2) {
                long ymValue = ymValue(julianCalendar2) - ymValue(julianCalendar);
                int i2 = (ymValue > 0 ? 1 : (ymValue == 0 ? 0 : -1));
                if (i2 <= 0 || julianCalendar2.dom >= julianCalendar.dom) {
                    return (i2 >= 0 || julianCalendar2.dom <= julianCalendar.dom) ? ymValue : ymValue + 1;
                }
                return ymValue - 1;
            } else if (i == 3) {
                return julianCalendar.until(julianCalendar2, Unit.DAYS) / 7;
            } else {
                if (i == 4) {
                    return JulianCalendar.CALSYS.transform(julianCalendar2) - JulianCalendar.CALSYS.transform(julianCalendar);
                }
                throw new UnsupportedOperationException(this.unit.name());
            }
        }

        private static long ymValue(JulianCalendar julianCalendar) {
            return ((((long) julianCalendar.prolepticYear) * 12) + ((long) julianCalendar.month)) - 1;
        }
    }

    /* renamed from: net.time4j.calendar.JulianCalendar$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$calendar$JulianCalendar$Unit;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                net.time4j.calendar.JulianCalendar$Unit[] r0 = net.time4j.calendar.JulianCalendar.Unit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$calendar$JulianCalendar$Unit = r0
                net.time4j.calendar.JulianCalendar$Unit r1 = net.time4j.calendar.JulianCalendar.Unit.YEARS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$calendar$JulianCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.calendar.JulianCalendar$Unit r1 = net.time4j.calendar.JulianCalendar.Unit.MONTHS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$calendar$JulianCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.calendar.JulianCalendar$Unit r1 = net.time4j.calendar.JulianCalendar.Unit.WEEKS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$net$time4j$calendar$JulianCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.calendar.JulianCalendar$Unit r1 = net.time4j.calendar.JulianCalendar.Unit.DAYS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.JulianCalendar.AnonymousClass2.<clinit>():void");
        }
    }

    private static class SPX implements Externalizable {
        private static final int JULIAN = 7;
        private static final long serialVersionUID = 1;
        private transient Object obj;

        public SPX() {
        }

        SPX(Object obj2) {
            this.obj = obj2;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeByte(7);
            writeJulian(objectOutput);
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            if (objectInput.readByte() == 7) {
                this.obj = readJulian(objectInput);
                return;
            }
            throw new InvalidObjectException("Unknown calendar type.");
        }

        private Object readResolve() throws ObjectStreamException {
            return this.obj;
        }

        private void writeJulian(ObjectOutput objectOutput) throws IOException {
            JulianCalendar julianCalendar = (JulianCalendar) this.obj;
            objectOutput.writeInt(julianCalendar.getProlepticYear());
            objectOutput.writeInt(julianCalendar.getMonth().getValue());
            objectOutput.writeInt(julianCalendar.getDayOfMonth());
        }

        private JulianCalendar readJulian(ObjectInput objectInput) throws IOException {
            int readInt = objectInput.readInt();
            int readInt2 = objectInput.readInt();
            int readInt3 = objectInput.readInt();
            HistoricEra historicEra = readInt >= 1 ? HistoricEra.AD : HistoricEra.BC;
            if (readInt < 1) {
                readInt = MathUtils.safeSubtract(1, readInt);
            }
            return JulianCalendar.of(historicEra, readInt, readInt2, readInt3);
        }
    }
}
