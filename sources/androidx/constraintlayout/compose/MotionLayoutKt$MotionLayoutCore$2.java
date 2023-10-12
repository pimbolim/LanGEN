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
@DebugMetadata(c = "androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$2", f = "MotionLayout.kt", i = {}, l = {228, 238}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MotionLayout.kt */
public final class MotionLayoutKt$MotionLayoutCore$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $animateToEnd$delegate;
    final /* synthetic */ AnimationSpec<Float> $animationSpec;
    final /* synthetic */ Channel<ConstraintSet> $channel;
    final /* synthetic */ MutableState<ConstraintSet> $end$delegate;
    final /* synthetic */ Function0<Unit> $finishedAnimationListener;
    final /* synthetic */ Animatable<Float, AnimationVector1D> $progress;
    final /* synthetic */ MutableState<ConstraintSet> $start$delegate;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MotionLayoutKt$MotionLayoutCore$2(Channel<ConstraintSet> channel, Animatable<Float, AnimationVector1D> animatable, AnimationSpec<Float> animationSpec, Function0<Unit> function0, MutableState<Boolean> mutableState, MutableState<ConstraintSet> mutableState2, MutableState<ConstraintSet> mutableState3, Continuation<? super MotionLayoutKt$MotionLayoutCore$2> continuation) {
        super(2, continuation);
        this.$channel = channel;
        this.$progress = animatable;
        this.$animationSpec = animationSpec;
        this.$finishedAnimationListener = function0;
        this.$animateToEnd$delegate = mutableState;
        this.$start$delegate = mutableState2;
        this.$end$delegate = mutableState3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MotionLayoutKt$MotionLayoutCore$2(this.$channel, this.$progress, this.$animationSpec, this.$finishedAnimationListener, this.$animateToEnd$delegate, this.$start$delegate, this.$end$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MotionLayoutKt$MotionLayoutCore$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x002d
            if (r2 == r4) goto L_0x0022
            if (r2 != r3) goto L_0x001a
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            kotlin.ResultKt.throwOnFailure(r18)
            r5 = r0
            goto L_0x00b9
        L_0x001a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0022:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            kotlin.ResultKt.throwOnFailure(r18)
            r6 = r18
            r5 = r0
            goto L_0x0045
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r18)
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
            if (r6 == 0) goto L_0x00ce
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
            androidx.compose.runtime.MutableState<java.lang.Boolean> r7 = r5.$animateToEnd$delegate
            boolean r7 = androidx.constraintlayout.compose.MotionLayoutKt.m4182MotionLayoutCore$lambda16(r7)
            if (r7 == 0) goto L_0x006e
            r7 = 1065353216(0x3f800000, float:1.0)
            goto L_0x006f
        L_0x006e:
            r7 = 0
        L_0x006f:
            androidx.compose.runtime.MutableState<java.lang.Boolean> r8 = r5.$animateToEnd$delegate
            boolean r8 = androidx.constraintlayout.compose.MotionLayoutKt.m4182MotionLayoutCore$lambda16(r8)
            if (r8 == 0) goto L_0x007e
            androidx.compose.runtime.MutableState<androidx.constraintlayout.compose.ConstraintSet> r8 = r5.$start$delegate
            androidx.constraintlayout.compose.ConstraintSet r8 = androidx.constraintlayout.compose.MotionLayoutKt.m4186MotionLayoutCore$lambda8(r8)
            goto L_0x0084
        L_0x007e:
            androidx.compose.runtime.MutableState<androidx.constraintlayout.compose.ConstraintSet> r8 = r5.$end$delegate
            androidx.constraintlayout.compose.ConstraintSet r8 = androidx.constraintlayout.compose.MotionLayoutKt.m4180MotionLayoutCore$lambda11(r8)
        L_0x0084:
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r8)
            if (r8 != 0) goto L_0x0037
            androidx.compose.runtime.MutableState<java.lang.Boolean> r8 = r5.$animateToEnd$delegate
            boolean r8 = androidx.constraintlayout.compose.MotionLayoutKt.m4182MotionLayoutCore$lambda16(r8)
            if (r8 == 0) goto L_0x0098
            androidx.compose.runtime.MutableState<androidx.constraintlayout.compose.ConstraintSet> r8 = r5.$end$delegate
            androidx.constraintlayout.compose.MotionLayoutKt.m4181MotionLayoutCore$lambda12(r8, r6)
            goto L_0x009d
        L_0x0098:
            androidx.compose.runtime.MutableState<androidx.constraintlayout.compose.ConstraintSet> r8 = r5.$start$delegate
            androidx.constraintlayout.compose.MotionLayoutKt.m4187MotionLayoutCore$lambda9(r8, r6)
        L_0x009d:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r9 = r5.$progress
            java.lang.Float r10 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r7)
            androidx.compose.animation.core.AnimationSpec<java.lang.Float> r11 = r5.$animationSpec
            r12 = 0
            r13 = 0
            r14 = r5
            kotlin.coroutines.Continuation r14 = (kotlin.coroutines.Continuation) r14
            r15 = 12
            r16 = 0
            r5.L$0 = r2
            r5.label = r3
            java.lang.Object r6 = androidx.compose.animation.core.Animatable.animateTo$default(r9, r10, r11, r12, r13, r14, r15, r16)
            if (r6 != r1) goto L_0x00b9
            return r1
        L_0x00b9:
            androidx.compose.runtime.MutableState<java.lang.Boolean> r6 = r5.$animateToEnd$delegate
            boolean r7 = androidx.constraintlayout.compose.MotionLayoutKt.m4182MotionLayoutCore$lambda16(r6)
            r7 = r7 ^ r4
            androidx.constraintlayout.compose.MotionLayoutKt.m4183MotionLayoutCore$lambda17(r6, r7)
            kotlin.jvm.functions.Function0<kotlin.Unit> r6 = r5.$finishedAnimationListener
            if (r6 != 0) goto L_0x00c9
            goto L_0x0037
        L_0x00c9:
            r6.invoke()
            goto L_0x0037
        L_0x00ce:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.MotionLayoutKt$MotionLayoutCore$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
