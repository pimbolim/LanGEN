package com.stripe.android.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.stripe.android.model.PaymentMethod;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0000¢\u0006\u0002\b\u0019R&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/view/PaymentMethodsRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "paymentMethodSelectedCallback", "Lkotlin/Function1;", "Lcom/stripe/android/model/PaymentMethod;", "", "getPaymentMethodSelectedCallback$payments_core_release", "()Lkotlin/jvm/functions/Function1;", "setPaymentMethodSelectedCallback$payments_core_release", "(Lkotlin/jvm/functions/Function1;)V", "tappedPaymentMethod", "getTappedPaymentMethod$payments_core_release", "()Lcom/stripe/android/model/PaymentMethod;", "setTappedPaymentMethod$payments_core_release", "(Lcom/stripe/android/model/PaymentMethod;)V", "attachItemTouchHelper", "callback", "Landroidx/recyclerview/widget/ItemTouchHelper$SimpleCallback;", "attachItemTouchHelper$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodsRecyclerView.kt */
public final class PaymentMethodsRecyclerView extends RecyclerView {
    private Function1<? super PaymentMethod, Unit> paymentMethodSelectedCallback;
    private PaymentMethod tappedPaymentMethod;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PaymentMethodsRecyclerView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PaymentMethodsRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentMethodsRecyclerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentMethodsRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.paymentMethodSelectedCallback = PaymentMethodsRecyclerView$paymentMethodSelectedCallback$1.INSTANCE;
        setHasFixedSize(false);
        setLayoutManager(new LinearLayoutManager(context));
        setItemAnimator(new DefaultItemAnimator(this) {
            final /* synthetic */ PaymentMethodsRecyclerView this$0;

            {
                this.this$0 = r1;
            }

            public void onAnimationFinished(RecyclerView.ViewHolder viewHolder) {
                Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
                super.onAnimationFinished(viewHolder);
                PaymentMethod tappedPaymentMethod$payments_core_release = this.this$0.getTappedPaymentMethod$payments_core_release();
                if (tappedPaymentMethod$payments_core_release != null) {
                    this.this$0.getPaymentMethodSelectedCallback$payments_core_release().invoke(tappedPaymentMethod$payments_core_release);
                }
                this.this$0.setTappedPaymentMethod$payments_core_release((PaymentMethod) null);
            }
        });
    }

    public final Function1<PaymentMethod, Unit> getPaymentMethodSelectedCallback$payments_core_release() {
        return this.paymentMethodSelectedCallback;
    }

    public final void setPaymentMethodSelectedCallback$payments_core_release(Function1<? super PaymentMethod, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.paymentMethodSelectedCallback = function1;
    }

    public final PaymentMethod getTappedPaymentMethod$payments_core_release() {
        return this.tappedPaymentMethod;
    }

    public final void setTappedPaymentMethod$payments_core_release(PaymentMethod paymentMethod) {
        this.tappedPaymentMethod = paymentMethod;
    }

    public final /* synthetic */ void attachItemTouchHelper$payments_core_release(ItemTouchHelper.SimpleCallback simpleCallback) {
        Intrinsics.checkNotNullParameter(simpleCallback, "callback");
        new ItemTouchHelper(simpleCallback).attachToRecyclerView(this);
    }
}
