package com.stripe.android.stripe3ds2.views;

import androidx.activity.OnBackPressedCallback;
import com.stripe.android.stripe3ds2.transaction.ChallengeAction;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/stripe/android/stripe3ds2/views/ChallengeActivity$onCreate$1", "Landroidx/activity/OnBackPressedCallback;", "handleOnBackPressed", "", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeActivity.kt */
public final class ChallengeActivity$onCreate$1 extends OnBackPressedCallback {
    final /* synthetic */ ChallengeActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChallengeActivity$onCreate$1(ChallengeActivity challengeActivity) {
        super(true);
        this.this$0 = challengeActivity;
    }

    public void handleOnBackPressed() {
        this.this$0.getViewModel$3ds2sdk_release().submit(ChallengeAction.Cancel.INSTANCE);
    }
}
