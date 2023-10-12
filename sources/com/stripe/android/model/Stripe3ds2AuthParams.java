package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-BO\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0017\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÂ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÂ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÂ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÂ\u0003J\t\u0010\u001c\u001a\u00020\fHÂ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÂ\u0003Je\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u001f\u001a\u00020\fHÖ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\fHÖ\u0001J\u0014\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020#0&H\u0016J\t\u0010'\u001a\u00020\u0004HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\fHÖ\u0001R\u0014\u0010\u000f\u001a\u00020\u00108AX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/stripe/android/model/Stripe3ds2AuthParams;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "sourceId", "", "sdkAppId", "sdkReferenceNumber", "sdkTransactionId", "deviceData", "sdkEphemeralPublicKey", "messageVersion", "maxTimeout", "", "returnUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "appParams", "Lorg/json/JSONObject;", "getAppParams$payments_core_release", "()Lorg/json/JSONObject;", "deviceRenderOptions", "getDeviceRenderOptions", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Stripe3ds2AuthParams.kt */
public final class Stripe3ds2AuthParams implements StripeParamsModel, Parcelable {
    public static final Parcelable.Creator<Stripe3ds2AuthParams> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FIELD_APP = "app";
    private static final String FIELD_DEVICE_RENDER_OPTIONS = "deviceRenderOptions";
    public static final String FIELD_FALLBACK_RETURN_URL = "fallback_return_url";
    private static final String FIELD_MESSAGE_VERSION = "messageVersion";
    private static final String FIELD_SDK_APP_ID = "sdkAppID";
    private static final String FIELD_SDK_ENC_DATA = "sdkEncData";
    private static final String FIELD_SDK_EPHEM_PUB_KEY = "sdkEphemPubKey";
    private static final String FIELD_SDK_INTERFACE = "sdkInterface";
    private static final String FIELD_SDK_MAX_TIMEOUT = "sdkMaxTimeout";
    private static final String FIELD_SDK_REFERENCE_NUMBER = "sdkReferenceNumber";
    private static final String FIELD_SDK_TRANS_ID = "sdkTransID";
    private static final String FIELD_SDK_UI_TYPE = "sdkUiType";
    public static final String FIELD_SOURCE = "source";
    private final String deviceData;
    private final int maxTimeout;
    private final String messageVersion;
    private final String returnUrl;
    private final String sdkAppId;
    private final String sdkEphemeralPublicKey;
    private final String sdkReferenceNumber;
    private final String sdkTransactionId;
    private final String sourceId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Stripe3ds2AuthParams.kt */
    public static final class Creator implements Parcelable.Creator<Stripe3ds2AuthParams> {
        public final Stripe3ds2AuthParams createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Stripe3ds2AuthParams(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString());
        }

        public final Stripe3ds2AuthParams[] newArray(int i) {
            return new Stripe3ds2AuthParams[i];
        }
    }

    private final String component1() {
        return this.sourceId;
    }

    private final String component2() {
        return this.sdkAppId;
    }

    private final String component3() {
        return this.sdkReferenceNumber;
    }

    private final String component4() {
        return this.sdkTransactionId;
    }

    private final String component5() {
        return this.deviceData;
    }

    private final String component6() {
        return this.sdkEphemeralPublicKey;
    }

    private final String component7() {
        return this.messageVersion;
    }

    private final int component8() {
        return this.maxTimeout;
    }

    private final String component9() {
        return this.returnUrl;
    }

    public static /* synthetic */ Stripe3ds2AuthParams copy$default(Stripe3ds2AuthParams stripe3ds2AuthParams, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, int i2, Object obj) {
        Stripe3ds2AuthParams stripe3ds2AuthParams2 = stripe3ds2AuthParams;
        int i3 = i2;
        return stripe3ds2AuthParams.copy((i3 & 1) != 0 ? stripe3ds2AuthParams2.sourceId : str, (i3 & 2) != 0 ? stripe3ds2AuthParams2.sdkAppId : str2, (i3 & 4) != 0 ? stripe3ds2AuthParams2.sdkReferenceNumber : str3, (i3 & 8) != 0 ? stripe3ds2AuthParams2.sdkTransactionId : str4, (i3 & 16) != 0 ? stripe3ds2AuthParams2.deviceData : str5, (i3 & 32) != 0 ? stripe3ds2AuthParams2.sdkEphemeralPublicKey : str6, (i3 & 64) != 0 ? stripe3ds2AuthParams2.messageVersion : str7, (i3 & 128) != 0 ? stripe3ds2AuthParams2.maxTimeout : i, (i3 & 256) != 0 ? stripe3ds2AuthParams2.returnUrl : str8);
    }

    public final Stripe3ds2AuthParams copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8) {
        Intrinsics.checkNotNullParameter(str, "sourceId");
        Intrinsics.checkNotNullParameter(str2, "sdkAppId");
        Intrinsics.checkNotNullParameter(str3, FIELD_SDK_REFERENCE_NUMBER);
        Intrinsics.checkNotNullParameter(str4, "sdkTransactionId");
        String str9 = str5;
        Intrinsics.checkNotNullParameter(str9, "deviceData");
        String str10 = str6;
        Intrinsics.checkNotNullParameter(str10, "sdkEphemeralPublicKey");
        String str11 = str7;
        Intrinsics.checkNotNullParameter(str11, "messageVersion");
        return new Stripe3ds2AuthParams(str, str2, str3, str4, str9, str10, str11, i, str8);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Stripe3ds2AuthParams)) {
            return false;
        }
        Stripe3ds2AuthParams stripe3ds2AuthParams = (Stripe3ds2AuthParams) obj;
        return Intrinsics.areEqual((Object) this.sourceId, (Object) stripe3ds2AuthParams.sourceId) && Intrinsics.areEqual((Object) this.sdkAppId, (Object) stripe3ds2AuthParams.sdkAppId) && Intrinsics.areEqual((Object) this.sdkReferenceNumber, (Object) stripe3ds2AuthParams.sdkReferenceNumber) && Intrinsics.areEqual((Object) this.sdkTransactionId, (Object) stripe3ds2AuthParams.sdkTransactionId) && Intrinsics.areEqual((Object) this.deviceData, (Object) stripe3ds2AuthParams.deviceData) && Intrinsics.areEqual((Object) this.sdkEphemeralPublicKey, (Object) stripe3ds2AuthParams.sdkEphemeralPublicKey) && Intrinsics.areEqual((Object) this.messageVersion, (Object) stripe3ds2AuthParams.messageVersion) && this.maxTimeout == stripe3ds2AuthParams.maxTimeout && Intrinsics.areEqual((Object) this.returnUrl, (Object) stripe3ds2AuthParams.returnUrl);
    }

    public int hashCode() {
        int hashCode = ((((((((((((((this.sourceId.hashCode() * 31) + this.sdkAppId.hashCode()) * 31) + this.sdkReferenceNumber.hashCode()) * 31) + this.sdkTransactionId.hashCode()) * 31) + this.deviceData.hashCode()) * 31) + this.sdkEphemeralPublicKey.hashCode()) * 31) + this.messageVersion.hashCode()) * 31) + this.maxTimeout) * 31;
        String str = this.returnUrl;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Stripe3ds2AuthParams(sourceId=" + this.sourceId + ", sdkAppId=" + this.sdkAppId + ", sdkReferenceNumber=" + this.sdkReferenceNumber + ", sdkTransactionId=" + this.sdkTransactionId + ", deviceData=" + this.deviceData + ", sdkEphemeralPublicKey=" + this.sdkEphemeralPublicKey + ", messageVersion=" + this.messageVersion + ", maxTimeout=" + this.maxTimeout + ", returnUrl=" + this.returnUrl + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.sourceId);
        parcel.writeString(this.sdkAppId);
        parcel.writeString(this.sdkReferenceNumber);
        parcel.writeString(this.sdkTransactionId);
        parcel.writeString(this.deviceData);
        parcel.writeString(this.sdkEphemeralPublicKey);
        parcel.writeString(this.messageVersion);
        parcel.writeInt(this.maxTimeout);
        parcel.writeString(this.returnUrl);
    }

    public Stripe3ds2AuthParams(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8) {
        Intrinsics.checkNotNullParameter(str, "sourceId");
        Intrinsics.checkNotNullParameter(str2, "sdkAppId");
        Intrinsics.checkNotNullParameter(str3, FIELD_SDK_REFERENCE_NUMBER);
        Intrinsics.checkNotNullParameter(str4, "sdkTransactionId");
        Intrinsics.checkNotNullParameter(str5, "deviceData");
        Intrinsics.checkNotNullParameter(str6, "sdkEphemeralPublicKey");
        Intrinsics.checkNotNullParameter(str7, "messageVersion");
        this.sourceId = str;
        this.sdkAppId = str2;
        this.sdkReferenceNumber = str3;
        this.sdkTransactionId = str4;
        this.deviceData = str5;
        this.sdkEphemeralPublicKey = str6;
        this.messageVersion = str7;
        this.maxTimeout = i;
        this.returnUrl = str8;
    }

    public Map<String, Object> toParamMap() {
        Map map;
        Map mapOf = MapsKt.mapOf(TuplesKt.to("source", this.sourceId), TuplesKt.to(FIELD_APP, getAppParams$payments_core_release().toString()));
        String str = this.returnUrl;
        if (str == null) {
            map = null;
        } else {
            map = MapsKt.mapOf(TuplesKt.to(FIELD_FALLBACK_RETURN_URL, str));
        }
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        return MapsKt.plus(mapOf, map);
    }

    public final /* synthetic */ JSONObject getAppParams$payments_core_release() {
        JSONObject jSONObject;
        try {
            Result.Companion companion = Result.Companion;
            Stripe3ds2AuthParams stripe3ds2AuthParams = this;
            jSONObject = Result.m4709constructorimpl(new JSONObject().put(FIELD_SDK_APP_ID, stripe3ds2AuthParams.sdkAppId).put("sdkTransID", stripe3ds2AuthParams.sdkTransactionId).put(FIELD_SDK_ENC_DATA, stripe3ds2AuthParams.deviceData).put("sdkEphemPubKey", new JSONObject(stripe3ds2AuthParams.sdkEphemeralPublicKey)).put(FIELD_SDK_MAX_TIMEOUT, StringsKt.padStart(String.valueOf(stripe3ds2AuthParams.maxTimeout), 2, '0')).put(FIELD_SDK_REFERENCE_NUMBER, stripe3ds2AuthParams.sdkReferenceNumber).put("messageVersion", stripe3ds2AuthParams.messageVersion).put(FIELD_DEVICE_RENDER_OPTIONS, stripe3ds2AuthParams.getDeviceRenderOptions()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            jSONObject = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        JSONObject jSONObject2 = new JSONObject();
        if (Result.m4715isFailureimpl(jSONObject)) {
            jSONObject = jSONObject2;
        }
        return (JSONObject) jSONObject;
    }

    private final JSONObject getDeviceRenderOptions() {
        JSONObject jSONObject;
        try {
            Result.Companion companion = Result.Companion;
            Stripe3ds2AuthParams stripe3ds2AuthParams = this;
            jSONObject = Result.m4709constructorimpl(new JSONObject().put(FIELD_SDK_INTERFACE, "03").put(FIELD_SDK_UI_TYPE, new JSONArray(CollectionsKt.listOf("01", "02", "03", "04", "05"))));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            jSONObject = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        JSONObject jSONObject2 = new JSONObject();
        if (Result.m4715isFailureimpl(jSONObject)) {
            jSONObject = jSONObject2;
        }
        return (JSONObject) jSONObject;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/model/Stripe3ds2AuthParams$Companion;", "", "()V", "FIELD_APP", "", "FIELD_DEVICE_RENDER_OPTIONS", "FIELD_FALLBACK_RETURN_URL", "FIELD_MESSAGE_VERSION", "FIELD_SDK_APP_ID", "FIELD_SDK_ENC_DATA", "FIELD_SDK_EPHEM_PUB_KEY", "FIELD_SDK_INTERFACE", "FIELD_SDK_MAX_TIMEOUT", "FIELD_SDK_REFERENCE_NUMBER", "FIELD_SDK_TRANS_ID", "FIELD_SDK_UI_TYPE", "FIELD_SOURCE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Stripe3ds2AuthParams.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
