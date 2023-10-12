package net.time4j.format.expert;

import java.io.IOException;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;

final class LiteralProcessor implements FormatProcessor<Void> {
    private final char alt;
    private final AttributeKey<Character> attribute;
    private final boolean caseInsensitive;
    private final boolean interpunctuationMode;
    private final String multi;
    private final boolean rtl;
    private final char single;

    private static boolean isBidi(char c) {
        return c == 8206 || c == 8207 || c == 1564;
    }

    public ChronoElement<Void> getElement() {
        return null;
    }

    public FormatProcessor<Void> withElement(ChronoElement<Void> chronoElement) {
        return this;
    }

    LiteralProcessor(String str) {
        if (!str.isEmpty()) {
            char charAt = str.charAt(0);
            this.single = charAt;
            this.alt = charAt;
            this.attribute = null;
            this.multi = str;
            if (charAt >= ' ') {
                boolean z = true;
                this.caseInsensitive = true;
                this.interpunctuationMode = (str.length() != 1 || !isInterpunctuation(charAt)) ? false : z;
                this.rtl = false;
                return;
            }
            throw new IllegalArgumentException("Literal must not start with non-printable char.");
        }
        throw new IllegalArgumentException("Missing literal.");
    }

    LiteralProcessor(char c, char c2) {
        this.single = c;
        this.alt = c2;
        this.attribute = null;
        this.multi = null;
        if (c < ' ' || c2 < ' ') {
            throw new IllegalArgumentException("Literal must not start with non-printable char.");
        } else if (Character.isDigit(c) || Character.isDigit(c2)) {
            throw new IllegalArgumentException("Literal must not be a decimal digit.");
        } else {
            this.caseInsensitive = true;
            this.interpunctuationMode = false;
            this.rtl = false;
        }
    }

    LiteralProcessor(AttributeKey<Character> attributeKey) {
        Objects.requireNonNull(attributeKey, "Missing format attribute.");
        this.single = 0;
        this.alt = 0;
        this.attribute = attributeKey;
        this.multi = null;
        this.caseInsensitive = true;
        this.interpunctuationMode = false;
        this.rtl = false;
    }

    private LiteralProcessor(char c, char c2, String str, AttributeKey<Character> attributeKey, boolean z, boolean z2, boolean z3) {
        this.single = c;
        this.alt = c2;
        this.multi = str;
        this.attribute = attributeKey;
        this.caseInsensitive = z;
        this.interpunctuationMode = z2;
        this.rtl = z3;
    }

    public int print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, Set<ElementPosition> set, boolean z) throws IOException {
        AttributeKey attributeKey = this.attribute;
        if (attributeKey != null) {
            appendable.append(((Character) attributeQuery.get(attributeKey, null)).charValue());
            return 1;
        }
        String str = this.multi;
        if (str == null) {
            appendable.append(this.single);
            return 1;
        }
        appendable.append(str);
        return this.multi.length();
    }

    public void parse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, ParsedEntity<?> parsedEntity, boolean z) {
        if (z && this.interpunctuationMode) {
            int position = parseLog.getPosition();
            if (position < charSequence.length() && charSequence.charAt(position) == this.single) {
                parseLog.setPosition(position + 1);
            } else if (this.single != '.' || !((Boolean) attributeQuery.get(Attributes.PARSE_MULTIPLE_CONTEXT, Boolean.TRUE)).booleanValue()) {
                logError(charSequence, parseLog);
            }
        } else if (this.multi == null) {
            parseChar(charSequence, parseLog, attributeQuery, z);
        } else {
            parseMulti(charSequence, parseLog, attributeQuery, z);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008b, code lost:
        if (charEqualsIgnoreCase(r2, r5) != false) goto L_0x0092;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parseChar(java.lang.CharSequence r10, net.time4j.format.expert.ParseLog r11, net.time4j.engine.AttributeQuery r12, boolean r13) {
        /*
            r9 = this;
            int r0 = r11.getPosition()
            char r1 = r9.single
            net.time4j.engine.AttributeKey<java.lang.Character> r2 = r9.attribute
            r3 = 0
            if (r2 == 0) goto L_0x0019
            java.lang.Character r1 = java.lang.Character.valueOf(r3)
            java.lang.Object r1 = r12.get(r2, r1)
            java.lang.Character r1 = (java.lang.Character) r1
            char r1 = r1.charValue()
        L_0x0019:
            int r2 = r10.length()
            r4 = 1
            if (r0 >= r2) goto L_0x0090
            if (r1 == 0) goto L_0x0090
            boolean r2 = java.lang.Character.isDigit(r1)
            if (r2 == 0) goto L_0x002a
            goto L_0x0090
        L_0x002a:
            char r2 = r10.charAt(r0)
            char r5 = r9.alt
            net.time4j.engine.AttributeKey<java.lang.Character> r6 = r9.attribute
            if (r6 == 0) goto L_0x0063
            net.time4j.engine.AttributeKey<java.lang.Character> r6 = net.time4j.format.Attributes.DECIMAL_SEPARATOR
            java.lang.String r6 = r6.name()
            net.time4j.engine.AttributeKey<java.lang.Character> r7 = r9.attribute
            java.lang.String r7 = r7.name()
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0063
            java.util.Locale r6 = java.util.Locale.ROOT
            net.time4j.engine.AttributeKey<java.util.Locale> r7 = net.time4j.format.Attributes.LANGUAGE
            java.util.Locale r8 = java.util.Locale.ROOT
            java.lang.Object r7 = r12.get(r7, r8)
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0063
            r5 = 46
            r6 = 44
            if (r1 != r6) goto L_0x005d
            goto L_0x0063
        L_0x005d:
            if (r1 != r5) goto L_0x0062
            r5 = 44
            goto L_0x0063
        L_0x0062:
            r5 = r1
        L_0x0063:
            if (r2 == r1) goto L_0x0069
            if (r2 == r5) goto L_0x0069
            r6 = 1
            goto L_0x006a
        L_0x0069:
            r6 = 0
        L_0x006a:
            if (r6 == 0) goto L_0x008e
            if (r13 == 0) goto L_0x0071
            boolean r12 = r9.caseInsensitive
            goto L_0x007f
        L_0x0071:
            net.time4j.engine.AttributeKey<java.lang.Boolean> r13 = net.time4j.format.Attributes.PARSE_CASE_INSENSITIVE
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            java.lang.Object r12 = r12.get(r13, r7)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
        L_0x007f:
            if (r12 == 0) goto L_0x008e
            boolean r12 = charEqualsIgnoreCase(r2, r1)
            if (r12 != 0) goto L_0x0092
            boolean r12 = charEqualsIgnoreCase(r2, r5)
            if (r12 == 0) goto L_0x008e
            goto L_0x0092
        L_0x008e:
            r3 = r6
            goto L_0x0092
        L_0x0090:
            r2 = 0
            r3 = 1
        L_0x0092:
            if (r3 == 0) goto L_0x00bd
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r13 = "Cannot parse: \""
            r12.<init>(r13)
            r12.append(r10)
            java.lang.String r10 = "\" (expected: ["
            r12.append(r10)
            r12.append(r1)
            java.lang.String r10 = "], found: ["
            r12.append(r10)
            if (r2 == 0) goto L_0x00b0
            r12.append(r2)
        L_0x00b0:
            java.lang.String r10 = "])"
            r12.append(r10)
            java.lang.String r10 = r12.toString()
            r11.setError(r0, r10)
            goto L_0x00c1
        L_0x00bd:
            int r0 = r0 + r4
            r11.setPosition(r0)
        L_0x00c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.expert.LiteralProcessor.parseChar(java.lang.CharSequence, net.time4j.format.expert.ParseLog, net.time4j.engine.AttributeQuery, boolean):void");
    }

    private void parseMulti(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, boolean z) {
        boolean z2;
        boolean z3;
        int position = parseLog.getPosition();
        if (z) {
            z2 = this.caseInsensitive;
        } else {
            z2 = ((Boolean) attributeQuery.get(Attributes.PARSE_CASE_INSENSITIVE, Boolean.TRUE)).booleanValue();
        }
        if (z) {
            z3 = this.rtl;
        } else {
            z3 = CalendarText.isRTL((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT));
        }
        int subSequenceEquals = subSequenceEquals(charSequence, position, this.multi, z2, z3);
        if (subSequenceEquals == -1) {
            logError(charSequence, parseLog);
        } else {
            parseLog.setPosition(position + subSequenceEquals);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiteralProcessor)) {
            return false;
        }
        LiteralProcessor literalProcessor = (LiteralProcessor) obj;
        AttributeKey<Character> attributeKey = this.attribute;
        if (attributeKey != null) {
            return attributeKey.equals(literalProcessor.attribute);
        }
        String str = this.multi;
        if (str == null) {
            if (literalProcessor.multi == null && this.single == literalProcessor.single && this.alt == literalProcessor.alt) {
                return true;
            }
            return false;
        } else if (!str.equals(literalProcessor.multi) || this.interpunctuationMode != literalProcessor.interpunctuationMode) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        String str;
        AttributeKey<Character> attributeKey = this.attribute;
        if (attributeKey == null) {
            str = this.multi;
            if (str == null) {
                str = "";
            }
        } else {
            str = attributeKey.name();
        }
        return str.hashCode() ^ this.single;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append("[literal=");
        if (this.attribute != null) {
            sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
            sb.append(this.attribute);
            sb.append(AbstractJsonLexerKt.END_OBJ);
        } else {
            String str = this.multi;
            if (str == null) {
                sb.append(this.single);
                if (this.alt != this.single) {
                    sb.append(", alternative=");
                    sb.append(this.alt);
                }
            } else {
                sb.append(str);
            }
        }
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public boolean isNumerical() {
        if (this.multi != null && getPrefixedDigitArea() == this.multi.length()) {
            return true;
        }
        return false;
    }

    public FormatProcessor<Void> quickPath(ChronoFormatter<?> chronoFormatter, AttributeQuery attributeQuery, int i) {
        boolean isRTL = CalendarText.isRTL((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT));
        return new LiteralProcessor(this.single, this.alt, this.multi, this.attribute, ((Boolean) attributeQuery.get(Attributes.PARSE_CASE_INSENSITIVE, Boolean.TRUE)).booleanValue(), this.interpunctuationMode && !isRTL, isRTL);
    }

    /* access modifiers changed from: package-private */
    public int getPrefixedDigitArea() {
        String str = this.multi;
        int i = 0;
        if (str == null) {
            return 0;
        }
        int length = str.length();
        int i2 = 0;
        while (i < length && Character.isDigit(this.multi.charAt(i))) {
            i2++;
            i++;
        }
        return i2;
    }

    static int subSequenceEquals(CharSequence charSequence, int i, CharSequence charSequence2, boolean z, boolean z2) {
        char c;
        int length = charSequence.length();
        int length2 = charSequence2.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length2; i3++) {
            char charAt = charSequence2.charAt(i3);
            if (!isBidi(charAt)) {
                if (z2) {
                    c = 0;
                    while (true) {
                        int i4 = i2 + i;
                        if (i4 >= length) {
                            break;
                        }
                        c = charSequence.charAt(i4);
                        if (!isBidi(c)) {
                            break;
                        }
                        i2++;
                    }
                } else {
                    int i5 = i2 + i;
                    c = i5 < length ? charSequence.charAt(i5) : 0;
                }
                if (i2 + i >= length) {
                    return -1;
                }
                i2++;
                if (z) {
                    if (!charEqualsIgnoreCase(c, charAt)) {
                        return -1;
                    }
                } else if (c != charAt) {
                    return -1;
                }
            }
        }
        if (z2) {
            while (true) {
                int i6 = i2 + i;
                if (i6 >= length || !isBidi(charSequence.charAt(i6))) {
                    break;
                }
                i2++;
            }
        }
        return i2;
    }

    private static boolean charEqualsIgnoreCase(char c, char c2) {
        return c == c2 || Character.toUpperCase(c) == Character.toUpperCase(c2) || Character.toLowerCase(c) == Character.toLowerCase(c2);
    }

    private static boolean isInterpunctuation(char c) {
        return !Character.isLetter(c) && !Character.isDigit(c) && !isBidi(c);
    }

    private void logError(CharSequence charSequence, ParseLog parseLog) {
        int position = parseLog.getPosition();
        parseLog.setError(position, "Cannot parse: \"" + charSequence + "\" (expected: [" + this.multi + "], found: [" + charSequence.subSequence(position, Math.min(this.multi.length() + position, charSequence.length())) + "])");
    }
}
