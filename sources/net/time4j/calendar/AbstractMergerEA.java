package net.time4j.calendar;

import java.util.Locale;
import net.time4j.calendar.EastAsianCalendar;
import net.time4j.calendar.service.GenericDatePatterns;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoDisplay;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoMerger;
import net.time4j.engine.Chronology;
import net.time4j.engine.DisplayStyle;
import net.time4j.engine.StartOfDay;

abstract class AbstractMergerEA<C extends EastAsianCalendar<?, C>> implements ChronoMerger<C> {
    private final Class<C> chronoType;

    public abstract C createFrom(ChronoEntity<?> chronoEntity, AttributeQuery attributeQuery, boolean z, boolean z2);

    public int getDefaultPivotYear() {
        return 100;
    }

    public ChronoDisplay preformat(C c, AttributeQuery attributeQuery) {
        return c;
    }

    public Chronology<?> preparser() {
        return null;
    }

    AbstractMergerEA(Class<C> cls) {
        this.chronoType = cls;
    }

    public String getFormatPattern(DisplayStyle displayStyle, Locale locale) {
        return GenericDatePatterns.get("chinese", displayStyle, locale);
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [net.time4j.base.TimeSource, net.time4j.base.TimeSource<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C createFrom(net.time4j.base.TimeSource<?> r4, net.time4j.engine.AttributeQuery r5) {
        /*
            r3 = this;
            net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r0 = net.time4j.format.Attributes.TIMEZONE_ID
            boolean r0 = r5.contains(r0)
            if (r0 == 0) goto L_0x0011
            net.time4j.engine.AttributeKey<net.time4j.tz.TZID> r0 = net.time4j.format.Attributes.TIMEZONE_ID
            java.lang.Object r0 = r5.get(r0)
            net.time4j.tz.TZID r0 = (net.time4j.tz.TZID) r0
            goto L_0x0029
        L_0x0011:
            net.time4j.engine.AttributeKey<net.time4j.format.Leniency> r0 = net.time4j.format.Attributes.LENIENCY
            net.time4j.format.Leniency r1 = net.time4j.format.Leniency.SMART
            java.lang.Object r0 = r5.get(r0, r1)
            net.time4j.format.Leniency r0 = (net.time4j.format.Leniency) r0
            boolean r0 = r0.isLax()
            if (r0 == 0) goto L_0x005f
            net.time4j.tz.Timezone r0 = net.time4j.tz.Timezone.ofSystem()
            net.time4j.tz.TZID r0 = r0.getID()
        L_0x0029:
            net.time4j.engine.AttributeKey<net.time4j.engine.StartOfDay> r1 = net.time4j.format.Attributes.START_OF_DAY
            net.time4j.engine.StartOfDay r2 = r3.getDefaultStartOfDay()
            java.lang.Object r5 = r5.get(r1, r2)
            net.time4j.engine.StartOfDay r5 = (net.time4j.engine.StartOfDay) r5
            net.time4j.base.UnixTime r4 = r4.currentTime()
            net.time4j.Moment r4 = net.time4j.Moment.from(r4)
            net.time4j.PlainTimestamp r4 = r4.toZonalTimestamp((net.time4j.tz.TZID) r0)
            net.time4j.PlainDate r1 = r4.getCalendarDate()
            int r5 = r5.getDeviation(r1, r0)
            long r0 = (long) r5
            net.time4j.ClockUnit r5 = net.time4j.ClockUnit.SECONDS
            net.time4j.engine.TimePoint r4 = r4.minus(r0, r5)
            net.time4j.PlainTimestamp r4 = (net.time4j.PlainTimestamp) r4
            net.time4j.PlainDate r4 = r4.getCalendarDate()
            java.lang.Class<C> r5 = r3.chronoType
            net.time4j.engine.Calendrical r4 = r4.transform(r5)
            net.time4j.calendar.EastAsianCalendar r4 = (net.time4j.calendar.EastAsianCalendar) r4
            return r4
        L_0x005f:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.AbstractMergerEA.createFrom(net.time4j.base.TimeSource, net.time4j.engine.AttributeQuery):net.time4j.calendar.EastAsianCalendar");
    }

    public StartOfDay getDefaultStartOfDay() {
        return StartOfDay.MIDNIGHT;
    }
}
