package net.time4j.tz.olson;

import net.time4j.tz.TZID;

public interface StdZoneIdentifier extends TZID {
    String getCity();

    String getCountry();

    String getRegion();
}
