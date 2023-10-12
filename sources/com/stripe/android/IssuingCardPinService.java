package com.stripe.android;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.stripe.android.EphemeralOperation;
import com.stripe.android.core.AppInfo;
import com.stripe.android.core.Logger;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.StripeNetworkClient;
import com.stripe.android.networking.FraudDetectionDataParamsUtils;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeApiRepository;
import com.stripe.android.networking.StripeRepository;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u000f\b\u0007\u0018\u0000 +2\u00020\u0001:\u0005*+,-.B7\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J \u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u0013H\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0002J!\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010!J!\u0010\"\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010#J&\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0011J.\u0010(\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0013R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00130\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lcom/stripe/android/IssuingCardPinService;", "", "keyProvider", "Lcom/stripe/android/EphemeralKeyProvider;", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "operationIdFactory", "Lcom/stripe/android/OperationIdFactory;", "stripeAccountId", "", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/stripe/android/EphemeralKeyProvider;Lcom/stripe/android/networking/StripeRepository;Lcom/stripe/android/OperationIdFactory;Ljava/lang/String;Lkotlin/coroutines/CoroutineContext;)V", "ephemeralKeyManager", "Lcom/stripe/android/EphemeralKeyManager;", "retrievalListeners", "", "Lcom/stripe/android/IssuingCardPinService$IssuingCardPinRetrievalListener;", "updateListeners", "Lcom/stripe/android/IssuingCardPinService$IssuingCardPinUpdateListener;", "fireRetrievePinRequest", "", "ephemeralKey", "Lcom/stripe/android/EphemeralKey;", "operation", "Lcom/stripe/android/EphemeralOperation$Issuing$RetrievePin;", "listener", "fireUpdatePinRequest", "Lcom/stripe/android/EphemeralOperation$Issuing$UpdatePin;", "logMissingListener", "onRetrievePinError", "throwable", "", "(Ljava/lang/Throwable;Lcom/stripe/android/IssuingCardPinService$IssuingCardPinRetrievalListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onUpdatePinError", "(Ljava/lang/Throwable;Lcom/stripe/android/IssuingCardPinService$IssuingCardPinUpdateListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "retrievePin", "cardId", "verificationId", "userOneTimeCode", "updatePin", "newPin", "CardPinActionError", "Companion", "IssuingCardPinRetrievalListener", "IssuingCardPinUpdateListener", "Listener", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IssuingCardPinService.kt */
public final class IssuingCardPinService {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = IssuingCardPinService.class.getName();
    private final EphemeralKeyManager ephemeralKeyManager;
    private final OperationIdFactory operationIdFactory;
    /* access modifiers changed from: private */
    public final Map<String, IssuingCardPinRetrievalListener> retrievalListeners;
    /* access modifiers changed from: private */
    public final String stripeAccountId;
    /* access modifiers changed from: private */
    public final StripeRepository stripeRepository;
    /* access modifiers changed from: private */
    public final Map<String, IssuingCardPinUpdateListener> updateListeners;
    private final CoroutineContext workContext;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/IssuingCardPinService$CardPinActionError;", "", "(Ljava/lang/String;I)V", "UNKNOWN_ERROR", "EPHEMERAL_KEY_ERROR", "ONE_TIME_CODE_INCORRECT", "ONE_TIME_CODE_EXPIRED", "ONE_TIME_CODE_TOO_MANY_ATTEMPTS", "ONE_TIME_CODE_ALREADY_REDEEMED", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IssuingCardPinService.kt */
    public enum CardPinActionError {
        UNKNOWN_ERROR,
        EPHEMERAL_KEY_ERROR,
        ONE_TIME_CODE_INCORRECT,
        ONE_TIME_CODE_EXPIRED,
        ONE_TIME_CODE_TOO_MANY_ATTEMPTS,
        ONE_TIME_CODE_ALREADY_REDEEMED
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/IssuingCardPinService$IssuingCardPinRetrievalListener;", "Lcom/stripe/android/IssuingCardPinService$Listener;", "onIssuingCardPinRetrieved", "", "pin", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IssuingCardPinService.kt */
    public interface IssuingCardPinRetrievalListener extends Listener {
        void onIssuingCardPinRetrieved(String str);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/stripe/android/IssuingCardPinService$IssuingCardPinUpdateListener;", "Lcom/stripe/android/IssuingCardPinService$Listener;", "onIssuingCardPinUpdated", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IssuingCardPinService.kt */
    public interface IssuingCardPinUpdateListener extends Listener {
        void onIssuingCardPinUpdated();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Lcom/stripe/android/IssuingCardPinService$Listener;", "", "onError", "", "errorCode", "Lcom/stripe/android/IssuingCardPinService$CardPinActionError;", "errorMessage", "", "exception", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IssuingCardPinService.kt */
    public interface Listener {
        void onError(CardPinActionError cardPinActionError, String str, Throwable th);
    }

    @JvmStatic
    public static final IssuingCardPinService create(Context context, EphemeralKeyProvider ephemeralKeyProvider) {
        return Companion.create(context, ephemeralKeyProvider);
    }

    @JvmStatic
    public static final IssuingCardPinService create(Context context, String str, EphemeralKeyProvider ephemeralKeyProvider) {
        return Companion.create(context, str, ephemeralKeyProvider);
    }

    @JvmStatic
    public static final IssuingCardPinService create(Context context, String str, String str2, EphemeralKeyProvider ephemeralKeyProvider) {
        return Companion.create(context, str, str2, ephemeralKeyProvider);
    }

    public IssuingCardPinService(EphemeralKeyProvider ephemeralKeyProvider, StripeRepository stripeRepository2, OperationIdFactory operationIdFactory2, String str, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(ephemeralKeyProvider, "keyProvider");
        Intrinsics.checkNotNullParameter(stripeRepository2, "stripeRepository");
        Intrinsics.checkNotNullParameter(operationIdFactory2, "operationIdFactory");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        this.stripeRepository = stripeRepository2;
        this.operationIdFactory = operationIdFactory2;
        this.stripeAccountId = str;
        this.workContext = coroutineContext;
        this.retrievalListeners = new LinkedHashMap();
        this.updateListeners = new LinkedHashMap();
        this.ephemeralKeyManager = new EphemeralKeyManager(ephemeralKeyProvider, new IssuingCardPinService$ephemeralKeyManager$1(this), operationIdFactory2, true, (Function0) null, 0, 48, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IssuingCardPinService(EphemeralKeyProvider ephemeralKeyProvider, StripeRepository stripeRepository2, OperationIdFactory operationIdFactory2, String str, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ephemeralKeyProvider, stripeRepository2, (i & 4) != 0 ? new StripeOperationIdFactory() : operationIdFactory2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? Dispatchers.getIO() : coroutineContext);
    }

    public final void retrievePin(String str, String str2, String str3, IssuingCardPinRetrievalListener issuingCardPinRetrievalListener) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        Intrinsics.checkNotNullParameter(str2, "verificationId");
        Intrinsics.checkNotNullParameter(str3, "userOneTimeCode");
        Intrinsics.checkNotNullParameter(issuingCardPinRetrievalListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        String create = this.operationIdFactory.create();
        this.retrievalListeners.put(create, issuingCardPinRetrievalListener);
        this.ephemeralKeyManager.retrieveEphemeralKey$payments_core_release(new EphemeralOperation.Issuing.RetrievePin(str, str2, str3, create));
    }

    public final void updatePin(String str, String str2, String str3, String str4, IssuingCardPinUpdateListener issuingCardPinUpdateListener) {
        Intrinsics.checkNotNullParameter(str, "cardId");
        Intrinsics.checkNotNullParameter(str2, "newPin");
        Intrinsics.checkNotNullParameter(str3, "verificationId");
        Intrinsics.checkNotNullParameter(str4, "userOneTimeCode");
        Intrinsics.checkNotNullParameter(issuingCardPinUpdateListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        String create = this.operationIdFactory.create();
        this.updateListeners.put(create, issuingCardPinUpdateListener);
        this.ephemeralKeyManager.retrieveEphemeralKey$payments_core_release(new EphemeralOperation.Issuing.UpdatePin(str, str2, str3, str4, create));
    }

    /* access modifiers changed from: private */
    public final void fireRetrievePinRequest(EphemeralKey ephemeralKey, EphemeralOperation.Issuing.RetrievePin retrievePin, IssuingCardPinRetrievalListener issuingCardPinRetrievalListener) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.workContext), (CoroutineContext) null, (CoroutineStart) null, new IssuingCardPinService$fireRetrievePinRequest$1(this, retrievePin, ephemeralKey, issuingCardPinRetrievalListener, (Continuation<? super IssuingCardPinService$fireRetrievePinRequest$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object onRetrievePinError(Throwable th, IssuingCardPinRetrievalListener issuingCardPinRetrievalListener, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new IssuingCardPinService$onRetrievePinError$2(th, issuingCardPinRetrievalListener, (Continuation<? super IssuingCardPinService$onRetrievePinError$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void fireUpdatePinRequest(EphemeralKey ephemeralKey, EphemeralOperation.Issuing.UpdatePin updatePin, IssuingCardPinUpdateListener issuingCardPinUpdateListener) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.workContext), (CoroutineContext) null, (CoroutineStart) null, new IssuingCardPinService$fireUpdatePinRequest$1(this, updatePin, ephemeralKey, issuingCardPinUpdateListener, (Continuation<? super IssuingCardPinService$fireUpdatePinRequest$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object onUpdatePinError(Throwable th, IssuingCardPinUpdateListener issuingCardPinUpdateListener, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new IssuingCardPinService$onUpdatePinError$2(th, issuingCardPinUpdateListener, (Continuation<? super IssuingCardPinService$onUpdatePinError$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void logMissingListener() {
        Log.e(TAG, Intrinsics.stringPlus(getClass().getName(), " was called without a listener"));
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J,\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/IssuingCardPinService$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "create", "Lcom/stripe/android/IssuingCardPinService;", "context", "Landroid/content/Context;", "keyProvider", "Lcom/stripe/android/EphemeralKeyProvider;", "publishableKey", "stripeAccountId", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IssuingCardPinService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final IssuingCardPinService create(Context context, String str, EphemeralKeyProvider ephemeralKeyProvider) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "publishableKey");
            Intrinsics.checkNotNullParameter(ephemeralKeyProvider, "keyProvider");
            return create$default(this, context, str, (String) null, ephemeralKeyProvider, 4, (Object) null);
        }

        private Companion() {
        }

        @JvmStatic
        public final IssuingCardPinService create(Context context, EphemeralKeyProvider ephemeralKeyProvider) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(ephemeralKeyProvider, "keyProvider");
            PaymentConfiguration instance = PaymentConfiguration.Companion.getInstance(context);
            return create(context, instance.getPublishableKey(), instance.getStripeAccountId(), ephemeralKeyProvider);
        }

        public static /* synthetic */ IssuingCardPinService create$default(Companion companion, Context context, String str, String str2, EphemeralKeyProvider ephemeralKeyProvider, int i, Object obj) {
            if ((i & 4) != 0) {
                str2 = null;
            }
            return companion.create(context, str, str2, ephemeralKeyProvider);
        }

        @JvmStatic
        public final IssuingCardPinService create(Context context, String str, String str2, EphemeralKeyProvider ephemeralKeyProvider) {
            Context context2 = context;
            String str3 = str;
            Intrinsics.checkNotNullParameter(context2, "context");
            Intrinsics.checkNotNullParameter(str3, "publishableKey");
            Intrinsics.checkNotNullParameter(ephemeralKeyProvider, "keyProvider");
            AppInfo appInfo = Stripe.Companion.getAppInfo();
            PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory = r6;
            PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory2 = new PaymentAnalyticsRequestFactory(context2, (Function0<String>) new IssuingCardPinService$Companion$create$2(str3), (Set<String>) SetsKt.setOf("IssuingCardPinService"));
            return new IssuingCardPinService(ephemeralKeyProvider, new StripeApiRepository(context, new IssuingCardPinService$Companion$create$1(str3), appInfo, (Logger) null, (CoroutineContext) null, (Set) null, (StripeNetworkClient) null, (AnalyticsRequestExecutor) null, (FraudDetectionDataRepository) null, paymentAnalyticsRequestFactory, (FraudDetectionDataParamsUtils) null, (Set) null, (String) null, (String) null, 15864, (DefaultConstructorMarker) null), new StripeOperationIdFactory(), str2, (CoroutineContext) null, 16, (DefaultConstructorMarker) null);
        }
    }
}
