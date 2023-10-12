package com.stripe.android.core.networking;

import com.stripe.android.core.networking.RequestId;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\b\u0018\u0000 &*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001&B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\fJ\u001b\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u0007HÆ\u0003JF\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u00002\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u0007HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u00132\b\u0010!\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\u0016\u0010\"\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\t2\u0006\u0010#\u001a\u00020\bJ\t\u0010$\u001a\u00020\u0004HÖ\u0001J\b\u0010%\u001a\u00020\bH\u0016R\u0015\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0016\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/stripe/android/core/networking/StripeResponse;", "ResponseBody", "", "code", "", "body", "headers", "", "", "", "(ILjava/lang/Object;Ljava/util/Map;)V", "getBody", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getCode", "()I", "getHeaders", "()Ljava/util/Map;", "isError", "", "()Z", "isOk", "isRateLimited", "requestId", "Lcom/stripe/android/core/networking/RequestId;", "getRequestId", "()Lcom/stripe/android/core/networking/RequestId;", "component1", "component2", "component3", "copy", "(ILjava/lang/Object;Ljava/util/Map;)Lcom/stripe/android/core/networking/StripeResponse;", "equals", "other", "getHeaderValue", "key", "hashCode", "toString", "Companion", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeResponse.kt */
public final class StripeResponse<ResponseBody> {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String HEADER_REQUEST_ID = "Request-Id";
    private final ResponseBody body;
    private final int code;
    private final Map<String, List<String>> headers;
    private final boolean isError;
    private final boolean isOk;
    private final boolean isRateLimited;
    private final RequestId requestId;

    public static /* synthetic */ StripeResponse copy$default(StripeResponse stripeResponse, int i, ResponseBody responsebody, Map<String, List<String>> map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = stripeResponse.code;
        }
        if ((i2 & 2) != 0) {
            responsebody = stripeResponse.body;
        }
        if ((i2 & 4) != 0) {
            map = stripeResponse.headers;
        }
        return stripeResponse.copy(i, responsebody, map);
    }

    public final int component1() {
        return this.code;
    }

    public final ResponseBody component2() {
        return this.body;
    }

    public final Map<String, List<String>> component3() {
        return this.headers;
    }

    public final StripeResponse<ResponseBody> copy(int i, ResponseBody responsebody, Map<String, ? extends List<String>> map) {
        Intrinsics.checkNotNullParameter(map, "headers");
        return new StripeResponse<>(i, responsebody, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StripeResponse)) {
            return false;
        }
        StripeResponse stripeResponse = (StripeResponse) obj;
        return this.code == stripeResponse.code && Intrinsics.areEqual((Object) this.body, (Object) stripeResponse.body) && Intrinsics.areEqual((Object) this.headers, (Object) stripeResponse.headers);
    }

    public int hashCode() {
        int i = this.code * 31;
        ResponseBody responsebody = this.body;
        return ((i + (responsebody == null ? 0 : responsebody.hashCode())) * 31) + this.headers.hashCode();
    }

    public StripeResponse(int i, ResponseBody responsebody, Map<String, ? extends List<String>> map) {
        Intrinsics.checkNotNullParameter(map, "headers");
        this.code = i;
        this.body = responsebody;
        this.headers = map;
        boolean z = true;
        this.isOk = i == 200;
        this.isError = i < 200 || i >= 300;
        this.isRateLimited = i != 429 ? false : z;
        RequestId.Companion companion = RequestId.Companion;
        List<String> headerValue = getHeaderValue(HEADER_REQUEST_ID);
        this.requestId = companion.fromString(headerValue == null ? null : (String) CollectionsKt.firstOrNull(headerValue));
    }

    public final int getCode() {
        return this.code;
    }

    public final ResponseBody getBody() {
        return this.body;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StripeResponse(int i, Object obj, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, obj, (i2 & 4) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public final boolean isOk() {
        return this.isOk;
    }

    public final boolean isError() {
        return this.isError;
    }

    public final boolean isRateLimited() {
        return this.isRateLimited;
    }

    public final RequestId getRequestId() {
        return this.requestId;
    }

    public String toString() {
        return "Request-Id: " + this.requestId + ", Status Code: " + this.code;
    }

    public final List<String> getHeaderValue(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "key");
        Iterator it = this.headers.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (StringsKt.equals((String) ((Map.Entry) obj).getKey(), str, true)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry == null) {
            return null;
        }
        return (List) entry.getValue();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/core/networking/StripeResponse$Companion;", "", "()V", "HEADER_REQUEST_ID", "", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeResponse.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
