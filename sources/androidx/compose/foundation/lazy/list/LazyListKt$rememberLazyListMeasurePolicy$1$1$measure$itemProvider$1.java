package androidx.compose.foundation.lazy.list;

import androidx.compose.foundation.lazy.layout.LazyLayoutPlaceable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyList.kt */
final class LazyListKt$rememberLazyListMeasurePolicy$1$1$measure$itemProvider$1 implements MeasuredItemFactory {
    final /* synthetic */ int $afterContentPadding;
    final /* synthetic */ int $beforeContentPadding;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ int $itemsCount;
    final /* synthetic */ LazyListItemPlacementAnimator $placementAnimator;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ int $spaceBetweenItems;
    final /* synthetic */ int $startPadding;
    final /* synthetic */ MeasureScope $this_LazyMeasurePolicy;
    final /* synthetic */ int $topPadding;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;

    LazyListKt$rememberLazyListMeasurePolicy$1$1$measure$itemProvider$1(int i, int i2, MeasureScope measureScope, int i3, int i4, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, boolean z2, int i5, int i6, LazyListItemPlacementAnimator lazyListItemPlacementAnimator) {
        this.$itemsCount = i;
        this.$spaceBetweenItems = i2;
        this.$this_LazyMeasurePolicy = measureScope;
        this.$startPadding = i3;
        this.$topPadding = i4;
        this.$isVertical = z;
        this.$horizontalAlignment = horizontal;
        this.$verticalAlignment = vertical;
        this.$reverseLayout = z2;
        this.$beforeContentPadding = i5;
        this.$afterContentPadding = i6;
        this.$placementAnimator = lazyListItemPlacementAnimator;
    }

    /* renamed from: createItem-8xJyyfI  reason: not valid java name */
    public final LazyMeasuredItem m561createItem8xJyyfI(int i, Object obj, LazyLayoutPlaceable[] lazyLayoutPlaceableArr) {
        Intrinsics.checkNotNullParameter(obj, "key");
        Intrinsics.checkNotNullParameter(lazyLayoutPlaceableArr, "placeables");
        return new LazyMeasuredItem(i, lazyLayoutPlaceableArr, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_LazyMeasurePolicy.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, this.$placementAnimator, i == this.$itemsCount + -1 ? 0 : this.$spaceBetweenItems, IntOffsetKt.IntOffset(this.$startPadding, this.$topPadding), obj, (DefaultConstructorMarker) null);
    }
}
