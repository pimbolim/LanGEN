package com.stripe.android.stripe3ds2.transactions;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.stripe.android.model.Stripe3ds2AuthResult;
import com.stripe.android.stripe3ds2.transaction.SdkTransactionId;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 82\u00020\u0001:\u000289Bm\b\u0000\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003Jy\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020)HÖ\u0001J\r\u0010/\u001a\u000200H\u0000¢\u0006\u0002\b1J\t\u00102\u001a\u00020\u0003HÖ\u0001J\u0019\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020)HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006:"}, d2 = {"Lcom/stripe/android/stripe3ds2/transactions/ErrorData;", "Landroid/os/Parcelable;", "serverTransId", "", "acsTransId", "dsTransId", "errorCode", "errorComponent", "Lcom/stripe/android/stripe3ds2/transactions/ErrorData$ErrorComponent;", "errorDescription", "errorDetail", "errorMessageType", "messageVersion", "sdkTransId", "Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/stripe3ds2/transactions/ErrorData$ErrorComponent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;)V", "getAcsTransId", "()Ljava/lang/String;", "getDsTransId", "getErrorCode", "getErrorComponent", "()Lcom/stripe/android/stripe3ds2/transactions/ErrorData$ErrorComponent;", "getErrorDescription", "getErrorDetail", "getErrorMessageType", "getMessageVersion", "getSdkTransId", "()Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "getServerTransId", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toJson", "Lorg/json/JSONObject;", "toJson$3ds2sdk_release", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "ErrorComponent", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ErrorData.kt */
public final class ErrorData implements Parcelable {
    public static final Parcelable.Creator<ErrorData> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FIELD_3DS_SERVER_TRANS_ID = "threeDSServerTransID";
    private static final String FIELD_ACS_TRANS_ID = "acsTransID";
    private static final String FIELD_DS_TRANS_ID = "dsTransID";
    private static final String FIELD_ERROR_CODE = "errorCode";
    private static final String FIELD_ERROR_COMPONENT = "errorComponent";
    private static final String FIELD_ERROR_DESCRIPTION = "errorDescription";
    private static final String FIELD_ERROR_DETAIL = "errorDetail";
    private static final String FIELD_ERROR_MESSAGE_TYPE = "errorMessageType";
    private static final String FIELD_MESSAGE_TYPE = "messageType";
    private static final String FIELD_MESSAGE_VERSION = "messageVersion";
    private static final String FIELD_SDK_TRANS_ID = "sdkTransID";
    private static final String MESSAGE_TYPE = "Erro";
    private final String acsTransId;
    private final String dsTransId;
    private final String errorCode;
    private final ErrorComponent errorComponent;
    private final String errorDescription;
    private final String errorDetail;
    private final String errorMessageType;
    private final String messageVersion;
    private final SdkTransactionId sdkTransId;
    private final String serverTransId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ErrorData.kt */
    public static final class Creator implements Parcelable.Creator<ErrorData> {
        public final ErrorData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            SdkTransactionId sdkTransactionId = null;
            ErrorComponent valueOf = parcel.readInt() == 0 ? null : ErrorComponent.valueOf(parcel.readString());
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            if (parcel.readInt() != 0) {
                sdkTransactionId = SdkTransactionId.CREATOR.createFromParcel(parcel);
            }
            return new ErrorData(readString, readString2, readString3, readString4, valueOf, readString5, readString6, readString7, readString8, sdkTransactionId);
        }

        public final ErrorData[] newArray(int i) {
            return new ErrorData[i];
        }
    }

    public static /* synthetic */ ErrorData copy$default(ErrorData errorData, String str, String str2, String str3, String str4, ErrorComponent errorComponent2, String str5, String str6, String str7, String str8, SdkTransactionId sdkTransactionId, int i, Object obj) {
        ErrorData errorData2 = errorData;
        int i2 = i;
        return errorData.copy((i2 & 1) != 0 ? errorData2.serverTransId : str, (i2 & 2) != 0 ? errorData2.acsTransId : str2, (i2 & 4) != 0 ? errorData2.dsTransId : str3, (i2 & 8) != 0 ? errorData2.errorCode : str4, (i2 & 16) != 0 ? errorData2.errorComponent : errorComponent2, (i2 & 32) != 0 ? errorData2.errorDescription : str5, (i2 & 64) != 0 ? errorData2.errorDetail : str6, (i2 & 128) != 0 ? errorData2.errorMessageType : str7, (i2 & 256) != 0 ? errorData2.messageVersion : str8, (i2 & 512) != 0 ? errorData2.sdkTransId : sdkTransactionId);
    }

    public final String component1() {
        return this.serverTransId;
    }

    public final SdkTransactionId component10() {
        return this.sdkTransId;
    }

    public final String component2() {
        return this.acsTransId;
    }

    public final String component3() {
        return this.dsTransId;
    }

    public final String component4() {
        return this.errorCode;
    }

    public final ErrorComponent component5() {
        return this.errorComponent;
    }

    public final String component6() {
        return this.errorDescription;
    }

    public final String component7() {
        return this.errorDetail;
    }

    public final String component8() {
        return this.errorMessageType;
    }

    public final String component9() {
        return this.messageVersion;
    }

    public final ErrorData copy(String str, String str2, String str3, String str4, ErrorComponent errorComponent2, String str5, String str6, String str7, String str8, SdkTransactionId sdkTransactionId) {
        String str9 = str4;
        Intrinsics.checkNotNullParameter(str9, FIELD_ERROR_CODE);
        String str10 = str5;
        Intrinsics.checkNotNullParameter(str10, FIELD_ERROR_DESCRIPTION);
        String str11 = str6;
        Intrinsics.checkNotNullParameter(str11, FIELD_ERROR_DETAIL);
        String str12 = str8;
        Intrinsics.checkNotNullParameter(str12, "messageVersion");
        return new ErrorData(str, str2, str3, str9, errorComponent2, str10, str11, str7, str12, sdkTransactionId);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorData)) {
            return false;
        }
        ErrorData errorData = (ErrorData) obj;
        return Intrinsics.areEqual((Object) this.serverTransId, (Object) errorData.serverTransId) && Intrinsics.areEqual((Object) this.acsTransId, (Object) errorData.acsTransId) && Intrinsics.areEqual((Object) this.dsTransId, (Object) errorData.dsTransId) && Intrinsics.areEqual((Object) this.errorCode, (Object) errorData.errorCode) && this.errorComponent == errorData.errorComponent && Intrinsics.areEqual((Object) this.errorDescription, (Object) errorData.errorDescription) && Intrinsics.areEqual((Object) this.errorDetail, (Object) errorData.errorDetail) && Intrinsics.areEqual((Object) this.errorMessageType, (Object) errorData.errorMessageType) && Intrinsics.areEqual((Object) this.messageVersion, (Object) errorData.messageVersion) && Intrinsics.areEqual((Object) this.sdkTransId, (Object) errorData.sdkTransId);
    }

    public int hashCode() {
        String str = this.serverTransId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.acsTransId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.dsTransId;
        int hashCode3 = (((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.errorCode.hashCode()) * 31;
        ErrorComponent errorComponent2 = this.errorComponent;
        int hashCode4 = (((((hashCode3 + (errorComponent2 == null ? 0 : errorComponent2.hashCode())) * 31) + this.errorDescription.hashCode()) * 31) + this.errorDetail.hashCode()) * 31;
        String str4 = this.errorMessageType;
        int hashCode5 = (((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.messageVersion.hashCode()) * 31;
        SdkTransactionId sdkTransactionId = this.sdkTransId;
        if (sdkTransactionId != null) {
            i = sdkTransactionId.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "ErrorData(serverTransId=" + this.serverTransId + ", acsTransId=" + this.acsTransId + ", dsTransId=" + this.dsTransId + ", errorCode=" + this.errorCode + ", errorComponent=" + this.errorComponent + ", errorDescription=" + this.errorDescription + ", errorDetail=" + this.errorDetail + ", errorMessageType=" + this.errorMessageType + ", messageVersion=" + this.messageVersion + ", sdkTransId=" + this.sdkTransId + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.serverTransId);
        parcel.writeString(this.acsTransId);
        parcel.writeString(this.dsTransId);
        parcel.writeString(this.errorCode);
        ErrorComponent errorComponent2 = this.errorComponent;
        if (errorComponent2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(errorComponent2.name());
        }
        parcel.writeString(this.errorDescription);
        parcel.writeString(this.errorDetail);
        parcel.writeString(this.errorMessageType);
        parcel.writeString(this.messageVersion);
        SdkTransactionId sdkTransactionId = this.sdkTransId;
        if (sdkTransactionId == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        sdkTransactionId.writeToParcel(parcel, i);
    }

    public ErrorData(String str, String str2, String str3, String str4, ErrorComponent errorComponent2, String str5, String str6, String str7, String str8, SdkTransactionId sdkTransactionId) {
        Intrinsics.checkNotNullParameter(str4, FIELD_ERROR_CODE);
        Intrinsics.checkNotNullParameter(str5, FIELD_ERROR_DESCRIPTION);
        Intrinsics.checkNotNullParameter(str6, FIELD_ERROR_DETAIL);
        Intrinsics.checkNotNullParameter(str8, "messageVersion");
        this.serverTransId = str;
        this.acsTransId = str2;
        this.dsTransId = str3;
        this.errorCode = str4;
        this.errorComponent = errorComponent2;
        this.errorDescription = str5;
        this.errorDetail = str6;
        this.errorMessageType = str7;
        this.messageVersion = str8;
        this.sdkTransId = sdkTransactionId;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ErrorData(java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, com.stripe.android.stripe3ds2.transactions.ErrorData.ErrorComponent r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, com.stripe.android.stripe3ds2.transaction.SdkTransactionId r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r14 = this;
            r0 = r25
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r4 = r2
            goto L_0x000a
        L_0x0009:
            r4 = r15
        L_0x000a:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0010
            r5 = r2
            goto L_0x0012
        L_0x0010:
            r5 = r16
        L_0x0012:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0018
            r6 = r2
            goto L_0x001a
        L_0x0018:
            r6 = r17
        L_0x001a:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0020
            r8 = r2
            goto L_0x0022
        L_0x0020:
            r8 = r19
        L_0x0022:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0028
            r11 = r2
            goto L_0x002a
        L_0x0028:
            r11 = r22
        L_0x002a:
            r3 = r14
            r7 = r18
            r9 = r20
            r10 = r21
            r12 = r23
            r13 = r24
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.stripe3ds2.transactions.ErrorData.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.stripe.android.stripe3ds2.transactions.ErrorData$ErrorComponent, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.stripe.android.stripe3ds2.transaction.SdkTransactionId, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getServerTransId() {
        return this.serverTransId;
    }

    public final String getAcsTransId() {
        return this.acsTransId;
    }

    public final String getDsTransId() {
        return this.dsTransId;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final ErrorComponent getErrorComponent() {
        return this.errorComponent;
    }

    public final String getErrorDescription() {
        return this.errorDescription;
    }

    public final String getErrorDetail() {
        return this.errorDetail;
    }

    public final String getErrorMessageType() {
        return this.errorMessageType;
    }

    public final String getMessageVersion() {
        return this.messageVersion;
    }

    public final SdkTransactionId getSdkTransId() {
        return this.sdkTransId;
    }

    public final JSONObject toJson$3ds2sdk_release() throws JSONException {
        JSONObject put = new JSONObject().put("messageType", MESSAGE_TYPE).put("messageVersion", this.messageVersion).put("sdkTransID", this.sdkTransId).put(FIELD_ERROR_CODE, this.errorCode).put(FIELD_ERROR_DESCRIPTION, this.errorDescription).put(FIELD_ERROR_DETAIL, this.errorDetail);
        String str = this.serverTransId;
        if (str != null) {
            put.put("threeDSServerTransID", str);
        }
        String str2 = this.acsTransId;
        if (str2 != null) {
            put.put("acsTransID", str2);
        }
        String str3 = this.dsTransId;
        if (str3 != null) {
            put.put(FIELD_DS_TRANS_ID, str3);
        }
        ErrorComponent errorComponent2 = this.errorComponent;
        if (errorComponent2 != null) {
            put.put(FIELD_ERROR_COMPONENT, errorComponent2.getCode());
        }
        String str4 = this.errorMessageType;
        if (str4 != null) {
            put.put(FIELD_ERROR_MESSAGE_TYPE, str4);
        }
        Intrinsics.checkNotNullExpressionValue(put, "json");
        return put;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/stripe/android/stripe3ds2/transactions/ErrorData$ErrorComponent;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "ThreeDsSdk", "ThreeDsServer", "DirectoryServer", "Acs", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ErrorData.kt */
    public enum ErrorComponent {
        ThreeDsSdk(Stripe3ds2AuthResult.Ares.VALUE_CHALLENGE),
        ThreeDsServer(ExifInterface.LATITUDE_SOUTH),
        DirectoryServer("D"),
        Acs(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        
        public static final Companion Companion = null;
        private final String code;

        private ErrorComponent(String str) {
            this.code = str;
        }

        public final String getCode() {
            return this.code;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/stripe3ds2/transactions/ErrorData$ErrorComponent$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/stripe3ds2/transactions/ErrorData$ErrorComponent;", "code", "", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ErrorData.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ErrorComponent fromCode(String str) {
                ErrorComponent[] values = ErrorComponent.values();
                int length = values.length;
                int i = 0;
                while (i < length) {
                    ErrorComponent errorComponent = values[i];
                    i++;
                    if (Intrinsics.areEqual((Object) errorComponent.getCode(), (Object) str)) {
                        return errorComponent;
                    }
                }
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014J\u0015\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/stripe3ds2/transactions/ErrorData$Companion;", "", "()V", "FIELD_3DS_SERVER_TRANS_ID", "", "FIELD_ACS_TRANS_ID", "FIELD_DS_TRANS_ID", "FIELD_ERROR_CODE", "FIELD_ERROR_COMPONENT", "FIELD_ERROR_DESCRIPTION", "FIELD_ERROR_DETAIL", "FIELD_ERROR_MESSAGE_TYPE", "FIELD_MESSAGE_TYPE", "FIELD_MESSAGE_VERSION", "FIELD_SDK_TRANS_ID", "MESSAGE_TYPE", "fromJson", "Lcom/stripe/android/stripe3ds2/transactions/ErrorData;", "payload", "Lorg/json/JSONObject;", "fromJson$3ds2sdk_release", "isErrorMessage", "", "isErrorMessage$3ds2sdk_release", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ErrorData.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ErrorData fromJson$3ds2sdk_release(JSONObject jSONObject) {
            SdkTransactionId sdkTransactionId;
            Intrinsics.checkNotNullParameter(jSONObject, "payload");
            String optString = jSONObject.optString("threeDSServerTransID");
            String optString2 = jSONObject.optString("acsTransID");
            String optString3 = jSONObject.optString(ErrorData.FIELD_DS_TRANS_ID);
            String optString4 = jSONObject.optString(ErrorData.FIELD_ERROR_CODE);
            Intrinsics.checkNotNullExpressionValue(optString4, "payload.optString(FIELD_ERROR_CODE)");
            ErrorComponent fromCode = ErrorComponent.Companion.fromCode(jSONObject.optString(ErrorData.FIELD_ERROR_COMPONENT));
            String optString5 = jSONObject.optString(ErrorData.FIELD_ERROR_DESCRIPTION);
            Intrinsics.checkNotNullExpressionValue(optString5, "payload.optString(FIELD_ERROR_DESCRIPTION)");
            String optString6 = jSONObject.optString(ErrorData.FIELD_ERROR_DETAIL);
            Intrinsics.checkNotNullExpressionValue(optString6, "payload.optString(FIELD_ERROR_DETAIL)");
            String optString7 = jSONObject.optString(ErrorData.FIELD_ERROR_MESSAGE_TYPE);
            String optString8 = jSONObject.optString("messageVersion");
            Intrinsics.checkNotNullExpressionValue(optString8, "payload.optString(FIELD_MESSAGE_VERSION)");
            String optString9 = jSONObject.optString("sdkTransID");
            if (optString9 == null) {
                sdkTransactionId = null;
            } else {
                sdkTransactionId = new SdkTransactionId(optString9);
            }
            return new ErrorData(optString, optString2, optString3, optString4, fromCode, optString5, optString6, optString7, optString8, sdkTransactionId);
        }

        public final boolean isErrorMessage$3ds2sdk_release(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "payload");
            return Intrinsics.areEqual((Object) ErrorData.MESSAGE_TYPE, (Object) jSONObject.optString("messageType"));
        }
    }
}
