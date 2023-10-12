package com.stripe.android.stripe3ds2.transaction;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ProtocolErrorEvent;", "Landroid/os/Parcelable;", "sdkTransactionId", "Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "errorMessage", "Lcom/stripe/android/stripe3ds2/transaction/ErrorMessage;", "(Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;Lcom/stripe/android/stripe3ds2/transaction/ErrorMessage;)V", "getErrorMessage", "()Lcom/stripe/android/stripe3ds2/transaction/ErrorMessage;", "getSdkTransactionId", "()Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProtocolErrorEvent.kt */
public final class ProtocolErrorEvent implements Parcelable {
    public static final Parcelable.Creator<ProtocolErrorEvent> CREATOR = new Creator();
    private final ErrorMessage errorMessage;
    private final SdkTransactionId sdkTransactionId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ProtocolErrorEvent.kt */
    public static final class Creator implements Parcelable.Creator<ProtocolErrorEvent> {
        public final ProtocolErrorEvent createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ProtocolErrorEvent(parcel.readInt() == 0 ? null : SdkTransactionId.CREATOR.createFromParcel(parcel), ErrorMessage.CREATOR.createFromParcel(parcel));
        }

        public final ProtocolErrorEvent[] newArray(int i) {
            return new ProtocolErrorEvent[i];
        }
    }

    public static /* synthetic */ ProtocolErrorEvent copy$default(ProtocolErrorEvent protocolErrorEvent, SdkTransactionId sdkTransactionId2, ErrorMessage errorMessage2, int i, Object obj) {
        if ((i & 1) != 0) {
            sdkTransactionId2 = protocolErrorEvent.sdkTransactionId;
        }
        if ((i & 2) != 0) {
            errorMessage2 = protocolErrorEvent.errorMessage;
        }
        return protocolErrorEvent.copy(sdkTransactionId2, errorMessage2);
    }

    public final SdkTransactionId component1() {
        return this.sdkTransactionId;
    }

    public final ErrorMessage component2() {
        return this.errorMessage;
    }

    public final ProtocolErrorEvent copy(SdkTransactionId sdkTransactionId2, ErrorMessage errorMessage2) {
        Intrinsics.checkNotNullParameter(errorMessage2, "errorMessage");
        return new ProtocolErrorEvent(sdkTransactionId2, errorMessage2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProtocolErrorEvent)) {
            return false;
        }
        ProtocolErrorEvent protocolErrorEvent = (ProtocolErrorEvent) obj;
        return Intrinsics.areEqual((Object) this.sdkTransactionId, (Object) protocolErrorEvent.sdkTransactionId) && Intrinsics.areEqual((Object) this.errorMessage, (Object) protocolErrorEvent.errorMessage);
    }

    public int hashCode() {
        SdkTransactionId sdkTransactionId2 = this.sdkTransactionId;
        return ((sdkTransactionId2 == null ? 0 : sdkTransactionId2.hashCode()) * 31) + this.errorMessage.hashCode();
    }

    public String toString() {
        return "ProtocolErrorEvent(sdkTransactionId=" + this.sdkTransactionId + ", errorMessage=" + this.errorMessage + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        SdkTransactionId sdkTransactionId2 = this.sdkTransactionId;
        if (sdkTransactionId2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            sdkTransactionId2.writeToParcel(parcel, i);
        }
        this.errorMessage.writeToParcel(parcel, i);
    }

    public ProtocolErrorEvent(SdkTransactionId sdkTransactionId2, ErrorMessage errorMessage2) {
        Intrinsics.checkNotNullParameter(errorMessage2, "errorMessage");
        this.sdkTransactionId = sdkTransactionId2;
        this.errorMessage = errorMessage2;
    }

    public final SdkTransactionId getSdkTransactionId() {
        return this.sdkTransactionId;
    }

    public final ErrorMessage getErrorMessage() {
        return this.errorMessage;
    }
}
