package androidx.compose.ui.input.pointer;

import androidx.compose.ui.platform.InspectorInfo;
import com.drew.metadata.mov.QuickTimeAtomTypes;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "invoke", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: InspectableValue.kt */
public final class SuspendingPointerInputFilterKt$pointerInput$$inlined$debugInspectorInfo$3 extends Lambda implements Function1<InspectorInfo, Unit> {
    final /* synthetic */ Function2 $block$inlined;
    final /* synthetic */ Object[] $keys$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuspendingPointerInputFilterKt$pointerInput$$inlined$debugInspectorInfo$3(Object[] objArr, Function2 function2) {
        super(1);
        this.$keys$inlined = objArr;
        this.$block$inlined = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((InspectorInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(InspectorInfo inspectorInfo) {
        Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
        inspectorInfo.setName("pointerInput");
        inspectorInfo.getProperties().set(QuickTimeAtomTypes.ATOM_KEYS, this.$keys$inlined);
        inspectorInfo.getProperties().set("block", this.$block$inlined);
    }
}
