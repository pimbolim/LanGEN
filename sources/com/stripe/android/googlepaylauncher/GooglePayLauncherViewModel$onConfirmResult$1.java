package com.stripe.android.googlepaylauncher;

import android.content.Intent;
import com.stripe.android.googlepaylauncher.GooglePayLauncher;
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
@DebugMetadata(c = "com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel$onConfirmResult$1", f = "GooglePayLauncherViewModel.kt", i = {}, l = {184}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GooglePayLauncherViewModel.kt */
final class GooglePayLauncherViewModel$onConfirmResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Intent $data;
    final /* synthetic */ int $requestCode;
    int label;
    final /* synthetic */ GooglePayLauncherViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GooglePayLauncherViewModel$onConfirmResult$1(GooglePayLauncherViewModel googlePayLauncherViewModel, int i, Intent intent, Continuation<? super GooglePayLauncherViewModel$onConfirmResult$1> continuation) {
        super(2, continuation);
        this.this$0 = googlePayLauncherViewModel;
        this.$requestCode = i;
        this.$data = intent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GooglePayLauncherViewModel$onConfirmResult$1(this.this$0, this.$requestCode, this.$data, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GooglePayLauncherViewModel$onConfirmResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getResultFromConfirmation$payments_core_release(this.$requestCode, this.$data, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0._googleResult.postValue((GooglePayLauncher.Result) obj);
        return Unit.INSTANCE;
    }
}
