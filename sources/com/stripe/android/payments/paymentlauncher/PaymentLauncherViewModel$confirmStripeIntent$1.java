package com.stripe.android.payments.paymentlauncher;

import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.ConfirmStripeIntentParams;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.payments.core.authentication.PaymentAuthenticator;
import com.stripe.android.payments.paymentlauncher.PaymentResult;
import com.stripe.android.view.AuthActivityStarterHost;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.payments.paymentlauncher.PaymentLauncherViewModel$confirmStripeIntent$1", f = "PaymentLauncherViewModel.kt", i = {0}, l = {110, 120}, m = "invokeSuspend", n = {"returnUrl"}, s = {"L$0"})
/* compiled from: PaymentLauncherViewModel.kt */
final class PaymentLauncherViewModel$confirmStripeIntent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ConfirmStripeIntentParams $confirmStripeIntentParams;
    final /* synthetic */ AuthActivityStarterHost $host;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PaymentLauncherViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentLauncherViewModel$confirmStripeIntent$1(PaymentLauncherViewModel paymentLauncherViewModel, ConfirmStripeIntentParams confirmStripeIntentParams, AuthActivityStarterHost authActivityStarterHost, Continuation<? super PaymentLauncherViewModel$confirmStripeIntent$1> continuation) {
        super(2, continuation);
        this.this$0 = paymentLauncherViewModel;
        this.$confirmStripeIntentParams = confirmStripeIntentParams;
        this.$host = authActivityStarterHost;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PaymentLauncherViewModel$confirmStripeIntent$1 paymentLauncherViewModel$confirmStripeIntent$1 = new PaymentLauncherViewModel$confirmStripeIntent$1(this.this$0, this.$confirmStripeIntentParams, this.$host, continuation);
        paymentLauncherViewModel$confirmStripeIntent$1.L$0 = obj;
        return paymentLauncherViewModel$confirmStripeIntent$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PaymentLauncherViewModel$confirmStripeIntent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        String str;
        String id;
        String returnUrl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            this.this$0.savedStateHandle.set(PaymentLauncherViewModel.KEY_HAS_STARTED, Boxing.boxBoolean(true));
            this.this$0.logReturnUrl(this.$confirmStripeIntentParams.getReturnUrl());
            if (this.this$0.isInstantApp) {
                returnUrl = this.$confirmStripeIntentParams.getReturnUrl();
            } else {
                returnUrl = this.$confirmStripeIntentParams.getReturnUrl();
                CharSequence charSequence = returnUrl;
                if (charSequence == null || StringsKt.isBlank(charSequence)) {
                    returnUrl = null;
                }
                if (returnUrl == null) {
                    returnUrl = this.this$0.defaultReturnUrl.getValue();
                }
            }
            str = returnUrl;
            PaymentLauncherViewModel paymentLauncherViewModel = this.this$0;
            ConfirmStripeIntentParams confirmStripeIntentParams = this.$confirmStripeIntentParams;
            Result.Companion companion = Result.Companion;
            this.L$0 = str;
            this.label = 1;
            obj = paymentLauncherViewModel.confirmIntent(confirmStripeIntentParams, str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            str = (String) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m4709constructorimpl((StripeIntent) obj);
        PaymentLauncherViewModel paymentLauncherViewModel2 = this.this$0;
        AuthActivityStarterHost authActivityStarterHost = this.$host;
        Throwable r6 = Result.m4712exceptionOrNullimpl(obj2);
        if (r6 == null) {
            StripeIntent stripeIntent = (StripeIntent) obj2;
            StripeIntent.NextActionData nextActionData = stripeIntent.getNextActionData();
            if (!(nextActionData == null || !(nextActionData instanceof StripeIntent.NextActionData.SdkData.Use3DS1) || (id = stripeIntent.getId()) == null)) {
                Map access$getThreeDs1IntentReturnUrlMap$p = paymentLauncherViewModel2.threeDs1IntentReturnUrlMap;
                if (str == null) {
                    str = "";
                }
                access$getThreeDs1IntentReturnUrlMap$p.put(id, str);
            }
            PaymentAuthenticator authenticator = paymentLauncherViewModel2.authenticatorRegistry.getAuthenticator(stripeIntent);
            Object obj3 = paymentLauncherViewModel2.apiRequestOptionsProvider.get();
            Intrinsics.checkNotNullExpressionValue(obj3, "apiRequestOptionsProvider.get()");
            this.L$0 = null;
            this.label = 2;
            if (authenticator.authenticate(authActivityStarterHost, stripeIntent, (ApiRequest.Options) obj3, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            paymentLauncherViewModel2.getPaymentLauncherResult$payments_core_release().postValue(new PaymentResult.Failed(r6));
        }
        return Unit.INSTANCE;
    }
}
