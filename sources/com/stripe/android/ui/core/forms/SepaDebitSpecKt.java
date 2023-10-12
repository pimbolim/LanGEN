package com.stripe.android.ui.core.forms;

import com.stripe.android.model.PaymentMethod;
import com.stripe.android.ui.core.R;
import com.stripe.android.ui.core.elements.AddressSpec;
import com.stripe.android.ui.core.elements.BillingSpecKt;
import com.stripe.android.ui.core.elements.EmailSpec;
import com.stripe.android.ui.core.elements.IbanSpec;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import com.stripe.android.ui.core.elements.LayoutSpec;
import com.stripe.android.ui.core.elements.MandateTextSpec;
import com.stripe.android.ui.core.elements.SaveForFutureUseSpec;
import com.stripe.android.ui.core.elements.SectionFieldSpec;
import com.stripe.android.ui.core.elements.SectionSpec;
import com.stripe.android.ui.core.elements.SimpleTextSpec;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u0016\u0010\u0000\u001a\u00020\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0014\u0010\u0010\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0014\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0014\u0010\u0016\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\r\"\"\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\t¨\u0006\u001a"}, d2 = {"SepaDebitForm", "Lcom/stripe/android/ui/core/elements/LayoutSpec;", "getSepaDebitForm", "()Lcom/stripe/android/ui/core/elements/LayoutSpec;", "SepaDebitParamKey", "", "", "", "getSepaDebitParamKey", "()Ljava/util/Map;", "sepaBillingSection", "Lcom/stripe/android/ui/core/elements/SectionSpec;", "getSepaBillingSection", "()Lcom/stripe/android/ui/core/elements/SectionSpec;", "sepaDebitEmailSection", "getSepaDebitEmailSection", "sepaDebitIbanSection", "getSepaDebitIbanSection", "sepaDebitMandate", "Lcom/stripe/android/ui/core/elements/MandateTextSpec;", "getSepaDebitMandate", "()Lcom/stripe/android/ui/core/elements/MandateTextSpec;", "sepaDebitNameSection", "getSepaDebitNameSection", "sepaDebitParams", "getSepaDebitParams", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SepaDebitSpec.kt */
public final class SepaDebitSpecKt {
    private static final LayoutSpec SepaDebitForm;
    private static final Map<String, Object> SepaDebitParamKey;
    private static final SectionSpec sepaBillingSection;
    private static final SectionSpec sepaDebitEmailSection;
    private static final SectionSpec sepaDebitIbanSection;
    private static final MandateTextSpec sepaDebitMandate;
    private static final SectionSpec sepaDebitNameSection;
    private static final Map<String, Object> sepaDebitParams;

    public static final Map<String, Object> getSepaDebitParams() {
        return sepaDebitParams;
    }

    static {
        Map<String, Object> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("iban", null));
        sepaDebitParams = mutableMapOf;
        SepaDebitParamKey = MapsKt.mutableMapOf(TuplesKt.to("type", "sepa_debit"), TuplesKt.to("billing_details", BillingSpecKt.getBillingParams()), TuplesKt.to("sepa_debit", mutableMapOf));
        SectionSpec sectionSpec = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("name_section"), (SectionFieldSpec) SimpleTextSpec.Companion.getNAME(), (Integer) null, 4, (DefaultConstructorMarker) null);
        sepaDebitNameSection = sectionSpec;
        SectionSpec sectionSpec2 = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("email_section"), (SectionFieldSpec) EmailSpec.INSTANCE, (Integer) null, 4, (DefaultConstructorMarker) null);
        sepaDebitEmailSection = sectionSpec2;
        SectionSpec sectionSpec3 = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("iban_section"), (SectionFieldSpec) IbanSpec.INSTANCE, (Integer) null, 4, (DefaultConstructorMarker) null);
        sepaDebitIbanSection = sectionSpec3;
        MandateTextSpec mandateTextSpec = new MandateTextSpec(new IdentifierSpec.Generic("mandate"), R.string.sepa_mandate);
        sepaDebitMandate = mandateTextSpec;
        SectionSpec sectionSpec4 = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("billing_section"), (SectionFieldSpec) new AddressSpec(new IdentifierSpec.Generic(PaymentMethod.BillingDetails.PARAM_ADDRESS), BillingSpecKt.getSupportedBillingCountries()), Integer.valueOf(R.string.billing_details));
        sepaBillingSection = sectionSpec4;
        SepaDebitForm = LayoutSpec.Companion.create(sectionSpec, sectionSpec2, sectionSpec3, sectionSpec4, new SaveForFutureUseSpec(CollectionsKt.emptyList()), mandateTextSpec);
    }

    public static final Map<String, Object> getSepaDebitParamKey() {
        return SepaDebitParamKey;
    }

    public static final SectionSpec getSepaDebitNameSection() {
        return sepaDebitNameSection;
    }

    public static final SectionSpec getSepaDebitEmailSection() {
        return sepaDebitEmailSection;
    }

    public static final SectionSpec getSepaDebitIbanSection() {
        return sepaDebitIbanSection;
    }

    public static final MandateTextSpec getSepaDebitMandate() {
        return sepaDebitMandate;
    }

    public static final SectionSpec getSepaBillingSection() {
        return sepaBillingSection;
    }

    public static final LayoutSpec getSepaDebitForm() {
        return SepaDebitForm;
    }
}
