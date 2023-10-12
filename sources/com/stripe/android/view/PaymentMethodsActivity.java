package com.stripe.android.view;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.util.LinkifyCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.google.android.material.snackbar.Snackbar;
import com.stripe.android.R;
import com.stripe.android.core.exception.StripeException;
import com.stripe.android.databinding.PaymentMethodsActivityBinding;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.view.AddPaymentMethodActivityStarter;
import com.stripe.android.view.PaymentMethodsActivityStarter;
import com.stripe.android.view.i18n.TranslatorManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001EB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u000202H\u0002J\u001c\u00104\u001a\u0002022\b\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u000208H\u0002J\u0015\u00109\u001a\u0002022\u0006\u0010:\u001a\u00020;H\u0001¢\u0006\u0002\b<J\u0010\u0010=\u001a\u0002022\u0006\u00105\u001a\u000206H\u0002J\b\u0010>\u001a\u000202H\u0016J\u0012\u0010?\u001a\u0002022\b\u0010@\u001a\u0004\u0018\u00010AH\u0014J\b\u0010B\u001a\u000202H\u0014J\b\u0010C\u001a\u00020\u001fH\u0016J\b\u0010D\u001a\u000202H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R*\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198BX\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\n\u0004\b\u001d\u0010\b\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\b\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020$8@X\u0002¢\u0006\f\n\u0004\b'\u0010\b\u001a\u0004\b%\u0010&R\u001b\u0010(\u001a\u00020)8BX\u0002¢\u0006\f\n\u0004\b,\u0010\b\u001a\u0004\b*\u0010+\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006F"}, d2 = {"Lcom/stripe/android/view/PaymentMethodsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/stripe/android/view/PaymentMethodsAdapter;", "getAdapter", "()Lcom/stripe/android/view/PaymentMethodsAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "alertDisplayer", "Lcom/stripe/android/view/AlertDisplayer;", "getAlertDisplayer", "()Lcom/stripe/android/view/AlertDisplayer;", "alertDisplayer$delegate", "args", "Lcom/stripe/android/view/PaymentMethodsActivityStarter$Args;", "getArgs", "()Lcom/stripe/android/view/PaymentMethodsActivityStarter$Args;", "args$delegate", "cardDisplayTextFactory", "Lcom/stripe/android/view/CardDisplayTextFactory;", "getCardDisplayTextFactory", "()Lcom/stripe/android/view/CardDisplayTextFactory;", "cardDisplayTextFactory$delegate", "customerSession", "Lkotlin/Result;", "Lcom/stripe/android/CustomerSession;", "getCustomerSession-d1pmJ48", "()Ljava/lang/Object;", "customerSession$delegate", "startedFromPaymentSession", "", "getStartedFromPaymentSession", "()Z", "startedFromPaymentSession$delegate", "viewBinding", "Lcom/stripe/android/databinding/PaymentMethodsActivityBinding;", "getViewBinding$payments_core_release", "()Lcom/stripe/android/databinding/PaymentMethodsActivityBinding;", "viewBinding$delegate", "viewModel", "Lcom/stripe/android/view/PaymentMethodsViewModel;", "getViewModel", "()Lcom/stripe/android/view/PaymentMethodsViewModel;", "viewModel$delegate", "createFooterView", "Landroid/view/View;", "contentRoot", "Landroid/view/ViewGroup;", "fetchCustomerPaymentMethods", "", "finishWithGooglePay", "finishWithResult", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "resultCode", "", "onAddPaymentMethodResult", "result", "Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Result;", "onAddPaymentMethodResult$payments_core_release", "onAddedPaymentMethod", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSupportNavigateUp", "setupRecyclerView", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodsActivity.kt */
public final class PaymentMethodsActivity extends AppCompatActivity {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PRODUCT_TOKEN = "PaymentMethodsActivity";
    private final Lazy adapter$delegate = LazyKt.lazy(new PaymentMethodsActivity$adapter$2(this));
    private final Lazy alertDisplayer$delegate = LazyKt.lazy(new PaymentMethodsActivity$alertDisplayer$2(this));
    private final Lazy args$delegate = LazyKt.lazy(new PaymentMethodsActivity$args$2(this));
    private final Lazy cardDisplayTextFactory$delegate = LazyKt.lazy(new PaymentMethodsActivity$cardDisplayTextFactory$2(this));
    private final Lazy customerSession$delegate = LazyKt.lazy(new PaymentMethodsActivity$customerSession$2(this));
    private final Lazy startedFromPaymentSession$delegate = LazyKt.lazy(new PaymentMethodsActivity$startedFromPaymentSession$2(this));
    private final Lazy viewBinding$delegate = LazyKt.lazy(new PaymentMethodsActivity$viewBinding$2(this));
    private final Lazy viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(PaymentMethodsViewModel.class), new PaymentMethodsActivity$special$$inlined$viewModels$2(this), new PaymentMethodsActivity$viewModel$2(this));

    public final PaymentMethodsActivityBinding getViewBinding$payments_core_release() {
        return (PaymentMethodsActivityBinding) this.viewBinding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final boolean getStartedFromPaymentSession() {
        return ((Boolean) this.startedFromPaymentSession$delegate.getValue()).booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: getCustomerSession-d1pmJ48  reason: not valid java name */
    public final Object m4673getCustomerSessiond1pmJ48() {
        return ((Result) this.customerSession$delegate.getValue()).m4718unboximpl();
    }

    private final CardDisplayTextFactory getCardDisplayTextFactory() {
        return (CardDisplayTextFactory) this.cardDisplayTextFactory$delegate.getValue();
    }

    private final AlertDisplayer getAlertDisplayer() {
        return (AlertDisplayer) this.alertDisplayer$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final PaymentMethodsActivityStarter.Args getArgs() {
        return (PaymentMethodsActivityStarter.Args) this.args$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final PaymentMethodsViewModel getViewModel() {
        return (PaymentMethodsViewModel) this.viewModel$delegate.getValue();
    }

    private final PaymentMethodsAdapter getAdapter() {
        return (PaymentMethodsAdapter) this.adapter$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Result.m4715isFailureimpl(m4673getCustomerSessiond1pmJ48())) {
            finishWithResult((PaymentMethod) null, 0);
            return;
        }
        setContentView((View) getViewBinding$payments_core_release().getRoot());
        Integer windowFlags$payments_core_release = getArgs().getWindowFlags$payments_core_release();
        if (windowFlags$payments_core_release != null) {
            getWindow().addFlags(windowFlags$payments_core_release.intValue());
        }
        LifecycleOwner lifecycleOwner = this;
        getViewModel().getSnackbarData$payments_core_release().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PaymentMethodsActivity.m4675onCreate$lambda2(PaymentMethodsActivity.this, (String) obj);
            }
        });
        getViewModel().getProgressData$payments_core_release().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PaymentMethodsActivity.m4676onCreate$lambda3(PaymentMethodsActivity.this, (Boolean) obj);
            }
        });
        setupRecyclerView();
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new AddPaymentMethodContract(), new ActivityResultCallback() {
            public final void onActivityResult(Object obj) {
                PaymentMethodsActivity.this.onAddPaymentMethodResult$payments_core_release((AddPaymentMethodActivityStarter.Result) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResul…entMethodResult\n        )");
        getAdapter().getAddPaymentMethodArgs().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PaymentMethodsActivity.m4677onCreate$lambda4(ActivityResultLauncher.this, (AddPaymentMethodActivityStarter.Args) obj);
            }
        });
        setSupportActionBar(getViewBinding$payments_core_release().toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setDisplayShowHomeEnabled(true);
        }
        FrameLayout frameLayout = getViewBinding$payments_core_release().footerContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "viewBinding.footerContainer");
        View createFooterView = createFooterView(frameLayout);
        if (createFooterView != null) {
            if (Build.VERSION.SDK_INT >= 22) {
                getViewBinding$payments_core_release().recycler.setAccessibilityTraversalBefore(createFooterView.getId());
                createFooterView.setAccessibilityTraversalAfter(getViewBinding$payments_core_release().recycler.getId());
            }
            getViewBinding$payments_core_release().footerContainer.addView(createFooterView);
            FrameLayout frameLayout2 = getViewBinding$payments_core_release().footerContainer;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "viewBinding.footerContainer");
            frameLayout2.setVisibility(0);
        }
        fetchCustomerPaymentMethods();
        getViewBinding$payments_core_release().recycler.requestFocusFromTouch();
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m4675onCreate$lambda2(PaymentMethodsActivity paymentMethodsActivity, String str) {
        Intrinsics.checkNotNullParameter(paymentMethodsActivity, "this$0");
        if (str != null) {
            Snackbar.make((View) paymentMethodsActivity.getViewBinding$payments_core_release().coordinator, (CharSequence) str, -1).show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-3  reason: not valid java name */
    public static final void m4676onCreate$lambda3(PaymentMethodsActivity paymentMethodsActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(paymentMethodsActivity, "this$0");
        LinearProgressIndicator linearProgressIndicator = paymentMethodsActivity.getViewBinding$payments_core_release().progressBar;
        Intrinsics.checkNotNullExpressionValue(linearProgressIndicator, "viewBinding.progressBar");
        View view = linearProgressIndicator;
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        view.setVisibility(bool.booleanValue() ? 0 : 8);
    }

    /* access modifiers changed from: private */
    /* renamed from: onCreate$lambda-4  reason: not valid java name */
    public static final void m4677onCreate$lambda4(ActivityResultLauncher activityResultLauncher, AddPaymentMethodActivityStarter.Args args) {
        Intrinsics.checkNotNullParameter(activityResultLauncher, "$addPaymentMethodLauncher");
        if (args != null) {
            activityResultLauncher.launch(args);
        }
    }

    private final void setupRecyclerView() {
        Context context = this;
        DeletePaymentMethodDialogFactory deletePaymentMethodDialogFactory = new DeletePaymentMethodDialogFactory(context, getAdapter(), getCardDisplayTextFactory(), m4673getCustomerSessiond1pmJ48(), getViewModel().getProductUsage$payments_core_release(), new PaymentMethodsActivity$setupRecyclerView$deletePaymentMethodDialogFactory$1(this));
        getAdapter().setListener$payments_core_release(new PaymentMethodsActivity$setupRecyclerView$1(this, deletePaymentMethodDialogFactory));
        getViewBinding$payments_core_release().recycler.setAdapter(getAdapter());
        getViewBinding$payments_core_release().recycler.setPaymentMethodSelectedCallback$payments_core_release(new PaymentMethodsActivity$setupRecyclerView$2(this));
        if (getArgs().getCanDeletePaymentMethods$payments_core_release()) {
            getViewBinding$payments_core_release().recycler.attachItemTouchHelper$payments_core_release(new PaymentMethodSwipeCallback(context, getAdapter(), new SwipeToDeleteCallbackListener(deletePaymentMethodDialogFactory)));
        }
    }

    public boolean onSupportNavigateUp() {
        finishWithResult(getAdapter().getSelectedPaymentMethod$payments_core_release(), 0);
        return true;
    }

    public final void onAddPaymentMethodResult$payments_core_release(AddPaymentMethodActivityStarter.Result result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result instanceof AddPaymentMethodActivityStarter.Result.Success) {
            onAddedPaymentMethod(((AddPaymentMethodActivityStarter.Result.Success) result).getPaymentMethod());
        } else {
            boolean z = result instanceof AddPaymentMethodActivityStarter.Result.Failure;
        }
    }

    private final void onAddedPaymentMethod(PaymentMethod paymentMethod) {
        PaymentMethod.Type type = paymentMethod.type;
        boolean z = true;
        if (type == null || !type.isReusable) {
            z = false;
        }
        if (z) {
            fetchCustomerPaymentMethods();
            getViewModel().onPaymentMethodAdded$payments_core_release(paymentMethod);
            return;
        }
        finishWithResult$default(this, paymentMethod, 0, 2, (Object) null);
    }

    public void onBackPressed() {
        finishWithResult(getAdapter().getSelectedPaymentMethod$payments_core_release(), 0);
    }

    private final void fetchCustomerPaymentMethods() {
        getViewModel().getPaymentMethods$payments_core_release().observe(this, new Observer() {
            public final void onChanged(Object obj) {
                PaymentMethodsActivity.m4672fetchCustomerPaymentMethods$lambda9(PaymentMethodsActivity.this, (Result) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: fetchCustomerPaymentMethods$lambda-9  reason: not valid java name */
    public static final void m4672fetchCustomerPaymentMethods$lambda9(PaymentMethodsActivity paymentMethodsActivity, Result result) {
        String str;
        Intrinsics.checkNotNullParameter(paymentMethodsActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        Object r4 = result.m4718unboximpl();
        Throwable r0 = Result.m4712exceptionOrNullimpl(r4);
        if (r0 == null) {
            paymentMethodsActivity.getAdapter().setPaymentMethods$payments_core_release((List) r4);
            return;
        }
        AlertDisplayer alertDisplayer = paymentMethodsActivity.getAlertDisplayer();
        if (r0 instanceof StripeException) {
            StripeException stripeException = (StripeException) r0;
            str = TranslatorManager.INSTANCE.getErrorMessageTranslator().translate(stripeException.getStatusCode(), r0.getMessage(), stripeException.getStripeError());
        } else {
            str = r0.getMessage();
            if (str == null) {
                str = "";
            }
        }
        alertDisplayer.show(str);
    }

    /* access modifiers changed from: private */
    public final void finishWithGooglePay() {
        setResult(-1, new Intent().putExtras(new PaymentMethodsActivityStarter.Result((PaymentMethod) null, true, 1, (DefaultConstructorMarker) null).toBundle()));
        finish();
    }

    static /* synthetic */ void finishWithResult$default(PaymentMethodsActivity paymentMethodsActivity, PaymentMethod paymentMethod, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = -1;
        }
        paymentMethodsActivity.finishWithResult(paymentMethod, i);
    }

    private final void finishWithResult(PaymentMethod paymentMethod, int i) {
        Intent intent = new Intent();
        intent.putExtras(new PaymentMethodsActivityStarter.Result(paymentMethod, getArgs().getUseGooglePay$payments_core_release() && paymentMethod == null).toBundle());
        Unit unit = Unit.INSTANCE;
        setResult(i, intent);
        finish();
    }

    private final View createFooterView(ViewGroup viewGroup) {
        if (getArgs().getPaymentMethodsFooterLayoutId() <= 0) {
            return null;
        }
        View inflate = getLayoutInflater().inflate(getArgs().getPaymentMethodsFooterLayoutId(), viewGroup, false);
        inflate.setId(R.id.stripe_payment_methods_footer);
        if (!(inflate instanceof TextView)) {
            return inflate;
        }
        TextView textView = (TextView) inflate;
        LinkifyCompat.addLinks(textView, 15);
        ViewCompat.enableAccessibleClickableSpanSupport(inflate);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        PaymentMethodsViewModel viewModel = getViewModel();
        PaymentMethod selectedPaymentMethod$payments_core_release = getAdapter().getSelectedPaymentMethod$payments_core_release();
        viewModel.setSelectedPaymentMethodId$payments_core_release(selectedPaymentMethod$payments_core_release == null ? null : selectedPaymentMethod$payments_core_release.id);
        super.onDestroy();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/view/PaymentMethodsActivity$Companion;", "", "()V", "PRODUCT_TOKEN", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodsActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
