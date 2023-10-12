package com.stripe.android.payments.core.injection;

import android.app.Application;
import androidx.lifecycle.SavedStateHandle;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionContract;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2TransactionViewModel;
import dagger.BindsInstance;
import dagger.Subcomponent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/payments/core/injection/Stripe3ds2TransactionViewModelSubcomponent;", "", "viewModel", "Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionViewModel;", "getViewModel", "()Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionViewModel;", "Builder", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Subcomponent(modules = {Stripe3dsTransactionViewModelModule.class})
/* compiled from: Stripe3ds2TransactionViewModelSubcomponent.kt */
public interface Stripe3ds2TransactionViewModelSubcomponent {

    @Subcomponent.Builder
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H'J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH'¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/payments/core/injection/Stripe3ds2TransactionViewModelSubcomponent$Builder;", "", "application", "Landroid/app/Application;", "args", "Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2TransactionContract$Args;", "build", "Lcom/stripe/android/payments/core/injection/Stripe3ds2TransactionViewModelSubcomponent;", "savedStateHandle", "handle", "Landroidx/lifecycle/SavedStateHandle;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Stripe3ds2TransactionViewModelSubcomponent.kt */
    public interface Builder {
        @BindsInstance
        Builder application(Application application);

        @BindsInstance
        Builder args(Stripe3ds2TransactionContract.Args args);

        Stripe3ds2TransactionViewModelSubcomponent build();

        @BindsInstance
        Builder savedStateHandle(SavedStateHandle savedStateHandle);
    }

    Stripe3ds2TransactionViewModel getViewModel();
}
