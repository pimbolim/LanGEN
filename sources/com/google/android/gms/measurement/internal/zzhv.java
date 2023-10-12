package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.time.DateUtils;

public final class zzhv extends zzg {
    /* access modifiers changed from: private */
    public final zzin zzre;
    /* access modifiers changed from: private */
    public zzdx zzrf;
    private volatile Boolean zzrg;
    private final zzaa zzrh;
    private final zzjd zzri;
    private final List<Runnable> zzrj = new ArrayList();
    private final zzaa zzrk;

    protected zzhv(zzfj zzfj) {
        super(zzfj);
        this.zzri = new zzjd(zzfj.zzx());
        this.zzre = new zzin(this);
        this.zzrh = new zzhu(this, zzfj);
        this.zzrk = new zzif(this, zzfj);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbk() {
        return false;
    }

    public final boolean isConnected() {
        zzo();
        zzbi();
        return this.zzrf != null;
    }

    /* access modifiers changed from: protected */
    public final void zzip() {
        zzo();
        zzbi();
        zzd((Runnable) new zzie(this, zzi(true)));
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzdx zzdx, AbstractSafeParcelable abstractSafeParcelable, zzn zzn) {
        int i;
        List<AbstractSafeParcelable> zzc;
        zzo();
        zzm();
        zzbi();
        boolean zziq = zziq();
        int i2 = 0;
        int i3 = 100;
        while (i2 < 1001 && i3 == 100) {
            ArrayList arrayList = new ArrayList();
            if (!zziq || (zzc = zzu().zzc(100)) == null) {
                i = 0;
            } else {
                arrayList.addAll(zzc);
                i = zzc.size();
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList2.get(i4);
                i4++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzai) {
                    try {
                        zzdx.zza((zzai) abstractSafeParcelable2, zzn);
                    } catch (RemoteException e) {
                        zzab().zzgk().zza("Failed to send event to the service", e);
                    }
                } else if (abstractSafeParcelable2 instanceof zzjn) {
                    try {
                        zzdx.zza((zzjn) abstractSafeParcelable2, zzn);
                    } catch (RemoteException e2) {
                        zzab().zzgk().zza("Failed to send attribute to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzq) {
                    try {
                        zzdx.zza((zzq) abstractSafeParcelable2, zzn);
                    } catch (RemoteException e3) {
                        zzab().zzgk().zza("Failed to send conditional property to the service", e3);
                    }
                } else {
                    zzab().zzgk().zzao("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i3 = i;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzc(zzai zzai, String str) {
        Preconditions.checkNotNull(zzai);
        zzo();
        zzbi();
        boolean zziq = zziq();
        zzd((Runnable) new zzih(this, zziq, zziq && zzu().zza(zzai), zzai, zzi(true), str));
    }

    /* access modifiers changed from: protected */
    public final void zzd(zzq zzq) {
        Preconditions.checkNotNull(zzq);
        zzo();
        zzbi();
        zzae();
        zzd((Runnable) new zzig(this, true, zzu().zzc(zzq), new zzq(zzq), zzi(true), zzq));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzq>> atomicReference, String str, String str2, String str3) {
        zzo();
        zzbi();
        zzd((Runnable) new zzij(this, atomicReference, str, str2, str3, zzi(false)));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzp zzp, String str, String str2) {
        zzo();
        zzbi();
        zzd((Runnable) new zzii(this, str, str2, zzi(false), zzp));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzjn>> atomicReference, String str, String str2, String str3, boolean z) {
        zzo();
        zzbi();
        zzd((Runnable) new zzil(this, atomicReference, str, str2, str3, z, zzi(false)));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzp zzp, String str, String str2, boolean z) {
        zzo();
        zzbi();
        zzd((Runnable) new zzik(this, str, str2, z, zzi(false), zzp));
    }

    /* access modifiers changed from: protected */
    public final void zzb(zzjn zzjn) {
        zzo();
        zzbi();
        zzd((Runnable) new zzhx(this, zziq() && zzu().zza(zzjn), zzjn, zzi(true)));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzjn>> atomicReference, boolean z) {
        zzo();
        zzbi();
        zzd((Runnable) new zzhw(this, atomicReference, zzi(false), z));
    }

    /* access modifiers changed from: protected */
    public final void resetAnalyticsData() {
        zzo();
        zzm();
        zzbi();
        zzn zzi = zzi(false);
        if (zziq()) {
            zzu().resetAnalyticsData();
        }
        zzd((Runnable) new zzhz(this, zzi));
    }

    private final boolean zziq() {
        zzae();
        return true;
    }

    public final void zza(AtomicReference<String> atomicReference) {
        zzo();
        zzbi();
        zzd((Runnable) new zzhy(this, atomicReference, zzi(false)));
    }

    public final void getAppInstanceId(zzp zzp) {
        zzo();
        zzbi();
        zzd((Runnable) new zzib(this, zzi(false), zzp));
    }

    /* access modifiers changed from: protected */
    public final void zzim() {
        zzo();
        zzbi();
        zzn zzi = zzi(true);
        boolean zza = zzad().zza(zzak.zzjd);
        if (zza) {
            zzu().zzgh();
        }
        zzd((Runnable) new zzia(this, zzi, zza));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzhr zzhr) {
        zzo();
        zzbi();
        zzd((Runnable) new zzid(this, zzhr));
    }

    /* access modifiers changed from: private */
    public final void zzir() {
        zzo();
        this.zzri.start();
        this.zzrh.zzv(zzak.zzhl.get(null).longValue());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzis() {
        /*
            r6 = this;
            r6.zzo()
            r6.zzbi()
            boolean r0 = r6.isConnected()
            if (r0 == 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.Boolean r0 = r6.zzrg
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0119
            r6.zzo()
            r6.zzbi()
            com.google.android.gms.measurement.internal.zzeo r0 = r6.zzac()
            java.lang.Boolean r0 = r0.zzhe()
            if (r0 == 0) goto L_0x002c
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x002c
            r0 = 1
            goto L_0x0113
        L_0x002c:
            r6.zzae()
            com.google.android.gms.measurement.internal.zzdy r0 = r6.zzr()
            int r0 = r0.zzgg()
            if (r0 != r2) goto L_0x003d
        L_0x0039:
            r0 = 1
        L_0x003a:
            r3 = 1
            goto L_0x00f0
        L_0x003d:
            com.google.android.gms.measurement.internal.zzef r0 = r6.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgs()
            java.lang.String r3 = "Checking service availability"
            r0.zzao(r3)
            com.google.android.gms.measurement.internal.zzjs r0 = r6.zzz()
            r3 = 12451000(0xbdfcb8, float:1.7447567E-38)
            int r0 = r0.zzd((int) r3)
            if (r0 == 0) goto L_0x00e1
            if (r0 == r2) goto L_0x00d1
            r3 = 2
            if (r0 == r3) goto L_0x00a5
            r3 = 3
            if (r0 == r3) goto L_0x0095
            r3 = 9
            if (r0 == r3) goto L_0x0087
            r3 = 18
            if (r0 == r3) goto L_0x0079
            com.google.android.gms.measurement.internal.zzef r3 = r6.zzab()
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgn()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r4 = "Unexpected service status"
            r3.zza(r4, r0)
            goto L_0x00a2
        L_0x0079:
            com.google.android.gms.measurement.internal.zzef r0 = r6.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgn()
            java.lang.String r3 = "Service updating"
            r0.zzao(r3)
            goto L_0x0039
        L_0x0087:
            com.google.android.gms.measurement.internal.zzef r0 = r6.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgn()
            java.lang.String r3 = "Service invalid"
            r0.zzao(r3)
            goto L_0x00a2
        L_0x0095:
            com.google.android.gms.measurement.internal.zzef r0 = r6.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgn()
            java.lang.String r3 = "Service disabled"
            r0.zzao(r3)
        L_0x00a2:
            r0 = 0
        L_0x00a3:
            r3 = 0
            goto L_0x00f0
        L_0x00a5:
            com.google.android.gms.measurement.internal.zzef r0 = r6.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgr()
            java.lang.String r3 = "Service container out of date"
            r0.zzao(r3)
            com.google.android.gms.measurement.internal.zzjs r0 = r6.zzz()
            int r0 = r0.zzjx()
            r3 = 15300(0x3bc4, float:2.144E-41)
            if (r0 >= r3) goto L_0x00bf
            goto L_0x00de
        L_0x00bf:
            com.google.android.gms.measurement.internal.zzeo r0 = r6.zzac()
            java.lang.Boolean r0 = r0.zzhe()
            if (r0 == 0) goto L_0x00cf
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00a2
        L_0x00cf:
            r0 = 1
            goto L_0x00a3
        L_0x00d1:
            com.google.android.gms.measurement.internal.zzef r0 = r6.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgs()
            java.lang.String r3 = "Service missing"
            r0.zzao(r3)
        L_0x00de:
            r0 = 0
            goto L_0x003a
        L_0x00e1:
            com.google.android.gms.measurement.internal.zzef r0 = r6.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgs()
            java.lang.String r3 = "Service available"
            r0.zzao(r3)
            goto L_0x0039
        L_0x00f0:
            if (r0 != 0) goto L_0x010a
            com.google.android.gms.measurement.internal.zzs r4 = r6.zzad()
            boolean r4 = r4.zzbw()
            if (r4 == 0) goto L_0x010a
            com.google.android.gms.measurement.internal.zzef r3 = r6.zzab()
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()
            java.lang.String r4 = "No way to upload. Consider using the full version of Analytics"
            r3.zzao(r4)
            r3 = 0
        L_0x010a:
            if (r3 == 0) goto L_0x0113
            com.google.android.gms.measurement.internal.zzeo r3 = r6.zzac()
            r3.zzd(r0)
        L_0x0113:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r6.zzrg = r0
        L_0x0119:
            java.lang.Boolean r0 = r6.zzrg
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0127
            com.google.android.gms.measurement.internal.zzin r0 = r6.zzre
            r0.zzix()
            return
        L_0x0127:
            com.google.android.gms.measurement.internal.zzs r0 = r6.zzad()
            boolean r0 = r0.zzbw()
            if (r0 != 0) goto L_0x0185
            r6.zzae()
            android.content.Context r0 = r6.getContext()
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            android.content.Intent r3 = new android.content.Intent
            r3.<init>()
            android.content.Context r4 = r6.getContext()
            java.lang.String r5 = "com.google.android.gms.measurement.AppMeasurementService"
            android.content.Intent r3 = r3.setClassName(r4, r5)
            r4 = 65536(0x10000, float:9.18355E-41)
            java.util.List r0 = r0.queryIntentServices(r3, r4)
            if (r0 == 0) goto L_0x015a
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x015a
            r1 = 1
        L_0x015a:
            if (r1 == 0) goto L_0x0178
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.google.android.gms.measurement.START"
            r0.<init>(r1)
            android.content.ComponentName r1 = new android.content.ComponentName
            android.content.Context r2 = r6.getContext()
            r6.zzae()
            r1.<init>(r2, r5)
            r0.setComponent(r1)
            com.google.android.gms.measurement.internal.zzin r1 = r6.zzre
            r1.zzb(r0)
            return
        L_0x0178:
            com.google.android.gms.measurement.internal.zzef r0 = r6.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgk()
            java.lang.String r1 = "Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest"
            r0.zzao(r1)
        L_0x0185:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhv.zzis():void");
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzit() {
        return this.zzrg;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzdx zzdx) {
        zzo();
        Preconditions.checkNotNull(zzdx);
        this.zzrf = zzdx;
        zzir();
        zziv();
    }

    public final void disconnect() {
        zzo();
        zzbi();
        this.zzre.zziw();
        try {
            ConnectionTracker.getInstance().unbindService(getContext(), this.zzre);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzrf = null;
    }

    /* access modifiers changed from: private */
    public final void onServiceDisconnected(ComponentName componentName) {
        zzo();
        if (this.zzrf != null) {
            this.zzrf = null;
            zzab().zzgs().zza("Disconnected from device MeasurementService", componentName);
            zzo();
            zzis();
        }
    }

    /* access modifiers changed from: private */
    public final void zziu() {
        zzo();
        if (isConnected()) {
            zzab().zzgs().zzao("Inactivity, disconnecting from the service");
            disconnect();
        }
    }

    private final void zzd(Runnable runnable) throws IllegalStateException {
        zzo();
        if (isConnected()) {
            runnable.run();
        } else if (((long) this.zzrj.size()) >= 1000) {
            zzab().zzgk().zzao("Discarding data. Max runnable queue size reached");
        } else {
            this.zzrj.add(runnable);
            this.zzrk.zzv(DateUtils.MILLIS_PER_MINUTE);
            zzis();
        }
    }

    /* access modifiers changed from: private */
    public final void zziv() {
        zzo();
        zzab().zzgs().zza("Processing queued up service tasks", Integer.valueOf(this.zzrj.size()));
        for (Runnable run : this.zzrj) {
            try {
                run.run();
            } catch (Exception e) {
                zzab().zzgk().zza("Task exception while flushing queue", e);
            }
        }
        this.zzrj.clear();
        this.zzrk.cancel();
    }

    private final zzn zzi(boolean z) {
        zzae();
        return zzr().zzai(z ? zzab().zzgu() : null);
    }

    public final void zza(zzp zzp, zzai zzai, String str) {
        zzo();
        zzbi();
        if (zzz().zzd((int) GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            zzab().zzgn().zzao("Not bundling data. Service unavailable or out of date");
            zzz().zza(zzp, new byte[0]);
            return;
        }
        zzd((Runnable) new zzic(this, zzai, str, zzp));
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

    public final /* bridge */ /* synthetic */ zza zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzgp zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzdy zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzhv zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzhq zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzeb zzu() {
        return super.zzu();
    }

    public final /* bridge */ /* synthetic */ zziw zzv() {
        return super.zzv();
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
