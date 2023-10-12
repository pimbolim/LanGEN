package com.stripe.android.paymentsheet.flowcontroller;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.stripe.android.paymentsheet.model.PaymentSelection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/paymentsheet/flowcontroller/FlowControllerViewModel;", "Landroidx/lifecycle/ViewModel;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Landroidx/lifecycle/SavedStateHandle;)V", "value", "Lcom/stripe/android/paymentsheet/flowcontroller/InitData;", "initData", "getInitData", "()Lcom/stripe/android/paymentsheet/flowcontroller/InitData;", "setInitData", "(Lcom/stripe/android/paymentsheet/flowcontroller/InitData;)V", "paymentSelection", "Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "getPaymentSelection", "()Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "setPaymentSelection", "(Lcom/stripe/android/paymentsheet/model/PaymentSelection;)V", "Companion", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowControllerViewModel.kt */
public final class FlowControllerViewModel extends ViewModel {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String INIT_DATA_KEY = "init_data";
    private final SavedStateHandle handle;
    private PaymentSelection paymentSelection;

    public FlowControllerViewModel(SavedStateHandle savedStateHandle) {
        Intrinsics.checkNotNullParameter(savedStateHandle, "handle");
        this.handle = savedStateHandle;
    }

    public final PaymentSelection getPaymentSelection() {
        return this.paymentSelection;
    }

    public final void setPaymentSelection(PaymentSelection paymentSelection2) {
        this.paymentSelection = paymentSelection2;
    }

    public final InitData getInitData() {
        Object obj = this.handle.get(INIT_DATA_KEY);
        if (obj != null) {
            return (InitData) obj;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void setInitData(InitData initData) {
        Intrinsics.checkNotNullParameter(initData, "value");
        this.handle.set(INIT_DATA_KEY, initData);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/paymentsheet/flowcontroller/FlowControllerViewModel$Companion;", "", "()V", "INIT_DATA_KEY", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FlowControllerViewModel.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
