package com.stripe.android.paymentsheet;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistryOwner;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.reactnativecommunity.webview.events.TopMessageEvent;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncher;
import com.stripe.android.googlepaylauncher.GooglePayPaymentMethodLauncherContract;
import com.stripe.android.link.ui.LinkViewButton;
import com.stripe.android.model.ConfirmStripeIntentParams;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.PaymentSheetContract;
import com.stripe.android.paymentsheet.PaymentSheetResult;
import com.stripe.android.paymentsheet.PaymentSheetViewModel;
import com.stripe.android.paymentsheet.databinding.ActivityPaymentSheetBinding;
import com.stripe.android.paymentsheet.model.FragmentConfig;
import com.stripe.android.paymentsheet.model.PaymentSelection;
import com.stripe.android.paymentsheet.model.PaymentSheetViewState;
import com.stripe.android.paymentsheet.ui.AnimationConstants;
import com.stripe.android.paymentsheet.ui.BaseSheetActivity;
import com.stripe.android.paymentsheet.ui.GooglePayButton;
import com.stripe.android.paymentsheet.ui.PrimaryButton;
import com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel;
import com.stripe.android.ui.core.Amount;
import com.stripe.android.ui.core.PaymentsTheme;
import com.stripe.android.ui.core.PaymentsThemeDefaults;
import com.stripe.android.ui.core.PaymentsThemeKt;
import com.stripe.android.ui.core.PrimaryButtonModifier;
import java.security.InvalidParameterException;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 p2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001pB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010c\u001a\u00020\u0015H\u0016J\u0012\u0010d\u001a\u00020\u00152\b\u0010e\u001a\u0004\u0018\u00010fH\u0014J\u0018\u0010g\u001a\u00020\u00152\u0006\u0010h\u001a\u00020i2\u0006\u0010j\u001a\u00020fH\u0002J\u0010\u0010k\u001a\u00020\u00152\u0006\u0010l\u001a\u00020\u0002H\u0016J\b\u0010m\u001a\u00020\u0015H\u0002J\b\u0010n\u001a\u00020\u0015H\u0002J\b\u0010o\u001a\u00020\u0015H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058VX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8VX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000f\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0010\u0010\rR\u001c\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00150\u0013X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178CX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u000b8VX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001b\u0010\rR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020#8BX\u0002¢\u0006\f\n\u0004\b&\u0010\t\u001a\u0004\b$\u0010%R\u001b\u0010'\u001a\u00020#8VX\u0002¢\u0006\f\n\u0004\b)\u0010\t\u001a\u0004\b(\u0010%R\u001b\u0010*\u001a\u00020+8BX\u0002¢\u0006\f\n\u0004\b.\u0010\t\u001a\u0004\b,\u0010-R\u001b\u0010/\u001a\u0002008VX\u0002¢\u0006\f\n\u0004\b3\u0010\t\u001a\u0004\b1\u00102R\u001b\u00104\u001a\u00020\u000b8VX\u0002¢\u0006\f\n\u0004\b6\u0010\t\u001a\u0004\b5\u0010\rR\u001b\u00107\u001a\u0002088VX\u0002¢\u0006\f\n\u0004\b;\u0010\t\u001a\u0004\b9\u0010:R\u001d\u0010<\u001a\u0004\u0018\u00010=8BX\u0002¢\u0006\f\n\u0004\b@\u0010\t\u001a\u0004\b>\u0010?R\u001b\u0010A\u001a\u0002008VX\u0002¢\u0006\f\n\u0004\bC\u0010\t\u001a\u0004\bB\u00102R\u001b\u0010D\u001a\u00020E8VX\u0002¢\u0006\f\n\u0004\bH\u0010\t\u001a\u0004\bF\u0010GR\u001b\u0010I\u001a\u00020J8BX\u0002¢\u0006\f\n\u0004\bM\u0010\t\u001a\u0004\bK\u0010LR\u001b\u0010N\u001a\u0002008BX\u0002¢\u0006\f\n\u0004\bP\u0010\t\u001a\u0004\bO\u00102R!\u0010Q\u001a\u00020R8@X\u0002¢\u0006\u0012\n\u0004\bV\u0010\t\u0012\u0004\bS\u0010\u0003\u001a\u0004\bT\u0010UR\u001b\u0010W\u001a\u00020X8VX\u0002¢\u0006\f\n\u0004\b[\u0010\t\u001a\u0004\bY\u0010ZR$\u0010\\\u001a\u00020]8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b^\u0010\u0003\u001a\u0004\b_\u0010`\"\u0004\ba\u0010b¨\u0006q"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheetActivity;", "Lcom/stripe/android/paymentsheet/ui/BaseSheetActivity;", "Lcom/stripe/android/paymentsheet/PaymentSheetResult;", "()V", "appbar", "Lcom/google/android/material/appbar/AppBarLayout;", "getAppbar", "()Lcom/google/android/material/appbar/AppBarLayout;", "appbar$delegate", "Lkotlin/Lazy;", "bottomSheet", "Landroid/view/ViewGroup;", "getBottomSheet", "()Landroid/view/ViewGroup;", "bottomSheet$delegate", "buttonContainer", "getButtonContainer", "buttonContainer$delegate", "buyButtonStateObserver", "Lkotlin/Function1;", "Lcom/stripe/android/paymentsheet/model/PaymentSheetViewState;", "", "fragmentContainerId", "", "getFragmentContainerId", "()I", "fragmentContainerParent", "getFragmentContainerParent", "fragmentContainerParent$delegate", "googlePayButton", "Lcom/stripe/android/paymentsheet/ui/GooglePayButton;", "getGooglePayButton", "()Lcom/stripe/android/paymentsheet/ui/GooglePayButton;", "googlePayButton$delegate", "googlePayDivider", "Landroidx/compose/ui/platform/ComposeView;", "getGooglePayDivider", "()Landroidx/compose/ui/platform/ComposeView;", "googlePayDivider$delegate", "header", "getHeader", "header$delegate", "linkButton", "Lcom/stripe/android/link/ui/LinkViewButton;", "getLinkButton", "()Lcom/stripe/android/link/ui/LinkViewButton;", "linkButton$delegate", "messageView", "Landroid/widget/TextView;", "getMessageView", "()Landroid/widget/TextView;", "messageView$delegate", "rootView", "getRootView", "rootView$delegate", "scrollView", "Landroid/widget/ScrollView;", "getScrollView", "()Landroid/widget/ScrollView;", "scrollView$delegate", "starterArgs", "Lcom/stripe/android/paymentsheet/PaymentSheetContract$Args;", "getStarterArgs", "()Lcom/stripe/android/paymentsheet/PaymentSheetContract$Args;", "starterArgs$delegate", "testModeIndicator", "getTestModeIndicator", "testModeIndicator$delegate", "toolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "getToolbar", "()Lcom/google/android/material/appbar/MaterialToolbar;", "toolbar$delegate", "topContainer", "Landroid/widget/LinearLayout;", "getTopContainer", "()Landroid/widget/LinearLayout;", "topContainer$delegate", "topMessage", "getTopMessage", "topMessage$delegate", "viewBinding", "Lcom/stripe/android/paymentsheet/databinding/ActivityPaymentSheetBinding;", "getViewBinding$paymentsheet_release$annotations", "getViewBinding$paymentsheet_release", "()Lcom/stripe/android/paymentsheet/databinding/ActivityPaymentSheetBinding;", "viewBinding$delegate", "viewModel", "Lcom/stripe/android/paymentsheet/PaymentSheetViewModel;", "getViewModel", "()Lcom/stripe/android/paymentsheet/PaymentSheetViewModel;", "viewModel$delegate", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory$paymentsheet_release$annotations", "getViewModelFactory$paymentsheet_release", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory$paymentsheet_release", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "clearErrorMessages", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onTransitionTarget", "transitionTarget", "Lcom/stripe/android/paymentsheet/PaymentSheetViewModel$TransitionTarget;", "fragmentArgs", "setActivityResult", "result", "setupBuyButton", "setupGooglePayButton", "setupTopContainer", "Companion", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSheetActivity.kt */
public final class PaymentSheetActivity extends BaseSheetActivity<PaymentSheetResult> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_FRAGMENT_CONFIG = "com.stripe.android.paymentsheet.extra_fragment_config";
    public static final String EXTRA_STARTER_ARGS = "com.stripe.android.paymentsheet.extra_starter_args";
    private final Lazy appbar$delegate;
    private final Lazy bottomSheet$delegate;
    private final Lazy buttonContainer$delegate;
    private final Function1<PaymentSheetViewState, Unit> buyButtonStateObserver;
    private final Lazy fragmentContainerParent$delegate;
    private final Lazy googlePayButton$delegate;
    private final Lazy googlePayDivider$delegate;
    private final Lazy header$delegate;
    private final Lazy linkButton$delegate;
    private final Lazy messageView$delegate;
    private final Lazy rootView$delegate;
    private final Lazy scrollView$delegate;
    private final Lazy starterArgs$delegate;
    private final Lazy testModeIndicator$delegate;
    private final Lazy toolbar$delegate;
    private final Lazy topContainer$delegate;
    private final Lazy topMessage$delegate;
    private final Lazy viewBinding$delegate = LazyKt.lazy(new PaymentSheetActivity$viewBinding$2(this));
    private final Lazy viewModel$delegate;
    private ViewModelProvider.Factory viewModelFactory;

    public static /* synthetic */ void getViewBinding$paymentsheet_release$annotations() {
    }

    public static /* synthetic */ void getViewModelFactory$paymentsheet_release$annotations() {
    }

    public PaymentSheetActivity() {
        Function0 paymentSheetActivity$viewModelFactory$1 = new PaymentSheetActivity$viewModelFactory$1(this);
        Function0 paymentSheetActivity$viewModelFactory$2 = new PaymentSheetActivity$viewModelFactory$2(this);
        SavedStateRegistryOwner savedStateRegistryOwner = this;
        Intent intent = getIntent();
        this.viewModelFactory = new PaymentSheetViewModel.Factory(paymentSheetActivity$viewModelFactory$1, paymentSheetActivity$viewModelFactory$2, savedStateRegistryOwner, intent == null ? null : intent.getExtras());
        ComponentActivity componentActivity = this;
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(PaymentSheetViewModel.class), new PaymentSheetActivity$special$$inlined$viewModels$default$2(componentActivity), new PaymentSheetActivity$viewModel$2(this), new PaymentSheetActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
        this.starterArgs$delegate = LazyKt.lazy(new PaymentSheetActivity$starterArgs$2(this));
        this.rootView$delegate = LazyKt.lazy(new PaymentSheetActivity$rootView$2(this));
        this.bottomSheet$delegate = LazyKt.lazy(new PaymentSheetActivity$bottomSheet$2(this));
        this.appbar$delegate = LazyKt.lazy(new PaymentSheetActivity$appbar$2(this));
        this.toolbar$delegate = LazyKt.lazy(new PaymentSheetActivity$toolbar$2(this));
        this.testModeIndicator$delegate = LazyKt.lazy(new PaymentSheetActivity$testModeIndicator$2(this));
        this.scrollView$delegate = LazyKt.lazy(new PaymentSheetActivity$scrollView$2(this));
        this.header$delegate = LazyKt.lazy(new PaymentSheetActivity$header$2(this));
        this.fragmentContainerParent$delegate = LazyKt.lazy(new PaymentSheetActivity$fragmentContainerParent$2(this));
        this.messageView$delegate = LazyKt.lazy(new PaymentSheetActivity$messageView$2(this));
        this.buttonContainer$delegate = LazyKt.lazy(new PaymentSheetActivity$buttonContainer$2(this));
        this.topContainer$delegate = LazyKt.lazy(new PaymentSheetActivity$topContainer$2(this));
        this.googlePayButton$delegate = LazyKt.lazy(new PaymentSheetActivity$googlePayButton$2(this));
        this.linkButton$delegate = LazyKt.lazy(new PaymentSheetActivity$linkButton$2(this));
        this.topMessage$delegate = LazyKt.lazy(new PaymentSheetActivity$topMessage$2(this));
        this.googlePayDivider$delegate = LazyKt.lazy(new PaymentSheetActivity$googlePayDivider$2(this));
        this.buyButtonStateObserver = new PaymentSheetActivity$buyButtonStateObserver$1(this);
    }

    public final ActivityPaymentSheetBinding getViewBinding$paymentsheet_release() {
        return (ActivityPaymentSheetBinding) this.viewBinding$delegate.getValue();
    }

    public final ViewModelProvider.Factory getViewModelFactory$paymentsheet_release() {
        return this.viewModelFactory;
    }

    public final void setViewModelFactory$paymentsheet_release(ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.viewModelFactory = factory;
    }

    public PaymentSheetViewModel getViewModel() {
        return (PaymentSheetViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final PaymentSheetContract.Args getStarterArgs() {
        return (PaymentSheetContract.Args) this.starterArgs$delegate.getValue();
    }

    private final int getFragmentContainerId() {
        return getViewBinding$paymentsheet_release().fragmentContainer.getId();
    }

    public ViewGroup getRootView() {
        Object value = this.rootView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-rootView>(...)");
        return (ViewGroup) value;
    }

    public ViewGroup getBottomSheet() {
        Object value = this.bottomSheet$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-bottomSheet>(...)");
        return (ViewGroup) value;
    }

    public AppBarLayout getAppbar() {
        return (AppBarLayout) this.appbar$delegate.getValue();
    }

    public MaterialToolbar getToolbar() {
        return (MaterialToolbar) this.toolbar$delegate.getValue();
    }

    public TextView getTestModeIndicator() {
        return (TextView) this.testModeIndicator$delegate.getValue();
    }

    public ScrollView getScrollView() {
        return (ScrollView) this.scrollView$delegate.getValue();
    }

    public ComposeView getHeader() {
        return (ComposeView) this.header$delegate.getValue();
    }

    public ViewGroup getFragmentContainerParent() {
        Object value = this.fragmentContainerParent$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-fragmentContainerParent>(...)");
        return (ViewGroup) value;
    }

    public TextView getMessageView() {
        return (TextView) this.messageView$delegate.getValue();
    }

    private final ViewGroup getButtonContainer() {
        Object value = this.buttonContainer$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-buttonContainer>(...)");
        return (ViewGroup) value;
    }

    private final LinearLayout getTopContainer() {
        return (LinearLayout) this.topContainer$delegate.getValue();
    }

    private final GooglePayButton getGooglePayButton() {
        return (GooglePayButton) this.googlePayButton$delegate.getValue();
    }

    private final LinkViewButton getLinkButton() {
        return (LinkViewButton) this.linkButton$delegate.getValue();
    }

    private final TextView getTopMessage() {
        return (TextView) this.topMessage$delegate.getValue();
    }

    private final ComposeView getGooglePayDivider() {
        return (ComposeView) this.googlePayDivider$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PaymentSheetContract.Args starterArgs = getStarterArgs();
        if (starterArgs == null) {
            setActivityResult((PaymentSheetResult) new PaymentSheetResult.Failed(new IllegalArgumentException("PaymentSheet started without arguments.")));
            finish();
            return;
        }
        try {
            PaymentSheet.Configuration config$paymentsheet_release = starterArgs.getConfig$paymentsheet_release();
            if (config$paymentsheet_release != null) {
                PaymentSheetConfigurationKtxKt.validate(config$paymentsheet_release);
            }
            starterArgs.getClientSecret$paymentsheet_release().validate();
            LifecycleOwner lifecycleOwner = this;
            ActivityResultLauncher registerForActivityResult = registerForActivityResult(new GooglePayPaymentMethodLauncherContract(), new ActivityResultCallback() {
                public final void onActivityResult(Object obj) {
                    PaymentSheetViewModel.this.onGooglePayResult$paymentsheet_release((GooglePayPaymentMethodLauncher.Result) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…lePayResult\n            )");
            getViewModel().setupGooglePay(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), registerForActivityResult);
            if (!getViewModel().maybeFetchStripeIntent$paymentsheet_release()) {
                getButtonContainer().setVisibility(0);
                PrimaryButton primaryButton = getViewBinding$paymentsheet_release().buyButton;
                Intrinsics.checkNotNullExpressionValue(primaryButton, "viewBinding.buyButton");
                primaryButton.setVisibility(0);
            }
            Integer statusBarColor$paymentsheet_release = starterArgs.getStatusBarColor$paymentsheet_release();
            if (statusBarColor$paymentsheet_release != null) {
                getWindow().setStatusBarColor(statusBarColor$paymentsheet_release.intValue());
            }
            setContentView((View) getViewBinding$paymentsheet_release().getRoot());
            getRootView().addOnLayoutChangeListener(new PaymentSheetActivity$onCreate$$inlined$doOnNextLayout$1(this));
            setupBuyButton();
            setupTopContainer();
            getLinkButton().setOnClick(new PaymentSheetActivity$onCreate$4$1(getViewModel()));
            getViewModel().getTransition$paymentsheet_release().observe(lifecycleOwner, new Observer(starterArgs) {
                public final /* synthetic */ PaymentSheetContract.Args f$1;

                {
                    this.f$1 = r2;
                }

                public final void onChanged(Object obj) {
                    PaymentSheetActivity.m4413onCreate$lambda5(PaymentSheetActivity.this, this.f$1, (BaseSheetViewModel.Event) obj);
                }
            });
            getViewModel().getFragmentConfigEvent().observe(lifecycleOwner, new Observer() {
                public final void onChanged(Object obj) {
                    PaymentSheetActivity.m4414onCreate$lambda6(PaymentSheetActivity.this, (BaseSheetViewModel.Event) obj);
                }
            });
            getViewModel().getStartConfirm$paymentsheet_release().observe(lifecycleOwner, new Observer() {
                public final void onChanged(Object obj) {
                    PaymentSheetActivity.m4415onCreate$lambda7(PaymentSheetActivity.this, (BaseSheetViewModel.Event) obj);
                }
            });
            getViewModel().getPaymentSheetResult$paymentsheet_release().observe(lifecycleOwner, new Observer() {
                public final void onChanged(Object obj) {
                    PaymentSheetActivity.m4416onCreate$lambda8(PaymentSheetActivity.this, (PaymentSheetResult) obj);
                }
            });
            getViewModel().getContentVisible$paymentsheet_release().observe(lifecycleOwner, new Observer() {
                public final void onChanged(Object obj) {
                    PaymentSheetActivity.m4417onCreate$lambda9(PaymentSheetActivity.this, (Boolean) obj);
                }
            });
            getViewModel().getButtonsEnabled().observe(lifecycleOwner, new Observer() {
                public final void onChanged(Object obj) {
                    PaymentSheetActivity.m4411onCreate$lambda10(PaymentSheetActivity.this, (Boolean) obj);
                }
            });
            getViewModel().getSelection$paymentsheet_release().observe(lifecycleOwner, new Observer() {
                public final void onChanged(Object obj) {
                    PaymentSheetActivity.m4412onCreate$lambda11(PaymentSheetActivity.this, (PaymentSelection) obj);
                }
            });
        } catch (InvalidParameterException e) {
            setActivityResult((PaymentSheetResult) new PaymentSheetResult.Failed(e));
            finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-5  reason: not valid java name */
    public static final void m4413onCreate$lambda5(PaymentSheetActivity paymentSheetActivity, PaymentSheetContract.Args args, BaseSheetViewModel.Event event) {
        Intrinsics.checkNotNullParameter(paymentSheetActivity, "this$0");
        if (event != null) {
            paymentSheetActivity.clearErrorMessages();
            PaymentSheetViewModel.TransitionTarget transitionTarget = (PaymentSheetViewModel.TransitionTarget) event.getContentIfNotHandled();
            if (transitionTarget != null) {
                paymentSheetActivity.onTransitionTarget(transitionTarget, BundleKt.bundleOf(TuplesKt.to("com.stripe.android.paymentsheet.extra_starter_args", args), TuplesKt.to("com.stripe.android.paymentsheet.extra_fragment_config", transitionTarget.getFragmentConfig())));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-6  reason: not valid java name */
    public static final void m4414onCreate$lambda6(PaymentSheetActivity paymentSheetActivity, BaseSheetViewModel.Event event) {
        PaymentSheetViewModel.TransitionTarget transitionTarget;
        Intrinsics.checkNotNullParameter(paymentSheetActivity, "this$0");
        FragmentConfig fragmentConfig = (FragmentConfig) event.getContentIfNotHandled();
        if (fragmentConfig != null) {
            List<Fragment> fragments = paymentSheetActivity.getSupportFragmentManager().getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
            if (CollectionsKt.firstOrNull(fragments) instanceof PaymentSheetLoadingFragment) {
                Collection value = paymentSheetActivity.getViewModel().getPaymentMethods$paymentsheet_release().getValue();
                if (value == null || value.isEmpty()) {
                    paymentSheetActivity.getViewModel().updateSelection((PaymentSelection) null);
                    transitionTarget = new PaymentSheetViewModel.TransitionTarget.AddPaymentMethodSheet(fragmentConfig);
                } else {
                    transitionTarget = new PaymentSheetViewModel.TransitionTarget.SelectSavedPaymentMethod(fragmentConfig);
                }
                paymentSheetActivity.getViewModel().transitionTo(transitionTarget);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-7  reason: not valid java name */
    public static final void m4415onCreate$lambda7(PaymentSheetActivity paymentSheetActivity, BaseSheetViewModel.Event event) {
        Intrinsics.checkNotNullParameter(paymentSheetActivity, "this$0");
        ConfirmStripeIntentParams confirmStripeIntentParams = (ConfirmStripeIntentParams) event.getContentIfNotHandled();
        if (confirmStripeIntentParams != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(paymentSheetActivity), (CoroutineContext) null, (CoroutineStart) null, new PaymentSheetActivity$onCreate$7$1(paymentSheetActivity, confirmStripeIntentParams, (Continuation<? super PaymentSheetActivity$onCreate$7$1>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-8  reason: not valid java name */
    public static final void m4416onCreate$lambda8(PaymentSheetActivity paymentSheetActivity, PaymentSheetResult paymentSheetResult) {
        Intrinsics.checkNotNullParameter(paymentSheetActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(paymentSheetResult, "it");
        paymentSheetActivity.closeSheet(paymentSheetResult);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-9  reason: not valid java name */
    public static final void m4417onCreate$lambda9(PaymentSheetActivity paymentSheetActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(paymentSheetActivity, "this$0");
        ScrollView scrollView = paymentSheetActivity.getViewBinding$paymentsheet_release().scrollView;
        Intrinsics.checkNotNullExpressionValue(scrollView, "viewBinding.scrollView");
        View view = scrollView;
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        view.setVisibility(bool.booleanValue() ? 0 : 8);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-10  reason: not valid java name */
    public static final void m4411onCreate$lambda10(PaymentSheetActivity paymentSheetActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(paymentSheetActivity, "this$0");
        LinkViewButton linkButton = paymentSheetActivity.getLinkButton();
        Intrinsics.checkNotNullExpressionValue(bool, ViewProps.ENABLED);
        linkButton.setEnabled(bool.booleanValue());
        paymentSheetActivity.getGooglePayButton().setEnabled(bool.booleanValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-11  reason: not valid java name */
    public static final void m4412onCreate$lambda11(PaymentSheetActivity paymentSheetActivity, PaymentSelection paymentSelection) {
        Intrinsics.checkNotNullParameter(paymentSheetActivity, "this$0");
        paymentSheetActivity.clearErrorMessages();
    }

    private final void onTransitionTarget(PaymentSheetViewModel.TransitionTarget transitionTarget, Bundle bundle) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        if (transitionTarget instanceof PaymentSheetViewModel.TransitionTarget.AddPaymentMethodFull) {
            beginTransaction.setCustomAnimations(AnimationConstants.INSTANCE.getFADE_IN(), AnimationConstants.INSTANCE.getFADE_OUT(), AnimationConstants.INSTANCE.getFADE_IN(), AnimationConstants.INSTANCE.getFADE_OUT());
            beginTransaction.addToBackStack((String) null);
            beginTransaction.replace(getFragmentContainerId(), (Class<? extends Fragment>) PaymentSheetAddPaymentMethodFragment.class, bundle);
        } else if (transitionTarget instanceof PaymentSheetViewModel.TransitionTarget.SelectSavedPaymentMethod) {
            beginTransaction.setCustomAnimations(AnimationConstants.INSTANCE.getFADE_IN(), AnimationConstants.INSTANCE.getFADE_OUT(), AnimationConstants.INSTANCE.getFADE_IN(), AnimationConstants.INSTANCE.getFADE_OUT());
            beginTransaction.replace(getFragmentContainerId(), (Class<? extends Fragment>) PaymentSheetListFragment.class, bundle);
        } else if (transitionTarget instanceof PaymentSheetViewModel.TransitionTarget.AddPaymentMethodSheet) {
            beginTransaction.setCustomAnimations(AnimationConstants.INSTANCE.getFADE_IN(), AnimationConstants.INSTANCE.getFADE_OUT(), AnimationConstants.INSTANCE.getFADE_IN(), AnimationConstants.INSTANCE.getFADE_OUT());
            beginTransaction.replace(getFragmentContainerId(), (Class<? extends Fragment>) PaymentSheetAddPaymentMethodFragment.class, bundle);
        }
        beginTransaction.commit();
        getButtonContainer().setVisibility(0);
    }

    private final void setupBuyButton() {
        if (getViewModel().isProcessingPaymentIntent$paymentsheet_release()) {
            getViewModel().getAmount$paymentsheet_release().observe(this, new Observer() {
                public final void onChanged(Object obj) {
                    PaymentSheetActivity.m4418setupBuyButton$lambda13(PaymentSheetActivity.this, (Amount) obj);
                }
            });
        } else {
            getViewBinding$paymentsheet_release().buyButton.setLabel(getResources().getString(R.string.stripe_setup_button_label));
        }
        LifecycleOwner lifecycleOwner = this;
        getViewModel().getButtonStateObservable$paymentsheet_release(PaymentSheetViewModel.CheckoutIdentifier.SheetBottomBuy).observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PaymentSheetActivity.m4419setupBuyButton$lambda14(Function1.this, (PaymentSheetViewState) obj);
            }
        });
        PaymentSheet.Configuration config$paymentsheet_release = getViewModel().getConfig$paymentsheet_release();
        ColorStateList primaryButtonColor = config$paymentsheet_release == null ? null : config$paymentsheet_release.getPrimaryButtonColor();
        if (primaryButtonColor == null) {
            PrimaryButtonModifier primaryButtonModifierMutable = PaymentsTheme.INSTANCE.getPrimaryButtonModifierMutable();
            Context baseContext = getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
            primaryButtonColor = ColorStateList.valueOf(PaymentsThemeKt.getPrimaryColor(primaryButtonModifierMutable, baseContext));
            Intrinsics.checkNotNullExpressionValue(primaryButtonColor, "valueOf(\n            Pay…or(baseContext)\n        )");
        }
        getViewBinding$paymentsheet_release().buyButton.setAppearanceConfiguration(PaymentsTheme.INSTANCE.getPrimaryButtonModifierMutable(), primaryButtonColor);
        getViewBinding$paymentsheet_release().buyButton.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PaymentSheetActivity.m4420setupBuyButton$lambda15(PaymentSheetActivity.this, view);
            }
        });
        getViewModel().getCtaEnabled().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PaymentSheetActivity.m4421setupBuyButton$lambda16(PaymentSheetActivity.this, (Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: setupBuyButton$lambda-13  reason: not valid java name */
    public static final void m4418setupBuyButton$lambda13(PaymentSheetActivity paymentSheetActivity, Amount amount) {
        Intrinsics.checkNotNullParameter(paymentSheetActivity, "this$0");
        PrimaryButton primaryButton = paymentSheetActivity.getViewBinding$paymentsheet_release().buyButton;
        if (amount != null) {
            Resources resources = paymentSheetActivity.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            primaryButton.setLabel(amount.buildPayButtonLabel(resources));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: setupBuyButton$lambda-14  reason: not valid java name */
    public static final void m4419setupBuyButton$lambda14(Function1 function1, PaymentSheetViewState paymentSheetViewState) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(paymentSheetViewState);
    }

    /* access modifiers changed from: private */
    /* renamed from: setupBuyButton$lambda-15  reason: not valid java name */
    public static final void m4420setupBuyButton$lambda15(PaymentSheetActivity paymentSheetActivity, View view) {
        Intrinsics.checkNotNullParameter(paymentSheetActivity, "this$0");
        paymentSheetActivity.clearErrorMessages();
        paymentSheetActivity.getViewModel().checkout(PaymentSheetViewModel.CheckoutIdentifier.SheetBottomBuy);
    }

    /* access modifiers changed from: private */
    /* renamed from: setupBuyButton$lambda-16  reason: not valid java name */
    public static final void m4421setupBuyButton$lambda16(PaymentSheetActivity paymentSheetActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(paymentSheetActivity, "this$0");
        PrimaryButton primaryButton = paymentSheetActivity.getViewBinding$paymentsheet_release().buyButton;
        Intrinsics.checkNotNullExpressionValue(bool, "isEnabled");
        primaryButton.setEnabled(bool.booleanValue());
    }

    private final void setupTopContainer() {
        ComposeView googlePayDivider = getGooglePayDivider();
        googlePayDivider.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        googlePayDivider.setContent(ComposableLambdaKt.composableLambdaInstance(-985539946, true, new PaymentSheetActivity$setupTopContainer$1$1(googlePayDivider, this)));
        setupGooglePayButton();
        getViewModel().getShowTopContainer$paymentsheet_release().observe(this, new Observer() {
            public final void onChanged(Object obj) {
                PaymentSheetActivity.m4425setupTopContainer$lambda18(PaymentSheetActivity.this, (Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: setupTopContainer$lambda-18  reason: not valid java name */
    public static final void m4425setupTopContainer$lambda18(PaymentSheetActivity paymentSheetActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(paymentSheetActivity, "this$0");
        LinkViewButton linkButton = paymentSheetActivity.getLinkButton();
        Intrinsics.checkNotNullExpressionValue(linkButton, "linkButton");
        int i = 0;
        linkButton.setVisibility(Intrinsics.areEqual((Object) paymentSheetActivity.getViewModel().isLinkEnabled$paymentsheet_release().getValue(), (Object) true) ? 0 : 8);
        GooglePayButton googlePayButton = paymentSheetActivity.getGooglePayButton();
        Intrinsics.checkNotNullExpressionValue(googlePayButton, "googlePayButton");
        googlePayButton.setVisibility(Intrinsics.areEqual((Object) paymentSheetActivity.getViewModel().isGooglePayReady$paymentsheet_release().getValue(), (Object) true) ? 0 : 8);
        LinearLayout topContainer = paymentSheetActivity.getTopContainer();
        Intrinsics.checkNotNullExpressionValue(topContainer, "topContainer");
        View view = topContainer;
        Intrinsics.checkNotNullExpressionValue(bool, ViewProps.VISIBLE);
        if (!bool.booleanValue()) {
            i = 8;
        }
        view.setVisibility(i);
    }

    private final void setupGooglePayButton() {
        getGooglePayButton().setBackgroundColor(PaymentsThemeKt.m4516shouldUseDarkDynamicColor8_81llA(PaymentsThemeDefaults.INSTANCE.colors(PaymentsThemeKt.isSystemDarkTheme(this)).m4490getSurface0d7_KjU()));
        getGooglePayButton().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PaymentSheetActivity.m4422setupGooglePayButton$lambda19(PaymentSheetActivity.this, view);
            }
        });
        LifecycleOwner lifecycleOwner = this;
        getViewModel().getSelection$paymentsheet_release().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PaymentSheetActivity.m4423setupGooglePayButton$lambda20(PaymentSheetActivity.this, (PaymentSelection) obj);
            }
        });
        getViewModel().getButtonStateObservable$paymentsheet_release(PaymentSheetViewModel.CheckoutIdentifier.SheetTopGooglePay).observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PaymentSheetActivity.m4424setupGooglePayButton$lambda21(PaymentSheetActivity.this, (PaymentSheetViewState) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: setupGooglePayButton$lambda-19  reason: not valid java name */
    public static final void m4422setupGooglePayButton$lambda19(PaymentSheetActivity paymentSheetActivity, View view) {
        Intrinsics.checkNotNullParameter(paymentSheetActivity, "this$0");
        paymentSheetActivity.getViewModel().setContentVisible(false);
        paymentSheetActivity.getViewModel().setLastSelectedPaymentMethod$paymentsheet_release(paymentSheetActivity.getViewModel().getSelection$paymentsheet_release().getValue());
        paymentSheetActivity.getViewModel().updateSelection(PaymentSelection.GooglePay.INSTANCE);
    }

    /* access modifiers changed from: private */
    /* renamed from: setupGooglePayButton$lambda-20  reason: not valid java name */
    public static final void m4423setupGooglePayButton$lambda20(PaymentSheetActivity paymentSheetActivity, PaymentSelection paymentSelection) {
        Intrinsics.checkNotNullParameter(paymentSheetActivity, "this$0");
        if (Intrinsics.areEqual((Object) paymentSelection, (Object) PaymentSelection.GooglePay.INSTANCE)) {
            paymentSheetActivity.getViewModel().checkout(PaymentSheetViewModel.CheckoutIdentifier.SheetTopGooglePay);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: setupGooglePayButton$lambda-21  reason: not valid java name */
    public static final void m4424setupGooglePayButton$lambda21(PaymentSheetActivity paymentSheetActivity, PaymentSheetViewState paymentSheetViewState) {
        Intrinsics.checkNotNullParameter(paymentSheetActivity, "this$0");
        if (paymentSheetViewState instanceof PaymentSheetViewState.Reset) {
            paymentSheetActivity.getViewModel().updateSelection(paymentSheetActivity.getViewModel().getLastSelectedPaymentMethod$paymentsheet_release());
        }
        TextView topMessage = paymentSheetActivity.getTopMessage();
        Intrinsics.checkNotNullExpressionValue(topMessage, TopMessageEvent.EVENT_NAME);
        PrimaryButton.State state = null;
        paymentSheetActivity.updateErrorMessage(topMessage, paymentSheetViewState == null ? null : paymentSheetViewState.getErrorMessage());
        GooglePayButton googlePayButton = paymentSheetActivity.getGooglePayButton();
        if (paymentSheetViewState != null) {
            state = PaymentSheetViewModelKt.convert(paymentSheetViewState);
        }
        googlePayButton.updateState(state);
    }

    public void clearErrorMessages() {
        super.clearErrorMessages();
        TextView topMessage = getTopMessage();
        Intrinsics.checkNotNullExpressionValue(topMessage, TopMessageEvent.EVENT_NAME);
        BaseSheetActivity.updateErrorMessage$default(this, topMessage, (BaseSheetViewModel.UserErrorMessage) null, 2, (Object) null);
    }

    public void setActivityResult(PaymentSheetResult paymentSheetResult) {
        Intrinsics.checkNotNullParameter(paymentSheetResult, "result");
        setResult(-1, new Intent().putExtras(new PaymentSheetContract.Result(paymentSheetResult).toBundle()));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentSheetActivity$Companion;", "", "()V", "EXTRA_FRAGMENT_CONFIG", "", "EXTRA_STARTER_ARGS", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
