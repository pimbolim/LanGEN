package com.stripe.android.view;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.stripe.android.CustomerSession;
import com.stripe.android.R;
import com.stripe.android.core.StripeError;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.payments.core.injection.NamedConstantsKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0019BR\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0010J\u0015\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0013R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/view/DeletePaymentMethodDialogFactory;", "", "context", "Landroid/content/Context;", "adapter", "Lcom/stripe/android/view/PaymentMethodsAdapter;", "cardDisplayTextFactory", "Lcom/stripe/android/view/CardDisplayTextFactory;", "customerSession", "Lkotlin/Result;", "Lcom/stripe/android/CustomerSession;", "productUsage", "", "", "onDeletedPaymentMethodCallback", "Lkotlin/Function1;", "Lcom/stripe/android/model/PaymentMethod;", "", "(Landroid/content/Context;Lcom/stripe/android/view/PaymentMethodsAdapter;Lcom/stripe/android/view/CardDisplayTextFactory;Ljava/lang/Object;Ljava/util/Set;Lkotlin/jvm/functions/Function1;)V", "Ljava/lang/Object;", "create", "Landroidx/appcompat/app/AlertDialog;", "paymentMethod", "onDeletedPaymentMethod", "onDeletedPaymentMethod$payments_core_release", "PaymentMethodDeleteListener", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DeletePaymentMethodDialogFactory.kt */
public final class DeletePaymentMethodDialogFactory {
    private final PaymentMethodsAdapter adapter;
    private final CardDisplayTextFactory cardDisplayTextFactory;
    private final Context context;
    private final Object customerSession;
    private final Function1<PaymentMethod, Unit> onDeletedPaymentMethodCallback;
    private final Set<String> productUsage;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/view/DeletePaymentMethodDialogFactory$PaymentMethodDeleteListener;", "Lcom/stripe/android/CustomerSession$PaymentMethodRetrievalListener;", "()V", "onError", "", "errorCode", "", "errorMessage", "", "stripeError", "Lcom/stripe/android/core/StripeError;", "onPaymentMethodRetrieved", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DeletePaymentMethodDialogFactory.kt */
    private static final class PaymentMethodDeleteListener implements CustomerSession.PaymentMethodRetrievalListener {
        public void onError(int i, String str, StripeError stripeError) {
            Intrinsics.checkNotNullParameter(str, "errorMessage");
        }

        public void onPaymentMethodRetrieved(PaymentMethod paymentMethod) {
            Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        }
    }

    public DeletePaymentMethodDialogFactory(Context context2, PaymentMethodsAdapter paymentMethodsAdapter, CardDisplayTextFactory cardDisplayTextFactory2, Object obj, Set<String> set, Function1<? super PaymentMethod, Unit> function1) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(paymentMethodsAdapter, "adapter");
        Intrinsics.checkNotNullParameter(cardDisplayTextFactory2, "cardDisplayTextFactory");
        Intrinsics.checkNotNullParameter(set, NamedConstantsKt.PRODUCT_USAGE);
        Intrinsics.checkNotNullParameter(function1, "onDeletedPaymentMethodCallback");
        this.context = context2;
        this.adapter = paymentMethodsAdapter;
        this.cardDisplayTextFactory = cardDisplayTextFactory2;
        this.customerSession = obj;
        this.productUsage = set;
        this.onDeletedPaymentMethodCallback = function1;
    }

    public final /* synthetic */ AlertDialog create(PaymentMethod paymentMethod) {
        String str;
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        PaymentMethod.Card card = paymentMethod.card;
        if (card == null) {
            str = null;
        } else {
            str = this.cardDisplayTextFactory.createUnstyled$payments_core_release(card);
        }
        AlertDialog create = new AlertDialog.Builder(this.context, R.style.AlertDialogStyle).setTitle(R.string.delete_payment_method_prompt_title).setMessage((CharSequence) str).setPositiveButton(17039370, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(paymentMethod) {
            public final /* synthetic */ PaymentMethod f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                DeletePaymentMethodDialogFactory.m4660create$lambda1(DeletePaymentMethodDialogFactory.this, this.f$1, dialogInterface, i);
            }
        }).setNegativeButton(17039360, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(paymentMethod) {
            public final /* synthetic */ PaymentMethod f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                DeletePaymentMethodDialogFactory.m4661create$lambda2(DeletePaymentMethodDialogFactory.this, this.f$1, dialogInterface, i);
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener(paymentMethod) {
            public final /* synthetic */ PaymentMethod f$1;

            {
                this.f$1 = r2;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                DeletePaymentMethodDialogFactory.m4662create$lambda3(DeletePaymentMethodDialogFactory.this, this.f$1, dialogInterface);
            }
        }).create();
        Intrinsics.checkNotNullExpressionValue(create, "Builder(context, R.style…  }\n            .create()");
        return create;
    }

    /* access modifiers changed from: private */
    /* renamed from: create$lambda-1  reason: not valid java name */
    public static final void m4660create$lambda1(DeletePaymentMethodDialogFactory deletePaymentMethodDialogFactory, PaymentMethod paymentMethod, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(deletePaymentMethodDialogFactory, "this$0");
        Intrinsics.checkNotNullParameter(paymentMethod, "$paymentMethod");
        deletePaymentMethodDialogFactory.onDeletedPaymentMethod$payments_core_release(paymentMethod);
    }

    /* access modifiers changed from: private */
    /* renamed from: create$lambda-2  reason: not valid java name */
    public static final void m4661create$lambda2(DeletePaymentMethodDialogFactory deletePaymentMethodDialogFactory, PaymentMethod paymentMethod, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(deletePaymentMethodDialogFactory, "this$0");
        Intrinsics.checkNotNullParameter(paymentMethod, "$paymentMethod");
        deletePaymentMethodDialogFactory.adapter.resetPaymentMethod$payments_core_release(paymentMethod);
    }

    /* access modifiers changed from: private */
    /* renamed from: create$lambda-3  reason: not valid java name */
    public static final void m4662create$lambda3(DeletePaymentMethodDialogFactory deletePaymentMethodDialogFactory, PaymentMethod paymentMethod, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(deletePaymentMethodDialogFactory, "this$0");
        Intrinsics.checkNotNullParameter(paymentMethod, "$paymentMethod");
        deletePaymentMethodDialogFactory.adapter.resetPaymentMethod$payments_core_release(paymentMethod);
    }

    public final /* synthetic */ void onDeletedPaymentMethod$payments_core_release(PaymentMethod paymentMethod) {
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        this.adapter.deletePaymentMethod$payments_core_release(paymentMethod);
        String str = paymentMethod.id;
        if (str != null) {
            Object obj = this.customerSession;
            if (Result.m4715isFailureimpl(obj)) {
                obj = null;
            }
            CustomerSession customerSession2 = (CustomerSession) obj;
            if (customerSession2 != null) {
                customerSession2.detachPaymentMethod$payments_core_release(str, this.productUsage, new PaymentMethodDeleteListener());
            }
        }
        this.onDeletedPaymentMethodCallback.invoke(paymentMethod);
    }
}
