package com.stripe.android.ui.core.forms;

import com.stripe.android.ui.core.R;
import com.stripe.android.ui.core.elements.BankDropdownSpec;
import com.stripe.android.ui.core.elements.BillingSpecKt;
import com.stripe.android.ui.core.elements.EmailSpec;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import com.stripe.android.ui.core.elements.LayoutSpec;
import com.stripe.android.ui.core.elements.MandateTextSpec;
import com.stripe.android.ui.core.elements.SaveForFutureUseSpec;
import com.stripe.android.ui.core.elements.SectionFieldSpec;
import com.stripe.android.ui.core.elements.SectionSpec;
import com.stripe.android.ui.core.elements.SimpleTextSpec;
import com.stripe.android.ui.core.elements.SupportedBankType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u0016\u0010\u0000\u001a\u00020\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0014\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0014\u0010\u0014\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r\"\"\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\t¨\u0006\u0018"}, d2 = {"IdealForm", "Lcom/stripe/android/ui/core/elements/LayoutSpec;", "getIdealForm", "()Lcom/stripe/android/ui/core/elements/LayoutSpec;", "IdealParamKey", "", "", "", "getIdealParamKey", "()Ljava/util/Map;", "idealBankSection", "Lcom/stripe/android/ui/core/elements/SectionSpec;", "getIdealBankSection", "()Lcom/stripe/android/ui/core/elements/SectionSpec;", "idealEmailSection", "getIdealEmailSection", "idealMandate", "Lcom/stripe/android/ui/core/elements/MandateTextSpec;", "getIdealMandate", "()Lcom/stripe/android/ui/core/elements/MandateTextSpec;", "idealNameSection", "getIdealNameSection", "idealParams", "getIdealParams", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: IdealSpec.kt */
public final class IdealSpecKt {
    private static final LayoutSpec IdealForm;
    private static final Map<String, Object> IdealParamKey;
    private static final SectionSpec idealBankSection;
    private static final SectionSpec idealEmailSection;
    private static final MandateTextSpec idealMandate;
    private static final SectionSpec idealNameSection;
    private static final Map<String, Object> idealParams;

    public static final Map<String, Object> getIdealParams() {
        return idealParams;
    }

    static {
        Map<String, Object> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("bank", null));
        idealParams = mutableMapOf;
        IdealParamKey = MapsKt.mutableMapOf(TuplesKt.to("type", "ideal"), TuplesKt.to("billing_details", BillingSpecKt.getBillingParams()), TuplesKt.to("ideal", mutableMapOf));
        SectionSpec sectionSpec = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("name_section"), (SectionFieldSpec) SimpleTextSpec.Companion.getNAME(), (Integer) null, 4, (DefaultConstructorMarker) null);
        idealNameSection = sectionSpec;
        SectionSpec sectionSpec2 = new SectionSpec((IdentifierSpec) IdentifierSpec.Email.INSTANCE, (SectionFieldSpec) EmailSpec.INSTANCE, (Integer) null, 4, (DefaultConstructorMarker) null);
        idealEmailSection = sectionSpec2;
        SectionSpec sectionSpec3 = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("bank_section"), (SectionFieldSpec) new BankDropdownSpec(new IdentifierSpec.Generic("bank"), R.string.ideal_bank, SupportedBankType.Ideal), (Integer) null, 4, (DefaultConstructorMarker) null);
        idealBankSection = sectionSpec3;
        MandateTextSpec mandateTextSpec = new MandateTextSpec(new IdentifierSpec.Generic("mandate"), R.string.sepa_mandate);
        idealMandate = mandateTextSpec;
        IdealForm = LayoutSpec.Companion.create(sectionSpec, sectionSpec2, sectionSpec3, new SaveForFutureUseSpec(CollectionsKt.listOf(sectionSpec2, mandateTextSpec)), mandateTextSpec);
    }

    public static final Map<String, Object> getIdealParamKey() {
        return IdealParamKey;
    }

    public static final SectionSpec getIdealNameSection() {
        return idealNameSection;
    }

    public static final SectionSpec getIdealEmailSection() {
        return idealEmailSection;
    }

    public static final SectionSpec getIdealBankSection() {
        return idealBankSection;
    }

    public static final MandateTextSpec getIdealMandate() {
        return idealMandate;
    }

    public static final LayoutSpec getIdealForm() {
        return IdealForm;
    }
}
