package com.stripe.android.model;

import com.stripe.android.core.model.StripeModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0001\u0003\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/model/CustomerPaymentSource;", "Lcom/stripe/android/core/model/StripeModel;", "()V", "id", "", "getId", "()Ljava/lang/String;", "tokenizationMethod", "Lcom/stripe/android/model/TokenizationMethod;", "getTokenizationMethod", "()Lcom/stripe/android/model/TokenizationMethod;", "Lcom/stripe/android/model/CustomerCard;", "Lcom/stripe/android/model/CustomerBankAccount;", "Lcom/stripe/android/model/CustomerSource;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomerSource.kt */
public abstract class CustomerPaymentSource implements StripeModel {
    public static final int $stable = 0;

    public /* synthetic */ CustomerPaymentSource(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract String getId();

    public abstract TokenizationMethod getTokenizationMethod();

    private CustomerPaymentSource() {
    }
}
