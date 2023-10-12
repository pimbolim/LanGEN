package com.reactnativestripesdk;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.brentvatne.react.ReactVideoView;
import com.stripe.android.googlepaylauncher.GooglePayEnvironment;
import com.stripe.android.googlepaylauncher.GooglePayLauncher;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0002J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0002J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\bH\u0002J\u0010\u0010#\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\bH\u0002J\u0010\u0010$\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\bH\u0002J\u0010\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020(H\u0002J\u001a\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u000e\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u000fJ\u0016\u0010-\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/reactnativestripesdk/GooglePayFragment;", "Landroidx/fragment/app/Fragment;", "()V", "googlePayLauncher", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncher;", "googlePayMethodLauncher", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher;", "isGooglePayLauncherReady", "", "isGooglePayMethodLauncherReady", "localBroadcastManager", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "createPaymentMethod", "", "currencyCode", "", "amount", "", "mapToGooglePayLauncherBillingAddressConfig", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$BillingAddressConfig;", "formatString", "isRequired", "isPhoneNumberRequired", "mapToGooglePayPaymentMethodLauncherBillingAddressConfig", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$BillingAddressConfig;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onGooglePayLauncherReady", "isReady", "onGooglePayMethodLauncherReady", "onGooglePayReady", "onGooglePayResult", "result", "Lcom/stripe/android/googlepaylauncher/GooglePayLauncher$Result;", "Lcom/stripe/android/googlepaylauncher/GooglePayPaymentMethodLauncher$Result;", "onViewCreated", "view", "presentForPaymentIntent", "clientSecret", "presentForSetupIntent", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: GooglePayFragment.kt */
public final class GooglePayFragment extends Fragment {
    private GooglePayLauncher googlePayLauncher;
    private GooglePayPaymentMethodLauncher googlePayMethodLauncher;
    private boolean isGooglePayLauncherReady;
    private boolean isGooglePayMethodLauncherReady;
    private LocalBroadcastManager localBroadcastManager;

    /* access modifiers changed from: private */
    public final void onGooglePayMethodLauncherReady(boolean z) {
        this.isGooglePayMethodLauncherReady = true;
        if (this.isGooglePayLauncherReady) {
            onGooglePayReady(z);
        }
    }

    /* access modifiers changed from: private */
    public final void onGooglePayLauncherReady(boolean z) {
        this.isGooglePayLauncherReady = true;
        if (this.isGooglePayMethodLauncherReady) {
            onGooglePayReady(z);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(requireContext());
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance(requireContext())");
        this.localBroadcastManager = instance;
        FrameLayout frameLayout = new FrameLayout(requireActivity());
        frameLayout.setVisibility(8);
        return frameLayout;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        Bundle bundle2 = null;
        Boolean valueOf = arguments == null ? null : Boolean.valueOf(arguments.getBoolean("testEnv"));
        Bundle arguments2 = getArguments();
        String string = arguments2 == null ? null : arguments2.getString("merchantName");
        String str = "";
        if (string == null) {
            string = str;
        }
        Bundle arguments3 = getArguments();
        String string2 = arguments3 == null ? null : arguments3.getString("countryCode");
        String str2 = string2 == null ? str : string2;
        Bundle arguments4 = getArguments();
        boolean z = arguments4 == null ? false : arguments4.getBoolean("isEmailRequired");
        Bundle arguments5 = getArguments();
        boolean z2 = arguments5 == null ? false : arguments5.getBoolean("existingPaymentMethodRequired");
        Bundle arguments6 = getArguments();
        if (arguments6 != null) {
            bundle2 = arguments6.getBundle("billingAddressConfig");
        }
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        boolean z3 = bundle2.getBoolean("isRequired");
        String string3 = bundle2.getString("format");
        if (string3 != null) {
            str = string3;
        }
        boolean z4 = bundle2.getBoolean("isPhoneNumberRequired");
        String str3 = str2;
        String str4 = str2;
        GooglePayPaymentMethodLauncher.Config config = r5;
        String str5 = string;
        String str6 = string;
        Fragment fragment = this;
        boolean z5 = z;
        GooglePayPaymentMethodLauncher.Config config2 = new GooglePayPaymentMethodLauncher.Config(Intrinsics.areEqual((Object) valueOf, (Object) true) ? GooglePayEnvironment.Test : GooglePayEnvironment.Production, str3, str5, z, mapToGooglePayPaymentMethodLauncherBillingAddressConfig(str, z3, z4), z2);
        this.googlePayMethodLauncher = new GooglePayPaymentMethodLauncher(fragment, config, (GooglePayPaymentMethodLauncher.ReadyCallback) new GooglePayFragment$onViewCreated$1(this), (GooglePayPaymentMethodLauncher.ResultCallback) new GooglePayFragment$onViewCreated$2(this));
        this.googlePayLauncher = new GooglePayLauncher(fragment, new GooglePayLauncher.Config(Intrinsics.areEqual((Object) valueOf, (Object) true) ? GooglePayEnvironment.Test : GooglePayEnvironment.Production, str4, str6, z5, mapToGooglePayLauncherBillingAddressConfig(str, z3, z4), z2), (GooglePayLauncher.ReadyCallback) new GooglePayFragment$onViewCreated$3(this), (GooglePayLauncher.ResultCallback) new GooglePayFragment$onViewCreated$4(this));
    }

    public final void presentForPaymentIntent(String str) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        GooglePayLauncher googlePayLauncher2 = this.googlePayLauncher;
        if (googlePayLauncher2 == null) {
            Intent intent = new Intent(ConstantsKt.getON_GOOGLE_PAY_RESULT());
            intent.putExtra(ReactVideoView.EVENT_PROP_ERROR, "GooglePayLauncher is not initialized.");
            LocalBroadcastManager localBroadcastManager2 = this.localBroadcastManager;
            if (localBroadcastManager2 != null) {
                localBroadcastManager2.sendBroadcast(intent);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("localBroadcastManager");
                throw null;
            }
        } else {
            try {
                Result.Companion companion = Result.Companion;
                GooglePayFragment googlePayFragment = this;
                googlePayLauncher2.presentForPaymentIntent(str);
                obj = Result.m4709constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
            Throwable r6 = Result.m4712exceptionOrNullimpl(obj);
            if (r6 != null) {
                Intent intent2 = new Intent(ConstantsKt.getON_GOOGLE_PAY_RESULT());
                intent2.putExtra(ReactVideoView.EVENT_PROP_ERROR, r6.getLocalizedMessage());
                LocalBroadcastManager localBroadcastManager3 = this.localBroadcastManager;
                if (localBroadcastManager3 != null) {
                    localBroadcastManager3.sendBroadcast(intent2);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("localBroadcastManager");
                    throw null;
                }
            }
        }
    }

    public final void presentForSetupIntent(String str, String str2) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(str2, "currencyCode");
        GooglePayLauncher googlePayLauncher2 = this.googlePayLauncher;
        if (googlePayLauncher2 == null) {
            Intent intent = new Intent(ConstantsKt.getON_GOOGLE_PAY_RESULT());
            intent.putExtra(ReactVideoView.EVENT_PROP_ERROR, "GooglePayLauncher is not initialized.");
            LocalBroadcastManager localBroadcastManager2 = this.localBroadcastManager;
            if (localBroadcastManager2 != null) {
                localBroadcastManager2.sendBroadcast(intent);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("localBroadcastManager");
                throw null;
            }
        } else {
            try {
                Result.Companion companion = Result.Companion;
                GooglePayFragment googlePayFragment = this;
                googlePayLauncher2.presentForSetupIntent(str, str2);
                obj = Result.m4709constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
            Throwable r6 = Result.m4712exceptionOrNullimpl(obj);
            if (r6 != null) {
                Intent intent2 = new Intent(ConstantsKt.getON_GOOGLE_PAY_RESULT());
                intent2.putExtra(ReactVideoView.EVENT_PROP_ERROR, r6.getLocalizedMessage());
                LocalBroadcastManager localBroadcastManager3 = this.localBroadcastManager;
                if (localBroadcastManager3 != null) {
                    localBroadcastManager3.sendBroadcast(intent2);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("localBroadcastManager");
                    throw null;
                }
            }
        }
    }

    public final void createPaymentMethod(String str, int i) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "currencyCode");
        GooglePayPaymentMethodLauncher googlePayPaymentMethodLauncher = this.googlePayMethodLauncher;
        if (googlePayPaymentMethodLauncher == null) {
            Intent intent = new Intent(ConstantsKt.getON_GOOGLE_PAYMENT_METHOD_RESULT());
            intent.putExtra(ReactVideoView.EVENT_PROP_ERROR, "GooglePayPaymentMethodLauncher is not initialized.");
            LocalBroadcastManager localBroadcastManager2 = this.localBroadcastManager;
            if (localBroadcastManager2 != null) {
                localBroadcastManager2.sendBroadcast(intent);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("localBroadcastManager");
                throw null;
            }
        } else {
            try {
                Result.Companion companion = Result.Companion;
                GooglePayFragment googlePayFragment = this;
                GooglePayPaymentMethodLauncher.present$default(googlePayPaymentMethodLauncher, str, i, (String) null, 4, (Object) null);
                obj = Result.m4709constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
            Throwable r10 = Result.m4712exceptionOrNullimpl(obj);
            if (r10 != null) {
                Intent intent2 = new Intent(ConstantsKt.getON_GOOGLE_PAYMENT_METHOD_RESULT());
                intent2.putExtra(ReactVideoView.EVENT_PROP_ERROR, r10.getLocalizedMessage());
                LocalBroadcastManager localBroadcastManager3 = this.localBroadcastManager;
                if (localBroadcastManager3 != null) {
                    localBroadcastManager3.sendBroadcast(intent2);
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("localBroadcastManager");
                    throw null;
                }
            }
        }
    }

    private final void onGooglePayReady(boolean z) {
        Intent intent = new Intent(ConstantsKt.getON_INIT_GOOGLE_PAY());
        intent.putExtra("isReady", z);
        LocalBroadcastManager localBroadcastManager2 = this.localBroadcastManager;
        if (localBroadcastManager2 != null) {
            localBroadcastManager2.sendBroadcast(intent);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("localBroadcastManager");
            throw null;
        }
    }

    /* access modifiers changed from: private */
    public final void onGooglePayResult(GooglePayLauncher.Result result) {
        Intent intent = new Intent(ConstantsKt.getON_GOOGLE_PAY_RESULT());
        intent.putExtra("paymentResult", result);
        LocalBroadcastManager localBroadcastManager2 = this.localBroadcastManager;
        if (localBroadcastManager2 != null) {
            localBroadcastManager2.sendBroadcast(intent);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("localBroadcastManager");
            throw null;
        }
    }

    /* access modifiers changed from: private */
    public final void onGooglePayResult(GooglePayPaymentMethodLauncher.Result result) {
        Intent intent = new Intent(ConstantsKt.getON_GOOGLE_PAYMENT_METHOD_RESULT());
        intent.putExtra("paymentResult", result);
        LocalBroadcastManager localBroadcastManager2 = this.localBroadcastManager;
        if (localBroadcastManager2 != null) {
            localBroadcastManager2.sendBroadcast(intent);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("localBroadcastManager");
            throw null;
        }
    }

    private final GooglePayLauncher.BillingAddressConfig mapToGooglePayLauncherBillingAddressConfig(String str, boolean z, boolean z2) {
        GooglePayLauncher.BillingAddressConfig.Format format;
        if (Intrinsics.areEqual((Object) str, (Object) "FULL")) {
            format = GooglePayLauncher.BillingAddressConfig.Format.Full;
        } else if (Intrinsics.areEqual((Object) str, (Object) "MIN")) {
            format = GooglePayLauncher.BillingAddressConfig.Format.Min;
        } else {
            format = GooglePayLauncher.BillingAddressConfig.Format.Min;
        }
        return new GooglePayLauncher.BillingAddressConfig(z, format, z2);
    }

    private final GooglePayPaymentMethodLauncher.BillingAddressConfig mapToGooglePayPaymentMethodLauncherBillingAddressConfig(String str, boolean z, boolean z2) {
        GooglePayPaymentMethodLauncher.BillingAddressConfig.Format format;
        if (Intrinsics.areEqual((Object) str, (Object) "FULL")) {
            format = GooglePayPaymentMethodLauncher.BillingAddressConfig.Format.Full;
        } else if (Intrinsics.areEqual((Object) str, (Object) "MIN")) {
            format = GooglePayPaymentMethodLauncher.BillingAddressConfig.Format.Min;
        } else {
            format = GooglePayPaymentMethodLauncher.BillingAddressConfig.Format.Min;
        }
        return new GooglePayPaymentMethodLauncher.BillingAddressConfig(z, format, z2);
    }
}
