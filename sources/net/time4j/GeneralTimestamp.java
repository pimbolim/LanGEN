package net.time4j;

import java.util.Objects;
import net.time4j.base.MathUtils;
import net.time4j.engine.CalendarDays;
import net.time4j.engine.CalendarVariant;
import net.time4j.engine.Calendrical;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoException;
import net.time4j.engine.VariantSource;
import net.time4j.tz.TZID;

public final class GeneralTimestamp<C> implements ChronoDisplay, VariantSource {
    private final Calendrical<?, ?> ca;
    private final CalendarVariant<?> cv;
    private final PlainTime time;

    public boolean hasTimezone() {
        return false;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [net.time4j.engine.CalendarVariant, net.time4j.engine.CalendarVariant<?>] */
    /* JADX WARNING: type inference failed for: r4v0, types: [net.time4j.engine.Calendrical, net.time4j.engine.Calendrical<?, ?>] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private GeneralTimestamp(net.time4j.engine.CalendarVariant<?> r3, net.time4j.engine.Calendrical<?, ?> r4, net.time4j.PlainTime r5) {
        /*
            r2 = this;
            r2.<init>()
            int r0 = r5.getHour()
            r1 = 24
            if (r0 != r1) goto L_0x0030
            r5 = 0
            r0 = 1
            if (r3 != 0) goto L_0x001d
            r2.cv = r5
            net.time4j.engine.CalendarDays r3 = net.time4j.engine.CalendarDays.of(r0)
            net.time4j.engine.Calendrical r3 = r4.plus(r3)
            r2.ca = r3
            goto L_0x0029
        L_0x001d:
            net.time4j.engine.CalendarDays r4 = net.time4j.engine.CalendarDays.of(r0)
            net.time4j.engine.CalendarVariant r3 = r3.plus(r4)
            r2.cv = r3
            r2.ca = r5
        L_0x0029:
            net.time4j.PlainTime r3 = net.time4j.PlainTime.midnightAtStartOfDay()
            r2.time = r3
            goto L_0x0036
        L_0x0030:
            r2.cv = r3
            r2.ca = r4
            r2.time = r5
        L_0x0036:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.GeneralTimestamp.<init>(net.time4j.engine.CalendarVariant, net.time4j.engine.Calendrical, net.time4j.PlainTime):void");
    }

    public static <C extends CalendarVariant<C>> GeneralTimestamp<C> of(C c, PlainTime plainTime) {
        Objects.requireNonNull(c, "Missing date component.");
        return new GeneralTimestamp<>(c, (Calendrical<?, ?>) null, plainTime);
    }

    public static <C extends Calendrical<?, C>> GeneralTimestamp<C> of(C c, PlainTime plainTime) {
        Objects.requireNonNull(c, "Missing date component.");
        return new GeneralTimestamp<>((CalendarVariant<?>) null, c, plainTime);
    }

    public C toDate() {
        C c = this.cv;
        return c == null ? this.ca : c;
    }

    public PlainTime toTime() {
        return this.time;
    }

    public GeneralTimestamp<C> minus(CalendarDays calendarDays) {
        return plus(calendarDays.inverse());
    }

    public GeneralTimestamp<C> minus(long j, ClockUnit clockUnit) {
        return plus(MathUtils.safeNegate(j), clockUnit);
    }

    public GeneralTimestamp<C> plus(CalendarDays calendarDays) {
        CalendarVariant calendarVariant = this.cv;
        Calendrical calendrical = null;
        CalendarVariant plus = calendarVariant == null ? null : calendarVariant.plus(calendarDays);
        Calendrical calendrical2 = this.ca;
        if (calendrical2 != null) {
            calendrical = calendrical2.plus(calendarDays);
        }
        return new GeneralTimestamp<>(plus, calendrical, this.time);
    }

    public GeneralTimestamp<C> plus(long j, ClockUnit clockUnit) {
        DayCycles roll = this.time.roll(j, clockUnit);
        CalendarDays of = CalendarDays.of(roll.getDayOverflow());
        CalendarVariant calendarVariant = this.cv;
        Calendrical calendrical = null;
        CalendarVariant plus = calendarVariant == null ? null : calendarVariant.plus(of);
        Calendrical calendrical2 = this.ca;
        if (calendrical2 != null) {
            calendrical = calendrical2.plus(of);
        }
        return new GeneralTimestamp<>(plus, calendrical, roll.getWallTime());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GeneralTimestamp)) {
            return false;
        }
        GeneralTimestamp cast = GeneralTimestamp.class.cast(obj);
        if (!this.time.equals(cast.time)) {
            return false;
        }
        CalendarVariant<?> calendarVariant = this.cv;
        if (calendarVariant == null) {
            if (cast.cv != null || !this.ca.equals(cast.ca)) {
                return false;
            }
            return true;
        } else if (cast.ca != null || !calendarVariant.equals(cast.cv)) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        int i;
        CalendarVariant<?> calendarVariant = this.cv;
        if (calendarVariant == null) {
            i = this.ca.hashCode();
        } else {
            i = calendarVariant.hashCode();
        }
        return i + this.time.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        CalendarVariant<?> calendarVariant = this.cv;
        if (calendarVariant == null) {
            sb.append(this.ca);
        } else {
            sb.append(calendarVariant);
        }
        sb.append(this.time);
        return sb.toString();
    }

    /* JADX WARNING: type inference failed for: r6v4, types: [net.time4j.engine.TimePoint] */
    /* JADX WARNING: type inference failed for: r6v6, types: [net.time4j.engine.TimePoint] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.time4j.Moment at(net.time4j.tz.ZonalOffset r5, net.time4j.engine.StartOfDay r6) {
        /*
            r4 = this;
            net.time4j.engine.CalendarVariant<?> r0 = r4.cv
            if (r0 != 0) goto L_0x0015
            net.time4j.engine.Calendrical<?, ?> r0 = r4.ca
            java.lang.Class<net.time4j.PlainDate> r1 = net.time4j.PlainDate.class
            net.time4j.engine.Calendrical r0 = r0.transform(r1)
            net.time4j.PlainDate r0 = (net.time4j.PlainDate) r0
            net.time4j.PlainTime r1 = r4.time
            net.time4j.PlainTimestamp r0 = r0.at(r1)
            goto L_0x0023
        L_0x0015:
            java.lang.Class<net.time4j.PlainDate> r1 = net.time4j.PlainDate.class
            net.time4j.engine.Calendrical r0 = r0.transform(r1)
            net.time4j.PlainDate r0 = (net.time4j.PlainDate) r0
            net.time4j.PlainTime r1 = r4.time
            net.time4j.PlainTimestamp r0 = r0.at(r1)
        L_0x0023:
            net.time4j.PlainDate r1 = r0.getCalendarDate()
            int r6 = r6.getDeviation(r1, r5)
            net.time4j.PlainTime r1 = r4.time
            net.time4j.ProportionalElement<java.lang.Integer, net.time4j.PlainTime> r2 = net.time4j.PlainTime.SECOND_OF_DAY
            java.lang.Object r1 = r1.get(r2)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            int r1 = r1 - r6
            r6 = 86400(0x15180, float:1.21072E-40)
            r2 = 1
            if (r1 < r6) goto L_0x004b
            net.time4j.CalendarUnit r6 = net.time4j.CalendarUnit.DAYS
            net.time4j.engine.TimePoint r6 = r0.minus(r2, r6)
            r0 = r6
            net.time4j.PlainTimestamp r0 = (net.time4j.PlainTimestamp) r0
            goto L_0x0056
        L_0x004b:
            if (r1 >= 0) goto L_0x0056
            net.time4j.CalendarUnit r6 = net.time4j.CalendarUnit.DAYS
            net.time4j.engine.TimePoint r6 = r0.plus(r2, r6)
            r0 = r6
            net.time4j.PlainTimestamp r0 = (net.time4j.PlainTimestamp) r0
        L_0x0056:
            net.time4j.Moment r5 = r0.at(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.GeneralTimestamp.at(net.time4j.tz.ZonalOffset, net.time4j.engine.StartOfDay):net.time4j.Moment");
    }

    /* JADX WARNING: type inference failed for: r6v4, types: [net.time4j.engine.TimePoint] */
    /* JADX WARNING: type inference failed for: r6v6, types: [net.time4j.engine.TimePoint] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.time4j.Moment in(net.time4j.tz.Timezone r5, net.time4j.engine.StartOfDay r6) {
        /*
            r4 = this;
            net.time4j.engine.CalendarVariant<?> r0 = r4.cv
            if (r0 != 0) goto L_0x0015
            net.time4j.engine.Calendrical<?, ?> r0 = r4.ca
            java.lang.Class<net.time4j.PlainDate> r1 = net.time4j.PlainDate.class
            net.time4j.engine.Calendrical r0 = r0.transform(r1)
            net.time4j.PlainDate r0 = (net.time4j.PlainDate) r0
            net.time4j.PlainTime r1 = r4.time
            net.time4j.PlainTimestamp r0 = r0.at(r1)
            goto L_0x0023
        L_0x0015:
            java.lang.Class<net.time4j.PlainDate> r1 = net.time4j.PlainDate.class
            net.time4j.engine.Calendrical r0 = r0.transform(r1)
            net.time4j.PlainDate r0 = (net.time4j.PlainDate) r0
            net.time4j.PlainTime r1 = r4.time
            net.time4j.PlainTimestamp r0 = r0.at(r1)
        L_0x0023:
            net.time4j.PlainDate r1 = r0.getCalendarDate()
            net.time4j.tz.TZID r2 = r5.getID()
            int r6 = r6.getDeviation(r1, r2)
            net.time4j.PlainTime r1 = r4.time
            net.time4j.ProportionalElement<java.lang.Integer, net.time4j.PlainTime> r2 = net.time4j.PlainTime.SECOND_OF_DAY
            java.lang.Object r1 = r1.get(r2)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            int r1 = r1 - r6
            r6 = 86400(0x15180, float:1.21072E-40)
            r2 = 1
            if (r1 < r6) goto L_0x004f
            net.time4j.CalendarUnit r6 = net.time4j.CalendarUnit.DAYS
            net.time4j.engine.TimePoint r6 = r0.minus(r2, r6)
            r0 = r6
            net.time4j.PlainTimestamp r0 = (net.time4j.PlainTimestamp) r0
            goto L_0x005a
        L_0x004f:
            if (r1 >= 0) goto L_0x005a
            net.time4j.CalendarUnit r6 = net.time4j.CalendarUnit.DAYS
            net.time4j.engine.TimePoint r6 = r0.plus(r2, r6)
            r0 = r6
            net.time4j.PlainTimestamp r0 = (net.time4j.PlainTimestamp) r0
        L_0x005a:
            net.time4j.Moment r5 = r0.in(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.GeneralTimestamp.in(net.time4j.tz.Timezone, net.time4j.engine.StartOfDay):net.time4j.Moment");
    }

    public boolean contains(ChronoElement<?> chronoElement) {
        return chronoElement.isDateElement() ? toDate0().contains(chronoElement) : this.time.contains(chronoElement);
    }

    public <V> V get(ChronoElement<V> chronoElement) {
        return chronoElement.isDateElement() ? toDate0().get(chronoElement) : this.time.get(chronoElement);
    }

    public int getInt(ChronoElement<Integer> chronoElement) {
        return chronoElement.isDateElement() ? toDate0().getInt(chronoElement) : this.time.getInt(chronoElement);
    }

    public <V> V getMinimum(ChronoElement<V> chronoElement) {
        return chronoElement.isDateElement() ? toDate0().getMinimum(chronoElement) : this.time.getMinimum(chronoElement);
    }

    public <V> V getMaximum(ChronoElement<V> chronoElement) {
        return chronoElement.isDateElement() ? toDate0().getMaximum(chronoElement) : this.time.getMaximum(chronoElement);
    }

    public TZID getTimezone() {
        throw new ChronoException("Timezone not available: " + this);
    }

    private ChronoDisplay toDate0() {
        ChronoDisplay chronoDisplay = this.cv;
        if (chronoDisplay == null) {
            chronoDisplay = this.ca;
        }
        return chronoDisplay;
    }

    public String getVariant() {
        CalendarVariant<?> calendarVariant = this.cv;
        return calendarVariant == null ? "" : calendarVariant.getVariant();
    }
}
