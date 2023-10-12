package androidx.compose.material;

import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class ListItemKt$BaselinesOffsetColumn$1 implements MeasurePolicy {
    final /* synthetic */ List<Dp> $offsets;

    ListItemKt$BaselinesOffsetColumn$1(List<Dp> list) {
        this.$offsets = list;
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy.DefaultImpls.maxIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy.DefaultImpls.maxIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy.DefaultImpls.minIntrinsicHeight(this, intrinsicMeasureScope, list, i);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i) {
        return MeasurePolicy.DefaultImpls.minIntrinsicWidth(this, intrinsicMeasureScope, list, i);
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public final MeasureResult m1018measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int i;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        long r13 = Constraints.m3794copyZbe2FdA$default(j, 0, 0, 0, Integer.MAX_VALUE, 3, (Object) null);
        Iterable<Measurable> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Measurable r1 : iterable) {
            arrayList.add(r1.m3151measureBRTryo0(r13));
        }
        List<Placeable> list2 = (List) arrayList;
        int i2 = 0;
        for (Placeable width : list2) {
            i2 = Math.max(i2, width.getWidth());
        }
        int size = list2.size();
        Integer[] numArr = new Integer[size];
        for (int i3 = 0; i3 < size; i3++) {
            numArr[i3] = 0;
        }
        List<Dp> list3 = this.$offsets;
        int size2 = list2.size();
        int i4 = 0;
        int i5 = 0;
        while (i5 < size2) {
            int i6 = i5 + 1;
            Placeable placeable = (Placeable) list2.get(i5);
            if (i5 > 0) {
                int i7 = i5 - 1;
                i = ((Placeable) list2.get(i7)).getHeight() - ((Placeable) list2.get(i7)).get(AlignmentLineKt.getLastBaseline());
            } else {
                i = 0;
            }
            int max = Math.max(0, (measureScope.m3822roundToPx0680j_4(list3.get(i5).m3873unboximpl()) - placeable.get(AlignmentLineKt.getFirstBaseline())) - i);
            numArr[i5] = Integer.valueOf(max + i4);
            i4 += max + placeable.getHeight();
            i5 = i6;
        }
        return MeasureScope.DefaultImpls.layout$default(measureScope, i2, i4, (Map) null, new ListItemKt$BaselinesOffsetColumn$1$measure$2(list2, numArr), 4, (Object) null);
    }
}
