package com.stripe.android.payments.core.authentication.threeds2;

import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.Stripe3ds2AuthResult;
import com.stripe.android.model.Stripe3ds2Fingerprint;
import com.stripe.android.stripe3ds2.transaction.Transaction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/model/Stripe3ds2AuthResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel$perform3ds2AuthenticationRequest$2", f = "Stripe3ds2TransactionViewModel.kt", i = {}, l = {141, 158}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Stripe3ds2TransactionViewModel.kt */
final class Stripe3ds2TransactionViewModel$perform3ds2AuthenticationRequest$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Stripe3ds2AuthResult>, Object> {
    final /* synthetic */ ApiRequest.Options $requestOptions;
    final /* synthetic */ Stripe3ds2Fingerprint $stripe3ds2Fingerprint;
    final /* synthetic */ int $timeout;
    final /* synthetic */ Transaction $transaction;
    int label;
    final /* synthetic */ Stripe3ds2TransactionViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Stripe3ds2TransactionViewModel$perform3ds2AuthenticationRequest$2(Transaction transaction, Stripe3ds2Fingerprint stripe3ds2Fingerprint, int i, Stripe3ds2TransactionViewModel stripe3ds2TransactionViewModel, ApiRequest.Options options, Continuation<? super Stripe3ds2TransactionViewModel$perform3ds2AuthenticationRequest$2> continuation) {
        super(2, continuation);
        this.$transaction = transaction;
        this.$stripe3ds2Fingerprint = stripe3ds2Fingerprint;
        this.$timeout = i;
        this.this$0 = stripe3ds2TransactionViewModel;
        this.$requestOptions = options;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Stripe3ds2TransactionViewModel$perform3ds2AuthenticationRequest$2(this.$transaction, this.$stripe3ds2Fingerprint, this.$timeout, this.this$0, this.$requestOptions, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Stripe3ds2AuthResult> continuation) {
        return ((Stripe3ds2TransactionViewModel$perform3ds2AuthenticationRequest$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0072 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0070
        L_0x0012:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x002f
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r14)
            com.stripe.android.stripe3ds2.transaction.Transaction r14 = r13.$transaction
            r1 = r13
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r13.label = r3
            java.lang.Object r14 = r14.createAuthenticationRequestParameters(r1)
            if (r14 != r0) goto L_0x002f
            return r0
        L_0x002f:
            com.stripe.android.stripe3ds2.transaction.AuthenticationRequestParameters r14 = (com.stripe.android.stripe3ds2.transaction.AuthenticationRequestParameters) r14
            com.stripe.android.model.Stripe3ds2AuthParams r1 = new com.stripe.android.model.Stripe3ds2AuthParams
            com.stripe.android.model.Stripe3ds2Fingerprint r3 = r13.$stripe3ds2Fingerprint
            java.lang.String r4 = r3.getSource()
            java.lang.String r5 = r14.getSdkAppId()
            java.lang.String r6 = r14.getSdkReferenceNumber()
            com.stripe.android.stripe3ds2.transaction.SdkTransactionId r3 = r14.getSdkTransactionId()
            java.lang.String r7 = r3.getValue()
            java.lang.String r8 = r14.getDeviceData()
            java.lang.String r9 = r14.getSdkEphemeralPublicKey()
            java.lang.String r10 = r14.getMessageVersion()
            int r11 = r13.$timeout
            r12 = 0
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel r14 = r13.this$0
            com.stripe.android.networking.StripeRepository r14 = r14.stripeRepository
            com.stripe.android.core.networking.ApiRequest$Options r3 = r13.$requestOptions
            r4 = r13
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r13.label = r2
            java.lang.Object r14 = r14.start3ds2Auth$payments_core_release(r1, r3, r4)
            if (r14 != r0) goto L_0x0070
            return r0
        L_0x0070:
            if (r14 == 0) goto L_0x0073
            return r14
        L_0x0073:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Required value was null."
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel$perform3ds2AuthenticationRequest$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
