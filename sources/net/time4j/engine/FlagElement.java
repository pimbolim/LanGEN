package net.time4j.engine;

import java.util.Locale;

public enum FlagElement implements ChronoElement<Boolean> {
    LEAP_SECOND,
    DAYLIGHT_SAVING;

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

    public Class<Boolean> getType() {
        return Boolean.class;
    }

    public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
        boolean contains = chronoDisplay.contains(this);
        if (contains == chronoDisplay2.contains(this)) {
            return 0;
        }
        return contains ? 1 : -1;
    }

    public Boolean getDefaultMinimum() {
        return Boolean.FALSE;
    }

    public Boolean getDefaultMaximum() {
        return Boolean.TRUE;
    }

    public String getDisplayName(Locale locale) {
        return name();
    }
}
