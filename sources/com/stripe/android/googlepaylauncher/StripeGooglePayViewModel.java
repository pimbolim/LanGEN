package com.stripe.android.googlepaylauncher;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.android.gms.wallet.IsReadyToPayRequest;
import com.stripe.android.FraudDetectionDataRepository;
import com.stripe.android.GooglePayJsonFactory;
import com.stripe.android.core.AppInfo;
import com.stripe.android.core.Logger;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.StripeNetworkClient;
import com.stripe.android.googlepaylauncher.StripeGooglePayContract;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.networking.FraudDetectionDataParamsUtils;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeApiRepository;
import com.stripe.android.networking.StripeRepository;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u00010BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020(J\u001d\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0*0\u00152\u0006\u0010+\u001a\u00020,ø\u0001\u0000J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0011R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00110\u00110\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00061"}, d2 = {"Lcom/stripe/android/googlepaylauncher/StripeGooglePayViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "publishableKey", "", "stripeAccountId", "args", "Lcom/stripe/android/googlepaylauncher/StripeGooglePayContract$Args;", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "appName", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/googlepaylauncher/StripeGooglePayContract$Args;Lcom/stripe/android/networking/StripeRepository;Ljava/lang/String;Lkotlin/coroutines/CoroutineContext;)V", "_googleResult", "Landroidx/lifecycle/MutableLiveData;", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherResult;", "googlePayJsonFactory", "Lcom/stripe/android/GooglePayJsonFactory;", "googlePayResult", "Landroidx/lifecycle/LiveData;", "kotlin.jvm.PlatformType", "getGooglePayResult$payments_core_release", "()Landroidx/lifecycle/LiveData;", "hasLaunched", "", "getHasLaunched", "()Z", "setHasLaunched", "(Z)V", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "getPaymentMethod", "()Lcom/stripe/android/model/PaymentMethod;", "setPaymentMethod", "(Lcom/stripe/android/model/PaymentMethod;)V", "createIsReadyToPayRequest", "Lcom/google/android/gms/wallet/IsReadyToPayRequest;", "createPaymentDataRequestForPaymentIntentArgs", "Lorg/json/JSONObject;", "createPaymentMethod", "Lkotlin/Result;", "params", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "updateGooglePayResult", "", "result", "Factory", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeGooglePayViewModel.kt */
public final class StripeGooglePayViewModel extends AndroidViewModel {
    private final MutableLiveData<GooglePayLauncherResult> _googleResult;
    private final String appName;
    private final StripeGooglePayContract.Args args;
    private final GooglePayJsonFactory googlePayJsonFactory;
    private final LiveData<GooglePayLauncherResult> googlePayResult;
    private boolean hasLaunched;
    private PaymentMethod paymentMethod;
    /* access modifiers changed from: private */
    public final String publishableKey;
    /* access modifiers changed from: private */
    public final String stripeAccountId;
    /* access modifiers changed from: private */
    public final StripeRepository stripeRepository;
    /* access modifiers changed from: private */
    public final CoroutineContext workContext;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StripeGooglePayViewModel(Application application, String str, String str2, StripeGooglePayContract.Args args2, StripeRepository stripeRepository2, String str3, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, str, (i & 4) != 0 ? null : str2, args2, stripeRepository2, str3, coroutineContext);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StripeGooglePayViewModel(Application application, String str, String str2, StripeGooglePayContract.Args args2, StripeRepository stripeRepository2, String str3, CoroutineContext coroutineContext) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(str, "publishableKey");
        Intrinsics.checkNotNullParameter(args2, "args");
        Intrinsics.checkNotNullParameter(stripeRepository2, "stripeRepository");
        Intrinsics.checkNotNullParameter(str3, "appName");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        this.publishableKey = str;
        this.stripeAccountId = str2;
        this.args = args2;
        this.stripeRepository = stripeRepository2;
        this.appName = str3;
        this.workContext = coroutineContext;
        this.googlePayJsonFactory = new GooglePayJsonFactory((Context) application, false, 2, (DefaultConstructorMarker) null);
        MutableLiveData<GooglePayLauncherResult> mutableLiveData = new MutableLiveData<>();
        this._googleResult = mutableLiveData;
        LiveData<GooglePayLauncherResult> distinctUntilChanged = Transformations.distinctUntilChanged(mutableLiveData);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "distinctUntilChanged(this)");
        this.googlePayResult = distinctUntilChanged;
    }

    public final boolean getHasLaunched() {
        return this.hasLaunched;
    }

    public final void setHasLaunched(boolean z) {
        this.hasLaunched = z;
    }

    public final PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public final void setPaymentMethod(PaymentMethod paymentMethod2) {
        this.paymentMethod = paymentMethod2;
    }

    public final LiveData<GooglePayLauncherResult> getGooglePayResult$payments_core_release() {
        return this.googlePayResult;
    }

    public final IsReadyToPayRequest createIsReadyToPayRequest() {
        IsReadyToPayRequest fromJson = IsReadyToPayRequest.fromJson(GooglePayJsonFactory.createIsReadyToPayRequest$default(this.googlePayJsonFactory, (GooglePayJsonFactory.BillingAddressParameters) null, (Boolean) null, 3, (Object) null).toString());
        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(\n            go…st().toString()\n        )");
        return fromJson;
    }

    public final void updateGooglePayResult(GooglePayLauncherResult googlePayLauncherResult) {
        Intrinsics.checkNotNullParameter(googlePayLauncherResult, "result");
        this._googleResult.setValue(googlePayLauncherResult);
    }

    public final JSONObject createPaymentDataRequestForPaymentIntentArgs() {
        GooglePayJsonFactory googlePayJsonFactory2 = this.googlePayJsonFactory;
        GooglePayJsonFactory.TransactionInfo transactionInfo = new GooglePayJsonFactory.TransactionInfo(this.args.getConfig().getCurrencyCode$payments_core_release(), GooglePayJsonFactory.TransactionInfo.TotalPriceStatus.Final, this.args.getConfig().getCountryCode$payments_core_release(), this.args.getConfig().getTransactionId$payments_core_release(), this.args.getConfig().getAmount$payments_core_release(), (String) null, GooglePayJsonFactory.TransactionInfo.CheckoutOption.CompleteImmediatePurchase, 32, (DefaultConstructorMarker) null);
        String merchantName$payments_core_release = this.args.getConfig().getMerchantName$payments_core_release();
        if (merchantName$payments_core_release == null) {
            merchantName$payments_core_release = this.appName;
        }
        GooglePayJsonFactory.MerchantInfo merchantInfo = new GooglePayJsonFactory.MerchantInfo(merchantName$payments_core_release);
        return GooglePayJsonFactory.createPaymentDataRequest$default(googlePayJsonFactory2, transactionInfo, new GooglePayJsonFactory.BillingAddressParameters(true, GooglePayJsonFactory.BillingAddressParameters.Format.Min, false), (GooglePayJsonFactory.ShippingAddressParameters) null, this.args.getConfig().isEmailRequired$payments_core_release(), merchantInfo, 4, (Object) null);
    }

    public final LiveData<Result<PaymentMethod>> createPaymentMethod(PaymentMethodCreateParams paymentMethodCreateParams) {
        Intrinsics.checkNotNullParameter(paymentMethodCreateParams, "params");
        return CoroutineLiveDataKt.liveData$default((CoroutineContext) null, 0, (Function2) new StripeGooglePayViewModel$createPaymentMethod$1(this, paymentMethodCreateParams, (Continuation<? super StripeGooglePayViewModel$createPaymentMethod$1>) null), 3, (Object) null);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ%\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0016¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/googlepaylauncher/StripeGooglePayViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "application", "Landroid/app/Application;", "publishableKey", "", "stripeAccountId", "args", "Lcom/stripe/android/googlepaylauncher/StripeGooglePayContract$Args;", "(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/googlepaylauncher/StripeGooglePayContract$Args;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeGooglePayViewModel.kt */
    public static final class Factory implements ViewModelProvider.Factory {
        private final Application application;
        private final StripeGooglePayContract.Args args;
        /* access modifiers changed from: private */
        public final String publishableKey;
        private final String stripeAccountId;

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return ViewModelProvider.Factory.CC.$default$create(this, cls, creationExtras);
        }

        public Factory(Application application2, String str, String str2, StripeGooglePayContract.Args args2) {
            Intrinsics.checkNotNullParameter(application2, "application");
            Intrinsics.checkNotNullParameter(str, "publishableKey");
            Intrinsics.checkNotNullParameter(args2, "args");
            this.application = application2;
            this.publishableKey = str;
            this.stripeAccountId = str2;
            this.args = args2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Factory(Application application2, String str, String str2, StripeGooglePayContract.Args args2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(application2, str, (i & 4) != 0 ? null : str2, args2);
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            return (ViewModel) new StripeGooglePayViewModel(this.application, this.publishableKey, this.stripeAccountId, this.args, new StripeApiRepository(this.application, new StripeGooglePayViewModel$Factory$create$1(this), (AppInfo) null, (Logger) null, (CoroutineContext) null, (Set) null, (StripeNetworkClient) null, (AnalyticsRequestExecutor) null, (FraudDetectionDataRepository) null, (PaymentAnalyticsRequestFactory) null, (FraudDetectionDataParamsUtils) null, (Set) null, (String) null, (String) null, 16380, (DefaultConstructorMarker) null), this.application.getApplicationInfo().loadLabel(this.application.getPackageManager()).toString(), Dispatchers.getIO());
        }
    }
}
