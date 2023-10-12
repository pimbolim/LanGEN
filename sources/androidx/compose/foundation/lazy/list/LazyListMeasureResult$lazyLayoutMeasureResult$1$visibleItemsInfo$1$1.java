package androidx.compose.foundation.lazy.list;

import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemInfo;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"androidx/compose/foundation/lazy/list/LazyListMeasureResult$lazyLayoutMeasureResult$1$visibleItemsInfo$1$1", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemInfo;", "index", "", "getIndex", "()I", "key", "", "getKey", "()Ljava/lang/Object;", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyListMeasureResult.kt */
public final class LazyListMeasureResult$lazyLayoutMeasureResult$1$visibleItemsInfo$1$1 implements LazyLayoutItemInfo {
    final /* synthetic */ LazyListItemInfo $it;

    LazyListMeasureResult$lazyLayoutMeasureResult$1$visibleItemsInfo$1$1(LazyListItemInfo lazyListItemInfo) {
        this.$it = lazyListItemInfo;
    }

    public int getIndex() {
        return this.$it.getIndex();
    }

    public Object getKey() {
        return this.$it.getKey();
    }
}
