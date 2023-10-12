package com.stripe.android.connections;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.os.BundleKt;
import com.braintreepayments.api.internal.GraphQLConstants;
import com.stripe.android.connections.ConnectionsSheet;
import com.stripe.android.connections.ConnectionsSheetResult;
import java.security.InvalidParameterException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u0000 \u000f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000e\u000f\u0010B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/connections/ConnectionsSheetContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "Lcom/stripe/android/connections/ConnectionsSheetContract$Args;", "Lcom/stripe/android/connections/ConnectionsSheetResult;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Args", "Companion", "Result", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectionsSheetContract.kt */
public final class ConnectionsSheetContract extends ActivityResultContract<Args, ConnectionsSheetResult> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_ARGS = "com.stripe.android.connections.ConnectionsSheetContract.extra_args";
    private static final String EXTRA_RESULT = "com.stripe.android.connections.ConnectionsSheetContract.extra_result";

    public Intent createIntent(Context context, Args args) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(args, GraphQLConstants.Keys.INPUT);
        Intent putExtra = new Intent(context, ConnectionsSheetActivity.class).putExtra(EXTRA_ARGS, args);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(context, Connecti…tExtra(EXTRA_ARGS, input)");
        return putExtra;
    }

    public ConnectionsSheetResult parseResult(int i, Intent intent) {
        Result result;
        ConnectionsSheetResult connectionsSheetResult = null;
        if (!(intent == null || (result = (Result) intent.getParcelableExtra(EXTRA_RESULT)) == null)) {
            connectionsSheetResult = result.getConnectionsSheetResult();
        }
        return connectionsSheetResult == null ? new ConnectionsSheetResult.Failed(new IllegalArgumentException("Failed to retrieve a ConnectionsSheetResult.")) : connectionsSheetResult;
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0006\u0010\u0012\u001a\u00020\u0013J\u0019\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/stripe/android/connections/ConnectionsSheetContract$Args;", "Landroid/os/Parcelable;", "configuration", "Lcom/stripe/android/connections/ConnectionsSheet$Configuration;", "(Lcom/stripe/android/connections/ConnectionsSheet$Configuration;)V", "getConfiguration", "()Lcom/stripe/android/connections/ConnectionsSheet$Configuration;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "validate", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConnectionsSheetContract.kt */
    public static final class Args implements Parcelable {
        public static final Parcelable.Creator<Args> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final ConnectionsSheet.Configuration configuration;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ConnectionsSheetContract.kt */
        public static final class Creator implements Parcelable.Creator<Args> {
            public final Args createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Args(ConnectionsSheet.Configuration.CREATOR.createFromParcel(parcel));
            }

            public final Args[] newArray(int i) {
                return new Args[i];
            }
        }

        public static /* synthetic */ Args copy$default(Args args, ConnectionsSheet.Configuration configuration2, int i, Object obj) {
            if ((i & 1) != 0) {
                configuration2 = args.configuration;
            }
            return args.copy(configuration2);
        }

        public final ConnectionsSheet.Configuration component1() {
            return this.configuration;
        }

        public final Args copy(ConnectionsSheet.Configuration configuration2) {
            Intrinsics.checkNotNullParameter(configuration2, "configuration");
            return new Args(configuration2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Args) && Intrinsics.areEqual((Object) this.configuration, (Object) ((Args) obj).configuration);
        }

        public int hashCode() {
            return this.configuration.hashCode();
        }

        public String toString() {
            return "Args(configuration=" + this.configuration + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            this.configuration.writeToParcel(parcel, i);
        }

        public Args(ConnectionsSheet.Configuration configuration2) {
            Intrinsics.checkNotNullParameter(configuration2, "configuration");
            this.configuration = configuration2;
        }

        public final ConnectionsSheet.Configuration getConfiguration() {
            return this.configuration;
        }

        public final void validate() {
            if (StringsKt.isBlank(this.configuration.getLinkAccountSessionClientSecret())) {
                throw new InvalidParameterException("The link account session client secret cannot be an empty string.");
            } else if (StringsKt.isBlank(this.configuration.getPublishableKey())) {
                throw new InvalidParameterException("The publishable key cannot be an empty string.");
            }
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/connections/ConnectionsSheetContract$Args$Companion;", "", "()V", "fromIntent", "Lcom/stripe/android/connections/ConnectionsSheetContract$Args;", "intent", "Landroid/content/Intent;", "fromIntent$connections_release", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ConnectionsSheetContract.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Args fromIntent$connections_release(Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                return (Args) intent.getParcelableExtra(ConnectionsSheetContract.EXTRA_ARGS);
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/stripe/android/connections/ConnectionsSheetContract$Result;", "Landroid/os/Parcelable;", "connectionsSheetResult", "Lcom/stripe/android/connections/ConnectionsSheetResult;", "(Lcom/stripe/android/connections/ConnectionsSheetResult;)V", "getConnectionsSheetResult", "()Lcom/stripe/android/connections/ConnectionsSheetResult;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toBundle", "Landroid/os/Bundle;", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConnectionsSheetContract.kt */
    public static final class Result implements Parcelable {
        public static final Parcelable.Creator<Result> CREATOR = new Creator();
        private final ConnectionsSheetResult connectionsSheetResult;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ConnectionsSheetContract.kt */
        public static final class Creator implements Parcelable.Creator<Result> {
            public final Result createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Result((ConnectionsSheetResult) parcel.readParcelable(Result.class.getClassLoader()));
            }

            public final Result[] newArray(int i) {
                return new Result[i];
            }
        }

        public static /* synthetic */ Result copy$default(Result result, ConnectionsSheetResult connectionsSheetResult2, int i, Object obj) {
            if ((i & 1) != 0) {
                connectionsSheetResult2 = result.connectionsSheetResult;
            }
            return result.copy(connectionsSheetResult2);
        }

        public final ConnectionsSheetResult component1() {
            return this.connectionsSheetResult;
        }

        public final Result copy(ConnectionsSheetResult connectionsSheetResult2) {
            Intrinsics.checkNotNullParameter(connectionsSheetResult2, "connectionsSheetResult");
            return new Result(connectionsSheetResult2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Result) && Intrinsics.areEqual((Object) this.connectionsSheetResult, (Object) ((Result) obj).connectionsSheetResult);
        }

        public int hashCode() {
            return this.connectionsSheetResult.hashCode();
        }

        public String toString() {
            return "Result(connectionsSheetResult=" + this.connectionsSheetResult + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeParcelable(this.connectionsSheetResult, i);
        }

        public Result(ConnectionsSheetResult connectionsSheetResult2) {
            Intrinsics.checkNotNullParameter(connectionsSheetResult2, "connectionsSheetResult");
            this.connectionsSheetResult = connectionsSheetResult2;
        }

        public final ConnectionsSheetResult getConnectionsSheetResult() {
            return this.connectionsSheetResult;
        }

        public final Bundle toBundle() {
            return BundleKt.bundleOf(TuplesKt.to(ConnectionsSheetContract.EXTRA_RESULT, this));
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/connections/ConnectionsSheetContract$Companion;", "", "()V", "EXTRA_ARGS", "", "EXTRA_RESULT", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConnectionsSheetContract.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
