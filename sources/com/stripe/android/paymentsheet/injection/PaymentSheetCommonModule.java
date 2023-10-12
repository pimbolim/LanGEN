package com.stripe.android.paymentsheet.injection;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.os.LocaleListCompat;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.paymentsheet.analytics.DefaultDeviceIdRepository;
import com.stripe.android.paymentsheet.analytics.DefaultEventReporter;
import com.stripe.android.paymentsheet.analytics.DeviceIdRepository;
import com.stripe.android.paymentsheet.analytics.EventReporter;
import com.stripe.android.paymentsheet.repositories.CustomerApiRepository;
import com.stripe.android.paymentsheet.repositories.CustomerRepository;
import com.stripe.android.paymentsheet.repositories.StripeIntentRepository;
import com.stripe.android.ui.core.forms.resources.AsyncResourceRepository;
import com.stripe.android.ui.core.forms.resources.ResourceRepository;
import dagger.Binds;
import dagger.Lazy;
import dagger.Module;
import dagger.Provides;
import java.util.Locale;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH'J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H'J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0014H'¨\u0006\u0016"}, d2 = {"Lcom/stripe/android/paymentsheet/injection/PaymentSheetCommonModule;", "", "()V", "bindsCustomerRepository", "Lcom/stripe/android/paymentsheet/repositories/CustomerRepository;", "repository", "Lcom/stripe/android/paymentsheet/repositories/CustomerApiRepository;", "bindsDeviceIdRepository", "Lcom/stripe/android/paymentsheet/analytics/DeviceIdRepository;", "Lcom/stripe/android/paymentsheet/analytics/DefaultDeviceIdRepository;", "bindsEventReporter", "Lcom/stripe/android/paymentsheet/analytics/EventReporter;", "eventReporter", "Lcom/stripe/android/paymentsheet/analytics/DefaultEventReporter;", "bindsResourceRepository", "Lcom/stripe/android/ui/core/forms/resources/ResourceRepository;", "asyncResourceRepository", "Lcom/stripe/android/ui/core/forms/resources/AsyncResourceRepository;", "bindsStripeIntentRepository", "Lcom/stripe/android/paymentsheet/repositories/StripeIntentRepository;", "Lcom/stripe/android/paymentsheet/repositories/StripeIntentRepository$Api;", "Companion", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* compiled from: PaymentSheetCommonModule.kt */
public abstract class PaymentSheetCommonModule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Binds
    public abstract CustomerRepository bindsCustomerRepository(CustomerApiRepository customerApiRepository);

    @Binds
    public abstract DeviceIdRepository bindsDeviceIdRepository(DefaultDeviceIdRepository defaultDeviceIdRepository);

    @Binds
    public abstract EventReporter bindsEventReporter(DefaultEventReporter defaultEventReporter);

    @Binds
    public abstract ResourceRepository bindsResourceRepository(AsyncResourceRepository asyncResourceRepository);

    @Binds
    public abstract StripeIntentRepository bindsStripeIntentRepository(StripeIntentRepository.Api api);

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0007J\u001e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0007¨\u0006\u0014"}, d2 = {"Lcom/stripe/android/paymentsheet/injection/PaymentSheetCommonModule$Companion;", "", "()V", "provideEnabledLogging", "", "provideLocale", "Ljava/util/Locale;", "providePaymentConfiguration", "Lcom/stripe/android/PaymentConfiguration;", "appContext", "Landroid/content/Context;", "providePublishableKey", "Lkotlin/Function0;", "", "paymentConfiguration", "Ldagger/Lazy;", "provideResources", "Landroid/content/res/Resources;", "context", "provideStripeAccountId", "paymentsheet_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PaymentSheetCommonModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Singleton
        @Provides
        @Named("enableLogging")
        public final boolean provideEnabledLogging() {
            return false;
        }

        private Companion() {
        }

        @Provides
        public final PaymentConfiguration providePaymentConfiguration(Context context) {
            Intrinsics.checkNotNullParameter(context, "appContext");
            return PaymentConfiguration.Companion.getInstance(context);
        }

        @Singleton
        @Provides
        public final Resources provideResources(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Resources resources = context.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
            return resources;
        }

        @Provides
        @Named("publishableKey")
        public final Function0<String> providePublishableKey(Lazy<PaymentConfiguration> lazy) {
            Intrinsics.checkNotNullParameter(lazy, "paymentConfiguration");
            return new PaymentSheetCommonModule$Companion$providePublishableKey$1(lazy);
        }

        @Provides
        @Named("stripeAccountId")
        public final Function0<String> provideStripeAccountId(Lazy<PaymentConfiguration> lazy) {
            Intrinsics.checkNotNullParameter(lazy, "paymentConfiguration");
            return new PaymentSheetCommonModule$Companion$provideStripeAccountId$1(lazy);
        }

        @Singleton
        @Provides
        public final Locale provideLocale() {
            LocaleListCompat adjustedDefault = LocaleListCompat.getAdjustedDefault();
            if (adjustedDefault.isEmpty()) {
                adjustedDefault = null;
            }
            if (adjustedDefault == null) {
                return null;
            }
            return adjustedDefault.get(0);
        }
    }
}
