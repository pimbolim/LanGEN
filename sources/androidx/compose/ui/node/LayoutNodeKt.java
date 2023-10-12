package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000\u001a(\u0010\u0006\u001a\u0002H\u0007\"\f\b\u0000\u0010\u0007*\u0006\u0012\u0002\b\u00030\b*\u0002H\u00072\u0006\u0010\t\u001a\u00020\nH\b¢\u0006\u0002\u0010\u000b\u001a \u0010\f\u001a\u0002H\u0007\"\f\b\u0000\u0010\u0007*\u0006\u0012\u0002\b\u00030\b*\u0002H\u0007H\b¢\u0006\u0002\u0010\r\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"DebugChanges", "", "add", "", "Landroidx/compose/ui/node/LayoutNode;", "child", "assignChained", "T", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "originalWrapper", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "(Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;Landroidx/compose/ui/node/LayoutNodeWrapper;)Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "initialize", "(Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;)Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "requireOwner", "Landroidx/compose/ui/node/Owner;", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LayoutNode.kt */
public final class LayoutNodeKt {
    private static final boolean DebugChanges = false;

    public static final Owner requireOwner(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        Owner owner$ui_release = layoutNode.getOwner$ui_release();
        if (owner$ui_release != null) {
            return owner$ui_release;
        }
        throw new IllegalStateException("LayoutNode should be attached to an owner".toString());
    }

    public static final void add(LayoutNode layoutNode, LayoutNode layoutNode2) {
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        Intrinsics.checkNotNullParameter(layoutNode2, "child");
        layoutNode.insertAt$ui_release(layoutNode.getChildren$ui_release().size(), layoutNode2);
    }

    private static final <T extends DelegatingLayoutNodeWrapper<?>> T assignChained(T t, LayoutNodeWrapper layoutNodeWrapper) {
        if (layoutNodeWrapper != t.getWrapped$ui_release()) {
            ((DelegatingLayoutNodeWrapper) t.getWrapped$ui_release()).setChained(true);
        }
        return t;
    }

    private static final <T extends DelegatingLayoutNodeWrapper<?>> T initialize(T t) {
        t.onInitialize();
        return t;
    }
}
