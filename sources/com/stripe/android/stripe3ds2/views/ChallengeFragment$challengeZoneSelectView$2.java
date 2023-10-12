package com.stripe.android.stripe3ds2.views;

import com.stripe.android.stripe3ds2.transactions.ChallengeResponseData;
import com.stripe.android.stripe3ds2.transactions.UiType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/stripe3ds2/views/ChallengeZoneSelectView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeFragment.kt */
final class ChallengeFragment$challengeZoneSelectView$2 extends Lambda implements Function0<ChallengeZoneSelectView> {
    final /* synthetic */ ChallengeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChallengeFragment$challengeZoneSelectView$2(ChallengeFragment challengeFragment) {
        super(0);
        this.this$0 = challengeFragment;
    }

    public final ChallengeZoneSelectView invoke() {
        ChallengeResponseData access$getCresData$p = this.this$0.cresData;
        ChallengeResponseData challengeResponseData = null;
        if (access$getCresData$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cresData");
            access$getCresData$p = null;
        }
        if (access$getCresData$p.getUiType() != UiType.SingleSelect) {
            ChallengeResponseData access$getCresData$p2 = this.this$0.cresData;
            if (access$getCresData$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cresData");
                access$getCresData$p2 = null;
            }
            if (access$getCresData$p2.getUiType() != UiType.MultiSelect) {
                return null;
            }
        }
        ChallengeEntryViewFactory access$getChallengeEntryViewFactory = this.this$0.getChallengeEntryViewFactory();
        ChallengeResponseData access$getCresData$p3 = this.this$0.cresData;
        if (access$getCresData$p3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cresData");
        } else {
            challengeResponseData = access$getCresData$p3;
        }
        return access$getChallengeEntryViewFactory.createChallengeEntrySelectView(challengeResponseData, this.this$0.uiCustomization);
    }
}
