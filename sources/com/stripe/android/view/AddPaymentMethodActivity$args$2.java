package com.stripe.android.view;

import android.content.Intent;
import com.stripe.android.view.AddPaymentMethodActivityStarter;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/view/AddPaymentMethodActivityStarter$Args;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddPaymentMethodActivity.kt */
final class AddPaymentMethodActivity$args$2 extends Lambda implements Function0<AddPaymentMethodActivityStarter.Args> {
    final /* synthetic */ AddPaymentMethodActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AddPaymentMethodActivity$args$2(AddPaymentMethodActivity addPaymentMethodActivity) {
        super(0);
        this.this$0 = addPaymentMethodActivity;
    }

    public final AddPaymentMethodActivityStarter.Args invoke() {
        AddPaymentMethodActivityStarter.Args.Companion companion = AddPaymentMethodActivityStarter.Args.Companion;
        Intent intent = this.this$0.getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "intent");
        return companion.create$payments_core_release(intent);
    }
}
