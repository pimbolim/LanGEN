package com.stripe.android.paymentsheet.repositories;

import com.stripe.android.PaymentConfiguration;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.ListPaymentMethodsParams;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.paymentsheet.PaymentSheet;
import java.util.List;
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

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "Lcom/stripe/android/model/PaymentMethod;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.repositories.CustomerApiRepository$getPaymentMethods$2$1$1$1", f = "CustomerApiRepository.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CustomerApiRepository.kt */
final class CustomerApiRepository$getPaymentMethods$2$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PaymentMethod>>, Object> {
    final /* synthetic */ PaymentSheet.CustomerConfiguration $customerConfig;
    final /* synthetic */ PaymentMethod.Type $paymentMethodType;
    int label;
    final /* synthetic */ CustomerApiRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerApiRepository$getPaymentMethods$2$1$1$1(CustomerApiRepository customerApiRepository, PaymentSheet.CustomerConfiguration customerConfiguration, PaymentMethod.Type type, Continuation<? super CustomerApiRepository$getPaymentMethods$2$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = customerApiRepository;
        this.$customerConfig = customerConfiguration;
        this.$paymentMethodType = type;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CustomerApiRepository$getPaymentMethods$2$1$1$1(this.this$0, this.$customerConfig, this.$paymentMethodType, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<PaymentMethod>> continuation) {
        return ((CustomerApiRepository$getPaymentMethods$2$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StripeRepository access$getStripeRepository$p = this.this$0.stripeRepository;
            ListPaymentMethodsParams listPaymentMethodsParams = new ListPaymentMethodsParams(this.$customerConfig.getId(), this.$paymentMethodType, (Integer) null, (String) null, (String) null, 28, (DefaultConstructorMarker) null);
            this.label = 1;
            obj = access$getStripeRepository$p.getPaymentMethods(listPaymentMethodsParams, ((PaymentConfiguration) this.this$0.lazyPaymentConfig.get()).getPublishableKey(), this.this$0.productUsageTokens, new ApiRequest.Options(this.$customerConfig.getEphemeralKeySecret(), ((PaymentConfiguration) this.this$0.lazyPaymentConfig.get()).getStripeAccountId(), (String) null, 4, (DefaultConstructorMarker) null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
