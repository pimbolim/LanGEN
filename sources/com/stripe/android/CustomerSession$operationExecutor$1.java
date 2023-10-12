package com.stripe.android;

import com.stripe.android.model.Customer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "customer", "Lcom/stripe/android/model/Customer;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomerSession.kt */
final class CustomerSession$operationExecutor$1 extends Lambda implements Function1<Customer, Unit> {
    final /* synthetic */ CustomerSession this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerSession$operationExecutor$1(CustomerSession customerSession) {
        super(1);
        this.this$0 = customerSession;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Customer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Customer customer) {
        Intrinsics.checkNotNullParameter(customer, "customer");
        this.this$0.setCustomer$payments_core_release(customer);
        CustomerSession customerSession = this.this$0;
        customerSession.setCustomerCacheTime$payments_core_release(((Number) customerSession.timeSupplier.invoke()).longValue());
    }
}
