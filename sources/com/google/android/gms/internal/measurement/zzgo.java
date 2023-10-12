package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zzgo<T> implements zzgx<T> {
    private final zzgi zzakn;
    private final boolean zzako;
    private final zzhp<?, ?> zzakx;
    private final zzen<?> zzaky;

    private zzgo(zzhp<?, ?> zzhp, zzen<?> zzen, zzgi zzgi) {
        this.zzakx = zzhp;
        this.zzako = zzen.zze(zzgi);
        this.zzaky = zzen;
        this.zzakn = zzgi;
    }

    static <T> zzgo<T> zza(zzhp<?, ?> zzhp, zzen<?> zzen, zzgi zzgi) {
        return new zzgo<>(zzhp, zzen, zzgi);
    }

    public final T newInstance() {
        return this.zzakn.zzup().zzuf();
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzakx.zzx(t).equals(this.zzakx.zzx(t2))) {
            return false;
        }
        if (this.zzako) {
            return this.zzaky.zzh(t).equals(this.zzaky.zzh(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzakx.zzx(t).hashCode();
        return this.zzako ? (hashCode * 53) + this.zzaky.zzh(t).hashCode() : hashCode;
    }

    public final void zzc(T t, T t2) {
        zzgz.zza(this.zzakx, t, t2);
        if (this.zzako) {
            zzgz.zza(this.zzaky, t, t2);
        }
    }

    public final void zza(T t, zzim zzim) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zzaky.zzh(t).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzeq zzeq = (zzeq) next.getKey();
            if (zzeq.zztx() != zzij.MESSAGE || zzeq.zzty() || zzeq.zztz()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzfl) {
                zzim.zza(zzeq.zzlg(), (Object) ((zzfl) next).zzve().zzrs());
            } else {
                zzim.zza(zzeq.zzlg(), next.getValue());
            }
        }
        zzhp<?, ?> zzhp = this.zzakx;
        zzhp.zzc(zzhp.zzx(t), zzim);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.measurement.zzey$zze} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.measurement.zzdk r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.measurement.zzey r0 = (com.google.android.gms.internal.measurement.zzey) r0
            com.google.android.gms.internal.measurement.zzhs r1 = r0.zzahz
            com.google.android.gms.internal.measurement.zzhs r2 = com.google.android.gms.internal.measurement.zzhs.zzwq()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.measurement.zzhs r1 = com.google.android.gms.internal.measurement.zzhs.zzwr()
            r0.zzahz = r1
        L_0x0011:
            com.google.android.gms.internal.measurement.zzey$zzb r10 = (com.google.android.gms.internal.measurement.zzey.zzb) r10
            r10.zzuq()
            r10 = 0
            r0 = r10
        L_0x0018:
            if (r12 >= r13) goto L_0x00a4
            int r4 = com.google.android.gms.internal.measurement.zzdl.zza(r11, r12, r14)
            int r2 = r14.zzada
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L_0x0051
            r12 = r2 & 7
            if (r12 != r3) goto L_0x004c
            com.google.android.gms.internal.measurement.zzen<?> r12 = r9.zzaky
            com.google.android.gms.internal.measurement.zzel r0 = r14.zzadd
            com.google.android.gms.internal.measurement.zzgi r3 = r9.zzakn
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.measurement.zzey$zze r0 = (com.google.android.gms.internal.measurement.zzey.zze) r0
            if (r0 != 0) goto L_0x0043
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.measurement.zzdl.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzhs) r6, (com.google.android.gms.internal.measurement.zzdk) r7)
            goto L_0x0018
        L_0x0043:
            com.google.android.gms.internal.measurement.zzgt.zzvy()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x004c:
            int r12 = com.google.android.gms.internal.measurement.zzdl.zza((int) r2, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.measurement.zzdk) r14)
            goto L_0x0018
        L_0x0051:
            r12 = 0
            r2 = r10
        L_0x0053:
            if (r4 >= r13) goto L_0x0099
            int r4 = com.google.android.gms.internal.measurement.zzdl.zza(r11, r4, r14)
            int r5 = r14.zzada
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L_0x007b
            r8 = 3
            if (r6 == r8) goto L_0x0065
            goto L_0x0090
        L_0x0065:
            if (r0 != 0) goto L_0x0072
            if (r7 != r3) goto L_0x0090
            int r4 = com.google.android.gms.internal.measurement.zzdl.zze(r11, r4, r14)
            java.lang.Object r2 = r14.zzadc
            com.google.android.gms.internal.measurement.zzdp r2 = (com.google.android.gms.internal.measurement.zzdp) r2
            goto L_0x0053
        L_0x0072:
            com.google.android.gms.internal.measurement.zzgt.zzvy()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x007b:
            if (r7 != 0) goto L_0x0090
            int r4 = com.google.android.gms.internal.measurement.zzdl.zza(r11, r4, r14)
            int r12 = r14.zzada
            com.google.android.gms.internal.measurement.zzen<?> r0 = r9.zzaky
            com.google.android.gms.internal.measurement.zzel r5 = r14.zzadd
            com.google.android.gms.internal.measurement.zzgi r6 = r9.zzakn
            java.lang.Object r0 = r0.zza(r5, r6, r12)
            com.google.android.gms.internal.measurement.zzey$zze r0 = (com.google.android.gms.internal.measurement.zzey.zze) r0
            goto L_0x0053
        L_0x0090:
            r6 = 12
            if (r5 == r6) goto L_0x0099
            int r4 = com.google.android.gms.internal.measurement.zzdl.zza((int) r5, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.measurement.zzdk) r14)
            goto L_0x0053
        L_0x0099:
            if (r2 == 0) goto L_0x00a1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zzb((int) r12, (java.lang.Object) r2)
        L_0x00a1:
            r12 = r4
            goto L_0x0018
        L_0x00a4:
            if (r12 != r13) goto L_0x00a7
            return
        L_0x00a7:
            com.google.android.gms.internal.measurement.zzfi r10 = com.google.android.gms.internal.measurement.zzfi.zzva()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgo.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzdk):void");
    }

    public final void zza(T t, zzgy zzgy, zzel zzel) throws IOException {
        boolean z;
        zzhp<?, ?> zzhp = this.zzakx;
        zzen<?> zzen = this.zzaky;
        Object zzy = zzhp.zzy(t);
        zzeo<?> zzi = zzen.zzi(t);
        do {
            try {
                if (zzgy.zzsy() == Integer.MAX_VALUE) {
                    zzhp.zzf(t, zzy);
                    return;
                }
                int tag = zzgy.getTag();
                if (tag == 11) {
                    int i = 0;
                    Object obj = null;
                    zzdp zzdp = null;
                    while (zzgy.zzsy() != Integer.MAX_VALUE) {
                        int tag2 = zzgy.getTag();
                        if (tag2 == 16) {
                            i = zzgy.zzsp();
                            obj = zzen.zza(zzel, this.zzakn, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzen.zza(zzgy, obj, zzel, zzi);
                            } else {
                                zzdp = zzgy.zzso();
                            }
                        } else if (!zzgy.zzsz()) {
                            break;
                        }
                    }
                    if (zzgy.getTag() != 12) {
                        throw zzfi.zzux();
                    } else if (zzdp != null) {
                        if (obj != null) {
                            zzen.zza(zzdp, obj, zzel, zzi);
                        } else {
                            zzhp.zza(zzy, i, zzdp);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzen.zza(zzel, this.zzakn, tag >>> 3);
                    if (zza != null) {
                        zzen.zza(zzgy, zza, zzel, zzi);
                    } else {
                        z = zzhp.zza(zzy, zzgy);
                        continue;
                    }
                } else {
                    z = zzgy.zzsz();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzhp.zzf(t, zzy);
            }
        } while (z);
    }

    public final void zzj(T t) {
        this.zzakx.zzj(t);
        this.zzaky.zzj(t);
    }

    public final boolean zzv(T t) {
        return this.zzaky.zzh(t).isInitialized();
    }

    public final int zzt(T t) {
        zzhp<?, ?> zzhp = this.zzakx;
        int zzz = zzhp.zzz(zzhp.zzx(t)) + 0;
        return this.zzako ? zzz + this.zzaky.zzh(t).zzts() : zzz;
    }
}
