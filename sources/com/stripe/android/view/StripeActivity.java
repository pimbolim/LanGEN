package com.stripe.android.view;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.ProgressBar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.brentvatne.react.ReactVideoView;
import com.stripe.android.R;
import com.stripe.android.databinding.StripeActivityBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010#\u001a\u00020$H$J\u0012\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\u0010\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\n2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u0010/\u001a\u00020$2\u0006\u00100\u001a\u00020\nH\u0014J\u0010\u00101\u001a\u00020$2\u0006\u00102\u001a\u000203H\u0004R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108@X\u0002¢\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\b\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\b\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8@X\u0002¢\u0006\f\n\u0004\b\"\u0010\b\u001a\u0004\b \u0010!¨\u00064"}, d2 = {"Lcom/stripe/android/view/StripeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "alertDisplayer", "Lcom/stripe/android/view/AlertDisplayer;", "getAlertDisplayer", "()Lcom/stripe/android/view/AlertDisplayer;", "alertDisplayer$delegate", "Lkotlin/Lazy;", "value", "", "isProgressBarVisible", "()Z", "setProgressBarVisible", "(Z)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar$payments_core_release", "()Landroid/widget/ProgressBar;", "progressBar$delegate", "stripeColorUtils", "Lcom/stripe/android/view/StripeColorUtils;", "getStripeColorUtils", "()Lcom/stripe/android/view/StripeColorUtils;", "stripeColorUtils$delegate", "viewBinding", "Lcom/stripe/android/databinding/StripeActivityBinding;", "getViewBinding", "()Lcom/stripe/android/databinding/StripeActivityBinding;", "viewBinding$delegate", "viewStub", "Landroid/view/ViewStub;", "getViewStub$payments_core_release", "()Landroid/view/ViewStub;", "viewStub$delegate", "onActionSave", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPrepareOptionsMenu", "onProgressBarVisibilityChanged", "visible", "showError", "error", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeActivity.kt */
public abstract class StripeActivity extends AppCompatActivity {
    public static final int $stable = 8;
    private final Lazy alertDisplayer$delegate = LazyKt.lazy(new StripeActivity$alertDisplayer$2(this));
    private boolean isProgressBarVisible;
    private final Lazy progressBar$delegate = LazyKt.lazy(new StripeActivity$progressBar$2(this));
    private final Lazy stripeColorUtils$delegate = LazyKt.lazy(new StripeActivity$stripeColorUtils$2(this));
    private final Lazy viewBinding$delegate = LazyKt.lazy(new StripeActivity$viewBinding$2(this));
    private final Lazy viewStub$delegate = LazyKt.lazy(new StripeActivity$viewStub$2(this));

    /* access modifiers changed from: protected */
    public abstract void onActionSave();

    /* access modifiers changed from: protected */
    public void onProgressBarVisibilityChanged(boolean z) {
    }

    /* access modifiers changed from: private */
    public final StripeActivityBinding getViewBinding() {
        return (StripeActivityBinding) this.viewBinding$delegate.getValue();
    }

    public final ProgressBar getProgressBar$payments_core_release() {
        Object value = this.progressBar$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-progressBar>(...)");
        return (ProgressBar) value;
    }

    public final ViewStub getViewStub$payments_core_release() {
        return (ViewStub) this.viewStub$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final boolean isProgressBarVisible() {
        return this.isProgressBarVisible;
    }

    /* access modifiers changed from: protected */
    public final void setProgressBarVisible(boolean z) {
        getProgressBar$payments_core_release().setVisibility(z ? 0 : 8);
        invalidateOptionsMenu();
        onProgressBarVisibilityChanged(z);
        this.isProgressBarVisible = z;
    }

    private final AlertDisplayer getAlertDisplayer() {
        return (AlertDisplayer) this.alertDisplayer$delegate.getValue();
    }

    private final StripeColorUtils getStripeColorUtils() {
        return (StripeColorUtils) this.stripeColorUtils$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) getViewBinding().getRoot());
        setSupportActionBar(getViewBinding().toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        getMenuInflater().inflate(R.menu.add_payment_method, menu);
        menu.findItem(R.id.action_save).setEnabled(!this.isProgressBarVisible);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "item");
        if (menuItem.getItemId() == R.id.action_save) {
            onActionSave();
            return true;
        }
        boolean onOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        if (onOptionsItemSelected) {
            return onOptionsItemSelected;
        }
        onBackPressed();
        return onOptionsItemSelected;
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        MenuItem findItem = menu.findItem(R.id.action_save);
        StripeColorUtils stripeColorUtils = getStripeColorUtils();
        Resources.Theme theme = getTheme();
        Intrinsics.checkNotNullExpressionValue(theme, "theme");
        findItem.setIcon(stripeColorUtils.getTintedIconWithAttribute(theme, R.attr.titleTextColor, R.drawable.stripe_ic_checkmark));
        return super.onPrepareOptionsMenu(menu);
    }

    /* access modifiers changed from: protected */
    public final void showError(String str) {
        Intrinsics.checkNotNullParameter(str, ReactVideoView.EVENT_PROP_ERROR);
        getAlertDisplayer().show(str);
    }
}
