package androidx.compose.material;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BackdropScaffold.kt */
final class BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $gesturesEnabled;
    final /* synthetic */ BackdropScaffoldState $scaffoldState;
    final /* synthetic */ CoroutineScope $scope;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1(boolean z, BackdropScaffoldState backdropScaffoldState, CoroutineScope coroutineScope) {
        super(0);
        this.$gesturesEnabled = z;
        this.$scaffoldState = backdropScaffoldState;
        this.$scope = coroutineScope;
    }

    public final void invoke() {
        if (this.$gesturesEnabled && ((Boolean) this.$scaffoldState.getConfirmStateChange$material_release().invoke(BackdropValue.Concealed)).booleanValue()) {
            CoroutineScope coroutineScope = this.$scope;
            final BackdropScaffoldState backdropScaffoldState = this.$scaffoldState;
            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1$1", f = "BackdropScaffold.kt", i = {}, l = {357}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1$1  reason: invalid class name */
    /* compiled from: BackdropScaffold.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(backdropScaffoldState, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (backdropScaffoldState.conceal(this) == coroutine_suspended) {
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
}
