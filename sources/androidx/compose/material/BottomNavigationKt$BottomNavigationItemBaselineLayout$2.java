package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomNavigation.kt */
final class BottomNavigationKt$BottomNavigationItemBaselineLayout$2 implements MeasurePolicy {
    final /* synthetic */ float $iconPositionAnimationProgress;
    final /* synthetic */ Function2<Composer, Integer, Unit> $label;

    BottomNavigationKt$BottomNavigationItemBaselineLayout$2(Function2<? super Composer, ? super Integer, Unit> function2, float f) {
        this.$label = function2;
        this.$iconPositionAnimationProgress = f;
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
    public final MeasureResult m865measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        Placeable placeable;
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list;
        long j2 = j;
        Intrinsics.checkNotNullParameter(measureScope, "$this$Layout");
        Intrinsics.checkNotNullParameter(list2, "measurables");
        Iterable<Measurable> iterable = list2;
        for (Measurable measurable : iterable) {
            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), (Object) "icon")) {
                Placeable r12 = measurable.m3151measureBRTryo0(j2);
                if (this.$label == null) {
                    placeable = null;
                } else {
                    for (Measurable measurable2 : iterable) {
                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), (Object) AnnotatedPrivateKey.LABEL)) {
                            placeable = measurable2.m3151measureBRTryo0(Constraints.m3794copyZbe2FdA$default(j, 0, 0, 0, 0, 11, (Object) null));
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
                if (this.$label == null) {
                    return BottomNavigationKt.m863placeIcon3p2s80s(measureScope, r12, j2);
                }
                Intrinsics.checkNotNull(placeable);
                return BottomNavigationKt.m864placeLabelAndIconDIyivk0(measureScope, placeable, r12, j, this.$iconPositionAnimationProgress);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
