package com.stripe.android.paymentsheet;

import androidx.compose.runtime.Composer;
import com.drew.metadata.exif.makernotes.LeicaMakernoteDirectory;
import com.stripe.android.paymentsheet.PaymentOptionsAdapter;
import com.stripe.android.ui.core.PaymentsTheme;
import com.stripe.android.ui.core.PaymentsThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaymentOptionsAdapter.kt */
final class PaymentOptionsAdapter$AddNewPaymentMethodViewHolder$bind$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ boolean $isEnabled;
    final /* synthetic */ PaymentOptionsAdapter.AddNewPaymentMethodViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PaymentOptionsAdapter$AddNewPaymentMethodViewHolder$bind$1(PaymentOptionsAdapter.AddNewPaymentMethodViewHolder addNewPaymentMethodViewHolder, boolean z) {
        super(2);
        this.this$0 = addNewPaymentMethodViewHolder;
        this.$isEnabled = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        int i2;
        if (((i & 11) ^ 2) != 0 || !composer.getSkipping()) {
            if (PaymentsThemeKt.m4516shouldUseDarkDynamicColor8_81llA(PaymentsTheme.INSTANCE.getColors(composer, 8).m4504getComponent0d7_KjU())) {
                i2 = R.drawable.stripe_ic_paymentsheet_add_dark;
            } else {
                i2 = R.drawable.stripe_ic_paymentsheet_add_light;
            }
            float access$getWidth$p = this.this$0.width;
            String string = this.this$0.itemView.getResources().getString(R.string.stripe_paymentsheet_add_payment_method_button_label);
            String string2 = this.this$0.itemView.getResources().getString(R.string.add_new_payment_method);
            boolean z = this.$isEnabled;
            Intrinsics.checkNotNullExpressionValue(string, "getString(\n             …bel\n                    )");
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.add_new_payment_method)");
            final PaymentOptionsAdapter.AddNewPaymentMethodViewHolder addNewPaymentMethodViewHolder = this.this$0;
            PaymentOptionsAdapterKt.m4405PaymentOptionUijFuDa88(access$getWidth$p, false, false, z, i2, string, (String) null, string2, (Function0<Unit>) null, (String) null, new Function0<Unit>() {
                public final void invoke() {
                    addNewPaymentMethodViewHolder.onItemSelectedListener.invoke();
                }
            }, composer, 432, 0, LeicaMakernoteDirectory.TAG_IMAGE_ID_NUMBER);
            return;
        }
        composer.skipToGroupEnd();
    }
}
