package androidx.compose.ui.semantics;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatingLayoutNodeWrapper;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNodeWrapper;
import androidx.compose.ui.node.Owner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J3\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0006\u0010\u001a\u001a\u00020\u001bR\u0014\u0010\u0007\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsWrapper;", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/semantics/SemanticsModifier;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "semanticsModifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/semantics/SemanticsModifier;)V", "useMinimumTouchTarget", "", "getUseMinimumTouchTarget", "()Z", "collapsedSemanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "detach", "", "hitTestSemantics", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitSemanticsWrappers", "Landroidx/compose/ui/node/HitTestResult;", "isInLayer", "hitTestSemantics-9KIMszo", "(JLandroidx/compose/ui/node/HitTestResult;Z)V", "onModifierChanged", "toString", "", "touchBoundsInRoot", "Landroidx/compose/ui/geometry/Rect;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SemanticsWrapper.kt */
public final class SemanticsWrapper extends DelegatingLayoutNodeWrapper<SemanticsModifier> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SemanticsWrapper(LayoutNodeWrapper layoutNodeWrapper, SemanticsModifier semanticsModifier) {
        super(layoutNodeWrapper, semanticsModifier);
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "wrapped");
        Intrinsics.checkNotNullParameter(semanticsModifier, "semanticsModifier");
    }

    private final boolean getUseMinimumTouchTarget() {
        return SemanticsConfigurationKt.getOrNull(((SemanticsModifier) getModifier()).getSemanticsConfiguration(), SemanticsActions.INSTANCE.getOnClick()) != null;
    }

    public final SemanticsConfiguration collapsedSemanticsConfiguration() {
        SemanticsWrapper semanticsWrapper;
        LayoutNodeWrapper wrapped$ui_release = getWrapped$ui_release();
        while (true) {
            if (wrapped$ui_release == null) {
                semanticsWrapper = null;
                break;
            } else if (wrapped$ui_release instanceof SemanticsWrapper) {
                semanticsWrapper = (SemanticsWrapper) wrapped$ui_release;
                break;
            } else {
                wrapped$ui_release = wrapped$ui_release.getWrapped$ui_release();
            }
        }
        if (semanticsWrapper == null || ((SemanticsModifier) getModifier()).getSemanticsConfiguration().isClearingSemantics()) {
            return ((SemanticsModifier) getModifier()).getSemanticsConfiguration();
        }
        SemanticsConfiguration copy = ((SemanticsModifier) getModifier()).getSemanticsConfiguration().copy();
        copy.collapsePeer$ui_release(semanticsWrapper.collapsedSemanticsConfiguration());
        return copy;
    }

    public void detach() {
        super.detach();
        Owner owner$ui_release = getLayoutNode$ui_release().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onSemanticsChange();
        }
    }

    public void onModifierChanged() {
        super.onModifierChanged();
        Owner owner$ui_release = getLayoutNode$ui_release().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onSemanticsChange();
        }
    }

    public String toString() {
        return super.toString() + " id: " + ((SemanticsModifier) getModifier()).getId() + " config: " + ((SemanticsModifier) getModifier()).getSemanticsConfiguration();
    }

    /* renamed from: hitTestSemantics-9KIMszo  reason: not valid java name */
    public void m3492hitTestSemantics9KIMszo(long j, HitTestResult<SemanticsWrapper> hitTestResult, boolean z) {
        Intrinsics.checkNotNullParameter(hitTestResult, "hitSemanticsWrappers");
        m3243hitTestInMinimumTouchTarget7362WCg(j, hitTestResult, false, true, z, this, new SemanticsWrapper$hitTestSemantics$1(this, j, hitTestResult));
    }

    public final Rect touchBoundsInRoot() {
        if (!isAttached()) {
            return Rect.Companion.getZero();
        }
        if (!getUseMinimumTouchTarget()) {
            return LayoutCoordinatesKt.boundsInRoot(this);
        }
        LayoutCoordinates findRoot = LayoutCoordinatesKt.findRoot(this);
        MutableRect rectCache = getRectCache();
        long r2 = m3339calculateMinimumTouchTargetPaddingE7KxVPU(m3342getMinimumTouchTargetSizeNHjbRc());
        rectCache.setLeft(-Size.m1422getWidthimpl(r2));
        rectCache.setTop(-Size.m1419getHeightimpl(r2));
        rectCache.setRight(((float) getMeasuredWidth()) + Size.m1422getWidthimpl(r2));
        rectCache.setBottom(((float) getMeasuredHeight()) + Size.m1419getHeightimpl(r2));
        LayoutNodeWrapper layoutNodeWrapper = this;
        while (layoutNodeWrapper != findRoot) {
            layoutNodeWrapper.rectInParent$ui_release(rectCache, false, true);
            if (rectCache.isEmpty()) {
                return Rect.Companion.getZero();
            }
            layoutNodeWrapper = layoutNodeWrapper.getWrappedBy$ui_release();
            Intrinsics.checkNotNull(layoutNodeWrapper);
        }
        return MutableRectKt.toRect(rectCache);
    }
}
