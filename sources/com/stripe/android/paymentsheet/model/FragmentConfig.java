package com.stripe.android.paymentsheet.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stripe.android.model.StripeIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/paymentsheet/model/FragmentConfig;", "Landroid/os/Parcelable;", "stripeIntent", "Lcom/stripe/android/model/StripeIntent;", "isGooglePayReady", "", "savedSelection", "Lcom/stripe/android/paymentsheet/model/SavedSelection;", "(Lcom/stripe/android/model/StripeIntent;ZLcom/stripe/android/paymentsheet/model/SavedSelection;)V", "()Z", "getSavedSelection", "()Lcom/stripe/android/paymentsheet/model/SavedSelection;", "getStripeIntent", "()Lcom/stripe/android/model/StripeIntent;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FragmentConfig.kt */
public final class FragmentConfig implements Parcelable {
    public static final Parcelable.Creator<FragmentConfig> CREATOR = new Creator();
    private final boolean isGooglePayReady;
    private final SavedSelection savedSelection;
    private final StripeIntent stripeIntent;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FragmentConfig.kt */
    public static final class Creator implements Parcelable.Creator<FragmentConfig> {
        public final FragmentConfig createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FragmentConfig((StripeIntent) parcel.readParcelable(FragmentConfig.class.getClassLoader()), parcel.readInt() != 0, (SavedSelection) parcel.readParcelable(FragmentConfig.class.getClassLoader()));
        }

        public final FragmentConfig[] newArray(int i) {
            return new FragmentConfig[i];
        }
    }

    public static /* synthetic */ FragmentConfig copy$default(FragmentConfig fragmentConfig, StripeIntent stripeIntent2, boolean z, SavedSelection savedSelection2, int i, Object obj) {
        if ((i & 1) != 0) {
            stripeIntent2 = fragmentConfig.stripeIntent;
        }
        if ((i & 2) != 0) {
            z = fragmentConfig.isGooglePayReady;
        }
        if ((i & 4) != 0) {
            savedSelection2 = fragmentConfig.savedSelection;
        }
        return fragmentConfig.copy(stripeIntent2, z, savedSelection2);
    }

    public final StripeIntent component1() {
        return this.stripeIntent;
    }

    public final boolean component2() {
        return this.isGooglePayReady;
    }

    public final SavedSelection component3() {
        return this.savedSelection;
    }

    public final FragmentConfig copy(StripeIntent stripeIntent2, boolean z, SavedSelection savedSelection2) {
        Intrinsics.checkNotNullParameter(stripeIntent2, "stripeIntent");
        Intrinsics.checkNotNullParameter(savedSelection2, "savedSelection");
        return new FragmentConfig(stripeIntent2, z, savedSelection2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FragmentConfig)) {
            return false;
        }
        FragmentConfig fragmentConfig = (FragmentConfig) obj;
        return Intrinsics.areEqual((Object) this.stripeIntent, (Object) fragmentConfig.stripeIntent) && this.isGooglePayReady == fragmentConfig.isGooglePayReady && Intrinsics.areEqual((Object) this.savedSelection, (Object) fragmentConfig.savedSelection);
    }

    public int hashCode() {
        int hashCode = this.stripeIntent.hashCode() * 31;
        boolean z = this.isGooglePayReady;
        if (z) {
            z = true;
        }
        return ((hashCode + (z ? 1 : 0)) * 31) + this.savedSelection.hashCode();
    }

    public String toString() {
        return "FragmentConfig(stripeIntent=" + this.stripeIntent + ", isGooglePayReady=" + this.isGooglePayReady + ", savedSelection=" + this.savedSelection + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeParcelable(this.stripeIntent, i);
        parcel.writeInt(this.isGooglePayReady ? 1 : 0);
        parcel.writeParcelable(this.savedSelection, i);
    }

    public FragmentConfig(StripeIntent stripeIntent2, boolean z, SavedSelection savedSelection2) {
        Intrinsics.checkNotNullParameter(stripeIntent2, "stripeIntent");
        Intrinsics.checkNotNullParameter(savedSelection2, "savedSelection");
        this.stripeIntent = stripeIntent2;
        this.isGooglePayReady = z;
        this.savedSelection = savedSelection2;
    }

    public final StripeIntent getStripeIntent() {
        return this.stripeIntent;
    }

    public final boolean isGooglePayReady() {
        return this.isGooglePayReady;
    }

    public final SavedSelection getSavedSelection() {
        return this.savedSelection;
    }
}
