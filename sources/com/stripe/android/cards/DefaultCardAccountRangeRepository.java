package com.stripe.android.cards;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/cards/DefaultCardAccountRangeRepository;", "Lcom/stripe/android/cards/CardAccountRangeRepository;", "inMemorySource", "Lcom/stripe/android/cards/CardAccountRangeSource;", "remoteSource", "staticSource", "store", "Lcom/stripe/android/cards/CardAccountRangeStore;", "(Lcom/stripe/android/cards/CardAccountRangeSource;Lcom/stripe/android/cards/CardAccountRangeSource;Lcom/stripe/android/cards/CardAccountRangeSource;Lcom/stripe/android/cards/CardAccountRangeStore;)V", "loading", "Lkotlinx/coroutines/flow/Flow;", "", "getLoading", "()Lkotlinx/coroutines/flow/Flow;", "getAccountRange", "Lcom/stripe/android/model/AccountRange;", "cardNumber", "Lcom/stripe/android/cards/CardNumber$Unvalidated;", "(Lcom/stripe/android/cards/CardNumber$Unvalidated;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultCardAccountRangeRepository.kt */
public final class DefaultCardAccountRangeRepository implements CardAccountRangeRepository {
    private final CardAccountRangeSource inMemorySource;
    private final Flow<Boolean> loading;
    private final CardAccountRangeSource remoteSource;
    private final CardAccountRangeSource staticSource;
    private final CardAccountRangeStore store;

    public DefaultCardAccountRangeRepository(CardAccountRangeSource cardAccountRangeSource, CardAccountRangeSource cardAccountRangeSource2, CardAccountRangeSource cardAccountRangeSource3, CardAccountRangeStore cardAccountRangeStore) {
        Intrinsics.checkNotNullParameter(cardAccountRangeSource, "inMemorySource");
        Intrinsics.checkNotNullParameter(cardAccountRangeSource2, "remoteSource");
        Intrinsics.checkNotNullParameter(cardAccountRangeSource3, "staticSource");
        Intrinsics.checkNotNullParameter(cardAccountRangeStore, "store");
        this.inMemorySource = cardAccountRangeSource;
        this.remoteSource = cardAccountRangeSource2;
        this.staticSource = cardAccountRangeSource3;
        this.store = cardAccountRangeStore;
        Object[] array = CollectionsKt.toList(CollectionsKt.listOf(cardAccountRangeSource.getLoading(), cardAccountRangeSource2.getLoading(), cardAccountRangeSource3.getLoading())).toArray(new Flow[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.loading = new DefaultCardAccountRangeRepository$special$$inlined$combine$1((Flow[]) array);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getAccountRange(com.stripe.android.cards.CardNumber.Unvalidated r9, kotlin.coroutines.Continuation<? super com.stripe.android.model.AccountRange> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.stripe.android.cards.DefaultCardAccountRangeRepository$getAccountRange$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.stripe.android.cards.DefaultCardAccountRangeRepository$getAccountRange$1 r0 = (com.stripe.android.cards.DefaultCardAccountRangeRepository$getAccountRange$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.stripe.android.cards.DefaultCardAccountRangeRepository$getAccountRange$1 r0 = new com.stripe.android.cards.DefaultCardAccountRangeRepository$getAccountRange$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x0061
            if (r2 == r6) goto L_0x0055
            if (r2 == r5) goto L_0x0049
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00b7
        L_0x0035:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003d:
            java.lang.Object r9 = r0.L$1
            com.stripe.android.cards.CardNumber$Unvalidated r9 = (com.stripe.android.cards.CardNumber.Unvalidated) r9
            java.lang.Object r2 = r0.L$0
            com.stripe.android.cards.DefaultCardAccountRangeRepository r2 = (com.stripe.android.cards.DefaultCardAccountRangeRepository) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00a4
        L_0x0049:
            java.lang.Object r9 = r0.L$1
            com.stripe.android.cards.CardNumber$Unvalidated r9 = (com.stripe.android.cards.CardNumber.Unvalidated) r9
            java.lang.Object r2 = r0.L$0
            com.stripe.android.cards.DefaultCardAccountRangeRepository r2 = (com.stripe.android.cards.DefaultCardAccountRangeRepository) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0092
        L_0x0055:
            java.lang.Object r9 = r0.L$1
            com.stripe.android.cards.CardNumber$Unvalidated r9 = (com.stripe.android.cards.CardNumber.Unvalidated) r9
            java.lang.Object r2 = r0.L$0
            com.stripe.android.cards.DefaultCardAccountRangeRepository r2 = (com.stripe.android.cards.DefaultCardAccountRangeRepository) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x007b
        L_0x0061:
            kotlin.ResultKt.throwOnFailure(r10)
            com.stripe.android.cards.Bin r10 = r9.getBin()
            if (r10 != 0) goto L_0x006b
            goto L_0x00ba
        L_0x006b:
            com.stripe.android.cards.CardAccountRangeStore r2 = r8.store
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r6
            java.lang.Object r10 = r2.contains(r10, r0)
            if (r10 != r1) goto L_0x007a
            return r1
        L_0x007a:
            r2 = r8
        L_0x007b:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x0095
            com.stripe.android.cards.CardAccountRangeSource r10 = r2.inMemorySource
            r0.L$0 = r2
            r0.L$1 = r9
            r0.label = r5
            java.lang.Object r10 = r10.getAccountRange(r9, r0)
            if (r10 != r1) goto L_0x0092
            return r1
        L_0x0092:
            com.stripe.android.model.AccountRange r10 = (com.stripe.android.model.AccountRange) r10
            goto L_0x00a6
        L_0x0095:
            com.stripe.android.cards.CardAccountRangeSource r10 = r2.remoteSource
            r0.L$0 = r2
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r10 = r10.getAccountRange(r9, r0)
            if (r10 != r1) goto L_0x00a4
            return r1
        L_0x00a4:
            com.stripe.android.model.AccountRange r10 = (com.stripe.android.model.AccountRange) r10
        L_0x00a6:
            if (r10 != 0) goto L_0x00b9
            com.stripe.android.cards.CardAccountRangeSource r10 = r2.staticSource
            r0.L$0 = r7
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r10 = r10.getAccountRange(r9, r0)
            if (r10 != r1) goto L_0x00b7
            return r1
        L_0x00b7:
            com.stripe.android.model.AccountRange r10 = (com.stripe.android.model.AccountRange) r10
        L_0x00b9:
            r7 = r10
        L_0x00ba:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.cards.DefaultCardAccountRangeRepository.getAccountRange(com.stripe.android.cards.CardNumber$Unvalidated, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Flow<Boolean> getLoading() {
        return this.loading;
    }
}
