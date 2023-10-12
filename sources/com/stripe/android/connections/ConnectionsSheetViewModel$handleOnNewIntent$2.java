package com.stripe.android.connections;

import android.content.Intent;
import com.stripe.android.connections.model.LinkAccountSessionManifest;
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
@DebugMetadata(c = "com.stripe.android.connections.ConnectionsSheetViewModel$handleOnNewIntent$2", f = "ConnectionsSheetViewModel.kt", i = {}, l = {191, 192}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ConnectionsSheetViewModel.kt */
final class ConnectionsSheetViewModel$handleOnNewIntent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Intent $intent;
    int label;
    final /* synthetic */ ConnectionsSheetViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConnectionsSheetViewModel$handleOnNewIntent$2(ConnectionsSheetViewModel connectionsSheetViewModel, Intent intent, Continuation<? super ConnectionsSheetViewModel$handleOnNewIntent$2> continuation) {
        super(2, continuation);
        this.this$0 = connectionsSheetViewModel;
        this.$intent = intent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConnectionsSheetViewModel$handleOnNewIntent$2(this.this$0, this.$intent, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConnectionsSheetViewModel$handleOnNewIntent$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LinkAccountSessionManifest manifest = ((ConnectionsSheetState) this.this$0._state.getValue()).getManifest();
            Intent intent = this.$intent;
            String str2 = null;
            String valueOf = String.valueOf(intent == null ? null : intent.getData());
            if (manifest == null) {
                str = null;
            } else {
                str = manifest.getSuccessUrl();
            }
            if (Intrinsics.areEqual((Object) valueOf, (Object) str)) {
                this.this$0.fetchLinkAccountSession();
            } else {
                if (manifest != null) {
                    str2 = manifest.getCancelUrl();
                }
                if (Intrinsics.areEqual((Object) valueOf, (Object) str2)) {
                    this.label = 1;
                    if (this.this$0.onUserCancel(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    this.label = 2;
                    if (this.this$0.onFatal(new Exception("Error processing ConnectionsSheet intent"), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        } else if (i == 1 || i == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
