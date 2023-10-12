package androidx.compose.foundation;

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
@DebugMetadata(c = "androidx.compose.foundation.ClickableKt$combinedClickable$4$gesture$1", f = "Clickable.kt", i = {}, l = {318}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Clickable.kt */
final class ClickableKt$combinedClickable$4$gesture$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State<Function0<Boolean>> $delayPressInteraction;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ boolean $hasDoubleClick;
    final /* synthetic */ boolean $hasLongClick;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ State<Function0<Unit>> $onClickState;
    final /* synthetic */ State<Function0<Unit>> $onDoubleClickState;
    final /* synthetic */ State<Function0<Unit>> $onLongClickState;
    final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ClickableKt$combinedClickable$4$gesture$1(boolean z, boolean z2, boolean z3, State<? extends Function0<Unit>> state, State<? extends Function0<Unit>> state2, MutableInteractionSource mutableInteractionSource, MutableState<PressInteraction.Press> mutableState, State<? extends Function0<Boolean>> state3, State<? extends Function0<Unit>> state4, Continuation<? super ClickableKt$combinedClickable$4$gesture$1> continuation) {
        super(2, continuation);
        this.$hasDoubleClick = z;
        this.$enabled = z2;
        this.$hasLongClick = z3;
        this.$onDoubleClickState = state;
        this.$onLongClickState = state2;
        this.$interactionSource = mutableInteractionSource;
        this.$pressedInteraction = mutableState;
        this.$delayPressInteraction = state3;
        this.$onClickState = state4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ClickableKt$combinedClickable$4$gesture$1 clickableKt$combinedClickable$4$gesture$1 = new ClickableKt$combinedClickable$4$gesture$1(this.$hasDoubleClick, this.$enabled, this.$hasLongClick, this.$onDoubleClickState, this.$onLongClickState, this.$interactionSource, this.$pressedInteraction, this.$delayPressInteraction, this.$onClickState, continuation);
        clickableKt$combinedClickable$4$gesture$1.L$0 = obj;
        return clickableKt$combinedClickable$4$gesture$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((ClickableKt$combinedClickable$4$gesture$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.ClickableKt$combinedClickable$4$gesture$1$3", f = "Clickable.kt", i = {}, l = {331}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.ClickableKt$combinedClickable$4$gesture$1$3  reason: invalid class name */
    /* compiled from: Clickable.kt */
    static final class AnonymousClass3 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        int label;

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m192invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m1363unboximpl(), (Continuation) obj3);
        }

        /* renamed from: invoke-d-4ec7I  reason: not valid java name */
        public final Object m192invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
            AnonymousClass3 r0 = new AnonymousClass3(z, mutableInteractionSource, mutableState, state3, continuation);
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
                    if (ClickableKt.m187handlePressInteractionEPk0efs(pressGestureScope, j, mutableInteractionSource, mutableState, state3, this) == coroutine_suspended) {
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
        Function1 function1;
        Function1 function12;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            if (!this.$hasDoubleClick || !this.$enabled) {
                function1 = null;
            } else {
                final State<Function0<Unit>> state = this.$onDoubleClickState;
                function1 = new Function1<Offset, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        m190invokek4lQ0M(((Offset) obj).m1363unboximpl());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                    public final void m190invokek4lQ0M(long j) {
                        Function0 value = state.getValue();
                        if (value != null) {
                            value.invoke();
                        }
                    }
                };
            }
            Function1 function13 = function1;
            if (!this.$hasLongClick || !this.$enabled) {
                function12 = null;
            } else {
                final State<Function0<Unit>> state2 = this.$onLongClickState;
                function12 = new Function1<Offset, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        m191invokek4lQ0M(((Offset) obj).m1363unboximpl());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                    public final void m191invokek4lQ0M(long j) {
                        Function0 value = state2.getValue();
                        if (value != null) {
                            value.invoke();
                        }
                    }
                };
            }
            final boolean z = this.$enabled;
            final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            final MutableState<PressInteraction.Press> mutableState = this.$pressedInteraction;
            final State<Function0<Boolean>> state3 = this.$delayPressInteraction;
            final boolean z2 = this.$enabled;
            final State<Function0<Unit>> state4 = this.$onClickState;
            this.label = 1;
            if (TapGestureDetectorKt.detectTapGestures(pointerInputScope, function13, function12, new AnonymousClass3((Continuation<? super AnonymousClass3>) null), new Function1<Offset, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m193invokek4lQ0M(((Offset) obj).m1363unboximpl());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                public final void m193invokek4lQ0M(long j) {
                    if (z2) {
                        state4.getValue().invoke();
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
