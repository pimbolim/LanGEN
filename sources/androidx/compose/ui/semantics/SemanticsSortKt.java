package androidx.compose.ui.semantics;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.NodeLocationHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0003H\u0000\u001a\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\u00012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0000\u001a\f\u0010\n\u001a\u00020\u000b*\u00020\u0001H\u0000¨\u0006\f"}, d2 = {"findNodeByPredicateTraversal", "Landroidx/compose/ui/node/LayoutNode;", "predicate", "Lkotlin/Function1;", "", "findOneLayerOfSemanticsWrappersSortedByBounds", "", "Landroidx/compose/ui/semantics/SemanticsWrapper;", "list", "", "findWrapperToGetBounds", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SemanticsSort.kt */
public final class SemanticsSortKt {
    public static /* synthetic */ List findOneLayerOfSemanticsWrappersSortedByBounds$default(LayoutNode layoutNode, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        return findOneLayerOfSemanticsWrappersSortedByBounds(layoutNode, list);
    }

    private static final List<NodeLocationHolder> findOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy(List<NodeLocationHolder> list) {
        try {
            NodeLocationHolder.Companion.setComparisonStrategy$ui_release(NodeLocationHolder.ComparisonStrategy.Stripe);
            List<NodeLocationHolder> mutableList = CollectionsKt.toMutableList(list);
            CollectionsKt.sort(mutableList);
            return mutableList;
        } catch (IllegalArgumentException unused) {
            NodeLocationHolder.Companion.setComparisonStrategy$ui_release(NodeLocationHolder.ComparisonStrategy.Location);
            List<NodeLocationHolder> mutableList2 = CollectionsKt.toMutableList(list);
            CollectionsKt.sort(mutableList2);
            return mutableList2;
        }
    }

    public static final List<SemanticsWrapper> findOneLayerOfSemanticsWrappersSortedByBounds(LayoutNode layoutNode, List<SemanticsWrapper> list) {
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        Intrinsics.checkNotNullParameter(list, "list");
        if (!layoutNode.isAttached()) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        List<LayoutNode> children$ui_release = layoutNode.getChildren$ui_release();
        int size = children$ui_release.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            LayoutNode layoutNode2 = children$ui_release.get(i2);
            if (layoutNode2.isAttached()) {
                arrayList.add(new NodeLocationHolder(layoutNode, layoutNode2));
            }
            i2 = i3;
        }
        List<NodeLocationHolder> findOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy = findOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy(arrayList);
        ArrayList arrayList2 = new ArrayList(findOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy.size());
        int size2 = findOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy.size();
        for (int i4 = 0; i4 < size2; i4++) {
            arrayList2.add(findOneLayerOfSemanticsWrappersSortedByBounds$sortWithStrategy.get(i4).getNode$ui_release());
        }
        List list2 = arrayList2;
        int size3 = list2.size();
        while (i < size3) {
            int i5 = i + 1;
            LayoutNode layoutNode3 = (LayoutNode) list2.get(i);
            SemanticsWrapper outerSemantics = SemanticsNodeKt.getOuterSemantics(layoutNode3);
            if (outerSemantics != null) {
                list.add(outerSemantics);
            } else {
                findOneLayerOfSemanticsWrappersSortedByBounds(layoutNode3, list);
            }
            i = i5;
        }
        return list;
    }

    public static final LayoutNode findNodeByPredicateTraversal(LayoutNode layoutNode, Function1<? super LayoutNode, Boolean> function1) {
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (function1.invoke(layoutNode).booleanValue()) {
            return layoutNode;
        }
        List<LayoutNode> children$ui_release = layoutNode.getChildren$ui_release();
        int i = 0;
        int size = children$ui_release.size();
        while (i < size) {
            int i2 = i + 1;
            LayoutNode findNodeByPredicateTraversal = findNodeByPredicateTraversal(children$ui_release.get(i), function1);
            if (findNodeByPredicateTraversal != null) {
                return findNodeByPredicateTraversal;
            }
            i = i2;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = androidx.compose.ui.semantics.SemanticsNodeKt.getOuterSemantics(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.node.LayoutNodeWrapper findWrapperToGetBounds(androidx.compose.ui.node.LayoutNode r1) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            androidx.compose.ui.semantics.SemanticsWrapper r0 = androidx.compose.ui.semantics.SemanticsNodeKt.getOuterMergingSemantics(r1)
            if (r0 != 0) goto L_0x0016
            androidx.compose.ui.semantics.SemanticsWrapper r0 = androidx.compose.ui.semantics.SemanticsNodeKt.getOuterSemantics(r1)
            if (r0 != 0) goto L_0x0016
            androidx.compose.ui.node.LayoutNodeWrapper r1 = r1.getInnerLayoutNodeWrapper$ui_release()
            goto L_0x0019
        L_0x0016:
            r1 = r0
            androidx.compose.ui.node.LayoutNodeWrapper r1 = (androidx.compose.ui.node.LayoutNodeWrapper) r1
        L_0x0019:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.semantics.SemanticsSortKt.findWrapperToGetBounds(androidx.compose.ui.node.LayoutNode):androidx.compose.ui.node.LayoutNodeWrapper");
    }
}
