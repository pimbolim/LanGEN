package com.stripe.android.link.ui.wallet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WalletScreen.kt */
/* synthetic */ class WalletScreenKt$WalletBody$3 extends FunctionReferenceImpl implements Function0<Unit> {
    WalletScreenKt$WalletBody$3(Object obj) {
        super(0, obj, WalletViewModel.class, "addNewPaymentMethod", "addNewPaymentMethod()V", 0);
    }

    public final void invoke() {
        ((WalletViewModel) this.receiver).addNewPaymentMethod();
    }
}
