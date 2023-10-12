package com.stripe.android.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/stripe/android/view/ViewWidthAnimator$animate$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ViewWidthAnimator.kt */
public final class ViewWidthAnimator$animate$1$2 extends AnimatorListenerAdapter {
    final /* synthetic */ int $endWidth;
    final /* synthetic */ Function0<Unit> $onAnimationEnd;
    final /* synthetic */ ViewWidthAnimator this$0;

    ViewWidthAnimator$animate$1$2(ViewWidthAnimator viewWidthAnimator, Function0<Unit> function0, int i) {
        this.this$0 = viewWidthAnimator;
        this.$onAnimationEnd = function0;
        this.$endWidth = i;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        View access$getView$p = this.this$0.view;
        int i = this.$endWidth;
        ViewGroup.LayoutParams layoutParams = access$getView$p.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        layoutParams.width = i;
        access$getView$p.setLayoutParams(layoutParams);
        this.$onAnimationEnd.invoke();
    }
}
