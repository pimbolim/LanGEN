package com.stripe.android.ui.core.forms;

import com.stripe.android.ui.core.R;
import com.stripe.android.ui.core.elements.BankDropdownSpec;
import com.stripe.android.ui.core.elements.BillingSpecKt;
import com.stripe.android.ui.core.elements.EmailSpec;
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

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\"\u0016\u0010\u0000\u001a\u00020\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0014\u0010\u0010\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r\"\"\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\t¨\u0006\u0014"}, d2 = {"P24Form", "Lcom/stripe/android/ui/core/elements/LayoutSpec;", "getP24Form", "()Lcom/stripe/android/ui/core/elements/LayoutSpec;", "P24ParamKey", "", "", "", "getP24ParamKey", "()Ljava/util/Map;", "p24BankSection", "Lcom/stripe/android/ui/core/elements/SectionSpec;", "getP24BankSection", "()Lcom/stripe/android/ui/core/elements/SectionSpec;", "p24EmailSection", "getP24EmailSection", "p24NameSection", "getP24NameSection", "p24Params", "getP24Params", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: P24Spec.kt */
public final class P24SpecKt {
    private static final LayoutSpec P24Form;
    private static final Map<String, Object> P24ParamKey;
    private static final SectionSpec p24BankSection;
    private static final SectionSpec p24EmailSection;
    private static final SectionSpec p24NameSection;
    private static final Map<String, Object> p24Params;

    public static final Map<String, Object> getP24Params() {
        return p24Params;
    }

    static {
        Map<String, Object> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("bank", null));
        p24Params = mutableMapOf;
        P24ParamKey = MapsKt.mutableMapOf(TuplesKt.to("type", "p24"), TuplesKt.to("billing_details", BillingSpecKt.getBillingParams()), TuplesKt.to("p24", mutableMapOf));
        SectionSpec sectionSpec = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("name_section"), (SectionFieldSpec) SimpleTextSpec.Companion.getNAME(), (Integer) null, 4, (DefaultConstructorMarker) null);
        p24NameSection = sectionSpec;
        SectionSpec sectionSpec2 = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("email_section"), (SectionFieldSpec) EmailSpec.INSTANCE, (Integer) null, 4, (DefaultConstructorMarker) null);
        p24EmailSection = sectionSpec2;
        SectionSpec sectionSpec3 = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("bank_section"), (SectionFieldSpec) new BankDropdownSpec(new IdentifierSpec.Generic("bank"), R.string.p24_bank, SupportedBankType.P24), (Integer) null, 4, (DefaultConstructorMarker) null);
        p24BankSection = sectionSpec3;
        P24Form = LayoutSpec.Companion.create(sectionSpec, sectionSpec2, sectionSpec3);
    }

    public static final Map<String, Object> getP24ParamKey() {
        return P24ParamKey;
    }

    public static final SectionSpec getP24NameSection() {
        return p24NameSection;
    }

    public static final SectionSpec getP24EmailSection() {
        return p24EmailSection;
    }

    public static final SectionSpec getP24BankSection() {
        return p24BankSection;
    }

    public static final LayoutSpec getP24Form() {
        return P24Form;
    }
}
