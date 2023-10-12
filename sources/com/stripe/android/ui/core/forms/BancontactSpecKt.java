package com.stripe.android.ui.core.forms;

import com.stripe.android.ui.core.R;
import com.stripe.android.ui.core.elements.BillingSpecKt;
import com.stripe.android.ui.core.elements.EmailSpec;
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

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0016\u0010\u0000\u001a\u00020\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0014\u0010\u0012\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u0014"}, d2 = {"BancontactForm", "Lcom/stripe/android/ui/core/elements/LayoutSpec;", "getBancontactForm", "()Lcom/stripe/android/ui/core/elements/LayoutSpec;", "BancontactParamKey", "", "", "", "getBancontactParamKey", "()Ljava/util/Map;", "bancontactEmailSection", "Lcom/stripe/android/ui/core/elements/SectionSpec;", "getBancontactEmailSection", "()Lcom/stripe/android/ui/core/elements/SectionSpec;", "bancontactMandate", "Lcom/stripe/android/ui/core/elements/MandateTextSpec;", "getBancontactMandate", "()Lcom/stripe/android/ui/core/elements/MandateTextSpec;", "bancontactNameSection", "getBancontactNameSection", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: BancontactSpec.kt */
public final class BancontactSpecKt {
    private static final LayoutSpec BancontactForm;
    private static final Map<String, Object> BancontactParamKey = MapsKt.mutableMapOf(TuplesKt.to("type", "bancontact"), TuplesKt.to("billing_details", BillingSpecKt.getBillingParams()));
    private static final SectionSpec bancontactEmailSection;
    private static final MandateTextSpec bancontactMandate;
    private static final SectionSpec bancontactNameSection;

    public static final Map<String, Object> getBancontactParamKey() {
        return BancontactParamKey;
    }

    static {
        SectionSpec sectionSpec = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("name_section"), (SectionFieldSpec) SimpleTextSpec.Companion.getNAME(), (Integer) null, 4, (DefaultConstructorMarker) null);
        bancontactNameSection = sectionSpec;
        SectionSpec sectionSpec2 = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("email_section"), (SectionFieldSpec) EmailSpec.INSTANCE, (Integer) null, 4, (DefaultConstructorMarker) null);
        bancontactEmailSection = sectionSpec2;
        MandateTextSpec mandateTextSpec = new MandateTextSpec(new IdentifierSpec.Generic("mandate"), R.string.sepa_mandate);
        bancontactMandate = mandateTextSpec;
        BancontactForm = LayoutSpec.Companion.create(sectionSpec, sectionSpec2, new SaveForFutureUseSpec(CollectionsKt.listOf(sectionSpec2, mandateTextSpec)), mandateTextSpec);
    }

    public static final SectionSpec getBancontactNameSection() {
        return bancontactNameSection;
    }

    public static final SectionSpec getBancontactEmailSection() {
        return bancontactEmailSection;
    }

    public static final MandateTextSpec getBancontactMandate() {
        return bancontactMandate;
    }

    public static final LayoutSpec getBancontactForm() {
        return BancontactForm;
    }
}
