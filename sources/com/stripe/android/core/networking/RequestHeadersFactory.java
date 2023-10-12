package com.stripe.android.core.networking;

import android.system.Os;
import com.henninghall.date_picker.props.LocaleProp;
import com.stripe.android.core.AppInfo;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.core.networking.StripeRequest;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.StringUtils;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00142\u00020\u0001:\u0006\u0011\u0012\u0013\u0014\u0015\u0016B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004J\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004R\u001e\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0007\"\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0005X¤\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0001\u0003\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/core/networking/RequestHeadersFactory;", "", "()V", "extraHeaders", "", "", "getExtraHeaders", "()Ljava/util/Map;", "postHeaders", "getPostHeaders", "setPostHeaders", "(Ljava/util/Map;)V", "userAgent", "getUserAgent", "()Ljava/lang/String;", "create", "createPostHeader", "Analytics", "Api", "BaseApiHeadersFactory", "Companion", "FileUpload", "FraudDetection", "Lcom/stripe/android/core/networking/RequestHeadersFactory$BaseApiHeadersFactory;", "Lcom/stripe/android/core/networking/RequestHeadersFactory$FraudDetection;", "Lcom/stripe/android/core/networking/RequestHeadersFactory$Analytics;", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RequestHeadersFactory.kt */
public abstract class RequestHeadersFactory {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public static final String CHARSET;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String UNDETERMINED_LANGUAGE = "und";
    private Map<String, String> postHeaders;

    public /* synthetic */ RequestHeadersFactory(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* access modifiers changed from: protected */
    public abstract Map<String, String> getExtraHeaders();

    /* access modifiers changed from: protected */
    public abstract String getUserAgent();

    private RequestHeadersFactory() {
        this.postHeaders = MapsKt.emptyMap();
    }

    public final Map<String, String> create() {
        return MapsKt.plus(getExtraHeaders(), (Map<String, String>) MapsKt.mapOf(TuplesKt.to(NetworkConstantsKt.HEADER_USER_AGENT, getUserAgent()), TuplesKt.to(NetworkConstantsKt.HEADER_ACCEPT_CHARSET, CHARSET)));
    }

    public final Map<String, String> createPostHeader() {
        return getPostHeaders();
    }

    /* access modifiers changed from: protected */
    public Map<String, String> getPostHeaders() {
        return this.postHeaders;
    }

    /* access modifiers changed from: protected */
    public void setPostHeaders(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.postHeaders = map;
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B=\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0002\u0010\fR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R \u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u000e8TX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\n8TX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/core/networking/RequestHeadersFactory$BaseApiHeadersFactory;", "Lcom/stripe/android/core/networking/RequestHeadersFactory;", "optionsProvider", "Lkotlin/Function0;", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "appInfo", "Lcom/stripe/android/core/AppInfo;", "locale", "Ljava/util/Locale;", "apiVersion", "", "sdkVersion", "(Lkotlin/jvm/functions/Function0;Lcom/stripe/android/core/AppInfo;Ljava/util/Locale;Ljava/lang/String;Ljava/lang/String;)V", "extraHeaders", "", "getExtraHeaders", "()Ljava/util/Map;", "languageTag", "getLanguageTag", "()Ljava/lang/String;", "stripeClientUserAgentHeaderFactory", "Lcom/stripe/android/core/networking/StripeClientUserAgentHeaderFactory;", "userAgent", "getUserAgent", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RequestHeadersFactory.kt */
    public static class BaseApiHeadersFactory extends RequestHeadersFactory {
        public static final int $stable = 8;
        private final String apiVersion;
        private final AppInfo appInfo;
        private final Locale locale;
        private final Function0<ApiRequest.Options> optionsProvider;
        private final String sdkVersion;
        private final StripeClientUserAgentHeaderFactory stripeClientUserAgentHeaderFactory;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ BaseApiHeadersFactory(kotlin.jvm.functions.Function0 r7, com.stripe.android.core.AppInfo r8, java.util.Locale r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
            /*
                r6 = this;
                r13 = r12 & 2
                if (r13 == 0) goto L_0x0005
                r8 = 0
            L_0x0005:
                r2 = r8
                r8 = r12 & 4
                if (r8 == 0) goto L_0x0013
                java.util.Locale r9 = java.util.Locale.getDefault()
                java.lang.String r8 = "getDefault()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r8)
            L_0x0013:
                r3 = r9
                r8 = r12 & 8
                if (r8 == 0) goto L_0x0022
                com.stripe.android.core.ApiVersion$Companion r8 = com.stripe.android.core.ApiVersion.Companion
                com.stripe.android.core.ApiVersion r8 = r8.get()
                java.lang.String r10 = r8.getCode()
            L_0x0022:
                r4 = r10
                r8 = r12 & 16
                if (r8 == 0) goto L_0x0029
                java.lang.String r11 = "AndroidBindings/20.1.0"
            L_0x0029:
                r5 = r11
                r0 = r6
                r1 = r7
                r0.<init>(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.core.networking.RequestHeadersFactory.BaseApiHeadersFactory.<init>(kotlin.jvm.functions.Function0, com.stripe.android.core.AppInfo, java.util.Locale, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BaseApiHeadersFactory(Function0<ApiRequest.Options> function0, AppInfo appInfo2, Locale locale2, String str, String str2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(function0, "optionsProvider");
            Intrinsics.checkNotNullParameter(locale2, LocaleProp.name);
            Intrinsics.checkNotNullParameter(str, "apiVersion");
            Intrinsics.checkNotNullParameter(str2, "sdkVersion");
            this.optionsProvider = function0;
            this.appInfo = appInfo2;
            this.locale = locale2;
            this.apiVersion = str;
            this.sdkVersion = str2;
            this.stripeClientUserAgentHeaderFactory = new StripeClientUserAgentHeaderFactory((Function1) null, 1, (DefaultConstructorMarker) null);
        }

        private final String getLanguageTag() {
            String languageTag = this.locale.toLanguageTag();
            Intrinsics.checkNotNullExpressionValue(languageTag, "it");
            boolean z = true;
            if (!(!StringsKt.isBlank(languageTag)) || Intrinsics.areEqual((Object) languageTag, (Object) RequestHeadersFactory.UNDETERMINED_LANGUAGE)) {
                z = false;
            }
            if (z) {
                return languageTag;
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public String getUserAgent() {
            String[] strArr = new String[2];
            strArr[0] = RequestHeadersFactory.Companion.getUserAgent(this.sdkVersion);
            AppInfo appInfo2 = this.appInfo;
            strArr[1] = appInfo2 == null ? null : appInfo2.toUserAgent$stripe_core_release();
            return CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((T[]) strArr), StringUtils.SPACE, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }

        /* access modifiers changed from: protected */
        public Map<String, String> getExtraHeaders() {
            Map map;
            Map map2;
            Map map3;
            ApiRequest.Options invoke = this.optionsProvider.invoke();
            Map<String, String> plus = MapsKt.plus(MapsKt.mapOf(TuplesKt.to(NetworkConstantsKt.HEADER_ACCEPT, "application/json"), TuplesKt.to(NetworkConstantsKt.HEADER_STRIPE_VERSION, this.apiVersion), TuplesKt.to(NetworkConstantsKt.HEADER_AUTHORIZATION, Intrinsics.stringPlus("Bearer ", invoke.getApiKey()))), (Map) this.stripeClientUserAgentHeaderFactory.create(this.appInfo));
            if (invoke.getApiKeyIsUserKey()) {
                map = MapsKt.mapOf(TuplesKt.to(NetworkConstantsKt.HEADER_STRIPE_LIVEMODE, String.valueOf(true ^ Intrinsics.areEqual((Object) Os.getenv(NetworkConstantsKt.HEADER_STRIPE_LIVEMODE), (Object) "false"))));
            } else {
                map = MapsKt.emptyMap();
            }
            Map<String, String> plus2 = MapsKt.plus(plus, (Map<String, String>) map);
            String stripeAccount = invoke.getStripeAccount();
            Map map4 = null;
            if (stripeAccount == null) {
                map2 = null;
            } else {
                map2 = MapsKt.mapOf(TuplesKt.to(NetworkConstantsKt.HEADER_STRIPE_ACCOUNT, stripeAccount));
            }
            if (map2 == null) {
                map2 = MapsKt.emptyMap();
            }
            Map<String, String> plus3 = MapsKt.plus(plus2, (Map<String, String>) map2);
            String idempotencyKey = invoke.getIdempotencyKey();
            if (idempotencyKey == null) {
                map3 = null;
            } else {
                map3 = MapsKt.mapOf(TuplesKt.to(NetworkConstantsKt.HEADER_IDEMPOTENCY_KEY, idempotencyKey));
            }
            if (map3 == null) {
                map3 = MapsKt.emptyMap();
            }
            Map<String, String> plus4 = MapsKt.plus(plus3, (Map<String, String>) map3);
            String languageTag = getLanguageTag();
            if (languageTag != null) {
                map4 = MapsKt.mapOf(TuplesKt.to(NetworkConstantsKt.HEADER_ACCEPT_LANGUAGE, languageTag));
            }
            if (map4 == null) {
                map4 = MapsKt.emptyMap();
            }
            return MapsKt.plus(plus4, (Map<String, String>) map4);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bR&\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/core/networking/RequestHeadersFactory$Api;", "Lcom/stripe/android/core/networking/RequestHeadersFactory$BaseApiHeadersFactory;", "options", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "appInfo", "Lcom/stripe/android/core/AppInfo;", "locale", "Ljava/util/Locale;", "apiVersion", "", "sdkVersion", "(Lcom/stripe/android/core/networking/ApiRequest$Options;Lcom/stripe/android/core/AppInfo;Ljava/util/Locale;Ljava/lang/String;Ljava/lang/String;)V", "postHeaders", "", "getPostHeaders", "()Ljava/util/Map;", "setPostHeaders", "(Ljava/util/Map;)V", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RequestHeadersFactory.kt */
    public static final class Api extends BaseApiHeadersFactory {
        public static final int $stable = 8;
        private Map<String, String> postHeaders;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Api(com.stripe.android.core.networking.ApiRequest.Options r7, com.stripe.android.core.AppInfo r8, java.util.Locale r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
            /*
                r6 = this;
                r13 = r12 & 2
                if (r13 == 0) goto L_0x0005
                r8 = 0
            L_0x0005:
                r2 = r8
                r8 = r12 & 4
                if (r8 == 0) goto L_0x0013
                java.util.Locale r9 = java.util.Locale.getDefault()
                java.lang.String r8 = "getDefault()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r8)
            L_0x0013:
                r3 = r9
                r8 = r12 & 8
                if (r8 == 0) goto L_0x0022
                com.stripe.android.core.ApiVersion$Companion r8 = com.stripe.android.core.ApiVersion.Companion
                com.stripe.android.core.ApiVersion r8 = r8.get()
                java.lang.String r10 = r8.getCode()
            L_0x0022:
                r4 = r10
                r8 = r12 & 16
                if (r8 == 0) goto L_0x0029
                java.lang.String r11 = "AndroidBindings/20.1.0"
            L_0x0029:
                r5 = r11
                r0 = r6
                r1 = r7
                r0.<init>(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.core.networking.RequestHeadersFactory.Api.<init>(com.stripe.android.core.networking.ApiRequest$Options, com.stripe.android.core.AppInfo, java.util.Locale, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Api(final ApiRequest.Options options, AppInfo appInfo, Locale locale, String str, String str2) {
            super(new Function0<ApiRequest.Options>() {
                public final ApiRequest.Options invoke() {
                    return options;
                }
            }, appInfo, locale, str, str2);
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(locale, LocaleProp.name);
            Intrinsics.checkNotNullParameter(str, "apiVersion");
            Intrinsics.checkNotNullParameter(str2, "sdkVersion");
            this.postHeaders = MapsKt.mapOf(TuplesKt.to(NetworkConstantsKt.HEADER_CONTENT_TYPE, StripeRequest.MimeType.Form + "; charset=" + RequestHeadersFactory.Companion.getCHARSET()));
        }

        /* access modifiers changed from: protected */
        public Map<String, String> getPostHeaders() {
            return this.postHeaders;
        }

        /* access modifiers changed from: protected */
        public void setPostHeaders(Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.postHeaders = map;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fR&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/core/networking/RequestHeadersFactory$FileUpload;", "Lcom/stripe/android/core/networking/RequestHeadersFactory$BaseApiHeadersFactory;", "options", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "appInfo", "Lcom/stripe/android/core/AppInfo;", "locale", "Ljava/util/Locale;", "apiVersion", "", "sdkVersion", "boundary", "(Lcom/stripe/android/core/networking/ApiRequest$Options;Lcom/stripe/android/core/AppInfo;Ljava/util/Locale;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "postHeaders", "", "getPostHeaders", "()Ljava/util/Map;", "setPostHeaders", "(Ljava/util/Map;)V", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RequestHeadersFactory.kt */
    public static final class FileUpload extends BaseApiHeadersFactory {
        public static final int $stable = 8;
        private Map<String, String> postHeaders;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ FileUpload(com.stripe.android.core.networking.ApiRequest.Options r8, com.stripe.android.core.AppInfo r9, java.util.Locale r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
            /*
                r7 = this;
                r15 = r14 & 2
                if (r15 == 0) goto L_0x0005
                r9 = 0
            L_0x0005:
                r2 = r9
                r9 = r14 & 4
                if (r9 == 0) goto L_0x0013
                java.util.Locale r10 = java.util.Locale.getDefault()
                java.lang.String r9 = "getDefault()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r9)
            L_0x0013:
                r3 = r10
                r9 = r14 & 8
                if (r9 == 0) goto L_0x0022
                com.stripe.android.core.ApiVersion$Companion r9 = com.stripe.android.core.ApiVersion.Companion
                com.stripe.android.core.ApiVersion r9 = r9.get()
                java.lang.String r11 = r9.getCode()
            L_0x0022:
                r4 = r11
                r9 = r14 & 16
                if (r9 == 0) goto L_0x0029
                java.lang.String r12 = "AndroidBindings/20.1.0"
            L_0x0029:
                r5 = r12
                r0 = r7
                r1 = r8
                r6 = r13
                r0.<init>(r1, r2, r3, r4, r5, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.core.networking.RequestHeadersFactory.FileUpload.<init>(com.stripe.android.core.networking.ApiRequest$Options, com.stripe.android.core.AppInfo, java.util.Locale, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FileUpload(final ApiRequest.Options options, AppInfo appInfo, Locale locale, String str, String str2, String str3) {
            super(new Function0<ApiRequest.Options>() {
                public final ApiRequest.Options invoke() {
                    return options;
                }
            }, appInfo, locale, str, str2);
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(locale, LocaleProp.name);
            Intrinsics.checkNotNullParameter(str, "apiVersion");
            Intrinsics.checkNotNullParameter(str2, "sdkVersion");
            Intrinsics.checkNotNullParameter(str3, "boundary");
            this.postHeaders = MapsKt.mapOf(TuplesKt.to(NetworkConstantsKt.HEADER_CONTENT_TYPE, StripeRequest.MimeType.MultipartForm.getCode() + "; boundary=" + str3));
        }

        /* access modifiers changed from: protected */
        public Map<String, String> getPostHeaders() {
            return this.postHeaders;
        }

        /* access modifiers changed from: protected */
        public void setPostHeaders(Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.postHeaders = map;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\b\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/core/networking/RequestHeadersFactory$FraudDetection;", "Lcom/stripe/android/core/networking/RequestHeadersFactory;", "guid", "", "(Ljava/lang/String;)V", "extraHeaders", "", "getExtraHeaders", "()Ljava/util/Map;", "postHeaders", "getPostHeaders", "setPostHeaders", "(Ljava/util/Map;)V", "userAgent", "getUserAgent", "()Ljava/lang/String;", "Companion", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RequestHeadersFactory.kt */
    public static final class FraudDetection extends RequestHeadersFactory {
        public static final int $stable = 8;
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String HEADER_COOKIE = "Cookie";
        private final Map<String, String> extraHeaders;
        private Map<String, String> postHeaders = MapsKt.mapOf(TuplesKt.to(NetworkConstantsKt.HEADER_CONTENT_TYPE, StripeRequest.MimeType.Json + "; charset=" + RequestHeadersFactory.Companion.getCHARSET()));
        private final String userAgent = RequestHeadersFactory.Companion.getUserAgent("AndroidBindings/20.1.0");

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FraudDetection(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "guid");
            this.extraHeaders = MapsKt.mapOf(TuplesKt.to(HEADER_COOKIE, Intrinsics.stringPlus("m=", str)));
        }

        /* access modifiers changed from: protected */
        public Map<String, String> getExtraHeaders() {
            return this.extraHeaders;
        }

        /* access modifiers changed from: protected */
        public String getUserAgent() {
            return this.userAgent;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/core/networking/RequestHeadersFactory$FraudDetection$Companion;", "", "()V", "HEADER_COOKIE", "", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: RequestHeadersFactory.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        /* access modifiers changed from: protected */
        public Map<String, String> getPostHeaders() {
            return this.postHeaders;
        }

        /* access modifiers changed from: protected */
        public void setPostHeaders(Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.postHeaders = map;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/core/networking/RequestHeadersFactory$Analytics;", "Lcom/stripe/android/core/networking/RequestHeadersFactory;", "()V", "extraHeaders", "", "", "getExtraHeaders", "()Ljava/util/Map;", "userAgent", "getUserAgent", "()Ljava/lang/String;", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RequestHeadersFactory.kt */
    public static final class Analytics extends RequestHeadersFactory {
        public static final int $stable = 8;
        public static final Analytics INSTANCE = new Analytics();
        private static final Map<String, String> extraHeaders = MapsKt.emptyMap();
        private static final String userAgent = RequestHeadersFactory.Companion.getUserAgent("AndroidBindings/20.1.0");

        private Analytics() {
            super((DefaultConstructorMarker) null);
        }

        /* access modifiers changed from: protected */
        public String getUserAgent() {
            return userAgent;
        }

        /* access modifiers changed from: protected */
        public Map<String, String> getExtraHeaders() {
            return extraHeaders;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stripe/android/core/networking/RequestHeadersFactory$Companion;", "", "()V", "CHARSET", "", "getCHARSET", "()Ljava/lang/String;", "UNDETERMINED_LANGUAGE", "getUserAgent", "sdkVersion", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: RequestHeadersFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ String getUserAgent$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "AndroidBindings/20.1.0";
            }
            return companion.getUserAgent(str);
        }

        public final String getUserAgent(String str) {
            Intrinsics.checkNotNullParameter(str, "sdkVersion");
            return Intrinsics.stringPlus("Stripe/v1 ", str);
        }

        public final String getCHARSET() {
            return RequestHeadersFactory.CHARSET;
        }
    }

    static {
        String name = Charsets.UTF_8.name();
        Intrinsics.checkNotNullExpressionValue(name, "UTF_8.name()");
        CHARSET = name;
    }
}
