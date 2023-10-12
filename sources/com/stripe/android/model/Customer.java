package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bk\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u000b¢\u0006\u0002\u0010\u0012J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u0010-\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010.J\t\u0010/\u001a\u00020\rHÖ\u0001J\u0013\u00100\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u000102HÖ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\t2\u0006\u00104\u001a\u00020\u0003J\t\u00105\u001a\u00020\rHÖ\u0001J\t\u00106\u001a\u00020\u0003HÖ\u0001J\u0019\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\rHÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u0006<"}, d2 = {"Lcom/stripe/android/model/Customer;", "Lcom/stripe/android/core/model/StripeModel;", "id", "", "defaultSource", "shippingInformation", "Lcom/stripe/android/model/ShippingInformation;", "sources", "", "Lcom/stripe/android/model/CustomerPaymentSource;", "hasMore", "", "totalCount", "", "url", "description", "email", "liveMode", "(Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/ShippingInformation;Ljava/util/List;ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getDefaultSource", "()Ljava/lang/String;", "getDescription", "getEmail", "getHasMore", "()Z", "getId", "getLiveMode", "getShippingInformation", "()Lcom/stripe/android/model/ShippingInformation;", "getSources", "()Ljava/util/List;", "getTotalCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUrl", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/stripe/android/model/ShippingInformation;Ljava/util/List;ZLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/stripe/android/model/Customer;", "describeContents", "equals", "other", "", "getSourceById", "sourceId", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Customer.kt */
public final class Customer implements StripeModel {
    public static final int $stable = 8;
    public static final Parcelable.Creator<Customer> CREATOR = new Creator();
    private final String defaultSource;
    private final String description;
    private final String email;
    private final boolean hasMore;
    private final String id;
    private final boolean liveMode;
    private final ShippingInformation shippingInformation;
    private final List<CustomerPaymentSource> sources;
    private final Integer totalCount;
    private final String url;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Customer.kt */
    public static final class Creator implements Parcelable.Creator<Customer> {
        public final Customer createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Integer num = null;
            ShippingInformation createFromParcel = parcel.readInt() == 0 ? null : ShippingInformation.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i != readInt; i++) {
                arrayList.add(parcel.readParcelable(Customer.class.getClassLoader()));
            }
            List list = arrayList;
            boolean z = parcel.readInt() != 0;
            if (parcel.readInt() != 0) {
                num = Integer.valueOf(parcel.readInt());
            }
            return new Customer(readString, readString2, createFromParcel, list, z, num, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        public final Customer[] newArray(int i) {
            return new Customer[i];
        }
    }

    public static /* synthetic */ Customer copy$default(Customer customer, String str, String str2, ShippingInformation shippingInformation2, List list, boolean z, Integer num, String str3, String str4, String str5, boolean z2, int i, Object obj) {
        Customer customer2 = customer;
        int i2 = i;
        return customer.copy((i2 & 1) != 0 ? customer2.id : str, (i2 & 2) != 0 ? customer2.defaultSource : str2, (i2 & 4) != 0 ? customer2.shippingInformation : shippingInformation2, (i2 & 8) != 0 ? customer2.sources : list, (i2 & 16) != 0 ? customer2.hasMore : z, (i2 & 32) != 0 ? customer2.totalCount : num, (i2 & 64) != 0 ? customer2.url : str3, (i2 & 128) != 0 ? customer2.description : str4, (i2 & 256) != 0 ? customer2.email : str5, (i2 & 512) != 0 ? customer2.liveMode : z2);
    }

    public final String component1() {
        return this.id;
    }

    public final boolean component10() {
        return this.liveMode;
    }

    public final String component2() {
        return this.defaultSource;
    }

    public final ShippingInformation component3() {
        return this.shippingInformation;
    }

    public final List<CustomerPaymentSource> component4() {
        return this.sources;
    }

    public final boolean component5() {
        return this.hasMore;
    }

    public final Integer component6() {
        return this.totalCount;
    }

    public final String component7() {
        return this.url;
    }

    public final String component8() {
        return this.description;
    }

    public final String component9() {
        return this.email;
    }

    public final Customer copy(String str, String str2, ShippingInformation shippingInformation2, List<? extends CustomerPaymentSource> list, boolean z, Integer num, String str3, String str4, String str5, boolean z2) {
        List<? extends CustomerPaymentSource> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "sources");
        return new Customer(str, str2, shippingInformation2, list2, z, num, str3, str4, str5, z2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) customer.id) && Intrinsics.areEqual((Object) this.defaultSource, (Object) customer.defaultSource) && Intrinsics.areEqual((Object) this.shippingInformation, (Object) customer.shippingInformation) && Intrinsics.areEqual((Object) this.sources, (Object) customer.sources) && this.hasMore == customer.hasMore && Intrinsics.areEqual((Object) this.totalCount, (Object) customer.totalCount) && Intrinsics.areEqual((Object) this.url, (Object) customer.url) && Intrinsics.areEqual((Object) this.description, (Object) customer.description) && Intrinsics.areEqual((Object) this.email, (Object) customer.email) && this.liveMode == customer.liveMode;
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.defaultSource;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ShippingInformation shippingInformation2 = this.shippingInformation;
        int hashCode3 = (((hashCode2 + (shippingInformation2 == null ? 0 : shippingInformation2.hashCode())) * 31) + this.sources.hashCode()) * 31;
        boolean z = this.hasMore;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode3 + (z ? 1 : 0)) * 31;
        Integer num = this.totalCount;
        int hashCode4 = (i2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.url;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.description;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.email;
        if (str5 != null) {
            i = str5.hashCode();
        }
        int i3 = (hashCode6 + i) * 31;
        boolean z3 = this.liveMode;
        if (!z3) {
            z2 = z3;
        }
        return i3 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "Customer(id=" + this.id + ", defaultSource=" + this.defaultSource + ", shippingInformation=" + this.shippingInformation + ", sources=" + this.sources + ", hasMore=" + this.hasMore + ", totalCount=" + this.totalCount + ", url=" + this.url + ", description=" + this.description + ", email=" + this.email + ", liveMode=" + this.liveMode + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.defaultSource);
        ShippingInformation shippingInformation2 = this.shippingInformation;
        if (shippingInformation2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            shippingInformation2.writeToParcel(parcel, i);
        }
        List<CustomerPaymentSource> list = this.sources;
        parcel.writeInt(list.size());
        for (CustomerPaymentSource writeParcelable : list) {
            parcel.writeParcelable(writeParcelable, i);
        }
        parcel.writeInt(this.hasMore ? 1 : 0);
        Integer num = this.totalCount;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.url);
        parcel.writeString(this.description);
        parcel.writeString(this.email);
        parcel.writeInt(this.liveMode ? 1 : 0);
    }

    public Customer(String str, String str2, ShippingInformation shippingInformation2, List<? extends CustomerPaymentSource> list, boolean z, Integer num, String str3, String str4, String str5, boolean z2) {
        Intrinsics.checkNotNullParameter(list, "sources");
        this.id = str;
        this.defaultSource = str2;
        this.shippingInformation = shippingInformation2;
        this.sources = list;
        this.hasMore = z;
        this.totalCount = num;
        this.url = str3;
        this.description = str4;
        this.email = str5;
        this.liveMode = z2;
    }

    public final String getId() {
        return this.id;
    }

    public final String getDefaultSource() {
        return this.defaultSource;
    }

    public final ShippingInformation getShippingInformation() {
        return this.shippingInformation;
    }

    public final List<CustomerPaymentSource> getSources() {
        return this.sources;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final Integer getTotalCount() {
        return this.totalCount;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getEmail() {
        return this.email;
    }

    public final boolean getLiveMode() {
        return this.liveMode;
    }

    public final CustomerPaymentSource getSourceById(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "sourceId");
        Iterator it = this.sources.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((CustomerPaymentSource) obj).getId(), (Object) str)) {
                break;
            }
        }
        return (CustomerPaymentSource) obj;
    }
}
