package com.stripe.android.stripe3ds2.transaction;

import androidx.core.app.FrameMetricsAggregator;
import com.stripe.android.stripe3ds2.transaction.ChallengeAction;
import com.stripe.android.stripe3ds2.transaction.ChallengeActionHandler;
import com.stripe.android.stripe3ds2.transactions.ChallengeRequestData;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/stripe/android/stripe3ds2/transaction/ChallengeRequestResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.stripe3ds2.transaction.ChallengeActionHandler$Default$submit$2", f = "ChallengeActionHandler.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ChallengeActionHandler.kt */
final class ChallengeActionHandler$Default$submit$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ChallengeRequestResult>, Object> {
    final /* synthetic */ ChallengeAction $action;
    int label;
    final /* synthetic */ ChallengeActionHandler.Default this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChallengeActionHandler$Default$submit$2(ChallengeActionHandler.Default defaultR, ChallengeAction challengeAction, Continuation<? super ChallengeActionHandler$Default$submit$2> continuation) {
        super(2, continuation);
        this.this$0 = defaultR;
        this.$action = challengeAction;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ChallengeActionHandler$Default$submit$2(this.this$0, this.$action, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ChallengeRequestResult> continuation) {
        return ((ChallengeActionHandler$Default$submit$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ChallengeRequestData challengeRequestData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ChallengeRequestData challengeRequestData2 = new ChallengeRequestData(this.this$0.creqData.getMessageVersion(), this.this$0.creqData.getThreeDsServerTransId(), this.this$0.creqData.getAcsTransId(), this.this$0.creqData.getSdkTransId(), (String) null, (ChallengeRequestData.CancelReason) null, (String) null, this.this$0.creqData.getMessageExtensions(), (Boolean) null, (Boolean) null, 880, (DefaultConstructorMarker) null);
            ChallengeAction challengeAction = this.$action;
            if (challengeAction instanceof ChallengeAction.NativeForm) {
                challengeRequestData = ChallengeRequestData.copy$default(challengeRequestData2, (String) null, (String) null, (String) null, (SdkTransactionId) null, ((ChallengeAction.NativeForm) challengeAction).getUserEntry$3ds2sdk_release(), (ChallengeRequestData.CancelReason) null, (String) null, (List) null, (Boolean) null, (Boolean) null, 1007, (Object) null);
            } else if (challengeAction instanceof ChallengeAction.HtmlForm) {
                challengeRequestData = ChallengeRequestData.copy$default(challengeRequestData2, (String) null, (String) null, (String) null, (SdkTransactionId) null, (String) null, (ChallengeRequestData.CancelReason) null, ((ChallengeAction.HtmlForm) challengeAction).getUserEntry$3ds2sdk_release(), (List) null, (Boolean) null, (Boolean) null, 959, (Object) null);
            } else if (challengeAction instanceof ChallengeAction.Oob) {
                challengeRequestData = ChallengeRequestData.copy$default(challengeRequestData2, (String) null, (String) null, (String) null, (SdkTransactionId) null, (String) null, (ChallengeRequestData.CancelReason) null, (String) null, (List) null, Boxing.boxBoolean(true), (Boolean) null, 767, (Object) null);
            } else if (challengeAction instanceof ChallengeAction.Resend) {
                challengeRequestData = ChallengeRequestData.copy$default(challengeRequestData2, (String) null, (String) null, (String) null, (SdkTransactionId) null, (String) null, (ChallengeRequestData.CancelReason) null, (String) null, (List) null, (Boolean) null, Boxing.boxBoolean(true), FrameMetricsAggregator.EVERY_DURATION, (Object) null);
            } else if (challengeAction instanceof ChallengeAction.Cancel) {
                challengeRequestData = ChallengeRequestData.copy$default(challengeRequestData2, (String) null, (String) null, (String) null, (SdkTransactionId) null, (String) null, ChallengeRequestData.CancelReason.UserSelected, (String) null, (List) null, (Boolean) null, (Boolean) null, 991, (Object) null);
            } else {
                throw new NoWhenBranchMatchedException();
            }
            this.label = 1;
            Object access$executeChallengeRequest = this.this$0.executeChallengeRequest(challengeRequestData, this);
            return access$executeChallengeRequest == coroutine_suspended ? coroutine_suspended : access$executeChallengeRequest;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return obj;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
