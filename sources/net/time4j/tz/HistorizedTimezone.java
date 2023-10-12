package net.time4j.tz;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.base.GregorianDate;
import net.time4j.base.UnixTime;
import net.time4j.base.WallTime;

final class HistorizedTimezone extends Timezone {
    private static final long serialVersionUID = 1738909257417361021L;
    private final transient TransitionHistory history;
    private final transient TZID id;
    private final transient TransitionStrategy strategy;

    HistorizedTimezone(TZID tzid, TransitionHistory transitionHistory) {
        this(tzid, transitionHistory, Timezone.DEFAULT_CONFLICT_STRATEGY);
    }

    HistorizedTimezone(TZID tzid, TransitionHistory transitionHistory, TransitionStrategy transitionStrategy) {
        Objects.requireNonNull(tzid, "Missing timezone id.");
        if (!(tzid instanceof ZonalOffset) || transitionHistory.isEmpty()) {
            Objects.requireNonNull(transitionHistory, "Missing timezone history.");
            Objects.requireNonNull(transitionStrategy, "Missing transition strategy.");
            this.id = tzid;
            this.history = transitionHistory;
            this.strategy = transitionStrategy;
            return;
        }
        throw new IllegalArgumentException("Fixed zonal offset can't be combined with offset transitions: " + tzid.canonical());
    }

    public TZID getID() {
        return this.id;
    }

    public ZonalOffset getOffset(UnixTime unixTime) {
        ZonalTransition startTransition = this.history.getStartTransition(unixTime);
        if (startTransition == null) {
            return this.history.getInitialOffset();
        }
        return ZonalOffset.ofTotalSeconds(startTransition.getTotalOffset());
    }

    public ZonalOffset getStandardOffset(UnixTime unixTime) {
        ZonalTransition startTransition = this.history.getStartTransition(unixTime);
        if (startTransition == null) {
            return this.history.getInitialOffset();
        }
        return ZonalOffset.ofTotalSeconds(startTransition.getStandardOffset());
    }

    public ZonalOffset getDaylightSavingOffset(UnixTime unixTime) {
        ZonalTransition startTransition = this.history.getStartTransition(unixTime);
        if (startTransition == null) {
            return ZonalOffset.UTC;
        }
        return ZonalOffset.ofTotalSeconds(startTransition.getDaylightSavingOffset());
    }

    public ZonalOffset getOffset(GregorianDate gregorianDate, WallTime wallTime) {
        List<ZonalOffset> validOffsets = this.history.getValidOffsets(gregorianDate, wallTime);
        if (validOffsets.size() == 1) {
            return validOffsets.get(0);
        }
        return ZonalOffset.ofTotalSeconds(this.history.getConflictTransition(gregorianDate, wallTime).getTotalOffset());
    }

    public boolean isInvalid(GregorianDate gregorianDate, WallTime wallTime) {
        ZonalTransition conflictTransition = this.history.getConflictTransition(gregorianDate, wallTime);
        return conflictTransition != null && conflictTransition.isGap();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        r1 = net.time4j.tz.SimpleUT.previousTime(r6.getPosixTime(), 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isDaylightSaving(net.time4j.base.UnixTime r6) {
        /*
            r5 = this;
            net.time4j.tz.TransitionHistory r0 = r5.history
            net.time4j.tz.ZonalTransition r6 = r0.getStartTransition(r6)
            r0 = 0
            if (r6 != 0) goto L_0x000a
            return r0
        L_0x000a:
            int r1 = r6.getDaylightSavingOffset()
            r2 = 1
            if (r1 <= 0) goto L_0x0012
            return r2
        L_0x0012:
            if (r1 >= 0) goto L_0x0015
            return r0
        L_0x0015:
            net.time4j.tz.TransitionHistory r1 = r5.history
            boolean r1 = r1.hasNegativeDST()
            if (r1 != 0) goto L_0x001e
            return r0
        L_0x001e:
            long r3 = r6.getPosixTime()
            net.time4j.base.UnixTime r1 = net.time4j.tz.SimpleUT.previousTime(r3, r0)
            net.time4j.tz.TransitionHistory r3 = r5.history
            net.time4j.tz.ZonalTransition r3 = r3.getStartTransition(r1)
            if (r3 != 0) goto L_0x002f
            return r0
        L_0x002f:
            int r4 = r3.getStandardOffset()
            int r6 = r6.getStandardOffset()
            if (r4 != r6) goto L_0x0041
            int r6 = r3.getDaylightSavingOffset()
            if (r6 >= 0) goto L_0x0040
            r0 = 1
        L_0x0040:
            return r0
        L_0x0041:
            boolean r6 = r5.isDaylightSaving(r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.tz.HistorizedTimezone.isDaylightSaving(net.time4j.base.UnixTime):boolean");
    }

    public boolean isFixed() {
        return this.history.isEmpty();
    }

    public TransitionHistory getHistory() {
        return this.history;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HistorizedTimezone)) {
            return false;
        }
        HistorizedTimezone historizedTimezone = (HistorizedTimezone) obj;
        if (!this.id.canonical().equals(historizedTimezone.id.canonical()) || !this.history.equals(historizedTimezone.history) || !this.strategy.equals(historizedTimezone.strategy)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.id.canonical().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        sb.append(getClass().getName());
        sb.append(AbstractJsonLexerKt.COLON);
        sb.append(this.id.canonical());
        sb.append(",history={");
        sb.append(this.history);
        sb.append("},strategy=");
        sb.append(this.strategy);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    public TransitionStrategy getStrategy() {
        return this.strategy;
    }

    public Timezone with(TransitionStrategy transitionStrategy) {
        if (this.strategy == transitionStrategy) {
            return this;
        }
        return new HistorizedTimezone(this.id, this.history, transitionStrategy);
    }

    private Object writeReplace() {
        return new SPX(this, 14);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Serialization proxy required.");
    }
}
