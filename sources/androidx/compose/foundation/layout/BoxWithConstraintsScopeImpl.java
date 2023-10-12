package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0018\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\t\u0010\u0015\u001a\u00020\u0004HÂ\u0003J\u0019\u0010\u0016\u001a\u00020\u0006HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\tJ*\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0015\u0010#\u001a\u00020$*\u00020$2\u0006\u0010%\u001a\u00020&H\u0001J\r\u0010'\u001a\u00020$*\u00020$H\u0001R\u001f\u0010\u0005\u001a\u00020\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u00020\f8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u00020\f8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u001d\u0010\u0011\u001a\u00020\f8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u001d\u0010\u0013\u001a\u00020\f8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Landroidx/compose/foundation/layout/BoxWithConstraintsScopeImpl;", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "Landroidx/compose/foundation/layout/BoxScope;", "density", "Landroidx/compose/ui/unit/Density;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/ui/unit/Density;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConstraints-msEJaDk", "()J", "J", "maxHeight", "Landroidx/compose/ui/unit/Dp;", "getMaxHeight-D9Ej5fM", "()F", "maxWidth", "getMaxWidth-D9Ej5fM", "minHeight", "getMinHeight-D9Ej5fM", "minWidth", "getMinWidth-D9Ej5fM", "component1", "component2", "component2-msEJaDk", "copy", "copy-0kLqBqw", "(Landroidx/compose/ui/unit/Density;J)Landroidx/compose/foundation/layout/BoxWithConstraintsScopeImpl;", "equals", "", "other", "", "hashCode", "", "toString", "", "align", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "matchParentSize", "foundation-layout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BoxWithConstraints.kt */
final class BoxWithConstraintsScopeImpl implements BoxWithConstraintsScope, BoxScope {
    private final /* synthetic */ BoxScopeInstance $$delegate_0;
    private final long constraints;
    private final Density density;

    public /* synthetic */ BoxWithConstraintsScopeImpl(Density density2, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(density2, j);
    }

    private final Density component1() {
        return this.density;
    }

    /* renamed from: copy-0kLqBqw$default  reason: not valid java name */
    public static /* synthetic */ BoxWithConstraintsScopeImpl m395copy0kLqBqw$default(BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl, Density density2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            density2 = boxWithConstraintsScopeImpl.density;
        }
        if ((i & 2) != 0) {
            j = boxWithConstraintsScopeImpl.m398getConstraintsmsEJaDk();
        }
        return boxWithConstraintsScopeImpl.m397copy0kLqBqw(density2, j);
    }

    public Modifier align(Modifier modifier, Alignment alignment) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        return this.$$delegate_0.align(modifier, alignment);
    }

    /* renamed from: component2-msEJaDk  reason: not valid java name */
    public final long m396component2msEJaDk() {
        return m398getConstraintsmsEJaDk();
    }

    /* renamed from: copy-0kLqBqw  reason: not valid java name */
    public final BoxWithConstraintsScopeImpl m397copy0kLqBqw(Density density2, long j) {
        Intrinsics.checkNotNullParameter(density2, "density");
        return new BoxWithConstraintsScopeImpl(density2, j, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BoxWithConstraintsScopeImpl)) {
            return false;
        }
        BoxWithConstraintsScopeImpl boxWithConstraintsScopeImpl = (BoxWithConstraintsScopeImpl) obj;
        return Intrinsics.areEqual((Object) this.density, (Object) boxWithConstraintsScopeImpl.density) && Constraints.m3796equalsimpl0(m398getConstraintsmsEJaDk(), boxWithConstraintsScopeImpl.m398getConstraintsmsEJaDk());
    }

    public int hashCode() {
        return (this.density.hashCode() * 31) + Constraints.m3806hashCodeimpl(m398getConstraintsmsEJaDk());
    }

    public Modifier matchParentSize(Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return this.$$delegate_0.matchParentSize(modifier);
    }

    public String toString() {
        return "BoxWithConstraintsScopeImpl(density=" + this.density + ", constraints=" + Constraints.m3808toStringimpl(m398getConstraintsmsEJaDk()) + ')';
    }

    private BoxWithConstraintsScopeImpl(Density density2, long j) {
        this.density = density2;
        this.constraints = j;
        this.$$delegate_0 = BoxScopeInstance.INSTANCE;
    }

    /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
    public long m398getConstraintsmsEJaDk() {
        return this.constraints;
    }

    /* renamed from: getMinWidth-D9Ej5fM  reason: not valid java name */
    public float m402getMinWidthD9Ej5fM() {
        return this.density.m3825toDpu2uoSUM(Constraints.m3805getMinWidthimpl(m398getConstraintsmsEJaDk()));
    }

    /* renamed from: getMaxWidth-D9Ej5fM  reason: not valid java name */
    public float m400getMaxWidthD9Ej5fM() {
        return this.density.m3825toDpu2uoSUM(Constraints.m3803getMaxWidthimpl(m398getConstraintsmsEJaDk()));
    }

    /* renamed from: getMinHeight-D9Ej5fM  reason: not valid java name */
    public float m401getMinHeightD9Ej5fM() {
        return this.density.m3825toDpu2uoSUM(Constraints.m3804getMinHeightimpl(m398getConstraintsmsEJaDk()));
    }

    /* renamed from: getMaxHeight-D9Ej5fM  reason: not valid java name */
    public float m399getMaxHeightD9Ej5fM() {
        return this.density.m3825toDpu2uoSUM(Constraints.m3802getMaxHeightimpl(m398getConstraintsmsEJaDk()));
    }
}
