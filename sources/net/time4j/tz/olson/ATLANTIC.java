package net.time4j.tz.olson;

public enum ATLANTIC implements StdZoneIdentifier {
    AZORES("Azores", "PT"),
    BERMUDA("Bermuda", "BM"),
    CANARY("Canary", "ES"),
    CAPE_VERDE("Cape_Verde", "CV"),
    FAROE("Faroe", "FO"),
    MADEIRA("Madeira", "PT"),
    REYKJAVIK("Reykjavik", "IS"),
    SOUTH_GEORGIA("South_Georgia", "GS"),
    ST_HELENA("St_Helena", "SH"),
    STANLEY("Stanley", "FK");
    
    private final String city;
    private final String country;
    private final String id;

    public String getRegion() {
        return "Atlantic";
    }

    private ATLANTIC(String str, String str2) {
        this.id = "Atlantic/" + str;
        this.city = str;
        this.country = str2;
    }

    public String canonical() {
        return this.id;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }
}
