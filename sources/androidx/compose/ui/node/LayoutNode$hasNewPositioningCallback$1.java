package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "mod", "Landroidx/compose/ui/Modifier$Element;", "hasNewCallback", "invoke", "(Landroidx/compose/ui/Modifier$Element;Z)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LayoutNode.kt */
final class LayoutNode$hasNewPositioningCallback$1 extends Lambda implements Function2<Modifier.Element, Boolean, Boolean> {
    final /* synthetic */ MutableVector<OnGloballyPositionedModifierWrapper> $onPositionedCallbacks;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LayoutNode$hasNewPositioningCallback$1(MutableVector<OnGloballyPositionedModifierWrapper> mutableVector) {
        super(2);
        this.$onPositionedCallbacks = mutableVector;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((Modifier.Element) obj, ((Boolean) obj2).booleanValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.Object[]} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        if (r1 == null) goto L_0x0036;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke(androidx.compose.ui.Modifier.Element r7, boolean r8) {
        /*
            r6 = this;
            java.lang.String r0 = "mod"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 0
            if (r8 != 0) goto L_0x0036
            boolean r8 = r7 instanceof androidx.compose.ui.layout.OnGloballyPositionedModifier
            if (r8 == 0) goto L_0x0037
            androidx.compose.runtime.collection.MutableVector<androidx.compose.ui.node.OnGloballyPositionedModifierWrapper> r8 = r6.$onPositionedCallbacks
            r1 = 0
            if (r8 != 0) goto L_0x0012
            goto L_0x0034
        L_0x0012:
            int r2 = r8.getSize()
            if (r2 <= 0) goto L_0x0032
            java.lang.Object[] r8 = r8.getContent()
            r3 = 0
        L_0x001d:
            r4 = r8[r3]
            r5 = r4
            androidx.compose.ui.node.OnGloballyPositionedModifierWrapper r5 = (androidx.compose.ui.node.OnGloballyPositionedModifierWrapper) r5
            androidx.compose.ui.Modifier$Element r5 = r5.getModifier()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x002e
            r1 = r4
            goto L_0x0032
        L_0x002e:
            int r3 = r3 + 1
            if (r3 < r2) goto L_0x001d
        L_0x0032:
            androidx.compose.ui.node.OnGloballyPositionedModifierWrapper r1 = (androidx.compose.ui.node.OnGloballyPositionedModifierWrapper) r1
        L_0x0034:
            if (r1 != 0) goto L_0x0037
        L_0x0036:
            r0 = 1
        L_0x0037:
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode$hasNewPositioningCallback$1.invoke(androidx.compose.ui.Modifier$Element, boolean):java.lang.Boolean");
    }
}
