package com.stripe.android.googlepaylauncher;

import com.stripe.android.googlepaylauncher.StripeGooglePayViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Landroidx/lifecycle/ViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeGooglePayViewModel.kt */
final class StripeGooglePayViewModel$Factory$create$1 extends Lambda implements Function0<String> {
    final /* synthetic */ StripeGooglePayViewModel.Factory this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeGooglePayViewModel$Factory$create$1(StripeGooglePayViewModel.Factory factory) {
        super(0);
        this.this$0 = factory;
    }

    public final String invoke() {
        return this.this$0.publishableKey;
    }
}
