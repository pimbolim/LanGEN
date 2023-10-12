package com.stripe.android.link.model;

import com.stripe.android.model.ConfirmSetupIntentParams;
import com.stripe.android.model.ConsumerPaymentDetails;
import com.stripe.android.model.MandateDataParams;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.model.SetupIntent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/link/model/ConfirmSetupIntentParamsFactory;", "Lcom/stripe/android/link/model/ConfirmStripeIntentParamsFactory;", "Lcom/stripe/android/model/ConfirmSetupIntentParams;", "setupIntent", "Lcom/stripe/android/model/SetupIntent;", "(Lcom/stripe/android/model/SetupIntent;)V", "create", "consumerSessionClientSecret", "", "selectedPaymentDetails", "Lcom/stripe/android/model/ConsumerPaymentDetails$PaymentDetails;", "link_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConfirmStripeIntentParamsFactory.kt */
public final class ConfirmSetupIntentParamsFactory extends ConfirmStripeIntentParamsFactory<ConfirmSetupIntentParams> {
    private final SetupIntent setupIntent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConfirmSetupIntentParamsFactory(SetupIntent setupIntent2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(setupIntent2, "setupIntent");
        this.setupIntent = setupIntent2;
    }

    public ConfirmSetupIntentParams create(String str, ConsumerPaymentDetails.PaymentDetails paymentDetails) {
        Intrinsics.checkNotNullParameter(str, "consumerSessionClientSecret");
        Intrinsics.checkNotNullParameter(paymentDetails, "selectedPaymentDetails");
        ConfirmSetupIntentParams.Companion companion = ConfirmSetupIntentParams.Companion;
        PaymentMethodCreateParams createLink$default = PaymentMethodCreateParams.Companion.createLink$default(PaymentMethodCreateParams.Companion, paymentDetails.getId(), str, (Map) null, 4, (Object) null);
        String clientSecret = this.setupIntent.getClientSecret();
        Intrinsics.checkNotNull(clientSecret);
        return ConfirmSetupIntentParams.Companion.create$default(companion, createLink$default, clientSecret, (MandateDataParams) null, (String) null, 12, (Object) null);
    }
}
