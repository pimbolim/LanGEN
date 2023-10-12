package com.stripe.android.stripe3ds2.transaction;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ErrorMessage;", "Landroid/os/Parcelable;", "transactionId", "", "errorCode", "errorDescription", "errorDetails", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getErrorCode", "()Ljava/lang/String;", "getErrorDescription", "getErrorDetails", "getTransactionId", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ErrorMessage.kt */
public final class ErrorMessage implements Parcelable {
    public static final Parcelable.Creator<ErrorMessage> CREATOR = new Creator();
    private final String errorCode;
    private final String errorDescription;
    private final String errorDetails;
    private final String transactionId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ErrorMessage.kt */
    public static final class Creator implements Parcelable.Creator<ErrorMessage> {
        public final ErrorMessage createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ErrorMessage(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final ErrorMessage[] newArray(int i) {
            return new ErrorMessage[i];
        }
    }

    public static /* synthetic */ ErrorMessage copy$default(ErrorMessage errorMessage, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = errorMessage.transactionId;
        }
        if ((i & 2) != 0) {
            str2 = errorMessage.errorCode;
        }
        if ((i & 4) != 0) {
            str3 = errorMessage.errorDescription;
        }
        if ((i & 8) != 0) {
            str4 = errorMessage.errorDetails;
        }
        return errorMessage.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.transactionId;
    }

    public final String component2() {
        return this.errorCode;
    }

    public final String component3() {
        return this.errorDescription;
    }

    public final String component4() {
        return this.errorDetails;
    }

    public final ErrorMessage copy(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "transactionId");
        Intrinsics.checkNotNullParameter(str2, "errorCode");
        Intrinsics.checkNotNullParameter(str3, "errorDescription");
        Intrinsics.checkNotNullParameter(str4, "errorDetails");
        return new ErrorMessage(str, str2, str3, str4);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorMessage)) {
            return false;
        }
        ErrorMessage errorMessage = (ErrorMessage) obj;
        return Intrinsics.areEqual((Object) this.transactionId, (Object) errorMessage.transactionId) && Intrinsics.areEqual((Object) this.errorCode, (Object) errorMessage.errorCode) && Intrinsics.areEqual((Object) this.errorDescription, (Object) errorMessage.errorDescription) && Intrinsics.areEqual((Object) this.errorDetails, (Object) errorMessage.errorDetails);
    }

    public int hashCode() {
        return (((((this.transactionId.hashCode() * 31) + this.errorCode.hashCode()) * 31) + this.errorDescription.hashCode()) * 31) + this.errorDetails.hashCode();
    }

    public String toString() {
        return "ErrorMessage(transactionId=" + this.transactionId + ", errorCode=" + this.errorCode + ", errorDescription=" + this.errorDescription + ", errorDetails=" + this.errorDetails + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.transactionId);
        parcel.writeString(this.errorCode);
        parcel.writeString(this.errorDescription);
        parcel.writeString(this.errorDetails);
    }

    public ErrorMessage(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "transactionId");
        Intrinsics.checkNotNullParameter(str2, "errorCode");
        Intrinsics.checkNotNullParameter(str3, "errorDescription");
        Intrinsics.checkNotNullParameter(str4, "errorDetails");
        this.transactionId = str;
        this.errorCode = str2;
        this.errorDescription = str3;
        this.errorDetails = str4;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorDescription() {
        return this.errorDescription;
    }

    public final String getErrorDetails() {
        return this.errorDetails;
    }
}
