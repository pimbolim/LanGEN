package com.stripe.android.paymentsheet.model;

import com.stripe.android.model.ConfirmStripeIntentParams;
import com.stripe.android.paymentsheet.model.PaymentSelection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u000b*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003:\u0001\u000bB\u0007\b\u0004¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&¢\u0006\u0002\u0010\bJ\u0015\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\tH&¢\u0006\u0002\u0010\n\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/stripe/android/paymentsheet/model/ConfirmStripeIntentParamsFactory;", "T", "Lcom/stripe/android/model/ConfirmStripeIntentParams;", "", "()V", "create", "paymentSelection", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$New;", "(Lcom/stripe/android/paymentsheet/model/PaymentSelection$New;)Lcom/stripe/android/model/ConfirmStripeIntentParams;", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$Saved;", "(Lcom/stripe/android/paymentsheet/model/PaymentSelection$Saved;)Lcom/stripe/android/model/ConfirmStripeIntentParams;", "Companion", "Lcom/stripe/android/paymentsheet/model/ConfirmPaymentIntentParamsFactory;", "Lcom/stripe/android/paymentsheet/model/ConfirmSetupIntentParamsFactory;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConfirmStripeIntentParamsFactory.kt */
public abstract class ConfirmStripeIntentParamsFactory<T extends ConfirmStripeIntentParams> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public /* synthetic */ ConfirmStripeIntentParamsFactory(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract T create(PaymentSelection.New newR);

    public abstract T create(PaymentSelection.Saved saved);

    private ConfirmStripeIntentParamsFactory() {
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/paymentsheet/model/ConfirmStripeIntentParamsFactory$Companion;", "", "()V", "createFactory", "Lcom/stripe/android/paymentsheet/model/ConfirmStripeIntentParamsFactory;", "Lcom/stripe/android/model/ConfirmStripeIntentParams;", "clientSecret", "Lcom/stripe/android/paymentsheet/model/ClientSecret;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConfirmStripeIntentParamsFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ConfirmStripeIntentParamsFactory<ConfirmStripeIntentParams> createFactory(ClientSecret clientSecret) {
            Intrinsics.checkNotNullParameter(clientSecret, "clientSecret");
            if (clientSecret instanceof PaymentIntentClientSecret) {
                return new ConfirmPaymentIntentParamsFactory(clientSecret);
            }
            if (clientSecret instanceof SetupIntentClientSecret) {
                return new ConfirmSetupIntentParamsFactory(clientSecret);
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
