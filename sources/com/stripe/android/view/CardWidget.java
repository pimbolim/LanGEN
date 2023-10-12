package com.stripe.android.view;

import android.text.TextWatcher;
import com.stripe.android.model.CardParams;
import com.stripe.android.model.PaymentMethodCreateParams;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b`\u0018\u0000 *2\u00020\u0001:\u0001*J\b\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0012\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\u0012\u0010\u0016\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H&J\u0012\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\u0012\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH&J\u0012\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0012H&J\u0012\u0010 \u001a\u00020\u000f2\b\u0010!\u001a\u0004\u0018\u00010\u001aH&J\u001c\u0010\"\u001a\u00020\u000f2\b\b\u0001\u0010#\u001a\u00020$2\b\b\u0001\u0010%\u001a\u00020$H&J\u0012\u0010&\u001a\u00020\u000f2\b\u0010'\u001a\u0004\u0018\u00010\u001aH&J\u0012\u0010(\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010\u001aH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006+"}, d2 = {"Lcom/stripe/android/view/CardWidget;", "", "cardParams", "Lcom/stripe/android/model/CardParams;", "getCardParams", "()Lcom/stripe/android/model/CardParams;", "paymentMethodCard", "Lcom/stripe/android/model/PaymentMethodCreateParams$Card;", "getPaymentMethodCard", "()Lcom/stripe/android/model/PaymentMethodCreateParams$Card;", "paymentMethodCreateParams", "Lcom/stripe/android/model/PaymentMethodCreateParams;", "getPaymentMethodCreateParams", "()Lcom/stripe/android/model/PaymentMethodCreateParams;", "clear", "", "setCardHint", "cardHint", "", "setCardInputListener", "listener", "Lcom/stripe/android/view/CardInputListener;", "setCardNumber", "cardNumber", "setCardNumberTextWatcher", "cardNumberTextWatcher", "Landroid/text/TextWatcher;", "setCardValidCallback", "callback", "Lcom/stripe/android/view/CardValidCallback;", "setCvcCode", "cvcCode", "setCvcNumberTextWatcher", "cvcNumberTextWatcher", "setExpiryDate", "month", "", "year", "setExpiryDateTextWatcher", "expiryDateTextWatcher", "setPostalCodeTextWatcher", "postalCodeTextWatcher", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardWidget.kt */
public interface CardWidget {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final boolean DEFAULT_POSTAL_CODE_ENABLED = true;
    public static final boolean DEFAULT_POSTAL_CODE_REQUIRED = false;
    public static final boolean DEFAULT_US_ZIP_CODE_REQUIRED = false;

    void clear();

    CardParams getCardParams();

    PaymentMethodCreateParams.Card getPaymentMethodCard();

    PaymentMethodCreateParams getPaymentMethodCreateParams();

    void setCardHint(String str);

    void setCardInputListener(CardInputListener cardInputListener);

    void setCardNumber(String str);

    void setCardNumberTextWatcher(TextWatcher textWatcher);

    void setCardValidCallback(CardValidCallback cardValidCallback);

    void setCvcCode(String str);

    void setCvcNumberTextWatcher(TextWatcher textWatcher);

    void setExpiryDate(int i, int i2);

    void setExpiryDateTextWatcher(TextWatcher textWatcher);

    void setPostalCodeTextWatcher(TextWatcher textWatcher);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/stripe/android/view/CardWidget$Companion;", "", "()V", "DEFAULT_POSTAL_CODE_ENABLED", "", "DEFAULT_POSTAL_CODE_REQUIRED", "DEFAULT_US_ZIP_CODE_REQUIRED", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardWidget.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final boolean DEFAULT_POSTAL_CODE_ENABLED = true;
        public static final boolean DEFAULT_POSTAL_CODE_REQUIRED = false;
        public static final boolean DEFAULT_US_ZIP_CODE_REQUIRED = false;

        private Companion() {
        }
    }
}
