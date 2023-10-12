package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a'\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a9\u0010\r\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u000fHHø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a'\u0010\u0013\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\f\u001ag\u0010\u0015\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u001726\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u001a_\u0010!\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n26\u0010\"\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010%\u001a\u0004\u0018\u00010\u0007*\u00020&2\u0006\u0010'\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010(\u001a]\u0010)\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001e0\u00192\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00050\u000fHHø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-\u001ag\u0010)\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u001726\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110+¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010 \u001a_\u0010/\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n26\u0010\"\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110+¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u0010$\u001a'\u00101\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u0010\f\u001ag\u00103\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u001726\u0010\"\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u0010 \u001a_\u00105\u001a\u0004\u0018\u00010\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\n26\u0010\"\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u001e0\u0019H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u0010$\u001a\u0001\u00107\u001a\u00020\u001e*\u00020&2\u0014\b\u0002\u00108\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u001e0\u000f2\u000e\b\u0002\u00109\u001a\b\u0012\u0004\u0012\u00020\u001e0:2\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001e0:26\u0010<\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110+¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u001e0\u0019H@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010>\u001a\u0001\u0010?\u001a\u00020\u001e*\u00020&2\u0014\b\u0002\u00108\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u001e0\u000f2\u000e\b\u0002\u00109\u001a\b\u0012\u0004\u0012\u00020\u001e0:2\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001e0:26\u0010<\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110+¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u001e0\u0019H@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010>\u001a\u0001\u0010@\u001a\u00020\u001e*\u00020&2\u0014\b\u0002\u00108\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u001e0\u000f2\u000e\b\u0002\u00109\u001a\b\u0012\u0004\u0012\u00020\u001e0:2\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001e0:26\u0010A\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u001e0\u0019H@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010>\u001a\u0001\u0010B\u001a\u00020\u001e*\u00020&2\u0014\b\u0002\u00108\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u001e0\u000f2\u000e\b\u0002\u00109\u001a\b\u0012\u0004\u0012\u00020\u001e0:2\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001e0:26\u0010C\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020\u001e0\u0019H@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010>\u001a9\u0010D\u001a\u00020\u0010*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u000fH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bE\u0010\u0012\u001aa\u0010D\u001a\u00020\u0010*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u000f2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u000f2\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u000fHHø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bH\u0010I\u001a9\u0010J\u001a\u00020\u0010*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u000fH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bK\u0010\u0012\u001a!\u0010L\u001a\u00020\u0010*\u00020M2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bN\u0010O\u001a!\u0010P\u001a\u00020\u0005*\u00020Q2\u0006\u0010\u0016\u001a\u00020\u0017H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bR\u0010S\u001a9\u0010T\u001a\u00020\u0010*\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001e0\u000fH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bU\u0010\u0012\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006V"}, d2 = {"defaultTouchSlop", "Landroidx/compose/ui/unit/Dp;", "F", "mouseSlop", "mouseToTouchSlopRatio", "", "awaitDragOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "awaitDragOrCancellation-rnUCldI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDragOrUp", "hasDragged", "Lkotlin/Function1;", "", "awaitDragOrUp-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalDragOrCancellation", "awaitHorizontalDragOrCancellation-rnUCldI", "awaitHorizontalPointerSlopOrCancellation", "pointerType", "Landroidx/compose/ui/input/pointer/PointerType;", "onPointerSlopReached", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "change", "overSlop", "", "awaitHorizontalPointerSlopOrCancellation-gDDlDlE", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitHorizontalTouchSlopOrCancellation", "onTouchSlopReached", "awaitHorizontalTouchSlopOrCancellation-jO51t88", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLongPressOrCancellation", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "initialDown", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Landroidx/compose/ui/input/pointer/PointerInputChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPointerSlopOrCancellation", "getDragDirectionValue", "Landroidx/compose/ui/geometry/Offset;", "awaitPointerSlopOrCancellation-pn7EDYM", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPointerSlopOrCancellation-gDDlDlE", "awaitTouchSlopOrCancellation", "awaitTouchSlopOrCancellation-jO51t88", "awaitVerticalDragOrCancellation", "awaitVerticalDragOrCancellation-rnUCldI", "awaitVerticalPointerSlopOrCancellation", "awaitVerticalPointerSlopOrCancellation-gDDlDlE", "awaitVerticalTouchSlopOrCancellation", "awaitVerticalTouchSlopOrCancellation-jO51t88", "detectDragGestures", "onDragStart", "onDragEnd", "Lkotlin/Function0;", "onDragCancel", "onDrag", "dragAmount", "(Landroidx/compose/ui/input/pointer/PointerInputScope;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectDragGesturesAfterLongPress", "detectHorizontalDragGestures", "onHorizontalDrag", "detectVerticalDragGestures", "onVerticalDrag", "drag", "drag-jO51t88", "motionFromChange", "motionConsumed", "drag-VnAYq1g", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "horizontalDrag", "horizontalDrag-jO51t88", "isPointerUp", "Landroidx/compose/ui/input/pointer/PointerEvent;", "isPointerUp-DmW0f2w", "(Landroidx/compose/ui/input/pointer/PointerEvent;J)Z", "pointerSlop", "Landroidx/compose/ui/platform/ViewConfiguration;", "pointerSlop-E8SPZFQ", "(Landroidx/compose/ui/platform/ViewConfiguration;I)F", "verticalDrag", "verticalDrag-jO51t88", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DragGestureDetector.kt */
public final class DragGestureDetectorKt {
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;

    /* renamed from: awaitTouchSlopOrCancellation-jO51t88  reason: not valid java name */
    public static final Object m253awaitTouchSlopOrCancellationjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super PointerInputChange> continuation) {
        return m251awaitPointerSlopOrCancellationgDDlDlE(awaitPointerEventScope, j, PointerType.Companion.m3044getTouchT8wyACA(), function2, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ad A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00e2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* renamed from: awaitPointerSlopOrCancellation-gDDlDlE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m251awaitPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, int r22, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super androidx.compose.ui.geometry.Offset, kotlin.Unit> r23, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r24) {
        /*
            r0 = r20
            r2 = r24
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitPointerSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitPointerSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitPointerSlopOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitPointerSlopOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            r8 = 0
            if (r5 == 0) goto L_0x0070
            if (r5 == r7) goto L_0x0052
            if (r5 != r6) goto L_0x004a
            float r0 = r3.F$0
            long r9 = r3.J$0
            java.lang.Object r1 = r3.L$3
            androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
            java.lang.Object r5 = r3.L$2
            kotlin.jvm.internal.Ref$LongRef r5 = (kotlin.jvm.internal.Ref.LongRef) r5
            java.lang.Object r11 = r3.L$1
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            java.lang.Object r12 = r3.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r12
            kotlin.ResultKt.throwOnFailure(r2)
            r2 = r0
            r0 = r12
            r7 = 2
            goto L_0x0179
        L_0x004a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0052:
            float r0 = r3.F$0
            long r9 = r3.J$0
            java.lang.Object r1 = r3.L$2
            kotlin.jvm.internal.Ref$LongRef r1 = (kotlin.jvm.internal.Ref.LongRef) r1
            java.lang.Object r5 = r3.L$1
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            java.lang.Object r11 = r3.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            kotlin.ResultKt.throwOnFailure(r2)
            r18 = r3
            r3 = r0
            r0 = r11
            r10 = r9
            r9 = r1
            r1 = r5
        L_0x006c:
            r5 = r4
            r4 = r18
            goto L_0x00b5
        L_0x0070:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerEvent r2 = r19.getCurrentEvent()
            boolean r2 = m260isPointerUpDmW0f2w(r2, r0)
            if (r2 == 0) goto L_0x007e
            return r8
        L_0x007e:
            androidx.compose.ui.geometry.Offset$Companion r2 = androidx.compose.ui.geometry.Offset.Companion
            long r9 = r2.m1369getZeroF1C5BW0()
            androidx.compose.ui.platform.ViewConfiguration r2 = r19.getViewConfiguration()
            r5 = r22
            float r2 = m261pointerSlopE8SPZFQ(r2, r5)
            kotlin.jvm.internal.Ref$LongRef r5 = new kotlin.jvm.internal.Ref$LongRef
            r5.<init>()
            r5.element = r0
            r0 = r19
            r1 = r23
        L_0x0099:
            r3.L$0 = r0
            r3.L$1 = r1
            r3.L$2 = r5
            r3.L$3 = r8
            r3.J$0 = r9
            r3.F$0 = r2
            r3.label = r7
            java.lang.Object r11 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.DefaultImpls.awaitPointerEvent$default(r0, r8, r3, r7, r8)
            if (r11 != r4) goto L_0x00ae
            return r4
        L_0x00ae:
            r18 = r3
            r3 = r2
            r2 = r11
            r10 = r9
            r9 = r5
            goto L_0x006c
        L_0x00b5:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r12 = r2.getChanges()
            int r13 = r12.size()
            r15 = 0
        L_0x00c0:
            if (r15 >= r13) goto L_0x00e2
            int r16 = r15 + 1
            java.lang.Object r15 = r12.get(r15)
            r17 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            r20 = r15
            long r14 = r17.m2977getIdJ3iCeTQ()
            long r6 = r9.element
            boolean r6 = androidx.compose.ui.input.pointer.PointerId.m2966equalsimpl0(r14, r6)
            if (r6 == 0) goto L_0x00dd
            r15 = r20
            goto L_0x00e3
        L_0x00dd:
            r15 = r16
            r6 = 2
            r7 = 1
            goto L_0x00c0
        L_0x00e2:
            r15 = r8
        L_0x00e3:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
            r6 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeConsumed(r6)
            if (r7 == 0) goto L_0x00f0
            return r8
        L_0x00f0:
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r6)
            if (r7 == 0) goto L_0x0125
            java.util.List r2 = r2.getChanges()
            int r6 = r2.size()
            r14 = 0
        L_0x00ff:
            if (r14 >= r6) goto L_0x0113
            int r7 = r14 + 1
            java.lang.Object r12 = r2.get(r14)
            r13 = r12
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            boolean r13 = r13.getPressed()
            if (r13 == 0) goto L_0x0111
            goto L_0x0114
        L_0x0111:
            r14 = r7
            goto L_0x00ff
        L_0x0113:
            r12 = r8
        L_0x0114:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            if (r12 != 0) goto L_0x0119
            return r8
        L_0x0119:
            long r6 = r12.m2977getIdJ3iCeTQ()
            r9.element = r6
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r9
            r9 = r10
            goto L_0x0181
        L_0x0125:
            long r12 = androidx.compose.ui.input.pointer.PointerEventKt.positionChange(r6)
            long r10 = androidx.compose.ui.geometry.Offset.m1358plusMKHz9U(r10, r12)
            float r2 = androidx.compose.ui.geometry.Offset.m1351getDistanceimpl(r10)
            int r7 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r7 < 0) goto L_0x0156
            long r12 = androidx.compose.ui.geometry.Offset.m1348divtuRUvjQ(r10, r2)
            long r12 = androidx.compose.ui.geometry.Offset.m1360timestuRUvjQ(r12, r3)
            long r12 = androidx.compose.ui.geometry.Offset.m1357minusMKHz9U(r10, r12)
            androidx.compose.ui.geometry.Offset r2 = androidx.compose.ui.geometry.Offset.m1342boximpl(r12)
            r1.invoke(r6, r2)
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeConsumed(r6)
            if (r2 == 0) goto L_0x0150
            r14 = 1
            goto L_0x0157
        L_0x0150:
            androidx.compose.ui.geometry.Offset$Companion r2 = androidx.compose.ui.geometry.Offset.Companion
            long r10 = r2.m1369getZeroF1C5BW0()
        L_0x0156:
            r14 = 0
        L_0x0157:
            if (r14 == 0) goto L_0x015a
            return r6
        L_0x015a:
            androidx.compose.ui.input.pointer.PointerEventPass r2 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r4.L$0 = r0
            r4.L$1 = r1
            r4.L$2 = r9
            r4.L$3 = r6
            r4.J$0 = r10
            r4.F$0 = r3
            r7 = 2
            r4.label = r7
            java.lang.Object r2 = r0.awaitPointerEvent(r2, r4)
            if (r2 != r5) goto L_0x0172
            return r5
        L_0x0172:
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r9
            r9 = r10
            r11 = r1
            r1 = r6
        L_0x0179:
            boolean r1 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeConsumed(r1)
            if (r1 == 0) goto L_0x0180
            return r8
        L_0x0180:
            r1 = r11
        L_0x0181:
            r6 = 2
            r7 = 1
            goto L_0x0099
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m251awaitPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: drag-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m258dragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r4, long r5, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$drag$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r5 = r0.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            kotlin.ResultKt.throwOnFailure(r8)
            r7 = r4
            r4 = r5
            goto L_0x004c
        L_0x0034:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r8)
        L_0x003f:
            r0.L$0 = r4
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r8 = m246awaitDragOrCancellationrnUCldI(r4, r5, r0)
            if (r8 != r1) goto L_0x004c
            return r1
        L_0x004c:
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L_0x0056
            r4 = 0
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r4
        L_0x0056:
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r8)
            if (r5 == 0) goto L_0x0061
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r4
        L_0x0061:
            r7.invoke(r8)
            long r5 = r8.m2977getIdJ3iCeTQ()
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m258dragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cc, code lost:
        if (androidx.compose.ui.input.pointer.PointerEventKt.positionChangedIgnoreConsumed(r10) != false) goto L_0x00ce;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0093 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: awaitDragOrCancellation-rnUCldI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m246awaitDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            r0 = r18
            r2 = r20
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitDragOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L_0x0044
            if (r5 != r6) goto L_0x003c
            java.lang.Object r0 = r3.L$1
            kotlin.jvm.internal.Ref$LongRef r0 = (kotlin.jvm.internal.Ref.LongRef) r0
            java.lang.Object r1 = r3.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r2)
            r16 = r1
            r1 = r0
            r0 = r16
            goto L_0x006d
        L_0x003c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerEvent r2 = r17.getCurrentEvent()
            boolean r2 = m260isPointerUpDmW0f2w(r2, r0)
            if (r2 == 0) goto L_0x0052
            return r7
        L_0x0052:
            kotlin.jvm.internal.Ref$LongRef r2 = new kotlin.jvm.internal.Ref$LongRef
            r2.<init>()
            r2.element = r0
            r0 = r17
        L_0x005b:
            r3.L$0 = r0
            r3.L$1 = r2
            r3.label = r6
            java.lang.Object r1 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.DefaultImpls.awaitPointerEvent$default(r0, r7, r3, r6, r7)
            if (r1 != r4) goto L_0x0068
            return r4
        L_0x0068:
            r16 = r2
            r2 = r1
            r1 = r16
        L_0x006d:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r5 = r2.getChanges()
            int r8 = r5.size()
            r9 = 0
            r10 = 0
        L_0x0079:
            if (r10 >= r8) goto L_0x0093
            int r11 = r10 + 1
            java.lang.Object r10 = r5.get(r10)
            r12 = r10
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            long r12 = r12.m2977getIdJ3iCeTQ()
            long r14 = r1.element
            boolean r12 = androidx.compose.ui.input.pointer.PointerId.m2966equalsimpl0(r12, r14)
            if (r12 == 0) goto L_0x0091
            goto L_0x0094
        L_0x0091:
            r10 = r11
            goto L_0x0079
        L_0x0093:
            r10 = r7
        L_0x0094:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r10)
            if (r5 == 0) goto L_0x00c8
            java.util.List r2 = r2.getChanges()
            int r5 = r2.size()
        L_0x00a7:
            if (r9 >= r5) goto L_0x00bb
            int r8 = r9 + 1
            java.lang.Object r9 = r2.get(r9)
            r11 = r9
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L_0x00b9
            goto L_0x00bc
        L_0x00b9:
            r9 = r8
            goto L_0x00a7
        L_0x00bb:
            r9 = r7
        L_0x00bc:
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            if (r9 != 0) goto L_0x00c1
            goto L_0x00ce
        L_0x00c1:
            long r8 = r9.m2977getIdJ3iCeTQ()
            r1.element = r8
            goto L_0x00d7
        L_0x00c8:
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangedIgnoreConsumed(r10)
            if (r2 == 0) goto L_0x00d7
        L_0x00ce:
            boolean r0 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeConsumed(r10)
            if (r0 == 0) goto L_0x00d5
            goto L_0x00d6
        L_0x00d5:
            r7 = r10
        L_0x00d6:
            return r7
        L_0x00d7:
            r2 = r1
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m246awaitDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object detectDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = DragGestureDetectorKt$detectDragGestures$2.INSTANCE;
        }
        Function1 function12 = function1;
        if ((i & 2) != 0) {
            function0 = DragGestureDetectorKt$detectDragGestures$3.INSTANCE;
        }
        Function0 function03 = function0;
        if ((i & 4) != 0) {
            function02 = DragGestureDetectorKt$detectDragGestures$4.INSTANCE;
        }
        return detectDragGestures(pointerInputScope, function12, function03, function02, function2, continuation);
    }

    public static final Object detectDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object forEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new DragGestureDetectorKt$detectDragGestures$5(function1, function2, function02, function0, (Continuation<? super DragGestureDetectorKt$detectDragGestures$5>) null), continuation);
        return forEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? forEachGesture : Unit.INSTANCE;
    }

    public static /* synthetic */ Object detectDragGesturesAfterLongPress$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = DragGestureDetectorKt$detectDragGesturesAfterLongPress$2.INSTANCE;
        }
        Function1 function12 = function1;
        if ((i & 2) != 0) {
            function0 = DragGestureDetectorKt$detectDragGesturesAfterLongPress$3.INSTANCE;
        }
        Function0 function03 = function0;
        if ((i & 4) != 0) {
            function02 = DragGestureDetectorKt$detectDragGesturesAfterLongPress$4.INSTANCE;
        }
        return detectDragGesturesAfterLongPress(pointerInputScope, function12, function03, function02, function2, continuation);
    }

    public static final Object detectDragGesturesAfterLongPress(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Continuation<? super Unit> continuation) {
        Object forEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new DragGestureDetectorKt$detectDragGesturesAfterLongPress$5(function1, function02, function0, function2, (Continuation<? super DragGestureDetectorKt$detectDragGesturesAfterLongPress$5>) null), continuation);
        return forEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? forEachGesture : Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x016d, code lost:
        if (androidx.compose.ui.input.pointer.PointerEventKt.positionChangeConsumed(r5) == false) goto L_0x0171;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* renamed from: awaitVerticalTouchSlopOrCancellation-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m256awaitVerticalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r20, long r21, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r23, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r24) {
        /*
            r0 = r21
            r2 = r24
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalTouchSlopOrCancellation$1
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
            goto L_0x0169
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
            goto L_0x00c6
        L_0x007b:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerType$Companion r2 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r2 = r2.m3044getTouchT8wyACA()
            androidx.compose.ui.input.pointer.PointerEvent r5 = r20.getCurrentEvent()
            boolean r5 = m260isPointerUpDmW0f2w(r5, r0)
            if (r5 == 0) goto L_0x0090
            goto L_0x018c
        L_0x0090:
            androidx.compose.ui.platform.ViewConfiguration r5 = r20.getViewConfiguration()
            float r2 = m261pointerSlopE8SPZFQ(r5, r2)
            kotlin.jvm.internal.Ref$LongRef r5 = new kotlin.jvm.internal.Ref$LongRef
            r5.<init>()
            r5.element = r0
            r0 = r20
            r1 = r23
            r10 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = 0
        L_0x00a8:
            r4.L$0 = r0
            r4.L$1 = r1
            r4.L$2 = r10
            r4.L$3 = r9
            r4.F$0 = r3
            r4.F$1 = r2
            r4.label = r8
            java.lang.Object r11 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.DefaultImpls.awaitPointerEvent$default(r0, r9, r4, r8, r9)
            if (r11 != r5) goto L_0x00bd
            return r5
        L_0x00bd:
            r18 = r3
            r3 = r2
            r2 = r11
            r11 = r10
            r10 = r5
            r5 = r4
            r4 = r18
        L_0x00c6:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r12 = r2.getChanges()
            int r13 = r12.size()
            r15 = 0
        L_0x00d1:
            if (r15 >= r13) goto L_0x00f3
            int r16 = r15 + 1
            java.lang.Object r15 = r12.get(r15)
            r17 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            long r8 = r17.m2977getIdJ3iCeTQ()
            r21 = r15
            long r14 = r11.element
            boolean r8 = androidx.compose.ui.input.pointer.PointerId.m2966equalsimpl0(r8, r14)
            if (r8 == 0) goto L_0x00ee
            r15 = r21
            goto L_0x00f4
        L_0x00ee:
            r15 = r16
            r8 = 1
            r9 = 0
            goto L_0x00d1
        L_0x00f3:
            r15 = 0
        L_0x00f4:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
            r8 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            boolean r9 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeConsumed(r8)
            if (r9 == 0) goto L_0x0102
            goto L_0x016f
        L_0x0102:
            boolean r9 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r8)
            if (r9 == 0) goto L_0x0135
            java.util.List r2 = r2.getChanges()
            int r8 = r2.size()
            r14 = 0
        L_0x0111:
            if (r14 >= r8) goto L_0x0125
            int r9 = r14 + 1
            java.lang.Object r12 = r2.get(r14)
            r13 = r12
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            boolean r13 = r13.getPressed()
            if (r13 == 0) goto L_0x0123
            goto L_0x0126
        L_0x0123:
            r14 = r9
            goto L_0x0111
        L_0x0125:
            r12 = 0
        L_0x0126:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            if (r12 != 0) goto L_0x012b
            goto L_0x016f
        L_0x012b:
            long r8 = r12.m2977getIdJ3iCeTQ()
            r11.element = r8
            r2 = r3
            r3 = r4
            r4 = r5
            goto L_0x0171
        L_0x0135:
            long r12 = r8.m2978getPositionF1C5BW0()
            long r14 = r8.m2979getPreviousPositionF1C5BW0()
            float r2 = androidx.compose.ui.geometry.Offset.m1354getYimpl(r12)
            float r9 = androidx.compose.ui.geometry.Offset.m1354getYimpl(r14)
            float r2 = r2 - r9
            float r2 = r2 + r3
            float r3 = java.lang.Math.abs(r2)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x0177
            androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r5.L$0 = r0
            r5.L$1 = r1
            r5.L$2 = r11
            r5.L$3 = r8
            r5.F$0 = r4
            r5.F$1 = r2
            r5.label = r7
            java.lang.Object r3 = r0.awaitPointerEvent(r3, r5)
            if (r3 != r10) goto L_0x0166
            return r10
        L_0x0166:
            r3 = r4
            r4 = r5
            r5 = r8
        L_0x0169:
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeConsumed(r5)
            if (r5 == 0) goto L_0x0171
        L_0x016f:
            r9 = 0
            goto L_0x018c
        L_0x0171:
            r5 = r10
            r10 = r11
        L_0x0173:
            r8 = 1
            r9 = 0
            goto L_0x00a8
        L_0x0177:
            float r3 = java.lang.Math.signum(r2)
            float r3 = r3 * r4
            float r2 = r2 - r3
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r1.invoke(r8, r2)
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeConsumed(r8)
            if (r2 == 0) goto L_0x018d
            r9 = r8
        L_0x018c:
            return r9
        L_0x018d:
            r3 = r4
            r4 = r5
            r5 = r10
            r10 = r11
            r2 = 0
            goto L_0x0173
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m256awaitVerticalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0169, code lost:
        if (androidx.compose.ui.input.pointer.PointerEventKt.positionChangeConsumed(r5) == false) goto L_0x016d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ef A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* renamed from: awaitVerticalPointerSlopOrCancellation-gDDlDlE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m255awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r20, long r21, int r23, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r24, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r25) {
        /*
            r0 = r21
            r2 = r25
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalPointerSlopOrCancellation$1
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
            boolean r2 = m260isPointerUpDmW0f2w(r2, r0)
            if (r2 == 0) goto L_0x008a
            goto L_0x0188
        L_0x008a:
            androidx.compose.ui.platform.ViewConfiguration r2 = r20.getViewConfiguration()
            r5 = r23
            float r2 = m261pointerSlopE8SPZFQ(r2, r5)
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
            float r2 = androidx.compose.ui.geometry.Offset.m1354getYimpl(r12)
            float r9 = androidx.compose.ui.geometry.Offset.m1354getYimpl(r14)
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m255awaitVerticalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e9, code lost:
        if ((!(androidx.compose.ui.geometry.Offset.m1354getYimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11)) == 0.0f)) != false) goto L_0x00eb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0078 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: verticalDrag-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m262verticalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r16, long r17, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r19, kotlin.coroutines.Continuation<? super java.lang.Boolean> r20) {
        /*
            r0 = r20
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$verticalDrag$1
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 0
            r5 = 0
            r6 = 1
            if (r3 == 0) goto L_0x0045
            if (r3 != r6) goto L_0x003d
            java.lang.Object r3 = r1.L$2
            kotlin.jvm.internal.Ref$LongRef r3 = (kotlin.jvm.internal.Ref.LongRef) r3
            java.lang.Object r7 = r1.L$1
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r8 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            kotlin.ResultKt.throwOnFailure(r0)
            r9 = r3
            r3 = r2
            r2 = r7
            goto L_0x007b
        L_0x003d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r0)
            androidx.compose.ui.input.pointer.PointerEvent r0 = r16.getCurrentEvent()
            r7 = r17
            boolean r0 = m260isPointerUpDmW0f2w(r0, r7)
            if (r0 == 0) goto L_0x005a
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            goto L_0x0102
        L_0x005a:
            r0 = r16
            r3 = r2
            r2 = r1
            r1 = r19
        L_0x0060:
            kotlin.jvm.internal.Ref$LongRef r9 = new kotlin.jvm.internal.Ref$LongRef
            r9.<init>()
            r9.element = r7
            r15 = r2
            r2 = r1
            r1 = r15
        L_0x006a:
            r1.L$0 = r0
            r1.L$1 = r2
            r1.L$2 = r9
            r1.label = r6
            java.lang.Object r7 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.DefaultImpls.awaitPointerEvent$default(r0, r4, r1, r6, r4)
            if (r7 != r3) goto L_0x0079
            return r3
        L_0x0079:
            r8 = r0
            r0 = r7
        L_0x007b:
            androidx.compose.ui.input.pointer.PointerEvent r0 = (androidx.compose.ui.input.pointer.PointerEvent) r0
            java.util.List r7 = r0.getChanges()
            int r10 = r7.size()
            r11 = 0
        L_0x0086:
            if (r11 >= r10) goto L_0x00a2
            int r12 = r11 + 1
            java.lang.Object r11 = r7.get(r11)
            r13 = r11
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            long r13 = r13.m2977getIdJ3iCeTQ()
            long r4 = r9.element
            boolean r4 = androidx.compose.ui.input.pointer.PointerId.m2966equalsimpl0(r13, r4)
            if (r4 == 0) goto L_0x009e
            goto L_0x00a3
        L_0x009e:
            r11 = r12
            r4 = 0
            r5 = 0
            goto L_0x0086
        L_0x00a2:
            r11 = 0
        L_0x00a3:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r11)
            if (r4 == 0) goto L_0x00d8
            java.util.List r0 = r0.getChanges()
            int r4 = r0.size()
            r5 = 0
        L_0x00b7:
            if (r5 >= r4) goto L_0x00cb
            int r7 = r5 + 1
            java.lang.Object r5 = r0.get(r5)
            r10 = r5
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            boolean r10 = r10.getPressed()
            if (r10 == 0) goto L_0x00c9
            goto L_0x00cc
        L_0x00c9:
            r5 = r7
            goto L_0x00b7
        L_0x00cb:
            r5 = 0
        L_0x00cc:
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            if (r5 != 0) goto L_0x00d1
            goto L_0x00eb
        L_0x00d1:
            long r4 = r5.m2977getIdJ3iCeTQ()
            r9.element = r4
            goto L_0x0113
        L_0x00d8:
            long r4 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11)
            float r0 = androidx.compose.ui.geometry.Offset.m1354getYimpl(r4)
            r4 = 0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x00e7
            r0 = 1
            goto L_0x00e8
        L_0x00e7:
            r0 = 0
        L_0x00e8:
            r0 = r0 ^ r6
            if (r0 == 0) goto L_0x0113
        L_0x00eb:
            boolean r0 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeConsumed(r11)
            if (r0 == 0) goto L_0x00f7
            r0 = 0
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            goto L_0x0102
        L_0x00f7:
            r0 = 0
            boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r11)
            if (r4 == 0) goto L_0x0103
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
        L_0x0102:
            return r0
        L_0x0103:
            r2.invoke(r11)
            long r4 = r11.m2977getIdJ3iCeTQ()
            r0 = r8
            r7 = r4
            r4 = 0
            r5 = 0
            r15 = r2
            r2 = r1
            r1 = r15
            goto L_0x0060
        L_0x0113:
            r0 = 0
            r0 = r8
            r4 = 0
            r5 = 0
            goto L_0x006a
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m262verticalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d8, code lost:
        if ((r9 ^ 1) != 0) goto L_0x00da;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0093 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: awaitVerticalDragOrCancellation-rnUCldI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m254awaitVerticalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            r0 = r18
            r2 = r20
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitVerticalDragOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L_0x0044
            if (r5 != r7) goto L_0x003c
            java.lang.Object r0 = r3.L$1
            kotlin.jvm.internal.Ref$LongRef r0 = (kotlin.jvm.internal.Ref.LongRef) r0
            java.lang.Object r1 = r3.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r2)
            r16 = r1
            r1 = r0
            r0 = r16
            goto L_0x006d
        L_0x003c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerEvent r2 = r17.getCurrentEvent()
            boolean r2 = m260isPointerUpDmW0f2w(r2, r0)
            if (r2 == 0) goto L_0x0052
            return r6
        L_0x0052:
            kotlin.jvm.internal.Ref$LongRef r2 = new kotlin.jvm.internal.Ref$LongRef
            r2.<init>()
            r2.element = r0
            r0 = r17
        L_0x005b:
            r3.L$0 = r0
            r3.L$1 = r2
            r3.label = r7
            java.lang.Object r1 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.DefaultImpls.awaitPointerEvent$default(r0, r6, r3, r7, r6)
            if (r1 != r4) goto L_0x0068
            return r4
        L_0x0068:
            r16 = r2
            r2 = r1
            r1 = r16
        L_0x006d:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r5 = r2.getChanges()
            int r8 = r5.size()
            r9 = 0
            r10 = 0
        L_0x0079:
            if (r10 >= r8) goto L_0x0093
            int r11 = r10 + 1
            java.lang.Object r10 = r5.get(r10)
            r12 = r10
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            long r12 = r12.m2977getIdJ3iCeTQ()
            long r14 = r1.element
            boolean r12 = androidx.compose.ui.input.pointer.PointerId.m2966equalsimpl0(r12, r14)
            if (r12 == 0) goto L_0x0091
            goto L_0x0094
        L_0x0091:
            r10 = r11
            goto L_0x0079
        L_0x0093:
            r10 = r6
        L_0x0094:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r10)
            if (r5 == 0) goto L_0x00c8
            java.util.List r2 = r2.getChanges()
            int r5 = r2.size()
        L_0x00a7:
            if (r9 >= r5) goto L_0x00bb
            int r8 = r9 + 1
            java.lang.Object r9 = r2.get(r9)
            r11 = r9
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L_0x00b9
            goto L_0x00bc
        L_0x00b9:
            r9 = r8
            goto L_0x00a7
        L_0x00bb:
            r9 = r6
        L_0x00bc:
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            if (r9 != 0) goto L_0x00c1
            goto L_0x00da
        L_0x00c1:
            long r8 = r9.m2977getIdJ3iCeTQ()
            r1.element = r8
            goto L_0x00e3
        L_0x00c8:
            long r11 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r10)
            float r2 = androidx.compose.ui.geometry.Offset.m1354getYimpl(r11)
            r5 = 0
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x00d6
            r9 = 1
        L_0x00d6:
            r2 = r9 ^ 1
            if (r2 == 0) goto L_0x00e3
        L_0x00da:
            boolean r0 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeConsumed(r10)
            if (r0 == 0) goto L_0x00e1
            goto L_0x00e2
        L_0x00e1:
            r6 = r10
        L_0x00e2:
            return r6
        L_0x00e3:
            r2 = r1
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m254awaitVerticalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object detectVerticalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = DragGestureDetectorKt$detectVerticalDragGestures$2.INSTANCE;
        }
        Function1 function12 = function1;
        if ((i & 2) != 0) {
            function0 = DragGestureDetectorKt$detectVerticalDragGestures$3.INSTANCE;
        }
        Function0 function03 = function0;
        if ((i & 4) != 0) {
            function02 = DragGestureDetectorKt$detectVerticalDragGestures$4.INSTANCE;
        }
        return detectVerticalDragGestures(pointerInputScope, function12, function03, function02, function2, continuation);
    }

    public static final Object detectVerticalDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object forEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new DragGestureDetectorKt$detectVerticalDragGestures$5(function1, function2, function0, function02, (Continuation<? super DragGestureDetectorKt$detectVerticalDragGestures$5>) null), continuation);
        return forEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? forEachGesture : Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x016d, code lost:
        if (androidx.compose.ui.input.pointer.PointerEventKt.positionChangeConsumed(r5) == false) goto L_0x0171;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* renamed from: awaitHorizontalTouchSlopOrCancellation-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m250awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r20, long r21, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r23, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r24) {
        /*
            r0 = r21
            r2 = r24
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalTouchSlopOrCancellation$1
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
            goto L_0x0169
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
            goto L_0x00c6
        L_0x007b:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerType$Companion r2 = androidx.compose.ui.input.pointer.PointerType.Companion
            int r2 = r2.m3044getTouchT8wyACA()
            androidx.compose.ui.input.pointer.PointerEvent r5 = r20.getCurrentEvent()
            boolean r5 = m260isPointerUpDmW0f2w(r5, r0)
            if (r5 == 0) goto L_0x0090
            goto L_0x018c
        L_0x0090:
            androidx.compose.ui.platform.ViewConfiguration r5 = r20.getViewConfiguration()
            float r2 = m261pointerSlopE8SPZFQ(r5, r2)
            kotlin.jvm.internal.Ref$LongRef r5 = new kotlin.jvm.internal.Ref$LongRef
            r5.<init>()
            r5.element = r0
            r0 = r20
            r1 = r23
            r10 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = 0
        L_0x00a8:
            r4.L$0 = r0
            r4.L$1 = r1
            r4.L$2 = r10
            r4.L$3 = r9
            r4.F$0 = r3
            r4.F$1 = r2
            r4.label = r8
            java.lang.Object r11 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.DefaultImpls.awaitPointerEvent$default(r0, r9, r4, r8, r9)
            if (r11 != r5) goto L_0x00bd
            return r5
        L_0x00bd:
            r18 = r3
            r3 = r2
            r2 = r11
            r11 = r10
            r10 = r5
            r5 = r4
            r4 = r18
        L_0x00c6:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r12 = r2.getChanges()
            int r13 = r12.size()
            r15 = 0
        L_0x00d1:
            if (r15 >= r13) goto L_0x00f3
            int r16 = r15 + 1
            java.lang.Object r15 = r12.get(r15)
            r17 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
            long r8 = r17.m2977getIdJ3iCeTQ()
            r21 = r15
            long r14 = r11.element
            boolean r8 = androidx.compose.ui.input.pointer.PointerId.m2966equalsimpl0(r8, r14)
            if (r8 == 0) goto L_0x00ee
            r15 = r21
            goto L_0x00f4
        L_0x00ee:
            r15 = r16
            r8 = 1
            r9 = 0
            goto L_0x00d1
        L_0x00f3:
            r15 = 0
        L_0x00f4:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r15)
            r8 = r15
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            boolean r9 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeConsumed(r8)
            if (r9 == 0) goto L_0x0102
            goto L_0x016f
        L_0x0102:
            boolean r9 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r8)
            if (r9 == 0) goto L_0x0135
            java.util.List r2 = r2.getChanges()
            int r8 = r2.size()
            r14 = 0
        L_0x0111:
            if (r14 >= r8) goto L_0x0125
            int r9 = r14 + 1
            java.lang.Object r12 = r2.get(r14)
            r13 = r12
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            boolean r13 = r13.getPressed()
            if (r13 == 0) goto L_0x0123
            goto L_0x0126
        L_0x0123:
            r14 = r9
            goto L_0x0111
        L_0x0125:
            r12 = 0
        L_0x0126:
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            if (r12 != 0) goto L_0x012b
            goto L_0x016f
        L_0x012b:
            long r8 = r12.m2977getIdJ3iCeTQ()
            r11.element = r8
            r2 = r3
            r3 = r4
            r4 = r5
            goto L_0x0171
        L_0x0135:
            long r12 = r8.m2978getPositionF1C5BW0()
            long r14 = r8.m2979getPreviousPositionF1C5BW0()
            float r2 = androidx.compose.ui.geometry.Offset.m1353getXimpl(r12)
            float r9 = androidx.compose.ui.geometry.Offset.m1353getXimpl(r14)
            float r2 = r2 - r9
            float r2 = r2 + r3
            float r3 = java.lang.Math.abs(r2)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x0177
            androidx.compose.ui.input.pointer.PointerEventPass r3 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r5.L$0 = r0
            r5.L$1 = r1
            r5.L$2 = r11
            r5.L$3 = r8
            r5.F$0 = r4
            r5.F$1 = r2
            r5.label = r7
            java.lang.Object r3 = r0.awaitPointerEvent(r3, r5)
            if (r3 != r10) goto L_0x0166
            return r10
        L_0x0166:
            r3 = r4
            r4 = r5
            r5 = r8
        L_0x0169:
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeConsumed(r5)
            if (r5 == 0) goto L_0x0171
        L_0x016f:
            r9 = 0
            goto L_0x018c
        L_0x0171:
            r5 = r10
            r10 = r11
        L_0x0173:
            r8 = 1
            r9 = 0
            goto L_0x00a8
        L_0x0177:
            float r3 = java.lang.Math.signum(r2)
            float r3 = r3 * r4
            float r2 = r2 - r3
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r2)
            r1.invoke(r8, r2)
            boolean r2 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeConsumed(r8)
            if (r2 == 0) goto L_0x018d
            r9 = r8
        L_0x018c:
            return r9
        L_0x018d:
            r3 = r4
            r4 = r5
            r5 = r10
            r10 = r11
            r2 = 0
            goto L_0x0173
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m250awaitHorizontalTouchSlopOrCancellationjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

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
    public static final java.lang.Object m249awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope r20, long r21, int r23, kotlin.jvm.functions.Function2<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, kotlin.Unit> r24, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r25) {
        /*
            r0 = r21
            r2 = r25
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalPointerSlopOrCancellation$1
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
            boolean r2 = m260isPointerUpDmW0f2w(r2, r0)
            if (r2 == 0) goto L_0x008a
            goto L_0x0188
        L_0x008a:
            androidx.compose.ui.platform.ViewConfiguration r2 = r20.getViewConfiguration()
            r5 = r23
            float r2 = m261pointerSlopE8SPZFQ(r2, r5)
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m249awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e9, code lost:
        if ((!(androidx.compose.ui.geometry.Offset.m1353getXimpl(androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11)) == 0.0f)) != false) goto L_0x00eb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0078 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* renamed from: horizontalDrag-jO51t88  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m259horizontalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope r16, long r17, kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, kotlin.Unit> r19, kotlin.coroutines.Continuation<? super java.lang.Boolean> r20) {
        /*
            r0 = r20
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1 r1 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            goto L_0x001b
        L_0x0016:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1 r1 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$horizontalDrag$1
            r1.<init>(r0)
        L_0x001b:
            java.lang.Object r0 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 0
            r5 = 0
            r6 = 1
            if (r3 == 0) goto L_0x0045
            if (r3 != r6) goto L_0x003d
            java.lang.Object r3 = r1.L$2
            kotlin.jvm.internal.Ref$LongRef r3 = (kotlin.jvm.internal.Ref.LongRef) r3
            java.lang.Object r7 = r1.L$1
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            java.lang.Object r8 = r1.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            kotlin.ResultKt.throwOnFailure(r0)
            r9 = r3
            r3 = r2
            r2 = r7
            goto L_0x007b
        L_0x003d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r0)
            androidx.compose.ui.input.pointer.PointerEvent r0 = r16.getCurrentEvent()
            r7 = r17
            boolean r0 = m260isPointerUpDmW0f2w(r0, r7)
            if (r0 == 0) goto L_0x005a
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            goto L_0x0102
        L_0x005a:
            r0 = r16
            r3 = r2
            r2 = r1
            r1 = r19
        L_0x0060:
            kotlin.jvm.internal.Ref$LongRef r9 = new kotlin.jvm.internal.Ref$LongRef
            r9.<init>()
            r9.element = r7
            r15 = r2
            r2 = r1
            r1 = r15
        L_0x006a:
            r1.L$0 = r0
            r1.L$1 = r2
            r1.L$2 = r9
            r1.label = r6
            java.lang.Object r7 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.DefaultImpls.awaitPointerEvent$default(r0, r4, r1, r6, r4)
            if (r7 != r3) goto L_0x0079
            return r3
        L_0x0079:
            r8 = r0
            r0 = r7
        L_0x007b:
            androidx.compose.ui.input.pointer.PointerEvent r0 = (androidx.compose.ui.input.pointer.PointerEvent) r0
            java.util.List r7 = r0.getChanges()
            int r10 = r7.size()
            r11 = 0
        L_0x0086:
            if (r11 >= r10) goto L_0x00a2
            int r12 = r11 + 1
            java.lang.Object r11 = r7.get(r11)
            r13 = r11
            androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
            long r13 = r13.m2977getIdJ3iCeTQ()
            long r4 = r9.element
            boolean r4 = androidx.compose.ui.input.pointer.PointerId.m2966equalsimpl0(r13, r4)
            if (r4 == 0) goto L_0x009e
            goto L_0x00a3
        L_0x009e:
            r11 = r12
            r4 = 0
            r5 = 0
            goto L_0x0086
        L_0x00a2:
            r11 = 0
        L_0x00a3:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r11)
            if (r4 == 0) goto L_0x00d8
            java.util.List r0 = r0.getChanges()
            int r4 = r0.size()
            r5 = 0
        L_0x00b7:
            if (r5 >= r4) goto L_0x00cb
            int r7 = r5 + 1
            java.lang.Object r5 = r0.get(r5)
            r10 = r5
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            boolean r10 = r10.getPressed()
            if (r10 == 0) goto L_0x00c9
            goto L_0x00cc
        L_0x00c9:
            r5 = r7
            goto L_0x00b7
        L_0x00cb:
            r5 = 0
        L_0x00cc:
            androidx.compose.ui.input.pointer.PointerInputChange r5 = (androidx.compose.ui.input.pointer.PointerInputChange) r5
            if (r5 != 0) goto L_0x00d1
            goto L_0x00eb
        L_0x00d1:
            long r4 = r5.m2977getIdJ3iCeTQ()
            r9.element = r4
            goto L_0x0113
        L_0x00d8:
            long r4 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r11)
            float r0 = androidx.compose.ui.geometry.Offset.m1353getXimpl(r4)
            r4 = 0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x00e7
            r0 = 1
            goto L_0x00e8
        L_0x00e7:
            r0 = 0
        L_0x00e8:
            r0 = r0 ^ r6
            if (r0 == 0) goto L_0x0113
        L_0x00eb:
            boolean r0 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeConsumed(r11)
            if (r0 == 0) goto L_0x00f7
            r0 = 0
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r0)
            goto L_0x0102
        L_0x00f7:
            r0 = 0
            boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r11)
            if (r4 == 0) goto L_0x0103
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
        L_0x0102:
            return r0
        L_0x0103:
            r2.invoke(r11)
            long r4 = r11.m2977getIdJ3iCeTQ()
            r0 = r8
            r7 = r4
            r4 = 0
            r5 = 0
            r15 = r2
            r2 = r1
            r1 = r15
            goto L_0x0060
        L_0x0113:
            r0 = 0
            r0 = r8
            r4 = 0
            r5 = 0
            goto L_0x006a
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m259horizontalDragjO51t88(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d8, code lost:
        if ((r9 ^ 1) != 0) goto L_0x00da;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0093 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* renamed from: awaitHorizontalDragOrCancellation-rnUCldI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object m248awaitHorizontalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            r0 = r18
            r2 = r20
            boolean r3 = r2 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 r3 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1 r3 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitHorizontalDragOrCancellation$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L_0x0044
            if (r5 != r7) goto L_0x003c
            java.lang.Object r0 = r3.L$1
            kotlin.jvm.internal.Ref$LongRef r0 = (kotlin.jvm.internal.Ref.LongRef) r0
            java.lang.Object r1 = r3.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
            kotlin.ResultKt.throwOnFailure(r2)
            r16 = r1
            r1 = r0
            r0 = r16
            goto L_0x006d
        L_0x003c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.compose.ui.input.pointer.PointerEvent r2 = r17.getCurrentEvent()
            boolean r2 = m260isPointerUpDmW0f2w(r2, r0)
            if (r2 == 0) goto L_0x0052
            return r6
        L_0x0052:
            kotlin.jvm.internal.Ref$LongRef r2 = new kotlin.jvm.internal.Ref$LongRef
            r2.<init>()
            r2.element = r0
            r0 = r17
        L_0x005b:
            r3.L$0 = r0
            r3.L$1 = r2
            r3.label = r7
            java.lang.Object r1 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.DefaultImpls.awaitPointerEvent$default(r0, r6, r3, r7, r6)
            if (r1 != r4) goto L_0x0068
            return r4
        L_0x0068:
            r16 = r2
            r2 = r1
            r1 = r16
        L_0x006d:
            androidx.compose.ui.input.pointer.PointerEvent r2 = (androidx.compose.ui.input.pointer.PointerEvent) r2
            java.util.List r5 = r2.getChanges()
            int r8 = r5.size()
            r9 = 0
            r10 = 0
        L_0x0079:
            if (r10 >= r8) goto L_0x0093
            int r11 = r10 + 1
            java.lang.Object r10 = r5.get(r10)
            r12 = r10
            androidx.compose.ui.input.pointer.PointerInputChange r12 = (androidx.compose.ui.input.pointer.PointerInputChange) r12
            long r12 = r12.m2977getIdJ3iCeTQ()
            long r14 = r1.element
            boolean r12 = androidx.compose.ui.input.pointer.PointerId.m2966equalsimpl0(r12, r14)
            if (r12 == 0) goto L_0x0091
            goto L_0x0094
        L_0x0091:
            r10 = r11
            goto L_0x0079
        L_0x0093:
            r10 = r6
        L_0x0094:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
            boolean r5 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r10)
            if (r5 == 0) goto L_0x00c8
            java.util.List r2 = r2.getChanges()
            int r5 = r2.size()
        L_0x00a7:
            if (r9 >= r5) goto L_0x00bb
            int r8 = r9 + 1
            java.lang.Object r9 = r2.get(r9)
            r11 = r9
            androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
            boolean r11 = r11.getPressed()
            if (r11 == 0) goto L_0x00b9
            goto L_0x00bc
        L_0x00b9:
            r9 = r8
            goto L_0x00a7
        L_0x00bb:
            r9 = r6
        L_0x00bc:
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            if (r9 != 0) goto L_0x00c1
            goto L_0x00da
        L_0x00c1:
            long r8 = r9.m2977getIdJ3iCeTQ()
            r1.element = r8
            goto L_0x00e3
        L_0x00c8:
            long r11 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeIgnoreConsumed(r10)
            float r2 = androidx.compose.ui.geometry.Offset.m1353getXimpl(r11)
            r5 = 0
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x00d6
            r9 = 1
        L_0x00d6:
            r2 = r9 ^ 1
            if (r2 == 0) goto L_0x00e3
        L_0x00da:
            boolean r0 = androidx.compose.ui.input.pointer.PointerEventKt.positionChangeConsumed(r10)
            if (r0 == 0) goto L_0x00e1
            goto L_0x00e2
        L_0x00e1:
            r6 = r10
        L_0x00e2:
            return r6
        L_0x00e3:
            r2 = r1
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.m248awaitHorizontalDragOrCancellationrnUCldI(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object detectHorizontalDragGestures$default(PointerInputScope pointerInputScope, Function1 function1, Function0 function0, Function0 function02, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = DragGestureDetectorKt$detectHorizontalDragGestures$2.INSTANCE;
        }
        Function1 function12 = function1;
        if ((i & 2) != 0) {
            function0 = DragGestureDetectorKt$detectHorizontalDragGestures$3.INSTANCE;
        }
        Function0 function03 = function0;
        if ((i & 4) != 0) {
            function02 = DragGestureDetectorKt$detectHorizontalDragGestures$4.INSTANCE;
        }
        return detectHorizontalDragGestures(pointerInputScope, function12, function03, function02, function2, continuation);
    }

    public static final Object detectHorizontalDragGestures(PointerInputScope pointerInputScope, Function1<? super Offset, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, Function2<? super PointerInputChange, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object forEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new DragGestureDetectorKt$detectHorizontalDragGestures$5(function1, function2, function0, function02, (Continuation<? super DragGestureDetectorKt$detectHorizontalDragGestures$5>) null), continuation);
        return forEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? forEachGesture : Unit.INSTANCE;
    }

    /* renamed from: drag-VnAYq1g  reason: not valid java name */
    private static final Object m257dragVnAYq1g(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Unit> function1, Function1<? super PointerInputChange, Float> function12, Function1<? super PointerInputChange, Boolean> function13, Continuation<? super Boolean> continuation) {
        PointerInputChange pointerInputChange;
        long j2 = j;
        if (m260isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j2)) {
            return false;
        }
        while (true) {
            InlineMarker.mark(0);
            PointerInputChange pointerInputChange2 = null;
            AwaitPointerEventScope awaitPointerEventScope2 = awaitPointerEventScope;
            Object awaitPointerEvent$default = AwaitPointerEventScope.DefaultImpls.awaitPointerEvent$default(awaitPointerEventScope, (PointerEventPass) null, continuation, 1, (Object) null);
            InlineMarker.mark(1);
            PointerEvent pointerEvent = (PointerEvent) awaitPointerEvent$default;
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    pointerInputChange = null;
                    break;
                }
                int i2 = i + 1;
                pointerInputChange = changes.get(i);
                if (PointerId.m2966equalsimpl0(pointerInputChange.m2977getIdJ3iCeTQ(), j2)) {
                    break;
                }
                i = i2;
            }
            Intrinsics.checkNotNull(pointerInputChange);
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size2) {
                        break;
                    }
                    int i4 = i3 + 1;
                    PointerInputChange pointerInputChange4 = changes2.get(i3);
                    if (pointerInputChange4.getPressed()) {
                        pointerInputChange2 = pointerInputChange4;
                        break;
                    }
                    i3 = i4;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange2;
                if (pointerInputChange5 == null) {
                    Function1<? super PointerInputChange, Float> function14 = function12;
                } else {
                    j2 = pointerInputChange5.m2977getIdJ3iCeTQ();
                }
            } else {
                if (!(!(function12.invoke(pointerInputChange3).floatValue() == 0.0f))) {
                    Function1<? super PointerInputChange, Unit> function15 = function1;
                    Function1<? super PointerInputChange, Boolean> function16 = function13;
                }
            }
            if (function13.invoke(pointerInputChange3).booleanValue()) {
                return false;
            }
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                return true;
            }
            function1.invoke(pointerInputChange3);
            j2 = pointerInputChange3.m2977getIdJ3iCeTQ();
        }
    }

    /* renamed from: awaitDragOrUp-jO51t88  reason: not valid java name */
    private static final Object m247awaitDragOrUpjO51t88(AwaitPointerEventScope awaitPointerEventScope, long j, Function1<? super PointerInputChange, Boolean> function1, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        while (true) {
            int i = 0;
            InlineMarker.mark(0);
            PointerInputChange pointerInputChange2 = null;
            Object awaitPointerEvent$default = AwaitPointerEventScope.DefaultImpls.awaitPointerEvent$default(awaitPointerEventScope, (PointerEventPass) null, continuation, 1, (Object) null);
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
                if (PointerId.m2966equalsimpl0(pointerInputChange.m2977getIdJ3iCeTQ(), j)) {
                    break;
                }
                i2 = i3;
            }
            Intrinsics.checkNotNull(pointerInputChange);
            PointerInputChange pointerInputChange3 = pointerInputChange;
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange3)) {
                List<PointerInputChange> changes2 = pointerEvent.getChanges();
                int size2 = changes2.size();
                while (true) {
                    if (i >= size2) {
                        break;
                    }
                    int i4 = i + 1;
                    PointerInputChange pointerInputChange4 = changes2.get(i);
                    if (pointerInputChange4.getPressed()) {
                        pointerInputChange2 = pointerInputChange4;
                        break;
                    }
                    i = i4;
                }
                PointerInputChange pointerInputChange5 = pointerInputChange2;
                if (pointerInputChange5 == null) {
                    return pointerInputChange3;
                }
                j = pointerInputChange5.m2977getIdJ3iCeTQ();
            } else if (function1.invoke(pointerInputChange3).booleanValue()) {
                return pointerInputChange3;
            }
        }
    }

    /* renamed from: awaitPointerSlopOrCancellation-pn7EDYM  reason: not valid java name */
    private static final Object m252awaitPointerSlopOrCancellationpn7EDYM(AwaitPointerEventScope awaitPointerEventScope, long j, int i, Function2<? super PointerInputChange, ? super Float, Unit> function2, Function1<? super Offset, Float> function1, Continuation<? super PointerInputChange> continuation) {
        PointerInputChange pointerInputChange;
        PointerInputChange pointerInputChange2;
        PointerInputChange pointerInputChange3;
        AwaitPointerEventScope awaitPointerEventScope2 = awaitPointerEventScope;
        Function1<? super Offset, Float> function12 = function1;
        Continuation<? super PointerInputChange> continuation2 = continuation;
        long j2 = j;
        if (m260isPointerUpDmW0f2w(awaitPointerEventScope.getCurrentEvent(), j2)) {
            return null;
        }
        float r3 = m261pointerSlopE8SPZFQ(awaitPointerEventScope.getViewConfiguration(), i);
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

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object awaitLongPressOrCancellation(androidx.compose.ui.input.pointer.PointerInputScope r8, T r9, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r10) {
        /*
            boolean r0 = r10 instanceof androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1 r0 = (androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$1
            r0.<init>(r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r4) goto L_0x0035
            java.lang.Object r8 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r9 = r0.L$0
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ TimeoutCancellationException -> 0x0033 }
            goto L_0x0069
        L_0x0033:
            goto L_0x006d
        L_0x0035:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            r2.element = r9
            androidx.compose.ui.platform.ViewConfiguration r5 = r8.getViewConfiguration()
            long r5 = r5.getLongPressTimeoutMillis()
            androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2 r7 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$awaitLongPressOrCancellation$2     // Catch:{ TimeoutCancellationException -> 0x006c }
            r7.<init>(r8, r2, r10, r3)     // Catch:{ TimeoutCancellationException -> 0x006c }
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch:{ TimeoutCancellationException -> 0x006c }
            r0.L$0 = r9     // Catch:{ TimeoutCancellationException -> 0x006c }
            r0.L$1 = r10     // Catch:{ TimeoutCancellationException -> 0x006c }
            r0.label = r4     // Catch:{ TimeoutCancellationException -> 0x006c }
            java.lang.Object r8 = kotlinx.coroutines.TimeoutKt.withTimeout(r5, r7, r0)     // Catch:{ TimeoutCancellationException -> 0x006c }
            if (r8 != r1) goto L_0x0068
            return r1
        L_0x0068:
            r8 = r10
        L_0x0069:
            androidx.compose.ui.input.pointer.PointerInputChange r3 = (androidx.compose.ui.input.pointer.PointerInputChange) r3     // Catch:{ TimeoutCancellationException -> 0x0033 }
            goto L_0x0076
        L_0x006c:
            r8 = r10
        L_0x006d:
            T r8 = r8.element
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            if (r8 != 0) goto L_0x0075
            r3 = r9
            goto L_0x0076
        L_0x0075:
            r3 = r8
        L_0x0076:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt.awaitLongPressOrCancellation(androidx.compose.ui.input.pointer.PointerInputScope, androidx.compose.ui.input.pointer.PointerInputChange, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* renamed from: isPointerUp-DmW0f2w  reason: not valid java name */
    public static final boolean m260isPointerUpDmW0f2w(PointerEvent pointerEvent, long j) {
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
    public static final float m261pointerSlopE8SPZFQ(ViewConfiguration viewConfiguration, int i) {
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
