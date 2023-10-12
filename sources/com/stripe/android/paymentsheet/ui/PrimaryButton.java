package com.stripe.android.paymentsheet.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.compose.ui.unit.Dp;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.stripe.android.paymentsheet.R;
import com.stripe.android.paymentsheet.databinding.PrimaryButtonBinding;
import com.stripe.android.ui.core.PaymentsThemeDefaults;
import com.stripe.android.ui.core.PaymentsThemeKt;
import com.stripe.android.ui.core.PrimaryButtonModifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001:\u0001<B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010)\u001a\u0004\u0018\u00010*2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0016\u0010+\u001a\u00020,2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0.H\u0002J\b\u0010/\u001a\u00020,H\u0002J\b\u00100\u001a\u00020,H\u0002J\u0018\u00101\u001a\u00020,2\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0012J\u0012\u00105\u001a\u00020,2\b\u00104\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u00106\u001a\u00020,2\u0006\u00107\u001a\u00020\u001cH\u0016J\u0010\u00108\u001a\u00020,2\b\u00109\u001a\u0004\u0018\u00010\u0014J\b\u0010:\u001a\u00020,H\u0002J\u0010\u0010;\u001a\u00020,2\b\u0010\"\u001a\u0004\u0018\u00010#R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R&\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010$\u001a\u00020%8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\u0016\u001a\u0004\b'\u0010(¨\u0006="}, d2 = {"Lcom/stripe/android/paymentsheet/ui/PrimaryButton;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Lcom/stripe/android/paymentsheet/ui/PrimaryButtonAnimator;", "borderStrokeColor", "borderStrokeWidth", "", "confirmedIcon", "Landroid/widget/ImageView;", "cornerRadius", "defaultTintList", "Landroid/content/res/ColorStateList;", "externalLabel", "", "getExternalLabel$paymentsheet_release$annotations", "()V", "getExternalLabel$paymentsheet_release", "()Ljava/lang/String;", "setExternalLabel$paymentsheet_release", "(Ljava/lang/String;)V", "lockVisible", "", "getLockVisible$paymentsheet_release", "()Z", "setLockVisible$paymentsheet_release", "(Z)V", "originalLabel", "state", "Lcom/stripe/android/paymentsheet/ui/PrimaryButton$State;", "viewBinding", "Lcom/stripe/android/paymentsheet/databinding/PrimaryButtonBinding;", "getViewBinding$paymentsheet_release$annotations", "getViewBinding$paymentsheet_release", "()Lcom/stripe/android/paymentsheet/databinding/PrimaryButtonBinding;", "getTextAttributeValue", "", "onFinishProcessing", "", "onAnimationEnd", "Lkotlin/Function0;", "onReadyState", "onStartProcessing", "setAppearanceConfiguration", "primaryButtonModifier", "Lcom/stripe/android/ui/core/PrimaryButtonModifier;", "tintList", "setBackgroundTintList", "setEnabled", "enabled", "setLabel", "text", "updateAlpha", "updateState", "State", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrimaryButton.kt */
public final class PrimaryButton extends FrameLayout {
    private final PrimaryButtonAnimator animator;
    private int borderStrokeColor;
    private float borderStrokeWidth;
    private final ImageView confirmedIcon;
    private float cornerRadius;
    private ColorStateList defaultTintList;
    private String externalLabel;
    private boolean lockVisible;
    private String originalLabel;
    private State state;
    private final PrimaryButtonBinding viewBinding;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PrimaryButton(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PrimaryButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public static /* synthetic */ void getExternalLabel$paymentsheet_release$annotations() {
    }

    public static /* synthetic */ void getViewBinding$paymentsheet_release$annotations() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PrimaryButton(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PrimaryButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.animator = new PrimaryButtonAnimator(context);
        PrimaryButtonBinding inflate = PrimaryButtonBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n        LayoutI…text),\n        this\n    )");
        this.viewBinding = inflate;
        this.lockVisible = true;
        ImageView imageView = inflate.confirmedIcon;
        Intrinsics.checkNotNullExpressionValue(imageView, "viewBinding.confirmedIcon");
        this.confirmedIcon = imageView;
        this.cornerRadius = PaymentsThemeKt.m4514convertDpToPx3ABfNKs(context, Dp.m3859constructorimpl(PaymentsThemeDefaults.INSTANCE.getPrimaryButtonModifier().getCornerRadius()));
        this.borderStrokeWidth = PaymentsThemeKt.m4514convertDpToPx3ABfNKs(context, Dp.m3859constructorimpl(PaymentsThemeDefaults.INSTANCE.getPrimaryButtonModifier().getBorderStrokeWidth()));
        this.borderStrokeColor = ColorKt.m1651toArgb8_81llA(PaymentsThemeDefaults.INSTANCE.getPrimaryButtonModifier().m4538getBorder0d7_KjU());
        inflate.label.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        CharSequence textAttributeValue = getTextAttributeValue(attributeSet);
        if (textAttributeValue != null) {
            setLabel(textAttributeValue.toString());
        }
        setClickable(true);
        setEnabled(false);
    }

    public final String getExternalLabel$paymentsheet_release() {
        return this.externalLabel;
    }

    public final void setExternalLabel$paymentsheet_release(String str) {
        this.externalLabel = str;
    }

    public final PrimaryButtonBinding getViewBinding$paymentsheet_release() {
        return this.viewBinding;
    }

    public final boolean getLockVisible$paymentsheet_release() {
        return this.lockVisible;
    }

    public final void setLockVisible$paymentsheet_release(boolean z) {
        this.lockVisible = z;
    }

    public final void setAppearanceConfiguration(PrimaryButtonModifier primaryButtonModifier, ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(primaryButtonModifier, "primaryButtonModifier");
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.cornerRadius = PaymentsThemeKt.m4514convertDpToPx3ABfNKs(context, Dp.m3859constructorimpl(primaryButtonModifier.getCornerRadius()));
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.borderStrokeWidth = PaymentsThemeKt.m4514convertDpToPx3ABfNKs(context2, Dp.m3859constructorimpl(primaryButtonModifier.getBorderStrokeWidth()));
        this.borderStrokeColor = ColorKt.m1651toArgb8_81llA(primaryButtonModifier.m4538getBorder0d7_KjU());
        setBackgroundTintList(colorStateList);
        this.defaultTintList = colorStateList;
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(this.cornerRadius);
        gradientDrawable.setColor(colorStateList);
        gradientDrawable.setStroke((int) this.borderStrokeWidth, this.borderStrokeColor);
        setBackground(gradientDrawable);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stripe_paymentsheet_primary_button_padding);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
    }

    private final CharSequence getTextAttributeValue(AttributeSet attributeSet) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, CollectionsKt.toIntArray(CollectionsKt.listOf(16843087)), 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        CharSequence text = obtainStyledAttributes.getText(0);
        obtainStyledAttributes.recycle();
        return text;
    }

    public final void setLabel(String str) {
        this.externalLabel = str;
        if (!(this.state instanceof State.StartProcessing)) {
            this.originalLabel = str;
        }
        if (str != null) {
            getViewBinding$paymentsheet_release().label.setContent(ComposableLambdaKt.composableLambdaInstance(-985538457, true, new PrimaryButton$setLabel$1$1(str)));
        }
    }

    private final void onReadyState() {
        String str = this.originalLabel;
        if (str != null) {
            setLabel(str);
        }
        ColorStateList colorStateList = this.defaultTintList;
        if (colorStateList != null) {
            setBackgroundTintList(colorStateList);
        }
        ImageView imageView = this.viewBinding.lockIcon;
        Intrinsics.checkNotNullExpressionValue(imageView, "viewBinding.lockIcon");
        imageView.setVisibility(this.lockVisible ? 0 : 8);
        CircularProgressIndicator circularProgressIndicator = this.viewBinding.confirmingIcon;
        Intrinsics.checkNotNullExpressionValue(circularProgressIndicator, "viewBinding.confirmingIcon");
        circularProgressIndicator.setVisibility(8);
    }

    private final void onStartProcessing() {
        ImageView imageView = this.viewBinding.lockIcon;
        Intrinsics.checkNotNullExpressionValue(imageView, "viewBinding.lockIcon");
        imageView.setVisibility(8);
        CircularProgressIndicator circularProgressIndicator = this.viewBinding.confirmingIcon;
        Intrinsics.checkNotNullExpressionValue(circularProgressIndicator, "viewBinding.confirmingIcon");
        circularProgressIndicator.setVisibility(0);
        setLabel(getResources().getString(R.string.stripe_paymentsheet_primary_button_processing));
    }

    private final void onFinishProcessing(Function0<Unit> function0) {
        setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.stripe_paymentsheet_primary_button_success_background)));
        PrimaryButtonAnimator primaryButtonAnimator = this.animator;
        ComposeView composeView = this.viewBinding.label;
        Intrinsics.checkNotNullExpressionValue(composeView, "viewBinding.label");
        primaryButtonAnimator.fadeOut$paymentsheet_release(composeView);
        PrimaryButtonAnimator primaryButtonAnimator2 = this.animator;
        CircularProgressIndicator circularProgressIndicator = this.viewBinding.confirmingIcon;
        Intrinsics.checkNotNullExpressionValue(circularProgressIndicator, "viewBinding.confirmingIcon");
        primaryButtonAnimator2.fadeOut$paymentsheet_release(circularProgressIndicator);
        this.animator.fadeIn$paymentsheet_release(this.confirmedIcon, getWidth(), new PrimaryButton$onFinishProcessing$1(function0));
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        updateAlpha();
    }

    public final void updateState(State state2) {
        this.state = state2;
        updateAlpha();
        if (state2 instanceof State.Ready) {
            onReadyState();
        } else if (Intrinsics.areEqual((Object) state2, (Object) State.StartProcessing.INSTANCE)) {
            onStartProcessing();
        } else if (state2 instanceof State.FinishProcessing) {
            onFinishProcessing(((State.FinishProcessing) state2).getOnComplete());
        }
    }

    private final void updateAlpha() {
        ComposeView composeView = this.viewBinding.label;
        Intrinsics.checkNotNullExpressionValue(composeView, "viewBinding.label");
        ImageView imageView = this.viewBinding.lockIcon;
        Intrinsics.checkNotNullExpressionValue(imageView, "viewBinding.lockIcon");
        for (View view : CollectionsKt.listOf(composeView, imageView)) {
            State state2 = this.state;
            view.setAlpha(((state2 == null || (state2 instanceof State.Ready)) && !isEnabled()) ? 0.5f : 1.0f);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/paymentsheet/ui/PrimaryButton$State;", "", "()V", "FinishProcessing", "Ready", "StartProcessing", "Lcom/stripe/android/paymentsheet/ui/PrimaryButton$State$Ready;", "Lcom/stripe/android/paymentsheet/ui/PrimaryButton$State$StartProcessing;", "Lcom/stripe/android/paymentsheet/ui/PrimaryButton$State$FinishProcessing;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PrimaryButton.kt */
    public static abstract class State {
        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private State() {
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/stripe/android/paymentsheet/ui/PrimaryButton$State$Ready;", "Lcom/stripe/android/paymentsheet/ui/PrimaryButton$State;", "()V", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PrimaryButton.kt */
        public static final class Ready extends State {
            public static final int $stable = 0;
            public static final Ready INSTANCE = new Ready();

            private Ready() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/stripe/android/paymentsheet/ui/PrimaryButton$State$StartProcessing;", "Lcom/stripe/android/paymentsheet/ui/PrimaryButton$State;", "()V", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PrimaryButton.kt */
        public static final class StartProcessing extends State {
            public static final int $stable = 0;
            public static final StartProcessing INSTANCE = new StartProcessing();

            private StartProcessing() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/paymentsheet/ui/PrimaryButton$State$FinishProcessing;", "Lcom/stripe/android/paymentsheet/ui/PrimaryButton$State;", "onComplete", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "getOnComplete", "()Lkotlin/jvm/functions/Function0;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PrimaryButton.kt */
        public static final class FinishProcessing extends State {
            public static final int $stable = 0;
            private final Function0<Unit> onComplete;

            public static /* synthetic */ FinishProcessing copy$default(FinishProcessing finishProcessing, Function0<Unit> function0, int i, Object obj) {
                if ((i & 1) != 0) {
                    function0 = finishProcessing.onComplete;
                }
                return finishProcessing.copy(function0);
            }

            public final Function0<Unit> component1() {
                return this.onComplete;
            }

            public final FinishProcessing copy(Function0<Unit> function0) {
                Intrinsics.checkNotNullParameter(function0, "onComplete");
                return new FinishProcessing(function0);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof FinishProcessing) && Intrinsics.areEqual((Object) this.onComplete, (Object) ((FinishProcessing) obj).onComplete);
            }

            public int hashCode() {
                return this.onComplete.hashCode();
            }

            public String toString() {
                return "FinishProcessing(onComplete=" + this.onComplete + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public FinishProcessing(Function0<Unit> function0) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(function0, "onComplete");
                this.onComplete = function0;
            }

            public final Function0<Unit> getOnComplete() {
                return this.onComplete;
            }
        }
    }
}
