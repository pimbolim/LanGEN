package net.time4j.calendar.hindu;

import java.util.Collections;
import java.util.List;
import net.time4j.engine.CalendarEra;
import net.time4j.engine.EpochDays;

public enum AryaSiddhanta {
    SOLAR {
        public HinduCS getCalendarSystem() {
            return new OldCS(true);
        }
    },
    LUNAR {
        public HinduCS getCalendarSystem() {
            return new OldCS(false);
        }
    };
    
    static final String PREFIX = "AryaSiddhanta@";

    /* access modifiers changed from: package-private */
    public abstract HinduCS getCalendarSystem();

    public HinduVariant variant() {
        return this == SOLAR ? HinduVariant.VAR_OLD_SOLAR : HinduVariant.VAR_OLD_LUNAR;
    }

    private static class OldCS extends HinduCS {
        private static final double ARYA_LUNAR_MONTH = 29.530581807581694d;
        private static final double ARYA_SOLAR_MONTH = 30.43822337962963d;
        private static final double ARYA_SOLAR_YEAR = 365.25868055555554d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        OldCS(boolean z) {
            super(z ? HinduVariant.VAR_OLD_SOLAR : HinduVariant.VAR_OLD_LUNAR);
        }

        public List<CalendarEra> getEras() {
            return Collections.singletonList(HinduEra.KALI_YUGA);
        }

        /* access modifiers changed from: package-private */
        public HinduCalendar create(long j) {
            double transform = ((double) (EpochDays.RATA_DIE.transform(j, EpochDays.UTC) - -1132959)) + 0.25d;
            boolean z = true;
            if (isSolar()) {
                return new HinduCalendar(this.variant, (int) Math.floor(transform / ARYA_SOLAR_YEAR), HinduMonth.ofSolar(((int) modulo(Math.floor(transform / ARYA_SOLAR_MONTH), 12.0d)) + 1), HinduDay.valueOf(((int) Math.floor(modulo(transform, ARYA_SOLAR_MONTH))) + 1), j);
            }
            double modulo = transform - modulo(transform, ARYA_LUNAR_MONTH);
            double modulo2 = modulo(modulo, ARYA_SOLAR_MONTH);
            if (0.907641572047936d < modulo2 || modulo2 <= 0.0d) {
                z = false;
            }
            int ceil = (int) (Math.ceil((modulo + ARYA_SOLAR_MONTH) / ARYA_SOLAR_YEAR) - 1.0d);
            int modulo3 = (int) (modulo(Math.floor((transform * 30.0d) / ARYA_LUNAR_MONTH), 30.0d) + 1.0d);
            HinduMonth ofLunisolar = HinduMonth.ofLunisolar((int) (modulo(Math.ceil(modulo / ARYA_SOLAR_MONTH), 12.0d) + 1.0d));
            HinduVariant hinduVariant = this.variant;
            if (z) {
                ofLunisolar = ofLunisolar.withLeap();
            }
            return new HinduCalendar(hinduVariant, ceil, ofLunisolar, HinduDay.valueOf(modulo3), j);
        }

        /* access modifiers changed from: package-private */
        public HinduCalendar create(int i, HinduMonth hinduMonth, HinduDay hinduDay) {
            double d;
            if (isSolar()) {
                d = (((((double) i) * ARYA_SOLAR_YEAR) + (((double) (hinduMonth.getRasi() - 1)) * ARYA_SOLAR_MONTH)) + ((double) hinduDay.getValue())) - 1.25d;
            } else {
                double d2 = ((double) ((i * 12) - 1)) * ARYA_SOLAR_MONTH;
                double floor = (Math.floor(d2 / ARYA_LUNAR_MONTH) + 1.0d) * ARYA_LUNAR_MONTH;
                int value = hinduMonth.getValue().getValue();
                if (hinduMonth.isLeap() || Math.ceil((floor - d2) / 0.907641572047936d) > ((double) value)) {
                    value--;
                }
                d = ((floor + (((double) value) * ARYA_LUNAR_MONTH)) + (((double) (hinduDay.getValue() - 1)) * 0.9843527269193898d)) - 0.25d;
            }
            return new HinduCalendar(this.variant, i, hinduMonth, hinduDay, EpochDays.UTC.transform((long) Math.ceil(d - 3.66120548278559E-6d), EpochDays.RATA_DIE));
        }

        /* access modifiers changed from: package-private */
        public boolean isValid(int i, HinduMonth hinduMonth, HinduDay hinduDay) {
            if (i < 0 || i > 5999 || hinduMonth == null || hinduDay == null) {
                return false;
            }
            if (isSolar() && (hinduMonth.isLeap() || hinduDay.isLeap())) {
                return false;
            }
            if (hinduDay.getValue() > (isSolar() ? 31 : 30)) {
                return false;
            }
            return !isExpunged(i, hinduMonth, hinduDay);
        }

        public long getMinimumSinceUTC() {
            return EpochDays.UTC.transform(isSolar() ? -1132959 : -1132988, EpochDays.RATA_DIE);
        }

        public long getMaximumSinceUTC() {
            return isSolar() ? 338699 : 338671;
        }

        private boolean isSolar() {
            return this.variant == HinduVariant.VAR_OLD_SOLAR;
        }
    }
}
