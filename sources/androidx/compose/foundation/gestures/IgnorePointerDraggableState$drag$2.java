package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/DragScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.IgnorePointerDraggableState$drag$2", f = "Draggable.kt", i = {}, l = {472}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Draggable.kt */
final class IgnorePointerDraggableState$drag$2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PointerAwareDragScope, Continuation<? super Unit>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IgnorePointerDraggableState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IgnorePointerDraggableState$drag$2(IgnorePointerDraggableState ignorePointerDraggableState, Function2<? super PointerAwareDragScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super IgnorePointerDraggableState$drag$2> continuation) {
        super(2, continuation);
        this.this$0 = ignorePointerDraggableState;
        this.$block = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        IgnorePointerDraggableState$drag$2 ignorePointerDraggableState$drag$2 = new IgnorePointerDraggableState$drag$2(this.this$0, this.$block, continuation);
        ignorePointerDraggableState$drag$2.L$0 = obj;
        return ignorePointerDraggableState$drag$2;
    }

    public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
        return ((IgnorePointerDraggableState$drag$2) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.setLatestConsumptionScope((DragScope) this.L$0);
            Function2<PointerAwareDragScope, Continuation<? super Unit>, Object> function2 = this.$block;
            IgnorePointerDraggableState ignorePointerDraggableState = this.this$0;
            this.label = 1;
            if (function2.invoke(ignorePointerDraggableState, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
