package net.time4j.format;

import java.util.Objects;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoException;
import net.time4j.tz.TZID;

public class RawValues {
    private ChronoDisplay rawValues = new EmptyRawValues();

    public void accept(ChronoDisplay chronoDisplay) {
        Objects.requireNonNull(chronoDisplay, "Missing raw values.");
        this.rawValues = chronoDisplay;
    }

    public ChronoDisplay get() {
        return this.rawValues;
    }

    private static class EmptyRawValues implements ChronoDisplay {
        public boolean contains(ChronoElement<?> chronoElement) {
            return false;
        }

        public int getInt(ChronoElement<Integer> chronoElement) {
            return Integer.MIN_VALUE;
        }

        public boolean hasTimezone() {
            return false;
        }

        public String toString() {
            return "raw-values={}";
        }

        private EmptyRawValues() {
        }

        public <V> V get(ChronoElement<V> chronoElement) {
            throw new ChronoException("Not supported:" + chronoElement.name());
        }

        public <V> V getMinimum(ChronoElement<V> chronoElement) {
            throw new ChronoException("Not supported:" + chronoElement.name());
        }

        public <V> V getMaximum(ChronoElement<V> chronoElement) {
            throw new ChronoException("Not supported:" + chronoElement.name());
        }

        public TZID getTimezone() {
            throw new ChronoException("Timezone does not exist.");
        }
    }
}
