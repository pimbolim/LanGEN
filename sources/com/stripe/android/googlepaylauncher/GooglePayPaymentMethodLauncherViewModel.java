package com.stripe.android.googlepaylauncher;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.SavedStateRegistryOwner;
import com.google.android.gms.wallet.PaymentsClient;
import com.stripe.android.GooglePayJsonFactory;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.core.injection.Injectable;
import com.stripe.android.core.injection.InjectableKtxKt;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherContract;
import com.stripe.android.googlepaylauncher.injection.DaggerGooglePayPaymentMethodLauncherViewModelFactoryComponent;
import com.stripe.android.googlepaylauncher.injection.GooglePayPaymentMethodLauncherViewModelSubcomponent;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.payments.core.injection.NamedConstantsKt;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 02\u00020\u0001:\u000201B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H@ø\u0001\u0000¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020%H\u0007J\u0019\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0015\u0010)\u001a\u00020*2\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\b+J\u0011\u0010,\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010#J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0013R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00130\u00130\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u001a8@@@X\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00062"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherViewModel;", "Landroidx/lifecycle/ViewModel;", "paymentsClient", "Lcom/google/android/gms/wallet/PaymentsClient;", "requestOptions", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "args", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherContract$Args;", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "googlePayJsonFactory", "Lcom/stripe/android/GooglePayJsonFactory;", "googlePayRepository", "Lcom/stripe/android/googlepaylauncher/GooglePayRepository;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Lcom/google/android/gms/wallet/PaymentsClient;Lcom/stripe/android/core/networking/ApiRequest$Options;Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherContract$Args;Lcom/stripe/android/networking/StripeRepository;Lcom/stripe/android/GooglePayJsonFactory;Lcom/stripe/android/googlepaylauncher/GooglePayRepository;Landroidx/lifecycle/SavedStateHandle;)V", "_googleResult", "Landroidx/lifecycle/MutableLiveData;", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Result;", "googlePayResult", "Landroidx/lifecycle/LiveData;", "kotlin.jvm.PlatformType", "getGooglePayResult$payments_core_release", "()Landroidx/lifecycle/LiveData;", "value", "", "hasLaunched", "getHasLaunched$payments_core_release", "()Z", "setHasLaunched$payments_core_release", "(Z)V", "createLoadPaymentDataTask", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/gms/wallet/PaymentData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createPaymentDataRequest", "Lorg/json/JSONObject;", "createPaymentMethod", "paymentData", "(Lcom/google/android/gms/wallet/PaymentData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createTransactionInfo", "Lcom/stripe/android/GooglePayJsonFactory$TransactionInfo;", "createTransactionInfo$payments_core_release", "isReadyToPay", "updateResult", "", "result", "Companion", "Factory", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayPaymentMethodLauncherViewModel.kt */
public final class GooglePayPaymentMethodLauncherViewModel extends ViewModel {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String HAS_LAUNCHED_KEY = "has_launched";
    private final MutableLiveData<GooglePayPaymentMethodLauncher.Result> _googleResult;
    private final GooglePayPaymentMethodLauncherContract.Args args;
    private final GooglePayJsonFactory googlePayJsonFactory;
    private final GooglePayRepository googlePayRepository;
    private final LiveData<GooglePayPaymentMethodLauncher.Result> googlePayResult;
    private final PaymentsClient paymentsClient;
    private final ApiRequest.Options requestOptions;
    private final SavedStateHandle savedStateHandle;
    private final StripeRepository stripeRepository;

    @Inject
    public GooglePayPaymentMethodLauncherViewModel(PaymentsClient paymentsClient2, ApiRequest.Options options, GooglePayPaymentMethodLauncherContract.Args args2, StripeRepository stripeRepository2, GooglePayJsonFactory googlePayJsonFactory2, GooglePayRepository googlePayRepository2, SavedStateHandle savedStateHandle2) {
        Intrinsics.checkNotNullParameter(paymentsClient2, "paymentsClient");
        Intrinsics.checkNotNullParameter(options, "requestOptions");
        Intrinsics.checkNotNullParameter(args2, "args");
        Intrinsics.checkNotNullParameter(stripeRepository2, "stripeRepository");
        Intrinsics.checkNotNullParameter(googlePayJsonFactory2, "googlePayJsonFactory");
        Intrinsics.checkNotNullParameter(googlePayRepository2, "googlePayRepository");
        Intrinsics.checkNotNullParameter(savedStateHandle2, "savedStateHandle");
        this.paymentsClient = paymentsClient2;
        this.requestOptions = options;
        this.args = args2;
        this.stripeRepository = stripeRepository2;
        this.googlePayJsonFactory = googlePayJsonFactory2;
        this.googlePayRepository = googlePayRepository2;
        this.savedStateHandle = savedStateHandle2;
        MutableLiveData<GooglePayPaymentMethodLauncher.Result> mutableLiveData = new MutableLiveData<>();
        this._googleResult = mutableLiveData;
        LiveData<GooglePayPaymentMethodLauncher.Result> distinctUntilChanged = Transformations.distinctUntilChanged(mutableLiveData);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "distinctUntilChanged(this)");
        this.googlePayResult = distinctUntilChanged;
    }

    public final boolean getHasLaunched$payments_core_release() {
        return Intrinsics.areEqual(this.savedStateHandle.get("has_launched"), (Object) true);
    }

    public final void setHasLaunched$payments_core_release(boolean z) {
        this.savedStateHandle.set("has_launched", Boolean.valueOf(z));
    }

    public final LiveData<GooglePayPaymentMethodLauncher.Result> getGooglePayResult$payments_core_release() {
        return this.googlePayResult;
    }

    public final void updateResult(GooglePayPaymentMethodLauncher.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this._googleResult.setValue(result);
    }

    public final Object isReadyToPay(Continuation<? super Boolean> continuation) {
        return FlowKt.first(this.googlePayRepository.isReady(), continuation);
    }

    public final JSONObject createPaymentDataRequest() {
        return GooglePayJsonFactory.createPaymentDataRequest$default(this.googlePayJsonFactory, createTransactionInfo$payments_core_release(this.args), GooglePayConfigConversionKtxKt.convert(this.args.getConfig$payments_core_release().getBillingAddressConfig()), (GooglePayJsonFactory.ShippingAddressParameters) null, this.args.getConfig$payments_core_release().isEmailRequired(), new GooglePayJsonFactory.MerchantInfo(this.args.getConfig$payments_core_release().getMerchantName()), 4, (Object) null);
    }

    public final GooglePayJsonFactory.TransactionInfo createTransactionInfo$payments_core_release(GooglePayPaymentMethodLauncherContract.Args args2) {
        Intrinsics.checkNotNullParameter(args2, "args");
        return new GooglePayJsonFactory.TransactionInfo(args2.getCurrencyCode$payments_core_release(), GooglePayJsonFactory.TransactionInfo.TotalPriceStatus.Estimated, args2.getConfig$payments_core_release().getMerchantCountryCode(), args2.getTransactionId$payments_core_release(), Integer.valueOf(args2.getAmount$payments_core_release()), (String) null, GooglePayJsonFactory.TransactionInfo.CheckoutOption.Default, 32, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createLoadPaymentDataTask(kotlin.coroutines.Continuation<? super com.google.android.gms.tasks.Task<com.google.android.gms.wallet.PaymentData>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel$createLoadPaymentDataTask$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel$createLoadPaymentDataTask$1 r0 = (com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel$createLoadPaymentDataTask$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel$createLoadPaymentDataTask$1 r0 = new com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel$createLoadPaymentDataTask$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel r0 = (com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0045
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r4.isReadyToPay(r0)
            if (r5 != r1) goto L_0x0044
            return r1
        L_0x0044:
            r0 = r4
        L_0x0045:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0065
            com.google.android.gms.wallet.PaymentsClient r5 = r0.paymentsClient
            org.json.JSONObject r0 = r0.createPaymentDataRequest()
            java.lang.String r0 = r0.toString()
            com.google.android.gms.wallet.PaymentDataRequest r0 = com.google.android.gms.wallet.PaymentDataRequest.fromJson(r0)
            com.google.android.gms.tasks.Task r5 = r5.loadPaymentData(r0)
            java.lang.String r0 = "paymentsClient.loadPayme…t().toString())\n        )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            return r5
        L_0x0065:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Google Pay is unavailable."
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel.createLoadPaymentDataTask(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058 A[Catch:{ all -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f A[Catch:{ all -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createPaymentMethod(com.google.android.gms.wallet.PaymentData r5, kotlin.coroutines.Continuation<? super com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.Result> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel$createPaymentMethod$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel$createPaymentMethod$1 r0 = (com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel$createPaymentMethod$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel$createPaymentMethod$1 r0 = new com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel$createPaymentMethod$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x006b }
            goto L_0x0056
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            org.json.JSONObject r6 = new org.json.JSONObject
            java.lang.String r5 = r5.toJson()
            r6.<init>(r5)
            com.stripe.android.model.PaymentMethodCreateParams$Companion r5 = com.stripe.android.model.PaymentMethodCreateParams.Companion
            com.stripe.android.model.PaymentMethodCreateParams r5 = r5.createFromGooglePay(r6)
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x006b }
            r6 = r4
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel r6 = (com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel) r6     // Catch:{ all -> 0x006b }
            com.stripe.android.networking.StripeRepository r2 = r6.stripeRepository     // Catch:{ all -> 0x006b }
            com.stripe.android.core.networking.ApiRequest$Options r6 = r6.requestOptions     // Catch:{ all -> 0x006b }
            r0.label = r3     // Catch:{ all -> 0x006b }
            java.lang.Object r6 = r2.createPaymentMethod(r5, r6, r0)     // Catch:{ all -> 0x006b }
            if (r6 != r1) goto L_0x0056
            return r1
        L_0x0056:
            if (r6 == 0) goto L_0x005f
            com.stripe.android.model.PaymentMethod r6 = (com.stripe.android.model.PaymentMethod) r6     // Catch:{ all -> 0x006b }
            java.lang.Object r5 = kotlin.Result.m4709constructorimpl(r6)     // Catch:{ all -> 0x006b }
            goto L_0x0076
        L_0x005f:
            java.lang.String r5 = "Required value was null."
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x006b }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x006b }
            r6.<init>(r5)     // Catch:{ all -> 0x006b }
            throw r6     // Catch:{ all -> 0x006b }
        L_0x006b:
            r5 = move-exception
            kotlin.Result$Companion r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m4709constructorimpl(r5)
        L_0x0076:
            java.lang.Throwable r6 = kotlin.Result.m4712exceptionOrNullimpl(r5)
            if (r6 != 0) goto L_0x0086
            com.stripe.android.model.PaymentMethod r5 = (com.stripe.android.model.PaymentMethod) r5
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$Result$Completed r6 = new com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$Result$Completed
            r6.<init>(r5)
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$Result r6 = (com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.Result) r6
            goto L_0x0099
        L_0x0086:
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$Result$Failed r5 = new com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$Result$Failed
            boolean r0 = r6 instanceof com.stripe.android.core.exception.APIConnectionException
            if (r0 == 0) goto L_0x008e
            r3 = 3
            goto L_0x0093
        L_0x008e:
            boolean r0 = r6 instanceof com.stripe.android.core.exception.InvalidRequestException
            if (r0 == 0) goto L_0x0093
            r3 = 2
        L_0x0093:
            r5.<init>(r6, r3)
            r6 = r5
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$Result r6 = (com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.Result) r6
        L_0x0099:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherViewModel.createPaymentMethod(com.google.android.gms.wallet.PaymentData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001 B)\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ7\u0010\u0013\u001a\u0002H\u0014\"\n\b\u0000\u0010\u0014*\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherViewModel$Factory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "Lcom/stripe/android/core/injection/Injectable;", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherViewModel$Factory$FallbackInjectionParams;", "application", "Landroid/app/Application;", "args", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherContract$Args;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "defaultArgs", "Landroid/os/Bundle;", "(Landroid/app/Application;Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherContract$Args;Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V", "subComponentBuilder", "Lcom/stripe/android/googlepaylauncher/injection/GooglePayPaymentMethodLauncherViewModelSubcomponent$Builder;", "getSubComponentBuilder", "()Lcom/stripe/android/googlepaylauncher/injection/GooglePayPaymentMethodLauncherViewModelSubcomponent$Builder;", "setSubComponentBuilder", "(Lcom/stripe/android/googlepaylauncher/injection/GooglePayPaymentMethodLauncherViewModelSubcomponent$Builder;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "key", "", "modelClass", "Ljava/lang/Class;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "fallbackInitialize", "", "arg", "FallbackInjectionParams", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayPaymentMethodLauncherViewModel.kt */
    public static final class Factory extends AbstractSavedStateViewModelFactory implements Injectable<FallbackInjectionParams> {
        private final Application application;
        private final GooglePayPaymentMethodLauncherContract.Args args;
        @Inject
        public GooglePayPaymentMethodLauncherViewModelSubcomponent.Builder subComponentBuilder;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Factory(Application application2, GooglePayPaymentMethodLauncherContract.Args args2, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(application2, args2, savedStateRegistryOwner, (i & 8) != 0 ? null : bundle);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Factory(Application application2, GooglePayPaymentMethodLauncherContract.Args args2, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
            super(savedStateRegistryOwner, bundle);
            Intrinsics.checkNotNullParameter(application2, "application");
            Intrinsics.checkNotNullParameter(args2, "args");
            Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "owner");
            this.application = application2;
            this.args = args2;
        }

        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\nHÆ\u0003JC\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006 "}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherViewModel$Factory$FallbackInjectionParams;", "", "application", "Landroid/app/Application;", "enableLogging", "", "publishableKey", "", "stripeAccountId", "productUsage", "", "(Landroid/app/Application;ZLjava/lang/String;Ljava/lang/String;Ljava/util/Set;)V", "getApplication", "()Landroid/app/Application;", "getEnableLogging", "()Z", "getProductUsage", "()Ljava/util/Set;", "getPublishableKey", "()Ljava/lang/String;", "getStripeAccountId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: GooglePayPaymentMethodLauncherViewModel.kt */
        public static final class FallbackInjectionParams {
            private final Application application;
            private final boolean enableLogging;
            private final Set<String> productUsage;
            private final String publishableKey;
            private final String stripeAccountId;

            public static /* synthetic */ FallbackInjectionParams copy$default(FallbackInjectionParams fallbackInjectionParams, Application application2, boolean z, String str, String str2, Set<String> set, int i, Object obj) {
                if ((i & 1) != 0) {
                    application2 = fallbackInjectionParams.application;
                }
                if ((i & 2) != 0) {
                    z = fallbackInjectionParams.enableLogging;
                }
                boolean z2 = z;
                if ((i & 4) != 0) {
                    str = fallbackInjectionParams.publishableKey;
                }
                String str3 = str;
                if ((i & 8) != 0) {
                    str2 = fallbackInjectionParams.stripeAccountId;
                }
                String str4 = str2;
                if ((i & 16) != 0) {
                    set = fallbackInjectionParams.productUsage;
                }
                return fallbackInjectionParams.copy(application2, z2, str3, str4, set);
            }

            public final Application component1() {
                return this.application;
            }

            public final boolean component2() {
                return this.enableLogging;
            }

            public final String component3() {
                return this.publishableKey;
            }

            public final String component4() {
                return this.stripeAccountId;
            }

            public final Set<String> component5() {
                return this.productUsage;
            }

            public final FallbackInjectionParams copy(Application application2, boolean z, String str, String str2, Set<String> set) {
                Intrinsics.checkNotNullParameter(application2, "application");
                Intrinsics.checkNotNullParameter(str, "publishableKey");
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                return new FallbackInjectionParams(application2, z, str, str2, set);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof FallbackInjectionParams)) {
                    return false;
                }
                FallbackInjectionParams fallbackInjectionParams = (FallbackInjectionParams) obj;
                return Intrinsics.areEqual((Object) this.application, (Object) fallbackInjectionParams.application) && this.enableLogging == fallbackInjectionParams.enableLogging && Intrinsics.areEqual((Object) this.publishableKey, (Object) fallbackInjectionParams.publishableKey) && Intrinsics.areEqual((Object) this.stripeAccountId, (Object) fallbackInjectionParams.stripeAccountId) && Intrinsics.areEqual((Object) this.productUsage, (Object) fallbackInjectionParams.productUsage);
            }

            public int hashCode() {
                int hashCode = this.application.hashCode() * 31;
                boolean z = this.enableLogging;
                if (z) {
                    z = true;
                }
                int hashCode2 = (((hashCode + (z ? 1 : 0)) * 31) + this.publishableKey.hashCode()) * 31;
                String str = this.stripeAccountId;
                return ((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.productUsage.hashCode();
            }

            public String toString() {
                return "FallbackInjectionParams(application=" + this.application + ", enableLogging=" + this.enableLogging + ", publishableKey=" + this.publishableKey + ", stripeAccountId=" + this.stripeAccountId + ", productUsage=" + this.productUsage + ')';
            }

            public FallbackInjectionParams(Application application2, boolean z, String str, String str2, Set<String> set) {
                Intrinsics.checkNotNullParameter(application2, "application");
                Intrinsics.checkNotNullParameter(str, "publishableKey");
                Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
                this.application = application2;
                this.enableLogging = z;
                this.publishableKey = str;
                this.stripeAccountId = str2;
                this.productUsage = set;
            }

            public final Application getApplication() {
                return this.application;
            }

            public final boolean getEnableLogging() {
                return this.enableLogging;
            }

            public final String getPublishableKey() {
                return this.publishableKey;
            }

            public final String getStripeAccountId() {
                return this.stripeAccountId;
            }

            public final Set<String> getProductUsage() {
                return this.productUsage;
            }
        }

        public final GooglePayPaymentMethodLauncherViewModelSubcomponent.Builder getSubComponentBuilder() {
            GooglePayPaymentMethodLauncherViewModelSubcomponent.Builder builder = this.subComponentBuilder;
            if (builder != null) {
                return builder;
            }
            Intrinsics.throwUninitializedPropertyAccessException("subComponentBuilder");
            return null;
        }

        public final void setSubComponentBuilder(GooglePayPaymentMethodLauncherViewModelSubcomponent.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "<set-?>");
            this.subComponentBuilder = builder;
        }

        /* access modifiers changed from: protected */
        public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
            String str2;
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            Injectable injectable = this;
            GooglePayPaymentMethodLauncherContract.Args.InjectionParams injectionParams$payments_core_release = this.args.getInjectionParams$payments_core_release();
            Set<String> set = null;
            String injectorKey = injectionParams$payments_core_release == null ? null : injectionParams$payments_core_release.getInjectorKey();
            Application application2 = this.application;
            GooglePayPaymentMethodLauncherContract.Args.InjectionParams injectionParams$payments_core_release2 = this.args.getInjectionParams$payments_core_release();
            boolean enableLogging = injectionParams$payments_core_release2 == null ? false : injectionParams$payments_core_release2.getEnableLogging();
            GooglePayPaymentMethodLauncherContract.Args.InjectionParams injectionParams$payments_core_release3 = this.args.getInjectionParams$payments_core_release();
            String publishableKey = injectionParams$payments_core_release3 == null ? null : injectionParams$payments_core_release3.getPublishableKey();
            if (publishableKey == null) {
                publishableKey = PaymentConfiguration.Companion.getInstance(this.application).getPublishableKey();
            }
            String str3 = publishableKey;
            if (this.args.getInjectionParams$payments_core_release() != null) {
                str2 = this.args.getInjectionParams$payments_core_release().getStripeAccountId();
            } else {
                str2 = PaymentConfiguration.Companion.getInstance(this.application).getStripeAccountId();
            }
            String str4 = str2;
            GooglePayPaymentMethodLauncherContract.Args.InjectionParams injectionParams$payments_core_release4 = this.args.getInjectionParams$payments_core_release();
            if (injectionParams$payments_core_release4 != null) {
                set = injectionParams$payments_core_release4.getProductUsage();
            }
            if (set == null) {
                set = SetsKt.setOf(GooglePayPaymentMethodLauncher.PRODUCT_USAGE_TOKEN);
            }
            InjectableKtxKt.injectWithFallback(injectable, injectorKey, new FallbackInjectionParams(application2, enableLogging, str3, str4, set));
            return getSubComponentBuilder().args(this.args).savedStateHandle(savedStateHandle).build().getViewModel();
        }

        public void fallbackInitialize(FallbackInjectionParams fallbackInjectionParams) {
            Intrinsics.checkNotNullParameter(fallbackInjectionParams, "arg");
            DaggerGooglePayPaymentMethodLauncherViewModelFactoryComponent.builder().context(fallbackInjectionParams.getApplication()).enableLogging(fallbackInjectionParams.getEnableLogging()).publishableKeyProvider(new GooglePayPaymentMethodLauncherViewModel$Factory$fallbackInitialize$1(fallbackInjectionParams)).stripeAccountIdProvider(new GooglePayPaymentMethodLauncherViewModel$Factory$fallbackInitialize$2(fallbackInjectionParams)).productUsage(fallbackInjectionParams.getProductUsage()).googlePayConfig(this.args.getConfig$payments_core_release()).build().inject(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherViewModel$Companion;", "", "()V", "HAS_LAUNCHED_KEY", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayPaymentMethodLauncherViewModel.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
