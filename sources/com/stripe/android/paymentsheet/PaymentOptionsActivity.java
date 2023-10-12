package com.stripe.android.paymentsheet;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.compose.ui.platform.ComposeView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.savedstate.SavedStateRegistryOwner;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.stripe.android.paymentsheet.PaymentOptionContract;
import com.stripe.android.paymentsheet.PaymentOptionsViewModel;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.databinding.ActivityPaymentOptionsBinding;
import com.stripe.android.paymentsheet.model.FragmentConfig;
import com.stripe.android.paymentsheet.ui.AnimationConstants;
import com.stripe.android.paymentsheet.ui.BaseSheetActivity;
import com.stripe.android.paymentsheet.ui.PrimaryButton;
import com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel;
import com.stripe.android.ui.core.PaymentsTheme;
import com.stripe.android.ui.core.PaymentsThemeKt;
import com.stripe.android.ui.core.PrimaryButtonModifier;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 T2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001TB\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010JH\u0014J\u0018\u0010K\u001a\u00020H2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020JH\u0002J\u0010\u0010O\u001a\u00020H2\u0006\u0010P\u001a\u00020\u0002H\u0016J\u0010\u0010Q\u001a\u00020H2\u0006\u0010R\u001a\u00020SH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058VX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8VX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00108CX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u000b8VX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0014\u0010\rR\u001b\u0010\u0016\u001a\u00020\u00178VX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8VX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\t\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020\u000b8VX\u0002¢\u0006\f\n\u0004\b\"\u0010\t\u001a\u0004\b!\u0010\rR\u001b\u0010#\u001a\u00020$8VX\u0002¢\u0006\f\n\u0004\b'\u0010\t\u001a\u0004\b%\u0010&R\u001d\u0010(\u001a\u0004\u0018\u00010)8BX\u0002¢\u0006\f\n\u0004\b,\u0010\t\u001a\u0004\b*\u0010+R\u001b\u0010-\u001a\u00020\u001c8VX\u0002¢\u0006\f\n\u0004\b/\u0010\t\u001a\u0004\b.\u0010\u001eR\u001b\u00100\u001a\u0002018VX\u0002¢\u0006\f\n\u0004\b4\u0010\t\u001a\u0004\b2\u00103R!\u00105\u001a\u0002068@X\u0002¢\u0006\u0012\n\u0004\b:\u0010\t\u0012\u0004\b7\u0010\u0003\u001a\u0004\b8\u00109R\u001b\u0010;\u001a\u00020<8VX\u0002¢\u0006\f\n\u0004\b?\u0010\t\u001a\u0004\b=\u0010>R$\u0010@\u001a\u00020A8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bB\u0010\u0003\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006U"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsActivity;", "Lcom/stripe/android/paymentsheet/ui/BaseSheetActivity;", "Lcom/stripe/android/paymentsheet/PaymentOptionResult;", "()V", "appbar", "Lcom/google/android/material/appbar/AppBarLayout;", "getAppbar", "()Lcom/google/android/material/appbar/AppBarLayout;", "appbar$delegate", "Lkotlin/Lazy;", "bottomSheet", "Landroid/view/ViewGroup;", "getBottomSheet", "()Landroid/view/ViewGroup;", "bottomSheet$delegate", "fragmentContainerId", "", "getFragmentContainerId", "()I", "fragmentContainerParent", "getFragmentContainerParent", "fragmentContainerParent$delegate", "header", "Landroidx/compose/ui/platform/ComposeView;", "getHeader", "()Landroidx/compose/ui/platform/ComposeView;", "header$delegate", "messageView", "Landroid/widget/TextView;", "getMessageView", "()Landroid/widget/TextView;", "messageView$delegate", "rootView", "getRootView", "rootView$delegate", "scrollView", "Landroid/widget/ScrollView;", "getScrollView", "()Landroid/widget/ScrollView;", "scrollView$delegate", "starterArgs", "Lcom/stripe/android/paymentsheet/PaymentOptionContract$Args;", "getStarterArgs", "()Lcom/stripe/android/paymentsheet/PaymentOptionContract$Args;", "starterArgs$delegate", "testModeIndicator", "getTestModeIndicator", "testModeIndicator$delegate", "toolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "getToolbar", "()Lcom/google/android/material/appbar/MaterialToolbar;", "toolbar$delegate", "viewBinding", "Lcom/stripe/android/paymentsheet/databinding/ActivityPaymentOptionsBinding;", "getViewBinding$paymentsheet_release$annotations", "getViewBinding$paymentsheet_release", "()Lcom/stripe/android/paymentsheet/databinding/ActivityPaymentOptionsBinding;", "viewBinding$delegate", "viewModel", "Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel;", "getViewModel", "()Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel;", "viewModel$delegate", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory$paymentsheet_release$annotations", "getViewModelFactory$paymentsheet_release", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory$paymentsheet_release", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onTransitionTarget", "transitionTarget", "Lcom/stripe/android/paymentsheet/PaymentOptionsViewModel$TransitionTarget;", "fragmentArgs", "setActivityResult", "result", "setupContinueButton", "addButton", "Lcom/stripe/android/paymentsheet/ui/PrimaryButton;", "Companion", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionsActivity.kt */
public final class PaymentOptionsActivity extends BaseSheetActivity<PaymentOptionResult> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_FRAGMENT_CONFIG = "com.stripe.android.paymentsheet.extra_fragment_config";
    public static final String EXTRA_STARTER_ARGS = "com.stripe.android.paymentsheet.extra_starter_args";
    private final Lazy appbar$delegate;
    private final Lazy bottomSheet$delegate;
    private final Lazy fragmentContainerParent$delegate;
    private final Lazy header$delegate;
    private final Lazy messageView$delegate;
    private final Lazy rootView$delegate;
    private final Lazy scrollView$delegate;
    private final Lazy starterArgs$delegate;
    private final Lazy testModeIndicator$delegate;
    private final Lazy toolbar$delegate;
    private final Lazy viewBinding$delegate = LazyKt.lazy(new PaymentOptionsActivity$viewBinding$2(this));
    private final Lazy viewModel$delegate;
    private ViewModelProvider.Factory viewModelFactory;

    public static /* synthetic */ void getViewBinding$paymentsheet_release$annotations() {
    }

    public static /* synthetic */ void getViewModelFactory$paymentsheet_release$annotations() {
    }

    public PaymentOptionsActivity() {
        Function0 paymentOptionsActivity$viewModelFactory$1 = new PaymentOptionsActivity$viewModelFactory$1(this);
        Function0 paymentOptionsActivity$viewModelFactory$2 = new PaymentOptionsActivity$viewModelFactory$2(this);
        SavedStateRegistryOwner savedStateRegistryOwner = this;
        Intent intent = getIntent();
        this.viewModelFactory = new PaymentOptionsViewModel.Factory(paymentOptionsActivity$viewModelFactory$1, paymentOptionsActivity$viewModelFactory$2, savedStateRegistryOwner, intent == null ? null : intent.getExtras());
        ComponentActivity componentActivity = this;
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(PaymentOptionsViewModel.class), new PaymentOptionsActivity$special$$inlined$viewModels$default$2(componentActivity), new PaymentOptionsActivity$viewModel$2(this), new PaymentOptionsActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
        this.starterArgs$delegate = LazyKt.lazy(new PaymentOptionsActivity$starterArgs$2(this));
        this.rootView$delegate = LazyKt.lazy(new PaymentOptionsActivity$rootView$2(this));
        this.bottomSheet$delegate = LazyKt.lazy(new PaymentOptionsActivity$bottomSheet$2(this));
        this.appbar$delegate = LazyKt.lazy(new PaymentOptionsActivity$appbar$2(this));
        this.toolbar$delegate = LazyKt.lazy(new PaymentOptionsActivity$toolbar$2(this));
        this.testModeIndicator$delegate = LazyKt.lazy(new PaymentOptionsActivity$testModeIndicator$2(this));
        this.scrollView$delegate = LazyKt.lazy(new PaymentOptionsActivity$scrollView$2(this));
        this.header$delegate = LazyKt.lazy(new PaymentOptionsActivity$header$2(this));
        this.fragmentContainerParent$delegate = LazyKt.lazy(new PaymentOptionsActivity$fragmentContainerParent$2(this));
        this.messageView$delegate = LazyKt.lazy(new PaymentOptionsActivity$messageView$2(this));
    }

    public final ActivityPaymentOptionsBinding getViewBinding$paymentsheet_release() {
        return (ActivityPaymentOptionsBinding) this.viewBinding$delegate.getValue();
    }

    public final ViewModelProvider.Factory getViewModelFactory$paymentsheet_release() {
        return this.viewModelFactory;
    }

    public final void setViewModelFactory$paymentsheet_release(ViewModelProvider.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.viewModelFactory = factory;
    }

    public PaymentOptionsViewModel getViewModel() {
        return (PaymentOptionsViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final PaymentOptionContract.Args getStarterArgs() {
        return (PaymentOptionContract.Args) this.starterArgs$delegate.getValue();
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

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PaymentOptionContract.Args starterArgs = getStarterArgs();
        if (starterArgs == null) {
            finish();
            return;
        }
        Integer statusBarColor = starterArgs.getStatusBarColor();
        if (statusBarColor != null) {
            getWindow().setStatusBarColor(statusBarColor.intValue());
        }
        setContentView((View) getViewBinding$paymentsheet_release().getRoot());
        LifecycleOwner lifecycleOwner = this;
        getViewModel().getPaymentOptionResult$paymentsheet_release().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PaymentOptionsActivity.m4398onCreate$lambda1(PaymentOptionsActivity.this, (PaymentOptionResult) obj);
            }
        });
        PrimaryButton primaryButton = getViewBinding$paymentsheet_release().continueButton;
        Intrinsics.checkNotNullExpressionValue(primaryButton, "viewBinding.continueButton");
        setupContinueButton(primaryButton);
        getViewModel().getTransition$paymentsheet_release().observe(lifecycleOwner, new Observer(starterArgs) {
            public final /* synthetic */ PaymentOptionContract.Args f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                PaymentOptionsActivity.m4399onCreate$lambda3(PaymentOptionsActivity.this, this.f$1, (BaseSheetViewModel.Event) obj);
            }
        });
        getViewModel().getFragmentConfigEvent().observe(lifecycleOwner, new Observer(starterArgs) {
            public final /* synthetic */ PaymentOptionContract.Args f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                PaymentOptionsActivity.m4400onCreate$lambda4(PaymentOptionsActivity.this, this.f$1, (BaseSheetViewModel.Event) obj);
            }
        });
        getSupportFragmentManager().registerFragmentLifecycleCallbacks(new PaymentOptionsActivity$onCreate$5(this), false);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m4398onCreate$lambda1(PaymentOptionsActivity paymentOptionsActivity, PaymentOptionResult paymentOptionResult) {
        Intrinsics.checkNotNullParameter(paymentOptionsActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(paymentOptionResult, "it");
        paymentOptionsActivity.closeSheet(paymentOptionResult);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-3  reason: not valid java name */
    public static final void m4399onCreate$lambda3(PaymentOptionsActivity paymentOptionsActivity, PaymentOptionContract.Args args, BaseSheetViewModel.Event event) {
        PaymentOptionsViewModel.TransitionTarget transitionTarget;
        Intrinsics.checkNotNullParameter(paymentOptionsActivity, "this$0");
        if (event != null && (transitionTarget = (PaymentOptionsViewModel.TransitionTarget) event.getContentIfNotHandled()) != null) {
            paymentOptionsActivity.onTransitionTarget(transitionTarget, BundleKt.bundleOf(TuplesKt.to("com.stripe.android.paymentsheet.extra_starter_args", args), TuplesKt.to("com.stripe.android.paymentsheet.extra_fragment_config", transitionTarget.getFragmentConfig())));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-4  reason: not valid java name */
    public static final void m4400onCreate$lambda4(PaymentOptionsActivity paymentOptionsActivity, PaymentOptionContract.Args args, BaseSheetViewModel.Event event) {
        PaymentOptionsViewModel.TransitionTarget transitionTarget;
        Intrinsics.checkNotNullParameter(paymentOptionsActivity, "this$0");
        FragmentConfig fragmentConfig = (FragmentConfig) event.getContentIfNotHandled();
        if (fragmentConfig != null) {
            PaymentOptionsViewModel viewModel = paymentOptionsActivity.getViewModel();
            if (!args.getPaymentMethods().isEmpty() || fragmentConfig.isGooglePayReady()) {
                transitionTarget = new PaymentOptionsViewModel.TransitionTarget.SelectSavedPaymentMethod(fragmentConfig);
            } else {
                transitionTarget = new PaymentOptionsViewModel.TransitionTarget.AddPaymentMethodSheet(fragmentConfig);
            }
            viewModel.transitionTo(transitionTarget);
        }
    }

    private final void setupContinueButton(PrimaryButton primaryButton) {
        getViewBinding$paymentsheet_release().continueButton.setLockVisible$paymentsheet_release(false);
        getViewBinding$paymentsheet_release().continueButton.updateState(PrimaryButton.State.Ready.INSTANCE);
        PaymentSheet.Configuration config$paymentsheet_release = getViewModel().getConfig$paymentsheet_release();
        if (config$paymentsheet_release != null) {
            ColorStateList primaryButtonColor = config$paymentsheet_release.getPrimaryButtonColor();
            if (primaryButtonColor == null) {
                PrimaryButtonModifier primaryButtonModifierMutable = PaymentsTheme.INSTANCE.getPrimaryButtonModifierMutable();
                Context baseContext = getBaseContext();
                Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
                primaryButtonColor = ColorStateList.valueOf(PaymentsThemeKt.getPrimaryColor(primaryButtonModifierMutable, baseContext));
                Intrinsics.checkNotNullExpressionValue(primaryButtonColor, "valueOf(\n               …aseContext)\n            )");
            }
            getViewBinding$paymentsheet_release().continueButton.setAppearanceConfiguration(PaymentsTheme.INSTANCE.getPrimaryButtonModifierMutable(), primaryButtonColor);
        }
        primaryButton.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PaymentOptionsActivity.m4401setupContinueButton$lambda6(PaymentOptionsActivity.this, view);
            }
        });
        getViewModel().getCtaEnabled().observe(this, new Observer() {
            public final void onChanged(Object obj) {
                PaymentOptionsActivity.m4402setupContinueButton$lambda7(PrimaryButton.this, (Boolean) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: setupContinueButton$lambda-6  reason: not valid java name */
    public static final void m4401setupContinueButton$lambda6(PaymentOptionsActivity paymentOptionsActivity, View view) {
        Intrinsics.checkNotNullParameter(paymentOptionsActivity, "this$0");
        paymentOptionsActivity.getViewModel().onUserSelection();
    }

    /* access modifiers changed from: private */
    /* renamed from: setupContinueButton$lambda-7  reason: not valid java name */
    public static final void m4402setupContinueButton$lambda7(PrimaryButton primaryButton, Boolean bool) {
        Intrinsics.checkNotNullParameter(primaryButton, "$addButton");
        Intrinsics.checkNotNullExpressionValue(bool, "isEnabled");
        primaryButton.setEnabled(bool.booleanValue());
    }

    private final void onTransitionTarget(PaymentOptionsViewModel.TransitionTarget transitionTarget, Bundle bundle) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        if (transitionTarget instanceof PaymentOptionsViewModel.TransitionTarget.AddPaymentMethodFull) {
            beginTransaction.setCustomAnimations(AnimationConstants.INSTANCE.getFADE_IN(), AnimationConstants.INSTANCE.getFADE_OUT(), AnimationConstants.INSTANCE.getFADE_IN(), AnimationConstants.INSTANCE.getFADE_OUT());
            beginTransaction.addToBackStack((String) null);
            beginTransaction.replace(getFragmentContainerId(), (Class<? extends Fragment>) PaymentOptionsAddPaymentMethodFragment.class, bundle);
        } else if (transitionTarget instanceof PaymentOptionsViewModel.TransitionTarget.SelectSavedPaymentMethod) {
            beginTransaction.replace(getFragmentContainerId(), (Class<? extends Fragment>) PaymentOptionsListFragment.class, bundle);
        } else if (transitionTarget instanceof PaymentOptionsViewModel.TransitionTarget.AddPaymentMethodSheet) {
            beginTransaction.replace(getFragmentContainerId(), (Class<? extends Fragment>) PaymentOptionsAddPaymentMethodFragment.class, bundle);
        }
        beginTransaction.commit();
        getSupportFragmentManager().executePendingTransactions();
        getRootView().addOnLayoutChangeListener(new PaymentOptionsActivity$onTransitionTarget$$inlined$doOnNextLayout$1(this));
    }

    public void setActivityResult(PaymentOptionResult paymentOptionResult) {
        Intrinsics.checkNotNullParameter(paymentOptionResult, "result");
        setResult(paymentOptionResult.getResultCode(), new Intent().putExtras(paymentOptionResult.toBundle()));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/paymentsheet/PaymentOptionsActivity$Companion;", "", "()V", "EXTRA_FRAGMENT_CONFIG", "", "EXTRA_STARTER_ARGS", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentOptionsActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
