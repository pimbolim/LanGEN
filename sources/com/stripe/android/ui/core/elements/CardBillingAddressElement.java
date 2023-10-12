package com.stripe.android.ui.core.elements;

import com.brentvatne.react.ReactVideoView;
import com.stripe.android.ui.core.address.AddressFieldElementRepository;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\f¢\u0006\u0002\u0010\rR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stripe/android/ui/core/elements/CardBillingAddressElement;", "Lcom/stripe/android/ui/core/elements/AddressElement;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "addressFieldRepository", "Lcom/stripe/android/ui/core/address/AddressFieldElementRepository;", "countryCodes", "", "", "countryDropdownFieldController", "Lcom/stripe/android/ui/core/elements/DropdownFieldController;", "rawValuesMap", "", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;Lcom/stripe/android/ui/core/address/AddressFieldElementRepository;Ljava/util/Set;Lcom/stripe/android/ui/core/elements/DropdownFieldController;Ljava/util/Map;)V", "hiddenIdentifiers", "Lkotlinx/coroutines/flow/Flow;", "", "getHiddenIdentifiers", "()Lkotlinx/coroutines/flow/Flow;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CardBillingAddressElement.kt */
public final class CardBillingAddressElement extends AddressElement {
    public static final int $stable = 8;
    private final Flow<List<IdentifierSpec>> hiddenIdentifiers;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CardBillingAddressElement(com.stripe.android.ui.core.elements.IdentifierSpec r7, com.stripe.android.ui.core.address.AddressFieldElementRepository r8, java.util.Set r9, com.stripe.android.ui.core.elements.DropdownFieldController r10, java.util.Map r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 4
            if (r13 == 0) goto L_0x0008
            java.util.Set r9 = kotlin.collections.SetsKt.emptySet()
        L_0x0008:
            r3 = r9
            r9 = r12 & 8
            if (r9 == 0) goto L_0x001b
            com.stripe.android.ui.core.elements.DropdownFieldController r10 = new com.stripe.android.ui.core.elements.DropdownFieldController
            com.stripe.android.ui.core.elements.CountryConfig r9 = new com.stripe.android.ui.core.elements.CountryConfig
            r13 = 0
            r0 = 2
            r9.<init>(r3, r13, r0, r13)
            com.stripe.android.ui.core.elements.DropdownConfig r9 = (com.stripe.android.ui.core.elements.DropdownConfig) r9
            r10.<init>(r9, r13, r0, r13)
        L_0x001b:
            r4 = r10
            r9 = r12 & 16
            if (r9 == 0) goto L_0x0024
            java.util.Map r11 = kotlin.collections.MapsKt.emptyMap()
        L_0x0024:
            r5 = r11
            r0 = r6
            r1 = r7
            r2 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.elements.CardBillingAddressElement.<init>(com.stripe.android.ui.core.elements.IdentifierSpec, com.stripe.android.ui.core.address.AddressFieldElementRepository, java.util.Set, com.stripe.android.ui.core.elements.DropdownFieldController, java.util.Map, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardBillingAddressElement(IdentifierSpec identifierSpec, AddressFieldElementRepository addressFieldElementRepository, Set<String> set, DropdownFieldController dropdownFieldController, Map<IdentifierSpec, String> map) {
        super(identifierSpec, addressFieldElementRepository, map, set, dropdownFieldController);
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        Intrinsics.checkNotNullParameter(addressFieldElementRepository, "addressFieldRepository");
        Intrinsics.checkNotNullParameter(set, "countryCodes");
        Intrinsics.checkNotNullParameter(dropdownFieldController, "countryDropdownFieldController");
        Intrinsics.checkNotNullParameter(map, "rawValuesMap");
        this.hiddenIdentifiers = new CardBillingAddressElement$special$$inlined$map$1(dropdownFieldController.getRawFieldValue());
    }

    public final Flow<List<IdentifierSpec>> getHiddenIdentifiers() {
        return this.hiddenIdentifiers;
    }
}
