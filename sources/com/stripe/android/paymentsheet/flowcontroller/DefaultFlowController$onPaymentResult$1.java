package com.stripe.android.paymentsheet.flowcontroller;

import com.stripe.android.payments.paymentlauncher.PaymentResult;
import com.stripe.android.paymentsheet.PaymentSheetResult;
import com.stripe.android.paymentsheet.PaymentSheetResultCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.flowcontroller.DefaultFlowController$onPaymentResult$1", f = "DefaultFlowController.kt", i = {}, l = {406}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DefaultFlowController.kt */
final class DefaultFlowController$onPaymentResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PaymentResult $paymentResult;
    Object L$0;
    int label;
    final /* synthetic */ DefaultFlowController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultFlowController$onPaymentResult$1(DefaultFlowController defaultFlowController, PaymentResult paymentResult, Continuation<? super DefaultFlowController$onPaymentResult$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultFlowController;
        this.$paymentResult = paymentResult;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultFlowController$onPaymentResult$1(this.this$0, this.$paymentResult, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultFlowController$onPaymentResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        PaymentSheetResultCallback paymentSheetResultCallback;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PaymentSheetResultCallback access$getPaymentResultCallback$p = this.this$0.paymentResultCallback;
            CoroutineContext access$getUiContext$p = this.this$0.uiContext;
            final DefaultFlowController defaultFlowController = this.this$0;
            final PaymentResult paymentResult = this.$paymentResult;
            this.L$0 = access$getPaymentResultCallback$p;
            this.label = 1;
            Object withContext = BuildersKt.withContext(access$getUiContext$p, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this);
            if (withContext == coroutine_suspended) {
                return coroutine_suspended;
            }
            paymentSheetResultCallback = access$getPaymentResultCallback$p;
            obj = withContext;
        } else if (i == 1) {
            paymentSheetResultCallback = (PaymentSheetResultCallback) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        paymentSheetResultCallback.onPaymentSheetResult((PaymentSheetResult) obj);
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/paymentsheet/PaymentSheetResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.stripe.android.paymentsheet.flowcontroller.DefaultFlowController$onPaymentResult$1$1", f = "DefaultFlowController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stripe.android.paymentsheet.flowcontroller.DefaultFlowController$onPaymentResult$1$1  reason: invalid class name */
    /* compiled from: DefaultFlowController.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PaymentSheetResult>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(defaultFlowController, paymentResult, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PaymentSheetResult> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return defaultFlowController.createPaymentSheetResult(paymentResult);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
