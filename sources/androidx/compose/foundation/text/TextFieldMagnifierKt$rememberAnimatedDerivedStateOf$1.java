package androidx.compose.foundation.text;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.TextFieldMagnifierKt$rememberAnimatedDerivedStateOf$1", f = "TextFieldMagnifier.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TextFieldMagnifier.kt */
final class TextFieldMagnifierKt$rememberAnimatedDerivedStateOf$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Animatable<T, V> $animatable;
    final /* synthetic */ AnimationSpec<T> $animationSpec;
    final /* synthetic */ State<T> $targetValue$delegate;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextFieldMagnifierKt$rememberAnimatedDerivedStateOf$1(State<? extends T> state, Animatable<T, V> animatable, AnimationSpec<T> animationSpec, Continuation<? super TextFieldMagnifierKt$rememberAnimatedDerivedStateOf$1> continuation) {
        super(2, continuation);
        this.$targetValue$delegate = state;
        this.$animatable = animatable;
        this.$animationSpec = animationSpec;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TextFieldMagnifierKt$rememberAnimatedDerivedStateOf$1(this.$targetValue$delegate, this.$animatable, this.$animationSpec, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TextFieldMagnifierKt$rememberAnimatedDerivedStateOf$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.text.TextFieldMagnifierKt$rememberAnimatedDerivedStateOf$1$2", f = "TextFieldMagnifier.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.text.TextFieldMagnifierKt$rememberAnimatedDerivedStateOf$1$2  reason: invalid class name */
    /* compiled from: TextFieldMagnifier.kt */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<T, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 r0 = new AnonymousClass2(animatable, animationSpec, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(T t, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(t, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Object obj2 = this.L$0;
                this.label = 1;
                if (Animatable.animateTo$default(animatable, obj2, animationSpec, (Object) null, (Function1) null, this, 12, (Object) null) == coroutine_suspended) {
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

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final State<T> state = this.$targetValue$delegate;
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<T>() {
                public final T invoke() {
                    return TextFieldMagnifierKt.m709rememberAnimatedDerivedStateOf$lambda1(state);
                }
            });
            final Animatable<T, V> animatable = this.$animatable;
            final AnimationSpec<T> animationSpec = this.$animationSpec;
            this.label = 1;
            if (FlowKt.collectLatest(snapshotFlow, new AnonymousClass2((Continuation<? super AnonymousClass2>) null), this) == coroutine_suspended) {
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
