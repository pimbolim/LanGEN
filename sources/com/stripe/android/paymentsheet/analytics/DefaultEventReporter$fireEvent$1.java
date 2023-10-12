package com.stripe.android.paymentsheet.analytics;

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
@DebugMetadata(c = "com.stripe.android.paymentsheet.analytics.DefaultEventReporter$fireEvent$1", f = "DefaultEventReporter.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DefaultEventReporter.kt */
final class DefaultEventReporter$fireEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PaymentSheetEvent $event;
    int label;
    final /* synthetic */ DefaultEventReporter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultEventReporter$fireEvent$1(DefaultEventReporter defaultEventReporter, PaymentSheetEvent paymentSheetEvent, Continuation<? super DefaultEventReporter$fireEvent$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultEventReporter;
        this.$event = paymentSheetEvent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultEventReporter$fireEvent$1(this.this$0, this.$event, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultEventReporter$fireEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.deviceIdRepository.get(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.analyticsRequestExecutor.executeAsync(this.this$0.paymentAnalyticsRequestFactory.createRequest(this.$event.toString(), ((DeviceId) obj).getValue()));
        return Unit.INSTANCE;
    }
}
