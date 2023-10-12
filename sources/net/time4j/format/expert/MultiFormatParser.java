package net.time4j.format.expert;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoEntity;

public final class MultiFormatParser<T extends ChronoEntity<T>> implements ChronoParser<T> {
    private final ChronoFormatter<T>[] parsers;

    private MultiFormatParser(ChronoFormatter<T>[] chronoFormatterArr) {
        this.parsers = chronoFormatterArr;
        for (ChronoFormatter<T> requireNonNull : chronoFormatterArr) {
            Objects.requireNonNull(requireNonNull, "Null format cannot be set.");
        }
    }

    @SafeVarargs
    public static <T extends ChronoEntity<T>> MultiFormatParser<T> of(ChronoFormatter<T>... chronoFormatterArr) {
        return new MultiFormatParser<>((ChronoFormatter[]) Arrays.copyOf(chronoFormatterArr, chronoFormatterArr.length));
    }

    public static <T extends ChronoEntity<T>> MultiFormatParser<T> of(List<ChronoFormatter<T>> list) {
        return new MultiFormatParser<>((ChronoFormatter[]) list.toArray((ChronoFormatter[]) Array.newInstance(ChronoFormatter.class, list.size())));
    }

    public T parse(CharSequence charSequence) throws ParseException {
        ParseLog parseLog = new ParseLog();
        for (int i = 0; i < this.parsers.length; i++) {
            parseLog.reset();
            parseLog.setPosition(0);
            T t = (ChronoEntity) this.parsers[i].parse(charSequence, parseLog);
            if (t != null && !parseLog.isError() && (this.parsers[i].isToleratingTrailingChars() || parseLog.getPosition() == charSequence.length())) {
                return t;
            }
        }
        throw new ParseException("Not matched by any format: " + charSequence, charSequence.length());
    }

    public T parse(CharSequence charSequence, ParseLog parseLog) {
        int position = parseLog.getPosition();
        for (ChronoFormatter<T> parse : this.parsers) {
            parseLog.reset();
            parseLog.setPosition(position);
            T t = (ChronoEntity) parse.parse(charSequence, parseLog);
            if (t != null && !parseLog.isError()) {
                return t;
            }
        }
        parseLog.setError(parseLog.getErrorIndex(), "Not matched by any format: " + charSequence);
        return null;
    }

    public T parse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery) {
        int position = parseLog.getPosition();
        for (ChronoFormatter<T> parse : this.parsers) {
            parseLog.reset();
            parseLog.setPosition(position);
            T t = (ChronoEntity) parse.parse(charSequence, parseLog, attributeQuery);
            if (t != null && !parseLog.isError()) {
                return t;
            }
        }
        parseLog.setError(parseLog.getErrorIndex(), "Not matched by any format: " + charSequence);
        return null;
    }
}
