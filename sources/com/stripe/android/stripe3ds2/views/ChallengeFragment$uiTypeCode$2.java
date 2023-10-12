package com.stripe.android.stripe3ds2.views;

import com.stripe.android.stripe3ds2.transactions.ChallengeResponseData;
import com.stripe.android.stripe3ds2.transactions.UiType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeFragment.kt */
final class ChallengeFragment$uiTypeCode$2 extends Lambda implements Function0<String> {
    final /* synthetic */ ChallengeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChallengeFragment$uiTypeCode$2(ChallengeFragment challengeFragment) {
        super(0);
        this.this$0 = challengeFragment;
    }

    public final String invoke() {
        ChallengeResponseData access$getCresData$p = this.this$0.cresData;
        String str = null;
        if (access$getCresData$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cresData");
            access$getCresData$p = null;
        }
        UiType uiType = access$getCresData$p.getUiType();
        if (uiType != null) {
            str = uiType.getCode();
        }
        return str == null ? "" : str;
    }
}
