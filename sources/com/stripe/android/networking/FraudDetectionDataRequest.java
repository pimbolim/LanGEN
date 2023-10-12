package com.stripe.android.networking;

import com.stripe.android.core.StripeError;
import com.stripe.android.core.exception.InvalidRequestException;
import com.stripe.android.core.model.StripeJsonUtils;
import com.stripe.android.core.networking.NetworkConstantsKt;
import com.stripe.android.core.networking.RequestHeadersFactory;
import com.stripe.android.core.networking.StripeRequest;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B!\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR(\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000f¨\u0006,"}, d2 = {"Lcom/stripe/android/networking/FraudDetectionDataRequest;", "Lcom/stripe/android/core/networking/StripeRequest;", "params", "", "", "", "guid", "(Ljava/util/Map;Ljava/lang/String;)V", "headers", "getHeaders", "()Ljava/util/Map;", "headersFactory", "Lcom/stripe/android/core/networking/RequestHeadersFactory$FraudDetection;", "jsonBody", "getJsonBody", "()Ljava/lang/String;", "method", "Lcom/stripe/android/core/networking/StripeRequest$Method;", "getMethod", "()Lcom/stripe/android/core/networking/StripeRequest$Method;", "mimeType", "Lcom/stripe/android/core/networking/StripeRequest$MimeType;", "getMimeType", "()Lcom/stripe/android/core/networking/StripeRequest$MimeType;", "postBodyBytes", "", "getPostBodyBytes", "()[B", "postHeaders", "getPostHeaders", "setPostHeaders", "(Ljava/util/Map;)V", "retryResponseCodes", "", "", "getRetryResponseCodes", "()Ljava/lang/Iterable;", "url", "getUrl", "writePostBody", "", "outputStream", "Ljava/io/OutputStream;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FraudDetectionDataRequest.kt */
public final class FraudDetectionDataRequest extends StripeRequest {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String URL = "https://m.stripe.com/6";
    private final Map<String, String> headers;
    private final RequestHeadersFactory.FraudDetection headersFactory;
    private final StripeRequest.Method method = StripeRequest.Method.POST;
    private final StripeRequest.MimeType mimeType = StripeRequest.MimeType.Json;
    private final Map<String, Object> params;
    private Map<String, String> postHeaders;
    private final Iterable<Integer> retryResponseCodes = NetworkConstantsKt.getDEFAULT_RETRY_CODES();
    private final String url = URL;

    public FraudDetectionDataRequest(Map<String, ? extends Object> map, String str) {
        Intrinsics.checkNotNullParameter(map, "params");
        Intrinsics.checkNotNullParameter(str, "guid");
        this.params = map;
        RequestHeadersFactory.FraudDetection fraudDetection = new RequestHeadersFactory.FraudDetection(str);
        this.headersFactory = fraudDetection;
        this.headers = fraudDetection.create();
        this.postHeaders = fraudDetection.createPostHeader();
    }

    private final String getJsonBody() {
        return String.valueOf(StripeJsonUtils.INSTANCE.mapToJsonObject(this.params));
    }

    private final byte[] getPostBodyBytes() {
        try {
            byte[] bytes = getJsonBody().getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return bytes;
        } catch (UnsupportedEncodingException e) {
            throw new InvalidRequestException((StripeError) null, (String) null, 0, "Unable to encode parameters to " + Charsets.UTF_8.name() + ". Please contact support@stripe.com for assistance.", e, 7, (DefaultConstructorMarker) null);
        }
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

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/networking/FraudDetectionDataRequest$Companion;", "", "()V", "URL", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FraudDetectionDataRequest.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
