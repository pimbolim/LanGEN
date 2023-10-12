package com.stripe.android.ui.core.forms;

import com.stripe.android.ui.core.elements.BillingSpecKt;
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

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0016\u0010\u0000\u001a\u00020\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"GiropayForm", "Lcom/stripe/android/ui/core/elements/LayoutSpec;", "getGiropayForm", "()Lcom/stripe/android/ui/core/elements/LayoutSpec;", "GiropayParamKey", "", "", "", "getGiropayParamKey", "()Ljava/util/Map;", "giropayNameSection", "Lcom/stripe/android/ui/core/elements/SectionSpec;", "getGiropayNameSection", "()Lcom/stripe/android/ui/core/elements/SectionSpec;", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: GiropaySpec.kt */
public final class GiropaySpecKt {
    private static final LayoutSpec GiropayForm;
    private static final Map<String, Object> GiropayParamKey = MapsKt.mutableMapOf(TuplesKt.to("type", "giropay"), TuplesKt.to("billing_details", BillingSpecKt.getBillingParams()));
    private static final SectionSpec giropayNameSection;

    public static final Map<String, Object> getGiropayParamKey() {
        return GiropayParamKey;
    }

    static {
        SectionSpec sectionSpec = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("name_section"), (SectionFieldSpec) SimpleTextSpec.Companion.getNAME(), (Integer) null, 4, (DefaultConstructorMarker) null);
        giropayNameSection = sectionSpec;
        GiropayForm = LayoutSpec.Companion.create(sectionSpec);
    }

    public static final SectionSpec getGiropayNameSection() {
        return giropayNameSection;
    }

    public static final LayoutSpec getGiropayForm() {
        return GiropayForm;
    }
}
