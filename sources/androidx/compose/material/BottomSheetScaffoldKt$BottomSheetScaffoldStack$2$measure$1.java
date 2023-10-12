package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomSheetScaffold.kt */
final class BottomSheetScaffoldKt$BottomSheetScaffoldStack$2$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ State<Float> $bottomSheetOffset;
    final /* synthetic */ long $constraints;
    final /* synthetic */ int $floatingActionButtonPosition;
    final /* synthetic */ List<Measurable> $measurables;
    final /* synthetic */ Placeable $placeable;
    final /* synthetic */ MeasureScope $this_Layout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheetScaffoldStack$2$measure$1(Placeable placeable, List<? extends Measurable> list, State<Float> state, int i, MeasureScope measureScope, long j) {
        super(1);
        this.$placeable = placeable;
        this.$measurables = list;
        this.$bottomSheetOffset = state;
        this.$floatingActionButtonPosition = i;
        this.$this_Layout = measureScope;
        this.$constraints = j;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        int i;
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        Placeable.PlacementScope.placeRelative$default(placementScope, this.$placeable, 0, 0, 0.0f, 4, (Object) null);
        Iterable<Measurable> drop = CollectionsKt.drop(this.$measurables, 1);
        long j = this.$constraints;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(drop, 10));
        for (Measurable r13 : drop) {
            arrayList.add(r13.m3151measureBRTryo0(Constraints.m3794copyZbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null)));
        }
        List list = (List) arrayList;
        Placeable placeable = (Placeable) list.get(1);
        Placeable placeable2 = (Placeable) list.get(2);
        int roundToInt = MathKt.roundToInt(this.$bottomSheetOffset.getValue().floatValue());
        Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list.get(0), 0, roundToInt, 0.0f, 4, (Object) null);
        if (FabPosition.m999equalsimpl0(this.$floatingActionButtonPosition, FabPosition.Companion.m1003getCenter5ygKITE())) {
            i = (this.$placeable.getWidth() - placeable.getWidth()) / 2;
        } else {
            i = (this.$placeable.getWidth() - placeable.getWidth()) - this.$this_Layout.m3822roundToPx0680j_4(BottomSheetScaffoldKt.FabEndSpacing);
        }
        Placeable.PlacementScope placementScope2 = placementScope;
        Placeable.PlacementScope.placeRelative$default(placementScope2, placeable, i, roundToInt - (placeable.getHeight() / 2), 0.0f, 4, (Object) null);
        Placeable.PlacementScope.placeRelative$default(placementScope2, placeable2, (this.$placeable.getWidth() - placeable2.getWidth()) / 2, this.$placeable.getHeight() - placeable2.getHeight(), 0.0f, 4, (Object) null);
    }
}
