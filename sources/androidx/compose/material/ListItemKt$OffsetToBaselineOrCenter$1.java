package androidx.compose.material;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ListItem.kt */
final class ListItemKt$OffsetToBaselineOrCenter$1 implements MeasurePolicy {
    final /* synthetic */ float $offset;

    ListItemKt$OffsetToBaselineOrCenter$1(float f) {
        this.$offset = f;
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
    public final MeasureResult m1019measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        Placeable r11 = ((Measurable) list.get(0)).m3151measureBRTryo0(Constraints.m3794copyZbe2FdA$default(j, 0, 0, 0, 0, 11, (Object) null));
        int i3 = r11.get(AlignmentLineKt.getFirstBaseline());
        if (i3 != Integer.MIN_VALUE) {
            i2 = measureScope.m3822roundToPx0680j_4(this.$offset) - i3;
            i = Math.max(Constraints.m3804getMinHeightimpl(j), r11.getHeight() + i2);
        } else {
            i = Math.max(Constraints.m3804getMinHeightimpl(j), r11.getHeight());
            i2 = IntOffset.m3978getYimpl(Alignment.Companion.getCenter().m1253alignKFBX0sM(IntSize.Companion.m4024getZeroYbymL2g(), IntSizeKt.IntSize(0, i - r11.getHeight()), measureScope.getLayoutDirection()));
        }
        return MeasureScope.DefaultImpls.layout$default(measureScope, r11.getWidth(), i, (Map) null, new ListItemKt$OffsetToBaselineOrCenter$1$measure$1(r11, i2), 4, (Object) null);
    }
}
