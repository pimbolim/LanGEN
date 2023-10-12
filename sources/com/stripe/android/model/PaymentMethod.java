package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.ObjectBuilder;
import com.stripe.android.core.model.StripeModel;
import com.stripe.android.model.parsers.AccountRangeJsonParser;
import com.stripe.android.model.parsers.PaymentMethodJsonParser;
import com.stripe.android.model.wallets.Wallet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\b\b\u0018\u0000 L2\u00020\u0001:\u0010FGHIJKLMNOPQRSTUBÉ\u0001\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\u0002\u0010#J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u001eHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010 HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\"HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010/J\t\u00100\u001a\u00020\u0007HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0012HÆ\u0003JØ\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"HÆ\u0001¢\u0006\u0002\u00108J\t\u00109\u001a\u00020:HÖ\u0001J\u0013\u0010;\u001a\u00020\u00072\b\u0010<\u001a\u0004\u0018\u00010=HÖ\u0003J\b\u0010>\u001a\u00020\u0007H\u0007J\t\u0010?\u001a\u00020:HÖ\u0001J\t\u0010@\u001a\u00020\u0003HÖ\u0001J\u0019\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020:HÖ\u0001R\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0004\n\u0002\u0010$R\u0012\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001f\u001a\u0004\u0018\u00010 8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010!\u001a\u0004\u0018\u00010\"8\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/stripe/android/model/PaymentMethod;", "Lcom/stripe/android/core/model/StripeModel;", "id", "", "created", "", "liveMode", "", "type", "Lcom/stripe/android/model/PaymentMethod$Type;", "billingDetails", "Lcom/stripe/android/model/PaymentMethod$BillingDetails;", "customerId", "card", "Lcom/stripe/android/model/PaymentMethod$Card;", "cardPresent", "Lcom/stripe/android/model/PaymentMethod$CardPresent;", "fpx", "Lcom/stripe/android/model/PaymentMethod$Fpx;", "ideal", "Lcom/stripe/android/model/PaymentMethod$Ideal;", "sepaDebit", "Lcom/stripe/android/model/PaymentMethod$SepaDebit;", "auBecsDebit", "Lcom/stripe/android/model/PaymentMethod$AuBecsDebit;", "bacsDebit", "Lcom/stripe/android/model/PaymentMethod$BacsDebit;", "sofort", "Lcom/stripe/android/model/PaymentMethod$Sofort;", "upi", "Lcom/stripe/android/model/PaymentMethod$Upi;", "netbanking", "Lcom/stripe/android/model/PaymentMethod$Netbanking;", "usBankAccount", "Lcom/stripe/android/model/PaymentMethod$USBankAccount;", "(Ljava/lang/String;Ljava/lang/Long;ZLcom/stripe/android/model/PaymentMethod$Type;Lcom/stripe/android/model/PaymentMethod$BillingDetails;Ljava/lang/String;Lcom/stripe/android/model/PaymentMethod$Card;Lcom/stripe/android/model/PaymentMethod$CardPresent;Lcom/stripe/android/model/PaymentMethod$Fpx;Lcom/stripe/android/model/PaymentMethod$Ideal;Lcom/stripe/android/model/PaymentMethod$SepaDebit;Lcom/stripe/android/model/PaymentMethod$AuBecsDebit;Lcom/stripe/android/model/PaymentMethod$BacsDebit;Lcom/stripe/android/model/PaymentMethod$Sofort;Lcom/stripe/android/model/PaymentMethod$Upi;Lcom/stripe/android/model/PaymentMethod$Netbanking;Lcom/stripe/android/model/PaymentMethod$USBankAccount;)V", "Ljava/lang/Long;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "()Ljava/lang/Long;", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Long;ZLcom/stripe/android/model/PaymentMethod$Type;Lcom/stripe/android/model/PaymentMethod$BillingDetails;Ljava/lang/String;Lcom/stripe/android/model/PaymentMethod$Card;Lcom/stripe/android/model/PaymentMethod$CardPresent;Lcom/stripe/android/model/PaymentMethod$Fpx;Lcom/stripe/android/model/PaymentMethod$Ideal;Lcom/stripe/android/model/PaymentMethod$SepaDebit;Lcom/stripe/android/model/PaymentMethod$AuBecsDebit;Lcom/stripe/android/model/PaymentMethod$BacsDebit;Lcom/stripe/android/model/PaymentMethod$Sofort;Lcom/stripe/android/model/PaymentMethod$Upi;Lcom/stripe/android/model/PaymentMethod$Netbanking;Lcom/stripe/android/model/PaymentMethod$USBankAccount;)Lcom/stripe/android/model/PaymentMethod;", "describeContents", "", "equals", "other", "", "hasExpectedDetails", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "AuBecsDebit", "BacsDebit", "BillingDetails", "Builder", "Card", "CardPresent", "Companion", "Fpx", "Ideal", "Netbanking", "SepaDebit", "Sofort", "Type", "TypeData", "USBankAccount", "Upi", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethod.kt */
public final class PaymentMethod implements StripeModel {
    public static final int $stable = 8;
    public static final Parcelable.Creator<PaymentMethod> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public final AuBecsDebit auBecsDebit;
    public final BacsDebit bacsDebit;
    public final BillingDetails billingDetails;
    public final Card card;
    public final CardPresent cardPresent;
    public final Long created;
    public final String customerId;
    public final Fpx fpx;
    public final String id;
    public final Ideal ideal;
    public final boolean liveMode;
    public final Netbanking netbanking;
    public final SepaDebit sepaDebit;
    public final Sofort sofort;
    public final Type type;
    public final Upi upi;
    public final USBankAccount usBankAccount;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethod.kt */
    public static final class Creator implements Parcelable.Creator<PaymentMethod> {
        public final PaymentMethod createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            String readString = parcel.readString();
            USBankAccount uSBankAccount = null;
            Long valueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            boolean z = parcel.readInt() != 0;
            Type createFromParcel = parcel.readInt() == 0 ? null : Type.CREATOR.createFromParcel(parcel2);
            BillingDetails createFromParcel2 = parcel.readInt() == 0 ? null : BillingDetails.CREATOR.createFromParcel(parcel2);
            String readString2 = parcel.readString();
            Card createFromParcel3 = parcel.readInt() == 0 ? null : Card.CREATOR.createFromParcel(parcel2);
            CardPresent createFromParcel4 = parcel.readInt() == 0 ? null : CardPresent.CREATOR.createFromParcel(parcel2);
            Fpx createFromParcel5 = parcel.readInt() == 0 ? null : Fpx.CREATOR.createFromParcel(parcel2);
            Ideal createFromParcel6 = parcel.readInt() == 0 ? null : Ideal.CREATOR.createFromParcel(parcel2);
            SepaDebit createFromParcel7 = parcel.readInt() == 0 ? null : SepaDebit.CREATOR.createFromParcel(parcel2);
            AuBecsDebit createFromParcel8 = parcel.readInt() == 0 ? null : AuBecsDebit.CREATOR.createFromParcel(parcel2);
            BacsDebit createFromParcel9 = parcel.readInt() == 0 ? null : BacsDebit.CREATOR.createFromParcel(parcel2);
            Sofort createFromParcel10 = parcel.readInt() == 0 ? null : Sofort.CREATOR.createFromParcel(parcel2);
            Upi createFromParcel11 = parcel.readInt() == 0 ? null : Upi.CREATOR.createFromParcel(parcel2);
            Netbanking createFromParcel12 = parcel.readInt() == 0 ? null : Netbanking.CREATOR.createFromParcel(parcel2);
            if (parcel.readInt() != 0) {
                uSBankAccount = USBankAccount.CREATOR.createFromParcel(parcel2);
            }
            return new PaymentMethod(readString, valueOf, z, createFromParcel, createFromParcel2, readString2, createFromParcel3, createFromParcel4, createFromParcel5, createFromParcel6, createFromParcel7, createFromParcel8, createFromParcel9, createFromParcel10, createFromParcel11, createFromParcel12, uSBankAccount);
        }

        public final PaymentMethod[] newArray(int i) {
            return new PaymentMethod[i];
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethod.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Type.values().length];
            iArr[Type.Card.ordinal()] = 1;
            iArr[Type.CardPresent.ordinal()] = 2;
            iArr[Type.Fpx.ordinal()] = 3;
            iArr[Type.Ideal.ordinal()] = 4;
            iArr[Type.SepaDebit.ordinal()] = 5;
            iArr[Type.AuBecsDebit.ordinal()] = 6;
            iArr[Type.BacsDebit.ordinal()] = 7;
            iArr[Type.Sofort.ordinal()] = 8;
            iArr[Type.USBankAccount.ordinal()] = 9;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ PaymentMethod copy$default(PaymentMethod paymentMethod, String str, Long l, boolean z, Type type2, BillingDetails billingDetails2, String str2, Card card2, CardPresent cardPresent2, Fpx fpx2, Ideal ideal2, SepaDebit sepaDebit2, AuBecsDebit auBecsDebit2, BacsDebit bacsDebit2, Sofort sofort2, Upi upi2, Netbanking netbanking2, USBankAccount uSBankAccount, int i, Object obj) {
        PaymentMethod paymentMethod2 = paymentMethod;
        int i2 = i;
        return paymentMethod.copy((i2 & 1) != 0 ? paymentMethod2.id : str, (i2 & 2) != 0 ? paymentMethod2.created : l, (i2 & 4) != 0 ? paymentMethod2.liveMode : z, (i2 & 8) != 0 ? paymentMethod2.type : type2, (i2 & 16) != 0 ? paymentMethod2.billingDetails : billingDetails2, (i2 & 32) != 0 ? paymentMethod2.customerId : str2, (i2 & 64) != 0 ? paymentMethod2.card : card2, (i2 & 128) != 0 ? paymentMethod2.cardPresent : cardPresent2, (i2 & 256) != 0 ? paymentMethod2.fpx : fpx2, (i2 & 512) != 0 ? paymentMethod2.ideal : ideal2, (i2 & 1024) != 0 ? paymentMethod2.sepaDebit : sepaDebit2, (i2 & 2048) != 0 ? paymentMethod2.auBecsDebit : auBecsDebit2, (i2 & 4096) != 0 ? paymentMethod2.bacsDebit : bacsDebit2, (i2 & 8192) != 0 ? paymentMethod2.sofort : sofort2, (i2 & 16384) != 0 ? paymentMethod2.upi : upi2, (i2 & 32768) != 0 ? paymentMethod2.netbanking : netbanking2, (i2 & 65536) != 0 ? paymentMethod2.usBankAccount : uSBankAccount);
    }

    @JvmStatic
    public static final PaymentMethod fromJson(JSONObject jSONObject) {
        return Companion.fromJson(jSONObject);
    }

    public final String component1() {
        return this.id;
    }

    public final Ideal component10() {
        return this.ideal;
    }

    public final SepaDebit component11() {
        return this.sepaDebit;
    }

    public final AuBecsDebit component12() {
        return this.auBecsDebit;
    }

    public final BacsDebit component13() {
        return this.bacsDebit;
    }

    public final Sofort component14() {
        return this.sofort;
    }

    public final Upi component15() {
        return this.upi;
    }

    public final Netbanking component16() {
        return this.netbanking;
    }

    public final USBankAccount component17() {
        return this.usBankAccount;
    }

    public final Long component2() {
        return this.created;
    }

    public final boolean component3() {
        return this.liveMode;
    }

    public final Type component4() {
        return this.type;
    }

    public final BillingDetails component5() {
        return this.billingDetails;
    }

    public final String component6() {
        return this.customerId;
    }

    public final Card component7() {
        return this.card;
    }

    public final CardPresent component8() {
        return this.cardPresent;
    }

    public final Fpx component9() {
        return this.fpx;
    }

    public final PaymentMethod copy(String str, Long l, boolean z, Type type2, BillingDetails billingDetails2, String str2, Card card2, CardPresent cardPresent2, Fpx fpx2, Ideal ideal2, SepaDebit sepaDebit2, AuBecsDebit auBecsDebit2, BacsDebit bacsDebit2, Sofort sofort2, Upi upi2, Netbanking netbanking2, USBankAccount uSBankAccount) {
        return new PaymentMethod(str, l, z, type2, billingDetails2, str2, card2, cardPresent2, fpx2, ideal2, sepaDebit2, auBecsDebit2, bacsDebit2, sofort2, upi2, netbanking2, uSBankAccount);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentMethod)) {
            return false;
        }
        PaymentMethod paymentMethod = (PaymentMethod) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) paymentMethod.id) && Intrinsics.areEqual((Object) this.created, (Object) paymentMethod.created) && this.liveMode == paymentMethod.liveMode && this.type == paymentMethod.type && Intrinsics.areEqual((Object) this.billingDetails, (Object) paymentMethod.billingDetails) && Intrinsics.areEqual((Object) this.customerId, (Object) paymentMethod.customerId) && Intrinsics.areEqual((Object) this.card, (Object) paymentMethod.card) && Intrinsics.areEqual((Object) this.cardPresent, (Object) paymentMethod.cardPresent) && Intrinsics.areEqual((Object) this.fpx, (Object) paymentMethod.fpx) && Intrinsics.areEqual((Object) this.ideal, (Object) paymentMethod.ideal) && Intrinsics.areEqual((Object) this.sepaDebit, (Object) paymentMethod.sepaDebit) && Intrinsics.areEqual((Object) this.auBecsDebit, (Object) paymentMethod.auBecsDebit) && Intrinsics.areEqual((Object) this.bacsDebit, (Object) paymentMethod.bacsDebit) && Intrinsics.areEqual((Object) this.sofort, (Object) paymentMethod.sofort) && Intrinsics.areEqual((Object) this.upi, (Object) paymentMethod.upi) && Intrinsics.areEqual((Object) this.netbanking, (Object) paymentMethod.netbanking) && Intrinsics.areEqual((Object) this.usBankAccount, (Object) paymentMethod.usBankAccount);
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.created;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        boolean z = this.liveMode;
        if (z) {
            z = true;
        }
        int i2 = (hashCode2 + (z ? 1 : 0)) * 31;
        Type type2 = this.type;
        int hashCode3 = (i2 + (type2 == null ? 0 : type2.hashCode())) * 31;
        BillingDetails billingDetails2 = this.billingDetails;
        int hashCode4 = (hashCode3 + (billingDetails2 == null ? 0 : billingDetails2.hashCode())) * 31;
        String str2 = this.customerId;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Card card2 = this.card;
        int hashCode6 = (hashCode5 + (card2 == null ? 0 : card2.hashCode())) * 31;
        CardPresent cardPresent2 = this.cardPresent;
        int hashCode7 = (hashCode6 + (cardPresent2 == null ? 0 : cardPresent2.hashCode())) * 31;
        Fpx fpx2 = this.fpx;
        int hashCode8 = (hashCode7 + (fpx2 == null ? 0 : fpx2.hashCode())) * 31;
        Ideal ideal2 = this.ideal;
        int hashCode9 = (hashCode8 + (ideal2 == null ? 0 : ideal2.hashCode())) * 31;
        SepaDebit sepaDebit2 = this.sepaDebit;
        int hashCode10 = (hashCode9 + (sepaDebit2 == null ? 0 : sepaDebit2.hashCode())) * 31;
        AuBecsDebit auBecsDebit2 = this.auBecsDebit;
        int hashCode11 = (hashCode10 + (auBecsDebit2 == null ? 0 : auBecsDebit2.hashCode())) * 31;
        BacsDebit bacsDebit2 = this.bacsDebit;
        int hashCode12 = (hashCode11 + (bacsDebit2 == null ? 0 : bacsDebit2.hashCode())) * 31;
        Sofort sofort2 = this.sofort;
        int hashCode13 = (hashCode12 + (sofort2 == null ? 0 : sofort2.hashCode())) * 31;
        Upi upi2 = this.upi;
        int hashCode14 = (hashCode13 + (upi2 == null ? 0 : upi2.hashCode())) * 31;
        Netbanking netbanking2 = this.netbanking;
        int hashCode15 = (hashCode14 + (netbanking2 == null ? 0 : netbanking2.hashCode())) * 31;
        USBankAccount uSBankAccount = this.usBankAccount;
        if (uSBankAccount != null) {
            i = uSBankAccount.hashCode();
        }
        return hashCode15 + i;
    }

    public String toString() {
        return "PaymentMethod(id=" + this.id + ", created=" + this.created + ", liveMode=" + this.liveMode + ", type=" + this.type + ", billingDetails=" + this.billingDetails + ", customerId=" + this.customerId + ", card=" + this.card + ", cardPresent=" + this.cardPresent + ", fpx=" + this.fpx + ", ideal=" + this.ideal + ", sepaDebit=" + this.sepaDebit + ", auBecsDebit=" + this.auBecsDebit + ", bacsDebit=" + this.bacsDebit + ", sofort=" + this.sofort + ", upi=" + this.upi + ", netbanking=" + this.netbanking + ", usBankAccount=" + this.usBankAccount + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        Long l = this.created;
        if (l == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l.longValue());
        }
        parcel.writeInt(this.liveMode ? 1 : 0);
        Type type2 = this.type;
        if (type2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            type2.writeToParcel(parcel, i);
        }
        BillingDetails billingDetails2 = this.billingDetails;
        if (billingDetails2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            billingDetails2.writeToParcel(parcel, i);
        }
        parcel.writeString(this.customerId);
        Card card2 = this.card;
        if (card2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            card2.writeToParcel(parcel, i);
        }
        CardPresent cardPresent2 = this.cardPresent;
        if (cardPresent2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            cardPresent2.writeToParcel(parcel, i);
        }
        Fpx fpx2 = this.fpx;
        if (fpx2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            fpx2.writeToParcel(parcel, i);
        }
        Ideal ideal2 = this.ideal;
        if (ideal2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            ideal2.writeToParcel(parcel, i);
        }
        SepaDebit sepaDebit2 = this.sepaDebit;
        if (sepaDebit2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            sepaDebit2.writeToParcel(parcel, i);
        }
        AuBecsDebit auBecsDebit2 = this.auBecsDebit;
        if (auBecsDebit2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            auBecsDebit2.writeToParcel(parcel, i);
        }
        BacsDebit bacsDebit2 = this.bacsDebit;
        if (bacsDebit2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            bacsDebit2.writeToParcel(parcel, i);
        }
        Sofort sofort2 = this.sofort;
        if (sofort2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            sofort2.writeToParcel(parcel, i);
        }
        Upi upi2 = this.upi;
        if (upi2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            upi2.writeToParcel(parcel, i);
        }
        Netbanking netbanking2 = this.netbanking;
        if (netbanking2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            netbanking2.writeToParcel(parcel, i);
        }
        USBankAccount uSBankAccount = this.usBankAccount;
        if (uSBankAccount == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        uSBankAccount.writeToParcel(parcel, i);
    }

    public PaymentMethod(String str, Long l, boolean z, Type type2, BillingDetails billingDetails2, String str2, Card card2, CardPresent cardPresent2, Fpx fpx2, Ideal ideal2, SepaDebit sepaDebit2, AuBecsDebit auBecsDebit2, BacsDebit bacsDebit2, Sofort sofort2, Upi upi2, Netbanking netbanking2, USBankAccount uSBankAccount) {
        this.id = str;
        this.created = l;
        this.liveMode = z;
        this.type = type2;
        this.billingDetails = billingDetails2;
        this.customerId = str2;
        this.card = card2;
        this.cardPresent = cardPresent2;
        this.fpx = fpx2;
        this.ideal = ideal2;
        this.sepaDebit = sepaDebit2;
        this.auBecsDebit = auBecsDebit2;
        this.bacsDebit = bacsDebit2;
        this.sofort = sofort2;
        this.upi = upi2;
        this.netbanking = netbanking2;
        this.usBankAccount = uSBankAccount;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentMethod(java.lang.String r22, java.lang.Long r23, boolean r24, com.stripe.android.model.PaymentMethod.Type r25, com.stripe.android.model.PaymentMethod.BillingDetails r26, java.lang.String r27, com.stripe.android.model.PaymentMethod.Card r28, com.stripe.android.model.PaymentMethod.CardPresent r29, com.stripe.android.model.PaymentMethod.Fpx r30, com.stripe.android.model.PaymentMethod.Ideal r31, com.stripe.android.model.PaymentMethod.SepaDebit r32, com.stripe.android.model.PaymentMethod.AuBecsDebit r33, com.stripe.android.model.PaymentMethod.BacsDebit r34, com.stripe.android.model.PaymentMethod.Sofort r35, com.stripe.android.model.PaymentMethod.Upi r36, com.stripe.android.model.PaymentMethod.Netbanking r37, com.stripe.android.model.PaymentMethod.USBankAccount r38, int r39, kotlin.jvm.internal.DefaultConstructorMarker r40) {
        /*
            r21 = this;
            r0 = r39
            r1 = r0 & 16
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r8 = r2
            goto L_0x000b
        L_0x0009:
            r8 = r26
        L_0x000b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0011
            r9 = r2
            goto L_0x0013
        L_0x0011:
            r9 = r27
        L_0x0013:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0019
            r10 = r2
            goto L_0x001b
        L_0x0019:
            r10 = r28
        L_0x001b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0021
            r11 = r2
            goto L_0x0023
        L_0x0021:
            r11 = r29
        L_0x0023:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0029
            r12 = r2
            goto L_0x002b
        L_0x0029:
            r12 = r30
        L_0x002b:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0031
            r13 = r2
            goto L_0x0033
        L_0x0031:
            r13 = r31
        L_0x0033:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0039
            r14 = r2
            goto L_0x003b
        L_0x0039:
            r14 = r32
        L_0x003b:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0041
            r15 = r2
            goto L_0x0043
        L_0x0041:
            r15 = r33
        L_0x0043:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x004a
            r16 = r2
            goto L_0x004c
        L_0x004a:
            r16 = r34
        L_0x004c:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x0053
            r17 = r2
            goto L_0x0055
        L_0x0053:
            r17 = r35
        L_0x0055:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x005c
            r18 = r2
            goto L_0x005e
        L_0x005c:
            r18 = r36
        L_0x005e:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0067
            r19 = r2
            goto L_0x0069
        L_0x0067:
            r19 = r37
        L_0x0069:
            r1 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0071
            r20 = r2
            goto L_0x0073
        L_0x0071:
            r20 = r38
        L_0x0073:
            r3 = r21
            r4 = r22
            r5 = r23
            r6 = r24
            r7 = r25
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.PaymentMethod.<init>(java.lang.String, java.lang.Long, boolean, com.stripe.android.model.PaymentMethod$Type, com.stripe.android.model.PaymentMethod$BillingDetails, java.lang.String, com.stripe.android.model.PaymentMethod$Card, com.stripe.android.model.PaymentMethod$CardPresent, com.stripe.android.model.PaymentMethod$Fpx, com.stripe.android.model.PaymentMethod$Ideal, com.stripe.android.model.PaymentMethod$SepaDebit, com.stripe.android.model.PaymentMethod$AuBecsDebit, com.stripe.android.model.PaymentMethod$BacsDebit, com.stripe.android.model.PaymentMethod$Sofort, com.stripe.android.model.PaymentMethod$Upi, com.stripe.android.model.PaymentMethod$Netbanking, com.stripe.android.model.PaymentMethod$USBankAccount, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0013 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean hasExpectedDetails() {
        /*
            r3 = this;
            com.stripe.android.model.PaymentMethod$Type r0 = r3.type
            if (r0 != 0) goto L_0x0006
            r0 = -1
            goto L_0x000e
        L_0x0006:
            int[] r1 = com.stripe.android.model.PaymentMethod.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
        L_0x000e:
            r1 = 0
            r2 = 1
            switch(r0) {
                case 1: goto L_0x003d;
                case 2: goto L_0x0038;
                case 3: goto L_0x0033;
                case 4: goto L_0x002e;
                case 5: goto L_0x0029;
                case 6: goto L_0x0024;
                case 7: goto L_0x001f;
                case 8: goto L_0x001a;
                case 9: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            r1 = 1
            goto L_0x0042
        L_0x0015:
            com.stripe.android.model.PaymentMethod$USBankAccount r0 = r3.usBankAccount
            if (r0 == 0) goto L_0x0042
            goto L_0x0013
        L_0x001a:
            com.stripe.android.model.PaymentMethod$Sofort r0 = r3.sofort
            if (r0 == 0) goto L_0x0042
            goto L_0x0013
        L_0x001f:
            com.stripe.android.model.PaymentMethod$BacsDebit r0 = r3.bacsDebit
            if (r0 == 0) goto L_0x0042
            goto L_0x0013
        L_0x0024:
            com.stripe.android.model.PaymentMethod$AuBecsDebit r0 = r3.auBecsDebit
            if (r0 == 0) goto L_0x0042
            goto L_0x0013
        L_0x0029:
            com.stripe.android.model.PaymentMethod$SepaDebit r0 = r3.sepaDebit
            if (r0 == 0) goto L_0x0042
            goto L_0x0013
        L_0x002e:
            com.stripe.android.model.PaymentMethod$Ideal r0 = r3.ideal
            if (r0 == 0) goto L_0x0042
            goto L_0x0013
        L_0x0033:
            com.stripe.android.model.PaymentMethod$Fpx r0 = r3.fpx
            if (r0 == 0) goto L_0x0042
            goto L_0x0013
        L_0x0038:
            com.stripe.android.model.PaymentMethod$CardPresent r0 = r3.cardPresent
            if (r0 == 0) goto L_0x0042
            goto L_0x0013
        L_0x003d:
            com.stripe.android.model.PaymentMethod$Card r0 = r3.card
            if (r0 == 0) goto L_0x0042
            goto L_0x0013
        L_0x0042:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.PaymentMethod.hasExpectedDetails():boolean");
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0001\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001,B/\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\b\u0010\t\u001a\u00020\u0006H\u0007J\b\u0010\r\u001a\u00020\u0004H\u0016J\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fHÖ\u0001R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+¨\u0006-"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$Type;", "", "Landroid/os/Parcelable;", "code", "", "isReusable", "", "isVoucher", "requiresMandate", "hasDelayedSettlement", "(Ljava/lang/String;ILjava/lang/String;ZZZZ)V", "describeContents", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Link", "Card", "CardPresent", "Fpx", "Ideal", "SepaDebit", "AuBecsDebit", "BacsDebit", "Sofort", "Upi", "P24", "Bancontact", "Giropay", "Eps", "Oxxo", "Alipay", "GrabPay", "PayPal", "AfterpayClearpay", "Netbanking", "Blik", "WeChatPay", "Klarna", "Affirm", "USBankAccount", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethod.kt */
    public enum Type implements Parcelable {
        Link("link", false, false, true, false),
        Card("card", true, false, false, false),
        CardPresent("card_present", false, false, false, false),
        Fpx("fpx", false, false, false, false),
        Ideal("ideal", false, false, true, false),
        SepaDebit("sepa_debit", false, false, true, true),
        AuBecsDebit("au_becs_debit", true, false, true, true),
        BacsDebit("bacs_debit", true, false, true, true),
        Sofort("sofort", false, false, true, true),
        Upi("upi", false, false, false, false),
        P24("p24", false, false, false, false),
        Bancontact("bancontact", false, false, true, false),
        Giropay("giropay", false, false, false, false),
        Eps("eps", false, false, true, false),
        Oxxo("oxxo", false, true, false, false),
        Alipay("alipay", false, false, false, false),
        GrabPay("grabpay", false, false, false, false),
        PayPal("paypal", false, false, false, false),
        AfterpayClearpay("afterpay_clearpay", false, false, false, false),
        Netbanking("netbanking", false, false, false, false),
        Blik("blik", false, false, false, false),
        WeChatPay("wechat_pay", false, false, false, false),
        Klarna("klarna", false, false, false, false),
        Affirm("affirm", false, false, false, false),
        USBankAccount("us_bank_account", true, false, true, true);
        
        public static final Parcelable.Creator<Type> CREATOR = null;
        public static final Companion Companion = null;
        public final String code;
        private final boolean hasDelayedSettlement;
        public final boolean isReusable;
        public final boolean isVoucher;
        public final boolean requiresMandate;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<Type> {
            public final Type createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return Type.valueOf(parcel.readString());
            }

            public final Type[] newArray(int i) {
                return new Type[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(name());
        }

        private Type(String str, boolean z, boolean z2, boolean z3, boolean z4) {
            this.code = str;
            this.isReusable = z;
            this.isVoucher = z2;
            this.requiresMandate = z3;
            this.hasDelayedSettlement = z4;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
            CREATOR = new Creator();
        }

        public final boolean hasDelayedSettlement() {
            return this.hasDelayedSettlement;
        }

        public String toString() {
            return this.code;
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$Type$Companion;", "", "()V", "fromCode", "Lcom/stripe/android/model/PaymentMethod$Type;", "code", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethod.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final /* synthetic */ Type fromCode(String str) {
                Type[] values = Type.values();
                int length = values.length;
                int i = 0;
                while (i < length) {
                    Type type = values[i];
                    i++;
                    if (Intrinsics.areEqual((Object) type.code, (Object) str)) {
                        return type;
                    }
                }
                return null;
            }
        }
    }

    @Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010(\u001a\u00020\u0002H\u0016J\u0010\u0010)\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010*\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010+\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010,\u001a\u00020\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010-\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0015\u0010.\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010/J\u0010\u00100\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u00101\u001a\u00020\u00002\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u00102\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012J\u0010\u00103\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u000e\u00104\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019J\u001c\u00105\u001a\u00020\u00002\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001bJ\u0010\u00106\u001a\u00020\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0010\u00107\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0010\u00108\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010!J\u0010\u00109\u001a\u00020\u00002\b\u0010\"\u001a\u0004\u0018\u00010#J\u0010\u0010:\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010'J\u0010\u0010;\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010%R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$Builder;", "Lcom/stripe/android/ObjectBuilder;", "Lcom/stripe/android/model/PaymentMethod;", "()V", "auBecsDebit", "Lcom/stripe/android/model/PaymentMethod$AuBecsDebit;", "bacsDebit", "Lcom/stripe/android/model/PaymentMethod$BacsDebit;", "billingDetails", "Lcom/stripe/android/model/PaymentMethod$BillingDetails;", "card", "Lcom/stripe/android/model/PaymentMethod$Card;", "cardPresent", "Lcom/stripe/android/model/PaymentMethod$CardPresent;", "created", "", "Ljava/lang/Long;", "customerId", "", "fpx", "Lcom/stripe/android/model/PaymentMethod$Fpx;", "id", "ideal", "Lcom/stripe/android/model/PaymentMethod$Ideal;", "liveMode", "", "metadata", "", "netbanking", "Lcom/stripe/android/model/PaymentMethod$Netbanking;", "sepaDebit", "Lcom/stripe/android/model/PaymentMethod$SepaDebit;", "sofort", "Lcom/stripe/android/model/PaymentMethod$Sofort;", "type", "Lcom/stripe/android/model/PaymentMethod$Type;", "upi", "Lcom/stripe/android/model/PaymentMethod$Upi;", "usBankAccount", "Lcom/stripe/android/model/PaymentMethod$USBankAccount;", "build", "setAuBecsDebit", "setBacsDebit", "setBillingDetails", "setCard", "setCardPresent", "setCreated", "(Ljava/lang/Long;)Lcom/stripe/android/model/PaymentMethod$Builder;", "setCustomerId", "setFpx", "setId", "setIdeal", "setLiveMode", "setMetadata", "setNetbanking", "setSepaDebit", "setSofort", "setType", "setUSBankAccount", "setUpi", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethod.kt */
    public static final class Builder implements ObjectBuilder<PaymentMethod> {
        public static final int $stable = 8;
        private AuBecsDebit auBecsDebit;
        private BacsDebit bacsDebit;
        private BillingDetails billingDetails;
        private Card card;
        private CardPresent cardPresent;
        private Long created;
        private String customerId;
        private Fpx fpx;
        private String id;
        private Ideal ideal;
        private boolean liveMode;
        private Map<String, String> metadata;
        private Netbanking netbanking;
        private SepaDebit sepaDebit;
        private Sofort sofort;
        private Type type;
        private Upi upi;
        private USBankAccount usBankAccount;

        public final Builder setId(String str) {
            Builder builder = this;
            builder.id = str;
            return builder;
        }

        public final Builder setCreated(Long l) {
            Builder builder = this;
            builder.created = l;
            return builder;
        }

        public final Builder setLiveMode(boolean z) {
            Builder builder = this;
            builder.liveMode = z;
            return builder;
        }

        public final Builder setMetadata(Map<String, String> map) {
            Builder builder = this;
            builder.metadata = map;
            return builder;
        }

        public final Builder setType(Type type2) {
            Builder builder = this;
            builder.type = type2;
            return builder;
        }

        public final Builder setBillingDetails(BillingDetails billingDetails2) {
            Builder builder = this;
            builder.billingDetails = billingDetails2;
            return builder;
        }

        public final Builder setCard(Card card2) {
            Builder builder = this;
            builder.card = card2;
            return builder;
        }

        public final Builder setCardPresent(CardPresent cardPresent2) {
            Builder builder = this;
            builder.cardPresent = cardPresent2;
            return builder;
        }

        public final Builder setCustomerId(String str) {
            Builder builder = this;
            builder.customerId = str;
            return builder;
        }

        public final Builder setIdeal(Ideal ideal2) {
            Builder builder = this;
            builder.ideal = ideal2;
            return builder;
        }

        public final Builder setFpx(Fpx fpx2) {
            Builder builder = this;
            builder.fpx = fpx2;
            return builder;
        }

        public final Builder setSepaDebit(SepaDebit sepaDebit2) {
            Builder builder = this;
            builder.sepaDebit = sepaDebit2;
            return builder;
        }

        public final Builder setAuBecsDebit(AuBecsDebit auBecsDebit2) {
            Builder builder = this;
            builder.auBecsDebit = auBecsDebit2;
            return builder;
        }

        public final Builder setBacsDebit(BacsDebit bacsDebit2) {
            Builder builder = this;
            builder.bacsDebit = bacsDebit2;
            return builder;
        }

        public final Builder setSofort(Sofort sofort2) {
            Builder builder = this;
            builder.sofort = sofort2;
            return builder;
        }

        public final Builder setNetbanking(Netbanking netbanking2) {
            Builder builder = this;
            builder.netbanking = netbanking2;
            return builder;
        }

        public final Builder setUSBankAccount(USBankAccount uSBankAccount) {
            Builder builder = this;
            builder.usBankAccount = uSBankAccount;
            return builder;
        }

        public final Builder setUpi(Upi upi2) {
            Builder builder = this;
            builder.upi = upi2;
            return builder;
        }

        public PaymentMethod build() {
            return new PaymentMethod(this.id, this.created, this.liveMode, this.type, this.billingDetails, this.customerId, this.card, this.cardPresent, this.fpx, this.ideal, this.sepaDebit, this.auBecsDebit, this.bacsDebit, this.sofort, (Upi) null, this.netbanking, this.usBankAccount, 16384, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0002 !B7\b\u0007\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\u000b\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J9\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\u0014\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010HÖ\u0001R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/stripe/android/model/PaymentMethod$BillingDetails;", "Lcom/stripe/android/core/model/StripeModel;", "Lcom/stripe/android/model/StripeParamsModel;", "address", "Lcom/stripe/android/model/Address;", "email", "", "name", "phone", "(Lcom/stripe/android/model/Address;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toBuilder", "Lcom/stripe/android/model/PaymentMethod$BillingDetails$Builder;", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Builder", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethod.kt */
    public static final class BillingDetails implements StripeModel, StripeParamsModel {
        public static final int $stable = 0;
        public static final Parcelable.Creator<BillingDetails> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String PARAM_ADDRESS = "address";
        public static final String PARAM_EMAIL = "email";
        public static final String PARAM_NAME = "name";
        public static final String PARAM_PHONE = "phone";
        public final Address address;
        public final String email;
        public final String name;
        public final String phone;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<BillingDetails> {
            public final BillingDetails createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new BillingDetails(parcel.readInt() == 0 ? null : Address.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString());
            }

            public final BillingDetails[] newArray(int i) {
                return new BillingDetails[i];
            }
        }

        public BillingDetails() {
            this((Address) null, (String) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
        }

        public BillingDetails(Address address2) {
            this(address2, (String) null, (String) null, (String) null, 14, (DefaultConstructorMarker) null);
        }

        public BillingDetails(Address address2, String str) {
            this(address2, str, (String) null, (String) null, 12, (DefaultConstructorMarker) null);
        }

        public BillingDetails(Address address2, String str, String str2) {
            this(address2, str, str2, (String) null, 8, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ BillingDetails copy$default(BillingDetails billingDetails, Address address2, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                address2 = billingDetails.address;
            }
            if ((i & 2) != 0) {
                str = billingDetails.email;
            }
            if ((i & 4) != 0) {
                str2 = billingDetails.name;
            }
            if ((i & 8) != 0) {
                str3 = billingDetails.phone;
            }
            return billingDetails.copy(address2, str, str2, str3);
        }

        public final Address component1() {
            return this.address;
        }

        public final String component2() {
            return this.email;
        }

        public final String component3() {
            return this.name;
        }

        public final String component4() {
            return this.phone;
        }

        public final BillingDetails copy(Address address2, String str, String str2, String str3) {
            return new BillingDetails(address2, str, str2, str3);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BillingDetails)) {
                return false;
            }
            BillingDetails billingDetails = (BillingDetails) obj;
            return Intrinsics.areEqual((Object) this.address, (Object) billingDetails.address) && Intrinsics.areEqual((Object) this.email, (Object) billingDetails.email) && Intrinsics.areEqual((Object) this.name, (Object) billingDetails.name) && Intrinsics.areEqual((Object) this.phone, (Object) billingDetails.phone);
        }

        public int hashCode() {
            Address address2 = this.address;
            int i = 0;
            int hashCode = (address2 == null ? 0 : address2.hashCode()) * 31;
            String str = this.email;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.name;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.phone;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode3 + i;
        }

        public String toString() {
            return "BillingDetails(address=" + this.address + ", email=" + this.email + ", name=" + this.name + ", phone=" + this.phone + ')';
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
            parcel.writeString(this.email);
            parcel.writeString(this.name);
            parcel.writeString(this.phone);
        }

        public BillingDetails(Address address2, String str, String str2, String str3) {
            this.address = address2;
            this.email = str;
            this.name = str2;
            this.phone = str3;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ BillingDetails(Address address2, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : address2, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
        }

        public final Builder toBuilder() {
            return new Builder().setAddress(this.address).setEmail(this.email).setName(this.name).setPhone(this.phone);
        }

        public Map<String, Object> toParamMap() {
            Map<K, V> map;
            Map map2;
            Map map3;
            Map emptyMap = MapsKt.emptyMap();
            Address address2 = this.address;
            Map map4 = null;
            if (address2 == null) {
                map = null;
            } else {
                map = MapsKt.mapOf(TuplesKt.to(PARAM_ADDRESS, address2.toParamMap()));
            }
            if (map == null) {
                map = MapsKt.emptyMap();
            }
            Map<K, V> plus = MapsKt.plus(emptyMap, (Map) map);
            String str = this.email;
            if (str == null) {
                map2 = null;
            } else {
                map2 = MapsKt.mapOf(TuplesKt.to("email", str));
            }
            if (map2 == null) {
                map2 = MapsKt.emptyMap();
            }
            Map<K, V> plus2 = MapsKt.plus(plus, (Map<K, V>) map2);
            String str2 = this.name;
            if (str2 == null) {
                map3 = null;
            } else {
                map3 = MapsKt.mapOf(TuplesKt.to("name", str2));
            }
            if (map3 == null) {
                map3 = MapsKt.emptyMap();
            }
            Map<K, V> plus3 = MapsKt.plus(plus2, (Map<K, V>) map3);
            String str3 = this.phone;
            if (str3 != null) {
                map4 = MapsKt.mapOf(TuplesKt.to("phone", str3));
            }
            if (map4 == null) {
                map4 = MapsKt.emptyMap();
            }
            return MapsKt.plus(plus3, (Map<K, V>) map4);
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\f\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$BillingDetails$Builder;", "Lcom/stripe/android/ObjectBuilder;", "Lcom/stripe/android/model/PaymentMethod$BillingDetails;", "()V", "address", "Lcom/stripe/android/model/Address;", "email", "", "name", "phone", "build", "setAddress", "setEmail", "setName", "setPhone", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethod.kt */
        public static final class Builder implements ObjectBuilder<BillingDetails> {
            public static final int $stable = 8;
            private Address address;
            private String email;
            private String name;
            private String phone;

            public final Builder setAddress(Address address2) {
                Builder builder = this;
                builder.address = address2;
                return builder;
            }

            public final Builder setEmail(String str) {
                Builder builder = this;
                builder.email = str;
                return builder;
            }

            public final Builder setName(String str) {
                Builder builder = this;
                builder.name = str;
                return builder;
            }

            public final Builder setPhone(String str) {
                Builder builder = this;
                builder.phone = str;
                return builder;
            }

            public BillingDetails build() {
                return new BillingDetails(this.address, this.email, this.name, this.phone);
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$BillingDetails$Companion;", "", "()V", "PARAM_ADDRESS", "", "PARAM_EMAIL", "PARAM_NAME", "PARAM_PHONE", "create", "Lcom/stripe/android/model/PaymentMethod$BillingDetails;", "shippingInformation", "Lcom/stripe/android/model/ShippingInformation;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethod.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final BillingDetails create(ShippingInformation shippingInformation) {
                Intrinsics.checkNotNullParameter(shippingInformation, "shippingInformation");
                return new BillingDetails(shippingInformation.getAddress(), (String) null, shippingInformation.getName(), shippingInformation.getPhone(), 2, (DefaultConstructorMarker) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0001\u000b\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$TypeData;", "Lcom/stripe/android/core/model/StripeModel;", "()V", "type", "Lcom/stripe/android/model/PaymentMethod$Type;", "getType", "()Lcom/stripe/android/model/PaymentMethod$Type;", "Lcom/stripe/android/model/PaymentMethod$Card;", "Lcom/stripe/android/model/PaymentMethod$CardPresent;", "Lcom/stripe/android/model/PaymentMethod$Ideal;", "Lcom/stripe/android/model/PaymentMethod$Fpx;", "Lcom/stripe/android/model/PaymentMethod$SepaDebit;", "Lcom/stripe/android/model/PaymentMethod$AuBecsDebit;", "Lcom/stripe/android/model/PaymentMethod$BacsDebit;", "Lcom/stripe/android/model/PaymentMethod$Sofort;", "Lcom/stripe/android/model/PaymentMethod$Upi;", "Lcom/stripe/android/model/PaymentMethod$Netbanking;", "Lcom/stripe/android/model/PaymentMethod$USBankAccount;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethod.kt */
    public static abstract class TypeData implements StripeModel {
        public static final int $stable = 0;

        public /* synthetic */ TypeData(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract Type getType();

        private TypeData() {
        }
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0003567B\u0001\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0013HÀ\u0003¢\u0006\u0002\b\u001dJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0001\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u0010(J\t\u0010)\u001a\u00020\tHÖ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\tHÖ\u0001J\t\u0010/\u001a\u00020\u0007HÖ\u0001J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\tHÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0014\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0000X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$Card;", "Lcom/stripe/android/model/PaymentMethod$TypeData;", "brand", "Lcom/stripe/android/model/CardBrand;", "checks", "Lcom/stripe/android/model/PaymentMethod$Card$Checks;", "country", "", "expiryMonth", "", "expiryYear", "fingerprint", "funding", "last4", "threeDSecureUsage", "Lcom/stripe/android/model/PaymentMethod$Card$ThreeDSecureUsage;", "wallet", "Lcom/stripe/android/model/wallets/Wallet;", "networks", "Lcom/stripe/android/model/PaymentMethod$Card$Networks;", "(Lcom/stripe/android/model/CardBrand;Lcom/stripe/android/model/PaymentMethod$Card$Checks;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/PaymentMethod$Card$ThreeDSecureUsage;Lcom/stripe/android/model/wallets/Wallet;Lcom/stripe/android/model/PaymentMethod$Card$Networks;)V", "Ljava/lang/Integer;", "type", "Lcom/stripe/android/model/PaymentMethod$Type;", "getType", "()Lcom/stripe/android/model/PaymentMethod$Type;", "component1", "component10", "component11", "component11$payments_core_release", "component2", "component3", "component4", "()Ljava/lang/Integer;", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/stripe/android/model/CardBrand;Lcom/stripe/android/model/PaymentMethod$Card$Checks;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/PaymentMethod$Card$ThreeDSecureUsage;Lcom/stripe/android/model/wallets/Wallet;Lcom/stripe/android/model/PaymentMethod$Card$Networks;)Lcom/stripe/android/model/PaymentMethod$Card;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Checks", "Networks", "ThreeDSecureUsage", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethod.kt */
    public static final class Card extends TypeData {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Card> CREATOR = new Creator();
        public final CardBrand brand;
        public final Checks checks;
        public final String country;
        public final Integer expiryMonth;
        public final Integer expiryYear;
        public final String fingerprint;
        public final String funding;
        public final String last4;
        public final Networks networks;
        public final ThreeDSecureUsage threeDSecureUsage;
        public final Wallet wallet;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<Card> {
            public final Card createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                CardBrand valueOf = CardBrand.valueOf(parcel.readString());
                Networks networks = null;
                Checks createFromParcel = parcel.readInt() == 0 ? null : Checks.CREATOR.createFromParcel(parcel);
                String readString = parcel.readString();
                Integer valueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
                Integer valueOf3 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                ThreeDSecureUsage createFromParcel2 = parcel.readInt() == 0 ? null : ThreeDSecureUsage.CREATOR.createFromParcel(parcel);
                Wallet wallet = (Wallet) parcel.readParcelable(Card.class.getClassLoader());
                if (parcel.readInt() != 0) {
                    networks = Networks.CREATOR.createFromParcel(parcel);
                }
                return new Card(valueOf, createFromParcel, readString, valueOf2, valueOf3, readString2, readString3, readString4, createFromParcel2, wallet, networks);
            }

            public final Card[] newArray(int i) {
                return new Card[i];
            }
        }

        public Card() {
            this((CardBrand) null, (Checks) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (ThreeDSecureUsage) null, (Wallet) null, (Networks) null, 2047, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Card copy$default(Card card, CardBrand cardBrand, Checks checks2, String str, Integer num, Integer num2, String str2, String str3, String str4, ThreeDSecureUsage threeDSecureUsage2, Wallet wallet2, Networks networks2, int i, Object obj) {
            Card card2 = card;
            int i2 = i;
            return card.copy((i2 & 1) != 0 ? card2.brand : cardBrand, (i2 & 2) != 0 ? card2.checks : checks2, (i2 & 4) != 0 ? card2.country : str, (i2 & 8) != 0 ? card2.expiryMonth : num, (i2 & 16) != 0 ? card2.expiryYear : num2, (i2 & 32) != 0 ? card2.fingerprint : str2, (i2 & 64) != 0 ? card2.funding : str3, (i2 & 128) != 0 ? card2.last4 : str4, (i2 & 256) != 0 ? card2.threeDSecureUsage : threeDSecureUsage2, (i2 & 512) != 0 ? card2.wallet : wallet2, (i2 & 1024) != 0 ? card2.networks : networks2);
        }

        public final CardBrand component1() {
            return this.brand;
        }

        public final Wallet component10() {
            return this.wallet;
        }

        public final Networks component11$payments_core_release() {
            return this.networks;
        }

        public final Checks component2() {
            return this.checks;
        }

        public final String component3() {
            return this.country;
        }

        public final Integer component4() {
            return this.expiryMonth;
        }

        public final Integer component5() {
            return this.expiryYear;
        }

        public final String component6() {
            return this.fingerprint;
        }

        public final String component7() {
            return this.funding;
        }

        public final String component8() {
            return this.last4;
        }

        public final ThreeDSecureUsage component9() {
            return this.threeDSecureUsage;
        }

        public final Card copy(CardBrand cardBrand, Checks checks2, String str, Integer num, Integer num2, String str2, String str3, String str4, ThreeDSecureUsage threeDSecureUsage2, Wallet wallet2, Networks networks2) {
            Intrinsics.checkNotNullParameter(cardBrand, AccountRangeJsonParser.FIELD_BRAND);
            return new Card(cardBrand, checks2, str, num, num2, str2, str3, str4, threeDSecureUsage2, wallet2, networks2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Card)) {
                return false;
            }
            Card card = (Card) obj;
            return this.brand == card.brand && Intrinsics.areEqual((Object) this.checks, (Object) card.checks) && Intrinsics.areEqual((Object) this.country, (Object) card.country) && Intrinsics.areEqual((Object) this.expiryMonth, (Object) card.expiryMonth) && Intrinsics.areEqual((Object) this.expiryYear, (Object) card.expiryYear) && Intrinsics.areEqual((Object) this.fingerprint, (Object) card.fingerprint) && Intrinsics.areEqual((Object) this.funding, (Object) card.funding) && Intrinsics.areEqual((Object) this.last4, (Object) card.last4) && Intrinsics.areEqual((Object) this.threeDSecureUsage, (Object) card.threeDSecureUsage) && Intrinsics.areEqual((Object) this.wallet, (Object) card.wallet) && Intrinsics.areEqual((Object) this.networks, (Object) card.networks);
        }

        public int hashCode() {
            int hashCode = this.brand.hashCode() * 31;
            Checks checks2 = this.checks;
            int i = 0;
            int hashCode2 = (hashCode + (checks2 == null ? 0 : checks2.hashCode())) * 31;
            String str = this.country;
            int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
            Integer num = this.expiryMonth;
            int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.expiryYear;
            int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str2 = this.fingerprint;
            int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.funding;
            int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.last4;
            int hashCode8 = (hashCode7 + (str4 == null ? 0 : str4.hashCode())) * 31;
            ThreeDSecureUsage threeDSecureUsage2 = this.threeDSecureUsage;
            int hashCode9 = (hashCode8 + (threeDSecureUsage2 == null ? 0 : threeDSecureUsage2.hashCode())) * 31;
            Wallet wallet2 = this.wallet;
            int hashCode10 = (hashCode9 + (wallet2 == null ? 0 : wallet2.hashCode())) * 31;
            Networks networks2 = this.networks;
            if (networks2 != null) {
                i = networks2.hashCode();
            }
            return hashCode10 + i;
        }

        public String toString() {
            return "Card(brand=" + this.brand + ", checks=" + this.checks + ", country=" + this.country + ", expiryMonth=" + this.expiryMonth + ", expiryYear=" + this.expiryYear + ", fingerprint=" + this.fingerprint + ", funding=" + this.funding + ", last4=" + this.last4 + ", threeDSecureUsage=" + this.threeDSecureUsage + ", wallet=" + this.wallet + ", networks=" + this.networks + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.brand.name());
            Checks checks2 = this.checks;
            if (checks2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                checks2.writeToParcel(parcel, i);
            }
            parcel.writeString(this.country);
            Integer num = this.expiryMonth;
            if (num == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num.intValue());
            }
            Integer num2 = this.expiryYear;
            if (num2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeInt(num2.intValue());
            }
            parcel.writeString(this.fingerprint);
            parcel.writeString(this.funding);
            parcel.writeString(this.last4);
            ThreeDSecureUsage threeDSecureUsage2 = this.threeDSecureUsage;
            if (threeDSecureUsage2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                threeDSecureUsage2.writeToParcel(parcel, i);
            }
            parcel.writeParcelable(this.wallet, i);
            Networks networks2 = this.networks;
            if (networks2 == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            networks2.writeToParcel(parcel, i);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Card(com.stripe.android.model.CardBrand r13, com.stripe.android.model.PaymentMethod.Card.Checks r14, java.lang.String r15, java.lang.Integer r16, java.lang.Integer r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, com.stripe.android.model.PaymentMethod.Card.ThreeDSecureUsage r21, com.stripe.android.model.wallets.Wallet r22, com.stripe.android.model.PaymentMethod.Card.Networks r23, int r24, kotlin.jvm.internal.DefaultConstructorMarker r25) {
            /*
                r12 = this;
                r0 = r24
                r1 = r0 & 1
                if (r1 == 0) goto L_0x0009
                com.stripe.android.model.CardBrand r1 = com.stripe.android.model.CardBrand.Unknown
                goto L_0x000a
            L_0x0009:
                r1 = r13
            L_0x000a:
                r2 = r0 & 2
                r3 = 0
                if (r2 == 0) goto L_0x0011
                r2 = r3
                goto L_0x0012
            L_0x0011:
                r2 = r14
            L_0x0012:
                r4 = r0 & 4
                if (r4 == 0) goto L_0x0018
                r4 = r3
                goto L_0x0019
            L_0x0018:
                r4 = r15
            L_0x0019:
                r5 = r0 & 8
                if (r5 == 0) goto L_0x001f
                r5 = r3
                goto L_0x0021
            L_0x001f:
                r5 = r16
            L_0x0021:
                r6 = r0 & 16
                if (r6 == 0) goto L_0x0027
                r6 = r3
                goto L_0x0029
            L_0x0027:
                r6 = r17
            L_0x0029:
                r7 = r0 & 32
                if (r7 == 0) goto L_0x002f
                r7 = r3
                goto L_0x0031
            L_0x002f:
                r7 = r18
            L_0x0031:
                r8 = r0 & 64
                if (r8 == 0) goto L_0x0037
                r8 = r3
                goto L_0x0039
            L_0x0037:
                r8 = r19
            L_0x0039:
                r9 = r0 & 128(0x80, float:1.794E-43)
                if (r9 == 0) goto L_0x003f
                r9 = r3
                goto L_0x0041
            L_0x003f:
                r9 = r20
            L_0x0041:
                r10 = r0 & 256(0x100, float:3.59E-43)
                if (r10 == 0) goto L_0x0047
                r10 = r3
                goto L_0x0049
            L_0x0047:
                r10 = r21
            L_0x0049:
                r11 = r0 & 512(0x200, float:7.175E-43)
                if (r11 == 0) goto L_0x004f
                r11 = r3
                goto L_0x0051
            L_0x004f:
                r11 = r22
            L_0x0051:
                r0 = r0 & 1024(0x400, float:1.435E-42)
                if (r0 == 0) goto L_0x0056
                goto L_0x0058
            L_0x0056:
                r3 = r23
            L_0x0058:
                r13 = r12
                r14 = r1
                r15 = r2
                r16 = r4
                r17 = r5
                r18 = r6
                r19 = r7
                r20 = r8
                r21 = r9
                r22 = r10
                r23 = r11
                r24 = r3
                r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.model.PaymentMethod.Card.<init>(com.stripe.android.model.CardBrand, com.stripe.android.model.PaymentMethod$Card$Checks, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, com.stripe.android.model.PaymentMethod$Card$ThreeDSecureUsage, com.stripe.android.model.wallets.Wallet, com.stripe.android.model.PaymentMethod$Card$Networks, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Card(CardBrand cardBrand, Checks checks2, String str, Integer num, Integer num2, String str2, String str3, String str4, ThreeDSecureUsage threeDSecureUsage2, Wallet wallet2, Networks networks2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(cardBrand, AccountRangeJsonParser.FIELD_BRAND);
            this.brand = cardBrand;
            this.checks = checks2;
            this.country = str;
            this.expiryMonth = num;
            this.expiryYear = num2;
            this.fingerprint = str2;
            this.funding = str3;
            this.last4 = str4;
            this.threeDSecureUsage = threeDSecureUsage2;
            this.wallet = wallet2;
            this.networks = networks2;
        }

        public Type getType() {
            return Type.Card;
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$Card$Checks;", "Lcom/stripe/android/core/model/StripeModel;", "addressLine1Check", "", "addressPostalCodeCheck", "cvcCheck", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethod.kt */
        public static final class Checks implements StripeModel {
            public static final int $stable = 8;
            public static final Parcelable.Creator<Checks> CREATOR = new Creator();
            public final String addressLine1Check;
            public final String addressPostalCodeCheck;
            public final String cvcCheck;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentMethod.kt */
            public static final class Creator implements Parcelable.Creator<Checks> {
                public final Checks createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new Checks(parcel.readString(), parcel.readString(), parcel.readString());
                }

                public final Checks[] newArray(int i) {
                    return new Checks[i];
                }
            }

            public static /* synthetic */ Checks copy$default(Checks checks, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = checks.addressLine1Check;
                }
                if ((i & 2) != 0) {
                    str2 = checks.addressPostalCodeCheck;
                }
                if ((i & 4) != 0) {
                    str3 = checks.cvcCheck;
                }
                return checks.copy(str, str2, str3);
            }

            public final String component1() {
                return this.addressLine1Check;
            }

            public final String component2() {
                return this.addressPostalCodeCheck;
            }

            public final String component3() {
                return this.cvcCheck;
            }

            public final Checks copy(String str, String str2, String str3) {
                return new Checks(str, str2, str3);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Checks)) {
                    return false;
                }
                Checks checks = (Checks) obj;
                return Intrinsics.areEqual((Object) this.addressLine1Check, (Object) checks.addressLine1Check) && Intrinsics.areEqual((Object) this.addressPostalCodeCheck, (Object) checks.addressPostalCodeCheck) && Intrinsics.areEqual((Object) this.cvcCheck, (Object) checks.cvcCheck);
            }

            public int hashCode() {
                String str = this.addressLine1Check;
                int i = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.addressPostalCodeCheck;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.cvcCheck;
                if (str3 != null) {
                    i = str3.hashCode();
                }
                return hashCode2 + i;
            }

            public String toString() {
                return "Checks(addressLine1Check=" + this.addressLine1Check + ", addressPostalCodeCheck=" + this.addressPostalCodeCheck + ", cvcCheck=" + this.cvcCheck + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.addressLine1Check);
                parcel.writeString(this.addressPostalCodeCheck);
                parcel.writeString(this.cvcCheck);
            }

            public Checks(String str, String str2, String str3) {
                this.addressLine1Check = str;
                this.addressPostalCodeCheck = str2;
                this.cvcCheck = str3;
            }
        }

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\bHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bHÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$Card$ThreeDSecureUsage;", "Lcom/stripe/android/core/model/StripeModel;", "isSupported", "", "(Z)V", "component1", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethod.kt */
        public static final class ThreeDSecureUsage implements StripeModel {
            public static final int $stable = 8;
            public static final Parcelable.Creator<ThreeDSecureUsage> CREATOR = new Creator();
            public final boolean isSupported;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentMethod.kt */
            public static final class Creator implements Parcelable.Creator<ThreeDSecureUsage> {
                public final ThreeDSecureUsage createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new ThreeDSecureUsage(parcel.readInt() != 0);
                }

                public final ThreeDSecureUsage[] newArray(int i) {
                    return new ThreeDSecureUsage[i];
                }
            }

            public static /* synthetic */ ThreeDSecureUsage copy$default(ThreeDSecureUsage threeDSecureUsage, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = threeDSecureUsage.isSupported;
                }
                return threeDSecureUsage.copy(z);
            }

            public final boolean component1() {
                return this.isSupported;
            }

            public final ThreeDSecureUsage copy(boolean z) {
                return new ThreeDSecureUsage(z);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ThreeDSecureUsage) && this.isSupported == ((ThreeDSecureUsage) obj).isSupported;
            }

            public int hashCode() {
                boolean z = this.isSupported;
                if (z) {
                    return 1;
                }
                return z ? 1 : 0;
            }

            public String toString() {
                return "ThreeDSecureUsage(isSupported=" + this.isSupported + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeInt(this.isSupported ? 1 : 0);
            }

            public ThreeDSecureUsage(boolean z) {
                this.isSupported = z;
            }
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\bJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$Card$Networks;", "Lcom/stripe/android/core/model/StripeModel;", "available", "", "", "selectionMandatory", "", "preferred", "(Ljava/util/Set;ZLjava/lang/String;)V", "getAvailable", "()Ljava/util/Set;", "getPreferred", "()Ljava/lang/String;", "getSelectionMandatory", "()Z", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethod.kt */
        public static final class Networks implements StripeModel {
            public static final int $stable = 8;
            public static final Parcelable.Creator<Networks> CREATOR = new Creator();
            private final Set<String> available;
            private final String preferred;
            private final boolean selectionMandatory;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentMethod.kt */
            public static final class Creator implements Parcelable.Creator<Networks> {
                public final Networks createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    int readInt = parcel.readInt();
                    LinkedHashSet linkedHashSet = new LinkedHashSet(readInt);
                    boolean z = false;
                    for (int i = 0; i != readInt; i++) {
                        linkedHashSet.add(parcel.readString());
                    }
                    Set set = linkedHashSet;
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    return new Networks(set, z, parcel.readString());
                }

                public final Networks[] newArray(int i) {
                    return new Networks[i];
                }
            }

            public Networks() {
                this((Set) null, false, (String) null, 7, (DefaultConstructorMarker) null);
            }

            public static /* synthetic */ Networks copy$default(Networks networks, Set<String> set, boolean z, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    set = networks.available;
                }
                if ((i & 2) != 0) {
                    z = networks.selectionMandatory;
                }
                if ((i & 4) != 0) {
                    str = networks.preferred;
                }
                return networks.copy(set, z, str);
            }

            public final Set<String> component1() {
                return this.available;
            }

            public final boolean component2() {
                return this.selectionMandatory;
            }

            public final String component3() {
                return this.preferred;
            }

            public final Networks copy(Set<String> set, boolean z, String str) {
                Intrinsics.checkNotNullParameter(set, "available");
                return new Networks(set, z, str);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Networks)) {
                    return false;
                }
                Networks networks = (Networks) obj;
                return Intrinsics.areEqual((Object) this.available, (Object) networks.available) && this.selectionMandatory == networks.selectionMandatory && Intrinsics.areEqual((Object) this.preferred, (Object) networks.preferred);
            }

            public int hashCode() {
                int hashCode = this.available.hashCode() * 31;
                boolean z = this.selectionMandatory;
                if (z) {
                    z = true;
                }
                int i = (hashCode + (z ? 1 : 0)) * 31;
                String str = this.preferred;
                return i + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "Networks(available=" + this.available + ", selectionMandatory=" + this.selectionMandatory + ", preferred=" + this.preferred + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                Set<String> set = this.available;
                parcel.writeInt(set.size());
                for (String writeString : set) {
                    parcel.writeString(writeString);
                }
                parcel.writeInt(this.selectionMandatory ? 1 : 0);
                parcel.writeString(this.preferred);
            }

            public Networks(Set<String> set, boolean z, String str) {
                Intrinsics.checkNotNullParameter(set, "available");
                this.available = set;
                this.selectionMandatory = z;
                this.preferred = str;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Networks(Set set, boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? SetsKt.emptySet() : set, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : str);
            }

            public final Set<String> getAvailable() {
                return this.available;
            }

            public final boolean getSelectionMandatory() {
                return this.selectionMandatory;
            }

            public final String getPreferred() {
                return this.preferred;
            }
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\t\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\fHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$CardPresent;", "Lcom/stripe/android/model/PaymentMethod$TypeData;", "ignore", "", "(Z)V", "type", "Lcom/stripe/android/model/PaymentMethod$Type;", "getType", "()Lcom/stripe/android/model/PaymentMethod$Type;", "component1", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethod.kt */
    public static final class CardPresent extends TypeData {
        public static final int $stable = 8;
        public static final Parcelable.Creator<CardPresent> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static final /* synthetic */ CardPresent EMPTY = new CardPresent(false, 1, (DefaultConstructorMarker) null);
        private final boolean ignore;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<CardPresent> {
            public final CardPresent createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new CardPresent(parcel.readInt() != 0);
            }

            public final CardPresent[] newArray(int i) {
                return new CardPresent[i];
            }
        }

        public CardPresent() {
            this(false, 1, (DefaultConstructorMarker) null);
        }

        private final boolean component1() {
            return this.ignore;
        }

        public static /* synthetic */ CardPresent copy$default(CardPresent cardPresent, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = cardPresent.ignore;
            }
            return cardPresent.copy(z);
        }

        public final CardPresent copy(boolean z) {
            return new CardPresent(z);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CardPresent) && this.ignore == ((CardPresent) obj).ignore;
        }

        public int hashCode() {
            boolean z = this.ignore;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "CardPresent(ignore=" + this.ignore + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.ignore ? 1 : 0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CardPresent(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z);
        }

        public CardPresent(boolean z) {
            super((DefaultConstructorMarker) null);
            this.ignore = z;
        }

        public Type getType() {
            return Type.CardPresent;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$CardPresent$Companion;", "", "()V", "EMPTY", "Lcom/stripe/android/model/PaymentMethod$CardPresent;", "getEMPTY$payments_core_release", "()Lcom/stripe/android/model/PaymentMethod$CardPresent;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethod.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final CardPresent getEMPTY$payments_core_release() {
                return CardPresent.EMPTY;
            }
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$Ideal;", "Lcom/stripe/android/model/PaymentMethod$TypeData;", "bank", "", "bankIdentifierCode", "(Ljava/lang/String;Ljava/lang/String;)V", "type", "Lcom/stripe/android/model/PaymentMethod$Type;", "getType", "()Lcom/stripe/android/model/PaymentMethod$Type;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethod.kt */
    public static final class Ideal extends TypeData {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Ideal> CREATOR = new Creator();
        public final String bank;
        public final String bankIdentifierCode;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<Ideal> {
            public final Ideal createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Ideal(parcel.readString(), parcel.readString());
            }

            public final Ideal[] newArray(int i) {
                return new Ideal[i];
            }
        }

        public static /* synthetic */ Ideal copy$default(Ideal ideal, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = ideal.bank;
            }
            if ((i & 2) != 0) {
                str2 = ideal.bankIdentifierCode;
            }
            return ideal.copy(str, str2);
        }

        public final String component1() {
            return this.bank;
        }

        public final String component2() {
            return this.bankIdentifierCode;
        }

        public final Ideal copy(String str, String str2) {
            return new Ideal(str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Ideal)) {
                return false;
            }
            Ideal ideal = (Ideal) obj;
            return Intrinsics.areEqual((Object) this.bank, (Object) ideal.bank) && Intrinsics.areEqual((Object) this.bankIdentifierCode, (Object) ideal.bankIdentifierCode);
        }

        public int hashCode() {
            String str = this.bank;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.bankIdentifierCode;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "Ideal(bank=" + this.bank + ", bankIdentifierCode=" + this.bankIdentifierCode + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.bank);
            parcel.writeString(this.bankIdentifierCode);
        }

        public Ideal(String str, String str2) {
            super((DefaultConstructorMarker) null);
            this.bank = str;
            this.bankIdentifierCode = str2;
        }

        public Type getType() {
            return Type.Ideal;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$Fpx;", "Lcom/stripe/android/model/PaymentMethod$TypeData;", "bank", "", "accountHolderType", "(Ljava/lang/String;Ljava/lang/String;)V", "type", "Lcom/stripe/android/model/PaymentMethod$Type;", "getType", "()Lcom/stripe/android/model/PaymentMethod$Type;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethod.kt */
    public static final class Fpx extends TypeData {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Fpx> CREATOR = new Creator();
        public final String accountHolderType;
        public final String bank;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<Fpx> {
            public final Fpx createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Fpx(parcel.readString(), parcel.readString());
            }

            public final Fpx[] newArray(int i) {
                return new Fpx[i];
            }
        }

        public static /* synthetic */ Fpx copy$default(Fpx fpx, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fpx.bank;
            }
            if ((i & 2) != 0) {
                str2 = fpx.accountHolderType;
            }
            return fpx.copy(str, str2);
        }

        public final String component1() {
            return this.bank;
        }

        public final String component2() {
            return this.accountHolderType;
        }

        public final Fpx copy(String str, String str2) {
            return new Fpx(str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Fpx)) {
                return false;
            }
            Fpx fpx = (Fpx) obj;
            return Intrinsics.areEqual((Object) this.bank, (Object) fpx.bank) && Intrinsics.areEqual((Object) this.accountHolderType, (Object) fpx.accountHolderType);
        }

        public int hashCode() {
            String str = this.bank;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.accountHolderType;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "Fpx(bank=" + this.bank + ", accountHolderType=" + this.accountHolderType + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.bank);
            parcel.writeString(this.accountHolderType);
        }

        public Fpx(String str, String str2) {
            super((DefaultConstructorMarker) null);
            this.bank = str;
            this.accountHolderType = str2;
        }

        public Type getType() {
            return Type.Fpx;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B9\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003JE\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0014HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lcom/stripe/android/model/PaymentMethod$SepaDebit;", "Lcom/stripe/android/model/PaymentMethod$TypeData;", "bankCode", "", "branchCode", "country", "fingerprint", "last4", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "type", "Lcom/stripe/android/model/PaymentMethod$Type;", "getType", "()Lcom/stripe/android/model/PaymentMethod$Type;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethod.kt */
    public static final class SepaDebit extends TypeData {
        public static final int $stable = 8;
        public static final Parcelable.Creator<SepaDebit> CREATOR = new Creator();
        public final String bankCode;
        public final String branchCode;
        public final String country;
        public final String fingerprint;
        public final String last4;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<SepaDebit> {
            public final SepaDebit createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new SepaDebit(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            public final SepaDebit[] newArray(int i) {
                return new SepaDebit[i];
            }
        }

        public static /* synthetic */ SepaDebit copy$default(SepaDebit sepaDebit, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sepaDebit.bankCode;
            }
            if ((i & 2) != 0) {
                str2 = sepaDebit.branchCode;
            }
            String str6 = str2;
            if ((i & 4) != 0) {
                str3 = sepaDebit.country;
            }
            String str7 = str3;
            if ((i & 8) != 0) {
                str4 = sepaDebit.fingerprint;
            }
            String str8 = str4;
            if ((i & 16) != 0) {
                str5 = sepaDebit.last4;
            }
            return sepaDebit.copy(str, str6, str7, str8, str5);
        }

        public final String component1() {
            return this.bankCode;
        }

        public final String component2() {
            return this.branchCode;
        }

        public final String component3() {
            return this.country;
        }

        public final String component4() {
            return this.fingerprint;
        }

        public final String component5() {
            return this.last4;
        }

        public final SepaDebit copy(String str, String str2, String str3, String str4, String str5) {
            return new SepaDebit(str, str2, str3, str4, str5);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SepaDebit)) {
                return false;
            }
            SepaDebit sepaDebit = (SepaDebit) obj;
            return Intrinsics.areEqual((Object) this.bankCode, (Object) sepaDebit.bankCode) && Intrinsics.areEqual((Object) this.branchCode, (Object) sepaDebit.branchCode) && Intrinsics.areEqual((Object) this.country, (Object) sepaDebit.country) && Intrinsics.areEqual((Object) this.fingerprint, (Object) sepaDebit.fingerprint) && Intrinsics.areEqual((Object) this.last4, (Object) sepaDebit.last4);
        }

        public int hashCode() {
            String str = this.bankCode;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.branchCode;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.country;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.fingerprint;
            int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.last4;
            if (str5 != null) {
                i = str5.hashCode();
            }
            return hashCode4 + i;
        }

        public String toString() {
            return "SepaDebit(bankCode=" + this.bankCode + ", branchCode=" + this.branchCode + ", country=" + this.country + ", fingerprint=" + this.fingerprint + ", last4=" + this.last4 + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.bankCode);
            parcel.writeString(this.branchCode);
            parcel.writeString(this.country);
            parcel.writeString(this.fingerprint);
            parcel.writeString(this.last4);
        }

        public SepaDebit(String str, String str2, String str3, String str4, String str5) {
            super((DefaultConstructorMarker) null);
            this.bankCode = str;
            this.branchCode = str2;
            this.country = str3;
            this.fingerprint = str4;
            this.last4 = str5;
        }

        public Type getType() {
            return Type.SepaDebit;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$AuBecsDebit;", "Lcom/stripe/android/model/PaymentMethod$TypeData;", "bsbNumber", "", "fingerprint", "last4", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "type", "Lcom/stripe/android/model/PaymentMethod$Type;", "getType", "()Lcom/stripe/android/model/PaymentMethod$Type;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethod.kt */
    public static final class AuBecsDebit extends TypeData {
        public static final int $stable = 8;
        public static final Parcelable.Creator<AuBecsDebit> CREATOR = new Creator();
        public final String bsbNumber;
        public final String fingerprint;
        public final String last4;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<AuBecsDebit> {
            public final AuBecsDebit createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new AuBecsDebit(parcel.readString(), parcel.readString(), parcel.readString());
            }

            public final AuBecsDebit[] newArray(int i) {
                return new AuBecsDebit[i];
            }
        }

        public static /* synthetic */ AuBecsDebit copy$default(AuBecsDebit auBecsDebit, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = auBecsDebit.bsbNumber;
            }
            if ((i & 2) != 0) {
                str2 = auBecsDebit.fingerprint;
            }
            if ((i & 4) != 0) {
                str3 = auBecsDebit.last4;
            }
            return auBecsDebit.copy(str, str2, str3);
        }

        public final String component1() {
            return this.bsbNumber;
        }

        public final String component2() {
            return this.fingerprint;
        }

        public final String component3() {
            return this.last4;
        }

        public final AuBecsDebit copy(String str, String str2, String str3) {
            return new AuBecsDebit(str, str2, str3);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AuBecsDebit)) {
                return false;
            }
            AuBecsDebit auBecsDebit = (AuBecsDebit) obj;
            return Intrinsics.areEqual((Object) this.bsbNumber, (Object) auBecsDebit.bsbNumber) && Intrinsics.areEqual((Object) this.fingerprint, (Object) auBecsDebit.fingerprint) && Intrinsics.areEqual((Object) this.last4, (Object) auBecsDebit.last4);
        }

        public int hashCode() {
            String str = this.bsbNumber;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.fingerprint;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.last4;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "AuBecsDebit(bsbNumber=" + this.bsbNumber + ", fingerprint=" + this.fingerprint + ", last4=" + this.last4 + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.bsbNumber);
            parcel.writeString(this.fingerprint);
            parcel.writeString(this.last4);
        }

        public AuBecsDebit(String str, String str2, String str3) {
            super((DefaultConstructorMarker) null);
            this.bsbNumber = str;
            this.fingerprint = str2;
            this.last4 = str3;
        }

        public Type getType() {
            return Type.AuBecsDebit;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$BacsDebit;", "Lcom/stripe/android/model/PaymentMethod$TypeData;", "fingerprint", "", "last4", "sortCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "type", "Lcom/stripe/android/model/PaymentMethod$Type;", "getType", "()Lcom/stripe/android/model/PaymentMethod$Type;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethod.kt */
    public static final class BacsDebit extends TypeData {
        public static final int $stable = 8;
        public static final Parcelable.Creator<BacsDebit> CREATOR = new Creator();
        public final String fingerprint;
        public final String last4;
        public final String sortCode;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<BacsDebit> {
            public final BacsDebit createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new BacsDebit(parcel.readString(), parcel.readString(), parcel.readString());
            }

            public final BacsDebit[] newArray(int i) {
                return new BacsDebit[i];
            }
        }

        public static /* synthetic */ BacsDebit copy$default(BacsDebit bacsDebit, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = bacsDebit.fingerprint;
            }
            if ((i & 2) != 0) {
                str2 = bacsDebit.last4;
            }
            if ((i & 4) != 0) {
                str3 = bacsDebit.sortCode;
            }
            return bacsDebit.copy(str, str2, str3);
        }

        public final String component1() {
            return this.fingerprint;
        }

        public final String component2() {
            return this.last4;
        }

        public final String component3() {
            return this.sortCode;
        }

        public final BacsDebit copy(String str, String str2, String str3) {
            return new BacsDebit(str, str2, str3);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BacsDebit)) {
                return false;
            }
            BacsDebit bacsDebit = (BacsDebit) obj;
            return Intrinsics.areEqual((Object) this.fingerprint, (Object) bacsDebit.fingerprint) && Intrinsics.areEqual((Object) this.last4, (Object) bacsDebit.last4) && Intrinsics.areEqual((Object) this.sortCode, (Object) bacsDebit.sortCode);
        }

        public int hashCode() {
            String str = this.fingerprint;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.last4;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.sortCode;
            if (str3 != null) {
                i = str3.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "BacsDebit(fingerprint=" + this.fingerprint + ", last4=" + this.last4 + ", sortCode=" + this.sortCode + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.fingerprint);
            parcel.writeString(this.last4);
            parcel.writeString(this.sortCode);
        }

        public BacsDebit(String str, String str2, String str3) {
            super((DefaultConstructorMarker) null);
            this.fingerprint = str;
            this.last4 = str2;
            this.sortCode = str3;
        }

        public Type getType() {
            return Type.BacsDebit;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$Sofort;", "Lcom/stripe/android/model/PaymentMethod$TypeData;", "country", "", "(Ljava/lang/String;)V", "type", "Lcom/stripe/android/model/PaymentMethod$Type;", "getType", "()Lcom/stripe/android/model/PaymentMethod$Type;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethod.kt */
    public static final class Sofort extends TypeData {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Sofort> CREATOR = new Creator();
        public final String country;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<Sofort> {
            public final Sofort createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Sofort(parcel.readString());
            }

            public final Sofort[] newArray(int i) {
                return new Sofort[i];
            }
        }

        public static /* synthetic */ Sofort copy$default(Sofort sofort, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sofort.country;
            }
            return sofort.copy(str);
        }

        public final String component1() {
            return this.country;
        }

        public final Sofort copy(String str) {
            return new Sofort(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Sofort) && Intrinsics.areEqual((Object) this.country, (Object) ((Sofort) obj).country);
        }

        public int hashCode() {
            String str = this.country;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Sofort(country=" + this.country + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.country);
        }

        public Sofort(String str) {
            super((DefaultConstructorMarker) null);
            this.country = str;
        }

        public Type getType() {
            return Type.Sofort;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$Upi;", "Lcom/stripe/android/model/PaymentMethod$TypeData;", "vpa", "", "(Ljava/lang/String;)V", "type", "Lcom/stripe/android/model/PaymentMethod$Type;", "getType", "()Lcom/stripe/android/model/PaymentMethod$Type;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethod.kt */
    public static final class Upi extends TypeData {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Upi> CREATOR = new Creator();
        public final String vpa;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<Upi> {
            public final Upi createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Upi(parcel.readString());
            }

            public final Upi[] newArray(int i) {
                return new Upi[i];
            }
        }

        public static /* synthetic */ Upi copy$default(Upi upi, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = upi.vpa;
            }
            return upi.copy(str);
        }

        public final String component1() {
            return this.vpa;
        }

        public final Upi copy(String str) {
            return new Upi(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Upi) && Intrinsics.areEqual((Object) this.vpa, (Object) ((Upi) obj).vpa);
        }

        public int hashCode() {
            String str = this.vpa;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Upi(vpa=" + this.vpa + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.vpa);
        }

        public Upi(String str) {
            super((DefaultConstructorMarker) null);
            this.vpa = str;
        }

        public Type getType() {
            return Type.Upi;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\fHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fHÖ\u0001R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$Netbanking;", "Lcom/stripe/android/model/PaymentMethod$TypeData;", "bank", "", "(Ljava/lang/String;)V", "type", "Lcom/stripe/android/model/PaymentMethod$Type;", "getType", "()Lcom/stripe/android/model/PaymentMethod$Type;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethod.kt */
    public static final class Netbanking extends TypeData {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Netbanking> CREATOR = new Creator();
        public final String bank;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<Netbanking> {
            public final Netbanking createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Netbanking(parcel.readString());
            }

            public final Netbanking[] newArray(int i) {
                return new Netbanking[i];
            }
        }

        public static /* synthetic */ Netbanking copy$default(Netbanking netbanking, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = netbanking.bank;
            }
            return netbanking.copy(str);
        }

        public final String component1() {
            return this.bank;
        }

        public final Netbanking copy(String str) {
            return new Netbanking(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Netbanking) && Intrinsics.areEqual((Object) this.bank, (Object) ((Netbanking) obj).bank);
        }

        public int hashCode() {
            String str = this.bank;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "Netbanking(bank=" + this.bank + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.bank);
        }

        public Netbanking(String str) {
            super((DefaultConstructorMarker) null);
            this.bank = str;
        }

        public Type getType() {
            return Type.Netbanking;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001:\u0003)*+BS\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000eJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003Je\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001dHÖ\u0001J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001dHÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006,"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$USBankAccount;", "Lcom/stripe/android/model/PaymentMethod$TypeData;", "accountHolderType", "Lcom/stripe/android/model/PaymentMethod$USBankAccount$USBankAccountHolderType;", "accountType", "Lcom/stripe/android/model/PaymentMethod$USBankAccount$USBankAccountType;", "bankName", "", "fingerprint", "last4", "linkedAccount", "networks", "Lcom/stripe/android/model/PaymentMethod$USBankAccount$USBankNetworks;", "routingNumber", "(Lcom/stripe/android/model/PaymentMethod$USBankAccount$USBankAccountHolderType;Lcom/stripe/android/model/PaymentMethod$USBankAccount$USBankAccountType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/PaymentMethod$USBankAccount$USBankNetworks;Ljava/lang/String;)V", "type", "Lcom/stripe/android/model/PaymentMethod$Type;", "getType", "()Lcom/stripe/android/model/PaymentMethod$Type;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "USBankAccountHolderType", "USBankAccountType", "USBankNetworks", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethod.kt */
    public static final class USBankAccount extends TypeData {
        public static final int $stable = 8;
        public static final Parcelable.Creator<USBankAccount> CREATOR = new Creator();
        public final USBankAccountHolderType accountHolderType;
        public final USBankAccountType accountType;
        public final String bankName;
        public final String fingerprint;
        public final String last4;
        public final String linkedAccount;
        public final USBankNetworks networks;
        public final String routingNumber;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethod.kt */
        public static final class Creator implements Parcelable.Creator<USBankAccount> {
            public final USBankAccount createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new USBankAccount(USBankAccountHolderType.CREATOR.createFromParcel(parcel), USBankAccountType.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : USBankNetworks.CREATOR.createFromParcel(parcel), parcel.readString());
            }

            public final USBankAccount[] newArray(int i) {
                return new USBankAccount[i];
            }
        }

        public static /* synthetic */ USBankAccount copy$default(USBankAccount uSBankAccount, USBankAccountHolderType uSBankAccountHolderType, USBankAccountType uSBankAccountType, String str, String str2, String str3, String str4, USBankNetworks uSBankNetworks, String str5, int i, Object obj) {
            USBankAccount uSBankAccount2 = uSBankAccount;
            int i2 = i;
            return uSBankAccount.copy((i2 & 1) != 0 ? uSBankAccount2.accountHolderType : uSBankAccountHolderType, (i2 & 2) != 0 ? uSBankAccount2.accountType : uSBankAccountType, (i2 & 4) != 0 ? uSBankAccount2.bankName : str, (i2 & 8) != 0 ? uSBankAccount2.fingerprint : str2, (i2 & 16) != 0 ? uSBankAccount2.last4 : str3, (i2 & 32) != 0 ? uSBankAccount2.linkedAccount : str4, (i2 & 64) != 0 ? uSBankAccount2.networks : uSBankNetworks, (i2 & 128) != 0 ? uSBankAccount2.routingNumber : str5);
        }

        public final USBankAccountHolderType component1() {
            return this.accountHolderType;
        }

        public final USBankAccountType component2() {
            return this.accountType;
        }

        public final String component3() {
            return this.bankName;
        }

        public final String component4() {
            return this.fingerprint;
        }

        public final String component5() {
            return this.last4;
        }

        public final String component6() {
            return this.linkedAccount;
        }

        public final USBankNetworks component7() {
            return this.networks;
        }

        public final String component8() {
            return this.routingNumber;
        }

        public final USBankAccount copy(USBankAccountHolderType uSBankAccountHolderType, USBankAccountType uSBankAccountType, String str, String str2, String str3, String str4, USBankNetworks uSBankNetworks, String str5) {
            Intrinsics.checkNotNullParameter(uSBankAccountHolderType, "accountHolderType");
            Intrinsics.checkNotNullParameter(uSBankAccountType, "accountType");
            return new USBankAccount(uSBankAccountHolderType, uSBankAccountType, str, str2, str3, str4, uSBankNetworks, str5);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof USBankAccount)) {
                return false;
            }
            USBankAccount uSBankAccount = (USBankAccount) obj;
            return this.accountHolderType == uSBankAccount.accountHolderType && this.accountType == uSBankAccount.accountType && Intrinsics.areEqual((Object) this.bankName, (Object) uSBankAccount.bankName) && Intrinsics.areEqual((Object) this.fingerprint, (Object) uSBankAccount.fingerprint) && Intrinsics.areEqual((Object) this.last4, (Object) uSBankAccount.last4) && Intrinsics.areEqual((Object) this.linkedAccount, (Object) uSBankAccount.linkedAccount) && Intrinsics.areEqual((Object) this.networks, (Object) uSBankAccount.networks) && Intrinsics.areEqual((Object) this.routingNumber, (Object) uSBankAccount.routingNumber);
        }

        public int hashCode() {
            int hashCode = ((this.accountHolderType.hashCode() * 31) + this.accountType.hashCode()) * 31;
            String str = this.bankName;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.fingerprint;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.last4;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.linkedAccount;
            int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            USBankNetworks uSBankNetworks = this.networks;
            int hashCode6 = (hashCode5 + (uSBankNetworks == null ? 0 : uSBankNetworks.hashCode())) * 31;
            String str5 = this.routingNumber;
            if (str5 != null) {
                i = str5.hashCode();
            }
            return hashCode6 + i;
        }

        public String toString() {
            return "USBankAccount(accountHolderType=" + this.accountHolderType + ", accountType=" + this.accountType + ", bankName=" + this.bankName + ", fingerprint=" + this.fingerprint + ", last4=" + this.last4 + ", linkedAccount=" + this.linkedAccount + ", networks=" + this.networks + ", routingNumber=" + this.routingNumber + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            this.accountHolderType.writeToParcel(parcel, i);
            this.accountType.writeToParcel(parcel, i);
            parcel.writeString(this.bankName);
            parcel.writeString(this.fingerprint);
            parcel.writeString(this.last4);
            parcel.writeString(this.linkedAccount);
            USBankNetworks uSBankNetworks = this.networks;
            if (uSBankNetworks == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                uSBankNetworks.writeToParcel(parcel, i);
            }
            parcel.writeString(this.routingNumber);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public USBankAccount(USBankAccountHolderType uSBankAccountHolderType, USBankAccountType uSBankAccountType, String str, String str2, String str3, String str4, USBankNetworks uSBankNetworks, String str5) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(uSBankAccountHolderType, "accountHolderType");
            Intrinsics.checkNotNullParameter(uSBankAccountType, "accountType");
            this.accountHolderType = uSBankAccountHolderType;
            this.accountType = uSBankAccountType;
            this.bankName = str;
            this.fingerprint = str2;
            this.last4 = str3;
            this.linkedAccount = str4;
            this.networks = uSBankNetworks;
            this.routingNumber = str5;
        }

        public Type getType() {
            return Type.USBankAccount;
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tHÖ\u0001J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$USBankAccount$USBankAccountHolderType;", "", "Lcom/stripe/android/core/model/StripeModel;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "UNKNOWN", "INDIVIDUAL", "COMPANY", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethod.kt */
        public enum USBankAccountHolderType implements StripeModel {
            UNKNOWN("unknown"),
            INDIVIDUAL("individual"),
            COMPANY("company");
            
            public static final Parcelable.Creator<USBankAccountHolderType> CREATOR = null;
            private final String value;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentMethod.kt */
            public static final class Creator implements Parcelable.Creator<USBankAccountHolderType> {
                public final USBankAccountHolderType createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return USBankAccountHolderType.valueOf(parcel.readString());
                }

                public final USBankAccountHolderType[] newArray(int i) {
                    return new USBankAccountHolderType[i];
                }
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(name());
            }

            private USBankAccountHolderType(String str) {
                this.value = str;
            }

            public final String getValue() {
                return this.value;
            }

            static {
                CREATOR = new Creator();
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tHÖ\u0001J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$USBankAccount$USBankAccountType;", "", "Lcom/stripe/android/core/model/StripeModel;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "UNKNOWN", "CHECKING", "SAVINGS", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethod.kt */
        public enum USBankAccountType implements StripeModel {
            UNKNOWN("unknown"),
            CHECKING("checking"),
            SAVINGS("savings");
            
            public static final Parcelable.Creator<USBankAccountType> CREATOR = null;
            private final String value;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentMethod.kt */
            public static final class Creator implements Parcelable.Creator<USBankAccountType> {
                public final USBankAccountType createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return USBankAccountType.valueOf(parcel.readString());
                }

                public final USBankAccountType[] newArray(int i) {
                    return new USBankAccountType[i];
                }
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(name());
            }

            private USBankAccountType(String str) {
                this.value = str;
            }

            public final String getValue() {
                return this.value;
            }

            static {
                CREATOR = new Creator();
            }
        }

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J%\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$USBankAccount$USBankNetworks;", "Lcom/stripe/android/core/model/StripeModel;", "preferred", "", "supported", "", "(Ljava/lang/String;Ljava/util/List;)V", "getPreferred", "()Ljava/lang/String;", "getSupported", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethod.kt */
        public static final class USBankNetworks implements StripeModel {
            public static final int $stable = 8;
            public static final Parcelable.Creator<USBankNetworks> CREATOR = new Creator();
            private final String preferred;
            private final List<String> supported;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* compiled from: PaymentMethod.kt */
            public static final class Creator implements Parcelable.Creator<USBankNetworks> {
                public final USBankNetworks createFromParcel(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "parcel");
                    return new USBankNetworks(parcel.readString(), parcel.createStringArrayList());
                }

                public final USBankNetworks[] newArray(int i) {
                    return new USBankNetworks[i];
                }
            }

            public static /* synthetic */ USBankNetworks copy$default(USBankNetworks uSBankNetworks, String str, List<String> list, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = uSBankNetworks.preferred;
                }
                if ((i & 2) != 0) {
                    list = uSBankNetworks.supported;
                }
                return uSBankNetworks.copy(str, list);
            }

            public final String component1() {
                return this.preferred;
            }

            public final List<String> component2() {
                return this.supported;
            }

            public final USBankNetworks copy(String str, List<String> list) {
                Intrinsics.checkNotNullParameter(list, "supported");
                return new USBankNetworks(str, list);
            }

            public int describeContents() {
                return 0;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof USBankNetworks)) {
                    return false;
                }
                USBankNetworks uSBankNetworks = (USBankNetworks) obj;
                return Intrinsics.areEqual((Object) this.preferred, (Object) uSBankNetworks.preferred) && Intrinsics.areEqual((Object) this.supported, (Object) uSBankNetworks.supported);
            }

            public int hashCode() {
                String str = this.preferred;
                return ((str == null ? 0 : str.hashCode()) * 31) + this.supported.hashCode();
            }

            public String toString() {
                return "USBankNetworks(preferred=" + this.preferred + ", supported=" + this.supported + ')';
            }

            public void writeToParcel(Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "out");
                parcel.writeString(this.preferred);
                parcel.writeStringList(this.supported);
            }

            public USBankNetworks(String str, List<String> list) {
                Intrinsics.checkNotNullParameter(list, "supported");
                this.preferred = str;
                this.supported = list;
            }

            public final String getPreferred() {
                return this.preferred;
            }

            public final List<String> getSupported() {
                return this.supported;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/PaymentMethod$Companion;", "", "()V", "fromJson", "Lcom/stripe/android/model/PaymentMethod;", "paymentMethod", "Lorg/json/JSONObject;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethod.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PaymentMethod fromJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new PaymentMethodJsonParser().parse(jSONObject);
        }
    }
}
