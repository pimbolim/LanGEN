package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.measurement.internal.zzix;

public final class zzit<T extends Context & zzix> {
    private final T zzrz;

    public zzit(T t) {
        Preconditions.checkNotNull(t);
        this.zzrz = t;
    }

    public final void onCreate() {
        zzfj zza = zzfj.zza((Context) this.zzrz, (zzx) null);
        zzef zzab = zza.zzab();
        zza.zzae();
        zzab.zzgs().zzao("Local AppMeasurementService is starting up");
    }

    public final void onDestroy() {
        zzfj zza = zzfj.zza((Context) this.zzrz, (zzx) null);
        zzef zzab = zza.zzab();
        zza.zzae();
        zzab.zzgs().zzao("Local AppMeasurementService is shutting down");
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        zzfj zza = zzfj.zza((Context) this.zzrz, (zzx) null);
        zzef zzab = zza.zzab();
        if (intent == null) {
            zzab.zzgn().zzao("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zza.zzae();
        zzab.zzgs().zza("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zze(new zzis(this, i2, zzab, intent));
        }
        return 2;
    }

    private final void zze(Runnable runnable) {
        zzjg zzm = zzjg.zzm(this.zzrz);
        zzm.zzaa().zza((Runnable) new zziu(this, zzm, runnable));
    }

    public final IBinder onBind(Intent intent) {
        if (intent == null) {
            zzab().zzgk().zzao("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzfk(zzjg.zzm(this.zzrz));
        }
        zzab().zzgn().zza("onBind received unknown action", action);
        return null;
    }

    public final boolean onUnbind(Intent intent) {
        if (intent == null) {
            zzab().zzgk().zzao("onUnbind called with null intent");
            return true;
        }
        zzab().zzgs().zza("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    public final boolean onStartJob(JobParameters jobParameters) {
        zzfj zza = zzfj.zza((Context) this.zzrz, (zzx) null);
        zzef zzab = zza.zzab();
        String string = jobParameters.getExtras().getString("action");
        zza.zzae();
        zzab.zzgs().zza("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zze(new zziv(this, zzab, jobParameters));
        return true;
    }

    public final void onRebind(Intent intent) {
        if (intent == null) {
            zzab().zzgk().zzao("onRebind called with null intent");
            return;
        }
        zzab().zzgs().zza("onRebind called. action", intent.getAction());
    }

    private final zzef zzab() {
        return zzfj.zza((Context) this.zzrz, (zzx) null).zzab();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzef zzef, JobParameters jobParameters) {
        zzef.zzgs().zzao("AppMeasurementJobService processed last upload request.");
        ((zzix) this.zzrz).zza(jobParameters, false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(int i, zzef zzef, Intent intent) {
        if (((zzix) this.zzrz).zza(i)) {
            zzef.zzgs().zza("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzab().zzgs().zzao("Completed wakeful intent.");
            ((zzix) this.zzrz).zza(intent);
        }
    }
}
