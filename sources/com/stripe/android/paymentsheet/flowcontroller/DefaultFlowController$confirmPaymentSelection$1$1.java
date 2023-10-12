package com.stripe.android.paymentsheet.flowcontroller;

import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.ConfirmSetupIntentParams;
import com.stripe.android.model.ConfirmStripeIntentParams;
import com.stripe.android.payments.paymentlauncher.PaymentLauncher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.flowcontroller.DefaultFlowController$confirmPaymentSelection$1$1", f = "DefaultFlowController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DefaultFlowController.kt */
final class DefaultFlowController$confirmPaymentSelection$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ConfirmStripeIntentParams $confirmParams;
    int label;
    final /* synthetic */ DefaultFlowController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultFlowController$confirmPaymentSelection$1$1(ConfirmStripeIntentParams confirmStripeIntentParams, DefaultFlowController defaultFlowController, Continuation<? super DefaultFlowController$confirmPaymentSelection$1$1> continuation) {
        super(2, continuation);
        this.$confirmParams = confirmStripeIntentParams;
        this.this$0 = defaultFlowController;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultFlowController$confirmPaymentSelection$1$1(this.$confirmParams, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultFlowController$confirmPaymentSelection$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        PaymentLauncher access$getPaymentLauncher$p;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ConfirmStripeIntentParams confirmStripeIntentParams = this.$confirmParams;
            if (confirmStripeIntentParams instanceof ConfirmPaymentIntentParams) {
                PaymentLauncher access$getPaymentLauncher$p2 = this.this$0.paymentLauncher;
                if (access$getPaymentLauncher$p2 != null) {
                    access$getPaymentLauncher$p2.confirm((ConfirmPaymentIntentParams) this.$confirmParams);
                }
            } else if ((confirmStripeIntentParams instanceof ConfirmSetupIntentParams) && (access$getPaymentLauncher$p = this.this$0.paymentLauncher) != null) {
                access$getPaymentLauncher$p.confirm((ConfirmSetupIntentParams) this.$confirmParams);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
