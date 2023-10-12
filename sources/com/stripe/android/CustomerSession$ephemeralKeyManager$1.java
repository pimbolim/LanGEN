package com.stripe.android;

import com.stripe.android.CustomerSession;
import com.stripe.android.EphemeralKeyManager;
import com.stripe.android.core.StripeError;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"com/stripe/android/CustomerSession$ephemeralKeyManager$1", "Lcom/stripe/android/EphemeralKeyManager$KeyManagerListener;", "onKeyError", "", "operationId", "", "errorCode", "", "errorMessage", "onKeyUpdate", "ephemeralKey", "Lcom/stripe/android/EphemeralKey;", "operation", "Lcom/stripe/android/EphemeralOperation;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomerSession.kt */
public final class CustomerSession$ephemeralKeyManager$1 implements EphemeralKeyManager.KeyManagerListener {
    final /* synthetic */ CustomerSession this$0;

    CustomerSession$ephemeralKeyManager$1(CustomerSession customerSession) {
        this.this$0 = customerSession;
    }

    public void onKeyUpdate(EphemeralKey ephemeralKey, EphemeralOperation ephemeralOperation) {
        Intrinsics.checkNotNullParameter(ephemeralKey, "ephemeralKey");
        Intrinsics.checkNotNullParameter(ephemeralOperation, "operation");
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.this$0.workContext), (CoroutineContext) null, (CoroutineStart) null, new CustomerSession$ephemeralKeyManager$1$onKeyUpdate$1(this.this$0, ephemeralKey, ephemeralOperation, (Continuation<? super CustomerSession$ephemeralKeyManager$1$onKeyUpdate$1>) null), 3, (Object) null);
    }

    public void onKeyError(String str, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, "operationId");
        Intrinsics.checkNotNullParameter(str2, "errorMessage");
        CustomerSession.RetrievalListener retrievalListener = (CustomerSession.RetrievalListener) this.this$0.listeners.remove(str);
        if (retrievalListener != null) {
            retrievalListener.onError(i, str2, (StripeError) null);
        }
    }
}
