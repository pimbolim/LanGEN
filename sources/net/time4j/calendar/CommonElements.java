package net.time4j.calendar;

import java.io.ObjectStreamException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import net.time4j.Weekday;
import net.time4j.Weekmodel;
import net.time4j.base.MathUtils;
import net.time4j.calendar.service.StdEnumDateElement;
import net.time4j.calendar.service.StdIntegerDateElement;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.BasicElement;
import net.time4j.engine.CalendarDate;
import net.time4j.engine.CalendarVariant;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoExtension;
import net.time4j.engine.ChronoOperator;
import net.time4j.engine.Chronology;
import net.time4j.engine.ElementRule;
import net.time4j.engine.EpochDays;
import net.time4j.engine.FormattableElement;

public class CommonElements {
    @FormattableElement(format = "r")
    public static final ChronoElement<Integer> RELATED_GREGORIAN_YEAR = RelatedGregorianYearElement.SINGLETON;

    private CommonElements() {
    }

    @FormattableElement(alt = "c", format = "e")
    public static <T extends ChronoEntity<T> & CalendarDate> StdCalendarElement<Weekday, T> localDayOfWeek(Chronology<T> chronology, Weekmodel weekmodel) {
        checkSevenDayWeek(chronology);
        return new DayOfWeekElement(chronology.getChronoType(), weekmodel);
    }

    @FormattableElement(format = "w")
    public static <T extends ChronoEntity<T> & CalendarDate> StdCalendarElement<Integer, T> weekOfYear(Chronology<T> chronology, Weekmodel weekmodel) {
        ChronoElement<Integer> findDayElement = findDayElement(chronology, "DAY_OF_YEAR");
        if (findDayElement != null) {
            return new CalendarWeekElement("WEEK_OF_YEAR", chronology.getChronoType(), 1, 52, 'w', weekmodel, findDayElement, false);
        }
        throw new IllegalArgumentException("Cannot derive a rule for given chronology: " + chronology);
    }

    @FormattableElement(format = "W")
    public static <T extends ChronoEntity<T> & CalendarDate> StdCalendarElement<Integer, T> weekOfMonth(Chronology<T> chronology, Weekmodel weekmodel) {
        ChronoElement<Integer> findDayElement = findDayElement(chronology, "DAY_OF_MONTH");
        if (findDayElement != null) {
            return new CalendarWeekElement("WEEK_OF_MONTH", chronology.getChronoType(), 1, 5, 'W', weekmodel, findDayElement, false);
        }
        throw new IllegalArgumentException("Cannot derive a rule for given chronology: " + chronology);
    }

    public static <T extends ChronoEntity<T> & CalendarDate> StdCalendarElement<Integer, T> boundedWeekOfYear(Chronology<T> chronology, Weekmodel weekmodel) {
        ChronoElement<Integer> findDayElement = findDayElement(chronology, "DAY_OF_YEAR");
        if (findDayElement != null) {
            return new CalendarWeekElement("BOUNDED_WEEK_OF_YEAR", chronology.getChronoType(), 1, 52, 0, weekmodel, findDayElement, true);
        }
        throw new IllegalArgumentException("Cannot derive a rule for given chronology: " + chronology);
    }

    public static <T extends ChronoEntity<T> & CalendarDate> StdCalendarElement<Integer, T> boundedWeekOfMonth(Chronology<T> chronology, Weekmodel weekmodel) {
        ChronoElement<Integer> findDayElement = findDayElement(chronology, "DAY_OF_MONTH");
        if (findDayElement != null) {
            return new CalendarWeekElement("BOUNDED_WEEK_OF_MONTH", chronology.getChronoType(), 1, 5, 0, weekmodel, findDayElement, true);
        }
        throw new IllegalArgumentException("Cannot derive a rule for given chronology: " + chronology);
    }

    /* access modifiers changed from: private */
    public static <D extends ChronoEntity<D>> int getMax(ChronoElement<?> chronoElement, D d) {
        return Integer.class.cast(d.getMaximum(chronoElement)).intValue();
    }

    /* access modifiers changed from: private */
    public static Weekday getDayOfWeek(long j) {
        return Weekday.valueOf(MathUtils.floorModulo(j + 5, 7) + 1);
    }

    private static void checkSevenDayWeek(Chronology<?> chronology) {
        Object[] enumConstants;
        if (CalendarDate.class.isAssignableFrom(chronology.getChronoType())) {
            for (ChronoElement next : chronology.getRegisteredElements()) {
                if (next.name().equals("DAY_OF_WEEK") && (enumConstants = next.getType().getEnumConstants()) != null && enumConstants.length == 7) {
                    return;
                }
            }
        }
        throw new IllegalArgumentException("No 7-day-week: " + chronology);
    }

    private static <D extends ChronoEntity<D>> ChronoElement<Integer> findDayElement(Chronology<D> chronology, String str) {
        checkSevenDayWeek(chronology);
        for (ChronoElement<Integer> next : chronology.getRegisteredElements()) {
            if (next.name().equals(str)) {
                if (next.getType() == Integer.class) {
                    return next;
                }
                return null;
            }
        }
        return null;
    }

    static class Weekengine implements ChronoExtension {
        private final Class<? extends ChronoEntity> chronoType;
        private final ChronoElement<Integer> dayOfMonthElement;
        private final ChronoElement<Integer> dayOfYearElement;
        private final Weekmodel defaultWeekmodel;

        public boolean canResolve(ChronoElement<?> chronoElement) {
            return false;
        }

        public ChronoEntity<?> resolve(ChronoEntity<?> chronoEntity, Locale locale, AttributeQuery attributeQuery) {
            return chronoEntity;
        }

        Weekengine(Class<? extends ChronoEntity> cls, ChronoElement<Integer> chronoElement, ChronoElement<Integer> chronoElement2, Weekmodel weekmodel) {
            this.chronoType = cls;
            this.dayOfMonthElement = chronoElement;
            this.dayOfYearElement = chronoElement2;
            this.defaultWeekmodel = weekmodel;
        }

        public boolean accept(Class<?> cls) {
            return this.chronoType.equals(cls);
        }

        public Set<ChronoElement<?>> getElements(Locale locale, AttributeQuery attributeQuery) {
            Weekmodel of = locale.getCountry().isEmpty() ? this.defaultWeekmodel : Weekmodel.of(locale);
            HashSet hashSet = new HashSet();
            hashSet.add(DayOfWeekElement.of(this.chronoType, of));
            Weekmodel weekmodel = of;
            hashSet.add(CalendarWeekElement.of("WEEK_OF_MONTH", this.chronoType, 1, 5, 'W', weekmodel, this.dayOfMonthElement, false));
            hashSet.add(CalendarWeekElement.of("WEEK_OF_YEAR", this.chronoType, 1, 52, 'w', weekmodel, this.dayOfYearElement, false));
            hashSet.add(CalendarWeekElement.of("BOUNDED_WEEK_OF_MONTH", this.chronoType, 1, 5, 0, weekmodel, this.dayOfMonthElement, true));
            hashSet.add(CalendarWeekElement.of("BOUNDED_WEEK_OF_YEAR", this.chronoType, 1, 52, 0, weekmodel, this.dayOfYearElement, true));
            return Collections.unmodifiableSet(hashSet);
        }
    }

    private static class CalendarWeekElement<T extends ChronoEntity<T>> extends StdIntegerDateElement<T> {
        private static final long serialVersionUID = -7471192143785466686L;
        private final boolean bounded;
        /* access modifiers changed from: private */
        public final ChronoElement<Integer> dayElement;
        /* access modifiers changed from: private */
        public final Weekmodel model;

        public boolean isLenient() {
            return true;
        }

        /* access modifiers changed from: protected */
        public Object readResolve() throws ObjectStreamException {
            return this;
        }

        CalendarWeekElement(String str, Class<T> cls, int i, int i2, char c, Weekmodel weekmodel, ChronoElement<Integer> chronoElement, boolean z) {
            super(str, cls, i, i2, c);
            Objects.requireNonNull(weekmodel, "Missing week model.");
            this.model = weekmodel;
            this.dayElement = chronoElement;
            this.bounded = z;
        }

        static <T extends ChronoEntity<T>> CalendarWeekElement<T> of(String str, Class<T> cls, int i, int i2, char c, Weekmodel weekmodel, ChronoElement<Integer> chronoElement, boolean z) {
            return new CalendarWeekElement(str, cls, i, i2, c, weekmodel, chronoElement, z);
        }

        public ChronoOperator<T> decremented() {
            return new DayOperator(-7);
        }

        public ChronoOperator<T> incremented() {
            return new DayOperator(7);
        }

        /* access modifiers changed from: protected */
        public boolean doEquals(BasicElement<?> basicElement) {
            if (!super.doEquals(basicElement)) {
                return false;
            }
            CalendarWeekElement cast = CalendarWeekElement.class.cast(basicElement);
            if (!this.model.equals(cast.model) || this.bounded != cast.bounded) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: protected */
        public <D extends ChronoEntity<D>> ElementRule<D, Integer> derive(Chronology<D> chronology) {
            if (getChronoType().equals(chronology.getChronoType())) {
                return this.bounded ? new BWRule(this) : new CWRule(this);
            }
            return null;
        }
    }

    private static class CWRule<D extends ChronoEntity<D>> implements ElementRule<D, Integer> {
        private final CalendarWeekElement<?> owner;

        private CWRule(CalendarWeekElement<?> calendarWeekElement) {
            this.owner = calendarWeekElement;
        }

        public Integer getValue(D d) {
            return Integer.valueOf(getCalendarWeek(d));
        }

        public Integer getMinimum(D d) {
            return 1;
        }

        public Integer getMaximum(D d) {
            return Integer.valueOf(getMaxCalendarWeek(d));
        }

        public boolean isValid(D d, Integer num) {
            int intValue;
            if (num != null && (intValue = num.intValue()) >= 1 && intValue <= getMaxCalendarWeek(d)) {
                return true;
            }
            return false;
        }

        public D withValue(D d, Integer num, boolean z) {
            int intValue = num.intValue();
            if (z || isValid(d, num)) {
                return setCalendarWeek(d, intValue);
            }
            throw new IllegalArgumentException("Invalid value: " + intValue + " (context=" + d + ")");
        }

        public ChronoElement<?> getChildAtFloor(D d) {
            return getChild(d.getClass());
        }

        public ChronoElement<?> getChildAtCeiling(D d) {
            return getChild(d.getClass());
        }

        private ChronoElement<?> getChild(Object obj) {
            return new DayOfWeekElement((Class) obj, this.owner.model);
        }

        private int getMaxCalendarWeek(D d) {
            int i = d.getInt(this.owner.dayElement);
            int firstCalendarWeekAsDay = getFirstCalendarWeekAsDay(d, 0);
            if (firstCalendarWeekAsDay <= i) {
                int firstCalendarWeekAsDay2 = getFirstCalendarWeekAsDay(d, 1) + getLengthOfYM(d, 0);
                if (firstCalendarWeekAsDay2 <= i) {
                    try {
                        int firstCalendarWeekAsDay3 = getFirstCalendarWeekAsDay(d, 1);
                        firstCalendarWeekAsDay2 = getFirstCalendarWeekAsDay(d.with((ChronoElement<Long>) EpochDays.UTC, ((Long) d.get(EpochDays.UTC)).longValue() + 7), 1) + getLengthOfYM(d, 1);
                        firstCalendarWeekAsDay = firstCalendarWeekAsDay3;
                    } catch (RuntimeException unused) {
                        firstCalendarWeekAsDay2 += 7;
                    }
                }
                return (firstCalendarWeekAsDay2 - firstCalendarWeekAsDay) / 7;
            }
            return ((firstCalendarWeekAsDay + getLengthOfYM(d, -1)) - getFirstCalendarWeekAsDay(d, -1)) / 7;
        }

        private int getFirstCalendarWeekAsDay(D d, int i) {
            Weekday weekdayStart = getWeekdayStart(d, i);
            Weekmodel access$200 = this.owner.model;
            int value = weekdayStart.getValue(access$200);
            return value <= 8 - access$200.getMinimalDaysInFirstWeek() ? 2 - value : 9 - value;
        }

        private Weekday getWeekdayStart(D d, int i) {
            int i2 = d.getInt(this.owner.dayElement);
            if (i == -1) {
                long longValue = ((Long) d.get(EpochDays.UTC)).longValue() - ((long) i2);
                return CommonElements.getDayOfWeek((longValue - ((long) d.with((ChronoElement<Long>) EpochDays.UTC, longValue).getInt(this.owner.dayElement))) + 1);
            } else if (i == 0) {
                return CommonElements.getDayOfWeek((((Long) d.get(EpochDays.UTC)).longValue() - ((long) i2)) + 1);
            } else {
                if (i == 1) {
                    return CommonElements.getDayOfWeek(((((Long) d.get(EpochDays.UTC)).longValue() + ((long) CommonElements.getMax(this.owner.dayElement, d))) + 1) - ((long) i2));
                }
                throw new AssertionError("Unexpected: " + i);
            }
        }

        private int getLengthOfYM(D d, int i) {
            int i2 = d.getInt(this.owner.dayElement);
            if (i == -1) {
                return CommonElements.getMax(this.owner.dayElement, d.with((ChronoElement<Long>) EpochDays.UTC, ((Long) d.get(EpochDays.UTC)).longValue() - ((long) i2)));
            }
            if (i == 0) {
                return CommonElements.getMax(this.owner.dayElement, d);
            }
            if (i == 1) {
                return CommonElements.getMax(this.owner.dayElement, d.with((ChronoElement<Long>) EpochDays.UTC, ((((Long) d.get(EpochDays.UTC)).longValue() + ((long) CommonElements.getMax(this.owner.dayElement, d))) + 1) - ((long) i2)));
            }
            throw new AssertionError("Unexpected: " + i);
        }

        private int getCalendarWeek(D d) {
            int lengthOfYM;
            int i = d.getInt(this.owner.dayElement);
            int firstCalendarWeekAsDay = getFirstCalendarWeekAsDay(d, 0);
            if (firstCalendarWeekAsDay > i) {
                lengthOfYM = ((i + getLengthOfYM(d, -1)) - getFirstCalendarWeekAsDay(d, -1)) / 7;
            } else if (getFirstCalendarWeekAsDay(d, 1) + getLengthOfYM(d, 0) <= i) {
                return 1;
            } else {
                lengthOfYM = (i - firstCalendarWeekAsDay) / 7;
            }
            return lengthOfYM + 1;
        }

        private D setCalendarWeek(D d, int i) {
            int calendarWeek = getCalendarWeek(d);
            if (i == calendarWeek) {
                return d;
            }
            return d.with((ChronoElement<Long>) EpochDays.UTC, ((Long) d.get(EpochDays.UTC)).longValue() + ((long) ((i - calendarWeek) * 7)));
        }
    }

    private static class BWRule<D extends ChronoEntity<D>> implements ElementRule<D, Integer> {
        private final CalendarWeekElement<?> owner;

        private BWRule(CalendarWeekElement<?> calendarWeekElement) {
            this.owner = calendarWeekElement;
        }

        public Integer getValue(D d) {
            return Integer.valueOf(getWeek(d));
        }

        public Integer getMinimum(D d) {
            return Integer.valueOf(getMinWeek(d));
        }

        public Integer getMaximum(D d) {
            return Integer.valueOf(getMaxWeek(d));
        }

        public ChronoElement<?> getChildAtFloor(D d) {
            return getChild(d, false);
        }

        public ChronoElement<?> getChildAtCeiling(D d) {
            return getChild(d, true);
        }

        private ChronoElement<?> getChild(D d, boolean z) {
            DayOfWeekElement of = DayOfWeekElement.of(d.getClass(), this.owner.model);
            int week = getWeek(d);
            long longValue = ((Long) d.get(EpochDays.UTC)).longValue();
            int i = d.getInt(this.owner.dayElement);
            if (z) {
                if (((long) ((Integer) d.getMaximum(this.owner.dayElement)).intValue()) < ((long) i) + (((Long) d.with(of, d.getMaximum(of)).get(EpochDays.UTC)).longValue() - longValue)) {
                    return this.owner.dayElement;
                }
            } else if (week <= 1) {
                if (((long) ((Integer) d.getMinimum(this.owner.dayElement)).intValue()) > ((long) i) - (longValue - ((Long) d.with(of, d.getMinimum(of)).get(EpochDays.UTC)).longValue())) {
                    return this.owner.dayElement;
                }
            }
            return of;
        }

        public boolean isValid(D d, Integer num) {
            int intValue;
            if (num != null && (intValue = num.intValue()) >= getMinWeek(d) && intValue <= getMaxWeek(d)) {
                return true;
            }
            return false;
        }

        public D withValue(D d, Integer num, boolean z) {
            if (num != null && (z || isValid(d, num))) {
                return setWeek(d, num.intValue());
            }
            throw new IllegalArgumentException("Invalid value: " + num + " (context=" + d + ")");
        }

        private int getWeek(D d) {
            return getWeek(d, 0);
        }

        private int getMinWeek(D d) {
            return getWeek(d, -1);
        }

        private int getMaxWeek(D d) {
            return getWeek(d, 1);
        }

        private int getWeek(D d, int i) {
            int i2 = d.getInt(this.owner.dayElement);
            int value = CommonElements.getDayOfWeek((((Long) d.get(EpochDays.UTC)).longValue() - ((long) i2)) + 1).getValue(this.owner.model);
            int i3 = value <= 8 - this.owner.model.getMinimalDaysInFirstWeek() ? 2 - value : 9 - value;
            if (i == -1) {
                i2 = 1;
            } else if (i != 0) {
                if (i == 1) {
                    i2 = ((Integer) d.getMaximum(this.owner.dayElement)).intValue();
                } else {
                    throw new AssertionError("Unexpected: " + i);
                }
            }
            return MathUtils.floorDivide(i2 - i3, 7) + 1;
        }

        private D setWeek(D d, int i) {
            int week = getWeek(d);
            if (i == week) {
                return d;
            }
            return d.with((ChronoElement<Long>) EpochDays.UTC, ((Long) d.get(EpochDays.UTC)).longValue() + ((long) ((i - week) * 7)));
        }
    }

    private static class DayOfWeekElement<T extends ChronoEntity<T>> extends StdEnumDateElement<Weekday, T> {
        private static final long serialVersionUID = 5613494586572932860L;
        /* access modifiers changed from: private */
        public final Weekmodel model;

        /* access modifiers changed from: protected */
        public boolean isWeekdayElement() {
            return true;
        }

        /* access modifiers changed from: protected */
        public Object readResolve() throws ObjectStreamException {
            return this;
        }

        DayOfWeekElement(Class<T> cls, Weekmodel weekmodel) {
            super("LOCAL_DAY_OF_WEEK", cls, Weekday.class, 'e');
            this.model = weekmodel;
        }

        static <T extends ChronoEntity<T>> DayOfWeekElement<T> of(Class<T> cls, Weekmodel weekmodel) {
            return new DayOfWeekElement<>(cls, weekmodel);
        }

        public ChronoOperator<T> decremented() {
            return new DayOperator(-1);
        }

        public ChronoOperator<T> incremented() {
            return new DayOperator(1);
        }

        public int numerical(Weekday weekday) {
            return weekday.getValue(this.model);
        }

        public Weekday getDefaultMinimum() {
            return this.model.getFirstDayOfWeek();
        }

        public Weekday getDefaultMaximum() {
            return this.model.getFirstDayOfWeek().roll(6);
        }

        public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
            int value = ((Weekday) chronoDisplay.get(this)).getValue(this.model);
            int value2 = ((Weekday) chronoDisplay2.get(this)).getValue(this.model);
            if (value < value2) {
                return -1;
            }
            return value == value2 ? 0 : 1;
        }

        /* access modifiers changed from: protected */
        public boolean doEquals(BasicElement<?> basicElement) {
            if (super.doEquals(basicElement)) {
                return this.model.equals(DayOfWeekElement.class.cast(basicElement).model);
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public <D extends ChronoEntity<D>> ElementRule<D, Weekday> derive(Chronology<D> chronology) {
            if (getChronoType().equals(chronology.getChronoType())) {
                return new DRule(this);
            }
            return null;
        }
    }

    private static class DRule<T extends ChronoEntity<T>> implements ElementRule<T, Weekday> {
        private final DayOfWeekElement<?> element;

        public ChronoElement<?> getChildAtCeiling(T t) {
            return null;
        }

        public ChronoElement<?> getChildAtFloor(T t) {
            return null;
        }

        private DRule(DayOfWeekElement<?> dayOfWeekElement) {
            this.element = dayOfWeekElement;
        }

        public Weekday getValue(T t) {
            return CommonElements.getDayOfWeek(((Long) t.get(EpochDays.UTC)).longValue());
        }

        public Weekday getMinimum(T t) {
            long j;
            Chronology<?> lookup = Chronology.lookup(t.getClass());
            if (t instanceof CalendarVariant) {
                j = lookup.getCalendarSystem(CalendarVariant.class.cast(t).getVariant()).getMinimumSinceUTC();
            } else {
                j = lookup.getCalendarSystem().getMinimumSinceUTC();
            }
            long longValue = ((Long) t.get(EpochDays.UTC)).longValue();
            if ((longValue + 1) - ((long) CommonElements.getDayOfWeek(longValue).getValue(this.element.model)) < j) {
                return CommonElements.getDayOfWeek(j);
            }
            return this.element.getDefaultMinimum();
        }

        public Weekday getMaximum(T t) {
            long j;
            Chronology<?> lookup = Chronology.lookup(t.getClass());
            if (t instanceof CalendarVariant) {
                j = lookup.getCalendarSystem(CalendarVariant.class.cast(t).getVariant()).getMaximumSinceUTC();
            } else {
                j = lookup.getCalendarSystem().getMaximumSinceUTC();
            }
            long longValue = ((Long) t.get(EpochDays.UTC)).longValue();
            if ((longValue + 7) - ((long) CommonElements.getDayOfWeek(longValue).getValue(this.element.model)) > j) {
                return CommonElements.getDayOfWeek(j);
            }
            return this.element.getDefaultMaximum();
        }

        public boolean isValid(T t, Weekday weekday) {
            if (weekday == null) {
                return false;
            }
            try {
                withValue(t, weekday, false);
                return true;
            } catch (ArithmeticException | IllegalArgumentException unused) {
                return false;
            }
        }

        public T withValue(T t, Weekday weekday, boolean z) {
            long longValue = ((Long) t.get(EpochDays.UTC)).longValue();
            Weekday access$400 = CommonElements.getDayOfWeek(longValue);
            if (weekday == access$400) {
                return t;
            }
            int value = access$400.getValue(this.element.model);
            return t.with((ChronoElement<Long>) EpochDays.UTC, (longValue + ((long) weekday.getValue(this.element.model))) - ((long) value));
        }
    }

    private static class DayOperator<T extends ChronoEntity<T>> implements ChronoOperator<T> {
        private final int amount;

        DayOperator(int i) {
            this.amount = i;
        }

        public T apply(T t) {
            return t.with((ChronoElement<Long>) EpochDays.UTC, MathUtils.safeAdd(((Long) t.get(EpochDays.UTC)).longValue(), (long) this.amount));
        }
    }
}
