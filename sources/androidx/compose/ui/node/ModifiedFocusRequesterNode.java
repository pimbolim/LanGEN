package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.focus.FocusNodeUtilsKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b\u0011J\b\u0010\u0012\u001a\u00020\rH\u0016R\"\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/node/ModifiedFocusRequesterNode;", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/focus/FocusRequesterModifier;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "modifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/focus/FocusRequesterModifier;)V", "value", "Landroidx/compose/ui/focus/FocusRequester;", "focusRequester", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "attach", "", "detach", "findFocusNode", "Landroidx/compose/ui/node/ModifiedFocusNode;", "findFocusNode$ui_release", "onModifierChanged", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModifiedFocusRequesterNode.kt */
public final class ModifiedFocusRequesterNode extends DelegatingLayoutNodeWrapper<FocusRequesterModifier> {
    private FocusRequester focusRequester;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModifiedFocusRequesterNode(LayoutNodeWrapper layoutNodeWrapper, FocusRequesterModifier focusRequesterModifier) {
        super(layoutNodeWrapper, focusRequesterModifier);
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "wrapped");
        Intrinsics.checkNotNullParameter(focusRequesterModifier, "modifier");
    }

    private final void setFocusRequester(FocusRequester focusRequester2) {
        MutableVector<ModifiedFocusRequesterNode> focusRequesterNodes$ui_release;
        MutableVector<ModifiedFocusRequesterNode> focusRequesterNodes$ui_release2;
        FocusRequester focusRequester3 = this.focusRequester;
        if (!(focusRequester3 == null || (focusRequesterNodes$ui_release2 = focusRequester3.getFocusRequesterNodes$ui_release()) == null)) {
            focusRequesterNodes$ui_release2.remove(this);
        }
        this.focusRequester = focusRequester2;
        if (focusRequester2 != null && (focusRequesterNodes$ui_release = focusRequester2.getFocusRequesterNodes$ui_release()) != null) {
            focusRequesterNodes$ui_release.add(this);
        }
    }

    public final ModifiedFocusNode findFocusNode$ui_release() {
        ModifiedFocusNode findNextFocusWrapper = findNextFocusWrapper(false);
        return findNextFocusWrapper == null ? FocusNodeUtilsKt.searchChildrenForFocusNode$default(getLayoutNode$ui_release(), (MutableVector) null, false, 1, (Object) null) : findNextFocusWrapper;
    }

    public void onModifierChanged() {
        super.onModifierChanged();
        setFocusRequester(((FocusRequesterModifier) getModifier()).getFocusRequester());
    }

    public void attach() {
        super.attach();
        setFocusRequester(((FocusRequesterModifier) getModifier()).getFocusRequester());
    }

    public void detach() {
        setFocusRequester((FocusRequester) null);
        super.detach();
    }
}
