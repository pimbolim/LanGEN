package com.stripe.android.connections;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.connections.ConnectionsSheetViewModel$fetchManifest$1", f = "ConnectionsSheetViewModel.kt", i = {}, l = {60, 65, 67}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ConnectionsSheetViewModel.kt */
final class ConnectionsSheetViewModel$fetchManifest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ ConnectionsSheetViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConnectionsSheetViewModel$fetchManifest$1(ConnectionsSheetViewModel connectionsSheetViewModel, Continuation<? super ConnectionsSheetViewModel$fetchManifest$1> continuation) {
        super(2, continuation);
        this.this$0 = connectionsSheetViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConnectionsSheetViewModel$fetchManifest$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConnectionsSheetViewModel$fetchManifest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x007b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0028
            if (r1 == r4) goto L_0x0024
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0089
        L_0x0016:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001e:
            java.lang.Object r1 = r6.L$0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0073
        L_0x0024:
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0053 }
            goto L_0x004c
        L_0x0028:
            kotlin.ResultKt.throwOnFailure(r7)
            com.stripe.android.connections.ConnectionsSheetViewModel r7 = r6.this$0
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x0053 }
            com.stripe.android.connections.domain.GenerateLinkAccountSessionManifest r1 = r7.generateLinkAccountSessionManifest     // Catch:{ all -> 0x0053 }
            com.stripe.android.connections.ConnectionsSheetContract$Args r5 = r7.starterArgs     // Catch:{ all -> 0x0053 }
            com.stripe.android.connections.ConnectionsSheet$Configuration r5 = r5.getConfiguration()     // Catch:{ all -> 0x0053 }
            java.lang.String r5 = r5.getLinkAccountSessionClientSecret()     // Catch:{ all -> 0x0053 }
            java.lang.String r7 = r7.applicationId     // Catch:{ all -> 0x0053 }
            r6.label = r4     // Catch:{ all -> 0x0053 }
            java.lang.Object r7 = r1.invoke(r5, r7, r6)     // Catch:{ all -> 0x0053 }
            if (r7 != r0) goto L_0x004c
            return r0
        L_0x004c:
            com.stripe.android.connections.model.LinkAccountSessionManifest r7 = (com.stripe.android.connections.model.LinkAccountSessionManifest) r7     // Catch:{ all -> 0x0053 }
            java.lang.Object r7 = kotlin.Result.m4709constructorimpl(r7)     // Catch:{ all -> 0x0053 }
            goto L_0x005e
        L_0x0053:
            r7 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)
            java.lang.Object r7 = kotlin.Result.m4709constructorimpl(r7)
        L_0x005e:
            r1 = r7
            com.stripe.android.connections.ConnectionsSheetViewModel r7 = r6.this$0
            java.lang.Throwable r4 = kotlin.Result.m4712exceptionOrNullimpl(r1)
            if (r4 != 0) goto L_0x0068
            goto L_0x0073
        L_0x0068:
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r7.onFatal(r4, r6)
            if (r7 != r0) goto L_0x0073
            return r0
        L_0x0073:
            com.stripe.android.connections.ConnectionsSheetViewModel r7 = r6.this$0
            boolean r3 = kotlin.Result.m4716isSuccessimpl(r1)
            if (r3 == 0) goto L_0x0089
            r3 = r1
            com.stripe.android.connections.model.LinkAccountSessionManifest r3 = (com.stripe.android.connections.model.LinkAccountSessionManifest) r3
            r6.L$0 = r1
            r6.label = r2
            java.lang.Object r7 = r7.openAuthFlow(r3, r6)
            if (r7 != r0) goto L_0x0089
            return r0
        L_0x0089:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.connections.ConnectionsSheetViewModel$fetchManifest$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
