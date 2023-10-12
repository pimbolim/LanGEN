package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzey;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class zzhp extends zzjh {
    public zzhp(zzjg zzjg) {
        super(zzjg);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbk() {
        return false;
    }

    public final byte[] zzb(zzai zzai, String str) {
        zzjp zzjp;
        zzbs.zzf.zza zza;
        zzbs.zzg.zza zza2;
        zzf zzf;
        byte[] bArr;
        Bundle bundle;
        zzae zzae;
        long j;
        zzai zzai2 = zzai;
        String str2 = str;
        zzo();
        this.zzj.zzl();
        Preconditions.checkNotNull(zzai);
        Preconditions.checkNotEmpty(str);
        if (!zzad().zze(str2, zzak.zzio)) {
            zzab().zzgr().zza("Generating ScionPayload disabled. packageName", str2);
            return new byte[0];
        } else if ("_iap".equals(zzai2.name) || "_iapx".equals(zzai2.name)) {
            zzbs.zzf.zza zznj = zzbs.zzf.zznj();
            zzgy().beginTransaction();
            try {
                zzf zzab = zzgy().zzab(str2);
                if (zzab == null) {
                    zzab().zzgr().zza("Log and bundle not available. package_name", str2);
                    return new byte[0];
                } else if (!zzab.isMeasurementEnabled()) {
                    zzab().zzgr().zza("Log and bundle disabled. package_name", str2);
                    byte[] bArr2 = new byte[0];
                    zzgy().endTransaction();
                    return bArr2;
                } else {
                    zzbs.zzg.zza zzcc = zzbs.zzg.zzpr().zzp(1).zzcc("android");
                    if (!TextUtils.isEmpty(zzab.zzag())) {
                        zzcc.zzch(zzab.zzag());
                    }
                    if (!TextUtils.isEmpty(zzab.zzan())) {
                        zzcc.zzcg(zzab.zzan());
                    }
                    if (!TextUtils.isEmpty(zzab.zzal())) {
                        zzcc.zzci(zzab.zzal());
                    }
                    if (zzab.zzam() != -2147483648L) {
                        zzcc.zzv((int) zzab.zzam());
                    }
                    zzcc.zzas(zzab.zzao()).zzax(zzab.zzaq());
                    if (!TextUtils.isEmpty(zzab.getGmpAppId())) {
                        zzcc.zzcm(zzab.getGmpAppId());
                    } else if (!TextUtils.isEmpty(zzab.zzah())) {
                        zzcc.zzcq(zzab.zzah());
                    }
                    zzcc.zzau(zzab.zzap());
                    if (this.zzj.isEnabled() && zzs.zzbv() && zzad().zzl(zzcc.zzag())) {
                        zzcc.zzag();
                        if (!TextUtils.isEmpty((CharSequence) null)) {
                            zzcc.zzcp((String) null);
                        }
                    }
                    Pair<String, Boolean> zzap = zzac().zzap(zzab.zzag());
                    if (zzab.zzbe() && zzap != null && !TextUtils.isEmpty((CharSequence) zzap.first)) {
                        zzcc.zzcj(zzo((String) zzap.first, Long.toString(zzai2.zzfu)));
                        if (zzap.second != null) {
                            zzcc.zzm(((Boolean) zzap.second).booleanValue());
                        }
                    }
                    zzw().zzbi();
                    zzbs.zzg.zza zzce = zzcc.zzce(Build.MODEL);
                    zzw().zzbi();
                    zzce.zzcd(Build.VERSION.RELEASE).zzt((int) zzw().zzcq()).zzcf(zzw().zzcr());
                    try {
                        zzcc.zzck(zzo(zzab.getAppInstanceId(), Long.toString(zzai2.zzfu)));
                        if (!TextUtils.isEmpty(zzab.getFirebaseInstanceId())) {
                            zzcc.zzcn(zzab.getFirebaseInstanceId());
                        }
                        String zzag = zzab.zzag();
                        List<zzjp> zzaa = zzgy().zzaa(zzag);
                        Iterator<zzjp> it = zzaa.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                zzjp = null;
                                break;
                            }
                            zzjp = it.next();
                            if ("_lte".equals(zzjp.name)) {
                                break;
                            }
                        }
                        if (zzjp == null || zzjp.value == null) {
                            zzjp zzjp2 = new zzjp(zzag, "auto", "_lte", zzx().currentTimeMillis(), 0L);
                            zzaa.add(zzjp2);
                            zzgy().zza(zzjp2);
                        }
                        if (zzad().zze(zzag, zzak.zzij)) {
                            zzjo zzgw = zzgw();
                            zzgw.zzab().zzgs().zzao("Checking account type status for ad personalization signals");
                            if (zzgw.zzw().zzcu()) {
                                String zzag2 = zzab.zzag();
                                if (zzab.zzbe() && zzgw.zzgz().zzba(zzag2)) {
                                    zzgw.zzab().zzgr().zzao("Turning off ad personalization due to account type");
                                    Iterator<zzjp> it2 = zzaa.iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            break;
                                        } else if ("_npa".equals(it2.next().name)) {
                                            it2.remove();
                                            break;
                                        }
                                    }
                                    zzaa.add(new zzjp(zzag2, "auto", "_npa", zzgw.zzx().currentTimeMillis(), 1L));
                                }
                            }
                        }
                        zzbs.zzk[] zzkArr = new zzbs.zzk[zzaa.size()];
                        for (int i = 0; i < zzaa.size(); i++) {
                            zzbs.zzk.zza zzbk = zzbs.zzk.zzqu().zzdb(zzaa.get(i).name).zzbk(zzaa.get(i).zztr);
                            zzgw().zza(zzbk, zzaa.get(i).value);
                            zzkArr[i] = (zzbs.zzk) ((zzey) zzbk.zzug());
                        }
                        zzcc.zzb(Arrays.asList(zzkArr));
                        Bundle zzcv = zzai2.zzfq.zzcv();
                        zzcv.putLong("_c", 1);
                        zzab().zzgr().zzao("Marking in-app purchase as real-time");
                        zzcv.putLong("_r", 1);
                        zzcv.putString("_o", zzai2.origin);
                        if (zzz().zzbr(zzcc.zzag())) {
                            zzz().zza(zzcv, "_dbg", (Object) 1L);
                            zzz().zza(zzcv, "_r", (Object) 1L);
                        }
                        zzae zzc = zzgy().zzc(str2, zzai2.name);
                        if (zzc == null) {
                            zzf = zzab;
                            zza2 = zzcc;
                            zza = zznj;
                            bundle = zzcv;
                            bArr = null;
                            zzae = new zzae(str, zzai2.name, 0, 0, zzai2.zzfu, 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
                            j = 0;
                        } else {
                            zza2 = zzcc;
                            zzf = zzab;
                            zza = zznj;
                            bundle = zzcv;
                            bArr = null;
                            j = zzc.zzfj;
                            zzae = zzc.zzw(zzai2.zzfu);
                        }
                        zzgy().zza(zzae);
                        zzaf zzaf = new zzaf(this.zzj, zzai2.origin, str, zzai2.name, zzai2.zzfu, j, bundle);
                        zzbs.zzc.zza zzah = zzbs.zzc.zzmq().zzag(zzaf.timestamp).zzbx(zzaf.name).zzah(zzaf.zzfp);
                        Iterator<String> it3 = zzaf.zzfq.iterator();
                        while (it3.hasNext()) {
                            String next = it3.next();
                            zzbs.zze.zza zzbz = zzbs.zze.zzng().zzbz(next);
                            zzgw().zza(zzbz, zzaf.zzfq.get(next));
                            zzah.zza(zzbz);
                        }
                        zzbs.zzg.zza zza3 = zza2;
                        zza3.zza(zzah).zza(zzbs.zzh.zzpt().zza(zzbs.zzd.zzms().zzak(zzae.zzfg).zzby(zzai2.name)));
                        zza3.zzc(zzgx().zza(zzf.zzag(), (List<zzbs.zzc>) Collections.emptyList(), zza3.zzno()));
                        if (zzah.zzml()) {
                            zza3.zzao(zzah.getTimestampMillis()).zzap(zzah.getTimestampMillis());
                        }
                        long zzak = zzf.zzak();
                        int i2 = (zzak > 0 ? 1 : (zzak == 0 ? 0 : -1));
                        if (i2 != 0) {
                            zza3.zzar(zzak);
                        }
                        long zzaj = zzf.zzaj();
                        if (zzaj != 0) {
                            zza3.zzaq(zzaj);
                        } else if (i2 != 0) {
                            zza3.zzaq(zzak);
                        }
                        zzf.zzau();
                        zzbs.zzg.zza zzan = zza3.zzu((int) zzf.zzar()).zzat(zzad().zzao()).zzan(zzx().currentTimeMillis());
                        Boolean bool = Boolean.TRUE;
                        zzan.zzn(true);
                        zzbs.zzf.zza zza4 = zza;
                        zza4.zza(zza3);
                        zzf zzf2 = zzf;
                        zzf2.zze(zza3.zznq());
                        zzf2.zzf(zza3.zznr());
                        zzgy().zza(zzf2);
                        zzgy().setTransactionSuccessful();
                        zzgy().endTransaction();
                        try {
                            return zzgw().zzc(((zzbs.zzf) ((zzey) zza4.zzug())).toByteArray());
                        } catch (IOException e) {
                            zzab().zzgk().zza("Data loss. Failed to bundle and serialize. appId", zzef.zzam(str), e);
                            return bArr;
                        }
                    } catch (SecurityException e2) {
                        zzab().zzgr().zza("app instance id encryption failed", e2.getMessage());
                        byte[] bArr3 = new byte[0];
                        zzgy().endTransaction();
                        return bArr3;
                    }
                }
            } catch (SecurityException e3) {
                zzab().zzgr().zza("Resettable device id encryption failed", e3.getMessage());
                return new byte[0];
            } finally {
                zzgy().endTransaction();
            }
        } else {
            zzab().zzgr().zza("Generating a payload for this event is not available. package_name, event_name", str2, zzai2.name);
            return null;
        }
    }

    private static String zzo(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }
}
