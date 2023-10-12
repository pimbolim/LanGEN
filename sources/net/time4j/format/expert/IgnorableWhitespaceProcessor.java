package net.time4j.format.expert;

import java.io.IOException;
import java.util.Set;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;

enum IgnorableWhitespaceProcessor implements FormatProcessor<Void> {
    SINGLETON;

    public ChronoElement<Void> getElement() {
        return null;
    }

    public boolean isNumerical() {
        return false;
    }

    public FormatProcessor<Void> quickPath(ChronoFormatter<?> chronoFormatter, AttributeQuery attributeQuery, int i) {
        return this;
    }

    public String toString() {
        return "{IGNORABLE_WHITE_SPACE}";
    }

    public FormatProcessor<Void> withElement(ChronoElement<Void> chronoElement) {
        return this;
    }

    public int print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, Set<ElementPosition> set, boolean z) throws IOException {
        appendable.append(' ');
        return 1;
    }

    public void parse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, ParsedEntity<?> parsedEntity, boolean z) {
        int position = parseLog.getPosition();
        while (position < charSequence.length() && Character.isWhitespace(charSequence.charAt(position))) {
            position++;
        }
        parseLog.setPosition(position);
    }
}
