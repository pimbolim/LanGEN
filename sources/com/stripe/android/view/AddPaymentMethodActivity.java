package com.stripe.android.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.text.util.LinkifyCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelLazy;
import com.stripe.android.CustomerSession;
import com.stripe.android.R;
import com.stripe.android.Stripe;
import com.stripe.android.databinding.AddPaymentMethodActivityBinding;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.view.AddPaymentMethodActivityStarter;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020'2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020.H\u0002J\u001f\u0010/\u001a\u00020'2\u0006\u0010!\u001a\u00020\"2\b\u00100\u001a\u0004\u0018\u000101H\u0000¢\u0006\u0002\b2J\u0010\u00103\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u00104\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u00105\u001a\u00020'2\u0006\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u00020'H\u0016J\u0012\u00109\u001a\u00020'2\b\u0010:\u001a\u0004\u0018\u00010;H\u0014J\u0010\u0010<\u001a\u00020'2\u0006\u0010=\u001a\u00020\u0014H\u0014J\b\u0010>\u001a\u00020'H\u0014R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001e8CX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\b\u001a\u0004\b#\u0010$¨\u0006@"}, d2 = {"Lcom/stripe/android/view/AddPaymentMethodActivity;", "Lcom/stripe/android/view/StripeActivity;", "()V", "addPaymentMethodView", "Lcom/stripe/android/view/AddPaymentMethodView;", "getAddPaymentMethodView", "()Lcom/stripe/android/view/AddPaymentMethodView;", "addPaymentMethodView$delegate", "Lkotlin/Lazy;", "args", "Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Args;", "getArgs", "()Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Args;", "args$delegate", "paymentMethodType", "Lcom/stripe/android/model/PaymentMethod$Type;", "getPaymentMethodType", "()Lcom/stripe/android/model/PaymentMethod$Type;", "paymentMethodType$delegate", "shouldAttachToCustomer", "", "getShouldAttachToCustomer", "()Z", "shouldAttachToCustomer$delegate", "stripe", "Lcom/stripe/android/Stripe;", "getStripe", "()Lcom/stripe/android/Stripe;", "stripe$delegate", "titleStringRes", "", "getTitleStringRes", "()I", "viewModel", "Lcom/stripe/android/view/AddPaymentMethodViewModel;", "getViewModel", "()Lcom/stripe/android/view/AddPaymentMethodViewModel;", "viewModel$delegate", "attachPaymentMethodToCustomer", "", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "configureView", "createFooterView", "Landroid/view/View;", "contentRoot", "Landroid/view/ViewGroup;", "createPaymentMethod", "params", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "createPaymentMethod$payments_core_release", "createPaymentMethodView", "finishWithPaymentMethod", "finishWithResult", "result", "Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Result;", "onActionSave", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onProgressBarVisibilityChanged", "visible", "onResume", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddPaymentMethodActivity.kt */
public final class AddPaymentMethodActivity extends StripeActivity {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PRODUCT_TOKEN = "AddPaymentMethodActivity";
    private final Lazy addPaymentMethodView$delegate = LazyKt.lazy(new AddPaymentMethodActivity$addPaymentMethodView$2(this));
    private final Lazy args$delegate = LazyKt.lazy(new AddPaymentMethodActivity$args$2(this));
    private final Lazy paymentMethodType$delegate = LazyKt.lazy(new AddPaymentMethodActivity$paymentMethodType$2(this));
    private final Lazy shouldAttachToCustomer$delegate = LazyKt.lazy(new AddPaymentMethodActivity$shouldAttachToCustomer$2(this));
    private final Lazy stripe$delegate = LazyKt.lazy(new AddPaymentMethodActivity$stripe$2(this));
    private final Lazy viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(AddPaymentMethodViewModel.class), new AddPaymentMethodActivity$special$$inlined$viewModels$2(this), new AddPaymentMethodActivity$viewModel$2(this));

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AddPaymentMethodActivity.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaymentMethod.Type.values().length];
            iArr[PaymentMethod.Type.Card.ordinal()] = 1;
            iArr[PaymentMethod.Type.Fpx.ordinal()] = 2;
            iArr[PaymentMethod.Type.Netbanking.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: private */
    public final AddPaymentMethodActivityStarter.Args getArgs() {
        return (AddPaymentMethodActivityStarter.Args) this.args$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Stripe getStripe() {
        return (Stripe) this.stripe$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final PaymentMethod.Type getPaymentMethodType() {
        return (PaymentMethod.Type) this.paymentMethodType$delegate.getValue();
    }

    private final boolean getShouldAttachToCustomer() {
        return ((Boolean) this.shouldAttachToCustomer$delegate.getValue()).booleanValue();
    }

    private final AddPaymentMethodView getAddPaymentMethodView() {
        return (AddPaymentMethodView) this.addPaymentMethodView$delegate.getValue();
    }

    private final AddPaymentMethodViewModel getViewModel() {
        return (AddPaymentMethodViewModel) this.viewModel$delegate.getValue();
    }

    private final int getTitleStringRes() {
        int i = WhenMappings.$EnumSwitchMapping$0[getPaymentMethodType().ordinal()];
        if (i == 1) {
            return R.string.title_add_a_card;
        }
        if (i == 2) {
            return R.string.title_bank_account;
        }
        if (i == 3) {
            return R.string.title_bank_account;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Unsupported Payment Method type: ", getPaymentMethodType().code));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        configureView(getArgs());
        setResult(-1, new Intent().putExtras(AddPaymentMethodActivityStarter.Result.Canceled.INSTANCE.toBundle()));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        getAddPaymentMethodView().requestFocus();
    }

    private final void configureView(AddPaymentMethodActivityStarter.Args args) {
        Integer windowFlags$payments_core_release = args.getWindowFlags$payments_core_release();
        if (windowFlags$payments_core_release != null) {
            getWindow().addFlags(windowFlags$payments_core_release.intValue());
        }
        getViewStub$payments_core_release().setLayoutResource(R.layout.add_payment_method_activity);
        View inflate = getViewStub$payments_core_release().inflate();
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        AddPaymentMethodActivityBinding bind = AddPaymentMethodActivityBinding.bind((ViewGroup) inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(scrollView)");
        bind.root.addView(getAddPaymentMethodView());
        LinearLayout linearLayout = bind.root;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "viewBinding.root");
        View createFooterView = createFooterView(linearLayout);
        if (createFooterView != null) {
            if (Build.VERSION.SDK_INT >= 22) {
                getAddPaymentMethodView().setAccessibilityTraversalBefore(createFooterView.getId());
                createFooterView.setAccessibilityTraversalAfter(getAddPaymentMethodView().getId());
            }
            bind.root.addView(createFooterView);
        }
        setTitle(getTitleStringRes());
    }

    /* access modifiers changed from: private */
    public final AddPaymentMethodView createPaymentMethodView(AddPaymentMethodActivityStarter.Args args) {
        int i = WhenMappings.$EnumSwitchMapping$0[getPaymentMethodType().ordinal()];
        if (i == 1) {
            return new AddPaymentMethodCardView(this, (AttributeSet) null, 0, args.getBillingAddressFields$payments_core_release(), 6, (DefaultConstructorMarker) null);
        }
        if (i == 2) {
            return AddPaymentMethodFpxView.Companion.create$payments_core_release(this);
        }
        if (i == 3) {
            return AddPaymentMethodNetbankingView.Companion.create$payments_core_release(this);
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Unsupported Payment Method type: ", getPaymentMethodType().code));
    }

    private final View createFooterView(ViewGroup viewGroup) {
        if (getArgs().getAddPaymentMethodFooterLayoutId$payments_core_release() <= 0) {
            return null;
        }
        View inflate = getLayoutInflater().inflate(getArgs().getAddPaymentMethodFooterLayoutId$payments_core_release(), viewGroup, false);
        inflate.setId(R.id.stripe_add_payment_method_footer);
        if (!(inflate instanceof TextView)) {
            return inflate;
        }
        TextView textView = (TextView) inflate;
        LinkifyCompat.addLinks(textView, 15);
        ViewCompat.enableAccessibleClickableSpanSupport(inflate);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        return inflate;
    }

    public void onActionSave() {
        createPaymentMethod$payments_core_release(getViewModel(), getAddPaymentMethodView().getCreateParams());
    }

    public final void createPaymentMethod$payments_core_release(AddPaymentMethodViewModel addPaymentMethodViewModel, PaymentMethodCreateParams paymentMethodCreateParams) {
        Intrinsics.checkNotNullParameter(addPaymentMethodViewModel, "viewModel");
        if (paymentMethodCreateParams != null) {
            setProgressBarVisible(true);
            addPaymentMethodViewModel.createPaymentMethod$payments_core_release(paymentMethodCreateParams).observe(this, new Observer() {
                public final void onChanged(Object obj) {
                    AddPaymentMethodActivity.m4636createPaymentMethod$lambda4(AddPaymentMethodActivity.this, (Result) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: createPaymentMethod$lambda-4  reason: not valid java name */
    public static final void m4636createPaymentMethod$lambda4(AddPaymentMethodActivity addPaymentMethodActivity, Result result) {
        Intrinsics.checkNotNullParameter(addPaymentMethodActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        Object r2 = result.m4718unboximpl();
        Throwable r0 = Result.m4712exceptionOrNullimpl(r2);
        if (r0 == null) {
            PaymentMethod paymentMethod = (PaymentMethod) r2;
            if (addPaymentMethodActivity.getShouldAttachToCustomer()) {
                addPaymentMethodActivity.attachPaymentMethodToCustomer(paymentMethod);
            } else {
                addPaymentMethodActivity.finishWithPaymentMethod(paymentMethod);
            }
        } else {
            addPaymentMethodActivity.setProgressBarVisible(false);
            String message = r0.getMessage();
            if (message == null) {
                message = "";
            }
            addPaymentMethodActivity.showError(message);
        }
    }

    private final void attachPaymentMethodToCustomer(PaymentMethod paymentMethod) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            AddPaymentMethodActivity addPaymentMethodActivity = this;
            obj = Result.m4709constructorimpl(CustomerSession.Companion.getInstance());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        Throwable r1 = Result.m4712exceptionOrNullimpl(obj);
        if (r1 == null) {
            getViewModel().attachPaymentMethod$payments_core_release((CustomerSession) obj, paymentMethod).observe(this, new Observer() {
                public final void onChanged(Object obj) {
                    AddPaymentMethodActivity.m4635attachPaymentMethodToCustomer$lambda8$lambda7(AddPaymentMethodActivity.this, (Result) obj);
                }
            });
            return;
        }
        finishWithResult(new AddPaymentMethodActivityStarter.Result.Failure(r1));
    }

    /* access modifiers changed from: private */
    /* renamed from: attachPaymentMethodToCustomer$lambda-8$lambda-7  reason: not valid java name */
    public static final void m4635attachPaymentMethodToCustomer$lambda8$lambda7(AddPaymentMethodActivity addPaymentMethodActivity, Result result) {
        Intrinsics.checkNotNullParameter(addPaymentMethodActivity, "this$0");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        Object r2 = result.m4718unboximpl();
        Throwable r0 = Result.m4712exceptionOrNullimpl(r2);
        if (r0 == null) {
            addPaymentMethodActivity.finishWithPaymentMethod((PaymentMethod) r2);
            return;
        }
        addPaymentMethodActivity.setProgressBarVisible(false);
        String message = r0.getMessage();
        if (message == null) {
            message = "";
        }
        addPaymentMethodActivity.showError(message);
    }

    private final void finishWithPaymentMethod(PaymentMethod paymentMethod) {
        finishWithResult(new AddPaymentMethodActivityStarter.Result.Success(paymentMethod));
    }

    private final void finishWithResult(AddPaymentMethodActivityStarter.Result result) {
        setProgressBarVisible(false);
        setResult(-1, new Intent().putExtras(result.toBundle()));
        finish();
    }

    /* access modifiers changed from: protected */
    public void onProgressBarVisibilityChanged(boolean z) {
        getAddPaymentMethodView().setCommunicatingProgress(z);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/view/AddPaymentMethodActivity$Companion;", "", "()V", "PRODUCT_TOKEN", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AddPaymentMethodActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
