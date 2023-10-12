package com.stripe.android.paymentsheet.ui;

import android.animation.Animator;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\n"}, d2 = {"androidx/core/animation/AnimatorKt$addListener$listener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "core-ktx_release", "androidx/core/animation/AnimatorKt$doOnEnd$$inlined$addListener$default$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: com.stripe.android.paymentsheet.ui.PrimaryButtonAnimator$slideToCenter$lambda-2$$inlined$doOnEnd$1  reason: invalid class name */
/* compiled from: Animator.kt */
public final class PrimaryButtonAnimator$slideToCenter$lambda2$$inlined$doOnEnd$1 implements Animator.AnimatorListener {
    final /* synthetic */ Function0 $onAnimationEnd$inlined;
    final /* synthetic */ View $view$inlined;
    final /* synthetic */ PrimaryButtonAnimator this$0;

    public void onAnimationCancel(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
    }

    public void onAnimationRepeat(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
    }

    public PrimaryButtonAnimator$slideToCenter$lambda2$$inlined$doOnEnd$1(PrimaryButtonAnimator primaryButtonAnimator, View view, Function0 function0) {
        this.this$0 = primaryButtonAnimator;
        this.$view$inlined = view;
        this.$onAnimationEnd$inlined = function0;
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        this.this$0.delay(this.$view$inlined, this.$onAnimationEnd$inlined);
    }
}
