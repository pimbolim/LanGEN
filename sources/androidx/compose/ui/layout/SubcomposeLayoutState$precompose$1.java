package androidx.compose.ui.layout;

import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"androidx/compose/ui/layout/SubcomposeLayoutState$precompose$1", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "dispose", "", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubcomposeLayout.kt */
public final class SubcomposeLayoutState$precompose$1 implements SubcomposeLayoutState.PrecomposedSlotHandle {
    final /* synthetic */ Object $slotId;
    final /* synthetic */ SubcomposeLayoutState this$0;

    SubcomposeLayoutState$precompose$1(SubcomposeLayoutState subcomposeLayoutState, Object obj) {
        this.this$0 = subcomposeLayoutState;
        this.$slotId = obj;
    }

    public void dispose() {
        LayoutNode layoutNode = (LayoutNode) this.this$0.precomposeMap.remove(this.$slotId);
        if (layoutNode != null) {
            int indexOf = this.this$0.getRoot().getFoldedChildren$ui_release().indexOf(layoutNode);
            boolean z = false;
            if (indexOf != -1) {
                if (this.this$0.reusableCount < this.this$0.maxSlotsToRetainForReuse) {
                    this.this$0.move(indexOf, (this.this$0.getRoot().getFoldedChildren$ui_release().size() - this.this$0.precomposedCount) - this.this$0.reusableCount, 1);
                    SubcomposeLayoutState subcomposeLayoutState = this.this$0;
                    subcomposeLayoutState.reusableCount = subcomposeLayoutState.reusableCount + 1;
                } else {
                    SubcomposeLayoutState subcomposeLayoutState2 = this.this$0;
                    LayoutNode access$getRoot = subcomposeLayoutState2.getRoot();
                    access$getRoot.ignoreRemeasureRequests = true;
                    subcomposeLayoutState2.disposeNode(layoutNode);
                    subcomposeLayoutState2.getRoot().removeAt$ui_release(indexOf, 1);
                    access$getRoot.ignoreRemeasureRequests = false;
                }
                if (this.this$0.precomposedCount > 0) {
                    z = true;
                }
                if (z) {
                    SubcomposeLayoutState subcomposeLayoutState3 = this.this$0;
                    subcomposeLayoutState3.precomposedCount = subcomposeLayoutState3.precomposedCount - 1;
                    return;
                }
                throw new IllegalStateException("Check failed.".toString());
            }
            throw new IllegalStateException("Check failed.".toString());
        }
    }
}
