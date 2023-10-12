package net.time4j.history;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.PlainDate;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.BasicElement;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.Chronology;
import net.time4j.engine.ElementRule;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.DisplayElement;
import net.time4j.format.TextAccessor;
import net.time4j.format.TextElement;
import net.time4j.format.TextWidth;
import net.time4j.history.internal.HistoricAttribute;

final class HistoricEraElement extends DisplayElement<HistoricEra> implements TextElement<HistoricEra> {
    private static final Locale LATIN = new Locale("la");
    private static final long serialVersionUID = 5200533417265981438L;
    private final ChronoHistory history;

    public char getSymbol() {
        return 'G';
    }

    public boolean isDateElement() {
        return true;
    }

    public boolean isTimeElement() {
        return false;
    }

    HistoricEraElement(ChronoHistory chronoHistory) {
        super("ERA");
        this.history = chronoHistory;
    }

    public Class<HistoricEra> getType() {
        return HistoricEra.class;
    }

    public HistoricEra getDefaultMinimum() {
        return HistoricEra.BC;
    }

    public HistoricEra getDefaultMaximum() {
        return HistoricEra.AD;
    }

    public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException {
        appendable.append(accessor(attributeQuery).print((Enum) chronoDisplay.get(this)));
    }

    public HistoricEra parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
        return (HistoricEra) accessor(attributeQuery).parse(charSequence, parsePosition, getType(), attributeQuery);
    }

    /* access modifiers changed from: protected */
    public <T extends ChronoEntity<T>> ElementRule<T, HistoricEra> derive(Chronology<T> chronology) {
        if (chronology.isRegistered(PlainDate.COMPONENT)) {
            return new Rule(this.history);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean doEquals(BasicElement<?> basicElement) {
        return this.history.equals(((HistoricEraElement) basicElement).history);
    }

    private TextAccessor accessor(AttributeQuery attributeQuery) {
        TextWidth textWidth = (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE);
        String str = "w";
        if (((Boolean) attributeQuery.get(HistoricAttribute.LATIN_ERA, Boolean.FALSE)).booleanValue()) {
            CalendarText instance = CalendarText.getInstance("historic", LATIN);
            String[] strArr = new String[1];
            if (textWidth != TextWidth.WIDE) {
                str = "a";
            }
            strArr[0] = str;
            return instance.getTextForms(this, strArr);
        }
        CalendarText isoInstance = CalendarText.getIsoInstance((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT));
        if (!((Boolean) attributeQuery.get(HistoricAttribute.COMMON_ERA, Boolean.FALSE)).booleanValue()) {
            return isoInstance.getEras(textWidth);
        }
        String[] strArr2 = new String[2];
        if (textWidth != TextWidth.WIDE) {
            str = "a";
        }
        strArr2[0] = str;
        strArr2[1] = "alt";
        return isoInstance.getTextForms(this, strArr2);
    }

    private Object readResolve() throws ObjectStreamException {
        return this.history.era();
    }

    private static class Rule<C extends ChronoEntity<C>> implements ElementRule<C, HistoricEra> {
        private final ChronoHistory history;

        Rule(ChronoHistory chronoHistory) {
            this.history = chronoHistory;
        }

        public HistoricEra getValue(C c) {
            try {
                return this.history.convert((PlainDate) c.get(PlainDate.COMPONENT)).getEra();
            } catch (IllegalArgumentException e) {
                throw new ChronoException(e.getMessage(), e);
            }
        }

        public HistoricEra getMinimum(C c) {
            HistoricEra value = getValue(c);
            return value == HistoricEra.AD ? HistoricEra.BC : value;
        }

        public HistoricEra getMaximum(C c) {
            HistoricEra value = getValue(c);
            return value == HistoricEra.BC ? HistoricEra.AD : value;
        }

        public boolean isValid(C c, HistoricEra historicEra) {
            if (historicEra == null) {
                return false;
            }
            try {
                if (this.history.convert((PlainDate) c.get(PlainDate.COMPONENT)).getEra() == historicEra) {
                    return true;
                }
                return false;
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }

        public C withValue(C c, HistoricEra historicEra, boolean z) {
            if (historicEra == null) {
                throw new IllegalArgumentException("Missing era value.");
            } else if (this.history.convert((PlainDate) c.get(PlainDate.COMPONENT)).getEra() == historicEra) {
                return c;
            } else {
                throw new IllegalArgumentException(historicEra.name());
            }
        }

        public ChronoElement<?> getChildAtFloor(C c) {
            throw new UnsupportedOperationException("Never called.");
        }

        public ChronoElement<?> getChildAtCeiling(C c) {
            throw new UnsupportedOperationException("Never called.");
        }
    }
}
