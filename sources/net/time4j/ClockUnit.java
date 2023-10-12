package net.time4j;

import net.time4j.base.MathUtils;
import net.time4j.engine.Normalizer;
import net.time4j.engine.TimePoint;
import net.time4j.engine.TimeSpan;
import org.apache.commons.lang3.time.DateUtils;

public enum ClockUnit implements IsoTimeUnit {
    HOURS {
        public double getLength() {
            return 3600.0d;
        }

        public char getSymbol() {
            return 'H';
        }
    },
    MINUTES {
        public double getLength() {
            return 60.0d;
        }

        public char getSymbol() {
            return 'M';
        }
    },
    SECONDS {
        public double getLength() {
            return 1.0d;
        }

        public char getSymbol() {
            return 'S';
        }
    },
    MILLIS {
        public double getLength() {
            return 0.001d;
        }

        public char getSymbol() {
            return '3';
        }
    },
    MICROS {
        public double getLength() {
            return 1.0E-6d;
        }

        public char getSymbol() {
            return '6';
        }
    },
    NANOS {
        public double getLength() {
            return 1.0E-9d;
        }

        public char getSymbol() {
            return '9';
        }
    };
    
    private static final long[] FACTORS = null;

    public boolean isCalendrical() {
        return false;
    }

    static {
        FACTORS = new long[]{1, 60, 3600, DateUtils.MILLIS_PER_HOUR, 3600000000L, 3600000000000L};
    }

    public <T extends TimePoint<? super ClockUnit, T>> long between(T t, T t2) {
        return t.until(t2, this);
    }

    public long convert(long j, ClockUnit clockUnit) {
        if (j == 0) {
            return 0;
        }
        int ordinal = ordinal();
        int ordinal2 = clockUnit.ordinal();
        if (ordinal == ordinal2) {
            return j;
        }
        if (ordinal > ordinal2) {
            long[] jArr = FACTORS;
            return MathUtils.safeMultiply(j, jArr[ordinal] / jArr[ordinal2]);
        }
        long[] jArr2 = FACTORS;
        return j / (jArr2[ordinal2] / jArr2[ordinal]);
    }

    public long convert(TimeSpan<? extends ClockUnit> timeSpan) {
        long j = 0;
        if (timeSpan.isEmpty()) {
            return 0;
        }
        ClockUnit clockUnit = null;
        for (int size = timeSpan.getTotalLength().size() - 1; size >= 0; size--) {
            TimeSpan.Item item = timeSpan.getTotalLength().get(size);
            ClockUnit clockUnit2 = (ClockUnit) item.getUnit();
            if (clockUnit == null) {
                j = item.getAmount();
                clockUnit = clockUnit2;
            } else {
                j = MathUtils.safeAdd(j, clockUnit.convert(item.getAmount(), clockUnit2));
            }
        }
        if (timeSpan.isNegative()) {
            j = MathUtils.safeNegate(j);
        }
        return convert(j, clockUnit);
    }

    public Normalizer<ClockUnit> only() {
        return ClockNormalizer.ofOnlyMode(this);
    }

    public Normalizer<ClockUnit> truncated() {
        return ClockNormalizer.ofTruncateMode(this);
    }

    public Normalizer<ClockUnit> rounded() {
        return ClockNormalizer.ofRoundingMode(this);
    }
}
