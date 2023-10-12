package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.model.Token;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 #2\u00020\u0001:\u0002#$BC\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÂ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÂ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÂ\u0003JK\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0018HÖ\u0001R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006%"}, d2 = {"Lcom/stripe/android/model/BankAccountTokenParams;", "Lcom/stripe/android/model/TokenParams;", "country", "", "currency", "accountNumber", "accountHolderType", "Lcom/stripe/android/model/BankAccountTokenParams$Type;", "accountHolderName", "routingNumber", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/BankAccountTokenParams$Type;Ljava/lang/String;Ljava/lang/String;)V", "typeDataParams", "", "", "getTypeDataParams", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "Type", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BankAccountTokenParams.kt */
public final class BankAccountTokenParams extends TokenParams {
    public static final int $stable = 8;
    public static final Parcelable.Creator<BankAccountTokenParams> CREATOR = new Creator();
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String PARAM_ACCOUNT_HOLDER_NAME = "account_holder_name";
    @Deprecated
    private static final String PARAM_ACCOUNT_HOLDER_TYPE = "account_holder_type";
    @Deprecated
    private static final String PARAM_ACCOUNT_NUMBER = "account_number";
    @Deprecated
    private static final String PARAM_COUNTRY = "country";
    @Deprecated
    private static final String PARAM_CURRENCY = "currency";
    @Deprecated
    private static final String PARAM_ROUTING_NUMBER = "routing_number";
    private final String accountHolderName;
    private final Type accountHolderType;
    private final String accountNumber;
    private final String country;
    private final String currency;
    private final String routingNumber;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BankAccountTokenParams.kt */
    public static final class Creator implements Parcelable.Creator<BankAccountTokenParams> {
        public final BankAccountTokenParams createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BankAccountTokenParams(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Type.valueOf(parcel.readString()), parcel.readString(), parcel.readString());
        }

        public final BankAccountTokenParams[] newArray(int i) {
            return new BankAccountTokenParams[i];
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BankAccountTokenParams(String str, String str2, String str3) {
        this(str, str2, str3, (Type) null, (String) null, (String) null, 56, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "country");
        Intrinsics.checkNotNullParameter(str2, "currency");
        Intrinsics.checkNotNullParameter(str3, "accountNumber");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BankAccountTokenParams(String str, String str2, String str3, Type type) {
        this(str, str2, str3, type, (String) null, (String) null, 48, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "country");
        Intrinsics.checkNotNullParameter(str2, "currency");
        Intrinsics.checkNotNullParameter(str3, "accountNumber");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BankAccountTokenParams(String str, String str2, String str3, Type type, String str4) {
        this(str, str2, str3, type, str4, (String) null, 32, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "country");
        Intrinsics.checkNotNullParameter(str2, "currency");
        Intrinsics.checkNotNullParameter(str3, "accountNumber");
    }

    private final String component1() {
        return this.country;
    }

    private final String component2() {
        return this.currency;
    }

    private final String component3() {
        return this.accountNumber;
    }

    private final Type component4() {
        return this.accountHolderType;
    }

    private final String component5() {
        return this.accountHolderName;
    }

    private final String component6() {
        return this.routingNumber;
    }

    public static /* synthetic */ BankAccountTokenParams copy$default(BankAccountTokenParams bankAccountTokenParams, String str, String str2, String str3, Type type, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bankAccountTokenParams.country;
        }
        if ((i & 2) != 0) {
            str2 = bankAccountTokenParams.currency;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = bankAccountTokenParams.accountNumber;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            type = bankAccountTokenParams.accountHolderType;
        }
        Type type2 = type;
        if ((i & 16) != 0) {
            str4 = bankAccountTokenParams.accountHolderName;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            str5 = bankAccountTokenParams.routingNumber;
        }
        return bankAccountTokenParams.copy(str, str6, str7, type2, str8, str5);
    }

    public final BankAccountTokenParams copy(String str, String str2, String str3, Type type, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "country");
        Intrinsics.checkNotNullParameter(str2, "currency");
        Intrinsics.checkNotNullParameter(str3, "accountNumber");
        return new BankAccountTokenParams(str, str2, str3, type, str4, str5);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BankAccountTokenParams)) {
            return false;
        }
        BankAccountTokenParams bankAccountTokenParams = (BankAccountTokenParams) obj;
        return Intrinsics.areEqual((Object) this.country, (Object) bankAccountTokenParams.country) && Intrinsics.areEqual((Object) this.currency, (Object) bankAccountTokenParams.currency) && Intrinsics.areEqual((Object) this.accountNumber, (Object) bankAccountTokenParams.accountNumber) && this.accountHolderType == bankAccountTokenParams.accountHolderType && Intrinsics.areEqual((Object) this.accountHolderName, (Object) bankAccountTokenParams.accountHolderName) && Intrinsics.areEqual((Object) this.routingNumber, (Object) bankAccountTokenParams.routingNumber);
    }

    public int hashCode() {
        int hashCode = ((((this.country.hashCode() * 31) + this.currency.hashCode()) * 31) + this.accountNumber.hashCode()) * 31;
        Type type = this.accountHolderType;
        int i = 0;
        int hashCode2 = (hashCode + (type == null ? 0 : type.hashCode())) * 31;
        String str = this.accountHolderName;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.routingNumber;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "BankAccountTokenParams(country=" + this.country + ", currency=" + this.currency + ", accountNumber=" + this.accountNumber + ", accountHolderType=" + this.accountHolderType + ", accountHolderName=" + this.accountHolderName + ", routingNumber=" + this.routingNumber + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.country);
        parcel.writeString(this.currency);
        parcel.writeString(this.accountNumber);
        Type type = this.accountHolderType;
        if (type == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(type.name());
        }
        parcel.writeString(this.accountHolderName);
        parcel.writeString(this.routingNumber);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BankAccountTokenParams(String str, String str2, String str3, Type type, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : type, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/stripe/android/model/BankAccountTokenParams$Type;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode$payments_core_release", "()Ljava/lang/String;", "Individual", "Company", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BankAccountTokenParams.kt */
    public enum Type {
        Individual("individual"),
        Company("company");
        
        public static final Companion Companion = null;
        private final String code;

        private Type(String str) {
            this.code = str;
        }

        public final String getCode$payments_core_release() {
            return this.code;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/BankAccountTokenParams$Type$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/model/BankAccountTokenParams$Type;", "code", "", "fromCode$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: BankAccountTokenParams.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Type fromCode$payments_core_release(String str) {
                Type[] values = Type.values();
                int length = values.length;
                int i = 0;
                while (i < length) {
                    Type type = values[i];
                    i++;
                    if (Intrinsics.areEqual((Object) type.getCode$payments_core_release(), (Object) str)) {
                        return type;
                    }
                }
                return null;
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BankAccountTokenParams(String str, String str2, String str3, Type type, String str4, String str5) {
        super(Token.Type.BankAccount, (Set) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "country");
        Intrinsics.checkNotNullParameter(str2, "currency");
        Intrinsics.checkNotNullParameter(str3, "accountNumber");
        this.country = str;
        this.currency = str2;
        this.accountNumber = str3;
        this.accountHolderType = type;
        this.accountHolderName = str4;
        this.routingNumber = str5;
    }

    public Map<String, Object> getTypeDataParams() {
        Map map;
        Pair[] pairArr = new Pair[6];
        pairArr[0] = TuplesKt.to("country", this.country);
        pairArr[1] = TuplesKt.to("currency", this.currency);
        pairArr[2] = TuplesKt.to(PARAM_ACCOUNT_HOLDER_NAME, this.accountHolderName);
        Type type = this.accountHolderType;
        pairArr[3] = TuplesKt.to(PARAM_ACCOUNT_HOLDER_TYPE, type == null ? null : type.getCode$payments_core_release());
        pairArr[4] = TuplesKt.to(PARAM_ROUTING_NUMBER, this.routingNumber);
        pairArr[5] = TuplesKt.to(PARAM_ACCOUNT_NUMBER, this.accountNumber);
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

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stripe/android/model/BankAccountTokenParams$Companion;", "", "()V", "PARAM_ACCOUNT_HOLDER_NAME", "", "PARAM_ACCOUNT_HOLDER_TYPE", "PARAM_ACCOUNT_NUMBER", "PARAM_COUNTRY", "PARAM_CURRENCY", "PARAM_ROUTING_NUMBER", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BankAccountTokenParams.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
