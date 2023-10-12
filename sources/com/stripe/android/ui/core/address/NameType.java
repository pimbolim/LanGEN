package com.stripe.android.ui.core.address;

import com.stripe.android.ui.core.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006 "}, d2 = {"Lcom/stripe/android/ui/core/address/NameType;", "", "stringResId", "", "(Ljava/lang/String;II)V", "getStringResId", "()I", "area", "cedex", "city", "country", "county", "department", "district", "do_si", "eircode", "emirate", "island", "neighborhood", "oblast", "parish", "pin", "post_town", "postal", "prefecture", "province", "state", "suburb", "suburb_or_city", "townland", "village_township", "zip", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TransformAddressToElement.kt */
public enum NameType {
    area(R.string.address_label_hk_area),
    cedex(R.string.address_label_cedex),
    city(R.string.address_label_city),
    country(R.string.address_label_country),
    county(R.string.address_label_county),
    department(R.string.address_label_department),
    district(R.string.address_label_district),
    do_si(R.string.address_label_kr_do_si),
    eircode(R.string.address_label_ie_eircode),
    emirate(R.string.address_label_ae_emirate),
    island(R.string.address_label_island),
    neighborhood(R.string.address_label_neighborhood),
    oblast(R.string.address_label_oblast),
    parish(R.string.address_label_bb_jm_parish),
    pin(R.string.address_label_in_pin),
    post_town(R.string.address_label_post_town),
    postal(R.string.address_label_postal_code),
    prefecture(R.string.address_label_jp_prefecture),
    province(R.string.address_label_province),
    state(R.string.address_label_state),
    suburb(R.string.address_label_suburb),
    suburb_or_city(R.string.address_label_au_suburb_or_city),
    townland(R.string.address_label_ie_townland),
    village_township(R.string.address_label_village_township),
    zip(R.string.address_label_zip_code);
    
    private final int stringResId;

    private NameType(int i) {
        this.stringResId = i;
    }

    public final int getStringResId() {
        return this.stringResId;
    }
}
