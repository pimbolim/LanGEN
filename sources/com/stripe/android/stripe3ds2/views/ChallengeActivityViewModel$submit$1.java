package com.stripe.android.stripe3ds2.views;

import com.stripe.android.stripe3ds2.transaction.ChallengeAction;
import com.stripe.android.stripe3ds2.views.ChallengeActivityViewModel;
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
@DebugMetadata(c = "com.stripe.android.stripe3ds2.views.ChallengeActivityViewModel$submit$1", f = "ChallengeActivityViewModel.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ChallengeActivityViewModel.kt */
final class ChallengeActivityViewModel$submit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChallengeAction $action;
    Object L$0;
    int label;
    final /* synthetic */ ChallengeActivityViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChallengeActivityViewModel$submit$1(ChallengeActivityViewModel challengeActivityViewModel, ChallengeAction challengeAction, Continuation<? super ChallengeActivityViewModel$submit$1> continuation) {
        super(2, continuation);
        this.this$0 = challengeActivityViewModel;
        this.$action = challengeAction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChallengeActivityViewModel$submit$1(this.this$0, this.$action, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ChallengeActivityViewModel$submit$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ChallengeActivityViewModel.OnInactiveAwareMutableLiveData onInactiveAwareMutableLiveData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ChallengeActivityViewModel.OnInactiveAwareMutableLiveData access$get_challengeRequestResult$p = this.this$0._challengeRequestResult;
            this.L$0 = access$get_challengeRequestResult$p;
            this.label = 1;
            Object submit = this.this$0.challengeActionHandler.submit(this.$action, this);
            if (submit == coroutine_suspended) {
                return coroutine_suspended;
            }
            onInactiveAwareMutableLiveData = access$get_challengeRequestResult$p;
            obj = submit;
        } else if (i == 1) {
            onInactiveAwareMutableLiveData = (ChallengeActivityViewModel.OnInactiveAwareMutableLiveData) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        onInactiveAwareMutableLiveData.postValue(obj);
        return Unit.INSTANCE;
    }
}
