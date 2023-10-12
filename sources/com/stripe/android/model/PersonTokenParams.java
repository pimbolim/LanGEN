package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.ObjectBuilder;
import com.stripe.android.model.Token;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\b\u0018\u0000 [2\u00020\u0001:\u0005Z[\\]^Bõ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cJ\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0017\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0015HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\nHÆ\u0003Jù\u0001\u0010M\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÆ\u0001J\t\u0010N\u001a\u00020OHÖ\u0001J\u0013\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u000106HÖ\u0003J\t\u0010S\u001a\u00020OHÖ\u0001J\t\u0010T\u001a\u00020\nHÖ\u0001J\u0019\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020OHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0013\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0013\u0010\r\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%R\u001f\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b1\u0010%R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b4\u0010%R \u00105\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002060\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b7\u00100R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\b\n\u0000\u001a\u0004\b8\u00109¨\u0006_"}, d2 = {"Lcom/stripe/android/model/PersonTokenParams;", "Lcom/stripe/android/model/TokenParams;", "address", "Lcom/stripe/android/model/Address;", "addressKana", "Lcom/stripe/android/model/AddressJapanParams;", "addressKanji", "dateOfBirth", "Lcom/stripe/android/model/DateOfBirth;", "email", "", "firstName", "firstNameKana", "firstNameKanji", "gender", "idNumber", "lastName", "lastNameKana", "lastNameKanji", "maidenName", "metadata", "", "phone", "relationship", "Lcom/stripe/android/model/PersonTokenParams$Relationship;", "ssnLast4", "verification", "Lcom/stripe/android/model/PersonTokenParams$Verification;", "(Lcom/stripe/android/model/Address;Lcom/stripe/android/model/AddressJapanParams;Lcom/stripe/android/model/AddressJapanParams;Lcom/stripe/android/model/DateOfBirth;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lcom/stripe/android/model/PersonTokenParams$Relationship;Ljava/lang/String;Lcom/stripe/android/model/PersonTokenParams$Verification;)V", "getAddress", "()Lcom/stripe/android/model/Address;", "getAddressKana", "()Lcom/stripe/android/model/AddressJapanParams;", "getAddressKanji", "getDateOfBirth", "()Lcom/stripe/android/model/DateOfBirth;", "getEmail", "()Ljava/lang/String;", "getFirstName", "getFirstNameKana", "getFirstNameKanji", "getGender", "getIdNumber", "getLastName", "getLastNameKana", "getLastNameKanji", "getMaidenName", "getMetadata", "()Ljava/util/Map;", "getPhone", "getRelationship", "()Lcom/stripe/android/model/PersonTokenParams$Relationship;", "getSsnLast4", "typeDataParams", "", "getTypeDataParams", "getVerification", "()Lcom/stripe/android/model/PersonTokenParams$Verification;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Builder", "Companion", "Document", "Relationship", "Verification", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonTokenParams.kt */
public final class PersonTokenParams extends TokenParams {
    public static final int $stable = 8;
    public static final Parcelable.Creator<PersonTokenParams> CREATOR = new Creator();
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String PARAM_ADDRESS = "address";
    @Deprecated
    private static final String PARAM_ADDRESS_KANA = "address_kana";
    @Deprecated
    private static final String PARAM_ADDRESS_KANJI = "address_kanji";
    @Deprecated
    private static final String PARAM_DOB = "dob";
    @Deprecated
    private static final String PARAM_EMAIL = "email";
    @Deprecated
    private static final String PARAM_FIRST_NAME = "first_name";
    @Deprecated
    private static final String PARAM_FIRST_NAME_KANA = "first_name_kana";
    @Deprecated
    private static final String PARAM_FIRST_NAME_KANJI = "first_name_kanji";
    @Deprecated
    private static final String PARAM_GENDER = "gender";
    @Deprecated
    private static final String PARAM_ID_NUMBER = "id_number";
    @Deprecated
    private static final String PARAM_LAST_NAME = "last_name";
    @Deprecated
    private static final String PARAM_LAST_NAME_KANA = "last_name_kana";
    @Deprecated
    private static final String PARAM_LAST_NAME_KANJI = "last_name_kanji";
    @Deprecated
    private static final String PARAM_MAIDEN_NAME = "maiden_name";
    @Deprecated
    private static final String PARAM_METADATA = "metadata";
    @Deprecated
    private static final String PARAM_PERSON = "person";
    @Deprecated
    private static final String PARAM_PHONE = "phone";
    @Deprecated
    private static final String PARAM_RELATIONSHIP = "relationship";
    @Deprecated
    private static final String PARAM_SSN_LAST_4 = "ssn_last_4";
    @Deprecated
    private static final String PARAM_VERIFICATION = "verification";
    private final Address address;
    private final AddressJapanParams addressKana;
    private final AddressJapanParams addressKanji;
    private final DateOfBirth dateOfBirth;
    private final String email;
    private final String firstName;
    private final String firstNameKana;
    private final String firstNameKanji;
    private final String gender;
    private final String idNumber;
    private final String lastName;
    private final String lastNameKana;
    private final String lastNameKanji;
    private final String maidenName;
    private final Map<String, String> metadata;
    private final String phone;
    private final Relationship relationship;
    private final String ssnLast4;
    private final Verification verification;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PersonTokenParams.kt */
    public static final class Creator implements Parcelable.Creator<PersonTokenParams> {
        public final PersonTokenParams createFromParcel(Parcel parcel) {
            String str;
            LinkedHashMap linkedHashMap;
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            Address createFromParcel = parcel.readInt() == 0 ? null : Address.CREATOR.createFromParcel(parcel2);
            AddressJapanParams createFromParcel2 = parcel.readInt() == 0 ? null : AddressJapanParams.CREATOR.createFromParcel(parcel2);
            AddressJapanParams createFromParcel3 = parcel.readInt() == 0 ? null : AddressJapanParams.CREATOR.createFromParcel(parcel2);
            DateOfBirth createFromParcel4 = parcel.readInt() == 0 ? null : DateOfBirth.CREATOR.createFromParcel(parcel2);
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
            if (parcel.readInt() == 0) {
                str = readString8;
                linkedHashMap = null;
            } else {
                int readInt = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt);
                int i = 0;
                while (i != readInt) {
                    linkedHashMap.put(parcel.readString(), parcel.readString());
                    i++;
                    readInt = readInt;
                    readString8 = readString8;
                }
                str = readString8;
            }
            return new PersonTokenParams(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, readString, readString2, readString3, readString4, readString5, readString6, readString7, str, readString9, readString10, linkedHashMap, parcel.readString(), parcel.readInt() == 0 ? null : Relationship.CREATOR.createFromParcel(parcel2), parcel.readString(), parcel.readInt() == 0 ? null : Verification.CREATOR.createFromParcel(parcel2));
        }

        public final PersonTokenParams[] newArray(int i) {
            return new PersonTokenParams[i];
        }
    }

    public PersonTokenParams() {
        this((Address) null, (AddressJapanParams) null, (AddressJapanParams) null, (DateOfBirth) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Map) null, (String) null, (Relationship) null, (String) null, (Verification) null, 524287, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PersonTokenParams copy$default(PersonTokenParams personTokenParams, Address address2, AddressJapanParams addressJapanParams, AddressJapanParams addressJapanParams2, DateOfBirth dateOfBirth2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Map map, String str11, Relationship relationship2, String str12, Verification verification2, int i, Object obj) {
        PersonTokenParams personTokenParams2 = personTokenParams;
        int i2 = i;
        return personTokenParams.copy((i2 & 1) != 0 ? personTokenParams2.address : address2, (i2 & 2) != 0 ? personTokenParams2.addressKana : addressJapanParams, (i2 & 4) != 0 ? personTokenParams2.addressKanji : addressJapanParams2, (i2 & 8) != 0 ? personTokenParams2.dateOfBirth : dateOfBirth2, (i2 & 16) != 0 ? personTokenParams2.email : str, (i2 & 32) != 0 ? personTokenParams2.firstName : str2, (i2 & 64) != 0 ? personTokenParams2.firstNameKana : str3, (i2 & 128) != 0 ? personTokenParams2.firstNameKanji : str4, (i2 & 256) != 0 ? personTokenParams2.gender : str5, (i2 & 512) != 0 ? personTokenParams2.idNumber : str6, (i2 & 1024) != 0 ? personTokenParams2.lastName : str7, (i2 & 2048) != 0 ? personTokenParams2.lastNameKana : str8, (i2 & 4096) != 0 ? personTokenParams2.lastNameKanji : str9, (i2 & 8192) != 0 ? personTokenParams2.maidenName : str10, (i2 & 16384) != 0 ? personTokenParams2.metadata : map, (i2 & 32768) != 0 ? personTokenParams2.phone : str11, (i2 & 65536) != 0 ? personTokenParams2.relationship : relationship2, (i2 & 131072) != 0 ? personTokenParams2.ssnLast4 : str12, (i2 & 262144) != 0 ? personTokenParams2.verification : verification2);
    }

    public final Address component1() {
        return this.address;
    }

    public final String component10() {
        return this.idNumber;
    }

    public final String component11() {
        return this.lastName;
    }

    public final String component12() {
        return this.lastNameKana;
    }

    public final String component13() {
        return this.lastNameKanji;
    }

    public final String component14() {
        return this.maidenName;
    }

    public final Map<String, String> component15() {
        return this.metadata;
    }

    public final String component16() {
        return this.phone;
    }

    public final Relationship component17() {
        return this.relationship;
    }

    public final String component18() {
        return this.ssnLast4;
    }

    public final Verification component19() {
        return this.verification;
    }

    public final AddressJapanParams component2() {
        return this.addressKana;
    }

    public final AddressJapanParams component3() {
        return this.addressKanji;
    }

    public final DateOfBirth component4() {
        return this.dateOfBirth;
    }

    public final String component5() {
        return this.email;
    }

    public final String component6() {
        return this.firstName;
    }

    public final String component7() {
        return this.firstNameKana;
    }

    public final String component8() {
        return this.firstNameKanji;
    }

    public final String component9() {
        return this.gender;
    }

    public final PersonTokenParams copy(Address address2, AddressJapanParams addressJapanParams, AddressJapanParams addressJapanParams2, DateOfBirth dateOfBirth2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Map<String, String> map, String str11, Relationship relationship2, String str12, Verification verification2) {
        return new PersonTokenParams(address2, addressJapanParams, addressJapanParams2, dateOfBirth2, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, map, str11, relationship2, str12, verification2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PersonTokenParams)) {
            return false;
        }
        PersonTokenParams personTokenParams = (PersonTokenParams) obj;
        return Intrinsics.areEqual((Object) this.address, (Object) personTokenParams.address) && Intrinsics.areEqual((Object) this.addressKana, (Object) personTokenParams.addressKana) && Intrinsics.areEqual((Object) this.addressKanji, (Object) personTokenParams.addressKanji) && Intrinsics.areEqual((Object) this.dateOfBirth, (Object) personTokenParams.dateOfBirth) && Intrinsics.areEqual((Object) this.email, (Object) personTokenParams.email) && Intrinsics.areEqual((Object) this.firstName, (Object) personTokenParams.firstName) && Intrinsics.areEqual((Object) this.firstNameKana, (Object) personTokenParams.firstNameKana) && Intrinsics.areEqual((Object) this.firstNameKanji, (Object) personTokenParams.firstNameKanji) && Intrinsics.areEqual((Object) this.gender, (Object) personTokenParams.gender) && Intrinsics.areEqual((Object) this.idNumber, (Object) personTokenParams.idNumber) && Intrinsics.areEqual((Object) this.lastName, (Object) personTokenParams.lastName) && Intrinsics.areEqual((Object) this.lastNameKana, (Object) personTokenParams.lastNameKana) && Intrinsics.areEqual((Object) this.lastNameKanji, (Object) personTokenParams.lastNameKanji) && Intrinsics.areEqual((Object) this.maidenName, (Object) personTokenParams.maidenName) && Intrinsics.areEqual((Object) this.metadata, (Object) personTokenParams.metadata) && Intrinsics.areEqual((Object) this.phone, (Object) personTokenParams.phone) && Intrinsics.areEqual((Object) this.relationship, (Object) personTokenParams.relationship) && Intrinsics.areEqual((Object) this.ssnLast4, (Object) personTokenParams.ssnLast4) && Intrinsics.areEqual((Object) this.verification, (Object) personTokenParams.verification);
    }

    public int hashCode() {
        Address address2 = this.address;
        int i = 0;
        int hashCode = (address2 == null ? 0 : address2.hashCode()) * 31;
        AddressJapanParams addressJapanParams = this.addressKana;
        int hashCode2 = (hashCode + (addressJapanParams == null ? 0 : addressJapanParams.hashCode())) * 31;
        AddressJapanParams addressJapanParams2 = this.addressKanji;
        int hashCode3 = (hashCode2 + (addressJapanParams2 == null ? 0 : addressJapanParams2.hashCode())) * 31;
        DateOfBirth dateOfBirth2 = this.dateOfBirth;
        int hashCode4 = (hashCode3 + (dateOfBirth2 == null ? 0 : dateOfBirth2.hashCode())) * 31;
        String str = this.email;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.firstName;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.firstNameKana;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.firstNameKanji;
        int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.gender;
        int hashCode9 = (hashCode8 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.idNumber;
        int hashCode10 = (hashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.lastName;
        int hashCode11 = (hashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.lastNameKana;
        int hashCode12 = (hashCode11 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.lastNameKanji;
        int hashCode13 = (hashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.maidenName;
        int hashCode14 = (hashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Map<String, String> map = this.metadata;
        int hashCode15 = (hashCode14 + (map == null ? 0 : map.hashCode())) * 31;
        String str11 = this.phone;
        int hashCode16 = (hashCode15 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Relationship relationship2 = this.relationship;
        int hashCode17 = (hashCode16 + (relationship2 == null ? 0 : relationship2.hashCode())) * 31;
        String str12 = this.ssnLast4;
        int hashCode18 = (hashCode17 + (str12 == null ? 0 : str12.hashCode())) * 31;
        Verification verification2 = this.verification;
        if (verification2 != null) {
            i = verification2.hashCode();
        }
        return hashCode18 + i;
    }

    public String toString() {
        return "PersonTokenParams(address=" + this.address + ", addressKana=" + this.addressKana + ", addressKanji=" + this.addressKanji + ", dateOfBirth=" + this.dateOfBirth + ", email=" + this.email + ", firstName=" + this.firstName + ", firstNameKana=" + this.firstNameKana + ", firstNameKanji=" + this.firstNameKanji + ", gender=" + this.gender + ", idNumber=" + this.idNumber + ", lastName=" + this.lastName + ", lastNameKana=" + this.lastNameKana + ", lastNameKanji=" + this.lastNameKanji + ", maidenName=" + this.maidenName + ", metadata=" + this.metadata + ", phone=" + this.phone + ", relationship=" + this.relationship + ", ssnLast4=" + this.ssnLast4 + ", verification=" + this.verification + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Address address2 = this.address;
        if (address2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            address2.writeToParcel(parcel, i);
        }
        AddressJapanParams addressJapanParams = this.addressKana;
        if (addressJapanParams == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            addressJapanParams.writeToParcel(parcel, i);
        }
        AddressJapanParams addressJapanParams2 = this.addressKanji;
        if (addressJapanParams2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            addressJapanParams2.writeToParcel(parcel, i);
        }
        DateOfBirth dateOfBirth2 = this.dateOfBirth;
        if (dateOfBirth2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            dateOfBirth2.writeToParcel(parcel, i);
        }
        parcel.writeString(this.email);
        parcel.writeString(this.firstName);
        parcel.writeString(this.firstNameKana);
        parcel.writeString(this.firstNameKanji);
        parcel.writeString(this.gender);
        parcel.writeString(this.idNumber);
        parcel.writeString(this.lastName);
        parcel.writeString(this.lastNameKana);
        parcel.writeString(this.lastNameKanji);
        parcel.writeString(this.maidenName);
        Map<String, String> map = this.metadata;
        if (map == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(map.size());
            for (Map.Entry next : map.entrySet()) {
                parcel.writeString((String) next.getKey());
                parcel.writeString((String) next.getValue());
            }
        }
        parcel.writeString(this.phone);
        Relationship relationship2 = this.relationship;
        if (relationship2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            relationship2.writeToParcel(parcel, i);
        }
        parcel.writeString(this.ssnLast4);
        Verification verification2 = this.verification;
        if (verification2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        verification2.writeToParcel(parcel, i);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PersonTokenParams(com.stripe.android.model.Address r21, com.stripe.android.model.AddressJapanParams r22, com.stripe.android.model.AddressJapanParams r23, com.stripe.android.model.DateOfBirth r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.util.Map r35, java.lang.String r36, com.stripe.android.model.PersonTokenParams.Relationship r37, java.lang.String r38, com.stripe.android.model.PersonTokenParams.Verification r39, int r40, kotlin.jvm.internal.DefaultConstructorMarker r41) {
        /*
            r20 = this;
            r0 = r40
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r21
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r22
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r23
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r24
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r25
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r26
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r27
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r28
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r29
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r30
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r31
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r32
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r33
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r34
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 0
            goto L_0x007a
        L_0x0078:
            r2 = r35
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r36
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = 0
            goto L_0x0091
        L_0x008f:
            r17 = r37
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x009a
            r18 = 0
            goto L_0x009c
        L_0x009a:
            r18 = r38
        L_0x009c:
            r19 = 262144(0x40000, float:3.67342E-40)
            r0 = r0 & r19
            if (r0 == 0) goto L_0x00a4
            r0 = 0
            goto L_0x00a6
        L_0x00a4:
            r0 = r39
        L_0x00a6:
            r21 = r20
            r22 = r1
            r23 = r3
            r24 = r4
            r25 = r5
            r26 = r6
            r27 = r7
            r28 = r8
            r29 = r9
            r30 = r10
            r31 = r11
            r32 = r12
            r33 = r13
            r34 = r14
            r35 = r15
            r36 = r2
            r37 = r16
            r38 = r17
            r39 = r18
            r40 = r0
            r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.PersonTokenParams.<init>(com.stripe.android.model.Address, com.stripe.android.model.AddressJapanParams, com.stripe.android.model.AddressJapanParams, com.stripe.android.model.DateOfBirth, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, java.lang.String, com.stripe.android.model.PersonTokenParams$Relationship, java.lang.String, com.stripe.android.model.PersonTokenParams$Verification, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Address getAddress() {
        return this.address;
    }

    public final AddressJapanParams getAddressKana() {
        return this.addressKana;
    }

    public final AddressJapanParams getAddressKanji() {
        return this.addressKanji;
    }

    public final DateOfBirth getDateOfBirth() {
        return this.dateOfBirth;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getFirstName() {
        return this.firstName;
    }

    public final String getFirstNameKana() {
        return this.firstNameKana;
    }

    public final String getFirstNameKanji() {
        return this.firstNameKanji;
    }

    public final String getGender() {
        return this.gender;
    }

    public final String getIdNumber() {
        return this.idNumber;
    }

    public final String getLastName() {
        return this.lastName;
    }

    public final String getLastNameKana() {
        return this.lastNameKana;
    }

    public final String getLastNameKanji() {
        return this.lastNameKanji;
    }

    public final String getMaidenName() {
        return this.maidenName;
    }

    public final Map<String, String> getMetadata() {
        return this.metadata;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final Relationship getRelationship() {
        return this.relationship;
    }

    public final String getSsnLast4() {
        return this.ssnLast4;
    }

    public final Verification getVerification() {
        return this.verification;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PersonTokenParams(Address address2, AddressJapanParams addressJapanParams, AddressJapanParams addressJapanParams2, DateOfBirth dateOfBirth2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Map<String, String> map, String str11, Relationship relationship2, String str12, Verification verification2) {
        super(Token.Type.Person, (Set) null, 2, (DefaultConstructorMarker) null);
        this.address = address2;
        this.addressKana = addressJapanParams;
        this.addressKanji = addressJapanParams2;
        this.dateOfBirth = dateOfBirth2;
        this.email = str;
        this.firstName = str2;
        this.firstNameKana = str3;
        this.firstNameKanji = str4;
        this.gender = str5;
        this.idNumber = str6;
        this.lastName = str7;
        this.lastNameKana = str8;
        this.lastNameKanji = str9;
        this.maidenName = str10;
        this.metadata = map;
        this.phone = str11;
        this.relationship = relationship2;
        this.ssnLast4 = str12;
        this.verification = verification2;
    }

    public Map<String, Object> getTypeDataParams() {
        Map map;
        Pair[] pairArr = new Pair[19];
        Address address2 = this.address;
        pairArr[0] = TuplesKt.to("address", address2 == null ? null : address2.toParamMap());
        AddressJapanParams addressJapanParams = this.addressKana;
        pairArr[1] = TuplesKt.to(PARAM_ADDRESS_KANA, addressJapanParams == null ? null : addressJapanParams.toParamMap());
        AddressJapanParams addressJapanParams2 = this.addressKanji;
        pairArr[2] = TuplesKt.to(PARAM_ADDRESS_KANJI, addressJapanParams2 == null ? null : addressJapanParams2.toParamMap());
        DateOfBirth dateOfBirth2 = this.dateOfBirth;
        pairArr[3] = TuplesKt.to(PARAM_DOB, dateOfBirth2 == null ? null : dateOfBirth2.toParamMap());
        pairArr[4] = TuplesKt.to("email", this.email);
        pairArr[5] = TuplesKt.to(PARAM_FIRST_NAME, this.firstName);
        pairArr[6] = TuplesKt.to(PARAM_FIRST_NAME_KANA, this.firstNameKana);
        pairArr[7] = TuplesKt.to(PARAM_FIRST_NAME_KANJI, this.firstNameKanji);
        pairArr[8] = TuplesKt.to("gender", this.gender);
        pairArr[9] = TuplesKt.to(PARAM_ID_NUMBER, this.idNumber);
        pairArr[10] = TuplesKt.to(PARAM_LAST_NAME, this.lastName);
        pairArr[11] = TuplesKt.to(PARAM_LAST_NAME_KANA, this.lastNameKana);
        pairArr[12] = TuplesKt.to(PARAM_LAST_NAME_KANJI, this.lastNameKanji);
        pairArr[13] = TuplesKt.to(PARAM_MAIDEN_NAME, this.maidenName);
        pairArr[14] = TuplesKt.to("metadata", this.metadata);
        pairArr[15] = TuplesKt.to("phone", this.phone);
        Relationship relationship2 = this.relationship;
        pairArr[16] = TuplesKt.to(PARAM_RELATIONSHIP, relationship2 == null ? null : relationship2.toParamMap());
        pairArr[17] = TuplesKt.to(PARAM_SSN_LAST_4, this.ssnLast4);
        Verification verification2 = this.verification;
        pairArr[18] = TuplesKt.to(PARAM_VERIFICATION, verification2 == null ? null : verification2.toParamMap());
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

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0002-.BM\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003JV\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010\u001fJ\t\u0010 \u001a\u00020\bHÖ\u0001J\u0013\u0010!\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\bHÖ\u0001J\u0014\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020#0&H\u0016J\t\u0010'\u001a\u00020\u000bHÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\bHÖ\u0001R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0015\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006/"}, d2 = {"Lcom/stripe/android/model/PersonTokenParams$Relationship;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "director", "", "executive", "owner", "percentOwnership", "", "representative", "title", "", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;)V", "getDirector", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getExecutive", "getOwner", "getPercentOwnership", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRepresentative", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/stripe/android/model/PersonTokenParams$Relationship;", "describeContents", "equals", "other", "", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Builder", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PersonTokenParams.kt */
    public static final class Relationship implements StripeParamsModel, Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Relationship> CREATOR = new Creator();
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String PARAM_DIRECTOR = "director";
        @Deprecated
        private static final String PARAM_EXECUTIVE = "executive";
        @Deprecated
        private static final String PARAM_OWNER = "owner";
        @Deprecated
        private static final String PARAM_PERCENT_OWNERSHIP = "percent_ownership";
        @Deprecated
        private static final String PARAM_REPRESENTATIVE = "representative";
        @Deprecated
        private static final String PARAM_TITLE = "title";
        private final Boolean director;
        private final Boolean executive;
        private final Boolean owner;
        private final Integer percentOwnership;
        private final Boolean representative;
        private final String title;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PersonTokenParams.kt */
        public static final class Creator implements Parcelable.Creator<Relationship> {
            public final Relationship createFromParcel(Parcel parcel) {
                Boolean bool;
                Boolean bool2;
                Boolean bool3;
                Boolean bool4;
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                boolean z = true;
                if (parcel.readInt() == 0) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                }
                if (parcel.readInt() == 0) {
                    bool2 = null;
                } else {
                    bool2 = Boolean.valueOf(parcel.readInt() != 0);
                }
                if (parcel.readInt() == 0) {
                    bool3 = null;
                } else {
                    bool3 = Boolean.valueOf(parcel.readInt() != 0);
                }
                Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
                if (parcel.readInt() == 0) {
                    bool4 = null;
                } else {
                    if (parcel.readInt() == 0) {
                        z = false;
                    }
                    bool4 = Boolean.valueOf(z);
                }
                return new Relationship(bool, bool2, bool3, valueOf, bool4, parcel.readString());
            }

            public final Relationship[] newArray(int i) {
                return new Relationship[i];
            }
        }

        public Relationship() {
            this((Boolean) null, (Boolean) null, (Boolean) null, (Integer) null, (Boolean) null, (String) null, 63, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Relationship copy$default(Relationship relationship, Boolean bool, Boolean bool2, Boolean bool3, Integer num, Boolean bool4, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                bool = relationship.director;
            }
            if ((i & 2) != 0) {
                bool2 = relationship.executive;
            }
            Boolean bool5 = bool2;
            if ((i & 4) != 0) {
                bool3 = relationship.owner;
            }
            Boolean bool6 = bool3;
            if ((i & 8) != 0) {
                num = relationship.percentOwnership;
            }
            Integer num2 = num;
            if ((i & 16) != 0) {
                bool4 = relationship.representative;
            }
            Boolean bool7 = bool4;
            if ((i & 32) != 0) {
                str = relationship.title;
            }
            return relationship.copy(bool, bool5, bool6, num2, bool7, str);
        }

        public final Boolean component1() {
            return this.director;
        }

        public final Boolean component2() {
            return this.executive;
        }

        public final Boolean component3() {
            return this.owner;
        }

        public final Integer component4() {
            return this.percentOwnership;
        }

        public final Boolean component5() {
            return this.representative;
        }

        public final String component6() {
            return this.title;
        }

        public final Relationship copy(Boolean bool, Boolean bool2, Boolean bool3, Integer num, Boolean bool4, String str) {
            return new Relationship(bool, bool2, bool3, num, bool4, str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Relationship)) {
                return false;
            }
            Relationship relationship = (Relationship) obj;
            return Intrinsics.areEqual((Object) this.director, (Object) relationship.director) && Intrinsics.areEqual((Object) this.executive, (Object) relationship.executive) && Intrinsics.areEqual((Object) this.owner, (Object) relationship.owner) && Intrinsics.areEqual((Object) this.percentOwnership, (Object) relationship.percentOwnership) && Intrinsics.areEqual((Object) this.representative, (Object) relationship.representative) && Intrinsics.areEqual((Object) this.title, (Object) relationship.title);
        }

        public int hashCode() {
            Boolean bool = this.director;
            int i = 0;
            int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
            Boolean bool2 = this.executive;
            int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
            Boolean bool3 = this.owner;
            int hashCode3 = (hashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
            Integer num = this.percentOwnership;
            int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
            Boolean bool4 = this.representative;
            int hashCode5 = (hashCode4 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
            String str = this.title;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode5 + i;
        }

        public String toString() {
            return "Relationship(director=" + this.director + ", executive=" + this.executive + ", owner=" + this.owner + ", percentOwnership=" + this.percentOwnership + ", representative=" + this.representative + ", title=" + this.title + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            Boolean bool = this.director;
            if (bool == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(bool.booleanValue() ? 1 : 0);
            }
            Boolean bool2 = this.executive;
            if (bool2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(bool2.booleanValue() ? 1 : 0);
            }
            Boolean bool3 = this.owner;
            if (bool3 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(bool3.booleanValue() ? 1 : 0);
            }
            Integer num = this.percentOwnership;
            if (num == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num.intValue());
            }
            Boolean bool4 = this.representative;
            if (bool4 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(bool4.booleanValue() ? 1 : 0);
            }
            parcel.writeString(this.title);
        }

        public Relationship(Boolean bool, Boolean bool2, Boolean bool3, Integer num, Boolean bool4, String str) {
            this.director = bool;
            this.executive = bool2;
            this.owner = bool3;
            this.percentOwnership = num;
            this.representative = bool4;
            this.title = str;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Relationship(java.lang.Boolean r6, java.lang.Boolean r7, java.lang.Boolean r8, java.lang.Integer r9, java.lang.Boolean r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
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
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.PersonTokenParams.Relationship.<init>(java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Integer, java.lang.Boolean, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final Boolean getDirector() {
            return this.director;
        }

        public final Boolean getExecutive() {
            return this.executive;
        }

        public final Boolean getOwner() {
            return this.owner;
        }

        public final Integer getPercentOwnership() {
            return this.percentOwnership;
        }

        public final Boolean getRepresentative() {
            return this.representative;
        }

        public final String getTitle() {
            return this.title;
        }

        public Map<String, Object> toParamMap() {
            Map map;
            Pair[] pairArr = {TuplesKt.to(PARAM_DIRECTOR, this.director), TuplesKt.to(PARAM_EXECUTIVE, this.executive), TuplesKt.to(PARAM_OWNER, this.owner), TuplesKt.to(PARAM_PERCENT_OWNERSHIP, this.percentOwnership), TuplesKt.to(PARAM_REPRESENTATIVE, this.representative), TuplesKt.to("title", this.title)};
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

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0015\u0010\u0010\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0017\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/model/PersonTokenParams$Relationship$Builder;", "Lcom/stripe/android/ObjectBuilder;", "Lcom/stripe/android/model/PersonTokenParams$Relationship;", "()V", "director", "", "Ljava/lang/Boolean;", "executive", "owner", "percentOwnership", "", "Ljava/lang/Integer;", "representative", "title", "", "build", "setDirector", "(Ljava/lang/Boolean;)Lcom/stripe/android/model/PersonTokenParams$Relationship$Builder;", "setExecutive", "setOwner", "setPercentOwnership", "(Ljava/lang/Integer;)Lcom/stripe/android/model/PersonTokenParams$Relationship$Builder;", "setRepresentative", "setTitle", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PersonTokenParams.kt */
        public static final class Builder implements ObjectBuilder<Relationship> {
            public static final int $stable = 8;
            private Boolean director;
            private Boolean executive;
            private Boolean owner;
            private Integer percentOwnership;
            private Boolean representative;
            private String title;

            public final Builder setDirector(Boolean bool) {
                Builder builder = this;
                builder.director = bool;
                return builder;
            }

            public final Builder setExecutive(Boolean bool) {
                Builder builder = this;
                builder.executive = bool;
                return builder;
            }

            public final Builder setOwner(Boolean bool) {
                Builder builder = this;
                builder.owner = bool;
                return builder;
            }

            public final Builder setPercentOwnership(Integer num) {
                Builder builder = this;
                builder.percentOwnership = num;
                return builder;
            }

            public final Builder setRepresentative(Boolean bool) {
                Builder builder = this;
                builder.representative = bool;
                return builder;
            }

            public final Builder setTitle(String str) {
                Builder builder = this;
                builder.title = str;
                return builder;
            }

            public Relationship build() {
                return new Relationship(this.director, this.executive, this.owner, this.percentOwnership, this.representative, this.title);
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stripe/android/model/PersonTokenParams$Relationship$Companion;", "", "()V", "PARAM_DIRECTOR", "", "PARAM_EXECUTIVE", "PARAM_OWNER", "PARAM_PERCENT_OWNERSHIP", "PARAM_REPRESENTATIVE", "PARAM_TITLE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PersonTokenParams.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u001f\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\u0014\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120\u0015H\u0016J\t\u0010\u0017\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eHÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/stripe/android/model/PersonTokenParams$Verification;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "document", "Lcom/stripe/android/model/PersonTokenParams$Document;", "additionalDocument", "(Lcom/stripe/android/model/PersonTokenParams$Document;Lcom/stripe/android/model/PersonTokenParams$Document;)V", "getAdditionalDocument", "()Lcom/stripe/android/model/PersonTokenParams$Document;", "getDocument", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PersonTokenParams.kt */
    public static final class Verification implements StripeParamsModel, Parcelable {
        public static final int $stable = 0;
        public static final Parcelable.Creator<Verification> CREATOR = new Creator();
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String PARAM_ADDITIONAL_DOCUMENT = "additional_document";
        @Deprecated
        private static final String PARAM_DOCUMENT = "document";
        private final Document additionalDocument;
        private final Document document;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PersonTokenParams.kt */
        public static final class Creator implements Parcelable.Creator<Verification> {
            public final Verification createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                Document document = null;
                Document createFromParcel = parcel.readInt() == 0 ? null : Document.CREATOR.createFromParcel(parcel);
                if (parcel.readInt() != 0) {
                    document = Document.CREATOR.createFromParcel(parcel);
                }
                return new Verification(createFromParcel, document);
            }

            public final Verification[] newArray(int i) {
                return new Verification[i];
            }
        }

        public Verification() {
            this((Document) null, (Document) null, 3, (DefaultConstructorMarker) null);
        }

        public Verification(Document document2) {
            this(document2, (Document) null, 2, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Verification copy$default(Verification verification, Document document2, Document document3, int i, Object obj) {
            if ((i & 1) != 0) {
                document2 = verification.document;
            }
            if ((i & 2) != 0) {
                document3 = verification.additionalDocument;
            }
            return verification.copy(document2, document3);
        }

        public final Document component1() {
            return this.document;
        }

        public final Document component2() {
            return this.additionalDocument;
        }

        public final Verification copy(Document document2, Document document3) {
            return new Verification(document2, document3);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Verification)) {
                return false;
            }
            Verification verification = (Verification) obj;
            return Intrinsics.areEqual((Object) this.document, (Object) verification.document) && Intrinsics.areEqual((Object) this.additionalDocument, (Object) verification.additionalDocument);
        }

        public int hashCode() {
            Document document2 = this.document;
            int i = 0;
            int hashCode = (document2 == null ? 0 : document2.hashCode()) * 31;
            Document document3 = this.additionalDocument;
            if (document3 != null) {
                i = document3.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "Verification(document=" + this.document + ", additionalDocument=" + this.additionalDocument + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            Document document2 = this.document;
            if (document2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                document2.writeToParcel(parcel, i);
            }
            Document document3 = this.additionalDocument;
            if (document3 == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            document3.writeToParcel(parcel, i);
        }

        public Verification(Document document2, Document document3) {
            this.document = document2;
            this.additionalDocument = document3;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Verification(Document document2, Document document3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : document2, (i & 2) != 0 ? null : document3);
        }

        public final Document getDocument() {
            return this.document;
        }

        public final Document getAdditionalDocument() {
            return this.additionalDocument;
        }

        public Map<String, Object> toParamMap() {
            Map map;
            Pair[] pairArr = new Pair[2];
            Document document2 = this.document;
            pairArr[0] = TuplesKt.to(PARAM_ADDITIONAL_DOCUMENT, document2 == null ? null : document2.toParamMap());
            Document document3 = this.additionalDocument;
            pairArr[1] = TuplesKt.to(PARAM_DOCUMENT, document3 == null ? null : document3.toParamMap());
            Map<String, Object> emptyMap = MapsKt.emptyMap();
            for (Pair pair : CollectionsKt.listOf(pairArr)) {
                String str = (String) pair.component1();
                Map map2 = (Map) pair.component2();
                if (map2 == null) {
                    map = null;
                } else {
                    map = MapsKt.mapOf(TuplesKt.to(str, map2));
                }
                if (map == null) {
                    map = MapsKt.emptyMap();
                }
                emptyMap = MapsKt.plus(emptyMap, (Map<String, Object>) map);
            }
            return emptyMap;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/model/PersonTokenParams$Verification$Companion;", "", "()V", "PARAM_ADDITIONAL_DOCUMENT", "", "PARAM_DOCUMENT", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PersonTokenParams.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u001f\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\u0014\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000eHÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/stripe/android/model/PersonTokenParams$Document;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "front", "", "back", "(Ljava/lang/String;Ljava/lang/String;)V", "getBack", "()Ljava/lang/String;", "getFront", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PersonTokenParams.kt */
    public static final class Document implements StripeParamsModel, Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Document> CREATOR = new Creator();
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String PARAM_BACK = "back";
        @Deprecated
        private static final String PARAM_FRONT = "front";
        private final String back;
        private final String front;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PersonTokenParams.kt */
        public static final class Creator implements Parcelable.Creator<Document> {
            public final Document createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Document(parcel.readString(), parcel.readString());
            }

            public final Document[] newArray(int i) {
                return new Document[i];
            }
        }

        public Document() {
            this((String) null, (String) null, 3, (DefaultConstructorMarker) null);
        }

        public Document(String str) {
            this(str, (String) null, 2, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Document copy$default(Document document, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = document.front;
            }
            if ((i & 2) != 0) {
                str2 = document.back;
            }
            return document.copy(str, str2);
        }

        public final String component1() {
            return this.front;
        }

        public final String component2() {
            return this.back;
        }

        public final Document copy(String str, String str2) {
            return new Document(str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Document)) {
                return false;
            }
            Document document = (Document) obj;
            return Intrinsics.areEqual((Object) this.front, (Object) document.front) && Intrinsics.areEqual((Object) this.back, (Object) document.back);
        }

        public int hashCode() {
            String str = this.front;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.back;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "Document(front=" + this.front + ", back=" + this.back + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.front);
            parcel.writeString(this.back);
        }

        public Document(String str, String str2) {
            this.front = str;
            this.back = str2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Document(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
        }

        public final String getFront() {
            return this.front;
        }

        public final String getBack() {
            return this.back;
        }

        public Map<String, Object> toParamMap() {
            Map map;
            Pair[] pairArr = {TuplesKt.to(PARAM_BACK, this.back), TuplesKt.to(PARAM_FRONT, this.front)};
            Map<String, Object> emptyMap = MapsKt.emptyMap();
            for (Pair pair : CollectionsKt.listOf(pairArr)) {
                String str = (String) pair.component1();
                String str2 = (String) pair.component2();
                if (str2 == null) {
                    map = null;
                } else {
                    map = MapsKt.mapOf(TuplesKt.to(str, str2));
                }
                if (map == null) {
                    map = MapsKt.emptyMap();
                }
                emptyMap = MapsKt.plus(emptyMap, (Map<String, Object>) map);
            }
            return emptyMap;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/model/PersonTokenParams$Document$Companion;", "", "()V", "PARAM_BACK", "", "PARAM_FRONT", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PersonTokenParams.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010 \u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010!\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\"\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010#\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010$\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010%\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\fJ\u0010\u0010&\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\fJ\u0010\u0010'\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\fJ\u0010\u0010(\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\fJ\u0010\u0010)\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\fJ\u0010\u0010*\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\fJ\u0010\u0010+\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\fJ\u0010\u0010,\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\fJ\u001c\u0010-\u001a\u00020\u00002\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u0017J\u0010\u0010.\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\fJ\u0010\u0010/\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0010\u00100\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\fJ\u0010\u00101\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/stripe/android/model/PersonTokenParams$Builder;", "Lcom/stripe/android/ObjectBuilder;", "Lcom/stripe/android/model/PersonTokenParams;", "()V", "address", "Lcom/stripe/android/model/Address;", "addressKana", "Lcom/stripe/android/model/AddressJapanParams;", "addressKanji", "dateOfBirth", "Lcom/stripe/android/model/DateOfBirth;", "email", "", "firstName", "firstNameKana", "firstNameKanji", "gender", "idNumber", "lastName", "lastNameKana", "lastNameKanji", "maidenName", "metadata", "", "phone", "relationship", "Lcom/stripe/android/model/PersonTokenParams$Relationship;", "ssnLast4", "verification", "Lcom/stripe/android/model/PersonTokenParams$Verification;", "build", "setAddress", "setAddressKana", "setAddressKanji", "setDateOfBirth", "setEmail", "setFirstName", "setFirstNameKana", "setFirstNameKanji", "setGender", "setIdNumber", "setLastName", "setLastNameKana", "setLastNameKanji", "setMaidenName", "setMetadata", "setPhone", "setRelationship", "setSsnLast4", "setVerification", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PersonTokenParams.kt */
    public static final class Builder implements ObjectBuilder<PersonTokenParams> {
        public static final int $stable = 8;
        private Address address;
        private AddressJapanParams addressKana;
        private AddressJapanParams addressKanji;
        private DateOfBirth dateOfBirth;
        private String email;
        private String firstName;
        private String firstNameKana;
        private String firstNameKanji;
        private String gender;
        private String idNumber;
        private String lastName;
        private String lastNameKana;
        private String lastNameKanji;
        private String maidenName;
        private Map<String, String> metadata;
        private String phone;
        private Relationship relationship;
        private String ssnLast4;
        private Verification verification;

        public final Builder setAddress(Address address2) {
            Builder builder = this;
            builder.address = address2;
            return builder;
        }

        public final Builder setAddressKana(AddressJapanParams addressJapanParams) {
            Builder builder = this;
            builder.addressKana = addressJapanParams;
            return builder;
        }

        public final Builder setAddressKanji(AddressJapanParams addressJapanParams) {
            Builder builder = this;
            builder.addressKanji = addressJapanParams;
            return builder;
        }

        public final Builder setDateOfBirth(DateOfBirth dateOfBirth2) {
            Builder builder = this;
            builder.dateOfBirth = dateOfBirth2;
            return builder;
        }

        public final Builder setEmail(String str) {
            Builder builder = this;
            builder.email = str;
            return builder;
        }

        public final Builder setFirstName(String str) {
            Builder builder = this;
            builder.firstName = str;
            return builder;
        }

        public final Builder setFirstNameKana(String str) {
            Builder builder = this;
            builder.firstNameKana = str;
            return builder;
        }

        public final Builder setFirstNameKanji(String str) {
            Builder builder = this;
            builder.firstNameKanji = str;
            return builder;
        }

        public final Builder setGender(String str) {
            Builder builder = this;
            builder.gender = str;
            return builder;
        }

        public final Builder setIdNumber(String str) {
            Builder builder = this;
            builder.idNumber = str;
            return builder;
        }

        public final Builder setLastName(String str) {
            Builder builder = this;
            builder.lastName = str;
            return builder;
        }

        public final Builder setLastNameKana(String str) {
            Builder builder = this;
            builder.lastNameKana = str;
            return builder;
        }

        public final Builder setLastNameKanji(String str) {
            Builder builder = this;
            builder.lastNameKanji = str;
            return builder;
        }

        public final Builder setMaidenName(String str) {
            Builder builder = this;
            builder.maidenName = str;
            return builder;
        }

        public final Builder setMetadata(Map<String, String> map) {
            Builder builder = this;
            builder.metadata = map;
            return builder;
        }

        public final Builder setPhone(String str) {
            Builder builder = this;
            builder.phone = str;
            return builder;
        }

        public final Builder setRelationship(Relationship relationship2) {
            Builder builder = this;
            builder.relationship = relationship2;
            return builder;
        }

        public final Builder setSsnLast4(String str) {
            Builder builder = this;
            builder.ssnLast4 = str;
            return builder;
        }

        public final Builder setVerification(Verification verification2) {
            Builder builder = this;
            builder.verification = verification2;
            return builder;
        }

        public PersonTokenParams build() {
            return new PersonTokenParams(this.address, this.addressKana, this.addressKanji, this.dateOfBirth, this.email, this.firstName, this.firstNameKana, this.firstNameKanji, this.gender, this.idNumber, this.lastName, this.lastNameKana, this.lastNameKanji, this.maidenName, this.metadata, this.phone, this.relationship, this.ssnLast4, this.verification);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/model/PersonTokenParams$Companion;", "", "()V", "PARAM_ADDRESS", "", "PARAM_ADDRESS_KANA", "PARAM_ADDRESS_KANJI", "PARAM_DOB", "PARAM_EMAIL", "PARAM_FIRST_NAME", "PARAM_FIRST_NAME_KANA", "PARAM_FIRST_NAME_KANJI", "PARAM_GENDER", "PARAM_ID_NUMBER", "PARAM_LAST_NAME", "PARAM_LAST_NAME_KANA", "PARAM_LAST_NAME_KANJI", "PARAM_MAIDEN_NAME", "PARAM_METADATA", "PARAM_PERSON", "PARAM_PHONE", "PARAM_RELATIONSHIP", "PARAM_SSN_LAST_4", "PARAM_VERIFICATION", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PersonTokenParams.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
