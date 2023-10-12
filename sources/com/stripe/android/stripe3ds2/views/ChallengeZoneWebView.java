package com.stripe.android.stripe3ds2.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.stripe.android.stripe3ds2.databinding.StripeChallengeZoneWebViewBinding;
import com.stripe.android.stripe3ds2.views.ThreeDS2WebViewClient;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011J\u0012\u0010\u001c\u001a\u00020\u001a2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0011H\u0002J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0011H\u0002J\u0015\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0011H\u0001¢\u0006\u0002\b R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\""}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ChallengeZoneWebView;", "Landroid/widget/FrameLayout;", "Lcom/stripe/android/stripe3ds2/views/FormField;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onClickListener", "Landroid/view/View$OnClickListener;", "getOnClickListener$3ds2sdk_release", "()Landroid/view/View$OnClickListener;", "setOnClickListener$3ds2sdk_release", "(Landroid/view/View$OnClickListener;)V", "<set-?>", "", "userEntry", "getUserEntry", "()Ljava/lang/String;", "webView", "Lcom/stripe/android/stripe3ds2/views/ThreeDS2WebView;", "getWebView", "()Lcom/stripe/android/stripe3ds2/views/ThreeDS2WebView;", "loadHtml", "", "html", "setOnClickListener", "transformFormActionUrl", "transformFormMethod", "transformHtml", "transformHtml$3ds2sdk_release", "Companion", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChallengeZoneWebView.kt */
public final class ChallengeZoneWebView extends FrameLayout implements FormField {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String ENCODING = "UTF-8";
    @Deprecated
    private static final String HTML_MIME_TYPE = "text/html";
    @Deprecated
    private static final String METHOD_GET = "method=\"get\"";
    @Deprecated
    private static final Pattern PATTERN_FORM_ACTION = Pattern.compile("action=\"(.+?)\"", 10);
    @Deprecated
    private static final Pattern PATTERN_METHOD_POST = Pattern.compile("method=\"post\"", 10);
    private View.OnClickListener onClickListener;
    private String userEntry;
    private final ThreeDS2WebView webView;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ChallengeZoneWebView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ChallengeZoneWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChallengeZoneWebView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChallengeZoneWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.userEntry = "";
        StripeChallengeZoneWebViewBinding inflate = StripeChallengeZoneWebViewBinding.inflate(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…           this\n        )");
        ThreeDS2WebView threeDS2WebView = inflate.webView;
        Intrinsics.checkNotNullExpressionValue(threeDS2WebView, "viewBinding.webView");
        this.webView = threeDS2WebView;
        threeDS2WebView.setOnHtmlSubmitListener$3ds2sdk_release(new ThreeDS2WebViewClient.OnHtmlSubmitListener() {
            public final void onHtmlSubmit(String str) {
                ChallengeZoneWebView.m4461_init_$lambda0(ChallengeZoneWebView.this, str);
            }
        });
    }

    public final ThreeDS2WebView getWebView() {
        return this.webView;
    }

    public String getUserEntry() {
        return this.userEntry;
    }

    public final View.OnClickListener getOnClickListener$3ds2sdk_release() {
        return this.onClickListener;
    }

    public final void setOnClickListener$3ds2sdk_release(View.OnClickListener onClickListener2) {
        this.onClickListener = onClickListener2;
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m4461_init_$lambda0(ChallengeZoneWebView challengeZoneWebView, String str) {
        Intrinsics.checkNotNullParameter(challengeZoneWebView, "this$0");
        if (str == null) {
            str = "";
        }
        challengeZoneWebView.userEntry = str;
        View.OnClickListener onClickListener2 = challengeZoneWebView.onClickListener;
        if (onClickListener2 != null) {
            onClickListener2.onClick(challengeZoneWebView);
        }
    }

    public final String transformHtml$3ds2sdk_release(String str) {
        Intrinsics.checkNotNullParameter(str, "html");
        return transformFormActionUrl(transformFormMethod(str));
    }

    private final String transformFormMethod(String str) {
        String replaceAll = PATTERN_METHOD_POST.matcher(str).replaceAll(METHOD_GET);
        Intrinsics.checkNotNullExpressionValue(replaceAll, "methodMatcher.replaceAll(METHOD_GET)");
        return replaceAll;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r0 = r0.group(1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String transformFormActionUrl(java.lang.String r5) {
        /*
            r4 = this;
            java.util.regex.Pattern r0 = PATTERN_FORM_ACTION
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.util.regex.Matcher r0 = r0.matcher(r1)
            boolean r2 = r0.find()
            if (r2 == 0) goto L_0x0028
            r2 = 1
            java.lang.String r0 = r0.group(r2)
            if (r0 != 0) goto L_0x0017
            goto L_0x0028
        L_0x0017:
            java.lang.String r2 = "https://emv3ds/challenge"
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r0)
            if (r3 != 0) goto L_0x0028
            kotlin.text.Regex r5 = new kotlin.text.Regex
            r5.<init>((java.lang.String) r0)
            java.lang.String r5 = r5.replace((java.lang.CharSequence) r1, (java.lang.String) r2)
        L_0x0028:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.stripe3ds2.views.ChallengeZoneWebView.transformFormActionUrl(java.lang.String):java.lang.String");
    }

    public final void loadHtml(String str) {
        if (str != null) {
            this.webView.loadDataWithBaseURL((String) null, transformHtml$3ds2sdk_release(str), HTML_MIME_TYPE, "UTF-8", (String) null);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener2) {
        this.onClickListener = onClickListener2;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/stripe3ds2/views/ChallengeZoneWebView$Companion;", "", "()V", "ENCODING", "", "HTML_MIME_TYPE", "METHOD_GET", "PATTERN_FORM_ACTION", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "PATTERN_METHOD_POST", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ChallengeZoneWebView.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
