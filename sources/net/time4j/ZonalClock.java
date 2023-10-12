package net.time4j;

import java.util.Objects;
import net.time4j.base.TimeSource;
import net.time4j.base.UnixTime;
import net.time4j.engine.CalendarFamily;
import net.time4j.engine.CalendarVariant;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.Chronology;
import net.time4j.engine.StartOfDay;
import net.time4j.engine.VariantSource;
import net.time4j.format.Attributes;
import net.time4j.tz.TZID;
import net.time4j.tz.Timezone;

public final class ZonalClock {
    private static final ZonalClock SYSTEM = new ZonalClock();
    private final TimeSource<?> timeSource;
    private final Timezone timezone;

    public ZonalClock(TimeSource<?> timeSource2, TZID tzid) {
        this(timeSource2, Timezone.of(tzid));
    }

    public ZonalClock(TimeSource<?> timeSource2, String str) {
        this(timeSource2, Timezone.of(str));
    }

    public ZonalClock(TimeSource<?> timeSource2, Timezone timezone2) {
        Objects.requireNonNull(timeSource2, "Missing time source.");
        Objects.requireNonNull(timezone2, "Missing timezone.");
        this.timeSource = timeSource2;
        this.timezone = timezone2;
    }

    private ZonalClock() {
        this.timeSource = SystemClock.INSTANCE;
        this.timezone = null;
    }

    public PlainDate today() {
        UnixTime currentTime = this.timeSource.currentTime();
        Timezone timezone2 = this.timezone;
        if (timezone2 == null) {
            timezone2 = Timezone.ofSystem();
        }
        return PlainDate.from(currentTime, timezone2.getOffset(currentTime));
    }

    public PlainTimestamp now() {
        UnixTime currentTime = this.timeSource.currentTime();
        Timezone timezone2 = this.timezone;
        if (timezone2 == null) {
            timezone2 = Timezone.ofSystem();
        }
        return PlainTimestamp.from(currentTime, timezone2.getOffset(currentTime));
    }

    public <T extends ChronoEntity<T>> T now(Chronology<T> chronology) {
        Timezone timezone2 = this.timezone;
        if (timezone2 == null) {
            timezone2 = Timezone.ofSystem();
        }
        T t = (ChronoEntity) chronology.createFrom(this.timeSource, new Attributes.Builder().setTimezone(timezone2.getID()).build());
        if (t != null) {
            return t;
        }
        Class<T> chronoType = chronology.getChronoType();
        if (CalendarVariant.class.isAssignableFrom(chronoType)) {
            throw new IllegalArgumentException("Calendar variant required: " + chronoType.getName());
        }
        throw new IllegalArgumentException("Insufficient data: " + chronoType.getName());
    }

    public <C extends CalendarVariant<C>> GeneralTimestamp<C> now(CalendarFamily<C> calendarFamily, String str, StartOfDay startOfDay) {
        Timezone timezone2 = this.timezone;
        if (timezone2 == null) {
            timezone2 = Timezone.ofSystem();
        }
        return Moment.from(this.timeSource.currentTime()).toGeneralTimestamp(calendarFamily, str, timezone2.getID(), startOfDay);
    }

    public <C extends CalendarVariant<C>> GeneralTimestamp<C> now(CalendarFamily<C> calendarFamily, VariantSource variantSource, StartOfDay startOfDay) {
        return now(calendarFamily, variantSource.getVariant(), startOfDay);
    }

    public TimeSource<?> getSource() {
        return this.timeSource;
    }

    public TZID getTimezone() {
        Timezone timezone2 = this.timezone;
        if (timezone2 == null) {
            timezone2 = Timezone.ofSystem();
        }
        return timezone2.getID();
    }

    static ZonalClock ofSystem() {
        return SYSTEM;
    }
}
