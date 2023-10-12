package net.time4j.format.expert;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.base.ResourceLoader;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoCondition;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.Chronology;
import net.time4j.format.Attributes;
import net.time4j.format.Leniency;
import net.time4j.format.NumberSymbolProvider;
import net.time4j.format.NumberSystem;
import net.time4j.format.OutputContext;
import net.time4j.format.TextWidth;
import net.time4j.i18n.LanguageMatch;
import net.time4j.i18n.SymbolProviderSPI;
import org.apache.commons.lang3.ClassUtils;

final class AttributeSet implements AttributeQuery {
    private static final NumericalSymbols DEFAULT_NUMERICAL_SYMBOLS;
    private static final char ISO_DECIMAL_SEPARATOR;
    static final AttributeKey<String> MINUS_SIGN = Attributes.createKey("MINUS_SIGN", String.class);
    private static final NumberSymbolProvider NUMBER_SYMBOLS;
    private static final ConcurrentMap<String, NumericalSymbols> NUMBER_SYMBOL_CACHE = new ConcurrentHashMap();
    static final AttributeKey<String> PLUS_SIGN = Attributes.createKey("PLUS_SIGN", String.class);
    private final Attributes attributes;
    private final Map<String, Object> internals;
    private final int level;
    private final Locale locale;
    private final ChronoCondition<ChronoDisplay> printCondition;
    private final int section;

    static {
        NumberSymbolProvider numberSymbolProvider = null;
        int i = 0;
        for (NumberSymbolProvider next : ResourceLoader.getInstance().services(NumberSymbolProvider.class)) {
            int length = next.getAvailableLocales().length;
            if (length > i) {
                numberSymbolProvider = next;
                i = length;
            }
        }
        if (numberSymbolProvider == null) {
            numberSymbolProvider = SymbolProviderSPI.INSTANCE;
        }
        NUMBER_SYMBOLS = numberSymbolProvider;
        char c = Boolean.getBoolean("net.time4j.format.iso.decimal.dot") ? ClassUtils.PACKAGE_SEPARATOR_CHAR : AbstractJsonLexerKt.COMMA;
        ISO_DECIMAL_SEPARATOR = c;
        DEFAULT_NUMERICAL_SYMBOLS = new NumericalSymbols(NumberSystem.ARABIC, '0', c, "+", "-");
    }

    AttributeSet(Attributes attributes2, Locale locale2) {
        this(attributes2, locale2, 0, 0, (ChronoCondition<ChronoDisplay>) null);
    }

    AttributeSet(Attributes attributes2, Locale locale2, int i, int i2, ChronoCondition<ChronoDisplay> chronoCondition) {
        Objects.requireNonNull(attributes2, "Missing format attributes.");
        this.attributes = attributes2;
        this.locale = locale2 == null ? Locale.ROOT : locale2;
        this.level = i;
        this.section = i2;
        this.printCondition = chronoCondition;
        this.internals = Collections.emptyMap();
    }

    private AttributeSet(Attributes attributes2, Locale locale2, int i, int i2, ChronoCondition<ChronoDisplay> chronoCondition, Map<String, Object> map) {
        Objects.requireNonNull(attributes2, "Missing format attributes.");
        this.attributes = attributes2;
        this.locale = locale2 == null ? Locale.ROOT : locale2;
        this.level = i;
        this.section = i2;
        this.printCondition = chronoCondition;
        this.internals = Collections.unmodifiableMap(map);
    }

    public boolean contains(AttributeKey<?> attributeKey) {
        if (this.internals.containsKey(attributeKey.name())) {
            return true;
        }
        return this.attributes.contains(attributeKey);
    }

    public <A> A get(AttributeKey<A> attributeKey) {
        if (this.internals.containsKey(attributeKey.name())) {
            return attributeKey.type().cast(this.internals.get(attributeKey.name()));
        }
        return this.attributes.get(attributeKey);
    }

    public <A> A get(AttributeKey<A> attributeKey, A a) {
        if (this.internals.containsKey(attributeKey.name())) {
            return attributeKey.type().cast(this.internals.get(attributeKey.name()));
        }
        return this.attributes.get(attributeKey, a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AttributeSet)) {
            return false;
        }
        AttributeSet attributeSet = (AttributeSet) obj;
        if (!this.attributes.equals(attributeSet.attributes) || !this.locale.equals(attributeSet.locale) || this.level != attributeSet.level || this.section != attributeSet.section || !isEqual(this.printCondition, attributeSet.printCondition) || !this.internals.equals(attributeSet.internals)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.attributes.hashCode() * 7) + (this.internals.hashCode() * 37);
    }

    public String toString() {
        return getClass().getName() + "[attributes=" + this.attributes + ",locale=" + this.locale + ",level=" + this.level + ",section=" + this.section + ",print-condition=" + this.printCondition + ",other=" + this.internals + AbstractJsonLexerKt.END_LIST;
    }

    /* access modifiers changed from: package-private */
    public Attributes getAttributes() {
        return this.attributes;
    }

    /* access modifiers changed from: package-private */
    public Locale getLocale() {
        return this.locale;
    }

    /* access modifiers changed from: package-private */
    public int getLevel() {
        return this.level;
    }

    /* access modifiers changed from: package-private */
    public int getSection() {
        return this.section;
    }

    /* access modifiers changed from: package-private */
    public ChronoCondition<ChronoDisplay> getCondition() {
        return this.printCondition;
    }

    static AttributeSet createDefaults(Chronology<?> chronology, Attributes attributes2, Locale locale2) {
        Attributes.Builder builder = new Attributes.Builder(chronology);
        builder.set(Attributes.LENIENCY, Leniency.SMART);
        builder.set(Attributes.TEXT_WIDTH, TextWidth.WIDE);
        builder.set(Attributes.OUTPUT_CONTEXT, OutputContext.FORMAT);
        builder.set(Attributes.PAD_CHAR, ' ');
        builder.setAll(attributes2);
        return new AttributeSet(builder.build(), locale2).withLocale(locale2);
    }

    /* access modifiers changed from: package-private */
    public AttributeSet withAttributes(Attributes attributes2) {
        return new AttributeSet(attributes2, this.locale, this.level, this.section, this.printCondition, this.internals);
    }

    /* access modifiers changed from: package-private */
    public <A> AttributeSet withInternal(AttributeKey<A> attributeKey, A a) {
        HashMap hashMap = new HashMap(this.internals);
        if (a == null) {
            hashMap.remove(attributeKey.name());
        } else {
            hashMap.put(attributeKey.name(), a);
        }
        return new AttributeSet(this.attributes, this.locale, this.level, this.section, this.printCondition, hashMap);
    }

    /* access modifiers changed from: package-private */
    public AttributeSet withLocale(Locale locale2) {
        String access$300;
        String access$400;
        Attributes.Builder builder = new Attributes.Builder();
        builder.setAll(this.attributes);
        String alias = LanguageMatch.getAlias(locale2);
        String country = locale2.getCountry();
        if (!alias.isEmpty() || !country.isEmpty()) {
            if (!country.isEmpty()) {
                alias = alias + "_" + country;
            }
            NumericalSymbols numericalSymbols = (NumericalSymbols) NUMBER_SYMBOL_CACHE.get(alias);
            if (numericalSymbols == null) {
                try {
                    NumberSymbolProvider numberSymbolProvider = NUMBER_SYMBOLS;
                    numericalSymbols = new NumericalSymbols(numberSymbolProvider.getDefaultNumberSystem(locale2), numberSymbolProvider.getZeroDigit(locale2), numberSymbolProvider.getDecimalSeparator(locale2), numberSymbolProvider.getPlusSign(locale2), numberSymbolProvider.getMinusSign(locale2));
                } catch (RuntimeException unused) {
                    numericalSymbols = DEFAULT_NUMERICAL_SYMBOLS;
                }
                NumericalSymbols putIfAbsent = NUMBER_SYMBOL_CACHE.putIfAbsent(alias, numericalSymbols);
                if (putIfAbsent != null) {
                    numericalSymbols = putIfAbsent;
                }
            }
            builder.set(Attributes.NUMBER_SYSTEM, numericalSymbols.numsys);
            builder.set(Attributes.ZERO_DIGIT, numericalSymbols.zeroDigit);
            builder.set(Attributes.DECIMAL_SEPARATOR, numericalSymbols.decimalSeparator);
            access$300 = numericalSymbols.plus;
            access$400 = numericalSymbols.minus;
        } else {
            locale2 = Locale.ROOT;
            builder.set(Attributes.NUMBER_SYSTEM, NumberSystem.ARABIC);
            builder.set(Attributes.DECIMAL_SEPARATOR, ISO_DECIMAL_SEPARATOR);
            access$300 = "+";
            access$400 = "-";
        }
        Locale locale3 = locale2;
        builder.setLanguage(locale3);
        HashMap hashMap = new HashMap(this.internals);
        hashMap.put(PLUS_SIGN.name(), access$300);
        hashMap.put(MINUS_SIGN.name(), access$400);
        return new AttributeSet(builder.build(), locale3, this.level, this.section, this.printCondition, hashMap);
    }

    static AttributeSet merge(AttributeSet attributeSet, AttributeSet attributeSet2) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(attributeSet2.internals);
        hashMap.putAll(attributeSet.internals);
        return new AttributeSet(new Attributes.Builder().setAll(attributeSet2.attributes).setAll(attributeSet.attributes).build(), Locale.ROOT, 0, 0, (ChronoCondition<ChronoDisplay>) null, hashMap).withLocale(attributeSet.locale);
    }

    private static boolean isEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    private static class NumericalSymbols {
        /* access modifiers changed from: private */
        public final char decimalSeparator;
        /* access modifiers changed from: private */
        public final String minus;
        /* access modifiers changed from: private */
        public final NumberSystem numsys;
        /* access modifiers changed from: private */
        public final String plus;
        /* access modifiers changed from: private */
        public final char zeroDigit;

        NumericalSymbols(NumberSystem numberSystem, char c, char c2, String str, String str2) {
            this.numsys = numberSystem;
            this.zeroDigit = c;
            this.decimalSeparator = c2;
            this.plus = str;
            this.minus = str2;
        }
    }
}
