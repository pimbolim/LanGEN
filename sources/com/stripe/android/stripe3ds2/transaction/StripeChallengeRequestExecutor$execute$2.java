package com.stripe.android.stripe3ds2.transaction;

import com.nimbusds.jose.JOSEObject;
import com.stripe.android.stripe3ds2.transaction.ChallengeRequestResult;
import com.stripe.android.stripe3ds2.transactions.ChallengeRequestData;
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
import kotlinx.coroutines.TimeoutCancellationException;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.stripe3ds2.transaction.StripeChallengeRequestExecutor$execute$2", f = "StripeChallengeRequestExecutor.kt", i = {}, l = {62, 70}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StripeChallengeRequestExecutor.kt */
final class StripeChallengeRequestExecutor$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ChallengeRequestResult>, Object> {
    final /* synthetic */ ChallengeRequestData $creqData;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StripeChallengeRequestExecutor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeChallengeRequestExecutor$execute$2(StripeChallengeRequestExecutor stripeChallengeRequestExecutor, ChallengeRequestData challengeRequestData, Continuation<? super StripeChallengeRequestExecutor$execute$2> continuation) {
        super(2, continuation);
        this.this$0 = stripeChallengeRequestExecutor;
        this.$creqData = challengeRequestData;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StripeChallengeRequestExecutor$execute$2 stripeChallengeRequestExecutor$execute$2 = new StripeChallengeRequestExecutor$execute$2(this.this$0, this.$creqData, continuation);
        stripeChallengeRequestExecutor$execute$2.L$0 = obj;
        return stripeChallengeRequestExecutor$execute$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ChallengeRequestResult> continuation) {
        return ((StripeChallengeRequestExecutor$execute$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            StripeChallengeRequestExecutor stripeChallengeRequestExecutor = this.this$0;
            ChallengeRequestData challengeRequestData = this.$creqData;
            Result.Companion companion = Result.Companion;
            HttpClient access$getHttpClient$p = stripeChallengeRequestExecutor.httpClient;
            String access$getRequestBody = stripeChallengeRequestExecutor.getRequestBody(challengeRequestData.toJson$3ds2sdk_release());
            this.label = 1;
            obj = access$getHttpClient$p.doPostRequest(access$getRequestBody, JOSEObject.MIME_TYPE_COMPACT, this);
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
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return (ChallengeRequestResult) obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m4709constructorimpl((HttpResponse) obj);
        StripeChallengeRequestExecutor stripeChallengeRequestExecutor2 = this.this$0;
        Throwable r3 = Result.m4712exceptionOrNullimpl(obj2);
        if (r3 != null) {
            stripeChallengeRequestExecutor2.errorReporter.reportError(r3);
        }
        StripeChallengeRequestExecutor stripeChallengeRequestExecutor3 = this.this$0;
        ChallengeRequestData challengeRequestData2 = this.$creqData;
        Throwable r4 = Result.m4712exceptionOrNullimpl(obj2);
        if (r4 == null) {
            ChallengeResponseProcessor access$getResponseProcessor$p = stripeChallengeRequestExecutor3.responseProcessor;
            this.label = 2;
            obj = access$getResponseProcessor$p.process(challengeRequestData2, (HttpResponse) obj2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            return (ChallengeRequestResult) obj;
        } else if (r4 instanceof TimeoutCancellationException) {
            return StripeChallengeRequestExecutor.Companion.createTimeoutResult(challengeRequestData2);
        } else {
            return new ChallengeRequestResult.RuntimeError(r4);
        }
    }
}
