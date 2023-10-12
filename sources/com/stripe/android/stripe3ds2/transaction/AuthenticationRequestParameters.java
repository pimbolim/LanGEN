package com.stripe.android.stripe3ds2.transaction;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.stripe3ds2.transactions.ChallengeRequestData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006'"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/AuthenticationRequestParameters;", "Landroid/os/Parcelable;", "deviceData", "", "sdkTransactionId", "Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "sdkAppId", "sdkReferenceNumber", "sdkEphemeralPublicKey", "messageVersion", "(Ljava/lang/String;Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceData", "()Ljava/lang/String;", "getMessageVersion", "getSdkAppId", "getSdkEphemeralPublicKey", "getSdkReferenceNumber", "getSdkTransactionId", "()Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuthenticationRequestParameters.kt */
public final class AuthenticationRequestParameters implements Parcelable {
    public static final Parcelable.Creator<AuthenticationRequestParameters> CREATOR = new Creator();
    private final String deviceData;
    private final String messageVersion;
    private final String sdkAppId;
    private final String sdkEphemeralPublicKey;
    private final String sdkReferenceNumber;
    private final SdkTransactionId sdkTransactionId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AuthenticationRequestParameters.kt */
    public static final class Creator implements Parcelable.Creator<AuthenticationRequestParameters> {
        public final AuthenticationRequestParameters createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AuthenticationRequestParameters(parcel.readString(), SdkTransactionId.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final AuthenticationRequestParameters[] newArray(int i) {
            return new AuthenticationRequestParameters[i];
        }
    }

    public static /* synthetic */ AuthenticationRequestParameters copy$default(AuthenticationRequestParameters authenticationRequestParameters, String str, SdkTransactionId sdkTransactionId2, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authenticationRequestParameters.deviceData;
        }
        if ((i & 2) != 0) {
            sdkTransactionId2 = authenticationRequestParameters.sdkTransactionId;
        }
        SdkTransactionId sdkTransactionId3 = sdkTransactionId2;
        if ((i & 4) != 0) {
            str2 = authenticationRequestParameters.sdkAppId;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = authenticationRequestParameters.sdkReferenceNumber;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = authenticationRequestParameters.sdkEphemeralPublicKey;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            str5 = authenticationRequestParameters.messageVersion;
        }
        return authenticationRequestParameters.copy(str, sdkTransactionId3, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.deviceData;
    }

    public final SdkTransactionId component2() {
        return this.sdkTransactionId;
    }

    public final String component3() {
        return this.sdkAppId;
    }

    public final String component4() {
        return this.sdkReferenceNumber;
    }

    public final String component5() {
        return this.sdkEphemeralPublicKey;
    }

    public final String component6() {
        return this.messageVersion;
    }

    public final AuthenticationRequestParameters copy(String str, SdkTransactionId sdkTransactionId2, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "deviceData");
        Intrinsics.checkNotNullParameter(sdkTransactionId2, "sdkTransactionId");
        Intrinsics.checkNotNullParameter(str2, "sdkAppId");
        Intrinsics.checkNotNullParameter(str3, "sdkReferenceNumber");
        Intrinsics.checkNotNullParameter(str4, "sdkEphemeralPublicKey");
        Intrinsics.checkNotNullParameter(str5, ChallengeRequestData.FIELD_MESSAGE_VERSION);
        return new AuthenticationRequestParameters(str, sdkTransactionId2, str2, str3, str4, str5);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationRequestParameters)) {
            return false;
        }
        AuthenticationRequestParameters authenticationRequestParameters = (AuthenticationRequestParameters) obj;
        return Intrinsics.areEqual((Object) this.deviceData, (Object) authenticationRequestParameters.deviceData) && Intrinsics.areEqual((Object) this.sdkTransactionId, (Object) authenticationRequestParameters.sdkTransactionId) && Intrinsics.areEqual((Object) this.sdkAppId, (Object) authenticationRequestParameters.sdkAppId) && Intrinsics.areEqual((Object) this.sdkReferenceNumber, (Object) authenticationRequestParameters.sdkReferenceNumber) && Intrinsics.areEqual((Object) this.sdkEphemeralPublicKey, (Object) authenticationRequestParameters.sdkEphemeralPublicKey) && Intrinsics.areEqual((Object) this.messageVersion, (Object) authenticationRequestParameters.messageVersion);
    }

    public int hashCode() {
        return (((((((((this.deviceData.hashCode() * 31) + this.sdkTransactionId.hashCode()) * 31) + this.sdkAppId.hashCode()) * 31) + this.sdkReferenceNumber.hashCode()) * 31) + this.sdkEphemeralPublicKey.hashCode()) * 31) + this.messageVersion.hashCode();
    }

    public String toString() {
        return "AuthenticationRequestParameters(deviceData=" + this.deviceData + ", sdkTransactionId=" + this.sdkTransactionId + ", sdkAppId=" + this.sdkAppId + ", sdkReferenceNumber=" + this.sdkReferenceNumber + ", sdkEphemeralPublicKey=" + this.sdkEphemeralPublicKey + ", messageVersion=" + this.messageVersion + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.deviceData);
        this.sdkTransactionId.writeToParcel(parcel, i);
        parcel.writeString(this.sdkAppId);
        parcel.writeString(this.sdkReferenceNumber);
        parcel.writeString(this.sdkEphemeralPublicKey);
        parcel.writeString(this.messageVersion);
    }

    public AuthenticationRequestParameters(String str, SdkTransactionId sdkTransactionId2, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "deviceData");
        Intrinsics.checkNotNullParameter(sdkTransactionId2, "sdkTransactionId");
        Intrinsics.checkNotNullParameter(str2, "sdkAppId");
        Intrinsics.checkNotNullParameter(str3, "sdkReferenceNumber");
        Intrinsics.checkNotNullParameter(str4, "sdkEphemeralPublicKey");
        Intrinsics.checkNotNullParameter(str5, ChallengeRequestData.FIELD_MESSAGE_VERSION);
        this.deviceData = str;
        this.sdkTransactionId = sdkTransactionId2;
        this.sdkAppId = str2;
        this.sdkReferenceNumber = str3;
        this.sdkEphemeralPublicKey = str4;
        this.messageVersion = str5;
    }

    public final String getDeviceData() {
        return this.deviceData;
    }

    public final SdkTransactionId getSdkTransactionId() {
        return this.sdkTransactionId;
    }

    public final String getSdkAppId() {
        return this.sdkAppId;
    }

    public final String getSdkReferenceNumber() {
        return this.sdkReferenceNumber;
    }

    public final String getSdkEphemeralPublicKey() {
        return this.sdkEphemeralPublicKey;
    }

    public final String getMessageVersion() {
        return this.messageVersion;
    }
}
