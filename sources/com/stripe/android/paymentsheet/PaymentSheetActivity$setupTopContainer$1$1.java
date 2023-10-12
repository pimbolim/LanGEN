package com.stripe.android.paymentsheet;

import android.content.res.Resources;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.platform.ComposeView;
import com.stripe.android.paymentsheet.model.SupportedPaymentMethod;
import com.stripe.android.paymentsheet.ui.GooglePayDividerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentSheetActivity.kt */
final class PaymentSheetActivity$setupTopContainer$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ ComposeView $this_apply;
    final /* synthetic */ PaymentSheetActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentSheetActivity$setupTopContainer$1$1(ComposeView composeView, PaymentSheetActivity paymentSheetActivity) {
        super(2);
        this.$this_apply = composeView;
        this.this$0 = paymentSheetActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        int i2;
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Resources resources = this.$this_apply.getContext().getResources();
            if (this.this$0.getViewModel().getSupportedPaymentMethods$paymentsheet_release().size() != 1 || !this.this$0.getViewModel().getSupportedPaymentMethods$paymentsheet_release().contains(SupportedPaymentMethod.Card.INSTANCE)) {
                i2 = R.string.stripe_paymentsheet_or_pay_using;
            } else {
                i2 = R.string.stripe_paymentsheet_or_pay_with_card;
            }
            String string = resources.getString(i2);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…  }\n                    )");
            GooglePayDividerKt.GooglePayDividerUi(string, composer, 0, 0);
            return;
        }
        composer.skipToGroupEnd();
    }
}
