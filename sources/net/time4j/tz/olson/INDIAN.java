package net.time4j.tz.olson;

public enum INDIAN implements StdZoneIdentifier {
    ANTANANARIVO("Antananarivo", "MG"),
    CHAGOS("Chagos", "IO"),
    CHRISTMAS("Christmas", "CX"),
    COCOS("Cocos", "CC"),
    COMORO("Comoro", "KM"),
    KERGUELEN("Kerguelen", "TF"),
    MAHE("Mahe", "SC"),
    MALDIVES("Maldives", "MV"),
    MAURITIUS("Mauritius", "MU"),
    MAYOTTE("Mayotte", "YT"),
    REUNION("Reunion", "RE");
    
    private final String city;
    private final String country;
    private final String id;

    public String getRegion() {
        return "Indian";
    }

    private INDIAN(String str, String str2) {
        this.id = "Indian/" + str;
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
