package net.time4j.format.expert;

import java.io.IOException;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.format.Attributes;

final class LookupProcessor<V> implements FormatProcessor<V> {
    private final boolean caseInsensitive;
    private final ChronoElement<V> element;
    private final Locale locale;
    private final int protectedLength;
    private final Map<V, String> resources;

    public boolean isNumerical() {
        return false;
    }

    LookupProcessor(ChronoElement<V> chronoElement, Map<V, String> map) {
        Map<V, String> map2;
        Class<V> type = chronoElement.getType();
        if (!type.isEnum()) {
            map2 = new HashMap<>(map.size());
        } else if (map.size() >= type.getEnumConstants().length) {
            map2 = createMap(type);
        } else {
            throw new IllegalArgumentException("Not enough text resources defined for enum: " + type.getName());
        }
        map2.putAll(map);
        this.element = chronoElement;
        this.resources = Collections.unmodifiableMap(map2);
        this.protectedLength = 0;
        this.caseInsensitive = true;
        this.locale = Locale.getDefault();
    }

    private LookupProcessor(ChronoElement<V> chronoElement, Map<V, String> map, int i, boolean z, Locale locale2) {
        this.element = chronoElement;
        this.resources = map;
        this.protectedLength = i;
        this.caseInsensitive = z;
        this.locale = locale2;
    }

    public int print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, Set<ElementPosition> set, boolean z) throws IOException {
        if (!(appendable instanceof CharSequence)) {
            return print(chronoDisplay, appendable);
        }
        CharSequence charSequence = (CharSequence) appendable;
        int length = charSequence.length();
        int print = print(chronoDisplay, appendable);
        if (set != null) {
            set.add(new ElementPosition(this.element, length, charSequence.length()));
        }
        return print;
    }

    public void parse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, ParsedEntity<?> parsedEntity, boolean z) {
        boolean z2;
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
        if (z) {
            z2 = this.caseInsensitive;
        } else {
            z2 = ((Boolean) attributeQuery.get(Attributes.PARSE_CASE_INSENSITIVE, Boolean.TRUE)).booleanValue();
        }
        Locale locale2 = z ? this.locale : (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.getDefault());
        int i = length - position;
        for (V next : this.resources.keySet()) {
            String string = getString(next);
            if (z2) {
                String upperCase = string.toUpperCase(locale2);
                int length2 = string.length();
                if (length2 <= i) {
                    int i2 = length2 + position;
                    if (upperCase.equals(charSequence.subSequence(position, i2).toString().toUpperCase(locale2))) {
                        parsedEntity.put((ChronoElement<?>) this.element, (Object) next);
                        parseLog.setPosition(i2);
                        return;
                    }
                } else {
                    continue;
                }
            } else {
                int length3 = string.length();
                if (length3 <= i) {
                    int i3 = length3 + position;
                    if (string.equals(charSequence.subSequence(position, i3).toString())) {
                        parsedEntity.put((ChronoElement<?>) this.element, (Object) next);
                        parseLog.setPosition(i3);
                        return;
                    }
                } else {
                    continue;
                }
            }
        }
        parseLog.setError(position, "Element value could not be parsed: " + this.element.name());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LookupProcessor)) {
            return false;
        }
        LookupProcessor lookupProcessor = (LookupProcessor) obj;
        if (!this.element.equals(lookupProcessor.element) || !this.resources.equals(lookupProcessor.resources)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.element.hashCode() * 7) + (this.resources.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(512);
        sb.append(getClass().getName());
        sb.append("[element=");
        sb.append(this.element.name());
        sb.append(", resources=");
        sb.append(this.resources);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public ChronoElement<V> getElement() {
        return this.element;
    }

    public FormatProcessor<V> withElement(ChronoElement<V> chronoElement) {
        if (this.element == chronoElement) {
            return this;
        }
        return new LookupProcessor(chronoElement, this.resources);
    }

    public FormatProcessor<V> quickPath(ChronoFormatter<?> chronoFormatter, AttributeQuery attributeQuery, int i) {
        return new LookupProcessor(this.element, this.resources, ((Integer) attributeQuery.get(Attributes.PROTECTED_CHARACTERS, 0)).intValue(), ((Boolean) attributeQuery.get(Attributes.PARSE_CASE_INSENSITIVE, Boolean.TRUE)).booleanValue(), (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.getDefault()));
    }

    private int print(ChronoDisplay chronoDisplay, Appendable appendable) throws IOException {
        String string = getString(chronoDisplay.get(this.element));
        appendable.append(string);
        return string.length();
    }

    private String getString(V v) {
        String str = this.resources.get(v);
        return str == null ? v.toString() : str;
    }

    private static <V, K extends Enum<K>> Map<V, String> createMap(Class<V> cls) {
        return new EnumMap(cls);
    }
}
