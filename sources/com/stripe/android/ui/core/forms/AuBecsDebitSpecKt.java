package com.stripe.android.ui.core.forms;

import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import com.stripe.android.ui.core.R;
import com.stripe.android.ui.core.elements.AuBankAccountNumberSpec;
import com.stripe.android.ui.core.elements.AuBecsDebitMandateTextSpec;
import com.stripe.android.ui.core.elements.BillingSpecKt;
import com.stripe.android.ui.core.elements.BsbSpec;
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

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\"\u0016\u0010\u0000\u001a\u00020\u00018\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"$\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\"\"\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\"\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0014\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0014\u0010\u0018\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0014\u0010\u001a\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013¨\u0006\u001c"}, d2 = {"AuBecsDebitForm", "Lcom/stripe/android/ui/core/elements/LayoutSpec;", "getAuBecsDebitForm", "()Lcom/stripe/android/ui/core/elements/LayoutSpec;", "AuBecsDebitParamKey", "", "", "", "getAuBecsDebitParamKey", "()Ljava/util/Map;", "AuBecsDebitParams", "getAuBecsDebitParams", "auBecsBsbNumberSection", "Lcom/stripe/android/ui/core/elements/BsbSpec;", "getAuBecsBsbNumberSection", "()Lcom/stripe/android/ui/core/elements/BsbSpec;", "auBecsDebitAccountNumberSection", "Lcom/stripe/android/ui/core/elements/SectionSpec;", "getAuBecsDebitAccountNumberSection", "()Lcom/stripe/android/ui/core/elements/SectionSpec;", "auBecsDebitCustomMandate", "Lcom/stripe/android/ui/core/elements/AuBecsDebitMandateTextSpec;", "getAuBecsDebitCustomMandate", "()Lcom/stripe/android/ui/core/elements/AuBecsDebitMandateTextSpec;", "auBecsDebitEmailSection", "getAuBecsDebitEmailSection", "auBecsDebitNameSection", "getAuBecsDebitNameSection", "payments-ui-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuBecsDebitSpec.kt */
public final class AuBecsDebitSpecKt {
    private static final LayoutSpec AuBecsDebitForm;
    private static final Map<String, Object> AuBecsDebitParamKey;
    private static final Map<String, Object> AuBecsDebitParams;
    private static final BsbSpec auBecsBsbNumberSection;
    private static final SectionSpec auBecsDebitAccountNumberSection;
    private static final AuBecsDebitMandateTextSpec auBecsDebitCustomMandate;
    private static final SectionSpec auBecsDebitEmailSection;
    private static final SectionSpec auBecsDebitNameSection;

    public static final Map<String, Object> getAuBecsDebitParams() {
        return AuBecsDebitParams;
    }

    static {
        Map<String, Object> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("bsb_number", null), TuplesKt.to("account_number", null));
        AuBecsDebitParams = mutableMapOf;
        AuBecsDebitParamKey = MapsKt.mutableMapOf(TuplesKt.to("type", "au_becs_debit"), TuplesKt.to("au_becs_debit", mutableMapOf), TuplesKt.to("billing_details", BillingSpecKt.getBillingParams()));
        SectionSpec sectionSpec = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("name_section"), (SectionFieldSpec) new SimpleTextSpec(IdentifierSpec.Name.INSTANCE, R.string.au_becs_account_name, KeyboardCapitalization.Companion.m3667getWordsIUNYP9k(), KeyboardType.Companion.m3681getTextPjHm6EE(), false, 16, (DefaultConstructorMarker) null), (Integer) null, 4, (DefaultConstructorMarker) null);
        auBecsDebitNameSection = sectionSpec;
        SectionSpec sectionSpec2 = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("email_section"), (SectionFieldSpec) EmailSpec.INSTANCE, (Integer) null, 4, (DefaultConstructorMarker) null);
        auBecsDebitEmailSection = sectionSpec2;
        BsbSpec bsbSpec = new BsbSpec((IdentifierSpec) null, 1, (DefaultConstructorMarker) null);
        auBecsBsbNumberSection = bsbSpec;
        SectionSpec sectionSpec3 = new SectionSpec((IdentifierSpec) new IdentifierSpec.Generic("account_number"), (SectionFieldSpec) AuBankAccountNumberSpec.INSTANCE, (Integer) null, 4, (DefaultConstructorMarker) null);
        auBecsDebitAccountNumberSection = sectionSpec3;
        AuBecsDebitMandateTextSpec auBecsDebitMandateTextSpec = new AuBecsDebitMandateTextSpec(new IdentifierSpec.Generic("au_becs_mandate"));
        auBecsDebitCustomMandate = auBecsDebitMandateTextSpec;
        AuBecsDebitForm = LayoutSpec.Companion.create(sectionSpec2, bsbSpec, sectionSpec3, sectionSpec, auBecsDebitMandateTextSpec);
    }

    public static final Map<String, Object> getAuBecsDebitParamKey() {
        return AuBecsDebitParamKey;
    }

    public static final SectionSpec getAuBecsDebitNameSection() {
        return auBecsDebitNameSection;
    }

    public static final SectionSpec getAuBecsDebitEmailSection() {
        return auBecsDebitEmailSection;
    }

    public static final BsbSpec getAuBecsBsbNumberSection() {
        return auBecsBsbNumberSection;
    }

    public static final SectionSpec getAuBecsDebitAccountNumberSection() {
        return auBecsDebitAccountNumberSection;
    }

    public static final AuBecsDebitMandateTextSpec getAuBecsDebitCustomMandate() {
        return auBecsDebitCustomMandate;
    }

    public static final LayoutSpec getAuBecsDebitForm() {
        return AuBecsDebitForm;
    }
}
