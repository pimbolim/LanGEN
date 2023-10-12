package androidx.compose.ui.platform;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, d2 = {"invertTo", "", "Landroidx/compose/ui/graphics/Matrix;", "other", "invertTo-JiSxe2E", "([F[F)Z", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: InvertMatrix.kt */
public final class InvertMatrixKt {
    /* renamed from: invertTo-JiSxe2E  reason: not valid java name */
    public static final boolean m3424invertToJiSxe2E(float[] fArr, float[] fArr2) {
        float[] fArr3 = fArr;
        float[] fArr4 = fArr2;
        Intrinsics.checkNotNullParameter(fArr3, "$this$invertTo");
        Intrinsics.checkNotNullParameter(fArr4, "other");
        float f = fArr3[0];
        float f2 = fArr3[1];
        float f3 = fArr3[2];
        float f4 = fArr3[3];
        float f5 = fArr3[4];
        float f6 = fArr3[5];
        float f7 = fArr3[6];
        float f8 = fArr3[7];
        float f9 = fArr3[8];
        float f10 = fArr3[9];
        float f11 = fArr3[10];
        float f12 = fArr3[11];
        float f13 = fArr3[12];
        float f14 = fArr3[13];
        float f15 = fArr3[14];
        float f16 = fArr3[15];
        float f17 = (f * f6) - (f2 * f5);
        float f18 = (f * f7) - (f3 * f5);
        float f19 = (f * f8) - (f4 * f5);
        float f20 = (f2 * f7) - (f3 * f6);
        float f21 = (f2 * f8) - (f4 * f6);
        float f22 = (f3 * f8) - (f4 * f7);
        float f23 = (f9 * f14) - (f10 * f13);
        float f24 = (f9 * f15) - (f11 * f13);
        float f25 = (f9 * f16) - (f12 * f13);
        float f26 = (f10 * f15) - (f11 * f14);
        float f27 = (f10 * f16) - (f12 * f14);
        float f28 = (f11 * f16) - (f12 * f15);
        float f29 = (((((f17 * f28) - (f18 * f27)) + (f19 * f26)) + (f20 * f25)) - (f21 * f24)) + (f22 * f23);
        if (f29 == 0.0f) {
            return false;
        }
        float f30 = 1.0f / f29;
        fArr4[0] = (((f6 * f28) - (f7 * f27)) + (f8 * f26)) * f30;
        fArr4[1] = ((((-f2) * f28) + (f3 * f27)) - (f4 * f26)) * f30;
        fArr4[2] = (((f14 * f22) - (f15 * f21)) + (f16 * f20)) * f30;
        fArr4[3] = ((((-f10) * f22) + (f11 * f21)) - (f12 * f20)) * f30;
        float f31 = -f5;
        fArr4[4] = (((f31 * f28) + (f7 * f25)) - (f8 * f24)) * f30;
        fArr4[5] = (((f28 * f) - (f3 * f25)) + (f4 * f24)) * f30;
        float f32 = -f13;
        fArr4[6] = (((f32 * f22) + (f15 * f19)) - (f16 * f18)) * f30;
        fArr4[7] = (((f22 * f9) - (f11 * f19)) + (f12 * f18)) * f30;
        fArr4[8] = (((f5 * f27) - (f6 * f25)) + (f8 * f23)) * f30;
        fArr4[9] = ((((-f) * f27) + (f25 * f2)) - (f4 * f23)) * f30;
        fArr4[10] = (((f13 * f21) - (f14 * f19)) + (f16 * f17)) * f30;
        fArr4[11] = ((((-f9) * f21) + (f19 * f10)) - (f12 * f17)) * f30;
        fArr4[12] = (((f31 * f26) + (f6 * f24)) - (f7 * f23)) * f30;
        fArr4[13] = (((f * f26) - (f2 * f24)) + (f3 * f23)) * f30;
        fArr4[14] = (((f32 * f20) + (f14 * f18)) - (f15 * f17)) * f30;
        fArr4[15] = (((f9 * f20) - (f10 * f18)) + (f11 * f17)) * f30;
        return true;
    }
}
