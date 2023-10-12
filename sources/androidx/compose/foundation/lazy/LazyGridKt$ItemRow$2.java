package androidx.compose.foundation.lazy;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyGrid.kt */
final class LazyGridKt$ItemRow$2 implements MeasurePolicy {
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ int $nColumns;
    final /* synthetic */ List<Pair<Function2<Composer, Integer, Unit>, Integer>> $rowContent;

    LazyGridKt$ItemRow$2(List<? extends Pair<? extends Function2<? super Composer, ? super Integer, Unit>, Integer>> list, Arrangement.Horizontal horizontal, int i) {
        this.$rowContent = list;
        this.$horizontalArrangement = horizontal;
        this.$nColumns = i;
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
    public final MeasureResult m519measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Comparable comparable;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        Intrinsics.checkNotNullParameter(measureScope2, "$this$Layout");
        Intrinsics.checkNotNullParameter(list2, "measurables");
        int i = 1;
        if (!(list.size() == this.$rowContent.size())) {
            throw new IllegalStateException("Check failed.".toString());
        } else if (list.isEmpty()) {
            return MeasureScope.DefaultImpls.layout$default(measureScope, Constraints.m3805getMinWidthimpl(j), Constraints.m3804getMinHeightimpl(j), (Map) null, LazyGridKt$ItemRow$2$measure$1.INSTANCE, 4, (Object) null);
        } else {
            int r3 = measureScope2.m3822roundToPx0680j_4(this.$horizontalArrangement.m361getSpacingD9Ej5fM());
            int max = Math.max(Constraints.m3803getMaxWidthimpl(j) - ((this.$nColumns - 1) * r3), 0) / this.$nColumns;
            int r7 = Constraints.m3803getMaxWidthimpl(j);
            int i2 = this.$nColumns;
            int max2 = Math.max((r7 - (max * i2)) - ((i2 - 1) * r3), 0);
            List<Pair<Function2<Composer, Integer, Unit>, Integer>> list3 = this.$rowContent;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            int i3 = 0;
            while (i3 < size) {
                int i4 = i3 + 1;
                int intValue = ((Number) list3.get(i3).getSecond()).intValue();
                int min = Math.min(max2, intValue);
                max2 -= min;
                Placeable r11 = ((Measurable) list2.get(i3)).m3151measureBRTryo0(Constraints.Companion.m3813fixedWidthOenEA2s((intValue * max) + min + ((intValue - 1) * r3)));
                if (r11 != null) {
                    arrayList.add(r11);
                }
                i3 = i4;
            }
            List list4 = arrayList;
            int r2 = Constraints.m3803getMaxWidthimpl(j);
            if (list4.isEmpty()) {
                comparable = null;
            } else {
                comparable = Integer.valueOf(((Placeable) list4.get(0)).getHeight());
                int lastIndex = CollectionsKt.getLastIndex(list4);
                if (1 <= lastIndex) {
                    while (true) {
                        int i5 = i + 1;
                        Comparable valueOf = Integer.valueOf(((Placeable) list4.get(i)).getHeight());
                        if (valueOf.compareTo(comparable) > 0) {
                            comparable = valueOf;
                        }
                        if (i == lastIndex) {
                            break;
                        }
                        i = i5;
                    }
                }
            }
            Intrinsics.checkNotNull(comparable);
            return MeasureScope.DefaultImpls.layout$default(measureScope, r2, ((Number) comparable).intValue(), (Map) null, new LazyGridKt$ItemRow$2$measure$3(list4, r3), 4, (Object) null);
        }
    }
}
