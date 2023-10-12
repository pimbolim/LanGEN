package net.time4j.format.expert;

import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.engine.ChronoElement;

public final class ElementPosition {
    private final ChronoElement<?> element;
    private final int endIndex;
    private final int startIndex;

    public ElementPosition(ChronoElement<?> chronoElement, int i, int i2) {
        Objects.requireNonNull(chronoElement, "Missing chronological element.");
        if (i < 0) {
            throw new IllegalArgumentException("Negative start index: " + i + " (" + chronoElement.name() + ")");
        } else if (i2 > i) {
            this.element = chronoElement;
            this.startIndex = i;
            this.endIndex = i2;
        } else {
            throw new IllegalArgumentException("End index " + i2 + " must be greater than start index " + i + " (" + chronoElement.name() + ")");
        }
    }

    public ChronoElement<?> getElement() {
        return this.element;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public int getEndIndex() {
        return this.endIndex;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ElementPosition)) {
            return false;
        }
        ElementPosition elementPosition = (ElementPosition) obj;
        if (this.element.equals(elementPosition.element) && this.startIndex == elementPosition.startIndex && this.endIndex == elementPosition.endIndex) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.element.hashCode() + ((this.startIndex | (this.endIndex << 16)) * 37);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(80);
        sb.append(getClass().getName());
        sb.append("[element=");
        sb.append(this.element.name());
        sb.append(",start-index=");
        sb.append(this.startIndex);
        sb.append(",end-index=");
        sb.append(this.endIndex);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }
}
