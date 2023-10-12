package com.stripe.android.stripe3ds2.views;

import com.stripe.android.stripe3ds2.transaction.ErrorRequestExecutor;
import com.stripe.android.stripe3ds2.transaction.StripeErrorRequestExecutor;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/stripe3ds2/transaction/ErrorRequestExecutor;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeActivity.kt */
final class ChallengeActivity$errorRequestExecutor$2 extends Lambda implements Function0<ErrorRequestExecutor> {
    final /* synthetic */ ChallengeActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChallengeActivity$errorRequestExecutor$2(ChallengeActivity challengeActivity) {
        super(0);
        this.this$0 = challengeActivity;
    }

    public final ErrorRequestExecutor invoke() {
        return new StripeErrorRequestExecutor.Factory(ChallengeActivity.WORK_CONTEXT).create(this.this$0.getViewArgs().getCreqExecutorConfig$3ds2sdk_release().getAcsUrl$3ds2sdk_release(), this.this$0.getErrorReporter());
    }
}
