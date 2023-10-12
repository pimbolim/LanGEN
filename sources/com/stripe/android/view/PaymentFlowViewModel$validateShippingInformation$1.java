package com.stripe.android.view;

import androidx.lifecycle.LiveDataScope;
import com.stripe.android.PaymentSessionConfig;
import com.stripe.android.model.ShippingInformation;
import com.stripe.android.model.ShippingMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/Result;", "", "Lcom/stripe/android/model/ShippingMethod;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.view.PaymentFlowViewModel$validateShippingInformation$1", f = "PaymentFlowViewModel.kt", i = {0}, l = {71, 89}, m = "invokeSuspend", n = {"$this$liveData"}, s = {"L$0"})
/* compiled from: PaymentFlowViewModel.kt */
final class PaymentFlowViewModel$validateShippingInformation$1 extends SuspendLambda implements Function2<LiveDataScope<Result<? extends List<? extends ShippingMethod>>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ PaymentSessionConfig.ShippingInformationValidator $shippingInfoValidator;
    final /* synthetic */ ShippingInformation $shippingInformation;
    final /* synthetic */ PaymentSessionConfig.ShippingMethodsFactory $shippingMethodsFactory;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PaymentFlowViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentFlowViewModel$validateShippingInformation$1(PaymentFlowViewModel paymentFlowViewModel, PaymentSessionConfig.ShippingInformationValidator shippingInformationValidator, ShippingInformation shippingInformation, PaymentSessionConfig.ShippingMethodsFactory shippingMethodsFactory, Continuation<? super PaymentFlowViewModel$validateShippingInformation$1> continuation) {
        super(2, continuation);
        this.this$0 = paymentFlowViewModel;
        this.$shippingInfoValidator = shippingInformationValidator;
        this.$shippingInformation = shippingInformation;
        this.$shippingMethodsFactory = shippingMethodsFactory;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PaymentFlowViewModel$validateShippingInformation$1 paymentFlowViewModel$validateShippingInformation$1 = new PaymentFlowViewModel$validateShippingInformation$1(this.this$0, this.$shippingInfoValidator, this.$shippingInformation, this.$shippingMethodsFactory, continuation);
        paymentFlowViewModel$validateShippingInformation$1.L$0 = obj;
        return paymentFlowViewModel$validateShippingInformation$1;
    }

    public final Object invoke(LiveDataScope<Result<List<ShippingMethod>>> liveDataScope, Continuation<? super Unit> continuation) {
        return ((PaymentFlowViewModel$validateShippingInformation$1) create(liveDataScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.lifecycle.LiveDataScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x0023
            if (r1 == r4) goto L_0x001b
            if (r1 != r3) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0077
        L_0x0013:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x001b:
            java.lang.Object r1 = r9.L$0
            androidx.lifecycle.LiveDataScope r1 = (androidx.lifecycle.LiveDataScope) r1
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x004c
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            r1 = r10
            androidx.lifecycle.LiveDataScope r1 = (androidx.lifecycle.LiveDataScope) r1
            com.stripe.android.view.PaymentFlowViewModel r10 = r9.this$0
            kotlin.coroutines.CoroutineContext r10 = r10.workContext
            com.stripe.android.view.PaymentFlowViewModel$validateShippingInformation$1$result$1 r5 = new com.stripe.android.view.PaymentFlowViewModel$validateShippingInformation$1$result$1
            com.stripe.android.PaymentSessionConfig$ShippingInformationValidator r6 = r9.$shippingInfoValidator
            com.stripe.android.model.ShippingInformation r7 = r9.$shippingInformation
            com.stripe.android.PaymentSessionConfig$ShippingMethodsFactory r8 = r9.$shippingMethodsFactory
            r5.<init>(r6, r7, r8, r2)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r6 = r9
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r9.L$0 = r1
            r9.label = r4
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r10, r5, r6)
            if (r10 != r0) goto L_0x004c
            return r0
        L_0x004c:
            kotlin.Result r10 = (kotlin.Result) r10
            java.lang.Object r10 = r10.m4718unboximpl()
            com.stripe.android.view.PaymentFlowViewModel r4 = r9.this$0
            java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
            boolean r6 = kotlin.Result.m4715isFailureimpl(r10)
            if (r6 == 0) goto L_0x005f
            goto L_0x0060
        L_0x005f:
            r5 = r10
        L_0x0060:
            java.util.List r5 = (java.util.List) r5
            r4.setShippingMethods$payments_core_release(r5)
            kotlin.Result r10 = kotlin.Result.m4708boximpl(r10)
            r4 = r9
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r9.L$0 = r2
            r9.label = r3
            java.lang.Object r10 = r1.emit(r10, r4)
            if (r10 != r0) goto L_0x0077
            return r0
        L_0x0077:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.view.PaymentFlowViewModel$validateShippingInformation$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
