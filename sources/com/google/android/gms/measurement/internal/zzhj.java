package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

final class zzhj implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zzgp zzpt;

    private zzhj(zzgp zzgp) {
        this.zzpt = zzgp;
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d2 A[Catch:{ Exception -> 0x01d6, all -> 0x01d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0122 A[Catch:{ Exception -> 0x01d6, all -> 0x01d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x015e A[SYNTHETIC, Splitter:B:74:0x015e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityCreated(android.app.Activity r20, android.os.Bundle r21) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            r3 = r21
            java.lang.String r0 = "referrer"
            com.google.android.gms.measurement.internal.zzgp r4 = r1.zzpt     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgs()     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r5 = "onActivityCreated"
            r4.zzao(r5)     // Catch:{ Exception -> 0x01d6 }
            android.content.Intent r4 = r20.getIntent()     // Catch:{ Exception -> 0x01d6 }
            if (r4 != 0) goto L_0x0027
            com.google.android.gms.measurement.internal.zzgp r0 = r1.zzpt
            com.google.android.gms.measurement.internal.zzhq r0 = r0.zzt()
            r0.onActivityCreated(r2, r3)
            return
        L_0x0027:
            android.net.Uri r5 = r4.getData()     // Catch:{ Exception -> 0x01d6 }
            if (r5 == 0) goto L_0x01ca
            boolean r6 = r5.isHierarchical()     // Catch:{ Exception -> 0x01d6 }
            if (r6 != 0) goto L_0x0035
            goto L_0x01ca
        L_0x0035:
            com.google.android.gms.measurement.internal.zzgp r6 = r1.zzpt     // Catch:{ Exception -> 0x01d6 }
            r6.zzz()     // Catch:{ Exception -> 0x01d6 }
            boolean r4 = com.google.android.gms.measurement.internal.zzjs.zzc((android.content.Intent) r4)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r6 = "auto"
            if (r4 == 0) goto L_0x0045
            java.lang.String r4 = "gs"
            goto L_0x0046
        L_0x0045:
            r4 = r6
        L_0x0046:
            java.lang.String r7 = r5.getQueryParameter(r0)     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzgp r8 = r1.zzpt     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzs r8 = r8.zzad()     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzak.zzje     // Catch:{ Exception -> 0x01d6 }
            boolean r8 = r8.zza((com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean>) r9)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r9 = "Activity created with data 'referrer' without required params"
            java.lang.String r10 = "utm_medium"
            java.lang.String r11 = "_cis"
            java.lang.String r12 = "utm_source"
            java.lang.String r13 = "utm_campaign"
            java.lang.String r15 = "gclid"
            if (r8 != 0) goto L_0x0077
            com.google.android.gms.measurement.internal.zzgp r8 = r1.zzpt     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzs r8 = r8.zzad()     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzak.zzjg     // Catch:{ Exception -> 0x01d6 }
            boolean r8 = r8.zza((com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean>) r14)     // Catch:{ Exception -> 0x01d6 }
            if (r8 == 0) goto L_0x0073
            goto L_0x0077
        L_0x0073:
            r17 = r9
            r8 = 0
            goto L_0x00cf
        L_0x0077:
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x01d6 }
            if (r8 == 0) goto L_0x007e
            goto L_0x0073
        L_0x007e:
            boolean r8 = r7.contains(r15)     // Catch:{ Exception -> 0x01d6 }
            if (r8 != 0) goto L_0x00a4
            boolean r8 = r7.contains(r13)     // Catch:{ Exception -> 0x01d6 }
            if (r8 != 0) goto L_0x00a4
            boolean r8 = r7.contains(r12)     // Catch:{ Exception -> 0x01d6 }
            if (r8 != 0) goto L_0x00a4
            boolean r8 = r7.contains(r10)     // Catch:{ Exception -> 0x01d6 }
            if (r8 != 0) goto L_0x00a4
            com.google.android.gms.measurement.internal.zzgp r0 = r1.zzpt     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzab()     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgr()     // Catch:{ Exception -> 0x01d6 }
            r0.zzao(r9)     // Catch:{ Exception -> 0x01d6 }
            goto L_0x0073
        L_0x00a4:
            com.google.android.gms.measurement.internal.zzgp r8 = r1.zzpt     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzjs r8 = r8.zzz()     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r14 = "https://google.com/search?"
            r17 = r9
            java.lang.String r9 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x01d6 }
            int r18 = r9.length()     // Catch:{ Exception -> 0x01d6 }
            if (r18 == 0) goto L_0x00bd
            java.lang.String r9 = r14.concat(r9)     // Catch:{ Exception -> 0x01d6 }
            goto L_0x00c2
        L_0x00bd:
            java.lang.String r9 = new java.lang.String     // Catch:{ Exception -> 0x01d6 }
            r9.<init>(r14)     // Catch:{ Exception -> 0x01d6 }
        L_0x00c2:
            android.net.Uri r9 = android.net.Uri.parse(r9)     // Catch:{ Exception -> 0x01d6 }
            android.os.Bundle r8 = r8.zza((android.net.Uri) r9)     // Catch:{ Exception -> 0x01d6 }
            if (r8 == 0) goto L_0x00cf
            r8.putString(r11, r0)     // Catch:{ Exception -> 0x01d6 }
        L_0x00cf:
            r9 = 1
            if (r3 != 0) goto L_0x0122
            com.google.android.gms.measurement.internal.zzgp r14 = r1.zzpt     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzjs r14 = r14.zzz()     // Catch:{ Exception -> 0x01d6 }
            android.os.Bundle r14 = r14.zza((android.net.Uri) r5)     // Catch:{ Exception -> 0x01d6 }
            if (r14 == 0) goto L_0x011f
            java.lang.String r5 = "intent"
            r14.putString(r11, r5)     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzgp r5 = r1.zzpt     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzs r5 = r5.zzad()     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzak.zzje     // Catch:{ Exception -> 0x01d6 }
            boolean r5 = r5.zza((com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean>) r11)     // Catch:{ Exception -> 0x01d6 }
            if (r5 == 0) goto L_0x0115
            boolean r5 = r14.containsKey(r15)     // Catch:{ Exception -> 0x01d6 }
            if (r5 != 0) goto L_0x0115
            if (r8 == 0) goto L_0x0115
            boolean r5 = r8.containsKey(r15)     // Catch:{ Exception -> 0x01d6 }
            if (r5 == 0) goto L_0x0115
            java.lang.String r5 = "_cer"
            java.lang.String r11 = "gclid=%s"
            java.lang.Object[] r0 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r16 = r8.getString(r15)     // Catch:{ Exception -> 0x01d6 }
            r18 = 0
            r0[r18] = r16     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = java.lang.String.format(r11, r0)     // Catch:{ Exception -> 0x01d6 }
            r14.putString(r5, r0)     // Catch:{ Exception -> 0x01d6 }
            goto L_0x0117
        L_0x0115:
            r18 = 0
        L_0x0117:
            com.google.android.gms.measurement.internal.zzgp r0 = r1.zzpt     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r5 = "_cmp"
            r0.logEvent(r4, r5, r14)     // Catch:{ Exception -> 0x01d6 }
            goto L_0x0125
        L_0x011f:
            r18 = 0
            goto L_0x0125
        L_0x0122:
            r18 = 0
            r14 = 0
        L_0x0125:
            com.google.android.gms.measurement.internal.zzgp r0 = r1.zzpt     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzs r0 = r0.zzad()     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzak.zzjg     // Catch:{ Exception -> 0x01d6 }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean>) r4)     // Catch:{ Exception -> 0x01d6 }
            if (r0 == 0) goto L_0x014e
            if (r8 == 0) goto L_0x014e
            boolean r0 = r8.containsKey(r15)     // Catch:{ Exception -> 0x01d6 }
            if (r0 == 0) goto L_0x014e
            if (r14 == 0) goto L_0x0143
            boolean r0 = r14.containsKey(r15)     // Catch:{ Exception -> 0x01d6 }
            if (r0 != 0) goto L_0x014e
        L_0x0143:
            com.google.android.gms.measurement.internal.zzgp r0 = r1.zzpt     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r4 = "_lgclid"
            java.lang.String r5 = r8.getString(r15)     // Catch:{ Exception -> 0x01d6 }
            r0.zzb((java.lang.String) r6, (java.lang.String) r4, (java.lang.Object) r5, (boolean) r9)     // Catch:{ Exception -> 0x01d6 }
        L_0x014e:
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x01d6 }
            if (r0 == 0) goto L_0x015e
            com.google.android.gms.measurement.internal.zzgp r0 = r1.zzpt
            com.google.android.gms.measurement.internal.zzhq r0 = r0.zzt()
            r0.onActivityCreated(r2, r3)
            return
        L_0x015e:
            boolean r0 = r7.contains(r15)     // Catch:{ Exception -> 0x01d6 }
            if (r0 == 0) goto L_0x0188
            boolean r0 = r7.contains(r13)     // Catch:{ Exception -> 0x01d6 }
            if (r0 != 0) goto L_0x0186
            boolean r0 = r7.contains(r12)     // Catch:{ Exception -> 0x01d6 }
            if (r0 != 0) goto L_0x0186
            boolean r0 = r7.contains(r10)     // Catch:{ Exception -> 0x01d6 }
            if (r0 != 0) goto L_0x0186
            java.lang.String r0 = "utm_term"
            boolean r0 = r7.contains(r0)     // Catch:{ Exception -> 0x01d6 }
            if (r0 != 0) goto L_0x0186
            java.lang.String r0 = "utm_content"
            boolean r0 = r7.contains(r0)     // Catch:{ Exception -> 0x01d6 }
            if (r0 == 0) goto L_0x0188
        L_0x0186:
            r0 = 1
            goto L_0x0189
        L_0x0188:
            r0 = 0
        L_0x0189:
            if (r0 != 0) goto L_0x01a4
            com.google.android.gms.measurement.internal.zzgp r0 = r1.zzpt     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzab()     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgr()     // Catch:{ Exception -> 0x01d6 }
            r4 = r17
            r0.zzao(r4)     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzgp r0 = r1.zzpt
            com.google.android.gms.measurement.internal.zzhq r0 = r0.zzt()
            r0.onActivityCreated(r2, r3)
            return
        L_0x01a4:
            com.google.android.gms.measurement.internal.zzgp r0 = r1.zzpt     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzab()     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgr()     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r4 = "Activity created with referrer"
            r0.zza(r4, r7)     // Catch:{ Exception -> 0x01d6 }
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x01d6 }
            if (r0 != 0) goto L_0x01c0
            com.google.android.gms.measurement.internal.zzgp r0 = r1.zzpt     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r4 = "_ldl"
            r0.zzb((java.lang.String) r6, (java.lang.String) r4, (java.lang.Object) r7, (boolean) r9)     // Catch:{ Exception -> 0x01d6 }
        L_0x01c0:
            com.google.android.gms.measurement.internal.zzgp r0 = r1.zzpt
            com.google.android.gms.measurement.internal.zzhq r0 = r0.zzt()
            r0.onActivityCreated(r2, r3)
            return
        L_0x01ca:
            com.google.android.gms.measurement.internal.zzgp r0 = r1.zzpt
            com.google.android.gms.measurement.internal.zzhq r0 = r0.zzt()
            r0.onActivityCreated(r2, r3)
            return
        L_0x01d4:
            r0 = move-exception
            goto L_0x01f0
        L_0x01d6:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgp r4 = r1.zzpt     // Catch:{ all -> 0x01d4 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ all -> 0x01d4 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgk()     // Catch:{ all -> 0x01d4 }
            java.lang.String r5 = "Throwable caught in onActivityCreated"
            r4.zza(r5, r0)     // Catch:{ all -> 0x01d4 }
            com.google.android.gms.measurement.internal.zzgp r0 = r1.zzpt
            com.google.android.gms.measurement.internal.zzhq r0 = r0.zzt()
            r0.onActivityCreated(r2, r3)
            return
        L_0x01f0:
            com.google.android.gms.measurement.internal.zzgp r4 = r1.zzpt
            com.google.android.gms.measurement.internal.zzhq r4 = r4.zzt()
            r4.onActivityCreated(r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhj.onActivityCreated(android.app.Activity, android.os.Bundle):void");
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zzpt.zzt().onActivityDestroyed(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.zzpt.zzt().onActivityPaused(activity);
        zziw zzv = this.zzpt.zzv();
        zzv.zzaa().zza((Runnable) new zzja(zzv, zzv.zzx().elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        this.zzpt.zzt().onActivityResumed(activity);
        zziw zzv = this.zzpt.zzv();
        zzv.zzaa().zza((Runnable) new zzjb(zzv, zzv.zzx().elapsedRealtime()));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zzpt.zzt().onActivitySaveInstanceState(activity, bundle);
    }

    /* synthetic */ zzhj(zzgp zzgp, zzgo zzgo) {
        this(zzgp);
    }
}
