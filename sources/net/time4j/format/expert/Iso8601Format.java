package net.time4j.format.expert;

import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.Moment;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.PlainTimestamp;
import net.time4j.Weekmodel;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoCondition;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoFunction;
import net.time4j.format.Attributes;
import net.time4j.format.DisplayMode;
import net.time4j.format.Leniency;
import net.time4j.format.NumberSystem;
import net.time4j.format.expert.ChronoFormatter;
import net.time4j.tz.TZID;
import net.time4j.tz.ZonalOffset;
import org.apache.commons.lang3.ClassUtils;

public class Iso8601Format {
    public static final ChronoFormatter<PlainDate> BASIC_CALENDAR_DATE = calendarFormat(false);
    public static final ChronoFormatter<PlainDate> BASIC_DATE = generalDateFormat(false);
    public static final ChronoFormatter<PlainTimestamp> BASIC_DATE_TIME = timestampFormat(false);
    public static final ChronoFormatter<Moment> BASIC_DATE_TIME_OFFSET = momentFormat(false);
    public static final ChronoFormatter<PlainDate> BASIC_ORDINAL_DATE = ordinalFormat(false);
    public static final ChronoFormatter<PlainTime> BASIC_WALL_TIME = timeFormat(false);
    public static final ChronoFormatter<PlainDate> BASIC_WEEK_DATE = weekdateFormat(false);
    public static final ChronoFormatter<PlainDate> EXTENDED_CALENDAR_DATE = calendarFormat(true);
    public static final ChronoFormatter<PlainDate> EXTENDED_DATE = generalDateFormat(true);
    public static final ChronoFormatter<PlainTimestamp> EXTENDED_DATE_TIME = timestampFormat(true);
    public static final ChronoFormatter<Moment> EXTENDED_DATE_TIME_OFFSET = momentFormat(true);
    public static final ChronoFormatter<PlainDate> EXTENDED_ORDINAL_DATE = ordinalFormat(true);
    public static final ChronoFormatter<PlainTime> EXTENDED_WALL_TIME = timeFormat(true);
    public static final ChronoFormatter<PlainDate> EXTENDED_WEEK_DATE = weekdateFormat(true);
    private static final char ISO_DECIMAL_SEPARATOR = (Boolean.getBoolean("net.time4j.format.iso.decimal.dot") ? ClassUtils.PACKAGE_SEPARATOR_CHAR : AbstractJsonLexerKt.COMMA);
    private static final NonZeroCondition NON_ZERO_FRACTION;
    private static final NonZeroCondition NON_ZERO_SECOND;
    private static final ChronoCondition<ChronoDisplay> SECOND_PART;
    private static final ChronoCondition<Character> T_CONDITION = new TCondition();

    static {
        NonZeroCondition nonZeroCondition = new NonZeroCondition(PlainTime.SECOND_OF_MINUTE);
        NON_ZERO_SECOND = nonZeroCondition;
        NonZeroCondition nonZeroCondition2 = new NonZeroCondition(PlainTime.NANO_OF_SECOND);
        NON_ZERO_FRACTION = nonZeroCondition2;
        SECOND_PART = nonZeroCondition.or(nonZeroCondition2);
    }

    private Iso8601Format() {
    }

    public static PlainDate parseDate(CharSequence charSequence) throws ParseException {
        ParseLog parseLog = new ParseLog();
        PlainDate parseDate = parseDate(charSequence, parseLog);
        if (parseDate == null || parseLog.isError()) {
            throw new ParseException(parseLog.getErrorMessage(), parseLog.getErrorIndex());
        } else if (parseLog.getPosition() >= charSequence.length()) {
            return parseDate;
        } else {
            throw new ParseException("Trailing characters found: " + charSequence, parseLog.getPosition());
        }
    }

    public static PlainDate parseDate(CharSequence charSequence, ParseLog parseLog) {
        ChronoFormatter<PlainDate> chronoFormatter;
        int length = charSequence.length();
        int position = parseLog.getPosition();
        int i = length - position;
        if (i < 7) {
            parseLog.setError(length, "Too short to be compatible with ISO-8601: " + charSequence.subSequence(position, length));
            return null;
        }
        int i2 = position + 1;
        int i3 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt == '-') {
                i3++;
            } else if (charAt == '/' || charAt == 'T') {
                i = i2 - position;
            } else if (charAt == 'W') {
                if (i3 > 0) {
                    chronoFormatter = EXTENDED_WEEK_DATE;
                } else {
                    chronoFormatter = BASIC_WEEK_DATE;
                }
                return chronoFormatter.parse(charSequence, parseLog);
            }
            i2++;
        }
        i = i2 - position;
        if (i3 == 0) {
            int i4 = i - 4;
            char charAt2 = charSequence.charAt(position);
            if (charAt2 == '+' || charAt2 == '-') {
                i4 -= 2;
            }
            return (i4 == 3 ? BASIC_ORDINAL_DATE : BASIC_CALENDAR_DATE).parse(charSequence, parseLog);
        } else if (i3 == 1) {
            return EXTENDED_ORDINAL_DATE.parse(charSequence, parseLog);
        } else {
            return EXTENDED_CALENDAR_DATE.parse(charSequence, parseLog);
        }
    }

    private static ChronoFormatter<PlainDate> calendarFormat(boolean z) {
        ChronoFormatter.Builder<PlainDate> addInteger = ChronoFormatter.setUp(PlainDate.class, Locale.ROOT).startSection(Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC).startSection((AttributeKey<Character>) Attributes.ZERO_DIGIT, '0').addInteger(PlainDate.YEAR, 4, 9, SignPolicy.SHOW_WHEN_BIG_NUMBER);
        if (z) {
            addInteger.addLiteral((char) SignatureVisitor.SUPER);
        }
        addInteger.addFixedInteger(PlainDate.MONTH_AS_NUMBER, 2);
        if (z) {
            addInteger.addLiteral((char) SignatureVisitor.SUPER);
        }
        return addInteger.addFixedInteger(PlainDate.DAY_OF_MONTH, 2).endSection().endSection().build().with(Leniency.STRICT);
    }

    private static ChronoFormatter<PlainDate> ordinalFormat(boolean z) {
        ChronoFormatter.Builder<PlainDate> addInteger = ChronoFormatter.setUp(PlainDate.class, Locale.ROOT).startSection(Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC).startSection((AttributeKey<Character>) Attributes.ZERO_DIGIT, '0').addInteger(PlainDate.YEAR, 4, 9, SignPolicy.SHOW_WHEN_BIG_NUMBER);
        if (z) {
            addInteger.addLiteral((char) SignatureVisitor.SUPER);
        }
        return addInteger.addFixedInteger(PlainDate.DAY_OF_YEAR, 3).endSection().endSection().build().with(Leniency.STRICT);
    }

    private static ChronoFormatter<PlainDate> weekdateFormat(boolean z) {
        ChronoFormatter.Builder<PlainDate> addInteger = ChronoFormatter.setUp(PlainDate.class, Locale.ROOT).startSection(Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC).startSection((AttributeKey<Character>) Attributes.ZERO_DIGIT, '0').addInteger(PlainDate.YEAR_OF_WEEKDATE, 4, 9, SignPolicy.SHOW_WHEN_BIG_NUMBER);
        if (z) {
            addInteger.addLiteral((char) SignatureVisitor.SUPER);
        }
        addInteger.addLiteral('W');
        addInteger.addFixedInteger(Weekmodel.ISO.weekOfYear(), 2);
        if (z) {
            addInteger.addLiteral((char) SignatureVisitor.SUPER);
        }
        return addInteger.addFixedNumerical(PlainDate.DAY_OF_WEEK, 1).endSection().endSection().build().with(Leniency.STRICT);
    }

    private static ChronoFormatter<PlainDate> generalDateFormat(boolean z) {
        ChronoFormatter.Builder<PlainDate> up = ChronoFormatter.setUp(PlainDate.class, Locale.ROOT);
        up.addCustomized(PlainDate.COMPONENT, generalDatePrinter(z), generalDateParser(z));
        return up.build().with(Leniency.STRICT);
    }

    private static ChronoFormatter<PlainTime> timeFormat(boolean z) {
        ChronoFormatter.Builder<PlainTime> up = ChronoFormatter.setUp(PlainTime.class, Locale.ROOT);
        up.skipUnknown(T_CONDITION, 1);
        addWallTime(up, z);
        return up.build().with(Leniency.STRICT);
    }

    private static ChronoFormatter<PlainTimestamp> timestampFormat(boolean z) {
        ChronoFormatter.Builder<PlainTimestamp> up = ChronoFormatter.setUp(PlainTimestamp.class, Locale.ROOT);
        up.addCustomized(PlainDate.COMPONENT, generalDatePrinter(z), generalDateParser(z));
        up.addLiteral('T');
        addWallTime(up, z);
        return up.build().with(Leniency.STRICT);
    }

    private static ChronoFormatter<Moment> momentFormat(boolean z) {
        ChronoFormatter.Builder<Moment> up = ChronoFormatter.setUp(Moment.class, Locale.ROOT);
        up.addCustomized(Moment.axis().element(), momentFormat(DisplayMode.MEDIUM, z), momentFormat(DisplayMode.SHORT, z));
        return up.build().with(Leniency.STRICT).withTimezone((TZID) ZonalOffset.UTC);
    }

    private static ChronoFormatter<Moment> momentFormat(DisplayMode displayMode, boolean z) {
        ChronoFormatter.Builder<Moment> up = ChronoFormatter.setUp(Moment.class, Locale.ROOT);
        up.addCustomized(PlainDate.COMPONENT, generalDatePrinter(z), generalDateParser(z));
        up.addLiteral('T');
        addWallTime(up, z);
        up.addTimezoneOffset(displayMode, z, Collections.singletonList("Z"));
        return up.build();
    }

    private static ChronoPrinter<PlainDate> generalDatePrinter(final boolean z) {
        return new ChronoPrinter<PlainDate>() {
            public <R> R print(PlainDate plainDate, Appendable appendable, AttributeQuery attributeQuery, ChronoFunction<ChronoDisplay, R> chronoFunction) throws IOException {
                (z ? Iso8601Format.EXTENDED_CALENDAR_DATE : Iso8601Format.BASIC_CALENDAR_DATE).print(plainDate, appendable, attributeQuery);
                return null;
            }
        };
    }

    private static ChronoParser<PlainDate> generalDateParser(final boolean z) {
        return new ChronoParser<PlainDate>() {
            public PlainDate parse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery) {
                int length = charSequence.length();
                int position = parseLog.getPosition();
                int i = length - position;
                int i2 = position + 1;
                int i3 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    char charAt = charSequence.charAt(i2);
                    if (charAt == '-') {
                        i3++;
                    } else if (charAt == '/' || charAt == 'T') {
                        i = i2 - position;
                    } else if (charAt == 'W') {
                        if (z) {
                            return Iso8601Format.EXTENDED_WEEK_DATE.parse(charSequence, parseLog);
                        }
                        return Iso8601Format.BASIC_WEEK_DATE.parse(charSequence, parseLog);
                    }
                    i2++;
                }
                i = i2 - position;
                if (!z) {
                    int i4 = i - 4;
                    char charAt2 = charSequence.charAt(position);
                    if (charAt2 == '+' || charAt2 == '-') {
                        i4 -= 2;
                    }
                    if (i4 == 3) {
                        return Iso8601Format.BASIC_ORDINAL_DATE.parse(charSequence, parseLog);
                    }
                    return Iso8601Format.BASIC_CALENDAR_DATE.parse(charSequence, parseLog);
                } else if (i3 == 1) {
                    return Iso8601Format.EXTENDED_ORDINAL_DATE.parse(charSequence, parseLog);
                } else {
                    return Iso8601Format.EXTENDED_CALENDAR_DATE.parse(charSequence, parseLog);
                }
            }
        };
    }

    private static <T extends ChronoEntity<T>> void addWallTime(ChronoFormatter.Builder<T> builder, boolean z) {
        builder.startSection((AttributeKey<A>) Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC);
        builder.startSection(Attributes.ZERO_DIGIT, '0');
        builder.addFixedInteger(PlainTime.HOUR_FROM_0_TO_24, 2);
        builder.startOptionalSection();
        if (z) {
            builder.addLiteral((char) AbstractJsonLexerKt.COLON);
        }
        builder.addFixedInteger(PlainTime.MINUTE_OF_HOUR, 2);
        builder.startOptionalSection(SECOND_PART);
        if (z) {
            builder.addLiteral((char) AbstractJsonLexerKt.COLON);
        }
        builder.addFixedInteger(PlainTime.SECOND_OF_MINUTE, 2);
        builder.startOptionalSection(NON_ZERO_FRACTION);
        if (ISO_DECIMAL_SEPARATOR == ',') {
            builder.addLiteral(AbstractJsonLexerKt.COMMA, ClassUtils.PACKAGE_SEPARATOR_CHAR);
        } else {
            builder.addLiteral(ClassUtils.PACKAGE_SEPARATOR_CHAR, AbstractJsonLexerKt.COMMA);
        }
        builder.addFraction(PlainTime.NANO_OF_SECOND, 0, 9, false);
        for (int i = 0; i < 5; i++) {
            builder.endSection();
        }
    }

    private static class NonZeroCondition implements ChronoCondition<ChronoDisplay> {
        private final ChronoElement<Integer> element;

        NonZeroCondition(ChronoElement<Integer> chronoElement) {
            this.element = chronoElement;
        }

        public boolean test(ChronoDisplay chronoDisplay) {
            return chronoDisplay.getInt(this.element) > 0;
        }

        /* access modifiers changed from: package-private */
        public ChronoCondition<ChronoDisplay> or(final NonZeroCondition nonZeroCondition) {
            return new ChronoCondition<ChronoDisplay>() {
                public boolean test(ChronoDisplay chronoDisplay) {
                    return NonZeroCondition.this.test(chronoDisplay) || nonZeroCondition.test(chronoDisplay);
                }
            };
        }
    }

    private static class TCondition implements ChronoCondition<Character> {
        private TCondition() {
        }

        public boolean test(Character ch) {
            return ch.charValue() == 'T';
        }
    }
}
