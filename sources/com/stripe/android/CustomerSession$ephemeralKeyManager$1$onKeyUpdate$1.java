package com.stripe.android;

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
@DebugMetadata(c = "com.stripe.android.CustomerSession$ephemeralKeyManager$1$onKeyUpdate$1", f = "CustomerSession.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CustomerSession.kt */
final class CustomerSession$ephemeralKeyManager$1$onKeyUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EphemeralKey $ephemeralKey;
    final /* synthetic */ EphemeralOperation $operation;
    int label;
    final /* synthetic */ CustomerSession this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerSession$ephemeralKeyManager$1$onKeyUpdate$1(CustomerSession customerSession, EphemeralKey ephemeralKey, EphemeralOperation ephemeralOperation, Continuation<? super CustomerSession$ephemeralKeyManager$1$onKeyUpdate$1> continuation) {
        super(2, continuation);
        this.this$0 = customerSession;
        this.$ephemeralKey = ephemeralKey;
        this.$operation = ephemeralOperation;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CustomerSession$ephemeralKeyManager$1$onKeyUpdate$1(this.this$0, this.$ephemeralKey, this.$operation, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CustomerSession$ephemeralKeyManager$1$onKeyUpdate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.operationExecutor.execute$payments_core_release(this.$ephemeralKey, this.$operation, this) == coroutine_suspended) {
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
