package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.braintreepayments.api.models.ThreeDSecureRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.InvocationTargetException;

public final class zzs extends zzgf {
    private Boolean zzeb;
    private zzu zzec = zzv.zzee;
    private Boolean zzed;

    zzs(zzfj zzfj) {
        super(zzfj);
        zzak.zza(zzfj);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzu zzu) {
        this.zzec = zzu;
    }

    static String zzbm() {
        return zzak.zzgf.get(null);
    }

    public final int zzi(String str) {
        return zzb(str, zzak.zzgt);
    }

    public final long zzao() {
        zzae();
        return 16250;
    }

    public final boolean zzbn() {
        if (this.zzed == null) {
            synchronized (this) {
                if (this.zzed == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzed = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.zzed == null) {
                        this.zzed = Boolean.TRUE;
                        zzab().zzgk().zzao("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzed.booleanValue();
    }

    public final long zza(String str, zzdu<Long> zzdu) {
        if (str == null) {
            return zzdu.get(null).longValue();
        }
        String zzb = this.zzec.zzb(str, zzdu.getKey());
        if (TextUtils.isEmpty(zzb)) {
            return zzdu.get(null).longValue();
        }
        try {
            return zzdu.get(Long.valueOf(Long.parseLong(zzb))).longValue();
        } catch (NumberFormatException unused) {
            return zzdu.get(null).longValue();
        }
    }

    public final int zzb(String str, zzdu<Integer> zzdu) {
        if (str == null) {
            return zzdu.get(null).intValue();
        }
        String zzb = this.zzec.zzb(str, zzdu.getKey());
        if (TextUtils.isEmpty(zzb)) {
            return zzdu.get(null).intValue();
        }
        try {
            return zzdu.get(Integer.valueOf(Integer.parseInt(zzb))).intValue();
        } catch (NumberFormatException unused) {
            return zzdu.get(null).intValue();
        }
    }

    public final double zzc(String str, zzdu<Double> zzdu) {
        if (str == null) {
            return zzdu.get(null).doubleValue();
        }
        String zzb = this.zzec.zzb(str, zzdu.getKey());
        if (TextUtils.isEmpty(zzb)) {
            return zzdu.get(null).doubleValue();
        }
        try {
            return zzdu.get(Double.valueOf(Double.parseDouble(zzb))).doubleValue();
        } catch (NumberFormatException unused) {
            return zzdu.get(null).doubleValue();
        }
    }

    public final boolean zzd(String str, zzdu<Boolean> zzdu) {
        if (str == null) {
            return zzdu.get(null).booleanValue();
        }
        String zzb = this.zzec.zzb(str, zzdu.getKey());
        if (TextUtils.isEmpty(zzb)) {
            return zzdu.get(null).booleanValue();
        }
        return zzdu.get(Boolean.valueOf(Boolean.parseBoolean(zzb))).booleanValue();
    }

    public final boolean zze(String str, zzdu<Boolean> zzdu) {
        return zzd(str, zzdu);
    }

    public final boolean zza(zzdu<Boolean> zzdu) {
        return zzd((String) null, zzdu);
    }

    private final Bundle zzbo() {
        try {
            if (getContext().getPackageManager() == null) {
                zzab().zzgk().zzao("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(getContext()).getApplicationInfo(getContext().getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            zzab().zzgk().zzao("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            zzab().zzgk().zza("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzj(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle zzbo = zzbo();
        if (zzbo == null) {
            zzab().zzgk().zzao("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!zzbo.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(zzbo.getBoolean(str));
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002b A[SYNTHETIC, Splitter:B:9:0x002b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> zzk(java.lang.String r4) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r0 = r3.zzbo()
            r1 = 0
            if (r0 != 0) goto L_0x0019
            com.google.android.gms.measurement.internal.zzef r4 = r3.zzab()
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgk()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.zzao(r0)
        L_0x0017:
            r4 = r1
            goto L_0x0028
        L_0x0019:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L_0x0020
            goto L_0x0017
        L_0x0020:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x0028:
            if (r4 != 0) goto L_0x002b
            return r1
        L_0x002b:
            android.content.Context r0 = r3.getContext()     // Catch:{ NotFoundException -> 0x0043 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ NotFoundException -> 0x0043 }
            int r4 = r4.intValue()     // Catch:{ NotFoundException -> 0x0043 }
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch:{ NotFoundException -> 0x0043 }
            if (r4 != 0) goto L_0x003e
            return r1
        L_0x003e:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ NotFoundException -> 0x0043 }
            return r4
        L_0x0043:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzef r0 = r3.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgk()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.zza(r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzs.zzk(java.lang.String):java.util.List");
    }

    public final boolean zzbp() {
        zzae();
        Boolean zzj = zzj("firebase_analytics_collection_deactivated");
        return zzj != null && zzj.booleanValue();
    }

    public final Boolean zzbq() {
        zzae();
        return zzj("firebase_analytics_collection_enabled");
    }

    public final Boolean zzbr() {
        zzm();
        Boolean zzj = zzj("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(zzj == null || zzj.booleanValue());
    }

    public static long zzbs() {
        return zzak.zzhi.get(null).longValue();
    }

    public static long zzbt() {
        return zzak.zzgi.get(null).longValue();
    }

    public final String zzbu() {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{"debug.firebase.analytics.app", ""});
        } catch (ClassNotFoundException e) {
            zzab().zzgk().zza("Could not find SystemProperties class", e);
            return "";
        } catch (NoSuchMethodException e2) {
            zzab().zzgk().zza("Could not find SystemProperties.get() method", e2);
            return "";
        } catch (IllegalAccessException e3) {
            zzab().zzgk().zza("Could not access SystemProperties.get()", e3);
            return "";
        } catch (InvocationTargetException e4) {
            zzab().zzgk().zza("SystemProperties.get() threw an exception", e4);
            return "";
        }
    }

    public static boolean zzbv() {
        return zzak.zzge.get(null).booleanValue();
    }

    public final boolean zzl(String str) {
        return ThreeDSecureRequest.VERSION_1.equals(this.zzec.zzb(str, "gaia_collection_enabled"));
    }

    public final boolean zzm(String str) {
        return ThreeDSecureRequest.VERSION_1.equals(this.zzec.zzb(str, "measurement.event_sampling_enabled"));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzn(String str) {
        return zzd(str, zzak.zzhs);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzo(String str) {
        return zzd(str, zzak.zzhm);
    }

    /* access modifiers changed from: package-private */
    public final String zzp(String str) {
        zzdu<String> zzdu = zzak.zzhn;
        if (str == null) {
            return zzdu.get(null);
        }
        return zzdu.get(this.zzec.zzb(str, zzdu.getKey()));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzq(String str) {
        return zzd(str, zzak.zzht);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzr(String str) {
        return zzd(str, zzak.zzhu);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzs(String str) {
        return zzd(str, zzak.zzhv);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzt(String str) {
        return zzd(str, zzak.zzhx);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzbw() {
        if (this.zzeb == null) {
            Boolean zzj = zzj("app_measurement_lite");
            this.zzeb = zzj;
            if (zzj == null) {
                this.zzeb = false;
            }
        }
        if (this.zzeb.booleanValue() || !this.zzj.zzia()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzu(String str) {
        return zzd(str, zzak.zzhw);
    }

    static boolean zzbx() {
        return zzak.zzhy.get(null).booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzv(String str) {
        return zzd(str, zzak.zzhz);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzw(String str) {
        return zzd(str, zzak.zzia);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzx(String str) {
        return zzd(str, zzak.zzib);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzy(String str) {
        return zzd(str, zzak.zzic);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzz(String str) {
        return zzd(str, zzak.zzih);
    }

    public final /* bridge */ /* synthetic */ void zzl() {
        super.zzl();
    }

    public final /* bridge */ /* synthetic */ void zzm() {
        super.zzm();
    }

    public final /* bridge */ /* synthetic */ void zzn() {
        super.zzn();
    }

    public final /* bridge */ /* synthetic */ void zzo() {
        super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzac zzw() {
        return super.zzw();
    }

    public final /* bridge */ /* synthetic */ Clock zzx() {
        return super.zzx();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final /* bridge */ /* synthetic */ zzed zzy() {
        return super.zzy();
    }

    public final /* bridge */ /* synthetic */ zzjs zzz() {
        return super.zzz();
    }

    public final /* bridge */ /* synthetic */ zzfc zzaa() {
        return super.zzaa();
    }

    public final /* bridge */ /* synthetic */ zzef zzab() {
        return super.zzab();
    }

    public final /* bridge */ /* synthetic */ zzeo zzac() {
        return super.zzac();
    }

    public final /* bridge */ /* synthetic */ zzs zzad() {
        return super.zzad();
    }

    public final /* bridge */ /* synthetic */ zzr zzae() {
        return super.zzae();
    }
}
