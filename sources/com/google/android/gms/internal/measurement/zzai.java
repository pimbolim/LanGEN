package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzz;

final class zzai extends zzz.zzb {
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ String zzbb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzai(zzz zzz, String str) {
        super(zzz);
        this.zzaa = zzz;
        this.zzbb = str;
    }

    /* access modifiers changed from: package-private */
    public final void zzf() throws RemoteException {
        this.zzaa.zzar.endAdUnitExposure(this.zzbb, this.zzbt);
    }
}
