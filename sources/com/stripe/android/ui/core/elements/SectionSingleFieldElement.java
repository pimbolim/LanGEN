package com.stripe.android.ui.core.elements;

import com.stripe.android.ui.core.forms.FormFieldEntry;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000f0\u000e0\r0\fH\u0016J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\r0\fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001e\u0010\u0013\u001a\u00020\u00142\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0016R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0001\u0007\u0018\u0019\u001a\u001b\u001c\u001d\u001e¨\u0006\u001f"}, d2 = {"Lcom/stripe/android/ui/core/elements/SectionSingleFieldElement;", "Lcom/stripe/android/ui/core/elements/SectionFieldElement;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;)V", "controller", "Lcom/stripe/android/ui/core/elements/InputController;", "getController", "()Lcom/stripe/android/ui/core/elements/InputController;", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "getFormFieldValueFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lkotlin/Pair;", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "getTextFieldIdentifiers", "sectionFieldErrorController", "Lcom/stripe/android/ui/core/elements/SectionFieldErrorController;", "setRawValue", "", "rawValuesMap", "", "", "Lcom/stripe/android/ui/core/elements/CardNumberElement;", "Lcom/stripe/android/ui/core/elements/CountryElement;", "Lcom/stripe/android/ui/core/elements/CvcElement;", "Lcom/stripe/android/ui/core/elements/EmailElement;", "Lcom/stripe/android/ui/core/elements/IbanElement;", "Lcom/stripe/android/ui/core/elements/SimpleDropdownElement;", "Lcom/stripe/android/ui/core/elements/SimpleTextElement;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SectionSingleFieldElement.kt */
public abstract class SectionSingleFieldElement implements SectionFieldElement {
    public static final int $stable = 0;
    private final IdentifierSpec identifier;

    public /* synthetic */ SectionSingleFieldElement(IdentifierSpec identifierSpec, DefaultConstructorMarker defaultConstructorMarker) {
        this(identifierSpec);
    }

    public abstract InputController getController();

    private SectionSingleFieldElement(IdentifierSpec identifierSpec) {
        this.identifier = identifierSpec;
    }

    public IdentifierSpec getIdentifier() {
        return this.identifier;
    }

    public SectionFieldErrorController sectionFieldErrorController() {
        return getController();
    }

    public Flow<List<Pair<IdentifierSpec, FormFieldEntry>>> getFormFieldValueFlow() {
        return new SectionSingleFieldElement$getFormFieldValueFlow$$inlined$map$1(getController().getFormFieldValue(), this);
    }

    public void setRawValue(Map<IdentifierSpec, String> map) {
        Intrinsics.checkNotNullParameter(map, "rawValuesMap");
        String str = map.get(getIdentifier());
        if (str != null) {
            getController().onRawValueChange(str);
        }
    }

    public Flow<List<IdentifierSpec>> getTextFieldIdentifiers() {
        List listOf = CollectionsKt.listOf(getIdentifier());
        if (!(getController() instanceof TextFieldController)) {
            listOf = null;
        }
        if (listOf == null) {
            listOf = CollectionsKt.emptyList();
        }
        return StateFlowKt.MutableStateFlow(listOf);
    }
}
