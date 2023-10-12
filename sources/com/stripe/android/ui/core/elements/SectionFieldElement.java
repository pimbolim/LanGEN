package com.stripe.android.ui.core.elements;

import com.stripe.android.ui.core.forms.FormFieldEntry;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t0\b0\u0007H&J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u0007H&J\b\u0010\f\u001a\u00020\rH&J\u001e\u0010\u000e\u001a\u00020\u000f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0011H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0001\u0002\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/stripe/android/ui/core/elements/SectionFieldElement;", "", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "getFormFieldValueFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lkotlin/Pair;", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "getTextFieldIdentifiers", "sectionFieldErrorController", "Lcom/stripe/android/ui/core/elements/SectionFieldErrorController;", "setRawValue", "", "rawValuesMap", "", "", "Lcom/stripe/android/ui/core/elements/SectionMultiFieldElement;", "Lcom/stripe/android/ui/core/elements/SectionSingleFieldElement;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SectionFieldElement.kt */
public interface SectionFieldElement {
    Flow<List<Pair<IdentifierSpec, FormFieldEntry>>> getFormFieldValueFlow();

    IdentifierSpec getIdentifier();

    Flow<List<IdentifierSpec>> getTextFieldIdentifiers();

    SectionFieldErrorController sectionFieldErrorController();

    void setRawValue(Map<IdentifierSpec, String> map);
}
