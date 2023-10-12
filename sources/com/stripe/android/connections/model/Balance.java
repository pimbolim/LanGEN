package com.stripe.android.connections.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.paypal.android.sdk.onetouch.core.PayPalLineItem;
import com.stripe.android.core.model.StripeModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0003;<=B_\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\u0016\b\u0001\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011BC\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0012J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\u0015\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007HÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000eHÆ\u0003JK\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\t\u0010)\u001a\u00020\u0004HÖ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-HÖ\u0003J\t\u0010.\u001a\u00020\u0004HÖ\u0001J\t\u0010/\u001a\u00020\bHÖ\u0001J!\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206HÇ\u0001J\u0019\u00107\u001a\u0002012\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u001cR(\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00078\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\t\u001a\u00020\n8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u0014\u001a\u0004\b!\u0010\"¨\u0006>"}, d2 = {"Lcom/stripe/android/connections/model/Balance;", "Lcom/stripe/android/core/model/StripeModel;", "Landroid/os/Parcelable;", "seen1", "", "asOf", "current", "", "", "type", "Lcom/stripe/android/connections/model/Balance$Type;", "cash", "Lcom/stripe/android/connections/model/CashBalance;", "credit", "Lcom/stripe/android/connections/model/CreditBalance;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/util/Map;Lcom/stripe/android/connections/model/Balance$Type;Lcom/stripe/android/connections/model/CashBalance;Lcom/stripe/android/connections/model/CreditBalance;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ILjava/util/Map;Lcom/stripe/android/connections/model/Balance$Type;Lcom/stripe/android/connections/model/CashBalance;Lcom/stripe/android/connections/model/CreditBalance;)V", "getAsOf$annotations", "()V", "getAsOf", "()I", "getCash$annotations", "getCash", "()Lcom/stripe/android/connections/model/CashBalance;", "getCredit$annotations", "getCredit", "()Lcom/stripe/android/connections/model/CreditBalance;", "getCurrent$annotations", "getCurrent", "()Ljava/util/Map;", "getType$annotations", "getType", "()Lcom/stripe/android/connections/model/Balance$Type;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "$serializer", "Companion", "Type", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
/* compiled from: Balance.kt */
public final class Balance implements StripeModel, Parcelable {
    public static final Parcelable.Creator<Balance> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int asOf;
    private final CashBalance cash;
    private final CreditBalance credit;
    private final Map<String, Integer> current;
    private final Type type;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Balance.kt */
    public static final class Creator implements Parcelable.Creator<Balance> {
        public final Balance createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt2);
            for (int i = 0; i != readInt2; i++) {
                linkedHashMap.put(parcel.readString(), Integer.valueOf(parcel.readInt()));
            }
            Map map = linkedHashMap;
            Type valueOf = Type.valueOf(parcel.readString());
            CreditBalance creditBalance = null;
            CashBalance createFromParcel = parcel.readInt() == 0 ? null : CashBalance.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                creditBalance = CreditBalance.CREATOR.createFromParcel(parcel);
            }
            return new Balance(readInt, map, valueOf, createFromParcel, creditBalance);
        }

        public final Balance[] newArray(int i) {
            return new Balance[i];
        }
    }

    public static /* synthetic */ Balance copy$default(Balance balance, int i, Map<String, Integer> map, Type type2, CashBalance cashBalance, CreditBalance creditBalance, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = balance.asOf;
        }
        if ((i2 & 2) != 0) {
            map = balance.current;
        }
        Map<String, Integer> map2 = map;
        if ((i2 & 4) != 0) {
            type2 = balance.type;
        }
        Type type3 = type2;
        if ((i2 & 8) != 0) {
            cashBalance = balance.cash;
        }
        CashBalance cashBalance2 = cashBalance;
        if ((i2 & 16) != 0) {
            creditBalance = balance.credit;
        }
        return balance.copy(i, map2, type3, cashBalance2, creditBalance);
    }

    @SerialName("as_of")
    public static /* synthetic */ void getAsOf$annotations() {
    }

    @SerialName("cash")
    public static /* synthetic */ void getCash$annotations() {
    }

    @SerialName("credit")
    public static /* synthetic */ void getCredit$annotations() {
    }

    @SerialName("current")
    public static /* synthetic */ void getCurrent$annotations() {
    }

    @SerialName("type")
    public static /* synthetic */ void getType$annotations() {
    }

    public final int component1() {
        return this.asOf;
    }

    public final Map<String, Integer> component2() {
        return this.current;
    }

    public final Type component3() {
        return this.type;
    }

    public final CashBalance component4() {
        return this.cash;
    }

    public final CreditBalance component5() {
        return this.credit;
    }

    public final Balance copy(int i, Map<String, Integer> map, Type type2, CashBalance cashBalance, CreditBalance creditBalance) {
        Intrinsics.checkNotNullParameter(map, "current");
        Intrinsics.checkNotNullParameter(type2, "type");
        return new Balance(i, map, type2, cashBalance, creditBalance);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Balance)) {
            return false;
        }
        Balance balance = (Balance) obj;
        return this.asOf == balance.asOf && Intrinsics.areEqual((Object) this.current, (Object) balance.current) && this.type == balance.type && Intrinsics.areEqual((Object) this.cash, (Object) balance.cash) && Intrinsics.areEqual((Object) this.credit, (Object) balance.credit);
    }

    public int hashCode() {
        int hashCode = ((((this.asOf * 31) + this.current.hashCode()) * 31) + this.type.hashCode()) * 31;
        CashBalance cashBalance = this.cash;
        int i = 0;
        int hashCode2 = (hashCode + (cashBalance == null ? 0 : cashBalance.hashCode())) * 31;
        CreditBalance creditBalance = this.credit;
        if (creditBalance != null) {
            i = creditBalance.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "Balance(asOf=" + this.asOf + ", current=" + this.current + ", type=" + this.type + ", cash=" + this.cash + ", credit=" + this.credit + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.asOf);
        Map<String, Integer> map = this.current;
        parcel.writeInt(map.size());
        for (Map.Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeInt(((Number) next.getValue()).intValue());
        }
        parcel.writeString(this.type.name());
        CashBalance cashBalance = this.cash;
        if (cashBalance == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            cashBalance.writeToParcel(parcel, i);
        }
        CreditBalance creditBalance = this.credit;
        if (creditBalance == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        creditBalance.writeToParcel(parcel, i);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/connections/model/Balance$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stripe/android/connections/model/Balance;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Balance.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<Balance> serializer() {
            return Balance$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ Balance(int i, @SerialName("as_of") int i2, @SerialName("current") Map map, @SerialName("type") Type type2, @SerialName("cash") CashBalance cashBalance, @SerialName("credit") CreditBalance creditBalance, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, Balance$$serializer.INSTANCE.getDescriptor());
        }
        this.asOf = i2;
        this.current = map;
        if ((i & 4) == 0) {
            this.type = Type.UNKNOWN;
        } else {
            this.type = type2;
        }
        if ((i & 8) == 0) {
            this.cash = null;
        } else {
            this.cash = cashBalance;
        }
        if ((i & 16) == 0) {
            this.credit = null;
        } else {
            this.credit = creditBalance;
        }
    }

    public Balance(int i, Map<String, Integer> map, Type type2, CashBalance cashBalance, CreditBalance creditBalance) {
        Intrinsics.checkNotNullParameter(map, "current");
        Intrinsics.checkNotNullParameter(type2, "type");
        this.asOf = i;
        this.current = map;
        this.type = type2;
        this.cash = cashBalance;
        this.credit = creditBalance;
    }

    @JvmStatic
    public static final void write$Self(Balance balance, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        boolean z;
        Intrinsics.checkNotNullParameter(balance, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        boolean z2 = false;
        compositeEncoder.encodeIntElement(serialDescriptor, 0, balance.asOf);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 1, new LinkedHashMapSerializer(StringSerializer.INSTANCE, IntSerializer.INSTANCE), balance.current);
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) && balance.type == Type.UNKNOWN) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 2, Balance$Type$$serializer.INSTANCE, balance.type);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || balance.cash != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, CashBalance$$serializer.INSTANCE, balance.cash);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || balance.credit != null) {
            z2 = true;
        }
        if (z2) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, CreditBalance$$serializer.INSTANCE, balance.credit);
        }
    }

    public final int getAsOf() {
        return this.asOf;
    }

    public final Map<String, Integer> getCurrent() {
        return this.current;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Balance(int i, Map map, Type type2, CashBalance cashBalance, CreditBalance creditBalance, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, map, (i2 & 4) != 0 ? Type.UNKNOWN : type2, (i2 & 8) != 0 ? null : cashBalance, (i2 & 16) != 0 ? null : creditBalance);
    }

    public final Type getType() {
        return this.type;
    }

    public final CashBalance getCash() {
        return this.cash;
    }

    public final CreditBalance getCredit() {
        return this.credit;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\n\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/stripe/android/connections/model/Balance$Type;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CASH", "CREDIT", "UNKNOWN", "$serializer", "Companion", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Serializable
    /* compiled from: Balance.kt */
    public enum Type {
        CASH("cash"),
        CREDIT(PayPalLineItem.KIND_CREDIT),
        UNKNOWN("unknown");
        
        public static final Companion Companion = null;
        private final String value;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/connections/model/Balance$Type$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stripe/android/connections/model/Balance$Type;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Balance.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Type> serializer() {
                return Balance$Type$$serializer.INSTANCE;
            }
        }

        private Type(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }
    }
}
