package androidx.compose.ui.input.nestedscroll;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.DelegatingLayoutNodeWrapper;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeWrapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u0000H\u0016J\b\u0010!\u001a\u00020\u0000H\u0016J\u0016\u0010\"\u001a\u00020\u001e2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0018H\u0002J\b\u0010%\u001a\u00020\u001eH\u0016J\u0012\u0010&\u001a\u00020\u001e2\b\u0010'\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010(\u001a\u00020\u001eH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R4\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8B@BX\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0012\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00028V@VX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00000\u0018X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\t\u001a\u0004\u0018\u00010\u0019@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\u001b\u0010\u001c¨\u0006)"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollDelegatingWrapper;", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollModifier;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "nestedScrollModifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/input/nestedscroll/NestedScrollModifier;)V", "childScrollConnection", "Landroidx/compose/ui/input/nestedscroll/ParentWrapperNestedScrollConnection;", "value", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScopeEvaluation", "getCoroutineScopeEvaluation", "()Lkotlin/jvm/functions/Function0;", "setCoroutineScopeEvaluation", "(Lkotlin/jvm/functions/Function0;)V", "lastModifier", "modifier", "getModifier", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollModifier;", "setModifier", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollModifier;)V", "nestedScrollChildrenResult", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "parentConnection", "setParentConnection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "attach", "", "detach", "findNextNestedScrollWrapper", "findPreviousNestedScrollWrapper", "loopChildrenForNestedScroll", "children", "Landroidx/compose/ui/node/LayoutNode;", "onModifierChanged", "refreshChildrenWithParentConnection", "newParent", "refreshSelfIfNeeded", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NestedScrollDelegatingWrapper.kt */
public final class NestedScrollDelegatingWrapper extends DelegatingLayoutNodeWrapper<NestedScrollModifier> {
    private final ParentWrapperNestedScrollConnection childScrollConnection;
    private NestedScrollModifier lastModifier;
    private final MutableVector<NestedScrollDelegatingWrapper> nestedScrollChildrenResult;
    private NestedScrollConnection parentConnection;

    public NestedScrollDelegatingWrapper findNextNestedScrollWrapper() {
        return this;
    }

    public NestedScrollDelegatingWrapper findPreviousNestedScrollWrapper() {
        return this;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NestedScrollDelegatingWrapper(LayoutNodeWrapper layoutNodeWrapper, NestedScrollModifier nestedScrollModifier) {
        super(layoutNodeWrapper, nestedScrollModifier);
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "wrapped");
        Intrinsics.checkNotNullParameter(nestedScrollModifier, "nestedScrollModifier");
        NestedScrollConnection nestedScrollConnection = this.parentConnection;
        this.childScrollConnection = new ParentWrapperNestedScrollConnection(nestedScrollConnection == null ? NestedScrollDelegatingWrapperKt.NoOpConnection : nestedScrollConnection, nestedScrollModifier.getConnection());
        this.nestedScrollChildrenResult = new MutableVector<>(new NestedScrollDelegatingWrapper[16], 0);
    }

    private final void setParentConnection(NestedScrollConnection nestedScrollConnection) {
        getModifier().getDispatcher().setParent$ui_release(nestedScrollConnection);
        this.childScrollConnection.setParent(nestedScrollConnection == null ? NestedScrollDelegatingWrapperKt.NoOpConnection : nestedScrollConnection);
        this.parentConnection = nestedScrollConnection;
    }

    /* access modifiers changed from: private */
    public final Function0<CoroutineScope> getCoroutineScopeEvaluation() {
        return getModifier().getDispatcher().getCalculateNestedScrollScope$ui_release();
    }

    private final void setCoroutineScopeEvaluation(Function0<? extends CoroutineScope> function0) {
        getModifier().getDispatcher().setCalculateNestedScrollScope$ui_release(function0);
    }

    public void onModifierChanged() {
        super.onModifierChanged();
        this.childScrollConnection.setSelf(getModifier().getConnection());
        getModifier().getDispatcher().setParent$ui_release(this.parentConnection);
        refreshSelfIfNeeded();
    }

    public NestedScrollModifier getModifier() {
        return (NestedScrollModifier) super.getModifier();
    }

    public void setModifier(NestedScrollModifier nestedScrollModifier) {
        Intrinsics.checkNotNullParameter(nestedScrollModifier, "value");
        this.lastModifier = (NestedScrollModifier) super.getModifier();
        super.setModifier(nestedScrollModifier);
    }

    public void attach() {
        super.attach();
        refreshSelfIfNeeded();
    }

    public void detach() {
        super.detach();
        refreshChildrenWithParentConnection(this.parentConnection);
        this.lastModifier = null;
    }

    private final void refreshSelfIfNeeded() {
        ParentWrapperNestedScrollConnection parentWrapperNestedScrollConnection;
        NestedScrollModifier nestedScrollModifier = this.lastModifier;
        if (((nestedScrollModifier != null && nestedScrollModifier.getConnection() == getModifier().getConnection() && nestedScrollModifier.getDispatcher() == getModifier().getDispatcher()) ? false : true) && isAttached()) {
            NestedScrollDelegatingWrapper findPreviousNestedScrollWrapper = super.findPreviousNestedScrollWrapper();
            Function0<CoroutineScope> function0 = null;
            if (findPreviousNestedScrollWrapper == null) {
                parentWrapperNestedScrollConnection = null;
            } else {
                parentWrapperNestedScrollConnection = findPreviousNestedScrollWrapper.childScrollConnection;
            }
            setParentConnection(parentWrapperNestedScrollConnection);
            if (findPreviousNestedScrollWrapper != null) {
                function0 = findPreviousNestedScrollWrapper.getCoroutineScopeEvaluation();
            }
            if (function0 == null) {
                function0 = getCoroutineScopeEvaluation();
            }
            setCoroutineScopeEvaluation(function0);
            refreshChildrenWithParentConnection(this.childScrollConnection);
            this.lastModifier = getModifier();
        }
    }

    private final void refreshChildrenWithParentConnection(NestedScrollConnection nestedScrollConnection) {
        this.nestedScrollChildrenResult.clear();
        NestedScrollDelegatingWrapper findNextNestedScrollWrapper = getWrapped$ui_release().findNextNestedScrollWrapper();
        if (findNextNestedScrollWrapper != null) {
            this.nestedScrollChildrenResult.add(findNextNestedScrollWrapper);
        } else {
            loopChildrenForNestedScroll(getLayoutNode$ui_release().get_children$ui_release());
        }
        int i = 0;
        NestedScrollDelegatingWrapper nestedScrollDelegatingWrapper = this.nestedScrollChildrenResult.isNotEmpty() ? (NestedScrollDelegatingWrapper) this.nestedScrollChildrenResult.getContent()[0] : null;
        MutableVector<NestedScrollDelegatingWrapper> mutableVector = this.nestedScrollChildrenResult;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            do {
                NestedScrollDelegatingWrapper nestedScrollDelegatingWrapper2 = (NestedScrollDelegatingWrapper) content[i];
                nestedScrollDelegatingWrapper2.setParentConnection(nestedScrollConnection);
                nestedScrollDelegatingWrapper2.setCoroutineScopeEvaluation(nestedScrollConnection != null ? new NestedScrollDelegatingWrapper$refreshChildrenWithParentConnection$1$1(this) : new NestedScrollDelegatingWrapper$refreshChildrenWithParentConnection$1$2(nestedScrollDelegatingWrapper));
                i++;
            } while (i < size);
        }
    }

    private final void loopChildrenForNestedScroll(MutableVector<LayoutNode> mutableVector) {
        int size = mutableVector.getSize();
        if (size > 0) {
            int i = 0;
            Object[] content = mutableVector.getContent();
            do {
                LayoutNode layoutNode = (LayoutNode) content[i];
                NestedScrollDelegatingWrapper findNextNestedScrollWrapper = layoutNode.getOuterLayoutNodeWrapper$ui_release().findNextNestedScrollWrapper();
                if (findNextNestedScrollWrapper != null) {
                    this.nestedScrollChildrenResult.add(findNextNestedScrollWrapper);
                } else {
                    loopChildrenForNestedScroll(layoutNode.get_children$ui_release());
                }
                i++;
            } while (i < size);
        }
    }
}
