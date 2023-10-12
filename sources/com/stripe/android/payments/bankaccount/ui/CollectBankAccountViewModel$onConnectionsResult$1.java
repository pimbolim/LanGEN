package com.stripe.android.payments.bankaccount.ui;

import com.stripe.android.connections.ConnectionsSheetResult;
import com.stripe.android.payments.bankaccount.navigation.CollectBankAccountResult;
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
@DebugMetadata(c = "com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel$onConnectionsResult$1", f = "CollectBankAccountViewModel.kt", i = {}, l = {82, 84}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CollectBankAccountViewModel.kt */
final class CollectBankAccountViewModel$onConnectionsResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ConnectionsSheetResult $result;
    int label;
    final /* synthetic */ CollectBankAccountViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CollectBankAccountViewModel$onConnectionsResult$1(ConnectionsSheetResult connectionsSheetResult, CollectBankAccountViewModel collectBankAccountViewModel, Continuation<? super CollectBankAccountViewModel$onConnectionsResult$1> continuation) {
        super(2, continuation);
        this.$result = connectionsSheetResult;
        this.this$0 = collectBankAccountViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CollectBankAccountViewModel$onConnectionsResult$1(this.$result, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CollectBankAccountViewModel$onConnectionsResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ConnectionsSheetResult connectionsSheetResult = this.$result;
            if (connectionsSheetResult instanceof ConnectionsSheetResult.Canceled) {
                this.label = 1;
                if (this.this$0.finishWithResult(CollectBankAccountResult.Cancelled.INSTANCE, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (connectionsSheetResult instanceof ConnectionsSheetResult.Failed) {
                this.label = 2;
                if (this.this$0.finishWithError(((ConnectionsSheetResult.Failed) connectionsSheetResult).getError(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (connectionsSheetResult instanceof ConnectionsSheetResult.Completed) {
                this.this$0.attachLinkAccountSessionToIntent(((ConnectionsSheetResult.Completed) connectionsSheetResult).getLinkAccountSession().getId());
            }
        } else if (i == 1 || i == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
