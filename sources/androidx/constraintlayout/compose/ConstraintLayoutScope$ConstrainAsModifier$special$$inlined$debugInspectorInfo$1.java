package androidx.constraintlayout.compose;

import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: InspectableValue.kt */
public final class ConstraintLayoutScope$ConstrainAsModifier$special$$inlined$debugInspectorInfo$1 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ Function1 $constrainBlock$inlined;
    final /* synthetic */ ConstrainedLayoutReference $ref$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConstraintLayoutScope$ConstrainAsModifier$special$$inlined$debugInspectorInfo$1(ConstrainedLayoutReference constrainedLayoutReference, Function1 function1) {
        super(1);
        this.$ref$inlined = constrainedLayoutReference;
        this.$constrainBlock$inlined = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("constrainAs");
        inspectorInfo.getProperties().set("ref", this.$ref$inlined);
        inspectorInfo.getProperties().set("constrainBlock", this.$constrainBlock$inlined);
    }
}
