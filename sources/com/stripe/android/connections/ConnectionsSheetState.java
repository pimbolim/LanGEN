package com.stripe.android.connections;

import androidx.lifecycle.SavedStateHandle;
import com.stripe.android.connections.model.LinkAccountSessionManifest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u001d\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0000H\u0000¢\u0006\u0002\b\u001cJ\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lcom/stripe/android/connections/ConnectionsSheetState;", "", "activityRecreated", "", "manifest", "Lcom/stripe/android/connections/model/LinkAccountSessionManifest;", "authFlowActive", "(ZLcom/stripe/android/connections/model/LinkAccountSessionManifest;Z)V", "getActivityRecreated", "()Z", "getAuthFlowActive", "getManifest", "()Lcom/stripe/android/connections/model/LinkAccountSessionManifest;", "component1", "component2", "component3", "copy", "equals", "other", "from", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "from$connections_release", "hashCode", "", "to", "", "previousValue", "to$connections_release", "toString", "", "Companion", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectionsSheetState.kt */
public final class ConnectionsSheetState {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_AUTHFLOW_ACTIVE = "key_authflow_active";
    private static final String KEY_MANIFEST = "key_manifest";
    private final boolean activityRecreated;
    private final boolean authFlowActive;
    private final LinkAccountSessionManifest manifest;

    public ConnectionsSheetState() {
        this(false, (LinkAccountSessionManifest) null, false, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ConnectionsSheetState copy$default(ConnectionsSheetState connectionsSheetState, boolean z, LinkAccountSessionManifest linkAccountSessionManifest, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = connectionsSheetState.activityRecreated;
        }
        if ((i & 2) != 0) {
            linkAccountSessionManifest = connectionsSheetState.manifest;
        }
        if ((i & 4) != 0) {
            z2 = connectionsSheetState.authFlowActive;
        }
        return connectionsSheetState.copy(z, linkAccountSessionManifest, z2);
    }

    public final boolean component1() {
        return this.activityRecreated;
    }

    public final LinkAccountSessionManifest component2() {
        return this.manifest;
    }

    public final boolean component3() {
        return this.authFlowActive;
    }

    public final ConnectionsSheetState copy(boolean z, LinkAccountSessionManifest linkAccountSessionManifest, boolean z2) {
        return new ConnectionsSheetState(z, linkAccountSessionManifest, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConnectionsSheetState)) {
            return false;
        }
        ConnectionsSheetState connectionsSheetState = (ConnectionsSheetState) obj;
        return this.activityRecreated == connectionsSheetState.activityRecreated && Intrinsics.areEqual((Object) this.manifest, (Object) connectionsSheetState.manifest) && this.authFlowActive == connectionsSheetState.authFlowActive;
    }

    public int hashCode() {
        boolean z = this.activityRecreated;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        LinkAccountSessionManifest linkAccountSessionManifest = this.manifest;
        int hashCode = (i + (linkAccountSessionManifest == null ? 0 : linkAccountSessionManifest.hashCode())) * 31;
        boolean z3 = this.authFlowActive;
        if (!z3) {
            z2 = z3;
        }
        return hashCode + (z2 ? 1 : 0);
    }

    public String toString() {
        return "ConnectionsSheetState(activityRecreated=" + this.activityRecreated + ", manifest=" + this.manifest + ", authFlowActive=" + this.authFlowActive + ')';
    }

    public ConnectionsSheetState(boolean z, LinkAccountSessionManifest linkAccountSessionManifest, boolean z2) {
        this.activityRecreated = z;
        this.manifest = linkAccountSessionManifest;
        this.authFlowActive = z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConnectionsSheetState(boolean z, LinkAccountSessionManifest linkAccountSessionManifest, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : linkAccountSessionManifest, (i & 4) != 0 ? false : z2);
    }

    public final boolean getActivityRecreated() {
        return this.activityRecreated;
    }

    public final LinkAccountSessionManifest getManifest() {
        return this.manifest;
    }

    public final boolean getAuthFlowActive() {
        return this.authFlowActive;
    }

    public final ConnectionsSheetState from$connections_release(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        LinkAccountSessionManifest linkAccountSessionManifest = (LinkAccountSessionManifest) savedStateHandle.get(KEY_MANIFEST);
        if (linkAccountSessionManifest == null) {
            linkAccountSessionManifest = this.manifest;
        }
        LinkAccountSessionManifest linkAccountSessionManifest2 = linkAccountSessionManifest;
        Boolean bool = (Boolean) savedStateHandle.get(KEY_AUTHFLOW_ACTIVE);
        return copy$default(this, false, linkAccountSessionManifest2, bool == null ? this.authFlowActive : bool.booleanValue(), 1, (Object) null);
    }

    public final void to$connections_release(SavedStateHandle savedStateHandle, ConnectionsSheetState connectionsSheetState) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "savedStateHandle");
        Intrinsics.checkNotNullParameter(connectionsSheetState, "previousValue");
        if (!Intrinsics.areEqual((Object) connectionsSheetState.manifest, (Object) this.manifest)) {
            savedStateHandle.set(KEY_MANIFEST, this.manifest);
        }
        boolean z = connectionsSheetState.authFlowActive;
        boolean z2 = this.authFlowActive;
        if (z != z2) {
            savedStateHandle.set(KEY_AUTHFLOW_ACTIVE, Boolean.valueOf(z2));
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/connections/ConnectionsSheetState$Companion;", "", "()V", "KEY_AUTHFLOW_ACTIVE", "", "KEY_MANIFEST", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConnectionsSheetState.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
