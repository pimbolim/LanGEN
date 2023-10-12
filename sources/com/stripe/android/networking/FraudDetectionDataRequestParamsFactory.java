package com.stripe.android.networking;

import android.os.Build;
import android.util.DisplayMetrics;
import com.brentvatne.react.ReactVideoViewManager;
import com.nimbusds.jose.HeaderParameterNames;
import com.nimbusds.jose.jwk.JWKParameterNames;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B)\b\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u000fH\u0002J#\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\b\u0013J\u001e\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u000f2\u0006\u0010\u0016\u001a\u00020\bH\u0002R\u000e\u0010\f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/networking/FraudDetectionDataRequestParamsFactory;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "displayMetrics", "Landroid/util/DisplayMetrics;", "packageName", "", "versionName", "timeZone", "(Landroid/util/DisplayMetrics;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "androidVersionString", "screen", "createFirstMap", "", "createParams", "fraudDetectionData", "Lcom/stripe/android/networking/FraudDetectionData;", "createParams$payments_core_release", "createSecondMap", "createValueMap", "value", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FraudDetectionDataRequestParamsFactory.kt */
public final class FraudDetectionDataRequestParamsFactory {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String androidVersionString;
    private final DisplayMetrics displayMetrics;
    private final String packageName;
    private final String screen;
    private final String timeZone;
    private final String versionName;

    public FraudDetectionDataRequestParamsFactory(DisplayMetrics displayMetrics2, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(displayMetrics2, "displayMetrics");
        Intrinsics.checkNotNullParameter(str, "packageName");
        Intrinsics.checkNotNullParameter(str3, "timeZone");
        this.displayMetrics = displayMetrics2;
        this.packageName = str;
        this.versionName = str2;
        this.timeZone = str3;
        this.screen = displayMetrics2.widthPixels + "w_" + displayMetrics2.heightPixels + "h_" + displayMetrics2.densityDpi + "dpi";
        this.androidVersionString = "Android " + Build.VERSION.RELEASE + ' ' + Build.VERSION.CODENAME + ' ' + Build.VERSION.SDK_INT;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FraudDetectionDataRequestParamsFactory(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            android.content.res.Resources r0 = r4.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            java.lang.String r1 = "context.resources.displayMetrics"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r1 = r4.getPackageName()
            if (r1 != 0) goto L_0x001a
            java.lang.String r1 = ""
        L_0x001a:
            com.stripe.android.utils.ContextUtils r2 = com.stripe.android.utils.ContextUtils.INSTANCE
            android.content.pm.PackageInfo r4 = r2.getPackageInfo$payments_core_release(r4)
            if (r4 != 0) goto L_0x0024
            r4 = 0
            goto L_0x0026
        L_0x0024:
            java.lang.String r4 = r4.versionName
        L_0x0026:
            com.stripe.android.networking.FraudDetectionDataRequestParamsFactory$Companion r2 = Companion
            java.lang.String r2 = r2.createTimezone()
            r3.<init>(r0, r1, r4, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.networking.FraudDetectionDataRequestParamsFactory.<init>(android.content.Context):void");
    }

    public final /* synthetic */ Map createParams$payments_core_release(FraudDetectionData fraudDetectionData) {
        return MapsKt.mapOf(TuplesKt.to("v2", 1), TuplesKt.to(HeaderParameterNames.AUTHENTICATION_TAG, "20.1.0"), TuplesKt.to(ReactVideoViewManager.PROP_SRC, "android-sdk"), TuplesKt.to("a", createFirstMap()), TuplesKt.to("b", createSecondMap(fraudDetectionData)));
    }

    private final Map<String, Object> createFirstMap() {
        String locale = Locale.getDefault().toString();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault().toString()");
        return MapsKt.mapOf(TuplesKt.to("c", createValueMap(locale)), TuplesKt.to("d", createValueMap(this.androidVersionString)), TuplesKt.to("f", createValueMap(this.screen)), TuplesKt.to("g", createValueMap(this.timeZone)));
    }

    private final Map<String, Object> createSecondMap(FraudDetectionData fraudDetectionData) {
        String str;
        Pair[] pairArr = new Pair[9];
        Map map = null;
        String muid$payments_core_release = fraudDetectionData == null ? null : fraudDetectionData.getMuid$payments_core_release();
        String str2 = "";
        if (muid$payments_core_release == null) {
            muid$payments_core_release = str2;
        }
        pairArr[0] = TuplesKt.to("d", muid$payments_core_release);
        if (fraudDetectionData == null) {
            str = null;
        } else {
            str = fraudDetectionData.getSid$payments_core_release();
        }
        if (str != null) {
            str2 = str;
        }
        pairArr[1] = TuplesKt.to(JWKParameterNames.RSA_EXPONENT, str2);
        pairArr[2] = TuplesKt.to(JWKParameterNames.OCT_KEY_VALUE, this.packageName);
        pairArr[3] = TuplesKt.to("o", Build.VERSION.RELEASE);
        pairArr[4] = TuplesKt.to(JWKParameterNames.RSA_FIRST_PRIME_FACTOR, Integer.valueOf(Build.VERSION.SDK_INT));
        pairArr[5] = TuplesKt.to(JWKParameterNames.RSA_SECOND_PRIME_FACTOR, Build.MANUFACTURER);
        pairArr[6] = TuplesKt.to(JWKParameterNames.RSA_OTHER_PRIMES__PRIME_FACTOR, Build.BRAND);
        pairArr[7] = TuplesKt.to("s", Build.MODEL);
        pairArr[8] = TuplesKt.to(JWKParameterNames.RSA_OTHER_PRIMES__FACTOR_CRT_COEFFICIENT, Build.TAGS);
        Map mapOf = MapsKt.mapOf(pairArr);
        String str3 = this.versionName;
        if (str3 != null) {
            map = MapsKt.mapOf(TuplesKt.to("l", str3));
        }
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        return MapsKt.plus(mapOf, map);
    }

    private final Map<String, Object> createValueMap(String str) {
        return MapsKt.mapOf(TuplesKt.to("v", str));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/networking/FraudDetectionDataRequestParamsFactory$Companion;", "", "()V", "createTimezone", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FraudDetectionDataRequestParamsFactory.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final String createTimezone() {
            int convert = (int) TimeUnit.MINUTES.convert((long) TimeZone.getDefault().getRawOffset(), TimeUnit.MILLISECONDS);
            if (convert % 60 == 0) {
                return String.valueOf(convert / 60);
            }
            String bigDecimal = new BigDecimal(convert).setScale(2, 6).divide(new BigDecimal(60), new MathContext(2)).setScale(2, 6).toString();
            Intrinsics.checkNotNullExpressionValue(bigDecimal, "decHours.toString()");
            return bigDecimal;
        }
    }
}
