package com.stripe.android.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.stripe.android.CustomerSession;
import com.stripe.android.PaymentSession;
import com.stripe.android.Stripe;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.view.AddPaymentMethodActivityStarter;
import com.stripe.android.view.i18n.ErrorMessageTranslator;
import com.stripe.android.view.i18n.TranslatorManager;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ,\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0000ø\u0001\u0000¢\u0006\u0002\b\u0013J$\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0000ø\u0001\u0000¢\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016H\u0001¢\u0006\u0002\b\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/view/AddPaymentMethodViewModel;", "Landroidx/lifecycle/ViewModel;", "stripe", "Lcom/stripe/android/Stripe;", "args", "Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Args;", "errorMessageTranslator", "Lcom/stripe/android/view/i18n/ErrorMessageTranslator;", "(Lcom/stripe/android/Stripe;Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Args;Lcom/stripe/android/view/i18n/ErrorMessageTranslator;)V", "productUsage", "", "", "attachPaymentMethod", "Landroidx/lifecycle/LiveData;", "Lkotlin/Result;", "Lcom/stripe/android/model/PaymentMethod;", "customerSession", "Lcom/stripe/android/CustomerSession;", "paymentMethod", "attachPaymentMethod$payments_core_release", "createPaymentMethod", "params", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "createPaymentMethod$payments_core_release", "updatedPaymentMethodCreateParams", "updatedPaymentMethodCreateParams$payments_core_release", "Factory", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddPaymentMethodViewModel.kt */
public final class AddPaymentMethodViewModel extends ViewModel {
    private final AddPaymentMethodActivityStarter.Args args;
    /* access modifiers changed from: private */
    public final ErrorMessageTranslator errorMessageTranslator;
    private final Set<String> productUsage;
    private final Stripe stripe;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AddPaymentMethodViewModel(Stripe stripe2, AddPaymentMethodActivityStarter.Args args2, ErrorMessageTranslator errorMessageTranslator2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(stripe2, args2, (i & 4) != 0 ? TranslatorManager.INSTANCE.getErrorMessageTranslator() : errorMessageTranslator2);
    }

    public AddPaymentMethodViewModel(Stripe stripe2, AddPaymentMethodActivityStarter.Args args2, ErrorMessageTranslator errorMessageTranslator2) {
        Intrinsics.checkNotNullParameter(stripe2, "stripe");
        Intrinsics.checkNotNullParameter(args2, "args");
        Intrinsics.checkNotNullParameter(errorMessageTranslator2, "errorMessageTranslator");
        this.stripe = stripe2;
        this.args = args2;
        this.errorMessageTranslator = errorMessageTranslator2;
        String[] strArr = new String[2];
        strArr[0] = AddPaymentMethodActivity.PRODUCT_TOKEN;
        strArr[1] = args2.isPaymentSessionActive$payments_core_release() ? PaymentSession.PRODUCT_TOKEN : null;
        this.productUsage = CollectionsKt.toSet(CollectionsKt.listOfNotNull((T[]) strArr));
    }

    public final LiveData<Result<PaymentMethod>> createPaymentMethod$payments_core_release(PaymentMethodCreateParams paymentMethodCreateParams) {
        Intrinsics.checkNotNullParameter(paymentMethodCreateParams, "params");
        MutableLiveData mutableLiveData = new MutableLiveData();
        Stripe.createPaymentMethod$default(this.stripe, updatedPaymentMethodCreateParams$payments_core_release(paymentMethodCreateParams), (String) null, (String) null, new AddPaymentMethodViewModel$createPaymentMethod$1(mutableLiveData), 6, (Object) null);
        return mutableLiveData;
    }

    public final PaymentMethodCreateParams updatedPaymentMethodCreateParams$payments_core_release(PaymentMethodCreateParams paymentMethodCreateParams) {
        Intrinsics.checkNotNullParameter(paymentMethodCreateParams, "params");
        return PaymentMethodCreateParams.copy$default(paymentMethodCreateParams, (PaymentMethod.Type) null, (PaymentMethodCreateParams.Card) null, (PaymentMethodCreateParams.Ideal) null, (PaymentMethodCreateParams.Fpx) null, (PaymentMethodCreateParams.SepaDebit) null, (PaymentMethodCreateParams.AuBecsDebit) null, (PaymentMethodCreateParams.BacsDebit) null, (PaymentMethodCreateParams.Sofort) null, (PaymentMethodCreateParams.Upi) null, (PaymentMethodCreateParams.Netbanking) null, (PaymentMethodCreateParams.USBankAccount) null, (PaymentMethodCreateParams.Link) null, (PaymentMethod.BillingDetails) null, (Map) null, this.productUsage, (Map) null, 49151, (Object) null);
    }

    public final /* synthetic */ LiveData attachPaymentMethod$payments_core_release(CustomerSession customerSession, PaymentMethod paymentMethod) {
        Intrinsics.checkNotNullParameter(customerSession, "customerSession");
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        MutableLiveData mutableLiveData = new MutableLiveData();
        String str = paymentMethod.id;
        if (str == null) {
            str = "";
        }
        customerSession.attachPaymentMethod$payments_core_release(str, this.productUsage, new AddPaymentMethodViewModel$attachPaymentMethod$1(mutableLiveData, this));
        return mutableLiveData;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/stripe/android/view/AddPaymentMethodViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "stripe", "Lcom/stripe/android/Stripe;", "args", "Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Args;", "(Lcom/stripe/android/Stripe;Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Args;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AddPaymentMethodViewModel.kt */
    public static final class Factory implements ViewModelProvider.Factory {
        private final AddPaymentMethodActivityStarter.Args args;
        private final Stripe stripe;

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return ViewModelProvider.Factory.CC.$default$create(this, cls, creationExtras);
        }

        public Factory(Stripe stripe2, AddPaymentMethodActivityStarter.Args args2) {
            Intrinsics.checkNotNullParameter(stripe2, "stripe");
            Intrinsics.checkNotNullParameter(args2, "args");
            this.stripe = stripe2;
            this.args = args2;
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            return (ViewModel) new AddPaymentMethodViewModel(this.stripe, this.args, (ErrorMessageTranslator) null, 4, (DefaultConstructorMarker) null);
        }
    }
}
