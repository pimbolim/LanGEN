package com.stripe.android.paymentsheet;

import com.stripe.android.model.ConfirmStripeIntentParams;
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
@DebugMetadata(c = "com.stripe.android.paymentsheet.PaymentSheetActivity$onCreate$7$1", f = "PaymentSheetActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PaymentSheetActivity.kt */
final class PaymentSheetActivity$onCreate$7$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ConfirmStripeIntentParams $confirmParams;
    int label;
    final /* synthetic */ PaymentSheetActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentSheetActivity$onCreate$7$1(PaymentSheetActivity paymentSheetActivity, ConfirmStripeIntentParams confirmStripeIntentParams, Continuation<? super PaymentSheetActivity$onCreate$7$1> continuation) {
        super(2, continuation);
        this.this$0 = paymentSheetActivity;
        this.$confirmParams = confirmStripeIntentParams;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaymentSheetActivity$onCreate$7$1(this.this$0, this.$confirmParams, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PaymentSheetActivity$onCreate$7$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getViewModel().confirmStripeIntent(this.$confirmParams);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
