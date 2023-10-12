package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LayoutNode.kt */
final class LayoutNode$layoutChildren$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LayoutNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutNode$layoutChildren$1(LayoutNode layoutNode) {
        super(0);
        this.this$0 = layoutNode;
    }

    public final void invoke() {
        int i = 0;
        this.this$0.nextChildPlaceOrder = 0;
        MutableVector<LayoutNode> mutableVector = this.this$0.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            int i2 = 0;
            do {
                LayoutNode layoutNode = (LayoutNode) content[i2];
                layoutNode.previousPlaceOrder = layoutNode.getPlaceOrder$ui_release();
                layoutNode.placeOrder = Integer.MAX_VALUE;
                layoutNode.getAlignmentLines$ui_release().setUsedDuringParentLayout$ui_release(false);
                if (layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InLayoutBlock) {
                    layoutNode.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
                }
                i2++;
            } while (i2 < size);
        }
        this.this$0.getInnerLayoutNodeWrapper$ui_release().getMeasureResult().placeChildren();
        MutableVector<LayoutNode> mutableVector2 = this.this$0.get_children$ui_release();
        LayoutNode layoutNode2 = this.this$0;
        int size2 = mutableVector2.getSize();
        if (size2 > 0) {
            Object[] content2 = mutableVector2.getContent();
            do {
                LayoutNode layoutNode3 = (LayoutNode) content2[i];
                if (layoutNode3.previousPlaceOrder != layoutNode3.getPlaceOrder$ui_release()) {
                    layoutNode2.onZSortedChildrenInvalidated();
                    layoutNode2.invalidateLayer$ui_release();
                    if (layoutNode3.getPlaceOrder$ui_release() == Integer.MAX_VALUE) {
                        layoutNode3.markSubtreeAsNotPlaced();
                    }
                }
                layoutNode3.getAlignmentLines$ui_release().setPreviousUsedDuringParentLayout$ui_release(layoutNode3.getAlignmentLines$ui_release().getUsedDuringParentLayout$ui_release());
                i++;
            } while (i < size2);
        }
    }
}
