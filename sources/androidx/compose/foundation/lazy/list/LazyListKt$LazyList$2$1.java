package androidx.compose.foundation.lazy.list;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemsProvider;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyList.kt */
final class LazyListKt$LazyList$2$1 extends Lambda implements Function0<LazyLayoutItemsProvider> {
    final /* synthetic */ State<LazyListItemsProvider> $stateOfItemsProvider;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListKt$LazyList$2$1(State<? extends LazyListItemsProvider> state) {
        super(0);
        this.$stateOfItemsProvider = state;
    }

    public final LazyLayoutItemsProvider invoke() {
        return this.$stateOfItemsProvider.getValue();
    }
}
