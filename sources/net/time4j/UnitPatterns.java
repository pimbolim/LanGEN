package net.time4j;

import com.nimbusds.jose.jwk.JWKParameterNames;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.base.ResourceLoader;
import net.time4j.format.PluralCategory;
import net.time4j.format.RelativeTimeProvider;
import net.time4j.format.TextWidth;
import net.time4j.format.UnitPatternProvider;

final class UnitPatterns {
    private static final ConcurrentMap<Locale, UnitPatterns> CACHE = new ConcurrentHashMap();
    private static final UnitPatternProvider FALLBACK;
    private static final int MAX_LIST_INDEX = 7;
    private static final int MIN_LIST_INDEX = 2;
    private static final UnitPatternProvider PROVIDER;
    private static final IsoUnit[] UNIT_IDS = {CalendarUnit.YEARS, CalendarUnit.MONTHS, CalendarUnit.WEEKS, CalendarUnit.DAYS, ClockUnit.HOURS, ClockUnit.MINUTES, ClockUnit.SECONDS, ClockUnit.MILLIS, ClockUnit.MICROS, ClockUnit.NANOS};
    private final Map<IsoUnit, Map<PluralCategory, String>> future;
    private final Map<Weekday, String> lastWeekdays;
    private final Map<Integer, Map<TextWidth, String>> list;
    private final Locale locale;
    private final Map<Weekday, String> nextWeekdays;
    private final String now;
    private final Map<IsoUnit, Map<PluralCategory, String>> past;
    private final Map<IsoUnit, Map<TextWidth, Map<PluralCategory, String>>> patterns;
    private final Map<IsoUnit, Map<PluralCategory, String>> shortFuture;
    private final Map<IsoUnit, Map<PluralCategory, String>> shortPast;
    private final String today;
    private final String tomorrow;
    private final String yesterday;

    static {
        UnitPatternProvider unitPatternProvider = null;
        UnitPatternProvider fallbackProvider = new FallbackProvider((AnonymousClass1) null);
        FALLBACK = fallbackProvider;
        Iterator<S> it = ResourceLoader.getInstance().services(UnitPatternProvider.class).iterator();
        if (it.hasNext()) {
            unitPatternProvider = it.next();
        }
        if (unitPatternProvider != null) {
            fallbackProvider = unitPatternProvider;
        }
        PROVIDER = fallbackProvider;
    }

    private UnitPatterns(Locale locale2) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Locale locale3 = locale2;
        this.locale = locale3;
        HashMap hashMap = new HashMap(10);
        HashMap hashMap2 = new HashMap(10);
        HashMap hashMap3 = new HashMap(10);
        HashMap hashMap4 = new HashMap(10);
        HashMap hashMap5 = new HashMap(10);
        HashMap hashMap6 = new HashMap(10);
        IsoUnit[] isoUnitArr = UNIT_IDS;
        int length = isoUnitArr.length;
        int i = 0;
        while (i < length) {
            IsoUnit isoUnit = isoUnitArr[i];
            EnumMap enumMap = new EnumMap(TextWidth.class);
            TextWidth[] values = TextWidth.values();
            int length2 = values.length;
            int i2 = 0;
            while (i2 < length2) {
                IsoUnit[] isoUnitArr2 = isoUnitArr;
                TextWidth textWidth = values[i2];
                int i3 = length;
                TextWidth[] textWidthArr = values;
                EnumMap enumMap2 = new EnumMap(PluralCategory.class);
                PluralCategory[] values2 = PluralCategory.values();
                int i4 = length2;
                int length3 = values2.length;
                int i5 = 0;
                while (i5 < length3) {
                    int i6 = length3;
                    PluralCategory pluralCategory = values2[i5];
                    enumMap2.put(pluralCategory, lookup(locale3, isoUnit, textWidth, pluralCategory));
                    i5++;
                    length3 = i6;
                    values2 = values2;
                }
                enumMap.put(textWidth, Collections.unmodifiableMap(enumMap2));
                i2++;
                isoUnitArr = isoUnitArr2;
                length = i3;
                values = textWidthArr;
                length2 = i4;
            }
            IsoUnit[] isoUnitArr3 = isoUnitArr;
            int i7 = length;
            hashMap.put(isoUnit, Collections.unmodifiableMap(enumMap));
            if (!Character.isDigit(isoUnit.getSymbol())) {
                EnumMap enumMap3 = new EnumMap(PluralCategory.class);
                for (PluralCategory pluralCategory2 : PluralCategory.values()) {
                    enumMap3.put(pluralCategory2, lookup(locale3, isoUnit, false, false, pluralCategory2));
                }
                hashMap2.put(isoUnit, Collections.unmodifiableMap(enumMap3));
                EnumMap enumMap4 = new EnumMap(PluralCategory.class);
                for (PluralCategory pluralCategory3 : PluralCategory.values()) {
                    enumMap4.put(pluralCategory3, lookup(locale3, isoUnit, false, true, pluralCategory3));
                }
                hashMap4.put(isoUnit, Collections.unmodifiableMap(enumMap4));
                EnumMap enumMap5 = new EnumMap(PluralCategory.class);
                PluralCategory[] values3 = PluralCategory.values();
                int length4 = values3.length;
                int i8 = 0;
                while (i8 < length4) {
                    PluralCategory pluralCategory4 = values3[i8];
                    enumMap5.put(pluralCategory4, lookup(locale3, isoUnit, true, false, pluralCategory4));
                    i8++;
                    values3 = values3;
                }
                hashMap3.put(isoUnit, Collections.unmodifiableMap(enumMap5));
                EnumMap enumMap6 = new EnumMap(PluralCategory.class);
                for (PluralCategory pluralCategory5 : PluralCategory.values()) {
                    enumMap6.put(pluralCategory5, lookup(locale3, isoUnit, true, true, pluralCategory5));
                }
                hashMap5.put(isoUnit, Collections.unmodifiableMap(enumMap6));
            }
            i++;
            isoUnitArr = isoUnitArr3;
            length = i7;
        }
        for (int i9 = 2; i9 <= 7; i9++) {
            Integer valueOf = Integer.valueOf(i9);
            EnumMap enumMap7 = new EnumMap(TextWidth.class);
            for (TextWidth textWidth2 : TextWidth.values()) {
                enumMap7.put(textWidth2, lookup(locale3, textWidth2, valueOf.intValue()));
            }
            hashMap6.put(valueOf, Collections.unmodifiableMap(enumMap7));
        }
        Map<IsoUnit, Map<TextWidth, Map<PluralCategory, String>>> unmodifiableMap = Collections.unmodifiableMap(hashMap);
        this.patterns = unmodifiableMap;
        this.past = Collections.unmodifiableMap(hashMap2);
        this.future = Collections.unmodifiableMap(hashMap3);
        this.shortPast = Collections.unmodifiableMap(hashMap4);
        this.shortFuture = Collections.unmodifiableMap(hashMap5);
        this.list = Collections.unmodifiableMap(hashMap6);
        EnumMap enumMap8 = new EnumMap(Weekday.class);
        EnumMap enumMap9 = new EnumMap(Weekday.class);
        Weekday[] values4 = Weekday.values();
        int length5 = values4.length;
        int i10 = 0;
        while (true) {
            str = "";
            if (i10 < length5) {
                Weekday weekday = values4[i10];
                enumMap8.put(weekday, str);
                enumMap9.put(weekday, str);
                i10++;
            } else {
                try {
                    break;
                } catch (MissingResourceException unused) {
                    str5 = str;
                    str2 = str5;
                    str3 = FALLBACK.getNowWord(locale3);
                    str4 = str5;
                    this.now = str3;
                    this.yesterday = str;
                    this.today = str2;
                    this.tomorrow = str4;
                    this.lastWeekdays = Collections.unmodifiableMap(enumMap8);
                    this.nextWeekdays = Collections.unmodifiableMap(enumMap9);
                }
            }
        }
        UnitPatternProvider unitPatternProvider = PROVIDER;
        str3 = unitPatternProvider.getNowWord(locale3);
        if (unitPatternProvider instanceof RelativeTimeProvider) {
            RelativeTimeProvider cast = RelativeTimeProvider.class.cast(unitPatternProvider);
            String yesterdayWord = cast.getYesterdayWord(locale3);
            try {
                str2 = cast.getTodayWord(locale3);
            } catch (MissingResourceException unused2) {
                str5 = str;
                str2 = str5;
                str = yesterdayWord;
                str3 = FALLBACK.getNowWord(locale3);
                str4 = str5;
                this.now = str3;
                this.yesterday = str;
                this.today = str2;
                this.tomorrow = str4;
                this.lastWeekdays = Collections.unmodifiableMap(enumMap8);
                this.nextWeekdays = Collections.unmodifiableMap(enumMap9);
            }
            try {
                String tomorrowWord = cast.getTomorrowWord(locale3);
                for (Weekday weekday2 : Weekday.values()) {
                    enumMap8.put(weekday2, cast.labelForLast(weekday2, locale3));
                    enumMap9.put(weekday2, cast.labelForNext(weekday2, locale3));
                }
                str4 = tomorrowWord;
                str = yesterdayWord;
            } catch (MissingResourceException unused3) {
                str5 = str;
                str = yesterdayWord;
                str3 = FALLBACK.getNowWord(locale3);
                str4 = str5;
                this.now = str3;
                this.yesterday = str;
                this.today = str2;
                this.tomorrow = str4;
                this.lastWeekdays = Collections.unmodifiableMap(enumMap8);
                this.nextWeekdays = Collections.unmodifiableMap(enumMap9);
            }
        } else {
            str4 = str;
            str2 = str4;
        }
        this.now = str3;
        this.yesterday = str;
        this.today = str2;
        this.tomorrow = str4;
        this.lastWeekdays = Collections.unmodifiableMap(enumMap8);
        this.nextWeekdays = Collections.unmodifiableMap(enumMap9);
    }

    static UnitPatterns of(Locale locale2) {
        Objects.requireNonNull(locale2, "Missing language.");
        ConcurrentMap<Locale, UnitPatterns> concurrentMap = CACHE;
        UnitPatterns unitPatterns = (UnitPatterns) concurrentMap.get(locale2);
        if (unitPatterns != null) {
            return unitPatterns;
        }
        UnitPatterns unitPatterns2 = new UnitPatterns(locale2);
        UnitPatterns putIfAbsent = concurrentMap.putIfAbsent(locale2, unitPatterns2);
        return putIfAbsent != null ? putIfAbsent : unitPatterns2;
    }

    /* access modifiers changed from: package-private */
    public String getPattern(TextWidth textWidth, PluralCategory pluralCategory, IsoUnit isoUnit) {
        checkNull(textWidth, pluralCategory);
        return (String) ((Map) this.patterns.get(isoUnit).get(textWidth)).get(pluralCategory);
    }

    /* access modifiers changed from: package-private */
    public String getPatternInPast(PluralCategory pluralCategory, boolean z, IsoUnit isoUnit) {
        checkNull(pluralCategory);
        if (z) {
            return (String) this.shortPast.get(isoUnit).get(pluralCategory);
        }
        return (String) this.past.get(isoUnit).get(pluralCategory);
    }

    /* access modifiers changed from: package-private */
    public String getPatternInFuture(PluralCategory pluralCategory, boolean z, IsoUnit isoUnit) {
        checkNull(pluralCategory);
        if (z) {
            return (String) this.shortFuture.get(isoUnit).get(pluralCategory);
        }
        return (String) this.future.get(isoUnit).get(pluralCategory);
    }

    /* access modifiers changed from: package-private */
    public String getNowWord() {
        return this.now;
    }

    /* access modifiers changed from: package-private */
    public String getYesterdayWord() {
        return this.yesterday;
    }

    /* access modifiers changed from: package-private */
    public String getTodayWord() {
        return this.today;
    }

    /* access modifiers changed from: package-private */
    public String getTomorrowWord() {
        return this.tomorrow;
    }

    /* access modifiers changed from: package-private */
    public String labelForLast(Weekday weekday) {
        return this.lastWeekdays.get(weekday);
    }

    /* access modifiers changed from: package-private */
    public String labelForNext(Weekday weekday) {
        return this.nextWeekdays.get(weekday);
    }

    /* access modifiers changed from: package-private */
    public String getListPattern(TextWidth textWidth, int i) {
        Objects.requireNonNull(textWidth, "Missing width.");
        if (i < 2 || i > 7) {
            return lookup(this.locale, textWidth, i);
        }
        return (String) this.list.get(Integer.valueOf(i)).get(textWidth);
    }

    private static void checkNull(PluralCategory pluralCategory) {
        Objects.requireNonNull(pluralCategory, "Missing plural category.");
    }

    private static void checkNull(TextWidth textWidth, PluralCategory pluralCategory) {
        Objects.requireNonNull(textWidth, "Missing text width.");
        checkNull(pluralCategory);
    }

    private static char getID(IsoUnit isoUnit) {
        char symbol = isoUnit.getSymbol();
        if (isoUnit == ClockUnit.MINUTES) {
            return 'N';
        }
        return symbol;
    }

    private static String lookup(Locale locale2, IsoUnit isoUnit, TextWidth textWidth, PluralCategory pluralCategory) {
        try {
            return lookup(PROVIDER, locale2, getID(isoUnit), textWidth, pluralCategory);
        } catch (MissingResourceException unused) {
            return lookup(FALLBACK, locale2, getID(isoUnit), textWidth, pluralCategory);
        }
    }

    private static String lookup(UnitPatternProvider unitPatternProvider, Locale locale2, char c, TextWidth textWidth, PluralCategory pluralCategory) {
        if (c == '3') {
            return unitPatternProvider.getMilliPattern(locale2, textWidth, pluralCategory);
        }
        if (c == '6') {
            return unitPatternProvider.getMicroPattern(locale2, textWidth, pluralCategory);
        }
        if (c == '9') {
            return unitPatternProvider.getNanoPattern(locale2, textWidth, pluralCategory);
        }
        if (c == 'D') {
            return unitPatternProvider.getDayPattern(locale2, textWidth, pluralCategory);
        }
        if (c == 'H') {
            return unitPatternProvider.getHourPattern(locale2, textWidth, pluralCategory);
        }
        if (c == 'S') {
            return unitPatternProvider.getSecondPattern(locale2, textWidth, pluralCategory);
        }
        if (c == 'W') {
            return unitPatternProvider.getWeekPattern(locale2, textWidth, pluralCategory);
        }
        if (c == 'Y') {
            return unitPatternProvider.getYearPattern(locale2, textWidth, pluralCategory);
        }
        if (c == 'M') {
            return unitPatternProvider.getMonthPattern(locale2, textWidth, pluralCategory);
        }
        if (c == 'N') {
            return unitPatternProvider.getMinutePattern(locale2, textWidth, pluralCategory);
        }
        throw new UnsupportedOperationException("Unit-ID: " + c);
    }

    private static String lookup(Locale locale2, IsoUnit isoUnit, boolean z, boolean z2, PluralCategory pluralCategory) {
        try {
            return lookup(PROVIDER, locale2, getID(isoUnit), z, z2, pluralCategory);
        } catch (MissingResourceException unused) {
            return lookup(FALLBACK, locale2, getID(isoUnit), z, z2, pluralCategory);
        }
    }

    private static String lookup(UnitPatternProvider unitPatternProvider, Locale locale2, char c, boolean z, boolean z2, PluralCategory pluralCategory) {
        if (z2 && (unitPatternProvider instanceof RelativeTimeProvider)) {
            RelativeTimeProvider cast = RelativeTimeProvider.class.cast(unitPatternProvider);
            if (c == 'D') {
                return cast.getShortDayPattern(locale2, z, pluralCategory);
            }
            if (c == 'H') {
                return cast.getShortHourPattern(locale2, z, pluralCategory);
            }
            if (c == 'S') {
                return cast.getShortSecondPattern(locale2, z, pluralCategory);
            }
            if (c == 'W') {
                return cast.getShortWeekPattern(locale2, z, pluralCategory);
            }
            if (c == 'Y') {
                return cast.getShortYearPattern(locale2, z, pluralCategory);
            }
            if (c == 'M') {
                return cast.getShortMonthPattern(locale2, z, pluralCategory);
            }
            if (c == 'N') {
                return cast.getShortMinutePattern(locale2, z, pluralCategory);
            }
            throw new UnsupportedOperationException("Unit-ID: " + c);
        } else if (c == 'D') {
            return unitPatternProvider.getDayPattern(locale2, z, pluralCategory);
        } else {
            if (c == 'H') {
                return unitPatternProvider.getHourPattern(locale2, z, pluralCategory);
            }
            if (c == 'S') {
                return unitPatternProvider.getSecondPattern(locale2, z, pluralCategory);
            }
            if (c == 'W') {
                return unitPatternProvider.getWeekPattern(locale2, z, pluralCategory);
            }
            if (c == 'Y') {
                return unitPatternProvider.getYearPattern(locale2, z, pluralCategory);
            }
            if (c == 'M') {
                return unitPatternProvider.getMonthPattern(locale2, z, pluralCategory);
            }
            if (c == 'N') {
                return unitPatternProvider.getMinutePattern(locale2, z, pluralCategory);
            }
            throw new UnsupportedOperationException("Unit-ID: " + c);
        }
    }

    private static String lookup(Locale locale2, TextWidth textWidth, int i) {
        try {
            return PROVIDER.getListPattern(locale2, textWidth, i);
        } catch (MissingResourceException unused) {
            return FALLBACK.getListPattern(locale2, textWidth, i);
        }
    }

    private static class FallbackProvider implements UnitPatternProvider {
        public String getNowWord(Locale locale) {
            return "now";
        }

        private FallbackProvider() {
        }

        /* synthetic */ FallbackProvider(AnonymousClass1 r1) {
            this();
        }

        public String getYearPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getEnglishPattern("year", "yr", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE, textWidth, pluralCategory);
            }
            return getUnitPattern(JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE);
        }

        public String getMonthPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getEnglishPattern("month", "mth", "m", textWidth, pluralCategory);
            }
            return getUnitPattern("m");
        }

        public String getWeekPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getEnglishPattern("week", "wk", "w", textWidth, pluralCategory);
            }
            return getUnitPattern("w");
        }

        public String getDayPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getEnglishPattern("day", "day", "d", textWidth, pluralCategory);
            }
            return getUnitPattern("d");
        }

        public String getHourPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getEnglishPattern("hour", "hr", "h", textWidth, pluralCategory);
            }
            return getUnitPattern("h");
        }

        public String getMinutePattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getEnglishPattern("minute", "min", "m", textWidth, pluralCategory);
            }
            return getUnitPattern("min");
        }

        public String getSecondPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getEnglishPattern("second", "sec", "s", textWidth, pluralCategory);
            }
            return getUnitPattern("s");
        }

        public String getYearPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getRelativeEnglishPattern("year", z, pluralCategory);
            }
            return getRelativePattern(JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE, z);
        }

        public String getMonthPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getRelativeEnglishPattern("month", z, pluralCategory);
            }
            return getRelativePattern("m", z);
        }

        public String getWeekPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getRelativeEnglishPattern("week", z, pluralCategory);
            }
            return getRelativePattern("w", z);
        }

        public String getDayPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getRelativeEnglishPattern("day", z, pluralCategory);
            }
            return getRelativePattern("d", z);
        }

        public String getHourPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getRelativeEnglishPattern("hour", z, pluralCategory);
            }
            return getRelativePattern("h", z);
        }

        public String getMinutePattern(Locale locale, boolean z, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getRelativeEnglishPattern("minute", z, pluralCategory);
            }
            return getRelativePattern("min", z);
        }

        public String getSecondPattern(Locale locale, boolean z, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getRelativeEnglishPattern("second", z, pluralCategory);
            }
            return getRelativePattern("s", z);
        }

        private static String getEnglishPattern(String str, String str2, String str3, TextWidth textWidth, PluralCategory pluralCategory) {
            int i = AnonymousClass1.$SwitchMap$net$time4j$format$TextWidth[textWidth.ordinal()];
            if (i == 1) {
                return getPluralPattern(str, pluralCategory);
            }
            if (i == 2 || i == 3) {
                return getPluralPattern(str2, pluralCategory);
            }
            if (i == 4) {
                return "{0}" + str3;
            }
            throw new UnsupportedOperationException(textWidth.name());
        }

        private static String getPluralPattern(String str, PluralCategory pluralCategory) {
            String str2 = pluralCategory == PluralCategory.ONE ? "" : "s";
            return "{0} " + str + str2;
        }

        private static String getUnitPattern(String str) {
            return "{0} " + str;
        }

        private static String getRelativeEnglishPattern(String str, boolean z, PluralCategory pluralCategory) {
            String str2 = pluralCategory == PluralCategory.ONE ? "" : "s";
            if (z) {
                return "in {0} " + str + str2;
            }
            return "{0} " + str + str2 + " ago";
        }

        private static String getRelativePattern(String str, boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append(z ? "+" : "-");
            sb.append("{0} ");
            sb.append(str);
            return sb.toString();
        }

        public String getListPattern(Locale locale, TextWidth textWidth, int i) {
            if (i >= 2) {
                StringBuilder sb = new StringBuilder(i * 5);
                for (int i2 = 0; i2 < i; i2++) {
                    sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
                    sb.append(i2);
                    sb.append(AbstractJsonLexerKt.END_OBJ);
                    if (i2 < i - 1) {
                        sb.append(", ");
                    }
                }
                return sb.toString();
            }
            throw new IllegalArgumentException("Size must be greater than 1.");
        }

        public String getMilliPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getEnglishPattern("millisecond", "msec", "ms", textWidth, pluralCategory);
            }
            return getUnitPattern("ms");
        }

        public String getMicroPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getEnglishPattern("microsecond", "µsec", "µs", textWidth, pluralCategory);
            }
            return getUnitPattern("µs");
        }

        public String getNanoPattern(Locale locale, TextWidth textWidth, PluralCategory pluralCategory) {
            if (locale.getLanguage().equals("en")) {
                return getEnglishPattern("nanosecond", "nsec", "ns", textWidth, pluralCategory);
            }
            return getUnitPattern("ns");
        }
    }

    /* renamed from: net.time4j.UnitPatterns$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$TextWidth;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                net.time4j.format.TextWidth[] r0 = net.time4j.format.TextWidth.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$format$TextWidth = r0
                net.time4j.format.TextWidth r1 = net.time4j.format.TextWidth.WIDE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$format$TextWidth     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.format.TextWidth r1 = net.time4j.format.TextWidth.ABBREVIATED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$format$TextWidth     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.format.TextWidth r1 = net.time4j.format.TextWidth.SHORT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$net$time4j$format$TextWidth     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.format.TextWidth r1 = net.time4j.format.TextWidth.NARROW     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.UnitPatterns.AnonymousClass1.<clinit>():void");
        }
    }
}
