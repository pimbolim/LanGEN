package com.stripe.android.view;

import com.stripe.android.core.model.CountryCode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/stripe/android/core/model/CountryCode;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CountryTextInputLayout.kt */
final class CountryTextInputLayout$countryCodeChangeCallback$1 extends Lambda implements Function1<CountryCode, Unit> {
    public static final CountryTextInputLayout$countryCodeChangeCallback$1 INSTANCE = new CountryTextInputLayout$countryCodeChangeCallback$1();

    CountryTextInputLayout$countryCodeChangeCallback$1() {
        super(1);
    }

    public final void invoke(CountryCode countryCode) {
        Intrinsics.checkNotNullParameter(countryCode, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CountryCode) obj);
        return Unit.INSTANCE;
    }
}
