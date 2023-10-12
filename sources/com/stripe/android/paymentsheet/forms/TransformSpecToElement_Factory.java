package com.stripe.android.paymentsheet.forms;

import android.content.Context;
import com.stripe.android.paymentsheet.paymentdatacollection.FormFragmentArguments;
import com.stripe.android.ui.core.forms.resources.ResourceRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

public final class TransformSpecToElement_Factory implements Factory<TransformSpecToElement> {
    private final Provider<Context> contextProvider;
    private final Provider<FormFragmentArguments> formFragmentArgumentsProvider;
    private final Provider<ResourceRepository> resourceRepositoryProvider;

    public TransformSpecToElement_Factory(Provider<ResourceRepository> provider, Provider<FormFragmentArguments> provider2, Provider<Context> provider3) {
        this.resourceRepositoryProvider = provider;
        this.formFragmentArgumentsProvider = provider2;
        this.contextProvider = provider3;
    }

    public TransformSpecToElement get() {
        return newInstance(this.resourceRepositoryProvider.get(), this.formFragmentArgumentsProvider.get(), this.contextProvider.get());
    }

    public static TransformSpecToElement_Factory create(Provider<ResourceRepository> provider, Provider<FormFragmentArguments> provider2, Provider<Context> provider3) {
        return new TransformSpecToElement_Factory(provider, provider2, provider3);
    }

    public static TransformSpecToElement newInstance(ResourceRepository resourceRepository, FormFragmentArguments formFragmentArguments, Context context) {
        return new TransformSpecToElement(resourceRepository, formFragmentArguments, context);
    }
}
