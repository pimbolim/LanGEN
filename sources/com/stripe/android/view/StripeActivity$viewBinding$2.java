package com.stripe.android.view;

import com.stripe.android.databinding.StripeActivityBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/databinding/StripeActivityBinding;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: StripeActivity.kt */
final class StripeActivity$viewBinding$2 extends Lambda implements Function0<StripeActivityBinding> {
    final /* synthetic */ StripeActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StripeActivity$viewBinding$2(StripeActivity stripeActivity) {
        super(0);
        this.this$0 = stripeActivity;
    }

    public final StripeActivityBinding invoke() {
        StripeActivityBinding inflate = StripeActivityBinding.inflate(this.this$0.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        return inflate;
    }
}
