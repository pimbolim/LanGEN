package net.time4j.calendar;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.calendar.EastAsianCalendar;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoException;
import net.time4j.engine.ElementRule;
import net.time4j.format.Attributes;
import net.time4j.format.TextElement;

class EastAsianST<D extends EastAsianCalendar<?, D>> implements TextElement<SolarTerm>, ElementRule<D, SolarTerm>, Serializable {
    private static final EastAsianST SINGLETON = new EastAsianST();
    private static final long serialVersionUID = 4572549754637955194L;

    public char getSymbol() {
        return 0;
    }

    public boolean isDateElement() {
        return true;
    }

    public boolean isLenient() {
        return false;
    }

    public boolean isTimeElement() {
        return false;
    }

    public boolean isValid(D d, SolarTerm solarTerm) {
        return solarTerm != null;
    }

    public String name() {
        return "SOLAR_TERM";
    }

    EastAsianST() {
    }

    static <D extends EastAsianCalendar<?, D>> EastAsianST<D> getInstance() {
        return SINGLETON;
    }

    public Class<SolarTerm> getType() {
        return SolarTerm.class;
    }

    public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
        return ((SolarTerm) chronoDisplay.get(this)).compareTo((Enum) chronoDisplay2.get(this));
    }

    public SolarTerm getDefaultMinimum() {
        return SolarTerm.MINOR_01_LICHUN_315;
    }

    public SolarTerm getDefaultMaximum() {
        return SolarTerm.MAJOR_12_DAHAN_300;
    }

    public String getDisplayName(Locale locale) {
        String language = locale.getLanguage();
        if (language.equals("zh")) {
            return locale.getCountry().equals("TW") ? "節氣" : "节气";
        }
        if (language.equals("ko")) {
            return "절기";
        }
        if (language.equals("vi")) {
            return "tiết khí";
        }
        if (language.equals("ja")) {
            return "節気";
        }
        return language.isEmpty() ? "jieqi" : "jiéqì";
    }

    public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
        appendable.append(((SolarTerm) chronoDisplay.get(this)).getDisplayName((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT)));
    }

    public SolarTerm parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
        Locale locale = (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT);
        int length = charSequence.length();
        if (parsePosition.getIndex() < length) {
            return SolarTerm.parse(charSequence, locale, parsePosition);
        }
        parsePosition.setErrorIndex(length);
        return null;
    }

    public SolarTerm getValue(D d) {
        return SolarTerm.of(d.getCalendarSystem().midnight(d.getDaysSinceEpochUTC() + 1));
    }

    public SolarTerm getMinimum(D d) {
        EastAsianCS calendarSystem = d.getCalendarSystem();
        return SolarTerm.of(calendarSystem.midnight(calendarSystem.newYear(d.getCycle(), d.getYear().getNumber()) + 1));
    }

    public SolarTerm getMaximum(D d) {
        EastAsianCS calendarSystem = d.getCalendarSystem();
        return SolarTerm.of(calendarSystem.midnight(calendarSystem.newYear(d.getCycle(), d.getYear().getNumber()) + ((long) d.lengthOfYear())));
    }

    public D withValue(D d, SolarTerm solarTerm, boolean z) {
        if (solarTerm != null) {
            return (EastAsianCalendar) d.with(solarTerm.sinceNewYear());
        }
        throw new IllegalArgumentException("Missing solar term.");
    }

    public ChronoElement<?> getChildAtFloor(D d) {
        throw new AbstractMethodError();
    }

    public ChronoElement<?> getChildAtCeiling(D d) {
        throw new AbstractMethodError();
    }

    /* access modifiers changed from: protected */
    public Object readResolve() throws ObjectStreamException {
        return SINGLETON;
    }
}
