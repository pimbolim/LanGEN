package com.stripe.android.payments.bankaccount.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistryOwner;
import com.stripe.android.payments.bankaccount.navigation.CollectBankAccountContract;
import com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewEffect;
import com.stripe.android.payments.bankaccount.ui.CollectBankAccountViewModel;
import com.stripe.android.payments.connections.ConnectionsPaymentsProxy;
import com.stripe.android.payments.connections.reflection.IsConnectionsAvailable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\f\u0010\u001b\u001a\u00020\u0017*\u00020\u001cH\u0002J\f\u0010\u001b\u001a\u00020\u0017*\u00020\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/stripe/android/payments/bankaccount/ui/CollectBankAccountActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "connectionsPaymentsProxy", "Lcom/stripe/android/payments/connections/ConnectionsPaymentsProxy;", "starterArgs", "Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountContract$Args;", "getStarterArgs", "()Lcom/stripe/android/payments/bankaccount/navigation/CollectBankAccountContract$Args;", "starterArgs$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/stripe/android/payments/bankaccount/ui/CollectBankAccountViewModel;", "getViewModel", "()Lcom/stripe/android/payments/bankaccount/ui/CollectBankAccountViewModel;", "viewModel$delegate", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory$payments_core_release", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory$payments_core_release", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "initConnectionsPaymentsProxy", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "launch", "Lcom/stripe/android/payments/bankaccount/ui/CollectBankAccountViewEffect$FinishWithResult;", "Lcom/stripe/android/payments/bankaccount/ui/CollectBankAccountViewEffect$OpenConnectionsFlow;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectBankAccountActivity.kt */
public final class CollectBankAccountActivity extends AppCompatActivity {
    private ConnectionsPaymentsProxy connectionsPaymentsProxy;
    private final Lazy starterArgs$delegate = LazyKt.lazy(new CollectBankAccountActivity$starterArgs$2(this));
    private final Lazy viewModel$delegate;
    private ViewModelProvider.Factory viewModelFactory;

    public CollectBankAccountActivity() {
        Function0 collectBankAccountActivity$viewModelFactory$1 = new CollectBankAccountActivity$viewModelFactory$1(this);
        Function0 collectBankAccountActivity$viewModelFactory$2 = new CollectBankAccountActivity$viewModelFactory$2(this);
        SavedStateRegistryOwner savedStateRegistryOwner = this;
        Intent intent = getIntent();
        this.viewModelFactory = new CollectBankAccountViewModel.Factory(collectBankAccountActivity$viewModelFactory$1, collectBankAccountActivity$viewModelFactory$2, savedStateRegistryOwner, intent == null ? null : intent.getExtras());
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(CollectBankAccountViewModel.class), new CollectBankAccountActivity$special$$inlined$viewModels$2(this), new CollectBankAccountActivity$viewModel$2(this));
    }

    /* access modifiers changed from: private */
    public final CollectBankAccountContract.Args getStarterArgs() {
        return (CollectBankAccountContract.Args) this.starterArgs$delegate.getValue();
    }

    public final ViewModelProvider.Factory getViewModelFactory$payments_core_release() {
        return this.viewModelFactory;
    }

    public final void setViewModelFactory$payments_core_release(ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.viewModelFactory = factory;
    }

    /* access modifiers changed from: private */
    public final CollectBankAccountViewModel getViewModel() {
        return (CollectBankAccountViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initConnectionsPaymentsProxy();
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new CollectBankAccountActivity$onCreate$1(this, (Continuation<? super CollectBankAccountActivity$onCreate$1>) null));
    }

    private final void initConnectionsPaymentsProxy() {
        this.connectionsPaymentsProxy = ConnectionsPaymentsProxy.Companion.create$default(ConnectionsPaymentsProxy.Companion, (AppCompatActivity) this, (Function1) new CollectBankAccountActivity$initConnectionsPaymentsProxy$1(getViewModel()), (Function0) null, (IsConnectionsAvailable) null, 12, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void launch(CollectBankAccountViewEffect.OpenConnectionsFlow openConnectionsFlow) {
        ConnectionsPaymentsProxy connectionsPaymentsProxy2 = this.connectionsPaymentsProxy;
        if (connectionsPaymentsProxy2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectionsPaymentsProxy");
            connectionsPaymentsProxy2 = null;
        }
        connectionsPaymentsProxy2.present(openConnectionsFlow.getLinkedAccountSessionClientSecret(), openConnectionsFlow.getPublishableKey());
    }

    /* access modifiers changed from: private */
    public final void launch(CollectBankAccountViewEffect.FinishWithResult finishWithResult) {
        setResult(-1, new Intent().putExtras(new CollectBankAccountContract.Result(finishWithResult.getResult()).toBundle()));
        finish();
    }
}
