package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002¨\u0006\u0003"}, d2 = {"focusRequester", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/focus/FocusRequester;", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FocusRequesterModifier.kt */
public final class FocusRequesterModifierKt {
    public static final Modifier focusRequester(Modifier modifier, FocusRequester focusRequester) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(focusRequester, "focusRequester");
        return modifier.then(new FocusRequesterModifierImpl(focusRequester, InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusRequesterModifierKt$focusRequester$$inlined$debugInspectorInfo$1(focusRequester) : InspectableValueKt.getNoInspectorInfo()));
    }
}
