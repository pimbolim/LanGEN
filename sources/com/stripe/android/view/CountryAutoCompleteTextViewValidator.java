package com.stripe.android.view;

import android.widget.AutoCompleteTextView;
import com.stripe.android.core.model.Country;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stripe/android/view/CountryAutoCompleteTextViewValidator;", "Landroid/widget/AutoCompleteTextView$Validator;", "countryAdapter", "Lcom/stripe/android/view/CountryAdapter;", "onCountrySelected", "Lkotlin/Function1;", "Lcom/stripe/android/core/model/Country;", "", "(Lcom/stripe/android/view/CountryAdapter;Lkotlin/jvm/functions/Function1;)V", "fixText", "", "invalidText", "isValid", "", "text", "payments-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CountryAutoCompleteTextViewValidator.kt */
public final class CountryAutoCompleteTextViewValidator implements AutoCompleteTextView.Validator {
    private final CountryAdapter countryAdapter;
    private final Function1<Country, Unit> onCountrySelected;

    public CountryAutoCompleteTextViewValidator(CountryAdapter countryAdapter2, Function1<? super Country, Unit> function1) {
        Intrinsics.checkNotNullParameter(countryAdapter2, "countryAdapter");
        Intrinsics.checkNotNullParameter(function1, "onCountrySelected");
        this.countryAdapter = countryAdapter2;
        this.onCountrySelected = function1;
    }

    public CharSequence fixText(CharSequence charSequence) {
        return charSequence == null ? "" : charSequence;
    }

    public boolean isValid(CharSequence charSequence) {
        Object obj;
        Iterator it = this.countryAdapter.getUnfilteredCountries$payments_core_release().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((Country) obj).getName(), (Object) String.valueOf(charSequence))) {
                break;
            }
        }
        this.onCountrySelected.invoke(obj);
        return ((Country) obj) != null;
    }
}
