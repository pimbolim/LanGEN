package androidx.compose.foundation.lazy.list;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.gestures.OverScrollController;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureResult;
import androidx.compose.foundation.lazy.layout.LazyLayoutPlaceablesProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchPolicy;
import androidx.compose.foundation.lazy.layout.LazyMeasurePolicy;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyList.kt */
final class LazyListKt$rememberLazyListMeasurePolicy$1$1 implements LazyMeasurePolicy {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ Ref<LazyItemScopeImpl> $itemScope;
    final /* synthetic */ OverScrollController $overScrollController;
    final /* synthetic */ LazyListItemPlacementAnimator $placementAnimator;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyListState $state;
    final /* synthetic */ State<LazyListItemsProvider> $stateOfItemsProvider;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    LazyListKt$rememberLazyListMeasurePolicy$1$1(boolean z, PaddingValues paddingValues, boolean z2, State<? extends LazyListItemsProvider> state, LazyListState lazyListState, Ref<LazyItemScopeImpl> ref, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, Alignment.Horizontal horizontal2, Alignment.Vertical vertical2, OverScrollController overScrollController) {
        this.$isVertical = z;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z2;
        this.$stateOfItemsProvider = state;
        this.$state = lazyListState;
        this.$itemScope = ref;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$placementAnimator = lazyListItemPlacementAnimator;
        this.$horizontalAlignment = horizontal2;
        this.$verticalAlignment = vertical2;
        this.$overScrollController = overScrollController;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final LazyLayoutMeasureResult m560measure3p2s80s(MeasureScope measureScope, LazyLayoutPlaceablesProvider lazyLayoutPlaceablesProvider, long j) {
        int i;
        float f;
        int i2;
        MeasureScope measureScope2 = measureScope;
        long j2 = j;
        Intrinsics.checkNotNullParameter(measureScope2, "$this$LazyMeasurePolicy");
        Intrinsics.checkNotNullParameter(lazyLayoutPlaceablesProvider, "placeablesProvider");
        ScrollKt.m221assertNotNestingScrollableContainersK40F9xA(j2, this.$isVertical);
        int r5 = measureScope2.m3822roundToPx0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, measureScope.getLayoutDirection()));
        int r1 = measureScope2.m3822roundToPx0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, measureScope.getLayoutDirection()));
        int r6 = measureScope2.m3822roundToPx0680j_4(this.$contentPadding.m444calculateTopPaddingD9Ej5fM());
        int r2 = measureScope2.m3822roundToPx0680j_4(this.$contentPadding.m441calculateBottomPaddingD9Ej5fM());
        int i3 = r6 + r2;
        int i4 = r5 + r1;
        boolean z = this.$isVertical;
        int i5 = z ? i3 : i4;
        if (z && !this.$reverseLayout) {
            i = r6;
        } else if (!z || !this.$reverseLayout) {
            i = (z || this.$reverseLayout) ? r1 : r5;
        } else {
            i = r2;
        }
        int i6 = i5 - i;
        long r8 = ConstraintsKt.m3819offsetNN6EwU(j2, -i4, -i3);
        LazyListItemsProvider value = this.$stateOfItemsProvider.getValue();
        this.$state.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(value);
        Density density = measureScope2;
        this.$state.setDensity$foundation_release(density);
        LazyListKt.m559update3p2s80s(this.$itemScope, density, r8);
        if (this.$isVertical) {
            Arrangement.Vertical vertical = this.$verticalArrangement;
            if (vertical != null) {
                f = vertical.m375getSpacingD9Ej5fM();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            Arrangement.Horizontal horizontal = this.$horizontalArrangement;
            if (horizontal != null) {
                f = horizontal.m361getSpacingD9Ej5fM();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        int r3 = measureScope2.m3822roundToPx0680j_4(f);
        int itemsCount = value.getItemsCount();
        boolean z2 = this.$isVertical;
        Density density2 = density;
        LazyListItemsProvider lazyListItemsProvider = value;
        long j3 = r8;
        int i7 = i4;
        int i8 = i3;
        LazyMeasuredItemProvider lazyMeasuredItemProvider = new LazyMeasuredItemProvider(j3, z2, lazyListItemsProvider, lazyLayoutPlaceablesProvider, new LazyListKt$rememberLazyListMeasurePolicy$1$1$measure$itemProvider$1(itemsCount, r3, measureScope, r5, r6, z2, this.$horizontalAlignment, this.$verticalAlignment, this.$reverseLayout, i, i6, this.$placementAnimator), (DefaultConstructorMarker) null);
        LazyLayoutPrefetchPolicy prefetchPolicy$foundation_release = this.$state.getPrefetchPolicy$foundation_release();
        if (prefetchPolicy$foundation_release != null) {
            prefetchPolicy$foundation_release.m531setConstraintsBRTryo0(lazyMeasuredItemProvider.m572getChildConstraintsmsEJaDk());
        }
        if (this.$isVertical) {
            i2 = Constraints.m3802getMaxHeightimpl(j) - i8;
        } else {
            i2 = Constraints.m3803getMaxWidthimpl(j) - i7;
        }
        long j4 = j;
        int i9 = i7;
        int i10 = i8;
        LazyListMeasureResult r7 = LazyListMeasureKt.m562measureLazyListwroFCeY(itemsCount, lazyMeasuredItemProvider, i2, i, i6, this.$state.m526getFirstVisibleItemIndexNonObservableAUyieIw$foundation_release(), this.$state.getFirstVisibleItemScrollOffsetNonObservable$foundation_release(), this.$state.getScrollToBeConsumed$foundation_release(), j3, this.$isVertical, lazyListItemsProvider.getHeaderIndexes(), this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, density2, measureScope.getLayoutDirection(), this.$placementAnimator, new LazyListKt$rememberLazyListMeasurePolicy$1$1$measure$1(measureScope, j4, i9, i10));
        LazyListState lazyListState = this.$state;
        OverScrollController overScrollController = this.$overScrollController;
        lazyListState.applyMeasureResult$foundation_release(r7);
        LazyListKt.m558refreshOverScrollInfoL1NQ6kE(overScrollController, r7, j4, i9, i10);
        return r7.getLazyLayoutMeasureResult();
    }
}
