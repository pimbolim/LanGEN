package com.stripe.android;

import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.AbstractSavedStateViewModelFactory;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.savedstate.SavedStateRegistryOwner;
import com.nimbusds.jose.shaded.ow2asm.Opcodes;
import com.stripe.android.PaymentSessionPrefs;
import com.stripe.android.core.StripeError;
import com.stripe.android.model.Customer;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.ShippingInformation;
import com.stripe.android.model.ShippingMethod;
import com.stripe.android.view.PaymentMethodsActivityStarter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0000\u0018\u0000 <2\u00020\u0001:\u0004<=>?B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00122\b\b\u0002\u0010 \u001a\u00020!J7\u0010\"\u001a\u00020\u001d2\b\u0010#\u001a\u0004\u0018\u00010$2#\u0010%\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010'¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u001d0&H\u0002J\u0014\u0010+\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010$J\u0006\u0010-\u001a\u00020\u001dJ/\u0010.\u001a\u00020\u001d2\b\u0010/\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001d00H\u0000¢\u0006\u0002\b1J\u0006\u00102\u001a\u00020\u001dJ\u000e\u00103\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u00104\u001a\u00020\u001d2\b\u00105\u001a\u0004\u0018\u000106J\u001a\u00107\u001a\u00020\u001d2\b\u0010*\u001a\u0004\u0018\u00010'2\u0006\u00108\u001a\u00020!H\u0002J\u0010\u00109\u001a\u00020\u001d2\b\b\u0001\u0010:\u001a\u00020;R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/stripe/android/PaymentSessionViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "paymentSessionData", "Lcom/stripe/android/PaymentSessionData;", "customerSession", "Lcom/stripe/android/CustomerSession;", "paymentSessionPrefs", "Lcom/stripe/android/PaymentSessionPrefs;", "(Landroid/app/Application;Landroidx/lifecycle/SavedStateHandle;Lcom/stripe/android/PaymentSessionData;Lcom/stripe/android/CustomerSession;Lcom/stripe/android/PaymentSessionPrefs;)V", "_networkState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/stripe/android/PaymentSessionViewModel$NetworkState;", "_paymentSessionDataLiveData", "networkState", "Landroidx/lifecycle/LiveData;", "getNetworkState$payments_core_release", "()Landroidx/lifecycle/LiveData;", "value", "getPaymentSessionData", "()Lcom/stripe/android/PaymentSessionData;", "setPaymentSessionData", "(Lcom/stripe/android/PaymentSessionData;)V", "paymentSessionDataLiveData", "getPaymentSessionDataLiveData", "clearPaymentMethod", "", "fetchCustomer", "Lcom/stripe/android/PaymentSessionViewModel$FetchCustomerResult;", "isInitialFetch", "", "fetchCustomerPaymentMethod", "paymentMethodId", "", "onComplete", "Lkotlin/Function1;", "Lcom/stripe/android/model/PaymentMethod;", "Lkotlin/ParameterName;", "name", "paymentMethod", "getSelectedPaymentMethodId", "userSelectedPaymentMethodId", "onCompleted", "onCustomerRetrieved", "customerId", "Lkotlin/Function0;", "onCustomerRetrieved$payments_core_release", "onListenerAttached", "onPaymentFlowResult", "onPaymentMethodResult", "result", "Lcom/stripe/android/view/PaymentMethodsActivityStarter$Result;", "persistPaymentMethodResult", "useGooglePay", "updateCartTotal", "cartTotal", "", "Companion", "Factory", "FetchCustomerResult", "NetworkState", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSessionViewModel.kt */
public final class PaymentSessionViewModel extends AndroidViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_PAYMENT_SESSION_DATA = "key_payment_session_data";
    private static final int MAX_PAYMENT_METHODS_LIMIT = 100;
    /* access modifiers changed from: private */
    public final MutableLiveData<NetworkState> _networkState;
    private final MutableLiveData<PaymentSessionData> _paymentSessionDataLiveData;
    private final CustomerSession customerSession;
    private final LiveData<NetworkState> networkState;
    private PaymentSessionData paymentSessionData;
    private final LiveData<PaymentSessionData> paymentSessionDataLiveData;
    private final PaymentSessionPrefs paymentSessionPrefs;
    private final SavedStateHandle savedStateHandle;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/PaymentSessionViewModel$NetworkState;", "", "(Ljava/lang/String;I)V", "Active", "Inactive", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSessionViewModel.kt */
    public enum NetworkState {
        Active,
        Inactive
    }

    public final /* synthetic */ void onCompleted() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentSessionViewModel(Application application, SavedStateHandle savedStateHandle2, PaymentSessionData paymentSessionData2, CustomerSession customerSession2, PaymentSessionPrefs paymentSessionPrefs2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, savedStateHandle2, paymentSessionData2, customerSession2, (i & 16) != 0 ? new PaymentSessionPrefs.Default(application) : paymentSessionPrefs2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentSessionViewModel(Application application, SavedStateHandle savedStateHandle2, PaymentSessionData paymentSessionData2, CustomerSession customerSession2, PaymentSessionPrefs paymentSessionPrefs2) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(savedStateHandle2, "savedStateHandle");
        Intrinsics.checkNotNullParameter(paymentSessionData2, "paymentSessionData");
        Intrinsics.checkNotNullParameter(customerSession2, "customerSession");
        Intrinsics.checkNotNullParameter(paymentSessionPrefs2, "paymentSessionPrefs");
        this.savedStateHandle = savedStateHandle2;
        this.customerSession = customerSession2;
        this.paymentSessionPrefs = paymentSessionPrefs2;
        this.paymentSessionData = paymentSessionData2;
        MutableLiveData<PaymentSessionData> mutableLiveData = new MutableLiveData<>();
        this._paymentSessionDataLiveData = mutableLiveData;
        this.paymentSessionDataLiveData = mutableLiveData;
        PaymentSessionData paymentSessionData3 = (PaymentSessionData) savedStateHandle2.get(KEY_PAYMENT_SESSION_DATA);
        if (paymentSessionData3 != null) {
            setPaymentSessionData(paymentSessionData3);
        }
        MutableLiveData<NetworkState> mutableLiveData2 = new MutableLiveData<>();
        this._networkState = mutableLiveData2;
        this.networkState = mutableLiveData2;
    }

    public final PaymentSessionData getPaymentSessionData() {
        return this.paymentSessionData;
    }

    public final void setPaymentSessionData(PaymentSessionData paymentSessionData2) {
        Intrinsics.checkNotNullParameter(paymentSessionData2, "value");
        if (!Intrinsics.areEqual((Object) paymentSessionData2, (Object) this.paymentSessionData)) {
            this.paymentSessionData = paymentSessionData2;
            this.savedStateHandle.set(KEY_PAYMENT_SESSION_DATA, paymentSessionData2);
            this._paymentSessionDataLiveData.setValue(paymentSessionData2);
        }
    }

    public final LiveData<PaymentSessionData> getPaymentSessionDataLiveData() {
        return this.paymentSessionDataLiveData;
    }

    public final LiveData<NetworkState> getNetworkState$payments_core_release() {
        return this.networkState;
    }

    public final /* synthetic */ void updateCartTotal(long j) {
        setPaymentSessionData(PaymentSessionData.copy$default(this.paymentSessionData, false, false, j, 0, (ShippingInformation) null, (ShippingMethod) null, (PaymentMethod) null, false, 251, (Object) null));
    }

    public final void clearPaymentMethod() {
        setPaymentSessionData(PaymentSessionData.copy$default(this.paymentSessionData, false, false, 0, 0, (ShippingInformation) null, (ShippingMethod) null, (PaymentMethod) null, false, Opcodes.ATHROW, (Object) null));
    }

    public static /* synthetic */ LiveData fetchCustomer$default(PaymentSessionViewModel paymentSessionViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return paymentSessionViewModel.fetchCustomer(z);
    }

    public final /* synthetic */ LiveData fetchCustomer(boolean z) {
        this._networkState.setValue(NetworkState.Active);
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.customerSession.retrieveCurrentCustomer$payments_core_release(SetsKt.setOf(PaymentSession.PRODUCT_TOKEN), new PaymentSessionViewModel$fetchCustomer$1(this, z, mutableLiveData));
        return mutableLiveData;
    }

    public static /* synthetic */ void onCustomerRetrieved$payments_core_release$default(PaymentSessionViewModel paymentSessionViewModel, String str, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        paymentSessionViewModel.onCustomerRetrieved$payments_core_release(str, z, function0);
    }

    public final /* synthetic */ void onCustomerRetrieved$payments_core_release(String str, boolean z, Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "onComplete");
        if (z) {
            fetchCustomerPaymentMethod(this.paymentSessionPrefs.getPaymentMethodId(str), new PaymentSessionViewModel$onCustomerRetrieved$1(function0, this));
        } else {
            function0.invoke();
        }
    }

    private final void fetchCustomerPaymentMethod(String str, Function1<? super PaymentMethod, Unit> function1) {
        if (str != null) {
            CustomerSession.getPaymentMethods$default(this.customerSession, PaymentMethod.Type.Card, 100, (String) null, (String) null, new PaymentSessionViewModel$fetchCustomerPaymentMethod$1(function1, str), 12, (Object) null);
        } else {
            function1.invoke(null);
        }
    }

    public static /* synthetic */ String getSelectedPaymentMethodId$default(PaymentSessionViewModel paymentSessionViewModel, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return paymentSessionViewModel.getSelectedPaymentMethodId(str);
    }

    public final /* synthetic */ String getSelectedPaymentMethodId(String str) {
        String id;
        if (this.paymentSessionData.getUseGooglePay()) {
            return null;
        }
        if (str != null) {
            return str;
        }
        if (this.paymentSessionData.getPaymentMethod() != null) {
            PaymentMethod paymentMethod = this.paymentSessionData.getPaymentMethod();
            if (paymentMethod != null) {
                return paymentMethod.id;
            }
        } else {
            Customer cachedCustomer = this.customerSession.getCachedCustomer();
            if (!(cachedCustomer == null || (id = cachedCustomer.getId()) == null)) {
                return this.paymentSessionPrefs.getPaymentMethodId(id);
            }
        }
        return null;
    }

    public final /* synthetic */ void onPaymentMethodResult(PaymentMethodsActivityStarter.Result result) {
        boolean z;
        PaymentMethod paymentMethod = result == null ? null : result.paymentMethod;
        if (result == null) {
            z = false;
        } else {
            z = result.getUseGooglePay();
        }
        persistPaymentMethodResult(paymentMethod, z);
    }

    private final void persistPaymentMethodResult(PaymentMethod paymentMethod, boolean z) {
        String id;
        PaymentMethod paymentMethod2 = paymentMethod;
        Customer cachedCustomer = this.customerSession.getCachedCustomer();
        if (!(cachedCustomer == null || (id = cachedCustomer.getId()) == null)) {
            this.paymentSessionPrefs.savePaymentMethodId(id, paymentMethod2 == null ? null : paymentMethod2.id);
        }
        setPaymentSessionData(PaymentSessionData.copy$default(this.paymentSessionData, false, false, 0, 0, (ShippingInformation) null, (ShippingMethod) null, paymentMethod, z, 63, (Object) null));
    }

    public final /* synthetic */ void onPaymentFlowResult(PaymentSessionData paymentSessionData2) {
        Intrinsics.checkNotNullParameter(paymentSessionData2, "paymentSessionData");
        setPaymentSessionData(paymentSessionData2);
    }

    public final /* synthetic */ void onListenerAttached() {
        this._paymentSessionDataLiveData.setValue(this.paymentSessionData);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/PaymentSessionViewModel$FetchCustomerResult;", "", "()V", "Error", "Success", "Lcom/stripe/android/PaymentSessionViewModel$FetchCustomerResult$Success;", "Lcom/stripe/android/PaymentSessionViewModel$FetchCustomerResult$Error;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSessionViewModel.kt */
    public static abstract class FetchCustomerResult {
        public static final int $stable = 0;

        public /* synthetic */ FetchCustomerResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/stripe/android/PaymentSessionViewModel$FetchCustomerResult$Success;", "Lcom/stripe/android/PaymentSessionViewModel$FetchCustomerResult;", "()V", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSessionViewModel.kt */
        public static final class Success extends FetchCustomerResult {
            public static final int $stable = 0;
            public static final Success INSTANCE = new Success();

            private Success() {
                super((DefaultConstructorMarker) null);
            }
        }

        private FetchCustomerResult() {
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/stripe/android/PaymentSessionViewModel$FetchCustomerResult$Error;", "Lcom/stripe/android/PaymentSessionViewModel$FetchCustomerResult;", "errorCode", "", "errorMessage", "", "stripeError", "Lcom/stripe/android/core/StripeError;", "(ILjava/lang/String;Lcom/stripe/android/core/StripeError;)V", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "getStripeError", "()Lcom/stripe/android/core/StripeError;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: PaymentSessionViewModel.kt */
        public static final class Error extends FetchCustomerResult {
            public static final int $stable = StripeError.$stable;
            private final int errorCode;
            private final String errorMessage;
            private final StripeError stripeError;

            public static /* synthetic */ Error copy$default(Error error, int i, String str, StripeError stripeError2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = error.errorCode;
                }
                if ((i2 & 2) != 0) {
                    str = error.errorMessage;
                }
                if ((i2 & 4) != 0) {
                    stripeError2 = error.stripeError;
                }
                return error.copy(i, str, stripeError2);
            }

            public final int component1() {
                return this.errorCode;
            }

            public final String component2() {
                return this.errorMessage;
            }

            public final StripeError component3() {
                return this.stripeError;
            }

            public final Error copy(int i, String str, StripeError stripeError2) {
                Intrinsics.checkNotNullParameter(str, "errorMessage");
                return new Error(i, str, stripeError2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Error)) {
                    return false;
                }
                Error error = (Error) obj;
                return this.errorCode == error.errorCode && Intrinsics.areEqual((Object) this.errorMessage, (Object) error.errorMessage) && Intrinsics.areEqual((Object) this.stripeError, (Object) error.stripeError);
            }

            public int hashCode() {
                int hashCode = ((this.errorCode * 31) + this.errorMessage.hashCode()) * 31;
                StripeError stripeError2 = this.stripeError;
                return hashCode + (stripeError2 == null ? 0 : stripeError2.hashCode());
            }

            public String toString() {
                return "Error(errorCode=" + this.errorCode + ", errorMessage=" + this.errorMessage + ", stripeError=" + this.stripeError + ')';
            }

            public final int getErrorCode() {
                return this.errorCode;
            }

            public final String getErrorMessage() {
                return this.errorMessage;
            }

            public final StripeError getStripeError() {
                return this.stripeError;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(int i, String str, StripeError stripeError2) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "errorMessage");
                this.errorCode = i;
                this.errorMessage = str;
                this.stripeError = stripeError2;
            }
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ7\u0010\u000b\u001a\u0002H\f\"\n\b\u0000\u0010\f*\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\f0\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/stripe/android/PaymentSessionViewModel$Factory;", "Landroidx/lifecycle/AbstractSavedStateViewModelFactory;", "application", "Landroid/app/Application;", "owner", "Landroidx/savedstate/SavedStateRegistryOwner;", "paymentSessionData", "Lcom/stripe/android/PaymentSessionData;", "customerSession", "Lcom/stripe/android/CustomerSession;", "(Landroid/app/Application;Landroidx/savedstate/SavedStateRegistryOwner;Lcom/stripe/android/PaymentSessionData;Lcom/stripe/android/CustomerSession;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "key", "", "modelClass", "Ljava/lang/Class;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "(Ljava/lang/String;Ljava/lang/Class;Landroidx/lifecycle/SavedStateHandle;)Landroidx/lifecycle/ViewModel;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSessionViewModel.kt */
    public static final class Factory extends AbstractSavedStateViewModelFactory {
        private final Application application;
        private final CustomerSession customerSession;
        private final PaymentSessionData paymentSessionData;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Factory(Application application2, SavedStateRegistryOwner savedStateRegistryOwner, PaymentSessionData paymentSessionData2, CustomerSession customerSession2) {
            super(savedStateRegistryOwner, (Bundle) null);
            Intrinsics.checkNotNullParameter(application2, "application");
            Intrinsics.checkNotNullParameter(savedStateRegistryOwner, "owner");
            Intrinsics.checkNotNullParameter(paymentSessionData2, "paymentSessionData");
            Intrinsics.checkNotNullParameter(customerSession2, "customerSession");
            this.application = application2;
            this.paymentSessionData = paymentSessionData2;
            this.customerSession = customerSession2;
        }

        /* access modifiers changed from: protected */
        public <T extends ViewModel> T create(String str, Class<T> cls, SavedStateHandle savedStateHandle) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            Intrinsics.checkNotNullParameter(savedStateHandle, "handle");
            return (ViewModel) new PaymentSessionViewModel(this.application, savedStateHandle, this.paymentSessionData, this.customerSession, (PaymentSessionPrefs) null, 16, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/PaymentSessionViewModel$Companion;", "", "()V", "KEY_PAYMENT_SESSION_DATA", "", "MAX_PAYMENT_METHODS_LIMIT", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSessionViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
