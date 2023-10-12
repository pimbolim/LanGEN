package com.stripe.android.paymentsheet.injection;

import android.app.Application;
import android.content.Context;
import com.stripe.android.paymentsheet.analytics.EventReporter;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.Set;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'¨\u0006\b"}, d2 = {"Lcom/stripe/android/paymentsheet/injection/PaymentSheetLauncherModule;", "", "()V", "bindsApplicationForContext", "Landroid/content/Context;", "application", "Landroid/app/Application;", "Companion", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(subcomponents = {PaymentSheetViewModelSubcomponent.class, FormViewModelSubcomponent.class})
/* compiled from: PaymentSheetLauncherModule.kt */
public abstract class PaymentSheetLauncherModule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Binds
    public abstract Context bindsApplicationForContext(Application application);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/stripe/android/paymentsheet/injection/PaymentSheetLauncherModule$Companion;", "", "()V", "provideEventReporterMode", "Lcom/stripe/android/paymentsheet/analytics/EventReporter$Mode;", "provideProductUsageTokens", "", "", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetLauncherModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Singleton
        @Provides
        public final EventReporter.Mode provideEventReporterMode() {
            return EventReporter.Mode.Complete;
        }

        @Named("productUsage")
        @Singleton
        @Provides
        public final Set<String> provideProductUsageTokens() {
            return SetsKt.setOf("PaymentSheet");
        }
    }
}
