package com.stripe.android.payments.core.authentication.threeds2;

import androidx.lifecycle.LifecycleOwnerKt;
import com.stripe.android.payments.PaymentFlowResult;
import com.stripe.android.stripe3ds2.transaction.ChallengeResult;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "challengeResult", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Stripe3ds2TransactionActivity.kt */
final class Stripe3ds2TransactionActivity$onCreate$onChallengeResult$1 extends Lambda implements Function1<ChallengeResult, Job> {
    final /* synthetic */ Lazy<Stripe3ds2TransactionViewModel> $viewModel$delegate;
    final /* synthetic */ Stripe3ds2TransactionActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Stripe3ds2TransactionActivity$onCreate$onChallengeResult$1(Stripe3ds2TransactionActivity stripe3ds2TransactionActivity, Lazy<Stripe3ds2TransactionViewModel> lazy) {
        super(1);
        this.this$0 = stripe3ds2TransactionActivity;
        this.$viewModel$delegate = lazy;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionActivity$onCreate$onChallengeResult$1$1", f = "Stripe3ds2TransactionActivity.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionActivity$onCreate$onChallengeResult$1$1  reason: invalid class name */
    /* compiled from: Stripe3ds2TransactionActivity.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(stripe3ds2TransactionActivity, challengeResult, lazy, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Stripe3ds2TransactionActivity stripe3ds2TransactionActivity;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Stripe3ds2TransactionActivity stripe3ds2TransactionActivity2 = stripe3ds2TransactionActivity;
                this.L$0 = stripe3ds2TransactionActivity2;
                this.label = 1;
                Object processChallengeResult = Stripe3ds2TransactionActivity.m4380onCreate$lambda6(lazy).processChallengeResult(challengeResult, this);
                if (processChallengeResult == coroutine_suspended) {
                    return coroutine_suspended;
                }
                stripe3ds2TransactionActivity = stripe3ds2TransactionActivity2;
                obj = processChallengeResult;
            } else if (i == 1) {
                stripe3ds2TransactionActivity = (Stripe3ds2TransactionActivity) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            stripe3ds2TransactionActivity.finishWithResult((PaymentFlowResult.Unvalidated) obj);
            return Unit.INSTANCE;
        }
    }

    public final Job invoke(final ChallengeResult challengeResult) {
        Intrinsics.checkNotNullParameter(challengeResult, "challengeResult");
        final Stripe3ds2TransactionActivity stripe3ds2TransactionActivity = this.this$0;
        final Lazy<Stripe3ds2TransactionViewModel> lazy = this.$viewModel$delegate;
        return BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }
}
