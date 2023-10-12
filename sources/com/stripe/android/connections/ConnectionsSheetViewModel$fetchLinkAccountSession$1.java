package com.stripe.android.connections;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.connections.ConnectionsSheetViewModel$fetchLinkAccountSession$1", f = "ConnectionsSheetViewModel.kt", i = {}, l = {143, 147, 149}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ConnectionsSheetViewModel.kt */
final class ConnectionsSheetViewModel$fetchLinkAccountSession$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ConnectionsSheetViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConnectionsSheetViewModel$fetchLinkAccountSession$1(ConnectionsSheetViewModel connectionsSheetViewModel, Continuation<? super ConnectionsSheetViewModel$fetchLinkAccountSession$1> continuation) {
        super(2, continuation);
        this.this$0 = connectionsSheetViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConnectionsSheetViewModel$fetchLinkAccountSession$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConnectionsSheetViewModel$fetchLinkAccountSession$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0099  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0028
            if (r1 == r4) goto L_0x0024
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x00a4
        L_0x0016:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x001e:
            java.lang.Object r1 = r7.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0090
        L_0x0024:
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x004f }
            goto L_0x0048
        L_0x0028:
            kotlin.ResultKt.throwOnFailure(r8)
            com.stripe.android.connections.ConnectionsSheetViewModel r8 = r7.this$0
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x004f }
            com.stripe.android.connections.domain.FetchLinkAccountSession r1 = r8.fetchLinkAccountSession     // Catch:{ all -> 0x004f }
            com.stripe.android.connections.ConnectionsSheetContract$Args r8 = r8.starterArgs     // Catch:{ all -> 0x004f }
            com.stripe.android.connections.ConnectionsSheet$Configuration r8 = r8.getConfiguration()     // Catch:{ all -> 0x004f }
            java.lang.String r8 = r8.getLinkAccountSessionClientSecret()     // Catch:{ all -> 0x004f }
            r7.label = r4     // Catch:{ all -> 0x004f }
            java.lang.Object r8 = r1.invoke(r8, r7)     // Catch:{ all -> 0x004f }
            if (r8 != r0) goto L_0x0048
            return r0
        L_0x0048:
            com.stripe.android.connections.model.LinkAccountSession r8 = (com.stripe.android.connections.model.LinkAccountSession) r8     // Catch:{ all -> 0x004f }
            java.lang.Object r8 = kotlin.Result.m4709constructorimpl(r8)     // Catch:{ all -> 0x004f }
            goto L_0x005a
        L_0x004f:
            r8 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r8 = kotlin.Result.m4709constructorimpl(r8)
        L_0x005a:
            r1 = r8
            com.stripe.android.connections.ConnectionsSheetViewModel r8 = r7.this$0
            boolean r4 = kotlin.Result.m4716isSuccessimpl(r1)
            if (r4 == 0) goto L_0x0090
            r4 = r1
            com.stripe.android.connections.model.LinkAccountSession r4 = (com.stripe.android.connections.model.LinkAccountSession) r4
            com.stripe.android.connections.ConnectionsSheetResult$Completed r5 = new com.stripe.android.connections.ConnectionsSheetResult$Completed
            r5.<init>(r4)
            com.stripe.android.connections.analytics.ConnectionsEventReporter r4 = r8.eventReporter
            com.stripe.android.connections.ConnectionsSheetContract$Args r6 = r8.starterArgs
            com.stripe.android.connections.ConnectionsSheet$Configuration r6 = r6.getConfiguration()
            com.stripe.android.connections.ConnectionsSheetResult r5 = (com.stripe.android.connections.ConnectionsSheetResult) r5
            r4.onResult(r6, r5)
            kotlinx.coroutines.flow.MutableSharedFlow r8 = r8._viewEffect
            com.stripe.android.connections.ConnectionsSheetViewEffect$FinishWithResult r4 = new com.stripe.android.connections.ConnectionsSheetViewEffect$FinishWithResult
            r4.<init>(r5)
            r7.L$0 = r1
            r7.label = r3
            java.lang.Object r8 = r8.emit(r4, r7)
            if (r8 != r0) goto L_0x0090
            return r0
        L_0x0090:
            com.stripe.android.connections.ConnectionsSheetViewModel r8 = r7.this$0
            java.lang.Throwable r3 = kotlin.Result.m4712exceptionOrNullimpl(r1)
            if (r3 != 0) goto L_0x0099
            goto L_0x00a4
        L_0x0099:
            r7.L$0 = r1
            r7.label = r2
            java.lang.Object r8 = r8.onFatal(r3, r7)
            if (r8 != r0) goto L_0x00a4
            return r0
        L_0x00a4:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.connections.ConnectionsSheetViewModel$fetchLinkAccountSession$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
