package com.stripe.android.paymentsheet.injection;

import android.content.Context;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.PrefsRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;

public final class PaymentOptionsViewModelModule_ProvidePrefsRepositoryFactoryFactory implements Factory<Function1<PaymentSheet.CustomerConfiguration, PrefsRepository>> {
    private final Provider<Context> appContextProvider;
    private final PaymentOptionsViewModelModule module;
    private final Provider<CoroutineContext> workContextProvider;

    public PaymentOptionsViewModelModule_ProvidePrefsRepositoryFactoryFactory(PaymentOptionsViewModelModule paymentOptionsViewModelModule, Provider<Context> provider, Provider<CoroutineContext> provider2) {
        this.module = paymentOptionsViewModelModule;
        this.appContextProvider = provider;
        this.workContextProvider = provider2;
    }

    public Function1<PaymentSheet.CustomerConfiguration, PrefsRepository> get() {
        return providePrefsRepositoryFactory(this.module, this.appContextProvider.get(), this.workContextProvider.get());
    }

    public static PaymentOptionsViewModelModule_ProvidePrefsRepositoryFactoryFactory create(PaymentOptionsViewModelModule paymentOptionsViewModelModule, Provider<Context> provider, Provider<CoroutineContext> provider2) {
        return new PaymentOptionsViewModelModule_ProvidePrefsRepositoryFactoryFactory(paymentOptionsViewModelModule, provider, provider2);
    }

    public static Function1<PaymentSheet.CustomerConfiguration, PrefsRepository> providePrefsRepositoryFactory(PaymentOptionsViewModelModule paymentOptionsViewModelModule, Context context, CoroutineContext coroutineContext) {
        return (Function1) Preconditions.checkNotNullFromProvides(paymentOptionsViewModelModule.providePrefsRepositoryFactory(context, coroutineContext));
    }
}
