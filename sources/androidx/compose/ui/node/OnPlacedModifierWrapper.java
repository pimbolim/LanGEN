package androidx.compose.ui.node;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.OnPlacedModifier;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/node/OnPlacedModifierWrapper;", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/layout/OnPlacedModifier;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "modifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/layout/OnPlacedModifier;)V", "providedAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "getProvidedAlignmentLines", "()Ljava/util/Set;", "onPlaced", "", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OnPlacedModifierWrapper.kt */
public final class OnPlacedModifierWrapper extends DelegatingLayoutNodeWrapper<OnPlacedModifier> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnPlacedModifierWrapper(LayoutNodeWrapper layoutNodeWrapper, OnPlacedModifier onPlacedModifier) {
        super(layoutNodeWrapper, onPlacedModifier);
        Intrinsics.checkNotNullParameter(layoutNodeWrapper, "wrapped");
        Intrinsics.checkNotNullParameter(onPlacedModifier, "modifier");
    }

    public Set<AlignmentLine> getProvidedAlignmentLines() {
        Set<AlignmentLine> linkedHashSet = new LinkedHashSet<>();
        getLayoutNode$ui_release();
        for (LayoutNodeWrapper wrapped$ui_release = getWrapped$ui_release(); wrapped$ui_release != null; wrapped$ui_release = wrapped$ui_release.getWrapped$ui_release()) {
            CollectionsKt.addAll(linkedHashSet, wrapped$ui_release.getProvidedAlignmentLines());
            if (Intrinsics.areEqual((Object) wrapped$ui_release, (Object) getLayoutNode$ui_release().getInnerLayoutNodeWrapper$ui_release())) {
                break;
            }
        }
        return linkedHashSet;
    }

    public void onPlaced() {
        ((OnPlacedModifier) getModifier()).onPlaced(this);
    }
}
