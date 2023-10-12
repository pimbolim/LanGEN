package net.time4j.engine;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import net.time4j.base.TimeSource;

public class Chronology<T> implements ChronoMerger<T> {
    private static final List<ChronoReference> CHRONOS = new CopyOnWriteArrayList();
    private static final ReferenceQueue<Chronology<?>> QUEUE = new ReferenceQueue<>();
    /* access modifiers changed from: private */
    public final Class<T> chronoType;
    private final List<ChronoExtension> extensions;
    private final Map<ChronoElement<?>, IntElementRule<T>> intRules;
    private final ChronoMerger<T> merger;
    private final Map<ChronoElement<?>, ElementRule<T, ?>> ruleMap;

    private static <T> T cast(Object obj) {
        return obj;
    }

    public boolean hasCalendarSystem() {
        return false;
    }

    Chronology(Class<T> cls) {
        Objects.requireNonNull(cls, "Missing chronological type.");
        this.chronoType = cls;
        this.merger = null;
        this.ruleMap = Collections.emptyMap();
        this.extensions = Collections.emptyList();
        this.intRules = Collections.emptyMap();
    }

    Chronology(Class<T> cls, ChronoMerger<T> chronoMerger, Map<ChronoElement<?>, ElementRule<T, ?>> map, List<ChronoExtension> list) {
        Objects.requireNonNull(cls, "Missing chronological type.");
        Objects.requireNonNull(chronoMerger, "Missing chronological merger.");
        this.chronoType = cls;
        this.merger = chronoMerger;
        Map<ChronoElement<?>, ElementRule<T, ?>> unmodifiableMap = Collections.unmodifiableMap(map);
        this.ruleMap = unmodifiableMap;
        this.extensions = Collections.unmodifiableList(list);
        HashMap hashMap = new HashMap();
        for (ChronoElement next : unmodifiableMap.keySet()) {
            if (next.getType() == Integer.class) {
                ElementRule<T, ?> elementRule = this.ruleMap.get(next);
                if (elementRule instanceof IntElementRule) {
                    hashMap.put(next, (IntElementRule) elementRule);
                }
            }
        }
        this.intRules = Collections.unmodifiableMap(hashMap);
    }

    public Class<T> getChronoType() {
        return this.chronoType;
    }

    public Set<ChronoElement<?>> getRegisteredElements() {
        return this.ruleMap.keySet();
    }

    public boolean isRegistered(ChronoElement<?> chronoElement) {
        return chronoElement != null && this.ruleMap.containsKey(chronoElement);
    }

    public boolean isSupported(ChronoElement<?> chronoElement) {
        if (chronoElement == null) {
            return false;
        }
        if (isRegistered(chronoElement) || getDerivedRule(chronoElement, false) != null) {
            return true;
        }
        return false;
    }

    public T createFrom(TimeSource<?> timeSource, AttributeQuery attributeQuery) {
        Objects.requireNonNull(attributeQuery, "Missing attributes.");
        return this.merger.createFrom(timeSource, attributeQuery);
    }

    public T createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
        return this.merger.createFrom(chronoEntity, attributeQuery, z, z2);
    }

    public ChronoDisplay preformat(T t, AttributeQuery attributeQuery) {
        return this.merger.preformat(t, attributeQuery);
    }

    public Chronology<?> preparser() {
        return this.merger.preparser();
    }

    public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
        return this.merger.getFormatPattern(displayStyle, locale);
    }

    public StartOfDay getDefaultStartOfDay() {
        return this.merger.getDefaultStartOfDay();
    }

    public int getDefaultPivotYear() {
        return this.merger.getDefaultPivotYear();
    }

    public List<ChronoExtension> getExtensions() {
        return this.extensions;
    }

    public CalendarSystem<T> getCalendarSystem() {
        throw new ChronoException("Calendar system is not available.");
    }

    public CalendarSystem<T> getCalendarSystem(String str) {
        throw new ChronoException("Calendar variant is not available: " + str);
    }

    public final CalendarSystem<T> getCalendarSystem(VariantSource variantSource) {
        return getCalendarSystem(variantSource.getVariant());
    }

    public static <T> Chronology<T> lookup(Class<T> cls) {
        try {
            Class.forName(cls.getName(), true, cls.getClassLoader());
            Chronology chronology = null;
            boolean z = false;
            Iterator<ChronoReference> it = CHRONOS.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Chronology chronology2 = (Chronology) it.next().get();
                if (chronology2 == null) {
                    z = true;
                } else if (chronology2.getChronoType() == cls) {
                    chronology = chronology2;
                    break;
                }
            }
            if (z) {
                purgeQueue();
            }
            return (Chronology) cast(chronology);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    static void register(Chronology<?> chronology) {
        CHRONOS.add(new ChronoReference(chronology, QUEUE));
    }

    /* access modifiers changed from: package-private */
    public <V> ElementRule<T, V> getRule(ChronoElement<V> chronoElement) {
        Objects.requireNonNull(chronoElement, "Missing chronological element.");
        ElementRule<T, ?> elementRule = (ElementRule) this.ruleMap.get(chronoElement);
        if (elementRule != null || (elementRule = getDerivedRule(chronoElement, true)) != null) {
            return (ElementRule) cast(elementRule);
        }
        throw new RuleNotFoundException((Chronology<?>) this, (ChronoElement<?>) chronoElement);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [net.time4j.engine.ChronoElement<java.lang.Integer>, java.lang.Object] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.time4j.engine.IntElementRule<T> getIntegerRule(net.time4j.engine.ChronoElement<java.lang.Integer> r2) {
        /*
            r1 = this;
            java.util.Map<net.time4j.engine.ChronoElement<?>, net.time4j.engine.IntElementRule<T>> r0 = r1.intRules
            java.lang.Object r2 = r0.get(r2)
            net.time4j.engine.IntElementRule r2 = (net.time4j.engine.IntElementRule) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.engine.Chronology.getIntegerRule(net.time4j.engine.ChronoElement):net.time4j.engine.IntElementRule");
    }

    private ElementRule<T, ?> getDerivedRule(ChronoElement<?> chronoElement, boolean z) {
        String str = null;
        if (!(chronoElement instanceof BasicElement) || !ChronoEntity.class.isAssignableFrom(getChronoType())) {
            return null;
        }
        BasicElement cast = BasicElement.class.cast(chronoElement);
        if (z) {
            str = cast.getVeto(this);
        }
        if (str == null) {
            return (ElementRule) cast(cast.derive((Chronology) cast(this)));
        }
        throw new RuleNotFoundException(str);
    }

    private static void purgeQueue() {
        while (true) {
            ChronoReference chronoReference = (ChronoReference) QUEUE.poll();
            if (chronoReference != null) {
                Iterator<ChronoReference> it = CHRONOS.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ChronoReference next = it.next();
                    if (next.name.equals(chronoReference.name)) {
                        CHRONOS.remove(next);
                        break;
                    }
                }
            } else {
                return;
            }
        }
    }

    public static class Builder<T extends ChronoEntity<T>> {
        final Class<T> chronoType;
        final List<ChronoExtension> extensions = new ArrayList();
        final ChronoMerger<T> merger;
        final Map<ChronoElement<?>, ElementRule<T, ?>> ruleMap = new HashMap();
        final boolean time4j;

        Builder(Class<T> cls, ChronoMerger<T> chronoMerger) {
            Objects.requireNonNull(chronoMerger, "Missing chronological merger.");
            this.chronoType = cls;
            this.time4j = cls.getName().startsWith("net.time4j.");
            this.merger = chronoMerger;
        }

        public static <T extends ChronoEntity<T>> Builder<T> setUp(Class<T> cls, ChronoMerger<T> chronoMerger) {
            if (!TimePoint.class.isAssignableFrom(cls)) {
                return new Builder<>(cls, chronoMerger);
            }
            throw new UnsupportedOperationException("This builder cannot construct a chronology with a time axis, use TimeAxis.Builder instead.");
        }

        public <V> Builder<T> appendElement(ChronoElement<V> chronoElement, ElementRule<T, V> elementRule) {
            checkElementDuplicates(chronoElement);
            this.ruleMap.put(chronoElement, elementRule);
            return this;
        }

        public Builder<T> appendExtension(ChronoExtension chronoExtension) {
            Objects.requireNonNull(chronoExtension, "Missing chronological extension.");
            if (!this.extensions.contains(chronoExtension)) {
                this.extensions.add(chronoExtension);
            }
            return this;
        }

        public Chronology<T> build() {
            Chronology<T> chronology = new Chronology<>(this.chronoType, this.merger, this.ruleMap, this.extensions);
            Chronology.register(chronology);
            return chronology;
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x001e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void checkElementDuplicates(net.time4j.engine.ChronoElement<?> r5) {
            /*
                r4 = this;
                boolean r0 = r4.time4j
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                java.lang.String r0 = "Static initialization problem: Check if given element statically refer to any chronology causing premature class loading."
                java.util.Objects.requireNonNull(r5, r0)
                java.lang.String r0 = r5.name()
                java.util.Map<net.time4j.engine.ChronoElement<?>, net.time4j.engine.ElementRule<T, ?>> r1 = r4.ruleMap
                java.util.Set r1 = r1.keySet()
                java.util.Iterator r1 = r1.iterator()
            L_0x0018:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x004c
                java.lang.Object r2 = r1.next()
                net.time4j.engine.ChronoElement r2 = (net.time4j.engine.ChronoElement) r2
                boolean r3 = r2.equals(r5)
                if (r3 != 0) goto L_0x0035
                java.lang.String r2 = r2.name()
                boolean r2 = r2.equals(r0)
                if (r2 != 0) goto L_0x0035
                goto L_0x0018
            L_0x0035:
                java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Element duplicate found: "
                r1.append(r2)
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                r5.<init>(r0)
                throw r5
            L_0x004c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.time4j.engine.Chronology.Builder.checkElementDuplicates(net.time4j.engine.ChronoElement):void");
        }
    }

    private static class ChronoReference extends WeakReference<Chronology<?>> {
        /* access modifiers changed from: private */
        public final String name;

        ChronoReference(Chronology<?> chronology, ReferenceQueue<Chronology<?>> referenceQueue) {
            super(chronology, referenceQueue);
            this.name = chronology.chronoType.getName();
        }
    }
}
