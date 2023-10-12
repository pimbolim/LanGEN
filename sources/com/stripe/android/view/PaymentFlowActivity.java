package com.stripe.android.view;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import com.stripe.android.CustomerSession;
import com.stripe.android.PaymentSession;
import com.stripe.android.PaymentSessionConfig;
import com.stripe.android.PaymentSessionData;
import com.stripe.android.R;
import com.stripe.android.databinding.PaymentFlowActivityBinding;
import com.stripe.android.model.Customer;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.ShippingInformation;
import com.stripe.android.model.ShippingMethod;
import com.stripe.android.view.PaymentFlowActivityStarter;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 N2\u00020\u0001:\u0001NB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u000205H\u0002J\b\u00106\u001a\u000205H\u0002J\b\u00107\u001a\u000201H\u0016J\b\u00108\u001a\u000201H\u0016J\u0012\u00109\u001a\u0002012\b\u0010:\u001a\u0004\u0018\u00010;H\u0014J\u0010\u0010<\u001a\u0002012\u0006\u0010=\u001a\u00020>H\u0002J'\u0010?\u001a\u0002012\b\u0010@\u001a\u0004\u0018\u00010\u001e2\u000e\b\u0002\u0010A\u001a\b\u0012\u0004\u0012\u00020C0BH\u0000¢\u0006\u0002\bDJ\b\u0010E\u001a\u000201H\u0002J\u0016\u0010F\u001a\u0002012\f\u0010A\u001a\b\u0012\u0004\u0012\u00020C0BH\u0002J\b\u0010G\u001a\u000201H\u0002J\u0016\u0010H\u001a\u0002012\f\u0010A\u001a\b\u0012\u0004\u0012\u00020C0BH\u0002J\"\u0010I\u001a\u0002012\u0006\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010@\u001a\u00020\u001eH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\b\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8BX\u0002¢\u0006\f\n\u0004\b*\u0010\b\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8BX\u0002¢\u0006\f\n\u0004\b/\u0010\b\u001a\u0004\b-\u0010.¨\u0006O"}, d2 = {"Lcom/stripe/android/view/PaymentFlowActivity;", "Lcom/stripe/android/view/StripeActivity;", "()V", "args", "Lcom/stripe/android/view/PaymentFlowActivityStarter$Args;", "getArgs", "()Lcom/stripe/android/view/PaymentFlowActivityStarter$Args;", "args$delegate", "Lkotlin/Lazy;", "customerSession", "Lcom/stripe/android/CustomerSession;", "getCustomerSession", "()Lcom/stripe/android/CustomerSession;", "customerSession$delegate", "keyboardController", "Lcom/stripe/android/view/KeyboardController;", "getKeyboardController", "()Lcom/stripe/android/view/KeyboardController;", "keyboardController$delegate", "paymentFlowPagerAdapter", "Lcom/stripe/android/view/PaymentFlowPagerAdapter;", "getPaymentFlowPagerAdapter", "()Lcom/stripe/android/view/PaymentFlowPagerAdapter;", "paymentFlowPagerAdapter$delegate", "paymentSessionConfig", "Lcom/stripe/android/PaymentSessionConfig;", "getPaymentSessionConfig", "()Lcom/stripe/android/PaymentSessionConfig;", "paymentSessionConfig$delegate", "shippingInfo", "Lcom/stripe/android/model/ShippingInformation;", "getShippingInfo", "()Lcom/stripe/android/model/ShippingInformation;", "viewBinding", "Lcom/stripe/android/databinding/PaymentFlowActivityBinding;", "getViewBinding", "()Lcom/stripe/android/databinding/PaymentFlowActivityBinding;", "viewBinding$delegate", "viewModel", "Lcom/stripe/android/view/PaymentFlowViewModel;", "getViewModel", "()Lcom/stripe/android/view/PaymentFlowViewModel;", "viewModel$delegate", "viewPager", "Lcom/stripe/android/view/PaymentFlowViewPager;", "getViewPager", "()Lcom/stripe/android/view/PaymentFlowViewPager;", "viewPager$delegate", "finishWithData", "", "paymentSessionData", "Lcom/stripe/android/PaymentSessionData;", "hasNextPage", "", "hasPreviousPage", "onActionSave", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onShippingInfoError", "error", "", "onShippingInfoSaved", "shippingInformation", "shippingMethods", "", "Lcom/stripe/android/model/ShippingMethod;", "onShippingInfoSaved$payments_core_release", "onShippingInfoSubmitted", "onShippingInfoValidated", "onShippingMethodSave", "onShippingMethodsReady", "validateShippingInformation", "shippingInfoValidator", "Lcom/stripe/android/PaymentSessionConfig$ShippingInformationValidator;", "shippingMethodsFactory", "Lcom/stripe/android/PaymentSessionConfig$ShippingMethodsFactory;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentFlowActivity.kt */
public final class PaymentFlowActivity extends StripeActivity {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PRODUCT_TOKEN = "PaymentFlowActivity";
    private final Lazy args$delegate = LazyKt.lazy(new PaymentFlowActivity$args$2(this));
    private final Lazy customerSession$delegate = LazyKt.lazy(PaymentFlowActivity$customerSession$2.INSTANCE);
    private final Lazy keyboardController$delegate = LazyKt.lazy(new PaymentFlowActivity$keyboardController$2(this));
    private final Lazy paymentFlowPagerAdapter$delegate = LazyKt.lazy(new PaymentFlowActivity$paymentFlowPagerAdapter$2(this));
    private final Lazy paymentSessionConfig$delegate = LazyKt.lazy(new PaymentFlowActivity$paymentSessionConfig$2(this));
    private final Lazy viewBinding$delegate = LazyKt.lazy(new PaymentFlowActivity$viewBinding$2(this));
    private final Lazy viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(PaymentFlowViewModel.class), new PaymentFlowActivity$special$$inlined$viewModels$2(this), new PaymentFlowActivity$viewModel$2(this));
    private final Lazy viewPager$delegate = LazyKt.lazy(new PaymentFlowActivity$viewPager$2(this));

    /* access modifiers changed from: private */
    public final PaymentFlowActivityBinding getViewBinding() {
        return (PaymentFlowActivityBinding) this.viewBinding$delegate.getValue();
    }

    private final PaymentFlowViewPager getViewPager() {
        return (PaymentFlowViewPager) this.viewPager$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final CustomerSession getCustomerSession() {
        return (CustomerSession) this.customerSession$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final PaymentFlowActivityStarter.Args getArgs() {
        return (PaymentFlowActivityStarter.Args) this.args$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final PaymentSessionConfig getPaymentSessionConfig() {
        return (PaymentSessionConfig) this.paymentSessionConfig$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final PaymentFlowViewModel getViewModel() {
        return (PaymentFlowViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final PaymentFlowPagerAdapter getPaymentFlowPagerAdapter() {
        return (PaymentFlowPagerAdapter) this.paymentFlowPagerAdapter$delegate.getValue();
    }

    private final KeyboardController getKeyboardController() {
        return (KeyboardController) this.keyboardController$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PaymentFlowActivityStarter.Args.Companion companion = PaymentFlowActivityStarter.Args.Companion;
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        Integer windowFlags$payments_core_release = companion.create(intent).getWindowFlags$payments_core_release();
        if (windowFlags$payments_core_release != null) {
            getWindow().addFlags(windowFlags$payments_core_release.intValue());
        }
        ShippingInformation submittedShippingInfo$payments_core_release = getViewModel().getSubmittedShippingInfo$payments_core_release();
        if (submittedShippingInfo$payments_core_release == null) {
            submittedShippingInfo$payments_core_release = getPaymentSessionConfig().getPrepopulatedShippingInfo();
        }
        getPaymentFlowPagerAdapter().setShippingMethods$payments_core_release(getViewModel().getShippingMethods$payments_core_release());
        getPaymentFlowPagerAdapter().setShippingInfoSubmitted$payments_core_release(getViewModel().isShippingInfoSubmitted$payments_core_release());
        getPaymentFlowPagerAdapter().setShippingInformation$payments_core_release(submittedShippingInfo$payments_core_release);
        getPaymentFlowPagerAdapter().setSelectedShippingMethod$payments_core_release(getViewModel().getSelectedShippingMethod$payments_core_release());
        getViewPager().setAdapter(getPaymentFlowPagerAdapter());
        getViewPager().addOnPageChangeListener(new PaymentFlowActivity$onCreate$2(this));
        getViewPager().setCurrentItem(getViewModel().getCurrentPage$payments_core_release());
        setTitle(getPaymentFlowPagerAdapter().getPageTitle(getViewPager().getCurrentItem()));
    }

    public void onActionSave() {
        if (PaymentFlowPage.ShippingInfo == getPaymentFlowPagerAdapter().getPageAt$payments_core_release(getViewPager().getCurrentItem())) {
            onShippingInfoSubmitted();
        } else {
            onShippingMethodSave();
        }
    }

    public static /* synthetic */ void onShippingInfoSaved$payments_core_release$default(PaymentFlowActivity paymentFlowActivity, ShippingInformation shippingInformation, List list, int i, Object obj) {
        if ((i & 2) != 0) {
            list = CollectionsKt.emptyList();
        }
        paymentFlowActivity.onShippingInfoSaved$payments_core_release(shippingInformation, list);
    }

    public final /* synthetic */ void onShippingInfoSaved$payments_core_release(ShippingInformation shippingInformation, List list) {
        List list2 = list;
        Intrinsics.checkNotNullParameter(list2, "shippingMethods");
        onShippingMethodsReady(list2);
        getViewModel().setPaymentSessionData$payments_core_release(PaymentSessionData.copy$default(getViewModel().getPaymentSessionData$payments_core_release(), false, false, 0, 0, shippingInformation, (ShippingMethod) null, (PaymentMethod) null, false, 239, (Object) null));
    }

    private final void onShippingInfoValidated(List<ShippingMethod> list) {
        ShippingInformation shippingInformation = getViewModel().getPaymentSessionData$payments_core_release().getShippingInformation();
        if (shippingInformation != null) {
            getViewModel().saveCustomerShippingInformation$payments_core_release(shippingInformation).observe(this, new Observer(list) {
                public final /* synthetic */ List f$1;

                {
                    this.f$1 = r2;
                }

                public final void onChanged(Object obj) {
                    PaymentFlowActivity.m4669onShippingInfoValidated$lambda4$lambda3(PaymentFlowActivity.this, this.f$1, (Result) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onShippingInfoValidated$lambda-4$lambda-3  reason: not valid java name */
    public static final void m4669onShippingInfoValidated$lambda4$lambda3(PaymentFlowActivity paymentFlowActivity, List list, Result result) {
        Intrinsics.checkNotNullParameter(paymentFlowActivity, "this$0");
        Intrinsics.checkNotNullParameter(list, "$shippingMethods");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        Object r3 = result.m4718unboximpl();
        Throwable r0 = Result.m4712exceptionOrNullimpl(r3);
        if (r0 == null) {
            paymentFlowActivity.onShippingInfoSaved$payments_core_release(((Customer) r3).getShippingInformation(), list);
            return;
        }
        String message = r0.getMessage();
        if (message == null) {
            message = "";
        }
        paymentFlowActivity.showError(message);
    }

    private final void onShippingMethodsReady(List<ShippingMethod> list) {
        setProgressBarVisible(false);
        getPaymentFlowPagerAdapter().setShippingMethods$payments_core_release(list);
        getPaymentFlowPagerAdapter().setShippingInfoSubmitted$payments_core_release(true);
        if (hasNextPage()) {
            PaymentFlowViewModel viewModel = getViewModel();
            viewModel.setCurrentPage$payments_core_release(viewModel.getCurrentPage$payments_core_release() + 1);
            getViewPager().setCurrentItem(getViewModel().getCurrentPage$payments_core_release());
            return;
        }
        finishWithData(getViewModel().getPaymentSessionData$payments_core_release());
    }

    private final void onShippingInfoSubmitted() {
        getKeyboardController().hide();
        ShippingInformation shippingInfo = getShippingInfo();
        if (shippingInfo != null) {
            getViewModel().setPaymentSessionData$payments_core_release(PaymentSessionData.copy$default(getViewModel().getPaymentSessionData$payments_core_release(), false, false, 0, 0, shippingInfo, (ShippingMethod) null, (PaymentMethod) null, false, 239, (Object) null));
            setProgressBarVisible(true);
            validateShippingInformation(getPaymentSessionConfig().getShippingInformationValidator$payments_core_release(), getPaymentSessionConfig().getShippingMethodsFactory$payments_core_release(), shippingInfo);
        }
    }

    private final ShippingInformation getShippingInfo() {
        return ((ShippingInfoWidget) getViewPager().findViewById(R.id.shipping_info_widget)).getShippingInformation();
    }

    private final boolean hasNextPage() {
        return getViewPager().getCurrentItem() + 1 < getPaymentFlowPagerAdapter().getCount();
    }

    private final boolean hasPreviousPage() {
        return getViewPager().getCurrentItem() != 0;
    }

    private final void onShippingMethodSave() {
        finishWithData(PaymentSessionData.copy$default(getViewModel().getPaymentSessionData$payments_core_release(), false, false, 0, 0, (ShippingInformation) null, ((SelectShippingMethodWidget) getViewPager().findViewById(R.id.select_shipping_method_widget)).getSelectedShippingMethod(), (PaymentMethod) null, false, 223, (Object) null));
    }

    private final void validateShippingInformation(PaymentSessionConfig.ShippingInformationValidator shippingInformationValidator, PaymentSessionConfig.ShippingMethodsFactory shippingMethodsFactory, ShippingInformation shippingInformation) {
        getViewModel().validateShippingInformation$payments_core_release(shippingInformationValidator, shippingMethodsFactory, shippingInformation).observe(this, new Observer() {
            public final void onChanged(Object obj) {
                PaymentFlowActivity.m4670validateShippingInformation$lambda7(PaymentFlowActivity.this, (Result) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: validateShippingInformation$lambda-7  reason: not valid java name */
    public static final void m4670validateShippingInformation$lambda7(PaymentFlowActivity paymentFlowActivity, Result result) {
        Intrinsics.checkNotNullParameter(paymentFlowActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        Object r2 = result.m4718unboximpl();
        Throwable r0 = Result.m4712exceptionOrNullimpl(r2);
        if (r0 == null) {
            paymentFlowActivity.onShippingInfoValidated((List) r2);
        } else {
            paymentFlowActivity.onShippingInfoError(r0);
        }
    }

    private final void onShippingInfoError(Throwable th) {
        String message = th.getMessage();
        boolean z = false;
        setProgressBarVisible(false);
        CharSequence charSequence = message;
        if (charSequence == null || charSequence.length() == 0) {
            z = true;
        }
        if (!z) {
            showError(message);
        } else {
            String string = getString(R.string.invalid_shipping_information);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.invalid_shipping_information)");
            showError(string);
        }
        getViewModel().setPaymentSessionData$payments_core_release(PaymentSessionData.copy$default(getViewModel().getPaymentSessionData$payments_core_release(), false, false, 0, 0, (ShippingInformation) null, (ShippingMethod) null, (PaymentMethod) null, false, 239, (Object) null));
    }

    private final void finishWithData(PaymentSessionData paymentSessionData) {
        setResult(-1, new Intent().putExtra(PaymentSession.EXTRA_PAYMENT_SESSION_DATA, paymentSessionData));
        finish();
    }

    public void onBackPressed() {
        if (hasPreviousPage()) {
            PaymentFlowViewModel viewModel = getViewModel();
            viewModel.setCurrentPage$payments_core_release(viewModel.getCurrentPage$payments_core_release() - 1);
            getViewPager().setCurrentItem(getViewModel().getCurrentPage$payments_core_release());
            return;
        }
        super.onBackPressed();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/view/PaymentFlowActivity$Companion;", "", "()V", "PRODUCT_TOKEN", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentFlowActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
