package com.stripe.android.stripe3ds2.transaction;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.stripe3ds2.transaction.StripeErrorRequestExecutor$executeAsync$3$1", f = "StripeErrorRequestExecutor.kt", i = {}, l = {33}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StripeErrorRequestExecutor.kt */
final class StripeErrorRequestExecutor$executeAsync$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $requestBody;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StripeErrorRequestExecutor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeErrorRequestExecutor$executeAsync$3$1(StripeErrorRequestExecutor stripeErrorRequestExecutor, String str, Continuation<? super StripeErrorRequestExecutor$executeAsync$3$1> continuation) {
        super(2, continuation);
        this.this$0 = stripeErrorRequestExecutor;
        this.$requestBody = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StripeErrorRequestExecutor$executeAsync$3$1 stripeErrorRequestExecutor$executeAsync$3$1 = new StripeErrorRequestExecutor$executeAsync$3$1(this.this$0, this.$requestBody, continuation);
        stripeErrorRequestExecutor$executeAsync$3$1.L$0 = obj;
        return stripeErrorRequestExecutor$executeAsync$3$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((StripeErrorRequestExecutor$executeAsync$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            StripeErrorRequestExecutor stripeErrorRequestExecutor = this.this$0;
            String str = this.$requestBody;
            Result.Companion companion = Result.Companion;
            HttpClient access$getHttpClient$p = stripeErrorRequestExecutor.httpClient;
            Intrinsics.checkNotNullExpressionValue(str, "requestBody");
            this.label = 1;
            obj = access$getHttpClient$p.doPostRequest(str, "application/json; charset=utf-8", this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m4709constructorimpl((HttpResponse) obj);
        StripeErrorRequestExecutor stripeErrorRequestExecutor2 = this.this$0;
        Throwable r5 = Result.m4712exceptionOrNullimpl(obj2);
        if (r5 != null) {
            stripeErrorRequestExecutor2.errorReporter.reportError(r5);
        }
        return Unit.INSTANCE;
    }
}
