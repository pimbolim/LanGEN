package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Collect.kt */
public final class SwipeableState$performFling$$inlined$collect$1 implements FlowCollector<Map<Float, ? extends T>> {
    final /* synthetic */ float $velocity$inlined;
    final /* synthetic */ SwipeableState this$0;

    public SwipeableState$performFling$$inlined$collect$1(SwipeableState swipeableState, float f) {
        this.this$0 = swipeableState;
        this.$velocity$inlined = f;
    }

    public Object emit(Map<Float, ? extends T> map, Continuation<? super Unit> continuation) {
        Map map2 = map;
        Float access$getOffset = SwipeableKt.getOffset(map2, this.this$0.getCurrentValue());
        Intrinsics.checkNotNull(access$getOffset);
        float floatValue = access$getOffset.floatValue();
        Object obj = map2.get(Boxing.boxFloat(SwipeableKt.computeTarget(this.this$0.getOffset().getValue().floatValue(), floatValue, map2.keySet(), this.this$0.getThresholds$material_release(), this.$velocity$inlined, this.this$0.getVelocityThreshold$material_release())));
        if (obj == null || !((Boolean) this.this$0.getConfirmStateChange$material_release().invoke(obj)).booleanValue()) {
            SwipeableState swipeableState = this.this$0;
            Object access$animateInternalToOffset = swipeableState.animateInternalToOffset(floatValue, swipeableState.getAnimationSpec$material_release(), continuation);
            if (access$animateInternalToOffset == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return access$animateInternalToOffset;
            }
        } else {
            Object animateTo$default = SwipeableState.animateTo$default(this.this$0, obj, (AnimationSpec) null, continuation, 2, (Object) null);
            if (animateTo$default == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return animateTo$default;
            }
        }
        return Unit.INSTANCE;
    }
}
