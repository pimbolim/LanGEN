package net.time4j.calendar.service;

import java.io.IOException;
import java.text.ParsePosition;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.ChronoOperator;
import net.time4j.format.Attributes;
import net.time4j.format.Leniency;
import net.time4j.format.NumberSystem;
import net.time4j.format.TextWidth;
import net.time4j.format.internal.DualFormatElement;

public abstract class DualYearOfEraElement<T extends ChronoEntity<T>> extends StdIntegerDateElement<T> implements DualFormatElement {
    /* access modifiers changed from: protected */
    public abstract NumberSystem getNumberSystem(AttributeQuery attributeQuery);

    protected DualYearOfEraElement(Class<T> cls, int i, int i2, char c) {
        super("YEAR_OF_ERA", cls, i, i2, c, (ChronoOperator) null, (ChronoOperator) null);
    }

    public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
        char c;
        char charAt;
        NumberSystem numberSystem = getNumberSystem(attributeQuery);
        int i = AnonymousClass1.$SwitchMap$net$time4j$format$TextWidth[((TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.NARROW)).ordinal()];
        int i2 = i != 1 ? i != 2 ? i != 3 ? 4 : 3 : 2 : 1;
        if (attributeQuery.contains(Attributes.ZERO_DIGIT)) {
            charAt = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT)).charValue();
        } else if (numberSystem.isDecimal()) {
            charAt = numberSystem.getDigits().charAt(0);
        } else {
            c = '0';
            print(chronoDisplay, appendable, attributeQuery, numberSystem, c, i2, 10);
        }
        c = charAt;
        print(chronoDisplay, appendable, attributeQuery, numberSystem, c, i2, 10);
    }

    /* renamed from: net.time4j.calendar.service.DualYearOfEraElement$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$TextWidth;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                net.time4j.format.TextWidth[] r0 = net.time4j.format.TextWidth.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$format$TextWidth = r0
                net.time4j.format.TextWidth r1 = net.time4j.format.TextWidth.NARROW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$format$TextWidth     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.format.TextWidth r1 = net.time4j.format.TextWidth.SHORT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$format$TextWidth     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.format.TextWidth r1 = net.time4j.format.TextWidth.ABBREVIATED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.service.DualYearOfEraElement.AnonymousClass1.<clinit>():void");
        }
    }

    public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, NumberSystem numberSystem, char c, int i, int i2) throws IOException, ChronoException {
        String numeral = numberSystem.toNumeral(chronoDisplay.getInt(this));
        if (numberSystem.isDecimal()) {
            int length = i - numeral.length();
            for (int i3 = 0; i3 < length; i3++) {
                appendable.append(c);
            }
        }
        appendable.append(numeral);
    }

    public Integer parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
        char c;
        int i;
        NumberSystem numberSystem = getNumberSystem(attributeQuery);
        int index = parsePosition.getIndex();
        int i2 = 0;
        if (attributeQuery.contains(Attributes.ZERO_DIGIT)) {
            c = ((Character) attributeQuery.get(Attributes.ZERO_DIGIT)).charValue();
        } else {
            c = numberSystem.isDecimal() ? numberSystem.getDigits().charAt(0) : '0';
        }
        Leniency leniency = numberSystem.isDecimal() ? Leniency.SMART : (Leniency) attributeQuery.get(Attributes.LENIENCY, Leniency.SMART);
        long j = 0;
        if (numberSystem.isDecimal()) {
            int min = Math.min(index + 9, charSequence.length());
            int i3 = index;
            i = i3;
            while (i3 < min) {
                int charAt = charSequence.charAt(i3) - c;
                if (charAt < 0 || charAt > 9) {
                    break;
                }
                j = (j * 10) + ((long) charAt);
                i++;
                i3++;
            }
        } else {
            int length = charSequence.length();
            int i4 = index;
            while (i4 < length && numberSystem.contains(charSequence.charAt(i4))) {
                i2++;
                i4++;
            }
            if (i2 > 0) {
                i = i2 + index;
                j = (long) numberSystem.toInteger(charSequence.subSequence(index, i).toString(), leniency);
            } else {
                i = index;
            }
        }
        if (i == index || j > 2147483647L) {
            parsePosition.setErrorIndex(index);
            return null;
        }
        parsePosition.setIndex(i);
        return Integer.valueOf((int) j);
    }

    public Integer parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery, ChronoEntity<?> chronoEntity) {
        return parse(charSequence, parsePosition, attributeQuery);
    }
}
