package com.stripe.android.paymentsheet.viewmodels;

import androidx.lifecycle.FlowLiveDataConversions;
import com.stripe.android.paymentsheet.PrefsRepository;
import com.stripe.android.paymentsheet.model.SavedSelection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/paymentsheet/model/SavedSelection;", "TransitionTargetType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.paymentsheet.viewmodels.BaseSheetViewModel$1$savedSelection$1", f = "BaseSheetViewModel.kt", i = {}, l = {216, 216}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BaseSheetViewModel.kt */
final class BaseSheetViewModel$1$savedSelection$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super SavedSelection>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ BaseSheetViewModel<TransitionTargetType> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseSheetViewModel$1$savedSelection$1(BaseSheetViewModel<TransitionTargetType> baseSheetViewModel, Continuation<? super BaseSheetViewModel$1$savedSelection$1> continuation) {
        super(2, continuation);
        this.this$0 = baseSheetViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseSheetViewModel$1$savedSelection$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super SavedSelection> continuation) {
        return ((BaseSheetViewModel$1$savedSelection$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        PrefsRepository prefsRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            prefsRepository = this.this$0.getPrefsRepository();
            this.L$0 = prefsRepository;
            this.label = 1;
            obj = FlowKt.first(FlowLiveDataConversions.asFlow(this.this$0.isGooglePayReady$paymentsheet_release()), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            prefsRepository = (PrefsRepository) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.L$0 = null;
        this.label = 2;
        obj = prefsRepository.getSavedSelection(((Boolean) obj).booleanValue(), this);
        return obj == coroutine_suspended ? coroutine_suspended : obj;
    }
}
