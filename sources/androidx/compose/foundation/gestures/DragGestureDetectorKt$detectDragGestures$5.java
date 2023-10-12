package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5", f = "DragGestureDetector.kt", i = {}, l = {227}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DragGestureDetector.kt */
final class DragGestureDetectorKt$detectDragGestures$5 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
    final /* synthetic */ Function0<Unit> $onDragCancel;
    final /* synthetic */ Function0<Unit> $onDragEnd;
    final /* synthetic */ Function1<Offset, Unit> $onDragStart;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragGestureDetectorKt$detectDragGestures$5(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super DragGestureDetectorKt$detectDragGestures$5> continuation) {
        super(2, continuation);
        this.$onDragStart = function1;
        this.$onDrag = function2;
        this.$onDragCancel = function0;
        this.$onDragEnd = function02;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$detectDragGestures$5 dragGestureDetectorKt$detectDragGestures$5 = new DragGestureDetectorKt$detectDragGestures$5(this.$onDragStart, this.$onDrag, this.$onDragCancel, this.$onDragEnd, continuation);
        dragGestureDetectorKt$detectDragGestures$5.L$0 = obj;
        return dragGestureDetectorKt$detectDragGestures$5;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectDragGestures$5) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$1", f = "DragGestureDetector.kt", i = {0, 1, 1, 1}, l = {228, 232, 244}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "down", "overSlop"}, s = {"L$0", "L$0", "L$1", "L$2"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$1  reason: invalid class name */
    /* compiled from: DragGestureDetector.kt */
    static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(function1, function2, function0, function02, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v18, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: androidx.compose.ui.input.pointer.AwaitPointerEventScope} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0086  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0094  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0096  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00d8  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00de  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                r13 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r13.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0038
                if (r1 == r4) goto L_0x0030
                if (r1 == r3) goto L_0x001f
                if (r1 != r2) goto L_0x0017
                kotlin.ResultKt.throwOnFailure(r14)
                r11 = r13
                goto L_0x00d0
            L_0x0017:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L_0x001f:
                java.lang.Object r1 = r13.L$2
                kotlin.jvm.internal.Ref$LongRef r1 = (kotlin.jvm.internal.Ref.LongRef) r1
                java.lang.Object r4 = r13.L$1
                androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                java.lang.Object r5 = r13.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                kotlin.ResultKt.throwOnFailure(r14)
                r11 = r13
                goto L_0x0089
            L_0x0030:
                java.lang.Object r1 = r13.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                kotlin.ResultKt.throwOnFailure(r14)
                goto L_0x004f
            L_0x0038:
                kotlin.ResultKt.throwOnFailure(r14)
                java.lang.Object r14 = r13.L$0
                r1 = r14
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                r14 = 0
                r5 = r13
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
                r13.L$0 = r1
                r13.label = r4
                java.lang.Object r14 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(r1, r14, r5)
                if (r14 != r0) goto L_0x004f
                return r0
            L_0x004f:
                androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
                kotlin.jvm.internal.Ref$LongRef r4 = new kotlin.jvm.internal.Ref$LongRef
                r4.<init>()
                androidx.compose.ui.geometry.Offset$Companion r5 = androidx.compose.ui.geometry.Offset.Companion
                long r5 = r5.m1369getZeroF1C5BW0()
                r4.element = r5
                r11 = r13
                r12 = r4
                r4 = r14
                r14 = r1
                r1 = r12
            L_0x0063:
                long r6 = r4.m2977getIdJ3iCeTQ()
                int r8 = r4.m2981getTypeT8wyACA()
                androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$1$1 r5 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$1$1
                r5.<init>(r1)
                r9 = r5
                kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
                r10 = r11
                kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
                r11.L$0 = r14
                r11.L$1 = r4
                r11.L$2 = r1
                r11.label = r3
                r5 = r14
                java.lang.Object r5 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m251awaitPointerSlopOrCancellationgDDlDlE(r5, r6, r8, r9, r10)
                if (r5 != r0) goto L_0x0086
                return r0
            L_0x0086:
                r12 = r5
                r5 = r14
                r14 = r12
            L_0x0089:
                androidx.compose.ui.input.pointer.PointerInputChange r14 = (androidx.compose.ui.input.pointer.PointerInputChange) r14
                if (r14 == 0) goto L_0x0096
                boolean r6 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeConsumed(r14)
                if (r6 == 0) goto L_0x0094
                goto L_0x0096
            L_0x0094:
                r14 = r5
                goto L_0x0063
            L_0x0096:
                if (r14 == 0) goto L_0x00e3
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r3 = r4
                long r6 = r14.m2978getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m1342boximpl(r6)
                r3.invoke(r4)
                kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r3 = r5
                long r6 = r1.element
                androidx.compose.ui.geometry.Offset r1 = androidx.compose.ui.geometry.Offset.m1342boximpl(r6)
                r3.invoke(r14, r1)
                long r3 = r14.m2977getIdJ3iCeTQ()
                androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$1$2 r14 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$1$2
                kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r1 = r5
                r14.<init>(r1)
                kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
                r1 = r11
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r6 = 0
                r11.L$0 = r6
                r11.L$1 = r6
                r11.L$2 = r6
                r11.label = r2
                java.lang.Object r14 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m258dragjO51t88(r5, r3, r14, r1)
                if (r14 != r0) goto L_0x00d0
                return r0
            L_0x00d0:
                java.lang.Boolean r14 = (java.lang.Boolean) r14
                boolean r14 = r14.booleanValue()
                if (r14 != 0) goto L_0x00de
                kotlin.jvm.functions.Function0<kotlin.Unit> r14 = r6
                r14.invoke()
                goto L_0x00e3
            L_0x00de:
                kotlin.jvm.functions.Function0<kotlin.Unit> r14 = r7
                r14.invoke()
            L_0x00e3:
                kotlin.Unit r14 = kotlin.Unit.INSTANCE
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final Function1<Offset, Unit> function1 = this.$onDragStart;
            final Function2<PointerInputChange, Offset, Unit> function2 = this.$onDrag;
            final Function0<Unit> function0 = this.$onDragCancel;
            final Function0<Unit> function02 = this.$onDragEnd;
            this.label = 1;
            if (((PointerInputScope) this.L$0).awaitPointerEventScope(new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
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
