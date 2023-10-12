package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AlertDialog.kt */
final class AlertDialogKt$AlertDialogFlowRow$1$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {
    final /* synthetic */ List<Integer> $crossAxisPositions;
    final /* synthetic */ int $mainAxisLayoutSize;
    final /* synthetic */ float $mainAxisSpacing;
    final /* synthetic */ List<List<Placeable>> $sequences;
    final /* synthetic */ MeasureScope $this_Layout;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlertDialogKt$AlertDialogFlowRow$1$measure$1(List<List<Placeable>> list, MeasureScope measureScope, float f, int i, List<Integer> list2) {
        super(1);
        this.$sequences = list;
        this.$this_Layout = measureScope;
        this.$mainAxisSpacing = f;
        this.$mainAxisLayoutSize = i;
        this.$crossAxisPositions = list2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        List<List<Placeable>> list = this.$sequences;
        MeasureScope measureScope = this.$this_Layout;
        float f = this.$mainAxisSpacing;
        int i = this.$mainAxisLayoutSize;
        List<Integer> list2 = this.$crossAxisPositions;
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            List list3 = list.get(i2);
            int size2 = list3.size();
            int[] iArr = new int[size2];
            int i4 = 0;
            while (i4 < size2) {
                iArr[i4] = ((Placeable) list3.get(i4)).getWidth() + (i4 < CollectionsKt.getLastIndex(list3) ? measureScope.m3822roundToPx0680j_4(f) : 0);
                i4++;
            }
            Arrangement.Vertical bottom = Arrangement.INSTANCE.getBottom();
            int[] iArr2 = new int[size2];
            for (int i5 = 0; i5 < size2; i5++) {
                iArr2[i5] = 0;
            }
            bottom.arrange(measureScope, i, iArr, iArr2);
            int i6 = 0;
            for (int size3 = list3.size(); i6 < size3; size3 = size3) {
                Placeable.PlacementScope.place$default(placementScope, (Placeable) list3.get(i6), iArr2[i6], list2.get(i2).intValue(), 0.0f, 4, (Object) null);
                i6++;
                iArr2 = iArr2;
                list3 = list3;
                i2 = i2;
            }
            i2 = i3;
        }
    }
}
