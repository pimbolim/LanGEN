package net.time4j.format.expert;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoCondition;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.format.Attributes;
import net.time4j.format.Leniency;

final class FormatStep {
    private final AttributeQuery fullAttrs;
    private final int lastOrBlockIndex;
    private final int level;
    private final boolean orMarker;
    private final int padLeft;
    private final int padRight;
    private final FormatProcessor<?> processor;
    private final int reserved;
    private final int section;
    private final AttributeSet sectionalAttrs;

    FormatStep(FormatProcessor<?> formatProcessor, int i, int i2, AttributeSet attributeSet) {
        this(formatProcessor, i, i2, attributeSet, (AttributeQuery) null, 0, 0, 0, false, -1);
    }

    private FormatStep(FormatProcessor<?> formatProcessor, int i, int i2, AttributeSet attributeSet, AttributeQuery attributeQuery, int i3, int i4, int i5, boolean z, int i6) {
        Objects.requireNonNull(formatProcessor, "Missing format processor.");
        if (i < 0) {
            throw new IllegalArgumentException("Invalid level: " + i);
        } else if (i2 < 0) {
            throw new IllegalArgumentException("Invalid section: " + i2);
        } else if (i3 < 0) {
            throw new IllegalArgumentException("Reserved chars must not be negative: " + i3);
        } else if (i4 < 0) {
            throw new IllegalArgumentException("Invalid pad-width: " + i4);
        } else if (i5 >= 0) {
            this.processor = formatProcessor;
            this.level = i;
            this.section = i2;
            this.sectionalAttrs = attributeSet;
            this.fullAttrs = attributeQuery;
            this.reserved = i3;
            this.padLeft = i4;
            this.padRight = i5;
            this.orMarker = z;
            this.lastOrBlockIndex = i6;
        } else {
            throw new IllegalArgumentException("Invalid pad-width: " + i5);
        }
    }

    /* access modifiers changed from: package-private */
    public int print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, Set<ElementPosition> set, boolean z) throws IOException {
        int i;
        StringBuilder sb;
        int i2;
        int i3;
        Appendable appendable2 = appendable;
        Set<ElementPosition> set2 = set;
        if (!isPrinting(chronoDisplay)) {
            return 0;
        }
        AttributeQuery query = z ? this.fullAttrs : getQuery(attributeQuery);
        if (this.padLeft == 0 && this.padRight == 0) {
            return this.processor.print(chronoDisplay, appendable, query, set, z);
        }
        LinkedHashSet<ElementPosition> linkedHashSet = null;
        if (appendable2 instanceof StringBuilder) {
            sb = (StringBuilder) appendable2;
            i = sb.length();
        } else {
            sb = new StringBuilder();
            i = -1;
        }
        if (!(appendable2 instanceof CharSequence) || set2 == null) {
            i2 = -1;
        } else {
            if (sb == appendable2) {
                FormatProcessor<?> formatProcessor = this.processor;
                if ((formatProcessor instanceof CustomizedProcessor) || (formatProcessor instanceof StyleProcessor)) {
                    i3 = 0;
                    i2 = i3;
                    linkedHashSet = new LinkedHashSet<>();
                }
            }
            i3 = ((CharSequence) appendable2).length();
            i2 = i3;
            linkedHashSet = new LinkedHashSet<>();
        }
        boolean isStrict = isStrict(query);
        char padChar = getPadChar(query);
        int length = sb.length();
        char c = padChar;
        this.processor.print(chronoDisplay, sb, query, linkedHashSet, z);
        int length2 = sb.length() - length;
        int i4 = this.padLeft;
        if (i4 > 0) {
            if (!isStrict || length2 <= i4) {
                int i5 = length2;
                int i6 = 0;
                while (i5 < this.padLeft) {
                    if (i == -1) {
                        appendable2.append(c);
                    } else {
                        sb.insert(i, c);
                    }
                    i5++;
                    i6++;
                }
                if (i == -1) {
                    appendable2.append(sb);
                }
                if (i2 != -1) {
                    int i7 = i2 + i6;
                    for (ElementPosition elementPosition : linkedHashSet) {
                        set2.add(new ElementPosition(elementPosition.getElement(), elementPosition.getStartIndex() + i7, elementPosition.getEndIndex() + i7));
                    }
                }
                int i8 = this.padRight;
                if (i8 <= 0) {
                    return i5;
                }
                if (!isStrict || length2 <= i8) {
                    while (length2 < this.padRight) {
                        appendable2.append(c);
                        length2++;
                        i5++;
                    }
                    return i5;
                }
                throw new IllegalArgumentException(padExceeded());
            }
            throw new IllegalArgumentException(padExceeded());
        } else if (!isStrict || length2 <= this.padRight) {
            if (i == -1) {
                appendable2.append(sb);
            }
            while (length2 < this.padRight) {
                appendable2.append(c);
                length2++;
            }
            if (i2 != -1) {
                for (ElementPosition elementPosition2 : linkedHashSet) {
                    set2.add(new ElementPosition(elementPosition2.getElement(), elementPosition2.getStartIndex() + i2, elementPosition2.getEndIndex() + i2));
                }
            }
            return length2;
        } else {
            throw new IllegalArgumentException(padExceeded());
        }
    }

    /* access modifiers changed from: package-private */
    public void parse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, ParsedEntity<?> parsedEntity, boolean z) {
        int i;
        int i2;
        AttributeQuery query = z ? this.fullAttrs : getQuery(attributeQuery);
        if (this.padLeft == 0 && this.padRight == 0) {
            doParse(charSequence, parseLog, query, parsedEntity, z);
            return;
        }
        boolean isStrict = isStrict(query);
        char padChar = getPadChar(query);
        int position = parseLog.getPosition();
        int length = charSequence.length();
        int i3 = position;
        while (i3 < length && charSequence.charAt(i3) == padChar) {
            i3++;
        }
        int i4 = i3 - position;
        if (!isStrict || i4 <= this.padLeft) {
            parseLog.setPosition(i3);
            doParse(charSequence, parseLog, query, parsedEntity, z);
            if (!parseLog.isError()) {
                int position2 = parseLog.getPosition();
                int i5 = (position2 - position) - i4;
                if (!isStrict || (i2 = this.padLeft) <= 0 || i4 + i5 == i2) {
                    int i6 = 0;
                    while (position2 < length && ((!isStrict || i5 + i6 < this.padRight) && charSequence.charAt(position2) == padChar)) {
                        position2++;
                        i6++;
                    }
                    if (!isStrict || (i = this.padRight) <= 0 || i5 + i6 == i) {
                        parseLog.setPosition(position2);
                    } else {
                        parseLog.setError(position2 - i6, padMismatched());
                    }
                } else {
                    parseLog.setError(position, padMismatched());
                }
            }
        } else {
            parseLog.setError(position, padExceeded());
        }
    }

    /* access modifiers changed from: package-private */
    public int getLevel() {
        return this.level;
    }

    /* access modifiers changed from: package-private */
    public int getSection() {
        return this.section;
    }

    /* access modifiers changed from: package-private */
    public boolean isDecimal() {
        FormatProcessor<?> formatProcessor = this.processor;
        return (formatProcessor instanceof FractionProcessor) || (formatProcessor instanceof DecimalProcessor);
    }

    /* access modifiers changed from: package-private */
    public boolean isNumerical() {
        return this.processor.isNumerical();
    }

    /* access modifiers changed from: package-private */
    public FormatProcessor<?> getProcessor() {
        return this.processor;
    }

    /* access modifiers changed from: package-private */
    public FormatStep quickPath(ChronoFormatter<?> chronoFormatter) {
        AttributeSet attributes0 = chronoFormatter.getAttributes0();
        if (this.sectionalAttrs != null) {
            attributes0 = attributes0.withAttributes(new Attributes.Builder().setAll(attributes0.getAttributes()).setAll(this.sectionalAttrs.getAttributes()).build());
        }
        AttributeSet attributeSet = attributes0;
        return new FormatStep(this.processor.quickPath(chronoFormatter, attributeSet, this.reserved), this.level, this.section, this.sectionalAttrs, attributeSet, this.reserved, this.padLeft, this.padRight, this.orMarker, this.lastOrBlockIndex);
    }

    /* access modifiers changed from: package-private */
    public FormatStep updateElement(ChronoElement<?> chronoElement) {
        FormatProcessor<?> update = update(this.processor, chronoElement);
        if (this.processor == update) {
            return this;
        }
        return new FormatStep(update, this.level, this.section, this.sectionalAttrs, this.fullAttrs, this.reserved, this.padLeft, this.padRight, this.orMarker, this.lastOrBlockIndex);
    }

    /* access modifiers changed from: package-private */
    public FormatStep reserve(int i) {
        return new FormatStep(this.processor, this.level, this.section, this.sectionalAttrs, (AttributeQuery) null, this.reserved + i, this.padLeft, this.padRight, this.orMarker, this.lastOrBlockIndex);
    }

    /* access modifiers changed from: package-private */
    public FormatStep pad(int i, int i2) {
        return new FormatStep(this.processor, this.level, this.section, this.sectionalAttrs, (AttributeQuery) null, this.reserved, this.padLeft + i, this.padRight + i2, this.orMarker, this.lastOrBlockIndex);
    }

    /* access modifiers changed from: package-private */
    public FormatStep startNewOrBlock() {
        if (!this.orMarker) {
            return new FormatStep(this.processor, this.level, this.section, this.sectionalAttrs, (AttributeQuery) null, this.reserved, this.padLeft, this.padRight, true, -1);
        }
        throw new IllegalStateException("Cannot start or-block twice.");
    }

    /* access modifiers changed from: package-private */
    public FormatStep markLastOrBlock(int i) {
        if (this.orMarker) {
            return new FormatStep(this.processor, this.level, this.section, this.sectionalAttrs, this.fullAttrs, this.reserved, this.padLeft, this.padRight, true, i);
        }
        throw new IllegalStateException("This step is not starting an or-block.");
    }

    /* access modifiers changed from: package-private */
    public boolean isNewOrBlockStarted() {
        return this.orMarker;
    }

    /* access modifiers changed from: package-private */
    public int skipTrailingOrBlocks() {
        return this.lastOrBlockIndex;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FormatStep)) {
            return false;
        }
        FormatStep formatStep = (FormatStep) obj;
        if (this.processor.equals(formatStep.processor) && this.level == formatStep.level && this.section == formatStep.section && isEqual(this.sectionalAttrs, formatStep.sectionalAttrs) && isEqual(this.fullAttrs, formatStep.fullAttrs) && this.reserved == formatStep.reserved && this.padLeft == formatStep.padLeft && this.padRight == formatStep.padRight && this.orMarker == formatStep.orMarker && this.lastOrBlockIndex == formatStep.lastOrBlockIndex) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i;
        int hashCode = this.processor.hashCode() * 7;
        AttributeSet attributeSet = this.sectionalAttrs;
        if (attributeSet == null) {
            i = 0;
        } else {
            i = attributeSet.hashCode();
        }
        return hashCode + (i * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[processor=");
        sb.append(this.processor);
        sb.append(", level=");
        sb.append(this.level);
        sb.append(", section=");
        sb.append(this.section);
        if (this.sectionalAttrs != null) {
            sb.append(", attributes=");
            sb.append(this.sectionalAttrs);
        }
        sb.append(", reserved=");
        sb.append(this.reserved);
        sb.append(", pad-left=");
        sb.append(this.padLeft);
        sb.append(", pad-right=");
        sb.append(this.padRight);
        if (this.orMarker) {
            sb.append(", or-block-started");
        }
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    private AttributeQuery getQuery(AttributeQuery attributeQuery) {
        AttributeSet attributeSet = this.sectionalAttrs;
        if (attributeSet == null) {
            return attributeQuery;
        }
        return new MergedAttributes(attributeSet, attributeQuery);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [net.time4j.engine.ChronoElement, net.time4j.engine.ChronoElement<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <V> net.time4j.format.expert.FormatProcessor<V> update(net.time4j.format.expert.FormatProcessor<V> r2, net.time4j.engine.ChronoElement<?> r3) {
        /*
            net.time4j.engine.ChronoElement r0 = r2.getElement()
            if (r0 != 0) goto L_0x0007
            return r2
        L_0x0007:
            net.time4j.engine.ChronoElement r0 = r2.getElement()
            java.lang.Class r0 = r0.getType()
            java.lang.Class r1 = r3.getType()
            if (r0 == r1) goto L_0x0035
            boolean r0 = r3 instanceof net.time4j.format.internal.DualFormatElement
            if (r0 == 0) goto L_0x001a
            goto L_0x0035
        L_0x001a:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Cannot change element value type: "
            r0.append(r1)
            java.lang.String r3 = r3.name()
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r2.<init>(r3)
            throw r2
        L_0x0035:
            net.time4j.format.expert.FormatProcessor r2 = r2.withElement(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.expert.FormatStep.update(net.time4j.format.expert.FormatProcessor, net.time4j.engine.ChronoElement):net.time4j.format.expert.FormatProcessor");
    }

    private static boolean isEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private void doParse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, ParsedEntity<?> parsedEntity, boolean z) {
        int position = parseLog.getPosition();
        try {
            this.processor.parse(charSequence, parseLog, attributeQuery, parsedEntity, z);
        } catch (RuntimeException e) {
            parseLog.setError(position, e.getMessage());
        }
    }

    private boolean isStrict(AttributeQuery attributeQuery) {
        return ((Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART)).isStrict();
    }

    private char getPadChar(AttributeQuery attributeQuery) {
        return ((Character) attributeQuery.get(Attributes.PAD_CHAR, ' ')).charValue();
    }

    private String padExceeded() {
        return "Pad width exceeded: " + this.processor.getElement().name();
    }

    private String padMismatched() {
        return "Pad width mismatched: " + this.processor.getElement().name();
    }

    private boolean isPrinting(ChronoDisplay chronoDisplay) {
        ChronoCondition<ChronoDisplay> condition;
        AttributeSet attributeSet = this.sectionalAttrs;
        if (attributeSet == null || (condition = attributeSet.getCondition()) == null || condition.test(chronoDisplay)) {
            return true;
        }
        return false;
    }
}
