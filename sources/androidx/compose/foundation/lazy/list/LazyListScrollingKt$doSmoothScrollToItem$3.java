package androidx.compose.foundation.lazy.list;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.LazyListState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.list.LazyListScrollingKt$doSmoothScrollToItem$3", f = "LazyListScrolling.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {116, 207}, m = "invokeSuspend", n = {"$this$scroll", "loop", "anim", "loops", "targetDistancePx", "boundDistancePx", "forward"}, s = {"L$0", "L$1", "L$2", "L$3", "F$0", "F$1", "I$0"})
/* compiled from: LazyListScrolling.kt */
final class LazyListScrollingKt$doSmoothScrollToItem$3 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ int $scrollOffset;
    final /* synthetic */ LazyListState $this_doSmoothScrollToItem;
    float F$0;
    float F$1;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyListScrollingKt$doSmoothScrollToItem$3(LazyListState lazyListState, int i, int i2, Continuation<? super LazyListScrollingKt$doSmoothScrollToItem$3> continuation) {
        super(2, continuation);
        this.$this_doSmoothScrollToItem = lazyListState;
        this.$index = i;
        this.$scrollOffset = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LazyListScrollingKt$doSmoothScrollToItem$3 lazyListScrollingKt$doSmoothScrollToItem$3 = new LazyListScrollingKt$doSmoothScrollToItem$3(this.$this_doSmoothScrollToItem, this.$index, this.$scrollOffset, continuation);
        lazyListScrollingKt$doSmoothScrollToItem$3.L$0 = obj;
        return lazyListScrollingKt$doSmoothScrollToItem$3;
    }

    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return ((LazyListScrollingKt$doSmoothScrollToItem$3) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: androidx.compose.foundation.gestures.ScrollScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x010b A[Catch:{ ItemFoundInScroll -> 0x01d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x014e A[Catch:{ ItemFoundInScroll -> 0x01d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0150 A[Catch:{ ItemFoundInScroll -> 0x01d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0153 A[Catch:{ ItemFoundInScroll -> 0x01d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0156 A[Catch:{ ItemFoundInScroll -> 0x01d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x015c A[Catch:{ ItemFoundInScroll -> 0x01d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x015f A[Catch:{ ItemFoundInScroll -> 0x01d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0222  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0249 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r42) {
        /*
            r41 = this;
            r1 = r41
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r1.label
            r3 = 0
            r4 = 2
            r6 = 1
            if (r0 == 0) goto L_0x0047
            if (r0 == r6) goto L_0x001f
            if (r0 != r4) goto L_0x0017
            kotlin.ResultKt.throwOnFailure(r42)
            r9 = r1
            goto L_0x024a
        L_0x0017:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x001f:
            int r0 = r1.I$0
            float r7 = r1.F$1
            float r8 = r1.F$0
            java.lang.Object r9 = r1.L$3
            kotlin.jvm.internal.Ref$IntRef r9 = (kotlin.jvm.internal.Ref.IntRef) r9
            java.lang.Object r10 = r1.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r1.L$1
            kotlin.jvm.internal.Ref$BooleanRef r11 = (kotlin.jvm.internal.Ref.BooleanRef) r11
            java.lang.Object r12 = r1.L$0
            androidx.compose.foundation.gestures.ScrollScope r12 = (androidx.compose.foundation.gestures.ScrollScope) r12
            kotlin.ResultKt.throwOnFailure(r42)     // Catch:{ ItemFoundInScroll -> 0x0043 }
            r15 = r7
            r14 = r8
            r13 = r9
            r9 = r1
            r40 = r12
            r12 = r10
            r10 = r40
            goto L_0x01ba
        L_0x0043:
            r0 = move-exception
            r9 = r1
            goto L_0x01e4
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r42)
            java.lang.Object r0 = r1.L$0
            r12 = r0
            androidx.compose.foundation.gestures.ScrollScope r12 = (androidx.compose.foundation.gestures.ScrollScope) r12
            androidx.compose.foundation.lazy.LazyListState r0 = r1.$this_doSmoothScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            androidx.compose.ui.unit.Density r0 = r0.getDensity$foundation_release()     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            float r7 = androidx.compose.foundation.lazy.list.LazyListScrollingKt.TargetDistance     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            float r0 = r0.m3828toPx0680j_4(r7)     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            androidx.compose.foundation.lazy.LazyListState r7 = r1.$this_doSmoothScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            androidx.compose.ui.unit.Density r7 = r7.getDensity$foundation_release()     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            float r8 = androidx.compose.foundation.lazy.list.LazyListScrollingKt.BoundDistance     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            float r7 = r7.m3828toPx0680j_4(r8)     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            kotlin.jvm.internal.Ref$BooleanRef r8 = new kotlin.jvm.internal.Ref$BooleanRef     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            r8.<init>()     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            r8.element = r6     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            kotlin.jvm.internal.Ref$ObjectRef r9 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            r9.<init>()     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            r20 = 30
            r21 = 0
            androidx.compose.animation.core.AnimationState r10 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r13, r14, r15, r17, r19, r20, r21)     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            r9.element = r10     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            androidx.compose.foundation.lazy.LazyListState r10 = r1.$this_doSmoothScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            int r11 = r1.$index     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            androidx.compose.foundation.lazy.LazyListItemInfo r10 = androidx.compose.foundation.lazy.list.LazyListScrollingKt.doSmoothScrollToItem$getTargetItem(r10, r11)     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            if (r10 != 0) goto L_0x01d7
            int r10 = r1.$index     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            androidx.compose.foundation.lazy.LazyListState r11 = r1.$this_doSmoothScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            int r11 = r11.getFirstVisibleItemIndex()     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            if (r10 <= r11) goto L_0x009f
            r10 = 1
            goto L_0x00a0
        L_0x009f:
            r10 = 0
        L_0x00a0:
            kotlin.jvm.internal.Ref$IntRef r11 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            r11.<init>()     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            r11.element = r6     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            r14 = r0
            r15 = r7
            r0 = r10
            r13 = r11
            r10 = r12
            r11 = r8
            r12 = r9
            r9 = r1
        L_0x00af:
            boolean r7 = r11.element     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            if (r7 == 0) goto L_0x0253
            androidx.compose.foundation.lazy.LazyListState r7 = r9.$this_doSmoothScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            androidx.compose.foundation.lazy.LazyListLayoutInfo r7 = r7.getLayoutInfo()     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            int r7 = r7.getTotalItemsCount()     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            if (r7 <= 0) goto L_0x0253
            androidx.compose.foundation.lazy.LazyListState r7 = r9.$this_doSmoothScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            androidx.compose.foundation.lazy.LazyListLayoutInfo r7 = r7.getLayoutInfo()     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            java.util.List r7 = r7.getVisibleItemsInfo()     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            int r8 = r7.size()     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            r5 = 0
            r16 = 0
        L_0x00d0:
            if (r5 >= r8) goto L_0x00e3
            int r17 = r5 + 1
            java.lang.Object r5 = r7.get(r5)     // Catch:{ ItemFoundInScroll -> 0x01c7 }
            androidx.compose.foundation.lazy.LazyListItemInfo r5 = (androidx.compose.foundation.lazy.LazyListItemInfo) r5     // Catch:{ ItemFoundInScroll -> 0x01c7 }
            int r5 = r5.getSize()     // Catch:{ ItemFoundInScroll -> 0x01c7 }
            int r16 = r16 + r5
            r5 = r17
            goto L_0x00d0
        L_0x00e3:
            int r5 = r7.size()     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            int r16 = r16 / r5
            int r5 = r9.$index     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            androidx.compose.foundation.lazy.LazyListState r7 = r9.$this_doSmoothScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            int r7 = r7.getFirstVisibleItemIndex()     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            int r5 = r5 - r7
            int r5 = r5 * r16
            float r5 = (float) r5     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            int r7 = r9.$scrollOffset     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            float r7 = (float) r7     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            float r5 = r5 + r7
            androidx.compose.foundation.lazy.LazyListState r7 = r9.$this_doSmoothScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            int r7 = r7.getFirstVisibleItemScrollOffset()     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            float r7 = (float) r7     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            float r5 = r5 - r7
            float r7 = java.lang.Math.abs(r5)     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            int r7 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r7 >= 0) goto L_0x010b
        L_0x0109:
            r8 = r5
            goto L_0x0111
        L_0x010b:
            if (r0 == 0) goto L_0x010f
            r8 = r14
            goto L_0x0111
        L_0x010f:
            float r5 = -r14
            goto L_0x0109
        L_0x0111:
            T r5 = r12.element     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            r20 = r5
            androidx.compose.animation.core.AnimationState r20 = (androidx.compose.animation.core.AnimationState) r20     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            r21 = 0
            r22 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r28 = 30
            r29 = 0
            androidx.compose.animation.core.AnimationState r5 = androidx.compose.animation.core.AnimationStateKt.copy$default((androidx.compose.animation.core.AnimationState) r20, (float) r21, (float) r22, (long) r23, (long) r25, (boolean) r27, (int) r28, (java.lang.Object) r29)     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            r12.element = r5     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            kotlin.jvm.internal.Ref$FloatRef r5 = new kotlin.jvm.internal.Ref$FloatRef     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            r5.<init>()     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            T r7 = r12.element     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            r20 = r7
            androidx.compose.animation.core.AnimationState r20 = (androidx.compose.animation.core.AnimationState) r20     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            java.lang.Float r21 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r8)     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            r22 = 0
            T r7 = r12.element     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            androidx.compose.animation.core.AnimationState r7 = (androidx.compose.animation.core.AnimationState) r7     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            java.lang.Object r7 = r7.getVelocity()     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            java.lang.Number r7 = (java.lang.Number) r7     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            float r7 = r7.floatValue()     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            int r7 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x0150
            r7 = 1
            goto L_0x0151
        L_0x0150:
            r7 = 0
        L_0x0151:
            if (r7 != 0) goto L_0x0156
            r23 = 1
            goto L_0x0158
        L_0x0156:
            r23 = 0
        L_0x0158:
            androidx.compose.foundation.lazy.list.LazyListScrollingKt$doSmoothScrollToItem$3$2 r24 = new androidx.compose.foundation.lazy.list.LazyListScrollingKt$doSmoothScrollToItem$3$2     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            if (r0 == 0) goto L_0x015f
            r16 = 1
            goto L_0x0161
        L_0x015f:
            r16 = 0
        L_0x0161:
            int r7 = r9.$index     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            androidx.compose.foundation.lazy.LazyListState r4 = r9.$this_doSmoothScrollToItem     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            int r3 = r9.$scrollOffset     // Catch:{ ItemFoundInScroll -> 0x01d1 }
            r17 = r7
            r7 = r24
            r6 = r9
            r9 = r5
            r5 = r10
            r42 = r11
            r30 = r12
            r12 = r16
            r31 = r13
            r13 = r15
            r1 = r14
            r14 = r31
            r32 = r2
            r2 = r15
            r15 = r17
            r16 = r4
            r17 = r3
            r18 = r30
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ ItemFoundInScroll -> 0x01ca }
            kotlin.jvm.functions.Function1 r24 = (kotlin.jvm.functions.Function1) r24     // Catch:{ ItemFoundInScroll -> 0x01ca }
            r25 = r6
            kotlin.coroutines.Continuation r25 = (kotlin.coroutines.Continuation) r25     // Catch:{ ItemFoundInScroll -> 0x01ca }
            r26 = 2
            r27 = 0
            r6.L$0 = r5     // Catch:{ ItemFoundInScroll -> 0x01ca }
            r8 = r42
            r6.L$1 = r8     // Catch:{ ItemFoundInScroll -> 0x01ca }
            r9 = r30
            r6.L$2 = r9     // Catch:{ ItemFoundInScroll -> 0x01ca }
            r11 = r31
            r6.L$3 = r11     // Catch:{ ItemFoundInScroll -> 0x01ca }
            r6.F$0 = r1     // Catch:{ ItemFoundInScroll -> 0x01ca }
            r6.F$1 = r2     // Catch:{ ItemFoundInScroll -> 0x01ca }
            r6.I$0 = r0     // Catch:{ ItemFoundInScroll -> 0x01ca }
            r3 = 1
            r6.label = r3     // Catch:{ ItemFoundInScroll -> 0x01ca }
            java.lang.Object r3 = androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r20, r21, r22, r23, r24, r25, r26, r27)     // Catch:{ ItemFoundInScroll -> 0x01ca }
            r4 = r32
            if (r3 != r4) goto L_0x01b2
            return r4
        L_0x01b2:
            r14 = r1
            r15 = r2
            r2 = r4
            r10 = r5
            r12 = r9
            r13 = r11
            r9 = r6
            r11 = r8
        L_0x01ba:
            int r1 = r13.element     // Catch:{ ItemFoundInScroll -> 0x01c7 }
            r3 = 1
            int r1 = r1 + r3
            r13.element = r1     // Catch:{ ItemFoundInScroll -> 0x01c7 }
            r1 = r41
            r3 = 0
            r4 = 2
            r6 = 1
            goto L_0x00af
        L_0x01c7:
            r0 = move-exception
            r12 = r10
            goto L_0x01e4
        L_0x01ca:
            r0 = move-exception
            r4 = r32
            r2 = r4
            r12 = r5
            r9 = r6
            goto L_0x01e4
        L_0x01d1:
            r0 = move-exception
            r4 = r2
            r6 = r9
            r5 = r10
            r12 = r5
            goto L_0x01e4
        L_0x01d7:
            androidx.compose.foundation.lazy.list.ItemFoundInScroll r0 = new androidx.compose.foundation.lazy.list.ItemFoundInScroll     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            T r1 = r9.element     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            androidx.compose.animation.core.AnimationState r1 = (androidx.compose.animation.core.AnimationState) r1     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            r0.<init>(r10, r1)     // Catch:{ ItemFoundInScroll -> 0x01e1 }
            throw r0     // Catch:{ ItemFoundInScroll -> 0x01e1 }
        L_0x01e1:
            r0 = move-exception
            r9 = r41
        L_0x01e4:
            androidx.compose.animation.core.AnimationState r30 = r0.getPreviousAnimation()
            r31 = 0
            r32 = 0
            r33 = 0
            r35 = 0
            r37 = 0
            r38 = 30
            r39 = 0
            androidx.compose.animation.core.AnimationState r20 = androidx.compose.animation.core.AnimationStateKt.copy$default((androidx.compose.animation.core.AnimationState) r30, (float) r31, (float) r32, (long) r33, (long) r35, (boolean) r37, (int) r38, (java.lang.Object) r39)
            androidx.compose.foundation.lazy.LazyListItemInfo r0 = r0.getItem()
            int r0 = r0.getOffset()
            int r1 = r9.$scrollOffset
            int r0 = r0 + r1
            float r0 = (float) r0
            kotlin.jvm.internal.Ref$FloatRef r1 = new kotlin.jvm.internal.Ref$FloatRef
            r1.<init>()
            java.lang.Float r21 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r0)
            r22 = 0
            java.lang.Object r3 = r20.getVelocity()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            r4 = 0
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x0222
            r5 = 1
            goto L_0x0223
        L_0x0222:
            r5 = 0
        L_0x0223:
            r3 = 1
            r23 = r5 ^ 1
            androidx.compose.foundation.lazy.list.LazyListScrollingKt$doSmoothScrollToItem$3$4 r3 = new androidx.compose.foundation.lazy.list.LazyListScrollingKt$doSmoothScrollToItem$3$4
            r3.<init>(r0, r1, r12)
            r24 = r3
            kotlin.jvm.functions.Function1 r24 = (kotlin.jvm.functions.Function1) r24
            r25 = r9
            kotlin.coroutines.Continuation r25 = (kotlin.coroutines.Continuation) r25
            r26 = 2
            r27 = 0
            r0 = 0
            r9.L$0 = r0
            r9.L$1 = r0
            r9.L$2 = r0
            r9.L$3 = r0
            r1 = 2
            r9.label = r1
            java.lang.Object r0 = androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r20, r21, r22, r23, r24, r25, r26, r27)
            if (r0 != r2) goto L_0x024a
            return r2
        L_0x024a:
            androidx.compose.foundation.lazy.LazyListState r0 = r9.$this_doSmoothScrollToItem
            int r1 = r9.$index
            int r2 = r9.$scrollOffset
            r0.snapToItemIndexInternal$foundation_release(r1, r2)
        L_0x0253:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.list.LazyListScrollingKt$doSmoothScrollToItem$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final boolean invokeSuspend$isOvershot(boolean z, LazyListState lazyListState, int i, int i2) {
        if (z) {
            if (lazyListState.getFirstVisibleItemIndex() <= i && (lazyListState.getFirstVisibleItemIndex() != i || lazyListState.getFirstVisibleItemScrollOffset() <= i2)) {
                return false;
            }
        } else if (lazyListState.getFirstVisibleItemIndex() >= i && (lazyListState.getFirstVisibleItemIndex() != i || lazyListState.getFirstVisibleItemScrollOffset() >= i2)) {
            return false;
        }
        return true;
    }
}
