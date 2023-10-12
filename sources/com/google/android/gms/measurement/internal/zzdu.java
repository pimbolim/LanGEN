package com.google.android.gms.measurement.internal;

public final class zzdu<V> {
    private static final Object zzjo = new Object();
    private final String zzjj;
    private final zzdv<V> zzjk;
    private final V zzjl;
    private final V zzjm;
    private final Object zzjn;
    private volatile V zzjp;
    private volatile V zzjq;

    private zzdu(String str, V v, V v2, zzdv<V> zzdv) {
        this.zzjn = new Object();
        this.zzjp = null;
        this.zzjq = null;
        this.zzjj = str;
        this.zzjl = v;
        this.zzjm = v2;
        this.zzjk = zzdv;
    }

    public final String getKey() {
        return this.zzjj;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: CFG modification limit reached, blocks count: 173 */
    public final V get(V r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.zzjn
            monitor-enter(r0)
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            if (r5 == 0) goto L_0x0007
            return r5
        L_0x0007:
            com.google.android.gms.measurement.internal.zzr r5 = com.google.android.gms.measurement.internal.zzak.zzfv
            if (r5 != 0) goto L_0x000e
            V r5 = r4.zzjl
            return r5
        L_0x000e:
            com.google.android.gms.measurement.internal.zzr r5 = com.google.android.gms.measurement.internal.zzak.zzfv
            java.lang.Object r5 = zzjo
            monitor-enter(r5)
            boolean r0 = com.google.android.gms.measurement.internal.zzr.isMainThread()     // Catch:{ all -> 0x0086 }
            if (r0 == 0) goto L_0x0024
            V r0 = r4.zzjq     // Catch:{ all -> 0x0086 }
            if (r0 != 0) goto L_0x0020
            V r0 = r4.zzjl     // Catch:{ all -> 0x0086 }
            goto L_0x0022
        L_0x0020:
            V r0 = r4.zzjq     // Catch:{ all -> 0x0086 }
        L_0x0022:
            monitor-exit(r5)     // Catch:{ all -> 0x0086 }
            return r0
        L_0x0024:
            boolean r0 = com.google.android.gms.measurement.internal.zzr.isMainThread()     // Catch:{ all -> 0x0086 }
            if (r0 != 0) goto L_0x007e
            com.google.android.gms.measurement.internal.zzr r0 = com.google.android.gms.measurement.internal.zzak.zzfv     // Catch:{ all -> 0x0086 }
            java.util.List r0 = com.google.android.gms.measurement.internal.zzak.zzfw     // Catch:{ SecurityException -> 0x0062 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ SecurityException -> 0x0062 }
        L_0x0034:
            boolean r1 = r0.hasNext()     // Catch:{ SecurityException -> 0x0062 }
            if (r1 == 0) goto L_0x0066
            java.lang.Object r1 = r0.next()     // Catch:{ SecurityException -> 0x0062 }
            com.google.android.gms.measurement.internal.zzdu r1 = (com.google.android.gms.measurement.internal.zzdu) r1     // Catch:{ SecurityException -> 0x0062 }
            java.lang.Object r2 = zzjo     // Catch:{ SecurityException -> 0x0062 }
            monitor-enter(r2)     // Catch:{ SecurityException -> 0x0062 }
            boolean r3 = com.google.android.gms.measurement.internal.zzr.isMainThread()     // Catch:{ all -> 0x005f }
            if (r3 != 0) goto L_0x0057
            com.google.android.gms.measurement.internal.zzdv<V> r3 = r1.zzjk     // Catch:{ all -> 0x005f }
            if (r3 == 0) goto L_0x0052
            java.lang.Object r3 = r3.get()     // Catch:{ all -> 0x005f }
            goto L_0x0053
        L_0x0052:
            r3 = 0
        L_0x0053:
            r1.zzjq = r3     // Catch:{ all -> 0x005f }
            monitor-exit(r2)     // Catch:{ all -> 0x005f }
            goto L_0x0034
        L_0x0057:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x005f }
            java.lang.String r1 = "Refreshing flag cache must be done on a worker thread."
            r0.<init>(r1)     // Catch:{ all -> 0x005f }
            throw r0     // Catch:{ all -> 0x005f }
        L_0x005f:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x005f }
            throw r0     // Catch:{ SecurityException -> 0x0062 }
        L_0x0062:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzak.zza((java.lang.Exception) r0)     // Catch:{ all -> 0x0086 }
        L_0x0066:
            monitor-exit(r5)     // Catch:{ all -> 0x0086 }
            com.google.android.gms.measurement.internal.zzdv<V> r5 = r4.zzjk
            if (r5 != 0) goto L_0x0070
            com.google.android.gms.measurement.internal.zzr r5 = com.google.android.gms.measurement.internal.zzak.zzfv
            V r5 = r4.zzjl
            return r5
        L_0x0070:
            java.lang.Object r5 = r5.get()     // Catch:{ SecurityException -> 0x0075 }
            return r5
        L_0x0075:
            r5 = move-exception
            com.google.android.gms.measurement.internal.zzak.zza((java.lang.Exception) r5)
            com.google.android.gms.measurement.internal.zzr r5 = com.google.android.gms.measurement.internal.zzak.zzfv
            V r5 = r4.zzjl
            return r5
        L_0x007e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0086 }
            java.lang.String r1 = "Tried to refresh flag cache on main thread or on package side."
            r0.<init>(r1)     // Catch:{ all -> 0x0086 }
            throw r0     // Catch:{ all -> 0x0086 }
        L_0x0086:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0086 }
            throw r0
        L_0x0089:
            monitor-exit(r0)     // Catch:{ all -> 0x008b }
            throw r5
        L_0x008b:
            r5 = move-exception
            goto L_0x0089
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzdu.get(java.lang.Object):java.lang.Object");
    }
}
