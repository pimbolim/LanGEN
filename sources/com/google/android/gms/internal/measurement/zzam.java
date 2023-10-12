package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzz;

final class zzam extends zzz.zzb {
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ zzl zzat;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzam(zzz zzz, zzl zzl) {
        super(zzz);
        this.zzaa = zzz;
        this.zzat = zzl;
    }

    /* access modifiers changed from: package-private */
    public final void zzf() throws RemoteException {
        this.zzaa.zzar.generateEventId(this.zzat);
    }

    /* access modifiers changed from: protected */
    public final void zzk() {
        this.zzat.zzb((Bundle) null);
    }
}
