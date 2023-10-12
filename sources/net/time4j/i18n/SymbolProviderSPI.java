package net.time4j.i18n;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.time4j.format.NumberSymbolProvider;
import net.time4j.format.NumberSystem;
import org.apache.commons.lang3.StringUtils;

public final class SymbolProviderSPI implements NumberSymbolProvider {
    private static final Map<String, NumberSystem> CLDR_NAMES;
    private static final Locale[] EMPTY_ARRAY = new Locale[0];
    public static final SymbolProviderSPI INSTANCE = new SymbolProviderSPI();
    public static final Set<String> SUPPORTED_LOCALES;

    public String toString() {
        return "SymbolProviderSPI";
    }

    static {
        String[] split = PropertyBundle.load("i18n/numbers/symbol", Locale.ROOT).getString("locales").split(StringUtils.SPACE);
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, split);
        SUPPORTED_LOCALES = Collections.unmodifiableSet(hashSet);
        HashMap hashMap = new HashMap();
        for (NumberSystem numberSystem : NumberSystem.values()) {
            hashMap.put(numberSystem.getCode(), numberSystem);
        }
        CLDR_NAMES = Collections.unmodifiableMap(hashMap);
    }

    public Locale[] getAvailableLocales() {
        return EMPTY_ARRAY;
    }

    public char getZeroDigit(Locale locale) {
        return lookup(locale, "zero", NumberSymbolProvider.DEFAULT.getZeroDigit(locale));
    }

    public char getDecimalSeparator(Locale locale) {
        return lookup(locale, "separator", NumberSymbolProvider.DEFAULT.getDecimalSeparator(locale));
    }

    public String getPlusSign(Locale locale) {
        return lookup(locale, "plus", NumberSymbolProvider.DEFAULT.getPlusSign(locale));
    }

    public String getMinusSign(Locale locale) {
        return lookup(locale, "minus", NumberSymbolProvider.DEFAULT.getMinusSign(locale));
    }

    public NumberSystem getDefaultNumberSystem(Locale locale) {
        String lookup = lookup(locale, "numsys", NumberSystem.ARABIC.getCode());
        NumberSystem numberSystem = CLDR_NAMES.get(lookup);
        if (numberSystem != null) {
            return numberSystem;
        }
        throw new IllegalStateException("Unrecognized number system: " + lookup + " (locale=" + locale + ')');
    }

    private static char lookup(Locale locale, String str, char c) {
        PropertyBundle bundle = getBundle(locale);
        return (bundle == null || !bundle.containsKey(str)) ? c : bundle.getString(str).charAt(0);
    }

    private static String lookup(Locale locale, String str, String str2) {
        PropertyBundle bundle = getBundle(locale);
        return (bundle == null || !bundle.containsKey(str)) ? str2 : bundle.getString(str);
    }

    private static PropertyBundle getBundle(Locale locale) {
        if (SUPPORTED_LOCALES.contains(LanguageMatch.getAlias(locale))) {
            return PropertyBundle.load("i18n/numbers/symbol", locale);
        }
        return null;
    }
}
