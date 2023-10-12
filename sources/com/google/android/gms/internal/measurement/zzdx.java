package com.google.android.gms.internal.measurement;

final class zzdx {
    private final byte[] buffer;
    private final zzee zzadn;

    private zzdx(int i) {
        byte[] bArr = new byte[i];
        this.buffer = bArr;
        this.zzadn = zzee.zzf(bArr);
    }

    public final zzdp zzse() {
        this.zzadn.zzth();
        return new zzdz(this.buffer);
    }

    public final zzee zzsf() {
        return this.zzadn;
    }

    /* synthetic */ zzdx(int i, zzdo zzdo) {
        this(i);
    }
}
