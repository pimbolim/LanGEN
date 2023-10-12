package com.stripe.android.link.injection;

import androidx.activity.result.ActivityResultLauncher;
import com.stripe.android.link.LinkActivityContract;
import com.stripe.android.link.LinkPaymentLauncher;
import dagger.assisted.AssistedFactory;
import kotlin.Metadata;

@AssistedFactory
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/link/injection/LinkPaymentLauncherFactory;", "", "create", "Lcom/stripe/android/link/LinkPaymentLauncher;", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/stripe/android/link/LinkActivityContract$Args;", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LinkPaymentLauncherFactory.kt */
public interface LinkPaymentLauncherFactory {
    LinkPaymentLauncher create(ActivityResultLauncher<LinkActivityContract.Args> activityResultLauncher);
}
