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
import net.time4j.base.MathUtils;
import net.time4j.calendar.CommonElements;
import net.time4j.calendar.HebrewMonth;
import net.time4j.calendar.service.GenericDatePatterns;
import net.time4j.calendar.service.StdEnumDateElement;
import net.time4j.calendar.service.StdIntegerDateElement;
import net.time4j.calendar.service.StdWeekdayElement;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.CalendarDate;
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
import net.time4j.tz.Timezone;

@CalendarType("hebrew")
public final class HebrewCalendar extends Calendrical<Unit, HebrewCalendar> implements LocalizedPatternSupport {
    public static final StdCalendarElement<Integer, HebrewCalendar> BOUNDED_WEEK_OF_MONTH = CommonElements.boundedWeekOfMonth(axis(), getDefaultWeekmodel());
    public static final StdCalendarElement<Integer, HebrewCalendar> BOUNDED_WEEK_OF_YEAR = CommonElements.boundedWeekOfYear(axis(), getDefaultWeekmodel());
    /* access modifiers changed from: private */
    public static final EraYearMonthDaySystem<HebrewCalendar> CALSYS;
    @FormattableElement(format = "d")
    public static final StdCalendarElement<Integer, HebrewCalendar> DAY_OF_MONTH;
    private static final int DAY_OF_MONTH_INDEX = 2;
    @FormattableElement(format = "E")
    public static final StdCalendarElement<Weekday, HebrewCalendar> DAY_OF_WEEK;
    @FormattableElement(format = "D")
    public static final StdCalendarElement<Integer, HebrewCalendar> DAY_OF_YEAR;
    private static final int DAY_OF_YEAR_INDEX = 3;
    /* access modifiers changed from: private */
    public static final TimeAxis<Unit, HebrewCalendar> ENGINE;
    @FormattableElement(format = "G")
    public static final ChronoElement<HebrewEra> ERA;
    /* access modifiers changed from: private */
    public static final long FIXED_EPOCH = ((Long) PlainDate.of(-3760, 9, 7).get(EpochDays.RATA_DIE)).longValue();
    public static final StdCalendarElement<Weekday, HebrewCalendar> LOCAL_DAY_OF_WEEK = CommonElements.localDayOfWeek(axis(), getDefaultWeekmodel());
    @FormattableElement(alt = "L", format = "M")
    public static final StdCalendarElement<HebrewMonth, HebrewCalendar> MONTH_OF_YEAR;
    @FormattableElement(format = "F")
    public static final OrdinalWeekdayElement<HebrewCalendar> WEEKDAY_IN_MONTH;
    public static final StdCalendarElement<Integer, HebrewCalendar> WEEK_OF_MONTH = CommonElements.weekOfMonth(axis(), getDefaultWeekmodel());
    public static final StdCalendarElement<Integer, HebrewCalendar> WEEK_OF_YEAR = CommonElements.weekOfYear(axis(), getDefaultWeekmodel());
    private static final WeekdayInMonthElement<HebrewCalendar> WIM_ELEMENT;
    private static final int YEAR_INDEX = 0;
    @FormattableElement(format = "y")
    public static final StdCalendarElement<Integer, HebrewCalendar> YEAR_OF_ERA;
    private static final long serialVersionUID = -4183006723190472312L;
    /* access modifiers changed from: private */
    public final transient int dom;
    /* access modifiers changed from: private */
    public final transient HebrewMonth month;
    /* access modifiers changed from: private */
    public final transient int year;

    /* access modifiers changed from: protected */
    public HebrewCalendar getContext() {
        return this;
    }

    static {
        Class<HebrewCalendar> cls = HebrewCalendar.class;
        StdEnumDateElement stdEnumDateElement = new StdEnumDateElement("ERA", cls, HebrewEra.class, 'G');
        ERA = stdEnumDateElement;
        StdIntegerDateElement stdIntegerDateElement = new StdIntegerDateElement("YEAR_OF_ERA", HebrewCalendar.class, 1, 9999, 'y', (ChronoOperator) null, (ChronoOperator) null);
        YEAR_OF_ERA = stdIntegerDateElement;
        AnonymousClass1 r3 = new StdEnumDateElement<HebrewMonth, HebrewCalendar>("MONTH_OF_YEAR", cls, HebrewMonth.class, 'M') {
            /* access modifiers changed from: protected */
            public boolean hasLeapMonth(ChronoDisplay chronoDisplay) {
                return HebrewCalendar.isLeapYear(chronoDisplay.getInt(HebrewCalendar.YEAR_OF_ERA));
            }

            public int printToInt(HebrewMonth hebrewMonth, ChronoDisplay chronoDisplay, AttributeQuery attributeQuery) {
                int i = AnonymousClass3.$SwitchMap$net$time4j$calendar$HebrewMonth$Order[((HebrewMonth.Order) attributeQuery.get(HebrewMonth.order(), HebrewMonth.Order.CIVIL)).ordinal()];
                if (i == 1) {
                    return hebrewMonth.getCivilValue(hasLeapMonth(chronoDisplay));
                }
                if (i != 2) {
                    return numerical(hebrewMonth);
                }
                return hebrewMonth.getBiblicalValue(hasLeapMonth(chronoDisplay));
            }

            public boolean parseFromInt(ChronoEntity<?> chronoEntity, int i) {
                if (i < 1 || i > 13) {
                    return false;
                }
                chronoEntity.with((ChronoElement<Integer>) ParsedMonthElement.INSTANCE, i);
                return true;
            }
        };
        MONTH_OF_YEAR = r3;
        StdIntegerDateElement stdIntegerDateElement2 = new StdIntegerDateElement("DAY_OF_MONTH", HebrewCalendar.class, 1, 30, 'd');
        DAY_OF_MONTH = stdIntegerDateElement2;
        StdIntegerDateElement stdIntegerDateElement3 = new StdIntegerDateElement("DAY_OF_YEAR", HebrewCalendar.class, 1, 355, 'D');
        DAY_OF_YEAR = stdIntegerDateElement3;
        StdWeekdayElement stdWeekdayElement = new StdWeekdayElement(cls, getDefaultWeekmodel());
        DAY_OF_WEEK = stdWeekdayElement;
        WeekdayInMonthElement<HebrewCalendar> weekdayInMonthElement = new WeekdayInMonthElement<>(cls, stdIntegerDateElement2, stdWeekdayElement);
        WIM_ELEMENT = weekdayInMonthElement;
        WEEKDAY_IN_MONTH = weekdayInMonthElement;
        Transformer transformer = new Transformer();
        CALSYS = transformer;
        ENGINE = TimeAxis.Builder.setUp(Unit.class, cls, new Merger(), transformer).appendElement((ChronoElement) stdEnumDateElement, (ElementRule) new EraRule()).appendElement(stdIntegerDateElement, new IntegerRule(0), Unit.YEARS).appendElement(r3, new MonthRule(), Unit.MONTHS).appendElement(stdIntegerDateElement2, new IntegerRule(2), Unit.DAYS).appendElement(stdIntegerDateElement3, new IntegerRule(3), Unit.DAYS).appendElement(stdWeekdayElement, new WeekdayRule(getDefaultWeekmodel(), new ChronoFunction<HebrewCalendar, CalendarSystem<HebrewCalendar>>() {
            public CalendarSystem<HebrewCalendar> apply(HebrewCalendar hebrewCalendar) {
                return HebrewCalendar.CALSYS;
            }
        }), Unit.DAYS).appendElement((ChronoElement) weekdayInMonthElement, (ElementRule) WeekdayInMonthElement.getRule(weekdayInMonthElement)).appendElement((ChronoElement) CommonElements.RELATED_GREGORIAN_YEAR, (ElementRule) new RelatedGregorianYearRule(transformer, (ChronoElement<Integer>) stdIntegerDateElement3)).appendUnit(Unit.YEARS, new HebrewUnitRule(Unit.YEARS), Unit.YEARS.getLength(), Collections.singleton(Unit.MONTHS)).appendUnit(Unit.MONTHS, new HebrewUnitRule(Unit.MONTHS), Unit.MONTHS.getLength(), Collections.singleton(Unit.YEARS)).appendUnit(Unit.WEEKS, new HebrewUnitRule(Unit.WEEKS), Unit.WEEKS.getLength(), Collections.singleton(Unit.DAYS)).appendUnit(Unit.DAYS, new HebrewUnitRule(Unit.DAYS), Unit.DAYS.getLength(), Collections.singleton(Unit.WEEKS)).appendExtension((ChronoExtension) new CommonElements.Weekengine(cls, stdIntegerDateElement2, stdIntegerDateElement3, getDefaultWeekmodel())).build();
    }

    private HebrewCalendar(int i, HebrewMonth hebrewMonth, int i2) {
        this.year = i;
        this.month = hebrewMonth;
        this.dom = i2;
    }

    public static HebrewCalendar of(int i, HebrewMonth hebrewMonth, int i2) {
        if (CALSYS.isValid(HebrewEra.ANNO_MUNDI, i, hebrewMonth.getValue(), i2)) {
            return new HebrewCalendar(i, hebrewMonth, i2);
        }
        throw new IllegalArgumentException("Invalid Hebrew date: year=" + i + ", month=" + hebrewMonth + ", day=" + i2);
    }

    public static HebrewCalendar ofCivil(int i, int i2, int i3) {
        return of(i, HebrewMonth.valueOfCivil(i2, isLeapYear(i)), i3);
    }

    public static HebrewCalendar ofBiblical(int i, int i2, int i3) {
        return of(i, HebrewMonth.valueOfBiblical(i2, isLeapYear(i)), i3);
    }

    public static HebrewCalendar nowInSystemTime() {
        return (HebrewCalendar) SystemClock.inLocalView().now(axis());
    }

    public static HebrewCalendar nowInSystemTime(StartOfDay startOfDay) {
        return (HebrewCalendar) SystemClock.currentMoment().toGeneralTimestamp(axis(), Timezone.ofSystem().getID(), startOfDay).toDate();
    }

    public HebrewEra getEra() {
        return HebrewEra.ANNO_MUNDI;
    }

    public int getYear() {
        return this.year;
    }

    public HebrewMonth getMonth() {
        return this.month;
    }

    public int getDayOfMonth() {
        return this.dom;
    }

    public Weekday getDayOfWeek() {
        return Weekday.valueOf(MathUtils.floorModulo(CALSYS.transform(this) + 5, 7) + 1);
    }

    public int getDayOfYear() {
        return getInt(DAY_OF_YEAR);
    }

    public int lengthOfMonth() {
        return lengthOfMonth(this.year, this.month);
    }

    public int lengthOfYear() {
        return lengthOfYear(this.year);
    }

    public static boolean isLeapYear(int i) {
        if (i >= 0) {
            return ((i * 7) + 1) % 19 < 7;
        }
        throw new IllegalArgumentException("Hebrew year is not positive: " + i);
    }

    public boolean isLeapYear() {
        return isLeapYear(this.year);
    }

    public boolean isSabbaticalYear() {
        return this.year % 7 == 0;
    }

    public boolean isRoshChodesh() {
        return (this.dom == 1 && this.month != HebrewMonth.TISHRI) || this.dom == 30;
    }

    public static boolean isValid(int i, HebrewMonth hebrewMonth, int i2) {
        return CALSYS.isValid(HebrewEra.ANNO_MUNDI, i, hebrewMonth.getValue(), i2);
    }

    public HebrewCalendar barMitzvah() {
        return (HebrewCalendar) get(HebrewAnniversary.BIRTHDAY.inHebrewYear(this.year + 13));
    }

    public HebrewCalendar batMitzvah() {
        return (HebrewCalendar) get(HebrewAnniversary.BIRTHDAY.inHebrewYear(this.year + 12));
    }

    public GeneralTimestamp<HebrewCalendar> at(PlainTime plainTime) {
        return GeneralTimestamp.of(this, plainTime);
    }

    public GeneralTimestamp<HebrewCalendar> atTime(int i, int i2) {
        return at(PlainTime.of(i, i2));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HebrewCalendar)) {
            return false;
        }
        HebrewCalendar hebrewCalendar = (HebrewCalendar) obj;
        if (this.dom == hebrewCalendar.dom && this.month == hebrewCalendar.month && this.year == hebrewCalendar.year) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.dom * 17) + (this.month.getValue() * 31) + (this.year * 37);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("AM-");
        String valueOf = String.valueOf(this.year);
        for (int length = valueOf.length(); length < 4; length++) {
            sb.append('0');
        }
        sb.append(valueOf);
        sb.append(SignatureVisitor.SUPER);
        sb.append(this.month.name());
        sb.append(SignatureVisitor.SUPER);
        if (this.dom < 10) {
            sb.append('0');
        }
        sb.append(this.dom);
        return sb.toString();
    }

    public static Weekmodel getDefaultWeekmodel() {
        return Weekmodel.of(Weekday.SUNDAY, 1, Weekday.FRIDAY, Weekday.SATURDAY);
    }

    public static TimeAxis<Unit, HebrewCalendar> axis() {
        return ENGINE;
    }

    /* access modifiers changed from: protected */
    public TimeAxis<Unit, HebrewCalendar> getChronology() {
        return ENGINE;
    }

    static int lengthOfMonth(int i, HebrewMonth hebrewMonth) {
        switch (AnonymousClass3.$SwitchMap$net$time4j$calendar$HebrewMonth[hebrewMonth.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return 29;
            case 6:
                int lengthOfYear = lengthOfYear(i);
                if (lengthOfYear == 355 || lengthOfYear == 385) {
                    return 30;
                }
                return 29;
            case 7:
                int lengthOfYear2 = lengthOfYear(i);
                return (lengthOfYear2 == 353 || lengthOfYear2 == 383) ? 29 : 30;
            default:
                return 30;
        }
    }

    /* access modifiers changed from: private */
    public static int lengthOfYear(int i) {
        return (int) (hcNewYear(i + 1) - hcNewYear(i));
    }

    /* access modifiers changed from: private */
    public static long hcNewYear(int i) {
        return FIXED_EPOCH + ((long) hcDelay1(i)) + ((long) hcDelay2(i));
    }

    private static int hcDelay2(int i) {
        int hcDelay1 = hcDelay1(i);
        if (hcDelay1(i + 1) - hcDelay1 == 356) {
            return 2;
        }
        if (hcDelay1 - hcDelay1(i - 1) == 382) {
            return 1;
        }
        return 0;
    }

    private static int hcDelay1(int i) {
        int floor = (int) Math.floor((hcMolad(i, HebrewMonth.TISHRI) - ((double) FIXED_EPOCH)) + 0.5d);
        int i2 = floor + 1;
        return (i2 * 3) % 7 < 3 ? i2 : floor;
    }

    private static double hcMolad(int i, HebrewMonth hebrewMonth) {
        int value = hebrewMonth.getValue() + 6;
        if (value > 13) {
            value -= 13;
        }
        if (value < 7) {
            i++;
        }
        return (((double) FIXED_EPOCH) - 0.033796296296296297d) + (((double) ((long) ((value - 7) + MathUtils.floorDivide((i * 235) - 234, 19)))) * 29.53059413580247d);
    }

    private Object writeReplace() {
        return new SPX(this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    public enum Unit implements ChronoUnit {
        YEARS(3.155732352E7d),
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

        public int between(HebrewCalendar hebrewCalendar, HebrewCalendar hebrewCalendar2) {
            return (int) hebrewCalendar.until(hebrewCalendar2, this);
        }
    }

    private static class Transformer implements EraYearMonthDaySystem<HebrewCalendar> {
        private Transformer() {
        }

        public boolean isValid(CalendarEra calendarEra, int i, int i2, int i3) {
            if (calendarEra != HebrewEra.ANNO_MUNDI || i < 1 || i > 9999 || i2 < 1 || i2 > 13 || i3 < 1 || i3 > getLengthOfMonth(calendarEra, i, i2)) {
                return false;
            }
            return true;
        }

        public int getLengthOfMonth(CalendarEra calendarEra, int i, int i2) {
            if (calendarEra != HebrewEra.ANNO_MUNDI) {
                throw new IllegalArgumentException("Invalid era: " + calendarEra);
            } else if (i >= 1 && i <= 9999 && i2 >= 1 && i2 <= 13) {
                return HebrewCalendar.lengthOfMonth(i, HebrewMonth.valueOf(i2));
            } else {
                throw new IllegalArgumentException("Out of bounds: year=" + i + ", month=" + HebrewMonth.valueOf(i2));
            }
        }

        public int getLengthOfYear(CalendarEra calendarEra, int i) {
            if (calendarEra != HebrewEra.ANNO_MUNDI) {
                throw new IllegalArgumentException("Invalid era: " + calendarEra);
            } else if (i >= 1 && i <= 9999) {
                return HebrewCalendar.lengthOfYear(i);
            } else {
                throw new IllegalArgumentException("Out of bounds: year=" + i);
            }
        }

        public HebrewCalendar transform(long j) {
            long transform = EpochDays.RATA_DIE.transform(j, EpochDays.UTC);
            int floorDivide = (int) MathUtils.floorDivide((transform - HebrewCalendar.FIXED_EPOCH) * 98496, 35975351);
            int i = floorDivide - 1;
            while (HebrewCalendar.hcNewYear(floorDivide) <= transform) {
                int i2 = floorDivide;
                floorDivide++;
                i = i2;
            }
            long access$700 = transform - (HebrewCalendar.hcNewYear(i) - 1);
            boolean isLeapYear = HebrewCalendar.isLeapYear(i);
            int i3 = 1;
            for (int i4 = 1; i4 < 13; i4++) {
                if (i4 != 6 || isLeapYear) {
                    long lengthOfMonth = access$700 - ((long) HebrewCalendar.lengthOfMonth(i, HebrewMonth.valueOf(i4)));
                    if (lengthOfMonth <= 0) {
                        break;
                    }
                    i3 = i4 + 1;
                    access$700 = lengthOfMonth;
                } else {
                    i3 = i4 + 1;
                }
            }
            return HebrewCalendar.of(i, HebrewMonth.valueOf(i3), (int) access$700);
        }

        public long transform(HebrewCalendar hebrewCalendar) {
            long transform = (EpochDays.UTC.transform(HebrewCalendar.hcNewYear(hebrewCalendar.year), EpochDays.RATA_DIE) + ((long) hebrewCalendar.dom)) - 1;
            boolean isLeapYear = HebrewCalendar.isLeapYear(hebrewCalendar.year);
            int value = hebrewCalendar.month.getValue();
            for (int i = 1; i < value; i++) {
                if (isLeapYear || i != 6) {
                    transform += (long) HebrewCalendar.lengthOfMonth(hebrewCalendar.year, HebrewMonth.valueOf(i));
                }
            }
            return transform;
        }

        public long getMinimumSinceUTC() {
            return transform(new HebrewCalendar(1, HebrewMonth.TISHRI, 1));
        }

        public long getMaximumSinceUTC() {
            return transform(new HebrewCalendar(9999, HebrewMonth.ELUL, 29));
        }

        public List<CalendarEra> getEras() {
            return Collections.singletonList(HebrewEra.ANNO_MUNDI);
        }
    }

    private static class IntegerRule implements IntElementRule<HebrewCalendar> {
        private final int index;

        IntegerRule(int i) {
            this.index = i;
        }

        public Integer getValue(HebrewCalendar hebrewCalendar) {
            return Integer.valueOf(getInt(hebrewCalendar));
        }

        public Integer getMinimum(HebrewCalendar hebrewCalendar) {
            int i = this.index;
            if (i == 0 || i == 2 || i == 3) {
                return 1;
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public Integer getMaximum(HebrewCalendar hebrewCalendar) {
            return Integer.valueOf(getMax(hebrewCalendar));
        }

        public boolean isValid(HebrewCalendar hebrewCalendar, Integer num) {
            if (num == null) {
                return false;
            }
            Integer minimum = getMinimum(hebrewCalendar);
            Integer maximum = getMaximum(hebrewCalendar);
            if (minimum.compareTo(num) > 0 || maximum.compareTo(num) < 0) {
                return false;
            }
            return true;
        }

        public HebrewCalendar withValue(HebrewCalendar hebrewCalendar, Integer num, boolean z) {
            if (num != null) {
                return withValue(hebrewCalendar, num.intValue(), z);
            }
            throw new IllegalArgumentException("Missing new value.");
        }

        public ChronoElement<?> getChildAtFloor(HebrewCalendar hebrewCalendar) {
            if (this.index == 0) {
                return HebrewCalendar.MONTH_OF_YEAR;
            }
            return null;
        }

        public ChronoElement<?> getChildAtCeiling(HebrewCalendar hebrewCalendar) {
            if (this.index == 0) {
                return HebrewCalendar.MONTH_OF_YEAR;
            }
            return null;
        }

        public int getInt(HebrewCalendar hebrewCalendar) {
            int i = this.index;
            if (i == 0) {
                return hebrewCalendar.year;
            }
            if (i == 2) {
                return hebrewCalendar.dom;
            }
            if (i == 3) {
                int i2 = 0;
                boolean isLeapYear = HebrewCalendar.isLeapYear(hebrewCalendar.year);
                for (int i3 = 1; i3 < hebrewCalendar.month.getValue(); i3++) {
                    if (isLeapYear || i3 != 6) {
                        i2 += HebrewCalendar.CALSYS.getLengthOfMonth(HebrewEra.ANNO_MUNDI, hebrewCalendar.year, i3);
                    }
                }
                return i2 + hebrewCalendar.dom;
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public boolean isValid(HebrewCalendar hebrewCalendar, int i) {
            return i <= getMax(hebrewCalendar) && 1 <= i;
        }

        public HebrewCalendar withValue(HebrewCalendar hebrewCalendar, int i, boolean z) {
            if (isValid(hebrewCalendar, i)) {
                int i2 = this.index;
                if (i2 == 0) {
                    return HebrewCalendar.of(i, hebrewCalendar.getMonth(), Math.min(hebrewCalendar.dom, HebrewCalendar.CALSYS.getLengthOfMonth(HebrewEra.ANNO_MUNDI, i, hebrewCalendar.month.getValue())));
                } else if (i2 == 2) {
                    return new HebrewCalendar(hebrewCalendar.year, hebrewCalendar.month, i);
                } else {
                    if (i2 == 3) {
                        return (HebrewCalendar) hebrewCalendar.plus(CalendarDays.of((long) (i - getInt(hebrewCalendar))));
                    }
                    throw new UnsupportedOperationException("Unknown element index: " + this.index);
                }
            } else {
                throw new IllegalArgumentException("Out of range: " + i);
            }
        }

        private int getMax(HebrewCalendar hebrewCalendar) {
            int i = this.index;
            if (i == 0) {
                return 9999;
            }
            if (i == 2) {
                return HebrewCalendar.lengthOfMonth(hebrewCalendar.year, hebrewCalendar.month);
            }
            if (i == 3) {
                return HebrewCalendar.lengthOfYear(hebrewCalendar.year);
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }
    }

    private static class MonthRule implements ElementRule<HebrewCalendar, HebrewMonth> {
        private MonthRule() {
        }

        public HebrewMonth getValue(HebrewCalendar hebrewCalendar) {
            return hebrewCalendar.month;
        }

        public HebrewMonth getMinimum(HebrewCalendar hebrewCalendar) {
            return HebrewMonth.TISHRI;
        }

        public HebrewMonth getMaximum(HebrewCalendar hebrewCalendar) {
            return HebrewMonth.ELUL;
        }

        public boolean isValid(HebrewCalendar hebrewCalendar, HebrewMonth hebrewMonth) {
            return hebrewMonth != null && (hebrewMonth != HebrewMonth.ADAR_I || hebrewCalendar.isLeapYear());
        }

        public HebrewCalendar withValue(HebrewCalendar hebrewCalendar, HebrewMonth hebrewMonth, boolean z) {
            if (hebrewMonth == null) {
                throw new IllegalArgumentException("Missing month.");
            } else if (hebrewMonth != HebrewMonth.ADAR_I || hebrewCalendar.isLeapYear()) {
                return new HebrewCalendar(hebrewCalendar.year, hebrewMonth, Math.min(hebrewCalendar.dom, HebrewCalendar.lengthOfMonth(hebrewCalendar.year, hebrewMonth)));
            } else {
                throw new IllegalArgumentException("ADAR-I cannot be set in a standard year: " + hebrewCalendar);
            }
        }

        public ChronoElement<?> getChildAtFloor(HebrewCalendar hebrewCalendar) {
            return HebrewCalendar.DAY_OF_MONTH;
        }

        public ChronoElement<?> getChildAtCeiling(HebrewCalendar hebrewCalendar) {
            return HebrewCalendar.DAY_OF_MONTH;
        }
    }

    private static class EraRule implements ElementRule<HebrewCalendar, HebrewEra> {
        public boolean isValid(HebrewCalendar hebrewCalendar, HebrewEra hebrewEra) {
            return hebrewEra != null;
        }

        private EraRule() {
        }

        public HebrewEra getValue(HebrewCalendar hebrewCalendar) {
            return HebrewEra.ANNO_MUNDI;
        }

        public HebrewEra getMinimum(HebrewCalendar hebrewCalendar) {
            return HebrewEra.ANNO_MUNDI;
        }

        public HebrewEra getMaximum(HebrewCalendar hebrewCalendar) {
            return HebrewEra.ANNO_MUNDI;
        }

        public HebrewCalendar withValue(HebrewCalendar hebrewCalendar, HebrewEra hebrewEra, boolean z) {
            if (hebrewEra != null) {
                return hebrewCalendar;
            }
            throw new IllegalArgumentException("Missing era value.");
        }

        public ChronoElement<?> getChildAtFloor(HebrewCalendar hebrewCalendar) {
            return HebrewCalendar.YEAR_OF_ERA;
        }

        public ChronoElement<?> getChildAtCeiling(HebrewCalendar hebrewCalendar) {
            return HebrewCalendar.YEAR_OF_ERA;
        }
    }

    private enum ParsedMonthElement implements ChronoElement<Integer> {
        INSTANCE;

        public char getSymbol() {
            return 0;
        }

        public boolean isDateElement() {
            return true;
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
            return 1;
        }

        public Integer getDefaultMaximum() {
            return 13;
        }

        public String getDisplayName(Locale locale) {
            return name();
        }
    }

    private static class Merger implements ChronoMerger<HebrewCalendar> {
        public ChronoDisplay preformat(HebrewCalendar hebrewCalendar, AttributeQuery attributeQuery) {
            return hebrewCalendar;
        }

        public Chronology<?> preparser() {
            return null;
        }

        private Merger() {
        }

        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            return GenericDatePatterns.get("hebrew", displayStyle, locale);
        }

        /* JADX WARNING: type inference failed for: r4v0, types: [net.time4j.base.TimeSource, net.time4j.base.TimeSource<?>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.calendar.HebrewCalendar createFrom(net.time4j.base.TimeSource<?> r4, net.time4j.engine.AttributeQuery r5) {
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
                net.time4j.engine.TimeAxis r1 = net.time4j.calendar.HebrewCalendar.ENGINE
                net.time4j.GeneralTimestamp r4 = r4.toGeneralTimestamp(r1, r0, r5)
                java.lang.Object r4 = r4.toDate()
                net.time4j.calendar.HebrewCalendar r4 = (net.time4j.calendar.HebrewCalendar) r4
                return r4
            L_0x004c:
                r4 = 0
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.HebrewCalendar.Merger.createFrom(net.time4j.base.TimeSource, net.time4j.engine.AttributeQuery):net.time4j.calendar.HebrewCalendar");
        }

        public HebrewCalendar createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            HebrewMonth hebrewMonth;
            int i = chronoEntity.getInt(HebrewCalendar.YEAR_OF_ERA);
            if (i == Integer.MIN_VALUE) {
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Missing Hebrew year.");
                return null;
            }
            int i2 = 1;
            if (chronoEntity.contains(ParsedMonthElement.INSTANCE)) {
                int i3 = chronoEntity.getInt(ParsedMonthElement.INSTANCE);
                int i4 = AnonymousClass3.$SwitchMap$net$time4j$calendar$HebrewMonth$Order[((HebrewMonth.Order) attributeQuery.get(HebrewMonth.order(), HebrewMonth.Order.CIVIL)).ordinal()];
                hebrewMonth = i4 != 1 ? i4 != 2 ? HebrewMonth.valueOf(i3) : HebrewMonth.valueOfBiblical(i3, HebrewCalendar.isLeapYear(i)) : HebrewMonth.valueOfCivil(i3, HebrewCalendar.isLeapYear(i));
            } else {
                hebrewMonth = chronoEntity.contains(HebrewCalendar.MONTH_OF_YEAR) ? (HebrewMonth) chronoEntity.get((ChronoElement<V>) HebrewCalendar.MONTH_OF_YEAR) : null;
            }
            if (hebrewMonth != null) {
                int i5 = chronoEntity.getInt(HebrewCalendar.DAY_OF_MONTH);
                if (i5 != Integer.MIN_VALUE) {
                    if (HebrewCalendar.CALSYS.isValid(HebrewEra.ANNO_MUNDI, i, hebrewMonth.getValue(), i5)) {
                        return HebrewCalendar.of(i, hebrewMonth, i5);
                    }
                    chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Invalid Hebrew date.");
                }
            } else {
                int i6 = chronoEntity.getInt(HebrewCalendar.DAY_OF_YEAR);
                if (i6 != Integer.MIN_VALUE) {
                    if (i6 > 0) {
                        int i7 = 0;
                        boolean isLeapYear = HebrewCalendar.isLeapYear(i);
                        while (i2 <= 13) {
                            if (i2 != 6 || isLeapYear) {
                                int lengthOfMonth = HebrewCalendar.lengthOfMonth(i, HebrewMonth.valueOf(i2)) + i7;
                                if (i6 <= lengthOfMonth) {
                                    return HebrewCalendar.of(i, HebrewMonth.valueOf(i2), i6 - i7);
                                }
                                i2++;
                                i7 = lengthOfMonth;
                            }
                        }
                    }
                    chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Invalid Hebrew date.");
                }
            }
            return null;
        }

        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.EVENING;
        }

        public int getDefaultPivotYear() {
            return HebrewCalendar.nowInSystemTime().getYear() + 20;
        }
    }

    private static class HebrewUnitRule implements UnitRule<HebrewCalendar> {
        private final Unit unit;

        HebrewUnitRule(Unit unit2) {
            this.unit = unit2;
        }

        public HebrewCalendar addTo(HebrewCalendar hebrewCalendar, long j) {
            int i = AnonymousClass3.$SwitchMap$net$time4j$calendar$HebrewCalendar$Unit[this.unit.ordinal()];
            if (i == 1) {
                int safeCast = MathUtils.safeCast(MathUtils.safeAdd((long) hebrewCalendar.year, j));
                if (safeCast < 1 || safeCast > 9999) {
                    throw new IllegalArgumentException("Resulting year out of bounds: " + safeCast);
                }
                HebrewMonth access$1000 = hebrewCalendar.month;
                if (access$1000 == HebrewMonth.ADAR_I && !HebrewCalendar.isLeapYear(safeCast)) {
                    access$1000 = HebrewMonth.SHEVAT;
                }
                return new HebrewCalendar(safeCast, access$1000, Math.min(hebrewCalendar.dom, HebrewCalendar.lengthOfMonth(safeCast, access$1000)));
            } else if (i != 2) {
                if (i == 3) {
                    j = MathUtils.safeMultiply(j, 7);
                } else if (i != 4) {
                    throw new UnsupportedOperationException(this.unit.name());
                }
                return (HebrewCalendar) HebrewCalendar.CALSYS.transform(MathUtils.safeAdd(HebrewCalendar.CALSYS.transform(hebrewCalendar), j));
            } else {
                int access$800 = hebrewCalendar.year;
                int value = hebrewCalendar.month.getValue();
                for (long abs = Math.abs(j); abs > 0; abs--) {
                    if (j > 0) {
                        value++;
                        if (value == 6 && !HebrewCalendar.isLeapYear(access$800)) {
                            value++;
                        } else if (value == 14) {
                            access$800++;
                            value = 1;
                        }
                    } else {
                        value--;
                        if (value == 6 && !HebrewCalendar.isLeapYear(access$800)) {
                            value--;
                        } else if (value == 0) {
                            value = 13;
                            access$800--;
                        }
                    }
                }
                HebrewMonth valueOf = HebrewMonth.valueOf(value);
                return HebrewCalendar.of(access$800, valueOf, Math.min(hebrewCalendar.dom, HebrewCalendar.lengthOfMonth(access$800, valueOf)));
            }
        }

        public long between(HebrewCalendar hebrewCalendar, HebrewCalendar hebrewCalendar2) {
            HebrewCalendar hebrewCalendar3;
            HebrewCalendar hebrewCalendar4;
            int i = AnonymousClass3.$SwitchMap$net$time4j$calendar$HebrewCalendar$Unit[this.unit.ordinal()];
            if (i == 1) {
                int access$800 = hebrewCalendar2.year - hebrewCalendar.year;
                if (access$800 > 0) {
                    if (hebrewCalendar2.month.getValue() < hebrewCalendar.month.getValue() || (hebrewCalendar2.month.getValue() == hebrewCalendar.month.getValue() && hebrewCalendar2.dom < hebrewCalendar.dom)) {
                        access$800--;
                    }
                } else if (access$800 < 0 && (hebrewCalendar2.month.getValue() > hebrewCalendar.month.getValue() || (hebrewCalendar2.month.getValue() == hebrewCalendar.month.getValue() && hebrewCalendar2.dom > hebrewCalendar.dom))) {
                    access$800++;
                }
                return (long) access$800;
            } else if (i == 2) {
                boolean isAfter = hebrewCalendar.isAfter((CalendarDate) hebrewCalendar2);
                if (isAfter) {
                    hebrewCalendar3 = hebrewCalendar;
                    hebrewCalendar4 = hebrewCalendar2;
                } else {
                    hebrewCalendar4 = hebrewCalendar;
                    hebrewCalendar3 = hebrewCalendar2;
                }
                int i2 = 0;
                int access$8002 = hebrewCalendar4.year;
                int value = hebrewCalendar4.month.getValue();
                while (true) {
                    if (access$8002 < hebrewCalendar3.year || (access$8002 == hebrewCalendar3.year && value < hebrewCalendar3.month.getValue())) {
                        value++;
                        i2++;
                        if (value == 6 && !HebrewCalendar.isLeapYear(access$8002)) {
                            value++;
                        } else if (value == 14) {
                            access$8002++;
                            value = 1;
                        }
                    }
                }
                if (i2 > 0 && hebrewCalendar4.dom > hebrewCalendar3.dom) {
                    i2--;
                }
                if (isAfter) {
                    i2 = -i2;
                }
                return (long) i2;
            } else if (i == 3) {
                return (long) (Unit.DAYS.between(hebrewCalendar, hebrewCalendar2) / 7);
            } else {
                if (i == 4) {
                    return HebrewCalendar.CALSYS.transform(hebrewCalendar2) - HebrewCalendar.CALSYS.transform(hebrewCalendar);
                }
                throw new UnsupportedOperationException(this.unit.name());
            }
        }
    }

    /* renamed from: net.time4j.calendar.HebrewCalendar$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$calendar$HebrewCalendar$Unit;
        static final /* synthetic */ int[] $SwitchMap$net$time4j$calendar$HebrewMonth;
        static final /* synthetic */ int[] $SwitchMap$net$time4j$calendar$HebrewMonth$Order;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|(2:29|30)|31|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|33|34|(3:35|36|38)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|38) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0094 */
        static {
            /*
                net.time4j.calendar.HebrewCalendar$Unit[] r0 = net.time4j.calendar.HebrewCalendar.Unit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$calendar$HebrewCalendar$Unit = r0
                r1 = 1
                net.time4j.calendar.HebrewCalendar$Unit r2 = net.time4j.calendar.HebrewCalendar.Unit.YEARS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$net$time4j$calendar$HebrewCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.calendar.HebrewCalendar$Unit r3 = net.time4j.calendar.HebrewCalendar.Unit.MONTHS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$net$time4j$calendar$HebrewCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.calendar.HebrewCalendar$Unit r4 = net.time4j.calendar.HebrewCalendar.Unit.WEEKS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$net$time4j$calendar$HebrewCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.calendar.HebrewCalendar$Unit r5 = net.time4j.calendar.HebrewCalendar.Unit.DAYS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                net.time4j.calendar.HebrewMonth[] r4 = net.time4j.calendar.HebrewMonth.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$net$time4j$calendar$HebrewMonth = r4
                net.time4j.calendar.HebrewMonth r5 = net.time4j.calendar.HebrewMonth.IYAR     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r4 = $SwitchMap$net$time4j$calendar$HebrewMonth     // Catch:{ NoSuchFieldError -> 0x004e }
                net.time4j.calendar.HebrewMonth r5 = net.time4j.calendar.HebrewMonth.TAMUZ     // Catch:{ NoSuchFieldError -> 0x004e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r4 = $SwitchMap$net$time4j$calendar$HebrewMonth     // Catch:{ NoSuchFieldError -> 0x0058 }
                net.time4j.calendar.HebrewMonth r5 = net.time4j.calendar.HebrewMonth.ELUL     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r2 = $SwitchMap$net$time4j$calendar$HebrewMonth     // Catch:{ NoSuchFieldError -> 0x0062 }
                net.time4j.calendar.HebrewMonth r4 = net.time4j.calendar.HebrewMonth.TEVET     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r2[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r2 = $SwitchMap$net$time4j$calendar$HebrewMonth     // Catch:{ NoSuchFieldError -> 0x006d }
                net.time4j.calendar.HebrewMonth r3 = net.time4j.calendar.HebrewMonth.ADAR_II     // Catch:{ NoSuchFieldError -> 0x006d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r4 = 5
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r2 = $SwitchMap$net$time4j$calendar$HebrewMonth     // Catch:{ NoSuchFieldError -> 0x0078 }
                net.time4j.calendar.HebrewMonth r3 = net.time4j.calendar.HebrewMonth.HESHVAN     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r4 = 6
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r2 = $SwitchMap$net$time4j$calendar$HebrewMonth     // Catch:{ NoSuchFieldError -> 0x0083 }
                net.time4j.calendar.HebrewMonth r3 = net.time4j.calendar.HebrewMonth.KISLEV     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r4 = 7
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                net.time4j.calendar.HebrewMonth$Order[] r2 = net.time4j.calendar.HebrewMonth.Order.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$net$time4j$calendar$HebrewMonth$Order = r2
                net.time4j.calendar.HebrewMonth$Order r3 = net.time4j.calendar.HebrewMonth.Order.CIVIL     // Catch:{ NoSuchFieldError -> 0x0094 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0094 }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0094 }
            L_0x0094:
                int[] r1 = $SwitchMap$net$time4j$calendar$HebrewMonth$Order     // Catch:{ NoSuchFieldError -> 0x009e }
                net.time4j.calendar.HebrewMonth$Order r2 = net.time4j.calendar.HebrewMonth.Order.BIBLICAL     // Catch:{ NoSuchFieldError -> 0x009e }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x009e }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x009e }
            L_0x009e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.HebrewCalendar.AnonymousClass3.<clinit>():void");
        }
    }

    private static class SPX implements Externalizable {
        private static final int HEBREW_DATE = 12;
        private static final long serialVersionUID = 1;
        private transient Object obj;

        public SPX() {
        }

        SPX(Object obj2) {
            this.obj = obj2;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeByte(12);
            writeHebrewDate(objectOutput);
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            if (objectInput.readByte() == 12) {
                this.obj = readHebrewDate(objectInput);
                return;
            }
            throw new InvalidObjectException("Unknown calendar type.");
        }

        private Object readResolve() throws ObjectStreamException {
            return this.obj;
        }

        private void writeHebrewDate(ObjectOutput objectOutput) throws IOException {
            HebrewCalendar hebrewCalendar = (HebrewCalendar) this.obj;
            objectOutput.writeInt(hebrewCalendar.getYear());
            objectOutput.writeByte(hebrewCalendar.getMonth().getValue());
            objectOutput.writeByte(hebrewCalendar.getDayOfMonth());
        }

        private HebrewCalendar readHebrewDate(ObjectInput objectInput) throws IOException {
            return HebrewCalendar.of(objectInput.readInt(), HebrewMonth.valueOf((int) objectInput.readByte()), objectInput.readByte());
        }
    }
}
