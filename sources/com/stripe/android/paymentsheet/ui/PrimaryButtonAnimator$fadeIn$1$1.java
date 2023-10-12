package com.stripe.android.paymentsheet.ui;

import android.view.View;
import android.view.animation.Animation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/stripe/android/paymentsheet/ui/PrimaryButtonAnimator$fadeIn$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "p0", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrimaryButtonAnimator.kt */
public final class PrimaryButtonAnimator$fadeIn$1$1 implements Animation.AnimationListener {
    final /* synthetic */ Function0<Unit> $onAnimationEnd;
    final /* synthetic */ int $parentWidth;
    final /* synthetic */ View $view;
    final /* synthetic */ PrimaryButtonAnimator this$0;

    public void onAnimationRepeat(Animation animation) {
    }

    PrimaryButtonAnimator$fadeIn$1$1(View view, PrimaryButtonAnimator primaryButtonAnimator, int i, Function0<Unit> function0) {
        this.$view = view;
        this.this$0 = primaryButtonAnimator;
        this.$parentWidth = i;
        this.$onAnimationEnd = function0;
    }

    public void onAnimationStart(Animation animation) {
        this.$view.setVisibility(0);
    }

    public void onAnimationEnd(Animation animation) {
        this.$view.setVisibility(0);
        this.this$0.slideToCenter(this.$view, this.$parentWidth, this.$onAnimationEnd);
    }
}
