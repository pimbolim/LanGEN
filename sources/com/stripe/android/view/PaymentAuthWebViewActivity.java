package com.stripe.android.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.stripe.android.R;
import com.stripe.android.auth.PaymentBrowserAuthContract;
import com.stripe.android.core.Logger;
import com.stripe.android.core.exception.StripeException;
import com.stripe.android.databinding.PaymentAuthWebViewActivityBinding;
import com.stripe.android.model.Source;
import com.stripe.android.payments.PaymentFlowResult;
import com.stripe.android.stripe3ds2.utils.CustomizeUtils;
import com.stripe.android.view.PaymentAuthWebViewActivityViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\u0017\u0010\u001f\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010!H\u0001¢\u0006\u0002\b\"J\b\u0010#\u001a\u00020\u0019H\u0016J\u0012\u0010$\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0019H\u0014J\u0010\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020.H\u0016R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016¨\u0006/"}, d2 = {"Lcom/stripe/android/view/PaymentAuthWebViewActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "_args", "Lcom/stripe/android/auth/PaymentBrowserAuthContract$Args;", "get_args", "()Lcom/stripe/android/auth/PaymentBrowserAuthContract$Args;", "_args$delegate", "Lkotlin/Lazy;", "logger", "Lcom/stripe/android/core/Logger;", "getLogger", "()Lcom/stripe/android/core/Logger;", "logger$delegate", "viewBinding", "Lcom/stripe/android/databinding/PaymentAuthWebViewActivityBinding;", "getViewBinding", "()Lcom/stripe/android/databinding/PaymentAuthWebViewActivityBinding;", "viewBinding$delegate", "viewModel", "Lcom/stripe/android/view/PaymentAuthWebViewActivityViewModel;", "getViewModel", "()Lcom/stripe/android/view/PaymentAuthWebViewActivityViewModel;", "viewModel$delegate", "cancelIntentSource", "", "createResultIntent", "Landroid/content/Intent;", "paymentFlowResult", "Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "customizeToolbar", "onAuthComplete", "error", "", "onAuthComplete$payments_core_release", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentAuthWebViewActivity.kt */
public final class PaymentAuthWebViewActivity extends AppCompatActivity {
    public static final int $stable = 8;
    private final Lazy _args$delegate = LazyKt.lazy(new PaymentAuthWebViewActivity$_args$2(this));
    private final Lazy logger$delegate = LazyKt.lazy(new PaymentAuthWebViewActivity$logger$2(this));
    private final Lazy viewBinding$delegate = LazyKt.lazy(new PaymentAuthWebViewActivity$viewBinding$2(this));
    private final Lazy viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(PaymentAuthWebViewActivityViewModel.class), new PaymentAuthWebViewActivity$special$$inlined$viewModels$2(this), new PaymentAuthWebViewActivity$viewModel$2(this));

    private final PaymentAuthWebViewActivityBinding getViewBinding() {
        return (PaymentAuthWebViewActivityBinding) this.viewBinding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final PaymentBrowserAuthContract.Args get_args() {
        return (PaymentBrowserAuthContract.Args) this._args$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Logger getLogger() {
        return (Logger) this.logger$delegate.getValue();
    }

    private final PaymentAuthWebViewActivityViewModel getViewModel() {
        return (PaymentAuthWebViewActivityViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PaymentBrowserAuthContract.Args args = get_args();
        if (args == null) {
            setResult(0);
            finish();
            return;
        }
        getLogger().debug("PaymentAuthWebViewActivity#onCreate()");
        setContentView((View) getViewBinding().getRoot());
        setSupportActionBar(getViewBinding().toolbar);
        customizeToolbar();
        String clientSecret = args.getClientSecret();
        setResult(-1, createResultIntent(getViewModel().getPaymentResult$payments_core_release()));
        if (StringsKt.isBlank(clientSecret)) {
            getLogger().debug("PaymentAuthWebViewActivity#onCreate() - clientSecret is blank");
            finish();
            return;
        }
        getLogger().debug("PaymentAuthWebViewActivity#onCreate() - PaymentAuthWebView init and loadUrl");
        MutableLiveData mutableLiveData = new MutableLiveData(false);
        mutableLiveData.observe(this, new Observer() {
            public final void onChanged(Object obj) {
                PaymentAuthWebViewActivity.m4667onCreate$lambda0(PaymentAuthWebViewActivity.this, (Boolean) obj);
            }
        });
        PaymentAuthWebViewClient paymentAuthWebViewClient = new PaymentAuthWebViewClient(getLogger(), mutableLiveData, clientSecret, args.getReturnUrl(), new PaymentAuthWebViewActivity$onCreate$webViewClient$1(this), new PaymentAuthWebViewActivity$onCreate$webViewClient$2(this));
        getViewBinding().webView.setOnLoadBlank$payments_core_release(new PaymentAuthWebViewActivity$onCreate$2(paymentAuthWebViewClient));
        getViewBinding().webView.setWebViewClient(paymentAuthWebViewClient);
        getViewBinding().webView.setWebChromeClient(new PaymentAuthWebChromeClient(this, getLogger()));
        getViewModel().logStart();
        getViewBinding().webView.loadUrl(args.getUrl(), getViewModel().getExtraHeaders());
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m4667onCreate$lambda0(PaymentAuthWebViewActivity paymentAuthWebViewActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(paymentAuthWebViewActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "shouldHide");
        if (bool.booleanValue()) {
            CircularProgressIndicator circularProgressIndicator = paymentAuthWebViewActivity.getViewBinding().progressBar;
            Intrinsics.checkNotNullExpressionValue(circularProgressIndicator, "viewBinding.progressBar");
            circularProgressIndicator.setVisibility(8);
        }
    }

    public final void onAuthComplete$payments_core_release(Throwable th) {
        if (th != null) {
            getViewModel().logError();
            setResult(-1, createResultIntent(PaymentFlowResult.Unvalidated.copy$default(getViewModel().getPaymentResult$payments_core_release(), (String) null, 2, StripeException.Companion.create(th), true, (String) null, (Source) null, (String) null, 113, (Object) null)));
        } else {
            getViewModel().logComplete();
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        getViewBinding().webViewContainer.removeAllViews();
        getViewBinding().webView.destroy();
        super.onDestroy();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getLogger().debug("PaymentAuthWebViewActivity#onCreateOptionsMenu()");
        getMenuInflater().inflate(R.menu.payment_auth_web_view_menu, menu);
        String buttonText$payments_core_release = getViewModel().getButtonText$payments_core_release();
        if (buttonText$payments_core_release != null) {
            getLogger().debug("PaymentAuthWebViewActivity#customizeToolbar() - updating close button text");
            menu.findItem(R.id.action_close).setTitle(buttonText$payments_core_release);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        getLogger().debug("PaymentAuthWebViewActivity#onOptionsItemSelected()");
        if (menuItem.getItemId() != R.id.action_close) {
            return super.onOptionsItemSelected(menuItem);
        }
        cancelIntentSource();
        return true;
    }

    public void onBackPressed() {
        if (getViewBinding().webView.canGoBack()) {
            getViewBinding().webView.goBack();
        } else {
            cancelIntentSource();
        }
    }

    private final void cancelIntentSource() {
        setResult(-1, getViewModel().getCancellationResult$payments_core_release());
        finish();
    }

    private final void customizeToolbar() {
        getLogger().debug("PaymentAuthWebViewActivity#customizeToolbar()");
        PaymentAuthWebViewActivityViewModel.ToolbarTitleData toolbarTitle$payments_core_release = getViewModel().getToolbarTitle$payments_core_release();
        if (toolbarTitle$payments_core_release != null) {
            getLogger().debug("PaymentAuthWebViewActivity#customizeToolbar() - updating toolbar title");
            getViewBinding().toolbar.setTitle((CharSequence) CustomizeUtils.INSTANCE.buildStyledText(this, toolbarTitle$payments_core_release.getText$payments_core_release(), toolbarTitle$payments_core_release.getToolbarCustomization$payments_core_release()));
        }
        String toolbarBackgroundColor$payments_core_release = getViewModel().getToolbarBackgroundColor$payments_core_release();
        if (toolbarBackgroundColor$payments_core_release != null) {
            getLogger().debug("PaymentAuthWebViewActivity#customizeToolbar() - updating toolbar background color");
            int parseColor = Color.parseColor(toolbarBackgroundColor$payments_core_release);
            getViewBinding().toolbar.setBackgroundColor(parseColor);
            CustomizeUtils.INSTANCE.setStatusBarColor(this, parseColor);
        }
    }

    private final Intent createResultIntent(PaymentFlowResult.Unvalidated unvalidated) {
        Intent putExtras = new Intent().putExtras(unvalidated.toBundle());
        Intrinsics.checkNotNullExpressionValue(putExtras, "Intent().putExtras(paymentFlowResult.toBundle())");
        return putExtras;
    }
}
