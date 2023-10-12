package androidx.compose.ui.platform;

import androidx.compose.runtime.Recomposer;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareViewTreeRecomposer$2$onStateChanged$1", f = "WindowRecomposer.android.kt", i = {}, l = {270}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: WindowRecomposer.android.kt */
final class WindowRecomposer_androidKt$createLifecycleAwareViewTreeRecomposer$2$onStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ Recomposer $recomposer;
    final /* synthetic */ WindowRecomposer_androidKt$createLifecycleAwareViewTreeRecomposer$2 $self;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WindowRecomposer_androidKt$createLifecycleAwareViewTreeRecomposer$2$onStateChanged$1(Recomposer recomposer, LifecycleOwner lifecycleOwner, WindowRecomposer_androidKt$createLifecycleAwareViewTreeRecomposer$2 windowRecomposer_androidKt$createLifecycleAwareViewTreeRecomposer$2, Continuation<? super WindowRecomposer_androidKt$createLifecycleAwareViewTreeRecomposer$2$onStateChanged$1> continuation) {
        super(2, continuation);
        this.$recomposer = recomposer;
        this.$lifecycleOwner = lifecycleOwner;
        this.$self = windowRecomposer_androidKt$createLifecycleAwareViewTreeRecomposer$2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WindowRecomposer_androidKt$createLifecycleAwareViewTreeRecomposer$2$onStateChanged$1(this.$recomposer, this.$lifecycleOwner, this.$self, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WindowRecomposer_androidKt$createLifecycleAwareViewTreeRecomposer$2$onStateChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$recomposer.runRecomposeAndApplyChanges(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                this.$lifecycleOwner.getLifecycle().removeObserver(this.$self);
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$lifecycleOwner.getLifecycle().removeObserver(this.$self);
        return Unit.INSTANCE;
    }
}
