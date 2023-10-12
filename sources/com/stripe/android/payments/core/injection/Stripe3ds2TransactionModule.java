package com.stripe.android.payments.core.injection;

import android.content.Context;
import com.stripe.android.core.injection.IOContext;
import com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor;
import com.stripe.android.payments.core.authentication.threeds2.Stripe3ds2ChallengeResultProcessor;
import com.stripe.android.stripe3ds2.service.StripeThreeDs2Service;
import com.stripe.android.stripe3ds2.service.StripeThreeDs2ServiceImpl;
import com.stripe.android.stripe3ds2.transaction.MessageVersionRegistry;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b!\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'¨\u0006\b"}, d2 = {"Lcom/stripe/android/payments/core/injection/Stripe3ds2TransactionModule;", "", "()V", "bindsStripe3ds2ChallengeResultProcessor", "Lcom/stripe/android/payments/core/authentication/threeds2/Stripe3ds2ChallengeResultProcessor;", "defaultStripe3ds2ChallengeResultProcessor", "Lcom/stripe/android/payments/core/authentication/threeds2/DefaultStripe3ds2ChallengeResultProcessor;", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module(subcomponents = {Stripe3ds2TransactionViewModelSubcomponent.class})
/* compiled from: Stripe3ds2TransactionModule.kt */
public abstract class Stripe3ds2TransactionModule {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Binds
    public abstract Stripe3ds2ChallengeResultProcessor bindsStripe3ds2ChallengeResultProcessor(DefaultStripe3ds2ChallengeResultProcessor defaultStripe3ds2ChallengeResultProcessor);

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\fH\u0007¨\u0006\r"}, d2 = {"Lcom/stripe/android/payments/core/injection/Stripe3ds2TransactionModule$Companion;", "", "()V", "provideMessageVersionRegistry", "Lcom/stripe/android/stripe3ds2/transaction/MessageVersionRegistry;", "provideStripeThreeDs2Service", "Lcom/stripe/android/stripe3ds2/service/StripeThreeDs2Service;", "context", "Landroid/content/Context;", "enableLogging", "", "workContext", "Lkotlin/coroutines/CoroutineContext;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Stripe3ds2TransactionModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Singleton
        @Provides
        public final MessageVersionRegistry provideMessageVersionRegistry() {
            return new MessageVersionRegistry();
        }

        @Singleton
        @Provides
        public final StripeThreeDs2Service provideStripeThreeDs2Service(Context context, @Named("enableLogging") boolean z, @IOContext CoroutineContext coroutineContext) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
            return new StripeThreeDs2ServiceImpl(context, z, coroutineContext);
        }
    }
}
