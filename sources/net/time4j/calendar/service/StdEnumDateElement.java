package net.time4j.calendar.service;

import java.io.IOException;
import java.lang.Enum;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoOperator;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.CalendarType;
import net.time4j.format.NumericalElement;
import net.time4j.format.OutputContext;
import net.time4j.format.TextAccessor;
import net.time4j.format.TextElement;
import net.time4j.format.TextWidth;

public class StdEnumDateElement<V extends Enum<V>, T extends ChronoEntity<T>> extends StdDateElement<V, T> implements NumericalElement<V>, TextElement<V> {
    private static final long serialVersionUID = -2452569351302286113L;
    private final transient ChronoOperator<T> decrementor;
    private final transient String defaultCalendarType;
    private final transient ChronoOperator<T> incrementor;
    private final transient Class<V> type;

    private static boolean isWeekdayElement(char c) {
        return c == 'E';
    }

    /* access modifiers changed from: protected */
    public boolean hasLeapMonth(ChronoDisplay chronoDisplay) {
        return false;
    }

    public StdEnumDateElement(String str, Class<T> cls, Class<V> cls2, char c) {
        super(str, cls, c, isWeekdayElement(c));
        this.type = cls2;
        this.defaultCalendarType = extractCalendarType(cls);
        this.decrementor = null;
        this.incrementor = null;
    }

    public StdEnumDateElement(String str, Class<T> cls, Class<V> cls2, char c, String str2) {
        super(str, cls, c, isWeekdayElement(c));
        this.type = cls2;
        this.defaultCalendarType = str2;
        this.decrementor = null;
        this.incrementor = null;
    }

    public StdEnumDateElement(String str, Class<T> cls, Class<V> cls2, char c, ChronoOperator<T> chronoOperator, ChronoOperator<T> chronoOperator2) {
        super(str, cls, c, false);
        this.type = cls2;
        this.defaultCalendarType = extractCalendarType(cls);
        this.decrementor = chronoOperator;
        this.incrementor = chronoOperator2;
    }

    public Class<V> getType() {
        return this.type;
    }

    public V getDefaultMinimum() {
        return ((Enum[]) this.type.getEnumConstants())[0];
    }

    public V getDefaultMaximum() {
        V[] vArr = (Enum[]) this.type.getEnumConstants();
        return vArr[vArr.length - 1];
    }

    public int numerical(V v) {
        return v.ordinal() + 1;
    }

    public int printToInt(V v, ChronoDisplay chronoDisplay, AttributeQuery attributeQuery) {
        return numerical(v);
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

    public ChronoOperator<T> decremented() {
        ChronoOperator<T> chronoOperator = this.decrementor;
        if (chronoOperator != null) {
            return chronoOperator;
        }
        return super.decremented();
    }

    public ChronoOperator<T> incremented() {
        ChronoOperator<T> chronoOperator = this.incrementor;
        if (chronoOperator != null) {
            return chronoOperator;
        }
        return super.incremented();
    }

    public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException {
        appendable.append(accessor(attributeQuery, (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT), hasLeapMonth(chronoDisplay)).print((Enum) chronoDisplay.get(this)));
    }

    public V parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
        int index = parsePosition.getIndex();
        OutputContext outputContext = (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT);
        V parse = accessor(attributeQuery, outputContext, false).parse(charSequence, parsePosition, getType(), attributeQuery);
        if (parse == null && isMonthElement()) {
            parsePosition.setErrorIndex(-1);
            parsePosition.setIndex(index);
            parse = accessor(attributeQuery, outputContext, true).parse(charSequence, parsePosition, getType(), attributeQuery);
        }
        if (parse != null || !((Boolean) attributeQuery.get(Attributes.PARSE_MULTIPLE_CONTEXT, Boolean.TRUE)).booleanValue()) {
            return parse;
        }
        parsePosition.setErrorIndex(-1);
        parsePosition.setIndex(index);
        OutputContext outputContext2 = outputContext == OutputContext.FORMAT ? OutputContext.STANDALONE : OutputContext.FORMAT;
        V parse2 = accessor(attributeQuery, outputContext2, false).parse(charSequence, parsePosition, getType(), attributeQuery);
        if (parse2 != null || !isMonthElement()) {
            return parse2;
        }
        parsePosition.setErrorIndex(-1);
        parsePosition.setIndex(index);
        return accessor(attributeQuery, outputContext2, true).parse(charSequence, parsePosition, getType(), attributeQuery);
    }

    /* access modifiers changed from: protected */
    public String getCalendarType(AttributeQuery attributeQuery) {
        if (isMonthElement() || isEraElement()) {
            return (String) attributeQuery.get(Attributes.CALENDAR_TYPE, this.defaultCalendarType);
        }
        if (isWeekdayElement()) {
            return CalendarText.ISO_CALENDAR_TYPE;
        }
        return this.defaultCalendarType;
    }

    /* access modifiers changed from: protected */
    public boolean isEraElement() {
        return getSymbol() == 'G';
    }

    /* access modifiers changed from: protected */
    public boolean isMonthElement() {
        return getSymbol() == 'M';
    }

    /* access modifiers changed from: protected */
    public boolean isWeekdayElement() {
        return isWeekdayElement(getSymbol());
    }

    /* access modifiers changed from: protected */
    public TextAccessor accessor(AttributeQuery attributeQuery, OutputContext outputContext, boolean z) {
        TextWidth textWidth = (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE);
        CalendarText instance = CalendarText.getInstance(getCalendarType(attributeQuery), (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT));
        if (isMonthElement()) {
            if (z) {
                return instance.getLeapMonths(textWidth, outputContext);
            }
            return instance.getStdMonths(textWidth, outputContext);
        } else if (isWeekdayElement()) {
            return instance.getWeekdays(textWidth, outputContext);
        } else {
            if (isEraElement()) {
                return instance.getEras(textWidth);
            }
            return instance.getTextForms(name(), this.type, new String[0]);
        }
    }

    private static String extractCalendarType(Class<?> cls) {
        CalendarType calendarType = (CalendarType) cls.getAnnotation(CalendarType.class);
        if (calendarType == null) {
            return CalendarText.ISO_CALENDAR_TYPE;
        }
        return calendarType.value();
    }
}
