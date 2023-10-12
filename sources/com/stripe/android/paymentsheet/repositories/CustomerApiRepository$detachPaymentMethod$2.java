package com.stripe.android.paymentsheet.repositories;

import com.stripe.android.PaymentConfiguration;
import com.stripe.android.core.Logger;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.networking.StripeRepository;
import com.stripe.android.paymentsheet.PaymentSheet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.apache.commons.lang3.ClassUtils;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/model/PaymentMethod;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.repositories.CustomerApiRepository$detachPaymentMethod$2", f = "CustomerApiRepository.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CustomerApiRepository.kt */
final class CustomerApiRepository$detachPaymentMethod$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PaymentMethod>, Object> {
    final /* synthetic */ PaymentSheet.CustomerConfiguration $customerConfig;
    final /* synthetic */ String $paymentMethodId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CustomerApiRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerApiRepository$detachPaymentMethod$2(CustomerApiRepository customerApiRepository, String str, PaymentSheet.CustomerConfiguration customerConfiguration, Continuation<? super CustomerApiRepository$detachPaymentMethod$2> continuation) {
        super(2, continuation);
        this.this$0 = customerApiRepository;
        this.$paymentMethodId = str;
        this.$customerConfig = customerConfiguration;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CustomerApiRepository$detachPaymentMethod$2 customerApiRepository$detachPaymentMethod$2 = new CustomerApiRepository$detachPaymentMethod$2(this.this$0, this.$paymentMethodId, this.$customerConfig, continuation);
        customerApiRepository$detachPaymentMethod$2.L$0 = obj;
        return customerApiRepository$detachPaymentMethod$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PaymentMethod> continuation) {
        return ((CustomerApiRepository$detachPaymentMethod$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            CustomerApiRepository customerApiRepository = this.this$0;
            String str = this.$paymentMethodId;
            PaymentSheet.CustomerConfiguration customerConfiguration = this.$customerConfig;
            Result.Companion companion = Result.Companion;
            StripeRepository access$getStripeRepository$p = customerApiRepository.stripeRepository;
            String publishableKey = ((PaymentConfiguration) customerApiRepository.lazyPaymentConfig.get()).getPublishableKey();
            Set access$getProductUsageTokens$p = customerApiRepository.productUsageTokens;
            ApiRequest.Options options = new ApiRequest.Options(customerConfiguration.getEphemeralKeySecret(), ((PaymentConfiguration) customerApiRepository.lazyPaymentConfig.get()).getStripeAccountId(), (String) null, 4, (DefaultConstructorMarker) null);
            this.label = 1;
            obj = access$getStripeRepository$p.detachPaymentMethod(publishableKey, access$getProductUsageTokens$p, str, options, this);
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
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m4709constructorimpl((PaymentMethod) obj);
        CustomerApiRepository customerApiRepository2 = this.this$0;
        String str2 = this.$paymentMethodId;
        Throwable r2 = Result.m4712exceptionOrNullimpl(obj2);
        if (r2 != null) {
            Logger access$getLogger$p = customerApiRepository2.logger;
            access$getLogger$p.error("Failed to detach payment method " + str2 + ClassUtils.PACKAGE_SEPARATOR_CHAR, r2);
        }
        if (Result.m4715isFailureimpl(obj2)) {
            return null;
        }
        return obj2;
    }
}
