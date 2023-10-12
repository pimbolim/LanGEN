package net.time4j.format.expert;

import java.math.BigDecimal;
import java.util.Locale;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;

enum FractionalElement implements ChronoElement<BigDecimal> {
    FRACTION;

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

    public Class<BigDecimal> getType() {
        return BigDecimal.class;
    }

    public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
        return ((BigDecimal) chronoDisplay.get(this)).compareTo((BigDecimal) chronoDisplay2.get(this));
    }

    public BigDecimal getDefaultMinimum() {
        return BigDecimal.ZERO;
    }

    public BigDecimal getDefaultMaximum() {
        return BigDecimal.ONE;
    }

    public String getDisplayName(Locale locale) {
        return name();
    }
}
