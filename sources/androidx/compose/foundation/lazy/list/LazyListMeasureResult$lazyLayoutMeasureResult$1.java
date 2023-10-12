package androidx.compose.foundation.lazy.list;

import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureResult;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\t\u0010\u0013\u001a\u00020\u0014H\u0001R\u001e\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0005¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\u0006X\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0006X\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0015"}, d2 = {"androidx/compose/foundation/lazy/list/LazyListMeasureResult$lazyLayoutMeasureResult$1", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureResult;", "Landroidx/compose/ui/layout/MeasureResult;", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "getAlignmentLines", "()Ljava/util/Map;", "height", "getHeight", "()I", "visibleItemsInfo", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemInfo;", "getVisibleItemsInfo", "()Ljava/util/List;", "width", "getWidth", "placeChildren", "", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyListMeasureResult.kt */
public final class LazyListMeasureResult$lazyLayoutMeasureResult$1 implements LazyLayoutMeasureResult, MeasureResult {
    private final /* synthetic */ MeasureResult $$delegate_0;
    final /* synthetic */ LazyListMeasureResult this$0;

    public Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$$delegate_0.getAlignmentLines();
    }

    public int getHeight() {
        return this.$$delegate_0.getHeight();
    }

    public int getWidth() {
        return this.$$delegate_0.getWidth();
    }

    public void placeChildren() {
        this.$$delegate_0.placeChildren();
    }

    LazyListMeasureResult$lazyLayoutMeasureResult$1(LazyListMeasureResult lazyListMeasureResult) {
        this.this$0 = lazyListMeasureResult;
        this.$$delegate_0 = lazyListMeasureResult.getMeasureResult();
    }

    public List<LazyLayoutItemInfo> getVisibleItemsInfo() {
        List<LazyListItemInfo> visibleItemsInfo = this.this$0.getVisibleItemsInfo();
        ArrayList arrayList = new ArrayList(visibleItemsInfo.size());
        int size = visibleItemsInfo.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new LazyListMeasureResult$lazyLayoutMeasureResult$1$visibleItemsInfo$1$1(visibleItemsInfo.get(i)));
        }
        return arrayList;
    }
}
