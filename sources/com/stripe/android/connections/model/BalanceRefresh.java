package com.stripe.android.connections.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0003)*+B/\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0019\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\u001f\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J!\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÇ\u0001J\u0019\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012¨\u0006,"}, d2 = {"Lcom/stripe/android/connections/model/BalanceRefresh;", "Lcom/stripe/android/core/model/StripeModel;", "Landroid/os/Parcelable;", "seen1", "", "status", "Lcom/stripe/android/connections/model/BalanceRefresh$BalanceRefreshStatus;", "lastAttemptedAt", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/stripe/android/connections/model/BalanceRefresh$BalanceRefreshStatus;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/stripe/android/connections/model/BalanceRefresh$BalanceRefreshStatus;I)V", "getLastAttemptedAt$annotations", "()V", "getLastAttemptedAt", "()I", "getStatus$annotations", "getStatus", "()Lcom/stripe/android/connections/model/BalanceRefresh$BalanceRefreshStatus;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "$serializer", "BalanceRefreshStatus", "Companion", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
/* compiled from: BalanceRefresh.kt */
public final class BalanceRefresh implements StripeModel, Parcelable {
    public static final Parcelable.Creator<BalanceRefresh> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int lastAttemptedAt;
    private final BalanceRefreshStatus status;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BalanceRefresh.kt */
    public static final class Creator implements Parcelable.Creator<BalanceRefresh> {
        public final BalanceRefresh createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BalanceRefresh(parcel.readInt() == 0 ? null : BalanceRefreshStatus.valueOf(parcel.readString()), parcel.readInt());
        }

        public final BalanceRefresh[] newArray(int i) {
            return new BalanceRefresh[i];
        }
    }

    public static /* synthetic */ BalanceRefresh copy$default(BalanceRefresh balanceRefresh, BalanceRefreshStatus balanceRefreshStatus, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            balanceRefreshStatus = balanceRefresh.status;
        }
        if ((i2 & 2) != 0) {
            i = balanceRefresh.lastAttemptedAt;
        }
        return balanceRefresh.copy(balanceRefreshStatus, i);
    }

    @SerialName("last_attempted_at")
    public static /* synthetic */ void getLastAttemptedAt$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getStatus$annotations() {
    }

    public final BalanceRefreshStatus component1() {
        return this.status;
    }

    public final int component2() {
        return this.lastAttemptedAt;
    }

    public final BalanceRefresh copy(BalanceRefreshStatus balanceRefreshStatus, int i) {
        return new BalanceRefresh(balanceRefreshStatus, i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BalanceRefresh)) {
            return false;
        }
        BalanceRefresh balanceRefresh = (BalanceRefresh) obj;
        return this.status == balanceRefresh.status && this.lastAttemptedAt == balanceRefresh.lastAttemptedAt;
    }

    public int hashCode() {
        BalanceRefreshStatus balanceRefreshStatus = this.status;
        return ((balanceRefreshStatus == null ? 0 : balanceRefreshStatus.hashCode()) * 31) + this.lastAttemptedAt;
    }

    public String toString() {
        return "BalanceRefresh(status=" + this.status + ", lastAttemptedAt=" + this.lastAttemptedAt + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        BalanceRefreshStatus balanceRefreshStatus = this.status;
        if (balanceRefreshStatus == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(balanceRefreshStatus.name());
        }
        parcel.writeInt(this.lastAttemptedAt);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/connections/model/BalanceRefresh$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stripe/android/connections/model/BalanceRefresh;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BalanceRefresh.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<BalanceRefresh> serializer() {
            return BalanceRefresh$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ BalanceRefresh(int i, @SerialName("status") BalanceRefreshStatus balanceRefreshStatus, @SerialName("last_attempted_at") int i2, SerializationConstructorMarker serializationConstructorMarker) {
        if (2 != (i & 2)) {
            PluginExceptionsKt.throwMissingFieldException(i, 2, BalanceRefresh$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.status = BalanceRefreshStatus.UNKNOWN;
        } else {
            this.status = balanceRefreshStatus;
        }
        this.lastAttemptedAt = i2;
    }

    public BalanceRefresh(BalanceRefreshStatus balanceRefreshStatus, int i) {
        this.status = balanceRefreshStatus;
        this.lastAttemptedAt = i;
    }

    @JvmStatic
    public static final void write$Self(BalanceRefresh balanceRefresh, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        Intrinsics.checkNotNullParameter(balanceRefresh, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) && balanceRefresh.status == BalanceRefreshStatus.UNKNOWN) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, BalanceRefresh$BalanceRefreshStatus$$serializer.INSTANCE, balanceRefresh.status);
        }
        compositeEncoder.encodeIntElement(serialDescriptor, 1, balanceRefresh.lastAttemptedAt);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BalanceRefresh(BalanceRefreshStatus balanceRefreshStatus, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? BalanceRefreshStatus.UNKNOWN : balanceRefreshStatus, i);
    }

    public final BalanceRefreshStatus getStatus() {
        return this.status;
    }

    public final int getLastAttemptedAt() {
        return this.lastAttemptedAt;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u000b\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\r"}, d2 = {"Lcom/stripe/android/connections/model/BalanceRefresh$BalanceRefreshStatus;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode$connections_release", "()Ljava/lang/String;", "FAILED", "PENDING", "SUCCEEDED", "UNKNOWN", "$serializer", "Companion", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Serializable
    /* compiled from: BalanceRefresh.kt */
    public enum BalanceRefreshStatus {
        FAILED("failed"),
        PENDING("pending"),
        SUCCEEDED("succeeded"),
        UNKNOWN("unknown");
        
        public static final Companion Companion = null;
        private final String code;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/connections/model/BalanceRefresh$BalanceRefreshStatus$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stripe/android/connections/model/BalanceRefresh$BalanceRefreshStatus;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: BalanceRefresh.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<BalanceRefreshStatus> serializer() {
                return BalanceRefresh$BalanceRefreshStatus$$serializer.INSTANCE;
            }
        }

        private BalanceRefreshStatus(String str) {
            this.code = str;
        }

        public final String getCode$connections_release() {
            return this.code;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }
    }
}
