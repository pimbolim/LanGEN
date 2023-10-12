package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/model/ConsumerSessionLookup;", "Lcom/stripe/android/core/model/StripeModel;", "exists", "", "consumerSession", "Lcom/stripe/android/model/ConsumerSession;", "errorMessage", "", "(ZLcom/stripe/android/model/ConsumerSession;Ljava/lang/String;)V", "getConsumerSession", "()Lcom/stripe/android/model/ConsumerSession;", "getErrorMessage", "()Ljava/lang/String;", "getExists", "()Z", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConsumerSessionLookup.kt */
public final class ConsumerSessionLookup implements StripeModel {
    public static final int $stable = 8;
    public static final Parcelable.Creator<ConsumerSessionLookup> CREATOR = new Creator();
    private final ConsumerSession consumerSession;
    private final String errorMessage;
    private final boolean exists;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConsumerSessionLookup.kt */
    public static final class Creator implements Parcelable.Creator<ConsumerSessionLookup> {
        public final ConsumerSessionLookup createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ConsumerSessionLookup(parcel.readInt() != 0, parcel.readInt() == 0 ? null : ConsumerSession.CREATOR.createFromParcel(parcel), parcel.readString());
        }

        public final ConsumerSessionLookup[] newArray(int i) {
            return new ConsumerSessionLookup[i];
        }
    }

    public static /* synthetic */ ConsumerSessionLookup copy$default(ConsumerSessionLookup consumerSessionLookup, boolean z, ConsumerSession consumerSession2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = consumerSessionLookup.exists;
        }
        if ((i & 2) != 0) {
            consumerSession2 = consumerSessionLookup.consumerSession;
        }
        if ((i & 4) != 0) {
            str = consumerSessionLookup.errorMessage;
        }
        return consumerSessionLookup.copy(z, consumerSession2, str);
    }

    public final boolean component1() {
        return this.exists;
    }

    public final ConsumerSession component2() {
        return this.consumerSession;
    }

    public final String component3() {
        return this.errorMessage;
    }

    public final ConsumerSessionLookup copy(boolean z, ConsumerSession consumerSession2, String str) {
        return new ConsumerSessionLookup(z, consumerSession2, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsumerSessionLookup)) {
            return false;
        }
        ConsumerSessionLookup consumerSessionLookup = (ConsumerSessionLookup) obj;
        return this.exists == consumerSessionLookup.exists && Intrinsics.areEqual((Object) this.consumerSession, (Object) consumerSessionLookup.consumerSession) && Intrinsics.areEqual((Object) this.errorMessage, (Object) consumerSessionLookup.errorMessage);
    }

    public int hashCode() {
        boolean z = this.exists;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        ConsumerSession consumerSession2 = this.consumerSession;
        int i2 = 0;
        int hashCode = (i + (consumerSession2 == null ? 0 : consumerSession2.hashCode())) * 31;
        String str = this.errorMessage;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "ConsumerSessionLookup(exists=" + this.exists + ", consumerSession=" + this.consumerSession + ", errorMessage=" + this.errorMessage + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.exists ? 1 : 0);
        ConsumerSession consumerSession2 = this.consumerSession;
        if (consumerSession2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            consumerSession2.writeToParcel(parcel, i);
        }
        parcel.writeString(this.errorMessage);
    }

    public ConsumerSessionLookup(boolean z, ConsumerSession consumerSession2, String str) {
        this.exists = z;
        this.consumerSession = consumerSession2;
        this.errorMessage = str;
    }

    public final boolean getExists() {
        return this.exists;
    }

    public final ConsumerSession getConsumerSession() {
        return this.consumerSession;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }
}
