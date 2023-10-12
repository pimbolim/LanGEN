package com.reactnativestripesdk;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.stripe.android.googlepaylauncher.GooglePayEnvironment;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ$\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/reactnativestripesdk/GooglePayPaymentMethodLauncherFragment;", "Landroidx/fragment/app/Fragment;", "context", "Lcom/facebook/react/bridge/ReactApplicationContext;", "isTestEnv", "", "paymentMethodRequired", "promise", "Lcom/facebook/react/bridge/Promise;", "(Lcom/facebook/react/bridge/ReactApplicationContext;ZZLcom/facebook/react/bridge/Promise;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: GooglePayPaymentMethodLauncherFragment.kt */
public final class GooglePayPaymentMethodLauncherFragment extends Fragment {
    private final ReactApplicationContext context;
    private final boolean isTestEnv;
    private final boolean paymentMethodRequired;
    private final Promise promise;

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-2  reason: not valid java name */
    public static final void m4274onViewCreated$lambda2(GooglePayPaymentMethodLauncher.Result result) {
        Intrinsics.checkNotNullParameter(result, "it");
    }

    public GooglePayPaymentMethodLauncherFragment(ReactApplicationContext reactApplicationContext, boolean z, boolean z2, Promise promise2) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "context");
        Intrinsics.checkNotNullParameter(promise2, BaseJavaModule.METHOD_TYPE_PROMISE);
        this.context = reactApplicationContext;
        this.isTestEnv = z;
        this.paymentMethodRequired = z2;
        this.promise = promise2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FrameLayout frameLayout = new FrameLayout(requireActivity());
        frameLayout.setVisibility(8);
        return frameLayout;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        new GooglePayPaymentMethodLauncher((Fragment) this, new GooglePayPaymentMethodLauncher.Config(this.isTestEnv ? GooglePayEnvironment.Test : GooglePayEnvironment.Production, "", "", false, (GooglePayPaymentMethodLauncher.BillingAddressConfig) null, this.paymentMethodRequired, 24, (DefaultConstructorMarker) null), (GooglePayPaymentMethodLauncher.ReadyCallback) new GooglePayPaymentMethodLauncher.ReadyCallback() {
            public final void onReady(boolean z) {
                GooglePayPaymentMethodLauncherFragment.m4273onViewCreated$lambda1(GooglePayPaymentMethodLauncherFragment.this, z);
            }
        }, (GooglePayPaymentMethodLauncher.ResultCallback) $$Lambda$GooglePayPaymentMethodLauncherFragment$2Ck8CW5Pr9wd5w5Ko9x16snEPQ.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewCreated$lambda-1  reason: not valid java name */
    public static final void m4273onViewCreated$lambda1(GooglePayPaymentMethodLauncherFragment googlePayPaymentMethodLauncherFragment, boolean z) {
        FragmentTransaction remove;
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(googlePayPaymentMethodLauncherFragment, "this$0");
        googlePayPaymentMethodLauncherFragment.promise.resolve(Boolean.valueOf(z));
        Activity currentActivity = googlePayPaymentMethodLauncherFragment.context.getCurrentActivity();
        FragmentTransaction fragmentTransaction = null;
        AppCompatActivity appCompatActivity = currentActivity instanceof AppCompatActivity ? (AppCompatActivity) currentActivity : null;
        if (!(appCompatActivity == null || (supportFragmentManager = appCompatActivity.getSupportFragmentManager()) == null)) {
            fragmentTransaction = supportFragmentManager.beginTransaction();
        }
        if (fragmentTransaction != null && (remove = fragmentTransaction.remove(googlePayPaymentMethodLauncherFragment)) != null) {
            remove.commit();
        }
    }
}
