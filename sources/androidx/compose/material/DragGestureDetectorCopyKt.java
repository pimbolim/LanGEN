package androidx.compose.material;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ag\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f26\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00130\u000eH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a]\u0010\u0016\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u000e2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00050\u0018HHø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001a!\u0010\u001c\u001a\u00020\u001d*\u00020\u001e2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u001a!\u0010!\u001a\u00020\u0005*\u00020\"2\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006%"}, d2 = {"defaultTouchSlop", "Landroidx/compose/ui/unit/Dp;", "F", "mouseSlop", "mouseToTouchSlopRatio", "", "awaitHorizontalPointerSlopOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPointerSlopOrCancellation", "getDragDirectionValue", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-pn7EDYM", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPointerUp", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DragGestureDetectorCopy.kt */
public final class DragGestureDetectorCopyKt {
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0169, code lost:
        if (androidx.compose.ui.input.pointer.PointerEventKt.positionChangeConsumed(r5) == false) goto L_0x016d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ef A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m955awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r20, long r21, int r23, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r24, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r25) {
        /*
            r0 = r21
            r2 = r25
            boolean r3 = r2 instanceof androidx.compose.material.DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.material.DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 r3 = (androidx.compose.material.DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.material.DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1 r3 = new androidx.compose.material.DragGestureDetectorCopyKt$awaitHorizontalPointerSlopOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 0
            r7 = 2
            r8 = 1
            r9 = 0
            if (r5 == 0) goto L_0x007b
            if (r5 == r8) goto L_0x005a
            if (r5 != r7) goto L_0x0052
            float r0 = r3.F$1
            float r1 = r3.F$0
            java.lang.Object r5 = r3.L$3
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            java.lang.Object r10 = r3.L$2
            kotlin.jvm.internal.Ref$LongRef r10 = (kotlin.jvm.internal.Ref.LongRef) r10
            java.lang.Object r11 = r3.L$1
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            java.lang.Object r12 = r3.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r0
            r0 = r12
            r18 = r3
            r3 = r1
            r1 = r11
            r11 = r10
            r10 = r4
            r4 = r18
            goto L_0x0165
        L_0x0052:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x005a:
            float r0 = r3.F$1
            float r1 = r3.F$0
            java.lang.Object r5 = r3.L$2
            kotlin.jvm.internal.Ref$LongRef r5 = (kotlin.jvm.internal.Ref.LongRef) r5
            java.lang.Object r10 = r3.L$1
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            java.lang.Object r11 = r3.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            kotlin.ResultKt.throwOnFailure(r2)
            r18 = r3
            r3 = r0
            r0 = r11
            r11 = r5
            r5 = r18
            r19 = r4
            r4 = r1
            r1 = r10
            r10 = r19
            goto L_0x00c2
        L_0x007b:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerEvent r2 = r20.getCurrentEvent()
            boolean r2 = m957isPointerUpDmW0f2w(r2, r0)
            if (r2 == 0) goto L_0x008a
            goto L_0x0188
        L_0x008a:
            androidx.compose.ui.platform.ViewConfiguration r2 = r20.getViewConfiguration()
            r5 = r23
            float r2 = m958pointerSlopE8SPZFQ(r2, r5)
            kotlin.jvm.internal.Ref$LongRef r5 = new kotlin.jvm.internal.Ref$LongRef
            r5.<init>()
            r5.element = r0
            r0 = r20
            r1 = r24
            r10 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = 0
        L_0x00a4:
            r4.L$0 = r0
            r4.L$1 = r1
            r4.L$2 = r10
            r4.L$3 = r9
            r4.F$0 = r3
            r4.F$1 = r2
            r4.label = r8
            java.lang.Object r11 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.DefaultImpls.awaitPointerEvent$default(r0, r9, r4, r8, r9)
            if (r11 != r5) goto L_0x00b9
            return r5
        L_0x00b9:
            r18 = r3
            r3 = r2
            r2 = r11
            r11 = r10
            r10 = r5
            r5 = r4
            r4 = r18
        L_0x00c2:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r12 = r2.getChanges()
            int r13 = r12.size()
            r15 = 0
        L_0x00cd:
            if (r15 >= r13) goto L_0x00ef
            int r16 = r15 + 1
            java.lang.Object r15 = r12.get(r15)
            r17 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            long r8 = r17.m2977getIdJ3iCeTQ()
            r21 = r15
            long r14 = r11.element
            boolean r8 = androidx.compose.ui.input.pointer.PointerId.m2966equalsimpl0(r8, r14)
            if (r8 == 0) goto L_0x00ea
            r15 = r21
            goto L_0x00f0
        L_0x00ea:
            r15 = r16
            r8 = 1
            r9 = 0
            goto L_0x00cd
        L_0x00ef:
            r15 = 0
        L_0x00f0:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
            r8 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            boolean r9 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeConsumed(r8)
            if (r9 == 0) goto L_0x00fe
            goto L_0x016b
        L_0x00fe:
            boolean r9 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r8)
            if (r9 == 0) goto L_0x0131
            java.util.List r2 = r2.getChanges()
            int r8 = r2.size()
            r14 = 0
        L_0x010d:
            if (r14 >= r8) goto L_0x0121
            int r9 = r14 + 1
            java.lang.Object r12 = r2.get(r14)
            r13 = r12
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            boolean r13 = r13.getPressed()
            if (r13 == 0) goto L_0x011f
            goto L_0x0122
        L_0x011f:
            r14 = r9
            goto L_0x010d
        L_0x0121:
            r12 = 0
        L_0x0122:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            if (r12 != 0) goto L_0x0127
            goto L_0x016b
        L_0x0127:
            long r8 = r12.m2977getIdJ3iCeTQ()
            r11.element = r8
            r2 = r3
            r3 = r4
            r4 = r5
            goto L_0x016d
        L_0x0131:
            long r12 = r8.m2978getPositionF1C5BW0()
            long r14 = r8.m2979getPreviousPositionF1C5BW0()
            float r2 = androidx.compose.ui.geometry.Offset.m1353getXimpl(r12)
            float r9 = androidx.compose.ui.geometry.Offset.m1353getXimpl(r14)
            float r2 = r2 - r9
            float r2 = r2 + r3
            float r3 = java.lang.Math.abs(r2)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x0173
            androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r5.L$0 = r0
            r5.L$1 = r1
            r5.L$2 = r11
            r5.L$3 = r8
            r5.F$0 = r4
            r5.F$1 = r2
            r5.label = r7
            java.lang.Object r3 = r0.awaitPointerEvent(r3, r5)
            if (r3 != r10) goto L_0x0162
            return r10
        L_0x0162:
            r3 = r4
            r4 = r5
            r5 = r8
        L_0x0165:
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeConsumed(r5)
            if (r5 == 0) goto L_0x016d
        L_0x016b:
            r9 = 0
            goto L_0x0188
        L_0x016d:
            r5 = r10
            r10 = r11
        L_0x016f:
            r8 = 1
            r9 = 0
            goto L_0x00a4
        L_0x0173:
            float r3 = java.lang.Math.signum(r2)
            float r3 = r3 * r4
            float r2 = r2 - r3
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r1.invoke(r8, r2)
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeConsumed(r8)
            if (r2 == 0) goto L_0x0189
            r9 = r8
        L_0x0188:
            return r9
        L_0x0189:
            r3 = r4
            r4 = r5
            r5 = r10
            r10 = r11
            r2 = 0
            goto L_0x016f
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DragGestureDetectorCopyKt.m955awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: awaitPointerSlopOrCancellation-pn7EDYM  reason: not valid java name */
    private static final Object m956awaitPointerSlopOrCancellationpn7EDYM(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Function2<? super PointerInputChange, ? super Float, Unit> function2, Function1<? super Offset, Float> function1, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        PointerInputChange pointerInputChange3;
        AwaitPointerEventScope awaitPointerEventScope2 = awaitPointerEventScope;
        Function1<? super Offset, Float> function12 = function1;
        Continuation<? super PointerInputChange> continuation2 = continuation;
        long j2 = j;
        if (m957isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j2)) {
            return null;
        }
        float r3 = m958pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
        do {
            float f = 0.0f;
            while (true) {
                InlineMarker.mark(0);
                Object awaitPointerEvent$default = AwaitPointerEventScope.DefaultImpls.awaitPointerEvent$default(awaitPointerEventScope2, (PointerEventPass) null, continuation2, 1, (Object) null);
                InlineMarker.mark(1);
                PointerEvent pointerEvent = (PointerEvent) awaitPointerEvent$default;
                List<PointerInputChange> changes = pointerEvent.getChanges();
                int size = changes.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        pointerInputChange = null;
                        break;
                    }
                    int i3 = i2 + 1;
                    pointerInputChange = changes.get(i2);
                    if (PointerId.m2966equalsimpl0(pointerInputChange.m2977getIdJ3iCeTQ(), j2)) {
                        break;
                    }
                    i2 = i3;
                }
                Intrinsics.checkNotNull(pointerInputChange);
                pointerInputChange2 = pointerInputChange;
                if (PointerEventKt.positionChangeConsumed(pointerInputChange2)) {
                    return null;
                }
                if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                    List<PointerInputChange> changes2 = pointerEvent.getChanges();
                    int size2 = changes2.size();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= size2) {
                            pointerInputChange3 = null;
                            break;
                        }
                        int i5 = i4 + 1;
                        pointerInputChange3 = changes2.get(i4);
                        if (pointerInputChange3.getPressed()) {
                            break;
                        }
                        i4 = i5;
                    }
                    PointerInputChange pointerInputChange4 = pointerInputChange3;
                    if (pointerInputChange4 == null) {
                        return null;
                    }
                    j2 = pointerInputChange4.m2977getIdJ3iCeTQ();
                } else {
                    f += function12.invoke(Offset.m1342boximpl(pointerInputChange2.m2978getPositionF1C5BW0())).floatValue() - function12.invoke(Offset.m1342boximpl(pointerInputChange2.m2979getPreviousPositionF1C5BW0())).floatValue();
                    if (Math.abs(f) < r3) {
                        PointerEventPass pointerEventPass = PointerEventPass.Final;
                        InlineMarker.mark(0);
                        awaitPointerEventScope2.awaitPointerEvent(pointerEventPass, continuation2);
                        InlineMarker.mark(1);
                        if (PointerEventKt.positionChangeConsumed(pointerInputChange2)) {
                            return null;
                        }
                    } else {
                        function2.invoke(pointerInputChange2, Float.valueOf(f - (Math.signum(f) * r3)));
                    }
                }
            }
        } while (!PointerEventKt.positionChangeConsumed(pointerInputChange2));
        return pointerInputChange2;
    }

    /* renamed from: isPointerUp-DmW0f2w  reason: not valid java name */
    private static final boolean m957isPointerUpDmW0f2w(PointerEvent pointerEvent, long j) {
        PointerInputChange pointerInputChange;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= size) {
                pointerInputChange = null;
                break;
            }
            int i2 = i + 1;
            pointerInputChange = changes.get(i);
            if (PointerId.m2966equalsimpl0(pointerInputChange.m2977getIdJ3iCeTQ(), j)) {
                break;
            }
            i = i2;
        }
        PointerInputChange pointerInputChange2 = pointerInputChange;
        if (pointerInputChange2 != null && pointerInputChange2.getPressed()) {
            z = true;
        }
        return true ^ z;
    }

    /* renamed from: pointerSlop-E8SPZFQ  reason: not valid java name */
    public static final float m958pointerSlopE8SPZFQ(ViewConfiguration viewConfiguration, int i) {
        Intrinsics.checkNotNullParameter(viewConfiguration, "$this$pointerSlop");
        if (PointerType.m3037equalsimpl0(i, PointerType.Companion.m3042getMouseT8wyACA())) {
            return viewConfiguration.getTouchSlop() * mouseToTouchSlopRatio;
        }
        return viewConfiguration.getTouchSlop();
    }

    static {
        float r0 = Dp.m3859constructorimpl((float) 0.125d);
        mouseSlop = r0;
        float r1 = Dp.m3859constructorimpl((float) 18);
        defaultTouchSlop = r1;
        mouseToTouchSlopRatio = r0 / r1;
    }
}
