package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzz;

final class zzar extends zzz.zzb {
    private final /* synthetic */ zzz zzaa;
    private final /* synthetic */ String zzas;
    private final /* synthetic */ zzl zzat;
    private final /* synthetic */ boolean zzbi;
    private final /* synthetic */ String zzx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzar(zzz zzz, String str, String str2, boolean z, zzl zzl) {
        super(zzz);
        this.zzaa = zzz;
        this.zzx = str;
        this.zzas = str2;
        this.zzbi = z;
        this.zzat = zzl;
    }

    /* access modifiers changed from: package-private */
    public final void zzf() throws RemoteException {
        this.zzaa.zzar.getUserProperties(this.zzx, this.zzas, this.zzbi, this.zzat);
    }

    /* access modifiers changed from: protected */
    public final void zzk() {
        this.zzat.zzb((Bundle) null);
    }
}
