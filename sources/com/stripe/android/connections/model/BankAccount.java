package com.stripe.android.connections.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Required;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 /2\u00020\u0001:\u0002./BI\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J5\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J!\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)HÇ\u0001J\u0019\u0010*\u001a\u00020$2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001e\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010¨\u00060"}, d2 = {"Lcom/stripe/android/connections/model/BankAccount;", "Lcom/stripe/android/connections/model/PaymentAccount;", "seen1", "", "id", "", "last4", "bankName", "routingNumber", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBankName$annotations", "()V", "getBankName", "()Ljava/lang/String;", "getId$annotations", "getId", "getLast4$annotations", "getLast4", "getRoutingNumber$annotations", "getRoutingNumber", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "$serializer", "Companion", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
/* compiled from: BankAccount.kt */
public final class BankAccount extends PaymentAccount {
    public static final Parcelable.Creator<BankAccount> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String bankName;
    private final String id;
    private final String last4;
    private final String routingNumber;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BankAccount.kt */
    public static final class Creator implements Parcelable.Creator<BankAccount> {
        public final BankAccount createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BankAccount(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final BankAccount[] newArray(int i) {
            return new BankAccount[i];
        }
    }

    public static /* synthetic */ BankAccount copy$default(BankAccount bankAccount, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bankAccount.id;
        }
        if ((i & 2) != 0) {
            str2 = bankAccount.last4;
        }
        if ((i & 4) != 0) {
            str3 = bankAccount.bankName;
        }
        if ((i & 8) != 0) {
            str4 = bankAccount.routingNumber;
        }
        return bankAccount.copy(str, str2, str3, str4);
    }

    @SerialName("bank_name")
    public static /* synthetic */ void getBankName$annotations() {
    }

    @Required
    @SerialName("id")
    public static /* synthetic */ void getId$annotations() {
    }

    @Required
    @SerialName("last4")
    public static /* synthetic */ void getLast4$annotations() {
    }

    @SerialName("routing_number")
    public static /* synthetic */ void getRoutingNumber$annotations() {
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.last4;
    }

    public final String component3() {
        return this.bankName;
    }

    public final String component4() {
        return this.routingNumber;
    }

    public final BankAccount copy(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
        Intrinsics.checkNotNullParameter(str2, "last4");
        return new BankAccount(str, str2, str3, str4);
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
        return Intrinsics.areEqual((Object) this.id, (Object) bankAccount.id) && Intrinsics.areEqual((Object) this.last4, (Object) bankAccount.last4) && Intrinsics.areEqual((Object) this.bankName, (Object) bankAccount.bankName) && Intrinsics.areEqual((Object) this.routingNumber, (Object) bankAccount.routingNumber);
    }

    public int hashCode() {
        int hashCode = ((this.id.hashCode() * 31) + this.last4.hashCode()) * 31;
        String str = this.bankName;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.routingNumber;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "BankAccount(id=" + this.id + ", last4=" + this.last4 + ", bankName=" + this.bankName + ", routingNumber=" + this.routingNumber + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.last4);
        parcel.writeString(this.bankName);
        parcel.writeString(this.routingNumber);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/connections/model/BankAccount$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stripe/android/connections/model/BankAccount;", "connections_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BankAccount.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<BankAccount> serializer() {
            return BankAccount$$serializer.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ BankAccount(int i, @Required @SerialName("id") String str, @Required @SerialName("last4") String str2, @SerialName("bank_name") String str3, @SerialName("routing_number") String str4, SerializationConstructorMarker serializationConstructorMarker) {
        super((DefaultConstructorMarker) null);
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, BankAccount$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.last4 = str2;
        if ((i & 4) == 0) {
            this.bankName = null;
        } else {
            this.bankName = str3;
        }
        if ((i & 8) == 0) {
            this.routingNumber = null;
        } else {
            this.routingNumber = str4;
        }
    }

    @JvmStatic
    public static final void write$Self(BankAccount bankAccount, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(bankAccount, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        boolean z = false;
        compositeEncoder.encodeStringElement(serialDescriptor, 0, bankAccount.id);
        compositeEncoder.encodeStringElement(serialDescriptor, 1, bankAccount.last4);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || bankAccount.bankName != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, bankAccount.bankName);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || bankAccount.routingNumber != null) {
            z = true;
        }
        if (z) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, bankAccount.routingNumber);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BankAccount(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public final String getId() {
        return this.id;
    }

    public final String getLast4() {
        return this.last4;
    }

    public final String getBankName() {
        return this.bankName;
    }

    public final String getRoutingNumber() {
        return this.routingNumber;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BankAccount(String str, String str2, String str3, String str4) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, MessageExtension.FIELD_ID);
        Intrinsics.checkNotNullParameter(str2, "last4");
        this.id = str;
        this.last4 = str2;
        this.bankName = str3;
        this.routingNumber = str4;
    }
}
