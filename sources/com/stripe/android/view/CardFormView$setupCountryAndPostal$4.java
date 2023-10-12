package com.stripe.android.view;

import com.stripe.android.core.model.CountryCode;
import com.stripe.android.core.model.CountryUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "countryCode", "Lcom/stripe/android/core/model/CountryCode;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardFormView.kt */
final class CardFormView$setupCountryAndPostal$4 extends Lambda implements Function1<CountryCode, Unit> {
    final /* synthetic */ CardFormView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CardFormView$setupCountryAndPostal$4(CardFormView cardFormView) {
        super(1);
        this.this$0 = cardFormView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CountryCode) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(CountryCode countryCode) {
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        this.this$0.updatePostalCodeViewLocale(countryCode);
        this.this$0.postalCodeContainer.setVisibility(CountryUtils.INSTANCE.doesCountryUsePostalCode(countryCode) ? 0 : 8);
        this.this$0.postalCodeView.setShouldShowError(false);
        this.this$0.postalCodeView.setText((CharSequence) null);
    }
}
