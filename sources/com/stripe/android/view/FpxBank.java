package com.stripe.android.view;

import com.stripe.android.R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001c\b\u0001\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001#B+\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000ej\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006$"}, d2 = {"Lcom/stripe/android/view/FpxBank;", "", "Lcom/stripe/android/view/Bank;", "id", "", "code", "displayName", "brandIconResId", "", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getBrandIconResId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCode", "()Ljava/lang/String;", "getDisplayName", "getId", "Maybank2U", "Cimb", "PublicBank", "Rhb", "HongLeongBank", "AmBank", "AffinBank", "AllianceBankBusiness", "BankIslam", "BankMuamalat", "BankRakyat", "Bsn", "Hsbc", "Kfh", "Maybank2E", "Ocbc", "StandardChartered", "UobBank", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FpxBank.kt */
public enum FpxBank implements Bank {
    Maybank2U("MB2U0227", "maybank2u", "Maybank2U", Integer.valueOf(R.drawable.stripe_ic_bank_maybank)),
    Cimb("BCBB0235", "cimb", "CIMB Clicks", Integer.valueOf(R.drawable.stripe_ic_bank_cimb)),
    PublicBank("PBB0233", "public_bank", "Public Bank", Integer.valueOf(R.drawable.stripe_ic_bank_public)),
    Rhb("RHB0218", "rhb", "RHB Bank", Integer.valueOf(R.drawable.stripe_ic_bank_rhb)),
    HongLeongBank("HLB0224", "hong_leong_bank", "Hong Leong Bank", Integer.valueOf(R.drawable.stripe_ic_bank_hong_leong)),
    AmBank("AMBB0209", "ambank", "AmBank", Integer.valueOf(R.drawable.stripe_ic_bank_ambank)),
    AffinBank("ABB0233", "affin_bank", "Affin Bank", Integer.valueOf(R.drawable.stripe_ic_bank_affin)),
    AllianceBankBusiness("ABMB0212", "alliance_bank", "Alliance Bank", Integer.valueOf(R.drawable.stripe_ic_bank_alliance)),
    BankIslam("BIMB0340", "bank_islam", "Bank Islam", Integer.valueOf(R.drawable.stripe_ic_bank_islam)),
    BankMuamalat("BMMB0341", "bank_muamalat", "Bank Muamalat", Integer.valueOf(R.drawable.stripe_ic_bank_muamalat)),
    BankRakyat("BKRM0602", "bank_rakyat", "Bank Rakyat", Integer.valueOf(R.drawable.stripe_ic_bank_raykat)),
    Bsn("BSN0601", "bsn", "BSN", Integer.valueOf(R.drawable.stripe_ic_bank_bsn)),
    Hsbc("HSBC0223", "hsbc", "HSBC Bank", Integer.valueOf(R.drawable.stripe_ic_bank_hsbc)),
    Kfh("KFH0346", "kfh", "KFH", Integer.valueOf(R.drawable.stripe_ic_bank_kfh)),
    Maybank2E("MBB0228", "maybank2e", "Maybank2E", Integer.valueOf(R.drawable.stripe_ic_bank_maybank)),
    Ocbc("OCBC0229", "ocbc", "OCBC Bank", Integer.valueOf(R.drawable.stripe_ic_bank_ocbc)),
    StandardChartered("SCB0216", "standard_chartered", "Standard Chartered", Integer.valueOf(R.drawable.stripe_ic_bank_standard_chartered)),
    UobBank("UOB0226", "uob", "UOB", Integer.valueOf(R.drawable.stripe_ic_bank_uob));
    
    public static final Companion Companion = null;
    private final Integer brandIconResId;
    private final String code;
    private final String displayName;
    private final String id;

    @JvmStatic
    public static final FpxBank get(String str) {
        return Companion.get(str);
    }

    private FpxBank(String str, String str2, String str3, Integer num) {
        this.id = str;
        this.code = str2;
        this.displayName = str3;
        this.brandIconResId = num;
    }

    public String getId() {
        return this.id;
    }

    public String getCode() {
        return this.code;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public Integer getBrandIconResId() {
        return this.brandIconResId;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/view/FpxBank$Companion;", "", "()V", "get", "Lcom/stripe/android/view/FpxBank;", "bankCode", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FpxBank.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FpxBank get(String str) {
            FpxBank[] values = FpxBank.values();
            int length = values.length;
            int i = 0;
            while (i < length) {
                FpxBank fpxBank = values[i];
                i++;
                if (Intrinsics.areEqual((Object) fpxBank.getCode(), (Object) str)) {
                    return fpxBank;
                }
            }
            return null;
        }
    }
}
