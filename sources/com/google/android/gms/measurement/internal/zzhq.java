package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.stripe.android.stripe3ds2.transactions.MessageExtension;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class zzhq extends zzg {
    protected zzhr zzqo;
    private volatile zzhr zzqp;
    private zzhr zzqq;
    private final Map<Activity, zzhr> zzqr = new ArrayMap();
    private zzhr zzqs;
    private String zzqt;

    public zzhq(zzfj zzfj) {
        super(zzfj);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbk() {
        return false;
    }

    public final zzhr zzin() {
        zzbi();
        zzo();
        return this.zzqo;
    }

    public final void setCurrentScreen(Activity activity, String str, String str2) {
        if (this.zzqp == null) {
            zzab().zzgp().zzao("setCurrentScreen cannot be called while no activity active");
        } else if (this.zzqr.get(activity) == null) {
            zzab().zzgp().zzao("setCurrentScreen must be called with an activity in the activity lifecycle");
        } else {
            if (str2 == null) {
                str2 = zzbh(activity.getClass().getCanonicalName());
            }
            boolean equals = this.zzqp.zzqv.equals(str2);
            boolean zzs = zzjs.zzs(this.zzqp.zzqu, str);
            if (equals && zzs) {
                zzab().zzgp().zzao("setCurrentScreen cannot be called with the same class and name");
            } else if (str != null && (str.length() <= 0 || str.length() > 100)) {
                zzab().zzgp().zza("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            } else if (str2 == null || (str2.length() > 0 && str2.length() <= 100)) {
                zzab().zzgs().zza("Setting current screen to name, class", str == null ? AbstractJsonLexerKt.NULL : str, str2);
                zzhr zzhr = new zzhr(str, str2, zzz().zzjv());
                this.zzqr.put(activity, zzhr);
                zza(activity, zzhr, true);
            } else {
                zzab().zzgp().zza("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            }
        }
    }

    public final zzhr zzio() {
        zzm();
        return this.zzqp;
    }

    private final void zza(Activity activity, zzhr zzhr, boolean z) {
        zzhr zzhr2 = this.zzqp == null ? this.zzqq : this.zzqp;
        if (zzhr.zzqv == null) {
            zzhr = new zzhr(zzhr.zzqu, zzbh(activity.getClass().getCanonicalName()), zzhr.zzqw);
        }
        this.zzqq = this.zzqp;
        this.zzqp = zzhr;
        zzaa().zza((Runnable) new zzht(this, z, zzhr2, zzhr));
    }

    /* access modifiers changed from: private */
    public final void zza(zzhr zzhr, boolean z) {
        zzp().zzc(zzx().elapsedRealtime());
        if (zzv().zza(zzhr.zzqx, z)) {
            zzhr.zzqx = false;
        }
    }

    public static void zza(zzhr zzhr, Bundle bundle, boolean z) {
        if (bundle != null && zzhr != null && (!bundle.containsKey("_sc") || z)) {
            if (zzhr.zzqu != null) {
                bundle.putString("_sn", zzhr.zzqu);
            } else {
                bundle.remove("_sn");
            }
            bundle.putString("_sc", zzhr.zzqv);
            bundle.putLong("_si", zzhr.zzqw);
        } else if (bundle != null && zzhr == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    public final void zza(String str, zzhr zzhr) {
        zzo();
        synchronized (this) {
            String str2 = this.zzqt;
            if (str2 == null || str2.equals(str) || zzhr != null) {
                this.zzqt = str;
                this.zzqs = zzhr;
            }
        }
    }

    private static String zzbh(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    private final zzhr zza(Activity activity) {
        Preconditions.checkNotNull(activity);
        zzhr zzhr = this.zzqr.get(activity);
        if (zzhr != null) {
            return zzhr;
        }
        zzhr zzhr2 = new zzhr((String) null, zzbh(activity.getClass().getCanonicalName()), zzz().zzjv());
        this.zzqr.put(activity, zzhr2);
        return zzhr2;
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (bundle != null && (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) != null) {
            this.zzqr.put(activity, new zzhr(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong(MessageExtension.FIELD_ID)));
        }
    }

    public final void onActivityResumed(Activity activity) {
        zza(activity, zza(activity), false);
        zza zzp = zzp();
        zzp.zzaa().zza((Runnable) new zze(zzp, zzp.zzx().elapsedRealtime()));
    }

    public final void onActivityPaused(Activity activity) {
        zzhr zza = zza(activity);
        this.zzqq = this.zzqp;
        this.zzqp = null;
        zzaa().zza((Runnable) new zzhs(this, zza));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzhr zzhr;
        if (bundle != null && (zzhr = this.zzqr.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong(MessageExtension.FIELD_ID, zzhr.zzqw);
            bundle2.putString("name", zzhr.zzqu);
            bundle2.putString("referrer_name", zzhr.zzqv);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zzqr.remove(activity);
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
