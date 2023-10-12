package androidx.compose.foundation.lazy.list;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u00020\u0005HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\bJ*\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u001d\u0010\u001e\u001a\u00020\u001f*\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0017ø\u0001\u0000J\u0014\u0010#\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010$\u001a\u00020%H\u0016J\u0014\u0010&\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010$\u001a\u00020%H\u0016J\u0014\u0010'\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010$\u001a\u00020%H\u0016R\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\rX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u0019\u0010\u000f\u001a\u00020\rX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006("}, d2 = {"Landroidx/compose/foundation/lazy/list/LazyItemScopeImpl;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "density", "Landroidx/compose/ui/unit/Density;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/ui/unit/Density;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConstraints-msEJaDk", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "maxHeight", "Landroidx/compose/ui/unit/Dp;", "F", "maxWidth", "component1", "component2", "component2-msEJaDk", "copy", "copy-0kLqBqw", "(Landroidx/compose/ui/unit/Density;J)Landroidx/compose/foundation/lazy/list/LazyItemScopeImpl;", "equals", "", "other", "", "hashCode", "", "toString", "", "animateItemPlacement", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "Landroidx/compose/ui/unit/IntOffset;", "fillParentMaxHeight", "fraction", "", "fillParentMaxSize", "fillParentMaxWidth", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyItemScopeImpl.kt */
public final class LazyItemScopeImpl implements LazyItemScope {
    private final long constraints;
    private final Density density;
    private final float maxHeight;
    private final float maxWidth;

    public /* synthetic */ LazyItemScopeImpl(Density density2, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(density2, j);
    }

    /* renamed from: copy-0kLqBqw$default  reason: not valid java name */
    public static /* synthetic */ LazyItemScopeImpl m548copy0kLqBqw$default(LazyItemScopeImpl lazyItemScopeImpl, Density density2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            density2 = lazyItemScopeImpl.density;
        }
        if ((i & 2) != 0) {
            j = lazyItemScopeImpl.constraints;
        }
        return lazyItemScopeImpl.m550copy0kLqBqw(density2, j);
    }

    public final Density component1() {
        return this.density;
    }

    /* renamed from: component2-msEJaDk  reason: not valid java name */
    public final long m549component2msEJaDk() {
        return this.constraints;
    }

    /* renamed from: copy-0kLqBqw  reason: not valid java name */
    public final LazyItemScopeImpl m550copy0kLqBqw(Density density2, long j) {
        Intrinsics.checkNotNullParameter(density2, "density");
        return new LazyItemScopeImpl(density2, j, (DefaultConstructorMarker) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyItemScopeImpl)) {
            return false;
        }
        LazyItemScopeImpl lazyItemScopeImpl = (LazyItemScopeImpl) obj;
        return Intrinsics.areEqual((Object) this.density, (Object) lazyItemScopeImpl.density) && Constraints.m3796equalsimpl0(this.constraints, lazyItemScopeImpl.constraints);
    }

    public int hashCode() {
        return (this.density.hashCode() * 31) + Constraints.m3806hashCodeimpl(this.constraints);
    }

    public String toString() {
        return "LazyItemScopeImpl(density=" + this.density + ", constraints=" + Constraints.m3808toStringimpl(this.constraints) + ')';
    }

    private LazyItemScopeImpl(Density density2, long j) {
        this.density = density2;
        this.constraints = j;
        this.maxWidth = density2.m3825toDpu2uoSUM(Constraints.m3803getMaxWidthimpl(m551getConstraintsmsEJaDk()));
        this.maxHeight = density2.m3825toDpu2uoSUM(Constraints.m3802getMaxHeightimpl(m551getConstraintsmsEJaDk()));
    }

    public final Density getDensity() {
        return this.density;
    }

    /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
    public final long m551getConstraintsmsEJaDk() {
        return this.constraints;
    }

    public Modifier fillParentMaxSize(Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return SizeKt.m494sizeVpY3zN4(modifier, Dp.m3859constructorimpl(this.maxWidth * f), Dp.m3859constructorimpl(this.maxHeight * f));
    }

    public Modifier fillParentMaxWidth(Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return SizeKt.m497width3ABfNKs(modifier, Dp.m3859constructorimpl(this.maxWidth * f));
    }

    public Modifier fillParentMaxHeight(Modifier modifier, float f) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return SizeKt.m478height3ABfNKs(modifier, Dp.m3859constructorimpl(this.maxHeight * f));
    }

    @ExperimentalFoundationApi
    public Modifier animateItemPlacement(Modifier modifier, FiniteAnimationSpec<IntOffset> finiteAnimationSpec) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(finiteAnimationSpec, "animationSpec");
        return modifier.then(new AnimateItemPlacementModifier(finiteAnimationSpec, InspectableValueKt.isDebugInspectorInfoEnabled() ? new LazyItemScopeImpl$animateItemPlacement$$inlined$debugInspectorInfo$1(finiteAnimationSpec) : InspectableValueKt.getNoInspectorInfo()));
    }
}
