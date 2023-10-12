package net.time4j.calendar;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoException;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.Leniency;
import net.time4j.format.TextElement;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

class EastAsianCY implements TextElement<CyclicYear>, Serializable {
    static final EastAsianCY SINGLETON = new EastAsianCY();
    private static final long serialVersionUID = -4211396220263977858L;

    public char getSymbol() {
        return Matrix.MATRIX_TYPE_RANDOM_UT;
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

    public String name() {
        return "CYCLIC_YEAR";
    }

    EastAsianCY() {
    }

    public Class<CyclicYear> getType() {
        return CyclicYear.class;
    }

    public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
        return ((CyclicYear) chronoDisplay.get(this)).compareTo((SexagesimalName) chronoDisplay2.get(this));
    }

    public CyclicYear getDefaultMinimum() {
        return CyclicYear.of(1);
    }

    public CyclicYear getDefaultMaximum() {
        return CyclicYear.of(60);
    }

    public String getDisplayName(Locale locale) {
        String str = CalendarText.getIsoInstance(locale).getTextForms().get("L_year");
        return str == null ? name() : str;
    }

    public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
        appendable.append(((CyclicYear) chronoDisplay.get(this)).getDisplayName((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT)));
    }

    public CyclicYear parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
        return CyclicYear.parse(charSequence, parsePosition, (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT), !((Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART)).isStrict());
    }

    /* access modifiers changed from: protected */
    public Object readResolve() throws ObjectStreamException {
        return SINGLETON;
    }
}
