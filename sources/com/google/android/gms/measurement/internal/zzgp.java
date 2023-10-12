package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.stripe.android.model.PaymentMethodOptionsParams;
import com.stripe.android.model.Stripe3ds2AuthParams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public final class zzgp extends zzg {
    protected zzhj zzpu;
    private zzgk zzpv;
    private final Set<zzgn> zzpw = new CopyOnWriteArraySet();
    private boolean zzpx;
    private final AtomicReference<String> zzpy = new AtomicReference<>();
    protected boolean zzpz = true;

    protected zzgp(zzfj zzfj) {
        super(zzfj);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbk() {
        return false;
    }

    public final void zzif() {
        if (getContext().getApplicationContext() instanceof Application) {
            ((Application) getContext().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zzpu);
        }
    }

    public final Boolean zzig() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzaa().zza(atomicReference, 15000, "boolean test flag value", new zzgo(this, atomicReference));
    }

    public final String zzih() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzaa().zza(atomicReference, 15000, "String test flag value", new zzgy(this, atomicReference));
    }

    public final Long zzii() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzaa().zza(atomicReference, 15000, "long test flag value", new zzha(this, atomicReference));
    }

    public final Integer zzij() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzaa().zza(atomicReference, 15000, "int test flag value", new zzhd(this, atomicReference));
    }

    public final Double zzik() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzaa().zza(atomicReference, 15000, "double test flag value", new zzhc(this, atomicReference));
    }

    public final void setMeasurementEnabled(boolean z) {
        zzbi();
        zzm();
        zzaa().zza((Runnable) new zzhf(this, z));
    }

    public final void zza(boolean z) {
        zzbi();
        zzm();
        zzaa().zza((Runnable) new zzhe(this, z));
    }

    /* access modifiers changed from: private */
    public final void zzg(boolean z) {
        zzo();
        zzm();
        zzbi();
        zzab().zzgr().zza("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        zzac().setMeasurementEnabled(z);
        zzil();
    }

    /* access modifiers changed from: private */
    public final void zzil() {
        if (zzad().zze(zzr().zzag(), zzak.zzik)) {
            zzo();
            String zzho = zzac().zzlx.zzho();
            if (zzho != null) {
                if ("unset".equals(zzho)) {
                    zza(Stripe3ds2AuthParams.FIELD_APP, "_npa", (Object) null, zzx().currentTimeMillis());
                } else {
                    zza(Stripe3ds2AuthParams.FIELD_APP, "_npa", (Object) Long.valueOf("true".equals(zzho) ? 1 : 0), zzx().currentTimeMillis());
                }
            }
        }
        if (!this.zzj.isEnabled() || !this.zzpz) {
            zzab().zzgr().zzao("Updating Scion state (FE)");
            zzs().zzip();
            return;
        }
        zzab().zzgr().zzao("Recording app launch after enabling measurement for the first time (FE)");
        zzim();
    }

    public final void setMinimumSessionDuration(long j) {
        zzm();
        zzaa().zza((Runnable) new zzhh(this, j));
    }

    public final void setSessionTimeoutDuration(long j) {
        zzm();
        zzaa().zza((Runnable) new zzhg(this, j));
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z) {
        logEvent(str, str2, bundle, false, true, zzx().currentTimeMillis());
    }

    public final void logEvent(String str, String str2, Bundle bundle) {
        logEvent(str, str2, bundle, true, true, zzx().currentTimeMillis());
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, String str2, Bundle bundle) {
        zzm();
        zzo();
        zza(str, str2, zzx().currentTimeMillis(), bundle);
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, String str2, long j, Bundle bundle) {
        zzm();
        zzo();
        zza(str, str2, j, bundle, true, this.zzpv == null || zzjs.zzbq(str2), false, (String) null);
    }

    /* access modifiers changed from: private */
    public final void zza(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        String str4;
        long j2;
        long j3;
        String str5;
        String str6;
        String str7;
        int i;
        int i2;
        int i3;
        zzhr zzhr;
        ArrayList arrayList;
        Bundle bundle2;
        long j4;
        Class<?> cls;
        List<String> zzbh;
        String str8 = str;
        String str9 = str2;
        long j5 = j;
        Bundle bundle3 = bundle;
        Preconditions.checkNotEmpty(str);
        if (!zzad().zze(str3, zzak.zzip)) {
            Preconditions.checkNotEmpty(str2);
        }
        Preconditions.checkNotNull(bundle);
        zzo();
        zzbi();
        if (!this.zzj.isEnabled()) {
            zzab().zzgr().zzao("Event not sent since app measurement is disabled");
        } else if (!zzad().zze(zzr().zzag(), zzak.zzix) || (zzbh = zzr().zzbh()) == null || zzbh.contains(str9)) {
            int i4 = 0;
            if (!this.zzpx) {
                this.zzpx = true;
                try {
                    if (!this.zzj.zzia()) {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, getContext().getClassLoader());
                    } else {
                        cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                    }
                    try {
                        cls.getDeclaredMethod("initialize", new Class[]{Context.class}).invoke((Object) null, new Object[]{getContext()});
                    } catch (Exception e) {
                        zzab().zzgn().zza("Failed to invoke Tag Manager's initialize() method", e);
                    }
                } catch (ClassNotFoundException unused) {
                    zzab().zzgq().zzao("Tag Manager is not found and thus will not be used");
                }
            }
            if (zzad().zze(zzr().zzag(), zzak.zzje) && "_cmp".equals(str9) && bundle3.containsKey("gclid")) {
                zza("auto", "_lgclid", (Object) bundle3.getString("gclid"), zzx().currentTimeMillis());
            }
            if (z3) {
                zzae();
                if (!"_iap".equals(str9)) {
                    zzjs zzz = this.zzj.zzz();
                    int i5 = 2;
                    if (zzz.zzp("event", str9)) {
                        if (!zzz.zza("event", zzgj.zzpn, str9)) {
                            i5 = 13;
                        } else if (zzz.zza("event", 40, str9)) {
                            i5 = 0;
                        }
                    }
                    if (i5 != 0) {
                        zzab().zzgm().zza("Invalid public event name. Event will not be logged (FE)", zzy().zzaj(str9));
                        this.zzj.zzz();
                        this.zzj.zzz().zza(i5, "_ev", zzjs.zza(str9, 40, true), str9 != null ? str2.length() : 0);
                        return;
                    }
                }
            }
            zzae();
            zzhr zzin = zzt().zzin();
            if (zzin != null && !bundle3.containsKey("_sc")) {
                zzin.zzqx = true;
            }
            zzhq.zza(zzin, bundle3, z && z3);
            boolean equals = "am".equals(str8);
            boolean zzbq = zzjs.zzbq(str2);
            if (z && this.zzpv != null && !zzbq && !equals) {
                zzab().zzgr().zza("Passing event to registered event handler (FE)", zzy().zzaj(str9), zzy().zzc(bundle3));
                this.zzpv.interceptEvent(str, str2, bundle, j);
            } else if (this.zzj.zzie()) {
                int zzbl = zzz().zzbl(str9);
                if (zzbl != 0) {
                    zzab().zzgm().zza("Invalid event name. Event will not be logged (FE)", zzy().zzaj(str9));
                    zzz();
                    String zza = zzjs.zza(str9, 40, true);
                    if (str9 != null) {
                        i4 = str2.length();
                    }
                    this.zzj.zzz().zza(str3, zzbl, "_ev", zza, i4);
                    return;
                }
                List listOf = CollectionUtils.listOf((T[]) new String[]{"_o", "_sn", "_sc", "_si"});
                String str10 = str9;
                Bundle zza2 = zzz().zza(str3, str2, bundle, listOf, z3, true);
                zzhr zzhr2 = (zza2 == null || !zza2.containsKey("_sc") || !zza2.containsKey("_si")) ? null : new zzhr(zza2.getString("_sn"), zza2.getString("_sc"), Long.valueOf(zza2.getLong("_si")).longValue());
                zzhr zzhr3 = zzhr2 == null ? zzin : zzhr2;
                if (zzad().zzz(str3)) {
                    zzae();
                    if (zzt().zzin() != null && "_ae".equals(str10)) {
                        long zzjb = zzv().zzjb();
                        if (zzjb > 0) {
                            zzz().zzb(zza2, zzjb);
                        }
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(zza2);
                long nextLong = zzz().zzjw().nextLong();
                if (!zzad().zze(zzr().zzag(), zzak.zzid) || zzac().zzma.get() <= 0) {
                    j3 = nextLong;
                    str4 = "_ae";
                    j2 = j;
                } else {
                    long j6 = j;
                    if (!zzac().zzx(j6) || !zzac().zzmd.get()) {
                        j3 = nextLong;
                        str4 = "_ae";
                        j2 = j6;
                    } else {
                        zzab().zzgs().zzao("Current session is expired, remove the session number and Id");
                        if (zzad().zze(zzr().zzag(), zzak.zzhz)) {
                            str4 = "_ae";
                            j2 = j6;
                            j3 = nextLong;
                            zza("auto", "_sid", (Object) null, zzx().currentTimeMillis());
                        } else {
                            j3 = nextLong;
                            str4 = "_ae";
                            j2 = j6;
                        }
                        if (zzad().zze(zzr().zzag(), zzak.zzia)) {
                            zza("auto", "_sno", (Object) null, zzx().currentTimeMillis());
                        }
                    }
                }
                if (zzad().zzy(zzr().zzag()) && zza2.getLong(FirebaseAnalytics.Param.EXTEND_SESSION, 0) == 1) {
                    zzab().zzgs().zzao("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                    this.zzj.zzv().zza(j2, true);
                }
                String[] strArr = (String[]) zza2.keySet().toArray(new String[bundle.size()]);
                Arrays.sort(strArr);
                int length = strArr.length;
                int i6 = 0;
                int i7 = 0;
                while (i6 < length) {
                    String str11 = strArr[i6];
                    Object obj = zza2.get(str11);
                    zzz();
                    String[] strArr2 = strArr;
                    Bundle[] zzb = zzjs.zzb(obj);
                    if (zzb != null) {
                        i3 = length;
                        zza2.putInt(str11, zzb.length);
                        long j7 = j3;
                        int i8 = 0;
                        while (i8 < zzb.length) {
                            Bundle bundle4 = zzb[i8];
                            zzhq.zza(zzhr3, bundle4, true);
                            int i9 = i6;
                            long j8 = j7;
                            Bundle zza3 = zzz().zza(str3, "_ep", bundle4, listOf, z3, false);
                            zza3.putString("_en", str10);
                            zza3.putLong("_eid", j8);
                            zza3.putString("_gn", str11);
                            zza3.putInt("_ll", zzb.length);
                            zza3.putInt("_i", i8);
                            ArrayList arrayList3 = arrayList2;
                            arrayList3.add(zza3);
                            i8++;
                            long j9 = j;
                            j7 = j8;
                            zza2 = zza2;
                            arrayList2 = arrayList3;
                            zzhr3 = zzhr3;
                            i6 = i9;
                            i7 = i7;
                            str4 = str4;
                        }
                        str7 = str4;
                        i2 = i6;
                        arrayList = arrayList2;
                        zzhr = zzhr3;
                        bundle2 = zza2;
                        j4 = j7;
                        i = i7 + zzb.length;
                    } else {
                        str7 = str4;
                        i3 = length;
                        i2 = i6;
                        i = i7;
                        j4 = j3;
                        arrayList = arrayList2;
                        zzhr = zzhr3;
                        bundle2 = zza2;
                    }
                    long j10 = j;
                    zza2 = bundle2;
                    arrayList2 = arrayList;
                    zzhr3 = zzhr;
                    length = i3;
                    str4 = str7;
                    j3 = j4;
                    i7 = i;
                    i6 = i2 + 1;
                    strArr = strArr2;
                }
                String str12 = str4;
                int i10 = i7;
                long j11 = j3;
                ArrayList arrayList4 = arrayList2;
                Bundle bundle5 = zza2;
                if (i10 != 0) {
                    bundle5.putLong("_eid", j11);
                    bundle5.putInt("_epc", i10);
                }
                int i11 = 0;
                while (i11 < arrayList4.size()) {
                    Bundle bundle6 = (Bundle) arrayList4.get(i11);
                    if (i11 != 0) {
                        str6 = "_ep";
                        str5 = str10;
                    } else {
                        str6 = str10;
                        str5 = str6;
                    }
                    bundle6.putString("_o", str);
                    if (z2) {
                        bundle6 = zzz().zzg(bundle6);
                    }
                    Bundle bundle7 = bundle6;
                    zzab().zzgr().zza("Logging event (FE)", zzy().zzaj(str5), zzy().zzc(bundle7));
                    zzs().zzc(new zzai(str6, new zzah(bundle7), str, j), str3);
                    if (!equals) {
                        for (zzgn onEvent : this.zzpw) {
                            onEvent.onEvent(str, str2, new Bundle(bundle7), j);
                        }
                    }
                    i11++;
                    str10 = str5;
                }
                String str13 = str10;
                zzae();
                if (zzt().zzin() != null && str12.equals(str13)) {
                    zzv().zza(true, true);
                }
            }
        } else {
            zzab().zzgr().zza("Dropping non-safelisted event. event name, origin", str9, str8);
        }
    }

    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        zzm();
        zzb(str == null ? Stripe3ds2AuthParams.FIELD_APP : str, str2, j, bundle == null ? new Bundle() : bundle, z2, !z2 || this.zzpv == null || zzjs.zzbq(str2), !z, (String) null);
    }

    private final void zzb(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        zzaa().zza((Runnable) new zzgr(this, str, str2, j, zzjs.zzh(bundle), z, z2, z3, str3));
    }

    public final void zzb(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, z, zzx().currentTimeMillis());
    }

    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        if (str == null) {
            str = Stripe3ds2AuthParams.FIELD_APP;
        }
        String str3 = str;
        int i = 6;
        int i2 = 0;
        if (z) {
            i = zzz().zzbm(str2);
        } else {
            zzjs zzz = zzz();
            if (zzz.zzp("user property", str2)) {
                if (!zzz.zza("user property", zzgl.zzpp, str2)) {
                    i = 15;
                } else if (zzz.zza("user property", 24, str2)) {
                    i = 0;
                }
            }
        }
        if (i != 0) {
            zzz();
            String zza = zzjs.zza(str2, 24, true);
            if (str2 != null) {
                i2 = str2.length();
            }
            this.zzj.zzz().zza(i, "_ev", zza, i2);
        } else if (obj != null) {
            int zzc = zzz().zzc(str2, obj);
            if (zzc != 0) {
                zzz();
                String zza2 = zzjs.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i2 = String.valueOf(obj).length();
                }
                this.zzj.zzz().zza(zzc, "_ev", zza2, i2);
                return;
            }
            Object zzd = zzz().zzd(str2, obj);
            if (zzd != null) {
                zza(str3, str2, j, zzd);
            }
        } else {
            zza(str3, str2, j, (Object) null);
        }
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzaa().zza((Runnable) new zzgq(this, str, str2, obj, j));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r9)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r8.zzo()
            r8.zzm()
            r8.zzbi()
            com.google.android.gms.measurement.internal.zzs r0 = r8.zzad()
            com.google.android.gms.measurement.internal.zzdy r1 = r8.zzr()
            java.lang.String r1 = r1.zzag()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzak.zzik
            boolean r0 = r0.zze(r1, r2)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x007a
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x007a
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L_0x006a
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x006a
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            if (r10 == 0) goto L_0x004c
            r4 = r2
            goto L_0x004e
        L_0x004c:
            r4 = 0
        L_0x004e:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.zzeo r0 = r8.zzac()
            com.google.android.gms.measurement.internal.zzev r0 = r0.zzlx
            r4 = r10
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0065
            java.lang.String r11 = "true"
        L_0x0065:
            r0.zzau(r11)
            r6 = r10
            goto L_0x0078
        L_0x006a:
            if (r11 != 0) goto L_0x007a
            com.google.android.gms.measurement.internal.zzeo r10 = r8.zzac()
            com.google.android.gms.measurement.internal.zzev r10 = r10.zzlx
            java.lang.String r0 = "unset"
            r10.zzau(r0)
            r6 = r11
        L_0x0078:
            r3 = r1
            goto L_0x007c
        L_0x007a:
            r3 = r10
            r6 = r11
        L_0x007c:
            com.google.android.gms.measurement.internal.zzfj r10 = r8.zzj
            boolean r10 = r10.isEnabled()
            if (r10 != 0) goto L_0x0092
            com.google.android.gms.measurement.internal.zzef r9 = r8.zzab()
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzgr()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.zzao(r10)
            return
        L_0x0092:
            com.google.android.gms.measurement.internal.zzfj r10 = r8.zzj
            boolean r10 = r10.zzie()
            if (r10 != 0) goto L_0x009b
            return
        L_0x009b:
            com.google.android.gms.measurement.internal.zzef r10 = r8.zzab()
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzgr()
            com.google.android.gms.measurement.internal.zzed r11 = r8.zzy()
            java.lang.String r11 = r11.zzaj(r3)
            java.lang.String r0 = "Setting user property (FE)"
            r10.zza(r0, r11, r6)
            com.google.android.gms.measurement.internal.zzjn r10 = new com.google.android.gms.measurement.internal.zzjn
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.zzhv r9 = r8.zzs()
            r9.zzb((com.google.android.gms.measurement.internal.zzjn) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgp.zza(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final List<zzjn> zzh(boolean z) {
        zzm();
        zzbi();
        zzab().zzgr().zzao("Fetching user attributes (FE)");
        if (zzaa().zzhp()) {
            zzab().zzgk().zzao("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (zzr.isMainThread()) {
            zzab().zzgk().zzao("Cannot get all user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                this.zzj.zzaa().zza((Runnable) new zzgt(this, atomicReference, z));
                try {
                    atomicReference.wait(CoroutineLiveDataKt.DEFAULT_TIMEOUT);
                } catch (InterruptedException e) {
                    zzab().zzgn().zza("Interrupted waiting for get user properties", e);
                }
            }
            List<zzjn> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            zzab().zzgn().zzao("Timed out waiting for get user properties");
            return Collections.emptyList();
        }
    }

    public final String zzi() {
        zzm();
        return this.zzpy.get();
    }

    public final String zzy(long j) {
        if (zzaa().zzhp()) {
            zzab().zzgk().zzao("Cannot retrieve app instance id from analytics worker thread");
            return null;
        } else if (zzr.isMainThread()) {
            zzab().zzgk().zzao("Cannot retrieve app instance id from main thread");
            return null;
        } else {
            long elapsedRealtime = zzx().elapsedRealtime();
            String zzz = zzz(120000);
            long elapsedRealtime2 = zzx().elapsedRealtime() - elapsedRealtime;
            return (zzz != null || elapsedRealtime2 >= 120000) ? zzz : zzz(120000 - elapsedRealtime2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzbg(String str) {
        this.zzpy.set(str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        zzab().zzgn().zzao("Interrupted waiting for app instance id");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002c, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String zzz(long r4) {
        /*
            r3 = this;
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r0.<init>()
            monitor-enter(r0)
            com.google.android.gms.measurement.internal.zzfc r1 = r3.zzaa()     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.zzgs r2 = new com.google.android.gms.measurement.internal.zzgs     // Catch:{ all -> 0x002d }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x002d }
            r1.zza((java.lang.Runnable) r2)     // Catch:{ all -> 0x002d }
            r0.wait(r4)     // Catch:{ InterruptedException -> 0x001d }
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            java.lang.Object r4 = r0.get()
            java.lang.String r4 = (java.lang.String) r4
            return r4
        L_0x001d:
            com.google.android.gms.measurement.internal.zzef r4 = r3.zzab()     // Catch:{ all -> 0x002d }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgn()     // Catch:{ all -> 0x002d }
            java.lang.String r5 = "Interrupted waiting for app instance id"
            r4.zzao(r5)     // Catch:{ all -> 0x002d }
            r4 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            return r4
        L_0x002d:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzgp.zzz(long):java.lang.String");
    }

    public final void resetAnalyticsData(long j) {
        zzbg((String) null);
        zzaa().zza((Runnable) new zzgv(this, j));
    }

    public final void zzim() {
        zzo();
        zzm();
        zzbi();
        if (this.zzj.zzie()) {
            zzs().zzim();
            this.zzpz = false;
            String zzhh = zzac().zzhh();
            if (!TextUtils.isEmpty(zzhh)) {
                zzw().zzbi();
                if (!zzhh.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzhh);
                    logEvent("auto", "_ou", bundle);
                }
            }
        }
    }

    public final void zza(zzgk zzgk) {
        zzgk zzgk2;
        zzo();
        zzm();
        zzbi();
        if (!(zzgk == null || zzgk == (zzgk2 = this.zzpv))) {
            Preconditions.checkState(zzgk2 == null, "EventInterceptor already set.");
        }
        this.zzpv = zzgk;
    }

    public final void zza(zzgn zzgn) {
        zzm();
        zzbi();
        Preconditions.checkNotNull(zzgn);
        if (!this.zzpw.add(zzgn)) {
            zzab().zzgn().zzao("OnEventListener already registered");
        }
    }

    public final void zzb(zzgn zzgn) {
        zzm();
        zzbi();
        Preconditions.checkNotNull(zzgn);
        if (!this.zzpw.remove(zzgn)) {
            zzab().zzgn().zzao("OnEventListener had not been registered");
        }
    }

    public final void setConditionalUserProperty(Bundle bundle) {
        setConditionalUserProperty(bundle, zzx().currentTimeMillis());
    }

    public final void setConditionalUserProperty(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzm();
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString(PaymentMethodOptionsParams.WeChatPay.PARAM_APP_ID))) {
            zzab().zzgn().zzao("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove(PaymentMethodOptionsParams.WeChatPay.PARAM_APP_ID);
        zza(bundle2, j);
    }

    public final void zzd(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString(PaymentMethodOptionsParams.WeChatPay.PARAM_APP_ID));
        zzl();
        zza(new Bundle(bundle), zzx().currentTimeMillis());
    }

    private final void zza(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzgg.zza(bundle, PaymentMethodOptionsParams.WeChatPay.PARAM_APP_ID, String.class, null);
        zzgg.zza(bundle, "origin", String.class, null);
        zzgg.zza(bundle, "name", String.class, null);
        zzgg.zza(bundle, "value", Object.class, null);
        zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzgg.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle.getString("name"));
        Preconditions.checkNotEmpty(bundle.getString("origin"));
        Preconditions.checkNotNull(bundle.get("value"));
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle.getString("name");
        Object obj = bundle.get("value");
        if (zzz().zzbm(string) != 0) {
            zzab().zzgk().zza("Invalid conditional user property name", zzy().zzal(string));
        } else if (zzz().zzc(string, obj) != 0) {
            zzab().zzgk().zza("Invalid conditional user property value", zzy().zzal(string), obj);
        } else {
            Object zzd = zzz().zzd(string, obj);
            if (zzd == null) {
                zzab().zzgk().zza("Unable to normalize conditional user property value", zzy().zzal(string), obj);
                return;
            }
            zzgg.zza(bundle, zzd);
            long j2 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            if (TextUtils.isEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) || (j2 <= 15552000000L && j2 >= 1)) {
                long j3 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                if (j3 > 15552000000L || j3 < 1) {
                    zzab().zzgk().zza("Invalid conditional user property time to live", zzy().zzal(string), Long.valueOf(j3));
                } else {
                    zzaa().zza((Runnable) new zzgx(this, bundle));
                }
            } else {
                zzab().zzgk().zza("Invalid conditional user property timeout", zzy().zzal(string), Long.valueOf(j2));
            }
        }
    }

    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        zzm();
        zza((String) null, str, str2, bundle);
    }

    public final void clearConditionalUserPropertyAs(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zzl();
        zza(str, str2, str3, bundle);
    }

    private final void zza(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzx().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        Bundle bundle2 = new Bundle();
        if (str != null) {
            bundle2.putString(PaymentMethodOptionsParams.WeChatPay.PARAM_APP_ID, str);
        }
        bundle2.putString("name", str2);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str3 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str3);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzaa().zza((Runnable) new zzgw(this, bundle2));
    }

    /* access modifiers changed from: private */
    public final void zze(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzo();
        zzbi();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        if (!this.zzj.isEnabled()) {
            zzab().zzgr().zzao("Conditional property not sent since collection is disabled");
            return;
        }
        zzjn zzjn = new zzjn(bundle2.getString("name"), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle2.get("value"), bundle2.getString("origin"));
        try {
            zzai zza = zzz().zza(bundle2.getString(PaymentMethodOptionsParams.WeChatPay.PARAM_APP_ID), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false);
            zzs().zzd(new zzq(bundle2.getString(PaymentMethodOptionsParams.WeChatPay.PARAM_APP_ID), bundle2.getString("origin"), zzjn, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), false, bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), zzz().zza(bundle2.getString(PaymentMethodOptionsParams.WeChatPay.PARAM_APP_ID), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), zza, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zzz().zza(bundle2.getString(PaymentMethodOptionsParams.WeChatPay.PARAM_APP_ID), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* access modifiers changed from: private */
    public final void zzf(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzo();
        zzbi();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        if (!this.zzj.isEnabled()) {
            zzab().zzgr().zzao("Conditional property not cleared since collection is disabled");
            return;
        }
        zzjn zzjn = new zzjn(bundle2.getString("name"), 0, (Object) null, (String) null);
        try {
            zzai zza = zzz().zza(bundle2.getString(PaymentMethodOptionsParams.WeChatPay.PARAM_APP_ID), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString("origin"), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, false);
            zzjn zzjn2 = zzjn;
            zzs().zzd(new zzq(bundle2.getString(PaymentMethodOptionsParams.WeChatPay.PARAM_APP_ID), bundle2.getString("origin"), zzjn2, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), bundle2.getBoolean("active"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME), (zzai) null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT), (zzai) null, bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE), zza));
        } catch (IllegalArgumentException unused) {
        }
    }

    public final ArrayList<Bundle> zzn(String str, String str2) {
        zzm();
        return zze((String) null, str, str2);
    }

    public final ArrayList<Bundle> zzd(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzl();
        return zze(str, str2, str3);
    }

    private final ArrayList<Bundle> zze(String str, String str2, String str3) {
        if (zzaa().zzhp()) {
            zzab().zzgk().zzao("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        } else if (zzr.isMainThread()) {
            zzab().zzgk().zzao("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                this.zzj.zzaa().zza((Runnable) new zzgz(this, atomicReference, str, str2, str3));
                try {
                    atomicReference.wait(CoroutineLiveDataKt.DEFAULT_TIMEOUT);
                } catch (InterruptedException e) {
                    zzab().zzgn().zza("Interrupted waiting for get conditional user properties", str, e);
                }
            }
            List list = (List) atomicReference.get();
            if (list != null) {
                return zzjs.zzd((List<zzq>) list);
            }
            zzab().zzgn().zza("Timed out waiting for get conditional user properties", str);
            return new ArrayList<>();
        }
    }

    public final Map<String, Object> getUserProperties(String str, String str2, boolean z) {
        zzm();
        return zzb((String) null, str, str2, z);
    }

    public final Map<String, Object> getUserPropertiesAs(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zzl();
        return zzb(str, str2, str3, z);
    }

    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        if (zzaa().zzhp()) {
            zzab().zzgk().zzao("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (zzr.isMainThread()) {
            zzab().zzgk().zzao("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            synchronized (atomicReference) {
                this.zzj.zzaa().zza((Runnable) new zzhb(this, atomicReference, str, str2, str3, z));
                try {
                    atomicReference.wait(CoroutineLiveDataKt.DEFAULT_TIMEOUT);
                } catch (InterruptedException e) {
                    zzab().zzgn().zza("Interrupted waiting for get user properties", e);
                }
            }
            List<zzjn> list = (List) atomicReference.get();
            if (list == null) {
                zzab().zzgn().zzao("Timed out waiting for get user properties");
                return Collections.emptyMap();
            }
            ArrayMap arrayMap = new ArrayMap(list.size());
            for (zzjn zzjn : list) {
                arrayMap.put(zzjn.name, zzjn.getValue());
            }
            return arrayMap;
        }
    }

    public final String getCurrentScreenName() {
        zzhr zzio = this.zzj.zzt().zzio();
        if (zzio != null) {
            return zzio.zzqu;
        }
        return null;
    }

    public final String getCurrentScreenClass() {
        zzhr zzio = this.zzj.zzt().zzio();
        if (zzio != null) {
            return zzio.zzqv;
        }
        return null;
    }

    public final String getGmpAppId() {
        if (this.zzj.zzhx() != null) {
            return this.zzj.zzhx();
        }
        try {
            return GoogleServices.getGoogleAppId();
        } catch (IllegalStateException e) {
            this.zzj.zzab().zzgk().zza("getGoogleAppId failed with exception", e);
            return null;
        }
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
