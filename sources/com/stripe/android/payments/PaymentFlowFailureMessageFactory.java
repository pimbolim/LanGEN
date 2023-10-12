package com.stripe.android.payments;

import android.content.Context;
import com.stripe.android.R;
import com.stripe.android.model.PaymentIntent;
import com.stripe.android.model.SetupIntent;
import com.stripe.android.model.StripeIntent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/payments/PaymentFlowFailureMessageFactory;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "create", "", "intent", "Lcom/stripe/android/model/StripeIntent;", "outcome", "", "createForPaymentIntent", "paymentIntent", "Lcom/stripe/android/model/PaymentIntent;", "createForSetupIntent", "setupIntent", "Lcom/stripe/android/model/SetupIntent;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentFlowFailureMessageFactory.kt */
public final class PaymentFlowFailureMessageFactory {
    private final Context context;

    public PaymentFlowFailureMessageFactory(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final String create(StripeIntent stripeIntent, int i) {
        Intrinsics.checkNotNullParameter(stripeIntent, "intent");
        if (i == 4) {
            return this.context.getResources().getString(R.string.stripe_failure_reason_timed_out);
        }
        if (stripeIntent.getStatus() != StripeIntent.Status.RequiresPaymentMethod && stripeIntent.getStatus() != StripeIntent.Status.RequiresAction) {
            return null;
        }
        if (stripeIntent instanceof PaymentIntent) {
            return createForPaymentIntent((PaymentIntent) stripeIntent);
        }
        if (stripeIntent instanceof SetupIntent) {
            return createForSetupIntent((SetupIntent) stripeIntent);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        if (r1 != false) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String createForPaymentIntent(com.stripe.android.model.PaymentIntent r4) {
        /*
            r3 = this;
            com.stripe.android.model.StripeIntent$Status r0 = r4.getStatus()
            com.stripe.android.model.StripeIntent$Status r1 = com.stripe.android.model.StripeIntent.Status.RequiresAction
            if (r0 != r1) goto L_0x001d
            com.stripe.android.model.PaymentMethod r0 = r4.getPaymentMethod()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0012
        L_0x0010:
            r1 = 0
            goto L_0x001b
        L_0x0012:
            com.stripe.android.model.PaymentMethod$Type r0 = r0.type
            if (r0 != 0) goto L_0x0017
            goto L_0x0010
        L_0x0017:
            boolean r0 = r0.isVoucher
            if (r0 != r1) goto L_0x0010
        L_0x001b:
            if (r1 == 0) goto L_0x0032
        L_0x001d:
            com.stripe.android.model.PaymentIntent$Error r0 = r4.getLastPaymentError()
            r1 = 0
            if (r0 != 0) goto L_0x0026
            r0 = r1
            goto L_0x002a
        L_0x0026:
            java.lang.String r0 = r0.getCode()
        L_0x002a:
            java.lang.String r2 = "payment_intent_authentication_failure"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x003f
        L_0x0032:
            android.content.Context r4 = r3.context
            android.content.res.Resources r4 = r4.getResources()
            int r0 = com.stripe.android.R.string.stripe_failure_reason_authentication
            java.lang.String r4 = r4.getString(r0)
            goto L_0x005b
        L_0x003f:
            com.stripe.android.model.PaymentIntent$Error r0 = r4.getLastPaymentError()
            if (r0 != 0) goto L_0x0047
            r0 = r1
            goto L_0x004b
        L_0x0047:
            com.stripe.android.model.PaymentIntent$Error$Type r0 = r0.getType()
        L_0x004b:
            com.stripe.android.model.PaymentIntent$Error$Type r2 = com.stripe.android.model.PaymentIntent.Error.Type.CardError
            if (r0 != r2) goto L_0x0058
            com.stripe.android.model.PaymentIntent$Error r4 = r4.getLastPaymentError()
            java.lang.String r4 = r4.getMessage()
            goto L_0x005b
        L_0x0058:
            r4 = r1
            java.lang.String r4 = (java.lang.String) r4
        L_0x005b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.payments.PaymentFlowFailureMessageFactory.createForPaymentIntent(com.stripe.android.model.PaymentIntent):java.lang.String");
    }

    private final String createForSetupIntent(SetupIntent setupIntent) {
        SetupIntent.Error lastSetupError = setupIntent.getLastSetupError();
        if (Intrinsics.areEqual((Object) lastSetupError == null ? null : lastSetupError.getCode(), (Object) SetupIntent.Error.CODE_AUTHENTICATION_ERROR)) {
            return this.context.getResources().getString(R.string.stripe_failure_reason_authentication);
        }
        SetupIntent.Error lastSetupError2 = setupIntent.getLastSetupError();
        if ((lastSetupError2 == null ? null : lastSetupError2.getType()) == SetupIntent.Error.Type.CardError) {
            return setupIntent.getLastSetupError().getMessage();
        }
        return null;
    }
}
