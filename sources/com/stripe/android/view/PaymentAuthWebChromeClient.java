package com.stripe.android.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.appcompat.app.AlertDialog;
import com.stripe.android.R;
import com.stripe.android.core.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J0\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/view/PaymentAuthWebChromeClient;", "Landroid/webkit/WebChromeClient;", "activity", "Landroid/app/Activity;", "logger", "Lcom/stripe/android/core/Logger;", "(Landroid/app/Activity;Lcom/stripe/android/core/Logger;)V", "onConsoleMessage", "", "consoleMessage", "Landroid/webkit/ConsoleMessage;", "onJsConfirm", "view", "Landroid/webkit/WebView;", "url", "", "message", "result", "Landroid/webkit/JsResult;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentAuthWebChromeClient.kt */
public final class PaymentAuthWebChromeClient extends WebChromeClient {
    private final Activity activity;
    private final Logger logger;

    public PaymentAuthWebChromeClient(Activity activity2, Logger logger2) {
        Intrinsics.checkNotNullParameter(activity2, "activity");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        this.activity = activity2;
        this.logger = logger2;
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message;
        if (!(consoleMessage == null || (message = consoleMessage.message()) == null)) {
            this.logger.debug(message);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        new AlertDialog.Builder(this.activity, R.style.AlertDialogStyle).setMessage((CharSequence) str2).setPositiveButton(17039370, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(jsResult) {
            public final /* synthetic */ JsResult f$0;

            {
                this.f$0 = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                PaymentAuthWebChromeClient.m4665onJsConfirm$lambda0(this.f$0, dialogInterface, i);
            }
        }).setNegativeButton(17039360, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(jsResult) {
            public final /* synthetic */ JsResult f$0;

            {
                this.f$0 = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                PaymentAuthWebChromeClient.m4666onJsConfirm$lambda1(this.f$0, dialogInterface, i);
            }
        }).create().show();
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: onJsConfirm$lambda-0  reason: not valid java name */
    public static final void m4665onJsConfirm$lambda0(JsResult jsResult, DialogInterface dialogInterface, int i) {
        if (jsResult != null) {
            jsResult.confirm();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onJsConfirm$lambda-1  reason: not valid java name */
    public static final void m4666onJsConfirm$lambda1(JsResult jsResult, DialogInterface dialogInterface, int i) {
        if (jsResult != null) {
            jsResult.cancel();
        }
    }
}
