package com.stripe.android.paymentsheet.flowcontroller;

import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.flowcontroller.DefaultFlowController$dispatchResult$2", f = "DefaultFlowController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DefaultFlowController.kt */
final class DefaultFlowController$dispatchResult$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PaymentSheet.FlowController.ConfigCallback $callback;
    final /* synthetic */ FlowControllerInitializer.InitResult $result;
    int label;
    final /* synthetic */ DefaultFlowController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultFlowController$dispatchResult$2(FlowControllerInitializer.InitResult initResult, DefaultFlowController defaultFlowController, PaymentSheet.FlowController.ConfigCallback configCallback, Continuation<? super DefaultFlowController$dispatchResult$2> continuation) {
        super(2, continuation);
        this.$result = initResult;
        this.this$0 = defaultFlowController;
        this.$callback = configCallback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultFlowController$dispatchResult$2(this.$result, this.this$0, this.$callback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultFlowController$dispatchResult$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FlowControllerInitializer.InitResult initResult = this.$result;
            if (initResult instanceof FlowControllerInitializer.InitResult.Success) {
                this.this$0.onInitSuccess(((FlowControllerInitializer.InitResult.Success) initResult).getInitData(), this.$callback);
            } else if (initResult instanceof FlowControllerInitializer.InitResult.Failure) {
                this.$callback.onConfigured(false, ((FlowControllerInitializer.InitResult.Failure) initResult).getThrowable());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
