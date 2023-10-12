package net.time4j.calendar.service;

import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import net.time4j.PlainDate;
import net.time4j.calendar.KoreanCalendar;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoExtension;

public class KoreanExtension implements ChronoExtension {
    public boolean accept(Class<?> cls) {
        return cls == PlainDate.class;
    }

    public Set<ChronoElement<?>> getElements(Locale locale, AttributeQuery attributeQuery) {
        return Collections.emptySet();
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [net.time4j.engine.ChronoEntity<?>, net.time4j.engine.ChronoEntity] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public net.time4j.engine.ChronoEntity<?> resolve(net.time4j.engine.ChronoEntity<?> r1, java.util.Locale r2, net.time4j.engine.AttributeQuery r3) {
        /*
            r0 = this;
            net.time4j.engine.ChronoElement<java.lang.Integer> r2 = net.time4j.calendar.KoreanCalendar.YEAR_OF_ERA
            boolean r2 = r1.contains(r2)
            if (r2 == 0) goto L_0x0016
            net.time4j.engine.ChronoElement<java.lang.Integer> r2 = net.time4j.calendar.KoreanCalendar.YEAR_OF_ERA
            int r2 = r1.getInt(r2)
            net.time4j.AdjustableElement<java.lang.Integer, net.time4j.PlainDate> r3 = net.time4j.PlainDate.YEAR
            int r2 = r2 + -2333
            net.time4j.engine.ChronoEntity r1 = r1.with((net.time4j.engine.ChronoElement<java.lang.Integer>) r3, (int) r2)
        L_0x0016:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.time4j.calendar.service.KoreanExtension.resolve(net.time4j.engine.ChronoEntity, java.util.Locale, net.time4j.engine.AttributeQuery):net.time4j.engine.ChronoEntity");
    }

    public boolean canResolve(ChronoElement<?> chronoElement) {
        return chronoElement == KoreanCalendar.YEAR_OF_ERA;
    }
}
