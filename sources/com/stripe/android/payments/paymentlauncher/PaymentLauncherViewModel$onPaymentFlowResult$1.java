package com.stripe.android.payments.paymentlauncher;

import com.stripe.android.StripeIntentResult;
import com.stripe.android.payments.PaymentFlowResult;
import com.stripe.android.payments.PaymentFlowResultProcessor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.payments.paymentlauncher.PaymentLauncherViewModel$onPaymentFlowResult$1", f = "PaymentLauncherViewModel.kt", i = {}, l = {201, 204, 209}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PaymentLauncherViewModel.kt */
final class PaymentLauncherViewModel$onPaymentFlowResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PaymentFlowResult.Unvalidated $paymentFlowResult;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PaymentLauncherViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentLauncherViewModel$onPaymentFlowResult$1(PaymentLauncherViewModel paymentLauncherViewModel, PaymentFlowResult.Unvalidated unvalidated, Continuation<? super PaymentLauncherViewModel$onPaymentFlowResult$1> continuation) {
        super(2, continuation);
        this.this$0 = paymentLauncherViewModel;
        this.$paymentFlowResult = unvalidated;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PaymentLauncherViewModel$onPaymentFlowResult$1 paymentLauncherViewModel$onPaymentFlowResult$1 = new PaymentLauncherViewModel$onPaymentFlowResult$1(this.this$0, this.$paymentFlowResult, continuation);
        paymentLauncherViewModel$onPaymentFlowResult$1.L$0 = obj;
        return paymentLauncherViewModel$onPaymentFlowResult$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PaymentLauncherViewModel$onPaymentFlowResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        PaymentFlowResultProcessor paymentFlowResultProcessor;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            PaymentLauncherViewModel paymentLauncherViewModel = this.this$0;
            PaymentFlowResult.Unvalidated unvalidated = this.$paymentFlowResult;
            Result.Companion companion = Result.Companion;
            if (paymentLauncherViewModel.isPaymentIntent) {
                paymentFlowResultProcessor = (PaymentFlowResultProcessor) paymentLauncherViewModel.lazyPaymentIntentFlowResultProcessor.get();
            } else {
                paymentFlowResultProcessor = (PaymentFlowResultProcessor) paymentLauncherViewModel.lazySetupIntentFlowResultProcessor.get();
            }
            this.label = 1;
            obj = paymentFlowResultProcessor.processResult(unvalidated, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
        } else if (i == 2 || i == 3) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m4709constructorimpl((StripeIntentResult) obj);
        PaymentLauncherViewModel paymentLauncherViewModel2 = this.this$0;
        Throwable r4 = Result.m4712exceptionOrNullimpl(obj2);
        if (r4 == null) {
            this.label = 2;
            if (BuildersKt.withContext(paymentLauncherViewModel2.uiContext, new PaymentLauncherViewModel$onPaymentFlowResult$1$2$1(paymentLauncherViewModel2, (StripeIntentResult) obj2, (Continuation<? super PaymentLauncherViewModel$onPaymentFlowResult$1$2$1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            this.label = 3;
            if (BuildersKt.withContext(paymentLauncherViewModel2.uiContext, new PaymentLauncherViewModel$onPaymentFlowResult$1$3$1(paymentLauncherViewModel2, r4, (Continuation<? super PaymentLauncherViewModel$onPaymentFlowResult$1$3$1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
