package com.stripe.android.payments.core.authentication.threeds2;

import com.stripe.android.core.Logger;
import com.stripe.android.core.injection.IOContext;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.core.networking.RetryDelaySupplier;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.payments.PaymentFlowResult;
import com.stripe.android.stripe3ds2.transaction.ChallengeResult;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Singleton
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ+\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J1\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/stripe/android/payments/core/authentication/threeds2/DefaultStripe3ds2ChallengeResultProcessor;", "Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2ChallengeResultProcessor;", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "analyticsRequestExecutor", "Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;", "paymentAnalyticsRequestFactory", "Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;", "retryDelaySupplier", "Lcom/stripe/android/core/networking/RetryDelaySupplier;", "logger", "Lcom/stripe/android/core/Logger;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/stripe/android/networking/StripeRepository;Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;Lcom/stripe/android/core/networking/RetryDelaySupplier;Lcom/stripe/android/core/Logger;Lkotlin/coroutines/CoroutineContext;)V", "complete3ds2Auth", "", "challengeResult", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult;", "requestOptions", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "remainingRetries", "", "(Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult;Lcom/stripe/android/core/networking/ApiRequest$Options;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onComplete3ds2AuthFailure", "error", "", "(Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult;Lcom/stripe/android/core/networking/ApiRequest$Options;ILjava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "process", "Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "(Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Stripe3ds2ChallengeResultProcessor.kt */
public final class DefaultStripe3ds2ChallengeResultProcessor implements Stripe3ds2ChallengeResultProcessor {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final int MAX_RETRIES = 3;
    /* access modifiers changed from: private */
    public final AnalyticsRequestExecutor analyticsRequestExecutor;
    private final Logger logger;
    /* access modifiers changed from: private */
    public final PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory;
    private final RetryDelaySupplier retryDelaySupplier;
    private final StripeRepository stripeRepository;
    private final CoroutineContext workContext;

    @Inject
    public DefaultStripe3ds2ChallengeResultProcessor(StripeRepository stripeRepository2, AnalyticsRequestExecutor analyticsRequestExecutor2, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory2, RetryDelaySupplier retryDelaySupplier2, Logger logger2, @IOContext CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(stripeRepository2, "stripeRepository");
        Intrinsics.checkNotNullParameter(analyticsRequestExecutor2, "analyticsRequestExecutor");
        Intrinsics.checkNotNullParameter(paymentAnalyticsRequestFactory2, "paymentAnalyticsRequestFactory");
        Intrinsics.checkNotNullParameter(retryDelaySupplier2, "retryDelaySupplier");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        this.stripeRepository = stripeRepository2;
        this.analyticsRequestExecutor = analyticsRequestExecutor2;
        this.paymentAnalyticsRequestFactory = paymentAnalyticsRequestFactory2;
        this.retryDelaySupplier = retryDelaySupplier2;
        this.logger = logger2;
        this.workContext = coroutineContext;
    }

    public Object process(ChallengeResult challengeResult, Continuation<? super PaymentFlowResult.Unvalidated> continuation) {
        return BuildersKt.withContext(this.workContext, new DefaultStripe3ds2ChallengeResultProcessor$process$2(challengeResult, this, (Continuation<? super DefaultStripe3ds2ChallengeResultProcessor$process$2>) null), continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: com.stripe.android.core.networking.ApiRequest$Options} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object complete3ds2Auth(com.stripe.android.stripe3ds2.transaction.ChallengeResult r8, com.stripe.android.core.networking.ApiRequest.Options r9, int r10, kotlin.coroutines.Continuation<? super java.lang.Boolean> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor$complete3ds2Auth$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor$complete3ds2Auth$1 r0 = (com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor$complete3ds2Auth$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor$complete3ds2Auth$1 r0 = new com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor$complete3ds2Auth$1
            r0.<init>(r7, r11)
        L_0x0019:
            r6 = r0
            java.lang.Object r11 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x004c
            if (r1 == r3) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00c0
        L_0x002f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0037:
            int r10 = r6.I$0
            java.lang.Object r8 = r6.L$2
            r9 = r8
            com.stripe.android.core.networking.ApiRequest$Options r9 = (com.stripe.android.core.networking.ApiRequest.Options) r9
            java.lang.Object r8 = r6.L$1
            com.stripe.android.stripe3ds2.transaction.ChallengeResult r8 = (com.stripe.android.stripe3ds2.transaction.ChallengeResult) r8
            java.lang.Object r1 = r6.L$0
            com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor r1 = (com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor) r1
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x004a }
            goto L_0x0070
        L_0x004a:
            r11 = move-exception
            goto L_0x0079
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.Result$Companion r11 = kotlin.Result.Companion     // Catch:{ all -> 0x0077 }
            r11 = r7
            com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor r11 = (com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor) r11     // Catch:{ all -> 0x0077 }
            com.stripe.android.networking.StripeRepository r11 = r11.stripeRepository     // Catch:{ all -> 0x0077 }
            com.stripe.android.stripe3ds2.transaction.IntentData r1 = r8.getIntentData()     // Catch:{ all -> 0x0077 }
            java.lang.String r1 = r1.getSourceId()     // Catch:{ all -> 0x0077 }
            r6.L$0 = r7     // Catch:{ all -> 0x0077 }
            r6.L$1 = r8     // Catch:{ all -> 0x0077 }
            r6.L$2 = r9     // Catch:{ all -> 0x0077 }
            r6.I$0 = r10     // Catch:{ all -> 0x0077 }
            r6.label = r3     // Catch:{ all -> 0x0077 }
            java.lang.Object r11 = r11.complete3ds2Auth$payments_core_release(r1, r9, r6)     // Catch:{ all -> 0x0077 }
            if (r11 != r0) goto L_0x006f
            return r0
        L_0x006f:
            r1 = r7
        L_0x0070:
            com.stripe.android.model.Stripe3ds2AuthResult r11 = (com.stripe.android.model.Stripe3ds2AuthResult) r11     // Catch:{ all -> 0x004a }
            java.lang.Object r11 = kotlin.Result.m4709constructorimpl(r11)     // Catch:{ all -> 0x004a }
            goto L_0x0083
        L_0x0077:
            r11 = move-exception
            r1 = r7
        L_0x0079:
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            java.lang.Object r11 = kotlin.ResultKt.createFailure(r11)
            java.lang.Object r11 = kotlin.Result.m4709constructorimpl(r11)
        L_0x0083:
            r4 = r10
            java.lang.Throwable r5 = kotlin.Result.m4712exceptionOrNullimpl(r11)
            if (r5 != 0) goto L_0x00ae
            com.stripe.android.model.Stripe3ds2AuthResult r11 = (com.stripe.android.model.Stripe3ds2AuthResult) r11
            int r8 = 3 - r4
            com.stripe.android.core.Logger r9 = r1.logger
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "3DS2 challenge completion request was successful. "
            r10.append(r11)
            r10.append(r8)
            java.lang.String r8 = " retries attempted."
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.debug(r8)
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            goto L_0x00ca
        L_0x00ae:
            r10 = 0
            r6.L$0 = r10
            r6.L$1 = r10
            r6.L$2 = r10
            r6.label = r2
            r2 = r8
            r3 = r9
            java.lang.Object r11 = r1.onComplete3ds2AuthFailure(r2, r3, r4, r5, r6)
            if (r11 != r0) goto L_0x00c0
            return r0
        L_0x00c0:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r8 = r11.booleanValue()
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
        L_0x00ca:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor.complete3ds2Auth(com.stripe.android.stripe3ds2.transaction.ChallengeResult, com.stripe.android.core.networking.ApiRequest$Options, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object complete3ds2Auth$default(DefaultStripe3ds2ChallengeResultProcessor defaultStripe3ds2ChallengeResultProcessor, ChallengeResult challengeResult, ApiRequest.Options options, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 3;
        }
        return defaultStripe3ds2ChallengeResultProcessor.complete3ds2Auth(challengeResult, options, i, continuation);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: com.stripe.android.core.networking.ApiRequest$Options} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0099 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009a A[PHI: r11 
      PHI: (r11v2 java.lang.Object) = (r11v4 java.lang.Object), (r11v1 java.lang.Object) binds: [B:28:0x0097, B:10:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object onComplete3ds2AuthFailure(com.stripe.android.stripe3ds2.transaction.ChallengeResult r7, com.stripe.android.core.networking.ApiRequest.Options r8, int r9, java.lang.Throwable r10, kotlin.coroutines.Continuation<? super java.lang.Boolean> r11) {
        /*
            r6 = this;
            boolean r0 = r11 instanceof com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor$onComplete3ds2AuthFailure$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor$onComplete3ds2AuthFailure$1 r0 = (com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor$onComplete3ds2AuthFailure$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor$onComplete3ds2AuthFailure$1 r0 = new com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor$onComplete3ds2AuthFailure$1
            r0.<init>(r6, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x009a
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            int r9 = r0.I$0
            java.lang.Object r7 = r0.L$2
            r8 = r7
            com.stripe.android.core.networking.ApiRequest$Options r8 = (com.stripe.android.core.networking.ApiRequest.Options) r8
            java.lang.Object r7 = r0.L$1
            com.stripe.android.stripe3ds2.transaction.ChallengeResult r7 = (com.stripe.android.stripe3ds2.transaction.ChallengeResult) r7
            java.lang.Object r10 = r0.L$0
            com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor r10 = (com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0089
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r11)
            com.stripe.android.core.Logger r11 = r6.logger
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            java.lang.String r5 = "3DS2 challenge completion request failed. Remaining retries: "
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r2)
            r11.error(r2, r10)
            boolean r11 = r10 instanceof com.stripe.android.core.exception.StripeException
            r2 = 0
            if (r11 == 0) goto L_0x0066
            com.stripe.android.core.exception.StripeException r10 = (com.stripe.android.core.exception.StripeException) r10
            boolean r10 = r10.isClientError()
            goto L_0x0067
        L_0x0066:
            r10 = 0
        L_0x0067:
            if (r9 <= 0) goto L_0x006d
            if (r10 == 0) goto L_0x006d
            r10 = 1
            goto L_0x006e
        L_0x006d:
            r10 = 0
        L_0x006e:
            if (r10 == 0) goto L_0x009b
            com.stripe.android.core.networking.RetryDelaySupplier r10 = r6.retryDelaySupplier
            r11 = 3
            long r10 = r10.getDelayMillis(r11, r9)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r8
            r0.I$0 = r9
            r0.label = r4
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.delay(r10, r0)
            if (r10 != r1) goto L_0x0088
            return r1
        L_0x0088:
            r10 = r6
        L_0x0089:
            int r9 = r9 - r4
            r11 = 0
            r0.L$0 = r11
            r0.L$1 = r11
            r0.L$2 = r11
            r0.label = r3
            java.lang.Object r11 = r10.complete3ds2Auth(r7, r8, r9, r0)
            if (r11 != r1) goto L_0x009a
            return r1
        L_0x009a:
            return r11
        L_0x009b:
            com.stripe.android.core.Logger r7 = r6.logger
            java.lang.String r8 = "Did not make a successful 3DS2 challenge completion request after retrying."
            r7.debug(r8)
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor.onComplete3ds2AuthFailure(com.stripe.android.stripe3ds2.transaction.ChallengeResult, com.stripe.android.core.networking.ApiRequest$Options, int, java.lang.Throwable, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/payments/core/authentication/threeds2/DefaultStripe3ds2ChallengeResultProcessor$Companion;", "", "()V", "MAX_RETRIES", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Stripe3ds2ChallengeResultProcessor.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
