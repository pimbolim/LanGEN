package net.time4j.tz;

import java.util.Locale;
import java.util.Set;

public interface ZoneNameProvider {
    String getDisplayName(String str, NameStyle nameStyle, Locale locale);

    Set<String> getPreferredIDs(Locale locale, boolean z);

    String getStdFormatPattern(boolean z, Locale locale);
}
