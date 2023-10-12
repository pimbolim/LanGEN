package com.stripe.android.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.core.model.StripeModel;
import com.stripe.android.view.Bank;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÂ\u0003J\u001f\u0010\b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\nHÖ\u0001J\u0015\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J\r\u0010\u0013\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0014J\t\u0010\u0015\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\nHÖ\u0001R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/model/BankStatuses;", "Lcom/stripe/android/core/model/StripeModel;", "statuses", "", "", "", "(Ljava/util/Map;)V", "component1", "copy", "describeContents", "", "equals", "other", "", "hashCode", "isOnline", "bank", "Lcom/stripe/android/view/Bank;", "isOnline$payments_core_release", "size", "size$payments_core_release", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BankStatuses.kt */
public final class BankStatuses implements StripeModel {
    public static final Parcelable.Creator<BankStatuses> CREATOR = new Creator();
    private final Map<String, Boolean> statuses;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BankStatuses.kt */
    public static final class Creator implements Parcelable.Creator<BankStatuses> {
        public final BankStatuses createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i = 0; i != readInt; i++) {
                linkedHashMap.put(parcel.readString(), Boolean.valueOf(parcel.readInt() != 0));
            }
            return new BankStatuses(linkedHashMap);
        }

        public final BankStatuses[] newArray(int i) {
            return new BankStatuses[i];
        }
    }

    public BankStatuses() {
        this((Map) null, 1, (DefaultConstructorMarker) null);
    }

    private final Map<String, Boolean> component1() {
        return this.statuses;
    }

    public static /* synthetic */ BankStatuses copy$default(BankStatuses bankStatuses, Map<String, Boolean> map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = bankStatuses.statuses;
        }
        return bankStatuses.copy(map);
    }

    public final BankStatuses copy(Map<String, Boolean> map) {
        Intrinsics.checkNotNullParameter(map, "statuses");
        return new BankStatuses(map);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BankStatuses) && Intrinsics.areEqual((Object) this.statuses, (Object) ((BankStatuses) obj).statuses);
    }

    public int hashCode() {
        return this.statuses.hashCode();
    }

    public String toString() {
        return "BankStatuses(statuses=" + this.statuses + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Map<String, Boolean> map = this.statuses;
        parcel.writeInt(map.size());
        for (Map.Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeInt(((Boolean) next.getValue()).booleanValue() ? 1 : 0);
        }
    }

    public BankStatuses(Map<String, Boolean> map) {
        Intrinsics.checkNotNullParameter(map, "statuses");
        this.statuses = map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BankStatuses(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map);
    }

    public final int size$payments_core_release() {
        return this.statuses.size();
    }

    public final /* synthetic */ boolean isOnline$payments_core_release(Bank bank) {
        Intrinsics.checkNotNullParameter(bank, "bank");
        Boolean bool = this.statuses.get(bank.getId());
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }
}
