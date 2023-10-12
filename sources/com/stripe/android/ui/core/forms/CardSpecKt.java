package com.stripe.android.ui.core.forms;

import com.stripe.android.ui.core.R;
import com.stripe.android.ui.core.elements.BillingSpecKt;
import com.stripe.android.ui.core.elements.CardBillingSpec;
import com.stripe.android.ui.core.elements.CardDetailsSpec;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import com.stripe.android.ui.core.elements.LayoutSpec;
import com.stripe.android.ui.core.elements.SaveForFutureUseSpec;
import com.stripe.android.ui.core.elements.SectionFieldSpec;
import com.stripe.android.ui.core.elements.SectionSpec;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0016\u0010\u0000\u001a\u00020\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\"\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0014\u0010\u0010\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"CardForm", "Lcom/stripe/android/ui/core/elements/LayoutSpec;", "getCardForm", "()Lcom/stripe/android/ui/core/elements/LayoutSpec;", "CardParamKey", "", "", "", "getCardParamKey", "()Ljava/util/Map;", "cardParams", "getCardParams", "creditBillingSection", "Lcom/stripe/android/ui/core/elements/SectionSpec;", "getCreditBillingSection", "()Lcom/stripe/android/ui/core/elements/SectionSpec;", "creditDetailsSection", "getCreditDetailsSection", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardSpec.kt */
public final class CardSpecKt {
    private static final LayoutSpec CardForm;
    private static final Map<String, Object> CardParamKey;
    private static final Map<String, Object> cardParams;
    private static final SectionSpec creditBillingSection;
    private static final SectionSpec creditDetailsSection;

    public static final Map<String, Object> getCardParams() {
        return cardParams;
    }

    static {
        Map<String, Object> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("number", null), TuplesKt.to("exp_month", null), TuplesKt.to("exp_year", null), TuplesKt.to("cvc", null));
        cardParams = mutableMapOf;
        CardParamKey = MapsKt.mutableMapOf(TuplesKt.to("type", "card"), TuplesKt.to("billing_details", BillingSpecKt.getBillingParams()), TuplesKt.to("card", mutableMapOf));
        SectionSpec sectionSpec = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("credit_details_section"), (SectionFieldSpec) CardDetailsSpec.INSTANCE, Integer.valueOf(R.string.card_information));
        creditDetailsSection = sectionSpec;
        SectionSpec sectionSpec2 = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("credit_billing_section"), (SectionFieldSpec) new CardBillingSpec((IdentifierSpec) null, BillingSpecKt.getSupportedBillingCountries(), 1, (DefaultConstructorMarker) null), Integer.valueOf(R.string.billing_details));
        creditBillingSection = sectionSpec2;
        CardForm = LayoutSpec.Companion.create(sectionSpec, sectionSpec2, new SaveForFutureUseSpec(CollectionsKt.emptyList()));
    }

    public static final Map<String, Object> getCardParamKey() {
        return CardParamKey;
    }

    public static final SectionSpec getCreditDetailsSection() {
        return creditDetailsSection;
    }

    public static final SectionSpec getCreditBillingSection() {
        return creditBillingSection;
    }

    public static final LayoutSpec getCardForm() {
        return CardForm;
    }
}
