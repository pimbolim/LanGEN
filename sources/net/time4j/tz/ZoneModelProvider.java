package net.time4j.tz;

import java.util.Map;
import java.util.Set;

public interface ZoneModelProvider {
    Map<String, String> getAliases();

    Set<String> getAvailableIDs();

    String getFallback();

    String getLocation();

    String getName();

    ZoneNameProvider getSpecificZoneNameRepository();

    String getVersion();

    TransitionHistory load(String str);
}
