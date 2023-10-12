package com.reactnativestripesdk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.stripe.android.payments.bankaccount.CollectBankAccountConfiguration;
import com.stripe.android.payments.bankaccount.CollectBankAccountLauncher;
import com.stripe.android.payments.bankaccount.navigation.CollectBankAccountResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u0010\u001a\u00020\u000fH\u0002J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/reactnativestripesdk/CollectBankAccountLauncherFragment;", "Landroidx/fragment/app/Fragment;", "context", "Lcom/facebook/react/bridge/ReactApplicationContext;", "publishableKey", "", "clientSecret", "isPaymentIntent", "", "collectParams", "Lcom/stripe/android/payments/bankaccount/CollectBankAccountConfiguration$USBankAccount;", "promise", "Lcom/facebook/react/bridge/Promise;", "(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/lang/String;Ljava/lang/String;ZLcom/stripe/android/payments/bankaccount/CollectBankAccountConfiguration$USBankAccount;Lcom/facebook/react/bridge/Promise;)V", "collectBankAccountLauncher", "Lcom/stripe/android/payments/bankaccount/CollectBankAccountLauncher;", "createBankAccountLauncher", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CollectBankAccountLauncherFragment.kt */
public final class CollectBankAccountLauncherFragment extends Fragment {
    private final String clientSecret;
    private CollectBankAccountLauncher collectBankAccountLauncher;
    private final CollectBankAccountConfiguration.USBankAccount collectParams;
    /* access modifiers changed from: private */
    public final ReactApplicationContext context;
    /* access modifiers changed from: private */
    public final boolean isPaymentIntent;
    /* access modifiers changed from: private */
    public final Promise promise;
    private final String publishableKey;

    public CollectBankAccountLauncherFragment(ReactApplicationContext reactApplicationContext, String str, String str2, boolean z, CollectBankAccountConfiguration.USBankAccount uSBankAccount, Promise promise2) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "context");
        Intrinsics.checkNotNullParameter(str, "publishableKey");
        Intrinsics.checkNotNullParameter(str2, "clientSecret");
        Intrinsics.checkNotNullParameter(uSBankAccount, "collectParams");
        Intrinsics.checkNotNullParameter(promise2, BaseJavaModule.METHOD_TYPE_PROMISE);
        this.context = reactApplicationContext;
        this.publishableKey = str;
        this.clientSecret = str2;
        this.isPaymentIntent = z;
        this.collectParams = uSBankAccount;
        this.promise = promise2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this.collectBankAccountLauncher = createBankAccountLauncher();
        FrameLayout frameLayout = new FrameLayout(requireActivity());
        frameLayout.setVisibility(8);
        return frameLayout;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        if (this.isPaymentIntent) {
            CollectBankAccountLauncher collectBankAccountLauncher2 = this.collectBankAccountLauncher;
            if (collectBankAccountLauncher2 != null) {
                collectBankAccountLauncher2.presentWithPaymentIntent(this.publishableKey, this.clientSecret, this.collectParams);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("collectBankAccountLauncher");
                throw null;
            }
        } else {
            CollectBankAccountLauncher collectBankAccountLauncher3 = this.collectBankAccountLauncher;
            if (collectBankAccountLauncher3 != null) {
                collectBankAccountLauncher3.presentWithSetupIntent(this.publishableKey, this.clientSecret, this.collectParams);
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("collectBankAccountLauncher");
                throw null;
            }
        }
    }

    private final CollectBankAccountLauncher createBankAccountLauncher() {
        return CollectBankAccountLauncher.Companion.create((Fragment) this, (Function1<? super CollectBankAccountResult, Unit>) new CollectBankAccountLauncherFragment$createBankAccountLauncher$1(this));
    }
}
