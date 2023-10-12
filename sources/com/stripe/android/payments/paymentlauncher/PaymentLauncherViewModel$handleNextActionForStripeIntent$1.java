package com.stripe.android.payments.paymentlauncher;

import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.StripeIntent;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.payments.core.authentication.PaymentAuthenticator;
import com.stripe.android.payments.paymentlauncher.PaymentResult;
import com.stripe.android.view.AuthActivityStarterHost;
import java.util.List;
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
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.payments.paymentlauncher.PaymentLauncherViewModel$handleNextActionForStripeIntent$1", f = "PaymentLauncherViewModel.kt", i = {}, l = {171, 180}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PaymentLauncherViewModel.kt */
final class PaymentLauncherViewModel$handleNextActionForStripeIntent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $clientSecret;
    final /* synthetic */ AuthActivityStarterHost $host;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PaymentLauncherViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentLauncherViewModel$handleNextActionForStripeIntent$1(PaymentLauncherViewModel paymentLauncherViewModel, String str, AuthActivityStarterHost authActivityStarterHost, Continuation<? super PaymentLauncherViewModel$handleNextActionForStripeIntent$1> continuation) {
        super(2, continuation);
        this.this$0 = paymentLauncherViewModel;
        this.$clientSecret = str;
        this.$host = authActivityStarterHost;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PaymentLauncherViewModel$handleNextActionForStripeIntent$1 paymentLauncherViewModel$handleNextActionForStripeIntent$1 = new PaymentLauncherViewModel$handleNextActionForStripeIntent$1(this.this$0, this.$clientSecret, this.$host, continuation);
        paymentLauncherViewModel$handleNextActionForStripeIntent$1.L$0 = obj;
        return paymentLauncherViewModel$handleNextActionForStripeIntent$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PaymentLauncherViewModel$handleNextActionForStripeIntent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            this.this$0.savedStateHandle.set(PaymentLauncherViewModel.KEY_HAS_STARTED, Boxing.boxBoolean(true));
            PaymentLauncherViewModel paymentLauncherViewModel = this.this$0;
            String str = this.$clientSecret;
            Result.Companion companion = Result.Companion;
            StripeRepository access$getStripeApiRepository$p = paymentLauncherViewModel.stripeApiRepository;
            Object obj3 = paymentLauncherViewModel.apiRequestOptionsProvider.get();
            Intrinsics.checkNotNullExpressionValue(obj3, "apiRequestOptionsProvider.get()");
            this.label = 1;
            obj = StripeRepository.retrieveStripeIntent$payments_core_release$default(access$getStripeApiRepository$p, str, (ApiRequest.Options) obj3, (List) null, this, 4, (Object) null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
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
        if (obj != null) {
            obj2 = Result.m4709constructorimpl((StripeIntent) obj);
            PaymentLauncherViewModel paymentLauncherViewModel2 = this.this$0;
            AuthActivityStarterHost authActivityStarterHost = this.$host;
            Throwable r5 = Result.m4712exceptionOrNullimpl(obj2);
            if (r5 == null) {
                StripeIntent stripeIntent = (StripeIntent) obj2;
                PaymentAuthenticator authenticator = paymentLauncherViewModel2.authenticatorRegistry.getAuthenticator(stripeIntent);
                Object obj4 = paymentLauncherViewModel2.apiRequestOptionsProvider.get();
                Intrinsics.checkNotNullExpressionValue(obj4, "apiRequestOptionsProvider.get()");
                this.label = 2;
                if (authenticator.authenticate(authActivityStarterHost, stripeIntent, (ApiRequest.Options) obj4, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                paymentLauncherViewModel2.getPaymentLauncherResult$payments_core_release().postValue(new PaymentResult.Failed(r5));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
