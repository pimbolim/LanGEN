package net.time4j.history;

import java.io.ObjectStreamException;
import net.time4j.PlainDate;
import net.time4j.engine.BasicElement;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoException;
import net.time4j.engine.Chronology;
import net.time4j.engine.ElementRule;

final class HistoricDateElement extends BasicElement<HistoricDate> {
    private static final long serialVersionUID = -5386613740709845550L;
    private final ChronoHistory history;

    public boolean isDateElement() {
        return true;
    }

    public boolean isTimeElement() {
        return false;
    }

    HistoricDateElement(ChronoHistory chronoHistory) {
        super("HISTORIC_DATE");
        this.history = chronoHistory;
    }

    public Class<HistoricDate> getType() {
        return HistoricDate.class;
    }

    public HistoricDate getDefaultMinimum() {
        return HistoricDate.of(HistoricEra.BC, 45, 1, 1);
    }

    public HistoricDate getDefaultMaximum() {
        return HistoricDate.of(HistoricEra.AD, 9999, 12, 31);
    }

    /* access modifiers changed from: protected */
    public <T extends ChronoEntity<T>> ElementRule<T, HistoricDate> derive(Chronology<T> chronology) {
        if (chronology.isRegistered(PlainDate.COMPONENT)) {
            return new Rule(this.history);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean doEquals(BasicElement<?> basicElement) {
        return this.history.equals(((HistoricDateElement) basicElement).history);
    }

    private Object readResolve() throws ObjectStreamException {
        return this.history.date();
    }

    private static class Rule<C extends ChronoEntity<C>> implements ElementRule<C, HistoricDate> {
        private final ChronoHistory history;

        Rule(ChronoHistory chronoHistory) {
            this.history = chronoHistory;
        }

        public HistoricDate getValue(C c) {
            try {
                return this.history.convert((PlainDate) c.get(PlainDate.COMPONENT));
            } catch (IllegalArgumentException e) {
                throw new ChronoException(e.getMessage(), e);
            }
        }

        public HistoricDate getMinimum(C c) {
            if (this.history == ChronoHistory.PROLEPTIC_BYZANTINE) {
                return HistoricDate.of(HistoricEra.BYZANTINE, 0, 9, 1);
            }
            if (this.history == ChronoHistory.PROLEPTIC_JULIAN) {
                return HistoricDate.of(HistoricEra.BC, 999979466, 1, 1);
            }
            if (this.history == ChronoHistory.PROLEPTIC_GREGORIAN) {
                return HistoricDate.of(HistoricEra.BC, 1000000000, 1, 1);
            }
            return HistoricDate.of(HistoricEra.BC, 45, 1, 1);
        }

        public HistoricDate getMaximum(C c) {
            if (this.history == ChronoHistory.PROLEPTIC_BYZANTINE) {
                return HistoricDate.of(HistoricEra.BYZANTINE, 999984973, 8, 31);
            }
            if (this.history == ChronoHistory.PROLEPTIC_JULIAN) {
                return HistoricDate.of(HistoricEra.AD, 999979465, 12, 31);
            }
            if (this.history == ChronoHistory.PROLEPTIC_GREGORIAN) {
                return HistoricDate.of(HistoricEra.AD, 999999999, 12, 31);
            }
            return HistoricDate.of(HistoricEra.AD, 9999, 12, 31);
        }

        public boolean isValid(C c, HistoricDate historicDate) {
            return this.history.isValid(historicDate);
        }

        public C withValue(C c, HistoricDate historicDate, boolean z) {
            if (historicDate != null) {
                return c.with(PlainDate.COMPONENT, this.history.convert(historicDate));
            }
            throw new IllegalArgumentException("Missing historic date.");
        }

        public ChronoElement<?> getChildAtFloor(C c) {
            throw new UnsupportedOperationException("Never called.");
        }

        public ChronoElement<?> getChildAtCeiling(C c) {
            throw new UnsupportedOperationException("Never called.");
        }
    }
}
