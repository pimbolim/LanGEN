package com.google.android.gms.internal.measurement;

import java.io.IOException;

abstract class zzhp<T, B> {
    zzhp() {
    }

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, zzdp zzdp);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, T t);

    /* access modifiers changed from: package-private */
    public abstract void zza(T t, zzim zzim) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract boolean zza(zzgy zzgy);

    /* access modifiers changed from: package-private */
    public abstract void zzb(B b, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzc(B b, int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract void zzc(T t, zzim zzim) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zze(Object obj, T t);

    /* access modifiers changed from: package-private */
    public abstract void zzf(Object obj, B b);

    /* access modifiers changed from: package-private */
    public abstract T zzg(T t, T t2);

    /* access modifiers changed from: package-private */
    public abstract void zzj(Object obj);

    /* access modifiers changed from: package-private */
    public abstract T zzp(B b);

    /* access modifiers changed from: package-private */
    public abstract int zzt(T t);

    /* access modifiers changed from: package-private */
    public abstract B zzwp();

    /* access modifiers changed from: package-private */
    public abstract T zzx(Object obj);

    /* access modifiers changed from: package-private */
    public abstract B zzy(Object obj);

    /* access modifiers changed from: package-private */
    public abstract int zzz(T t);

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f A[LOOP:0: B:16:0x002f->B:19:0x003c, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(B r7, com.google.android.gms.internal.measurement.zzgy r8) throws java.io.IOException {
        /*
            r6 = this;
            int r0 = r8.getTag()
            int r1 = r0 >>> 3
            r0 = r0 & 7
            r2 = 1
            if (r0 == 0) goto L_0x0061
            if (r0 == r2) goto L_0x0059
            r3 = 2
            if (r0 == r3) goto L_0x0051
            r3 = 4
            r4 = 3
            if (r0 == r4) goto L_0x0028
            if (r0 == r3) goto L_0x0026
            r3 = 5
            if (r0 != r3) goto L_0x0021
            int r8 = r8.zzsl()
            r6.zzc(r7, r1, r8)
            return r2
        L_0x0021:
            com.google.android.gms.internal.measurement.zzfh r7 = com.google.android.gms.internal.measurement.zzfi.zzuy()
            throw r7
        L_0x0026:
            r7 = 0
            return r7
        L_0x0028:
            java.lang.Object r0 = r6.zzwp()
            int r4 = r1 << 3
            r3 = r3 | r4
        L_0x002f:
            int r4 = r8.zzsy()
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x003e
            boolean r4 = r6.zza(r0, (com.google.android.gms.internal.measurement.zzgy) r8)
            if (r4 != 0) goto L_0x002f
        L_0x003e:
            int r8 = r8.getTag()
            if (r3 != r8) goto L_0x004c
            java.lang.Object r8 = r6.zzp(r0)
            r6.zza(r7, (int) r1, r8)
            return r2
        L_0x004c:
            com.google.android.gms.internal.measurement.zzfi r7 = com.google.android.gms.internal.measurement.zzfi.zzux()
            throw r7
        L_0x0051:
            com.google.android.gms.internal.measurement.zzdp r8 = r8.zzso()
            r6.zza(r7, (int) r1, (com.google.android.gms.internal.measurement.zzdp) r8)
            return r2
        L_0x0059:
            long r3 = r8.zzsk()
            r6.zzb(r7, r1, r3)
            return r2
        L_0x0061:
            long r3 = r8.zzsi()
            r6.zza(r7, (int) r1, (long) r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhp.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzgy):boolean");
    }
}
