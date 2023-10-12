package androidx.compose.foundation.lazy.list;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: InspectableValue.kt */
public final class LazyItemScopeImpl$animateItemPlacement$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ FiniteAnimationSpec $animationSpec$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyItemScopeImpl$animateItemPlacement$$inlined$debugInspectorInfo$1(FiniteAnimationSpec finiteAnimationSpec) {
        super(1);
        this.$animationSpec$inlined = finiteAnimationSpec;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("animateItemPlacement");
        inspectorInfo.setValue(this.$animationSpec$inlined);
    }
}
