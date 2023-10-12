package com.stripe.android.link.account;

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
@DebugMetadata(c = "com.stripe.android.link.account.LinkAccountManager$logout$1$1", f = "LinkAccountManager.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LinkAccountManager.kt */
final class LinkAccountManager$logout$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LinkAccount $account;
    final /* synthetic */ String $cookie;
    int label;
    final /* synthetic */ LinkAccountManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LinkAccountManager$logout$1$1(LinkAccountManager linkAccountManager, LinkAccount linkAccount, String str, Continuation<? super LinkAccountManager$logout$1$1> continuation) {
        super(2, continuation);
        this.this$0 = linkAccountManager;
        this.$account = linkAccount;
        this.$cookie = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LinkAccountManager$logout$1$1(this.this$0, this.$account, this.$cookie, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LinkAccountManager$logout$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.linkRepository.m4321logout0E7RQCE(this.$account.getClientSecret(), this.$cookie, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            ((Result) obj).m4718unboximpl();
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
