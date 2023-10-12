package com.stripe.android.googlepaylauncher;

import androidx.lifecycle.LiveDataScope;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.model.PaymentMethodCreateParams;
import com.stripe.android.networking.StripeRepository;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/Result;", "Lcom/stripe/android/model/PaymentMethod;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.googlepaylauncher.StripeGooglePayViewModel$createPaymentMethod$1", f = "StripeGooglePayViewModel.kt", i = {}, l = {74}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: StripeGooglePayViewModel.kt */
final class StripeGooglePayViewModel$createPaymentMethod$1 extends SuspendLambda implements Function2<LiveDataScope<Result<? extends PaymentMethod>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ PaymentMethodCreateParams $params;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StripeGooglePayViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeGooglePayViewModel$createPaymentMethod$1(StripeGooglePayViewModel stripeGooglePayViewModel, PaymentMethodCreateParams paymentMethodCreateParams, Continuation<? super StripeGooglePayViewModel$createPaymentMethod$1> continuation) {
        super(2, continuation);
        this.this$0 = stripeGooglePayViewModel;
        this.$params = paymentMethodCreateParams;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        StripeGooglePayViewModel$createPaymentMethod$1 stripeGooglePayViewModel$createPaymentMethod$1 = new StripeGooglePayViewModel$createPaymentMethod$1(this.this$0, this.$params, continuation);
        stripeGooglePayViewModel$createPaymentMethod$1.L$0 = obj;
        return stripeGooglePayViewModel$createPaymentMethod$1;
    }

    public final Object invoke(LiveDataScope<Result<PaymentMethod>> liveDataScope, Continuation<? super Unit> continuation) {
        return ((StripeGooglePayViewModel$createPaymentMethod$1) create(liveDataScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.stripe.android.googlepaylauncher.StripeGooglePayViewModel$createPaymentMethod$1$1", f = "StripeGooglePayViewModel.kt", i = {}, l = {78, 75}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stripe.android.googlepaylauncher.StripeGooglePayViewModel$createPaymentMethod$1$1  reason: invalid class name */
    /* compiled from: StripeGooglePayViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(liveDataScope, stripeGooglePayViewModel, paymentMethodCreateParams, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            LiveDataScope<Result<PaymentMethod>> liveDataScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                liveDataScope = liveDataScope;
                StripeGooglePayViewModel stripeGooglePayViewModel = stripeGooglePayViewModel;
                PaymentMethodCreateParams paymentMethodCreateParams = paymentMethodCreateParams;
                Result.Companion companion = Result.Companion;
                StripeRepository access$getStripeRepository$p = stripeGooglePayViewModel.stripeRepository;
                ApiRequest.Options options = new ApiRequest.Options(stripeGooglePayViewModel.publishableKey, stripeGooglePayViewModel.stripeAccountId, (String) null, 4, (DefaultConstructorMarker) null);
                this.L$0 = liveDataScope;
                this.label = 1;
                obj = access$getStripeRepository$p.createPaymentMethod(paymentMethodCreateParams, options, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                liveDataScope = (LiveDataScope) this.L$0;
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
                obj2 = Result.m4709constructorimpl((PaymentMethod) obj);
                this.L$0 = null;
                this.label = 2;
                if (liveDataScope.emit(Result.m4708boximpl(obj2), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final LiveDataScope liveDataScope = (LiveDataScope) this.L$0;
            CoroutineContext access$getWorkContext$p = this.this$0.workContext;
            final StripeGooglePayViewModel stripeGooglePayViewModel = this.this$0;
            final PaymentMethodCreateParams paymentMethodCreateParams = this.$params;
            this.label = 1;
            if (BuildersKt.withContext(access$getWorkContext$p, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
