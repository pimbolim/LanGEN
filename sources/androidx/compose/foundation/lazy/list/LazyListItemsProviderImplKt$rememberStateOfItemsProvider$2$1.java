package androidx.compose.foundation.lazy.list;

import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.node.Ref;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyListItemsProviderImpl.kt */
final class LazyListItemsProviderImplKt$rememberStateOfItemsProvider$2$1 extends Lambda implements Function0<LazyListItemsProvider> {
    final /* synthetic */ Ref<LazyItemScopeImpl> $itemScope;
    final /* synthetic */ State<Function1<LazyListScope, Unit>> $latestContent;
    final /* synthetic */ MutableState<IntRange> $nearestItemsRangeState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListItemsProviderImplKt$rememberStateOfItemsProvider$2$1(State<? extends Function1<? super LazyListScope, Unit>> state, Ref<LazyItemScopeImpl> ref, MutableState<IntRange> mutableState) {
        super(0);
        this.$latestContent = state;
        this.$itemScope = ref;
        this.$nearestItemsRangeState = mutableState;
    }

    public final LazyListItemsProvider invoke() {
        LazyListScopeImpl lazyListScopeImpl = new LazyListScopeImpl();
        this.$latestContent.getValue().invoke(lazyListScopeImpl);
        return new LazyListItemsProviderImpl(this.$itemScope, lazyListScopeImpl.getIntervals(), lazyListScopeImpl.getHeaderIndexes(), this.$nearestItemsRangeState.getValue());
    }
}
