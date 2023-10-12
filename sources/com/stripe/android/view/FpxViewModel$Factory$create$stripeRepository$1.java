package com.stripe.android.view;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FpxViewModel.kt */
final class FpxViewModel$Factory$create$stripeRepository$1 extends Lambda implements Function0<String> {
    final /* synthetic */ String $publishableKey;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FpxViewModel$Factory$create$stripeRepository$1(String str) {
        super(0);
        this.$publishableKey = str;
    }

    public final String invoke() {
        return this.$publishableKey;
    }
}
