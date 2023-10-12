package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "awaitRelease", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAwaitRelease", "", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TapGestureDetector.kt */
public interface PressGestureScope extends Density {
    Object awaitRelease(Continuation<? super Unit> continuation);

    Object tryAwaitRelease(Continuation<? super Boolean> continuation);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TapGestureDetector.kt */
    public static final class DefaultImpls {
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m284roundToPxR2X_6o(PressGestureScope pressGestureScope, long j) {
            Intrinsics.checkNotNullParameter(pressGestureScope, "this");
            return Density.DefaultImpls.m3833roundToPxR2X_6o(pressGestureScope, j);
        }

        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m285roundToPx0680j_4(PressGestureScope pressGestureScope, float f) {
            Intrinsics.checkNotNullParameter(pressGestureScope, "this");
            return Density.DefaultImpls.m3834roundToPx0680j_4(pressGestureScope, f);
        }

        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m286toDpGaN1DYA(PressGestureScope pressGestureScope, long j) {
            Intrinsics.checkNotNullParameter(pressGestureScope, "this");
            return Density.DefaultImpls.m3835toDpGaN1DYA(pressGestureScope, j);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m287toDpu2uoSUM(PressGestureScope pressGestureScope, float f) {
            Intrinsics.checkNotNullParameter(pressGestureScope, "this");
            return Density.DefaultImpls.m3836toDpu2uoSUM((Density) pressGestureScope, f);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m288toDpu2uoSUM(PressGestureScope pressGestureScope, int i) {
            Intrinsics.checkNotNullParameter(pressGestureScope, "this");
            return Density.DefaultImpls.m3837toDpu2uoSUM((Density) pressGestureScope, i);
        }

        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m289toDpSizekrfVVM(PressGestureScope pressGestureScope, long j) {
            Intrinsics.checkNotNullParameter(pressGestureScope, "this");
            return Density.DefaultImpls.m3838toDpSizekrfVVM(pressGestureScope, j);
        }

        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m290toPxR2X_6o(PressGestureScope pressGestureScope, long j) {
            Intrinsics.checkNotNullParameter(pressGestureScope, "this");
            return Density.DefaultImpls.m3839toPxR2X_6o(pressGestureScope, j);
        }

        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m291toPx0680j_4(PressGestureScope pressGestureScope, float f) {
            Intrinsics.checkNotNullParameter(pressGestureScope, "this");
            return Density.DefaultImpls.m3840toPx0680j_4(pressGestureScope, f);
        }

        public static Rect toRect(PressGestureScope pressGestureScope, DpRect dpRect) {
            Intrinsics.checkNotNullParameter(pressGestureScope, "this");
            Intrinsics.checkNotNullParameter(dpRect, "receiver");
            return Density.DefaultImpls.toRect(pressGestureScope, dpRect);
        }

        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m292toSizeXkaWNTQ(PressGestureScope pressGestureScope, long j) {
            Intrinsics.checkNotNullParameter(pressGestureScope, "this");
            return Density.DefaultImpls.m3841toSizeXkaWNTQ(pressGestureScope, j);
        }

        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m293toSp0xMU5do(PressGestureScope pressGestureScope, float f) {
            Intrinsics.checkNotNullParameter(pressGestureScope, "this");
            return Density.DefaultImpls.m3842toSp0xMU5do(pressGestureScope, f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m294toSpkPz2Gy4(PressGestureScope pressGestureScope, float f) {
            Intrinsics.checkNotNullParameter(pressGestureScope, "this");
            return Density.DefaultImpls.m3843toSpkPz2Gy4((Density) pressGestureScope, f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m295toSpkPz2Gy4(PressGestureScope pressGestureScope, int i) {
            Intrinsics.checkNotNullParameter(pressGestureScope, "this");
            return Density.DefaultImpls.m3844toSpkPz2Gy4((Density) pressGestureScope, i);
        }
    }
}
