package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.PaymentMethod;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u00012\u00020\u0002:\u0004\u0010\u0011\u0012\u0013B\u000f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J!\u0010\b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n0\tH ¢\u0006\u0002\b\rJ\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u000fH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0004\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/model/PaymentMethodOptionsParams;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "type", "Lcom/stripe/android/model/PaymentMethod$Type;", "(Lcom/stripe/android/model/PaymentMethod$Type;)V", "getType", "()Lcom/stripe/android/model/PaymentMethod$Type;", "createTypeParams", "", "Lkotlin/Pair;", "", "", "createTypeParams$payments_core_release", "toParamMap", "", "Blik", "Card", "USBankAccount", "WeChatPay", "Lcom/stripe/android/model/PaymentMethodOptionsParams$Card;", "Lcom/stripe/android/model/PaymentMethodOptionsParams$Blik;", "Lcom/stripe/android/model/PaymentMethodOptionsParams$WeChatPay;", "Lcom/stripe/android/model/PaymentMethodOptionsParams$USBankAccount;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodOptionsParams.kt */
public abstract class PaymentMethodOptionsParams implements StripeParamsModel, Parcelable {
    public static final int $stable = 0;
    private final PaymentMethod.Type type;

    public /* synthetic */ PaymentMethodOptionsParams(PaymentMethod.Type type2, DefaultConstructorMarker defaultConstructorMarker) {
        this(type2);
    }

    public abstract List<Pair<String, Object>> createTypeParams$payments_core_release();

    private PaymentMethodOptionsParams(PaymentMethod.Type type2) {
        this.type = type2;
    }

    public final PaymentMethod.Type getType() {
        return this.type;
    }

    public Map<String, Object> toParamMap() {
        Map map;
        Map emptyMap = MapsKt.emptyMap();
        for (Pair pair : createTypeParams$payments_core_release()) {
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
            emptyMap = MapsKt.plus(emptyMap, map);
        }
        if (!emptyMap.isEmpty()) {
            return MapsKt.mapOf(TuplesKt.to(this.type.code, emptyMap));
        }
        return MapsKt.emptyMap();
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 12\u00020\u0001:\u00011B+\b\u0016\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B7\b\u0000\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\tHÀ\u0003¢\u0006\u0004\b\u001e\u0010\u0010J>\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010 J!\u0010!\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010$0#0\"H\u0010¢\u0006\u0002\b%J\t\u0010&\u001a\u00020'HÖ\u0001J\u0013\u0010(\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010*\u001a\u00020'HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020'HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u00062"}, d2 = {"Lcom/stripe/android/model/PaymentMethodOptionsParams$Card;", "Lcom/stripe/android/model/PaymentMethodOptionsParams;", "cvc", "", "network", "setupFutureUsage", "Lcom/stripe/android/model/ConfirmPaymentIntentParams$SetupFutureUsage;", "(Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/ConfirmPaymentIntentParams$SetupFutureUsage;)V", "moto", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/ConfirmPaymentIntentParams$SetupFutureUsage;Ljava/lang/Boolean;)V", "getCvc", "()Ljava/lang/String;", "setCvc", "(Ljava/lang/String;)V", "getMoto$payments_core_release", "()Ljava/lang/Boolean;", "setMoto$payments_core_release", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getNetwork", "setNetwork", "getSetupFutureUsage", "()Lcom/stripe/android/model/ConfirmPaymentIntentParams$SetupFutureUsage;", "setSetupFutureUsage", "(Lcom/stripe/android/model/ConfirmPaymentIntentParams$SetupFutureUsage;)V", "component1", "component2", "component3", "component4", "component4$payments_core_release", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/ConfirmPaymentIntentParams$SetupFutureUsage;Ljava/lang/Boolean;)Lcom/stripe/android/model/PaymentMethodOptionsParams$Card;", "createTypeParams", "", "Lkotlin/Pair;", "", "createTypeParams$payments_core_release", "describeContents", "", "equals", "other", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodOptionsParams.kt */
    public static final class Card extends PaymentMethodOptionsParams {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Card> CREATOR = new Creator();
        private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @Deprecated
        private static final String PARAM_CVC = "cvc";
        @Deprecated
        private static final String PARAM_MOTO = "moto";
        @Deprecated
        private static final String PARAM_NETWORK = "network";
        @Deprecated
        private static final String PARAM_SETUP_FUTURE_USAGE = "setup_future_usage";
        private String cvc;
        private Boolean moto;
        private String network;
        private ConfirmPaymentIntentParams.SetupFutureUsage setupFutureUsage;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodOptionsParams.kt */
        public static final class Creator implements Parcelable.Creator<Card> {
            public final Card createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                Boolean bool = null;
                ConfirmPaymentIntentParams.SetupFutureUsage valueOf = parcel.readInt() == 0 ? null : ConfirmPaymentIntentParams.SetupFutureUsage.valueOf(parcel.readString());
                if (parcel.readInt() != 0) {
                    bool = Boolean.valueOf(parcel.readInt() != 0);
                }
                return new Card(readString, readString2, valueOf, bool);
            }

            public final Card[] newArray(int i) {
                return new Card[i];
            }
        }

        public Card() {
            this((String) null, (String) null, (ConfirmPaymentIntentParams.SetupFutureUsage) null, (Boolean) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Card copy$default(Card card, String str, String str2, ConfirmPaymentIntentParams.SetupFutureUsage setupFutureUsage2, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                str = card.cvc;
            }
            if ((i & 2) != 0) {
                str2 = card.network;
            }
            if ((i & 4) != 0) {
                setupFutureUsage2 = card.setupFutureUsage;
            }
            if ((i & 8) != 0) {
                bool = card.moto;
            }
            return card.copy(str, str2, setupFutureUsage2, bool);
        }

        public final String component1() {
            return this.cvc;
        }

        public final String component2() {
            return this.network;
        }

        public final ConfirmPaymentIntentParams.SetupFutureUsage component3() {
            return this.setupFutureUsage;
        }

        public final Boolean component4$payments_core_release() {
            return this.moto;
        }

        public final Card copy(String str, String str2, ConfirmPaymentIntentParams.SetupFutureUsage setupFutureUsage2, Boolean bool) {
            return new Card(str, str2, setupFutureUsage2, bool);
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
            return Intrinsics.areEqual((Object) this.cvc, (Object) card.cvc) && Intrinsics.areEqual((Object) this.network, (Object) card.network) && this.setupFutureUsage == card.setupFutureUsage && Intrinsics.areEqual((Object) this.moto, (Object) card.moto);
        }

        public int hashCode() {
            String str = this.cvc;
            int i = 0;
            int hashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.network;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            ConfirmPaymentIntentParams.SetupFutureUsage setupFutureUsage2 = this.setupFutureUsage;
            int hashCode3 = (hashCode2 + (setupFutureUsage2 == null ? 0 : setupFutureUsage2.hashCode())) * 31;
            Boolean bool = this.moto;
            if (bool != null) {
                i = bool.hashCode();
            }
            return hashCode3 + i;
        }

        public String toString() {
            return "Card(cvc=" + this.cvc + ", network=" + this.network + ", setupFutureUsage=" + this.setupFutureUsage + ", moto=" + this.moto + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.cvc);
            parcel.writeString(this.network);
            ConfirmPaymentIntentParams.SetupFutureUsage setupFutureUsage2 = this.setupFutureUsage;
            if (setupFutureUsage2 == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                parcel.writeString(setupFutureUsage2.name());
            }
            Boolean bool = this.moto;
            if (bool == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Card(String str, String str2, ConfirmPaymentIntentParams.SetupFutureUsage setupFutureUsage2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : setupFutureUsage2, (i & 8) != 0 ? null : bool);
        }

        public final String getCvc() {
            return this.cvc;
        }

        public final void setCvc(String str) {
            this.cvc = str;
        }

        public final String getNetwork() {
            return this.network;
        }

        public final void setNetwork(String str) {
            this.network = str;
        }

        public final ConfirmPaymentIntentParams.SetupFutureUsage getSetupFutureUsage() {
            return this.setupFutureUsage;
        }

        public final void setSetupFutureUsage(ConfirmPaymentIntentParams.SetupFutureUsage setupFutureUsage2) {
            this.setupFutureUsage = setupFutureUsage2;
        }

        public final Boolean getMoto$payments_core_release() {
            return this.moto;
        }

        public final void setMoto$payments_core_release(Boolean bool) {
            this.moto = bool;
        }

        public Card(String str, String str2, ConfirmPaymentIntentParams.SetupFutureUsage setupFutureUsage2, Boolean bool) {
            super(PaymentMethod.Type.Card, (DefaultConstructorMarker) null);
            this.cvc = str;
            this.network = str2;
            this.setupFutureUsage = setupFutureUsage2;
            this.moto = bool;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Card(String str, String str2, ConfirmPaymentIntentParams.SetupFutureUsage setupFutureUsage2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : setupFutureUsage2);
        }

        public Card(String str, String str2, ConfirmPaymentIntentParams.SetupFutureUsage setupFutureUsage2) {
            this(str, str2, setupFutureUsage2, (Boolean) null);
        }

        public List<Pair<String, Object>> createTypeParams$payments_core_release() {
            Pair[] pairArr = new Pair[4];
            pairArr[0] = TuplesKt.to(PARAM_CVC, this.cvc);
            pairArr[1] = TuplesKt.to(PARAM_NETWORK, this.network);
            pairArr[2] = TuplesKt.to(PARAM_MOTO, this.moto);
            ConfirmPaymentIntentParams.SetupFutureUsage setupFutureUsage2 = this.setupFutureUsage;
            pairArr[3] = TuplesKt.to("setup_future_usage", setupFutureUsage2 == null ? null : setupFutureUsage2.getCode$payments_core_release());
            return CollectionsKt.listOf(pairArr);
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stripe/android/model/PaymentMethodOptionsParams$Card$Companion;", "", "()V", "PARAM_CVC", "", "PARAM_MOTO", "PARAM_NETWORK", "PARAM_SETUP_FUTURE_USAGE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodOptionsParams.kt */
        private static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J!\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\f0\u000bH\u0010¢\u0006\u0002\b\u000eJ\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u0014\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/model/PaymentMethodOptionsParams$Blik;", "Lcom/stripe/android/model/PaymentMethodOptionsParams;", "code", "", "(Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "setCode", "component1", "copy", "createTypeParams", "", "Lkotlin/Pair;", "", "createTypeParams$payments_core_release", "describeContents", "", "equals", "", "other", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodOptionsParams.kt */
    public static final class Blik extends PaymentMethodOptionsParams {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Blik> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String PARAM_CODE = "code";
        private String code;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodOptionsParams.kt */
        public static final class Creator implements Parcelable.Creator<Blik> {
            public final Blik createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Blik(parcel.readString());
            }

            public final Blik[] newArray(int i) {
                return new Blik[i];
            }
        }

        public static /* synthetic */ Blik copy$default(Blik blik, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = blik.code;
            }
            return blik.copy(str);
        }

        public final String component1() {
            return this.code;
        }

        public final Blik copy(String str) {
            Intrinsics.checkNotNullParameter(str, PARAM_CODE);
            return new Blik(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Blik) && Intrinsics.areEqual((Object) this.code, (Object) ((Blik) obj).code);
        }

        public int hashCode() {
            return this.code.hashCode();
        }

        public String toString() {
            return "Blik(code=" + this.code + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.code);
        }

        public final String getCode() {
            return this.code;
        }

        public final void setCode(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.code = str;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Blik(String str) {
            super(PaymentMethod.Type.Blik, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, PARAM_CODE);
            this.code = str;
        }

        public List<Pair<String, Object>> createTypeParams$payments_core_release() {
            return CollectionsKt.listOf(TuplesKt.to(PARAM_CODE, this.code));
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/model/PaymentMethodOptionsParams$Blik$Companion;", "", "()V", "PARAM_CODE", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodOptionsParams.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J!\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\r0\f0\u000bH\u0010¢\u0006\u0002\b\u000eJ\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u0014\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/stripe/android/model/PaymentMethodOptionsParams$WeChatPay;", "Lcom/stripe/android/model/PaymentMethodOptionsParams;", "appId", "", "(Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "setAppId", "component1", "copy", "createTypeParams", "", "Lkotlin/Pair;", "", "createTypeParams$payments_core_release", "describeContents", "", "equals", "", "other", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodOptionsParams.kt */
    public static final class WeChatPay extends PaymentMethodOptionsParams {
        public static final int $stable = 8;
        public static final Parcelable.Creator<WeChatPay> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String PARAM_APP_ID = "app_id";
        public static final String PARAM_CLIENT = "client";
        private String appId;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodOptionsParams.kt */
        public static final class Creator implements Parcelable.Creator<WeChatPay> {
            public final WeChatPay createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new WeChatPay(parcel.readString());
            }

            public final WeChatPay[] newArray(int i) {
                return new WeChatPay[i];
            }
        }

        public static /* synthetic */ WeChatPay copy$default(WeChatPay weChatPay, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = weChatPay.appId;
            }
            return weChatPay.copy(str);
        }

        public final String component1() {
            return this.appId;
        }

        public final WeChatPay copy(String str) {
            Intrinsics.checkNotNullParameter(str, "appId");
            return new WeChatPay(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WeChatPay) && Intrinsics.areEqual((Object) this.appId, (Object) ((WeChatPay) obj).appId);
        }

        public int hashCode() {
            return this.appId.hashCode();
        }

        public String toString() {
            return "WeChatPay(appId=" + this.appId + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.appId);
        }

        public final String getAppId() {
            return this.appId;
        }

        public final void setAppId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.appId = str;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WeChatPay(String str) {
            super(PaymentMethod.Type.WeChatPay, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "appId");
            this.appId = str;
        }

        public List<Pair<String, Object>> createTypeParams$payments_core_release() {
            return CollectionsKt.listOf(TuplesKt.to(PARAM_CLIENT, "android"), TuplesKt.to(PARAM_APP_ID, this.appId));
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/model/PaymentMethodOptionsParams$WeChatPay$Companion;", "", "()V", "PARAM_APP_ID", "", "PARAM_CLIENT", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodOptionsParams.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J!\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f0\u000bH\u0010¢\u0006\u0002\b\u000fJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u0015\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0016\u001a\u00020\rHÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/stripe/android/model/PaymentMethodOptionsParams$USBankAccount;", "Lcom/stripe/android/model/PaymentMethodOptionsParams;", "setupFutureUsage", "Lcom/stripe/android/model/ConfirmPaymentIntentParams$SetupFutureUsage;", "(Lcom/stripe/android/model/ConfirmPaymentIntentParams$SetupFutureUsage;)V", "getSetupFutureUsage", "()Lcom/stripe/android/model/ConfirmPaymentIntentParams$SetupFutureUsage;", "setSetupFutureUsage", "component1", "copy", "createTypeParams", "", "Lkotlin/Pair;", "", "", "createTypeParams$payments_core_release", "describeContents", "", "equals", "", "other", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodOptionsParams.kt */
    public static final class USBankAccount extends PaymentMethodOptionsParams {
        public static final int $stable = 8;
        public static final Parcelable.Creator<USBankAccount> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String PARAM_SETUP_FUTURE_USAGE = "setup_future_usage";
        private ConfirmPaymentIntentParams.SetupFutureUsage setupFutureUsage;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodOptionsParams.kt */
        public static final class Creator implements Parcelable.Creator<USBankAccount> {
            public final USBankAccount createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new USBankAccount(parcel.readInt() == 0 ? null : ConfirmPaymentIntentParams.SetupFutureUsage.valueOf(parcel.readString()));
            }

            public final USBankAccount[] newArray(int i) {
                return new USBankAccount[i];
            }
        }

        public USBankAccount() {
            this((ConfirmPaymentIntentParams.SetupFutureUsage) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ USBankAccount copy$default(USBankAccount uSBankAccount, ConfirmPaymentIntentParams.SetupFutureUsage setupFutureUsage2, int i, Object obj) {
            if ((i & 1) != 0) {
                setupFutureUsage2 = uSBankAccount.setupFutureUsage;
            }
            return uSBankAccount.copy(setupFutureUsage2);
        }

        public final ConfirmPaymentIntentParams.SetupFutureUsage component1() {
            return this.setupFutureUsage;
        }

        public final USBankAccount copy(ConfirmPaymentIntentParams.SetupFutureUsage setupFutureUsage2) {
            return new USBankAccount(setupFutureUsage2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof USBankAccount) && this.setupFutureUsage == ((USBankAccount) obj).setupFutureUsage;
        }

        public int hashCode() {
            ConfirmPaymentIntentParams.SetupFutureUsage setupFutureUsage2 = this.setupFutureUsage;
            if (setupFutureUsage2 == null) {
                return 0;
            }
            return setupFutureUsage2.hashCode();
        }

        public String toString() {
            return "USBankAccount(setupFutureUsage=" + this.setupFutureUsage + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            ConfirmPaymentIntentParams.SetupFutureUsage setupFutureUsage2 = this.setupFutureUsage;
            if (setupFutureUsage2 == null) {
                parcel.writeInt(0);
                return;
            }
            parcel.writeInt(1);
            parcel.writeString(setupFutureUsage2.name());
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ USBankAccount(ConfirmPaymentIntentParams.SetupFutureUsage setupFutureUsage2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : setupFutureUsage2);
        }

        public final ConfirmPaymentIntentParams.SetupFutureUsage getSetupFutureUsage() {
            return this.setupFutureUsage;
        }

        public final void setSetupFutureUsage(ConfirmPaymentIntentParams.SetupFutureUsage setupFutureUsage2) {
            this.setupFutureUsage = setupFutureUsage2;
        }

        public USBankAccount(ConfirmPaymentIntentParams.SetupFutureUsage setupFutureUsage2) {
            super(PaymentMethod.Type.USBankAccount, (DefaultConstructorMarker) null);
            this.setupFutureUsage = setupFutureUsage2;
        }

        public List<Pair<String, Object>> createTypeParams$payments_core_release() {
            ConfirmPaymentIntentParams.SetupFutureUsage setupFutureUsage2 = this.setupFutureUsage;
            return CollectionsKt.listOf(TuplesKt.to(PARAM_SETUP_FUTURE_USAGE, setupFutureUsage2 == null ? null : setupFutureUsage2.getCode$payments_core_release()));
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/model/PaymentMethodOptionsParams$USBankAccount$Companion;", "", "()V", "PARAM_SETUP_FUTURE_USAGE", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentMethodOptionsParams.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}
