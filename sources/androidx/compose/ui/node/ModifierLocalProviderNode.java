package androidx.compose.ui.node;

import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\u0002H\t\"\u0004\b\u0001\u0010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/ui/node/ModifierLocalProviderNode;", "T", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "modifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/modifier/ModifierLocalProvider;)V", "onModifierLocalRead", "V", "modifierLocal", "Landroidx/compose/ui/modifier/ModifierLocal;", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ModifierLocalProviderNode.kt */
public final class ModifierLocalProviderNode<T> extends DelegatingLayoutNodeWrapper<ModifierLocalProvider<T>> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModifierLocalProviderNode(LayoutNodeWrapper layoutNodeWrapper, ModifierLocalProvider<T> modifierLocalProvider) {
        super(layoutNodeWrapper, modifierLocalProvider);
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "wrapped");
        Intrinsics.checkNotNullParameter(modifierLocalProvider, "modifier");
    }

    public <V> V onModifierLocalRead(ModifierLocal<V> modifierLocal) {
        Intrinsics.checkNotNullParameter(modifierLocal, "modifierLocal");
        if (Intrinsics.areEqual((Object) ((ModifierLocalProvider) getModifier()).getKey(), (Object) modifierLocal)) {
            return ((ModifierLocalProvider) getModifier()).getValue();
        }
        return super.onModifierLocalRead(modifierLocal);
    }
}
