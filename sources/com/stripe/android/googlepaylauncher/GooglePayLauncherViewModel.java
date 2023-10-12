package com.stripe.android.googlepaylauncher;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.android.gms.wallet.PaymentsClient;
import com.stripe.android.FraudDetectionDataRepository;
import com.stripe.android.GooglePayConfig;
import com.stripe.android.GooglePayJsonFactory;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.PaymentController;
import com.stripe.android.StripePaymentController;
import com.stripe.android.core.AppInfo;
import com.stripe.android.core.Logger;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.core.networking.StripeNetworkClient;
import com.stripe.android.googlepaylauncher.GooglePayLauncher;
import com.stripe.android.googlepaylauncher.GooglePayLauncherContract;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.ConfirmSetupIntentParams;
import com.stripe.android.model.ConfirmStripeIntentParams;
import com.stripe.android.model.MandateDataParams;
import com.stripe.android.model.PaymentIntent;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.model.PaymentMethodOptionsParams;
import com.stripe.android.model.SetupIntent;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.networking.AlipayRepository;
import com.stripe.android.networking.FraudDetectionDataParamsUtils;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeApiRepository;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.view.AuthActivityStarterHost;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001:\u0001?B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J!\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'H@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0019\u0010*\u001a\u00020+2\u0006\u0010\u0006\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010,J\u001d\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0001¢\u0006\u0002\b3J#\u00104\u001a\u00020\u00132\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208H@ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u0011\u0010;\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0016\u0010<\u001a\u00020 2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000208J\u000e\u0010=\u001a\u00020 2\u0006\u0010>\u001a\u00020\u0013R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00130\u00130\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006@"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncherViewModel;", "Landroidx/lifecycle/ViewModel;", "paymentsClient", "Lcom/google/android/gms/wallet/PaymentsClient;", "requestOptions", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "args", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherContract$Args;", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "paymentController", "Lcom/stripe/android/PaymentController;", "googlePayJsonFactory", "Lcom/stripe/android/GooglePayJsonFactory;", "googlePayRepository", "Lcom/stripe/android/googlepaylauncher/GooglePayRepository;", "(Lcom/google/android/gms/wallet/PaymentsClient;Lcom/stripe/android/core/networking/ApiRequest$Options;Lcom/stripe/android/googlepaylauncher/GooglePayLauncherContract$Args;Lcom/stripe/android/networking/StripeRepository;Lcom/stripe/android/PaymentController;Lcom/stripe/android/GooglePayJsonFactory;Lcom/stripe/android/googlepaylauncher/GooglePayRepository;)V", "_googleResult", "Landroidx/lifecycle/MutableLiveData;", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Result;", "googlePayResult", "Landroidx/lifecycle/LiveData;", "kotlin.jvm.PlatformType", "getGooglePayResult$payments_core_release", "()Landroidx/lifecycle/LiveData;", "hasLaunched", "", "getHasLaunched", "()Z", "setHasLaunched", "(Z)V", "confirmStripeIntent", "", "host", "Lcom/stripe/android/view/AuthActivityStarterHost;", "params", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "(Lcom/stripe/android/view/AuthActivityStarterHost;Lcom/stripe/android/model/PaymentMethodCreateParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createLoadPaymentDataTask", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/gms/wallet/PaymentData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPaymentDataRequest", "Lorg/json/JSONObject;", "(Lcom/stripe/android/googlepaylauncher/GooglePayLauncherContract$Args;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createTransactionInfo", "Lcom/stripe/android/GooglePayJsonFactory$TransactionInfo;", "stripeIntent", "Lcom/stripe/android/model/StripeIntent;", "currencyCode", "", "createTransactionInfo$payments_core_release", "getResultFromConfirmation", "requestCode", "", "data", "Landroid/content/Intent;", "getResultFromConfirmation$payments_core_release", "(ILandroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isReadyToPay", "onConfirmResult", "updateResult", "result", "Factory", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayLauncherViewModel.kt */
public final class GooglePayLauncherViewModel extends ViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<GooglePayLauncher.Result> _googleResult;
    private final GooglePayLauncherContract.Args args;
    private final GooglePayJsonFactory googlePayJsonFactory;
    private final GooglePayRepository googlePayRepository;
    private final LiveData<GooglePayLauncher.Result> googlePayResult;
    private boolean hasLaunched;
    private final PaymentController paymentController;
    private final PaymentsClient paymentsClient;
    private final ApiRequest.Options requestOptions;
    private final StripeRepository stripeRepository;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayLauncherViewModel.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GooglePayLauncher.BillingAddressConfig.Format.values().length];
            iArr[GooglePayLauncher.BillingAddressConfig.Format.Min.ordinal()] = 1;
            iArr[GooglePayLauncher.BillingAddressConfig.Format.Full.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public GooglePayLauncherViewModel(PaymentsClient paymentsClient2, ApiRequest.Options options, GooglePayLauncherContract.Args args2, StripeRepository stripeRepository2, PaymentController paymentController2, GooglePayJsonFactory googlePayJsonFactory2, GooglePayRepository googlePayRepository2) {
        Intrinsics.checkNotNullParameter(paymentsClient2, "paymentsClient");
        Intrinsics.checkNotNullParameter(options, "requestOptions");
        Intrinsics.checkNotNullParameter(args2, "args");
        Intrinsics.checkNotNullParameter(stripeRepository2, "stripeRepository");
        Intrinsics.checkNotNullParameter(paymentController2, "paymentController");
        Intrinsics.checkNotNullParameter(googlePayJsonFactory2, "googlePayJsonFactory");
        Intrinsics.checkNotNullParameter(googlePayRepository2, "googlePayRepository");
        this.paymentsClient = paymentsClient2;
        this.requestOptions = options;
        this.args = args2;
        this.stripeRepository = stripeRepository2;
        this.paymentController = paymentController2;
        this.googlePayJsonFactory = googlePayJsonFactory2;
        this.googlePayRepository = googlePayRepository2;
        MutableLiveData<GooglePayLauncher.Result> mutableLiveData = new MutableLiveData<>();
        this._googleResult = mutableLiveData;
        LiveData<GooglePayLauncher.Result> distinctUntilChanged = Transformations.distinctUntilChanged(mutableLiveData);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "distinctUntilChanged(this)");
        this.googlePayResult = distinctUntilChanged;
    }

    public final boolean getHasLaunched() {
        return this.hasLaunched;
    }

    public final void setHasLaunched(boolean z) {
        this.hasLaunched = z;
    }

    public final LiveData<GooglePayLauncher.Result> getGooglePayResult$payments_core_release() {
        return this.googlePayResult;
    }

    public final void updateResult(GooglePayLauncher.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this._googleResult.setValue(result);
    }

    public final Object isReadyToPay(Continuation<? super Boolean> continuation) {
        return FlowKt.first(this.googlePayRepository.isReady(), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createPaymentDataRequest(com.stripe.android.googlepaylauncher.GooglePayLauncherContract.Args r11, kotlin.coroutines.Continuation<? super org.json.JSONObject> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel$createPaymentDataRequest$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel$createPaymentDataRequest$1 r0 = (com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel$createPaymentDataRequest$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel$createPaymentDataRequest$1 r0 = new com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel$createPaymentDataRequest$1
            r0.<init>(r10, r12)
        L_0x0019:
            r5 = r0
            java.lang.Object r12 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r8 = 2
            r9 = 1
            if (r1 == 0) goto L_0x004b
            if (r1 == r9) goto L_0x003f
            if (r1 != r8) goto L_0x0037
            java.lang.Object r11 = r5.L$1
            com.stripe.android.googlepaylauncher.GooglePayLauncherContract$Args r11 = (com.stripe.android.googlepaylauncher.GooglePayLauncherContract.Args) r11
            java.lang.Object r0 = r5.L$0
            com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel r0 = (com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00a8
        L_0x0037:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003f:
            java.lang.Object r11 = r5.L$1
            com.stripe.android.googlepaylauncher.GooglePayLauncherContract$Args r11 = (com.stripe.android.googlepaylauncher.GooglePayLauncherContract.Args) r11
            java.lang.Object r0 = r5.L$0
            com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel r0 = (com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel) r0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x006b
        L_0x004b:
            kotlin.ResultKt.throwOnFailure(r12)
            boolean r12 = r11 instanceof com.stripe.android.googlepaylauncher.GooglePayLauncherContract.PaymentIntentArgs
            if (r12 == 0) goto L_0x008b
            com.stripe.android.networking.StripeRepository r1 = r10.stripeRepository
            java.lang.String r2 = r11.getClientSecret$payments_core_release()
            com.stripe.android.core.networking.ApiRequest$Options r3 = r10.requestOptions
            r4 = 0
            r6 = 4
            r7 = 0
            r5.L$0 = r10
            r5.L$1 = r11
            r5.label = r9
            java.lang.Object r12 = com.stripe.android.networking.StripeRepository.retrievePaymentIntent$default(r1, r2, r3, r4, r5, r6, r7)
            if (r12 != r0) goto L_0x006a
            return r0
        L_0x006a:
            r0 = r10
        L_0x006b:
            if (r12 == 0) goto L_0x007f
            com.stripe.android.model.PaymentIntent r12 = (com.stripe.android.model.PaymentIntent) r12
            r1 = r12
            com.stripe.android.model.StripeIntent r1 = (com.stripe.android.model.StripeIntent) r1
            java.lang.String r12 = r12.getCurrency()
            if (r12 != 0) goto L_0x007a
            java.lang.String r12 = ""
        L_0x007a:
            com.stripe.android.GooglePayJsonFactory$TransactionInfo r12 = r0.createTransactionInfo$payments_core_release(r1, r12)
            goto L_0x00b9
        L_0x007f:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "Could not retrieve PaymentIntent."
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x008b:
            boolean r12 = r11 instanceof com.stripe.android.googlepaylauncher.GooglePayLauncherContract.SetupIntentArgs
            if (r12 == 0) goto L_0x0125
            com.stripe.android.networking.StripeRepository r1 = r10.stripeRepository
            java.lang.String r2 = r11.getClientSecret$payments_core_release()
            com.stripe.android.core.networking.ApiRequest$Options r3 = r10.requestOptions
            r4 = 0
            r6 = 4
            r7 = 0
            r5.L$0 = r10
            r5.L$1 = r11
            r5.label = r8
            java.lang.Object r12 = com.stripe.android.networking.StripeRepository.retrieveSetupIntent$default(r1, r2, r3, r4, r5, r6, r7)
            if (r12 != r0) goto L_0x00a7
            return r0
        L_0x00a7:
            r0 = r10
        L_0x00a8:
            if (r12 == 0) goto L_0x0119
            com.stripe.android.model.SetupIntent r12 = (com.stripe.android.model.SetupIntent) r12
            com.stripe.android.model.StripeIntent r12 = (com.stripe.android.model.StripeIntent) r12
            r1 = r11
            com.stripe.android.googlepaylauncher.GooglePayLauncherContract$SetupIntentArgs r1 = (com.stripe.android.googlepaylauncher.GooglePayLauncherContract.SetupIntentArgs) r1
            java.lang.String r1 = r1.getCurrencyCode$payments_core_release()
            com.stripe.android.GooglePayJsonFactory$TransactionInfo r12 = r0.createTransactionInfo$payments_core_release(r12, r1)
        L_0x00b9:
            r1 = r12
            com.stripe.android.GooglePayJsonFactory r0 = r0.googlePayJsonFactory
            com.stripe.android.GooglePayJsonFactory$MerchantInfo r5 = new com.stripe.android.GooglePayJsonFactory$MerchantInfo
            com.stripe.android.googlepaylauncher.GooglePayLauncher$Config r12 = r11.getConfig$payments_core_release()
            java.lang.String r12 = r12.getMerchantName()
            r5.<init>(r12)
            com.stripe.android.GooglePayJsonFactory$BillingAddressParameters r2 = new com.stripe.android.GooglePayJsonFactory$BillingAddressParameters
            com.stripe.android.googlepaylauncher.GooglePayLauncher$Config r12 = r11.getConfig$payments_core_release()
            com.stripe.android.googlepaylauncher.GooglePayLauncher$BillingAddressConfig r12 = r12.getBillingAddressConfig()
            boolean r12 = r12.isRequired$payments_core_release()
            com.stripe.android.googlepaylauncher.GooglePayLauncher$Config r3 = r11.getConfig$payments_core_release()
            com.stripe.android.googlepaylauncher.GooglePayLauncher$BillingAddressConfig r3 = r3.getBillingAddressConfig()
            com.stripe.android.googlepaylauncher.GooglePayLauncher$BillingAddressConfig$Format r3 = r3.getFormat$payments_core_release()
            int[] r4 = com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel.WhenMappings.$EnumSwitchMapping$0
            int r3 = r3.ordinal()
            r3 = r4[r3]
            if (r3 == r9) goto L_0x00f8
            if (r3 != r8) goto L_0x00f2
            com.stripe.android.GooglePayJsonFactory$BillingAddressParameters$Format r3 = com.stripe.android.GooglePayJsonFactory.BillingAddressParameters.Format.Full
            goto L_0x00fa
        L_0x00f2:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        L_0x00f8:
            com.stripe.android.GooglePayJsonFactory$BillingAddressParameters$Format r3 = com.stripe.android.GooglePayJsonFactory.BillingAddressParameters.Format.Min
        L_0x00fa:
            com.stripe.android.googlepaylauncher.GooglePayLauncher$Config r4 = r11.getConfig$payments_core_release()
            com.stripe.android.googlepaylauncher.GooglePayLauncher$BillingAddressConfig r4 = r4.getBillingAddressConfig()
            boolean r4 = r4.isPhoneNumberRequired$payments_core_release()
            r2.<init>(r12, r3, r4)
            com.stripe.android.googlepaylauncher.GooglePayLauncher$Config r11 = r11.getConfig$payments_core_release()
            boolean r4 = r11.isEmailRequired()
            r3 = 0
            r6 = 4
            r7 = 0
            org.json.JSONObject r11 = com.stripe.android.GooglePayJsonFactory.createPaymentDataRequest$default(r0, r1, r2, r3, r4, r5, r6, r7)
            return r11
        L_0x0119:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "Could not retrieve SetupIntent."
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x0125:
            kotlin.NoWhenBranchMatchedException r11 = new kotlin.NoWhenBranchMatchedException
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel.createPaymentDataRequest(com.stripe.android.googlepaylauncher.GooglePayLauncherContract$Args, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final GooglePayJsonFactory.TransactionInfo createTransactionInfo$payments_core_release(StripeIntent stripeIntent, String str) {
        Intrinsics.checkNotNullParameter(stripeIntent, "stripeIntent");
        Intrinsics.checkNotNullParameter(str, "currencyCode");
        if (stripeIntent instanceof PaymentIntent) {
            GooglePayJsonFactory.TransactionInfo.TotalPriceStatus totalPriceStatus = GooglePayJsonFactory.TransactionInfo.TotalPriceStatus.Final;
            String merchantCountryCode = this.args.getConfig$payments_core_release().getMerchantCountryCode();
            String id = stripeIntent.getId();
            Long amount = ((PaymentIntent) stripeIntent).getAmount();
            return new GooglePayJsonFactory.TransactionInfo(str, totalPriceStatus, merchantCountryCode, id, amount == null ? null : Integer.valueOf((int) amount.longValue()), (String) null, GooglePayJsonFactory.TransactionInfo.CheckoutOption.CompleteImmediatePurchase, 32, (DefaultConstructorMarker) null);
        } else if (stripeIntent instanceof SetupIntent) {
            return new GooglePayJsonFactory.TransactionInfo(str, GooglePayJsonFactory.TransactionInfo.TotalPriceStatus.Estimated, this.args.getConfig$payments_core_release().getMerchantCountryCode(), stripeIntent.getId(), 0, (String) null, GooglePayJsonFactory.TransactionInfo.CheckoutOption.Default, 32, (DefaultConstructorMarker) null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createLoadPaymentDataTask(kotlin.coroutines.Continuation<? super com.google.android.gms.tasks.Task<com.google.android.gms.wallet.PaymentData>> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel$createLoadPaymentDataTask$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel$createLoadPaymentDataTask$1 r0 = (com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel$createLoadPaymentDataTask$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel$createLoadPaymentDataTask$1 r0 = new com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel$createLoadPaymentDataTask$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r0 = r0.L$0
            com.google.android.gms.wallet.PaymentsClient r0 = (com.google.android.gms.wallet.PaymentsClient) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x006a
        L_0x0031:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0039:
            java.lang.Object r2 = r0.L$0
            com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel r2 = (com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0050
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r6.isReadyToPay(r0)
            if (r7 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r2 = r6
        L_0x0050:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x007e
            com.google.android.gms.wallet.PaymentsClient r7 = r2.paymentsClient
            com.stripe.android.googlepaylauncher.GooglePayLauncherContract$Args r4 = r2.args
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r0 = r2.createPaymentDataRequest(r4, r0)
            if (r0 != r1) goto L_0x0067
            return r1
        L_0x0067:
            r5 = r0
            r0 = r7
            r7 = r5
        L_0x006a:
            org.json.JSONObject r7 = (org.json.JSONObject) r7
            java.lang.String r7 = r7.toString()
            com.google.android.gms.wallet.PaymentDataRequest r7 = com.google.android.gms.wallet.PaymentDataRequest.fromJson(r7)
            com.google.android.gms.tasks.Task r7 = r0.loadPaymentData(r7)
            java.lang.String r0 = "paymentsClient.loadPayme…)\n            )\n        )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            return r7
        L_0x007e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "Google Pay is unavailable."
            java.lang.String r0 = r0.toString()
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel.createLoadPaymentDataTask(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object confirmStripeIntent(AuthActivityStarterHost authActivityStarterHost, PaymentMethodCreateParams paymentMethodCreateParams, Continuation<? super Unit> continuation) {
        ConfirmStripeIntentParams confirmStripeIntentParams;
        GooglePayLauncherContract.Args args2 = this.args;
        if (args2 instanceof GooglePayLauncherContract.PaymentIntentArgs) {
            confirmStripeIntentParams = ConfirmPaymentIntentParams.Companion.createWithPaymentMethodCreateParams$default(ConfirmPaymentIntentParams.Companion, paymentMethodCreateParams, this.args.getClientSecret$payments_core_release(), (Boolean) null, (String) null, (MandateDataParams) null, (ConfirmPaymentIntentParams.SetupFutureUsage) null, (ConfirmPaymentIntentParams.Shipping) null, (PaymentMethodOptionsParams) null, 252, (Object) null);
        } else if (args2 instanceof GooglePayLauncherContract.SetupIntentArgs) {
            confirmStripeIntentParams = ConfirmSetupIntentParams.Companion.create$default(ConfirmSetupIntentParams.Companion, paymentMethodCreateParams, this.args.getClientSecret$payments_core_release(), (MandateDataParams) null, (String) null, 12, (Object) null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        AuthActivityStarterHost authActivityStarterHost2 = authActivityStarterHost;
        Object startConfirmAndAuth = this.paymentController.startConfirmAndAuth(authActivityStarterHost, confirmStripeIntentParams, this.requestOptions, continuation);
        return startConfirmAndAuth == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? startConfirmAndAuth : Unit.INSTANCE;
    }

    public final void onConfirmResult(int i, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "data");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new GooglePayLauncherViewModel$onConfirmResult$1(this, i, intent, (Continuation<? super GooglePayLauncherViewModel$onConfirmResult$1>) null), 3, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getResultFromConfirmation$payments_core_release(int r6, android.content.Intent r7, kotlin.coroutines.Continuation<? super com.stripe.android.googlepaylauncher.GooglePayLauncher.Result> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel$getResultFromConfirmation$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel$getResultFromConfirmation$1 r0 = (com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel$getResultFromConfirmation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel$getResultFromConfirmation$1 r0 = new com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel$getResultFromConfirmation$1
            r0.<init>(r5, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0079 }
            goto L_0x006a
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0079 }
            goto L_0x0054
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x0079 }
            r8 = r5
            com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel r8 = (com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel) r8     // Catch:{ all -> 0x0079 }
            com.stripe.android.PaymentController r2 = r8.paymentController     // Catch:{ all -> 0x0079 }
            boolean r2 = r2.shouldHandlePaymentResult(r6, r7)     // Catch:{ all -> 0x0079 }
            if (r2 == 0) goto L_0x0057
            com.stripe.android.PaymentController r6 = r8.paymentController     // Catch:{ all -> 0x0079 }
            r0.label = r4     // Catch:{ all -> 0x0079 }
            java.lang.Object r6 = r6.getPaymentIntentResult(r7, r0)     // Catch:{ all -> 0x0079 }
            if (r6 != r1) goto L_0x0054
            return r1
        L_0x0054:
            com.stripe.android.googlepaylauncher.GooglePayLauncher$Result$Completed r6 = com.stripe.android.googlepaylauncher.GooglePayLauncher.Result.Completed.INSTANCE     // Catch:{ all -> 0x0079 }
            goto L_0x006c
        L_0x0057:
            com.stripe.android.PaymentController r2 = r8.paymentController     // Catch:{ all -> 0x0079 }
            boolean r6 = r2.shouldHandleSetupResult(r6, r7)     // Catch:{ all -> 0x0079 }
            if (r6 == 0) goto L_0x0071
            com.stripe.android.PaymentController r6 = r8.paymentController     // Catch:{ all -> 0x0079 }
            r0.label = r3     // Catch:{ all -> 0x0079 }
            java.lang.Object r6 = r6.getSetupIntentResult(r7, r0)     // Catch:{ all -> 0x0079 }
            if (r6 != r1) goto L_0x006a
            return r1
        L_0x006a:
            com.stripe.android.googlepaylauncher.GooglePayLauncher$Result$Completed r6 = com.stripe.android.googlepaylauncher.GooglePayLauncher.Result.Completed.INSTANCE     // Catch:{ all -> 0x0079 }
        L_0x006c:
            java.lang.Object r6 = kotlin.Result.m4709constructorimpl(r6)     // Catch:{ all -> 0x0079 }
            goto L_0x0084
        L_0x0071:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0079 }
            java.lang.String r7 = "Unexpected confirmation result."
            r6.<init>(r7)     // Catch:{ all -> 0x0079 }
            throw r6     // Catch:{ all -> 0x0079 }
        L_0x0079:
            r6 = move-exception
            kotlin.Result$Companion r7 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)
            java.lang.Object r6 = kotlin.Result.m4709constructorimpl(r6)
        L_0x0084:
            java.lang.Throwable r7 = kotlin.Result.m4712exceptionOrNullimpl(r6)
            if (r7 != 0) goto L_0x008b
            goto L_0x0092
        L_0x008b:
            com.stripe.android.googlepaylauncher.GooglePayLauncher$Result$Failed r6 = new com.stripe.android.googlepaylauncher.GooglePayLauncher$Result$Failed
            r6.<init>(r7)
            com.stripe.android.googlepaylauncher.GooglePayLauncher$Result r6 = (com.stripe.android.googlepaylauncher.GooglePayLauncher.Result) r6
        L_0x0092:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.googlepaylauncher.GooglePayLauncherViewModel.getResultFromConfirmation$payments_core_release(int, android.content.Intent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ%\u0010\u000b\u001a\u0002H\f\"\b\b\u0000\u0010\f*\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u000fH\u0016¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayLauncherViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "application", "Landroid/app/Application;", "args", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncherContract$Args;", "enableLogging", "", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/app/Application;Lcom/stripe/android/googlepaylauncher/GooglePayLauncherContract$Args;ZLkotlin/coroutines/CoroutineContext;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayLauncherViewModel.kt */
    public static final class Factory implements ViewModelProvider.Factory {
        private final Application application;
        private final GooglePayLauncherContract.Args args;
        private final boolean enableLogging;
        private final CoroutineContext workContext;

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return ViewModelProvider.Factory.CC.$default$create(this, cls, creationExtras);
        }

        public Factory(Application application2, GooglePayLauncherContract.Args args2, boolean z, CoroutineContext coroutineContext) {
            Intrinsics.checkNotNullParameter(application2, "application");
            Intrinsics.checkNotNullParameter(args2, "args");
            Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
            this.application = application2;
            this.args = args2;
            this.enableLogging = z;
            this.workContext = coroutineContext;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Factory(Application application2, GooglePayLauncherContract.Args args2, boolean z, CoroutineContext coroutineContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(application2, args2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? Dispatchers.getIO() : coroutineContext);
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            GooglePayEnvironment environment = this.args.getConfig$payments_core_release().getEnvironment();
            Logger instance = Logger.Companion.getInstance(this.enableLogging);
            PaymentConfiguration instance2 = PaymentConfiguration.Companion.getInstance(this.application);
            String publishableKey = instance2.getPublishableKey();
            String stripeAccountId = instance2.getStripeAccountId();
            Set of = SetsKt.setOf(GooglePayLauncher.PRODUCT_USAGE);
            PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory = r5;
            PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory2 = new PaymentAnalyticsRequestFactory((Context) this.application, publishableKey, (Set<String>) of);
            String str = publishableKey;
            StripeApiRepository stripeApiRepository = new StripeApiRepository(this.application, new GooglePayLauncherViewModel$Factory$create$stripeRepository$1(publishableKey), (AppInfo) null, instance, this.workContext, of, (StripeNetworkClient) null, (AnalyticsRequestExecutor) null, (FraudDetectionDataRepository) null, paymentAnalyticsRequestFactory, (FraudDetectionDataParamsUtils) null, (Set) null, (String) null, (String) null, 15812, (DefaultConstructorMarker) null);
            DefaultGooglePayRepository defaultGooglePayRepository = new DefaultGooglePayRepository(this.application, this.args.getConfig$payments_core_release().getEnvironment(), GooglePayConfigConversionKtxKt.convert(this.args.getConfig$payments_core_release().getBillingAddressConfig()), this.args.getConfig$payments_core_release().getExistingPaymentMethodRequired(), instance);
            PaymentsClient create = new PaymentsClientFactory(this.application).create(environment);
            ApiRequest.Options options = new ApiRequest.Options(str, stripeAccountId, (String) null, 4, (DefaultConstructorMarker) null);
            GooglePayLauncherContract.Args args2 = this.args;
            StripeRepository stripeRepository = stripeApiRepository;
            String str2 = str;
            boolean z = this.enableLogging;
            return (ViewModel) new GooglePayLauncherViewModel(create, options, args2, stripeRepository, new StripePaymentController(this.application, new GooglePayLauncherViewModel$Factory$create$1(str2), stripeRepository, z, this.workContext, (AnalyticsRequestExecutor) null, (PaymentAnalyticsRequestFactory) null, (AlipayRepository) null, (CoroutineContext) null, 480, (DefaultConstructorMarker) null), new GooglePayJsonFactory(new GooglePayConfig(str2, stripeAccountId), this.args.getConfig$payments_core_release().isJcbEnabled$payments_core_release()), defaultGooglePayRepository);
        }
    }
}
