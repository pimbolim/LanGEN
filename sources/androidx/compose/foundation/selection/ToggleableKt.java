package androidx.compose.foundation.selection;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
import com.braintreepayments.api.models.PostalAddressParser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aY\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u000e\u001aG\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u000f\u001aS\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0015\u001aS\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0017\u001aA\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0002\b\u0018\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0019"}, d2 = {"toggleable", "Landroidx/compose/ui/Modifier;", "value", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "role", "Landroidx/compose/ui/semantics/Role;", "onValueChange", "Lkotlin/Function1;", "", "toggleable-O2vRcR0", "toggleable-XHw0xAI", "toggleableImpl", "state", "Landroidx/compose/ui/state/ToggleableState;", "onClick", "Lkotlin/Function0;", "toggleableImpl-3WzHGRc", "triStateToggleable", "triStateToggleable-O2vRcR0", "triStateToggleable-XHw0xAI", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Toggleable.kt */
public final class ToggleableKt {
    /* renamed from: toggleable-XHw0xAI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m584toggleableXHw0xAI$default(Modifier modifier, boolean z, boolean z2, Role role, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m583toggleableXHw0xAI(modifier, z, z2, role, function1);
    }

    /* renamed from: toggleable-O2vRcR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m582toggleableO2vRcR0$default(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z2, Role role, Function1 function1, int i, Object obj) {
        boolean z3 = (i & 8) != 0 ? true : z2;
        if ((i & 16) != 0) {
            role = null;
        }
        return m581toggleableO2vRcR0(modifier, z, mutableInteractionSource, indication, z3, role, function1);
    }

    /* renamed from: triStateToggleable-XHw0xAI$default  reason: not valid java name */
    public static /* synthetic */ Modifier m590triStateToggleableXHw0xAI$default(Modifier modifier, ToggleableState toggleableState, boolean z, Role role, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m589triStateToggleableXHw0xAI(modifier, toggleableState, z, role, function0);
    }

    /* renamed from: triStateToggleable-O2vRcR0$default  reason: not valid java name */
    public static /* synthetic */ Modifier m588triStateToggleableO2vRcR0$default(Modifier modifier, ToggleableState toggleableState, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, Role role, Function0 function0, int i, Object obj) {
        boolean z2 = (i & 8) != 0 ? true : z;
        if ((i & 16) != 0) {
            role = null;
        }
        return m587triStateToggleableO2vRcR0(modifier, toggleableState, mutableInteractionSource, indication, z2, role, function0);
    }

    /* renamed from: toggleableImpl-3WzHGRc$default  reason: not valid java name */
    static /* synthetic */ Modifier m586toggleableImpl3WzHGRc$default(Modifier modifier, ToggleableState toggleableState, boolean z, Role role, MutableInteractionSource mutableInteractionSource, Indication indication, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            role = null;
        }
        return m585toggleableImpl3WzHGRc(modifier, toggleableState, z, role, mutableInteractionSource, indication, function0);
    }

    /* access modifiers changed from: private */
    /* renamed from: toggleableImpl-3WzHGRc  reason: not valid java name */
    public static final Modifier m585toggleableImpl3WzHGRc(Modifier modifier, ToggleableState toggleableState, boolean z, Role role, MutableInteractionSource mutableInteractionSource, Indication indication, Function0<Unit> function0) {
        return ComposedModifierKt.composed$default(modifier, (Function1) null, new ToggleableKt$toggleableImpl$1(function0, z, mutableInteractionSource, indication, role, toggleableState), 1, (Object) null);
    }

    /* renamed from: toggleable-XHw0xAI  reason: not valid java name */
    public static final Modifier m583toggleableXHw0xAI(Modifier modifier, boolean z, boolean z2, Role role, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "$this$toggleable");
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$toggleableXHw0xAI$$inlined$debugInspectorInfo$1(z, z2, role, function1) : InspectableValueKt.getNoInspectorInfo(), new ToggleableKt$toggleable$2(z, z2, role, function1));
    }

    /* renamed from: toggleable-O2vRcR0  reason: not valid java name */
    public static final Modifier m581toggleableO2vRcR0(Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z2, Role role, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(modifier, "$this$toggleable");
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        return InspectableValueKt.inspectableWrapper(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$toggleableO2vRcR0$$inlined$debugInspectorInfo$1(z, mutableInteractionSource, indication, z2, role, function1) : InspectableValueKt.getNoInspectorInfo(), m585toggleableImpl3WzHGRc(Modifier.Companion, ToggleableStateKt.ToggleableState(z), z2, role, mutableInteractionSource, indication, new ToggleableKt$toggleable$4$1(function1, z)));
    }

    /* renamed from: triStateToggleable-XHw0xAI  reason: not valid java name */
    public static final Modifier m589triStateToggleableXHw0xAI(Modifier modifier, ToggleableState toggleableState, boolean z, Role role, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(modifier, "$this$triStateToggleable");
        Intrinsics.checkNotNullParameter(toggleableState, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(function0, "onClick");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$triStateToggleableXHw0xAI$$inlined$debugInspectorInfo$1(toggleableState, z, role, function0) : InspectableValueKt.getNoInspectorInfo(), new ToggleableKt$triStateToggleable$2(toggleableState, z, role, function0));
    }

    /* renamed from: triStateToggleable-O2vRcR0  reason: not valid java name */
    public static final Modifier m587triStateToggleableO2vRcR0(Modifier modifier, ToggleableState toggleableState, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z, Role role, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(modifier, "$this$triStateToggleable");
        Intrinsics.checkNotNullParameter(toggleableState, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        return InspectableValueKt.inspectableWrapper(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ToggleableKt$triStateToggleableO2vRcR0$$inlined$debugInspectorInfo$1(toggleableState, z, role, mutableInteractionSource, indication, function0) : InspectableValueKt.getNoInspectorInfo(), m585toggleableImpl3WzHGRc(Modifier.Companion, toggleableState, z, role, mutableInteractionSource, indication, function0));
    }
}
