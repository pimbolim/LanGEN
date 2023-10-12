package com.stripe.android.view;

import android.content.Intent;
import android.net.Uri;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.lifecycle.MutableLiveData;
import com.stripe.android.core.Logger;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0010\u0010J\b\u0010\u001c\u001a\u00020\rH\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001bH\u0002J\u0014\u0010 \u001a\u00020\r2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000fH\u0002J\u001a\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\fH\u0002J\u0010\u0010(\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002J\u0018\u0010)\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002R\u001c\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0004\u0012\u00020\r0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0012\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/stripe/android/view/PaymentAuthWebViewClient;", "Landroid/webkit/WebViewClient;", "logger", "Lcom/stripe/android/core/Logger;", "isPageLoaded", "Landroidx/lifecycle/MutableLiveData;", "", "clientSecret", "", "returnUrl", "activityStarter", "Lkotlin/Function1;", "Landroid/content/Intent;", "", "activityFinisher", "", "(Lcom/stripe/android/core/Logger;Landroidx/lifecycle/MutableLiveData;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "<set-?>", "completionUrlParam", "getCompletionUrlParam", "()Ljava/lang/String;", "hasLoadedBlank", "getHasLoadedBlank$payments_core_release", "()Z", "setHasLoadedBlank$payments_core_release", "(Z)V", "userReturnUri", "Landroid/net/Uri;", "hideProgressBar", "isPredefinedReturnUrl", "uri", "isReturnUrl", "onAuthCompleted", "error", "onPageFinished", "view", "Landroid/webkit/WebView;", "url", "openIntent", "intent", "openIntentScheme", "shouldOverrideUrlLoading", "request", "Landroid/webkit/WebResourceRequest;", "updateCompletionUrl", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentAuthWebViewClient.kt */
public final class PaymentAuthWebViewClient extends WebViewClient {
    /* access modifiers changed from: private */
    public static final Set<String> AUTHENTICATE_URLS = SetsKt.setOf("https://hooks.stripe.com/three_d_secure/authenticate");
    public static final String BLANK_PAGE = "about:blank";
    /* access modifiers changed from: private */
    public static final Set<String> COMPLETION_URLS = SetsKt.setOf("https://hooks.stripe.com/redirect/complete/", "https://hooks.stripe.com/3d_secure/complete/");
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PARAM_PAYMENT_CLIENT_SECRET = "payment_intent_client_secret";
    private static final String PARAM_RETURN_URL = "return_url";
    public static final String PARAM_SETUP_CLIENT_SECRET = "setup_intent_client_secret";
    private final Function1<Throwable, Unit> activityFinisher;
    private final Function1<Intent, Unit> activityStarter;
    private final String clientSecret;
    private String completionUrlParam;
    private boolean hasLoadedBlank;
    private final MutableLiveData<Boolean> isPageLoaded;
    private final Logger logger;
    private final Uri userReturnUri;

    public PaymentAuthWebViewClient(Logger logger2, MutableLiveData<Boolean> mutableLiveData, String str, String str2, Function1<? super Intent, Unit> function1, Function1<? super Throwable, Unit> function12) {
        Uri uri;
        Intrinsics.checkNotNullParameter(logger2, "logger");
        Intrinsics.checkNotNullParameter(mutableLiveData, "isPageLoaded");
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(function1, "activityStarter");
        Intrinsics.checkNotNullParameter(function12, "activityFinisher");
        this.logger = logger2;
        this.isPageLoaded = mutableLiveData;
        this.clientSecret = str;
        this.activityStarter = function1;
        this.activityFinisher = function12;
        if (str2 == null) {
            uri = null;
        } else {
            uri = Uri.parse(str2);
        }
        this.userReturnUri = uri;
    }

    public final String getCompletionUrlParam() {
        return this.completionUrlParam;
    }

    public final boolean getHasLoadedBlank$payments_core_release() {
        return this.hasLoadedBlank;
    }

    public final void setHasLoadedBlank$payments_core_release(boolean z) {
        this.hasLoadedBlank = z;
    }

    public void onPageFinished(WebView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "view");
        this.logger.debug(Intrinsics.stringPlus("PaymentAuthWebViewClient#onPageFinished() - ", str));
        super.onPageFinished(webView, str);
        if (!this.hasLoadedBlank) {
            hideProgressBar();
        }
        if (str != null && Companion.isCompletionUrl$payments_core_release(str)) {
            this.logger.debug(Intrinsics.stringPlus(str, " is a completion URL"));
            onAuthCompleted$default(this, (Throwable) null, 1, (Object) null);
        }
    }

    private final void hideProgressBar() {
        this.logger.debug("PaymentAuthWebViewClient#hideProgressBar()");
        this.isPageLoaded.setValue(true);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(webResourceRequest, "request");
        Uri url = webResourceRequest.getUrl();
        this.logger.debug(Intrinsics.stringPlus("PaymentAuthWebViewClient#shouldOverrideUrlLoading(): ", url));
        Intrinsics.checkNotNullExpressionValue(url, "url");
        updateCompletionUrl(url);
        if (isReturnUrl(url)) {
            this.logger.debug("PaymentAuthWebViewClient#shouldOverrideUrlLoading() - handle return URL");
            onAuthCompleted$default(this, (Throwable) null, 1, (Object) null);
            return true;
        } else if (StringsKt.equals("intent", url.getScheme(), true)) {
            openIntentScheme(url);
            return true;
        } else if (URLUtil.isNetworkUrl(url.toString())) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        } else {
            openIntent(new Intent("android.intent.action.VIEW", url));
            return true;
        }
    }

    private final void openIntentScheme(Uri uri) {
        Object obj;
        this.logger.debug("PaymentAuthWebViewClient#openIntentScheme()");
        try {
            Result.Companion companion = Result.Companion;
            Intent parseUri = Intent.parseUri(uri.toString(), 1);
            Intrinsics.checkNotNullExpressionValue(parseUri, "parseUri(uri.toString(), Intent.URI_INTENT_SCHEME)");
            openIntent(parseUri);
            obj = Result.m4709constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        Throwable r3 = Result.m4712exceptionOrNullimpl(obj);
        if (r3 != null) {
            this.logger.error("Failed to start Intent.", r3);
            onAuthCompleted(r3);
        }
    }

    private final void openIntent(Intent intent) {
        Object obj;
        this.logger.debug("PaymentAuthWebViewClient#openIntent()");
        try {
            Result.Companion companion = Result.Companion;
            this.activityStarter.invoke(intent);
            obj = Result.m4709constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        Throwable r0 = Result.m4712exceptionOrNullimpl(obj);
        if (r0 != null) {
            this.logger.error("Failed to start Intent.", r0);
            if (!Intrinsics.areEqual((Object) intent.getScheme(), (Object) "alipays")) {
                onAuthCompleted(r0);
            }
        }
    }

    private final void updateCompletionUrl(Uri uri) {
        String str;
        this.logger.debug("PaymentAuthWebViewClient#updateCompletionUrl()");
        Companion companion = Companion;
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        if (companion.isAuthenticateUrl(uri2)) {
            str = uri.getQueryParameter("return_url");
        } else {
            str = null;
        }
        CharSequence charSequence = str;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            this.completionUrlParam = str;
        }
    }

    private final boolean isReturnUrl(Uri uri) {
        String str;
        this.logger.debug("PaymentAuthWebViewClient#isReturnUrl()");
        if (isPredefinedReturnUrl(uri)) {
            return true;
        }
        Uri uri2 = this.userReturnUri;
        if (uri2 != null) {
            if (uri2.getScheme() == null || !Intrinsics.areEqual((Object) this.userReturnUri.getScheme(), (Object) uri.getScheme()) || this.userReturnUri.getHost() == null || !Intrinsics.areEqual((Object) this.userReturnUri.getHost(), (Object) uri.getHost())) {
                return false;
            }
            return true;
        } else if (uri.isOpaque()) {
            return false;
        } else {
            Set<String> queryParameterNames = uri.getQueryParameterNames();
            if (queryParameterNames.contains(PARAM_PAYMENT_CLIENT_SECRET)) {
                str = uri.getQueryParameter(PARAM_PAYMENT_CLIENT_SECRET);
            } else {
                str = queryParameterNames.contains(PARAM_SETUP_CLIENT_SECRET) ? uri.getQueryParameter(PARAM_SETUP_CLIENT_SECRET) : null;
            }
            return Intrinsics.areEqual((Object) this.clientSecret, (Object) str);
        }
    }

    private final boolean isPredefinedReturnUrl(Uri uri) {
        return Intrinsics.areEqual((Object) "stripejs://use_stripe_sdk/return_url", (Object) uri.toString());
    }

    static /* synthetic */ void onAuthCompleted$default(PaymentAuthWebViewClient paymentAuthWebViewClient, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        paymentAuthWebViewClient.onAuthCompleted(th);
    }

    private final void onAuthCompleted(Throwable th) {
        this.logger.debug("PaymentAuthWebViewClient#onAuthCompleted()");
        this.activityFinisher.invoke(th);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0015\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0001¢\u0006\u0002\b\u000fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/stripe/android/view/PaymentAuthWebViewClient$Companion;", "", "()V", "AUTHENTICATE_URLS", "", "", "BLANK_PAGE", "COMPLETION_URLS", "PARAM_PAYMENT_CLIENT_SECRET", "PARAM_RETURN_URL", "PARAM_SETUP_CLIENT_SECRET", "isAuthenticateUrl", "", "url", "isCompletionUrl", "isCompletionUrl$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentAuthWebViewClient.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isCompletionUrl$payments_core_release(String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            Iterable<String> access$getCOMPLETION_URLS$cp = PaymentAuthWebViewClient.COMPLETION_URLS;
            if ((access$getCOMPLETION_URLS$cp instanceof Collection) && ((Collection) access$getCOMPLETION_URLS$cp).isEmpty()) {
                return false;
            }
            for (String startsWith$default : access$getCOMPLETION_URLS$cp) {
                if (StringsKt.startsWith$default(str, startsWith$default, false, 2, (Object) null)) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: private */
        public final boolean isAuthenticateUrl(String str) {
            Iterable<String> access$getAUTHENTICATE_URLS$cp = PaymentAuthWebViewClient.AUTHENTICATE_URLS;
            if ((access$getAUTHENTICATE_URLS$cp instanceof Collection) && ((Collection) access$getAUTHENTICATE_URLS$cp).isEmpty()) {
                return false;
            }
            for (String startsWith$default : access$getAUTHENTICATE_URLS$cp) {
                if (StringsKt.startsWith$default(str, startsWith$default, false, 2, (Object) null)) {
                    return true;
                }
            }
            return false;
        }
    }
}
