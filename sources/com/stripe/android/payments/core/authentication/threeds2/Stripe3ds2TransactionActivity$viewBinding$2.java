package com.stripe.android.payments.core.authentication.threeds2;

import com.stripe.android.databinding.Stripe3ds2TransactionLayoutBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/databinding/Stripe3ds2TransactionLayoutBinding;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Stripe3ds2TransactionActivity.kt */
final class Stripe3ds2TransactionActivity$viewBinding$2 extends Lambda implements Function0<Stripe3ds2TransactionLayoutBinding> {
    final /* synthetic */ Stripe3ds2TransactionActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Stripe3ds2TransactionActivity$viewBinding$2(Stripe3ds2TransactionActivity stripe3ds2TransactionActivity) {
        super(0);
        this.this$0 = stripe3ds2TransactionActivity;
    }

    public final Stripe3ds2TransactionLayoutBinding invoke() {
        Stripe3ds2TransactionLayoutBinding inflate = Stripe3ds2TransactionLayoutBinding.inflate(this.this$0.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(layoutInflater)");
        return inflate;
    }
}
