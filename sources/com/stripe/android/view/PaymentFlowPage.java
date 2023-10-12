package com.stripe.android.view;

import com.stripe.android.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/view/PaymentFlowPage;", "", "titleResId", "", "(Ljava/lang/String;II)V", "getTitleResId", "()I", "ShippingInfo", "ShippingMethod", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentFlowPage.kt */
public enum PaymentFlowPage {
    ShippingInfo(R.string.title_add_an_address),
    ShippingMethod(R.string.title_select_shipping_method);
    
    private final int titleResId;

    private PaymentFlowPage(int i) {
        this.titleResId = i;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }
}
