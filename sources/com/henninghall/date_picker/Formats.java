package com.henninghall.date_picker;

import com.nimbusds.jose.jwk.JWKParameterNames;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import java.util.EnumMap;
import java.util.HashMap;

public class Formats {
    public static EnumMap<Format, String> defaultFormat = mapOf("EEE, MMM d", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE);
    private static HashMap<String, EnumMap<Format, String>> map = new HashMap<String, EnumMap<Format, String>>() {
        {
            put("af", Formats.mapOf("EEE d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("am", Formats.mapOf("EEE፣ MMM d", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("ar", Formats.mapOf("EEE، d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("ar_DZ", Formats.mapOf("EEE، d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("ar_EG", Formats.mapOf("EEE، d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("az", Formats.mapOf("d MMM, EEE", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("be", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("bg", Formats.mapOf("EEE, d.MM", "d", "y 'г'."));
            put("bn", Formats.mapOf("EEE d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("br", Formats.mapOf("EEE d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("bs", Formats.mapOf("EEE, d. MMM", "d.", "y."));
            put("ca", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("chr", Formats.mapOf("EEE, MMM d", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("cs", Formats.mapOf("EEE d. M.", "d.", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("cy", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("da", Formats.mapOf("EEE d. MMM", "d.", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("de", Formats.mapOf("EEE, d. MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("de_AT", Formats.mapOf("EEE, d. MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("de_CH", Formats.mapOf("EEE, d. MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("el", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("en", Formats.mapOf("EEE, MMM d", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("en_AU", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("en_CA", Formats.mapOf("EEE, MMM d", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("en_GB", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("en_IE", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("en_IN", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("en_SG", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("en_US", Formats.mapOf("EEE, MMM d", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("en_ZA", Formats.mapOf("EEE, dd MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("es", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("es_419", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("es_ES", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("es_MX", Formats.mapOf("EEE d 'de' MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("es_US", Formats.mapOf("EEE, d 'de' MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("et", Formats.mapOf("EEE, d. MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("eu", Formats.mapOf("MMM d, EEE", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("fa", Formats.mapOf("EEE d LLL", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("fi", Formats.mapOf("EEE d. MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("fil", Formats.mapOf("EEE, MMM d", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("fr", Formats.mapOf("EEE d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("fr_CA", Formats.mapOf("EEE d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("ga", Formats.mapOf("EEE d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("gl", Formats.mapOf("EEE, d 'de' MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("gsw", Formats.mapOf("EEE d. MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("gu", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("haw", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("he", Formats.mapOf("EEE, d בMMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("hi", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("hr", Formats.mapOf("EEE, d. MMM", "d.", "y."));
            put("hu", Formats.mapOf("MMM d., EEE", "d", "y."));
            put("hy", Formats.mapOf("d MMM, EEE", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put(MessageExtension.FIELD_ID, Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("in", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("is", Formats.mapOf("EEE, d. MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("it", Formats.mapOf("EEE d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("iw", Formats.mapOf("EEE, d בMMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("ja", Formats.mapOf("M月d日 EEE", "d日", "y年"));
            put("ka", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("kk", Formats.mapOf("d MMM, EEE", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("km", Formats.mapOf("EEE d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("kn", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("ko", Formats.mapOf("MMM d일 EEE", "d일", "y년"));
            put("ky", Formats.mapOf("d-MMM, EEE", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("ln", Formats.mapOf("EEE d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("lo", Formats.mapOf("EEE d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("lt", Formats.mapOf("MM-dd, EEE", "dd", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("lv", Formats.mapOf("EEE, d. MMM", "d", "y. 'g'."));
            put("mk", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("ml", Formats.mapOf("MMM d, EEE", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("mn", Formats.mapOf("MMM'ын' d. EEE", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("mo", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("mr", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("ms", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("mt", Formats.mapOf("EEE, d 'ta'’ MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("my", Formats.mapOf("MMM d၊ EEE", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("nb", Formats.mapOf("EEE d. MMM", "d.", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("ne", Formats.mapOf("MMM d, EEE", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("nl", Formats.mapOf("EEE d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("nn", Formats.mapOf("EEE d. MMM", "d.", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("no", Formats.mapOf("EEE d. MMM", "d.", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("no_NO", Formats.mapOf("EEE d. MMM", "d.", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("or", Formats.mapOf("EEE, MMM d", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("pa", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("pl", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("pt", Formats.mapOf("EEE, d 'de' MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("pt_BR", Formats.mapOf("EEE, d 'de' MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("pt_PT", Formats.mapOf("EEE, d/MM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("ro", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("ru", Formats.mapOf("ccc, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            String str = "y.";
            put("sh", Formats.mapOf("EEE d. MMM", "d", str));
            put("si", Formats.mapOf("MMM d EEE", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("sk", Formats.mapOf("EEE d. M.", "d.", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("sl", Formats.mapOf("EEE, d. MMM", "d.", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("sq", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("sr", Formats.mapOf("EEE d. MMM", "d", str));
            put("sr_Latn", Formats.mapOf("EEE d. MMM", "d", str));
            put("sv", Formats.mapOf("EEE d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("sw", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("ta", Formats.mapOf("MMM d, EEE", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("te", Formats.mapOf("d MMM, EEE", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("th", Formats.mapOf("EEE d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("tl", Formats.mapOf("EEE, MMM d", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("tr", Formats.mapOf("d MMMM EEE", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("uk", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("ur", Formats.mapOf("EEE، d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("uz", Formats.mapOf("EEE, d-MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("vi", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            String str2 = "d日";
            put("zh", Formats.mapOf("M月d日EEE", str2, "y年"));
            put("zh_CN", Formats.mapOf("M月d日EEE", str2, "y年"));
            put("zh_HK", Formats.mapOf("M月d日EEE", str2, "y年"));
            put("zh_TW", Formats.mapOf("M月d日 EEE", str2, "y年"));
            put("zu", Formats.mapOf("EEE, MMM d", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("en_ISO", Formats.mapOf("EEE, MMM d", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("en_MY", Formats.mapOf("EEE, d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("fr_CH", Formats.mapOf("EEE d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("it_CH", Formats.mapOf("EEE d MMM", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
            put("ps", Formats.mapOf("MMM d, EEE", "d", JWKParameterNames.ELLIPTIC_CURVE_Y_COORDINATE));
        }
    };

    public enum Format {
        MMMEd,
        d,
        y
    }

    public static String get(String str, Format format) throws FormatNotFoundException {
        try {
            return ((String) map.get(str).get(format)).replaceAll(",", "");
        } catch (NullPointerException unused) {
            throw new FormatNotFoundException();
        }
    }

    /* access modifiers changed from: private */
    public static EnumMap<Format, String> mapOf(String str, String str2, String str3) {
        return new EnumMap<Format, String>(Format.class, str, str2, str3) {
            final /* synthetic */ String val$MMMed;
            final /* synthetic */ String val$d;
            final /* synthetic */ String val$y;

            {
                this.val$MMMed = r2;
                this.val$d = r3;
                this.val$y = r4;
                put(Format.MMMEd, r2);
                put(Format.d, r3);
                put(Format.y, r4);
            }
        };
    }

    static class FormatNotFoundException extends Exception {
        FormatNotFoundException() {
        }
    }
}
