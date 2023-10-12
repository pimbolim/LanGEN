package com.stripe.android.cards;

import com.stripe.android.cards.CardNumber;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.cards.CardAccountRangeService$queryAccountRangeRepository$1", f = "CardAccountRangeService.kt", i = {}, l = {61, 66}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CardAccountRangeService.kt */
final class CardAccountRangeService$queryAccountRangeRepository$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CardNumber.Unvalidated $cardNumber;
    int label;
    final /* synthetic */ CardAccountRangeService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CardAccountRangeService$queryAccountRangeRepository$1(CardNumber.Unvalidated unvalidated, CardAccountRangeService cardAccountRangeService, Continuation<? super CardAccountRangeService$queryAccountRangeRepository$1> continuation) {
        super(2, continuation);
        this.$cardNumber = unvalidated;
        this.this$0 = cardAccountRangeService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CardAccountRangeService$queryAccountRangeRepository$1(this.$cardNumber, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CardAccountRangeService$queryAccountRangeRepository$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x001f
            if (r1 == r4) goto L_0x001b
            if (r1 != r3) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005f
        L_0x0013:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x003e
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r7)
            com.stripe.android.cards.CardNumber$Unvalidated r7 = r6.$cardNumber
            com.stripe.android.cards.Bin r7 = r7.getBin()
            if (r7 == 0) goto L_0x0041
            com.stripe.android.cards.CardAccountRangeService r7 = r6.this$0
            com.stripe.android.cards.CardAccountRangeRepository r7 = r7.cardAccountRangeRepository
            com.stripe.android.cards.CardNumber$Unvalidated r1 = r6.$cardNumber
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.label = r4
            java.lang.Object r7 = r7.getAccountRange(r1, r5)
            if (r7 != r0) goto L_0x003e
            return r0
        L_0x003e:
            com.stripe.android.model.AccountRange r7 = (com.stripe.android.model.AccountRange) r7
            goto L_0x0044
        L_0x0041:
            r7 = r2
            com.stripe.android.model.AccountRange r7 = (com.stripe.android.model.AccountRange) r7
        L_0x0044:
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            com.stripe.android.cards.CardAccountRangeService$queryAccountRangeRepository$1$1 r4 = new com.stripe.android.cards.CardAccountRangeService$queryAccountRangeRepository$1$1
            com.stripe.android.cards.CardAccountRangeService r5 = r6.this$0
            r4.<init>(r5, r7, r2)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r7 = r6
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r6.label = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r1, r4, r7)
            if (r7 != r0) goto L_0x005f
            return r0
        L_0x005f:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.cards.CardAccountRangeService$queryAccountRangeRepository$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
