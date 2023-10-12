package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IntrinsicMeasureScope.kt */
public interface IntrinsicMeasureScope extends Density {
    LayoutDirection getLayoutDirection();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IntrinsicMeasureScope.kt */
    public static final class DefaultImpls {
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m3116roundToPxR2X_6o(IntrinsicMeasureScope intrinsicMeasureScope, long j) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "this");
            return Density.DefaultImpls.m3833roundToPxR2X_6o(intrinsicMeasureScope, j);
        }

        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m3117roundToPx0680j_4(IntrinsicMeasureScope intrinsicMeasureScope, float f) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "this");
            return Density.DefaultImpls.m3834roundToPx0680j_4(intrinsicMeasureScope, f);
        }

        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m3118toDpGaN1DYA(IntrinsicMeasureScope intrinsicMeasureScope, long j) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "this");
            return Density.DefaultImpls.m3835toDpGaN1DYA(intrinsicMeasureScope, j);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m3119toDpu2uoSUM(IntrinsicMeasureScope intrinsicMeasureScope, float f) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "this");
            return Density.DefaultImpls.m3836toDpu2uoSUM((Density) intrinsicMeasureScope, f);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m3120toDpu2uoSUM(IntrinsicMeasureScope intrinsicMeasureScope, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "this");
            return Density.DefaultImpls.m3837toDpu2uoSUM((Density) intrinsicMeasureScope, i);
        }

        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m3121toDpSizekrfVVM(IntrinsicMeasureScope intrinsicMeasureScope, long j) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "this");
            return Density.DefaultImpls.m3838toDpSizekrfVVM(intrinsicMeasureScope, j);
        }

        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m3122toPxR2X_6o(IntrinsicMeasureScope intrinsicMeasureScope, long j) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "this");
            return Density.DefaultImpls.m3839toPxR2X_6o(intrinsicMeasureScope, j);
        }

        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m3123toPx0680j_4(IntrinsicMeasureScope intrinsicMeasureScope, float f) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "this");
            return Density.DefaultImpls.m3840toPx0680j_4(intrinsicMeasureScope, f);
        }

        public static Rect toRect(IntrinsicMeasureScope intrinsicMeasureScope, DpRect dpRect) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "this");
            Intrinsics.checkNotNullParameter(dpRect, "receiver");
            return Density.DefaultImpls.toRect(intrinsicMeasureScope, dpRect);
        }

        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m3124toSizeXkaWNTQ(IntrinsicMeasureScope intrinsicMeasureScope, long j) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "this");
            return Density.DefaultImpls.m3841toSizeXkaWNTQ(intrinsicMeasureScope, j);
        }

        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m3125toSp0xMU5do(IntrinsicMeasureScope intrinsicMeasureScope, float f) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "this");
            return Density.DefaultImpls.m3842toSp0xMU5do(intrinsicMeasureScope, f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m3126toSpkPz2Gy4(IntrinsicMeasureScope intrinsicMeasureScope, float f) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "this");
            return Density.DefaultImpls.m3843toSpkPz2Gy4((Density) intrinsicMeasureScope, f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m3127toSpkPz2Gy4(IntrinsicMeasureScope intrinsicMeasureScope, int i) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "this");
            return Density.DefaultImpls.m3844toSpkPz2Gy4((Density) intrinsicMeasureScope, i);
        }
    }
}
