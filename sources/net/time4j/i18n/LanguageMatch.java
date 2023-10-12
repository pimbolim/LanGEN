package net.time4j.i18n;

import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import java.util.Locale;

public enum LanguageMatch {
    tl("fil"),
    no("nb"),
    in(MessageExtension.FIELD_ID),
    iw("he");
    
    static final LanguageMatch[] ALIASES = null;
    private final String alias;

    static {
        ALIASES = values();
    }

    private LanguageMatch(String str) {
        this.alias = str;
    }

    public static String getAlias(Locale locale) {
        String language = locale.getLanguage();
        if (language.equals("no") && locale.getVariant().equals("NY") && locale.getCountry().equals("NO")) {
            return "nn";
        }
        for (LanguageMatch languageMatch : ALIASES) {
            if (language.equals(languageMatch.name())) {
                return languageMatch.alias;
            }
        }
        return language;
    }
}
