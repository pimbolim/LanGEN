package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2", f = "DragGestureDetector.kt", i = {}, l = {757}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DragGestureDetector.kt */
final class DragGestureDetectorKt$awaitLongPressOrCancellation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<PointerInputChange> $currentDown;
    final /* synthetic */ Ref.ObjectRef<PointerInputChange> $longPress;
    final /* synthetic */ PointerInputScope $this_awaitLongPressOrCancellation;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragGestureDetectorKt$awaitLongPressOrCancellation$2(PointerInputScope pointerInputScope, Ref.ObjectRef<PointerInputChange> objectRef, Ref.ObjectRef<PointerInputChange> objectRef2, Continuation<? super DragGestureDetectorKt$awaitLongPressOrCancellation$2> continuation) {
        super(2, continuation);
        this.$this_awaitLongPressOrCancellation = pointerInputScope;
        this.$currentDown = objectRef;
        this.$longPress = objectRef2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DragGestureDetectorKt$awaitLongPressOrCancellation$2(this.$this_awaitLongPressOrCancellation, this.$currentDown, this.$longPress, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$awaitLongPressOrCancellation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2$1", f = "DragGestureDetector.kt", i = {0, 0, 1, 1, 1}, l = {760, 777}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "finished", "$this$awaitPointerEventScope", "event", "finished"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2$1  reason: invalid class name */
    /* compiled from: DragGestureDetector.kt */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(objectRef, objectRef2, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x006b  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0080  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x008c  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00ba  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00cf  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x00de  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x00f3  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0104  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x013a  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x007d A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x00b7 A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x00f0 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                r17 = this;
                r0 = r17
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 2
                r4 = 0
                r6 = 1
                if (r2 == 0) goto L_0x0039
                if (r2 == r6) goto L_0x002b
                if (r2 != r3) goto L_0x0023
                int r2 = r0.I$0
                java.lang.Object r7 = r0.L$1
                androidx.compose.ui.input.pointer.PointerEvent r7 = (androidx.compose.ui.input.pointer.PointerEvent) r7
                java.lang.Object r8 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
                kotlin.ResultKt.throwOnFailure(r18)
                r4 = r18
                r5 = r0
                goto L_0x00d1
            L_0x0023:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x002b:
                int r2 = r0.I$0
                java.lang.Object r7 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
                kotlin.ResultKt.throwOnFailure(r18)
                r9 = r18
                r8 = r7
                r7 = r0
                goto L_0x005e
            L_0x0039:
                kotlin.ResultKt.throwOnFailure(r18)
                java.lang.Object r2 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                r8 = r0
                r7 = r2
                r2 = 0
            L_0x0043:
                if (r2 != 0) goto L_0x0171
                androidx.compose.ui.input.pointer.PointerEventPass r9 = androidx.compose.ui.input.pointer.PointerEventPass.Main
                r10 = r8
                kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
                r8.L$0 = r7
                r8.L$1 = r4
                r8.I$0 = r2
                r8.label = r6
                java.lang.Object r9 = r7.awaitPointerEvent(r9, r10)
                if (r9 != r1) goto L_0x0059
                return r1
            L_0x0059:
                r16 = r8
                r8 = r7
                r7 = r16
            L_0x005e:
                androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.ui.input.pointer.PointerEvent) r9
                java.util.List r10 = r9.getChanges()
                int r11 = r10.size()
                r12 = 0
            L_0x0069:
                if (r12 >= r11) goto L_0x007d
                int r13 = r12 + 1
                java.lang.Object r12 = r10.get(r12)
                androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
                boolean r12 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r12)
                if (r12 != 0) goto L_0x007b
                r10 = 0
                goto L_0x007e
            L_0x007b:
                r12 = r13
                goto L_0x0069
            L_0x007d:
                r10 = 1
            L_0x007e:
                if (r10 == 0) goto L_0x0081
                r2 = 1
            L_0x0081:
                java.util.List r10 = r9.getChanges()
                int r11 = r10.size()
                r12 = 0
            L_0x008a:
                if (r12 >= r11) goto L_0x00b7
                int r13 = r12 + 1
                java.lang.Object r12 = r10.get(r12)
                androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
                androidx.compose.ui.input.pointer.ConsumedData r14 = r12.getConsumed()
                boolean r14 = r14.getDownChange()
                if (r14 != 0) goto L_0x00af
                long r14 = r8.m2896getSizeYbymL2g()
                long r4 = r8.m2895getExtendedTouchPaddingNHjbRc()
                boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.m2928isOutOfBoundsjwHxaWs(r12, r14, r4)
                if (r4 == 0) goto L_0x00ad
                goto L_0x00af
            L_0x00ad:
                r4 = 0
                goto L_0x00b0
            L_0x00af:
                r4 = 1
            L_0x00b0:
                if (r4 == 0) goto L_0x00b4
                r4 = 1
                goto L_0x00b8
            L_0x00b4:
                r12 = r13
                r4 = 0
                goto L_0x008a
            L_0x00b7:
                r4 = 0
            L_0x00b8:
                if (r4 == 0) goto L_0x00bb
                r2 = 1
            L_0x00bb:
                androidx.compose.ui.input.pointer.PointerEventPass r4 = androidx.compose.ui.input.pointer.PointerEventPass.Final
                r5 = r7
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r7.L$0 = r8
                r7.L$1 = r9
                r7.I$0 = r2
                r7.label = r3
                java.lang.Object r4 = r8.awaitPointerEvent(r4, r5)
                if (r4 != r1) goto L_0x00cf
                return r1
            L_0x00cf:
                r5 = r7
                r7 = r9
            L_0x00d1:
                androidx.compose.ui.input.pointer.PointerEvent r4 = (androidx.compose.ui.input.pointer.PointerEvent) r4
                java.util.List r4 = r4.getChanges()
                int r9 = r4.size()
                r10 = 0
            L_0x00dc:
                if (r10 >= r9) goto L_0x00f0
                int r11 = r10 + 1
                java.lang.Object r10 = r4.get(r10)
                androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
                boolean r10 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeConsumed(r10)
                if (r10 == 0) goto L_0x00ee
                r4 = 1
                goto L_0x00f1
            L_0x00ee:
                r10 = r11
                goto L_0x00dc
            L_0x00f0:
                r4 = 0
            L_0x00f1:
                if (r4 == 0) goto L_0x00f4
                r2 = 1
            L_0x00f4:
                kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r3
                T r4 = r4.element
                androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                long r9 = r4.m2977getIdJ3iCeTQ()
                boolean r4 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m260isPointerUpDmW0f2w(r7, r9)
                if (r4 != 0) goto L_0x013a
                kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r4
                java.util.List r7 = r7.getChanges()
                kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r9 = r3
                int r10 = r7.size()
                r11 = 0
            L_0x0111:
                if (r11 >= r10) goto L_0x0136
                int r12 = r11 + 1
                java.lang.Object r11 = r7.get(r11)
                r13 = r11
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                long r13 = r13.m2977getIdJ3iCeTQ()
                T r15 = r9.element
                androidx.compose.ui.input.pointer.PointerInputChange r15 = (androidx.compose.ui.input.pointer.PointerInputChange) r15
                r18 = r7
                long r6 = r15.m2977getIdJ3iCeTQ()
                boolean r6 = androidx.compose.ui.input.pointer.PointerId.m2966equalsimpl0(r13, r6)
                if (r6 == 0) goto L_0x0131
                goto L_0x0137
            L_0x0131:
                r7 = r18
                r11 = r12
                r6 = 1
                goto L_0x0111
            L_0x0136:
                r11 = 0
            L_0x0137:
                r4.element = r11
                goto L_0x0168
            L_0x013a:
                java.util.List r4 = r7.getChanges()
                int r6 = r4.size()
                r7 = 0
            L_0x0143:
                if (r7 >= r6) goto L_0x0157
                int r9 = r7 + 1
                java.lang.Object r7 = r4.get(r7)
                r10 = r7
                androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
                boolean r10 = r10.getPressed()
                if (r10 == 0) goto L_0x0155
                goto L_0x0158
            L_0x0155:
                r7 = r9
                goto L_0x0143
            L_0x0157:
                r7 = 0
            L_0x0158:
                androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
                if (r7 == 0) goto L_0x016e
                kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r3
                r4.element = r7
                kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r4 = r4
                kotlin.jvm.internal.Ref$ObjectRef<androidx.compose.ui.input.pointer.PointerInputChange> r6 = r3
                T r6 = r6.element
                r4.element = r6
            L_0x0168:
                r7 = r8
            L_0x0169:
                r4 = 0
                r6 = 1
                r8 = r5
                goto L_0x0043
            L_0x016e:
                r7 = r8
                r2 = 1
                goto L_0x0169
            L_0x0171:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = this.$this_awaitLongPressOrCancellation;
            final Ref.ObjectRef<PointerInputChange> objectRef = this.$currentDown;
            final Ref.ObjectRef<PointerInputChange> objectRef2 = this.$longPress;
            this.label = 1;
            if (pointerInputScope.awaitPointerEventScope(new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
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
