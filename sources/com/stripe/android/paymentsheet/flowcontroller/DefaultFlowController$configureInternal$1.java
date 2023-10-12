package com.stripe.android.paymentsheet.flowcontroller;

import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.model.ClientSecret;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.flowcontroller.DefaultFlowController$configureInternal$1", f = "DefaultFlowController.kt", i = {0, 1, 1}, l = {194, 200, 203}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "result"}, s = {"L$0", "L$0", "L$1"})
/* compiled from: DefaultFlowController.kt */
final class DefaultFlowController$configureInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PaymentSheet.FlowController.ConfigCallback $callback;
    final /* synthetic */ ClientSecret $clientSecret;
    final /* synthetic */ PaymentSheet.Configuration $configuration;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DefaultFlowController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultFlowController$configureInternal$1(DefaultFlowController defaultFlowController, ClientSecret clientSecret, PaymentSheet.Configuration configuration, PaymentSheet.FlowController.ConfigCallback configCallback, Continuation<? super DefaultFlowController$configureInternal$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultFlowController;
        this.$clientSecret = clientSecret;
        this.$configuration = configuration;
        this.$callback = configCallback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DefaultFlowController$configureInternal$1 defaultFlowController$configureInternal$1 = new DefaultFlowController$configureInternal$1(this.this$0, this.$clientSecret, this.$configuration, this.$callback, continuation);
        defaultFlowController$configureInternal$1.L$0 = obj;
        return defaultFlowController$configureInternal$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DefaultFlowController$configureInternal$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 == r4) goto L_0x002a
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x008f
        L_0x0016:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x001e:
            java.lang.Object r1 = r9.L$1
            com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer$InitResult r1 = (com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer.InitResult) r1
            java.lang.Object r3 = r9.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x006e
        L_0x002a:
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0054
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            com.stripe.android.paymentsheet.flowcontroller.DefaultFlowController r1 = r9.this$0
            com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer r1 = r1.flowControllerInitializer
            com.stripe.android.paymentsheet.model.ClientSecret r5 = r9.$clientSecret
            com.stripe.android.paymentsheet.PaymentSheet$Configuration r6 = r9.$configuration
            r7 = r9
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r9.L$0 = r10
            r9.label = r4
            java.lang.Object r1 = r1.init(r5, r6, r7)
            if (r1 != r0) goto L_0x0051
            return r0
        L_0x0051:
            r8 = r1
            r1 = r10
            r10 = r8
        L_0x0054:
            com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer$InitResult r10 = (com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer.InitResult) r10
            com.stripe.android.paymentsheet.flowcontroller.DefaultFlowController r4 = r9.this$0
            com.stripe.android.ui.core.forms.resources.ResourceRepository r4 = r4.resourceRepository
            r5 = r9
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r9.L$0 = r1
            r9.L$1 = r10
            r9.label = r3
            java.lang.Object r3 = r4.waitUntilLoaded(r5)
            if (r3 != r0) goto L_0x006c
            return r0
        L_0x006c:
            r3 = r1
            r1 = r10
        L_0x006e:
            boolean r10 = kotlinx.coroutines.CoroutineScopeKt.isActive(r3)
            r3 = 0
            if (r10 == 0) goto L_0x0089
            com.stripe.android.paymentsheet.flowcontroller.DefaultFlowController r10 = r9.this$0
            com.stripe.android.paymentsheet.PaymentSheet$FlowController$ConfigCallback r4 = r9.$callback
            r5 = r9
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r9.L$0 = r3
            r9.L$1 = r3
            r9.label = r2
            java.lang.Object r10 = r10.dispatchResult(r1, r4, r5)
            if (r10 != r0) goto L_0x008f
            return r0
        L_0x0089:
            com.stripe.android.paymentsheet.PaymentSheet$FlowController$ConfigCallback r10 = r9.$callback
            r0 = 0
            r10.onConfigured(r0, r3)
        L_0x008f:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.flowcontroller.DefaultFlowController$configureInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
