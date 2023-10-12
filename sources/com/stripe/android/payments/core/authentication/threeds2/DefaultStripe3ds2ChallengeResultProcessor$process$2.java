package com.stripe.android.payments.core.authentication.threeds2;

import com.stripe.android.core.exception.StripeException;
import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.Source;
import com.stripe.android.model.Token;
import com.stripe.android.networking.PaymentAnalyticsEvent;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.payments.PaymentFlowResult;
import com.stripe.android.stripe3ds2.transaction.ChallengeResult;
import com.stripe.android.stripe3ds2.transactions.UiType;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/payments/PaymentFlowResult$Unvalidated;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.payments.core.authentication.threeds2.DefaultStripe3ds2ChallengeResultProcessor$process$2", f = "Stripe3ds2ChallengeResultProcessor.kt", i = {0}, l = {95}, m = "invokeSuspend", n = {"requestOptions"}, s = {"L$0"})
/* compiled from: Stripe3ds2ChallengeResultProcessor.kt */
final class DefaultStripe3ds2ChallengeResultProcessor$process$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PaymentFlowResult.Unvalidated>, Object> {
    final /* synthetic */ ChallengeResult $challengeResult;
    Object L$0;
    int label;
    final /* synthetic */ DefaultStripe3ds2ChallengeResultProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultStripe3ds2ChallengeResultProcessor$process$2(ChallengeResult challengeResult, DefaultStripe3ds2ChallengeResultProcessor defaultStripe3ds2ChallengeResultProcessor, Continuation<? super DefaultStripe3ds2ChallengeResultProcessor$process$2> continuation) {
        super(2, continuation);
        this.$challengeResult = challengeResult;
        this.this$0 = defaultStripe3ds2ChallengeResultProcessor;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultStripe3ds2ChallengeResultProcessor$process$2(this.$challengeResult, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PaymentFlowResult.Unvalidated> continuation) {
        return ((DefaultStripe3ds2ChallengeResultProcessor$process$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ApiRequest.Options options;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 1;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ChallengeResult challengeResult = this.$challengeResult;
            if (challengeResult instanceof ChallengeResult.Succeeded) {
                this.this$0.analyticsRequestExecutor.executeAsync(this.this$0.paymentAnalyticsRequestFactory.create3ds2Challenge$payments_core_release(PaymentAnalyticsEvent.Auth3ds2ChallengeCompleted, ((ChallengeResult.Succeeded) this.$challengeResult).getUiTypeCode()));
            } else if (challengeResult instanceof ChallengeResult.Failed) {
                this.this$0.analyticsRequestExecutor.executeAsync(this.this$0.paymentAnalyticsRequestFactory.create3ds2Challenge$payments_core_release(PaymentAnalyticsEvent.Auth3ds2ChallengeCompleted, ((ChallengeResult.Failed) this.$challengeResult).getUiTypeCode()));
            } else if (challengeResult instanceof ChallengeResult.Canceled) {
                this.this$0.analyticsRequestExecutor.executeAsync(this.this$0.paymentAnalyticsRequestFactory.create3ds2Challenge$payments_core_release(PaymentAnalyticsEvent.Auth3ds2ChallengeCanceled, ((ChallengeResult.Canceled) this.$challengeResult).getUiTypeCode()));
            } else if (challengeResult instanceof ChallengeResult.ProtocolError) {
                this.this$0.analyticsRequestExecutor.executeAsync(PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(this.this$0.paymentAnalyticsRequestFactory, PaymentAnalyticsEvent.Auth3ds2ChallengeErrored, (Set) null, (String) null, (Token.Type) null, (PaymentAnalyticsRequestFactory.ThreeDS2UiType) null, 30, (Object) null));
            } else if (challengeResult instanceof ChallengeResult.RuntimeError) {
                this.this$0.analyticsRequestExecutor.executeAsync(PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(this.this$0.paymentAnalyticsRequestFactory, PaymentAnalyticsEvent.Auth3ds2ChallengeErrored, (Set) null, (String) null, (Token.Type) null, (PaymentAnalyticsRequestFactory.ThreeDS2UiType) null, 30, (Object) null));
            } else if (challengeResult instanceof ChallengeResult.Timeout) {
                this.this$0.analyticsRequestExecutor.executeAsync(this.this$0.paymentAnalyticsRequestFactory.create3ds2Challenge$payments_core_release(PaymentAnalyticsEvent.Auth3ds2ChallengeTimedOut, ((ChallengeResult.Timeout) this.$challengeResult).getUiTypeCode()));
            }
            AnalyticsRequestExecutor access$getAnalyticsRequestExecutor$p = this.this$0.analyticsRequestExecutor;
            PaymentAnalyticsRequestFactory access$getPaymentAnalyticsRequestFactory$p = this.this$0.paymentAnalyticsRequestFactory;
            PaymentAnalyticsEvent paymentAnalyticsEvent = PaymentAnalyticsEvent.Auth3ds2ChallengePresented;
            UiType initialUiType = this.$challengeResult.getInitialUiType();
            String code = initialUiType == null ? null : initialUiType.getCode();
            if (code == null) {
                code = "";
            }
            access$getAnalyticsRequestExecutor$p.executeAsync(access$getPaymentAnalyticsRequestFactory$p.create3ds2Challenge$payments_core_release(paymentAnalyticsEvent, code));
            ApiRequest.Options options2 = new ApiRequest.Options(this.$challengeResult.getIntentData().getPublishableKey(), this.$challengeResult.getIntentData().getAccountId(), (String) null, 4, (DefaultConstructorMarker) null);
            this.L$0 = options2;
            this.label = 1;
            Object complete3ds2Auth$default = DefaultStripe3ds2ChallengeResultProcessor.complete3ds2Auth$default(this.this$0, this.$challengeResult, options2, 0, this, 4, (Object) null);
            if (complete3ds2Auth$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            options = options2;
            obj = complete3ds2Auth$default;
        } else if (i == 1) {
            options = (ApiRequest.Options) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            ChallengeResult challengeResult2 = this.$challengeResult;
            if (!(challengeResult2 instanceof ChallengeResult.Succeeded)) {
                if (!(challengeResult2 instanceof ChallengeResult.Failed)) {
                    if (challengeResult2 instanceof ChallengeResult.Canceled) {
                        i2 = 3;
                    } else if (!(challengeResult2 instanceof ChallengeResult.ProtocolError) && !(challengeResult2 instanceof ChallengeResult.RuntimeError)) {
                        if (challengeResult2 instanceof ChallengeResult.Timeout) {
                            i2 = 4;
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                }
            }
            return new PaymentFlowResult.Unvalidated(this.$challengeResult.getIntentData().getClientSecret(), i2, (StripeException) null, false, (String) null, (Source) null, options.getStripeAccount(), 60, (DefaultConstructorMarker) null);
        }
        i2 = 2;
        return new PaymentFlowResult.Unvalidated(this.$challengeResult.getIntentData().getClientSecret(), i2, (StripeException) null, false, (String) null, (Source) null, options.getStripeAccount(), 60, (DefaultConstructorMarker) null);
    }
}
