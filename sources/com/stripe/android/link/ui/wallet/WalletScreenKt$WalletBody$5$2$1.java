package com.stripe.android.link.ui.wallet;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WalletScreen.kt */
final class WalletScreenKt$WalletBody$5$2$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MutableState<Boolean> $isWalletExpanded$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletScreenKt$WalletBody$5$2$1(MutableState<Boolean> mutableState) {
        super(0);
        this.$isWalletExpanded$delegate = mutableState;
    }

    public final void invoke() {
        WalletScreenKt.m4358WalletBody$lambda3(this.$isWalletExpanded$delegate, false);
    }
}
