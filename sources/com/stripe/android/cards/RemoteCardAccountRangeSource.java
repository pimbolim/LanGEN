package com.stripe.android.cards;

import com.stripe.android.core.networking.AnalyticsRequestExecutor;
import com.stripe.android.core.networking.ApiRequest;
import com.stripe.android.model.Token;
import com.stripe.android.networking.PaymentAnalyticsEvent;
import com.stripe.android.networking.PaymentAnalyticsRequestFactory;
import com.stripe.android.networking.StripeRepository;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH\u0002R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/stripe/android/cards/RemoteCardAccountRangeSource;", "Lcom/stripe/android/cards/CardAccountRangeSource;", "stripeRepository", "Lcom/stripe/android/networking/StripeRepository;", "requestOptions", "Lcom/stripe/android/core/networking/ApiRequest$Options;", "cardAccountRangeStore", "Lcom/stripe/android/cards/CardAccountRangeStore;", "analyticsRequestExecutor", "Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;", "paymentAnalyticsRequestFactory", "Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;", "(Lcom/stripe/android/networking/StripeRepository;Lcom/stripe/android/core/networking/ApiRequest$Options;Lcom/stripe/android/cards/CardAccountRangeStore;Lcom/stripe/android/core/networking/AnalyticsRequestExecutor;Lcom/stripe/android/networking/PaymentAnalyticsRequestFactory;)V", "_loading", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "loading", "Lkotlinx/coroutines/flow/Flow;", "getLoading", "()Lkotlinx/coroutines/flow/Flow;", "getAccountRange", "Lcom/stripe/android/model/AccountRange;", "cardNumber", "Lcom/stripe/android/cards/CardNumber$Unvalidated;", "(Lcom/stripe/android/cards/CardNumber$Unvalidated;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCardMetadataMissingRange", "", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RemoteCardAccountRangeSource.kt */
public final class RemoteCardAccountRangeSource implements CardAccountRangeSource {
    private final MutableStateFlow<Boolean> _loading = StateFlowKt.MutableStateFlow(false);
    private final AnalyticsRequestExecutor analyticsRequestExecutor;
    private final CardAccountRangeStore cardAccountRangeStore;
    private final PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory;
    private final ApiRequest.Options requestOptions;
    private final StripeRepository stripeRepository;

    public RemoteCardAccountRangeSource(StripeRepository stripeRepository2, ApiRequest.Options options, CardAccountRangeStore cardAccountRangeStore2, AnalyticsRequestExecutor analyticsRequestExecutor2, PaymentAnalyticsRequestFactory paymentAnalyticsRequestFactory2) {
        Intrinsics.checkNotNullParameter(stripeRepository2, "stripeRepository");
        Intrinsics.checkNotNullParameter(options, "requestOptions");
        Intrinsics.checkNotNullParameter(cardAccountRangeStore2, "cardAccountRangeStore");
        Intrinsics.checkNotNullParameter(analyticsRequestExecutor2, "analyticsRequestExecutor");
        Intrinsics.checkNotNullParameter(paymentAnalyticsRequestFactory2, "paymentAnalyticsRequestFactory");
        this.stripeRepository = stripeRepository2;
        this.requestOptions = options;
        this.cardAccountRangeStore = cardAccountRangeStore2;
        this.analyticsRequestExecutor = analyticsRequestExecutor2;
        this.paymentAnalyticsRequestFactory = paymentAnalyticsRequestFactory2;
    }

    public Flow<Boolean> getLoading() {
        return this._loading;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.stripe.android.model.AccountRange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.stripe.android.model.AccountRange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.stripe.android.model.AccountRange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.stripe.android.model.AccountRange} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.stripe.android.model.AccountRange} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getAccountRange(com.stripe.android.cards.CardNumber.Unvalidated r7, kotlin.coroutines.Continuation<? super com.stripe.android.model.AccountRange> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.stripe.android.cards.RemoteCardAccountRangeSource$getAccountRange$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.stripe.android.cards.RemoteCardAccountRangeSource$getAccountRange$1 r0 = (com.stripe.android.cards.RemoteCardAccountRangeSource$getAccountRange$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.stripe.android.cards.RemoteCardAccountRangeSource$getAccountRange$1 r0 = new com.stripe.android.cards.RemoteCardAccountRangeSource$getAccountRange$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r4) goto L_0x0037
            java.lang.Object r7 = r0.L$2
            com.stripe.android.cards.Bin r7 = (com.stripe.android.cards.Bin) r7
            java.lang.Object r1 = r0.L$1
            com.stripe.android.cards.CardNumber$Unvalidated r1 = (com.stripe.android.cards.CardNumber.Unvalidated) r1
            java.lang.Object r0 = r0.L$0
            com.stripe.android.cards.RemoteCardAccountRangeSource r0 = (com.stripe.android.cards.RemoteCardAccountRangeSource) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006a
        L_0x0037:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r8)
            com.stripe.android.cards.Bin r8 = r7.getBin()
            if (r8 != 0) goto L_0x004a
            goto L_0x00be
        L_0x004a:
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r2 = r6._loading
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            r2.setValue(r5)
            com.stripe.android.networking.StripeRepository r2 = r6.stripeRepository
            com.stripe.android.core.networking.ApiRequest$Options r5 = r6.requestOptions
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r8
            r0.label = r4
            java.lang.Object r0 = r2.getCardMetadata$payments_core_release(r8, r5, r0)
            if (r0 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r1 = r7
            r7 = r8
            r8 = r0
            r0 = r6
        L_0x006a:
            com.stripe.android.model.CardMetadata r8 = (com.stripe.android.model.CardMetadata) r8
            if (r8 != 0) goto L_0x0070
            r8 = r3
            goto L_0x0074
        L_0x0070:
            java.util.List r8 = r8.getAccountRanges()
        L_0x0074:
            if (r8 != 0) goto L_0x007a
            java.util.List r8 = kotlin.collections.CollectionsKt.emptyList()
        L_0x007a:
            com.stripe.android.cards.CardAccountRangeStore r2 = r0.cardAccountRangeStore
            r2.save(r7, r8)
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r7 = r0._loading
            r2 = 0
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            r7.setValue(r2)
            r7 = r8
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            r7 = r7 ^ r4
            if (r7 == 0) goto L_0x00be
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
        L_0x0099:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00b1
            java.lang.Object r8 = r7.next()
            r2 = r8
            com.stripe.android.model.AccountRange r2 = (com.stripe.android.model.AccountRange) r2
            com.stripe.android.model.BinRange r2 = r2.component1()
            boolean r2 = r2.matches(r1)
            if (r2 == 0) goto L_0x0099
            r3 = r8
        L_0x00b1:
            com.stripe.android.model.AccountRange r3 = (com.stripe.android.model.AccountRange) r3
            if (r3 != 0) goto L_0x00be
            boolean r7 = r1.isValidLuhn()
            if (r7 == 0) goto L_0x00be
            r0.onCardMetadataMissingRange()
        L_0x00be:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.cards.RemoteCardAccountRangeSource.getAccountRange(com.stripe.android.cards.CardNumber$Unvalidated, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void onCardMetadataMissingRange() {
        this.analyticsRequestExecutor.executeAsync(PaymentAnalyticsRequestFactory.createRequest$payments_core_release$default(this.paymentAnalyticsRequestFactory, PaymentAnalyticsEvent.CardMetadataMissingRange, (Set) null, (String) null, (Token.Type) null, (PaymentAnalyticsRequestFactory.ThreeDS2UiType) null, 30, (Object) null));
    }
}
