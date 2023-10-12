package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.braintreepayments.api.models.PostalAddressParser;
import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.model.parsers.TokenJsonParser;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 +2\u00020\u0001:\u0001+BO\b\u0000\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003JQ\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u001fHÖ\u0001J\t\u0010%\u001a\u00020\u0007HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001fHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, d2 = {"Lcom/stripe/android/model/GooglePayResult;", "Landroid/os/Parcelable;", "token", "Lcom/stripe/android/model/Token;", "address", "Lcom/stripe/android/model/Address;", "name", "", "email", "phoneNumber", "shippingInformation", "Lcom/stripe/android/model/ShippingInformation;", "(Lcom/stripe/android/model/Token;Lcom/stripe/android/model/Address;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/ShippingInformation;)V", "getAddress", "()Lcom/stripe/android/model/Address;", "getEmail", "()Ljava/lang/String;", "getName", "getPhoneNumber", "getShippingInformation", "()Lcom/stripe/android/model/ShippingInformation;", "getToken", "()Lcom/stripe/android/model/Token;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GooglePayResult.kt */
public final class GooglePayResult implements Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<GooglePayResult> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Address address;
    private final String email;
    private final String name;
    private final String phoneNumber;
    private final ShippingInformation shippingInformation;
    private final Token token;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayResult.kt */
    public static final class Creator implements Parcelable.Creator<GooglePayResult> {
        public final GooglePayResult createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Token token = (Token) parcel.readParcelable(GooglePayResult.class.getClassLoader());
            ShippingInformation shippingInformation = null;
            Address createFromParcel = parcel.readInt() == 0 ? null : Address.CREATOR.createFromParcel(parcel);
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            if (parcel.readInt() != 0) {
                shippingInformation = ShippingInformation.CREATOR.createFromParcel(parcel);
            }
            return new GooglePayResult(token, createFromParcel, readString, readString2, readString3, shippingInformation);
        }

        public final GooglePayResult[] newArray(int i) {
            return new GooglePayResult[i];
        }
    }

    public GooglePayResult() {
        this((Token) null, (Address) null, (String) null, (String) null, (String) null, (ShippingInformation) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GooglePayResult copy$default(GooglePayResult googlePayResult, Token token2, Address address2, String str, String str2, String str3, ShippingInformation shippingInformation2, int i, Object obj) {
        if ((i & 1) != 0) {
            token2 = googlePayResult.token;
        }
        if ((i & 2) != 0) {
            address2 = googlePayResult.address;
        }
        Address address3 = address2;
        if ((i & 4) != 0) {
            str = googlePayResult.name;
        }
        String str4 = str;
        if ((i & 8) != 0) {
            str2 = googlePayResult.email;
        }
        String str5 = str2;
        if ((i & 16) != 0) {
            str3 = googlePayResult.phoneNumber;
        }
        String str6 = str3;
        if ((i & 32) != 0) {
            shippingInformation2 = googlePayResult.shippingInformation;
        }
        return googlePayResult.copy(token2, address3, str4, str5, str6, shippingInformation2);
    }

    @JvmStatic
    public static final GooglePayResult fromJson(JSONObject jSONObject) throws JSONException {
        return Companion.fromJson(jSONObject);
    }

    public final Token component1() {
        return this.token;
    }

    public final Address component2() {
        return this.address;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.email;
    }

    public final String component5() {
        return this.phoneNumber;
    }

    public final ShippingInformation component6() {
        return this.shippingInformation;
    }

    public final GooglePayResult copy(Token token2, Address address2, String str, String str2, String str3, ShippingInformation shippingInformation2) {
        return new GooglePayResult(token2, address2, str, str2, str3, shippingInformation2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GooglePayResult)) {
            return false;
        }
        GooglePayResult googlePayResult = (GooglePayResult) obj;
        return Intrinsics.areEqual((Object) this.token, (Object) googlePayResult.token) && Intrinsics.areEqual((Object) this.address, (Object) googlePayResult.address) && Intrinsics.areEqual((Object) this.name, (Object) googlePayResult.name) && Intrinsics.areEqual((Object) this.email, (Object) googlePayResult.email) && Intrinsics.areEqual((Object) this.phoneNumber, (Object) googlePayResult.phoneNumber) && Intrinsics.areEqual((Object) this.shippingInformation, (Object) googlePayResult.shippingInformation);
    }

    public int hashCode() {
        Token token2 = this.token;
        int i = 0;
        int hashCode = (token2 == null ? 0 : token2.hashCode()) * 31;
        Address address2 = this.address;
        int hashCode2 = (hashCode + (address2 == null ? 0 : address2.hashCode())) * 31;
        String str = this.name;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.email;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.phoneNumber;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        ShippingInformation shippingInformation2 = this.shippingInformation;
        if (shippingInformation2 != null) {
            i = shippingInformation2.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "GooglePayResult(token=" + this.token + ", address=" + this.address + ", name=" + this.name + ", email=" + this.email + ", phoneNumber=" + this.phoneNumber + ", shippingInformation=" + this.shippingInformation + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.token, i);
        Address address2 = this.address;
        if (address2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            address2.writeToParcel(parcel, i);
        }
        parcel.writeString(this.name);
        parcel.writeString(this.email);
        parcel.writeString(this.phoneNumber);
        ShippingInformation shippingInformation2 = this.shippingInformation;
        if (shippingInformation2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        shippingInformation2.writeToParcel(parcel, i);
    }

    public GooglePayResult(Token token2, Address address2, String str, String str2, String str3, ShippingInformation shippingInformation2) {
        this.token = token2;
        this.address = address2;
        this.name = str;
        this.email = str2;
        this.phoneNumber = str3;
        this.shippingInformation = shippingInformation2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GooglePayResult(com.stripe.android.model.Token r6, com.stripe.android.model.Address r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, com.stripe.android.model.ShippingInformation r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0007
            r13 = r0
            goto L_0x0008
        L_0x0007:
            r13 = r6
        L_0x0008:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r7
        L_0x000f:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r8
        L_0x0016:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r9
        L_0x001d:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r10
        L_0x0024:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002a
            r12 = r0
            goto L_0x002b
        L_0x002a:
            r12 = r11
        L_0x002b:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.GooglePayResult.<init>(com.stripe.android.model.Token, com.stripe.android.model.Address, java.lang.String, java.lang.String, java.lang.String, com.stripe.android.model.ShippingInformation, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Token getToken() {
        return this.token;
    }

    public final Address getAddress() {
        return this.address;
    }

    public final String getName() {
        return this.name;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final ShippingInformation getShippingInformation() {
        return this.shippingInformation;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\t"}, d2 = {"Lcom/stripe/android/model/GooglePayResult$Companion;", "", "()V", "createShippingInformation", "Lcom/stripe/android/model/ShippingInformation;", "paymentDataJson", "Lorg/json/JSONObject;", "fromJson", "Lcom/stripe/android/model/GooglePayResult;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: GooglePayResult.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GooglePayResult fromJson(JSONObject jSONObject) throws JSONException {
            Address address;
            Intrinsics.checkNotNullParameter(jSONObject, "paymentDataJson");
            JSONObject jSONObject2 = jSONObject.getJSONObject("paymentMethodData");
            Token parse = new TokenJsonParser().parse(new JSONObject(jSONObject2.getJSONObject("tokenizationData").getString("token")));
            JSONObject optJSONObject = jSONObject2.getJSONObject("info").optJSONObject("billingAddress");
            if (optJSONObject == null) {
                address = null;
            } else {
                address = new Address(StripeJsonUtils.optString(optJSONObject, PostalAddressParser.USER_ADDRESS_LOCALITY_KEY), StripeJsonUtils.optString(optJSONObject, "countryCode"), StripeJsonUtils.optString(optJSONObject, PostalAddressParser.USER_ADDRESS_ADDRESS_1_KEY), StripeJsonUtils.optString(optJSONObject, PostalAddressParser.USER_ADDRESS_ADDRESS_2_KEY), StripeJsonUtils.optString(optJSONObject, "postalCode"), StripeJsonUtils.optString(optJSONObject, PostalAddressParser.USER_ADDRESS_ADMINISTRATIVE_AREA_KEY));
            }
            return new GooglePayResult(parse, address, StripeJsonUtils.optString(optJSONObject, "name"), StripeJsonUtils.optString(jSONObject, "email"), StripeJsonUtils.optString(optJSONObject, "phoneNumber"), createShippingInformation(jSONObject));
        }

        private final ShippingInformation createShippingInformation(JSONObject jSONObject) {
            JSONObject optJSONObject = jSONObject.optJSONObject("shippingAddress");
            if (optJSONObject == null) {
                return null;
            }
            String optString = StripeJsonUtils.optString(optJSONObject, PostalAddressParser.USER_ADDRESS_ADDRESS_1_KEY);
            String optString2 = StripeJsonUtils.optString(optJSONObject, PostalAddressParser.USER_ADDRESS_ADDRESS_2_KEY);
            String optString3 = StripeJsonUtils.optString(optJSONObject, "postalCode");
            return new ShippingInformation(new Address(StripeJsonUtils.optString(optJSONObject, PostalAddressParser.USER_ADDRESS_LOCALITY_KEY), StripeJsonUtils.optString(optJSONObject, "countryCode"), optString, optString2, optString3, StripeJsonUtils.optString(optJSONObject, PostalAddressParser.USER_ADDRESS_ADMINISTRATIVE_AREA_KEY)), StripeJsonUtils.optString(optJSONObject, "name"), StripeJsonUtils.optString(optJSONObject, "phoneNumber"));
        }
    }
}
