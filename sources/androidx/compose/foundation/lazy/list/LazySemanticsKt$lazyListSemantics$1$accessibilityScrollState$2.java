package androidx.compose.foundation.lazy.list;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Float;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazySemantics.kt */
final class LazySemanticsKt$lazyListSemantics$1$accessibilityScrollState$2 extends Lambda implements Function0<Float> {
    final /* synthetic */ LazyListState $state;
    final /* synthetic */ State<LazyListItemsProvider> $stateOfItemsProvider;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazySemanticsKt$lazyListSemantics$1$accessibilityScrollState$2(LazyListState lazyListState, State<? extends LazyListItemsProvider> state) {
        super(0);
        this.$state = lazyListState;
        this.$stateOfItemsProvider = state;
    }

    public final Float invoke() {
        float f;
        float f2;
        if (this.$state.getCanScrollForward$foundation_release()) {
            f2 = (float) this.$stateOfItemsProvider.getValue().getItemsCount();
            f = 1.0f;
        } else {
            f2 = (float) this.$state.getFirstVisibleItemIndex();
            f = ((float) this.$state.getFirstVisibleItemScrollOffset()) / 100000.0f;
        }
        return Float.valueOf(f2 + f);
    }
}
