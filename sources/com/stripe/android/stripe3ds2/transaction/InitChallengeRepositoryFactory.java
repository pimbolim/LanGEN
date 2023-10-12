package com.stripe.android.stripe3ds2.transaction;

import android.app.Application;
import com.stripe.android.stripe3ds2.init.ui.StripeUiCustomization;
import com.stripe.android.stripe3ds2.observability.DefaultErrorReporter;
import com.stripe.android.stripe3ds2.observability.ErrorReporter;
import com.stripe.android.stripe3ds2.observability.SentryConfig;
import com.stripe.android.stripe3ds2.observability.Stripe3ds2ErrorReporterConfig;
import com.stripe.android.stripe3ds2.security.DefaultMessageTransformer;
import com.stripe.android.stripe3ds2.transaction.StripeErrorRequestExecutor;
import java.security.cert.X509Certificate;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/stripe3ds2/transaction/InitChallengeRepositoryFactory;", "", "application", "Landroid/app/Application;", "isLiveMode", "", "sdkTransactionId", "Lcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;", "uiCustomization", "Lcom/stripe/android/stripe3ds2/init/ui/StripeUiCustomization;", "rootCerts", "", "Ljava/security/cert/X509Certificate;", "enableLogging", "workContext", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/app/Application;ZLcom/stripe/android/stripe3ds2/transaction/SdkTransactionId;Lcom/stripe/android/stripe3ds2/init/ui/StripeUiCustomization;Ljava/util/List;ZLkotlin/coroutines/CoroutineContext;)V", "create", "Lcom/stripe/android/stripe3ds2/transaction/InitChallengeRepository;", "3ds2sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InitChallengeRepository.kt */
public final class InitChallengeRepositoryFactory {
    private final Application application;
    private final boolean enableLogging;
    private final boolean isLiveMode;
    private final List<X509Certificate> rootCerts;
    private final SdkTransactionId sdkTransactionId;
    private final StripeUiCustomization uiCustomization;
    private final CoroutineContext workContext;

    public InitChallengeRepositoryFactory(Application application2, boolean z, SdkTransactionId sdkTransactionId2, StripeUiCustomization stripeUiCustomization, List<? extends X509Certificate> list, boolean z2, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(application2, "application");
        Intrinsics.checkNotNullParameter(sdkTransactionId2, "sdkTransactionId");
        Intrinsics.checkNotNullParameter(stripeUiCustomization, "uiCustomization");
        Intrinsics.checkNotNullParameter(list, "rootCerts");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        this.application = application2;
        this.isLiveMode = z;
        this.sdkTransactionId = sdkTransactionId2;
        this.uiCustomization = stripeUiCustomization;
        this.rootCerts = list;
        this.enableLogging = z2;
        this.workContext = coroutineContext;
    }

    public final InitChallengeRepository create() {
        Logger logger = Logger.Companion.get(this.enableLogging);
        ErrorReporter defaultErrorReporter = new DefaultErrorReporter(this.application, new Stripe3ds2ErrorReporterConfig(this.sdkTransactionId), this.workContext, logger, (SentryConfig) null, (String) null, (String) null, 0, 240, (DefaultConstructorMarker) null);
        return new DefaultInitChallengeRepository(this.sdkTransactionId, new MessageVersionRegistry(), new DefaultJwsValidator(this.isLiveMode, this.rootCerts, defaultErrorReporter), new DefaultMessageTransformer(this.isLiveMode), new DefaultAcsDataParser(defaultErrorReporter), new DefaultChallengeRequestResultRepository(defaultErrorReporter, this.workContext), new StripeErrorRequestExecutor.Factory(this.workContext), this.uiCustomization, defaultErrorReporter, logger);
    }
}
