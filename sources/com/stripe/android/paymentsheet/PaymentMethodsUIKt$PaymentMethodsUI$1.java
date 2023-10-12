package com.stripe.android.paymentsheet;

import androidx.compose.foundation.lazy.LazyListState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.PaymentMethodsUIKt$PaymentMethodsUI$1", f = "PaymentMethodsUI.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PaymentMethodsUI.kt */
final class PaymentMethodsUIKt$PaymentMethodsUI$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isEnabled;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ LazyListState $state;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentMethodsUIKt$PaymentMethodsUI$1(boolean z, LazyListState lazyListState, CoroutineScope coroutineScope, Continuation<? super PaymentMethodsUIKt$PaymentMethodsUI$1> continuation) {
        super(2, continuation);
        this.$isEnabled = z;
        this.$state = lazyListState;
        this.$scope = coroutineScope;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaymentMethodsUIKt$PaymentMethodsUI$1(this.$isEnabled, this.$state, this.$scope, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PaymentMethodsUIKt$PaymentMethodsUI$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$isEnabled) {
                LazyListEnabableKt.reenableScrolling(this.$state, this.$scope);
            } else {
                LazyListEnabableKt.disableScrolling(this.$state, this.$scope);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
