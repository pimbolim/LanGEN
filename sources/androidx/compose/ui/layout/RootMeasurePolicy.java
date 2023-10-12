package androidx.compose.ui.layout;

import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"Landroidx/compose/ui/layout/RootMeasurePolicy;", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RootMeasurePolicy.kt */
public final class RootMeasurePolicy extends LayoutNode.NoIntrinsicsMeasurePolicy {
    public static final RootMeasurePolicy INSTANCE = new RootMeasurePolicy();

    private RootMeasurePolicy() {
        super("Undefined intrinsics block and it is required");
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m3188measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$receiver");
        Intrinsics.checkNotNullParameter(list, "measurables");
        if (list.isEmpty()) {
            return MeasureScope.DefaultImpls.layout$default(measureScope, Constraints.m3805getMinWidthimpl(j), Constraints.m3804getMinHeightimpl(j), (Map) null, RootMeasurePolicy$measure$1.INSTANCE, 4, (Object) null);
        }
        int i = 0;
        if (list.size() == 1) {
            Placeable r0 = ((Measurable) list.get(0)).m3151measureBRTryo0(j);
            return MeasureScope.DefaultImpls.layout$default(measureScope, ConstraintsKt.m3817constrainWidthK40F9xA(j, r0.getWidth()), ConstraintsKt.m3816constrainHeightK40F9xA(j, r0.getHeight()), (Map) null, new RootMeasurePolicy$measure$2(r0), 4, (Object) null);
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((Measurable) list.get(i2)).m3151measureBRTryo0(j));
        }
        List list2 = arrayList;
        int size2 = list2.size();
        int i3 = 0;
        int i4 = 0;
        while (i < size2) {
            int i5 = i + 1;
            Placeable placeable = (Placeable) list2.get(i);
            i3 = Math.max(placeable.getWidth(), i3);
            i4 = Math.max(placeable.getHeight(), i4);
            i = i5;
        }
        return MeasureScope.DefaultImpls.layout$default(measureScope, ConstraintsKt.m3817constrainWidthK40F9xA(j, i3), ConstraintsKt.m3816constrainHeightK40F9xA(j, i4), (Map) null, new RootMeasurePolicy$measure$4(list2), 4, (Object) null);
    }
}
