package net.time4j.format.expert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.format.Attributes;
import net.time4j.format.Leniency;

final class FractionProcessor implements FormatProcessor<Integer> {
    private static final int MRD_MINUS_1 = 999999999;
    private final FormatProcessor<Void> decimalSeparator;
    private final ChronoElement<Integer> element;
    private final boolean fixedWidth;
    private final Leniency lenientMode;
    private final int maxDigits;
    private final int minDigits;
    private final char zeroDigit;

    public boolean isNumerical() {
        return true;
    }

    FractionProcessor(ChronoElement<Integer> chronoElement, int i, int i2, boolean z) {
        this.element = chronoElement;
        this.minDigits = i;
        this.maxDigits = i2;
        this.fixedWidth = !z && i == i2;
        this.decimalSeparator = z ? new LiteralProcessor(Attributes.DECIMAL_SEPARATOR) : null;
        Objects.requireNonNull(chronoElement, "Missing element.");
        if (i < 0) {
            throw new IllegalArgumentException("Negative min digits: " + i);
        } else if (i > i2) {
            throw new IllegalArgumentException("Max smaller than min: " + i2 + " < " + i);
        } else if (i > 9) {
            throw new IllegalArgumentException("Min digits out of range: " + i);
        } else if (i2 <= 9) {
            this.zeroDigit = '0';
            this.lenientMode = Leniency.SMART;
        } else {
            throw new IllegalArgumentException("Max digits out of range: " + i2);
        }
    }

    private FractionProcessor(FormatProcessor<Void> formatProcessor, ChronoElement<Integer> chronoElement, int i, int i2, boolean z, char c, Leniency leniency) {
        this.decimalSeparator = formatProcessor;
        this.element = chronoElement;
        this.minDigits = i;
        this.maxDigits = i2;
        this.fixedWidth = z;
        this.zeroDigit = c;
        this.lenientMode = leniency;
    }

    public int print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, Set<ElementPosition> set, boolean z) throws IOException {
        BigDecimal bigDecimal;
        char c;
        int i;
        int i2;
        ChronoDisplay chronoDisplay2 = chronoDisplay;
        Appendable appendable2 = appendable;
        Set<ElementPosition> set2 = set;
        BigDecimal decimal = toDecimal((Number) chronoDisplay2.get(this.element));
        BigDecimal decimal2 = toDecimal((Number) chronoDisplay2.getMinimum(this.element));
        BigDecimal decimal3 = toDecimal((Number) chronoDisplay2.getMaximum(this.element));
        if (decimal.compareTo(decimal3) > 0) {
            decimal = decimal3;
        }
        BigDecimal divide = decimal.subtract(decimal2).divide(decimal3.subtract(decimal2).add(BigDecimal.ONE), 9, RoundingMode.FLOOR);
        if (divide.compareTo(BigDecimal.ZERO) == 0) {
            bigDecimal = BigDecimal.ZERO;
        } else {
            bigDecimal = divide.stripTrailingZeros();
        }
        BigDecimal bigDecimal2 = bigDecimal;
        if (z) {
            c = this.zeroDigit;
            AttributeQuery attributeQuery2 = attributeQuery;
        } else {
            c = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, '0')).charValue();
        }
        char c2 = c;
        int length = appendable2 instanceof CharSequence ? ((CharSequence) appendable2).length() : -1;
        int i3 = 0;
        if (bigDecimal2.scale() != 0) {
            if (hasDecimalSeparator()) {
                this.decimalSeparator.print(chronoDisplay, appendable, attributeQuery, set, z);
                i3 = 1;
            }
            String plainString = bigDecimal2.setScale(Math.min(Math.max(bigDecimal2.scale(), this.minDigits), this.maxDigits), RoundingMode.FLOOR).toPlainString();
            int i4 = c2 - '0';
            int length2 = plainString.length();
            for (int i5 = 2; i5 < length2; i5++) {
                appendable2.append((char) (plainString.charAt(i5) + i4));
                i3++;
            }
        } else if (this.minDigits > 0) {
            if (hasDecimalSeparator()) {
                this.decimalSeparator.print(chronoDisplay, appendable, attributeQuery, set, z);
                i = 1;
            } else {
                i = 0;
            }
            while (true) {
                i2 = this.minDigits;
                if (i3 >= i2) {
                    break;
                }
                appendable2.append(c2);
                i3++;
            }
            i3 = i + i2;
        }
        if (!(length == -1 || i3 <= 1 || set2 == null)) {
            set2.add(new ElementPosition(this.element, length + 1, length + i3));
        }
        return i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ff, code lost:
        r2 = new java.math.BigDecimal(r14).movePointLeft(r1 - r21.getPosition());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x011a, code lost:
        if (r0.element.name().equals("NANO_OF_SECOND") == false) goto L_0x012a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x011c, code lost:
        r9.put((net.time4j.engine.ChronoElement<?>) r0.element, getRealValue(r2, 0, 999999999));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x012a, code lost:
        r9.put((net.time4j.engine.ChronoElement<?>) net.time4j.format.expert.FractionalElement.FRACTION, (java.lang.Object) r2);
        r2 = r0.element;
        r9.put((net.time4j.engine.ChronoElement<?>) r2, (java.lang.Object) r2.getDefaultMinimum());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0138, code lost:
        r7.setPosition(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x013b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parse(java.lang.CharSequence r20, net.time4j.format.expert.ParseLog r21, net.time4j.engine.AttributeQuery r22, net.time4j.format.expert.ParsedEntity<?> r23, boolean r24) {
        /*
            r19 = this;
            r0 = r19
            r7 = r21
            r8 = r22
            r9 = r23
            if (r24 == 0) goto L_0x000d
            net.time4j.format.Leniency r1 = r0.lenientMode
            goto L_0x0017
        L_0x000d:
            net.time4j.engine.AttributeKey<net.time4j.format.Leniency> r1 = net.time4j.format.Attributes.LENIENCY
            net.time4j.format.Leniency r2 = net.time4j.format.Leniency.SMART
            java.lang.Object r1 = r8.get(r1, r2)
            net.time4j.format.Leniency r1 = (net.time4j.format.Leniency) r1
        L_0x0017:
            r10 = r1
            boolean r1 = r10.isLax()
            r11 = 9
            if (r1 == 0) goto L_0x0029
            boolean r1 = r0.fixedWidth
            if (r1 == 0) goto L_0x0025
            goto L_0x0029
        L_0x0025:
            r13 = 0
            r14 = 9
            goto L_0x002f
        L_0x0029:
            int r1 = r0.minDigits
            int r2 = r0.maxDigits
            r13 = r1
            r14 = r2
        L_0x002f:
            int r15 = r20.length()
            int r1 = r21.getPosition()
            if (r1 < r15) goto L_0x005a
            if (r13 <= 0) goto L_0x0059
            int r1 = r21.getPosition()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Expected fraction digits not found for: "
            r2.append(r3)
            net.time4j.engine.ChronoElement<java.lang.Integer> r3 = r0.element
            java.lang.String r3 = r3.name()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r7.setError(r1, r2)
        L_0x0059:
            return
        L_0x005a:
            boolean r1 = r19.hasDecimalSeparator()
            if (r1 == 0) goto L_0x007a
            net.time4j.format.expert.FormatProcessor<java.lang.Void> r1 = r0.decimalSeparator
            r5 = 0
            r2 = r20
            r3 = r21
            r4 = r22
            r6 = r24
            r1.parse(r2, r3, r4, r5, r6)
            boolean r1 = r21.isError()
            if (r1 == 0) goto L_0x007a
            if (r13 != 0) goto L_0x0079
            r21.clearError()
        L_0x0079:
            return
        L_0x007a:
            int r1 = r21.getPosition()
            int r2 = r1 + r13
            int r14 = r14 + r1
            int r3 = java.lang.Math.min(r14, r15)
            java.lang.String r4 = " digits."
            java.lang.String r5 = "Expected at least "
            if (r2 <= r15) goto L_0x00ab
            boolean r6 = r10.isStrict()
            if (r6 == 0) goto L_0x00ab
            int r1 = r21.getPosition()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r2.append(r13)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r7.setError(r1, r2)
            return
        L_0x00ab:
            if (r24 == 0) goto L_0x00b0
            char r6 = r0.zeroDigit
            goto L_0x00c2
        L_0x00b0:
            net.time4j.engine.AttributeKey<java.lang.Character> r6 = net.time4j.format.Attributes.ZERO_DIGIT
            r14 = 48
            java.lang.Character r14 = java.lang.Character.valueOf(r14)
            java.lang.Object r6 = r8.get(r6, r14)
            java.lang.Character r6 = (java.lang.Character) r6
            char r6 = r6.charValue()
        L_0x00c2:
            r14 = 0
        L_0x00c4:
            if (r1 >= r3) goto L_0x00ff
            r8 = r20
            char r16 = r8.charAt(r1)
            int r12 = r16 - r6
            if (r12 < 0) goto L_0x00dd
            if (r12 > r11) goto L_0x00dd
            r17 = 10
            long r14 = r14 * r17
            long r11 = (long) r12
            long r14 = r14 + r11
            int r1 = r1 + 1
            r11 = 9
            goto L_0x00c4
        L_0x00dd:
            if (r1 >= r2) goto L_0x00ff
            boolean r2 = r10.isStrict()
            if (r2 == 0) goto L_0x00ff
            int r1 = r21.getPosition()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r2.append(r13)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r7.setError(r1, r2)
            return
        L_0x00ff:
            java.math.BigDecimal r2 = new java.math.BigDecimal
            r2.<init>(r14)
            int r3 = r21.getPosition()
            int r3 = r1 - r3
            java.math.BigDecimal r2 = r2.movePointLeft(r3)
            net.time4j.engine.ChronoElement<java.lang.Integer> r3 = r0.element
            java.lang.String r3 = r3.name()
            java.lang.String r4 = "NANO_OF_SECOND"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x012a
            r3 = 999999999(0x3b9ac9ff, float:0.004723787)
            r4 = 0
            int r2 = r0.getRealValue(r2, r4, r3)
            net.time4j.engine.ChronoElement<java.lang.Integer> r3 = r0.element
            r9.put((net.time4j.engine.ChronoElement<?>) r3, (int) r2)
            goto L_0x0138
        L_0x012a:
            net.time4j.format.expert.FractionalElement r3 = net.time4j.format.expert.FractionalElement.FRACTION
            r9.put((net.time4j.engine.ChronoElement<?>) r3, (java.lang.Object) r2)
            net.time4j.engine.ChronoElement<java.lang.Integer> r2 = r0.element
            java.lang.Object r3 = r2.getDefaultMinimum()
            r9.put((net.time4j.engine.ChronoElement<?>) r2, (java.lang.Object) r3)
        L_0x0138:
            r7.setPosition(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.expert.FractionProcessor.parse(java.lang.CharSequence, net.time4j.format.expert.ParseLog, net.time4j.engine.AttributeQuery, net.time4j.format.expert.ParsedEntity, boolean):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FractionProcessor)) {
            return false;
        }
        FractionProcessor fractionProcessor = (FractionProcessor) obj;
        if (this.element.equals(fractionProcessor.element) && this.minDigits == fractionProcessor.minDigits && this.maxDigits == fractionProcessor.maxDigits && hasDecimalSeparator() == fractionProcessor.hasDecimalSeparator()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.element.hashCode() * 7) + ((this.minDigits + (this.maxDigits * 10)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(getClass().getName());
        sb.append("[element=");
        sb.append(this.element.name());
        sb.append(", min-digits=");
        sb.append(this.minDigits);
        sb.append(", max-digits=");
        sb.append(this.maxDigits);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public ChronoElement<Integer> getElement() {
        return this.element;
    }

    public FormatProcessor<Integer> withElement(ChronoElement<Integer> chronoElement) {
        if (this.element == chronoElement) {
            return this;
        }
        return new FractionProcessor(chronoElement, this.minDigits, this.maxDigits, hasDecimalSeparator());
    }

    public FormatProcessor<Integer> quickPath(ChronoFormatter<?> chronoFormatter, AttributeQuery attributeQuery, int i) {
        return new FractionProcessor(this.decimalSeparator, this.element, this.minDigits, this.maxDigits, this.fixedWidth, ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, '0')).charValue(), (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART));
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [net.time4j.engine.ChronoEntity<?>, net.time4j.engine.ChronoEntity] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.time4j.engine.ChronoEntity<?> update(net.time4j.engine.ChronoEntity<?> r4, net.time4j.engine.ChronoEntity<?> r5) {
        /*
            r3 = this;
            net.time4j.format.expert.FractionalElement r0 = net.time4j.format.expert.FractionalElement.FRACTION
            boolean r0 = r5.contains(r0)
            if (r0 != 0) goto L_0x0009
            return r4
        L_0x0009:
            net.time4j.format.expert.FractionalElement r0 = net.time4j.format.expert.FractionalElement.FRACTION
            java.lang.Object r0 = r5.get(r0)
            java.math.BigDecimal r0 = (java.math.BigDecimal) r0
            net.time4j.engine.ChronoElement<java.lang.Integer> r1 = r3.element
            java.lang.Object r1 = r4.getMinimum(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            net.time4j.engine.ChronoElement<java.lang.Integer> r2 = r3.element
            java.lang.Object r2 = r4.getMaximum(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            int r0 = r3.getRealValue(r0, r1, r2)
            net.time4j.format.expert.FractionalElement r1 = net.time4j.format.expert.FractionalElement.FRACTION
            r2 = 0
            r5.with(r1, r2)
            net.time4j.engine.ChronoElement<java.lang.Integer> r1 = r3.element
            r5.with((net.time4j.engine.ChronoElement<java.lang.Integer>) r1, (int) r0)
            net.time4j.engine.ChronoElement<java.lang.Integer> r5 = r3.element
            net.time4j.engine.ChronoEntity r4 = r4.with((net.time4j.engine.ChronoElement<java.lang.Integer>) r5, (int) r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.expert.FractionProcessor.update(net.time4j.engine.ChronoEntity, net.time4j.engine.ChronoEntity):net.time4j.engine.ChronoEntity");
    }

    private int getRealValue(BigDecimal bigDecimal, int i, int i2) {
        BigDecimal valueOf = BigDecimal.valueOf((long) i);
        return bigDecimal.multiply(BigDecimal.valueOf((long) i2).subtract(valueOf).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(valueOf).intValueExact();
    }

    private static BigDecimal toDecimal(Number number) {
        return BigDecimal.valueOf(number.longValue());
    }

    private boolean hasDecimalSeparator() {
        return this.decimalSeparator != null;
    }
}
