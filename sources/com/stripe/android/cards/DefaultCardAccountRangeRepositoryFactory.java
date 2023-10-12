package com.stripe.android.cards;

import android.content.Context;
import com.stripe.android.FraudDetectionDataRepository;
import com.stripe.android.PaymentConfiguration;
import com.stripe.android.cards.CardAccountRangeRepository;
import com.stripe.android.cards.CardNumber;
import com.stripe.android.core.AppInfo;
import com.stripe.android.core.Logger;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.core.networking.DefaultAnalyticsRequestExecutor;
import com.stripe.android.core.networking.StripeNetworkClient;
import com.stripe.android.model.AccountRange;
import com.stripe.android.model.Token;
import com.stripe.android.networking.FraudDetectionDataParamsUtils;
import com.stripe.android.networking.PaymentAnalyticsEvent;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeApiRepository;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0014B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \t*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/stripe/android/cards/DefaultCardAccountRangeRepositoryFactory;", "Lcom/stripe/android/cards/CardAccountRangeRepository$Factory;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "analyticsRequestExecutor", "Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;", "(Landroid/content/Context;Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;)V", "appContext", "kotlin.jvm.PlatformType", "create", "Lcom/stripe/android/cards/CardAccountRangeRepository;", "createRemoteCardAccountRangeSource", "Lcom/stripe/android/cards/CardAccountRangeSource;", "fireAnalyticsEvent", "", "publishableKey", "", "event", "Lcom/stripe/android/networking/PaymentAnalyticsEvent;", "NullCardAccountRangeSource", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultCardAccountRangeRepositoryFactory.kt */
public final class DefaultCardAccountRangeRepositoryFactory implements CardAccountRangeRepository.Factory {
    public static final int $stable = 8;
    private final AnalyticsRequestExecutor analyticsRequestExecutor;
    private final Context appContext;

    public DefaultCardAccountRangeRepositoryFactory(Context context, AnalyticsRequestExecutor analyticsRequestExecutor2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(analyticsRequestExecutor2, "analyticsRequestExecutor");
        this.analyticsRequestExecutor = analyticsRequestExecutor2;
        this.appContext = context.getApplicationContext();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public DefaultCardAccountRangeRepositoryFactory(Context context) {
        this(context, new DefaultAnalyticsRequestExecutor());
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public CardAccountRangeRepository create() throws IllegalStateException {
        Context context = this.appContext;
        Intrinsics.checkNotNullExpressionValue(context, "appContext");
        CardAccountRangeStore defaultCardAccountRangeStore = new DefaultCardAccountRangeStore(context);
        return new DefaultCardAccountRangeRepository(new InMemoryCardAccountRangeSource(defaultCardAccountRangeStore), createRemoteCardAccountRangeSource(), new StaticCardAccountRangeSource((StaticCardAccountRanges) null, 1, (DefaultConstructorMarker) null), defaultCardAccountRangeStore);
    }

    private final CardAccountRangeSource createRemoteCardAccountRangeSource() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            PaymentConfiguration.Companion companion2 = PaymentConfiguration.Companion;
            Context context = this.appContext;
            Intrinsics.checkNotNullExpressionValue(context, "appContext");
            obj = Result.m4709constructorimpl(companion2.getInstance(context).getPublishableKey());
        } catch (Throwable th) {
            Result.Companion companion3 = Result.Companion;
            obj = Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m4716isSuccessimpl(obj)) {
            fireAnalyticsEvent((String) obj, PaymentAnalyticsEvent.CardMetadataPublishableKeyAvailable);
        }
        if (Result.m4712exceptionOrNullimpl(obj) != null) {
            fireAnalyticsEvent(ApiRequest.Options.UNDEFINED_PUBLISHABLE_KEY, PaymentAnalyticsEvent.CardMetadataPublishableKeyUnavailable);
        }
        if (Result.m4712exceptionOrNullimpl(obj) != null) {
            return new NullCardAccountRangeSource();
        }
        String str = (String) obj;
        Context context2 = this.appContext;
        Intrinsics.checkNotNullExpressionValue(context2, "appContext");
        ApiRequest.Options options = new ApiRequest.Options(str, (String) null, (String) null, 6, (DefaultConstructorMarker) null);
        Context context3 = this.appContext;
        Intrinsics.checkNotNullExpressionValue(context3, "appContext");
        Context context4 = this.appContext;
        Intrinsics.checkNotNullExpressionValue(context4, "appContext");
        return new RemoteCardAccountRangeSource(new StripeApiRepository(context2, new DefaultCardAccountRangeRepositoryFactory$createRemoteCardAccountRangeSource$4$1(str), (AppInfo) null, (Logger) null, (CoroutineContext) null, (Set) null, (StripeNetworkClient) null, (AnalyticsRequestExecutor) null, (FraudDetectionDataRepository) null, (PaymentAnalyticsRequestFactory) null, (FraudDetectionDataParamsUtils) null, (Set) null, (String) null, (String) null, 16380, (DefaultConstructorMarker) null), options, new DefaultCardAccountRangeStore(context3), new DefaultAnalyticsRequestExecutor(), new PaymentAnalyticsRequestFactory(context4, str, (Set) null, 4, (DefaultConstructorMarker) null));
    }

    private final void fireAnalyticsEvent(String str, PaymentAnalyticsEvent paymentAnalyticsEvent) {
        AnalyticsRequestExecutor analyticsRequestExecutor2 = this.analyticsRequestExecutor;
        Context context = this.appContext;
        Intrinsics.checkNotNullExpressionValue(context, "appContext");
        analyticsRequestExecutor2.executeAsync(PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(new PaymentAnalyticsRequestFactory(context, str, (Set) null, 4, (DefaultConstructorMarker) null), paymentAnalyticsEvent, (Set) null, (String) null, (Token.Type) null, (PaymentAnalyticsRequestFactory.ThreeDS2UiType) null, 30, (Object) null));
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/stripe/android/cards/DefaultCardAccountRangeRepositoryFactory$NullCardAccountRangeSource;", "Lcom/stripe/android/cards/CardAccountRangeSource;", "()V", "loading", "Lkotlinx/coroutines/flow/Flow;", "", "getLoading", "()Lkotlinx/coroutines/flow/Flow;", "getAccountRange", "Lcom/stripe/android/model/AccountRange;", "cardNumber", "Lcom/stripe/android/cards/CardNumber$Unvalidated;", "(Lcom/stripe/android/cards/CardNumber$Unvalidated;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultCardAccountRangeRepositoryFactory.kt */
    private static final class NullCardAccountRangeSource implements CardAccountRangeSource {
        private final Flow<Boolean> loading = FlowKt.flowOf(false);

        public Object getAccountRange(CardNumber.Unvalidated unvalidated, Continuation<? super AccountRange> continuation) {
            return null;
        }

        public Flow<Boolean> getLoading() {
            return this.loading;
        }
    }
}
