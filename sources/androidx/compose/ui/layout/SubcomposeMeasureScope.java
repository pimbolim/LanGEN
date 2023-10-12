package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.DpRect;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\nH&¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "subcompose", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", "", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubcomposeLayout.kt */
public interface SubcomposeMeasureScope extends MeasureScope {
    List<Measurable> subcompose(Object obj, Function2<? super Composer, ? super Integer, Unit> function2);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SubcomposeLayout.kt */
    public static final class DefaultImpls {
        public static MeasureResult layout(SubcomposeMeasureScope subcomposeMeasureScope, int i, int i2, Map<AlignmentLine, Integer> map, Function1<? super Placeable.PlacementScope, Unit> function1) {
            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "this");
            Intrinsics.checkNotNullParameter(map, "alignmentLines");
            Intrinsics.checkNotNullParameter(function1, "placementBlock");
            return MeasureScope.DefaultImpls.layout(subcomposeMeasureScope, i, i2, map, function1);
        }

        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m3228roundToPxR2X_6o(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "this");
            return MeasureScope.DefaultImpls.m3153roundToPxR2X_6o(subcomposeMeasureScope, j);
        }

        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m3229roundToPx0680j_4(SubcomposeMeasureScope subcomposeMeasureScope, float f) {
            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "this");
            return MeasureScope.DefaultImpls.m3154roundToPx0680j_4(subcomposeMeasureScope, f);
        }

        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m3230toDpGaN1DYA(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "this");
            return MeasureScope.DefaultImpls.m3155toDpGaN1DYA(subcomposeMeasureScope, j);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m3231toDpu2uoSUM(SubcomposeMeasureScope subcomposeMeasureScope, float f) {
            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "this");
            return MeasureScope.DefaultImpls.m3156toDpu2uoSUM((MeasureScope) subcomposeMeasureScope, f);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m3232toDpu2uoSUM(SubcomposeMeasureScope subcomposeMeasureScope, int i) {
            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "this");
            return MeasureScope.DefaultImpls.m3157toDpu2uoSUM((MeasureScope) subcomposeMeasureScope, i);
        }

        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m3233toDpSizekrfVVM(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "this");
            return MeasureScope.DefaultImpls.m3158toDpSizekrfVVM(subcomposeMeasureScope, j);
        }

        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m3234toPxR2X_6o(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "this");
            return MeasureScope.DefaultImpls.m3159toPxR2X_6o(subcomposeMeasureScope, j);
        }

        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m3235toPx0680j_4(SubcomposeMeasureScope subcomposeMeasureScope, float f) {
            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "this");
            return MeasureScope.DefaultImpls.m3160toPx0680j_4(subcomposeMeasureScope, f);
        }

        public static Rect toRect(SubcomposeMeasureScope subcomposeMeasureScope, DpRect dpRect) {
            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "this");
            Intrinsics.checkNotNullParameter(dpRect, "receiver");
            return MeasureScope.DefaultImpls.toRect(subcomposeMeasureScope, dpRect);
        }

        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m3236toSizeXkaWNTQ(SubcomposeMeasureScope subcomposeMeasureScope, long j) {
            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "this");
            return MeasureScope.DefaultImpls.m3161toSizeXkaWNTQ(subcomposeMeasureScope, j);
        }

        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m3237toSp0xMU5do(SubcomposeMeasureScope subcomposeMeasureScope, float f) {
            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "this");
            return MeasureScope.DefaultImpls.m3162toSp0xMU5do(subcomposeMeasureScope, f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m3238toSpkPz2Gy4(SubcomposeMeasureScope subcomposeMeasureScope, float f) {
            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "this");
            return MeasureScope.DefaultImpls.m3163toSpkPz2Gy4((MeasureScope) subcomposeMeasureScope, f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m3239toSpkPz2Gy4(SubcomposeMeasureScope subcomposeMeasureScope, int i) {
            Intrinsics.checkNotNullParameter(subcomposeMeasureScope, "this");
            return MeasureScope.DefaultImpls.m3164toSpkPz2Gy4((MeasureScope) subcomposeMeasureScope, i);
        }
    }
}
