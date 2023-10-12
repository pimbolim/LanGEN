package net.time4j.calendar;

import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import net.time4j.GeneralTimestamp;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.SystemClock;
import net.time4j.Weekday;
import net.time4j.Weekmodel;
import net.time4j.base.GregorianMath;
import net.time4j.base.MathUtils;
import net.time4j.calendar.CommonElements;
import net.time4j.calendar.service.GenericDatePatterns;
import net.time4j.calendar.service.StdEnumDateElement;
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
import net.time4j.format.CalendarType;
import net.time4j.format.LocalizedPatternSupport;

@CalendarType("indian")
public final class IndianCalendar extends Calendrical<Unit, IndianCalendar> implements LocalizedPatternSupport {
    /* access modifiers changed from: private */
    public static final EraYearMonthDaySystem<IndianCalendar> CALSYS;
    @FormattableElement(format = "d")
    public static final StdCalendarElement<Integer, IndianCalendar> DAY_OF_MONTH;
    private static final int DAY_OF_MONTH_INDEX = 2;
    @FormattableElement(format = "E")
    public static final StdCalendarElement<Weekday, IndianCalendar> DAY_OF_WEEK;
    @FormattableElement(format = "D")
    public static final StdCalendarElement<Integer, IndianCalendar> DAY_OF_YEAR;
    private static final int DAY_OF_YEAR_INDEX = 3;
    /* access modifiers changed from: private */
    public static final TimeAxis<Unit, IndianCalendar> ENGINE;
    @FormattableElement(format = "G")
    public static final ChronoElement<IndianEra> ERA;
    private static final int MAX_YEAR = 999999921;
    @FormattableElement(alt = "L", format = "M")
    public static final StdCalendarElement<IndianMonth, IndianCalendar> MONTH_OF_YEAR;
    @FormattableElement(format = "F")
    public static final OrdinalWeekdayElement<IndianCalendar> WEEKDAY_IN_MONTH;
    private static final WeekdayInMonthElement<IndianCalendar> WIM_ELEMENT;
    private static final int YEAR_INDEX = 0;
    @FormattableElement(format = "y")
    public static final StdCalendarElement<Integer, IndianCalendar> YEAR_OF_ERA;
    private static final long serialVersionUID = 7482205842000661998L;
    /* access modifiers changed from: private */
    public final transient int idom;
    /* access modifiers changed from: private */
    public final transient int imonth;
    /* access modifiers changed from: private */
    public final transient int iyear;

    /* access modifiers changed from: protected */
    public IndianCalendar getContext() {
        return this;
    }

    static {
        Class<IndianCalendar> cls = IndianCalendar.class;
        StdEnumDateElement stdEnumDateElement = new StdEnumDateElement("ERA", cls, IndianEra.class, 'G');
        ERA = stdEnumDateElement;
        StdIntegerDateElement stdIntegerDateElement = new StdIntegerDateElement("YEAR_OF_ERA", IndianCalendar.class, 1, MAX_YEAR, 'y', (ChronoOperator) null, (ChronoOperator) null);
        YEAR_OF_ERA = stdIntegerDateElement;
        StdEnumDateElement stdEnumDateElement2 = new StdEnumDateElement("MONTH_OF_YEAR", cls, IndianMonth.class, 'M');
        MONTH_OF_YEAR = stdEnumDateElement2;
        StdIntegerDateElement stdIntegerDateElement2 = new StdIntegerDateElement("DAY_OF_MONTH", IndianCalendar.class, 1, 31, 'd');
        DAY_OF_MONTH = stdIntegerDateElement2;
        StdIntegerDateElement stdIntegerDateElement3 = new StdIntegerDateElement("DAY_OF_YEAR", IndianCalendar.class, 1, 365, 'D');
        DAY_OF_YEAR = stdIntegerDateElement3;
        StdWeekdayElement stdWeekdayElement = new StdWeekdayElement(cls, getDefaultWeekmodel());
        DAY_OF_WEEK = stdWeekdayElement;
        WeekdayInMonthElement<IndianCalendar> weekdayInMonthElement = new WeekdayInMonthElement<>(cls, stdIntegerDateElement2, stdWeekdayElement);
        WIM_ELEMENT = weekdayInMonthElement;
        WEEKDAY_IN_MONTH = weekdayInMonthElement;
        Transformer transformer = new Transformer();
        CALSYS = transformer;
        ENGINE = TimeAxis.Builder.setUp(Unit.class, cls, new Merger(), transformer).appendElement((ChronoElement) stdEnumDateElement, (ElementRule) new EraRule()).appendElement(stdIntegerDateElement, new IntegerRule(0), Unit.YEARS).appendElement(stdEnumDateElement2, new MonthRule(), Unit.MONTHS).appendElement(stdIntegerDateElement2, new IntegerRule(2), Unit.DAYS).appendElement(stdIntegerDateElement3, new IntegerRule(3), Unit.DAYS).appendElement(stdWeekdayElement, new WeekdayRule(getDefaultWeekmodel(), new ChronoFunction<IndianCalendar, CalendarSystem<IndianCalendar>>() {
            public CalendarSystem<IndianCalendar> apply(IndianCalendar indianCalendar) {
                return IndianCalendar.CALSYS;
            }
        }), Unit.DAYS).appendElement((ChronoElement) weekdayInMonthElement, (ElementRule) WeekdayInMonthElement.getRule(weekdayInMonthElement)).appendElement((ChronoElement) CommonElements.RELATED_GREGORIAN_YEAR, (ElementRule) new RelatedGregorianYearRule(transformer, (ChronoElement<Integer>) stdIntegerDateElement3)).appendUnit(Unit.YEARS, new IndianUnitRule(Unit.YEARS), Unit.YEARS.getLength(), Collections.singleton(Unit.MONTHS)).appendUnit(Unit.MONTHS, new IndianUnitRule(Unit.MONTHS), Unit.MONTHS.getLength(), Collections.singleton(Unit.YEARS)).appendUnit(Unit.WEEKS, new IndianUnitRule(Unit.WEEKS), Unit.WEEKS.getLength(), Collections.singleton(Unit.DAYS)).appendUnit(Unit.DAYS, new IndianUnitRule(Unit.DAYS), Unit.DAYS.getLength(), Collections.singleton(Unit.WEEKS)).appendExtension((ChronoExtension) new CommonElements.Weekengine(cls, stdIntegerDateElement2, stdIntegerDateElement3, getDefaultWeekmodel())).build();
    }

    private IndianCalendar(int i, int i2, int i3) {
        this.iyear = i;
        this.imonth = i2;
        this.idom = i3;
    }

    public static IndianCalendar of(int i, IndianMonth indianMonth, int i2) {
        return of(i, indianMonth.getValue(), i2);
    }

    public static IndianCalendar of(int i, int i2, int i3) {
        if (CALSYS.isValid(IndianEra.SAKA, i, i2, i3)) {
            return new IndianCalendar(i, i2, i3);
        }
        throw new IllegalArgumentException("Invalid Indian date: year=" + i + ", month=" + i2 + ", day=" + i3);
    }

    public static IndianCalendar nowInSystemTime() {
        return (IndianCalendar) SystemClock.inLocalView().now(axis());
    }

    public IndianEra getEra() {
        return IndianEra.SAKA;
    }

    public int getYear() {
        return this.iyear;
    }

    public IndianMonth getMonth() {
        return IndianMonth.valueOf(this.imonth);
    }

    public int getDayOfMonth() {
        return this.idom;
    }

    public Weekday getDayOfWeek() {
        return Weekday.valueOf(MathUtils.floorModulo(CALSYS.transform(this) + 5, 7) + 1);
    }

    public int getDayOfYear() {
        return ((Integer) get(DAY_OF_YEAR)).intValue();
    }

    public int lengthOfMonth() {
        return CALSYS.getLengthOfMonth(IndianEra.SAKA, this.iyear, this.imonth);
    }

    public int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    public boolean isLeapYear() {
        return GregorianMath.isLeapYear(this.iyear + 78);
    }

    public static boolean isValid(int i, int i2, int i3) {
        return CALSYS.isValid(IndianEra.SAKA, i, i2, i3);
    }

    public GeneralTimestamp<IndianCalendar> at(PlainTime plainTime) {
        return GeneralTimestamp.of(this, plainTime);
    }

    public GeneralTimestamp<IndianCalendar> atTime(int i, int i2) {
        return at(PlainTime.of(i, i2));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IndianCalendar)) {
            return false;
        }
        IndianCalendar indianCalendar = (IndianCalendar) obj;
        if (this.idom == indianCalendar.idom && this.imonth == indianCalendar.imonth && this.iyear == indianCalendar.iyear) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.idom * 17) + (this.imonth * 31) + (this.iyear * 37);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("Saka-");
        String valueOf = String.valueOf(this.iyear);
        for (int length = valueOf.length(); length < 4; length++) {
            sb.append('0');
        }
        sb.append(valueOf);
        sb.append(SignatureVisitor.SUPER);
        if (this.imonth < 10) {
            sb.append('0');
        }
        sb.append(this.imonth);
        sb.append(SignatureVisitor.SUPER);
        if (this.idom < 10) {
            sb.append('0');
        }
        sb.append(this.idom);
        return sb.toString();
    }

    public static Weekmodel getDefaultWeekmodel() {
        return Weekmodel.of(Weekday.SUNDAY, 1, Weekday.SUNDAY, Weekday.SUNDAY);
    }

    public static TimeAxis<Unit, IndianCalendar> axis() {
        return ENGINE;
    }

    /* access modifiers changed from: protected */
    public TimeAxis<Unit, IndianCalendar> getChronology() {
        return ENGINE;
    }

    private Object writeReplace() {
        return new SPX(this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    public enum Unit implements ChronoUnit {
        YEARS(3.1556952E7d),
        MONTHS(2629746.0d),
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

        public long between(IndianCalendar indianCalendar, IndianCalendar indianCalendar2) {
            return indianCalendar.until(indianCalendar2, this);
        }
    }

    private static class Transformer implements EraYearMonthDaySystem<IndianCalendar> {
        private Transformer() {
        }

        public boolean isValid(CalendarEra calendarEra, int i, int i2, int i3) {
            if (calendarEra == IndianEra.SAKA && i >= 1 && i <= IndianCalendar.MAX_YEAR && i2 >= 1) {
                if (i2 > (i == IndianCalendar.MAX_YEAR ? 10 : 12) || i3 < 1 || i3 > getLengthOfMonth(calendarEra, i, i2)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int getLengthOfMonth(CalendarEra calendarEra, int i, int i2) {
            if (calendarEra == IndianEra.SAKA) {
                if (i >= 1 && i <= IndianCalendar.MAX_YEAR && i2 >= 1) {
                    if (i == IndianCalendar.MAX_YEAR && i2 == 10) {
                        return 10;
                    }
                    if (i2 == 1) {
                        if (GregorianMath.isLeapYear(i + 78)) {
                            return 31;
                        }
                        return 30;
                    } else if (i2 <= 6) {
                        return 31;
                    } else {
                        if (i2 <= 12) {
                            return 30;
                        }
                    }
                }
                throw new IllegalArgumentException("Out of bounds: year=" + i + ", month=" + i2);
            }
            throw new IllegalArgumentException("Invalid era: " + calendarEra);
        }

        public int getLengthOfYear(CalendarEra calendarEra, int i) {
            if (calendarEra != IndianEra.SAKA) {
                throw new IllegalArgumentException("Invalid era: " + calendarEra);
            } else if (i >= 1 && i < IndianCalendar.MAX_YEAR) {
                return GregorianMath.isLeapYear(i + 78) ? 366 : 365;
            } else {
                if (i == IndianCalendar.MAX_YEAR) {
                    return 285;
                }
                throw new IllegalArgumentException("Out of bounds: year=" + i);
            }
        }

        public IndianCalendar transform(long j) {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            int i10;
            int i11;
            int i12;
            PlainDate of = PlainDate.of(j, EpochDays.UTC);
            int year = of.getYear();
            int month = of.getMonth();
            int dayOfMonth = of.getDayOfMonth();
            boolean isLeapYear = GregorianMath.isLeapYear(year);
            int i13 = isLeapYear ? 21 : 22;
            int year2 = of.getYear() - 78;
            int i14 = 11;
            int i15 = 10;
            if (month != 12 || dayOfMonth < 22) {
                if (month == 12) {
                    i = dayOfMonth + 9;
                } else if (month != 11 || dayOfMonth < 22) {
                    if (month == 11) {
                        i12 = dayOfMonth + 9;
                    } else if (month != 10 || dayOfMonth < 23) {
                        if (month == 10) {
                            i11 = dayOfMonth + 8;
                        } else if (month != 9 || dayOfMonth < 23) {
                            if (month == 9) {
                                i10 = dayOfMonth + 9;
                            } else if (month != 8 || dayOfMonth < 23) {
                                if (month == 8) {
                                    i9 = dayOfMonth + 9;
                                } else if (month != 7 || dayOfMonth < 23) {
                                    if (month == 7) {
                                        i8 = dayOfMonth + 9;
                                    } else if (month != 6 || dayOfMonth < 22) {
                                        if (month == 6) {
                                            i7 = dayOfMonth + 10;
                                        } else if (month != 5 || dayOfMonth < 22) {
                                            if (month == 5) {
                                                i6 = dayOfMonth + 10;
                                            } else if (month != 4 || dayOfMonth < 21) {
                                                if (month == 4) {
                                                    if (!isLeapYear) {
                                                        i14 = 10;
                                                    }
                                                    i5 = dayOfMonth + i14;
                                                } else if (month != 3 || dayOfMonth < i13) {
                                                    if (month == 3) {
                                                        year2--;
                                                        if (!isLeapYear) {
                                                            i15 = 9;
                                                        }
                                                        i4 = dayOfMonth + i15;
                                                    } else if (month != 2 || dayOfMonth < 20) {
                                                        if (month == 2) {
                                                            i2 = year2 - 1;
                                                            i3 = dayOfMonth + 11;
                                                        } else if (month != 1 || dayOfMonth < 21) {
                                                            year2--;
                                                            i = dayOfMonth + 10;
                                                        } else {
                                                            i2 = year2 - 1;
                                                            i3 = dayOfMonth - 20;
                                                        }
                                                        i15 = 11;
                                                    } else {
                                                        year2--;
                                                        i4 = dayOfMonth - 19;
                                                    }
                                                    i15 = 12;
                                                } else {
                                                    i5 = (dayOfMonth - i13) + 1;
                                                }
                                                i15 = 1;
                                            } else {
                                                i6 = dayOfMonth - 20;
                                            }
                                            i15 = 2;
                                        } else {
                                            i7 = dayOfMonth - 21;
                                        }
                                        i15 = 3;
                                    } else {
                                        i8 = dayOfMonth - 21;
                                    }
                                    i15 = 4;
                                } else {
                                    i9 = dayOfMonth - 22;
                                }
                                i15 = 5;
                            } else {
                                i10 = dayOfMonth - 22;
                            }
                            i15 = 6;
                        } else {
                            i11 = dayOfMonth - 22;
                        }
                        i15 = 7;
                    } else {
                        i12 = dayOfMonth - 22;
                    }
                    i15 = 8;
                } else {
                    i = dayOfMonth - 21;
                }
                i15 = 9;
            } else {
                i = dayOfMonth - 21;
            }
            return IndianCalendar.of(year2, i15, i);
        }

        public long transform(IndianCalendar indianCalendar) {
            int access$500 = indianCalendar.iyear + 78;
            boolean isLeapYear = GregorianMath.isLeapYear(access$500);
            long longValue = ((Long) PlainDate.of(access$500, 3, isLeapYear ? 21 : 22).get(EpochDays.UTC)).longValue();
            int i = 0;
            for (int i2 = 1; i2 < indianCalendar.imonth; i2++) {
                switch (i2) {
                    case 1:
                        i += isLeapYear ? 31 : 30;
                        break;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        i += 31;
                        break;
                    default:
                        i += 30;
                        break;
                }
            }
            return longValue + ((long) (i + (indianCalendar.idom - 1)));
        }

        public long getMinimumSinceUTC() {
            return transform(new IndianCalendar(1, 1, 1));
        }

        public long getMaximumSinceUTC() {
            return transform(new IndianCalendar(IndianCalendar.MAX_YEAR, 10, 10));
        }

        public List<CalendarEra> getEras() {
            return Collections.singletonList(IndianEra.SAKA);
        }
    }

    private static class IntegerRule implements IntElementRule<IndianCalendar> {
        private final int index;

        IntegerRule(int i) {
            this.index = i;
        }

        public int getInt(IndianCalendar indianCalendar) {
            int i = this.index;
            if (i == 0) {
                return indianCalendar.iyear;
            }
            if (i == 2) {
                return indianCalendar.idom;
            }
            if (i == 3) {
                int i2 = 0;
                for (int i3 = 1; i3 < indianCalendar.imonth; i3++) {
                    i2 += IndianCalendar.CALSYS.getLengthOfMonth(IndianEra.SAKA, indianCalendar.iyear, i3);
                }
                return i2 + indianCalendar.idom;
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public boolean isValid(IndianCalendar indianCalendar, int i) {
            return getMin() <= i && getMax(indianCalendar) >= i;
        }

        public IndianCalendar withValue(IndianCalendar indianCalendar, int i, boolean z) {
            if (isValid(indianCalendar, i)) {
                int i2 = this.index;
                if (i2 == 0) {
                    return new IndianCalendar(i, indianCalendar.imonth, Math.min(indianCalendar.idom, IndianCalendar.CALSYS.getLengthOfMonth(IndianEra.SAKA, i, indianCalendar.imonth)));
                } else if (i2 == 2) {
                    return new IndianCalendar(indianCalendar.iyear, indianCalendar.imonth, i);
                } else {
                    if (i2 == 3) {
                        return (IndianCalendar) indianCalendar.plus(CalendarDays.of((long) (i - getValue(indianCalendar).intValue())));
                    }
                    throw new UnsupportedOperationException("Unknown element index: " + this.index);
                }
            } else {
                throw new IllegalArgumentException("Out of range: " + i);
            }
        }

        public Integer getValue(IndianCalendar indianCalendar) {
            return Integer.valueOf(getInt(indianCalendar));
        }

        public Integer getMinimum(IndianCalendar indianCalendar) {
            return Integer.valueOf(getMin());
        }

        public Integer getMaximum(IndianCalendar indianCalendar) {
            return Integer.valueOf(getMax(indianCalendar));
        }

        public boolean isValid(IndianCalendar indianCalendar, Integer num) {
            return num != null && isValid(indianCalendar, num.intValue());
        }

        public IndianCalendar withValue(IndianCalendar indianCalendar, Integer num, boolean z) {
            if (num != null) {
                return withValue(indianCalendar, num.intValue(), z);
            }
            throw new IllegalArgumentException("Missing new value.");
        }

        public ChronoElement<?> getChildAtFloor(IndianCalendar indianCalendar) {
            if (this.index == 0) {
                return IndianCalendar.MONTH_OF_YEAR;
            }
            return null;
        }

        public ChronoElement<?> getChildAtCeiling(IndianCalendar indianCalendar) {
            if (this.index == 0) {
                return IndianCalendar.MONTH_OF_YEAR;
            }
            return null;
        }

        private int getMin() {
            int i = this.index;
            if (i == 0 || i == 2 || i == 3) {
                return 1;
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        private int getMax(IndianCalendar indianCalendar) {
            int i = this.index;
            if (i == 0) {
                return IndianCalendar.MAX_YEAR;
            }
            if (i == 2) {
                return IndianCalendar.CALSYS.getLengthOfMonth(IndianEra.SAKA, indianCalendar.iyear, indianCalendar.imonth);
            }
            if (i == 3) {
                return IndianCalendar.CALSYS.getLengthOfYear(IndianEra.SAKA, indianCalendar.iyear);
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }
    }

    private static class MonthRule implements ElementRule<IndianCalendar, IndianMonth> {
        public boolean isValid(IndianCalendar indianCalendar, IndianMonth indianMonth) {
            return indianMonth != null;
        }

        private MonthRule() {
        }

        public IndianMonth getValue(IndianCalendar indianCalendar) {
            return indianCalendar.getMonth();
        }

        public IndianMonth getMinimum(IndianCalendar indianCalendar) {
            return IndianMonth.CHAITRA;
        }

        public IndianMonth getMaximum(IndianCalendar indianCalendar) {
            return IndianMonth.PHALGUNA;
        }

        public IndianCalendar withValue(IndianCalendar indianCalendar, IndianMonth indianMonth, boolean z) {
            if (indianMonth != null) {
                int value = indianMonth.getValue();
                return new IndianCalendar(indianCalendar.iyear, value, Math.min(indianCalendar.idom, IndianCalendar.CALSYS.getLengthOfMonth(IndianEra.SAKA, indianCalendar.iyear, value)));
            }
            throw new IllegalArgumentException("Missing month.");
        }

        public ChronoElement<?> getChildAtFloor(IndianCalendar indianCalendar) {
            return IndianCalendar.DAY_OF_MONTH;
        }

        public ChronoElement<?> getChildAtCeiling(IndianCalendar indianCalendar) {
            return IndianCalendar.DAY_OF_MONTH;
        }
    }

    private static class EraRule implements ElementRule<IndianCalendar, IndianEra> {
        public boolean isValid(IndianCalendar indianCalendar, IndianEra indianEra) {
            return indianEra != null;
        }

        private EraRule() {
        }

        public IndianEra getValue(IndianCalendar indianCalendar) {
            return IndianEra.SAKA;
        }

        public IndianEra getMinimum(IndianCalendar indianCalendar) {
            return IndianEra.SAKA;
        }

        public IndianEra getMaximum(IndianCalendar indianCalendar) {
            return IndianEra.SAKA;
        }

        public IndianCalendar withValue(IndianCalendar indianCalendar, IndianEra indianEra, boolean z) {
            if (indianEra != null) {
                return indianCalendar;
            }
            throw new IllegalArgumentException("Missing era value.");
        }

        public ChronoElement<?> getChildAtFloor(IndianCalendar indianCalendar) {
            return IndianCalendar.YEAR_OF_ERA;
        }

        public ChronoElement<?> getChildAtCeiling(IndianCalendar indianCalendar) {
            return IndianCalendar.YEAR_OF_ERA;
        }
    }

    private static class Merger implements ChronoMerger<IndianCalendar> {
        public ChronoDisplay preformat(IndianCalendar indianCalendar, AttributeQuery attributeQuery) {
            return indianCalendar;
        }

        public Chronology<?> preparser() {
            return null;
        }

        private Merger() {
        }

        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            return GenericDatePatterns.get("indian", displayStyle, locale);
        }

        /* JADX WARNING: type inference failed for: r4v0, types: [net.time4j.base.TimeSource, net.time4j.base.TimeSource<?>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.calendar.IndianCalendar createFrom(net.time4j.base.TimeSource<?> r4, net.time4j.engine.AttributeQuery r5) {
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
                net.time4j.engine.TimeAxis r1 = net.time4j.calendar.IndianCalendar.ENGINE
                net.time4j.GeneralTimestamp r4 = r4.toGeneralTimestamp(r1, r0, r5)
                java.lang.Object r4 = r4.toDate()
                net.time4j.calendar.IndianCalendar r4 = (net.time4j.calendar.IndianCalendar) r4
                return r4
            L_0x004c:
                r4 = 0
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.IndianCalendar.Merger.createFrom(net.time4j.base.TimeSource, net.time4j.engine.AttributeQuery):net.time4j.calendar.IndianCalendar");
        }

        public IndianCalendar createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            int i = chronoEntity.getInt(IndianCalendar.YEAR_OF_ERA);
            if (i == Integer.MIN_VALUE) {
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Missing Indian year.");
                return null;
            }
            if (chronoEntity.contains(IndianCalendar.MONTH_OF_YEAR)) {
                int value = ((IndianMonth) chronoEntity.get((ChronoElement<V>) IndianCalendar.MONTH_OF_YEAR)).getValue();
                int i2 = chronoEntity.getInt(IndianCalendar.DAY_OF_MONTH);
                if (i2 != Integer.MIN_VALUE) {
                    if (IndianCalendar.CALSYS.isValid(IndianEra.SAKA, i, value, i2)) {
                        return IndianCalendar.of(i, value, i2);
                    }
                    chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Invalid Indian date.");
                }
            } else {
                int i3 = chronoEntity.getInt(IndianCalendar.DAY_OF_YEAR);
                if (i3 != Integer.MIN_VALUE) {
                    if (i3 > 0) {
                        int i4 = 0;
                        int i5 = 1;
                        while (i5 <= 12) {
                            int lengthOfMonth = IndianCalendar.CALSYS.getLengthOfMonth(IndianEra.SAKA, i, i5) + i4;
                            if (i3 <= lengthOfMonth) {
                                return IndianCalendar.of(i, i5, i3 - i4);
                            }
                            i5++;
                            i4 = lengthOfMonth;
                        }
                    }
                    chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Invalid Indian date.");
                }
            }
            return null;
        }

        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.MIDNIGHT;
        }

        public int getDefaultPivotYear() {
            return PlainDate.axis().getDefaultPivotYear() - 78;
        }
    }

    private static class IndianUnitRule implements UnitRule<IndianCalendar> {
        private final Unit unit;

        IndianUnitRule(Unit unit2) {
            this.unit = unit2;
        }

        public IndianCalendar addTo(IndianCalendar indianCalendar, long j) {
            int i = AnonymousClass2.$SwitchMap$net$time4j$calendar$IndianCalendar$Unit[this.unit.ordinal()];
            if (i == 1) {
                j = MathUtils.safeMultiply(j, 12);
            } else if (i != 2) {
                if (i == 3) {
                    j = MathUtils.safeMultiply(j, 7);
                } else if (i != 4) {
                    throw new UnsupportedOperationException(this.unit.name());
                }
                return (IndianCalendar) IndianCalendar.CALSYS.transform(MathUtils.safeAdd(IndianCalendar.CALSYS.transform(indianCalendar), j));
            }
            long safeAdd = MathUtils.safeAdd((long) ymValue(indianCalendar), j);
            int safeCast = MathUtils.safeCast(MathUtils.floorDivide(safeAdd, 12));
            int floorModulo = MathUtils.floorModulo(safeAdd, 12) + 1;
            return IndianCalendar.of(safeCast, floorModulo, Math.min(indianCalendar.idom, IndianCalendar.CALSYS.getLengthOfMonth(IndianEra.SAKA, safeCast, floorModulo)));
        }

        public long between(IndianCalendar indianCalendar, IndianCalendar indianCalendar2) {
            int i = AnonymousClass2.$SwitchMap$net$time4j$calendar$IndianCalendar$Unit[this.unit.ordinal()];
            if (i == 1) {
                return Unit.MONTHS.between(indianCalendar, indianCalendar2) / 12;
            }
            if (i == 2) {
                long ymValue = (long) (ymValue(indianCalendar2) - ymValue(indianCalendar));
                int i2 = (ymValue > 0 ? 1 : (ymValue == 0 ? 0 : -1));
                if (i2 <= 0 || indianCalendar2.idom >= indianCalendar.idom) {
                    return (i2 >= 0 || indianCalendar2.idom <= indianCalendar.idom) ? ymValue : ymValue + 1;
                }
                return ymValue - 1;
            } else if (i == 3) {
                return Unit.DAYS.between(indianCalendar, indianCalendar2) / 7;
            } else {
                if (i == 4) {
                    return IndianCalendar.CALSYS.transform(indianCalendar2) - IndianCalendar.CALSYS.transform(indianCalendar);
                }
                throw new UnsupportedOperationException(this.unit.name());
            }
        }

        private static int ymValue(IndianCalendar indianCalendar) {
            return ((indianCalendar.iyear * 12) + indianCalendar.imonth) - 1;
        }
    }

    /* renamed from: net.time4j.calendar.IndianCalendar$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$calendar$IndianCalendar$Unit;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                net.time4j.calendar.IndianCalendar$Unit[] r0 = net.time4j.calendar.IndianCalendar.Unit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$calendar$IndianCalendar$Unit = r0
                net.time4j.calendar.IndianCalendar$Unit r1 = net.time4j.calendar.IndianCalendar.Unit.YEARS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$calendar$IndianCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.calendar.IndianCalendar$Unit r1 = net.time4j.calendar.IndianCalendar.Unit.MONTHS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$calendar$IndianCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.calendar.IndianCalendar$Unit r1 = net.time4j.calendar.IndianCalendar.Unit.WEEKS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$net$time4j$calendar$IndianCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.calendar.IndianCalendar$Unit r1 = net.time4j.calendar.IndianCalendar.Unit.DAYS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.IndianCalendar.AnonymousClass2.<clinit>():void");
        }
    }

    private static class SPX implements Externalizable {
        private static final int INDIAN = 10;
        private static final long serialVersionUID = 1;
        private transient Object obj;

        public SPX() {
        }

        SPX(Object obj2) {
            this.obj = obj2;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeByte(10);
            writeIndian(objectOutput);
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            if (objectInput.readByte() == 10) {
                this.obj = readIndian(objectInput);
                return;
            }
            throw new InvalidObjectException("Unknown calendar type.");
        }

        private Object readResolve() throws ObjectStreamException {
            return this.obj;
        }

        private void writeIndian(ObjectOutput objectOutput) throws IOException {
            IndianCalendar indianCalendar = (IndianCalendar) this.obj;
            objectOutput.writeInt(indianCalendar.getYear());
            objectOutput.writeByte(indianCalendar.getMonth().getValue());
            objectOutput.writeByte(indianCalendar.getDayOfMonth());
        }

        private IndianCalendar readIndian(ObjectInput objectInput) throws IOException {
            return IndianCalendar.of(objectInput.readInt(), (int) objectInput.readByte(), (int) objectInput.readByte());
        }
    }
}
