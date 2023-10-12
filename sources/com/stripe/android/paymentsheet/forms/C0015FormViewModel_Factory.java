package com.stripe.android.paymentsheet.forms;

import com.stripe.android.paymentsheet.paymentdatacollection.FormFragmentArguments;
import com.stripe.android.ui.core.elements.LayoutSpec;
import com.stripe.android.ui.core.forms.resources.ResourceRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.stripe.android.paymentsheet.forms.FormViewModel_Factory  reason: case insensitive filesystem */
public final class C0015FormViewModel_Factory implements Factory<FormViewModel> {
    private final Provider<FormFragmentArguments> configProvider;
    private final Provider<LayoutSpec> layoutProvider;
    private final Provider<ResourceRepository> resourceRepositoryProvider;
    private final Provider<TransformSpecToElement> transformSpecToElementProvider;

    public C0015FormViewModel_Factory(Provider<LayoutSpec> provider, Provider<FormFragmentArguments> provider2, Provider<ResourceRepository> provider3, Provider<TransformSpecToElement> provider4) {
        this.layoutProvider = provider;
        this.configProvider = provider2;
        this.resourceRepositoryProvider = provider3;
        this.transformSpecToElementProvider = provider4;
    }

    public FormViewModel get() {
        return newInstance(this.layoutProvider.get(), this.configProvider.get(), this.resourceRepositoryProvider.get(), this.transformSpecToElementProvider.get());
    }

    public static C0015FormViewModel_Factory create(Provider<LayoutSpec> provider, Provider<FormFragmentArguments> provider2, Provider<ResourceRepository> provider3, Provider<TransformSpecToElement> provider4) {
        return new C0015FormViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static FormViewModel newInstance(LayoutSpec layoutSpec, FormFragmentArguments formFragmentArguments, ResourceRepository resourceRepository, TransformSpecToElement transformSpecToElement) {
        return new FormViewModel(layoutSpec, formFragmentArguments, resourceRepository, transformSpecToElement);
    }
}
