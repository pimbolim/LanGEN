package net.time4j;

import com.nimbusds.jose.shaded.ow2asm.signature.SignatureVisitor;
import java.io.Serializable;
import net.time4j.CalendarUnit;
import net.time4j.engine.BasicUnit;
import net.time4j.engine.ChronoEntity;
import net.time4j.engine.Chronology;
import net.time4j.engine.UnitRule;

final class OverflowUnit extends BasicUnit implements IsoDateUnit, Serializable {
    static final int POLICY_CARRY_OVER = 3;
    static final int POLICY_END_OF_MONTH = 2;
    static final int POLICY_JODA_METRIC = 6;
    static final int POLICY_KEEPING_LAST_DATE = 5;
    static final int POLICY_NEXT_VALID_DATE = 1;
    static final int POLICY_PREVIOUS_VALID_DATE = 0;
    static final int POLICY_UNLESS_INVALID = 4;
    private static final long serialVersionUID = 1988843503875912054L;
    private final int policy;
    private final CalendarUnit unit;

    public char getSymbol() {
        return 0;
    }

    public boolean isCalendrical() {
        return true;
    }

    OverflowUnit(CalendarUnit calendarUnit, int i) {
        this.unit = calendarUnit;
        this.policy = i;
    }

    public double getLength() {
        return this.unit.getLength();
    }

    /* access modifiers changed from: protected */
    public <T extends ChronoEntity<T>> UnitRule<T> derive(Chronology<T> chronology) {
        if (chronology.isRegistered(PlainDate.CALENDAR_DATE)) {
            return new CalendarUnit.Rule(this.unit, this.policy);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OverflowUnit)) {
            return false;
        }
        OverflowUnit overflowUnit = (OverflowUnit) obj;
        if (this.unit == overflowUnit.unit && this.policy == overflowUnit.policy) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.unit.hashCode() * 23) + (this.policy * 37);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.unit.getSymbol());
        sb.append(SignatureVisitor.SUPER);
        switch (this.policy) {
            case 1:
                sb.append("NEXT_VALID_DATE");
                break;
            case 2:
                sb.append("END_OF_MONTH");
                break;
            case 3:
                sb.append("CARRY_OVER");
                break;
            case 4:
                sb.append("UNLESS_INVALID");
                break;
            case 5:
                sb.append("KEEPING_LAST_DATE");
                break;
            case 6:
                sb.append("JODA_METRIC");
                break;
            default:
                sb.append("PREVIOUS_VALID_DATE");
                break;
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public CalendarUnit getCalendarUnit() {
        return this.unit;
    }
}
