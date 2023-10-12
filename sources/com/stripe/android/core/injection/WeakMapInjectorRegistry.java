package com.stripe.android.core.injection;

import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0017J\u001a\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\n2\b\b\u0001\u0010\u0015\u001a\u00020\u000bH\u0016J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\b\u0001\u0010\u0017\u001a\u00020\u000bH\u0016R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R(\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/core/injection/WeakMapInjectorRegistry;", "Lcom/stripe/android/core/injection/InjectorRegistry;", "()V", "CURRENT_REGISTER_KEY", "Ljava/util/concurrent/atomic/AtomicInteger;", "getCURRENT_REGISTER_KEY$annotations", "getCURRENT_REGISTER_KEY", "()Ljava/util/concurrent/atomic/AtomicInteger;", "staticCacheMap", "Ljava/util/WeakHashMap;", "Lcom/stripe/android/core/injection/Injector;", "", "getStaticCacheMap$annotations", "getStaticCacheMap", "()Ljava/util/WeakHashMap;", "clear", "", "nextKey", "prefix", "register", "injector", "key", "retrieve", "injectorKey", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WeakMapInjectorRegistry.kt */
public final class WeakMapInjectorRegistry implements InjectorRegistry {
    public static final int $stable = 8;
    private static final AtomicInteger CURRENT_REGISTER_KEY = new AtomicInteger(0);
    public static final WeakMapInjectorRegistry INSTANCE = new WeakMapInjectorRegistry();
    private static final WeakHashMap<Injector, String> staticCacheMap = new WeakHashMap<>();

    public static /* synthetic */ void getCURRENT_REGISTER_KEY$annotations() {
    }

    public static /* synthetic */ void getStaticCacheMap$annotations() {
    }

    private WeakMapInjectorRegistry() {
    }

    public final WeakHashMap<Injector, String> getStaticCacheMap() {
        return staticCacheMap;
    }

    public final AtomicInteger getCURRENT_REGISTER_KEY() {
        return CURRENT_REGISTER_KEY;
    }

    public synchronized void register(Injector injector, @InjectorKey String str) {
        Intrinsics.checkNotNullParameter(injector, "injector");
        Intrinsics.checkNotNullParameter(str, "key");
        staticCacheMap.put(injector, str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.stripe.android.core.injection.Injector} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.stripe.android.core.injection.Injector retrieve(@com.stripe.android.core.injection.InjectorKey java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "injectorKey"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)     // Catch:{ all -> 0x003f }
            java.util.WeakHashMap<com.stripe.android.core.injection.Injector, java.lang.String> r0 = staticCacheMap     // Catch:{ all -> 0x003f }
            java.util.Set r0 = r0.entrySet()     // Catch:{ all -> 0x003f }
            java.lang.String r1 = "staticCacheMap.entries"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch:{ all -> 0x003f }
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ all -> 0x003f }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x003f }
        L_0x0017:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x003f }
            r2 = 0
            if (r1 == 0) goto L_0x0030
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x003f }
            r3 = r1
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x003f }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x003f }
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)     // Catch:{ all -> 0x003f }
            if (r3 == 0) goto L_0x0017
            goto L_0x0031
        L_0x0030:
            r1 = r2
        L_0x0031:
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x0036
            goto L_0x003d
        L_0x0036:
            java.lang.Object r5 = r1.getKey()     // Catch:{ all -> 0x003f }
            r2 = r5
            com.stripe.android.core.injection.Injector r2 = (com.stripe.android.core.injection.Injector) r2     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r4)
            return r2
        L_0x003f:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.core.injection.WeakMapInjectorRegistry.retrieve(java.lang.String):com.stripe.android.core.injection.Injector");
    }

    @InjectorKey
    public String nextKey(String str) {
        Intrinsics.checkNotNullParameter(str, "prefix");
        return Intrinsics.stringPlus(str, Integer.valueOf(CURRENT_REGISTER_KEY.incrementAndGet()));
    }

    public final void clear() {
        synchronized (staticCacheMap) {
            INSTANCE.getStaticCacheMap().clear();
            Unit unit = Unit.INSTANCE;
        }
    }
}
