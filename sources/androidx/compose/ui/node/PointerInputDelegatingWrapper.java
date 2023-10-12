package androidx.compose.ui.node;

import androidx.compose.ui.input.pointer.PointerInputFilter;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J;\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J;\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0012J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\u000fH\u0016\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/node/PointerInputDelegatingWrapper;", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/input/pointer/PointerInputModifier;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "modifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/input/pointer/PointerInputModifier;)V", "hitTest", "", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "isTouchEvent", "", "isInLayer", "hitTest-M_7yMNQ", "(JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestChild", "hitTestChild-M_7yMNQ", "onInitialize", "shouldSharePointerInputWithSiblings", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PointerInputDelegatingWrapper.kt */
public final class PointerInputDelegatingWrapper extends DelegatingLayoutNodeWrapper<PointerInputModifier> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PointerInputDelegatingWrapper(LayoutNodeWrapper layoutNodeWrapper, PointerInputModifier pointerInputModifier) {
        super(layoutNodeWrapper, pointerInputModifier);
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "wrapped");
        Intrinsics.checkNotNullParameter(pointerInputModifier, "modifier");
    }

    public void onInitialize() {
        super.onInitialize();
        ((PointerInputModifier) getModifier()).getPointerInputFilter().setLayoutCoordinates$ui_release(this);
    }

    /* renamed from: hitTest-M_7yMNQ  reason: not valid java name */
    public void m3377hitTestM_7yMNQ(long j, HitTestResult<PointerInputFilter> hitTestResult, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        boolean z3 = z;
        m3243hitTestInMinimumTouchTarget7362WCg(j, hitTestResult, ((PointerInputModifier) getModifier()).getPointerInputFilter().getInterceptOutOfBoundsChildEvents(), z3, z2, ((PointerInputModifier) getModifier()).getPointerInputFilter(), new PointerInputDelegatingWrapper$hitTest$1(this, j, hitTestResult, z3));
    }

    /* access modifiers changed from: private */
    /* renamed from: hitTestChild-M_7yMNQ  reason: not valid java name */
    public final void m3376hitTestChildM_7yMNQ(long j, HitTestResult<PointerInputFilter> hitTestResult, boolean z, boolean z2) {
        getWrapped$ui_release().m3345hitTestM_7yMNQ(getWrapped$ui_release().m3341fromParentPositionMKHz9U(j), hitTestResult, z, z2);
    }

    public boolean shouldSharePointerInputWithSiblings() {
        return ((PointerInputModifier) getModifier()).getPointerInputFilter().getShareWithSiblings() || getWrapped$ui_release().shouldSharePointerInputWithSiblings();
    }
}
