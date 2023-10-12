package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"androidx/compose/foundation/gestures/ScrollingLogic$doFlingAnimation$2$scope$1", "Landroidx/compose/foundation/gestures/ScrollScope;", "scrollBy", "", "pixels", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Scrollable.kt */
public final class ScrollingLogic$doFlingAnimation$2$scope$1 implements ScrollScope {
    final /* synthetic */ Function1<Float, Float> $outerScopeScroll;

    ScrollingLogic$doFlingAnimation$2$scope$1(Function1<? super Float, Float> function1) {
        this.$outerScopeScroll = function1;
    }

    public float scrollBy(float f) {
        return this.$outerScopeScroll.invoke(Float.valueOf(f)).floatValue();
    }
}
