package com.reactnativestripesdk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.stripe.android.Stripe;
import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.ConfirmSetupIntentParams;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.payments.paymentlauncher.PaymentLauncher;
import com.stripe.android.payments.paymentlauncher.PaymentResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u0014\u001a\u00020\fH\u0002J\u0016\u0010\u0015\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ\u0012\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\"\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/reactnativestripesdk/PaymentLauncherFragment;", "Landroidx/fragment/app/Fragment;", "stripe", "Lcom/stripe/android/Stripe;", "publishableKey", "", "stripeAccountId", "(Lcom/stripe/android/Stripe;Ljava/lang/String;Ljava/lang/String;)V", "clientSecret", "isPaymentIntent", "", "paymentLauncher", "Lcom/stripe/android/payments/paymentlauncher/PaymentLauncher;", "promise", "Lcom/facebook/react/bridge/Promise;", "confirm", "", "params", "Lcom/stripe/android/model/ConfirmPaymentIntentParams;", "Lcom/stripe/android/model/ConfirmSetupIntentParams;", "createPaymentLauncher", "handleNextActionForPaymentIntent", "isNextActionSuccessState", "nextAction", "Lcom/stripe/android/model/StripeIntent$NextActionType;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "retrievePaymentIntent", "retrieveSetupIntent", "stripe_stripe-react-native_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: PaymentLauncherFragment.kt */
public final class PaymentLauncherFragment extends Fragment {
    private String clientSecret;
    private boolean isPaymentIntent = true;
    private PaymentLauncher paymentLauncher;
    private Promise promise;
    private final String publishableKey;
    private final Stripe stripe;
    private final String stripeAccountId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: PaymentLauncherFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StripeIntent.NextActionType.values().length];
            iArr[StripeIntent.NextActionType.DisplayOxxoDetails.ordinal()] = 1;
            iArr[StripeIntent.NextActionType.VerifyWithMicrodeposits.ordinal()] = 2;
            iArr[StripeIntent.NextActionType.RedirectToUrl.ordinal()] = 3;
            iArr[StripeIntent.NextActionType.UseStripeSdk.ordinal()] = 4;
            iArr[StripeIntent.NextActionType.AlipayRedirect.ordinal()] = 5;
            iArr[StripeIntent.NextActionType.BlikAuthorize.ordinal()] = 6;
            iArr[StripeIntent.NextActionType.WeChatPayRedirect.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PaymentLauncherFragment(Stripe stripe2, String str, String str2) {
        Intrinsics.checkNotNullParameter(stripe2, "stripe");
        Intrinsics.checkNotNullParameter(str, "publishableKey");
        this.stripe = stripe2;
        this.publishableKey = str;
        this.stripeAccountId = str2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        this.paymentLauncher = createPaymentLauncher();
        FrameLayout frameLayout = new FrameLayout(requireActivity());
        frameLayout.setVisibility(8);
        return frameLayout;
    }

    public final void handleNextActionForPaymentIntent(String str, Promise promise2) {
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(promise2, BaseJavaModule.METHOD_TYPE_PROMISE);
        this.clientSecret = str;
        this.promise = promise2;
        PaymentLauncher paymentLauncher2 = this.paymentLauncher;
        if (paymentLauncher2 != null) {
            paymentLauncher2.handleNextActionForPaymentIntent(str);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("paymentLauncher");
            throw null;
        }
    }

    public final void confirm(ConfirmPaymentIntentParams confirmPaymentIntentParams, String str, Promise promise2) {
        Intrinsics.checkNotNullParameter(confirmPaymentIntentParams, "params");
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(promise2, BaseJavaModule.METHOD_TYPE_PROMISE);
        this.clientSecret = str;
        this.promise = promise2;
        this.isPaymentIntent = true;
        PaymentLauncher paymentLauncher2 = this.paymentLauncher;
        if (paymentLauncher2 != null) {
            paymentLauncher2.confirm(confirmPaymentIntentParams);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("paymentLauncher");
            throw null;
        }
    }

    public final void confirm(ConfirmSetupIntentParams confirmSetupIntentParams, String str, Promise promise2) {
        Intrinsics.checkNotNullParameter(confirmSetupIntentParams, "params");
        Intrinsics.checkNotNullParameter(str, "clientSecret");
        Intrinsics.checkNotNullParameter(promise2, BaseJavaModule.METHOD_TYPE_PROMISE);
        this.clientSecret = str;
        this.promise = promise2;
        this.isPaymentIntent = false;
        PaymentLauncher paymentLauncher2 = this.paymentLauncher;
        if (paymentLauncher2 != null) {
            paymentLauncher2.confirm(confirmSetupIntentParams);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("paymentLauncher");
            throw null;
        }
    }

    private final PaymentLauncher createPaymentLauncher() {
        return PaymentLauncher.Companion.create((Fragment) this, this.publishableKey, this.stripeAccountId, (PaymentLauncher.PaymentResultCallback) new PaymentLauncher.PaymentResultCallback() {
            public final void onPaymentResult(PaymentResult paymentResult) {
                PaymentLauncherFragment.m4275createPaymentLauncher$lambda3(PaymentLauncherFragment.this, paymentResult);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: createPaymentLauncher$lambda-3  reason: not valid java name */
    public static final void m4275createPaymentLauncher$lambda3(PaymentLauncherFragment paymentLauncherFragment, PaymentResult paymentResult) {
        Unit unit;
        Intrinsics.checkNotNullParameter(paymentLauncherFragment, "this$0");
        Intrinsics.checkNotNullParameter(paymentResult, "paymentResult");
        Unit unit2 = null;
        if (paymentResult instanceof PaymentResult.Completed) {
            String str = paymentLauncherFragment.clientSecret;
            if (str == null) {
                unit = null;
            } else {
                if (paymentLauncherFragment.isPaymentIntent) {
                    paymentLauncherFragment.retrievePaymentIntent(str, paymentLauncherFragment.stripeAccountId);
                } else {
                    paymentLauncherFragment.retrieveSetupIntent(str, paymentLauncherFragment.stripeAccountId);
                }
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                Promise promise2 = paymentLauncherFragment.promise;
                if (promise2 != null) {
                    promise2.resolve(ErrorsKt.createError(ConfirmPaymentErrorType.Failed.toString(), "Client secret must be set before responding to payment results."));
                    unit2 = Unit.INSTANCE;
                }
                if (unit2 == null) {
                    throw new Exception("Client secret must be set before responding to payment results.");
                }
            }
        } else if (paymentResult instanceof PaymentResult.Canceled) {
            Promise promise3 = paymentLauncherFragment.promise;
            if (promise3 != null) {
                promise3.resolve(ErrorsKt.createError(ConfirmPaymentErrorType.Canceled.toString(), (String) null));
                unit2 = Unit.INSTANCE;
            }
            if (unit2 == null) {
                throw new Exception("No promise is set to handle payment results.");
            }
        } else if (paymentResult instanceof PaymentResult.Failed) {
            Promise promise4 = paymentLauncherFragment.promise;
            if (promise4 != null) {
                promise4.resolve(ErrorsKt.createError(ConfirmPaymentErrorType.Failed.toString(), ((PaymentResult.Failed) paymentResult).getThrowable().getLocalizedMessage()));
                unit2 = Unit.INSTANCE;
            }
            if (unit2 == null) {
                throw new Exception("No promise is set to handle payment results.");
            }
        }
    }

    private final void retrieveSetupIntent(String str, String str2) {
        Promise promise2 = this.promise;
        if (promise2 != null) {
            this.stripe.retrieveSetupIntent(str, str2, new PaymentLauncherFragment$retrieveSetupIntent$1(promise2, this));
            return;
        }
        throw new Exception("No promise is set to handle payment results.");
    }

    private final void retrievePaymentIntent(String str, String str2) {
        Promise promise2 = this.promise;
        if (promise2 != null) {
            this.stripe.retrievePaymentIntent(str, str2, new PaymentLauncherFragment$retrievePaymentIntent$1(promise2, this));
            return;
        }
        throw new Exception("No promise is set to handle payment results.");
    }

    /* access modifiers changed from: private */
    public final boolean isNextActionSuccessState(StripeIntent.NextActionType nextActionType) {
        switch (nextActionType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[nextActionType.ordinal()]) {
            case -1:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return false;
            case 1:
            case 2:
                return true;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
