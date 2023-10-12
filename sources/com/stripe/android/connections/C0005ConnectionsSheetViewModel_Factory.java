package com.stripe.android.connections;

import androidx.lifecycle.SavedStateHandle;
import com.stripe.android.connections.ConnectionsSheetContract;
import com.stripe.android.connections.analytics.ConnectionsEventReporter;
import com.stripe.android.connections.domain.FetchLinkAccountSession;
import com.stripe.android.connections.domain.GenerateLinkAccountSessionManifest;
import dagger.internal.Factory;
import javax.inject.Provider;

/* renamed from: com.stripe.android.connections.ConnectionsSheetViewModel_Factory  reason: case insensitive filesystem */
public final class C0005ConnectionsSheetViewModel_Factory implements Factory<ConnectionsSheetViewModel> {
    private final Provider<String> applicationIdProvider;
    private final Provider<ConnectionsEventReporter> eventReporterProvider;
    private final Provider<FetchLinkAccountSession> fetchLinkAccountSessionProvider;
    private final Provider<GenerateLinkAccountSessionManifest> generateLinkAccountSessionManifestProvider;
    private final Provider<SavedStateHandle> savedStateHandleProvider;
    private final Provider<ConnectionsSheetContract.Args> starterArgsProvider;

    public C0005ConnectionsSheetViewModel_Factory(Provider<String> provider, Provider<ConnectionsSheetContract.Args> provider2, Provider<GenerateLinkAccountSessionManifest> provider3, Provider<FetchLinkAccountSession> provider4, Provider<SavedStateHandle> provider5, Provider<ConnectionsEventReporter> provider6) {
        this.applicationIdProvider = provider;
        this.starterArgsProvider = provider2;
        this.generateLinkAccountSessionManifestProvider = provider3;
        this.fetchLinkAccountSessionProvider = provider4;
        this.savedStateHandleProvider = provider5;
        this.eventReporterProvider = provider6;
    }

    public ConnectionsSheetViewModel get() {
        return newInstance(this.applicationIdProvider.get(), this.starterArgsProvider.get(), this.generateLinkAccountSessionManifestProvider.get(), this.fetchLinkAccountSessionProvider.get(), this.savedStateHandleProvider.get(), this.eventReporterProvider.get());
    }

    public static C0005ConnectionsSheetViewModel_Factory create(Provider<String> provider, Provider<ConnectionsSheetContract.Args> provider2, Provider<GenerateLinkAccountSessionManifest> provider3, Provider<FetchLinkAccountSession> provider4, Provider<SavedStateHandle> provider5, Provider<ConnectionsEventReporter> provider6) {
        return new C0005ConnectionsSheetViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ConnectionsSheetViewModel newInstance(String str, ConnectionsSheetContract.Args args, GenerateLinkAccountSessionManifest generateLinkAccountSessionManifest, FetchLinkAccountSession fetchLinkAccountSession, SavedStateHandle savedStateHandle, ConnectionsEventReporter connectionsEventReporter) {
        return new ConnectionsSheetViewModel(str, args, generateLinkAccountSessionManifest, fetchLinkAccountSession, savedStateHandle, connectionsEventReporter);
    }
}
