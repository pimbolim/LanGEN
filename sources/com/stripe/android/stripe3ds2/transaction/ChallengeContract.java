package com.stripe.android.stripe3ds2.transaction;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.stripe.android.stripe3ds2.views.ChallengeActivity;
import com.stripe.android.stripe3ds2.views.ChallengeViewArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Lcom/stripe/android/stripe3ds2/views/ChallengeViewArgs;", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeResult;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeContract.kt */
public final class ChallengeContract extends ActivityResultContract<ChallengeViewArgs, ChallengeResult> {
    public Intent createIntent(Context context, ChallengeViewArgs challengeViewArgs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(challengeViewArgs, GraphQLConstants.Keys.INPUT);
        Intent putExtras = new Intent(context, ChallengeActivity.class).putExtras(challengeViewArgs.toBundle());
        Intrinsics.checkNotNullExpressionValue(putExtras, "Intent(context, Challeng…tExtras(input.toBundle())");
        return putExtras;
    }

    public ChallengeResult parseResult(int i, Intent intent) {
        return ChallengeResult.Companion.fromIntent(intent);
    }
}
