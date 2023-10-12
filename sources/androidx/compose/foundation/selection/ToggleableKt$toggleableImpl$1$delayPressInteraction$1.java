package androidx.compose.foundation.selection;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Toggleable.kt */
final class ToggleableKt$toggleableImpl$1$delayPressInteraction$1 extends Lambda implements Function0<Boolean> {
    final /* synthetic */ Function0<Boolean> $isRootInScrollableContainer;
    final /* synthetic */ MutableState<Boolean> $isToggleableInScrollableContainer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ToggleableKt$toggleableImpl$1$delayPressInteraction$1(MutableState<Boolean> mutableState, Function0<Boolean> function0) {
        super(0);
        this.$isToggleableInScrollableContainer = mutableState;
        this.$isRootInScrollableContainer = function0;
    }

    public final Boolean invoke() {
        return Boolean.valueOf(this.$isToggleableInScrollableContainer.getValue().booleanValue() || this.$isRootInScrollableContainer.invoke().booleanValue());
    }
}
