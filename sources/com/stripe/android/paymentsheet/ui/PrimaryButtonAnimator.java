package com.stripe.android.paymentsheet.ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.stripe.android.paymentsheet.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0002J+\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0000¢\u0006\u0002\b\u0010J\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0012J&\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/stripe/android/paymentsheet/ui/PrimaryButtonAnimator;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "slideAnimationDuration", "", "delay", "", "view", "Landroid/view/View;", "onAnimationEnd", "Lkotlin/Function0;", "fadeIn", "parentWidth", "", "fadeIn$paymentsheet_release", "fadeOut", "fadeOut$paymentsheet_release", "slideToCenter", "Companion", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrimaryButtonAnimator.kt */
public final class PrimaryButtonAnimator {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long HOLD_ANIMATION_ON_SLIDE_IN_COMPLETION = 1500;
    private final Context context;
    private final long slideAnimationDuration;

    public PrimaryButtonAnimator(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.slideAnimationDuration = (long) context2.getResources().getInteger(17694720);
    }

    public final void fadeIn$paymentsheet_release(View view, int i, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(function0, "onAnimationEnd");
        Animation loadAnimation = AnimationUtils.loadAnimation(this.context, R.anim.stripe_paymentsheet_transition_fade_in);
        loadAnimation.setAnimationListener(new PrimaryButtonAnimator$fadeIn$1$1(view, this, i, function0));
        view.startAnimation(loadAnimation);
    }

    /* access modifiers changed from: private */
    public final void slideToCenter(View view, int i, Function0<Unit> function0) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", new float[]{0.0f, -((((float) view.getLeft()) + (((float) (view.getRight() - view.getLeft())) / 2.0f)) - (((float) i) / 2.0f))});
        ofFloat.setDuration(this.slideAnimationDuration);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "animator");
        ofFloat.addListener(new PrimaryButtonAnimator$slideToCenter$lambda2$$inlined$doOnEnd$1(this, view, function0));
        ofFloat.start();
    }

    /* access modifiers changed from: private */
    public final void delay(View view, Function0<Unit> function0) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", new float[]{0.0f, 0.0f});
        ofFloat.setDuration(HOLD_ANIMATION_ON_SLIDE_IN_COMPLETION);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "animator");
        ofFloat.addListener(new PrimaryButtonAnimator$delay$lambda4$$inlined$doOnEnd$1(function0));
        ofFloat.start();
    }

    public final void fadeOut$paymentsheet_release(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        Animation loadAnimation = AnimationUtils.loadAnimation(this.context, R.anim.stripe_paymentsheet_transition_fade_out);
        loadAnimation.setAnimationListener(new PrimaryButtonAnimator$fadeOut$1$1(view));
        view.startAnimation(loadAnimation);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/paymentsheet/ui/PrimaryButtonAnimator$Companion;", "", "()V", "HOLD_ANIMATION_ON_SLIDE_IN_COMPLETION", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PrimaryButtonAnimator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
