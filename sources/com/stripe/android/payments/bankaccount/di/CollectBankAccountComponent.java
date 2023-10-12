package com.stripe.android.payments.bankaccount.di;

import android.app.Application;
import com.stripe.android.core.injection.CoroutineContextModule;
import com.stripe.android.core.injection.LoggingModule;
import com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract;
import com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewEffect;
import com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel;
import com.stripe.android.payments.core.injection.StripeRepositoryModule;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlinx.coroutines.flow.MutableSharedFlow;

@Component(modules = {CoroutineContextModule.class, CollectBankAccountModule.class, StripeRepositoryModule.class, LoggingModule.class})
@Singleton
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\nJ\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/payments/bankaccount/di/CollectBankAccountComponent;", "", "viewModel", "Lcom/stripe/android/payments/bankaccount/ui/CollectBankAccountViewModel;", "getViewModel", "()Lcom/stripe/android/payments/bankaccount/ui/CollectBankAccountViewModel;", "inject", "", "factory", "Lcom/stripe/android/payments/bankaccount/ui/CollectBankAccountViewModel$Factory;", "Builder", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectBankAccountComponent.kt */
public interface CollectBankAccountComponent {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0016\u0010\b\u001a\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\n0\tH'¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/payments/bankaccount/di/CollectBankAccountComponent$Builder;", "", "application", "Landroid/app/Application;", "build", "Lcom/stripe/android/payments/bankaccount/di/CollectBankAccountComponent;", "configuration", "Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountContract$Args;", "viewEffect", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/stripe/android/payments/bankaccount/ui/CollectBankAccountViewEffect;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Component.Builder
    /* compiled from: CollectBankAccountComponent.kt */
    public interface Builder {
        @BindsInstance
        Builder application(Application application);

        CollectBankAccountComponent build();

        @BindsInstance
        Builder configuration(CollectBankAccountContract.Args args);

        @BindsInstance
        Builder viewEffect(MutableSharedFlow<CollectBankAccountViewEffect> mutableSharedFlow);
    }

    CollectBankAccountViewModel getViewModel();

    void inject(CollectBankAccountViewModel.Factory factory);
}
