package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u000b\u001a\u00020\f*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u000b\u001a\u00020\f*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\r*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0013\u001a\u00020\r*\u00020\u0003H\u0017ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0013\u001a\u00020\r*\u00020\fH\u0017ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u001a*\u00020\u001bH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u0003*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0017J\u0019\u0010\u001e\u001a\u00020\u0003*\u00020\u0010H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b \u0010\u0015J\f\u0010!\u001a\u00020\"*\u00020#H\u0017J\u0019\u0010$\u001a\u00020\u001b*\u00020\u001aH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010\u001dJ\u0019\u0010&\u001a\u00020\u0010*\u00020\rH\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J\u001c\u0010&\u001a\u00020\u0010*\u00020\u0003H\u0017ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b)\u0010(J\u001c\u0010&\u001a\u00020\u0010*\u00020\fH\u0017ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b)\u0010*R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Landroidx/compose/ui/unit/Density;", "", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "fontScale", "getFontScale$annotations", "getFontScale", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui-unit_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Density.kt */
public interface Density {
    float getDensity();

    float getFontScale();

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    int m3821roundToPxR2X_6o(long j);

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    int m3822roundToPx0680j_4(float f);

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    float m3823toDpGaN1DYA(long j);

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    float m3824toDpu2uoSUM(float f);

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    float m3825toDpu2uoSUM(int i);

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    long m3826toDpSizekrfVVM(long j);

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    float m3827toPxR2X_6o(long j);

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    float m3828toPx0680j_4(float f);

    Rect toRect(DpRect dpRect);

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    long m3829toSizeXkaWNTQ(long j);

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    long m3830toSp0xMU5do(float f);

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    long m3831toSpkPz2Gy4(float f);

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    long m3832toSpkPz2Gy4(int i);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Density.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void getDensity$annotations() {
        }

        public static /* synthetic */ void getFontScale$annotations() {
        }

        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m3840toPx0680j_4(Density density, float f) {
            Intrinsics.checkNotNullParameter(density, "this");
            return f * density.getDensity();
        }

        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m3834roundToPx0680j_4(Density density, float f) {
            Intrinsics.checkNotNullParameter(density, "this");
            float r1 = density.m3828toPx0680j_4(f);
            if (Float.isInfinite(r1)) {
                return Integer.MAX_VALUE;
            }
            return MathKt.roundToInt(r1);
        }

        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m3842toSp0xMU5do(Density density, float f) {
            Intrinsics.checkNotNullParameter(density, "this");
            return TextUnitKt.getSp(f / density.getFontScale());
        }

        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m3839toPxR2X_6o(Density density, long j) {
            Intrinsics.checkNotNullParameter(density, "this");
            if (TextUnitType.m4068equalsimpl0(TextUnit.m4039getTypeUIouoOA(j), TextUnitType.Companion.m4073getSpUIouoOA())) {
                return TextUnit.m4040getValueimpl(j) * density.getFontScale() * density.getDensity();
            }
            throw new IllegalStateException("Only Sp can convert to Px".toString());
        }

        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m3833roundToPxR2X_6o(Density density, long j) {
            Intrinsics.checkNotNullParameter(density, "this");
            return MathKt.roundToInt(density.m3827toPxR2X_6o(j));
        }

        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m3835toDpGaN1DYA(Density density, long j) {
            Intrinsics.checkNotNullParameter(density, "this");
            if (TextUnitType.m4068equalsimpl0(TextUnit.m4039getTypeUIouoOA(j), TextUnitType.Companion.m4073getSpUIouoOA())) {
                return Dp.m3859constructorimpl(TextUnit.m4040getValueimpl(j) * density.getFontScale());
            }
            throw new IllegalStateException("Only Sp can convert to Px".toString());
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m3837toDpu2uoSUM(Density density, int i) {
            Intrinsics.checkNotNullParameter(density, "this");
            return Dp.m3859constructorimpl(((float) i) / density.getDensity());
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m3844toSpkPz2Gy4(Density density, int i) {
            Intrinsics.checkNotNullParameter(density, "this");
            return TextUnitKt.getSp(((float) i) / (density.getFontScale() * density.getDensity()));
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m3836toDpu2uoSUM(Density density, float f) {
            Intrinsics.checkNotNullParameter(density, "this");
            return Dp.m3859constructorimpl(f / density.getDensity());
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m3843toSpkPz2Gy4(Density density, float f) {
            Intrinsics.checkNotNullParameter(density, "this");
            return TextUnitKt.getSp(f / (density.getFontScale() * density.getDensity()));
        }

        public static Rect toRect(Density density, DpRect dpRect) {
            Intrinsics.checkNotNullParameter(density, "this");
            Intrinsics.checkNotNullParameter(dpRect, "receiver");
            return new Rect(density.m3828toPx0680j_4(dpRect.m3942getLeftD9Ej5fM()), density.m3828toPx0680j_4(dpRect.m3944getTopD9Ej5fM()), density.m3828toPx0680j_4(dpRect.m3943getRightD9Ej5fM()), density.m3828toPx0680j_4(dpRect.m3941getBottomD9Ej5fM()));
        }

        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m3841toSizeXkaWNTQ(Density density, long j) {
            Intrinsics.checkNotNullParameter(density, "this");
            if (j != DpSize.Companion.m3966getUnspecifiedMYxV2XQ()) {
                return SizeKt.Size(density.m3828toPx0680j_4(DpSize.m3957getWidthD9Ej5fM(j)), density.m3828toPx0680j_4(DpSize.m3955getHeightD9Ej5fM(j)));
            }
            return Size.Companion.m1430getUnspecifiedNHjbRc();
        }

        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m3838toDpSizekrfVVM(Density density, long j) {
            Intrinsics.checkNotNullParameter(density, "this");
            if (j != Size.Companion.m1430getUnspecifiedNHjbRc()) {
                return DpKt.m3881DpSizeYgX7TsA(density.m3824toDpu2uoSUM(Size.m1422getWidthimpl(j)), density.m3824toDpu2uoSUM(Size.m1419getHeightimpl(j)));
            }
            return DpSize.Companion.m3966getUnspecifiedMYxV2XQ();
        }
    }
}
