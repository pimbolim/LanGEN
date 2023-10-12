package com.stripe.android.paymentsheet.flowcontroller;

import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer;
import com.stripe.android.paymentsheet.model.ClientSecret;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/paymentsheet/flowcontroller/FlowControllerInitializer$InitResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$init$2", f = "DefaultFlowControllerInitializer.kt", i = {1}, l = {41, 43, 49}, m = "invokeSuspend", n = {"isGooglePayReady"}, s = {"Z$0"})
/* compiled from: DefaultFlowControllerInitializer.kt */
final class DefaultFlowControllerInitializer$init$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FlowControllerInitializer.InitResult>, Object> {
    final /* synthetic */ ClientSecret $clientSecret;
    final /* synthetic */ PaymentSheet.Configuration $paymentSheetConfiguration;
    boolean Z$0;
    int label;
    final /* synthetic */ DefaultFlowControllerInitializer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultFlowControllerInitializer$init$2(DefaultFlowControllerInitializer defaultFlowControllerInitializer, PaymentSheet.Configuration configuration, ClientSecret clientSecret, Continuation<? super DefaultFlowControllerInitializer$init$2> continuation) {
        super(2, continuation);
        this.this$0 = defaultFlowControllerInitializer;
        this.$paymentSheetConfiguration = configuration;
        this.$clientSecret = clientSecret;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultFlowControllerInitializer$init$2(this.this$0, this.$paymentSheetConfiguration, this.$clientSecret, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super FlowControllerInitializer.InitResult> continuation) {
        return ((DefaultFlowControllerInitializer$init$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x0028
            if (r1 == r5) goto L_0x0024
            if (r1 == r4) goto L_0x001e
            if (r1 != r3) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0077
        L_0x0016:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x001e:
            boolean r1 = r11.Z$0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0060
        L_0x0024:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x003b
        L_0x0028:
            kotlin.ResultKt.throwOnFailure(r12)
            com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer r12 = r11.this$0
            com.stripe.android.paymentsheet.PaymentSheet$Configuration r1 = r11.$paymentSheetConfiguration
            r6 = r11
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r11.label = r5
            java.lang.Object r12 = r12.isGooglePayReady(r1, r6)
            if (r12 != r0) goto L_0x003b
            return r0
        L_0x003b:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r1 = r12.booleanValue()
            com.stripe.android.paymentsheet.PaymentSheet$Configuration r12 = r11.$paymentSheetConfiguration
            if (r12 != 0) goto L_0x0046
            goto L_0x0063
        L_0x0046:
            com.stripe.android.paymentsheet.PaymentSheet$CustomerConfiguration r7 = r12.getCustomer()
            if (r7 != 0) goto L_0x004d
            goto L_0x0063
        L_0x004d:
            com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer r5 = r11.this$0
            com.stripe.android.paymentsheet.model.ClientSecret r6 = r11.$clientSecret
            com.stripe.android.paymentsheet.PaymentSheet$Configuration r8 = r11.$paymentSheetConfiguration
            r11.Z$0 = r1
            r11.label = r4
            r9 = r1
            r10 = r11
            java.lang.Object r12 = r5.createWithCustomer(r6, r7, r8, r9, r10)
            if (r12 != r0) goto L_0x0060
            return r0
        L_0x0060:
            r2 = r12
            com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer$InitResult r2 = (com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer.InitResult) r2
        L_0x0063:
            if (r2 != 0) goto L_0x007a
            com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer r12 = r11.this$0
            com.stripe.android.paymentsheet.model.ClientSecret r2 = r11.$clientSecret
            com.stripe.android.paymentsheet.PaymentSheet$Configuration r4 = r11.$paymentSheetConfiguration
            r5 = r11
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r11.label = r3
            java.lang.Object r12 = r12.createWithoutCustomer(r2, r4, r1, r5)
            if (r12 != r0) goto L_0x0077
            return r0
        L_0x0077:
            r2 = r12
            com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer$InitResult r2 = (com.stripe.android.paymentsheet.flowcontroller.FlowControllerInitializer.InitResult) r2
        L_0x007a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.flowcontroller.DefaultFlowControllerInitializer$init$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
