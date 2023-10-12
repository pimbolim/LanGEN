package androidx.compose.foundation.interaction;

import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.runtime.MutableState;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Collect.kt */
public final class DragInteractionKt$collectIsDraggedAsState$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<Interaction> {
    final /* synthetic */ List $dragInteractions$inlined;
    final /* synthetic */ MutableState $isDragged$inlined;

    public DragInteractionKt$collectIsDraggedAsState$1$invokeSuspend$$inlined$collect$1(List list, MutableState mutableState) {
        this.$dragInteractions$inlined = list;
        this.$isDragged$inlined = mutableState;
    }

    public Object emit(Interaction interaction, Continuation<? super Unit> continuation) {
        Interaction interaction2 = interaction;
        if (interaction2 instanceof DragInteraction.Start) {
            this.$dragInteractions$inlined.add(interaction2);
        } else if (interaction2 instanceof DragInteraction.Stop) {
            this.$dragInteractions$inlined.remove(((DragInteraction.Stop) interaction2).getStart());
        } else if (interaction2 instanceof DragInteraction.Cancel) {
            this.$dragInteractions$inlined.remove(((DragInteraction.Cancel) interaction2).getStart());
        }
        this.$isDragged$inlined.setValue(Boxing.boxBoolean(!this.$dragInteractions$inlined.isEmpty()));
        return Unit.INSTANCE;
    }
}
