package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzz;

final class zzae extends zzz.zzb {
    private final /* synthetic */ zzz zzaa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzae(zzz zzz) {
        super(zzz);
        this.zzaa = zzz;
    }

    /* access modifiers changed from: package-private */
    public final void zzf() throws RemoteException {
        this.zzaa.zzar.resetAnalyticsData(this.timestamp);
    }
}
