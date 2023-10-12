package com.stripe.android.stripe3ds2.views;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import com.stripe.android.stripe3ds2.transaction.SdkTransactionId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ChallengeProgressFragmentFactory;", "Landroidx/fragment/app/FragmentFactory;", "directoryServerName", "", "sdkTransactionId", "Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "accentColor", "", "(Ljava/lang/String;Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "instantiate", "Landroidx/fragment/app/Fragment;", "classLoader", "Ljava/lang/ClassLoader;", "className", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeProgressFragmentFactory.kt */
public final class ChallengeProgressFragmentFactory extends FragmentFactory {
    private final Integer accentColor;
    private final String directoryServerName;
    private final SdkTransactionId sdkTransactionId;

    public ChallengeProgressFragmentFactory(String str, SdkTransactionId sdkTransactionId2, Integer num) {
        Intrinsics.checkNotNullParameter(str, "directoryServerName");
        Intrinsics.checkNotNullParameter(sdkTransactionId2, "sdkTransactionId");
        this.directoryServerName = str;
        this.sdkTransactionId = sdkTransactionId2;
        this.accentColor = num;
    }

    public Fragment instantiate(ClassLoader classLoader, String str) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        Intrinsics.checkNotNullParameter(str, "className");
        if (Intrinsics.areEqual((Object) str, (Object) ChallengeProgressFragment.class.getName())) {
            return new ChallengeProgressFragment(this.directoryServerName, this.sdkTransactionId, this.accentColor);
        }
        Fragment instantiate = super.instantiate(classLoader, str);
        Intrinsics.checkNotNullExpressionValue(instantiate, "{\n                super.… className)\n            }");
        return instantiate;
    }
}
