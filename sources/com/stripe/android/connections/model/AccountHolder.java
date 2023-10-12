package com.stripe.android.connections.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0003-./B=\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fB'\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J+\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0004HÖ\u0001J\t\u0010!\u001a\u00020\bHÖ\u0001J!\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(HÇ\u0001J\u0019\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016¨\u00060"}, d2 = {"Lcom/stripe/android/connections/model/AccountHolder;", "Lcom/stripe/android/core/model/StripeModel;", "Landroid/os/Parcelable;", "seen1", "", "type", "Lcom/stripe/android/connections/model/AccountHolder$Type;", "account", "", "customer", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/stripe/android/connections/model/AccountHolder$Type;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Lcom/stripe/android/connections/model/AccountHolder$Type;Ljava/lang/String;Ljava/lang/String;)V", "getAccount$annotations", "()V", "getAccount", "()Ljava/lang/String;", "getCustomer$annotations", "getCustomer", "getType$annotations", "getType", "()Lcom/stripe/android/connections/model/AccountHolder$Type;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "$serializer", "Companion", "Type", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
/* compiled from: AccountHolder.kt */
public final class AccountHolder implements StripeModel, Parcelable {
    public static final Parcelable.Creator<AccountHolder> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String account;
    private final String customer;
    private final Type type;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AccountHolder.kt */
    public static final class Creator implements Parcelable.Creator<AccountHolder> {
        public final AccountHolder createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new AccountHolder(Type.valueOf(parcel.readString()), parcel.readString(), parcel.readString());
        }

        public final AccountHolder[] newArray(int i) {
            return new AccountHolder[i];
        }
    }

    public AccountHolder() {
        this((Type) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ AccountHolder copy$default(AccountHolder accountHolder, Type type2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            type2 = accountHolder.type;
        }
        if ((i & 2) != 0) {
            str = accountHolder.account;
        }
        if ((i & 4) != 0) {
            str2 = accountHolder.customer;
        }
        return accountHolder.copy(type2, str, str2);
    }

    @SerialName("account")
    public static /* synthetic */ void getAccount$annotations() {
    }

    @SerialName("customer")
    public static /* synthetic */ void getCustomer$annotations() {
    }

    @SerialName("type")
    public static /* synthetic */ void getType$annotations() {
    }

    public final Type component1() {
        return this.type;
    }

    public final String component2() {
        return this.account;
    }

    public final String component3() {
        return this.customer;
    }

    public final AccountHolder copy(Type type2, String str, String str2) {
        Intrinsics.checkNotNullParameter(type2, "type");
        return new AccountHolder(type2, str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountHolder)) {
            return false;
        }
        AccountHolder accountHolder = (AccountHolder) obj;
        return this.type == accountHolder.type && Intrinsics.areEqual((Object) this.account, (Object) accountHolder.account) && Intrinsics.areEqual((Object) this.customer, (Object) accountHolder.customer);
    }

    public int hashCode() {
        int hashCode = this.type.hashCode() * 31;
        String str = this.account;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.customer;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "AccountHolder(type=" + this.type + ", account=" + this.account + ", customer=" + this.customer + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.type.name());
        parcel.writeString(this.account);
        parcel.writeString(this.customer);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/connections/model/AccountHolder$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stripe/android/connections/model/AccountHolder;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AccountHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<AccountHolder> serializer() {
            return AccountHolder$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ AccountHolder(int i, @SerialName("type") Type type2, @SerialName("account") String str, @SerialName("customer") String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 0) != 0) {
            PluginExceptionsKt.throwMissingFieldException(i, 0, AccountHolder$$serializer.INSTANCE.getDescriptor());
        }
        this.type = (i & 1) == 0 ? Type.UNKNOWN : type2;
        if ((i & 2) == 0) {
            this.account = null;
        } else {
            this.account = str;
        }
        if ((i & 4) == 0) {
            this.customer = null;
        } else {
            this.customer = str2;
        }
    }

    public AccountHolder(Type type2, String str, String str2) {
        Intrinsics.checkNotNullParameter(type2, "type");
        this.type = type2;
        this.account = str;
        this.customer = str2;
    }

    @JvmStatic
    public static final void write$Self(AccountHolder accountHolder, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(accountHolder, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        boolean z = false;
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || accountHolder.type != Type.UNKNOWN) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 0, AccountHolder$Type$$serializer.INSTANCE, accountHolder.type);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || accountHolder.account != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, accountHolder.account);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || accountHolder.customer != null) {
            z = true;
        }
        if (z) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, accountHolder.customer);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AccountHolder(Type type2, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Type.UNKNOWN : type2, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }

    public final Type getType() {
        return this.type;
    }

    public final String getAccount() {
        return this.account;
    }

    public final String getCustomer() {
        return this.customer;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\n\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\f"}, d2 = {"Lcom/stripe/android/connections/model/AccountHolder$Type;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ACCOUNT", "CUSTOMER", "UNKNOWN", "$serializer", "Companion", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Serializable
    /* compiled from: AccountHolder.kt */
    public enum Type {
        ACCOUNT("account"),
        CUSTOMER("customer"),
        UNKNOWN("unknown");
        
        public static final Companion Companion = null;
        private final String value;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/connections/model/AccountHolder$Type$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stripe/android/connections/model/AccountHolder$Type;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: AccountHolder.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final KSerializer<Type> serializer() {
                return AccountHolder$Type$$serializer.INSTANCE;
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
