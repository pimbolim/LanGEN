package com.stripe.android.view;

import com.stripe.android.PaymentSessionConfig;
import com.stripe.android.model.ShippingInformation;
import com.stripe.android.model.ShippingMethod;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lcom/stripe/android/model/ShippingMethod;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.view.PaymentFlowViewModel$validateShippingInformation$1$result$1", f = "PaymentFlowViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PaymentFlowViewModel.kt */
final class PaymentFlowViewModel$validateShippingInformation$1$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends List<? extends ShippingMethod>>>, Object> {
    final /* synthetic */ PaymentSessionConfig.ShippingInformationValidator $shippingInfoValidator;
    final /* synthetic */ ShippingInformation $shippingInformation;
    final /* synthetic */ PaymentSessionConfig.ShippingMethodsFactory $shippingMethodsFactory;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentFlowViewModel$validateShippingInformation$1$result$1(PaymentSessionConfig.ShippingInformationValidator shippingInformationValidator, ShippingInformation shippingInformation, PaymentSessionConfig.ShippingMethodsFactory shippingMethodsFactory, Continuation<? super PaymentFlowViewModel$validateShippingInformation$1$result$1> continuation) {
        super(2, continuation);
        this.$shippingInfoValidator = shippingInformationValidator;
        this.$shippingInformation = shippingInformation;
        this.$shippingMethodsFactory = shippingMethodsFactory;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PaymentFlowViewModel$validateShippingInformation$1$result$1 paymentFlowViewModel$validateShippingInformation$1$result$1 = new PaymentFlowViewModel$validateShippingInformation$1$result$1(this.$shippingInfoValidator, this.$shippingInformation, this.$shippingMethodsFactory, continuation);
        paymentFlowViewModel$validateShippingInformation$1$result$1.L$0 = obj;
        return paymentFlowViewModel$validateShippingInformation$1$result$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends List<ShippingMethod>>> continuation) {
        return ((PaymentFlowViewModel$validateShippingInformation$1$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object obj3;
        List<ShippingMethod> list;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (this.$shippingInfoValidator.isValid(this.$shippingInformation)) {
                PaymentSessionConfig.ShippingMethodsFactory shippingMethodsFactory = this.$shippingMethodsFactory;
                ShippingInformation shippingInformation = this.$shippingInformation;
                try {
                    Result.Companion companion = Result.Companion;
                    if (shippingMethodsFactory == null) {
                        list = null;
                    } else {
                        list = shippingMethodsFactory.create(shippingInformation);
                    }
                    if (list == null) {
                        list = CollectionsKt.emptyList();
                    }
                    obj2 = Result.m4709constructorimpl(list);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj2 = Result.m4709constructorimpl(ResultKt.createFailure(th));
                }
            } else {
                PaymentSessionConfig.ShippingInformationValidator shippingInformationValidator = this.$shippingInfoValidator;
                ShippingInformation shippingInformation2 = this.$shippingInformation;
                try {
                    Result.Companion companion3 = Result.Companion;
                    obj3 = Result.m4709constructorimpl(shippingInformationValidator.getErrorMessage(shippingInformation2));
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.Companion;
                    obj3 = Result.m4709constructorimpl(ResultKt.createFailure(th2));
                }
                Throwable r0 = Result.m4712exceptionOrNullimpl(obj3);
                if (r0 == null) {
                    r0 = new RuntimeException((String) obj3);
                }
                Result.Companion companion5 = Result.Companion;
                obj2 = Result.m4709constructorimpl(ResultKt.createFailure(r0));
            }
            return Result.m4708boximpl(obj2);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
