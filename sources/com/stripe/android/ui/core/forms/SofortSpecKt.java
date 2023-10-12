package com.stripe.android.ui.core.forms;

import com.stripe.android.ui.core.R;
import com.stripe.android.ui.core.elements.BillingSpecKt;
import com.stripe.android.ui.core.elements.CountrySpec;
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
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u0016\u0010\u0000\u001a\u00020\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0014\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0014\u0010\u0014\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r\"\"\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\t¨\u0006\u0018"}, d2 = {"SofortForm", "Lcom/stripe/android/ui/core/elements/LayoutSpec;", "getSofortForm", "()Lcom/stripe/android/ui/core/elements/LayoutSpec;", "SofortParamKey", "", "", "", "getSofortParamKey", "()Ljava/util/Map;", "sofortCountrySection", "Lcom/stripe/android/ui/core/elements/SectionSpec;", "getSofortCountrySection", "()Lcom/stripe/android/ui/core/elements/SectionSpec;", "sofortEmailSection", "getSofortEmailSection", "sofortMandate", "Lcom/stripe/android/ui/core/elements/MandateTextSpec;", "getSofortMandate", "()Lcom/stripe/android/ui/core/elements/MandateTextSpec;", "sofortNameSection", "getSofortNameSection", "sofortParams", "getSofortParams", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SofortSpec.kt */
public final class SofortSpecKt {
    private static final LayoutSpec SofortForm;
    private static final Map<String, Object> SofortParamKey;
    private static final SectionSpec sofortCountrySection;
    private static final SectionSpec sofortEmailSection;
    private static final MandateTextSpec sofortMandate;
    private static final SectionSpec sofortNameSection;
    private static final Map<String, Object> sofortParams;

    public static final Map<String, Object> getSofortParams() {
        return sofortParams;
    }

    static {
        Map<String, Object> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("country", null));
        sofortParams = mutableMapOf;
        SofortParamKey = MapsKt.mutableMapOf(TuplesKt.to("type", "sofort"), TuplesKt.to("billing_details", BillingSpecKt.getBillingParams()), TuplesKt.to("sofort", mutableMapOf));
        SectionSpec sectionSpec = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("name_section"), (SectionFieldSpec) SimpleTextSpec.Companion.getNAME(), (Integer) null, 4, (DefaultConstructorMarker) null);
        sofortNameSection = sectionSpec;
        SectionSpec sectionSpec2 = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("email_section"), (SectionFieldSpec) EmailSpec.INSTANCE, (Integer) null, 4, (DefaultConstructorMarker) null);
        sofortEmailSection = sectionSpec2;
        SectionSpec sectionSpec3 = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("country_section"), (SectionFieldSpec) new CountrySpec(SetsKt.setOf("AT", "BE", "DE", "ES", "IT", "NL")), (Integer) null, 4, (DefaultConstructorMarker) null);
        sofortCountrySection = sectionSpec3;
        MandateTextSpec mandateTextSpec = new MandateTextSpec(new IdentifierSpec.Generic("mandate"), R.string.sepa_mandate);
        sofortMandate = mandateTextSpec;
        SofortForm = LayoutSpec.Companion.create(sectionSpec, sectionSpec2, sectionSpec3, new SaveForFutureUseSpec(CollectionsKt.listOf(sectionSpec, sectionSpec2, mandateTextSpec)), mandateTextSpec);
    }

    public static final Map<String, Object> getSofortParamKey() {
        return SofortParamKey;
    }

    public static final SectionSpec getSofortNameSection() {
        return sofortNameSection;
    }

    public static final SectionSpec getSofortEmailSection() {
        return sofortEmailSection;
    }

    public static final SectionSpec getSofortCountrySection() {
        return sofortCountrySection;
    }

    public static final MandateTextSpec getSofortMandate() {
        return sofortMandate;
    }

    public static final LayoutSpec getSofortForm() {
        return SofortForm;
    }
}
