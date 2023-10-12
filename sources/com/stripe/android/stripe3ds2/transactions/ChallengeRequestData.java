package com.stripe.android.stripe3ds2.transactions;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.stripe3ds2.exceptions.SDKRuntimeException;
import com.stripe.android.stripe3ds2.transaction.SdkTransactionId;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0002ABBs\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0013J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u0010&\u001a\u00020\u0004HÆ\u0003J\t\u0010'\u001a\u00020\u0004HÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eHÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010/J\t\u00100\u001a\u000201HÖ\u0001J\u0013\u00102\u001a\u00020\u00112\b\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u000201HÖ\u0001J\r\u00106\u001a\u00020\u0000H\u0000¢\u0006\u0002\b7J\r\u00108\u001a\u000209H\u0000¢\u0006\u0002\b:J\t\u0010;\u001a\u00020\u0004HÖ\u0001J\u0019\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u000201HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\"\u0010\u001eR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015¨\u0006C"}, d2 = {"Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "messageVersion", "", "threeDsServerTransId", "acsTransId", "sdkTransId", "Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "challengeDataEntry", "cancelReason", "Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData$CancelReason;", "challengeHtmlDataEntry", "messageExtensions", "", "Lcom/stripe/android/stripe3ds2/transactions/MessageExtension;", "oobContinue", "", "shouldResendChallenge", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;Ljava/lang/String;Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData$CancelReason;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getAcsTransId", "()Ljava/lang/String;", "getCancelReason", "()Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData$CancelReason;", "getChallengeDataEntry", "getChallengeHtmlDataEntry", "getMessageExtensions", "()Ljava/util/List;", "getMessageVersion", "getOobContinue", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSdkTransId", "()Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "getShouldResendChallenge", "getThreeDsServerTransId", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;Ljava/lang/String;Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData$CancelReason;Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData;", "describeContents", "", "equals", "other", "", "hashCode", "sanitize", "sanitize$3ds2sdk_release", "toJson", "Lorg/json/JSONObject;", "toJson$3ds2sdk_release", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CancelReason", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeRequestData.kt */
public final class ChallengeRequestData implements Serializable, Parcelable {
    public static final Parcelable.Creator<ChallengeRequestData> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FIELD_3DS_SERVER_TRANS_ID = "threeDSServerTransID";
    public static final String FIELD_ACS_TRANS_ID = "acsTransID";
    public static final String FIELD_CHALLENGE_CANCEL = "challengeCancel";
    public static final String FIELD_CHALLENGE_DATA_ENTRY = "challengeDataEntry";
    public static final String FIELD_CHALLENGE_HTML_DATA_ENTRY = "challengeHTMLDataEntry";
    public static final String FIELD_MESSAGE_EXTENSION = "messageExtensions";
    public static final String FIELD_MESSAGE_TYPE = "messageType";
    public static final String FIELD_MESSAGE_VERSION = "messageVersion";
    public static final String FIELD_OOB_CONTINUE = "oobContinue";
    public static final String FIELD_RESEND_CHALLENGE = "resendChallenge";
    public static final String FIELD_SDK_TRANS_ID = "sdkTransID";
    public static final String MESSAGE_TYPE = "CReq";
    private final String acsTransId;
    private final CancelReason cancelReason;
    private final String challengeDataEntry;
    private final String challengeHtmlDataEntry;
    private final List<MessageExtension> messageExtensions;
    private final String messageVersion;
    private final Boolean oobContinue;
    private final SdkTransactionId sdkTransId;
    private final Boolean shouldResendChallenge;
    private final String threeDsServerTransId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeRequestData.kt */
    public static final class Creator implements Parcelable.Creator<ChallengeRequestData> {
        public final ChallengeRequestData createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Boolean bool;
            Boolean bool2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            SdkTransactionId createFromParcel = SdkTransactionId.CREATOR.createFromParcel(parcel);
            String readString4 = parcel.readString();
            CancelReason valueOf = parcel.readInt() == 0 ? null : CancelReason.valueOf(parcel.readString());
            String readString5 = parcel.readString();
            boolean z = false;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(MessageExtension.CREATOR.createFromParcel(parcel));
                }
            }
            List list = arrayList;
            if (parcel.readInt() == 0) {
                bool = null;
            } else {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                bool2 = null;
            } else {
                if (parcel.readInt() != 0) {
                    z = true;
                }
                bool2 = Boolean.valueOf(z);
            }
            return new ChallengeRequestData(readString, readString2, readString3, createFromParcel, readString4, valueOf, readString5, list, bool, bool2);
        }

        public final ChallengeRequestData[] newArray(int i) {
            return new ChallengeRequestData[i];
        }
    }

    public static /* synthetic */ ChallengeRequestData copy$default(ChallengeRequestData challengeRequestData, String str, String str2, String str3, SdkTransactionId sdkTransactionId, String str4, CancelReason cancelReason2, String str5, List list, Boolean bool, Boolean bool2, int i, Object obj) {
        ChallengeRequestData challengeRequestData2 = challengeRequestData;
        int i2 = i;
        return challengeRequestData.copy((i2 & 1) != 0 ? challengeRequestData2.messageVersion : str, (i2 & 2) != 0 ? challengeRequestData2.threeDsServerTransId : str2, (i2 & 4) != 0 ? challengeRequestData2.acsTransId : str3, (i2 & 8) != 0 ? challengeRequestData2.sdkTransId : sdkTransactionId, (i2 & 16) != 0 ? challengeRequestData2.challengeDataEntry : str4, (i2 & 32) != 0 ? challengeRequestData2.cancelReason : cancelReason2, (i2 & 64) != 0 ? challengeRequestData2.challengeHtmlDataEntry : str5, (i2 & 128) != 0 ? challengeRequestData2.messageExtensions : list, (i2 & 256) != 0 ? challengeRequestData2.oobContinue : bool, (i2 & 512) != 0 ? challengeRequestData2.shouldResendChallenge : bool2);
    }

    public final String component1() {
        return this.messageVersion;
    }

    public final Boolean component10() {
        return this.shouldResendChallenge;
    }

    public final String component2() {
        return this.threeDsServerTransId;
    }

    public final String component3() {
        return this.acsTransId;
    }

    public final SdkTransactionId component4() {
        return this.sdkTransId;
    }

    public final String component5() {
        return this.challengeDataEntry;
    }

    public final CancelReason component6() {
        return this.cancelReason;
    }

    public final String component7() {
        return this.challengeHtmlDataEntry;
    }

    public final List<MessageExtension> component8() {
        return this.messageExtensions;
    }

    public final Boolean component9() {
        return this.oobContinue;
    }

    public final ChallengeRequestData copy(String str, String str2, String str3, SdkTransactionId sdkTransactionId, String str4, CancelReason cancelReason2, String str5, List<MessageExtension> list, Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(str, FIELD_MESSAGE_VERSION);
        Intrinsics.checkNotNullParameter(str2, "threeDsServerTransId");
        Intrinsics.checkNotNullParameter(str3, "acsTransId");
        SdkTransactionId sdkTransactionId2 = sdkTransactionId;
        Intrinsics.checkNotNullParameter(sdkTransactionId2, "sdkTransId");
        return new ChallengeRequestData(str, str2, str3, sdkTransactionId2, str4, cancelReason2, str5, list, bool, bool2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChallengeRequestData)) {
            return false;
        }
        ChallengeRequestData challengeRequestData = (ChallengeRequestData) obj;
        return Intrinsics.areEqual((Object) this.messageVersion, (Object) challengeRequestData.messageVersion) && Intrinsics.areEqual((Object) this.threeDsServerTransId, (Object) challengeRequestData.threeDsServerTransId) && Intrinsics.areEqual((Object) this.acsTransId, (Object) challengeRequestData.acsTransId) && Intrinsics.areEqual((Object) this.sdkTransId, (Object) challengeRequestData.sdkTransId) && Intrinsics.areEqual((Object) this.challengeDataEntry, (Object) challengeRequestData.challengeDataEntry) && this.cancelReason == challengeRequestData.cancelReason && Intrinsics.areEqual((Object) this.challengeHtmlDataEntry, (Object) challengeRequestData.challengeHtmlDataEntry) && Intrinsics.areEqual((Object) this.messageExtensions, (Object) challengeRequestData.messageExtensions) && Intrinsics.areEqual((Object) this.oobContinue, (Object) challengeRequestData.oobContinue) && Intrinsics.areEqual((Object) this.shouldResendChallenge, (Object) challengeRequestData.shouldResendChallenge);
    }

    public int hashCode() {
        int hashCode = ((((((this.messageVersion.hashCode() * 31) + this.threeDsServerTransId.hashCode()) * 31) + this.acsTransId.hashCode()) * 31) + this.sdkTransId.hashCode()) * 31;
        String str = this.challengeDataEntry;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        CancelReason cancelReason2 = this.cancelReason;
        int hashCode3 = (hashCode2 + (cancelReason2 == null ? 0 : cancelReason2.hashCode())) * 31;
        String str2 = this.challengeHtmlDataEntry;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<MessageExtension> list = this.messageExtensions;
        int hashCode5 = (hashCode4 + (list == null ? 0 : list.hashCode())) * 31;
        Boolean bool = this.oobContinue;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.shouldResendChallenge;
        if (bool2 != null) {
            i = bool2.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        return "ChallengeRequestData(messageVersion=" + this.messageVersion + ", threeDsServerTransId=" + this.threeDsServerTransId + ", acsTransId=" + this.acsTransId + ", sdkTransId=" + this.sdkTransId + ", challengeDataEntry=" + this.challengeDataEntry + ", cancelReason=" + this.cancelReason + ", challengeHtmlDataEntry=" + this.challengeHtmlDataEntry + ", messageExtensions=" + this.messageExtensions + ", oobContinue=" + this.oobContinue + ", shouldResendChallenge=" + this.shouldResendChallenge + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.messageVersion);
        parcel.writeString(this.threeDsServerTransId);
        parcel.writeString(this.acsTransId);
        this.sdkTransId.writeToParcel(parcel, i);
        parcel.writeString(this.challengeDataEntry);
        CancelReason cancelReason2 = this.cancelReason;
        if (cancelReason2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(cancelReason2.name());
        }
        parcel.writeString(this.challengeHtmlDataEntry);
        List<MessageExtension> list = this.messageExtensions;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (MessageExtension writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, i);
            }
        }
        Boolean bool = this.oobContinue;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.shouldResendChallenge;
        if (bool2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(bool2.booleanValue() ? 1 : 0);
    }

    public ChallengeRequestData(String str, String str2, String str3, SdkTransactionId sdkTransactionId, String str4, CancelReason cancelReason2, String str5, List<MessageExtension> list, Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(str, FIELD_MESSAGE_VERSION);
        Intrinsics.checkNotNullParameter(str2, "threeDsServerTransId");
        Intrinsics.checkNotNullParameter(str3, "acsTransId");
        Intrinsics.checkNotNullParameter(sdkTransactionId, "sdkTransId");
        this.messageVersion = str;
        this.threeDsServerTransId = str2;
        this.acsTransId = str3;
        this.sdkTransId = sdkTransactionId;
        this.challengeDataEntry = str4;
        this.cancelReason = cancelReason2;
        this.challengeHtmlDataEntry = str5;
        this.messageExtensions = list;
        this.oobContinue = bool;
        this.shouldResendChallenge = bool2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ChallengeRequestData(java.lang.String r15, java.lang.String r16, java.lang.String r17, com.stripe.android.stripe3ds2.transaction.SdkTransactionId r18, java.lang.String r19, com.stripe.android.stripe3ds2.transactions.ChallengeRequestData.CancelReason r20, java.lang.String r21, java.util.List r22, java.lang.Boolean r23, java.lang.Boolean r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r14 = this;
            r0 = r25
            r1 = r0 & 16
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r8 = r2
            goto L_0x000b
        L_0x0009:
            r8 = r19
        L_0x000b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0011
            r9 = r2
            goto L_0x0013
        L_0x0011:
            r9 = r20
        L_0x0013:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0019
            r10 = r2
            goto L_0x001b
        L_0x0019:
            r10 = r21
        L_0x001b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0021
            r11 = r2
            goto L_0x0023
        L_0x0021:
            r11 = r22
        L_0x0023:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0029
            r12 = r2
            goto L_0x002b
        L_0x0029:
            r12 = r23
        L_0x002b:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0031
            r13 = r2
            goto L_0x0033
        L_0x0031:
            r13 = r24
        L_0x0033:
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.stripe3ds2.transactions.ChallengeRequestData.<init>(java.lang.String, java.lang.String, java.lang.String, com.stripe.android.stripe3ds2.transaction.SdkTransactionId, java.lang.String, com.stripe.android.stripe3ds2.transactions.ChallengeRequestData$CancelReason, java.lang.String, java.util.List, java.lang.Boolean, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getMessageVersion() {
        return this.messageVersion;
    }

    public final String getThreeDsServerTransId() {
        return this.threeDsServerTransId;
    }

    public final String getAcsTransId() {
        return this.acsTransId;
    }

    public final SdkTransactionId getSdkTransId() {
        return this.sdkTransId;
    }

    public final String getChallengeDataEntry() {
        return this.challengeDataEntry;
    }

    public final CancelReason getCancelReason() {
        return this.cancelReason;
    }

    public final String getChallengeHtmlDataEntry() {
        return this.challengeHtmlDataEntry;
    }

    public final List<MessageExtension> getMessageExtensions() {
        return this.messageExtensions;
    }

    public final Boolean getOobContinue() {
        return this.oobContinue;
    }

    public final Boolean getShouldResendChallenge() {
        return this.shouldResendChallenge;
    }

    public final JSONObject toJson$3ds2sdk_release() {
        try {
            Result.Companion companion = Result.Companion;
            ChallengeRequestData challengeRequestData = this;
            JSONObject put = new JSONObject().put(FIELD_MESSAGE_TYPE, MESSAGE_TYPE).put(FIELD_MESSAGE_VERSION, challengeRequestData.getMessageVersion()).put(FIELD_SDK_TRANS_ID, challengeRequestData.getSdkTransId().getValue()).put(FIELD_3DS_SERVER_TRANS_ID, challengeRequestData.getThreeDsServerTransId()).put(FIELD_ACS_TRANS_ID, challengeRequestData.getAcsTransId());
            if (challengeRequestData.getCancelReason() != null) {
                put.put(FIELD_CHALLENGE_CANCEL, challengeRequestData.getCancelReason().getCode());
            }
            if (challengeRequestData.getChallengeDataEntry() != null) {
                put.put(FIELD_CHALLENGE_DATA_ENTRY, challengeRequestData.getChallengeDataEntry());
            }
            if (challengeRequestData.getChallengeHtmlDataEntry() != null) {
                put.put(FIELD_CHALLENGE_HTML_DATA_ENTRY, challengeRequestData.getChallengeHtmlDataEntry());
            }
            JSONArray jsonArray = MessageExtension.Companion.toJsonArray(challengeRequestData.getMessageExtensions());
            if (jsonArray != null) {
                put.put(FIELD_MESSAGE_EXTENSION, jsonArray);
            }
            if (challengeRequestData.getOobContinue() != null) {
                put.put(FIELD_OOB_CONTINUE, challengeRequestData.getOobContinue().booleanValue());
            }
            if (challengeRequestData.getShouldResendChallenge() != null) {
                put.put(FIELD_RESEND_CHALLENGE, challengeRequestData.getShouldResendChallenge().booleanValue() ? "Y" : "N");
            }
            Intrinsics.checkNotNullExpressionValue(put, "json");
            return put;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Throwable r0 = Result.m4712exceptionOrNullimpl(Result.m4709constructorimpl(ResultKt.createFailure(th)));
            if (r0 == null) {
                throw new KotlinNothingValueException();
            }
            throw new SDKRuntimeException(r0);
        }
    }

    public final ChallengeRequestData sanitize$3ds2sdk_release() {
        return copy$default(this, (String) null, (String) null, (String) null, (SdkTransactionId) null, (String) null, (CancelReason) null, (String) null, (List) null, (Boolean) null, (Boolean) null, 943, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData$CancelReason;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "UserSelected", "Reserved", "TransactionTimedOutDecoupled", "TransactionTimedOutOther", "TransactionTimedOutFirstCreq", "TransactionError", "Unknown", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeRequestData.kt */
    public enum CancelReason {
        UserSelected("01"),
        Reserved("02"),
        TransactionTimedOutDecoupled("03"),
        TransactionTimedOutOther("04"),
        TransactionTimedOutFirstCreq("05"),
        TransactionError("06"),
        Unknown("07");
        
        private final String code;

        private CancelReason(String str) {
            this.code = str;
        }

        public final String getCode() {
            return this.code;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/stripe3ds2/transactions/ChallengeRequestData$Companion;", "", "()V", "FIELD_3DS_SERVER_TRANS_ID", "", "FIELD_ACS_TRANS_ID", "FIELD_CHALLENGE_CANCEL", "FIELD_CHALLENGE_DATA_ENTRY", "FIELD_CHALLENGE_HTML_DATA_ENTRY", "FIELD_MESSAGE_EXTENSION", "FIELD_MESSAGE_TYPE", "FIELD_MESSAGE_VERSION", "FIELD_OOB_CONTINUE", "FIELD_RESEND_CHALLENGE", "FIELD_SDK_TRANS_ID", "MESSAGE_TYPE", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeRequestData.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
