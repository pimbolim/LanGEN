package com.stripe.android.ui.core.elements;

import com.stripe.android.ui.core.forms.FormFieldEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J \u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r0\fH&J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\r0\fH\u0016R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0001\t\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/stripe/android/ui/core/elements/FormElement;", "", "()V", "controller", "Lcom/stripe/android/ui/core/elements/Controller;", "getController", "()Lcom/stripe/android/ui/core/elements/Controller;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "getFormFieldValueFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lkotlin/Pair;", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "getTextFieldIdentifiers", "Lcom/stripe/android/ui/core/elements/AffirmHeaderElement;", "Lcom/stripe/android/ui/core/elements/AfterpayClearpayHeaderElement;", "Lcom/stripe/android/ui/core/elements/AuBecsDebitMandateTextElement;", "Lcom/stripe/android/ui/core/elements/BsbElement;", "Lcom/stripe/android/ui/core/elements/EmptyFormElement;", "Lcom/stripe/android/ui/core/elements/MandateTextElement;", "Lcom/stripe/android/ui/core/elements/SaveForFutureUseElement;", "Lcom/stripe/android/ui/core/elements/SectionElement;", "Lcom/stripe/android/ui/core/elements/StaticTextElement;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FormElement.kt */
public abstract class FormElement {
    public static final int $stable = 0;

    public /* synthetic */ FormElement(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Controller getController();

    public abstract Flow<List<Pair<IdentifierSpec, FormFieldEntry>>> getFormFieldValueFlow();

    public abstract IdentifierSpec getIdentifier();

    private FormElement() {
    }

    public Flow<List<IdentifierSpec>> getTextFieldIdentifiers() {
        return StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    }
}
