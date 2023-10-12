package net.time4j.tz;

import net.time4j.base.UnixTime;

class SimpleUT implements UnixTime {
    private final int nano;
    private final long posix;

    private SimpleUT(long j, int i) {
        this.posix = j;
        this.nano = i;
    }

    public long getPosixTime() {
        return this.posix;
    }

    public int getNanosecond() {
        return this.nano;
    }

    static UnixTime previousTime(UnixTime unixTime) {
        return previousTime(unixTime.getPosixTime(), unixTime.getNanosecond());
    }

    static UnixTime previousTime(long j, int i) {
        if (i == 0) {
            j--;
        }
        return new SimpleUT(j, i == 0 ? 999999999 : i - 1);
    }
}
