package com.stripe.android.paymentsheet;

import com.stripe.android.paymentsheet.forms.FormFieldValues;
import com.stripe.android.paymentsheet.forms.FormViewModel;
import com.stripe.android.paymentsheet.paymentdatacollection.ComposeFormDataCollectionFragment;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.BaseAddPaymentMethodFragment$attachComposeFragmentViewModel$1$1", f = "BaseAddPaymentMethodFragment.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BaseAddPaymentMethodFragment.kt */
final class BaseAddPaymentMethodFragment$attachComposeFragmentViewModel$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ComposeFormDataCollectionFragment $formFragment;
    final /* synthetic */ FormViewModel $formViewModel;
    int label;
    final /* synthetic */ BaseAddPaymentMethodFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseAddPaymentMethodFragment$attachComposeFragmentViewModel$1$1(FormViewModel formViewModel, BaseAddPaymentMethodFragment baseAddPaymentMethodFragment, ComposeFormDataCollectionFragment composeFormDataCollectionFragment, Continuation<? super BaseAddPaymentMethodFragment$attachComposeFragmentViewModel$1$1> continuation) {
        super(2, continuation);
        this.$formViewModel = formViewModel;
        this.this$0 = baseAddPaymentMethodFragment;
        this.$formFragment = composeFormDataCollectionFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseAddPaymentMethodFragment$attachComposeFragmentViewModel$1$1(this.$formViewModel, this.this$0, this.$formFragment, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BaseAddPaymentMethodFragment$attachComposeFragmentViewModel$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Flow<FormFieldValues> completeFormValues = this.$formViewModel.getCompleteFormValues();
            final BaseAddPaymentMethodFragment baseAddPaymentMethodFragment = this.this$0;
            final ComposeFormDataCollectionFragment composeFormDataCollectionFragment = this.$formFragment;
            this.label = 1;
            if (completeFormValues.collect(new FlowCollector<FormFieldValues>() {
                public final Object emit(FormFieldValues formFieldValues, Continuation<? super Unit> continuation) {
                    baseAddPaymentMethodFragment.getSheetViewModel().updateSelection(BaseAddPaymentMethodFragment.Companion.transformToPaymentSelection$paymentsheet_release(formFieldValues, composeFormDataCollectionFragment.getParamKeySpec(), baseAddPaymentMethodFragment.getSheetViewModel().getAddFragmentSelectedLpmValue()));
                    return Unit.INSTANCE;
                }
            }, this) == coroutine_suspended) {
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
