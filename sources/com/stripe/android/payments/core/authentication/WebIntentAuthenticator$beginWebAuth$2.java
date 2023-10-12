package com.stripe.android.payments.core.authentication;

import com.drew.metadata.photoshop.PhotoshopDirectory;
import com.stripe.android.PaymentBrowserAuthStarter;
import com.stripe.android.auth.PaymentBrowserAuthContract;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.stripe3ds2.init.ui.StripeToolbarCustomization;
import com.stripe.android.view.AuthActivityStarterHost;
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
@DebugMetadata(c = "com.stripe.android.payments.core.authentication.WebIntentAuthenticator$beginWebAuth$2", f = "WebIntentAuthenticator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: WebIntentAuthenticator.kt */
final class WebIntentAuthenticator$beginWebAuth$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $authUrl;
    final /* synthetic */ String $clientSecret;
    final /* synthetic */ AuthActivityStarterHost $host;
    final /* synthetic */ int $requestCode;
    final /* synthetic */ String $returnUrl;
    final /* synthetic */ boolean $shouldCancelIntentOnUserNavigation;
    final /* synthetic */ boolean $shouldCancelSource;
    final /* synthetic */ String $stripeAccount;
    final /* synthetic */ StripeIntent $stripeIntent;
    int label;
    final /* synthetic */ WebIntentAuthenticator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebIntentAuthenticator$beginWebAuth$2(WebIntentAuthenticator webIntentAuthenticator, AuthActivityStarterHost authActivityStarterHost, StripeIntent stripeIntent, int i, String str, String str2, String str3, String str4, boolean z, boolean z2, Continuation<WebIntentAuthenticator$beginWebAuth$2> continuation) {
        super(2, continuation);
        this.this$0 = webIntentAuthenticator;
        this.$host = authActivityStarterHost;
        this.$stripeIntent = stripeIntent;
        this.$requestCode = i;
        this.$clientSecret = str;
        this.$authUrl = str2;
        this.$returnUrl = str3;
        this.$stripeAccount = str4;
        this.$shouldCancelSource = z;
        this.$shouldCancelIntentOnUserNavigation = z2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebIntentAuthenticator$beginWebAuth$2(this.this$0, this.$host, this.$stripeIntent, this.$requestCode, this.$clientSecret, this.$authUrl, this.$returnUrl, this.$stripeAccount, this.$shouldCancelSource, this.$shouldCancelIntentOnUserNavigation, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<Unit> continuation) {
        return ((WebIntentAuthenticator$beginWebAuth$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            PaymentBrowserAuthStarter paymentBrowserAuthStarter = (PaymentBrowserAuthStarter) this.this$0.paymentBrowserAuthStarterFactory.invoke(this.$host);
            String id = this.$stripeIntent.getId();
            if (id == null) {
                id = "";
            }
            PaymentBrowserAuthContract.Args args = r2;
            PaymentBrowserAuthContract.Args args2 = new PaymentBrowserAuthContract.Args(id, this.$requestCode, this.$clientSecret, this.$authUrl, this.$returnUrl, this.this$0.enableLogging, (StripeToolbarCustomization) null, this.$stripeAccount, this.$shouldCancelSource, this.$shouldCancelIntentOnUserNavigation, (Integer) null, (String) this.this$0.publishableKeyProvider.invoke(), this.this$0.isInstantApp, PhotoshopDirectory.TAG_PATH_SELECTION_STATE, (DefaultConstructorMarker) null);
            paymentBrowserAuthStarter.start(args);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
