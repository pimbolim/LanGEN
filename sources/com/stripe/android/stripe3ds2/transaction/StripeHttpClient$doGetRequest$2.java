package com.stripe.android.stripe3ds2.transaction;

import java.io.InputStream;
import java.net.HttpURLConnection;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Ljava/io/InputStream;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.stripe3ds2.transaction.StripeHttpClient$doGetRequest$2", f = "StripeHttpClient.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StripeHttpClient.kt */
final class StripeHttpClient$doGetRequest$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InputStream>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StripeHttpClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeHttpClient$doGetRequest$2(StripeHttpClient stripeHttpClient, Continuation<? super StripeHttpClient$doGetRequest$2> continuation) {
        super(2, continuation);
        this.this$0 = stripeHttpClient;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StripeHttpClient$doGetRequest$2 stripeHttpClient$doGetRequest$2 = new StripeHttpClient$doGetRequest$2(this.this$0, continuation);
        stripeHttpClient$doGetRequest$2.L$0 = obj;
        return stripeHttpClient$doGetRequest$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InputStream> continuation) {
        return ((StripeHttpClient$doGetRequest$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        InputStream inputStream;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            StripeHttpClient stripeHttpClient = this.this$0;
            try {
                Result.Companion companion = Result.Companion;
                HttpURLConnection access$createGetConnection = stripeHttpClient.createGetConnection();
                access$createGetConnection.connect();
                if (access$createGetConnection.getResponseCode() == 200) {
                    inputStream = access$createGetConnection.getInputStream();
                } else {
                    inputStream = null;
                }
                obj2 = Result.m4709constructorimpl(inputStream);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
            StripeHttpClient stripeHttpClient2 = this.this$0;
            Throwable r2 = Result.m4712exceptionOrNullimpl(obj2);
            if (r2 != null) {
                stripeHttpClient2.errorReporter.reportError(r2);
            }
            if (Result.m4715isFailureimpl(obj2)) {
                return null;
            }
            return obj2;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
