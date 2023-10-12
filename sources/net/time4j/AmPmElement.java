package net.time4j;

import java.io.IOException;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoException;
import net.time4j.engine.ChronoFunction;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.Leniency;
import net.time4j.format.OutputContext;
import net.time4j.format.TextAccessor;
import net.time4j.format.TextWidth;
import net.time4j.format.internal.GregorianTextElement;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.ZonalOffset;

enum AmPmElement implements ZonalElement<Meridiem>, GregorianTextElement<Meridiem> {
    AM_PM_OF_DAY;

    public char getSymbol() {
        return 'a';
    }

    public boolean isDateElement() {
        return false;
    }

    public boolean isLenient() {
        return false;
    }

    public boolean isTimeElement() {
        return true;
    }

    public Class<Meridiem> getType() {
        return Meridiem.class;
    }

    public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
        return ((Meridiem) chronoDisplay.get(this)).compareTo((Enum) chronoDisplay2.get(this));
    }

    public Meridiem getDefaultMinimum() {
        return Meridiem.AM;
    }

    public Meridiem getDefaultMaximum() {
        return Meridiem.PM;
    }

    public ChronoFunction<Moment, Meridiem> inStdTimezone() {
        return in(Timezone.ofSystem());
    }

    public ChronoFunction<Moment, Meridiem> inTimezone(TZID tzid) {
        return in(Timezone.of(tzid));
    }

    public ChronoFunction<Moment, Meridiem> in(Timezone timezone) {
        return new ZonalQuery(this, timezone);
    }

    public ChronoFunction<Moment, Meridiem> atUTC() {
        return at(ZonalOffset.UTC);
    }

    public ChronoFunction<Moment, Meridiem> at(ZonalOffset zonalOffset) {
        return new ZonalQuery(this, zonalOffset);
    }

    public String getDisplayName(Locale locale) {
        String str = CalendarText.getIsoInstance(locale).getTextForms().get("L_dayperiod");
        return str == null ? name() : str;
    }

    public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException {
        appendable.append(accessor(attributeQuery).print((Enum) chronoDisplay.get(this)));
    }

    public Meridiem parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
        Meridiem parseAmPm = parseAmPm(charSequence, parsePosition);
        return parseAmPm == null ? (Meridiem) accessor(attributeQuery).parse(charSequence, parsePosition, getType(), attributeQuery) : parseAmPm;
    }

    public void print(ChronoDisplay chronoDisplay, Appendable appendable, Locale locale, TextWidth textWidth, OutputContext outputContext) throws IOException, ChronoException {
        appendable.append(accessor(locale, textWidth, outputContext).print((Enum) chronoDisplay.get(this)));
    }

    public Meridiem parse(CharSequence charSequence, ParsePosition parsePosition, Locale locale, TextWidth textWidth, OutputContext outputContext, Leniency leniency) {
        Meridiem parseAmPm = parseAmPm(charSequence, parsePosition);
        return parseAmPm == null ? (Meridiem) accessor(locale, textWidth, outputContext).parse(charSequence, parsePosition, getType(), leniency) : parseAmPm;
    }

    private TextAccessor accessor(AttributeQuery attributeQuery) {
        return CalendarText.getIsoInstance((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT)).getMeridiems((TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE), (OutputContext) attributeQuery.get(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT));
    }

    private TextAccessor accessor(Locale locale, TextWidth textWidth, OutputContext outputContext) {
        return CalendarText.getIsoInstance(locale).getMeridiems(textWidth, outputContext);
    }

    static Meridiem parseAmPm(CharSequence charSequence, ParsePosition parsePosition) {
        int index = parsePosition.getIndex();
        int i = index + 2;
        if (charSequence.length() < i) {
            return null;
        }
        char charAt = charSequence.charAt(index + 1);
        if (charAt != 'M' && charAt != 'm') {
            return null;
        }
        char charAt2 = charSequence.charAt(index);
        if (charAt2 == 'A' || charAt2 == 'a') {
            parsePosition.setIndex(i);
            return Meridiem.AM;
        } else if (charAt2 != 'P' && charAt2 != 'p') {
            return null;
        } else {
            parsePosition.setIndex(i);
            return Meridiem.PM;
        }
    }
}
