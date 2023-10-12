package com.stripe.android.paymentsheet;

import android.app.Application;
import android.os.Bundle;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.savedstate.SavedStateRegistryOwner;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.core.injection.Injectable;
import com.stripe.android.core.injection.InjectableKtxKt;
import com.stripe.android.core.injection.InjectorKt;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherContract;
import com.stripe.android.googlepaylauncher.injection.GooglePayPaymentMethodLauncherFactory;
import com.stripe.android.link.LinkActivityResult;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.ConfirmSetupIntentParams;
import com.stripe.android.model.ConfirmStripeIntentParams;
import com.stripe.android.model.PaymentIntent;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.payments.paymentlauncher.PaymentLauncher;
import com.stripe.android.payments.paymentlauncher.PaymentLauncherContract;
import com.stripe.android.payments.paymentlauncher.PaymentResult;
import com.stripe.android.payments.paymentlauncher.StripePaymentLauncherAssistedFactory;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.PaymentSheetContract;
import com.stripe.android.paymentsheet.PaymentSheetResult;
import com.stripe.android.paymentsheet.PaymentSheetViewModel;
import com.stripe.android.paymentsheet.injection.DaggerPaymentSheetLauncherComponent;
import com.stripe.android.paymentsheet.injection.PaymentSheetViewModelModule;
import com.stripe.android.paymentsheet.injection.PaymentSheetViewModelSubcomponent;
import com.stripe.android.paymentsheet.model.ConfirmStripeIntentParamsFactory;
import com.stripe.android.paymentsheet.model.FragmentConfig;
import com.stripe.android.paymentsheet.model.PaymentIntentClientSecret;
import com.stripe.android.paymentsheet.model.PaymentSelection;
import com.stripe.android.paymentsheet.model.PaymentSheetViewState;
import com.stripe.android.paymentsheet.model.StripeIntentValidator;
import com.stripe.android.paymentsheet.repositories.StripeIntentRepository;
import com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel;
import dagger.Lazy;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000²\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006¢\u0001£\u0001¤\u0001B\u0001\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\b\b\u0001\u0010\u001c\u001a\u00020\u001d\u0012\b\b\u0001\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#¢\u0006\u0002\u0010$J\u000e\u0010q\u001a\u00020r2\u0006\u0010:\u001a\u00020;J\u0012\u0010s\u001a\u00020r2\b\u0010t\u001a\u0004\u0018\u00010VH\u0002J\u000e\u0010u\u001a\u00020r2\u0006\u0010v\u001a\u000203J\u001d\u0010w\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050j2\u0006\u0010:\u001a\u00020;H\u0000¢\u0006\u0002\bxJ\u0006\u0010y\u001a\u00020rJ\r\u0010z\u001a\u00020'H\u0000¢\u0006\u0002\b{J\u0010\u0010|\u001a\u00020r2\u0006\u0010}\u001a\u00020~H\u0016J\u0018\u0010\u001a\u00020r2\b\u0010\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0001J\t\u0010\u0001\u001a\u00020rH\u0016J\u0013\u0010\u0001\u001a\u00020r2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010\u0001\u001a\u00020r2\b\u0010\u0001\u001a\u00030\u0001H\u0007J\u0013\u0010\u0001\u001a\u00020r2\b\u0010\u0001\u001a\u00030\u0001H\u0002J\t\u0010\u0001\u001a\u00020rH\u0016J\u001d\u0010\u0001\u001a\u00020r2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010\u0001\u001a\u00020r2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u001d\u0010\u0001\u001a\u00020r2\f\b\u0001\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002¢\u0006\u0003\u0010\u0001J\u0016\u0010\u0001\u001a\u00020r2\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u001fH\u0002J\u0010\u0010\u0001\u001a\u00020r2\u0007\u0010\u0001\u001a\u00020'J\"\u0010\u0001\u001a\u00020r2\b\u0010\u0001\u001a\u00030\u00012\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001J\u0011\u0010\u0001\u001a\u00020r2\u0006\u0010:\u001a\u00020;H\u0002J\t\u0010\u0001\u001a\u00020rH\u0016J\u0013\u0010 \u0001\u001a\u00020r2\b\u0010\u0001\u001a\u00030\u0001H\u0007J\u000f\u0010¡\u0001\u001a\u00030\u0001*\u00030\u0001H\u0002R*\u0010%\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010'0'0&8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\"\u0010-\u001a\b\u0012\u0004\u0012\u00020.0&8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b/\u0010*\u001a\u0004\b0\u0010,R\u001a\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000203020&X\u0004¢\u0006\u0002\n\u0000R\"\u00104\u001a\b\u0012\u0004\u0012\u0002050&8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b6\u0010*\u001a\u0004\b7\u0010,R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001a\u0010:\u001a\u00020;X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u0002030AX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020'0CX\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u001e\u0010F\u001a\u0004\u0018\u00010G8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bH\u0010*\u001a\u0004\bI\u0010JR&\u0010K\u001a\u0004\u0018\u00010L8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bM\u0010*\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010R\u001a\u00020'8@X\u0004¢\u0006\u0006\u001a\u0004\bS\u0010TR\u001c\u0010U\u001a\u0004\u0018\u00010VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010[\u001a\u0004\u0018\u00010\\X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001c\u0010a\u001a\u0004\u0018\u00010bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010g\u001a\b\u0012\u0004\u0012\u00020.0CX\u0004¢\u0006\b\n\u0000\u001a\u0004\bh\u0010ER\u001a\u0010i\u001a\b\u0012\u0004\u0012\u00020'0jX\u0004¢\u0006\b\n\u0000\u001a\u0004\bk\u0010lR \u0010m\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000203020CX\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010ER\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010o\u001a\b\u0012\u0004\u0012\u0002050CX\u0004¢\u0006\b\n\u0000\u001a\u0004\bp\u0010E¨\u0006¥\u0001"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheetViewModel;", "Lcom/stripe/android/paymentsheet/viewmodels/BaseSheetViewModel;", "Lcom/stripe/android/paymentsheet/PaymentSheetViewModel$TransitionTarget;", "application", "Landroid/app/Application;", "args", "Lcom/stripe/android/paymentsheet/PaymentSheetContract$Args;", "eventReporter", "Lcom/stripe/android/paymentsheet/analytics/EventReporter;", "lazyPaymentConfig", "Ldagger/Lazy;", "Lcom/stripe/android/PaymentConfiguration;", "stripeIntentRepository", "Lcom/stripe/android/paymentsheet/repositories/StripeIntentRepository;", "stripeIntentValidator", "Lcom/stripe/android/paymentsheet/model/StripeIntentValidator;", "customerRepository", "Lcom/stripe/android/paymentsheet/repositories/CustomerRepository;", "prefsRepository", "Lcom/stripe/android/paymentsheet/PrefsRepository;", "resourceRepository", "Lcom/stripe/android/ui/core/forms/resources/ResourceRepository;", "paymentLauncherFactory", "Lcom/stripe/android/payments/paymentlauncher/StripePaymentLauncherAssistedFactory;", "googlePayPaymentMethodLauncherFactory", "Lcom/stripe/android/googlepaylauncher/injection/GooglePayPaymentMethodLauncherFactory;", "logger", "Lcom/stripe/android/core/Logger;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "injectorKey", "", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "linkPaymentLauncherFactory", "Lcom/stripe/android/link/injection/LinkPaymentLauncherFactory;", "(Landroid/app/Application;Lcom/stripe/android/paymentsheet/PaymentSheetContract$Args;Lcom/stripe/android/paymentsheet/analytics/EventReporter;Ldagger/Lazy;Lcom/stripe/android/paymentsheet/repositories/StripeIntentRepository;Lcom/stripe/android/paymentsheet/model/StripeIntentValidator;Lcom/stripe/android/paymentsheet/repositories/CustomerRepository;Lcom/stripe/android/paymentsheet/PrefsRepository;Lcom/stripe/android/ui/core/forms/resources/ResourceRepository;Lcom/stripe/android/payments/paymentlauncher/StripePaymentLauncherAssistedFactory;Lcom/stripe/android/googlepaylauncher/injection/GooglePayPaymentMethodLauncherFactory;Lcom/stripe/android/core/Logger;Lkotlin/coroutines/CoroutineContext;Ljava/lang/String;Landroidx/lifecycle/SavedStateHandle;Lcom/stripe/android/link/injection/LinkPaymentLauncherFactory;)V", "_contentVisible", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "get_contentVisible$paymentsheet_release$annotations", "()V", "get_contentVisible$paymentsheet_release", "()Landroidx/lifecycle/MutableLiveData;", "_paymentSheetResult", "Lcom/stripe/android/paymentsheet/PaymentSheetResult;", "get_paymentSheetResult$paymentsheet_release$annotations", "get_paymentSheetResult$paymentsheet_release", "_startConfirm", "Lcom/stripe/android/paymentsheet/viewmodels/BaseSheetViewModel$Event;", "Lcom/stripe/android/model/ConfirmStripeIntentParams;", "_viewState", "Lcom/stripe/android/paymentsheet/model/PaymentSheetViewState;", "get_viewState$paymentsheet_release$annotations", "get_viewState$paymentsheet_release", "getArgs$paymentsheet_release", "()Lcom/stripe/android/paymentsheet/PaymentSheetContract$Args;", "checkoutIdentifier", "Lcom/stripe/android/paymentsheet/PaymentSheetViewModel$CheckoutIdentifier;", "getCheckoutIdentifier$paymentsheet_release", "()Lcom/stripe/android/paymentsheet/PaymentSheetViewModel$CheckoutIdentifier;", "setCheckoutIdentifier$paymentsheet_release", "(Lcom/stripe/android/paymentsheet/PaymentSheetViewModel$CheckoutIdentifier;)V", "confirmParamsFactory", "Lcom/stripe/android/paymentsheet/model/ConfirmStripeIntentParamsFactory;", "contentVisible", "Landroidx/lifecycle/LiveData;", "getContentVisible$paymentsheet_release", "()Landroidx/lifecycle/LiveData;", "googlePayLauncherConfig", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Config;", "getGooglePayLauncherConfig$paymentsheet_release$annotations", "getGooglePayLauncherConfig$paymentsheet_release", "()Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Config;", "googlePayPaymentMethodLauncher", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher;", "getGooglePayPaymentMethodLauncher$paymentsheet_release$annotations", "getGooglePayPaymentMethodLauncher$paymentsheet_release", "()Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher;", "setGooglePayPaymentMethodLauncher$paymentsheet_release", "(Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher;)V", "isProcessingPaymentIntent", "isProcessingPaymentIntent$paymentsheet_release", "()Z", "lastSelectedPaymentMethod", "Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "getLastSelectedPaymentMethod$paymentsheet_release", "()Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "setLastSelectedPaymentMethod$paymentsheet_release", "(Lcom/stripe/android/paymentsheet/model/PaymentSelection;)V", "newCard", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$New$Card;", "getNewCard", "()Lcom/stripe/android/paymentsheet/model/PaymentSelection$New$Card;", "setNewCard", "(Lcom/stripe/android/paymentsheet/model/PaymentSelection$New$Card;)V", "paymentLauncher", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncher;", "getPaymentLauncher$paymentsheet_release", "()Lcom/stripe/android/payments/paymentlauncher/PaymentLauncher;", "setPaymentLauncher$paymentsheet_release", "(Lcom/stripe/android/payments/paymentlauncher/PaymentLauncher;)V", "paymentSheetResult", "getPaymentSheetResult$paymentsheet_release", "showTopContainer", "Landroidx/lifecycle/MediatorLiveData;", "getShowTopContainer$paymentsheet_release", "()Landroidx/lifecycle/MediatorLiveData;", "startConfirm", "getStartConfirm$paymentsheet_release", "viewState", "getViewState$paymentsheet_release", "checkout", "", "confirmPaymentSelection", "paymentSelection", "confirmStripeIntent", "confirmStripeIntentParams", "getButtonStateObservable", "getButtonStateObservable$paymentsheet_release", "launchLink", "maybeFetchStripeIntent", "maybeFetchStripeIntent$paymentsheet_release", "onFatal", "throwable", "", "onGooglePayResult", "result", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Result;", "onGooglePayResult$paymentsheet_release", "onLinkLaunched", "onLinkPaymentResult", "Lcom/stripe/android/link/LinkActivityResult;", "onPaymentResult", "paymentResult", "Lcom/stripe/android/payments/paymentlauncher/PaymentResult;", "onStripeIntentFetchResponse", "stripeIntent", "Lcom/stripe/android/model/StripeIntent;", "onUserCancel", "processPayment", "registerFromActivity", "activityResultCaller", "Landroidx/activity/result/ActivityResultCaller;", "resetViewState", "stringResId", "", "(Ljava/lang/Integer;)V", "userErrorMessage", "setContentVisible", "visible", "setupGooglePay", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncherContract$Args;", "startProcessing", "unregisterFromActivity", "updatePaymentMethods", "convertToPaymentResult", "CheckoutIdentifier", "Factory", "TransitionTarget", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSheetViewModel.kt */
public final class PaymentSheetViewModel extends BaseSheetViewModel<TransitionTarget> {
    private final MutableLiveData<Boolean> _contentVisible;
    private final MutableLiveData<PaymentSheetResult> _paymentSheetResult;
    private final MutableLiveData<BaseSheetViewModel.Event<ConfirmStripeIntentParams>> _startConfirm;
    private final MutableLiveData<PaymentSheetViewState> _viewState;
    private final PaymentSheetContract.Args args;
    private CheckoutIdentifier checkoutIdentifier = CheckoutIdentifier.SheetBottomBuy;
    private final ConfirmStripeIntentParamsFactory<ConfirmStripeIntentParams> confirmParamsFactory;
    private final LiveData<Boolean> contentVisible;
    private final GooglePayPaymentMethodLauncher.Config googlePayLauncherConfig;
    private GooglePayPaymentMethodLauncher googlePayPaymentMethodLauncher;
    private final GooglePayPaymentMethodLauncherFactory googlePayPaymentMethodLauncherFactory;
    private PaymentSelection lastSelectedPaymentMethod;
    /* access modifiers changed from: private */
    public final Lazy<PaymentConfiguration> lazyPaymentConfig;
    private PaymentSelection.New.Card newCard;
    private PaymentLauncher paymentLauncher;
    private final StripePaymentLauncherAssistedFactory paymentLauncherFactory;
    private final LiveData<PaymentSheetResult> paymentSheetResult;
    private final MediatorLiveData<Boolean> showTopContainer;
    private final LiveData<BaseSheetViewModel.Event<ConfirmStripeIntentParams>> startConfirm;
    /* access modifiers changed from: private */
    public final StripeIntentRepository stripeIntentRepository;
    private final StripeIntentValidator stripeIntentValidator;
    private final LiveData<PaymentSheetViewState> viewState;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheetViewModel$CheckoutIdentifier;", "", "(Ljava/lang/String;I)V", "SheetTopGooglePay", "SheetBottomBuy", "None", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetViewModel.kt */
    public enum CheckoutIdentifier {
        SheetTopGooglePay,
        SheetBottomBuy,
        None
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetViewModel.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaymentSheet.GooglePayConfiguration.Environment.values().length];
            iArr[PaymentSheet.GooglePayConfiguration.Environment.Production.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getGooglePayLauncherConfig$paymentsheet_release$annotations() {
    }

    public static /* synthetic */ void getGooglePayPaymentMethodLauncher$paymentsheet_release$annotations() {
    }

    public static /* synthetic */ void get_contentVisible$paymentsheet_release$annotations() {
    }

    public static /* synthetic */ void get_paymentSheetResult$paymentsheet_release$annotations() {
    }

    public static /* synthetic */ void get_viewState$paymentsheet_release$annotations() {
    }

    public final void launchLink() {
    }

    public final PaymentSheetContract.Args getArgs$paymentsheet_release() {
        return this.args;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @javax.inject.Inject
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PaymentSheetViewModel(android.app.Application r18, com.stripe.android.paymentsheet.PaymentSheetContract.Args r19, com.stripe.android.paymentsheet.analytics.EventReporter r20, dagger.Lazy<com.stripe.android.PaymentConfiguration> r21, com.stripe.android.paymentsheet.repositories.StripeIntentRepository r22, com.stripe.android.paymentsheet.model.StripeIntentValidator r23, com.stripe.android.paymentsheet.repositories.CustomerRepository r24, com.stripe.android.paymentsheet.PrefsRepository r25, com.stripe.android.ui.core.forms.resources.ResourceRepository r26, com.stripe.android.payments.paymentlauncher.StripePaymentLauncherAssistedFactory r27, com.stripe.android.googlepaylauncher.injection.GooglePayPaymentMethodLauncherFactory r28, com.stripe.android.core.Logger r29, @com.stripe.android.core.injection.IOContext kotlin.coroutines.CoroutineContext r30, @com.stripe.android.core.injection.InjectorKey java.lang.String r31, androidx.lifecycle.SavedStateHandle r32, com.stripe.android.link.injection.LinkPaymentLauncherFactory r33) {
        /*
            r17 = this;
            r12 = r17
            r13 = r19
            r14 = r20
            r15 = r21
            r11 = r22
            r10 = r23
            r9 = r27
            r8 = r28
            r7 = r29
            r6 = r32
            java.lang.String r0 = "application"
            r1 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "eventReporter"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "lazyPaymentConfig"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "stripeIntentRepository"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "stripeIntentValidator"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "customerRepository"
            r4 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "prefsRepository"
            r5 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "resourceRepository"
            r3 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "paymentLauncherFactory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "googlePayPaymentMethodLauncherFactory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "logger"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "workContext"
            r2 = r30
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "injectorKey"
            r8 = r31
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "savedStateHandle"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "linkPaymentLauncherFactory"
            r11 = r33
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            com.stripe.android.paymentsheet.PaymentSheet$Configuration r16 = r19.getConfig$paymentsheet_release()
            r0 = r17
            r2 = r16
            r3 = r20
            r6 = r30
            r14 = r7
            r14 = r28
            r14 = r9
            r9 = r26
            r14 = r10
            r10 = r32
            r14 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r12.args = r13
            r12.lazyPaymentConfig = r15
            r12.stripeIntentRepository = r14
            r0 = r23
            r12.stripeIntentValidator = r0
            r0 = r27
            r12.paymentLauncherFactory = r0
            r0 = r28
            r12.googlePayPaymentMethodLauncherFactory = r0
            com.stripe.android.paymentsheet.model.ConfirmStripeIntentParamsFactory$Companion r0 = com.stripe.android.paymentsheet.model.ConfirmStripeIntentParamsFactory.Companion
            com.stripe.android.paymentsheet.model.ClientSecret r1 = r19.getClientSecret$paymentsheet_release()
            com.stripe.android.paymentsheet.model.ConfirmStripeIntentParamsFactory r0 = r0.createFactory(r1)
            r12.confirmParamsFactory = r0
            androidx.lifecycle.MutableLiveData r0 = new androidx.lifecycle.MutableLiveData
            r0.<init>()
            r12._paymentSheetResult = r0
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            r12.paymentSheetResult = r0
            androidx.lifecycle.MutableLiveData r0 = new androidx.lifecycle.MutableLiveData
            r0.<init>()
            r12._startConfirm = r0
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            r12.startConfirm = r0
            androidx.lifecycle.MutableLiveData r0 = new androidx.lifecycle.MutableLiveData
            r1 = 0
            r0.<init>(r1)
            r12._viewState = r0
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            androidx.lifecycle.LiveData r0 = androidx.lifecycle.Transformations.distinctUntilChanged(r0)
            java.lang.String r2 = "distinctUntilChanged(this)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r12.viewState = r0
            androidx.lifecycle.MutableLiveData r0 = new androidx.lifecycle.MutableLiveData
            r3 = 1
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r3)
            r0.<init>(r4)
            r12._contentVisible = r0
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            androidx.lifecycle.LiveData r0 = androidx.lifecycle.Transformations.distinctUntilChanged(r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            r12.contentVisible = r0
            com.stripe.android.paymentsheet.PaymentSheetViewModel$CheckoutIdentifier r0 = com.stripe.android.paymentsheet.PaymentSheetViewModel.CheckoutIdentifier.SheetBottomBuy
            r12.checkoutIdentifier = r0
            com.stripe.android.paymentsheet.PaymentSheet$GooglePayConfiguration r0 = r19.getGooglePayConfig()
            if (r0 != 0) goto L_0x00f7
            goto L_0x0145
        L_0x00f7:
            java.lang.String r2 = r0.getCurrencyCode()
            if (r2 != 0) goto L_0x010d
            boolean r2 = r17.isProcessingPaymentIntent$paymentsheet_release()
            if (r2 != 0) goto L_0x010d
            java.lang.String r0 = "GooglePayConfiguration.currencyCode is required in order to use Google Pay when processing a Setup Intent"
            r2 = r29
            r2.warning(r0)
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$Config r1 = (com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher.Config) r1
            goto L_0x0145
        L_0x010d:
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$Config r1 = new com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$Config
            com.stripe.android.paymentsheet.PaymentSheet$GooglePayConfiguration$Environment r2 = r0.getEnvironment()
            int[] r4 = com.stripe.android.paymentsheet.PaymentSheetViewModel.WhenMappings.$EnumSwitchMapping$0
            int r2 = r2.ordinal()
            r2 = r4[r2]
            if (r2 != r3) goto L_0x0120
            com.stripe.android.googlepaylauncher.GooglePayEnvironment r2 = com.stripe.android.googlepaylauncher.GooglePayEnvironment.Production
            goto L_0x0122
        L_0x0120:
            com.stripe.android.googlepaylauncher.GooglePayEnvironment r2 = com.stripe.android.googlepaylauncher.GooglePayEnvironment.Test
        L_0x0122:
            java.lang.String r0 = r0.getCountryCode()
            java.lang.String r4 = r17.getMerchantName$paymentsheet_release()
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 56
            r9 = 0
            r21 = r1
            r22 = r2
            r23 = r0
            r24 = r4
            r25 = r5
            r26 = r6
            r27 = r7
            r28 = r8
            r29 = r9
            r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29)
        L_0x0145:
            r12.googlePayLauncherConfig = r1
            androidx.lifecycle.MediatorLiveData r0 = new androidx.lifecycle.MediatorLiveData
            r0.<init>()
            r1 = 3
            androidx.lifecycle.LiveData[] r1 = new androidx.lifecycle.LiveData[r1]
            androidx.lifecycle.LiveData r2 = r17.isLinkEnabled$paymentsheet_release()
            r4 = 0
            r1[r4] = r2
            androidx.lifecycle.LiveData r2 = r17.isGooglePayReady$paymentsheet_release()
            r1[r3] = r2
            r2 = 2
            androidx.lifecycle.LiveData r3 = r17.getFragmentConfigEvent()
            r1[r2] = r3
            java.util.List r1 = kotlin.collections.CollectionsKt.listOf(r1)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x016d:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0184
            java.lang.Object r2 = r1.next()
            androidx.lifecycle.LiveData r2 = (androidx.lifecycle.LiveData) r2
            com.stripe.android.paymentsheet.PaymentSheetViewModel$showTopContainer$1$1$1 r3 = new com.stripe.android.paymentsheet.PaymentSheetViewModel$showTopContainer$1$1$1
            r3.<init>(r0, r12)
            androidx.lifecycle.Observer r3 = (androidx.lifecycle.Observer) r3
            r0.addSource(r2, r3)
            goto L_0x016d
        L_0x0184:
            r12.showTopContainer = r0
            com.stripe.android.paymentsheet.PaymentSheet$Configuration r0 = r17.getConfig$paymentsheet_release()
            r1 = r20
            r1.onInit(r0)
            com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher$Config r0 = r12.googlePayLauncherConfig
            if (r0 != 0) goto L_0x019e
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r4)
            java.lang.String r1 = "google_pay_ready"
            r2 = r32
            r2.set(r1, r0)
        L_0x019e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.PaymentSheetViewModel.<init>(android.app.Application, com.stripe.android.paymentsheet.PaymentSheetContract$Args, com.stripe.android.paymentsheet.analytics.EventReporter, dagger.Lazy, com.stripe.android.paymentsheet.repositories.StripeIntentRepository, com.stripe.android.paymentsheet.model.StripeIntentValidator, com.stripe.android.paymentsheet.repositories.CustomerRepository, com.stripe.android.paymentsheet.PrefsRepository, com.stripe.android.ui.core.forms.resources.ResourceRepository, com.stripe.android.payments.paymentlauncher.StripePaymentLauncherAssistedFactory, com.stripe.android.googlepaylauncher.injection.GooglePayPaymentMethodLauncherFactory, com.stripe.android.core.Logger, kotlin.coroutines.CoroutineContext, java.lang.String, androidx.lifecycle.SavedStateHandle, com.stripe.android.link.injection.LinkPaymentLauncherFactory):void");
    }

    public final MutableLiveData<PaymentSheetResult> get_paymentSheetResult$paymentsheet_release() {
        return this._paymentSheetResult;
    }

    public final LiveData<PaymentSheetResult> getPaymentSheetResult$paymentsheet_release() {
        return this.paymentSheetResult;
    }

    public final LiveData<BaseSheetViewModel.Event<ConfirmStripeIntentParams>> getStartConfirm$paymentsheet_release() {
        return this.startConfirm;
    }

    public final MutableLiveData<PaymentSheetViewState> get_viewState$paymentsheet_release() {
        return this._viewState;
    }

    public final LiveData<PaymentSheetViewState> getViewState$paymentsheet_release() {
        return this.viewState;
    }

    public final MutableLiveData<Boolean> get_contentVisible$paymentsheet_release() {
        return this._contentVisible;
    }

    public final LiveData<Boolean> getContentVisible$paymentsheet_release() {
        return this.contentVisible;
    }

    public final CheckoutIdentifier getCheckoutIdentifier$paymentsheet_release() {
        return this.checkoutIdentifier;
    }

    public final void setCheckoutIdentifier$paymentsheet_release(CheckoutIdentifier checkoutIdentifier2) {
        Intrinsics.checkNotNullParameter(checkoutIdentifier2, "<set-?>");
        this.checkoutIdentifier = checkoutIdentifier2;
    }

    public final MediatorLiveData<PaymentSheetViewState> getButtonStateObservable$paymentsheet_release(CheckoutIdentifier checkoutIdentifier2) {
        Intrinsics.checkNotNullParameter(checkoutIdentifier2, "checkoutIdentifier");
        MediatorLiveData<PaymentSheetViewState> mediatorLiveData = new MediatorLiveData<>();
        mediatorLiveData.addSource(this._viewState, new Observer(checkoutIdentifier2, mediatorLiveData) {
            public final /* synthetic */ PaymentSheetViewModel.CheckoutIdentifier f$1;
            public final /* synthetic */ MediatorLiveData f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onChanged(Object obj) {
                PaymentSheetViewModel.m4427getButtonStateObservable$lambda0(PaymentSheetViewModel.this, this.f$1, this.f$2, (PaymentSheetViewState) obj);
            }
        });
        return mediatorLiveData;
    }

    /* access modifiers changed from: private */
    /* renamed from: getButtonStateObservable$lambda-0  reason: not valid java name */
    public static final void m4427getButtonStateObservable$lambda0(PaymentSheetViewModel paymentSheetViewModel, CheckoutIdentifier checkoutIdentifier2, MediatorLiveData mediatorLiveData, PaymentSheetViewState paymentSheetViewState) {
        Intrinsics.checkNotNullParameter(paymentSheetViewModel, "this$0");
        Intrinsics.checkNotNullParameter(checkoutIdentifier2, "$checkoutIdentifier");
        Intrinsics.checkNotNullParameter(mediatorLiveData, "$outputLiveData");
        if (paymentSheetViewModel.checkoutIdentifier == checkoutIdentifier2) {
            mediatorLiveData.setValue(paymentSheetViewState);
        }
    }

    public final PaymentSelection getLastSelectedPaymentMethod$paymentsheet_release() {
        return this.lastSelectedPaymentMethod;
    }

    public final void setLastSelectedPaymentMethod$paymentsheet_release(PaymentSelection paymentSelection) {
        this.lastSelectedPaymentMethod = paymentSelection;
    }

    public final boolean isProcessingPaymentIntent$paymentsheet_release() {
        return this.args.getClientSecret$paymentsheet_release() instanceof PaymentIntentClientSecret;
    }

    public PaymentSelection.New.Card getNewCard() {
        return this.newCard;
    }

    public void setNewCard(PaymentSelection.New.Card card) {
        this.newCard = card;
    }

    public final GooglePayPaymentMethodLauncher getGooglePayPaymentMethodLauncher$paymentsheet_release() {
        return this.googlePayPaymentMethodLauncher;
    }

    public final void setGooglePayPaymentMethodLauncher$paymentsheet_release(GooglePayPaymentMethodLauncher googlePayPaymentMethodLauncher2) {
        this.googlePayPaymentMethodLauncher = googlePayPaymentMethodLauncher2;
    }

    public final GooglePayPaymentMethodLauncher.Config getGooglePayLauncherConfig$paymentsheet_release() {
        return this.googlePayLauncherConfig;
    }

    public final MediatorLiveData<Boolean> getShowTopContainer$paymentsheet_release() {
        return this.showTopContainer;
    }

    public final PaymentLauncher getPaymentLauncher$paymentsheet_release() {
        return this.paymentLauncher;
    }

    public final void setPaymentLauncher$paymentsheet_release(PaymentLauncher paymentLauncher2) {
        this.paymentLauncher = paymentLauncher2;
    }

    public final void setupGooglePay(CoroutineScope coroutineScope, ActivityResultLauncher<GooglePayPaymentMethodLauncherContract.Args> activityResultLauncher) {
        Intrinsics.checkNotNullParameter(coroutineScope, "lifecycleScope");
        Intrinsics.checkNotNullParameter(activityResultLauncher, "activityResultLauncher");
        GooglePayPaymentMethodLauncher.Config config = this.googlePayLauncherConfig;
        if (config != null) {
            setGooglePayPaymentMethodLauncher$paymentsheet_release(GooglePayPaymentMethodLauncherFactory.DefaultImpls.create$default(this.googlePayPaymentMethodLauncherFactory, coroutineScope, config, new PaymentSheetViewModel$setupGooglePay$1$1(this), activityResultLauncher, false, 16, (Object) null));
        }
    }

    public final boolean maybeFetchStripeIntent$paymentsheet_release() {
        if (getStripeIntent$paymentsheet_release().getValue() != null) {
            return false;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PaymentSheetViewModel$maybeFetchStripeIntent$1(this, (Continuation<? super PaymentSheetViewModel$maybeFetchStripeIntent$1>) null), 3, (Object) null);
        return true;
    }

    /* access modifiers changed from: private */
    public final void onStripeIntentFetchResponse(StripeIntent stripeIntent) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m4709constructorimpl(this.stripeIntentValidator.requireValid(stripeIntent));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        Throwable r1 = Result.m4712exceptionOrNullimpl(obj);
        if (r1 == null) {
            StripeIntent stripeIntent2 = (StripeIntent) obj;
            getSavedStateHandle().set(BaseSheetViewModel.SAVE_STRIPE_INTENT, stripeIntent);
            updatePaymentMethods(stripeIntent);
            setupLink(stripeIntent);
            resetViewState$default(this, (String) null, 1, (Object) null);
            return;
        }
        onFatal(r1);
    }

    public final void updatePaymentMethods(StripeIntent stripeIntent) {
        Intrinsics.checkNotNullParameter(stripeIntent, "stripeIntent");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PaymentSheetViewModel$updatePaymentMethods$1(this, stripeIntent, (Continuation<? super PaymentSheetViewModel$updatePaymentMethods$1>) null), 3, (Object) null);
    }

    private final void resetViewState(Integer num) {
        String str;
        if (num == null) {
            str = null;
        } else {
            str = getApplication().getResources().getString(num.intValue());
        }
        resetViewState(str);
    }

    static /* synthetic */ void resetViewState$default(PaymentSheetViewModel paymentSheetViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        paymentSheetViewModel.resetViewState(str);
    }

    private final void resetViewState(String str) {
        BaseSheetViewModel.UserErrorMessage userErrorMessage;
        MutableLiveData<PaymentSheetViewState> mutableLiveData = this._viewState;
        if (str == null) {
            userErrorMessage = null;
        } else {
            userErrorMessage = new BaseSheetViewModel.UserErrorMessage(str);
        }
        mutableLiveData.setValue(new PaymentSheetViewState.Reset(userErrorMessage));
        getSavedStateHandle().set(BaseSheetViewModel.SAVE_PROCESSING, false);
    }

    private final void startProcessing(CheckoutIdentifier checkoutIdentifier2) {
        if (this.checkoutIdentifier != checkoutIdentifier2) {
            this._viewState.setValue(new PaymentSheetViewState.Reset((BaseSheetViewModel.UserErrorMessage) null, 1, (DefaultConstructorMarker) null));
        }
        this.checkoutIdentifier = checkoutIdentifier2;
        getSavedStateHandle().set(BaseSheetViewModel.SAVE_PROCESSING, true);
        this._viewState.setValue(PaymentSheetViewState.StartProcessing.INSTANCE);
    }

    public final void checkout(CheckoutIdentifier checkoutIdentifier2) {
        GooglePayPaymentMethodLauncher googlePayPaymentMethodLauncher$paymentsheet_release;
        Long amount;
        Intrinsics.checkNotNullParameter(checkoutIdentifier2, "checkoutIdentifier");
        startProcessing(checkoutIdentifier2);
        PaymentSelection value = getSelection$paymentsheet_release().getValue();
        if (value instanceof PaymentSelection.GooglePay) {
            StripeIntent value2 = getStripeIntent$paymentsheet_release().getValue();
            if (value2 != null && (googlePayPaymentMethodLauncher$paymentsheet_release = getGooglePayPaymentMethodLauncher$paymentsheet_release()) != null) {
                boolean z = value2 instanceof PaymentIntent;
                PaymentIntent paymentIntent = null;
                PaymentIntent paymentIntent2 = z ? (PaymentIntent) value2 : null;
                String currency = paymentIntent2 == null ? null : paymentIntent2.getCurrency();
                if (currency == null) {
                    PaymentSheet.GooglePayConfiguration googlePayConfig = getArgs$paymentsheet_release().getGooglePayConfig();
                    currency = googlePayConfig == null ? null : googlePayConfig.getCurrencyCode();
                    if (currency == null) {
                        currency = "";
                    }
                }
                if (z) {
                    paymentIntent = (PaymentIntent) value2;
                }
                int i = 0;
                if (!(paymentIntent == null || (amount = paymentIntent.getAmount()) == null)) {
                    i = (int) amount.longValue();
                }
                googlePayPaymentMethodLauncher$paymentsheet_release.present(currency, i, value2.getId());
                return;
            }
            return;
        }
        confirmPaymentSelection(value);
    }

    public final void confirmStripeIntent(ConfirmStripeIntentParams confirmStripeIntentParams) {
        Object obj;
        Intrinsics.checkNotNullParameter(confirmStripeIntentParams, "confirmStripeIntentParams");
        try {
            Result.Companion companion = Result.Companion;
            PaymentLauncher paymentLauncher$paymentsheet_release = getPaymentLauncher$paymentsheet_release();
            if (paymentLauncher$paymentsheet_release != null) {
                obj = Result.m4709constructorimpl(paymentLauncher$paymentsheet_release);
                Throwable r1 = Result.m4712exceptionOrNullimpl(obj);
                if (r1 == null) {
                    PaymentLauncher paymentLauncher2 = (PaymentLauncher) obj;
                    if (confirmStripeIntentParams instanceof ConfirmPaymentIntentParams) {
                        paymentLauncher2.confirm((ConfirmPaymentIntentParams) confirmStripeIntentParams);
                    } else if (confirmStripeIntentParams instanceof ConfirmSetupIntentParams) {
                        paymentLauncher2.confirm((ConfirmSetupIntentParams) confirmStripeIntentParams);
                    }
                } else {
                    onFatal(r1);
                }
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
    }

    public void registerFromActivity(ActivityResultCaller activityResultCaller) {
        Intrinsics.checkNotNullParameter(activityResultCaller, "activityResultCaller");
        super.registerFromActivity(activityResultCaller);
        ActivityResultLauncher registerForActivityResult = activityResultCaller.registerForActivityResult(new PaymentLauncherContract(), new ActivityResultCallback() {
            public final void onActivityResult(Object obj) {
                PaymentSheetViewModel.this.onPaymentResult((PaymentResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "activityResultCaller.reg…ymentResult\n            )");
        this.paymentLauncher = this.paymentLauncherFactory.create(new PaymentSheetViewModel$registerFromActivity$1(this), new PaymentSheetViewModel$registerFromActivity$2(this), registerForActivityResult);
    }

    public void unregisterFromActivity() {
        super.unregisterFromActivity();
        this.paymentLauncher = null;
    }

    public final void setContentVisible(boolean z) {
        this._contentVisible.setValue(Boolean.valueOf(z));
    }

    private final void confirmPaymentSelection(PaymentSelection paymentSelection) {
        ConfirmStripeIntentParams confirmStripeIntentParams;
        if (paymentSelection instanceof PaymentSelection.Saved) {
            confirmStripeIntentParams = this.confirmParamsFactory.create((PaymentSelection.Saved) paymentSelection);
        } else {
            confirmStripeIntentParams = paymentSelection instanceof PaymentSelection.New ? this.confirmParamsFactory.create((PaymentSelection.New) paymentSelection) : null;
        }
        if (confirmStripeIntentParams != null) {
            this._startConfirm.setValue(new BaseSheetViewModel.Event(confirmStripeIntentParams));
        }
    }

    public void onLinkLaunched() {
        startProcessing(CheckoutIdentifier.SheetBottomBuy);
    }

    public void onLinkPaymentResult(LinkActivityResult linkActivityResult) {
        Intrinsics.checkNotNullParameter(linkActivityResult, "result");
        onPaymentResult(convertToPaymentResult(linkActivityResult));
    }

    private final PaymentResult convertToPaymentResult(LinkActivityResult linkActivityResult) {
        if (linkActivityResult instanceof LinkActivityResult.Success) {
            return PaymentResult.Completed.INSTANCE;
        }
        if (linkActivityResult instanceof LinkActivityResult.Canceled) {
            return PaymentResult.Canceled.INSTANCE;
        }
        if (linkActivityResult instanceof LinkActivityResult.Failed) {
            return new PaymentResult.Failed(((LinkActivityResult.Failed) linkActivityResult).getError());
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void onPaymentResult(PaymentResult paymentResult) {
        Intrinsics.checkNotNullParameter(paymentResult, "paymentResult");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new PaymentSheetViewModel$onPaymentResult$1(this, paymentResult, (Continuation<? super PaymentSheetViewModel$onPaymentResult$1>) null), 3, (Object) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v3, types: [com.stripe.android.paymentsheet.model.PaymentSelection] */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r1v14 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void processPayment(com.stripe.android.model.StripeIntent r4, com.stripe.android.payments.paymentlauncher.PaymentResult r5) {
        /*
            r3 = this;
            com.stripe.android.payments.paymentlauncher.PaymentResult$Completed r0 = com.stripe.android.payments.paymentlauncher.PaymentResult.Completed.INSTANCE
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r0)
            r1 = 0
            if (r0 == 0) goto L_0x007f
            com.stripe.android.paymentsheet.analytics.EventReporter r5 = r3.getEventReporter$paymentsheet_release()
            androidx.lifecycle.LiveData r0 = r3.getSelection$paymentsheet_release()
            java.lang.Object r0 = r0.getValue()
            com.stripe.android.paymentsheet.model.PaymentSelection r0 = (com.stripe.android.paymentsheet.model.PaymentSelection) r0
            r5.onPaymentSuccess(r0)
            androidx.lifecycle.LiveData r5 = r3.getSelection$paymentsheet_release()
            java.lang.Object r5 = r5.getValue()
            com.stripe.android.paymentsheet.model.PaymentSelection r5 = (com.stripe.android.paymentsheet.model.PaymentSelection) r5
            boolean r0 = r5 instanceof com.stripe.android.paymentsheet.model.PaymentSelection.New
            if (r0 == 0) goto L_0x0037
            com.stripe.android.model.PaymentMethod r4 = r4.getPaymentMethod()
            if (r4 != 0) goto L_0x002f
            goto L_0x0034
        L_0x002f:
            com.stripe.android.paymentsheet.model.PaymentSelection$Saved r1 = new com.stripe.android.paymentsheet.model.PaymentSelection$Saved
            r1.<init>(r4)
        L_0x0034:
            com.stripe.android.paymentsheet.model.PaymentSelection r1 = (com.stripe.android.paymentsheet.model.PaymentSelection) r1
            goto L_0x005d
        L_0x0037:
            com.stripe.android.paymentsheet.model.PaymentSelection$GooglePay r4 = com.stripe.android.paymentsheet.model.PaymentSelection.GooglePay.INSTANCE
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x004b
            androidx.lifecycle.LiveData r4 = r3.getSelection$paymentsheet_release()
            java.lang.Object r4 = r4.getValue()
            r1 = r4
            com.stripe.android.paymentsheet.model.PaymentSelection r1 = (com.stripe.android.paymentsheet.model.PaymentSelection) r1
            goto L_0x005d
        L_0x004b:
            boolean r4 = r5 instanceof com.stripe.android.paymentsheet.model.PaymentSelection.Saved
            if (r4 == 0) goto L_0x005b
            androidx.lifecycle.LiveData r4 = r3.getSelection$paymentsheet_release()
            java.lang.Object r4 = r4.getValue()
            r1 = r4
            com.stripe.android.paymentsheet.model.PaymentSelection r1 = (com.stripe.android.paymentsheet.model.PaymentSelection) r1
            goto L_0x005d
        L_0x005b:
            if (r5 != 0) goto L_0x0079
        L_0x005d:
            if (r1 != 0) goto L_0x0060
            goto L_0x0067
        L_0x0060:
            com.stripe.android.paymentsheet.PrefsRepository r4 = r3.getPrefsRepository()
            r4.savePaymentSelection(r1)
        L_0x0067:
            androidx.lifecycle.MutableLiveData<com.stripe.android.paymentsheet.model.PaymentSheetViewState> r4 = r3._viewState
            com.stripe.android.paymentsheet.model.PaymentSheetViewState$FinishProcessing r5 = new com.stripe.android.paymentsheet.model.PaymentSheetViewState$FinishProcessing
            com.stripe.android.paymentsheet.PaymentSheetViewModel$processPayment$3 r0 = new com.stripe.android.paymentsheet.PaymentSheetViewModel$processPayment$3
            r0.<init>(r3)
            kotlin.jvm.functions.Function0 r0 = (kotlin.jvm.functions.Function0) r0
            r5.<init>(r0)
            r4.setValue(r5)
            goto L_0x00c8
        L_0x0079:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        L_0x007f:
            com.stripe.android.paymentsheet.analytics.EventReporter r0 = r3.getEventReporter$paymentsheet_release()
            androidx.lifecycle.LiveData r2 = r3.getSelection$paymentsheet_release()
            java.lang.Object r2 = r2.getValue()
            com.stripe.android.paymentsheet.model.PaymentSelection r2 = (com.stripe.android.paymentsheet.model.PaymentSelection) r2
            r0.onPaymentFailure(r2)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00a0 }
            r0 = r3
            com.stripe.android.paymentsheet.PaymentSheetViewModel r0 = (com.stripe.android.paymentsheet.PaymentSheetViewModel) r0     // Catch:{ all -> 0x00a0 }
            com.stripe.android.paymentsheet.model.StripeIntentValidator r0 = r0.stripeIntentValidator     // Catch:{ all -> 0x00a0 }
            com.stripe.android.model.StripeIntent r4 = r0.requireValid(r4)     // Catch:{ all -> 0x00a0 }
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r4)     // Catch:{ all -> 0x00a0 }
            goto L_0x00ab
        L_0x00a0:
            r4 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m4709constructorimpl(r4)
        L_0x00ab:
            java.lang.Throwable r0 = kotlin.Result.m4712exceptionOrNullimpl(r4)
            if (r0 != 0) goto L_0x00c5
            com.stripe.android.model.StripeIntent r4 = (com.stripe.android.model.StripeIntent) r4
            boolean r4 = r5 instanceof com.stripe.android.payments.paymentlauncher.PaymentResult.Failed
            if (r4 == 0) goto L_0x00c1
            com.stripe.android.payments.paymentlauncher.PaymentResult$Failed r5 = (com.stripe.android.payments.paymentlauncher.PaymentResult.Failed) r5
            java.lang.Throwable r4 = r5.getThrowable()
            java.lang.String r1 = r4.getMessage()
        L_0x00c1:
            r3.resetViewState((java.lang.String) r1)
            goto L_0x00c8
        L_0x00c5:
            r3.onFatal(r0)
        L_0x00c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.PaymentSheetViewModel.processPayment(com.stripe.android.model.StripeIntent, com.stripe.android.payments.paymentlauncher.PaymentResult):void");
    }

    public final void onGooglePayResult$paymentsheet_release(GooglePayPaymentMethodLauncher.Result result) {
        int i;
        Intrinsics.checkNotNullParameter(result, "result");
        setContentVisible(true);
        if (result instanceof GooglePayPaymentMethodLauncher.Result.Completed) {
            confirmPaymentSelection(new PaymentSelection.Saved(((GooglePayPaymentMethodLauncher.Result.Completed) result).getPaymentMethod()));
        } else if (result instanceof GooglePayPaymentMethodLauncher.Result.Failed) {
            GooglePayPaymentMethodLauncher.Result.Failed failed = (GooglePayPaymentMethodLauncher.Result.Failed) result;
            getLogger().error("Error processing Google Pay payment", failed.getError());
            getEventReporter$paymentsheet_release().onPaymentFailure(PaymentSelection.GooglePay.INSTANCE);
            if (failed.getErrorCode() == 3) {
                i = R.string.stripe_failure_connection_error;
            } else {
                i = R.string.stripe_google_pay_error_internal;
            }
            resetViewState(Integer.valueOf(i));
        } else if (result instanceof GooglePayPaymentMethodLauncher.Result.Canceled) {
            resetViewState$default(this, (String) null, 1, (Object) null);
        }
    }

    public void onFatal(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "throwable");
        getLogger().error("Payment Sheet error", th);
        get_fatal().setValue(th);
        this._paymentSheetResult.setValue(new PaymentSheetResult.Failed(th));
    }

    public void onUserCancel() {
        this._paymentSheetResult.setValue(PaymentSheetResult.Canceled.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheetViewModel$TransitionTarget;", "", "()V", "fragmentConfig", "Lcom/stripe/android/paymentsheet/model/FragmentConfig;", "getFragmentConfig", "()Lcom/stripe/android/paymentsheet/model/FragmentConfig;", "AddPaymentMethodFull", "AddPaymentMethodSheet", "SelectSavedPaymentMethod", "Lcom/stripe/android/paymentsheet/PaymentSheetViewModel$TransitionTarget$SelectSavedPaymentMethod;", "Lcom/stripe/android/paymentsheet/PaymentSheetViewModel$TransitionTarget$AddPaymentMethodFull;", "Lcom/stripe/android/paymentsheet/PaymentSheetViewModel$TransitionTarget$AddPaymentMethodSheet;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetViewModel.kt */
    public static abstract class TransitionTarget {
        public /* synthetic */ TransitionTarget(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract FragmentConfig getFragmentConfig();

        private TransitionTarget() {
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheetViewModel$TransitionTarget$SelectSavedPaymentMethod;", "Lcom/stripe/android/paymentsheet/PaymentSheetViewModel$TransitionTarget;", "fragmentConfig", "Lcom/stripe/android/paymentsheet/model/FragmentConfig;", "(Lcom/stripe/android/paymentsheet/model/FragmentConfig;)V", "getFragmentConfig", "()Lcom/stripe/android/paymentsheet/model/FragmentConfig;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheetViewModel.kt */
        public static final class SelectSavedPaymentMethod extends TransitionTarget {
            public static final int $stable = 8;
            private final FragmentConfig fragmentConfig;

            public static /* synthetic */ SelectSavedPaymentMethod copy$default(SelectSavedPaymentMethod selectSavedPaymentMethod, FragmentConfig fragmentConfig2, int i, Object obj) {
                if ((i & 1) != 0) {
                    fragmentConfig2 = selectSavedPaymentMethod.getFragmentConfig();
                }
                return selectSavedPaymentMethod.copy(fragmentConfig2);
            }

            public final FragmentConfig component1() {
                return getFragmentConfig();
            }

            public final SelectSavedPaymentMethod copy(FragmentConfig fragmentConfig2) {
                Intrinsics.checkNotNullParameter(fragmentConfig2, "fragmentConfig");
                return new SelectSavedPaymentMethod(fragmentConfig2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof SelectSavedPaymentMethod) && Intrinsics.areEqual((Object) getFragmentConfig(), (Object) ((SelectSavedPaymentMethod) obj).getFragmentConfig());
            }

            public int hashCode() {
                return getFragmentConfig().hashCode();
            }

            public String toString() {
                return "SelectSavedPaymentMethod(fragmentConfig=" + getFragmentConfig() + ')';
            }

            public FragmentConfig getFragmentConfig() {
                return this.fragmentConfig;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public SelectSavedPaymentMethod(FragmentConfig fragmentConfig2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(fragmentConfig2, "fragmentConfig");
                this.fragmentConfig = fragmentConfig2;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheetViewModel$TransitionTarget$AddPaymentMethodFull;", "Lcom/stripe/android/paymentsheet/PaymentSheetViewModel$TransitionTarget;", "fragmentConfig", "Lcom/stripe/android/paymentsheet/model/FragmentConfig;", "(Lcom/stripe/android/paymentsheet/model/FragmentConfig;)V", "getFragmentConfig", "()Lcom/stripe/android/paymentsheet/model/FragmentConfig;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheetViewModel.kt */
        public static final class AddPaymentMethodFull extends TransitionTarget {
            public static final int $stable = 8;
            private final FragmentConfig fragmentConfig;

            public static /* synthetic */ AddPaymentMethodFull copy$default(AddPaymentMethodFull addPaymentMethodFull, FragmentConfig fragmentConfig2, int i, Object obj) {
                if ((i & 1) != 0) {
                    fragmentConfig2 = addPaymentMethodFull.getFragmentConfig();
                }
                return addPaymentMethodFull.copy(fragmentConfig2);
            }

            public final FragmentConfig component1() {
                return getFragmentConfig();
            }

            public final AddPaymentMethodFull copy(FragmentConfig fragmentConfig2) {
                Intrinsics.checkNotNullParameter(fragmentConfig2, "fragmentConfig");
                return new AddPaymentMethodFull(fragmentConfig2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof AddPaymentMethodFull) && Intrinsics.areEqual((Object) getFragmentConfig(), (Object) ((AddPaymentMethodFull) obj).getFragmentConfig());
            }

            public int hashCode() {
                return getFragmentConfig().hashCode();
            }

            public String toString() {
                return "AddPaymentMethodFull(fragmentConfig=" + getFragmentConfig() + ')';
            }

            public FragmentConfig getFragmentConfig() {
                return this.fragmentConfig;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public AddPaymentMethodFull(FragmentConfig fragmentConfig2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(fragmentConfig2, "fragmentConfig");
                this.fragmentConfig = fragmentConfig2;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheetViewModel$TransitionTarget$AddPaymentMethodSheet;", "Lcom/stripe/android/paymentsheet/PaymentSheetViewModel$TransitionTarget;", "fragmentConfig", "Lcom/stripe/android/paymentsheet/model/FragmentConfig;", "(Lcom/stripe/android/paymentsheet/model/FragmentConfig;)V", "getFragmentConfig", "()Lcom/stripe/android/paymentsheet/model/FragmentConfig;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheetViewModel.kt */
        public static final class AddPaymentMethodSheet extends TransitionTarget {
            public static final int $stable = 8;
            private final FragmentConfig fragmentConfig;

            public static /* synthetic */ AddPaymentMethodSheet copy$default(AddPaymentMethodSheet addPaymentMethodSheet, FragmentConfig fragmentConfig2, int i, Object obj) {
                if ((i & 1) != 0) {
                    fragmentConfig2 = addPaymentMethodSheet.getFragmentConfig();
                }
                return addPaymentMethodSheet.copy(fragmentConfig2);
            }

            public final FragmentConfig component1() {
                return getFragmentConfig();
            }

            public final AddPaymentMethodSheet copy(FragmentConfig fragmentConfig2) {
                Intrinsics.checkNotNullParameter(fragmentConfig2, "fragmentConfig");
                return new AddPaymentMethodSheet(fragmentConfig2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof AddPaymentMethodSheet) && Intrinsics.areEqual((Object) getFragmentConfig(), (Object) ((AddPaymentMethodSheet) obj).getFragmentConfig());
            }

            public int hashCode() {
                return getFragmentConfig().hashCode();
            }

            public String toString() {
                return "AddPaymentMethodSheet(fragmentConfig=" + getFragmentConfig() + ')';
            }

            public FragmentConfig getFragmentConfig() {
                return this.fragmentConfig;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public AddPaymentMethodSheet(FragmentConfig fragmentConfig2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(fragmentConfig2, "fragmentConfig");
                this.fragmentConfig = fragmentConfig2;
            }
        }
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\"B5\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ5\u0010\u0015\u001a\u0002H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00160\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005X\u0004¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006#"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheetViewModel$Factory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "Lcom/stripe/android/core/injection/Injectable;", "Lcom/stripe/android/paymentsheet/PaymentSheetViewModel$Factory$FallbackInitializeParam;", "applicationSupplier", "Lkotlin/Function0;", "Landroid/app/Application;", "starterArgsSupplier", "Lcom/stripe/android/paymentsheet/PaymentSheetContract$Args;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "defaultArgs", "Landroid/os/Bundle;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V", "subComponentBuilderProvider", "Ljavax/inject/Provider;", "Lcom/stripe/android/paymentsheet/injection/PaymentSheetViewModelSubcomponent$Builder;", "getSubComponentBuilderProvider", "()Ljavax/inject/Provider;", "setSubComponentBuilderProvider", "(Ljavax/inject/Provider;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "key", "", "modelClass", "Ljava/lang/Class;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "fallbackInitialize", "", "arg", "FallbackInitializeParam", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetViewModel.kt */
    public static final class Factory extends AbstractSavedStateViewModelFactory implements Injectable<FallbackInitializeParam> {
        private final Function0<Application> applicationSupplier;
        private final Function0<PaymentSheetContract.Args> starterArgsSupplier;
        @Inject
        public Provider<PaymentSheetViewModelSubcomponent.Builder> subComponentBuilderProvider;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Factory(Function0 function0, Function0 function02, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(function0, function02, savedStateRegistryOwner, (i & 8) != 0 ? null : bundle);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Factory(Function0<? extends Application> function0, Function0<PaymentSheetContract.Args> function02, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
            super(savedStateRegistryOwner, bundle);
            Intrinsics.checkNotNullParameter(function0, "applicationSupplier");
            Intrinsics.checkNotNullParameter(function02, "starterArgsSupplier");
            Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "owner");
            this.applicationSupplier = function0;
            this.starterArgsSupplier = function02;
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheetViewModel$Factory$FallbackInitializeParam;", "", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "getApplication", "()Landroid/app/Application;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSheetViewModel.kt */
        public static final class FallbackInitializeParam {
            private final Application application;

            public static /* synthetic */ FallbackInitializeParam copy$default(FallbackInitializeParam fallbackInitializeParam, Application application2, int i, Object obj) {
                if ((i & 1) != 0) {
                    application2 = fallbackInitializeParam.application;
                }
                return fallbackInitializeParam.copy(application2);
            }

            public final Application component1() {
                return this.application;
            }

            public final FallbackInitializeParam copy(Application application2) {
                Intrinsics.checkNotNullParameter(application2, "application");
                return new FallbackInitializeParam(application2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof FallbackInitializeParam) && Intrinsics.areEqual((Object) this.application, (Object) ((FallbackInitializeParam) obj).application);
            }

            public int hashCode() {
                return this.application.hashCode();
            }

            public String toString() {
                return "FallbackInitializeParam(application=" + this.application + ')';
            }

            public FallbackInitializeParam(Application application2) {
                Intrinsics.checkNotNullParameter(application2, "application");
                this.application = application2;
            }

            public final Application getApplication() {
                return this.application;
            }
        }

        public final Provider<PaymentSheetViewModelSubcomponent.Builder> getSubComponentBuilderProvider() {
            Provider<PaymentSheetViewModelSubcomponent.Builder> provider = this.subComponentBuilderProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("subComponentBuilderProvider");
            return null;
        }

        public final void setSubComponentBuilderProvider(Provider<PaymentSheetViewModelSubcomponent.Builder> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.subComponentBuilderProvider = provider;
        }

        /* access modifiers changed from: protected */
        public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            PaymentSheetContract.Args invoke = this.starterArgsSupplier.invoke();
            InjectableKtxKt.injectWithFallback(this, invoke.getInjectorKey$paymentsheet_release(), new FallbackInitializeParam(this.applicationSupplier.invoke()));
            return getSubComponentBuilderProvider().get().paymentSheetViewModelModule(new PaymentSheetViewModelModule(invoke)).savedStateHandle(savedStateHandle).build().getViewModel();
        }

        public void fallbackInitialize(FallbackInitializeParam fallbackInitializeParam) {
            Intrinsics.checkNotNullParameter(fallbackInitializeParam, "arg");
            DaggerPaymentSheetLauncherComponent.builder().application(fallbackInitializeParam.getApplication()).injectorKey(InjectorKt.DUMMY_INJECTOR_KEY).build().inject(this);
        }
    }
}
