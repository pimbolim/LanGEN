package com.stripe.android.paymentsheet.ui;

import android.content.res.Resources;
import com.stripe.android.model.CardBrand;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.paymentsheet.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0001\u001a\u0016\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006*\u00020\tH\u0001¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"createCardLabel", "", "resources", "Landroid/content/res/Resources;", "last4", "getCardBrandIcon", "", "Lcom/stripe/android/model/CardBrand;", "getLabel", "Lcom/stripe/android/model/PaymentMethod;", "getSavedPaymentMethodIcon", "(Lcom/stripe/android/model/PaymentMethod;)Ljava/lang/Integer;", "paymentsheet_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodsUiExtension.kt */
public final class PaymentMethodsUiExtensionKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentMethodsUiExtension.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PaymentMethod.Type.values().length];
            iArr[PaymentMethod.Type.Card.ordinal()] = 1;
            iArr[PaymentMethod.Type.SepaDebit.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CardBrand.values().length];
            iArr2[CardBrand.Visa.ordinal()] = 1;
            iArr2[CardBrand.AmericanExpress.ordinal()] = 2;
            iArr2[CardBrand.Discover.ordinal()] = 3;
            iArr2[CardBrand.JCB.ordinal()] = 4;
            iArr2[CardBrand.DinersClub.ordinal()] = 5;
            iArr2[CardBrand.MasterCard.ordinal()] = 6;
            iArr2[CardBrand.UnionPay.ordinal()] = 7;
            iArr2[CardBrand.Unknown.ordinal()] = 8;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final Integer getSavedPaymentMethodIcon(PaymentMethod paymentMethod) {
        int i;
        CardBrand cardBrand;
        Intrinsics.checkNotNullParameter(paymentMethod, "<this>");
        PaymentMethod.Type type = paymentMethod.type;
        int i2 = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        Integer num = null;
        if (i2 == 1) {
            PaymentMethod.Card card = paymentMethod.card;
            if (!(card == null || (cardBrand = card.brand) == null)) {
                num = Integer.valueOf(getCardBrandIcon(cardBrand));
            }
            if (num == null) {
                i = R.drawable.stripe_ic_paymentsheet_card_unknown;
            } else {
                i = num.intValue();
            }
            return Integer.valueOf(i);
        } else if (i2 != 2) {
            return null;
        } else {
            return Integer.valueOf(R.drawable.stripe_ic_paymentsheet_pm_sepa_debit);
        }
    }

    public static final int getCardBrandIcon(CardBrand cardBrand) {
        Intrinsics.checkNotNullParameter(cardBrand, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$1[cardBrand.ordinal()]) {
            case 1:
                return R.drawable.stripe_ic_paymentsheet_card_visa;
            case 2:
                return R.drawable.stripe_ic_paymentsheet_card_amex;
            case 3:
                return R.drawable.stripe_ic_paymentsheet_card_discover;
            case 4:
                return R.drawable.stripe_ic_paymentsheet_card_jcb;
            case 5:
                return R.drawable.stripe_ic_paymentsheet_card_dinersclub;
            case 6:
                return R.drawable.stripe_ic_paymentsheet_card_mastercard;
            case 7:
                return R.drawable.stripe_ic_paymentsheet_card_unionpay;
            case 8:
                return R.drawable.stripe_ic_paymentsheet_card_unknown;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final String getLabel(PaymentMethod paymentMethod, Resources resources) {
        Intrinsics.checkNotNullParameter(paymentMethod, "<this>");
        Intrinsics.checkNotNullParameter(resources, "resources");
        PaymentMethod.Type type = paymentMethod.type;
        int i = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        String str = null;
        if (i == 1) {
            PaymentMethod.Card card = paymentMethod.card;
            if (card != null) {
                str = card.last4;
            }
            return createCardLabel(resources, str);
        } else if (i != 2) {
            return null;
        } else {
            int i2 = R.string.paymentsheet_payment_method_item_card_number;
            Object[] objArr = new Object[1];
            PaymentMethod.SepaDebit sepaDebit = paymentMethod.sepaDebit;
            if (sepaDebit != null) {
                str = sepaDebit.last4;
            }
            objArr[0] = str;
            return resources.getString(i2, objArr);
        }
    }

    public static final String createCardLabel(Resources resources, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(resources, "resources");
        if (str == null) {
            str2 = null;
        } else {
            str2 = resources.getString(R.string.paymentsheet_payment_method_item_card_number, new Object[]{str});
        }
        return str2 == null ? "" : str2;
    }
}
