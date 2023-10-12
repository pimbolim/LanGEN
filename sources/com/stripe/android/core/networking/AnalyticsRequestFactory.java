package com.stripe.android.core.networking;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.core.networking.RequestHeadersFactory;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\b\u0017\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b¢\u0006\u0002\u0010\fJ\u0019\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0010H\u0000¢\u0006\u0002\b\u0011J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0010J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00072\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0010H\u0007J\u001a\u0010\u0018\u001a\u00020\u00192\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0014\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0010H\u0002J\u0018\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0010*\u00020\u0014H\u0002R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/stripe/android/core/networking/AnalyticsRequestFactory;", "", "packageManager", "Landroid/content/pm/PackageManager;", "packageInfo", "Landroid/content/pm/PackageInfo;", "packageName", "", "publishableKeyProvider", "Ljavax/inject/Provider;", "defaultProductUsageTokens", "", "(Landroid/content/pm/PackageManager;Landroid/content/pm/PackageInfo;Ljava/lang/String;Ljavax/inject/Provider;Ljava/util/Set;)V", "getDefaultProductUsageTokens$stripe_core_release", "()Ljava/util/Set;", "appDataParams", "", "appDataParams$stripe_core_release", "createParams", "event", "Lcom/stripe/android/core/networking/AnalyticsEvent;", "createRequest", "Lcom/stripe/android/core/networking/AnalyticsRequest;", "additionalParams", "getAppName", "", "standardParams", "params", "Companion", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnalyticsRequestFactory.kt */
public class AnalyticsRequestFactory {
    public static final int $stable = 8;
    private static final String ANALYTICS_NAME = "stripe_android";
    private static final String ANALYTICS_PREFIX = "analytics";
    public static final String ANALYTICS_UA = "analytics.stripe_android-1.0";
    private static final String ANALYTICS_VERSION = "1.0";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DEVICE_TYPE = (Build.MANUFACTURER + '_' + Build.BRAND + '_' + Build.MODEL);
    private final Set<String> defaultProductUsageTokens;
    private final PackageInfo packageInfo;
    private final PackageManager packageManager;
    private final String packageName;
    private final Provider<String> publishableKeyProvider;

    public AnalyticsRequestFactory(PackageManager packageManager2, PackageInfo packageInfo2, String str, Provider<String> provider, Set<String> set) {
        Intrinsics.checkNotNullParameter(str, "packageName");
        Intrinsics.checkNotNullParameter(provider, "publishableKeyProvider");
        Intrinsics.checkNotNullParameter(set, "defaultProductUsageTokens");
        this.packageManager = packageManager2;
        this.packageInfo = packageInfo2;
        this.packageName = str;
        this.publishableKeyProvider = provider;
        this.defaultProductUsageTokens = set;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AnalyticsRequestFactory(PackageManager packageManager2, PackageInfo packageInfo2, String str, Provider provider, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(packageManager2, packageInfo2, str, provider, (i & 16) != 0 ? SetsKt.emptySet() : set);
    }

    public final Set<String> getDefaultProductUsageTokens$stripe_core_release() {
        return this.defaultProductUsageTokens;
    }

    public final AnalyticsRequest createRequest(AnalyticsEvent analyticsEvent, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(analyticsEvent, "event");
        Intrinsics.checkNotNullParameter(map, "additionalParams");
        return new AnalyticsRequest(MapsKt.plus(createParams(analyticsEvent), (Map<String, Object>) map), RequestHeadersFactory.Analytics.INSTANCE.create());
    }

    @Deprecated(message = "use {@link #createRequest(AnalyticsEvent, Map<String, Any>)}")
    public final AnalyticsRequest createRequest(String str, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "event");
        Intrinsics.checkNotNullParameter(map, "additionalParams");
        return createRequest((AnalyticsEvent) new AnalyticsRequestFactory$createRequest$1(str), map);
    }

    private final Map<String, Object> createParams(AnalyticsEvent analyticsEvent) {
        return MapsKt.plus(MapsKt.plus(standardParams(), appDataParams$stripe_core_release()), (Map<String, Object>) params(analyticsEvent));
    }

    private final Map<String, String> params(AnalyticsEvent analyticsEvent) {
        return MapsKt.mapOf(TuplesKt.to("event", analyticsEvent.getEventName()));
    }

    private final Map<String, Object> standardParams() {
        Object obj;
        Pair[] pairArr = new Pair[8];
        pairArr[0] = TuplesKt.to(AnalyticsFields.ANALYTICS_UA, ANALYTICS_UA);
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m4709constructorimpl(this.publishableKeyProvider.get());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m4715isFailureimpl(obj)) {
            obj = ApiRequest.Options.UNDEFINED_PUBLISHABLE_KEY;
        }
        pairArr[1] = TuplesKt.to(AnalyticsFields.PUBLISHABLE_KEY, obj);
        pairArr[2] = TuplesKt.to(AnalyticsFields.OS_NAME, Build.VERSION.CODENAME);
        pairArr[3] = TuplesKt.to(AnalyticsFields.OS_RELEASE, Build.VERSION.RELEASE);
        pairArr[4] = TuplesKt.to(AnalyticsFields.OS_VERSION, Integer.valueOf(Build.VERSION.SDK_INT));
        pairArr[5] = TuplesKt.to(AnalyticsFields.DEVICE_TYPE, DEVICE_TYPE);
        pairArr[6] = TuplesKt.to(AnalyticsFields.BINDINGS_VERSION, "20.1.0");
        pairArr[7] = TuplesKt.to(AnalyticsFields.IS_DEVELOPMENT, false);
        return MapsKt.mapOf(pairArr);
    }

    public final Map<String, Object> appDataParams$stripe_core_release() {
        PackageInfo packageInfo2;
        PackageManager packageManager2 = this.packageManager;
        if (packageManager2 == null || (packageInfo2 = this.packageInfo) == null) {
            return MapsKt.emptyMap();
        }
        return MapsKt.mapOf(TuplesKt.to(AnalyticsFields.APP_NAME, getAppName(packageInfo2, packageManager2)), TuplesKt.to(AnalyticsFields.APP_VERSION, Integer.valueOf(this.packageInfo.versionCode)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r2 = r2.applicationInfo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.CharSequence getAppName(android.content.pm.PackageInfo r2, android.content.pm.PackageManager r3) {
        /*
            r1 = this;
            r0 = 0
            if (r2 != 0) goto L_0x0005
        L_0x0003:
            r2 = r0
            goto L_0x000e
        L_0x0005:
            android.content.pm.ApplicationInfo r2 = r2.applicationInfo
            if (r2 != 0) goto L_0x000a
            goto L_0x0003
        L_0x000a:
            java.lang.CharSequence r2 = r2.loadLabel(r3)
        L_0x000e:
            if (r2 == 0) goto L_0x0019
            boolean r3 = kotlin.text.StringsKt.isBlank(r2)
            if (r3 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r3 = 0
            goto L_0x001a
        L_0x0019:
            r3 = 1
        L_0x001a:
            if (r3 != 0) goto L_0x001d
            r0 = r2
        L_0x001d:
            if (r0 != 0) goto L_0x0024
            java.lang.String r2 = r1.packageName
            r0 = r2
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
        L_0x0024:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.core.networking.AnalyticsRequestFactory.getAppName(android.content.pm.PackageInfo, android.content.pm.PackageManager):java.lang.CharSequence");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/core/networking/AnalyticsRequestFactory$Companion;", "", "()V", "ANALYTICS_NAME", "", "ANALYTICS_PREFIX", "ANALYTICS_UA", "ANALYTICS_VERSION", "DEVICE_TYPE", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AnalyticsRequestFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
