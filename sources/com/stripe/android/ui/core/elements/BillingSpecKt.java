package com.stripe.android.ui.core.elements;

import com.braintreepayments.api.models.PostalAddressParser;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import com.stripe.android.model.PaymentMethod;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0003\"\"\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\"\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005\"\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"addressParams", "", "", "", "getAddressParams", "()Ljava/util/Map;", "billingParams", "getBillingParams", "supportedBillingCountries", "", "getSupportedBillingCountries", "()Ljava/util/Set;", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BillingSpec.kt */
public final class BillingSpecKt {
    private static final Map<String, Object> addressParams;
    private static final Map<String, Object> billingParams;
    private static final Set<String> supportedBillingCountries = SetsKt.setOf("AD", "AE", "AF", "AG", "AI", "AL", "AM", "AO", "AQ", "AR", "AT", "AU", "AW", "AX", "AZ", "BA", "BB", "BD", "BE", "BF", "BG", "BH", "BI", "BJ", "BL", "BM", "BN", "BO", "BQ", "BR", "BS", "BT", "BV", "BW", "BY", "BZ", "CA", "CD", "CF", "CG", "CH", "CI", "CK", "CL", "CM", "CN", "CO", "CR", "CV", "CW", "CY", "CZ", "DE", "DJ", "DK", "DM", "DO", "DZ", "EC", "EE", "EG", "EH", "ER", "ES", "ET", "FI", "FJ", "FK", "FO", "FR", "GA", "GB", "GD", "GE", "GF", "GG", "GH", "GI", "GL", "GM", "GN", "GP", "GQ", "GR", "GS", "GT", "GU", "GW", "GY", "HK", "HN", "HR", "HT", "HU", "ID", "IE", "IL", "IM", "IN", "IO", "IQ", "IS", "IT", "JE", "JM", "JO", "JP", "KE", ExpandedProductParsedResult.KILOGRAM, "KH", "KI", "KM", "KN", "KR", "KW", "KY", "KZ", "LA", ExpandedProductParsedResult.POUND, "LC", "LI", "LK", "LR", "LS", "LT", "LU", "LV", "LY", "MA", "MC", "MD", "ME", "MF", "MG", "MK", "ML", "MM", "MN", "MO", "MQ", "MR", "MS", "MT", "MU", "MV", "MW", "MX", "MY", "MZ", "NA", "NC", "NE", "NG", "NI", "NL", "NO", "NP", "NR", "NU", "NZ", "OM", "PA", "PE", "PF", "PG", "PH", "PK", "PL", "PM", "PN", "PR", "PS", "PT", "PY", "QA", "RE", "RO", "RS", "RU", "RW", "SA", "SB", "SC", "SE", "SG", "SH", "SI", "SJ", "SK", "SL", "SM", "SN", "SO", "SR", "SS", "ST", "SV", "SX", "SZ", "TA", "TC", "TD", "TF", "TG", "TH", "TJ", "TK", "TL", "TM", "TN", "TO", "TR", "TT", "TV", "TW", "TZ", "UA", "UG", "US", "UY", "UZ", "VA", "VC", "VE", "VG", "VN", "VU", "WF", "WS", "XK", "YE", "YT", "ZA", "ZM", "ZW");

    public static final Map<String, Object> getAddressParams() {
        return addressParams;
    }

    static {
        Map<String, Object> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(PostalAddressParser.LOCALITY_KEY, null), TuplesKt.to("country", null), TuplesKt.to(PostalAddressParser.LINE_1_KEY, null), TuplesKt.to(PostalAddressParser.LINE_2_KEY, null), TuplesKt.to(PostalAddressParser.POSTAL_CODE_UNDERSCORE_KEY, null), TuplesKt.to(PostalAddressParser.REGION_KEY, null));
        addressParams = mutableMapOf;
        billingParams = MapsKt.mutableMapOf(TuplesKt.to(PaymentMethod.BillingDetails.PARAM_ADDRESS, mutableMapOf), TuplesKt.to("name", null), TuplesKt.to("email", null), TuplesKt.to("phone", null));
    }

    public static final Map<String, Object> getBillingParams() {
        return billingParams;
    }

    public static final Set<String> getSupportedBillingCountries() {
        return supportedBillingCountries;
    }
}
