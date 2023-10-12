package com.stripe.android.connections.di;

import android.app.Application;
import androidx.lifecycle.SavedStateHandle;
import com.stripe.android.connections.ConnectionsSheetContract;
import com.stripe.android.connections.ConnectionsSheetViewModel;
import com.stripe.android.core.injection.CoroutineContextModule;
import com.stripe.android.core.injection.LoggingModule;
import dagger.BindsInstance;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;

@Component(modules = {ConnectionsSheetModule.class, CoroutineContextModule.class, LoggingModule.class})
@Singleton
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\nJ\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/connections/di/ConnectionsSheetComponent;", "", "viewModel", "Lcom/stripe/android/connections/ConnectionsSheetViewModel;", "getViewModel", "()Lcom/stripe/android/connections/ConnectionsSheetViewModel;", "inject", "", "factory", "Lcom/stripe/android/connections/ConnectionsSheetViewModel$Factory;", "Builder", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectionsSheetComponent.kt */
public interface ConnectionsSheetComponent {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H'J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tH'¨\u0006\n"}, d2 = {"Lcom/stripe/android/connections/di/ConnectionsSheetComponent$Builder;", "", "application", "Landroid/app/Application;", "build", "Lcom/stripe/android/connections/di/ConnectionsSheetComponent;", "configuration", "Lcom/stripe/android/connections/ConnectionsSheetContract$Args;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Component.Builder
    /* compiled from: ConnectionsSheetComponent.kt */
    public interface Builder {
        @BindsInstance
        Builder application(Application application);

        ConnectionsSheetComponent build();

        @BindsInstance
        Builder configuration(ConnectionsSheetContract.Args args);

        @BindsInstance
        Builder savedStateHandle(SavedStateHandle savedStateHandle);
    }

    ConnectionsSheetViewModel getViewModel();

    void inject(ConnectionsSheetViewModel.Factory factory);
}
