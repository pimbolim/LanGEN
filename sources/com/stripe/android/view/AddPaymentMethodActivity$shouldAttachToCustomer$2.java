package com.stripe.android.view;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddPaymentMethodActivity.kt */
final class AddPaymentMethodActivity$shouldAttachToCustomer$2 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ AddPaymentMethodActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddPaymentMethodActivity$shouldAttachToCustomer$2(AddPaymentMethodActivity addPaymentMethodActivity) {
        super(0);
        this.this$0 = addPaymentMethodActivity;
    }

    public final Boolean invoke() {
        return Boolean.valueOf(this.this$0.getPaymentMethodType().isReusable && this.this$0.getArgs().getShouldAttachToCustomer$payments_core_release());
    }
}
