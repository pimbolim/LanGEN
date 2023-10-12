package com.google.android.gms.wallet;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.google.android.gms.internal.wallet.zzh;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-wallet@@19.1.0 */
final class zzc implements OnCompleteListener, Runnable {
    static final Handler zza = new zzh(Looper.getMainLooper());
    static final SparseArray zzb = new SparseArray(2);
    private static final AtomicInteger zzd = new AtomicInteger();
    int zzc;
    private zzd zze;
    private Task zzf;

    zzc() {
    }

    public static zzc zza(Task task) {
        zzc zzc2 = new zzc();
        int incrementAndGet = zzd.incrementAndGet();
        zzc2.zzc = incrementAndGet;
        zzb.put(incrementAndGet, zzc2);
        zza.postDelayed(zzc2, AutoResolveHelper.zzb);
        task.addOnCompleteListener(zzc2);
        return zzc2;
    }

    private final void zzd() {
        if (this.zzf != null && this.zze != null) {
            zzb.delete(this.zzc);
            zza.removeCallbacks(this);
            zzd zzd2 = this.zze;
            if (zzd2 != null) {
                zzd2.zzb(this.zzf);
            }
        }
    }

    public final void onComplete(Task task) {
        this.zzf = task;
        zzd();
    }

    public final void run() {
        zzb.delete(this.zzc);
    }

    public final void zzb(zzd zzd2) {
        if (this.zze == zzd2) {
            this.zze = null;
        }
    }

    public final void zzc(zzd zzd2) {
        this.zze = zzd2;
        zzd();
    }
}
