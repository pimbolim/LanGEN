package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Padding.kt */
final class PaddingValuesModifier$measure$2 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ MeasureScope $$receiver;
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ PaddingValuesModifier this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaddingValuesModifier$measure$2(Placeable placeable, MeasureScope measureScope, PaddingValuesModifier paddingValuesModifier) {
        super(1);
        this.$placeable = placeable;
        this.$$receiver = measureScope;
        this.this$0 = paddingValuesModifier;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        Placeable.PlacementScope.place$default(placementScope, this.$placeable, this.$$receiver.m3822roundToPx0680j_4(this.this$0.getPaddingValues().m442calculateLeftPaddingu2uoSUM(this.$$receiver.getLayoutDirection())), this.$$receiver.m3822roundToPx0680j_4(this.this$0.getPaddingValues().m444calculateTopPaddingD9Ej5fM()), 0.0f, 4, (Object) null);
    }
}
