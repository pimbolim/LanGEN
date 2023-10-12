package com.stripe.android.paymentsheet.model;

import android.content.res.Resources;
import com.stripe.android.paymentsheet.R;
import com.stripe.android.paymentsheet.model.PaymentSelection;
import com.stripe.android.paymentsheet.ui.PaymentMethodsUiExtensionKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/stripe/android/paymentsheet/model/PaymentOptionFactory;", "", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "create", "Lcom/stripe/android/paymentsheet/model/PaymentOption;", "selection", "Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionFactory.kt */
public final class PaymentOptionFactory {
    private final Resources resources;

    public PaymentOptionFactory(Resources resources2) {
        Intrinsics.checkNotNullParameter(resources2, "resources");
        this.resources = resources2;
    }

    public final PaymentOption create(PaymentSelection paymentSelection) {
        PaymentOption paymentOption;
        Intrinsics.checkNotNullParameter(paymentSelection, "selection");
        if (Intrinsics.areEqual((Object) paymentSelection, (Object) PaymentSelection.GooglePay.INSTANCE)) {
            int i = R.drawable.stripe_google_pay_mark;
            String string = this.resources.getString(R.string.google_pay);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.google_pay)");
            return new PaymentOption(i, string);
        }
        if (paymentSelection instanceof PaymentSelection.Saved) {
            PaymentSelection.Saved saved = (PaymentSelection.Saved) paymentSelection;
            Integer savedPaymentMethodIcon = PaymentMethodsUiExtensionKt.getSavedPaymentMethodIcon(saved.getPaymentMethod());
            int intValue = savedPaymentMethodIcon == null ? 0 : savedPaymentMethodIcon.intValue();
            String label = PaymentMethodsUiExtensionKt.getLabel(saved.getPaymentMethod(), this.resources);
            if (label == null) {
                label = "";
            }
            paymentOption = new PaymentOption(intValue, label);
        } else if (paymentSelection instanceof PaymentSelection.New.Card) {
            PaymentSelection.New.Card card = (PaymentSelection.New.Card) paymentSelection;
            paymentOption = new PaymentOption(PaymentMethodsUiExtensionKt.getCardBrandIcon(card.getBrand()), PaymentMethodsUiExtensionKt.createCardLabel(this.resources, card.getLast4()));
        } else if (paymentSelection instanceof PaymentSelection.New.GenericPaymentMethod) {
            PaymentSelection.New.GenericPaymentMethod genericPaymentMethod = (PaymentSelection.New.GenericPaymentMethod) paymentSelection;
            int iconResource = genericPaymentMethod.getIconResource();
            String string2 = this.resources.getString(genericPaymentMethod.getLabelResource());
            Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(selection.labelResource)");
            paymentOption = new PaymentOption(iconResource, string2);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return paymentOption;
    }
}
