package net.time4j.format.expert;

import java.io.IOException;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.format.Attributes;
import net.time4j.format.Leniency;
import net.time4j.format.NumberType;
import net.time4j.format.PluralCategory;
import net.time4j.format.PluralRules;

final class OrdinalProcessor implements FormatProcessor<Integer> {
    private static final Map<PluralCategory, String> ENGLISH_ORDINALS;
    private final ChronoElement<Integer> element;
    private final Map<PluralCategory, String> indicators;
    private final Leniency lenientMode;
    private final Locale locale;
    private final int protectedLength;
    private final int reserved;
    private final char zeroDigit;

    public boolean isNumerical() {
        return false;
    }

    static {
        EnumMap enumMap = new EnumMap(PluralCategory.class);
        enumMap.put(PluralCategory.ONE, "st");
        enumMap.put(PluralCategory.TWO, "nd");
        enumMap.put(PluralCategory.FEW, "rd");
        enumMap.put(PluralCategory.OTHER, "th");
        ENGLISH_ORDINALS = Collections.unmodifiableMap(enumMap);
    }

    OrdinalProcessor(ChronoElement<Integer> chronoElement, Map<PluralCategory, String> map) {
        Objects.requireNonNull(chronoElement, "Missing element.");
        this.element = chronoElement;
        if (map == null) {
            this.indicators = null;
        } else {
            Map<PluralCategory, String> unmodifiableMap = Collections.unmodifiableMap(new EnumMap(map));
            this.indicators = unmodifiableMap;
            if (!unmodifiableMap.containsKey(PluralCategory.OTHER)) {
                throw new IllegalArgumentException("Missing plural category OTHER: " + map);
            }
        }
        this.reserved = 0;
        this.protectedLength = 0;
        this.zeroDigit = '0';
        this.lenientMode = Leniency.SMART;
        this.locale = Locale.ROOT;
    }

    private OrdinalProcessor(ChronoElement<Integer> chronoElement, Map<PluralCategory, String> map, int i, int i2, char c, Leniency leniency, Locale locale2) {
        this.element = chronoElement;
        this.indicators = map;
        this.reserved = i;
        this.protectedLength = i2;
        this.zeroDigit = c;
        this.lenientMode = leniency;
        this.locale = locale2;
    }

    public int print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, Set<ElementPosition> set, boolean z) throws IOException {
        char c;
        int i = chronoDisplay.getInt(this.element);
        if (i >= 0) {
            String num = Integer.toString(i);
            if (z) {
                c = this.zeroDigit;
            } else {
                c = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, '0')).charValue();
            }
            if (c != '0') {
                int i2 = c - '0';
                char[] charArray = num.toCharArray();
                for (int i3 = 0; i3 < charArray.length; i3++) {
                    charArray[i3] = (char) (charArray[i3] + i2);
                }
                num = new String(charArray);
            }
            int length = appendable instanceof CharSequence ? ((CharSequence) appendable).length() : -1;
            appendable.append(num);
            int length2 = 0 + num.length();
            String indicator = getIndicator(attributeQuery, z, i);
            appendable.append(indicator);
            int length3 = length2 + indicator.length();
            if (!(length == -1 || length3 <= 0 || set == null)) {
                set.add(new ElementPosition(this.element, length, length + length3));
            }
            return length3;
        } else if (i == Integer.MIN_VALUE) {
            return -1;
        } else {
            throw new IllegalArgumentException("Cannot format negative ordinal numbers: " + chronoDisplay);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parse(java.lang.CharSequence r21, net.time4j.format.expert.ParseLog r22, net.time4j.engine.AttributeQuery r23, net.time4j.format.expert.ParsedEntity<?> r24, boolean r25) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r25
            int r5 = r21.length()
            int r6 = r22.getPosition()
            if (r4 == 0) goto L_0x0017
            net.time4j.format.Leniency r7 = r0.lenientMode
            goto L_0x0021
        L_0x0017:
            net.time4j.engine.AttributeKey<net.time4j.format.Leniency> r7 = net.time4j.format.Attributes.LENIENCY
            net.time4j.format.Leniency r8 = net.time4j.format.Leniency.SMART
            java.lang.Object r7 = r3.get(r7, r8)
            net.time4j.format.Leniency r7 = (net.time4j.format.Leniency) r7
        L_0x0021:
            r8 = 0
            if (r4 == 0) goto L_0x0027
            int r9 = r0.protectedLength
            goto L_0x0037
        L_0x0027:
            net.time4j.engine.AttributeKey<java.lang.Integer> r9 = net.time4j.format.Attributes.PROTECTED_CHARACTERS
            java.lang.Integer r10 = java.lang.Integer.valueOf(r8)
            java.lang.Object r9 = r3.get(r9, r10)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
        L_0x0037:
            if (r9 <= 0) goto L_0x003a
            int r5 = r5 - r9
        L_0x003a:
            if (r6 < r5) goto L_0x005a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Missing digits for: "
            r1.append(r3)
            net.time4j.engine.ChronoElement<java.lang.Integer> r3 = r0.element
            java.lang.String r3 = r3.name()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r2.setError(r6, r1)
            r22.setWarning()
            return
        L_0x005a:
            if (r4 == 0) goto L_0x005f
            char r10 = r0.zeroDigit
            goto L_0x0071
        L_0x005f:
            net.time4j.engine.AttributeKey<java.lang.Character> r10 = net.time4j.format.Attributes.ZERO_DIGIT
            r11 = 48
            java.lang.Character r11 = java.lang.Character.valueOf(r11)
            java.lang.Object r10 = r3.get(r10, r11)
            java.lang.Character r10 = (java.lang.Character) r10
            char r10 = r10.charValue()
        L_0x0071:
            int r11 = r0.reserved
            r12 = 9
            if (r11 <= 0) goto L_0x0093
            if (r9 > 0) goto L_0x0093
            r9 = r6
            r11 = 0
        L_0x007b:
            if (r9 >= r5) goto L_0x008b
            char r13 = r1.charAt(r9)
            int r13 = r13 - r10
            if (r13 < 0) goto L_0x008b
            if (r13 > r12) goto L_0x008b
            int r11 = r11 + 1
            int r9 = r9 + 1
            goto L_0x007b
        L_0x008b:
            int r9 = r0.reserved
            int r11 = r11 - r9
            int r9 = java.lang.Math.min(r12, r11)
            goto L_0x0095
        L_0x0093:
            r9 = 9
        L_0x0095:
            int r11 = r6 + 1
            int r9 = r9 + r6
            int r9 = java.lang.Math.min(r5, r9)
            r13 = 0
            r15 = 1
            r8 = r6
        L_0x00a0:
            if (r8 >= r9) goto L_0x00c6
            char r16 = r1.charAt(r8)
            r17 = r9
            int r9 = r16 - r10
            if (r9 < 0) goto L_0x00be
            if (r9 > r12) goto L_0x00be
            r18 = 10
            long r13 = r13 * r18
            r16 = r10
            long r9 = (long) r9
            long r13 = r13 + r9
            int r8 = r8 + 1
            r10 = r16
            r9 = r17
            r15 = 0
            goto L_0x00a0
        L_0x00be:
            if (r15 == 0) goto L_0x00c6
            java.lang.String r1 = "Digit expected."
            r2.setError(r6, r1)
            return
        L_0x00c6:
            if (r8 >= r11) goto L_0x00e3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Not enough digits found for: "
            r1.append(r3)
            net.time4j.engine.ChronoElement<java.lang.Integer> r3 = r0.element
            java.lang.String r3 = r3.name()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r2.setError(r6, r1)
            return
        L_0x00e3:
            int r6 = (int) r13
            java.lang.String r3 = r0.getIndicator(r3, r4, r6)
            int r4 = r3.length()
            int r4 = r4 + r8
            if (r4 < r5) goto L_0x010a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Missing or wrong ordinal indicator for: "
            r1.append(r3)
            net.time4j.engine.ChronoElement<java.lang.Integer> r3 = r0.element
            java.lang.String r3 = r3.name()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r2.setError(r8, r1)
            return
        L_0x010a:
            java.lang.CharSequence r1 = r1.subSequence(r8, r4)
            java.lang.String r1 = r1.toString()
            boolean r5 = r1.equals(r3)
            if (r5 == 0) goto L_0x011a
            r8 = r4
            goto L_0x0150
        L_0x011a:
            boolean r4 = r7.isLax()
            if (r4 != 0) goto L_0x0150
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Wrong ordinal indicator for: "
            r4.append(r5)
            net.time4j.engine.ChronoElement<java.lang.Integer> r5 = r0.element
            java.lang.String r5 = r5.name()
            r4.append(r5)
            java.lang.String r5 = " (expected="
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = ", found="
            r4.append(r3)
            r4.append(r1)
            java.lang.String r1 = ")"
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            r2.setError(r8, r1)
            return
        L_0x0150:
            net.time4j.engine.ChronoElement<java.lang.Integer> r1 = r0.element
            r3 = r24
            r3.put((net.time4j.engine.ChronoElement<?>) r1, (int) r6)
            r2.setPosition(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.expert.OrdinalProcessor.parse(java.lang.CharSequence, net.time4j.format.expert.ParseLog, net.time4j.engine.AttributeQuery, net.time4j.format.expert.ParsedEntity, boolean):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrdinalProcessor)) {
            return false;
        }
        OrdinalProcessor ordinalProcessor = (OrdinalProcessor) obj;
        if (!this.element.equals(ordinalProcessor.element) || !getIndicators().equals(ordinalProcessor.getIndicators())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.element.hashCode() * 7) + (getIndicators().hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(getClass().getName());
        sb.append("[element=");
        sb.append(this.element.name());
        sb.append(", indicators=");
        sb.append(getIndicators());
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    private String getIndicator(AttributeQuery attributeQuery, boolean z, int i) {
        Locale locale2;
        if (isEnglish()) {
            locale2 = Locale.ENGLISH;
        } else {
            locale2 = z ? this.locale : (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT);
        }
        PluralCategory category = PluralRules.of(locale2, NumberType.ORDINALS).getCategory((long) i);
        if (!getIndicators().containsKey(category)) {
            category = PluralCategory.OTHER;
        }
        return getIndicators().get(category);
    }

    private boolean isEnglish() {
        return this.indicators == null;
    }

    private Map<PluralCategory, String> getIndicators() {
        if (isEnglish()) {
            return ENGLISH_ORDINALS;
        }
        return this.indicators;
    }

    public ChronoElement<Integer> getElement() {
        return this.element;
    }

    public FormatProcessor<Integer> withElement(ChronoElement<Integer> chronoElement) {
        if (this.element == chronoElement) {
            return this;
        }
        return new OrdinalProcessor(chronoElement, this.indicators);
    }

    public FormatProcessor<Integer> quickPath(ChronoFormatter<?> chronoFormatter, AttributeQuery attributeQuery, int i) {
        return new OrdinalProcessor(this.element, this.indicators, i, ((Integer) attributeQuery.get(Attributes.PROTECTED_CHARACTERS, 0)).intValue(), ((Character) attributeQuery.get(Attributes.ZERO_DIGIT, '0')).charValue(), (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART), (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT));
    }
}
