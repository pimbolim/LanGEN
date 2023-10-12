package com.stripe.android.stripe3ds2.transaction;

import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import com.stripe.android.stripe3ds2.transaction.ErrorRequestExecutor;
import com.stripe.android.stripe3ds2.transaction.StripeHttpClient;
import com.stripe.android.stripe3ds2.transactions.ErrorData;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0002\r\u000eB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/StripeErrorRequestExecutor;", "Lcom/stripe/android/stripe3ds2/transaction/ErrorRequestExecutor;", "httpClient", "Lcom/stripe/android/stripe3ds2/transaction/HttpClient;", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/stripe/android/stripe3ds2/transaction/HttpClient;Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;Lkotlin/coroutines/CoroutineContext;)V", "executeAsync", "", "errorData", "Lcom/stripe/android/stripe3ds2/transactions/ErrorData;", "Companion", "Factory", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeErrorRequestExecutor.kt */
public final class StripeErrorRequestExecutor implements ErrorRequestExecutor {
    @Deprecated
    private static final String CONTENT_TYPE = "application/json; charset=utf-8";
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final ErrorReporter errorReporter;
    /* access modifiers changed from: private */
    public final HttpClient httpClient;
    private final CoroutineContext workContext;

    public StripeErrorRequestExecutor(HttpClient httpClient2, ErrorReporter errorReporter2, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(httpClient2, "httpClient");
        Intrinsics.checkNotNullParameter(errorReporter2, "errorReporter");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        this.httpClient = httpClient2;
        this.errorReporter = errorReporter2;
        this.workContext = coroutineContext;
    }

    public void executeAsync(ErrorData errorData) {
        Object obj;
        Intrinsics.checkNotNullParameter(errorData, "errorData");
        try {
            Result.Companion companion = Result.Companion;
            StripeErrorRequestExecutor stripeErrorRequestExecutor = this;
            obj = Result.m4709constructorimpl(errorData.toJson$3ds2sdk_release().toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        Throwable r1 = Result.m4712exceptionOrNullimpl(obj);
        if (r1 != null) {
            this.errorReporter.reportError(new RuntimeException(Intrinsics.stringPlus("Could not convert ErrorData to JSON.\n$", errorData), r1));
        }
        if (Result.m4715isFailureimpl(obj)) {
            obj = null;
        }
        String str = (String) obj;
        if (str != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.workContext), (CoroutineContext) null, (CoroutineStart) null, new StripeErrorRequestExecutor$executeAsync$3$1(this, str, (Continuation<? super StripeErrorRequestExecutor$executeAsync$3$1>) null), 3, (Object) null);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/StripeErrorRequestExecutor$Factory;", "Lcom/stripe/android/stripe3ds2/transaction/ErrorRequestExecutor$Factory;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "create", "Lcom/stripe/android/stripe3ds2/transaction/ErrorRequestExecutor;", "acsUrl", "", "errorReporter", "Lcom/stripe/android/stripe3ds2/observability/ErrorReporter;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeErrorRequestExecutor.kt */
    public static final class Factory implements ErrorRequestExecutor.Factory {
        private final CoroutineContext workContext;

        public Factory(CoroutineContext coroutineContext) {
            Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
            this.workContext = coroutineContext;
        }

        public ErrorRequestExecutor create(String str, ErrorReporter errorReporter) {
            Intrinsics.checkNotNullParameter(str, "acsUrl");
            Intrinsics.checkNotNullParameter(errorReporter, "errorReporter");
            return new StripeErrorRequestExecutor(new StripeHttpClient(str, (StripeHttpClient.ConnectionFactory) null, errorReporter, this.workContext, 2, (DefaultConstructorMarker) null), errorReporter, Dispatchers.getIO());
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/StripeErrorRequestExecutor$Companion;", "", "()V", "CONTENT_TYPE", "", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeErrorRequestExecutor.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
