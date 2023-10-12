package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/unit/DensityImpl;", "Landroidx/compose/ui/unit/Density;", "density", "", "fontScale", "(FF)V", "getDensity", "()F", "getFontScale", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-unit_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Density.kt */
final class DensityImpl implements Density {
    private final float density;
    private final float fontScale;

    public static /* synthetic */ DensityImpl copy$default(DensityImpl densityImpl, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = densityImpl.getDensity();
        }
        if ((i & 2) != 0) {
            f2 = densityImpl.getFontScale();
        }
        return densityImpl.copy(f, f2);
    }

    public final float component1() {
        return getDensity();
    }

    public final float component2() {
        return getFontScale();
    }

    public final DensityImpl copy(float f, float f2) {
        return new DensityImpl(f, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DensityImpl)) {
            return false;
        }
        DensityImpl densityImpl = (DensityImpl) obj;
        return Intrinsics.areEqual((Object) Float.valueOf(getDensity()), (Object) Float.valueOf(densityImpl.getDensity())) && Intrinsics.areEqual((Object) Float.valueOf(getFontScale()), (Object) Float.valueOf(densityImpl.getFontScale()));
    }

    public int hashCode() {
        return (Float.floatToIntBits(getDensity()) * 31) + Float.floatToIntBits(getFontScale());
    }

    public String toString() {
        return "DensityImpl(density=" + getDensity() + ", fontScale=" + getFontScale() + ')';
    }

    public DensityImpl(float f, float f2) {
        this.density = f;
        this.fontScale = f2;
    }

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    public int m3845roundToPxR2X_6o(long j) {
        return Density.DefaultImpls.m3833roundToPxR2X_6o(this, j);
    }

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    public int m3846roundToPx0680j_4(float f) {
        return Density.DefaultImpls.m3834roundToPx0680j_4(this, f);
    }

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    public float m3847toDpGaN1DYA(long j) {
        return Density.DefaultImpls.m3835toDpGaN1DYA(this, j);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m3848toDpu2uoSUM(float f) {
        return Density.DefaultImpls.m3836toDpu2uoSUM((Density) this, f);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m3849toDpu2uoSUM(int i) {
        return Density.DefaultImpls.m3837toDpu2uoSUM((Density) this, i);
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    public long m3850toDpSizekrfVVM(long j) {
        return Density.DefaultImpls.m3838toDpSizekrfVVM(this, j);
    }

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    public float m3851toPxR2X_6o(long j) {
        return Density.DefaultImpls.m3839toPxR2X_6o(this, j);
    }

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    public float m3852toPx0680j_4(float f) {
        return Density.DefaultImpls.m3840toPx0680j_4(this, f);
    }

    public Rect toRect(DpRect dpRect) {
        return Density.DefaultImpls.toRect(this, dpRect);
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    public long m3853toSizeXkaWNTQ(long j) {
        return Density.DefaultImpls.m3841toSizeXkaWNTQ(this, j);
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    public long m3854toSp0xMU5do(float f) {
        return Density.DefaultImpls.m3842toSp0xMU5do(this, f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m3855toSpkPz2Gy4(float f) {
        return Density.DefaultImpls.m3843toSpkPz2Gy4((Density) this, f);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m3856toSpkPz2Gy4(int i) {
        return Density.DefaultImpls.m3844toSpkPz2Gy4((Density) this, i);
    }

    public float getDensity() {
        return this.density;
    }

    public float getFontScale() {
        return this.fontScale;
    }
}
