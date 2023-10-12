package net.time4j;

import androidx.compose.animation.core.AnimationKt;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.base.MathUtils;
import net.time4j.base.ResourceLoader;
import net.time4j.base.TimeSource;
import net.time4j.base.UnixTime;
import net.time4j.engine.TimeSpan;
import net.time4j.format.NumberSymbolProvider;
import net.time4j.format.NumberSystem;
import net.time4j.format.NumberType;
import net.time4j.format.PluralCategory;
import net.time4j.format.PluralRules;
import net.time4j.format.TemporalFormatter;
import net.time4j.format.TextWidth;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;

public final class PrettyTime {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ConcurrentMap<Locale, PrettyTime> LANGUAGE_MAP = new ConcurrentHashMap();
    private static final int MIO = 1000000;
    private static final NumberSymbolProvider NUMBER_SYMBOLS;
    private static final long START_1972 = 63072000;
    private static final IsoUnit[] STD_UNITS;
    private static final Set<IsoUnit> SUPPORTED_UNITS;
    private static final IsoUnit[] TSP_UNITS = {CalendarUnit.YEARS, CalendarUnit.MONTHS, CalendarUnit.DAYS, ClockUnit.HOURS, ClockUnit.MINUTES, ClockUnit.SECONDS};
    private final IsoUnit emptyUnit;
    private final String endListSeparator;
    private final Locale locale;
    private final String minusSign;
    private final TimeSource<?> refClock;
    private final PluralRules rules;
    private final boolean shortStyle;
    private final String stdListSeparator;
    private final boolean weekToDays;
    private final char zeroDigit;

    static {
        NumberSymbolProvider numberSymbolProvider = null;
        int i = 0;
        for (S s : ResourceLoader.getInstance().services(NumberSymbolProvider.class)) {
            int length = s.getAvailableLocales().length;
            if (length >= i) {
                numberSymbolProvider = s;
                i = length;
            }
        }
        if (numberSymbolProvider == null) {
            numberSymbolProvider = NumberSymbolProvider.DEFAULT;
        }
        NUMBER_SYMBOLS = numberSymbolProvider;
        IsoUnit[] isoUnitArr = {CalendarUnit.YEARS, CalendarUnit.MONTHS, CalendarUnit.WEEKS, CalendarUnit.DAYS, ClockUnit.HOURS, ClockUnit.MINUTES, ClockUnit.SECONDS};
        STD_UNITS = isoUnitArr;
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, isoUnitArr);
        hashSet.add(ClockUnit.NANOS);
        SUPPORTED_UNITS = Collections.unmodifiableSet(hashSet);
    }

    private PrettyTime(Locale locale2, TimeSource<?> timeSource, char c, String str, IsoUnit isoUnit, boolean z, boolean z2, String str2, String str3) {
        Objects.requireNonNull(isoUnit, "Missing zero time unit.");
        Objects.requireNonNull(timeSource, "Missing reference clock.");
        this.rules = PluralRules.of(locale2, NumberType.CARDINALS);
        this.locale = locale2;
        this.refClock = timeSource;
        this.zeroDigit = c;
        this.emptyUnit = isoUnit;
        this.minusSign = str;
        this.weekToDays = z;
        this.shortStyle = z2;
        this.stdListSeparator = str2;
        this.endListSeparator = str3;
    }

    public static PrettyTime of(Locale locale2) {
        ConcurrentMap<Locale, PrettyTime> concurrentMap = LANGUAGE_MAP;
        PrettyTime prettyTime = (PrettyTime) concurrentMap.get(locale2);
        if (prettyTime != null) {
            return prettyTime;
        }
        SystemClock systemClock = SystemClock.INSTANCE;
        NumberSymbolProvider numberSymbolProvider = NUMBER_SYMBOLS;
        PrettyTime prettyTime2 = new PrettyTime(locale2, systemClock, numberSymbolProvider.getZeroDigit(locale2), numberSymbolProvider.getMinusSign(locale2), ClockUnit.SECONDS, false, false, (String) null, (String) null);
        PrettyTime putIfAbsent = concurrentMap.putIfAbsent(locale2, prettyTime2);
        return putIfAbsent != null ? putIfAbsent : prettyTime2;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public TimeSource<?> getReferenceClock() {
        return this.refClock;
    }

    public PrettyTime withReferenceClock(TimeSource<?> timeSource) {
        return new PrettyTime(this.locale, timeSource, this.zeroDigit, this.minusSign, this.emptyUnit, this.weekToDays, this.shortStyle, this.stdListSeparator, this.endListSeparator);
    }

    public PrettyTime withZeroDigit(NumberSystem numberSystem) {
        if (numberSystem.isDecimal()) {
            return withZeroDigit(numberSystem.getDigits().charAt(0));
        }
        throw new IllegalArgumentException("Number system is not decimal: " + numberSystem);
    }

    public PrettyTime withZeroDigit(char c) {
        if (this.zeroDigit == c) {
            return this;
        }
        return new PrettyTime(this.locale, this.refClock, c, this.minusSign, this.emptyUnit, this.weekToDays, this.shortStyle, this.stdListSeparator, this.endListSeparator);
    }

    public PrettyTime withMinusSign(String str) {
        if (str.equals(this.minusSign)) {
            return this;
        }
        return new PrettyTime(this.locale, this.refClock, this.zeroDigit, str, this.emptyUnit, this.weekToDays, this.shortStyle, this.stdListSeparator, this.endListSeparator);
    }

    public PrettyTime withEmptyUnit(CalendarUnit calendarUnit) {
        if (this.emptyUnit.equals(calendarUnit)) {
            return this;
        }
        return new PrettyTime(this.locale, this.refClock, this.zeroDigit, this.minusSign, calendarUnit, this.weekToDays, this.shortStyle, this.stdListSeparator, this.endListSeparator);
    }

    public PrettyTime withEmptyUnit(ClockUnit clockUnit) {
        if (this.emptyUnit.equals(clockUnit)) {
            return this;
        }
        return new PrettyTime(this.locale, this.refClock, this.zeroDigit, this.minusSign, clockUnit, this.weekToDays, this.shortStyle, this.stdListSeparator, this.endListSeparator);
    }

    public PrettyTime withWeeksToDays() {
        if (this.weekToDays) {
            return this;
        }
        return new PrettyTime(this.locale, this.refClock, this.zeroDigit, this.minusSign, this.emptyUnit, true, this.shortStyle, this.stdListSeparator, this.endListSeparator);
    }

    public PrettyTime withShortStyle() {
        if (this.shortStyle) {
            return this;
        }
        return new PrettyTime(this.locale, this.refClock, this.zeroDigit, this.minusSign, this.emptyUnit, this.weekToDays, true, this.stdListSeparator, this.endListSeparator);
    }

    public PrettyTime withDefaultListSeparator(String str) {
        if (str.equals(this.stdListSeparator)) {
            return this;
        }
        return new PrettyTime(this.locale, this.refClock, this.zeroDigit, this.minusSign, this.emptyUnit, this.weekToDays, this.shortStyle, str, this.endListSeparator);
    }

    public PrettyTime withLastListSeparator(String str) {
        if (str.equals(this.endListSeparator)) {
            return this;
        }
        return new PrettyTime(this.locale, this.refClock, this.zeroDigit, this.minusSign, this.emptyUnit, this.weekToDays, this.shortStyle, this.stdListSeparator, str);
    }

    public String printYesterday() {
        return UnitPatterns.of(getLocale()).getYesterdayWord();
    }

    public String printToday() {
        return UnitPatterns.of(getLocale()).getTodayWord();
    }

    public String printTomorrow() {
        return UnitPatterns.of(getLocale()).getTomorrowWord();
    }

    public String printLast(Weekday weekday) {
        return UnitPatterns.of(getLocale()).labelForLast(weekday);
    }

    public String printNext(Weekday weekday) {
        return UnitPatterns.of(getLocale()).labelForNext(weekday);
    }

    public String print(long j, CalendarUnit calendarUnit, TextWidth textWidth) {
        CalendarUnit calendarUnit2;
        UnitPatterns of = UnitPatterns.of(this.locale);
        switch (AnonymousClass1.$SwitchMap$net$time4j$CalendarUnit[calendarUnit.ordinal()]) {
            case 1:
                j = MathUtils.safeMultiply(j, 1000);
                calendarUnit2 = CalendarUnit.YEARS;
                break;
            case 2:
                j = MathUtils.safeMultiply(j, 100);
                calendarUnit2 = CalendarUnit.YEARS;
                break;
            case 3:
                j = MathUtils.safeMultiply(j, 10);
                calendarUnit2 = CalendarUnit.YEARS;
                break;
            case 4:
                calendarUnit2 = CalendarUnit.YEARS;
                break;
            case 5:
                j = MathUtils.safeMultiply(j, 3);
                calendarUnit2 = CalendarUnit.MONTHS;
                break;
            case 6:
                calendarUnit2 = CalendarUnit.MONTHS;
                break;
            case 7:
                if (!this.weekToDays) {
                    calendarUnit2 = CalendarUnit.WEEKS;
                    break;
                } else {
                    j = MathUtils.safeMultiply(j, 7);
                    calendarUnit2 = CalendarUnit.DAYS;
                    break;
                }
            case 8:
                calendarUnit2 = CalendarUnit.DAYS;
                break;
            default:
                throw new UnsupportedOperationException(calendarUnit.name());
        }
        return format(of.getPattern(textWidth, getCategory(j), calendarUnit2), j);
    }

    public String print(long j, ClockUnit clockUnit, TextWidth textWidth) {
        return format(UnitPatterns.of(this.locale).getPattern(textWidth, getCategory(j), clockUnit), j);
    }

    public String print(Duration<?> duration) {
        return print(duration, this.shortStyle ? TextWidth.ABBREVIATED : TextWidth.WIDE, false, Integer.MAX_VALUE);
    }

    public String print(Duration<?> duration, TextWidth textWidth) {
        return print(duration, textWidth, false, Integer.MAX_VALUE);
    }

    public String print(Duration<?> duration, TextWidth textWidth, boolean z, int i) {
        String str;
        int i2;
        TextWidth textWidth2 = textWidth;
        int i3 = i;
        if (i3 >= 1) {
            long j = 0;
            if (!duration.isEmpty()) {
                boolean isNegative = duration.isNegative();
                long[] jArr = new long[8];
                pushDuration(jArr, duration, this.refClock, this.weekToDays);
                ArrayList arrayList = new ArrayList();
                int i4 = 0;
                int i5 = 0;
                for (int i6 = 8; i5 < i6; i6 = 8) {
                    if (i4 >= i3 || ((this.weekToDays && i5 == 2) || ((!z || i4 <= 0) && jArr[i5] <= j))) {
                        i2 = i5;
                        i4 = i4;
                    } else {
                        i2 = i5;
                        arrayList.add(format(jArr[i5], i5 == 7 ? ClockUnit.NANOS : STD_UNITS[i5], isNegative, textWidth));
                        i4++;
                    }
                    i5 = i2 + 1;
                    j = 0;
                }
                int i7 = i4;
                if (i7 == 1) {
                    return arrayList.get(0).toString();
                }
                String str2 = this.stdListSeparator;
                if (str2 != null) {
                    String str3 = this.endListSeparator;
                    if (str3 != null) {
                        str2 = str3;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("{0}");
                    int i8 = i7 - 1;
                    for (int i9 = 1; i9 < i8; i9++) {
                        sb.append(this.stdListSeparator);
                        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
                        sb.append(i9);
                        sb.append(AbstractJsonLexerKt.END_OBJ);
                    }
                    sb.append(str2);
                    sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
                    sb.append(i8);
                    sb.append(AbstractJsonLexerKt.END_OBJ);
                    str = sb.toString();
                } else {
                    str = UnitPatterns.of(this.locale).getListPattern(textWidth2, i7);
                }
                return MessageFormat.format(str, arrayList.toArray(new Object[i7]));
            } else if (this.emptyUnit.isCalendrical()) {
                return print(0, CalendarUnit.class.cast(this.emptyUnit), textWidth2);
            } else {
                return print(0, ClockUnit.class.cast(this.emptyUnit), textWidth2);
            }
        } else {
            throw new IllegalArgumentException("Max length is invalid: " + i3);
        }
    }

    public String printRelativeInStdTimezone(UnixTime unixTime) {
        return printRelative(unixTime, Timezone.ofSystem(), TimeUnit.SECONDS);
    }

    public String printRelative(UnixTime unixTime, TZID tzid) {
        return printRelative(unixTime, Timezone.of(tzid), TimeUnit.SECONDS);
    }

    public String printRelative(UnixTime unixTime, String str) {
        return printRelative(unixTime, Timezone.of(str), TimeUnit.SECONDS);
    }

    public String printRelative(UnixTime unixTime, Timezone timezone, TimeUnit timeUnit) {
        Moment from = Moment.from(getReferenceClock().currentTime());
        Moment from2 = Moment.from(unixTime);
        if (timeUnit.compareTo(TimeUnit.SECONDS) <= 0) {
            long until = from.until(from2, TimeUnit.SECONDS);
            if (Math.abs(until) < 60) {
                return printRelativeSeconds(from, from2, until);
            }
        }
        return printRelativeTime(from, from2, timezone, timeUnit, (CalendarUnit) null, (TemporalFormatter<Moment>) null);
    }

    public String printRelativeOrDateTime(UnixTime unixTime, Timezone timezone, TimeUnit timeUnit, long j, TemporalFormatter<Moment> temporalFormatter) {
        Moment from = Moment.from(getReferenceClock().currentTime());
        Moment from2 = Moment.from(unixTime);
        long until = from.until(from2, TimeUnit.SECONDS);
        if (Math.abs(until) > j) {
            return temporalFormatter.format(from2);
        }
        if (timeUnit.compareTo(TimeUnit.SECONDS) > 0 || Math.abs(until) >= 60) {
            return printRelativeTime(from, from2, timezone, timeUnit, (CalendarUnit) null, (TemporalFormatter<Moment>) null);
        }
        return printRelativeSeconds(from, from2, until);
    }

    public String printRelativeOrDateTime(UnixTime unixTime, Timezone timezone, TimeUnit timeUnit, CalendarUnit calendarUnit, TemporalFormatter<Moment> temporalFormatter) {
        Objects.requireNonNull(calendarUnit, "Missing max relative unit.");
        Moment from = Moment.from(getReferenceClock().currentTime());
        Moment from2 = Moment.from(unixTime);
        long until = from.until(from2, TimeUnit.SECONDS);
        if (timeUnit.compareTo(TimeUnit.SECONDS) > 0 || Math.abs(until) >= 60) {
            return printRelativeTime(from, from2, timezone, timeUnit, calendarUnit, temporalFormatter);
        }
        return printRelativeSeconds(from, from2, until);
    }

    public String printRelativeOrDate(PlainDate plainDate, TZID tzid, CalendarUnit calendarUnit, TemporalFormatter<PlainDate> temporalFormatter) {
        Duration duration;
        String str;
        Objects.requireNonNull(calendarUnit, "Missing max relative unit.");
        PlainDate date = Moment.from(getReferenceClock().currentTime()).toZonalTimestamp(tzid).toDate();
        if (this.weekToDays) {
            duration = Duration.inYearsMonthsDays().between(date, plainDate);
        } else {
            duration = (Duration) Duration.in((U[]) new CalendarUnit[]{CalendarUnit.YEARS, CalendarUnit.MONTHS, CalendarUnit.WEEKS, CalendarUnit.DAYS}).between(date, plainDate);
        }
        if (duration.isEmpty()) {
            return getEmptyRelativeString(TimeUnit.DAYS);
        }
        TimeSpan.Item item = (TimeSpan.Item) duration.getTotalLength().get(0);
        long amount = item.getAmount();
        CalendarUnit calendarUnit2 = (CalendarUnit) item.getUnit();
        if (Double.compare(calendarUnit2.getLength(), calendarUnit.getLength()) > 0) {
            return temporalFormatter.format(plainDate);
        }
        if (calendarUnit2.equals(CalendarUnit.DAYS)) {
            String relativeReplacement = getRelativeReplacement(plainDate, duration.isNegative(), amount);
            if (!relativeReplacement.isEmpty()) {
                return relativeReplacement;
            }
        }
        if (duration.isNegative()) {
            str = getPastPattern(amount, calendarUnit2);
        } else {
            str = getFuturePattern(amount, calendarUnit2);
        }
        return format(str, amount);
    }

    private String printRelativeSeconds(Moment moment, Moment moment2, long j) {
        String str;
        long posixTime = moment.getPosixTime();
        long j2 = START_1972;
        if (posixTime >= j2 && moment2.getPosixTime() >= j2) {
            j = SI.SECONDS.between(moment, moment2);
        }
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return UnitPatterns.of(this.locale).getNowWord();
        }
        long abs = Math.abs(j);
        if (i < 0) {
            str = getPastPattern(abs, ClockUnit.SECONDS);
        } else {
            str = getFuturePattern(abs, ClockUnit.SECONDS);
        }
        return format(str, abs);
    }

    private String printRelativeTime(Moment moment, Moment moment2, Timezone timezone, TimeUnit timeUnit, CalendarUnit calendarUnit, TemporalFormatter<Moment> temporalFormatter) {
        String str;
        PlainTimestamp from = PlainTimestamp.from(moment, timezone.getOffset(moment));
        PlainTimestamp from2 = PlainTimestamp.from(moment2, timezone.getOffset(moment2));
        Duration between = Duration.in(timezone, this.weekToDays ? TSP_UNITS : STD_UNITS).between(from, from2);
        if (between.isEmpty()) {
            return getEmptyRelativeString(timeUnit);
        }
        TimeSpan.Item item = (TimeSpan.Item) between.getTotalLength().get(0);
        long amount = item.getAmount();
        IsoUnit isoUnit = (IsoUnit) item.getUnit();
        if (isoUnit instanceof ClockUnit) {
            if (5 - ((ClockUnit) isoUnit).ordinal() < timeUnit.ordinal()) {
                return getEmptyRelativeString(timeUnit);
            }
        } else if (calendarUnit != null && Double.compare(isoUnit.getLength(), calendarUnit.getLength()) > 0) {
            return temporalFormatter.format(moment2);
        } else {
            if (isoUnit.equals(CalendarUnit.DAYS)) {
                String relativeReplacement = getRelativeReplacement(from2.toDate(), between.isNegative(), amount);
                if (!relativeReplacement.isEmpty()) {
                    return relativeReplacement;
                }
            }
        }
        if (between.isNegative()) {
            if (isoUnit.isCalendrical()) {
                str = getPastPattern(amount, (CalendarUnit) isoUnit);
            } else {
                str = getPastPattern(amount, (ClockUnit) isoUnit);
            }
        } else if (isoUnit.isCalendrical()) {
            str = getFuturePattern(amount, (CalendarUnit) isoUnit);
        } else {
            str = getFuturePattern(amount, (ClockUnit) isoUnit);
        }
        return format(str, amount);
    }

    private String getRelativeReplacement(PlainDate plainDate, boolean z, long j) {
        int i = (j > 1 ? 1 : (j == 1 ? 0 : -1));
        if (i < 0 || j > 7) {
            return "";
        }
        UnitPatterns of = UnitPatterns.of(this.locale);
        if (i == 0) {
            return z ? of.getYesterdayWord() : of.getTomorrowWord();
        }
        Weekday dayOfWeek = plainDate.getDayOfWeek();
        return z ? of.labelForLast(dayOfWeek) : of.labelForNext(dayOfWeek);
    }

    private String getEmptyRelativeString(TimeUnit timeUnit) {
        UnitPatterns of = UnitPatterns.of(this.locale);
        if (timeUnit.equals(TimeUnit.DAYS)) {
            String todayWord = of.getTodayWord();
            if (!todayWord.isEmpty()) {
                return todayWord;
            }
        }
        return of.getNowWord();
    }

    private String getPastPattern(long j, CalendarUnit calendarUnit) {
        return UnitPatterns.of(this.locale).getPatternInPast(getCategory(j), this.shortStyle, calendarUnit);
    }

    private String getFuturePattern(long j, CalendarUnit calendarUnit) {
        return UnitPatterns.of(this.locale).getPatternInFuture(getCategory(j), this.shortStyle, calendarUnit);
    }

    private String getPastPattern(long j, ClockUnit clockUnit) {
        return UnitPatterns.of(this.locale).getPatternInPast(getCategory(j), this.shortStyle, clockUnit);
    }

    private String getFuturePattern(long j, ClockUnit clockUnit) {
        return UnitPatterns.of(this.locale).getPatternInFuture(getCategory(j), this.shortStyle, clockUnit);
    }

    private PluralCategory getCategory(long j) {
        return this.rules.getCategory(Math.abs(j));
    }

    /* JADX WARNING: type inference failed for: r10v0, types: [net.time4j.base.TimeSource, net.time4j.base.TimeSource<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void pushDuration(long[] r8, net.time4j.Duration<?> r9, net.time4j.base.TimeSource<?> r10, boolean r11) {
        /*
            java.util.List r0 = r9.getTotalLength()
            int r0 = r0.size()
            r1 = 0
            r2 = 0
        L_0x000a:
            if (r2 >= r0) goto L_0x0093
            java.util.List r3 = r9.getTotalLength()
            java.lang.Object r3 = r3.get(r2)
            net.time4j.engine.TimeSpan$Item r3 = (net.time4j.engine.TimeSpan.Item) r3
            java.lang.Object r4 = r3.getUnit()
            net.time4j.IsoUnit r4 = (net.time4j.IsoUnit) r4
            long r5 = r3.getAmount()
            boolean r3 = r4 instanceof net.time4j.CalendarUnit
            if (r3 == 0) goto L_0x0030
            java.lang.Class<net.time4j.CalendarUnit> r3 = net.time4j.CalendarUnit.class
            java.lang.Object r3 = r3.cast(r4)
            net.time4j.CalendarUnit r3 = (net.time4j.CalendarUnit) r3
            push(r8, r3, r5, r11)
            goto L_0x008f
        L_0x0030:
            boolean r3 = r4 instanceof net.time4j.ClockUnit
            if (r3 == 0) goto L_0x0040
            java.lang.Class<net.time4j.ClockUnit> r3 = net.time4j.ClockUnit.class
            java.lang.Object r3 = r3.cast(r4)
            net.time4j.ClockUnit r3 = (net.time4j.ClockUnit) r3
            push(r8, r3, r5)
            goto L_0x008f
        L_0x0040:
            boolean r3 = r4 instanceof net.time4j.OverflowUnit
            if (r3 == 0) goto L_0x0054
            java.lang.Class<net.time4j.OverflowUnit> r3 = net.time4j.OverflowUnit.class
            java.lang.Object r3 = r3.cast(r4)
            net.time4j.OverflowUnit r3 = (net.time4j.OverflowUnit) r3
            net.time4j.CalendarUnit r3 = r3.getCalendarUnit()
            push(r8, r3, r5, r11)
            goto L_0x008f
        L_0x0054:
            net.time4j.IsoDateUnit r3 = net.time4j.CalendarUnit.weekBasedYears()
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x0067
            r3 = r8[r1]
            long r3 = net.time4j.base.MathUtils.safeAdd((long) r5, (long) r3)
            r8[r1] = r3
            goto L_0x008f
        L_0x0067:
            net.time4j.base.UnixTime r3 = r10.currentTime()
            net.time4j.Moment r3 = net.time4j.Moment.from(r3)
            net.time4j.tz.ZonalOffset r7 = net.time4j.tz.ZonalOffset.UTC
            net.time4j.PlainTimestamp r3 = r3.toZonalTimestamp((net.time4j.tz.TZID) r7)
            net.time4j.engine.TimePoint r4 = r3.plus(r5, r4)
            net.time4j.PlainTimestamp r4 = (net.time4j.PlainTimestamp) r4
            if (r11 == 0) goto L_0x0080
            net.time4j.IsoUnit[] r5 = TSP_UNITS
            goto L_0x0082
        L_0x0080:
            net.time4j.IsoUnit[] r5 = STD_UNITS
        L_0x0082:
            net.time4j.engine.TimeMetric r5 = net.time4j.Duration.in((U[]) r5)
            java.lang.Object r3 = r5.between(r3, r4)
            net.time4j.Duration r3 = (net.time4j.Duration) r3
            pushDuration(r8, r3, r10, r11)
        L_0x008f:
            int r2 = r2 + 1
            goto L_0x000a
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.PrettyTime.pushDuration(long[], net.time4j.Duration, net.time4j.base.TimeSource, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        r4[r1] = net.time4j.base.MathUtils.safeAdd(r6, r4[r1]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0048, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0029, code lost:
        r1 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void push(long[] r4, net.time4j.CalendarUnit r5, long r6, boolean r8) {
        /*
            int[] r0 = net.time4j.PrettyTime.AnonymousClass1.$SwitchMap$net$time4j$CalendarUnit
            int r1 = r5.ordinal()
            r0 = r0[r1]
            r1 = 3
            r2 = 1
            r3 = 0
            switch(r0) {
                case 1: goto L_0x0039;
                case 2: goto L_0x0032;
                case 3: goto L_0x002b;
                case 4: goto L_0x003f;
                case 5: goto L_0x0023;
                case 6: goto L_0x0029;
                case 7: goto L_0x0018;
                case 8: goto L_0x0040;
                default: goto L_0x000e;
            }
        L_0x000e:
            java.lang.UnsupportedOperationException r4 = new java.lang.UnsupportedOperationException
            java.lang.String r5 = r5.name()
            r4.<init>(r5)
            throw r4
        L_0x0018:
            if (r8 == 0) goto L_0x0021
            r2 = 7
            long r6 = net.time4j.base.MathUtils.safeMultiply((long) r6, (long) r2)
            goto L_0x0040
        L_0x0021:
            r1 = 2
            goto L_0x0040
        L_0x0023:
            r0 = 3
            long r6 = net.time4j.base.MathUtils.safeMultiply((long) r6, (long) r0)
        L_0x0029:
            r1 = 1
            goto L_0x0040
        L_0x002b:
            r0 = 10
            long r6 = net.time4j.base.MathUtils.safeMultiply((long) r6, (long) r0)
            goto L_0x003f
        L_0x0032:
            r0 = 100
            long r6 = net.time4j.base.MathUtils.safeMultiply((long) r6, (long) r0)
            goto L_0x003f
        L_0x0039:
            r0 = 1000(0x3e8, double:4.94E-321)
            long r6 = net.time4j.base.MathUtils.safeMultiply((long) r6, (long) r0)
        L_0x003f:
            r1 = 0
        L_0x0040:
            r2 = r4[r1]
            long r5 = net.time4j.base.MathUtils.safeAdd((long) r6, (long) r2)
            r4[r1] = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.PrettyTime.push(long[], net.time4j.CalendarUnit, long, boolean):void");
    }

    /* renamed from: net.time4j.PrettyTime$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$CalendarUnit;
        static final /* synthetic */ int[] $SwitchMap$net$time4j$ClockUnit;

        /* JADX WARNING: Can't wrap try/catch for region: R(30:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|28|29|30|31|32|33|34|35|36|37|38|(3:39|40|42)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0097 */
        static {
            /*
                net.time4j.ClockUnit[] r0 = net.time4j.ClockUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$ClockUnit = r0
                r1 = 1
                net.time4j.ClockUnit r2 = net.time4j.ClockUnit.HOURS     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$net$time4j$ClockUnit     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.ClockUnit r3 = net.time4j.ClockUnit.MINUTES     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$net$time4j$ClockUnit     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.ClockUnit r4 = net.time4j.ClockUnit.SECONDS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$net$time4j$ClockUnit     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.ClockUnit r5 = net.time4j.ClockUnit.MILLIS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = $SwitchMap$net$time4j$ClockUnit     // Catch:{ NoSuchFieldError -> 0x003e }
                net.time4j.ClockUnit r6 = net.time4j.ClockUnit.MICROS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = $SwitchMap$net$time4j$ClockUnit     // Catch:{ NoSuchFieldError -> 0x0049 }
                net.time4j.ClockUnit r7 = net.time4j.ClockUnit.NANOS     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                net.time4j.CalendarUnit[] r6 = net.time4j.CalendarUnit.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                $SwitchMap$net$time4j$CalendarUnit = r6
                net.time4j.CalendarUnit r7 = net.time4j.CalendarUnit.MILLENNIA     // Catch:{ NoSuchFieldError -> 0x005a }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r6[r7] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r1 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x0064 }
                net.time4j.CalendarUnit r6 = net.time4j.CalendarUnit.CENTURIES     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r1[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x006e }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.DECADES     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x0078 }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.YEARS     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x0082 }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.QUARTERS     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x008c }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.MONTHS     // Catch:{ NoSuchFieldError -> 0x008c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x0097 }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.WEEKS     // Catch:{ NoSuchFieldError -> 0x0097 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0097 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0097 }
            L_0x0097:
                int[] r0 = $SwitchMap$net$time4j$CalendarUnit     // Catch:{ NoSuchFieldError -> 0x00a3 }
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.DAYS     // Catch:{ NoSuchFieldError -> 0x00a3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a3 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a3 }
            L_0x00a3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.PrettyTime.AnonymousClass1.<clinit>():void");
        }
    }

    private static void push(long[] jArr, ClockUnit clockUnit, long j) {
        char c = 7;
        switch (AnonymousClass1.$SwitchMap$net$time4j$ClockUnit[clockUnit.ordinal()]) {
            case 1:
                c = 4;
                break;
            case 2:
                c = 5;
                break;
            case 3:
                c = 6;
                break;
            case 4:
                j = MathUtils.safeMultiply(j, (long) AnimationKt.MillisToNanos);
                break;
            case 5:
                j = MathUtils.safeMultiply(j, 1000);
                break;
            case 6:
                break;
            default:
                throw new UnsupportedOperationException(clockUnit.name());
        }
        jArr[c] = MathUtils.safeAdd(j, jArr[c]);
    }

    private String format(long j, IsoUnit isoUnit, boolean z, TextWidth textWidth) {
        long safeNegate = z ? MathUtils.safeNegate(j) : j;
        if (!SUPPORTED_UNITS.contains(isoUnit)) {
            throw new UnsupportedOperationException("Unknown unit: " + isoUnit);
        } else if (isoUnit.isCalendrical()) {
            return print(safeNegate, CalendarUnit.class.cast(isoUnit), textWidth);
        } else {
            ClockUnit cast = ClockUnit.class.cast(isoUnit);
            if (cast == ClockUnit.NANOS) {
                if (j % AnimationKt.MillisToNanos == 0) {
                    cast = ClockUnit.MILLIS;
                    safeNegate /= AnimationKt.MillisToNanos;
                } else if (j % 1000 == 0) {
                    cast = ClockUnit.MICROS;
                    safeNegate /= 1000;
                }
            }
            return print(safeNegate, cast, textWidth);
        }
    }

    private String format(String str, long j) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (i < length - 2 && str.charAt(i) == '{' && str.charAt(i + 1) == '0' && str.charAt(i + 2) == '}') {
                StringBuilder sb = new StringBuilder(str);
                sb.replace(i, i + 3, format(j));
                return sb.toString();
            }
        }
        if (j >= 0) {
            return str;
        }
        return this.minusSign + str;
    }

    private String format(long j) {
        String valueOf = String.valueOf(Math.abs(j));
        char c = this.zeroDigit;
        StringBuilder sb = new StringBuilder();
        if (j < 0) {
            sb.append(this.minusSign);
        }
        int length = valueOf.length();
        for (int i = 0; i < length; i++) {
            char charAt = valueOf.charAt(i);
            if (c != '0') {
                charAt = (char) ((charAt + c) - 48);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }
}
