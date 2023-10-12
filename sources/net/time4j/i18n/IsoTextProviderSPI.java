package net.time4j.i18n;

import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Set;
import net.time4j.format.CalendarText;
import net.time4j.format.DisplayMode;
import net.time4j.format.OutputContext;
import net.time4j.format.TextProvider;
import net.time4j.format.TextWidth;
import net.time4j.format.internal.ExtendedPatterns;
import org.apache.commons.lang3.StringUtils;

public final class IsoTextProviderSPI implements TextProvider, ExtendedPatterns {
    private static final String ISO_PATH = "calendar/names/iso8601/iso8601";
    private static final Set<String> LANGUAGES;
    private static final Set<Locale> LOCALES;

    public String toString() {
        return "IsoTextProviderSPI";
    }

    static {
        String[] split = PropertyBundle.load(ISO_PATH, Locale.ROOT).getString("languages").split(StringUtils.SPACE);
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, split);
        Set<String> unmodifiableSet = Collections.unmodifiableSet(hashSet);
        LANGUAGES = unmodifiableSet;
        HashSet hashSet2 = new HashSet();
        for (String locale : unmodifiableSet) {
            hashSet2.add(new Locale(locale));
        }
        for (LanguageMatch name : LanguageMatch.values()) {
            hashSet2.add(new Locale(name.name()));
        }
        LOCALES = Collections.unmodifiableSet(hashSet2);
    }

    public boolean supportsCalendarType(String str) {
        return CalendarText.ISO_CALENDAR_TYPE.equals(str);
    }

    public boolean supportsLanguage(Locale locale) {
        return LANGUAGES.contains(LanguageMatch.getAlias(locale));
    }

    public String[] getSupportedCalendarTypes() {
        return new String[]{CalendarText.ISO_CALENDAR_TYPE};
    }

    public Locale[] getAvailableLocales() {
        Set<Locale> set = LOCALES;
        return (Locale[]) set.toArray(new Locale[set.size()]);
    }

    public String[] months(String str, Locale locale, TextWidth textWidth, OutputContext outputContext, boolean z) {
        return months(locale, textWidth, outputContext);
    }

    public String[] quarters(String str, Locale locale, TextWidth textWidth, OutputContext outputContext) {
        return quarters(locale, textWidth, outputContext);
    }

    public String[] weekdays(String str, Locale locale, TextWidth textWidth, OutputContext outputContext) {
        return weekdays(locale, textWidth, outputContext);
    }

    public String[] eras(String str, Locale locale, TextWidth textWidth) {
        return eras(locale, textWidth);
    }

    public String[] meridiems(String str, Locale locale, TextWidth textWidth, OutputContext outputContext) {
        return meridiems(locale, textWidth, outputContext);
    }

    public String getDatePattern(DisplayMode displayMode, Locale locale) {
        return getBundle(locale).getString("F(" + toChar(displayMode) + ")_d");
    }

    public String getTimePattern(DisplayMode displayMode, Locale locale) {
        return getTimePattern(displayMode, locale, false);
    }

    public String getTimePattern(DisplayMode displayMode, Locale locale, boolean z) {
        String str;
        if (!z || displayMode != DisplayMode.FULL) {
            str = "F(" + toChar(displayMode) + ")_t";
        } else {
            str = "F(alt)";
        }
        return getBundle(locale).getString(str);
    }

    public String getDateTimePattern(DisplayMode displayMode, DisplayMode displayMode2, Locale locale) {
        if (displayMode.compareTo(displayMode2) < 0) {
            displayMode = displayMode2;
        }
        return getBundle(locale).getString("F(" + toChar(displayMode) + ")_dt");
    }

    public String getIntervalPattern(Locale locale) {
        return getBundle(locale).getString("I");
    }

    static Set<String> getPrimaryLanguages() {
        return LANGUAGES;
    }

    private static String[] months(Locale locale, TextWidth textWidth, OutputContext outputContext) throws MissingResourceException {
        String[] strArr;
        PropertyBundle bundle = getBundle(locale);
        if (bundle != null) {
            if (textWidth == TextWidth.SHORT) {
                textWidth = TextWidth.ABBREVIATED;
            }
            strArr = lookupBundle(bundle, 12, getKey(bundle, "MONTH_OF_YEAR"), textWidth, (TextWidth) null, outputContext, 1);
            if (strArr == null) {
                if (outputContext == OutputContext.STANDALONE) {
                    if (textWidth != TextWidth.NARROW) {
                        strArr = months(locale, textWidth, OutputContext.FORMAT);
                    }
                } else if (textWidth == TextWidth.ABBREVIATED) {
                    strArr = months(locale, TextWidth.WIDE, OutputContext.FORMAT);
                } else if (textWidth == TextWidth.NARROW) {
                    strArr = months(locale, textWidth, OutputContext.STANDALONE);
                }
            }
        } else {
            strArr = null;
        }
        if (strArr != null) {
            return strArr;
        }
        throw new MissingResourceException("Cannot find ISO-8601-month for locale: " + locale, IsoTextProviderSPI.class.getName(), locale.toString());
    }

    private static String[] quarters(Locale locale, TextWidth textWidth, OutputContext outputContext) throws MissingResourceException {
        String[] strArr;
        PropertyBundle bundle = getBundle(locale);
        if (bundle != null) {
            if (textWidth == TextWidth.SHORT) {
                textWidth = TextWidth.ABBREVIATED;
            }
            strArr = lookupBundle(bundle, 4, getKey(bundle, "QUARTER_OF_YEAR"), textWidth, (TextWidth) null, outputContext, 1);
            if (strArr == null) {
                if (outputContext == OutputContext.STANDALONE) {
                    if (textWidth != TextWidth.NARROW) {
                        strArr = quarters(locale, textWidth, OutputContext.FORMAT);
                    }
                } else if (textWidth == TextWidth.ABBREVIATED) {
                    strArr = quarters(locale, TextWidth.WIDE, OutputContext.FORMAT);
                } else if (textWidth == TextWidth.NARROW) {
                    strArr = quarters(locale, textWidth, OutputContext.STANDALONE);
                }
            }
        } else {
            strArr = null;
        }
        if (strArr != null) {
            return strArr;
        }
        throw new MissingResourceException("Cannot find ISO-8601-quarter-of-year for locale: " + locale, IsoTextProviderSPI.class.getName(), locale.toString());
    }

    private static String[] weekdays(Locale locale, TextWidth textWidth, OutputContext outputContext) throws MissingResourceException {
        String[] strArr;
        PropertyBundle bundle = getBundle(locale);
        if (bundle != null) {
            strArr = lookupBundle(bundle, 7, getKey(bundle, "DAY_OF_WEEK"), textWidth, (TextWidth) null, outputContext, 1);
            if (strArr == null) {
                if (outputContext == OutputContext.STANDALONE) {
                    if (textWidth != TextWidth.NARROW) {
                        strArr = weekdays(locale, textWidth, OutputContext.FORMAT);
                    }
                } else if (textWidth == TextWidth.ABBREVIATED) {
                    strArr = weekdays(locale, TextWidth.WIDE, OutputContext.FORMAT);
                } else if (textWidth == TextWidth.SHORT) {
                    strArr = weekdays(locale, TextWidth.ABBREVIATED, OutputContext.FORMAT);
                } else if (textWidth == TextWidth.NARROW) {
                    strArr = weekdays(locale, textWidth, OutputContext.STANDALONE);
                }
            }
        } else {
            strArr = null;
        }
        if (strArr != null) {
            return strArr;
        }
        throw new MissingResourceException("Cannot find ISO-8601-day-of-week for locale: " + locale, IsoTextProviderSPI.class.getName(), locale.toString());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: net.time4j.format.TextWidth} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: java.lang.String[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.lang.String[]} */
    /* JADX WARNING: type inference failed for: r1v9, types: [net.time4j.format.TextWidth] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String[] eras(java.util.Locale r7, net.time4j.format.TextWidth r8) throws java.util.MissingResourceException {
        /*
            net.time4j.i18n.PropertyBundle r0 = getBundle(r7)
            r1 = 0
            if (r0 == 0) goto L_0x002f
            net.time4j.format.TextWidth r2 = net.time4j.format.TextWidth.SHORT
            if (r8 != r2) goto L_0x000d
            net.time4j.format.TextWidth r8 = net.time4j.format.TextWidth.ABBREVIATED
        L_0x000d:
            java.lang.String r2 = "ERA"
            java.lang.String r2 = getKey(r0, r2)
            net.time4j.format.TextWidth r3 = net.time4j.format.TextWidth.NARROW
            if (r8 != r3) goto L_0x0019
            net.time4j.format.TextWidth r1 = net.time4j.format.TextWidth.ABBREVIATED
        L_0x0019:
            r4 = r1
            r1 = 5
            net.time4j.format.OutputContext r5 = net.time4j.format.OutputContext.FORMAT
            r6 = 0
            r3 = r8
            java.lang.String[] r1 = lookupBundle(r0, r1, r2, r3, r4, r5, r6)
            if (r1 != 0) goto L_0x002f
            net.time4j.format.TextWidth r0 = net.time4j.format.TextWidth.ABBREVIATED
            if (r8 == r0) goto L_0x002f
            net.time4j.format.TextWidth r8 = net.time4j.format.TextWidth.ABBREVIATED
            java.lang.String[] r1 = eras(r7, r8)
        L_0x002f:
            if (r1 == 0) goto L_0x0032
            return r1
        L_0x0032:
            java.util.MissingResourceException r8 = new java.util.MissingResourceException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot find ISO-8601-resource for era and locale: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.Class<net.time4j.i18n.IsoTextProviderSPI> r1 = net.time4j.i18n.IsoTextProviderSPI.class
            java.lang.String r1 = r1.getName()
            java.lang.String r7 = r7.toString()
            r8.<init>(r0, r1, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.i18n.IsoTextProviderSPI.eras(java.util.Locale, net.time4j.format.TextWidth):java.lang.String[]");
    }

    private static String[] meridiems(Locale locale, TextWidth textWidth, OutputContext outputContext) throws MissingResourceException {
        PropertyBundle bundle = getBundle(locale);
        if (bundle != null) {
            if (textWidth == TextWidth.SHORT) {
                textWidth = TextWidth.ABBREVIATED;
            }
            String meridiemKey = meridiemKey("am", textWidth, outputContext);
            String meridiemKey2 = meridiemKey("pm", textWidth, outputContext);
            if (bundle.containsKey(meridiemKey) && bundle.containsKey(meridiemKey2)) {
                return new String[]{bundle.getString(meridiemKey), bundle.getString(meridiemKey2)};
            } else if (outputContext == OutputContext.STANDALONE) {
                if (textWidth == TextWidth.ABBREVIATED) {
                    return meridiems(locale, textWidth, OutputContext.FORMAT);
                }
                return meridiems(locale, TextWidth.ABBREVIATED, outputContext);
            } else if (textWidth != TextWidth.ABBREVIATED) {
                return meridiems(locale, TextWidth.ABBREVIATED, outputContext);
            }
        }
        throw new MissingResourceException("Cannot find ISO-8601-resource for am/pm and locale: " + locale, IsoTextProviderSPI.class.getName(), locale.toString());
    }

    private static PropertyBundle getBundle(Locale locale) throws MissingResourceException {
        return PropertyBundle.load(ISO_PATH, locale);
    }

    private static char toChar(DisplayMode displayMode) {
        return Character.toLowerCase(displayMode.name().charAt(0));
    }

    private static String[] lookupBundle(PropertyBundle propertyBundle, int i, String str, TextWidth textWidth, TextWidth textWidth2, OutputContext outputContext, int i2) {
        String[] lookupBundle;
        PropertyBundle propertyBundle2 = propertyBundle;
        int i3 = i;
        OutputContext outputContext2 = outputContext;
        String[] strArr = new String[i3];
        boolean z = str.length() == 1;
        for (int i4 = 0; i4 < i3; i4++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append('(');
            if (z) {
                char charAt = textWidth.name().charAt(0);
                if (outputContext2 != OutputContext.STANDALONE) {
                    charAt = Character.toLowerCase(charAt);
                }
                sb.append(charAt);
            } else {
                sb.append(textWidth.name());
                if (outputContext2 == OutputContext.STANDALONE) {
                    sb.append('|');
                    sb.append(outputContext.name());
                }
            }
            sb.append(')');
            sb.append('_');
            sb.append(i4 + i2);
            String sb2 = sb.toString();
            if (propertyBundle2.containsKey(sb2)) {
                strArr[i4] = propertyBundle2.getString(sb2);
            } else if (textWidth2 == null || (lookupBundle = lookupBundle(propertyBundle, i, str, textWidth2, (TextWidth) null, outputContext, i2)) == null) {
                return null;
            } else {
                strArr[i4] = lookupBundle[i4];
            }
        }
        return strArr;
    }

    private static String getKey(PropertyBundle propertyBundle, String str) {
        return (!propertyBundle.containsKey("useShortKeys") || !"true".equals(propertyBundle.getString("useShortKeys"))) ? str : str.substring(0, 1);
    }

    private static String meridiemKey(String str, TextWidth textWidth, OutputContext outputContext) {
        char charAt = textWidth.name().charAt(0);
        if (outputContext == OutputContext.FORMAT) {
            charAt = Character.toLowerCase(charAt);
        }
        return "P(" + String.valueOf(charAt) + ")_" + str;
    }
}
