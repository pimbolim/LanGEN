package com.stripe.android.link.repositories;

import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.ConsumerSessionLookup;
import com.stripe.android.networking.StripeRepository;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H@"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/stripe/android/model/ConsumerSessionLookup;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.link.repositories.LinkApiRepository$lookupConsumer$2", f = "LinkApiRepository.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LinkApiRepository.kt */
final class LinkApiRepository$lookupConsumer$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends ConsumerSessionLookup>>, Object> {
    final /* synthetic */ String $authSessionCookie;
    final /* synthetic */ String $email;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LinkApiRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LinkApiRepository$lookupConsumer$2(LinkApiRepository linkApiRepository, String str, String str2, Continuation<? super LinkApiRepository$lookupConsumer$2> continuation) {
        super(2, continuation);
        this.this$0 = linkApiRepository;
        this.$email = str;
        this.$authSessionCookie = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LinkApiRepository$lookupConsumer$2 linkApiRepository$lookupConsumer$2 = new LinkApiRepository$lookupConsumer$2(this.this$0, this.$email, this.$authSessionCookie, continuation);
        linkApiRepository$lookupConsumer$2.L$0 = obj;
        return linkApiRepository$lookupConsumer$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<ConsumerSessionLookup>> continuation) {
        return ((LinkApiRepository$lookupConsumer$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Result result;
        Object obj3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            LinkApiRepository linkApiRepository = this.this$0;
            String str = this.$email;
            String str2 = this.$authSessionCookie;
            Result.Companion companion = Result.Companion;
            StripeRepository access$getStripeRepository$p = linkApiRepository.stripeRepository;
            ApiRequest.Options options = new ApiRequest.Options((String) linkApiRepository.publishableKeyProvider.invoke(), (String) linkApiRepository.stripeAccountIdProvider.invoke(), (String) null, 4, (DefaultConstructorMarker) null);
            this.label = 1;
            obj = access$getStripeRepository$p.lookupConsumerSession(str, str2, options, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m4709constructorimpl(ResultKt.createFailure(th));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.m4709constructorimpl((ConsumerSessionLookup) obj);
        LinkApiRepository linkApiRepository2 = this.this$0;
        Throwable r1 = Result.m4712exceptionOrNullimpl(obj2);
        if (r1 == null) {
            ConsumerSessionLookup consumerSessionLookup = (ConsumerSessionLookup) obj2;
            if (consumerSessionLookup == null) {
                result = null;
            } else {
                Result.Companion companion3 = Result.Companion;
                result = Result.m4708boximpl(Result.m4709constructorimpl(consumerSessionLookup));
            }
            if (result == null) {
                Result.Companion companion4 = Result.Companion;
                obj3 = Result.m4709constructorimpl(ResultKt.createFailure(new InternalError("Error looking up consumer")));
            } else {
                obj3 = result.m4718unboximpl();
            }
            return Result.m4708boximpl(obj3);
        }
        linkApiRepository2.logger.error("Error looking up consumer", r1);
        Result.Companion companion5 = Result.Companion;
        return Result.m4708boximpl(Result.m4709constructorimpl(ResultKt.createFailure(r1)));
    }
}
