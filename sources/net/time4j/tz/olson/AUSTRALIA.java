package net.time4j.tz.olson;

public enum AUSTRALIA implements StdZoneIdentifier {
    ADELAIDE("Adelaide"),
    BRISBANE("Brisbane"),
    BROKEN_HILL("Broken_Hill"),
    CURRIE("Currie"),
    DARWIN("Darwin"),
    EUCLA("Eucla"),
    HOBART("Hobart"),
    LINDEMAN("Lindeman"),
    LORD_HOWE("Lord_Howe"),
    MELBOURNE("Melbourne"),
    PERTH("Perth"),
    SYDNEY("Sydney");
    
    private final String city;
    private final String id;

    public String getCountry() {
        return "AU";
    }

    public String getRegion() {
        return "Australia";
    }

    private AUSTRALIA(String str) {
        this.id = "Australia/" + str;
        this.city = str;
    }

    public String canonical() {
        return this.id;
    }

    public String getCity() {
        return this.city;
    }
}
