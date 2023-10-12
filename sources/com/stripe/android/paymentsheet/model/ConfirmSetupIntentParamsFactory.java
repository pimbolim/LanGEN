package com.stripe.android.paymentsheet.model;

import com.stripe.android.model.ConfirmSetupIntentParams;
import com.stripe.android.model.MandateDataParams;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.paymentsheet.model.PaymentSelection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/model/ConfirmSetupIntentParamsFactory;", "Lcom/stripe/android/paymentsheet/model/ConfirmStripeIntentParamsFactory;", "Lcom/stripe/android/model/ConfirmSetupIntentParams;", "clientSecret", "Lcom/stripe/android/paymentsheet/model/ClientSecret;", "(Lcom/stripe/android/paymentsheet/model/ClientSecret;)V", "create", "paymentSelection", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$New;", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$Saved;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConfirmStripeIntentParamsFactory.kt */
public final class ConfirmSetupIntentParamsFactory extends ConfirmStripeIntentParamsFactory<ConfirmSetupIntentParams> {
    private final ClientSecret clientSecret;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConfirmSetupIntentParamsFactory(ClientSecret clientSecret2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(clientSecret2, "clientSecret");
        this.clientSecret = clientSecret2;
    }

    public ConfirmSetupIntentParams create(PaymentSelection.Saved saved) {
        MandateDataParams mandateDataParams;
        Intrinsics.checkNotNullParameter(saved, "paymentSelection");
        ConfirmSetupIntentParams.Companion companion = ConfirmSetupIntentParams.Companion;
        String str = saved.getPaymentMethod().id;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        String value = this.clientSecret.getValue();
        PaymentMethod.Type type = saved.getPaymentMethod().type;
        if (type == null) {
            mandateDataParams = null;
        } else {
            boolean z = type.requiresMandate;
            mandateDataParams = new MandateDataParams(MandateDataParams.Type.Online.Companion.getDEFAULT());
        }
        return ConfirmSetupIntentParams.Companion.create$default(companion, str2, value, mandateDataParams, (String) null, 8, (Object) null);
    }

    public ConfirmSetupIntentParams create(PaymentSelection.New newR) {
        Intrinsics.checkNotNullParameter(newR, "paymentSelection");
        return ConfirmSetupIntentParams.Companion.create$default(ConfirmSetupIntentParams.Companion, newR.getPaymentMethodCreateParams(), this.clientSecret.getValue(), (MandateDataParams) null, (String) null, 12, (Object) null);
    }
}
