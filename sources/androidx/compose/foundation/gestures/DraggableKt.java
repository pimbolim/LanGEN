package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Velocity;
import com.braintreepayments.api.models.PostalAddressParser;
import com.brentvatne.react.ReactVideoView;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.SendChannel;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u001a!\u0010\u0006\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0007¢\u0006\u0002\u0010\u0007\u001aa\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t*\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\u00030\r2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00100\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u001aO\u0010\u0016\u001a\u00020\u000e*\u00020\u000b2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001aô\u0001\u0010\u001d\u001a\u00020\u001e*\u00020\u001e2\u0011\u0010\u001f\u001a\r\u0012\u0004\u0012\u00020 0\u0010¢\u0006\u0002\b!2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\u00032\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\"\u001a\u00020\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102>\b\u0002\u0010%\u001a8\b\u0001\u0012\u0004\u0012\u00020'\u0012\u0013\u0012\u00110(¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050,\u0012\u0006\u0012\u0004\u0018\u00010-0&¢\u0006\u0002\b.2>\b\u0002\u0010/\u001a8\b\u0001\u0012\u0004\u0012\u00020'\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(0\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050,\u0012\u0006\u0012\u0004\u0018\u00010-0&¢\u0006\u0002\b.2\b\b\u0002\u0010\u001b\u001a\u00020\u000eH\u0000ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u00101\u001aÏ\u0001\u0010\u001d\u001a\u00020\u001e*\u00020\u001e2\u0006\u00102\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\"\u001a\u00020\u000e2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2>\b\u0002\u0010%\u001a8\b\u0001\u0012\u0004\u0012\u00020'\u0012\u0013\u0012\u00110(¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050,\u0012\u0006\u0012\u0004\u0018\u00010-0&¢\u0006\u0002\b.2>\b\u0002\u0010/\u001a8\b\u0001\u0012\u0004\u0012\u00020'\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(0\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050,\u0012\u0006\u0012\u0004\u0018\u00010-0&¢\u0006\u0002\b.2\b\b\u0002\u0010\u001b\u001a\u00020\u000eø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u00103\u001a!\u00104\u001a\u00020\u0004*\u00020(2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106\u001a!\u00104\u001a\u00020\u0004*\u0002072\u0006\u0010\u0013\u001a\u00020\u0014H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00106\u001a\u001c\u00109\u001a\u00020(*\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0002ø\u0001\u0000¢\u0006\u0002\u0010:\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006;"}, d2 = {"DraggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "onDelta", "Lkotlin/Function1;", "", "", "rememberDraggableState", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/DraggableState;", "awaitDownAndSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "canDrag", "Landroidx/compose/runtime/State;", "", "startDragImmediately", "Lkotlin/Function0;", "velocityTracker", "Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/ui/input/pointer/util/VelocityTracker;Landroidx/compose/foundation/gestures/Orientation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitDrag", "dragStart", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "Landroidx/compose/foundation/gestures/DragEvent;", "reverseDirection", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;Lkotlin/Pair;Landroidx/compose/ui/input/pointer/util/VelocityTracker;Lkotlinx/coroutines/channels/SendChannel;ZLandroidx/compose/foundation/gestures/Orientation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "draggable", "Landroidx/compose/ui/Modifier;", "stateFactory", "Landroidx/compose/foundation/gestures/PointerAwareDraggableState;", "Landroidx/compose/runtime/Composable;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "velocity", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)Landroidx/compose/ui/Modifier;", "state", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/gestures/DraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)Landroidx/compose/ui/Modifier;", "toFloat", "toFloat-3MmeM6k", "(JLandroidx/compose/foundation/gestures/Orientation;)F", "Landroidx/compose/ui/unit/Velocity;", "toFloat-sF-c-tU", "toOffset", "(FLandroidx/compose/foundation/gestures/Orientation;)J", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Draggable.kt */
public final class DraggableKt {
    public static final DraggableState DraggableState(Function1<? super Float, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onDelta");
        return new DefaultDraggableState(function1);
    }

    public static final DraggableState rememberDraggableState(Function1<? super Float, Unit> function1, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function1, "onDelta");
        composer.startReplaceableGroup(-1066220065);
        ComposerKt.sourceInformation(composer, "C(rememberDraggableState)136@5816L29,137@5857L61:Draggable.kt#8bwon0");
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function1, composer, i & 14);
        composer.startReplaceableGroup(-3687241);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = DraggableState(new DraggableKt$rememberDraggableState$1$1(rememberUpdatedState));
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        DraggableState draggableState = (DraggableState) rememberedValue;
        composer.endReplaceableGroup();
        return draggableState;
    }

    public static /* synthetic */ Modifier draggable$default(Modifier modifier, DraggableState draggableState, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Function3 function3, Function3 function32, boolean z3, int i, Object obj) {
        int i2 = i;
        return draggable(modifier, draggableState, orientation, (i2 & 4) != 0 ? true : z, (i2 & 8) != 0 ? null : mutableInteractionSource, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? new DraggableKt$draggable$1((Continuation<? super DraggableKt$draggable$1>) null) : function3, (i2 & 64) != 0 ? new DraggableKt$draggable$2((Continuation<? super DraggableKt$draggable$2>) null) : function32, (i2 & 128) != 0 ? false : z3);
    }

    public static final Modifier draggable(Modifier modifier, DraggableState draggableState, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, boolean z2, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> function32, boolean z3) {
        DraggableState draggableState2 = draggableState;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(draggableState, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(orientation, ReactVideoView.EVENT_PROP_ORIENTATION);
        Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function33 = function3;
        Intrinsics.checkNotNullParameter(function33, "onDragStarted");
        Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> function34 = function32;
        Intrinsics.checkNotNullParameter(function34, "onDragStopped");
        return draggable(modifier, new DraggableKt$draggable$3(draggableState), DraggableKt$draggable$4.INSTANCE, orientation, z, mutableInteractionSource, new DraggableKt$draggable$5(z2), function33, function34, z3);
    }

    public static /* synthetic */ Modifier draggable$default(Modifier modifier, Function2 function2, Function1 function1, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, Function0 function0, Function3 function3, Function3 function32, boolean z2, int i, Object obj) {
        int i2 = i;
        return draggable(modifier, function2, function1, orientation, (i2 & 8) != 0 ? true : z, (i2 & 16) != 0 ? null : mutableInteractionSource, function0, (i2 & 64) != 0 ? new DraggableKt$draggable$6((Continuation<? super DraggableKt$draggable$6>) null) : function3, (i2 & 128) != 0 ? new DraggableKt$draggable$7((Continuation<? super DraggableKt$draggable$7>) null) : function32, (i2 & 256) != 0 ? false : z2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v4, resolved type: androidx.compose.foundation.gestures.Orientation} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: androidx.compose.ui.input.pointer.util.VelocityTracker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: androidx.compose.runtime.State<? extends kotlin.jvm.functions.Function0<java.lang.Boolean>>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: androidx.compose.runtime.State<? extends kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Boolean>>} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object awaitDownAndSlop(androidx.compose.ui.input.pointer.AwaitPointerEventScope r9, androidx.compose.runtime.State<? extends kotlin.jvm.functions.Function1<? super androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Boolean>> r10, androidx.compose.runtime.State<? extends kotlin.jvm.functions.Function0<java.lang.Boolean>> r11, androidx.compose.ui.input.pointer.util.VelocityTracker r12, androidx.compose.foundation.gestures.Orientation r13, kotlin.coroutines.Continuation<? super kotlin.Pair<androidx.compose.ui.input.pointer.PointerInputChange, java.lang.Float>> r14) {
        /*
            boolean r0 = r14 instanceof androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$1 r0 = (androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$1 r0 = new androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$1
            r0.<init>(r14)
        L_0x0019:
            r14 = r0
            java.lang.Object r0 = r14.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r14.label
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            if (r2 == 0) goto L_0x0079
            if (r2 == r7) goto L_0x005d
            if (r2 == r6) goto L_0x004c
            if (r2 == r5) goto L_0x0043
            if (r2 != r4) goto L_0x003b
            java.lang.Object r9 = r14.L$0
            kotlin.jvm.internal.Ref$FloatRef r9 = (kotlin.jvm.internal.Ref.FloatRef) r9
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x012f
        L_0x003b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0043:
            java.lang.Object r9 = r14.L$0
            kotlin.jvm.internal.Ref$FloatRef r9 = (kotlin.jvm.internal.Ref.FloatRef) r9
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0112
        L_0x004c:
            java.lang.Object r9 = r14.L$2
            androidx.compose.foundation.gestures.Orientation r9 = (androidx.compose.foundation.gestures.Orientation) r9
            java.lang.Object r10 = r14.L$1
            androidx.compose.ui.input.pointer.util.VelocityTracker r10 = (androidx.compose.ui.input.pointer.util.VelocityTracker) r10
            java.lang.Object r11 = r14.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x00e2
        L_0x005d:
            java.lang.Object r9 = r14.L$4
            r13 = r9
            androidx.compose.foundation.gestures.Orientation r13 = (androidx.compose.foundation.gestures.Orientation) r13
            java.lang.Object r9 = r14.L$3
            r12 = r9
            androidx.compose.ui.input.pointer.util.VelocityTracker r12 = (androidx.compose.ui.input.pointer.util.VelocityTracker) r12
            java.lang.Object r9 = r14.L$2
            r11 = r9
            androidx.compose.runtime.State r11 = (androidx.compose.runtime.State) r11
            java.lang.Object r9 = r14.L$1
            r10 = r9
            androidx.compose.runtime.State r10 = (androidx.compose.runtime.State) r10
            java.lang.Object r9 = r14.L$0
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x0091
        L_0x0079:
            kotlin.ResultKt.throwOnFailure(r0)
            androidx.compose.ui.input.pointer.PointerEventPass r0 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
            r14.L$0 = r9
            r14.L$1 = r10
            r14.L$2 = r11
            r14.L$3 = r12
            r14.L$4 = r13
            r14.label = r7
            java.lang.Object r0 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDownOnPass(r9, r0, r3, r14)
            if (r0 != r1) goto L_0x0091
            return r1
        L_0x0091:
            androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.ui.input.pointer.PointerInputChange) r0
            java.lang.Object r10 = r10.getValue()
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            java.lang.Object r10 = r10.invoke(r0)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L_0x00a9
            kotlin.Pair r8 = (kotlin.Pair) r8
            goto L_0x013d
        L_0x00a9:
            java.lang.Object r10 = r11.getValue()
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            java.lang.Object r10 = r10.invoke()
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x00cc
            androidx.compose.ui.input.pointer.PointerEventKt.consumeAllChanges(r0)
            androidx.compose.ui.input.pointer.util.VelocityTrackerKt.addPointerInputChange(r12, r0)
            r9 = 0
            java.lang.Float r9 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r9)
            kotlin.Pair r8 = kotlin.TuplesKt.to(r0, r9)
            goto L_0x013d
        L_0x00cc:
            r14.L$0 = r9
            r14.L$1 = r12
            r14.L$2 = r13
            r14.L$3 = r8
            r14.L$4 = r8
            r14.label = r6
            java.lang.Object r0 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(r9, r3, r14)
            if (r0 != r1) goto L_0x00df
            return r1
        L_0x00df:
            r11 = r9
            r10 = r12
            r9 = r13
        L_0x00e2:
            androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.ui.input.pointer.PointerInputChange) r0
            androidx.compose.ui.input.pointer.util.VelocityTrackerKt.addPointerInputChange(r10, r0)
            kotlin.jvm.internal.Ref$FloatRef r2 = new kotlin.jvm.internal.Ref$FloatRef
            r2.<init>()
            androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$postPointerSlop$1 r12 = new androidx.compose.foundation.gestures.DraggableKt$awaitDownAndSlop$postPointerSlop$1
            r12.<init>(r10, r2)
            r13 = r12
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            androidx.compose.foundation.gestures.Orientation r10 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r9 != r10) goto L_0x0115
            long r3 = r0.m2977getIdJ3iCeTQ()
            int r12 = r0.m2981getTypeT8wyACA()
            r14.L$0 = r2
            r14.L$1 = r8
            r14.L$2 = r8
            r14.label = r5
            r9 = r11
            r10 = r3
            java.lang.Object r0 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m255awaitVerticalPointerSlopOrCancellationgDDlDlE(r9, r10, r12, r13, r14)
            if (r0 != r1) goto L_0x0111
            return r1
        L_0x0111:
            r9 = r2
        L_0x0112:
            androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.ui.input.pointer.PointerInputChange) r0
            goto L_0x0131
        L_0x0115:
            long r5 = r0.m2977getIdJ3iCeTQ()
            int r12 = r0.m2981getTypeT8wyACA()
            r14.L$0 = r2
            r14.L$1 = r8
            r14.L$2 = r8
            r14.label = r4
            r9 = r11
            r10 = r5
            java.lang.Object r0 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m249awaitHorizontalPointerSlopOrCancellationgDDlDlE(r9, r10, r12, r13, r14)
            if (r0 != r1) goto L_0x012e
            return r1
        L_0x012e:
            r9 = r2
        L_0x012f:
            androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.ui.input.pointer.PointerInputChange) r0
        L_0x0131:
            if (r0 == 0) goto L_0x013d
            float r9 = r9.element
            java.lang.Float r9 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r9)
            kotlin.Pair r8 = kotlin.TuplesKt.to(r0, r9)
        L_0x013d:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DraggableKt.awaitDownAndSlop(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.runtime.State, androidx.compose.runtime.State, androidx.compose.ui.input.pointer.util.VelocityTracker, androidx.compose.foundation.gestures.Orientation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final Object awaitDrag(AwaitPointerEventScope awaitPointerEventScope, Pair<PointerInputChange, Float> pair, VelocityTracker velocityTracker, SendChannel<? super DragEvent> sendChannel, boolean z, Orientation orientation, Continuation<? super Boolean> continuation) {
        float floatValue = pair.getSecond().floatValue();
        PointerInputChange first = pair.getFirst();
        long r1 = Offset.m1357minusMKHz9U(first.m2978getPositionF1C5BW0(), Offset.m1360timestuRUvjQ(toOffset(floatValue, orientation), Math.signum(m270toFloat3MmeM6k(first.m2978getPositionF1C5BW0(), orientation))));
        sendChannel.m6176trySendJP2dKIU(new DragEvent.DragStarted(r1, (DefaultConstructorMarker) null));
        if (z) {
            floatValue *= (float) -1;
        }
        sendChannel.m6176trySendJP2dKIU(new DragEvent.DragDelta(floatValue, r1, (DefaultConstructorMarker) null));
        Function1 draggableKt$awaitDrag$dragTick$1 = new DraggableKt$awaitDrag$dragTick$1(velocityTracker, orientation, sendChannel, z);
        if (orientation == Orientation.Vertical) {
            return DragGestureDetectorKt.m262verticalDragjO51t88(awaitPointerEventScope, first.m2977getIdJ3iCeTQ(), draggableKt$awaitDrag$dragTick$1, continuation);
        }
        return DragGestureDetectorKt.m259horizontalDragjO51t88(awaitPointerEventScope, first.m2977getIdJ3iCeTQ(), draggableKt$awaitDrag$dragTick$1, continuation);
    }

    private static final long toOffset(float f, Orientation orientation) {
        return orientation == Orientation.Vertical ? OffsetKt.Offset(0.0f, f) : OffsetKt.Offset(f, 0.0f);
    }

    /* access modifiers changed from: private */
    /* renamed from: toFloat-3MmeM6k  reason: not valid java name */
    public static final float m270toFloat3MmeM6k(long j, Orientation orientation) {
        return orientation == Orientation.Vertical ? Offset.m1354getYimpl(j) : Offset.m1353getXimpl(j);
    }

    /* access modifiers changed from: private */
    /* renamed from: toFloat-sF-c-tU  reason: not valid java name */
    public static final float m271toFloatsFctU(long j, Orientation orientation) {
        return orientation == Orientation.Vertical ? Velocity.m4085getYimpl(j) : Velocity.m4084getXimpl(j);
    }

    public static final Modifier draggable(Modifier modifier, Function2<? super Composer, ? super Integer, ? extends PointerAwareDraggableState> function2, Function1<? super PointerInputChange, Boolean> function1, Orientation orientation, boolean z, MutableInteractionSource mutableInteractionSource, Function0<Boolean> function0, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> function32, boolean z2) {
        Modifier modifier2 = modifier;
        Intrinsics.checkNotNullParameter(modifier2, "<this>");
        Intrinsics.checkNotNullParameter(function2, "stateFactory");
        Intrinsics.checkNotNullParameter(function1, "canDrag");
        Intrinsics.checkNotNullParameter(orientation, ReactVideoView.EVENT_PROP_ORIENTATION);
        Intrinsics.checkNotNullParameter(function0, "startDragImmediately");
        Intrinsics.checkNotNullParameter(function3, "onDragStarted");
        Intrinsics.checkNotNullParameter(function32, "onDragStopped");
        return ComposedModifierKt.composed(modifier2, InspectableValueKt.isDebugInspectorInfoEnabled() ? new DraggableKt$draggable$$inlined$debugInspectorInfo$1(function1, orientation, z, z2, mutableInteractionSource, function0, function3, function32, function2) : InspectableValueKt.getNoInspectorInfo(), new DraggableKt$draggable$9(function2, mutableInteractionSource, function0, function1, function3, function32, orientation, z, z2));
    }
}
