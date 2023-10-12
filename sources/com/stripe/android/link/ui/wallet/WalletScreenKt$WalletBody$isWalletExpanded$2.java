package com.stripe.android.link.ui.wallet;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WalletScreen.kt */
final class WalletScreenKt$WalletBody$isWalletExpanded$2 extends Lambda implements Function0<MutableState<Boolean>> {
    public static final WalletScreenKt$WalletBody$isWalletExpanded$2 INSTANCE = new WalletScreenKt$WalletBody$isWalletExpanded$2();

    WalletScreenKt$WalletBody$isWalletExpanded$2() {
        super(0);
    }

    public final MutableState<Boolean> invoke() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    }
}
