package com.google.android.gms.wallet.callback;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-wallet@@19.1.0 */
public class IntermediatePaymentData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<IntermediatePaymentData> CREATOR = new zzl();
    String zza;
    Bundle zzb;

    IntermediatePaymentData(String str, Bundle bundle) {
        this.zza = str;
        this.zzb = bundle;
    }

    public static IntermediatePaymentData fromJson(String str) {
        return new IntermediatePaymentData((String) Preconditions.checkNotNull(str, "JSON cannot be null!"), (Bundle) null);
    }

    public Bundle getLastSavedState() {
        return this.zzb;
    }

    public String toJson() {
        return this.zza;
    }

    public IntermediatePaymentData withLastSavedState(Bundle bundle) {
        this.zzb = bundle;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeBundle(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
