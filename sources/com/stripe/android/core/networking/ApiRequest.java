package com.stripe.android.core.networking;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.stripe.android.core.ApiKeyValidator;
import com.stripe.android.core.ApiVersion;
import com.stripe.android.core.AppInfo;
import com.stripe.android.core.StripeError;
import com.stripe.android.core.exception.InvalidRequestException;
import com.stripe.android.core.networking.RequestHeadersFactory;
import com.stripe.android.core.networking.StripeRequest;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 A2\u00020\u0001:\u0003ABCBU\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u0003\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005¢\u0006\u0002\u0010\u000eJ\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\u0015\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u0003\u0018\u00010\u0007HÆ\u0003J\t\u00102\u001a\u00020\tHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u000bHÂ\u0003J\t\u00104\u001a\u00020\u0005HÂ\u0003J\t\u00105\u001a\u00020\u0005HÂ\u0003J]\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u0003\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020*HÖ\u0001J\b\u0010<\u001a\u00020\u0005H\u0016J\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0016R\u000e\u0010\f\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0014\u0010\u001f\u001a\u00020 8BX\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R(\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u000e\u0010\r\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010\u0010¨\u0006D"}, d2 = {"Lcom/stripe/android/core/networking/ApiRequest;", "Lcom/stripe/android/core/networking/StripeRequest;", "method", "Lcom/stripe/android/core/networking/StripeRequest$Method;", "baseUrl", "", "params", "", "options", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "appInfo", "Lcom/stripe/android/core/AppInfo;", "apiVersion", "sdkVersion", "(Lcom/stripe/android/core/networking/StripeRequest$Method;Ljava/lang/String;Ljava/util/Map;Lcom/stripe/android/core/networking/ApiRequest$Options;Lcom/stripe/android/core/AppInfo;Ljava/lang/String;Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "headers", "getHeaders", "()Ljava/util/Map;", "headersFactory", "Lcom/stripe/android/core/networking/RequestHeadersFactory$Api;", "getMethod", "()Lcom/stripe/android/core/networking/StripeRequest$Method;", "mimeType", "Lcom/stripe/android/core/networking/StripeRequest$MimeType;", "getMimeType", "()Lcom/stripe/android/core/networking/StripeRequest$MimeType;", "getOptions", "()Lcom/stripe/android/core/networking/ApiRequest$Options;", "getParams", "postBodyBytes", "", "getPostBodyBytes", "()[B", "postHeaders", "getPostHeaders", "setPostHeaders", "(Ljava/util/Map;)V", "query", "retryResponseCodes", "", "", "getRetryResponseCodes", "()Ljava/lang/Iterable;", "url", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "writePostBody", "", "outputStream", "Ljava/io/OutputStream;", "Companion", "Factory", "Options", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ApiRequest.kt */
public final class ApiRequest extends StripeRequest {
    public static final int $stable = 8;
    public static final String API_HOST = "https://api.stripe.com";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String apiVersion;
    private final AppInfo appInfo;
    private final String baseUrl;
    private final Map<String, String> headers;
    private final RequestHeadersFactory.Api headersFactory;
    private final StripeRequest.Method method;
    private final StripeRequest.MimeType mimeType;
    private final Options options;
    private final Map<String, ?> params;
    private Map<String, String> postHeaders;
    private final String query;
    private final Iterable<Integer> retryResponseCodes;
    private final String sdkVersion;

    private final AppInfo component5() {
        return this.appInfo;
    }

    private final String component6() {
        return this.apiVersion;
    }

    private final String component7() {
        return this.sdkVersion;
    }

    public static /* synthetic */ ApiRequest copy$default(ApiRequest apiRequest, StripeRequest.Method method2, String str, Map<String, ?> map, Options options2, AppInfo appInfo2, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            method2 = apiRequest.getMethod();
        }
        if ((i & 2) != 0) {
            str = apiRequest.baseUrl;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            map = apiRequest.params;
        }
        Map<String, ?> map2 = map;
        if ((i & 8) != 0) {
            options2 = apiRequest.options;
        }
        Options options3 = options2;
        if ((i & 16) != 0) {
            appInfo2 = apiRequest.appInfo;
        }
        AppInfo appInfo3 = appInfo2;
        if ((i & 32) != 0) {
            str2 = apiRequest.apiVersion;
        }
        String str5 = str2;
        if ((i & 64) != 0) {
            str3 = apiRequest.sdkVersion;
        }
        return apiRequest.copy(method2, str4, map2, options3, appInfo3, str5, str3);
    }

    public final StripeRequest.Method component1() {
        return getMethod();
    }

    public final String component2() {
        return this.baseUrl;
    }

    public final Map<String, ?> component3() {
        return this.params;
    }

    public final Options component4() {
        return this.options;
    }

    public final ApiRequest copy(StripeRequest.Method method2, String str, Map<String, ?> map, Options options2, AppInfo appInfo2, String str2, String str3) {
        Intrinsics.checkNotNullParameter(method2, FirebaseAnalytics.Param.METHOD);
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Intrinsics.checkNotNullParameter(options2, "options");
        Intrinsics.checkNotNullParameter(str2, "apiVersion");
        String str4 = str3;
        Intrinsics.checkNotNullParameter(str4, "sdkVersion");
        return new ApiRequest(method2, str, map, options2, appInfo2, str2, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApiRequest)) {
            return false;
        }
        ApiRequest apiRequest = (ApiRequest) obj;
        return getMethod() == apiRequest.getMethod() && Intrinsics.areEqual((Object) this.baseUrl, (Object) apiRequest.baseUrl) && Intrinsics.areEqual((Object) this.params, (Object) apiRequest.params) && Intrinsics.areEqual((Object) this.options, (Object) apiRequest.options) && Intrinsics.areEqual((Object) this.appInfo, (Object) apiRequest.appInfo) && Intrinsics.areEqual((Object) this.apiVersion, (Object) apiRequest.apiVersion) && Intrinsics.areEqual((Object) this.sdkVersion, (Object) apiRequest.sdkVersion);
    }

    public int hashCode() {
        int hashCode = ((getMethod().hashCode() * 31) + this.baseUrl.hashCode()) * 31;
        Map<String, ?> map = this.params;
        int i = 0;
        int hashCode2 = (((hashCode + (map == null ? 0 : map.hashCode())) * 31) + this.options.hashCode()) * 31;
        AppInfo appInfo2 = this.appInfo;
        if (appInfo2 != null) {
            i = appInfo2.hashCode();
        }
        return ((((hashCode2 + i) * 31) + this.apiVersion.hashCode()) * 31) + this.sdkVersion.hashCode();
    }

    public StripeRequest.Method getMethod() {
        return this.method;
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final Map<String, ?> getParams() {
        return this.params;
    }

    public final Options getOptions() {
        return this.options;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ApiRequest(StripeRequest.Method method2, String str, Map map, Options options2, AppInfo appInfo2, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(method2, str, (i & 4) != 0 ? null : map, options2, (i & 16) != 0 ? null : appInfo2, (i & 32) != 0 ? ApiVersion.Companion.get().getCode() : str2, (i & 64) != 0 ? "AndroidBindings/20.1.0" : str3);
    }

    public ApiRequest(StripeRequest.Method method2, String str, Map<String, ?> map, Options options2, AppInfo appInfo2, String str2, String str3) {
        Intrinsics.checkNotNullParameter(method2, FirebaseAnalytics.Param.METHOD);
        Intrinsics.checkNotNullParameter(str, "baseUrl");
        Intrinsics.checkNotNullParameter(options2, "options");
        Intrinsics.checkNotNullParameter(str2, "apiVersion");
        Intrinsics.checkNotNullParameter(str3, "sdkVersion");
        this.method = method2;
        this.baseUrl = str;
        this.params = map;
        this.options = options2;
        this.appInfo = appInfo2;
        this.apiVersion = str2;
        this.sdkVersion = str3;
        this.query = QueryStringFactory.INSTANCE.createFromParamsWithEmptyValues(map);
        RequestHeadersFactory.Api api = new RequestHeadersFactory.Api(options2, appInfo2, (Locale) null, str2, str3, 4, (DefaultConstructorMarker) null);
        this.headersFactory = api;
        this.mimeType = StripeRequest.MimeType.Form;
        this.retryResponseCodes = NetworkConstantsKt.getDEFAULT_RETRY_CODES();
        this.headers = api.create();
        this.postHeaders = api.createPostHeader();
    }

    private final byte[] getPostBodyBytes() throws UnsupportedEncodingException, InvalidRequestException {
        try {
            byte[] bytes = this.query.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return bytes;
        } catch (UnsupportedEncodingException e) {
            throw new InvalidRequestException((StripeError) null, (String) null, 0, "Unable to encode parameters to " + Charsets.UTF_8.name() + ". Please contact support@stripe.com for assistance.", e, 7, (DefaultConstructorMarker) null);
        }
    }

    public StripeRequest.MimeType getMimeType() {
        return this.mimeType;
    }

    public Iterable<Integer> getRetryResponseCodes() {
        return this.retryResponseCodes;
    }

    public String getUrl() {
        if (StripeRequest.Method.GET != getMethod()) {
            return this.baseUrl;
        }
        String[] strArr = new String[2];
        strArr[0] = this.baseUrl;
        String str = this.query;
        if (!(str.length() > 0)) {
            str = null;
        }
        strArr[1] = str;
        Iterable listOfNotNull = CollectionsKt.listOfNotNull((T[]) strArr);
        String str2 = "?";
        if (StringsKt.contains$default((CharSequence) this.baseUrl, (CharSequence) str2, false, 2, (Object) null)) {
            str2 = "&";
        }
        return CollectionsKt.joinToString$default(listOfNotNull, str2, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public Map<String, String> getPostHeaders() {
        return this.postHeaders;
    }

    public void setPostHeaders(Map<String, String> map) {
        this.postHeaders = map;
    }

    public void writePostBody(OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        outputStream.write(getPostBodyBytes());
        outputStream.flush();
    }

    public String toString() {
        return getMethod().getCode() + ' ' + this.baseUrl;
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B)\b\u0017\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0001\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¢\u0006\u0002\u0010\u0006B%\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J+\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006$"}, d2 = {"Lcom/stripe/android/core/networking/ApiRequest$Options;", "Landroid/os/Parcelable;", "publishableKeyProvider", "Lkotlin/Function0;", "", "stripeAccountIdProvider", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "apiKey", "stripeAccount", "idempotencyKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getApiKey", "()Ljava/lang/String;", "apiKeyIsUserKey", "", "getApiKeyIsUserKey", "()Z", "getIdempotencyKey", "getStripeAccount", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ApiRequest.kt */
    public static final class Options implements Parcelable {
        public static final int $stable = 8;
        public static final Parcelable.Creator<Options> CREATOR = new Creator();
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final String UNDEFINED_PUBLISHABLE_KEY = "pk_undefined";
        private final String apiKey;
        private final String idempotencyKey;
        private final String stripeAccount;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ApiRequest.kt */
        public static final class Creator implements Parcelable.Creator<Options> {
            public final Options createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Options(parcel.readString(), parcel.readString(), parcel.readString());
            }

            public final Options[] newArray(int i) {
                return new Options[i];
            }
        }

        public static /* synthetic */ Options copy$default(Options options, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = options.apiKey;
            }
            if ((i & 2) != 0) {
                str2 = options.stripeAccount;
            }
            if ((i & 4) != 0) {
                str3 = options.idempotencyKey;
            }
            return options.copy(str, str2, str3);
        }

        public final String component1() {
            return this.apiKey;
        }

        public final String component2() {
            return this.stripeAccount;
        }

        public final String component3() {
            return this.idempotencyKey;
        }

        public final Options copy(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "apiKey");
            return new Options(str, str2, str3);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Options)) {
                return false;
            }
            Options options = (Options) obj;
            return Intrinsics.areEqual((Object) this.apiKey, (Object) options.apiKey) && Intrinsics.areEqual((Object) this.stripeAccount, (Object) options.stripeAccount) && Intrinsics.areEqual((Object) this.idempotencyKey, (Object) options.idempotencyKey);
        }

        public int hashCode() {
            int hashCode = this.apiKey.hashCode() * 31;
            String str = this.stripeAccount;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.idempotencyKey;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode2 + i;
        }

        public String toString() {
            return "Options(apiKey=" + this.apiKey + ", stripeAccount=" + this.stripeAccount + ", idempotencyKey=" + this.idempotencyKey + ')';
        }

        public void writeToParcel(Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.apiKey);
            parcel.writeString(this.stripeAccount);
            parcel.writeString(this.idempotencyKey);
        }

        public Options(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "apiKey");
            this.apiKey = str;
            this.stripeAccount = str2;
            this.idempotencyKey = str3;
            new ApiKeyValidator().requireValid(str);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Options(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        public final String getApiKey() {
            return this.apiKey;
        }

        public final String getStripeAccount() {
            return this.stripeAccount;
        }

        public final String getIdempotencyKey() {
            return this.idempotencyKey;
        }

        public final boolean getApiKeyIsUserKey() {
            return StringsKt.startsWith$default(this.apiKey, "uk_", false, 2, (Object) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        @Inject
        public Options(@Named("publishableKey") Function0<String> function0, @Named("stripeAccountId") Function0<String> function02) {
            this(function0.invoke(), function02.invoke(), (String) null, 4, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(function0, "publishableKeyProvider");
            Intrinsics.checkNotNullParameter(function02, "stripeAccountIdProvider");
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/core/networking/ApiRequest$Options$Companion;", "", "()V", "UNDEFINED_PUBLISHABLE_KEY", "", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: ApiRequest.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fJ,\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u0003\u0018\u00010\u000fJ,\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0002\b\u0003\u0018\u00010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/core/networking/ApiRequest$Factory;", "", "appInfo", "Lcom/stripe/android/core/AppInfo;", "apiVersion", "", "sdkVersion", "(Lcom/stripe/android/core/AppInfo;Ljava/lang/String;Ljava/lang/String;)V", "createDelete", "Lcom/stripe/android/core/networking/ApiRequest;", "url", "options", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "createGet", "params", "", "createPost", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ApiRequest.kt */
    public static final class Factory {
        public static final int $stable = 8;
        private final String apiVersion;
        private final AppInfo appInfo;
        private final String sdkVersion;

        public Factory() {
            this((AppInfo) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
        }

        public Factory(AppInfo appInfo2, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "apiVersion");
            Intrinsics.checkNotNullParameter(str2, "sdkVersion");
            this.appInfo = appInfo2;
            this.apiVersion = str;
            this.sdkVersion = str2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Factory(AppInfo appInfo2, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : appInfo2, (i & 2) != 0 ? ApiVersion.Companion.get().getCode() : str, (i & 4) != 0 ? "AndroidBindings/20.1.0" : str2);
        }

        public static /* synthetic */ ApiRequest createGet$default(Factory factory, String str, Options options, Map map, int i, Object obj) {
            if ((i & 4) != 0) {
                map = null;
            }
            return factory.createGet(str, options, map);
        }

        public final ApiRequest createGet(String str, Options options, Map<String, ?> map) {
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(options, "options");
            return new ApiRequest(StripeRequest.Method.GET, str, map, options, this.appInfo, this.apiVersion, this.sdkVersion);
        }

        public static /* synthetic */ ApiRequest createPost$default(Factory factory, String str, Options options, Map map, int i, Object obj) {
            if ((i & 4) != 0) {
                map = null;
            }
            return factory.createPost(str, options, map);
        }

        public final ApiRequest createPost(String str, Options options, Map<String, ?> map) {
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(options, "options");
            return new ApiRequest(StripeRequest.Method.POST, str, map, options, this.appInfo, this.apiVersion, this.sdkVersion);
        }

        public final ApiRequest createDelete(String str, Options options) {
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(options, "options");
            return new ApiRequest(StripeRequest.Method.DELETE, str, (Map) null, options, this.appInfo, this.apiVersion, this.sdkVersion, 4, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/core/networking/ApiRequest$Companion;", "", "()V", "API_HOST", "", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ApiRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
