package com.stripe.android.view;

import com.stripe.android.view.BecsDebitBanks;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/stripe/android/view/BecsDebitBanks$Bank;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: BecsDebitBsbEditText.kt */
final class BecsDebitBsbEditText$onBankChangedCallback$1 extends Lambda implements Function1<BecsDebitBanks.Bank, Unit> {
    public static final BecsDebitBsbEditText$onBankChangedCallback$1 INSTANCE = new BecsDebitBsbEditText$onBankChangedCallback$1();

    BecsDebitBsbEditText$onBankChangedCallback$1() {
        super(1);
    }

    public final void invoke(BecsDebitBanks.Bank bank) {
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BecsDebitBanks.Bank) obj);
        return Unit.INSTANCE;
    }
}
