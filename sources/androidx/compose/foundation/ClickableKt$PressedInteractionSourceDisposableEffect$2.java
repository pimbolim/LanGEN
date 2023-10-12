package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Clickable.kt */
final class ClickableKt$PressedInteractionSourceDisposableEffect$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableKt$PressedInteractionSourceDisposableEffect$2(MutableInteractionSource mutableInteractionSource, MutableState<PressInteraction.Press> mutableState, int i) {
        super(2);
        this.$interactionSource = mutableInteractionSource;
        this.$pressedInteraction = mutableState;
        this.$$changed = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ClickableKt.PressedInteractionSourceDisposableEffect(this.$interactionSource, this.$pressedInteraction, composer, this.$$changed | 1);
    }
}
