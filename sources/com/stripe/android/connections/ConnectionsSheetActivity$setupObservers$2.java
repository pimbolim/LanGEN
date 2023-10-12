package com.stripe.android.connections;

import com.stripe.android.connections.ConnectionsSheetViewEffect;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.SharedFlow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.connections.ConnectionsSheetActivity$setupObservers$2", f = "ConnectionsSheetActivity.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ConnectionsSheetActivity.kt */
final class ConnectionsSheetActivity$setupObservers$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ConnectionsSheetActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConnectionsSheetActivity$setupObservers$2(ConnectionsSheetActivity connectionsSheetActivity, Continuation<? super ConnectionsSheetActivity$setupObservers$2> continuation) {
        super(2, continuation);
        this.this$0 = connectionsSheetActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConnectionsSheetActivity$setupObservers$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConnectionsSheetActivity$setupObservers$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SharedFlow<ConnectionsSheetViewEffect> viewEffect$connections_release = this.this$0.getViewModel().getViewEffect$connections_release();
            final ConnectionsSheetActivity connectionsSheetActivity = this.this$0;
            this.label = 1;
            if (viewEffect$connections_release.collect(new Object() {
                public final Object emit(ConnectionsSheetViewEffect connectionsSheetViewEffect, Continuation<? super Unit> continuation) {
                    if (connectionsSheetViewEffect instanceof ConnectionsSheetViewEffect.OpenAuthFlowWithUrl) {
                        connectionsSheetActivity.launch((ConnectionsSheetViewEffect.OpenAuthFlowWithUrl) connectionsSheetViewEffect);
                    } else if (connectionsSheetViewEffect instanceof ConnectionsSheetViewEffect.FinishWithResult) {
                        connectionsSheetActivity.finishWithResult(((ConnectionsSheetViewEffect.FinishWithResult) connectionsSheetViewEffect).getResult());
                    }
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
