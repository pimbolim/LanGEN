package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import com.brentvatne.react.ReactVideoView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0002\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ!\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H@ø\u0001\u0000¢\u0006\u0002\u0010%J\u001b\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*J\u0006\u0010+\u001a\u00020\u0005J1\u0010,\u001a\u00020$*\u00020-2\u0006\u0010.\u001a\u00020$2\b\u0010/\u001a\u0004\u0018\u00010'2\u0006\u00100\u001a\u000201ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103J\n\u00104\u001a\u00020$*\u00020$J\u0017\u00105\u001a\u00020$*\u00020'ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u00107J\u0017\u00105\u001a\u00020$*\u00020\u001dø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00107J\u001a\u00109\u001a\u00020'*\u00020$ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b:\u0010;J\u001a\u0010<\u001a\u00020\u001d*\u00020$ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b=\u0010;J\u001f\u0010>\u001a\u00020\u001d*\u00020\u001d2\u0006\u0010?\u001a\u00020$ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b@\u0010AR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseDirection", "", "nestedScrollDispatcher", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "overScrollController", "Landroidx/compose/foundation/gestures/OverScrollController;", "(Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/runtime/State;Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/gestures/OverScrollController;)V", "getFlingBehavior", "()Landroidx/compose/foundation/gestures/FlingBehavior;", "getNestedScrollDispatcher", "()Landroidx/compose/runtime/State;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getOverScrollController", "()Landroidx/compose/foundation/gestures/OverScrollController;", "getReverseDirection", "()Z", "getScrollableState", "()Landroidx/compose/foundation/gestures/ScrollableState;", "doFlingAnimation", "Landroidx/compose/ui/unit/Velocity;", "available", "doFlingAnimation-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStopped", "", "axisVelocity", "", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performRawScroll", "Landroidx/compose/ui/geometry/Offset;", "scroll", "performRawScroll-MK-Hz9U", "(J)J", "shouldScrollImmediately", "dispatchScroll", "Landroidx/compose/foundation/gestures/ScrollScope;", "scrollDelta", "pointerPosition", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "dispatchScroll-iGfEq8s", "(Landroidx/compose/foundation/gestures/ScrollScope;FLandroidx/compose/ui/geometry/Offset;I)F", "reverseIfNeeded", "toFloat", "toFloat-k-4lQ0M", "(J)F", "toFloat-TH1AsA0", "toOffset", "toOffset-tuRUvjQ", "(F)J", "toVelocity", "toVelocity-adjELrA", "update", "newValue", "update-QWom1Mo", "(JF)J", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Scrollable.kt */
final class ScrollingLogic {
    private final FlingBehavior flingBehavior;
    private final State<NestedScrollDispatcher> nestedScrollDispatcher;
    private final Orientation orientation;
    private final OverScrollController overScrollController;
    private final boolean reverseDirection;
    private final ScrollableState scrollableState;

    public ScrollingLogic(Orientation orientation2, boolean z, State<NestedScrollDispatcher> state, ScrollableState scrollableState2, FlingBehavior flingBehavior2, OverScrollController overScrollController2) {
        Intrinsics.checkNotNullParameter(orientation2, ReactVideoView.EVENT_PROP_ORIENTATION);
        Intrinsics.checkNotNullParameter(state, "nestedScrollDispatcher");
        Intrinsics.checkNotNullParameter(scrollableState2, "scrollableState");
        Intrinsics.checkNotNullParameter(flingBehavior2, "flingBehavior");
        this.orientation = orientation2;
        this.reverseDirection = z;
        this.nestedScrollDispatcher = state;
        this.scrollableState = scrollableState2;
        this.flingBehavior = flingBehavior2;
        this.overScrollController = overScrollController2;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final boolean getReverseDirection() {
        return this.reverseDirection;
    }

    public final State<NestedScrollDispatcher> getNestedScrollDispatcher() {
        return this.nestedScrollDispatcher;
    }

    public final ScrollableState getScrollableState() {
        return this.scrollableState;
    }

    public final FlingBehavior getFlingBehavior() {
        return this.flingBehavior;
    }

    public final OverScrollController getOverScrollController() {
        return this.overScrollController;
    }

    /* renamed from: toOffset-tuRUvjQ  reason: not valid java name */
    public final long m318toOffsettuRUvjQ(float f) {
        if (f == 0.0f) {
            return Offset.Companion.m1369getZeroF1C5BW0();
        }
        if (this.orientation == Orientation.Horizontal) {
            return OffsetKt.Offset(f, 0.0f);
        }
        return OffsetKt.Offset(0.0f, f);
    }

    /* renamed from: toVelocity-adjELrA  reason: not valid java name */
    public final long m319toVelocityadjELrA(float f) {
        return this.orientation == Orientation.Horizontal ? VelocityKt.Velocity(f, 0.0f) : VelocityKt.Velocity(0.0f, f);
    }

    /* renamed from: toFloat-k-4lQ0M  reason: not valid java name */
    public final float m317toFloatk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m1353getXimpl(j) : Offset.m1354getYimpl(j);
    }

    /* renamed from: toFloat-TH1AsA0  reason: not valid java name */
    public final float m316toFloatTH1AsA0(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m4084getXimpl(j) : Velocity.m4085getYimpl(j);
    }

    /* renamed from: update-QWom1Mo  reason: not valid java name */
    public final long m320updateQWom1Mo(long j, float f) {
        return this.orientation == Orientation.Horizontal ? Velocity.m4080copyOhffZ5M$default(j, f, 0.0f, 2, (Object) null) : Velocity.m4080copyOhffZ5M$default(j, 0.0f, f, 1, (Object) null);
    }

    public final float reverseIfNeeded(float f) {
        return this.reverseDirection ? f * ((float) -1) : f;
    }

    /* renamed from: dispatchScroll-iGfEq8s  reason: not valid java name */
    public final float m313dispatchScrolliGfEq8s(ScrollScope scrollScope, float f, Offset offset, int i) {
        float f2;
        Intrinsics.checkNotNullParameter(scrollScope, "$receiver");
        OverScrollController overScrollController2 = this.overScrollController;
        if (overScrollController2 == null) {
            f2 = 0.0f;
        } else {
            f2 = m317toFloatk4lQ0M(overScrollController2.m281consumePreScrollA0NYTsA(m318toOffsettuRUvjQ(f), offset, i));
        }
        float f3 = f - f2;
        NestedScrollDispatcher value = this.nestedScrollDispatcher.getValue();
        float r12 = f3 - m317toFloatk4lQ0M(value.m2879dispatchPreScrollOzD1aCk(m318toOffsettuRUvjQ(f3), i));
        float reverseIfNeeded = reverseIfNeeded(scrollScope.scrollBy(reverseIfNeeded(r12)));
        float f4 = r12 - reverseIfNeeded;
        long r1 = value.m2877dispatchPostScrollDzOQY0M(m318toOffsettuRUvjQ(reverseIfNeeded), m318toOffsettuRUvjQ(f4), i);
        OverScrollController overScrollController3 = this.overScrollController;
        if (overScrollController3 != null) {
            overScrollController3.m279consumePostScrolll7mfB5k(m318toOffsettuRUvjQ(r12), m318toOffsettuRUvjQ(f4 - m317toFloatk4lQ0M(r1)), offset, i);
        }
        return f4;
    }

    /* renamed from: performRawScroll-MK-Hz9U  reason: not valid java name */
    public final long m315performRawScrollMKHz9U(long j) {
        if (this.scrollableState.isScrollInProgress()) {
            return Offset.Companion.m1369getZeroF1C5BW0();
        }
        return m318toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m317toFloatk4lQ0M(j)))));
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object onDragStopped(float r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1
            r0.<init>(r9, r11)
        L_0x0019:
            r6 = r0
            java.lang.Object r11 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0054
            if (r1 == r4) goto L_0x004a
            if (r1 == r3) goto L_0x0040
            if (r1 != r2) goto L_0x0038
            long r0 = r6.J$0
            java.lang.Object r10 = r6.L$0
            androidx.compose.foundation.gestures.ScrollingLogic r10 = (androidx.compose.foundation.gestures.ScrollingLogic) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00c7
        L_0x0038:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0040:
            long r3 = r6.J$0
            java.lang.Object r10 = r6.L$0
            androidx.compose.foundation.gestures.ScrollingLogic r10 = (androidx.compose.foundation.gestures.ScrollingLogic) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00a2
        L_0x004a:
            long r4 = r6.J$0
            java.lang.Object r10 = r6.L$0
            androidx.compose.foundation.gestures.ScrollingLogic r10 = (androidx.compose.foundation.gestures.ScrollingLogic) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x008a
        L_0x0054:
            kotlin.ResultKt.throwOnFailure(r11)
            androidx.compose.foundation.gestures.OverScrollController r11 = r9.getOverScrollController()
            if (r11 != 0) goto L_0x005f
            r11 = 0
            goto L_0x006b
        L_0x005f:
            long r7 = r9.m319toVelocityadjELrA(r10)
            long r7 = r11.m280consumePreFlingAH228Gc(r7)
            float r11 = r9.m316toFloatTH1AsA0(r7)
        L_0x006b:
            float r10 = r10 - r11
            long r10 = r9.m319toVelocityadjELrA(r10)
            androidx.compose.runtime.State r1 = r9.getNestedScrollDispatcher()
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r1 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher) r1
            r6.L$0 = r9
            r6.J$0 = r10
            r6.label = r4
            java.lang.Object r1 = r1.m2878dispatchPreFlingQWom1Mo(r10, r6)
            if (r1 != r0) goto L_0x0087
            return r0
        L_0x0087:
            r4 = r10
            r11 = r1
            r10 = r9
        L_0x008a:
            androidx.compose.ui.unit.Velocity r11 = (androidx.compose.ui.unit.Velocity) r11
            long r7 = r11.m4093unboximpl()
            long r4 = androidx.compose.ui.unit.Velocity.m4087minusAH228Gc(r4, r7)
            r6.L$0 = r10
            r6.J$0 = r4
            r6.label = r3
            java.lang.Object r11 = r10.m314doFlingAnimationQWom1Mo(r4, r6)
            if (r11 != r0) goto L_0x00a1
            return r0
        L_0x00a1:
            r3 = r4
        L_0x00a2:
            androidx.compose.ui.unit.Velocity r11 = (androidx.compose.ui.unit.Velocity) r11
            long r7 = r11.m4093unboximpl()
            androidx.compose.runtime.State r11 = r10.getNestedScrollDispatcher()
            java.lang.Object r11 = r11.getValue()
            r1 = r11
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r1 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher) r1
            long r3 = androidx.compose.ui.unit.Velocity.m4087minusAH228Gc(r3, r7)
            r6.L$0 = r10
            r6.J$0 = r7
            r6.label = r2
            r2 = r3
            r4 = r7
            java.lang.Object r11 = r1.m2876dispatchPostFlingRZ2iAVY(r2, r4, r6)
            if (r11 != r0) goto L_0x00c6
            return r0
        L_0x00c6:
            r0 = r7
        L_0x00c7:
            androidx.compose.ui.unit.Velocity r11 = (androidx.compose.ui.unit.Velocity) r11
            long r2 = r11.m4093unboximpl()
            long r0 = androidx.compose.ui.unit.Velocity.m4087minusAH228Gc(r0, r2)
            androidx.compose.foundation.gestures.OverScrollController r11 = r10.getOverScrollController()
            if (r11 != 0) goto L_0x00d8
            goto L_0x00e3
        L_0x00d8:
            float r0 = r10.m316toFloatTH1AsA0(r0)
            long r0 = r10.m319toVelocityadjELrA(r0)
            r11.m278consumePostFlingTH1AsA0(r0)
        L_0x00e3:
            androidx.compose.foundation.gestures.OverScrollController r10 = r10.getOverScrollController()
            if (r10 != 0) goto L_0x00ea
            goto L_0x00ed
        L_0x00ea:
            r10.release()
        L_0x00ed:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.onDragStopped(float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: doFlingAnimation-QWom1Mo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m314doFlingAnimationQWom1Mo(long r13, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            r0.<init>(r12, r15)
        L_0x0019:
            r4 = r0
            java.lang.Object r15 = r4.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            java.lang.Object r13 = r4.L$0
            kotlin.jvm.internal.Ref$LongRef r13 = (kotlin.jvm.internal.Ref.LongRef) r13
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0063
        L_0x002f:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r15)
            kotlin.jvm.internal.Ref$LongRef r15 = new kotlin.jvm.internal.Ref$LongRef
            r15.<init>()
            r15.element = r13
            androidx.compose.foundation.gestures.ScrollableState r1 = r12.getScrollableState()
            r3 = 0
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2 r11 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2
            r10 = 0
            r5 = r11
            r6 = r12
            r7 = r15
            r8 = r13
            r5.<init>(r6, r7, r8, r10)
            r13 = r11
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            r5 = 1
            r6 = 0
            r4.L$0 = r15
            r4.label = r2
            r2 = r3
            r3 = r13
            java.lang.Object r13 = androidx.compose.foundation.gestures.ScrollableState.DefaultImpls.scroll$default(r1, r2, r3, r4, r5, r6)
            if (r13 != r0) goto L_0x0062
            return r0
        L_0x0062:
            r13 = r15
        L_0x0063:
            long r13 = r13.element
            androidx.compose.ui.unit.Velocity r13 = androidx.compose.ui.unit.Velocity.m4075boximpl(r13)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m314doFlingAnimationQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean shouldScrollImmediately() {
        if (!this.scrollableState.isScrollInProgress()) {
            OverScrollController overScrollController2 = this.overScrollController;
            if (overScrollController2 == null ? false : overScrollController2.stopOverscrollAnimation()) {
                return true;
            }
            return false;
        }
        return true;
    }
}
