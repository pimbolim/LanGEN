package com.stripe.android.view;

import android.content.Intent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentAuthWebViewActivity.kt */
/* synthetic */ class PaymentAuthWebViewActivity$onCreate$webViewClient$1 extends FunctionReferenceImpl implements Function1<Intent, Unit> {
    PaymentAuthWebViewActivity$onCreate$webViewClient$1(Object obj) {
        super(1, obj, PaymentAuthWebViewActivity.class, "startActivity", "startActivity(Landroid/content/Intent;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Intent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Intent intent) {
        ((PaymentAuthWebViewActivity) this.receiver).startActivity(intent);
    }
}
