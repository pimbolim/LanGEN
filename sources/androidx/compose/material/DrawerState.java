package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J'\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00110 H@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0011\u0010\"\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0011\u0010$\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0019\u0010%\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010&R\u0011\u0010\b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0011\u0010\u000e\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108GX\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u00038GX\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Landroidx/compose/material/DrawerState;", "", "initialValue", "Landroidx/compose/material/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material/DrawerValue;Lkotlin/jvm/functions/Function1;)V", "currentValue", "getCurrentValue", "()Landroidx/compose/material/DrawerValue;", "isAnimationRunning", "()Z", "isClosed", "isOpen", "offset", "Landroidx/compose/runtime/State;", "", "getOffset$annotations", "()V", "getOffset", "()Landroidx/compose/runtime/State;", "swipeableState", "Landroidx/compose/material/SwipeableState;", "getSwipeableState$material_release", "()Landroidx/compose/material/SwipeableState;", "targetValue", "getTargetValue$annotations", "getTargetValue", "animateTo", "", "anim", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material/DrawerValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "open", "snapTo", "(Landroidx/compose/material/DrawerValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Drawer.kt */
public final class DrawerState {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final SwipeableState<DrawerValue> swipeableState;

    @ExperimentalMaterialApi
    public static /* synthetic */ void getOffset$annotations() {
    }

    @ExperimentalMaterialApi
    public static /* synthetic */ void getTargetValue$annotations() {
    }

    public DrawerState(DrawerValue drawerValue, Function1<? super DrawerValue, Boolean> function1) {
        Intrinsics.checkNotNullParameter(drawerValue, "initialValue");
        Intrinsics.checkNotNullParameter(function1, "confirmStateChange");
        this.swipeableState = new SwipeableState<>(drawerValue, DrawerKt.AnimationSpec, function1);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DrawerState(DrawerValue drawerValue, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawerValue, (i & 2) != 0 ? AnonymousClass1.INSTANCE : function1);
    }

    public final SwipeableState<DrawerValue> getSwipeableState$material_release() {
        return this.swipeableState;
    }

    public final boolean isOpen() {
        return getCurrentValue() == DrawerValue.Open;
    }

    public final boolean isClosed() {
        return getCurrentValue() == DrawerValue.Closed;
    }

    public final DrawerValue getCurrentValue() {
        return this.swipeableState.getCurrentValue();
    }

    public final boolean isAnimationRunning() {
        return this.swipeableState.isAnimationRunning();
    }

    public final Object open(Continuation<? super Unit> continuation) {
        Object animateTo = animateTo(DrawerValue.Open, DrawerKt.AnimationSpec, continuation);
        return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
    }

    public final Object close(Continuation<? super Unit> continuation) {
        Object animateTo = animateTo(DrawerValue.Closed, DrawerKt.AnimationSpec, continuation);
        return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
    }

    @ExperimentalMaterialApi
    public final Object animateTo(DrawerValue drawerValue, AnimationSpec<Float> animationSpec, Continuation<? super Unit> continuation) {
        Object animateTo = getSwipeableState$material_release().animateTo(drawerValue, animationSpec, continuation);
        return animateTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? animateTo : Unit.INSTANCE;
    }

    @ExperimentalMaterialApi
    public final Object snapTo(DrawerValue drawerValue, Continuation<? super Unit> continuation) {
        Object snapTo = getSwipeableState$material_release().snapTo(drawerValue, continuation);
        return snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? snapTo : Unit.INSTANCE;
    }

    @ExperimentalMaterialApi
    public final DrawerValue getTargetValue() {
        return this.swipeableState.getTargetValue();
    }

    @ExperimentalMaterialApi
    public final State<Float> getOffset() {
        return this.swipeableState.getOffset();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¨\u0006\n"}, d2 = {"Landroidx/compose/material/DrawerState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/DrawerState;", "Landroidx/compose/material/DrawerValue;", "confirmStateChange", "Lkotlin/Function1;", "", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Drawer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Saver<DrawerState, DrawerValue> Saver(Function1<? super DrawerValue, Boolean> function1) {
            Intrinsics.checkNotNullParameter(function1, "confirmStateChange");
            return SaverKt.Saver(DrawerState$Companion$Saver$1.INSTANCE, new DrawerState$Companion$Saver$2(function1));
        }
    }
}
