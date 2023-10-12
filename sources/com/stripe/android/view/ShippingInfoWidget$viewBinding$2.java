package com.stripe.android.view;

import android.content.Context;
import android.view.LayoutInflater;
import com.stripe.android.databinding.AddressWidgetBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/stripe/android/databinding/AddressWidgetBinding;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShippingInfoWidget.kt */
final class ShippingInfoWidget$viewBinding$2 extends Lambda implements Function0<AddressWidgetBinding> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ShippingInfoWidget this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShippingInfoWidget$viewBinding$2(Context context, ShippingInfoWidget shippingInfoWidget) {
        super(0);
        this.$context = context;
        this.this$0 = shippingInfoWidget;
    }

    public final AddressWidgetBinding invoke() {
        AddressWidgetBinding inflate = AddressWidgetBinding.inflate(LayoutInflater.from(this.$context), this.this$0);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(\n            Lay…           this\n        )");
        return inflate;
    }
}
