package com.stripe.android.payments.core.authentication.threeds2;

import com.stripe.android.StripePaymentController;
import com.stripe.android.model.Stripe3ds2AuthResult;
import com.stripe.android.payments.core.authentication.threeds2.NextStep;
import com.stripe.android.stripe3ds2.transaction.ChallengeParameters;
import com.stripe.android.stripe3ds2.transaction.IntentData;
import com.stripe.android.stripe3ds2.transaction.Transaction;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/payments/core/authentication/threeds2/NextStep$StartChallenge;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel$startChallengeFlow$2", f = "Stripe3ds2TransactionViewModel.kt", i = {}, l = {259}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Stripe3ds2TransactionViewModel.kt */
final class Stripe3ds2TransactionViewModel$startChallengeFlow$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super NextStep.StartChallenge>, Object> {
    final /* synthetic */ Stripe3ds2AuthResult.Ares $ares;
    final /* synthetic */ int $maxTimeout;
    final /* synthetic */ String $sourceId;
    final /* synthetic */ Transaction $transaction;
    int label;
    final /* synthetic */ Stripe3ds2TransactionViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Stripe3ds2TransactionViewModel$startChallengeFlow$2(Stripe3ds2AuthResult.Ares ares, Transaction transaction, int i, Stripe3ds2TransactionViewModel stripe3ds2TransactionViewModel, String str, Continuation<? super Stripe3ds2TransactionViewModel$startChallengeFlow$2> continuation) {
        super(2, continuation);
        this.$ares = ares;
        this.$transaction = transaction;
        this.$maxTimeout = i;
        this.this$0 = stripe3ds2TransactionViewModel;
        this.$sourceId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Stripe3ds2TransactionViewModel$startChallengeFlow$2(this.$ares, this.$transaction, this.$maxTimeout, this.this$0, this.$sourceId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super NextStep.StartChallenge> continuation) {
        return ((Stripe3ds2TransactionViewModel$startChallengeFlow$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(StripePaymentController.Companion.getCHALLENGE_DELAY$payments_core_release(), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ChallengeParameters challengeParameters = new ChallengeParameters(this.$ares.getThreeDSServerTransId$payments_core_release(), this.$ares.getAcsTransId$payments_core_release(), (String) null, this.$ares.getAcsSignedContent$payments_core_release(), (String) null, 20, (DefaultConstructorMarker) null);
        Transaction transaction = this.$transaction;
        int i2 = this.$maxTimeout;
        String clientSecret = this.this$0.args.getStripeIntent().getClientSecret();
        if (clientSecret == null) {
            clientSecret = "";
        }
        return new NextStep.StartChallenge(transaction.createInitChallengeArgs(challengeParameters, i2, new IntentData(clientSecret, this.$sourceId, this.this$0.args.getRequestOptions().getApiKey(), this.this$0.args.getRequestOptions().getStripeAccount())));
    }
}
