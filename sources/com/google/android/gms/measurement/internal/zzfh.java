package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

final class zzfh<V> extends FutureTask<V> implements Comparable<zzfh> {
    private final String zzns;
    private final /* synthetic */ zzfc zznt;
    private final long zznw;
    final boolean zznx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfh(zzfc zzfc, Callable<V> callable, boolean z, String str) {
        super(callable);
        this.zznt = zzfc;
        Preconditions.checkNotNull(str);
        long andIncrement = zzfc.zznj.getAndIncrement();
        this.zznw = andIncrement;
        this.zzns = str;
        this.zznx = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzfc.zzab().zzgk().zzao("Tasks index overflow");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfh(zzfc zzfc, Runnable runnable, boolean z, String str) {
        super(runnable, (Object) null);
        this.zznt = zzfc;
        Preconditions.checkNotNull(str);
        long andIncrement = zzfc.zznj.getAndIncrement();
        this.zznw = andIncrement;
        this.zzns = str;
        this.zznx = false;
        if (andIncrement == Long.MAX_VALUE) {
            zzfc.zzab().zzgk().zzao("Tasks index overflow");
        }
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th) {
        this.zznt.zzab().zzgk().zza(this.zzns, th);
        if (th instanceof zzff) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        zzfh zzfh = (zzfh) obj;
        boolean z = this.zznx;
        if (z != zzfh.zznx) {
            return z ? -1 : 1;
        }
        long j = this.zznw;
        long j2 = zzfh.zznw;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.zznt.zzab().zzgl().zza("Two tasks share the same index. index", Long.valueOf(this.zznw));
        return 0;
    }
}
