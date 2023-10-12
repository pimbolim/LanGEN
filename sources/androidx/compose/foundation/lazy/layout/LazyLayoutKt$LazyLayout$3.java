package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyLayout.kt */
final class LazyLayoutKt$LazyLayout$3 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ Function0<LazyLayoutItemsProvider> $itemsProvider;
    final /* synthetic */ LazyMeasurePolicy $measurePolicy;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ LazyLayoutPrefetchPolicy $prefetchPolicy;
    final /* synthetic */ LazyLayoutState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyLayoutKt$LazyLayout$3(Function0<? extends LazyLayoutItemsProvider> function0, Modifier modifier, LazyLayoutState lazyLayoutState, LazyLayoutPrefetchPolicy lazyLayoutPrefetchPolicy, LazyMeasurePolicy lazyMeasurePolicy, int i, int i2) {
        super(2);
        this.$itemsProvider = function0;
        this.$modifier = modifier;
        this.$state = lazyLayoutState;
        this.$prefetchPolicy = lazyLayoutPrefetchPolicy;
        this.$measurePolicy = lazyMeasurePolicy;
        this.$$changed = i;
        this.$$default = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        LazyLayoutKt.LazyLayout(this.$itemsProvider, this.$modifier, this.$state, this.$prefetchPolicy, this.$measurePolicy, composer, this.$$changed | 1, this.$$default);
    }
}
