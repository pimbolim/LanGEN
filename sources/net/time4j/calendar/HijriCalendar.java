package net.time4j.calendar;

import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.GeneralTimestamp;
import net.time4j.PlainTime;
import net.time4j.SystemClock;
import net.time4j.Weekday;
import net.time4j.Weekmodel;
import net.time4j.base.MathUtils;
import net.time4j.calendar.CommonElements;
import net.time4j.calendar.HijriMonth;
import net.time4j.calendar.service.GenericDatePatterns;
import net.time4j.calendar.service.StdEnumDateElement;
import net.time4j.calendar.service.StdIntegerDateElement;
import net.time4j.calendar.service.StdWeekdayElement;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.CalendarDays;
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
import net.time4j.engine.ChronoUnit;
import net.time4j.engine.Chronology;
import net.time4j.engine.DisplayStyle;
import net.time4j.engine.ElementRule;
import net.time4j.engine.FormattableElement;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.ValidationElement;
import net.time4j.engine.VariantSource;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarType;
import net.time4j.format.LocalizedPatternSupport;

@CalendarType("islamic")
public final class HijriCalendar extends CalendarVariant<HijriCalendar> implements LocalizedPatternSupport {
    public static final StdCalendarElement<Integer, HijriCalendar> BOUNDED_WEEK_OF_MONTH = CommonElements.boundedWeekOfMonth(family(), getDefaultWeekmodel());
    public static final StdCalendarElement<Integer, HijriCalendar> BOUNDED_WEEK_OF_YEAR = CommonElements.boundedWeekOfYear(family(), getDefaultWeekmodel());
    /* access modifiers changed from: private */
    public static final Map<String, EraYearMonthDaySystem<HijriCalendar>> CALSYS;
    @FormattableElement(format = "d")
    public static final StdCalendarElement<Integer, HijriCalendar> DAY_OF_MONTH;
    private static final int DAY_OF_MONTH_INDEX = 2;
    @FormattableElement(format = "E")
    public static final StdCalendarElement<Weekday, HijriCalendar> DAY_OF_WEEK;
    @FormattableElement(format = "D")
    public static final StdCalendarElement<Integer, HijriCalendar> DAY_OF_YEAR = new StdIntegerDateElement("DAY_OF_YEAR", HijriCalendar.class, 1, 355, 'D');
    private static final int DAY_OF_YEAR_INDEX = 3;
    /* access modifiers changed from: private */
    public static final CalendarFamily<HijriCalendar> ENGINE;
    @FormattableElement(format = "G")
    public static final ChronoElement<HijriEra> ERA;
    public static final StdCalendarElement<Weekday, HijriCalendar> LOCAL_DAY_OF_WEEK = CommonElements.localDayOfWeek(family(), getDefaultWeekmodel());
    @FormattableElement(alt = "L", format = "M")
    public static final StdCalendarElement<HijriMonth, HijriCalendar> MONTH_OF_YEAR = new StdEnumDateElement("MONTH_OF_YEAR", HijriCalendar.class, HijriMonth.class, 'M', new HijriMonth.Operator(-1), new HijriMonth.Operator(1));
    public static final String VARIANT_DIYANET = "islamic-diyanet";
    @Deprecated
    public static final String VARIANT_ICU4J = "islamic-icu4j";
    public static final String VARIANT_UMALQURA = "islamic-umalqura";
    @FormattableElement(format = "F")
    public static final OrdinalWeekdayElement<HijriCalendar> WEEKDAY_IN_MONTH;
    public static final StdCalendarElement<Integer, HijriCalendar> WEEK_OF_MONTH = CommonElements.weekOfMonth(family(), getDefaultWeekmodel());
    public static final StdCalendarElement<Integer, HijriCalendar> WEEK_OF_YEAR = CommonElements.weekOfYear(family(), getDefaultWeekmodel());
    private static final WeekdayInMonthElement<HijriCalendar> WIM_ELEMENT;
    private static final int YEAR_INDEX = 0;
    @FormattableElement(format = "y")
    public static final StdCalendarElement<Integer, HijriCalendar> YEAR_OF_ERA = new StdIntegerDateElement("YEAR_OF_ERA", HijriCalendar.class, Integer.MIN_VALUE, Integer.MAX_VALUE, 'y', new HijriMonth.Operator(-12), new HijriMonth.Operator(12));
    private static final long serialVersionUID = 4666707700222367373L;
    /* access modifiers changed from: private */
    public final transient int hdom;
    /* access modifiers changed from: private */
    public final transient int hmonth;
    /* access modifiers changed from: private */
    public final transient int hyear;
    private final transient String variant;

    /* access modifiers changed from: protected */
    public HijriCalendar getContext() {
        return this;
    }

    static {
        Class<HijriCalendar> cls = HijriCalendar.class;
        ERA = new StdEnumDateElement("ERA", cls, HijriEra.class, 'G');
        StdIntegerDateElement stdIntegerDateElement = new StdIntegerDateElement("DAY_OF_MONTH", HijriCalendar.class, 1, 30, 'd');
        DAY_OF_MONTH = stdIntegerDateElement;
        StdWeekdayElement stdWeekdayElement = new StdWeekdayElement(cls, getDefaultWeekmodel());
        DAY_OF_WEEK = stdWeekdayElement;
        WeekdayInMonthElement<HijriCalendar> weekdayInMonthElement = new WeekdayInMonthElement<>(cls, stdIntegerDateElement, stdWeekdayElement);
        WIM_ELEMENT = weekdayInMonthElement;
        WEEKDAY_IN_MONTH = weekdayInMonthElement;
        VariantMap variantMap = new VariantMap();
        variantMap.put(VARIANT_UMALQURA, AstronomicalHijriData.UMALQURA);
        for (HijriAlgorithm hijriAlgorithm : HijriAlgorithm.values()) {
            variantMap.put(hijriAlgorithm.getVariant(), hijriAlgorithm.getCalendarSystem(0));
        }
        CALSYS = variantMap;
        CalendarFamily.Builder<HijriCalendar> appendElement = CalendarFamily.Builder.setUp(cls, new Merger(), variantMap).appendElement(ERA, new EraRule()).appendElement(YEAR_OF_ERA, new IntegerRule(0)).appendElement(MONTH_OF_YEAR, new MonthRule());
        ChronoElement chronoElement = CommonElements.RELATED_GREGORIAN_YEAR;
        StdCalendarElement<Integer, HijriCalendar> stdCalendarElement = DAY_OF_YEAR;
        CalendarFamily.Builder<HijriCalendar> appendElement2 = appendElement.appendElement((ChronoElement<V>) chronoElement, (ElementRule<HijriCalendar, V>) new RelatedGregorianYearRule(variantMap, (ChronoElement<Integer>) stdCalendarElement));
        StdCalendarElement<Integer, HijriCalendar> stdCalendarElement2 = DAY_OF_MONTH;
        CalendarFamily.Builder<HijriCalendar> appendElement3 = appendElement2.appendElement((ChronoElement<V>) stdCalendarElement2, (ElementRule<HijriCalendar, V>) new IntegerRule(2)).appendElement(stdCalendarElement, new IntegerRule(3)).appendElement(DAY_OF_WEEK, new WeekdayRule(getDefaultWeekmodel(), new ChronoFunction<HijriCalendar, CalendarSystem<HijriCalendar>>() {
            public CalendarSystem<HijriCalendar> apply(HijriCalendar hijriCalendar) {
                return hijriCalendar.getChronology().getCalendarSystem(hijriCalendar.getVariant());
            }
        }));
        WeekdayInMonthElement<HijriCalendar> weekdayInMonthElement2 = WIM_ELEMENT;
        ENGINE = appendElement3.appendElement((ChronoElement<V>) weekdayInMonthElement2, (ElementRule<HijriCalendar, V>) WeekdayInMonthElement.getRule(weekdayInMonthElement2)).appendExtension((ChronoExtension) new CommonElements.Weekengine(cls, stdCalendarElement2, stdCalendarElement, getDefaultWeekmodel())).build();
    }

    private HijriCalendar(int i, int i2, int i3, String str) {
        this.hyear = i;
        this.hmonth = i2;
        this.hdom = i3;
        this.variant = str;
    }

    public static HijriCalendar of(String str, int i, HijriMonth hijriMonth, int i2) {
        return of(str, i, hijriMonth.getValue(), i2);
    }

    public static HijriCalendar of(String str, int i, int i2, int i3) {
        if (getCalendarSystem(str).isValid(HijriEra.ANNO_HEGIRAE, i, i2, i3)) {
            return new HijriCalendar(i, i2, i3, str);
        }
        throw new IllegalArgumentException("Invalid hijri date: year=" + i + ", month=" + i2 + ", day=" + i3);
    }

    public static HijriCalendar of(VariantSource variantSource, int i, HijriMonth hijriMonth, int i2) {
        return of(variantSource.getVariant(), i, hijriMonth.getValue(), i2);
    }

    public static HijriCalendar of(VariantSource variantSource, int i, int i2, int i3) {
        return of(variantSource.getVariant(), i, i2, i3);
    }

    public static HijriCalendar ofUmalqura(int i, HijriMonth hijriMonth, int i2) {
        return of(VARIANT_UMALQURA, i, hijriMonth.getValue(), i2);
    }

    public static HijriCalendar ofUmalqura(int i, int i2, int i3) {
        return of(VARIANT_UMALQURA, i, i2, i3);
    }

    public static HijriCalendar nowInSystemTime(String str, StartOfDay startOfDay) {
        return (HijriCalendar) SystemClock.inLocalView().now(family(), str, startOfDay).toDate();
    }

    public static HijriCalendar nowInSystemTime(VariantSource variantSource, StartOfDay startOfDay) {
        return (HijriCalendar) SystemClock.inLocalView().now(family(), variantSource, startOfDay).toDate();
    }

    public HijriEra getEra() {
        return HijriEra.ANNO_HEGIRAE;
    }

    public int getYear() {
        return this.hyear;
    }

    public HijriMonth getMonth() {
        return HijriMonth.valueOf(this.hmonth);
    }

    public int getDayOfMonth() {
        return this.hdom;
    }

    public Weekday getDayOfWeek() {
        return Weekday.valueOf(MathUtils.floorModulo(getCalendarSystem(this.variant).transform(this) + 5, 7) + 1);
    }

    public int getDayOfYear() {
        return ((Integer) get(DAY_OF_YEAR)).intValue();
    }

    public String getVariant() {
        return this.variant;
    }

    public int lengthOfMonth() {
        return getCalendarSystem().getLengthOfMonth(HijriEra.ANNO_HEGIRAE, this.hyear, this.hmonth);
    }

    public int lengthOfYear() {
        try {
            return getCalendarSystem().getLengthOfYear(HijriEra.ANNO_HEGIRAE, this.hyear);
        } catch (IllegalArgumentException e) {
            throw new ChronoException(e.getMessage(), e);
        }
    }

    public static boolean isValid(String str, int i, int i2, int i3) {
        EraYearMonthDaySystem eraYearMonthDaySystem = CALSYS.get(str);
        return eraYearMonthDaySystem != null && eraYearMonthDaySystem.isValid(HijriEra.ANNO_HEGIRAE, i, i2, i3);
    }

    public HijriCalendar nextYear() {
        return (HijriCalendar) with(YEAR_OF_ERA.incremented());
    }

    public HijriCalendar nextMonth() {
        return (HijriCalendar) with(MONTH_OF_YEAR.incremented());
    }

    public HijriCalendar nextDay() {
        return (HijriCalendar) with(DAY_OF_MONTH.incremented());
    }

    public GeneralTimestamp<HijriCalendar> at(PlainTime plainTime) {
        return GeneralTimestamp.of(this, plainTime);
    }

    public GeneralTimestamp<HijriCalendar> atTime(int i, int i2) {
        return at(PlainTime.of(i, i2));
    }

    public HijriCalendar plus(int i, Unit unit) {
        try {
            return unit.addTo(this, i);
        } catch (IllegalArgumentException e) {
            ArithmeticException arithmeticException = new ArithmeticException(e.getMessage());
            arithmeticException.initCause(e);
            throw arithmeticException;
        }
    }

    public HijriCalendar minus(int i, Unit unit) {
        return plus(MathUtils.safeNegate(i), unit);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HijriCalendar)) {
            return false;
        }
        HijriCalendar hijriCalendar = (HijriCalendar) obj;
        if (this.hdom == hijriCalendar.hdom && this.hmonth == hijriCalendar.hmonth && this.hyear == hijriCalendar.hyear && this.variant.equals(hijriCalendar.variant)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.hdom * 17) + (this.hmonth * 31)) + (this.hyear * 37)) ^ this.variant.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("AH-");
        String valueOf = String.valueOf(this.hyear);
        for (int length = valueOf.length(); length < 4; length++) {
            sb.append('0');
        }
        sb.append(valueOf);
        sb.append(SignatureVisitor.SUPER);
        if (this.hmonth < 10) {
            sb.append('0');
        }
        sb.append(this.hmonth);
        sb.append(SignatureVisitor.SUPER);
        if (this.hdom < 10) {
            sb.append('0');
        }
        sb.append(this.hdom);
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        sb.append(this.variant);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public static Weekmodel getDefaultWeekmodel() {
        return Weekmodel.of(Weekday.SUNDAY, 1, Weekday.FRIDAY, Weekday.SATURDAY);
    }

    public static CalendarFamily<HijriCalendar> family() {
        return ENGINE;
    }

    public static void register(HijriData hijriData) {
        String str = "islamic-" + hijriData.name();
        hijriData.prepare();
        try {
            CALSYS.put(str, new AstronomicalHijriData(hijriData));
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Invalid Hijri data.", e);
        }
    }

    public static String getVersion(String str) {
        EraYearMonthDaySystem<HijriCalendar> calendarSystem = getCalendarSystem(str);
        return calendarSystem instanceof AstronomicalHijriData ? AstronomicalHijriData.class.cast(calendarSystem).getVersion() : "";
    }

    /* access modifiers changed from: protected */
    public CalendarFamily<HijriCalendar> getChronology() {
        return ENGINE;
    }

    /* access modifiers changed from: protected */
    public EraYearMonthDaySystem<HijriCalendar> getCalendarSystem() {
        return getCalendarSystem(this.variant);
    }

    private static EraYearMonthDaySystem<HijriCalendar> getCalendarSystem(String str) {
        EraYearMonthDaySystem<HijriCalendar> eraYearMonthDaySystem = CALSYS.get(str);
        if (eraYearMonthDaySystem != null) {
            return eraYearMonthDaySystem;
        }
        throw new ChronoException("Unsupported calendar variant: " + str);
    }

    private Object writeReplace() {
        return new SPX(this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    public enum Unit implements ChronoUnit {
        YEARS(3.061728E7d),
        MONTHS(2551440.0d),
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

        public int between(HijriCalendar hijriCalendar, HijriCalendar hijriCalendar2, String str) {
            int i = AnonymousClass2.$SwitchMap$net$time4j$calendar$HijriCalendar$Unit[ordinal()];
            if (i == 1) {
                return MONTHS.between(hijriCalendar, hijriCalendar2, str) / 12;
            }
            if (i == 2) {
                HijriCalendar hijriCalendar3 = (HijriCalendar) hijriCalendar.withVariant(str);
                HijriCalendar hijriCalendar4 = (HijriCalendar) hijriCalendar2.withVariant(str);
                int access$400 = (((hijriCalendar4.hyear * 12) + (hijriCalendar4.hmonth - 1)) - (hijriCalendar3.hyear * 12)) - (hijriCalendar3.hmonth - 1);
                if (access$400 <= 0 || hijriCalendar4.hdom >= hijriCalendar3.hdom) {
                    return (access$400 >= 0 || hijriCalendar4.hdom <= hijriCalendar3.hdom) ? access$400 : access$400 + 1;
                }
                return access$400 - 1;
            } else if (i == 3) {
                return DAYS.between(hijriCalendar, hijriCalendar2, str) / 7;
            } else {
                if (i == 4) {
                    return (int) CalendarDays.between(hijriCalendar, hijriCalendar2).getAmount();
                }
                throw new UnsupportedOperationException(name());
            }
        }

        public int between(HijriCalendar hijriCalendar, HijriCalendar hijriCalendar2, VariantSource variantSource) {
            return between(hijriCalendar, hijriCalendar2, variantSource.getVariant());
        }

        /* access modifiers changed from: package-private */
        public HijriCalendar addTo(HijriCalendar hijriCalendar, int i) {
            int i2 = AnonymousClass2.$SwitchMap$net$time4j$calendar$HijriCalendar$Unit[ordinal()];
            if (i2 == 1) {
                return (HijriCalendar) hijriCalendar.with((ChronoElement<Integer>) HijriCalendar.YEAR_OF_ERA, MathUtils.safeAdd(hijriCalendar.getYear(), i));
            }
            if (i2 == 2) {
                int safeAdd = MathUtils.safeAdd((hijriCalendar.hyear * 12) + (hijriCalendar.hmonth - 1), i);
                int floorDivide = MathUtils.floorDivide(safeAdd, 12);
                int floorModulo = MathUtils.floorModulo(safeAdd, 12) + 1;
                return HijriCalendar.of(hijriCalendar.getVariant(), floorDivide, floorModulo, Math.min(hijriCalendar.hdom, hijriCalendar.getCalendarSystem().getLengthOfMonth(HijriEra.ANNO_HEGIRAE, floorDivide, floorModulo)));
            } else if (i2 == 3) {
                return DAYS.addTo(hijriCalendar, MathUtils.safeMultiply(i, 7));
            } else {
                if (i2 == 4) {
                    return (HijriCalendar) hijriCalendar.plus(CalendarDays.of((long) i));
                }
                throw new UnsupportedOperationException(name());
            }
        }
    }

    /* renamed from: net.time4j.calendar.HijriCalendar$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$calendar$HijriCalendar$Unit;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                net.time4j.calendar.HijriCalendar$Unit[] r0 = net.time4j.calendar.HijriCalendar.Unit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$calendar$HijriCalendar$Unit = r0
                net.time4j.calendar.HijriCalendar$Unit r1 = net.time4j.calendar.HijriCalendar.Unit.YEARS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$calendar$HijriCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.calendar.HijriCalendar$Unit r1 = net.time4j.calendar.HijriCalendar.Unit.MONTHS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$calendar$HijriCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.calendar.HijriCalendar$Unit r1 = net.time4j.calendar.HijriCalendar.Unit.WEEKS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$net$time4j$calendar$HijriCalendar$Unit     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.calendar.HijriCalendar$Unit r1 = net.time4j.calendar.HijriCalendar.Unit.DAYS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.HijriCalendar.AnonymousClass2.<clinit>():void");
        }
    }

    private static class VariantMap extends ConcurrentHashMap<String, EraYearMonthDaySystem<HijriCalendar>> {
        private VariantMap() {
        }

        public EraYearMonthDaySystem<HijriCalendar> get(Object obj) {
            AstronomicalHijriData astronomicalHijriData = (EraYearMonthDaySystem) super.get(obj);
            if (astronomicalHijriData != null) {
                return astronomicalHijriData;
            }
            String obj2 = obj.toString();
            if (obj.equals(HijriCalendar.VARIANT_UMALQURA)) {
                astronomicalHijriData = AstronomicalHijriData.UMALQURA;
            } else {
                HijriAdjustment from = HijriAdjustment.from(obj2);
                String baseVariant = from.getBaseVariant();
                HijriAlgorithm[] values = HijriAlgorithm.values();
                int length = values.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    HijriAlgorithm hijriAlgorithm = values[i];
                    if (hijriAlgorithm.getVariant().equals(baseVariant)) {
                        astronomicalHijriData = hijriAlgorithm.getCalendarSystem(from.getValue());
                        break;
                    }
                    i++;
                }
                if (astronomicalHijriData == null) {
                    try {
                        astronomicalHijriData = new AstronomicalHijriData(obj2);
                    } catch (IOException | ChronoException unused) {
                        return null;
                    }
                }
            }
            EraYearMonthDaySystem<HijriCalendar> eraYearMonthDaySystem = (EraYearMonthDaySystem) putIfAbsent(obj2, astronomicalHijriData);
            return eraYearMonthDaySystem != null ? eraYearMonthDaySystem : astronomicalHijriData;
        }
    }

    private static class IntegerRule implements ElementRule<HijriCalendar, Integer> {
        private final int index;

        IntegerRule(int i) {
            this.index = i;
        }

        public Integer getValue(HijriCalendar hijriCalendar) {
            int i = this.index;
            if (i == 0) {
                return Integer.valueOf(hijriCalendar.hyear);
            }
            if (i == 2) {
                return Integer.valueOf(hijriCalendar.hdom);
            }
            if (i == 3) {
                int i2 = 0;
                EraYearMonthDaySystem<HijriCalendar> calendarSystem = hijriCalendar.getCalendarSystem();
                for (int i3 = 1; i3 < hijriCalendar.hmonth; i3++) {
                    i2 += calendarSystem.getLengthOfMonth(HijriEra.ANNO_HEGIRAE, hijriCalendar.hyear, i3);
                }
                return Integer.valueOf(i2 + hijriCalendar.hdom);
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public Integer getMinimum(HijriCalendar hijriCalendar) {
            int i = this.index;
            if (i == 0) {
                EraYearMonthDaySystem<HijriCalendar> calendarSystem = hijriCalendar.getCalendarSystem();
                return Integer.valueOf(calendarSystem.transform(calendarSystem.getMinimumSinceUTC()).hyear);
            } else if (i == 2 || i == 3) {
                return 1;
            } else {
                throw new UnsupportedOperationException("Unknown element index: " + this.index);
            }
        }

        public Integer getMaximum(HijriCalendar hijriCalendar) {
            EraYearMonthDaySystem<HijriCalendar> calendarSystem = hijriCalendar.getCalendarSystem();
            int i = this.index;
            if (i == 0) {
                return Integer.valueOf(calendarSystem.transform(calendarSystem.getMaximumSinceUTC()).hyear);
            }
            if (i == 2) {
                return Integer.valueOf(calendarSystem.getLengthOfMonth(HijriEra.ANNO_HEGIRAE, hijriCalendar.hyear, hijriCalendar.hmonth));
            }
            if (i == 3) {
                return Integer.valueOf(calendarSystem.getLengthOfYear(HijriEra.ANNO_HEGIRAE, hijriCalendar.hyear));
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public boolean isValid(HijriCalendar hijriCalendar, Integer num) {
            if (num == null) {
                return false;
            }
            Integer minimum = getMinimum(hijriCalendar);
            Integer maximum = getMaximum(hijriCalendar);
            if (minimum.compareTo(num) > 0 || maximum.compareTo(num) < 0) {
                return false;
            }
            return true;
        }

        public HijriCalendar withValue(HijriCalendar hijriCalendar, Integer num, boolean z) {
            if (isValid(hijriCalendar, num)) {
                int i = this.index;
                if (i == 0) {
                    EraYearMonthDaySystem<HijriCalendar> calendarSystem = hijriCalendar.getCalendarSystem();
                    int intValue = num.intValue();
                    return HijriCalendar.of(hijriCalendar.getVariant(), intValue, hijriCalendar.hmonth, Math.min(hijriCalendar.hdom, calendarSystem.getLengthOfMonth(HijriEra.ANNO_HEGIRAE, intValue, hijriCalendar.hmonth)));
                } else if (i == 2) {
                    return new HijriCalendar(hijriCalendar.hyear, hijriCalendar.hmonth, num.intValue(), hijriCalendar.getVariant());
                } else {
                    if (i == 3) {
                        return (HijriCalendar) hijriCalendar.plus(CalendarDays.of((long) (num.intValue() - getValue(hijriCalendar).intValue())));
                    }
                    throw new UnsupportedOperationException("Unknown element index: " + this.index);
                }
            } else {
                throw new IllegalArgumentException("Out of range: " + num);
            }
        }

        public ChronoElement<?> getChildAtFloor(HijriCalendar hijriCalendar) {
            if (this.index == 0) {
                return HijriCalendar.MONTH_OF_YEAR;
            }
            return null;
        }

        public ChronoElement<?> getChildAtCeiling(HijriCalendar hijriCalendar) {
            if (this.index == 0) {
                return HijriCalendar.MONTH_OF_YEAR;
            }
            return null;
        }
    }

    private static class MonthRule implements ElementRule<HijriCalendar, HijriMonth> {
        public boolean isValid(HijriCalendar hijriCalendar, HijriMonth hijriMonth) {
            return hijriMonth != null;
        }

        private MonthRule() {
        }

        public HijriMonth getValue(HijriCalendar hijriCalendar) {
            return hijriCalendar.getMonth();
        }

        public HijriMonth getMinimum(HijriCalendar hijriCalendar) {
            return HijriMonth.MUHARRAM;
        }

        public HijriMonth getMaximum(HijriCalendar hijriCalendar) {
            return HijriMonth.DHU_AL_HIJJAH;
        }

        public HijriCalendar withValue(HijriCalendar hijriCalendar, HijriMonth hijriMonth, boolean z) {
            if (hijriMonth != null) {
                int value = hijriMonth.getValue();
                return new HijriCalendar(hijriCalendar.hyear, value, Math.min(hijriCalendar.hdom, hijriCalendar.getCalendarSystem().getLengthOfMonth(HijriEra.ANNO_HEGIRAE, hijriCalendar.hyear, value)), hijriCalendar.getVariant());
            }
            throw new IllegalArgumentException("Missing month.");
        }

        public ChronoElement<?> getChildAtFloor(HijriCalendar hijriCalendar) {
            return HijriCalendar.DAY_OF_MONTH;
        }

        public ChronoElement<?> getChildAtCeiling(HijriCalendar hijriCalendar) {
            return HijriCalendar.DAY_OF_MONTH;
        }
    }

    private static class EraRule implements ElementRule<HijriCalendar, HijriEra> {
        public boolean isValid(HijriCalendar hijriCalendar, HijriEra hijriEra) {
            return hijriEra != null;
        }

        private EraRule() {
        }

        public HijriEra getValue(HijriCalendar hijriCalendar) {
            return HijriEra.ANNO_HEGIRAE;
        }

        public HijriEra getMinimum(HijriCalendar hijriCalendar) {
            return HijriEra.ANNO_HEGIRAE;
        }

        public HijriEra getMaximum(HijriCalendar hijriCalendar) {
            return HijriEra.ANNO_HEGIRAE;
        }

        public HijriCalendar withValue(HijriCalendar hijriCalendar, HijriEra hijriEra, boolean z) {
            if (hijriEra != null) {
                return hijriCalendar;
            }
            throw new IllegalArgumentException("Missing era value.");
        }

        public ChronoElement<?> getChildAtFloor(HijriCalendar hijriCalendar) {
            return HijriCalendar.YEAR_OF_ERA;
        }

        public ChronoElement<?> getChildAtCeiling(HijriCalendar hijriCalendar) {
            return HijriCalendar.YEAR_OF_ERA;
        }
    }

    private static class Merger implements ChronoMerger<HijriCalendar> {
        public ChronoDisplay preformat(HijriCalendar hijriCalendar, AttributeQuery attributeQuery) {
            return hijriCalendar;
        }

        public Chronology<?> preparser() {
            return null;
        }

        private Merger() {
        }

        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            return GenericDatePatterns.get("islamic", displayStyle, locale);
        }

        /* JADX WARNING: type inference failed for: r5v0, types: [net.time4j.base.TimeSource, net.time4j.base.TimeSource<?>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.calendar.HijriCalendar createFrom(net.time4j.base.TimeSource<?> r5, net.time4j.engine.AttributeQuery r6) {
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
                net.time4j.engine.CalendarFamily r2 = net.time4j.calendar.HijriCalendar.ENGINE
                net.time4j.GeneralTimestamp r5 = r5.toGeneralTimestamp(r2, r0, r1, r6)
                java.lang.Object r5 = r5.toDate()
                net.time4j.calendar.HijriCalendar r5 = (net.time4j.calendar.HijriCalendar) r5
                return r5
            L_0x005e:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.HijriCalendar.Merger.createFrom(net.time4j.base.TimeSource, net.time4j.engine.AttributeQuery):net.time4j.calendar.HijriCalendar");
        }

        public HijriCalendar createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            String str = (String) attributeQuery.get(Attributes.CALENDAR_VARIANT, "");
            if (str.isEmpty()) {
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Missing Hijri calendar variant.");
                return null;
            }
            EraYearMonthDaySystem eraYearMonthDaySystem = (EraYearMonthDaySystem) HijriCalendar.CALSYS.get(str);
            if (eraYearMonthDaySystem == null) {
                ValidationElement validationElement = ValidationElement.ERROR_MESSAGE;
                chronoEntity.with((ChronoElement<V>) validationElement, "Unknown Hijri calendar variant: " + str);
                return null;
            }
            int i = chronoEntity.getInt(HijriCalendar.YEAR_OF_ERA);
            if (i == Integer.MIN_VALUE) {
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Missing islamic year.");
                return null;
            }
            if (chronoEntity.contains(HijriCalendar.MONTH_OF_YEAR)) {
                int value = ((HijriMonth) chronoEntity.get((ChronoElement<V>) HijriCalendar.MONTH_OF_YEAR)).getValue();
                int i2 = chronoEntity.getInt(HijriCalendar.DAY_OF_MONTH);
                if (i2 != Integer.MIN_VALUE) {
                    if (eraYearMonthDaySystem.isValid(HijriEra.ANNO_HEGIRAE, i, value, i2)) {
                        return HijriCalendar.of(str, i, value, i2);
                    }
                    chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Invalid Hijri date.");
                }
            } else {
                int i3 = chronoEntity.getInt(HijriCalendar.DAY_OF_YEAR);
                if (i3 != Integer.MIN_VALUE) {
                    if (i3 > 0) {
                        int i4 = 0;
                        int i5 = 1;
                        while (i5 <= 12) {
                            int lengthOfMonth = eraYearMonthDaySystem.getLengthOfMonth(HijriEra.ANNO_HEGIRAE, i, i5) + i4;
                            if (i3 <= lengthOfMonth) {
                                return HijriCalendar.of(str, i, i5, i3 - i4);
                            }
                            i5++;
                            i4 = lengthOfMonth;
                        }
                    }
                    chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Invalid Hijri date.");
                }
            }
            return null;
        }

        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.EVENING;
        }

        public int getDefaultPivotYear() {
            return HijriCalendar.nowInSystemTime((VariantSource) HijriAlgorithm.WEST_ISLAMIC_CIVIL, StartOfDay.MIDNIGHT).getYear() + 20;
        }
    }

    private static class SPX implements Externalizable {
        private static final int HIJRI = 1;
        private static final long serialVersionUID = 1;
        private transient Object obj;

        public SPX() {
        }

        SPX(Object obj2) {
            this.obj = obj2;
        }

        public void writeExternal(ObjectOutput objectOutput) throws IOException {
            objectOutput.writeByte(1);
            writeHijri(objectOutput);
        }

        public void readExternal(ObjectInput objectInput) throws IOException {
            if (objectInput.readByte() == 1) {
                this.obj = readHijri(objectInput);
                return;
            }
            throw new InvalidObjectException("Unknown calendar type.");
        }

        private Object readResolve() throws ObjectStreamException {
            return this.obj;
        }

        private void writeHijri(ObjectOutput objectOutput) throws IOException {
            HijriCalendar hijriCalendar = (HijriCalendar) this.obj;
            objectOutput.writeUTF(hijriCalendar.getVariant());
            objectOutput.writeUTF(HijriCalendar.getVersion(hijriCalendar.getVariant()));
            objectOutput.writeInt(hijriCalendar.getYear());
            objectOutput.writeByte(hijriCalendar.getMonth().getValue());
            objectOutput.writeByte(hijriCalendar.getDayOfMonth());
        }

        private HijriCalendar readHijri(ObjectInput objectInput) throws IOException {
            String readUTF = objectInput.readUTF();
            String readUTF2 = objectInput.readUTF();
            if (HijriCalendar.getVersion(readUTF).equals(readUTF2)) {
                return HijriCalendar.of(readUTF, objectInput.readInt(), (int) objectInput.readByte(), (int) objectInput.readByte());
            }
            throw new InvalidObjectException("Hijri calendar object with different data version not supported: " + readUTF + "/" + readUTF2);
        }
    }
}
