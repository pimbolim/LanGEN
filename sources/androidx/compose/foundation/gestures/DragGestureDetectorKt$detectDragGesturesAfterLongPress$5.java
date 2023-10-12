package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5", f = "DragGestureDetector.kt", i = {0, 1}, l = {279, 283, 287}, m = "invokeSuspend", n = {"$this$forEachGesture", "$this$forEachGesture"}, s = {"L$0", "L$0"})
/* compiled from: DragGestureDetector.kt */
final class DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<PointerInputChange, Offset, Unit> $onDrag;
    final /* synthetic */ Function0<Unit> $onDragCancel;
    final /* synthetic */ Function0<Unit> $onDragEnd;
    final /* synthetic */ Function1<Offset, Unit> $onDragStart;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super DragGestureDetectorKt$detectDragGesturesAfterLongPress$5> continuation) {
        super(2, continuation);
        this.$onDragStart = function1;
        this.$onDragCancel = function0;
        this.$onDragEnd = function02;
        this.$onDrag = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DragGestureDetectorKt$detectDragGesturesAfterLongPress$5 dragGestureDetectorKt$detectDragGesturesAfterLongPress$5 = new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(this.$onDragStart, this.$onDragCancel, this.$onDragEnd, this.$onDrag, continuation);
        dragGestureDetectorKt$detectDragGesturesAfterLongPress$5.L$0 = obj;
        return dragGestureDetectorKt$detectDragGesturesAfterLongPress$5;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectDragGesturesAfterLongPress$5) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0066 A[Catch:{ CancellationException -> 0x0017 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 == r5) goto L_0x002a
            if (r1 == r4) goto L_0x0022
            if (r1 != r3) goto L_0x001a
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ CancellationException -> 0x0017 }
            goto L_0x0090
        L_0x0017:
            r12 = move-exception
            goto L_0x0093
        L_0x001a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0022:
            java.lang.Object r1 = r11.L$0
            androidx.compose.ui.input.pointer.PointerInputScope r1 = (androidx.compose.ui.input.pointer.PointerInputScope) r1
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ CancellationException -> 0x0017 }
            goto L_0x0061
        L_0x002a:
            java.lang.Object r1 = r11.L$0
            androidx.compose.ui.input.pointer.PointerInputScope r1 = (androidx.compose.ui.input.pointer.PointerInputScope) r1
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0051
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            androidx.compose.ui.input.pointer.PointerInputScope r12 = (androidx.compose.ui.input.pointer.PointerInputScope) r12
            androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$down$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$down$1
            r1.<init>(r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r6 = r11
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r11.L$0 = r12
            r11.label = r5
            java.lang.Object r1 = r12.awaitPointerEventScope(r1, r6)
            if (r1 != r0) goto L_0x004e
            return r0
        L_0x004e:
            r10 = r1
            r1 = r12
            r12 = r10
        L_0x0051:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            r5 = r11
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch:{ CancellationException -> 0x0017 }
            r11.L$0 = r1     // Catch:{ CancellationException -> 0x0017 }
            r11.label = r4     // Catch:{ CancellationException -> 0x0017 }
            java.lang.Object r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitLongPressOrCancellation(r1, r12, r5)     // Catch:{ CancellationException -> 0x0017 }
            if (r12 != r0) goto L_0x0061
            return r0
        L_0x0061:
            r5 = r12
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5     // Catch:{ CancellationException -> 0x0017 }
            if (r5 == 0) goto L_0x0090
            kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r12 = r11.$onDragStart     // Catch:{ CancellationException -> 0x0017 }
            long r6 = r5.m2978getPositionF1C5BW0()     // Catch:{ CancellationException -> 0x0017 }
            androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m1342boximpl(r6)     // Catch:{ CancellationException -> 0x0017 }
            r12.invoke(r4)     // Catch:{ CancellationException -> 0x0017 }
            androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1 r12 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5$1     // Catch:{ CancellationException -> 0x0017 }
            kotlin.jvm.functions.Function0<kotlin.Unit> r6 = r11.$onDragEnd     // Catch:{ CancellationException -> 0x0017 }
            kotlin.jvm.functions.Function0<kotlin.Unit> r7 = r11.$onDragCancel     // Catch:{ CancellationException -> 0x0017 }
            kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r8 = r11.$onDrag     // Catch:{ CancellationException -> 0x0017 }
            r9 = 0
            r4 = r12
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ CancellationException -> 0x0017 }
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12     // Catch:{ CancellationException -> 0x0017 }
            r4 = r11
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4     // Catch:{ CancellationException -> 0x0017 }
            r11.L$0 = r2     // Catch:{ CancellationException -> 0x0017 }
            r11.label = r3     // Catch:{ CancellationException -> 0x0017 }
            java.lang.Object r12 = r1.awaitPointerEventScope(r12, r4)     // Catch:{ CancellationException -> 0x0017 }
            if (r12 != r0) goto L_0x0090
            return r0
        L_0x0090:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x0093:
            kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r11.$onDragCancel
            r0.invoke()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGesturesAfterLongPress$5.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
