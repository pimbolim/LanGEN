package androidx.compose.foundation.lazy;

import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyGrid.kt */
final class LazyGridKt$ItemRow$2$measure$3 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ List<Placeable> $placeables;
    final /* synthetic */ int $spacing;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyGridKt$ItemRow$2$measure$3(List<? extends Placeable> list, int i) {
        super(1);
        this.$placeables = list;
        this.$spacing = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        List<Placeable> list = this.$placeables;
        int i = this.$spacing;
        int size = list.size();
        int i2 = 0;
        int i3 = 0;
        while (i2 < size) {
            int i4 = i2 + 1;
            Placeable placeable = list.get(i2);
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i3, 0, 0.0f, 4, (Object) null);
            i3 += placeable.getWidth() + i;
            i2 = i4;
        }
    }
}
