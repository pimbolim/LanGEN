package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "mod", "Landroidx/compose/ui/Modifier$Element;", "invoke", "(Lkotlin/Unit;Landroidx/compose/ui/Modifier$Element;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LayoutNode.kt */
final class LayoutNode$markReusedModifiers$2 extends Lambda implements Function2<Unit, Modifier.Element, Unit> {
    final /* synthetic */ LayoutNode this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutNode$markReusedModifiers$2(LayoutNode layoutNode) {
        super(2);
        this.this$0 = layoutNode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Unit) obj, (Modifier.Element) obj2);
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.Object[]} */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(kotlin.Unit r7, androidx.compose.ui.Modifier.Element r8) {
        /*
            r6 = this;
            java.lang.String r0 = "$noName_0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r7 = "mod"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r7)
            androidx.compose.ui.node.LayoutNode r7 = r6.this$0
            androidx.compose.runtime.collection.MutableVector r7 = r7.wrapperCache
            int r0 = r7.getSize()
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L_0x0038
            int r0 = r0 - r1
            java.lang.Object[] r7 = r7.getContent()
        L_0x001d:
            r3 = r7[r0]
            r4 = r3
            androidx.compose.ui.node.DelegatingLayoutNodeWrapper r4 = (androidx.compose.ui.node.DelegatingLayoutNodeWrapper) r4
            androidx.compose.ui.Modifier$Element r5 = r4.getModifier()
            if (r5 != r8) goto L_0x0030
            boolean r4 = r4.getToBeReusedForSameModifier()
            if (r4 != 0) goto L_0x0030
            r4 = 1
            goto L_0x0031
        L_0x0030:
            r4 = 0
        L_0x0031:
            if (r4 == 0) goto L_0x0034
            goto L_0x0039
        L_0x0034:
            int r0 = r0 + -1
            if (r0 >= 0) goto L_0x001d
        L_0x0038:
            r3 = r2
        L_0x0039:
            androidx.compose.ui.node.DelegatingLayoutNodeWrapper r3 = (androidx.compose.ui.node.DelegatingLayoutNodeWrapper) r3
        L_0x003b:
            if (r3 == 0) goto L_0x0054
            r3.setToBeReusedForSameModifier(r1)
            boolean r7 = r3.isChained()
            if (r7 == 0) goto L_0x0052
            androidx.compose.ui.node.LayoutNodeWrapper r7 = r3.getWrappedBy$ui_release()
            boolean r8 = r7 instanceof androidx.compose.ui.node.DelegatingLayoutNodeWrapper
            if (r8 == 0) goto L_0x0052
            androidx.compose.ui.node.DelegatingLayoutNodeWrapper r7 = (androidx.compose.ui.node.DelegatingLayoutNodeWrapper) r7
            r3 = r7
            goto L_0x003b
        L_0x0052:
            r3 = r2
            goto L_0x003b
        L_0x0054:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode$markReusedModifiers$2.invoke(kotlin.Unit, androidx.compose.ui.Modifier$Element):void");
    }
}
