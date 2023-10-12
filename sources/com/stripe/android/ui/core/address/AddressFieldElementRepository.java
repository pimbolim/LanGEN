package com.stripe.android.ui.core.address;

import android.content.res.AssetManager;
import android.content.res.Resources;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import com.stripe.android.ui.core.elements.SectionFieldElement;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Singleton
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0011\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J#\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0001¢\u0006\u0002\b\u0010J\u001f\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\u0012J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\"\u0010\u0013\u001a\u00020\r2\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\b0\u0017H\u0002R\"\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/ui/core/address/AddressFieldElementRepository;", "", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "countryFieldMap", "", "", "", "Lcom/stripe/android/ui/core/elements/SectionFieldElement;", "getResources", "()Landroid/content/res/Resources;", "add", "", "countryCode", "listElements", "add$payments_ui_core_release", "get", "get$payments_ui_core_release", "initialize", "schema", "Ljava/io/ByteArrayInputStream;", "countryAddressSchemaPair", "", "Lcom/stripe/android/ui/core/address/CountryAddressSchema;", "Companion", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddressFieldElementRepository.kt */
public final class AddressFieldElementRepository {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DEFAULT_COUNTRY_CODE = "ZZ";
    /* access modifiers changed from: private */
    public static final Set<String> supportedCountries = SetsKt.setOf("AC", "AD", "AE", "AF", "AG", "AI", "AL", "AM", "AO", "AQ", "AR", "AT", "AU", "AW", "AX", "AZ", "BA", "BB", "BD", "BE", "BF", "BG", "BH", "BI", "BJ", "BL", "BM", "BN", "BO", "BQ", "BR", "BS", "BT", "BV", "BW", "BY", "BZ", "CA", "CD", "CF", "CG", "CH", "CI", "CK", "CL", "CM", "CN", "CO", "CR", "CV", "CW", "CY", "CZ", "DE", "DJ", "DK", "DM", "DO", "DZ", "EC", "EE", "EG", "EH", "ER", "ES", "ET", "FI", "FJ", "FK", "FO", "FR", "GA", "GB", "GD", "GE", "GF", "GG", "GH", "GI", "GL", "GM", "GN", "GP", "GQ", "GR", "GS", "GT", "GU", "GW", "GY", "HK", "HN", "HR", "HT", "HU", "ID", "IE", "IL", "IM", "IN", "IO", "IQ", "IS", "IT", "JE", "JM", "JO", "JP", "KE", ExpandedProductParsedResult.KILOGRAM, "KH", "KI", "KM", "KN", "KR", "KW", "KY", "KZ", "LA", ExpandedProductParsedResult.POUND, "LC", "LI", "LK", "LR", "LS", "LT", "LU", "LV", "LY", "MA", "MC", "MD", "ME", "MF", "MG", "MK", "ML", "MM", "MN", "MO", "MQ", "MR", "MS", "MT", "MU", "MV", "MW", "MX", "MY", "MZ", "NA", "NC", "NE", "NG", "NI", "NL", "NO", "NP", "NR", "NU", "NZ", "OM", "PA", "PE", "PF", "PG", "PH", "PK", "PL", "PM", "PN", "PR", "PS", "PT", "PY", "QA", "RE", "RO", "RS", "RU", "RW", "SA", "SB", "SC", "SE", "SG", "SH", "SI", "SJ", "SK", "SL", "SM", "SN", "SO", "SR", "SS", "ST", "SV", "SX", "SZ", "TA", "TC", "TD", "TF", "TG", "TH", "TJ", "TK", "TL", "TM", "TN", "TO", "TR", "TT", "TV", "TW", "TZ", "UA", "UG", "US", "UY", "UZ", "VA", "VC", "VE", "VG", "VN", "VU", "WF", "WS", "XK", "YE", "YT", "ZA", "ZM", "ZW", DEFAULT_COUNTRY_CODE);
    private final Map<String, List<SectionFieldElement>> countryFieldMap = new LinkedHashMap();
    private final Resources resources;

    @Inject
    public AddressFieldElementRepository(Resources resources2) {
        AssetManager assets;
        this.resources = resources2;
        Iterable iterable = supportedCountries;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next : iterable) {
            linkedHashMap.put(next, "addressinfo/" + ((String) next) + ".json");
        }
        Map map = linkedHashMap;
        Map linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            String str = (String) entry.getValue();
            Resources resources3 = getResources();
            InputStream inputStream = null;
            if (!(resources3 == null || (assets = resources3.getAssets()) == null)) {
                inputStream = assets.open(str);
            }
            List<CountryAddressSchema> parseAddressesSchema = TransformAddressToElementKt.parseAddressesSchema(inputStream);
            if (parseAddressesSchema != null) {
                linkedHashMap2.put(key, parseAddressesSchema);
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        initialize(linkedHashMap2);
    }

    public final Resources getResources() {
        return this.resources;
    }

    public final List<SectionFieldElement> get$payments_ui_core_release(String str) {
        List<SectionFieldElement> list = str == null ? null : this.countryFieldMap.get(str);
        return list == null ? this.countryFieldMap.get(DEFAULT_COUNTRY_CODE) : list;
    }

    public final void initialize(String str, ByteArrayInputStream byteArrayInputStream) {
        Intrinsics.checkNotNullParameter(str, "countryCode");
        Intrinsics.checkNotNullParameter(byteArrayInputStream, "schema");
        List<CountryAddressSchema> parseAddressesSchema = TransformAddressToElementKt.parseAddressesSchema(byteArrayInputStream);
        Intrinsics.checkNotNull(parseAddressesSchema);
        initialize(MapsKt.mapOf(TuplesKt.to(str, parseAddressesSchema)));
    }

    public final void add$payments_ui_core_release(String str, List<? extends SectionFieldElement> list) {
        Intrinsics.checkNotNullParameter(str, "countryCode");
        Intrinsics.checkNotNullParameter(list, "listElements");
        this.countryFieldMap.put(str, list);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/ui/core/address/AddressFieldElementRepository$Companion;", "", "()V", "DEFAULT_COUNTRY_CODE", "", "getDEFAULT_COUNTRY_CODE$payments_ui_core_release$annotations", "supportedCountries", "", "getSupportedCountries$payments_ui_core_release$annotations", "getSupportedCountries$payments_ui_core_release", "()Ljava/util/Set;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AddressFieldElementRepository.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDEFAULT_COUNTRY_CODE$payments_ui_core_release$annotations() {
        }

        public static /* synthetic */ void getSupportedCountries$payments_ui_core_release$annotations() {
        }

        private Companion() {
        }

        public final Set<String> getSupportedCountries$payments_ui_core_release() {
            return AddressFieldElementRepository.supportedCountries;
        }
    }

    private final void initialize(Map<String, ? extends List<CountryAddressSchema>> map) {
        Collection arrayList = new ArrayList(map.size());
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            List<SectionFieldElement> transformToElementList = TransformAddressToElementKt.transformToElementList((List) next.getValue());
            if (transformToElementList != null) {
                arrayList.add(TuplesKt.to(str, transformToElementList));
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        for (Pair pair : (List) arrayList) {
            add$payments_ui_core_release((String) pair.getFirst(), (List) pair.getSecond());
        }
    }
}
