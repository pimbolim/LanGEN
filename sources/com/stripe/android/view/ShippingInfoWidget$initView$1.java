package com.stripe.android.view;

import com.stripe.android.core.model.Country;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShippingInfoWidget.kt */
/* synthetic */ class ShippingInfoWidget$initView$1 extends FunctionReferenceImpl implements Function1<Country, Unit> {
    ShippingInfoWidget$initView$1(Object obj) {
        super(1, obj, ShippingInfoWidget.class, "updateConfigForCountry", "updateConfigForCountry(Lcom/stripe/android/core/model/Country;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Country) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Country country) {
        Intrinsics.checkNotNullParameter(country, "p0");
        ((ShippingInfoWidget) this.receiver).updateConfigForCountry(country);
    }
}
