package com.stripe.android.paymentsheet.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.security.InvalidParameterException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0019\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/stripe/android/paymentsheet/model/PaymentIntentClientSecret;", "Lcom/stripe/android/paymentsheet/model/ClientSecret;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "validate", "", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClientSecret.kt */
public final class PaymentIntentClientSecret extends ClientSecret {
    public static final Parcelable.Creator<PaymentIntentClientSecret> CREATOR = new Creator();
    private final String value;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ClientSecret.kt */
    public static final class Creator implements Parcelable.Creator<PaymentIntentClientSecret> {
        public final PaymentIntentClientSecret createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PaymentIntentClientSecret(parcel.readString());
        }

        public final PaymentIntentClientSecret[] newArray(int i) {
            return new PaymentIntentClientSecret[i];
        }
    }

    public static /* synthetic */ PaymentIntentClientSecret copy$default(PaymentIntentClientSecret paymentIntentClientSecret, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = paymentIntentClientSecret.getValue();
        }
        return paymentIntentClientSecret.copy(str);
    }

    public final String component1() {
        return getValue();
    }

    public final PaymentIntentClientSecret copy(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return new PaymentIntentClientSecret(str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PaymentIntentClientSecret) && Intrinsics.areEqual((Object) getValue(), (Object) ((PaymentIntentClientSecret) obj).getValue());
    }

    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return "PaymentIntentClientSecret(value=" + getValue() + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.value);
    }

    public String getValue() {
        return this.value;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentIntentClientSecret(String str) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "value");
        this.value = str;
    }

    public void validate() {
        if (StringsKt.isBlank(getValue())) {
            throw new InvalidParameterException("The PaymentIntent client_secret cannot be an empty string.");
        }
    }
}
