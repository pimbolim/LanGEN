package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\u0014\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00170\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\""}, d2 = {"Lcom/stripe/android/model/ShippingInformation;", "Lcom/stripe/android/core/model/StripeModel;", "Lcom/stripe/android/model/StripeParamsModel;", "address", "Lcom/stripe/android/model/Address;", "name", "", "phone", "(Lcom/stripe/android/model/Address;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Lcom/stripe/android/model/Address;", "getName", "()Ljava/lang/String;", "getPhone", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShippingInformation.kt */
public final class ShippingInformation implements StripeModel, StripeParamsModel {
    public static final int $stable = 0;
    public static final Parcelable.Creator<ShippingInformation> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String PARAM_ADDRESS = "address";
    private static final String PARAM_NAME = "name";
    private static final String PARAM_PHONE = "phone";
    private final Address address;
    private final String name;
    private final String phone;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShippingInformation.kt */
    public static final class Creator implements Parcelable.Creator<ShippingInformation> {
        public final ShippingInformation createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ShippingInformation(parcel.readInt() == 0 ? null : Address.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString());
        }

        public final ShippingInformation[] newArray(int i) {
            return new ShippingInformation[i];
        }
    }

    public ShippingInformation() {
        this((Address) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ ShippingInformation copy$default(ShippingInformation shippingInformation, Address address2, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            address2 = shippingInformation.address;
        }
        if ((i & 2) != 0) {
            str = shippingInformation.name;
        }
        if ((i & 4) != 0) {
            str2 = shippingInformation.phone;
        }
        return shippingInformation.copy(address2, str, str2);
    }

    public final Address component1() {
        return this.address;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.phone;
    }

    public final ShippingInformation copy(Address address2, String str, String str2) {
        return new ShippingInformation(address2, str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShippingInformation)) {
            return false;
        }
        ShippingInformation shippingInformation = (ShippingInformation) obj;
        return Intrinsics.areEqual((Object) this.address, (Object) shippingInformation.address) && Intrinsics.areEqual((Object) this.name, (Object) shippingInformation.name) && Intrinsics.areEqual((Object) this.phone, (Object) shippingInformation.phone);
    }

    public int hashCode() {
        Address address2 = this.address;
        int i = 0;
        int hashCode = (address2 == null ? 0 : address2.hashCode()) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.phone;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ShippingInformation(address=" + this.address + ", name=" + this.name + ", phone=" + this.phone + ')';
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
        parcel.writeString(this.name);
        parcel.writeString(this.phone);
    }

    public ShippingInformation(Address address2, String str, String str2) {
        this.address = address2;
        this.name = str;
        this.phone = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShippingInformation(Address address2, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : address2, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }

    public final Address getAddress() {
        return this.address;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPhone() {
        return this.phone;
    }

    public Map<String, Object> toParamMap() {
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("name", this.name);
        pairArr[1] = TuplesKt.to("phone", this.phone);
        Address address2 = this.address;
        pairArr[2] = TuplesKt.to("address", address2 == null ? null : address2.toParamMap());
        Collection arrayList = new ArrayList();
        for (Pair pair : CollectionsKt.listOf(pairArr)) {
            String str = (String) pair.component1();
            Object component2 = pair.component2();
            Pair pair2 = component2 == null ? null : new Pair(str, component2);
            if (pair2 != null) {
                arrayList.add(pair2);
            }
        }
        return MapsKt.toMap((List) arrayList);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/model/ShippingInformation$Companion;", "", "()V", "PARAM_ADDRESS", "", "PARAM_NAME", "PARAM_PHONE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShippingInformation.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
