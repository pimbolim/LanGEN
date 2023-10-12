package com.stripe.android.paymentsheet.model;

import com.stripe.android.paymentsheet.model.SupportedPaymentMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/stripe/android/paymentsheet/model/SupportedPaymentMethod;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: SupportedPaymentMethod.kt */
final class SupportedPaymentMethod$Companion$exposedPaymentMethods$2 extends Lambda implements Function0<List<? extends SupportedPaymentMethod>> {
    public static final SupportedPaymentMethod$Companion$exposedPaymentMethods$2 INSTANCE = new SupportedPaymentMethod$Companion$exposedPaymentMethods$2();

    SupportedPaymentMethod$Companion$exposedPaymentMethods$2() {
        super(0);
    }

    public final List<SupportedPaymentMethod> invoke() {
        return CollectionsKt.listOf(SupportedPaymentMethod.Card.INSTANCE, SupportedPaymentMethod.Bancontact.INSTANCE, SupportedPaymentMethod.Sofort.INSTANCE, SupportedPaymentMethod.Ideal.INSTANCE, SupportedPaymentMethod.SepaDebit.INSTANCE, SupportedPaymentMethod.Eps.INSTANCE, SupportedPaymentMethod.Giropay.INSTANCE, SupportedPaymentMethod.P24.INSTANCE, SupportedPaymentMethod.Klarna.INSTANCE, SupportedPaymentMethod.PayPal.INSTANCE, SupportedPaymentMethod.AfterpayClearpay.INSTANCE);
    }
}
