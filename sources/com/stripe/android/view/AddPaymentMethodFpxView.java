package com.stripe.android.view;

import android.util.AttributeSet;
import androidx.fragment.app.FragmentActivity;
import com.stripe.android.model.BankStatuses;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodCreateParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB%\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/stripe/android/view/AddPaymentMethodFpxView;", "Lcom/stripe/android/view/AddPaymentMethodView;", "activity", "Landroidx/fragment/app/FragmentActivity;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroidx/fragment/app/FragmentActivity;Landroid/util/AttributeSet;I)V", "createParams", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "getCreateParams", "()Lcom/stripe/android/model/PaymentMethodCreateParams;", "fpxAdapter", "Lcom/stripe/android/view/AddPaymentMethodListAdapter;", "fpxBankStatuses", "Lcom/stripe/android/model/BankStatuses;", "viewModel", "Lcom/stripe/android/view/FpxViewModel;", "getViewModel", "()Lcom/stripe/android/view/FpxViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getItem", "Lcom/stripe/android/view/FpxBank;", "position", "onFpxBankStatusesUpdated", "", "updateStatuses", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddPaymentMethodFpxView.kt */
public final class AddPaymentMethodFpxView extends AddPaymentMethodView {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final AddPaymentMethodListAdapter fpxAdapter;
    private BankStatuses fpxBankStatuses;
    private final Lazy viewModel$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AddPaymentMethodFpxView(FragmentActivity fragmentActivity) {
        this(fragmentActivity, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AddPaymentMethodFpxView(FragmentActivity fragmentActivity, AttributeSet attributeSet) {
        this(fragmentActivity, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AddPaymentMethodFpxView(FragmentActivity fragmentActivity, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentActivity, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AddPaymentMethodFpxView(androidx.fragment.app.FragmentActivity r5, android.util.AttributeSet r6, int r7) {
        /*
            r4 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = r5
            android.content.Context r0 = (android.content.Context) r0
            r4.<init>(r0, r6, r7)
            com.stripe.android.model.BankStatuses r6 = new com.stripe.android.model.BankStatuses
            r7 = 0
            r1 = 1
            r6.<init>(r7, r1, r7)
            r4.fpxBankStatuses = r6
            com.stripe.android.view.AddPaymentMethodListAdapter r6 = new com.stripe.android.view.AddPaymentMethodListAdapter
            com.stripe.android.view.ThemeConfig r7 = new com.stripe.android.view.ThemeConfig
            r7.<init>(r0)
            com.stripe.android.view.FpxBank[] r2 = com.stripe.android.view.FpxBank.values()
            java.util.List r2 = kotlin.collections.ArraysKt.toList((T[]) r2)
            com.stripe.android.view.AddPaymentMethodFpxView$fpxAdapter$1 r3 = new com.stripe.android.view.AddPaymentMethodFpxView$fpxAdapter$1
            r3.<init>(r4)
            kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3
            r6.<init>(r7, r2, r3)
            r4.fpxAdapter = r6
            com.stripe.android.view.AddPaymentMethodFpxView$viewModel$2 r7 = new com.stripe.android.view.AddPaymentMethodFpxView$viewModel$2
            r7.<init>(r5)
            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
            kotlin.Lazy r7 = kotlin.LazyKt.lazy(r7)
            r4.viewModel$delegate = r7
            android.view.LayoutInflater r7 = r5.getLayoutInflater()
            r2 = r4
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            com.stripe.android.databinding.BankListPaymentMethodBinding r7 = com.stripe.android.databinding.BankListPaymentMethodBinding.inflate(r7, r2, r1)
            java.lang.String r2 = "inflate(\n            act…           true\n        )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)
            int r2 = com.stripe.android.R.id.stripe_payment_methods_add_fpx
            r4.setId(r2)
            com.stripe.android.view.FpxViewModel r2 = r4.getViewModel()
            androidx.lifecycle.LiveData r2 = r2.getFpxBankStatues$payments_core_release()
            androidx.lifecycle.LifecycleOwner r5 = (androidx.lifecycle.LifecycleOwner) r5
            com.stripe.android.view.-$$Lambda$AddPaymentMethodFpxView$tS-pBy2TQHFumnxuQcv2kNnsdsc r3 = new com.stripe.android.view.-$$Lambda$AddPaymentMethodFpxView$tS-pBy2TQHFumnxuQcv2kNnsdsc
            r3.<init>()
            r2.observe(r5, r3)
            androidx.recyclerview.widget.RecyclerView r5 = r7.bankList
            r7 = r6
            androidx.recyclerview.widget.RecyclerView$Adapter r7 = (androidx.recyclerview.widget.RecyclerView.Adapter) r7
            r5.setAdapter(r7)
            r5.setHasFixedSize(r1)
            androidx.recyclerview.widget.LinearLayoutManager r7 = new androidx.recyclerview.widget.LinearLayoutManager
            r7.<init>(r0)
            androidx.recyclerview.widget.RecyclerView$LayoutManager r7 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r7
            r5.setLayoutManager(r7)
            androidx.recyclerview.widget.DefaultItemAnimator r7 = new androidx.recyclerview.widget.DefaultItemAnimator
            r7.<init>()
            androidx.recyclerview.widget.RecyclerView$ItemAnimator r7 = (androidx.recyclerview.widget.RecyclerView.ItemAnimator) r7
            r5.setItemAnimator(r7)
            com.stripe.android.view.FpxViewModel r5 = r4.getViewModel()
            java.lang.Integer r5 = r5.getSelectedPosition$payments_core_release()
            if (r5 != 0) goto L_0x008d
            goto L_0x0096
        L_0x008d:
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            r6.updateSelected$payments_core_release(r5)
        L_0x0096:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.AddPaymentMethodFpxView.<init>(androidx.fragment.app.FragmentActivity, android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: private */
    public final FpxViewModel getViewModel() {
        return (FpxViewModel) this.viewModel$delegate.getValue();
    }

    public PaymentMethodCreateParams getCreateParams() {
        Integer valueOf = Integer.valueOf(this.fpxAdapter.getSelectedPosition());
        if (!(valueOf.intValue() != -1)) {
            valueOf = null;
        }
        if (valueOf == null) {
            return null;
        }
        return PaymentMethodCreateParams.Companion.create$default(PaymentMethodCreateParams.Companion, new PaymentMethodCreateParams.Fpx(FpxBank.values()[valueOf.intValue()].getCode()), (PaymentMethod.BillingDetails) null, (Map) null, 6, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void onFpxBankStatusesUpdated(BankStatuses bankStatuses) {
        if (bankStatuses != null) {
            updateStatuses(bankStatuses);
        }
    }

    private final void updateStatuses(BankStatuses bankStatuses) {
        this.fpxBankStatuses = bankStatuses;
        this.fpxAdapter.setBankStatuses$payments_core_release(bankStatuses);
        Collection arrayList = new ArrayList();
        for (Object next : ArraysKt.getIndices((T[]) FpxBank.values())) {
            if (!bankStatuses.isOnline$payments_core_release(getItem(((Number) next).intValue()))) {
                arrayList.add(next);
            }
        }
        for (Number intValue : (List) arrayList) {
            this.fpxAdapter.notifyAdapterItemChanged(intValue.intValue());
        }
    }

    private final FpxBank getItem(int i) {
        return FpxBank.values()[i];
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/view/AddPaymentMethodFpxView$Companion;", "", "()V", "create", "Lcom/stripe/android/view/AddPaymentMethodFpxView;", "activity", "Landroidx/fragment/app/FragmentActivity;", "create$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AddPaymentMethodFpxView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final /* synthetic */ AddPaymentMethodFpxView create$payments_core_release(FragmentActivity fragmentActivity) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
            return new AddPaymentMethodFpxView(fragmentActivity, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        }
    }
}
