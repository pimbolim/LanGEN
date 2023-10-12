package androidx.compose.ui.window;

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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AndroidDialog.android.kt */
final class AndroidDialog_androidKt$DialogLayout$1 implements MeasurePolicy {
    public static final AndroidDialog_androidKt$DialogLayout$1 INSTANCE = new AndroidDialog_androidKt$DialogLayout$1();

    AndroidDialog_androidKt$DialogLayout$1() {
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
    public final MeasureResult m4103measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list, "measurables");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((Measurable) list.get(i)).m3151measureBRTryo0(j));
        }
        List list2 = arrayList;
        Integer num = null;
        int i2 = 1;
        if (list2.isEmpty()) {
            obj = null;
        } else {
            obj = list2.get(0);
            int width = ((Placeable) obj).getWidth();
            int lastIndex = CollectionsKt.getLastIndex(list2);
            if (1 <= lastIndex) {
                int i3 = 1;
                while (true) {
                    int i4 = i3 + 1;
                    Object obj3 = list2.get(i3);
                    int width2 = ((Placeable) obj3).getWidth();
                    if (width < width2) {
                        obj = obj3;
                        width = width2;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3 = i4;
                }
            }
        }
        Placeable placeable = (Placeable) obj;
        Integer valueOf = placeable == null ? null : Integer.valueOf(placeable.getWidth());
        int r5 = valueOf == null ? Constraints.m3805getMinWidthimpl(j) : valueOf.intValue();
        if (list2.isEmpty()) {
            obj2 = null;
        } else {
            obj2 = list2.get(0);
            int height = ((Placeable) obj2).getHeight();
            int lastIndex2 = CollectionsKt.getLastIndex(list2);
            if (1 <= lastIndex2) {
                while (true) {
                    int i5 = i2 + 1;
                    Object obj4 = list2.get(i2);
                    int height2 = ((Placeable) obj4).getHeight();
                    if (height < height2) {
                        obj2 = obj4;
                        height = height2;
                    }
                    if (i2 == lastIndex2) {
                        break;
                    }
                    i2 = i5;
                }
            }
        }
        Placeable placeable2 = (Placeable) obj2;
        if (placeable2 != null) {
            num = Integer.valueOf(placeable2.getHeight());
        }
        return MeasureScope.DefaultImpls.layout$default(measureScope, r5, num == null ? Constraints.m3804getMinHeightimpl(j) : num.intValue(), (Map) null, new AndroidDialog_androidKt$DialogLayout$1$measure$1(list2), 4, (Object) null);
    }
}
