package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "event", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Draggable.kt */
final class DraggableKt$awaitDrag$dragTick$1 extends Lambda implements Function1<PointerInputChange, Unit> {
    final /* synthetic */ SendChannel<DragEvent> $channel;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ boolean $reverseDirection;
    final /* synthetic */ VelocityTracker $velocityTracker;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DraggableKt$awaitDrag$dragTick$1(VelocityTracker velocityTracker, Orientation orientation, SendChannel<? super DragEvent> sendChannel, boolean z) {
        super(1);
        this.$velocityTracker = velocityTracker;
        this.$orientation = orientation;
        this.$channel = sendChannel;
        this.$reverseDirection = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PointerInputChange) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "event");
        VelocityTrackerKt.addPointerInputChange(this.$velocityTracker, pointerInputChange);
        float r0 = DraggableKt.m270toFloat3MmeM6k(PointerEventKt.positionChange(pointerInputChange), this.$orientation);
        PointerEventKt.consumePositionChange(pointerInputChange);
        SendChannel<DragEvent> sendChannel = this.$channel;
        if (this.$reverseDirection) {
            r0 *= (float) -1;
        }
        sendChannel.m6176trySendJP2dKIU(new DragEvent.DragDelta(r0, pointerInputChange.m2978getPositionF1C5BW0(), (DefaultConstructorMarker) null));
    }
}
