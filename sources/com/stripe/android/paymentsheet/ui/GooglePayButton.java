package com.stripe.android.paymentsheet.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import com.stripe.android.paymentsheet.R;
import com.stripe.android.paymentsheet.databinding.StripeGooglePayButtonBinding;
import com.stripe.android.paymentsheet.ui.PrimaryButton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\u000e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\u0010\u0010\u0019\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\nR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/paymentsheet/ui/GooglePayButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "state", "Lcom/stripe/android/paymentsheet/ui/PrimaryButton$State;", "viewBinding", "Lcom/stripe/android/paymentsheet/databinding/StripeGooglePayButtonBinding;", "getViewBinding$paymentsheet_release", "()Lcom/stripe/android/paymentsheet/databinding/StripeGooglePayButtonBinding;", "onFinishProcessing", "", "onReadyState", "onStartProcessing", "setBackgroundColor", "useDarkResources", "", "setEnabled", "enabled", "updateAlpha", "updateState", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayButton.kt */
public final class GooglePayButton extends FrameLayout {
    private PrimaryButton.State state;
    private final StripeGooglePayButtonBinding viewBinding;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GooglePayButton(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GooglePayButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GooglePayButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GooglePayButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        StripeGooglePayButtonBinding inflate = StripeGooglePayButtonBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n        LayoutI…text),\n        this\n    )");
        this.viewBinding = inflate;
        super.setClickable(true);
        super.setEnabled(true);
    }

    public final StripeGooglePayButtonBinding getViewBinding$paymentsheet_release() {
        return this.viewBinding;
    }

    public final void setBackgroundColor(boolean z) {
        int i;
        int i2;
        if (z) {
            i = R.drawable.stripe_googlepay_button_no_shadow_background_dark;
        } else {
            i = R.drawable.stripe_googlepay_button_no_shadow_background_light;
        }
        this.viewBinding.googlePayButtonIcon.setBackground(ResourcesCompat.getDrawable(getResources(), i, (Resources.Theme) null));
        if (z) {
            i2 = R.drawable.stripe_googlepay_button_content_dark;
        } else {
            i2 = R.drawable.stripe_googlepay_button_content_light;
        }
        this.viewBinding.googlePayButtonContent.setImageDrawable(ResourcesCompat.getDrawable(getResources(), i2, (Resources.Theme) null));
        this.viewBinding.primaryButton.setBackgroundTintList(ColorStateList.valueOf(z ? ViewCompat.MEASURED_STATE_MASK : -1));
    }

    private final void onReadyState() {
        PrimaryButton primaryButton = this.viewBinding.primaryButton;
        Intrinsics.checkNotNullExpressionValue(primaryButton, "viewBinding.primaryButton");
        primaryButton.setVisibility(8);
        RelativeLayout relativeLayout = this.viewBinding.googlePayButtonIcon;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "viewBinding.googlePayButtonIcon");
        relativeLayout.setVisibility(0);
    }

    private final void onStartProcessing() {
        PrimaryButton primaryButton = this.viewBinding.primaryButton;
        Intrinsics.checkNotNullExpressionValue(primaryButton, "viewBinding.primaryButton");
        primaryButton.setVisibility(0);
        RelativeLayout relativeLayout = this.viewBinding.googlePayButtonIcon;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "viewBinding.googlePayButtonIcon");
        relativeLayout.setVisibility(8);
    }

    private final void onFinishProcessing() {
        PrimaryButton primaryButton = this.viewBinding.primaryButton;
        Intrinsics.checkNotNullExpressionValue(primaryButton, "viewBinding.primaryButton");
        primaryButton.setVisibility(0);
        RelativeLayout relativeLayout = this.viewBinding.googlePayButtonIcon;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "viewBinding.googlePayButtonIcon");
        relativeLayout.setVisibility(8);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.viewBinding.primaryButton.setEnabled(z);
        updateAlpha();
    }

    private final void updateAlpha() {
        RelativeLayout relativeLayout = this.viewBinding.googlePayButtonIcon;
        PrimaryButton.State state2 = this.state;
        relativeLayout.setAlpha(((state2 == null || (state2 instanceof PrimaryButton.State.Ready)) && !isEnabled()) ? 0.5f : 1.0f);
    }

    public final void updateState(PrimaryButton.State state2) {
        this.viewBinding.primaryButton.updateState(state2);
        this.state = state2;
        updateAlpha();
        if (state2 instanceof PrimaryButton.State.Ready) {
            onReadyState();
        } else if (Intrinsics.areEqual((Object) state2, (Object) PrimaryButton.State.StartProcessing.INSTANCE)) {
            onStartProcessing();
        } else if (state2 instanceof PrimaryButton.State.FinishProcessing) {
            onFinishProcessing();
        }
    }
}
