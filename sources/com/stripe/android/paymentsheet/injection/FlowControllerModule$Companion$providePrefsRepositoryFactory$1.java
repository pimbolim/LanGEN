package com.stripe.android.paymentsheet.injection;

import android.content.Context;
import com.stripe.android.paymentsheet.DefaultPrefsRepository;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.PrefsRepository;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/stripe/android/paymentsheet/PrefsRepository;", "customerConfig", "Lcom/stripe/android/paymentsheet/PaymentSheet$CustomerConfiguration;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowControllerModule.kt */
final class FlowControllerModule$Companion$providePrefsRepositoryFactory$1 extends Lambda implements Function1<PaymentSheet.CustomerConfiguration, PrefsRepository> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ CoroutineContext $workContext;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowControllerModule$Companion$providePrefsRepositoryFactory$1(Context context, CoroutineContext coroutineContext) {
        super(1);
        this.$appContext = context;
        this.$workContext = coroutineContext;
    }

    public final PrefsRepository invoke(PaymentSheet.CustomerConfiguration customerConfiguration) {
        DefaultPrefsRepository defaultPrefsRepository;
        if (customerConfiguration == null) {
            defaultPrefsRepository = null;
        } else {
            defaultPrefsRepository = new DefaultPrefsRepository(this.$appContext, customerConfiguration.getId(), this.$workContext);
        }
        return defaultPrefsRepository == null ? new PrefsRepository.Noop() : defaultPrefsRepository;
    }
}
