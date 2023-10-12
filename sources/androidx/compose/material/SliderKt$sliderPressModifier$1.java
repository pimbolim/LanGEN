package androidx.compose.material;

import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/PointerInputScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.SliderKt$sliderPressModifier$1", f = "Slider.kt", i = {}, l = {798}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Slider.kt */
final class SliderKt$sliderPressModifier$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DraggableState $draggableState;
    final /* synthetic */ State<Function1<Float, Unit>> $gestureEndAction;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ boolean $isRtl;
    final /* synthetic */ float $maxPx;
    final /* synthetic */ State<Float> $rawOffset;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SliderKt$sliderPressModifier$1(DraggableState draggableState, MutableInteractionSource mutableInteractionSource, State<? extends Function1<? super Float, Unit>> state, boolean z, float f, State<Float> state2, Continuation<? super SliderKt$sliderPressModifier$1> continuation) {
        super(2, continuation);
        this.$draggableState = draggableState;
        this.$interactionSource = mutableInteractionSource;
        this.$gestureEndAction = state;
        this.$isRtl = z;
        this.$maxPx = f;
        this.$rawOffset = state2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SliderKt$sliderPressModifier$1 sliderKt$sliderPressModifier$1 = new SliderKt$sliderPressModifier$1(this.$draggableState, this.$interactionSource, this.$gestureEndAction, this.$isRtl, this.$maxPx, this.$rawOffset, continuation);
        sliderKt$sliderPressModifier$1.L$0 = obj;
        return sliderKt$sliderPressModifier$1;
    }

    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
        return ((SliderKt$sliderPressModifier$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final DraggableState draggableState = this.$draggableState;
            final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            final State<Function1<Float, Unit>> state = this.$gestureEndAction;
            final boolean z = this.$isRtl;
            final float f = this.$maxPx;
            final State<Float> state2 = this.$rawOffset;
            this.label = 1;
            if (TapGestureDetectorKt.detectTapGestures$default((PointerInputScope) this.L$0, (Function1) null, (Function1) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), (Function1) null, this, 11, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/PressGestureScope;", "pos", "Landroidx/compose/ui/geometry/Offset;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.SliderKt$sliderPressModifier$1$1", f = "Slider.kt", i = {0, 0, 1, 1, 2}, l = {800, 805, 808, 818}, m = "invokeSuspend", n = {"$this$detectTapGestures", "pos", "$this$detectTapGestures", "interaction", "interaction"}, s = {"L$0", "J$0", "L$0", "L$1", "L$0"})
    /* renamed from: androidx.compose.material.SliderKt$sliderPressModifier$1$1  reason: invalid class name */
    /* compiled from: Slider.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
        /* synthetic */ long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m1105invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m1363unboximpl(), (Continuation) obj3);
        }

        /* renamed from: invoke-d-4ec7I  reason: not valid java name */
        public final Object m1105invoked4ec7I(PressGestureScope pressGestureScope, long j, Continuation<? super Unit> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(draggableState, mutableInteractionSource, state, z, f, state2, continuation);
            r0.L$0 = pressGestureScope;
            r0.J$0 = j;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x00ad A[Catch:{ CancellationException -> 0x00d6 }, RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00c6 A[Catch:{ CancellationException -> 0x00d6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00ce A[Catch:{ CancellationException -> 0x00d6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x00f1 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                r19 = this;
                r0 = r19
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                r7 = 0
                if (r2 == 0) goto L_0x0045
                if (r2 == r6) goto L_0x003b
                if (r2 == r5) goto L_0x002f
                if (r2 == r4) goto L_0x0024
                if (r2 != r3) goto L_0x001c
                kotlin.ResultKt.throwOnFailure(r20)
                goto L_0x00f2
            L_0x001c:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0024:
                java.lang.Object r2 = r0.L$0
                androidx.compose.foundation.interaction.PressInteraction$Press r2 = (androidx.compose.foundation.interaction.PressInteraction.Press) r2
                kotlin.ResultKt.throwOnFailure(r20)     // Catch:{ CancellationException -> 0x00d6 }
                r3 = r20
                goto L_0x00ae
            L_0x002f:
                java.lang.Object r2 = r0.L$1
                androidx.compose.foundation.interaction.PressInteraction$Press r2 = (androidx.compose.foundation.interaction.PressInteraction.Press) r2
                java.lang.Object r5 = r0.L$0
                androidx.compose.foundation.gestures.PressGestureScope r5 = (androidx.compose.foundation.gestures.PressGestureScope) r5
                kotlin.ResultKt.throwOnFailure(r20)
                goto L_0x009d
            L_0x003b:
                long r8 = r0.J$0
                java.lang.Object r2 = r0.L$0
                androidx.compose.foundation.gestures.PressGestureScope r2 = (androidx.compose.foundation.gestures.PressGestureScope) r2
                kotlin.ResultKt.throwOnFailure(r20)
                goto L_0x0081
            L_0x0045:
                kotlin.ResultKt.throwOnFailure(r20)
                java.lang.Object r2 = r0.L$0
                androidx.compose.foundation.gestures.PressGestureScope r2 = (androidx.compose.foundation.gestures.PressGestureScope) r2
                long r14 = r0.J$0
                androidx.compose.foundation.gestures.DraggableState r13 = r7
                androidx.compose.foundation.MutatePriority r11 = androidx.compose.foundation.MutatePriority.UserInput
                androidx.compose.material.SliderKt$sliderPressModifier$1$1$1 r16 = new androidx.compose.material.SliderKt$sliderPressModifier$1$1$1
                boolean r9 = r10
                float r10 = r11
                androidx.compose.runtime.State<java.lang.Float> r12 = r12
                r17 = 0
                r8 = r16
                r3 = r11
                r18 = r12
                r11 = r14
                r4 = r13
                r13 = r18
                r5 = r14
                r14 = r17
                r8.<init>(r9, r10, r11, r13, r14)
                r8 = r16
                kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
                r9 = r0
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                r0.L$0 = r2
                r0.J$0 = r5
                r10 = 1
                r0.label = r10
                java.lang.Object r3 = r4.drag(r3, r8, r9)
                if (r3 != r1) goto L_0x0080
                return r1
            L_0x0080:
                r8 = r5
            L_0x0081:
                r5 = r2
                androidx.compose.foundation.interaction.PressInteraction$Press r2 = new androidx.compose.foundation.interaction.PressInteraction$Press
                r2.<init>(r8, r7)
                androidx.compose.foundation.interaction.MutableInteractionSource r3 = r8
                r4 = r2
                androidx.compose.foundation.interaction.Interaction r4 = (androidx.compose.foundation.interaction.Interaction) r4
                r6 = r0
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r0.L$0 = r5
                r0.L$1 = r2
                r8 = 2
                r0.label = r8
                java.lang.Object r3 = r3.emit(r4, r6)
                if (r3 != r1) goto L_0x009d
                return r1
            L_0x009d:
                r3 = r0
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3     // Catch:{ CancellationException -> 0x00d6 }
                r0.L$0 = r2     // Catch:{ CancellationException -> 0x00d6 }
                r0.L$1 = r7     // Catch:{ CancellationException -> 0x00d6 }
                r4 = 3
                r0.label = r4     // Catch:{ CancellationException -> 0x00d6 }
                java.lang.Object r3 = r5.tryAwaitRelease(r3)     // Catch:{ CancellationException -> 0x00d6 }
                if (r3 != r1) goto L_0x00ae
                return r1
            L_0x00ae:
                java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ CancellationException -> 0x00d6 }
                boolean r3 = r3.booleanValue()     // Catch:{ CancellationException -> 0x00d6 }
                androidx.compose.runtime.State<kotlin.jvm.functions.Function1<java.lang.Float, kotlin.Unit>> r4 = r9     // Catch:{ CancellationException -> 0x00d6 }
                java.lang.Object r4 = r4.getValue()     // Catch:{ CancellationException -> 0x00d6 }
                kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4     // Catch:{ CancellationException -> 0x00d6 }
                r5 = 0
                java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)     // Catch:{ CancellationException -> 0x00d6 }
                r4.invoke(r5)     // Catch:{ CancellationException -> 0x00d6 }
                if (r3 == 0) goto L_0x00ce
                androidx.compose.foundation.interaction.PressInteraction$Release r3 = new androidx.compose.foundation.interaction.PressInteraction$Release     // Catch:{ CancellationException -> 0x00d6 }
                r3.<init>(r2)     // Catch:{ CancellationException -> 0x00d6 }
                androidx.compose.foundation.interaction.PressInteraction r3 = (androidx.compose.foundation.interaction.PressInteraction) r3     // Catch:{ CancellationException -> 0x00d6 }
                goto L_0x00dd
            L_0x00ce:
                androidx.compose.foundation.interaction.PressInteraction$Cancel r3 = new androidx.compose.foundation.interaction.PressInteraction$Cancel     // Catch:{ CancellationException -> 0x00d6 }
                r3.<init>(r2)     // Catch:{ CancellationException -> 0x00d6 }
                androidx.compose.foundation.interaction.PressInteraction r3 = (androidx.compose.foundation.interaction.PressInteraction) r3     // Catch:{ CancellationException -> 0x00d6 }
                goto L_0x00dd
            L_0x00d6:
                androidx.compose.foundation.interaction.PressInteraction$Cancel r3 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
                r3.<init>(r2)
                androidx.compose.foundation.interaction.PressInteraction r3 = (androidx.compose.foundation.interaction.PressInteraction) r3
            L_0x00dd:
                androidx.compose.foundation.interaction.MutableInteractionSource r2 = r8
                androidx.compose.foundation.interaction.Interaction r3 = (androidx.compose.foundation.interaction.Interaction) r3
                r4 = r0
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r0.L$0 = r7
                r0.L$1 = r7
                r5 = 4
                r0.label = r5
                java.lang.Object r2 = r2.emit(r3, r4)
                if (r2 != r1) goto L_0x00f2
                return r1
            L_0x00f2:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SliderKt$sliderPressModifier$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
