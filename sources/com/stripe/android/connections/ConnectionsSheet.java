package com.stripe.android.connections;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/connections/ConnectionsSheet;", "", "connectionsSheetLauncher", "Lcom/stripe/android/connections/ConnectionsSheetLauncher;", "(Lcom/stripe/android/connections/ConnectionsSheetLauncher;)V", "present", "", "configuration", "Lcom/stripe/android/connections/ConnectionsSheet$Configuration;", "Companion", "Configuration", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectionsSheet.kt */
public final class ConnectionsSheet {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final ConnectionsSheetLauncher connectionsSheetLauncher;

    public /* synthetic */ ConnectionsSheet(ConnectionsSheetLauncher connectionsSheetLauncher2, DefaultConstructorMarker defaultConstructorMarker) {
        this(connectionsSheetLauncher2);
    }

    private ConnectionsSheet(ConnectionsSheetLauncher connectionsSheetLauncher2) {
        this.connectionsSheetLauncher = connectionsSheetLauncher2;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/stripe/android/connections/ConnectionsSheet$Configuration;", "Landroid/os/Parcelable;", "linkAccountSessionClientSecret", "", "publishableKey", "(Ljava/lang/String;Ljava/lang/String;)V", "getLinkAccountSessionClientSecret", "()Ljava/lang/String;", "getPublishableKey", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConnectionsSheet.kt */
    public static final class Configuration implements Parcelable {
        public static final Parcelable.Creator<Configuration> CREATOR = new Creator();
        private final String linkAccountSessionClientSecret;
        private final String publishableKey;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ConnectionsSheet.kt */
        public static final class Creator implements Parcelable.Creator<Configuration> {
            public final Configuration createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Configuration(parcel.readString(), parcel.readString());
            }

            public final Configuration[] newArray(int i) {
                return new Configuration[i];
            }
        }

        public static /* synthetic */ Configuration copy$default(Configuration configuration, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = configuration.linkAccountSessionClientSecret;
            }
            if ((i & 2) != 0) {
                str2 = configuration.publishableKey;
            }
            return configuration.copy(str, str2);
        }

        public final String component1() {
            return this.linkAccountSessionClientSecret;
        }

        public final String component2() {
            return this.publishableKey;
        }

        public final Configuration copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "linkAccountSessionClientSecret");
            Intrinsics.checkNotNullParameter(str2, "publishableKey");
            return new Configuration(str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Configuration)) {
                return false;
            }
            Configuration configuration = (Configuration) obj;
            return Intrinsics.areEqual((Object) this.linkAccountSessionClientSecret, (Object) configuration.linkAccountSessionClientSecret) && Intrinsics.areEqual((Object) this.publishableKey, (Object) configuration.publishableKey);
        }

        public int hashCode() {
            return (this.linkAccountSessionClientSecret.hashCode() * 31) + this.publishableKey.hashCode();
        }

        public String toString() {
            return "Configuration(linkAccountSessionClientSecret=" + this.linkAccountSessionClientSecret + ", publishableKey=" + this.publishableKey + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.linkAccountSessionClientSecret);
            parcel.writeString(this.publishableKey);
        }

        public Configuration(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "linkAccountSessionClientSecret");
            Intrinsics.checkNotNullParameter(str2, "publishableKey");
            this.linkAccountSessionClientSecret = str;
            this.publishableKey = str2;
        }

        public final String getLinkAccountSessionClientSecret() {
            return this.linkAccountSessionClientSecret;
        }

        public final String getPublishableKey() {
            return this.publishableKey;
        }
    }

    public final void present(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.connectionsSheetLauncher.present(configuration);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/connections/ConnectionsSheet$Companion;", "", "()V", "create", "Lcom/stripe/android/connections/ConnectionsSheet;", "activity", "Landroidx/activity/ComponentActivity;", "callback", "Lcom/stripe/android/connections/ConnectionsSheetResultCallback;", "fragment", "Landroidx/fragment/app/Fragment;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConnectionsSheet.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ConnectionsSheet create(ComponentActivity componentActivity, ConnectionsSheetResultCallback connectionsSheetResultCallback) {
            Intrinsics.checkNotNullParameter(componentActivity, "activity");
            Intrinsics.checkNotNullParameter(connectionsSheetResultCallback, "callback");
            return new ConnectionsSheet(new DefaultConnectionsSheetLauncher(componentActivity, connectionsSheetResultCallback), (DefaultConstructorMarker) null);
        }

        public final ConnectionsSheet create(Fragment fragment, ConnectionsSheetResultCallback connectionsSheetResultCallback) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(connectionsSheetResultCallback, "callback");
            return new ConnectionsSheet(new DefaultConnectionsSheetLauncher(fragment, connectionsSheetResultCallback), (DefaultConstructorMarker) null);
        }
    }
}
