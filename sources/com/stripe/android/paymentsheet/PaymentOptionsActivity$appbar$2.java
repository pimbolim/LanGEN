package com.stripe.android.paymentsheet;

import com.google.android.material.appbar.AppBarLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/google/android/material/appbar/AppBarLayout;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionsActivity.kt */
final class PaymentOptionsActivity$appbar$2 extends Lambda implements Function0<AppBarLayout> {
    final /* synthetic */ PaymentOptionsActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentOptionsActivity$appbar$2(PaymentOptionsActivity paymentOptionsActivity) {
        super(0);
        this.this$0 = paymentOptionsActivity;
    }

    public final AppBarLayout invoke() {
        AppBarLayout appBarLayout = this.this$0.getViewBinding$paymentsheet_release().appbar;
        Intrinsics.checkNotNullExpressionValue(appBarLayout, "viewBinding.appbar");
        return appBarLayout;
    }
}
