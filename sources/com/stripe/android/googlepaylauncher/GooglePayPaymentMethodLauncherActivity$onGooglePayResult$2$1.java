package com.stripe.android.googlepaylauncher;

import com.google.android.gms.wallet.PaymentData;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherActivity$onGooglePayResult$2$1", f = "GooglePayPaymentMethodLauncherActivity.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GooglePayPaymentMethodLauncherActivity.kt */
final class GooglePayPaymentMethodLauncherActivity$onGooglePayResult$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PaymentData $paymentData;
    Object L$0;
    int label;
    final /* synthetic */ GooglePayPaymentMethodLauncherActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GooglePayPaymentMethodLauncherActivity$onGooglePayResult$2$1(GooglePayPaymentMethodLauncherActivity googlePayPaymentMethodLauncherActivity, PaymentData paymentData, Continuation<? super GooglePayPaymentMethodLauncherActivity$onGooglePayResult$2$1> continuation) {
        super(2, continuation);
        this.this$0 = googlePayPaymentMethodLauncherActivity;
        this.$paymentData = paymentData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GooglePayPaymentMethodLauncherActivity$onGooglePayResult$2$1(this.this$0, this.$paymentData, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GooglePayPaymentMethodLauncherActivity$onGooglePayResult$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        GooglePayPaymentMethodLauncherActivity googlePayPaymentMethodLauncherActivity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            GooglePayPaymentMethodLauncherActivity googlePayPaymentMethodLauncherActivity2 = this.this$0;
            GooglePayPaymentMethodLauncherViewModel access$getViewModel = googlePayPaymentMethodLauncherActivity2.getViewModel();
            PaymentData paymentData = this.$paymentData;
            Intrinsics.checkNotNullExpressionValue(paymentData, "paymentData");
            this.L$0 = googlePayPaymentMethodLauncherActivity2;
            this.label = 1;
            Object createPaymentMethod = access$getViewModel.createPaymentMethod(paymentData, this);
            if (createPaymentMethod == coroutine_suspended) {
                return coroutine_suspended;
            }
            googlePayPaymentMethodLauncherActivity = googlePayPaymentMethodLauncherActivity2;
            obj = createPaymentMethod;
        } else if (i == 1) {
            googlePayPaymentMethodLauncherActivity = (GooglePayPaymentMethodLauncherActivity) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        googlePayPaymentMethodLauncherActivity.finishWithResult((GooglePayPaymentMethodLauncher.Result) obj);
        return Unit.INSTANCE;
    }
}
