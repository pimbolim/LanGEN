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
import net.time4j.base.MathUtils;
import net.time4j.calendar.CommonElements;
import net.time4j.calendar.service.GenericDatePatterns;
import net.time4j.calendar.service.StdEnumDateElement;
import net.time4j.calendar.service.StdIntegerDateElement;
import net.time4j.calendar.service.StdWeekdayElement;
import net.time4j.engine.AttributeQuery;
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

@CalendarType("juche")
public final class JucheCalendar extends Calendrical<CalendarUnit, JucheCalendar> implements LocalizedPatternSupport {
    /* access modifiers changed from: private */
    public static final EraYearMonthDaySystem<JucheCalendar> CALSYS;
    /* access modifiers changed from: private */
    public static final Map<Object, ChronoElement<?>> CHILDREN;
    @FormattableElement(format = "d")
    public static final StdCalendarElement<Integer, JucheCalendar> DAY_OF_MONTH;
    @FormattableElement(format = "E")
    public static final StdCalendarElement<Weekday, JucheCalendar> DAY_OF_WEEK;
    @FormattableElement(format = "D")
    public static final StdCalendarElement<Integer, JucheCalendar> DAY_OF_YEAR;
    /* access modifiers changed from: private */
    public static final TimeAxis<CalendarUnit, JucheCalendar> ENGINE;
    @FormattableElement(format = "G")
    public static final ChronoElement<JucheEra> ERA;
    @FormattableElement(alt = "L", format = "M")
    public static final StdCalendarElement<Month, JucheCalendar> MONTH_OF_YEAR;
    @FormattableElement(format = "F")
    public static final OrdinalWeekdayElement<JucheCalendar> WEEKDAY_IN_MONTH;
    private static final WeekdayInMonthElement<JucheCalendar> WIM_ELEMENT;
    @FormattableElement(format = "y")
    public static final StdCalendarElement<Integer, JucheCalendar> YEAR_OF_ERA;
    private static final long serialVersionUID = 757676060690932159L;
    /* access modifiers changed from: private */
    public final PlainDate iso;

    /* access modifiers changed from: protected */
    public JucheCalendar getContext() {
        return this;
    }

    static {
        Class<JucheCalendar> cls = JucheCalendar.class;
        StdEnumDateElement stdEnumDateElement = new StdEnumDateElement("ERA", cls, JucheEra.class, 'G');
        ERA = stdEnumDateElement;
        StdIntegerDateElement stdIntegerDateElement = new StdIntegerDateElement("YEAR_OF_ERA", JucheCalendar.class, 1, 999998088, 'y', (ChronoOperator) null, (ChronoOperator) null);
        YEAR_OF_ERA = stdIntegerDateElement;
        StdEnumDateElement stdEnumDateElement2 = new StdEnumDateElement("MONTH_OF_YEAR", cls, Month.class, 'M');
        MONTH_OF_YEAR = stdEnumDateElement2;
        StdIntegerDateElement stdIntegerDateElement2 = new StdIntegerDateElement("DAY_OF_MONTH", JucheCalendar.class, 1, 31, 'd');
        DAY_OF_MONTH = stdIntegerDateElement2;
        StdIntegerDateElement stdIntegerDateElement3 = new StdIntegerDateElement("DAY_OF_YEAR", JucheCalendar.class, 1, 365, 'D');
        DAY_OF_YEAR = stdIntegerDateElement3;
        StdWeekdayElement stdWeekdayElement = new StdWeekdayElement(cls, getDefaultWeekmodel());
        DAY_OF_WEEK = stdWeekdayElement;
        WeekdayInMonthElement<JucheCalendar> weekdayInMonthElement = new WeekdayInMonthElement<>(cls, stdIntegerDateElement2, stdWeekdayElement);
        WIM_ELEMENT = weekdayInMonthElement;
        WEEKDAY_IN_MONTH = weekdayInMonthElement;
        HashMap hashMap = new HashMap();
        hashMap.put(stdEnumDateElement, stdIntegerDateElement);
        hashMap.put(stdIntegerDateElement, stdEnumDateElement2);
        hashMap.put(stdEnumDateElement2, stdIntegerDateElement2);
        CHILDREN = Collections.unmodifiableMap(hashMap);
        Transformer transformer = new Transformer();
        CALSYS = transformer;
        TimeAxis.Builder appendExtension = TimeAxis.Builder.setUp(CalendarUnit.class, cls, new Merger(), transformer).appendElement((ChronoElement) stdEnumDateElement, (ElementRule) FieldRule.of(stdEnumDateElement)).appendElement(stdIntegerDateElement, FieldRule.of(stdIntegerDateElement), CalendarUnit.YEARS).appendElement(stdEnumDateElement2, FieldRule.of(stdEnumDateElement2), CalendarUnit.MONTHS).appendElement((ChronoElement) CommonElements.RELATED_GREGORIAN_YEAR, (ElementRule) new RelatedGregorianYearRule(transformer, (ChronoElement<Integer>) stdIntegerDateElement3)).appendElement(stdIntegerDateElement2, FieldRule.of(stdIntegerDateElement2), CalendarUnit.DAYS).appendElement(stdIntegerDateElement3, FieldRule.of(stdIntegerDateElement3), CalendarUnit.DAYS).appendElement(stdWeekdayElement, new WeekdayRule(getDefaultWeekmodel(), new ChronoFunction<JucheCalendar, CalendarSystem<JucheCalendar>>() {
            public CalendarSystem<JucheCalendar> apply(JucheCalendar jucheCalendar) {
                return JucheCalendar.CALSYS;
            }
        }), CalendarUnit.DAYS).appendElement((ChronoElement) weekdayInMonthElement, (ElementRule) WeekdayInMonthElement.getRule(weekdayInMonthElement)).appendExtension((ChronoExtension) new CommonElements.Weekengine(cls, stdIntegerDateElement2, stdIntegerDateElement3, getDefaultWeekmodel()));
        registerUnits(appendExtension);
        ENGINE = appendExtension.build();
    }

    JucheCalendar(PlainDate plainDate) {
        if (plainDate.getYear() >= 1912) {
            this.iso = plainDate;
            return;
        }
        throw new IllegalArgumentException("Juche calendar not valid before gregorian year 1912.");
    }

    public static JucheCalendar of(int i, Month month, int i2) {
        return of(i, month.getValue(), i2);
    }

    public static JucheCalendar of(int i, int i2, int i3) {
        return new JucheCalendar(PlainDate.of(toProlepticYear(i), i2, i3));
    }

    public static JucheCalendar nowInSystemTime() {
        return (JucheCalendar) SystemClock.inLocalView().now(axis());
    }

    public JucheEra getEra() {
        return JucheEra.JUCHE;
    }

    public int getYear() {
        return this.iso.getYear() - 1911;
    }

    public Month getMonth() {
        return Month.valueOf(this.iso.getMonth());
    }

    public int getDayOfMonth() {
        return this.iso.getDayOfMonth();
    }

    public Weekday getDayOfWeek() {
        return (Weekday) this.iso.get(PlainDate.DAY_OF_WEEK);
    }

    public int getDayOfYear() {
        return this.iso.getInt(PlainDate.DAY_OF_YEAR);
    }

    public int lengthOfMonth() {
        return this.iso.lengthOfMonth();
    }

    public int lengthOfYear() {
        return this.iso.lengthOfYear();
    }

    public boolean isLeapYear() {
        return this.iso.isLeapYear();
    }

    public static boolean isValid(int i, int i2, int i3) {
        return CALSYS.isValid(JucheEra.JUCHE, i, i2, i3);
    }

    public GeneralTimestamp<JucheCalendar> at(PlainTime plainTime) {
        return GeneralTimestamp.of(this, plainTime);
    }

    public GeneralTimestamp<JucheCalendar> atTime(int i, int i2) {
        return at(PlainTime.of(i, i2));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JucheCalendar) {
            return this.iso.equals(((JucheCalendar) obj).iso);
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
        return Weekmodel.of(new Locale("ko", "KP"));
    }

    public static TimeAxis<CalendarUnit, JucheCalendar> axis() {
        return ENGINE;
    }

    /* access modifiers changed from: protected */
    public TimeAxis<CalendarUnit, JucheCalendar> getChronology() {
        return ENGINE;
    }

    /* access modifiers changed from: package-private */
    public PlainDate toISO() {
        return this.iso;
    }

    /* access modifiers changed from: private */
    public static int toProlepticYear(int i) {
        return MathUtils.safeAdd(i, 1911);
    }

    private static void registerUnits(TimeAxis.Builder<CalendarUnit, JucheCalendar> builder) {
        EnumSet range = EnumSet.range(CalendarUnit.MILLENNIA, CalendarUnit.MONTHS);
        EnumSet range2 = EnumSet.range(CalendarUnit.WEEKS, CalendarUnit.DAYS);
        for (CalendarUnit calendarUnit : CalendarUnit.values()) {
            builder.appendUnit(calendarUnit, new JucheUnitRule(calendarUnit), calendarUnit.getLength(), calendarUnit.compareTo(CalendarUnit.WEEKS) < 0 ? range : range2);
        }
    }

    private Object writeReplace() {
        return new SPX(this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private static class Transformer implements EraYearMonthDaySystem<JucheCalendar> {
        public long getMinimumSinceUTC() {
            return -21915;
        }

        private Transformer() {
        }

        public boolean isValid(CalendarEra calendarEra, int i, int i2, int i3) {
            try {
                if (!(calendarEra instanceof JucheEra)) {
                    return false;
                }
                int access$300 = JucheCalendar.toProlepticYear(i);
                if (i < 1 || access$300 > 999999999 || i2 < 1 || i2 > 12 || i3 < 1 || i3 > GregorianMath.getLengthOfMonth(access$300, i2)) {
                    return false;
                }
                return true;
            } catch (ArithmeticException unused) {
                return false;
            }
        }

        public int getLengthOfMonth(CalendarEra calendarEra, int i, int i2) {
            try {
                return PlainDate.of(JucheCalendar.toProlepticYear(i), i2, 1).lengthOfMonth();
            } catch (RuntimeException e) {
                throw new IllegalArgumentException(e.getMessage(), e);
            }
        }

        public int getLengthOfYear(CalendarEra calendarEra, int i) {
            try {
                return PlainDate.of(JucheCalendar.toProlepticYear(i), Month.JANUARY, 1).lengthOfYear();
            } catch (RuntimeException e) {
                throw new IllegalArgumentException(e.getMessage(), e);
            }
        }

        public JucheCalendar transform(long j) {
            return new JucheCalendar(PlainDate.of(j, EpochDays.UTC));
        }

        public long transform(JucheCalendar jucheCalendar) {
            return ((Long) jucheCalendar.iso.get(EpochDays.UTC)).longValue();
        }

        public long getMaximumSinceUTC() {
            return PlainDate.axis().getCalendarSystem().getMaximumSinceUTC();
        }

        public List<CalendarEra> getEras() {
            return Collections.singletonList(JucheEra.JUCHE);
        }
    }

    private static class FieldRule<V extends Comparable<V>> implements ElementRule<JucheCalendar, V> {
        private final ChronoElement<V> element;

        private FieldRule(ChronoElement<V> chronoElement) {
            this.element = chronoElement;
        }

        static <V extends Comparable<V>> FieldRule<V> of(ChronoElement<V> chronoElement) {
            return new FieldRule<>(chronoElement);
        }

        public V getValue(JucheCalendar jucheCalendar) {
            Object obj;
            if (this.element == JucheCalendar.ERA) {
                obj = JucheEra.JUCHE;
            } else if (this.element.equals(JucheCalendar.YEAR_OF_ERA)) {
                obj = Integer.valueOf(jucheCalendar.getYear());
            } else if (this.element.equals(JucheCalendar.MONTH_OF_YEAR)) {
                obj = jucheCalendar.getMonth();
            } else if (this.element.equals(JucheCalendar.DAY_OF_MONTH)) {
                obj = Integer.valueOf(jucheCalendar.getDayOfMonth());
            } else if (this.element.equals(JucheCalendar.DAY_OF_YEAR)) {
                obj = Integer.valueOf(jucheCalendar.getDayOfYear());
            } else {
                throw new ChronoException("Missing rule for: " + this.element.name());
            }
            return (Comparable) this.element.getType().cast(obj);
        }

        public V getMinimum(JucheCalendar jucheCalendar) {
            int i;
            if (this.element == JucheCalendar.ERA) {
                i = JucheEra.JUCHE;
            } else if (Integer.class.isAssignableFrom(this.element.getType())) {
                i = 1;
            } else if (this.element.equals(JucheCalendar.MONTH_OF_YEAR)) {
                i = Month.JANUARY;
            } else {
                throw new ChronoException("Missing rule for: " + this.element.name());
            }
            return (Comparable) this.element.getType().cast(i);
        }

        public V getMaximum(JucheCalendar jucheCalendar) {
            int i;
            if (this.element == JucheCalendar.ERA) {
                i = JucheEra.JUCHE;
            } else if (this.element.equals(JucheCalendar.YEAR_OF_ERA)) {
                i = 999998088;
            } else if (this.element.equals(JucheCalendar.MONTH_OF_YEAR)) {
                i = Month.DECEMBER;
            } else if (this.element.equals(JucheCalendar.DAY_OF_MONTH)) {
                i = jucheCalendar.iso.getMaximum(PlainDate.DAY_OF_MONTH);
            } else if (this.element.equals(JucheCalendar.DAY_OF_YEAR)) {
                i = jucheCalendar.iso.getMaximum(PlainDate.DAY_OF_YEAR);
            } else {
                throw new ChronoException("Missing rule for: " + this.element.name());
            }
            return (Comparable) this.element.getType().cast(i);
        }

        public boolean isValid(JucheCalendar jucheCalendar, V v) {
            if (v == null) {
                return false;
            }
            if (this.element == JucheCalendar.ERA) {
                return true;
            }
            Comparable minimum = getMinimum(jucheCalendar);
            Comparable maximum = getMaximum(jucheCalendar);
            if (minimum.compareTo(v) > 0 || v.compareTo(maximum) > 0) {
                return false;
            }
            return true;
        }

        public JucheCalendar withValue(JucheCalendar jucheCalendar, V v, boolean z) {
            if (!isValid(jucheCalendar, v)) {
                throw new IllegalArgumentException("Out of range: " + v);
            } else if (this.element == JucheCalendar.ERA) {
                return jucheCalendar;
            } else {
                if (this.element.equals(JucheCalendar.YEAR_OF_ERA)) {
                    JucheCalendar of = JucheCalendar.of(toNumber(v), jucheCalendar.getMonth(), 1);
                    return (JucheCalendar) of.with((ChronoElement<Integer>) JucheCalendar.DAY_OF_MONTH, Math.min(jucheCalendar.getDayOfMonth(), of.lengthOfMonth()));
                } else if (this.element.equals(JucheCalendar.MONTH_OF_YEAR)) {
                    return new JucheCalendar((PlainDate) jucheCalendar.iso.with(PlainDate.MONTH_OF_YEAR, Month.class.cast(v)));
                } else {
                    if (this.element.equals(JucheCalendar.DAY_OF_MONTH)) {
                        return new JucheCalendar((PlainDate) jucheCalendar.iso.with((ChronoElement<Integer>) PlainDate.DAY_OF_MONTH, toNumber(v)));
                    }
                    if (this.element.equals(JucheCalendar.DAY_OF_YEAR)) {
                        return new JucheCalendar((PlainDate) jucheCalendar.iso.with((ChronoElement<Integer>) PlainDate.DAY_OF_YEAR, toNumber(v)));
                    }
                    throw new ChronoException("Missing rule for: " + this.element.name());
                }
            }
        }

        public ChronoElement<?> getChildAtFloor(JucheCalendar jucheCalendar) {
            return (ChronoElement) JucheCalendar.CHILDREN.get(this.element);
        }

        public ChronoElement<?> getChildAtCeiling(JucheCalendar jucheCalendar) {
            return (ChronoElement) JucheCalendar.CHILDREN.get(this.element);
        }

        private static int toNumber(Object obj) {
            return Integer.class.cast(obj).intValue();
        }
    }

    private static class JucheUnitRule implements UnitRule<JucheCalendar> {
        private final CalendarUnit unit;

        JucheUnitRule(CalendarUnit calendarUnit) {
            this.unit = calendarUnit;
        }

        public JucheCalendar addTo(JucheCalendar jucheCalendar, long j) {
            return new JucheCalendar((PlainDate) jucheCalendar.iso.plus(j, this.unit));
        }

        public long between(JucheCalendar jucheCalendar, JucheCalendar jucheCalendar2) {
            return this.unit.between(jucheCalendar.iso, jucheCalendar2.iso);
        }
    }

    private static class Merger implements ChronoMerger<JucheCalendar> {
        public ChronoDisplay preformat(JucheCalendar jucheCalendar, AttributeQuery attributeQuery) {
            return jucheCalendar;
        }

        public Chronology<?> preparser() {
            return null;
        }

        private Merger() {
        }

        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            return GenericDatePatterns.get("roc", displayStyle, locale);
        }

        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.MIDNIGHT;
        }

        /* JADX WARNING: type inference failed for: r4v0, types: [net.time4j.base.TimeSource, net.time4j.base.TimeSource<?>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.calendar.JucheCalendar createFrom(net.time4j.base.TimeSource<?> r4, net.time4j.engine.AttributeQuery r5) {
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
                net.time4j.engine.TimeAxis r1 = net.time4j.calendar.JucheCalendar.ENGINE
                net.time4j.GeneralTimestamp r4 = r4.toGeneralTimestamp(r1, r0, r5)
                java.lang.Object r4 = r4.toDate()
                net.time4j.calendar.JucheCalendar r4 = (net.time4j.calendar.JucheCalendar) r4
                return r4
            L_0x004c:
                r4 = 0
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.JucheCalendar.Merger.createFrom(net.time4j.base.TimeSource, net.time4j.engine.AttributeQuery):net.time4j.calendar.JucheCalendar");
        }

        public JucheCalendar createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            if (chronoEntity.contains(PlainDate.COMPONENT)) {
                return new JucheCalendar((PlainDate) chronoEntity.get((ChronoElement<V>) PlainDate.COMPONENT));
            }
            int i = chronoEntity.getInt(JucheCalendar.YEAR_OF_ERA);
            if (i == Integer.MIN_VALUE) {
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Missing Juche year.");
                return null;
            }
            int access$300 = JucheCalendar.toProlepticYear(i);
            if (chronoEntity.contains(JucheCalendar.MONTH_OF_YEAR)) {
                int value = ((Month) chronoEntity.get((ChronoElement<V>) JucheCalendar.MONTH_OF_YEAR)).getValue();
                int i2 = chronoEntity.getInt(JucheCalendar.DAY_OF_MONTH);
                if (i2 != Integer.MIN_VALUE) {
                    if (JucheCalendar.CALSYS.isValid(JucheEra.JUCHE, i, value, i2)) {
                        return JucheCalendar.of(i, value, i2);
                    }
                    chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Invalid Juche date.");
                }
            } else {
                int i3 = chronoEntity.getInt(JucheCalendar.DAY_OF_YEAR);
                if (i3 != Integer.MIN_VALUE) {
                    if (i3 > 0) {
                        int i4 = 0;
                        int i5 = 1;
                        while (i5 <= 12) {
                            int lengthOfMonth = GregorianMath.getLengthOfMonth(access$300, i5) + i4;
                            if (i3 <= lengthOfMonth) {
                                return JucheCalendar.of(i, i5, i3 - i4);
                            }
                            i5++;
                            i4 = lengthOfMonth;
                        }
                    }
                    chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Invalid Juche date.");
                }
            }
            return null;
        }

        public int getDefaultPivotYear() {
            return PlainDate.axis().getDefaultPivotYear() - 1911;
        }
    }

    private static class SPX implements Externalizable {
        private static final int JUCHE = 17;
        private static final long serialVersionUID = 1;
        private transient Object obj;

        public SPX() {
        }

        SPX(Object obj2) {
            this.obj = obj2;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeByte(17);
            writeJuche(objectOutput);
        }

        public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
            if (objectInput.readByte() == 17) {
                this.obj = readJuche(objectInput);
                return;
            }
            throw new InvalidObjectException("Unknown calendar type.");
        }

        private Object readResolve() throws ObjectStreamException {
            return this.obj;
        }

        private void writeJuche(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeObject(((JucheCalendar) this.obj).toISO());
        }

        private JucheCalendar readJuche(ObjectInput objectInput) throws IOException, ClassNotFoundException {
            return new JucheCalendar(PlainDate.class.cast(objectInput.readObject()));
        }
    }
}
