package com.stripe.android.stripe3ds2.observability;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.stripe3ds2.observability.DefaultErrorReporter$reportError$1", f = "DefaultErrorReporter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DefaultErrorReporter.kt */
final class DefaultErrorReporter$reportError$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Throwable $t;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DefaultErrorReporter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultErrorReporter$reportError$1(DefaultErrorReporter defaultErrorReporter, Throwable th, Continuation<? super DefaultErrorReporter$reportError$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultErrorReporter;
        this.$t = th;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DefaultErrorReporter$reportError$1 defaultErrorReporter$reportError$1 = new DefaultErrorReporter$reportError$1(this.this$0, this.$t, continuation);
        defaultErrorReporter$reportError$1.L$0 = obj;
        return defaultErrorReporter$reportError$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultErrorReporter$reportError$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            DefaultErrorReporter defaultErrorReporter = this.this$0;
            Throwable th = this.$t;
            try {
                Result.Companion companion = Result.Companion;
                defaultErrorReporter.send(defaultErrorReporter.createRequestBody$3ds2sdk_release(th));
                obj2 = Result.m4709constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m4709constructorimpl(ResultKt.createFailure(th2));
            }
            DefaultErrorReporter defaultErrorReporter2 = this.this$0;
            Throwable r3 = Result.m4712exceptionOrNullimpl(obj2);
            if (r3 != null) {
                defaultErrorReporter2.onFailure(r3);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
