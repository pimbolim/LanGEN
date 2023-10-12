package net.time4j.tz.olson;

public enum ANTARCTICA implements StdZoneIdentifier {
    CASEY("Casey", "AQ"),
    DAVIS("Davis", "AQ"),
    DUMONTDURVILLE("DumontDUrville", "AQ"),
    MACQUARIE("Macquarie", "AU"),
    MAWSON("Mawson", "AQ"),
    MCMURDO("McMurdo", "AQ"),
    PALMER("Palmer", "AQ"),
    ROTHERA("Rothera", "AQ"),
    SYOWA("Syowa", "AQ"),
    VOSTOK("Vostok", "AQ");
    
    private final String city;
    private final String country;
    private final String id;

    public String getRegion() {
        return "Antarctica";
    }

    private ANTARCTICA(String str, String str2) {
        this.id = "Antarctica/" + str;
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
