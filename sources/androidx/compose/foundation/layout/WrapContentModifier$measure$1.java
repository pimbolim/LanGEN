package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Size.kt */
final class WrapContentModifier$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ MeasureScope $$receiver;
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ int $wrapperHeight;
    final /* synthetic */ int $wrapperWidth;
    final /* synthetic */ WrapContentModifier this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WrapContentModifier$measure$1(WrapContentModifier wrapContentModifier, int i, Placeable placeable, int i2, MeasureScope measureScope) {
        super(1);
        this.this$0 = wrapContentModifier;
        this.$wrapperWidth = i;
        this.$placeable = placeable;
        this.$wrapperHeight = i2;
        this.$$receiver = measureScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        Placeable.PlacementScope placementScope2 = placementScope;
        Placeable.PlacementScope.m3178place70tqf50$default(placementScope2, this.$placeable, ((IntOffset) this.this$0.alignmentCallback.invoke(IntSize.m4011boximpl(IntSizeKt.IntSize(this.$wrapperWidth - this.$placeable.getWidth(), this.$wrapperHeight - this.$placeable.getHeight())), this.$$receiver.getLayoutDirection())).m3986unboximpl(), 0.0f, 2, (Object) null);
    }
}
