package com.stripe.android;

import com.stripe.android.EphemeralKeyManager;
import com.stripe.android.EphemeralOperation;
import com.stripe.android.IssuingCardPinService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/stripe/android/IssuingCardPinService$ephemeralKeyManager$1", "Lcom/stripe/android/EphemeralKeyManager$KeyManagerListener;", "onKeyError", "", "operationId", "", "errorCode", "", "errorMessage", "onKeyUpdate", "ephemeralKey", "Lcom/stripe/android/EphemeralKey;", "operation", "Lcom/stripe/android/EphemeralOperation;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IssuingCardPinService.kt */
public final class IssuingCardPinService$ephemeralKeyManager$1 implements EphemeralKeyManager.KeyManagerListener {
    final /* synthetic */ IssuingCardPinService this$0;

    IssuingCardPinService$ephemeralKeyManager$1(IssuingCardPinService issuingCardPinService) {
        this.this$0 = issuingCardPinService;
    }

    public void onKeyUpdate(EphemeralKey ephemeralKey, EphemeralOperation ephemeralOperation) {
        Intrinsics.checkNotNullParameter(ephemeralKey, "ephemeralKey");
        Intrinsics.checkNotNullParameter(ephemeralOperation, "operation");
        Unit unit = null;
        if (ephemeralOperation instanceof EphemeralOperation.Issuing.RetrievePin) {
            IssuingCardPinService.IssuingCardPinRetrievalListener issuingCardPinRetrievalListener = (IssuingCardPinService.IssuingCardPinRetrievalListener) this.this$0.retrievalListeners.remove(ephemeralOperation.getId$payments_core_release());
            if (issuingCardPinRetrievalListener != null) {
                this.this$0.fireRetrievePinRequest(ephemeralKey, (EphemeralOperation.Issuing.RetrievePin) ephemeralOperation, issuingCardPinRetrievalListener);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                this.this$0.logMissingListener();
            }
        } else if (ephemeralOperation instanceof EphemeralOperation.Issuing.UpdatePin) {
            IssuingCardPinService.IssuingCardPinUpdateListener issuingCardPinUpdateListener = (IssuingCardPinService.IssuingCardPinUpdateListener) this.this$0.updateListeners.remove(ephemeralOperation.getId$payments_core_release());
            if (issuingCardPinUpdateListener != null) {
                this.this$0.fireUpdatePinRequest(ephemeralKey, (EphemeralOperation.Issuing.UpdatePin) ephemeralOperation, issuingCardPinUpdateListener);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                this.this$0.logMissingListener();
            }
        }
    }

    public void onKeyError(String str, int i, String str2) {
        Unit unit;
        Intrinsics.checkNotNullParameter(str, "operationId");
        Intrinsics.checkNotNullParameter(str2, "errorMessage");
        IssuingCardPinService.IssuingCardPinUpdateListener issuingCardPinUpdateListener = (IssuingCardPinService.IssuingCardPinUpdateListener) this.this$0.updateListeners.remove(str);
        IssuingCardPinService.IssuingCardPinRetrievalListener issuingCardPinRetrievalListener = (IssuingCardPinService.IssuingCardPinRetrievalListener) this.this$0.retrievalListeners.remove(str);
        if (issuingCardPinRetrievalListener == null) {
            unit = null;
        } else {
            issuingCardPinRetrievalListener.onError(IssuingCardPinService.CardPinActionError.EPHEMERAL_KEY_ERROR, str2, (Throwable) null);
            unit = Unit.INSTANCE;
        }
        if (unit == null && issuingCardPinUpdateListener != null) {
            issuingCardPinUpdateListener.onError(IssuingCardPinService.CardPinActionError.EPHEMERAL_KEY_ERROR, str2, (Throwable) null);
        }
    }
}
