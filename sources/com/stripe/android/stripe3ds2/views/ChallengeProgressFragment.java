package com.stripe.android.stripe3ds2.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.stripe.android.stripe3ds2.R;
import com.stripe.android.stripe3ds2.databinding.StripeProgressViewLayoutBinding;
import com.stripe.android.stripe3ds2.observability.DefaultErrorReporter;
import com.stripe.android.stripe3ds2.observability.SentryConfig;
import com.stripe.android.stripe3ds2.observability.Stripe3ds2ErrorReporterConfig;
import com.stripe.android.stripe3ds2.transaction.Logger;
import com.stripe.android.stripe3ds2.transaction.SdkTransactionId;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ChallengeProgressFragment;", "Landroidx/fragment/app/Fragment;", "directoryServerName", "", "sdkTransactionId", "Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "accentColor", "", "(Ljava/lang/String;Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeProgressFragment.kt */
public final class ChallengeProgressFragment extends Fragment {
    private final Integer accentColor;
    private final String directoryServerName;
    private final SdkTransactionId sdkTransactionId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChallengeProgressFragment(String str, SdkTransactionId sdkTransactionId2, Integer num) {
        super(R.layout.stripe_progress_view_layout);
        Intrinsics.checkNotNullParameter(str, "directoryServerName");
        Intrinsics.checkNotNullParameter(sdkTransactionId2, "sdkTransactionId");
        this.directoryServerName = str;
        this.sdkTransactionId = sdkTransactionId2;
        this.accentColor = num;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        StripeProgressViewLayoutBinding bind = StripeProgressViewLayoutBinding.bind(view);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(view)");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Brand lookup$3ds2sdk_release = Brand.Companion.lookup$3ds2sdk_release(this.directoryServerName, new DefaultErrorReporter(requireContext, new Stripe3ds2ErrorReporterConfig(this.sdkTransactionId), (CoroutineContext) null, (Logger) null, (SentryConfig) null, (String) null, (String) null, 0, 252, (DefaultConstructorMarker) null));
        ImageView imageView = bind.brandLogo;
        FragmentActivity activity = getActivity();
        String str = null;
        if (activity == null) {
            drawable = null;
        } else {
            drawable = ContextCompat.getDrawable(activity, lookup$3ds2sdk_release.getDrawableResId$3ds2sdk_release());
        }
        imageView.setImageDrawable(drawable);
        Integer nameResId$3ds2sdk_release = lookup$3ds2sdk_release.getNameResId$3ds2sdk_release();
        if (nameResId$3ds2sdk_release != null) {
            str = getString(nameResId$3ds2sdk_release.intValue());
        }
        imageView.setContentDescription(str);
        if (lookup$3ds2sdk_release.getShouldStretch$3ds2sdk_release()) {
            Intrinsics.checkNotNullExpressionValue(imageView, "brandLogo");
            View view2 = imageView;
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            layoutParams.width = -2;
            layoutParams.height = -2;
            view2.setLayoutParams(layoutParams);
        }
        Intrinsics.checkNotNullExpressionValue(imageView, "brandLogo");
        imageView.setVisibility(0);
        Integer num = this.accentColor;
        if (num != null) {
            bind.progressBar.setIndicatorColor(num.intValue());
        }
    }
}
