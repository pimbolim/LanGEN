package com.stripe.android.connections.analytics;

import com.stripe.android.connections.ConnectionsSheet;
import com.stripe.android.connections.ConnectionsSheetResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/stripe/android/connections/analytics/ConnectionsEventReporter;", "", "onPresented", "", "configuration", "Lcom/stripe/android/connections/ConnectionsSheet$Configuration;", "onResult", "connectionsSheetResult", "Lcom/stripe/android/connections/ConnectionsSheetResult;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectionsEventReporter.kt */
public interface ConnectionsEventReporter {
    void onPresented(ConnectionsSheet.Configuration configuration);

    void onResult(ConnectionsSheet.Configuration configuration, ConnectionsSheetResult connectionsSheetResult);
}
