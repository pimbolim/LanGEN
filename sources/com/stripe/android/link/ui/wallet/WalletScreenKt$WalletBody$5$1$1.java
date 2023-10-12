package com.stripe.android.link.ui.wallet;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WalletScreen.kt */
final class WalletScreenKt$WalletBody$5$1$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ MutableState<Integer> $selectedIndex$delegate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletScreenKt$WalletBody$5$1$1(MutableState<Integer> mutableState) {
        super(1);
        this.$selectedIndex$delegate = mutableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        WalletScreenKt.m4360WalletBody$lambda9$lambda5(this.$selectedIndex$delegate, i);
    }
}
