package com.stripe.android.link.ui.wallet;

import com.stripe.android.link.LinkActivityResult;
import com.stripe.android.payments.paymentlauncher.PaymentResult;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "result", "Lkotlin/Result;", "Lcom/stripe/android/payments/paymentlauncher/PaymentResult;", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WalletViewModel.kt */
final class WalletViewModel$completePayment$1 extends Lambda implements Function1<Result<? extends PaymentResult>, Unit> {
    final /* synthetic */ WalletViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WalletViewModel$completePayment$1(WalletViewModel walletViewModel) {
        super(1);
        this.this$0 = walletViewModel;
    }

    public final void invoke(Object obj) {
        WalletViewModel walletViewModel = this.this$0;
        Throwable r1 = Result.m4712exceptionOrNullimpl(obj);
        if (r1 == null) {
            PaymentResult paymentResult = (PaymentResult) obj;
            if (!(paymentResult instanceof PaymentResult.Canceled)) {
                if (paymentResult instanceof PaymentResult.Failed) {
                    walletViewModel.onError(((PaymentResult.Failed) paymentResult).getThrowable());
                } else if (paymentResult instanceof PaymentResult.Completed) {
                    walletViewModel.navigator.dismiss(LinkActivityResult.Success.INSTANCE);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        } else {
            walletViewModel.onError(r1);
        }
        this.this$0.isProcessing().setValue(false);
    }
}
