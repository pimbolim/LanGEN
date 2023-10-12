package net.time4j.format.expert;

import java.util.HashMap;
import java.util.Map;
import net.time4j.engine.ChronoElement;

class NonAmbivalentMap extends HashMap<ChronoElement<?>, Object> {
    private static final long serialVersionUID = 1245025551222311435L;

    NonAmbivalentMap(Map<? extends ChronoElement<?>, ?> map) {
        super(map);
    }

    public Object put(ChronoElement<?> chronoElement, Object obj) {
        Object put = super.put(chronoElement, obj);
        if (chronoElement == null || put == null || put.equals(obj)) {
            return put;
        }
        throw new AmbivalentValueException(chronoElement);
    }
}
