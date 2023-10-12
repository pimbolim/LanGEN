package androidx.compose.foundation.lazy.list;

import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.lazy.LazyListItemInfo;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/lazy/list/ItemFoundInScroll;", "Ljava/util/concurrent/CancellationException;", "Lkotlin/coroutines/cancellation/CancellationException;", "item", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "previousAnimation", "Landroidx/compose/animation/core/AnimationState;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "(Landroidx/compose/foundation/lazy/LazyListItemInfo;Landroidx/compose/animation/core/AnimationState;)V", "getItem", "()Landroidx/compose/foundation/lazy/LazyListItemInfo;", "getPreviousAnimation", "()Landroidx/compose/animation/core/AnimationState;", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyListScrolling.kt */
final class ItemFoundInScroll extends CancellationException {
    private final LazyListItemInfo item;
    private final AnimationState<Float, AnimationVector1D> previousAnimation;

    public final LazyListItemInfo getItem() {
        return this.item;
    }

    public final AnimationState<Float, AnimationVector1D> getPreviousAnimation() {
        return this.previousAnimation;
    }

    public ItemFoundInScroll(LazyListItemInfo lazyListItemInfo, AnimationState<Float, AnimationVector1D> animationState) {
        Intrinsics.checkNotNullParameter(lazyListItemInfo, "item");
        Intrinsics.checkNotNullParameter(animationState, "previousAnimation");
        this.item = lazyListItemInfo;
        this.previousAnimation = animationState;
    }
}
