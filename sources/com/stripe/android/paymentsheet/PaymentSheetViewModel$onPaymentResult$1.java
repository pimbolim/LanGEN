package com.stripe.android.paymentsheet;

import com.stripe.android.model.StripeIntent;
import com.stripe.android.payments.paymentlauncher.PaymentResult;
import com.stripe.android.paymentsheet.model.ClientSecret;
import com.stripe.android.paymentsheet.repositories.StripeIntentRepository;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.PaymentSheetViewModel$onPaymentResult$1", f = "PaymentSheetViewModel.kt", i = {}, l = {413}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PaymentSheetViewModel.kt */
final class PaymentSheetViewModel$onPaymentResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PaymentResult $paymentResult;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PaymentSheetViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentSheetViewModel$onPaymentResult$1(PaymentSheetViewModel paymentSheetViewModel, PaymentResult paymentResult, Continuation<? super PaymentSheetViewModel$onPaymentResult$1> continuation) {
        super(2, continuation);
        this.this$0 = paymentSheetViewModel;
        this.$paymentResult = paymentResult;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PaymentSheetViewModel$onPaymentResult$1 paymentSheetViewModel$onPaymentResult$1 = new PaymentSheetViewModel$onPaymentResult$1(this.this$0, this.$paymentResult, continuation);
        paymentSheetViewModel$onPaymentResult$1.L$0 = obj;
        return paymentSheetViewModel$onPaymentResult$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PaymentSheetViewModel$onPaymentResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            PaymentSheetViewModel paymentSheetViewModel = this.this$0;
            Result.Companion companion = Result.Companion;
            StripeIntentRepository access$getStripeIntentRepository$p = paymentSheetViewModel.stripeIntentRepository;
            ClientSecret clientSecret$paymentsheet_release = paymentSheetViewModel.getArgs$paymentsheet_release().getClientSecret$paymentsheet_release();
            this.label = 1;
            obj = access$getStripeIntentRepository$p.get(clientSecret$paymentsheet_release, this);
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
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m4709constructorimpl((StripeIntent) obj);
        PaymentSheetViewModel paymentSheetViewModel2 = this.this$0;
        PaymentResult paymentResult = this.$paymentResult;
        Throwable r2 = Result.m4712exceptionOrNullimpl(obj2);
        if (r2 == null) {
            paymentSheetViewModel2.processPayment((StripeIntent) obj2, paymentResult);
        } else {
            paymentSheetViewModel2.onFatal(r2);
        }
        return Unit.INSTANCE;
    }
}
