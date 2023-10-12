package com.stripe.android.core.networking;

import com.stripe.android.core.Logger;
import com.stripe.android.core.exception.APIConnectionException;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B9\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJI\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\u0004\b\u0000\u0010\u000f2\u0006\u0010\u0010\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u00122\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000f0\u000e0\u0014H@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ'\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00180\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J,\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u000e\"\u0004\b\u0000\u0010\u000f2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\u000f0$2\b\u0010%\u001a\u0004\u0018\u00010\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/stripe/android/core/networking/DefaultStripeNetworkClient;", "Lcom/stripe/android/core/networking/StripeNetworkClient;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "connectionFactory", "Lcom/stripe/android/core/networking/ConnectionFactory;", "retryDelaySupplier", "Lcom/stripe/android/core/networking/RetryDelaySupplier;", "maxRetries", "", "logger", "Lcom/stripe/android/core/Logger;", "(Lkotlin/coroutines/CoroutineContext;Lcom/stripe/android/core/networking/ConnectionFactory;Lcom/stripe/android/core/networking/RetryDelaySupplier;ILcom/stripe/android/core/Logger;)V", "executeInternal", "Lcom/stripe/android/core/networking/StripeResponse;", "BodyType", "remainingRetries", "retryResponseCodes", "", "requester", "Lkotlin/Function0;", "executeInternal$stripe_core_release", "(ILjava/lang/Iterable;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeRequest", "", "request", "Lcom/stripe/android/core/networking/StripeRequest;", "(Lcom/stripe/android/core/networking/StripeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeRequestForFile", "Ljava/io/File;", "outputFile", "(Lcom/stripe/android/core/networking/StripeRequest;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "makeRequest", "makeRequestForFile", "parseResponse", "connection", "Lcom/stripe/android/core/networking/StripeConnection;", "baseUrl", "Companion", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultStripeNetworkClient.kt */
public final class DefaultStripeNetworkClient implements StripeNetworkClient {
    public static final int $stable = 8;
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final int DEFAULT_MAX_RETRIES = 3;
    private final ConnectionFactory connectionFactory;
    /* access modifiers changed from: private */
    public final Logger logger;
    private final int maxRetries;
    /* access modifiers changed from: private */
    public final RetryDelaySupplier retryDelaySupplier;
    private final CoroutineContext workContext;

    public DefaultStripeNetworkClient() {
        this((CoroutineContext) null, (ConnectionFactory) null, (RetryDelaySupplier) null, 0, (Logger) null, 31, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DefaultStripeNetworkClient(CoroutineContext coroutineContext) {
        this(coroutineContext, (ConnectionFactory) null, (RetryDelaySupplier) null, 0, (Logger) null, 30, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DefaultStripeNetworkClient(CoroutineContext coroutineContext, ConnectionFactory connectionFactory2) {
        this(coroutineContext, connectionFactory2, (RetryDelaySupplier) null, 0, (Logger) null, 28, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(connectionFactory2, "connectionFactory");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DefaultStripeNetworkClient(CoroutineContext coroutineContext, ConnectionFactory connectionFactory2, RetryDelaySupplier retryDelaySupplier2) {
        this(coroutineContext, connectionFactory2, retryDelaySupplier2, 0, (Logger) null, 24, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(connectionFactory2, "connectionFactory");
        Intrinsics.checkNotNullParameter(retryDelaySupplier2, "retryDelaySupplier");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DefaultStripeNetworkClient(CoroutineContext coroutineContext, ConnectionFactory connectionFactory2, RetryDelaySupplier retryDelaySupplier2, int i) {
        this(coroutineContext, connectionFactory2, retryDelaySupplier2, i, (Logger) null, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(connectionFactory2, "connectionFactory");
        Intrinsics.checkNotNullParameter(retryDelaySupplier2, "retryDelaySupplier");
    }

    public DefaultStripeNetworkClient(CoroutineContext coroutineContext, ConnectionFactory connectionFactory2, RetryDelaySupplier retryDelaySupplier2, int i, Logger logger2) {
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(connectionFactory2, "connectionFactory");
        Intrinsics.checkNotNullParameter(retryDelaySupplier2, "retryDelaySupplier");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        this.workContext = coroutineContext;
        this.connectionFactory = connectionFactory2;
        this.retryDelaySupplier = retryDelaySupplier2;
        this.maxRetries = i;
        this.logger = logger2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DefaultStripeNetworkClient(kotlin.coroutines.CoroutineContext r4, com.stripe.android.core.networking.ConnectionFactory r5, com.stripe.android.core.networking.RetryDelaySupplier r6, int r7, com.stripe.android.core.Logger r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x000a
            kotlinx.coroutines.CoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4
        L_0x000a:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x0012
            com.stripe.android.core.networking.ConnectionFactory$Default r5 = com.stripe.android.core.networking.ConnectionFactory.Default.INSTANCE
            com.stripe.android.core.networking.ConnectionFactory r5 = (com.stripe.android.core.networking.ConnectionFactory) r5
        L_0x0012:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x001c
            com.stripe.android.core.networking.RetryDelaySupplier r6 = new com.stripe.android.core.networking.RetryDelaySupplier
            r6.<init>()
        L_0x001c:
            r0 = r6
            r5 = r9 & 8
            if (r5 == 0) goto L_0x0024
            r7 = 3
            r1 = 3
            goto L_0x0025
        L_0x0024:
            r1 = r7
        L_0x0025:
            r5 = r9 & 16
            if (r5 == 0) goto L_0x002f
            com.stripe.android.core.Logger$Companion r5 = com.stripe.android.core.Logger.Companion
            com.stripe.android.core.Logger r8 = r5.noop()
        L_0x002f:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.core.networking.DefaultStripeNetworkClient.<init>(kotlin.coroutines.CoroutineContext, com.stripe.android.core.networking.ConnectionFactory, com.stripe.android.core.networking.RetryDelaySupplier, int, com.stripe.android.core.Logger, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public Object executeRequest(StripeRequest stripeRequest, Continuation<? super StripeResponse<String>> continuation) {
        return executeInternal$stripe_core_release(this.maxRetries, stripeRequest.getRetryResponseCodes(), new DefaultStripeNetworkClient$executeRequest$2(this, stripeRequest), continuation);
    }

    public Object executeRequestForFile(StripeRequest stripeRequest, File file, Continuation<? super StripeResponse<File>> continuation) {
        return executeInternal$stripe_core_release(this.maxRetries, stripeRequest.getRetryResponseCodes(), new DefaultStripeNetworkClient$executeRequestForFile$2(this, stripeRequest, file), continuation);
    }

    public final <BodyType> Object executeInternal$stripe_core_release(int i, Iterable<Integer> iterable, Function0<StripeResponse<BodyType>> function0, Continuation<? super StripeResponse<BodyType>> continuation) {
        return BuildersKt.withContext(this.workContext, new DefaultStripeNetworkClient$executeInternal$2(function0, iterable, i, this, (Continuation<? super DefaultStripeNetworkClient$executeInternal$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    public final StripeResponse<String> makeRequest(StripeRequest stripeRequest) {
        return parseResponse(this.connectionFactory.create(stripeRequest), stripeRequest.getUrl());
    }

    /* access modifiers changed from: private */
    public final StripeResponse<File> makeRequestForFile(StripeRequest stripeRequest, File file) {
        return parseResponse(this.connectionFactory.createForFile(stripeRequest, file), stripeRequest.getUrl());
    }

    private final <BodyType> StripeResponse<BodyType> parseResponse(StripeConnection<BodyType> stripeConnection, String str) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            StripeResponse<BodyType> response = stripeConnection.getResponse();
            this.logger.info(response.toString());
            obj = Result.m4709constructorimpl(response);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        Throwable r0 = Result.m4712exceptionOrNullimpl(obj);
        if (r0 == null) {
            return (StripeResponse) obj;
        }
        this.logger.error("Exception while making Stripe API request", r0);
        if (r0 instanceof IOException) {
            r0 = APIConnectionException.Companion.create((IOException) r0, str);
        }
        throw r0;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/core/networking/DefaultStripeNetworkClient$Companion;", "", "()V", "DEFAULT_MAX_RETRIES", "", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultStripeNetworkClient.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
