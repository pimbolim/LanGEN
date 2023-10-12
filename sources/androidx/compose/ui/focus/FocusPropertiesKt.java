package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.node.ModifiedFocusNode;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n\u001a\u0014\u0010\u000b\u001a\u00020\t*\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0000\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000e"}, d2 = {"ModifierLocalFocusProperties", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/ui/focus/FocusProperties;", "getModifierLocalFocusProperties", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "focusProperties", "Landroidx/compose/ui/Modifier;", "scope", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "setUpdatedProperties", "Landroidx/compose/ui/node/ModifiedFocusNode;", "properties", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: FocusProperties.kt */
public final class FocusPropertiesKt {
    private static final ProvidableModifierLocal<FocusProperties> ModifierLocalFocusProperties = ModifierLocalKt.modifierLocalOf(FocusPropertiesKt$ModifierLocalFocusProperties$1.INSTANCE);

    public static final ProvidableModifierLocal<FocusProperties> getModifierLocalFocusProperties() {
        return ModifierLocalFocusProperties;
    }

    public static final Modifier focusProperties(Modifier modifier, Function1<? super FocusProperties, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "scope");
        return modifier.then(new FocusPropertiesModifier(function1, InspectableValueKt.isDebugInspectorInfoEnabled() ? new FocusPropertiesKt$focusProperties$$inlined$debugInspectorInfo$1(function1) : InspectableValueKt.getNoInspectorInfo()));
    }

    public static final void setUpdatedProperties(ModifiedFocusNode modifiedFocusNode, FocusProperties focusProperties) {
        Intrinsics.checkNotNullParameter(modifiedFocusNode, "<this>");
        Intrinsics.checkNotNullParameter(focusProperties, "properties");
        if (focusProperties.getCanFocus()) {
            FocusTransactionsKt.activateNode(modifiedFocusNode);
        } else {
            FocusTransactionsKt.deactivateNode(modifiedFocusNode);
        }
    }
}
