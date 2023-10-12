package com.stripe.android.ui.core.forms;

import com.stripe.android.ui.core.R;
import com.stripe.android.ui.core.elements.BankDropdownSpec;
import com.stripe.android.ui.core.elements.BillingSpecKt;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import com.stripe.android.ui.core.elements.LayoutSpec;
import com.stripe.android.ui.core.elements.SectionFieldSpec;
import com.stripe.android.ui.core.elements.SectionSpec;
import com.stripe.android.ui.core.elements.SimpleTextSpec;
import com.stripe.android.ui.core.elements.SupportedBankType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u0016\u0010\u0000\u001a\u00020\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r\"\"\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"EpsForm", "Lcom/stripe/android/ui/core/elements/LayoutSpec;", "getEpsForm", "()Lcom/stripe/android/ui/core/elements/LayoutSpec;", "EpsParamKey", "", "", "", "getEpsParamKey", "()Ljava/util/Map;", "epsBankSection", "Lcom/stripe/android/ui/core/elements/SectionSpec;", "getEpsBankSection", "()Lcom/stripe/android/ui/core/elements/SectionSpec;", "epsNameSection", "getEpsNameSection", "epsParams", "getEpsParams", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: EpsSpec.kt */
public final class EpsSpecKt {
    private static final LayoutSpec EpsForm;
    private static final Map<String, Object> EpsParamKey;
    private static final SectionSpec epsBankSection;
    private static final SectionSpec epsNameSection;
    private static final Map<String, Object> epsParams;

    public static final Map<String, Object> getEpsParams() {
        return epsParams;
    }

    static {
        Map<String, Object> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("bank", null));
        epsParams = mutableMapOf;
        EpsParamKey = MapsKt.mutableMapOf(TuplesKt.to("type", "eps"), TuplesKt.to("billing_details", BillingSpecKt.getBillingParams()), TuplesKt.to("eps", mutableMapOf));
        SectionSpec sectionSpec = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("name_section"), (SectionFieldSpec) SimpleTextSpec.Companion.getNAME(), (Integer) null, 4, (DefaultConstructorMarker) null);
        epsNameSection = sectionSpec;
        SectionSpec sectionSpec2 = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("bank_section"), (SectionFieldSpec) new BankDropdownSpec(new IdentifierSpec.Generic("bank"), R.string.eps_bank, SupportedBankType.Eps), (Integer) null, 4, (DefaultConstructorMarker) null);
        epsBankSection = sectionSpec2;
        EpsForm = LayoutSpec.Companion.create(sectionSpec, sectionSpec2);
    }

    public static final Map<String, Object> getEpsParamKey() {
        return EpsParamKey;
    }

    public static final SectionSpec getEpsNameSection() {
        return epsNameSection;
    }

    public static final SectionSpec getEpsBankSection() {
        return epsBankSection;
    }

    public static final LayoutSpec getEpsForm() {
        return EpsForm;
    }
}
