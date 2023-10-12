package net.time4j.format;

import java.util.Locale;

public interface PluralProvider {
    PluralRules load(Locale locale, NumberType numberType);
}
