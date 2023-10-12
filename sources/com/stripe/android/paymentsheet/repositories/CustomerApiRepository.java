package com.stripe.android.paymentsheet.repositories;

import com.stripe.android.PaymentConfiguration;
import com.stripe.android.core.Logger;
import com.stripe.android.core.injection.IOContext;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.paymentsheet.PaymentSheet;
import dagger.Lazy;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

@Singleton
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\u000e\b\u0003\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ#\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J-\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u00162\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/paymentsheet/repositories/CustomerApiRepository;", "Lcom/stripe/android/paymentsheet/repositories/CustomerRepository;", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "lazyPaymentConfig", "Ldagger/Lazy;", "Lcom/stripe/android/PaymentConfiguration;", "logger", "Lcom/stripe/android/core/Logger;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "productUsageTokens", "", "", "(Lcom/stripe/android/networking/StripeRepository;Ldagger/Lazy;Lcom/stripe/android/core/Logger;Lkotlin/coroutines/CoroutineContext;Ljava/util/Set;)V", "detachPaymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "customerConfig", "Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;", "paymentMethodId", "(Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPaymentMethods", "", "types", "Lcom/stripe/android/model/PaymentMethod$Type;", "(Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomerApiRepository.kt */
public final class CustomerApiRepository implements CustomerRepository {
    /* access modifiers changed from: private */
    public final Lazy<PaymentConfiguration> lazyPaymentConfig;
    /* access modifiers changed from: private */
    public final Logger logger;
    /* access modifiers changed from: private */
    public final Set<String> productUsageTokens;
    /* access modifiers changed from: private */
    public final StripeRepository stripeRepository;
    private final CoroutineContext workContext;

    @Inject
    public CustomerApiRepository(StripeRepository stripeRepository2, Lazy<PaymentConfiguration> lazy, Logger logger2, @IOContext CoroutineContext coroutineContext, @Named("productUsage") Set<String> set) {
        Intrinsics.checkNotNullParameter(stripeRepository2, "stripeRepository");
        Intrinsics.checkNotNullParameter(lazy, "lazyPaymentConfig");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(set, "productUsageTokens");
        this.stripeRepository = stripeRepository2;
        this.lazyPaymentConfig = lazy;
        this.logger = logger2;
        this.workContext = coroutineContext;
        this.productUsageTokens = set;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomerApiRepository(StripeRepository stripeRepository2, Lazy lazy, Logger logger2, CoroutineContext coroutineContext, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(stripeRepository2, lazy, logger2, coroutineContext, (i & 16) != 0 ? SetsKt.emptySet() : set);
    }

    public Object getPaymentMethods(PaymentSheet.CustomerConfiguration customerConfiguration, List<? extends PaymentMethod.Type> list, Continuation<? super List<PaymentMethod>> continuation) {
        return BuildersKt.withContext(this.workContext, new CustomerApiRepository$getPaymentMethods$2(list, this, customerConfiguration, (Continuation<? super CustomerApiRepository$getPaymentMethods$2>) null), continuation);
    }

    public Object detachPaymentMethod(PaymentSheet.CustomerConfiguration customerConfiguration, String str, Continuation<? super PaymentMethod> continuation) {
        return BuildersKt.withContext(this.workContext, new CustomerApiRepository$detachPaymentMethod$2(this, str, customerConfiguration, (Continuation<? super CustomerApiRepository$detachPaymentMethod$2>) null), continuation);
    }
}
