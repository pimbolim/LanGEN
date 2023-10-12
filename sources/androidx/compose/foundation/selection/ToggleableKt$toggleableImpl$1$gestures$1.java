package androidx.compose.foundation.selection;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.selection.ToggleableKt$toggleableImpl$1$gestures$1", f = "Toggleable.kt", i = {}, l = {270}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Toggleable.kt */
final class ToggleableKt$toggleableImpl$1$gestures$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function0<Boolean>> $delayPressInteraction;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ State<Function0<Unit>> $onClickState;
    final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ToggleableKt$toggleableImpl$1$gestures$1(boolean z, MutableInteractionSource mutableInteractionSource, MutableState<PressInteraction.Press> mutableState, State<? extends Function0<Boolean>> state, State<? extends Function0<Unit>> state2, Continuation<? super ToggleableKt$toggleableImpl$1$gestures$1> continuation) {
        super(2, continuation);
        this.$enabled = z;
        this.$interactionSource = mutableInteractionSource;
        this.$pressedInteraction = mutableState;
        this.$delayPressInteraction = state;
        this.$onClickState = state2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ToggleableKt$toggleableImpl$1$gestures$1 toggleableKt$toggleableImpl$1$gestures$1 = new ToggleableKt$toggleableImpl$1$gestures$1(this.$enabled, this.$interactionSource, this.$pressedInteraction, this.$delayPressInteraction, this.$onClickState, continuation);
        toggleableKt$toggleableImpl$1$gestures$1.L$0 = obj;
        return toggleableKt$toggleableImpl$1$gestures$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((ToggleableKt$toggleableImpl$1$gestures$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.selection.ToggleableKt$toggleableImpl$1$gestures$1$1", f = "Toggleable.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.selection.ToggleableKt$toggleableImpl$1$gestures$1$1  reason: invalid class name */
    /* compiled from: Toggleable.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m591invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m1363unboximpl(), (Continuation) obj3);
        }

        /* renamed from: invoke-d-4ec7I  reason: not valid java name */
        public final Object m591invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(z, mutableInteractionSource, mutableState, state, continuation);
            r0.L$0 = pressGestureScope;
            r0.J$0 = j;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                long j = this.J$0;
                if (z) {
                    this.label = 1;
                    if (ClickableKt.m187handlePressInteractionEPk0efs(pressGestureScope, j, mutableInteractionSource, mutableState, state, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final boolean z = this.$enabled;
            final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            final MutableState<PressInteraction.Press> mutableState = this.$pressedInteraction;
            final State<Function0<Boolean>> state = this.$delayPressInteraction;
            final boolean z2 = this.$enabled;
            final State<Function0<Unit>> state2 = this.$onClickState;
            this.label = 1;
            if (TapGestureDetectorKt.detectTapAndPress((PointerInputScope) this.L$0, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), new Function1<Offset, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m592invokek4lQ0M(((Offset) obj).m1363unboximpl());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                public final void m592invokek4lQ0M(long j) {
                    if (z2) {
                        state2.getValue().invoke();
                    }
                }
            }, this) == coroutine_suspended) {
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
