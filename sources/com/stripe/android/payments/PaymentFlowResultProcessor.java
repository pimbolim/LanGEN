package com.stripe.android.payments;

import android.content.Context;
import com.stripe.android.StripeIntentResult;
import com.stripe.android.core.Logger;
import com.stripe.android.core.exception.InvalidRequestException;
import com.stripe.android.core.exception.MaxRetryReachedException;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.model.StripeIntentKtxKt;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.payments.PaymentFlowResult;
import java.util.List;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 1*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0010\b\u0001\u0010\u0003 \u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005:\u00011B5\b\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J+\u0010\u0016\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nH¤@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ'\u0010\u001c\u001a\u00028\u00012\u0006\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\nH$¢\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00028\u00012\u0006\u0010\"\u001a\u00020#H@ø\u0001\u0000¢\u0006\u0002\u0010$J!\u0010%\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019H¤@ø\u0001\u0000¢\u0006\u0002\u0010'J1\u0010(\u001a\u0004\u0018\u00018\u00002\u0006\u0010&\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0*H¤@ø\u0001\u0000¢\u0006\u0002\u0010+J\u0018\u0010,\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010.\u001a\u00020-H\u0002J\u0018\u0010/\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u001eH\u0002R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000\u0001\u000223\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"Lcom/stripe/android/payments/PaymentFlowResultProcessor;", "T", "Lcom/stripe/android/model/StripeIntent;", "S", "Lcom/stripe/android/StripeIntentResult;", "", "context", "Landroid/content/Context;", "publishableKeyProvider", "Ljavax/inject/Provider;", "", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "logger", "Lcom/stripe/android/core/Logger;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Ljavax/inject/Provider;Lcom/stripe/android/networking/StripeRepository;Lcom/stripe/android/core/Logger;Lkotlin/coroutines/CoroutineContext;)V", "failureMessageFactory", "Lcom/stripe/android/payments/PaymentFlowFailureMessageFactory;", "getStripeRepository", "()Lcom/stripe/android/networking/StripeRepository;", "cancelStripeIntentSource", "stripeIntent", "requestOptions", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "sourceId", "(Lcom/stripe/android/model/StripeIntent;Lcom/stripe/android/core/networking/ApiRequest$Options;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createStripeIntentResult", "outcomeFromFlow", "", "failureMessage", "(Lcom/stripe/android/model/StripeIntent;ILjava/lang/String;)Lcom/stripe/android/StripeIntentResult;", "processResult", "unvalidatedResult", "Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "(Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshStripeIntentUntilTerminalState", "clientSecret", "(Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retrieveStripeIntent", "expandFields", "", "(Ljava/lang/String;Lcom/stripe/android/core/networking/ApiRequest$Options;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldCancelIntentSource", "", "shouldCancelSource", "shouldRefreshIntent", "flowOutcome", "Companion", "Lcom/stripe/android/payments/PaymentIntentFlowResultProcessor;", "Lcom/stripe/android/payments/SetupIntentFlowResultProcessor;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentFlowResultProcessor.kt */
public abstract class PaymentFlowResultProcessor<T extends StripeIntent, S extends StripeIntentResult<? extends T>> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final List<String> EXPAND_PAYMENT_METHOD = CollectionsKt.listOf("payment_method");
    /* access modifiers changed from: private */
    public final PaymentFlowFailureMessageFactory failureMessageFactory;
    /* access modifiers changed from: private */
    public final Logger logger;
    /* access modifiers changed from: private */
    public final Provider<String> publishableKeyProvider;
    private final StripeRepository stripeRepository;
    private final CoroutineContext workContext;

    public /* synthetic */ PaymentFlowResultProcessor(Context context, Provider provider, StripeRepository stripeRepository2, Logger logger2, CoroutineContext coroutineContext, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, provider, stripeRepository2, logger2, coroutineContext);
    }

    /* access modifiers changed from: protected */
    public abstract Object cancelStripeIntentSource(T t, ApiRequest.Options options, String str, Continuation<? super T> continuation);

    /* access modifiers changed from: protected */
    public abstract S createStripeIntentResult(T t, int i, String str);

    /* access modifiers changed from: protected */
    public abstract Object refreshStripeIntentUntilTerminalState(String str, ApiRequest.Options options, Continuation<? super T> continuation) throws MaxRetryReachedException, InvalidRequestException;

    /* access modifiers changed from: protected */
    public abstract Object retrieveStripeIntent(String str, ApiRequest.Options options, List<String> list, Continuation<? super T> continuation);

    private PaymentFlowResultProcessor(Context context, Provider<String> provider, StripeRepository stripeRepository2, Logger logger2, CoroutineContext coroutineContext) {
        this.publishableKeyProvider = provider;
        this.stripeRepository = stripeRepository2;
        this.logger = logger2;
        this.workContext = coroutineContext;
        this.failureMessageFactory = new PaymentFlowFailureMessageFactory(context);
    }

    /* access modifiers changed from: protected */
    public final StripeRepository getStripeRepository() {
        return this.stripeRepository;
    }

    public final Object processResult(PaymentFlowResult.Unvalidated unvalidated, Continuation<? super S> continuation) {
        return BuildersKt.withContext(this.workContext, new PaymentFlowResultProcessor$processResult$2(unvalidated, this, (Continuation<? super PaymentFlowResultProcessor$processResult$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    public final boolean shouldCancelIntentSource(StripeIntent stripeIntent, boolean z) {
        return z && stripeIntent.requiresAction();
    }

    /* access modifiers changed from: private */
    public final boolean shouldRefreshIntent(StripeIntent stripeIntent, int i) {
        return i == 1 && StripeIntentKtxKt.shouldRefresh(stripeIntent);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/payments/PaymentFlowResultProcessor$Companion;", "", "()V", "EXPAND_PAYMENT_METHOD", "", "", "getEXPAND_PAYMENT_METHOD", "()Ljava/util/List;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentFlowResultProcessor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<String> getEXPAND_PAYMENT_METHOD() {
            return PaymentFlowResultProcessor.EXPAND_PAYMENT_METHOD;
        }
    }
}
