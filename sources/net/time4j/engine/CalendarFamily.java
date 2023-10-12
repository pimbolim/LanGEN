package net.time4j.engine;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import net.time4j.engine.CalendarVariant;
import net.time4j.engine.Chronology;

public final class CalendarFamily<T extends CalendarVariant<T>> extends Chronology<T> {
    private final Map<String, ? extends CalendarSystem<T>> calendars;

    public boolean hasCalendarSystem() {
        return true;
    }

    private CalendarFamily(Class<T> cls, ChronoMerger<T> chronoMerger, Map<ChronoElement<?>, ElementRule<T, ?>> map, List<ChronoExtension> list, Map<String, ? extends CalendarSystem<T>> map2) {
        super(cls, chronoMerger, map, list);
        this.calendars = map2;
    }

    public CalendarSystem<T> getCalendarSystem() {
        throw new ChronoException("Cannot determine calendar system without variant.");
    }

    public CalendarSystem<T> getCalendarSystem(String str) {
        if (str.isEmpty()) {
            return getCalendarSystem();
        }
        CalendarSystem<T> calendarSystem = (CalendarSystem) this.calendars.get(str);
        return calendarSystem == null ? super.getCalendarSystem(str) : calendarSystem;
    }

    public TimeLine<T> getTimeLine(String str) {
        return new CalendarTimeLine(this, str);
    }

    public TimeLine<T> getTimeLine(VariantSource variantSource) {
        return getTimeLine(variantSource.getVariant());
    }

    public boolean isSupported(ChronoElement<?> chronoElement) {
        return super.isSupported(chronoElement) || (chronoElement instanceof EpochDays);
    }

    public static final class Builder<T extends CalendarVariant<T>> extends Chronology.Builder<T> {
        private final Map<String, ? extends CalendarSystem<T>> calendars;

        private Builder(Class<T> cls, ChronoMerger<T> chronoMerger, Map<String, ? extends CalendarSystem<T>> map) {
            super(cls, chronoMerger);
            if (!map.isEmpty()) {
                this.calendars = map;
                return;
            }
            throw new IllegalArgumentException("Missing calendar variants.");
        }

        public static <T extends CalendarVariant<T>> Builder<T> setUp(Class<T> cls, ChronoMerger<T> chronoMerger, Map<String, ? extends CalendarSystem<T>> map) {
            return new Builder<>(cls, chronoMerger, map);
        }

        public <V> Builder<T> appendElement(ChronoElement<V> chronoElement, ElementRule<T, V> elementRule) {
            super.appendElement(chronoElement, elementRule);
            return this;
        }

        public Builder<T> appendExtension(ChronoExtension chronoExtension) {
            super.appendExtension(chronoExtension);
            return this;
        }

        public CalendarFamily<T> build() {
            CalendarFamily calendarFamily = new CalendarFamily(this.chronoType, this.merger, this.ruleMap, this.extensions, this.calendars);
            Chronology.register(calendarFamily);
            return calendarFamily;
        }
    }

    private static class CalendarTimeLine<D extends CalendarVariant<D>> implements TimeLine<D>, Serializable {
        private final transient CalendarSystem<D> calsys;
        private final Class<D> chronoType;
        private final String variant;

        public boolean isCalendrical() {
            return true;
        }

        private CalendarTimeLine(Chronology<D> chronology, String str) {
            this.calsys = chronology.getCalendarSystem(str);
            this.chronoType = chronology.getChronoType();
            this.variant = str;
        }

        public D stepForward(D d) {
            if (d.getDaysSinceEpochUTC() == this.calsys.getMaximumSinceUTC()) {
                return null;
            }
            return d.plus(CalendarDays.ONE);
        }

        public D stepBackwards(D d) {
            if (d.getDaysSinceEpochUTC() == this.calsys.getMinimumSinceUTC()) {
                return null;
            }
            return d.minus(CalendarDays.ONE);
        }

        public int compare(D d, D d2) {
            int i = (d.getDaysSinceEpochUTC() > d2.getDaysSinceEpochUTC() ? 1 : (d.getDaysSinceEpochUTC() == d2.getDaysSinceEpochUTC() ? 0 : -1));
            if (i < 0) {
                return -1;
            }
            return i > 0 ? 1 : 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CalendarTimeLine)) {
                return false;
            }
            CalendarTimeLine calendarTimeLine = (CalendarTimeLine) obj;
            if (this.chronoType != calendarTimeLine.chronoType || !this.variant.equals(calendarTimeLine.variant)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.chronoType.hashCode() + (this.variant.hashCode() * 31);
        }

        private Object readResolve() throws ObjectStreamException {
            return new CalendarTimeLine(Chronology.lookup(this.chronoType), this.variant);
        }
    }
}
