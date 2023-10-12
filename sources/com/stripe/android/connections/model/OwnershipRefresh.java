package com.stripe.android.connections.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
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

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0003)*+B/\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nB\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J!\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$HÇ\u0001J\u0019\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0012¨\u0006,"}, d2 = {"Lcom/stripe/android/connections/model/OwnershipRefresh;", "Landroid/os/Parcelable;", "Lcom/stripe/android/core/model/StripeModel;", "seen1", "", "lastAttemptedAt", "status", "Lcom/stripe/android/connections/model/OwnershipRefresh$Status;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILcom/stripe/android/connections/model/OwnershipRefresh$Status;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ILcom/stripe/android/connections/model/OwnershipRefresh$Status;)V", "getLastAttemptedAt$annotations", "()V", "getLastAttemptedAt", "()I", "getStatus$annotations", "getStatus", "()Lcom/stripe/android/connections/model/OwnershipRefresh$Status;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "$serializer", "Companion", "Status", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
/* compiled from: OwnershipRefresh.kt */
public final class OwnershipRefresh implements Parcelable, StripeModel {
    public static final Parcelable.Creator<OwnershipRefresh> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int lastAttemptedAt;
    private final Status status;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OwnershipRefresh.kt */
    public static final class Creator implements Parcelable.Creator<OwnershipRefresh> {
        public final OwnershipRefresh createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new OwnershipRefresh(parcel.readInt(), Status.valueOf(parcel.readString()));
        }

        public final OwnershipRefresh[] newArray(int i) {
            return new OwnershipRefresh[i];
        }
    }

    public static /* synthetic */ OwnershipRefresh copy$default(OwnershipRefresh ownershipRefresh, int i, Status status2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = ownershipRefresh.lastAttemptedAt;
        }
        if ((i2 & 2) != 0) {
            status2 = ownershipRefresh.status;
        }
        return ownershipRefresh.copy(i, status2);
    }

    @SerialName("last_attempted_at")
    public static /* synthetic */ void getLastAttemptedAt$annotations() {
    }

    @SerialName("status")
    public static /* synthetic */ void getStatus$annotations() {
    }

    public final int component1() {
        return this.lastAttemptedAt;
    }

    public final Status component2() {
        return this.status;
    }

    public final OwnershipRefresh copy(int i, Status status2) {
        Intrinsics.checkNotNullParameter(status2, NotificationCompat.CATEGORY_STATUS);
        return new OwnershipRefresh(i, status2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OwnershipRefresh)) {
            return false;
        }
        OwnershipRefresh ownershipRefresh = (OwnershipRefresh) obj;
        return this.lastAttemptedAt == ownershipRefresh.lastAttemptedAt && this.status == ownershipRefresh.status;
    }

    public int hashCode() {
        return (this.lastAttemptedAt * 31) + this.status.hashCode();
    }

    public String toString() {
        return "OwnershipRefresh(lastAttemptedAt=" + this.lastAttemptedAt + ", status=" + this.status + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.lastAttemptedAt);
        parcel.writeString(this.status.name());
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/connections/model/OwnershipRefresh$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stripe/android/connections/model/OwnershipRefresh;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OwnershipRefresh.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<OwnershipRefresh> serializer() {
            return OwnershipRefresh$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ OwnershipRefresh(int i, @SerialName("last_attempted_at") int i2, @SerialName("status") Status status2, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, OwnershipRefresh$$serializer.INSTANCE.getDescriptor());
        }
        this.lastAttemptedAt = i2;
        if ((i & 2) == 0) {
            this.status = Status.UNKNOWN;
        } else {
            this.status = status2;
        }
    }

    public OwnershipRefresh(int i, Status status2) {
        Intrinsics.checkNotNullParameter(status2, NotificationCompat.CATEGORY_STATUS);
        this.lastAttemptedAt = i;
        this.status = status2;
    }

    @JvmStatic
    public static final void write$Self(OwnershipRefresh ownershipRefresh, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(ownershipRefresh, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        boolean z = false;
        compositeEncoder.encodeIntElement(serialDescriptor, 0, ownershipRefresh.lastAttemptedAt);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || ownershipRefresh.status != Status.UNKNOWN) {
            z = true;
        }
        if (z) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 1, OwnershipRefresh$Status$$serializer.INSTANCE, ownershipRefresh.status);
        }
    }

    public final int getLastAttemptedAt() {
        return this.lastAttemptedAt;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OwnershipRefresh(int i, Status status2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? Status.UNKNOWN : status2);
    }

    public final Status getStatus() {
        return this.status;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u000b\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\r"}, d2 = {"Lcom/stripe/android/connections/model/OwnershipRefresh$Status;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FAILED", "PENDING", "SUCCEEDED", "UNKNOWN", "$serializer", "Companion", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Serializable
    /* compiled from: OwnershipRefresh.kt */
    public enum Status {
        FAILED("failed"),
        PENDING("pending"),
        SUCCEEDED("succeeded"),
        UNKNOWN("unknown");
        
        public static final Companion Companion = null;
        private final String value;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/connections/model/OwnershipRefresh$Status$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stripe/android/connections/model/OwnershipRefresh$Status;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: OwnershipRefresh.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Status> serializer() {
                return OwnershipRefresh$Status$$serializer.INSTANCE;
            }
        }

        private Status(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }
    }
}
