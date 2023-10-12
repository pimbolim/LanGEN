package net.time4j.base;

import net.time4j.base.UnixTime;

public interface TimeSource<T extends UnixTime> {
    T currentTime();
}
