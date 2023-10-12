package com.stripe.android.paymentsheet.injection;

import com.stripe.android.paymentsheet.PaymentSheetContract;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class PaymentSheetViewModelModule_ProvideArgsFactory implements Factory<PaymentSheetContract.Args> {
    private final PaymentSheetViewModelModule module;

    public PaymentSheetViewModelModule_ProvideArgsFactory(PaymentSheetViewModelModule paymentSheetViewModelModule) {
        this.module = paymentSheetViewModelModule;
    }

    public PaymentSheetContract.Args get() {
        return provideArgs(this.module);
    }

    public static PaymentSheetViewModelModule_ProvideArgsFactory create(PaymentSheetViewModelModule paymentSheetViewModelModule) {
        return new PaymentSheetViewModelModule_ProvideArgsFactory(paymentSheetViewModelModule);
    }

    public static PaymentSheetContract.Args provideArgs(PaymentSheetViewModelModule paymentSheetViewModelModule) {
        return (PaymentSheetContract.Args) Preconditions.checkNotNullFromProvides(paymentSheetViewModelModule.provideArgs());
    }
}
