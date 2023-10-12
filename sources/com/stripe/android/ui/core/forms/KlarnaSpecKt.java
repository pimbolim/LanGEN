package com.stripe.android.ui.core.forms;

import com.stripe.android.ui.core.elements.BillingSpecKt;
import com.stripe.android.ui.core.elements.EmailSpec;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import com.stripe.android.ui.core.elements.KlarnaCountrySpec;
import com.stripe.android.ui.core.elements.KlarnaHelper;
import com.stripe.android.ui.core.elements.LayoutSpec;
import com.stripe.android.ui.core.elements.SectionFieldSpec;
import com.stripe.android.ui.core.elements.SectionSpec;
import com.stripe.android.ui.core.elements.StaticTextSpec;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0016\u0010\u0000\u001a\u00020\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0014\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"KlarnaForm", "Lcom/stripe/android/ui/core/elements/LayoutSpec;", "getKlarnaForm", "()Lcom/stripe/android/ui/core/elements/LayoutSpec;", "KlarnaParamKey", "", "", "", "getKlarnaParamKey", "()Ljava/util/Map;", "klarnaBillingSection", "Lcom/stripe/android/ui/core/elements/SectionSpec;", "getKlarnaBillingSection", "()Lcom/stripe/android/ui/core/elements/SectionSpec;", "klarnaEmailSection", "getKlarnaEmailSection", "klarnaHeader", "Lcom/stripe/android/ui/core/elements/StaticTextSpec;", "getKlarnaHeader", "()Lcom/stripe/android/ui/core/elements/StaticTextSpec;", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: KlarnaSpec.kt */
public final class KlarnaSpecKt {
    private static final LayoutSpec KlarnaForm;
    private static final Map<String, Object> KlarnaParamKey = MapsKt.mutableMapOf(TuplesKt.to("type", "klarna"), TuplesKt.to("billing_details", BillingSpecKt.getBillingParams()));
    private static final SectionSpec klarnaBillingSection;
    private static final SectionSpec klarnaEmailSection;
    private static final StaticTextSpec klarnaHeader;

    public static final Map<String, Object> getKlarnaParamKey() {
        return KlarnaParamKey;
    }

    static {
        StaticTextSpec staticTextSpec = new StaticTextSpec(new IdentifierSpec.Generic("klarna_header"), KlarnaHelper.getKlarnaHeader$default(KlarnaHelper.INSTANCE, (Locale) null, 1, (Object) null));
        klarnaHeader = staticTextSpec;
        SectionSpec sectionSpec = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("email_section"), (SectionFieldSpec) EmailSpec.INSTANCE, (Integer) null, 4, (DefaultConstructorMarker) null);
        klarnaEmailSection = sectionSpec;
        SectionSpec sectionSpec2 = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("country_section"), (SectionFieldSpec) new KlarnaCountrySpec(), (Integer) null, 4, (DefaultConstructorMarker) null);
        klarnaBillingSection = sectionSpec2;
        KlarnaForm = LayoutSpec.Companion.create(staticTextSpec, sectionSpec, sectionSpec2);
    }

    public static final StaticTextSpec getKlarnaHeader() {
        return klarnaHeader;
    }

    public static final SectionSpec getKlarnaEmailSection() {
        return klarnaEmailSection;
    }

    public static final SectionSpec getKlarnaBillingSection() {
        return klarnaBillingSection;
    }

    public static final LayoutSpec getKlarnaForm() {
        return KlarnaForm;
    }
}
