package net.time4j.calendar;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Locale;
import net.time4j.Month;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoException;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.NumberSystem;
import net.time4j.format.OutputContext;
import net.time4j.format.TextAccessor;
import net.time4j.format.TextElement;
import net.time4j.format.TextWidth;
import net.time4j.format.internal.DualFormatElement;

class EastAsianME implements TextElement<EastAsianMonth>, Serializable {
    static final EastAsianME SINGLETON_EA = new EastAsianME();
    private static final long serialVersionUID = -5874268477318061153L;

    public char getSymbol() {
        return 'M';
    }

    public boolean isDateElement() {
        return true;
    }

    public boolean isLenient() {
        return false;
    }

    public boolean isTimeElement() {
        return false;
    }

    public String name() {
        return "MONTH_OF_YEAR";
    }

    EastAsianME() {
    }

    public Class<EastAsianMonth> getType() {
        return EastAsianMonth.class;
    }

    public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
        return ((EastAsianMonth) chronoDisplay.get(this)).compareTo((EastAsianMonth) chronoDisplay2.get(this));
    }

    public EastAsianMonth getDefaultMinimum() {
        return EastAsianMonth.valueOf(1);
    }

    public EastAsianMonth getDefaultMaximum() {
        return EastAsianMonth.valueOf(12);
    }

    public String getDisplayName(Locale locale) {
        String str = CalendarText.getIsoInstance(locale).getTextForms().get("L_month");
        return str == null ? name() : str;
    }

    /* access modifiers changed from: protected */
    public Object readResolve() throws ObjectStreamException {
        return SINGLETON_EA;
    }

    public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
        TextAccessor textAccessor;
        Locale locale = (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT);
        EastAsianMonth eastAsianMonth = (EastAsianMonth) chronoDisplay.get(this);
        if (attributeQuery.contains(DualFormatElement.COUNT_OF_PATTERN_SYMBOLS)) {
            appendable.append(eastAsianMonth.getDisplayName(locale, (NumberSystem) attributeQuery.get(Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC), attributeQuery));
            return;
        }
        TextWidth textWidth = (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE);
        OutputContext outputContext = (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT);
        if (eastAsianMonth.isLeap()) {
            textAccessor = CalendarText.getInstance("chinese", locale).getLeapMonths(textWidth, outputContext);
        } else {
            textAccessor = CalendarText.getInstance("chinese", locale).getStdMonths(textWidth, outputContext);
        }
        appendable.append(textAccessor.print(Month.valueOf(eastAsianMonth.getNumber())));
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [java.lang.Enum] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x014b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.time4j.calendar.EastAsianMonth parse(java.lang.CharSequence r19, java.text.ParsePosition r20, net.time4j.engine.AttributeQuery r21) {
        /*
            r18 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            net.time4j.engine.AttributeKey<java.util.Locale> r3 = net.time4j.format.Attributes.LANGUAGE
            java.util.Locale r4 = java.util.Locale.ROOT
            java.lang.Object r3 = r2.get(r3, r4)
            java.util.Locale r3 = (java.util.Locale) r3
            int r4 = r19.length()
            int r5 = r20.getIndex()
            r6 = 0
            if (r5 < r4) goto L_0x001f
            r1.setErrorIndex(r4)
            return r6
        L_0x001f:
            net.time4j.engine.AttributeKey<java.lang.Integer> r7 = net.time4j.format.internal.DualFormatElement.COUNT_OF_PATTERN_SYMBOLS
            boolean r7 = r2.contains(r7)
            r8 = 0
            r9 = 1
            if (r7 == 0) goto L_0x00fe
            java.lang.String r7 = "generic"
            net.time4j.format.CalendarText r3 = net.time4j.format.CalendarText.getInstance((java.lang.String) r7, (java.util.Locale) r3)
            java.util.Map r3 = r3.getTextForms()
            net.time4j.engine.AttributeKey<net.time4j.format.NumberSystem> r7 = net.time4j.format.Attributes.NUMBER_SYSTEM
            net.time4j.format.NumberSystem r10 = net.time4j.format.NumberSystem.ARABIC
            java.lang.Object r7 = r2.get(r7, r10)
            net.time4j.format.NumberSystem r7 = (net.time4j.format.NumberSystem) r7
            net.time4j.engine.AttributeKey<java.lang.Character> r10 = net.time4j.format.Attributes.ZERO_DIGIT
            java.lang.String r11 = r7.getDigits()
            char r11 = r11.charAt(r8)
            java.lang.Character r11 = java.lang.Character.valueOf(r11)
            java.lang.Object r10 = r2.get(r10, r11)
            java.lang.Character r10 = (java.lang.Character) r10
            char r10 = r10.charValue()
            net.time4j.engine.AttributeKey<java.lang.Boolean> r11 = net.time4j.calendar.EastAsianMonth.LEAP_MONTH_IS_TRAILING
            java.lang.String r12 = "leap-alignment"
            java.lang.Object r12 = r3.get(r12)
            java.lang.String r13 = "R"
            boolean r12 = r13.equals(r12)
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)
            java.lang.Object r11 = r2.get(r11, r12)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            net.time4j.engine.AttributeKey<java.lang.Character> r12 = net.time4j.calendar.EastAsianMonth.LEAP_MONTH_INDICATOR
            java.lang.String r13 = "leap-indicator"
            java.lang.Object r3 = r3.get(r13)
            java.lang.String r3 = (java.lang.String) r3
            char r3 = r3.charAt(r8)
            java.lang.Character r3 = java.lang.Character.valueOf(r3)
            java.lang.Object r2 = r2.get(r12, r3)
            java.lang.Character r2 = (java.lang.Character) r2
            char r2 = r2.charValue()
            if (r11 != 0) goto L_0x0099
            char r3 = r0.charAt(r5)
            if (r3 != r2) goto L_0x0099
            int r3 = r5 + 1
            r12 = 1
            goto L_0x009b
        L_0x0099:
            r3 = r5
            r12 = 0
        L_0x009b:
            boolean r13 = r7.isDecimal()
            if (r13 == 0) goto L_0x00ac
        L_0x00a1:
            if (r3 >= r4) goto L_0x00ac
            char r13 = r0.charAt(r3)
            if (r13 != r10) goto L_0x00ac
            int r3 = r3 + 1
            goto L_0x00a1
        L_0x00ac:
            r13 = 12
            r14 = 0
        L_0x00af:
            if (r13 < r9) goto L_0x00e0
            if (r14 != 0) goto L_0x00e0
            java.lang.String r15 = net.time4j.format.internal.DualFormatHelper.toNumeral(r7, r10, r13)
            int r8 = r15.length()
            r9 = 0
        L_0x00bc:
            int r6 = r3 + r9
            if (r4 <= r6) goto L_0x00cd
            char r6 = r0.charAt(r6)
            r17 = r7
            char r7 = r15.charAt(r9)
            if (r6 == r7) goto L_0x00cf
            goto L_0x00d5
        L_0x00cd:
            r17 = r7
        L_0x00cf:
            int r9 = r9 + 1
            if (r9 != r8) goto L_0x00dd
            int r3 = r3 + r8
            r14 = r13
        L_0x00d5:
            int r13 = r13 + -1
            r7 = r17
            r6 = 0
            r8 = 0
            r9 = 1
            goto L_0x00af
        L_0x00dd:
            r7 = r17
            goto L_0x00bc
        L_0x00e0:
            if (r14 != 0) goto L_0x00e7
            r1.setErrorIndex(r5)
        L_0x00e5:
            r0 = 0
            return r0
        L_0x00e7:
            if (r11 == 0) goto L_0x00f5
            if (r4 <= r3) goto L_0x00f5
            char r0 = r0.charAt(r3)
            if (r0 != r2) goto L_0x00f5
            int r3 = r3 + 1
            r9 = 1
            goto L_0x00f6
        L_0x00f5:
            r9 = r12
        L_0x00f6:
            net.time4j.calendar.EastAsianMonth r0 = net.time4j.calendar.EastAsianMonth.valueOf(r14)
            r1.setIndex(r3)
            goto L_0x0155
        L_0x00fe:
            net.time4j.engine.AttributeKey<net.time4j.format.TextWidth> r4 = net.time4j.format.Attributes.TEXT_WIDTH
            net.time4j.format.TextWidth r6 = net.time4j.format.TextWidth.WIDE
            java.lang.Object r4 = r2.get(r4, r6)
            net.time4j.format.TextWidth r4 = (net.time4j.format.TextWidth) r4
            net.time4j.engine.AttributeKey<net.time4j.format.OutputContext> r6 = net.time4j.format.Attributes.OUTPUT_CONTEXT
            net.time4j.format.OutputContext r7 = net.time4j.format.OutputContext.FORMAT
            java.lang.Object r6 = r2.get(r6, r7)
            net.time4j.format.OutputContext r6 = (net.time4j.format.OutputContext) r6
            java.lang.String r7 = "chinese"
            net.time4j.format.CalendarText r8 = net.time4j.format.CalendarText.getInstance((java.lang.String) r7, (java.util.Locale) r3)
            net.time4j.format.TextAccessor r8 = r8.getStdMonths(r4, r6)
            java.lang.Class<net.time4j.Month> r9 = net.time4j.Month.class
            java.lang.Enum r8 = r8.parse((java.lang.CharSequence) r0, (java.text.ParsePosition) r1, r9, (net.time4j.engine.AttributeQuery) r2)
            net.time4j.Month r8 = (net.time4j.Month) r8
            if (r8 != 0) goto L_0x0143
            r8 = -1
            r1.setErrorIndex(r8)
            r1.setIndex(r5)
            net.time4j.format.CalendarText r3 = net.time4j.format.CalendarText.getInstance((java.lang.String) r7, (java.util.Locale) r3)
            net.time4j.format.TextAccessor r3 = r3.getLeapMonths(r4, r6)
            java.lang.Class<net.time4j.Month> r4 = net.time4j.Month.class
            java.lang.Enum r0 = r3.parse((java.lang.CharSequence) r0, (java.text.ParsePosition) r1, r4, (net.time4j.engine.AttributeQuery) r2)
            r8 = r0
            net.time4j.Month r8 = (net.time4j.Month) r8
            if (r8 == 0) goto L_0x0143
            r16 = 1
            goto L_0x0145
        L_0x0143:
            r16 = 0
        L_0x0145:
            if (r8 != 0) goto L_0x014b
            r1.setErrorIndex(r5)
            goto L_0x00e5
        L_0x014b:
            int r0 = r8.getValue()
            net.time4j.calendar.EastAsianMonth r0 = net.time4j.calendar.EastAsianMonth.valueOf(r0)
            r9 = r16
        L_0x0155:
            if (r9 == 0) goto L_0x015b
            net.time4j.calendar.EastAsianMonth r0 = r0.withLeap()
        L_0x015b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.EastAsianME.parse(java.lang.CharSequence, java.text.ParsePosition, net.time4j.engine.AttributeQuery):net.time4j.calendar.EastAsianMonth");
    }
}
