package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.model.PaymentMethod;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\t\u0010\u000f\u001a\u00020\u0004HÂ\u0003J\u000e\u0010\u0010\u001a\u00020\u0006HÀ\u0003¢\u0006\u0002\b\u0011J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\bHÂ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÂ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÂ\u0003JF\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u0017J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\u0014\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001c0\u001fH\u0016J\t\u0010 \u001a\u00020\u0004HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\bHÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/stripe/android/model/ListPaymentMethodsParams;", "Lcom/stripe/android/model/StripeParamsModel;", "Landroid/os/Parcelable;", "customerId", "", "paymentMethodType", "Lcom/stripe/android/model/PaymentMethod$Type;", "limit", "", "endingBefore", "startingAfter", "(Ljava/lang/String;Lcom/stripe/android/model/PaymentMethod$Type;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "Ljava/lang/Integer;", "getPaymentMethodType$payments_core_release", "()Lcom/stripe/android/model/PaymentMethod$Type;", "component1", "component2", "component2$payments_core_release", "component3", "()Ljava/lang/Integer;", "component4", "component5", "copy", "(Ljava/lang/String;Lcom/stripe/android/model/PaymentMethod$Type;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/stripe/android/model/ListPaymentMethodsParams;", "describeContents", "equals", "", "other", "", "hashCode", "toParamMap", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ListPaymentMethodsParams.kt */
public final class ListPaymentMethodsParams implements StripeParamsModel, Parcelable {
    public static final int $stable = 8;
    public static final Parcelable.Creator<ListPaymentMethodsParams> CREATOR = new Creator();
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String PARAM_CUSTOMER = "customer";
    @Deprecated
    private static final String PARAM_ENDING_BEFORE = "ending_before";
    @Deprecated
    private static final String PARAM_LIMIT = "limit";
    @Deprecated
    private static final String PARAM_STARTING_AFTER = "starting_after";
    @Deprecated
    private static final String PARAM_TYPE = "type";
    private final String customerId;
    private final String endingBefore;
    private final Integer limit;
    private final PaymentMethod.Type paymentMethodType;
    private final String startingAfter;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ListPaymentMethodsParams.kt */
    public static final class Creator implements Parcelable.Creator<ListPaymentMethodsParams> {
        public final ListPaymentMethodsParams createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ListPaymentMethodsParams(parcel.readString(), PaymentMethod.Type.CREATOR.createFromParcel(parcel), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString());
        }

        public final ListPaymentMethodsParams[] newArray(int i) {
            return new ListPaymentMethodsParams[i];
        }
    }

    private final String component1() {
        return this.customerId;
    }

    private final Integer component3() {
        return this.limit;
    }

    private final String component4() {
        return this.endingBefore;
    }

    private final String component5() {
        return this.startingAfter;
    }

    public static /* synthetic */ ListPaymentMethodsParams copy$default(ListPaymentMethodsParams listPaymentMethodsParams, String str, PaymentMethod.Type type, Integer num, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = listPaymentMethodsParams.customerId;
        }
        if ((i & 2) != 0) {
            type = listPaymentMethodsParams.paymentMethodType;
        }
        PaymentMethod.Type type2 = type;
        if ((i & 4) != 0) {
            num = listPaymentMethodsParams.limit;
        }
        Integer num2 = num;
        if ((i & 8) != 0) {
            str2 = listPaymentMethodsParams.endingBefore;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            str3 = listPaymentMethodsParams.startingAfter;
        }
        return listPaymentMethodsParams.copy(str, type2, num2, str4, str3);
    }

    public final PaymentMethod.Type component2$payments_core_release() {
        return this.paymentMethodType;
    }

    public final ListPaymentMethodsParams copy(String str, PaymentMethod.Type type, Integer num, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "customerId");
        Intrinsics.checkNotNullParameter(type, "paymentMethodType");
        return new ListPaymentMethodsParams(str, type, num, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListPaymentMethodsParams)) {
            return false;
        }
        ListPaymentMethodsParams listPaymentMethodsParams = (ListPaymentMethodsParams) obj;
        return Intrinsics.areEqual((Object) this.customerId, (Object) listPaymentMethodsParams.customerId) && this.paymentMethodType == listPaymentMethodsParams.paymentMethodType && Intrinsics.areEqual((Object) this.limit, (Object) listPaymentMethodsParams.limit) && Intrinsics.areEqual((Object) this.endingBefore, (Object) listPaymentMethodsParams.endingBefore) && Intrinsics.areEqual((Object) this.startingAfter, (Object) listPaymentMethodsParams.startingAfter);
    }

    public int hashCode() {
        int hashCode = ((this.customerId.hashCode() * 31) + this.paymentMethodType.hashCode()) * 31;
        Integer num = this.limit;
        int i = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.endingBefore;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.startingAfter;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ListPaymentMethodsParams(customerId=" + this.customerId + ", paymentMethodType=" + this.paymentMethodType + ", limit=" + this.limit + ", endingBefore=" + this.endingBefore + ", startingAfter=" + this.startingAfter + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.customerId);
        this.paymentMethodType.writeToParcel(parcel, i);
        Integer num = this.limit;
        if (num == null) {
            i2 = 0;
        } else {
            parcel.writeInt(1);
            i2 = num.intValue();
        }
        parcel.writeInt(i2);
        parcel.writeString(this.endingBefore);
        parcel.writeString(this.startingAfter);
    }

    public ListPaymentMethodsParams(String str, PaymentMethod.Type type, Integer num, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "customerId");
        Intrinsics.checkNotNullParameter(type, "paymentMethodType");
        this.customerId = str;
        this.paymentMethodType = type;
        this.limit = num;
        this.endingBefore = str2;
        this.startingAfter = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ListPaymentMethodsParams(String str, PaymentMethod.Type type, Integer num, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, type, (i & 4) != 0 ? null : num, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3);
    }

    public final PaymentMethod.Type getPaymentMethodType$payments_core_release() {
        return this.paymentMethodType;
    }

    public Map<String, Object> toParamMap() {
        Map map;
        Pair[] pairArr = {TuplesKt.to(PARAM_CUSTOMER, this.customerId), TuplesKt.to("type", this.paymentMethodType.code), TuplesKt.to(PARAM_LIMIT, this.limit), TuplesKt.to(PARAM_ENDING_BEFORE, this.endingBefore), TuplesKt.to(PARAM_STARTING_AFTER, this.startingAfter)};
        Map<String, Object> emptyMap = MapsKt.emptyMap();
        for (Pair pair : CollectionsKt.listOf(pairArr)) {
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

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/model/ListPaymentMethodsParams$Companion;", "", "()V", "PARAM_CUSTOMER", "", "PARAM_ENDING_BEFORE", "PARAM_LIMIT", "PARAM_STARTING_AFTER", "PARAM_TYPE", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ListPaymentMethodsParams.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
