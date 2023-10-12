package com.stripe.android.paymentsheet.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Insets;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.WindowMetrics;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnit;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.stripe.android.paymentsheet.BottomSheetController;
import com.stripe.android.paymentsheet.R;
import com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel;
import com.stripe.android.ui.core.PaymentsThemeDefaults;
import com.stripe.android.ui.core.PaymentsThemeKt;
import com.stripe.android.view.KeyboardController;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b \u0018\u0000 O*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002OPB\u0005¢\u0006\u0002\u0010\u0003J\b\u00108\u001a\u000209H\u0016J\u0015\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010<J\b\u0010=\u001a\u000209H\u0016J\b\u0010>\u001a\u000209H\u0016J\u0012\u0010?\u001a\u0002092\b\u0010@\u001a\u0004\u0018\u00010AH\u0014J\b\u0010B\u001a\u000209H\u0014J\b\u0010C\u001a\u000209H\u0002J\u0015\u0010D\u001a\u0002092\u0006\u0010;\u001a\u00028\u0000H&¢\u0006\u0002\u0010<J\b\u0010E\u001a\u000209H\u0002J\b\u0010F\u001a\u000209H\u0002J\u001c\u0010G\u001a\u0002092\u0006\u0010$\u001a\u00020%2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010IH\u0004J\u0010\u0010J\u001a\u0002092\u0006\u0010K\u001a\u00020LH\u0002J\u0010\u0010M\u001a\u0002092\u0006\u0010N\u001a\u00020LH\u0002R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR/\u0010\f\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\t0\t0\r8@X\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u000f\u0010\u0003\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158DX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0019\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000bR\u0012\u0010\u001b\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010\u001f\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b#\u0010\u0013\u001a\u0004\b!\u0010\"R\u0012\u0010$\u001a\u00020%X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0012\u0010(\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u000bR\u0012\u0010*\u001a\u00020+X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0012\u0010.\u001a\u00020%X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010'R\u0012\u00100\u001a\u000201X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u0016\u00104\u001a\u0006\u0012\u0002\b\u000305X¦\u0004¢\u0006\u0006\u001a\u0004\b6\u00107¨\u0006Q"}, d2 = {"Lcom/stripe/android/paymentsheet/ui/BaseSheetActivity;", "ResultType", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "appbar", "Lcom/google/android/material/appbar/AppBarLayout;", "getAppbar", "()Lcom/google/android/material/appbar/AppBarLayout;", "bottomSheet", "Landroid/view/ViewGroup;", "getBottomSheet", "()Landroid/view/ViewGroup;", "bottomSheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "kotlin.jvm.PlatformType", "getBottomSheetBehavior$paymentsheet_release$annotations", "getBottomSheetBehavior$paymentsheet_release", "()Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "bottomSheetBehavior$delegate", "Lkotlin/Lazy;", "bottomSheetController", "Lcom/stripe/android/paymentsheet/BottomSheetController;", "getBottomSheetController", "()Lcom/stripe/android/paymentsheet/BottomSheetController;", "bottomSheetController$delegate", "fragmentContainerParent", "getFragmentContainerParent", "header", "Landroidx/compose/ui/platform/ComposeView;", "getHeader", "()Landroidx/compose/ui/platform/ComposeView;", "keyboardController", "Lcom/stripe/android/view/KeyboardController;", "getKeyboardController", "()Lcom/stripe/android/view/KeyboardController;", "keyboardController$delegate", "messageView", "Landroid/widget/TextView;", "getMessageView", "()Landroid/widget/TextView;", "rootView", "getRootView", "scrollView", "Landroid/widget/ScrollView;", "getScrollView", "()Landroid/widget/ScrollView;", "testModeIndicator", "getTestModeIndicator", "toolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "getToolbar", "()Lcom/google/android/material/appbar/MaterialToolbar;", "viewModel", "Lcom/stripe/android/paymentsheet/viewmodels/BaseSheetViewModel;", "getViewModel", "()Lcom/stripe/android/paymentsheet/viewmodels/BaseSheetViewModel;", "clearErrorMessages", "", "closeSheet", "result", "(Ljava/lang/Object;)V", "finish", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onUserBack", "setActivityResult", "setSheetWidthForTablets", "setupHeader", "updateErrorMessage", "userMessage", "Lcom/stripe/android/paymentsheet/viewmodels/BaseSheetViewModel$UserErrorMessage;", "updateRootViewClickHandling", "isProcessing", "", "updateToolbarButton", "isStackEmpty", "Companion", "ToolbarResources", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseSheetActivity.kt */
public abstract class BaseSheetActivity<ResultType> extends AppCompatActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_FRAGMENT_CONFIG = "com.stripe.android.paymentsheet.extra_fragment_config";
    public static final String EXTRA_STARTER_ARGS = "com.stripe.android.paymentsheet.extra_starter_args";
    public static final double TABLET_WIDTH_RATIO = 0.6d;
    private final Lazy bottomSheetBehavior$delegate = LazyKt.lazy(new BaseSheetActivity$bottomSheetBehavior$2(this));
    private final Lazy bottomSheetController$delegate = LazyKt.lazy(new BaseSheetActivity$bottomSheetController$2(this));
    private final Lazy keyboardController$delegate = LazyKt.lazy(new BaseSheetActivity$keyboardController$2(this));

    public static /* synthetic */ void getBottomSheetBehavior$paymentsheet_release$annotations() {
    }

    public abstract AppBarLayout getAppbar();

    public abstract ViewGroup getBottomSheet();

    public abstract ViewGroup getFragmentContainerParent();

    public abstract ComposeView getHeader();

    public abstract TextView getMessageView();

    public abstract ViewGroup getRootView();

    public abstract ScrollView getScrollView();

    public abstract TextView getTestModeIndicator();

    public abstract MaterialToolbar getToolbar();

    public abstract BaseSheetViewModel<?> getViewModel();

    public abstract void setActivityResult(ResultType resulttype);

    public final BottomSheetBehavior<ViewGroup> getBottomSheetBehavior$paymentsheet_release() {
        return (BottomSheetBehavior) this.bottomSheetBehavior$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public final BottomSheetController getBottomSheetController() {
        return (BottomSheetController) this.bottomSheetController$delegate.getValue();
    }

    private final KeyboardController getKeyboardController() {
        return (KeyboardController) this.keyboardController$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getViewModel().registerFromActivity(this);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            public final void onBackStackChanged() {
                BaseSheetActivity.m4434onCreate$lambda0(BaseSheetActivity.this);
            }
        });
        getScrollView().getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            public final void onScrollChanged() {
                BaseSheetActivity.m4435onCreate$lambda1(BaseSheetActivity.this);
            }
        });
        getBottomSheet().getLayoutTransition().enableTransitionType(4);
        getFragmentContainerParent().getLayoutTransition().enableTransitionType(4);
        getBottomSheetController().setup();
        LifecycleOwner lifecycleOwner = this;
        getBottomSheetController().getShouldFinish$paymentsheet_release().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                BaseSheetActivity.m4436onCreate$lambda2(BaseSheetActivity.this, (Boolean) obj);
            }
        });
        getViewModel().getProcessing().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                BaseSheetActivity.m4437onCreate$lambda3(BaseSheetActivity.this, (Boolean) obj);
            }
        });
        setSupportActionBar(getToolbar());
        ActionBar supportActionBar = getSupportActionBar();
        boolean z = false;
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
        getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BaseSheetActivity.m4438onCreate$lambda4(BaseSheetActivity.this, view);
            }
        });
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            z = true;
        }
        updateToolbarButton(z);
        setupHeader();
        getBottomSheet().setClickable(true);
        getViewModel().getLiveMode$paymentsheet_release().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                BaseSheetActivity.m4439onCreate$lambda5(BaseSheetActivity.this, (Boolean) obj);
            }
        });
        Context baseContext = getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
        boolean isSystemDarkTheme = PaymentsThemeKt.isSystemDarkTheme(baseContext);
        getBottomSheet().setBackgroundColor(ColorKt.m1651toArgb8_81llA(PaymentsThemeDefaults.INSTANCE.colors(isSystemDarkTheme).m4490getSurface0d7_KjU()));
        getToolbar().setBackgroundColor(ColorKt.m1651toArgb8_81llA(PaymentsThemeDefaults.INSTANCE.colors(isSystemDarkTheme).m4490getSurface0d7_KjU()));
        setSheetWidthForTablets();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m4434onCreate$lambda0(BaseSheetActivity baseSheetActivity) {
        Intrinsics.checkNotNullParameter(baseSheetActivity, "this$0");
        baseSheetActivity.updateToolbarButton(baseSheetActivity.getSupportFragmentManager().getBackStackEntryCount() == 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m4435onCreate$lambda1(BaseSheetActivity baseSheetActivity) {
        Intrinsics.checkNotNullParameter(baseSheetActivity, "this$0");
        baseSheetActivity.getAppbar().setElevation(baseSheetActivity.getScrollView().getScrollY() > 0 ? baseSheetActivity.getResources().getDimension(R.dimen.stripe_paymentsheet_toolbar_elevation) : 0.0f);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m4436onCreate$lambda2(BaseSheetActivity baseSheetActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(baseSheetActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "shouldFinish");
        if (bool.booleanValue()) {
            baseSheetActivity.finish();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-3  reason: not valid java name */
    public static final void m4437onCreate$lambda3(BaseSheetActivity baseSheetActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(baseSheetActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "isProcessing");
        baseSheetActivity.updateRootViewClickHandling(bool.booleanValue());
        baseSheetActivity.getToolbar().setEnabled(!bool.booleanValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-4  reason: not valid java name */
    public static final void m4438onCreate$lambda4(BaseSheetActivity baseSheetActivity, View view) {
        Intrinsics.checkNotNullParameter(baseSheetActivity, "this$0");
        if (!baseSheetActivity.getToolbar().isEnabled()) {
            return;
        }
        if (baseSheetActivity.getSupportFragmentManager().getBackStackEntryCount() == 0) {
            baseSheetActivity.getViewModel().onUserCancel();
        } else {
            baseSheetActivity.onUserBack();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-5  reason: not valid java name */
    public static final void m4439onCreate$lambda5(BaseSheetActivity baseSheetActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(baseSheetActivity, "this$0");
        TextView testModeIndicator = baseSheetActivity.getTestModeIndicator();
        Intrinsics.checkNotNullExpressionValue(bool, "isLiveMode");
        testModeIndicator.setVisibility(bool.booleanValue() ? 8 : 0);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            clearErrorMessages();
            super.onBackPressed();
            return;
        }
        getViewModel().onUserCancel();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        getViewModel().unregisterFromActivity();
    }

    /* access modifiers changed from: protected */
    public final void closeSheet(ResultType resulttype) {
        setActivityResult(resulttype);
        getBottomSheetController().hide();
    }

    public void clearErrorMessages() {
        updateErrorMessage$default(this, getMessageView(), (BaseSheetViewModel.UserErrorMessage) null, 2, (Object) null);
    }

    public static /* synthetic */ void updateErrorMessage$default(BaseSheetActivity baseSheetActivity, TextView textView, BaseSheetViewModel.UserErrorMessage userErrorMessage, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                userErrorMessage = null;
            }
            baseSheetActivity.updateErrorMessage(textView, userErrorMessage);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateErrorMessage");
    }

    /* access modifiers changed from: protected */
    public final void updateErrorMessage(TextView textView, BaseSheetViewModel.UserErrorMessage userErrorMessage) {
        Intrinsics.checkNotNullParameter(textView, "messageView");
        String message = userErrorMessage == null ? null : userErrorMessage.getMessage();
        float r3 = Dp.m3859constructorimpl(PaymentsThemeDefaults.INSTANCE.getTypography().getFontSizeMultiplier() * TextUnit.m4040getValueimpl(PaymentsThemeDefaults.INSTANCE.getTypography().m4527getSmallFontSizeXSAIIZE()));
        PaymentsThemeDefaults paymentsThemeDefaults = PaymentsThemeDefaults.INSTANCE;
        Context baseContext = getBaseContext();
        Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
        textView.setText(PaymentsThemeKt.m4515createTextSpanFromTextStyleqhTmNto(message, this, r3, paymentsThemeDefaults.colors(PaymentsThemeKt.isSystemDarkTheme(baseContext)).m4484getError0d7_KjU(), PaymentsThemeDefaults.INSTANCE.getTypography().getFontFamily()));
        View view = textView;
        int i = 0;
        if (!(userErrorMessage != null)) {
            i = 8;
        }
        view.setVisibility(i);
    }

    private final void setupHeader() {
        ComposeView header = getHeader();
        header.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        header.setContent(ComposableLambdaKt.composableLambdaInstance(-985535984, true, new BaseSheetActivity$setupHeader$1$1(this)));
    }

    private final void updateToolbarButton(boolean z) {
        ToolbarResources toolbarResources;
        if (z) {
            toolbarResources = new ToolbarResources(R.drawable.stripe_paymentsheet_toolbar_close, R.string.stripe_paymentsheet_close);
        } else {
            toolbarResources = new ToolbarResources(R.drawable.stripe_paymentsheet_toolbar_back, R.string.stripe_paymentsheet_back);
        }
        Drawable drawable = AppCompatResources.getDrawable(this, toolbarResources.getIcon());
        if (drawable != null) {
            PaymentsThemeDefaults paymentsThemeDefaults = PaymentsThemeDefaults.INSTANCE;
            Context baseContext = getBaseContext();
            Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
            drawable.setTintList(ColorStateList.valueOf(ColorKt.m1651toArgb8_81llA(paymentsThemeDefaults.colors(PaymentsThemeKt.isSystemDarkTheme(baseContext)).m4480getAppBarIcon0d7_KjU())));
        }
        getToolbar().setNavigationIcon(drawable);
        getToolbar().setNavigationContentDescription((CharSequence) getResources().getString(toolbarResources.getDescription()));
    }

    private final void updateRootViewClickHandling(boolean z) {
        if (!z) {
            getRootView().setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    BaseSheetActivity.m4440updateRootViewClickHandling$lambda8(BaseSheetActivity.this, view);
                }
            });
            return;
        }
        getRootView().setOnClickListener((View.OnClickListener) null);
        getRootView().setClickable(false);
    }

    /* access modifiers changed from: private */
    /* renamed from: updateRootViewClickHandling$lambda-8  reason: not valid java name */
    public static final void m4440updateRootViewClickHandling$lambda8(BaseSheetActivity baseSheetActivity, View view) {
        Intrinsics.checkNotNullParameter(baseSheetActivity, "this$0");
        baseSheetActivity.getViewModel().onUserCancel();
    }

    private final void onUserBack() {
        getKeyboardController().hide();
        onBackPressed();
    }

    private final void setSheetWidthForTablets() {
        int i;
        if (getResources().getBoolean(R.bool.isTablet)) {
            if (Build.VERSION.SDK_INT >= 30) {
                WindowMetrics currentWindowMetrics = getWindowManager().getCurrentWindowMetrics();
                Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "windowManager.currentWindowMetrics");
                Insets insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
                Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility, "windowMetrics.windowInse…Insets.Type.systemBars())");
                i = (currentWindowMetrics.getBounds().width() - insetsIgnoringVisibility.left) - insetsIgnoringVisibility.right;
            } else {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                i = displayMetrics.widthPixels;
            }
            ViewGroup.LayoutParams layoutParams = getBottomSheet().getLayoutParams();
            Intrinsics.checkNotNullExpressionValue(layoutParams, "bottomSheet.layoutParams");
            layoutParams.width = MathKt.roundToInt(((double) i) * 0.6d);
            getBottomSheet().setLayoutParams(layoutParams);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/stripe/android/paymentsheet/ui/BaseSheetActivity$Companion;", "", "()V", "EXTRA_FRAGMENT_CONFIG", "", "EXTRA_STARTER_ARGS", "TABLET_WIDTH_RATIO", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BaseSheetActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/paymentsheet/ui/BaseSheetActivity$ToolbarResources;", "", "icon", "", "description", "(II)V", "getDescription", "()I", "getIcon", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BaseSheetActivity.kt */
    public static final class ToolbarResources {
        private final int description;
        private final int icon;

        public static /* synthetic */ ToolbarResources copy$default(ToolbarResources toolbarResources, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = toolbarResources.icon;
            }
            if ((i3 & 2) != 0) {
                i2 = toolbarResources.description;
            }
            return toolbarResources.copy(i, i2);
        }

        public final int component1() {
            return this.icon;
        }

        public final int component2() {
            return this.description;
        }

        public final ToolbarResources copy(int i, int i2) {
            return new ToolbarResources(i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ToolbarResources)) {
                return false;
            }
            ToolbarResources toolbarResources = (ToolbarResources) obj;
            return this.icon == toolbarResources.icon && this.description == toolbarResources.description;
        }

        public int hashCode() {
            return (this.icon * 31) + this.description;
        }

        public String toString() {
            return "ToolbarResources(icon=" + this.icon + ", description=" + this.description + ')';
        }

        public ToolbarResources(int i, int i2) {
            this.icon = i;
            this.description = i2;
        }

        public final int getIcon() {
            return this.icon;
        }

        public final int getDescription() {
            return this.description;
        }
    }
}
