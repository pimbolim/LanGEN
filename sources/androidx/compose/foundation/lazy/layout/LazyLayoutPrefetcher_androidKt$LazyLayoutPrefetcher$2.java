package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyLayoutPrefetcher.android.kt */
final class LazyLayoutPrefetcher_androidKt$LazyLayoutPrefetcher$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ LazyLayoutItemContentFactory $itemContentFactory;
    final /* synthetic */ LazyLayoutPrefetchPolicy $prefetchPolicy;
    final /* synthetic */ LazyLayoutState $state;
    final /* synthetic */ SubcomposeLayoutState $subcomposeLayoutState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutPrefetcher_androidKt$LazyLayoutPrefetcher$2(LazyLayoutPrefetchPolicy lazyLayoutPrefetchPolicy, LazyLayoutState lazyLayoutState, LazyLayoutItemContentFactory lazyLayoutItemContentFactory, SubcomposeLayoutState subcomposeLayoutState, int i) {
        super(2);
        this.$prefetchPolicy = lazyLayoutPrefetchPolicy;
        this.$state = lazyLayoutState;
        this.$itemContentFactory = lazyLayoutItemContentFactory;
        this.$subcomposeLayoutState = subcomposeLayoutState;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        LazyLayoutPrefetcher_androidKt.LazyLayoutPrefetcher(this.$prefetchPolicy, this.$state, this.$itemContentFactory, this.$subcomposeLayoutState, composer, this.$$changed | 1);
    }
}
