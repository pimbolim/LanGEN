package androidx.compose.foundation.lazy;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/GridItemSpan;", "T", "Landroidx/compose/foundation/lazy/LazyGridItemSpanScope;", "it", "", "invoke-OHRMr_U", "(Landroidx/compose/foundation/lazy/LazyGridItemSpanScope;I)J"}, k = 3, mv = {1, 6, 0}, xi = 176)
/* compiled from: LazyGrid.kt */
final class LazyGridKt$itemsIndexed$3$1 extends Lambda implements Function2<LazyGridItemSpanScope, Integer, GridItemSpan> {
    final /* synthetic */ T[] $items;
    final /* synthetic */ Function3<LazyGridItemSpanScope, Integer, T, GridItemSpan> $spans;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyGridKt$itemsIndexed$3$1(Function3<? super LazyGridItemSpanScope, ? super Integer, ? super T, GridItemSpan> function3, T[] tArr) {
        super(2);
        this.$spans = function3;
        this.$items = tArr;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return GridItemSpan.m511boximpl(m523invokeOHRMr_U((LazyGridItemSpanScope) obj, ((Number) obj2).intValue()));
    }

    /* renamed from: invoke-OHRMr_U  reason: not valid java name */
    public final long m523invokeOHRMr_U(LazyGridItemSpanScope lazyGridItemSpanScope, int i) {
        Intrinsics.checkNotNullParameter(lazyGridItemSpanScope, "$this$null");
        return this.$spans.invoke(lazyGridItemSpanScope, Integer.valueOf(i), this.$items[i]).m518unboximpl();
    }
}
