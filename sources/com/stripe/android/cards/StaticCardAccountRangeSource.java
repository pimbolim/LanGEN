package com.stripe.android.cards;

import com.stripe.android.cards.CardNumber;
import com.stripe.android.model.AccountRange;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/cards/StaticCardAccountRangeSource;", "Lcom/stripe/android/cards/CardAccountRangeSource;", "accountRanges", "Lcom/stripe/android/cards/StaticCardAccountRanges;", "(Lcom/stripe/android/cards/StaticCardAccountRanges;)V", "loading", "Lkotlinx/coroutines/flow/Flow;", "", "getLoading", "()Lkotlinx/coroutines/flow/Flow;", "getAccountRange", "Lcom/stripe/android/model/AccountRange;", "cardNumber", "Lcom/stripe/android/cards/CardNumber$Unvalidated;", "(Lcom/stripe/android/cards/CardNumber$Unvalidated;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StaticCardAccountRangeSource.kt */
public final class StaticCardAccountRangeSource implements CardAccountRangeSource {
    public static final int $stable = 8;
    private final StaticCardAccountRanges accountRanges;
    private final Flow<Boolean> loading;

    public StaticCardAccountRangeSource() {
        this((StaticCardAccountRanges) null, 1, (DefaultConstructorMarker) null);
    }

    public StaticCardAccountRangeSource(StaticCardAccountRanges staticCardAccountRanges) {
        Intrinsics.checkNotNullParameter(staticCardAccountRanges, "accountRanges");
        this.accountRanges = staticCardAccountRanges;
        this.loading = FlowKt.flowOf(false);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ StaticCardAccountRangeSource(StaticCardAccountRanges staticCardAccountRanges, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DefaultStaticCardAccountRanges() : staticCardAccountRanges);
    }

    public Flow<Boolean> getLoading() {
        return this.loading;
    }

    public Object getAccountRange(CardNumber.Unvalidated unvalidated, Continuation<? super AccountRange> continuation) {
        return this.accountRanges.first(unvalidated);
    }
}
