package com.stripe.android.cards;

import com.stripe.android.cards.CardNumber;
import com.stripe.android.model.AccountRange;
import com.stripe.android.model.CardBrand;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001(B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"J\u0010\u0010$\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010&\u001a\u00020\u001f2\b\u0010'\u001a\u0004\u0018\u00010\fR\"\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/stripe/android/cards/CardAccountRangeService;", "", "cardAccountRangeRepository", "Lcom/stripe/android/cards/CardAccountRangeRepository;", "workContext", "Lkotlin/coroutines/CoroutineContext;", "staticCardAccountRanges", "Lcom/stripe/android/cards/StaticCardAccountRanges;", "accountRangeResultListener", "Lcom/stripe/android/cards/CardAccountRangeService$AccountRangeResultListener;", "(Lcom/stripe/android/cards/CardAccountRangeRepository;Lkotlin/coroutines/CoroutineContext;Lcom/stripe/android/cards/StaticCardAccountRanges;Lcom/stripe/android/cards/CardAccountRangeService$AccountRangeResultListener;)V", "<set-?>", "Lcom/stripe/android/model/AccountRange;", "accountRange", "getAccountRange", "()Lcom/stripe/android/model/AccountRange;", "accountRangeRepositoryJob", "Lkotlinx/coroutines/Job;", "getAccountRangeRepositoryJob$annotations", "()V", "getAccountRangeRepositoryJob", "()Lkotlinx/coroutines/Job;", "setAccountRangeRepositoryJob", "(Lkotlinx/coroutines/Job;)V", "isLoading", "Lkotlinx/coroutines/flow/Flow;", "", "()Lkotlinx/coroutines/flow/Flow;", "getStaticCardAccountRanges", "()Lcom/stripe/android/cards/StaticCardAccountRanges;", "cancelAccountRangeRepositoryJob", "", "onCardNumberChanged", "cardNumber", "Lcom/stripe/android/cards/CardNumber$Unvalidated;", "queryAccountRangeRepository", "shouldQueryAccountRange", "shouldQueryRepository", "updateAccountRangeResult", "newAccountRange", "AccountRangeResultListener", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardAccountRangeService.kt */
public final class CardAccountRangeService {
    public static final int $stable = 8;
    private AccountRange accountRange;
    private Job accountRangeRepositoryJob;
    private final AccountRangeResultListener accountRangeResultListener;
    /* access modifiers changed from: private */
    public final CardAccountRangeRepository cardAccountRangeRepository;
    private final Flow<Boolean> isLoading;
    private final StaticCardAccountRanges staticCardAccountRanges;
    private final CoroutineContext workContext;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/stripe/android/cards/CardAccountRangeService$AccountRangeResultListener;", "", "onAccountRangeResult", "", "newAccountRange", "Lcom/stripe/android/model/AccountRange;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardAccountRangeService.kt */
    public interface AccountRangeResultListener {
        void onAccountRangeResult(AccountRange accountRange);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: CardAccountRangeService.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardBrand.values().length];
            iArr[CardBrand.Unknown.ordinal()] = 1;
            iArr[CardBrand.UnionPay.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static /* synthetic */ void getAccountRangeRepositoryJob$annotations() {
    }

    public CardAccountRangeService(CardAccountRangeRepository cardAccountRangeRepository2, CoroutineContext coroutineContext, StaticCardAccountRanges staticCardAccountRanges2, AccountRangeResultListener accountRangeResultListener2) {
        Intrinsics.checkNotNullParameter(cardAccountRangeRepository2, "cardAccountRangeRepository");
        Intrinsics.checkNotNullParameter(coroutineContext, "workContext");
        Intrinsics.checkNotNullParameter(staticCardAccountRanges2, "staticCardAccountRanges");
        Intrinsics.checkNotNullParameter(accountRangeResultListener2, "accountRangeResultListener");
        this.cardAccountRangeRepository = cardAccountRangeRepository2;
        this.workContext = coroutineContext;
        this.staticCardAccountRanges = staticCardAccountRanges2;
        this.accountRangeResultListener = accountRangeResultListener2;
        this.isLoading = cardAccountRangeRepository2.getLoading();
    }

    public final StaticCardAccountRanges getStaticCardAccountRanges() {
        return this.staticCardAccountRanges;
    }

    public final Flow<Boolean> isLoading() {
        return this.isLoading;
    }

    public final AccountRange getAccountRange() {
        return this.accountRange;
    }

    public final Job getAccountRangeRepositoryJob() {
        return this.accountRangeRepositoryJob;
    }

    public final void setAccountRangeRepositoryJob(Job job) {
        this.accountRangeRepositoryJob = job;
    }

    public final void onCardNumberChanged(CardNumber.Unvalidated unvalidated) {
        AccountRange accountRange2;
        Intrinsics.checkNotNullParameter(unvalidated, "cardNumber");
        List<AccountRange> filter = this.staticCardAccountRanges.filter(unvalidated);
        if (filter.size() == 1) {
            accountRange2 = (AccountRange) CollectionsKt.first(filter);
        } else {
            accountRange2 = null;
        }
        if (accountRange2 == null || shouldQueryRepository(accountRange2)) {
            queryAccountRangeRepository(unvalidated);
        } else {
            updateAccountRangeResult(accountRange2);
        }
    }

    public final /* synthetic */ void queryAccountRangeRepository(CardNumber.Unvalidated unvalidated) {
        Intrinsics.checkNotNullParameter(unvalidated, "cardNumber");
        if (shouldQueryAccountRange(unvalidated)) {
            cancelAccountRangeRepositoryJob();
            this.accountRange = null;
            this.accountRangeRepositoryJob = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.workContext), (CoroutineContext) null, (CoroutineStart) null, new CardAccountRangeService$queryAccountRangeRepository$1(unvalidated, this, (Continuation<? super CardAccountRangeService$queryAccountRangeRepository$1>) null), 3, (Object) null);
        }
    }

    public final void cancelAccountRangeRepositoryJob() {
        Job job = this.accountRangeRepositoryJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.accountRangeRepositoryJob = null;
    }

    public final /* synthetic */ void updateAccountRangeResult(AccountRange accountRange2) {
        this.accountRange = accountRange2;
        this.accountRangeResultListener.onAccountRangeResult(accountRange2);
    }

    private final boolean shouldQueryRepository(AccountRange accountRange2) {
        int i = WhenMappings.$EnumSwitchMapping$0[accountRange2.getBrand().ordinal()];
        return i == 1 || i == 2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0012, code lost:
        r0 = r0.getBinRange();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean shouldQueryAccountRange(com.stripe.android.cards.CardNumber.Unvalidated r4) {
        /*
            r3 = this;
            com.stripe.android.model.AccountRange r0 = r3.accountRange
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0024
            com.stripe.android.cards.Bin r0 = r4.getBin()
            if (r0 == 0) goto L_0x0024
            com.stripe.android.model.AccountRange r0 = r3.accountRange
            if (r0 != 0) goto L_0x0012
        L_0x0010:
            r4 = 0
            goto L_0x0020
        L_0x0012:
            com.stripe.android.model.BinRange r0 = r0.getBinRange()
            if (r0 != 0) goto L_0x0019
            goto L_0x0010
        L_0x0019:
            boolean r4 = r0.matches(r4)
            if (r4 != 0) goto L_0x0010
            r4 = 1
        L_0x0020:
            if (r4 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r1 = 0
        L_0x0024:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.cards.CardAccountRangeService.shouldQueryAccountRange(com.stripe.android.cards.CardNumber$Unvalidated):boolean");
    }
}
