package com.stripe.android.googlepaylauncher;

import com.google.android.gms.tasks.Task;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher;
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
@DebugMetadata(c = "com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherActivity$onCreate$2", f = "GooglePayPaymentMethodLauncherActivity.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GooglePayPaymentMethodLauncherActivity.kt */
final class GooglePayPaymentMethodLauncherActivity$onCreate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GooglePayPaymentMethodLauncherActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GooglePayPaymentMethodLauncherActivity$onCreate$2(GooglePayPaymentMethodLauncherActivity googlePayPaymentMethodLauncherActivity, Continuation<? super GooglePayPaymentMethodLauncherActivity$onCreate$2> continuation) {
        super(2, continuation);
        this.this$0 = googlePayPaymentMethodLauncherActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GooglePayPaymentMethodLauncherActivity$onCreate$2 googlePayPaymentMethodLauncherActivity$onCreate$2 = new GooglePayPaymentMethodLauncherActivity$onCreate$2(this.this$0, continuation);
        googlePayPaymentMethodLauncherActivity$onCreate$2.L$0 = obj;
        return googlePayPaymentMethodLauncherActivity$onCreate$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GooglePayPaymentMethodLauncherActivity$onCreate$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            GooglePayPaymentMethodLauncherActivity googlePayPaymentMethodLauncherActivity = this.this$0;
            Result.Companion companion = Result.Companion;
            GooglePayPaymentMethodLauncherViewModel access$getViewModel = googlePayPaymentMethodLauncherActivity.getViewModel();
            this.label = 1;
            obj = access$getViewModel.createLoadPaymentDataTask(this);
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
        obj2 = Result.m4709constructorimpl((Task) obj);
        GooglePayPaymentMethodLauncherActivity googlePayPaymentMethodLauncherActivity2 = this.this$0;
        Throwable r1 = Result.m4712exceptionOrNullimpl(obj2);
        if (r1 == null) {
            googlePayPaymentMethodLauncherActivity2.launchGooglePay((Task) obj2);
            googlePayPaymentMethodLauncherActivity2.getViewModel().setHasLaunched$payments_core_release(true);
        } else {
            googlePayPaymentMethodLauncherActivity2.updateResult(new GooglePayPaymentMethodLauncher.Result.Failed(r1, 1));
        }
        return Unit.INSTANCE;
    }
}
