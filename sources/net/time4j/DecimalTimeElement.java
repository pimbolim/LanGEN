package net.time4j;

import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.math.BigDecimal;
import net.time4j.engine.BasicElement;
import net.time4j.engine.ChronoFunction;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;
import net.time4j.tz.ZonalOffset;

final class DecimalTimeElement extends BasicElement<BigDecimal> implements ZonalElement<BigDecimal> {
    private static final long serialVersionUID = -4837430960549551204L;
    private final transient BigDecimal defaultMax;

    public boolean isDateElement() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isSingleton() {
        return true;
    }

    public boolean isTimeElement() {
        return true;
    }

    DecimalTimeElement(String str, BigDecimal bigDecimal) {
        super(str);
        this.defaultMax = bigDecimal;
    }

    public Class<BigDecimal> getType() {
        return BigDecimal.class;
    }

    public BigDecimal getDefaultMinimum() {
        return BigDecimal.ZERO;
    }

    public BigDecimal getDefaultMaximum() {
        return this.defaultMax;
    }

    public ChronoFunction<Moment, BigDecimal> inStdTimezone() {
        return in(Timezone.ofSystem());
    }

    public ChronoFunction<Moment, BigDecimal> inTimezone(TZID tzid) {
        return in(Timezone.of(tzid));
    }

    public ChronoFunction<Moment, BigDecimal> in(Timezone timezone) {
        return new ZonalQuery(this, timezone);
    }

    public ChronoFunction<Moment, BigDecimal> atUTC() {
        return at(ZonalOffset.UTC);
    }

    public ChronoFunction<Moment, BigDecimal> at(ZonalOffset zonalOffset) {
        return new ZonalQuery(this, zonalOffset);
    }

    private Object readResolve() throws ObjectStreamException {
        Object lookupElement = PlainTime.lookupElement(name());
        if (lookupElement != null) {
            return lookupElement;
        }
        throw new InvalidObjectException(name());
    }
}
