package net.time4j.calendar.service;

import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import net.time4j.calendar.EthiopianTime;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoExtension;

public class EthiopianExtension implements ChronoExtension {
    public boolean accept(Class<?> cls) {
        return false;
    }

    public Set<ChronoElement<?>> getElements(Locale locale, AttributeQuery attributeQuery) {
        return Collections.singleton(EthiopianTime.ETHIOPIAN_HOUR);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [net.time4j.engine.ChronoEntity<?>, net.time4j.engine.ChronoEntity] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.time4j.engine.ChronoEntity<?> resolve(net.time4j.engine.ChronoEntity<?> r1, java.util.Locale r2, net.time4j.engine.AttributeQuery r3) {
        /*
            r0 = this;
            net.time4j.engine.ChronoElement<java.lang.Integer> r2 = net.time4j.calendar.EthiopianTime.ETHIOPIAN_HOUR
            boolean r2 = r1.contains(r2)
            if (r2 == 0) goto L_0x0025
            net.time4j.engine.ChronoElement<java.lang.Integer> r2 = net.time4j.calendar.EthiopianTime.ETHIOPIAN_HOUR
            java.lang.Object r2 = r1.get(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r3 = 12
            if (r2 != r3) goto L_0x0019
            r2 = 0
        L_0x0019:
            int r2 = r2 + 6
            if (r2 < r3) goto L_0x001f
            int r2 = r2 + -12
        L_0x001f:
            net.time4j.ProportionalElement<java.lang.Integer, net.time4j.PlainTime> r3 = net.time4j.PlainTime.DIGITAL_HOUR_OF_AMPM
            net.time4j.engine.ChronoEntity r1 = r1.with((net.time4j.engine.ChronoElement<java.lang.Integer>) r3, (int) r2)
        L_0x0025:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.service.EthiopianExtension.resolve(net.time4j.engine.ChronoEntity, java.util.Locale, net.time4j.engine.AttributeQuery):net.time4j.engine.ChronoEntity");
    }

    public boolean canResolve(ChronoElement<?> chronoElement) {
        return EthiopianTime.ETHIOPIAN_HOUR.equals(chronoElement);
    }
}
