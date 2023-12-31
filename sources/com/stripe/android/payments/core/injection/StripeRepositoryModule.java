package com.stripe.android.payments.core.injection;

import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor;
import com.stripe.android.networking.StripeApiRepository;
import com.stripe.android.networking.StripeRepository;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H!¢\u0006\u0002\b\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH!¢\u0006\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/stripe/android/payments/core/injection/StripeRepositoryModule;", "", "()V", "bindsAnalyticsRequestExecutor", "Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;", "default", "Lcom/stripe/android/core/networking/DefaultAnalyticsRequestExecutor;", "bindsAnalyticsRequestExecutor$payments_core_release", "bindsStripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "stripeApiRepository", "Lcom/stripe/android/networking/StripeApiRepository;", "bindsStripeRepository$payments_core_release", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* compiled from: StripeRepositoryModule.kt */
public abstract class StripeRepositoryModule {
    public static final int $stable = 0;

    @Binds
    public abstract AnalyticsRequestExecutor bindsAnalyticsRequestExecutor$payments_core_release(DefaultAnalyticsRequestExecutor defaultAnalyticsRequestExecutor);

    @Binds
    public abstract StripeRepository bindsStripeRepository$payments_core_release(StripeApiRepository stripeApiRepository);
}
