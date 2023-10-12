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
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.GeneralTimestamp;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.SystemClock;
import net.time4j.Weekday;
import net.time4j.Weekmodel;
import net.time4j.base.MathUtils;
import net.time4j.calendar.CommonElements;
import net.time4j.calendar.service.GenericDatePatterns;
import net.time4j.calendar.service.StdEnumDateElement;
import net.time4j.calendar.service.StdIntegerDateElement;
import net.time4j.calendar.service.StdWeekdayElement;
import net.time4j.engine.CalendarDays;
import net.time4j.engine.CalendarEra;
import net.time4j.engine.CalendarSystem;
import net.time4j.engine.Calendrical;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoException;
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
import net.time4j.engine.StartOfDay;
import net.time4j.engine.TimeAxis;
import net.time4j.engine.UnitRule;
import net.time4j.format.CalendarType;
import net.time4j.format.LocalizedPatternSupport;
import net.time4j.tz.ZonalOffset;

@CalendarType("persian")
public final class PersianCalendar extends Calendrical<Unit, PersianCalendar> implements LocalizedPatternSupport {
    public static final StdCalendarElement<Integer, PersianCalendar> BOUNDED_WEEK_OF_MONTH = CommonElements.boundedWeekOfMonth(axis(), getDefaultWeekmodel());
    public static final StdCalendarElement<Integer, PersianCalendar> BOUNDED_WEEK_OF_YEAR = CommonElements.boundedWeekOfYear(axis(), getDefaultWeekmodel());
    /* access modifiers changed from: private */
    public static final EraYearMonthDaySystem<PersianCalendar> CALSYS;
    @FormattableElement(format = "d")
    public static final StdCalendarElement<Integer, PersianCalendar> DAY_OF_MONTH;
    private static final int DAY_OF_MONTH_INDEX = 2;
    @FormattableElement(format = "E")
    public static final StdCalendarElement<Weekday, PersianCalendar> DAY_OF_WEEK;
    @FormattableElement(format = "D")
    public static final StdCalendarElement<Integer, PersianCalendar> DAY_OF_YEAR;
    private static final int DAY_OF_YEAR_INDEX = 3;
    /* access modifiers changed from: private */
    public static final PersianAlgorithm DEFAULT_COMPUTATION = PersianAlgorithm.BORKOWSKI;
    /* access modifiers changed from: private */
    public static final TimeAxis<Unit, PersianCalendar> ENGINE;
    @FormattableElement(format = "G")
    public static final ChronoElement<PersianEra> ERA;
    public static final StdCalendarElement<Weekday, PersianCalendar> LOCAL_DAY_OF_WEEK = CommonElements.localDayOfWeek(axis(), getDefaultWeekmodel());
    @FormattableElement(alt = "L", format = "M")
    public static final StdCalendarElement<PersianMonth, PersianCalendar> MONTH_OF_YEAR;
    @FormattableElement(format = "F")
    public static final OrdinalWeekdayElement<PersianCalendar> WEEKDAY_IN_MONTH;
    public static final StdCalendarElement<Integer, PersianCalendar> WEEK_OF_MONTH = CommonElements.weekOfMonth(axis(), getDefaultWeekmodel());
    public static final StdCalendarElement<Integer, PersianCalendar> WEEK_OF_YEAR = CommonElements.weekOfYear(axis(), getDefaultWeekmodel());
    private static final WeekdayInMonthElement<PersianCalendar> WIM_ELEMENT;
    private static final int YEAR_INDEX = 0;
    @FormattableElement(format = "y")
    public static final StdCalendarElement<Integer, PersianCalendar> YEAR_OF_ERA;
    private static final long serialVersionUID = -411339992208638290L;
    /* access modifiers changed from: private */
    public final transient int pdom;
    /* access modifiers changed from: private */
    public final transient int pmonth;
    /* access modifiers changed from: private */
    public final transient int pyear;

    /* access modifiers changed from: protected */
    public PersianCalendar getContext() {
        return this;
    }

    static {
        Class<PersianCalendar> cls = PersianCalendar.class;
        StdEnumDateElement stdEnumDateElement = new StdEnumDateElement("ERA", cls, PersianEra.class, 'G');
        ERA = stdEnumDateElement;
        StdIntegerDateElement stdIntegerDateElement = new StdIntegerDateElement("YEAR_OF_ERA", PersianCalendar.class, 1, 3000, 'y', (ChronoOperator) null, (ChronoOperator) null);
        YEAR_OF_ERA = stdIntegerDateElement;
        StdEnumDateElement stdEnumDateElement2 = new StdEnumDateElement("MONTH_OF_YEAR", cls, PersianMonth.class, 'M');
        MONTH_OF_YEAR = stdEnumDateElement2;
        StdIntegerDateElement stdIntegerDateElement2 = new StdIntegerDateElement("DAY_OF_MONTH", PersianCalendar.class, 1, 31, 'd');
        DAY_OF_MONTH = stdIntegerDateElement2;
        StdIntegerDateElement stdIntegerDateElement3 = new StdIntegerDateElement("DAY_OF_YEAR", PersianCalendar.class, 1, 365, 'D');
        DAY_OF_YEAR = stdIntegerDateElement3;
        StdWeekdayElement stdWeekdayElement = new StdWeekdayElement(cls, getDefaultWeekmodel());
        DAY_OF_WEEK = stdWeekdayElement;
        WeekdayInMonthElement<PersianCalendar> weekdayInMonthElement = new WeekdayInMonthElement<>(cls, stdIntegerDateElement2, stdWeekdayElement);
        WIM_ELEMENT = weekdayInMonthElement;
        WEEKDAY_IN_MONTH = weekdayInMonthElement;
        Transformer transformer = new Transformer();
        CALSYS = transformer;
        ENGINE = TimeAxis.Builder.setUp(Unit.class, cls, new Merger(), transformer).appendElement((ChronoElement) stdEnumDateElement, (ElementRule) new EraRule()).appendElement(stdIntegerDateElement, new IntegerRule(0), Unit.YEARS).appendElement(stdEnumDateElement2, new MonthRule(), Unit.MONTHS).appendElement(stdIntegerDateElement2, new IntegerRule(2), Unit.DAYS).appendElement(stdIntegerDateElement3, new IntegerRule(3), Unit.DAYS).appendElement(stdWeekdayElement, new WeekdayRule(getDefaultWeekmodel(), new ChronoFunction<PersianCalendar, CalendarSystem<PersianCalendar>>() {
            public CalendarSystem<PersianCalendar> apply(PersianCalendar persianCalendar) {
                return PersianCalendar.CALSYS;
            }
        }), Unit.DAYS).appendElement((ChronoElement) weekdayInMonthElement, (ElementRule) WeekdayInMonthElement.getRule(weekdayInMonthElement)).appendElement((ChronoElement) CommonElements.RELATED_GREGORIAN_YEAR, (ElementRule) new RelatedGregorianYearRule(transformer, (ChronoElement<Integer>) stdIntegerDateElement3)).appendUnit(Unit.YEARS, new PersianUnitRule(Unit.YEARS), Unit.YEARS.getLength(), Collections.singleton(Unit.MONTHS)).appendUnit(Unit.MONTHS, new PersianUnitRule(Unit.MONTHS), Unit.MONTHS.getLength(), Collections.singleton(Unit.YEARS)).appendUnit(Unit.WEEKS, new PersianUnitRule(Unit.WEEKS), Unit.WEEKS.getLength(), Collections.singleton(Unit.DAYS)).appendUnit(Unit.DAYS, new PersianUnitRule(Unit.DAYS), Unit.DAYS.getLength(), Collections.singleton(Unit.WEEKS)).appendExtension((ChronoExtension) new CommonElements.Weekengine(cls, stdIntegerDateElement2, stdIntegerDateElement3, getDefaultWeekmodel())).build();
    }

    PersianCalendar(int i, int i2, int i3) {
        this.pyear = i;
        this.pmonth = i2;
        this.pdom = i3;
    }

    public static PersianCalendar of(int i, PersianMonth persianMonth, int i2) {
        return of(i, persianMonth.getValue(), i2);
    }

    public static PersianCalendar of(int i, int i2, int i3) {
        if (CALSYS.isValid(PersianEra.ANNO_PERSICO, i, i2, i3)) {
            return new PersianCalendar(i, i2, i3);
        }
        throw new IllegalArgumentException("Invalid Persian date: year=" + i + ", month=" + i2 + ", day=" + i3);
    }

    public static PersianCalendar nowInSystemTime() {
        return (PersianCalendar) SystemClock.inLocalView().now(axis());
    }

    public PersianEra getEra() {
        return PersianEra.ANNO_PERSICO;
    }

    public int getYear() {
        return this.pyear;
    }

    public PersianMonth getMonth() {
        return PersianMonth.valueOf(this.pmonth);
    }

    public int getDayOfMonth() {
        return this.pdom;
    }

    public Weekday getDayOfWeek() {
        return Weekday.valueOf(MathUtils.floorModulo(CALSYS.transform(this) + 5, 7) + 1);
    }

    public int getDayOfYear() {
        return ((Integer) get(DAY_OF_YEAR)).intValue();
    }

    public Date getDate(PersianAlgorithm persianAlgorithm) {
        ZonalOffset zonalOffset = PersianAlgorithm.STD_OFFSET;
        PersianAlgorithm persianAlgorithm2 = DEFAULT_COMPUTATION;
        if (persianAlgorithm == persianAlgorithm2) {
            return new Date(persianAlgorithm2, zonalOffset);
        }
        return new Date(persianAlgorithm, zonalOffset);
    }

    public Date getDate(ZonalOffset zonalOffset) {
        Objects.requireNonNull(zonalOffset, "Missing timezone offset.");
        PersianAlgorithm persianAlgorithm = PersianAlgorithm.ASTRONOMICAL;
        return new Date(persianAlgorithm, zonalOffset);
    }

    public int lengthOfMonth() {
        return CALSYS.getLengthOfMonth(PersianEra.ANNO_PERSICO, this.pyear, this.pmonth);
    }

    public int lengthOfYear() {
        return CALSYS.getLengthOfYear(PersianEra.ANNO_PERSICO, this.pyear);
    }

    public boolean isLeapYear() {
        return lengthOfYear() > 365;
    }

    public static boolean isValid(int i, int i2, int i3) {
        return CALSYS.isValid(PersianEra.ANNO_PERSICO, i, i2, i3);
    }

    public GeneralTimestamp<PersianCalendar> at(PlainTime plainTime) {
        return GeneralTimestamp.of(this, plainTime);
    }

    public GeneralTimestamp<PersianCalendar> atTime(int i, int i2) {
        return at(PlainTime.of(i, i2));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PersianCalendar)) {
            return false;
        }
        PersianCalendar persianCalendar = (PersianCalendar) obj;
        if (this.pdom == persianCalendar.pdom && this.pmonth == persianCalendar.pmonth && this.pyear == persianCalendar.pyear) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.pdom * 17) + (this.pmonth * 31) + (this.pyear * 37);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("AP-");
        String valueOf = String.valueOf(this.pyear);
        for (int length = valueOf.length(); length < 4; length++) {
            sb.append('0');
        }
        sb.append(valueOf);
        sb.append(SignatureVisitor.SUPER);
        if (this.pmonth < 10) {
            sb.append('0');
        }
        sb.append(this.pmonth);
        sb.append(SignatureVisitor.SUPER);
        if (this.pdom < 10) {
            sb.append('0');
        }
        sb.append(this.pdom);
        return sb.toString();
    }

    public static Weekmodel getDefaultWeekmodel() {
        return Weekmodel.of(Weekday.SATURDAY, 1, Weekday.FRIDAY, Weekday.FRIDAY);
    }

    public static TimeAxis<Unit, PersianCalendar> axis() {
        return ENGINE;
    }

    /* access modifiers changed from: protected */
    public TimeAxis<Unit, PersianCalendar> getChronology() {
        return ENGINE;
    }

    private Object writeReplace() {
        return new SPX(this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    public enum Unit implements ChronoUnit {
        YEARS(3.155694336E7d),
        MONTHS(2629745.28d),
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

        public int between(PersianCalendar persianCalendar, PersianCalendar persianCalendar2) {
            return (int) persianCalendar.until(persianCalendar2, this);
        }
    }

    public static final class Date implements ChronoDisplay {
        private final PersianAlgorithm algorithm;
        private final PersianCalendar delegate;
        private final ZonalOffset offset;

        private Date(PersianCalendar persianCalendar, PersianAlgorithm persianAlgorithm, ZonalOffset zonalOffset) {
            this.delegate = persianCalendar;
            this.algorithm = persianAlgorithm;
            this.offset = zonalOffset;
        }

        public boolean contains(ChronoElement<?> chronoElement) {
            return PersianCalendar.ENGINE.isRegistered(chronoElement);
        }

        public <V> V get(ChronoElement<V> chronoElement) {
            int i = 1;
            if (chronoElement == PersianCalendar.DAY_OF_WEEK) {
                return chronoElement.getType().cast(Weekday.valueOf(MathUtils.floorModulo(this.algorithm.transform(this.delegate, this.offset) + 5, 7) + 1));
            } else if (chronoElement == PersianCalendar.DAY_OF_YEAR) {
                int i2 = 0;
                while (i < this.delegate.pmonth) {
                    i2 = i <= 6 ? i2 + 31 : i2 + 30;
                    i++;
                }
                return chronoElement.getType().cast(Integer.valueOf(i2 + this.delegate.pdom));
            } else if (chronoElement == PersianCalendar.WEEKDAY_IN_MONTH) {
                return chronoElement.getType().cast(Integer.valueOf(MathUtils.floorDivide(this.delegate.pdom - 1, 7) + 1));
            } else {
                if (chronoElement == CommonElements.RELATED_GREGORIAN_YEAR) {
                    return chronoElement.getType().cast(Integer.valueOf(this.delegate.getYear() + 621));
                }
                if (chronoElement instanceof EpochDays) {
                    return chronoElement.getType().cast(Long.valueOf(EpochDays.class.cast(chronoElement).transform(this.algorithm.transform(this.delegate, this.offset), EpochDays.UTC)));
                } else if (PersianCalendar.ENGINE.isRegistered(chronoElement)) {
                    return this.delegate.get(chronoElement);
                } else {
                    throw new ChronoException("Persian dates only support registered elements.");
                }
            }
        }

        public int getInt(ChronoElement<Integer> chronoElement) {
            if (chronoElement == PersianCalendar.DAY_OF_MONTH) {
                return this.delegate.pdom;
            }
            if (chronoElement == PersianCalendar.YEAR_OF_ERA) {
                return this.delegate.pyear;
            }
            int i = 1;
            if (chronoElement == PersianCalendar.DAY_OF_YEAR) {
                int i2 = 0;
                while (i < this.delegate.pmonth) {
                    i2 = i <= 6 ? i2 + 31 : i2 + 30;
                    i++;
                }
                return i2 + this.delegate.pdom;
            } else if (chronoElement == PersianCalendar.WEEKDAY_IN_MONTH) {
                return MathUtils.floorDivide(this.delegate.pdom - 1, 7) + 1;
            } else {
                if (chronoElement == CommonElements.RELATED_GREGORIAN_YEAR) {
                    return this.delegate.getYear() + 621;
                }
                if (PersianCalendar.ENGINE.isRegistered(chronoElement)) {
                    return this.delegate.getInt(chronoElement);
                }
                return Integer.MIN_VALUE;
            }
        }

        public <V> V getMinimum(ChronoElement<V> chronoElement) {
            if (PersianCalendar.ENGINE.isRegistered(chronoElement)) {
                return this.delegate.getMinimum(chronoElement);
            }
            throw new ChronoException("Persian dates only support registered elements.");
        }

        public <V> V getMaximum(ChronoElement<V> chronoElement) {
            if (chronoElement == PersianCalendar.DAY_OF_MONTH) {
                int access$700 = this.delegate.pmonth;
                int i = 30;
                if (access$700 <= 6) {
                    i = 31;
                } else if (access$700 > 11 && !this.algorithm.isLeapYear(this.delegate.pyear, this.offset)) {
                    i = 29;
                }
                return chronoElement.getType().cast(Integer.valueOf(i));
            } else if (chronoElement == PersianCalendar.DAY_OF_YEAR) {
                return chronoElement.getType().cast(Integer.valueOf(this.algorithm.isLeapYear(this.delegate.pyear, this.offset) ? 366 : 365));
            } else if (chronoElement == PersianCalendar.WEEKDAY_IN_MONTH) {
                int access$800 = this.delegate.pdom;
                while (true) {
                    int i2 = access$800 + 7;
                    if (i2 > ((Integer) getMaximum(PersianCalendar.DAY_OF_MONTH)).intValue()) {
                        return chronoElement.getType().cast(Integer.valueOf(MathUtils.floorDivide(access$800 - 1, 7) + 1));
                    }
                    access$800 = i2;
                }
            } else if (PersianCalendar.ENGINE.isRegistered(chronoElement)) {
                return this.delegate.getMaximum(chronoElement);
            } else {
                throw new ChronoException("Persian dates only support registered elements.");
            }
        }

        public boolean hasTimezone() {
            return this.algorithm == PersianAlgorithm.ASTRONOMICAL;
        }

        public ZonalOffset getTimezone() {
            if (hasTimezone()) {
                return this.offset;
            }
            throw new ChronoException("Timezone offset not defined.");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Date)) {
                return false;
            }
            Date date = (Date) obj;
            PersianAlgorithm persianAlgorithm = this.algorithm;
            if (persianAlgorithm != date.algorithm) {
                return false;
            }
            if (persianAlgorithm != PersianAlgorithm.ASTRONOMICAL || this.offset.equals(date.offset)) {
                return this.delegate.equals(date.delegate);
            }
            return false;
        }

        public int hashCode() {
            return (this.delegate.hashCode() * 7) + (this.algorithm.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.delegate);
            sb.append(AbstractJsonLexerKt.BEGIN_LIST);
            sb.append(this.algorithm);
            if (this.algorithm == PersianAlgorithm.ASTRONOMICAL) {
                sb.append(this.offset.toString());
            }
            sb.append(AbstractJsonLexerKt.END_LIST);
            return sb.toString();
        }
    }

    private static class Transformer implements EraYearMonthDaySystem<PersianCalendar> {
        private Transformer() {
        }

        public boolean isValid(CalendarEra calendarEra, int i, int i2, int i3) {
            if (calendarEra != PersianEra.ANNO_PERSICO || i < 1 || i > 3000 || i2 < 1 || i2 > 12 || i3 < 1 || i3 > getLengthOfMonth(calendarEra, i, i2)) {
                return false;
            }
            return true;
        }

        public int getLengthOfMonth(CalendarEra calendarEra, int i, int i2) {
            if (calendarEra != PersianEra.ANNO_PERSICO) {
                throw new IllegalArgumentException("Invalid era: " + calendarEra);
            } else if (calendarEra != PersianEra.ANNO_PERSICO || i < 1 || i > 3000 || i2 < 1 || i2 > 12) {
                throw new IllegalArgumentException("Out of bounds: year=" + i + ", month=" + i2);
            } else if (i2 <= 6) {
                return 31;
            } else {
                return (i2 > 11 && getLengthOfYear(calendarEra, i) == 365) ? 29 : 30;
            }
        }

        public int getLengthOfYear(CalendarEra calendarEra, int i) {
            if (calendarEra == PersianEra.ANNO_PERSICO) {
                return PersianCalendar.DEFAULT_COMPUTATION.isLeapYear(i) ? 366 : 365;
            }
            throw new IllegalArgumentException("Invalid era: " + calendarEra);
        }

        public PersianCalendar transform(long j) {
            return PersianCalendar.DEFAULT_COMPUTATION.transform(j, PersianAlgorithm.STD_OFFSET);
        }

        public long transform(PersianCalendar persianCalendar) {
            return PersianCalendar.DEFAULT_COMPUTATION.transform(persianCalendar, PersianAlgorithm.STD_OFFSET);
        }

        public long getMinimumSinceUTC() {
            return transform(new PersianCalendar(1, 1, 1));
        }

        public long getMaximumSinceUTC() {
            return transform(new PersianCalendar(3001, 1, 1)) - 1;
        }

        public List<CalendarEra> getEras() {
            return Collections.singletonList(PersianEra.ANNO_PERSICO);
        }
    }

    private static class IntegerRule implements ElementRule<PersianCalendar, Integer> {
        private final int index;

        IntegerRule(int i) {
            this.index = i;
        }

        public Integer getValue(PersianCalendar persianCalendar) {
            int i = this.index;
            if (i == 0) {
                return Integer.valueOf(persianCalendar.pyear);
            }
            if (i == 2) {
                return Integer.valueOf(persianCalendar.pdom);
            }
            if (i == 3) {
                int i2 = 0;
                for (int i3 = 1; i3 < persianCalendar.pmonth; i3++) {
                    i2 += PersianCalendar.CALSYS.getLengthOfMonth(PersianEra.ANNO_PERSICO, persianCalendar.pyear, i3);
                }
                return Integer.valueOf(i2 + persianCalendar.pdom);
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public Integer getMinimum(PersianCalendar persianCalendar) {
            int i = this.index;
            if (i == 0 || i == 2 || i == 3) {
                return 1;
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public Integer getMaximum(PersianCalendar persianCalendar) {
            int i = this.index;
            if (i == 0) {
                return 3000;
            }
            if (i == 2) {
                return Integer.valueOf(PersianCalendar.CALSYS.getLengthOfMonth(PersianEra.ANNO_PERSICO, persianCalendar.pyear, persianCalendar.pmonth));
            }
            if (i == 3) {
                return Integer.valueOf(PersianCalendar.CALSYS.getLengthOfYear(PersianEra.ANNO_PERSICO, persianCalendar.pyear));
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public boolean isValid(PersianCalendar persianCalendar, Integer num) {
            if (num == null) {
                return false;
            }
            Integer minimum = getMinimum(persianCalendar);
            Integer maximum = getMaximum(persianCalendar);
            if (minimum.compareTo(num) > 0 || maximum.compareTo(num) < 0) {
                return false;
            }
            return true;
        }

        public PersianCalendar withValue(PersianCalendar persianCalendar, Integer num, boolean z) {
            if (isValid(persianCalendar, num)) {
                int i = this.index;
                if (i == 0) {
                    int intValue = num.intValue();
                    return PersianCalendar.of(intValue, persianCalendar.pmonth, Math.min(persianCalendar.pdom, PersianCalendar.CALSYS.getLengthOfMonth(PersianEra.ANNO_PERSICO, intValue, persianCalendar.pmonth)));
                } else if (i == 2) {
                    return new PersianCalendar(persianCalendar.pyear, persianCalendar.pmonth, num.intValue());
                } else {
                    if (i == 3) {
                        return (PersianCalendar) persianCalendar.plus(CalendarDays.of((long) (num.intValue() - getValue(persianCalendar).intValue())));
                    }
                    throw new UnsupportedOperationException("Unknown element index: " + this.index);
                }
            } else {
                throw new IllegalArgumentException("Out of range: " + num);
            }
        }

        public ChronoElement<?> getChildAtFloor(PersianCalendar persianCalendar) {
            if (this.index == 0) {
                return PersianCalendar.MONTH_OF_YEAR;
            }
            return null;
        }

        public ChronoElement<?> getChildAtCeiling(PersianCalendar persianCalendar) {
            if (this.index == 0) {
                return PersianCalendar.MONTH_OF_YEAR;
            }
            return null;
        }
    }

    private static class MonthRule implements ElementRule<PersianCalendar, PersianMonth> {
        public boolean isValid(PersianCalendar persianCalendar, PersianMonth persianMonth) {
            return persianMonth != null;
        }

        private MonthRule() {
        }

        public PersianMonth getValue(PersianCalendar persianCalendar) {
            return persianCalendar.getMonth();
        }

        public PersianMonth getMinimum(PersianCalendar persianCalendar) {
            return PersianMonth.FARVARDIN;
        }

        public PersianMonth getMaximum(PersianCalendar persianCalendar) {
            return PersianMonth.ESFAND;
        }

        public PersianCalendar withValue(PersianCalendar persianCalendar, PersianMonth persianMonth, boolean z) {
            if (persianMonth != null) {
                int value = persianMonth.getValue();
                return new PersianCalendar(persianCalendar.pyear, value, Math.min(persianCalendar.pdom, PersianCalendar.CALSYS.getLengthOfMonth(PersianEra.ANNO_PERSICO, persianCalendar.pyear, value)));
            }
            throw new IllegalArgumentException("Missing month.");
        }

        public ChronoElement<?> getChildAtFloor(PersianCalendar persianCalendar) {
            return PersianCalendar.DAY_OF_MONTH;
        }

        public ChronoElement<?> getChildAtCeiling(PersianCalendar persianCalendar) {
            return PersianCalendar.DAY_OF_MONTH;
        }
    }

    private static class EraRule implements ElementRule<PersianCalendar, PersianEra> {
        public boolean isValid(PersianCalendar persianCalendar, PersianEra persianEra) {
            return persianEra != null;
        }

        private EraRule() {
        }

        public PersianEra getValue(PersianCalendar persianCalendar) {
            return PersianEra.ANNO_PERSICO;
        }

        public PersianEra getMinimum(PersianCalendar persianCalendar) {
            return PersianEra.ANNO_PERSICO;
        }

        public PersianEra getMaximum(PersianCalendar persianCalendar) {
            return PersianEra.ANNO_PERSICO;
        }

        public PersianCalendar withValue(PersianCalendar persianCalendar, PersianEra persianEra, boolean z) {
            if (persianEra != null) {
                return persianCalendar;
            }
            throw new IllegalArgumentException("Missing era value.");
        }

        public ChronoElement<?> getChildAtFloor(PersianCalendar persianCalendar) {
            return PersianCalendar.YEAR_OF_ERA;
        }

        public ChronoElement<?> getChildAtCeiling(PersianCalendar persianCalendar) {
            return PersianCalendar.YEAR_OF_ERA;
        }
    }

    private static class Merger implements ChronoMerger<PersianCalendar> {
        public Chronology<?> preparser() {
            return null;
        }

        private Merger() {
        }

        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            return GenericDatePatterns.get("persian", displayStyle, locale);
        }

        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.MIDNIGHT;
        }

        public int getDefaultPivotYear() {
            return PlainDate.axis().getDefaultPivotYear() - 621;
        }

        /* JADX WARNING: type inference failed for: r4v0, types: [net.time4j.base.TimeSource, net.time4j.base.TimeSource<?>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.calendar.PersianCalendar createFrom(net.time4j.base.TimeSource<?> r4, net.time4j.engine.AttributeQuery r5) {
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
                net.time4j.engine.TimeAxis r1 = net.time4j.calendar.PersianCalendar.ENGINE
                net.time4j.GeneralTimestamp r4 = r4.toGeneralTimestamp(r1, r0, r5)
                java.lang.Object r4 = r4.toDate()
                net.time4j.calendar.PersianCalendar r4 = (net.time4j.calendar.PersianCalendar) r4
                return r4
            L_0x004c:
                r4 = 0
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.PersianCalendar.Merger.createFrom(net.time4j.base.TimeSource, net.time4j.engine.AttributeQuery):net.time4j.calendar.PersianCalendar");
        }

        /* JADX WARNING: type inference failed for: r9v15, types: [net.time4j.tz.TZID] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.calendar.PersianCalendar createFrom(net.time4j.engine.ChronoEntity<?> r8, net.time4j.engine.AttributeQuery r9, boolean r10, boolean r11) {
            /*
                r7 = this;
                net.time4j.calendar.StdCalendarElement<java.lang.Integer, net.time4j.calendar.PersianCalendar> r10 = net.time4j.calendar.PersianCalendar.YEAR_OF_ERA
                int r10 = r8.getInt(r10)
                r11 = 0
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                if (r10 != r0) goto L_0x0013
                net.time4j.engine.ValidationElement r9 = net.time4j.engine.ValidationElement.ERROR_MESSAGE
                java.lang.String r10 = "Missing Persian year."
                r8.with(r9, r10)
                return r11
            L_0x0013:
                net.time4j.engine.AttributeKey r1 = net.time4j.calendar.PersianAlgorithm.attribute()
                net.time4j.calendar.PersianAlgorithm r2 = net.time4j.calendar.PersianCalendar.DEFAULT_COMPUTATION
                java.lang.Object r1 = r9.get(r1, r2)
                net.time4j.calendar.PersianAlgorithm r1 = (net.time4j.calendar.PersianAlgorithm) r1
                net.time4j.tz.ZonalOffset r2 = net.time4j.calendar.PersianAlgorithm.STD_OFFSET
                net.time4j.calendar.PersianAlgorithm r3 = net.time4j.calendar.PersianAlgorithm.ASTRONOMICAL
                if (r1 != r3) goto L_0x003e
                net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r3 = net.time4j.format.Attributes.TIMEZONE_ID
                boolean r3 = r9.contains(r3)
                if (r3 == 0) goto L_0x003e
                net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r3 = net.time4j.format.Attributes.TIMEZONE_ID
                java.lang.Object r9 = r9.get(r3)
                net.time4j.tz.TZID r9 = (net.time4j.tz.TZID) r9
                boolean r3 = r9 instanceof net.time4j.tz.ZonalOffset
                if (r3 == 0) goto L_0x003e
                r2 = r9
                net.time4j.tz.ZonalOffset r2 = (net.time4j.tz.ZonalOffset) r2
            L_0x003e:
                net.time4j.calendar.StdCalendarElement<net.time4j.calendar.PersianMonth, net.time4j.calendar.PersianCalendar> r9 = net.time4j.calendar.PersianCalendar.MONTH_OF_YEAR
                boolean r9 = r8.contains(r9)
                java.lang.String r3 = "Invalid Persian date."
                if (r9 == 0) goto L_0x0082
                net.time4j.calendar.StdCalendarElement<net.time4j.calendar.PersianMonth, net.time4j.calendar.PersianCalendar> r9 = net.time4j.calendar.PersianCalendar.MONTH_OF_YEAR
                java.lang.Object r9 = r8.get(r9)
                net.time4j.calendar.PersianMonth r9 = (net.time4j.calendar.PersianMonth) r9
                int r9 = r9.getValue()
                net.time4j.calendar.StdCalendarElement<java.lang.Integer, net.time4j.calendar.PersianCalendar> r4 = net.time4j.calendar.PersianCalendar.DAY_OF_MONTH
                int r4 = r8.getInt(r4)
                if (r4 == r0) goto L_0x00d8
                boolean r0 = r1.isValid(r10, r9, r4, r2)
                if (r0 == 0) goto L_0x007c
                net.time4j.calendar.PersianCalendar r8 = new net.time4j.calendar.PersianCalendar
                r8.<init>(r10, r9, r4)
                net.time4j.calendar.PersianAlgorithm r9 = net.time4j.calendar.PersianCalendar.DEFAULT_COMPUTATION
                if (r1 == r9) goto L_0x007b
                long r8 = r1.transform((net.time4j.calendar.PersianCalendar) r8, (net.time4j.tz.ZonalOffset) r2)
                net.time4j.calendar.PersianAlgorithm r10 = net.time4j.calendar.PersianCalendar.DEFAULT_COMPUTATION
                net.time4j.tz.ZonalOffset r11 = net.time4j.calendar.PersianAlgorithm.STD_OFFSET
                net.time4j.calendar.PersianCalendar r8 = r10.transform((long) r8, (net.time4j.tz.ZonalOffset) r11)
            L_0x007b:
                return r8
            L_0x007c:
                net.time4j.engine.ValidationElement r9 = net.time4j.engine.ValidationElement.ERROR_MESSAGE
                r8.with(r9, r3)
                goto L_0x00d8
            L_0x0082:
                net.time4j.calendar.StdCalendarElement<java.lang.Integer, net.time4j.calendar.PersianCalendar> r9 = net.time4j.calendar.PersianCalendar.DAY_OF_YEAR
                int r9 = r8.getInt(r9)
                if (r9 == r0) goto L_0x00d8
                if (r9 <= 0) goto L_0x00d3
                r0 = 0
                r4 = 1
            L_0x008e:
                r5 = 12
                if (r4 > r5) goto L_0x00d3
                r5 = 6
                r6 = 30
                if (r4 > r5) goto L_0x009a
                r6 = 31
                goto L_0x00aa
            L_0x009a:
                r5 = 11
                if (r4 > r5) goto L_0x009f
                goto L_0x00aa
            L_0x009f:
                boolean r5 = r1.isLeapYear(r10, r2)
                if (r5 == 0) goto L_0x00a6
                goto L_0x00aa
            L_0x00a6:
                r5 = 29
                r6 = 29
            L_0x00aa:
                int r5 = r0 + r6
                if (r9 <= r5) goto L_0x00b2
                int r4 = r4 + 1
                r0 = r5
                goto L_0x008e
            L_0x00b2:
                int r9 = r9 - r0
                boolean r0 = r1.isValid(r10, r4, r9, r2)
                if (r0 == 0) goto L_0x00d3
                net.time4j.calendar.PersianCalendar r8 = new net.time4j.calendar.PersianCalendar
                r8.<init>(r10, r4, r9)
                net.time4j.calendar.PersianAlgorithm r9 = net.time4j.calendar.PersianCalendar.DEFAULT_COMPUTATION
                if (r1 == r9) goto L_0x00d2
                long r8 = r1.transform((net.time4j.calendar.PersianCalendar) r8, (net.time4j.tz.ZonalOffset) r2)
                net.time4j.calendar.PersianAlgorithm r10 = net.time4j.calendar.PersianCalendar.DEFAULT_COMPUTATION
                net.time4j.tz.ZonalOffset r11 = net.time4j.calendar.PersianAlgorithm.STD_OFFSET
                net.time4j.calendar.PersianCalendar r8 = r10.transform((long) r8, (net.time4j.tz.ZonalOffset) r11)
            L_0x00d2:
                return r8
            L_0x00d3:
                net.time4j.engine.ValidationElement r9 = net.time4j.engine.ValidationElement.ERROR_MESSAGE
                r8.with(r9, r3)
            L_0x00d8:
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.PersianCalendar.Merger.createFrom(net.time4j.engine.ChronoEntity, net.time4j.engine.AttributeQuery, boolean, boolean):net.time4j.calendar.PersianCalendar");
        }

        /* JADX WARNING: type inference failed for: r4v2, types: [net.time4j.tz.TZID] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.engine.ChronoDisplay preformat(net.time4j.calendar.PersianCalendar r3, net.time4j.engine.AttributeQuery r4) {
            /*
                r2 = this;
                net.time4j.engine.AttributeKey r0 = net.time4j.calendar.PersianAlgorithm.attribute()
                net.time4j.calendar.PersianAlgorithm r1 = net.time4j.calendar.PersianCalendar.DEFAULT_COMPUTATION
                java.lang.Object r0 = r4.get(r0, r1)
                net.time4j.calendar.PersianAlgorithm r0 = (net.time4j.calendar.PersianAlgorithm) r0
                net.time4j.calendar.PersianAlgorithm r1 = net.time4j.calendar.PersianCalendar.DEFAULT_COMPUTATION
                if (r0 != r1) goto L_0x0015
                return r3
            L_0x0015:
                net.time4j.calendar.PersianAlgorithm r1 = net.time4j.calendar.PersianAlgorithm.ASTRONOMICAL
                if (r0 != r1) goto L_0x0037
                net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r1 = net.time4j.format.Attributes.TIMEZONE_ID
                boolean r1 = r4.contains(r1)
                if (r1 == 0) goto L_0x0037
                net.time4j.tz.ZonalOffset r0 = net.time4j.calendar.PersianAlgorithm.STD_OFFSET
                net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r1 = net.time4j.format.Attributes.TIMEZONE_ID
                java.lang.Object r4 = r4.get(r1)
                net.time4j.tz.TZID r4 = (net.time4j.tz.TZID) r4
                boolean r1 = r4 instanceof net.time4j.tz.ZonalOffset
                if (r1 == 0) goto L_0x0032
                r0 = r4
                net.time4j.tz.ZonalOffset r0 = (net.time4j.tz.ZonalOffset) r0
            L_0x0032:
                net.time4j.calendar.PersianCalendar$Date r3 = r3.getDate((net.time4j.tz.ZonalOffset) r0)
                return r3
            L_0x0037:
                net.time4j.calendar.PersianCalendar$Date r3 = r3.getDate((net.time4j.calendar.PersianAlgorithm) r0)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.PersianCalendar.Merger.preformat(net.time4j.calendar.PersianCalendar, net.time4j.engine.AttributeQuery):net.time4j.engine.ChronoDisplay");
        }
    }

    private static class PersianUnitRule implements UnitRule<PersianCalendar> {
        private final Unit unit;

        PersianUnitRule(Unit unit2) {
            this.unit = unit2;
        }

        public PersianCalendar addTo(PersianCalendar persianCalendar, long j) {
            int i = AnonymousClass2.$SwitchMap$net$time4j$calendar$PersianCalendar$Unit[this.unit.ordinal()];
            if (i == 1) {
                j = MathUtils.safeMultiply(j, 12);
            } else if (i != 2) {
                if (i == 3) {
                    j = MathUtils.safeMultiply(j, 7);
                } else if (i != 4) {
                    throw new UnsupportedOperationException(this.unit.name());
                }
                return (PersianCalendar) PersianCalendar.CALSYS.transform(MathUtils.safeAdd(PersianCalendar.CALSYS.transform(persianCalendar), j));
            }
            long safeAdd = MathUtils.safeAdd((long) ymValue(persianCalendar), j);
            int safeCast = MathUtils.safeCast(MathUtils.floorDivide(safeAdd, 12));
            int floorModulo = MathUtils.floorModulo(safeAdd, 12) + 1;
            return PersianCalendar.of(safeCast, floorModulo, Math.min(persianCalendar.pdom, PersianCalendar.CALSYS.getLengthOfMonth(PersianEra.ANNO_PERSICO, safeCast, floorModulo)));
        }

        public long between(PersianCalendar persianCalendar, PersianCalendar persianCalendar2) {
            int between;
            int i = AnonymousClass2.$SwitchMap$net$time4j$calendar$PersianCalendar$Unit[this.unit.ordinal()];
            if (i == 1) {
                between = Unit.MONTHS.between(persianCalendar, persianCalendar2) / 12;
            } else if (i == 2) {
                long ymValue = (long) (ymValue(persianCalendar2) - ymValue(persianCalendar));
                int i2 = (ymValue > 0 ? 1 : (ymValue == 0 ? 0 : -1));
                if (i2 <= 0 || persianCalendar2.pdom >= persianCalendar.pdom) {
                    return (i2 >= 0 || persianCalendar2.pdom <= persianCalendar.pdom) ? ymValue : ymValue + 1;
                }
                return ymValue - 1;
            } else if (i == 3) {
                between = Unit.DAYS.between(persianCalendar, persianCalendar2) / 7;
            } else if (i == 4) {
                return PersianCalendar.CALSYS.transform(persianCalendar2) - PersianCalendar.CALSYS.transform(persianCalendar);
            } else {
                throw new UnsupportedOperationException(this.unit.name());
            }
            return (long) between;
        }

        private static int ymValue(PersianCalendar persianCalendar) {
            return ((persianCalendar.pyear * 12) + persianCalendar.pmonth) - 1;
        }
    }

    /* renamed from: net.time4j.calendar.PersianCalendar$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$calendar$PersianCalendar$Unit;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                net.time4j.calendar.PersianCalendar$Unit[] r0 = net.time4j.calendar.PersianCalendar.Unit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$calendar$PersianCalendar$Unit = r0
                net.time4j.calendar.PersianCalendar$Unit r1 = net.time4j.calendar.PersianCalendar.Unit.YEARS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$calendar$PersianCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.calendar.PersianCalendar$Unit r1 = net.time4j.calendar.PersianCalendar.Unit.MONTHS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$calendar$PersianCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.calendar.PersianCalendar$Unit r1 = net.time4j.calendar.PersianCalendar.Unit.WEEKS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$net$time4j$calendar$PersianCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.calendar.PersianCalendar$Unit r1 = net.time4j.calendar.PersianCalendar.Unit.DAYS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.PersianCalendar.AnonymousClass2.<clinit>():void");
        }
    }

    private static class SPX implements Externalizable {
        private static final int PERSIAN = 2;
        private static final long serialVersionUID = 1;
        private transient Object obj;

        public SPX() {
        }

        SPX(Object obj2) {
            this.obj = obj2;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeByte(2);
            writePersian(objectOutput);
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            if (objectInput.readByte() == 2) {
                this.obj = readPersian(objectInput);
                return;
            }
            throw new InvalidObjectException("Unknown calendar type.");
        }

        private Object readResolve() throws ObjectStreamException {
            return this.obj;
        }

        private void writePersian(ObjectOutput objectOutput) throws IOException {
            PersianCalendar persianCalendar = (PersianCalendar) this.obj;
            objectOutput.writeInt(persianCalendar.getYear());
            objectOutput.writeByte(persianCalendar.getMonth().getValue());
            objectOutput.writeByte(persianCalendar.getDayOfMonth());
        }

        private PersianCalendar readPersian(ObjectInput objectInput) throws IOException {
            return PersianCalendar.of(objectInput.readInt(), (int) objectInput.readByte(), (int) objectInput.readByte());
        }
    }
}
