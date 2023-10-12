package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.DpRect;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JG\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0016¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "placementBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MeasureScope.kt */
public interface MeasureScope extends IntrinsicMeasureScope {
    MeasureResult layout(int i, int i2, Map<AlignmentLine, Integer> map, Function1<? super Placeable.PlacementScope, Unit> function1);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MeasureScope.kt */
    public static final class DefaultImpls {
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m3153roundToPxR2X_6o(MeasureScope measureScope, long j) {
            Intrinsics.checkNotNullParameter(measureScope, "this");
            return IntrinsicMeasureScope.DefaultImpls.m3116roundToPxR2X_6o(measureScope, j);
        }

        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m3154roundToPx0680j_4(MeasureScope measureScope, float f) {
            Intrinsics.checkNotNullParameter(measureScope, "this");
            return IntrinsicMeasureScope.DefaultImpls.m3117roundToPx0680j_4(measureScope, f);
        }

        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m3155toDpGaN1DYA(MeasureScope measureScope, long j) {
            Intrinsics.checkNotNullParameter(measureScope, "this");
            return IntrinsicMeasureScope.DefaultImpls.m3118toDpGaN1DYA(measureScope, j);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m3156toDpu2uoSUM(MeasureScope measureScope, float f) {
            Intrinsics.checkNotNullParameter(measureScope, "this");
            return IntrinsicMeasureScope.DefaultImpls.m3119toDpu2uoSUM((IntrinsicMeasureScope) measureScope, f);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m3157toDpu2uoSUM(MeasureScope measureScope, int i) {
            Intrinsics.checkNotNullParameter(measureScope, "this");
            return IntrinsicMeasureScope.DefaultImpls.m3120toDpu2uoSUM((IntrinsicMeasureScope) measureScope, i);
        }

        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m3158toDpSizekrfVVM(MeasureScope measureScope, long j) {
            Intrinsics.checkNotNullParameter(measureScope, "this");
            return IntrinsicMeasureScope.DefaultImpls.m3121toDpSizekrfVVM(measureScope, j);
        }

        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m3159toPxR2X_6o(MeasureScope measureScope, long j) {
            Intrinsics.checkNotNullParameter(measureScope, "this");
            return IntrinsicMeasureScope.DefaultImpls.m3122toPxR2X_6o(measureScope, j);
        }

        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m3160toPx0680j_4(MeasureScope measureScope, float f) {
            Intrinsics.checkNotNullParameter(measureScope, "this");
            return IntrinsicMeasureScope.DefaultImpls.m3123toPx0680j_4(measureScope, f);
        }

        public static Rect toRect(MeasureScope measureScope, DpRect dpRect) {
            Intrinsics.checkNotNullParameter(measureScope, "this");
            Intrinsics.checkNotNullParameter(dpRect, "receiver");
            return IntrinsicMeasureScope.DefaultImpls.toRect(measureScope, dpRect);
        }

        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m3161toSizeXkaWNTQ(MeasureScope measureScope, long j) {
            Intrinsics.checkNotNullParameter(measureScope, "this");
            return IntrinsicMeasureScope.DefaultImpls.m3124toSizeXkaWNTQ(measureScope, j);
        }

        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m3162toSp0xMU5do(MeasureScope measureScope, float f) {
            Intrinsics.checkNotNullParameter(measureScope, "this");
            return IntrinsicMeasureScope.DefaultImpls.m3125toSp0xMU5do(measureScope, f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m3163toSpkPz2Gy4(MeasureScope measureScope, float f) {
            Intrinsics.checkNotNullParameter(measureScope, "this");
            return IntrinsicMeasureScope.DefaultImpls.m3126toSpkPz2Gy4((IntrinsicMeasureScope) measureScope, f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m3164toSpkPz2Gy4(MeasureScope measureScope, int i) {
            Intrinsics.checkNotNullParameter(measureScope, "this");
            return IntrinsicMeasureScope.DefaultImpls.m3127toSpkPz2Gy4((IntrinsicMeasureScope) measureScope, i);
        }

        public static /* synthetic */ MeasureResult layout$default(MeasureScope measureScope, int i, int i2, Map map, Function1 function1, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    map = MapsKt.emptyMap();
                }
                return measureScope.layout(i, i2, map, function1);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
        }

        public static MeasureResult layout(MeasureScope measureScope, int i, int i2, Map<AlignmentLine, Integer> map, Function1<? super Placeable.PlacementScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(measureScope, "this");
            Intrinsics.checkNotNullParameter(map, "alignmentLines");
            Intrinsics.checkNotNullParameter(function1, "placementBlock");
            return new MeasureScope$layout$1(i, i2, map, measureScope, function1);
        }
    }
}
