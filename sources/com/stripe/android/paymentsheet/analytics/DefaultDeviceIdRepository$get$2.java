package com.stripe.android.paymentsheet.analytics;

import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/paymentsheet/analytics/DeviceId;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.analytics.DefaultDeviceIdRepository$get$2", f = "DefaultDeviceIdRepository.kt", i = {0}, l = {55}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
/* compiled from: DefaultDeviceIdRepository.kt */
final class DefaultDeviceIdRepository$get$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DeviceId>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DefaultDeviceIdRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultDeviceIdRepository$get$2(DefaultDeviceIdRepository defaultDeviceIdRepository, Continuation<? super DefaultDeviceIdRepository$get$2> continuation) {
        super(2, continuation);
        this.this$0 = defaultDeviceIdRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultDeviceIdRepository$get$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super DeviceId> continuation) {
        return ((DefaultDeviceIdRepository$get$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        DefaultDeviceIdRepository defaultDeviceIdRepository;
        DeviceId deviceId;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.this$0.mutex;
            DefaultDeviceIdRepository defaultDeviceIdRepository2 = this.this$0;
            this.L$0 = mutex;
            this.L$1 = defaultDeviceIdRepository2;
            this.label = 1;
            if (mutex.lock((Object) null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            defaultDeviceIdRepository = defaultDeviceIdRepository2;
        } else if (i == 1) {
            defaultDeviceIdRepository = (DefaultDeviceIdRepository) this.L$1;
            mutex = (Mutex) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            String string = defaultDeviceIdRepository.getPrefs().getString(PaymentAnalyticsRequestFactory.FIELD_DEVICE_ID, (String) null);
            if (string != null) {
                deviceId = new DeviceId(string);
            } else {
                deviceId = defaultDeviceIdRepository.createDeviceId();
            }
            return deviceId;
        } finally {
            mutex.unlock((Object) null);
        }
    }
}
