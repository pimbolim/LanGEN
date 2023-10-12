package com.stripe.android.paymentsheet.model;

import com.stripe.android.model.ConfirmPaymentIntentParams;
import com.stripe.android.model.MandateDataParams;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.model.PaymentMethodOptionsParams;
import com.stripe.android.paymentsheet.model.PaymentSelection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/stripe/android/paymentsheet/model/ConfirmPaymentIntentParamsFactory;", "Lcom/stripe/android/paymentsheet/model/ConfirmStripeIntentParamsFactory;", "Lcom/stripe/android/model/ConfirmPaymentIntentParams;", "clientSecret", "Lcom/stripe/android/paymentsheet/model/ClientSecret;", "(Lcom/stripe/android/paymentsheet/model/ClientSecret;)V", "create", "paymentSelection", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$New;", "Lcom/stripe/android/paymentsheet/model/PaymentSelection$Saved;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConfirmStripeIntentParamsFactory.kt */
public final class ConfirmPaymentIntentParamsFactory extends ConfirmStripeIntentParamsFactory<ConfirmPaymentIntentParams> {
    private final ClientSecret clientSecret;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConfirmStripeIntentParamsFactory.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PaymentSelection.CustomerRequestedSave.values().length];
            iArr[PaymentSelection.CustomerRequestedSave.RequestReuse.ordinal()] = 1;
            iArr[PaymentSelection.CustomerRequestedSave.RequestNoReuse.ordinal()] = 2;
            iArr[PaymentSelection.CustomerRequestedSave.NoRequest.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConfirmPaymentIntentParamsFactory(ClientSecret clientSecret2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(clientSecret2, "clientSecret");
        this.clientSecret = clientSecret2;
    }

    public ConfirmPaymentIntentParams create(PaymentSelection.Saved saved) {
        Intrinsics.checkNotNullParameter(saved, "paymentSelection");
        ConfirmPaymentIntentParams.Companion companion = ConfirmPaymentIntentParams.Companion;
        String str = saved.getPaymentMethod().id;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        String value = this.clientSecret.getValue();
        PaymentMethodOptionsParams.Card card = new PaymentMethodOptionsParams.Card((String) null, (String) null, ConfirmPaymentIntentParams.SetupFutureUsage.Blank, 3, (DefaultConstructorMarker) null);
        if (!(saved.getPaymentMethod().type == PaymentMethod.Type.Card)) {
            card = null;
        }
        return ConfirmPaymentIntentParams.Companion.createWithPaymentMethodId$default(companion, str2, value, (Boolean) null, card, (String) null, (MandateDataParams) null, (ConfirmPaymentIntentParams.SetupFutureUsage) null, (ConfirmPaymentIntentParams.Shipping) null, 244, (Object) null);
    }

    public ConfirmPaymentIntentParams create(PaymentSelection.New newR) {
        ConfirmPaymentIntentParams.SetupFutureUsage setupFutureUsage;
        Intrinsics.checkNotNullParameter(newR, "paymentSelection");
        ConfirmPaymentIntentParams.Companion companion = ConfirmPaymentIntentParams.Companion;
        PaymentMethodCreateParams paymentMethodCreateParams = newR.getPaymentMethodCreateParams();
        String value = this.clientSecret.getValue();
        int i = WhenMappings.$EnumSwitchMapping$0[newR.getCustomerRequestedSave().ordinal()];
        if (i == 1) {
            setupFutureUsage = ConfirmPaymentIntentParams.SetupFutureUsage.OffSession;
        } else if (i == 2) {
            setupFutureUsage = ConfirmPaymentIntentParams.SetupFutureUsage.Blank;
        } else if (i == 3) {
            setupFutureUsage = null;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return ConfirmPaymentIntentParams.Companion.createWithPaymentMethodCreateParams$default(companion, paymentMethodCreateParams, value, (Boolean) null, (String) null, (MandateDataParams) null, (ConfirmPaymentIntentParams.SetupFutureUsage) null, (ConfirmPaymentIntentParams.Shipping) null, new PaymentMethodOptionsParams.Card((String) null, (String) null, Intrinsics.areEqual((Object) newR.getPaymentMethodCreateParams().getTypeCode(), (Object) PaymentMethod.Type.Card.code) ? setupFutureUsage : null, 3, (DefaultConstructorMarker) null), 124, (Object) null);
    }
}
