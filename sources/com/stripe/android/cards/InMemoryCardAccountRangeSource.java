package com.stripe.android.cards;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/cards/InMemoryCardAccountRangeSource;", "Lcom/stripe/android/cards/CardAccountRangeSource;", "store", "Lcom/stripe/android/cards/CardAccountRangeStore;", "(Lcom/stripe/android/cards/CardAccountRangeStore;)V", "loading", "Lkotlinx/coroutines/flow/Flow;", "", "getLoading", "()Lkotlinx/coroutines/flow/Flow;", "getAccountRange", "Lcom/stripe/android/model/AccountRange;", "cardNumber", "Lcom/stripe/android/cards/CardNumber$Unvalidated;", "(Lcom/stripe/android/cards/CardNumber$Unvalidated;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InMemoryCardAccountRangeSource.kt */
public final class InMemoryCardAccountRangeSource implements CardAccountRangeSource {
    private final Flow<Boolean> loading = FlowKt.flowOf(false);
    private final CardAccountRangeStore store;

    public InMemoryCardAccountRangeSource(CardAccountRangeStore cardAccountRangeStore) {
        Intrinsics.checkNotNullParameter(cardAccountRangeStore, "store");
        this.store = cardAccountRangeStore;
    }

    public Flow<Boolean> getLoading() {
        return this.loading;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.stripe.android.model.AccountRange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.stripe.android.model.AccountRange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.stripe.android.model.AccountRange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.stripe.android.model.AccountRange} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006c A[EDGE_INSN: B:24:0x006c->B:23:0x006c ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getAccountRange(com.stripe.android.cards.CardNumber.Unvalidated r6, kotlin.coroutines.Continuation<? super com.stripe.android.model.AccountRange> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.stripe.android.cards.InMemoryCardAccountRangeSource$getAccountRange$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.stripe.android.cards.InMemoryCardAccountRangeSource$getAccountRange$1 r0 = (com.stripe.android.cards.InMemoryCardAccountRangeSource$getAccountRange$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.stripe.android.cards.InMemoryCardAccountRangeSource$getAccountRange$1 r0 = new com.stripe.android.cards.InMemoryCardAccountRangeSource$getAccountRange$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            java.lang.Object r6 = r0.L$0
            com.stripe.android.cards.CardNumber$Unvalidated r6 = (com.stripe.android.cards.CardNumber.Unvalidated) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004e
        L_0x002f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r7)
            com.stripe.android.cards.Bin r7 = r6.getBin()
            if (r7 != 0) goto L_0x0041
            goto L_0x006e
        L_0x0041:
            com.stripe.android.cards.CardAccountRangeStore r2 = r5.store
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r2.get(r7, r0)
            if (r7 != r1) goto L_0x004e
            return r1
        L_0x004e:
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x0054:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x006c
            java.lang.Object r0 = r7.next()
            r1 = r0
            com.stripe.android.model.AccountRange r1 = (com.stripe.android.model.AccountRange) r1
            com.stripe.android.model.BinRange r1 = r1.component1()
            boolean r1 = r1.matches(r6)
            if (r1 == 0) goto L_0x0054
            r3 = r0
        L_0x006c:
            com.stripe.android.model.AccountRange r3 = (com.stripe.android.model.AccountRange) r3
        L_0x006e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.cards.InMemoryCardAccountRangeSource.getAccountRange(com.stripe.android.cards.CardNumber$Unvalidated, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
