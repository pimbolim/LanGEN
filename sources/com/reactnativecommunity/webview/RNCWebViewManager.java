package com.reactnativecommunity.webview;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Environment;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.JavascriptInterface;
import android.webkit.PermissionRequest;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.autofill.HintConstants;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.ContentSizeChangeEvent;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.views.scroll.OnScrollDispatchHelper;
import com.facebook.react.views.scroll.ReactScrollViewHelper;
import com.facebook.react.views.scroll.ScrollEvent;
import com.facebook.react.views.scroll.ScrollEventType;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.reactnativecommunity.webview.RNCWebViewManager;
import com.reactnativecommunity.webview.events.TopHttpErrorEvent;
import com.reactnativecommunity.webview.events.TopLoadingErrorEvent;
import com.reactnativecommunity.webview.events.TopLoadingFinishEvent;
import com.reactnativecommunity.webview.events.TopLoadingProgressEvent;
import com.reactnativecommunity.webview.events.TopLoadingStartEvent;
import com.reactnativecommunity.webview.events.TopMessageEvent;
import com.reactnativecommunity.webview.events.TopRenderProcessGoneEvent;
import com.reactnativecommunity.webview.events.TopShouldStartLoadWithRequestEvent;
import com.stripe.android.core.networking.NetworkConstantsKt;
import com.stripe.android.core.networking.RequestHeadersFactory;
import com.stripe.android.model.PaymentMethodOptionsParams;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.i18n.MessageBundle;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name = "RNCWebView")
public class RNCWebViewManager extends SimpleViewManager<WebView> {
    protected static final String BLANK_URL = "about:blank";
    public static final int COMMAND_CLEAR_CACHE = 1001;
    public static final int COMMAND_CLEAR_FORM_DATA = 1000;
    public static final int COMMAND_CLEAR_HISTORY = 1002;
    public static final int COMMAND_FOCUS = 8;
    public static final int COMMAND_GO_BACK = 1;
    public static final int COMMAND_GO_FORWARD = 2;
    public static final int COMMAND_INJECT_JAVASCRIPT = 6;
    public static final int COMMAND_LOAD_URL = 7;
    public static final int COMMAND_POST_MESSAGE = 5;
    public static final int COMMAND_RELOAD = 3;
    public static final int COMMAND_STOP_LOADING = 4;
    protected static final String HTML_ENCODING = "UTF-8";
    protected static final String HTML_MIME_TYPE = "text/html";
    protected static final String HTTP_METHOD_POST = "POST";
    protected static final String JAVASCRIPT_INTERFACE = "ReactNativeWebView";
    protected static final String REACT_CLASS = "RNCWebView";
    protected static final int SHOULD_OVERRIDE_URL_LOADING_TIMEOUT = 250;
    private static final String TAG = "RNCWebViewManager";
    protected boolean mAllowsFullscreenVideo;
    protected String mUserAgent;
    protected String mUserAgentWithApplicationName;
    protected RNCWebChromeClient mWebChromeClient;
    protected WebViewConfig mWebViewConfig;

    public String getName() {
        return "RNCWebView";
    }

    public RNCWebViewManager() {
        this.mWebChromeClient = null;
        this.mAllowsFullscreenVideo = false;
        this.mUserAgent = null;
        this.mUserAgentWithApplicationName = null;
        this.mWebViewConfig = new WebViewConfig() {
            public void configWebView(WebView webView) {
            }
        };
    }

    public RNCWebViewManager(WebViewConfig webViewConfig) {
        this.mWebChromeClient = null;
        this.mAllowsFullscreenVideo = false;
        this.mUserAgent = null;
        this.mUserAgentWithApplicationName = null;
        this.mWebViewConfig = webViewConfig;
    }

    /* access modifiers changed from: protected */
    public RNCWebView createRNCWebViewInstance(ThemedReactContext themedReactContext) {
        return new RNCWebView(themedReactContext);
    }

    /* access modifiers changed from: protected */
    public WebView createViewInstance(final ThemedReactContext themedReactContext) {
        final RNCWebView createRNCWebViewInstance = createRNCWebViewInstance(themedReactContext);
        setupWebChromeClient(themedReactContext, createRNCWebViewInstance);
        themedReactContext.addLifecycleEventListener(createRNCWebViewInstance);
        this.mWebViewConfig.configWebView(createRNCWebViewInstance);
        WebSettings settings = createRNCWebViewInstance.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setDomStorageEnabled(true);
        settings.setSupportMultipleWindows(true);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            setAllowUniversalAccessFromFileURLs(createRNCWebViewInstance, false);
        }
        setMixedContentMode(createRNCWebViewInstance, ReactScrollViewHelper.OVER_SCROLL_NEVER);
        createRNCWebViewInstance.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        createRNCWebViewInstance.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                createRNCWebViewInstance.setIgnoreErrFailedForThisURL(str);
                RNCWebViewModule module = RNCWebViewManager.getModule(themedReactContext);
                try {
                    DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
                    String guessFileName = URLUtil.guessFileName(str, str3, str4);
                    String str5 = "Downloading " + guessFileName;
                    try {
                        URL url = new URL(str);
                        request.addRequestHeader(RequestHeadersFactory.FraudDetection.HEADER_COOKIE, CookieManager.getInstance().getCookie(url.getProtocol() + "://" + url.getHost()));
                    } catch (MalformedURLException e) {
                        Log.w(RNCWebViewManager.TAG, "Error getting cookie for DownloadManager", e);
                    }
                    request.addRequestHeader(NetworkConstantsKt.HEADER_USER_AGENT, str2);
                    request.setTitle(guessFileName);
                    request.setDescription(str5);
                    request.allowScanningByMediaScanner();
                    request.setNotificationVisibility(1);
                    request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, guessFileName);
                    module.setDownloadRequest(request);
                    if (module.grantFileDownloaderPermissions()) {
                        module.downloadFile();
                    }
                } catch (IllegalArgumentException e2) {
                    Log.w(RNCWebViewManager.TAG, "Unsupported URI, aborting download", e2);
                }
            }
        });
        return createRNCWebViewInstance;
    }

    @ReactProp(name = "javaScriptEnabled")
    public void setJavaScriptEnabled(WebView webView, boolean z) {
        webView.getSettings().setJavaScriptEnabled(z);
    }

    @ReactProp(name = "setBuiltInZoomControls")
    public void setBuiltInZoomControls(WebView webView, boolean z) {
        webView.getSettings().setBuiltInZoomControls(z);
    }

    @ReactProp(name = "setDisplayZoomControls")
    public void setDisplayZoomControls(WebView webView, boolean z) {
        webView.getSettings().setDisplayZoomControls(z);
    }

    @ReactProp(name = "setSupportMultipleWindows")
    public void setSupportMultipleWindows(WebView webView, boolean z) {
        webView.getSettings().setSupportMultipleWindows(z);
    }

    @ReactProp(name = "showsHorizontalScrollIndicator")
    public void setShowsHorizontalScrollIndicator(WebView webView, boolean z) {
        webView.setHorizontalScrollBarEnabled(z);
    }

    @ReactProp(name = "showsVerticalScrollIndicator")
    public void setShowsVerticalScrollIndicator(WebView webView, boolean z) {
        webView.setVerticalScrollBarEnabled(z);
    }

    @ReactProp(name = "cacheEnabled")
    public void setCacheEnabled(WebView webView, boolean z) {
        if (z) {
            Context context = webView.getContext();
            if (context != null) {
                webView.getSettings().setAppCachePath(context.getCacheDir().getAbsolutePath());
                webView.getSettings().setCacheMode(-1);
                webView.getSettings().setAppCacheEnabled(true);
                return;
            }
            return;
        }
        webView.getSettings().setCacheMode(2);
        webView.getSettings().setAppCacheEnabled(false);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "cacheMode")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setCacheMode(android.webkit.WebView r6, java.lang.String r7) {
        /*
            r5 = this;
            int r0 = r7.hashCode()
            r1 = 3
            r2 = -1
            r3 = 2
            r4 = 1
            switch(r0) {
                case -2059164003: goto L_0x002a;
                case -1215135800: goto L_0x0020;
                case -873877826: goto L_0x0016;
                case 1548620642: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0034
        L_0x000c:
            java.lang.String r0 = "LOAD_CACHE_ONLY"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0034
            r7 = 0
            goto L_0x0035
        L_0x0016:
            java.lang.String r0 = "LOAD_CACHE_ELSE_NETWORK"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0034
            r7 = 1
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "LOAD_DEFAULT"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0034
            r7 = 3
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "LOAD_NO_CACHE"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0034
            r7 = 2
            goto L_0x0035
        L_0x0034:
            r7 = -1
        L_0x0035:
            if (r7 == 0) goto L_0x004a
            if (r7 == r4) goto L_0x0045
            if (r7 == r3) goto L_0x0040
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)
            goto L_0x004e
        L_0x0040:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
            goto L_0x004e
        L_0x0045:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            goto L_0x004e
        L_0x004a:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r1)
        L_0x004e:
            android.webkit.WebSettings r6 = r6.getSettings()
            int r7 = r7.intValue()
            r6.setCacheMode(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.webview.RNCWebViewManager.setCacheMode(android.webkit.WebView, java.lang.String):void");
    }

    @ReactProp(name = "androidHardwareAccelerationDisabled")
    public void setHardwareAccelerationDisabled(WebView webView, boolean z) {
        if (z) {
            webView.setLayerType(1, (Paint) null);
        }
    }

    @ReactProp(name = "androidLayerType")
    public void setLayerType(WebView webView, String str) {
        str.hashCode();
        webView.setLayerType(!str.equals("hardware") ? !str.equals("software") ? 0 : 1 : 2, (Paint) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0044  */
    @com.facebook.react.uimanager.annotations.ReactProp(name = "overScrollMode")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setOverScrollMode(android.webkit.WebView r6, java.lang.String r7) {
        /*
            r5 = this;
            int r0 = r7.hashCode()
            r1 = -1414557169(0xffffffffabaf920f, float:-1.2475037E-12)
            r2 = 0
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L_0x002b
            r1 = 104712844(0x63dca8c, float:3.5695757E-35)
            if (r0 == r1) goto L_0x0021
            r1 = 951530617(0x38b73479, float:8.735894E-5)
            if (r0 == r1) goto L_0x0017
            goto L_0x0035
        L_0x0017:
            java.lang.String r0 = "content"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0035
            r7 = 1
            goto L_0x0036
        L_0x0021:
            java.lang.String r0 = "never"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0035
            r7 = 0
            goto L_0x0036
        L_0x002b:
            java.lang.String r0 = "always"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0035
            r7 = 2
            goto L_0x0036
        L_0x0035:
            r7 = -1
        L_0x0036:
            if (r7 == 0) goto L_0x0044
            if (r7 == r4) goto L_0x003f
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)
            goto L_0x0048
        L_0x003f:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            goto L_0x0048
        L_0x0044:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
        L_0x0048:
            int r7 = r7.intValue()
            r6.setOverScrollMode(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.webview.RNCWebViewManager.setOverScrollMode(android.webkit.WebView, java.lang.String):void");
    }

    @ReactProp(name = "nestedScrollEnabled")
    public void setNestedScrollEnabled(WebView webView, boolean z) {
        ((RNCWebView) webView).setNestedScrollEnabled(z);
    }

    @ReactProp(name = "thirdPartyCookiesEnabled")
    public void setThirdPartyCookiesEnabled(WebView webView, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, z);
        }
    }

    @ReactProp(name = "textZoom")
    public void setTextZoom(WebView webView, int i) {
        webView.getSettings().setTextZoom(i);
    }

    @ReactProp(name = "scalesPageToFit")
    public void setScalesPageToFit(WebView webView, boolean z) {
        webView.getSettings().setLoadWithOverviewMode(z);
        webView.getSettings().setUseWideViewPort(z);
    }

    @ReactProp(name = "domStorageEnabled")
    public void setDomStorageEnabled(WebView webView, boolean z) {
        webView.getSettings().setDomStorageEnabled(z);
    }

    @ReactProp(name = "userAgent")
    public void setUserAgent(WebView webView, String str) {
        if (str != null) {
            this.mUserAgent = str;
        } else {
            this.mUserAgent = null;
        }
        setUserAgentString(webView);
    }

    @ReactProp(name = "applicationNameForUserAgent")
    public void setApplicationNameForUserAgent(WebView webView, String str) {
        if (str == null) {
            this.mUserAgentWithApplicationName = null;
        } else if (Build.VERSION.SDK_INT >= 17) {
            String defaultUserAgent = WebSettings.getDefaultUserAgent(webView.getContext());
            this.mUserAgentWithApplicationName = defaultUserAgent + StringUtils.SPACE + str;
        }
        setUserAgentString(webView);
    }

    /* access modifiers changed from: protected */
    public void setUserAgentString(WebView webView) {
        if (this.mUserAgent != null) {
            webView.getSettings().setUserAgentString(this.mUserAgent);
        } else if (this.mUserAgentWithApplicationName != null) {
            webView.getSettings().setUserAgentString(this.mUserAgentWithApplicationName);
        } else if (Build.VERSION.SDK_INT >= 17) {
            webView.getSettings().setUserAgentString(WebSettings.getDefaultUserAgent(webView.getContext()));
        }
    }

    @ReactProp(name = "mediaPlaybackRequiresUserAction")
    public void setMediaPlaybackRequiresUserAction(WebView webView, boolean z) {
        webView.getSettings().setMediaPlaybackRequiresUserGesture(z);
    }

    @ReactProp(name = "javaScriptCanOpenWindowsAutomatically")
    public void setJavaScriptCanOpenWindowsAutomatically(WebView webView, boolean z) {
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
    }

    @ReactProp(name = "allowFileAccessFromFileURLs")
    public void setAllowFileAccessFromFileURLs(WebView webView, boolean z) {
        webView.getSettings().setAllowFileAccessFromFileURLs(z);
    }

    @ReactProp(name = "allowUniversalAccessFromFileURLs")
    public void setAllowUniversalAccessFromFileURLs(WebView webView, boolean z) {
        webView.getSettings().setAllowUniversalAccessFromFileURLs(z);
    }

    @ReactProp(name = "saveFormDataDisabled")
    public void setSaveFormDataDisabled(WebView webView, boolean z) {
        webView.getSettings().setSaveFormData(!z);
    }

    @ReactProp(name = "injectedJavaScript")
    public void setInjectedJavaScript(WebView webView, String str) {
        ((RNCWebView) webView).setInjectedJavaScript(str);
    }

    @ReactProp(name = "injectedJavaScriptBeforeContentLoaded")
    public void setInjectedJavaScriptBeforeContentLoaded(WebView webView, String str) {
        ((RNCWebView) webView).setInjectedJavaScriptBeforeContentLoaded(str);
    }

    @ReactProp(name = "injectedJavaScriptForMainFrameOnly")
    public void setInjectedJavaScriptForMainFrameOnly(WebView webView, boolean z) {
        ((RNCWebView) webView).setInjectedJavaScriptForMainFrameOnly(z);
    }

    @ReactProp(name = "injectedJavaScriptBeforeContentLoadedForMainFrameOnly")
    public void setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(WebView webView, boolean z) {
        ((RNCWebView) webView).setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(z);
    }

    @ReactProp(name = "messagingEnabled")
    public void setMessagingEnabled(WebView webView, boolean z) {
        ((RNCWebView) webView).setMessagingEnabled(z);
    }

    @ReactProp(name = "messagingModuleName")
    public void setMessagingModuleName(WebView webView, String str) {
        ((RNCWebView) webView).setMessagingModuleName(str);
    }

    @ReactProp(name = "incognito")
    public void setIncognito(WebView webView, boolean z) {
        if (z) {
            if (Build.VERSION.SDK_INT >= 21) {
                CookieManager.getInstance().removeAllCookies((ValueCallback) null);
            } else {
                CookieManager.getInstance().removeAllCookie();
            }
            webView.getSettings().setCacheMode(2);
            webView.getSettings().setAppCacheEnabled(false);
            webView.clearHistory();
            webView.clearCache(true);
            webView.clearFormData();
            webView.getSettings().setSavePassword(false);
            webView.getSettings().setSaveFormData(false);
        }
    }

    @ReactProp(name = "source")
    public void setSource(WebView webView, ReadableMap readableMap) {
        if (readableMap != null) {
            if (readableMap.hasKey("html")) {
                webView.loadDataWithBaseURL(readableMap.hasKey("baseUrl") ? readableMap.getString("baseUrl") : "", readableMap.getString("html"), HTML_MIME_TYPE, "UTF-8", (String) null);
                return;
            } else if (readableMap.hasKey("uri")) {
                String string = readableMap.getString("uri");
                String url = webView.getUrl();
                if (url != null && url.equals(string)) {
                    return;
                }
                if (!readableMap.hasKey(FirebaseAnalytics.Param.METHOD) || !readableMap.getString(FirebaseAnalytics.Param.METHOD).equalsIgnoreCase("POST")) {
                    HashMap hashMap = new HashMap();
                    if (readableMap.hasKey("headers")) {
                        ReadableMap map = readableMap.getMap("headers");
                        ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
                        while (keySetIterator.hasNextKey()) {
                            String nextKey = keySetIterator.nextKey();
                            if (!"user-agent".equals(nextKey.toLowerCase(Locale.ENGLISH))) {
                                hashMap.put(nextKey, map.getString(nextKey));
                            } else if (webView.getSettings() != null) {
                                webView.getSettings().setUserAgentString(map.getString(nextKey));
                            }
                        }
                    }
                    webView.loadUrl(string, hashMap);
                    return;
                }
                byte[] bArr = null;
                if (readableMap.hasKey("body")) {
                    String string2 = readableMap.getString("body");
                    try {
                        bArr = string2.getBytes("UTF-8");
                    } catch (UnsupportedEncodingException unused) {
                        bArr = string2.getBytes();
                    }
                }
                if (bArr == null) {
                    bArr = new byte[0];
                }
                webView.postUrl(string, bArr);
                return;
            }
        }
        webView.loadUrl("about:blank");
    }

    @ReactProp(name = "basicAuthCredential")
    public void setBasicAuthCredential(WebView webView, ReadableMap readableMap) {
        ((RNCWebView) webView).setBasicAuthCredential((readableMap == null || !readableMap.hasKey(HintConstants.AUTOFILL_HINT_USERNAME) || !readableMap.hasKey(HintConstants.AUTOFILL_HINT_PASSWORD)) ? null : new BasicAuthCredential(readableMap.getString(HintConstants.AUTOFILL_HINT_USERNAME), readableMap.getString(HintConstants.AUTOFILL_HINT_PASSWORD)));
    }

    @ReactProp(name = "onContentSizeChange")
    public void setOnContentSizeChange(WebView webView, boolean z) {
        ((RNCWebView) webView).setSendContentSizeChangeEvents(z);
    }

    @ReactProp(name = "mixedContentMode")
    public void setMixedContentMode(WebView webView, String str) {
        if (Build.VERSION.SDK_INT < 21) {
            return;
        }
        if (str == null || ReactScrollViewHelper.OVER_SCROLL_NEVER.equals(str)) {
            webView.getSettings().setMixedContentMode(1);
        } else if (ReactScrollViewHelper.OVER_SCROLL_ALWAYS.equals(str)) {
            webView.getSettings().setMixedContentMode(0);
        } else if ("compatibility".equals(str)) {
            webView.getSettings().setMixedContentMode(2);
        }
    }

    @ReactProp(name = "urlPrefixesForDefaultIntent")
    public void setUrlPrefixesForDefaultIntent(WebView webView, ReadableArray readableArray) {
        RNCWebViewClient rNCWebViewClient = ((RNCWebView) webView).getRNCWebViewClient();
        if (rNCWebViewClient != null && readableArray != null) {
            rNCWebViewClient.setUrlPrefixesForDefaultIntent(readableArray);
        }
    }

    @ReactProp(name = "allowsFullscreenVideo")
    public void setAllowsFullscreenVideo(WebView webView, Boolean bool) {
        this.mAllowsFullscreenVideo = bool != null && bool.booleanValue();
        setupWebChromeClient((ReactContext) webView.getContext(), webView);
    }

    @ReactProp(name = "allowFileAccess")
    public void setAllowFileAccess(WebView webView, Boolean bool) {
        webView.getSettings().setAllowFileAccess(bool != null && bool.booleanValue());
    }

    @ReactProp(name = "geolocationEnabled")
    public void setGeolocationEnabled(WebView webView, Boolean bool) {
        webView.getSettings().setGeolocationEnabled(bool != null && bool.booleanValue());
    }

    @ReactProp(name = "onScroll")
    public void setOnScroll(WebView webView, boolean z) {
        ((RNCWebView) webView).setHasScrollEvent(z);
    }

    @ReactProp(name = "forceDarkOn")
    public void setForceDarkOn(WebView webView, boolean z) {
        if (Build.VERSION.SDK_INT > 28) {
            if (WebViewFeature.isFeatureSupported("FORCE_DARK")) {
                WebSettingsCompat.setForceDark(webView.getSettings(), z ? 2 : 0);
            }
            if (z && WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK_STRATEGY)) {
                WebSettingsCompat.setForceDarkStrategy(webView.getSettings(), 2);
            }
        }
    }

    @ReactProp(name = "minimumFontSize")
    public void setMinimumFontSize(WebView webView, int i) {
        webView.getSettings().setMinimumFontSize(i);
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(ThemedReactContext themedReactContext, WebView webView) {
        webView.setWebViewClient(new RNCWebViewClient());
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        Map exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = MapBuilder.newHashMap();
        }
        exportedCustomDirectEventTypeConstants.put(TopLoadingProgressEvent.EVENT_NAME, MapBuilder.of("registrationName", "onLoadingProgress"));
        exportedCustomDirectEventTypeConstants.put(TopShouldStartLoadWithRequestEvent.EVENT_NAME, MapBuilder.of("registrationName", "onShouldStartLoadWithRequest"));
        exportedCustomDirectEventTypeConstants.put(ScrollEventType.getJSEventName(ScrollEventType.SCROLL), MapBuilder.of("registrationName", "onScroll"));
        exportedCustomDirectEventTypeConstants.put(TopHttpErrorEvent.EVENT_NAME, MapBuilder.of("registrationName", "onHttpError"));
        exportedCustomDirectEventTypeConstants.put(TopRenderProcessGoneEvent.EVENT_NAME, MapBuilder.of("registrationName", "onRenderProcessGone"));
        return exportedCustomDirectEventTypeConstants;
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.builder().put("goBack", 1).put("goForward", 2).put("reload", 3).put("stopLoading", 4).put("postMessage", 5).put("injectJavaScript", 6).put("loadUrl", 7).put("requestFocus", 8).put("clearFormData", 1000).put("clearCache", 1001).put("clearHistory", 1002).build();
    }

    public void receiveCommand(WebView webView, int i, ReadableArray readableArray) {
        boolean z = false;
        switch (i) {
            case 1:
                webView.goBack();
                return;
            case 2:
                webView.goForward();
                return;
            case 3:
                webView.reload();
                return;
            case 4:
                webView.stopLoading();
                return;
            case 5:
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("data", readableArray.getString(0));
                    ((RNCWebView) webView).evaluateJavascriptWithFallback("(function () {var event;var data = " + jSONObject.toString() + ";try {event = new MessageEvent('message', data);} catch (e) {event = document.createEvent('MessageEvent');event.initMessageEvent('message', true, true, data.data, data.origin, data.lastEventId, data.source);}document.dispatchEvent(event);})();");
                    return;
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            case 6:
                ((RNCWebView) webView).evaluateJavascriptWithFallback(readableArray.getString(0));
                return;
            case 7:
                if (readableArray != null) {
                    ((RNCWebView) webView).progressChangedFilter.setWaitingForCommandLoadUrl(false);
                    webView.loadUrl(readableArray.getString(0));
                    return;
                }
                throw new RuntimeException("Arguments for loading an url are null!");
            case 8:
                webView.requestFocus();
                return;
            default:
                switch (i) {
                    case 1000:
                        webView.clearFormData();
                        return;
                    case 1001:
                        if (readableArray != null && readableArray.getBoolean(0)) {
                            z = true;
                        }
                        webView.clearCache(z);
                        return;
                    case 1002:
                        webView.clearHistory();
                        return;
                    default:
                        return;
                }
        }
    }

    public void onDropViewInstance(WebView webView) {
        super.onDropViewInstance(webView);
        RNCWebView rNCWebView = (RNCWebView) webView;
        ((ThemedReactContext) webView.getContext()).removeLifecycleEventListener(rNCWebView);
        rNCWebView.cleanupCallbacksAndDestroy();
        this.mWebChromeClient = null;
    }

    public static RNCWebViewModule getModule(ReactContext reactContext) {
        return (RNCWebViewModule) reactContext.getNativeModule(RNCWebViewModule.class);
    }

    /* access modifiers changed from: protected */
    public void setupWebChromeClient(ReactContext reactContext, WebView webView) {
        final Activity currentActivity = reactContext.getCurrentActivity();
        if (!this.mAllowsFullscreenVideo || currentActivity == null) {
            RNCWebChromeClient rNCWebChromeClient = this.mWebChromeClient;
            if (rNCWebChromeClient != null) {
                rNCWebChromeClient.onHideCustomView();
            }
            AnonymousClass4 r0 = new RNCWebChromeClient(reactContext, webView) {
                public Bitmap getDefaultVideoPoster() {
                    return Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
                }
            };
            this.mWebChromeClient = r0;
            webView.setWebChromeClient(r0);
            return;
        }
        final int requestedOrientation = currentActivity.getRequestedOrientation();
        AnonymousClass3 r02 = new RNCWebChromeClient(reactContext, webView) {
            public Bitmap getDefaultVideoPoster() {
                return Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
            }

            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                if (this.mVideoView != null) {
                    customViewCallback.onCustomViewHidden();
                    return;
                }
                this.mVideoView = view;
                this.mCustomViewCallback = customViewCallback;
                currentActivity.setRequestedOrientation(-1);
                if (Build.VERSION.SDK_INT >= 19) {
                    this.mVideoView.setSystemUiVisibility(7942);
                    currentActivity.getWindow().setFlags(512, 512);
                }
                this.mVideoView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                ViewGroup rootView = getRootView();
                rootView.addView(this.mVideoView, FULLSCREEN_LAYOUT_PARAMS);
                if (rootView.getRootView() != this.mWebView.getRootView()) {
                    this.mWebView.getRootView().setVisibility(8);
                } else {
                    this.mWebView.setVisibility(8);
                }
                this.mReactContext.addLifecycleEventListener(this);
            }

            public void onHideCustomView() {
                if (this.mVideoView != null) {
                    ViewGroup rootView = getRootView();
                    if (rootView.getRootView() != this.mWebView.getRootView()) {
                        this.mWebView.getRootView().setVisibility(0);
                    } else {
                        this.mWebView.setVisibility(0);
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        currentActivity.getWindow().clearFlags(512);
                    }
                    rootView.removeView(this.mVideoView);
                    this.mCustomViewCallback.onCustomViewHidden();
                    this.mVideoView = null;
                    this.mCustomViewCallback = null;
                    currentActivity.setRequestedOrientation(requestedOrientation);
                    this.mReactContext.removeLifecycleEventListener(this);
                }
            }
        };
        this.mWebChromeClient = r02;
        webView.setWebChromeClient(r02);
    }

    protected static class RNCWebViewClient extends WebViewClient {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        protected BasicAuthCredential basicAuthCredential = null;
        protected String ignoreErrFailedForThisURL = null;
        protected boolean mLastLoadFailed = false;
        protected ReadableArray mUrlPrefixesForDefaultIntent;
        protected RNCWebView.ProgressChangedFilter progressChangedFilter = null;

        static {
            Class<RNCWebViewManager> cls = RNCWebViewManager.class;
        }

        protected RNCWebViewClient() {
        }

        public void setIgnoreErrFailedForThisURL(String str) {
            this.ignoreErrFailedForThisURL = str;
        }

        public void setBasicAuthCredential(BasicAuthCredential basicAuthCredential2) {
            this.basicAuthCredential = basicAuthCredential2;
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (!this.mLastLoadFailed) {
                ((RNCWebView) webView).callInjectedJavaScript();
                emitFinishEvent(webView, str);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            this.mLastLoadFailed = false;
            RNCWebView rNCWebView = (RNCWebView) webView;
            rNCWebView.callInjectedJavaScriptBeforeContentLoaded();
            rNCWebView.dispatchEvent(webView, new TopLoadingStartEvent(webView.getId(), createWebViewEvent(webView, str)));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0077, code lost:
            if (r1.get() != com.reactnativecommunity.webview.RNCWebViewModule.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.SHOULD_OVERRIDE) goto L_0x007a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x007a, code lost:
            r3 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x007b, code lost:
            com.reactnativecommunity.webview.RNCWebViewModule.shouldOverrideUrlLoadingLock.removeLock(java.lang.Integer.valueOf(r2));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0084, code lost:
            return r3;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean shouldOverrideUrlLoading(android.webkit.WebView r10, java.lang.String r11) {
            /*
                r9 = this;
                r0 = r10
                com.reactnativecommunity.webview.RNCWebViewManager$RNCWebView r0 = (com.reactnativecommunity.webview.RNCWebViewManager.RNCWebView) r0
                android.content.Context r1 = r10.getContext()
                com.facebook.react.bridge.ReactContext r1 = (com.facebook.react.bridge.ReactContext) r1
                com.facebook.react.bridge.JavaScriptContextHolder r1 = r1.getJavaScriptContextHolder()
                long r1 = r1.get()
                r3 = 1
                r4 = 0
                r5 = 0
                int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
                if (r7 != 0) goto L_0x001b
                r1 = 1
                goto L_0x001c
            L_0x001b:
                r1 = 0
            L_0x001c:
                if (r1 != 0) goto L_0x009a
                com.facebook.react.bridge.CatalystInstance r1 = r0.mCatalystInstance
                if (r1 == 0) goto L_0x009a
                com.reactnativecommunity.webview.RNCWebViewModule$ShouldOverrideUrlLoadingLock r1 = com.reactnativecommunity.webview.RNCWebViewModule.shouldOverrideUrlLoadingLock
                androidx.core.util.Pair r1 = r1.getNewLock()
                F r2 = r1.first
                java.lang.Integer r2 = (java.lang.Integer) r2
                int r2 = r2.intValue()
                S r1 = r1.second
                java.util.concurrent.atomic.AtomicReference r1 = (java.util.concurrent.atomic.AtomicReference) r1
                com.facebook.react.bridge.WritableMap r10 = r9.createWebViewEvent(r10, r11)
                java.lang.String r11 = "lockIdentifier"
                r10.putInt(r11, r2)
                java.lang.String r11 = "onShouldStartLoadWithRequest"
                r0.sendDirectMessage(r11, r10)
                monitor-enter(r1)     // Catch:{ InterruptedException -> 0x0088 }
                long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0085 }
            L_0x0047:
                java.lang.Object r0 = r1.get()     // Catch:{ all -> 0x0085 }
                com.reactnativecommunity.webview.RNCWebViewModule$ShouldOverrideUrlLoadingLock$ShouldOverrideCallbackState r5 = com.reactnativecommunity.webview.RNCWebViewModule.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.UNDECIDED     // Catch:{ all -> 0x0085 }
                if (r0 != r5) goto L_0x0070
                long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0085 }
                long r5 = r5 - r10
                r7 = 250(0xfa, double:1.235E-321)
                int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r0 <= 0) goto L_0x006c
                java.lang.String r10 = "RNCWebViewManager"
                java.lang.String r11 = "Did not receive response to shouldOverrideUrlLoading in time, defaulting to allow loading."
                com.facebook.common.logging.FLog.w((java.lang.String) r10, (java.lang.String) r11)     // Catch:{ all -> 0x0085 }
                com.reactnativecommunity.webview.RNCWebViewModule$ShouldOverrideUrlLoadingLock r10 = com.reactnativecommunity.webview.RNCWebViewModule.shouldOverrideUrlLoadingLock     // Catch:{ all -> 0x0085 }
                java.lang.Integer r11 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0085 }
                r10.removeLock(r11)     // Catch:{ all -> 0x0085 }
                monitor-exit(r1)     // Catch:{ all -> 0x0085 }
                return r4
            L_0x006c:
                r1.wait(r7)     // Catch:{ all -> 0x0085 }
                goto L_0x0047
            L_0x0070:
                monitor-exit(r1)     // Catch:{ all -> 0x0085 }
                java.lang.Object r10 = r1.get()
                com.reactnativecommunity.webview.RNCWebViewModule$ShouldOverrideUrlLoadingLock$ShouldOverrideCallbackState r11 = com.reactnativecommunity.webview.RNCWebViewModule.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.SHOULD_OVERRIDE
                if (r10 != r11) goto L_0x007a
                goto L_0x007b
            L_0x007a:
                r3 = 0
            L_0x007b:
                com.reactnativecommunity.webview.RNCWebViewModule$ShouldOverrideUrlLoadingLock r10 = com.reactnativecommunity.webview.RNCWebViewModule.shouldOverrideUrlLoadingLock
                java.lang.Integer r11 = java.lang.Integer.valueOf(r2)
                r10.removeLock(r11)
                return r3
            L_0x0085:
                r10 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0085 }
                throw r10     // Catch:{ InterruptedException -> 0x0088 }
            L_0x0088:
                r10 = move-exception
                java.lang.String r11 = "RNCWebViewManager"
                java.lang.String r0 = "shouldOverrideUrlLoading was interrupted while waiting for result."
                com.facebook.common.logging.FLog.e((java.lang.String) r11, (java.lang.String) r0, (java.lang.Throwable) r10)
                com.reactnativecommunity.webview.RNCWebViewModule$ShouldOverrideUrlLoadingLock r10 = com.reactnativecommunity.webview.RNCWebViewModule.shouldOverrideUrlLoadingLock
                java.lang.Integer r11 = java.lang.Integer.valueOf(r2)
                r10.removeLock(r11)
                return r4
            L_0x009a:
                java.lang.String r1 = "RNCWebViewManager"
                java.lang.String r2 = "Couldn't use blocking synchronous call for onShouldStartLoadWithRequest due to debugging or missing Catalyst instance, falling back to old event-and-load."
                com.facebook.common.logging.FLog.w((java.lang.String) r1, (java.lang.String) r2)
                com.reactnativecommunity.webview.RNCWebViewManager$RNCWebView$ProgressChangedFilter r1 = r9.progressChangedFilter
                r1.setWaitingForCommandLoadUrl(r3)
                com.reactnativecommunity.webview.events.TopShouldStartLoadWithRequestEvent r1 = new com.reactnativecommunity.webview.events.TopShouldStartLoadWithRequestEvent
                int r2 = r10.getId()
                com.facebook.react.bridge.WritableMap r11 = r9.createWebViewEvent(r10, r11)
                r1.<init>(r2, r11)
                r0.dispatchEvent(r10, r1)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.webview.RNCWebViewManager.RNCWebViewClient.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
        }

        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            BasicAuthCredential basicAuthCredential2 = this.basicAuthCredential;
            if (basicAuthCredential2 != null) {
                httpAuthHandler.proceed(basicAuthCredential2.username, this.basicAuthCredential.password);
            } else {
                super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String url = webView.getUrl();
            String url2 = sslError.getUrl();
            sslErrorHandler.cancel();
            if (!url.equalsIgnoreCase(url2)) {
                Log.w(RNCWebViewManager.TAG, "Resource blocked from loading due to SSL error. Blocked URL: " + url2);
                return;
            }
            int primaryError = sslError.getPrimaryError();
            String str = primaryError != 0 ? primaryError != 1 ? primaryError != 2 ? primaryError != 3 ? primaryError != 4 ? primaryError != 5 ? "Unknown SSL Error" : "A generic error occurred" : "The date of the certificate is invalid" : "The certificate authority is not trusted" : "Hostname mismatch" : "The certificate has expired" : "The certificate is not yet valid";
            onReceivedError(webView, primaryError, "SSL error: " + str, url2);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            String str3 = this.ignoreErrFailedForThisURL;
            if (str3 == null || !str2.equals(str3) || i != -1 || !str.equals("net::ERR_FAILED")) {
                super.onReceivedError(webView, i, str, str2);
                this.mLastLoadFailed = true;
                emitFinishEvent(webView, str2);
                WritableMap createWebViewEvent = createWebViewEvent(webView, str2);
                createWebViewEvent.putDouble(PaymentMethodOptionsParams.Blik.PARAM_CODE, (double) i);
                createWebViewEvent.putString("description", str);
                ((RNCWebView) webView).dispatchEvent(webView, new TopLoadingErrorEvent(webView.getId(), createWebViewEvent));
                return;
            }
            setIgnoreErrFailedForThisURL((String) null);
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (webResourceRequest.isForMainFrame()) {
                WritableMap createWebViewEvent = createWebViewEvent(webView, webResourceRequest.getUrl().toString());
                createWebViewEvent.putInt("statusCode", webResourceResponse.getStatusCode());
                createWebViewEvent.putString("description", webResourceResponse.getReasonPhrase());
                ((RNCWebView) webView).dispatchEvent(webView, new TopHttpErrorEvent(webView.getId(), createWebViewEvent));
            }
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            if (Build.VERSION.SDK_INT < 26) {
                return false;
            }
            super.onRenderProcessGone(webView, renderProcessGoneDetail);
            if (renderProcessGoneDetail.didCrash()) {
                Log.e(RNCWebViewManager.TAG, "The WebView rendering process crashed.");
            } else {
                Log.w(RNCWebViewManager.TAG, "The WebView rendering process was killed by the system.");
            }
            if (webView == null) {
                return true;
            }
            WritableMap createWebViewEvent = createWebViewEvent(webView, webView.getUrl());
            createWebViewEvent.putBoolean("didCrash", renderProcessGoneDetail.didCrash());
            ((RNCWebView) webView).dispatchEvent(webView, new TopRenderProcessGoneEvent(webView.getId(), createWebViewEvent));
            return true;
        }

        /* access modifiers changed from: protected */
        public void emitFinishEvent(WebView webView, String str) {
            ((RNCWebView) webView).dispatchEvent(webView, new TopLoadingFinishEvent(webView.getId(), createWebViewEvent(webView, str)));
        }

        /* access modifiers changed from: protected */
        public WritableMap createWebViewEvent(WebView webView, String str) {
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("target", (double) webView.getId());
            createMap.putString("url", str);
            createMap.putBoolean("loading", !this.mLastLoadFailed && webView.getProgress() != 100);
            createMap.putString(MessageBundle.TITLE_ENTRY, webView.getTitle());
            createMap.putBoolean("canGoBack", webView.canGoBack());
            createMap.putBoolean("canGoForward", webView.canGoForward());
            return createMap;
        }

        public void setUrlPrefixesForDefaultIntent(ReadableArray readableArray) {
            this.mUrlPrefixesForDefaultIntent = readableArray;
        }

        public void setProgressChangedFilter(RNCWebView.ProgressChangedFilter progressChangedFilter2) {
            this.progressChangedFilter = progressChangedFilter2;
        }
    }

    protected static class RNCWebChromeClient extends WebChromeClient implements LifecycleEventListener {
        protected static final int COMMON_PERMISSION_REQUEST = 3;
        protected static final FrameLayout.LayoutParams FULLSCREEN_LAYOUT_PARAMS = new FrameLayout.LayoutParams(-1, -1, 17);
        protected static final int FULLSCREEN_SYSTEM_UI_VISIBILITY = 7942;
        protected GeolocationPermissions.Callback geolocationPermissionCallback;
        protected String geolocationPermissionOrigin;
        protected List<String> grantedPermissions;
        protected WebChromeClient.CustomViewCallback mCustomViewCallback;
        protected ReactContext mReactContext;
        protected View mVideoView;
        protected View mWebView;
        protected List<String> pendingPermissions = new ArrayList();
        protected PermissionRequest permissionRequest;
        protected boolean permissionsRequestShown = false;
        protected RNCWebView.ProgressChangedFilter progressChangedFilter = null;
        private PermissionListener webviewPermissionsListener = new PermissionListener() {
            public final boolean onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                return RNCWebViewManager.RNCWebChromeClient.this.lambda$new$0$RNCWebViewManager$RNCWebChromeClient(i, strArr, iArr);
            }
        };

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return true;
        }

        public void onHostDestroy() {
        }

        public void onHostPause() {
        }

        public RNCWebChromeClient(ReactContext reactContext, WebView webView) {
            this.mReactContext = reactContext;
            this.mWebView = webView;
        }

        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            ((WebView.WebViewTransport) message.obj).setWebView(new WebView(webView.getContext()));
            message.sendToTarget();
            return true;
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            String url = webView.getUrl();
            if (!this.progressChangedFilter.isWaitingForCommandLoadUrl()) {
                WritableMap createMap = Arguments.createMap();
                createMap.putDouble("target", (double) webView.getId());
                createMap.putString(MessageBundle.TITLE_ENTRY, webView.getTitle());
                createMap.putString("url", url);
                createMap.putBoolean("canGoBack", webView.canGoBack());
                createMap.putBoolean("canGoForward", webView.canGoForward());
                createMap.putDouble("progress", (double) (((float) i) / 100.0f));
                ((RNCWebView) webView).dispatchEvent(webView, new TopLoadingProgressEvent(webView.getId(), createMap));
            }
        }

        public void onPermissionRequest(PermissionRequest permissionRequest2) {
            this.grantedPermissions = new ArrayList();
            ArrayList arrayList = new ArrayList();
            String[] resources = permissionRequest2.getResources();
            int length = resources.length;
            int i = 0;
            while (true) {
                String str = null;
                if (i >= length) {
                    break;
                }
                String str2 = resources[i];
                if (str2.equals("android.webkit.resource.AUDIO_CAPTURE")) {
                    str = "android.permission.RECORD_AUDIO";
                } else if (str2.equals("android.webkit.resource.VIDEO_CAPTURE")) {
                    str = "android.permission.CAMERA";
                } else if (str2.equals("android.webkit.resource.PROTECTED_MEDIA_ID")) {
                    str = "android.webkit.resource.PROTECTED_MEDIA_ID";
                }
                if (str != null) {
                    if (ContextCompat.checkSelfPermission(this.mReactContext, str) == 0) {
                        this.grantedPermissions.add(str2);
                    } else {
                        arrayList.add(str);
                    }
                }
                i++;
            }
            if (arrayList.isEmpty()) {
                permissionRequest2.grant((String[]) this.grantedPermissions.toArray(new String[0]));
                this.grantedPermissions = null;
                return;
            }
            this.permissionRequest = permissionRequest2;
            requestPermissions(arrayList);
        }

        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            if (ContextCompat.checkSelfPermission(this.mReactContext, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                this.geolocationPermissionCallback = callback;
                this.geolocationPermissionOrigin = str;
                requestPermissions(Collections.singletonList("android.permission.ACCESS_FINE_LOCATION"));
                return;
            }
            callback.invoke(str, true, false);
        }

        private PermissionAwareActivity getPermissionAwareActivity() {
            Activity currentActivity = this.mReactContext.getCurrentActivity();
            if (currentActivity == null) {
                throw new IllegalStateException("Tried to use permissions API while not attached to an Activity.");
            } else if (currentActivity instanceof PermissionAwareActivity) {
                return (PermissionAwareActivity) currentActivity;
            } else {
                throw new IllegalStateException("Tried to use permissions API but the host Activity doesn't implement PermissionAwareActivity.");
            }
        }

        private synchronized void requestPermissions(List<String> list) {
            if (this.permissionsRequestShown) {
                this.pendingPermissions.addAll(list);
                return;
            }
            PermissionAwareActivity permissionAwareActivity = getPermissionAwareActivity();
            this.permissionsRequestShown = true;
            permissionAwareActivity.requestPermissions((String[]) list.toArray(new String[0]), 3, this.webviewPermissionsListener);
            this.pendingPermissions.clear();
        }

        public /* synthetic */ boolean lambda$new$0$RNCWebViewManager$RNCWebChromeClient(int i, String[] strArr, int[] iArr) {
            PermissionRequest permissionRequest2;
            List<String> list;
            List<String> list2;
            List<String> list3;
            List<String> list4;
            GeolocationPermissions.Callback callback;
            String str;
            this.permissionsRequestShown = false;
            boolean z = false;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                String str2 = strArr[i2];
                boolean z2 = iArr[i2] == 0;
                if (!(!str2.equals("android.permission.ACCESS_FINE_LOCATION") || (callback = this.geolocationPermissionCallback) == null || (str = this.geolocationPermissionOrigin) == null)) {
                    if (z2) {
                        callback.invoke(str, true, false);
                    } else {
                        callback.invoke(str, false, false);
                    }
                    this.geolocationPermissionCallback = null;
                    this.geolocationPermissionOrigin = null;
                }
                if (str2.equals("android.permission.RECORD_AUDIO")) {
                    if (z2 && (list4 = this.grantedPermissions) != null) {
                        list4.add("android.webkit.resource.AUDIO_CAPTURE");
                    }
                    z = true;
                }
                if (str2.equals("android.permission.CAMERA")) {
                    if (z2 && (list3 = this.grantedPermissions) != null) {
                        list3.add("android.webkit.resource.VIDEO_CAPTURE");
                    }
                    z = true;
                }
                if (str2.equals("android.webkit.resource.PROTECTED_MEDIA_ID")) {
                    if (z2 && (list2 = this.grantedPermissions) != null) {
                        list2.add("android.webkit.resource.PROTECTED_MEDIA_ID");
                    }
                    z = true;
                }
            }
            if (!(!z || (permissionRequest2 = this.permissionRequest) == null || (list = this.grantedPermissions) == null)) {
                permissionRequest2.grant((String[]) list.toArray(new String[0]));
                this.permissionRequest = null;
                this.grantedPermissions = null;
            }
            if (this.pendingPermissions.isEmpty()) {
                return true;
            }
            requestPermissions(this.pendingPermissions);
            return false;
        }

        /* access modifiers changed from: protected */
        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            RNCWebViewManager.getModule(this.mReactContext).startPhotoPickerIntent(valueCallback, str);
        }

        /* access modifiers changed from: protected */
        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            RNCWebViewManager.getModule(this.mReactContext).startPhotoPickerIntent(valueCallback, "");
        }

        /* access modifiers changed from: protected */
        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            RNCWebViewManager.getModule(this.mReactContext).startPhotoPickerIntent(valueCallback, str);
        }

        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            String[] acceptTypes = fileChooserParams.getAcceptTypes();
            boolean z = true;
            if (fileChooserParams.getMode() != 1) {
                z = false;
            }
            return RNCWebViewManager.getModule(this.mReactContext).startPhotoPickerIntent(valueCallback, acceptTypes, z);
        }

        public void onHostResume() {
            View view;
            if (Build.VERSION.SDK_INT >= 19 && (view = this.mVideoView) != null && view.getSystemUiVisibility() != FULLSCREEN_SYSTEM_UI_VISIBILITY) {
                this.mVideoView.setSystemUiVisibility(FULLSCREEN_SYSTEM_UI_VISIBILITY);
            }
        }

        /* access modifiers changed from: protected */
        public ViewGroup getRootView() {
            return (ViewGroup) this.mReactContext.getCurrentActivity().findViewById(16908290);
        }

        public void setProgressChangedFilter(RNCWebView.ProgressChangedFilter progressChangedFilter2) {
            this.progressChangedFilter = progressChangedFilter2;
        }
    }

    protected static class RNCWebView extends WebView implements LifecycleEventListener {
        protected boolean hasScrollEvent = false;
        protected String injectedJS;
        protected String injectedJSBeforeContentLoaded;
        protected boolean injectedJavaScriptBeforeContentLoadedForMainFrameOnly = true;
        protected boolean injectedJavaScriptForMainFrameOnly = true;
        protected CatalystInstance mCatalystInstance;
        private OnScrollDispatchHelper mOnScrollDispatchHelper;
        protected RNCWebViewClient mRNCWebViewClient;
        WebChromeClient mWebChromeClient;
        protected boolean messagingEnabled = false;
        protected String messagingModuleName;
        protected boolean nestedScrollEnabled = false;
        protected ProgressChangedFilter progressChangedFilter;
        protected boolean sendContentSizeChangeEvents = false;

        public void onHostPause() {
        }

        public void onHostResume() {
        }

        public RNCWebView(ThemedReactContext themedReactContext) {
            super(themedReactContext);
            createCatalystInstance();
            this.progressChangedFilter = new ProgressChangedFilter();
        }

        public void setIgnoreErrFailedForThisURL(String str) {
            this.mRNCWebViewClient.setIgnoreErrFailedForThisURL(str);
        }

        public void setBasicAuthCredential(BasicAuthCredential basicAuthCredential) {
            this.mRNCWebViewClient.setBasicAuthCredential(basicAuthCredential);
        }

        public void setSendContentSizeChangeEvents(boolean z) {
            this.sendContentSizeChangeEvents = z;
        }

        public void setHasScrollEvent(boolean z) {
            this.hasScrollEvent = z;
        }

        public void setNestedScrollEnabled(boolean z) {
            this.nestedScrollEnabled = z;
        }

        public void onHostDestroy() {
            cleanupCallbacksAndDestroy();
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (this.nestedScrollEnabled) {
                requestDisallowInterceptTouchEvent(true);
            }
            return super.onTouchEvent(motionEvent);
        }

        /* access modifiers changed from: protected */
        public void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            if (this.sendContentSizeChangeEvents) {
                dispatchEvent(this, new ContentSizeChangeEvent(getId(), i, i2));
            }
        }

        public void setWebViewClient(WebViewClient webViewClient) {
            super.setWebViewClient(webViewClient);
            if (webViewClient instanceof RNCWebViewClient) {
                RNCWebViewClient rNCWebViewClient = (RNCWebViewClient) webViewClient;
                this.mRNCWebViewClient = rNCWebViewClient;
                rNCWebViewClient.setProgressChangedFilter(this.progressChangedFilter);
            }
        }

        public void setWebChromeClient(WebChromeClient webChromeClient) {
            this.mWebChromeClient = webChromeClient;
            super.setWebChromeClient(webChromeClient);
            if (webChromeClient instanceof RNCWebChromeClient) {
                ((RNCWebChromeClient) webChromeClient).setProgressChangedFilter(this.progressChangedFilter);
            }
        }

        public RNCWebViewClient getRNCWebViewClient() {
            return this.mRNCWebViewClient;
        }

        public void setInjectedJavaScript(String str) {
            this.injectedJS = str;
        }

        public void setInjectedJavaScriptBeforeContentLoaded(String str) {
            this.injectedJSBeforeContentLoaded = str;
        }

        public void setInjectedJavaScriptForMainFrameOnly(boolean z) {
            this.injectedJavaScriptForMainFrameOnly = z;
        }

        public void setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(boolean z) {
            this.injectedJavaScriptBeforeContentLoadedForMainFrameOnly = z;
        }

        /* access modifiers changed from: protected */
        public RNCWebViewBridge createRNCWebViewBridge(RNCWebView rNCWebView) {
            return new RNCWebViewBridge(rNCWebView);
        }

        /* access modifiers changed from: protected */
        public void createCatalystInstance() {
            ReactContext reactContext = (ReactContext) getContext();
            if (reactContext != null) {
                this.mCatalystInstance = reactContext.getCatalystInstance();
            }
        }

        public void setMessagingEnabled(boolean z) {
            if (this.messagingEnabled != z) {
                this.messagingEnabled = z;
                if (z) {
                    addJavascriptInterface(createRNCWebViewBridge(this), RNCWebViewManager.JAVASCRIPT_INTERFACE);
                } else {
                    removeJavascriptInterface(RNCWebViewManager.JAVASCRIPT_INTERFACE);
                }
            }
        }

        public void setMessagingModuleName(String str) {
            this.messagingModuleName = str;
        }

        /* access modifiers changed from: protected */
        public void evaluateJavascriptWithFallback(String str) {
            if (Build.VERSION.SDK_INT >= 19) {
                evaluateJavascript(str, (ValueCallback) null);
                return;
            }
            try {
                loadUrl("javascript:" + URLEncoder.encode(str, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }

        public void callInjectedJavaScript() {
            String str;
            if (getSettings().getJavaScriptEnabled() && (str = this.injectedJS) != null && !TextUtils.isEmpty(str)) {
                evaluateJavascriptWithFallback("(function() {\n" + this.injectedJS + ";\n})();");
            }
        }

        public void callInjectedJavaScriptBeforeContentLoaded() {
            String str;
            if (getSettings().getJavaScriptEnabled() && (str = this.injectedJSBeforeContentLoaded) != null && !TextUtils.isEmpty(str)) {
                evaluateJavascriptWithFallback("(function() {\n" + this.injectedJSBeforeContentLoaded + ";\n})();");
            }
        }

        public void onMessage(final String str) {
            ReactContext reactContext = (ReactContext) getContext();
            if (this.mRNCWebViewClient != null) {
                post(new Runnable(this) {
                    final /* synthetic */ WebView val$webView;

                    {
                        this.val$webView = r2;
                    }

                    public void run() {
                        if (RNCWebView.this.mRNCWebViewClient != null) {
                            RNCWebViewClient rNCWebViewClient = RNCWebView.this.mRNCWebViewClient;
                            WebView webView = this.val$webView;
                            WritableMap createWebViewEvent = rNCWebViewClient.createWebViewEvent(webView, webView.getUrl());
                            createWebViewEvent.putString("data", str);
                            if (RNCWebView.this.mCatalystInstance != null) {
                                this.sendDirectMessage("onMessage", createWebViewEvent);
                            } else {
                                RNCWebView.this.dispatchEvent(this.val$webView, new TopMessageEvent(this.val$webView.getId(), createWebViewEvent));
                            }
                        }
                    }
                });
                return;
            }
            WritableMap createMap = Arguments.createMap();
            createMap.putString("data", str);
            if (this.mCatalystInstance != null) {
                sendDirectMessage("onMessage", createMap);
            } else {
                dispatchEvent(this, new TopMessageEvent(getId(), createMap));
            }
        }

        /* access modifiers changed from: protected */
        public void sendDirectMessage(String str, WritableMap writableMap) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putMap("nativeEvent", writableMap);
            WritableNativeArray writableNativeArray = new WritableNativeArray();
            writableNativeArray.pushMap(writableNativeMap);
            this.mCatalystInstance.callFunction(this.messagingModuleName, str, writableNativeArray);
        }

        /* access modifiers changed from: protected */
        public void onScrollChanged(int i, int i2, int i3, int i4) {
            super.onScrollChanged(i, i2, i3, i4);
            if (this.hasScrollEvent) {
                if (this.mOnScrollDispatchHelper == null) {
                    this.mOnScrollDispatchHelper = new OnScrollDispatchHelper();
                }
                if (this.mOnScrollDispatchHelper.onScrollChanged(i, i2)) {
                    dispatchEvent(this, ScrollEvent.obtain(getId(), ScrollEventType.SCROLL, i, i2, this.mOnScrollDispatchHelper.getXFlingVelocity(), this.mOnScrollDispatchHelper.getYFlingVelocity(), computeHorizontalScrollRange(), computeVerticalScrollRange(), getWidth(), getHeight()));
                }
            }
        }

        /* access modifiers changed from: protected */
        public void dispatchEvent(WebView webView, Event event) {
            ((UIManagerModule) ((ReactContext) webView.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(event);
        }

        /* access modifiers changed from: protected */
        public void cleanupCallbacksAndDestroy() {
            setWebViewClient((WebViewClient) null);
            destroy();
        }

        public void destroy() {
            WebChromeClient webChromeClient = this.mWebChromeClient;
            if (webChromeClient != null) {
                webChromeClient.onHideCustomView();
            }
            super.destroy();
        }

        protected class RNCWebViewBridge {
            RNCWebView mContext;

            RNCWebViewBridge(RNCWebView rNCWebView) {
                this.mContext = rNCWebView;
            }

            @JavascriptInterface
            public void postMessage(String str) {
                this.mContext.onMessage(str);
            }
        }

        protected static class ProgressChangedFilter {
            private boolean waitingForCommandLoadUrl = false;

            protected ProgressChangedFilter() {
            }

            public void setWaitingForCommandLoadUrl(boolean z) {
                this.waitingForCommandLoadUrl = z;
            }

            public boolean isWaitingForCommandLoadUrl() {
                return this.waitingForCommandLoadUrl;
            }
        }
    }
}
