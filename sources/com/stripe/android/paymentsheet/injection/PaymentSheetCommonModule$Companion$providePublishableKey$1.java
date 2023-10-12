package com.stripe.android.paymentsheet.injection;

import com.stripe.android.PaymentConfiguration;
import dagger.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSheetCommonModule.kt */
final class PaymentSheetCommonModule$Companion$providePublishableKey$1 extends Lambda implements Function0<String> {
    final /* synthetic */ Lazy<PaymentConfiguration> $paymentConfiguration;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentSheetCommonModule$Companion$providePublishableKey$1(Lazy<PaymentConfiguration> lazy) {
        super(0);
        this.$paymentConfiguration = lazy;
    }

    public final String invoke() {
        return this.$paymentConfiguration.get().getPublishableKey();
    }
}
