package net.time4j;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.lang.Enum;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.Leniency;
import net.time4j.format.NumericalElement;
import net.time4j.format.OutputContext;
import net.time4j.format.TextAccessor;
import net.time4j.format.TextWidth;
import net.time4j.format.internal.GregorianTextElement;

final class EnumElement<V extends Enum<V>> extends AbstractDateElement<V> implements NavigableElement<V>, NumericalElement<V>, GregorianTextElement<V> {
    static final int DAY_OF_WEEK = 102;
    static final int MONTH = 101;
    static final int QUARTER_OF_YEAR = 103;
    private static final long serialVersionUID = 2055272540517425102L;
    private final transient V dmax;
    private final transient V dmin;
    private final transient int index;
    private final transient char symbol;
    private final transient Class<V> type;

    public boolean isDateElement() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isSingleton() {
        return true;
    }

    public boolean isTimeElement() {
        return false;
    }

    EnumElement(String str, Class<V> cls, V v, V v2, int i, char c) {
        super(str);
        this.type = cls;
        this.dmin = v;
        this.dmax = v2;
        this.index = i;
        this.symbol = c;
    }

    public Class<V> getType() {
        return this.type;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public V getDefaultMinimum() {
        return this.dmin;
    }

    public V getDefaultMaximum() {
        return this.dmax;
    }

    public ElementOperator<PlainDate> setToNext(V v) {
        return new NavigationOperator(this, 9, v);
    }

    public ElementOperator<PlainDate> setToPrevious(V v) {
        return new NavigationOperator(this, 10, v);
    }

    public ElementOperator<PlainDate> setToNextOrSame(V v) {
        return new NavigationOperator(this, 11, v);
    }

    public ElementOperator<PlainDate> setToPreviousOrSame(V v) {
        return new NavigationOperator(this, 12, v);
    }

    public int numerical(V v) {
        return v.ordinal() + 1;
    }

    public int printToInt(V v, ChronoDisplay chronoDisplay, AttributeQuery attributeQuery) {
        return v.ordinal() + 1;
    }

    public boolean parseFromInt(ChronoEntity<?> chronoEntity, int i) {
        for (Enum enumR : (Enum[]) getType().getEnumConstants()) {
            if (numerical(enumR) == i) {
                chronoEntity.with((ChronoElement<V>) this, enumR);
                return true;
            }
        }
        return false;
    }

    public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException {
        appendable.append(accessor((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT), (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE), (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT)).print((Enum) chronoDisplay.get(this)));
    }

    public V parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
        int index2 = parsePosition.getIndex();
        Locale locale = (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT);
        TextWidth textWidth = (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE);
        OutputContext outputContext = (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT);
        V parse = accessor(locale, textWidth, outputContext).parse(charSequence, parsePosition, getType(), attributeQuery);
        if (parse != null || !((Boolean) attributeQuery.get(Attributes.PARSE_MULTIPLE_CONTEXT, Boolean.TRUE)).booleanValue()) {
            return parse;
        }
        parsePosition.setErrorIndex(-1);
        parsePosition.setIndex(index2);
        return accessor(locale, textWidth, outputContext == OutputContext.FORMAT ? OutputContext.STANDALONE : OutputContext.FORMAT).parse(charSequence, parsePosition, getType(), attributeQuery);
    }

    public void print(ChronoDisplay chronoDisplay, Appendable appendable, Locale locale, TextWidth textWidth, OutputContext outputContext) throws IOException, ChronoException {
        appendable.append(accessor(locale, textWidth, outputContext).print((Enum) chronoDisplay.get(this)));
    }

    public V parse(CharSequence charSequence, ParsePosition parsePosition, Locale locale, TextWidth textWidth, OutputContext outputContext, Leniency leniency) {
        int index2 = parsePosition.getIndex();
        V parse = accessor(locale, textWidth, outputContext).parse(charSequence, parsePosition, getType(), leniency);
        if (parse != null || leniency.isStrict()) {
            return parse;
        }
        parsePosition.setErrorIndex(-1);
        parsePosition.setIndex(index2);
        return accessor(locale, textWidth, outputContext == OutputContext.FORMAT ? OutputContext.STANDALONE : OutputContext.FORMAT).parse(charSequence, parsePosition, getType(), leniency);
    }

    /* access modifiers changed from: package-private */
    public int getIndex() {
        return this.index;
    }

    private TextAccessor accessor(Locale locale, TextWidth textWidth, OutputContext outputContext) {
        switch (this.index) {
            case 101:
                return CalendarText.getIsoInstance(locale).getStdMonths(textWidth, outputContext);
            case 102:
                return CalendarText.getIsoInstance(locale).getWeekdays(textWidth, outputContext);
            case 103:
                return CalendarText.getIsoInstance(locale).getQuarters(textWidth, outputContext);
            default:
                throw new UnsupportedOperationException(name());
        }
    }

    private Object readResolve() throws ObjectStreamException {
        Object lookupElement = PlainDate.lookupElement(name());
        if (lookupElement != null) {
            return lookupElement;
        }
        throw new InvalidObjectException(name());
    }
}
