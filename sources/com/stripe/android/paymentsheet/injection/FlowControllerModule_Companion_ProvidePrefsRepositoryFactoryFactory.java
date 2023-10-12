package com.stripe.android.paymentsheet.injection;

import android.content.Context;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.PrefsRepository;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;

public final class FlowControllerModule_Companion_ProvidePrefsRepositoryFactoryFactory implements Factory<Function1<PaymentSheet.CustomerConfiguration, PrefsRepository>> {
    private final Provider<Context> appContextProvider;
    private final Provider<CoroutineContext> workContextProvider;

    public FlowControllerModule_Companion_ProvidePrefsRepositoryFactoryFactory(Provider<Context> provider, Provider<CoroutineContext> provider2) {
        this.appContextProvider = provider;
        this.workContextProvider = provider2;
    }

    public Function1<PaymentSheet.CustomerConfiguration, PrefsRepository> get() {
        return providePrefsRepositoryFactory(this.appContextProvider.get(), this.workContextProvider.get());
    }

    public static FlowControllerModule_Companion_ProvidePrefsRepositoryFactoryFactory create(Provider<Context> provider, Provider<CoroutineContext> provider2) {
        return new FlowControllerModule_Companion_ProvidePrefsRepositoryFactoryFactory(provider, provider2);
    }

    public static Function1<PaymentSheet.CustomerConfiguration, PrefsRepository> providePrefsRepositoryFactory(Context context, CoroutineContext coroutineContext) {
        return (Function1) Preconditions.checkNotNullFromProvides(FlowControllerModule.Companion.providePrefsRepositoryFactory(context, coroutineContext));
    }
}
