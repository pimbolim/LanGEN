package com.stripe.android.payments.bankaccount.di;

import com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.jvm.functions.Function0;

public final class CollectBankAccountModule_ProvidePublishableKeyFactory implements Factory<Function0<String>> {
    private final Provider<CollectBankAccountContract.Args> argsProvider;

    public CollectBankAccountModule_ProvidePublishableKeyFactory(Provider<CollectBankAccountContract.Args> provider) {
        this.argsProvider = provider;
    }

    public Function0<String> get() {
        return providePublishableKey(this.argsProvider.get());
    }

    public static CollectBankAccountModule_ProvidePublishableKeyFactory create(Provider<CollectBankAccountContract.Args> provider) {
        return new CollectBankAccountModule_ProvidePublishableKeyFactory(provider);
    }

    public static Function0<String> providePublishableKey(CollectBankAccountContract.Args args) {
        return (Function0) Preconditions.checkNotNullFromProvides(CollectBankAccountModule.INSTANCE.providePublishableKey(args));
    }
}
