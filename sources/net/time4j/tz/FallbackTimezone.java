package net.time4j.tz;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.time4j.base.GregorianDate;
import net.time4j.base.UnixTime;
import net.time4j.base.WallTime;

final class FallbackTimezone extends Timezone {
    private static final long serialVersionUID = -2894726563499525332L;
    private final Timezone fallback;
    private final TZID tzid;

    FallbackTimezone(TZID tzid2, Timezone timezone) {
        if (tzid2 == null || timezone == null) {
            throw null;
        }
        this.tzid = tzid2;
        this.fallback = timezone;
    }

    public TZID getID() {
        return this.tzid;
    }

    public ZonalOffset getOffset(UnixTime unixTime) {
        return this.fallback.getOffset(unixTime);
    }

    public ZonalOffset getStandardOffset(UnixTime unixTime) {
        return this.fallback.getStandardOffset(unixTime);
    }

    public ZonalOffset getDaylightSavingOffset(UnixTime unixTime) {
        return this.fallback.getDaylightSavingOffset(unixTime);
    }

    public ZonalOffset getOffset(GregorianDate gregorianDate, WallTime wallTime) {
        return this.fallback.getOffset(gregorianDate, wallTime);
    }

    public boolean isInvalid(GregorianDate gregorianDate, WallTime wallTime) {
        return this.fallback.isInvalid(gregorianDate, wallTime);
    }

    public boolean isDaylightSaving(UnixTime unixTime) {
        return this.fallback.isDaylightSaving(unixTime);
    }

    public boolean isFixed() {
        return this.fallback.isFixed();
    }

    public TransitionHistory getHistory() {
        return this.fallback.getHistory();
    }

    public TransitionStrategy getStrategy() {
        return this.fallback.getStrategy();
    }

    public Timezone with(TransitionStrategy transitionStrategy) {
        return new FallbackTimezone(this.tzid, this.fallback.with(transitionStrategy));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FallbackTimezone)) {
            return false;
        }
        FallbackTimezone fallbackTimezone = (FallbackTimezone) obj;
        if (!this.tzid.canonical().equals(fallbackTimezone.tzid.canonical()) || !this.fallback.equals(fallbackTimezone.fallback)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.tzid.canonical().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        sb.append(getClass().getName());
        sb.append(AbstractJsonLexerKt.COLON);
        sb.append(this.tzid.canonical());
        sb.append(",fallback=");
        sb.append(this.fallback);
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public Timezone getFallback() {
        return this.fallback;
    }

    private Object writeReplace() {
        return new SPX(this, 12);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Serialization proxy required.");
    }
}
