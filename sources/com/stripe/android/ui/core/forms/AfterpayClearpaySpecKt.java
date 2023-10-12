package com.stripe.android.ui.core.forms;

import com.stripe.android.model.PaymentMethod;
import com.stripe.android.ui.core.R;
import com.stripe.android.ui.core.elements.AddressSpec;
import com.stripe.android.ui.core.elements.AfterpayClearpayTextSpec;
import com.stripe.android.ui.core.elements.BillingSpecKt;
import com.stripe.android.ui.core.elements.EmailSpec;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import com.stripe.android.ui.core.elements.LayoutSpec;
import com.stripe.android.ui.core.elements.SectionFieldSpec;
import com.stripe.android.ui.core.elements.SectionSpec;
import com.stripe.android.ui.core.elements.SimpleTextSpec;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0016\u0010\u0000\u001a\u00020\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0014\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0014\u0010\u0014\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006\u0016"}, d2 = {"AfterpayClearpayForm", "Lcom/stripe/android/ui/core/elements/LayoutSpec;", "getAfterpayClearpayForm", "()Lcom/stripe/android/ui/core/elements/LayoutSpec;", "AfterpayClearpayParamKey", "", "", "", "getAfterpayClearpayParamKey", "()Ljava/util/Map;", "afterpayClearpayBillingSection", "Lcom/stripe/android/ui/core/elements/SectionSpec;", "getAfterpayClearpayBillingSection", "()Lcom/stripe/android/ui/core/elements/SectionSpec;", "afterpayClearpayEmailSection", "getAfterpayClearpayEmailSection", "afterpayClearpayHeader", "Lcom/stripe/android/ui/core/elements/AfterpayClearpayTextSpec;", "getAfterpayClearpayHeader", "()Lcom/stripe/android/ui/core/elements/AfterpayClearpayTextSpec;", "afterpayClearpayNameSection", "getAfterpayClearpayNameSection", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AfterpayClearpaySpec.kt */
public final class AfterpayClearpaySpecKt {
    private static final LayoutSpec AfterpayClearpayForm;
    private static final Map<String, Object> AfterpayClearpayParamKey = MapsKt.mutableMapOf(TuplesKt.to("type", "afterpay_clearpay"), TuplesKt.to("billing_details", BillingSpecKt.getBillingParams()));
    private static final SectionSpec afterpayClearpayBillingSection;
    private static final SectionSpec afterpayClearpayEmailSection;
    private static final AfterpayClearpayTextSpec afterpayClearpayHeader;
    private static final SectionSpec afterpayClearpayNameSection;

    public static final Map<String, Object> getAfterpayClearpayParamKey() {
        return AfterpayClearpayParamKey;
    }

    static {
        AfterpayClearpayTextSpec afterpayClearpayTextSpec = new AfterpayClearpayTextSpec(new IdentifierSpec.Generic("afterpay_clearpay_header"));
        afterpayClearpayHeader = afterpayClearpayTextSpec;
        SectionSpec sectionSpec = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("name_section"), (SectionFieldSpec) SimpleTextSpec.Companion.getNAME(), (Integer) null, 4, (DefaultConstructorMarker) null);
        afterpayClearpayNameSection = sectionSpec;
        SectionSpec sectionSpec2 = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("email_section"), (SectionFieldSpec) EmailSpec.INSTANCE, (Integer) null, 4, (DefaultConstructorMarker) null);
        afterpayClearpayEmailSection = sectionSpec2;
        SectionSpec sectionSpec3 = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("address_section"), (SectionFieldSpec) new AddressSpec(new IdentifierSpec.Generic(PaymentMethod.BillingDetails.PARAM_ADDRESS), BillingSpecKt.getSupportedBillingCountries()), Integer.valueOf(R.string.billing_details));
        afterpayClearpayBillingSection = sectionSpec3;
        AfterpayClearpayForm = LayoutSpec.Companion.create(afterpayClearpayTextSpec, sectionSpec, sectionSpec2, sectionSpec3);
    }

    public static final AfterpayClearpayTextSpec getAfterpayClearpayHeader() {
        return afterpayClearpayHeader;
    }

    public static final SectionSpec getAfterpayClearpayNameSection() {
        return afterpayClearpayNameSection;
    }

    public static final SectionSpec getAfterpayClearpayEmailSection() {
        return afterpayClearpayEmailSection;
    }

    public static final SectionSpec getAfterpayClearpayBillingSection() {
        return afterpayClearpayBillingSection;
    }

    public static final LayoutSpec getAfterpayClearpayForm() {
        return AfterpayClearpayForm;
    }
}
