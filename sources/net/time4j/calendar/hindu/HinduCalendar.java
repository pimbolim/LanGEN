package net.time4j.calendar.hindu;

import com.stripe.android.view.PaymentMethodsActivityStarter;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.GeneralTimestamp;
import net.time4j.PlainTime;
import net.time4j.SystemClock;
import net.time4j.Weekday;
import net.time4j.base.MathUtils;
import net.time4j.calendar.CommonElements;
import net.time4j.calendar.IndianCalendar;
import net.time4j.calendar.IndianMonth;
import net.time4j.calendar.StdCalendarElement;
import net.time4j.calendar.astro.SolarTime;
import net.time4j.calendar.service.Java8Function;
import net.time4j.calendar.service.RelatedGregorianYearRule;
import net.time4j.calendar.service.StdEnumDateElement;
import net.time4j.calendar.service.StdIntegerDateElement;
import net.time4j.calendar.service.StdWeekdayElement;
import net.time4j.calendar.service.WeekdayRule;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.CalendarDays;
import net.time4j.engine.CalendarFamily;
import net.time4j.engine.CalendarSystem;
import net.time4j.engine.CalendarVariant;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.ChronoMerger;
import net.time4j.engine.ChronoOperator;
import net.time4j.engine.Chronology;
import net.time4j.engine.DisplayStyle;
import net.time4j.engine.ElementRule;
import net.time4j.engine.FormattableElement;
import net.time4j.engine.IntElementRule;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.ValidationElement;
import net.time4j.engine.VariantSource;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.CalendarType;
import net.time4j.format.DisplayElement;
import net.time4j.format.LocalizedPatternSupport;
import net.time4j.format.NumberSystem;
import net.time4j.format.OutputContext;
import net.time4j.format.TextWidth;
import net.time4j.format.internal.DualFormatElement;
import net.time4j.format.internal.DualFormatHelper;

@CalendarType("hindu")
public final class HinduCalendar extends CalendarVariant<HinduCalendar> implements LocalizedPatternSupport {
    private static final Map<String, HinduCS> CALSYS;
    @FormattableElement(format = "d")
    public static final AdjustableTextElement<HinduDay> DAY_OF_MONTH = DayOfMonthElement.SINGLETON;
    @FormattableElement(format = "E")
    public static final StdCalendarElement<Weekday, HinduCalendar> DAY_OF_WEEK;
    @FormattableElement(format = "D")
    public static final StdCalendarElement<Integer, HinduCalendar> DAY_OF_YEAR = new StdIntegerDateElement("DAY_OF_YEAR", HinduCalendar.class, 1, 365, 'D');
    private static final int DAY_OF_YEAR_INDEX = 1;
    /* access modifiers changed from: private */
    public static final CalendarFamily<HinduCalendar> ENGINE;
    @FormattableElement(format = "G")
    public static final ChronoElement<HinduEra> ERA;
    private static final int MAX_YEAR = 5999;
    private static final int MIN_YEAR = 1200;
    @FormattableElement(format = "M")
    public static final AdjustableTextElement<HinduMonth> MONTH_OF_YEAR = MonthElement.SINGLETON;
    private static final int YEAR_INDEX = 0;
    @FormattableElement(format = "y")
    public static final StdCalendarElement<Integer, HinduCalendar> YEAR_OF_ERA = new StdIntegerDateElement("YEAR_OF_ERA", HinduCalendar.class, 0, PaymentMethodsActivityStarter.REQUEST_CODE, 'y');
    private static final long serialVersionUID = 4078031838043675524L;
    /* access modifiers changed from: private */
    public final transient HinduDay dayOfMonth;
    /* access modifiers changed from: private */
    public final transient int kyYear;
    /* access modifiers changed from: private */
    public final transient HinduMonth month;
    /* access modifiers changed from: private */
    public final transient long utcDays;
    /* access modifiers changed from: private */
    public final transient HinduVariant variant;

    /* access modifiers changed from: protected */
    public HinduCalendar getContext() {
        return this;
    }

    static {
        Class<HinduCalendar> cls = HinduCalendar.class;
        ERA = new StdEnumDateElement("ERA", cls, HinduEra.class, 'G');
        DAY_OF_WEEK = new StdWeekdayElement(cls, IndianCalendar.getDefaultWeekmodel());
        VariantMap variantMap = new VariantMap();
        for (HinduRule variant2 : HinduRule.values()) {
            variantMap.accept(variant2.variant());
        }
        variantMap.accept(HinduVariant.VAR_OLD_SOLAR);
        variantMap.accept(HinduVariant.VAR_OLD_LUNAR);
        CALSYS = variantMap;
        CalendarFamily.Builder<HinduCalendar> up = CalendarFamily.Builder.setUp(cls, new Merger(), variantMap);
        ChronoElement chronoElement = CommonElements.RELATED_GREGORIAN_YEAR;
        StdCalendarElement<Integer, HinduCalendar> stdCalendarElement = DAY_OF_YEAR;
        ENGINE = up.appendElement((ChronoElement<V>) chronoElement, (ElementRule<HinduCalendar, V>) new RelatedGregorianYearRule(variantMap, (ChronoElement<Integer>) stdCalendarElement)).appendElement(ERA, new EraRule()).appendElement(YEAR_OF_ERA, new IntegerRule(0)).appendElement(MONTH_OF_YEAR, MonthElement.SINGLETON).appendElement(DAY_OF_MONTH, DayOfMonthElement.SINGLETON).appendElement(stdCalendarElement, new IntegerRule(1)).appendElement(DAY_OF_WEEK, new WeekdayRule(IndianCalendar.getDefaultWeekmodel(), new Java8Function<HinduCalendar, CalendarSystem<HinduCalendar>>() {
            public CalendarSystem<HinduCalendar> apply(HinduCalendar hinduCalendar) {
                return hinduCalendar.getCalendarSystem();
            }
        })).build();
    }

    HinduCalendar(HinduVariant hinduVariant, int i, HinduMonth hinduMonth, HinduDay hinduDay, long j) {
        Objects.requireNonNull(hinduVariant, "Missing variant.");
        Objects.requireNonNull(hinduMonth, "Missing month.");
        Objects.requireNonNull(hinduDay, "Missing day of month.");
        this.variant = hinduVariant;
        this.kyYear = i;
        this.month = hinduMonth;
        this.dayOfMonth = hinduDay;
        this.utcDays = j;
    }

    public static HinduCalendar nowInSystemTime(HinduVariant hinduVariant) {
        return nowInSystemTime(hinduVariant, family().getDefaultStartOfDay());
    }

    public static HinduCalendar nowInSystemTime(HinduVariant hinduVariant, StartOfDay startOfDay) {
        return (HinduCalendar) SystemClock.inLocalView().now(family(), (VariantSource) hinduVariant, startOfDay).toDate();
    }

    public static HinduCalendar ofOldSolar(int i, int i2, int i3) {
        if (i3 <= 31) {
            return of(HinduVariant.VAR_OLD_SOLAR, HinduEra.KALI_YUGA, i, HinduMonth.ofSolar(i2), HinduDay.valueOf(i3));
        }
        throw new IllegalArgumentException("Day-of-month out of range: " + i3);
    }

    public static HinduCalendar ofOldLunar(int i, HinduMonth hinduMonth, int i2) {
        if (i2 <= 30) {
            return of(HinduVariant.VAR_OLD_LUNAR, HinduEra.KALI_YUGA, i, hinduMonth, HinduDay.valueOf(i2));
        }
        throw new IllegalArgumentException("Day-of-month out of range: " + i2);
    }

    public static HinduCalendar of(HinduVariant hinduVariant, HinduEra hinduEra, int i, HinduMonth hinduMonth, HinduDay hinduDay) {
        HinduCS calendarSystem = hinduVariant.with(hinduEra).getCalendarSystem();
        int yearOfEra = HinduEra.KALI_YUGA.yearOfEra(hinduEra, i);
        if (!hinduVariant.isUsingElapsedYears()) {
            yearOfEra--;
        }
        if (yearOfEra < 0) {
            throw new IllegalArgumentException("Kali yuga year must not be smaller than 0: " + yearOfEra);
        } else if (!hinduVariant.isOld() && yearOfEra < MIN_YEAR) {
            throw new IllegalArgumentException("Year out of range in modern Hindu calendar: " + yearOfEra);
        } else if (calendarSystem.isValid(yearOfEra, hinduMonth, hinduDay)) {
            return calendarSystem.create(yearOfEra, hinduMonth, hinduDay);
        } else {
            throw new IllegalArgumentException("Invalid values: " + hinduVariant + "[" + hinduEra + "/" + i + "/" + hinduMonth + "/" + hinduDay + "]");
        }
    }

    public static boolean isValid(HinduVariant hinduVariant, HinduEra hinduEra, int i, HinduMonth hinduMonth, HinduDay hinduDay) {
        HinduCS calendarSystem = hinduVariant.with(hinduEra).getCalendarSystem();
        int yearOfEra = HinduEra.KALI_YUGA.yearOfEra(hinduEra, i);
        if (!hinduVariant.isUsingElapsedYears()) {
            yearOfEra--;
        }
        if (yearOfEra < 0) {
            return false;
        }
        if (hinduVariant.isOld() || yearOfEra >= MIN_YEAR) {
            return calendarSystem.isValid(yearOfEra, hinduMonth, hinduDay);
        }
        return false;
    }

    public int lengthOfMonth() {
        return (int) (withMidOfMonth(1).withFirstDayOfMonth().utcDays - withFirstDayOfMonth().utcDays);
    }

    public int lengthOfYear() {
        return ((Integer) getMaximum(DAY_OF_YEAR)).intValue();
    }

    public String getVariant() {
        return this.variant.getVariant();
    }

    public HinduEra getEra() {
        HinduEra defaultEra = this.variant.getDefaultEra();
        return defaultEra.yearOfEra(HinduEra.KALI_YUGA, this.kyYear) < 0 ? HinduEra.KALI_YUGA : defaultEra;
    }

    public int getYear() {
        int yearOfEra = getEra().yearOfEra(HinduEra.KALI_YUGA, this.kyYear);
        return !this.variant.isUsingElapsedYears() ? yearOfEra + 1 : yearOfEra;
    }

    public HinduMonth getMonth() {
        return this.month;
    }

    public HinduDay getDayOfMonth() {
        return this.dayOfMonth;
    }

    public Weekday getDayOfWeek() {
        return Weekday.valueOf(MathUtils.floorModulo(this.utcDays + 5, 7) + 1);
    }

    public int getDayOfYear() {
        return (int) ((this.utcDays - withNewYear().utcDays) + 1);
    }

    public HinduCalendar previousDay() {
        return getCalendarSystem().transform(this.utcDays - 1);
    }

    public HinduCalendar previousMonth() {
        HinduCalendar withAdjustedDayInMonth = withMidOfMonth(-1).withAdjustedDayInMonth(this.dayOfMonth);
        if (withAdjustedDayInMonth.utcDays >= this.variant.getCalendarSystem().getMinimumSinceUTC()) {
            return withAdjustedDayInMonth;
        }
        throw new IllegalArgumentException("Hindu date out of range");
    }

    public HinduCalendar previousYear() {
        return withYearChangedBy(-1);
    }

    public HinduCalendar nextDay() {
        return getCalendarSystem().transform(this.utcDays + 1);
    }

    public HinduCalendar nextMonth() {
        HinduCalendar withAdjustedDayInMonth = withMidOfMonth(1).withAdjustedDayInMonth(this.dayOfMonth);
        if (withAdjustedDayInMonth.utcDays <= this.variant.getCalendarSystem().getMaximumSinceUTC()) {
            return withAdjustedDayInMonth;
        }
        throw new IllegalArgumentException("Hindu date out of range");
    }

    public HinduCalendar nextYear() {
        return withYearChangedBy(1);
    }

    public GeneralTimestamp<HinduCalendar> at(PlainTime plainTime) {
        return GeneralTimestamp.of(this, plainTime);
    }

    public GeneralTimestamp<HinduCalendar> atTime(int i, int i2) {
        return at(PlainTime.of(i, i2));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HinduCalendar)) {
            return false;
        }
        HinduCalendar hinduCalendar = (HinduCalendar) obj;
        if (!this.variant.equals(hinduCalendar.variant) || this.kyYear != hinduCalendar.kyYear || !this.month.equals(hinduCalendar.month) || !this.dayOfMonth.equals(hinduCalendar.dayOfMonth) || this.utcDays != hinduCalendar.utcDays) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.variant.hashCode() * 7) + (this.kyYear * 17) + (this.month.hashCode() * 31) + (this.dayOfMonth.hashCode() * 37);
    }

    public String toString() {
        return AbstractJsonLexerKt.BEGIN_LIST + this.variant + ",era=" + getEra() + ",year-of-era=" + getYear() + ",month=" + this.month + ",day-of-month=" + this.dayOfMonth + AbstractJsonLexerKt.END_LIST;
    }

    public long getDaysSinceEpochUTC() {
        return this.utcDays;
    }

    public static CalendarFamily<HinduCalendar> family() {
        return ENGINE;
    }

    /* access modifiers changed from: protected */
    public CalendarFamily<HinduCalendar> getChronology() {
        return ENGINE;
    }

    /* access modifiers changed from: protected */
    public CalendarSystem<HinduCalendar> getCalendarSystem() {
        return this.variant.getCalendarSystem();
    }

    /* access modifiers changed from: package-private */
    public int getExpiredYearOfKaliYuga() {
        return this.kyYear;
    }

    /* access modifiers changed from: package-private */
    public HinduCalendar withNewYear() {
        HinduMonth hinduMonth;
        if (this.variant.isPurnimanta()) {
            return this.variant.getCalendarSystem().create(this.variant.toAmanta().create(this.kyYear, HinduMonth.ofLunisolar(1), HinduDay.valueOf(15)).withNewYear().getDaysSinceEpochUTC());
        }
        if (this.variant.isSolar()) {
            hinduMonth = HinduMonth.ofSolar(1);
        } else {
            hinduMonth = HinduMonth.ofLunisolar(this.variant.getFirstMonthOfYear());
        }
        HinduCS calendarSystem = this.variant.getCalendarSystem();
        HinduCalendar create = calendarSystem.create(this.kyYear, hinduMonth, HinduDay.valueOf(15));
        if (this.variant.isLunisolar()) {
            HinduCalendar create2 = calendarSystem.create(create.utcDays - 30);
            if (create2.getMonth().isLeap() && create2.kyYear == this.kyYear) {
                create = create2;
            }
        }
        return create.withFirstDayOfMonth();
    }

    /* access modifiers changed from: package-private */
    public HinduCalendar withFirstDayOfMonth() {
        HinduDay valueOf = HinduDay.valueOf(1);
        HinduCS calendarSystem = this.variant.getCalendarSystem();
        int i = this.kyYear;
        if (this.variant.isLunisolar()) {
            int i2 = 3;
            if (this.variant.isPurnimanta()) {
                HinduDay valueOf2 = HinduDay.valueOf(16);
                if (isChaitra() && this.dayOfMonth.getValue() < 16) {
                    if (this.month.equals(withNewYear().month)) {
                        i--;
                    }
                }
                valueOf = valueOf2;
            }
            while (calendarSystem.isExpunged(i, this.month, valueOf)) {
                if (i2 != 0) {
                    if (valueOf.isLeap()) {
                        valueOf = HinduDay.valueOf(valueOf.getValue() + 1);
                    } else {
                        valueOf = valueOf.withLeap();
                    }
                    i2--;
                } else {
                    throw new IllegalArgumentException("Cannot determine first day of month: " + this);
                }
            }
        }
        return calendarSystem.create(i, this.month, valueOf);
    }

    /* access modifiers changed from: private */
    public HinduCalendar withMidOfMonth(int i) {
        int value = this.dayOfMonth.getValue();
        if (this.variant.isPurnimanta()) {
            value = value >= 16 ? value - 15 : value + 15;
        }
        return this.variant.getCalendarSystem().create(((this.utcDays + Math.round(((double) i) * (this.variant.isSolar() ? 30.4d : 29.5d))) + 15) - ((long) value));
    }

    private HinduCalendar withYearChangedBy(int i) {
        return (HinduCalendar) with((ChronoElement<Integer>) YEAR_OF_ERA, getYear() + i);
    }

    /* access modifiers changed from: private */
    public HinduCalendar withAdjustedDayInMonth(HinduDay hinduDay) {
        HinduCS calendarSystem = this.variant.getCalendarSystem();
        boolean isPurnimanta = this.variant.isPurnimanta();
        boolean z = isPurnimanta && isChaitra() && withNewYear().month.equals(this.month);
        int i = 5;
        HinduDay hinduDay2 = hinduDay;
        while (true) {
            int criticalYear = criticalYear(z, hinduDay2);
            if (!calendarSystem.isExpunged(criticalYear, this.month, hinduDay2)) {
                return calendarSystem.create(criticalYear, this.month, hinduDay2);
            }
            if (hinduDay2.getValue() == (isPurnimanta ? 16 : 1) && !hinduDay2.isLeap()) {
                return withFirstDayOfMonth();
            }
            if (i != 0) {
                if (hinduDay2.isLeap()) {
                    hinduDay2 = HinduDay.valueOf(hinduDay2.getValue());
                } else {
                    int value = hinduDay2.getValue() - 1;
                    if (isPurnimanta && value == 0) {
                        value = 30;
                    }
                    hinduDay2 = HinduDay.valueOf(value);
                    if (this.variant.isLunisolar()) {
                        hinduDay2 = hinduDay2.withLeap();
                    }
                }
                i--;
            } else if (calendarSystem.isExpunged(criticalYear, this.month)) {
                throw new IllegalArgumentException("Kshaia (lost) month is never valid: kali-yuga-year=" + criticalYear + ", month=" + this.month);
            } else {
                throw new IllegalArgumentException("No valid day found for: " + this + " => (desired day=" + hinduDay + ")");
            }
        }
    }

    /* access modifiers changed from: private */
    public int criticalYear(boolean z, HinduDay hinduDay) {
        if (z) {
            if (this.dayOfMonth.getValue() >= 16 && hinduDay.getValue() < 16) {
                return this.kyYear + 1;
            }
            if (this.dayOfMonth.getValue() < 16 && hinduDay.getValue() >= 16) {
                return this.kyYear - 1;
            }
        }
        return this.kyYear;
    }

    /* access modifiers changed from: private */
    public boolean isChaitra() {
        return this.month.getValue().equals(IndianMonth.CHAITRA);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int parseLeadingLeapInfo(java.lang.CharSequence r3, int r4, int r5, boolean r6, java.lang.String r7, char r8, java.util.Locale r9) {
        /*
            int r0 = r7.length()
            int r0 = r0 + r4
            r1 = 1
            if (r0 >= r5) goto L_0x002d
            java.lang.CharSequence r2 = r3.subSequence(r4, r0)
            java.lang.String r2 = r2.toString()
            if (r6 == 0) goto L_0x001a
            java.lang.String r7 = r7.toUpperCase(r9)
            java.lang.String r2 = r2.toUpperCase(r9)
        L_0x001a:
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L_0x002d
            if (r0 >= r5) goto L_0x002f
            char r5 = r3.charAt(r0)
            r7 = 32
            if (r5 != r7) goto L_0x002f
            int r0 = r0 + 1
            goto L_0x002f
        L_0x002d:
            r1 = 0
            r0 = r4
        L_0x002f:
            if (r1 != 0) goto L_0x0036
            int r3 = parseLeapIndicator(r3, r4, r6, r8)
            return r3
        L_0x0036:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.hindu.HinduCalendar.parseLeadingLeapInfo(java.lang.CharSequence, int, int, boolean, java.lang.String, char, java.util.Locale):int");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int parseTrailingLeapInfo(java.lang.CharSequence r3, int r4, int r5, boolean r6, java.lang.String r7, char r8, java.util.Locale r9) {
        /*
            int r0 = r7.length()
            int r0 = r0 + r4
            if (r0 >= r5) goto L_0x0014
            char r1 = r3.charAt(r4)
            r2 = 32
            if (r1 != r2) goto L_0x0014
            int r1 = r4 + 1
            int r0 = r0 + 1
            goto L_0x0015
        L_0x0014:
            r1 = r4
        L_0x0015:
            if (r0 >= r5) goto L_0x0031
            java.lang.CharSequence r5 = r3.subSequence(r1, r0)
            java.lang.String r5 = r5.toString()
            if (r6 == 0) goto L_0x0029
            java.lang.String r7 = r7.toUpperCase(r9)
            java.lang.String r5 = r5.toUpperCase(r9)
        L_0x0029:
            boolean r5 = r7.equals(r5)
            if (r5 == 0) goto L_0x0031
            r5 = 1
            goto L_0x0033
        L_0x0031:
            r5 = 0
            r0 = r1
        L_0x0033:
            if (r5 != 0) goto L_0x003a
            int r3 = parseLeapIndicator(r3, r4, r6, r8)
            return r3
        L_0x003a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.hindu.HinduCalendar.parseTrailingLeapInfo(java.lang.CharSequence, int, int, boolean, java.lang.String, char, java.util.Locale):int");
    }

    private static int parseLeapIndicator(CharSequence charSequence, int i, boolean z, char c) {
        char charAt = charSequence.charAt(i);
        if (z) {
            charAt = Character.toUpperCase(charAt);
            c = Character.toUpperCase(c);
        }
        if (charAt == c) {
            return i + 1;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static HinduVariant getVariant(ChronoDisplay chronoDisplay, AttributeQuery attributeQuery) {
        String str;
        if (chronoDisplay instanceof VariantSource) {
            return HinduVariant.from(((VariantSource) chronoDisplay).getVariant());
        }
        if (attributeQuery.contains(Attributes.CALENDAR_VARIANT)) {
            return HinduVariant.from((String) attributeQuery.get(Attributes.CALENDAR_VARIANT));
        }
        if (chronoDisplay == null) {
            str = "<attributes>";
        } else {
            str = chronoDisplay.toString();
        }
        throw new IllegalArgumentException("Cannot infer Hindu calendar variant: " + str);
    }

    private Object writeReplace() {
        return new SPX(this, 20);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }

    private static class VariantMap extends ConcurrentHashMap<String, HinduCS> {
        private VariantMap() {
        }

        public HinduCS get(Object obj) {
            HinduCS hinduCS = (HinduCS) super.get(obj);
            if (hinduCS != null) {
                return hinduCS;
            }
            String obj2 = obj.toString();
            HinduCS calendarSystem = HinduVariant.from(obj2).getCalendarSystem();
            HinduCS hinduCS2 = (HinduCS) putIfAbsent(obj2, calendarSystem);
            return hinduCS2 != null ? hinduCS2 : calendarSystem;
        }

        /* access modifiers changed from: package-private */
        public void accept(HinduVariant hinduVariant) {
            put(hinduVariant.getVariant(), hinduVariant.getCalendarSystem());
        }
    }

    private static class EraRule implements ElementRule<HinduCalendar, HinduEra> {
        private EraRule() {
        }

        public HinduEra getValue(HinduCalendar hinduCalendar) {
            return hinduCalendar.getEra();
        }

        public HinduEra getMinimum(HinduCalendar hinduCalendar) {
            return HinduEra.KALI_YUGA;
        }

        public HinduEra getMaximum(HinduCalendar hinduCalendar) {
            if (!hinduCalendar.variant.isOld()) {
                HinduEra[] values = HinduEra.values();
                for (int length = values.length - 1; length >= 1; length--) {
                    HinduEra hinduEra = values[length];
                    if (hinduEra.yearOfEra(HinduEra.KALI_YUGA, hinduCalendar.kyYear) >= 0) {
                        return hinduEra;
                    }
                }
            }
            return HinduEra.KALI_YUGA;
        }

        public boolean isValid(HinduCalendar hinduCalendar, HinduEra hinduEra) {
            if (hinduCalendar.variant.isOld()) {
                if (hinduEra == HinduEra.KALI_YUGA) {
                    return true;
                }
            } else if (hinduEra != null) {
                return true;
            }
            return false;
        }

        public HinduCalendar withValue(HinduCalendar hinduCalendar, HinduEra hinduEra, boolean z) {
            if (isValid(hinduCalendar, hinduEra)) {
                HinduVariant with = hinduCalendar.variant.with(hinduEra);
                if (with == hinduCalendar.variant) {
                    return hinduCalendar;
                }
                return new HinduCalendar(with, hinduCalendar.kyYear, hinduCalendar.month, hinduCalendar.dayOfMonth, hinduCalendar.utcDays);
            }
            throw new IllegalArgumentException("Invalid Hindu era: " + hinduEra);
        }

        public ChronoElement<?> getChildAtFloor(HinduCalendar hinduCalendar) {
            return HinduCalendar.YEAR_OF_ERA;
        }

        public ChronoElement<?> getChildAtCeiling(HinduCalendar hinduCalendar) {
            return HinduCalendar.YEAR_OF_ERA;
        }
    }

    private static class IntegerRule implements IntElementRule<HinduCalendar> {
        private final int index;

        IntegerRule(int i) {
            this.index = i;
        }

        public int getInt(HinduCalendar hinduCalendar) {
            int i = this.index;
            if (i == 0) {
                return hinduCalendar.getYear();
            }
            if (i == 1) {
                return hinduCalendar.getDayOfYear();
            }
            throw new UnsupportedOperationException("Unknown element index: " + this.index);
        }

        public boolean isValid(HinduCalendar hinduCalendar, int i) {
            return getMin(hinduCalendar) <= i && getMax(hinduCalendar) >= i;
        }

        public HinduCalendar withValue(HinduCalendar hinduCalendar, int i, boolean z) {
            if (isValid(hinduCalendar, i)) {
                int i2 = this.index;
                int i3 = 1;
                if (i2 == 0) {
                    int yearOfEra = HinduEra.KALI_YUGA.yearOfEra(hinduCalendar.getEra(), i);
                    if (!hinduCalendar.variant.isUsingElapsedYears()) {
                        yearOfEra--;
                    }
                    if (yearOfEra == hinduCalendar.kyYear) {
                        return hinduCalendar;
                    }
                    int i4 = 15;
                    if (hinduCalendar.variant.isPurnimanta()) {
                        i4 = hinduCalendar.dayOfMonth.getValue() >= 16 ? 29 : 2;
                    }
                    HinduCS calendarSystem = hinduCalendar.variant.getCalendarSystem();
                    HinduMonth access$500 = hinduCalendar.month;
                    boolean isExpunged = calendarSystem.isExpunged(yearOfEra, access$500);
                    if (isExpunged) {
                        IndianMonth value = hinduCalendar.month.getValue();
                        if (yearOfEra > hinduCalendar.kyYear) {
                            i3 = -1;
                        }
                        access$500 = HinduMonth.of(value.roll(i3));
                        if (yearOfEra < hinduCalendar.kyYear) {
                            HinduMonth access$5002 = calendarSystem.create(calendarSystem.create(yearOfEra, access$500, HinduDay.valueOf(i4)).getDaysSinceEpochUTC() - 30).month;
                            if (access$5002.equals(access$500.withLeap())) {
                                access$500 = access$5002;
                            }
                        }
                    }
                    HinduCalendar create = calendarSystem.create(yearOfEra, access$500, HinduDay.valueOf(i4));
                    if (!isExpunged && access$500.isLeap()) {
                        create = calendarSystem.transform(create.utcDays);
                        if (create.month.getValue().getValue() > access$500.getValue().getValue()) {
                            create = calendarSystem.create(create.utcDays - 30);
                        }
                    }
                    return create.withAdjustedDayInMonth(hinduCalendar.dayOfMonth);
                } else if (i2 == 1) {
                    return (HinduCalendar) hinduCalendar.plus(CalendarDays.of((long) (i - getInt(hinduCalendar))));
                } else {
                    throw new UnsupportedOperationException("Unknown element index: " + this.index);
                }
            } else {
                throw new IllegalArgumentException("Out of range: " + i);
            }
        }

        public Integer getValue(HinduCalendar hinduCalendar) {
            return Integer.valueOf(getInt(hinduCalendar));
        }

        public Integer getMinimum(HinduCalendar hinduCalendar) {
            return Integer.valueOf(getMin(hinduCalendar));
        }

        public Integer getMaximum(HinduCalendar hinduCalendar) {
            return Integer.valueOf(getMax(hinduCalendar));
        }

        public boolean isValid(HinduCalendar hinduCalendar, Integer num) {
            return num != null && isValid(hinduCalendar, num.intValue());
        }

        public HinduCalendar withValue(HinduCalendar hinduCalendar, Integer num, boolean z) {
            if (num != null) {
                return withValue(hinduCalendar, num.intValue(), z);
            }
            throw new IllegalArgumentException("Missing new value.");
        }

        public ChronoElement<?> getChildAtFloor(HinduCalendar hinduCalendar) {
            if (this.index == 0) {
                return HinduCalendar.MONTH_OF_YEAR;
            }
            return null;
        }

        public ChronoElement<?> getChildAtCeiling(HinduCalendar hinduCalendar) {
            if (this.index == 0) {
                return HinduCalendar.MONTH_OF_YEAR;
            }
            return null;
        }

        private int getMin(HinduCalendar hinduCalendar) {
            int i = this.index;
            if (i == 0) {
                int i2 = hinduCalendar.variant.isOld() ? 0 : HinduCalendar.MIN_YEAR;
                return hinduCalendar.variant.isUsingElapsedYears() ? i2 : i2 + 1;
            } else if (i == 1) {
                return 1;
            } else {
                throw new UnsupportedOperationException("Unknown element index: " + this.index);
            }
        }

        private int getMax(HinduCalendar hinduCalendar) {
            int i = this.index;
            if (i == 0) {
                return hinduCalendar.getEra().yearOfEra(HinduEra.KALI_YUGA, hinduCalendar.variant.isUsingElapsedYears() ? HinduCalendar.MAX_YEAR : PaymentMethodsActivityStarter.REQUEST_CODE);
            } else if (i == 1) {
                HinduCalendar withNewYear = hinduCalendar.withNewYear();
                return (int) (hinduCalendar.variant.getCalendarSystem().create(withNewYear.utcDays + 400).withNewYear().utcDays - withNewYear.utcDays);
            } else {
                throw new UnsupportedOperationException("Unknown element index: " + this.index);
            }
        }
    }

    private static class MonthElement extends DisplayElement<HinduMonth> implements AdjustableTextElement<HinduMonth>, ElementRule<HinduCalendar, HinduMonth> {
        static final MonthElement SINGLETON = new MonthElement();
        private static final long serialVersionUID = 7462717336727909653L;

        public char getSymbol() {
            return 'M';
        }

        public boolean isDateElement() {
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean isSingleton() {
            return true;
        }

        public boolean isTimeElement() {
            return false;
        }

        private MonthElement() {
            super("MONTH_OF_YEAR");
        }

        public ChronoOperator<HinduCalendar> minimized() {
            return new ChronoOperator<HinduCalendar>() {
                public HinduCalendar apply(HinduCalendar hinduCalendar) {
                    MonthElement monthElement = MonthElement.this;
                    return (HinduCalendar) hinduCalendar.with(monthElement, hinduCalendar.getMinimum(monthElement));
                }
            };
        }

        public ChronoOperator<HinduCalendar> maximized() {
            return new ChronoOperator<HinduCalendar>() {
                public HinduCalendar apply(HinduCalendar hinduCalendar) {
                    MonthElement monthElement = MonthElement.this;
                    return (HinduCalendar) hinduCalendar.with(monthElement, hinduCalendar.getMaximum(monthElement));
                }
            };
        }

        public HinduMonth getValue(HinduCalendar hinduCalendar) {
            return hinduCalendar.month;
        }

        public HinduMonth getMinimum(HinduCalendar hinduCalendar) {
            return hinduCalendar.withNewYear().month;
        }

        public HinduMonth getMaximum(HinduCalendar hinduCalendar) {
            if (hinduCalendar.variant.isSolar()) {
                return HinduMonth.ofSolar(12);
            }
            return hinduCalendar.variant.getCalendarSystem().create(hinduCalendar.withNewYear().utcDays - 20).month;
        }

        public boolean isValid(HinduCalendar hinduCalendar, HinduMonth hinduMonth) {
            if (hinduMonth == null || (hinduMonth.isLeap() && hinduCalendar.variant.isSolar())) {
                return false;
            }
            if (hinduMonth.isLeap()) {
                int i = 0;
                for (HinduCalendar withNewYear = hinduCalendar.withNewYear(); !withNewYear.month.equals(hinduMonth); withNewYear = withNewYear.nextMonth()) {
                    if (!withNewYear.month.isLeap() && (i = i + 1) >= 12) {
                        return false;
                    }
                }
            }
            if (!hinduCalendar.variant.isLunisolar() || hinduCalendar.variant.isOld()) {
                return true;
            }
            return !hinduCalendar.variant.getCalendarSystem().isExpunged(hinduCalendar.kyYear, hinduMonth);
        }

        public HinduCalendar withValue(HinduCalendar hinduCalendar, HinduMonth hinduMonth, boolean z) {
            if (hinduMonth == null || (hinduMonth.isLeap() && hinduCalendar.variant.isSolar())) {
                throw new IllegalArgumentException("Invalid month: " + hinduMonth);
            }
            HinduCalendar withNewYear = hinduCalendar.withNewYear();
            int i = 0;
            while (!withNewYear.month.equals(hinduMonth)) {
                if (withNewYear.month.isLeap() || (i = i + 1) < 12) {
                    withNewYear = withNewYear.nextMonth();
                } else {
                    throw new IllegalArgumentException("Invalid month: " + hinduMonth);
                }
            }
            return withNewYear.withAdjustedDayInMonth(hinduCalendar.dayOfMonth);
        }

        public ChronoElement<?> getChildAtFloor(HinduCalendar hinduCalendar) {
            return HinduCalendar.DAY_OF_MONTH;
        }

        public ChronoElement<?> getChildAtCeiling(HinduCalendar hinduCalendar) {
            return HinduCalendar.DAY_OF_MONTH;
        }

        public Class<HinduMonth> getType() {
            return HinduMonth.class;
        }

        public HinduMonth getDefaultMinimum() {
            return HinduMonth.ofLunisolar(1);
        }

        public HinduMonth getDefaultMaximum() {
            return HinduMonth.ofLunisolar(12);
        }

        /* access modifiers changed from: protected */
        public Object readResolve() throws ObjectStreamException {
            return SINGLETON;
        }

        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
            String str;
            boolean z;
            char c;
            HinduVariant access$900 = HinduCalendar.getVariant(chronoDisplay, attributeQuery);
            Locale locale = (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT);
            int intValue = ((Integer) attributeQuery.get(DualFormatElement.COUNT_OF_PATTERN_SYMBOLS, 0)).intValue();
            HinduMonth hinduMonth = (HinduMonth) chronoDisplay.get(HinduCalendar.MONTH_OF_YEAR);
            if (hinduMonth.isLeap()) {
                Map<String, String> textForms = CalendarText.getInstance("generic", locale).getTextForms();
                z = ((Boolean) attributeQuery.get(HinduPrimitive.ADHIKA_IS_TRAILING, Boolean.valueOf("R".equals(textForms.get("leap-alignment"))))).booleanValue();
                c = ((Character) attributeQuery.get(HinduPrimitive.ADHIKA_INDICATOR, Character.valueOf(textForms.get("leap-indicator").charAt(0)))).charValue();
                str = CalendarText.getInstance("hindu", locale).getTextForms().get("adhika");
            } else {
                c = '*';
                str = "";
                z = false;
            }
            if (intValue != 0) {
                if (hinduMonth.isLeap() && !z) {
                    appendable.append(c);
                }
                int rasi = access$900.isSolar() ? hinduMonth.getRasi() : hinduMonth.getValue().getValue();
                NumberSystem numberSystem = (NumberSystem) attributeQuery.get(Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC);
                char charValue = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, Character.valueOf(numberSystem.getDigits().charAt(0)))).charValue();
                String numeral = DualFormatHelper.toNumeral(numberSystem, charValue, rasi);
                if (access$900.isSolar() && numberSystem.isDecimal()) {
                    for (int length = intValue - numeral.length(); length > 0; length--) {
                        appendable.append(charValue);
                    }
                }
                appendable.append(numeral);
                if (z) {
                    appendable.append(c);
                }
            } else if (!access$900.isSolar() || !((Boolean) attributeQuery.get(HinduMonth.RASI_NAMES, Boolean.valueOf(access$900.prefersRasiNames()))).booleanValue()) {
                TextWidth textWidth = (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE);
                OutputContext outputContext = (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT);
                if (hinduMonth.isLeap() && !z) {
                    if (textWidth == TextWidth.WIDE) {
                        appendable.append(str);
                        appendable.append(' ');
                    } else {
                        appendable.append(c);
                    }
                    hinduMonth = HinduMonth.of(hinduMonth.getValue());
                }
                appendable.append(hinduMonth.getDisplayName(locale, textWidth, outputContext));
                if (!z) {
                    return;
                }
                if (textWidth == TextWidth.WIDE) {
                    appendable.append(' ');
                    appendable.append(str);
                    return;
                }
                appendable.append(c);
            } else {
                appendable.append(hinduMonth.getRasi(locale));
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x00e1  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00e5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.calendar.hindu.HinduMonth parse(java.lang.CharSequence r24, java.text.ParsePosition r25, net.time4j.engine.AttributeQuery r26) {
            /*
                r23 = this;
                r7 = r24
                r8 = r25
                r9 = r26
                int r10 = r25.getIndex()
                int r11 = r24.length()
                r12 = 0
                if (r10 < r11) goto L_0x0015
                r8.setErrorIndex(r10)
                return r12
            L_0x0015:
                net.time4j.calendar.hindu.HinduVariant r0 = net.time4j.calendar.hindu.HinduCalendar.getVariant(r12, r9)
                net.time4j.engine.AttributeKey<java.util.Locale> r1 = net.time4j.format.Attributes.LANGUAGE
                java.util.Locale r2 = java.util.Locale.ROOT
                java.lang.Object r1 = r9.get(r1, r2)
                r13 = r1
                java.util.Locale r13 = (java.util.Locale) r13
                net.time4j.engine.AttributeKey<java.lang.Integer> r1 = net.time4j.format.internal.DualFormatElement.COUNT_OF_PATTERN_SYMBOLS
                r14 = 0
                java.lang.Integer r2 = java.lang.Integer.valueOf(r14)
                java.lang.Object r1 = r9.get(r1, r2)
                java.lang.Integer r1 = (java.lang.Integer) r1
                int r15 = r1.intValue()
                net.time4j.engine.AttributeKey<java.lang.Boolean> r1 = net.time4j.format.Attributes.PARSE_CASE_INSENSITIVE
                java.lang.Boolean r2 = java.lang.Boolean.TRUE
                java.lang.Object r1 = r9.get(r1, r2)
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                boolean r16 = r1.booleanValue()
                r1 = 42
                boolean r17 = r0.isSolar()
                java.lang.String r6 = "hindu"
                java.lang.String r5 = "R"
                r4 = -1
                r3 = 1
                if (r17 != 0) goto L_0x00d1
                java.lang.String r0 = "generic"
                net.time4j.format.CalendarText r0 = net.time4j.format.CalendarText.getInstance((java.lang.String) r0, (java.util.Locale) r13)
                java.util.Map r0 = r0.getTextForms()
                net.time4j.engine.AttributeKey<java.lang.Boolean> r1 = net.time4j.calendar.hindu.HinduPrimitive.ADHIKA_IS_TRAILING
                java.lang.String r2 = "leap-alignment"
                java.lang.Object r2 = r0.get(r2)
                boolean r2 = r5.equals(r2)
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                java.lang.Object r1 = r9.get(r1, r2)
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                boolean r18 = r1.booleanValue()
                net.time4j.engine.AttributeKey<java.lang.Character> r1 = net.time4j.calendar.hindu.HinduPrimitive.ADHIKA_INDICATOR
                java.lang.String r2 = "leap-indicator"
                java.lang.Object r0 = r0.get(r2)
                java.lang.String r0 = (java.lang.String) r0
                char r0 = r0.charAt(r14)
                java.lang.Character r0 = java.lang.Character.valueOf(r0)
                java.lang.Object r0 = r9.get(r1, r0)
                java.lang.Character r0 = (java.lang.Character) r0
                char r19 = r0.charValue()
                net.time4j.format.CalendarText r0 = net.time4j.format.CalendarText.getInstance((java.lang.String) r6, (java.util.Locale) r13)
                java.util.Map r0 = r0.getTextForms()
                java.lang.String r1 = "adhika"
                java.lang.Object r0 = r0.get(r1)
                r20 = r0
                java.lang.String r20 = (java.lang.String) r20
                if (r18 != 0) goto L_0x00c4
                r0 = r24
                r1 = r10
                r2 = r11
                r3 = r16
                r14 = -1
                r4 = r20
                r21 = r5
                r5 = r19
                r22 = r6
                r6 = r13
                int r0 = net.time4j.calendar.hindu.HinduCalendar.parseLeadingLeapInfo(r0, r1, r2, r3, r4, r5, r6)
                if (r0 == r14) goto L_0x00c9
                r1 = r18
                r5 = r19
                r4 = r20
                r18 = 1
                goto L_0x00df
            L_0x00c4:
                r21 = r5
                r22 = r6
                r14 = -1
            L_0x00c9:
                r0 = r10
                r1 = r18
                r5 = r19
                r4 = r20
                goto L_0x00dd
            L_0x00d1:
                r21 = r5
                r22 = r6
                r14 = -1
                java.lang.String r0 = ""
                r4 = r0
                r0 = r10
                r1 = 0
                r5 = 42
            L_0x00dd:
                r18 = 0
            L_0x00df:
                if (r0 < r11) goto L_0x00e5
                r8.setErrorIndex(r10)
                return r12
            L_0x00e5:
                if (r15 != 0) goto L_0x0151
                r8.setIndex(r0)
                net.time4j.engine.AttributeKey<net.time4j.format.TextWidth> r2 = net.time4j.format.Attributes.TEXT_WIDTH
                net.time4j.format.TextWidth r3 = net.time4j.format.TextWidth.WIDE
                java.lang.Object r2 = r9.get(r2, r3)
                net.time4j.format.TextWidth r2 = (net.time4j.format.TextWidth) r2
                net.time4j.engine.AttributeKey<net.time4j.format.OutputContext> r3 = net.time4j.format.Attributes.OUTPUT_CONTEXT
                net.time4j.format.OutputContext r6 = net.time4j.format.OutputContext.FORMAT
                java.lang.Object r3 = r9.get(r3, r6)
                net.time4j.format.OutputContext r3 = (net.time4j.format.OutputContext) r3
                java.lang.String r6 = "indian"
                net.time4j.format.CalendarText r6 = net.time4j.format.CalendarText.getInstance((java.lang.String) r6, (java.util.Locale) r13)
                net.time4j.format.TextAccessor r2 = r6.getStdMonths(r2, r3)
                java.lang.Class<net.time4j.calendar.IndianMonth> r3 = net.time4j.calendar.IndianMonth.class
                java.lang.Enum r2 = r2.parse((java.lang.CharSequence) r7, (java.text.ParsePosition) r8, r3, (net.time4j.engine.AttributeQuery) r9)
                net.time4j.calendar.IndianMonth r2 = (net.time4j.calendar.IndianMonth) r2
                if (r2 != 0) goto L_0x013f
                if (r17 == 0) goto L_0x013f
                r8.setIndex(r0)
                r8.setErrorIndex(r14)
                r0 = r22
                net.time4j.format.CalendarText r0 = net.time4j.format.CalendarText.getInstance((java.lang.String) r0, (java.util.Locale) r13)
                java.lang.Class<net.time4j.calendar.IndianMonth> r2 = net.time4j.calendar.IndianMonth.class
                r3 = 0
                java.lang.String[] r3 = new java.lang.String[r3]
                r6 = r21
                net.time4j.format.TextAccessor r0 = r0.getTextForms(r6, r2, r3)
                java.lang.Class<net.time4j.calendar.IndianMonth> r2 = net.time4j.calendar.IndianMonth.class
                java.lang.Enum r0 = r0.parse((java.lang.CharSequence) r7, (java.text.ParsePosition) r8, r2, (net.time4j.engine.AttributeQuery) r9)
                net.time4j.calendar.IndianMonth r0 = (net.time4j.calendar.IndianMonth) r0
                int r0 = r0.getValue()
                net.time4j.calendar.hindu.HinduMonth r0 = net.time4j.calendar.hindu.HinduMonth.ofSolar(r0)
                net.time4j.calendar.IndianMonth r2 = r0.getValue()
            L_0x013f:
                if (r2 != 0) goto L_0x0145
                r8.setErrorIndex(r10)
                return r12
            L_0x0145:
                net.time4j.calendar.hindu.HinduMonth r0 = net.time4j.calendar.hindu.HinduMonth.of(r2)
                int r2 = r25.getIndex()
                r9 = r0
                r10 = r2
                goto L_0x01d5
            L_0x0151:
                net.time4j.engine.AttributeKey<net.time4j.format.NumberSystem> r2 = net.time4j.format.Attributes.NUMBER_SYSTEM
                net.time4j.format.NumberSystem r3 = net.time4j.format.NumberSystem.ARABIC
                java.lang.Object r2 = r9.get(r2, r3)
                net.time4j.format.NumberSystem r2 = (net.time4j.format.NumberSystem) r2
                net.time4j.engine.AttributeKey<java.lang.Character> r3 = net.time4j.format.Attributes.ZERO_DIGIT
                java.lang.String r6 = r2.getDigits()
                r15 = 0
                char r6 = r6.charAt(r15)
                java.lang.Character r6 = java.lang.Character.valueOf(r6)
                java.lang.Object r3 = r9.get(r3, r6)
                java.lang.Character r3 = (java.lang.Character) r3
                char r3 = r3.charValue()
                if (r17 == 0) goto L_0x0187
                boolean r6 = r2.isDecimal()
                if (r6 == 0) goto L_0x0187
            L_0x017c:
                if (r0 >= r11) goto L_0x0187
                char r6 = r7.charAt(r0)
                if (r6 != r3) goto L_0x0187
                int r0 = r0 + 1
                goto L_0x017c
            L_0x0187:
                r6 = 12
                r6 = 0
                r9 = 12
            L_0x018c:
                r15 = 1
                if (r9 < r15) goto L_0x01c1
                if (r6 != 0) goto L_0x01c1
                java.lang.String r15 = net.time4j.format.internal.DualFormatHelper.toNumeral(r2, r3, r9)
                int r14 = r15.length()
                r21 = r2
                r12 = 0
            L_0x019c:
                int r2 = r0 + r12
                if (r11 <= r2) goto L_0x01ad
                char r2 = r7.charAt(r2)
                r26 = r3
                char r3 = r15.charAt(r12)
                if (r2 == r3) goto L_0x01af
                goto L_0x01b5
            L_0x01ad:
                r26 = r3
            L_0x01af:
                int r12 = r12 + 1
                if (r12 != r14) goto L_0x01be
                int r0 = r0 + r14
                r6 = r9
            L_0x01b5:
                int r9 = r9 + -1
                r3 = r26
                r2 = r21
                r12 = 0
                r14 = -1
                goto L_0x018c
            L_0x01be:
                r3 = r26
                goto L_0x019c
            L_0x01c1:
                if (r6 != 0) goto L_0x01c8
                r8.setErrorIndex(r10)
                r0 = 0
                return r0
            L_0x01c8:
                if (r17 == 0) goto L_0x01cf
                net.time4j.calendar.hindu.HinduMonth r2 = net.time4j.calendar.hindu.HinduMonth.ofSolar(r6)
                goto L_0x01d3
            L_0x01cf:
                net.time4j.calendar.hindu.HinduMonth r2 = net.time4j.calendar.hindu.HinduMonth.ofLunisolar(r6)
            L_0x01d3:
                r10 = r0
                r9 = r2
            L_0x01d5:
                if (r1 == 0) goto L_0x01e8
                r0 = r24
                r1 = r10
                r2 = r11
                r3 = r16
                r6 = r13
                int r0 = net.time4j.calendar.hindu.HinduCalendar.parseTrailingLeapInfo(r0, r1, r2, r3, r4, r5, r6)
                r1 = -1
                if (r0 == r1) goto L_0x01e8
                r10 = r0
                r3 = 1
                goto L_0x01ea
            L_0x01e8:
                r3 = r18
            L_0x01ea:
                if (r3 == 0) goto L_0x01f0
                net.time4j.calendar.hindu.HinduMonth r9 = r9.withLeap()
            L_0x01f0:
                r8.setIndex(r10)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.hindu.HinduCalendar.MonthElement.parse(java.lang.CharSequence, java.text.ParsePosition, net.time4j.engine.AttributeQuery):net.time4j.calendar.hindu.HinduMonth");
        }
    }

    private static class DayOfMonthElement extends DisplayElement<HinduDay> implements AdjustableTextElement<HinduDay>, ElementRule<HinduCalendar, HinduDay> {
        static final DayOfMonthElement SINGLETON = new DayOfMonthElement();
        private static final long serialVersionUID = 992340906349614332L;

        public ChronoElement<?> getChildAtCeiling(HinduCalendar hinduCalendar) {
            return null;
        }

        public ChronoElement<?> getChildAtFloor(HinduCalendar hinduCalendar) {
            return null;
        }

        public char getSymbol() {
            return 'd';
        }

        public boolean isDateElement() {
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean isSingleton() {
            return true;
        }

        public boolean isTimeElement() {
            return false;
        }

        private DayOfMonthElement() {
            super("DAY_OF_MONTH");
        }

        public ChronoOperator<HinduCalendar> minimized() {
            return new ChronoOperator<HinduCalendar>() {
                public HinduCalendar apply(HinduCalendar hinduCalendar) {
                    DayOfMonthElement dayOfMonthElement = DayOfMonthElement.this;
                    return (HinduCalendar) hinduCalendar.with(dayOfMonthElement, hinduCalendar.getMinimum(dayOfMonthElement));
                }
            };
        }

        public ChronoOperator<HinduCalendar> maximized() {
            return new ChronoOperator<HinduCalendar>() {
                public HinduCalendar apply(HinduCalendar hinduCalendar) {
                    DayOfMonthElement dayOfMonthElement = DayOfMonthElement.this;
                    return (HinduCalendar) hinduCalendar.with(dayOfMonthElement, hinduCalendar.getMaximum(dayOfMonthElement));
                }
            };
        }

        public HinduDay getValue(HinduCalendar hinduCalendar) {
            return hinduCalendar.dayOfMonth;
        }

        public HinduDay getMinimum(HinduCalendar hinduCalendar) {
            return hinduCalendar.withFirstDayOfMonth().dayOfMonth;
        }

        public HinduDay getMaximum(HinduCalendar hinduCalendar) {
            return hinduCalendar.variant.getCalendarSystem().create(hinduCalendar.withMidOfMonth(1).withFirstDayOfMonth().utcDays - 1).dayOfMonth;
        }

        public boolean isValid(HinduCalendar hinduCalendar, HinduDay hinduDay) {
            boolean z = false;
            if (hinduDay == null || (hinduDay.isLeap() && hinduCalendar.variant.isSolar())) {
                return false;
            }
            if (hinduCalendar.variant.isPurnimanta() && hinduCalendar.isChaitra() && hinduCalendar.withNewYear().month.equals(hinduCalendar.month)) {
                z = true;
            }
            return hinduCalendar.variant.getCalendarSystem().isValid(hinduCalendar.criticalYear(z, hinduDay), hinduCalendar.month, hinduDay);
        }

        public HinduCalendar withValue(HinduCalendar hinduCalendar, HinduDay hinduDay, boolean z) {
            if (hinduDay != null && (!hinduDay.isLeap() || !hinduCalendar.variant.isSolar())) {
                int access$1400 = hinduCalendar.criticalYear(hinduCalendar.variant.isPurnimanta() && hinduCalendar.isChaitra() && hinduCalendar.withNewYear().month.equals(hinduCalendar.month), hinduDay);
                HinduCS calendarSystem = hinduCalendar.variant.getCalendarSystem();
                if (calendarSystem.isValid(access$1400, hinduCalendar.month, hinduDay)) {
                    return calendarSystem.create(access$1400, hinduCalendar.month, hinduDay);
                }
            }
            throw new IllegalArgumentException("Invalid day of month: " + hinduDay);
        }

        public Class<HinduDay> getType() {
            return HinduDay.class;
        }

        public HinduDay getDefaultMinimum() {
            return HinduDay.valueOf(1);
        }

        public HinduDay getDefaultMaximum() {
            return HinduDay.valueOf(32);
        }

        /* access modifiers changed from: protected */
        public Object readResolve() throws ObjectStreamException {
            return SINGLETON;
        }

        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
            boolean z;
            char c;
            String str;
            HinduVariant access$900 = HinduCalendar.getVariant(chronoDisplay, attributeQuery);
            Locale locale = (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT);
            int intValue = ((Integer) attributeQuery.get(DualFormatElement.COUNT_OF_PATTERN_SYMBOLS, 0)).intValue();
            HinduDay hinduDay = (HinduDay) chronoDisplay.get(HinduCalendar.DAY_OF_MONTH);
            if (hinduDay.isLeap()) {
                Map<String, String> textForms = CalendarText.getInstance("generic", locale).getTextForms();
                z = ((Boolean) attributeQuery.get(HinduPrimitive.ADHIKA_IS_TRAILING, Boolean.valueOf("R".equals(textForms.get("leap-alignment"))))).booleanValue();
                c = ((Character) attributeQuery.get(HinduPrimitive.ADHIKA_INDICATOR, Character.valueOf(textForms.get("leap-indicator").charAt(0)))).charValue();
                str = CalendarText.getInstance("hindu", locale).getTextForms().get("adhika");
            } else {
                c = '*';
                str = "";
                z = false;
            }
            if (hinduDay.isLeap() && !z) {
                if (intValue >= 2) {
                    appendable.append(str);
                    appendable.append(' ');
                } else {
                    appendable.append(c);
                }
            }
            NumberSystem numberSystem = (NumberSystem) attributeQuery.get(Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC);
            char charValue = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, Character.valueOf(numberSystem.getDigits().charAt(0)))).charValue();
            String numeral = DualFormatHelper.toNumeral(numberSystem, charValue, hinduDay.getValue());
            if (access$900.isSolar() && numberSystem.isDecimal()) {
                for (int length = intValue - numeral.length(); length > 0; length--) {
                    appendable.append(charValue);
                }
            }
            appendable.append(numeral);
            if (!z) {
                return;
            }
            if (intValue >= 2) {
                appendable.append(' ');
                appendable.append(str);
                return;
            }
            appendable.append(c);
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x00c1  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x00c6  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.calendar.hindu.HinduDay parse(java.lang.CharSequence r21, java.text.ParsePosition r22, net.time4j.engine.AttributeQuery r23) {
            /*
                r20 = this;
                r7 = r21
                r8 = r22
                r9 = r23
                int r10 = r22.getIndex()
                int r11 = r21.length()
                r12 = 0
                if (r10 < r11) goto L_0x0015
                r8.setErrorIndex(r10)
                return r12
            L_0x0015:
                net.time4j.calendar.hindu.HinduVariant r0 = net.time4j.calendar.hindu.HinduCalendar.getVariant(r12, r9)
                net.time4j.engine.AttributeKey<java.util.Locale> r1 = net.time4j.format.Attributes.LANGUAGE
                java.util.Locale r2 = java.util.Locale.ROOT
                java.lang.Object r1 = r9.get(r1, r2)
                r13 = r1
                java.util.Locale r13 = (java.util.Locale) r13
                net.time4j.engine.AttributeKey<java.lang.Boolean> r1 = net.time4j.format.Attributes.PARSE_CASE_INSENSITIVE
                java.lang.Boolean r2 = java.lang.Boolean.TRUE
                java.lang.Object r1 = r9.get(r1, r2)
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                boolean r14 = r1.booleanValue()
                r1 = 42
                boolean r15 = r0.isSolar()
                r6 = -1
                r5 = 1
                r4 = 0
                if (r15 != 0) goto L_0x00b4
                java.lang.String r0 = "generic"
                net.time4j.format.CalendarText r0 = net.time4j.format.CalendarText.getInstance((java.lang.String) r0, (java.util.Locale) r13)
                java.util.Map r0 = r0.getTextForms()
                net.time4j.engine.AttributeKey<java.lang.Boolean> r1 = net.time4j.calendar.hindu.HinduPrimitive.ADHIKA_IS_TRAILING
                java.lang.String r2 = "leap-alignment"
                java.lang.Object r2 = r0.get(r2)
                java.lang.String r3 = "R"
                boolean r2 = r3.equals(r2)
                java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                java.lang.Object r1 = r9.get(r1, r2)
                java.lang.Boolean r1 = (java.lang.Boolean) r1
                boolean r16 = r1.booleanValue()
                net.time4j.engine.AttributeKey<java.lang.Character> r1 = net.time4j.calendar.hindu.HinduPrimitive.ADHIKA_INDICATOR
                java.lang.String r2 = "leap-indicator"
                java.lang.Object r0 = r0.get(r2)
                java.lang.String r0 = (java.lang.String) r0
                char r0 = r0.charAt(r4)
                java.lang.Character r0 = java.lang.Character.valueOf(r0)
                java.lang.Object r0 = r9.get(r1, r0)
                java.lang.Character r0 = (java.lang.Character) r0
                char r17 = r0.charValue()
                java.lang.String r0 = "hindu"
                net.time4j.format.CalendarText r0 = net.time4j.format.CalendarText.getInstance((java.lang.String) r0, (java.util.Locale) r13)
                java.util.Map r0 = r0.getTextForms()
                java.lang.String r1 = "adhika"
                java.lang.Object r0 = r0.get(r1)
                r18 = r0
                java.lang.String r18 = (java.lang.String) r18
                if (r16 != 0) goto L_0x00ad
                r0 = r21
                r1 = r10
                r2 = r11
                r3 = r14
                r4 = r18
                r5 = r17
                r12 = -1
                r6 = r13
                int r0 = net.time4j.calendar.hindu.HinduCalendar.parseLeadingLeapInfo(r0, r1, r2, r3, r4, r5, r6)
                if (r0 == r12) goto L_0x00ae
                r4 = r16
                r5 = r17
                r16 = 1
                goto L_0x00bf
            L_0x00ad:
                r12 = -1
            L_0x00ae:
                r0 = r10
                r4 = r16
                r5 = r17
                goto L_0x00bd
            L_0x00b4:
                r12 = -1
                java.lang.String r0 = ""
                r18 = r0
                r0 = r10
                r4 = 0
                r5 = 42
            L_0x00bd:
                r16 = 0
            L_0x00bf:
                if (r0 < r11) goto L_0x00c6
                r8.setErrorIndex(r10)
            L_0x00c4:
                r0 = 0
                return r0
            L_0x00c6:
                net.time4j.engine.AttributeKey<net.time4j.format.NumberSystem> r1 = net.time4j.format.Attributes.NUMBER_SYSTEM
                net.time4j.format.NumberSystem r2 = net.time4j.format.NumberSystem.ARABIC
                java.lang.Object r1 = r9.get(r1, r2)
                net.time4j.format.NumberSystem r1 = (net.time4j.format.NumberSystem) r1
                net.time4j.engine.AttributeKey<java.lang.Character> r2 = net.time4j.format.Attributes.ZERO_DIGIT
                java.lang.String r3 = r1.getDigits()
                r6 = 0
                char r3 = r3.charAt(r6)
                java.lang.Character r3 = java.lang.Character.valueOf(r3)
                java.lang.Object r2 = r9.get(r2, r3)
                java.lang.Character r2 = (java.lang.Character) r2
                char r2 = r2.charValue()
                if (r15 == 0) goto L_0x00fc
                boolean r3 = r1.isDecimal()
                if (r3 == 0) goto L_0x00fc
            L_0x00f1:
                if (r0 >= r11) goto L_0x00fc
                char r3 = r7.charAt(r0)
                if (r3 != r2) goto L_0x00fc
                int r0 = r0 + 1
                goto L_0x00f1
            L_0x00fc:
                if (r15 == 0) goto L_0x0101
                r3 = 32
                goto L_0x0103
            L_0x0101:
                r3 = 30
            L_0x0103:
                r9 = r0
                r0 = 0
            L_0x0105:
                r15 = 1
                if (r3 < r15) goto L_0x013a
                if (r0 != 0) goto L_0x013a
                java.lang.String r6 = net.time4j.format.internal.DualFormatHelper.toNumeral(r1, r2, r3)
                int r15 = r6.length()
                r19 = r1
                r12 = 0
            L_0x0115:
                int r1 = r9 + r12
                if (r11 <= r1) goto L_0x0126
                char r1 = r7.charAt(r1)
                r23 = r2
                char r2 = r6.charAt(r12)
                if (r1 == r2) goto L_0x0128
                goto L_0x012e
            L_0x0126:
                r23 = r2
            L_0x0128:
                int r12 = r12 + 1
                if (r12 != r15) goto L_0x0137
                int r9 = r9 + r15
                r0 = r3
            L_0x012e:
                int r3 = r3 + -1
                r2 = r23
                r1 = r19
                r6 = 0
                r12 = -1
                goto L_0x0105
            L_0x0137:
                r2 = r23
                goto L_0x0115
            L_0x013a:
                if (r0 != 0) goto L_0x0140
                r8.setErrorIndex(r10)
                goto L_0x00c4
            L_0x0140:
                net.time4j.calendar.hindu.HinduDay r10 = net.time4j.calendar.hindu.HinduDay.valueOf(r0)
                if (r4 == 0) goto L_0x0158
                r0 = r21
                r1 = r9
                r2 = r11
                r3 = r14
                r4 = r18
                r6 = r13
                int r0 = net.time4j.calendar.hindu.HinduCalendar.parseTrailingLeapInfo(r0, r1, r2, r3, r4, r5, r6)
                r1 = -1
                if (r0 == r1) goto L_0x0158
                r9 = r0
                r5 = 1
                goto L_0x015a
            L_0x0158:
                r5 = r16
            L_0x015a:
                if (r5 == 0) goto L_0x0160
                net.time4j.calendar.hindu.HinduDay r10 = r10.withLeap()
            L_0x0160:
                r8.setIndex(r9)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.hindu.HinduCalendar.DayOfMonthElement.parse(java.lang.CharSequence, java.text.ParsePosition, net.time4j.engine.AttributeQuery):net.time4j.calendar.hindu.HinduDay");
        }
    }

    private static class Merger implements ChronoMerger<HinduCalendar> {
        public int getDefaultPivotYear() {
            return 100;
        }

        public ChronoDisplay preformat(HinduCalendar hinduCalendar, AttributeQuery attributeQuery) {
            return hinduCalendar;
        }

        public Chronology<?> preparser() {
            return null;
        }

        private Merger() {
        }

        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            return IndianCalendar.axis().getFormatPattern(displayStyle, locale);
        }

        /* JADX WARNING: type inference failed for: r10v0, types: [net.time4j.base.TimeSource, net.time4j.base.TimeSource<?>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.calendar.hindu.HinduCalendar createFrom(net.time4j.base.TimeSource<?> r10, net.time4j.engine.AttributeQuery r11) {
            /*
                r9 = this;
                net.time4j.engine.AttributeKey<java.lang.String> r0 = net.time4j.format.Attributes.CALENDAR_VARIANT
                java.lang.String r1 = ""
                java.lang.Object r0 = r11.get(r0, r1)
                java.lang.String r0 = (java.lang.String) r0
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L_0x0012
                r10 = 0
                return r10
            L_0x0012:
                net.time4j.calendar.hindu.HinduVariant r1 = net.time4j.calendar.hindu.HinduVariant.from(r0)
                net.time4j.calendar.astro.GeoLocation r2 = r1.getLocation()
                net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r3 = net.time4j.format.Attributes.TIMEZONE_ID
                boolean r3 = r11.contains(r3)
                if (r3 == 0) goto L_0x002b
                net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r1 = net.time4j.format.Attributes.TIMEZONE_ID
                java.lang.Object r1 = r11.get(r1)
                net.time4j.tz.TZID r1 = (net.time4j.tz.TZID) r1
                goto L_0x003b
            L_0x002b:
                net.time4j.calendar.astro.GeoLocation r1 = r1.getLocation()
                double r3 = r1.getLongitude()
                java.math.BigDecimal r1 = java.math.BigDecimal.valueOf(r3)
                net.time4j.tz.ZonalOffset r1 = net.time4j.tz.ZonalOffset.atLongitude(r1)
            L_0x003b:
                double r3 = r2.getLatitude()
                double r5 = r2.getLongitude()
                int r7 = r2.getAltitude()
                net.time4j.calendar.astro.StdSolarCalculator r8 = net.time4j.calendar.astro.StdSolarCalculator.CC
                net.time4j.calendar.astro.SolarTime r2 = net.time4j.calendar.astro.SolarTime.ofLocation((double) r3, (double) r5, (int) r7, (net.time4j.calendar.astro.SolarTime.Calculator) r8)
                net.time4j.engine.ChronoFunction r2 = r2.sunrise()
                net.time4j.engine.StartOfDay r2 = net.time4j.engine.StartOfDay.definedBy(r2)
                net.time4j.engine.AttributeKey<net.time4j.engine.StartOfDay> r3 = net.time4j.format.Attributes.START_OF_DAY
                java.lang.Object r11 = r11.get(r3, r2)
                net.time4j.engine.StartOfDay r11 = (net.time4j.engine.StartOfDay) r11
                net.time4j.base.UnixTime r10 = r10.currentTime()
                net.time4j.Moment r10 = net.time4j.Moment.from(r10)
                net.time4j.engine.CalendarFamily r2 = net.time4j.calendar.hindu.HinduCalendar.ENGINE
                net.time4j.GeneralTimestamp r10 = r10.toGeneralTimestamp(r2, r0, r1, r11)
                java.lang.Object r10 = r10.toDate()
                net.time4j.calendar.hindu.HinduCalendar r10 = (net.time4j.calendar.hindu.HinduCalendar) r10
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.hindu.HinduCalendar.Merger.createFrom(net.time4j.base.TimeSource, net.time4j.engine.AttributeQuery):net.time4j.calendar.hindu.HinduCalendar");
        }

        public HinduCalendar createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            String str = (String) attributeQuery.get(Attributes.CALENDAR_VARIANT, "");
            if (str.isEmpty()) {
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Missing Hindu calendar variant.");
                return null;
            }
            try {
                HinduVariant from = HinduVariant.from(str);
                HinduCS calendarSystem = from.getCalendarSystem();
                HinduEra defaultEra = from.getDefaultEra();
                if (chronoEntity.contains(HinduCalendar.ERA)) {
                    defaultEra = (HinduEra) chronoEntity.get((ChronoElement<V>) HinduCalendar.ERA);
                }
                int i = chronoEntity.getInt(HinduCalendar.YEAR_OF_ERA);
                if (i == Integer.MIN_VALUE) {
                    chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Missing Hindu year.");
                    return null;
                }
                int yearOfEra = HinduEra.KALI_YUGA.yearOfEra(defaultEra, i);
                if (!from.isUsingElapsedYears()) {
                    yearOfEra--;
                }
                if (!chronoEntity.contains(HinduCalendar.MONTH_OF_YEAR) || !chronoEntity.contains(HinduCalendar.DAY_OF_MONTH)) {
                    int i2 = chronoEntity.getInt(HinduCalendar.DAY_OF_YEAR);
                    if (i2 != Integer.MIN_VALUE) {
                        if (i2 >= 1) {
                            long access$700 = (calendarSystem.create(calendarSystem.create(yearOfEra, HinduMonth.of(IndianMonth.AGRAHAYANA), HinduDay.valueOf(1)).utcDays).withNewYear().utcDays + ((long) i2)) - 1;
                            HinduCalendar create = calendarSystem.create(access$700);
                            if (calendarSystem.getMinimumSinceUTC() <= access$700 && calendarSystem.getMaximumSinceUTC() >= access$700 && (z || create.kyYear == yearOfEra)) {
                                return create;
                            }
                        }
                        chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Invalid Hindu date.");
                    }
                } else {
                    HinduMonth hinduMonth = (HinduMonth) chronoEntity.get((ChronoElement<V>) HinduCalendar.MONTH_OF_YEAR);
                    HinduDay hinduDay = (HinduDay) chronoEntity.get((ChronoElement<V>) HinduCalendar.DAY_OF_MONTH);
                    if (calendarSystem.isValid(yearOfEra, hinduMonth, hinduDay)) {
                        return calendarSystem.create(yearOfEra, hinduMonth, hinduDay);
                    }
                    chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Invalid Hindu date.");
                }
                return null;
            } catch (IllegalArgumentException unused) {
                chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, "Invalid Hindu calendar variant.");
                return null;
            }
        }

        public StartOfDay getDefaultStartOfDay() {
            return StartOfDay.definedBy(SolarTime.ofLocation(HinduVariant.UJJAIN.getLatitude(), HinduVariant.UJJAIN.getLongitude()).sunrise());
        }
    }
}
