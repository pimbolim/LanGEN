package net.time4j.format;

import androidx.exifinterface.media.ExifInterface;
import com.braintreepayments.api.models.ThreeDSecureRequest;
import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.base.ResourceLoader;
import net.time4j.engine.BridgeChronology;
import net.time4j.engine.CalendarEra;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.Chronology;
import net.time4j.format.internal.ExtendedPatterns;
import net.time4j.format.internal.FormatUtils;
import net.time4j.i18n.IsoTextProviderSPI;
import net.time4j.i18n.PropertyBundle;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public final class CalendarText {
    private static final ConcurrentMap<String, CalendarText> CACHE = new ConcurrentHashMap();
    private static final FormatPatternProvider FORMAT_PATTERN_PROVIDER;
    public static final String ISO_CALENDAR_TYPE = "iso8601";
    private static final TextProvider JDK_PROVIDER = new JDKTextProvider((AnonymousClass1) null);
    private static final TextProvider ROOT_PROVIDER = new FallbackProvider((AnonymousClass1) null);
    private static final Set<String> RTL;
    private final String calendarType;
    private final Map<TextWidth, TextAccessor> eras;
    private final Map<TextWidth, Map<OutputContext, TextAccessor>> leapMonths;
    private final Locale locale;
    private final Map<TextWidth, Map<OutputContext, TextAccessor>> meridiems;
    private final MissingResourceException mre;
    private final String provider;
    private final Map<TextWidth, Map<OutputContext, TextAccessor>> quarters;
    private final Map<TextWidth, Map<OutputContext, TextAccessor>> stdMonths;
    private final Map<String, String> textForms;
    private final Map<TextWidth, Map<OutputContext, TextAccessor>> weekdays;

    static {
        FormatPatternProvider formatPatternProvider;
        HashSet hashSet = new HashSet();
        hashSet.add("ar");
        hashSet.add("dv");
        hashSet.add("fa");
        hashSet.add("ha");
        hashSet.add("he");
        hashSet.add("iw");
        hashSet.add("ji");
        hashSet.add("ps");
        hashSet.add("sd");
        hashSet.add("ug");
        hashSet.add("ur");
        hashSet.add("yi");
        RTL = Collections.unmodifiableSet(hashSet);
        Iterator<S> it = ResourceLoader.getInstance().services(FormatPatternProvider.class).iterator();
        if (it.hasNext()) {
            formatPatternProvider = (FormatPatternProvider) it.next();
        } else {
            formatPatternProvider = new IsoTextProviderSPI();
        }
        FORMAT_PATTERN_PROVIDER = new FormatPatterns(formatPatternProvider);
    }

    private CalendarText(String str, Locale locale2, TextProvider textProvider) {
        String str2 = str;
        Locale locale3 = locale2;
        TextProvider textProvider2 = textProvider;
        this.provider = textProvider.toString();
        Map<TextWidth, Map<OutputContext, TextAccessor>> unmodifiableMap = Collections.unmodifiableMap(getMonths(str2, locale3, textProvider2, false));
        this.stdMonths = unmodifiableMap;
        Map<TextWidth, Map<OutputContext, TextAccessor>> months = getMonths(str2, locale3, textProvider2, true);
        if (months == null) {
            this.leapMonths = unmodifiableMap;
        } else {
            this.leapMonths = Collections.unmodifiableMap(months);
        }
        EnumMap enumMap = new EnumMap(TextWidth.class);
        for (TextWidth textWidth : TextWidth.values()) {
            EnumMap enumMap2 = new EnumMap(OutputContext.class);
            for (OutputContext outputContext : OutputContext.values()) {
                enumMap2.put(outputContext, new TextAccessor(textProvider2.quarters(str2, locale3, textWidth, outputContext)));
            }
            enumMap.put(textWidth, enumMap2);
        }
        this.quarters = Collections.unmodifiableMap(enumMap);
        EnumMap enumMap3 = new EnumMap(TextWidth.class);
        for (TextWidth textWidth2 : TextWidth.values()) {
            EnumMap enumMap4 = new EnumMap(OutputContext.class);
            for (OutputContext outputContext2 : OutputContext.values()) {
                enumMap4.put(outputContext2, new TextAccessor(textProvider2.weekdays(str2, locale3, textWidth2, outputContext2)));
            }
            enumMap3.put(textWidth2, enumMap4);
        }
        this.weekdays = Collections.unmodifiableMap(enumMap3);
        EnumMap enumMap5 = new EnumMap(TextWidth.class);
        for (TextWidth textWidth3 : TextWidth.values()) {
            enumMap5.put(textWidth3, new TextAccessor(textProvider2.eras(str2, locale3, textWidth3)));
        }
        this.eras = Collections.unmodifiableMap(enumMap5);
        EnumMap enumMap6 = new EnumMap(TextWidth.class);
        for (TextWidth textWidth4 : TextWidth.values()) {
            EnumMap enumMap7 = new EnumMap(OutputContext.class);
            for (OutputContext outputContext3 : OutputContext.values()) {
                enumMap7.put(outputContext3, new TextAccessor(textProvider2.meridiems(str2, locale3, textWidth4, outputContext3)));
            }
            enumMap6.put(textWidth4, enumMap7);
        }
        this.meridiems = Collections.unmodifiableMap(enumMap6);
        HashMap hashMap = new HashMap();
        MissingResourceException e = null;
        try {
            PropertyBundle load = PropertyBundle.load("calendar/names/" + str2 + "/" + str2, locale3);
            for (String next : load.keySet()) {
                hashMap.put(next, load.getString(next));
            }
        } catch (MissingResourceException e2) {
            e = e2;
        }
        this.textForms = Collections.unmodifiableMap(hashMap);
        this.calendarType = str2;
        this.locale = locale3;
        this.mre = e;
    }

    public static CalendarText getIsoInstance(Locale locale2) {
        return getInstance(ISO_CALENDAR_TYPE, locale2);
    }

    public static CalendarText getInstance(Chronology<?> chronology, Locale locale2) {
        return getInstance(extractCalendarType(chronology), locale2);
    }

    public static CalendarText getInstance(String str, Locale locale2) {
        Objects.requireNonNull(str, "Missing calendar type.");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(AbstractJsonLexerKt.COLON);
        sb.append(locale2.getLanguage());
        String country = locale2.getCountry();
        if (!country.isEmpty()) {
            sb.append(SignatureVisitor.SUPER);
            sb.append(country);
        }
        String sb2 = sb.toString();
        CalendarText calendarText = (CalendarText) CACHE.get(sb2);
        if (calendarText != null) {
            return calendarText;
        }
        TextProvider textProvider = null;
        if (!locale2.getLanguage().isEmpty() || !str.equals(ISO_CALENDAR_TYPE)) {
            Iterator<S> it = ResourceLoader.getInstance().services(TextProvider.class).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TextProvider textProvider2 = (TextProvider) it.next();
                if (textProvider2.supportsCalendarType(str) && textProvider2.supportsLanguage(locale2)) {
                    textProvider = textProvider2;
                    break;
                }
            }
            if (textProvider == null) {
                TextProvider textProvider3 = JDK_PROVIDER;
                if (textProvider3.supportsCalendarType(str) && textProvider3.supportsLanguage(locale2)) {
                    textProvider = textProvider3;
                }
                if (textProvider == null) {
                    textProvider = ROOT_PROVIDER;
                }
            }
        } else {
            textProvider = ROOT_PROVIDER;
        }
        CalendarText calendarText2 = new CalendarText(str, locale2, textProvider);
        CalendarText putIfAbsent = CACHE.putIfAbsent(sb2, calendarText2);
        return putIfAbsent != null ? putIfAbsent : calendarText2;
    }

    public TextAccessor getStdMonths(TextWidth textWidth, OutputContext outputContext) {
        return getMonths(textWidth, outputContext, false);
    }

    public TextAccessor getLeapMonths(TextWidth textWidth, OutputContext outputContext) {
        return getMonths(textWidth, outputContext, true);
    }

    public TextAccessor getQuarters(TextWidth textWidth, OutputContext outputContext) {
        return (TextAccessor) this.quarters.get(textWidth).get(outputContext);
    }

    public TextAccessor getWeekdays(TextWidth textWidth, OutputContext outputContext) {
        return (TextAccessor) this.weekdays.get(textWidth).get(outputContext);
    }

    public TextAccessor getEras(TextWidth textWidth) {
        return this.eras.get(textWidth);
    }

    public TextAccessor getMeridiems(TextWidth textWidth, OutputContext outputContext) {
        return (TextAccessor) this.meridiems.get(textWidth).get(outputContext);
    }

    public Map<String, String> getTextForms() {
        return this.textForms;
    }

    public <V extends Enum<V>> TextAccessor getTextForms(ChronoElement<V> chronoElement, String... strArr) {
        return getTextForms(chronoElement.name(), chronoElement.getType(), strArr);
    }

    public <V extends Enum<V>> TextAccessor getTextForms(String str, Class<V> cls, String... strArr) {
        if (this.mre == null) {
            Enum[] enumArr = (Enum[]) cls.getEnumConstants();
            int length = enumArr.length;
            String[] strArr2 = new String[length];
            String keyPrefix = getKeyPrefix(str);
            boolean z = !CalendarEra.class.isAssignableFrom(cls);
            for (int i = 0; i < length; i++) {
                String str2 = null;
                int i2 = 0;
                while (true) {
                    String keyStart = getKeyStart(keyPrefix, i2, strArr);
                    if (keyStart == null) {
                        break;
                    }
                    String key = toKey(keyStart, i, z ? 1 : 0);
                    if (this.textForms.containsKey(key)) {
                        str2 = key;
                        break;
                    }
                    i2++;
                }
                if (str2 != null) {
                    strArr2[i] = this.textForms.get(str2);
                } else if (this.textForms.containsKey(str)) {
                    strArr2[i] = this.textForms.get(str);
                } else {
                    strArr2[i] = enumArr[i].name();
                }
            }
            return new TextAccessor(strArr2);
        }
        throw new MissingResourceException(this.mre.getMessage(), this.mre.getClassName(), this.mre.getKey());
    }

    public static String patternForDate(DisplayMode displayMode, Locale locale2) {
        return FORMAT_PATTERN_PROVIDER.getDatePattern(displayMode, locale2);
    }

    public static String patternForTime(DisplayMode displayMode, Locale locale2) {
        return FORMAT_PATTERN_PROVIDER.getTimePattern(displayMode, locale2);
    }

    public static String patternForTimestamp(DisplayMode displayMode, DisplayMode displayMode2, Locale locale2) {
        return FormatUtils.removeZones(FORMAT_PATTERN_PROVIDER.getDateTimePattern(displayMode, displayMode2, locale2));
    }

    public static String patternForMoment(DisplayMode displayMode, DisplayMode displayMode2, Locale locale2) {
        return FORMAT_PATTERN_PROVIDER.getDateTimePattern(displayMode, displayMode2, locale2);
    }

    public static String patternForInterval(Locale locale2) {
        return FORMAT_PATTERN_PROVIDER.getIntervalPattern(locale2);
    }

    public String toString() {
        return this.provider + "(" + this.calendarType + "/" + this.locale + ")";
    }

    public static void clearCache() {
        CACHE.clear();
    }

    public static boolean isRTL(Locale locale2) {
        return RTL.contains(locale2.getLanguage());
    }

    static String extractCalendarType(Chronology<?> chronology) {
        while (chronology instanceof BridgeChronology) {
            chronology = chronology.preparser();
        }
        CalendarType calendarType2 = (CalendarType) chronology.getChronoType().getAnnotation(CalendarType.class);
        if (calendarType2 == null) {
            return ISO_CALENDAR_TYPE;
        }
        return calendarType2.value();
    }

    private TextAccessor getMonths(TextWidth textWidth, OutputContext outputContext, boolean z) {
        if (z) {
            return (TextAccessor) this.leapMonths.get(textWidth).get(outputContext);
        }
        return (TextAccessor) this.stdMonths.get(textWidth).get(outputContext);
    }

    private static Map<TextWidth, Map<OutputContext, TextAccessor>> getMonths(String str, Locale locale2, TextProvider textProvider, boolean z) {
        TextWidth textWidth;
        EnumMap enumMap;
        OutputContext[] outputContextArr;
        int i;
        EnumMap enumMap2 = new EnumMap(TextWidth.class);
        TextWidth[] values = TextWidth.values();
        int length = values.length;
        boolean z2 = false;
        int i2 = 0;
        while (i2 < length) {
            TextWidth textWidth2 = values[i2];
            EnumMap enumMap3 = new EnumMap(OutputContext.class);
            OutputContext[] values2 = OutputContext.values();
            int length2 = values2.length;
            boolean z3 = z2;
            int i3 = 0;
            while (i3 < length2) {
                OutputContext outputContext = values2[i3];
                OutputContext outputContext2 = outputContext;
                int i4 = i3;
                String[] months = textProvider.months(str, locale2, textWidth2, outputContext, z);
                if (!z || z3) {
                    i = length2;
                    outputContextArr = values2;
                    enumMap = enumMap3;
                    textWidth = textWidth2;
                } else {
                    i = length2;
                    outputContextArr = values2;
                    enumMap = enumMap3;
                    textWidth = textWidth2;
                    z3 = !Arrays.equals(textProvider.months(str, locale2, textWidth2, outputContext2, false), months);
                }
                enumMap.put(outputContext2, new TextAccessor(months));
                i3 = i4 + 1;
                length2 = i;
                values2 = outputContextArr;
                enumMap3 = enumMap;
                textWidth2 = textWidth;
            }
            enumMap2.put(textWidth2, enumMap3);
            i2++;
            z2 = z3;
        }
        if (!z || z2) {
            return enumMap2;
        }
        return null;
    }

    private String getKeyPrefix(String str) {
        if (!this.textForms.containsKey("useShortKeys") || !"true".equals(this.textForms.get("useShortKeys"))) {
            return str;
        }
        if (str.equals("MONTH_OF_YEAR") || str.equals("DAY_OF_WEEK") || str.equals("QUARTER_OF_YEAR") || str.equals("ERA")) {
            return str.substring(0, 1);
        }
        if (str.equals("EVANGELIST")) {
            return "EV";
        }
        if (str.equals("SANSCULOTTIDES")) {
            return ExifInterface.LATITUDE_SOUTH;
        }
        return str.equals("DAY_OF_DECADE") ? "D" : str;
    }

    private static String getKeyStart(String str, int i, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            if (i > 0) {
                return null;
            }
            return str;
        } else if (strArr.length < i) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder(str);
            boolean z = true;
            for (int i2 = 0; i2 < strArr.length - i; i2++) {
                if (z) {
                    sb.append('(');
                    z = false;
                } else {
                    sb.append('|');
                }
                sb.append(strArr[i2]);
            }
            if (!z) {
                sb.append(')');
            }
            return sb.toString();
        }
    }

    private static String toKey(String str, int i, int i2) {
        return str + '_' + (i + i2);
    }

    private static class JDKTextProvider implements TextProvider {
        public String toString() {
            return "JDKTextProvider";
        }

        private JDKTextProvider() {
        }

        /* synthetic */ JDKTextProvider(AnonymousClass1 r1) {
            this();
        }

        public boolean supportsCalendarType(String str) {
            return CalendarText.ISO_CALENDAR_TYPE.equals(str);
        }

        public boolean supportsLanguage(Locale locale) {
            String language = locale.getLanguage();
            for (Locale language2 : DateFormatSymbols.getAvailableLocales()) {
                if (language2.getLanguage().equals(language)) {
                    return true;
                }
            }
            return false;
        }

        public String[] getSupportedCalendarTypes() {
            return new String[]{CalendarText.ISO_CALENDAR_TYPE};
        }

        public Locale[] getAvailableLocales() {
            return DateFormatSymbols.getAvailableLocales();
        }

        public String[] months(String str, Locale locale, TextWidth textWidth, OutputContext outputContext, boolean z) {
            DateFormatSymbols instance = DateFormatSymbols.getInstance(locale);
            int i = AnonymousClass1.$SwitchMap$net$time4j$format$TextWidth[textWidth.ordinal()];
            if (i == 1) {
                return instance.getMonths();
            }
            if (i == 2 || i == 3) {
                return instance.getShortMonths();
            }
            if (i == 4) {
                return narrow(instance.getShortMonths(), 12);
            }
            throw new UnsupportedOperationException(textWidth.name());
        }

        public String[] quarters(String str, Locale locale, TextWidth textWidth, OutputContext outputContext) {
            return new String[]{"Q1", "Q2", "Q3", "Q4"};
        }

        public String[] weekdays(String str, Locale locale, TextWidth textWidth, OutputContext outputContext) {
            String[] strArr;
            DateFormatSymbols instance = DateFormatSymbols.getInstance(locale);
            int i = AnonymousClass1.$SwitchMap$net$time4j$format$TextWidth[textWidth.ordinal()];
            if (i == 1) {
                strArr = instance.getWeekdays();
            } else if (i == 2 || i == 3) {
                strArr = instance.getShortWeekdays();
            } else if (i == 4) {
                strArr = narrow(weekdays("", locale, TextWidth.SHORT, outputContext), 7);
            } else {
                throw new UnsupportedOperationException("Unknown text width: " + textWidth);
            }
            if (strArr.length <= 7) {
                return strArr;
            }
            String str2 = strArr[1];
            String[] strArr2 = new String[7];
            System.arraycopy(strArr, 2, strArr2, 0, 6);
            strArr2[6] = str2;
            return strArr2;
        }

        public String[] eras(String str, Locale locale, TextWidth textWidth) {
            DateFormatSymbols instance = DateFormatSymbols.getInstance(locale);
            if (textWidth != TextWidth.NARROW) {
                return instance.getEras();
            }
            String[] eras = instance.getEras();
            String[] strArr = new String[eras.length];
            int length = eras.length;
            for (int i = 0; i < length; i++) {
                if (!eras[i].isEmpty()) {
                    strArr[i] = toSingleLetter(eras[i]);
                } else if (i == 0 && eras.length == 2) {
                    strArr[i] = "B";
                } else if (i == 1 && eras.length == 2) {
                    strArr[i] = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
                } else {
                    strArr[i] = String.valueOf(i);
                }
            }
            return strArr;
        }

        public String[] meridiems(String str, Locale locale, TextWidth textWidth, OutputContext outputContext) {
            if (textWidth == TextWidth.NARROW) {
                return new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "P"};
            }
            return DateFormatSymbols.getInstance(locale).getAmPmStrings();
        }

        private static String[] narrow(String[] strArr, int i) {
            String[] strArr2 = new String[i];
            for (int i2 = 0; i2 < i; i2++) {
                if (!strArr[i2].isEmpty()) {
                    strArr2[i2] = toSingleLetter(strArr[i2]);
                } else {
                    strArr2[i2] = String.valueOf(i2 + 1);
                }
            }
            return strArr2;
        }

        private static String toSingleLetter(String str) {
            char charAt = Normalizer.normalize(str, Normalizer.Form.NFD).charAt(0);
            if (charAt >= 'A' && charAt <= 'Z') {
                return String.valueOf(charAt);
            }
            if (charAt >= 'a' && charAt <= 'z') {
                return String.valueOf((char) (charAt - ' '));
            }
            if (charAt < 1040 || charAt > 1071) {
                return (charAt < 1072 || charAt > 1103) ? str : String.valueOf((char) (charAt - ' '));
            }
            return String.valueOf(charAt);
        }
    }

    private static class FallbackProvider implements TextProvider {
        public boolean supportsCalendarType(String str) {
            return true;
        }

        public boolean supportsLanguage(Locale locale) {
            return true;
        }

        public String toString() {
            return "FallbackProvider";
        }

        private FallbackProvider() {
        }

        /* synthetic */ FallbackProvider(AnonymousClass1 r1) {
            this();
        }

        public String[] getSupportedCalendarTypes() {
            throw new UnsupportedOperationException("Never called.");
        }

        public Locale[] getAvailableLocales() {
            throw new UnsupportedOperationException("Never called.");
        }

        public String[] months(String str, Locale locale, TextWidth textWidth, OutputContext outputContext, boolean z) {
            if (textWidth == TextWidth.WIDE) {
                return new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13"};
            }
            return new String[]{ThreeDSecureRequest.VERSION_1, "2", ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", "10", "11", "12", "13"};
        }

        public String[] quarters(String str, Locale locale, TextWidth textWidth, OutputContext outputContext) {
            if (textWidth == TextWidth.NARROW) {
                return new String[]{ThreeDSecureRequest.VERSION_1, "2", ExifInterface.GPS_MEASUREMENT_3D, "4"};
            }
            return new String[]{"Q1", "Q2", "Q3", "Q4"};
        }

        public String[] weekdays(String str, Locale locale, TextWidth textWidth, OutputContext outputContext) {
            return new String[]{ThreeDSecureRequest.VERSION_1, "2", ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7"};
        }

        public String[] eras(String str, Locale locale, TextWidth textWidth) {
            if (textWidth == TextWidth.NARROW) {
                return new String[]{"B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS};
            }
            return new String[]{BouncyCastleProvider.PROVIDER_NAME, "AD"};
        }

        public String[] meridiems(String str, Locale locale, TextWidth textWidth, OutputContext outputContext) {
            if (textWidth == TextWidth.NARROW) {
                return new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "P"};
            }
            return new String[]{"AM", "PM"};
        }
    }

    private static class FormatPatterns implements FormatPatternProvider {
        private final FormatPatternProvider delegate;

        FormatPatterns(FormatPatternProvider formatPatternProvider) {
            this.delegate = formatPatternProvider;
        }

        public String getDatePattern(DisplayMode displayMode, Locale locale) {
            FormatPatternProvider formatPatternProvider = this.delegate;
            if (formatPatternProvider == null) {
                return getFormatPattern(DateFormat.getDateInstance(getFormatStyle(displayMode), locale));
            }
            return formatPatternProvider.getDatePattern(displayMode, locale);
        }

        public String getTimePattern(DisplayMode displayMode, Locale locale) {
            String str;
            FormatPatternProvider formatPatternProvider = this.delegate;
            if (formatPatternProvider == null) {
                str = getFormatPattern(DateFormat.getTimeInstance(getFormatStyle(displayMode), locale));
            } else if (formatPatternProvider instanceof ExtendedPatterns) {
                str = ExtendedPatterns.class.cast(formatPatternProvider).getTimePattern(displayMode, locale, true);
            } else {
                str = formatPatternProvider.getTimePattern(displayMode, locale);
            }
            return FormatUtils.removeZones(str);
        }

        public String getDateTimePattern(DisplayMode displayMode, DisplayMode displayMode2, Locale locale) {
            FormatPatternProvider formatPatternProvider = this.delegate;
            if (formatPatternProvider == null) {
                return getFormatPattern(DateFormat.getDateTimeInstance(getFormatStyle(displayMode), getFormatStyle(displayMode2), locale));
            }
            return this.delegate.getDateTimePattern(displayMode, displayMode2, locale).replace("{1}", this.delegate.getDatePattern(displayMode, locale)).replace("{0}", formatPatternProvider.getTimePattern(displayMode2, locale));
        }

        public String getIntervalPattern(Locale locale) {
            FormatPatternProvider formatPatternProvider = this.delegate;
            if (formatPatternProvider == null) {
                return (!locale.getLanguage().isEmpty() || !locale.getCountry().isEmpty()) ? "{0} - {1}" : "{0}/{1}";
            }
            return formatPatternProvider.getIntervalPattern(locale);
        }

        private static int getFormatStyle(DisplayMode displayMode) {
            int i = AnonymousClass1.$SwitchMap$net$time4j$format$DisplayMode[displayMode.ordinal()];
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 1;
            }
            if (i == 3) {
                return 2;
            }
            if (i == 4) {
                return 3;
            }
            throw new UnsupportedOperationException("Unknown: " + displayMode);
        }

        private static String getFormatPattern(DateFormat dateFormat) {
            if (dateFormat instanceof SimpleDateFormat) {
                return SimpleDateFormat.class.cast(dateFormat).toPattern();
            }
            throw new IllegalStateException("Cannot retrieve format pattern: " + dateFormat);
        }
    }

    /* renamed from: net.time4j.format.CalendarText$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$DisplayMode;
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$TextWidth;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|(3:23|24|26)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        static {
            /*
                net.time4j.format.DisplayMode[] r0 = net.time4j.format.DisplayMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$format$DisplayMode = r0
                r1 = 1
                net.time4j.format.DisplayMode r2 = net.time4j.format.DisplayMode.FULL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$net$time4j$format$DisplayMode     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.format.DisplayMode r3 = net.time4j.format.DisplayMode.LONG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$net$time4j$format$DisplayMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.format.DisplayMode r4 = net.time4j.format.DisplayMode.MEDIUM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$net$time4j$format$DisplayMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.format.DisplayMode r5 = net.time4j.format.DisplayMode.SHORT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                net.time4j.format.TextWidth[] r4 = net.time4j.format.TextWidth.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$net$time4j$format$TextWidth = r4
                net.time4j.format.TextWidth r5 = net.time4j.format.TextWidth.WIDE     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = $SwitchMap$net$time4j$format$TextWidth     // Catch:{ NoSuchFieldError -> 0x004e }
                net.time4j.format.TextWidth r4 = net.time4j.format.TextWidth.ABBREVIATED     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = $SwitchMap$net$time4j$format$TextWidth     // Catch:{ NoSuchFieldError -> 0x0058 }
                net.time4j.format.TextWidth r1 = net.time4j.format.TextWidth.SHORT     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = $SwitchMap$net$time4j$format$TextWidth     // Catch:{ NoSuchFieldError -> 0x0062 }
                net.time4j.format.TextWidth r1 = net.time4j.format.TextWidth.NARROW     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.CalendarText.AnonymousClass1.<clinit>():void");
        }
    }
}
