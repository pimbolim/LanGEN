package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Box.kt */
final class BoxKt$boxMeasurePolicy$1 implements MeasurePolicy {
    final /* synthetic */ Alignment $alignment;
    final /* synthetic */ boolean $propagateMinConstraints;

    BoxKt$boxMeasurePolicy$1(boolean z, Alignment alignment) {
        this.$propagateMinConstraints = z;
        this.$alignment = alignment;
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
    public final MeasureResult m388measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        long j2;
        int i;
        Placeable placeable;
        int i2;
        List<? extends Measurable> list2 = list;
        Intrinsics.checkNotNullParameter(measureScope, "$this$MeasurePolicy");
        Intrinsics.checkNotNullParameter(list2, "measurables");
        if (list.isEmpty()) {
            return MeasureScope.DefaultImpls.layout$default(measureScope, Constraints.m3805getMinWidthimpl(j), Constraints.m3804getMinHeightimpl(j), (Map) null, BoxKt$boxMeasurePolicy$1$measure$1.INSTANCE, 4, (Object) null);
        }
        if (this.$propagateMinConstraints) {
            j2 = j;
        } else {
            j2 = Constraints.m3794copyZbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null);
        }
        int i3 = 0;
        if (list.size() == 1) {
            Measurable measurable = (Measurable) list2.get(0);
            if (!BoxKt.getMatchesParentSize(measurable)) {
                Placeable r1 = measurable.m3151measureBRTryo0(j2);
                int max = Math.max(Constraints.m3805getMinWidthimpl(j), r1.getWidth());
                i = Math.max(Constraints.m3804getMinHeightimpl(j), r1.getHeight());
                placeable = r1;
                i2 = max;
            } else {
                i2 = Constraints.m3805getMinWidthimpl(j);
                int r2 = Constraints.m3804getMinHeightimpl(j);
                placeable = measurable.m3151measureBRTryo0(Constraints.Companion.m3811fixedJhjzzOo(Constraints.m3805getMinWidthimpl(j), Constraints.m3804getMinHeightimpl(j)));
                i = r2;
            }
            return MeasureScope.DefaultImpls.layout$default(measureScope, i2, i, (Map) null, new BoxKt$boxMeasurePolicy$1$measure$2(placeable, measurable, measureScope, i2, i, this.$alignment), 4, (Object) null);
        }
        Placeable[] placeableArr = new Placeable[list.size()];
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = Constraints.m3805getMinWidthimpl(j);
        Ref.IntRef intRef2 = new Ref.IntRef();
        intRef2.element = Constraints.m3804getMinHeightimpl(j);
        int size = list.size();
        int i4 = 0;
        boolean z = false;
        while (i4 < size) {
            int i5 = i4 + 1;
            Measurable measurable2 = (Measurable) list2.get(i4);
            if (!BoxKt.getMatchesParentSize(measurable2)) {
                Placeable r14 = measurable2.m3151measureBRTryo0(j2);
                placeableArr[i4] = r14;
                intRef.element = Math.max(intRef.element, r14.getWidth());
                intRef2.element = Math.max(intRef2.element, r14.getHeight());
            } else {
                z = true;
            }
            i4 = i5;
        }
        if (z) {
            long Constraints = ConstraintsKt.Constraints(intRef.element != Integer.MAX_VALUE ? intRef.element : 0, intRef.element, intRef2.element != Integer.MAX_VALUE ? intRef2.element : 0, intRef2.element);
            int size2 = list.size();
            while (i3 < size2) {
                int i6 = i3 + 1;
                Measurable measurable3 = (Measurable) list2.get(i3);
                if (BoxKt.getMatchesParentSize(measurable3)) {
                    placeableArr[i3] = measurable3.m3151measureBRTryo0(Constraints);
                }
                i3 = i6;
            }
        }
        return MeasureScope.DefaultImpls.layout$default(measureScope, intRef.element, intRef2.element, (Map) null, new BoxKt$boxMeasurePolicy$1$measure$5(placeableArr, list, measureScope, intRef, intRef2, this.$alignment), 4, (Object) null);
    }
}
