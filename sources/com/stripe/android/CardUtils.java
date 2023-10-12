package com.stripe.android;

import com.stripe.android.cards.CardNumber;
import com.stripe.android.model.CardBrand;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\t"}, d2 = {"Lcom/stripe/android/CardUtils;", "", "()V", "getPossibleCardBrand", "Lcom/stripe/android/model/CardBrand;", "cardNumber", "", "isValidLuhnNumber", "", "payments-model_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardUtils.kt */
public final class CardUtils {
    public static final CardUtils INSTANCE = new CardUtils();

    private CardUtils() {
    }

    @JvmStatic
    @Deprecated(message = "CardInputWidget and CardMultilineWidget handle card brand lookup. This method should not be relied on for determining CardBrand.")
    public static final CardBrand getPossibleCardBrand(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return CardBrand.Unknown;
        }
        return CardBrand.Companion.fromCardNumber(new CardNumber.Unvalidated(str).getNormalized());
    }

    public final boolean isValidLuhnNumber(String str) {
        int i;
        if (str == null) {
            return false;
        }
        int length = str.length() - 1;
        if (length >= 0) {
            boolean z = true;
            i = 0;
            while (true) {
                int i2 = length - 1;
                char charAt = str.charAt(length);
                if (!Character.isDigit(charAt)) {
                    return false;
                }
                int numericValue = Character.getNumericValue(charAt);
                z = !z;
                if (z) {
                    numericValue *= 2;
                }
                if (numericValue > 9) {
                    numericValue -= 9;
                }
                i += numericValue;
                if (i2 < 0) {
                    break;
                }
                length = i2;
            }
        } else {
            i = 0;
        }
        if (i % 10 == 0) {
            return true;
        }
        return false;
    }
}
