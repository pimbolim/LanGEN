package androidx.compose.ui.focus;

import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\t\u001a\u00020\u0006*\u00020\u0006H\u0007\u001a\n\u0010\n\u001a\u00020\u0006*\u00020\u0006\u001a\u0014\u0010\n\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\t\u001a\u00020\u000bH\u0000\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"ModifierLocalHasFocusEventListener", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "", "getModifierLocalHasFocusEventListener", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "ResetFocusModifierLocals", "Landroidx/compose/ui/Modifier;", "getResetFocusModifierLocals", "()Landroidx/compose/ui/Modifier;", "focusModifier", "focusTarget", "Landroidx/compose/ui/focus/FocusModifier;", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FocusModifier.kt */
public final class FocusModifierKt {
    private static final ProvidableModifierLocal<Boolean> ModifierLocalHasFocusEventListener = ModifierLocalKt.modifierLocalOf(FocusModifierKt$ModifierLocalHasFocusEventListener$1.INSTANCE);
    private static final Modifier ResetFocusModifierLocals = Modifier.Companion.then(new FocusModifierKt$ResetFocusModifierLocals$1()).then(new FocusModifierKt$ResetFocusModifierLocals$2());

    public static final Modifier focusTarget(Modifier modifier, FocusModifier focusModifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(focusModifier, "focusModifier");
        return modifier.then(focusModifier).then(ResetFocusModifierLocals);
    }

    public static final ProvidableModifierLocal<Boolean> getModifierLocalHasFocusEventListener() {
        return ModifierLocalHasFocusEventListener;
    }

    public static final Modifier getResetFocusModifierLocals() {
        return ResetFocusModifierLocals;
    }

    public static final Modifier focusTarget(Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusModifierKt$focusTarget$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), FocusModifierKt$focusTarget$2.INSTANCE);
    }

    @Deprecated(message = "Replaced by focusTarget", replaceWith = @ReplaceWith(expression = "focusTarget()", imports = {"androidx.compose.ui.focus.focusTarget"}))
    public static final Modifier focusModifier(Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusModifierKt$focusModifier$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), FocusModifierKt$focusModifier$2.INSTANCE);
    }
}
