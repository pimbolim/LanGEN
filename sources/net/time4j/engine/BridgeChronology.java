package net.time4j.engine;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import net.time4j.base.TimeSource;
import net.time4j.engine.ChronoEntity;

public final class BridgeChronology<S, T extends ChronoEntity<T>> extends Chronology<S> {
    private final Converter<S, T> converter;
    private final Chronology<T> delegate;

    public boolean isSupported(ChronoElement<?> chronoElement) {
        return false;
    }

    public BridgeChronology(Converter<S, T> converter2, Chronology<T> chronology) {
        super(converter2.getSourceType());
        if (ChronoEntity.class.isAssignableFrom(chronology.getChronoType())) {
            this.converter = converter2;
            this.delegate = chronology;
            return;
        }
        throw new IllegalArgumentException("Target chronology not compatible with ChronoEntity.");
    }

    public S createFrom(TimeSource<?> timeSource, AttributeQuery attributeQuery) {
        ChronoEntity chronoEntity = (ChronoEntity) this.delegate.createFrom(timeSource, attributeQuery);
        if (chronoEntity == null) {
            return null;
        }
        return this.converter.from(chronoEntity);
    }

    public S createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2) {
        ChronoEntity chronoEntity2;
        if (this.delegate.getChronoType().isInstance(chronoEntity)) {
            chronoEntity2 = (ChronoEntity) this.delegate.getChronoType().cast(chronoEntity);
        } else {
            chronoEntity2 = (ChronoEntity) this.delegate.createFrom(chronoEntity, attributeQuery, z, z2);
        }
        if (chronoEntity2 == null) {
            return null;
        }
        return this.converter.from(chronoEntity2);
    }

    public ChronoDisplay preformat(S s, AttributeQuery attributeQuery) {
        return this.delegate.preformat((ChronoEntity) this.converter.translate(s), attributeQuery);
    }

    public Chronology<?> preparser() {
        return this.delegate;
    }

    public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
        throw new UnsupportedOperationException("Localized format patterns are not available for foreign types.");
    }

    public StartOfDay getDefaultStartOfDay() {
        return this.delegate.getDefaultStartOfDay();
    }

    public int getDefaultPivotYear() {
        return this.delegate.getDefaultPivotYear();
    }

    public boolean hasCalendarSystem() {
        return this.delegate.hasCalendarSystem();
    }

    public CalendarSystem<S> getCalendarSystem() {
        return new CalendarSystemProxy(this.converter, this.delegate.getCalendarSystem());
    }

    public CalendarSystem<S> getCalendarSystem(String str) {
        return new CalendarSystemProxy(this.converter, this.delegate.getCalendarSystem(str));
    }

    public Set<ChronoElement<?>> getRegisteredElements() {
        return Collections.emptySet();
    }

    public List<ChronoExtension> getExtensions() {
        return Collections.emptyList();
    }

    private static class CalendarSystemProxy<S, T> implements CalendarSystem<S> {
        private final CalendarSystem<T> calsys;
        private final Converter<S, T> converter;

        CalendarSystemProxy(Converter<S, T> converter2, CalendarSystem<T> calendarSystem) {
            this.converter = converter2;
            this.calsys = calendarSystem;
        }

        public S transform(long j) {
            return this.converter.from(this.calsys.transform(j));
        }

        public long transform(S s) {
            return this.calsys.transform(this.converter.translate(s));
        }

        public long getMinimumSinceUTC() {
            return this.calsys.getMinimumSinceUTC();
        }

        public long getMaximumSinceUTC() {
            return this.calsys.getMaximumSinceUTC();
        }

        public List<CalendarEra> getEras() {
            return this.calsys.getEras();
        }
    }
}
