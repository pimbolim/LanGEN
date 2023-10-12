package com.stripe.android.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/view/ViewWidthAnimator;", "", "view", "Landroid/view/View;", "duration", "", "(Landroid/view/View;J)V", "animate", "", "startWidth", "", "endWidth", "onAnimationEnd", "Lkotlin/Function0;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ViewWidthAnimator.kt */
public final class ViewWidthAnimator {
    private final long duration;
    /* access modifiers changed from: private */
    public final View view;

    public ViewWidthAnimator(View view2, long j) {
        Intrinsics.checkNotNullParameter(view2, "view");
        this.view = view2;
        this.duration = j;
    }

    public final void animate(int i, int i2, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onAnimationEnd");
        ValueAnimator duration2 = ValueAnimator.ofInt(new int[]{i, i2}).setDuration(this.duration);
        duration2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ViewWidthAnimator.m4691animate$lambda2$lambda1(ViewWidthAnimator.this, valueAnimator);
            }
        });
        duration2.addListener(new ViewWidthAnimator$animate$1$2(this, function0, i2));
        duration2.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: animate$lambda-2$lambda-1  reason: not valid java name */
    public static final void m4691animate$lambda2$lambda1(ViewWidthAnimator viewWidthAnimator, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(viewWidthAnimator, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        View view2 = viewWidthAnimator.view;
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        layoutParams.width = intValue;
        view2.setLayoutParams(layoutParams);
    }
}
