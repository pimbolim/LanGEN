package com.stripe.android.ui.core.elements;

import com.stripe.android.ui.core.address.AddressFieldElementRepository;
import com.stripe.android.ui.core.elements.IdentifierSpec;
import com.stripe.android.ui.core.forms.FormFieldEntry;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ \u0010\u001f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020!0 0\u001a0\u0019H\u0016J\u0014\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a0\u0019H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u001e\u0010%\u001a\u00020&2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u00138\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/stripe/android/ui/core/elements/AddressElement;", "Lcom/stripe/android/ui/core/elements/SectionMultiFieldElement;", "_identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "addressFieldRepository", "Lcom/stripe/android/ui/core/address/AddressFieldElementRepository;", "rawValuesMap", "", "", "countryCodes", "", "countryDropdownFieldController", "Lcom/stripe/android/ui/core/elements/DropdownFieldController;", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;Lcom/stripe/android/ui/core/address/AddressFieldElementRepository;Ljava/util/Map;Ljava/util/Set;Lcom/stripe/android/ui/core/elements/DropdownFieldController;)V", "controller", "Lcom/stripe/android/ui/core/elements/AddressController;", "getController", "()Lcom/stripe/android/ui/core/elements/AddressController;", "countryElement", "Lcom/stripe/android/ui/core/elements/CountryElement;", "getCountryElement$annotations", "()V", "getCountryElement", "()Lcom/stripe/android/ui/core/elements/CountryElement;", "fields", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/stripe/android/ui/core/elements/SectionFieldElement;", "getFields", "()Lkotlinx/coroutines/flow/Flow;", "otherFields", "getFormFieldValueFlow", "Lkotlin/Pair;", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "getTextFieldIdentifiers", "sectionFieldErrorController", "Lcom/stripe/android/ui/core/elements/SectionFieldErrorController;", "setRawValue", "", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddressElement.kt */
public class AddressElement extends SectionMultiFieldElement {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    public final AddressFieldElementRepository addressFieldRepository;
    private final AddressController controller;
    private final CountryElement countryElement;
    private final Flow<List<SectionFieldElement>> fields;
    private final Flow<List<SectionFieldElement>> otherFields;
    /* access modifiers changed from: private */
    public Map<IdentifierSpec, String> rawValuesMap;

    public static /* synthetic */ void getCountryElement$annotations() {
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AddressElement(com.stripe.android.ui.core.elements.IdentifierSpec r7, com.stripe.android.ui.core.address.AddressFieldElementRepository r8, java.util.Map r9, java.util.Set r10, com.stripe.android.ui.core.elements.DropdownFieldController r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 4
            if (r13 == 0) goto L_0x0008
            java.util.Map r9 = kotlin.collections.MapsKt.emptyMap()
        L_0x0008:
            r3 = r9
            r9 = r12 & 8
            if (r9 == 0) goto L_0x0011
            java.util.Set r10 = kotlin.collections.SetsKt.emptySet()
        L_0x0011:
            r4 = r10
            r9 = r12 & 16
            if (r9 == 0) goto L_0x002c
            com.stripe.android.ui.core.elements.DropdownFieldController r11 = new com.stripe.android.ui.core.elements.DropdownFieldController
            com.stripe.android.ui.core.elements.CountryConfig r9 = new com.stripe.android.ui.core.elements.CountryConfig
            r10 = 2
            r12 = 0
            r9.<init>(r4, r12, r10, r12)
            com.stripe.android.ui.core.elements.DropdownConfig r9 = (com.stripe.android.ui.core.elements.DropdownConfig) r9
            com.stripe.android.ui.core.elements.IdentifierSpec$Country r10 = com.stripe.android.ui.core.elements.IdentifierSpec.Country.INSTANCE
            java.lang.Object r10 = r3.get(r10)
            java.lang.String r10 = (java.lang.String) r10
            r11.<init>(r9, r10)
        L_0x002c:
            r5 = r11
            r0 = r6
            r1 = r7
            r2 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.elements.AddressElement.<init>(com.stripe.android.ui.core.elements.IdentifierSpec, com.stripe.android.ui.core.address.AddressFieldElementRepository, java.util.Map, java.util.Set, com.stripe.android.ui.core.elements.DropdownFieldController, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AddressElement(IdentifierSpec identifierSpec, AddressFieldElementRepository addressFieldElementRepository, Map<IdentifierSpec, String> map, Set<String> set, DropdownFieldController dropdownFieldController) {
        super(identifierSpec, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(identifierSpec, "_identifier");
        Intrinsics.checkNotNullParameter(addressFieldElementRepository, "addressFieldRepository");
        Intrinsics.checkNotNullParameter(map, "rawValuesMap");
        Intrinsics.checkNotNullParameter(set, "countryCodes");
        Intrinsics.checkNotNullParameter(dropdownFieldController, "countryDropdownFieldController");
        this.addressFieldRepository = addressFieldElementRepository;
        this.rawValuesMap = map;
        CountryElement countryElement2 = new CountryElement(IdentifierSpec.Country.INSTANCE, dropdownFieldController);
        this.countryElement = countryElement2;
        Flow<List<SectionFieldElement>> addressElement$special$$inlined$map$2 = new AddressElement$special$$inlined$map$2(new AddressElement$special$$inlined$map$1(FlowKt.distinctUntilChanged(countryElement2.getController().getRawFieldValue()), this), this);
        this.otherFields = addressElement$special$$inlined$map$2;
        Flow<List<SectionFieldElement>> addressElement$special$$inlined$map$3 = new AddressElement$special$$inlined$map$3(addressElement$special$$inlined$map$2, this);
        this.fields = addressElement$special$$inlined$map$3;
        this.controller = new AddressController(addressElement$special$$inlined$map$3);
    }

    public final CountryElement getCountryElement() {
        return this.countryElement;
    }

    public final Flow<List<SectionFieldElement>> getFields() {
        return this.fields;
    }

    public final AddressController getController() {
        return this.controller;
    }

    public SectionFieldErrorController sectionFieldErrorController() {
        return this.controller;
    }

    public Flow<List<Pair<IdentifierSpec, FormFieldEntry>>> getFormFieldValueFlow() {
        return FlowKt.transformLatest(this.fields, new AddressElement$getFormFieldValueFlow$$inlined$flatMapLatest$1((Continuation) null));
    }

    public Flow<List<IdentifierSpec>> getTextFieldIdentifiers() {
        return FlowKt.transformLatest(this.fields, new AddressElement$getTextFieldIdentifiers$$inlined$flatMapLatest$1((Continuation) null));
    }

    public void setRawValue(Map<IdentifierSpec, String> map) {
        Intrinsics.checkNotNullParameter(map, "rawValuesMap");
        this.rawValuesMap = map;
    }
}
