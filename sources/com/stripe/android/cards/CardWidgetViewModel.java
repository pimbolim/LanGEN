package com.stripe.android.cards;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.lifecycle.LiveData;
import com.stripe.android.cards.CardAccountRangeRepository;
import com.stripe.android.cards.CardNumber;
import com.stripe.android.model.AccountRange;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012R\u001b\u0010\b\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/cards/CardWidgetViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "cardAccountRangeRepositoryFactory", "Lcom/stripe/android/cards/CardAccountRangeRepository$Factory;", "(Landroid/app/Application;Lcom/stripe/android/cards/CardAccountRangeRepository$Factory;)V", "cardAccountRangeRepository", "Lcom/stripe/android/cards/CardAccountRangeRepository;", "getCardAccountRangeRepository", "()Lcom/stripe/android/cards/CardAccountRangeRepository;", "cardAccountRangeRepository$delegate", "Lkotlin/Lazy;", "getAccountRange", "Landroidx/lifecycle/LiveData;", "Lcom/stripe/android/model/AccountRange;", "cardNumber", "Lcom/stripe/android/cards/CardNumber$Unvalidated;", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardWidgetViewModel.kt */
public final class CardWidgetViewModel extends AndroidViewModel {
    private final Lazy cardAccountRangeRepository$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardWidgetViewModel(Application application, CardAccountRangeRepository.Factory factory) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(factory, "cardAccountRangeRepositoryFactory");
        this.cardAccountRangeRepository$delegate = LazyKt.lazy(new CardWidgetViewModel$cardAccountRangeRepository$2(factory));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CardWidgetViewModel(Application application) {
        this(application, new DefaultCardAccountRangeRepositoryFactory(application));
        Intrinsics.checkNotNullParameter(application, "application");
    }

    /* access modifiers changed from: private */
    public final CardAccountRangeRepository getCardAccountRangeRepository() {
        return (CardAccountRangeRepository) this.cardAccountRangeRepository$delegate.getValue();
    }

    public final LiveData<AccountRange> getAccountRange(CardNumber.Unvalidated unvalidated) {
        Intrinsics.checkNotNullParameter(unvalidated, "cardNumber");
        return CoroutineLiveDataKt.liveData$default((CoroutineContext) null, 0, (Function2) new CardWidgetViewModel$getAccountRange$1(this, unvalidated, (Continuation<? super CardWidgetViewModel$getAccountRange$1>) null), 3, (Object) null);
    }
}
