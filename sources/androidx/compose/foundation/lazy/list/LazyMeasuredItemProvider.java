package androidx.compose.foundation.lazy.list;

import androidx.compose.foundation.lazy.layout.LazyLayoutPlaceablesProvider;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B0\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0002\u0010\fJ\u001b\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\r\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00130\u00128F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/lazy/list/LazyMeasuredItemProvider;", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "itemsProvider", "Landroidx/compose/foundation/lazy/list/LazyListItemsProvider;", "placeablesProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPlaceablesProvider;", "measuredItemFactory", "Landroidx/compose/foundation/lazy/list/MeasuredItemFactory;", "(JZLandroidx/compose/foundation/lazy/list/LazyListItemsProvider;Landroidx/compose/foundation/lazy/layout/LazyLayoutPlaceablesProvider;Landroidx/compose/foundation/lazy/list/MeasuredItemFactory;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "childConstraints", "getChildConstraints-msEJaDk", "()J", "J", "keyToIndexMap", "", "", "getKeyToIndexMap", "()Ljava/util/Map;", "getAndMeasure", "Landroidx/compose/foundation/lazy/list/LazyMeasuredItem;", "index", "Landroidx/compose/foundation/lazy/list/DataIndex;", "getAndMeasure-oA9-DU0", "(I)Landroidx/compose/foundation/lazy/list/LazyMeasuredItem;", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyMeasuredItemProvider.kt */
public final class LazyMeasuredItemProvider {
    private final long childConstraints;
    private final LazyListItemsProvider itemsProvider;
    private final MeasuredItemFactory measuredItemFactory;
    private final LazyLayoutPlaceablesProvider placeablesProvider;

    public /* synthetic */ LazyMeasuredItemProvider(long j, boolean z, LazyListItemsProvider lazyListItemsProvider, LazyLayoutPlaceablesProvider lazyLayoutPlaceablesProvider, MeasuredItemFactory measuredItemFactory2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, z, lazyListItemsProvider, lazyLayoutPlaceablesProvider, measuredItemFactory2);
    }

    private LazyMeasuredItemProvider(long j, boolean z, LazyListItemsProvider lazyListItemsProvider, LazyLayoutPlaceablesProvider lazyLayoutPlaceablesProvider, MeasuredItemFactory measuredItemFactory2) {
        this.itemsProvider = lazyListItemsProvider;
        this.placeablesProvider = lazyLayoutPlaceablesProvider;
        this.measuredItemFactory = measuredItemFactory2;
        this.childConstraints = ConstraintsKt.Constraints$default(0, z ? Constraints.m3803getMaxWidthimpl(j) : Integer.MAX_VALUE, 0, !z ? Constraints.m3802getMaxHeightimpl(j) : Integer.MAX_VALUE, 5, (Object) null);
    }

    /* renamed from: getChildConstraints-msEJaDk  reason: not valid java name */
    public final long m572getChildConstraintsmsEJaDk() {
        return this.childConstraints;
    }

    /* renamed from: getAndMeasure-oA9-DU0  reason: not valid java name */
    public final LazyMeasuredItem m571getAndMeasureoA9DU0(int i) {
        return this.measuredItemFactory.m573createItem8xJyyfI(i, this.itemsProvider.getKey(i), this.placeablesProvider.m529getAndMeasure0kLqBqw(i, m572getChildConstraintsmsEJaDk()));
    }

    public final Map<Object, Integer> getKeyToIndexMap() {
        return this.itemsProvider.getKeyToIndexMap();
    }
}
