package com.stripe.android.view;

import android.util.AttributeSet;
import androidx.fragment.app.FragmentActivity;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodCreateParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B%\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/view/AddPaymentMethodNetbankingView;", "Lcom/stripe/android/view/AddPaymentMethodView;", "activity", "Landroidx/fragment/app/FragmentActivity;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroidx/fragment/app/FragmentActivity;Landroid/util/AttributeSet;I)V", "createParams", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "getCreateParams", "()Lcom/stripe/android/model/PaymentMethodCreateParams;", "netbankingAdapter", "Lcom/stripe/android/view/AddPaymentMethodListAdapter;", "selectedPosition", "Ljava/lang/Integer;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddPaymentMethodNetbankingView.kt */
public final class AddPaymentMethodNetbankingView extends AddPaymentMethodView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final AddPaymentMethodListAdapter netbankingAdapter;
    /* access modifiers changed from: private */
    public Integer selectedPosition;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AddPaymentMethodNetbankingView(FragmentActivity fragmentActivity) {
        this(fragmentActivity, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AddPaymentMethodNetbankingView(FragmentActivity fragmentActivity, AttributeSet attributeSet) {
        this(fragmentActivity, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AddPaymentMethodNetbankingView(FragmentActivity fragmentActivity, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentActivity, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AddPaymentMethodNetbankingView(androidx.fragment.app.FragmentActivity r4, android.util.AttributeSet r5, int r6) {
        /*
            r3 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = r4
            android.content.Context r0 = (android.content.Context) r0
            r3.<init>(r0, r5, r6)
            com.stripe.android.view.AddPaymentMethodListAdapter r5 = new com.stripe.android.view.AddPaymentMethodListAdapter
            com.stripe.android.view.ThemeConfig r6 = new com.stripe.android.view.ThemeConfig
            r6.<init>(r0)
            com.stripe.android.view.NetbankingBank[] r1 = com.stripe.android.view.NetbankingBank.values()
            java.util.List r1 = kotlin.collections.ArraysKt.toList((T[]) r1)
            com.stripe.android.view.AddPaymentMethodNetbankingView$netbankingAdapter$1 r2 = new com.stripe.android.view.AddPaymentMethodNetbankingView$netbankingAdapter$1
            r2.<init>(r3)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            r5.<init>(r6, r1, r2)
            r3.netbankingAdapter = r5
            android.view.LayoutInflater r4 = r4.getLayoutInflater()
            r6 = r3
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r1 = 1
            com.stripe.android.databinding.BankListPaymentMethodBinding r4 = com.stripe.android.databinding.BankListPaymentMethodBinding.inflate(r4, r6, r1)
            java.lang.String r6 = "inflate(\n            act…           true\n        )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            int r6 = com.stripe.android.R.id.stripe_payment_methods_add_netbanking
            r3.setId(r6)
            androidx.recyclerview.widget.RecyclerView r4 = r4.bankList
            r6 = r5
            androidx.recyclerview.widget.RecyclerView$Adapter r6 = (androidx.recyclerview.widget.RecyclerView.Adapter) r6
            r4.setAdapter(r6)
            r4.setHasFixedSize(r1)
            androidx.recyclerview.widget.LinearLayoutManager r6 = new androidx.recyclerview.widget.LinearLayoutManager
            r6.<init>(r0)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r6 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r6
            r4.setLayoutManager(r6)
            androidx.recyclerview.widget.DefaultItemAnimator r6 = new androidx.recyclerview.widget.DefaultItemAnimator
            r6.<init>()
            androidx.recyclerview.widget.RecyclerView$ItemAnimator r6 = (androidx.recyclerview.widget.RecyclerView.ItemAnimator) r6
            r4.setItemAnimator(r6)
            java.lang.Integer r4 = r3.selectedPosition
            if (r4 != 0) goto L_0x0060
            goto L_0x0069
        L_0x0060:
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            r5.updateSelected$payments_core_release(r4)
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.AddPaymentMethodNetbankingView.<init>(androidx.fragment.app.FragmentActivity, android.util.AttributeSet, int):void");
    }

    public PaymentMethodCreateParams getCreateParams() {
        Integer valueOf = Integer.valueOf(this.netbankingAdapter.getSelectedPosition());
        if (!(valueOf.intValue() != -1)) {
            valueOf = null;
        }
        if (valueOf == null) {
            return null;
        }
        valueOf.intValue();
        return PaymentMethodCreateParams.Companion.create$default(PaymentMethodCreateParams.Companion, new PaymentMethodCreateParams.Netbanking(NetbankingBank.values()[this.netbankingAdapter.getSelectedPosition()].getCode()), (PaymentMethod.BillingDetails) null, (Map) null, 6, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/view/AddPaymentMethodNetbankingView$Companion;", "", "()V", "create", "Lcom/stripe/android/view/AddPaymentMethodNetbankingView;", "activity", "Landroidx/fragment/app/FragmentActivity;", "create$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AddPaymentMethodNetbankingView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final /* synthetic */ AddPaymentMethodNetbankingView create$payments_core_release(FragmentActivity fragmentActivity) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            return new AddPaymentMethodNetbankingView(fragmentActivity, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        }
    }
}
