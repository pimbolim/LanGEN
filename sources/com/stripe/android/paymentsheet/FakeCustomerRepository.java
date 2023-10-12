package com.stripe.android.paymentsheet;

import com.stripe.android.model.PaymentMethod;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.repositories.CustomerRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J#\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J-\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/paymentsheet/FakeCustomerRepository;", "Lcom/stripe/android/paymentsheet/repositories/CustomerRepository;", "paymentMethods", "", "Lcom/stripe/android/model/PaymentMethod;", "(Ljava/util/List;)V", "error", "", "getError", "()Ljava/lang/Throwable;", "setError", "(Ljava/lang/Throwable;)V", "savedPaymentMethod", "getSavedPaymentMethod", "()Lcom/stripe/android/model/PaymentMethod;", "setSavedPaymentMethod", "(Lcom/stripe/android/model/PaymentMethod;)V", "detachPaymentMethod", "customerConfig", "Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;", "paymentMethodId", "", "(Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPaymentMethods", "types", "Lcom/stripe/android/model/PaymentMethod$Type;", "(Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FakeCustomerRepository.kt */
public final class FakeCustomerRepository implements CustomerRepository {
    private Throwable error;
    private final List<PaymentMethod> paymentMethods;
    public PaymentMethod savedPaymentMethod;

    public FakeCustomerRepository() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public Object detachPaymentMethod(PaymentSheet.CustomerConfiguration customerConfiguration, String str, Continuation<? super PaymentMethod> continuation) {
        return null;
    }

    public FakeCustomerRepository(List<PaymentMethod> list) {
        Intrinsics.checkNotNullParameter(list, "paymentMethods");
        this.paymentMethods = list;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FakeCustomerRepository(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final PaymentMethod getSavedPaymentMethod() {
        PaymentMethod paymentMethod = this.savedPaymentMethod;
        if (paymentMethod != null) {
            return paymentMethod;
        }
        Intrinsics.throwUninitializedPropertyAccessException("savedPaymentMethod");
        return null;
    }

    public final void setSavedPaymentMethod(PaymentMethod paymentMethod) {
        Intrinsics.checkNotNullParameter(paymentMethod, "<set-?>");
        this.savedPaymentMethod = paymentMethod;
    }

    public final Throwable getError() {
        return this.error;
    }

    public final void setError(Throwable th) {
        this.error = th;
    }

    public Object getPaymentMethods(PaymentSheet.CustomerConfiguration customerConfiguration, List<? extends PaymentMethod.Type> list, Continuation<? super List<PaymentMethod>> continuation) {
        return this.paymentMethods;
    }
}
