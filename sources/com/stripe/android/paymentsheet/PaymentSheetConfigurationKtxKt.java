package com.stripe.android.paymentsheet;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"validate", "", "Lcom/stripe/android/paymentsheet/PaymentSheet$Configuration;", "paymentsheet_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSheetConfigurationKtx.kt */
public final class PaymentSheetConfigurationKtxKt {
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        r0 = r0.getId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void validate(com.stripe.android.paymentsheet.PaymentSheet.Configuration r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = r3.getMerchantDisplayName()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 != 0) goto L_0x0057
            com.stripe.android.paymentsheet.PaymentSheet$CustomerConfiguration r0 = r3.getCustomer()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x001b
        L_0x0019:
            r0 = 0
            goto L_0x002b
        L_0x001b:
            java.lang.String r0 = r0.getId()
            if (r0 != 0) goto L_0x0022
            goto L_0x0019
        L_0x0022:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = kotlin.text.StringsKt.isBlank(r0)
            if (r0 != r1) goto L_0x0019
            r0 = 1
        L_0x002b:
            if (r0 != 0) goto L_0x004f
            com.stripe.android.paymentsheet.PaymentSheet$CustomerConfiguration r3 = r3.getCustomer()
            if (r3 != 0) goto L_0x0035
        L_0x0033:
            r1 = 0
            goto L_0x0044
        L_0x0035:
            java.lang.String r3 = r3.getEphemeralKeySecret()
            if (r3 != 0) goto L_0x003c
            goto L_0x0033
        L_0x003c:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            if (r3 != r1) goto L_0x0033
        L_0x0044:
            if (r1 != 0) goto L_0x0047
            return
        L_0x0047:
            java.security.InvalidParameterException r3 = new java.security.InvalidParameterException
            java.lang.String r0 = "When a CustomerConfiguration is passed to PaymentSheet, the ephemeralKeySecret cannot be an empty string."
            r3.<init>(r0)
            throw r3
        L_0x004f:
            java.security.InvalidParameterException r3 = new java.security.InvalidParameterException
            java.lang.String r0 = "When a CustomerConfiguration is passed to PaymentSheet, the Customer ID cannot be an empty string."
            r3.<init>(r0)
            throw r3
        L_0x0057:
            java.security.InvalidParameterException r3 = new java.security.InvalidParameterException
            java.lang.String r0 = "When a Configuration is passed to PaymentSheet, the Merchant display name cannot be an empty string."
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.PaymentSheetConfigurationKtxKt.validate(com.stripe.android.paymentsheet.PaymentSheet$Configuration):void");
    }
}
