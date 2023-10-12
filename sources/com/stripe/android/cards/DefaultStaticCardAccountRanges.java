package com.stripe.android.cards;

import com.stripe.android.cards.CardNumber;
import com.stripe.android.model.AccountRange;
import com.stripe.android.model.BinRange;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"Lcom/stripe/android/cards/DefaultStaticCardAccountRanges;", "Lcom/stripe/android/cards/StaticCardAccountRanges;", "()V", "filter", "", "Lcom/stripe/android/model/AccountRange;", "cardNumber", "Lcom/stripe/android/cards/CardNumber$Unvalidated;", "first", "Companion", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultStaticCardAccountRanges.kt */
public final class DefaultStaticCardAccountRanges implements StaticCardAccountRanges {
    public static final int $stable = 0;
    /* access modifiers changed from: private */
    public static final List<AccountRange> ACCOUNTS;
    private static final List<AccountRange> AMEX_ACCOUNTS;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final List<AccountRange> DINERSCLUB14_ACCOUNT_RANGES;
    private static final List<AccountRange> DINERSCLUB16_ACCOUNT_RANGES;
    /* access modifiers changed from: private */
    public static final List<AccountRange> DISCOVER_ACCOUNTS;
    private static final List<AccountRange> JCB_ACCOUNTS;
    private static final List<AccountRange> MASTERCARD_ACCOUNTS;
    /* access modifiers changed from: private */
    public static final List<AccountRange> UNIONPAY16_ACCOUNTS;
    /* access modifiers changed from: private */
    public static final List<AccountRange> UNIONPAY19_ACCOUNTS;
    private static final List<AccountRange> VISA_ACCOUNTS;

    public AccountRange first(CardNumber.Unvalidated unvalidated) {
        Intrinsics.checkNotNullParameter(unvalidated, "cardNumber");
        return (AccountRange) CollectionsKt.firstOrNull(filter(unvalidated));
    }

    public List<AccountRange> filter(CardNumber.Unvalidated unvalidated) {
        Intrinsics.checkNotNullParameter(unvalidated, "cardNumber");
        Collection arrayList = new ArrayList();
        for (Object next : ACCOUNTS) {
            if (((AccountRange) next).getBinRange().matches(unvalidated)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u0007R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0007R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/stripe/android/cards/DefaultStaticCardAccountRanges$Companion;", "", "()V", "ACCOUNTS", "", "Lcom/stripe/android/model/AccountRange;", "getACCOUNTS$payments_core_release", "()Ljava/util/List;", "AMEX_ACCOUNTS", "DINERSCLUB14_ACCOUNT_RANGES", "DINERSCLUB16_ACCOUNT_RANGES", "DISCOVER_ACCOUNTS", "getDISCOVER_ACCOUNTS$payments_core_release", "JCB_ACCOUNTS", "MASTERCARD_ACCOUNTS", "UNIONPAY16_ACCOUNTS", "getUNIONPAY16_ACCOUNTS$payments_core_release$annotations", "getUNIONPAY16_ACCOUNTS$payments_core_release", "UNIONPAY19_ACCOUNTS", "getUNIONPAY19_ACCOUNTS$payments_core_release$annotations", "getUNIONPAY19_ACCOUNTS$payments_core_release", "VISA_ACCOUNTS", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultStaticCardAccountRanges.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getUNIONPAY16_ACCOUNTS$payments_core_release$annotations() {
        }

        public static /* synthetic */ void getUNIONPAY19_ACCOUNTS$payments_core_release$annotations() {
        }

        private Companion() {
        }

        public final List<AccountRange> getDISCOVER_ACCOUNTS$payments_core_release() {
            return DefaultStaticCardAccountRanges.DISCOVER_ACCOUNTS;
        }

        public final List<AccountRange> getUNIONPAY16_ACCOUNTS$payments_core_release() {
            return DefaultStaticCardAccountRanges.UNIONPAY16_ACCOUNTS;
        }

        public final List<AccountRange> getUNIONPAY19_ACCOUNTS$payments_core_release() {
            return DefaultStaticCardAccountRanges.UNIONPAY19_ACCOUNTS;
        }

        public final List<AccountRange> getACCOUNTS$payments_core_release() {
            return DefaultStaticCardAccountRanges.ACCOUNTS;
        }
    }

    static {
        Iterable<BinRange> of = SetsKt.setOf(new BinRange("4000000000000000", "4999999999999999"));
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(of, 10));
        for (BinRange accountRange : of) {
            arrayList.add(new AccountRange(accountRange, 16, AccountRange.BrandInfo.Visa, (String) null, 8, (DefaultConstructorMarker) null));
        }
        VISA_ACCOUNTS = (List) arrayList;
        Iterable<BinRange> of2 = SetsKt.setOf(new BinRange("2221000000000000", "2720999999999999"), new BinRange("5100000000000000", "5599999999999999"));
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(of2, 10));
        for (BinRange accountRange2 : of2) {
            arrayList2.add(new AccountRange(accountRange2, 16, AccountRange.BrandInfo.Mastercard, (String) null, 8, (DefaultConstructorMarker) null));
        }
        MASTERCARD_ACCOUNTS = (List) arrayList2;
        Iterable<BinRange> of3 = SetsKt.setOf(new BinRange("340000000000000", "349999999999999"), new BinRange("370000000000000", "379999999999999"));
        Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(of3, 10));
        for (BinRange accountRange3 : of3) {
            arrayList3.add(new AccountRange(accountRange3, 15, AccountRange.BrandInfo.AmericanExpress, (String) null, 8, (DefaultConstructorMarker) null));
        }
        AMEX_ACCOUNTS = (List) arrayList3;
        Iterable<BinRange> of4 = SetsKt.setOf(new BinRange("6000000000000000", "6099999999999999"), new BinRange("6400000000000000", "6499999999999999"), new BinRange("6500000000000000", "6599999999999999"));
        Collection arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(of4, 10));
        for (BinRange accountRange4 : of4) {
            arrayList4.add(new AccountRange(accountRange4, 16, AccountRange.BrandInfo.Discover, (String) null, 8, (DefaultConstructorMarker) null));
        }
        DISCOVER_ACCOUNTS = (List) arrayList4;
        Iterable<BinRange> of5 = SetsKt.setOf(new BinRange("3528000000000000", "3589999999999999"));
        Collection arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(of5, 10));
        for (BinRange accountRange5 : of5) {
            arrayList5.add(new AccountRange(accountRange5, 16, AccountRange.BrandInfo.JCB, (String) null, 8, (DefaultConstructorMarker) null));
        }
        JCB_ACCOUNTS = (List) arrayList5;
        Iterable<BinRange> of6 = SetsKt.setOf(new BinRange("6200000000000000", "6216828049999999"), new BinRange("6216828060000000", "6299999999999999"), new BinRange("8100000000000000", "8199999999999999"));
        Collection arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(of6, 10));
        for (BinRange accountRange6 : of6) {
            arrayList6.add(new AccountRange(accountRange6, 16, AccountRange.BrandInfo.UnionPay, (String) null, 8, (DefaultConstructorMarker) null));
        }
        UNIONPAY16_ACCOUNTS = (List) arrayList6;
        Iterable<BinRange> of7 = SetsKt.setOf(new BinRange("6216828050000000000", "6216828059999999999"));
        Collection arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(of7, 10));
        for (BinRange accountRange7 : of7) {
            arrayList7.add(new AccountRange(accountRange7, 19, AccountRange.BrandInfo.UnionPay, (String) null, 8, (DefaultConstructorMarker) null));
        }
        UNIONPAY19_ACCOUNTS = (List) arrayList7;
        Iterable<BinRange> of8 = SetsKt.setOf(new BinRange("3000000000000000", "3059999999999999"), new BinRange("3095000000000000", "3095999999999999"), new BinRange("3800000000000000", "3999999999999999"));
        Collection arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(of8, 10));
        for (BinRange accountRange8 : of8) {
            arrayList8.add(new AccountRange(accountRange8, 16, AccountRange.BrandInfo.DinersClub, (String) null, 8, (DefaultConstructorMarker) null));
        }
        DINERSCLUB16_ACCOUNT_RANGES = (List) arrayList8;
        Iterable<BinRange> of9 = SetsKt.setOf(new BinRange("36000000000000", "36999999999999"));
        Collection arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(of9, 10));
        for (BinRange accountRange9 : of9) {
            arrayList9.add(new AccountRange(accountRange9, 14, AccountRange.BrandInfo.DinersClub, (String) null, 8, (DefaultConstructorMarker) null));
        }
        List<AccountRange> list = (List) arrayList9;
        DINERSCLUB14_ACCOUNT_RANGES = list;
        ACCOUNTS = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(VISA_ACCOUNTS, MASTERCARD_ACCOUNTS), AMEX_ACCOUNTS), DISCOVER_ACCOUNTS), JCB_ACCOUNTS), UNIONPAY16_ACCOUNTS), UNIONPAY19_ACCOUNTS), DINERSCLUB16_ACCOUNT_RANGES), list);
    }
}
