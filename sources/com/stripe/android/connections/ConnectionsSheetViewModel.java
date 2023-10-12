package com.stripe.android.connections;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.savedstate.SavedStateRegistryOwner;
import com.stripe.android.connections.ConnectionsSheetContract;
import com.stripe.android.connections.ConnectionsSheetResult;
import com.stripe.android.connections.ConnectionsSheetViewEffect;
import com.stripe.android.connections.analytics.ConnectionsEventReporter;
import com.stripe.android.connections.di.DaggerConnectionsSheetComponent;
import com.stripe.android.connections.di.NamedConstantsKt;
import com.stripe.android.connections.domain.FetchLinkAccountSession;
import com.stripe.android.connections.domain.GenerateLinkAccountSessionManifest;
import com.stripe.android.connections.model.LinkAccountSessionManifest;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 62\u00020\u0001:\u000267B9\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\b\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0017\u0010\u001f\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010!H\u0000¢\u0006\u0002\b\"J\r\u0010#\u001a\u00020\u001dH\u0000¢\u0006\u0002\b$J\r\u0010%\u001a\u00020\u001dH\u0000¢\u0006\u0002\b&J\u0019\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020)H@ø\u0001\u0000¢\u0006\u0002\u0010*J\r\u0010+\u001a\u00020\u001dH\u0000¢\u0006\u0002\b,J\u0011\u0010-\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010.J\u0019\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u000201H@ø\u0001\u0000¢\u0006\u0002\u00102J'\u00103\u001a\u00020\u001d*\b\u0012\u0004\u0012\u00020\u00110\u00102\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u001105H\bR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u001aX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u0002\u0004\n\u0002\b\u0019¨\u00068"}, d2 = {"Lcom/stripe/android/connections/ConnectionsSheetViewModel;", "Landroidx/lifecycle/ViewModel;", "applicationId", "", "starterArgs", "Lcom/stripe/android/connections/ConnectionsSheetContract$Args;", "generateLinkAccountSessionManifest", "Lcom/stripe/android/connections/domain/GenerateLinkAccountSessionManifest;", "fetchLinkAccountSession", "Lcom/stripe/android/connections/domain/FetchLinkAccountSession;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "eventReporter", "Lcom/stripe/android/connections/analytics/ConnectionsEventReporter;", "(Ljava/lang/String;Lcom/stripe/android/connections/ConnectionsSheetContract$Args;Lcom/stripe/android/connections/domain/GenerateLinkAccountSessionManifest;Lcom/stripe/android/connections/domain/FetchLinkAccountSession;Landroidx/lifecycle/SavedStateHandle;Lcom/stripe/android/connections/analytics/ConnectionsEventReporter;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/stripe/android/connections/ConnectionsSheetState;", "_viewEffect", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/stripe/android/connections/ConnectionsSheetViewEffect;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState$connections_release", "()Lkotlinx/coroutines/flow/StateFlow;", "viewEffect", "Lkotlinx/coroutines/flow/SharedFlow;", "getViewEffect$connections_release", "()Lkotlinx/coroutines/flow/SharedFlow;", "", "fetchManifest", "handleOnNewIntent", "intent", "Landroid/content/Intent;", "handleOnNewIntent$connections_release", "onActivityRecreated", "onActivityRecreated$connections_release", "onActivityResult", "onActivityResult$connections_release", "onFatal", "throwable", "", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onResume", "onResume$connections_release", "onUserCancel", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openAuthFlow", "manifest", "Lcom/stripe/android/connections/model/LinkAccountSessionManifest;", "(Lcom/stripe/android/connections/model/LinkAccountSessionManifest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAndPersist", "function", "Lkotlin/Function1;", "Companion", "Factory", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectionsSheetViewModel.kt */
public final class ConnectionsSheetViewModel extends ViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_ACCOUNTS = 100;
    /* access modifiers changed from: private */
    public final MutableStateFlow<ConnectionsSheetState> _state;
    /* access modifiers changed from: private */
    public final MutableSharedFlow<ConnectionsSheetViewEffect> _viewEffect;
    /* access modifiers changed from: private */
    public final String applicationId;
    /* access modifiers changed from: private */
    public final ConnectionsEventReporter eventReporter;
    /* access modifiers changed from: private */
    public final FetchLinkAccountSession fetchLinkAccountSession;
    /* access modifiers changed from: private */
    public final GenerateLinkAccountSessionManifest generateLinkAccountSessionManifest;
    private final SavedStateHandle savedStateHandle;
    /* access modifiers changed from: private */
    public final ConnectionsSheetContract.Args starterArgs;
    private final StateFlow<ConnectionsSheetState> state;
    private final SharedFlow<ConnectionsSheetViewEffect> viewEffect;

    @Inject
    public ConnectionsSheetViewModel(@Named("applicationId") String str, ConnectionsSheetContract.Args args, GenerateLinkAccountSessionManifest generateLinkAccountSessionManifest2, FetchLinkAccountSession fetchLinkAccountSession2, SavedStateHandle savedStateHandle2, ConnectionsEventReporter connectionsEventReporter) {
        Intrinsics.checkNotNullParameter(str, NamedConstantsKt.APPLICATION_ID);
        Intrinsics.checkNotNullParameter(args, "starterArgs");
        Intrinsics.checkNotNullParameter(generateLinkAccountSessionManifest2, "generateLinkAccountSessionManifest");
        Intrinsics.checkNotNullParameter(fetchLinkAccountSession2, "fetchLinkAccountSession");
        Intrinsics.checkNotNullParameter(savedStateHandle2, "savedStateHandle");
        Intrinsics.checkNotNullParameter(connectionsEventReporter, "eventReporter");
        this.applicationId = str;
        this.starterArgs = args;
        this.generateLinkAccountSessionManifest = generateLinkAccountSessionManifest2;
        this.fetchLinkAccountSession = fetchLinkAccountSession2;
        this.savedStateHandle = savedStateHandle2;
        this.eventReporter = connectionsEventReporter;
        MutableStateFlow<ConnectionsSheetState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ConnectionsSheetState(false, (LinkAccountSessionManifest) null, false, 7, (DefaultConstructorMarker) null).from$connections_release(savedStateHandle2));
        this._state = MutableStateFlow;
        StateFlow<ConnectionsSheetState> stateFlow = MutableStateFlow;
        this.state = stateFlow;
        MutableSharedFlow<ConnectionsSheetViewEffect> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._viewEffect = MutableSharedFlow$default;
        this.viewEffect = MutableSharedFlow$default;
        connectionsEventReporter.onPresented(args.getConfiguration());
        if (stateFlow.getValue().getManifest() == null) {
            fetchManifest();
        }
    }

    public final StateFlow<ConnectionsSheetState> getState$connections_release() {
        return this.state;
    }

    public final SharedFlow<ConnectionsSheetViewEffect> getViewEffect$connections_release() {
        return this.viewEffect;
    }

    private final void fetchManifest() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConnectionsSheetViewModel$fetchManifest$1(this, (Continuation<? super ConnectionsSheetViewModel$fetchManifest$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object openAuthFlow(LinkAccountSessionManifest linkAccountSessionManifest, Continuation<? super Unit> continuation) {
        ConnectionsSheetState value;
        MutableStateFlow<ConnectionsSheetState> mutableStateFlow = this._state;
        ConnectionsSheetState value2 = mutableStateFlow.getValue();
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ConnectionsSheetState.copy$default(value, false, linkAccountSessionManifest, true, 1, (Object) null)));
        mutableStateFlow.getValue().to$connections_release(this.savedStateHandle, value2);
        Object emit = this._viewEffect.emit(new ConnectionsSheetViewEffect.OpenAuthFlowWithUrl(linkAccountSessionManifest.getHostedAuthUrl()), continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    public final void onActivityRecreated$connections_release() {
        ConnectionsSheetState value;
        MutableStateFlow<ConnectionsSheetState> mutableStateFlow = this._state;
        ConnectionsSheetState value2 = mutableStateFlow.getValue();
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ConnectionsSheetState.copy$default(value, true, (LinkAccountSessionManifest) null, false, 6, (Object) null)));
        mutableStateFlow.getValue().to$connections_release(this.savedStateHandle, value2);
    }

    public final void onResume$connections_release() {
        if (this._state.getValue().getAuthFlowActive() && !this._state.getValue().getActivityRecreated()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConnectionsSheetViewModel$onResume$1(this, (Continuation<? super ConnectionsSheetViewModel$onResume$1>) null), 3, (Object) null);
        }
    }

    public final void onActivityResult$connections_release() {
        if (this._state.getValue().getAuthFlowActive() && this._state.getValue().getActivityRecreated()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConnectionsSheetViewModel$onActivityResult$1(this, (Continuation<? super ConnectionsSheetViewModel$onActivityResult$1>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void fetchLinkAccountSession() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConnectionsSheetViewModel$fetchLinkAccountSession$1(this, (Continuation<? super ConnectionsSheetViewModel$fetchLinkAccountSession$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object onFatal(Throwable th, Continuation<? super Unit> continuation) {
        ConnectionsSheetResult failed = new ConnectionsSheetResult.Failed(th);
        this.eventReporter.onResult(this.starterArgs.getConfiguration(), failed);
        Object emit = this._viewEffect.emit(new ConnectionsSheetViewEffect.FinishWithResult(failed), continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object onUserCancel(Continuation<? super Unit> continuation) {
        ConnectionsSheetResult connectionsSheetResult = ConnectionsSheetResult.Canceled.INSTANCE;
        this.eventReporter.onResult(this.starterArgs.getConfiguration(), connectionsSheetResult);
        Object emit = this._viewEffect.emit(new ConnectionsSheetViewEffect.FinishWithResult(connectionsSheetResult), continuation);
        return emit == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emit : Unit.INSTANCE;
    }

    public final void handleOnNewIntent$connections_release(Intent intent) {
        ConnectionsSheetState value;
        MutableStateFlow<ConnectionsSheetState> mutableStateFlow = this._state;
        ConnectionsSheetState value2 = mutableStateFlow.getValue();
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, ConnectionsSheetState.copy$default(value, false, (LinkAccountSessionManifest) null, false, 3, (Object) null)));
        mutableStateFlow.getValue().to$connections_release(this.savedStateHandle, value2);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ConnectionsSheetViewModel$handleOnNewIntent$2(this, intent, (Continuation<? super ConnectionsSheetViewModel$handleOnNewIntent$2>) null), 3, (Object) null);
    }

    private final void updateAndPersist(MutableStateFlow<ConnectionsSheetState> mutableStateFlow, Function1<? super ConnectionsSheetState, ConnectionsSheetState> function1) {
        ConnectionsSheetState value;
        ConnectionsSheetState value2 = mutableStateFlow.getValue();
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, function1.invoke(value)));
        mutableStateFlow.getValue().to$connections_release(this.savedStateHandle, value2);
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B5\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ5\u0010\f\u001a\u0002H\r\"\b\b\u0000\u0010\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\r0\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0014¢\u0006\u0002\u0010\u0015R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/stripe/android/connections/ConnectionsSheetViewModel$Factory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "applicationSupplier", "Lkotlin/Function0;", "Landroid/app/Application;", "starterArgsSupplier", "Lcom/stripe/android/connections/ConnectionsSheetContract$Args;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "defaultArgs", "Landroid/os/Bundle;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/savedstate/SavedStateRegistryOwner;Landroid/os/Bundle;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "key", "", "modelClass", "Ljava/lang/Class;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConnectionsSheetViewModel.kt */
    public static final class Factory extends AbstractSavedStateViewModelFactory {
        private final Function0<Application> applicationSupplier;
        private final Function0<ConnectionsSheetContract.Args> starterArgsSupplier;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Factory(Function0 function0, Function0 function02, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(function0, function02, savedStateRegistryOwner, (i & 8) != 0 ? null : bundle);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Factory(Function0<? extends Application> function0, Function0<ConnectionsSheetContract.Args> function02, SavedStateRegistryOwner savedStateRegistryOwner, Bundle bundle) {
            super(savedStateRegistryOwner, bundle);
            Intrinsics.checkNotNullParameter(function0, "applicationSupplier");
            Intrinsics.checkNotNullParameter(function02, "starterArgsSupplier");
            Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "owner");
            this.applicationSupplier = function0;
            this.starterArgsSupplier = function02;
        }

        /* access modifiers changed from: protected */
        public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
            return DaggerConnectionsSheetComponent.builder().application(this.applicationSupplier.invoke()).savedStateHandle(savedStateHandle).configuration(this.starterArgsSupplier.invoke()).build().getViewModel();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/connections/ConnectionsSheetViewModel$Companion;", "", "()V", "MAX_ACCOUNTS", "", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConnectionsSheetViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
