package com.stripe.android;

import com.stripe.android.CustomerSession;
import com.stripe.android.model.PaymentMethod;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.CustomerSessionOperationExecutor$execute$5", f = "CustomerSessionOperationExecutor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CustomerSessionOperationExecutor.kt */
final class CustomerSessionOperationExecutor$execute$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EphemeralOperation $operation;
    final /* synthetic */ Object $result;
    int label;
    final /* synthetic */ CustomerSessionOperationExecutor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerSessionOperationExecutor$execute$5(CustomerSessionOperationExecutor customerSessionOperationExecutor, EphemeralOperation ephemeralOperation, Object obj, Continuation<? super CustomerSessionOperationExecutor$execute$5> continuation) {
        super(2, continuation);
        this.this$0 = customerSessionOperationExecutor;
        this.$operation = ephemeralOperation;
        this.$result = obj;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CustomerSessionOperationExecutor$execute$5(this.this$0, this.$operation, this.$result, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CustomerSessionOperationExecutor$execute$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CustomerSession.PaymentMethodRetrievalListener paymentMethodRetrievalListener = (CustomerSession.PaymentMethodRetrievalListener) this.this$0.getListener(this.$operation.getId$payments_core_release());
            Object obj2 = this.$result;
            CustomerSessionOperationExecutor customerSessionOperationExecutor = this.this$0;
            Throwable r2 = Result.m4712exceptionOrNullimpl(obj2);
            if (r2 == null) {
                PaymentMethod paymentMethod = (PaymentMethod) obj2;
                if (paymentMethodRetrievalListener == null) {
                    return null;
                }
                paymentMethodRetrievalListener.onPaymentMethodRetrieved(paymentMethod);
                return Unit.INSTANCE;
            }
            customerSessionOperationExecutor.onError(paymentMethodRetrievalListener, r2);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
