package com.stripe.android.connections;

import androidx.activity.result.ActivityResultLauncher;
import com.stripe.android.connections.ConnectionsSheet;
import com.stripe.android.connections.ConnectionsSheetContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tB\u0013\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/connections/DefaultConnectionsSheetLauncher;", "Lcom/stripe/android/connections/ConnectionsSheetLauncher;", "activity", "Landroidx/activity/ComponentActivity;", "callback", "Lcom/stripe/android/connections/ConnectionsSheetResultCallback;", "(Landroidx/activity/ComponentActivity;Lcom/stripe/android/connections/ConnectionsSheetResultCallback;)V", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Lcom/stripe/android/connections/ConnectionsSheetResultCallback;)V", "activityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Lcom/stripe/android/connections/ConnectionsSheetContract$Args;", "(Landroidx/activity/result/ActivityResultLauncher;)V", "present", "", "configuration", "Lcom/stripe/android/connections/ConnectionsSheet$Configuration;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultConnectionsSheetLauncher.kt */
public final class DefaultConnectionsSheetLauncher implements ConnectionsSheetLauncher {
    private final ActivityResultLauncher<ConnectionsSheetContract.Args> activityResultLauncher;

    public DefaultConnectionsSheetLauncher(ActivityResultLauncher<ConnectionsSheetContract.Args> activityResultLauncher2) {
        Intrinsics.checkNotNullParameter(activityResultLauncher2, "activityResultLauncher");
        this.activityResultLauncher = activityResultLauncher2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DefaultConnectionsSheetLauncher(androidx.activity.ComponentActivity r3, com.stripe.android.connections.ConnectionsSheetResultCallback r4) {
        /*
            r2 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "callback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            com.stripe.android.connections.ConnectionsSheetContract r0 = new com.stripe.android.connections.ConnectionsSheetContract
            r0.<init>()
            androidx.activity.result.contract.ActivityResultContract r0 = (androidx.activity.result.contract.ActivityResultContract) r0
            com.stripe.android.connections.-$$Lambda$DefaultConnectionsSheetLauncher$gM2cVfpooXeJVBsLsplIliM8KZo r1 = new com.stripe.android.connections.-$$Lambda$DefaultConnectionsSheetLauncher$gM2cVfpooXeJVBsLsplIliM8KZo
            r1.<init>()
            androidx.activity.result.ActivityResultLauncher r3 = r3.registerForActivityResult(r0, r1)
            java.lang.String r4 = "activity.registerForActi…SheetResult(it)\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r2.<init>(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.connections.DefaultConnectionsSheetLauncher.<init>(androidx.activity.ComponentActivity, com.stripe.android.connections.ConnectionsSheetResultCallback):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m4286_init_$lambda0(ConnectionsSheetResultCallback connectionsSheetResultCallback, ConnectionsSheetResult connectionsSheetResult) {
        Intrinsics.checkNotNullParameter(connectionsSheetResultCallback, "$callback");
        Intrinsics.checkNotNullExpressionValue(connectionsSheetResult, "it");
        connectionsSheetResultCallback.onConnectionsSheetResult(connectionsSheetResult);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DefaultConnectionsSheetLauncher(androidx.fragment.app.Fragment r3, com.stripe.android.connections.ConnectionsSheetResultCallback r4) {
        /*
            r2 = this;
            java.lang.String r0 = "fragment"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "callback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            com.stripe.android.connections.ConnectionsSheetContract r0 = new com.stripe.android.connections.ConnectionsSheetContract
            r0.<init>()
            androidx.activity.result.contract.ActivityResultContract r0 = (androidx.activity.result.contract.ActivityResultContract) r0
            com.stripe.android.connections.-$$Lambda$DefaultConnectionsSheetLauncher$fRn0lGRoLZUxoUhbas13dnPhgCA r1 = new com.stripe.android.connections.-$$Lambda$DefaultConnectionsSheetLauncher$fRn0lGRoLZUxoUhbas13dnPhgCA
            r1.<init>()
            androidx.activity.result.ActivityResultLauncher r3 = r3.registerForActivityResult(r0, r1)
            java.lang.String r4 = "fragment.registerForActi…SheetResult(it)\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r2.<init>(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.connections.DefaultConnectionsSheetLauncher.<init>(androidx.fragment.app.Fragment, com.stripe.android.connections.ConnectionsSheetResultCallback):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m4287_init_$lambda1(ConnectionsSheetResultCallback connectionsSheetResultCallback, ConnectionsSheetResult connectionsSheetResult) {
        Intrinsics.checkNotNullParameter(connectionsSheetResultCallback, "$callback");
        Intrinsics.checkNotNullExpressionValue(connectionsSheetResult, "it");
        connectionsSheetResultCallback.onConnectionsSheetResult(connectionsSheetResult);
    }

    public void present(ConnectionsSheet.Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.activityResultLauncher.launch(new ConnectionsSheetContract.Args(configuration));
    }
}
