package net.time4j.tz;

import net.time4j.base.GregorianDate;
import net.time4j.base.WallTime;

public interface TransitionStrategy {
    ZonalOffset getOffset(GregorianDate gregorianDate, WallTime wallTime, Timezone timezone);

    long resolve(GregorianDate gregorianDate, WallTime wallTime, Timezone timezone);

    TransitionStrategy using(OverlapResolver overlapResolver);
}
