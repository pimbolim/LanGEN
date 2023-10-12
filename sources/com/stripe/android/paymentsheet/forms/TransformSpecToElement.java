package com.stripe.android.paymentsheet.forms;

import com.stripe.android.ui.core.elements.FormElement;
import com.stripe.android.ui.core.elements.FormItemSpec;
import com.stripe.android.ui.core.forms.TransformSpecToElements;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH\u0000¢\u0006\u0002\b\u0010R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/paymentsheet/forms/TransformSpecToElement;", "", "resourceRepository", "Lcom/stripe/android/ui/core/forms/resources/ResourceRepository;", "formFragmentArguments", "Lcom/stripe/android/paymentsheet/paymentdatacollection/FormFragmentArguments;", "context", "Landroid/content/Context;", "(Lcom/stripe/android/ui/core/forms/resources/ResourceRepository;Lcom/stripe/android/paymentsheet/paymentdatacollection/FormFragmentArguments;Landroid/content/Context;)V", "transformSpecToElements", "Lcom/stripe/android/ui/core/forms/TransformSpecToElements;", "transform", "", "Lcom/stripe/android/ui/core/elements/FormElement;", "list", "Lcom/stripe/android/ui/core/elements/FormItemSpec;", "transform$paymentsheet_release", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TransformSpecToElement.kt */
public final class TransformSpecToElement {
    private final TransformSpecToElements transformSpecToElements;

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0025, code lost:
        r1 = r1.getAddress();
     */
    @javax.inject.Inject
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TransformSpecToElement(com.stripe.android.ui.core.forms.resources.ResourceRepository r10, com.stripe.android.paymentsheet.paymentdatacollection.FormFragmentArguments r11, android.content.Context r12) {
        /*
            r9 = this;
            java.lang.String r0 = "resourceRepository"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "formFragmentArguments"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r9.<init>()
            com.stripe.android.ui.core.forms.TransformSpecToElements r0 = new com.stripe.android.ui.core.forms.TransformSpecToElements
            java.util.Map r3 = com.stripe.android.paymentsheet.paymentdatacollection.FormFragmentArgumentsKt.getInitialValuesMap(r11)
            com.stripe.android.ui.core.Amount r4 = r11.getAmount()
            com.stripe.android.paymentsheet.PaymentSheet$BillingDetails r1 = r11.getBillingDetails()
            r2 = 0
            if (r1 != 0) goto L_0x0025
        L_0x0023:
            r5 = r2
            goto L_0x0031
        L_0x0025:
            com.stripe.android.paymentsheet.PaymentSheet$Address r1 = r1.getAddress()
            if (r1 != 0) goto L_0x002c
            goto L_0x0023
        L_0x002c:
            java.lang.String r1 = r1.getCountry()
            r5 = r1
        L_0x0031:
            boolean r6 = r11.getShowCheckboxControlledFields()
            java.lang.String r7 = r11.getMerchantName()
            r1 = r0
            r2 = r10
            r8 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r9.transformSpecToElements = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.forms.TransformSpecToElement.<init>(com.stripe.android.ui.core.forms.resources.ResourceRepository, com.stripe.android.paymentsheet.paymentdatacollection.FormFragmentArguments, android.content.Context):void");
    }

    public final List<FormElement> transform$paymentsheet_release(List<? extends FormItemSpec> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return this.transformSpecToElements.transform(list);
    }
}
