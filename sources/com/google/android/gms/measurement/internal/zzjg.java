package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.braintreepayments.api.models.BinData;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzey;
import com.google.android.gms.internal.measurement.zzx;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.commons.lang3.time.DateUtils;

public class zzjg implements zzgh {
    private static volatile zzjg zzsn;
    private boolean zzdh;
    private final zzfj zzj;
    private zzfd zzso;
    private zzej zzsp;
    private zzx zzsq;
    private zzem zzsr;
    private zzjc zzss;
    private zzp zzst;
    private final zzjo zzsu;
    private zzhp zzsv;
    private boolean zzsw;
    private boolean zzsx;
    private long zzsy;
    private List<Runnable> zzsz;
    private int zzta;
    private int zztb;
    private boolean zztc;
    private boolean zztd;
    private boolean zzte;
    private FileLock zztf;
    private FileChannel zztg;
    private List<Long> zzth;
    private List<Long> zzti;
    private long zztj;

    class zza implements zzz {
        zzbs.zzg zztn;
        List<Long> zzto;
        List<zzbs.zzc> zztp;
        private long zztq;

        private zza() {
        }

        public final void zzb(zzbs.zzg zzg) {
            Preconditions.checkNotNull(zzg);
            this.zztn = zzg;
        }

        public final boolean zza(long j, zzbs.zzc zzc) {
            Preconditions.checkNotNull(zzc);
            if (this.zztp == null) {
                this.zztp = new ArrayList();
            }
            if (this.zzto == null) {
                this.zzto = new ArrayList();
            }
            if (this.zztp.size() > 0 && zza(this.zztp.get(0)) != zza(zzc)) {
                return false;
            }
            long zzuk = this.zztq + ((long) zzc.zzuk());
            if (zzuk >= ((long) Math.max(0, zzak.zzgn.get(null).intValue()))) {
                return false;
            }
            this.zztq = zzuk;
            this.zztp.add(zzc);
            this.zzto.add(Long.valueOf(j));
            if (this.zztp.size() >= Math.max(1, zzak.zzgo.get(null).intValue())) {
                return false;
            }
            return true;
        }

        private static long zza(zzbs.zzc zzc) {
            return ((zzc.getTimestampMillis() / 1000) / 60) / 60;
        }

        /* synthetic */ zza(zzjg zzjg, zzjj zzjj) {
            this();
        }
    }

    public static zzjg zzm(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzsn == null) {
            synchronized (zzjg.class) {
                if (zzsn == null) {
                    zzsn = new zzjg(new zzjm(context));
                }
            }
        }
        return zzsn;
    }

    private zzjg(zzjm zzjm) {
        this(zzjm, (zzfj) null);
    }

    private zzjg(zzjm zzjm, zzfj zzfj) {
        this.zzdh = false;
        Preconditions.checkNotNull(zzjm);
        zzfj zza2 = zzfj.zza(zzjm.zzob, (zzx) null);
        this.zzj = zza2;
        this.zztj = -1;
        zzjo zzjo = new zzjo(this);
        zzjo.initialize();
        this.zzsu = zzjo;
        zzej zzej = new zzej(this);
        zzej.initialize();
        this.zzsp = zzej;
        zzfd zzfd = new zzfd(this);
        zzfd.initialize();
        this.zzso = zzfd;
        zza2.zzaa().zza((Runnable) new zzjj(this, zzjm));
    }

    /* access modifiers changed from: private */
    public final void zza(zzjm zzjm) {
        this.zzj.zzaa().zzo();
        zzx zzx = new zzx(this);
        zzx.initialize();
        this.zzsq = zzx;
        this.zzj.zzad().zza((zzu) this.zzso);
        zzp zzp = new zzp(this);
        zzp.initialize();
        this.zzst = zzp;
        zzhp zzhp = new zzhp(this);
        zzhp.initialize();
        this.zzsv = zzhp;
        zzjc zzjc = new zzjc(this);
        zzjc.initialize();
        this.zzss = zzjc;
        this.zzsr = new zzem(this);
        if (this.zzta != this.zztb) {
            this.zzj.zzab().zzgk().zza("Not all upload components initialized", Integer.valueOf(this.zzta), Integer.valueOf(this.zztb));
        }
        this.zzdh = true;
    }

    /* access modifiers changed from: protected */
    public final void start() {
        this.zzj.zzaa().zzo();
        zzgy().zzca();
        if (this.zzj.zzac().zzlj.get() == 0) {
            this.zzj.zzac().zzlj.set(this.zzj.zzx().currentTimeMillis());
        }
        zzjn();
    }

    public final zzr zzae() {
        return this.zzj.zzae();
    }

    public final zzs zzad() {
        return this.zzj.zzad();
    }

    public final zzef zzab() {
        return this.zzj.zzab();
    }

    public final zzfc zzaa() {
        return this.zzj.zzaa();
    }

    public final zzfd zzgz() {
        zza((zzjh) this.zzso);
        return this.zzso;
    }

    public final zzej zzjf() {
        zza((zzjh) this.zzsp);
        return this.zzsp;
    }

    public final zzx zzgy() {
        zza((zzjh) this.zzsq);
        return this.zzsq;
    }

    private final zzem zzjg() {
        zzem zzem = this.zzsr;
        if (zzem != null) {
            return zzem;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzjc zzjh() {
        zza((zzjh) this.zzss);
        return this.zzss;
    }

    public final zzp zzgx() {
        zza((zzjh) this.zzst);
        return this.zzst;
    }

    public final zzhp zzji() {
        zza((zzjh) this.zzsv);
        return this.zzsv;
    }

    public final zzjo zzgw() {
        zza((zzjh) this.zzsu);
        return this.zzsu;
    }

    public final zzed zzy() {
        return this.zzj.zzy();
    }

    public final Context getContext() {
        return this.zzj.getContext();
    }

    public final Clock zzx() {
        return this.zzj.zzx();
    }

    public final zzjs zzz() {
        return this.zzj.zzz();
    }

    private final void zzo() {
        this.zzj.zzaa().zzo();
    }

    /* access modifiers changed from: package-private */
    public final void zzjj() {
        if (!this.zzdh) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    private static void zza(zzjh zzjh) {
        if (zzjh == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!zzjh.isInitialized()) {
            String valueOf = String.valueOf(zzjh.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final void zze(zzn zzn) {
        zzo();
        zzjj();
        Preconditions.checkNotEmpty(zzn.packageName);
        zzg(zzn);
    }

    private final long zzjk() {
        long currentTimeMillis = this.zzj.zzx().currentTimeMillis();
        zzeo zzac = this.zzj.zzac();
        zzac.zzbi();
        zzac.zzo();
        long j = zzac.zzln.get();
        if (j == 0) {
            j = 1 + ((long) zzac.zzz().zzjw().nextInt(86400000));
            zzac.zzln.set(j);
        }
        return ((((currentTimeMillis + j) / 1000) / 60) / 60) / 24;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(zzai zzai, String str) {
        zzai zzai2 = zzai;
        String str2 = str;
        zzf zzab = zzgy().zzab(str2);
        if (zzab == null || TextUtils.isEmpty(zzab.zzal())) {
            this.zzj.zzab().zzgr().zza("No app data available; dropping event", str2);
            return;
        }
        Boolean zzc = zzc(zzab);
        if (zzc == null) {
            if (!"_ui".equals(zzai2.name)) {
                this.zzj.zzab().zzgn().zza("Could not find package. appId", zzef.zzam(str));
            }
        } else if (!zzc.booleanValue()) {
            this.zzj.zzab().zzgk().zza("App version does not match; dropping event. appId", zzef.zzam(str));
            return;
        }
        zzn zzn = r2;
        zzf zzf = zzab;
        zzn zzn2 = new zzn(str, zzab.getGmpAppId(), zzab.zzal(), zzab.zzam(), zzab.zzan(), zzab.zzao(), zzab.zzap(), (String) null, zzab.isMeasurementEnabled(), false, zzf.getFirebaseInstanceId(), zzf.zzbd(), 0, 0, zzf.zzbe(), zzf.zzbf(), false, zzf.zzah(), zzf.zzbg(), zzf.zzaq(), zzf.zzbh());
        zzc(zzai2, zzn);
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzai zzai, zzn zzn) {
        List<zzq> list;
        List<zzq> list2;
        List<zzq> list3;
        zzai zzai2 = zzai;
        zzn zzn2 = zzn;
        Preconditions.checkNotNull(zzn);
        Preconditions.checkNotEmpty(zzn2.packageName);
        zzo();
        zzjj();
        String str = zzn2.packageName;
        long j = zzai2.zzfu;
        if (zzgw().zze(zzai2, zzn2)) {
            if (!zzn2.zzcq) {
                zzg(zzn2);
                return;
            }
            if (this.zzj.zzad().zze(str, zzak.zzix) && zzn2.zzcw != null) {
                if (zzn2.zzcw.contains(zzai2.name)) {
                    Bundle zzcv = zzai2.zzfq.zzcv();
                    zzcv.putLong("ga_safelisted", 1);
                    zzai2 = new zzai(zzai2.name, new zzah(zzcv), zzai2.origin, zzai2.zzfu);
                } else {
                    this.zzj.zzab().zzgr().zza("Dropping non-safelisted event. appId, event name, origin", str, zzai2.name, zzai2.origin);
                    return;
                }
            }
            zzgy().beginTransaction();
            try {
                zzx zzgy = zzgy();
                Preconditions.checkNotEmpty(str);
                zzgy.zzo();
                zzgy.zzbi();
                int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
                if (i < 0) {
                    zzgy.zzab().zzgn().zza("Invalid time querying timed out conditional properties", zzef.zzam(str), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zzgy.zzb("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzq next : list) {
                    if (next != null) {
                        this.zzj.zzab().zzgr().zza("User property timed out", next.packageName, this.zzj.zzy().zzal(next.zzdw.name), next.zzdw.getValue());
                        if (next.zzdx != null) {
                            zzd(new zzai(next.zzdx, j), zzn2);
                        }
                        zzgy().zzg(str, next.zzdw.name);
                    }
                }
                zzx zzgy2 = zzgy();
                Preconditions.checkNotEmpty(str);
                zzgy2.zzo();
                zzgy2.zzbi();
                if (i < 0) {
                    zzgy2.zzab().zzgn().zza("Invalid time querying expired conditional properties", zzef.zzam(str), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zzgy2.zzb("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzq next2 : list2) {
                    if (next2 != null) {
                        this.zzj.zzab().zzgr().zza("User property expired", next2.packageName, this.zzj.zzy().zzal(next2.zzdw.name), next2.zzdw.getValue());
                        zzgy().zzd(str, next2.zzdw.name);
                        if (next2.zzdz != null) {
                            arrayList.add(next2.zzdz);
                        }
                        zzgy().zzg(str, next2.zzdw.name);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList2.get(i2);
                    i2++;
                    zzd(new zzai((zzai) obj, j), zzn2);
                }
                zzx zzgy3 = zzgy();
                String str2 = zzai2.name;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zzgy3.zzo();
                zzgy3.zzbi();
                if (i < 0) {
                    zzgy3.zzab().zzgn().zza("Invalid time querying triggered conditional properties", zzef.zzam(str), zzgy3.zzy().zzaj(str2), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zzgy3.zzb("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList3 = new ArrayList(list3.size());
                for (zzq next3 : list3) {
                    if (next3 != null) {
                        zzjn zzjn = next3.zzdw;
                        zzjp zzjp = r4;
                        zzjp zzjp2 = new zzjp(next3.packageName, next3.origin, zzjn.name, j, zzjn.getValue());
                        if (zzgy().zza(zzjp)) {
                            this.zzj.zzab().zzgr().zza("User property triggered", next3.packageName, this.zzj.zzy().zzal(zzjp.name), zzjp.value);
                        } else {
                            this.zzj.zzab().zzgk().zza("Too many active user properties, ignoring", zzef.zzam(next3.packageName), this.zzj.zzy().zzal(zzjp.name), zzjp.value);
                        }
                        if (next3.zzdy != null) {
                            arrayList3.add(next3.zzdy);
                        }
                        next3.zzdw = new zzjn(zzjp);
                        next3.active = true;
                        zzgy().zza(next3);
                    }
                }
                zzd(zzai2, zzn2);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = arrayList4.get(i3);
                    i3++;
                    zzd(new zzai((zzai) obj2, j), zzn2);
                }
                zzgy().setTransactionSuccessful();
            } finally {
                zzgy().endTransaction();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:237:0x080c, code lost:
        r11 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x026e A[Catch:{ SQLiteException -> 0x0237, all -> 0x08c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x02a5 A[Catch:{ SQLiteException -> 0x0237, all -> 0x08c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x02f3 A[Catch:{ SQLiteException -> 0x0237, all -> 0x08c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0320  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzd(com.google.android.gms.measurement.internal.zzai r28, com.google.android.gms.measurement.internal.zzn r29) {
        /*
            r27 = this;
            r1 = r27
            r2 = r28
            r3 = r29
            java.lang.String r4 = "_s"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r29)
            java.lang.String r5 = r3.packageName
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            long r5 = java.lang.System.nanoTime()
            r27.zzo()
            r27.zzjj()
            java.lang.String r15 = r3.packageName
            com.google.android.gms.measurement.internal.zzjo r7 = r27.zzgw()
            boolean r7 = r7.zze(r2, r3)
            if (r7 != 0) goto L_0x0027
            return
        L_0x0027:
            boolean r7 = r3.zzcq
            if (r7 != 0) goto L_0x002f
            r1.zzg(r3)
            return
        L_0x002f:
            com.google.android.gms.measurement.internal.zzfd r7 = r27.zzgz()
            java.lang.String r8 = r2.name
            boolean r7 = r7.zzk(r15, r8)
            java.lang.String r14 = "_err"
            r13 = 0
            r12 = 1
            if (r7 == 0) goto L_0x00db
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzab()
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgn()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzef.zzam(r15)
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj
            com.google.android.gms.measurement.internal.zzed r5 = r5.zzy()
            java.lang.String r6 = r2.name
            java.lang.String r5 = r5.zzaj(r6)
            java.lang.String r6 = "Dropping blacklisted event. appId"
            r3.zza(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzfd r3 = r27.zzgz()
            boolean r3 = r3.zzbc(r15)
            if (r3 != 0) goto L_0x0075
            com.google.android.gms.measurement.internal.zzfd r3 = r27.zzgz()
            boolean r3 = r3.zzbd(r15)
            if (r3 == 0) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            r3 = 0
            goto L_0x0076
        L_0x0075:
            r3 = 1
        L_0x0076:
            if (r3 != 0) goto L_0x0091
            java.lang.String r4 = r2.name
            boolean r4 = r14.equals(r4)
            if (r4 != 0) goto L_0x0091
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj
            com.google.android.gms.measurement.internal.zzjs r7 = r4.zzz()
            r9 = 11
            java.lang.String r11 = r2.name
            r12 = 0
            java.lang.String r10 = "_ev"
            r8 = r15
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)
        L_0x0091:
            if (r3 == 0) goto L_0x00da
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()
            com.google.android.gms.measurement.internal.zzf r2 = r2.zzab(r15)
            if (r2 == 0) goto L_0x00da
            long r3 = r2.zzat()
            long r5 = r2.zzas()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj
            com.google.android.gms.common.util.Clock r5 = r5.zzx()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzak.zzhe
            java.lang.Object r5 = r5.get(r13)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00da
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzab()
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgr()
            java.lang.String r4 = "Fetching config for blacklisted app"
            r3.zzao(r4)
            r1.zzb((com.google.android.gms.measurement.internal.zzf) r2)
        L_0x00da:
            return
        L_0x00db:
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzab()
            r10 = 2
            boolean r7 = r7.isLoggable(r10)
            if (r7 == 0) goto L_0x0101
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzab()
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgs()
            com.google.android.gms.measurement.internal.zzfj r8 = r1.zzj
            com.google.android.gms.measurement.internal.zzed r8 = r8.zzy()
            java.lang.String r8 = r8.zzb((com.google.android.gms.measurement.internal.zzai) r2)
            java.lang.String r9 = "Logging event"
            r7.zza(r9, r8)
        L_0x0101:
            com.google.android.gms.measurement.internal.zzx r7 = r27.zzgy()
            r7.beginTransaction()
            r1.zzg(r3)     // Catch:{ all -> 0x08c5 }
            java.lang.String r7 = "_iap"
            java.lang.String r8 = r2.name     // Catch:{ all -> 0x08c5 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x08c5 }
            java.lang.String r8 = "ecommerce_purchase"
            if (r7 != 0) goto L_0x0125
            java.lang.String r7 = r2.name     // Catch:{ all -> 0x08c5 }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x08c5 }
            if (r7 == 0) goto L_0x0120
            goto L_0x0125
        L_0x0120:
            r23 = r5
            r5 = 0
            goto L_0x02b4
        L_0x0125:
            com.google.android.gms.measurement.internal.zzah r7 = r2.zzfq     // Catch:{ all -> 0x08c5 }
            java.lang.String r9 = "currency"
            java.lang.String r7 = r7.getString(r9)     // Catch:{ all -> 0x08c5 }
            java.lang.String r9 = r2.name     // Catch:{ all -> 0x08c5 }
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x08c5 }
            java.lang.String r9 = "value"
            if (r8 == 0) goto L_0x0189
            com.google.android.gms.measurement.internal.zzah r8 = r2.zzfq     // Catch:{ all -> 0x08c5 }
            java.lang.Double r8 = r8.zzah(r9)     // Catch:{ all -> 0x08c5 }
            double r16 = r8.doubleValue()     // Catch:{ all -> 0x08c5 }
            r18 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r16 = r16 * r18
            r20 = 0
            int r8 = (r16 > r20 ? 1 : (r16 == r20 ? 0 : -1))
            if (r8 != 0) goto L_0x015b
            com.google.android.gms.measurement.internal.zzah r8 = r2.zzfq     // Catch:{ all -> 0x08c5 }
            java.lang.Long r8 = r8.getLong(r9)     // Catch:{ all -> 0x08c5 }
            long r8 = r8.longValue()     // Catch:{ all -> 0x08c5 }
            double r8 = (double) r8     // Catch:{ all -> 0x08c5 }
            double r16 = r8 * r18
        L_0x015b:
            r8 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r18 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1))
            if (r18 > 0) goto L_0x016c
            r8 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r18 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1))
            if (r18 < 0) goto L_0x016c
            long r8 = java.lang.Math.round(r16)     // Catch:{ all -> 0x08c5 }
            goto L_0x0193
        L_0x016c:
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzab()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgn()     // Catch:{ all -> 0x08c5 }
            java.lang.String r8 = "Data lost. Currency value is too big. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzef.zzam(r15)     // Catch:{ all -> 0x08c5 }
            java.lang.Double r10 = java.lang.Double.valueOf(r16)     // Catch:{ all -> 0x08c5 }
            r7.zza(r8, r9, r10)     // Catch:{ all -> 0x08c5 }
            r23 = r5
            r5 = 0
            r11 = 0
            goto L_0x02a3
        L_0x0189:
            com.google.android.gms.measurement.internal.zzah r8 = r2.zzfq     // Catch:{ all -> 0x08c5 }
            java.lang.Long r8 = r8.getLong(r9)     // Catch:{ all -> 0x08c5 }
            long r8 = r8.longValue()     // Catch:{ all -> 0x08c5 }
        L_0x0193:
            boolean r10 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x08c5 }
            if (r10 != 0) goto L_0x029f
            java.util.Locale r10 = java.util.Locale.US     // Catch:{ all -> 0x08c5 }
            java.lang.String r7 = r7.toUpperCase(r10)     // Catch:{ all -> 0x08c5 }
            java.lang.String r10 = "[A-Z]{3}"
            boolean r10 = r7.matches(r10)     // Catch:{ all -> 0x08c5 }
            if (r10 == 0) goto L_0x029f
            java.lang.String r10 = "_ltv_"
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x08c5 }
            int r16 = r7.length()     // Catch:{ all -> 0x08c5 }
            if (r16 == 0) goto L_0x01b8
            java.lang.String r7 = r10.concat(r7)     // Catch:{ all -> 0x08c5 }
            goto L_0x01bd
        L_0x01b8:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x08c5 }
            r7.<init>(r10)     // Catch:{ all -> 0x08c5 }
        L_0x01bd:
            r10 = r7
            com.google.android.gms.measurement.internal.zzx r7 = r27.zzgy()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzjp r7 = r7.zze(r15, r10)     // Catch:{ all -> 0x08c5 }
            if (r7 == 0) goto L_0x01fe
            java.lang.Object r11 = r7.value     // Catch:{ all -> 0x08c5 }
            boolean r11 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x08c5 }
            if (r11 != 0) goto L_0x01cf
            goto L_0x01fe
        L_0x01cf:
            java.lang.Object r7 = r7.value     // Catch:{ all -> 0x08c5 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x08c5 }
            long r19 = r7.longValue()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzjp r17 = new com.google.android.gms.measurement.internal.zzjp     // Catch:{ all -> 0x08c5 }
            java.lang.String r11 = r2.origin     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.common.util.Clock r7 = r7.zzx()     // Catch:{ all -> 0x08c5 }
            long r21 = r7.currentTimeMillis()     // Catch:{ all -> 0x08c5 }
            long r19 = r19 + r8
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x08c5 }
            r7 = r17
            r8 = r15
            r9 = r11
            r11 = 2
            r23 = r5
            r5 = 0
            r6 = 1
            r11 = r21
            r13 = r19
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x08c5 }
        L_0x01fb:
            r6 = r17
            goto L_0x0264
        L_0x01fe:
            r23 = r5
            r5 = 0
            r6 = 1
            com.google.android.gms.measurement.internal.zzx r7 = r27.zzgy()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzfj r11 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzs r11 = r11.zzad()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r12 = com.google.android.gms.measurement.internal.zzak.zzhj     // Catch:{ all -> 0x08c5 }
            int r11 = r11.zzb(r15, r12)     // Catch:{ all -> 0x08c5 }
            int r11 = r11 - r6
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x08c5 }
            r7.zzo()     // Catch:{ all -> 0x08c5 }
            r7.zzbi()     // Catch:{ all -> 0x08c5 }
            android.database.sqlite.SQLiteDatabase r12 = r7.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0237 }
            java.lang.String r13 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r6 = 3
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0237 }
            r6[r5] = r15     // Catch:{ SQLiteException -> 0x0237 }
            r16 = 1
            r6[r16] = r15     // Catch:{ SQLiteException -> 0x0237 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ SQLiteException -> 0x0237 }
            r16 = 2
            r6[r16] = r11     // Catch:{ SQLiteException -> 0x0237 }
            r12.execSQL(r13, r6)     // Catch:{ SQLiteException -> 0x0237 }
            goto L_0x024a
        L_0x0237:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzab()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgk()     // Catch:{ all -> 0x08c5 }
            java.lang.String r11 = "Error pruning currencies. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzef.zzam(r15)     // Catch:{ all -> 0x08c5 }
            r7.zza(r11, r12, r6)     // Catch:{ all -> 0x08c5 }
        L_0x024a:
            com.google.android.gms.measurement.internal.zzjp r17 = new com.google.android.gms.measurement.internal.zzjp     // Catch:{ all -> 0x08c5 }
            java.lang.String r6 = r2.origin     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.common.util.Clock r7 = r7.zzx()     // Catch:{ all -> 0x08c5 }
            long r11 = r7.currentTimeMillis()     // Catch:{ all -> 0x08c5 }
            java.lang.Long r13 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x08c5 }
            r7 = r17
            r8 = r15
            r9 = r6
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x08c5 }
            goto L_0x01fb
        L_0x0264:
            com.google.android.gms.measurement.internal.zzx r7 = r27.zzgy()     // Catch:{ all -> 0x08c5 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzjp) r6)     // Catch:{ all -> 0x08c5 }
            if (r7 != 0) goto L_0x02a2
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzab()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgk()     // Catch:{ all -> 0x08c5 }
            java.lang.String r8 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzef.zzam(r15)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzfj r10 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzed r10 = r10.zzy()     // Catch:{ all -> 0x08c5 }
            java.lang.String r11 = r6.name     // Catch:{ all -> 0x08c5 }
            java.lang.String r10 = r10.zzal(r11)     // Catch:{ all -> 0x08c5 }
            java.lang.Object r6 = r6.value     // Catch:{ all -> 0x08c5 }
            r7.zza(r8, r9, r10, r6)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzjs r7 = r6.zzz()     // Catch:{ all -> 0x08c5 }
            r9 = 9
            r10 = 0
            r11 = 0
            r12 = 0
            r8 = r15
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)     // Catch:{ all -> 0x08c5 }
            goto L_0x02a2
        L_0x029f:
            r23 = r5
            r5 = 0
        L_0x02a2:
            r11 = 1
        L_0x02a3:
            if (r11 != 0) goto L_0x02b4
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()     // Catch:{ all -> 0x08c5 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()
            r2.endTransaction()
            return
        L_0x02b4:
            java.lang.String r6 = r2.name     // Catch:{ all -> 0x08c5 }
            boolean r6 = com.google.android.gms.measurement.internal.zzjs.zzbk(r6)     // Catch:{ all -> 0x08c5 }
            java.lang.String r7 = r2.name     // Catch:{ all -> 0x08c5 }
            boolean r16 = r14.equals(r7)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzx r7 = r27.zzgy()     // Catch:{ all -> 0x08c5 }
            long r8 = r27.zzjk()     // Catch:{ all -> 0x08c5 }
            r11 = 1
            r13 = 0
            r17 = 0
            r10 = r15
            r12 = r6
            r14 = r16
            r18 = r15
            r15 = r17
            com.google.android.gms.measurement.internal.zzw r7 = r7.zza(r8, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x08c5 }
            long r8 = r7.zzeg     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r10 = com.google.android.gms.measurement.internal.zzak.zzgp     // Catch:{ all -> 0x08c5 }
            r14 = 0
            java.lang.Object r10 = r10.get(r14)     // Catch:{ all -> 0x08c5 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x08c5 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x08c5 }
            long r10 = (long) r10     // Catch:{ all -> 0x08c5 }
            long r8 = r8 - r10
            r10 = 1000(0x3e8, double:4.94E-321)
            r12 = 1
            r14 = 0
            int r17 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r17 <= 0) goto L_0x0320
            long r8 = r8 % r10
            int r2 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x0311
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgk()     // Catch:{ all -> 0x08c5 }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzef.zzam(r18)     // Catch:{ all -> 0x08c5 }
            long r5 = r7.zzeg     // Catch:{ all -> 0x08c5 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x08c5 }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x08c5 }
        L_0x0311:
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()     // Catch:{ all -> 0x08c5 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()
            r2.endTransaction()
            return
        L_0x0320:
            if (r6 == 0) goto L_0x0378
            long r8 = r7.zzef     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r5 = com.google.android.gms.measurement.internal.zzak.zzgr     // Catch:{ all -> 0x08c5 }
            r12 = 0
            java.lang.Object r5 = r5.get(r12)     // Catch:{ all -> 0x08c5 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ all -> 0x08c5 }
            int r5 = r5.intValue()     // Catch:{ all -> 0x08c5 }
            long r12 = (long) r5     // Catch:{ all -> 0x08c5 }
            long r8 = r8 - r12
            int r5 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r5 <= 0) goto L_0x0378
            long r8 = r8 % r10
            r3 = 1
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0357
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzab()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch:{ all -> 0x08c5 }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzef.zzam(r18)     // Catch:{ all -> 0x08c5 }
            long r6 = r7.zzef     // Catch:{ all -> 0x08c5 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x08c5 }
            r3.zza(r4, r5, r6)     // Catch:{ all -> 0x08c5 }
        L_0x0357:
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzjs r7 = r3.zzz()     // Catch:{ all -> 0x08c5 }
            r9 = 16
            java.lang.String r10 = "_ev"
            java.lang.String r11 = r2.name     // Catch:{ all -> 0x08c5 }
            r12 = 0
            r8 = r18
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()     // Catch:{ all -> 0x08c5 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()
            r2.endTransaction()
            return
        L_0x0378:
            if (r16 == 0) goto L_0x03ca
            long r8 = r7.zzei     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzs r5 = r5.zzad()     // Catch:{ all -> 0x08c5 }
            java.lang.String r10 = r3.packageName     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r11 = com.google.android.gms.measurement.internal.zzak.zzgq     // Catch:{ all -> 0x08c5 }
            int r5 = r5.zzb(r10, r11)     // Catch:{ all -> 0x08c5 }
            r10 = 1000000(0xf4240, float:1.401298E-39)
            int r5 = java.lang.Math.min(r10, r5)     // Catch:{ all -> 0x08c5 }
            r12 = 0
            int r5 = java.lang.Math.max(r12, r5)     // Catch:{ all -> 0x08c5 }
            long r10 = (long) r5     // Catch:{ all -> 0x08c5 }
            long r8 = r8 - r10
            int r5 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r5 <= 0) goto L_0x03cb
            r10 = 1
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 != 0) goto L_0x03bb
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgk()     // Catch:{ all -> 0x08c5 }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzef.zzam(r18)     // Catch:{ all -> 0x08c5 }
            long r5 = r7.zzei     // Catch:{ all -> 0x08c5 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x08c5 }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x08c5 }
        L_0x03bb:
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()     // Catch:{ all -> 0x08c5 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()
            r2.endTransaction()
            return
        L_0x03ca:
            r12 = 0
        L_0x03cb:
            com.google.android.gms.measurement.internal.zzah r5 = r2.zzfq     // Catch:{ all -> 0x08c5 }
            android.os.Bundle r5 = r5.zzcv()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzjs r7 = r7.zzz()     // Catch:{ all -> 0x08c5 }
            java.lang.String r8 = "_o"
            java.lang.String r9 = r2.origin     // Catch:{ all -> 0x08c5 }
            r7.zza((android.os.Bundle) r5, (java.lang.String) r8, (java.lang.Object) r9)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzjs r7 = r7.zzz()     // Catch:{ all -> 0x08c5 }
            r13 = r18
            boolean r7 = r7.zzbr(r13)     // Catch:{ all -> 0x08c5 }
            java.lang.String r11 = "_r"
            if (r7 == 0) goto L_0x040c
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzjs r7 = r7.zzz()     // Catch:{ all -> 0x08c5 }
            java.lang.String r8 = "_dbg"
            r9 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x08c5 }
            r7.zza((android.os.Bundle) r5, (java.lang.String) r8, (java.lang.Object) r12)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzjs r7 = r7.zzz()     // Catch:{ all -> 0x08c5 }
            java.lang.Long r8 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x08c5 }
            r7.zza((android.os.Bundle) r5, (java.lang.String) r11, (java.lang.Object) r8)     // Catch:{ all -> 0x08c5 }
        L_0x040c:
            java.lang.String r7 = r2.name     // Catch:{ all -> 0x08c5 }
            boolean r7 = r4.equals(r7)     // Catch:{ all -> 0x08c5 }
            java.lang.String r8 = "_sno"
            if (r7 == 0) goto L_0x0441
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzs r7 = r7.zzad()     // Catch:{ all -> 0x08c5 }
            java.lang.String r9 = r3.packageName     // Catch:{ all -> 0x08c5 }
            boolean r7 = r7.zzw(r9)     // Catch:{ all -> 0x08c5 }
            if (r7 == 0) goto L_0x0441
            com.google.android.gms.measurement.internal.zzx r7 = r27.zzgy()     // Catch:{ all -> 0x08c5 }
            java.lang.String r9 = r3.packageName     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzjp r7 = r7.zze(r9, r8)     // Catch:{ all -> 0x08c5 }
            if (r7 == 0) goto L_0x0441
            java.lang.Object r9 = r7.value     // Catch:{ all -> 0x08c5 }
            boolean r9 = r9 instanceof java.lang.Long     // Catch:{ all -> 0x08c5 }
            if (r9 == 0) goto L_0x0441
            com.google.android.gms.measurement.internal.zzfj r9 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzjs r9 = r9.zzz()     // Catch:{ all -> 0x08c5 }
            java.lang.Object r7 = r7.value     // Catch:{ all -> 0x08c5 }
            r9.zza((android.os.Bundle) r5, (java.lang.String) r8, (java.lang.Object) r7)     // Catch:{ all -> 0x08c5 }
        L_0x0441:
            java.lang.String r7 = r2.name     // Catch:{ all -> 0x08c5 }
            boolean r4 = r4.equals(r7)     // Catch:{ all -> 0x08c5 }
            if (r4 == 0) goto L_0x0471
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzs r4 = r4.zzad()     // Catch:{ all -> 0x08c5 }
            java.lang.String r7 = r3.packageName     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzak.zzif     // Catch:{ all -> 0x08c5 }
            boolean r4 = r4.zze(r7, r9)     // Catch:{ all -> 0x08c5 }
            if (r4 == 0) goto L_0x0471
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzs r4 = r4.zzad()     // Catch:{ all -> 0x08c5 }
            java.lang.String r7 = r3.packageName     // Catch:{ all -> 0x08c5 }
            boolean r4 = r4.zzw(r7)     // Catch:{ all -> 0x08c5 }
            if (r4 != 0) goto L_0x0471
            com.google.android.gms.measurement.internal.zzjn r4 = new com.google.android.gms.measurement.internal.zzjn     // Catch:{ all -> 0x08c5 }
            r12 = 0
            r4.<init>(r8, r14, r12)     // Catch:{ all -> 0x08c5 }
            r1.zzc((com.google.android.gms.measurement.internal.zzjn) r4, (com.google.android.gms.measurement.internal.zzn) r3)     // Catch:{ all -> 0x08c5 }
            goto L_0x0472
        L_0x0471:
            r12 = 0
        L_0x0472:
            com.google.android.gms.measurement.internal.zzx r4 = r27.zzgy()     // Catch:{ all -> 0x08c5 }
            long r7 = r4.zzac(r13)     // Catch:{ all -> 0x08c5 }
            int r4 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r4 <= 0) goto L_0x0495
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgn()     // Catch:{ all -> 0x08c5 }
            java.lang.String r9 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzef.zzam(r13)     // Catch:{ all -> 0x08c5 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x08c5 }
            r4.zza(r9, r10, r7)     // Catch:{ all -> 0x08c5 }
        L_0x0495:
            com.google.android.gms.measurement.internal.zzaf r4 = new com.google.android.gms.measurement.internal.zzaf     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzfj r8 = r1.zzj     // Catch:{ all -> 0x08c5 }
            java.lang.String r9 = r2.origin     // Catch:{ all -> 0x08c5 }
            java.lang.String r10 = r2.name     // Catch:{ all -> 0x08c5 }
            long r14 = r2.zzfu     // Catch:{ all -> 0x08c5 }
            r19 = 0
            r7 = r4
            r2 = r10
            r10 = r13
            r26 = r11
            r11 = r2
            r16 = r12
            r2 = r13
            r25 = 0
            r12 = r14
            r28 = r16
            r14 = r19
            r16 = r5
            r7.<init>((com.google.android.gms.measurement.internal.zzfj) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (long) r12, (long) r14, (android.os.Bundle) r16)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzx r5 = r27.zzgy()     // Catch:{ all -> 0x08c5 }
            java.lang.String r7 = r4.name     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzae r5 = r5.zzc(r2, r7)     // Catch:{ all -> 0x08c5 }
            if (r5 != 0) goto L_0x0528
            com.google.android.gms.measurement.internal.zzx r5 = r27.zzgy()     // Catch:{ all -> 0x08c5 }
            long r7 = r5.zzag(r2)     // Catch:{ all -> 0x08c5 }
            r9 = 500(0x1f4, double:2.47E-321)
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 < 0) goto L_0x050e
            if (r6 == 0) goto L_0x050e
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzab()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzgk()     // Catch:{ all -> 0x08c5 }
            java.lang.String r5 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzef.zzam(r2)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzed r7 = r7.zzy()     // Catch:{ all -> 0x08c5 }
            java.lang.String r4 = r4.name     // Catch:{ all -> 0x08c5 }
            java.lang.String r4 = r7.zzaj(r4)     // Catch:{ all -> 0x08c5 }
            r7 = 500(0x1f4, float:7.0E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x08c5 }
            r3.zza(r5, r6, r4, r7)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzjs r7 = r3.zzz()     // Catch:{ all -> 0x08c5 }
            r9 = 8
            r10 = 0
            r11 = 0
            r12 = 0
            r8 = r2
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()
            r2.endTransaction()
            return
        L_0x050e:
            com.google.android.gms.measurement.internal.zzae r5 = new com.google.android.gms.measurement.internal.zzae     // Catch:{ all -> 0x08c5 }
            java.lang.String r9 = r4.name     // Catch:{ all -> 0x08c5 }
            r10 = 0
            r12 = 0
            long r14 = r4.timestamp     // Catch:{ all -> 0x08c5 }
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r7 = r5
            r8 = r2
            r7.<init>(r8, r9, r10, r12, r14, r16, r18, r19, r20, r21)     // Catch:{ all -> 0x08c5 }
            goto L_0x0536
        L_0x0528:
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj     // Catch:{ all -> 0x08c5 }
            long r6 = r5.zzfj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzaf r4 = r4.zza(r2, r6)     // Catch:{ all -> 0x08c5 }
            long r6 = r4.timestamp     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzae r5 = r5.zzw(r6)     // Catch:{ all -> 0x08c5 }
        L_0x0536:
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()     // Catch:{ all -> 0x08c5 }
            r2.zza((com.google.android.gms.measurement.internal.zzae) r5)     // Catch:{ all -> 0x08c5 }
            r27.zzo()     // Catch:{ all -> 0x08c5 }
            r27.zzjj()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r29)     // Catch:{ all -> 0x08c5 }
            java.lang.String r2 = r4.zzce     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x08c5 }
            java.lang.String r2 = r4.zzce     // Catch:{ all -> 0x08c5 }
            java.lang.String r5 = r3.packageName     // Catch:{ all -> 0x08c5 }
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r2 = com.google.android.gms.internal.measurement.zzbs.zzg.zzpr()     // Catch:{ all -> 0x08c5 }
            r5 = 1
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r2 = r2.zzp(r5)     // Catch:{ all -> 0x08c5 }
            java.lang.String r6 = "android"
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r2 = r2.zzcc(r6)     // Catch:{ all -> 0x08c5 }
            java.lang.String r6 = r3.packageName     // Catch:{ all -> 0x08c5 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c5 }
            if (r6 != 0) goto L_0x0575
            java.lang.String r6 = r3.packageName     // Catch:{ all -> 0x08c5 }
            r2.zzch(r6)     // Catch:{ all -> 0x08c5 }
        L_0x0575:
            java.lang.String r6 = r3.zzco     // Catch:{ all -> 0x08c5 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c5 }
            if (r6 != 0) goto L_0x0582
            java.lang.String r6 = r3.zzco     // Catch:{ all -> 0x08c5 }
            r2.zzcg(r6)     // Catch:{ all -> 0x08c5 }
        L_0x0582:
            java.lang.String r6 = r3.zzcm     // Catch:{ all -> 0x08c5 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c5 }
            if (r6 != 0) goto L_0x058f
            java.lang.String r6 = r3.zzcm     // Catch:{ all -> 0x08c5 }
            r2.zzci(r6)     // Catch:{ all -> 0x08c5 }
        L_0x058f:
            long r6 = r3.zzcn     // Catch:{ all -> 0x08c5 }
            r8 = -2147483648(0xffffffff80000000, double:NaN)
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x059e
            long r6 = r3.zzcn     // Catch:{ all -> 0x08c5 }
            int r7 = (int) r6     // Catch:{ all -> 0x08c5 }
            r2.zzv(r7)     // Catch:{ all -> 0x08c5 }
        L_0x059e:
            long r6 = r3.zzr     // Catch:{ all -> 0x08c5 }
            r2.zzas(r6)     // Catch:{ all -> 0x08c5 }
            java.lang.String r6 = r3.zzcg     // Catch:{ all -> 0x08c5 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c5 }
            if (r6 != 0) goto L_0x05b0
            java.lang.String r6 = r3.zzcg     // Catch:{ all -> 0x08c5 }
            r2.zzcm(r6)     // Catch:{ all -> 0x08c5 }
        L_0x05b0:
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzad()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzak.zzit     // Catch:{ all -> 0x08c5 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean>) r7)     // Catch:{ all -> 0x08c5 }
            if (r6 == 0) goto L_0x05d6
            java.lang.String r6 = r2.getGmpAppId()     // Catch:{ all -> 0x08c5 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c5 }
            if (r6 == 0) goto L_0x05e3
            java.lang.String r6 = r3.zzcu     // Catch:{ all -> 0x08c5 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c5 }
            if (r6 != 0) goto L_0x05e3
            java.lang.String r6 = r3.zzcu     // Catch:{ all -> 0x08c5 }
            r2.zzcq(r6)     // Catch:{ all -> 0x08c5 }
            goto L_0x05e3
        L_0x05d6:
            java.lang.String r6 = r3.zzcu     // Catch:{ all -> 0x08c5 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c5 }
            if (r6 != 0) goto L_0x05e3
            java.lang.String r6 = r3.zzcu     // Catch:{ all -> 0x08c5 }
            r2.zzcq(r6)     // Catch:{ all -> 0x08c5 }
        L_0x05e3:
            long r6 = r3.zzcp     // Catch:{ all -> 0x08c5 }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x05f0
            long r6 = r3.zzcp     // Catch:{ all -> 0x08c5 }
            r2.zzau(r6)     // Catch:{ all -> 0x08c5 }
        L_0x05f0:
            long r6 = r3.zzs     // Catch:{ all -> 0x08c5 }
            r2.zzax(r6)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzad()     // Catch:{ all -> 0x08c5 }
            java.lang.String r7 = r3.packageName     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzak.zzin     // Catch:{ all -> 0x08c5 }
            boolean r6 = r6.zze(r7, r10)     // Catch:{ all -> 0x08c5 }
            if (r6 == 0) goto L_0x0612
            com.google.android.gms.measurement.internal.zzjo r6 = r27.zzgw()     // Catch:{ all -> 0x08c5 }
            java.util.List r6 = r6.zzju()     // Catch:{ all -> 0x08c5 }
            if (r6 == 0) goto L_0x0612
            r2.zzd(r6)     // Catch:{ all -> 0x08c5 }
        L_0x0612:
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzeo r6 = r6.zzac()     // Catch:{ all -> 0x08c5 }
            java.lang.String r7 = r3.packageName     // Catch:{ all -> 0x08c5 }
            android.util.Pair r6 = r6.zzap(r7)     // Catch:{ all -> 0x08c5 }
            if (r6 == 0) goto L_0x0645
            java.lang.Object r7 = r6.first     // Catch:{ all -> 0x08c5 }
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x08c5 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x08c5 }
            if (r7 != 0) goto L_0x0645
            boolean r7 = r3.zzcs     // Catch:{ all -> 0x08c5 }
            if (r7 == 0) goto L_0x06a7
            java.lang.Object r7 = r6.first     // Catch:{ all -> 0x08c5 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x08c5 }
            r2.zzcj(r7)     // Catch:{ all -> 0x08c5 }
            java.lang.Object r7 = r6.second     // Catch:{ all -> 0x08c5 }
            if (r7 == 0) goto L_0x06a7
            java.lang.Object r6 = r6.second     // Catch:{ all -> 0x08c5 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x08c5 }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x08c5 }
            r2.zzm(r6)     // Catch:{ all -> 0x08c5 }
            goto L_0x06a7
        L_0x0645:
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzac r6 = r6.zzw()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c5 }
            android.content.Context r7 = r7.getContext()     // Catch:{ all -> 0x08c5 }
            boolean r6 = r6.zzj(r7)     // Catch:{ all -> 0x08c5 }
            if (r6 != 0) goto L_0x06a7
            boolean r6 = r3.zzct     // Catch:{ all -> 0x08c5 }
            if (r6 == 0) goto L_0x06a7
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c5 }
            android.content.Context r6 = r6.getContext()     // Catch:{ all -> 0x08c5 }
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ all -> 0x08c5 }
            java.lang.String r7 = "android_id"
            java.lang.String r6 = android.provider.Settings.Secure.getString(r6, r7)     // Catch:{ all -> 0x08c5 }
            if (r6 != 0) goto L_0x0687
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzab()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzgn()     // Catch:{ all -> 0x08c5 }
            java.lang.String r7 = "null secure ID. appId"
            java.lang.String r10 = r2.zzag()     // Catch:{ all -> 0x08c5 }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzef.zzam(r10)     // Catch:{ all -> 0x08c5 }
            r6.zza(r7, r10)     // Catch:{ all -> 0x08c5 }
            java.lang.String r6 = "null"
            goto L_0x06a4
        L_0x0687:
            boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x08c5 }
            if (r7 == 0) goto L_0x06a4
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzab()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgn()     // Catch:{ all -> 0x08c5 }
            java.lang.String r10 = "empty secure ID. appId"
            java.lang.String r11 = r2.zzag()     // Catch:{ all -> 0x08c5 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzef.zzam(r11)     // Catch:{ all -> 0x08c5 }
            r7.zza(r10, r11)     // Catch:{ all -> 0x08c5 }
        L_0x06a4:
            r2.zzco(r6)     // Catch:{ all -> 0x08c5 }
        L_0x06a7:
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzac r6 = r6.zzw()     // Catch:{ all -> 0x08c5 }
            r6.zzbi()     // Catch:{ all -> 0x08c5 }
            java.lang.String r6 = android.os.Build.MODEL     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r6 = r2.zzce(r6)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzac r7 = r7.zzw()     // Catch:{ all -> 0x08c5 }
            r7.zzbi()     // Catch:{ all -> 0x08c5 }
            java.lang.String r7 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r6 = r6.zzcd(r7)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzac r7 = r7.zzw()     // Catch:{ all -> 0x08c5 }
            long r10 = r7.zzcq()     // Catch:{ all -> 0x08c5 }
            int r7 = (int) r10     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r6 = r6.zzt(r7)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzac r7 = r7.zzw()     // Catch:{ all -> 0x08c5 }
            java.lang.String r7 = r7.zzcr()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r6 = r6.zzcf(r7)     // Catch:{ all -> 0x08c5 }
            long r10 = r3.zzcr     // Catch:{ all -> 0x08c5 }
            r6.zzaw(r10)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x08c5 }
            boolean r6 = r6.isEnabled()     // Catch:{ all -> 0x08c5 }
            if (r6 == 0) goto L_0x0703
            boolean r6 = com.google.android.gms.measurement.internal.zzs.zzbv()     // Catch:{ all -> 0x08c5 }
            if (r6 == 0) goto L_0x0703
            r2.zzag()     // Catch:{ all -> 0x08c5 }
            boolean r6 = android.text.TextUtils.isEmpty(r28)     // Catch:{ all -> 0x08c5 }
            if (r6 != 0) goto L_0x0703
            r6 = r28
            r2.zzcp(r6)     // Catch:{ all -> 0x08c5 }
        L_0x0703:
            com.google.android.gms.measurement.internal.zzx r6 = r27.zzgy()     // Catch:{ all -> 0x08c5 }
            java.lang.String r7 = r3.packageName     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzf r6 = r6.zzab(r7)     // Catch:{ all -> 0x08c5 }
            if (r6 != 0) goto L_0x0776
            com.google.android.gms.measurement.internal.zzf r6 = new com.google.android.gms.measurement.internal.zzf     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c5 }
            java.lang.String r10 = r3.packageName     // Catch:{ all -> 0x08c5 }
            r6.<init>(r7, r10)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzjs r7 = r7.zzz()     // Catch:{ all -> 0x08c5 }
            java.lang.String r7 = r7.zzjy()     // Catch:{ all -> 0x08c5 }
            r6.zza((java.lang.String) r7)     // Catch:{ all -> 0x08c5 }
            java.lang.String r7 = r3.zzci     // Catch:{ all -> 0x08c5 }
            r6.zze((java.lang.String) r7)     // Catch:{ all -> 0x08c5 }
            java.lang.String r7 = r3.zzcg     // Catch:{ all -> 0x08c5 }
            r6.zzb((java.lang.String) r7)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzac()     // Catch:{ all -> 0x08c5 }
            java.lang.String r10 = r3.packageName     // Catch:{ all -> 0x08c5 }
            java.lang.String r7 = r7.zzaq(r10)     // Catch:{ all -> 0x08c5 }
            r6.zzd(r7)     // Catch:{ all -> 0x08c5 }
            r6.zzk(r8)     // Catch:{ all -> 0x08c5 }
            r6.zze((long) r8)     // Catch:{ all -> 0x08c5 }
            r6.zzf((long) r8)     // Catch:{ all -> 0x08c5 }
            java.lang.String r7 = r3.zzcm     // Catch:{ all -> 0x08c5 }
            r6.zzf((java.lang.String) r7)     // Catch:{ all -> 0x08c5 }
            long r10 = r3.zzcn     // Catch:{ all -> 0x08c5 }
            r6.zzg((long) r10)     // Catch:{ all -> 0x08c5 }
            java.lang.String r7 = r3.zzco     // Catch:{ all -> 0x08c5 }
            r6.zzg((java.lang.String) r7)     // Catch:{ all -> 0x08c5 }
            long r10 = r3.zzr     // Catch:{ all -> 0x08c5 }
            r6.zzh((long) r10)     // Catch:{ all -> 0x08c5 }
            long r10 = r3.zzcp     // Catch:{ all -> 0x08c5 }
            r6.zzi(r10)     // Catch:{ all -> 0x08c5 }
            boolean r7 = r3.zzcq     // Catch:{ all -> 0x08c5 }
            r6.setMeasurementEnabled(r7)     // Catch:{ all -> 0x08c5 }
            long r10 = r3.zzcr     // Catch:{ all -> 0x08c5 }
            r6.zzt(r10)     // Catch:{ all -> 0x08c5 }
            long r10 = r3.zzs     // Catch:{ all -> 0x08c5 }
            r6.zzj(r10)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzx r7 = r27.zzgy()     // Catch:{ all -> 0x08c5 }
            r7.zza((com.google.android.gms.measurement.internal.zzf) r6)     // Catch:{ all -> 0x08c5 }
        L_0x0776:
            java.lang.String r7 = r6.getAppInstanceId()     // Catch:{ all -> 0x08c5 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x08c5 }
            if (r7 != 0) goto L_0x0787
            java.lang.String r7 = r6.getAppInstanceId()     // Catch:{ all -> 0x08c5 }
            r2.zzck(r7)     // Catch:{ all -> 0x08c5 }
        L_0x0787:
            java.lang.String r7 = r6.getFirebaseInstanceId()     // Catch:{ all -> 0x08c5 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x08c5 }
            if (r7 != 0) goto L_0x0798
            java.lang.String r6 = r6.getFirebaseInstanceId()     // Catch:{ all -> 0x08c5 }
            r2.zzcn(r6)     // Catch:{ all -> 0x08c5 }
        L_0x0798:
            com.google.android.gms.measurement.internal.zzx r6 = r27.zzgy()     // Catch:{ all -> 0x08c5 }
            java.lang.String r3 = r3.packageName     // Catch:{ all -> 0x08c5 }
            java.util.List r3 = r6.zzaa(r3)     // Catch:{ all -> 0x08c5 }
            r11 = 0
        L_0x07a3:
            int r6 = r3.size()     // Catch:{ all -> 0x08c5 }
            if (r11 >= r6) goto L_0x07da
            com.google.android.gms.internal.measurement.zzbs$zzk$zza r6 = com.google.android.gms.internal.measurement.zzbs.zzk.zzqu()     // Catch:{ all -> 0x08c5 }
            java.lang.Object r7 = r3.get(r11)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzjp r7 = (com.google.android.gms.measurement.internal.zzjp) r7     // Catch:{ all -> 0x08c5 }
            java.lang.String r7 = r7.name     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.internal.measurement.zzbs$zzk$zza r6 = r6.zzdb(r7)     // Catch:{ all -> 0x08c5 }
            java.lang.Object r7 = r3.get(r11)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzjp r7 = (com.google.android.gms.measurement.internal.zzjp) r7     // Catch:{ all -> 0x08c5 }
            long r12 = r7.zztr     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.internal.measurement.zzbs$zzk$zza r6 = r6.zzbk(r12)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzjo r7 = r27.zzgw()     // Catch:{ all -> 0x08c5 }
            java.lang.Object r10 = r3.get(r11)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzjp r10 = (com.google.android.gms.measurement.internal.zzjp) r10     // Catch:{ all -> 0x08c5 }
            java.lang.Object r10 = r10.value     // Catch:{ all -> 0x08c5 }
            r7.zza((com.google.android.gms.internal.measurement.zzbs.zzk.zza) r6, (java.lang.Object) r10)     // Catch:{ all -> 0x08c5 }
            r2.zza((com.google.android.gms.internal.measurement.zzbs.zzk.zza) r6)     // Catch:{ all -> 0x08c5 }
            int r11 = r11 + 1
            goto L_0x07a3
        L_0x07da:
            com.google.android.gms.measurement.internal.zzx r3 = r27.zzgy()     // Catch:{ IOException -> 0x0853 }
            com.google.android.gms.internal.measurement.zzgi r6 = r2.zzug()     // Catch:{ IOException -> 0x0853 }
            com.google.android.gms.internal.measurement.zzey r6 = (com.google.android.gms.internal.measurement.zzey) r6     // Catch:{ IOException -> 0x0853 }
            com.google.android.gms.internal.measurement.zzbs$zzg r6 = (com.google.android.gms.internal.measurement.zzbs.zzg) r6     // Catch:{ IOException -> 0x0853 }
            long r2 = r3.zza((com.google.android.gms.internal.measurement.zzbs.zzg) r6)     // Catch:{ IOException -> 0x0853 }
            com.google.android.gms.measurement.internal.zzx r6 = r27.zzgy()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzah r7 = r4.zzfq     // Catch:{ all -> 0x08c5 }
            if (r7 == 0) goto L_0x0849
            com.google.android.gms.measurement.internal.zzah r7 = r4.zzfq     // Catch:{ all -> 0x08c5 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x08c5 }
        L_0x07f8:
            boolean r10 = r7.hasNext()     // Catch:{ all -> 0x08c5 }
            if (r10 == 0) goto L_0x0811
            java.lang.Object r10 = r7.next()     // Catch:{ all -> 0x08c5 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x08c5 }
            r11 = r26
            boolean r10 = r11.equals(r10)     // Catch:{ all -> 0x08c5 }
            if (r10 == 0) goto L_0x080e
        L_0x080c:
            r11 = 1
            goto L_0x084a
        L_0x080e:
            r26 = r11
            goto L_0x07f8
        L_0x0811:
            com.google.android.gms.measurement.internal.zzfd r7 = r27.zzgz()     // Catch:{ all -> 0x08c5 }
            java.lang.String r10 = r4.zzce     // Catch:{ all -> 0x08c5 }
            java.lang.String r11 = r4.name     // Catch:{ all -> 0x08c5 }
            boolean r7 = r7.zzl(r10, r11)     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzx r10 = r27.zzgy()     // Catch:{ all -> 0x08c5 }
            long r11 = r27.zzjk()     // Catch:{ all -> 0x08c5 }
            java.lang.String r13 = r4.zzce     // Catch:{ all -> 0x08c5 }
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            com.google.android.gms.measurement.internal.zzw r10 = r10.zza(r11, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x08c5 }
            if (r7 == 0) goto L_0x0849
            long r10 = r10.zzej     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzs r7 = r7.zzad()     // Catch:{ all -> 0x08c5 }
            java.lang.String r12 = r4.zzce     // Catch:{ all -> 0x08c5 }
            int r7 = r7.zzi(r12)     // Catch:{ all -> 0x08c5 }
            long r12 = (long) r7     // Catch:{ all -> 0x08c5 }
            int r7 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r7 >= 0) goto L_0x0849
            goto L_0x080c
        L_0x0849:
            r11 = 0
        L_0x084a:
            boolean r2 = r6.zza((com.google.android.gms.measurement.internal.zzaf) r4, (long) r2, (boolean) r11)     // Catch:{ all -> 0x08c5 }
            if (r2 == 0) goto L_0x086c
            r1.zzsy = r8     // Catch:{ all -> 0x08c5 }
            goto L_0x086c
        L_0x0853:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzab()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzgk()     // Catch:{ all -> 0x08c5 }
            java.lang.String r6 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r2 = r2.zzag()     // Catch:{ all -> 0x08c5 }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzef.zzam(r2)     // Catch:{ all -> 0x08c5 }
            r5.zza(r6, r2, r3)     // Catch:{ all -> 0x08c5 }
        L_0x086c:
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()     // Catch:{ all -> 0x08c5 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()     // Catch:{ all -> 0x08c5 }
            r3 = 2
            boolean r2 = r2.isLoggable(r3)     // Catch:{ all -> 0x08c5 }
            if (r2 == 0) goto L_0x0899
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgs()     // Catch:{ all -> 0x08c5 }
            java.lang.String r3 = "Event recorded"
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x08c5 }
            com.google.android.gms.measurement.internal.zzed r5 = r5.zzy()     // Catch:{ all -> 0x08c5 }
            java.lang.String r4 = r5.zza(r4)     // Catch:{ all -> 0x08c5 }
            r2.zza(r3, r4)     // Catch:{ all -> 0x08c5 }
        L_0x0899:
            com.google.android.gms.measurement.internal.zzx r2 = r27.zzgy()
            r2.endTransaction()
            r27.zzjn()
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgs()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r23
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zza(r4, r3)
            return
        L_0x08c5:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzx r3 = r27.zzgy()
            r3.endTransaction()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.zzd(com.google.android.gms.measurement.internal.zzai, com.google.android.gms.measurement.internal.zzn):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:95|96) */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        r1.zzj.zzab().zzgk().zza("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzef.zzam(r5), r9);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x02c6 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzjl() {
        /*
            r17 = this;
            r1 = r17
            r17.zzo()
            r17.zzjj()
            r0 = 1
            r1.zzte = r0
            r2 = 0
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x0302 }
            r3.zzae()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzhv r3 = r3.zzs()     // Catch:{ all -> 0x0302 }
            java.lang.Boolean r3 = r3.zzit()     // Catch:{ all -> 0x0302 }
            if (r3 != 0) goto L_0x0032
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzab()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgn()     // Catch:{ all -> 0x0302 }
            java.lang.String r3 = "Upload data called on the client side before use of service was decided"
            r0.zzao(r3)     // Catch:{ all -> 0x0302 }
            r1.zzte = r2
            r17.zzjo()
            return
        L_0x0032:
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0302 }
            if (r3 == 0) goto L_0x004d
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzab()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgk()     // Catch:{ all -> 0x0302 }
            java.lang.String r3 = "Upload called in the client side when service should be used"
            r0.zzao(r3)     // Catch:{ all -> 0x0302 }
            r1.zzte = r2
            r17.zzjo()
            return
        L_0x004d:
            long r3 = r1.zzsy     // Catch:{ all -> 0x0302 }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x005e
            r17.zzjn()     // Catch:{ all -> 0x0302 }
            r1.zzte = r2
            r17.zzjo()
            return
        L_0x005e:
            r17.zzo()     // Catch:{ all -> 0x0302 }
            java.util.List<java.lang.Long> r3 = r1.zzth     // Catch:{ all -> 0x0302 }
            if (r3 == 0) goto L_0x0067
            r3 = 1
            goto L_0x0068
        L_0x0067:
            r3 = 0
        L_0x0068:
            if (r3 == 0) goto L_0x007f
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzab()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgs()     // Catch:{ all -> 0x0302 }
            java.lang.String r3 = "Uploading requested multiple times"
            r0.zzao(r3)     // Catch:{ all -> 0x0302 }
            r1.zzte = r2
            r17.zzjo()
            return
        L_0x007f:
            com.google.android.gms.measurement.internal.zzej r3 = r17.zzjf()     // Catch:{ all -> 0x0302 }
            boolean r3 = r3.zzgv()     // Catch:{ all -> 0x0302 }
            if (r3 != 0) goto L_0x00a1
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzab()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgs()     // Catch:{ all -> 0x0302 }
            java.lang.String r3 = "Network not connected, ignoring upload request"
            r0.zzao(r3)     // Catch:{ all -> 0x0302 }
            r17.zzjn()     // Catch:{ all -> 0x0302 }
            r1.zzte = r2
            r17.zzjo()
            return
        L_0x00a1:
            com.google.android.gms.measurement.internal.zzfj r3 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.common.util.Clock r3 = r3.zzx()     // Catch:{ all -> 0x0302 }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x0302 }
            long r7 = com.google.android.gms.measurement.internal.zzs.zzbt()     // Catch:{ all -> 0x0302 }
            long r7 = r3 - r7
            r9 = 0
            r1.zzd((java.lang.String) r9, (long) r7)     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzac()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzlj     // Catch:{ all -> 0x0302 }
            long r7 = r7.get()     // Catch:{ all -> 0x0302 }
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 == 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzab()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzgr()     // Catch:{ all -> 0x0302 }
            java.lang.String r6 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r7 = r3 - r7
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x0302 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0302 }
            r5.zza(r6, r7)     // Catch:{ all -> 0x0302 }
        L_0x00de:
            com.google.android.gms.measurement.internal.zzx r5 = r17.zzgy()     // Catch:{ all -> 0x0302 }
            java.lang.String r5 = r5.zzby()     // Catch:{ all -> 0x0302 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0302 }
            r7 = -1
            if (r6 != 0) goto L_0x02da
            long r10 = r1.zztj     // Catch:{ all -> 0x0302 }
            int r6 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x00fe
            com.google.android.gms.measurement.internal.zzx r6 = r17.zzgy()     // Catch:{ all -> 0x0302 }
            long r6 = r6.zzcf()     // Catch:{ all -> 0x0302 }
            r1.zztj = r6     // Catch:{ all -> 0x0302 }
        L_0x00fe:
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzad()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzak.zzgl     // Catch:{ all -> 0x0302 }
            int r6 = r6.zzb(r5, r7)     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzfj r7 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzs r7 = r7.zzad()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzak.zzgm     // Catch:{ all -> 0x0302 }
            int r7 = r7.zzb(r5, r8)     // Catch:{ all -> 0x0302 }
            int r7 = java.lang.Math.max(r2, r7)     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzx r8 = r17.zzgy()     // Catch:{ all -> 0x0302 }
            java.util.List r6 = r8.zza((java.lang.String) r5, (int) r6, (int) r7)     // Catch:{ all -> 0x0302 }
            boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x0302 }
            if (r7 != 0) goto L_0x02fc
            java.util.Iterator r7 = r6.iterator()     // Catch:{ all -> 0x0302 }
        L_0x012c:
            boolean r8 = r7.hasNext()     // Catch:{ all -> 0x0302 }
            if (r8 == 0) goto L_0x014b
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x0302 }
            android.util.Pair r8 = (android.util.Pair) r8     // Catch:{ all -> 0x0302 }
            java.lang.Object r8 = r8.first     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbs$zzg r8 = (com.google.android.gms.internal.measurement.zzbs.zzg) r8     // Catch:{ all -> 0x0302 }
            java.lang.String r10 = r8.zzot()     // Catch:{ all -> 0x0302 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0302 }
            if (r10 != 0) goto L_0x012c
            java.lang.String r7 = r8.zzot()     // Catch:{ all -> 0x0302 }
            goto L_0x014c
        L_0x014b:
            r7 = r9
        L_0x014c:
            if (r7 == 0) goto L_0x017b
            r8 = 0
        L_0x014f:
            int r10 = r6.size()     // Catch:{ all -> 0x0302 }
            if (r8 >= r10) goto L_0x017b
            java.lang.Object r10 = r6.get(r8)     // Catch:{ all -> 0x0302 }
            android.util.Pair r10 = (android.util.Pair) r10     // Catch:{ all -> 0x0302 }
            java.lang.Object r10 = r10.first     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbs$zzg r10 = (com.google.android.gms.internal.measurement.zzbs.zzg) r10     // Catch:{ all -> 0x0302 }
            java.lang.String r11 = r10.zzot()     // Catch:{ all -> 0x0302 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0302 }
            if (r11 != 0) goto L_0x0178
            java.lang.String r10 = r10.zzot()     // Catch:{ all -> 0x0302 }
            boolean r10 = r10.equals(r7)     // Catch:{ all -> 0x0302 }
            if (r10 != 0) goto L_0x0178
            java.util.List r6 = r6.subList(r2, r8)     // Catch:{ all -> 0x0302 }
            goto L_0x017b
        L_0x0178:
            int r8 = r8 + 1
            goto L_0x014f
        L_0x017b:
            com.google.android.gms.internal.measurement.zzbs$zzf$zza r7 = com.google.android.gms.internal.measurement.zzbs.zzf.zznj()     // Catch:{ all -> 0x0302 }
            int r8 = r6.size()     // Catch:{ all -> 0x0302 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x0302 }
            int r11 = r6.size()     // Catch:{ all -> 0x0302 }
            r10.<init>(r11)     // Catch:{ all -> 0x0302 }
            boolean r11 = com.google.android.gms.measurement.internal.zzs.zzbv()     // Catch:{ all -> 0x0302 }
            if (r11 == 0) goto L_0x01a0
            com.google.android.gms.measurement.internal.zzfj r11 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzs r11 = r11.zzad()     // Catch:{ all -> 0x0302 }
            boolean r11 = r11.zzl(r5)     // Catch:{ all -> 0x0302 }
            if (r11 == 0) goto L_0x01a0
            r11 = 1
            goto L_0x01a1
        L_0x01a0:
            r11 = 0
        L_0x01a1:
            r12 = 0
        L_0x01a2:
            if (r12 >= r8) goto L_0x020d
            java.lang.Object r13 = r6.get(r12)     // Catch:{ all -> 0x0302 }
            android.util.Pair r13 = (android.util.Pair) r13     // Catch:{ all -> 0x0302 }
            java.lang.Object r13 = r13.first     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbs$zzg r13 = (com.google.android.gms.internal.measurement.zzbs.zzg) r13     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzey$zza r13 = r13.zzuj()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzey$zza r13 = (com.google.android.gms.internal.measurement.zzey.zza) r13     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r13 = (com.google.android.gms.internal.measurement.zzbs.zzg.zza) r13     // Catch:{ all -> 0x0302 }
            java.lang.Object r14 = r6.get(r12)     // Catch:{ all -> 0x0302 }
            android.util.Pair r14 = (android.util.Pair) r14     // Catch:{ all -> 0x0302 }
            java.lang.Object r14 = r14.second     // Catch:{ all -> 0x0302 }
            java.lang.Long r14 = (java.lang.Long) r14     // Catch:{ all -> 0x0302 }
            r10.add(r14)     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzfj r14 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzs r14 = r14.zzad()     // Catch:{ all -> 0x0302 }
            long r14 = r14.zzao()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r14 = r13.zzat(r14)     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r14 = r14.zzan(r3)     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzfj r15 = r1.zzj     // Catch:{ all -> 0x0302 }
            r15.zzae()     // Catch:{ all -> 0x0302 }
            r14.zzn(r2)     // Catch:{ all -> 0x0302 }
            if (r11 != 0) goto L_0x01e2
            r13.zznw()     // Catch:{ all -> 0x0302 }
        L_0x01e2:
            com.google.android.gms.measurement.internal.zzfj r14 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzs r14 = r14.zzad()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzak.zzis     // Catch:{ all -> 0x0302 }
            boolean r14 = r14.zze(r5, r15)     // Catch:{ all -> 0x0302 }
            if (r14 == 0) goto L_0x0207
            com.google.android.gms.internal.measurement.zzgi r14 = r13.zzug()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzey r14 = (com.google.android.gms.internal.measurement.zzey) r14     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbs$zzg r14 = (com.google.android.gms.internal.measurement.zzbs.zzg) r14     // Catch:{ all -> 0x0302 }
            byte[] r14 = r14.toByteArray()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzjo r15 = r17.zzgw()     // Catch:{ all -> 0x0302 }
            long r14 = r15.zza((byte[]) r14)     // Catch:{ all -> 0x0302 }
            r13.zzay(r14)     // Catch:{ all -> 0x0302 }
        L_0x0207:
            r7.zza(r13)     // Catch:{ all -> 0x0302 }
            int r12 = r12 + 1
            goto L_0x01a2
        L_0x020d:
            com.google.android.gms.measurement.internal.zzfj r6 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzef r6 = r6.zzab()     // Catch:{ all -> 0x0302 }
            r11 = 2
            boolean r6 = r6.isLoggable(r11)     // Catch:{ all -> 0x0302 }
            if (r6 == 0) goto L_0x022b
            com.google.android.gms.measurement.internal.zzjo r6 = r17.zzgw()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzgi r11 = r7.zzug()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzey r11 = (com.google.android.gms.internal.measurement.zzey) r11     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbs$zzf r11 = (com.google.android.gms.internal.measurement.zzbs.zzf) r11     // Catch:{ all -> 0x0302 }
            java.lang.String r6 = r6.zza((com.google.android.gms.internal.measurement.zzbs.zzf) r11)     // Catch:{ all -> 0x0302 }
            goto L_0x022c
        L_0x022b:
            r6 = r9
        L_0x022c:
            r17.zzgw()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzgi r11 = r7.zzug()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzey r11 = (com.google.android.gms.internal.measurement.zzey) r11     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbs$zzf r11 = (com.google.android.gms.internal.measurement.zzbs.zzf) r11     // Catch:{ all -> 0x0302 }
            byte[] r14 = r11.toByteArray()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.String> r11 = com.google.android.gms.measurement.internal.zzak.zzgv     // Catch:{ all -> 0x0302 }
            java.lang.Object r9 = r11.get(r9)     // Catch:{ all -> 0x0302 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0302 }
            java.net.URL r13 = new java.net.URL     // Catch:{ MalformedURLException -> 0x02c6 }
            r13.<init>(r9)     // Catch:{ MalformedURLException -> 0x02c6 }
            boolean r11 = r10.isEmpty()     // Catch:{ MalformedURLException -> 0x02c6 }
            if (r11 != 0) goto L_0x0250
            r11 = 1
            goto L_0x0251
        L_0x0250:
            r11 = 0
        L_0x0251:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r11)     // Catch:{ MalformedURLException -> 0x02c6 }
            java.util.List<java.lang.Long> r11 = r1.zzth     // Catch:{ MalformedURLException -> 0x02c6 }
            if (r11 == 0) goto L_0x0268
            com.google.android.gms.measurement.internal.zzfj r10 = r1.zzj     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzab()     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzgk()     // Catch:{ MalformedURLException -> 0x02c6 }
            java.lang.String r11 = "Set uploading progress before finishing the previous upload"
            r10.zzao(r11)     // Catch:{ MalformedURLException -> 0x02c6 }
            goto L_0x026f
        L_0x0268:
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x02c6 }
            r11.<init>(r10)     // Catch:{ MalformedURLException -> 0x02c6 }
            r1.zzth = r11     // Catch:{ MalformedURLException -> 0x02c6 }
        L_0x026f:
            com.google.android.gms.measurement.internal.zzfj r10 = r1.zzj     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzeo r10 = r10.zzac()     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzet r10 = r10.zzlk     // Catch:{ MalformedURLException -> 0x02c6 }
            r10.set(r3)     // Catch:{ MalformedURLException -> 0x02c6 }
            java.lang.String r3 = "?"
            if (r8 <= 0) goto L_0x0286
            com.google.android.gms.internal.measurement.zzbs$zzg r3 = r7.zzo(r2)     // Catch:{ MalformedURLException -> 0x02c6 }
            java.lang.String r3 = r3.zzag()     // Catch:{ MalformedURLException -> 0x02c6 }
        L_0x0286:
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgs()     // Catch:{ MalformedURLException -> 0x02c6 }
            java.lang.String r7 = "Uploading data. app, uncompressed size, data"
            int r8 = r14.length     // Catch:{ MalformedURLException -> 0x02c6 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ MalformedURLException -> 0x02c6 }
            r4.zza(r7, r3, r8, r6)     // Catch:{ MalformedURLException -> 0x02c6 }
            r1.zztd = r0     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzej r11 = r17.zzjf()     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzji r0 = new com.google.android.gms.measurement.internal.zzji     // Catch:{ MalformedURLException -> 0x02c6 }
            r0.<init>(r1, r5)     // Catch:{ MalformedURLException -> 0x02c6 }
            r11.zzo()     // Catch:{ MalformedURLException -> 0x02c6 }
            r11.zzbi()     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzfc r3 = r11.zzaa()     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzen r4 = new com.google.android.gms.measurement.internal.zzen     // Catch:{ MalformedURLException -> 0x02c6 }
            r15 = 0
            r10 = r4
            r12 = r5
            r16 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ MalformedURLException -> 0x02c6 }
            r3.zzb((java.lang.Runnable) r4)     // Catch:{ MalformedURLException -> 0x02c6 }
            goto L_0x02fc
        L_0x02c6:
            com.google.android.gms.measurement.internal.zzfj r0 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzef r0 = r0.zzab()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzeh r0 = r0.zzgk()     // Catch:{ all -> 0x0302 }
            java.lang.String r3 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzef.zzam(r5)     // Catch:{ all -> 0x0302 }
            r0.zza(r3, r4, r9)     // Catch:{ all -> 0x0302 }
            goto L_0x02fc
        L_0x02da:
            r1.zztj = r7     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzx r0 = r17.zzgy()     // Catch:{ all -> 0x0302 }
            long r5 = com.google.android.gms.measurement.internal.zzs.zzbt()     // Catch:{ all -> 0x0302 }
            long r3 = r3 - r5
            java.lang.String r0 = r0.zzu(r3)     // Catch:{ all -> 0x0302 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0302 }
            if (r3 != 0) goto L_0x02fc
            com.google.android.gms.measurement.internal.zzx r3 = r17.zzgy()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzf r0 = r3.zzab(r0)     // Catch:{ all -> 0x0302 }
            if (r0 == 0) goto L_0x02fc
            r1.zzb((com.google.android.gms.measurement.internal.zzf) r0)     // Catch:{ all -> 0x0302 }
        L_0x02fc:
            r1.zzte = r2
            r17.zzjo()
            return
        L_0x0302:
            r0 = move-exception
            r1.zzte = r2
            r17.zzjo()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.zzjl():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:472:0x0c3d, code lost:
        if (r5 != r14) goto L_0x0c3f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0249 A[SYNTHETIC, Splitter:B:115:0x0249] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0250 A[Catch:{ IOException -> 0x020d, all -> 0x0ef0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x025e A[Catch:{ IOException -> 0x020d, all -> 0x0ef0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x03a2 A[Catch:{ IOException -> 0x020d, all -> 0x0ef0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x03a4 A[Catch:{ IOException -> 0x020d, all -> 0x0ef0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x03a7 A[Catch:{ IOException -> 0x020d, all -> 0x0ef0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03a8 A[Catch:{ IOException -> 0x020d, all -> 0x0ef0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x03c3 A[SYNTHETIC, Splitter:B:183:0x03c3] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0460 A[Catch:{ IOException -> 0x020d, all -> 0x0ef0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x04c1 A[Catch:{ IOException -> 0x020d, all -> 0x0ef0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x04c5 A[Catch:{ IOException -> 0x020d, all -> 0x0ef0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x052b A[Catch:{ IOException -> 0x020d, all -> 0x0ef0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x0565 A[Catch:{ IOException -> 0x020d, all -> 0x0ef0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x0584 A[Catch:{ IOException -> 0x020d, all -> 0x0ef0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x0690 A[Catch:{ IOException -> 0x020d, all -> 0x0ef0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x0742 A[Catch:{ IOException -> 0x020d, all -> 0x0ef0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x075b A[Catch:{ IOException -> 0x020d, all -> 0x0ef0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:301:0x0775 A[Catch:{ IOException -> 0x020d, all -> 0x0ef0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:435:0x0b89 A[Catch:{ all -> 0x0ecf }] */
    /* JADX WARNING: Removed duplicated region for block: B:436:0x0b8b A[Catch:{ all -> 0x0ecf }] */
    /* JADX WARNING: Removed duplicated region for block: B:440:0x0b93 A[SYNTHETIC, Splitter:B:440:0x0b93] */
    /* JADX WARNING: Removed duplicated region for block: B:451:0x0bc1 A[SYNTHETIC, Splitter:B:451:0x0bc1] */
    /* JADX WARNING: Removed duplicated region for block: B:479:0x0c5a A[Catch:{ all -> 0x0ecf }] */
    /* JADX WARNING: Removed duplicated region for block: B:483:0x0ca4 A[Catch:{ all -> 0x0ecf }] */
    /* JADX WARNING: Removed duplicated region for block: B:565:0x0ed3  */
    /* JADX WARNING: Removed duplicated region for block: B:573:0x0eea A[SYNTHETIC, Splitter:B:573:0x0eea] */
    /* JADX WARNING: Removed duplicated region for block: B:586:0x042a A[EDGE_INSN: B:586:0x042a->B:192:0x042a ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzd(java.lang.String r60, long r61) {
        /*
            r59 = this;
            r1 = r59
            java.lang.String r2 = "_npa"
            com.google.android.gms.measurement.internal.zzx r3 = r59.zzgy()
            r3.beginTransaction()
            com.google.android.gms.measurement.internal.zzjg$zza r3 = new com.google.android.gms.measurement.internal.zzjg$zza     // Catch:{ all -> 0x0ef0 }
            r4 = 0
            r3.<init>(r1, r4)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzx r5 = r59.zzgy()     // Catch:{ all -> 0x0ef0 }
            long r6 = r1.zztj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0ef0 }
            r5.zzo()     // Catch:{ all -> 0x0ef0 }
            r5.zzbi()     // Catch:{ all -> 0x0ef0 }
            r9 = -1
            r11 = 2
            r12 = 0
            r13 = 1
            android.database.sqlite.SQLiteDatabase r15 = r5.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            boolean r14 = android.text.TextUtils.isEmpty(r4)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            java.lang.String r16 = ""
            if (r14 == 0) goto L_0x0090
            int r14 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r14 == 0) goto L_0x0049
            java.lang.String[] r8 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x0044 }
            java.lang.String r17 = java.lang.String.valueOf(r6)     // Catch:{ SQLiteException -> 0x0044 }
            r8[r12] = r17     // Catch:{ SQLiteException -> 0x0044 }
            java.lang.String r17 = java.lang.String.valueOf(r61)     // Catch:{ SQLiteException -> 0x0044 }
            r8[r13] = r17     // Catch:{ SQLiteException -> 0x0044 }
            goto L_0x0051
        L_0x0044:
            r0 = move-exception
            r6 = r0
            r8 = r4
            goto L_0x0236
        L_0x0049:
            java.lang.String[] r8 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            java.lang.String r17 = java.lang.String.valueOf(r61)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            r8[r12] = r17     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
        L_0x0051:
            if (r14 == 0) goto L_0x0055
            java.lang.String r16 = "rowid <= ? and "
        L_0x0055:
            r14 = r16
            int r4 = r14.length()     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            int r4 = r4 + 148
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            r11.<init>(r4)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            java.lang.String r4 = "select app_id, metadata_fingerprint from raw_events where "
            r11.append(r4)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            r11.append(r14)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            java.lang.String r4 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r11.append(r4)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            java.lang.String r4 = r11.toString()     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            android.database.Cursor r4 = r15.rawQuery(r4, r8)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            boolean r8 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0229 }
            if (r8 != 0) goto L_0x0084
            if (r4 == 0) goto L_0x024c
            r4.close()     // Catch:{ all -> 0x0ef0 }
            goto L_0x024c
        L_0x0084:
            java.lang.String r8 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x0229 }
            java.lang.String r11 = r4.getString(r13)     // Catch:{ SQLiteException -> 0x0226 }
            r4.close()     // Catch:{ SQLiteException -> 0x0226 }
            goto L_0x00e1
        L_0x0090:
            int r4 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r4 == 0) goto L_0x00a1
            r8 = 2
            java.lang.String[] r11 = new java.lang.String[r8]     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            r8 = 0
            r11[r12] = r8     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            java.lang.String r8 = java.lang.String.valueOf(r6)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            r11[r13] = r8     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            goto L_0x00a6
        L_0x00a1:
            r8 = 0
            java.lang.String[] r11 = new java.lang.String[]{r8}     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
        L_0x00a6:
            if (r4 == 0) goto L_0x00aa
            java.lang.String r16 = " and rowid <= ?"
        L_0x00aa:
            r4 = r16
            int r8 = r4.length()     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            int r8 = r8 + 84
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            r14.<init>(r8)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            java.lang.String r8 = "select metadata_fingerprint from raw_events where app_id = ?"
            r14.append(r8)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            r14.append(r4)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            java.lang.String r4 = " order by rowid limit 1;"
            r14.append(r4)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            java.lang.String r4 = r14.toString()     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            android.database.Cursor r4 = r15.rawQuery(r4, r11)     // Catch:{ SQLiteException -> 0x0232, all -> 0x022c }
            boolean r8 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0229 }
            if (r8 != 0) goto L_0x00d9
            if (r4 == 0) goto L_0x024c
            r4.close()     // Catch:{ all -> 0x0ef0 }
            goto L_0x024c
        L_0x00d9:
            java.lang.String r11 = r4.getString(r12)     // Catch:{ SQLiteException -> 0x0229 }
            r4.close()     // Catch:{ SQLiteException -> 0x0229 }
            r8 = 0
        L_0x00e1:
            java.lang.String r16 = "raw_events_metadata"
            java.lang.String r14 = "metadata"
            java.lang.String[] r17 = new java.lang.String[]{r14}     // Catch:{ SQLiteException -> 0x0226 }
            java.lang.String r18 = "app_id = ? and metadata_fingerprint = ?"
            r14 = 2
            java.lang.String[] r9 = new java.lang.String[r14]     // Catch:{ SQLiteException -> 0x0226 }
            r9[r12] = r8     // Catch:{ SQLiteException -> 0x0226 }
            r9[r13] = r11     // Catch:{ SQLiteException -> 0x0226 }
            r19 = 0
            r20 = 0
            java.lang.String r21 = "rowid"
            java.lang.String r22 = "2"
            r14 = r15
            r10 = r15
            r15 = r16
            r16 = r17
            r17 = r18
            r18 = r9
            android.database.Cursor r4 = r14.query(r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ SQLiteException -> 0x0226 }
            boolean r9 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0226 }
            if (r9 != 0) goto L_0x0126
            com.google.android.gms.measurement.internal.zzef r6 = r5.zzab()     // Catch:{ SQLiteException -> 0x0226 }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzgk()     // Catch:{ SQLiteException -> 0x0226 }
            java.lang.String r7 = "Raw event metadata record is missing. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzef.zzam(r8)     // Catch:{ SQLiteException -> 0x0226 }
            r6.zza(r7, r9)     // Catch:{ SQLiteException -> 0x0226 }
            if (r4 == 0) goto L_0x024c
            r4.close()     // Catch:{ all -> 0x0ef0 }
            goto L_0x024c
        L_0x0126:
            byte[] r9 = r4.getBlob(r12)     // Catch:{ SQLiteException -> 0x0226 }
            com.google.android.gms.internal.measurement.zzel r14 = com.google.android.gms.internal.measurement.zzel.zztq()     // Catch:{ IOException -> 0x020d }
            com.google.android.gms.internal.measurement.zzbs$zzg r9 = com.google.android.gms.internal.measurement.zzbs.zzg.zzd((byte[]) r9, (com.google.android.gms.internal.measurement.zzel) r14)     // Catch:{ IOException -> 0x020d }
            boolean r14 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0226 }
            if (r14 == 0) goto L_0x0149
            com.google.android.gms.measurement.internal.zzef r14 = r5.zzab()     // Catch:{ SQLiteException -> 0x0226 }
            com.google.android.gms.measurement.internal.zzeh r14 = r14.zzgn()     // Catch:{ SQLiteException -> 0x0226 }
            java.lang.String r15 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzef.zzam(r8)     // Catch:{ SQLiteException -> 0x0226 }
            r14.zza(r15, r13)     // Catch:{ SQLiteException -> 0x0226 }
        L_0x0149:
            r4.close()     // Catch:{ SQLiteException -> 0x0226 }
            r3.zzb(r9)     // Catch:{ SQLiteException -> 0x0226 }
            r13 = -1
            int r9 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r9 == 0) goto L_0x016b
            java.lang.String r9 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            r13 = 3
            java.lang.String[] r14 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0226 }
            r14[r12] = r8     // Catch:{ SQLiteException -> 0x0226 }
            r13 = 1
            r14[r13] = r11     // Catch:{ SQLiteException -> 0x0226 }
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ SQLiteException -> 0x0226 }
            r7 = 2
            r14[r7] = r6     // Catch:{ SQLiteException -> 0x0226 }
            r17 = r9
            r18 = r14
            goto L_0x0179
        L_0x016b:
            java.lang.String r6 = "app_id = ? and metadata_fingerprint = ?"
            r7 = 2
            java.lang.String[] r9 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x0226 }
            r9[r12] = r8     // Catch:{ SQLiteException -> 0x0226 }
            r7 = 1
            r9[r7] = r11     // Catch:{ SQLiteException -> 0x0226 }
            r17 = r6
            r18 = r9
        L_0x0179:
            java.lang.String r15 = "raw_events"
            java.lang.String r6 = "rowid"
            java.lang.String r7 = "name"
            java.lang.String r9 = "timestamp"
            java.lang.String r11 = "data"
            java.lang.String[] r16 = new java.lang.String[]{r6, r7, r9, r11}     // Catch:{ SQLiteException -> 0x0226 }
            r19 = 0
            r20 = 0
            java.lang.String r21 = "rowid"
            r22 = 0
            r14 = r10
            android.database.Cursor r4 = r14.query(r15, r16, r17, r18, r19, r20, r21, r22)     // Catch:{ SQLiteException -> 0x0226 }
            boolean r6 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x0226 }
            if (r6 != 0) goto L_0x01b2
            com.google.android.gms.measurement.internal.zzef r6 = r5.zzab()     // Catch:{ SQLiteException -> 0x0226 }
            com.google.android.gms.measurement.internal.zzeh r6 = r6.zzgn()     // Catch:{ SQLiteException -> 0x0226 }
            java.lang.String r7 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzef.zzam(r8)     // Catch:{ SQLiteException -> 0x0226 }
            r6.zza(r7, r9)     // Catch:{ SQLiteException -> 0x0226 }
            if (r4 == 0) goto L_0x024c
            r4.close()     // Catch:{ all -> 0x0ef0 }
            goto L_0x024c
        L_0x01b2:
            long r6 = r4.getLong(r12)     // Catch:{ SQLiteException -> 0x0226 }
            r9 = 3
            byte[] r10 = r4.getBlob(r9)     // Catch:{ SQLiteException -> 0x0226 }
            com.google.android.gms.internal.measurement.zzbs$zzc$zza r9 = com.google.android.gms.internal.measurement.zzbs.zzc.zzmq()     // Catch:{ IOException -> 0x01ee }
            com.google.android.gms.internal.measurement.zzel r11 = com.google.android.gms.internal.measurement.zzel.zztq()     // Catch:{ IOException -> 0x01ee }
            com.google.android.gms.internal.measurement.zzdh r9 = r9.zzf(r10, r11)     // Catch:{ IOException -> 0x01ee }
            com.google.android.gms.internal.measurement.zzbs$zzc$zza r9 = (com.google.android.gms.internal.measurement.zzbs.zzc.zza) r9     // Catch:{ IOException -> 0x01ee }
            r10 = 1
            java.lang.String r11 = r4.getString(r10)     // Catch:{ SQLiteException -> 0x0226 }
            com.google.android.gms.internal.measurement.zzbs$zzc$zza r10 = r9.zzbx(r11)     // Catch:{ SQLiteException -> 0x0226 }
            r11 = 2
            long r13 = r4.getLong(r11)     // Catch:{ SQLiteException -> 0x0226 }
            r10.zzag(r13)     // Catch:{ SQLiteException -> 0x0226 }
            com.google.android.gms.internal.measurement.zzgi r9 = r9.zzug()     // Catch:{ SQLiteException -> 0x0226 }
            com.google.android.gms.internal.measurement.zzey r9 = (com.google.android.gms.internal.measurement.zzey) r9     // Catch:{ SQLiteException -> 0x0226 }
            com.google.android.gms.internal.measurement.zzbs$zzc r9 = (com.google.android.gms.internal.measurement.zzbs.zzc) r9     // Catch:{ SQLiteException -> 0x0226 }
            boolean r6 = r3.zza(r6, r9)     // Catch:{ SQLiteException -> 0x0226 }
            if (r6 != 0) goto L_0x0201
            if (r4 == 0) goto L_0x024c
            r4.close()     // Catch:{ all -> 0x0ef0 }
            goto L_0x024c
        L_0x01ee:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzef r7 = r5.zzab()     // Catch:{ SQLiteException -> 0x0226 }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgk()     // Catch:{ SQLiteException -> 0x0226 }
            java.lang.String r9 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzef.zzam(r8)     // Catch:{ SQLiteException -> 0x0226 }
            r7.zza(r9, r10, r6)     // Catch:{ SQLiteException -> 0x0226 }
        L_0x0201:
            boolean r6 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x0226 }
            if (r6 != 0) goto L_0x01b2
            if (r4 == 0) goto L_0x024c
            r4.close()     // Catch:{ all -> 0x0ef0 }
            goto L_0x024c
        L_0x020d:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzef r7 = r5.zzab()     // Catch:{ SQLiteException -> 0x0226 }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgk()     // Catch:{ SQLiteException -> 0x0226 }
            java.lang.String r9 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzef.zzam(r8)     // Catch:{ SQLiteException -> 0x0226 }
            r7.zza(r9, r10, r6)     // Catch:{ SQLiteException -> 0x0226 }
            if (r4 == 0) goto L_0x024c
            r4.close()     // Catch:{ all -> 0x0ef0 }
            goto L_0x024c
        L_0x0226:
            r0 = move-exception
            r6 = r0
            goto L_0x0236
        L_0x0229:
            r0 = move-exception
            r6 = r0
            goto L_0x0235
        L_0x022c:
            r0 = move-exception
            r5 = r1
            r4 = 0
        L_0x022f:
            r1 = r0
            goto L_0x0ee8
        L_0x0232:
            r0 = move-exception
            r6 = r0
            r4 = 0
        L_0x0235:
            r8 = 0
        L_0x0236:
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzab()     // Catch:{ all -> 0x0ee4 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzgk()     // Catch:{ all -> 0x0ee4 }
            java.lang.String r7 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzef.zzam(r8)     // Catch:{ all -> 0x0ee4 }
            r5.zza(r7, r8, r6)     // Catch:{ all -> 0x0ee4 }
            if (r4 == 0) goto L_0x024c
            r4.close()     // Catch:{ all -> 0x0ef0 }
        L_0x024c:
            java.util.List<com.google.android.gms.internal.measurement.zzbs$zzc> r4 = r3.zztp     // Catch:{ all -> 0x0ef0 }
            if (r4 == 0) goto L_0x025b
            java.util.List<com.google.android.gms.internal.measurement.zzbs$zzc> r4 = r3.zztp     // Catch:{ all -> 0x0ef0 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0ef0 }
            if (r4 == 0) goto L_0x0259
            goto L_0x025b
        L_0x0259:
            r4 = 0
            goto L_0x025c
        L_0x025b:
            r4 = 1
        L_0x025c:
            if (r4 != 0) goto L_0x0ed3
            com.google.android.gms.internal.measurement.zzbs$zzg r4 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey$zza r4 = r4.zzuj()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey$zza r4 = (com.google.android.gms.internal.measurement.zzey.zza) r4     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r4 = (com.google.android.gms.internal.measurement.zzbs.zzg.zza) r4     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r4 = r4.zznn()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzs r5 = r5.zzad()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzg r6 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r6 = r6.zzag()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzak.zzii     // Catch:{ all -> 0x0ef0 }
            boolean r5 = r5.zze(r6, r7)     // Catch:{ all -> 0x0ef0 }
            r6 = -1
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = -1
            r13 = 0
            r14 = 0
            r16 = 0
        L_0x0288:
            java.util.List<com.google.android.gms.internal.measurement.zzbs$zzc> r7 = r3.zztp     // Catch:{ all -> 0x0ef0 }
            int r7 = r7.size()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r8 = "_fr"
            r19 = r13
            java.lang.String r13 = "_et"
            r20 = r2
            java.lang.String r2 = "_e"
            r21 = r14
            if (r11 >= r7) goto L_0x07cc
            java.util.List<com.google.android.gms.internal.measurement.zzbs$zzc> r7 = r3.zztp     // Catch:{ all -> 0x0ef0 }
            java.lang.Object r7 = r7.get(r11)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzc r7 = (com.google.android.gms.internal.measurement.zzbs.zzc) r7     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey$zza r7 = r7.zzuj()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey$zza r7 = (com.google.android.gms.internal.measurement.zzey.zza) r7     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzc$zza r7 = (com.google.android.gms.internal.measurement.zzbs.zzc.zza) r7     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzfd r14 = r59.zzgz()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzg r15 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r15 = r15.zzag()     // Catch:{ all -> 0x0ef0 }
            r25 = r11
            java.lang.String r11 = r7.getName()     // Catch:{ all -> 0x0ef0 }
            boolean r11 = r14.zzk(r15, r11)     // Catch:{ all -> 0x0ef0 }
            java.lang.String r14 = "_err"
            if (r11 == 0) goto L_0x0341
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgn()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r8 = "Dropping blacklisted raw event. appId"
            com.google.android.gms.internal.measurement.zzbs$zzg r11 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r11 = r11.zzag()     // Catch:{ all -> 0x0ef0 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzef.zzam(r11)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzfj r13 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzed r13 = r13.zzy()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r15 = r7.getName()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r13 = r13.zzaj(r15)     // Catch:{ all -> 0x0ef0 }
            r2.zza(r8, r11, r13)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzfd r2 = r59.zzgz()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzg r8 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r8 = r8.zzag()     // Catch:{ all -> 0x0ef0 }
            boolean r2 = r2.zzbc(r8)     // Catch:{ all -> 0x0ef0 }
            if (r2 != 0) goto L_0x030e
            com.google.android.gms.measurement.internal.zzfd r2 = r59.zzgz()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzg r8 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r8 = r8.zzag()     // Catch:{ all -> 0x0ef0 }
            boolean r2 = r2.zzbd(r8)     // Catch:{ all -> 0x0ef0 }
            if (r2 == 0) goto L_0x030c
            goto L_0x030e
        L_0x030c:
            r2 = 0
            goto L_0x030f
        L_0x030e:
            r2 = 1
        L_0x030f:
            if (r2 != 0) goto L_0x0334
            java.lang.String r2 = r7.getName()     // Catch:{ all -> 0x0ef0 }
            boolean r2 = r14.equals(r2)     // Catch:{ all -> 0x0ef0 }
            if (r2 != 0) goto L_0x0334
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzjs r26 = r2.zzz()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzg r2 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r27 = r2.zzag()     // Catch:{ all -> 0x0ef0 }
            r28 = 11
            java.lang.String r29 = "_ev"
            java.lang.String r30 = r7.getName()     // Catch:{ all -> 0x0ef0 }
            r31 = 0
            r26.zza((java.lang.String) r27, (int) r28, (java.lang.String) r29, (java.lang.String) r30, (int) r31)     // Catch:{ all -> 0x0ef0 }
        L_0x0334:
            r26 = r5
            r28 = r9
            r14 = r21
            r8 = r25
            r5 = -1
            r13 = 3
            r9 = r4
            goto L_0x07bf
        L_0x0341:
            com.google.android.gms.measurement.internal.zzfd r11 = r59.zzgz()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzg r15 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r15 = r15.zzag()     // Catch:{ all -> 0x0ef0 }
            r26 = r5
            java.lang.String r5 = r7.getName()     // Catch:{ all -> 0x0ef0 }
            boolean r5 = r11.zzl(r15, r5)     // Catch:{ all -> 0x0ef0 }
            java.lang.String r11 = "_c"
            if (r5 != 0) goto L_0x03b0
            r59.zzgw()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r15 = r7.getName()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x0ef0 }
            r27 = r12
            int r12 = r15.hashCode()     // Catch:{ all -> 0x0ef0 }
            r28 = r9
            r9 = 94660(0x171c4, float:1.32647E-40)
            if (r12 == r9) goto L_0x038f
            r9 = 95025(0x17331, float:1.33158E-40)
            if (r12 == r9) goto L_0x0385
            r9 = 95027(0x17333, float:1.33161E-40)
            if (r12 == r9) goto L_0x037b
            goto L_0x0399
        L_0x037b:
            java.lang.String r9 = "_ui"
            boolean r9 = r15.equals(r9)     // Catch:{ all -> 0x0ef0 }
            if (r9 == 0) goto L_0x0399
            r9 = 1
            goto L_0x039a
        L_0x0385:
            java.lang.String r9 = "_ug"
            boolean r9 = r15.equals(r9)     // Catch:{ all -> 0x0ef0 }
            if (r9 == 0) goto L_0x0399
            r9 = 2
            goto L_0x039a
        L_0x038f:
            java.lang.String r9 = "_in"
            boolean r9 = r15.equals(r9)     // Catch:{ all -> 0x0ef0 }
            if (r9 == 0) goto L_0x0399
            r9 = 0
            goto L_0x039a
        L_0x0399:
            r9 = -1
        L_0x039a:
            if (r9 == 0) goto L_0x03a4
            r12 = 1
            if (r9 == r12) goto L_0x03a4
            r12 = 2
            if (r9 == r12) goto L_0x03a4
            r9 = 0
            goto L_0x03a5
        L_0x03a4:
            r9 = 1
        L_0x03a5:
            if (r9 == 0) goto L_0x03a8
            goto L_0x03b4
        L_0x03a8:
            r30 = r4
            r29 = r13
        L_0x03ac:
            r13 = r19
            goto L_0x059f
        L_0x03b0:
            r28 = r9
            r27 = r12
        L_0x03b4:
            r29 = r13
            r9 = 0
            r12 = 0
            r15 = 0
        L_0x03b9:
            int r13 = r7.zzmk()     // Catch:{ all -> 0x0ef0 }
            r30 = r4
            java.lang.String r4 = "_r"
            if (r9 >= r13) goto L_0x042a
            com.google.android.gms.internal.measurement.zzbs$zze r13 = r7.zzl(r9)     // Catch:{ all -> 0x0ef0 }
            java.lang.String r13 = r13.getName()     // Catch:{ all -> 0x0ef0 }
            boolean r13 = r11.equals(r13)     // Catch:{ all -> 0x0ef0 }
            if (r13 == 0) goto L_0x03f2
            com.google.android.gms.internal.measurement.zzbs$zze r4 = r7.zzl(r9)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey$zza r4 = r4.zzuj()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey$zza r4 = (com.google.android.gms.internal.measurement.zzey.zza) r4     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = (com.google.android.gms.internal.measurement.zzbs.zze.zza) r4     // Catch:{ all -> 0x0ef0 }
            r12 = 1
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = r4.zzam(r12)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzgi r4 = r4.zzug()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey r4 = (com.google.android.gms.internal.measurement.zzey) r4     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zze r4 = (com.google.android.gms.internal.measurement.zzbs.zze) r4     // Catch:{ all -> 0x0ef0 }
            r7.zza((int) r9, (com.google.android.gms.internal.measurement.zzbs.zze) r4)     // Catch:{ all -> 0x0ef0 }
            r31 = r14
            r12 = 1
            goto L_0x0423
        L_0x03f2:
            com.google.android.gms.internal.measurement.zzbs$zze r13 = r7.zzl(r9)     // Catch:{ all -> 0x0ef0 }
            java.lang.String r13 = r13.getName()     // Catch:{ all -> 0x0ef0 }
            boolean r4 = r4.equals(r13)     // Catch:{ all -> 0x0ef0 }
            if (r4 == 0) goto L_0x0421
            com.google.android.gms.internal.measurement.zzbs$zze r4 = r7.zzl(r9)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey$zza r4 = r4.zzuj()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey$zza r4 = (com.google.android.gms.internal.measurement.zzey.zza) r4     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = (com.google.android.gms.internal.measurement.zzbs.zze.zza) r4     // Catch:{ all -> 0x0ef0 }
            r31 = r14
            r13 = 1
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = r4.zzam(r13)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzgi r4 = r4.zzug()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey r4 = (com.google.android.gms.internal.measurement.zzey) r4     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zze r4 = (com.google.android.gms.internal.measurement.zzbs.zze) r4     // Catch:{ all -> 0x0ef0 }
            r7.zza((int) r9, (com.google.android.gms.internal.measurement.zzbs.zze) r4)     // Catch:{ all -> 0x0ef0 }
            r15 = 1
            goto L_0x0423
        L_0x0421:
            r31 = r14
        L_0x0423:
            int r9 = r9 + 1
            r4 = r30
            r14 = r31
            goto L_0x03b9
        L_0x042a:
            r31 = r14
            if (r12 != 0) goto L_0x045e
            if (r5 == 0) goto L_0x045e
            com.google.android.gms.measurement.internal.zzfj r9 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzab()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzgs()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r12 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzfj r13 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzed r13 = r13.zzy()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r14 = r7.getName()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r13 = r13.zzaj(r14)     // Catch:{ all -> 0x0ef0 }
            r9.zza(r12, r13)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r9 = com.google.android.gms.internal.measurement.zzbs.zze.zzng()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r9 = r9.zzbz(r11)     // Catch:{ all -> 0x0ef0 }
            r12 = 1
            com.google.android.gms.internal.measurement.zzbs$zze$zza r9 = r9.zzam(r12)     // Catch:{ all -> 0x0ef0 }
            r7.zza((com.google.android.gms.internal.measurement.zzbs.zze.zza) r9)     // Catch:{ all -> 0x0ef0 }
        L_0x045e:
            if (r15 != 0) goto L_0x048e
            com.google.android.gms.measurement.internal.zzfj r9 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzef r9 = r9.zzab()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzeh r9 = r9.zzgs()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r12 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzfj r13 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzed r13 = r13.zzy()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r14 = r7.getName()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r13 = r13.zzaj(r14)     // Catch:{ all -> 0x0ef0 }
            r9.zza(r12, r13)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r9 = com.google.android.gms.internal.measurement.zzbs.zze.zzng()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r9 = r9.zzbz(r4)     // Catch:{ all -> 0x0ef0 }
            r12 = 1
            com.google.android.gms.internal.measurement.zzbs$zze$zza r9 = r9.zzam(r12)     // Catch:{ all -> 0x0ef0 }
            r7.zza((com.google.android.gms.internal.measurement.zzbs.zze.zza) r9)     // Catch:{ all -> 0x0ef0 }
        L_0x048e:
            com.google.android.gms.measurement.internal.zzx r32 = r59.zzgy()     // Catch:{ all -> 0x0ef0 }
            long r33 = r59.zzjk()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzg r9 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r35 = r9.zzag()     // Catch:{ all -> 0x0ef0 }
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 1
            com.google.android.gms.measurement.internal.zzw r9 = r32.zza(r33, r35, r36, r37, r38, r39, r40)     // Catch:{ all -> 0x0ef0 }
            long r12 = r9.zzej     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzfj r9 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzs r9 = r9.zzad()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzg r14 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r14 = r14.zzag()     // Catch:{ all -> 0x0ef0 }
            int r9 = r9.zzi(r14)     // Catch:{ all -> 0x0ef0 }
            long r14 = (long) r9     // Catch:{ all -> 0x0ef0 }
            int r9 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r9 <= 0) goto L_0x04c5
            zza((com.google.android.gms.internal.measurement.zzbs.zzc.zza) r7, (java.lang.String) r4)     // Catch:{ all -> 0x0ef0 }
            goto L_0x04c7
        L_0x04c5:
            r19 = 1
        L_0x04c7:
            java.lang.String r4 = r7.getName()     // Catch:{ all -> 0x0ef0 }
            boolean r4 = com.google.android.gms.measurement.internal.zzjs.zzbk(r4)     // Catch:{ all -> 0x0ef0 }
            if (r4 == 0) goto L_0x03ac
            if (r5 == 0) goto L_0x03ac
            com.google.android.gms.measurement.internal.zzx r32 = r59.zzgy()     // Catch:{ all -> 0x0ef0 }
            long r33 = r59.zzjk()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzg r4 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r35 = r4.zzag()     // Catch:{ all -> 0x0ef0 }
            r36 = 0
            r37 = 0
            r38 = 1
            r39 = 0
            r40 = 0
            com.google.android.gms.measurement.internal.zzw r4 = r32.zza(r33, r35, r36, r37, r38, r39, r40)     // Catch:{ all -> 0x0ef0 }
            long r12 = r4.zzeh     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzs r4 = r4.zzad()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzg r9 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r9 = r9.zzag()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r14 = com.google.android.gms.measurement.internal.zzak.zzgs     // Catch:{ all -> 0x0ef0 }
            int r4 = r4.zzb(r9, r14)     // Catch:{ all -> 0x0ef0 }
            long r14 = (long) r4     // Catch:{ all -> 0x0ef0 }
            int r4 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r4 <= 0) goto L_0x03ac
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgn()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r9 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzbs$zzg r12 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r12 = r12.zzag()     // Catch:{ all -> 0x0ef0 }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzef.zzam(r12)     // Catch:{ all -> 0x0ef0 }
            r4.zza(r9, r12)     // Catch:{ all -> 0x0ef0 }
            r4 = 0
            r9 = -1
            r12 = 0
            r13 = 0
        L_0x0525:
            int r14 = r7.zzmk()     // Catch:{ all -> 0x0ef0 }
            if (r4 >= r14) goto L_0x0558
            com.google.android.gms.internal.measurement.zzbs$zze r14 = r7.zzl(r4)     // Catch:{ all -> 0x0ef0 }
            java.lang.String r15 = r14.getName()     // Catch:{ all -> 0x0ef0 }
            boolean r15 = r11.equals(r15)     // Catch:{ all -> 0x0ef0 }
            if (r15 == 0) goto L_0x0546
            com.google.android.gms.internal.measurement.zzey$zza r9 = r14.zzuj()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey$zza r9 = (com.google.android.gms.internal.measurement.zzey.zza) r9     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r9 = (com.google.android.gms.internal.measurement.zzbs.zze.zza) r9     // Catch:{ all -> 0x0ef0 }
            r12 = r9
            r15 = r31
            r9 = r4
            goto L_0x0553
        L_0x0546:
            java.lang.String r14 = r14.getName()     // Catch:{ all -> 0x0ef0 }
            r15 = r31
            boolean r14 = r15.equals(r14)     // Catch:{ all -> 0x0ef0 }
            if (r14 == 0) goto L_0x0553
            r13 = 1
        L_0x0553:
            int r4 = r4 + 1
            r31 = r15
            goto L_0x0525
        L_0x0558:
            r15 = r31
            if (r13 == 0) goto L_0x0563
            if (r12 == 0) goto L_0x0563
            r7.zzm(r9)     // Catch:{ all -> 0x0ef0 }
            goto L_0x03ac
        L_0x0563:
            if (r12 == 0) goto L_0x0584
            java.lang.Object r4 = r12.clone()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey$zza r4 = (com.google.android.gms.internal.measurement.zzey.zza) r4     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = (com.google.android.gms.internal.measurement.zzbs.zze.zza) r4     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = r4.zzbz(r15)     // Catch:{ all -> 0x0ef0 }
            r12 = 10
            com.google.android.gms.internal.measurement.zzbs$zze$zza r4 = r4.zzam(r12)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzgi r4 = r4.zzug()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey r4 = (com.google.android.gms.internal.measurement.zzey) r4     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zze r4 = (com.google.android.gms.internal.measurement.zzbs.zze) r4     // Catch:{ all -> 0x0ef0 }
            r7.zza((int) r9, (com.google.android.gms.internal.measurement.zzbs.zze) r4)     // Catch:{ all -> 0x0ef0 }
            goto L_0x03ac
        L_0x0584:
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgk()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r9 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzbs$zzg r12 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r12 = r12.zzag()     // Catch:{ all -> 0x0ef0 }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzef.zzam(r12)     // Catch:{ all -> 0x0ef0 }
            r4.zza(r9, r12)     // Catch:{ all -> 0x0ef0 }
            goto L_0x03ac
        L_0x059f:
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzs r4 = r4.zzad()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzg r9 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r9 = r9.zzag()     // Catch:{ all -> 0x0ef0 }
            boolean r4 = r4.zzs(r9)     // Catch:{ all -> 0x0ef0 }
            if (r4 == 0) goto L_0x0678
            if (r5 == 0) goto L_0x0678
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0ef0 }
            java.util.List r5 = r7.zzmj()     // Catch:{ all -> 0x0ef0 }
            r4.<init>(r5)     // Catch:{ all -> 0x0ef0 }
            r5 = 0
            r9 = -1
            r12 = -1
        L_0x05bf:
            int r14 = r4.size()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r15 = "currency"
            r19 = r13
            java.lang.String r13 = "value"
            if (r5 >= r14) goto L_0x05f3
            java.lang.Object r14 = r4.get(r5)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zze r14 = (com.google.android.gms.internal.measurement.zzbs.zze) r14     // Catch:{ all -> 0x0ef0 }
            java.lang.String r14 = r14.getName()     // Catch:{ all -> 0x0ef0 }
            boolean r13 = r13.equals(r14)     // Catch:{ all -> 0x0ef0 }
            if (r13 == 0) goto L_0x05dd
            r9 = r5
            goto L_0x05ee
        L_0x05dd:
            java.lang.Object r13 = r4.get(r5)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zze r13 = (com.google.android.gms.internal.measurement.zzbs.zze) r13     // Catch:{ all -> 0x0ef0 }
            java.lang.String r13 = r13.getName()     // Catch:{ all -> 0x0ef0 }
            boolean r13 = r15.equals(r13)     // Catch:{ all -> 0x0ef0 }
            if (r13 == 0) goto L_0x05ee
            r12 = r5
        L_0x05ee:
            int r5 = r5 + 1
            r13 = r19
            goto L_0x05bf
        L_0x05f3:
            r5 = -1
            if (r9 == r5) goto L_0x067b
            java.lang.Object r5 = r4.get(r9)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zze r5 = (com.google.android.gms.internal.measurement.zzbs.zze) r5     // Catch:{ all -> 0x0ef0 }
            boolean r5 = r5.zzna()     // Catch:{ all -> 0x0ef0 }
            if (r5 != 0) goto L_0x0629
            java.lang.Object r5 = r4.get(r9)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zze r5 = (com.google.android.gms.internal.measurement.zzbs.zze) r5     // Catch:{ all -> 0x0ef0 }
            boolean r5 = r5.zznd()     // Catch:{ all -> 0x0ef0 }
            if (r5 != 0) goto L_0x0629
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgp()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r5 = "Value must be specified with a numeric type."
            r4.zzao(r5)     // Catch:{ all -> 0x0ef0 }
            r7.zzm(r9)     // Catch:{ all -> 0x0ef0 }
            zza((com.google.android.gms.internal.measurement.zzbs.zzc.zza) r7, (java.lang.String) r11)     // Catch:{ all -> 0x0ef0 }
            r4 = 18
            zza((com.google.android.gms.internal.measurement.zzbs.zzc.zza) r7, (int) r4, (java.lang.String) r13)     // Catch:{ all -> 0x0ef0 }
            goto L_0x067a
        L_0x0629:
            r5 = -1
            if (r12 != r5) goto L_0x062f
            r4 = 1
            r13 = 3
            goto L_0x065b
        L_0x062f:
            java.lang.Object r4 = r4.get(r12)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zze r4 = (com.google.android.gms.internal.measurement.zzbs.zze) r4     // Catch:{ all -> 0x0ef0 }
            java.lang.String r4 = r4.zzmy()     // Catch:{ all -> 0x0ef0 }
            int r12 = r4.length()     // Catch:{ all -> 0x0ef0 }
            r13 = 3
            if (r12 == r13) goto L_0x0642
        L_0x0640:
            r4 = 1
            goto L_0x065b
        L_0x0642:
            r12 = 0
        L_0x0643:
            int r14 = r4.length()     // Catch:{ all -> 0x0ef0 }
            if (r12 >= r14) goto L_0x065a
            int r14 = r4.codePointAt(r12)     // Catch:{ all -> 0x0ef0 }
            boolean r18 = java.lang.Character.isLetter(r14)     // Catch:{ all -> 0x0ef0 }
            if (r18 != 0) goto L_0x0654
            goto L_0x0640
        L_0x0654:
            int r14 = java.lang.Character.charCount(r14)     // Catch:{ all -> 0x0ef0 }
            int r12 = r12 + r14
            goto L_0x0643
        L_0x065a:
            r4 = 0
        L_0x065b:
            if (r4 == 0) goto L_0x067c
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzab()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgp()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r12 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r4.zzao(r12)     // Catch:{ all -> 0x0ef0 }
            r7.zzm(r9)     // Catch:{ all -> 0x0ef0 }
            zza((com.google.android.gms.internal.measurement.zzbs.zzc.zza) r7, (java.lang.String) r11)     // Catch:{ all -> 0x0ef0 }
            r4 = 19
            zza((com.google.android.gms.internal.measurement.zzbs.zzc.zza) r7, (int) r4, (java.lang.String) r15)     // Catch:{ all -> 0x0ef0 }
            goto L_0x067c
        L_0x0678:
            r19 = r13
        L_0x067a:
            r5 = -1
        L_0x067b:
            r13 = 3
        L_0x067c:
            com.google.android.gms.measurement.internal.zzfj r4 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzs r4 = r4.zzad()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzg r9 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r9 = r9.zzag()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzak.zzih     // Catch:{ all -> 0x0ef0 }
            boolean r4 = r4.zze(r9, r11)     // Catch:{ all -> 0x0ef0 }
            if (r4 == 0) goto L_0x0742
            java.lang.String r4 = r7.getName()     // Catch:{ all -> 0x0ef0 }
            boolean r4 = r2.equals(r4)     // Catch:{ all -> 0x0ef0 }
            r11 = 1000(0x3e8, double:4.94E-321)
            if (r4 == 0) goto L_0x06e9
            r59.zzgw()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzgi r4 = r7.zzug()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey r4 = (com.google.android.gms.internal.measurement.zzey) r4     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzc r4 = (com.google.android.gms.internal.measurement.zzbs.zzc) r4     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zze r4 = com.google.android.gms.measurement.internal.zzjo.zza((com.google.android.gms.internal.measurement.zzbs.zzc) r4, (java.lang.String) r8)     // Catch:{ all -> 0x0ef0 }
            if (r4 != 0) goto L_0x06e6
            if (r10 == 0) goto L_0x06dc
            long r8 = r10.getTimestampMillis()     // Catch:{ all -> 0x0ef0 }
            long r14 = r7.getTimestampMillis()     // Catch:{ all -> 0x0ef0 }
            long r8 = r8 - r14
            long r8 = java.lang.Math.abs(r8)     // Catch:{ all -> 0x0ef0 }
            int r4 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r4 > 0) goto L_0x06dc
            java.lang.Object r4 = r10.clone()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey$zza r4 = (com.google.android.gms.internal.measurement.zzey.zza) r4     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzc$zza r4 = (com.google.android.gms.internal.measurement.zzbs.zzc.zza) r4     // Catch:{ all -> 0x0ef0 }
            boolean r8 = r1.zza((com.google.android.gms.internal.measurement.zzbs.zzc.zza) r7, (com.google.android.gms.internal.measurement.zzbs.zzc.zza) r4)     // Catch:{ all -> 0x0ef0 }
            if (r8 == 0) goto L_0x06dc
            r9 = r30
            r9.zza((int) r6, (com.google.android.gms.internal.measurement.zzbs.zzc.zza) r4)     // Catch:{ all -> 0x0ef0 }
            r12 = r27
            r14 = r29
        L_0x06d7:
            r10 = 0
            r28 = 0
            goto L_0x0749
        L_0x06dc:
            r9 = r30
            r28 = r7
            r12 = r16
            r14 = r29
            goto L_0x0749
        L_0x06e6:
            r9 = r30
            goto L_0x073d
        L_0x06e9:
            r9 = r30
            java.lang.String r4 = "_vs"
            java.lang.String r8 = r7.getName()     // Catch:{ all -> 0x0ef0 }
            boolean r4 = r4.equals(r8)     // Catch:{ all -> 0x0ef0 }
            if (r4 == 0) goto L_0x073d
            r59.zzgw()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzgi r4 = r7.zzug()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey r4 = (com.google.android.gms.internal.measurement.zzey) r4     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzc r4 = (com.google.android.gms.internal.measurement.zzbs.zzc) r4     // Catch:{ all -> 0x0ef0 }
            r14 = r29
            com.google.android.gms.internal.measurement.zzbs$zze r4 = com.google.android.gms.measurement.internal.zzjo.zza((com.google.android.gms.internal.measurement.zzbs.zzc) r4, (java.lang.String) r14)     // Catch:{ all -> 0x0ef0 }
            if (r4 != 0) goto L_0x073a
            if (r28 == 0) goto L_0x0733
            long r23 = r28.getTimestampMillis()     // Catch:{ all -> 0x0ef0 }
            long r29 = r7.getTimestampMillis()     // Catch:{ all -> 0x0ef0 }
            long r23 = r23 - r29
            long r23 = java.lang.Math.abs(r23)     // Catch:{ all -> 0x0ef0 }
            int r4 = (r23 > r11 ? 1 : (r23 == r11 ? 0 : -1))
            if (r4 > 0) goto L_0x0733
            java.lang.Object r4 = r28.clone()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey$zza r4 = (com.google.android.gms.internal.measurement.zzey.zza) r4     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzc$zza r4 = (com.google.android.gms.internal.measurement.zzbs.zzc.zza) r4     // Catch:{ all -> 0x0ef0 }
            boolean r8 = r1.zza((com.google.android.gms.internal.measurement.zzbs.zzc.zza) r4, (com.google.android.gms.internal.measurement.zzbs.zzc.zza) r7)     // Catch:{ all -> 0x0ef0 }
            if (r8 == 0) goto L_0x0733
            r8 = r27
            r9.zza((int) r8, (com.google.android.gms.internal.measurement.zzbs.zzc.zza) r4)     // Catch:{ all -> 0x0ef0 }
            r12 = r8
            goto L_0x06d7
        L_0x0733:
            r8 = r27
            r10 = r7
            r12 = r8
            r6 = r16
            goto L_0x0749
        L_0x073a:
            r8 = r27
            goto L_0x0748
        L_0x073d:
            r8 = r27
            r14 = r29
            goto L_0x0748
        L_0x0742:
            r8 = r27
            r14 = r29
            r9 = r30
        L_0x0748:
            r12 = r8
        L_0x0749:
            if (r26 != 0) goto L_0x07a9
            java.lang.String r4 = r7.getName()     // Catch:{ all -> 0x0ef0 }
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0ef0 }
            if (r2 == 0) goto L_0x07a9
            int r2 = r7.zzmk()     // Catch:{ all -> 0x0ef0 }
            if (r2 != 0) goto L_0x0775
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgn()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r4 = "Engagement event does not contain any parameters. appId"
            com.google.android.gms.internal.measurement.zzbs$zzg r8 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r8 = r8.zzag()     // Catch:{ all -> 0x0ef0 }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzef.zzam(r8)     // Catch:{ all -> 0x0ef0 }
            r2.zza(r4, r8)     // Catch:{ all -> 0x0ef0 }
            goto L_0x07a9
        L_0x0775:
            r59.zzgw()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzgi r2 = r7.zzug()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey r2 = (com.google.android.gms.internal.measurement.zzey) r2     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzc r2 = (com.google.android.gms.internal.measurement.zzbs.zzc) r2     // Catch:{ all -> 0x0ef0 }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzjo.zzb((com.google.android.gms.internal.measurement.zzbs.zzc) r2, (java.lang.String) r14)     // Catch:{ all -> 0x0ef0 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x0ef0 }
            if (r2 != 0) goto L_0x07a2
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgn()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r4 = "Engagement event does not include duration. appId"
            com.google.android.gms.internal.measurement.zzbs$zzg r8 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r8 = r8.zzag()     // Catch:{ all -> 0x0ef0 }
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzef.zzam(r8)     // Catch:{ all -> 0x0ef0 }
            r2.zza(r4, r8)     // Catch:{ all -> 0x0ef0 }
            goto L_0x07a9
        L_0x07a2:
            long r14 = r2.longValue()     // Catch:{ all -> 0x0ef0 }
            long r14 = r21 + r14
            goto L_0x07ab
        L_0x07a9:
            r14 = r21
        L_0x07ab:
            java.util.List<com.google.android.gms.internal.measurement.zzbs$zzc> r2 = r3.zztp     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzgi r4 = r7.zzug()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey r4 = (com.google.android.gms.internal.measurement.zzey) r4     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzc r4 = (com.google.android.gms.internal.measurement.zzbs.zzc) r4     // Catch:{ all -> 0x0ef0 }
            r8 = r25
            r2.set(r8, r4)     // Catch:{ all -> 0x0ef0 }
            int r16 = r16 + 1
            r9.zza((com.google.android.gms.internal.measurement.zzbs.zzc.zza) r7)     // Catch:{ all -> 0x0ef0 }
        L_0x07bf:
            int r11 = r8 + 1
            r4 = r9
            r13 = r19
            r2 = r20
            r5 = r26
            r9 = r28
            goto L_0x0288
        L_0x07cc:
            r9 = r4
            r26 = r5
            r14 = r13
            if (r26 == 0) goto L_0x0824
            r4 = r16
            r5 = 0
        L_0x07d5:
            if (r5 >= r4) goto L_0x0824
            com.google.android.gms.internal.measurement.zzbs$zzc r6 = r9.zzq(r5)     // Catch:{ all -> 0x0ef0 }
            java.lang.String r7 = r6.getName()     // Catch:{ all -> 0x0ef0 }
            boolean r7 = r2.equals(r7)     // Catch:{ all -> 0x0ef0 }
            if (r7 == 0) goto L_0x07f6
            r59.zzgw()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zze r7 = com.google.android.gms.measurement.internal.zzjo.zza((com.google.android.gms.internal.measurement.zzbs.zzc) r6, (java.lang.String) r8)     // Catch:{ all -> 0x0ef0 }
            if (r7 == 0) goto L_0x07f6
            r9.zzr(r5)     // Catch:{ all -> 0x0ef0 }
            int r4 = r4 + -1
            int r5 = r5 + -1
            goto L_0x0821
        L_0x07f6:
            r59.zzgw()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zze r6 = com.google.android.gms.measurement.internal.zzjo.zza((com.google.android.gms.internal.measurement.zzbs.zzc) r6, (java.lang.String) r14)     // Catch:{ all -> 0x0ef0 }
            if (r6 == 0) goto L_0x0821
            boolean r7 = r6.zzna()     // Catch:{ all -> 0x0ef0 }
            if (r7 == 0) goto L_0x080e
            long r6 = r6.zznb()     // Catch:{ all -> 0x0ef0 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0ef0 }
            goto L_0x080f
        L_0x080e:
            r6 = 0
        L_0x080f:
            if (r6 == 0) goto L_0x0821
            long r10 = r6.longValue()     // Catch:{ all -> 0x0ef0 }
            r12 = 0
            int r7 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r7 <= 0) goto L_0x0821
            long r6 = r6.longValue()     // Catch:{ all -> 0x0ef0 }
            long r21 = r21 + r6
        L_0x0821:
            r6 = 1
            int r5 = r5 + r6
            goto L_0x07d5
        L_0x0824:
            r14 = r21
            r2 = 0
            r1.zza((com.google.android.gms.internal.measurement.zzbs.zzg.zza) r9, (long) r14, (boolean) r2)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzs r2 = r2.zzad()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r4 = r9.zzag()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzak.zzja     // Catch:{ all -> 0x0ef0 }
            boolean r2 = r2.zze(r4, r5)     // Catch:{ all -> 0x0ef0 }
            java.lang.String r4 = "_se"
            if (r2 == 0) goto L_0x0873
            java.util.List r2 = r9.zznl()     // Catch:{ all -> 0x0ef0 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0ef0 }
        L_0x0846:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x0ef0 }
            if (r5 == 0) goto L_0x0860
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzc r5 = (com.google.android.gms.internal.measurement.zzbs.zzc) r5     // Catch:{ all -> 0x0ef0 }
            java.lang.String r6 = "_s"
            java.lang.String r5 = r5.getName()     // Catch:{ all -> 0x0ef0 }
            boolean r5 = r6.equals(r5)     // Catch:{ all -> 0x0ef0 }
            if (r5 == 0) goto L_0x0846
            r2 = 1
            goto L_0x0861
        L_0x0860:
            r2 = 0
        L_0x0861:
            if (r2 == 0) goto L_0x086e
            com.google.android.gms.measurement.internal.zzx r2 = r59.zzgy()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r5 = r9.zzag()     // Catch:{ all -> 0x0ef0 }
            r2.zzd(r5, r4)     // Catch:{ all -> 0x0ef0 }
        L_0x086e:
            r2 = 1
            r1.zza((com.google.android.gms.internal.measurement.zzbs.zzg.zza) r9, (long) r14, (boolean) r2)     // Catch:{ all -> 0x0ef0 }
            goto L_0x0890
        L_0x0873:
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzs r2 = r2.zzad()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r5 = r9.zzag()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzak.zzjb     // Catch:{ all -> 0x0ef0 }
            boolean r2 = r2.zze(r5, r6)     // Catch:{ all -> 0x0ef0 }
            if (r2 == 0) goto L_0x0890
            com.google.android.gms.measurement.internal.zzx r2 = r59.zzgy()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r5 = r9.zzag()     // Catch:{ all -> 0x0ef0 }
            r2.zzd(r5, r4)     // Catch:{ all -> 0x0ef0 }
        L_0x0890:
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzs r2 = r2.zzad()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r4 = r9.zzag()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzak.zzij     // Catch:{ all -> 0x0ef0 }
            boolean r2 = r2.zze(r4, r5)     // Catch:{ all -> 0x0ef0 }
            if (r2 == 0) goto L_0x0933
            com.google.android.gms.measurement.internal.zzjo r2 = r59.zzgw()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzef r4 = r2.zzab()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgs()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r5 = "Checking account type status for ad personalization signals"
            r4.zzao(r5)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzfd r4 = r2.zzgz()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r5 = r9.zzag()     // Catch:{ all -> 0x0ef0 }
            boolean r4 = r4.zzba(r5)     // Catch:{ all -> 0x0ef0 }
            if (r4 == 0) goto L_0x0933
            com.google.android.gms.measurement.internal.zzx r4 = r2.zzgy()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r5 = r9.zzag()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzf r4 = r4.zzab(r5)     // Catch:{ all -> 0x0ef0 }
            if (r4 == 0) goto L_0x0933
            boolean r4 = r4.zzbe()     // Catch:{ all -> 0x0ef0 }
            if (r4 == 0) goto L_0x0933
            com.google.android.gms.measurement.internal.zzac r4 = r2.zzw()     // Catch:{ all -> 0x0ef0 }
            boolean r4 = r4.zzcu()     // Catch:{ all -> 0x0ef0 }
            if (r4 == 0) goto L_0x0933
            com.google.android.gms.measurement.internal.zzef r4 = r2.zzab()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzeh r4 = r4.zzgr()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r5 = "Turning off ad personalization due to account type"
            r4.zzao(r5)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzk$zza r4 = com.google.android.gms.internal.measurement.zzbs.zzk.zzqu()     // Catch:{ all -> 0x0ef0 }
            r5 = r20
            com.google.android.gms.internal.measurement.zzbs$zzk$zza r4 = r4.zzdb(r5)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzac r2 = r2.zzw()     // Catch:{ all -> 0x0ef0 }
            long r6 = r2.zzcs()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzk$zza r2 = r4.zzbk(r6)     // Catch:{ all -> 0x0ef0 }
            r6 = 1
            com.google.android.gms.internal.measurement.zzbs$zzk$zza r2 = r2.zzbl(r6)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzgi r2 = r2.zzug()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey r2 = (com.google.android.gms.internal.measurement.zzey) r2     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzk r2 = (com.google.android.gms.internal.measurement.zzbs.zzk) r2     // Catch:{ all -> 0x0ef0 }
            r4 = 0
        L_0x0911:
            int r6 = r9.zznp()     // Catch:{ all -> 0x0ef0 }
            if (r4 >= r6) goto L_0x092d
            com.google.android.gms.internal.measurement.zzbs$zzk r6 = r9.zzs(r4)     // Catch:{ all -> 0x0ef0 }
            java.lang.String r6 = r6.getName()     // Catch:{ all -> 0x0ef0 }
            boolean r6 = r5.equals(r6)     // Catch:{ all -> 0x0ef0 }
            if (r6 == 0) goto L_0x092a
            r9.zza((int) r4, (com.google.android.gms.internal.measurement.zzbs.zzk) r2)     // Catch:{ all -> 0x0ef0 }
            r4 = 1
            goto L_0x092e
        L_0x092a:
            int r4 = r4 + 1
            goto L_0x0911
        L_0x092d:
            r4 = 0
        L_0x092e:
            if (r4 != 0) goto L_0x0933
            r9.zza((com.google.android.gms.internal.measurement.zzbs.zzk) r2)     // Catch:{ all -> 0x0ef0 }
        L_0x0933:
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r2 = r9.zznv()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r4 = r9.zzag()     // Catch:{ all -> 0x0ef0 }
            java.util.List r5 = r9.zzno()     // Catch:{ all -> 0x0ef0 }
            java.util.List r6 = r9.zznl()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzp r7 = r59.zzgx()     // Catch:{ all -> 0x0ef0 }
            java.util.List r4 = r7.zza((java.lang.String) r4, (java.util.List<com.google.android.gms.internal.measurement.zzbs.zzc>) r6, (java.util.List<com.google.android.gms.internal.measurement.zzbs.zzk>) r5)     // Catch:{ all -> 0x0ef0 }
            r2.zzc(r4)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzs r2 = r2.zzad()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzg r4 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r4 = r4.zzag()     // Catch:{ all -> 0x0ef0 }
            boolean r2 = r2.zzm(r4)     // Catch:{ all -> 0x0ef0 }
            if (r2 == 0) goto L_0x0cfd
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0ecf }
            r2.<init>()     // Catch:{ all -> 0x0ecf }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0ecf }
            r4.<init>()     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.measurement.internal.zzjs r5 = r5.zzz()     // Catch:{ all -> 0x0ecf }
            java.security.SecureRandom r5 = r5.zzjw()     // Catch:{ all -> 0x0ecf }
            r6 = 0
        L_0x0978:
            int r7 = r9.zznm()     // Catch:{ all -> 0x0ecf }
            if (r6 >= r7) goto L_0x0cc9
            com.google.android.gms.internal.measurement.zzbs$zzc r7 = r9.zzq(r6)     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.internal.measurement.zzey$zza r7 = r7.zzuj()     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.internal.measurement.zzey$zza r7 = (com.google.android.gms.internal.measurement.zzey.zza) r7     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.internal.measurement.zzbs$zzc$zza r7 = (com.google.android.gms.internal.measurement.zzbs.zzc.zza) r7     // Catch:{ all -> 0x0ecf }
            java.lang.String r8 = r7.getName()     // Catch:{ all -> 0x0ecf }
            java.lang.String r10 = "_ep"
            boolean r8 = r8.equals(r10)     // Catch:{ all -> 0x0ecf }
            java.lang.String r10 = "_sr"
            if (r8 == 0) goto L_0x0a0c
            r59.zzgw()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzgi r8 = r7.zzug()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey r8 = (com.google.android.gms.internal.measurement.zzey) r8     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzc r8 = (com.google.android.gms.internal.measurement.zzbs.zzc) r8     // Catch:{ all -> 0x0ef0 }
            java.lang.String r11 = "_en"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzjo.zzb((com.google.android.gms.internal.measurement.zzbs.zzc) r8, (java.lang.String) r11)     // Catch:{ all -> 0x0ef0 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0ef0 }
            java.lang.Object r11 = r2.get(r8)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzae r11 = (com.google.android.gms.measurement.internal.zzae) r11     // Catch:{ all -> 0x0ef0 }
            if (r11 != 0) goto L_0x09c4
            com.google.android.gms.measurement.internal.zzx r11 = r59.zzgy()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzg r12 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r12 = r12.zzag()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzae r11 = r11.zzc(r12, r8)     // Catch:{ all -> 0x0ef0 }
            r2.put(r8, r11)     // Catch:{ all -> 0x0ef0 }
        L_0x09c4:
            java.lang.Long r8 = r11.zzfm     // Catch:{ all -> 0x0ef0 }
            if (r8 != 0) goto L_0x0a01
            java.lang.Long r8 = r11.zzfn     // Catch:{ all -> 0x0ef0 }
            long r12 = r8.longValue()     // Catch:{ all -> 0x0ef0 }
            r14 = 1
            int r8 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r8 <= 0) goto L_0x09dc
            r59.zzgw()     // Catch:{ all -> 0x0ef0 }
            java.lang.Long r8 = r11.zzfn     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzjo.zza((com.google.android.gms.internal.measurement.zzbs.zzc.zza) r7, (java.lang.String) r10, (java.lang.Object) r8)     // Catch:{ all -> 0x0ef0 }
        L_0x09dc:
            java.lang.Boolean r8 = r11.zzfo     // Catch:{ all -> 0x0ef0 }
            if (r8 == 0) goto L_0x09f6
            java.lang.Boolean r8 = r11.zzfo     // Catch:{ all -> 0x0ef0 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0ef0 }
            if (r8 == 0) goto L_0x09f6
            r59.zzgw()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r8 = "_efs"
            r10 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzjo.zza((com.google.android.gms.internal.measurement.zzbs.zzc.zza) r7, (java.lang.String) r8, (java.lang.Object) r12)     // Catch:{ all -> 0x0ef0 }
        L_0x09f6:
            com.google.android.gms.internal.measurement.zzgi r8 = r7.zzug()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey r8 = (com.google.android.gms.internal.measurement.zzey) r8     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzc r8 = (com.google.android.gms.internal.measurement.zzbs.zzc) r8     // Catch:{ all -> 0x0ef0 }
            r4.add(r8)     // Catch:{ all -> 0x0ef0 }
        L_0x0a01:
            r9.zza((int) r6, (com.google.android.gms.internal.measurement.zzbs.zzc.zza) r7)     // Catch:{ all -> 0x0ef0 }
        L_0x0a04:
            r8 = r2
            r60 = r5
            r1 = r6
            r5 = 1
            goto L_0x0cbf
        L_0x0a0c:
            com.google.android.gms.measurement.internal.zzfd r8 = r59.zzgz()     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.internal.measurement.zzbs$zzg r11 = r3.zztn     // Catch:{ all -> 0x0ecf }
            java.lang.String r11 = r11.zzag()     // Catch:{ all -> 0x0ecf }
            long r11 = r8.zzbb(r11)     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.measurement.internal.zzfj r8 = r1.zzj     // Catch:{ all -> 0x0ecf }
            r8.zzz()     // Catch:{ all -> 0x0ecf }
            long r13 = r7.getTimestampMillis()     // Catch:{ all -> 0x0ecf }
            long r13 = com.google.android.gms.measurement.internal.zzjs.zzc((long) r13, (long) r11)     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.internal.measurement.zzgi r8 = r7.zzug()     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.internal.measurement.zzey r8 = (com.google.android.gms.internal.measurement.zzey) r8     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.internal.measurement.zzbs$zzc r8 = (com.google.android.gms.internal.measurement.zzbs.zzc) r8     // Catch:{ all -> 0x0ecf }
            java.lang.String r15 = "_dbg"
            r25 = r11
            r20 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r20)     // Catch:{ all -> 0x0ecf }
            boolean r12 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x0ecf }
            if (r12 != 0) goto L_0x0a99
            if (r11 != 0) goto L_0x0a42
            goto L_0x0a99
        L_0x0a42:
            java.util.List r8 = r8.zzmj()     // Catch:{ all -> 0x0ef0 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x0ef0 }
        L_0x0a4a:
            boolean r12 = r8.hasNext()     // Catch:{ all -> 0x0ef0 }
            if (r12 == 0) goto L_0x0a99
            java.lang.Object r12 = r8.next()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zze r12 = (com.google.android.gms.internal.measurement.zzbs.zze) r12     // Catch:{ all -> 0x0ef0 }
            r60 = r8
            java.lang.String r8 = r12.getName()     // Catch:{ all -> 0x0ef0 }
            boolean r8 = r15.equals(r8)     // Catch:{ all -> 0x0ef0 }
            if (r8 == 0) goto L_0x0a96
            boolean r8 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0ef0 }
            if (r8 == 0) goto L_0x0a74
            long r15 = r12.zznb()     // Catch:{ all -> 0x0ef0 }
            java.lang.Long r8 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x0ef0 }
            boolean r8 = r11.equals(r8)     // Catch:{ all -> 0x0ef0 }
            if (r8 != 0) goto L_0x0a94
        L_0x0a74:
            boolean r8 = r11 instanceof java.lang.String     // Catch:{ all -> 0x0ef0 }
            if (r8 == 0) goto L_0x0a82
            java.lang.String r8 = r12.zzmy()     // Catch:{ all -> 0x0ef0 }
            boolean r8 = r11.equals(r8)     // Catch:{ all -> 0x0ef0 }
            if (r8 != 0) goto L_0x0a94
        L_0x0a82:
            boolean r8 = r11 instanceof java.lang.Double     // Catch:{ all -> 0x0ef0 }
            if (r8 == 0) goto L_0x0a99
            double r15 = r12.zzne()     // Catch:{ all -> 0x0ef0 }
            java.lang.Double r8 = java.lang.Double.valueOf(r15)     // Catch:{ all -> 0x0ef0 }
            boolean r8 = r11.equals(r8)     // Catch:{ all -> 0x0ef0 }
            if (r8 == 0) goto L_0x0a99
        L_0x0a94:
            r8 = 1
            goto L_0x0a9a
        L_0x0a96:
            r8 = r60
            goto L_0x0a4a
        L_0x0a99:
            r8 = 0
        L_0x0a9a:
            if (r8 != 0) goto L_0x0aaf
            com.google.android.gms.measurement.internal.zzfd r8 = r59.zzgz()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzg r11 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r11 = r11.zzag()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r12 = r7.getName()     // Catch:{ all -> 0x0ef0 }
            int r8 = r8.zzm(r11, r12)     // Catch:{ all -> 0x0ef0 }
            goto L_0x0ab0
        L_0x0aaf:
            r8 = 1
        L_0x0ab0:
            if (r8 > 0) goto L_0x0ad9
            com.google.android.gms.measurement.internal.zzfj r10 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzab()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzgn()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r11 = "Sample rate must be positive. event, rate"
            java.lang.String r12 = r7.getName()     // Catch:{ all -> 0x0ef0 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0ef0 }
            r10.zza(r11, r12, r8)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzgi r8 = r7.zzug()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey r8 = (com.google.android.gms.internal.measurement.zzey) r8     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzc r8 = (com.google.android.gms.internal.measurement.zzbs.zzc) r8     // Catch:{ all -> 0x0ef0 }
            r4.add(r8)     // Catch:{ all -> 0x0ef0 }
            r9.zza((int) r6, (com.google.android.gms.internal.measurement.zzbs.zzc.zza) r7)     // Catch:{ all -> 0x0ef0 }
            goto L_0x0a04
        L_0x0ad9:
            java.lang.String r11 = r7.getName()     // Catch:{ all -> 0x0ecf }
            java.lang.Object r11 = r2.get(r11)     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.measurement.internal.zzae r11 = (com.google.android.gms.measurement.internal.zzae) r11     // Catch:{ all -> 0x0ecf }
            if (r11 != 0) goto L_0x0b72
            com.google.android.gms.measurement.internal.zzx r11 = r59.zzgy()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzg r12 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r12 = r12.zzag()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r15 = r7.getName()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzae r11 = r11.zzc(r12, r15)     // Catch:{ all -> 0x0ef0 }
            if (r11 != 0) goto L_0x0b72
            com.google.android.gms.measurement.internal.zzfj r11 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzef r11 = r11.zzab()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzeh r11 = r11.zzgn()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r12 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzbs$zzg r15 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r15 = r15.zzag()     // Catch:{ all -> 0x0ef0 }
            r20 = r13
            java.lang.String r13 = r7.getName()     // Catch:{ all -> 0x0ef0 }
            r11.zza(r12, r15, r13)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzfj r11 = r1.zzj     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzs r11 = r11.zzad()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzg r12 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r12 = r12.zzag()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzak.zziz     // Catch:{ all -> 0x0ef0 }
            boolean r11 = r11.zze(r12, r13)     // Catch:{ all -> 0x0ef0 }
            if (r11 == 0) goto L_0x0b4e
            com.google.android.gms.measurement.internal.zzae r11 = new com.google.android.gms.measurement.internal.zzae     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzg r12 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r28 = r12.zzag()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r29 = r7.getName()     // Catch:{ all -> 0x0ef0 }
            r30 = 1
            r32 = 1
            r34 = 1
            long r36 = r7.getTimestampMillis()     // Catch:{ all -> 0x0ef0 }
            r38 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r27 = r11
            r27.<init>(r28, r29, r30, r32, r34, r36, r38, r40, r41, r42, r43)     // Catch:{ all -> 0x0ef0 }
            goto L_0x0b74
        L_0x0b4e:
            com.google.android.gms.measurement.internal.zzae r11 = new com.google.android.gms.measurement.internal.zzae     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzg r12 = r3.zztn     // Catch:{ all -> 0x0ef0 }
            java.lang.String r45 = r12.zzag()     // Catch:{ all -> 0x0ef0 }
            java.lang.String r46 = r7.getName()     // Catch:{ all -> 0x0ef0 }
            r47 = 1
            r49 = 1
            long r51 = r7.getTimestampMillis()     // Catch:{ all -> 0x0ef0 }
            r53 = 0
            r55 = 0
            r56 = 0
            r57 = 0
            r58 = 0
            r44 = r11
            r44.<init>(r45, r46, r47, r49, r51, r53, r55, r56, r57, r58)     // Catch:{ all -> 0x0ef0 }
            goto L_0x0b74
        L_0x0b72:
            r20 = r13
        L_0x0b74:
            r59.zzgw()     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.internal.measurement.zzgi r12 = r7.zzug()     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.internal.measurement.zzey r12 = (com.google.android.gms.internal.measurement.zzey) r12     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.internal.measurement.zzbs$zzc r12 = (com.google.android.gms.internal.measurement.zzbs.zzc) r12     // Catch:{ all -> 0x0ecf }
            java.lang.String r13 = "_eid"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzjo.zzb((com.google.android.gms.internal.measurement.zzbs.zzc) r12, (java.lang.String) r13)     // Catch:{ all -> 0x0ecf }
            java.lang.Long r12 = (java.lang.Long) r12     // Catch:{ all -> 0x0ecf }
            if (r12 == 0) goto L_0x0b8b
            r13 = 1
            goto L_0x0b8c
        L_0x0b8b:
            r13 = 0
        L_0x0b8c:
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)     // Catch:{ all -> 0x0ecf }
            r14 = 1
            if (r8 != r14) goto L_0x0bc1
            com.google.android.gms.internal.measurement.zzgi r8 = r7.zzug()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey r8 = (com.google.android.gms.internal.measurement.zzey) r8     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzc r8 = (com.google.android.gms.internal.measurement.zzbs.zzc) r8     // Catch:{ all -> 0x0ef0 }
            r4.add(r8)     // Catch:{ all -> 0x0ef0 }
            boolean r8 = r13.booleanValue()     // Catch:{ all -> 0x0ef0 }
            if (r8 == 0) goto L_0x0bbc
            java.lang.Long r8 = r11.zzfm     // Catch:{ all -> 0x0ef0 }
            if (r8 != 0) goto L_0x0bb0
            java.lang.Long r8 = r11.zzfn     // Catch:{ all -> 0x0ef0 }
            if (r8 != 0) goto L_0x0bb0
            java.lang.Boolean r8 = r11.zzfo     // Catch:{ all -> 0x0ef0 }
            if (r8 == 0) goto L_0x0bbc
        L_0x0bb0:
            r8 = 0
            com.google.android.gms.measurement.internal.zzae r10 = r11.zza(r8, r8, r8)     // Catch:{ all -> 0x0ef0 }
            java.lang.String r8 = r7.getName()     // Catch:{ all -> 0x0ef0 }
            r2.put(r8, r10)     // Catch:{ all -> 0x0ef0 }
        L_0x0bbc:
            r9.zza((int) r6, (com.google.android.gms.internal.measurement.zzbs.zzc.zza) r7)     // Catch:{ all -> 0x0ef0 }
            goto L_0x0a04
        L_0x0bc1:
            int r14 = r5.nextInt(r8)     // Catch:{ all -> 0x0ecf }
            if (r14 != 0) goto L_0x0c05
            r59.zzgw()     // Catch:{ all -> 0x0ef0 }
            long r14 = (long) r8     // Catch:{ all -> 0x0ef0 }
            java.lang.Long r8 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.measurement.internal.zzjo.zza((com.google.android.gms.internal.measurement.zzbs.zzc.zza) r7, (java.lang.String) r10, (java.lang.Object) r8)     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzgi r8 = r7.zzug()     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzey r8 = (com.google.android.gms.internal.measurement.zzey) r8     // Catch:{ all -> 0x0ef0 }
            com.google.android.gms.internal.measurement.zzbs$zzc r8 = (com.google.android.gms.internal.measurement.zzbs.zzc) r8     // Catch:{ all -> 0x0ef0 }
            r4.add(r8)     // Catch:{ all -> 0x0ef0 }
            boolean r8 = r13.booleanValue()     // Catch:{ all -> 0x0ef0 }
            if (r8 == 0) goto L_0x0bec
            java.lang.Long r8 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0ef0 }
            r10 = 0
            com.google.android.gms.measurement.internal.zzae r11 = r11.zza(r10, r8, r10)     // Catch:{ all -> 0x0ef0 }
        L_0x0bec:
            java.lang.String r8 = r7.getName()     // Catch:{ all -> 0x0ef0 }
            long r12 = r7.getTimestampMillis()     // Catch:{ all -> 0x0ef0 }
            r14 = r20
            com.google.android.gms.measurement.internal.zzae r10 = r11.zza(r12, r14)     // Catch:{ all -> 0x0ef0 }
            r2.put(r8, r10)     // Catch:{ all -> 0x0ef0 }
            r8 = r2
            r60 = r5
            r1 = r6
            r5 = 1
            goto L_0x0cbc
        L_0x0c05:
            r60 = r5
            r14 = r20
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.measurement.internal.zzs r5 = r5.zzad()     // Catch:{ all -> 0x0ecf }
            r16 = r6
            com.google.android.gms.internal.measurement.zzbs$zzg r6 = r3.zztn     // Catch:{ all -> 0x0ecf }
            java.lang.String r6 = r6.zzag()     // Catch:{ all -> 0x0ecf }
            boolean r5 = r5.zzu(r6)     // Catch:{ all -> 0x0ecf }
            if (r5 == 0) goto L_0x0c43
            java.lang.Long r5 = r11.zzfl     // Catch:{ all -> 0x0ecf }
            if (r5 == 0) goto L_0x0c2a
            java.lang.Long r5 = r11.zzfl     // Catch:{ all -> 0x0ef0 }
            long r5 = r5.longValue()     // Catch:{ all -> 0x0ef0 }
            r18 = r2
            goto L_0x0c3b
        L_0x0c2a:
            com.google.android.gms.measurement.internal.zzfj r5 = r1.zzj     // Catch:{ all -> 0x0ecf }
            r5.zzz()     // Catch:{ all -> 0x0ecf }
            long r5 = r7.zzmm()     // Catch:{ all -> 0x0ecf }
            r18 = r2
            r1 = r25
            long r5 = com.google.android.gms.measurement.internal.zzjs.zzc((long) r5, (long) r1)     // Catch:{ all -> 0x0ecf }
        L_0x0c3b:
            int r1 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r1 == 0) goto L_0x0c41
        L_0x0c3f:
            r1 = 1
            goto L_0x0c58
        L_0x0c41:
            r1 = 0
            goto L_0x0c58
        L_0x0c43:
            r18 = r2
            long r1 = r11.zzfk     // Catch:{ all -> 0x0ecf }
            long r5 = r7.getTimestampMillis()     // Catch:{ all -> 0x0ecf }
            long r5 = r5 - r1
            long r1 = java.lang.Math.abs(r5)     // Catch:{ all -> 0x0ecf }
            r5 = 86400000(0x5265c00, double:4.2687272E-316)
            int r20 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r20 < 0) goto L_0x0c41
            goto L_0x0c3f
        L_0x0c58:
            if (r1 == 0) goto L_0x0ca4
            r59.zzgw()     // Catch:{ all -> 0x0ecf }
            java.lang.String r1 = "_efs"
            r5 = 1
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.measurement.internal.zzjo.zza((com.google.android.gms.internal.measurement.zzbs.zzc.zza) r7, (java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x0ecf }
            r59.zzgw()     // Catch:{ all -> 0x0ecf }
            long r1 = (long) r8     // Catch:{ all -> 0x0ecf }
            java.lang.Long r8 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.measurement.internal.zzjo.zza((com.google.android.gms.internal.measurement.zzbs.zzc.zza) r7, (java.lang.String) r10, (java.lang.Object) r8)     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.internal.measurement.zzgi r8 = r7.zzug()     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.internal.measurement.zzey r8 = (com.google.android.gms.internal.measurement.zzey) r8     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.internal.measurement.zzbs$zzc r8 = (com.google.android.gms.internal.measurement.zzbs.zzc) r8     // Catch:{ all -> 0x0ecf }
            r4.add(r8)     // Catch:{ all -> 0x0ecf }
            boolean r8 = r13.booleanValue()     // Catch:{ all -> 0x0ecf }
            if (r8 == 0) goto L_0x0c92
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0ecf }
            r2 = 1
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0ecf }
            r2 = 0
            com.google.android.gms.measurement.internal.zzae r11 = r11.zza(r2, r1, r8)     // Catch:{ all -> 0x0ecf }
        L_0x0c92:
            java.lang.String r1 = r7.getName()     // Catch:{ all -> 0x0ecf }
            long r12 = r7.getTimestampMillis()     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.measurement.internal.zzae r2 = r11.zza(r12, r14)     // Catch:{ all -> 0x0ecf }
            r8 = r18
            r8.put(r1, r2)     // Catch:{ all -> 0x0ecf }
            goto L_0x0cba
        L_0x0ca4:
            r8 = r18
            r5 = 1
            boolean r1 = r13.booleanValue()     // Catch:{ all -> 0x0ecf }
            if (r1 == 0) goto L_0x0cba
            java.lang.String r1 = r7.getName()     // Catch:{ all -> 0x0ecf }
            r2 = 0
            com.google.android.gms.measurement.internal.zzae r10 = r11.zza(r12, r2, r2)     // Catch:{ all -> 0x0ecf }
            r8.put(r1, r10)     // Catch:{ all -> 0x0ecf }
        L_0x0cba:
            r1 = r16
        L_0x0cbc:
            r9.zza((int) r1, (com.google.android.gms.internal.measurement.zzbs.zzc.zza) r7)     // Catch:{ all -> 0x0ecf }
        L_0x0cbf:
            int r1 = r1 + 1
            r5 = r60
            r6 = r1
            r2 = r8
            r1 = r59
            goto L_0x0978
        L_0x0cc9:
            r8 = r2
            int r1 = r4.size()     // Catch:{ all -> 0x0ecf }
            int r2 = r9.zznm()     // Catch:{ all -> 0x0ecf }
            if (r1 >= r2) goto L_0x0cdb
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r1 = r9.zznn()     // Catch:{ all -> 0x0ecf }
            r1.zza((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzbs.zzc>) r4)     // Catch:{ all -> 0x0ecf }
        L_0x0cdb:
            java.util.Set r1 = r8.entrySet()     // Catch:{ all -> 0x0ecf }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0ecf }
        L_0x0ce3:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0ecf }
            if (r2 == 0) goto L_0x0cfd
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0ecf }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.measurement.internal.zzx r4 = r59.zzgy()     // Catch:{ all -> 0x0ecf }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.measurement.internal.zzae r2 = (com.google.android.gms.measurement.internal.zzae) r2     // Catch:{ all -> 0x0ecf }
            r4.zza((com.google.android.gms.measurement.internal.zzae) r2)     // Catch:{ all -> 0x0ecf }
            goto L_0x0ce3
        L_0x0cfd:
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            com.google.android.gms.internal.measurement.zzbs$zzg$zza r1 = r9.zzao(r1)     // Catch:{ all -> 0x0ecf }
            r4 = -9223372036854775808
            r1.zzap(r4)     // Catch:{ all -> 0x0ecf }
            r1 = 0
        L_0x0d0c:
            int r2 = r9.zznm()     // Catch:{ all -> 0x0ecf }
            if (r1 >= r2) goto L_0x0d3f
            com.google.android.gms.internal.measurement.zzbs$zzc r2 = r9.zzq(r1)     // Catch:{ all -> 0x0ecf }
            long r4 = r2.getTimestampMillis()     // Catch:{ all -> 0x0ecf }
            long r6 = r9.zznq()     // Catch:{ all -> 0x0ecf }
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x0d29
            long r4 = r2.getTimestampMillis()     // Catch:{ all -> 0x0ecf }
            r9.zzao(r4)     // Catch:{ all -> 0x0ecf }
        L_0x0d29:
            long r4 = r2.getTimestampMillis()     // Catch:{ all -> 0x0ecf }
            long r6 = r9.zznr()     // Catch:{ all -> 0x0ecf }
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0d3c
            long r4 = r2.getTimestampMillis()     // Catch:{ all -> 0x0ecf }
            r9.zzap(r4)     // Catch:{ all -> 0x0ecf }
        L_0x0d3c:
            int r1 = r1 + 1
            goto L_0x0d0c
        L_0x0d3f:
            com.google.android.gms.internal.measurement.zzbs$zzg r1 = r3.zztn     // Catch:{ all -> 0x0ecf }
            java.lang.String r1 = r1.zzag()     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.measurement.internal.zzx r2 = r59.zzgy()     // Catch:{ all -> 0x0ecf }
            com.google.android.gms.measurement.internal.zzf r2 = r2.zzab(r1)     // Catch:{ all -> 0x0ecf }
            if (r2 != 0) goto L_0x0d6b
            r5 = r59
            com.google.android.gms.measurement.internal.zzfj r2 = r5.zzj     // Catch:{ all -> 0x0eee }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()     // Catch:{ all -> 0x0eee }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgk()     // Catch:{ all -> 0x0eee }
            java.lang.String r4 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzbs$zzg r6 = r3.zztn     // Catch:{ all -> 0x0eee }
            java.lang.String r6 = r6.zzag()     // Catch:{ all -> 0x0eee }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzef.zzam(r6)     // Catch:{ all -> 0x0eee }
            r2.zza(r4, r6)     // Catch:{ all -> 0x0eee }
            goto L_0x0dc8
        L_0x0d6b:
            r5 = r59
            int r4 = r9.zznm()     // Catch:{ all -> 0x0eee }
            if (r4 <= 0) goto L_0x0dc8
            long r6 = r2.zzak()     // Catch:{ all -> 0x0eee }
            r10 = 0
            int r4 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r4 == 0) goto L_0x0d81
            r9.zzar(r6)     // Catch:{ all -> 0x0eee }
            goto L_0x0d84
        L_0x0d81:
            r9.zznt()     // Catch:{ all -> 0x0eee }
        L_0x0d84:
            long r10 = r2.zzaj()     // Catch:{ all -> 0x0eee }
            r12 = 0
            int r4 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r4 != 0) goto L_0x0d8f
            goto L_0x0d90
        L_0x0d8f:
            r6 = r10
        L_0x0d90:
            int r4 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r4 == 0) goto L_0x0d98
            r9.zzaq(r6)     // Catch:{ all -> 0x0eee }
            goto L_0x0d9b
        L_0x0d98:
            r9.zzns()     // Catch:{ all -> 0x0eee }
        L_0x0d9b:
            r2.zzau()     // Catch:{ all -> 0x0eee }
            long r6 = r2.zzar()     // Catch:{ all -> 0x0eee }
            int r4 = (int) r6     // Catch:{ all -> 0x0eee }
            r9.zzu(r4)     // Catch:{ all -> 0x0eee }
            long r6 = r9.zznq()     // Catch:{ all -> 0x0eee }
            r2.zze((long) r6)     // Catch:{ all -> 0x0eee }
            long r6 = r9.zznr()     // Catch:{ all -> 0x0eee }
            r2.zzf((long) r6)     // Catch:{ all -> 0x0eee }
            java.lang.String r4 = r2.zzbc()     // Catch:{ all -> 0x0eee }
            if (r4 == 0) goto L_0x0dbe
            r9.zzcl(r4)     // Catch:{ all -> 0x0eee }
            goto L_0x0dc1
        L_0x0dbe:
            r9.zznu()     // Catch:{ all -> 0x0eee }
        L_0x0dc1:
            com.google.android.gms.measurement.internal.zzx r4 = r59.zzgy()     // Catch:{ all -> 0x0eee }
            r4.zza((com.google.android.gms.measurement.internal.zzf) r2)     // Catch:{ all -> 0x0eee }
        L_0x0dc8:
            int r2 = r9.zznm()     // Catch:{ all -> 0x0eee }
            if (r2 <= 0) goto L_0x0e2e
            com.google.android.gms.measurement.internal.zzfj r2 = r5.zzj     // Catch:{ all -> 0x0eee }
            r2.zzae()     // Catch:{ all -> 0x0eee }
            com.google.android.gms.measurement.internal.zzfd r2 = r59.zzgz()     // Catch:{ all -> 0x0eee }
            com.google.android.gms.internal.measurement.zzbs$zzg r4 = r3.zztn     // Catch:{ all -> 0x0eee }
            java.lang.String r4 = r4.zzag()     // Catch:{ all -> 0x0eee }
            com.google.android.gms.internal.measurement.zzbw r2 = r2.zzaw(r4)     // Catch:{ all -> 0x0eee }
            if (r2 == 0) goto L_0x0df2
            java.lang.Long r4 = r2.zzzk     // Catch:{ all -> 0x0eee }
            if (r4 != 0) goto L_0x0de8
            goto L_0x0df2
        L_0x0de8:
            java.lang.Long r2 = r2.zzzk     // Catch:{ all -> 0x0eee }
            long r6 = r2.longValue()     // Catch:{ all -> 0x0eee }
            r9.zzav(r6)     // Catch:{ all -> 0x0eee }
            goto L_0x0e1d
        L_0x0df2:
            com.google.android.gms.internal.measurement.zzbs$zzg r2 = r3.zztn     // Catch:{ all -> 0x0eee }
            java.lang.String r2 = r2.getGmpAppId()     // Catch:{ all -> 0x0eee }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0eee }
            if (r2 == 0) goto L_0x0e04
            r6 = -1
            r9.zzav(r6)     // Catch:{ all -> 0x0eee }
            goto L_0x0e1d
        L_0x0e04:
            com.google.android.gms.measurement.internal.zzfj r2 = r5.zzj     // Catch:{ all -> 0x0eee }
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()     // Catch:{ all -> 0x0eee }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgn()     // Catch:{ all -> 0x0eee }
            java.lang.String r4 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzbs$zzg r6 = r3.zztn     // Catch:{ all -> 0x0eee }
            java.lang.String r6 = r6.zzag()     // Catch:{ all -> 0x0eee }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzef.zzam(r6)     // Catch:{ all -> 0x0eee }
            r2.zza(r4, r6)     // Catch:{ all -> 0x0eee }
        L_0x0e1d:
            com.google.android.gms.measurement.internal.zzx r2 = r59.zzgy()     // Catch:{ all -> 0x0eee }
            com.google.android.gms.internal.measurement.zzgi r4 = r9.zzug()     // Catch:{ all -> 0x0eee }
            com.google.android.gms.internal.measurement.zzey r4 = (com.google.android.gms.internal.measurement.zzey) r4     // Catch:{ all -> 0x0eee }
            com.google.android.gms.internal.measurement.zzbs$zzg r4 = (com.google.android.gms.internal.measurement.zzbs.zzg) r4     // Catch:{ all -> 0x0eee }
            r12 = r19
            r2.zza((com.google.android.gms.internal.measurement.zzbs.zzg) r4, (boolean) r12)     // Catch:{ all -> 0x0eee }
        L_0x0e2e:
            com.google.android.gms.measurement.internal.zzx r2 = r59.zzgy()     // Catch:{ all -> 0x0eee }
            java.util.List<java.lang.Long> r3 = r3.zzto     // Catch:{ all -> 0x0eee }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0eee }
            r2.zzo()     // Catch:{ all -> 0x0eee }
            r2.zzbi()     // Catch:{ all -> 0x0eee }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0eee }
            java.lang.String r6 = "rowid in ("
            r4.<init>(r6)     // Catch:{ all -> 0x0eee }
            r6 = 0
        L_0x0e45:
            int r7 = r3.size()     // Catch:{ all -> 0x0eee }
            if (r6 >= r7) goto L_0x0e62
            if (r6 == 0) goto L_0x0e52
            java.lang.String r7 = ","
            r4.append(r7)     // Catch:{ all -> 0x0eee }
        L_0x0e52:
            java.lang.Object r7 = r3.get(r6)     // Catch:{ all -> 0x0eee }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0eee }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0eee }
            r4.append(r7)     // Catch:{ all -> 0x0eee }
            int r6 = r6 + 1
            goto L_0x0e45
        L_0x0e62:
            java.lang.String r6 = ")"
            r4.append(r6)     // Catch:{ all -> 0x0eee }
            android.database.sqlite.SQLiteDatabase r6 = r2.getWritableDatabase()     // Catch:{ all -> 0x0eee }
            java.lang.String r7 = "raw_events"
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0eee }
            r8 = 0
            int r4 = r6.delete(r7, r4, r8)     // Catch:{ all -> 0x0eee }
            int r6 = r3.size()     // Catch:{ all -> 0x0eee }
            if (r4 == r6) goto L_0x0e95
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()     // Catch:{ all -> 0x0eee }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgk()     // Catch:{ all -> 0x0eee }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0eee }
            int r3 = r3.size()     // Catch:{ all -> 0x0eee }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0eee }
            r2.zza(r6, r4, r3)     // Catch:{ all -> 0x0eee }
        L_0x0e95:
            com.google.android.gms.measurement.internal.zzx r2 = r59.zzgy()     // Catch:{ all -> 0x0eee }
            android.database.sqlite.SQLiteDatabase r3 = r2.getWritableDatabase()     // Catch:{ all -> 0x0eee }
            java.lang.String r4 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0eac }
            r7 = 0
            r6[r7] = r1     // Catch:{ SQLiteException -> 0x0eac }
            r7 = 1
            r6[r7] = r1     // Catch:{ SQLiteException -> 0x0eac }
            r3.execSQL(r4, r6)     // Catch:{ SQLiteException -> 0x0eac }
            goto L_0x0ebf
        L_0x0eac:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzab()     // Catch:{ all -> 0x0eee }
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzgk()     // Catch:{ all -> 0x0eee }
            java.lang.String r4 = "Failed to remove unused event metadata. appId"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzef.zzam(r1)     // Catch:{ all -> 0x0eee }
            r2.zza(r4, r1, r3)     // Catch:{ all -> 0x0eee }
        L_0x0ebf:
            com.google.android.gms.measurement.internal.zzx r1 = r59.zzgy()     // Catch:{ all -> 0x0eee }
            r1.setTransactionSuccessful()     // Catch:{ all -> 0x0eee }
            com.google.android.gms.measurement.internal.zzx r1 = r59.zzgy()
            r1.endTransaction()
            r1 = 1
            return r1
        L_0x0ecf:
            r0 = move-exception
            r5 = r59
            goto L_0x0ef2
        L_0x0ed3:
            r5 = r1
            com.google.android.gms.measurement.internal.zzx r1 = r59.zzgy()     // Catch:{ all -> 0x0eee }
            r1.setTransactionSuccessful()     // Catch:{ all -> 0x0eee }
            com.google.android.gms.measurement.internal.zzx r1 = r59.zzgy()
            r1.endTransaction()
            r1 = 0
            return r1
        L_0x0ee4:
            r0 = move-exception
            r5 = r1
            goto L_0x022f
        L_0x0ee8:
            if (r4 == 0) goto L_0x0eed
            r4.close()     // Catch:{ all -> 0x0eee }
        L_0x0eed:
            throw r1     // Catch:{ all -> 0x0eee }
        L_0x0eee:
            r0 = move-exception
            goto L_0x0ef2
        L_0x0ef0:
            r0 = move-exception
            r5 = r1
        L_0x0ef2:
            r1 = r0
            com.google.android.gms.measurement.internal.zzx r2 = r59.zzgy()
            r2.endTransaction()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.zzd(java.lang.String, long):boolean");
    }

    private final void zza(zzbs.zzg.zza zza2, long j, boolean z) {
        zzjp zzjp;
        String str = z ? "_se" : "_lte";
        zzjp zze = zzgy().zze(zza2.zzag(), str);
        if (zze == null || zze.value == null) {
            zzjp = new zzjp(zza2.zzag(), "auto", str, this.zzj.zzx().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzjp = new zzjp(zza2.zzag(), "auto", str, this.zzj.zzx().currentTimeMillis(), Long.valueOf(((Long) zze.value).longValue() + j));
        }
        zzbs.zzk zzk = (zzbs.zzk) ((zzey) zzbs.zzk.zzqu().zzdb(str).zzbk(this.zzj.zzx().currentTimeMillis()).zzbl(((Long) zzjp.value).longValue()).zzug());
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (i >= zza2.zznp()) {
                break;
            } else if (str.equals(zza2.zzs(i).getName())) {
                zza2.zza(i, zzk);
                z2 = true;
                break;
            } else {
                i++;
            }
        }
        if (!z2) {
            zza2.zza(zzk);
        }
        if (j > 0) {
            zzgy().zza(zzjp);
            this.zzj.zzab().zzgr().zza("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", zzjp.value);
        }
    }

    private final boolean zza(zzbs.zzc.zza zza2, zzbs.zzc.zza zza3) {
        String str;
        Preconditions.checkArgument("_e".equals(zza2.getName()));
        zzgw();
        zzbs.zze zza4 = zzjo.zza((zzbs.zzc) ((zzey) zza2.zzug()), "_sc");
        String str2 = null;
        if (zza4 == null) {
            str = null;
        } else {
            str = zza4.zzmy();
        }
        zzgw();
        zzbs.zze zza5 = zzjo.zza((zzbs.zzc) ((zzey) zza3.zzug()), "_pc");
        if (zza5 != null) {
            str2 = zza5.zzmy();
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        zzgw();
        zzbs.zze zza6 = zzjo.zza((zzbs.zzc) ((zzey) zza2.zzug()), "_et");
        if (zza6.zzna() && zza6.zznb() > 0) {
            long zznb = zza6.zznb();
            zzgw();
            zzbs.zze zza7 = zzjo.zza((zzbs.zzc) ((zzey) zza3.zzug()), "_et");
            if (zza7 != null && zza7.zznb() > 0) {
                zznb += zza7.zznb();
            }
            zzgw();
            zzjo.zza(zza3, "_et", (Object) Long.valueOf(zznb));
            zzgw();
            zzjo.zza(zza2, "_fr", (Object) 1L);
        }
        return true;
    }

    private static void zza(zzbs.zzc.zza zza2, String str) {
        List<zzbs.zze> zzmj = zza2.zzmj();
        for (int i = 0; i < zzmj.size(); i++) {
            if (str.equals(zzmj.get(i).getName())) {
                zza2.zzm(i);
                return;
            }
        }
    }

    private static void zza(zzbs.zzc.zza zza2, int i, String str) {
        List<zzbs.zze> zzmj = zza2.zzmj();
        int i2 = 0;
        while (i2 < zzmj.size()) {
            if (!"_err".equals(zzmj.get(i2).getName())) {
                i2++;
            } else {
                return;
            }
        }
        zza2.zza((zzbs.zze) ((zzey) zzbs.zze.zzng().zzbz("_err").zzam(Long.valueOf((long) i).longValue()).zzug())).zza((zzbs.zze) ((zzey) zzbs.zze.zzng().zzbz("_ev").zzca(str).zzug()));
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzx zzgy;
        zzo();
        zzjj();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zztd = false;
                zzjo();
                throw th2;
            }
        }
        List<Long> list = this.zzth;
        this.zzth = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzj.zzac().zzlj.set(this.zzj.zzx().currentTimeMillis());
                this.zzj.zzac().zzlk.set(0);
                zzjn();
                this.zzj.zzab().zzgs().zza("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzgy().beginTransaction();
                try {
                    for (Long next : list) {
                        try {
                            zzgy = zzgy();
                            long longValue = next.longValue();
                            zzgy.zzo();
                            zzgy.zzbi();
                            if (zzgy.getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zzgy.zzab().zzgk().zza("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            List<Long> list2 = this.zzti;
                            if (list2 == null || !list2.contains(next)) {
                                throw e2;
                            }
                        }
                    }
                    zzgy().setTransactionSuccessful();
                    zzgy().endTransaction();
                    this.zzti = null;
                    if (!zzjf().zzgv() || !zzjm()) {
                        this.zztj = -1;
                        zzjn();
                    } else {
                        zzjl();
                    }
                    this.zzsy = 0;
                } catch (Throwable th3) {
                    zzgy().endTransaction();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                this.zzj.zzab().zzgk().zza("Database error while trying to delete uploaded bundles", e3);
                this.zzsy = this.zzj.zzx().elapsedRealtime();
                this.zzj.zzab().zzgs().zza("Disable upload, time", Long.valueOf(this.zzsy));
            }
        } else {
            this.zzj.zzab().zzgs().zza("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzj.zzac().zzlk.set(this.zzj.zzx().currentTimeMillis());
            if (i != 503) {
                if (i != 429) {
                    z = false;
                }
            }
            if (z) {
                this.zzj.zzac().zzll.set(this.zzj.zzx().currentTimeMillis());
            }
            zzgy().zzb(list);
            zzjn();
        }
        this.zztd = false;
        zzjo();
    }

    private final boolean zzjm() {
        zzo();
        zzjj();
        return zzgy().zzcd() || !TextUtils.isEmpty(zzgy().zzby());
    }

    private final void zzb(zzf zzf) {
        zzo();
        if (!TextUtils.isEmpty(zzf.getGmpAppId()) || (zzs.zzbx() && !TextUtils.isEmpty(zzf.zzah()))) {
            zzs zzad = this.zzj.zzad();
            Uri.Builder builder = new Uri.Builder();
            String gmpAppId = zzf.getGmpAppId();
            if (TextUtils.isEmpty(gmpAppId) && zzs.zzbx()) {
                gmpAppId = zzf.zzah();
            }
            ArrayMap arrayMap = null;
            Uri.Builder encodedAuthority = builder.scheme(zzak.zzgj.get(null)).encodedAuthority(zzak.zzgk.get(null));
            String valueOf = String.valueOf(gmpAppId);
            encodedAuthority.path(valueOf.length() != 0 ? "config/app/".concat(valueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", zzf.getAppInstanceId()).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", String.valueOf(zzad.zzao()));
            String uri = builder.build().toString();
            try {
                URL url = new URL(uri);
                this.zzj.zzab().zzgs().zza("Fetching remote configuration", zzf.zzag());
                zzbw zzaw = zzgz().zzaw(zzf.zzag());
                String zzax = zzgz().zzax(zzf.zzag());
                if (zzaw != null && !TextUtils.isEmpty(zzax)) {
                    arrayMap = new ArrayMap();
                    arrayMap.put("If-Modified-Since", zzax);
                }
                this.zztc = true;
                zzej zzjf = zzjf();
                String zzag = zzf.zzag();
                zzjl zzjl = new zzjl(this);
                zzjf.zzo();
                zzjf.zzbi();
                Preconditions.checkNotNull(url);
                Preconditions.checkNotNull(zzjl);
                zzjf.zzaa().zzb((Runnable) new zzen(zzjf, zzag, url, (byte[]) null, arrayMap, zzjl));
            } catch (MalformedURLException unused) {
                this.zzj.zzab().zzgk().zza("Failed to parse config URL. Not fetching. appId", zzef.zzam(zzf.zzag()), uri);
            }
        } else {
            zzb(zzf.zzag(), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x013a A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x014a A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0172 A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0176 A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            r6 = this;
            r6.zzo()
            r6.zzjj()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            r0 = 0
            if (r10 != 0) goto L_0x000e
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x0196 }
        L_0x000e:
            com.google.android.gms.measurement.internal.zzfj r1 = r6.zzj     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()     // Catch:{ all -> 0x0196 }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r10.length     // Catch:{ all -> 0x0196 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0196 }
            r1.zza(r2, r3)     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzx r1 = r6.zzgy()     // Catch:{ all -> 0x0196 }
            r1.beginTransaction()     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzx r1 = r6.zzgy()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzf r1 = r1.zzab(r7)     // Catch:{ all -> 0x018d }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 304(0x130, float:4.26E-43)
            r4 = 1
            if (r8 == r2) goto L_0x003e
            r2 = 204(0xcc, float:2.86E-43)
            if (r8 == r2) goto L_0x003e
            if (r8 != r3) goto L_0x0042
        L_0x003e:
            if (r9 != 0) goto L_0x0042
            r2 = 1
            goto L_0x0043
        L_0x0042:
            r2 = 0
        L_0x0043:
            if (r1 != 0) goto L_0x005a
            com.google.android.gms.measurement.internal.zzfj r8 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzef r8 = r8.zzab()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzeh r8 = r8.zzgn()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzef.zzam(r7)     // Catch:{ all -> 0x018d }
            r8.zza(r9, r7)     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x005a:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00ca
            if (r8 != r5) goto L_0x0061
            goto L_0x00ca
        L_0x0061:
            com.google.android.gms.measurement.internal.zzfj r10 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r10 = r10.zzx()     // Catch:{ all -> 0x018d }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r1.zzm(r10)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzx r10 = r6.zzgy()     // Catch:{ all -> 0x018d }
            r10.zza((com.google.android.gms.measurement.internal.zzf) r1)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfj r10 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzef r10 = r10.zzab()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzgs()     // Catch:{ all -> 0x018d }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x018d }
            r10.zza(r11, r1, r9)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfd r9 = r6.zzgz()     // Catch:{ all -> 0x018d }
            r9.zzay(r7)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfj r7 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzac()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzlk     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfj r9 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r9 = r9.zzx()     // Catch:{ all -> 0x018d }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r7.set(r9)     // Catch:{ all -> 0x018d }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00ae
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r4 = 0
        L_0x00ae:
            if (r4 == 0) goto L_0x00c5
            com.google.android.gms.measurement.internal.zzfj r7 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzeo r7 = r7.zzac()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzet r7 = r7.zzll     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfj r8 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r8 = r8.zzx()     // Catch:{ all -> 0x018d }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r7.set(r8)     // Catch:{ all -> 0x018d }
        L_0x00c5:
            r6.zzjn()     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x00ca:
            r9 = 0
            if (r11 == 0) goto L_0x00d6
            java.lang.String r2 = "Last-Modified"
            java.lang.Object r11 = r11.get(r2)     // Catch:{ all -> 0x018d }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x018d }
            goto L_0x00d7
        L_0x00d6:
            r11 = r9
        L_0x00d7:
            if (r11 == 0) goto L_0x00e6
            int r2 = r11.size()     // Catch:{ all -> 0x018d }
            if (r2 <= 0) goto L_0x00e6
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x018d }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x018d }
            goto L_0x00e7
        L_0x00e6:
            r11 = r9
        L_0x00e7:
            if (r8 == r5) goto L_0x0103
            if (r8 != r3) goto L_0x00ec
            goto L_0x0103
        L_0x00ec:
            com.google.android.gms.measurement.internal.zzfd r9 = r6.zzgz()     // Catch:{ all -> 0x018d }
            boolean r9 = r9.zza(r7, r10, r11)     // Catch:{ all -> 0x018d }
            if (r9 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzx r7 = r6.zzgy()     // Catch:{ all -> 0x0196 }
            r7.endTransaction()     // Catch:{ all -> 0x0196 }
            r6.zztc = r0
            r6.zzjo()
            return
        L_0x0103:
            com.google.android.gms.measurement.internal.zzfd r11 = r6.zzgz()     // Catch:{ all -> 0x018d }
            com.google.android.gms.internal.measurement.zzbw r11 = r11.zzaw(r7)     // Catch:{ all -> 0x018d }
            if (r11 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzfd r11 = r6.zzgz()     // Catch:{ all -> 0x018d }
            boolean r9 = r11.zza(r7, r9, r9)     // Catch:{ all -> 0x018d }
            if (r9 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzx r7 = r6.zzgy()     // Catch:{ all -> 0x0196 }
            r7.endTransaction()     // Catch:{ all -> 0x0196 }
            r6.zztc = r0
            r6.zzjo()
            return
        L_0x0124:
            com.google.android.gms.measurement.internal.zzfj r9 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r9 = r9.zzx()     // Catch:{ all -> 0x018d }
            long r2 = r9.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r1.zzl(r2)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzx r9 = r6.zzgy()     // Catch:{ all -> 0x018d }
            r9.zza((com.google.android.gms.measurement.internal.zzf) r1)     // Catch:{ all -> 0x018d }
            if (r8 != r5) goto L_0x014a
            com.google.android.gms.measurement.internal.zzfj r8 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzef r8 = r8.zzab()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzeh r8 = r8.zzgp()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.zza(r9, r7)     // Catch:{ all -> 0x018d }
            goto L_0x0162
        L_0x014a:
            com.google.android.gms.measurement.internal.zzfj r7 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzef r7 = r7.zzab()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzgs()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x018d }
            int r10 = r10.length     // Catch:{ all -> 0x018d }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x018d }
            r7.zza(r9, r8, r10)     // Catch:{ all -> 0x018d }
        L_0x0162:
            com.google.android.gms.measurement.internal.zzej r7 = r6.zzjf()     // Catch:{ all -> 0x018d }
            boolean r7 = r7.zzgv()     // Catch:{ all -> 0x018d }
            if (r7 == 0) goto L_0x0176
            boolean r7 = r6.zzjm()     // Catch:{ all -> 0x018d }
            if (r7 == 0) goto L_0x0176
            r6.zzjl()     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x0176:
            r6.zzjn()     // Catch:{ all -> 0x018d }
        L_0x0179:
            com.google.android.gms.measurement.internal.zzx r7 = r6.zzgy()     // Catch:{ all -> 0x018d }
            r7.setTransactionSuccessful()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzx r7 = r6.zzgy()     // Catch:{ all -> 0x0196 }
            r7.endTransaction()     // Catch:{ all -> 0x0196 }
            r6.zztc = r0
            r6.zzjo()
            return
        L_0x018d:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzx r8 = r6.zzgy()     // Catch:{ all -> 0x0196 }
            r8.endTransaction()     // Catch:{ all -> 0x0196 }
            throw r7     // Catch:{ all -> 0x0196 }
        L_0x0196:
            r7 = move-exception
            r6.zztc = r0
            r6.zzjo()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.zzb(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzjn() {
        /*
            r21 = this;
            r0 = r21
            r21.zzo()
            r21.zzjj()
            boolean r1 = r21.zzjr()
            if (r1 != 0) goto L_0x001d
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzs r1 = r1.zzad()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzak.zzim
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean>) r2)
            if (r1 != 0) goto L_0x001d
            return
        L_0x001d:
            long r1 = r0.zzsy
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0062
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzx()
            long r1 = r1.elapsedRealtime()
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            long r7 = r0.zzsy
            long r1 = r1 - r7
            long r1 = java.lang.Math.abs(r1)
            long r5 = r5 - r1
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0060
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            java.lang.String r3 = "Upload has been suspended. Will update scheduling later in approximately ms"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.zzem r1 = r21.zzjg()
            r1.unregister()
            com.google.android.gms.measurement.internal.zzjc r1 = r21.zzjh()
            r1.cancel()
            return
        L_0x0060:
            r0.zzsy = r3
        L_0x0062:
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            boolean r1 = r1.zzie()
            if (r1 == 0) goto L_0x026a
            boolean r1 = r21.zzjm()
            if (r1 != 0) goto L_0x0072
            goto L_0x026a
        L_0x0072:
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzx()
            long r1 = r1.currentTimeMillis()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzak.zzhf
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.zzx r5 = r21.zzgy()
            boolean r5 = r5.zzce()
            if (r5 != 0) goto L_0x00a4
            com.google.android.gms.measurement.internal.zzx r5 = r21.zzgy()
            boolean r5 = r5.zzbz()
            if (r5 == 0) goto L_0x00a2
            goto L_0x00a4
        L_0x00a2:
            r5 = 0
            goto L_0x00a5
        L_0x00a4:
            r5 = 1
        L_0x00a5:
            if (r5 == 0) goto L_0x00e1
            com.google.android.gms.measurement.internal.zzfj r10 = r0.zzj
            com.google.android.gms.measurement.internal.zzs r10 = r10.zzad()
            java.lang.String r10 = r10.zzbu()
            boolean r11 = android.text.TextUtils.isEmpty(r10)
            if (r11 != 0) goto L_0x00d0
            java.lang.String r11 = ".none."
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L_0x00d0
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzak.zzha
            java.lang.Object r10 = r10.get(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            goto L_0x00f1
        L_0x00d0:
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzak.zzgz
            java.lang.Object r10 = r10.get(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            goto L_0x00f1
        L_0x00e1:
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzak.zzgy
            java.lang.Object r10 = r10.get(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
        L_0x00f1:
            com.google.android.gms.measurement.internal.zzfj r12 = r0.zzj
            com.google.android.gms.measurement.internal.zzeo r12 = r12.zzac()
            com.google.android.gms.measurement.internal.zzet r12 = r12.zzlj
            long r12 = r12.get()
            com.google.android.gms.measurement.internal.zzfj r14 = r0.zzj
            com.google.android.gms.measurement.internal.zzeo r14 = r14.zzac()
            com.google.android.gms.measurement.internal.zzet r14 = r14.zzlk
            long r14 = r14.get()
            com.google.android.gms.measurement.internal.zzx r16 = r21.zzgy()
            r17 = r10
            long r9 = r16.zzcb()
            com.google.android.gms.measurement.internal.zzx r11 = r21.zzgy()
            r19 = r7
            long r6 = r11.zzcc()
            long r6 = java.lang.Math.max(r9, r6)
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x0128
        L_0x0125:
            r10 = r3
            goto L_0x019d
        L_0x0128:
            long r6 = r6 - r1
            long r6 = java.lang.Math.abs(r6)
            long r6 = r1 - r6
            long r12 = r12 - r1
            long r8 = java.lang.Math.abs(r12)
            long r8 = r1 - r8
            long r14 = r14 - r1
            long r10 = java.lang.Math.abs(r14)
            long r1 = r1 - r10
            long r8 = java.lang.Math.max(r8, r1)
            long r10 = r6 + r19
            if (r5 == 0) goto L_0x014e
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x014e
            long r10 = java.lang.Math.min(r6, r8)
            long r10 = r10 + r17
        L_0x014e:
            com.google.android.gms.measurement.internal.zzjo r5 = r21.zzgw()
            r12 = r17
            boolean r5 = r5.zzb((long) r8, (long) r12)
            if (r5 != 0) goto L_0x015c
            long r10 = r8 + r12
        L_0x015c:
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x019d
            int r5 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x019d
            r5 = 0
        L_0x0165:
            r6 = 20
            com.google.android.gms.measurement.internal.zzdu<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzak.zzhh
            r8 = 0
            java.lang.Object r7 = r7.get(r8)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r9 = 0
            int r7 = java.lang.Math.max(r9, r7)
            int r6 = java.lang.Math.min(r6, r7)
            if (r5 >= r6) goto L_0x0125
            r6 = 1
            long r6 = r6 << r5
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r12 = com.google.android.gms.measurement.internal.zzak.zzhg
            java.lang.Object r12 = r12.get(r8)
            java.lang.Long r12 = (java.lang.Long) r12
            long r12 = r12.longValue()
            long r12 = java.lang.Math.max(r3, r12)
            long r12 = r12 * r6
            long r10 = r10 + r12
            int r6 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x019a
            goto L_0x019d
        L_0x019a:
            int r5 = r5 + 1
            goto L_0x0165
        L_0x019d:
            int r1 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x01bf
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.String r2 = "Next upload time is 0"
            r1.zzao(r2)
            com.google.android.gms.measurement.internal.zzem r1 = r21.zzjg()
            r1.unregister()
            com.google.android.gms.measurement.internal.zzjc r1 = r21.zzjh()
            r1.cancel()
            return
        L_0x01bf:
            com.google.android.gms.measurement.internal.zzej r1 = r21.zzjf()
            boolean r1 = r1.zzgv()
            if (r1 != 0) goto L_0x01e7
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.String r2 = "No network"
            r1.zzao(r2)
            com.google.android.gms.measurement.internal.zzem r1 = r21.zzjg()
            r1.zzha()
            com.google.android.gms.measurement.internal.zzjc r1 = r21.zzjh()
            r1.cancel()
            return
        L_0x01e7:
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzeo r1 = r1.zzac()
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzll
            long r1 = r1.get()
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzak.zzgw
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzjo r7 = r21.zzgw()
            boolean r7 = r7.zzb((long) r1, (long) r5)
            if (r7 != 0) goto L_0x0213
            long r1 = r1 + r5
            long r10 = java.lang.Math.max(r10, r1)
        L_0x0213:
            com.google.android.gms.measurement.internal.zzem r1 = r21.zzjg()
            r1.unregister()
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzx()
            long r1 = r1.currentTimeMillis()
            long r10 = r10 - r1
            int r1 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x024f
            com.google.android.gms.measurement.internal.zzdu<java.lang.Long> r1 = com.google.android.gms.measurement.internal.zzak.zzhb
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r10 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzeo r1 = r1.zzac()
            com.google.android.gms.measurement.internal.zzet r1 = r1.zzlj
            com.google.android.gms.measurement.internal.zzfj r2 = r0.zzj
            com.google.android.gms.common.util.Clock r2 = r2.zzx()
            long r2 = r2.currentTimeMillis()
            r1.set(r2)
        L_0x024f:
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.Long r2 = java.lang.Long.valueOf(r10)
            java.lang.String r3 = "Upload scheduled in approximately ms"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.zzjc r1 = r21.zzjh()
            r1.zzv(r10)
            return
        L_0x026a:
            com.google.android.gms.measurement.internal.zzfj r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzab()
            com.google.android.gms.measurement.internal.zzeh r1 = r1.zzgs()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zzao(r2)
            com.google.android.gms.measurement.internal.zzem r1 = r21.zzjg()
            r1.unregister()
            com.google.android.gms.measurement.internal.zzjc r1 = r21.zzjh()
            r1.cancel()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.zzjn():void");
    }

    /* access modifiers changed from: package-private */
    public final void zzf(Runnable runnable) {
        zzo();
        if (this.zzsz == null) {
            this.zzsz = new ArrayList();
        }
        this.zzsz.add(runnable);
    }

    private final void zzjo() {
        zzo();
        if (this.zztc || this.zztd || this.zzte) {
            this.zzj.zzab().zzgs().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zztc), Boolean.valueOf(this.zztd), Boolean.valueOf(this.zzte));
            return;
        }
        this.zzj.zzab().zzgs().zzao("Stopping uploading service(s)");
        List<Runnable> list = this.zzsz;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            this.zzsz.clear();
        }
    }

    private final Boolean zzc(zzf zzf) {
        try {
            if (zzf.zzam() != -2147483648L) {
                if (zzf.zzam() == ((long) Wrappers.packageManager(this.zzj.getContext()).getPackageInfo(zzf.zzag(), 0).versionCode)) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzj.getContext()).getPackageInfo(zzf.zzag(), 0).versionName;
                if (zzf.zzal() != null && zzf.zzal().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final boolean zzjp() {
        FileLock fileLock;
        zzo();
        if (!this.zzj.zzad().zza(zzak.zzjh) || (fileLock = this.zztf) == null || !fileLock.isValid()) {
            try {
                FileChannel channel = new RandomAccessFile(new File(this.zzj.getContext().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zztg = channel;
                FileLock tryLock = channel.tryLock();
                this.zztf = tryLock;
                if (tryLock != null) {
                    this.zzj.zzab().zzgs().zzao("Storage concurrent access okay");
                    return true;
                }
                this.zzj.zzab().zzgk().zzao("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                this.zzj.zzab().zzgk().zza("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                this.zzj.zzab().zzgk().zza("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                this.zzj.zzab().zzgn().zza("Storage lock already acquired", e3);
                return false;
            }
        } else {
            this.zzj.zzab().zzgs().zzao("Storage concurrent access okay");
            return true;
        }
    }

    private final int zza(FileChannel fileChannel) {
        zzo();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzab().zzgk().zzao("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.zzj.zzab().zzgn().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            this.zzj.zzab().zzgk().zza("Failed to read from channel", e);
            return 0;
        }
    }

    private final boolean zza(int i, FileChannel fileChannel) {
        zzo();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzab().zzgk().zzao("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzj.zzab().zzgk().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzj.zzab().zzgk().zza("Failed to write to channel", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzjq() {
        zzo();
        zzjj();
        if (!this.zzsx) {
            this.zzsx = true;
            zzo();
            zzjj();
            if ((this.zzj.zzad().zza(zzak.zzim) || zzjr()) && zzjp()) {
                int zza2 = zza(this.zztg);
                int zzgf = this.zzj.zzr().zzgf();
                zzo();
                if (zza2 > zzgf) {
                    this.zzj.zzab().zzgk().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzgf));
                } else if (zza2 < zzgf) {
                    if (zza(zzgf, this.zztg)) {
                        this.zzj.zzab().zzgs().zza("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzgf));
                    } else {
                        this.zzj.zzab().zzgk().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzgf));
                    }
                }
            }
        }
        if (!this.zzsw && !this.zzj.zzad().zza(zzak.zzim)) {
            this.zzj.zzab().zzgq().zzao("This instance being marked as an uploader");
            this.zzsw = true;
            zzjn();
        }
    }

    private final boolean zzjr() {
        zzo();
        zzjj();
        return this.zzsw;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(zzn zzn) {
        if (this.zzth != null) {
            ArrayList arrayList = new ArrayList();
            this.zzti = arrayList;
            arrayList.addAll(this.zzth);
        }
        zzx zzgy = zzgy();
        String str = zzn.packageName;
        Preconditions.checkNotEmpty(str);
        zzgy.zzo();
        zzgy.zzbi();
        try {
            SQLiteDatabase writableDatabase = zzgy.getWritableDatabase();
            String[] strArr = {str};
            int delete = writableDatabase.delete("apps", "app_id=?", strArr) + 0 + writableDatabase.delete("events", "app_id=?", strArr) + writableDatabase.delete("user_attributes", "app_id=?", strArr) + writableDatabase.delete("conditional_properties", "app_id=?", strArr) + writableDatabase.delete("raw_events", "app_id=?", strArr) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr) + writableDatabase.delete("queue", "app_id=?", strArr) + writableDatabase.delete("audience_filter_values", "app_id=?", strArr) + writableDatabase.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zzgy.zzab().zzgs().zza("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzgy.zzab().zzgk().zza("Error resetting analytics data. appId, error", zzef.zzam(str), e);
        }
        zzn zza2 = zza(this.zzj.getContext(), zzn.packageName, zzn.zzcg, zzn.zzcq, zzn.zzcs, zzn.zzct, zzn.zzdr, zzn.zzcu);
        if (zzn.zzcq) {
            zzf(zza2);
        }
    }

    private final zzn zza(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j, String str3) {
        String str4;
        String str5;
        int i;
        String str6 = str;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            this.zzj.zzab().zzgk().zzao("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str4 = packageManager.getInstallerPackageName(str6);
        } catch (IllegalArgumentException unused) {
            this.zzj.zzab().zzgk().zza("Error retrieving installer package name. appId", zzef.zzam(str));
            str4 = BinData.UNKNOWN;
        }
        if (str4 == null) {
            str4 = "manual_install";
        } else if ("com.android.vending".equals(str4)) {
            str4 = "";
        }
        String str7 = str4;
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str6, 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = Wrappers.packageManager(context).getApplicationLabel(str6);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    String charSequence = applicationLabel.toString();
                }
                String str8 = packageInfo.versionName;
                i = packageInfo.versionCode;
                str5 = str8;
            } else {
                i = Integer.MIN_VALUE;
                str5 = BinData.UNKNOWN;
            }
            this.zzj.zzae();
            return new zzn(str, str2, str5, (long) i, str7, this.zzj.zzad().zzao(), this.zzj.zzz().zzc(context, str6), (String) null, z, false, "", 0, this.zzj.zzad().zzr(str6) ? j : 0, 0, z2, z3, false, str3, (Boolean) null, 0, (List<String>) null);
        } catch (PackageManager.NameNotFoundException unused2) {
            this.zzj.zzab().zzgk().zza("Error retrieving newly installed package info. appId, appName", zzef.zzam(str), BinData.UNKNOWN);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzjn zzjn, zzn zzn) {
        zzae zzc;
        zzo();
        zzjj();
        if (TextUtils.isEmpty(zzn.zzcg) && TextUtils.isEmpty(zzn.zzcu)) {
            return;
        }
        if (!zzn.zzcq) {
            zzg(zzn);
            return;
        }
        int zzbm = this.zzj.zzz().zzbm(zzjn.name);
        if (zzbm != 0) {
            this.zzj.zzz();
            this.zzj.zzz().zza(zzn.packageName, zzbm, "_ev", zzjs.zza(zzjn.name, 24, true), zzjn.name != null ? zzjn.name.length() : 0);
            return;
        }
        int zzc2 = this.zzj.zzz().zzc(zzjn.name, zzjn.getValue());
        if (zzc2 != 0) {
            this.zzj.zzz();
            String zza2 = zzjs.zza(zzjn.name, 24, true);
            Object value = zzjn.getValue();
            this.zzj.zzz().zza(zzn.packageName, zzc2, "_ev", zza2, (value == null || (!(value instanceof String) && !(value instanceof CharSequence))) ? 0 : String.valueOf(value).length());
            return;
        }
        Object zzd = this.zzj.zzz().zzd(zzjn.name, zzjn.getValue());
        if (zzd != null) {
            if ("_sid".equals(zzjn.name) && this.zzj.zzad().zzw(zzn.packageName)) {
                long j = zzjn.zztr;
                String str = zzjn.origin;
                long j2 = 0;
                zzjp zze = zzgy().zze(zzn.packageName, "_sno");
                if (zze == null || !(zze.value instanceof Long)) {
                    if (zze != null) {
                        this.zzj.zzab().zzgn().zza("Retrieved last session number from database does not contain a valid (long) value", zze.value);
                    }
                    if (this.zzj.zzad().zze(zzn.packageName, zzak.zzie) && (zzc = zzgy().zzc(zzn.packageName, "_s")) != null) {
                        j2 = zzc.zzfg;
                        this.zzj.zzab().zzgs().zza("Backfill the session number. Last used session number", Long.valueOf(j2));
                    }
                } else {
                    j2 = ((Long) zze.value).longValue();
                }
                zzb(new zzjn("_sno", j, Long.valueOf(j2 + 1), str), zzn);
            }
            zzjp zzjp = new zzjp(zzn.packageName, zzjn.origin, zzjn.name, zzjn.zztr, zzd);
            this.zzj.zzab().zzgr().zza("Setting user property", this.zzj.zzy().zzal(zzjp.name), zzd);
            zzgy().beginTransaction();
            try {
                zzg(zzn);
                boolean zza3 = zzgy().zza(zzjp);
                zzgy().setTransactionSuccessful();
                if (zza3) {
                    this.zzj.zzab().zzgr().zza("User property set", this.zzj.zzy().zzal(zzjp.name), zzjp.value);
                } else {
                    this.zzj.zzab().zzgk().zza("Too many unique user properties are set. Ignoring user property", this.zzj.zzy().zzal(zzjp.name), zzjp.value);
                    this.zzj.zzz().zza(zzn.packageName, 9, (String) null, (String) null, 0);
                }
            } finally {
                zzgy().endTransaction();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzjn zzjn, zzn zzn) {
        zzo();
        zzjj();
        if (TextUtils.isEmpty(zzn.zzcg) && TextUtils.isEmpty(zzn.zzcu)) {
            return;
        }
        if (!zzn.zzcq) {
            zzg(zzn);
        } else if (!this.zzj.zzad().zze(zzn.packageName, zzak.zzij)) {
            this.zzj.zzab().zzgr().zza("Removing user property", this.zzj.zzy().zzal(zzjn.name));
            zzgy().beginTransaction();
            try {
                zzg(zzn);
                zzgy().zzd(zzn.packageName, zzjn.name);
                zzgy().setTransactionSuccessful();
                this.zzj.zzab().zzgr().zza("User property removed", this.zzj.zzy().zzal(zzjn.name));
            } finally {
                zzgy().endTransaction();
            }
        } else if (!"_npa".equals(zzjn.name) || zzn.zzcv == null) {
            this.zzj.zzab().zzgr().zza("Removing user property", this.zzj.zzy().zzal(zzjn.name));
            zzgy().beginTransaction();
            try {
                zzg(zzn);
                zzgy().zzd(zzn.packageName, zzjn.name);
                zzgy().setTransactionSuccessful();
                this.zzj.zzab().zzgr().zza("User property removed", this.zzj.zzy().zzal(zzjn.name));
            } finally {
                zzgy().endTransaction();
            }
        } else {
            this.zzj.zzab().zzgr().zzao("Falling back to manifest metadata value for ad personalization");
            zzb(new zzjn("_npa", this.zzj.zzx().currentTimeMillis(), Long.valueOf(zzn.zzcv.booleanValue() ? 1 : 0), "auto"), zzn);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzjh zzjh) {
        this.zzta++;
    }

    /* access modifiers changed from: package-private */
    public final void zzjs() {
        this.zztb++;
    }

    /* access modifiers changed from: package-private */
    public final zzfj zzjt() {
        return this.zzj;
    }

    /* access modifiers changed from: package-private */
    public final void zzf(zzn zzn) {
        String str;
        int i;
        zzf zzab;
        zzae zzae;
        String str2;
        long j;
        long j2;
        PackageInfo packageInfo;
        String str3;
        ApplicationInfo applicationInfo;
        boolean z;
        zzx zzgy;
        String zzag;
        zzjp zze;
        zzn zzn2 = zzn;
        zzo();
        zzjj();
        Preconditions.checkNotNull(zzn);
        Preconditions.checkNotEmpty(zzn2.packageName);
        if (!TextUtils.isEmpty(zzn2.zzcg) || !TextUtils.isEmpty(zzn2.zzcu)) {
            zzf zzab2 = zzgy().zzab(zzn2.packageName);
            if (zzab2 != null && TextUtils.isEmpty(zzab2.getGmpAppId()) && !TextUtils.isEmpty(zzn2.zzcg)) {
                zzab2.zzl(0);
                zzgy().zza(zzab2);
                zzgz().zzaz(zzn2.packageName);
            }
            if (!zzn2.zzcq) {
                zzg(zzn);
                return;
            }
            long j3 = zzn2.zzdr;
            if (j3 == 0) {
                j3 = this.zzj.zzx().currentTimeMillis();
            }
            if (this.zzj.zzad().zze(zzn2.packageName, zzak.zzij)) {
                this.zzj.zzw().zzct();
            }
            int i2 = zzn2.zzds;
            if (!(i2 == 0 || i2 == 1)) {
                this.zzj.zzab().zzgn().zza("Incorrect app type, assuming installed app. appId, appType", zzef.zzam(zzn2.packageName), Integer.valueOf(i2));
                i2 = 0;
            }
            zzgy().beginTransaction();
            try {
                if (!this.zzj.zzad().zze(zzn2.packageName, zzak.zzij) || ((zze = zzgy().zze(zzn2.packageName, "_npa")) != null && !"auto".equals(zze.origin))) {
                    str = "_sysu";
                    i = 1;
                } else if (zzn2.zzcv != null) {
                    zzjn zzjn = r12;
                    str = "_sysu";
                    zzjp zzjp = zze;
                    i = 1;
                    zzjn zzjn2 = new zzjn("_npa", j3, Long.valueOf(zzn2.zzcv.booleanValue() ? 1 : 0), "auto");
                    if (zzjp == null || !zzjp.value.equals(zzjn.zzts)) {
                        zzb(zzjn, zzn2);
                    }
                } else {
                    str = "_sysu";
                    i = 1;
                    if (zze != null) {
                        zzc(new zzjn("_npa", j3, (Object) null, "auto"), zzn2);
                    }
                }
                zzab = zzgy().zzab(zzn2.packageName);
                if (zzab != null) {
                    this.zzj.zzz();
                    if (zzjs.zza(zzn2.zzcg, zzab.getGmpAppId(), zzn2.zzcu, zzab.zzah())) {
                        this.zzj.zzab().zzgn().zza("New GMP App Id passed in. Removing cached database data. appId", zzef.zzam(zzab.zzag()));
                        zzgy = zzgy();
                        zzag = zzab.zzag();
                        zzgy.zzbi();
                        zzgy.zzo();
                        Preconditions.checkNotEmpty(zzag);
                        SQLiteDatabase writableDatabase = zzgy.getWritableDatabase();
                        String[] strArr = new String[i];
                        strArr[0] = zzag;
                        int delete = writableDatabase.delete("events", "app_id=?", strArr) + 0 + writableDatabase.delete("user_attributes", "app_id=?", strArr) + writableDatabase.delete("conditional_properties", "app_id=?", strArr) + writableDatabase.delete("apps", "app_id=?", strArr) + writableDatabase.delete("raw_events", "app_id=?", strArr) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr) + writableDatabase.delete("event_filters", "app_id=?", strArr) + writableDatabase.delete("property_filters", "app_id=?", strArr) + writableDatabase.delete("audience_filter_values", "app_id=?", strArr);
                        if (delete > 0) {
                            zzgy.zzab().zzgs().zza("Deleted application data. app, records", zzag, Integer.valueOf(delete));
                        }
                        zzab = null;
                    }
                }
            } catch (SQLiteException e) {
                zzgy.zzab().zzgk().zza("Error deleting application data. appId, error", zzef.zzam(zzag), e);
            } catch (Throwable th) {
                zzgy().endTransaction();
                throw th;
            }
            if (zzab != null) {
                if (zzab.zzam() != -2147483648L) {
                    if (zzab.zzam() != zzn2.zzcn) {
                        Bundle bundle = new Bundle();
                        bundle.putString("_pv", zzab.zzal());
                        zzc(new zzai("_au", new zzah(bundle), "auto", j3), zzn2);
                    }
                } else if (zzab.zzal() != null && !zzab.zzal().equals(zzn2.zzcm)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("_pv", zzab.zzal());
                    zzc(new zzai("_au", new zzah(bundle2), "auto", j3), zzn2);
                }
            }
            zzg(zzn);
            if (i2 == 0) {
                zzae = zzgy().zzc(zzn2.packageName, "_f");
            } else {
                zzae = i2 == i ? zzgy().zzc(zzn2.packageName, "_v") : null;
            }
            if (zzae == null) {
                long j4 = ((j3 / DateUtils.MILLIS_PER_HOUR) + 1) * DateUtils.MILLIS_PER_HOUR;
                if (i2 == 0) {
                    str2 = "_et";
                    zzb(new zzjn("_fot", j3, Long.valueOf(j4), "auto"), zzn2);
                    if (this.zzj.zzad().zzt(zzn2.zzcg)) {
                        zzo();
                        this.zzj.zzht().zzat(zzn2.packageName);
                    }
                    zzo();
                    zzjj();
                    Bundle bundle3 = new Bundle();
                    bundle3.putLong("_c", 1);
                    bundle3.putLong("_r", 1);
                    bundle3.putLong("_uwa", 0);
                    bundle3.putLong("_pfo", 0);
                    bundle3.putLong("_sys", 0);
                    String str4 = str;
                    bundle3.putLong(str4, 0);
                    if (this.zzj.zzad().zzz(zzn2.packageName)) {
                        j2 = 1;
                        bundle3.putLong(str2, 1);
                    } else {
                        j2 = 1;
                    }
                    if (zzn2.zzdt) {
                        bundle3.putLong("_dac", j2);
                    }
                    if (this.zzj.getContext().getPackageManager() == null) {
                        this.zzj.zzab().zzgk().zza("PackageManager is null, first open report might be inaccurate. appId", zzef.zzam(zzn2.packageName));
                    } else {
                        try {
                            packageInfo = Wrappers.packageManager(this.zzj.getContext()).getPackageInfo(zzn2.packageName, 0);
                        } catch (PackageManager.NameNotFoundException e2) {
                            this.zzj.zzab().zzgk().zza("Package info is null, first open report might be inaccurate. appId", zzef.zzam(zzn2.packageName), e2);
                            packageInfo = null;
                        }
                        if (packageInfo == null || packageInfo.firstInstallTime == 0) {
                            str3 = str4;
                        } else {
                            if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                bundle3.putLong("_uwa", 1);
                                z = false;
                            } else {
                                z = true;
                            }
                            str3 = str4;
                            zzb(new zzjn("_fi", j3, Long.valueOf(z ? 1 : 0), "auto"), zzn2);
                        }
                        try {
                            applicationInfo = Wrappers.packageManager(this.zzj.getContext()).getApplicationInfo(zzn2.packageName, 0);
                        } catch (PackageManager.NameNotFoundException e3) {
                            this.zzj.zzab().zzgk().zza("Application info is null, first open report might be inaccurate. appId", zzef.zzam(zzn2.packageName), e3);
                            applicationInfo = null;
                        }
                        if (applicationInfo != null) {
                            if ((applicationInfo.flags & 1) != 0) {
                                bundle3.putLong("_sys", 1);
                            }
                            if ((applicationInfo.flags & 128) != 0) {
                                bundle3.putLong(str3, 1);
                            }
                        }
                    }
                    zzx zzgy2 = zzgy();
                    String str5 = zzn2.packageName;
                    Preconditions.checkNotEmpty(str5);
                    zzgy2.zzo();
                    zzgy2.zzbi();
                    long zzj2 = zzgy2.zzj(str5, "first_open_count");
                    if (zzj2 >= 0) {
                        bundle3.putLong("_pfo", zzj2);
                    }
                    zzc(new zzai("_f", new zzah(bundle3), "auto", j3), zzn2);
                } else {
                    str2 = "_et";
                    if (i2 == 1) {
                        zzb(new zzjn("_fvt", j3, Long.valueOf(j4), "auto"), zzn2);
                        zzo();
                        zzjj();
                        Bundle bundle4 = new Bundle();
                        bundle4.putLong("_c", 1);
                        bundle4.putLong("_r", 1);
                        if (this.zzj.zzad().zzz(zzn2.packageName)) {
                            j = 1;
                            bundle4.putLong(str2, 1);
                        } else {
                            j = 1;
                        }
                        if (zzn2.zzdt) {
                            bundle4.putLong("_dac", j);
                        }
                        zzc(new zzai("_v", new zzah(bundle4), "auto", j3), zzn2);
                    }
                }
                if (!this.zzj.zzad().zze(zzn2.packageName, zzak.zzii)) {
                    Bundle bundle5 = new Bundle();
                    bundle5.putLong(str2, 1);
                    if (this.zzj.zzad().zzz(zzn2.packageName)) {
                        bundle5.putLong("_fr", 1);
                    }
                    zzc(new zzai("_e", new zzah(bundle5), "auto", j3), zzn2);
                }
            } else if (zzn2.zzdq) {
                zzc(new zzai("_cd", new zzah(new Bundle()), "auto", j3), zzn2);
            }
            zzgy().setTransactionSuccessful();
            zzgy().endTransaction();
        }
    }

    private final zzn zzbi(String str) {
        String str2 = str;
        zzf zzab = zzgy().zzab(str2);
        if (zzab == null || TextUtils.isEmpty(zzab.zzal())) {
            this.zzj.zzab().zzgr().zza("No app data available; dropping", str2);
            return null;
        }
        Boolean zzc = zzc(zzab);
        if (zzc == null || zzc.booleanValue()) {
            zzf zzf = zzab;
            return new zzn(str, zzab.getGmpAppId(), zzab.zzal(), zzab.zzam(), zzab.zzan(), zzab.zzao(), zzab.zzap(), (String) null, zzab.isMeasurementEnabled(), false, zzab.getFirebaseInstanceId(), zzf.zzbd(), 0, 0, zzf.zzbe(), zzf.zzbf(), false, zzf.zzah(), zzf.zzbg(), zzf.zzaq(), zzf.zzbh());
        }
        this.zzj.zzab().zzgk().zza("App version does not match; dropping. appId", zzef.zzam(str));
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void zze(zzq zzq) {
        zzn zzbi = zzbi(zzq.packageName);
        if (zzbi != null) {
            zzb(zzq, zzbi);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzq zzq, zzn zzn) {
        Preconditions.checkNotNull(zzq);
        Preconditions.checkNotEmpty(zzq.packageName);
        Preconditions.checkNotNull(zzq.origin);
        Preconditions.checkNotNull(zzq.zzdw);
        Preconditions.checkNotEmpty(zzq.zzdw.name);
        zzo();
        zzjj();
        if (TextUtils.isEmpty(zzn.zzcg) && TextUtils.isEmpty(zzn.zzcu)) {
            return;
        }
        if (!zzn.zzcq) {
            zzg(zzn);
            return;
        }
        zzq zzq2 = new zzq(zzq);
        boolean z = false;
        zzq2.active = false;
        zzgy().beginTransaction();
        try {
            zzq zzf = zzgy().zzf(zzq2.packageName, zzq2.zzdw.name);
            if (zzf != null && !zzf.origin.equals(zzq2.origin)) {
                this.zzj.zzab().zzgn().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzj.zzy().zzal(zzq2.zzdw.name), zzq2.origin, zzf.origin);
            }
            if (zzf != null && zzf.active) {
                zzq2.origin = zzf.origin;
                zzq2.creationTimestamp = zzf.creationTimestamp;
                zzq2.triggerTimeout = zzf.triggerTimeout;
                zzq2.triggerEventName = zzf.triggerEventName;
                zzq2.zzdy = zzf.zzdy;
                zzq2.active = zzf.active;
                zzq2.zzdw = new zzjn(zzq2.zzdw.name, zzf.zzdw.zztr, zzq2.zzdw.getValue(), zzf.zzdw.origin);
            } else if (TextUtils.isEmpty(zzq2.triggerEventName)) {
                zzq2.zzdw = new zzjn(zzq2.zzdw.name, zzq2.creationTimestamp, zzq2.zzdw.getValue(), zzq2.zzdw.origin);
                zzq2.active = true;
                z = true;
            }
            if (zzq2.active) {
                zzjn zzjn = zzq2.zzdw;
                zzjp zzjp = new zzjp(zzq2.packageName, zzq2.origin, zzjn.name, zzjn.zztr, zzjn.getValue());
                if (zzgy().zza(zzjp)) {
                    this.zzj.zzab().zzgr().zza("User property updated immediately", zzq2.packageName, this.zzj.zzy().zzal(zzjp.name), zzjp.value);
                } else {
                    this.zzj.zzab().zzgk().zza("(2)Too many active user properties, ignoring", zzef.zzam(zzq2.packageName), this.zzj.zzy().zzal(zzjp.name), zzjp.value);
                }
                if (z && zzq2.zzdy != null) {
                    zzd(new zzai(zzq2.zzdy, zzq2.creationTimestamp), zzn);
                }
            }
            if (zzgy().zza(zzq2)) {
                this.zzj.zzab().zzgr().zza("Conditional property added", zzq2.packageName, this.zzj.zzy().zzal(zzq2.zzdw.name), zzq2.zzdw.getValue());
            } else {
                this.zzj.zzab().zzgk().zza("Too many conditional properties, ignoring", zzef.zzam(zzq2.packageName), this.zzj.zzy().zzal(zzq2.zzdw.name), zzq2.zzdw.getValue());
            }
            zzgy().setTransactionSuccessful();
        } finally {
            zzgy().endTransaction();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzf(zzq zzq) {
        zzn zzbi = zzbi(zzq.packageName);
        if (zzbi != null) {
            zzc(zzq, zzbi);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzq zzq, zzn zzn) {
        Preconditions.checkNotNull(zzq);
        Preconditions.checkNotEmpty(zzq.packageName);
        Preconditions.checkNotNull(zzq.zzdw);
        Preconditions.checkNotEmpty(zzq.zzdw.name);
        zzo();
        zzjj();
        if (TextUtils.isEmpty(zzn.zzcg) && TextUtils.isEmpty(zzn.zzcu)) {
            return;
        }
        if (!zzn.zzcq) {
            zzg(zzn);
            return;
        }
        zzgy().beginTransaction();
        try {
            zzg(zzn);
            zzq zzf = zzgy().zzf(zzq.packageName, zzq.zzdw.name);
            if (zzf != null) {
                this.zzj.zzab().zzgr().zza("Removing conditional user property", zzq.packageName, this.zzj.zzy().zzal(zzq.zzdw.name));
                zzgy().zzg(zzq.packageName, zzq.zzdw.name);
                if (zzf.active) {
                    zzgy().zzd(zzq.packageName, zzq.zzdw.name);
                }
                if (zzq.zzdz != null) {
                    Bundle bundle = null;
                    if (zzq.zzdz.zzfq != null) {
                        bundle = zzq.zzdz.zzfq.zzcv();
                    }
                    Bundle bundle2 = bundle;
                    zzd(this.zzj.zzz().zza(zzq.packageName, zzq.zzdz.name, bundle2, zzf.origin, zzq.zzdz.zzfu, true, false), zzn);
                }
            } else {
                this.zzj.zzab().zzgn().zza("Conditional user property doesn't exist", zzef.zzam(zzq.packageName), this.zzj.zzy().zzal(zzq.zzdw.name));
            }
            zzgy().setTransactionSuccessful();
        } finally {
            zzgy().endTransaction();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x018f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzf zzg(com.google.android.gms.measurement.internal.zzn r11) {
        /*
            r10 = this;
            r10.zzo()
            r10.zzjj()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)
            java.lang.String r0 = r11.packageName
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r0)
            com.google.android.gms.measurement.internal.zzx r0 = r10.zzgy()
            java.lang.String r1 = r11.packageName
            com.google.android.gms.measurement.internal.zzf r0 = r0.zzab(r1)
            com.google.android.gms.measurement.internal.zzfj r1 = r10.zzj
            com.google.android.gms.measurement.internal.zzeo r1 = r1.zzac()
            java.lang.String r2 = r11.packageName
            java.lang.String r1 = r1.zzaq(r2)
            r2 = 1
            if (r0 != 0) goto L_0x0042
            com.google.android.gms.measurement.internal.zzf r0 = new com.google.android.gms.measurement.internal.zzf
            com.google.android.gms.measurement.internal.zzfj r3 = r10.zzj
            java.lang.String r4 = r11.packageName
            r0.<init>(r3, r4)
            com.google.android.gms.measurement.internal.zzfj r3 = r10.zzj
            com.google.android.gms.measurement.internal.zzjs r3 = r3.zzz()
            java.lang.String r3 = r3.zzjy()
            r0.zza((java.lang.String) r3)
            r0.zzd(r1)
        L_0x0040:
            r1 = 1
            goto L_0x005e
        L_0x0042:
            java.lang.String r3 = r0.zzai()
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x005d
            r0.zzd(r1)
            com.google.android.gms.measurement.internal.zzfj r1 = r10.zzj
            com.google.android.gms.measurement.internal.zzjs r1 = r1.zzz()
            java.lang.String r1 = r1.zzjy()
            r0.zza((java.lang.String) r1)
            goto L_0x0040
        L_0x005d:
            r1 = 0
        L_0x005e:
            java.lang.String r3 = r11.zzcg
            java.lang.String r4 = r0.getGmpAppId()
            boolean r3 = android.text.TextUtils.equals(r3, r4)
            if (r3 != 0) goto L_0x0070
            java.lang.String r1 = r11.zzcg
            r0.zzb((java.lang.String) r1)
            r1 = 1
        L_0x0070:
            java.lang.String r3 = r11.zzcu
            java.lang.String r4 = r0.zzah()
            boolean r3 = android.text.TextUtils.equals(r3, r4)
            if (r3 != 0) goto L_0x0082
            java.lang.String r1 = r11.zzcu
            r0.zzc((java.lang.String) r1)
            r1 = 1
        L_0x0082:
            java.lang.String r3 = r11.zzci
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x009c
            java.lang.String r3 = r11.zzci
            java.lang.String r4 = r0.getFirebaseInstanceId()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x009c
            java.lang.String r1 = r11.zzci
            r0.zze((java.lang.String) r1)
            r1 = 1
        L_0x009c:
            long r3 = r11.zzr
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x00b4
            long r3 = r11.zzr
            long r7 = r0.zzao()
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x00b4
            long r3 = r11.zzr
            r0.zzh((long) r3)
            r1 = 1
        L_0x00b4:
            java.lang.String r3 = r11.zzcm
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x00ce
            java.lang.String r3 = r11.zzcm
            java.lang.String r4 = r0.zzal()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00ce
            java.lang.String r1 = r11.zzcm
            r0.zzf((java.lang.String) r1)
            r1 = 1
        L_0x00ce:
            long r3 = r11.zzcn
            long r7 = r0.zzam()
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x00de
            long r3 = r11.zzcn
            r0.zzg((long) r3)
            r1 = 1
        L_0x00de:
            java.lang.String r3 = r11.zzco
            if (r3 == 0) goto L_0x00f4
            java.lang.String r3 = r11.zzco
            java.lang.String r4 = r0.zzan()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00f4
            java.lang.String r1 = r11.zzco
            r0.zzg((java.lang.String) r1)
            r1 = 1
        L_0x00f4:
            long r3 = r11.zzcp
            long r7 = r0.zzap()
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x0104
            long r3 = r11.zzcp
            r0.zzi(r3)
            r1 = 1
        L_0x0104:
            boolean r3 = r11.zzcq
            boolean r4 = r0.isMeasurementEnabled()
            if (r3 == r4) goto L_0x0112
            boolean r1 = r11.zzcq
            r0.setMeasurementEnabled(r1)
            r1 = 1
        L_0x0112:
            java.lang.String r3 = r11.zzdp
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x012c
            java.lang.String r3 = r11.zzdp
            java.lang.String r4 = r0.zzbb()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x012c
            java.lang.String r1 = r11.zzdp
            r0.zzh((java.lang.String) r1)
            r1 = 1
        L_0x012c:
            long r3 = r11.zzcr
            long r7 = r0.zzbd()
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x013c
            long r3 = r11.zzcr
            r0.zzt(r3)
            r1 = 1
        L_0x013c:
            boolean r3 = r11.zzcs
            boolean r4 = r0.zzbe()
            if (r3 == r4) goto L_0x014a
            boolean r1 = r11.zzcs
            r0.zzb((boolean) r1)
            r1 = 1
        L_0x014a:
            boolean r3 = r11.zzct
            boolean r4 = r0.zzbf()
            if (r3 == r4) goto L_0x0158
            boolean r1 = r11.zzct
            r0.zzc((boolean) r1)
            r1 = 1
        L_0x0158:
            com.google.android.gms.measurement.internal.zzfj r3 = r10.zzj
            com.google.android.gms.measurement.internal.zzs r3 = r3.zzad()
            java.lang.String r4 = r11.packageName
            com.google.android.gms.measurement.internal.zzdu<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzak.zzij
            boolean r3 = r3.zze(r4, r7)
            if (r3 == 0) goto L_0x0176
            java.lang.Boolean r3 = r11.zzcv
            java.lang.Boolean r4 = r0.zzbg()
            if (r3 == r4) goto L_0x0176
            java.lang.Boolean r1 = r11.zzcv
            r0.zza((java.lang.Boolean) r1)
            r1 = 1
        L_0x0176:
            long r3 = r11.zzs
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x018c
            long r3 = r11.zzs
            long r5 = r0.zzaq()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x018c
            long r3 = r11.zzs
            r0.zzj(r3)
            goto L_0x018d
        L_0x018c:
            r2 = r1
        L_0x018d:
            if (r2 == 0) goto L_0x0196
            com.google.android.gms.measurement.internal.zzx r11 = r10.zzgy()
            r11.zza((com.google.android.gms.measurement.internal.zzf) r0)
        L_0x0196:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.zzg(com.google.android.gms.measurement.internal.zzn):com.google.android.gms.measurement.internal.zzf");
    }

    /* access modifiers changed from: package-private */
    public final String zzh(zzn zzn) {
        try {
            return (String) this.zzj.zzaa().zza(new zzjk(this, zzn)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzj.zzab().zzgk().zza("Failed to get app instance id. appId", zzef.zzam(zzn.packageName), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzj(boolean z) {
        zzjn();
    }
}
