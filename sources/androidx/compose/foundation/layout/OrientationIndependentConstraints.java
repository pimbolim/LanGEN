package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import com.brentvatne.react.ReactVideoView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001a\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006B%\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010\u0012\u001a\u00020\bHÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\bHÖ\u0001J\u000e\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u0000J\u001e\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001f\u0010 J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "", "c", "Landroidx/compose/ui/unit/Constraints;", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "(JLandroidx/compose/foundation/layout/LayoutOrientation;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "mainAxisMin", "", "mainAxisMax", "crossAxisMin", "crossAxisMax", "(IIII)V", "getCrossAxisMax", "()I", "getCrossAxisMin", "getMainAxisMax", "getMainAxisMin", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "maxHeight", "maxWidth", "stretchCrossAxis", "toBoxConstraints", "toBoxConstraints-OenEA2s", "(Landroidx/compose/foundation/layout/LayoutOrientation;)J", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RowColumnImpl.kt */
public final class OrientationIndependentConstraints {
    private final int crossAxisMax;
    private final int crossAxisMin;
    private final int mainAxisMax;
    private final int mainAxisMin;

    public /* synthetic */ OrientationIndependentConstraints(long j, LayoutOrientation layoutOrientation, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, layoutOrientation);
    }

    public static /* synthetic */ OrientationIndependentConstraints copy$default(OrientationIndependentConstraints orientationIndependentConstraints, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = orientationIndependentConstraints.mainAxisMin;
        }
        if ((i5 & 2) != 0) {
            i2 = orientationIndependentConstraints.mainAxisMax;
        }
        if ((i5 & 4) != 0) {
            i3 = orientationIndependentConstraints.crossAxisMin;
        }
        if ((i5 & 8) != 0) {
            i4 = orientationIndependentConstraints.crossAxisMax;
        }
        return orientationIndependentConstraints.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.mainAxisMin;
    }

    public final int component2() {
        return this.mainAxisMax;
    }

    public final int component3() {
        return this.crossAxisMin;
    }

    public final int component4() {
        return this.crossAxisMax;
    }

    public final OrientationIndependentConstraints copy(int i, int i2, int i3, int i4) {
        return new OrientationIndependentConstraints(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrientationIndependentConstraints)) {
            return false;
        }
        OrientationIndependentConstraints orientationIndependentConstraints = (OrientationIndependentConstraints) obj;
        return this.mainAxisMin == orientationIndependentConstraints.mainAxisMin && this.mainAxisMax == orientationIndependentConstraints.mainAxisMax && this.crossAxisMin == orientationIndependentConstraints.crossAxisMin && this.crossAxisMax == orientationIndependentConstraints.crossAxisMax;
    }

    public int hashCode() {
        return (((((this.mainAxisMin * 31) + this.mainAxisMax) * 31) + this.crossAxisMin) * 31) + this.crossAxisMax;
    }

    public String toString() {
        return "OrientationIndependentConstraints(mainAxisMin=" + this.mainAxisMin + ", mainAxisMax=" + this.mainAxisMax + ", crossAxisMin=" + this.crossAxisMin + ", crossAxisMax=" + this.crossAxisMax + ')';
    }

    public OrientationIndependentConstraints(int i, int i2, int i3, int i4) {
        this.mainAxisMin = i;
        this.mainAxisMax = i2;
        this.crossAxisMin = i3;
        this.crossAxisMax = i4;
    }

    public final int getMainAxisMin() {
        return this.mainAxisMin;
    }

    public final int getMainAxisMax() {
        return this.mainAxisMax;
    }

    public final int getCrossAxisMin() {
        return this.crossAxisMin;
    }

    public final int getCrossAxisMax() {
        return this.crossAxisMax;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    private OrientationIndependentConstraints(long j, LayoutOrientation layoutOrientation) {
        this(layoutOrientation == LayoutOrientation.Horizontal ? Constraints.m3805getMinWidthimpl(j) : Constraints.m3804getMinHeightimpl(j), layoutOrientation == LayoutOrientation.Horizontal ? Constraints.m3803getMaxWidthimpl(j) : Constraints.m3802getMaxHeightimpl(j), layoutOrientation == LayoutOrientation.Horizontal ? Constraints.m3804getMinHeightimpl(j) : Constraints.m3805getMinWidthimpl(j), layoutOrientation == LayoutOrientation.Horizontal ? Constraints.m3802getMaxHeightimpl(j) : Constraints.m3803getMaxWidthimpl(j));
    }

    public final OrientationIndependentConstraints stretchCrossAxis() {
        int i = this.mainAxisMin;
        int i2 = this.mainAxisMax;
        int i3 = this.crossAxisMax;
        return new OrientationIndependentConstraints(i, i2, i3 != Integer.MAX_VALUE ? i3 : this.crossAxisMin, i3);
    }

    /* renamed from: toBoxConstraints-OenEA2s  reason: not valid java name */
    public final long m423toBoxConstraintsOenEA2s(LayoutOrientation layoutOrientation) {
        Intrinsics.checkNotNullParameter(layoutOrientation, ReactVideoView.EVENT_PROP_ORIENTATION);
        if (layoutOrientation == LayoutOrientation.Horizontal) {
            return ConstraintsKt.Constraints(this.mainAxisMin, this.mainAxisMax, this.crossAxisMin, this.crossAxisMax);
        }
        return ConstraintsKt.Constraints(this.crossAxisMin, this.crossAxisMax, this.mainAxisMin, this.mainAxisMax);
    }

    public final int maxWidth(LayoutOrientation layoutOrientation) {
        Intrinsics.checkNotNullParameter(layoutOrientation, ReactVideoView.EVENT_PROP_ORIENTATION);
        if (layoutOrientation == LayoutOrientation.Horizontal) {
            return this.mainAxisMax;
        }
        return this.crossAxisMax;
    }

    public final int maxHeight(LayoutOrientation layoutOrientation) {
        Intrinsics.checkNotNullParameter(layoutOrientation, ReactVideoView.EVENT_PROP_ORIENTATION);
        if (layoutOrientation == LayoutOrientation.Horizontal) {
            return this.crossAxisMax;
        }
        return this.mainAxisMax;
    }
}
