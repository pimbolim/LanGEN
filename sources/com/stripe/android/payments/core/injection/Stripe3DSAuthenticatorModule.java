package com.stripe.android.payments.core.injection;

import com.stripe.android.PaymentAuthConfig;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.payments.core.authentication.PaymentAuthenticator;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3DS2Authenticator;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H'¨\u0006\t"}, d2 = {"Lcom/stripe/android/payments/core/injection/Stripe3DSAuthenticatorModule;", "", "()V", "bindsStripe3DSAuthenticator", "Lcom/stripe/android/payments/core/authentication/PaymentAuthenticator;", "Lcom/stripe/android/model/StripeIntent;", "stripe3ds2Authenticator", "Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3DS2Authenticator;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(includes = {Stripe3ds2TransactionModule.class})
/* compiled from: Stripe3DSAuthenticatorModule.kt */
public abstract class Stripe3DSAuthenticatorModule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @IntentAuthenticatorMap
    @Binds
    @IntoMap
    @IntentAuthenticatorKey(StripeIntent.NextActionData.SdkData.Use3DS2.class)
    public abstract PaymentAuthenticator<StripeIntent> bindsStripe3DSAuthenticator(Stripe3DS2Authenticator stripe3DS2Authenticator);

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/stripe/android/payments/core/injection/Stripe3DSAuthenticatorModule$Companion;", "", "()V", "providePaymentAuthConfig", "Lcom/stripe/android/PaymentAuthConfig;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Stripe3DSAuthenticatorModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Singleton
        @Provides
        public final PaymentAuthConfig providePaymentAuthConfig() {
            return PaymentAuthConfig.Companion.get();
        }
    }
}
