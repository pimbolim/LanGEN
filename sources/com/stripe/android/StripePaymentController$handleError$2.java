package com.stripe.android;

import com.stripe.android.PaymentRelayStarter;
import com.stripe.android.core.exception.StripeException;
import com.stripe.android.view.AuthActivityStarterHost;
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
@DebugMetadata(c = "com.stripe.android.StripePaymentController$handleError$2", f = "StripePaymentController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StripePaymentController.kt */
final class StripePaymentController$handleError$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AuthActivityStarterHost $host;
    final /* synthetic */ int $requestCode;
    final /* synthetic */ Throwable $throwable;
    int label;
    final /* synthetic */ StripePaymentController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripePaymentController$handleError$2(StripePaymentController stripePaymentController, AuthActivityStarterHost authActivityStarterHost, Throwable th, int i, Continuation<? super StripePaymentController$handleError$2> continuation) {
        super(2, continuation);
        this.this$0 = stripePaymentController;
        this.$host = authActivityStarterHost;
        this.$throwable = th;
        this.$requestCode = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new StripePaymentController$handleError$2(this.this$0, this.$host, this.$throwable, this.$requestCode, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StripePaymentController$handleError$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ((PaymentRelayStarter) this.this$0.paymentRelayStarterFactory.invoke(this.$host)).start(new PaymentRelayStarter.Args.ErrorArgs(StripeException.Companion.create(this.$throwable), this.$requestCode));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
