package com.stripe.android.paymentsheet.injection;

import android.content.Context;
import com.stripe.android.paymentsheet.PrefsRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

public final class PaymentSheetViewModelModule_ProvidePrefsRepositoryFactory implements Factory<PrefsRepository> {
    private final Provider<Context> appContextProvider;
    private final PaymentSheetViewModelModule module;
    private final Provider<CoroutineContext> workContextProvider;

    public PaymentSheetViewModelModule_ProvidePrefsRepositoryFactory(PaymentSheetViewModelModule paymentSheetViewModelModule, Provider<Context> provider, Provider<CoroutineContext> provider2) {
        this.module = paymentSheetViewModelModule;
        this.appContextProvider = provider;
        this.workContextProvider = provider2;
    }

    public PrefsRepository get() {
        return providePrefsRepository(this.module, this.appContextProvider.get(), this.workContextProvider.get());
    }

    public static PaymentSheetViewModelModule_ProvidePrefsRepositoryFactory create(PaymentSheetViewModelModule paymentSheetViewModelModule, Provider<Context> provider, Provider<CoroutineContext> provider2) {
        return new PaymentSheetViewModelModule_ProvidePrefsRepositoryFactory(paymentSheetViewModelModule, provider, provider2);
    }

    public static PrefsRepository providePrefsRepository(PaymentSheetViewModelModule paymentSheetViewModelModule, Context context, CoroutineContext coroutineContext) {
        return (PrefsRepository) Preconditions.checkNotNullFromProvides(paymentSheetViewModelModule.providePrefsRepository(context, coroutineContext));
    }
}
