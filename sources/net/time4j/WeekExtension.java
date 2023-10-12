package net.time4j;

import java.util.Collections;
import java.util.Locale;
import java.util.Set;
import net.time4j.engine.AttributeQuery;
import net.time4j.engine.ChronoElement;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.ChronoExtension;

class WeekExtension implements ChronoExtension {
    public boolean accept(Class<?> cls) {
        return false;
    }

    public boolean canResolve(ChronoElement<?> chronoElement) {
        return false;
    }

    public ChronoEntity<?> resolve(ChronoEntity<?> chronoEntity, Locale locale, AttributeQuery attributeQuery) {
        return chronoEntity;
    }

    WeekExtension() {
    }

    public Set<ChronoElement<?>> getElements(Locale locale, AttributeQuery attributeQuery) {
        if (locale.getCountry().isEmpty()) {
            return Collections.emptySet();
        }
        return Weekmodel.of(locale).getElements();
    }
}
