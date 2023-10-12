package net.time4j.scale;

import net.time4j.base.GregorianDate;

public interface LeapSecondEvent {
    GregorianDate getDate();

    int getShift();
}
