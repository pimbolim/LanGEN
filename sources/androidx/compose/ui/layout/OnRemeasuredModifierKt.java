package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0012\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0007ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"onSizeChanged", "Landroidx/compose/ui/Modifier;", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: OnRemeasuredModifier.kt */
public final class OnRemeasuredModifierKt {
    public static final Modifier onSizeChanged(Modifier modifier, Function1<? super IntSize, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onSizeChanged");
        return modifier.then(new OnSizeChangedModifier(function1, InspectableValueKt.isDebugInspectorInfoEnabled() ? new OnRemeasuredModifierKt$onSizeChanged$$inlined$debugInspectorInfo$1(function1) : InspectableValueKt.getNoInspectorInfo()));
    }
}
