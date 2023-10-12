package com.stripe.android.stripe3ds2.views;

import com.stripe.android.stripe3ds2.databinding.StripeChallengeSubmitDialogBinding;
import com.stripe.android.stripe3ds2.views.ChallengeSubmitDialogFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/stripe3ds2/databinding/StripeChallengeSubmitDialogBinding;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeSubmitDialogFactory.kt */
final class ChallengeSubmitDialogFactory$ChallengeSubmitDialog$viewBinding$2 extends Lambda implements Function0<StripeChallengeSubmitDialogBinding> {
    final /* synthetic */ ChallengeSubmitDialogFactory.ChallengeSubmitDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChallengeSubmitDialogFactory$ChallengeSubmitDialog$viewBinding$2(ChallengeSubmitDialogFactory.ChallengeSubmitDialog challengeSubmitDialog) {
        super(0);
        this.this$0 = challengeSubmitDialog;
    }

    public final StripeChallengeSubmitDialogBinding invoke() {
        StripeChallengeSubmitDialogBinding inflate = StripeChallengeSubmitDialogBinding.inflate(this.this$0.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        return inflate;
    }
}
