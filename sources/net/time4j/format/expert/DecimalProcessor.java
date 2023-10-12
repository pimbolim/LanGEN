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

final class DecimalProcessor implements FormatProcessor<BigDecimal> {
    private final FormatProcessor<Void> decimalSeparator;
    private final ChronoElement<BigDecimal> element;
    private final Leniency lenientMode;
    private final int precision;
    private final int protectedLength;
    private final int scale;
    private final char zeroDigit;

    public boolean isNumerical() {
        return true;
    }

    DecimalProcessor(ChronoElement<BigDecimal> chronoElement, int i, int i2) {
        this.decimalSeparator = new LiteralProcessor(Attributes.DECIMAL_SEPARATOR);
        this.element = chronoElement;
        this.precision = i;
        this.scale = i2;
        Objects.requireNonNull(chronoElement, "Missing element.");
        if (i < 2) {
            throw new IllegalArgumentException("Precision must be >= 2: " + i);
        } else if (i2 >= i) {
            throw new IllegalArgumentException("Precision must be bigger than scale: " + i + "," + i2);
        } else if (i2 >= 1) {
            this.zeroDigit = '0';
            this.lenientMode = Leniency.SMART;
            this.protectedLength = 0;
        } else {
            throw new IllegalArgumentException("Scale must be bigger than zero.");
        }
    }

    private DecimalProcessor(FormatProcessor<Void> formatProcessor, ChronoElement<BigDecimal> chronoElement, int i, int i2, char c, Leniency leniency, int i3) {
        this.decimalSeparator = formatProcessor;
        this.element = chronoElement;
        this.precision = i;
        this.scale = i2;
        this.zeroDigit = c;
        this.lenientMode = leniency;
        this.protectedLength = i3;
    }

    public int print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, Set<ElementPosition> set, boolean z) throws IOException {
        char c;
        Appendable appendable2 = appendable;
        Set<ElementPosition> set2 = set;
        String plainString = ((BigDecimal) chronoDisplay.get(this.element)).setScale(this.scale, RoundingMode.FLOOR).toPlainString();
        int length = plainString.length();
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (plainString.charAt(i4) == '.') {
                i = i4;
            } else if (i >= 0) {
                i3++;
            } else {
                i2++;
            }
        }
        int i5 = this.precision;
        int i6 = (i5 - this.scale) - i2;
        if (i6 >= 0) {
            StringBuilder sb = new StringBuilder(i5 + 1);
            for (int i7 = 0; i7 < i6; i7++) {
                sb.append('0');
            }
            for (int i8 = 0; i8 < i2; i8++) {
                sb.append(plainString.charAt(i8));
            }
            this.decimalSeparator.print(chronoDisplay, sb, attributeQuery, set, z);
            for (int i9 = 0; i9 < i3; i9++) {
                sb.append(plainString.charAt(i2 + 1 + i9));
            }
            for (int i10 = 0; i10 < this.scale - i3; i10++) {
                sb.append('0');
            }
            String sb2 = sb.toString();
            if (z) {
                c = this.zeroDigit;
            } else {
                c = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, '0')).charValue();
            }
            if (c != '0') {
                int i11 = c - '0';
                char[] charArray = sb2.toCharArray();
                for (int i12 = 0; i12 < charArray.length; i12++) {
                    char c2 = charArray[i12];
                    if (c2 >= '0' && c2 <= '9') {
                        charArray[i12] = (char) (c2 + i11);
                    }
                }
                sb2 = new String(charArray);
            }
            int length2 = sb2.length();
            int length3 = appendable2 instanceof CharSequence ? ((CharSequence) appendable2).length() : -1;
            appendable2.append(sb2);
            if (!(length3 == -1 || length2 <= 0 || set2 == null)) {
                set2.add(new ElementPosition(this.element, length3, length3 + length2));
            }
            return length2;
        }
        throw new IllegalArgumentException("Integer part of element value exceeds fixed format width: " + plainString);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parse(java.lang.CharSequence r23, net.time4j.format.expert.ParseLog r24, net.time4j.engine.AttributeQuery r25, net.time4j.format.expert.ParsedEntity<?> r26, boolean r27) {
        /*
            r22 = this;
            r0 = r22
            r7 = r23
            r8 = r24
            r4 = r25
            int r1 = r23.length()
            int r2 = r24.getPosition()
            r9 = 0
            if (r27 == 0) goto L_0x0016
            int r3 = r0.protectedLength
            goto L_0x0026
        L_0x0016:
            net.time4j.engine.AttributeKey<java.lang.Integer> r3 = net.time4j.format.Attributes.PROTECTED_CHARACTERS
            java.lang.Integer r5 = java.lang.Integer.valueOf(r9)
            java.lang.Object r3 = r4.get(r3, r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
        L_0x0026:
            if (r3 <= 0) goto L_0x0029
            int r1 = r1 - r3
        L_0x0029:
            r10 = r1
            if (r2 < r10) goto L_0x004a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Missing digits for: "
            r1.append(r3)
            net.time4j.engine.ChronoElement<java.math.BigDecimal> r3 = r0.element
            java.lang.String r3 = r3.name()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r8.setError(r2, r1)
            r24.setWarning()
            return
        L_0x004a:
            if (r27 == 0) goto L_0x004f
            char r1 = r0.zeroDigit
            goto L_0x0061
        L_0x004f:
            net.time4j.engine.AttributeKey<java.lang.Character> r1 = net.time4j.format.Attributes.ZERO_DIGIT
            r3 = 48
            java.lang.Character r3 = java.lang.Character.valueOf(r3)
            java.lang.Object r1 = r4.get(r1, r3)
            java.lang.Character r1 = (java.lang.Character) r1
            char r1 = r1.charValue()
        L_0x0061:
            r11 = r1
            int r1 = r2 + 18
            int r1 = java.lang.Math.min(r10, r1)
            r14 = 1
            r3 = 0
            r5 = 1
            r12 = 0
        L_0x006d:
            int r6 = r2 + r3
            r17 = 10
            r9 = 9
            if (r6 >= r1) goto L_0x0090
            char r19 = r7.charAt(r6)
            int r15 = r19 - r11
            if (r15 < 0) goto L_0x0088
            if (r15 > r9) goto L_0x0088
            long r12 = r12 * r17
            long r5 = (long) r15
            long r12 = r12 + r5
            int r3 = r3 + 1
            r5 = 0
            r9 = 0
            goto L_0x006d
        L_0x0088:
            if (r5 == 0) goto L_0x0090
            java.lang.String r1 = "Digit expected."
            r8.setError(r2, r1)
            return
        L_0x0090:
            if (r27 == 0) goto L_0x0095
            net.time4j.format.Leniency r1 = r0.lenientMode
            goto L_0x009f
        L_0x0095:
            net.time4j.engine.AttributeKey<net.time4j.format.Leniency> r1 = net.time4j.format.Attributes.LENIENCY
            net.time4j.format.Leniency r5 = net.time4j.format.Leniency.SMART
            java.lang.Object r1 = r4.get(r1, r5)
            net.time4j.format.Leniency r1 = (net.time4j.format.Leniency) r1
        L_0x009f:
            r15 = r1
            boolean r1 = r15.isLax()
            if (r1 != 0) goto L_0x00b3
            int r1 = r0.precision
            int r5 = r0.scale
            int r1 = r1 - r5
            if (r3 == r1) goto L_0x00b3
            java.lang.String r1 = "Integer part of decimal element does not match expected width."
            r8.setError(r2, r1)
            return
        L_0x00b3:
            r8.setPosition(r6)
            net.time4j.format.expert.FormatProcessor<java.lang.Void> r1 = r0.decimalSeparator
            r5 = 0
            r2 = r23
            r3 = r24
            r4 = r25
            r16 = r6
            r6 = r27
            r1.parse(r2, r3, r4, r5, r6)
            boolean r1 = r24.isError()
            if (r1 == 0) goto L_0x00cd
            return
        L_0x00cd:
            int r6 = r16 + 1
            int r1 = r6 + 18
            int r1 = java.lang.Math.min(r10, r1)
            r2 = 0
            r20 = 0
        L_0x00d8:
            int r3 = r6 + r2
            if (r3 >= r1) goto L_0x00ed
            char r4 = r7.charAt(r3)
            int r4 = r4 - r11
            if (r4 < 0) goto L_0x00ed
            if (r4 > r9) goto L_0x00ed
            long r20 = r20 * r17
            long r3 = (long) r4
            long r20 = r20 + r3
            int r2 = r2 + 1
            goto L_0x00d8
        L_0x00ed:
            if (r2 != 0) goto L_0x00f5
            java.lang.String r1 = "Fraction part expected."
            r8.setError(r6, r1)
            return
        L_0x00f5:
            boolean r1 = r15.isStrict()
            if (r1 == 0) goto L_0x0105
            int r1 = r0.scale
            if (r2 == r1) goto L_0x0105
            java.lang.String r1 = "Fraction part of decimal element does not match expected width."
            r8.setError(r6, r1)
            return
        L_0x0105:
            r8.setPosition(r3)
            java.math.BigDecimal r1 = new java.math.BigDecimal
            r1.<init>(r12)
            java.math.BigDecimal r3 = new java.math.BigDecimal
            java.math.BigInteger r4 = java.math.BigInteger.valueOf(r20)
            r3.<init>(r4, r2)
            java.math.BigDecimal r1 = r1.add(r3)
            java.math.BigDecimal r1 = r1.stripTrailingZeros()
            net.time4j.engine.ChronoElement<java.math.BigDecimal> r2 = r0.element
            r3 = r26
            r3.put((net.time4j.engine.ChronoElement<?>) r2, (java.lang.Object) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.expert.DecimalProcessor.parse(java.lang.CharSequence, net.time4j.format.expert.ParseLog, net.time4j.engine.AttributeQuery, net.time4j.format.expert.ParsedEntity, boolean):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DecimalProcessor)) {
            return false;
        }
        DecimalProcessor decimalProcessor = (DecimalProcessor) obj;
        if (this.element.equals(decimalProcessor.element) && this.precision == decimalProcessor.precision && this.scale == decimalProcessor.scale) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.element.hashCode() * 7) + ((this.scale + (this.precision * 10)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(getClass().getName());
        sb.append("[element=");
        sb.append(this.element.name());
        sb.append(", precision=");
        sb.append(this.precision);
        sb.append(", scale=");
        sb.append(this.scale);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public ChronoElement<BigDecimal> getElement() {
        return this.element;
    }

    public FormatProcessor<BigDecimal> withElement(ChronoElement<BigDecimal> chronoElement) {
        if (this.element == chronoElement) {
            return this;
        }
        return new DecimalProcessor(chronoElement, this.precision, this.scale);
    }

    public FormatProcessor<BigDecimal> quickPath(ChronoFormatter<?> chronoFormatter, AttributeQuery attributeQuery, int i) {
        return new DecimalProcessor(this.decimalSeparator, this.element, this.precision, this.scale, ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, '0')).charValue(), (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART), ((Integer) attributeQuery.get(Attributes.PROTECTED_CHARACTERS, 0)).intValue());
    }
}
