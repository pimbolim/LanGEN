package net.time4j.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import net.time4j.engine.Chronology;
import net.time4j.engine.TimePoint;

public final class TimeAxis<U, T extends TimePoint<U, T>> extends Chronology<T> implements TimeLine<T> {
    private final Map<ChronoElement<?>, U> baseUnits;
    private final CalendarSystem<T> calendarSystem;
    private final Map<U, Set<U>> convertibleUnits;
    private final T max;
    private final T min;
    private final ChronoElement<T> self;
    private final TimeLine<T> timeline;
    private final Map<U, Double> unitLengths;
    private final Map<U, UnitRule<T>> unitRules;
    private final Class<U> unitType;

    private TimeAxis(Class<T> cls, Class<U> cls2, ChronoMerger<T> chronoMerger, Map<ChronoElement<?>, ElementRule<T, ?>> map, Map<U, UnitRule<T>> map2, final Map<U, Double> map3, Map<U, Set<U>> map4, List<ChronoExtension> list, Map<ChronoElement<?>, U> map5, T t, T t2, CalendarSystem<T> calendarSystem2, TimeLine<T> timeLine) {
        super(cls, chronoMerger, map, list);
        this.unitType = cls2;
        this.unitRules = Collections.unmodifiableMap(map2);
        this.unitLengths = Collections.unmodifiableMap(map3);
        this.convertibleUnits = Collections.unmodifiableMap(map4);
        this.baseUnits = Collections.unmodifiableMap(map5);
        this.min = t;
        this.max = t2;
        this.calendarSystem = calendarSystem2;
        this.self = new SelfElement(cls, t, t2);
        if (timeLine == null) {
            ArrayList arrayList = new ArrayList(map2.keySet());
            Collections.sort(arrayList, new Comparator<U>() {
                public int compare(U u, U u2) {
                    return Double.compare(TimeAxis.getLength(map3, u), TimeAxis.getLength(map3, u2));
                }
            });
            this.timeline = new DefaultTimeLine(arrayList.get(0), t, t2);
            return;
        }
        this.timeline = timeLine;
    }

    public Class<U> getUnitType() {
        return this.unitType;
    }

    public Set<U> getRegisteredUnits() {
        return this.unitRules.keySet();
    }

    public boolean isRegistered(U u) {
        return this.unitRules.containsKey(u);
    }

    public boolean isSupported(U u) {
        if (isRegistered(u)) {
            return true;
        }
        if (!(u instanceof BasicUnit) || BasicUnit.class.cast(u).derive(this) == null) {
            return false;
        }
        return true;
    }

    public double getLength(U u) {
        return getLength(this.unitLengths, u);
    }

    public boolean isConvertible(U u, U u2) {
        Set set = this.convertibleUnits.get(u);
        return set != null && set.contains(u2);
    }

    public Comparator<? super U> unitComparator() {
        return new Comparator<U>() {
            public int compare(U u, U u2) {
                return Double.compare(TimeAxis.this.getLength(u2), TimeAxis.this.getLength(u));
            }
        };
    }

    public int compare(T t, T t2) {
        return t.compareTo(t2);
    }

    public boolean hasBaseUnit(ChronoElement<?> chronoElement) {
        boolean z = false;
        if (chronoElement == null) {
            return false;
        }
        boolean containsKey = this.baseUnits.containsKey(chronoElement);
        if (containsKey || !(chronoElement instanceof BasicElement)) {
            return containsKey;
        }
        ChronoElement<?> parent = ((BasicElement) chronoElement).getParent();
        if (parent != null && this.baseUnits.containsKey(parent)) {
            z = true;
        }
        return z;
    }

    public U getBaseUnit(ChronoElement<?> chronoElement) {
        Objects.requireNonNull(chronoElement, "Missing element.");
        U u = this.baseUnits.get(chronoElement);
        if (u == null && (chronoElement instanceof BasicElement)) {
            u = this.baseUnits.get(((BasicElement) chronoElement).getParent());
        }
        if (u != null) {
            return u;
        }
        throw new ChronoException("Base unit not found for: " + chronoElement.name());
    }

    public T getMinimum() {
        return this.min;
    }

    public T getMaximum() {
        return this.max;
    }

    public boolean isCalendrical() {
        return this.calendarSystem != null;
    }

    public boolean hasCalendarSystem() {
        return this.calendarSystem != null;
    }

    public CalendarSystem<T> getCalendarSystem() {
        CalendarSystem<T> calendarSystem2 = this.calendarSystem;
        return calendarSystem2 == null ? super.getCalendarSystem() : calendarSystem2;
    }

    public CalendarSystem<T> getCalendarSystem(String str) {
        if (str.isEmpty()) {
            return getCalendarSystem();
        }
        return super.getCalendarSystem(str);
    }

    public T createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
        if (chronoEntity.contains(this.self)) {
            return (TimePoint) chronoEntity.get((ChronoElement<V>) this.self);
        }
        return (TimePoint) super.createFrom(chronoEntity, attributeQuery, z, z2);
    }

    public ChronoElement<T> element() {
        return this.self;
    }

    public T stepForward(T t) {
        return (TimePoint) this.timeline.stepForward(t);
    }

    public T stepBackwards(T t) {
        return (TimePoint) this.timeline.stepBackwards(t);
    }

    /* access modifiers changed from: package-private */
    public UnitRule<T> getRule(U u) {
        UnitRule<T> derive;
        Objects.requireNonNull(u, "Missing chronological unit.");
        if (isRegistered(u)) {
            return this.unitRules.get(u);
        }
        if ((u instanceof BasicUnit) && (derive = BasicUnit.class.cast(u).derive(this)) != null) {
            return derive;
        }
        throw new RuleNotFoundException((Chronology<?>) this, (Object) u);
    }

    /* access modifiers changed from: private */
    public static <U> double getLength(Map<U, Double> map, U u) {
        Double d = map.get(u);
        if (d != null) {
            return d.doubleValue();
        }
        if (u instanceof ChronoUnit) {
            return ChronoUnit.class.cast(u).getLength();
        }
        return Double.NaN;
    }

    public static final class Builder<U, T extends TimePoint<U, T>> extends Chronology.Builder<T> {
        private final Map<ChronoElement<?>, U> baseUnits;
        private final CalendarSystem<T> calendarSystem;
        private final Map<U, Set<U>> convertibleUnits;
        private final T max;
        private final T min;
        private TimeLine<T> timeline = null;
        private final Map<U, Double> unitLengths;
        private final Map<U, UnitRule<T>> unitRules;
        private final Class<U> unitType;

        private Builder(Class<U> cls, Class<T> cls2, ChronoMerger<T> chronoMerger, T t, T t2, CalendarSystem<T> calendarSystem2, TimeLine<T> timeLine) {
            super(cls2, chronoMerger);
            Objects.requireNonNull(cls, "Missing unit type.");
            Objects.requireNonNull(t, "Missing minimum of range.");
            Objects.requireNonNull(t2, "Missing maximum of range.");
            if (Calendrical.class.isAssignableFrom(cls2)) {
                Objects.requireNonNull(calendarSystem2, "Missing calendar system.");
            }
            this.unitType = cls;
            this.unitRules = new HashMap();
            this.unitLengths = new HashMap();
            this.convertibleUnits = new HashMap();
            this.baseUnits = new HashMap();
            this.min = t;
            this.max = t2;
            this.calendarSystem = calendarSystem2;
            this.timeline = timeLine;
        }

        public static <U, T extends TimePoint<U, T>> Builder<U, T> setUp(Class<U> cls, Class<T> cls2, ChronoMerger<T> chronoMerger, T t, T t2) {
            return new Builder(cls, cls2, chronoMerger, t, t2, (CalendarSystem) null, (TimeLine) null);
        }

        public static <U, D extends Calendrical<U, D>> Builder<U, D> setUp(Class<U> cls, Class<D> cls2, ChronoMerger<D> chronoMerger, CalendarSystem<D> calendarSystem2) {
            Builder builder = new Builder(cls, cls2, chronoMerger, (TimePoint) calendarSystem2.transform(calendarSystem2.getMinimumSinceUTC()), (TimePoint) calendarSystem2.transform(calendarSystem2.getMaximumSinceUTC()), calendarSystem2, (TimeLine) null);
            for (EpochDays epochDays : EpochDays.values()) {
                builder.appendElement((ChronoElement) epochDays, (ElementRule) epochDays.derive(calendarSystem2));
            }
            return builder;
        }

        public <V> Builder<U, T> appendElement(ChronoElement<V> chronoElement, ElementRule<T, V> elementRule) {
            super.appendElement(chronoElement, elementRule);
            return this;
        }

        public <V> Builder<U, T> appendElement(ChronoElement<V> chronoElement, ElementRule<T, V> elementRule, U u) {
            Objects.requireNonNull(u, "Missing base unit.");
            super.appendElement(chronoElement, elementRule);
            this.baseUnits.put(chronoElement, u);
            return this;
        }

        public Builder<U, T> appendUnit(U u, UnitRule<T> unitRule, double d) {
            return appendUnit(u, unitRule, d, Collections.emptySet());
        }

        public Builder<U, T> appendUnit(U u, UnitRule<T> unitRule, double d, Set<? extends U> set) {
            Objects.requireNonNull(u, "Missing time unit.");
            Objects.requireNonNull(unitRule, "Missing unit rule.");
            checkUnitDuplicates(u);
            for (Object requireNonNull : set) {
                Objects.requireNonNull(requireNonNull, "Found convertible unit which is null.");
            }
            if (Double.isNaN(d)) {
                throw new IllegalArgumentException("Not a number: " + d);
            } else if (!Double.isInfinite(d)) {
                this.unitRules.put(u, unitRule);
                this.unitLengths.put(u, Double.valueOf(d));
                HashSet hashSet = new HashSet(set);
                hashSet.remove(u);
                this.convertibleUnits.put(u, hashSet);
                return this;
            } else {
                throw new IllegalArgumentException("Infinite: " + d);
            }
        }

        public Builder<U, T> appendExtension(ChronoExtension chronoExtension) {
            super.appendExtension(chronoExtension);
            return this;
        }

        public Builder<U, T> withTimeLine(TimeLine<T> timeLine) {
            Objects.requireNonNull(timeLine, "Missing time line.");
            this.timeline = timeLine;
            return this;
        }

        public TimeAxis<U, T> build() {
            if (!this.unitRules.isEmpty()) {
                TimeAxis timeAxis = new TimeAxis(this.chronoType, this.unitType, this.merger, this.ruleMap, this.unitRules, this.unitLengths, this.convertibleUnits, this.extensions, this.baseUnits, this.min, this.max, this.calendarSystem, this.timeline);
                Chronology.register(timeAxis);
                return timeAxis;
            }
            throw new IllegalStateException("No time unit was registered.");
        }

        private void checkUnitDuplicates(U u) {
            if (!this.time4j) {
                for (U equals : this.unitRules.keySet()) {
                    if (equals.equals(u)) {
                        throw new IllegalArgumentException("Unit duplicate found: " + u.toString());
                    }
                }
                if (u instanceof Enum) {
                    String name = Enum.class.cast(u).name();
                    for (U next : this.unitRules.keySet()) {
                        if ((next instanceof Enum) && Enum.class.cast(next).name().equals(name)) {
                            throw new IllegalArgumentException("Unit duplicate found: " + name);
                        }
                    }
                }
            }
        }
    }

    private static class SelfElement<T extends TimePoint<?, T>> extends BasicElement<T> implements ElementRule<T, T> {
        private static final long serialVersionUID = 4777240530511579802L;
        private final T max;
        private final T min;
        private final Class<T> type;

        public T getValue(T t) {
            return t;
        }

        /* access modifiers changed from: protected */
        public String getVeto(Chronology<?> chronology) {
            return null;
        }

        public boolean isDateElement() {
            return false;
        }

        /* access modifiers changed from: protected */
        public boolean isSingleton() {
            return true;
        }

        public boolean isTimeElement() {
            return false;
        }

        public boolean isValid(T t, T t2) {
            return t2 != null;
        }

        private SelfElement(Class<T> cls, T t, T t2) {
            super(cls.getName() + "-AXIS");
            this.type = cls;
            this.min = t;
            this.max = t2;
        }

        public Class<T> getType() {
            return this.type;
        }

        public T getDefaultMinimum() {
            return this.min;
        }

        public T getDefaultMaximum() {
            return this.max;
        }

        public T getMinimum(T t) {
            return getDefaultMinimum();
        }

        public T getMaximum(T t) {
            return getDefaultMaximum();
        }

        public T withValue(T t, T t2, boolean z) {
            if (t2 != null) {
                return t2;
            }
            throw new IllegalArgumentException("Missing value.");
        }

        public ChronoElement<?> getChildAtFloor(T t) {
            throw new UnsupportedOperationException();
        }

        public ChronoElement<?> getChildAtCeiling(T t) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        public <X extends ChronoEntity<X>> ElementRule<X, T> derive(Chronology<X> chronology) {
            if (chronology.getChronoType().equals(this.type)) {
                return this;
            }
            return null;
        }
    }

    private static class DefaultTimeLine<U, T extends TimePoint<U, T>> implements TimeLine<T> {
        private final T max;
        private final T min;
        private final U step;

        DefaultTimeLine(U u, T t, T t2) {
            this.step = u;
            this.min = t;
            this.max = t2;
        }

        public T stepForward(T t) {
            if (t.compareTo(this.max) >= 0) {
                return null;
            }
            return t.plus(1, this.step);
        }

        public T stepBackwards(T t) {
            if (t.compareTo(this.min) <= 0) {
                return null;
            }
            return t.minus(1, this.step);
        }

        public boolean isCalendrical() {
            return this.max instanceof CalendarDate;
        }

        public int compare(T t, T t2) {
            return t.compareTo(t2);
        }
    }
}
