package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: OuterMeasurablePlaceable.kt */
final class OuterMeasurablePlaceable$placeAt$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<GraphicsLayerScope, Unit> $layerBlock;
    final /* synthetic */ long $position;
    final /* synthetic */ float $zIndex;
    final /* synthetic */ OuterMeasurablePlaceable this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OuterMeasurablePlaceable$placeAt$1(OuterMeasurablePlaceable outerMeasurablePlaceable, long j, float f, Function1<? super GraphicsLayerScope, Unit> function1) {
        super(0);
        this.this$0 = outerMeasurablePlaceable;
        this.$position = j;
        this.$zIndex = f;
        this.$layerBlock = function1;
    }

    public final void invoke() {
        this.this$0.m3362placeOuterWrapperf8xVGno(this.$position, this.$zIndex, this.$layerBlock);
    }
}
