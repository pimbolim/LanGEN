package net.time4j.engine;

import java.util.Locale;
import kotlin.jvm.internal.CharCompanionObject;

public enum ValidationElement implements ChronoElement<String> {
    ERROR_MESSAGE;

    public String getDefaultMinimum() {
        return "";
    }

    public char getSymbol() {
        return 0;
    }

    public boolean isDateElement() {
        return false;
    }

    public boolean isLenient() {
        return false;
    }

    public boolean isTimeElement() {
        return false;
    }

    public Class<String> getType() {
        return String.class;
    }

    public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
        boolean contains = chronoDisplay.contains(this);
        if (contains == chronoDisplay2.contains(this)) {
            return 0;
        }
        return contains ? 1 : -1;
    }

    public String getDefaultMaximum() {
        return String.valueOf(CharCompanionObject.MAX_VALUE);
    }

    public String getDisplayName(Locale locale) {
        return name();
    }
}
