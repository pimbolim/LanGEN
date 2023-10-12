package com.stripe.android.cards;

import androidx.lifecycle.LiveDataScope;
import com.stripe.android.cards.CardNumber;
import com.stripe.android.model.AccountRange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Landroidx/lifecycle/LiveDataScope;", "Lcom/stripe/android/model/AccountRange;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.cards.CardWidgetViewModel$getAccountRange$1", f = "CardWidgetViewModel.kt", i = {}, l = {29, 29}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CardWidgetViewModel.kt */
final class CardWidgetViewModel$getAccountRange$1 extends SuspendLambda implements Function2<LiveDataScope<AccountRange>, Continuation<? super Unit>, Object> {
    final /* synthetic */ CardNumber.Unvalidated $cardNumber;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CardWidgetViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CardWidgetViewModel$getAccountRange$1(CardWidgetViewModel cardWidgetViewModel, CardNumber.Unvalidated unvalidated, Continuation<? super CardWidgetViewModel$getAccountRange$1> continuation) {
        super(2, continuation);
        this.this$0 = cardWidgetViewModel;
        this.$cardNumber = unvalidated;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CardWidgetViewModel$getAccountRange$1 cardWidgetViewModel$getAccountRange$1 = new CardWidgetViewModel$getAccountRange$1(this.this$0, this.$cardNumber, continuation);
        cardWidgetViewModel$getAccountRange$1.L$0 = obj;
        return cardWidgetViewModel$getAccountRange$1;
    }

    public final Object invoke(LiveDataScope<AccountRange> liveDataScope, Continuation<? super Unit> continuation) {
        return ((CardWidgetViewModel$getAccountRange$1) create(liveDataScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: androidx.lifecycle.LiveDataScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0022
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004f
        L_0x0012:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001a:
            java.lang.Object r1 = r6.L$0
            androidx.lifecycle.LiveDataScope r1 = (androidx.lifecycle.LiveDataScope) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0040
        L_0x0022:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.Object r7 = r6.L$0
            r1 = r7
            androidx.lifecycle.LiveDataScope r1 = (androidx.lifecycle.LiveDataScope) r1
            com.stripe.android.cards.CardWidgetViewModel r7 = r6.this$0
            com.stripe.android.cards.CardAccountRangeRepository r7 = r7.getCardAccountRangeRepository()
            com.stripe.android.cards.CardNumber$Unvalidated r4 = r6.$cardNumber
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.L$0 = r1
            r6.label = r3
            java.lang.Object r7 = r7.getAccountRange(r4, r5)
            if (r7 != r0) goto L_0x0040
            return r0
        L_0x0040:
            r3 = r6
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4 = 0
            r6.L$0 = r4
            r6.label = r2
            java.lang.Object r7 = r1.emit(r7, r3)
            if (r7 != r0) goto L_0x004f
            return r0
        L_0x004f:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.cards.CardWidgetViewModel$getAccountRange$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
