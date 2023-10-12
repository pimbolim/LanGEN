package com.stripe.android.link.ui.verification;

import com.stripe.android.link.model.LinkAccount;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.link.ui.verification.VerificationViewModel$onResendCodeClicked$1", f = "VerificationViewModel.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: VerificationViewModel.kt */
final class VerificationViewModel$onResendCodeClicked$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VerificationViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VerificationViewModel$onResendCodeClicked$1(VerificationViewModel verificationViewModel, Continuation<? super VerificationViewModel$onResendCodeClicked$1> continuation) {
        super(2, continuation);
        this.this$0 = verificationViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VerificationViewModel$onResendCodeClicked$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((VerificationViewModel$onResendCodeClicked$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj2 = this.this$0.linkAccountManager.m4310startVerificationIoAF18A(this);
            if (obj2 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            obj2 = ((Result) obj).m4718unboximpl();
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        VerificationViewModel verificationViewModel = this.this$0;
        Throwable r1 = Result.m4712exceptionOrNullimpl(obj2);
        if (r1 == null) {
            LinkAccount linkAccount = (LinkAccount) obj2;
            verificationViewModel.logger.info("Verification code sent");
        } else {
            verificationViewModel.onError(r1);
        }
        return Unit.INSTANCE;
    }
}
