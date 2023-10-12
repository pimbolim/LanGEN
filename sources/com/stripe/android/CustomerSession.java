package com.stripe.android;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.stripe.android.EphemeralKeyManager;
import com.stripe.android.EphemeralOperation;
import com.stripe.android.core.Logger;
import com.stripe.android.core.StripeError;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.StripeNetworkClient;
import com.stripe.android.model.Customer;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.ShippingInformation;
import com.stripe.android.model.Source;
import com.stripe.android.networking.FraudDetectionDataParamsUtils;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeApiRepository;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.payments.core.injection.NamedConstantsKt;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExecutorsKt;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \\2\u00020\u0001:\u0006\\]^_`aBY\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0012\b\u0002\u0010\r\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u001e\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u000201J3\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u0007032\u0006\u00100\u001a\u000201H\u0000¢\u0006\u0002\b4J\u0016\u00105\u001a\u00020-2\u0006\u00106\u001a\u00020\u00072\u0006\u00100\u001a\u000207J+\u00105\u001a\u00020-2\u0006\u00106\u001a\u00020\u00072\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u0007032\u0006\u00100\u001a\u000207H\u0000¢\u0006\u0002\b8J\r\u00109\u001a\u00020-H\u0000¢\u0006\u0002\b:J\u0016\u0010;\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00072\u0006\u00100\u001a\u000201J+\u0010;\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00072\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u0007032\u0006\u00100\u001a\u000201H\u0000¢\u0006\u0002\b<J\u0016\u0010=\u001a\u00020-2\u0006\u00106\u001a\u00020\u00072\u0006\u00100\u001a\u000207J+\u0010=\u001a\u00020-2\u0006\u00106\u001a\u00020\u00072\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u0007032\u0006\u00100\u001a\u000207H\u0000¢\u0006\u0002\b>J#\u0010?\u001a\u0004\u0018\u0001H@\"\n\b\u0000\u0010@*\u0004\u0018\u00010)2\u0006\u0010A\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010BJ\u0016\u0010C\u001a\u00020-2\u0006\u0010D\u001a\u00020E2\u0006\u00100\u001a\u00020FJA\u0010C\u001a\u00020-2\u0006\u0010D\u001a\u00020E2\n\b\u0001\u0010G\u001a\u0004\u0018\u00010H2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00072\u0006\u00100\u001a\u00020FH\u0007¢\u0006\u0002\u0010KJQ\u0010C\u001a\u00020-2\u0006\u0010D\u001a\u00020E2\n\b\u0003\u0010G\u001a\u0004\u0018\u00010H2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u00072\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u0007032\u0006\u00100\u001a\u00020FH\u0000¢\u0006\u0004\bL\u0010MJ\u000e\u0010N\u001a\u00020-2\u0006\u00100\u001a\u00020OJ#\u0010N\u001a\u00020-2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u0007032\u0006\u00100\u001a\u00020OH\u0000¢\u0006\u0002\bPJ\u001e\u0010Q\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u00020OJ3\u0010Q\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u00072\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u0007032\u0006\u00100\u001a\u00020OH\u0000¢\u0006\u0002\bRJ\u0016\u0010S\u001a\u00020-2\u0006\u0010T\u001a\u00020U2\u0006\u00100\u001a\u00020OJ+\u0010S\u001a\u00020-2\u0006\u0010T\u001a\u00020U2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u0007032\u0006\u00100\u001a\u00020OH\u0000¢\u0006\u0002\bVJ\u001a\u0010W\u001a\u00020-2\u0006\u0010X\u001a\u00020Y2\b\u00100\u001a\u0004\u0018\u00010)H\u0002J\u000e\u0010Z\u001a\u00020-2\u0006\u00100\u001a\u00020OJ#\u0010Z\u001a\u00020-2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u0007032\u0006\u00100\u001a\u00020OH\u0000¢\u0006\u0002\b[R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0017\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010)0(X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\f\u0012\u0004\u0012\u00020\u000f0\u000ej\u0002`\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/stripe/android/CustomerSession;", "", "context", "Landroid/content/Context;", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "publishableKey", "", "stripeAccountId", "workContext", "Lkotlin/coroutines/CoroutineContext;", "operationIdFactory", "Lcom/stripe/android/OperationIdFactory;", "timeSupplier", "Lkotlin/Function0;", "", "Lcom/stripe/android/TimeSupplier;", "ephemeralKeyManagerFactory", "Lcom/stripe/android/EphemeralKeyManager$Factory;", "(Landroid/content/Context;Lcom/stripe/android/networking/StripeRepository;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/CoroutineContext;Lcom/stripe/android/OperationIdFactory;Lkotlin/jvm/functions/Function0;Lcom/stripe/android/EphemeralKeyManager$Factory;)V", "cachedCustomer", "Lcom/stripe/android/model/Customer;", "getCachedCustomer", "()Lcom/stripe/android/model/Customer;", "canUseCachedCustomer", "", "getCanUseCachedCustomer", "()Z", "customer", "getCustomer$payments_core_release", "setCustomer$payments_core_release", "(Lcom/stripe/android/model/Customer;)V", "customerCacheTime", "getCustomerCacheTime$payments_core_release", "()J", "setCustomerCacheTime$payments_core_release", "(J)V", "ephemeralKeyManager", "Lcom/stripe/android/EphemeralKeyManager;", "listeners", "", "Lcom/stripe/android/CustomerSession$RetrievalListener;", "operationExecutor", "Lcom/stripe/android/CustomerSessionOperationExecutor;", "addCustomerSource", "", "sourceId", "sourceType", "listener", "Lcom/stripe/android/CustomerSession$SourceRetrievalListener;", "productUsage", "", "addCustomerSource$payments_core_release", "attachPaymentMethod", "paymentMethodId", "Lcom/stripe/android/CustomerSession$PaymentMethodRetrievalListener;", "attachPaymentMethod$payments_core_release", "cancel", "cancel$payments_core_release", "deleteCustomerSource", "deleteCustomerSource$payments_core_release", "detachPaymentMethod", "detachPaymentMethod$payments_core_release", "getListener", "L", "operationId", "(Ljava/lang/String;)Lcom/stripe/android/CustomerSession$RetrievalListener;", "getPaymentMethods", "paymentMethodType", "Lcom/stripe/android/model/PaymentMethod$Type;", "Lcom/stripe/android/CustomerSession$PaymentMethodsRetrievalListener;", "limit", "", "endingBefore", "startingAfter", "(Lcom/stripe/android/model/PaymentMethod$Type;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/CustomerSession$PaymentMethodsRetrievalListener;)V", "getPaymentMethods$payments_core_release", "(Lcom/stripe/android/model/PaymentMethod$Type;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;Lcom/stripe/android/CustomerSession$PaymentMethodsRetrievalListener;)V", "retrieveCurrentCustomer", "Lcom/stripe/android/CustomerSession$CustomerRetrievalListener;", "retrieveCurrentCustomer$payments_core_release", "setCustomerDefaultSource", "setCustomerDefaultSource$payments_core_release", "setCustomerShippingInformation", "shippingInformation", "Lcom/stripe/android/model/ShippingInformation;", "setCustomerShippingInformation$payments_core_release", "startOperation", "operation", "Lcom/stripe/android/EphemeralOperation;", "updateCurrentCustomer", "updateCurrentCustomer$payments_core_release", "Companion", "CustomerRetrievalListener", "PaymentMethodRetrievalListener", "PaymentMethodsRetrievalListener", "RetrievalListener", "SourceRetrievalListener", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomerSession.kt */
public final class CustomerSession {
    public static final int $stable = 8;
    private static final long CUSTOMER_CACHE_DURATION_MILLISECONDS = TimeUnit.MINUTES.toMillis(1);
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int KEEP_ALIVE_TIME = 2;
    /* access modifiers changed from: private */
    public static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
    private static final int THREAD_POOL_SIZE = 3;
    /* access modifiers changed from: private */
    public static /* synthetic */ CustomerSession instance;
    private /* synthetic */ Customer customer;
    private /* synthetic */ long customerCacheTime;
    private final EphemeralKeyManager ephemeralKeyManager;
    /* access modifiers changed from: private */
    public final Map<String, RetrievalListener> listeners;
    /* access modifiers changed from: private */
    public final CustomerSessionOperationExecutor operationExecutor;
    private final OperationIdFactory operationIdFactory;
    /* access modifiers changed from: private */
    public final Function0<Long> timeSupplier;
    /* access modifiers changed from: private */
    public final CoroutineContext workContext;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/CustomerSession$CustomerRetrievalListener;", "Lcom/stripe/android/CustomerSession$RetrievalListener;", "onCustomerRetrieved", "", "customer", "Lcom/stripe/android/model/Customer;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CustomerSession.kt */
    public interface CustomerRetrievalListener extends RetrievalListener {
        void onCustomerRetrieved(Customer customer);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/CustomerSession$PaymentMethodRetrievalListener;", "Lcom/stripe/android/CustomerSession$RetrievalListener;", "onPaymentMethodRetrieved", "", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CustomerSession.kt */
    public interface PaymentMethodRetrievalListener extends RetrievalListener {
        void onPaymentMethodRetrieved(PaymentMethod paymentMethod);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/CustomerSession$PaymentMethodsRetrievalListener;", "Lcom/stripe/android/CustomerSession$RetrievalListener;", "onPaymentMethodsRetrieved", "", "paymentMethods", "", "Lcom/stripe/android/model/PaymentMethod;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CustomerSession.kt */
    public interface PaymentMethodsRetrievalListener extends RetrievalListener {
        void onPaymentMethodsRetrieved(List<PaymentMethod> list);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/stripe/android/CustomerSession$RetrievalListener;", "", "onError", "", "errorCode", "", "errorMessage", "", "stripeError", "Lcom/stripe/android/core/StripeError;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CustomerSession.kt */
    public interface RetrievalListener {
        void onError(int i, String str, StripeError stripeError);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/CustomerSession$SourceRetrievalListener;", "Lcom/stripe/android/CustomerSession$RetrievalListener;", "onSourceRetrieved", "", "source", "Lcom/stripe/android/model/Source;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CustomerSession.kt */
    public interface SourceRetrievalListener extends RetrievalListener {
        void onSourceRetrieved(Source source);
    }

    @JvmStatic
    public static final void cancelCallbacks() {
        Companion.cancelCallbacks();
    }

    @JvmStatic
    public static final void endCustomerSession() {
        Companion.endCustomerSession();
    }

    @JvmStatic
    public static final CustomerSession getInstance() {
        return Companion.getInstance();
    }

    @JvmStatic
    public static final void initCustomerSession(Context context, EphemeralKeyProvider ephemeralKeyProvider) {
        Companion.initCustomerSession(context, ephemeralKeyProvider);
    }

    @JvmStatic
    public static final void initCustomerSession(Context context, EphemeralKeyProvider ephemeralKeyProvider, boolean z) {
        Companion.initCustomerSession(context, ephemeralKeyProvider, z);
    }

    public final void getPaymentMethods(PaymentMethod.Type type, Integer num, PaymentMethodsRetrievalListener paymentMethodsRetrievalListener) {
        Intrinsics.checkNotNullParameter(type, "paymentMethodType");
        Intrinsics.checkNotNullParameter(paymentMethodsRetrievalListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        getPaymentMethods$default(this, type, num, (String) null, (String) null, paymentMethodsRetrievalListener, 12, (Object) null);
    }

    public final void getPaymentMethods(PaymentMethod.Type type, Integer num, String str, PaymentMethodsRetrievalListener paymentMethodsRetrievalListener) {
        Intrinsics.checkNotNullParameter(type, "paymentMethodType");
        Intrinsics.checkNotNullParameter(paymentMethodsRetrievalListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        getPaymentMethods$default(this, type, num, str, (String) null, paymentMethodsRetrievalListener, 8, (Object) null);
    }

    public CustomerSession(Context context, StripeRepository stripeRepository, String str, String str2, CoroutineContext coroutineContext, OperationIdFactory operationIdFactory2, Function0<Long> function0, EphemeralKeyManager.Factory factory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(stripeRepository, "stripeRepository");
        Intrinsics.checkNotNullParameter(str, "publishableKey");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(operationIdFactory2, "operationIdFactory");
        Intrinsics.checkNotNullParameter(function0, "timeSupplier");
        Intrinsics.checkNotNullParameter(factory, "ephemeralKeyManagerFactory");
        this.workContext = coroutineContext;
        this.operationIdFactory = operationIdFactory2;
        this.timeSupplier = function0;
        Map<String, RetrievalListener> linkedHashMap = new LinkedHashMap<>();
        this.listeners = linkedHashMap;
        this.operationExecutor = new CustomerSessionOperationExecutor(stripeRepository, str, str2, linkedHashMap, new CustomerSession$operationExecutor$1(this));
        this.ephemeralKeyManager = factory.create(new CustomerSession$ephemeralKeyManager$1(this));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CustomerSession(android.content.Context r11, com.stripe.android.networking.StripeRepository r12, java.lang.String r13, java.lang.String r14, kotlin.coroutines.CoroutineContext r15, com.stripe.android.OperationIdFactory r16, kotlin.jvm.functions.Function0 r17, com.stripe.android.EphemeralKeyManager.Factory r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r10 = this;
            r0 = r19 & 16
            if (r0 == 0) goto L_0x000c
            com.stripe.android.CustomerSession$Companion r0 = Companion
            kotlin.coroutines.CoroutineContext r0 = r0.createCoroutineDispatcher()
            r6 = r0
            goto L_0x000d
        L_0x000c:
            r6 = r15
        L_0x000d:
            r0 = r19 & 32
            if (r0 == 0) goto L_0x001a
            com.stripe.android.StripeOperationIdFactory r0 = new com.stripe.android.StripeOperationIdFactory
            r0.<init>()
            com.stripe.android.OperationIdFactory r0 = (com.stripe.android.OperationIdFactory) r0
            r7 = r0
            goto L_0x001c
        L_0x001a:
            r7 = r16
        L_0x001c:
            r0 = r19 & 64
            if (r0 == 0) goto L_0x0026
            com.stripe.android.CustomerSession$1 r0 = com.stripe.android.CustomerSession.AnonymousClass1.INSTANCE
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r8 = r0
            goto L_0x0028
        L_0x0026:
            r8 = r17
        L_0x0028:
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r9 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.CustomerSession.<init>(android.content.Context, com.stripe.android.networking.StripeRepository, java.lang.String, java.lang.String, kotlin.coroutines.CoroutineContext, com.stripe.android.OperationIdFactory, kotlin.jvm.functions.Function0, com.stripe.android.EphemeralKeyManager$Factory, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final long getCustomerCacheTime$payments_core_release() {
        return this.customerCacheTime;
    }

    public final void setCustomerCacheTime$payments_core_release(long j) {
        this.customerCacheTime = j;
    }

    public final Customer getCustomer$payments_core_release() {
        return this.customer;
    }

    public final void setCustomer$payments_core_release(Customer customer2) {
        this.customer = customer2;
    }

    public final void retrieveCurrentCustomer(CustomerRetrievalListener customerRetrievalListener) {
        Intrinsics.checkNotNullParameter(customerRetrievalListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        retrieveCurrentCustomer$payments_core_release(SetsKt.emptySet(), customerRetrievalListener);
    }

    public final /* synthetic */ void retrieveCurrentCustomer$payments_core_release(Set set, CustomerRetrievalListener customerRetrievalListener) {
        Unit unit;
        Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
        Intrinsics.checkNotNullParameter(customerRetrievalListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Customer cachedCustomer = getCachedCustomer();
        if (cachedCustomer == null) {
            unit = null;
        } else {
            customerRetrievalListener.onCustomerRetrieved(cachedCustomer);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            updateCurrentCustomer$payments_core_release(set, customerRetrievalListener);
        }
    }

    public final void updateCurrentCustomer(CustomerRetrievalListener customerRetrievalListener) {
        Intrinsics.checkNotNullParameter(customerRetrievalListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        updateCurrentCustomer$payments_core_release(SetsKt.emptySet(), customerRetrievalListener);
    }

    public final /* synthetic */ void updateCurrentCustomer$payments_core_release(Set set, CustomerRetrievalListener customerRetrievalListener) {
        Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
        Intrinsics.checkNotNullParameter(customerRetrievalListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.customer = null;
        startOperation(new EphemeralOperation.RetrieveKey(this.operationIdFactory.create(), set), customerRetrievalListener);
    }

    public final Customer getCachedCustomer() {
        Customer customer2 = this.customer;
        if (getCanUseCachedCustomer()) {
            return customer2;
        }
        return null;
    }

    public final void addCustomerSource(String str, String str2, SourceRetrievalListener sourceRetrievalListener) {
        Intrinsics.checkNotNullParameter(str, "sourceId");
        Intrinsics.checkNotNullParameter(str2, "sourceType");
        Intrinsics.checkNotNullParameter(sourceRetrievalListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        addCustomerSource$payments_core_release(str, str2, SetsKt.emptySet(), sourceRetrievalListener);
    }

    public final /* synthetic */ void addCustomerSource$payments_core_release(String str, String str2, Set set, SourceRetrievalListener sourceRetrievalListener) {
        Intrinsics.checkNotNullParameter(str, "sourceId");
        Intrinsics.checkNotNullParameter(str2, "sourceType");
        Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
        Intrinsics.checkNotNullParameter(sourceRetrievalListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        startOperation(new EphemeralOperation.Customer.AddSource(str, str2, this.operationIdFactory.create(), set), sourceRetrievalListener);
    }

    public final void deleteCustomerSource(String str, SourceRetrievalListener sourceRetrievalListener) {
        Intrinsics.checkNotNullParameter(str, "sourceId");
        Intrinsics.checkNotNullParameter(sourceRetrievalListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        deleteCustomerSource$payments_core_release(str, SetsKt.emptySet(), sourceRetrievalListener);
    }

    public final /* synthetic */ void deleteCustomerSource$payments_core_release(String str, Set set, SourceRetrievalListener sourceRetrievalListener) {
        Intrinsics.checkNotNullParameter(str, "sourceId");
        Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
        Intrinsics.checkNotNullParameter(sourceRetrievalListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        startOperation(new EphemeralOperation.Customer.DeleteSource(str, this.operationIdFactory.create(), set), sourceRetrievalListener);
    }

    public final void attachPaymentMethod(String str, PaymentMethodRetrievalListener paymentMethodRetrievalListener) {
        Intrinsics.checkNotNullParameter(str, "paymentMethodId");
        Intrinsics.checkNotNullParameter(paymentMethodRetrievalListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        attachPaymentMethod$payments_core_release(str, SetsKt.emptySet(), paymentMethodRetrievalListener);
    }

    public final /* synthetic */ void attachPaymentMethod$payments_core_release(String str, Set set, PaymentMethodRetrievalListener paymentMethodRetrievalListener) {
        Intrinsics.checkNotNullParameter(str, "paymentMethodId");
        Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
        Intrinsics.checkNotNullParameter(paymentMethodRetrievalListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        startOperation(new EphemeralOperation.Customer.AttachPaymentMethod(str, this.operationIdFactory.create(), set), paymentMethodRetrievalListener);
    }

    public final void detachPaymentMethod(String str, PaymentMethodRetrievalListener paymentMethodRetrievalListener) {
        Intrinsics.checkNotNullParameter(str, "paymentMethodId");
        Intrinsics.checkNotNullParameter(paymentMethodRetrievalListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        detachPaymentMethod$payments_core_release(str, SetsKt.emptySet(), paymentMethodRetrievalListener);
    }

    public final /* synthetic */ void detachPaymentMethod$payments_core_release(String str, Set set, PaymentMethodRetrievalListener paymentMethodRetrievalListener) {
        Intrinsics.checkNotNullParameter(str, "paymentMethodId");
        Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
        Intrinsics.checkNotNullParameter(paymentMethodRetrievalListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        startOperation(new EphemeralOperation.Customer.DetachPaymentMethod(str, this.operationIdFactory.create(), set), paymentMethodRetrievalListener);
    }

    public static /* synthetic */ void getPaymentMethods$default(CustomerSession customerSession, PaymentMethod.Type type, Integer num, String str, String str2, PaymentMethodsRetrievalListener paymentMethodsRetrievalListener, int i, Object obj) {
        customerSession.getPaymentMethods(type, num, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, paymentMethodsRetrievalListener);
    }

    public final void getPaymentMethods(PaymentMethod.Type type, Integer num, String str, String str2, PaymentMethodsRetrievalListener paymentMethodsRetrievalListener) {
        Intrinsics.checkNotNullParameter(type, "paymentMethodType");
        Intrinsics.checkNotNullParameter(paymentMethodsRetrievalListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        getPaymentMethods$payments_core_release(type, num, str, str2, SetsKt.emptySet(), paymentMethodsRetrievalListener);
    }

    public static /* synthetic */ void getPaymentMethods$payments_core_release$default(CustomerSession customerSession, PaymentMethod.Type type, Integer num, String str, String str2, Set set, PaymentMethodsRetrievalListener paymentMethodsRetrievalListener, int i, Object obj) {
        customerSession.getPaymentMethods$payments_core_release(type, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, set, paymentMethodsRetrievalListener);
    }

    public final /* synthetic */ void getPaymentMethods$payments_core_release(PaymentMethod.Type type, Integer num, String str, String str2, Set set, PaymentMethodsRetrievalListener paymentMethodsRetrievalListener) {
        Intrinsics.checkNotNullParameter(type, "paymentMethodType");
        Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
        Intrinsics.checkNotNullParameter(paymentMethodsRetrievalListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        startOperation(new EphemeralOperation.Customer.GetPaymentMethods(type, num, str, str2, this.operationIdFactory.create(), set), paymentMethodsRetrievalListener);
    }

    public final void getPaymentMethods(PaymentMethod.Type type, PaymentMethodsRetrievalListener paymentMethodsRetrievalListener) {
        Intrinsics.checkNotNullParameter(type, "paymentMethodType");
        Intrinsics.checkNotNullParameter(paymentMethodsRetrievalListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        getPaymentMethods$payments_core_release$default(this, type, (Integer) null, (String) null, (String) null, SetsKt.emptySet(), paymentMethodsRetrievalListener, 14, (Object) null);
    }

    public final void setCustomerShippingInformation(ShippingInformation shippingInformation, CustomerRetrievalListener customerRetrievalListener) {
        Intrinsics.checkNotNullParameter(shippingInformation, "shippingInformation");
        Intrinsics.checkNotNullParameter(customerRetrievalListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        setCustomerShippingInformation$payments_core_release(shippingInformation, SetsKt.emptySet(), customerRetrievalListener);
    }

    public final /* synthetic */ void setCustomerShippingInformation$payments_core_release(ShippingInformation shippingInformation, Set set, CustomerRetrievalListener customerRetrievalListener) {
        Intrinsics.checkNotNullParameter(shippingInformation, "shippingInformation");
        Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
        Intrinsics.checkNotNullParameter(customerRetrievalListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        startOperation(new EphemeralOperation.Customer.UpdateShipping(shippingInformation, this.operationIdFactory.create(), set), customerRetrievalListener);
    }

    public final void setCustomerDefaultSource(String str, String str2, CustomerRetrievalListener customerRetrievalListener) {
        Intrinsics.checkNotNullParameter(str, "sourceId");
        Intrinsics.checkNotNullParameter(str2, "sourceType");
        Intrinsics.checkNotNullParameter(customerRetrievalListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        setCustomerDefaultSource$payments_core_release(str, str2, SetsKt.emptySet(), customerRetrievalListener);
    }

    public final /* synthetic */ void setCustomerDefaultSource$payments_core_release(String str, String str2, Set set, CustomerRetrievalListener customerRetrievalListener) {
        Intrinsics.checkNotNullParameter(str, "sourceId");
        Intrinsics.checkNotNullParameter(str2, "sourceType");
        Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
        Intrinsics.checkNotNullParameter(customerRetrievalListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        startOperation(new EphemeralOperation.Customer.UpdateDefaultSource(str, str2, this.operationIdFactory.create(), set), customerRetrievalListener);
    }

    private final void startOperation(EphemeralOperation ephemeralOperation, RetrievalListener retrievalListener) {
        this.listeners.put(ephemeralOperation.getId$payments_core_release(), retrievalListener);
        this.ephemeralKeyManager.retrieveEphemeralKey$payments_core_release(ephemeralOperation);
    }

    private final boolean getCanUseCachedCustomer() {
        return this.customer != null && this.timeSupplier.invoke().longValue() - this.customerCacheTime < CUSTOMER_CACHE_DURATION_MILLISECONDS;
    }

    public final /* synthetic */ void cancel$payments_core_release() {
        this.listeners.clear();
        JobKt__JobKt.cancelChildren$default(this.workContext, (CancellationException) null, 1, (Object) null);
    }

    private final <L extends RetrievalListener> L getListener(String str) {
        return (RetrievalListener) this.listeners.remove(str);
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\r\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0002\b\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0011H\u0007J\b\u0010\u0017\u001a\u00020\u000bH\u0007J\"\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/CustomerSession$Companion;", "", "()V", "CUSTOMER_CACHE_DURATION_MILLISECONDS", "", "KEEP_ALIVE_TIME", "", "KEEP_ALIVE_TIME_UNIT", "Ljava/util/concurrent/TimeUnit;", "THREAD_POOL_SIZE", "instance", "Lcom/stripe/android/CustomerSession;", "getInstance$payments_core_release", "()Lcom/stripe/android/CustomerSession;", "setInstance$payments_core_release", "(Lcom/stripe/android/CustomerSession;)V", "cancelCallbacks", "", "clearInstance", "clearInstance$payments_core_release", "createCoroutineDispatcher", "Lkotlin/coroutines/CoroutineContext;", "endCustomerSession", "getInstance", "initCustomerSession", "context", "Landroid/content/Context;", "ephemeralKeyProvider", "Lcom/stripe/android/EphemeralKeyProvider;", "shouldPrefetchEphemeralKey", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CustomerSession.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void initCustomerSession(Context context, EphemeralKeyProvider ephemeralKeyProvider) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(ephemeralKeyProvider, "ephemeralKeyProvider");
            initCustomerSession$default(this, context, ephemeralKeyProvider, false, 4, (Object) null);
        }

        private Companion() {
        }

        public static /* synthetic */ void initCustomerSession$default(Companion companion, Context context, EphemeralKeyProvider ephemeralKeyProvider, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = true;
            }
            companion.initCustomerSession(context, ephemeralKeyProvider, z);
        }

        @JvmStatic
        public final void initCustomerSession(Context context, EphemeralKeyProvider ephemeralKeyProvider, boolean z) {
            CustomerSession customerSession;
            Context context2 = context;
            EphemeralKeyProvider ephemeralKeyProvider2 = ephemeralKeyProvider;
            Context context3 = context;
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(ephemeralKeyProvider2, "ephemeralKeyProvider");
            StripeOperationIdFactory stripeOperationIdFactory = new StripeOperationIdFactory();
            Function0 function0 = CustomerSession$Companion$initCustomerSession$timeSupplier$1.INSTANCE;
            OperationIdFactory operationIdFactory = stripeOperationIdFactory;
            EphemeralKeyManager.Factory.Default defaultR = new EphemeralKeyManager.Factory.Default(ephemeralKeyProvider2, z, operationIdFactory, function0);
            PaymentConfiguration instance = PaymentConfiguration.Companion.getInstance(context2);
            PaymentConfiguration paymentConfiguration = instance;
            new CustomerSession(context3, new StripeApiRepository(context3, new CustomerSession$Companion$initCustomerSession$1(instance), Stripe.Companion.getAppInfo(), (Logger) null, (CoroutineContext) null, (Set) null, (StripeNetworkClient) null, (AnalyticsRequestExecutor) null, (FraudDetectionDataRepository) null, (PaymentAnalyticsRequestFactory) null, (FraudDetectionDataParamsUtils) null, (Set) null, (String) null, (String) null, 16376, (DefaultConstructorMarker) null), paymentConfiguration.getPublishableKey(), paymentConfiguration.getStripeAccountId(), createCoroutineDispatcher(), operationIdFactory, function0, defaultR);
            setInstance$payments_core_release(customerSession);
        }

        public final CustomerSession getInstance$payments_core_release() {
            return CustomerSession.instance;
        }

        public final void setInstance$payments_core_release(CustomerSession customerSession) {
            CustomerSession.instance = customerSession;
        }

        @JvmStatic
        public final CustomerSession getInstance() {
            CustomerSession instance$payments_core_release = getInstance$payments_core_release();
            if (instance$payments_core_release != null) {
                return instance$payments_core_release;
            }
            throw new IllegalStateException("Attempted to get instance of CustomerSession without initialization.".toString());
        }

        @JvmStatic
        public final void endCustomerSession() {
            clearInstance$payments_core_release();
        }

        public final /* synthetic */ void clearInstance$payments_core_release() {
            cancelCallbacks();
            setInstance$payments_core_release((CustomerSession) null);
        }

        @JvmStatic
        public final void cancelCallbacks() {
            CustomerSession instance$payments_core_release = getInstance$payments_core_release();
            if (instance$payments_core_release != null) {
                instance$payments_core_release.cancel$payments_core_release();
            }
        }

        /* access modifiers changed from: private */
        public final CoroutineContext createCoroutineDispatcher() {
            return ExecutorsKt.from((ExecutorService) new ThreadPoolExecutor(3, 3, 2, CustomerSession.KEEP_ALIVE_TIME_UNIT, new LinkedBlockingQueue()));
        }
    }
}
