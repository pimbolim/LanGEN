package net.time4j.format.expert;

import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.Month;
import net.time4j.PlainDate;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.format.Attributes;
import net.time4j.format.Leniency;
import net.time4j.format.OutputContext;
import net.time4j.format.TextElement;
import net.time4j.format.TextWidth;
import net.time4j.format.internal.DualFormatElement;
import net.time4j.format.internal.GregorianTextElement;

final class TextProcessor<V> implements FormatProcessor<V> {
    private final TextElement<V> element;
    private final GregorianTextElement<V> gte;
    private final Locale language;
    private final Leniency lenientMode;
    private final OutputContext oc;
    private final int protectedLength;
    private final boolean protectedMode;
    private final TextWidth tw;

    public boolean isNumerical() {
        return false;
    }

    private TextProcessor(TextElement<V> textElement, boolean z, Locale locale, TextWidth textWidth, OutputContext outputContext, Leniency leniency, int i) {
        Objects.requireNonNull(textElement, "Missing element.");
        this.element = textElement;
        this.protectedMode = z;
        this.gte = textElement instanceof GregorianTextElement ? (GregorianTextElement) textElement : null;
        this.language = locale;
        this.tw = textWidth;
        this.oc = outputContext;
        this.lenientMode = leniency;
        this.protectedLength = i;
    }

    static <V> TextProcessor<V> create(TextElement<V> textElement) {
        return new TextProcessor(textElement, false, Locale.ROOT, TextWidth.WIDE, OutputContext.FORMAT, Leniency.SMART, 0);
    }

    static <V> TextProcessor<V> createProtected(TextElement<V> textElement) {
        return new TextProcessor(textElement, true, Locale.ROOT, TextWidth.WIDE, OutputContext.FORMAT, Leniency.SMART, 0);
    }

    public int print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, Set<ElementPosition> set, boolean z) throws IOException {
        if (!(appendable instanceof CharSequence)) {
            return print(chronoDisplay, appendable, attributeQuery, z) ? Integer.MAX_VALUE : -1;
        }
        CharSequence charSequence = (CharSequence) appendable;
        int length = charSequence.length();
        if (!print(chronoDisplay, appendable, attributeQuery, z)) {
            return -1;
        }
        if (set != null) {
            set.add(new ElementPosition(this.element, length, charSequence.length()));
        }
        return charSequence.length() - length;
    }

    public void parse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, ParsedEntity<?> parsedEntity, boolean z) {
        V v;
        GregorianTextElement<V> gregorianTextElement;
        int position = parseLog.getPosition();
        int length = charSequence.length();
        int intValue = z ? this.protectedLength : ((Integer) attributeQuery.get(Attributes.PROTECTED_CHARACTERS, 0)).intValue();
        if (intValue > 0) {
            length -= intValue;
        }
        if (position >= length) {
            parseLog.setError(position, "Missing chars for: " + this.element.name());
            parseLog.setWarning();
            return;
        }
        if (!z || (gregorianTextElement = this.gte) == null || this.lenientMode == null) {
            TextElement<V> textElement = this.element;
            if (textElement instanceof DualFormatElement) {
                v = ((DualFormatElement) textElement).parse(charSequence, parseLog.getPP(), attributeQuery, parsedEntity);
            } else {
                v = textElement.parse(charSequence, parseLog.getPP(), attributeQuery);
            }
        } else {
            v = gregorianTextElement.parse(charSequence, parseLog.getPP(), this.language, this.tw, this.oc, this.lenientMode);
        }
        if (parseLog.isError()) {
            Class<V> type = this.element.getType();
            if (type.isEnum()) {
                int errorIndex = parseLog.getErrorIndex();
                parseLog.setError(errorIndex, "No suitable enum found: " + type.getName());
                return;
            }
            int errorIndex2 = parseLog.getErrorIndex();
            parseLog.setError(errorIndex2, "Unparseable element: " + this.element.name());
        } else if (v == null) {
            parseLog.setError(position, "No interpretable value.");
        } else if (this.element == PlainDate.MONTH_OF_YEAR) {
            parsedEntity.put((ChronoElement<?>) PlainDate.MONTH_AS_NUMBER, Month.class.cast(v).getValue());
        } else {
            parsedEntity.put((ChronoElement<?>) this.element, (Object) v);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextProcessor)) {
            return false;
        }
        TextProcessor textProcessor = (TextProcessor) obj;
        if (!this.element.equals(textProcessor.element) || this.protectedMode != textProcessor.protectedMode) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.element.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(getClass().getName());
        sb.append("[element=");
        sb.append(this.element.name());
        sb.append(",protected-mode=");
        sb.append(this.protectedMode);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public ChronoElement<V> getElement() {
        return this.element;
    }

    public FormatProcessor<V> withElement(ChronoElement<V> chronoElement) {
        if (this.protectedMode || this.element == chronoElement) {
            return this;
        }
        if (chronoElement instanceof TextElement) {
            return create((TextElement) chronoElement);
        }
        throw new IllegalArgumentException("Text element required: " + chronoElement.getClass().getName());
    }

    public FormatProcessor<V> quickPath(ChronoFormatter<?> chronoFormatter, AttributeQuery attributeQuery, int i) {
        Leniency leniency;
        Leniency leniency2 = (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART);
        boolean booleanValue = ((Boolean) attributeQuery.get(Attributes.PARSE_MULTIPLE_CONTEXT, Boolean.TRUE)).booleanValue();
        boolean booleanValue2 = ((Boolean) attributeQuery.get(Attributes.PARSE_CASE_INSENSITIVE, Boolean.TRUE)).booleanValue();
        boolean booleanValue3 = ((Boolean) attributeQuery.get(Attributes.PARSE_PARTIAL_COMPARE, Boolean.FALSE)).booleanValue();
        if ((leniency2 != Leniency.STRICT || (!booleanValue && !booleanValue2 && !booleanValue3)) && ((leniency2 != Leniency.SMART || (booleanValue && booleanValue2 && !booleanValue3)) && booleanValue && booleanValue2 && booleanValue3)) {
            leniency = leniency2;
        } else {
            leniency = null;
        }
        return new TextProcessor(this.element, this.protectedMode, (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT), (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE), (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT), leniency, ((Integer) attributeQuery.get(Attributes.PROTECTED_CHARACTERS, 0)).intValue());
    }

    private boolean print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, boolean z) throws IOException {
        GregorianTextElement<V> gregorianTextElement = this.gte;
        if (gregorianTextElement != null && z) {
            gregorianTextElement.print(chronoDisplay, appendable, this.language, this.tw, this.oc);
            return true;
        } else if (!chronoDisplay.contains(this.element)) {
            return false;
        } else {
            this.element.print(chronoDisplay, appendable, attributeQuery);
            return true;
        }
    }
}
