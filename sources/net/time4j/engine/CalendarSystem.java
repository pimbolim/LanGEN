package net.time4j.engine;

import java.util.List;

public interface CalendarSystem<D> {
    List<CalendarEra> getEras();

    long getMaximumSinceUTC();

    long getMinimumSinceUTC();

    long transform(D d);

    D transform(long j);
}
