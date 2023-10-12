package com.stripe.android.payments;

import com.stripe.android.payments.PaymentFlowResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u0010\b\u0001\u0010\u0001 \u0001*\b\u0012\u0004\u0012\u0002H\u00020\u0004*\u00020\u0005H@"}, d2 = {"<anonymous>", "S", "T", "Lcom/stripe/android/model/StripeIntent;", "Lcom/stripe/android/StripeIntentResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.payments.PaymentFlowResultProcessor$processResult$2", f = "PaymentFlowResultProcessor.kt", i = {0, 0, 1, 2}, l = {52, 60, 72}, m = "invokeSuspend", n = {"result", "requestOptions", "result", "result"}, s = {"L$0", "L$1", "L$0", "L$0"})
/* compiled from: PaymentFlowResultProcessor.kt */
final class PaymentFlowResultProcessor$processResult$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super S>, Object> {
    final /* synthetic */ PaymentFlowResult.Unvalidated $unvalidatedResult;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ PaymentFlowResultProcessor<T, S> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentFlowResultProcessor$processResult$2(PaymentFlowResult.Unvalidated unvalidated, PaymentFlowResultProcessor<T, ? extends S> paymentFlowResultProcessor, Continuation<? super PaymentFlowResultProcessor$processResult$2> continuation) {
        super(2, continuation);
        this.$unvalidatedResult = unvalidated;
        this.this$0 = paymentFlowResultProcessor;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaymentFlowResultProcessor$processResult$2(this.$unvalidatedResult, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super S> continuation) {
        return ((PaymentFlowResultProcessor$processResult$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            java.lang.String r2 = "Required value was null."
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0039
            if (r1 == r5) goto L_0x002d
            if (r1 == r4) goto L_0x0024
            if (r1 != r3) goto L_0x001c
            java.lang.Object r0 = r13.L$0
            com.stripe.android.payments.PaymentFlowResult$Validated r0 = (com.stripe.android.payments.PaymentFlowResult.Validated) r0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00f4
        L_0x001c:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x0024:
            java.lang.Object r0 = r13.L$0
            com.stripe.android.payments.PaymentFlowResult$Validated r0 = (com.stripe.android.payments.PaymentFlowResult.Validated) r0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00a3
        L_0x002d:
            java.lang.Object r1 = r13.L$1
            com.stripe.android.core.networking.ApiRequest$Options r1 = (com.stripe.android.core.networking.ApiRequest.Options) r1
            java.lang.Object r5 = r13.L$0
            com.stripe.android.payments.PaymentFlowResult$Validated r5 = (com.stripe.android.payments.PaymentFlowResult.Validated) r5
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0080
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r14)
            com.stripe.android.payments.PaymentFlowResult$Unvalidated r14 = r13.$unvalidatedResult
            com.stripe.android.payments.PaymentFlowResult$Validated r14 = r14.validate$payments_core_release()
            com.stripe.android.core.networking.ApiRequest$Options r1 = new com.stripe.android.core.networking.ApiRequest$Options
            com.stripe.android.payments.PaymentFlowResultProcessor<T, S> r6 = r13.this$0
            javax.inject.Provider r6 = r6.publishableKeyProvider
            java.lang.Object r6 = r6.get()
            java.lang.String r7 = "publishableKeyProvider.get()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r8 = r14.getStripeAccountId$payments_core_release()
            r9 = 0
            r10 = 4
            r11 = 0
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11)
            com.stripe.android.payments.PaymentFlowResultProcessor<T, S> r6 = r13.this$0
            java.lang.String r7 = r14.getClientSecret()
            com.stripe.android.payments.PaymentFlowResultProcessor$Companion r8 = com.stripe.android.payments.PaymentFlowResultProcessor.Companion
            java.util.List r8 = r8.getEXPAND_PAYMENT_METHOD()
            r9 = r13
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r13.L$0 = r14
            r13.L$1 = r1
            r13.label = r5
            java.lang.Object r5 = r6.retrieveStripeIntent(r7, r1, r8, r9)
            if (r5 != r0) goto L_0x007d
            return r0
        L_0x007d:
            r12 = r5
            r5 = r14
            r14 = r12
        L_0x0080:
            if (r14 == 0) goto L_0x011a
            com.stripe.android.payments.PaymentFlowResultProcessor<T, S> r6 = r13.this$0
            com.stripe.android.model.StripeIntent r14 = (com.stripe.android.model.StripeIntent) r14
            int r7 = r5.getFlowOutcome$payments_core_release()
            boolean r7 = r6.shouldRefreshIntent(r14, r7)
            r8 = 0
            if (r7 == 0) goto L_0x00a7
            java.lang.String r14 = r5.getClientSecret()
            r13.L$0 = r5
            r13.L$1 = r8
            r13.label = r4
            java.lang.Object r14 = r6.refreshStripeIntentUntilTerminalState(r14, r1, r13)
            if (r14 != r0) goto L_0x00a2
            return r0
        L_0x00a2:
            r0 = r5
        L_0x00a3:
            com.stripe.android.model.StripeIntent r14 = (com.stripe.android.model.StripeIntent) r14
        L_0x00a5:
            r5 = r0
            goto L_0x0103
        L_0x00a7:
            boolean r4 = r5.getCanCancelSource$payments_core_release()
            boolean r4 = r6.shouldCancelIntentSource(r14, r4)
            if (r4 == 0) goto L_0x0103
            java.lang.String r4 = r5.getSourceId$payments_core_release()
            if (r4 != 0) goto L_0x00b9
            java.lang.String r4 = ""
        L_0x00b9:
            com.stripe.android.core.Logger r7 = r6.logger
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Canceling source '"
            r9.append(r10)
            r9.append(r4)
            java.lang.String r10 = "' for '"
            r9.append(r10)
            java.lang.Class r10 = r14.getClass()
            java.lang.String r10 = r10.getSimpleName()
            r9.append(r10)
            r10 = 39
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r7.debug(r9)
            r13.L$0 = r5
            r13.L$1 = r8
            r13.label = r3
            java.lang.Object r14 = r6.cancelStripeIntentSource(r14, r1, r4, r13)
            if (r14 != r0) goto L_0x00f3
            return r0
        L_0x00f3:
            r0 = r5
        L_0x00f4:
            if (r14 == 0) goto L_0x00f9
            com.stripe.android.model.StripeIntent r14 = (com.stripe.android.model.StripeIntent) r14
            goto L_0x00a5
        L_0x00f9:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r2.toString()
            r14.<init>(r0)
            throw r14
        L_0x0103:
            com.stripe.android.payments.PaymentFlowResultProcessor<T, S> r0 = r13.this$0
            int r1 = r5.getFlowOutcome$payments_core_release()
            com.stripe.android.payments.PaymentFlowFailureMessageFactory r2 = r0.failureMessageFactory
            int r3 = r5.getFlowOutcome$payments_core_release()
            java.lang.String r2 = r2.create(r14, r3)
            com.stripe.android.StripeIntentResult r14 = r0.createStripeIntentResult(r14, r1, r2)
            return r14
        L_0x011a:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r2.toString()
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.PaymentFlowResultProcessor$processResult$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
