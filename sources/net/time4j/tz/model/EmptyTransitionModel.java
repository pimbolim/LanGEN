package net.time4j.tz.model;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import net.time4j.base.GregorianDate;
import net.time4j.base.UnixTime;
import net.time4j.base.WallTime;
import net.time4j.tz.TransitionHistory;
import net.time4j.tz.ZonalOffset;
import net.time4j.tz.ZonalTransition;

final class EmptyTransitionModel implements TransitionHistory, Serializable {
    private static final long serialVersionUID = 1374714021808040253L;
    private final ZonalOffset offset;

    public ZonalTransition getConflictTransition(GregorianDate gregorianDate, WallTime wallTime) {
        return null;
    }

    public ZonalTransition getNextTransition(UnixTime unixTime) {
        return null;
    }

    public ZonalTransition getStartTransition(UnixTime unixTime) {
        return null;
    }

    public boolean hasNegativeDST() {
        return false;
    }

    public boolean isEmpty() {
        return true;
    }

    EmptyTransitionModel(ZonalOffset zonalOffset) {
        this.offset = zonalOffset;
    }

    public ZonalOffset getInitialOffset() {
        return this.offset;
    }

    public List<ZonalOffset> getValidOffsets(GregorianDate gregorianDate, WallTime wallTime) {
        return Collections.singletonList(this.offset);
    }

    public List<ZonalTransition> getStdTransitions() {
        return Collections.emptyList();
    }

    public List<ZonalTransition> getTransitions(UnixTime unixTime, UnixTime unixTime2) {
        return Collections.emptyList();
    }

    public void dump(Appendable appendable) throws IOException {
        appendable.append("*** Fixed offset:").append(TransitionModel.NEW_LINE).append(">>> ");
        appendable.append(getInitialOffset().canonical()).append(TransitionModel.NEW_LINE);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EmptyTransitionModel) {
            return this.offset.equals(((EmptyTransitionModel) obj).offset);
        }
        return false;
    }

    public int hashCode() {
        return this.offset.hashCode();
    }

    public String toString() {
        return "EmptyTransitionModel=" + this.offset.canonical();
    }
}
