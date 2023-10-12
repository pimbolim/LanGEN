package com.stripe.android.paymentsheet.repositories;

import com.stripe.android.PaymentConfiguration;
import com.stripe.android.core.injection.IOContext;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.paymentsheet.model.ClientSecret;
import dagger.Lazy;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0001\u0002\n\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/stripe/android/paymentsheet/repositories/StripeIntentRepository;", "", "()V", "get", "Lcom/stripe/android/model/StripeIntent;", "clientSecret", "Lcom/stripe/android/paymentsheet/model/ClientSecret;", "(Lcom/stripe/android/paymentsheet/model/ClientSecret;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Api", "Static", "Lcom/stripe/android/paymentsheet/repositories/StripeIntentRepository$Static;", "Lcom/stripe/android/paymentsheet/repositories/StripeIntentRepository$Api;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeIntentRepository.kt */
public abstract class StripeIntentRepository {
    public /* synthetic */ StripeIntentRepository(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Object get(ClientSecret clientSecret, Continuation<? super StripeIntent> continuation);

    private StripeIntentRepository() {
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/stripe/android/paymentsheet/repositories/StripeIntentRepository$Static;", "Lcom/stripe/android/paymentsheet/repositories/StripeIntentRepository;", "stripeIntent", "Lcom/stripe/android/model/StripeIntent;", "(Lcom/stripe/android/model/StripeIntent;)V", "get", "clientSecret", "Lcom/stripe/android/paymentsheet/model/ClientSecret;", "(Lcom/stripe/android/paymentsheet/model/ClientSecret;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeIntentRepository.kt */
    public static final class Static extends StripeIntentRepository {
        public static final int $stable = 8;
        private final StripeIntent stripeIntent;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Static(StripeIntent stripeIntent2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(stripeIntent2, "stripeIntent");
            this.stripeIntent = stripeIntent2;
        }

        public Object get(ClientSecret clientSecret, Continuation<? super StripeIntent> continuation) {
            return this.stripeIntent;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/paymentsheet/repositories/StripeIntentRepository$Api;", "Lcom/stripe/android/paymentsheet/repositories/StripeIntentRepository;", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "lazyPaymentConfig", "Ldagger/Lazy;", "Lcom/stripe/android/PaymentConfiguration;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "locale", "Ljava/util/Locale;", "(Lcom/stripe/android/networking/StripeRepository;Ldagger/Lazy;Lkotlin/coroutines/CoroutineContext;Ljava/util/Locale;)V", "requestOptions", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "getRequestOptions", "()Lcom/stripe/android/core/networking/ApiRequest$Options;", "requestOptions$delegate", "Lkotlin/Lazy;", "get", "Lcom/stripe/android/model/StripeIntent;", "clientSecret", "Lcom/stripe/android/paymentsheet/model/ClientSecret;", "(Lcom/stripe/android/paymentsheet/model/ClientSecret;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeIntentRepository.kt */
    public static final class Api extends StripeIntentRepository {
        public static final int $stable = 8;
        /* access modifiers changed from: private */
        public final Lazy<PaymentConfiguration> lazyPaymentConfig;
        /* access modifiers changed from: private */
        public final Locale locale;
        private final kotlin.Lazy requestOptions$delegate = LazyKt.lazy(new StripeIntentRepository$Api$requestOptions$2(this));
        /* access modifiers changed from: private */
        public final StripeRepository stripeRepository;
        private final CoroutineContext workContext;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        @Inject
        public Api(StripeRepository stripeRepository2, Lazy<PaymentConfiguration> lazy, @IOContext CoroutineContext coroutineContext, Locale locale2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(stripeRepository2, "stripeRepository");
            Intrinsics.checkNotNullParameter(lazy, "lazyPaymentConfig");
            Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
            this.stripeRepository = stripeRepository2;
            this.lazyPaymentConfig = lazy;
            this.workContext = coroutineContext;
            this.locale = locale2;
        }

        /* access modifiers changed from: private */
        public final ApiRequest.Options getRequestOptions() {
            return (ApiRequest.Options) this.requestOptions$delegate.getValue();
        }

        public Object get(ClientSecret clientSecret, Continuation<? super StripeIntent> continuation) {
            return BuildersKt.withContext(this.workContext, new StripeIntentRepository$Api$get$2(clientSecret, this, (Continuation<? super StripeIntentRepository$Api$get$2>) null), continuation);
        }
    }
}
