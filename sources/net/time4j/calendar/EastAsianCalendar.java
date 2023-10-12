package net.time4j.calendar;

import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.GeneralTimestamp;
import net.time4j.PlainTime;
import net.time4j.Weekday;
import net.time4j.base.MathUtils;
import net.time4j.calendar.EastAsianCalendar;
import net.time4j.calendar.SexagesimalName;
import net.time4j.engine.CalendarDate;
import net.time4j.engine.CalendarDays;
import net.time4j.engine.Calendrical;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ElementRule;
import net.time4j.engine.EpochDays;
import net.time4j.engine.IntElementRule;
import net.time4j.engine.UnitRule;
import net.time4j.format.CalendarType;

public abstract class EastAsianCalendar<U, D extends EastAsianCalendar<U, D>> extends Calendrical<U, D> {
    static final int CYCLE_INDEX = 3;
    static final int DAY_OF_MONTH_INDEX = 0;
    static final int DAY_OF_YEAR_INDEX = 1;
    static final int MONTH_AS_ORDINAL_INDEX = 2;
    static final int UNIT_CYCLES = 0;
    static final int UNIT_DAYS = 4;
    static final int UNIT_MONTHS = 2;
    static final int UNIT_WEEKS = 3;
    static final int UNIT_YEARS = 1;
    private final transient int cycle;
    private final transient int dayOfMonth;
    private final transient int leapMonth;
    private final transient EastAsianMonth month;
    private final transient long utcDays;
    private final transient int yearOfCycle;

    /* access modifiers changed from: package-private */
    public abstract EastAsianCS<D> getCalendarSystem();

    EastAsianCalendar(int i, int i2, EastAsianMonth eastAsianMonth, int i3, long j) {
        this.cycle = i;
        this.yearOfCycle = i2;
        this.month = eastAsianMonth;
        this.dayOfMonth = i3;
        this.utcDays = j;
        this.leapMonth = getCalendarSystem().getLeapMonth(i, i2);
    }

    public CyclicYear getYear() {
        return CyclicYear.of(this.yearOfCycle);
    }

    public SolarTerm getSolarTerm() {
        return EastAsianST.getInstance().getValue((EastAsianCalendar) getContext());
    }

    public EastAsianMonth getMonth() {
        return this.month;
    }

    public int getDayOfMonth() {
        return this.dayOfMonth;
    }

    public Weekday getDayOfWeek() {
        return Weekday.valueOf(MathUtils.floorModulo(this.utcDays + 5, 7) + 1);
    }

    public int getDayOfYear() {
        return (int) ((this.utcDays - getCalendarSystem().newYear(this.cycle, this.yearOfCycle)) + 1);
    }

    public SexagesimalName getSexagesimalMonth() {
        int floorModulo = MathUtils.floorModulo(getSolarTerm().getIndex() + 1, 12);
        SexagesimalName.Branch branch = SexagesimalName.Branch.values()[floorModulo];
        int elapsedCyclicYears = EastAsianYear.forGregorian(((Integer) get(CommonElements.RELATED_GREGORIAN_YEAR)).intValue()).getElapsedCyclicYears();
        if (floorModulo <= 2) {
            long daysSinceEpochUTC = SolarTerm.MINOR_11_DAXUE_255.onOrAfter((EastAsianCalendar) minus(CalendarDays.of(this.utcDays - newYearUTC(0)))).getDaysSinceEpochUTC();
            long j = this.utcDays;
            if (j >= daysSinceEpochUTC && j < newYearUTC(1)) {
                elapsedCyclicYears++;
            }
        }
        return SexagesimalName.of(SexagesimalName.Stem.values()[MathUtils.floorModulo(((elapsedCyclicYears - 1) * 12) + floorModulo + 2, 10)], branch);
    }

    public SexagesimalName getSexagesimalDay() {
        int i = 60;
        int floorModulo = MathUtils.floorModulo(EpochDays.RATA_DIE.transform(this.utcDays, EpochDays.UTC) - 45, 60);
        if (floorModulo != 0) {
            i = floorModulo;
        }
        return SexagesimalName.of(i);
    }

    public boolean isLeapYear() {
        return this.leapMonth > 0;
    }

    public EastAsianMonth findLeapMonth() {
        int leapMonth2 = getCalendarSystem().getLeapMonth(getCycle(), getYear().getNumber());
        if (leapMonth2 == 0) {
            return null;
        }
        return EastAsianMonth.valueOf(leapMonth2).withLeap();
    }

    public D withBeginOfNextLeapMonth() {
        EastAsianCalendar eastAsianCalendar = (EastAsianCalendar) getContext();
        EastAsianCS calendarSystem = eastAsianCalendar.getCalendarSystem();
        int cycle2 = eastAsianCalendar.getCycle();
        int number = eastAsianCalendar.getYear().getNumber();
        while (true) {
            int leapMonth2 = calendarSystem.getLeapMonth(cycle2, number);
            if (leapMonth2 > 0) {
                EastAsianMonth withLeap = EastAsianMonth.valueOf(leapMonth2).withLeap();
                if (eastAsianCalendar.getMonth().compareTo(withLeap) < 0) {
                    return calendarSystem.transform(calendarSystem.transform(cycle2, number, withLeap, 1));
                }
            }
            number++;
            if (number > 60) {
                cycle2++;
                number = 1;
            }
            eastAsianCalendar = calendarSystem.transform(calendarSystem.transform(cycle2, number, EastAsianMonth.valueOf(1), 1));
        }
    }

    public int lengthOfMonth() {
        return (int) (((((long) this.dayOfMonth) + getCalendarSystem().newMoonOnOrAfter(this.utcDays + 1)) - this.utcDays) - 1);
    }

    public int lengthOfYear() {
        int i = this.cycle;
        int i2 = 1;
        int i3 = this.yearOfCycle + 1;
        if (i3 > 60) {
            i++;
        } else {
            i2 = i3;
        }
        return (int) (getCalendarSystem().newYear(i, i2) - getCalendarSystem().newYear(this.cycle, this.yearOfCycle));
    }

    public GeneralTimestamp<D> at(PlainTime plainTime) {
        return GeneralTimestamp.of((Calendrical) getContext(), plainTime);
    }

    public GeneralTimestamp<D> atTime(int i, int i2) {
        return at(PlainTime.of(i, i2));
    }

    public long getDaysSinceEpochUTC() {
        return this.utcDays;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EastAsianCalendar eastAsianCalendar = (EastAsianCalendar) obj;
        if (this.cycle == eastAsianCalendar.cycle && this.yearOfCycle == eastAsianCalendar.yearOfCycle && this.dayOfMonth == eastAsianCalendar.dayOfMonth && this.month.equals(eastAsianCalendar.month) && this.utcDays == eastAsianCalendar.utcDays) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.utcDays;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String value = ((CalendarType) getClass().getAnnotation(CalendarType.class)).value();
        if (value.equals("dangi")) {
            value = "korean";
        }
        sb.append(value);
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        sb.append(getYear().getDisplayName(Locale.ROOT));
        sb.append('(');
        sb.append(getInt(CommonElements.RELATED_GREGORIAN_YEAR));
        sb.append(")-");
        sb.append(this.month.toString());
        sb.append(SignatureVisitor.SUPER);
        if (this.dayOfMonth < 10) {
            sb.append('0');
        }
        sb.append(this.dayOfMonth);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    static <D extends EastAsianCalendar<?, D>> ElementRule<D, Integer> getCycleRule(ChronoElement<?> chronoElement) {
        return new IntegerElementRule(3, chronoElement);
    }

    static <D extends EastAsianCalendar<?, D>> ElementRule<D, CyclicYear> getYearOfCycleRule(ChronoElement<?> chronoElement) {
        return new CyclicYearRule(chronoElement, false);
    }

    static <D extends EastAsianCalendar<?, D>> ElementRule<D, CyclicYear> getVietYearOfCycleRule(ChronoElement<?> chronoElement) {
        return new CyclicYearRule(chronoElement, true);
    }

    static <D extends EastAsianCalendar<?, D>> ElementRule<D, EastAsianMonth> getMonthOfYearRule(ChronoElement<?> chronoElement) {
        return new MonthRule(chronoElement);
    }

    static <D extends EastAsianCalendar<?, D>> ElementRule<D, Integer> getMonthAsOrdinalRule(ChronoElement<?> chronoElement) {
        return new IntegerElementRule(2, chronoElement);
    }

    static <D extends EastAsianCalendar<?, D>> ElementRule<D, Integer> getDayOfMonthRule() {
        return new IntegerElementRule(0, (ChronoElement) null);
    }

    static <D extends EastAsianCalendar<?, D>> ElementRule<D, Integer> getDayOfYearRule() {
        return new IntegerElementRule(1, (ChronoElement) null);
    }

    static <D extends EastAsianCalendar<?, D>> UnitRule<D> getUnitRule(int i) {
        return new EastAsianUnitRule(i);
    }

    /* access modifiers changed from: package-private */
    public int getCycle() {
        return this.cycle;
    }

    /* access modifiers changed from: package-private */
    public int getLeapMonth() {
        return this.leapMonth;
    }

    private long newYearUTC(int i) {
        return getCalendarSystem().newYear(this.cycle, this.yearOfCycle + i);
    }

    private static class IntegerElementRule<D extends EastAsianCalendar<?, D>> implements IntElementRule<D> {
        private final ChronoElement<?> child;
        private final int index;

        private IntegerElementRule(int i, ChronoElement<?> chronoElement) {
            this.index = i;
            this.child = chronoElement;
        }

        public int getInt(D d) {
            int i = this.index;
            if (i == 0) {
                return d.getDayOfMonth();
            }
            if (i == 1) {
                return d.getDayOfYear();
            }
            if (i == 2) {
                int number = d.getMonth().getNumber();
                int leapMonth = d.getLeapMonth();
                return ((leapMonth <= 0 || leapMonth >= number) && !d.getMonth().isLeap()) ? number : number + 1;
            } else if (i == 3) {
                return d.getCycle();
            } else {
                throw new UnsupportedOperationException("Unknown element index: " + this.index);
            }
        }

        public boolean isValid(D d, int i) {
            if (i < 1) {
                return false;
            }
            int i2 = this.index;
            if (i2 == 0) {
                if (i > 30) {
                    return false;
                }
                if (i != 30 || d.lengthOfMonth() == 30) {
                    return true;
                }
                return false;
            } else if (i2 == 1) {
                if (i <= d.lengthOfYear()) {
                    return true;
                }
                return false;
            } else if (i2 == 2) {
                if (i <= 12 || (i == 13 && d.getLeapMonth() > 0)) {
                    return true;
                }
                return false;
            } else if (i2 == 3) {
                EastAsianCS calendarSystem = d.getCalendarSystem();
                int cycle = ((EastAsianCalendar) calendarSystem.transform(calendarSystem.getMinimumSinceUTC())).getCycle();
                int cycle2 = ((EastAsianCalendar) calendarSystem.transform(calendarSystem.getMaximumSinceUTC())).getCycle();
                if (i < cycle || i > cycle2) {
                    return false;
                }
                return true;
            } else {
                throw new UnsupportedOperationException("Unknown element index: " + this.index);
            }
        }

        public D withValue(D d, int i, boolean z) {
            int i2 = this.index;
            boolean z2 = true;
            if (i2 != 0) {
                if (i2 != 1) {
                    boolean z3 = false;
                    if (i2 != 2) {
                        if (i2 != 3) {
                            throw new UnsupportedOperationException("Unknown element index: " + this.index);
                        } else if (isValid(d, i)) {
                            return (EastAsianCalendar) EastAsianCalendar.getUnitRule(0).addTo(d, (long) (i - d.getCycle()));
                        } else {
                            throw new IllegalArgumentException("Sexagesimal cycle out of range: " + i);
                        }
                    } else if (isValid(d, i)) {
                        int leapMonth = d.getLeapMonth();
                        if (leapMonth > 0 && leapMonth < i) {
                            if (i != leapMonth + 1) {
                                z2 = false;
                            }
                            i--;
                            z3 = z2;
                        }
                        EastAsianMonth valueOf = EastAsianMonth.valueOf(i);
                        if (z3) {
                            valueOf = valueOf.withLeap();
                        }
                        return MonthRule.withMonth(d, valueOf);
                    } else {
                        throw new IllegalArgumentException("Ordinal month out of range: " + i);
                    }
                } else if (z || (i >= 1 && i <= d.lengthOfYear())) {
                    return d.getCalendarSystem().transform((d.getDaysSinceEpochUTC() + ((long) i)) - ((long) d.getDayOfYear()));
                } else {
                    throw new IllegalArgumentException("Day of year out of range: " + i);
                }
            } else if (z) {
                return d.getCalendarSystem().transform((d.getDaysSinceEpochUTC() + ((long) i)) - ((long) d.getDayOfMonth()));
            } else if (i < 1 || i > 30 || (i == 30 && d.lengthOfMonth() < 30)) {
                throw new IllegalArgumentException("Day of month out of range: " + i);
            } else {
                return d.getCalendarSystem().create(d.getCycle(), d.getYear().getNumber(), d.getMonth(), i, (d.getDaysSinceEpochUTC() + ((long) i)) - ((long) d.getDayOfMonth()));
            }
        }

        public Integer getValue(D d) {
            return Integer.valueOf(getInt(d));
        }

        public Integer getMinimum(D d) {
            if (this.index != 3) {
                return 1;
            }
            EastAsianCS calendarSystem = d.getCalendarSystem();
            return Integer.valueOf(((EastAsianCalendar) calendarSystem.transform(calendarSystem.getMinimumSinceUTC())).getCycle());
        }

        public Integer getMaximum(D d) {
            int i;
            int i2 = this.index;
            if (i2 == 0) {
                i = d.lengthOfMonth();
            } else if (i2 == 1) {
                i = d.lengthOfYear();
            } else if (i2 == 2) {
                i = d.isLeapYear() ? 13 : 12;
            } else if (i2 == 3) {
                EastAsianCS calendarSystem = d.getCalendarSystem();
                i = ((EastAsianCalendar) calendarSystem.transform(calendarSystem.getMaximumSinceUTC())).getCycle();
            } else {
                throw new UnsupportedOperationException("Unknown element index: " + this.index);
            }
            return Integer.valueOf(i);
        }

        public boolean isValid(D d, Integer num) {
            return num != null && isValid(d, num.intValue());
        }

        public D withValue(D d, Integer num, boolean z) {
            if (num != null) {
                return withValue(d, num.intValue(), z);
            }
            throw new IllegalArgumentException("Missing element value.");
        }

        public ChronoElement<?> getChildAtFloor(D d) {
            return this.child;
        }

        public ChronoElement<?> getChildAtCeiling(D d) {
            return this.child;
        }
    }

    private static class CyclicYearRule<D extends EastAsianCalendar<?, D>> implements ElementRule<D, CyclicYear> {
        private final ChronoElement<?> child;
        private final boolean vietnam;

        private CyclicYearRule(ChronoElement<?> chronoElement, boolean z) {
            this.child = chronoElement;
            this.vietnam = z;
        }

        public CyclicYear getValue(D d) {
            return d.getYear();
        }

        public CyclicYear getMinimum(D d) {
            return this.vietnam ? d.getCycle() == 75 ? CyclicYear.of(10) : CyclicYear.of(1) : d.getCycle() == 72 ? CyclicYear.of(22) : CyclicYear.of(1);
        }

        public CyclicYear getMaximum(D d) {
            return CyclicYear.of(d.getCycle() == 94 ? 56 : 60);
        }

        public boolean isValid(D d, CyclicYear cyclicYear) {
            return cyclicYear != null && getMinimum(d).compareTo((SexagesimalName) cyclicYear) <= 0 && getMaximum(d).compareTo((SexagesimalName) cyclicYear) >= 0;
        }

        public D withValue(D d, CyclicYear cyclicYear, boolean z) {
            if (isValid(d, cyclicYear)) {
                EastAsianCS calendarSystem = d.getCalendarSystem();
                int dayOfMonth = d.getDayOfMonth();
                EastAsianMonth month = d.getMonth();
                int number = cyclicYear.getNumber();
                int cycle = d.getCycle();
                EastAsianMonth valueOf = (!month.isLeap() || month.getNumber() == calendarSystem.getLeapMonth(cycle, number)) ? month : EastAsianMonth.valueOf(month.getNumber());
                if (dayOfMonth <= 29) {
                    return calendarSystem.create(cycle, number, valueOf, dayOfMonth, calendarSystem.transform(cycle, number, valueOf, dayOfMonth));
                }
                long transform = calendarSystem.transform(cycle, number, valueOf, 1);
                int min = Math.min(dayOfMonth, calendarSystem.transform(transform).lengthOfMonth());
                return calendarSystem.create(cycle, number, valueOf, min, (transform + ((long) min)) - 1);
            }
            throw new IllegalArgumentException("Invalid cyclic year: " + cyclicYear);
        }

        public ChronoElement<?> getChildAtFloor(D d) {
            return this.child;
        }

        public ChronoElement<?> getChildAtCeiling(D d) {
            return this.child;
        }
    }

    private static class MonthRule<D extends EastAsianCalendar<?, D>> implements ElementRule<D, EastAsianMonth> {
        private final ChronoElement<?> child;

        private MonthRule(ChronoElement<?> chronoElement) {
            this.child = chronoElement;
        }

        public EastAsianMonth getValue(D d) {
            return d.getMonth();
        }

        public EastAsianMonth getMinimum(D d) {
            return EastAsianMonth.valueOf(1);
        }

        public EastAsianMonth getMaximum(D d) {
            return EastAsianMonth.valueOf(12);
        }

        public boolean isValid(D d, EastAsianMonth eastAsianMonth) {
            return eastAsianMonth != null && (!eastAsianMonth.isLeap() || eastAsianMonth.getNumber() == d.getLeapMonth());
        }

        public D withValue(D d, EastAsianMonth eastAsianMonth, boolean z) {
            if (isValid(d, eastAsianMonth)) {
                return withMonth(d, eastAsianMonth);
            }
            throw new IllegalArgumentException("Invalid month: " + eastAsianMonth);
        }

        public ChronoElement<?> getChildAtFloor(D d) {
            return this.child;
        }

        public ChronoElement<?> getChildAtCeiling(D d) {
            return this.child;
        }

        static <D extends EastAsianCalendar<?, D>> D withMonth(D d, EastAsianMonth eastAsianMonth) {
            EastAsianCS calendarSystem = d.getCalendarSystem();
            int dayOfMonth = d.getDayOfMonth();
            int number = d.getYear().getNumber();
            if (dayOfMonth <= 29) {
                return calendarSystem.create(d.getCycle(), number, eastAsianMonth, dayOfMonth, calendarSystem.transform(d.getCycle(), number, eastAsianMonth, dayOfMonth));
            }
            long transform = calendarSystem.transform(d.getCycle(), number, eastAsianMonth, 1);
            int min = Math.min(dayOfMonth, calendarSystem.transform(transform).lengthOfMonth());
            return calendarSystem.create(d.getCycle(), number, eastAsianMonth, min, (transform + ((long) min)) - 1);
        }
    }

    private static class EastAsianUnitRule<D extends EastAsianCalendar<?, D>> implements UnitRule<D> {
        private final int index;

        EastAsianUnitRule(int i) {
            this.index = i;
        }

        public D addTo(D d, long j) {
            long j2 = j;
            EastAsianCS calendarSystem = d.getCalendarSystem();
            int dayOfMonth = d.getDayOfMonth();
            int cycle = d.getCycle();
            int number = d.getYear().getNumber();
            EastAsianMonth month = d.getMonth();
            int i = this.index;
            if (i == 0) {
                j2 = MathUtils.safeMultiply(j2, 60);
            } else if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        j2 = MathUtils.safeMultiply(j2, 7);
                    } else if (i != 4) {
                        throw new UnsupportedOperationException();
                    }
                    return calendarSystem.transform(MathUtils.safeAdd(d.getDaysSinceEpochUTC(), j2));
                }
                checkAmountOfMonths(j);
                int i2 = -1;
                int i3 = j2 > 0 ? 1 : -1;
                int number2 = month.getNumber();
                boolean isLeap = month.isLeap();
                int leapMonth = calendarSystem.getLeapMonth(cycle, number);
                for (long j3 = 0; j2 != j3; j3 = 0) {
                    if (isLeap) {
                        isLeap = false;
                        if (i3 == 1) {
                            number2++;
                        }
                    } else {
                        if (!(i3 == 1 && leapMonth == number2)) {
                            if (i3 == i2 && leapMonth == number2 - 1) {
                                number2--;
                            } else {
                                number2 += i3;
                            }
                        }
                        isLeap = true;
                    }
                    if (!isLeap) {
                        if (number2 == 13) {
                            number++;
                            if (number == 61) {
                                cycle++;
                                number = 1;
                            }
                            leapMonth = calendarSystem.getLeapMonth(cycle, number);
                            number2 = 1;
                        } else if (number2 == 0) {
                            int i4 = number - 1;
                            if (i4 == 0) {
                                cycle--;
                                i4 = 60;
                            }
                            leapMonth = calendarSystem.getLeapMonth(cycle, number);
                            number2 = 12;
                        }
                    }
                    j2 -= (long) i3;
                    i2 = -1;
                }
                EastAsianMonth valueOf = EastAsianMonth.valueOf(number2);
                if (isLeap) {
                    valueOf = valueOf.withLeap();
                }
                return create(cycle, number, valueOf, dayOfMonth, calendarSystem);
            }
            long safeAdd = MathUtils.safeAdd((long) (((cycle * 60) + number) - 1), j2);
            int safeCast = MathUtils.safeCast(MathUtils.floorDivide(safeAdd, 60));
            int floorModulo = MathUtils.floorModulo(safeAdd, 60) + 1;
            if (month.isLeap() && calendarSystem.getLeapMonth(safeCast, floorModulo) != month.getNumber()) {
                month = EastAsianMonth.valueOf(month.getNumber());
            }
            return create(safeCast, floorModulo, month, dayOfMonth, calendarSystem);
        }

        public long between(D d, D d2) {
            return between(d, d2, this.index);
        }

        private static <D extends EastAsianCalendar<?, D>> long between(D d, D d2, int i) {
            int compareTo;
            D d3;
            D d4;
            EastAsianCS calendarSystem = d.getCalendarSystem();
            if (i == 0) {
                return between(d, d2, 1) / 60;
            }
            if (i == 1) {
                int cycle = (((d2.getCycle() * 60) + d2.getYear().getNumber()) - (d.getCycle() * 60)) - d.getYear().getNumber();
                if (cycle > 0) {
                    int compareTo2 = d.getMonth().compareTo(d2.getMonth());
                    if (compareTo2 > 0 || (compareTo2 == 0 && d.getDayOfMonth() > d2.getDayOfMonth())) {
                        cycle--;
                    }
                } else if (cycle < 0 && ((compareTo = d.getMonth().compareTo(d2.getMonth())) < 0 || (compareTo == 0 && d.getDayOfMonth() < d2.getDayOfMonth()))) {
                    cycle++;
                }
                return (long) cycle;
            } else if (i == 2) {
                boolean isAfter = d.isAfter((CalendarDate) d2);
                if (isAfter) {
                    d3 = d;
                    d4 = d2;
                } else {
                    d4 = d;
                    d3 = d2;
                }
                int cycle2 = d4.getCycle();
                int number = d4.getYear().getNumber();
                EastAsianMonth month = d4.getMonth();
                int number2 = month.getNumber();
                boolean isLeap = month.isLeap();
                int leapMonth = calendarSystem.getLeapMonth(cycle2, number);
                int i2 = 0;
                while (true) {
                    if (cycle2 == d3.getCycle() && number == d3.getYear().getNumber() && month.equals(d3.getMonth())) {
                        break;
                    }
                    if (isLeap) {
                        number2++;
                        isLeap = false;
                    } else if (leapMonth == number2) {
                        isLeap = true;
                    } else {
                        number2++;
                    }
                    if (!isLeap) {
                        if (number2 == 13) {
                            number++;
                            if (number == 61) {
                                cycle2++;
                                number = 1;
                            }
                            leapMonth = calendarSystem.getLeapMonth(cycle2, number);
                            number2 = 1;
                        } else if (number2 == 0) {
                            int i3 = number - 1;
                            if (i3 == 0) {
                                cycle2--;
                                i3 = 60;
                            }
                            leapMonth = calendarSystem.getLeapMonth(cycle2, number);
                            number2 = 12;
                        }
                    }
                    month = EastAsianMonth.valueOf(number2);
                    if (isLeap) {
                        month = month.withLeap();
                    }
                    i2++;
                }
                if (i2 > 0 && d4.getDayOfMonth() > d3.getDayOfMonth()) {
                    i2--;
                }
                if (isAfter) {
                    i2 = -i2;
                }
                return (long) i2;
            } else if (i == 3) {
                return (d2.getDaysSinceEpochUTC() - d.getDaysSinceEpochUTC()) / 7;
            } else {
                if (i == 4) {
                    return d2.getDaysSinceEpochUTC() - d.getDaysSinceEpochUTC();
                }
                throw new UnsupportedOperationException();
            }
        }

        private static <D extends EastAsianCalendar<?, D>> D create(int i, int i2, EastAsianMonth eastAsianMonth, int i3, EastAsianCS<D> eastAsianCS) {
            if (i3 <= 29) {
                return eastAsianCS.create(i, i2, eastAsianMonth, i3, eastAsianCS.transform(i, i2, eastAsianMonth, i3));
            }
            long transform = eastAsianCS.transform(i, i2, eastAsianMonth, 1);
            int min = Math.min(i3, eastAsianCS.transform(transform).lengthOfMonth());
            return eastAsianCS.create(i, i2, eastAsianMonth, min, (transform + ((long) min)) - 1);
        }

        private static void checkAmountOfMonths(long j) {
            if (j > 1200 || j < -1200) {
                throw new ArithmeticException("Month arithmetic limited to delta not greater than 1200.");
            }
        }
    }
}
