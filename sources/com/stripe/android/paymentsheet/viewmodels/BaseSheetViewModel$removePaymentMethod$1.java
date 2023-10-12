package com.stripe.android.paymentsheet.viewmodels;

import androidx.lifecycle.SavedStateHandle;
import com.stripe.android.model.PaymentMethod;
import com.stripe.android.paymentsheet.PaymentSheet;
import com.stripe.android.paymentsheet.repositories.CustomerRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/Job;", "TransitionTargetType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel$removePaymentMethod$1", f = "BaseSheetViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BaseSheetViewModel.kt */
final class BaseSheetViewModel$removePaymentMethod$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Job>, Object> {
    final /* synthetic */ PaymentMethod $paymentMethod;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BaseSheetViewModel<TransitionTargetType> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseSheetViewModel$removePaymentMethod$1(PaymentMethod paymentMethod, BaseSheetViewModel<TransitionTargetType> baseSheetViewModel, Continuation<? super BaseSheetViewModel$removePaymentMethod$1> continuation) {
        super(2, continuation);
        this.$paymentMethod = paymentMethod;
        this.this$0 = baseSheetViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BaseSheetViewModel$removePaymentMethod$1 baseSheetViewModel$removePaymentMethod$1 = new BaseSheetViewModel$removePaymentMethod$1(this.$paymentMethod, this.this$0, continuation);
        baseSheetViewModel$removePaymentMethod$1.L$0 = obj;
        return baseSheetViewModel$removePaymentMethod$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Job> continuation) {
        return ((BaseSheetViewModel$removePaymentMethod$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "", "TransitionTargetType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel$removePaymentMethod$1$1", f = "BaseSheetViewModel.kt", i = {}, l = {370}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel$removePaymentMethod$1$1  reason: invalid class name */
    /* compiled from: BaseSheetViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(paymentMethod, baseSheetViewModel, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            List list;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String str = paymentMethod.id;
                if (str != null) {
                    BaseSheetViewModel<TransitionTargetType> baseSheetViewModel = baseSheetViewModel;
                    SavedStateHandle savedStateHandle = baseSheetViewModel.getSavedStateHandle();
                    List value = baseSheetViewModel.get_paymentMethods$paymentsheet_release().getValue();
                    if (value == null) {
                        list = null;
                    } else {
                        Collection arrayList = new ArrayList();
                        for (Object next : value) {
                            if (!Intrinsics.areEqual((Object) ((PaymentMethod) next).id, (Object) str)) {
                                arrayList.add(next);
                            }
                        }
                        list = (List) arrayList;
                    }
                    savedStateHandle.set(BaseSheetViewModel.SAVE_PAYMENT_METHODS, list);
                    PaymentSheet.CustomerConfiguration customerConfig$paymentsheet_release = baseSheetViewModel.getCustomerConfig$paymentsheet_release();
                    if (customerConfig$paymentsheet_release != null) {
                        CustomerRepository customerRepository = baseSheetViewModel.getCustomerRepository();
                        this.label = 1;
                        if (customerRepository.detachPaymentMethod(customerConfig$paymentsheet_release, str, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            final PaymentMethod paymentMethod = this.$paymentMethod;
            final BaseSheetViewModel<TransitionTargetType> baseSheetViewModel = this.this$0;
            return BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
