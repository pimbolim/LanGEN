package com.stripe.android.payments.bankaccount.di;

import android.app.Application;
import android.content.Context;
import com.stripe.android.core.Logger;
import com.stripe.android.core.injection.CoroutineContextModule;
import com.stripe.android.core.injection.CoroutineContextModule_ProvideWorkContextFactory;
import com.stripe.android.core.injection.LoggingModule;
import com.stripe.android.core.injection.LoggingModule_ProvideLoggerFactory;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeApiRepository;
import com.stripe.android.payments.bankaccount.di.CollectBankAccountComponent;
import com.stripe.android.payments.bankaccount.domain.AttachLinkAccountSession;
import com.stripe.android.payments.bankaccount.domain.CreateLinkAccountSession;
import com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract;
import com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewEffect;
import com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.MutableSharedFlow;

public final class DaggerCollectBankAccountComponent implements CollectBankAccountComponent {
    private final Application application;
    private final DaggerCollectBankAccountComponent collectBankAccountComponent;
    private final CollectBankAccountContract.Args configuration;
    private Provider<Logger> provideLoggerProvider;
    private Provider<CoroutineContext> provideWorkContextProvider;
    private final MutableSharedFlow<CollectBankAccountViewEffect> viewEffect;

    public void inject(CollectBankAccountViewModel.Factory factory) {
    }

    private DaggerCollectBankAccountComponent(CoroutineContextModule coroutineContextModule, LoggingModule loggingModule, Application application2, MutableSharedFlow<CollectBankAccountViewEffect> mutableSharedFlow, CollectBankAccountContract.Args args) {
        this.collectBankAccountComponent = this;
        this.configuration = args;
        this.viewEffect = mutableSharedFlow;
        this.application = application2;
        initialize(coroutineContextModule, loggingModule, application2, mutableSharedFlow, args);
    }

    public static CollectBankAccountComponent.Builder builder() {
        return new Builder();
    }

    private Context context() {
        return CollectBankAccountModule_ProvidesAppContextFactory.providesAppContext(this.application);
    }

    private Function0<String> namedFunction0OfString() {
        return CollectBankAccountModule_ProvidePublishableKeyFactory.providePublishableKey(this.configuration);
    }

    private PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory() {
        return new PaymentAnalyticsRequestFactory(context(), namedFunction0OfString(), CollectBankAccountModule_ProvidesProductUsageFactory.providesProductUsage());
    }

    private DefaultAnalyticsRequestExecutor defaultAnalyticsRequestExecutor() {
        return new DefaultAnalyticsRequestExecutor(this.provideLoggerProvider.get(), this.provideWorkContextProvider.get());
    }

    private StripeApiRepository stripeApiRepository() {
        return new StripeApiRepository(context(), namedFunction0OfString(), this.provideWorkContextProvider.get(), CollectBankAccountModule_ProvidesProductUsageFactory.providesProductUsage(), paymentAnalyticsRequestFactory(), (AnalyticsRequestExecutor) defaultAnalyticsRequestExecutor(), this.provideLoggerProvider.get());
    }

    private CreateLinkAccountSession createLinkAccountSession() {
        return new CreateLinkAccountSession(stripeApiRepository());
    }

    private AttachLinkAccountSession attachLinkAccountSession() {
        return new AttachLinkAccountSession(stripeApiRepository());
    }

    private void initialize(CoroutineContextModule coroutineContextModule, LoggingModule loggingModule, Application application2, MutableSharedFlow<CollectBankAccountViewEffect> mutableSharedFlow, CollectBankAccountContract.Args args) {
        this.provideWorkContextProvider = DoubleCheck.provider(CoroutineContextModule_ProvideWorkContextFactory.create(coroutineContextModule));
        this.provideLoggerProvider = DoubleCheck.provider(LoggingModule_ProvideLoggerFactory.create(loggingModule, CollectBankAccountModule_ProvidesEnableLoggingFactory.create()));
    }

    public CollectBankAccountViewModel getViewModel() {
        return new CollectBankAccountViewModel(this.configuration, this.viewEffect, createLinkAccountSession(), attachLinkAccountSession(), this.provideLoggerProvider.get());
    }

    private static final class Builder implements CollectBankAccountComponent.Builder {
        private Application application;
        private CollectBankAccountContract.Args configuration;
        private MutableSharedFlow<CollectBankAccountViewEffect> viewEffect;

        private Builder() {
        }

        public Builder application(Application application2) {
            this.application = (Application) Preconditions.checkNotNull(application2);
            return this;
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Object, kotlinx.coroutines.flow.MutableSharedFlow<com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewEffect>] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.stripe.android.payments.bankaccount.di.DaggerCollectBankAccountComponent.Builder viewEffect(kotlinx.coroutines.flow.MutableSharedFlow<com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewEffect> r1) {
            /*
                r0 = this;
                java.lang.Object r1 = dagger.internal.Preconditions.checkNotNull(r1)
                kotlinx.coroutines.flow.MutableSharedFlow r1 = (kotlinx.coroutines.flow.MutableSharedFlow) r1
                r0.viewEffect = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.bankaccount.di.DaggerCollectBankAccountComponent.Builder.viewEffect(kotlinx.coroutines.flow.MutableSharedFlow):com.stripe.android.payments.bankaccount.di.DaggerCollectBankAccountComponent$Builder");
        }

        public Builder configuration(CollectBankAccountContract.Args args) {
            this.configuration = (CollectBankAccountContract.Args) Preconditions.checkNotNull(args);
            return this;
        }

        public CollectBankAccountComponent build() {
            Preconditions.checkBuilderRequirement(this.application, Application.class);
            Preconditions.checkBuilderRequirement(this.viewEffect, MutableSharedFlow.class);
            Preconditions.checkBuilderRequirement(this.configuration, CollectBankAccountContract.Args.class);
            return new DaggerCollectBankAccountComponent(new CoroutineContextModule(), new LoggingModule(), this.application, this.viewEffect, this.configuration);
        }
    }
}
