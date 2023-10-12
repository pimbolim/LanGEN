package com.stripe.android.view.i18n;

import com.stripe.android.core.StripeError;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\b\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/stripe/android/view/i18n/TranslatorManager;", "", "()V", "DEFAULT_ERROR_MESSAGE_TRANSLATOR", "Lcom/stripe/android/view/i18n/TranslatorManager$Default;", "errorMessageTranslator", "Lcom/stripe/android/view/i18n/ErrorMessageTranslator;", "getErrorMessageTranslator", "setErrorMessageTranslator", "", "Default", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TranslatorManager.kt */
public final class TranslatorManager {
    public static final int $stable = 8;
    private static final Default DEFAULT_ERROR_MESSAGE_TRANSLATOR = new Default();
    public static final TranslatorManager INSTANCE = new TranslatorManager();
    private static ErrorMessageTranslator errorMessageTranslator;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"Lcom/stripe/android/view/i18n/TranslatorManager$Default;", "Lcom/stripe/android/view/i18n/ErrorMessageTranslator;", "()V", "translate", "", "httpCode", "", "errorMessage", "stripeError", "Lcom/stripe/android/core/StripeError;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TranslatorManager.kt */
    private static final class Default implements ErrorMessageTranslator {
        public String translate(int i, String str, StripeError stripeError) {
            return str == null ? "" : str;
        }
    }

    private TranslatorManager() {
    }

    public final ErrorMessageTranslator getErrorMessageTranslator() {
        ErrorMessageTranslator errorMessageTranslator2 = errorMessageTranslator;
        return errorMessageTranslator2 == null ? DEFAULT_ERROR_MESSAGE_TRANSLATOR : errorMessageTranslator2;
    }

    public final void setErrorMessageTranslator(ErrorMessageTranslator errorMessageTranslator2) {
        errorMessageTranslator = errorMessageTranslator2;
    }
}
