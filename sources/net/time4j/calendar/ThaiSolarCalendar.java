package net.time4j.calendar;

import com.drew.metadata.exif.makernotes.SanyoMakernoteDirectory;
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
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.time4j.CalendarUnit;
import net.time4j.GeneralTimestamp;
import net.time4j.Month;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.SystemClock;
import net.time4j.Weekday;
import net.time4j.Weekmodel;
import net.time4j.base.GregorianMath;
import net.time4j.calendar.CommonElements;
import net.time4j.calendar.service.GenericDatePatterns;
import net.time4j.calendar.service.StdEnumDateElement;
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
import net.time4j.engine.ChronoExtension;
import net.time4j.engine.ChronoFunction;
import net.time4j.engine.ChronoMerger;
import net.time4j.engine.ChronoOperator;
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

@CalendarType("buddhist")
public final class ThaiSolarCalendar extends Calendrical<CalendarUnit, ThaiSolarCalendar> implements LocalizedPatternSupport {
    /* access modifiers changed from: private */
    public static final EraYearMonthDaySystem<ThaiSolarCalendar> CALSYS;
    /* access modifiers changed from: private */
    public static final Map<Object, ChronoElement<?>> CHILDREN;
    @FormattableElement(format = "d")
    public static final StdCalendarElement<Integer, ThaiSolarCalendar> DAY_OF_MONTH;
    @FormattableElement(format = "E")
    public static final StdCalendarElement<Weekday, ThaiSolarCalendar> DAY_OF_WEEK;
    @FormattableElement(format = "D")
    public static final StdCalendarElement<Integer, ThaiSolarCalendar> DAY_OF_YEAR;
    /* access modifiers changed from: private */
    public static final TimeAxis<CalendarUnit, ThaiSolarCalendar> ENGINE;
    @FormattableElement(format = "G")
    public static final ChronoElement<ThaiSolarEra> ERA;
    /* access modifiers changed from: private */
    public static final PlainDate MIN_ISO = PlainDate.of(-542, 4, 1);
    @FormattableElement(alt = "L", format = "M")
    public static final StdCalendarElement<Month, ThaiSolarCalendar> MONTH_OF_YEAR;
    @FormattableElement(format = "F")
    public static final OrdinalWeekdayElement<ThaiSolarCalendar> WEEKDAY_IN_MONTH;
    private static final WeekdayInMonthElement<ThaiSolarCalendar> WIM_ELEMENT;
    @FormattableElement(format = "y")
    public static final StdCalendarElement<Integer, ThaiSolarCalendar> YEAR_OF_ERA;
    private static final long serialVersionUID = -6628190121085147706L;
    /* access modifiers changed from: private */
    public final PlainDate iso;

    /* access modifiers changed from: protected */
    public ThaiSolarCalendar getContext() {
        return this;
    }

    static {
        Class<ThaiSolarCalendar> cls = ThaiSolarCalendar.class;
        StdEnumDateElement stdEnumDateElement = new StdEnumDateElement("ERA", cls, ThaiSolarEra.class, 'G');
        ERA = stdEnumDateElement;
        StdIntegerDateElement stdIntegerDateElement = new StdIntegerDateElement("YEAR_OF_ERA", ThaiSolarCalendar.class, 1, 1000000542, 'y', (ChronoOperator) null, (ChronoOperator) null);
        YEAR_OF_ERA = stdIntegerDateElement;
        StdEnumDateElement stdEnumDateElement2 = new StdEnumDateElement("MONTH_OF_YEAR", cls, Month.class, 'M');
        MONTH_OF_YEAR = stdEnumDateElement2;
        StdIntegerDateElement stdIntegerDateElement2 = new StdIntegerDateElement("DAY_OF_MONTH", ThaiSolarCalendar.class, 1, 31, 'd');
        DAY_OF_MONTH = stdIntegerDateElement2;
        StdIntegerDateElement stdIntegerDateElement3 = new StdIntegerDateElement("DAY_OF_YEAR", ThaiSolarCalendar.class, 1, 365, 'D');
        DAY_OF_YEAR = stdIntegerDateElement3;
        StdWeekdayElement stdWeekdayElement = new StdWeekdayElement(cls, getDefaultWeekmodel());
        DAY_OF_WEEK = stdWeekdayElement;
        WeekdayInMonthElement<ThaiSolarCalendar> weekdayInMonthElement = new WeekdayInMonthElement<>(cls, stdIntegerDateElement2, stdWeekdayElement);
        WIM_ELEMENT = weekdayInMonthElement;
        WEEKDAY_IN_MONTH = weekdayInMonthElement;
        HashMap hashMap = new HashMap();
        hashMap.put(stdEnumDateElement, stdIntegerDateElement);
        hashMap.put(stdIntegerDateElement, stdEnumDateElement2);
        hashMap.put(stdEnumDateElement2, stdIntegerDateElement2);
        CHILDREN = Collections.unmodifiableMap(hashMap);
        Transformer transformer = new Transformer();
        CALSYS = transformer;
        TimeAxis.Builder appendExtension = TimeAxis.Builder.setUp(CalendarUnit.class, cls, new Merger(), transformer).appendElement((ChronoElement) stdEnumDateElement, (ElementRule) FieldRule.of(stdEnumDateElement)).appendElement(stdIntegerDateElement, FieldRule.of(stdIntegerDateElement), CalendarUnit.YEARS).appendElement(stdEnumDateElement2, FieldRule.of(stdEnumDateElement2), CalendarUnit.MONTHS).appendElement((ChronoElement) CommonElements.RELATED_GREGORIAN_YEAR, (ElementRule) new RelatedGregorianYearRule(transformer, (ChronoElement<Integer>) stdIntegerDateElement3)).appendElement(stdIntegerDateElement2, FieldRule.of(stdIntegerDateElement2), CalendarUnit.DAYS).appendElement(stdIntegerDateElement3, FieldRule.of(stdIntegerDateElement3), CalendarUnit.DAYS).appendElement(stdWeekdayElement, new WeekdayRule(getDefaultWeekmodel(), new ChronoFunction<ThaiSolarCalendar, CalendarSystem<ThaiSolarCalendar>>() {
            public CalendarSystem<ThaiSolarCalendar> apply(ThaiSolarCalendar thaiSolarCalendar) {
                return ThaiSolarCalendar.CALSYS;
            }
        }), CalendarUnit.DAYS).appendElement((ChronoElement) weekdayInMonthElement, (ElementRule) WeekdayInMonthElement.getRule(weekdayInMonthElement)).appendExtension((ChronoExtension) new CommonElements.Weekengine(cls, stdIntegerDateElement2, stdIntegerDateElement3, getDefaultWeekmodel()));
        registerUnits(appendExtension);
        ENGINE = appendExtension.build();
    }

    private ThaiSolarCalendar(PlainDate plainDate) {
        if (!plainDate.isBefore((CalendarDate) MIN_ISO)) {
            this.iso = plainDate;
            return;
        }
        throw new IllegalArgumentException("Before buddhist era: " + plainDate);
    }

    public static ThaiSolarCalendar ofBuddhist(int i, Month month, int i2) {
        return of(ThaiSolarEra.BUDDHIST, i, month.getValue(), i2);
    }

    public static ThaiSolarCalendar ofBuddhist(int i, int i2, int i3) {
        return of(ThaiSolarEra.BUDDHIST, i, i2, i3);
    }

    public static ThaiSolarCalendar of(ThaiSolarEra thaiSolarEra, int i, int i2, int i3) {
        return new ThaiSolarCalendar(PlainDate.of(thaiSolarEra.toIsoYear(i, i2), i2, i3));
    }

    public static ThaiSolarCalendar nowInSystemTime() {
        return (ThaiSolarCalendar) SystemClock.inLocalView().now(axis());
    }

    public ThaiSolarEra getEra() {
        return ThaiSolarEra.BUDDHIST;
    }

    public int getYear() {
        int year = this.iso.getYear();
        return (year >= 1941 || this.iso.getMonth() >= 4) ? year + SanyoMakernoteDirectory.TAG_SCENE_SELECT : year + 542;
    }

    public Month getMonth() {
        return Month.valueOf(this.iso.getMonth());
    }

    public int getDayOfMonth() {
        return this.iso.getDayOfMonth();
    }

    public Weekday getDayOfWeek() {
        return this.iso.getDayOfWeek();
    }

    public int getDayOfYear() {
        int intValue = ((Integer) this.iso.get(PlainDate.DAY_OF_YEAR)).intValue();
        if (this.iso.getYear() >= 1941) {
            return intValue;
        }
        if (this.iso.getMonth() < 4) {
            return intValue + 275;
        }
        return intValue - (this.iso.isLeapYear() ? 91 : 90);
    }

    public int lengthOfMonth() {
        return this.iso.lengthOfMonth();
    }

    public int lengthOfYear() {
        int year = this.iso.getYear();
        if (year >= 1941) {
            return this.iso.lengthOfYear();
        }
        if (this.iso.getMonth() >= 4) {
            if (year == 1940) {
                return 275;
            }
            if (GregorianMath.isLeapYear(year + 1)) {
                return 366;
            }
            return 365;
        } else if (this.iso.isLeapYear()) {
            return 366;
        } else {
            return 365;
        }
    }

    public boolean isLeapYear() {
        return lengthOfYear() == 366;
    }

    public static boolean isValid(ThaiSolarEra thaiSolarEra, int i, int i2, int i3) {
        return CALSYS.isValid(thaiSolarEra, i, i2, i3);
    }

    public GeneralTimestamp<ThaiSolarCalendar> at(PlainTime plainTime) {
        return GeneralTimestamp.of(this, plainTime);
    }

    public GeneralTimestamp<ThaiSolarCalendar> atTime(int i, int i2) {
        return at(PlainTime.of(i, i2));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ThaiSolarCalendar) {
            return this.iso.equals(((ThaiSolarCalendar) obj).iso);
        }
        return false;
    }

    public int hashCode() {
        return this.iso.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(getEra());
        sb.append(SignatureVisitor.SUPER);
        sb.append(getYear());
        sb.append(SignatureVisitor.SUPER);
        int value = getMonth().getValue();
        if (value < 10) {
            sb.append('0');
        }
        sb.append(value);
        sb.append(SignatureVisitor.SUPER);
        int dayOfMonth = getDayOfMonth();
        if (dayOfMonth < 10) {
            sb.append('0');
        }
        sb.append(dayOfMonth);
        return sb.toString();
    }

    public static Weekmodel getDefaultWeekmodel() {
        return Weekmodel.of(Weekday.SUNDAY, 1);
    }

    public static TimeAxis<CalendarUnit, ThaiSolarCalendar> axis() {
        return ENGINE;
    }

    /* access modifiers changed from: protected */
    public TimeAxis<CalendarUnit, ThaiSolarCalendar> getChronology() {
        return ENGINE;
    }

    /* access modifiers changed from: package-private */
    public PlainDate toISO() {
        return this.iso;
    }

    private static void registerUnits(TimeAxis.Builder<CalendarUnit, ThaiSolarCalendar> builder) {
        EnumSet range = EnumSet.range(CalendarUnit.MILLENNIA, CalendarUnit.MONTHS);
        EnumSet range2 = EnumSet.range(CalendarUnit.WEEKS, CalendarUnit.DAYS);
        for (CalendarUnit calendarUnit : CalendarUnit.values()) {
            builder.appendUnit(calendarUnit, new ThaiUnitRule(calendarUnit), calendarUnit.getLength(), calendarUnit.compareTo(CalendarUnit.WEEKS) < 0 ? range : range2);
        }
    }

    private Object writeReplace() {
        return new SPX(this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private static class Transformer implements EraYearMonthDaySystem<ThaiSolarCalendar> {
        private Transformer() {
        }

        public boolean isValid(CalendarEra calendarEra, int i, int i2, int i3) {
            int isoYear;
            try {
                if (!(calendarEra instanceof ThaiSolarEra) || i < 1 || (isoYear = ThaiSolarEra.class.cast(calendarEra).toIsoYear(i, i2)) > 999999999 || i2 < 1 || i2 > 12 || i3 < 1 || i3 > GregorianMath.getLengthOfMonth(isoYear, i2)) {
                    return false;
                }
                return true;
            } catch (RuntimeException unused) {
                return false;
            }
        }

        public int getLengthOfMonth(CalendarEra calendarEra, int i, int i2) {
            try {
                return GregorianMath.getLengthOfMonth(ThaiSolarEra.class.cast(calendarEra).toIsoYear(i, i2), i2);
            } catch (RuntimeException e) {
                throw new IllegalArgumentException(e.getMessage(), e);
            }
        }

        public int getLengthOfYear(CalendarEra calendarEra, int i) {
            if (i < 1) {
                throw new IllegalArgumentException("Out of bounds: " + i);
            } else if (calendarEra.equals(ThaiSolarEra.BUDDHIST)) {
                int i2 = i - 543;
                if (i2 == 1940) {
                    return 275;
                }
                if (i2 < 1940) {
                    i2++;
                }
                if (GregorianMath.isLeapYear(i2)) {
                    return 366;
                }
                return 365;
            } else if (!calendarEra.equals(ThaiSolarEra.RATTANAKOSIN)) {
                throw new IllegalArgumentException("Invalid calendar era: " + calendarEra);
            } else if (GregorianMath.isLeapYear(i + 1782)) {
                return 366;
            } else {
                return 365;
            }
        }

        public ThaiSolarCalendar transform(long j) {
            return new ThaiSolarCalendar(PlainDate.of(j, EpochDays.UTC));
        }

        public long transform(ThaiSolarCalendar thaiSolarCalendar) {
            return ((Long) thaiSolarCalendar.iso.get(EpochDays.UTC)).longValue();
        }

        public long getMinimumSinceUTC() {
            return ThaiSolarCalendar.MIN_ISO.getDaysSinceEpochUTC();
        }

        public long getMaximumSinceUTC() {
            return PlainDate.axis().getCalendarSystem().getMaximumSinceUTC();
        }

        public List<CalendarEra> getEras() {
            return Arrays.asList(new CalendarEra[]{ThaiSolarEra.RATTANAKOSIN, ThaiSolarEra.BUDDHIST});
        }
    }

    private static class FieldRule<V extends Comparable<V>> implements ElementRule<ThaiSolarCalendar, V> {
        private final ChronoElement<V> element;

        private FieldRule(ChronoElement<V> chronoElement) {
            this.element = chronoElement;
        }

        static <V extends Comparable<V>> FieldRule<V> of(ChronoElement<V> chronoElement) {
            return new FieldRule<>(chronoElement);
        }

        public V getValue(ThaiSolarCalendar thaiSolarCalendar) {
            Object obj;
            if (this.element == ThaiSolarCalendar.ERA) {
                obj = thaiSolarCalendar.getEra();
            } else if (this.element.equals(ThaiSolarCalendar.YEAR_OF_ERA)) {
                obj = Integer.valueOf(thaiSolarCalendar.getYear());
            } else if (this.element.equals(ThaiSolarCalendar.MONTH_OF_YEAR)) {
                obj = thaiSolarCalendar.getMonth();
            } else if (this.element.equals(ThaiSolarCalendar.DAY_OF_MONTH)) {
                obj = Integer.valueOf(thaiSolarCalendar.getDayOfMonth());
            } else if (this.element.equals(ThaiSolarCalendar.DAY_OF_YEAR)) {
                obj = Integer.valueOf(thaiSolarCalendar.getDayOfYear());
            } else {
                throw new ChronoException("Missing rule for: " + this.element.name());
            }
            return (Comparable) this.element.getType().cast(obj);
        }

        public V getMinimum(ThaiSolarCalendar thaiSolarCalendar) {
            int i;
            if (this.element == ThaiSolarCalendar.ERA) {
                i = ThaiSolarEra.BUDDHIST;
            } else if (Integer.class.isAssignableFrom(this.element.getType())) {
                i = 1;
            } else if (this.element.equals(ThaiSolarCalendar.MONTH_OF_YEAR)) {
                i = thaiSolarCalendar.iso.getYear() >= 1941 ? Month.JANUARY : Month.APRIL;
            } else {
                throw new ChronoException("Missing rule for: " + this.element.name());
            }
            return (Comparable) this.element.getType().cast(i);
        }

        public V getMaximum(ThaiSolarCalendar thaiSolarCalendar) {
            int i;
            if (this.element == ThaiSolarCalendar.ERA) {
                i = ThaiSolarEra.BUDDHIST;
            } else if (this.element.equals(ThaiSolarCalendar.YEAR_OF_ERA)) {
                i = 1000000542;
            } else if (this.element.equals(ThaiSolarCalendar.MONTH_OF_YEAR)) {
                i = thaiSolarCalendar.getYear() >= 2483 ? Month.DECEMBER : Month.MARCH;
            } else if (this.element.equals(ThaiSolarCalendar.DAY_OF_MONTH)) {
                i = Integer.valueOf(thaiSolarCalendar.lengthOfMonth());
            } else if (this.element.equals(ThaiSolarCalendar.DAY_OF_YEAR)) {
                i = Integer.valueOf(thaiSolarCalendar.lengthOfYear());
            } else {
                throw new ChronoException("Missing rule for: " + this.element.name());
            }
            return (Comparable) this.element.getType().cast(i);
        }

        public boolean isValid(ThaiSolarCalendar thaiSolarCalendar, V v) {
            if (v == null) {
                return false;
            }
            if (!this.element.getType().isEnum()) {
                Comparable minimum = getMinimum(thaiSolarCalendar);
                Comparable maximum = getMaximum(thaiSolarCalendar);
                if (minimum.compareTo(v) > 0 || v.compareTo(maximum) > 0) {
                    return false;
                }
                return true;
            } else if (!this.element.equals(ThaiSolarCalendar.MONTH_OF_YEAR) || thaiSolarCalendar.getYear() != 2483 || Month.class.cast(v).getValue() >= 4) {
                return true;
            } else {
                return false;
            }
        }

        public ThaiSolarCalendar withValue(ThaiSolarCalendar thaiSolarCalendar, V v, boolean z) {
            if (!isValid(thaiSolarCalendar, v)) {
                throw new IllegalArgumentException("Out of range: " + v);
            } else if (this.element == ThaiSolarCalendar.ERA) {
                return thaiSolarCalendar;
            } else {
                if (this.element.equals(ThaiSolarCalendar.YEAR_OF_ERA)) {
                    ThaiSolarCalendar ofBuddhist = ThaiSolarCalendar.ofBuddhist(toNumber(v), thaiSolarCalendar.getMonth(), 1);
                    return (ThaiSolarCalendar) ofBuddhist.with((ChronoElement<Integer>) ThaiSolarCalendar.DAY_OF_MONTH, Math.min(thaiSolarCalendar.getDayOfMonth(), ofBuddhist.lengthOfMonth()));
                } else if (this.element.equals(ThaiSolarCalendar.MONTH_OF_YEAR)) {
                    ThaiSolarCalendar ofBuddhist2 = ThaiSolarCalendar.ofBuddhist(thaiSolarCalendar.getYear(), Month.class.cast(v), 1);
                    return (ThaiSolarCalendar) ofBuddhist2.with((ChronoElement<Integer>) ThaiSolarCalendar.DAY_OF_MONTH, Math.min(thaiSolarCalendar.getDayOfMonth(), ofBuddhist2.lengthOfMonth()));
                } else if (this.element.equals(ThaiSolarCalendar.DAY_OF_MONTH)) {
                    return new ThaiSolarCalendar((PlainDate) thaiSolarCalendar.iso.with((ChronoElement<Integer>) PlainDate.DAY_OF_MONTH, toNumber(v)));
                } else {
                    if (this.element.equals(ThaiSolarCalendar.DAY_OF_YEAR)) {
                        return new ThaiSolarCalendar((PlainDate) ThaiSolarCalendar.ofBuddhist(thaiSolarCalendar.getYear(), thaiSolarCalendar.iso.getYear() >= 1941 ? 1 : 4, 1).iso.plus((long) (toNumber(v) - 1), CalendarUnit.DAYS));
                    }
                    throw new ChronoException("Missing rule for: " + this.element.name());
                }
            }
        }

        public ChronoElement<?> getChildAtFloor(ThaiSolarCalendar thaiSolarCalendar) {
            return (ChronoElement) ThaiSolarCalendar.CHILDREN.get(this.element);
        }

        public ChronoElement<?> getChildAtCeiling(ThaiSolarCalendar thaiSolarCalendar) {
            return (ChronoElement) ThaiSolarCalendar.CHILDREN.get(this.element);
        }

        private static int toNumber(Object obj) {
            return Integer.class.cast(obj).intValue();
        }
    }

    private static class ThaiUnitRule implements UnitRule<ThaiSolarCalendar> {
        private final CalendarUnit unit;

        ThaiUnitRule(CalendarUnit calendarUnit) {
            this.unit = calendarUnit;
        }

        public ThaiSolarCalendar addTo(ThaiSolarCalendar thaiSolarCalendar, long j) {
            return new ThaiSolarCalendar((PlainDate) thaiSolarCalendar.iso.plus(j, this.unit));
        }

        public long between(ThaiSolarCalendar thaiSolarCalendar, ThaiSolarCalendar thaiSolarCalendar2) {
            return this.unit.between(thaiSolarCalendar.iso, thaiSolarCalendar2.iso);
        }
    }

    private static class Merger implements ChronoMerger<ThaiSolarCalendar> {
        public ChronoDisplay preformat(ThaiSolarCalendar thaiSolarCalendar, AttributeQuery attributeQuery) {
            return thaiSolarCalendar;
        }

        public Chronology<?> preparser() {
            return null;
        }

        private Merger() {
        }

        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            return GenericDatePatterns.get("buddhist", displayStyle, locale);
        }

        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.MIDNIGHT;
        }

        public int getDefaultPivotYear() {
            return PlainDate.axis().getDefaultPivotYear() + SanyoMakernoteDirectory.TAG_SCENE_SELECT;
        }

        /* JADX WARNING: type inference failed for: r4v0, types: [net.time4j.base.TimeSource, net.time4j.base.TimeSource<?>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.calendar.ThaiSolarCalendar createFrom(net.time4j.base.TimeSource<?> r4, net.time4j.engine.AttributeQuery r5) {
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
                net.time4j.engine.TimeAxis r1 = net.time4j.calendar.ThaiSolarCalendar.ENGINE
                net.time4j.GeneralTimestamp r4 = r4.toGeneralTimestamp(r1, r0, r5)
                java.lang.Object r4 = r4.toDate()
                net.time4j.calendar.ThaiSolarCalendar r4 = (net.time4j.calendar.ThaiSolarCalendar) r4
                return r4
            L_0x004c:
                r4 = 0
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.ThaiSolarCalendar.Merger.createFrom(net.time4j.base.TimeSource, net.time4j.engine.AttributeQuery):net.time4j.calendar.ThaiSolarCalendar");
        }

        public ThaiSolarCalendar createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            ThaiSolarEra thaiSolarEra;
            int i;
            int i2;
            if (chronoEntity.contains(PlainDate.COMPONENT)) {
                return new ThaiSolarCalendar((PlainDate) chronoEntity.get((ChronoElement<V>) PlainDate.COMPONENT));
            }
            if (chronoEntity.contains(ThaiSolarCalendar.ERA)) {
                thaiSolarEra = (ThaiSolarEra) chronoEntity.get((ChronoElement<V>) ThaiSolarCalendar.ERA);
            } else if (z) {
                thaiSolarEra = ThaiSolarEra.BUDDHIST;
            } else {
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Missing Thai era.");
                return null;
            }
            int i3 = chronoEntity.getInt(ThaiSolarCalendar.YEAR_OF_ERA);
            if (i3 == Integer.MIN_VALUE) {
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Missing Thai year.");
                return null;
            }
            if (chronoEntity.contains(ThaiSolarCalendar.MONTH_OF_YEAR)) {
                int value = ((Month) chronoEntity.get((ChronoElement<V>) ThaiSolarCalendar.MONTH_OF_YEAR)).getValue();
                int i4 = chronoEntity.getInt(ThaiSolarCalendar.DAY_OF_MONTH);
                if (i4 != Integer.MIN_VALUE) {
                    if (ThaiSolarCalendar.CALSYS.isValid(thaiSolarEra, i3, value, i4)) {
                        return ThaiSolarCalendar.of(thaiSolarEra, i3, value, i4);
                    }
                    chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Invalid Thai calendar date.");
                }
            } else {
                int i5 = chronoEntity.getInt(ThaiSolarCalendar.DAY_OF_YEAR);
                if (i5 != Integer.MIN_VALUE) {
                    if (i5 > 0) {
                        int i6 = 0;
                        int i7 = (thaiSolarEra == ThaiSolarEra.RATTANAKOSIN || i3 < 2484) ? 3 : 0;
                        int isoYear = thaiSolarEra.toIsoYear(i3, 4);
                        int i8 = i7 + 1;
                        while (i8 <= i7 + 12) {
                            if (i8 > 12) {
                                if (thaiSolarEra == ThaiSolarEra.BUDDHIST && isoYear == 1940) {
                                    break;
                                }
                                i2 = isoYear + 1;
                                i = i8 - 12;
                            } else {
                                i2 = isoYear;
                                i = i8;
                            }
                            int lengthOfMonth = GregorianMath.getLengthOfMonth(i2, i) + i6;
                            if (i5 <= lengthOfMonth) {
                                return ThaiSolarCalendar.of(thaiSolarEra, i3, i, i5 - i6);
                            }
                            i8++;
                            i6 = lengthOfMonth;
                        }
                    }
                    chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Invalid Thai calendar date.");
                }
            }
            return null;
        }
    }

    private static class SPX implements Externalizable {
        private static final int THAI_SOLAR = 8;
        private static final long serialVersionUID = 1;
        private transient Object obj;

        public SPX() {
        }

        SPX(Object obj2) {
            this.obj = obj2;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeByte(8);
            writeThaiSolar(objectOutput);
        }

        public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
            if (objectInput.readByte() == 8) {
                this.obj = readThaiSolar(objectInput);
                return;
            }
            throw new InvalidObjectException("Unknown calendar type.");
        }

        private Object readResolve() throws ObjectStreamException {
            return this.obj;
        }

        private void writeThaiSolar(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeObject(((ThaiSolarCalendar) this.obj).toISO());
        }

        private ThaiSolarCalendar readThaiSolar(ObjectInput objectInput) throws IOException, ClassNotFoundException {
            return (ThaiSolarCalendar) PlainDate.class.cast(objectInput.readObject()).transform(ThaiSolarCalendar.class);
        }
    }
}
