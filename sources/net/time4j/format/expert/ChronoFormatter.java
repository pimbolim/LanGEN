package net.time4j.format.expert;

import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.CalendarUnit;
import net.time4j.DayPeriod;
import net.time4j.GeneralTimestamp;
import net.time4j.Moment;
import net.time4j.PlainDate;
import net.time4j.PlainTime;
import net.time4j.PlainTimestamp;
import net.time4j.base.TimeSource;
import net.time4j.base.UnixTime;
import net.time4j.engine.AttributeKey;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.BridgeChronology;
import net.time4j.engine.CalendarFamily;
import net.time4j.engine.CalendarVariant;
import net.time4j.engine.Calendrical;
import net.time4j.engine.ChronoCondition;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.ChronoExtension;
import net.time4j.engine.ChronoFunction;
import net.time4j.engine.ChronoMerger;
import net.time4j.engine.Chronology;
import net.time4j.engine.DisplayStyle;
import net.time4j.engine.FlagElement;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.TimeAxis;
import net.time4j.engine.TimePoint;
import net.time4j.engine.ValidationElement;
import net.time4j.engine.VariantSource;
import net.time4j.format.Attributes;
import net.time4j.format.CalendarText;
import net.time4j.format.DisplayMode;
import net.time4j.format.Leniency;
import net.time4j.format.LocalizedPatternSupport;
import net.time4j.format.PluralCategory;
import net.time4j.format.RawValues;
import net.time4j.format.TemporalFormatter;
import net.time4j.format.TextElement;
import net.time4j.format.TextWidth;
import net.time4j.history.ChronoHistory;
import net.time4j.history.internal.HistoricAttribute;
import net.time4j.tz.NameStyle;
import net.time4j.tz.OffsetSign;
import net.time4j.tz.OverlapResolver;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.TransitionStrategy;
import net.time4j.tz.ZonalOffset;
import org.apache.commons.lang3.time.TimeZones;

public final class ChronoFormatter<T> implements ChronoPrinter<T>, ChronoParser<T>, TemporalFormatter<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final ChronoFormatter<Moment> RFC_1123 = rfc1123();
    private final Chronology<T> chronology;
    private final int countOfElements;
    private final Chronology<?> deepestParser;
    private final Map<ChronoElement<?>, Object> defaults;
    private final FractionProcessor fracproc;
    /* access modifiers changed from: private */
    public final AttributeSet globalAttributes;
    private final boolean hasOptionals;
    private final boolean hasOrMarkers;
    private final boolean indexable;
    private final Leniency leniency;
    private final boolean needsExtensions;
    private final boolean noPreparser;
    private final OverrideHandler<?> overrideHandler;
    private final boolean singleStepMode;
    private final int stepCount;
    private final List<FormatStep> steps;
    private final boolean trailing;

    /* access modifiers changed from: private */
    public static <T> T cast(Object obj) {
        return obj;
    }

    private ChronoFormatter(Chronology<T> chronology2, Chronology<?> chronology3, Locale locale, List<FormatStep> list, Map<ChronoElement<?>, Object> map, Attributes attributes, Chronology<?> chronology4) {
        Objects.requireNonNull(chronology2, "Missing chronology.");
        if (!list.isEmpty()) {
            this.chronology = chronology2;
            this.overrideHandler = OverrideHandler.of(chronology3);
            this.deepestParser = chronology4;
            AttributeSet createDefaults = AttributeSet.createDefaults(chronology3 == null ? chronology2 : chronology3, attributes, locale);
            this.globalAttributes = createDefaults;
            this.leniency = (Leniency) createDefaults.get(Attributes.LENIENCY, Leniency.SMART);
            this.defaults = Collections.unmodifiableMap(map);
            FractionProcessor fractionProcessor = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            boolean z4 = true;
            for (FormatStep next : list) {
                z2 = next.isNewOrBlockStarted() ? true : z2;
                if (fractionProcessor == null && (next.getProcessor() instanceof FractionProcessor)) {
                    fractionProcessor = FractionProcessor.class.cast(next.getProcessor());
                }
                if (!z && next.getLevel() > 0) {
                    z = true;
                }
                ChronoElement<?> element = next.getProcessor().getElement();
                if (element != null) {
                    i++;
                    if (z4 && !ParsedValues.isIndexed(element)) {
                        z4 = false;
                    }
                    if (!z3) {
                        z3 = needsExtension(chronology2, chronology3, element);
                    }
                }
            }
            this.fracproc = fractionProcessor;
            this.hasOptionals = z;
            this.hasOrMarkers = z2;
            this.needsExtensions = z3;
            this.countOfElements = i;
            this.indexable = z4;
            this.trailing = ((Boolean) this.globalAttributes.get(Attributes.TRAILING_CHARACTERS, Boolean.FALSE)).booleanValue();
            this.noPreparser = hasNoPreparser();
            this.stepCount = list.size();
            this.steps = freeze(list);
            this.singleStepMode = getSingleStepMode();
            return;
        }
        throw new IllegalStateException("No format processors defined.");
    }

    private ChronoFormatter(ChronoFormatter<T> chronoFormatter, Attributes attributes) {
        this(chronoFormatter, chronoFormatter.globalAttributes.withAttributes(attributes), (ChronoHistory) null);
    }

    private ChronoFormatter(ChronoFormatter<T> chronoFormatter, AttributeSet attributeSet) {
        this(chronoFormatter, attributeSet, (ChronoHistory) null);
    }

    private ChronoFormatter(ChronoFormatter<T> chronoFormatter, AttributeSet attributeSet, ChronoHistory chronoHistory) {
        Objects.requireNonNull(attributeSet, "Missing global format attributes.");
        this.chronology = chronoFormatter.chronology;
        this.overrideHandler = chronoFormatter.overrideHandler;
        this.deepestParser = chronoFormatter.deepestParser;
        this.globalAttributes = attributeSet;
        this.leniency = (Leniency) attributeSet.get(Attributes.LENIENCY, Leniency.SMART);
        this.defaults = Collections.unmodifiableMap(new NonAmbivalentMap(chronoFormatter.defaults));
        this.fracproc = chronoFormatter.fracproc;
        this.hasOptionals = chronoFormatter.hasOptionals;
        this.hasOrMarkers = chronoFormatter.hasOrMarkers;
        this.needsExtensions = chronoFormatter.needsExtensions || chronoHistory != null;
        this.countOfElements = chronoFormatter.countOfElements;
        int size = chronoFormatter.steps.size();
        ArrayList arrayList = new ArrayList(chronoFormatter.steps);
        boolean z = chronoFormatter.indexable;
        for (int i = 0; i < size; i++) {
            FormatStep formatStep = (FormatStep) arrayList.get(i);
            ChronoElement<?> element = formatStep.getProcessor().getElement();
            Chronology chronology2 = this.chronology;
            while (chronology2 instanceof BridgeChronology) {
                chronology2 = chronology2.preparser();
            }
            chronology2 = chronology2 == Moment.axis() ? chronology2.preparser() : chronology2;
            if (element != null && !chronology2.isRegistered(element)) {
                Iterator<ChronoExtension> it = chronology2.getExtensions().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ChronoExtension next = it.next();
                    if (next.getElements(chronoFormatter.getLocale(), chronoFormatter.globalAttributes).contains(element)) {
                        Iterator<ChronoElement<?>> it2 = next.getElements(attributeSet.getLocale(), attributeSet).iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            ChronoElement<?> next2 = it2.next();
                            if (next2.name().equals(element.name())) {
                                if (next2 != element) {
                                    arrayList.set(i, formatStep.updateElement(next2));
                                    z = false;
                                }
                            }
                        }
                    }
                }
            }
            if (chronoHistory != null) {
                ChronoElement chronoElement = null;
                if (element == PlainDate.YEAR) {
                    chronoElement = chronoHistory.yearOfEra();
                } else if (element == PlainDate.MONTH_OF_YEAR || element == PlainDate.MONTH_AS_NUMBER) {
                    chronoElement = chronoHistory.month();
                } else if (element == PlainDate.DAY_OF_MONTH) {
                    chronoElement = chronoHistory.dayOfMonth();
                } else if (element == PlainDate.DAY_OF_YEAR) {
                    chronoElement = chronoHistory.dayOfYear();
                }
                if (chronoElement != null) {
                    arrayList.set(i, formatStep.updateElement(chronoElement));
                }
                z = false;
            }
        }
        this.indexable = z;
        this.trailing = ((Boolean) this.globalAttributes.get(Attributes.TRAILING_CHARACTERS, Boolean.FALSE)).booleanValue();
        this.noPreparser = hasNoPreparser();
        this.stepCount = arrayList.size();
        this.steps = freeze(arrayList);
        this.singleStepMode = getSingleStepMode();
    }

    private ChronoFormatter(ChronoFormatter<T> chronoFormatter, Map<ChronoElement<?>, Object> map) {
        Chronology<?> chronology2;
        OverrideHandler<?> overrideHandler2 = chronoFormatter.overrideHandler;
        if (overrideHandler2 == null) {
            chronology2 = null;
        } else {
            chronology2 = overrideHandler2.getCalendarOverride();
        }
        for (ChronoElement<?> checkElement : map.keySet()) {
            checkElement(chronoFormatter.chronology, chronology2, checkElement);
        }
        this.chronology = chronoFormatter.chronology;
        this.overrideHandler = chronoFormatter.overrideHandler;
        this.deepestParser = chronoFormatter.deepestParser;
        this.globalAttributes = chronoFormatter.globalAttributes;
        this.leniency = chronoFormatter.leniency;
        this.fracproc = chronoFormatter.fracproc;
        this.hasOptionals = chronoFormatter.hasOptionals;
        this.hasOrMarkers = chronoFormatter.hasOrMarkers;
        this.needsExtensions = chronoFormatter.needsExtensions;
        this.countOfElements = chronoFormatter.countOfElements;
        this.trailing = chronoFormatter.trailing;
        HashMap hashMap = new HashMap(chronoFormatter.defaults);
        boolean z = chronoFormatter.indexable;
        for (ChronoElement next : map.keySet()) {
            Object obj = map.get(next);
            if (obj == null) {
                hashMap.remove(next);
            } else {
                hashMap.put(next, obj);
                z = z && ParsedValues.isIndexed(next);
            }
        }
        this.defaults = Collections.unmodifiableMap(hashMap);
        this.indexable = z;
        this.noPreparser = hasNoPreparser();
        this.stepCount = chronoFormatter.stepCount;
        this.steps = freeze(chronoFormatter.steps);
        this.singleStepMode = getSingleStepMode();
    }

    public Chronology<T> getChronology() {
        return this.chronology;
    }

    public Locale getLocale() {
        return this.globalAttributes.getLocale();
    }

    public String getPattern() {
        String str;
        if (isSingleStepOptimizationPossible()) {
            FormatProcessor<?> processor = this.steps.get(0).getProcessor();
            if (processor instanceof StyleProcessor) {
                str = StyleProcessor.class.cast(processor).getGeneratedPattern();
                return getPattern0(str);
            }
        }
        str = "";
        return getPattern0(str);
    }

    public AttributeQuery getAttributes() {
        return this.globalAttributes;
    }

    public String print(T t) {
        return format0(display(t, this.globalAttributes));
    }

    public String format(T t) {
        return print(t);
    }

    public String format(GeneralTimestamp<?> generalTimestamp) {
        return format0(generalTimestamp);
    }

    public Set<ElementPosition> print(T t, StringBuilder sb) {
        try {
            return print(display(t, this.globalAttributes), (Appendable) sb, (AttributeQuery) this.globalAttributes, true);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public Set<ElementPosition> print(T t, Appendable appendable, AttributeQuery attributeQuery) throws IOException {
        return print(display(t, attributeQuery), appendable, attributeQuery, true);
    }

    public <R> R print(T t, Appendable appendable, AttributeQuery attributeQuery, ChronoFunction<ChronoDisplay, R> chronoFunction) throws IOException {
        ChronoDisplay display = display(t, attributeQuery);
        print(display, appendable, attributeQuery, false);
        return chronoFunction.apply(display);
    }

    /* access modifiers changed from: package-private */
    public Set<ElementPosition> print(ChronoDisplay chronoDisplay, Appendable appendable, AttributeQuery attributeQuery, boolean z) throws IOException {
        LinkedList linkedList;
        int i;
        int i2;
        LinkedList linkedList2;
        LinkedList linkedList3;
        int i3;
        ChronoDisplay chronoDisplay2 = chronoDisplay;
        Appendable appendable2 = appendable;
        Objects.requireNonNull(appendable2, "Missing text result buffer.");
        int size = this.steps.size();
        int i4 = 0;
        boolean z2 = attributeQuery == this.globalAttributes;
        Set linkedHashSet = z ? new LinkedHashSet(size) : null;
        if (this.hasOrMarkers) {
            LinkedList linkedList4 = new LinkedList();
            linkedList4.push(new StringBuilder(size << 2));
            if (z) {
                LinkedList linkedList5 = new LinkedList();
                linkedList5.push(linkedHashSet);
                linkedList = linkedList5;
            } else {
                linkedList = null;
            }
            int i5 = 0;
            while (i5 < size) {
                FormatStep formatStep = this.steps.get(i5);
                int level = formatStep.getLevel();
                int i6 = level;
                while (i6 > i4) {
                    StringBuilder sb = new StringBuilder();
                    sb.append((CharSequence) linkedList4.peek());
                    linkedList4.push(sb);
                    if (z) {
                        linkedHashSet = new LinkedHashSet();
                        linkedHashSet.addAll((Collection) linkedList.peek());
                        linkedList.push(linkedHashSet);
                    }
                    i6--;
                }
                while (i6 < i4) {
                    linkedList4.pop();
                    linkedList4.push((StringBuilder) linkedList4.pop());
                    if (z) {
                        linkedHashSet = (Set) linkedList.pop();
                        linkedList.pop();
                        linkedList.push(linkedHashSet);
                    }
                    i6++;
                }
                StringBuilder sb2 = (StringBuilder) linkedList4.peek();
                if (z) {
                    linkedHashSet = (Set) linkedList.peek();
                }
                Set set = linkedHashSet;
                int i7 = i5;
                LinkedList linkedList6 = linkedList;
                LinkedList linkedList7 = linkedList4;
                try {
                    i = formatStep.print(chronoDisplay, sb2, attributeQuery, set, z2);
                    e = null;
                } catch (IllegalArgumentException | ChronoException e) {
                    e = e;
                    i = -1;
                }
                if (i == -1) {
                    int section = formatStep.getSection();
                    if (!formatStep.isNewOrBlockStarted()) {
                        i3 = i7;
                        i2 = i3 + 1;
                        while (true) {
                            if (i2 >= size) {
                                break;
                            }
                            FormatStep formatStep2 = this.steps.get(i2);
                            if (formatStep2.isNewOrBlockStarted() && formatStep2.getSection() == section) {
                                break;
                            }
                            i2++;
                        }
                    } else {
                        i3 = i7;
                    }
                    i2 = i3;
                    if (i2 > i3 || formatStep.isNewOrBlockStarted()) {
                        linkedList7.pop();
                        StringBuilder sb3 = new StringBuilder();
                        if (!linkedList7.isEmpty()) {
                            sb3.append((CharSequence) linkedList7.peek());
                        }
                        linkedList3 = linkedList7;
                        linkedList3.push(sb3);
                        if (z) {
                            linkedList6.pop();
                            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                            if (!linkedList6.isEmpty()) {
                                linkedHashSet2.addAll((Collection) linkedList6.peek());
                            }
                            linkedList2 = linkedList6;
                            linkedList2.push(linkedHashSet2);
                        } else {
                            linkedList2 = linkedList6;
                        }
                    } else if (e == null) {
                        throw new IllegalArgumentException("Not formattable: " + chronoDisplay2);
                    } else {
                        throw new IllegalArgumentException("Not formattable: " + chronoDisplay2, e);
                    }
                } else {
                    linkedList2 = linkedList6;
                    linkedList3 = linkedList7;
                    i2 = formatStep.isNewOrBlockStarted() ? formatStep.skipTrailingOrBlocks() : i7;
                }
                i5 = i2 + 1;
                linkedList4 = linkedList3;
                linkedList = linkedList2;
                linkedHashSet = set;
                i4 = level;
            }
            LinkedList linkedList8 = linkedList;
            LinkedList linkedList9 = linkedList4;
            linkedList9.clear();
            appendable2.append((StringBuilder) linkedList9.peek());
            if (z) {
                linkedHashSet = (Set) linkedList8.peek();
                linkedList8.clear();
            }
        } else {
            int i8 = 0;
            while (i8 < size) {
                try {
                    FormatStep formatStep3 = this.steps.get(i8);
                    formatStep3.print(chronoDisplay, appendable, attributeQuery, linkedHashSet, z2);
                    if (formatStep3.isNewOrBlockStarted()) {
                        i8 = formatStep3.skipTrailingOrBlocks();
                    }
                    i8++;
                } catch (ChronoException e2) {
                    throw new IllegalArgumentException("Not formattable: " + chronoDisplay2, e2);
                }
            }
        }
        if (z) {
            return Collections.unmodifiableSet(linkedHashSet);
        }
        return null;
    }

    public T parse(CharSequence charSequence) throws ParseException {
        ParseLog parseLog = new ParseLog();
        T parse = parse(charSequence, parseLog);
        if (parse != null) {
            int position = parseLog.getPosition();
            if (this.trailing || position >= charSequence.length()) {
                return parse;
            }
            throw new ParseException("Unparsed trailing characters: " + sub(position, charSequence), position);
        }
        throw new ParseException(parseLog.getErrorMessage(), parseLog.getErrorIndex());
    }

    public T parse(CharSequence charSequence, RawValues rawValues) throws ParseException {
        ParseLog parseLog = new ParseLog();
        T parse = parse(charSequence, parseLog);
        rawValues.accept(parseLog.getRawValues());
        if (parseLog.isError()) {
            throw new ParseException(parseLog.getErrorMessage(), parseLog.getErrorIndex());
        } else if (parse != null) {
            return parse;
        } else {
            throw new ParseException("Cannot parse: \"" + charSequence + "\"", 0);
        }
    }

    public T parse(CharSequence charSequence, ParseLog parseLog) {
        if (!this.noPreparser) {
            return parse(charSequence, parseLog, this.globalAttributes);
        }
        Chronology<T> chronology2 = this.chronology;
        return parse(this, chronology2, chronology2.getExtensions(), charSequence, parseLog, this.globalAttributes, this.leniency, false, true);
    }

    public T parse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery) {
        Leniency leniency2;
        MergedAttributes mergedAttributes;
        boolean z;
        TZID tzid;
        Moment moment;
        ParseLog parseLog2 = parseLog;
        AttributeQuery attributeQuery2 = attributeQuery;
        Leniency leniency3 = this.leniency;
        AttributeSet attributeSet = this.globalAttributes;
        if (attributeQuery2 != attributeSet) {
            MergedAttributes mergedAttributes2 = new MergedAttributes(attributeQuery2, attributeSet);
            mergedAttributes = mergedAttributes2;
            leniency2 = (Leniency) mergedAttributes2.get(Attributes.LENIENCY, Leniency.SMART);
            z = false;
        } else {
            leniency2 = leniency3;
            mergedAttributes = attributeQuery2;
            z = true;
        }
        OverrideHandler<?> overrideHandler2 = this.overrideHandler;
        if (overrideHandler2 != null) {
            List<ChronoExtension> extensions = overrideHandler2.getExtensions();
            OverrideHandler<?> overrideHandler3 = this.overrideHandler;
            GeneralTimestamp generalTimestamp = (GeneralTimestamp) parse(this, overrideHandler3, extensions, charSequence, parseLog, mergedAttributes, leniency2, true, z);
            if (parseLog.isError()) {
                return null;
            }
            ChronoEntity<?> rawValues0 = parseLog.getRawValues0();
            if (rawValues0.hasTimezone()) {
                tzid = rawValues0.getTimezone();
            } else {
                tzid = mergedAttributes.contains(Attributes.TIMEZONE_ID) ? (TZID) mergedAttributes.get(Attributes.TIMEZONE_ID) : null;
            }
            if (tzid != null) {
                StartOfDay startOfDay = (StartOfDay) attributeQuery2.get(Attributes.START_OF_DAY, overrideHandler3.getDefaultStartOfDay());
                if (rawValues0.contains(FlagElement.DAYLIGHT_SAVING)) {
                    moment = generalTimestamp.in(Timezone.of(tzid).with(((TransitionStrategy) mergedAttributes.get(Attributes.TRANSITION_STRATEGY, Timezone.DEFAULT_CONFLICT_STRATEGY)).using(((Boolean) rawValues0.get((ChronoElement<V>) FlagElement.DAYLIGHT_SAVING)).booleanValue() ? OverlapResolver.EARLIER_OFFSET : OverlapResolver.LATER_OFFSET)), startOfDay);
                } else {
                    moment = mergedAttributes.contains(Attributes.TRANSITION_STRATEGY) ? generalTimestamp.in(Timezone.of(tzid).with((TransitionStrategy) mergedAttributes.get(Attributes.TRANSITION_STRATEGY)), startOfDay) : generalTimestamp.in(Timezone.of(tzid), startOfDay);
                }
            } else {
                moment = null;
            }
            if (moment == null) {
                parseLog2.setError(charSequence.length(), "Missing timezone or offset.");
                return null;
            }
            rawValues0.with((ChronoElement<V>) Moment.axis().element(), moment);
            T cast = cast(moment);
            if (leniency2.isStrict()) {
                checkConsistency(rawValues0, cast, charSequence, parseLog2);
            }
            return cast;
        }
        return parse(this, this.chronology, 0, charSequence, parseLog, mergedAttributes, leniency2, z);
    }

    public ChronoEntity<?> parseRaw(String str) {
        return parseRaw(str, 0);
    }

    public ChronoEntity<?> parseRaw(CharSequence charSequence, int i) {
        if (i >= charSequence.length()) {
            return new ParsedValues(0, false);
        }
        ParseLog parseLog = new ParseLog(i);
        ChronoEntity<?> chronoEntity = null;
        try {
            chronoEntity = parseElements(charSequence, parseLog, this.globalAttributes, true, this.countOfElements);
            parseLog.setRawValues(chronoEntity);
        } catch (AmbivalentValueException e) {
            if (!parseLog.isError()) {
                parseLog.setError(parseLog.getPosition(), e.getMessage());
            }
        }
        if (chronoEntity == null || parseLog.isError()) {
            return new ParsedValues(0, false);
        }
        for (ChronoElement next : this.defaults.keySet()) {
            if (!chronoEntity.contains(next)) {
                setValue(chronoEntity, next, this.defaults.get(next));
            }
        }
        return chronoEntity;
    }

    public ChronoFormatter<T> with(Locale locale) {
        if (locale.equals(this.globalAttributes.getLocale())) {
            return this;
        }
        return new ChronoFormatter<>(this, this.globalAttributes.withLocale(locale));
    }

    public ChronoFormatter<T> with(Leniency leniency2) {
        return with(Attributes.LENIENCY, leniency2);
    }

    public ChronoFormatter<T> withAlternativeEraNames() {
        return new ChronoFormatter<>(this, new Attributes.Builder().setAll(this.globalAttributes.getAttributes()).set(HistoricAttribute.COMMON_ERA, true).set(HistoricAttribute.LATIN_ERA, false).build());
    }

    public ChronoFormatter<T> withLatinEraNames() {
        return new ChronoFormatter<>(this, new Attributes.Builder().setAll(this.globalAttributes.getAttributes()).set(HistoricAttribute.COMMON_ERA, false).set(HistoricAttribute.LATIN_ERA, true).build());
    }

    public ChronoFormatter<T> withGregorianCutOver(PlainDate plainDate) {
        return with(ChronoHistory.ofGregorianReform(plainDate));
    }

    public ChronoFormatter<T> with(ChronoHistory chronoHistory) {
        Objects.requireNonNull(chronoHistory, "Missing calendar history.");
        return new ChronoFormatter<>(this, this.globalAttributes.withInternal(HistoricAttribute.CALENDAR_HISTORY, chronoHistory).withAttributes(new Attributes.Builder().setAll(this.globalAttributes.getAttributes()).setCalendarVariant(chronoHistory.getVariant()).build()), chronoHistory);
    }

    public ChronoFormatter<T> with(Timezone timezone) {
        Objects.requireNonNull(timezone, "Missing timezone id.");
        return new ChronoFormatter<>(this, this.globalAttributes.withAttributes(new Attributes.Builder().setAll(this.globalAttributes.getAttributes()).setTimezone(timezone.getID()).build()).withInternal(Attributes.TRANSITION_STRATEGY, timezone.getStrategy()));
    }

    public ChronoFormatter<T> withTimezone(TZID tzid) {
        return with(Timezone.of(tzid));
    }

    public ChronoFormatter<T> withTimezone(String str) {
        return with(Timezone.of(str));
    }

    public ChronoFormatter<T> withStdTimezone() {
        return with(Timezone.ofSystem());
    }

    public ChronoFormatter<T> withCalendarVariant(String str) {
        return new ChronoFormatter<>(this, new Attributes.Builder().setAll(this.globalAttributes.getAttributes()).setCalendarVariant(str).build());
    }

    public ChronoFormatter<T> withCalendarVariant(VariantSource variantSource) {
        return withCalendarVariant(variantSource.getVariant());
    }

    public ChronoFormatter<T> with(StartOfDay startOfDay) {
        Objects.requireNonNull(startOfDay, "Missing start of day.");
        return new ChronoFormatter<>(this, this.globalAttributes.withInternal(Attributes.START_OF_DAY, startOfDay));
    }

    public <V> ChronoFormatter<T> withDefault(ChronoElement<V> chronoElement, V v) {
        Objects.requireNonNull(chronoElement, "Missing element.");
        HashMap hashMap = new HashMap();
        hashMap.put(chronoElement, v);
        return new ChronoFormatter<>(this, (Map<ChronoElement<?>, Object>) hashMap);
    }

    public ChronoFormatter<T> with(AttributeKey<Boolean> attributeKey, boolean z) {
        return new ChronoFormatter<>(this, new Attributes.Builder().setAll(this.globalAttributes.getAttributes()).set(attributeKey, z).build());
    }

    public ChronoFormatter<T> with(AttributeKey<Integer> attributeKey, int i) {
        return new ChronoFormatter<>(this, new Attributes.Builder().setAll(this.globalAttributes.getAttributes()).set(attributeKey, i).build());
    }

    public ChronoFormatter<T> with(AttributeKey<Character> attributeKey, char c) {
        return new ChronoFormatter<>(this, new Attributes.Builder().setAll(this.globalAttributes.getAttributes()).set(attributeKey, c).build());
    }

    public <A extends Enum<A>> ChronoFormatter<T> with(AttributeKey<A> attributeKey, A a) {
        return new ChronoFormatter<>(this, new Attributes.Builder().setAll(this.globalAttributes.getAttributes()).set(attributeKey, a).build());
    }

    public ChronoFormatter<T> with(Attributes attributes) {
        return new ChronoFormatter<>(this, new Attributes.Builder().setAll(this.globalAttributes.getAttributes()).setAll(attributes).build());
    }

    /* access modifiers changed from: package-private */
    public ChronoFormatter<T> with(Map<ChronoElement<?>, Object> map, AttributeSet attributeSet) {
        AttributeSet merge = AttributeSet.merge(attributeSet, this.globalAttributes);
        return new ChronoFormatter<>(new ChronoFormatter(this, map), merge, (ChronoHistory) merge.get(HistoricAttribute.CALENDAR_HISTORY, null));
    }

    /* access modifiers changed from: package-private */
    public Map<ChronoElement<?>, Object> getDefaults() {
        return this.defaults;
    }

    public Format toFormat() {
        return new TraditionalFormat(this);
    }

    public static ChronoFormatter<PlainDate> ofDatePattern(String str, PatternType patternType, Locale locale) {
        Builder builder = new Builder((Chronology) PlainDate.axis(), locale);
        addPattern(builder, str, patternType);
        try {
            return builder.build();
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static ChronoFormatter<PlainTime> ofTimePattern(String str, PatternType patternType, Locale locale) {
        Builder builder = new Builder((Chronology) PlainTime.axis(), locale);
        addPattern(builder, str, patternType);
        try {
            return builder.build();
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static ChronoFormatter<PlainTimestamp> ofTimestampPattern(String str, PatternType patternType, Locale locale) {
        Builder builder = new Builder((Chronology) PlainTimestamp.axis(), locale);
        addPattern(builder, str, patternType);
        try {
            return builder.build();
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static ChronoParser<Moment> ofMomentPattern(String str, PatternType patternType, Locale locale) {
        Builder builder = new Builder((Chronology) Moment.axis(), locale);
        addPattern(builder, str, patternType);
        try {
            return builder.build();
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static ChronoFormatter<Moment> ofMomentPattern(String str, PatternType patternType, Locale locale, TZID tzid) {
        Builder builder = new Builder((Chronology) Moment.axis(), locale);
        addPattern(builder, str, patternType);
        try {
            return builder.build().withTimezone(tzid);
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static <T> ChronoFormatter<T> ofPattern(String str, PatternType patternType, Locale locale, Chronology<T> chronology2) {
        Builder builder = new Builder((Chronology) chronology2, locale);
        addPattern(builder, str, patternType);
        try {
            return builder.build();
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static ChronoFormatter<PlainDate> ofDateStyle(DisplayMode displayMode, Locale locale) {
        Builder builder = new Builder((Chronology) PlainDate.axis(), locale);
        builder.addProcessor(new StyleProcessor(displayMode, displayMode));
        return builder.build();
    }

    public static ChronoFormatter<PlainTime> ofTimeStyle(DisplayMode displayMode, Locale locale) {
        Builder builder = new Builder((Chronology) PlainTime.axis(), locale);
        builder.addProcessor(new StyleProcessor(displayMode, displayMode));
        return builder.build();
    }

    public static ChronoFormatter<PlainTimestamp> ofTimestampStyle(DisplayMode displayMode, DisplayMode displayMode2, Locale locale) {
        Builder builder = new Builder((Chronology) PlainTimestamp.axis(), locale);
        builder.addProcessor(new StyleProcessor(displayMode, displayMode2));
        return builder.build();
    }

    public static ChronoFormatter<Moment> ofMomentStyle(DisplayMode displayMode, DisplayMode displayMode2, Locale locale, TZID tzid) {
        Builder builder = new Builder((Chronology) Moment.axis(), locale);
        builder.addProcessor(new StyleProcessor(displayMode, displayMode2));
        return builder.build().withTimezone(tzid);
    }

    public static <T extends LocalizedPatternSupport> ChronoFormatter<T> ofStyle(DisplayStyle displayStyle, Locale locale, Chronology<T> chronology2) {
        if (LocalizedPatternSupport.class.isAssignableFrom(chronology2.getChronoType())) {
            Builder builder = new Builder((Chronology) chronology2, locale);
            builder.addProcessor(new StyleProcessor(displayStyle, displayStyle));
            return builder.build();
        } else if (chronology2.equals(Moment.axis())) {
            throw new UnsupportedOperationException("Timezone required, use 'ofMomentStyle()' instead.");
        } else {
            throw new UnsupportedOperationException("Localized format patterns not available: " + chronology2);
        }
    }

    public static <T extends ChronoEntity<T>> Builder<T> setUp(Class<T> cls, Locale locale) {
        Objects.requireNonNull(cls, "Missing chronological type.");
        Chronology<T> lookup = Chronology.lookup(cls);
        if (lookup != null) {
            return new Builder<>((Chronology) lookup, locale);
        }
        throw new IllegalArgumentException("Not formattable: " + cls);
    }

    public static <T> Builder<T> setUp(Chronology<T> chronology2, Locale locale) {
        return new Builder<>((Chronology) chronology2, locale);
    }

    public static <C extends CalendarVariant<C>> Builder<Moment> setUpWithOverride(Locale locale, CalendarFamily<C> calendarFamily) {
        Objects.requireNonNull(calendarFamily, "Missing override calendar.");
        return new Builder<>(Moment.axis(), locale, calendarFamily);
    }

    public static <C extends Calendrical<?, C>> Builder<Moment> setUpWithOverride(Locale locale, Chronology<C> chronology2) {
        Objects.requireNonNull(chronology2, "Missing override calendar.");
        return new Builder<>(Moment.axis(), locale, chronology2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChronoFormatter)) {
            return false;
        }
        ChronoFormatter chronoFormatter = (ChronoFormatter) obj;
        if (!this.chronology.equals(chronoFormatter.chronology) || !isEqual(this.overrideHandler, chronoFormatter.overrideHandler) || !this.globalAttributes.equals(chronoFormatter.globalAttributes) || !this.defaults.equals(chronoFormatter.defaults) || !this.steps.equals(chronoFormatter.steps)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.chronology.hashCode() * 7) + (this.globalAttributes.hashCode() * 31) + (this.steps.hashCode() * 37);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("net.time4j.format.ChronoFormatter[chronology=");
        sb.append(this.chronology.getChronoType().getName());
        if (this.overrideHandler != null) {
            sb.append(", override=");
            sb.append(this.overrideHandler);
        }
        sb.append(", default-attributes=");
        sb.append(this.globalAttributes);
        sb.append(", default-values=");
        sb.append(this.defaults);
        sb.append(", processors=");
        boolean z = true;
        for (FormatStep next : this.steps) {
            if (z) {
                z = false;
                sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
            } else {
                sb.append('|');
            }
            sb.append(next);
        }
        sb.append("}]");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public AttributeSet getAttributes0() {
        return this.globalAttributes;
    }

    /* access modifiers changed from: package-private */
    public boolean isToleratingTrailingChars() {
        return this.trailing;
    }

    /* access modifiers changed from: package-private */
    public boolean isSingleStepOptimizationPossible() {
        return this.stepCount == 1 && !this.hasOptionals;
    }

    private boolean getSingleStepMode() {
        boolean isSingleStepOptimizationPossible = isSingleStepOptimizationPossible();
        if (!isSingleStepOptimizationPossible) {
            return isSingleStepOptimizationPossible;
        }
        FormatProcessor<?> processor = this.steps.get(0).getProcessor();
        if (processor instanceof CustomizedProcessor) {
            return CustomizedProcessor.class.cast(processor).isSingleStepMode();
        }
        if (!(processor instanceof StyleProcessor)) {
            return false;
        }
        return isSingleStepOptimizationPossible;
    }

    private String getPattern0(String str) {
        return (String) this.globalAttributes.get(Attributes.FORMAT_PATTERN, str);
    }

    private String format0(ChronoDisplay chronoDisplay) {
        StringBuilder sb = new StringBuilder(this.steps.size() * 8);
        try {
            print(chronoDisplay, (Appendable) sb, (AttributeQuery) this.globalAttributes, false);
            return sb.toString();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private static ChronoFormatter<Moment> rfc1123() {
        Builder<Moment> up = setUp(Moment.class, Locale.ENGLISH);
        rfc1123DateTime(up);
        up.addTimezoneOffset(DisplayMode.MEDIUM, false, Arrays.asList(new String[]{TimeZones.GMT_ID, "UT", "Z"}));
        up.or();
        rfc1123DateTime(up);
        final HashMap hashMap = new HashMap();
        hashMap.put("EST", ZonalOffset.ofHours(OffsetSign.BEHIND_UTC, 5));
        hashMap.put("EDT", ZonalOffset.ofHours(OffsetSign.BEHIND_UTC, 4));
        hashMap.put("CST", ZonalOffset.ofHours(OffsetSign.BEHIND_UTC, 6));
        hashMap.put("CDT", ZonalOffset.ofHours(OffsetSign.BEHIND_UTC, 5));
        hashMap.put("MST", ZonalOffset.ofHours(OffsetSign.BEHIND_UTC, 7));
        hashMap.put("MDT", ZonalOffset.ofHours(OffsetSign.BEHIND_UTC, 6));
        hashMap.put("PST", ZonalOffset.ofHours(OffsetSign.BEHIND_UTC, 8));
        hashMap.put("PDT", ZonalOffset.ofHours(OffsetSign.BEHIND_UTC, 7));
        up.addProcessor(new CustomizedProcessor(TimezoneElement.TIMEZONE_OFFSET, new ChronoPrinter<TZID>() {
            public <R> R print(TZID tzid, Appendable appendable, AttributeQuery attributeQuery, ChronoFunction<ChronoDisplay, R> chronoFunction) throws IOException {
                return null;
            }
        }, new ChronoParser<TZID>() {
            public TZID parse(CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery) {
                int position = parseLog.getPosition();
                int i = position + 3;
                if (i > charSequence.length()) {
                    return null;
                }
                TZID tzid = (TZID) hashMap.get(charSequence.subSequence(position, i).toString());
                if (tzid != null) {
                    parseLog.setPosition(i);
                    return tzid;
                }
                parseLog.setError(position, "No time zone information found.");
                return null;
            }
        }));
        return up.build().withTimezone((TZID) ZonalOffset.UTC);
    }

    private static void rfc1123DateTime(Builder<Moment> builder) {
        builder.startOptionalSection().startSection(Attributes.TEXT_WIDTH, TextWidth.ABBREVIATED).addText(PlainDate.DAY_OF_WEEK).endSection().addLiteral(", ").endSection().addInteger(PlainDate.DAY_OF_MONTH, 1, 2).addLiteral(' ').startSection(Attributes.TEXT_WIDTH, TextWidth.ABBREVIATED).addText(PlainDate.MONTH_OF_YEAR).endSection().addLiteral(' ').addFixedInteger(PlainDate.YEAR, 4).addLiteral(' ').addFixedInteger(PlainTime.DIGITAL_HOUR_OF_DAY, 2).addLiteral((char) AbstractJsonLexerKt.COLON).addFixedInteger(PlainTime.MINUTE_OF_HOUR, 2).startOptionalSection().addLiteral((char) AbstractJsonLexerKt.COLON).addFixedInteger(PlainTime.SECOND_OF_MINUTE, 2).endSection().addLiteral(' ');
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private net.time4j.engine.ChronoDisplay display(T r7, net.time4j.engine.AttributeQuery r8) {
        /*
            r6 = this;
            net.time4j.format.expert.ChronoFormatter$OverrideHandler<?> r0 = r6.overrideHandler
            if (r0 != 0) goto L_0x000b
            net.time4j.engine.Chronology<T> r0 = r6.chronology
            net.time4j.engine.ChronoDisplay r7 = r0.preformat(r7, r8)
            return r7
        L_0x000b:
            net.time4j.engine.Chronology r0 = r0.getCalendarOverride()     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            java.lang.Class r0 = r0.getChronoType()     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            net.time4j.engine.AttributeKey<net.time4j.engine.StartOfDay> r1 = net.time4j.format.Attributes.START_OF_DAY     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            net.time4j.format.expert.ChronoFormatter$OverrideHandler<?> r2 = r6.overrideHandler     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            net.time4j.engine.StartOfDay r2 = r2.getDefaultStartOfDay()     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            java.lang.Object r1 = r8.get(r1, r2)     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            net.time4j.engine.StartOfDay r1 = (net.time4j.engine.StartOfDay) r1     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            java.lang.Class<net.time4j.Moment> r2 = net.time4j.Moment.class
            java.lang.Object r2 = r2.cast(r7)     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            net.time4j.Moment r2 = (net.time4j.Moment) r2     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r3 = net.time4j.format.Attributes.TIMEZONE_ID     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            java.lang.Object r3 = r8.get(r3)     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            net.time4j.tz.TZID r3 = (net.time4j.tz.TZID) r3     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            java.lang.String r4 = ""
            java.lang.Class<net.time4j.engine.CalendarVariant> r5 = net.time4j.engine.CalendarVariant.class
            boolean r5 = r5.isAssignableFrom(r0)     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            if (r5 == 0) goto L_0x0055
            net.time4j.format.expert.ChronoFormatter$OverrideHandler<?> r0 = r6.overrideHandler     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            net.time4j.engine.Chronology r0 = r0.getCalendarOverride()     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            java.lang.Object r0 = cast(r0)     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            net.time4j.engine.CalendarFamily r0 = (net.time4j.engine.CalendarFamily) r0     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            net.time4j.engine.AttributeKey<java.lang.String> r4 = net.time4j.format.Attributes.CALENDAR_VARIANT     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            java.lang.Object r8 = r8.get(r4)     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            r4 = r8
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            net.time4j.GeneralTimestamp r8 = r2.toGeneralTimestamp(r0, r4, r3, r1)     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            goto L_0x0067
        L_0x0055:
            java.lang.Class<net.time4j.engine.Calendrical> r8 = net.time4j.engine.Calendrical.class
            boolean r8 = r8.isAssignableFrom(r0)     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            if (r8 == 0) goto L_0x006e
            net.time4j.format.expert.ChronoFormatter$OverrideHandler<?> r8 = r6.overrideHandler     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            net.time4j.engine.Chronology r8 = r8.getCalendarOverride()     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            net.time4j.GeneralTimestamp r8 = r2.toGeneralTimestamp(r8, r3, r1)     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
        L_0x0067:
            net.time4j.format.expert.ChronoFormatter$ZonalDisplay r0 = new net.time4j.format.expert.ChronoFormatter$ZonalDisplay     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            r1 = 0
            r0.<init>(r8, r4, r3)     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            return r0
        L_0x006e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            r1.<init>()     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            java.lang.String r2 = "Unexpected calendar override: "
            r1.append(r2)     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            r1.append(r0)     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            java.lang.String r0 = r1.toString()     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            r8.<init>(r0)     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
            throw r8     // Catch:{ ClassCastException -> 0x0090, NoSuchElementException -> 0x0085 }
        L_0x0085:
            r7 = move-exception
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r7.getMessage()
            r8.<init>(r0, r7)
            throw r8
        L_0x0090:
            r8 = move-exception
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Not formattable: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.expert.ChronoFormatter.display(java.lang.Object, net.time4j.engine.AttributeQuery):net.time4j.engine.ChronoDisplay");
    }

    private static <C> C parse(ChronoFormatter<?> chronoFormatter, Chronology<C> chronology2, int i, CharSequence charSequence, ParseLog parseLog, AttributeQuery attributeQuery, Leniency leniency2, boolean z) {
        Chronology<?> chronology3;
        Object obj;
        C c;
        Chronology<?> chronology4 = chronology2;
        ParseLog parseLog2 = parseLog;
        Chronology<?> preparser = chronology2.preparser();
        ChronoFormatter<?> chronoFormatter2 = chronoFormatter;
        if (preparser == null || chronology4 == (chronology3 = chronoFormatter2.deepestParser)) {
            CharSequence charSequence2 = charSequence;
            AttributeQuery attributeQuery2 = attributeQuery;
            return parse(chronoFormatter, chronology2, chronology2.getExtensions(), charSequence, parseLog, attributeQuery, leniency2, i > 0, z);
        }
        if (preparser == chronology3) {
            obj = parse(chronoFormatter, preparser, preparser.getExtensions(), charSequence, parseLog, attributeQuery, leniency2, true, z);
        } else {
            obj = parse(chronoFormatter, preparser, i + 1, charSequence, parseLog, attributeQuery, leniency2, z);
        }
        if (parseLog.isError()) {
            return null;
        }
        if (obj == null) {
            ChronoEntity<?> rawValues = parseLog.getRawValues();
            int length = charSequence.length();
            parseLog2.setError(length, getReason(rawValues) + getDescription(rawValues));
            return null;
        }
        ChronoEntity rawValues0 = parseLog.getRawValues0();
        try {
            if (preparser instanceof TimeAxis) {
                updateSelf(rawValues0, TimeAxis.class.cast(preparser).element(), obj);
                c = chronology2.createFrom(rawValues0, attributeQuery, leniency2.isLax(), false);
            } else if (chronology4 instanceof BridgeChronology) {
                c = chronology2.createFrom(ChronoEntity.class.cast(obj), Attributes.empty(), false, false);
            } else {
                CharSequence charSequence3 = charSequence;
                try {
                    throw new IllegalStateException("Unsupported chronology or preparser: " + chronology2);
                } catch (RuntimeException e) {
                    e = e;
                    int length2 = charSequence.length();
                    parseLog2.setError(length2, e.getMessage() + getDescription(rawValues0));
                    return null;
                }
            }
            if (c == null) {
                if (!parseLog.isError()) {
                    int length3 = charSequence.length();
                    parseLog2.setError(length3, getReason(rawValues0) + getDescription(rawValues0));
                }
                return null;
            } else if (leniency2.isStrict()) {
                return checkConsistency(rawValues0, c, charSequence, parseLog2);
            } else {
                return c;
            }
        } catch (RuntimeException e2) {
            e = e2;
            CharSequence charSequence4 = charSequence;
            int length22 = charSequence.length();
            parseLog2.setError(length22, e.getMessage() + getDescription(rawValues0));
            return null;
        }
    }

    private static <T> void updateSelf(ChronoEntity<?> chronoEntity, ChronoElement<T> chronoElement, Object obj) {
        chronoEntity.with((ChronoElement<V>) chronoElement, chronoElement.getType().cast(obj));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(16:10|11|(1:13)|14|15|27|29|(0)|48|(0)(0)|58|59|60|62|64|(0)(0)) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0058, code lost:
        r0 = e;
        r14 = r14;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0041 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d0 A[SYNTHETIC, Splitter:B:50:0x00d0] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0148  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> T parse(net.time4j.format.expert.ChronoFormatter<?> r15, net.time4j.engine.ChronoMerger<T> r16, java.util.List<net.time4j.engine.ChronoExtension> r17, java.lang.CharSequence r18, net.time4j.format.expert.ParseLog r19, net.time4j.engine.AttributeQuery r20, net.time4j.format.Leniency r21, boolean r22, boolean r23) {
        /*
            r7 = r15
            r8 = r19
            r9 = r20
            r10 = r22
            int r11 = r18.length()
            int r0 = r19.getPosition()
            if (r0 >= r11) goto L_0x0171
            r12 = 0
            r13 = 0
            boolean r0 = r7.singleStepMode     // Catch:{ AmbivalentValueException -> 0x005a }
            if (r0 == 0) goto L_0x0045
            if (r10 != 0) goto L_0x0045
            net.time4j.format.expert.ParsedValue r14 = new net.time4j.format.expert.ParsedValue     // Catch:{ AmbivalentValueException -> 0x005a }
            r14.<init>()     // Catch:{ AmbivalentValueException -> 0x005a }
            java.util.List<net.time4j.format.expert.FormatStep> r0 = r7.steps     // Catch:{ AmbivalentValueException -> 0x005a }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ AmbivalentValueException -> 0x005a }
            r1 = r0
            net.time4j.format.expert.FormatStep r1 = (net.time4j.format.expert.FormatStep) r1     // Catch:{ AmbivalentValueException -> 0x005a }
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r14
            r6 = r23
            r1.parse(r2, r3, r4, r5, r6)     // Catch:{ AmbivalentValueException -> 0x005a }
            boolean r0 = r19.isError()     // Catch:{ AmbivalentValueException -> 0x005a }
            if (r0 == 0) goto L_0x003a
            return r13
        L_0x003a:
            java.lang.Object r0 = r14.getResult()     // Catch:{ ClassCastException -> 0x0041 }
            if (r0 == 0) goto L_0x0041
            return r0
        L_0x0041:
            r8.setRawValues(r14)     // Catch:{ AmbivalentValueException -> 0x0058 }
            goto L_0x006d
        L_0x0045:
            int r6 = r7.countOfElements     // Catch:{ AmbivalentValueException -> 0x005a }
            r1 = r15
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r23
            net.time4j.engine.ChronoEntity r14 = r1.parseElements(r2, r3, r4, r5, r6)     // Catch:{ AmbivalentValueException -> 0x005a }
            r8.setRawValues(r14)     // Catch:{ AmbivalentValueException -> 0x0058 }
            goto L_0x006d
        L_0x0058:
            r0 = move-exception
            goto L_0x005c
        L_0x005a:
            r0 = move-exception
            r14 = r13
        L_0x005c:
            boolean r1 = r19.isError()
            if (r1 != 0) goto L_0x006d
            int r1 = r19.getPosition()
            java.lang.String r0 = r0.getMessage()
            r8.setError(r1, r0)
        L_0x006d:
            if (r14 == 0) goto L_0x0170
            boolean r0 = r19.isError()
            if (r0 == 0) goto L_0x0077
            goto L_0x0170
        L_0x0077:
            java.util.Map<net.time4j.engine.ChronoElement<?>, java.lang.Object> r0 = r7.defaults
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00cc
            java.util.Map<net.time4j.engine.ChronoElement<?>, java.lang.Object> r0 = r7.defaults
            java.util.Set r0 = r0.keySet()
            java.util.Iterator r0 = r0.iterator()
            r1 = r13
        L_0x008a:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00cc
            java.lang.Object r2 = r0.next()
            net.time4j.engine.ChronoElement r2 = (net.time4j.engine.ChronoElement) r2
            boolean r3 = r14.contains(r2)
            if (r3 != 0) goto L_0x008a
            char r3 = r2.getSymbol()
            r4 = 1
            if (r3 == 0) goto L_0x00c0
            if (r1 != 0) goto L_0x00a9
            java.util.Set r1 = r14.getRegisteredElements()
        L_0x00a9:
            java.util.Iterator r5 = r1.iterator()
        L_0x00ad:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x00c0
            java.lang.Object r6 = r5.next()
            net.time4j.engine.ChronoElement r6 = (net.time4j.engine.ChronoElement) r6
            char r6 = r6.getSymbol()
            if (r6 != r3) goto L_0x00ad
            r4 = 0
        L_0x00c0:
            if (r4 == 0) goto L_0x008a
            java.util.Map<net.time4j.engine.ChronoElement<?>, java.lang.Object> r3 = r7.defaults
            java.lang.Object r3 = r3.get(r2)
            setValue(r14, r2, r3)
            goto L_0x008a
        L_0x00cc:
            boolean r0 = r7.needsExtensions
            if (r0 == 0) goto L_0x0105
            java.util.Iterator r0 = r17.iterator()     // Catch:{ RuntimeException -> 0x00e9 }
        L_0x00d4:
            boolean r1 = r0.hasNext()     // Catch:{ RuntimeException -> 0x00e9 }
            if (r1 == 0) goto L_0x0105
            java.lang.Object r1 = r0.next()     // Catch:{ RuntimeException -> 0x00e9 }
            net.time4j.engine.ChronoExtension r1 = (net.time4j.engine.ChronoExtension) r1     // Catch:{ RuntimeException -> 0x00e9 }
            java.util.Locale r2 = r15.getLocale()     // Catch:{ RuntimeException -> 0x00e9 }
            net.time4j.engine.ChronoEntity r14 = r1.resolve(r14, r2, r9)     // Catch:{ RuntimeException -> 0x00e9 }
            goto L_0x00d4
        L_0x00e9:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = getDescription(r14)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r8.setError(r11, r0)
            return r13
        L_0x0105:
            boolean r0 = r21.isLax()     // Catch:{ RuntimeException -> 0x0155 }
            r1 = r16
            java.lang.Object r0 = r1.createFrom(r14, r9, r0, r10)     // Catch:{ RuntimeException -> 0x0155 }
            net.time4j.format.expert.FractionProcessor r1 = r7.fracproc
            if (r1 == 0) goto L_0x0129
            boolean r1 = r0 instanceof net.time4j.engine.ChronoEntity
            if (r1 == 0) goto L_0x0129
            java.lang.Class<net.time4j.engine.ChronoEntity> r1 = net.time4j.engine.ChronoEntity.class
            java.lang.Object r0 = r1.cast(r0)
            net.time4j.engine.ChronoEntity r0 = (net.time4j.engine.ChronoEntity) r0
            net.time4j.format.expert.FractionProcessor r1 = r7.fracproc
            net.time4j.engine.ChronoEntity r0 = r1.update(r0, r14)
            java.lang.Object r0 = cast(r0)
        L_0x0129:
            if (r0 != 0) goto L_0x0148
            if (r10 != 0) goto L_0x0147
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = getReason(r14)
            r0.append(r1)
            java.lang.String r1 = getDescription(r14)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.setError(r11, r0)
        L_0x0147:
            return r13
        L_0x0148:
            boolean r1 = r21.isStrict()
            if (r1 == 0) goto L_0x0154
            r1 = r18
            java.lang.Object r0 = checkConsistency(r14, r0, r1, r8)
        L_0x0154:
            return r0
        L_0x0155:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r0 = r0.getMessage()
            r1.append(r0)
            java.lang.String r0 = getDescription(r14)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r8.setError(r11, r0)
        L_0x0170:
            return r13
        L_0x0171:
            r1 = r18
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "["
            r2.append(r3)
            int r3 = r19.getPosition()
            r2.append(r3)
            java.lang.String r3 = "]: "
            r2.append(r3)
            java.lang.String r1 = r18.toString()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.expert.ChronoFormatter.parse(net.time4j.format.expert.ChronoFormatter, net.time4j.engine.ChronoMerger, java.util.List, java.lang.CharSequence, net.time4j.format.expert.ParseLog, net.time4j.engine.AttributeQuery, net.time4j.format.Leniency, boolean, boolean):java.lang.Object");
    }

    private static <V> void setValue(ChronoEntity<?> chronoEntity, ChronoElement<V> chronoElement, Object obj) {
        chronoEntity.with(chronoElement, chronoElement.getType().cast(obj));
    }

    private static String getReason(ChronoEntity<?> chronoEntity) {
        if (!chronoEntity.contains(ValidationElement.ERROR_MESSAGE)) {
            return "Insufficient data:";
        }
        String str = "Validation failed => " + ((String) chronoEntity.get((ChronoElement<V>) ValidationElement.ERROR_MESSAGE));
        chronoEntity.with((ChronoElement<V>) ValidationElement.ERROR_MESSAGE, null);
        return str;
    }

    private static boolean isEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0061, code lost:
        r3 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> void addPattern(net.time4j.format.expert.ChronoFormatter.Builder<T> r10, java.lang.String r11, net.time4j.format.expert.PatternType r12) {
        /*
            int r0 = r11.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r2 = 0
            r3 = 0
        L_0x000b:
            r4 = 1
            if (r3 >= r0) goto L_0x0068
            char r5 = r11.charAt(r3)
            r6 = 39
            if (r5 != r6) goto L_0x0063
            int r5 = r3 + 1
            char r7 = r11.charAt(r5)
            r8 = 90
            if (r7 != r8) goto L_0x0022
            r7 = 1
            goto L_0x0023
        L_0x0022:
            r7 = 0
        L_0x0023:
            if (r5 >= r0) goto L_0x0061
            char r8 = r11.charAt(r5)
            if (r8 != r6) goto L_0x005f
            int r8 = r5 + 1
            if (r8 >= r0) goto L_0x0037
            char r9 = r11.charAt(r8)
            if (r9 != r6) goto L_0x0037
            r5 = r8
            goto L_0x005f
        L_0x0037:
            if (r7 == 0) goto L_0x0061
            int r3 = r3 + 2
            if (r5 != r3) goto L_0x0061
            net.time4j.engine.Chronology r3 = r10.chronology
            boolean r3 = net.time4j.format.expert.ChronoFormatter.Builder.hasUnixChronology(r3)
            if (r3 != 0) goto L_0x0048
            goto L_0x0061
        L_0x0048:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "Z-literal (=UTC+00) should not be escaped: "
            r12.append(r0)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            r10.<init>(r11)
            throw r10
        L_0x005f:
            int r5 = r5 + r4
            goto L_0x0023
        L_0x0061:
            r3 = r5
            goto L_0x0066
        L_0x0063:
            r1.append(r5)
        L_0x0066:
            int r3 = r3 + r4
            goto L_0x000b
        L_0x0068:
            java.lang.String r0 = r1.toString()
            int[] r1 = net.time4j.format.expert.ChronoFormatter.AnonymousClass3.$SwitchMap$net$time4j$format$expert$PatternType
            int r2 = r12.ordinal()
            r1 = r1[r2]
            if (r1 == r4) goto L_0x0081
            r2 = 2
            if (r1 == r2) goto L_0x0081
            r2 = 3
            if (r1 == r2) goto L_0x0081
            r2 = 4
            if (r1 == r2) goto L_0x0081
            goto L_0x012d
        L_0x0081:
            java.lang.String r1 = "h"
            boolean r1 = r0.contains(r1)
            if (r1 != 0) goto L_0x0091
            java.lang.String r1 = "K"
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L_0x00c1
        L_0x0091:
            java.lang.String r1 = "a"
            boolean r1 = r0.contains(r1)
            if (r1 != 0) goto L_0x00c1
            java.lang.String r1 = "b"
            boolean r1 = r0.contains(r1)
            if (r1 != 0) goto L_0x00c1
            java.lang.String r1 = "B"
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L_0x00aa
            goto L_0x00c1
        L_0x00aa:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "12-hour-clock requires am/pm-marker or dayperiod: "
            r12.append(r0)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            r10.<init>(r11)
            throw r10
        L_0x00c1:
            java.lang.String r1 = "Y"
            boolean r1 = r0.contains(r1)
            java.lang.String r2 = "L"
            java.lang.String r3 = "M"
            if (r1 == 0) goto L_0x00f9
            boolean r1 = r0.contains(r3)
            if (r1 != 0) goto L_0x00d9
            boolean r1 = r0.contains(r2)
            if (r1 == 0) goto L_0x00f9
        L_0x00d9:
            java.lang.String r1 = "w"
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L_0x00e2
            goto L_0x00f9
        L_0x00e2:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "Y as week-based-year requires a week-date-format: "
            r12.append(r0)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            r10.<init>(r11)
            throw r10
        L_0x00f9:
            java.lang.String r1 = "D"
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L_0x012d
            boolean r1 = r0.contains(r3)
            if (r1 != 0) goto L_0x010d
            boolean r1 = r0.contains(r2)
            if (r1 == 0) goto L_0x012d
        L_0x010d:
            java.lang.String r1 = "d"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0116
            goto L_0x012d
        L_0x0116:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "D is the day of year but not the day of month: "
            r12.append(r0)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            r10.<init>(r11)
            throw r10
        L_0x012d:
            r10.addPattern(r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.expert.ChronoFormatter.addPattern(net.time4j.format.expert.ChronoFormatter$Builder, java.lang.String, net.time4j.format.expert.PatternType):void");
    }

    /* renamed from: net.time4j.format.expert.ChronoFormatter$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$net$time4j$format$expert$PatternType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                net.time4j.format.expert.PatternType[] r0 = net.time4j.format.expert.PatternType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$net$time4j$format$expert$PatternType = r0
                net.time4j.format.expert.PatternType r1 = net.time4j.format.expert.PatternType.CLDR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$net$time4j$format$expert$PatternType     // Catch:{ NoSuchFieldError -> 0x001d }
                net.time4j.format.expert.PatternType r1 = net.time4j.format.expert.PatternType.CLDR_24     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$net$time4j$format$expert$PatternType     // Catch:{ NoSuchFieldError -> 0x0028 }
                net.time4j.format.expert.PatternType r1 = net.time4j.format.expert.PatternType.CLDR_DATE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$net$time4j$format$expert$PatternType     // Catch:{ NoSuchFieldError -> 0x0033 }
                net.time4j.format.expert.PatternType r1 = net.time4j.format.expert.PatternType.SIMPLE_DATE_FORMAT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.expert.ChronoFormatter.AnonymousClass3.<clinit>():void");
        }
    }

    private static <T> T checkConsistency(ChronoEntity<?> chronoEntity, T t, CharSequence charSequence, ParseLog parseLog) {
        Object obj;
        if (t instanceof UnixTime) {
            UnixTime cast = UnixTime.class.cast(t);
            if (chronoEntity.contains(TimezoneElement.TIMEZONE_ID) && chronoEntity.contains(TimezoneElement.TIMEZONE_OFFSET)) {
                TZID tzid = (TZID) chronoEntity.get((ChronoElement<V>) TimezoneElement.TIMEZONE_ID);
                TZID tzid2 = (TZID) chronoEntity.get((ChronoElement<V>) TimezoneElement.TIMEZONE_OFFSET);
                if (!Timezone.of(tzid).getOffset(cast).equals(tzid2)) {
                    parseLog.setError(charSequence.length(), "Ambivalent offset information: " + tzid + " versus " + tzid2);
                    return null;
                }
            }
            if (!chronoEntity.contains(FlagElement.DAYLIGHT_SAVING)) {
                return t;
            }
            try {
                boolean isDaylightSaving = Timezone.of(chronoEntity.getTimezone()).isDaylightSaving(cast);
                if (isDaylightSaving == ((Boolean) chronoEntity.get((ChronoElement<V>) FlagElement.DAYLIGHT_SAVING)).booleanValue()) {
                    return t;
                }
                StringBuilder sb = new StringBuilder(256);
                sb.append("Conflict found: ");
                sb.append("Parsed entity is ");
                if (!isDaylightSaving) {
                    sb.append("not ");
                }
                sb.append("daylight-saving, but timezone name");
                sb.append(" has not the appropriate form in {");
                sb.append(charSequence.toString());
                sb.append("}.");
                parseLog.setError(charSequence.length(), sb.toString());
                return null;
            } catch (IllegalArgumentException e) {
                StringBuilder sb2 = new StringBuilder(256);
                sb2.append("Unable to check timezone name: ");
                sb2.append(e.getMessage());
                parseLog.setError(charSequence.length(), sb2.toString());
                return null;
            }
        } else if (!(t instanceof ChronoDisplay)) {
            return t;
        } else {
            ChronoDisplay chronoDisplay = (ChronoDisplay) t;
            TimePoint minus = (!(t instanceof PlainTimestamp) || PlainTimestamp.class.cast(t).getHour() != 0 || (chronoEntity.getInt(PlainTime.HOUR_FROM_0_TO_24) != 24 && (!chronoEntity.contains(PlainTime.COMPONENT) || ((PlainTime) chronoEntity.get((ChronoElement<V>) PlainTime.COMPONENT)).getHour() != 24))) ? null : PlainTimestamp.class.cast(t).toDate().minus(1, CalendarUnit.DAYS);
            for (ChronoElement next : chronoEntity.getRegisteredElements()) {
                if (next != PlainTime.SECOND_OF_MINUTE || chronoEntity.getInt(PlainTime.SECOND_OF_MINUTE) != 60) {
                    if (minus != null) {
                        if (next.isDateElement()) {
                            chronoDisplay = minus;
                        } else if (next.isTimeElement()) {
                            chronoDisplay = PlainTime.midnightAtEndOfDay();
                        }
                    }
                    if (chronoDisplay.contains(next)) {
                        boolean z = true;
                        if (next.getType() == Integer.class) {
                            ChronoElement chronoElement = (ChronoElement) cast(next);
                            int i = chronoEntity.getInt(chronoElement);
                            if (chronoDisplay.getInt(chronoElement) != i) {
                                obj = Integer.valueOf(i);
                                z = false;
                            } else {
                                obj = null;
                            }
                        } else {
                            obj = chronoEntity.get((ChronoElement<V>) next);
                            z = chronoDisplay.get(next).equals(obj);
                        }
                        if (!z) {
                            StringBuilder sb3 = new StringBuilder(256);
                            sb3.append("Conflict found: ");
                            sb3.append("Text {");
                            sb3.append(charSequence.toString());
                            sb3.append("} with element ");
                            sb3.append(next.name());
                            sb3.append(" {");
                            sb3.append(obj);
                            sb3.append("}, but parsed entity ");
                            sb3.append("has element value {");
                            sb3.append(chronoDisplay.get(next));
                            sb3.append("}.");
                            parseLog.setError(charSequence.length(), sb3.toString());
                            return null;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return t;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v3, resolved type: net.time4j.format.expert.ParsedValues} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v6, resolved type: net.time4j.format.expert.ParsedValues} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0146  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private net.time4j.engine.ChronoEntity<?> parseElements(java.lang.CharSequence r19, net.time4j.format.expert.ParseLog r20, net.time4j.engine.AttributeQuery r21, boolean r22, int r23) {
        /*
            r18 = this;
            r0 = r18
            r7 = r20
            r8 = r23
            net.time4j.format.expert.ParsedValues r1 = new net.time4j.format.expert.ParsedValues
            boolean r2 = r0.indexable
            r1.<init>(r8, r2)
            int r2 = r20.getPosition()
            r1.setPosition(r2)
            boolean r2 = r0.hasOptionals
            r9 = 0
            if (r2 == 0) goto L_0x0023
            java.util.LinkedList r2 = new java.util.LinkedList
            r2.<init>()
            r2.push(r1)
            r10 = r2
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            java.util.List<net.time4j.format.expert.FormatStep> r2 = r0.steps
            int r11 = r2.size()
            r2 = 0
            r3 = 0
            r12 = 0
        L_0x002d:
            if (r12 >= r11) goto L_0x0175
            java.util.List<net.time4j.format.expert.FormatStep> r4 = r0.steps
            java.lang.Object r4 = r4.get(r12)
            r13 = r4
            net.time4j.format.expert.FormatStep r13 = (net.time4j.format.expert.FormatStep) r13
            if (r10 != 0) goto L_0x003f
            r14 = r1
            r15 = r14
            r16 = r2
            goto L_0x007a
        L_0x003f:
            int r2 = r13.getLevel()
            r4 = r2
        L_0x0044:
            if (r4 <= r3) goto L_0x005c
            net.time4j.format.expert.ParsedValues r1 = new net.time4j.format.expert.ParsedValues
            int r5 = r8 >>> 1
            boolean r6 = r0.indexable
            r1.<init>(r5, r6)
            int r5 = r20.getPosition()
            r1.setPosition(r5)
            r10.push(r1)
            int r4 = r4 + -1
            goto L_0x0044
        L_0x005c:
            if (r4 >= r3) goto L_0x0070
            java.lang.Object r1 = r10.pop()
            net.time4j.format.expert.ParsedValues r1 = (net.time4j.format.expert.ParsedValues) r1
            java.lang.Object r5 = r10.peek()
            net.time4j.format.expert.ParsedValues r5 = (net.time4j.format.expert.ParsedValues) r5
            r5.putAll(r1)
            int r4 = r4 + 1
            goto L_0x005c
        L_0x0070:
            java.lang.Object r3 = r10.peek()
            net.time4j.format.expert.ParsedValues r3 = (net.time4j.format.expert.ParsedValues) r3
            r15 = r1
            r16 = r2
            r14 = r3
        L_0x007a:
            r20.clearWarning()
            r1 = r13
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r14
            r6 = r22
            r1.parse(r2, r3, r4, r5, r6)
            boolean r1 = r20.isWarning()
            if (r1 == 0) goto L_0x00b6
            net.time4j.format.expert.FormatProcessor r1 = r13.getProcessor()
            net.time4j.engine.ChronoElement r1 = r1.getElement()
            if (r1 == 0) goto L_0x00b6
            java.util.Map<net.time4j.engine.ChronoElement<?>, java.lang.Object> r2 = r0.defaults
            boolean r2 = r2.containsKey(r1)
            if (r2 == 0) goto L_0x00b6
            java.util.Map<net.time4j.engine.ChronoElement<?>, java.lang.Object> r2 = r0.defaults
            java.lang.Object r2 = r2.get(r1)
            r14.put((net.time4j.engine.ChronoElement<?>) r1, (java.lang.Object) r2)
            net.time4j.engine.ValidationElement r1 = net.time4j.engine.ValidationElement.ERROR_MESSAGE
            r14.with((net.time4j.engine.ChronoElement) r1, (java.lang.Object) r9)
            r20.clearError()
            r20.clearWarning()
        L_0x00b6:
            boolean r1 = r20.isError()
            if (r1 == 0) goto L_0x0163
            int r1 = r13.getSection()
            boolean r2 = r13.isNewOrBlockStarted()
            if (r2 != 0) goto L_0x00e2
            int r2 = r12 + 1
        L_0x00c8:
            if (r2 >= r11) goto L_0x00e2
            java.util.List<net.time4j.format.expert.FormatStep> r3 = r0.steps
            java.lang.Object r3 = r3.get(r2)
            net.time4j.format.expert.FormatStep r3 = (net.time4j.format.expert.FormatStep) r3
            boolean r4 = r3.isNewOrBlockStarted()
            if (r4 == 0) goto L_0x00df
            int r3 = r3.getSection()
            if (r3 != r1) goto L_0x00df
            goto L_0x00e3
        L_0x00df:
            int r2 = r2 + 1
            goto L_0x00c8
        L_0x00e2:
            r2 = r12
        L_0x00e3:
            if (r2 > r12) goto L_0x0146
            boolean r3 = r13.isNewOrBlockStarted()
            if (r3 == 0) goto L_0x00ec
            goto L_0x0146
        L_0x00ec:
            if (r16 != 0) goto L_0x00fb
            if (r10 == 0) goto L_0x00f7
            java.lang.Object r1 = r10.peek()
            r15 = r1
            net.time4j.format.expert.ParsedValues r15 = (net.time4j.format.expert.ParsedValues) r15
        L_0x00f7:
            r15.setNoAmbivalentCheck()
            return r15
        L_0x00fb:
            int r3 = r13.getLevel()
            int r12 = r12 + 1
            r4 = r2
            r2 = r12
        L_0x0103:
            if (r2 >= r11) goto L_0x011b
            java.util.List<net.time4j.format.expert.FormatStep> r5 = r0.steps
            java.lang.Object r5 = r5.get(r2)
            net.time4j.format.expert.FormatStep r5 = (net.time4j.format.expert.FormatStep) r5
            int r5 = r5.getLevel()
            if (r5 <= r3) goto L_0x011b
            int r4 = r2 + 1
            r17 = r4
            r4 = r2
            r2 = r17
            goto L_0x0103
        L_0x011b:
            int r2 = r11 + -1
        L_0x011d:
            if (r2 <= r4) goto L_0x0132
            java.util.List<net.time4j.format.expert.FormatStep> r3 = r0.steps
            java.lang.Object r3 = r3.get(r2)
            net.time4j.format.expert.FormatStep r3 = (net.time4j.format.expert.FormatStep) r3
            int r3 = r3.getSection()
            if (r3 != r1) goto L_0x012f
            r4 = r2
            goto L_0x0132
        L_0x012f:
            int r2 = r2 + -1
            goto L_0x011d
        L_0x0132:
            int r16 = r16 + -1
            java.lang.Object r1 = r10.pop()
            net.time4j.format.expert.ParsedValues r1 = (net.time4j.format.expert.ParsedValues) r1
            r20.clearError()
            int r2 = r1.getPosition()
            r7.setPosition(r2)
            r12 = r4
            goto L_0x016e
        L_0x0146:
            if (r10 == 0) goto L_0x014f
            java.lang.Object r1 = r10.pop()
            r15 = r1
            net.time4j.format.expert.ParsedValues r15 = (net.time4j.format.expert.ParsedValues) r15
        L_0x014f:
            r20.clearError()
            int r1 = r15.getPosition()
            r7.setPosition(r1)
            r15.reset()
            if (r10 == 0) goto L_0x0161
            r10.push(r15)
        L_0x0161:
            r12 = r2
            goto L_0x016d
        L_0x0163:
            boolean r1 = r13.isNewOrBlockStarted()
            if (r1 == 0) goto L_0x016d
            int r12 = r13.skipTrailingOrBlocks()
        L_0x016d:
            r1 = r15
        L_0x016e:
            r3 = r16
            int r12 = r12 + 1
            r2 = r3
            goto L_0x002d
        L_0x0175:
            if (r2 <= 0) goto L_0x0189
            java.lang.Object r1 = r10.pop()
            net.time4j.format.expert.ParsedValues r1 = (net.time4j.format.expert.ParsedValues) r1
            java.lang.Object r3 = r10.peek()
            net.time4j.format.expert.ParsedValues r3 = (net.time4j.format.expert.ParsedValues) r3
            r3.putAll(r1)
            int r2 = r2 + -1
            goto L_0x0175
        L_0x0189:
            if (r10 == 0) goto L_0x0191
            java.lang.Object r1 = r10.peek()
            net.time4j.format.expert.ParsedValues r1 = (net.time4j.format.expert.ParsedValues) r1
        L_0x0191:
            r1.setNoAmbivalentCheck()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.expert.ChronoFormatter.parseElements(java.lang.CharSequence, net.time4j.format.expert.ParseLog, net.time4j.engine.AttributeQuery, boolean, int):net.time4j.engine.ChronoEntity");
    }

    private static String sub(int i, CharSequence charSequence) {
        int length = charSequence.length();
        if (length - i <= 10) {
            return charSequence.subSequence(i, length).toString();
        }
        return charSequence.subSequence(i, i + 10).toString() + "...";
    }

    private static String getDescription(ChronoEntity<?> chronoEntity) {
        Set<ChronoElement<?>> registeredElements = chronoEntity.getRegisteredElements();
        StringBuilder sb = new StringBuilder(registeredElements.size() * 16);
        sb.append(" [parsed={");
        boolean z = true;
        for (ChronoElement next : registeredElements) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(next.name());
            sb.append(SignatureVisitor.INSTANCEOF);
            sb.append(chronoEntity.get((ChronoElement<V>) next));
        }
        sb.append("}]");
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public static Chronology<?> checkElement(Chronology<?> chronology2, Chronology<?> chronology3, ChronoElement<?> chronoElement) {
        if (chronology2.isSupported(chronoElement)) {
            return chronology2;
        }
        if (chronology3 == null) {
            do {
                chronology2 = chronology2.preparser();
                if (chronology2 != null) {
                }
            } while (!chronology2.isSupported(chronoElement));
            return chronology2;
        } else if (chronoElement.isDateElement() && chronology3.isSupported(chronoElement)) {
            return chronology3;
        } else {
            if (chronoElement.isTimeElement() && PlainTime.axis().isSupported(chronoElement)) {
                return PlainTime.axis();
            }
        }
        throw new IllegalArgumentException("Unsupported element: " + chronoElement.name());
    }

    private static boolean needsExtension(Chronology<?> chronology2, Chronology<?> chronology3, ChronoElement<?> chronoElement) {
        for (ChronoExtension canResolve : chronology2.getExtensions()) {
            if (canResolve.canResolve(chronoElement)) {
                return true;
            }
        }
        if (chronology3 != null) {
            if (chronoElement.isDateElement()) {
                while (chronology3 instanceof BridgeChronology) {
                    chronology3 = chronology3.preparser();
                }
                for (ChronoExtension canResolve2 : chronology3.getExtensions()) {
                    if (canResolve2.canResolve(chronoElement)) {
                        return true;
                    }
                }
                return false;
            } else if (!chronoElement.isTimeElement() || !PlainTime.axis().isSupported(chronoElement)) {
                return false;
            } else {
                for (ChronoExtension canResolve3 : PlainTime.axis().getExtensions()) {
                    if (canResolve3.canResolve(chronoElement)) {
                        return true;
                    }
                }
                return false;
            }
        }
        while (true) {
            chronology2 = chronology2.preparser();
            if (chronology2 == null) {
                return false;
            }
            Iterator<ChronoExtension> it = chronology2.getExtensions().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().canResolve(chronoElement)) {
                        return true;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static int getDepth(Chronology<?> chronology2, Chronology<?> chronology3, Chronology<?> chronology4) {
        if (chronology4 != null) {
            return -1;
        }
        int i = 0;
        if (chronology2.equals(chronology3)) {
            return 0;
        }
        do {
            chronology3 = chronology3.preparser();
            if (chronology3 == null) {
                return Integer.MAX_VALUE;
            }
            i++;
        } while (!chronology2.equals(chronology3));
        return i;
    }

    private List<FormatStep> freeze(List<FormatStep> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (FormatStep quickPath : list) {
            arrayList.add(quickPath.quickPath(this));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private boolean hasNoPreparser() {
        return this.chronology.preparser() == null && this.overrideHandler == null;
    }

    public static final class Builder<T> {
        private static final AttributeKey<DayPeriod> CUSTOM_DAY_PERIOD = Attributes.createKey("CUSTOM_DAY_PERIOD", DayPeriod.class);
        /* access modifiers changed from: private */
        public final Chronology<T> chronology;
        private DayPeriod dayPeriod;
        private Chronology<?> deepestParser;
        private Map<ChronoElement<?>, Object> defaultMap;
        private int depthOfParser;
        private int leftPadWidth;
        private final Locale locale;
        private final Chronology<?> override;
        private String pattern;
        private int reservedIndex;
        private int sectionID;
        private LinkedList<AttributeSet> stack;
        private List<FormatStep> steps;

        private static boolean isSymbol(char c) {
            return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
        }

        private Builder(Chronology<T> chronology2, Locale locale2) {
            this(chronology2, locale2, (Chronology<?>) null);
        }

        private Builder(Chronology<T> chronology2, Locale locale2, Chronology<?> chronology3) {
            Objects.requireNonNull(chronology2, "Missing chronology.");
            Objects.requireNonNull(locale2, "Missing locale.");
            this.chronology = chronology2;
            this.override = chronology3;
            this.locale = locale2;
            this.steps = new ArrayList();
            this.stack = new LinkedList<>();
            this.sectionID = 0;
            this.reservedIndex = -1;
            this.leftPadWidth = 0;
            this.pattern = null;
            this.dayPeriod = null;
            this.defaultMap = new HashMap();
            this.deepestParser = chronology2;
            this.depthOfParser = 0;
        }

        public Chronology<?> getChronology() {
            Chronology<?> chronology2 = this.override;
            return chronology2 == null ? this.chronology : chronology2;
        }

        public Builder<T> addInteger(ChronoElement<Integer> chronoElement, int i, int i2) {
            return addNumber(chronoElement, false, i, i2, SignPolicy.SHOW_NEVER);
        }

        public Builder<T> addInteger(ChronoElement<Integer> chronoElement, int i, int i2, SignPolicy signPolicy) {
            return addNumber(chronoElement, false, i, i2, signPolicy);
        }

        public Builder<T> addLongNumber(ChronoElement<Long> chronoElement, int i, int i2, SignPolicy signPolicy) {
            return addNumber(chronoElement, false, i, i2, signPolicy);
        }

        public Builder<T> addFixedInteger(ChronoElement<Integer> chronoElement, int i) {
            return addNumber(chronoElement, true, i, i, SignPolicy.SHOW_NEVER);
        }

        public <V extends Enum<V>> Builder<T> addNumerical(ChronoElement<V> chronoElement, int i, int i2) {
            return addNumber(chronoElement, false, i, i2, SignPolicy.SHOW_NEVER);
        }

        public <V extends Enum<V>> Builder<T> addFixedNumerical(ChronoElement<V> chronoElement, int i) {
            return addNumber(chronoElement, true, i, i, SignPolicy.SHOW_NEVER);
        }

        public Builder<T> addFraction(ChronoElement<Integer> chronoElement, int i, int i2, boolean z) {
            checkElement(chronoElement);
            boolean z2 = !z && i == i2;
            ensureOnlyOneFractional(z2, z);
            FractionProcessor fractionProcessor = new FractionProcessor(chronoElement, i, i2, z);
            int i3 = this.reservedIndex;
            if (i3 == -1 || !z2) {
                addProcessor(fractionProcessor);
            } else {
                FormatStep formatStep = this.steps.get(i3);
                addProcessor(fractionProcessor);
                List<FormatStep> list = this.steps;
                if (formatStep.getSection() == list.get(list.size() - 1).getSection()) {
                    this.reservedIndex = i3;
                    this.steps.set(i3, formatStep.reserve(i));
                }
            }
            return this;
        }

        public Builder<T> addFixedDecimal(ChronoElement<BigDecimal> chronoElement) {
            return addFixedDecimal(chronoElement, 11, 9);
        }

        public Builder<T> addFixedDecimal(ChronoElement<BigDecimal> chronoElement, int i, int i2) {
            checkElement(chronoElement);
            ensureDecimalDigitsOnlyOnce();
            DecimalProcessor decimalProcessor = new DecimalProcessor(chronoElement, i, i2);
            int i3 = this.reservedIndex;
            if (i3 != -1) {
                FormatStep formatStep = this.steps.get(i3);
                addProcessor(decimalProcessor);
                List<FormatStep> list = this.steps;
                if (formatStep.getSection() == list.get(list.size() - 1).getSection()) {
                    this.reservedIndex = i3;
                    this.steps.set(i3, formatStep.reserve(i - i2));
                }
            } else {
                addProcessor(decimalProcessor);
            }
            return this;
        }

        public Builder<T> addEnglishOrdinal(ChronoElement<Integer> chronoElement) {
            return addOrdinalProcessor(chronoElement, (Map<PluralCategory, String>) null);
        }

        public Builder<T> addOrdinal(ChronoElement<Integer> chronoElement, Map<PluralCategory, String> map) {
            Objects.requireNonNull(map, "Missing ordinal indicators.");
            return addOrdinalProcessor(chronoElement, map);
        }

        public Builder<T> addLiteral(char c) {
            return addLiteral(String.valueOf(c));
        }

        public Builder<T> addLiteral(char c, char c2) {
            addProcessor(new LiteralProcessor(c, c2));
            return this;
        }

        public Builder<T> addLiteral(String str) {
            int i;
            FormatStep formatStep;
            LiteralProcessor literalProcessor = new LiteralProcessor(str);
            int prefixedDigitArea = literalProcessor.getPrefixedDigitArea();
            if (prefixedDigitArea > 0) {
                if (this.steps.isEmpty()) {
                    formatStep = null;
                } else {
                    List<FormatStep> list = this.steps;
                    formatStep = list.get(list.size() - 1);
                }
                if (formatStep != null && formatStep.isDecimal() && !formatStep.isNewOrBlockStarted()) {
                    throw new IllegalStateException("Numerical literal can't be inserted after an element with decimal digits.");
                }
            }
            if (prefixedDigitArea == 0 || (i = this.reservedIndex) == -1) {
                addProcessor(literalProcessor);
            } else {
                FormatStep formatStep2 = this.steps.get(i);
                addProcessor(literalProcessor);
                int section = formatStep2.getSection();
                List<FormatStep> list2 = this.steps;
                if (section == list2.get(list2.size() - 1).getSection()) {
                    this.reservedIndex = i;
                    this.steps.set(i, formatStep2.reserve(prefixedDigitArea));
                }
            }
            return this;
        }

        public Builder<T> addLiteral(AttributeKey<Character> attributeKey) {
            addProcessor(new LiteralProcessor(attributeKey));
            return this;
        }

        public Builder<T> addIgnorableWhitespace() {
            addProcessor(IgnorableWhitespaceProcessor.SINGLETON);
            return this;
        }

        public Builder<T> skipUnknown(int i) {
            addProcessor(new SkipProcessor(i));
            return this;
        }

        public Builder<T> skipUnknown(ChronoCondition<Character> chronoCondition, int i) {
            addProcessor(new SkipProcessor(chronoCondition, i));
            return this;
        }

        public Builder<T> addPattern(String str, PatternType patternType) {
            Objects.requireNonNull(patternType, "Missing pattern type.");
            Map<ChronoElement<?>, ChronoElement<?>> emptyMap = Collections.emptyMap();
            int length = str.length();
            Locale locale2 = this.locale;
            StringBuilder sb = new StringBuilder();
            if (!this.stack.isEmpty()) {
                locale2 = this.stack.getLast().getLocale();
            }
            int i = 0;
            while (i < length) {
                char charAt = str.charAt(i);
                if (isSymbol(charAt)) {
                    addLiteralChars(sb);
                    int i2 = i + 1;
                    while (i2 < length && str.charAt(i2) == charAt) {
                        i2++;
                    }
                    Map<ChronoElement<?>, ChronoElement<?>> registerSymbol = patternType.registerSymbol(this, locale2, charAt, i2 - i);
                    if (!registerSymbol.isEmpty()) {
                        if (emptyMap.isEmpty()) {
                            emptyMap = registerSymbol;
                        } else {
                            HashMap hashMap = new HashMap(emptyMap);
                            hashMap.putAll(registerSymbol);
                            emptyMap = hashMap;
                        }
                    }
                    i = i2 - 1;
                } else if (charAt == '\'') {
                    addLiteralChars(sb);
                    int i3 = i + 1;
                    int i4 = i3;
                    while (i4 < length) {
                        if (str.charAt(i4) == '\'') {
                            int i5 = i4 + 1;
                            if (i5 >= length || str.charAt(i5) != '\'') {
                                break;
                            }
                            i4 = i5;
                        }
                        i4++;
                    }
                    if (i4 < length) {
                        if (i3 == i4) {
                            addLiteral('\'');
                        } else {
                            addLiteral(str.substring(i3, i4).replace("''", "'"));
                        }
                        i = i4;
                    } else {
                        throw new IllegalArgumentException("String literal in pattern not closed: " + str);
                    }
                } else if (charAt == '[') {
                    addLiteralChars(sb);
                    startOptionalSection();
                } else if (charAt == ']') {
                    addLiteralChars(sb);
                    endSection();
                } else if (charAt == '|') {
                    try {
                        addLiteralChars(sb);
                        or();
                    } catch (IllegalStateException e) {
                        throw new IllegalArgumentException(e);
                    }
                } else if (charAt == '#' || charAt == '{' || charAt == '}') {
                    throw new IllegalArgumentException("Pattern contains reserved character: '" + charAt + "'");
                } else {
                    sb.append(charAt);
                }
                i++;
            }
            addLiteralChars(sb);
            if (!emptyMap.isEmpty()) {
                int size = this.steps.size();
                for (int i6 = 0; i6 < size; i6++) {
                    FormatStep formatStep = this.steps.get(i6);
                    ChronoElement<?> element = formatStep.getProcessor().getElement();
                    if (emptyMap.containsKey(element)) {
                        this.steps.set(i6, formatStep.updateElement(emptyMap.get(element)));
                    }
                }
            }
            if (this.pattern != null) {
                str = "";
            }
            this.pattern = str;
            return this;
        }

        public Builder<T> addText(TextElement<?> textElement) {
            checkElement(textElement);
            addProcessor(TextProcessor.create(textElement));
            return this;
        }

        public <V extends Enum<V>> Builder<T> addText(ChronoElement<V> chronoElement) {
            checkElement(chronoElement);
            if (chronoElement instanceof TextElement) {
                addProcessor(TextProcessor.create(TextElement.class.cast(chronoElement)));
            } else {
                HashMap hashMap = new HashMap();
                for (Enum enumR : (Enum[]) chronoElement.getType().getEnumConstants()) {
                    hashMap.put(enumR, enumR.toString());
                }
                addProcessor(new LookupProcessor(chronoElement, hashMap));
            }
            return this;
        }

        public <V> Builder<T> addText(ChronoElement<V> chronoElement, Map<V, String> map) {
            checkElement(chronoElement);
            addProcessor(new LookupProcessor(chronoElement, map));
            return this;
        }

        public Builder<T> addDayPeriodFixed() {
            return addText(findDayPeriodElement(true, (DayPeriod) null));
        }

        public Builder<T> addDayPeriodApproximate() {
            return addText(findDayPeriodElement(false, (DayPeriod) null));
        }

        public Builder<T> addDayPeriod(Map<PlainTime, String> map) {
            if (this.dayPeriod == null) {
                DayPeriod of = DayPeriod.of(map);
                TextElement<?> findDayPeriodElement = findDayPeriodElement(false, of);
                this.dayPeriod = of;
                addProcessor(TextProcessor.createProtected(findDayPeriodElement));
                return this;
            }
            throw new IllegalStateException("Cannot add custom day period more than once.");
        }

        public <V extends ChronoEntity<V>> Builder<T> addCustomized(ChronoElement<V> chronoElement, ChronoFormatter<V> chronoFormatter) {
            return addCustomized(chronoElement, chronoFormatter, chronoFormatter);
        }

        public <V> Builder<T> addCustomized(ChronoElement<V> chronoElement, ChronoPrinter<V> chronoPrinter, ChronoParser<V> chronoParser) {
            checkElement(chronoElement);
            addProcessor(new CustomizedProcessor(chronoElement, chronoPrinter, chronoParser));
            return this;
        }

        public Builder<T> addTwoDigitYear(ChronoElement<Integer> chronoElement) {
            checkElement(chronoElement);
            checkAfterDecimalDigits(chronoElement);
            TwoDigitYearProcessor twoDigitYearProcessor = new TwoDigitYearProcessor(chronoElement);
            int i = this.reservedIndex;
            if (i == -1) {
                addProcessor(twoDigitYearProcessor);
                this.reservedIndex = this.steps.size() - 1;
            } else {
                FormatStep formatStep = this.steps.get(i);
                startSection(Attributes.LENIENCY, Leniency.STRICT);
                addProcessor(twoDigitYearProcessor);
                endSection();
                List<FormatStep> list = this.steps;
                if (formatStep.getSection() == list.get(list.size() - 1).getSection()) {
                    this.reservedIndex = i;
                    this.steps.set(i, formatStep.reserve(2));
                }
            }
            return this;
        }

        public Builder<T> addTimezoneID() {
            if (hasUnixChronology(this.chronology)) {
                addProcessor(TimezoneIDProcessor.INSTANCE);
                return this;
            }
            throw new IllegalStateException("Only unix timestamps can have a timezone id.");
        }

        public Builder<T> addShortTimezoneName() {
            checkMomentChrono();
            addProcessor(new TimezoneNameProcessor(true));
            return this;
        }

        public Builder<T> addLongTimezoneName() {
            checkMomentChrono();
            addProcessor(new TimezoneNameProcessor(false));
            return this;
        }

        public Builder<T> addShortTimezoneName(Set<TZID> set) {
            checkMomentChrono();
            addProcessor(new TimezoneNameProcessor(true, set));
            return this;
        }

        public Builder<T> addLongTimezoneName(Set<TZID> set) {
            checkMomentChrono();
            addProcessor(new TimezoneNameProcessor(false, set));
            return this;
        }

        public Builder<T> addTimezoneName(NameStyle nameStyle) {
            addProcessor(new TimezoneGenericProcessor(nameStyle));
            return this;
        }

        public Builder<T> addTimezoneName(NameStyle nameStyle, Set<TZID> set) {
            addProcessor(new TimezoneGenericProcessor(nameStyle, set));
            return this;
        }

        public Builder<T> addTimezoneOffset() {
            return addTimezoneOffset(DisplayMode.MEDIUM, true, Collections.singletonList("Z"));
        }

        public Builder<T> addTimezoneOffset(DisplayMode displayMode, boolean z, List<String> list) {
            addProcessor(new TimezoneOffsetProcessor(displayMode, z, list));
            return this;
        }

        public Builder<T> addShortLocalizedOffset() {
            addProcessor(new LocalizedGMTProcessor(true));
            return this;
        }

        public Builder<T> addLongLocalizedOffset() {
            addProcessor(new LocalizedGMTProcessor(false));
            return this;
        }

        public Builder<T> padNext(int i) {
            if (i >= 0) {
                if (i > 0) {
                    this.leftPadWidth = i;
                }
                return this;
            }
            throw new IllegalArgumentException("Negative pad width: " + i);
        }

        public Builder<T> padPrevious(int i) {
            if (i >= 0) {
                if (!this.steps.isEmpty() && i > 0) {
                    int size = this.steps.size() - 1;
                    FormatStep formatStep = this.steps.get(size);
                    if ((!this.stack.isEmpty() ? this.stack.getLast().getSection() : 0) == formatStep.getSection() && !formatStep.isNewOrBlockStarted()) {
                        this.steps.set(size, formatStep.pad(0, i));
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("Negative pad width: " + i);
        }

        public Builder<T> startOptionalSection() {
            return startOptionalSection((ChronoCondition<ChronoDisplay>) null);
        }

        public Builder<T> startOptionalSection(final ChronoCondition<ChronoDisplay> chronoCondition) {
            final ChronoCondition<ChronoDisplay> chronoCondition2;
            AnonymousClass1 r8;
            resetPadding();
            Attributes.Builder builder = new Attributes.Builder();
            AttributeSet attributeSet = null;
            if (!this.stack.isEmpty()) {
                attributeSet = this.stack.getLast();
                builder.setAll(attributeSet.getAttributes());
                chronoCondition2 = attributeSet.getCondition();
            } else {
                chronoCondition2 = null;
            }
            int level = getLevel(attributeSet) + 1;
            int i = this.sectionID + 1;
            this.sectionID = i;
            if (chronoCondition != null) {
                r8 = chronoCondition2 == null ? chronoCondition : new ChronoCondition<ChronoDisplay>() {
                    public boolean test(ChronoDisplay chronoDisplay) {
                        return chronoCondition2.test(chronoDisplay) && chronoCondition.test(chronoDisplay);
                    }
                };
            } else {
                r8 = chronoCondition2;
            }
            this.stack.addLast(new AttributeSet(builder.build(), this.locale, level, i, r8));
            return this;
        }

        public Builder<T> startSection(AttributeKey<Boolean> attributeKey, boolean z) {
            AttributeSet attributeSet;
            checkAttribute(attributeKey);
            resetPadding();
            if (this.stack.isEmpty()) {
                attributeSet = new AttributeSet(new Attributes.Builder().set(attributeKey, z).build(), this.locale);
            } else {
                AttributeSet last = this.stack.getLast();
                Attributes.Builder builder = new Attributes.Builder();
                builder.setAll(last.getAttributes());
                builder.set(attributeKey, z);
                attributeSet = last.withAttributes(builder.build());
            }
            this.stack.addLast(attributeSet);
            return this;
        }

        public Builder<T> startSection(AttributeKey<Integer> attributeKey, int i) {
            AttributeSet attributeSet;
            checkAttribute(attributeKey);
            resetPadding();
            if (this.stack.isEmpty()) {
                attributeSet = new AttributeSet(new Attributes.Builder().set(attributeKey, i).build(), this.locale);
            } else {
                AttributeSet last = this.stack.getLast();
                Attributes.Builder builder = new Attributes.Builder();
                builder.setAll(last.getAttributes());
                builder.set(attributeKey, i);
                attributeSet = last.withAttributes(builder.build());
            }
            this.stack.addLast(attributeSet);
            return this;
        }

        public Builder<T> startSection(AttributeKey<Character> attributeKey, char c) {
            AttributeSet attributeSet;
            checkAttribute(attributeKey);
            resetPadding();
            if (this.stack.isEmpty()) {
                attributeSet = new AttributeSet(new Attributes.Builder().set(attributeKey, c).build(), this.locale);
            } else {
                AttributeSet last = this.stack.getLast();
                Attributes.Builder builder = new Attributes.Builder();
                builder.setAll(last.getAttributes());
                builder.set(attributeKey, c);
                attributeSet = last.withAttributes(builder.build());
            }
            this.stack.addLast(attributeSet);
            return this;
        }

        public <A extends Enum<A>> Builder<T> startSection(AttributeKey<A> attributeKey, A a) {
            AttributeSet attributeSet;
            checkAttribute(attributeKey);
            resetPadding();
            if (this.stack.isEmpty()) {
                attributeSet = new AttributeSet(new Attributes.Builder().set(attributeKey, a).build(), this.locale);
            } else {
                AttributeSet last = this.stack.getLast();
                Attributes.Builder builder = new Attributes.Builder();
                builder.setAll(last.getAttributes());
                builder.set(attributeKey, a);
                attributeSet = last.withAttributes(builder.build());
            }
            this.stack.addLast(attributeSet);
            return this;
        }

        public Builder<T> endSection() {
            this.stack.removeLast();
            resetPadding();
            return this;
        }

        public Builder<T> or() {
            int i;
            FormatStep formatStep;
            int i2;
            int section = !this.stack.isEmpty() ? this.stack.getLast().getSection() : 0;
            if (!this.steps.isEmpty()) {
                i2 = this.steps.size() - 1;
                formatStep = this.steps.get(i2);
                i = formatStep.getSection();
            } else {
                formatStep = null;
                i2 = -1;
                i = -1;
            }
            if (section == i) {
                this.steps.set(i2, formatStep.startNewOrBlock());
                resetPadding();
                this.reservedIndex = -1;
                return this;
            }
            throw new IllegalStateException("Cannot start or-block without any previous step in current section.");
        }

        public <V> Builder<T> setDefault(ChronoElement<V> chronoElement, V v) {
            Objects.requireNonNull(v, "Missing default value.");
            checkElement(chronoElement);
            this.defaultMap.put(chronoElement, v);
            return this;
        }

        public ChronoFormatter<T> build() {
            return build(Attributes.empty());
        }

        public ChronoFormatter<T> build(Attributes attributes) {
            boolean z;
            Objects.requireNonNull(attributes, "Missing format attributes.");
            int size = this.steps.size();
            HashMap hashMap = null;
            for (int i = 0; i < size; i++) {
                FormatStep formatStep = this.steps.get(i);
                if (formatStep.isNewOrBlockStarted()) {
                    int section = formatStep.getSection();
                    int i2 = size - 1;
                    while (true) {
                        if (i2 <= i) {
                            z = false;
                            break;
                        } else if (this.steps.get(i2).getSection() == section) {
                            if (hashMap == null) {
                                hashMap = new HashMap();
                            }
                            hashMap.put(Integer.valueOf(i), formatStep.markLastOrBlock(i2));
                            z = true;
                        } else {
                            i2--;
                        }
                    }
                    if (!z) {
                        throw new IllegalStateException("Missing format processor after or-operator.");
                    }
                }
            }
            if (hashMap != null) {
                for (Integer num : hashMap.keySet()) {
                    this.steps.set(num.intValue(), hashMap.get(num));
                }
            }
            ChronoFormatter chronoFormatter = new ChronoFormatter(this.chronology, this.override, this.locale, this.steps, this.defaultMap, attributes, this.deepestParser);
            String str = this.pattern;
            if (str == null) {
                str = "";
            }
            if (this.dayPeriod == null && str.isEmpty()) {
                return chronoFormatter;
            }
            AttributeSet access$700 = chronoFormatter.globalAttributes;
            if (!str.isEmpty()) {
                access$700 = access$700.withInternal(Attributes.FORMAT_PATTERN, str);
            }
            DayPeriod dayPeriod2 = this.dayPeriod;
            if (dayPeriod2 != null) {
                access$700 = access$700.withInternal(CUSTOM_DAY_PERIOD, dayPeriod2);
            }
            return new ChronoFormatter<>(access$700);
        }

        /* access modifiers changed from: package-private */
        public Builder<T> addYear(ChronoElement<Integer> chronoElement, int i, boolean z) {
            FormatStep formatStep;
            if (this.steps.isEmpty()) {
                formatStep = null;
            } else {
                List<FormatStep> list = this.steps;
                formatStep = list.get(list.size() - 1);
            }
            if (formatStep == null || formatStep.isNewOrBlockStarted() || !formatStep.isNumerical() || i != 4) {
                return addNumber(chronoElement, false, i, 10, SignPolicy.SHOW_WHEN_NEGATIVE, z);
            }
            return addNumber(chronoElement, true, 4, 4, SignPolicy.SHOW_NEVER, z);
        }

        private <V> Builder<T> addNumber(ChronoElement<V> chronoElement, boolean z, int i, int i2, SignPolicy signPolicy) {
            return addNumber(chronoElement, z, i, i2, signPolicy, false);
        }

        private <V> Builder<T> addNumber(ChronoElement<V> chronoElement, boolean z, int i, int i2, SignPolicy signPolicy, boolean z2) {
            checkElement(chronoElement);
            FormatStep checkAfterDecimalDigits = checkAfterDecimalDigits(chronoElement);
            NumberProcessor numberProcessor = new NumberProcessor(chronoElement, z, i, i2, signPolicy, z2);
            if (z) {
                int i3 = this.reservedIndex;
                if (i3 == -1) {
                    addProcessor(numberProcessor);
                } else {
                    FormatStep formatStep = this.steps.get(i3);
                    addProcessor(numberProcessor);
                    List<FormatStep> list = this.steps;
                    if (formatStep.getSection() == list.get(list.size() - 1).getSection()) {
                        this.reservedIndex = i3;
                        this.steps.set(i3, formatStep.reserve(i));
                    }
                }
            } else if (checkAfterDecimalDigits == null || !checkAfterDecimalDigits.isNumerical() || checkAfterDecimalDigits.isNewOrBlockStarted()) {
                addProcessor(numberProcessor);
                this.reservedIndex = this.steps.size() - 1;
            } else {
                throw new IllegalStateException("Numerical element with variable width can't be inserted after another numerical element. Consider \"addFixedXXX()\" instead.");
            }
            return this;
        }

        private Builder<T> addOrdinalProcessor(ChronoElement<Integer> chronoElement, Map<PluralCategory, String> map) {
            checkElement(chronoElement);
            FormatStep checkAfterDecimalDigits = checkAfterDecimalDigits(chronoElement);
            OrdinalProcessor ordinalProcessor = new OrdinalProcessor(chronoElement, map);
            if (checkAfterDecimalDigits == null || !checkAfterDecimalDigits.isNumerical() || checkAfterDecimalDigits.isNewOrBlockStarted()) {
                addProcessor(ordinalProcessor);
                return this;
            }
            throw new IllegalStateException("Ordinal element with variable width can't be inserted after another numerical element.");
        }

        /* access modifiers changed from: private */
        public void addProcessor(FormatProcessor<?> formatProcessor) {
            int i;
            int i2;
            AttributeSet attributeSet;
            this.reservedIndex = -1;
            if (!this.stack.isEmpty()) {
                attributeSet = this.stack.getLast();
                i2 = attributeSet.getLevel();
                i = attributeSet.getSection();
            } else {
                attributeSet = null;
                i2 = 0;
                i = 0;
            }
            FormatStep formatStep = new FormatStep(formatProcessor, i2, i, attributeSet);
            int i3 = this.leftPadWidth;
            if (i3 > 0) {
                formatStep = formatStep.pad(i3, 0);
                this.leftPadWidth = 0;
            }
            this.steps.add(formatStep);
        }

        private TextElement<?> findDayPeriodElement(boolean z, DayPeriod dayPeriod2) {
            AttributeSet attributeSet;
            Attributes build = new Attributes.Builder(getChronology()).build();
            AttributeQuery attributeQuery = build;
            if (dayPeriod2 != null) {
                if (this.stack.isEmpty()) {
                    attributeSet = new AttributeSet(build, this.locale);
                } else {
                    attributeSet = this.stack.getLast();
                }
                attributeQuery = attributeSet.withInternal(CUSTOM_DAY_PERIOD, dayPeriod2);
            }
            for (ChronoExtension elements : PlainTime.axis().getExtensions()) {
                Iterator<ChronoElement<?>> it = elements.getElements(this.locale, attributeQuery).iterator();
                while (true) {
                    if (it.hasNext()) {
                        ChronoElement next = it.next();
                        if (z && next.getSymbol() == 'b' && isDayPeriodSupported(next)) {
                            return (TextElement) ChronoFormatter.cast(next);
                        }
                        if (!z && next.getSymbol() == 'B' && isDayPeriodSupported(next)) {
                            return (TextElement) ChronoFormatter.cast(next);
                        }
                    }
                }
            }
            throw new IllegalStateException("Day periods are not supported: " + getChronology().getChronoType());
        }

        private boolean isDayPeriodSupported(ChronoElement<?> chronoElement) {
            if (!chronoElement.name().endsWith("_DAY_PERIOD")) {
                return false;
            }
            if (this.override != null || this.chronology.isSupported(chronoElement)) {
                return true;
            }
            Chronology chronology2 = this.chronology;
            do {
                chronology2 = chronology2.preparser();
                if (chronology2 == null) {
                    return false;
                }
            } while (!chronology2.isSupported(chronoElement));
            return true;
        }

        private static int getLevel(AttributeSet attributeSet) {
            if (attributeSet == null) {
                return 0;
            }
            return attributeSet.getLevel();
        }

        private static void checkAttribute(AttributeKey<?> attributeKey) {
            if (attributeKey.name().charAt(0) == '_') {
                throw new IllegalArgumentException("Internal attribute not allowed: " + attributeKey.name());
            }
        }

        private void checkMomentChrono() {
            if (!hasUnixChronology(this.chronology)) {
                throw new IllegalStateException("Timezone names in specific non-location format can only be reliably combined with instant-like types, for example \"Moment\".");
            }
        }

        /* access modifiers changed from: private */
        public static boolean hasUnixChronology(Chronology<?> chronology2) {
            while (!UnixTime.class.isAssignableFrom(chronology2.getChronoType())) {
                chronology2 = chronology2.preparser();
                if (chronology2 == null) {
                    return false;
                }
            }
            return true;
        }

        private void resetPadding() {
            this.leftPadWidth = 0;
        }

        private void checkElement(ChronoElement<?> chronoElement) {
            Chronology<?> access$1000 = ChronoFormatter.checkElement(this.chronology, this.override, chronoElement);
            int access$1100 = ChronoFormatter.getDepth(access$1000, this.chronology, this.override);
            if (access$1100 >= this.depthOfParser) {
                this.deepestParser = access$1000;
                this.depthOfParser = access$1100;
            }
        }

        private void ensureDecimalDigitsOnlyOnce() {
            int size = this.steps.size() - 1;
            while (size >= 0) {
                FormatStep formatStep = this.steps.get(size);
                if (!formatStep.isNewOrBlockStarted()) {
                    if (!formatStep.isDecimal()) {
                        size--;
                    } else {
                        throw new IllegalArgumentException("Cannot define more than one element with decimal digits.");
                    }
                } else {
                    return;
                }
            }
        }

        private void ensureOnlyOneFractional(boolean z, boolean z2) {
            ensureDecimalDigitsOnlyOnce();
            if (!z && !z2 && this.reservedIndex != -1) {
                throw new IllegalArgumentException("Cannot add fractional element with variable width after another numerical element with variable width.");
            }
        }

        private FormatStep checkAfterDecimalDigits(ChronoElement<?> chronoElement) {
            FormatStep formatStep;
            if (this.steps.isEmpty()) {
                formatStep = null;
            } else {
                List<FormatStep> list = this.steps;
                formatStep = list.get(list.size() - 1);
            }
            if (formatStep == null) {
                return null;
            }
            if (!formatStep.isDecimal() || formatStep.isNewOrBlockStarted()) {
                return formatStep;
            }
            throw new IllegalStateException(chronoElement.name() + " can't be inserted after an element" + " with decimal digits.");
        }

        private void addLiteralChars(StringBuilder sb) {
            if (sb.length() > 0) {
                addLiteral(sb.toString());
                sb.setLength(0);
            }
        }
    }

    private static class TraditionalFormat<T> extends Format {
        private static final Map<String, DateFormat.Field> FIELD_MAP;
        private final ChronoFormatter<T> formatter;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put("YEAR", DateFormat.Field.YEAR);
            hashMap.put("YEAR_OF_ERA", DateFormat.Field.YEAR);
            hashMap.put("YEAR_OF_WEEKDATE", DateFormat.Field.YEAR);
            hashMap.put("WEEK_OF_YEAR", DateFormat.Field.WEEK_OF_YEAR);
            hashMap.put("WEEK_OF_MONTH", DateFormat.Field.WEEK_OF_MONTH);
            hashMap.put("BOUNDED_WEEK_OF_YEAR", DateFormat.Field.WEEK_OF_YEAR);
            hashMap.put("BOUNDED_WEEK_OF_MONTH", DateFormat.Field.WEEK_OF_MONTH);
            hashMap.put("MONTH_OF_YEAR", DateFormat.Field.MONTH);
            hashMap.put("MONTH_AS_NUMBER", DateFormat.Field.MONTH);
            hashMap.put("HISTORIC_MONTH", DateFormat.Field.MONTH);
            hashMap.put("WEEKDAY_IN_MONTH", DateFormat.Field.DAY_OF_WEEK_IN_MONTH);
            hashMap.put("SECOND_OF_MINUTE", DateFormat.Field.SECOND);
            hashMap.put("MINUTE_OF_HOUR", DateFormat.Field.MINUTE);
            hashMap.put("MILLI_OF_SECOND", DateFormat.Field.MILLISECOND);
            hashMap.put("DIGITAL_HOUR_OF_DAY", DateFormat.Field.HOUR_OF_DAY0);
            hashMap.put("DIGITAL_HOUR_OF_AMPM", DateFormat.Field.HOUR0);
            hashMap.put("CLOCK_HOUR_OF_DAY", DateFormat.Field.HOUR_OF_DAY1);
            hashMap.put("CLOCK_HOUR_OF_AMPM", DateFormat.Field.HOUR1);
            hashMap.put("AM_PM_OF_DAY", DateFormat.Field.AM_PM);
            hashMap.put("DAY_OF_MONTH", DateFormat.Field.DAY_OF_MONTH);
            hashMap.put("HISTORIC_DAY_OF_MONTH", DateFormat.Field.DAY_OF_MONTH);
            hashMap.put("DAY_OF_WEEK", DateFormat.Field.DAY_OF_WEEK);
            hashMap.put("LOCAL_DAY_OF_WEEK", DateFormat.Field.DAY_OF_WEEK);
            hashMap.put("DAY_OF_YEAR", DateFormat.Field.DAY_OF_YEAR);
            hashMap.put("TIMEZONE_ID", DateFormat.Field.TIME_ZONE);
            hashMap.put("ERA", DateFormat.Field.ERA);
            FIELD_MAP = Collections.unmodifiableMap(hashMap);
        }

        TraditionalFormat(ChronoFormatter<T> chronoFormatter) {
            this.formatter = chronoFormatter;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0095, code lost:
            r8.setBeginIndex(r1.getStartIndex());
            r8.setEndIndex(r1.getEndIndex());
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.StringBuffer format(java.lang.Object r6, java.lang.StringBuffer r7, java.text.FieldPosition r8) {
            /*
                r5 = this;
                java.lang.String r0 = "iso8601"
                r1 = 0
                r8.setBeginIndex(r1)
                r8.setEndIndex(r1)
                net.time4j.format.expert.ChronoFormatter<T> r1 = r5.formatter     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                net.time4j.format.expert.AttributeSet r1 = r1.globalAttributes     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                net.time4j.engine.AttributeKey<java.lang.String> r2 = net.time4j.format.Attributes.CALENDAR_TYPE     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                java.lang.Object r2 = r1.get(r2, r0)     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                java.lang.String r2 = (java.lang.String) r2     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                net.time4j.format.expert.ChronoFormatter<T> r3 = r5.formatter     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                net.time4j.engine.Chronology r3 = r3.getChronology()     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                java.lang.Class r3 = r3.getChronoType()     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                java.lang.Object r3 = r3.cast(r6)     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                net.time4j.format.expert.ChronoFormatter<T> r4 = r5.formatter     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                java.util.Set r1 = r4.print(r3, r7, r1)     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                boolean r0 = r2.equals(r0)     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                if (r0 == 0) goto L_0x00a3
                java.util.Iterator r0 = r1.iterator()     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
            L_0x0035:
                boolean r1 = r0.hasNext()     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                if (r1 == 0) goto L_0x00a3
                java.lang.Object r1 = r0.next()     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                net.time4j.format.expert.ElementPosition r1 = (net.time4j.format.expert.ElementPosition) r1     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                net.time4j.engine.ChronoElement r2 = r1.getElement()     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                java.text.DateFormat$Field r2 = toField(r2)     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                if (r2 == 0) goto L_0x0035
                java.text.Format$Field r3 = r8.getFieldAttribute()     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                boolean r3 = r2.equals(r3)     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                if (r3 != 0) goto L_0x0095
                int r3 = r2.getCalendarField()     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                int r4 = r8.getField()     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                if (r3 != r4) goto L_0x0066
                int r3 = r8.getField()     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                r4 = -1
                if (r3 != r4) goto L_0x0095
            L_0x0066:
                java.text.DateFormat$Field r3 = java.text.DateFormat.Field.TIME_ZONE     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                boolean r3 = r2.equals(r3)     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                if (r3 == 0) goto L_0x0076
                int r3 = r8.getField()     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                r4 = 17
                if (r3 == r4) goto L_0x0095
            L_0x0076:
                java.text.DateFormat$Field r3 = java.text.DateFormat.Field.HOUR_OF_DAY1     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                boolean r3 = r2.equals(r3)     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                if (r3 == 0) goto L_0x0085
                int r3 = r8.getField()     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                r4 = 4
                if (r3 == r4) goto L_0x0095
            L_0x0085:
                java.text.DateFormat$Field r3 = java.text.DateFormat.Field.HOUR1     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                boolean r2 = r2.equals(r3)     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                if (r2 == 0) goto L_0x0035
                int r2 = r8.getField()     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                r3 = 15
                if (r2 != r3) goto L_0x0035
            L_0x0095:
                int r0 = r1.getStartIndex()     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                r8.setBeginIndex(r0)     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                int r0 = r1.getEndIndex()     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
                r8.setEndIndex(r0)     // Catch:{ ClassCastException -> 0x00bc, IOException -> 0x00a4 }
            L_0x00a3:
                return r7
            L_0x00a4:
                r7 = move-exception
                java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Cannot print object: "
                r0.append(r1)
                r0.append(r6)
                java.lang.String r6 = r0.toString()
                r8.<init>(r6, r7)
                throw r8
            L_0x00bc:
                r7 = move-exception
                java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Not formattable: "
                r0.append(r1)
                r0.append(r6)
                java.lang.String r6 = r0.toString()
                r8.<init>(r6, r7)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.format.expert.ChronoFormatter.TraditionalFormat.format(java.lang.Object, java.lang.StringBuffer, java.text.FieldPosition):java.lang.StringBuffer");
        }

        public AttributedCharacterIterator formatToCharacterIterator(Object obj) {
            if (!((String) this.formatter.globalAttributes.get(Attributes.CALENDAR_TYPE, CalendarText.ISO_CALENDAR_TYPE)).equals(CalendarText.ISO_CALENDAR_TYPE)) {
                return super.formatToCharacterIterator(obj);
            }
            try {
                StringBuilder sb = new StringBuilder();
                Set<ElementPosition> print = this.formatter.print(this.formatter.getChronology().getChronoType().cast(obj), sb);
                AttributedString attributedString = new AttributedString(sb.toString());
                for (ElementPosition next : print) {
                    DateFormat.Field field = toField(next.getElement());
                    if (field != null) {
                        attributedString.addAttribute(field, field, next.getStartIndex(), next.getEndIndex());
                    }
                }
                return attributedString.getIterator();
            } catch (ClassCastException e) {
                throw new IllegalArgumentException("Not formattable: " + obj, e);
            }
        }

        public Object parseObject(String str, ParsePosition parsePosition) {
            ParseLog parseLog = new ParseLog(parsePosition.getIndex());
            T parse = this.formatter.parse((CharSequence) str, parseLog);
            if (parse == null) {
                parsePosition.setErrorIndex(parseLog.getErrorIndex());
            } else {
                parsePosition.setIndex(parseLog.getPosition());
            }
            return parse;
        }

        private static DateFormat.Field toField(ChronoElement<?> chronoElement) {
            return FIELD_MAP.get(chronoElement.name());
        }
    }

    private static class OverrideHandler<C> implements ChronoMerger<GeneralTimestamp<C>> {
        private final List<ChronoExtension> extensions;
        private final Chronology<C> override;

        private OverrideHandler(Chronology<C> chronology) {
            this.override = chronology;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(chronology.getExtensions());
            arrayList.addAll(PlainTime.axis().getExtensions());
            this.extensions = Collections.unmodifiableList(arrayList);
        }

        static <C> OverrideHandler<C> of(Chronology<C> chronology) {
            if (chronology == null) {
                return null;
            }
            return new OverrideHandler<>(chronology);
        }

        public GeneralTimestamp<C> createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
            GeneralTimestamp generalTimestamp;
            C createFrom = this.override.createFrom(chronoEntity, attributeQuery, z, z2);
            PlainTime plainTime = (PlainTime) PlainTime.axis().createFrom((ChronoEntity) chronoEntity, attributeQuery, z, z2);
            if (createFrom instanceof CalendarVariant) {
                generalTimestamp = GeneralTimestamp.of(CalendarVariant.class.cast(createFrom), plainTime);
            } else if (createFrom instanceof Calendrical) {
                generalTimestamp = GeneralTimestamp.of(Calendrical.class.cast(createFrom), plainTime);
            } else {
                throw new IllegalStateException("Cannot determine calendar type: " + createFrom);
            }
            return (GeneralTimestamp) ChronoFormatter.cast(generalTimestamp);
        }

        public StartOfDay getDefaultStartOfDay() {
            return this.override.getDefaultStartOfDay();
        }

        public int getDefaultPivotYear() {
            return this.override.getDefaultPivotYear();
        }

        public List<ChronoExtension> getExtensions() {
            return this.extensions;
        }

        public Chronology<?> getCalendarOverride() {
            return this.override;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof OverrideHandler) {
                return this.override.equals(((OverrideHandler) obj).override);
            }
            return false;
        }

        public int hashCode() {
            return this.override.hashCode();
        }

        public String toString() {
            return this.override.getChronoType().getName();
        }

        public ChronoDisplay preformat(GeneralTimestamp<C> generalTimestamp, AttributeQuery attributeQuery) {
            throw new UnsupportedOperationException("Not used.");
        }

        public Chronology<?> preparser() {
            throw new UnsupportedOperationException("Not used.");
        }

        public GeneralTimestamp<C> createFrom(TimeSource<?> timeSource, AttributeQuery attributeQuery) {
            throw new UnsupportedOperationException("Not used.");
        }

        public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
            throw new UnsupportedOperationException("Not used.");
        }
    }

    private static class ZonalDisplay implements ChronoDisplay, VariantSource, UnixTime {
        private final GeneralTimestamp<?> tsp;
        private final TZID tzid;
        private final String variant;

        public boolean hasTimezone() {
            return true;
        }

        private ZonalDisplay(GeneralTimestamp<?> generalTimestamp, String str, TZID tzid2) {
            this.tsp = generalTimestamp;
            this.variant = str;
            this.tzid = tzid2;
        }

        public boolean contains(ChronoElement<?> chronoElement) {
            return this.tsp.contains(chronoElement);
        }

        public <V> V get(ChronoElement<V> chronoElement) {
            return this.tsp.get(chronoElement);
        }

        public int getInt(ChronoElement<Integer> chronoElement) {
            return this.tsp.getInt(chronoElement);
        }

        public <V> V getMinimum(ChronoElement<V> chronoElement) {
            return this.tsp.getMinimum(chronoElement);
        }

        public <V> V getMaximum(ChronoElement<V> chronoElement) {
            return this.tsp.getMaximum(chronoElement);
        }

        public TZID getTimezone() {
            return this.tzid;
        }

        public long getPosixTime() {
            return getUnixTime().getPosixTime();
        }

        public int getNanosecond() {
            return getUnixTime().getNanosecond();
        }

        private UnixTime getUnixTime() {
            StartOfDay startOfDay;
            try {
                startOfDay = Chronology.lookup(this.tsp.toDate().getClass()).getDefaultStartOfDay();
            } catch (RuntimeException unused) {
                startOfDay = StartOfDay.MIDNIGHT;
            }
            return this.tsp.in(Timezone.of(this.tzid), startOfDay);
        }

        public String getVariant() {
            return this.variant;
        }
    }
}
