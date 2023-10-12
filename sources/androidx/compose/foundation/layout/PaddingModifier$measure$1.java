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
final class PaddingModifier$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ MeasureScope $$receiver;
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ PaddingModifier this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaddingModifier$measure$1(PaddingModifier paddingModifier, Placeable placeable, MeasureScope measureScope) {
        super(1);
        this.this$0 = paddingModifier;
        this.$placeable = placeable;
        this.$$receiver = measureScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        if (this.this$0.getRtlAware()) {
            Placeable.PlacementScope.placeRelative$default(placementScope, this.$placeable, this.$$receiver.m3822roundToPx0680j_4(this.this$0.m438getStartD9Ej5fM()), this.$$receiver.m3822roundToPx0680j_4(this.this$0.m439getTopD9Ej5fM()), 0.0f, 4, (Object) null);
            return;
        }
        Placeable.PlacementScope.place$default(placementScope, this.$placeable, this.$$receiver.m3822roundToPx0680j_4(this.this$0.m438getStartD9Ej5fM()), this.$$receiver.m3822roundToPx0680j_4(this.this$0.m439getTopD9Ej5fM()), 0.0f, 4, (Object) null);
    }
}
