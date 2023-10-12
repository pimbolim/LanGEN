package net.time4j.scale;

import java.util.Map;
import net.time4j.base.GregorianDate;

public interface LeapSecondProvider {
    GregorianDate getDateOfEvent(int i, int i2, int i3);

    GregorianDate getDateOfExpiration();

    Map<GregorianDate, Integer> getLeapSecondTable();

    boolean supportsNegativeLS();
}
