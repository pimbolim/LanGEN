package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzz;

final class zzax extends zzz.zzb {
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ zzl zzat;
    private final /* synthetic */ int zzbl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzax(zzz zzz, zzl zzl, int i) {
        super(zzz);
        this.zzaa = zzz;
        this.zzat = zzl;
        this.zzbl = i;
    }

    /* access modifiers changed from: package-private */
    public final void zzf() throws RemoteException {
        this.zzaa.zzar.getTestFlag(this.zzat, this.zzbl);
    }

    /* access modifiers changed from: protected */
    public final void zzk() {
        this.zzat.zzb((Bundle) null);
    }
}
