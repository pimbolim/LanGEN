package androidx.compose.foundation.selection;

import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Toggleable.kt */
final class ToggleableKt$toggleableImpl$1$semantics$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ Function0<Unit> $onClick;
    final /* synthetic */ Role $role;
    final /* synthetic */ ToggleableState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ToggleableKt$toggleableImpl$1$semantics$1(Role role, ToggleableState toggleableState, boolean z, Function0<Unit> function0) {
        super(1);
        this.$role = role;
        this.$state = toggleableState;
        this.$enabled = z;
        this.$onClick = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        Role role = this.$role;
        if (role != null) {
            SemanticsPropertiesKt.m3490setRolekuIjeqM(semanticsPropertyReceiver, role.m3476unboximpl());
        }
        SemanticsPropertiesKt.setToggleableState(semanticsPropertyReceiver, this.$state);
        final Function0<Unit> function0 = this.$onClick;
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() {
            public final Boolean invoke() {
                function0.invoke();
                return true;
            }
        }, 1, (Object) null);
        if (!this.$enabled) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
    }
}
