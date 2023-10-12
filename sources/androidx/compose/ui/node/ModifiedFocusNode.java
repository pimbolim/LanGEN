package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusModifier;
import androidx.compose.ui.focus.FocusNodeUtilsKt;
import androidx.compose.ui.focus.FocusOrder;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.focus.FocusStateImpl;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0000H\u0016J\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0016J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\"H\u0016J\u000e\u0010#\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\"R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u000e\u001a\u0004\u0018\u00010\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u00008F@FX\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006$"}, d2 = {"Landroidx/compose/ui/node/ModifiedFocusNode;", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/focus/FocusModifier;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "modifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/focus/FocusModifier;)V", "value", "Landroidx/compose/ui/focus/FocusStateImpl;", "focusState", "getFocusState", "()Landroidx/compose/ui/focus/FocusStateImpl;", "setFocusState", "(Landroidx/compose/ui/focus/FocusStateImpl;)V", "focusedChild", "getFocusedChild", "()Landroidx/compose/ui/node/ModifiedFocusNode;", "setFocusedChild", "(Landroidx/compose/ui/node/ModifiedFocusNode;)V", "attach", "", "detach", "findNextFocusWrapper", "excludeDeactivated", "", "findPreviousFocusWrapper", "focusRect", "Landroidx/compose/ui/geometry/Rect;", "onInitialize", "onModifierChanged", "populateFocusOrder", "focusOrder", "Landroidx/compose/ui/focus/FocusOrder;", "propagateFocusEvent", "Landroidx/compose/ui/focus/FocusState;", "sendOnFocusEvent", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModifiedFocusNode.kt */
public final class ModifiedFocusNode extends DelegatingLayoutNodeWrapper<FocusModifier> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ModifiedFocusNode.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FocusStateImpl.values().length];
            iArr[FocusStateImpl.Active.ordinal()] = 1;
            iArr[FocusStateImpl.Captured.ordinal()] = 2;
            iArr[FocusStateImpl.ActiveParent.ordinal()] = 3;
            iArr[FocusStateImpl.DeactivatedParent.ordinal()] = 4;
            iArr[FocusStateImpl.Deactivated.ordinal()] = 5;
            iArr[FocusStateImpl.Inactive.ordinal()] = 6;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ModifiedFocusNode findPreviousFocusWrapper() {
        return this;
    }

    public void populateFocusOrder(FocusOrder focusOrder) {
        Intrinsics.checkNotNullParameter(focusOrder, "focusOrder");
    }

    public void propagateFocusEvent(FocusState focusState) {
        Intrinsics.checkNotNullParameter(focusState, "focusState");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModifiedFocusNode(LayoutNodeWrapper layoutNodeWrapper, FocusModifier focusModifier) {
        super(layoutNodeWrapper, focusModifier);
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "wrapped");
        Intrinsics.checkNotNullParameter(focusModifier, "modifier");
    }

    public void onInitialize() {
        super.onInitialize();
        ((FocusModifier) getModifier()).setFocusNode(this);
    }

    public final FocusStateImpl getFocusState() {
        return ((FocusModifier) getModifier()).getFocusState();
    }

    public final void setFocusState(FocusStateImpl focusStateImpl) {
        Intrinsics.checkNotNullParameter(focusStateImpl, "value");
        ((FocusModifier) getModifier()).setFocusState(focusStateImpl);
        sendOnFocusEvent(focusStateImpl);
    }

    public final ModifiedFocusNode getFocusedChild() {
        return ((FocusModifier) getModifier()).getFocusedChild();
    }

    public final void setFocusedChild(ModifiedFocusNode modifiedFocusNode) {
        ((FocusModifier) getModifier()).setFocusedChild(modifiedFocusNode);
    }

    public final Rect focusRect() {
        LayoutCoordinates layoutCoordinates = this;
        return LayoutCoordinatesKt.findRoot(layoutCoordinates).localBoundingBoxOf(layoutCoordinates, false);
    }

    public final void sendOnFocusEvent(FocusState focusState) {
        LayoutNodeWrapper wrappedBy$ui_release;
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        if (isAttached() && ((FocusModifier) getModifier()).getHasFocusListeners() && (wrappedBy$ui_release = getWrappedBy$ui_release()) != null) {
            wrappedBy$ui_release.propagateFocusEvent(focusState);
        }
    }

    public void onModifierChanged() {
        super.onModifierChanged();
        sendOnFocusEvent(getFocusState());
    }

    public void attach() {
        super.attach();
        sendOnFocusEvent(getFocusState());
    }

    public void detach() {
        FocusManager focusManager;
        FocusStateImpl focusStateImpl;
        int i = WhenMappings.$EnumSwitchMapping$0[getFocusState().ordinal()];
        if (i == 1 || i == 2) {
            Owner owner$ui_release = getLayoutNode$ui_release().getOwner$ui_release();
            if (!(owner$ui_release == null || (focusManager = owner$ui_release.getFocusManager()) == null)) {
                focusManager.clearFocus(true);
            }
        } else {
            FocusStateImpl focusStateImpl2 = null;
            if (i == 3 || i == 4) {
                ModifiedFocusNode findNextFocusWrapper = getWrapped$ui_release().findNextFocusWrapper(false);
                if (findNextFocusWrapper == null) {
                    findNextFocusWrapper = FocusNodeUtilsKt.searchChildrenForFocusNode$default(getLayoutNode$ui_release(), (MutableVector) null, false, 1, (Object) null);
                }
                ModifiedFocusNode findParentFocusNode$ui_release = findParentFocusNode$ui_release();
                if (findParentFocusNode$ui_release != null) {
                    ((FocusModifier) findParentFocusNode$ui_release.getModifier()).setFocusedChild(findNextFocusWrapper);
                    if (findNextFocusWrapper != null) {
                        sendOnFocusEvent(findNextFocusWrapper.getFocusState());
                    } else {
                        int i2 = WhenMappings.$EnumSwitchMapping$0[findParentFocusNode$ui_release.getFocusState().ordinal()];
                        if (i2 == 3) {
                            focusStateImpl = FocusStateImpl.Inactive;
                        } else if (i2 != 4) {
                            focusStateImpl = findParentFocusNode$ui_release.getFocusState();
                        } else {
                            focusStateImpl = FocusStateImpl.Deactivated;
                        }
                        findParentFocusNode$ui_release.setFocusState(focusStateImpl);
                    }
                }
            } else if (i == 5) {
                ModifiedFocusNode findNextFocusWrapper2 = getWrapped$ui_release().findNextFocusWrapper(false);
                if (findNextFocusWrapper2 == null) {
                    findNextFocusWrapper2 = FocusNodeUtilsKt.searchChildrenForFocusNode$default(getLayoutNode$ui_release(), (MutableVector) null, false, 1, (Object) null);
                }
                if (findNextFocusWrapper2 != null) {
                    focusStateImpl2 = findNextFocusWrapper2.getFocusState();
                }
                if (focusStateImpl2 == null) {
                    focusStateImpl2 = FocusStateImpl.Inactive;
                }
                sendOnFocusEvent(focusStateImpl2);
            }
        }
        super.detach();
    }

    public ModifiedFocusNode findNextFocusWrapper(boolean z) {
        return (!((FocusModifier) getModifier()).getFocusState().isDeactivated() || !z) ? this : super.findNextFocusWrapper(z);
    }
}
