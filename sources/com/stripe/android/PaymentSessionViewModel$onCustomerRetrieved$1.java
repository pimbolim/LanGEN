package com.stripe.android;

import com.nimbusds.jose.shaded.ow2asm.Opcodes;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.ShippingInformation;
import com.stripe.android.model.ShippingMethod;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSessionViewModel.kt */
final class PaymentSessionViewModel$onCustomerRetrieved$1 extends Lambda implements Function1<PaymentMethod, Unit> {
    final /* synthetic */ Function0<Unit> $onComplete;
    final /* synthetic */ PaymentSessionViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentSessionViewModel$onCustomerRetrieved$1(Function0<Unit> function0, PaymentSessionViewModel paymentSessionViewModel) {
        super(1);
        this.$onComplete = function0;
        this.this$0 = paymentSessionViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PaymentMethod) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PaymentMethod paymentMethod) {
        if (paymentMethod != null) {
            PaymentSessionViewModel paymentSessionViewModel = this.this$0;
            paymentSessionViewModel.setPaymentSessionData(PaymentSessionData.copy$default(paymentSessionViewModel.getPaymentSessionData(), false, false, 0, 0, (ShippingInformation) null, (ShippingMethod) null, paymentMethod, false, Opcodes.ATHROW, (Object) null));
        }
        this.$onComplete.invoke();
    }
}
