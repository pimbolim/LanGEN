package com.stripe.android.payments.paymentlauncher;

import com.stripe.android.StripeIntentResult;
import com.stripe.android.model.StripeIntent;
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
@DebugMetadata(c = "com.stripe.android.payments.paymentlauncher.PaymentLauncherViewModel$onPaymentFlowResult$1$2$1", f = "PaymentLauncherViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PaymentLauncherViewModel.kt */
final class PaymentLauncherViewModel$onPaymentFlowResult$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ StripeIntentResult<StripeIntent> $it;
    int label;
    final /* synthetic */ PaymentLauncherViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentLauncherViewModel$onPaymentFlowResult$1$2$1(PaymentLauncherViewModel paymentLauncherViewModel, StripeIntentResult<? extends StripeIntent> stripeIntentResult, Continuation<? super PaymentLauncherViewModel$onPaymentFlowResult$1$2$1> continuation) {
        super(2, continuation);
        this.this$0 = paymentLauncherViewModel;
        this.$it = stripeIntentResult;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaymentLauncherViewModel$onPaymentFlowResult$1$2$1(this.this$0, this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PaymentLauncherViewModel$onPaymentFlowResult$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.postResult(this.$it);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
