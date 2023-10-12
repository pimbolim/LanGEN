package net.time4j.tz.olson;

public enum PACIFIC implements StdZoneIdentifier {
    APIA("Apia", "WS"),
    AUCKLAND("Auckland", "NZ"),
    CHATHAM("Chatham", "NZ"),
    CHUUK("Chuuk", "FM"),
    EASTER("Easter", "CL"),
    EFATE("Efate", "VU"),
    ENDERBURY("Enderbury", "KI"),
    FAKAOFO("Fakaofo", "TK"),
    FIJI("Fiji", "FJ"),
    FUNAFUTI("Funafuti", "TV"),
    GALAPAGOS("Galapagos", "EC"),
    GAMBIER("Gambier", "PF"),
    GUADALCANAL("Guadalcanal", "SB"),
    GUAM("Guam", "GU"),
    HONOLULU("Honolulu", "US"),
    JOHNSTON("Johnston", "UM"),
    KIRITIMATI("Kiritimati", "KI"),
    KOSRAE("Kosrae", "FM"),
    KWAJALEIN("Kwajalein", "MH"),
    MAJURO("Majuro", "MH"),
    MARQUESAS("Marquesas", "PF"),
    MIDWAY("Midway", "UM"),
    NAURU("Nauru", "NR"),
    NIUE("Niue", "NU"),
    NORFOLK("Norfolk", "NF"),
    NOUMEA("Noumea", "NC"),
    PAGO_PAGO("Pago_Pago", "AS"),
    PALAU("Palau", "PW"),
    PITCAIRN("Pitcairn", "PN"),
    POHNPEI("Pohnpei", "FM"),
    PORT_MORESBY("Port_Moresby", "PG"),
    RAROTONGA("Rarotonga", "CK"),
    SAIPAN("Saipan", "MP"),
    TAHITI("Tahiti", "PF"),
    TARAWA("Tarawa", "KI"),
    TONGATAPU("Tongatapu", "TO"),
    WAKE("Wake", "UM"),
    WALLIS("Wallis", "WF");
    
    private final String city;
    private final String country;
    private final String id;

    public String getRegion() {
        return "Pacific";
    }

    private PACIFIC(String str, String str2) {
        this.id = "Pacific/" + str;
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
