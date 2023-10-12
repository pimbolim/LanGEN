package androidx.compose.foundation.lazy.list;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\u001aF\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0000¨\u0006\f"}, d2 = {"findOrComposeLazyListHeader", "Landroidx/compose/foundation/lazy/list/LazyListPositionedItem;", "composedVisibleItems", "", "itemProvider", "Landroidx/compose/foundation/lazy/list/LazyMeasuredItemProvider;", "headerIndexes", "", "", "beforeContentPadding", "layoutWidth", "layoutHeight", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyListHeaders.kt */
public final class LazyListHeadersKt {
    public static final LazyListPositionedItem findOrComposeLazyListHeader(List<LazyListPositionedItem> list, LazyMeasuredItemProvider lazyMeasuredItemProvider, List<Integer> list2, int i, int i2, int i3) {
        List<LazyListPositionedItem> list3 = list;
        LazyMeasuredItemProvider lazyMeasuredItemProvider2 = lazyMeasuredItemProvider;
        List<Integer> list4 = list2;
        int i4 = i;
        Intrinsics.checkNotNullParameter(list3, "composedVisibleItems");
        Intrinsics.checkNotNullParameter(lazyMeasuredItemProvider2, "itemProvider");
        Intrinsics.checkNotNullParameter(list4, "headerIndexes");
        int index = ((LazyListPositionedItem) CollectionsKt.first(list)).getIndex();
        int size = list2.size();
        int i5 = 0;
        int i6 = -1;
        int i7 = -1;
        while (i5 < size) {
            int i8 = i5 + 1;
            if (list4.get(i5).intValue() > index) {
                break;
            }
            i6 = list4.get(i5).intValue();
            i7 = ((i8 < 0 || i8 > CollectionsKt.getLastIndex(list2)) ? -1 : list4.get(i8)).intValue();
            i5 = i8;
        }
        int size2 = list.size();
        int i9 = 0;
        int i10 = Integer.MIN_VALUE;
        int i11 = Integer.MIN_VALUE;
        int i12 = -1;
        while (i9 < size2) {
            int i13 = i9 + 1;
            LazyListPositionedItem lazyListPositionedItem = list3.get(i9);
            if (lazyListPositionedItem.getIndex() == i6) {
                i10 = lazyListPositionedItem.getOffset();
                i12 = i9;
            } else if (lazyListPositionedItem.getIndex() == i7) {
                i11 = lazyListPositionedItem.getOffset();
            }
            i9 = i13;
        }
        if (i6 == -1) {
            return null;
        }
        LazyMeasuredItem r1 = lazyMeasuredItemProvider2.m571getAndMeasureoA9DU0(DataIndex.m535constructorimpl(i6));
        int max = i10 != Integer.MIN_VALUE ? Math.max(-i4, i10) : -i4;
        if (i11 != Integer.MIN_VALUE) {
            max = Math.min(max, i11 - r1.getSize());
        }
        LazyListPositionedItem position = r1.position(max, i2, i3);
        if (i12 != -1) {
            list3.set(i12, position);
        } else {
            list3.add(0, position);
        }
        return position;
    }
}
