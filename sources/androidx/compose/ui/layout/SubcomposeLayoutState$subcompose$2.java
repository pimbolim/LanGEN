package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubcomposeLayout.kt */
final class SubcomposeLayoutState$subcompose$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LayoutNode $node;
    final /* synthetic */ SubcomposeLayoutState.NodeState $nodeState;
    final /* synthetic */ SubcomposeLayoutState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubcomposeLayoutState$subcompose$2(SubcomposeLayoutState subcomposeLayoutState, SubcomposeLayoutState.NodeState nodeState, LayoutNode layoutNode) {
        super(0);
        this.this$0 = subcomposeLayoutState;
        this.$nodeState = nodeState;
        this.$node = layoutNode;
    }

    public final void invoke() {
        SubcomposeLayoutState subcomposeLayoutState = this.this$0;
        SubcomposeLayoutState.NodeState nodeState = this.$nodeState;
        LayoutNode layoutNode = this.$node;
        LayoutNode access$getRoot = subcomposeLayoutState.getRoot();
        access$getRoot.ignoreRemeasureRequests = true;
        Function2<Composer, Integer, Unit> content = nodeState.getContent();
        Composition composition = nodeState.getComposition();
        CompositionContext compositionContext$ui_release = subcomposeLayoutState.getCompositionContext$ui_release();
        if (compositionContext$ui_release != null) {
            nodeState.setComposition(subcomposeLayoutState.subcomposeInto(composition, layoutNode, compositionContext$ui_release, ComposableLambdaKt.composableLambdaInstance(-985539783, true, new SubcomposeLayoutState$subcompose$2$1$1(content))));
            access$getRoot.ignoreRemeasureRequests = false;
            return;
        }
        throw new IllegalStateException("parent composition reference not set".toString());
    }
}
