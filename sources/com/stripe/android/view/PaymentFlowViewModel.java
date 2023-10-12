package com.stripe.android.view;

import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.stripe.android.CustomerSession;
import com.stripe.android.PaymentSession;
import com.stripe.android.PaymentSessionConfig;
import com.stripe.android.PaymentSessionData;
import com.stripe.android.model.ShippingInformation;
import com.stripe.android.model.ShippingMethod;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 72\u00020\u0001:\u000278B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0-0,2\u0006\u0010/\u001a\u00020&H\u0000ø\u0001\u0000¢\u0006\u0002\b0J<\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0 0-0,2\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\u0006\u0010/\u001a\u00020&H\u0000ø\u0001\u0000¢\u0006\u0002\b6R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00069"}, d2 = {"Lcom/stripe/android/view/PaymentFlowViewModel;", "Landroidx/lifecycle/ViewModel;", "customerSession", "Lcom/stripe/android/CustomerSession;", "paymentSessionData", "Lcom/stripe/android/PaymentSessionData;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/stripe/android/CustomerSession;Lcom/stripe/android/PaymentSessionData;Lkotlin/coroutines/CoroutineContext;)V", "currentPage", "", "getCurrentPage$payments_core_release", "()I", "setCurrentPage$payments_core_release", "(I)V", "isShippingInfoSubmitted", "", "isShippingInfoSubmitted$payments_core_release", "()Z", "setShippingInfoSubmitted$payments_core_release", "(Z)V", "getPaymentSessionData$payments_core_release", "()Lcom/stripe/android/PaymentSessionData;", "setPaymentSessionData$payments_core_release", "(Lcom/stripe/android/PaymentSessionData;)V", "selectedShippingMethod", "Lcom/stripe/android/model/ShippingMethod;", "getSelectedShippingMethod$payments_core_release", "()Lcom/stripe/android/model/ShippingMethod;", "setSelectedShippingMethod$payments_core_release", "(Lcom/stripe/android/model/ShippingMethod;)V", "shippingMethods", "", "getShippingMethods$payments_core_release", "()Ljava/util/List;", "setShippingMethods$payments_core_release", "(Ljava/util/List;)V", "submittedShippingInfo", "Lcom/stripe/android/model/ShippingInformation;", "getSubmittedShippingInfo$payments_core_release", "()Lcom/stripe/android/model/ShippingInformation;", "setSubmittedShippingInfo$payments_core_release", "(Lcom/stripe/android/model/ShippingInformation;)V", "saveCustomerShippingInformation", "Landroidx/lifecycle/LiveData;", "Lkotlin/Result;", "Lcom/stripe/android/model/Customer;", "shippingInformation", "saveCustomerShippingInformation$payments_core_release", "validateShippingInformation", "shippingInfoValidator", "Lcom/stripe/android/PaymentSessionConfig$ShippingInformationValidator;", "shippingMethodsFactory", "Lcom/stripe/android/PaymentSessionConfig$ShippingMethodsFactory;", "validateShippingInformation$payments_core_release", "Companion", "Factory", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentFlowViewModel.kt */
public final class PaymentFlowViewModel extends ViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Set<String> PRODUCT_USAGE = SetsKt.setOf(PaymentSession.PRODUCT_TOKEN, PaymentFlowActivity.PRODUCT_TOKEN, SHIPPING_INFO_PRODUCT_TOKEN);
    private static final String SHIPPING_INFO_PRODUCT_TOKEN = "ShippingInfoScreen";
    private int currentPage;
    private final CustomerSession customerSession;
    private boolean isShippingInfoSubmitted;
    private PaymentSessionData paymentSessionData;
    private ShippingMethod selectedShippingMethod;
    private List<ShippingMethod> shippingMethods = CollectionsKt.emptyList();
    private ShippingInformation submittedShippingInfo;
    /* access modifiers changed from: private */
    public final CoroutineContext workContext;

    public final PaymentSessionData getPaymentSessionData$payments_core_release() {
        return this.paymentSessionData;
    }

    public final void setPaymentSessionData$payments_core_release(PaymentSessionData paymentSessionData2) {
        Intrinsics.checkNotNullParameter(paymentSessionData2, "<set-?>");
        this.paymentSessionData = paymentSessionData2;
    }

    public PaymentFlowViewModel(CustomerSession customerSession2, PaymentSessionData paymentSessionData2, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(customerSession2, "customerSession");
        Intrinsics.checkNotNullParameter(paymentSessionData2, "paymentSessionData");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        this.customerSession = customerSession2;
        this.paymentSessionData = paymentSessionData2;
        this.workContext = coroutineContext;
    }

    public final List<ShippingMethod> getShippingMethods$payments_core_release() {
        return this.shippingMethods;
    }

    public final void setShippingMethods$payments_core_release(List<ShippingMethod> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.shippingMethods = list;
    }

    public final boolean isShippingInfoSubmitted$payments_core_release() {
        return this.isShippingInfoSubmitted;
    }

    public final void setShippingInfoSubmitted$payments_core_release(boolean z) {
        this.isShippingInfoSubmitted = z;
    }

    public final ShippingMethod getSelectedShippingMethod$payments_core_release() {
        return this.selectedShippingMethod;
    }

    public final void setSelectedShippingMethod$payments_core_release(ShippingMethod shippingMethod) {
        this.selectedShippingMethod = shippingMethod;
    }

    public final ShippingInformation getSubmittedShippingInfo$payments_core_release() {
        return this.submittedShippingInfo;
    }

    public final void setSubmittedShippingInfo$payments_core_release(ShippingInformation shippingInformation) {
        this.submittedShippingInfo = shippingInformation;
    }

    public final int getCurrentPage$payments_core_release() {
        return this.currentPage;
    }

    public final void setCurrentPage$payments_core_release(int i) {
        this.currentPage = i;
    }

    public final /* synthetic */ LiveData saveCustomerShippingInformation$payments_core_release(ShippingInformation shippingInformation) {
        Intrinsics.checkNotNullParameter(shippingInformation, "shippingInformation");
        this.submittedShippingInfo = shippingInformation;
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.customerSession.setCustomerShippingInformation$payments_core_release(shippingInformation, PRODUCT_USAGE, new PaymentFlowViewModel$saveCustomerShippingInformation$1(this, mutableLiveData));
        return mutableLiveData;
    }

    public final /* synthetic */ LiveData validateShippingInformation$payments_core_release(PaymentSessionConfig.ShippingInformationValidator shippingInformationValidator, PaymentSessionConfig.ShippingMethodsFactory shippingMethodsFactory, ShippingInformation shippingInformation) {
        Intrinsics.checkNotNullParameter(shippingInformationValidator, "shippingInfoValidator");
        ShippingInformation shippingInformation2 = shippingInformation;
        Intrinsics.checkNotNullParameter(shippingInformation2, "shippingInformation");
        return CoroutineLiveDataKt.liveData$default((CoroutineContext) null, 0, (Function2) new PaymentFlowViewModel$validateShippingInformation$1(this, shippingInformationValidator, shippingInformation2, shippingMethodsFactory, (Continuation<? super PaymentFlowViewModel$validateShippingInformation$1>) null), 3, (Object) null);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stripe/android/view/PaymentFlowViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "customerSession", "Lcom/stripe/android/CustomerSession;", "paymentSessionData", "Lcom/stripe/android/PaymentSessionData;", "(Lcom/stripe/android/CustomerSession;Lcom/stripe/android/PaymentSessionData;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentFlowViewModel.kt */
    public static final class Factory implements ViewModelProvider.Factory {
        private final CustomerSession customerSession;
        private final PaymentSessionData paymentSessionData;

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return ViewModelProvider.Factory.CC.$default$create(this, cls, creationExtras);
        }

        public Factory(CustomerSession customerSession2, PaymentSessionData paymentSessionData2) {
            Intrinsics.checkNotNullParameter(customerSession2, "customerSession");
            Intrinsics.checkNotNullParameter(paymentSessionData2, "paymentSessionData");
            this.customerSession = customerSession2;
            this.paymentSessionData = paymentSessionData2;
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            return (ViewModel) new PaymentFlowViewModel(this.customerSession, this.paymentSessionData, Dispatchers.getIO());
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/view/PaymentFlowViewModel$Companion;", "", "()V", "PRODUCT_USAGE", "", "", "getPRODUCT_USAGE", "()Ljava/util/Set;", "SHIPPING_INFO_PRODUCT_TOKEN", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentFlowViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<String> getPRODUCT_USAGE() {
            return PaymentFlowViewModel.PRODUCT_USAGE;
        }
    }
}
