package com.stripe.android.paymentsheet.injection;

import android.content.Context;
import android.content.res.Resources;
import com.stripe.android.core.injection.CoroutineContextModule;
import com.stripe.android.core.injection.CoroutineContextModule_ProvideWorkContextFactory;
import com.stripe.android.paymentsheet.forms.FormViewModel;
import com.stripe.android.paymentsheet.forms.FormViewModel_Factory_MembersInjector;
import com.stripe.android.paymentsheet.forms.TransformSpecToElement;
import com.stripe.android.paymentsheet.injection.FormViewModelComponent;
import com.stripe.android.paymentsheet.injection.FormViewModelSubcomponent;
import com.stripe.android.paymentsheet.paymentdatacollection.FormFragmentArguments;
import com.stripe.android.ui.core.elements.LayoutSpec;
import com.stripe.android.ui.core.forms.resources.AsyncResourceRepository;
import com.stripe.android.ui.core.forms.resources.AsyncResourceRepository_Factory;
import com.stripe.android.ui.core.forms.resources.ResourceRepository;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.Locale;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

public final class DaggerFormViewModelComponent implements FormViewModelComponent {
    /* access modifiers changed from: private */
    public Provider<AsyncResourceRepository> asyncResourceRepositoryProvider;
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public final DaggerFormViewModelComponent formViewModelComponent;
    private Provider<FormViewModelSubcomponent.Builder> formViewModelSubcomponentBuilderProvider;
    private Provider<Locale> provideLocaleProvider;
    private Provider<CoroutineContext> provideWorkContextProvider;
    private Provider<Resources> resourcesProvider;

    private DaggerFormViewModelComponent(CoroutineContextModule coroutineContextModule, Context context2, Resources resources) {
        this.formViewModelComponent = this;
        this.context = context2;
        initialize(coroutineContextModule, context2, resources);
    }

    public static FormViewModelComponent.Builder builder() {
        return new Builder();
    }

    private void initialize(CoroutineContextModule coroutineContextModule, Context context2, Resources resources) {
        this.formViewModelSubcomponentBuilderProvider = new Provider<FormViewModelSubcomponent.Builder>() {
            public FormViewModelSubcomponent.Builder get() {
                return new FormViewModelSubcomponentBuilder();
            }
        };
        this.resourcesProvider = InstanceFactory.create(resources);
        this.provideWorkContextProvider = DoubleCheck.provider(CoroutineContextModule_ProvideWorkContextFactory.create(coroutineContextModule));
        Provider<Locale> provider = DoubleCheck.provider(FormViewModelModule_Companion_ProvideLocaleFactory.create());
        this.provideLocaleProvider = provider;
        this.asyncResourceRepositoryProvider = DoubleCheck.provider(AsyncResourceRepository_Factory.create(this.resourcesProvider, this.provideWorkContextProvider, provider));
    }

    public void inject(FormViewModel.Factory factory) {
        injectFactory(factory);
    }

    private FormViewModel.Factory injectFactory(FormViewModel.Factory factory) {
        FormViewModel_Factory_MembersInjector.injectSubComponentBuilderProvider(factory, this.formViewModelSubcomponentBuilderProvider);
        return factory;
    }

    private static final class Builder implements FormViewModelComponent.Builder {
        private Context context;
        private Resources resources;

        private Builder() {
        }

        public Builder context(Context context2) {
            this.context = (Context) Preconditions.checkNotNull(context2);
            return this;
        }

        public Builder resources(Resources resources2) {
            this.resources = (Resources) Preconditions.checkNotNull(resources2);
            return this;
        }

        public FormViewModelComponent build() {
            Preconditions.checkBuilderRequirement(this.context, Context.class);
            Preconditions.checkBuilderRequirement(this.resources, Resources.class);
            return new DaggerFormViewModelComponent(new CoroutineContextModule(), this.context, this.resources);
        }
    }

    private static final class FormViewModelSubcomponentBuilder implements FormViewModelSubcomponent.Builder {
        private FormFragmentArguments formFragmentArguments;
        private final DaggerFormViewModelComponent formViewModelComponent;
        private LayoutSpec layout;

        private FormViewModelSubcomponentBuilder(DaggerFormViewModelComponent daggerFormViewModelComponent) {
            this.formViewModelComponent = daggerFormViewModelComponent;
        }

        public FormViewModelSubcomponentBuilder layout(LayoutSpec layoutSpec) {
            this.layout = (LayoutSpec) Preconditions.checkNotNull(layoutSpec);
            return this;
        }

        public FormViewModelSubcomponentBuilder formFragmentArguments(FormFragmentArguments formFragmentArguments2) {
            this.formFragmentArguments = (FormFragmentArguments) Preconditions.checkNotNull(formFragmentArguments2);
            return this;
        }

        public FormViewModelSubcomponent build() {
            Preconditions.checkBuilderRequirement(this.layout, LayoutSpec.class);
            Preconditions.checkBuilderRequirement(this.formFragmentArguments, FormFragmentArguments.class);
            return new FormViewModelSubcomponentImpl(this.layout, this.formFragmentArguments);
        }
    }

    private static final class FormViewModelSubcomponentImpl implements FormViewModelSubcomponent {
        private final FormFragmentArguments formFragmentArguments;
        private final DaggerFormViewModelComponent formViewModelComponent;
        private final FormViewModelSubcomponentImpl formViewModelSubcomponentImpl;
        private final LayoutSpec layout;

        private FormViewModelSubcomponentImpl(DaggerFormViewModelComponent daggerFormViewModelComponent, LayoutSpec layoutSpec, FormFragmentArguments formFragmentArguments2) {
            this.formViewModelSubcomponentImpl = this;
            this.formViewModelComponent = daggerFormViewModelComponent;
            this.layout = layoutSpec;
            this.formFragmentArguments = formFragmentArguments2;
        }

        private TransformSpecToElement transformSpecToElement() {
            return new TransformSpecToElement((ResourceRepository) this.formViewModelComponent.asyncResourceRepositoryProvider.get(), this.formFragmentArguments, this.formViewModelComponent.context);
        }

        public FormViewModel getViewModel() {
            return new FormViewModel(this.layout, this.formFragmentArguments, (ResourceRepository) this.formViewModelComponent.asyncResourceRepositoryProvider.get(), transformSpecToElement());
        }
    }
}
