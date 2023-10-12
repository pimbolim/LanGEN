package com.stripe.android.view;

import android.app.Application;
import android.content.res.Resources;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.stripe.android.CustomerSession;
import com.stripe.android.PaymentSession;
import com.stripe.android.R;
import com.stripe.android.model.PaymentMethod;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001:\u0001.B2\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001c\u0010 \u001a\u0004\u0018\u00010\b2\u0006\u0010!\u001a\u00020\"2\b\b\u0001\u0010#\u001a\u00020$H\u0002J\"\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0'0\u00050&H\u0000ø\u0001\u0000¢\u0006\u0002\b(J\u0015\u0010)\u001a\u00020*2\u0006\u0010!\u001a\u00020\"H\u0000¢\u0006\u0002\b+J\u0015\u0010,\u001a\u00020*2\u0006\u0010!\u001a\u00020\"H\u0000¢\u0006\u0002\b-R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\n \u0019*\u0004\u0018\u00010\u00180\u0018X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006/"}, d2 = {"Lcom/stripe/android/view/PaymentMethodsViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "customerSession", "Lkotlin/Result;", "Lcom/stripe/android/CustomerSession;", "selectedPaymentMethodId", "", "startedFromPaymentSession", "", "(Landroid/app/Application;Ljava/lang/Object;Ljava/lang/String;Z)V", "cardDisplayTextFactory", "Lcom/stripe/android/view/CardDisplayTextFactory;", "Ljava/lang/Object;", "productUsage", "", "getProductUsage$payments_core_release", "()Ljava/util/Set;", "progressData", "Landroidx/lifecycle/MutableLiveData;", "getProgressData$payments_core_release", "()Landroidx/lifecycle/MutableLiveData;", "resources", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "getSelectedPaymentMethodId$payments_core_release", "()Ljava/lang/String;", "setSelectedPaymentMethodId$payments_core_release", "(Ljava/lang/String;)V", "snackbarData", "getSnackbarData$payments_core_release", "createSnackbarText", "paymentMethod", "Lcom/stripe/android/model/PaymentMethod;", "stringRes", "", "getPaymentMethods", "Landroidx/lifecycle/LiveData;", "", "getPaymentMethods$payments_core_release", "onPaymentMethodAdded", "", "onPaymentMethodAdded$payments_core_release", "onPaymentMethodRemoved", "onPaymentMethodRemoved$payments_core_release", "Factory", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodsViewModel.kt */
public final class PaymentMethodsViewModel extends AndroidViewModel {
    private final CardDisplayTextFactory cardDisplayTextFactory;
    private final Object customerSession;
    private final Set<String> productUsage;
    private final MutableLiveData<Boolean> progressData;
    private final Resources resources;
    private String selectedPaymentMethodId;
    private final MutableLiveData<String> snackbarData;
    private final boolean startedFromPaymentSession;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentMethodsViewModel(Application application, Object obj, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, obj, (i & 4) != 0 ? null : str, z);
    }

    public final String getSelectedPaymentMethodId$payments_core_release() {
        return this.selectedPaymentMethodId;
    }

    public final void setSelectedPaymentMethodId$payments_core_release(String str) {
        this.selectedPaymentMethodId = str;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PaymentMethodsViewModel(Application application, Object obj, String str, boolean z) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.customerSession = obj;
        this.selectedPaymentMethodId = str;
        this.startedFromPaymentSession = z;
        this.resources = application.getResources();
        this.cardDisplayTextFactory = new CardDisplayTextFactory(application);
        String[] strArr = new String[2];
        strArr[0] = z ? PaymentSession.PRODUCT_TOKEN : null;
        strArr[1] = PaymentMethodsActivity.PRODUCT_TOKEN;
        this.productUsage = CollectionsKt.toSet(CollectionsKt.listOfNotNull((T[]) strArr));
        this.snackbarData = new MutableLiveData<>();
        this.progressData = new MutableLiveData<>();
    }

    public final Set<String> getProductUsage$payments_core_release() {
        return this.productUsage;
    }

    public final MutableLiveData<String> getSnackbarData$payments_core_release() {
        return this.snackbarData;
    }

    public final MutableLiveData<Boolean> getProgressData$payments_core_release() {
        return this.progressData;
    }

    public final void onPaymentMethodAdded$payments_core_release(PaymentMethod paymentMethod) {
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        String createSnackbarText = createSnackbarText(paymentMethod, R.string.added);
        if (createSnackbarText != null) {
            getSnackbarData$payments_core_release().setValue(createSnackbarText);
            getSnackbarData$payments_core_release().setValue(null);
        }
    }

    public final void onPaymentMethodRemoved$payments_core_release(PaymentMethod paymentMethod) {
        Intrinsics.checkNotNullParameter(paymentMethod, "paymentMethod");
        String createSnackbarText = createSnackbarText(paymentMethod, R.string.removed);
        if (createSnackbarText != null) {
            getSnackbarData$payments_core_release().setValue(createSnackbarText);
            getSnackbarData$payments_core_release().setValue(null);
        }
    }

    private final String createSnackbarText(PaymentMethod paymentMethod, int i) {
        PaymentMethod.Card card = paymentMethod.card;
        if (card == null) {
            return null;
        }
        return this.resources.getString(i, new Object[]{this.cardDisplayTextFactory.createUnstyled$payments_core_release(card)});
    }

    public final /* synthetic */ LiveData getPaymentMethods$payments_core_release() {
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.progressData.setValue(true);
        Object obj = this.customerSession;
        Throwable r2 = Result.m4712exceptionOrNullimpl(obj);
        if (r2 == null) {
            CustomerSession.getPaymentMethods$payments_core_release$default((CustomerSession) obj, PaymentMethod.Type.Card, (Integer) null, (String) null, (String) null, getProductUsage$payments_core_release(), new PaymentMethodsViewModel$getPaymentMethods$1$1(mutableLiveData, this), 14, (Object) null);
        } else {
            Result.Companion companion = Result.Companion;
            mutableLiveData.setValue(Result.m4708boximpl(Result.m4709constructorimpl(ResultKt.createFailure(r2))));
            getProgressData$payments_core_release().setValue(false);
        }
        return mutableLiveData;
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B0\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0002\u0010\u000bJ%\u0010\r\u001a\u0002H\u000e\"\b\b\u0000\u0010\u000e*\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0011H\u0016¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/view/PaymentMethodsViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "application", "Landroid/app/Application;", "customerSession", "Lkotlin/Result;", "Lcom/stripe/android/CustomerSession;", "initialPaymentMethodId", "", "startedFromPaymentSession", "", "(Landroid/app/Application;Ljava/lang/Object;Ljava/lang/String;Z)V", "Ljava/lang/Object;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodsViewModel.kt */
    public static final class Factory implements ViewModelProvider.Factory {
        private final Application application;
        private final Object customerSession;
        private final String initialPaymentMethodId;
        private final boolean startedFromPaymentSession;

        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return ViewModelProvider.Factory.CC.$default$create(this, cls, creationExtras);
        }

        public Factory(Application application2, Object obj, String str, boolean z) {
            Intrinsics.checkNotNullParameter(application2, "application");
            this.application = application2;
            this.customerSession = obj;
            this.initialPaymentMethodId = str;
            this.startedFromPaymentSession = z;
        }

        public <T extends ViewModel> T create(Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "modelClass");
            return (ViewModel) new PaymentMethodsViewModel(this.application, this.customerSession, this.initialPaymentMethodId, this.startedFromPaymentSession);
        }
    }
}
