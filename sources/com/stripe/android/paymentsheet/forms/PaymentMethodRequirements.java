package com.stripe.android.paymentsheet.forms;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u0013\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016HÖ\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\""}, d2 = {"Lcom/stripe/android/paymentsheet/forms/PaymentMethodRequirements;", "Landroid/os/Parcelable;", "piRequirements", "", "Lcom/stripe/android/paymentsheet/forms/PIRequirement;", "siRequirements", "Lcom/stripe/android/paymentsheet/forms/SIRequirement;", "confirmPMFromCustomer", "", "(Ljava/util/Set;Ljava/util/Set;Ljava/lang/Boolean;)V", "getConfirmPMFromCustomer", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPiRequirements", "()Ljava/util/Set;", "getSiRequirements", "component1", "component2", "component3", "copy", "(Ljava/util/Set;Ljava/util/Set;Ljava/lang/Boolean;)Lcom/stripe/android/paymentsheet/forms/PaymentMethodRequirements;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodRequirements.kt */
public final class PaymentMethodRequirements implements Parcelable {
    public static final Parcelable.Creator<PaymentMethodRequirements> CREATOR = new Creator();
    private final Boolean confirmPMFromCustomer;
    private final Set<PIRequirement> piRequirements;
    private final Set<SIRequirement> siRequirements;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodRequirements.kt */
    public static final class Creator implements Parcelable.Creator<PaymentMethodRequirements> {
        public final PaymentMethodRequirements createFromParcel(Parcel parcel) {
            LinkedHashSet linkedHashSet;
            LinkedHashSet linkedHashSet2;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Boolean bool = null;
            boolean z = false;
            if (parcel.readInt() == 0) {
                linkedHashSet = null;
            } else {
                int readInt = parcel.readInt();
                linkedHashSet = new LinkedHashSet(readInt);
                for (int i = 0; i != readInt; i++) {
                    linkedHashSet.add(parcel.readParcelable(PaymentMethodRequirements.class.getClassLoader()));
                }
            }
            Set set = linkedHashSet;
            if (parcel.readInt() == 0) {
                linkedHashSet2 = null;
            } else {
                int readInt2 = parcel.readInt();
                linkedHashSet2 = new LinkedHashSet(readInt2);
                for (int i2 = 0; i2 != readInt2; i2++) {
                    linkedHashSet2.add(parcel.readParcelable(PaymentMethodRequirements.class.getClassLoader()));
                }
            }
            Set set2 = linkedHashSet2;
            if (parcel.readInt() != 0) {
                if (parcel.readInt() != 0) {
                    z = true;
                }
                bool = Boolean.valueOf(z);
            }
            return new PaymentMethodRequirements(set, set2, bool);
        }

        public final PaymentMethodRequirements[] newArray(int i) {
            return new PaymentMethodRequirements[i];
        }
    }

    public static /* synthetic */ PaymentMethodRequirements copy$default(PaymentMethodRequirements paymentMethodRequirements, Set<PIRequirement> set, Set<SIRequirement> set2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            set = paymentMethodRequirements.piRequirements;
        }
        if ((i & 2) != 0) {
            set2 = paymentMethodRequirements.siRequirements;
        }
        if ((i & 4) != 0) {
            bool = paymentMethodRequirements.confirmPMFromCustomer;
        }
        return paymentMethodRequirements.copy(set, set2, bool);
    }

    public final Set<PIRequirement> component1() {
        return this.piRequirements;
    }

    public final Set<SIRequirement> component2() {
        return this.siRequirements;
    }

    public final Boolean component3() {
        return this.confirmPMFromCustomer;
    }

    public final PaymentMethodRequirements copy(Set<? extends PIRequirement> set, Set<? extends SIRequirement> set2, Boolean bool) {
        return new PaymentMethodRequirements(set, set2, bool);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentMethodRequirements)) {
            return false;
        }
        PaymentMethodRequirements paymentMethodRequirements = (PaymentMethodRequirements) obj;
        return Intrinsics.areEqual((Object) this.piRequirements, (Object) paymentMethodRequirements.piRequirements) && Intrinsics.areEqual((Object) this.siRequirements, (Object) paymentMethodRequirements.siRequirements) && Intrinsics.areEqual((Object) this.confirmPMFromCustomer, (Object) paymentMethodRequirements.confirmPMFromCustomer);
    }

    public int hashCode() {
        Set<PIRequirement> set = this.piRequirements;
        int i = 0;
        int hashCode = (set == null ? 0 : set.hashCode()) * 31;
        Set<SIRequirement> set2 = this.siRequirements;
        int hashCode2 = (hashCode + (set2 == null ? 0 : set2.hashCode())) * 31;
        Boolean bool = this.confirmPMFromCustomer;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "PaymentMethodRequirements(piRequirements=" + this.piRequirements + ", siRequirements=" + this.siRequirements + ", confirmPMFromCustomer=" + this.confirmPMFromCustomer + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Set<PIRequirement> set = this.piRequirements;
        if (set == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(set.size());
            for (PIRequirement writeParcelable : set) {
                parcel.writeParcelable(writeParcelable, i);
            }
        }
        Set<SIRequirement> set2 = this.siRequirements;
        if (set2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(set2.size());
            for (SIRequirement writeParcelable2 : set2) {
                parcel.writeParcelable(writeParcelable2, i);
            }
        }
        Boolean bool = this.confirmPMFromCustomer;
        if (bool == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(bool.booleanValue() ? 1 : 0);
    }

    public PaymentMethodRequirements(Set<? extends PIRequirement> set, Set<? extends SIRequirement> set2, Boolean bool) {
        this.piRequirements = set;
        this.siRequirements = set2;
        this.confirmPMFromCustomer = bool;
    }

    public final Set<PIRequirement> getPiRequirements() {
        return this.piRequirements;
    }

    public final Set<SIRequirement> getSiRequirements() {
        return this.siRequirements;
    }

    public final Boolean getConfirmPMFromCustomer() {
        return this.confirmPMFromCustomer;
    }
}
