package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Effects.kt */
public final class FocusableKt$focusable$2$1$invoke$$inlined$onDispose$1 implements DisposableEffectResult {
    final /* synthetic */ MutableState $focusedInteraction$inlined;
    final /* synthetic */ MutableInteractionSource $interactionSource$inlined;

    public FocusableKt$focusable$2$1$invoke$$inlined$onDispose$1(MutableState mutableState, MutableInteractionSource mutableInteractionSource) {
        this.$focusedInteraction$inlined = mutableState;
        this.$interactionSource$inlined = mutableInteractionSource;
    }

    public void dispose() {
        FocusInteraction.Focus focus = (FocusInteraction.Focus) this.$focusedInteraction$inlined.getValue();
        if (focus != null) {
            FocusInteraction.Unfocus unfocus = new FocusInteraction.Unfocus(focus);
            MutableInteractionSource mutableInteractionSource = this.$interactionSource$inlined;
            if (mutableInteractionSource != null) {
                mutableInteractionSource.tryEmit(unfocus);
            }
            this.$focusedInteraction$inlined.setValue(null);
        }
    }
}
