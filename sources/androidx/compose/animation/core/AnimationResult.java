package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B!\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/animation/core/AnimationResult;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "endState", "Landroidx/compose/animation/core/AnimationState;", "endReason", "Landroidx/compose/animation/core/AnimationEndReason;", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/AnimationEndReason;)V", "getEndReason", "()Landroidx/compose/animation/core/AnimationEndReason;", "getEndState", "()Landroidx/compose/animation/core/AnimationState;", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Animatable.kt */
public final class AnimationResult<T, V extends AnimationVector> {
    public static final int $stable = 0;
    private final AnimationEndReason endReason;
    private final AnimationState<T, V> endState;

    public AnimationResult(AnimationState<T, V> animationState, AnimationEndReason animationEndReason) {
        Intrinsics.checkNotNullParameter(animationState, "endState");
        Intrinsics.checkNotNullParameter(animationEndReason, "endReason");
        this.endState = animationState;
        this.endReason = animationEndReason;
    }

    public final AnimationState<T, V> getEndState() {
        return this.endState;
    }

    public final AnimationEndReason getEndReason() {
        return this.endReason;
    }
}
