package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey;

public final class zzbq {

    public static final class zza extends zzey<zza, C0001zza> implements zzgk {
        private static volatile zzgr<zza> zzuo;
        /* access modifiers changed from: private */
        public static final zza zzwa;
        private int zzue;
        private String zzvy = "";
        private String zzvz = "";

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.measurement.zzbq$zza$zza  reason: collision with other inner class name */
        public static final class C0001zza extends zzey.zza<zza, C0001zza> implements zzgk {
            private C0001zza() {
                super(zza.zzwa);
            }

            /* synthetic */ C0001zza(zzbp zzbp) {
                this();
            }
        }

        public final String getKey() {
            return this.zzvy;
        }

        public final String getValue() {
            return this.zzvz;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbp.zzud[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0001zza((zzbp) null);
                case 3:
                    return zza((zzgi) zzwa, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"zzue", "zzvy", "zzvz"});
                case 4:
                    return zzwa;
                case 5:
                    zzgr<zza> zzgr = zzuo;
                    if (zzgr == null) {
                        synchronized (zza.class) {
                            zzgr = zzuo;
                            if (zzgr == null) {
                                zzgr = new zzey.zzc<>(zzwa);
                                zzuo = zzgr;
                            }
                        }
                    }
                    return zzgr;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzgr<zza> zzkj() {
            return (zzgr) zzwa.zza(zzey.zzd.zzaij, (Object) null, (Object) null);
        }

        static {
            zza zza = new zza();
            zzwa = zza;
            zzey.zza(zza.class, zza);
        }
    }
}
