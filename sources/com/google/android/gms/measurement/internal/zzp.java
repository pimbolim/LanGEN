package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbk;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzey;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

final class zzp extends zzjh {
    zzp(zzjg zzjg) {
        super(zzjg);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbk() {
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v22, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v0, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v25, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v3, resolved type: androidx.collection.ArrayMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v5, resolved type: androidx.collection.ArrayMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v75, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v3, resolved type: java.util.ArrayList} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:412:0x0d16, code lost:
        if (r0.zzkb() == false) goto L_0x0d21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:413:0x0d18, code lost:
        r8 = java.lang.Integer.valueOf(r0.getId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:414:0x0d21, code lost:
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:415:0x0d22, code lost:
        r1.zza("Invalid property filter ID. appId, id", r6, java.lang.String.valueOf(r8));
        r15.add(java.lang.Integer.valueOf(r5));
        r7 = r86;
        r1 = r87;
        r0 = r16;
        r3 = r17;
        r46 = r23;
        r10 = r39;
        r39 = r44;
        r23 = r22;
        r22 = r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0365  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x048e  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x04ab  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x04ca  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x055f  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x05e7  */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0676  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0697  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x077c  */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x0a02  */
    /* JADX WARNING: Removed duplicated region for block: B:422:0x0d8c  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01e1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.measurement.zzbs.zza> zza(java.lang.String r86, java.util.List<com.google.android.gms.internal.measurement.zzbs.zzc> r87, java.util.List<com.google.android.gms.internal.measurement.zzbs.zzk> r88) {
        /*
            r85 = this;
            r7 = r85
            r9 = r86
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r86)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r87)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r88)
            java.util.HashSet r15 = new java.util.HashSet
            r15.<init>()
            androidx.collection.ArrayMap r13 = new androidx.collection.ArrayMap
            r13.<init>()
            androidx.collection.ArrayMap r14 = new androidx.collection.ArrayMap
            r14.<init>()
            androidx.collection.ArrayMap r11 = new androidx.collection.ArrayMap
            r11.<init>()
            androidx.collection.ArrayMap r12 = new androidx.collection.ArrayMap
            r12.<init>()
            androidx.collection.ArrayMap r10 = new androidx.collection.ArrayMap
            r10.<init>()
            com.google.android.gms.measurement.internal.zzs r0 = r85.zzad()
            boolean r25 = r0.zzq(r9)
            com.google.android.gms.measurement.internal.zzs r0 = r85.zzad()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzak.zziq
            boolean r26 = r0.zzd(r9, r1)
            com.google.android.gms.measurement.internal.zzs r0 = r85.zzad()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzak.zziy
            boolean r27 = r0.zzd(r9, r1)
            com.google.android.gms.measurement.internal.zzs r0 = r85.zzad()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzak.zziz
            boolean r28 = r0.zzd(r9, r1)
            if (r27 != 0) goto L_0x0055
            if (r28 == 0) goto L_0x007c
        L_0x0055:
            java.util.Iterator r0 = r87.iterator()
        L_0x0059:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x007c
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzbs$zzc r1 = (com.google.android.gms.internal.measurement.zzbs.zzc) r1
            java.lang.String r2 = r1.getName()
            java.lang.String r3 = "_s"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0059
            long r0 = r1.getTimestampMillis()
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r29 = r0
            goto L_0x007e
        L_0x007c:
            r29 = 0
        L_0x007e:
            r6 = 1
            r4 = 0
            if (r29 == 0) goto L_0x00c1
            if (r28 == 0) goto L_0x00c1
            com.google.android.gms.measurement.internal.zzx r1 = r85.zzgy()
            r1.zzbi()
            r1.zzo()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r86)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            java.lang.String r3 = "current_session_count"
            r0.put(r3, r2)
            android.database.sqlite.SQLiteDatabase r2 = r1.getWritableDatabase()     // Catch:{ SQLiteException -> 0x00af }
            java.lang.String r3 = "events"
            java.lang.String r5 = "app_id = ?"
            java.lang.String[] r8 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x00af }
            r8[r4] = r9     // Catch:{ SQLiteException -> 0x00af }
            r2.update(r3, r0, r5, r8)     // Catch:{ SQLiteException -> 0x00af }
            goto L_0x00c1
        L_0x00af:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgk()
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzef.zzam(r86)
            java.lang.String r3 = "Error resetting session-scoped event counts. appId"
            r1.zza(r3, r2, r0)
        L_0x00c1:
            com.google.android.gms.measurement.internal.zzx r0 = r85.zzgy()
            java.util.Map r0 = r0.zzaf(r9)
            if (r0 == 0) goto L_0x0353
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0353
            java.util.HashSet r1 = new java.util.HashSet
            java.util.Set r2 = r0.keySet()
            r1.<init>(r2)
            if (r27 == 0) goto L_0x01d6
            if (r29 == 0) goto L_0x01d6
            com.google.android.gms.measurement.internal.zzp r2 = r85.zzgx()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r86)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
            boolean r5 = r0.isEmpty()
            if (r5 != 0) goto L_0x01d7
            com.google.android.gms.measurement.internal.zzx r5 = r2.zzgy()
            java.util.Map r5 = r5.zzae(r9)
            java.util.Set r8 = r0.keySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x0103:
            boolean r17 = r8.hasNext()
            if (r17 == 0) goto L_0x01d7
            java.lang.Object r17 = r8.next()
            java.lang.Integer r17 = (java.lang.Integer) r17
            int r17 = r17.intValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r17)
            java.lang.Object r6 = r0.get(r6)
            com.google.android.gms.internal.measurement.zzbs$zzi r6 = (com.google.android.gms.internal.measurement.zzbs.zzi) r6
            java.lang.Integer r4 = java.lang.Integer.valueOf(r17)
            java.lang.Object r4 = r5.get(r4)
            java.util.List r4 = (java.util.List) r4
            if (r4 == 0) goto L_0x01bf
            boolean r20 = r4.isEmpty()
            if (r20 == 0) goto L_0x0131
            goto L_0x01bf
        L_0x0131:
            r20 = r5
            com.google.android.gms.measurement.internal.zzjo r5 = r2.zzgw()
            r21 = r8
            java.util.List r8 = r6.zzpy()
            java.util.List r5 = r5.zza((java.util.List<java.lang.Long>) r8, (java.util.List<java.lang.Integer>) r4)
            boolean r8 = r5.isEmpty()
            if (r8 != 0) goto L_0x01ba
            com.google.android.gms.internal.measurement.zzey$zza r8 = r6.zzuj()
            com.google.android.gms.internal.measurement.zzey$zza r8 = (com.google.android.gms.internal.measurement.zzey.zza) r8
            com.google.android.gms.internal.measurement.zzbs$zzi$zza r8 = (com.google.android.gms.internal.measurement.zzbs.zzi.zza) r8
            com.google.android.gms.internal.measurement.zzbs$zzi$zza r8 = r8.zzqr()
            com.google.android.gms.internal.measurement.zzbs$zzi$zza r5 = r8.zzo(r5)
            com.google.android.gms.measurement.internal.zzjo r8 = r2.zzgw()
            r22 = r2
            java.util.List r2 = r6.zzpv()
            java.util.List r2 = r8.zza((java.util.List<java.lang.Long>) r2, (java.util.List<java.lang.Integer>) r4)
            com.google.android.gms.internal.measurement.zzbs$zzi$zza r8 = r5.zzqq()
            r8.zzn(r2)
            r2 = 0
        L_0x016d:
            int r8 = r6.zzqc()
            if (r2 >= r8) goto L_0x018b
            com.google.android.gms.internal.measurement.zzbs$zzb r8 = r6.zzae(r2)
            int r8 = r8.getIndex()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            boolean r8 = r4.contains(r8)
            if (r8 == 0) goto L_0x0188
            r5.zzaj(r2)
        L_0x0188:
            int r2 = r2 + 1
            goto L_0x016d
        L_0x018b:
            r2 = 0
        L_0x018c:
            int r8 = r6.zzqf()
            if (r2 >= r8) goto L_0x01aa
            com.google.android.gms.internal.measurement.zzbs$zzj r8 = r6.zzag(r2)
            int r8 = r8.getIndex()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            boolean r8 = r4.contains(r8)
            if (r8 == 0) goto L_0x01a7
            r5.zzak(r2)
        L_0x01a7:
            int r2 = r2 + 1
            goto L_0x018c
        L_0x01aa:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)
            com.google.android.gms.internal.measurement.zzgi r4 = r5.zzug()
            com.google.android.gms.internal.measurement.zzey r4 = (com.google.android.gms.internal.measurement.zzey) r4
            com.google.android.gms.internal.measurement.zzbs$zzi r4 = (com.google.android.gms.internal.measurement.zzbs.zzi) r4
            r3.put(r2, r4)
            goto L_0x01cc
        L_0x01ba:
            r5 = r20
            r8 = r21
            goto L_0x01d2
        L_0x01bf:
            r22 = r2
            r20 = r5
            r21 = r8
            java.lang.Integer r2 = java.lang.Integer.valueOf(r17)
            r3.put(r2, r6)
        L_0x01cc:
            r5 = r20
            r8 = r21
            r2 = r22
        L_0x01d2:
            r4 = 0
            r6 = 1
            goto L_0x0103
        L_0x01d6:
            r3 = r0
        L_0x01d7:
            java.util.Iterator r1 = r1.iterator()
        L_0x01db:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0353
            java.lang.Object r2 = r1.next()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            java.lang.Object r4 = r3.get(r4)
            com.google.android.gms.internal.measurement.zzbs$zzi r4 = (com.google.android.gms.internal.measurement.zzbs.zzi) r4
            java.lang.Integer r5 = java.lang.Integer.valueOf(r2)
            java.lang.Object r5 = r14.get(r5)
            java.util.BitSet r5 = (java.util.BitSet) r5
            java.lang.Integer r6 = java.lang.Integer.valueOf(r2)
            java.lang.Object r6 = r11.get(r6)
            java.util.BitSet r6 = (java.util.BitSet) r6
            if (r25 == 0) goto L_0x026e
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            if (r4 == 0) goto L_0x0262
            int r17 = r4.zzqc()
            if (r17 != 0) goto L_0x0219
            goto L_0x0262
        L_0x0219:
            java.util.List r17 = r4.zzqb()
            java.util.Iterator r17 = r17.iterator()
        L_0x0221:
            boolean r20 = r17.hasNext()
            if (r20 == 0) goto L_0x0262
            java.lang.Object r20 = r17.next()
            com.google.android.gms.internal.measurement.zzbs$zzb r20 = (com.google.android.gms.internal.measurement.zzbs.zzb) r20
            boolean r21 = r20.zzme()
            if (r21 == 0) goto L_0x0259
            int r21 = r20.getIndex()
            r22 = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r21)
            boolean r21 = r20.zzmf()
            if (r21 == 0) goto L_0x0252
            long r20 = r20.zzmg()
            java.lang.Long r20 = java.lang.Long.valueOf(r20)
            r84 = r20
            r20 = r3
            r3 = r84
            goto L_0x0255
        L_0x0252:
            r20 = r3
            r3 = 0
        L_0x0255:
            r8.put(r1, r3)
            goto L_0x025d
        L_0x0259:
            r22 = r1
            r20 = r3
        L_0x025d:
            r3 = r20
            r1 = r22
            goto L_0x0221
        L_0x0262:
            r22 = r1
            r20 = r3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r12.put(r1, r8)
            goto L_0x0273
        L_0x026e:
            r22 = r1
            r20 = r3
            r8 = 0
        L_0x0273:
            if (r5 != 0) goto L_0x028d
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r14.put(r1, r5)
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            r11.put(r1, r6)
        L_0x028d:
            if (r4 == 0) goto L_0x02ea
            r1 = 0
        L_0x0290:
            int r3 = r4.zzpw()
            int r3 = r3 << 6
            if (r1 >= r3) goto L_0x02ea
            java.util.List r3 = r4.zzpv()
            boolean r3 = com.google.android.gms.measurement.internal.zzjo.zza((java.util.List<java.lang.Long>) r3, (int) r1)
            if (r3 == 0) goto L_0x02cf
            com.google.android.gms.measurement.internal.zzef r3 = r85.zzab()
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgs()
            r17 = r11
            java.lang.Integer r11 = java.lang.Integer.valueOf(r2)
            r21 = r12
            java.lang.Integer r12 = java.lang.Integer.valueOf(r1)
            r23 = r14
            java.lang.String r14 = "Filter already evaluated. audience ID, filter ID"
            r3.zza(r14, r11, r12)
            r6.set(r1)
            java.util.List r3 = r4.zzpy()
            boolean r3 = com.google.android.gms.measurement.internal.zzjo.zza((java.util.List<java.lang.Long>) r3, (int) r1)
            if (r3 == 0) goto L_0x02d5
            r5.set(r1)
            r3 = 1
            goto L_0x02d6
        L_0x02cf:
            r17 = r11
            r21 = r12
            r23 = r14
        L_0x02d5:
            r3 = 0
        L_0x02d6:
            if (r8 == 0) goto L_0x02e1
            if (r3 != 0) goto L_0x02e1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            r8.remove(r3)
        L_0x02e1:
            int r1 = r1 + 1
            r11 = r17
            r12 = r21
            r14 = r23
            goto L_0x0290
        L_0x02ea:
            r17 = r11
            r21 = r12
            r23 = r14
            com.google.android.gms.internal.measurement.zzbs$zza$zza r1 = com.google.android.gms.internal.measurement.zzbs.zza.zzmc()
            r3 = 0
            com.google.android.gms.internal.measurement.zzbs$zza$zza r1 = r1.zzk(r3)
            if (r27 == 0) goto L_0x0309
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            java.lang.Object r3 = r0.get(r3)
            com.google.android.gms.internal.measurement.zzbs$zzi r3 = (com.google.android.gms.internal.measurement.zzbs.zzi) r3
            r1.zza((com.google.android.gms.internal.measurement.zzbs.zzi) r3)
            goto L_0x030c
        L_0x0309:
            r1.zza((com.google.android.gms.internal.measurement.zzbs.zzi) r4)
        L_0x030c:
            com.google.android.gms.internal.measurement.zzbs$zzi$zza r3 = com.google.android.gms.internal.measurement.zzbs.zzi.zzqh()
            java.util.List r4 = com.google.android.gms.measurement.internal.zzjo.zza((java.util.BitSet) r5)
            com.google.android.gms.internal.measurement.zzbs$zzi$zza r3 = r3.zzo(r4)
            java.util.List r4 = com.google.android.gms.measurement.internal.zzjo.zza((java.util.BitSet) r6)
            com.google.android.gms.internal.measurement.zzbs$zzi$zza r3 = r3.zzn(r4)
            if (r25 == 0) goto L_0x0335
            java.util.List r4 = zza(r8)
            r3.zzp(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap
            r5.<init>()
            r10.put(r4, r5)
        L_0x0335:
            r1.zza((com.google.android.gms.internal.measurement.zzbs.zzi.zza) r3)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            com.google.android.gms.internal.measurement.zzgi r1 = r1.zzug()
            com.google.android.gms.internal.measurement.zzey r1 = (com.google.android.gms.internal.measurement.zzey) r1
            com.google.android.gms.internal.measurement.zzbs$zza r1 = (com.google.android.gms.internal.measurement.zzbs.zza) r1
            r13.put(r2, r1)
            r11 = r17
            r3 = r20
            r12 = r21
            r1 = r22
            r14 = r23
            goto L_0x01db
        L_0x0353:
            r17 = r11
            r21 = r12
            r23 = r14
            boolean r0 = r87.isEmpty()
            java.lang.String r14 = "Filter definition"
            java.lang.String r8 = "Skipping failed audience ID"
            java.lang.String r30 = "null"
            if (r0 != 0) goto L_0x09ee
            androidx.collection.ArrayMap r6 = new androidx.collection.ArrayMap
            r6.<init>()
            java.util.Iterator r31 = r87.iterator()
            r32 = 0
            r2 = r32
            r0 = 0
            r1 = 0
        L_0x0374:
            boolean r4 = r31.hasNext()
            if (r4 == 0) goto L_0x09ee
            java.lang.Object r4 = r31.next()
            com.google.android.gms.internal.measurement.zzbs$zzc r4 = (com.google.android.gms.internal.measurement.zzbs.zzc) r4
            java.lang.String r5 = r4.getName()
            java.util.List r20 = r4.zzmj()
            r85.zzgw()
            java.lang.String r11 = "_eid"
            java.lang.Object r24 = com.google.android.gms.measurement.internal.zzjo.zzb((com.google.android.gms.internal.measurement.zzbs.zzc) r4, (java.lang.String) r11)
            r12 = r24
            java.lang.Long r12 = (java.lang.Long) r12
            if (r12 == 0) goto L_0x039a
            r24 = 1
            goto L_0x039c
        L_0x039a:
            r24 = 0
        L_0x039c:
            r35 = r2
            if (r24 == 0) goto L_0x03aa
            java.lang.String r2 = "_ep"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x03aa
            r3 = 1
            goto L_0x03ab
        L_0x03aa:
            r3 = 0
        L_0x03ab:
            r37 = 1
            if (r3 == 0) goto L_0x0501
            r85.zzgw()
            java.lang.String r2 = "_en"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzjo.zzb((com.google.android.gms.internal.measurement.zzbs.zzc) r4, (java.lang.String) r2)
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            boolean r2 = android.text.TextUtils.isEmpty(r5)
            if (r2 == 0) goto L_0x03d7
            com.google.android.gms.measurement.internal.zzef r2 = r85.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgk()
            java.lang.String r3 = "Extra parameter without an event name. eventId"
            r2.zza(r3, r12)
            r41 = r6
            r39 = r8
            r18 = r15
            r11 = 0
            goto L_0x04f7
        L_0x03d7:
            if (r0 == 0) goto L_0x03ee
            if (r1 == 0) goto L_0x03ee
            long r2 = r12.longValue()
            long r39 = r1.longValue()
            int r24 = (r2 > r39 ? 1 : (r2 == r39 ? 0 : -1))
            if (r24 == 0) goto L_0x03e8
            goto L_0x03ee
        L_0x03e8:
            r11 = r0
            r24 = r1
            r2 = r35
            goto L_0x0416
        L_0x03ee:
            com.google.android.gms.measurement.internal.zzx r2 = r85.zzgy()
            android.util.Pair r2 = r2.zza((java.lang.String) r9, (java.lang.Long) r12)
            if (r2 == 0) goto L_0x04e2
            java.lang.Object r3 = r2.first
            if (r3 != 0) goto L_0x03fe
            goto L_0x04e2
        L_0x03fe:
            java.lang.Object r0 = r2.first
            com.google.android.gms.internal.measurement.zzbs$zzc r0 = (com.google.android.gms.internal.measurement.zzbs.zzc) r0
            java.lang.Object r1 = r2.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r2 = r1.longValue()
            r85.zzgw()
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzjo.zzb((com.google.android.gms.internal.measurement.zzbs.zzc) r0, (java.lang.String) r11)
            java.lang.Long r1 = (java.lang.Long) r1
            r11 = r0
            r24 = r1
        L_0x0416:
            long r35 = r2 - r37
            int r0 = (r35 > r32 ? 1 : (r35 == r32 ? 0 : -1))
            if (r0 > 0) goto L_0x0460
            com.google.android.gms.measurement.internal.zzx r1 = r85.zzgy()
            r1.zzo()
            com.google.android.gms.measurement.internal.zzef r0 = r1.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgs()
            java.lang.String r2 = "Clearing complex main event info. appId"
            r0.zza(r2, r9)
            android.database.sqlite.SQLiteDatabase r0 = r1.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0445 }
            java.lang.String r2 = "delete from main_event_params where app_id=?"
            r3 = 1
            java.lang.String[] r12 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0443 }
            r18 = 0
            r12[r18] = r9     // Catch:{ SQLiteException -> 0x0441 }
            r0.execSQL(r2, r12)     // Catch:{ SQLiteException -> 0x0441 }
            goto L_0x0456
        L_0x0441:
            r0 = move-exception
            goto L_0x0449
        L_0x0443:
            r0 = move-exception
            goto L_0x0447
        L_0x0445:
            r0 = move-exception
            r3 = 1
        L_0x0447:
            r18 = 0
        L_0x0449:
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgk()
            java.lang.String r2 = "Error clearing complex main event"
            r1.zza(r2, r0)
        L_0x0456:
            r41 = r6
            r39 = r8
            r18 = r15
            r12 = 0
            r15 = r4
            r8 = r5
            goto L_0x047b
        L_0x0460:
            r3 = 1
            r18 = 0
            com.google.android.gms.measurement.internal.zzx r1 = r85.zzgy()
            r2 = r86
            r19 = 1
            r3 = r12
            r39 = r8
            r18 = r15
            r12 = 0
            r15 = r4
            r8 = r5
            r4 = r35
            r41 = r6
            r6 = r11
            r1.zza(r2, r3, r4, r6)
        L_0x047b:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r1 = r11.zzmj()
            java.util.Iterator r1 = r1.iterator()
        L_0x0488:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x04a5
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzbs$zze r2 = (com.google.android.gms.internal.measurement.zzbs.zze) r2
            r85.zzgw()
            java.lang.String r3 = r2.getName()
            com.google.android.gms.internal.measurement.zzbs$zze r3 = com.google.android.gms.measurement.internal.zzjo.zza((com.google.android.gms.internal.measurement.zzbs.zzc) r15, (java.lang.String) r3)
            if (r3 != 0) goto L_0x0488
            r0.add(r2)
            goto L_0x0488
        L_0x04a5:
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x04ca
            java.util.Iterator r1 = r20.iterator()
        L_0x04af:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x04bf
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzbs$zze r2 = (com.google.android.gms.internal.measurement.zzbs.zze) r2
            r0.add(r2)
            goto L_0x04af
        L_0x04bf:
            r5 = r8
            r42 = r35
            r36 = r0
            r0 = r11
            r35 = r24
            r11 = 0
            goto L_0x0551
        L_0x04ca:
            com.google.android.gms.measurement.internal.zzef r0 = r85.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgn()
            java.lang.String r1 = "No unique parameters in main event. eventName"
            r0.zza(r1, r8)
            r5 = r8
            r0 = r11
            r42 = r35
            r11 = 0
            r36 = r20
            r35 = r24
            goto L_0x0551
        L_0x04e2:
            r41 = r6
            r39 = r8
            r18 = r15
            r11 = 0
            r8 = r5
            com.google.android.gms.measurement.internal.zzef r2 = r85.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgk()
            java.lang.String r3 = "Extra parameter without existing main event. eventName, eventId"
            r2.zza(r3, r8, r12)
        L_0x04f7:
            r15 = r18
            r2 = r35
            r8 = r39
            r6 = r41
            goto L_0x0374
        L_0x0501:
            r41 = r6
            r39 = r8
            r18 = r15
            r11 = 0
            r15 = r4
            if (r24 == 0) goto L_0x054a
            r85.zzgw()
            java.lang.Long r0 = java.lang.Long.valueOf(r32)
            java.lang.String r1 = "_epc"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzjo.zzb((com.google.android.gms.internal.measurement.zzbs.zzc) r15, (java.lang.String) r1)
            if (r1 != 0) goto L_0x051b
            goto L_0x051c
        L_0x051b:
            r0 = r1
        L_0x051c:
            java.lang.Long r0 = (java.lang.Long) r0
            long r35 = r0.longValue()
            int r0 = (r35 > r32 ? 1 : (r35 == r32 ? 0 : -1))
            if (r0 > 0) goto L_0x0535
            com.google.android.gms.measurement.internal.zzef r0 = r85.zzab()
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgn()
            java.lang.String r1 = "Complex event with zero extra param count. eventName"
            r0.zza(r1, r5)
            r8 = r5
            goto L_0x0543
        L_0x0535:
            com.google.android.gms.measurement.internal.zzx r1 = r85.zzgy()
            r2 = r86
            r3 = r12
            r8 = r5
            r4 = r35
            r6 = r15
            r1.zza(r2, r3, r4, r6)
        L_0x0543:
            r5 = r8
            r0 = r15
            r42 = r35
            r35 = r12
            goto L_0x054f
        L_0x054a:
            r8 = r5
            r42 = r35
            r35 = r1
        L_0x054f:
            r36 = r20
        L_0x0551:
            com.google.android.gms.measurement.internal.zzx r1 = r85.zzgy()
            java.lang.String r2 = r15.getName()
            com.google.android.gms.measurement.internal.zzae r1 = r1.zzc(r9, r2)
            if (r1 != 0) goto L_0x05e7
            com.google.android.gms.measurement.internal.zzef r1 = r85.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgn()
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzef.zzam(r86)
            com.google.android.gms.measurement.internal.zzed r3 = r85.zzy()
            java.lang.String r3 = r3.zzaj(r5)
            java.lang.String r4 = "Event aggregate wasn't created during raw event logging. appId, event"
            r1.zza(r4, r2, r3)
            if (r28 == 0) goto L_0x05b4
            com.google.android.gms.measurement.internal.zzae r1 = new com.google.android.gms.measurement.internal.zzae
            r4 = r39
            r6 = 0
            r8 = r1
            java.lang.String r2 = r15.getName()
            r3 = r10
            r10 = r2
            r19 = 1
            r2 = r17
            r44 = r21
            r11 = r19
            r16 = 1
            r47 = r13
            r49 = r14
            r48 = r23
            r13 = r16
            r34 = r15
            r50 = r18
            r15 = r16
            long r17 = r34.getTimestampMillis()
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r7 = r9
            r9 = r86
            r8.<init>(r9, r10, r11, r13, r15, r17, r19, r21, r22, r23, r24)
            goto L_0x0663
        L_0x05b4:
            r7 = r9
            r3 = r10
            r47 = r13
            r49 = r14
            r34 = r15
            r2 = r17
            r50 = r18
            r44 = r21
            r48 = r23
            r4 = r39
            r6 = 0
            com.google.android.gms.measurement.internal.zzae r1 = new com.google.android.gms.measurement.internal.zzae
            java.lang.String r10 = r34.getName()
            r11 = 1
            r13 = 1
            long r15 = r34.getTimestampMillis()
            r17 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r8 = r1
            r9 = r86
            r8.<init>(r9, r10, r11, r13, r15, r17, r19, r20, r21, r22)
            goto L_0x0663
        L_0x05e7:
            r7 = r9
            r3 = r10
            r47 = r13
            r49 = r14
            r34 = r15
            r2 = r17
            r50 = r18
            r44 = r21
            r48 = r23
            r4 = r39
            r6 = 0
            if (r28 == 0) goto L_0x0630
            com.google.android.gms.measurement.internal.zzae r8 = new com.google.android.gms.measurement.internal.zzae
            r51 = r8
            java.lang.String r9 = r1.zzce
            r52 = r9
            java.lang.String r9 = r1.name
            r53 = r9
            long r9 = r1.zzfg
            long r54 = r9 + r37
            long r9 = r1.zzfh
            long r56 = r9 + r37
            long r9 = r1.zzfi
            long r58 = r9 + r37
            long r9 = r1.zzfj
            r60 = r9
            long r9 = r1.zzfk
            r62 = r9
            java.lang.Long r9 = r1.zzfl
            r64 = r9
            java.lang.Long r9 = r1.zzfm
            r65 = r9
            java.lang.Long r9 = r1.zzfn
            r66 = r9
            java.lang.Boolean r1 = r1.zzfo
            r67 = r1
            r51.<init>(r52, r53, r54, r56, r58, r60, r62, r64, r65, r66, r67)
            goto L_0x0663
        L_0x0630:
            com.google.android.gms.measurement.internal.zzae r8 = new com.google.android.gms.measurement.internal.zzae
            r67 = r8
            java.lang.String r9 = r1.zzce
            r68 = r9
            java.lang.String r9 = r1.name
            r69 = r9
            long r9 = r1.zzfg
            long r70 = r9 + r37
            long r9 = r1.zzfh
            long r72 = r9 + r37
            long r9 = r1.zzfi
            r74 = r9
            long r9 = r1.zzfj
            r76 = r9
            long r9 = r1.zzfk
            r78 = r9
            java.lang.Long r9 = r1.zzfl
            r80 = r9
            java.lang.Long r9 = r1.zzfm
            r81 = r9
            java.lang.Long r9 = r1.zzfn
            r82 = r9
            java.lang.Boolean r1 = r1.zzfo
            r83 = r1
            r67.<init>(r68, r69, r70, r72, r74, r76, r78, r80, r81, r82, r83)
        L_0x0663:
            com.google.android.gms.measurement.internal.zzx r1 = r85.zzgy()
            r1.zza((com.google.android.gms.measurement.internal.zzae) r8)
            long r9 = r8.zzfg
            r11 = r41
            java.lang.Object r1 = r11.get(r5)
            java.util.Map r1 = (java.util.Map) r1
            if (r1 != 0) goto L_0x0688
            com.google.android.gms.measurement.internal.zzx r1 = r85.zzgy()
            java.util.Map r1 = r1.zzh(r7, r5)
            if (r1 != 0) goto L_0x0685
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap
            r1.<init>()
        L_0x0685:
            r11.put(r5, r1)
        L_0x0688:
            r12 = r1
            java.util.Set r1 = r12.keySet()
            java.util.Iterator r13 = r1.iterator()
        L_0x0691:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x09d4
            java.lang.Object r1 = r13.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r14 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
            r15 = r50
            boolean r1 = r15.contains(r1)
            if (r1 == 0) goto L_0x06bf
            com.google.android.gms.measurement.internal.zzef r1 = r85.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r1.zza(r4, r14)
            r50 = r15
            goto L_0x0691
        L_0x06bf:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
            r16 = r9
            r9 = r48
            java.lang.Object r1 = r9.get(r1)
            java.util.BitSet r1 = (java.util.BitSet) r1
            java.lang.Integer r10 = java.lang.Integer.valueOf(r14)
            java.lang.Object r10 = r2.get(r10)
            java.util.BitSet r10 = (java.util.BitSet) r10
            if (r25 == 0) goto L_0x06f6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r14)
            r18 = r10
            r10 = r44
            java.lang.Object r6 = r10.get(r6)
            java.util.Map r6 = (java.util.Map) r6
            r19 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r14)
            java.lang.Object r0 = r3.get(r0)
            java.util.Map r0 = (java.util.Map) r0
            r20 = r0
            goto L_0x06ff
        L_0x06f6:
            r19 = r0
            r18 = r10
            r10 = r44
            r6 = 0
            r20 = 0
        L_0x06ff:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r14)
            r41 = r11
            r11 = r47
            java.lang.Object r0 = r11.get(r0)
            com.google.android.gms.internal.measurement.zzbs$zza r0 = (com.google.android.gms.internal.measurement.zzbs.zza) r0
            if (r0 != 0) goto L_0x0763
            java.lang.Integer r0 = java.lang.Integer.valueOf(r14)
            com.google.android.gms.internal.measurement.zzbs$zza$zza r1 = com.google.android.gms.internal.measurement.zzbs.zza.zzmc()
            r21 = r13
            r13 = 1
            com.google.android.gms.internal.measurement.zzbs$zza$zza r1 = r1.zzk(r13)
            com.google.android.gms.internal.measurement.zzgi r1 = r1.zzug()
            com.google.android.gms.internal.measurement.zzey r1 = (com.google.android.gms.internal.measurement.zzey) r1
            com.google.android.gms.internal.measurement.zzbs$zza r1 = (com.google.android.gms.internal.measurement.zzbs.zza) r1
            r11.put(r0, r1)
            java.util.BitSet r1 = new java.util.BitSet
            r1.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r14)
            r9.put(r0, r1)
            java.util.BitSet r0 = new java.util.BitSet
            r0.<init>()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r14)
            r2.put(r13, r0)
            if (r25 == 0) goto L_0x0760
            androidx.collection.ArrayMap r6 = new androidx.collection.ArrayMap
            r6.<init>()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r14)
            r10.put(r13, r6)
            androidx.collection.ArrayMap r13 = new androidx.collection.ArrayMap
            r13.<init>()
            r18 = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r14)
            r3.put(r0, r13)
            r0 = r13
            r13 = r1
            goto L_0x0768
        L_0x0760:
            r18 = r0
            goto L_0x0765
        L_0x0763:
            r21 = r13
        L_0x0765:
            r13 = r1
            r0 = r20
        L_0x0768:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
            java.lang.Object r1 = r12.get(r1)
            java.util.List r1 = (java.util.List) r1
            java.util.Iterator r20 = r1.iterator()
        L_0x0776:
            boolean r1 = r20.hasNext()
            if (r1 == 0) goto L_0x09bf
            java.lang.Object r1 = r20.next()
            com.google.android.gms.internal.measurement.zzbk$zza r1 = (com.google.android.gms.internal.measurement.zzbk.zza) r1
            if (r28 == 0) goto L_0x0795
            if (r27 == 0) goto L_0x0795
            boolean r22 = r1.zzki()
            if (r22 == 0) goto L_0x0795
            r23 = r2
            r22 = r3
            long r2 = r8.zzfi
            r37 = r2
            goto L_0x079b
        L_0x0795:
            r23 = r2
            r22 = r3
            r37 = r16
        L_0x079b:
            com.google.android.gms.measurement.internal.zzef r2 = r85.zzab()
            r3 = 2
            boolean r2 = r2.isLoggable(r3)
            if (r2 == 0) goto L_0x07f5
            com.google.android.gms.measurement.internal.zzef r2 = r85.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgs()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r14)
            boolean r24 = r1.zzkb()
            if (r24 == 0) goto L_0x07c7
            int r24 = r1.getId()
            java.lang.Integer r24 = java.lang.Integer.valueOf(r24)
            r39 = r4
            r4 = r24
            r24 = r6
            goto L_0x07cc
        L_0x07c7:
            r39 = r4
            r24 = r6
            r4 = 0
        L_0x07cc:
            com.google.android.gms.measurement.internal.zzed r6 = r85.zzy()
            r40 = r8
            java.lang.String r8 = r1.zzjz()
            java.lang.String r6 = r6.zzaj(r8)
            java.lang.String r8 = "Evaluating filter. audience, filter, event"
            r2.zza(r8, r3, r4, r6)
            com.google.android.gms.measurement.internal.zzef r2 = r85.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgs()
            com.google.android.gms.measurement.internal.zzjo r3 = r85.zzgw()
            java.lang.String r3 = r3.zza((com.google.android.gms.internal.measurement.zzbk.zza) r1)
            r8 = r49
            r2.zza(r8, r3)
            goto L_0x07fd
        L_0x07f5:
            r39 = r4
            r24 = r6
            r40 = r8
            r8 = r49
        L_0x07fd:
            boolean r2 = r1.zzkb()
            if (r2 == 0) goto L_0x096e
            int r2 = r1.getId()
            r6 = 256(0x100, float:3.59E-43)
            if (r2 <= r6) goto L_0x080d
            goto L_0x096e
        L_0x080d:
            java.lang.String r4 = "Event filter result"
            if (r25 == 0) goto L_0x08ea
            boolean r2 = r1.zzkf()
            boolean r44 = r1.zzkg()
            if (r27 == 0) goto L_0x0823
            boolean r3 = r1.zzki()
            if (r3 == 0) goto L_0x0823
            r3 = 1
            goto L_0x0824
        L_0x0823:
            r3 = 0
        L_0x0824:
            if (r2 != 0) goto L_0x082e
            if (r44 != 0) goto L_0x082e
            if (r3 == 0) goto L_0x082b
            goto L_0x082e
        L_0x082b:
            r45 = 0
            goto L_0x0830
        L_0x082e:
            r45 = 1
        L_0x0830:
            int r2 = r1.getId()
            boolean r2 = r13.get(r2)
            if (r2 == 0) goto L_0x086b
            if (r45 != 0) goto L_0x086b
            com.google.android.gms.measurement.internal.zzef r2 = r85.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgs()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r14)
            boolean r4 = r1.zzkb()
            if (r4 == 0) goto L_0x0857
            int r1 = r1.getId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0858
        L_0x0857:
            r1 = 0
        L_0x0858:
            java.lang.String r4 = "Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r2.zza(r4, r3, r1)
            r49 = r8
            r3 = r22
            r2 = r23
            r6 = r24
            r4 = r39
            r8 = r40
            goto L_0x0776
        L_0x086b:
            r3 = r18
            r18 = r1
            r1 = r85
            r47 = r12
            r12 = r23
            r2 = r18
            r49 = r8
            r8 = r22
            r22 = r11
            r11 = r3
            r3 = r5
            r23 = r8
            r8 = r4
            r84 = r39
            r39 = r10
            r10 = r84
            r4 = r36
            r46 = r12
            r12 = r24
            r24 = r5
            r5 = r37
            java.lang.Boolean r1 = r1.zza(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzef r2 = r85.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgs()
            if (r1 != 0) goto L_0x08a3
            r3 = r30
            goto L_0x08a4
        L_0x08a3:
            r3 = r1
        L_0x08a4:
            r2.zza(r8, r3)
            if (r1 != 0) goto L_0x08b2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
            r15.add(r1)
            goto L_0x09ab
        L_0x08b2:
            int r2 = r18.getId()
            r11.set(r2)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x09ab
            int r1 = r18.getId()
            r13.set(r1)
            if (r45 == 0) goto L_0x09ab
            boolean r1 = r34.zzml()
            if (r1 == 0) goto L_0x09ab
            if (r44 == 0) goto L_0x08dd
            int r1 = r18.getId()
            long r2 = r34.getTimestampMillis()
            zzb(r0, r1, r2)
            goto L_0x09ab
        L_0x08dd:
            int r1 = r18.getId()
            long r2 = r34.getTimestampMillis()
            zza((java.util.Map<java.lang.Integer, java.lang.Long>) r12, (int) r1, (long) r2)
            goto L_0x09ab
        L_0x08ea:
            r49 = r8
            r47 = r12
            r46 = r23
            r12 = r24
            r8 = r4
            r24 = r5
            r23 = r22
            r22 = r11
            r11 = r18
            r18 = r1
            r84 = r39
            r39 = r10
            r10 = r84
            int r1 = r18.getId()
            boolean r1 = r13.get(r1)
            if (r1 == 0) goto L_0x0930
            com.google.android.gms.measurement.internal.zzef r1 = r85.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r14)
            boolean r3 = r18.zzkb()
            if (r3 == 0) goto L_0x0928
            int r3 = r18.getId()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            goto L_0x0929
        L_0x0928:
            r8 = 0
        L_0x0929:
            java.lang.String r3 = "Event filter already evaluated true. audience ID, filter ID"
            r1.zza(r3, r2, r8)
            goto L_0x09ab
        L_0x0930:
            r1 = r85
            r2 = r18
            r3 = r24
            r4 = r36
            r5 = r37
            java.lang.Boolean r1 = r1.zza(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzef r2 = r85.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgs()
            if (r1 != 0) goto L_0x094b
            r3 = r30
            goto L_0x094c
        L_0x094b:
            r3 = r1
        L_0x094c:
            r2.zza(r8, r3)
            if (r1 != 0) goto L_0x0959
            java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
            r15.add(r1)
            goto L_0x09ab
        L_0x0959:
            int r2 = r18.getId()
            r11.set(r2)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x09ab
            int r1 = r18.getId()
            r13.set(r1)
            goto L_0x09ab
        L_0x096e:
            r49 = r8
            r47 = r12
            r46 = r23
            r12 = r24
            r24 = r5
            r23 = r22
            r22 = r11
            r11 = r18
            r18 = r1
            r84 = r39
            r39 = r10
            r10 = r84
            com.google.android.gms.measurement.internal.zzef r1 = r85.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgn()
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzef.zzam(r86)
            boolean r3 = r18.zzkb()
            if (r3 == 0) goto L_0x09a1
            int r3 = r18.getId()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            goto L_0x09a2
        L_0x09a1:
            r8 = 0
        L_0x09a2:
            java.lang.String r3 = java.lang.String.valueOf(r8)
            java.lang.String r4 = "Invalid event filter ID. appId, id"
            r1.zza(r4, r2, r3)
        L_0x09ab:
            r4 = r10
            r18 = r11
            r6 = r12
            r11 = r22
            r3 = r23
            r5 = r24
            r10 = r39
            r8 = r40
            r2 = r46
            r12 = r47
            goto L_0x0776
        L_0x09bf:
            r39 = r10
            r48 = r9
            r47 = r11
            r50 = r15
            r9 = r16
            r0 = r19
            r13 = r21
            r44 = r39
            r11 = r41
            r6 = 0
            goto L_0x0691
        L_0x09d4:
            r19 = r0
            r17 = r2
            r10 = r3
            r8 = r4
            r9 = r7
            r6 = r11
            r1 = r35
            r2 = r42
            r21 = r44
            r13 = r47
            r23 = r48
            r14 = r49
            r15 = r50
            r7 = r85
            goto L_0x0374
        L_0x09ee:
            r7 = r9
            r22 = r13
            r49 = r14
            r46 = r17
            r39 = r21
            r9 = r23
            r23 = r10
            r10 = r8
            boolean r0 = r88.isEmpty()
            if (r0 != 0) goto L_0x0d6f
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            java.util.Iterator r1 = r88.iterator()
        L_0x0a0b:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0d6f
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzbs$zzk r2 = (com.google.android.gms.internal.measurement.zzbs.zzk) r2
            java.lang.String r3 = r2.getName()
            java.lang.Object r3 = r0.get(r3)
            java.util.Map r3 = (java.util.Map) r3
            if (r3 != 0) goto L_0x0a3d
            com.google.android.gms.measurement.internal.zzx r3 = r85.zzgy()
            java.lang.String r4 = r2.getName()
            java.util.Map r3 = r3.zzi(r7, r4)
            if (r3 != 0) goto L_0x0a36
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap
            r3.<init>()
        L_0x0a36:
            java.lang.String r4 = r2.getName()
            r0.put(r4, r3)
        L_0x0a3d:
            java.util.Set r4 = r3.keySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0a45:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0d5d
            java.lang.Object r5 = r4.next()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            boolean r6 = r15.contains(r6)
            if (r6 == 0) goto L_0x0a6f
            com.google.android.gms.measurement.internal.zzef r6 = r85.zzab()
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzgs()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6.zza(r10, r5)
            goto L_0x0a45
        L_0x0a6f:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            java.lang.Object r6 = r9.get(r6)
            java.util.BitSet r6 = (java.util.BitSet) r6
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
            r11 = r46
            java.lang.Object r8 = r11.get(r8)
            java.util.BitSet r8 = (java.util.BitSet) r8
            if (r25 == 0) goto L_0x0aa4
            java.lang.Integer r12 = java.lang.Integer.valueOf(r5)
            r13 = r39
            java.lang.Object r12 = r13.get(r12)
            java.util.Map r12 = (java.util.Map) r12
            java.lang.Integer r14 = java.lang.Integer.valueOf(r5)
            r87 = r1
            r1 = r23
            java.lang.Object r14 = r1.get(r14)
            java.util.Map r14 = (java.util.Map) r14
            r16 = r0
            goto L_0x0aae
        L_0x0aa4:
            r87 = r1
            r1 = r23
            r13 = r39
            r16 = r0
            r12 = 0
            r14 = 0
        L_0x0aae:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r88 = r4
            r4 = r22
            java.lang.Object r0 = r4.get(r0)
            com.google.android.gms.internal.measurement.zzbs$zza r0 = (com.google.android.gms.internal.measurement.zzbs.zza) r0
            if (r0 != 0) goto L_0x0b08
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            com.google.android.gms.internal.measurement.zzbs$zza$zza r6 = com.google.android.gms.internal.measurement.zzbs.zza.zzmc()
            r8 = 1
            com.google.android.gms.internal.measurement.zzbs$zza$zza r6 = r6.zzk(r8)
            com.google.android.gms.internal.measurement.zzgi r6 = r6.zzug()
            com.google.android.gms.internal.measurement.zzey r6 = (com.google.android.gms.internal.measurement.zzey) r6
            com.google.android.gms.internal.measurement.zzbs$zza r6 = (com.google.android.gms.internal.measurement.zzbs.zza) r6
            r4.put(r0, r6)
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r9.put(r0, r6)
            java.util.BitSet r8 = new java.util.BitSet
            r8.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r11.put(r0, r8)
            if (r25 == 0) goto L_0x0b08
            androidx.collection.ArrayMap r12 = new androidx.collection.ArrayMap
            r12.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r13.put(r0, r12)
            androidx.collection.ArrayMap r14 = new androidx.collection.ArrayMap
            r14.<init>()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r1.put(r0, r14)
        L_0x0b08:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            java.lang.Object r0 = r3.get(r0)
            java.util.List r0 = (java.util.List) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0b16:
            boolean r17 = r0.hasNext()
            if (r17 == 0) goto L_0x0d45
            java.lang.Object r17 = r0.next()
            r18 = r0
            r0 = r17
            com.google.android.gms.internal.measurement.zzbk$zzd r0 = (com.google.android.gms.internal.measurement.zzbk.zzd) r0
            r17 = r3
            com.google.android.gms.measurement.internal.zzef r3 = r85.zzab()
            r7 = 2
            boolean r3 = r3.isLoggable(r7)
            if (r3 == 0) goto L_0x0b82
            com.google.android.gms.measurement.internal.zzef r3 = r85.zzab()
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgs()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            boolean r19 = r0.zzkb()
            if (r19 == 0) goto L_0x0b54
            int r19 = r0.getId()
            java.lang.Integer r19 = java.lang.Integer.valueOf(r19)
            r22 = r1
            r39 = r10
            r10 = r19
            goto L_0x0b59
        L_0x0b54:
            r22 = r1
            r39 = r10
            r10 = 0
        L_0x0b59:
            com.google.android.gms.measurement.internal.zzed r1 = r85.zzy()
            r44 = r13
            java.lang.String r13 = r0.getPropertyName()
            java.lang.String r1 = r1.zzal(r13)
            java.lang.String r13 = "Evaluating filter. audience, filter, property"
            r3.zza(r13, r7, r10, r1)
            com.google.android.gms.measurement.internal.zzef r1 = r85.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            com.google.android.gms.measurement.internal.zzjo r3 = r85.zzgw()
            java.lang.String r3 = r3.zza((com.google.android.gms.internal.measurement.zzbk.zzd) r0)
            r7 = r49
            r1.zza(r7, r3)
            goto L_0x0b8a
        L_0x0b82:
            r22 = r1
            r39 = r10
            r44 = r13
            r7 = r49
        L_0x0b8a:
            boolean r1 = r0.zzkb()
            if (r1 == 0) goto L_0x0d00
            int r1 = r0.getId()
            r3 = 256(0x100, float:3.59E-43)
            if (r1 <= r3) goto L_0x0b9a
            goto L_0x0d00
        L_0x0b9a:
            java.lang.String r1 = "Property filter result"
            if (r25 == 0) goto L_0x0c8b
            boolean r10 = r0.zzkf()
            boolean r13 = r0.zzkg()
            if (r27 == 0) goto L_0x0bb1
            boolean r19 = r0.zzki()
            if (r19 == 0) goto L_0x0bb1
            r19 = 1
            goto L_0x0bb3
        L_0x0bb1:
            r19 = 0
        L_0x0bb3:
            if (r10 != 0) goto L_0x0bbc
            if (r13 != 0) goto L_0x0bbc
            if (r19 == 0) goto L_0x0bba
            goto L_0x0bbc
        L_0x0bba:
            r10 = 0
            goto L_0x0bbd
        L_0x0bbc:
            r10 = 1
        L_0x0bbd:
            int r3 = r0.getId()
            boolean r3 = r6.get(r3)
            if (r3 == 0) goto L_0x0bfa
            if (r10 != 0) goto L_0x0bfa
            com.google.android.gms.measurement.internal.zzef r1 = r85.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            boolean r10 = r0.zzkb()
            if (r10 == 0) goto L_0x0be4
            int r0 = r0.getId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0be5
        L_0x0be4:
            r0 = 0
        L_0x0be5:
            java.lang.String r10 = "Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r1.zza(r10, r3, r0)
            r49 = r7
            r3 = r17
            r0 = r18
            r1 = r22
            r10 = r39
            r13 = r44
            r7 = r86
            goto L_0x0b16
        L_0x0bfa:
            r3 = r85
            r49 = r7
            r7 = r86
            java.lang.Boolean r20 = r3.zza((com.google.android.gms.internal.measurement.zzbk.zzd) r0, (com.google.android.gms.internal.measurement.zzbs.zzk) r2)
            com.google.android.gms.measurement.internal.zzef r21 = r85.zzab()
            com.google.android.gms.measurement.internal.zzeh r7 = r21.zzgs()
            r23 = r11
            if (r20 != 0) goto L_0x0c13
            r11 = r30
            goto L_0x0c15
        L_0x0c13:
            r11 = r20
        L_0x0c15:
            r7.zza(r1, r11)
            if (r20 != 0) goto L_0x0c23
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r15.add(r0)
            goto L_0x0cbc
        L_0x0c23:
            int r1 = r0.getId()
            r8.set(r1)
            if (r27 == 0) goto L_0x0c34
            if (r19 == 0) goto L_0x0c34
            boolean r1 = r20.booleanValue()
            if (r1 == 0) goto L_0x0cbc
        L_0x0c34:
            if (r26 == 0) goto L_0x0c52
            int r1 = r0.getId()
            boolean r1 = r6.get(r1)
            if (r1 == 0) goto L_0x0c46
            boolean r1 = r0.zzkf()
            if (r1 == 0) goto L_0x0c5d
        L_0x0c46:
            int r1 = r0.getId()
            boolean r7 = r20.booleanValue()
            r6.set(r1, r7)
            goto L_0x0c5d
        L_0x0c52:
            int r1 = r0.getId()
            boolean r7 = r20.booleanValue()
            r6.set(r1, r7)
        L_0x0c5d:
            boolean r1 = r20.booleanValue()
            if (r1 == 0) goto L_0x0cbc
            if (r10 == 0) goto L_0x0cbc
            boolean r1 = r2.zzqs()
            if (r1 == 0) goto L_0x0cbc
            long r10 = r2.zzqt()
            if (r27 == 0) goto L_0x0c79
            if (r19 == 0) goto L_0x0c79
            if (r29 == 0) goto L_0x0c79
            long r10 = r29.longValue()
        L_0x0c79:
            if (r13 == 0) goto L_0x0c83
            int r0 = r0.getId()
            zzb(r14, r0, r10)
            goto L_0x0cbc
        L_0x0c83:
            int r0 = r0.getId()
            zza((java.util.Map<java.lang.Integer, java.lang.Long>) r12, (int) r0, (long) r10)
            goto L_0x0cbc
        L_0x0c8b:
            r3 = r85
            r49 = r7
            r23 = r11
            int r7 = r0.getId()
            boolean r7 = r6.get(r7)
            if (r7 == 0) goto L_0x0ccc
            com.google.android.gms.measurement.internal.zzef r1 = r85.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            boolean r10 = r0.zzkb()
            if (r10 == 0) goto L_0x0cb6
            int r0 = r0.getId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0cb7
        L_0x0cb6:
            r0 = 0
        L_0x0cb7:
            java.lang.String r10 = "Property filter already evaluated true. audience ID, filter ID"
            r1.zza(r10, r7, r0)
        L_0x0cbc:
            r7 = r86
            r3 = r17
            r0 = r18
            r1 = r22
            r11 = r23
            r10 = r39
            r13 = r44
            goto L_0x0b16
        L_0x0ccc:
            java.lang.Boolean r7 = r3.zza((com.google.android.gms.internal.measurement.zzbk.zzd) r0, (com.google.android.gms.internal.measurement.zzbs.zzk) r2)
            com.google.android.gms.measurement.internal.zzef r10 = r85.zzab()
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzgs()
            if (r7 != 0) goto L_0x0cdd
            r11 = r30
            goto L_0x0cde
        L_0x0cdd:
            r11 = r7
        L_0x0cde:
            r10.zza(r1, r11)
            if (r7 != 0) goto L_0x0ceb
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r15.add(r0)
            goto L_0x0cbc
        L_0x0ceb:
            int r1 = r0.getId()
            r8.set(r1)
            boolean r1 = r7.booleanValue()
            if (r1 == 0) goto L_0x0cbc
            int r0 = r0.getId()
            r6.set(r0)
            goto L_0x0cbc
        L_0x0d00:
            r3 = r85
            r49 = r7
            r23 = r11
            com.google.android.gms.measurement.internal.zzef r1 = r85.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgn()
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzef.zzam(r86)
            boolean r7 = r0.zzkb()
            if (r7 == 0) goto L_0x0d21
            int r0 = r0.getId()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            goto L_0x0d22
        L_0x0d21:
            r8 = 0
        L_0x0d22:
            java.lang.String r0 = java.lang.String.valueOf(r8)
            java.lang.String r7 = "Invalid property filter ID. appId, id"
            r1.zza(r7, r6, r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r5)
            r15.add(r0)
            r7 = r86
            r1 = r87
            r0 = r16
            r3 = r17
            r46 = r23
            r10 = r39
            r39 = r44
            r23 = r22
            r22 = r4
            goto L_0x0d59
        L_0x0d45:
            r17 = r3
            r3 = r85
            r7 = r86
            r23 = r1
            r22 = r4
            r46 = r11
            r39 = r13
            r0 = r16
            r3 = r17
            r1 = r87
        L_0x0d59:
            r4 = r88
            goto L_0x0a45
        L_0x0d5d:
            r3 = r85
            r4 = r22
            r22 = r23
            r44 = r39
            r23 = r46
            r7 = r86
            r23 = r22
            r22 = r4
            goto L_0x0a0b
        L_0x0d6f:
            r3 = r85
            r4 = r22
            r22 = r23
            r44 = r39
            r23 = r46
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Set r0 = r9.keySet()
            java.util.Iterator r2 = r0.iterator()
        L_0x0d86:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x1032
            java.lang.Object r0 = r2.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            boolean r5 = r15.contains(r5)
            if (r5 != 0) goto L_0x102c
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            java.lang.Object r5 = r4.get(r5)
            com.google.android.gms.internal.measurement.zzbs$zza r5 = (com.google.android.gms.internal.measurement.zzbs.zza) r5
            if (r5 != 0) goto L_0x0db1
            com.google.android.gms.internal.measurement.zzbs$zza$zza r5 = com.google.android.gms.internal.measurement.zzbs.zza.zzmc()
            goto L_0x0db9
        L_0x0db1:
            com.google.android.gms.internal.measurement.zzey$zza r5 = r5.zzuj()
            com.google.android.gms.internal.measurement.zzey$zza r5 = (com.google.android.gms.internal.measurement.zzey.zza) r5
            com.google.android.gms.internal.measurement.zzbs$zza$zza r5 = (com.google.android.gms.internal.measurement.zzbs.zza.C0002zza) r5
        L_0x0db9:
            r5.zzi(r0)
            com.google.android.gms.internal.measurement.zzbs$zzi$zza r6 = com.google.android.gms.internal.measurement.zzbs.zzi.zzqh()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
            java.lang.Object r7 = r9.get(r7)
            java.util.BitSet r7 = (java.util.BitSet) r7
            java.util.List r7 = com.google.android.gms.measurement.internal.zzjo.zza((java.util.BitSet) r7)
            com.google.android.gms.internal.measurement.zzbs$zzi$zza r6 = r6.zzo(r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
            r8 = r23
            java.lang.Object r7 = r8.get(r7)
            java.util.BitSet r7 = (java.util.BitSet) r7
            java.util.List r7 = com.google.android.gms.measurement.internal.zzjo.zza((java.util.BitSet) r7)
            com.google.android.gms.internal.measurement.zzbs$zzi$zza r6 = r6.zzn(r7)
            if (r25 == 0) goto L_0x0f8c
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
            r10 = r44
            java.lang.Object r7 = r10.get(r7)
            java.util.Map r7 = (java.util.Map) r7
            java.util.List r7 = zza(r7)
            r6.zzp(r7)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
            r11 = r22
            java.lang.Object r7 = r11.get(r7)
            java.util.Map r7 = (java.util.Map) r7
            if (r7 != 0) goto L_0x0e13
            java.util.List r7 = java.util.Collections.emptyList()
            r87 = r2
            r17 = r8
            goto L_0x0e86
        L_0x0e13:
            java.util.ArrayList r12 = new java.util.ArrayList
            int r13 = r7.size()
            r12.<init>(r13)
            java.util.Set r13 = r7.keySet()
            java.util.Iterator r13 = r13.iterator()
        L_0x0e24:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x0e81
            java.lang.Object r14 = r13.next()
            java.lang.Integer r14 = (java.lang.Integer) r14
            r87 = r2
            com.google.android.gms.internal.measurement.zzbs$zzj$zza r2 = com.google.android.gms.internal.measurement.zzbs.zzj.zzqo()
            int r3 = r14.intValue()
            com.google.android.gms.internal.measurement.zzbs$zzj$zza r2 = r2.zzal(r3)
            java.lang.Object r3 = r7.get(r14)
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto L_0x0e69
            java.util.Collections.sort(r3)
            java.util.Iterator r3 = r3.iterator()
        L_0x0e4d:
            boolean r14 = r3.hasNext()
            if (r14 == 0) goto L_0x0e69
            java.lang.Object r14 = r3.next()
            java.lang.Long r14 = (java.lang.Long) r14
            r88 = r7
            r17 = r8
            long r7 = r14.longValue()
            r2.zzbj(r7)
            r7 = r88
            r8 = r17
            goto L_0x0e4d
        L_0x0e69:
            r88 = r7
            r17 = r8
            com.google.android.gms.internal.measurement.zzgi r2 = r2.zzug()
            com.google.android.gms.internal.measurement.zzey r2 = (com.google.android.gms.internal.measurement.zzey) r2
            com.google.android.gms.internal.measurement.zzbs$zzj r2 = (com.google.android.gms.internal.measurement.zzbs.zzj) r2
            r12.add(r2)
            r3 = r85
            r2 = r87
            r7 = r88
            r8 = r17
            goto L_0x0e24
        L_0x0e81:
            r87 = r2
            r17 = r8
            r7 = r12
        L_0x0e86:
            if (r26 == 0) goto L_0x0e9c
            boolean r2 = r5.zzlw()
            if (r2 == 0) goto L_0x0e9c
            com.google.android.gms.internal.measurement.zzbs$zzi r2 = r5.zzlx()
            java.util.List r2 = r2.zzqe()
            boolean r3 = r2.isEmpty()
            if (r3 == 0) goto L_0x0ea0
        L_0x0e9c:
            r50 = r15
            goto L_0x0f88
        L_0x0ea0:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r7)
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap
            r7.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x0eae:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x0ee2
            java.lang.Object r8 = r2.next()
            com.google.android.gms.internal.measurement.zzbs$zzj r8 = (com.google.android.gms.internal.measurement.zzbs.zzj) r8
            boolean r12 = r8.zzme()
            if (r12 == 0) goto L_0x0ee0
            int r12 = r8.zzql()
            if (r12 <= 0) goto L_0x0ee0
            int r12 = r8.getIndex()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            int r13 = r8.zzql()
            r14 = 1
            int r13 = r13 - r14
            long r18 = r8.zzai(r13)
            java.lang.Long r8 = java.lang.Long.valueOf(r18)
            r7.put(r12, r8)
            goto L_0x0eae
        L_0x0ee0:
            r14 = 1
            goto L_0x0eae
        L_0x0ee2:
            r14 = 1
            r2 = 0
        L_0x0ee4:
            int r8 = r3.size()
            if (r2 >= r8) goto L_0x0f45
            java.lang.Object r8 = r3.get(r2)
            com.google.android.gms.internal.measurement.zzbs$zzj r8 = (com.google.android.gms.internal.measurement.zzbs.zzj) r8
            boolean r12 = r8.zzme()
            if (r12 == 0) goto L_0x0eff
            int r12 = r8.getIndex()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            goto L_0x0f00
        L_0x0eff:
            r12 = 0
        L_0x0f00:
            java.lang.Object r12 = r7.remove(r12)
            java.lang.Long r12 = (java.lang.Long) r12
            if (r12 == 0) goto L_0x0f40
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            long r18 = r12.longValue()
            r14 = 0
            long r20 = r8.zzai(r14)
            int r16 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r16 >= 0) goto L_0x0f1d
            r13.add(r12)
        L_0x0f1d:
            java.util.List r12 = r8.zzqk()
            r13.addAll(r12)
            com.google.android.gms.internal.measurement.zzey$zza r8 = r8.zzuj()
            com.google.android.gms.internal.measurement.zzey$zza r8 = (com.google.android.gms.internal.measurement.zzey.zza) r8
            com.google.android.gms.internal.measurement.zzbs$zzj$zza r8 = (com.google.android.gms.internal.measurement.zzbs.zzj.zza) r8
            com.google.android.gms.internal.measurement.zzbs$zzj$zza r8 = r8.zzqw()
            com.google.android.gms.internal.measurement.zzbs$zzj$zza r8 = r8.zzr(r13)
            com.google.android.gms.internal.measurement.zzgi r8 = r8.zzug()
            com.google.android.gms.internal.measurement.zzey r8 = (com.google.android.gms.internal.measurement.zzey) r8
            com.google.android.gms.internal.measurement.zzbs$zzj r8 = (com.google.android.gms.internal.measurement.zzbs.zzj) r8
            r3.set(r2, r8)
            goto L_0x0f41
        L_0x0f40:
            r14 = 0
        L_0x0f41:
            int r2 = r2 + 1
            r14 = 1
            goto L_0x0ee4
        L_0x0f45:
            r14 = 0
            java.util.Set r2 = r7.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0f4e:
            boolean r8 = r2.hasNext()
            if (r8 == 0) goto L_0x0f85
            java.lang.Object r8 = r2.next()
            java.lang.Integer r8 = (java.lang.Integer) r8
            com.google.android.gms.internal.measurement.zzbs$zzj$zza r12 = com.google.android.gms.internal.measurement.zzbs.zzj.zzqo()
            int r13 = r8.intValue()
            com.google.android.gms.internal.measurement.zzbs$zzj$zza r12 = r12.zzal(r13)
            java.lang.Object r8 = r7.get(r8)
            java.lang.Long r8 = (java.lang.Long) r8
            r50 = r15
            long r14 = r8.longValue()
            com.google.android.gms.internal.measurement.zzbs$zzj$zza r8 = r12.zzbj(r14)
            com.google.android.gms.internal.measurement.zzgi r8 = r8.zzug()
            com.google.android.gms.internal.measurement.zzey r8 = (com.google.android.gms.internal.measurement.zzey) r8
            com.google.android.gms.internal.measurement.zzbs$zzj r8 = (com.google.android.gms.internal.measurement.zzbs.zzj) r8
            r3.add(r8)
            r15 = r50
            r14 = 0
            goto L_0x0f4e
        L_0x0f85:
            r50 = r15
            r7 = r3
        L_0x0f88:
            r6.zzq(r7)
            goto L_0x0f96
        L_0x0f8c:
            r87 = r2
            r17 = r8
            r50 = r15
            r11 = r22
            r10 = r44
        L_0x0f96:
            r5.zza((com.google.android.gms.internal.measurement.zzbs.zzi.zza) r6)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            com.google.android.gms.internal.measurement.zzgi r3 = r5.zzug()
            com.google.android.gms.internal.measurement.zzey r3 = (com.google.android.gms.internal.measurement.zzey) r3
            com.google.android.gms.internal.measurement.zzbs$zza r3 = (com.google.android.gms.internal.measurement.zzbs.zza) r3
            r4.put(r2, r3)
            com.google.android.gms.internal.measurement.zzgi r2 = r5.zzug()
            com.google.android.gms.internal.measurement.zzey r2 = (com.google.android.gms.internal.measurement.zzey) r2
            com.google.android.gms.internal.measurement.zzbs$zza r2 = (com.google.android.gms.internal.measurement.zzbs.zza) r2
            r1.add(r2)
            com.google.android.gms.measurement.internal.zzx r2 = r85.zzgy()
            com.google.android.gms.internal.measurement.zzbs$zzi r3 = r5.zzlv()
            r2.zzbi()
            r2.zzo()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r86)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            byte[] r3 = r3.toByteArray()
            android.content.ContentValues r5 = new android.content.ContentValues
            r5.<init>()
            java.lang.String r6 = "app_id"
            r7 = r86
            r5.put(r6, r7)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r6 = "audience_id"
            r5.put(r6, r0)
            java.lang.String r0 = "current_results"
            r5.put(r0, r3)
            android.database.sqlite.SQLiteDatabase r0 = r2.getWritableDatabase()     // Catch:{ SQLiteException -> 0x100b }
            java.lang.String r3 = "audience_filter_values"
            r6 = 5
            r8 = 0
            long r5 = r0.insertWithOnConflict(r3, r8, r5, r6)     // Catch:{ SQLiteException -> 0x1009 }
            r12 = -1
            int r0 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r0 != 0) goto L_0x101e
            com.google.android.gms.measurement.internal.zzef r0 = r2.zzab()     // Catch:{ SQLiteException -> 0x1009 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgk()     // Catch:{ SQLiteException -> 0x1009 }
            java.lang.String r3 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzef.zzam(r86)     // Catch:{ SQLiteException -> 0x1009 }
            r0.zza(r3, r5)     // Catch:{ SQLiteException -> 0x1009 }
            goto L_0x101e
        L_0x1009:
            r0 = move-exception
            goto L_0x100d
        L_0x100b:
            r0 = move-exception
            r8 = 0
        L_0x100d:
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgk()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzef.zzam(r86)
            java.lang.String r5 = "Error storing filter results. appId"
            r2.zza(r5, r3, r0)
        L_0x101e:
            r3 = r85
            r2 = r87
            r44 = r10
            r22 = r11
            r23 = r17
            r15 = r50
            goto L_0x0d86
        L_0x102c:
            r7 = r86
            r3 = r85
            goto L_0x0d86
        L_0x1032:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzp.zza(java.lang.String, java.util.List, java.util.List):java.util.List");
    }

    private final Boolean zza(zzbk.zza zza, String str, List<zzbs.zze> list, long j) {
        Boolean bool;
        if (zza.zzkd()) {
            Boolean zza2 = zza(j, zza.zzke());
            if (zza2 == null) {
                return null;
            }
            if (!zza2.booleanValue()) {
                return false;
            }
        }
        HashSet hashSet = new HashSet();
        for (zzbk.zzb next : zza.zzkc()) {
            if (next.zzkr().isEmpty()) {
                zzab().zzgn().zza("null or empty param name in filter. event", zzy().zzaj(str));
                return null;
            }
            hashSet.add(next.zzkr());
        }
        ArrayMap arrayMap = new ArrayMap();
        for (zzbs.zze next2 : list) {
            if (hashSet.contains(next2.getName())) {
                if (next2.zzna()) {
                    arrayMap.put(next2.getName(), next2.zzna() ? Long.valueOf(next2.zznb()) : null);
                } else if (next2.zznd()) {
                    arrayMap.put(next2.getName(), next2.zznd() ? Double.valueOf(next2.zzne()) : null);
                } else if (next2.zzmx()) {
                    arrayMap.put(next2.getName(), next2.zzmy());
                } else {
                    zzab().zzgn().zza("Unknown value for param. event, param", zzy().zzaj(str), zzy().zzak(next2.getName()));
                    return null;
                }
            }
        }
        Iterator<zzbk.zzb> it = zza.zzkc().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                return true;
            }
            zzbk.zzb next3 = it.next();
            if (!next3.zzkp() || !next3.zzkq()) {
                z = false;
            }
            String zzkr = next3.zzkr();
            if (zzkr.isEmpty()) {
                zzab().zzgn().zza("Event has empty param name. event", zzy().zzaj(str));
                return null;
            }
            Object obj = arrayMap.get(zzkr);
            if (obj instanceof Long) {
                if (!next3.zzkn()) {
                    zzab().zzgn().zza("No number filter for long param. event, param", zzy().zzaj(str), zzy().zzak(zzkr));
                    return null;
                }
                Boolean zza3 = zza(((Long) obj).longValue(), next3.zzko());
                if (zza3 == null) {
                    return null;
                }
                if (zza3.booleanValue() == z) {
                    return false;
                }
            } else if (obj instanceof Double) {
                if (!next3.zzkn()) {
                    zzab().zzgn().zza("No number filter for double param. event, param", zzy().zzaj(str), zzy().zzak(zzkr));
                    return null;
                }
                Boolean zza4 = zza(((Double) obj).doubleValue(), next3.zzko());
                if (zza4 == null) {
                    return null;
                }
                if (zza4.booleanValue() == z) {
                    return false;
                }
            } else if (obj instanceof String) {
                if (next3.zzkl()) {
                    bool = zza((String) obj, next3.zzkm());
                } else if (next3.zzkn()) {
                    String str2 = (String) obj;
                    if (zzjo.zzbj(str2)) {
                        bool = zza(str2, next3.zzko());
                    } else {
                        zzab().zzgn().zza("Invalid param value for number filter. event, param", zzy().zzaj(str), zzy().zzak(zzkr));
                        return null;
                    }
                } else {
                    zzab().zzgn().zza("No filter for String param. event, param", zzy().zzaj(str), zzy().zzak(zzkr));
                    return null;
                }
                if (bool == null) {
                    return null;
                }
                if (bool.booleanValue() == z) {
                    return false;
                }
            } else if (obj == null) {
                zzab().zzgs().zza("Missing param for filter. event, param", zzy().zzaj(str), zzy().zzak(zzkr));
                return false;
            } else {
                zzab().zzgn().zza("Unknown param type. event, param", zzy().zzaj(str), zzy().zzak(zzkr));
                return null;
            }
        }
    }

    private final Boolean zza(zzbk.zzd zzd, zzbs.zzk zzk) {
        zzbk.zzb zzli = zzd.zzli();
        boolean zzkq = zzli.zzkq();
        if (zzk.zzna()) {
            if (zzli.zzkn()) {
                return zza(zza(zzk.zznb(), zzli.zzko()), zzkq);
            }
            zzab().zzgn().zza("No number filter for long property. property", zzy().zzal(zzk.getName()));
            return null;
        } else if (zzk.zznd()) {
            if (zzli.zzkn()) {
                return zza(zza(zzk.zzne(), zzli.zzko()), zzkq);
            }
            zzab().zzgn().zza("No number filter for double property. property", zzy().zzal(zzk.getName()));
            return null;
        } else if (!zzk.zzmx()) {
            zzab().zzgn().zza("User property has no value, property", zzy().zzal(zzk.getName()));
            return null;
        } else if (zzli.zzkl()) {
            return zza(zza(zzk.zzmy(), zzli.zzkm()), zzkq);
        } else {
            if (!zzli.zzkn()) {
                zzab().zzgn().zza("No string or number filter defined. property", zzy().zzal(zzk.getName()));
            } else if (zzjo.zzbj(zzk.zzmy())) {
                return zza(zza(zzk.zzmy(), zzli.zzko()), zzkq);
            } else {
                zzab().zzgn().zza("Invalid user property value for Numeric number filter. property, value", zzy().zzal(zzk.getName()), zzk.zzmy());
            }
            return null;
        }
    }

    private static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    private final Boolean zza(String str, zzbk.zze zze) {
        String str2;
        List<String> list;
        Preconditions.checkNotNull(zze);
        if (str == null || !zze.zzlk() || zze.zzll() == zzbk.zze.zza.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        if (zze.zzll() == zzbk.zze.zza.IN_LIST) {
            if (zze.zzlr() == 0) {
                return null;
            }
        } else if (!zze.zzlm()) {
            return null;
        }
        zzbk.zze.zza zzll = zze.zzll();
        boolean zzlp = zze.zzlp();
        if (zzlp || zzll == zzbk.zze.zza.REGEXP || zzll == zzbk.zze.zza.IN_LIST) {
            str2 = zze.zzln();
        } else {
            str2 = zze.zzln().toUpperCase(Locale.ENGLISH);
        }
        String str3 = str2;
        if (zze.zzlr() == 0) {
            list = null;
        } else {
            List<String> zzlq = zze.zzlq();
            if (!zzlp) {
                ArrayList arrayList = new ArrayList(zzlq.size());
                for (String upperCase : zzlq) {
                    arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
                }
                zzlq = Collections.unmodifiableList(arrayList);
            }
            list = zzlq;
        }
        return zza(str, zzll, zzlp, str3, list, zzll == zzbk.zze.zza.REGEXP ? str3 : null);
    }

    private final Boolean zza(String str, zzbk.zze.zza zza, boolean z, String str2, List<String> list, String str3) {
        if (str == null) {
            return null;
        }
        if (zza == zzbk.zze.zza.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && zza != zzbk.zze.zza.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (zzo.zzdu[zza.ordinal()]) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    zzab().zzgn().zza("Invalid regular expression in REGEXP audience filter. expression", str3);
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    private final Boolean zza(long j, zzbk.zzc zzc) {
        try {
            return zza(new BigDecimal(j), zzc, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean zza(double d, zzbk.zzc zzc) {
        try {
            return zza(new BigDecimal(d), zzc, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean zza(String str, zzbk.zzc zzc) {
        if (!zzjo.zzbj(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str), zzc, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0085, code lost:
        if (r2 != null) goto L_0x0087;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Boolean zza(java.math.BigDecimal r9, com.google.android.gms.internal.measurement.zzbk.zzc r10, double r11) {
        /*
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r10)
            boolean r0 = r10.zzku()
            r1 = 0
            if (r0 == 0) goto L_0x0110
            com.google.android.gms.internal.measurement.zzbk$zzc$zzb r0 = r10.zzkv()
            com.google.android.gms.internal.measurement.zzbk$zzc$zzb r2 = com.google.android.gms.internal.measurement.zzbk.zzc.zzb.UNKNOWN_COMPARISON_TYPE
            if (r0 != r2) goto L_0x0014
            goto L_0x0110
        L_0x0014:
            com.google.android.gms.internal.measurement.zzbk$zzc$zzb r0 = r10.zzkv()
            com.google.android.gms.internal.measurement.zzbk$zzc$zzb r2 = com.google.android.gms.internal.measurement.zzbk.zzc.zzb.BETWEEN
            if (r0 != r2) goto L_0x0029
            boolean r0 = r10.zzla()
            if (r0 == 0) goto L_0x0028
            boolean r0 = r10.zzlc()
            if (r0 != 0) goto L_0x0030
        L_0x0028:
            return r1
        L_0x0029:
            boolean r0 = r10.zzky()
            if (r0 != 0) goto L_0x0030
            return r1
        L_0x0030:
            com.google.android.gms.internal.measurement.zzbk$zzc$zzb r0 = r10.zzkv()
            com.google.android.gms.internal.measurement.zzbk$zzc$zzb r2 = r10.zzkv()
            com.google.android.gms.internal.measurement.zzbk$zzc$zzb r3 = com.google.android.gms.internal.measurement.zzbk.zzc.zzb.BETWEEN
            if (r2 != r3) goto L_0x0067
            java.lang.String r2 = r10.zzlb()
            boolean r2 = com.google.android.gms.measurement.internal.zzjo.zzbj(r2)
            if (r2 == 0) goto L_0x0066
            java.lang.String r2 = r10.zzld()
            boolean r2 = com.google.android.gms.measurement.internal.zzjo.zzbj(r2)
            if (r2 != 0) goto L_0x0051
            goto L_0x0066
        L_0x0051:
            java.math.BigDecimal r2 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0066 }
            java.lang.String r3 = r10.zzlb()     // Catch:{ NumberFormatException -> 0x0066 }
            r2.<init>(r3)     // Catch:{ NumberFormatException -> 0x0066 }
            java.math.BigDecimal r3 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0066 }
            java.lang.String r10 = r10.zzld()     // Catch:{ NumberFormatException -> 0x0066 }
            r3.<init>(r10)     // Catch:{ NumberFormatException -> 0x0066 }
            r10 = r2
            r2 = r1
            goto L_0x007d
        L_0x0066:
            return r1
        L_0x0067:
            java.lang.String r2 = r10.zzkz()
            boolean r2 = com.google.android.gms.measurement.internal.zzjo.zzbj(r2)
            if (r2 != 0) goto L_0x0072
            return r1
        L_0x0072:
            java.math.BigDecimal r2 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0110 }
            java.lang.String r10 = r10.zzkz()     // Catch:{ NumberFormatException -> 0x0110 }
            r2.<init>(r10)     // Catch:{ NumberFormatException -> 0x0110 }
            r10 = r1
            r3 = r10
        L_0x007d:
            com.google.android.gms.internal.measurement.zzbk$zzc$zzb r4 = com.google.android.gms.internal.measurement.zzbk.zzc.zzb.BETWEEN
            if (r0 != r4) goto L_0x0085
            if (r10 == 0) goto L_0x0084
            goto L_0x0087
        L_0x0084:
            return r1
        L_0x0085:
            if (r2 == 0) goto L_0x0110
        L_0x0087:
            int[] r4 = com.google.android.gms.measurement.internal.zzo.zzdv
            int r0 = r0.ordinal()
            r0 = r4[r0]
            r4 = -1
            r5 = 0
            r6 = 1
            if (r0 == r6) goto L_0x0104
            r7 = 2
            if (r0 == r7) goto L_0x00f8
            r8 = 3
            if (r0 == r8) goto L_0x00b0
            r11 = 4
            if (r0 == r11) goto L_0x009e
            goto L_0x0110
        L_0x009e:
            int r10 = r9.compareTo(r10)
            if (r10 == r4) goto L_0x00ab
            int r9 = r9.compareTo(r3)
            if (r9 == r6) goto L_0x00ab
            r5 = 1
        L_0x00ab:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            return r9
        L_0x00b0:
            r0 = 0
            int r10 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r10 == 0) goto L_0x00ec
            java.math.BigDecimal r10 = new java.math.BigDecimal
            r10.<init>(r11)
            java.math.BigDecimal r0 = new java.math.BigDecimal
            r0.<init>(r7)
            java.math.BigDecimal r10 = r10.multiply(r0)
            java.math.BigDecimal r10 = r2.subtract(r10)
            int r10 = r9.compareTo(r10)
            if (r10 != r6) goto L_0x00e7
            java.math.BigDecimal r10 = new java.math.BigDecimal
            r10.<init>(r11)
            java.math.BigDecimal r11 = new java.math.BigDecimal
            r11.<init>(r7)
            java.math.BigDecimal r10 = r10.multiply(r11)
            java.math.BigDecimal r10 = r2.add(r10)
            int r9 = r9.compareTo(r10)
            if (r9 != r4) goto L_0x00e7
            r5 = 1
        L_0x00e7:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            return r9
        L_0x00ec:
            int r9 = r9.compareTo(r2)
            if (r9 != 0) goto L_0x00f3
            r5 = 1
        L_0x00f3:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            return r9
        L_0x00f8:
            int r9 = r9.compareTo(r2)
            if (r9 != r6) goto L_0x00ff
            r5 = 1
        L_0x00ff:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            return r9
        L_0x0104:
            int r9 = r9.compareTo(r2)
            if (r9 != r4) goto L_0x010b
            r5 = 1
        L_0x010b:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            return r9
        L_0x0110:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzp.zza(java.math.BigDecimal, com.google.android.gms.internal.measurement.zzbk$zzc, double):java.lang.Boolean");
    }

    private static List<zzbs.zzb> zza(Map<Integer, Long> map) {
        if (map == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Integer intValue : map.keySet()) {
            int intValue2 = intValue.intValue();
            arrayList.add((zzbs.zzb) ((zzey) zzbs.zzb.zzmh().zzk(intValue2).zzae(map.get(Integer.valueOf(intValue2)).longValue()).zzug()));
        }
        return arrayList;
    }

    private static void zza(Map<Integer, Long> map, int i, long j) {
        Long l = map.get(Integer.valueOf(i));
        long j2 = j / 1000;
        if (l == null || j2 > l.longValue()) {
            map.put(Integer.valueOf(i), Long.valueOf(j2));
        }
    }

    private static void zzb(Map<Integer, List<Long>> map, int i, long j) {
        List list = map.get(Integer.valueOf(i));
        if (list == null) {
            list = new ArrayList();
            map.put(Integer.valueOf(i), list);
        }
        list.add(Long.valueOf(j / 1000));
    }
}
