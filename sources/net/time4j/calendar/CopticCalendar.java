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
import net.time4j.engine.StartOfDay;
import net.time4j.engine.TimeAxis;
import net.time4j.engine.UnitRule;
import net.time4j.engine.ValidationElement;
import net.time4j.format.CalendarType;
import net.time4j.format.LocalizedPatternSupport;
import net.time4j.history.ChronoHistory;
import net.time4j.history.HistoricDate;
import net.time4j.history.HistoricEra;

@CalendarType("coptic")
public final class CopticCalendar extends Calendrical<Unit, CopticCalendar> implements LocalizedPatternSupport {
    /* access modifiers changed from: private */
    public static final EraYearMonthDaySystem<CopticCalendar> CALSYS;
    @FormattableElement(format = "d")
    public static final StdCalendarElement<Integer, CopticCalendar> DAY_OF_MONTH;
    private static final int DAY_OF_MONTH_INDEX = 2;
    @FormattableElement(format = "E")
    public static final StdCalendarElement<Weekday, CopticCalendar> DAY_OF_WEEK;
    @FormattableElement(format = "D")
    public static final StdCalendarElement<Integer, CopticCalendar> DAY_OF_YEAR;
    private static final int DAY_OF_YEAR_INDEX = 3;
    /* access modifiers changed from: private */
    public static final long DIOCLETIAN = ((Long) ChronoHistory.PROLEPTIC_JULIAN.convert(HistoricDate.of(HistoricEra.AD, 284, 8, 29)).get(EpochDays.UTC)).longValue();
    /* access modifiers changed from: private */
    public static final TimeAxis<Unit, CopticCalendar> ENGINE;
    @FormattableElement(format = "G")
    public static final ChronoElement<CopticEra> ERA;
    @FormattableElement(alt = "L", format = "M")
    public static final StdCalendarElement<CopticMonth, CopticCalendar> MONTH_OF_YEAR;
    @FormattableElement(format = "F")
    public static final OrdinalWeekdayElement<CopticCalendar> WEEKDAY_IN_MONTH;
    private static final WeekdayInMonthElement<CopticCalendar> WIM_ELEMENT;
    private static final int YEAR_INDEX = 0;
    @FormattableElement(format = "y")
    public static final StdCalendarElement<Integer, CopticCalendar> YEAR_OF_ERA;
    private static final long serialVersionUID = -8248846000788617742L;
    /* access modifiers changed from: private */
    public final transient int cdom;
    /* access modifiers changed from: private */
    public final transient int cmonth;
    /* access modifiers changed from: private */
    public final transient int cyear;

    /* access modifiers changed from: protected */
    public CopticCalendar getContext() {
        return this;
    }

    static {
        Class<CopticCalendar> cls = CopticCalendar.class;
        StdEnumDateElement stdEnumDateElement = new StdEnumDateElement("ERA", cls, CopticEra.class, 'G');
        ERA = stdEnumDateElement;
        StdIntegerDateElement stdIntegerDateElement = new StdIntegerDateElement("YEAR_OF_ERA", CopticCalendar.class, 1, 9999, 'y', (ChronoOperator) null, (ChronoOperator) null);
        YEAR_OF_ERA = stdIntegerDateElement;
        StdEnumDateElement stdEnumDateElement2 = new StdEnumDateElement("MONTH_OF_YEAR", cls, CopticMonth.class, 'M');
        MONTH_OF_YEAR = stdEnumDateElement2;
        StdIntegerDateElement stdIntegerDateElement2 = new StdIntegerDateElement("DAY_OF_MONTH", CopticCalendar.class, 1, 30, 'd');
        DAY_OF_MONTH = stdIntegerDateElement2;
        StdIntegerDateElement stdIntegerDateElement3 = new StdIntegerDateElement("DAY_OF_YEAR", CopticCalendar.class, 1, 365, 'D');
        DAY_OF_YEAR = stdIntegerDateElement3;
        StdWeekdayElement stdWeekdayElement = new StdWeekdayElement(cls, getDefaultWeekmodel());
        DAY_OF_WEEK = stdWeekdayElement;
        WeekdayInMonthElement<CopticCalendar> weekdayInMonthElement = new WeekdayInMonthElement<>(cls, stdIntegerDateElement2, stdWeekdayElement);
        WIM_ELEMENT = weekdayInMonthElement;
        WEEKDAY_IN_MONTH = weekdayInMonthElement;
        Transformer transformer = new Transformer();
        CALSYS = transformer;
        ENGINE = TimeAxis.Builder.setUp(Unit.class, cls, new Merger(), transformer).appendElement((ChronoElement) stdEnumDateElement, (ElementRule) new EraRule()).appendElement(stdIntegerDateElement, new IntegerRule(0), Unit.YEARS).appendElement(stdEnumDateElement2, new MonthRule(), Unit.MONTHS).appendElement(stdIntegerDateElement2, new IntegerRule(2), Unit.DAYS).appendElement(stdIntegerDateElement3, new IntegerRule(3), Unit.DAYS).appendElement(stdWeekdayElement, new WeekdayRule(getDefaultWeekmodel(), new ChronoFunction<CopticCalendar, CalendarSystem<CopticCalendar>>() {
            public CalendarSystem<CopticCalendar> apply(CopticCalendar copticCalendar) {
                return CopticCalendar.CALSYS;
            }
        }), Unit.DAYS).appendElement((ChronoElement) weekdayInMonthElement, (ElementRule) WeekdayInMonthElement.getRule(weekdayInMonthElement)).appendElement((ChronoElement) CommonElements.RELATED_GREGORIAN_YEAR, (ElementRule) new RelatedGregorianYearRule(transformer, (ChronoElement<Integer>) stdIntegerDateElement3)).appendUnit(Unit.YEARS, new CopticUnitRule(Unit.YEARS), Unit.YEARS.getLength(), Collections.singleton(Unit.MONTHS)).appendUnit(Unit.MONTHS, new CopticUnitRule(Unit.MONTHS), Unit.MONTHS.getLength(), Collections.singleton(Unit.YEARS)).appendUnit(Unit.WEEKS, new CopticUnitRule(Unit.WEEKS), Unit.WEEKS.getLength(), Collections.singleton(Unit.DAYS)).appendUnit(Unit.DAYS, new CopticUnitRule(Unit.DAYS), Unit.DAYS.getLength(), Collections.singleton(Unit.WEEKS)).appendExtension((ChronoExtension) new CommonElements.Weekengine(cls, stdIntegerDateElement2, stdIntegerDateElement3, getDefaultWeekmodel())).build();
    }

    private CopticCalendar(int i, int i2, int i3) {
        this.cyear = i;
        this.cmonth = i2;
        this.cdom = i3;
    }

    public static CopticCalendar of(int i, CopticMonth copticMonth, int i2) {
        return of(i, copticMonth.getValue(), i2);
    }

    public static CopticCalendar of(int i, int i2, int i3) {
        if (CALSYS.isValid(CopticEra.ANNO_MARTYRUM, i, i2, i3)) {
            return new CopticCalendar(i, i2, i3);
        }
        throw new IllegalArgumentException("Invalid Coptic date: year=" + i + ", month=" + i2 + ", day=" + i3);
    }

    public static CopticCalendar nowInSystemTime() {
        return (CopticCalendar) SystemClock.inLocalView().now(axis());
    }

    public CopticEra getEra() {
        return CopticEra.ANNO_MARTYRUM;
    }

    public int getYear() {
        return this.cyear;
    }

    public CopticMonth getMonth() {
        return CopticMonth.valueOf(this.cmonth);
    }

    public int getDayOfMonth() {
        return this.cdom;
    }

    public Weekday getDayOfWeek() {
        return Weekday.valueOf(MathUtils.floorModulo(CALSYS.transform(this) + 5, 7) + 1);
    }

    public int getDayOfYear() {
        return ((Integer) get(DAY_OF_YEAR)).intValue();
    }

    public int lengthOfMonth() {
        return CALSYS.getLengthOfMonth(CopticEra.ANNO_MARTYRUM, this.cyear, this.cmonth);
    }

    public int lengthOfYear() {
        return isLeapYear() ? 366 : 365;
    }

    public boolean isLeapYear() {
        return this.cyear % 4 == 3;
    }

    public static boolean isValid(int i, int i2, int i3) {
        return CALSYS.isValid(CopticEra.ANNO_MARTYRUM, i, i2, i3);
    }

    public GeneralTimestamp<CopticCalendar> at(PlainTime plainTime) {
        return GeneralTimestamp.of(this, plainTime);
    }

    public GeneralTimestamp<CopticCalendar> atTime(int i, int i2) {
        return at(PlainTime.of(i, i2));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CopticCalendar)) {
            return false;
        }
        CopticCalendar copticCalendar = (CopticCalendar) obj;
        if (this.cdom == copticCalendar.cdom && this.cmonth == copticCalendar.cmonth && this.cyear == copticCalendar.cyear) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.cdom * 17) + (this.cmonth * 31) + (this.cyear * 37);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("A.M.-");
        String valueOf = String.valueOf(this.cyear);
        for (int length = valueOf.length(); length < 4; length++) {
            sb.append('0');
        }
        sb.append(valueOf);
        sb.append(SignatureVisitor.SUPER);
        if (this.cmonth < 10) {
            sb.append('0');
        }
        sb.append(this.cmonth);
        sb.append(SignatureVisitor.SUPER);
        if (this.cdom < 10) {
            sb.append('0');
        }
        sb.append(this.cdom);
        return sb.toString();
    }

    public static Weekmodel getDefaultWeekmodel() {
        return Weekmodel.of(Weekday.SATURDAY, 1, Weekday.FRIDAY, Weekday.SATURDAY);
    }

    public static TimeAxis<Unit, CopticCalendar> axis() {
        return ENGINE;
    }

    /* access modifiers changed from: protected */
    public TimeAxis<Unit, CopticCalendar> getChronology() {
        return ENGINE;
    }

    private Object writeReplace() {
        return new SPX(this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    public enum Unit implements ChronoUnit {
        YEARS(3.15576E7d),
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

        public int between(CopticCalendar copticCalendar, CopticCalendar copticCalendar2) {
            return (int) copticCalendar.until(copticCalendar2, this);
        }
    }

    private static class Transformer implements EraYearMonthDaySystem<CopticCalendar> {
        private Transformer() {
        }

        public boolean isValid(CalendarEra calendarEra, int i, int i2, int i3) {
            if (calendarEra != CopticEra.ANNO_MARTYRUM || i < 1 || i > 9999 || i2 < 1 || i2 > 13 || i3 < 1 || i3 > getLengthOfMonth(calendarEra, i, i2)) {
                return false;
            }
            return true;
        }

        public int getLengthOfMonth(CalendarEra calendarEra, int i, int i2) {
            if (calendarEra != CopticEra.ANNO_MARTYRUM) {
                throw new IllegalArgumentException("Invalid era: " + calendarEra);
            } else if (i < 1 || i > 9999 || i2 < 1 || i2 > 13) {
                throw new IllegalArgumentException("Out of bounds: year=" + i + ", month=" + i2);
            } else if (i2 <= 12) {
                return 30;
            } else {
                return i % 4 == 3 ? 6 : 5;
            }
        }

        public int getLengthOfYear(CalendarEra calendarEra, int i) {
            if (calendarEra != CopticEra.ANNO_MARTYRUM) {
                throw new IllegalArgumentException("Invalid era: " + calendarEra);
            } else if (i >= 1 && i <= 9999) {
                return i % 4 == 3 ? 366 : 365;
            } else {
                throw new IllegalArgumentException("Out of bounds: year=" + i);
            }
        }

        public CopticCalendar transform(long j) {
            try {
                int safeCast = MathUtils.safeCast(MathUtils.floorDivide(MathUtils.safeAdd(MathUtils.safeMultiply(4, MathUtils.safeSubtract(j, CopticCalendar.DIOCLETIAN)), 1463), 1461));
                int safeCast2 = MathUtils.safeCast(MathUtils.floorDivide(j - ((long) MathUtils.safeCast(transform(new CopticCalendar(safeCast, 1, 1)))), 30)) + 1;
                return CopticCalendar.of(safeCast, safeCast2, MathUtils.safeCast(MathUtils.safeSubtract(j, (long) MathUtils.safeCast(transform(new CopticCalendar(safeCast, safeCast2, 1))))) + 1);
            } catch (ArithmeticException e) {
                throw new IllegalArgumentException(e);
            }
        }

        public long transform(CopticCalendar copticCalendar) {
            return (CopticCalendar.DIOCLETIAN - 1) + ((long) ((copticCalendar.cyear - 1) * 365)) + ((long) MathUtils.floorDivide(copticCalendar.cyear, 4)) + ((long) ((copticCalendar.cmonth - 1) * 30)) + ((long) copticCalendar.cdom);
        }

        public long getMinimumSinceUTC() {
            return transform(new CopticCalendar(1, 1, 1));
        }

        public long getMaximumSinceUTC() {
            return transform(new CopticCalendar(9999, 13, 6));
        }

        public List<CalendarEra> getEras() {
            return Collections.singletonList(CopticEra.ANNO_MARTYRUM);
        }
    }

    private static class IntegerRule implements ElementRule<CopticCalendar, Integer> {
        private final int index;

        IntegerRule(int i) {
            this.index = i;
        }

        public Integer getValue(CopticCalendar copticCalendar) {
            int i = this.index;
            if (i == 0) {
                return Integer.valueOf(copticCalendar.cyear);
            }
            if (i == 2) {
                return Integer.valueOf(copticCalendar.cdom);
            }
            if (i == 3) {
                int i2 = 0;
                for (int i3 = 1; i3 < copticCalendar.cmonth; i3++) {
                    i2 += CopticCalendar.CALSYS.getLengthOfMonth(CopticEra.ANNO_MARTYRUM, copticCalendar.cyear, i3);
                }
                return Integer.valueOf(i2 + copticCalendar.cdom);
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public Integer getMinimum(CopticCalendar copticCalendar) {
            int i = this.index;
            if (i == 0 || i == 2 || i == 3) {
                return 1;
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public Integer getMaximum(CopticCalendar copticCalendar) {
            int i = this.index;
            if (i == 0) {
                return 9999;
            }
            if (i == 2) {
                return Integer.valueOf(CopticCalendar.CALSYS.getLengthOfMonth(CopticEra.ANNO_MARTYRUM, copticCalendar.cyear, copticCalendar.cmonth));
            }
            if (i == 3) {
                return Integer.valueOf(CopticCalendar.CALSYS.getLengthOfYear(CopticEra.ANNO_MARTYRUM, copticCalendar.cyear));
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public boolean isValid(CopticCalendar copticCalendar, Integer num) {
            if (num == null) {
                return false;
            }
            Integer minimum = getMinimum(copticCalendar);
            Integer maximum = getMaximum(copticCalendar);
            if (minimum.compareTo(num) > 0 || maximum.compareTo(num) < 0) {
                return false;
            }
            return true;
        }

        public CopticCalendar withValue(CopticCalendar copticCalendar, Integer num, boolean z) {
            if (isValid(copticCalendar, num)) {
                int i = this.index;
                if (i == 0) {
                    int intValue = num.intValue();
                    return CopticCalendar.of(intValue, copticCalendar.cmonth, Math.min(copticCalendar.cdom, CopticCalendar.CALSYS.getLengthOfMonth(CopticEra.ANNO_MARTYRUM, intValue, copticCalendar.cmonth)));
                } else if (i == 2) {
                    return new CopticCalendar(copticCalendar.cyear, copticCalendar.cmonth, num.intValue());
                } else {
                    if (i == 3) {
                        return (CopticCalendar) copticCalendar.plus(CalendarDays.of((long) (num.intValue() - getValue(copticCalendar).intValue())));
                    }
                    throw new UnsupportedOperationException("Unknown element index: " + this.index);
                }
            } else {
                throw new IllegalArgumentException("Out of range: " + num);
            }
        }

        public ChronoElement<?> getChildAtFloor(CopticCalendar copticCalendar) {
            if (this.index == 0) {
                return CopticCalendar.MONTH_OF_YEAR;
            }
            return null;
        }

        public ChronoElement<?> getChildAtCeiling(CopticCalendar copticCalendar) {
            if (this.index == 0) {
                return CopticCalendar.MONTH_OF_YEAR;
            }
            return null;
        }
    }

    private static class MonthRule implements ElementRule<CopticCalendar, CopticMonth> {
        public boolean isValid(CopticCalendar copticCalendar, CopticMonth copticMonth) {
            return copticMonth != null;
        }

        private MonthRule() {
        }

        public CopticMonth getValue(CopticCalendar copticCalendar) {
            return copticCalendar.getMonth();
        }

        public CopticMonth getMinimum(CopticCalendar copticCalendar) {
            return CopticMonth.TOUT;
        }

        public CopticMonth getMaximum(CopticCalendar copticCalendar) {
            return CopticMonth.NASIE;
        }

        public CopticCalendar withValue(CopticCalendar copticCalendar, CopticMonth copticMonth, boolean z) {
            if (copticMonth != null) {
                int value = copticMonth.getValue();
                return new CopticCalendar(copticCalendar.cyear, value, Math.min(copticCalendar.cdom, CopticCalendar.CALSYS.getLengthOfMonth(CopticEra.ANNO_MARTYRUM, copticCalendar.cyear, value)));
            }
            throw new IllegalArgumentException("Missing month.");
        }

        public ChronoElement<?> getChildAtFloor(CopticCalendar copticCalendar) {
            return CopticCalendar.DAY_OF_MONTH;
        }

        public ChronoElement<?> getChildAtCeiling(CopticCalendar copticCalendar) {
            return CopticCalendar.DAY_OF_MONTH;
        }
    }

    private static class EraRule implements ElementRule<CopticCalendar, CopticEra> {
        public boolean isValid(CopticCalendar copticCalendar, CopticEra copticEra) {
            return copticEra != null;
        }

        private EraRule() {
        }

        public CopticEra getValue(CopticCalendar copticCalendar) {
            return CopticEra.ANNO_MARTYRUM;
        }

        public CopticEra getMinimum(CopticCalendar copticCalendar) {
            return CopticEra.ANNO_MARTYRUM;
        }

        public CopticEra getMaximum(CopticCalendar copticCalendar) {
            return CopticEra.ANNO_MARTYRUM;
        }

        public CopticCalendar withValue(CopticCalendar copticCalendar, CopticEra copticEra, boolean z) {
            if (copticEra != null) {
                return copticCalendar;
            }
            throw new IllegalArgumentException("Missing era value.");
        }

        public ChronoElement<?> getChildAtFloor(CopticCalendar copticCalendar) {
            return CopticCalendar.YEAR_OF_ERA;
        }

        public ChronoElement<?> getChildAtCeiling(CopticCalendar copticCalendar) {
            return CopticCalendar.YEAR_OF_ERA;
        }
    }

    private static class Merger implements ChronoMerger<CopticCalendar> {
        public ChronoDisplay preformat(CopticCalendar copticCalendar, AttributeQuery attributeQuery) {
            return copticCalendar;
        }

        public Chronology<?> preparser() {
            return null;
        }

        private Merger() {
        }

        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            return GenericDatePatterns.get("coptic", displayStyle, locale);
        }

        /* JADX WARNING: type inference failed for: r4v0, types: [net.time4j.base.TimeSource, net.time4j.base.TimeSource<?>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.calendar.CopticCalendar createFrom(net.time4j.base.TimeSource<?> r4, net.time4j.engine.AttributeQuery r5) {
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
                net.time4j.engine.TimeAxis r1 = net.time4j.calendar.CopticCalendar.ENGINE
                net.time4j.GeneralTimestamp r4 = r4.toGeneralTimestamp(r1, r0, r5)
                java.lang.Object r4 = r4.toDate()
                net.time4j.calendar.CopticCalendar r4 = (net.time4j.calendar.CopticCalendar) r4
                return r4
            L_0x004c:
                r4 = 0
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.CopticCalendar.Merger.createFrom(net.time4j.base.TimeSource, net.time4j.engine.AttributeQuery):net.time4j.calendar.CopticCalendar");
        }

        public CopticCalendar createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            int i = chronoEntity.getInt(CopticCalendar.YEAR_OF_ERA);
            if (i == Integer.MIN_VALUE) {
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Missing Coptic year.");
                return null;
            }
            if (chronoEntity.contains(CopticCalendar.MONTH_OF_YEAR)) {
                int value = ((CopticMonth) chronoEntity.get((ChronoElement<V>) CopticCalendar.MONTH_OF_YEAR)).getValue();
                int i2 = chronoEntity.getInt(CopticCalendar.DAY_OF_MONTH);
                if (i2 != Integer.MIN_VALUE) {
                    if (CopticCalendar.CALSYS.isValid(CopticEra.ANNO_MARTYRUM, i, value, i2)) {
                        return CopticCalendar.of(i, value, i2);
                    }
                    chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Invalid Coptic date.");
                }
            } else {
                int i3 = chronoEntity.getInt(CopticCalendar.DAY_OF_YEAR);
                if (i3 != Integer.MIN_VALUE) {
                    if (i3 > 0) {
                        int i4 = 0;
                        int i5 = 1;
                        while (i5 <= 13) {
                            int lengthOfMonth = CopticCalendar.CALSYS.getLengthOfMonth(CopticEra.ANNO_MARTYRUM, i, i5) + i4;
                            if (i3 <= lengthOfMonth) {
                                return CopticCalendar.of(i, i5, i3 - i4);
                            }
                            i5++;
                            i4 = lengthOfMonth;
                        }
                    }
                    chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Invalid Coptic date.");
                }
            }
            return null;
        }

        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.EVENING;
        }

        public int getDefaultPivotYear() {
            return PlainDate.axis().getDefaultPivotYear() - 284;
        }
    }

    private static class CopticUnitRule implements UnitRule<CopticCalendar> {
        private final Unit unit;

        CopticUnitRule(Unit unit2) {
            this.unit = unit2;
        }

        public CopticCalendar addTo(CopticCalendar copticCalendar, long j) {
            int i = AnonymousClass2.$SwitchMap$net$time4j$calendar$CopticCalendar$Unit[this.unit.ordinal()];
            if (i == 1) {
                j = MathUtils.safeMultiply(j, 13);
            } else if (i != 2) {
                if (i == 3) {
                    j = MathUtils.safeMultiply(j, 7);
                } else if (i != 4) {
                    throw new UnsupportedOperationException(this.unit.name());
                }
                return (CopticCalendar) CopticCalendar.CALSYS.transform(MathUtils.safeAdd(CopticCalendar.CALSYS.transform(copticCalendar), j));
            }
            long safeAdd = MathUtils.safeAdd((long) ymValue(copticCalendar), j);
            int safeCast = MathUtils.safeCast(MathUtils.floorDivide(safeAdd, 13));
            int floorModulo = MathUtils.floorModulo(safeAdd, 13) + 1;
            return CopticCalendar.of(safeCast, floorModulo, Math.min(copticCalendar.cdom, CopticCalendar.CALSYS.getLengthOfMonth(CopticEra.ANNO_MARTYRUM, safeCast, floorModulo)));
        }

        public long between(CopticCalendar copticCalendar, CopticCalendar copticCalendar2) {
            int between;
            int i = AnonymousClass2.$SwitchMap$net$time4j$calendar$CopticCalendar$Unit[this.unit.ordinal()];
            if (i == 1) {
                between = Unit.MONTHS.between(copticCalendar, copticCalendar2) / 13;
            } else if (i == 2) {
                long ymValue = (long) (ymValue(copticCalendar2) - ymValue(copticCalendar));
                int i2 = (ymValue > 0 ? 1 : (ymValue == 0 ? 0 : -1));
                if (i2 <= 0 || copticCalendar2.cdom >= copticCalendar.cdom) {
                    return (i2 >= 0 || copticCalendar2.cdom <= copticCalendar.cdom) ? ymValue : ymValue + 1;
                }
                return ymValue - 1;
            } else if (i == 3) {
                between = Unit.DAYS.between(copticCalendar, copticCalendar2) / 7;
            } else if (i == 4) {
                return CopticCalendar.CALSYS.transform(copticCalendar2) - CopticCalendar.CALSYS.transform(copticCalendar);
            } else {
                throw new UnsupportedOperationException(this.unit.name());
            }
            return (long) between;
        }

        private static int ymValue(CopticCalendar copticCalendar) {
            return ((copticCalendar.cyear * 13) + copticCalendar.cmonth) - 1;
        }
    }

    /* renamed from: net.time4j.calendar.CopticCalendar$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$calendar$CopticCalendar$Unit;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                net.time4j.calendar.CopticCalendar$Unit[] r0 = net.time4j.calendar.CopticCalendar.Unit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$calendar$CopticCalendar$Unit = r0
                net.time4j.calendar.CopticCalendar$Unit r1 = net.time4j.calendar.CopticCalendar.Unit.YEARS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$calendar$CopticCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.calendar.CopticCalendar$Unit r1 = net.time4j.calendar.CopticCalendar.Unit.MONTHS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$calendar$CopticCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.calendar.CopticCalendar$Unit r1 = net.time4j.calendar.CopticCalendar.Unit.WEEKS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$net$time4j$calendar$CopticCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.calendar.CopticCalendar$Unit r1 = net.time4j.calendar.CopticCalendar.Unit.DAYS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.CopticCalendar.AnonymousClass2.<clinit>():void");
        }
    }

    private static class SPX implements Externalizable {
        private static final int COPTIC = 3;
        private static final long serialVersionUID = 1;
        private transient Object obj;

        public SPX() {
        }

        SPX(Object obj2) {
            this.obj = obj2;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeByte(3);
            writeCoptic(objectOutput);
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            if (objectInput.readByte() == 3) {
                this.obj = readCoptic(objectInput);
                return;
            }
            throw new InvalidObjectException("Unknown calendar type.");
        }

        private Object readResolve() throws ObjectStreamException {
            return this.obj;
        }

        private void writeCoptic(ObjectOutput objectOutput) throws IOException {
            CopticCalendar copticCalendar = (CopticCalendar) this.obj;
            objectOutput.writeInt(copticCalendar.getYear());
            objectOutput.writeByte(copticCalendar.getMonth().getValue());
            objectOutput.writeByte(copticCalendar.getDayOfMonth());
        }

        private CopticCalendar readCoptic(ObjectInput objectInput) throws IOException {
            return CopticCalendar.of(objectInput.readInt(), (int) objectInput.readByte(), (int) objectInput.readByte());
        }
    }
}
