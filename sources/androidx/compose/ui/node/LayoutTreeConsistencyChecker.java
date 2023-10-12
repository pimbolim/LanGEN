package androidx.compose.ui.node;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0003H\u0002J\f\u0010\u0011\u001a\u00020\f*\u00020\u0003H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/node/LayoutTreeConsistencyChecker;", "", "root", "Landroidx/compose/ui/node/LayoutNode;", "relayoutNodes", "Landroidx/compose/ui/node/DepthSortedSet;", "postponedMeasureRequests", "", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/DepthSortedSet;Ljava/util/List;)V", "assertConsistent", "", "isTreeConsistent", "", "node", "logTree", "", "nodeToString", "consistentLayoutState", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LayoutTreeConsistencyChecker.kt */
public final class LayoutTreeConsistencyChecker {
    private final List<LayoutNode> postponedMeasureRequests;
    private final DepthSortedSet relayoutNodes;
    private final LayoutNode root;

    public LayoutTreeConsistencyChecker(LayoutNode layoutNode, DepthSortedSet depthSortedSet, List<LayoutNode> list) {
        Intrinsics.checkNotNullParameter(layoutNode, "root");
        Intrinsics.checkNotNullParameter(depthSortedSet, "relayoutNodes");
        Intrinsics.checkNotNullParameter(list, "postponedMeasureRequests");
        this.root = layoutNode;
        this.relayoutNodes = depthSortedSet;
        this.postponedMeasureRequests = list;
    }

    public final void assertConsistent() {
        if (!isTreeConsistent(this.root)) {
            System.out.println(logTree());
            throw new IllegalStateException("Inconsistency found!");
        }
    }

    private final boolean isTreeConsistent(LayoutNode layoutNode) {
        if (!consistentLayoutState(layoutNode)) {
            return false;
        }
        List<LayoutNode> children$ui_release = layoutNode.getChildren$ui_release();
        int size = children$ui_release.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            if (!isTreeConsistent(children$ui_release.get(i))) {
                return false;
            }
            i = i2;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        if ((r0 != null && r0.isPlaced()) != false) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean consistentLayoutState(androidx.compose.ui.node.LayoutNode r6) {
        /*
            r5 = this;
            androidx.compose.ui.node.LayoutNode r0 = r6.getParent$ui_release()
            boolean r1 = r6.isPlaced()
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x0022
            int r1 = r6.getPlaceOrder$ui_release()
            r4 = 2147483647(0x7fffffff, float:NaN)
            if (r1 == r4) goto L_0x0077
            if (r0 != 0) goto L_0x0019
        L_0x0017:
            r1 = 0
            goto L_0x0020
        L_0x0019:
            boolean r1 = r0.isPlaced()
            if (r1 != r3) goto L_0x0017
            r1 = 1
        L_0x0020:
            if (r1 == 0) goto L_0x0077
        L_0x0022:
            androidx.compose.ui.node.LayoutNode$LayoutState r1 = r6.getLayoutState$ui_release()
            androidx.compose.ui.node.LayoutNode$LayoutState r4 = androidx.compose.ui.node.LayoutNode.LayoutState.NeedsRemeasure
            if (r1 != r4) goto L_0x0033
            java.util.List<androidx.compose.ui.node.LayoutNode> r1 = r5.postponedMeasureRequests
            boolean r1 = r1.contains(r6)
            if (r1 == 0) goto L_0x0033
            return r3
        L_0x0033:
            if (r0 != 0) goto L_0x0037
            r0 = 0
            goto L_0x003b
        L_0x0037:
            androidx.compose.ui.node.LayoutNode$LayoutState r0 = r0.getLayoutState$ui_release()
        L_0x003b:
            androidx.compose.ui.node.LayoutNode$LayoutState r1 = r6.getLayoutState$ui_release()
            androidx.compose.ui.node.LayoutNode$LayoutState r4 = androidx.compose.ui.node.LayoutNode.LayoutState.NeedsRemeasure
            if (r1 != r4) goto L_0x0055
            androidx.compose.ui.node.DepthSortedSet r1 = r5.relayoutNodes
            boolean r6 = r1.contains(r6)
            if (r6 != 0) goto L_0x0053
            androidx.compose.ui.node.LayoutNode$LayoutState r6 = androidx.compose.ui.node.LayoutNode.LayoutState.NeedsRemeasure
            if (r0 == r6) goto L_0x0053
            androidx.compose.ui.node.LayoutNode$LayoutState r6 = androidx.compose.ui.node.LayoutNode.LayoutState.Measuring
            if (r0 != r6) goto L_0x0054
        L_0x0053:
            r2 = 1
        L_0x0054:
            return r2
        L_0x0055:
            androidx.compose.ui.node.LayoutNode$LayoutState r1 = r6.getLayoutState$ui_release()
            androidx.compose.ui.node.LayoutNode$LayoutState r4 = androidx.compose.ui.node.LayoutNode.LayoutState.NeedsRelayout
            if (r1 != r4) goto L_0x0077
            androidx.compose.ui.node.DepthSortedSet r1 = r5.relayoutNodes
            boolean r6 = r1.contains(r6)
            if (r6 != 0) goto L_0x0075
            androidx.compose.ui.node.LayoutNode$LayoutState r6 = androidx.compose.ui.node.LayoutNode.LayoutState.NeedsRemeasure
            if (r0 == r6) goto L_0x0075
            androidx.compose.ui.node.LayoutNode$LayoutState r6 = androidx.compose.ui.node.LayoutNode.LayoutState.NeedsRelayout
            if (r0 == r6) goto L_0x0075
            androidx.compose.ui.node.LayoutNode$LayoutState r6 = androidx.compose.ui.node.LayoutNode.LayoutState.Measuring
            if (r0 == r6) goto L_0x0075
            androidx.compose.ui.node.LayoutNode$LayoutState r6 = androidx.compose.ui.node.LayoutNode.LayoutState.LayingOut
            if (r0 != r6) goto L_0x0076
        L_0x0075:
            r2 = 1
        L_0x0076:
            return r2
        L_0x0077:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutTreeConsistencyChecker.consistentLayoutState(androidx.compose.ui.node.LayoutNode):boolean");
    }

    private final String nodeToString(LayoutNode layoutNode) {
        StringBuilder sb = new StringBuilder();
        sb.append(layoutNode);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(AbstractJsonLexerKt.BEGIN_LIST);
        sb2.append(layoutNode.getLayoutState$ui_release());
        sb2.append(AbstractJsonLexerKt.END_LIST);
        sb.append(sb2.toString());
        if (!layoutNode.isPlaced()) {
            sb.append("[!isPlaced]");
        }
        sb.append("[measuredByParent=" + layoutNode.getMeasuredByParent$ui_release() + AbstractJsonLexerKt.END_LIST);
        if (!consistentLayoutState(layoutNode)) {
            sb.append("[INCONSISTENT]");
        }
        String sb3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "with(StringBuilder()) {\n…     toString()\n        }");
        return sb3;
    }

    private final String logTree() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tree state:");
        Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
        sb.append(10);
        Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
        logTree$printSubTree(this, sb, this.root, 0);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.toString()");
        return sb2;
    }

    private static final void logTree$printSubTree(LayoutTreeConsistencyChecker layoutTreeConsistencyChecker, StringBuilder sb, LayoutNode layoutNode, int i) {
        String nodeToString = layoutTreeConsistencyChecker.nodeToString(layoutNode);
        if (nodeToString.length() > 0) {
            int i2 = 0;
            while (i2 < i) {
                i2++;
                sb.append("..");
            }
            sb.append(nodeToString);
            Intrinsics.checkNotNullExpressionValue(sb, "append(value)");
            sb.append(10);
            Intrinsics.checkNotNullExpressionValue(sb, "append('\\n')");
            i++;
        }
        List<LayoutNode> children$ui_release = layoutNode.getChildren$ui_release();
        int size = children$ui_release.size();
        for (int i3 = 0; i3 < size; i3++) {
            logTree$printSubTree(layoutTreeConsistencyChecker, sb, children$ui_release.get(i3), i);
        }
    }
}
