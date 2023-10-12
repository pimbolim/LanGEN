package com.stripe.android.view;

import com.stripe.android.CustomerSession;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/stripe/android/CustomerSession;", "invoke-d1pmJ48", "()Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentMethodsActivity.kt */
final class PaymentMethodsActivity$customerSession$2 extends Lambda implements Function0<Result<? extends CustomerSession>> {
    final /* synthetic */ PaymentMethodsActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentMethodsActivity$customerSession$2(PaymentMethodsActivity paymentMethodsActivity) {
        super(0);
        this.this$0 = paymentMethodsActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return Result.m4708boximpl(m4678invoked1pmJ48());
    }

    /* renamed from: invoke-d1pmJ48  reason: not valid java name */
    public final Object m4678invoked1pmJ48() {
        try {
            Result.Companion companion = Result.Companion;
            return Result.m4709constructorimpl(CustomerSession.Companion.getInstance());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            return Result.m4709constructorimpl(ResultKt.createFailure(th));
        }
    }
}
