package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.drew.metadata.exif.makernotes.CanonMakernoteDirectory;
import com.stripe.android.CardUtils;
import com.stripe.android.model.Token;
import com.stripe.android.model.parsers.AccountRangeJsonParser;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 M2\u00020\u0001:\u0001MBg\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\u0002\u0010\u000eB\b\u0000\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r¢\u0006\u0002\u0010\u0013J\t\u00103\u001a\u00020\u0010HÆ\u0003J\u0017\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012HÂ\u0003J\u000e\u00106\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b7J\u000e\u00108\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b9J\u000e\u0010:\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b;J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b=J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rHÆ\u0001J\t\u0010B\u001a\u00020\u0005HÖ\u0001J\u0013\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u000101HÖ\u0003J\t\u0010F\u001a\u00020\u0005HÖ\u0001J\t\u0010G\u001a\u00020\u0003HÖ\u0001J\u0019\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\u0011\u0010&\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b'\u0010\u001bR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0012X\u0004¢\u0006\u0002\n\u0000R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001b\"\u0004\b-\u0010\u001dR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001b\"\u0004\b/\u0010\u001dR \u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002010\r8VX\u0004¢\u0006\u0006\u001a\u0004\b2\u0010)¨\u0006N"}, d2 = {"Lcom/stripe/android/model/CardParams;", "Lcom/stripe/android/model/TokenParams;", "number", "", "expMonth", "", "expYear", "cvc", "name", "address", "Lcom/stripe/android/model/Address;", "currency", "metadata", "", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/Address;Ljava/lang/String;Ljava/util/Map;)V", "brand", "Lcom/stripe/android/model/CardBrand;", "loggingTokens", "", "(Lcom/stripe/android/model/CardBrand;Ljava/util/Set;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/Address;Ljava/lang/String;Ljava/util/Map;)V", "getAddress", "()Lcom/stripe/android/model/Address;", "setAddress", "(Lcom/stripe/android/model/Address;)V", "getBrand", "()Lcom/stripe/android/model/CardBrand;", "getCurrency", "()Ljava/lang/String;", "setCurrency", "(Ljava/lang/String;)V", "getCvc$payments_core_release", "setCvc$payments_core_release", "getExpMonth$payments_core_release", "()I", "setExpMonth$payments_core_release", "(I)V", "getExpYear$payments_core_release", "setExpYear$payments_core_release", "last4", "getLast4", "getMetadata", "()Ljava/util/Map;", "setMetadata", "(Ljava/util/Map;)V", "getName", "setName", "getNumber$payments_core_release", "setNumber$payments_core_release", "typeDataParams", "", "getTypeDataParams", "component1", "component10", "component2", "component3", "component3$payments_core_release", "component4", "component4$payments_core_release", "component5", "component5$payments_core_release", "component6", "component6$payments_core_release", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardParams.kt */
public final class CardParams extends TokenParams {
    public static final int $stable = 8;
    public static final Parcelable.Creator<CardParams> CREATOR = new Creator();
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String PARAM_ADDRESS_CITY = "address_city";
    @Deprecated
    private static final String PARAM_ADDRESS_COUNTRY = "address_country";
    @Deprecated
    private static final String PARAM_ADDRESS_LINE1 = "address_line1";
    @Deprecated
    private static final String PARAM_ADDRESS_LINE2 = "address_line2";
    @Deprecated
    private static final String PARAM_ADDRESS_STATE = "address_state";
    @Deprecated
    private static final String PARAM_ADDRESS_ZIP = "address_zip";
    @Deprecated
    private static final String PARAM_CURRENCY = "currency";
    @Deprecated
    private static final String PARAM_CVC = "cvc";
    @Deprecated
    private static final String PARAM_EXP_MONTH = "exp_month";
    @Deprecated
    private static final String PARAM_EXP_YEAR = "exp_year";
    @Deprecated
    private static final String PARAM_METADATA = "metadata";
    @Deprecated
    private static final String PARAM_NAME = "name";
    @Deprecated
    private static final String PARAM_NUMBER = "number";
    private Address address;
    private final CardBrand brand;
    private String currency;
    private String cvc;
    private int expMonth;
    private int expYear;
    private final Set<String> loggingTokens;
    private Map<String, String> metadata;
    private String name;
    private String number;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardParams.kt */
    public static final class Creator implements Parcelable.Creator<CardParams> {
        public final CardParams createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            CardBrand valueOf = CardBrand.valueOf(parcel.readString());
            int readInt = parcel.readInt();
            LinkedHashSet linkedHashSet = new LinkedHashSet(readInt);
            for (int i = 0; i != readInt; i++) {
                linkedHashSet.add(parcel.readString());
            }
            Set set = linkedHashSet;
            String readString = parcel.readString();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            LinkedHashMap linkedHashMap = null;
            Address createFromParcel = parcel.readInt() == 0 ? null : Address.CREATOR.createFromParcel(parcel);
            String readString4 = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt4 = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt4);
                for (int i2 = 0; i2 != readInt4; i2++) {
                    linkedHashMap.put(parcel.readString(), parcel.readString());
                }
            }
            return new CardParams(valueOf, (Set<String>) set, readString, readInt2, readInt3, readString2, readString3, createFromParcel, readString4, (Map<String, String>) linkedHashMap);
        }

        public final CardParams[] newArray(int i) {
            return new CardParams[i];
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardParams(String str, int i, int i2) {
        this(str, i, i2, (String) null, (String) null, (Address) null, (String) null, (Map) null, 248, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, PARAM_NUMBER);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardParams(String str, int i, int i2, String str2) {
        this(str, i, i2, str2, (String) null, (Address) null, (String) null, (Map) null, 240, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, PARAM_NUMBER);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardParams(String str, int i, int i2, String str2, String str3) {
        this(str, i, i2, str2, str3, (Address) null, (String) null, (Map) null, (int) CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, PARAM_NUMBER);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardParams(String str, int i, int i2, String str2, String str3, Address address2) {
        this(str, i, i2, str2, str3, address2, (String) null, (Map) null, 192, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, PARAM_NUMBER);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardParams(String str, int i, int i2, String str2, String str3, Address address2, String str4) {
        this(str, i, i2, str2, str3, address2, str4, (Map) null, 128, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, PARAM_NUMBER);
    }

    private final Set<String> component2() {
        return this.loggingTokens;
    }

    public static /* synthetic */ CardParams copy$default(CardParams cardParams, CardBrand cardBrand, Set set, String str, int i, int i2, String str2, String str3, Address address2, String str4, Map map, int i3, Object obj) {
        CardParams cardParams2 = cardParams;
        int i4 = i3;
        return cardParams.copy((i4 & 1) != 0 ? cardParams2.brand : cardBrand, (i4 & 2) != 0 ? cardParams2.loggingTokens : set, (i4 & 4) != 0 ? cardParams2.number : str, (i4 & 8) != 0 ? cardParams2.expMonth : i, (i4 & 16) != 0 ? cardParams2.expYear : i2, (i4 & 32) != 0 ? cardParams2.cvc : str2, (i4 & 64) != 0 ? cardParams2.name : str3, (i4 & 128) != 0 ? cardParams2.address : address2, (i4 & 256) != 0 ? cardParams2.currency : str4, (i4 & 512) != 0 ? cardParams2.metadata : map);
    }

    public final CardBrand component1() {
        return this.brand;
    }

    public final Map<String, String> component10() {
        return this.metadata;
    }

    public final String component3$payments_core_release() {
        return this.number;
    }

    public final int component4$payments_core_release() {
        return this.expMonth;
    }

    public final int component5$payments_core_release() {
        return this.expYear;
    }

    public final String component6$payments_core_release() {
        return this.cvc;
    }

    public final String component7() {
        return this.name;
    }

    public final Address component8() {
        return this.address;
    }

    public final String component9() {
        return this.currency;
    }

    public final CardParams copy(CardBrand cardBrand, Set<String> set, String str, int i, int i2, String str2, String str3, Address address2, String str4, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(cardBrand, AccountRangeJsonParser.FIELD_BRAND);
        Intrinsics.checkNotNullParameter(set, "loggingTokens");
        Intrinsics.checkNotNullParameter(str, PARAM_NUMBER);
        return new CardParams(cardBrand, set, str, i, i2, str2, str3, address2, str4, map);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardParams)) {
            return false;
        }
        CardParams cardParams = (CardParams) obj;
        return this.brand == cardParams.brand && Intrinsics.areEqual((Object) this.loggingTokens, (Object) cardParams.loggingTokens) && Intrinsics.areEqual((Object) this.number, (Object) cardParams.number) && this.expMonth == cardParams.expMonth && this.expYear == cardParams.expYear && Intrinsics.areEqual((Object) this.cvc, (Object) cardParams.cvc) && Intrinsics.areEqual((Object) this.name, (Object) cardParams.name) && Intrinsics.areEqual((Object) this.address, (Object) cardParams.address) && Intrinsics.areEqual((Object) this.currency, (Object) cardParams.currency) && Intrinsics.areEqual((Object) this.metadata, (Object) cardParams.metadata);
    }

    public int hashCode() {
        int hashCode = ((((((((this.brand.hashCode() * 31) + this.loggingTokens.hashCode()) * 31) + this.number.hashCode()) * 31) + this.expMonth) * 31) + this.expYear) * 31;
        String str = this.cvc;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.name;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Address address2 = this.address;
        int hashCode4 = (hashCode3 + (address2 == null ? 0 : address2.hashCode())) * 31;
        String str3 = this.currency;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Map<String, String> map = this.metadata;
        if (map != null) {
            i = map.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "CardParams(brand=" + this.brand + ", loggingTokens=" + this.loggingTokens + ", number=" + this.number + ", expMonth=" + this.expMonth + ", expYear=" + this.expYear + ", cvc=" + this.cvc + ", name=" + this.name + ", address=" + this.address + ", currency=" + this.currency + ", metadata=" + this.metadata + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.brand.name());
        Set<String> set = this.loggingTokens;
        parcel.writeInt(set.size());
        for (String writeString : set) {
            parcel.writeString(writeString);
        }
        parcel.writeString(this.number);
        parcel.writeInt(this.expMonth);
        parcel.writeInt(this.expYear);
        parcel.writeString(this.cvc);
        parcel.writeString(this.name);
        Address address2 = this.address;
        if (address2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            address2.writeToParcel(parcel, i);
        }
        parcel.writeString(this.currency);
        Map<String, String> map = this.metadata;
        if (map == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(map.size());
        for (Map.Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeString((String) next.getValue());
        }
    }

    public final CardBrand getBrand() {
        return this.brand;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CardParams(com.stripe.android.model.CardBrand r14, java.util.Set r15, java.lang.String r16, int r17, int r18, java.lang.String r19, java.lang.String r20, com.stripe.android.model.Address r21, java.lang.String r22, java.util.Map r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
        /*
            r13 = this;
            r0 = r24
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000c
            java.util.Set r1 = kotlin.collections.SetsKt.emptySet()
            r4 = r1
            goto L_0x000d
        L_0x000c:
            r4 = r15
        L_0x000d:
            r1 = r0 & 32
            r2 = 0
            if (r1 == 0) goto L_0x0014
            r8 = r2
            goto L_0x0016
        L_0x0014:
            r8 = r19
        L_0x0016:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x001c
            r9 = r2
            goto L_0x001e
        L_0x001c:
            r9 = r20
        L_0x001e:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0024
            r10 = r2
            goto L_0x0026
        L_0x0024:
            r10 = r21
        L_0x0026:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x002c
            r11 = r2
            goto L_0x002e
        L_0x002c:
            r11 = r22
        L_0x002e:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0034
            r12 = r2
            goto L_0x0036
        L_0x0034:
            r12 = r23
        L_0x0036:
            r2 = r13
            r3 = r14
            r5 = r16
            r6 = r17
            r7 = r18
            r2.<init>((com.stripe.android.model.CardBrand) r3, (java.util.Set<java.lang.String>) r4, (java.lang.String) r5, (int) r6, (int) r7, (java.lang.String) r8, (java.lang.String) r9, (com.stripe.android.model.Address) r10, (java.lang.String) r11, (java.util.Map<java.lang.String, java.lang.String>) r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.CardParams.<init>(com.stripe.android.model.CardBrand, java.util.Set, java.lang.String, int, int, java.lang.String, java.lang.String, com.stripe.android.model.Address, java.lang.String, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getNumber$payments_core_release() {
        return this.number;
    }

    public final void setNumber$payments_core_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.number = str;
    }

    public final int getExpMonth$payments_core_release() {
        return this.expMonth;
    }

    public final void setExpMonth$payments_core_release(int i) {
        this.expMonth = i;
    }

    public final int getExpYear$payments_core_release() {
        return this.expYear;
    }

    public final void setExpYear$payments_core_release(int i) {
        this.expYear = i;
    }

    public final String getCvc$payments_core_release() {
        return this.cvc;
    }

    public final void setCvc$payments_core_release(String str) {
        this.cvc = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final Address getAddress() {
        return this.address;
    }

    public final void setAddress(Address address2) {
        this.address = address2;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final Map<String, String> getMetadata() {
        return this.metadata;
    }

    public final void setMetadata(Map<String, String> map) {
        this.metadata = map;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardParams(CardBrand cardBrand, Set<String> set, String str, int i, int i2, String str2, String str3, Address address2, String str4, Map<String, String> map) {
        super(Token.Type.Card, set);
        Intrinsics.checkNotNullParameter(cardBrand, AccountRangeJsonParser.FIELD_BRAND);
        Intrinsics.checkNotNullParameter(set, "loggingTokens");
        Intrinsics.checkNotNullParameter(str, PARAM_NUMBER);
        this.brand = cardBrand;
        this.loggingTokens = set;
        this.number = str;
        this.expMonth = i;
        this.expYear = i2;
        this.cvc = str2;
        this.name = str3;
        this.address = address2;
        this.currency = str4;
        this.metadata = map;
    }

    public final String getLast4() {
        return StringsKt.takeLast(this.number, 4);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CardParams(java.lang.String r13, int r14, int r15, java.lang.String r16, java.lang.String r17, com.stripe.android.model.Address r18, java.lang.String r19, java.util.Map r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r12 = this;
            r0 = r21
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r7 = r2
            goto L_0x000b
        L_0x0009:
            r7 = r16
        L_0x000b:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0011
            r8 = r2
            goto L_0x0013
        L_0x0011:
            r8 = r17
        L_0x0013:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0019
            r9 = r2
            goto L_0x001b
        L_0x0019:
            r9 = r18
        L_0x001b:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0021
            r10 = r2
            goto L_0x0023
        L_0x0021:
            r10 = r19
        L_0x0023:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0029
            r11 = r2
            goto L_0x002b
        L_0x0029:
            r11 = r20
        L_0x002b:
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.CardParams.<init>(java.lang.String, int, int, java.lang.String, java.lang.String, com.stripe.android.model.Address, java.lang.String, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardParams(String str, int i, int i2, String str2, String str3, Address address2, String str4, Map<String, String> map) {
        this(CardUtils.getPossibleCardBrand(str), (Set<String>) SetsKt.emptySet(), str, i, i2, str2, str3, address2, str4, map);
        Intrinsics.checkNotNullParameter(str, PARAM_NUMBER);
    }

    public Map<String, Object> getTypeDataParams() {
        Map map;
        Pair[] pairArr = new Pair[13];
        pairArr[0] = TuplesKt.to(PARAM_NUMBER, this.number);
        pairArr[1] = TuplesKt.to(PARAM_EXP_MONTH, Integer.valueOf(this.expMonth));
        pairArr[2] = TuplesKt.to(PARAM_EXP_YEAR, Integer.valueOf(this.expYear));
        pairArr[3] = TuplesKt.to(PARAM_CVC, this.cvc);
        pairArr[4] = TuplesKt.to("name", this.name);
        pairArr[5] = TuplesKt.to("currency", this.currency);
        Address address2 = this.address;
        pairArr[6] = TuplesKt.to(PARAM_ADDRESS_LINE1, address2 == null ? null : address2.getLine1());
        Address address3 = this.address;
        pairArr[7] = TuplesKt.to(PARAM_ADDRESS_LINE2, address3 == null ? null : address3.getLine2());
        Address address4 = this.address;
        pairArr[8] = TuplesKt.to(PARAM_ADDRESS_CITY, address4 == null ? null : address4.getCity());
        Address address5 = this.address;
        pairArr[9] = TuplesKt.to(PARAM_ADDRESS_STATE, address5 == null ? null : address5.getState());
        Address address6 = this.address;
        pairArr[10] = TuplesKt.to(PARAM_ADDRESS_ZIP, address6 == null ? null : address6.getPostalCode());
        Address address7 = this.address;
        pairArr[11] = TuplesKt.to(PARAM_ADDRESS_COUNTRY, address7 == null ? null : address7.getCountry());
        pairArr[12] = TuplesKt.to("metadata", this.metadata);
        Map<String, Object> emptyMap = MapsKt.emptyMap();
        for (Pair pair : CollectionsKt.listOf(pairArr)) {
            String str = (String) pair.component1();
            Object component2 = pair.component2();
            if (component2 == null) {
                map = null;
            } else {
                map = MapsKt.mapOf(TuplesKt.to(str, component2));
            }
            if (map == null) {
                map = MapsKt.emptyMap();
            }
            emptyMap = MapsKt.plus(emptyMap, (Map<String, Object>) map);
        }
        return emptyMap;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/model/CardParams$Companion;", "", "()V", "PARAM_ADDRESS_CITY", "", "PARAM_ADDRESS_COUNTRY", "PARAM_ADDRESS_LINE1", "PARAM_ADDRESS_LINE2", "PARAM_ADDRESS_STATE", "PARAM_ADDRESS_ZIP", "PARAM_CURRENCY", "PARAM_CVC", "PARAM_EXP_MONTH", "PARAM_EXP_YEAR", "PARAM_METADATA", "PARAM_NAME", "PARAM_NUMBER", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardParams.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
