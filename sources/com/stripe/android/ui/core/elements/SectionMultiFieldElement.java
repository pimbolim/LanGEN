package com.stripe.android.ui.core.elements;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/stripe/android/ui/core/elements/SectionMultiFieldElement;", "Lcom/stripe/android/ui/core/elements/SectionFieldElement;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;)V", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "Lcom/stripe/android/ui/core/elements/AddressElement;", "Lcom/stripe/android/ui/core/elements/CardDetailsElement;", "Lcom/stripe/android/ui/core/elements/RowElement;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SectionMultiFieldElement.kt */
public abstract class SectionMultiFieldElement implements SectionFieldElement {
    public static final int $stable = 0;
    private final IdentifierSpec identifier;

    public /* synthetic */ SectionMultiFieldElement(IdentifierSpec identifierSpec, DefaultConstructorMarker defaultConstructorMarker) {
        this(identifierSpec);
    }

    private SectionMultiFieldElement(IdentifierSpec identifierSpec) {
        this.identifier = identifierSpec;
    }

    public IdentifierSpec getIdentifier() {
        return this.identifier;
    }
}
