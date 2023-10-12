package com.stripe.android.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005B\u001f\b\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\bJ\u000e\u0010\u000f\u001a\u00020\u0004HÀ\u0003¢\u0006\u0002\b\u0010J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÀ\u0003¢\u0006\u0002\b\u0012J#\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/core/ApiVersion;", "", "betas", "", "", "(Ljava/util/Set;)V", "version", "betaCodes", "(Ljava/lang/String;Ljava/util/Set;)V", "getBetaCodes$stripe_core_release", "()Ljava/util/Set;", "code", "getCode", "()Ljava/lang/String;", "getVersion$stripe_core_release", "component1", "component1$stripe_core_release", "component2", "component2$stripe_core_release", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ApiVersion.kt */
public final class ApiVersion {
    public static final int $stable = 8;
    public static final String API_VERSION_CODE = "2020-03-02";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final ApiVersion INSTANCE = new ApiVersion(API_VERSION_CODE, (Set) null, 2, (DefaultConstructorMarker) null);
    private final Set<String> betaCodes;
    private final String version;

    public static /* synthetic */ ApiVersion copy$default(ApiVersion apiVersion, String str, Set<String> set, int i, Object obj) {
        if ((i & 1) != 0) {
            str = apiVersion.version;
        }
        if ((i & 2) != 0) {
            set = apiVersion.betaCodes;
        }
        return apiVersion.copy(str, set);
    }

    public final String component1$stripe_core_release() {
        return this.version;
    }

    public final Set<String> component2$stripe_core_release() {
        return this.betaCodes;
    }

    public final ApiVersion copy(String str, Set<String> set) {
        Intrinsics.checkNotNullParameter(str, "version");
        Intrinsics.checkNotNullParameter(set, "betaCodes");
        return new ApiVersion(str, set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApiVersion)) {
            return false;
        }
        ApiVersion apiVersion = (ApiVersion) obj;
        return Intrinsics.areEqual((Object) this.version, (Object) apiVersion.version) && Intrinsics.areEqual((Object) this.betaCodes, (Object) apiVersion.betaCodes);
    }

    public int hashCode() {
        return (this.version.hashCode() * 31) + this.betaCodes.hashCode();
    }

    public String toString() {
        return "ApiVersion(version=" + this.version + ", betaCodes=" + this.betaCodes + ')';
    }

    public ApiVersion(String str, Set<String> set) {
        Intrinsics.checkNotNullParameter(str, "version");
        Intrinsics.checkNotNullParameter(set, "betaCodes");
        this.version = str;
        this.betaCodes = set;
    }

    public final String getVersion$stripe_core_release() {
        return this.version;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ApiVersion(String str, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? SetsKt.emptySet() : set);
    }

    public final Set<String> getBetaCodes$stripe_core_release() {
        return this.betaCodes;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ApiVersion(Set<String> set) {
        this(API_VERSION_CODE, set);
        Intrinsics.checkNotNullParameter(set, "betas");
    }

    public final String getCode() {
        Collection listOf = CollectionsKt.listOf(this.version);
        Iterable<String> iterable = this.betaCodes;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String add : iterable) {
            arrayList.add(add);
        }
        return CollectionsKt.joinToString$default(CollectionsKt.plus(listOf, (List) arrayList), ";", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stripe/android/core/ApiVersion$Companion;", "", "()V", "API_VERSION_CODE", "", "INSTANCE", "Lcom/stripe/android/core/ApiVersion;", "get", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ApiVersion.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final /* synthetic */ ApiVersion get() {
            return ApiVersion.INSTANCE;
        }
    }
}
