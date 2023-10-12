package com.stripe.android.stripe3ds2.transaction;

import com.stripe.android.stripe3ds2.exceptions.SDKRuntimeException;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/stripe3ds2/transaction/HttpResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.stripe3ds2.transaction.StripeHttpClient$doPostRequest$2", f = "StripeHttpClient.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StripeHttpClient.kt */
final class StripeHttpClient$doPostRequest$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpResponse>, Object> {
    final /* synthetic */ String $contentType;
    final /* synthetic */ String $requestBody;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StripeHttpClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeHttpClient$doPostRequest$2(StripeHttpClient stripeHttpClient, String str, String str2, Continuation<? super StripeHttpClient$doPostRequest$2> continuation) {
        super(2, continuation);
        this.this$0 = stripeHttpClient;
        this.$requestBody = str;
        this.$contentType = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StripeHttpClient$doPostRequest$2 stripeHttpClient$doPostRequest$2 = new StripeHttpClient$doPostRequest$2(this.this$0, this.$requestBody, this.$contentType, continuation);
        stripeHttpClient$doPostRequest$2.L$0 = obj;
        return stripeHttpClient$doPostRequest$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpResponse> continuation) {
        return ((StripeHttpClient$doPostRequest$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            StripeHttpClient stripeHttpClient = this.this$0;
            String str = this.$requestBody;
            String str2 = this.$contentType;
            try {
                Result.Companion companion = Result.Companion;
                obj2 = Result.m4709constructorimpl(stripeHttpClient.doPostRequestInternal(str, str2));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
            StripeHttpClient stripeHttpClient2 = this.this$0;
            Throwable r1 = Result.m4712exceptionOrNullimpl(obj2);
            if (r1 != null) {
                stripeHttpClient2.errorReporter.reportError(r1);
            }
            Throwable r0 = Result.m4712exceptionOrNullimpl(obj2);
            if (r0 == null) {
                return obj2;
            }
            throw new SDKRuntimeException(r0);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
