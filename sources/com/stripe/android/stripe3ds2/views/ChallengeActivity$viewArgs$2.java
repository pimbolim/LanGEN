package com.stripe.android.stripe3ds2.views;

import android.os.Bundle;
import com.stripe.android.stripe3ds2.views.ChallengeViewArgs;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/stripe3ds2/views/ChallengeViewArgs;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeActivity.kt */
final class ChallengeActivity$viewArgs$2 extends Lambda implements Function0<ChallengeViewArgs> {
    final /* synthetic */ ChallengeActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChallengeActivity$viewArgs$2(ChallengeActivity challengeActivity) {
        super(0);
        this.this$0 = challengeActivity;
    }

    public final ChallengeViewArgs invoke() {
        ChallengeViewArgs.Companion companion = ChallengeViewArgs.Companion;
        Bundle extras = this.this$0.getIntent().getExtras();
        if (extras == null) {
            extras = Bundle.EMPTY;
        }
        Intrinsics.checkNotNullExpressionValue(extras, "intent.extras ?: Bundle.EMPTY");
        return companion.create(extras);
    }
}
