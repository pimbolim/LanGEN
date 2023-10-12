package net.time4j.calendar.hindu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import net.time4j.engine.CalendarEra;
import net.time4j.engine.CalendarSystem;

abstract class HinduCS implements CalendarSystem<HinduCalendar> {
    static final long KALI_YUGA_EPOCH = -1132959;
    final HinduVariant variant;

    /* access modifiers changed from: package-private */
    public abstract HinduCalendar create(int i, HinduMonth hinduMonth, HinduDay hinduDay);

    /* access modifiers changed from: package-private */
    public abstract HinduCalendar create(long j);

    /* access modifiers changed from: package-private */
    public abstract boolean isValid(int i, HinduMonth hinduMonth, HinduDay hinduDay);

    HinduCS(HinduVariant hinduVariant) {
        Objects.requireNonNull(hinduVariant);
        this.variant = hinduVariant;
    }

    public final HinduCalendar transform(long j) {
        long minimumSinceUTC = getMinimumSinceUTC();
        long maximumSinceUTC = getMaximumSinceUTC();
        if (j >= minimumSinceUTC && j <= maximumSinceUTC) {
            return create(j);
        }
        throw new IllegalArgumentException("Out of range: " + minimumSinceUTC + " <= " + j + " <= " + maximumSinceUTC);
    }

    public final long transform(HinduCalendar hinduCalendar) {
        return hinduCalendar.getDaysSinceEpochUTC();
    }

    public List<CalendarEra> getEras() {
        return Collections.unmodifiableList(new ArrayList(Arrays.asList(HinduEra.values())));
    }

    /* access modifiers changed from: package-private */
    public final boolean isExpunged(int i, HinduMonth hinduMonth) {
        return !create(create(i, hinduMonth, HinduDay.valueOf(15)).getDaysSinceEpochUTC()).getMonth().getValue().equals(hinduMonth.getValue());
    }

    /* access modifiers changed from: package-private */
    public final boolean isExpunged(int i, HinduMonth hinduMonth, HinduDay hinduDay) {
        HinduCalendar create = create(create(i, hinduMonth, hinduDay).getDaysSinceEpochUTC());
        return create.getExpiredYearOfKaliYuga() != i || !create.getMonth().equals(hinduMonth) || !create.getDayOfMonth().equals(hinduDay);
    }

    static double modulo(double d, double d2) {
        return d - (d2 * Math.floor(d / d2));
    }
}
