package com.stripe.android.paymentsheet.injection;

import com.stripe.android.paymentsheet.analytics.EventReporter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class PaymentSheetLauncherModule_Companion_ProvideEventReporterModeFactory implements Factory<EventReporter.Mode> {
    public EventReporter.Mode get() {
        return provideEventReporterMode();
    }

    public static PaymentSheetLauncherModule_Companion_ProvideEventReporterModeFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static EventReporter.Mode provideEventReporterMode() {
        return (EventReporter.Mode) Preconditions.checkNotNullFromProvides(PaymentSheetLauncherModule.Companion.provideEventReporterMode());
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final PaymentSheetLauncherModule_Companion_ProvideEventReporterModeFactory INSTANCE = new PaymentSheetLauncherModule_Companion_ProvideEventReporterModeFactory();

        private InstanceHolder() {
        }
    }
}
