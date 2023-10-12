package net.time4j.history;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.text.ParsePosition;
import java.util.List;
import java.util.Locale;
import net.time4j.Month;
import net.time4j.PlainDate;
import net.time4j.base.GregorianDate;
import net.time4j.base.MathUtils;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.BasicElement;
import net.time4j.engine.CalendarDays;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.Chronology;
import net.time4j.engine.ElementRule;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.Leniency;
import net.time4j.format.NumberSystem;
import net.time4j.format.OutputContext;
import net.time4j.format.TextAccessor;
import net.time4j.format.TextWidth;
import net.time4j.format.internal.DualFormatElement;
import net.time4j.history.internal.StdHistoricalElement;

final class HistoricIntegerElement extends StdHistoricalElement implements DualFormatElement {
    static final int CENTURY_INDEX = 8;
    static final int DAY_OF_MONTH_INDEX = 4;
    static final int DAY_OF_YEAR_INDEX = 5;
    static final int MONTH_INDEX = 3;
    static final int YEAR_AFTER_INDEX = 6;
    static final int YEAR_BEFORE_INDEX = 7;
    static final int YEAR_OF_ERA_INDEX = 2;
    private static final long serialVersionUID = -6283098762945747308L;
    private final ChronoHistory history;
    private final transient int index;

    /* access modifiers changed from: protected */
    public boolean isSingleton() {
        return false;
    }

    HistoricIntegerElement(char c, int i, int i2, ChronoHistory chronoHistory, int i3) {
        super(toName(i3), c, i, i2);
        this.history = chronoHistory;
        this.index = i3;
    }

    public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException {
        char c;
        char charAt;
        NumberSystem numberSystem = (NumberSystem) attributeQuery.get(Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC);
        if (attributeQuery.contains(Attributes.ZERO_DIGIT)) {
            charAt = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT)).charValue();
        } else if (numberSystem.isDecimal()) {
            charAt = numberSystem.getDigits().charAt(0);
        } else {
            c = '0';
            print(chronoDisplay, appendable, attributeQuery, numberSystem, c, 1, 10);
        }
        c = charAt;
        print(chronoDisplay, appendable, attributeQuery, numberSystem, c, 1, 10);
    }

    public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, NumberSystem numberSystem, char c, int i, int i2) throws IOException {
        HistoricDate historicDate;
        int yearOfEra;
        ChronoDisplay chronoDisplay2 = chronoDisplay;
        Appendable appendable2 = appendable;
        AttributeQuery attributeQuery2 = attributeQuery;
        NumberSystem numberSystem2 = numberSystem;
        char c2 = c;
        if (this.index == 5) {
            appendable.append(String.valueOf(chronoDisplay.get(this.history.dayOfYear())));
            return;
        }
        if (chronoDisplay2 instanceof GregorianDate) {
            historicDate = this.history.convert(PlainDate.from((GregorianDate) chronoDisplay2));
        } else {
            historicDate = (HistoricDate) chronoDisplay.get(this.history.date());
        }
        int i3 = this.index;
        if (i3 == 2) {
            NewYearStrategy newYearStrategy = this.history.getNewYearStrategy();
            int yearOfEra2 = historicDate.getYearOfEra();
            String str = null;
            if (!NewYearStrategy.DEFAULT.equals(newYearStrategy) && (yearOfEra = historicDate.getYearOfEra(newYearStrategy)) != yearOfEra2) {
                if (attributeQuery.get(ChronoHistory.YEAR_DEFINITION, YearDefinition.DUAL_DATING) == YearDefinition.DUAL_DATING) {
                    str = dual(numberSystem, c, yearOfEra, yearOfEra2, i);
                } else {
                    yearOfEra2 = yearOfEra;
                }
            }
            if (str == null) {
                if (numberSystem.isDecimal()) {
                    str = pad(numberSystem2.toNumeral(yearOfEra2), i, c2);
                } else {
                    str = numberSystem2.toNumeral(yearOfEra2);
                }
            }
            if (numberSystem.isDecimal()) {
                char charAt = numberSystem.getDigits().charAt(0);
                if (c2 != charAt) {
                    StringBuilder sb = new StringBuilder();
                    int length = str.length();
                    for (int i4 = 0; i4 < length; i4++) {
                        char charAt2 = str.charAt(i4);
                        if (numberSystem2.contains(charAt2)) {
                            sb.append((char) (charAt2 + (c2 - charAt)));
                        } else {
                            sb.append(charAt2);
                        }
                    }
                    str = sb.toString();
                }
                checkLength(str, i2);
            }
            appendable.append(str);
        } else if (i3 == 3) {
            int intValue = ((Integer) attributeQuery.get(DualFormatElement.COUNT_OF_PATTERN_SYMBOLS, 0)).intValue();
            int month = historicDate.getMonth();
            if (intValue == 0) {
                appendable.append(monthAccessor(attributeQuery, (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT)).print(Month.valueOf(month)));
                return;
            }
            String numeral = numberSystem2.toNumeral(month);
            if (numberSystem.isDecimal()) {
                numeral = pad(numeral, intValue, c2);
            }
            appendable.append(numeral);
        } else if (i3 == 4) {
            appendable.append(String.valueOf(historicDate.getDayOfMonth()));
        } else {
            throw new ChronoException("Not printable as text: " + name());
        }
    }

    public Integer parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
        return parse(charSequence, parsePosition, attributeQuery, (ChronoEntity<?>) null);
    }

    /* JADX WARNING: type inference failed for: r1v44, types: [java.lang.Enum] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0171  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Integer parse(java.lang.CharSequence r17, java.text.ParsePosition r18, net.time4j.engine.AttributeQuery r19, net.time4j.engine.ChronoEntity<?> r20) {
        /*
            r16 = this;
            r0 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            int r1 = r0.index
            r11 = 0
            r2 = 0
            r3 = 3
            if (r1 != r3) goto L_0x0078
            int r1 = r18.getIndex()
            net.time4j.engine.AttributeKey<java.lang.Integer> r3 = net.time4j.format.internal.DualFormatElement.COUNT_OF_PATTERN_SYMBOLS
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            java.lang.Object r3 = r9.get(r3, r4)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r3 != 0) goto L_0x0082
            net.time4j.engine.AttributeKey<net.time4j.format.OutputContext> r2 = net.time4j.format.Attributes.OUTPUT_CONTEXT
            net.time4j.format.OutputContext r3 = net.time4j.format.OutputContext.FORMAT
            java.lang.Object r2 = r9.get(r2, r3)
            net.time4j.format.OutputContext r2 = (net.time4j.format.OutputContext) r2
            net.time4j.format.TextAccessor r3 = r0.monthAccessor(r9, r2)
            java.lang.Class<net.time4j.Month> r4 = net.time4j.Month.class
            java.lang.Enum r3 = r3.parse((java.lang.CharSequence) r7, (java.text.ParsePosition) r8, r4, (net.time4j.engine.AttributeQuery) r9)
            net.time4j.Month r3 = (net.time4j.Month) r3
            if (r3 != 0) goto L_0x006c
            net.time4j.engine.AttributeKey<java.lang.Boolean> r4 = net.time4j.format.Attributes.PARSE_MULTIPLE_CONTEXT
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            java.lang.Object r4 = r9.get(r4, r5)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x006c
            r3 = -1
            r8.setErrorIndex(r3)
            r8.setIndex(r1)
            net.time4j.format.OutputContext r1 = net.time4j.format.OutputContext.FORMAT
            if (r2 != r1) goto L_0x005d
            net.time4j.format.OutputContext r1 = net.time4j.format.OutputContext.STANDALONE
            goto L_0x005f
        L_0x005d:
            net.time4j.format.OutputContext r1 = net.time4j.format.OutputContext.FORMAT
        L_0x005f:
            net.time4j.format.TextAccessor r1 = r0.monthAccessor(r9, r1)
            java.lang.Class<net.time4j.Month> r2 = net.time4j.Month.class
            java.lang.Enum r1 = r1.parse((java.lang.CharSequence) r7, (java.text.ParsePosition) r8, r2, (net.time4j.engine.AttributeQuery) r9)
            r3 = r1
            net.time4j.Month r3 = (net.time4j.Month) r3
        L_0x006c:
            if (r3 != 0) goto L_0x006f
            return r11
        L_0x006f:
            int r1 = r3.getValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            return r1
        L_0x0078:
            r3 = 6
            if (r1 == r3) goto L_0x0176
            r3 = 7
            if (r1 == r3) goto L_0x0176
            r3 = 8
            if (r1 == r3) goto L_0x0176
        L_0x0082:
            net.time4j.engine.AttributeKey<net.time4j.format.NumberSystem> r1 = net.time4j.format.Attributes.NUMBER_SYSTEM
            net.time4j.format.NumberSystem r3 = net.time4j.format.NumberSystem.ARABIC
            java.lang.Object r1 = r9.get(r1, r3)
            r12 = r1
            net.time4j.format.NumberSystem r12 = (net.time4j.format.NumberSystem) r12
            net.time4j.engine.AttributeKey<java.lang.Character> r1 = net.time4j.format.Attributes.ZERO_DIGIT
            boolean r1 = r9.contains(r1)
            if (r1 == 0) goto L_0x00a3
            net.time4j.engine.AttributeKey<java.lang.Character> r1 = net.time4j.format.Attributes.ZERO_DIGIT
            java.lang.Object r1 = r9.get(r1)
            java.lang.Character r1 = (java.lang.Character) r1
            char r1 = r1.charValue()
        L_0x00a1:
            r13 = r1
            goto L_0x00b6
        L_0x00a3:
            boolean r1 = r12.isDecimal()
            if (r1 == 0) goto L_0x00b2
            java.lang.String r1 = r12.getDigits()
            char r1 = r1.charAt(r2)
            goto L_0x00a1
        L_0x00b2:
            r1 = 48
            r13 = 48
        L_0x00b6:
            boolean r1 = r12.isDecimal()
            if (r1 == 0) goto L_0x00bf
            net.time4j.format.Leniency r1 = net.time4j.format.Leniency.SMART
            goto L_0x00c9
        L_0x00bf:
            net.time4j.engine.AttributeKey<net.time4j.format.Leniency> r1 = net.time4j.format.Attributes.LENIENCY
            net.time4j.format.Leniency r2 = net.time4j.format.Leniency.SMART
            java.lang.Object r1 = r9.get(r1, r2)
            net.time4j.format.Leniency r1 = (net.time4j.format.Leniency) r1
        L_0x00c9:
            r14 = r1
            int r15 = r18.getIndex()
            r1 = r12
            r2 = r13
            r3 = r17
            r4 = r15
            r5 = r18
            r6 = r14
            int r6 = parseNum(r1, r2, r3, r4, r5, r6)
            int r5 = r18.getIndex()
            int r1 = r0.index
            r4 = 2
            if (r1 != r4) goto L_0x0167
            if (r5 <= r15) goto L_0x0167
            net.time4j.history.NewYearStrategy r1 = net.time4j.history.NewYearStrategy.DEFAULT
            net.time4j.history.ChronoHistory r2 = r0.history
            net.time4j.history.NewYearStrategy r2 = r2.getNewYearStrategy()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0167
            int r1 = r17.length()
            if (r5 >= r1) goto L_0x0167
            char r1 = r7.charAt(r5)
            r2 = 47
            if (r1 != r2) goto L_0x0167
            net.time4j.engine.AttributeKey<net.time4j.history.YearDefinition> r1 = net.time4j.history.ChronoHistory.YEAR_DEFINITION
            net.time4j.history.YearDefinition r2 = net.time4j.history.YearDefinition.DUAL_DATING
            java.lang.Object r1 = r9.get(r1, r2)
            net.time4j.history.YearDefinition r2 = net.time4j.history.YearDefinition.DUAL_DATING
            if (r1 != r2) goto L_0x0167
            int r9 = r5 + 1
            r1 = r12
            r2 = r13
            r3 = r17
            r7 = 2
            r4 = r9
            r13 = r5
            r5 = r18
            r7 = r6
            r6 = r14
            int r6 = parseNum(r1, r2, r3, r4, r5, r6)
            int r5 = r18.getIndex()
            if (r5 != r9) goto L_0x0128
            r8.setIndex(r13)
            goto L_0x0169
        L_0x0128:
            net.time4j.history.ChronoHistory r1 = r0.history
            net.time4j.history.NewYearStrategy r1 = r1.getNewYearStrategy()
            net.time4j.history.HistoricEra r2 = net.time4j.history.HistoricEra.AD
            net.time4j.history.NewYearRule r1 = r1.rule(r2, r7)
            net.time4j.history.NewYearRule r2 = net.time4j.history.NewYearRule.CALCULUS_PISANUS
            if (r1 != r2) goto L_0x013a
            r4 = 2
            goto L_0x013b
        L_0x013a:
            r4 = 1
        L_0x013b:
            int r1 = r0.getAncientYear(r7, r6, r4)
            boolean r2 = r12.isDecimal()
            if (r2 == 0) goto L_0x0153
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 == r2) goto L_0x0153
            if (r10 == 0) goto L_0x0151
            net.time4j.engine.ChronoElement<java.lang.Integer> r2 = net.time4j.history.internal.StdHistoricalElement.YEAR_OF_DISPLAY
            r10.with((net.time4j.engine.ChronoElement<java.lang.Integer>) r2, (int) r7)
        L_0x0151:
            r6 = r1
            goto L_0x016b
        L_0x0153:
            int r1 = r6 - r7
            int r1 = java.lang.Math.abs(r1)
            if (r1 > r4) goto L_0x0163
            if (r10 == 0) goto L_0x016b
            net.time4j.engine.ChronoElement<java.lang.Integer> r1 = net.time4j.history.internal.StdHistoricalElement.YEAR_OF_DISPLAY
            r10.with((net.time4j.engine.ChronoElement<java.lang.Integer>) r1, (int) r7)
            goto L_0x016b
        L_0x0163:
            r8.setIndex(r13)
            goto L_0x0169
        L_0x0167:
            r13 = r5
            r7 = r6
        L_0x0169:
            r6 = r7
            r5 = r13
        L_0x016b:
            if (r5 != r15) goto L_0x0171
            r8.setErrorIndex(r15)
            return r11
        L_0x0171:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            return r1
        L_0x0176:
            net.time4j.engine.ChronoException r1 = new net.time4j.engine.ChronoException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Not parseable as text element: "
            r2.append(r3)
            java.lang.String r3 = r16.name()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.history.HistoricIntegerElement.parse(java.lang.CharSequence, java.text.ParsePosition, net.time4j.engine.AttributeQuery, net.time4j.engine.ChronoEntity):java.lang.Integer");
    }

    /* access modifiers changed from: protected */
    public <T extends ChronoEntity<T>> ElementRule<T, Integer> derive(Chronology<T> chronology) {
        if (chronology.isRegistered(PlainDate.COMPONENT)) {
            return new Rule(this.index, this.history);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean doEquals(BasicElement<?> basicElement) {
        return this.history.equals(((HistoricIntegerElement) basicElement).history);
    }

    private int getAncientYear(int i, int i2, int i3) {
        if (i2 < 0) {
            return Integer.MAX_VALUE;
        }
        int i4 = 100;
        if (i2 >= 100 || i < 100) {
            return Integer.MAX_VALUE;
        }
        if (i2 < 10) {
            i4 = 10;
        }
        if (Math.abs(i2 - MathUtils.floorModulo(i, i4)) <= i3) {
            return (MathUtils.floorDivide(i, i4) * i4) + i2;
        }
        return Integer.MAX_VALUE;
    }

    private String dual(NumberSystem numberSystem, char c, int i, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append(numberSystem.toNumeral(i));
        sb.append('/');
        if (!numberSystem.isDecimal() || i2 < 100 || MathUtils.floorDivide(i, 100) != MathUtils.floorDivide(i2, 100)) {
            sb.append(numberSystem.toNumeral(i2));
        } else {
            int floorModulo = MathUtils.floorModulo(i2, 100);
            if (floorModulo < 10) {
                sb.append(c);
            }
            sb.append(numberSystem.toNumeral(floorModulo));
        }
        if (numberSystem.isDecimal()) {
            return pad(sb.toString(), i3, c);
        }
        return sb.toString();
    }

    private static String pad(String str, int i, char c) {
        int length = str.length();
        if (i <= length) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        int i2 = i - length;
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(c);
        }
        sb.append(str);
        return sb.toString();
    }

    private void checkLength(String str, int i) {
        if (str.length() > i) {
            throw new IllegalArgumentException("Element " + name() + " cannot be printed as the formatted value " + str + " exceeds the maximum width of " + i + ".");
        }
    }

    private TextAccessor monthAccessor(AttributeQuery attributeQuery, OutputContext outputContext) {
        return CalendarText.getIsoInstance((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT)).getStdMonths((TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE), outputContext);
    }

    private static int parseNum(NumberSystem numberSystem, char c, CharSequence charSequence, int i, ParsePosition parsePosition, Leniency leniency) {
        boolean z;
        int i2;
        int charAt;
        int i3 = 0;
        long j = 0;
        if (numberSystem.isDecimal()) {
            if (numberSystem == NumberSystem.ARABIC && charSequence.charAt(i) == '-') {
                i2 = i + 1;
                z = true;
            } else {
                i2 = i;
                z = false;
            }
            if (!leniency.isStrict()) {
                i3 = numberSystem.getDigits().charAt(0);
            }
            int min = Math.min(i2 + 9, charSequence.length());
            int i4 = i2;
            while (i2 < min) {
                int charAt2 = charSequence.charAt(i2) - c;
                if (charAt2 < 0 || charAt2 > 9) {
                    if (i3 == 0 || c == i3 || (charAt = charSequence.charAt(i2) - i3) < 0 || charAt > 9) {
                        break;
                    }
                    j = (j * 10) + ((long) charAt);
                    i4++;
                    c = i3;
                } else {
                    j = (j * 10) + ((long) charAt2);
                    i4++;
                }
                i2++;
            }
            if (j > 2147483647L) {
                parsePosition.setErrorIndex(i);
                return Integer.MIN_VALUE;
            }
            if (z) {
                if (i4 != i + 1) {
                    j = MathUtils.safeNegate(j);
                }
            }
            i = i4;
        } else {
            int length = charSequence.length();
            int i5 = i;
            while (i5 < length && numberSystem.contains(charSequence.charAt(i5))) {
                i3++;
                i5++;
            }
            if (i3 > 0) {
                int i6 = i3 + i;
                j = (long) numberSystem.toInteger(charSequence.subSequence(i, i6).toString(), leniency);
                i = i6;
            }
        }
        parsePosition.setIndex(i);
        return (int) j;
    }

    private static String toName(int i) {
        switch (i) {
            case 2:
                return "YEAR_OF_ERA";
            case 3:
                return "HISTORIC_MONTH";
            case 4:
                return "HISTORIC_DAY_OF_MONTH";
            case 5:
                return "HISTORIC_DAY_OF_YEAR";
            case 6:
                return "YEAR_AFTER";
            case 7:
                return "YEAR_BEFORE";
            case 8:
                return "CENTURY_OF_ERA";
            default:
                throw new UnsupportedOperationException("Unknown element index: " + i);
        }
    }

    private Object readResolve() throws ObjectStreamException {
        String name = name();
        if (name.equals("YEAR_OF_ERA")) {
            return this.history.yearOfEra();
        }
        if (name.equals("HISTORIC_MONTH")) {
            return this.history.month();
        }
        if (name.equals("HISTORIC_DAY_OF_MONTH")) {
            return this.history.dayOfMonth();
        }
        if (name.equals("HISTORIC_DAY_OF_YEAR")) {
            return this.history.dayOfYear();
        }
        if (name.equals("YEAR_AFTER")) {
            return this.history.yearOfEra(YearDefinition.AFTER_NEW_YEAR);
        }
        if (name.equals("YEAR_BEFORE")) {
            return this.history.yearOfEra(YearDefinition.BEFORE_NEW_YEAR);
        }
        if (name.equals("CENTURY_OF_ERA")) {
            return this.history.centuryOfEra();
        }
        throw new InvalidObjectException("Unknown element: " + name);
    }

    private static class Rule<C extends ChronoEntity<C>> implements ElementRule<C, Integer> {
        private final ChronoHistory history;
        private final int index;

        Rule(int i, ChronoHistory chronoHistory) {
            this.index = i;
            this.history = chronoHistory;
        }

        public Integer getValue(C c) {
            int i;
            try {
                PlainDate plainDate = (PlainDate) c.get(PlainDate.COMPONENT);
                HistoricDate convert = this.history.convert(plainDate);
                switch (this.index) {
                    case 2:
                        i = convert.getYearOfEra();
                        break;
                    case 3:
                        i = convert.getMonth();
                        break;
                    case 4:
                        i = convert.getDayOfMonth();
                        break;
                    case 5:
                        i = (int) ((plainDate.getDaysSinceEpochUTC() - this.history.convert(this.history.getBeginOfYear(convert.getEra(), convert.getYearOfEra(this.history.getNewYearStrategy()))).getDaysSinceEpochUTC()) + 1);
                        break;
                    case 6:
                    case 7:
                        i = convert.getYearOfEra(this.history.getNewYearStrategy());
                        break;
                    case 8:
                        i = ((convert.getYearOfEra() - 1) / 100) + 1;
                        break;
                    default:
                        throw new UnsupportedOperationException("Unknown element index: " + this.index);
                }
                return Integer.valueOf(i);
            } catch (IllegalArgumentException e) {
                throw new ChronoException(e.getMessage(), e);
            }
        }

        public Integer getMinimum(C c) {
            try {
                HistoricDate convert = this.history.convert((PlainDate) c.get(PlainDate.COMPONENT));
                int i = this.index;
                if (!(i == 2 || i == 6 || i == 7)) {
                    if (i != 8) {
                        HistoricDate adjust = adjust(c, 1);
                        if (this.history.isValid(adjust)) {
                            return 1;
                        }
                        if (this.index != 5) {
                            List<CutOverEvent> events = this.history.getEvents();
                            int size = events.size() - 1;
                            while (true) {
                                if (size < 0) {
                                    break;
                                }
                                CutOverEvent cutOverEvent = events.get(size);
                                if (convert.compareTo(cutOverEvent.dateAtCutOver) >= 0) {
                                    adjust = cutOverEvent.dateAtCutOver;
                                    break;
                                }
                                size--;
                            }
                            return Integer.valueOf(this.index == 3 ? adjust.getMonth() : adjust.getDayOfMonth());
                        }
                        throw new ChronoException("Historic New Year cannot be determined.");
                    }
                }
                if (convert.getEra() != HistoricEra.BYZANTINE || convert.getMonth() < 9) {
                    return 1;
                }
                return 0;
            } catch (IllegalArgumentException e) {
                throw new ChronoException(e.getMessage(), e);
            }
        }

        public Integer getMaximum(C c) {
            HistoricDate historicDate;
            int i;
            try {
                HistoricDate convert = this.history.convert((PlainDate) c.get(PlainDate.COMPONENT));
                int i2 = 8;
                int i3 = 999984973;
                switch (this.index) {
                    case 2:
                    case 6:
                    case 7:
                    case 8:
                        if (this.history != ChronoHistory.PROLEPTIC_BYZANTINE) {
                            if (this.history == ChronoHistory.PROLEPTIC_JULIAN) {
                                i3 = 999979465;
                                if (convert.getEra() == HistoricEra.BC) {
                                    i3 = 999979466;
                                }
                            } else if (this.history == ChronoHistory.PROLEPTIC_GREGORIAN) {
                                i3 = 999999999;
                                if (convert.getEra() == HistoricEra.BC) {
                                    i3 = 1000000000;
                                }
                            } else {
                                i3 = convert.getEra() == HistoricEra.BC ? 45 : 9999;
                            }
                        }
                        if (this.index == 8) {
                            i3 = ((i3 - 1) / 100) + 1;
                        }
                        return Integer.valueOf(i3);
                    case 3:
                        if (convert.getEra() != HistoricEra.BYZANTINE || convert.getYearOfEra() != 999984973) {
                            i2 = 12;
                        }
                        historicDate = adjust(c, i2);
                        i = i2;
                        break;
                    case 4:
                        i = this.history.getAlgorithm(convert).getMaximumDayOfMonth(convert);
                        historicDate = adjust(c, i);
                        break;
                    case 5:
                        int lengthOfYear = this.history.getLengthOfYear(convert.getEra(), convert.getYearOfEra(this.history.getNewYearStrategy()));
                        if (lengthOfYear != -1) {
                            return Integer.valueOf(lengthOfYear);
                        }
                        throw new ChronoException("Length of historic year undefined.");
                    default:
                        throw new UnsupportedOperationException("Unknown element index: " + this.index);
                }
                if (this.history.isValid(historicDate)) {
                    return Integer.valueOf(i);
                }
                List<CutOverEvent> events = this.history.getEvents();
                int size = events.size() - 1;
                while (true) {
                    if (size >= 0) {
                        CutOverEvent cutOverEvent = events.get(size);
                        if (convert.compareTo(cutOverEvent.dateAtCutOver) < 0) {
                            historicDate = cutOverEvent.dateBeforeCutOver;
                        } else {
                            size--;
                        }
                    }
                }
                return Integer.valueOf(this.index == 3 ? historicDate.getMonth() : historicDate.getDayOfMonth());
            } catch (RuntimeException e) {
                throw new ChronoException(e.getMessage(), e);
            }
        }

        public boolean isValid(C c, Integer num) {
            if (num == null) {
                return false;
            }
            try {
                return this.history.isValid(adjust(c, num.intValue()));
            } catch (IllegalArgumentException unused) {
                return false;
            }
        }

        public C withValue(C c, Integer num, boolean z) {
            if (num != null) {
                return c.with(PlainDate.COMPONENT, this.history.convert(adjust(c, num.intValue())));
            }
            throw new IllegalArgumentException("Missing historic element value.");
        }

        public ChronoElement<?> getChildAtFloor(C c) {
            throw new UnsupportedOperationException("Never called.");
        }

        public ChronoElement<?> getChildAtCeiling(C c) {
            throw new UnsupportedOperationException("Never called.");
        }

        private HistoricDate adjust(C c, int i) {
            YearDefinition yearDefinition;
            HistoricDate convert = this.history.convert((PlainDate) c.get(PlainDate.COMPONENT));
            YearDefinition yearDefinition2 = YearDefinition.DUAL_DATING;
            NewYearStrategy newYearStrategy = this.history.getNewYearStrategy();
            int i2 = this.index;
            switch (i2) {
                case 2:
                    break;
                case 3:
                    return this.history.adjustDayOfMonth(HistoricDate.of(convert.getEra(), convert.getYearOfEra(), i, convert.getDayOfMonth()));
                case 4:
                    return HistoricDate.of(convert.getEra(), convert.getYearOfEra(), convert.getMonth(), i);
                case 5:
                    int yearOfEra = convert.getYearOfEra(this.history.getNewYearStrategy());
                    HistoricDate beginOfYear = this.history.getBeginOfYear(convert.getEra(), yearOfEra);
                    int lengthOfYear = this.history.getLengthOfYear(convert.getEra(), yearOfEra);
                    if (i == 1) {
                        return beginOfYear;
                    }
                    if (i <= 1 || i > lengthOfYear) {
                        throw new IllegalArgumentException("Out of range: " + i);
                    }
                    return this.history.convert((PlainDate) this.history.convert(beginOfYear).plus(CalendarDays.of((long) (i - 1))));
                case 6:
                case 7:
                    if (i2 == 6) {
                        yearDefinition = YearDefinition.AFTER_NEW_YEAR;
                    } else {
                        yearDefinition = YearDefinition.BEFORE_NEW_YEAR;
                    }
                    yearDefinition2 = yearDefinition;
                    break;
                case 8:
                    int i3 = 100;
                    int yearOfEra2 = convert.getYearOfEra() % 100;
                    int i4 = (i - 1) * 100;
                    if (yearOfEra2 != 0) {
                        i3 = yearOfEra2;
                    }
                    return this.history.adjustDayOfMonth(HistoricDate.of(convert.getEra(), i4 + i3, convert.getMonth(), convert.getDayOfMonth(), yearDefinition2, newYearStrategy));
                default:
                    throw new UnsupportedOperationException("Unknown element index: " + this.index);
            }
            int i5 = i;
            return this.history.adjustDayOfMonth(HistoricDate.of(convert.getEra(), i5, convert.getMonth(), convert.getDayOfMonth(), yearDefinition2, newYearStrategy));
        }
    }
}
