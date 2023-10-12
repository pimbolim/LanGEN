package net.time4j.calendar;

import java.io.ObjectStreamException;
import net.time4j.engine.BasicElement;

final class RelatedGregorianYearElement extends BasicElement<Integer> {
    static final RelatedGregorianYearElement SINGLETON = new RelatedGregorianYearElement();
    private static final long serialVersionUID = -1117064522468823402L;

    public char getSymbol() {
        return 'r';
    }

    public boolean isDateElement() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isSingleton() {
        return true;
    }

    public boolean isTimeElement() {
        return false;
    }

    private RelatedGregorianYearElement() {
        super("RELATED_GREGORIAN_YEAR");
    }

    public Class<Integer> getType() {
        return Integer.class;
    }

    public Integer getDefaultMinimum() {
        return -999999999;
    }

    public Integer getDefaultMaximum() {
        return 999999999;
    }

    /* access modifiers changed from: protected */
    public Object readResolve() throws ObjectStreamException {
        return SINGLETON;
    }
}
