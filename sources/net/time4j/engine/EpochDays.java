package net.time4j.engine;

import java.util.Locale;
import net.time4j.base.MathUtils;

public enum EpochDays implements ChronoElement<Long> {
    UTC(2441317),
    UNIX(2440587),
    MODIFIED_JULIAN_DATE(2400000),
    EXCEL(2415019),
    ANSI(2305812),
    RATA_DIE(1721424),
    JULIAN_DAY_NUMBER(-1),
    LILIAN_DAY_NUMBER(2299159);
    
    private final int offset;

    public boolean isDateElement() {
        return true;
    }

    public boolean isLenient() {
        return false;
    }

    public boolean isTimeElement() {
        return false;
    }

    private EpochDays(int i) {
        this.offset = (i - 2440587) - 730;
    }

    public long transform(long j, EpochDays epochDays) {
        try {
            return MathUtils.safeAdd(j, (long) (epochDays.offset - this.offset));
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public Class<Long> getType() {
        return Long.class;
    }

    public char getSymbol() {
        return this == MODIFIED_JULIAN_DATE ? 'g' : 0;
    }

    public int compare(ChronoDisplay chronoDisplay, ChronoDisplay chronoDisplay2) {
        return ((Long) chronoDisplay.get(this)).compareTo((Long) chronoDisplay2.get(this));
    }

    public Long getDefaultMinimum() {
        return Long.valueOf(-365243219892L - ((long) this.offset));
    }

    public Long getDefaultMaximum() {
        return Long.valueOf(365241779741L - ((long) this.offset));
    }

    public String getDisplayName(Locale locale) {
        return name();
    }

    /* access modifiers changed from: package-private */
    public <D extends ChronoEntity<D>> ElementRule<D, Long> derive(CalendarSystem<D> calendarSystem) {
        return new Rule(this, calendarSystem);
    }

    private static class Rule<D extends ChronoEntity<D>> implements ElementRule<D, Long> {
        private static final int UTC_OFFSET = 730;
        private final CalendarSystem<D> calsys;
        private final EpochDays element;

        public ChronoElement<?> getChildAtCeiling(D d) {
            return null;
        }

        public ChronoElement<?> getChildAtFloor(D d) {
            return null;
        }

        Rule(EpochDays epochDays, CalendarSystem<D> calendarSystem) {
            this.element = epochDays;
            this.calsys = calendarSystem;
        }

        public Long getValue(D d) {
            return Long.valueOf(this.element.transform(this.calsys.transform(d) + 730, EpochDays.UNIX));
        }

        public boolean isValid(D d, Long l) {
            if (l == null) {
                return false;
            }
            try {
                long safeSubtract = MathUtils.safeSubtract(EpochDays.UNIX.transform(l.longValue(), this.element), 730);
                if (safeSubtract > this.calsys.getMaximumSinceUTC() || safeSubtract < this.calsys.getMinimumSinceUTC()) {
                    return false;
                }
                return true;
            } catch (ArithmeticException | IllegalArgumentException unused) {
                return false;
            }
        }

        public D withValue(D d, Long l, boolean z) {
            if (l != null) {
                return (ChronoEntity) this.calsys.transform(MathUtils.safeSubtract(EpochDays.UNIX.transform(l.longValue(), this.element), 730));
            }
            throw new IllegalArgumentException("Missing epoch day value.");
        }

        public Long getMinimum(D d) {
            return Long.valueOf(this.element.transform(this.calsys.getMinimumSinceUTC() + 730, EpochDays.UNIX));
        }

        public Long getMaximum(D d) {
            return Long.valueOf(this.element.transform(this.calsys.getMaximumSinceUTC() + 730, EpochDays.UNIX));
        }
    }
}
