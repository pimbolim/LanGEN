package net.time4j.calendar;

import java.io.IOException;
import java.io.ObjectStreamException;
import java.text.ParsePosition;
import java.util.Locale;
import net.time4j.PlainDate;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.CalendarEra;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.Chronology;
import net.time4j.engine.ElementRule;
import net.time4j.engine.FormattableElement;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.DisplayElement;
import net.time4j.format.TextElement;
import net.time4j.format.TextWidth;

public enum KoreanEra implements CalendarEra {
    DANGI;
    
    private final transient ChronoElement<KoreanEra> eraElement;
    private final transient ChronoElement<Integer> yearOfEraElement;

    public String getDisplayName(Locale locale) {
        return getDisplayName(locale, TextWidth.WIDE);
    }

    public String getDisplayName(Locale locale, TextWidth textWidth) {
        return CalendarText.getInstance("dangi", locale).getEras(textWidth).print(this);
    }

    /* access modifiers changed from: package-private */
    @FormattableElement(format = "G")
    public ChronoElement<KoreanEra> era() {
        return this.eraElement;
    }

    /* access modifiers changed from: package-private */
    @FormattableElement(format = "y")
    public ChronoElement<Integer> yearOfEra() {
        return this.yearOfEraElement;
    }

    private static class EraElement extends DisplayElement<KoreanEra> implements TextElement<KoreanEra> {
        private static final long serialVersionUID = -5179188137244162427L;

        public char getSymbol() {
            return 'G';
        }

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

        private EraElement() {
            super("ERA");
        }

        public Class<KoreanEra> getType() {
            return KoreanEra.class;
        }

        public KoreanEra getDefaultMinimum() {
            return KoreanEra.DANGI;
        }

        public KoreanEra getDefaultMaximum() {
            return KoreanEra.DANGI;
        }

        public void print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery) throws IOException, ChronoException {
            appendable.append(KoreanEra.DANGI.getDisplayName((Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT), (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE)));
        }

        public KoreanEra parse(CharSequence charSequence, ParsePosition parsePosition, AttributeQuery attributeQuery) {
            Locale locale = (Locale) attributeQuery.get(Attributes.LANGUAGE, Locale.ROOT);
            boolean booleanValue = ((Boolean) attributeQuery.get(Attributes.PARSE_CASE_INSENSITIVE, Boolean.TRUE)).booleanValue();
            boolean booleanValue2 = ((Boolean) attributeQuery.get(Attributes.PARSE_PARTIAL_COMPARE, Boolean.FALSE)).booleanValue();
            int index = parsePosition.getIndex();
            String displayName = KoreanEra.DANGI.getDisplayName(locale, (TextWidth) attributeQuery.get(Attributes.TEXT_WIDTH, TextWidth.WIDE));
            int max = Math.max(Math.min(displayName.length() + index, charSequence.length()), index);
            if (max > index) {
                String charSequence2 = charSequence.subSequence(index, max).toString();
                if (booleanValue) {
                    displayName = displayName.toLowerCase(locale);
                    charSequence2 = charSequence2.toLowerCase(locale);
                }
                if (displayName.equals(charSequence2) || (booleanValue2 && displayName.startsWith(charSequence2))) {
                    parsePosition.setIndex(max);
                    return KoreanEra.DANGI;
                }
            }
            parsePosition.setErrorIndex(index);
            return null;
        }

        /* access modifiers changed from: protected */
        public <T extends ChronoEntity<T>> ElementRule<T, KoreanEra> derive(Chronology<T> chronology) {
            if (chronology.isRegistered(PlainDate.COMPONENT)) {
                return new EraRule();
            }
            return null;
        }

        private Object readResolve() throws ObjectStreamException {
            return KoreanEra.DANGI.era();
        }
    }

    private static class EraRule implements ElementRule<ChronoEntity<?>, KoreanEra> {
        private EraRule() {
        }

        public KoreanEra getValue(ChronoEntity<?> chronoEntity) {
            return KoreanEra.DANGI;
        }

        public KoreanEra getMinimum(ChronoEntity<?> chronoEntity) {
            return KoreanEra.DANGI;
        }

        public KoreanEra getMaximum(ChronoEntity<?> chronoEntity) {
            return KoreanEra.DANGI;
        }

        public boolean isValid(ChronoEntity<?> chronoEntity, KoreanEra koreanEra) {
            return koreanEra == KoreanEra.DANGI;
        }

        public ChronoEntity<?> withValue(ChronoEntity<?> chronoEntity, KoreanEra koreanEra, boolean z) {
            if (isValid(chronoEntity, koreanEra)) {
                return chronoEntity;
            }
            throw new IllegalArgumentException("Invalid Korean era: " + koreanEra);
        }

        public ChronoElement<?> getChildAtFloor(ChronoEntity<?> chronoEntity) {
            throw new AbstractMethodError("Never called.");
        }

        public ChronoElement<?> getChildAtCeiling(ChronoEntity<?> chronoEntity) {
            throw new AbstractMethodError("Never called.");
        }
    }

    private static class YearOfEraElement extends DisplayElement<Integer> {
        private static final long serialVersionUID = -7864513245908399367L;

        public char getSymbol() {
            return 'y';
        }

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

        private YearOfEraElement() {
            super("YEAR_OF_ERA");
        }

        public Class<Integer> getType() {
            return Integer.class;
        }

        public Integer getDefaultMinimum() {
            return 3978;
        }

        public Integer getDefaultMaximum() {
            return 5332;
        }

        /* access modifiers changed from: protected */
        public <T extends ChronoEntity<T>> ElementRule<T, Integer> derive(Chronology<T> chronology) {
            if (chronology.isRegistered(PlainDate.COMPONENT)) {
                return new GregorianYearOfEraRule();
            }
            return null;
        }

        private Object readResolve() throws ObjectStreamException {
            return KoreanEra.DANGI.yearOfEra();
        }
    }

    private static class GregorianYearOfEraRule implements ElementRule<ChronoEntity<?>, Integer> {
        private GregorianYearOfEraRule() {
        }

        public Integer getValue(ChronoEntity<?> chronoEntity) {
            return Integer.valueOf(getInt(chronoEntity));
        }

        public Integer getMinimum(ChronoEntity<?> chronoEntity) {
            return -999997666;
        }

        public Integer getMaximum(ChronoEntity<?> chronoEntity) {
            return 1000002332;
        }

        public boolean isValid(ChronoEntity<?> chronoEntity, Integer num) {
            if (num == null) {
                return false;
            }
            int intValue = getMinimum(chronoEntity).intValue();
            int intValue2 = getMaximum(chronoEntity).intValue();
            if (num.intValue() < intValue || num.intValue() > intValue2) {
                return false;
            }
            return true;
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [net.time4j.engine.ChronoEntity<?>, net.time4j.engine.ChronoEntity] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.time4j.engine.ChronoEntity<?> withValue(net.time4j.engine.ChronoEntity<?> r3, java.lang.Integer r4, boolean r5) {
            /*
                r2 = this;
                if (r4 == 0) goto L_0x0040
                boolean r5 = r2.isValid((net.time4j.engine.ChronoEntity<?>) r3, (java.lang.Integer) r4)
                if (r5 == 0) goto L_0x0029
                int r5 = r2.getInt(r3)
                net.time4j.CalendarDateElement r0 = net.time4j.PlainDate.COMPONENT
                java.lang.Object r0 = r3.get(r0)
                net.time4j.PlainDate r0 = (net.time4j.PlainDate) r0
                int r4 = r4.intValue()
                int r4 = r4 - r5
                long r4 = (long) r4
                net.time4j.CalendarUnit r1 = net.time4j.CalendarUnit.YEARS
                net.time4j.engine.TimePoint r4 = r0.plus(r4, r1)
                net.time4j.PlainDate r4 = (net.time4j.PlainDate) r4
                net.time4j.CalendarDateElement r5 = net.time4j.PlainDate.COMPONENT
                net.time4j.engine.ChronoEntity r3 = r3.with(r5, r4)
                return r3
            L_0x0029:
                java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r0 = "Invalid year of era: "
                r5.append(r0)
                r5.append(r4)
                java.lang.String r4 = r5.toString()
                r3.<init>(r4)
                throw r3
            L_0x0040:
                java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
                java.lang.String r4 = "Missing year of era."
                r3.<init>(r4)
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.KoreanEra.GregorianYearOfEraRule.withValue(net.time4j.engine.ChronoEntity, java.lang.Integer, boolean):net.time4j.engine.ChronoEntity");
        }

        public ChronoElement<?> getChildAtFloor(ChronoEntity<?> chronoEntity) {
            throw new AbstractMethodError("Never called.");
        }

        public ChronoElement<?> getChildAtCeiling(ChronoEntity<?> chronoEntity) {
            throw new AbstractMethodError("Never called.");
        }

        private int getInt(ChronoEntity<?> chronoEntity) {
            return ((PlainDate) chronoEntity.get((ChronoElement<V>) PlainDate.COMPONENT)).getYear() + 2333;
        }
    }
}
