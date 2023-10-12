package com.stripe.android.ui.core.elements;

import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\n\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/ui/core/elements/SectionFieldSpec;", "Landroid/os/Parcelable;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;)V", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "Lcom/stripe/android/ui/core/elements/AddressSpec;", "Lcom/stripe/android/ui/core/elements/AuBankAccountNumberSpec;", "Lcom/stripe/android/ui/core/elements/BankDropdownSpec;", "Lcom/stripe/android/ui/core/elements/CardBillingSpec;", "Lcom/stripe/android/ui/core/elements/CardDetailsSpec;", "Lcom/stripe/android/ui/core/elements/CountrySpec;", "Lcom/stripe/android/ui/core/elements/EmailSpec;", "Lcom/stripe/android/ui/core/elements/IbanSpec;", "Lcom/stripe/android/ui/core/elements/KlarnaCountrySpec;", "Lcom/stripe/android/ui/core/elements/SimpleTextSpec;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SectionFieldSpec.kt */
public abstract class SectionFieldSpec implements Parcelable {
    public static final int $stable = 0;
    private final IdentifierSpec identifier;

    public /* synthetic */ SectionFieldSpec(IdentifierSpec identifierSpec, DefaultConstructorMarker defaultConstructorMarker) {
        this(identifierSpec);
    }

    private SectionFieldSpec(IdentifierSpec identifierSpec) {
        this.identifier = identifierSpec;
    }

    public IdentifierSpec getIdentifier() {
        return this.identifier;
    }
}
