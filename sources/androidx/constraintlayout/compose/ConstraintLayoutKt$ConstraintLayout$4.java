package androidx.constraintlayout.compose;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "androidx.constraintlayout.compose.ConstraintLayoutKt$ConstraintLayout$4", f = "ConstraintLayout.kt", i = {}, l = {237, 246}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ConstraintLayout.kt */
public final class ConstraintLayoutKt$ConstraintLayout$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ Channel<ConstraintSet> $channel;
    final /* synthetic */ MutableState<Integer> $direction;
    final /* synthetic */ MutableState<ConstraintSet> $endConstraint$delegate;
    final /* synthetic */ Function0<Unit> $finishedAnimationListener;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $progress;
    final /* synthetic */ MutableState<ConstraintSet> $startConstraint$delegate;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConstraintLayoutKt$ConstraintLayout$4(Channel<ConstraintSet> channel, MutableState<Integer> mutableState, Animatable<Float, AnimationVector1D> animatable, AnimationSpec<Float> animationSpec, Function0<Unit> function0, MutableState<ConstraintSet> mutableState2, MutableState<ConstraintSet> mutableState3, Continuation<? super ConstraintLayoutKt$ConstraintLayout$4> continuation) {
        super(2, continuation);
        this.$channel = channel;
        this.$direction = mutableState;
        this.$progress = animatable;
        this.$animationSpec = animationSpec;
        this.$finishedAnimationListener = function0;
        this.$startConstraint$delegate = mutableState2;
        this.$endConstraint$delegate = mutableState3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConstraintLayoutKt$ConstraintLayout$4(this.$channel, this.$direction, this.$progress, this.$animationSpec, this.$finishedAnimationListener, this.$startConstraint$delegate, this.$endConstraint$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ConstraintLayoutKt$ConstraintLayout$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            r0 = r16
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x002d
            if (r2 == r4) goto L_0x0022
            if (r2 != r3) goto L_0x001a
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            kotlin.ResultKt.throwOnFailure(r17)
            r5 = r0
            goto L_0x00c5
        L_0x001a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0022:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            kotlin.ResultKt.throwOnFailure(r17)
            r6 = r17
            r5 = r0
            goto L_0x0045
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r17)
            kotlinx.coroutines.channels.Channel<androidx.constraintlayout.compose.ConstraintSet> r2 = r0.$channel
            kotlinx.coroutines.channels.ChannelIterator r2 = r2.iterator()
            r5 = r0
        L_0x0037:
            r6 = r5
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r5.L$0 = r2
            r5.label = r4
            java.lang.Object r6 = r2.hasNext(r6)
            if (r6 != r1) goto L_0x0045
            return r1
        L_0x0045:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x00e8
            java.lang.Object r6 = r2.next()
            androidx.constraintlayout.compose.ConstraintSet r6 = (androidx.constraintlayout.compose.ConstraintSet) r6
            kotlinx.coroutines.channels.Channel<androidx.constraintlayout.compose.ConstraintSet> r7 = r5.$channel
            java.lang.Object r7 = r7.m6174tryReceivePtdJZtk()
            java.lang.Object r7 = kotlinx.coroutines.channels.ChannelResult.m6159getOrNullimpl(r7)
            androidx.constraintlayout.compose.ConstraintSet r7 = (androidx.constraintlayout.compose.ConstraintSet) r7
            if (r7 != 0) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            r6 = r7
        L_0x0063:
            androidx.compose.runtime.MutableState<java.lang.Integer> r7 = r5.$direction
            java.lang.Object r7 = r7.getValue()
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            if (r7 != r4) goto L_0x0078
            androidx.compose.runtime.MutableState<androidx.constraintlayout.compose.ConstraintSet> r7 = r5.$startConstraint$delegate
            androidx.constraintlayout.compose.ConstraintSet r7 = androidx.constraintlayout.compose.ConstraintLayoutKt.m4153ConstraintLayout$lambda6(r7)
            goto L_0x007e
        L_0x0078:
            androidx.compose.runtime.MutableState<androidx.constraintlayout.compose.ConstraintSet> r7 = r5.$endConstraint$delegate
            androidx.constraintlayout.compose.ConstraintSet r7 = androidx.constraintlayout.compose.ConstraintLayoutKt.m4155ConstraintLayout$lambda9(r7)
        L_0x007e:
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r7 != 0) goto L_0x0037
            androidx.compose.runtime.MutableState<java.lang.Integer> r7 = r5.$direction
            java.lang.Object r7 = r7.getValue()
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            if (r7 != r4) goto L_0x0098
            androidx.compose.runtime.MutableState<androidx.constraintlayout.compose.ConstraintSet> r7 = r5.$endConstraint$delegate
            androidx.constraintlayout.compose.ConstraintLayoutKt.m4152ConstraintLayout$lambda10(r7, r6)
            goto L_0x009d
        L_0x0098:
            androidx.compose.runtime.MutableState<androidx.constraintlayout.compose.ConstraintSet> r7 = r5.$startConstraint$delegate
            androidx.constraintlayout.compose.ConstraintLayoutKt.m4154ConstraintLayout$lambda7(r7, r6)
        L_0x009d:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r8 = r5.$progress
            androidx.compose.runtime.MutableState<java.lang.Integer> r6 = r5.$direction
            java.lang.Object r6 = r6.getValue()
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            float r6 = (float) r6
            java.lang.Float r9 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r6)
            androidx.compose.animation.core.AnimationSpec<java.lang.Float> r10 = r5.$animationSpec
            r11 = 0
            r12 = 0
            r13 = r5
            kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
            r14 = 12
            r15 = 0
            r5.L$0 = r2
            r5.label = r3
            java.lang.Object r6 = androidx.compose.animation.core.Animatable.animateTo$default(r8, r9, r10, r11, r12, r13, r14, r15)
            if (r6 != r1) goto L_0x00c5
            return r1
        L_0x00c5:
            androidx.compose.runtime.MutableState<java.lang.Integer> r6 = r5.$direction
            java.lang.Object r7 = r6.getValue()
            java.lang.Number r7 = (java.lang.Number) r7
            int r7 = r7.intValue()
            if (r7 != r4) goto L_0x00d5
            r7 = 0
            goto L_0x00d6
        L_0x00d5:
            r7 = 1
        L_0x00d6:
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            r6.setValue(r7)
            kotlin.jvm.functions.Function0<kotlin.Unit> r6 = r5.$finishedAnimationListener
            if (r6 != 0) goto L_0x00e3
            goto L_0x0037
        L_0x00e3:
            r6.invoke()
            goto L_0x0037
        L_0x00e8:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.ConstraintLayoutKt$ConstraintLayout$4.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
