package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusModifier;
import androidx.compose.ui.focus.FocusModifierKt;
import androidx.compose.ui.focus.FocusNodeUtilsKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.focus.FocusStateImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Landroidx/compose/ui/node/ModifiedFocusEventNode;", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/focus/FocusEventModifier;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "modifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/focus/FocusEventModifier;)V", "onModifierChanged", "", "propagateFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModifiedFocusEventNode.kt */
public final class ModifiedFocusEventNode extends DelegatingLayoutNodeWrapper<FocusEventModifier> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModifiedFocusEventNode(LayoutNodeWrapper layoutNodeWrapper, FocusEventModifier focusEventModifier) {
        super(layoutNodeWrapper, focusEventModifier);
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "wrapped");
        Intrinsics.checkNotNullParameter(focusEventModifier, "modifier");
    }

    public void propagateFocusEvent(FocusState focusState) {
        Intrinsics.checkNotNullParameter(focusState, "focusState");
        ((FocusEventModifier) getModifier()).onFocusEvent(focusState);
        if (((Boolean) onModifierLocalRead(FocusModifierKt.getModifierLocalHasFocusEventListener())).booleanValue()) {
            super.propagateFocusEvent(focusState);
        }
    }

    public void onModifierChanged() {
        FocusModifier focusModifier;
        super.onModifierChanged();
        ModifiedFocusNode findNextFocusWrapper = getWrapped$ui_release().findNextFocusWrapper(false);
        FocusStateImpl focusStateImpl = null;
        if (findNextFocusWrapper == null) {
            findNextFocusWrapper = FocusNodeUtilsKt.searchChildrenForFocusNode$default(getLayoutNode$ui_release(), (MutableVector) null, false, 1, (Object) null);
        }
        FocusEventModifier focusEventModifier = (FocusEventModifier) getModifier();
        if (!(findNextFocusWrapper == null || (focusModifier = (FocusModifier) findNextFocusWrapper.getModifier()) == null)) {
            focusStateImpl = focusModifier.getFocusState();
        }
        if (focusStateImpl == null) {
            focusStateImpl = FocusStateImpl.Inactive;
        }
        focusEventModifier.onFocusEvent(focusStateImpl);
    }
}
