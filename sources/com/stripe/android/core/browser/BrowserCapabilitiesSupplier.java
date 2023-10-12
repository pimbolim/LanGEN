package com.stripe.android.core.browser;

import android.content.ComponentName;
import android.content.Context;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0002\t\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/core/browser/BrowserCapabilitiesSupplier;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "get", "Lcom/stripe/android/core/browser/BrowserCapabilities;", "isCustomTabsSupported", "", "Companion", "NoopCustomTabsServiceConnection", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BrowserCapabilitiesSupplier.kt */
public final class BrowserCapabilitiesSupplier {
    public static final int $stable = 8;
    @Deprecated
    private static final String CHROME_PACKAGE = "com.android.chrome";
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Context context;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/core/browser/BrowserCapabilitiesSupplier$NoopCustomTabsServiceConnection;", "Landroidx/browser/customtabs/CustomTabsServiceConnection;", "()V", "onCustomTabsServiceConnected", "", "componentName", "Landroid/content/ComponentName;", "customTabsClient", "Landroidx/browser/customtabs/CustomTabsClient;", "onServiceDisconnected", "name", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BrowserCapabilitiesSupplier.kt */
    private static final class NoopCustomTabsServiceConnection extends CustomTabsServiceConnection {
        public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
            Intrinsics.checkNotNullParameter(componentName, "componentName");
            Intrinsics.checkNotNullParameter(customTabsClient, "customTabsClient");
        }

        public void onServiceDisconnected(ComponentName componentName) {
            Intrinsics.checkNotNullParameter(componentName, "name");
        }
    }

    public BrowserCapabilitiesSupplier(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final BrowserCapabilities get() {
        if (isCustomTabsSupported()) {
            return BrowserCapabilities.CustomTabs;
        }
        return BrowserCapabilities.Unknown;
    }

    private final boolean isCustomTabsSupported() {
        Boolean bool;
        try {
            Result.Companion companion = Result.Companion;
            bool = Result.m4709constructorimpl(Boolean.valueOf(CustomTabsClient.bindCustomTabsService(this.context, CHROME_PACKAGE, new NoopCustomTabsServiceConnection())));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            bool = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m4715isFailureimpl(bool)) {
            bool = false;
        }
        return ((Boolean) bool).booleanValue();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/core/browser/BrowserCapabilitiesSupplier$Companion;", "", "()V", "CHROME_PACKAGE", "", "stripe-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BrowserCapabilitiesSupplier.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
