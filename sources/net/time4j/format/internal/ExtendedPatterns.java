package net.time4j.format.internal;

import java.util.Locale;
import net.time4j.format.DisplayMode;
import net.time4j.format.FormatPatternProvider;

public interface ExtendedPatterns extends FormatPatternProvider {
    String getTimePattern(DisplayMode displayMode, Locale locale, boolean z);
}
