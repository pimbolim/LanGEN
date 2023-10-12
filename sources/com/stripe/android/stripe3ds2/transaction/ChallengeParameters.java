package com.stripe.android.stripe3ds2.transaction;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\u0019\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001cHÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006("}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/ChallengeParameters;", "Landroid/os/Parcelable;", "threeDsServerTransactionId", "", "acsTransactionId", "acsRefNumber", "acsSignedContent", "threeDSRequestorAppURL", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAcsRefNumber", "()Ljava/lang/String;", "setAcsRefNumber", "(Ljava/lang/String;)V", "getAcsSignedContent", "setAcsSignedContent", "getAcsTransactionId", "setAcsTransactionId", "getThreeDSRequestorAppURL", "setThreeDSRequestorAppURL", "getThreeDsServerTransactionId", "setThreeDsServerTransactionId", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeParameters.kt */
public final class ChallengeParameters implements Parcelable {
    public static final Parcelable.Creator<ChallengeParameters> CREATOR = new Creator();
    private String acsRefNumber;
    private String acsSignedContent;
    private String acsTransactionId;
    private String threeDSRequestorAppURL;
    private String threeDsServerTransactionId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeParameters.kt */
    public static final class Creator implements Parcelable.Creator<ChallengeParameters> {
        public final ChallengeParameters createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ChallengeParameters(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final ChallengeParameters[] newArray(int i) {
            return new ChallengeParameters[i];
        }
    }

    public ChallengeParameters() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ChallengeParameters copy$default(ChallengeParameters challengeParameters, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = challengeParameters.threeDsServerTransactionId;
        }
        if ((i & 2) != 0) {
            str2 = challengeParameters.acsTransactionId;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = challengeParameters.acsRefNumber;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = challengeParameters.acsSignedContent;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = challengeParameters.threeDSRequestorAppURL;
        }
        return challengeParameters.copy(str, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.threeDsServerTransactionId;
    }

    public final String component2() {
        return this.acsTransactionId;
    }

    public final String component3() {
        return this.acsRefNumber;
    }

    public final String component4() {
        return this.acsSignedContent;
    }

    public final String component5() {
        return this.threeDSRequestorAppURL;
    }

    public final ChallengeParameters copy(String str, String str2, String str3, String str4, String str5) {
        return new ChallengeParameters(str, str2, str3, str4, str5);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChallengeParameters)) {
            return false;
        }
        ChallengeParameters challengeParameters = (ChallengeParameters) obj;
        return Intrinsics.areEqual((Object) this.threeDsServerTransactionId, (Object) challengeParameters.threeDsServerTransactionId) && Intrinsics.areEqual((Object) this.acsTransactionId, (Object) challengeParameters.acsTransactionId) && Intrinsics.areEqual((Object) this.acsRefNumber, (Object) challengeParameters.acsRefNumber) && Intrinsics.areEqual((Object) this.acsSignedContent, (Object) challengeParameters.acsSignedContent) && Intrinsics.areEqual((Object) this.threeDSRequestorAppURL, (Object) challengeParameters.threeDSRequestorAppURL);
    }

    public int hashCode() {
        String str = this.threeDsServerTransactionId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.acsTransactionId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.acsRefNumber;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.acsSignedContent;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.threeDSRequestorAppURL;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "ChallengeParameters(threeDsServerTransactionId=" + this.threeDsServerTransactionId + ", acsTransactionId=" + this.acsTransactionId + ", acsRefNumber=" + this.acsRefNumber + ", acsSignedContent=" + this.acsSignedContent + ", threeDSRequestorAppURL=" + this.threeDSRequestorAppURL + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.threeDsServerTransactionId);
        parcel.writeString(this.acsTransactionId);
        parcel.writeString(this.acsRefNumber);
        parcel.writeString(this.acsSignedContent);
        parcel.writeString(this.threeDSRequestorAppURL);
    }

    public ChallengeParameters(String str, String str2, String str3, String str4, String str5) {
        this.threeDsServerTransactionId = str;
        this.acsTransactionId = str2;
        this.acsRefNumber = str3;
        this.acsSignedContent = str4;
        this.threeDSRequestorAppURL = str5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ChallengeParameters(java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.stripe3ds2.transaction.ChallengeParameters.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getThreeDsServerTransactionId() {
        return this.threeDsServerTransactionId;
    }

    public final void setThreeDsServerTransactionId(String str) {
        this.threeDsServerTransactionId = str;
    }

    public final String getAcsTransactionId() {
        return this.acsTransactionId;
    }

    public final void setAcsTransactionId(String str) {
        this.acsTransactionId = str;
    }

    public final String getAcsRefNumber() {
        return this.acsRefNumber;
    }

    public final void setAcsRefNumber(String str) {
        this.acsRefNumber = str;
    }

    public final String getAcsSignedContent() {
        return this.acsSignedContent;
    }

    public final void setAcsSignedContent(String str) {
        this.acsSignedContent = str;
    }

    public final String getThreeDSRequestorAppURL() {
        return this.threeDSRequestorAppURL;
    }

    public final void setThreeDSRequestorAppURL(String str) {
        this.threeDSRequestorAppURL = str;
    }
}
