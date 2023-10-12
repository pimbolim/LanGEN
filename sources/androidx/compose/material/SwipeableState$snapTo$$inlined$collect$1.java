package androidx.compose.material;

import java.util.Map;
import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Collect.kt */
public final class SwipeableState$snapTo$$inlined$collect$1 implements FlowCollector<Map<Float, ? extends T>> {
    final /* synthetic */ Object $targetValue$inlined;
    final /* synthetic */ SwipeableState this$0;

    public SwipeableState$snapTo$$inlined$collect$1(Object obj, SwipeableState swipeableState) {
        this.$targetValue$inlined = obj;
        this.this$0 = swipeableState;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object emit(java.util.Map<java.lang.Float, ? extends T> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.compose.material.SwipeableState$snapTo$$inlined$collect$1.AnonymousClass1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            androidx.compose.material.SwipeableState$snapTo$$inlined$collect$1$1 r0 = (androidx.compose.material.SwipeableState$snapTo$$inlined$collect$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            androidx.compose.material.SwipeableState$snapTo$$inlined$collect$1$1 r0 = new androidx.compose.material.SwipeableState$snapTo$$inlined$collect$1$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            androidx.compose.material.SwipeableState$snapTo$$inlined$collect$1 r5 = (androidx.compose.material.SwipeableState$snapTo$$inlined$collect$1) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0058
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r0
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r6 = r4.$targetValue$inlined
            java.lang.Float r5 = androidx.compose.material.SwipeableKt.getOffset(r5, r6)
            if (r5 == 0) goto L_0x0062
            androidx.compose.material.SwipeableState r6 = r4.this$0
            float r5 = r5.floatValue()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r6.snapInternalToOffset(r5, r0)
            if (r5 != r1) goto L_0x0057
            return r1
        L_0x0057:
            r5 = r4
        L_0x0058:
            androidx.compose.material.SwipeableState r6 = r5.this$0
            java.lang.Object r5 = r5.$targetValue$inlined
            r6.setCurrentValue(r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0062:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "The target value must have an associated anchor."
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableState$snapTo$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
