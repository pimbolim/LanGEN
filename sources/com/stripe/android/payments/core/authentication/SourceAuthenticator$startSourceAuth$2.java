package com.stripe.android.payments.core.authentication;

import com.stripe.android.PaymentBrowserAuthStarter;
import com.stripe.android.StripePaymentController;
import com.stripe.android.auth.PaymentBrowserAuthContract;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.Source;
import com.stripe.android.model.Token;
import com.stripe.android.networking.PaymentAnalyticsEvent;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.stripe3ds2.init.ui.StripeToolbarCustomization;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.payments.core.authentication.SourceAuthenticator$startSourceAuth$2", f = "SourceAuthenticator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SourceAuthenticator.kt */
final class SourceAuthenticator$startSourceAuth$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PaymentBrowserAuthStarter $paymentBrowserAuthStarter;
    final /* synthetic */ ApiRequest.Options $requestOptions;
    final /* synthetic */ Source $source;
    int label;
    final /* synthetic */ SourceAuthenticator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SourceAuthenticator$startSourceAuth$2(SourceAuthenticator sourceAuthenticator, PaymentBrowserAuthStarter paymentBrowserAuthStarter, Source source, ApiRequest.Options options, Continuation<SourceAuthenticator$startSourceAuth$2> continuation) {
        super(2, continuation);
        this.this$0 = sourceAuthenticator;
        this.$paymentBrowserAuthStarter = paymentBrowserAuthStarter;
        this.$source = source;
        this.$requestOptions = options;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SourceAuthenticator$startSourceAuth$2(this.this$0, this.$paymentBrowserAuthStarter, this.$source, this.$requestOptions, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<Unit> continuation) {
        return ((SourceAuthenticator$startSourceAuth$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.analyticsRequestExecutor.executeAsync(PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(this.this$0.paymentAnalyticsRequestFactory, PaymentAnalyticsEvent.AuthSourceRedirect, (Set) null, (String) null, (Token.Type) null, (PaymentAnalyticsRequestFactory.ThreeDS2UiType) null, 30, (Object) null));
            PaymentBrowserAuthStarter paymentBrowserAuthStarter = this.$paymentBrowserAuthStarter;
            String id = this.$source.getId();
            String str3 = id == null ? "" : id;
            String clientSecret = this.$source.getClientSecret();
            if (clientSecret == null) {
                str = "";
            } else {
                str = clientSecret;
            }
            Source.Redirect redirect = this.$source.getRedirect();
            String str4 = null;
            String url = redirect == null ? null : redirect.getUrl();
            if (url == null) {
                str2 = "";
            } else {
                str2 = url;
            }
            Source.Redirect redirect2 = this.$source.getRedirect();
            if (redirect2 != null) {
                str4 = redirect2.getReturnUrl();
            }
            PaymentBrowserAuthContract.Args args = r2;
            PaymentBrowserAuthContract.Args args2 = new PaymentBrowserAuthContract.Args(str3, StripePaymentController.SOURCE_REQUEST_CODE, str, str2, str4, this.this$0.enableLogging, (StripeToolbarCustomization) null, this.$requestOptions.getStripeAccount(), false, false, (Integer) null, (String) this.this$0.publishableKeyProvider.invoke(), this.this$0.isInstantApp, 1856, (DefaultConstructorMarker) null);
            paymentBrowserAuthStarter.start(args);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
