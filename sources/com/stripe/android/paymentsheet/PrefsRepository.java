package com.stripe.android.paymentsheet;

import com.stripe.android.paymentsheet.model.PaymentSelection;
import com.stripe.android.paymentsheet.model.SavedSelection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/stripe/android/paymentsheet/PrefsRepository;", "", "getSavedSelection", "Lcom/stripe/android/paymentsheet/model/SavedSelection;", "isGooglePayAvailable", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePaymentSelection", "", "paymentSelection", "Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "Noop", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PrefsRepository.kt */
public interface PrefsRepository {
    Object getSavedSelection(boolean z, Continuation<? super SavedSelection> continuation);

    void savePaymentSelection(PaymentSelection paymentSelection);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/stripe/android/paymentsheet/PrefsRepository$Noop;", "Lcom/stripe/android/paymentsheet/PrefsRepository;", "()V", "getSavedSelection", "Lcom/stripe/android/paymentsheet/model/SavedSelection;", "isGooglePayAvailable", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePaymentSelection", "", "paymentSelection", "Lcom/stripe/android/paymentsheet/model/PaymentSelection;", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PrefsRepository.kt */
    public static final class Noop implements PrefsRepository {
        public static final int $stable = 0;

        public void savePaymentSelection(PaymentSelection paymentSelection) {
        }

        public Object getSavedSelection(boolean z, Continuation<? super SavedSelection> continuation) {
            return SavedSelection.None.INSTANCE;
        }
    }
}
