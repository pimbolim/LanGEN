package androidx.compose.foundation.lazy.list;

import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyList.kt */
final class LazyListKt$rememberLazyListMeasurePolicy$1$1$measure$1 extends Lambda implements Function3<Integer, Integer, Function1<? super Placeable.PlacementScope, ? extends Unit>, MeasureResult> {
    final /* synthetic */ long $containerConstraints;
    final /* synthetic */ MeasureScope $this_LazyMeasurePolicy;
    final /* synthetic */ int $totalHorizontalPadding;
    final /* synthetic */ int $totalVerticalPadding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListKt$rememberLazyListMeasurePolicy$1$1$measure$1(MeasureScope measureScope, long j, int i, int i2) {
        super(3);
        this.$this_LazyMeasurePolicy = measureScope;
        this.$containerConstraints = j;
        this.$totalHorizontalPadding = i;
        this.$totalVerticalPadding = i2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke(((Number) obj).intValue(), ((Number) obj2).intValue(), (Function1<? super Placeable.PlacementScope, Unit>) (Function1) obj3);
    }

    public final MeasureResult invoke(int i, int i2, Function1<? super Placeable.PlacementScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "placement");
        return this.$this_LazyMeasurePolicy.layout(ConstraintsKt.m3817constrainWidthK40F9xA(this.$containerConstraints, i + this.$totalHorizontalPadding), ConstraintsKt.m3816constrainHeightK40F9xA(this.$containerConstraints, i2 + this.$totalVerticalPadding), MapsKt.emptyMap(), function1);
    }
}
