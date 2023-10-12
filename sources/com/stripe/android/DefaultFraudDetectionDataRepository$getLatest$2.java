package com.stripe.android;

import com.stripe.android.networking.FraudDetectionData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/networking/FraudDetectionData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.DefaultFraudDetectionDataRepository$getLatest$2", f = "FraudDetectionDataRepository.kt", i = {0}, l = {70, 76}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"})
/* compiled from: FraudDetectionDataRepository.kt */
final class DefaultFraudDetectionDataRepository$getLatest$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FraudDetectionData>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DefaultFraudDetectionDataRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultFraudDetectionDataRepository$getLatest$2(DefaultFraudDetectionDataRepository defaultFraudDetectionDataRepository, Continuation<? super DefaultFraudDetectionDataRepository$getLatest$2> continuation) {
        super(2, continuation);
        this.this$0 = defaultFraudDetectionDataRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DefaultFraudDetectionDataRepository$getLatest$2 defaultFraudDetectionDataRepository$getLatest$2 = new DefaultFraudDetectionDataRepository$getLatest$2(this.this$0, continuation);
        defaultFraudDetectionDataRepository$getLatest$2.L$0 = obj;
        return defaultFraudDetectionDataRepository$getLatest$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super FraudDetectionData> continuation) {
        return ((DefaultFraudDetectionDataRepository$getLatest$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0025
            if (r1 == r4) goto L_0x001d
            if (r1 != r3) goto L_0x0015
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0013 }
            goto L_0x0075
        L_0x0013:
            r7 = move-exception
            goto L_0x0080
        L_0x0015:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001d:
            java.lang.Object r1 = r6.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0040
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
            com.stripe.android.DefaultFraudDetectionDataRepository r1 = r6.this$0
            com.stripe.android.FraudDetectionDataStore r1 = r1.localStore
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.L$0 = r7
            r6.label = r4
            java.lang.Object r7 = r1.get(r5)
            if (r7 != r0) goto L_0x0040
            return r0
        L_0x0040:
            com.stripe.android.DefaultFraudDetectionDataRepository r1 = r6.this$0
            com.stripe.android.networking.FraudDetectionData r7 = (com.stripe.android.networking.FraudDetectionData) r7
            if (r7 == 0) goto L_0x005a
            kotlin.jvm.functions.Function0 r4 = com.stripe.android.FraudDetectionDataRepositoryKt.timestampSupplier
            java.lang.Object r4 = r4.invoke()
            java.lang.Number r4 = (java.lang.Number) r4
            long r4 = r4.longValue()
            boolean r4 = r7.isExpired(r4)
            if (r4 == 0) goto L_0x0095
        L_0x005a:
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ all -> 0x0013 }
            com.stripe.android.core.networking.StripeNetworkClient r4 = r1.stripeNetworkClient     // Catch:{ all -> 0x0013 }
            com.stripe.android.networking.FraudDetectionDataRequestFactory r1 = r1.fraudDetectionDataRequestFactory     // Catch:{ all -> 0x0013 }
            com.stripe.android.networking.FraudDetectionDataRequest r7 = r1.create(r7)     // Catch:{ all -> 0x0013 }
            com.stripe.android.core.networking.StripeRequest r7 = (com.stripe.android.core.networking.StripeRequest) r7     // Catch:{ all -> 0x0013 }
            r6.L$0 = r2     // Catch:{ all -> 0x0013 }
            r6.label = r3     // Catch:{ all -> 0x0013 }
            java.lang.Object r7 = r4.executeRequest(r7, r6)     // Catch:{ all -> 0x0013 }
            if (r7 != r0) goto L_0x0075
            return r0
        L_0x0075:
            com.stripe.android.core.networking.StripeResponse r7 = (com.stripe.android.core.networking.StripeResponse) r7     // Catch:{ all -> 0x0013 }
            com.stripe.android.networking.FraudDetectionData r7 = com.stripe.android.FraudDetectionDataRepositoryKt.fraudDetectionData(r7)     // Catch:{ all -> 0x0013 }
            java.lang.Object r7 = kotlin.Result.m4709constructorimpl(r7)     // Catch:{ all -> 0x0013 }
            goto L_0x008a
        L_0x0080:
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)
            java.lang.Object r7 = kotlin.Result.m4709constructorimpl(r7)
        L_0x008a:
            boolean r0 = kotlin.Result.m4715isFailureimpl(r7)
            if (r0 == 0) goto L_0x0091
            goto L_0x0092
        L_0x0091:
            r2 = r7
        L_0x0092:
            r7 = r2
            com.stripe.android.networking.FraudDetectionData r7 = (com.stripe.android.networking.FraudDetectionData) r7
        L_0x0095:
            com.stripe.android.DefaultFraudDetectionDataRepository r0 = r6.this$0
            com.stripe.android.networking.FraudDetectionData r0 = r0.cachedFraudDetectionData
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r7)
            if (r0 != 0) goto L_0x00a9
            if (r7 != 0) goto L_0x00a4
            goto L_0x00a9
        L_0x00a4:
            com.stripe.android.DefaultFraudDetectionDataRepository r0 = r6.this$0
            r0.save(r7)
        L_0x00a9:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.DefaultFraudDetectionDataRepository$getLatest$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
