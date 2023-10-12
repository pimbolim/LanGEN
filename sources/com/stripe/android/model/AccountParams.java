package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.ObjectBuilder;
import com.stripe.android.model.Token;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0003\u001b\u001c\u001dB\u001b\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÂ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u001f\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u0014\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0015\u001a\u00020\tHÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0011HÖ\u0001R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/stripe/android/model/AccountParams;", "Lcom/stripe/android/model/TokenParams;", "tosShownAndAccepted", "", "businessTypeParams", "Lcom/stripe/android/model/AccountParams$BusinessTypeParams;", "(ZLcom/stripe/android/model/AccountParams$BusinessTypeParams;)V", "typeDataParams", "", "", "", "getTypeDataParams", "()Ljava/util/Map;", "component1", "component2", "copy", "describeContents", "", "equals", "other", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "BusinessType", "BusinessTypeParams", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AccountParams.kt */
public final class AccountParams extends TokenParams {
    public static final int $stable = 8;
    public static final Parcelable.Creator<AccountParams> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PARAM_BUSINESS_TYPE = "business_type";
    private static final String PARAM_TOS_SHOWN_AND_ACCEPTED = "tos_shown_and_accepted";
    private final BusinessTypeParams businessTypeParams;
    private final boolean tosShownAndAccepted;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AccountParams.kt */
    public static final class Creator implements Parcelable.Creator<AccountParams> {
        public final AccountParams createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AccountParams(parcel.readInt() != 0, (BusinessTypeParams) parcel.readParcelable(AccountParams.class.getClassLoader()));
        }

        public final AccountParams[] newArray(int i) {
            return new AccountParams[i];
        }
    }

    private final boolean component1() {
        return this.tosShownAndAccepted;
    }

    private final BusinessTypeParams component2() {
        return this.businessTypeParams;
    }

    public static /* synthetic */ AccountParams copy$default(AccountParams accountParams, boolean z, BusinessTypeParams businessTypeParams2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = accountParams.tosShownAndAccepted;
        }
        if ((i & 2) != 0) {
            businessTypeParams2 = accountParams.businessTypeParams;
        }
        return accountParams.copy(z, businessTypeParams2);
    }

    @JvmStatic
    public static final AccountParams create(boolean z) {
        return Companion.create(z);
    }

    @JvmStatic
    public static final AccountParams create(boolean z, BusinessType businessType) {
        return Companion.create(z, businessType);
    }

    @JvmStatic
    public static final AccountParams create(boolean z, BusinessTypeParams.Company company) {
        return Companion.create(z, company);
    }

    @JvmStatic
    public static final AccountParams create(boolean z, BusinessTypeParams.Individual individual) {
        return Companion.create(z, individual);
    }

    public final AccountParams copy(boolean z, BusinessTypeParams businessTypeParams2) {
        return new AccountParams(z, businessTypeParams2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountParams)) {
            return false;
        }
        AccountParams accountParams = (AccountParams) obj;
        return this.tosShownAndAccepted == accountParams.tosShownAndAccepted && Intrinsics.areEqual((Object) this.businessTypeParams, (Object) accountParams.businessTypeParams);
    }

    public int hashCode() {
        boolean z = this.tosShownAndAccepted;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        BusinessTypeParams businessTypeParams2 = this.businessTypeParams;
        return i + (businessTypeParams2 == null ? 0 : businessTypeParams2.hashCode());
    }

    public String toString() {
        return "AccountParams(tosShownAndAccepted=" + this.tosShownAndAccepted + ", businessTypeParams=" + this.businessTypeParams + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.tosShownAndAccepted ? 1 : 0);
        parcel.writeParcelable(this.businessTypeParams, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AccountParams(boolean z, BusinessTypeParams businessTypeParams2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : businessTypeParams2);
    }

    public AccountParams(boolean z, BusinessTypeParams businessTypeParams2) {
        super(Token.Type.Account, (Set) null, 2, (DefaultConstructorMarker) null);
        this.tosShownAndAccepted = z;
        this.businessTypeParams = businessTypeParams2;
    }

    public Map<String, Object> getTypeDataParams() {
        Map map;
        Map mapOf = MapsKt.mapOf(TuplesKt.to(PARAM_TOS_SHOWN_AND_ACCEPTED, Boolean.valueOf(this.tosShownAndAccepted)));
        BusinessTypeParams businessTypeParams2 = this.businessTypeParams;
        if (businessTypeParams2 == null) {
            map = null;
        } else {
            map = MapsKt.mapOf(TuplesKt.to(PARAM_BUSINESS_TYPE, businessTypeParams2.getType$payments_core_release().getCode()), TuplesKt.to(businessTypeParams2.getType$payments_core_release().getCode(), businessTypeParams2.toParamMap()));
        }
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        return MapsKt.plus(mapOf, map);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stripe/android/model/AccountParams$BusinessType;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()Ljava/lang/String;", "Individual", "Company", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AccountParams.kt */
    public enum BusinessType {
        Individual("individual"),
        Company("company");
        
        private final String code;

        private BusinessType(String str) {
            this.code = str;
        }

        public final String getCode() {
            return this.code;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0011\u0012B\u000f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0010H\u0016R&\u0010\u0006\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0001\u0002\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/stripe/android/model/AccountParams$BusinessTypeParams;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "type", "Lcom/stripe/android/model/AccountParams$BusinessType;", "(Lcom/stripe/android/model/AccountParams$BusinessType;)V", "paramsList", "", "Lkotlin/Pair;", "", "", "getParamsList", "()Ljava/util/List;", "getType$payments_core_release", "()Lcom/stripe/android/model/AccountParams$BusinessType;", "toParamMap", "", "Company", "Individual", "Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Company;", "Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Individual;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AccountParams.kt */
    public static abstract class BusinessTypeParams implements StripeParamsModel, Parcelable {
        public static final int $stable = 0;
        private final BusinessType type;

        public /* synthetic */ BusinessTypeParams(BusinessType businessType, DefaultConstructorMarker defaultConstructorMarker) {
            this(businessType);
        }

        public abstract List<Pair<String, Object>> getParamsList();

        private BusinessTypeParams(BusinessType businessType) {
            this.type = businessType;
        }

        public final BusinessType getType$payments_core_release() {
            return this.type;
        }

        public Map<String, Object> toParamMap() {
            Map map;
            Map<String, Object> emptyMap = MapsKt.emptyMap();
            for (Pair pair : getParamsList()) {
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

        @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u001f\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u0000 _2\u00020\u0001:\u0004^_`aB­\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0015J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010L\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010M\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010!J¶\u0001\u0010Q\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010RJ\t\u0010S\u001a\u00020THÖ\u0001J\u0013\u0010U\u001a\u00020\b2\b\u0010V\u001a\u0004\u0018\u000104HÖ\u0003J\t\u0010W\u001a\u00020THÖ\u0001J\t\u0010X\u001a\u00020\u000bHÖ\u0001J\u0019\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020THÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010(\"\u0004\b,\u0010*R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b/\u0010!\"\u0004\b0\u0010#R(\u00101\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010403028VX\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010(\"\u0004\b8\u0010*R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010(\"\u0004\b:\u0010*R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010(\"\u0004\b<\u0010*R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010(\"\u0004\b>\u0010*R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006b"}, d2 = {"Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Company;", "Lcom/stripe/android/model/AccountParams$BusinessTypeParams;", "address", "Lcom/stripe/android/model/Address;", "addressKana", "Lcom/stripe/android/model/AddressJapanParams;", "addressKanji", "directorsProvided", "", "executivesProvided", "name", "", "nameKana", "nameKanji", "ownersProvided", "phone", "taxId", "taxIdRegistrar", "vatId", "verification", "Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Company$Verification;", "(Lcom/stripe/android/model/Address;Lcom/stripe/android/model/AddressJapanParams;Lcom/stripe/android/model/AddressJapanParams;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Company$Verification;)V", "getAddress", "()Lcom/stripe/android/model/Address;", "setAddress", "(Lcom/stripe/android/model/Address;)V", "getAddressKana", "()Lcom/stripe/android/model/AddressJapanParams;", "setAddressKana", "(Lcom/stripe/android/model/AddressJapanParams;)V", "getAddressKanji", "setAddressKanji", "getDirectorsProvided", "()Ljava/lang/Boolean;", "setDirectorsProvided", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getExecutivesProvided", "setExecutivesProvided", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getNameKana", "setNameKana", "getNameKanji", "setNameKanji", "getOwnersProvided", "setOwnersProvided", "paramsList", "", "Lkotlin/Pair;", "", "getParamsList", "()Ljava/util/List;", "getPhone", "setPhone", "getTaxId", "setTaxId", "getTaxIdRegistrar", "setTaxIdRegistrar", "getVatId", "setVatId", "getVerification", "()Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Company$Verification;", "setVerification", "(Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Company$Verification;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/stripe/android/model/Address;Lcom/stripe/android/model/AddressJapanParams;Lcom/stripe/android/model/AddressJapanParams;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Company$Verification;)Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Company;", "describeContents", "", "equals", "other", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Builder", "Companion", "Document", "Verification", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AccountParams.kt */
        public static final class Company extends BusinessTypeParams {
            public static final int $stable = 8;
            public static final Parcelable.Creator<Company> CREATOR = new Creator();
            private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            @Deprecated
            private static final String PARAM_ADDRESS = "address";
            @Deprecated
            private static final String PARAM_ADDRESS_KANA = "address_kana";
            @Deprecated
            private static final String PARAM_ADDRESS_KANJI = "address_kanji";
            @Deprecated
            private static final String PARAM_DIRECTORS_PROVIDED = "directors_provided";
            @Deprecated
            private static final String PARAM_EXECUTIVES_PROVIDED = "executives_provided";
            @Deprecated
            private static final String PARAM_NAME = "name";
            @Deprecated
            private static final String PARAM_NAME_KANA = "name_kana";
            @Deprecated
            private static final String PARAM_NAME_KANJI = "name_kanji";
            @Deprecated
            private static final String PARAM_OWNERS_PROVIDED = "owners_provided";
            @Deprecated
            private static final String PARAM_PHONE = "phone";
            @Deprecated
            private static final String PARAM_TAX_ID = "tax_id";
            @Deprecated
            private static final String PARAM_TAX_ID_REGISTRAR = "tax_id_registrar";
            @Deprecated
            private static final String PARAM_VAT_ID = "vat_id";
            @Deprecated
            private static final String PARAM_VERIFICATION = "verification";
            private Address address;
            private AddressJapanParams addressKana;
            private AddressJapanParams addressKanji;
            private Boolean directorsProvided;
            private Boolean executivesProvided;
            private String name;
            private String nameKana;
            private String nameKanji;
            private Boolean ownersProvided;
            private String phone;
            private String taxId;
            private String taxIdRegistrar;
            private String vatId;
            private Verification verification;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: AccountParams.kt */
            public static final class Creator implements Parcelable.Creator<Company> {
                public final Company createFromParcel(Parcel parcel) {
                    Boolean bool;
                    Boolean bool2;
                    Boolean bool3;
                    Parcel parcel2 = parcel;
                    Intrinsics.checkNotNullParameter(parcel2, "parcel");
                    Verification verification = null;
                    Address createFromParcel = parcel.readInt() == 0 ? null : Address.CREATOR.createFromParcel(parcel2);
                    AddressJapanParams createFromParcel2 = parcel.readInt() == 0 ? null : AddressJapanParams.CREATOR.createFromParcel(parcel2);
                    AddressJapanParams createFromParcel3 = parcel.readInt() == 0 ? null : AddressJapanParams.CREATOR.createFromParcel(parcel2);
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
                    String readString = parcel.readString();
                    String readString2 = parcel.readString();
                    String readString3 = parcel.readString();
                    if (parcel.readInt() == 0) {
                        bool3 = null;
                    } else {
                        if (parcel.readInt() == 0) {
                            z = false;
                        }
                        bool3 = Boolean.valueOf(z);
                    }
                    String readString4 = parcel.readString();
                    String readString5 = parcel.readString();
                    String readString6 = parcel.readString();
                    String readString7 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        verification = Verification.CREATOR.createFromParcel(parcel2);
                    }
                    return new Company(createFromParcel, createFromParcel2, createFromParcel3, bool, bool2, readString, readString2, readString3, bool3, readString4, readString5, readString6, readString7, verification);
                }

                public final Company[] newArray(int i) {
                    return new Company[i];
                }
            }

            public Company() {
                this((Address) null, (AddressJapanParams) null, (AddressJapanParams) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (Verification) null, 16383, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Company copy$default(Company company, Address address2, AddressJapanParams addressJapanParams, AddressJapanParams addressJapanParams2, Boolean bool, Boolean bool2, String str, String str2, String str3, Boolean bool3, String str4, String str5, String str6, String str7, Verification verification2, int i, Object obj) {
                Company company2 = company;
                int i2 = i;
                return company.copy((i2 & 1) != 0 ? company2.address : address2, (i2 & 2) != 0 ? company2.addressKana : addressJapanParams, (i2 & 4) != 0 ? company2.addressKanji : addressJapanParams2, (i2 & 8) != 0 ? company2.directorsProvided : bool, (i2 & 16) != 0 ? company2.executivesProvided : bool2, (i2 & 32) != 0 ? company2.name : str, (i2 & 64) != 0 ? company2.nameKana : str2, (i2 & 128) != 0 ? company2.nameKanji : str3, (i2 & 256) != 0 ? company2.ownersProvided : bool3, (i2 & 512) != 0 ? company2.phone : str4, (i2 & 1024) != 0 ? company2.taxId : str5, (i2 & 2048) != 0 ? company2.taxIdRegistrar : str6, (i2 & 4096) != 0 ? company2.vatId : str7, (i2 & 8192) != 0 ? company2.verification : verification2);
            }

            public final Address component1() {
                return this.address;
            }

            public final String component10() {
                return this.phone;
            }

            public final String component11() {
                return this.taxId;
            }

            public final String component12() {
                return this.taxIdRegistrar;
            }

            public final String component13() {
                return this.vatId;
            }

            public final Verification component14() {
                return this.verification;
            }

            public final AddressJapanParams component2() {
                return this.addressKana;
            }

            public final AddressJapanParams component3() {
                return this.addressKanji;
            }

            public final Boolean component4() {
                return this.directorsProvided;
            }

            public final Boolean component5() {
                return this.executivesProvided;
            }

            public final String component6() {
                return this.name;
            }

            public final String component7() {
                return this.nameKana;
            }

            public final String component8() {
                return this.nameKanji;
            }

            public final Boolean component9() {
                return this.ownersProvided;
            }

            public final Company copy(Address address2, AddressJapanParams addressJapanParams, AddressJapanParams addressJapanParams2, Boolean bool, Boolean bool2, String str, String str2, String str3, Boolean bool3, String str4, String str5, String str6, String str7, Verification verification2) {
                return new Company(address2, addressJapanParams, addressJapanParams2, bool, bool2, str, str2, str3, bool3, str4, str5, str6, str7, verification2);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Company)) {
                    return false;
                }
                Company company = (Company) obj;
                return Intrinsics.areEqual((Object) this.address, (Object) company.address) && Intrinsics.areEqual((Object) this.addressKana, (Object) company.addressKana) && Intrinsics.areEqual((Object) this.addressKanji, (Object) company.addressKanji) && Intrinsics.areEqual((Object) this.directorsProvided, (Object) company.directorsProvided) && Intrinsics.areEqual((Object) this.executivesProvided, (Object) company.executivesProvided) && Intrinsics.areEqual((Object) this.name, (Object) company.name) && Intrinsics.areEqual((Object) this.nameKana, (Object) company.nameKana) && Intrinsics.areEqual((Object) this.nameKanji, (Object) company.nameKanji) && Intrinsics.areEqual((Object) this.ownersProvided, (Object) company.ownersProvided) && Intrinsics.areEqual((Object) this.phone, (Object) company.phone) && Intrinsics.areEqual((Object) this.taxId, (Object) company.taxId) && Intrinsics.areEqual((Object) this.taxIdRegistrar, (Object) company.taxIdRegistrar) && Intrinsics.areEqual((Object) this.vatId, (Object) company.vatId) && Intrinsics.areEqual((Object) this.verification, (Object) company.verification);
            }

            public int hashCode() {
                Address address2 = this.address;
                int i = 0;
                int hashCode = (address2 == null ? 0 : address2.hashCode()) * 31;
                AddressJapanParams addressJapanParams = this.addressKana;
                int hashCode2 = (hashCode + (addressJapanParams == null ? 0 : addressJapanParams.hashCode())) * 31;
                AddressJapanParams addressJapanParams2 = this.addressKanji;
                int hashCode3 = (hashCode2 + (addressJapanParams2 == null ? 0 : addressJapanParams2.hashCode())) * 31;
                Boolean bool = this.directorsProvided;
                int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
                Boolean bool2 = this.executivesProvided;
                int hashCode5 = (hashCode4 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
                String str = this.name;
                int hashCode6 = (hashCode5 + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.nameKana;
                int hashCode7 = (hashCode6 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.nameKanji;
                int hashCode8 = (hashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
                Boolean bool3 = this.ownersProvided;
                int hashCode9 = (hashCode8 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
                String str4 = this.phone;
                int hashCode10 = (hashCode9 + (str4 == null ? 0 : str4.hashCode())) * 31;
                String str5 = this.taxId;
                int hashCode11 = (hashCode10 + (str5 == null ? 0 : str5.hashCode())) * 31;
                String str6 = this.taxIdRegistrar;
                int hashCode12 = (hashCode11 + (str6 == null ? 0 : str6.hashCode())) * 31;
                String str7 = this.vatId;
                int hashCode13 = (hashCode12 + (str7 == null ? 0 : str7.hashCode())) * 31;
                Verification verification2 = this.verification;
                if (verification2 != null) {
                    i = verification2.hashCode();
                }
                return hashCode13 + i;
            }

            public String toString() {
                return "Company(address=" + this.address + ", addressKana=" + this.addressKana + ", addressKanji=" + this.addressKanji + ", directorsProvided=" + this.directorsProvided + ", executivesProvided=" + this.executivesProvided + ", name=" + this.name + ", nameKana=" + this.nameKana + ", nameKanji=" + this.nameKanji + ", ownersProvided=" + this.ownersProvided + ", phone=" + this.phone + ", taxId=" + this.taxId + ", taxIdRegistrar=" + this.taxIdRegistrar + ", vatId=" + this.vatId + ", verification=" + this.verification + ')';
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
                Boolean bool = this.directorsProvided;
                if (bool == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    parcel.writeInt(bool.booleanValue() ? 1 : 0);
                }
                Boolean bool2 = this.executivesProvided;
                if (bool2 == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    parcel.writeInt(bool2.booleanValue() ? 1 : 0);
                }
                parcel.writeString(this.name);
                parcel.writeString(this.nameKana);
                parcel.writeString(this.nameKanji);
                Boolean bool3 = this.ownersProvided;
                if (bool3 == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    parcel.writeInt(bool3.booleanValue() ? 1 : 0);
                }
                parcel.writeString(this.phone);
                parcel.writeString(this.taxId);
                parcel.writeString(this.taxIdRegistrar);
                parcel.writeString(this.vatId);
                Verification verification2 = this.verification;
                if (verification2 == null) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(1);
                verification2.writeToParcel(parcel, i);
            }

            public final Address getAddress() {
                return this.address;
            }

            public final void setAddress(Address address2) {
                this.address = address2;
            }

            public final AddressJapanParams getAddressKana() {
                return this.addressKana;
            }

            public final void setAddressKana(AddressJapanParams addressJapanParams) {
                this.addressKana = addressJapanParams;
            }

            public final AddressJapanParams getAddressKanji() {
                return this.addressKanji;
            }

            public final void setAddressKanji(AddressJapanParams addressJapanParams) {
                this.addressKanji = addressJapanParams;
            }

            public final Boolean getDirectorsProvided() {
                return this.directorsProvided;
            }

            public final void setDirectorsProvided(Boolean bool) {
                this.directorsProvided = bool;
            }

            public final Boolean getExecutivesProvided() {
                return this.executivesProvided;
            }

            public final void setExecutivesProvided(Boolean bool) {
                this.executivesProvided = bool;
            }

            public final String getName() {
                return this.name;
            }

            public final void setName(String str) {
                this.name = str;
            }

            public final String getNameKana() {
                return this.nameKana;
            }

            public final void setNameKana(String str) {
                this.nameKana = str;
            }

            public final String getNameKanji() {
                return this.nameKanji;
            }

            public final void setNameKanji(String str) {
                this.nameKanji = str;
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ Company(com.stripe.android.model.Address r16, com.stripe.android.model.AddressJapanParams r17, com.stripe.android.model.AddressJapanParams r18, java.lang.Boolean r19, java.lang.Boolean r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.Boolean r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, com.stripe.android.model.AccountParams.BusinessTypeParams.Company.Verification r29, int r30, kotlin.jvm.internal.DefaultConstructorMarker r31) {
                /*
                    r15 = this;
                    r0 = r30
                    r1 = r0 & 1
                    r2 = 0
                    if (r1 == 0) goto L_0x0009
                    r1 = r2
                    goto L_0x000b
                L_0x0009:
                    r1 = r16
                L_0x000b:
                    r3 = r0 & 2
                    if (r3 == 0) goto L_0x0011
                    r3 = r2
                    goto L_0x0013
                L_0x0011:
                    r3 = r17
                L_0x0013:
                    r4 = r0 & 4
                    if (r4 == 0) goto L_0x0019
                    r4 = r2
                    goto L_0x001b
                L_0x0019:
                    r4 = r18
                L_0x001b:
                    r5 = r0 & 8
                    if (r5 == 0) goto L_0x0021
                    r5 = r2
                    goto L_0x0023
                L_0x0021:
                    r5 = r19
                L_0x0023:
                    r6 = r0 & 16
                    if (r6 == 0) goto L_0x0029
                    r6 = r2
                    goto L_0x002b
                L_0x0029:
                    r6 = r20
                L_0x002b:
                    r7 = r0 & 32
                    if (r7 == 0) goto L_0x0031
                    r7 = r2
                    goto L_0x0033
                L_0x0031:
                    r7 = r21
                L_0x0033:
                    r8 = r0 & 64
                    if (r8 == 0) goto L_0x0039
                    r8 = r2
                    goto L_0x003b
                L_0x0039:
                    r8 = r22
                L_0x003b:
                    r9 = r0 & 128(0x80, float:1.794E-43)
                    if (r9 == 0) goto L_0x0041
                    r9 = r2
                    goto L_0x0043
                L_0x0041:
                    r9 = r23
                L_0x0043:
                    r10 = r0 & 256(0x100, float:3.59E-43)
                    if (r10 == 0) goto L_0x004d
                    r10 = 0
                    java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
                    goto L_0x004f
                L_0x004d:
                    r10 = r24
                L_0x004f:
                    r11 = r0 & 512(0x200, float:7.175E-43)
                    if (r11 == 0) goto L_0x0055
                    r11 = r2
                    goto L_0x0057
                L_0x0055:
                    r11 = r25
                L_0x0057:
                    r12 = r0 & 1024(0x400, float:1.435E-42)
                    if (r12 == 0) goto L_0x005d
                    r12 = r2
                    goto L_0x005f
                L_0x005d:
                    r12 = r26
                L_0x005f:
                    r13 = r0 & 2048(0x800, float:2.87E-42)
                    if (r13 == 0) goto L_0x0065
                    r13 = r2
                    goto L_0x0067
                L_0x0065:
                    r13 = r27
                L_0x0067:
                    r14 = r0 & 4096(0x1000, float:5.74E-42)
                    if (r14 == 0) goto L_0x006d
                    r14 = r2
                    goto L_0x006f
                L_0x006d:
                    r14 = r28
                L_0x006f:
                    r0 = r0 & 8192(0x2000, float:1.14794E-41)
                    if (r0 == 0) goto L_0x0074
                    goto L_0x0076
                L_0x0074:
                    r2 = r29
                L_0x0076:
                    r16 = r15
                    r17 = r1
                    r18 = r3
                    r19 = r4
                    r20 = r5
                    r21 = r6
                    r22 = r7
                    r23 = r8
                    r24 = r9
                    r25 = r10
                    r26 = r11
                    r27 = r12
                    r28 = r13
                    r29 = r14
                    r30 = r2
                    r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.AccountParams.BusinessTypeParams.Company.<init>(com.stripe.android.model.Address, com.stripe.android.model.AddressJapanParams, com.stripe.android.model.AddressJapanParams, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.stripe.android.model.AccountParams$BusinessTypeParams$Company$Verification, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
            }

            public final Boolean getOwnersProvided() {
                return this.ownersProvided;
            }

            public final void setOwnersProvided(Boolean bool) {
                this.ownersProvided = bool;
            }

            public final String getPhone() {
                return this.phone;
            }

            public final void setPhone(String str) {
                this.phone = str;
            }

            public final String getTaxId() {
                return this.taxId;
            }

            public final void setTaxId(String str) {
                this.taxId = str;
            }

            public final String getTaxIdRegistrar() {
                return this.taxIdRegistrar;
            }

            public final void setTaxIdRegistrar(String str) {
                this.taxIdRegistrar = str;
            }

            public final String getVatId() {
                return this.vatId;
            }

            public final void setVatId(String str) {
                this.vatId = str;
            }

            public final Verification getVerification() {
                return this.verification;
            }

            public final void setVerification(Verification verification2) {
                this.verification = verification2;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Company(Address address2, AddressJapanParams addressJapanParams, AddressJapanParams addressJapanParams2, Boolean bool, Boolean bool2, String str, String str2, String str3, Boolean bool3, String str4, String str5, String str6, String str7, Verification verification2) {
                super(BusinessType.Company, (DefaultConstructorMarker) null);
                this.address = address2;
                this.addressKana = addressJapanParams;
                this.addressKanji = addressJapanParams2;
                this.directorsProvided = bool;
                this.executivesProvided = bool2;
                this.name = str;
                this.nameKana = str2;
                this.nameKanji = str3;
                this.ownersProvided = bool3;
                this.phone = str4;
                this.taxId = str5;
                this.taxIdRegistrar = str6;
                this.vatId = str7;
                this.verification = verification2;
            }

            public List<Pair<String, Object>> getParamsList() {
                Pair[] pairArr = new Pair[14];
                Address address2 = this.address;
                Map<String, Object> map = null;
                pairArr[0] = TuplesKt.to("address", address2 == null ? null : address2.toParamMap());
                AddressJapanParams addressJapanParams = this.addressKana;
                pairArr[1] = TuplesKt.to(PARAM_ADDRESS_KANA, addressJapanParams == null ? null : addressJapanParams.toParamMap());
                AddressJapanParams addressJapanParams2 = this.addressKanji;
                pairArr[2] = TuplesKt.to(PARAM_ADDRESS_KANJI, addressJapanParams2 == null ? null : addressJapanParams2.toParamMap());
                pairArr[3] = TuplesKt.to(PARAM_DIRECTORS_PROVIDED, this.directorsProvided);
                pairArr[4] = TuplesKt.to(PARAM_EXECUTIVES_PROVIDED, this.executivesProvided);
                pairArr[5] = TuplesKt.to("name", this.name);
                pairArr[6] = TuplesKt.to(PARAM_NAME_KANA, this.nameKana);
                pairArr[7] = TuplesKt.to(PARAM_NAME_KANJI, this.nameKanji);
                pairArr[8] = TuplesKt.to(PARAM_OWNERS_PROVIDED, this.ownersProvided);
                pairArr[9] = TuplesKt.to("phone", this.phone);
                pairArr[10] = TuplesKt.to(PARAM_TAX_ID, this.taxId);
                pairArr[11] = TuplesKt.to(PARAM_TAX_ID_REGISTRAR, this.taxIdRegistrar);
                pairArr[12] = TuplesKt.to(PARAM_VAT_ID, this.vatId);
                Verification verification2 = this.verification;
                if (verification2 != null) {
                    map = verification2.toParamMap();
                }
                pairArr[13] = TuplesKt.to(PARAM_VERIFICATION, map);
                return CollectionsKt.listOf(pairArr);
            }

            @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00100\u0013H\u0016J\t\u0010\u0015\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fHÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Company$Verification;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "document", "Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Company$Document;", "(Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Company$Document;)V", "getDocument", "()Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Company$Document;", "setDocument", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: AccountParams.kt */
            public static final class Verification implements StripeParamsModel, Parcelable {
                public static final int $stable = 8;
                public static final Parcelable.Creator<Verification> CREATOR = new Creator();
                private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
                @Deprecated
                private static final String PARAM_DOCUMENT = "document";
                private Document document;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                /* compiled from: AccountParams.kt */
                public static final class Creator implements Parcelable.Creator<Verification> {
                    public final Verification createFromParcel(Parcel parcel) {
                        Intrinsics.checkNotNullParameter(parcel, "parcel");
                        return new Verification(parcel.readInt() == 0 ? null : Document.CREATOR.createFromParcel(parcel));
                    }

                    public final Verification[] newArray(int i) {
                        return new Verification[i];
                    }
                }

                public Verification() {
                    this((Document) null, 1, (DefaultConstructorMarker) null);
                }

                public static /* synthetic */ Verification copy$default(Verification verification, Document document2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        document2 = verification.document;
                    }
                    return verification.copy(document2);
                }

                public final Document component1() {
                    return this.document;
                }

                public final Verification copy(Document document2) {
                    return new Verification(document2);
                }

                public int describeContents() {
                    return 0;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof Verification) && Intrinsics.areEqual((Object) this.document, (Object) ((Verification) obj).document);
                }

                public int hashCode() {
                    Document document2 = this.document;
                    if (document2 == null) {
                        return 0;
                    }
                    return document2.hashCode();
                }

                public String toString() {
                    return "Verification(document=" + this.document + ')';
                }

                public void writeToParcel(Parcel parcel, int i) {
                    Intrinsics.checkNotNullParameter(parcel, "out");
                    Document document2 = this.document;
                    if (document2 == null) {
                        parcel.writeInt(0);
                        return;
                    }
                    parcel.writeInt(1);
                    document2.writeToParcel(parcel, i);
                }

                public Verification(Document document2) {
                    this.document = document2;
                }

                /* JADX INFO: this call moved to the top of the method (can break code semantics) */
                public /* synthetic */ Verification(Document document2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this((i & 1) != 0 ? null : document2);
                }

                public final Document getDocument() {
                    return this.document;
                }

                public final void setDocument(Document document2) {
                    this.document = document2;
                }

                public Map<String, Object> toParamMap() {
                    Map<String, Object> map;
                    Document document2 = this.document;
                    if (document2 == null) {
                        map = null;
                    } else {
                        map = MapsKt.mapOf(TuplesKt.to(PARAM_DOCUMENT, document2.toParamMap()));
                    }
                    return map == null ? MapsKt.emptyMap() : map;
                }

                @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Company$Verification$Companion;", "", "()V", "PARAM_DOCUMENT", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
                /* compiled from: AccountParams.kt */
                private static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }
                }
            }

            @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u001f\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÂ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0004HÂ\u0003J!\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bHÖ\u0001R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Company$Document;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "front", "", "back", "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: AccountParams.kt */
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
                /* compiled from: AccountParams.kt */
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

                private final String component1() {
                    return this.front;
                }

                private final String component2() {
                    return this.back;
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

                public Map<String, Object> toParamMap() {
                    Map map;
                    Pair[] pairArr = {TuplesKt.to(PARAM_FRONT, this.front), TuplesKt.to(PARAM_BACK, this.back)};
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

                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Company$Document$Companion;", "", "()V", "PARAM_BACK", "", "PARAM_FRONT", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
                /* compiled from: AccountParams.kt */
                private static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }
                }
            }

            @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001b\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0015\u0010\u001c\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010 \u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010!\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eJ\u0015\u0010\"\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u001dJ\u0010\u0010#\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010$\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010%\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010&\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010'\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Company$Builder;", "Lcom/stripe/android/ObjectBuilder;", "Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Company;", "()V", "address", "Lcom/stripe/android/model/Address;", "addressKana", "Lcom/stripe/android/model/AddressJapanParams;", "addressKanji", "directorsProvided", "", "Ljava/lang/Boolean;", "executivesProvided", "name", "", "nameKana", "nameKanji", "ownersProvided", "phone", "taxId", "taxIdRegistrar", "vatId", "verification", "Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Company$Verification;", "build", "setAddress", "setAddressKana", "setAddressKanji", "setDirectorsProvided", "(Ljava/lang/Boolean;)Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Company$Builder;", "setExecutivesProvided", "setName", "setNameKana", "setNameKanji", "setOwnersProvided", "setPhone", "setTaxId", "setTaxIdRegistrar", "setVatId", "setVerification", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: AccountParams.kt */
            public static final class Builder implements ObjectBuilder<Company> {
                public static final int $stable = 8;
                private Address address;
                private AddressJapanParams addressKana;
                private AddressJapanParams addressKanji;
                private Boolean directorsProvided;
                private Boolean executivesProvided;
                private String name;
                private String nameKana;
                private String nameKanji;
                private Boolean ownersProvided;
                private String phone;
                private String taxId;
                private String taxIdRegistrar;
                private String vatId;
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

                public final Builder setDirectorsProvided(Boolean bool) {
                    Builder builder = this;
                    builder.directorsProvided = bool;
                    return builder;
                }

                public final Builder setExecutivesProvided(Boolean bool) {
                    Builder builder = this;
                    builder.executivesProvided = bool;
                    return builder;
                }

                public final Builder setName(String str) {
                    Builder builder = this;
                    builder.name = str;
                    return builder;
                }

                public final Builder setNameKana(String str) {
                    Builder builder = this;
                    builder.nameKana = str;
                    return builder;
                }

                public final Builder setNameKanji(String str) {
                    Builder builder = this;
                    builder.nameKanji = str;
                    return builder;
                }

                public final Builder setOwnersProvided(Boolean bool) {
                    Builder builder = this;
                    builder.ownersProvided = bool;
                    return builder;
                }

                public final Builder setPhone(String str) {
                    Builder builder = this;
                    builder.phone = str;
                    return builder;
                }

                public final Builder setTaxId(String str) {
                    Builder builder = this;
                    builder.taxId = str;
                    return builder;
                }

                public final Builder setTaxIdRegistrar(String str) {
                    Builder builder = this;
                    builder.taxIdRegistrar = str;
                    return builder;
                }

                public final Builder setVatId(String str) {
                    Builder builder = this;
                    builder.vatId = str;
                    return builder;
                }

                public final Builder setVerification(Verification verification2) {
                    Builder builder = this;
                    builder.verification = verification2;
                    return builder;
                }

                public Company build() {
                    return new Company(this.address, this.addressKana, this.addressKanji, this.directorsProvided, this.executivesProvided, this.name, this.nameKana, this.nameKanji, this.ownersProvided, this.phone, this.taxId, this.taxIdRegistrar, this.vatId, this.verification);
                }
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Company$Companion;", "", "()V", "PARAM_ADDRESS", "", "PARAM_ADDRESS_KANA", "PARAM_ADDRESS_KANJI", "PARAM_DIRECTORS_PROVIDED", "PARAM_EXECUTIVES_PROVIDED", "PARAM_NAME", "PARAM_NAME_KANA", "PARAM_NAME_KANJI", "PARAM_OWNERS_PROVIDED", "PARAM_PHONE", "PARAM_TAX_ID", "PARAM_TAX_ID_REGISTRAR", "PARAM_VAT_ID", "PARAM_VERIFICATION", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: AccountParams.kt */
            private static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }

        @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u001e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u0000 q2\u00020\u0001:\u0004pqrsBé\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0017\u0010W\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0015HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\nHÆ\u0003Jí\u0001\u0010c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001J\t\u0010d\u001a\u00020eHÖ\u0001J\u0013\u0010f\u001a\u00020g2\b\u0010h\u001a\u0004\u0018\u00010FHÖ\u0003J\t\u0010i\u001a\u00020eHÖ\u0001J\t\u0010j\u001a\u00020\nHÖ\u0001J\u0019\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020n2\u0006\u0010o\u001a\u00020eHÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010*\"\u0004\b.\u0010,R\u001c\u0010\f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R\u001c\u0010\r\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010*\"\u0004\b2\u0010,R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010*\"\u0004\b4\u0010,R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010*\"\u0004\b6\u0010,R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010*\"\u0004\b8\u0010,R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010*\"\u0004\b:\u0010,R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010*\"\u0004\b<\u0010,R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010*\"\u0004\b>\u0010,R(\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR(\u0010C\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010F0E0D8VX\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010*\"\u0004\bJ\u0010,R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010*\"\u0004\bL\u0010,R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006t"}, d2 = {"Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Individual;", "Lcom/stripe/android/model/AccountParams$BusinessTypeParams;", "address", "Lcom/stripe/android/model/Address;", "addressKana", "Lcom/stripe/android/model/AddressJapanParams;", "addressKanji", "dateOfBirth", "Lcom/stripe/android/model/DateOfBirth;", "email", "", "firstName", "firstNameKana", "firstNameKanji", "gender", "idNumber", "lastName", "lastNameKana", "lastNameKanji", "maidenName", "metadata", "", "phone", "ssnLast4", "verification", "Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Individual$Verification;", "(Lcom/stripe/android/model/Address;Lcom/stripe/android/model/AddressJapanParams;Lcom/stripe/android/model/AddressJapanParams;Lcom/stripe/android/model/DateOfBirth;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Individual$Verification;)V", "getAddress", "()Lcom/stripe/android/model/Address;", "setAddress", "(Lcom/stripe/android/model/Address;)V", "getAddressKana", "()Lcom/stripe/android/model/AddressJapanParams;", "setAddressKana", "(Lcom/stripe/android/model/AddressJapanParams;)V", "getAddressKanji", "setAddressKanji", "getDateOfBirth", "()Lcom/stripe/android/model/DateOfBirth;", "setDateOfBirth", "(Lcom/stripe/android/model/DateOfBirth;)V", "getEmail", "()Ljava/lang/String;", "setEmail", "(Ljava/lang/String;)V", "getFirstName", "setFirstName", "getFirstNameKana", "setFirstNameKana", "getFirstNameKanji", "setFirstNameKanji", "getGender", "setGender", "getIdNumber", "setIdNumber", "getLastName", "setLastName", "getLastNameKana", "setLastNameKana", "getLastNameKanji", "setLastNameKanji", "getMaidenName", "setMaidenName", "getMetadata", "()Ljava/util/Map;", "setMetadata", "(Ljava/util/Map;)V", "paramsList", "", "Lkotlin/Pair;", "", "getParamsList", "()Ljava/util/List;", "getPhone", "setPhone", "getSsnLast4", "setSsnLast4", "getVerification", "()Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Individual$Verification;", "setVerification", "(Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Individual$Verification;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Builder", "Companion", "Document", "Verification", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AccountParams.kt */
        public static final class Individual extends BusinessTypeParams {
            public static final int $stable = 8;
            public static final Parcelable.Creator<Individual> CREATOR = new Creator();
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
            private static final String PARAM_PHONE = "phone";
            @Deprecated
            private static final String PARAM_SSN_LAST_4 = "ssn_last_4";
            @Deprecated
            private static final String PARAM_VERIFICATION = "verification";
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
            private String ssnLast4;
            private Verification verification;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: AccountParams.kt */
            public static final class Creator implements Parcelable.Creator<Individual> {
                public final Individual createFromParcel(Parcel parcel) {
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
                    return new Individual(createFromParcel, createFromParcel2, createFromParcel3, createFromParcel4, readString, readString2, readString3, readString4, readString5, readString6, readString7, str, readString9, readString10, linkedHashMap, parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Verification.CREATOR.createFromParcel(parcel2));
                }

                public final Individual[] newArray(int i) {
                    return new Individual[i];
                }
            }

            public Individual() {
                this((Address) null, (AddressJapanParams) null, (AddressJapanParams) null, (DateOfBirth) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Map) null, (String) null, (String) null, (Verification) null, 262143, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Individual copy$default(Individual individual, Address address2, AddressJapanParams addressJapanParams, AddressJapanParams addressJapanParams2, DateOfBirth dateOfBirth2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Map map, String str11, String str12, Verification verification2, int i, Object obj) {
                Individual individual2 = individual;
                int i2 = i;
                return individual.copy((i2 & 1) != 0 ? individual2.address : address2, (i2 & 2) != 0 ? individual2.addressKana : addressJapanParams, (i2 & 4) != 0 ? individual2.addressKanji : addressJapanParams2, (i2 & 8) != 0 ? individual2.dateOfBirth : dateOfBirth2, (i2 & 16) != 0 ? individual2.email : str, (i2 & 32) != 0 ? individual2.firstName : str2, (i2 & 64) != 0 ? individual2.firstNameKana : str3, (i2 & 128) != 0 ? individual2.firstNameKanji : str4, (i2 & 256) != 0 ? individual2.gender : str5, (i2 & 512) != 0 ? individual2.idNumber : str6, (i2 & 1024) != 0 ? individual2.lastName : str7, (i2 & 2048) != 0 ? individual2.lastNameKana : str8, (i2 & 4096) != 0 ? individual2.lastNameKanji : str9, (i2 & 8192) != 0 ? individual2.maidenName : str10, (i2 & 16384) != 0 ? individual2.metadata : map, (i2 & 32768) != 0 ? individual2.phone : str11, (i2 & 65536) != 0 ? individual2.ssnLast4 : str12, (i2 & 131072) != 0 ? individual2.verification : verification2);
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

            public final String component17() {
                return this.ssnLast4;
            }

            public final Verification component18() {
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

            public final Individual copy(Address address2, AddressJapanParams addressJapanParams, AddressJapanParams addressJapanParams2, DateOfBirth dateOfBirth2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Map<String, String> map, String str11, String str12, Verification verification2) {
                return new Individual(address2, addressJapanParams, addressJapanParams2, dateOfBirth2, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, map, str11, str12, verification2);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Individual)) {
                    return false;
                }
                Individual individual = (Individual) obj;
                return Intrinsics.areEqual((Object) this.address, (Object) individual.address) && Intrinsics.areEqual((Object) this.addressKana, (Object) individual.addressKana) && Intrinsics.areEqual((Object) this.addressKanji, (Object) individual.addressKanji) && Intrinsics.areEqual((Object) this.dateOfBirth, (Object) individual.dateOfBirth) && Intrinsics.areEqual((Object) this.email, (Object) individual.email) && Intrinsics.areEqual((Object) this.firstName, (Object) individual.firstName) && Intrinsics.areEqual((Object) this.firstNameKana, (Object) individual.firstNameKana) && Intrinsics.areEqual((Object) this.firstNameKanji, (Object) individual.firstNameKanji) && Intrinsics.areEqual((Object) this.gender, (Object) individual.gender) && Intrinsics.areEqual((Object) this.idNumber, (Object) individual.idNumber) && Intrinsics.areEqual((Object) this.lastName, (Object) individual.lastName) && Intrinsics.areEqual((Object) this.lastNameKana, (Object) individual.lastNameKana) && Intrinsics.areEqual((Object) this.lastNameKanji, (Object) individual.lastNameKanji) && Intrinsics.areEqual((Object) this.maidenName, (Object) individual.maidenName) && Intrinsics.areEqual((Object) this.metadata, (Object) individual.metadata) && Intrinsics.areEqual((Object) this.phone, (Object) individual.phone) && Intrinsics.areEqual((Object) this.ssnLast4, (Object) individual.ssnLast4) && Intrinsics.areEqual((Object) this.verification, (Object) individual.verification);
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
                String str12 = this.ssnLast4;
                int hashCode17 = (hashCode16 + (str12 == null ? 0 : str12.hashCode())) * 31;
                Verification verification2 = this.verification;
                if (verification2 != null) {
                    i = verification2.hashCode();
                }
                return hashCode17 + i;
            }

            public String toString() {
                return "Individual(address=" + this.address + ", addressKana=" + this.addressKana + ", addressKanji=" + this.addressKanji + ", dateOfBirth=" + this.dateOfBirth + ", email=" + this.email + ", firstName=" + this.firstName + ", firstNameKana=" + this.firstNameKana + ", firstNameKanji=" + this.firstNameKanji + ", gender=" + this.gender + ", idNumber=" + this.idNumber + ", lastName=" + this.lastName + ", lastNameKana=" + this.lastNameKana + ", lastNameKanji=" + this.lastNameKanji + ", maidenName=" + this.maidenName + ", metadata=" + this.metadata + ", phone=" + this.phone + ", ssnLast4=" + this.ssnLast4 + ", verification=" + this.verification + ')';
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
            public /* synthetic */ Individual(com.stripe.android.model.Address r20, com.stripe.android.model.AddressJapanParams r21, com.stripe.android.model.AddressJapanParams r22, com.stripe.android.model.DateOfBirth r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.util.Map r34, java.lang.String r35, java.lang.String r36, com.stripe.android.model.AccountParams.BusinessTypeParams.Individual.Verification r37, int r38, kotlin.jvm.internal.DefaultConstructorMarker r39) {
                /*
                    r19 = this;
                    r0 = r38
                    r1 = r0 & 1
                    if (r1 == 0) goto L_0x0008
                    r1 = 0
                    goto L_0x000a
                L_0x0008:
                    r1 = r20
                L_0x000a:
                    r3 = r0 & 2
                    if (r3 == 0) goto L_0x0010
                    r3 = 0
                    goto L_0x0012
                L_0x0010:
                    r3 = r21
                L_0x0012:
                    r4 = r0 & 4
                    if (r4 == 0) goto L_0x0018
                    r4 = 0
                    goto L_0x001a
                L_0x0018:
                    r4 = r22
                L_0x001a:
                    r5 = r0 & 8
                    if (r5 == 0) goto L_0x0020
                    r5 = 0
                    goto L_0x0022
                L_0x0020:
                    r5 = r23
                L_0x0022:
                    r6 = r0 & 16
                    if (r6 == 0) goto L_0x0028
                    r6 = 0
                    goto L_0x002a
                L_0x0028:
                    r6 = r24
                L_0x002a:
                    r7 = r0 & 32
                    if (r7 == 0) goto L_0x0030
                    r7 = 0
                    goto L_0x0032
                L_0x0030:
                    r7 = r25
                L_0x0032:
                    r8 = r0 & 64
                    if (r8 == 0) goto L_0x0038
                    r8 = 0
                    goto L_0x003a
                L_0x0038:
                    r8 = r26
                L_0x003a:
                    r9 = r0 & 128(0x80, float:1.794E-43)
                    if (r9 == 0) goto L_0x0040
                    r9 = 0
                    goto L_0x0042
                L_0x0040:
                    r9 = r27
                L_0x0042:
                    r10 = r0 & 256(0x100, float:3.59E-43)
                    if (r10 == 0) goto L_0x0048
                    r10 = 0
                    goto L_0x004a
                L_0x0048:
                    r10 = r28
                L_0x004a:
                    r11 = r0 & 512(0x200, float:7.175E-43)
                    if (r11 == 0) goto L_0x0050
                    r11 = 0
                    goto L_0x0052
                L_0x0050:
                    r11 = r29
                L_0x0052:
                    r12 = r0 & 1024(0x400, float:1.435E-42)
                    if (r12 == 0) goto L_0x0058
                    r12 = 0
                    goto L_0x005a
                L_0x0058:
                    r12 = r30
                L_0x005a:
                    r13 = r0 & 2048(0x800, float:2.87E-42)
                    if (r13 == 0) goto L_0x0060
                    r13 = 0
                    goto L_0x0062
                L_0x0060:
                    r13 = r31
                L_0x0062:
                    r14 = r0 & 4096(0x1000, float:5.74E-42)
                    if (r14 == 0) goto L_0x0068
                    r14 = 0
                    goto L_0x006a
                L_0x0068:
                    r14 = r32
                L_0x006a:
                    r15 = r0 & 8192(0x2000, float:1.14794E-41)
                    if (r15 == 0) goto L_0x0070
                    r15 = 0
                    goto L_0x0072
                L_0x0070:
                    r15 = r33
                L_0x0072:
                    r2 = r0 & 16384(0x4000, float:2.2959E-41)
                    if (r2 == 0) goto L_0x0078
                    r2 = 0
                    goto L_0x007a
                L_0x0078:
                    r2 = r34
                L_0x007a:
                    r16 = 32768(0x8000, float:4.5918E-41)
                    r16 = r0 & r16
                    if (r16 == 0) goto L_0x0084
                    r16 = 0
                    goto L_0x0086
                L_0x0084:
                    r16 = r35
                L_0x0086:
                    r17 = 65536(0x10000, float:9.18355E-41)
                    r17 = r0 & r17
                    if (r17 == 0) goto L_0x008f
                    r17 = 0
                    goto L_0x0091
                L_0x008f:
                    r17 = r36
                L_0x0091:
                    r18 = 131072(0x20000, float:1.83671E-40)
                    r0 = r0 & r18
                    if (r0 == 0) goto L_0x0099
                    r0 = 0
                    goto L_0x009b
                L_0x0099:
                    r0 = r37
                L_0x009b:
                    r20 = r19
                    r21 = r1
                    r22 = r3
                    r23 = r4
                    r24 = r5
                    r25 = r6
                    r26 = r7
                    r27 = r8
                    r28 = r9
                    r29 = r10
                    r30 = r11
                    r31 = r12
                    r32 = r13
                    r33 = r14
                    r34 = r15
                    r35 = r2
                    r36 = r16
                    r37 = r17
                    r38 = r0
                    r20.<init>(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.AccountParams.BusinessTypeParams.Individual.<init>(com.stripe.android.model.Address, com.stripe.android.model.AddressJapanParams, com.stripe.android.model.AddressJapanParams, com.stripe.android.model.DateOfBirth, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, java.lang.String, java.lang.String, com.stripe.android.model.AccountParams$BusinessTypeParams$Individual$Verification, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
            }

            public final Address getAddress() {
                return this.address;
            }

            public final void setAddress(Address address2) {
                this.address = address2;
            }

            public final AddressJapanParams getAddressKana() {
                return this.addressKana;
            }

            public final void setAddressKana(AddressJapanParams addressJapanParams) {
                this.addressKana = addressJapanParams;
            }

            public final AddressJapanParams getAddressKanji() {
                return this.addressKanji;
            }

            public final void setAddressKanji(AddressJapanParams addressJapanParams) {
                this.addressKanji = addressJapanParams;
            }

            public final DateOfBirth getDateOfBirth() {
                return this.dateOfBirth;
            }

            public final void setDateOfBirth(DateOfBirth dateOfBirth2) {
                this.dateOfBirth = dateOfBirth2;
            }

            public final String getEmail() {
                return this.email;
            }

            public final void setEmail(String str) {
                this.email = str;
            }

            public final String getFirstName() {
                return this.firstName;
            }

            public final void setFirstName(String str) {
                this.firstName = str;
            }

            public final String getFirstNameKana() {
                return this.firstNameKana;
            }

            public final void setFirstNameKana(String str) {
                this.firstNameKana = str;
            }

            public final String getFirstNameKanji() {
                return this.firstNameKanji;
            }

            public final void setFirstNameKanji(String str) {
                this.firstNameKanji = str;
            }

            public final String getGender() {
                return this.gender;
            }

            public final void setGender(String str) {
                this.gender = str;
            }

            public final String getIdNumber() {
                return this.idNumber;
            }

            public final void setIdNumber(String str) {
                this.idNumber = str;
            }

            public final String getLastName() {
                return this.lastName;
            }

            public final void setLastName(String str) {
                this.lastName = str;
            }

            public final String getLastNameKana() {
                return this.lastNameKana;
            }

            public final void setLastNameKana(String str) {
                this.lastNameKana = str;
            }

            public final String getLastNameKanji() {
                return this.lastNameKanji;
            }

            public final void setLastNameKanji(String str) {
                this.lastNameKanji = str;
            }

            public final String getMaidenName() {
                return this.maidenName;
            }

            public final void setMaidenName(String str) {
                this.maidenName = str;
            }

            public final Map<String, String> getMetadata() {
                return this.metadata;
            }

            public final void setMetadata(Map<String, String> map) {
                this.metadata = map;
            }

            public final String getPhone() {
                return this.phone;
            }

            public final void setPhone(String str) {
                this.phone = str;
            }

            public final String getSsnLast4() {
                return this.ssnLast4;
            }

            public final void setSsnLast4(String str) {
                this.ssnLast4 = str;
            }

            public final Verification getVerification() {
                return this.verification;
            }

            public final void setVerification(Verification verification2) {
                this.verification = verification2;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Individual(Address address2, AddressJapanParams addressJapanParams, AddressJapanParams addressJapanParams2, DateOfBirth dateOfBirth2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Map<String, String> map, String str11, String str12, Verification verification2) {
                super(BusinessType.Individual, (DefaultConstructorMarker) null);
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
                this.ssnLast4 = str12;
                this.verification = verification2;
            }

            public List<Pair<String, Object>> getParamsList() {
                Pair[] pairArr = new Pair[18];
                Address address2 = this.address;
                Map<String, Object> map = null;
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
                pairArr[16] = TuplesKt.to(PARAM_SSN_LAST_4, this.ssnLast4);
                Verification verification2 = this.verification;
                if (verification2 != null) {
                    map = verification2.toParamMap();
                }
                pairArr[17] = TuplesKt.to(PARAM_VERIFICATION, map);
                return CollectionsKt.listOf(pairArr);
            }

            @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u001f\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00150\u0018H\u0016J\t\u0010\u001a\u001a\u00020\u0019HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006!"}, d2 = {"Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Individual$Verification;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "document", "Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Individual$Document;", "additionalDocument", "(Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Individual$Document;Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Individual$Document;)V", "getAdditionalDocument", "()Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Individual$Document;", "setAdditionalDocument", "(Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Individual$Document;)V", "getDocument", "setDocument", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: AccountParams.kt */
            public static final class Verification implements StripeParamsModel, Parcelable {
                public static final int $stable = 8;
                public static final Parcelable.Creator<Verification> CREATOR = new Creator();
                private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
                @Deprecated
                private static final String PARAM_ADDITIONAL_DOCUMENT = "additional_document";
                @Deprecated
                private static final String PARAM_DOCUMENT = "document";
                private Document additionalDocument;
                private Document document;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                /* compiled from: AccountParams.kt */
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

                public final void setDocument(Document document2) {
                    this.document = document2;
                }

                public final Document getAdditionalDocument() {
                    return this.additionalDocument;
                }

                public final void setAdditionalDocument(Document document2) {
                    this.additionalDocument = document2;
                }

                public Map<String, Object> toParamMap() {
                    Map map;
                    Pair[] pairArr = new Pair[2];
                    Document document2 = this.additionalDocument;
                    pairArr[0] = TuplesKt.to(PARAM_ADDITIONAL_DOCUMENT, document2 == null ? null : document2.toParamMap());
                    Document document3 = this.document;
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

                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Individual$Verification$Companion;", "", "()V", "PARAM_ADDITIONAL_DOCUMENT", "", "PARAM_DOCUMENT", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
                /* compiled from: AccountParams.kt */
                private static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }
                }
            }

            @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00192\u00020\u00012\u00020\u0002:\u0001\u0019B\u001f\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÂ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0004HÂ\u0003J!\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000bHÖ\u0001R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Individual$Document;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "front", "", "back", "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: AccountParams.kt */
            public static final class Document implements StripeParamsModel, Parcelable {
                public static final int $stable = 8;
                public static final Parcelable.Creator<Document> CREATOR = new Creator();
                private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
                @Deprecated
                private static final String PARAM_BACK = "back";
                @Deprecated
                private static final String PARAM_FRONT = "front";
                private String back;
                private String front;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                /* compiled from: AccountParams.kt */
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

                private final String component1() {
                    return this.front;
                }

                private final String component2() {
                    return this.back;
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

                public Map<String, Object> toParamMap() {
                    Map map;
                    Pair[] pairArr = {TuplesKt.to(PARAM_FRONT, this.front), TuplesKt.to(PARAM_BACK, this.back)};
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

                @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Individual$Document$Companion;", "", "()V", "PARAM_BACK", "", "PARAM_FRONT", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
                /* compiled from: AccountParams.kt */
                private static final class Companion {
                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }

                    private Companion() {
                    }
                }
            }

            @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u0010\u0010\u001d\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u001e\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010 \u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010!\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\"\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0010\u0010#\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\fJ\u0010\u0010$\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\fJ\u0010\u0010%\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\fJ\u0010\u0010&\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\fJ\u0010\u0010'\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\fJ\u0010\u0010(\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\fJ\u0010\u0010)\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\fJ\u0010\u0010*\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\fJ\u001c\u0010+\u001a\u00020\u00002\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u0017J\u0010\u0010,\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\fJ\u0010\u0010-\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\fJ\u0010\u0010.\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Individual$Builder;", "Lcom/stripe/android/ObjectBuilder;", "Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Individual;", "()V", "address", "Lcom/stripe/android/model/Address;", "addressKana", "Lcom/stripe/android/model/AddressJapanParams;", "addressKanji", "dateOfBirth", "Lcom/stripe/android/model/DateOfBirth;", "email", "", "firstName", "firstNameKana", "firstNameKanji", "gender", "idNumber", "lastName", "lastNameKana", "lastNameKanji", "maidenName", "metadata", "", "phone", "ssnLast4", "verification", "Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Individual$Verification;", "build", "setAddress", "setAddressKana", "setAddressKanji", "setDateOfBirth", "setEmail", "setFirstName", "setFirstNameKana", "setFirstNameKanji", "setGender", "setIdNumber", "setLastName", "setLastNameKana", "setLastNameKanji", "setMaidenName", "setMetadata", "setPhone", "setSsnLast4", "setVerification", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: AccountParams.kt */
            public static final class Builder implements ObjectBuilder<Individual> {
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

                public Individual build() {
                    return new Individual(this.address, this.addressKana, this.addressKanji, this.dateOfBirth, this.email, this.firstName, this.firstNameKana, this.firstNameKanji, this.gender, this.idNumber, this.lastName, this.lastNameKana, this.lastNameKanji, this.maidenName, this.metadata, this.phone, this.ssnLast4, this.verification);
                }
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Individual$Companion;", "", "()V", "PARAM_ADDRESS", "", "PARAM_ADDRESS_KANA", "PARAM_ADDRESS_KANJI", "PARAM_DOB", "PARAM_EMAIL", "PARAM_FIRST_NAME", "PARAM_FIRST_NAME_KANA", "PARAM_FIRST_NAME_KANJI", "PARAM_GENDER", "PARAM_ID_NUMBER", "PARAM_LAST_NAME", "PARAM_LAST_NAME_KANA", "PARAM_LAST_NAME_KANJI", "PARAM_MAIDEN_NAME", "PARAM_METADATA", "PARAM_PHONE", "PARAM_SSN_LAST_4", "PARAM_VERIFICATION", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* compiled from: AccountParams.kt */
            private static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/model/AccountParams$Companion;", "", "()V", "PARAM_BUSINESS_TYPE", "", "PARAM_TOS_SHOWN_AND_ACCEPTED", "create", "Lcom/stripe/android/model/AccountParams;", "tosShownAndAccepted", "", "businessType", "Lcom/stripe/android/model/AccountParams$BusinessType;", "company", "Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Company;", "individual", "Lcom/stripe/android/model/AccountParams$BusinessTypeParams$Individual;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AccountParams.kt */
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AccountParams.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[BusinessType.values().length];
                iArr[BusinessType.Individual.ordinal()] = 1;
                iArr[BusinessType.Company.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AccountParams create(boolean z, BusinessTypeParams.Individual individual) {
            Intrinsics.checkNotNullParameter(individual, "individual");
            return new AccountParams(z, individual);
        }

        @JvmStatic
        public final AccountParams create(boolean z, BusinessTypeParams.Company company) {
            Intrinsics.checkNotNullParameter(company, "company");
            return new AccountParams(z, company);
        }

        @JvmStatic
        public final AccountParams create(boolean z, BusinessType businessType) {
            BusinessTypeParams businessTypeParams;
            Intrinsics.checkNotNullParameter(businessType, "businessType");
            int i = WhenMappings.$EnumSwitchMapping$0[businessType.ordinal()];
            if (i == 1) {
                businessTypeParams = new BusinessTypeParams.Individual((Address) null, (AddressJapanParams) null, (AddressJapanParams) null, (DateOfBirth) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Map) null, (String) null, (String) null, (BusinessTypeParams.Individual.Verification) null, 262143, (DefaultConstructorMarker) null);
            } else if (i == 2) {
                businessTypeParams = new BusinessTypeParams.Company((Address) null, (AddressJapanParams) null, (AddressJapanParams) null, (Boolean) null, (Boolean) null, (String) null, (String) null, (String) null, (Boolean) null, (String) null, (String) null, (String) null, (String) null, (BusinessTypeParams.Company.Verification) null, 16383, (DefaultConstructorMarker) null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return new AccountParams(z, businessTypeParams);
        }

        @JvmStatic
        public final AccountParams create(boolean z) {
            return new AccountParams(z, (BusinessTypeParams) null, 2, (DefaultConstructorMarker) null);
        }
    }
}
