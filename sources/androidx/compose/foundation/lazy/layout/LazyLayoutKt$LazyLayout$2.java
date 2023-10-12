package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyLayout.kt */
final class LazyLayoutKt$LazyLayout$2 extends Lambda implements Function2<SubcomposeMeasureScope, Constraints, MeasureResult> {
    final /* synthetic */ LazyLayoutItemContentFactory $itemContentFactory;
    final /* synthetic */ LazyMeasurePolicy $measurePolicy;
    final /* synthetic */ LazyLayoutState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutKt$LazyLayout$2(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, LazyLayoutState lazyLayoutState, LazyMeasurePolicy lazyMeasurePolicy) {
        super(2);
        this.$itemContentFactory = lazyLayoutItemContentFactory;
        this.$state = lazyLayoutState;
        this.$measurePolicy = lazyMeasurePolicy;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m528invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).m3809unboximpl());
    }

    /* renamed from: invoke-0kLqBqw  reason: not valid java name */
    public final MeasureResult m528invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
        Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "$this$SubcomposeLayout");
        this.$itemContentFactory.m527onBeforeMeasure0kLqBqw(subcomposeMeasureScope, j);
        LazyLayoutPlaceablesProvider lazyLayoutPlaceablesProvider = new LazyLayoutPlaceablesProvider(this.$state.getItemsProvider$foundation_release().invoke(), this.$itemContentFactory, subcomposeMeasureScope);
        LazyLayoutMeasureResult r4 = this.$measurePolicy.m532measure3p2s80s(subcomposeMeasureScope, lazyLayoutPlaceablesProvider, j);
        LazyLayoutOnPostMeasureListener onPostMeasureListener$foundation_release = this.$state.getOnPostMeasureListener$foundation_release();
        if (onPostMeasureListener$foundation_release != null) {
            onPostMeasureListener$foundation_release.onPostMeasure(r4, lazyLayoutPlaceablesProvider);
        }
        this.$state.getLayoutInfoState$foundation_release().setValue(r4);
        this.$state.setLayoutInfoNonObservable$foundation_release(r4);
        return r4;
    }
}
