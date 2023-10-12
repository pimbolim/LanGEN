package com.stripe.android.core.networking;

import com.stripe.android.core.networking.StripeRequest;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B+\u0012\u0010\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u00030\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0013\u0010\u001b\u001a\f\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u00030\u0003HÆ\u0003J\u0015\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J3\u0010\u001d\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u00030\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0015HÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u0004\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u000e\u0010\u0012\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lcom/stripe/android/core/networking/AnalyticsRequest;", "Lcom/stripe/android/core/networking/StripeRequest;", "params", "", "", "headers", "(Ljava/util/Map;Ljava/util/Map;)V", "getHeaders", "()Ljava/util/Map;", "method", "Lcom/stripe/android/core/networking/StripeRequest$Method;", "getMethod", "()Lcom/stripe/android/core/networking/StripeRequest$Method;", "mimeType", "Lcom/stripe/android/core/networking/StripeRequest$MimeType;", "getMimeType", "()Lcom/stripe/android/core/networking/StripeRequest$MimeType;", "getParams", "query", "retryResponseCodes", "", "", "getRetryResponseCodes", "()Ljava/lang/Iterable;", "url", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnalyticsRequest.kt */
public final class AnalyticsRequest extends StripeRequest {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String HOST = "https://q.stripe.com";
    private final Map<String, String> headers;
    private final StripeRequest.Method method = StripeRequest.Method.GET;
    private final StripeRequest.MimeType mimeType = StripeRequest.MimeType.Form;
    private final Map<String, ?> params;
    private final String query;
    private final Iterable<Integer> retryResponseCodes = new IntRange(NetworkConstantsKt.HTTP_TOO_MANY_REQUESTS, NetworkConstantsKt.HTTP_TOO_MANY_REQUESTS);
    private final String url;

    public static /* synthetic */ AnalyticsRequest copy$default(AnalyticsRequest analyticsRequest, Map<String, ?> map, Map<String, String> map2, int i, Object obj) {
        if ((i & 1) != 0) {
            map = analyticsRequest.params;
        }
        if ((i & 2) != 0) {
            map2 = analyticsRequest.getHeaders();
        }
        return analyticsRequest.copy(map, map2);
    }

    public final Map<String, ?> component1() {
        return this.params;
    }

    public final Map<String, String> component2() {
        return getHeaders();
    }

    public final AnalyticsRequest copy(Map<String, ?> map, Map<String, String> map2) {
        Intrinsics.checkNotNullParameter(map, "params");
        Intrinsics.checkNotNullParameter(map2, "headers");
        return new AnalyticsRequest(map, map2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnalyticsRequest)) {
            return false;
        }
        AnalyticsRequest analyticsRequest = (AnalyticsRequest) obj;
        return Intrinsics.areEqual((Object) this.params, (Object) analyticsRequest.params) && Intrinsics.areEqual((Object) getHeaders(), (Object) analyticsRequest.getHeaders());
    }

    public int hashCode() {
        return (this.params.hashCode() * 31) + getHeaders().hashCode();
    }

    public String toString() {
        return "AnalyticsRequest(params=" + this.params + ", headers=" + getHeaders() + ')';
    }

    public final Map<String, ?> getParams() {
        return this.params;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public AnalyticsRequest(Map<String, ?> map, Map<String, String> map2) {
        Intrinsics.checkNotNullParameter(map, "params");
        Intrinsics.checkNotNullParameter(map2, "headers");
        this.params = map;
        this.headers = map2;
        String createFromParamsWithEmptyValues = QueryStringFactory.INSTANCE.createFromParamsWithEmptyValues(map);
        this.query = createFromParamsWithEmptyValues;
        String[] strArr = new String[2];
        boolean z = false;
        strArr[0] = HOST;
        strArr[1] = !(createFromParamsWithEmptyValues.length() > 0 ? true : z) ? null : createFromParamsWithEmptyValues;
        this.url = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull((T[]) strArr), "?", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public StripeRequest.Method getMethod() {
        return this.method;
    }

    public StripeRequest.MimeType getMimeType() {
        return this.mimeType;
    }

    public Iterable<Integer> getRetryResponseCodes() {
        return this.retryResponseCodes;
    }

    public String getUrl() {
        return this.url;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/core/networking/AnalyticsRequest$Companion;", "", "()V", "HOST", "", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AnalyticsRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
