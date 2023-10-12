package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

final class zzf {
    private final String zzce;
    private String zzcf;
    private String zzcg;
    private String zzch;
    private String zzci;
    private long zzcj;
    private long zzck;
    private long zzcl;
    private String zzcm;
    private long zzcn;
    private String zzco;
    private long zzcp;
    private boolean zzcq;
    private long zzcr;
    private boolean zzcs;
    private boolean zzct;
    private String zzcu;
    private Boolean zzcv;
    private List<String> zzcw;
    private long zzcx;
    private long zzcy;
    private long zzcz;
    private long zzda;
    private long zzdb;
    private long zzdc;
    private String zzdd;
    private boolean zzde;
    private long zzdf;
    private long zzdg;
    private final zzfj zzj;
    private long zzr;
    private long zzs;

    zzf(zzfj zzfj, String str) {
        Preconditions.checkNotNull(zzfj);
        Preconditions.checkNotEmpty(str);
        this.zzj = zzfj;
        this.zzce = str;
        zzfj.zzaa().zzo();
    }

    public final void zzaf() {
        this.zzj.zzaa().zzo();
        this.zzde = false;
    }

    public final String zzag() {
        this.zzj.zzaa().zzo();
        return this.zzce;
    }

    public final String getAppInstanceId() {
        this.zzj.zzaa().zzo();
        return this.zzcf;
    }

    public final void zza(String str) {
        this.zzj.zzaa().zzo();
        this.zzde |= !zzjs.zzs(this.zzcf, str);
        this.zzcf = str;
    }

    public final String getGmpAppId() {
        this.zzj.zzaa().zzo();
        return this.zzcg;
    }

    public final void zzb(String str) {
        this.zzj.zzaa().zzo();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzde |= !zzjs.zzs(this.zzcg, str);
        this.zzcg = str;
    }

    public final String zzah() {
        this.zzj.zzaa().zzo();
        return this.zzcu;
    }

    public final void zzc(String str) {
        this.zzj.zzaa().zzo();
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzde |= !zzjs.zzs(this.zzcu, str);
        this.zzcu = str;
    }

    public final String zzai() {
        this.zzj.zzaa().zzo();
        return this.zzch;
    }

    public final void zzd(String str) {
        this.zzj.zzaa().zzo();
        this.zzde |= !zzjs.zzs(this.zzch, str);
        this.zzch = str;
    }

    public final String getFirebaseInstanceId() {
        this.zzj.zzaa().zzo();
        return this.zzci;
    }

    public final void zze(String str) {
        this.zzj.zzaa().zzo();
        this.zzde |= !zzjs.zzs(this.zzci, str);
        this.zzci = str;
    }

    public final long zzaj() {
        this.zzj.zzaa().zzo();
        return this.zzck;
    }

    public final void zze(long j) {
        this.zzj.zzaa().zzo();
        this.zzde |= this.zzck != j;
        this.zzck = j;
    }

    public final long zzak() {
        this.zzj.zzaa().zzo();
        return this.zzcl;
    }

    public final void zzf(long j) {
        this.zzj.zzaa().zzo();
        this.zzde |= this.zzcl != j;
        this.zzcl = j;
    }

    public final String zzal() {
        this.zzj.zzaa().zzo();
        return this.zzcm;
    }

    public final void zzf(String str) {
        this.zzj.zzaa().zzo();
        this.zzde |= !zzjs.zzs(this.zzcm, str);
        this.zzcm = str;
    }

    public final long zzam() {
        this.zzj.zzaa().zzo();
        return this.zzcn;
    }

    public final void zzg(long j) {
        this.zzj.zzaa().zzo();
        this.zzde |= this.zzcn != j;
        this.zzcn = j;
    }

    public final String zzan() {
        this.zzj.zzaa().zzo();
        return this.zzco;
    }

    public final void zzg(String str) {
        this.zzj.zzaa().zzo();
        this.zzde |= !zzjs.zzs(this.zzco, str);
        this.zzco = str;
    }

    public final long zzao() {
        this.zzj.zzaa().zzo();
        return this.zzr;
    }

    public final void zzh(long j) {
        this.zzj.zzaa().zzo();
        this.zzde |= this.zzr != j;
        this.zzr = j;
    }

    public final long zzap() {
        this.zzj.zzaa().zzo();
        return this.zzcp;
    }

    public final void zzi(long j) {
        this.zzj.zzaa().zzo();
        this.zzde |= this.zzcp != j;
        this.zzcp = j;
    }

    public final long zzaq() {
        this.zzj.zzaa().zzo();
        return this.zzs;
    }

    public final void zzj(long j) {
        this.zzj.zzaa().zzo();
        this.zzde |= this.zzs != j;
        this.zzs = j;
    }

    public final boolean isMeasurementEnabled() {
        this.zzj.zzaa().zzo();
        return this.zzcq;
    }

    public final void setMeasurementEnabled(boolean z) {
        this.zzj.zzaa().zzo();
        this.zzde |= this.zzcq != z;
        this.zzcq = z;
    }

    public final void zzk(long j) {
        boolean z = true;
        Preconditions.checkArgument(j >= 0);
        this.zzj.zzaa().zzo();
        boolean z2 = this.zzde;
        if (this.zzcj == j) {
            z = false;
        }
        this.zzde = z | z2;
        this.zzcj = j;
    }

    public final long zzar() {
        this.zzj.zzaa().zzo();
        return this.zzcj;
    }

    public final long zzas() {
        this.zzj.zzaa().zzo();
        return this.zzdf;
    }

    public final void zzl(long j) {
        this.zzj.zzaa().zzo();
        this.zzde |= this.zzdf != j;
        this.zzdf = j;
    }

    public final long zzat() {
        this.zzj.zzaa().zzo();
        return this.zzdg;
    }

    public final void zzm(long j) {
        this.zzj.zzaa().zzo();
        this.zzde |= this.zzdg != j;
        this.zzdg = j;
    }

    public final void zzau() {
        this.zzj.zzaa().zzo();
        long j = this.zzcj + 1;
        if (j > 2147483647L) {
            this.zzj.zzab().zzgn().zza("Bundle index overflow. appId", zzef.zzam(this.zzce));
            j = 0;
        }
        this.zzde = true;
        this.zzcj = j;
    }

    public final long zzav() {
        this.zzj.zzaa().zzo();
        return this.zzcx;
    }

    public final void zzn(long j) {
        this.zzj.zzaa().zzo();
        this.zzde |= this.zzcx != j;
        this.zzcx = j;
    }

    public final long zzaw() {
        this.zzj.zzaa().zzo();
        return this.zzcy;
    }

    public final void zzo(long j) {
        this.zzj.zzaa().zzo();
        this.zzde |= this.zzcy != j;
        this.zzcy = j;
    }

    public final long zzax() {
        this.zzj.zzaa().zzo();
        return this.zzcz;
    }

    public final void zzp(long j) {
        this.zzj.zzaa().zzo();
        this.zzde |= this.zzcz != j;
        this.zzcz = j;
    }

    public final long zzay() {
        this.zzj.zzaa().zzo();
        return this.zzda;
    }

    public final void zzq(long j) {
        this.zzj.zzaa().zzo();
        this.zzde |= this.zzda != j;
        this.zzda = j;
    }

    public final long zzaz() {
        this.zzj.zzaa().zzo();
        return this.zzdc;
    }

    public final void zzr(long j) {
        this.zzj.zzaa().zzo();
        this.zzde |= this.zzdc != j;
        this.zzdc = j;
    }

    public final long zzba() {
        this.zzj.zzaa().zzo();
        return this.zzdb;
    }

    public final void zzs(long j) {
        this.zzj.zzaa().zzo();
        this.zzde |= this.zzdb != j;
        this.zzdb = j;
    }

    public final String zzbb() {
        this.zzj.zzaa().zzo();
        return this.zzdd;
    }

    public final String zzbc() {
        this.zzj.zzaa().zzo();
        String str = this.zzdd;
        zzh((String) null);
        return str;
    }

    public final void zzh(String str) {
        this.zzj.zzaa().zzo();
        this.zzde |= !zzjs.zzs(this.zzdd, str);
        this.zzdd = str;
    }

    public final long zzbd() {
        this.zzj.zzaa().zzo();
        return this.zzcr;
    }

    public final void zzt(long j) {
        this.zzj.zzaa().zzo();
        this.zzde |= this.zzcr != j;
        this.zzcr = j;
    }

    public final boolean zzbe() {
        this.zzj.zzaa().zzo();
        return this.zzcs;
    }

    public final void zzb(boolean z) {
        this.zzj.zzaa().zzo();
        this.zzde = this.zzcs != z;
        this.zzcs = z;
    }

    public final boolean zzbf() {
        this.zzj.zzaa().zzo();
        return this.zzct;
    }

    public final void zzc(boolean z) {
        this.zzj.zzaa().zzo();
        this.zzde = this.zzct != z;
        this.zzct = z;
    }

    public final Boolean zzbg() {
        this.zzj.zzaa().zzo();
        return this.zzcv;
    }

    public final void zza(Boolean bool) {
        this.zzj.zzaa().zzo();
        this.zzde = !zzjs.zza(this.zzcv, bool);
        this.zzcv = bool;
    }

    public final List<String> zzbh() {
        this.zzj.zzaa().zzo();
        return this.zzcw;
    }

    public final void zza(List<String> list) {
        this.zzj.zzaa().zzo();
        if (!zzjs.zzb(this.zzcw, list)) {
            this.zzde = true;
            this.zzcw = list != null ? new ArrayList(list) : null;
        }
    }
}
