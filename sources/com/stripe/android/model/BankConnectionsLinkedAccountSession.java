package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/stripe/android/model/BankConnectionsLinkedAccountSession;", "Lcom/stripe/android/core/model/StripeModel;", "clientSecret", "", "id", "(Ljava/lang/String;Ljava/lang/String;)V", "getClientSecret", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BankConnectionsLinkedAccountSession.kt */
public final class BankConnectionsLinkedAccountSession implements StripeModel {
    public static final Parcelable.Creator<BankConnectionsLinkedAccountSession> CREATOR = new Creator();
    private final String clientSecret;
    private final String id;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BankConnectionsLinkedAccountSession.kt */
    public static final class Creator implements Parcelable.Creator<BankConnectionsLinkedAccountSession> {
        public final BankConnectionsLinkedAccountSession createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BankConnectionsLinkedAccountSession(parcel.readString(), parcel.readString());
        }

        public final BankConnectionsLinkedAccountSession[] newArray(int i) {
            return new BankConnectionsLinkedAccountSession[i];
        }
    }

    public static /* synthetic */ BankConnectionsLinkedAccountSession copy$default(BankConnectionsLinkedAccountSession bankConnectionsLinkedAccountSession, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bankConnectionsLinkedAccountSession.clientSecret;
        }
        if ((i & 2) != 0) {
            str2 = bankConnectionsLinkedAccountSession.id;
        }
        return bankConnectionsLinkedAccountSession.copy(str, str2);
    }

    public final String component1() {
        return this.clientSecret;
    }

    public final String component2() {
        return this.id;
    }

    public final BankConnectionsLinkedAccountSession copy(String str, String str2) {
        return new BankConnectionsLinkedAccountSession(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BankConnectionsLinkedAccountSession)) {
            return false;
        }
        BankConnectionsLinkedAccountSession bankConnectionsLinkedAccountSession = (BankConnectionsLinkedAccountSession) obj;
        return Intrinsics.areEqual((Object) this.clientSecret, (Object) bankConnectionsLinkedAccountSession.clientSecret) && Intrinsics.areEqual((Object) this.id, (Object) bankConnectionsLinkedAccountSession.id);
    }

    public int hashCode() {
        String str = this.clientSecret;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.id;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "BankConnectionsLinkedAccountSession(clientSecret=" + this.clientSecret + ", id=" + this.id + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.clientSecret);
        parcel.writeString(this.id);
    }

    public BankConnectionsLinkedAccountSession(String str, String str2) {
        this.clientSecret = str;
        this.id = str2;
    }

    public final String getClientSecret() {
        return this.clientSecret;
    }

    public final String getId() {
        return this.id;
    }
}
