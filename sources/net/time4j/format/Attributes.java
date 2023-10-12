package net.time4j.format;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.Chronology;
import net.time4j.engine.StartOfDay;
import net.time4j.scale.TimeScale;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.TransitionStrategy;

public final class Attributes implements AttributeQuery {
    public static final AttributeKey<String> CALENDAR_TYPE = PredefinedKey.valueOf("CALENDAR_TYPE", String.class);
    public static final AttributeKey<String> CALENDAR_VARIANT = PredefinedKey.valueOf("CALENDAR_VARIANT", String.class);
    public static final AttributeKey<Character> DECIMAL_SEPARATOR = PredefinedKey.valueOf("DECIMAL_SEPARATOR", Character.class);
    private static final Attributes EMPTY = new Attributes();
    public static final AttributeKey<String> FORMAT_PATTERN = PredefinedKey.valueOf("FORMAT_PATTERN", String.class);
    public static final AttributeKey<Boolean> FOUR_DIGIT_YEAR = PredefinedKey.valueOf("FOUR_DIGIT_YEAR", Boolean.class);
    public static final AttributeKey<Locale> LANGUAGE = PredefinedKey.valueOf("LANGUAGE", Locale.class);
    public static final AttributeKey<Leniency> LENIENCY = PredefinedKey.valueOf("LENIENCY", Leniency.class);
    public static final AttributeKey<Boolean> NO_GMT_PREFIX = PredefinedKey.valueOf("NO_GMT_PREFIX", Boolean.class);
    public static final AttributeKey<NumberSystem> NUMBER_SYSTEM = PredefinedKey.valueOf("NUMBER_SYSTEM", NumberSystem.class);
    public static final AttributeKey<OutputContext> OUTPUT_CONTEXT = PredefinedKey.valueOf("OUTPUT_CONTEXT", OutputContext.class);
    public static final AttributeKey<Character> PAD_CHAR = PredefinedKey.valueOf("PAD_CHAR", Character.class);
    public static final AttributeKey<Boolean> PARSE_CASE_INSENSITIVE = PredefinedKey.valueOf("PARSE_CASE_INSENSITIVE", Boolean.class);
    public static final AttributeKey<Boolean> PARSE_MULTIPLE_CONTEXT = PredefinedKey.valueOf("PARSE_MULTIPLE_CONTEXT", Boolean.class);
    public static final AttributeKey<Boolean> PARSE_PARTIAL_COMPARE = PredefinedKey.valueOf("PARSE_PARTIAL_COMPARE", Boolean.class);
    public static final AttributeKey<Integer> PIVOT_YEAR = PredefinedKey.valueOf("PIVOT_YEAR", Integer.class);
    public static final AttributeKey<Integer> PROTECTED_CHARACTERS = PredefinedKey.valueOf("PROTECTED_CHARACTERS", Integer.class);
    public static final AttributeKey<StartOfDay> START_OF_DAY = PredefinedKey.valueOf("START_OF_DAY", StartOfDay.class);
    public static final AttributeKey<TextWidth> TEXT_WIDTH = PredefinedKey.valueOf("TEXT_WIDTH", TextWidth.class);
    public static final AttributeKey<TZID> TIMEZONE_ID = PredefinedKey.valueOf("TIMEZONE_ID", TZID.class);
    public static final AttributeKey<TimeScale> TIME_SCALE = PredefinedKey.valueOf("TIME_SCALE", TimeScale.class);
    public static final AttributeKey<Boolean> TRAILING_CHARACTERS = PredefinedKey.valueOf("TRAILING_CHARACTERS", Boolean.class);
    public static final AttributeKey<TransitionStrategy> TRANSITION_STRATEGY = PredefinedKey.valueOf("TRANSITION_STRATEGY", TransitionStrategy.class);
    public static final AttributeKey<Character> ZERO_DIGIT = PredefinedKey.valueOf("ZERO_DIGIT", Character.class);
    /* access modifiers changed from: private */
    public final Map<String, Object> attributes;

    /* synthetic */ Attributes(Map map, AnonymousClass1 r2) {
        this(map);
    }

    private Attributes() {
        this.attributes = Collections.emptyMap();
    }

    private Attributes(Map<String, Object> map) {
        this.attributes = Collections.unmodifiableMap(new HashMap(map));
    }

    public static Attributes empty() {
        return EMPTY;
    }

    public static <A> AttributeKey<A> createKey(String str, Class<A> cls) {
        return PredefinedKey.valueOf(str, cls);
    }

    public boolean contains(AttributeKey<?> attributeKey) {
        return this.attributes.containsKey(attributeKey.name());
    }

    public <A> A get(AttributeKey<A> attributeKey) {
        Object obj = this.attributes.get(attributeKey.name());
        if (obj != null) {
            return attributeKey.type().cast(obj);
        }
        throw new NoSuchElementException(attributeKey.name());
    }

    public <A> A get(AttributeKey<A> attributeKey, A a) {
        Object obj = this.attributes.get(attributeKey.name());
        if (obj == null) {
            return a;
        }
        return attributeKey.type().cast(obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Attributes) {
            return this.attributes.equals(((Attributes) obj).attributes);
        }
        return false;
    }

    public int hashCode() {
        return this.attributes.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.attributes.size() * 32);
        sb.append(getClass().getName());
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        sb.append(this.attributes);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public static final class Builder {
        private final Map<String, Object> attrs = new HashMap();

        public Builder() {
        }

        public Builder(Chronology<?> chronology) {
            setInternal(Attributes.CALENDAR_TYPE, CalendarText.extractCalendarType(chronology));
        }

        public Builder setLanguage(Locale locale) {
            setInternal(Attributes.LANGUAGE, locale);
            return this;
        }

        public Builder setTimezone(TZID tzid) {
            setInternal(Attributes.TIMEZONE_ID, tzid);
            return this;
        }

        public Builder setTimezone(String str) {
            setTimezone(Timezone.of(str).getID());
            return this;
        }

        public Builder setStdTimezone() {
            return setTimezone(Timezone.ofSystem().getID());
        }

        public Builder setCalendarVariant(String str) {
            setInternal(Attributes.CALENDAR_VARIANT, str);
            return this;
        }

        public Builder set(AttributeKey<Boolean> attributeKey, boolean z) {
            this.attrs.put(attributeKey.name(), Boolean.valueOf(z));
            return this;
        }

        public Builder set(AttributeKey<Integer> attributeKey, int i) {
            if (attributeKey != Attributes.PIVOT_YEAR || i >= 100) {
                this.attrs.put(attributeKey.name(), Integer.valueOf(i));
                return this;
            }
            throw new IllegalArgumentException("Pivot year in far past not supported: " + i);
        }

        public Builder set(AttributeKey<Character> attributeKey, char c) {
            this.attrs.put(attributeKey.name(), Character.valueOf(c));
            return this;
        }

        public <A extends Enum<A>> Builder set(AttributeKey<A> attributeKey, A a) {
            if (a == null) {
                throw new NullPointerException("Missing attribute value for key: " + attributeKey);
            } else if (a instanceof Enum) {
                this.attrs.put(attributeKey.name(), a);
                if (attributeKey == Attributes.LENIENCY) {
                    int i = AnonymousClass1.$SwitchMap$net$time4j$format$Leniency[Leniency.class.cast(a).ordinal()];
                    if (i == 1) {
                        set(Attributes.PARSE_CASE_INSENSITIVE, false);
                        set(Attributes.PARSE_PARTIAL_COMPARE, false);
                        set(Attributes.TRAILING_CHARACTERS, false);
                        set(Attributes.PARSE_MULTIPLE_CONTEXT, false);
                    } else if (i == 2) {
                        set(Attributes.PARSE_CASE_INSENSITIVE, true);
                        set(Attributes.PARSE_PARTIAL_COMPARE, false);
                        set(Attributes.TRAILING_CHARACTERS, false);
                        set(Attributes.PARSE_MULTIPLE_CONTEXT, true);
                    } else if (i == 3) {
                        set(Attributes.PARSE_CASE_INSENSITIVE, true);
                        set(Attributes.PARSE_PARTIAL_COMPARE, true);
                        set(Attributes.TRAILING_CHARACTERS, true);
                        set(Attributes.PARSE_MULTIPLE_CONTEXT, true);
                    } else {
                        throw new UnsupportedOperationException(a.name());
                    }
                } else if (attributeKey == Attributes.NUMBER_SYSTEM) {
                    NumberSystem cast = NumberSystem.class.cast(a);
                    if (cast.isDecimal()) {
                        set(Attributes.ZERO_DIGIT, cast.getDigits().charAt(0));
                    }
                }
                return this;
            } else {
                throw new ClassCastException("Enum expected, but found: " + a);
            }
        }

        public Builder setAll(Attributes attributes) {
            this.attrs.putAll(attributes.attributes);
            return this;
        }

        public Builder remove(AttributeKey<?> attributeKey) {
            this.attrs.remove(attributeKey.name());
            return this;
        }

        public Attributes build() {
            return new Attributes(this.attrs, (AnonymousClass1) null);
        }

        private <A> void setInternal(AttributeKey<A> attributeKey, A a) {
            if (a != null) {
                this.attrs.put(attributeKey.name(), a);
                return;
            }
            throw new NullPointerException("Missing attribute value for key: " + attributeKey);
        }
    }

    /* renamed from: net.time4j.format.Attributes$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$Leniency;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                net.time4j.format.Leniency[] r0 = net.time4j.format.Leniency.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$format$Leniency = r0
                net.time4j.format.Leniency r1 = net.time4j.format.Leniency.STRICT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$format$Leniency     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.format.Leniency r1 = net.time4j.format.Leniency.SMART     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$format$Leniency     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.format.Leniency r1 = net.time4j.format.Leniency.LAX     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.Attributes.AnonymousClass1.<clinit>():void");
        }
    }
}
