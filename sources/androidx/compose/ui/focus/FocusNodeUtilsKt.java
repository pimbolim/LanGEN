package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifiedFocusNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0000\u001a&\u0010\n\u001a\u0004\u0018\u00010\u0007*\u00020\u00042\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\b\u001a\u00020\tH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"FocusTag", "", "findFocusableChildren", "", "Landroidx/compose/ui/node/LayoutNode;", "focusableChildren", "", "Landroidx/compose/ui/node/ModifiedFocusNode;", "excludeDeactivated", "", "searchChildrenForFocusNode", "queue", "Landroidx/compose/runtime/collection/MutableVector;", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FocusNodeUtils.kt */
public final class FocusNodeUtilsKt {
    public static final String FocusTag = "Compose Focus";

    public static final void findFocusableChildren(LayoutNode layoutNode, List<ModifiedFocusNode> list, boolean z) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        Intrinsics.checkNotNullParameter(list, "focusableChildren");
        ModifiedFocusNode findNextFocusWrapper = layoutNode.getOuterLayoutNodeWrapper$ui_release().findNextFocusWrapper(z);
        if (findNextFocusWrapper == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(list.add(findNextFocusWrapper));
        }
        if (bool == null) {
            List<LayoutNode> children$ui_release = layoutNode.getChildren$ui_release();
            int size = children$ui_release.size();
            for (int i = 0; i < size; i++) {
                findFocusableChildren(children$ui_release.get(i), list, z);
            }
        }
    }

    public static final ModifiedFocusNode searchChildrenForFocusNode(LayoutNode layoutNode, MutableVector<LayoutNode> mutableVector, boolean z) {
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        Intrinsics.checkNotNullParameter(mutableVector, "queue");
        MutableVector<LayoutNode> mutableVector2 = layoutNode.get_children$ui_release();
        int size = mutableVector2.getSize();
        if (size > 0) {
            Object[] content = mutableVector2.getContent();
            int i = 0;
            do {
                LayoutNode layoutNode2 = (LayoutNode) content[i];
                ModifiedFocusNode findNextFocusWrapper = layoutNode2.getOuterLayoutNodeWrapper$ui_release().findNextFocusWrapper(z);
                if (findNextFocusWrapper != null) {
                    return findNextFocusWrapper;
                }
                mutableVector.add(layoutNode2);
                i++;
            } while (i < size);
        }
        while (mutableVector.isNotEmpty()) {
            ModifiedFocusNode searchChildrenForFocusNode = searchChildrenForFocusNode(mutableVector.removeAt(0), mutableVector, z);
            if (searchChildrenForFocusNode != null) {
                return searchChildrenForFocusNode;
            }
        }
        return null;
    }

    public static /* synthetic */ ModifiedFocusNode searchChildrenForFocusNode$default(LayoutNode layoutNode, MutableVector mutableVector, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            mutableVector = new MutableVector(new LayoutNode[16], 0);
        }
        return searchChildrenForFocusNode(layoutNode, mutableVector, z);
    }
}
