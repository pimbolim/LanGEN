package com.stripe.android.stripe3ds2.views;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/stripe3ds2/views/BrandZoneView;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeFragment.kt */
final class ChallengeFragment$brandZoneView$2 extends Lambda implements Function0<BrandZoneView> {
    final /* synthetic */ ChallengeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChallengeFragment$brandZoneView$2(ChallengeFragment challengeFragment) {
        super(0);
        this.this$0 = challengeFragment;
    }

    public final BrandZoneView invoke() {
        BrandZoneView brandZoneView = this.this$0.getViewBinding$3ds2sdk_release().caBrandZone;
        Intrinsics.checkNotNullExpressionValue(brandZoneView, "viewBinding.caBrandZone");
        return brandZoneView;
    }
}
