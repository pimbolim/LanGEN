package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Collect.kt */
public final class DefaultButtonElevation$elevation$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<Interaction> {
    final /* synthetic */ SnapshotStateList $interactions$inlined;

    public DefaultButtonElevation$elevation$1$invokeSuspend$$inlined$collect$1(SnapshotStateList snapshotStateList) {
        this.$interactions$inlined = snapshotStateList;
    }

    public Object emit(Interaction interaction, Continuation<? super Unit> continuation) {
        Interaction interaction2 = interaction;
        if (interaction2 instanceof HoverInteraction.Enter) {
            this.$interactions$inlined.add(interaction2);
        } else if (interaction2 instanceof HoverInteraction.Exit) {
            this.$interactions$inlined.remove((Object) ((HoverInteraction.Exit) interaction2).getEnter());
        } else if (interaction2 instanceof FocusInteraction.Focus) {
            this.$interactions$inlined.add(interaction2);
        } else if (interaction2 instanceof FocusInteraction.Unfocus) {
            this.$interactions$inlined.remove((Object) ((FocusInteraction.Unfocus) interaction2).getFocus());
        } else if (interaction2 instanceof PressInteraction.Press) {
            this.$interactions$inlined.add(interaction2);
        } else if (interaction2 instanceof PressInteraction.Release) {
            this.$interactions$inlined.remove((Object) ((PressInteraction.Release) interaction2).getPress());
        } else if (interaction2 instanceof PressInteraction.Cancel) {
            this.$interactions$inlined.remove((Object) ((PressInteraction.Cancel) interaction2).getPress());
        }
        return Unit.INSTANCE;
    }
}
