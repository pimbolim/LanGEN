package com.google.android.gms.wallet.wobs;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-wallet@@19.1.0 */
public final class LabelValue extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LabelValue> CREATOR = new zzd();
    String zza;
    String zzb;

    LabelValue() {
    }

    public String getLabel() {
        return this.zza;
    }

    public String getValue() {
        return this.zzb;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public LabelValue(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }
}
