package com.stripe.android.payments;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabColorSchemeParams;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.SavedStateRegistryOwner;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.R;
import com.stripe.android.auth.PaymentBrowserAuthContract;
import com.stripe.android.core.browser.BrowserCapabilities;
import com.stripe.android.core.browser.BrowserCapabilitiesSupplier;
import com.stripe.android.core.exception.StripeException;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor;
import com.stripe.android.model.Source;
import com.stripe.android.model.Token;
import com.stripe.android.networking.PaymentAnalyticsEvent;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.payments.PaymentFlowResult;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8F@FX\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/stripe/android/payments/StripeBrowserLauncherViewModel;", "Landroidx/lifecycle/ViewModel;", "analyticsRequestExecutor", "Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;", "paymentAnalyticsRequestFactory", "Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;", "browserCapabilities", "Lcom/stripe/android/core/browser/BrowserCapabilities;", "intentChooserTitle", "", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;Lcom/stripe/android/core/browser/BrowserCapabilities;Ljava/lang/String;Landroidx/lifecycle/SavedStateHandle;)V", "<set-?>", "", "hasLaunched", "getHasLaunched", "()Z", "setHasLaunched", "(Z)V", "hasLaunched$delegate", "Lkotlin/properties/ReadWriteProperty;", "createLaunchIntent", "Landroid/content/Intent;", "args", "Lcom/stripe/android/auth/PaymentBrowserAuthContract$Args;", "getResultIntent", "logCapabilities", "", "shouldUseCustomTabs", "Companion", "Factory", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeBrowserLauncherViewModel.kt */
public final class StripeBrowserLauncherViewModel extends ViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(StripeBrowserLauncherViewModel.class, "hasLaunched", "getHasLaunched()Z", 0))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_HAS_LAUNCHED = "has_launched";
    private final AnalyticsRequestExecutor analyticsRequestExecutor;
    private final BrowserCapabilities browserCapabilities;
    private final ReadWriteProperty hasLaunched$delegate;
    private final String intentChooserTitle;
    private final PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory;
    /* access modifiers changed from: private */
    public final SavedStateHandle savedStateHandle;

    public StripeBrowserLauncherViewModel(AnalyticsRequestExecutor analyticsRequestExecutor2, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory2, BrowserCapabilities browserCapabilities2, String str, SavedStateHandle savedStateHandle2) {
        Intrinsics.checkNotNullParameter(analyticsRequestExecutor2, "analyticsRequestExecutor");
        Intrinsics.checkNotNullParameter(paymentAnalyticsRequestFactory2, "paymentAnalyticsRequestFactory");
        Intrinsics.checkNotNullParameter(browserCapabilities2, "browserCapabilities");
        Intrinsics.checkNotNullParameter(str, "intentChooserTitle");
        Intrinsics.checkNotNullParameter(savedStateHandle2, "savedStateHandle");
        this.analyticsRequestExecutor = analyticsRequestExecutor2;
        this.paymentAnalyticsRequestFactory = paymentAnalyticsRequestFactory2;
        this.browserCapabilities = browserCapabilities2;
        this.intentChooserTitle = str;
        this.savedStateHandle = savedStateHandle2;
        Delegates delegates = Delegates.INSTANCE;
        this.hasLaunched$delegate = new StripeBrowserLauncherViewModel$special$$inlined$observable$1(Boolean.valueOf(savedStateHandle2.contains(KEY_HAS_LAUNCHED)), this);
    }

    public final boolean getHasLaunched() {
        return ((Boolean) this.hasLaunched$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setHasLaunched(boolean z) {
        this.hasLaunched$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    public final Intent createLaunchIntent(PaymentBrowserAuthContract.Args args) {
        CustomTabColorSchemeParams customTabColorSchemeParams;
        Intrinsics.checkNotNullParameter(args, "args");
        boolean z = this.browserCapabilities == BrowserCapabilities.CustomTabs;
        logCapabilities(z);
        Uri parse = Uri.parse(args.getUrl());
        if (z) {
            Integer statusBarColor = args.getStatusBarColor();
            if (statusBarColor == null) {
                customTabColorSchemeParams = null;
            } else {
                customTabColorSchemeParams = new CustomTabColorSchemeParams.Builder().setToolbarColor(statusBarColor.intValue()).build();
            }
            CustomTabsIntent.Builder shareState = new CustomTabsIntent.Builder().setShareState(2);
            if (customTabColorSchemeParams != null) {
                shareState.setDefaultColorSchemeParams(customTabColorSchemeParams);
            }
            CustomTabsIntent build = shareState.build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …\n                .build()");
            build.intent.setData(parse);
            Intent createChooser = Intent.createChooser(build.intent, this.intentChooserTitle);
            Intrinsics.checkNotNullExpressionValue(createChooser, "{\n            val custom…e\n            )\n        }");
            return createChooser;
        }
        Intent createChooser2 = Intent.createChooser(new Intent("android.intent.action.VIEW", parse), this.intentChooserTitle);
        Intrinsics.checkNotNullExpressionValue(createChooser2, "{\n            // use def…e\n            )\n        }");
        return createChooser2;
    }

    public final Intent getResultIntent(PaymentBrowserAuthContract.Args args) {
        Intrinsics.checkNotNullParameter(args, "args");
        Uri parse = Uri.parse(args.getUrl());
        Intent intent = new Intent();
        String clientSecret = args.getClientSecret();
        String lastPathSegment = parse.getLastPathSegment();
        if (lastPathSegment == null) {
            lastPathSegment = "";
        }
        String stripeAccountId = args.getStripeAccountId();
        Intent putExtras = intent.putExtras(new PaymentFlowResult.Unvalidated(clientSecret, 0, (StripeException) null, args.getShouldCancelSource(), lastPathSegment, (Source) null, stripeAccountId, 38, (DefaultConstructorMarker) null).toBundle());
        Intrinsics.checkNotNullExpressionValue(putExtras, "Intent().putExtras(\n    …   ).toBundle()\n        )");
        return putExtras;
    }

    public final void logCapabilities(boolean z) {
        PaymentAnalyticsEvent paymentAnalyticsEvent;
        AnalyticsRequestExecutor analyticsRequestExecutor2 = this.analyticsRequestExecutor;
        PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory2 = this.paymentAnalyticsRequestFactory;
        if (z) {
            paymentAnalyticsEvent = PaymentAnalyticsEvent.AuthWithCustomTabs;
        } else if (!z) {
            paymentAnalyticsEvent = PaymentAnalyticsEvent.AuthWithDefaultBrowser;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        analyticsRequestExecutor2.executeAsync(PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(paymentAnalyticsRequestFactory2, paymentAnalyticsEvent, (Set) null, (String) null, (Token.Type) null, (PaymentAnalyticsRequestFactory.ThreeDS2UiType) null, 30, (Object) null));
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J7\u0010\u0007\u001a\u0002H\b\"\n\b\u0000\u0010\b*\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/payments/StripeBrowserLauncherViewModel$Factory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "application", "Landroid/app/Application;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroid/app/Application;Landroidx/savedstate/SavedStateRegistryOwner;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "key", "", "modelClass", "Ljava/lang/Class;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeBrowserLauncherViewModel.kt */
    public static final class Factory extends AbstractSavedStateViewModelFactory {
        public static final int $stable = 8;
        private final Application application;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Factory(Application application2, SavedStateRegistryOwner savedStateRegistryOwner) {
            super(savedStateRegistryOwner, (Bundle) null);
            Intrinsics.checkNotNullParameter(application2, "application");
            Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "owner");
            this.application = application2;
        }

        /* access modifiers changed from: protected */
        public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            Intrinsics.checkNotNullParameter(savedStateHandle, "handle");
            PaymentConfiguration instance = PaymentConfiguration.Companion.getInstance(this.application);
            BrowserCapabilitiesSupplier browserCapabilitiesSupplier = new BrowserCapabilitiesSupplier(this.application);
            PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory = new PaymentAnalyticsRequestFactory((Context) this.application, instance.getPublishableKey(), (Set) null, 4, (DefaultConstructorMarker) null);
            BrowserCapabilities browserCapabilities = browserCapabilitiesSupplier.get();
            String string = this.application.getString(R.string.stripe_verify_your_payment);
            Intrinsics.checkNotNullExpressionValue(string, "application.getString(R.…ripe_verify_your_payment)");
            return (ViewModel) new StripeBrowserLauncherViewModel(new DefaultAnalyticsRequestExecutor(), paymentAnalyticsRequestFactory, browserCapabilities, string, savedStateHandle);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/payments/StripeBrowserLauncherViewModel$Companion;", "", "()V", "KEY_HAS_LAUNCHED", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StripeBrowserLauncherViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
