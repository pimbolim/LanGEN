package com.stripe.android.googlepaylauncher;

import android.content.Intent;
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
@DebugMetadata(c = "com.stripe.android.googlepaylauncher.GooglePayLauncherActivity$onActivityResult$1", f = "GooglePayLauncherActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GooglePayLauncherActivity.kt */
final class GooglePayLauncherActivity$onActivityResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Intent $data;
    final /* synthetic */ int $requestCode;
    int label;
    final /* synthetic */ GooglePayLauncherActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GooglePayLauncherActivity$onActivityResult$1(GooglePayLauncherActivity googlePayLauncherActivity, int i, Intent intent, Continuation<? super GooglePayLauncherActivity$onActivityResult$1> continuation) {
        super(2, continuation);
        this.this$0 = googlePayLauncherActivity;
        this.$requestCode = i;
        this.$data = intent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GooglePayLauncherActivity$onActivityResult$1(this.this$0, this.$requestCode, this.$data, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GooglePayLauncherActivity$onActivityResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            GooglePayLauncherViewModel access$getViewModel = this.this$0.getViewModel();
            int i = this.$requestCode;
            Intent intent = this.$data;
            if (intent == null) {
                intent = new Intent();
            }
            access$getViewModel.onConfirmResult(i, intent);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
