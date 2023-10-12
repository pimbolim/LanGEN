package com.stripe.android.paymentsheet.flowcontroller;

import androidx.activity.result.ActivityResultCaller;
import androidx.lifecycle.LifecycleOwner;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.googlepaylauncher.injection.GooglePayPaymentMethodLauncherFactory;
import com.stripe.android.payments.paymentlauncher.StripePaymentLauncherAssistedFactory;
import com.stripe.android.paymentsheet.PaymentOptionCallback;
import com.stripe.android.paymentsheet.PaymentSheetResultCallback;
import com.stripe.android.paymentsheet.analytics.EventReporter;
import com.stripe.android.paymentsheet.model.PaymentOptionFactory;
import com.stripe.android.ui.core.forms.resources.ResourceRepository;
import dagger.Lazy;
import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import java.util.Set;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

public final class DefaultFlowController_Factory implements Factory<DefaultFlowController> {
    private final Provider<ActivityResultCaller> activityResultCallerProvider;
    private final Provider<Boolean> enableLoggingProvider;
    private final Provider<EventReporter> eventReporterProvider;
    private final Provider<FlowControllerInitializer> flowControllerInitializerProvider;
    private final Provider<GooglePayPaymentMethodLauncherFactory> googlePayPaymentMethodLauncherFactoryProvider;
    private final Provider<String> injectorKeyProvider;
    private final Provider<LifecycleOwner> lifecycleOwnerProvider;
    private final Provider<CoroutineScope> lifecycleScopeProvider;
    private final Provider<PaymentConfiguration> paymentConfigurationProvider;
    private final Provider<StripePaymentLauncherAssistedFactory> paymentLauncherFactoryProvider;
    private final Provider<PaymentOptionCallback> paymentOptionCallbackProvider;
    private final Provider<PaymentOptionFactory> paymentOptionFactoryProvider;
    private final Provider<PaymentSheetResultCallback> paymentResultCallbackProvider;
    private final Provider<Set<String>> productUsageProvider;
    private final Provider<ResourceRepository> resourceRepositoryProvider;
    private final Provider<Function0<Integer>> statusBarColorProvider;
    private final Provider<CoroutineContext> uiContextProvider;
    private final Provider<FlowControllerViewModel> viewModelProvider;

    public DefaultFlowController_Factory(Provider<CoroutineScope> provider, Provider<LifecycleOwner> provider2, Provider<Function0<Integer>> provider3, Provider<PaymentOptionFactory> provider4, Provider<PaymentOptionCallback> provider5, Provider<PaymentSheetResultCallback> provider6, Provider<ActivityResultCaller> provider7, Provider<String> provider8, Provider<FlowControllerInitializer> provider9, Provider<EventReporter> provider10, Provider<FlowControllerViewModel> provider11, Provider<StripePaymentLauncherAssistedFactory> provider12, Provider<ResourceRepository> provider13, Provider<PaymentConfiguration> provider14, Provider<CoroutineContext> provider15, Provider<Boolean> provider16, Provider<Set<String>> provider17, Provider<GooglePayPaymentMethodLauncherFactory> provider18) {
        this.lifecycleScopeProvider = provider;
        this.lifecycleOwnerProvider = provider2;
        this.statusBarColorProvider = provider3;
        this.paymentOptionFactoryProvider = provider4;
        this.paymentOptionCallbackProvider = provider5;
        this.paymentResultCallbackProvider = provider6;
        this.activityResultCallerProvider = provider7;
        this.injectorKeyProvider = provider8;
        this.flowControllerInitializerProvider = provider9;
        this.eventReporterProvider = provider10;
        this.viewModelProvider = provider11;
        this.paymentLauncherFactoryProvider = provider12;
        this.resourceRepositoryProvider = provider13;
        this.paymentConfigurationProvider = provider14;
        this.uiContextProvider = provider15;
        this.enableLoggingProvider = provider16;
        this.productUsageProvider = provider17;
        this.googlePayPaymentMethodLauncherFactoryProvider = provider18;
    }

    public DefaultFlowController get() {
        return newInstance(this.lifecycleScopeProvider.get(), this.lifecycleOwnerProvider.get(), this.statusBarColorProvider.get(), this.paymentOptionFactoryProvider.get(), this.paymentOptionCallbackProvider.get(), this.paymentResultCallbackProvider.get(), this.activityResultCallerProvider.get(), this.injectorKeyProvider.get(), this.flowControllerInitializerProvider.get(), this.eventReporterProvider.get(), this.viewModelProvider.get(), this.paymentLauncherFactoryProvider.get(), this.resourceRepositoryProvider.get(), DoubleCheck.lazy(this.paymentConfigurationProvider), this.uiContextProvider.get(), this.enableLoggingProvider.get().booleanValue(), this.productUsageProvider.get(), this.googlePayPaymentMethodLauncherFactoryProvider.get());
    }

    public static DefaultFlowController_Factory create(Provider<CoroutineScope> provider, Provider<LifecycleOwner> provider2, Provider<Function0<Integer>> provider3, Provider<PaymentOptionFactory> provider4, Provider<PaymentOptionCallback> provider5, Provider<PaymentSheetResultCallback> provider6, Provider<ActivityResultCaller> provider7, Provider<String> provider8, Provider<FlowControllerInitializer> provider9, Provider<EventReporter> provider10, Provider<FlowControllerViewModel> provider11, Provider<StripePaymentLauncherAssistedFactory> provider12, Provider<ResourceRepository> provider13, Provider<PaymentConfiguration> provider14, Provider<CoroutineContext> provider15, Provider<Boolean> provider16, Provider<Set<String>> provider17, Provider<GooglePayPaymentMethodLauncherFactory> provider18) {
        return new DefaultFlowController_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13, provider14, provider15, provider16, provider17, provider18);
    }

    public static DefaultFlowController newInstance(CoroutineScope coroutineScope, LifecycleOwner lifecycleOwner, Function0<Integer> function0, PaymentOptionFactory paymentOptionFactory, PaymentOptionCallback paymentOptionCallback, PaymentSheetResultCallback paymentSheetResultCallback, ActivityResultCaller activityResultCaller, String str, FlowControllerInitializer flowControllerInitializer, EventReporter eventReporter, FlowControllerViewModel flowControllerViewModel, StripePaymentLauncherAssistedFactory stripePaymentLauncherAssistedFactory, ResourceRepository resourceRepository, Lazy<PaymentConfiguration> lazy, CoroutineContext coroutineContext, boolean z, Set<String> set, GooglePayPaymentMethodLauncherFactory googlePayPaymentMethodLauncherFactory) {
        return new DefaultFlowController(coroutineScope, lifecycleOwner, function0, paymentOptionFactory, paymentOptionCallback, paymentSheetResultCallback, activityResultCaller, str, flowControllerInitializer, eventReporter, flowControllerViewModel, stripePaymentLauncherAssistedFactory, resourceRepository, lazy, coroutineContext, z, set, googlePayPaymentMethodLauncherFactory);
    }
}
