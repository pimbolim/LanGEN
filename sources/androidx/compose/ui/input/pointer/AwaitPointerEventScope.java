package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0013H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0014JH\u0010\u0015\u001a\u0002H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0017\u001a\u00020\u00182'\u0010\u0019\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001a¢\u0006\u0002\b\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJJ\u0010\u001f\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0017\u001a\u00020\u00182'\u0010\u0019\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001a¢\u0006\u0002\b\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001d\u0010\u0006\u001a\u00020\u00078VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000bX¦\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\f\u0010\tR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Landroidx/compose/ui/unit/Density;", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "getCurrentEvent", "()Landroidx/compose/ui/input/pointer/PointerEvent;", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "()J", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeout", "T", "timeMillis", "", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SuspendingPointerInputFilter.kt */
public interface AwaitPointerEventScope extends Density {
    Object awaitPointerEvent(PointerEventPass pointerEventPass, Continuation<? super PointerEvent> continuation);

    PointerEvent getCurrentEvent();

    /* renamed from: getExtendedTouchPadding-NH-jbRc  reason: not valid java name */
    long m2895getExtendedTouchPaddingNHjbRc();

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    long m2896getSizeYbymL2g();

    ViewConfiguration getViewConfiguration();

    <T> Object withTimeout(long j, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation);

    <T> Object withTimeoutOrNull(long j, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SuspendingPointerInputFilter.kt */
    public static final class DefaultImpls {
        /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
        public static int m2898roundToPxR2X_6o(AwaitPointerEventScope awaitPointerEventScope, long j) {
            Intrinsics.checkNotNullParameter(awaitPointerEventScope, "this");
            return Density.DefaultImpls.m3833roundToPxR2X_6o(awaitPointerEventScope, j);
        }

        /* renamed from: roundToPx-0680j_4  reason: not valid java name */
        public static int m2899roundToPx0680j_4(AwaitPointerEventScope awaitPointerEventScope, float f) {
            Intrinsics.checkNotNullParameter(awaitPointerEventScope, "this");
            return Density.DefaultImpls.m3834roundToPx0680j_4(awaitPointerEventScope, f);
        }

        /* renamed from: toDp-GaN1DYA  reason: not valid java name */
        public static float m2900toDpGaN1DYA(AwaitPointerEventScope awaitPointerEventScope, long j) {
            Intrinsics.checkNotNullParameter(awaitPointerEventScope, "this");
            return Density.DefaultImpls.m3835toDpGaN1DYA(awaitPointerEventScope, j);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m2901toDpu2uoSUM(AwaitPointerEventScope awaitPointerEventScope, float f) {
            Intrinsics.checkNotNullParameter(awaitPointerEventScope, "this");
            return Density.DefaultImpls.m3836toDpu2uoSUM((Density) awaitPointerEventScope, f);
        }

        /* renamed from: toDp-u2uoSUM  reason: not valid java name */
        public static float m2902toDpu2uoSUM(AwaitPointerEventScope awaitPointerEventScope, int i) {
            Intrinsics.checkNotNullParameter(awaitPointerEventScope, "this");
            return Density.DefaultImpls.m3837toDpu2uoSUM((Density) awaitPointerEventScope, i);
        }

        /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
        public static long m2903toDpSizekrfVVM(AwaitPointerEventScope awaitPointerEventScope, long j) {
            Intrinsics.checkNotNullParameter(awaitPointerEventScope, "this");
            return Density.DefaultImpls.m3838toDpSizekrfVVM(awaitPointerEventScope, j);
        }

        /* renamed from: toPx--R2X_6o  reason: not valid java name */
        public static float m2904toPxR2X_6o(AwaitPointerEventScope awaitPointerEventScope, long j) {
            Intrinsics.checkNotNullParameter(awaitPointerEventScope, "this");
            return Density.DefaultImpls.m3839toPxR2X_6o(awaitPointerEventScope, j);
        }

        /* renamed from: toPx-0680j_4  reason: not valid java name */
        public static float m2905toPx0680j_4(AwaitPointerEventScope awaitPointerEventScope, float f) {
            Intrinsics.checkNotNullParameter(awaitPointerEventScope, "this");
            return Density.DefaultImpls.m3840toPx0680j_4(awaitPointerEventScope, f);
        }

        public static Rect toRect(AwaitPointerEventScope awaitPointerEventScope, DpRect dpRect) {
            Intrinsics.checkNotNullParameter(awaitPointerEventScope, "this");
            Intrinsics.checkNotNullParameter(dpRect, "receiver");
            return Density.DefaultImpls.toRect(awaitPointerEventScope, dpRect);
        }

        /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
        public static long m2906toSizeXkaWNTQ(AwaitPointerEventScope awaitPointerEventScope, long j) {
            Intrinsics.checkNotNullParameter(awaitPointerEventScope, "this");
            return Density.DefaultImpls.m3841toSizeXkaWNTQ(awaitPointerEventScope, j);
        }

        /* renamed from: toSp-0xMU5do  reason: not valid java name */
        public static long m2907toSp0xMU5do(AwaitPointerEventScope awaitPointerEventScope, float f) {
            Intrinsics.checkNotNullParameter(awaitPointerEventScope, "this");
            return Density.DefaultImpls.m3842toSp0xMU5do(awaitPointerEventScope, f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m2908toSpkPz2Gy4(AwaitPointerEventScope awaitPointerEventScope, float f) {
            Intrinsics.checkNotNullParameter(awaitPointerEventScope, "this");
            return Density.DefaultImpls.m3843toSpkPz2Gy4((Density) awaitPointerEventScope, f);
        }

        /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
        public static long m2909toSpkPz2Gy4(AwaitPointerEventScope awaitPointerEventScope, int i) {
            Intrinsics.checkNotNullParameter(awaitPointerEventScope, "this");
            return Density.DefaultImpls.m3844toSpkPz2Gy4((Density) awaitPointerEventScope, i);
        }

        /* renamed from: getExtendedTouchPadding-NH-jbRc  reason: not valid java name */
        public static long m2897getExtendedTouchPaddingNHjbRc(AwaitPointerEventScope awaitPointerEventScope) {
            Intrinsics.checkNotNullParameter(awaitPointerEventScope, "this");
            return Size.Companion.m1431getZeroNHjbRc();
        }

        public static /* synthetic */ Object awaitPointerEvent$default(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    pointerEventPass = PointerEventPass.Main;
                }
                return awaitPointerEventScope.awaitPointerEvent(pointerEventPass, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitPointerEvent");
        }

        public static <T> Object withTimeoutOrNull(AwaitPointerEventScope awaitPointerEventScope, long j, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
            return function2.invoke(awaitPointerEventScope, continuation);
        }

        public static <T> Object withTimeout(AwaitPointerEventScope awaitPointerEventScope, long j, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
            return function2.invoke(awaitPointerEventScope, continuation);
        }
    }
}
