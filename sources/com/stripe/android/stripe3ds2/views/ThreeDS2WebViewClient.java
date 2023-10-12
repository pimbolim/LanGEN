package com.stripe.android.stripe3ds2.views;

import android.net.Uri;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.InputStream;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ThreeDS2WebViewClient;", "Landroid/webkit/WebViewClient;", "()V", "listener", "Lcom/stripe/android/stripe3ds2/views/ThreeDS2WebViewClient$OnHtmlSubmitListener;", "getListener$3ds2sdk_release", "()Lcom/stripe/android/stripe3ds2/views/ThreeDS2WebViewClient$OnHtmlSubmitListener;", "setListener$3ds2sdk_release", "(Lcom/stripe/android/stripe3ds2/views/ThreeDS2WebViewClient$OnHtmlSubmitListener;)V", "handleFormSubmitUrl", "", "uri", "Landroid/net/Uri;", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "view", "Landroid/webkit/WebView;", "request", "Landroid/webkit/WebResourceRequest;", "shouldNotInterceptUrl", "", "shouldOverrideUrlLoading", "Companion", "OnHtmlSubmitListener", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ThreeDS2WebViewClient.kt */
public final class ThreeDS2WebViewClient extends WebViewClient {
    public static final String CHALLENGE_URL = "https://emv3ds/challenge";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private OnHtmlSubmitListener listener;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bà\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ThreeDS2WebViewClient$OnHtmlSubmitListener;", "", "onHtmlSubmit", "", "data", "", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ThreeDS2WebViewClient.kt */
    public interface OnHtmlSubmitListener {
        void onHtmlSubmit(String str);
    }

    public final OnHtmlSubmitListener getListener$3ds2sdk_release() {
        return this.listener;
    }

    public final void setListener$3ds2sdk_release(OnHtmlSubmitListener onHtmlSubmitListener) {
        this.listener = onHtmlSubmitListener;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(webResourceRequest, "request");
        Uri url = webResourceRequest.getUrl();
        Intrinsics.checkNotNullExpressionValue(url, "request.url");
        handleFormSubmitUrl(url);
        Uri url2 = webResourceRequest.getUrl();
        Intrinsics.checkNotNullExpressionValue(url2, "request.url");
        if (shouldNotInterceptUrl(url2)) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        return new WebResourceResponse((String) null, (String) null, (InputStream) null);
    }

    public final boolean shouldNotInterceptUrl(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return URLUtil.isDataUrl(uri.toString());
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(webResourceRequest, "request");
        Uri url = webResourceRequest.getUrl();
        Intrinsics.checkNotNullExpressionValue(url, "request.url");
        handleFormSubmitUrl(url);
        return true;
    }

    public final void handleFormSubmitUrl(Uri uri) {
        OnHtmlSubmitListener onHtmlSubmitListener;
        Intrinsics.checkNotNullParameter(uri, "uri");
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        Locale locale = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(locale, "ENGLISH");
        String lowerCase = uri2.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (StringsKt.startsWith$default(lowerCase, CHALLENGE_URL, false, 2, (Object) null) && (onHtmlSubmitListener = this.listener) != null) {
            onHtmlSubmitListener.onHtmlSubmit(uri.getQuery());
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ThreeDS2WebViewClient$Companion;", "", "()V", "CHALLENGE_URL", "", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ThreeDS2WebViewClient.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
