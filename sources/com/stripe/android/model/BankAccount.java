package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u00012\u00020\u0002:\u000267B\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0001\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.HÖ\u0003J\t\u0010/\u001a\u00020*HÖ\u0001J\t\u00100\u001a\u00020\u0004HÖ\u0001J\u0019\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020*HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0016\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00068"}, d2 = {"Lcom/stripe/android/model/BankAccount;", "Lcom/stripe/android/core/model/StripeModel;", "Lcom/stripe/android/model/StripePaymentSource;", "id", "", "accountHolderName", "accountHolderType", "Lcom/stripe/android/model/BankAccount$Type;", "bankName", "countryCode", "currency", "fingerprint", "last4", "routingNumber", "status", "Lcom/stripe/android/model/BankAccount$Status;", "(Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/BankAccount$Type;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/BankAccount$Status;)V", "getAccountHolderName", "()Ljava/lang/String;", "getAccountHolderType", "()Lcom/stripe/android/model/BankAccount$Type;", "getBankName", "getCountryCode", "getCurrency", "getFingerprint", "getId", "getLast4", "getRoutingNumber", "getStatus", "()Lcom/stripe/android/model/BankAccount$Status;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Status", "Type", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BankAccount.kt */
public final class BankAccount implements StripeModel, StripePaymentSource {
    public static final Parcelable.Creator<BankAccount> CREATOR = new Creator();
    private final String accountHolderName;
    private final Type accountHolderType;
    private final String bankName;
    private final String countryCode;
    private final String currency;
    private final String fingerprint;
    private final String id;
    private final String last4;
    private final String routingNumber;
    private final Status status;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BankAccount.kt */
    public static final class Creator implements Parcelable.Creator<BankAccount> {
        public final BankAccount createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BankAccount(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Type.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Status.valueOf(parcel.readString()));
        }

        public final BankAccount[] newArray(int i) {
            return new BankAccount[i];
        }
    }

    public BankAccount() {
        this((String) null, (String) null, (Type) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Status) null, 1023, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BankAccount copy$default(BankAccount bankAccount, String str, String str2, Type type, String str3, String str4, String str5, String str6, String str7, String str8, Status status2, int i, Object obj) {
        BankAccount bankAccount2 = bankAccount;
        int i2 = i;
        return bankAccount.copy((i2 & 1) != 0 ? bankAccount.getId() : str, (i2 & 2) != 0 ? bankAccount2.accountHolderName : str2, (i2 & 4) != 0 ? bankAccount2.accountHolderType : type, (i2 & 8) != 0 ? bankAccount2.bankName : str3, (i2 & 16) != 0 ? bankAccount2.countryCode : str4, (i2 & 32) != 0 ? bankAccount2.currency : str5, (i2 & 64) != 0 ? bankAccount2.fingerprint : str6, (i2 & 128) != 0 ? bankAccount2.last4 : str7, (i2 & 256) != 0 ? bankAccount2.routingNumber : str8, (i2 & 512) != 0 ? bankAccount2.status : status2);
    }

    public final String component1() {
        return getId();
    }

    public final Status component10() {
        return this.status;
    }

    public final String component2() {
        return this.accountHolderName;
    }

    public final Type component3() {
        return this.accountHolderType;
    }

    public final String component4() {
        return this.bankName;
    }

    public final String component5() {
        return this.countryCode;
    }

    public final String component6() {
        return this.currency;
    }

    public final String component7() {
        return this.fingerprint;
    }

    public final String component8() {
        return this.last4;
    }

    public final String component9() {
        return this.routingNumber;
    }

    public final BankAccount copy(String str, String str2, Type type, String str3, String str4, String str5, String str6, String str7, String str8, Status status2) {
        return new BankAccount(str, str2, type, str3, str4, str5, str6, str7, str8, status2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BankAccount)) {
            return false;
        }
        BankAccount bankAccount = (BankAccount) obj;
        return Intrinsics.areEqual((Object) getId(), (Object) bankAccount.getId()) && Intrinsics.areEqual((Object) this.accountHolderName, (Object) bankAccount.accountHolderName) && this.accountHolderType == bankAccount.accountHolderType && Intrinsics.areEqual((Object) this.bankName, (Object) bankAccount.bankName) && Intrinsics.areEqual((Object) this.countryCode, (Object) bankAccount.countryCode) && Intrinsics.areEqual((Object) this.currency, (Object) bankAccount.currency) && Intrinsics.areEqual((Object) this.fingerprint, (Object) bankAccount.fingerprint) && Intrinsics.areEqual((Object) this.last4, (Object) bankAccount.last4) && Intrinsics.areEqual((Object) this.routingNumber, (Object) bankAccount.routingNumber) && this.status == bankAccount.status;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (getId() == null ? 0 : getId().hashCode()) * 31;
        String str = this.accountHolderName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Type type = this.accountHolderType;
        int hashCode3 = (hashCode2 + (type == null ? 0 : type.hashCode())) * 31;
        String str2 = this.bankName;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.countryCode;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.currency;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.fingerprint;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.last4;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.routingNumber;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Status status2 = this.status;
        if (status2 != null) {
            i = status2.hashCode();
        }
        return hashCode9 + i;
    }

    public String toString() {
        return "BankAccount(id=" + getId() + ", accountHolderName=" + this.accountHolderName + ", accountHolderType=" + this.accountHolderType + ", bankName=" + this.bankName + ", countryCode=" + this.countryCode + ", currency=" + this.currency + ", fingerprint=" + this.fingerprint + ", last4=" + this.last4 + ", routingNumber=" + this.routingNumber + ", status=" + this.status + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.accountHolderName);
        Type type = this.accountHolderType;
        if (type == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(type.name());
        }
        parcel.writeString(this.bankName);
        parcel.writeString(this.countryCode);
        parcel.writeString(this.currency);
        parcel.writeString(this.fingerprint);
        parcel.writeString(this.last4);
        parcel.writeString(this.routingNumber);
        Status status2 = this.status;
        if (status2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeString(status2.name());
    }

    public BankAccount(String str, String str2, Type type, String str3, String str4, String str5, String str6, String str7, String str8, Status status2) {
        this.id = str;
        this.accountHolderName = str2;
        this.accountHolderType = type;
        this.bankName = str3;
        this.countryCode = str4;
        this.currency = str5;
        this.fingerprint = str6;
        this.last4 = str7;
        this.routingNumber = str8;
        this.status = status2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BankAccount(java.lang.String r12, java.lang.String r13, com.stripe.android.model.BankAccount.Type r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, com.stripe.android.model.BankAccount.Status r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r11 = this;
            r0 = r22
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r12
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r13
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r14
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r15
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0027
        L_0x0025:
            r6 = r16
        L_0x0027:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002d
            r7 = r2
            goto L_0x002f
        L_0x002d:
            r7 = r17
        L_0x002f:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0035
            r8 = r2
            goto L_0x0037
        L_0x0035:
            r8 = r18
        L_0x0037:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003d
            r9 = r2
            goto L_0x003f
        L_0x003d:
            r9 = r19
        L_0x003f:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0045
            r10 = r2
            goto L_0x0047
        L_0x0045:
            r10 = r20
        L_0x0047:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r2 = r21
        L_0x004e:
            r12 = r11
            r13 = r1
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r10
            r22 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.BankAccount.<init>(java.lang.String, java.lang.String, com.stripe.android.model.BankAccount$Type, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.stripe.android.model.BankAccount$Status, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public String getId() {
        return this.id;
    }

    public final String getAccountHolderName() {
        return this.accountHolderName;
    }

    public final Type getAccountHolderType() {
        return this.accountHolderType;
    }

    public final String getBankName() {
        return this.bankName;
    }

    public final String getCountryCode() {
        return this.countryCode;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getFingerprint() {
        return this.fingerprint;
    }

    public final String getLast4() {
        return this.last4;
    }

    public final String getRoutingNumber() {
        return this.routingNumber;
    }

    public final Status getStatus() {
        return this.status;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/model/BankAccount$Type;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode$payments_model_release", "()Ljava/lang/String;", "toString", "Company", "Individual", "Companion", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BankAccount.kt */
    public enum Type {
        Company("company"),
        Individual("individual");
        
        public static final Companion Companion = null;
        private final String code;

        private Type(String str) {
            this.code = str;
        }

        public final String getCode$payments_model_release() {
            return this.code;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        public String toString() {
            return this.code;
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/BankAccount$Type$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/model/BankAccount$Type;", "code", "", "fromCode$payments_model_release", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: BankAccount.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Type fromCode$payments_model_release(String str) {
                Type[] values = Type.values();
                int length = values.length;
                int i = 0;
                while (i < length) {
                    Type type = values[i];
                    i++;
                    if (Intrinsics.areEqual((Object) type.getCode$payments_model_release(), (Object) str)) {
                        return type;
                    }
                }
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/model/BankAccount$Status;", "", "code", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCode$payments_model_release", "()Ljava/lang/String;", "toString", "New", "Validated", "Verified", "VerificationFailed", "Errored", "Companion", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BankAccount.kt */
    public enum Status {
        New("new"),
        Validated("validated"),
        Verified("verified"),
        VerificationFailed("verification_failed"),
        Errored("errored");
        
        public static final Companion Companion = null;
        private final String code;

        private Status(String str) {
            this.code = str;
        }

        public final String getCode$payments_model_release() {
            return this.code;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        public String toString() {
            return this.code;
        }

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/BankAccount$Status$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/model/BankAccount$Status;", "code", "", "fromCode$payments_model_release", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: BankAccount.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Status fromCode$payments_model_release(String str) {
                Status[] values = Status.values();
                int length = values.length;
                int i = 0;
                while (i < length) {
                    Status status = values[i];
                    i++;
                    if (Intrinsics.areEqual((Object) status.getCode$payments_model_release(), (Object) str)) {
                        return status;
                    }
                }
                return null;
            }
        }
    }
}
