package net.time4j.calendar;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
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
import net.time4j.calendar.service.StdEnumDateElement;
import net.time4j.calendar.service.StdIntegerDateElement;
import net.time4j.calendar.service.StdWeekdayElement;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.BasicElement;
import net.time4j.engine.CalendarDays;
import net.time4j.engine.CalendarEra;
import net.time4j.engine.CalendarFamily;
import net.time4j.engine.CalendarSystem;
import net.time4j.engine.CalendarVariant;
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
import net.time4j.engine.IntElementRule;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.ValidationElement;
import net.time4j.engine.VariantSource;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.CalendarType;
import net.time4j.format.DisplayElement;
import net.time4j.format.Leniency;
import net.time4j.format.LocalizedPatternSupport;
import net.time4j.format.NumberSystem;
import net.time4j.format.TextElement;
import net.time4j.format.internal.DualFormatElement;
import net.time4j.history.ChronoHistory;
import net.time4j.history.HistoricDate;
import net.time4j.history.HistoricEra;
import net.time4j.history.YearDefinition;
import net.time4j.history.internal.HistoricAttribute;
import net.time4j.i18n.HistoricExtension;

@CalendarType("historic")
public final class HistoricCalendar extends CalendarVariant<HistoricCalendar> implements LocalizedPatternSupport {
    private static final Map<String, CalendarSystem<HistoricCalendar>> CALSYS;
    private static final int CENTURY_INDEX = 4;
    public static final ChronoElement<Integer> CENTURY_OF_ERA;
    /* access modifiers changed from: private */
    public static final ChronoElement<Integer> CONTINUOUS_DOM;
    private static final int CONTINUOUS_DOM_INDEX = 5;
    @FormattableElement(format = "d")
    public static final StdCalendarElement<Integer, HistoricCalendar> DAY_OF_MONTH;
    private static final int DAY_OF_MONTH_INDEX = 2;
    @FormattableElement(format = "E")
    public static final StdCalendarElement<Weekday, HistoricCalendar> DAY_OF_WEEK;
    @FormattableElement(format = "D")
    public static final StdCalendarElement<Integer, HistoricCalendar> DAY_OF_YEAR;
    private static final int DAY_OF_YEAR_INDEX = 3;
    /* access modifiers changed from: private */
    public static final CalendarFamily<HistoricCalendar> ENGINE;
    @FormattableElement(format = "G")
    public static final ChronoElement<HistoricEra> ERA;
    @FormattableElement(alt = "L", format = "M")
    public static final StdCalendarElement<Month, HistoricCalendar> MONTH_OF_YEAR;
    @FormattableElement(format = "y")
    public static final TextElement<Integer> RELATED_STANDARD_YEAR;
    @FormattableElement(format = "F")
    public static final OrdinalWeekdayElement<HistoricCalendar> WEEKDAY_IN_MONTH;
    private static final WeekdayInMonthElement<HistoricCalendar> WIM_ELEMENT;
    private static final int YEAR_INDEX = 0;
    private static final long serialVersionUID = 7723641381724201009L;
    /* access modifiers changed from: private */
    public final transient HistoricDate date;
    /* access modifiers changed from: private */
    public final PlainDate gregorian;
    /* access modifiers changed from: private */
    public final ChronoHistory history;

    /* access modifiers changed from: protected */
    public HistoricCalendar getContext() {
        return this;
    }

    static {
        Class<HistoricCalendar> cls = HistoricCalendar.class;
        EraElement eraElement = new EraElement();
        ERA = eraElement;
        SimpleElement simpleElement = new SimpleElement("CENTURY_OF_ERA", ChronoHistory.ofFirstGregorianReform().centuryOfEra().getDefaultMinimum().intValue(), ChronoHistory.ofFirstGregorianReform().centuryOfEra().getDefaultMaximum().intValue());
        CENTURY_OF_ERA = simpleElement;
        YearElement yearElement = new YearElement();
        RELATED_STANDARD_YEAR = yearElement;
        AnonymousClass1 r7 = new StdEnumDateElement<Month, HistoricCalendar>("MONTH_OF_YEAR", HistoricCalendar.class, Month.class, 'M', new MonthOperator(true), new MonthOperator(false)) {
            /* access modifiers changed from: protected */
            public String getCalendarType(AttributeQuery attributeQuery) {
                return CalendarText.ISO_CALENDAR_TYPE;
            }
        };
        MONTH_OF_YEAR = r7;
        StdIntegerDateElement stdIntegerDateElement = new StdIntegerDateElement("DAY_OF_MONTH", HistoricCalendar.class, 1, 31, 'd');
        DAY_OF_MONTH = stdIntegerDateElement;
        StdIntegerDateElement stdIntegerDateElement2 = new StdIntegerDateElement("DAY_OF_YEAR", HistoricCalendar.class, 1, 365, 'D');
        DAY_OF_YEAR = stdIntegerDateElement2;
        StdWeekdayElement stdWeekdayElement = new StdWeekdayElement(cls, getDefaultWeekmodel());
        DAY_OF_WEEK = stdWeekdayElement;
        SimpleElement simpleElement2 = new SimpleElement("HC_CONTINUOUS_DOM", 1, 31);
        CONTINUOUS_DOM = simpleElement2;
        WeekdayInMonthElement<HistoricCalendar> weekdayInMonthElement = new WeekdayInMonthElement<>(cls, simpleElement2, stdWeekdayElement);
        WIM_ELEMENT = weekdayInMonthElement;
        WEEKDAY_IN_MONTH = weekdayInMonthElement;
        VariantMap variantMap = new VariantMap();
        ChronoHistory ofFirstGregorianReform = ChronoHistory.ofFirstGregorianReform();
        variantMap.put(ofFirstGregorianReform.getVariant(), new Transformer(ofFirstGregorianReform));
        CALSYS = variantMap;
        ENGINE = CalendarFamily.Builder.setUp(cls, new Merger(), variantMap).appendElement(PlainDate.COMPONENT, new GregorianDateRule()).appendElement(eraElement, new EraRule()).appendElement(simpleElement, new IntegerRule(4)).appendElement(yearElement, new IntegerRule(0)).appendElement(r7, new MonthRule()).appendElement(CommonElements.RELATED_GREGORIAN_YEAR, new RelatedGregorianYearRule(variantMap, (ChronoElement<Integer>) stdIntegerDateElement2)).appendElement(simpleElement2, new IntegerRule(5)).appendElement(stdIntegerDateElement, new IntegerRule(2)).appendElement(stdIntegerDateElement2, new IntegerRule(3)).appendElement(stdWeekdayElement, new WeekdayRule(getDefaultWeekmodel(), new ChronoFunction<HistoricCalendar, CalendarSystem<HistoricCalendar>>() {
            public CalendarSystem<HistoricCalendar> apply(HistoricCalendar historicCalendar) {
                return historicCalendar.getChronology().getCalendarSystem(historicCalendar.getVariant());
            }
        })).appendElement(weekdayInMonthElement, WeekdayInMonthElement.getRule(weekdayInMonthElement)).appendExtension((ChronoExtension) new CommonElements.Weekengine(cls, stdIntegerDateElement, stdIntegerDateElement2, getDefaultWeekmodel())).build();
    }

    private HistoricCalendar(ChronoHistory chronoHistory, HistoricDate historicDate) {
        this.gregorian = chronoHistory.convert(historicDate);
        this.date = historicDate;
        this.history = chronoHistory;
    }

    private HistoricCalendar(ChronoHistory chronoHistory, PlainDate plainDate) {
        this.date = chronoHistory.convert(plainDate);
        this.gregorian = plainDate;
        this.history = chronoHistory;
    }

    public static HistoricCalendar of(ChronoHistory chronoHistory, HistoricEra historicEra, int i, int i2, int i3) {
        return of(chronoHistory, historicEra, i, YearDefinition.DUAL_DATING, i2, i3);
    }

    public static HistoricCalendar of(ChronoHistory chronoHistory, HistoricEra historicEra, int i, YearDefinition yearDefinition, int i2, int i3) {
        return of(chronoHistory, HistoricDate.of(historicEra, i, i2, i3, yearDefinition, chronoHistory.getNewYearStrategy()));
    }

    public static HistoricCalendar nowInSystemTime(ChronoHistory chronoHistory) {
        return (HistoricCalendar) SystemClock.inLocalView().now(family(), (VariantSource) chronoHistory, StartOfDay.MIDNIGHT).toDate();
    }

    public ChronoHistory getHistory() {
        return this.history;
    }

    public HistoricEra getEra() {
        return this.date.getEra();
    }

    public int getCentury() {
        return getInt(this.history.centuryOfEra());
    }

    public int getYear() {
        return this.date.getYearOfEra(this.history.getNewYearStrategy());
    }

    public Month getMonth() {
        return Month.valueOf(this.date.getMonth());
    }

    public int getDayOfMonth() {
        return this.date.getDayOfMonth();
    }

    public Weekday getDayOfWeek() {
        return Weekday.valueOf(MathUtils.floorModulo(this.gregorian.getDaysSinceEpochUTC() + 5, 7) + 1);
    }

    public int getDayOfYear() {
        return ((Integer) get(DAY_OF_YEAR)).intValue();
    }

    public String getVariant() {
        return this.history.getVariant();
    }

    public int lengthOfMonth() {
        try {
            ChronoElement chronoElement = DAY_OF_MONTH;
            return ((int) CalendarDays.between(((HistoricCalendar) with((ChronoElement<Integer>) chronoElement, ((Integer) getMinimum(chronoElement)).intValue())).gregorian, ((HistoricCalendar) with((ChronoElement<Integer>) chronoElement, ((Integer) getMaximum(chronoElement)).intValue())).gregorian).getAmount()) + 1;
        } catch (RuntimeException unused) {
            return -1;
        }
    }

    public int lengthOfYear() {
        return this.history.getLengthOfYear(getEra(), getYear());
    }

    public HistoricCalendar withNewYear() {
        return of(this.history, this.history.getBeginOfYear(getEra(), getYear()));
    }

    public HistoricCalendar nextDay() {
        return (HistoricCalendar) with(DAY_OF_MONTH.incremented());
    }

    public GeneralTimestamp<HistoricCalendar> at(PlainTime plainTime) {
        return GeneralTimestamp.of(this, plainTime);
    }

    public GeneralTimestamp<HistoricCalendar> atTime(int i, int i2) {
        return at(PlainTime.of(i, i2));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HistoricCalendar)) {
            return false;
        }
        HistoricCalendar historicCalendar = (HistoricCalendar) obj;
        if (!this.gregorian.equals(historicCalendar.gregorian) || !this.history.equals(historicCalendar.history) || !this.date.equals(historicCalendar.date)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.gregorian.hashCode() * 17) + (this.history.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.date);
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        sb.append(this.history);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public static Weekmodel getDefaultWeekmodel() {
        return Weekmodel.of(Weekday.SUNDAY, 1);
    }

    public static CalendarFamily<HistoricCalendar> family() {
        return ENGINE;
    }

    /* access modifiers changed from: protected */
    public CalendarFamily<HistoricCalendar> getChronology() {
        return ENGINE;
    }

    private static HistoricCalendar of(ChronoHistory chronoHistory, HistoricDate historicDate) {
        if (chronoHistory.isValid(historicDate)) {
            return new HistoricCalendar(chronoHistory, historicDate);
        }
        throw new IllegalArgumentException("Historic date \"" + historicDate + "\" invalid in history: " + chronoHistory);
    }

    /* access modifiers changed from: private */
    public static ChronoHistory getHistory(AttributeQuery attributeQuery) {
        if (attributeQuery.contains(HistoricAttribute.CALENDAR_HISTORY)) {
            return (ChronoHistory) attributeQuery.get(HistoricAttribute.CALENDAR_HISTORY);
        }
        if (((String) attributeQuery.get(Attributes.CALENDAR_TYPE, CalendarText.ISO_CALENDAR_TYPE)).equals("historic") && attributeQuery.contains(Attributes.CALENDAR_VARIANT)) {
            return ChronoHistory.from((String) attributeQuery.get(Attributes.CALENDAR_VARIANT));
        }
        if (!((Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART)).isStrict()) {
            return ChronoHistory.of((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT));
        }
        return null;
    }

    private Object writeReplace() {
        return new SPX(this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private static class Transformer implements CalendarSystem<HistoricCalendar> {
        private final ChronoHistory history;

        Transformer(ChronoHistory chronoHistory) {
            this.history = chronoHistory;
        }

        public HistoricCalendar transform(long j) {
            return new HistoricCalendar(this.history, PlainDate.of(j, EpochDays.UTC));
        }

        public long transform(HistoricCalendar historicCalendar) {
            return historicCalendar.gregorian.getDaysSinceEpochUTC();
        }

        public long getMinimumSinceUTC() {
            return this.history.convert((HistoricDate) PlainDate.of(2000, 1, 1).getMinimum(this.history.date())).getDaysSinceEpochUTC();
        }

        public long getMaximumSinceUTC() {
            return this.history.convert((HistoricDate) PlainDate.of(2000, 1, 1).getMaximum(this.history.date())).getDaysSinceEpochUTC();
        }

        public List<CalendarEra> getEras() {
            ArrayList arrayList = new ArrayList();
            for (HistoricEra add : HistoricEra.values()) {
                arrayList.add(add);
            }
            return Collections.unmodifiableList(arrayList);
        }
    }

    private static class VariantMap extends ConcurrentHashMap<String, CalendarSystem<HistoricCalendar>> {
        private VariantMap() {
        }

        public CalendarSystem<HistoricCalendar> get(Object obj) {
            CalendarSystem<HistoricCalendar> calendarSystem = (CalendarSystem) super.get(obj);
            if (calendarSystem != null) {
                return calendarSystem;
            }
            String obj2 = obj.toString();
            try {
                Transformer transformer = new Transformer(ChronoHistory.from(obj2));
                CalendarSystem<HistoricCalendar> calendarSystem2 = (CalendarSystem) putIfAbsent(obj2, transformer);
                return calendarSystem2 != null ? calendarSystem2 : transformer;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    private static class IntegerRule implements IntElementRule<HistoricCalendar> {
        private final int index;

        IntegerRule(int i) {
            this.index = i;
        }

        public Integer getValue(HistoricCalendar historicCalendar) {
            return Integer.valueOf(getInt(historicCalendar));
        }

        public Integer getMinimum(HistoricCalendar historicCalendar) {
            if (this.index == 5) {
                int dayOfMonth = historicCalendar.date.getDayOfMonth();
                HistoricEra era = historicCalendar.date.getEra();
                int yearOfEra = historicCalendar.date.getYearOfEra();
                int month = historicCalendar.date.getMonth();
                for (int i = 1; i <= dayOfMonth; i++) {
                    if (historicCalendar.history.isValid(HistoricDate.of(era, yearOfEra, month, i))) {
                        return Integer.valueOf(i);
                    }
                }
            }
            return (Integer) historicCalendar.getMinimum(getElement(historicCalendar));
        }

        public Integer getMaximum(HistoricCalendar historicCalendar) {
            if (this.index != 5) {
                return (Integer) historicCalendar.getMaximum(getElement(historicCalendar));
            }
            int intValue = ((Integer) historicCalendar.getMaximum(historicCalendar.history.dayOfMonth())).intValue();
            HistoricEra era = historicCalendar.date.getEra();
            int yearOfEra = historicCalendar.date.getYearOfEra();
            int month = historicCalendar.date.getMonth();
            int i = 0;
            for (int i2 = 1; i2 <= intValue; i2++) {
                if (!historicCalendar.history.isValid(HistoricDate.of(era, yearOfEra, month, i2))) {
                    i++;
                }
            }
            return Integer.valueOf(intValue - i);
        }

        public boolean isValid(HistoricCalendar historicCalendar, Integer num) {
            if (num == null || this.index == 5) {
                return false;
            }
            return historicCalendar.isValid(getElement(historicCalendar), num);
        }

        public HistoricCalendar withValue(HistoricCalendar historicCalendar, Integer num, boolean z) {
            return (HistoricCalendar) historicCalendar.with(getElement(historicCalendar), num);
        }

        public ChronoElement<?> getChildAtFloor(HistoricCalendar historicCalendar) {
            int i = this.index;
            if (i == 2 || i == 3) {
                return null;
            }
            throw new UnsupportedOperationException("Never called.");
        }

        public ChronoElement<?> getChildAtCeiling(HistoricCalendar historicCalendar) {
            int i = this.index;
            if (i == 2 || i == 3) {
                return null;
            }
            throw new UnsupportedOperationException("Never called.");
        }

        private ChronoElement<Integer> getElement(HistoricCalendar historicCalendar) {
            int i = this.index;
            if (i == 0) {
                return historicCalendar.history.yearOfEra();
            }
            if (i == 2) {
                return historicCalendar.history.dayOfMonth();
            }
            if (i == 3) {
                return historicCalendar.history.dayOfYear();
            }
            if (i == 4) {
                return historicCalendar.history.centuryOfEra();
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public int getInt(HistoricCalendar historicCalendar) {
            int i = this.index;
            if (i == 0) {
                return historicCalendar.date.getYearOfEra();
            }
            if (i == 2) {
                return historicCalendar.date.getDayOfMonth();
            }
            if (i != 5) {
                return historicCalendar.getInt(getElement(historicCalendar));
            }
            int dayOfMonth = historicCalendar.date.getDayOfMonth();
            HistoricEra era = historicCalendar.date.getEra();
            int yearOfEra = historicCalendar.date.getYearOfEra();
            int month = historicCalendar.date.getMonth();
            int i2 = 0;
            for (int i3 = 1; i3 < dayOfMonth; i3++) {
                if (!historicCalendar.history.isValid(HistoricDate.of(era, yearOfEra, month, i3))) {
                    i2++;
                }
            }
            return dayOfMonth - i2;
        }

        public boolean isValid(HistoricCalendar historicCalendar, int i) {
            if (this.index == 5) {
                return false;
            }
            return historicCalendar.isValid(getElement(historicCalendar), i);
        }

        public HistoricCalendar withValue(HistoricCalendar historicCalendar, int i, boolean z) {
            return (HistoricCalendar) historicCalendar.with(getElement(historicCalendar), i);
        }
    }

    private static class MonthRule implements ElementRule<HistoricCalendar, Month> {
        private MonthRule() {
        }

        public Month getValue(HistoricCalendar historicCalendar) {
            return historicCalendar.getMonth();
        }

        public Month getMinimum(HistoricCalendar historicCalendar) {
            return Month.valueOf(((Integer) historicCalendar.getMinimum(historicCalendar.history.month())).intValue());
        }

        public Month getMaximum(HistoricCalendar historicCalendar) {
            return Month.valueOf(((Integer) historicCalendar.getMaximum(historicCalendar.history.month())).intValue());
        }

        public boolean isValid(HistoricCalendar historicCalendar, Month month) {
            if (month == null) {
                return false;
            }
            return historicCalendar.isValid((ChronoElement<Integer>) historicCalendar.history.month(), month.getValue());
        }

        public HistoricCalendar withValue(HistoricCalendar historicCalendar, Month month, boolean z) {
            return (HistoricCalendar) historicCalendar.with((ChronoElement<Integer>) historicCalendar.history.month(), month.getValue());
        }

        public ChronoElement<?> getChildAtFloor(HistoricCalendar historicCalendar) {
            return HistoricCalendar.DAY_OF_MONTH;
        }

        public ChronoElement<?> getChildAtCeiling(HistoricCalendar historicCalendar) {
            return HistoricCalendar.DAY_OF_MONTH;
        }
    }

    private static class GregorianDateRule implements ElementRule<HistoricCalendar, PlainDate> {
        private GregorianDateRule() {
        }

        public PlainDate getValue(HistoricCalendar historicCalendar) {
            return historicCalendar.gregorian;
        }

        public PlainDate getMinimum(HistoricCalendar historicCalendar) {
            return historicCalendar.history.convert((HistoricDate) historicCalendar.gregorian.getMinimum(historicCalendar.history.date()));
        }

        public PlainDate getMaximum(HistoricCalendar historicCalendar) {
            return historicCalendar.history.convert((HistoricDate) historicCalendar.gregorian.getMaximum(historicCalendar.history.date()));
        }

        public boolean isValid(HistoricCalendar historicCalendar, PlainDate plainDate) {
            if (plainDate == null) {
                return false;
            }
            try {
                historicCalendar.history.convert(plainDate);
                return true;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }

        public HistoricCalendar withValue(HistoricCalendar historicCalendar, PlainDate plainDate, boolean z) {
            return new HistoricCalendar(historicCalendar.history, plainDate);
        }

        public ChronoElement<?> getChildAtFloor(HistoricCalendar historicCalendar) {
            throw new UnsupportedOperationException("Never called.");
        }

        public ChronoElement<?> getChildAtCeiling(HistoricCalendar historicCalendar) {
            throw new UnsupportedOperationException("Never called.");
        }
    }

    private static class EraRule implements ElementRule<HistoricCalendar, HistoricEra> {
        private EraRule() {
        }

        public HistoricEra getValue(HistoricCalendar historicCalendar) {
            return historicCalendar.getEra();
        }

        public HistoricEra getMinimum(HistoricCalendar historicCalendar) {
            HistoricEra era = historicCalendar.getEra();
            return era == HistoricEra.AD ? HistoricEra.BC : era;
        }

        public HistoricEra getMaximum(HistoricCalendar historicCalendar) {
            HistoricEra era = historicCalendar.getEra();
            return era == HistoricEra.BC ? HistoricEra.AD : era;
        }

        public boolean isValid(HistoricCalendar historicCalendar, HistoricEra historicEra) {
            return historicEra != null && historicCalendar.date.getEra() == historicEra;
        }

        public HistoricCalendar withValue(HistoricCalendar historicCalendar, HistoricEra historicEra, boolean z) {
            if (historicEra != null && historicCalendar.date.getEra() == historicEra) {
                return historicCalendar;
            }
            throw new IllegalArgumentException(historicEra.name());
        }

        public ChronoElement<?> getChildAtFloor(HistoricCalendar historicCalendar) {
            throw new UnsupportedOperationException("Never called.");
        }

        public ChronoElement<?> getChildAtCeiling(HistoricCalendar historicCalendar) {
            throw new UnsupportedOperationException("Never called.");
        }
    }

    private static class EraElement extends DisplayElement<HistoricEra> implements TextElement<HistoricEra> {
        private static final long serialVersionUID = -4614710504356171166L;

        public char getSymbol() {
            return 'G';
        }

        public boolean isDateElement() {
            return true;
        }

        public boolean isTimeElement() {
            return false;
        }

        EraElement() {
            super("ERA");
        }

        public Class<HistoricEra> getType() {
            return HistoricEra.class;
        }

        public HistoricEra getDefaultMinimum() {
            return HistoricEra.BC;
        }

        public HistoricEra getDefaultMaximum() {
            return HistoricEra.AD;
        }

        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
            if (chronoDisplay instanceof HistoricCalendar) {
                HistoricCalendar cast = HistoricCalendar.class.cast(chronoDisplay);
                TextElement.class.cast(cast.history.era()).print(cast, appendable, attributeQuery);
                return;
            }
            throw new ChronoException("Cannot cast to historic calendar: " + chronoDisplay);
        }

        public HistoricEra parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
            ChronoHistory access$1100 = HistoricCalendar.getHistory(attributeQuery);
            if (access$1100 == null) {
                return null;
            }
            return HistoricEra.class.cast(TextElement.class.cast(access$1100.era()).parse(charSequence, parsePosition, attributeQuery));
        }

        private Object readResolve() throws ObjectStreamException {
            return HistoricCalendar.ERA;
        }
    }

    private static class SimpleElement extends DisplayElement<Integer> {
        private static final long serialVersionUID = 3808762239145701486L;
        private final transient Integer max;
        private final transient Integer min;

        public boolean isDateElement() {
            return true;
        }

        public boolean isTimeElement() {
            return false;
        }

        private SimpleElement(String str, int i, int i2) {
            super(str);
            this.min = Integer.valueOf(i);
            this.max = Integer.valueOf(i2);
        }

        public Class<Integer> getType() {
            return Integer.class;
        }

        public Integer getDefaultMinimum() {
            return this.min;
        }

        public Integer getDefaultMaximum() {
            return this.max;
        }

        /* access modifiers changed from: protected */
        public boolean doEquals(BasicElement<?> basicElement) {
            SimpleElement simpleElement = (SimpleElement) basicElement;
            return this.min.equals(simpleElement.min) && this.max.equals(simpleElement.max);
        }

        private Object readResolve() throws ObjectStreamException {
            String name = name();
            if (name.equals("HC_CONTINUOUS_DOM")) {
                return HistoricCalendar.CONTINUOUS_DOM;
            }
            if (name.equals("CENTURY_OF_ERA")) {
                return HistoricCalendar.CENTURY_OF_ERA;
            }
            throw new InvalidObjectException("Unknown element: " + name);
        }
    }

    private static class YearElement extends SimpleElement implements DualFormatElement {
        private static final long serialVersionUID = 6400379438892131807L;

        public char getSymbol() {
            return 'y';
        }

        private YearElement() {
            super("YEAR_OF_ERA", 1, 999999999);
        }

        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
            if (chronoDisplay instanceof HistoricCalendar) {
                HistoricCalendar cast = HistoricCalendar.class.cast(chronoDisplay);
                cast.history.yearOfEra().print(cast, appendable, attributeQuery);
                return;
            }
            throw new ChronoException("Cannot cast to historic calendar: " + chronoDisplay);
        }

        public Integer parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
            ChronoHistory access$1100 = HistoricCalendar.getHistory(attributeQuery);
            if (access$1100 == null) {
                return null;
            }
            return access$1100.yearOfEra().parse(charSequence, parsePosition, attributeQuery);
        }

        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, NumberSystem numberSystem, char c, int i, int i2) throws IOException, ChronoException {
            if (chronoDisplay instanceof HistoricCalendar) {
                DualFormatElement.class.cast(HistoricCalendar.class.cast(chronoDisplay).history.yearOfEra()).print(chronoDisplay, appendable, attributeQuery, numberSystem, c, i, i2);
                return;
            }
            throw new ChronoException("Cannot cast to historic calendar: " + chronoDisplay);
        }

        public Integer parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery, ChronoEntity<?> chronoEntity) {
            ChronoHistory access$1100 = HistoricCalendar.getHistory(attributeQuery);
            if (access$1100 == null) {
                return null;
            }
            return DualFormatElement.class.cast(access$1100.yearOfEra()).parse(charSequence, parsePosition, attributeQuery, chronoEntity);
        }

        private Object readResolve() throws ObjectStreamException {
            return HistoricCalendar.RELATED_STANDARD_YEAR;
        }
    }

    private static class MonthOperator implements ChronoOperator<HistoricCalendar> {
        private final boolean backwards;

        MonthOperator(boolean z) {
            this.backwards = z;
        }

        public HistoricCalendar apply(HistoricCalendar historicCalendar) {
            int i;
            HistoricEra era = historicCalendar.date.getEra();
            int yearOfEra = historicCalendar.date.getYearOfEra();
            int month = historicCalendar.date.getMonth() + (this.backwards ? -1 : 1);
            int dayOfMonth = historicCalendar.date.getDayOfMonth();
            if (month > 12) {
                if (era == HistoricEra.BC) {
                    yearOfEra--;
                    if (yearOfEra == 0) {
                        era = HistoricEra.AD;
                        yearOfEra = 1;
                    }
                } else {
                    yearOfEra++;
                }
                month = 1;
            } else if (month < 1) {
                if (era == HistoricEra.BC) {
                    i = yearOfEra + 1;
                } else {
                    i = yearOfEra - 1;
                    if (i == 0 && era == HistoricEra.AD) {
                        era = HistoricEra.BC;
                        i = 1;
                    }
                }
                month = 12;
            }
            HistoricDate of = HistoricDate.of(era, yearOfEra, month, dayOfMonth);
            int i2 = dayOfMonth;
            while (i2 > 1 && !historicCalendar.history.isValid(of)) {
                i2--;
                of = HistoricDate.of(era, yearOfEra, month, i2);
            }
            if (i2 == 1) {
                while (dayOfMonth <= 31 && !historicCalendar.history.isValid(of)) {
                    dayOfMonth++;
                    of = HistoricDate.of(era, yearOfEra, month, dayOfMonth);
                }
            }
            return new HistoricCalendar(historicCalendar.history, of);
        }
    }

    private static class Merger implements ChronoMerger<HistoricCalendar> {
        public ChronoDisplay preformat(HistoricCalendar historicCalendar, AttributeQuery attributeQuery) {
            return historicCalendar;
        }

        public Chronology<?> preparser() {
            return null;
        }

        private Merger() {
        }

        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            return GenericDatePatterns.get("generic", displayStyle, locale);
        }

        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.MIDNIGHT;
        }

        public int getDefaultPivotYear() {
            return PlainDate.axis().getDefaultPivotYear();
        }

        /* JADX WARNING: type inference failed for: r5v0, types: [net.time4j.base.TimeSource, net.time4j.base.TimeSource<?>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.calendar.HistoricCalendar createFrom(net.time4j.base.TimeSource<?> r5, net.time4j.engine.AttributeQuery r6) {
            /*
                r4 = this;
                net.time4j.engine.AttributeKey<java.lang.String> r0 = net.time4j.format.Attributes.CALENDAR_VARIANT
                java.lang.String r1 = ""
                java.lang.Object r0 = r6.get(r0, r1)
                java.lang.String r0 = (java.lang.String) r0
                boolean r1 = r0.isEmpty()
                r2 = 0
                if (r1 == 0) goto L_0x0012
                return r2
            L_0x0012:
                net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r1 = net.time4j.format.Attributes.TIMEZONE_ID
                boolean r1 = r6.contains(r1)
                if (r1 == 0) goto L_0x0023
                net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r1 = net.time4j.format.Attributes.TIMEZONE_ID
                java.lang.Object r1 = r6.get(r1)
                net.time4j.tz.TZID r1 = (net.time4j.tz.TZID) r1
                goto L_0x003b
            L_0x0023:
                net.time4j.engine.AttributeKey<net.time4j.format.Leniency> r1 = net.time4j.format.Attributes.LENIENCY
                net.time4j.format.Leniency r3 = net.time4j.format.Leniency.SMART
                java.lang.Object r1 = r6.get(r1, r3)
                net.time4j.format.Leniency r1 = (net.time4j.format.Leniency) r1
                boolean r1 = r1.isLax()
                if (r1 == 0) goto L_0x005e
                net.time4j.tz.Timezone r1 = net.time4j.tz.Timezone.ofSystem()
                net.time4j.tz.TZID r1 = r1.getID()
            L_0x003b:
                net.time4j.engine.AttributeKey<net.time4j.engine.StartOfDay> r2 = net.time4j.format.Attributes.START_OF_DAY
                net.time4j.engine.StartOfDay r3 = r4.getDefaultStartOfDay()
                java.lang.Object r6 = r6.get(r2, r3)
                net.time4j.engine.StartOfDay r6 = (net.time4j.engine.StartOfDay) r6
                net.time4j.base.UnixTime r5 = r5.currentTime()
                net.time4j.Moment r5 = net.time4j.Moment.from(r5)
                net.time4j.engine.CalendarFamily r2 = net.time4j.calendar.HistoricCalendar.ENGINE
                net.time4j.GeneralTimestamp r5 = r5.toGeneralTimestamp(r2, r0, r1, r6)
                java.lang.Object r5 = r5.toDate()
                net.time4j.calendar.HistoricCalendar r5 = (net.time4j.calendar.HistoricCalendar) r5
                return r5
            L_0x005e:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.HistoricCalendar.Merger.createFrom(net.time4j.base.TimeSource, net.time4j.engine.AttributeQuery):net.time4j.calendar.HistoricCalendar");
        }

        public HistoricCalendar createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            ChronoHistory access$1100 = HistoricCalendar.getHistory(attributeQuery);
            if (access$1100 == null) {
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Cannot find any calendar history.");
                return null;
            }
            if (chronoEntity.contains(HistoricCalendar.ERA)) {
                chronoEntity.with((ChronoElement<V>) HistoricCalendar.ERA, null);
                chronoEntity.with((ChronoElement<V>) access$1100.era(), (HistoricEra) chronoEntity.get((ChronoElement<V>) HistoricCalendar.ERA));
            }
            if (chronoEntity.contains(HistoricCalendar.RELATED_STANDARD_YEAR)) {
                int i = chronoEntity.getInt(HistoricCalendar.RELATED_STANDARD_YEAR);
                chronoEntity.with((ChronoElement<V>) HistoricCalendar.RELATED_STANDARD_YEAR, null);
                chronoEntity.with((ChronoElement<Integer>) access$1100.yearOfEra(), i);
            }
            if (chronoEntity.contains(HistoricCalendar.DAY_OF_YEAR)) {
                int i2 = chronoEntity.getInt(HistoricCalendar.DAY_OF_YEAR);
                chronoEntity.with((ChronoElement<V>) HistoricCalendar.DAY_OF_YEAR, null);
                chronoEntity.with(access$1100.dayOfYear(), i2);
            } else {
                if (chronoEntity.contains(HistoricCalendar.MONTH_OF_YEAR)) {
                    chronoEntity.with((ChronoElement<V>) HistoricCalendar.MONTH_OF_YEAR, null);
                    chronoEntity.with((ChronoElement<Integer>) access$1100.month(), ((Month) chronoEntity.get((ChronoElement<V>) HistoricCalendar.MONTH_OF_YEAR)).getValue());
                }
                if (chronoEntity.contains(HistoricCalendar.DAY_OF_MONTH)) {
                    int i3 = chronoEntity.getInt(HistoricCalendar.DAY_OF_MONTH);
                    chronoEntity.with((ChronoElement<V>) HistoricCalendar.DAY_OF_MONTH, null);
                    chronoEntity.with(access$1100.dayOfMonth(), i3);
                }
            }
            ChronoEntity<?> resolve = new HistoricExtension().resolve(chronoEntity, access$1100, attributeQuery);
            if (resolve.contains(PlainDate.COMPONENT)) {
                return new HistoricCalendar(access$1100, (PlainDate) resolve.get((ChronoElement<V>) PlainDate.COMPONENT));
            }
            return null;
        }
    }

    private static class SPX implements Externalizable {
        private static final int HISTORIC = 11;
        private static final long serialVersionUID = 1;
        private transient Object obj;

        public SPX() {
        }

        SPX(Object obj2) {
            this.obj = obj2;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeByte(11);
            writeHistoric(objectOutput);
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            if (objectInput.readByte() == 11) {
                this.obj = readHistoric(objectInput);
                return;
            }
            throw new InvalidObjectException("Unknown calendar type.");
        }

        private Object readResolve() throws ObjectStreamException {
            return this.obj;
        }

        private void writeHistoric(ObjectOutput objectOutput) throws IOException {
            HistoricCalendar historicCalendar = (HistoricCalendar) this.obj;
            objectOutput.writeUTF(historicCalendar.getHistory().getVariant());
            objectOutput.writeLong(((PlainDate) historicCalendar.get(PlainDate.COMPONENT)).getDaysSinceEpochUTC());
        }

        private HistoricCalendar readHistoric(ObjectInput objectInput) throws IOException {
            return (HistoricCalendar) PlainDate.of(objectInput.readLong(), EpochDays.UTC).transform(HistoricCalendar.class, objectInput.readUTF());
        }
    }
}
