package com.stripe.android.stripe3ds2.views;

import androidx.lifecycle.ViewModelProvider;
import com.stripe.android.stripe3ds2.views.ChallengeActivityViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/lifecycle/ViewModelProvider$Factory;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeActivity.kt */
final class ChallengeActivity$viewModel$2 extends Lambda implements Function0<ViewModelProvider.Factory> {
    final /* synthetic */ ChallengeActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChallengeActivity$viewModel$2(ChallengeActivity challengeActivity) {
        super(0);
        this.this$0 = challengeActivity;
    }

    public final ViewModelProvider.Factory invoke() {
        return new ChallengeActivityViewModel.Factory(this.this$0.getChallengeActionHandler(), this.this$0.getTransactionTimer(), this.this$0.getErrorReporter(), ChallengeActivity.WORK_CONTEXT);
    }
}
