package com.stripe.android.payments.core.authentication.threeds2;

import androidx.activity.result.ActivityResultLauncher;
import com.stripe.android.auth.PaymentBrowserAuthContract;
import com.stripe.android.stripe3ds2.transaction.ChallengeResult;
import com.stripe.android.stripe3ds2.views.ChallengeViewArgs;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionActivity$onCreate$3", f = "Stripe3ds2TransactionActivity.kt", i = {}, l = {108, 112}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Stripe3ds2TransactionActivity.kt */
final class Stripe3ds2TransactionActivity$onCreate$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ActivityResultLauncher<PaymentBrowserAuthContract.Args> $browserLauncher;
    final /* synthetic */ ActivityResultLauncher<ChallengeViewArgs> $challengeLauncher;
    final /* synthetic */ Function1<ChallengeResult, Job> $onChallengeResult;
    final /* synthetic */ Lazy<Stripe3ds2TransactionViewModel> $viewModel$delegate;
    int label;
    final /* synthetic */ Stripe3ds2TransactionActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Stripe3ds2TransactionActivity$onCreate$3(Stripe3ds2TransactionActivity stripe3ds2TransactionActivity, ActivityResultLauncher<ChallengeViewArgs> activityResultLauncher, Function1<? super ChallengeResult, ? extends Job> function1, ActivityResultLauncher<PaymentBrowserAuthContract.Args> activityResultLauncher2, Lazy<Stripe3ds2TransactionViewModel> lazy, Continuation<? super Stripe3ds2TransactionActivity$onCreate$3> continuation) {
        super(2, continuation);
        this.this$0 = stripe3ds2TransactionActivity;
        this.$challengeLauncher = activityResultLauncher;
        this.$onChallengeResult = function1;
        this.$browserLauncher = activityResultLauncher2;
        this.$viewModel$delegate = lazy;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Stripe3ds2TransactionActivity$onCreate$3(this.this$0, this.$challengeLauncher, this.$onChallengeResult, this.$browserLauncher, this.$viewModel$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Stripe3ds2TransactionActivity$onCreate$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0059
        L_0x0012:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x003b
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r5)
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionActivity r5 = r4.this$0
            boolean r5 = r5.isFinishing()
            if (r5 != 0) goto L_0x009a
            kotlin.Lazy<com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel> r5 = r4.$viewModel$delegate
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel r5 = com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionActivity.m4380onCreate$lambda6(r5)
            r1 = r4
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r4.label = r3
            java.lang.Object r5 = r5.start3ds2Flow(r1)
            if (r5 != r0) goto L_0x003b
            return r0
        L_0x003b:
            com.stripe.android.payments.core.authentication.threeds2.NextStep r5 = (com.stripe.android.payments.core.authentication.threeds2.NextStep) r5
            boolean r1 = r5 instanceof com.stripe.android.payments.core.authentication.threeds2.NextStep.StartChallenge
            if (r1 == 0) goto L_0x007b
            kotlin.Lazy<com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel> r1 = r4.$viewModel$delegate
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel r1 = com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionActivity.m4380onCreate$lambda6(r1)
            com.stripe.android.payments.core.authentication.threeds2.NextStep$StartChallenge r5 = (com.stripe.android.payments.core.authentication.threeds2.NextStep.StartChallenge) r5
            com.stripe.android.stripe3ds2.transaction.InitChallengeArgs r5 = r5.getArgs()
            r3 = r4
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4.label = r2
            java.lang.Object r5 = r1.initChallenge(r5, r3)
            if (r5 != r0) goto L_0x0059
            return r0
        L_0x0059:
            com.stripe.android.stripe3ds2.transaction.InitChallengeResult r5 = (com.stripe.android.stripe3ds2.transaction.InitChallengeResult) r5
            boolean r0 = r5 instanceof com.stripe.android.stripe3ds2.transaction.InitChallengeResult.Start
            if (r0 == 0) goto L_0x006b
            androidx.activity.result.ActivityResultLauncher<com.stripe.android.stripe3ds2.views.ChallengeViewArgs> r0 = r4.$challengeLauncher
            com.stripe.android.stripe3ds2.transaction.InitChallengeResult$Start r5 = (com.stripe.android.stripe3ds2.transaction.InitChallengeResult.Start) r5
            com.stripe.android.stripe3ds2.views.ChallengeViewArgs r5 = r5.getChallengeViewArgs()
            r0.launch(r5)
            goto L_0x009a
        L_0x006b:
            boolean r0 = r5 instanceof com.stripe.android.stripe3ds2.transaction.InitChallengeResult.End
            if (r0 == 0) goto L_0x009a
            kotlin.jvm.functions.Function1<com.stripe.android.stripe3ds2.transaction.ChallengeResult, kotlinx.coroutines.Job> r0 = r4.$onChallengeResult
            com.stripe.android.stripe3ds2.transaction.InitChallengeResult$End r5 = (com.stripe.android.stripe3ds2.transaction.InitChallengeResult.End) r5
            com.stripe.android.stripe3ds2.transaction.ChallengeResult r5 = r5.getChallengeResult()
            r0.invoke(r5)
            goto L_0x009a
        L_0x007b:
            boolean r0 = r5 instanceof com.stripe.android.payments.core.authentication.threeds2.NextStep.StartFallback
            if (r0 == 0) goto L_0x008b
            androidx.activity.result.ActivityResultLauncher<com.stripe.android.auth.PaymentBrowserAuthContract$Args> r0 = r4.$browserLauncher
            com.stripe.android.payments.core.authentication.threeds2.NextStep$StartFallback r5 = (com.stripe.android.payments.core.authentication.threeds2.NextStep.StartFallback) r5
            com.stripe.android.auth.PaymentBrowserAuthContract$Args r5 = r5.getArgs()
            r0.launch(r5)
            goto L_0x009a
        L_0x008b:
            boolean r0 = r5 instanceof com.stripe.android.payments.core.authentication.threeds2.NextStep.Complete
            if (r0 == 0) goto L_0x009a
            com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionActivity r0 = r4.this$0
            com.stripe.android.payments.core.authentication.threeds2.NextStep$Complete r5 = (com.stripe.android.payments.core.authentication.threeds2.NextStep.Complete) r5
            com.stripe.android.payments.PaymentFlowResult$Unvalidated r5 = r5.getResult()
            r0.finishWithResult(r5)
        L_0x009a:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionActivity$onCreate$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
