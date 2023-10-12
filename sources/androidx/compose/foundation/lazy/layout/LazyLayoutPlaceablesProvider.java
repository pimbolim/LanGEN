package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ)\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R6\u0010\t\u001a*\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\nj\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f`\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPlaceablesProvider;", "", "itemsProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemsProvider;", "itemContentFactory", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "subcomposeMeasureScope", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemsProvider;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;Landroidx/compose/ui/layout/SubcomposeMeasureScope;)V", "placeablesCache", "Ljava/util/HashMap;", "", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPlaceable;", "Lkotlin/collections/HashMap;", "getAndMeasure", "index", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getAndMeasure-0kLqBqw", "(IJ)[Landroidx/compose/foundation/lazy/layout/LazyLayoutPlaceable;", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyMeasurePolicy.kt */
public final class LazyLayoutPlaceablesProvider {
    private final LazyLayoutItemContentFactory itemContentFactory;
    private final LazyLayoutItemsProvider itemsProvider;
    private final HashMap<Integer, LazyLayoutPlaceable[]> placeablesCache = new HashMap<>();
    private final SubcomposeMeasureScope subcomposeMeasureScope;

    public LazyLayoutPlaceablesProvider(LazyLayoutItemsProvider lazyLayoutItemsProvider, LazyLayoutItemContentFactory lazyLayoutItemContentFactory, SubcomposeMeasureScope subcomposeMeasureScope2) {
        Intrinsics.checkNotNullParameter(lazyLayoutItemsProvider, "itemsProvider");
        Intrinsics.checkNotNullParameter(lazyLayoutItemContentFactory, "itemContentFactory");
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope2, "subcomposeMeasureScope");
        this.itemsProvider = lazyLayoutItemsProvider;
        this.itemContentFactory = lazyLayoutItemContentFactory;
        this.subcomposeMeasureScope = subcomposeMeasureScope2;
    }

    /* renamed from: getAndMeasure-0kLqBqw  reason: not valid java name */
    public final LazyLayoutPlaceable[] m529getAndMeasure0kLqBqw(int i, long j) {
        LazyLayoutPlaceable[] lazyLayoutPlaceableArr = this.placeablesCache.get(Integer.valueOf(i));
        if (lazyLayoutPlaceableArr != null) {
            return lazyLayoutPlaceableArr;
        }
        Object key = this.itemsProvider.getKey(i);
        List<Measurable> subcompose = this.subcomposeMeasureScope.subcompose(key, this.itemContentFactory.getContent(i, key));
        int size = subcompose.size();
        LazyLayoutPlaceable[] lazyLayoutPlaceableArr2 = new LazyLayoutPlaceable[size];
        for (int i2 = 0; i2 < size; i2++) {
            Measurable measurable = subcompose.get(i2);
            lazyLayoutPlaceableArr2[i2] = new LazyLayoutPlaceable(measurable.m3151measureBRTryo0(j), measurable.getParentData());
        }
        this.placeablesCache.put(Integer.valueOf(i), lazyLayoutPlaceableArr2);
        return lazyLayoutPlaceableArr2;
    }
}
