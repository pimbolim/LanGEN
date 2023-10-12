package com.stripe.android.ui.core.elements;

import android.content.res.Resources;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

@Singleton
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0014\u001a\u00020\u0007J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u001e\u0010\u001b\u001a\u00020\u001c2\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001eH\u0007J\u001a\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\t\u0010 \u001a\u00020\u0016HÖ\u0001R\"\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006!"}, d2 = {"Lcom/stripe/android/ui/core/elements/BankRepository;", "", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "bankItemMap", "", "Lcom/stripe/android/ui/core/elements/SupportedBankType;", "", "Lcom/stripe/android/ui/core/elements/DropdownItemSpec;", "format", "Lkotlinx/serialization/json/Json;", "getResources", "()Landroid/content/res/Resources;", "component1", "copy", "equals", "", "other", "get", "bankType", "getJsonStringFromInputStream", "", "inputStream", "Ljava/io/InputStream;", "hashCode", "", "initialize", "", "supportedBankTypeInputStreamMap", "", "parseBank", "toString", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BankRepository.kt */
public final class BankRepository {
    public static final int $stable = 8;
    private final Map<SupportedBankType, List<DropdownItemSpec>> bankItemMap = new LinkedHashMap();
    private final Json format = JsonKt.Json$default((Json) null, BankRepository$format$1.INSTANCE, 1, (Object) null);
    private final Resources resources;

    public static /* synthetic */ BankRepository copy$default(BankRepository bankRepository, Resources resources2, int i, Object obj) {
        if ((i & 1) != 0) {
            resources2 = bankRepository.resources;
        }
        return bankRepository.copy(resources2);
    }

    public final Resources component1() {
        return this.resources;
    }

    public final BankRepository copy(Resources resources2) {
        return new BankRepository(resources2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BankRepository) && Intrinsics.areEqual((Object) this.resources, (Object) ((BankRepository) obj).resources);
    }

    public int hashCode() {
        Resources resources2 = this.resources;
        if (resources2 == null) {
            return 0;
        }
        return resources2.hashCode();
    }

    public String toString() {
        return "BankRepository(resources=" + this.resources + ')';
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0041, code lost:
        r6 = r6.getAssets();
     */
    @javax.inject.Inject
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BankRepository(android.content.res.Resources r9) {
        /*
            r8 = this;
            r8.<init>()
            r8.resources = r9
            java.util.LinkedHashMap r9 = new java.util.LinkedHashMap
            r9.<init>()
            java.util.Map r9 = (java.util.Map) r9
            r8.bankItemMap = r9
            com.stripe.android.ui.core.elements.BankRepository$format$1 r9 = com.stripe.android.ui.core.elements.BankRepository$format$1.INSTANCE
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            r0 = 0
            r1 = 1
            kotlinx.serialization.json.Json r9 = kotlinx.serialization.json.JsonKt.Json$default(r0, r9, r1, r0)
            r8.format = r9
            com.stripe.android.ui.core.elements.SupportedBankType[] r9 = com.stripe.android.ui.core.elements.SupportedBankType.values()
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            int r2 = r9.length
            int r2 = kotlin.collections.MapsKt.mapCapacity(r2)
            r3 = 16
            int r2 = kotlin.ranges.RangesKt.coerceAtLeast((int) r2, (int) r3)
            r1.<init>(r2)
            int r2 = r9.length
            r3 = 0
        L_0x0030:
            if (r3 >= r2) goto L_0x0054
            r4 = r9[r3]
            int r3 = r3 + 1
            r5 = r1
            java.util.Map r5 = (java.util.Map) r5
            android.content.res.Resources r6 = r8.getResources()
            if (r6 != 0) goto L_0x0041
        L_0x003f:
            r6 = r0
            goto L_0x0050
        L_0x0041:
            android.content.res.AssetManager r6 = r6.getAssets()
            if (r6 != 0) goto L_0x0048
            goto L_0x003f
        L_0x0048:
            java.lang.String r7 = r4.getAssetFileName()
            java.io.InputStream r6 = r6.open(r7)
        L_0x0050:
            r5.put(r4, r6)
            goto L_0x0030
        L_0x0054:
            java.util.Map r1 = (java.util.Map) r1
            r8.initialize(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.elements.BankRepository.<init>(android.content.res.Resources):void");
    }

    public final Resources getResources() {
        return this.resources;
    }

    public final List<DropdownItemSpec> get(SupportedBankType supportedBankType) {
        Intrinsics.checkNotNullParameter(supportedBankType, "bankType");
        List<DropdownItemSpec> list = this.bankItemMap.get(supportedBankType);
        if (list != null) {
            return list;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final List<DropdownItemSpec> parseBank(InputStream inputStream) {
        String jsonStringFromInputStream = getJsonStringFromInputStream(inputStream);
        if (jsonStringFromInputStream == null) {
            return null;
        }
        StringFormat stringFormat = this.format;
        return (List) stringFormat.decodeFromString(SerializersKt.serializer(stringFormat.getSerializersModule(), Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(DropdownItemSpec.class)))), jsonStringFromInputStream);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0032, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0033, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0036, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getJsonStringFromInputStream(java.io.InputStream r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0005
            r2 = r0
            goto L_0x001d
        L_0x0005:
            java.nio.charset.Charset r1 = kotlin.text.Charsets.UTF_8
            java.io.InputStreamReader r2 = new java.io.InputStreamReader
            r2.<init>(r4, r1)
            java.io.Reader r2 = (java.io.Reader) r2
            r4 = 8192(0x2000, float:1.14794E-41)
            boolean r1 = r2 instanceof java.io.BufferedReader
            if (r1 == 0) goto L_0x0017
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2
            goto L_0x001d
        L_0x0017:
            java.io.BufferedReader r1 = new java.io.BufferedReader
            r1.<init>(r2, r4)
            r2 = r1
        L_0x001d:
            java.io.Closeable r2 = (java.io.Closeable) r2
            r4 = r2
            java.io.BufferedReader r4 = (java.io.BufferedReader) r4     // Catch:{ all -> 0x0030 }
            if (r4 != 0) goto L_0x0026
            r4 = r0
            goto L_0x002c
        L_0x0026:
            java.io.Reader r4 = (java.io.Reader) r4     // Catch:{ all -> 0x0030 }
            java.lang.String r4 = kotlin.io.TextStreamsKt.readText(r4)     // Catch:{ all -> 0x0030 }
        L_0x002c:
            kotlin.io.CloseableKt.closeFinally(r2, r0)
            return r4
        L_0x0030:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0032 }
        L_0x0032:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.elements.BankRepository.getJsonStringFromInputStream(java.io.InputStream):java.lang.String");
    }

    public final void initialize(Map<SupportedBankType, ? extends InputStream> map) {
        Intrinsics.checkNotNullParameter(map, "supportedBankTypeInputStreamMap");
        for (Map.Entry next : map.entrySet()) {
            this.bankItemMap.put((SupportedBankType) next.getKey(), parseBank((InputStream) next.getValue()));
        }
    }
}
