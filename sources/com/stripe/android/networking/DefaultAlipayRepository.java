package com.stripe.android.networking;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/networking/DefaultAlipayRepository;", "Lcom/stripe/android/networking/AlipayRepository;", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "(Lcom/stripe/android/networking/StripeRepository;)V", "authenticate", "Lcom/stripe/android/model/AlipayAuthResult;", "paymentIntent", "Lcom/stripe/android/model/PaymentIntent;", "authenticator", "Lcom/stripe/android/AlipayAuthenticator;", "requestOptions", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "(Lcom/stripe/android/model/PaymentIntent;Lcom/stripe/android/AlipayAuthenticator;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultAlipayRepository.kt */
public final class DefaultAlipayRepository implements AlipayRepository {
    @Deprecated
    private static final String ALIPAY_RESULT_FIELD = "resultStatus";
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final StripeRepository stripeRepository;

    public DefaultAlipayRepository(StripeRepository stripeRepository2) {
        Intrinsics.checkNotNullParameter(stripeRepository2, "stripeRepository");
        this.stripeRepository = stripeRepository2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object authenticate(com.stripe.android.model.PaymentIntent r6, com.stripe.android.AlipayAuthenticator r7, com.stripe.android.core.networking.ApiRequest.Options r8, kotlin.coroutines.Continuation<? super com.stripe.android.model.AlipayAuthResult> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.stripe.android.networking.DefaultAlipayRepository$authenticate$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.stripe.android.networking.DefaultAlipayRepository$authenticate$1 r0 = (com.stripe.android.networking.DefaultAlipayRepository$authenticate$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.stripe.android.networking.DefaultAlipayRepository$authenticate$1 r0 = new com.stripe.android.networking.DefaultAlipayRepository$authenticate$1
            r0.<init>(r5, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r4) goto L_0x002b
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0090
        L_0x002b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r9)
            com.stripe.android.model.PaymentMethod r9 = r6.getPaymentMethod()
            if (r9 != 0) goto L_0x003e
        L_0x003c:
            r9 = 0
            goto L_0x0043
        L_0x003e:
            boolean r9 = r9.liveMode
            if (r9 != 0) goto L_0x003c
            r9 = 1
        L_0x0043:
            if (r9 != 0) goto L_0x00b7
            com.stripe.android.model.StripeIntent$NextActionData r6 = r6.getNextActionData()
            boolean r9 = r6 instanceof com.stripe.android.model.StripeIntent.NextActionData.AlipayRedirect
            if (r9 == 0) goto L_0x00af
            com.stripe.android.model.StripeIntent$NextActionData$AlipayRedirect r6 = (com.stripe.android.model.StripeIntent.NextActionData.AlipayRedirect) r6
            java.lang.String r9 = r6.getData()
            java.util.Map r7 = r7.onAuthenticationRequest(r9)
            java.lang.String r9 = "resultStatus"
            java.lang.Object r7 = r7.get(r9)
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x00a9
            int r9 = r7.hashCode()
            r2 = 1596796(0x185d7c, float:2.237588E-39)
            if (r9 == r2) goto L_0x009f
            r2 = 1656379(0x19463b, float:2.321081E-39)
            if (r9 == r2) goto L_0x0094
            r2 = 1745751(0x1aa357, float:2.446318E-39)
            if (r9 == r2) goto L_0x0075
            goto L_0x00a9
        L_0x0075:
            java.lang.String r9 = "9000"
            boolean r7 = r7.equals(r9)
            if (r7 != 0) goto L_0x007e
            goto L_0x00a9
        L_0x007e:
            java.lang.String r6 = r6.getAuthCompleteUrl()
            if (r6 != 0) goto L_0x0085
            goto L_0x0092
        L_0x0085:
            com.stripe.android.networking.StripeRepository r7 = r5.stripeRepository
            r0.label = r4
            java.lang.Object r9 = r7.retrieveObject$payments_core_release(r6, r8, r0)
            if (r9 != r1) goto L_0x0090
            return r1
        L_0x0090:
            org.json.JSONObject r9 = (org.json.JSONObject) r9
        L_0x0092:
            r3 = 1
            goto L_0x00a9
        L_0x0094:
            java.lang.String r6 = "6001"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L_0x009d
            goto L_0x00a9
        L_0x009d:
            r3 = 3
            goto L_0x00a9
        L_0x009f:
            java.lang.String r6 = "4000"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto L_0x00a8
            goto L_0x00a9
        L_0x00a8:
            r3 = 2
        L_0x00a9:
            com.stripe.android.model.AlipayAuthResult r6 = new com.stripe.android.model.AlipayAuthResult
            r6.<init>(r3)
            return r6
        L_0x00af:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.String r7 = "Unable to authenticate Payment Intent with Alipay SDK"
            r6.<init>(r7)
            throw r6
        L_0x00b7:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Attempted to authenticate test mode PaymentIntent with the Alipay SDK.\nThe Alipay SDK does not support test mode payments."
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.networking.DefaultAlipayRepository.authenticate(com.stripe.android.model.PaymentIntent, com.stripe.android.AlipayAuthenticator, com.stripe.android.core.networking.ApiRequest$Options, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/networking/DefaultAlipayRepository$Companion;", "", "()V", "ALIPAY_RESULT_FIELD", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultAlipayRepository.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
