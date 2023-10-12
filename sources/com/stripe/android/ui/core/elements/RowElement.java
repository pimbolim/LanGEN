package com.stripe.android.ui.core.elements;

import com.stripe.android.ui.core.forms.FormFieldEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ \u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\u00100\u00050\u000fH\u0016J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00050\u000fH\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\u001e\u0010\u0014\u001a\u00020\u00152\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/stripe/android/ui/core/elements/RowElement;", "Lcom/stripe/android/ui/core/elements/SectionMultiFieldElement;", "_identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "fields", "", "Lcom/stripe/android/ui/core/elements/SectionSingleFieldElement;", "controller", "Lcom/stripe/android/ui/core/elements/RowController;", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;Ljava/util/List;Lcom/stripe/android/ui/core/elements/RowController;)V", "getController", "()Lcom/stripe/android/ui/core/elements/RowController;", "getFields", "()Ljava/util/List;", "getFormFieldValueFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Pair;", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "getTextFieldIdentifiers", "sectionFieldErrorController", "setRawValue", "", "rawValuesMap", "", "", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RowElement.kt */
public final class RowElement extends SectionMultiFieldElement {
    public static final int $stable = 8;
    private final RowController controller;
    private final List<SectionSingleFieldElement> fields;

    public final List<SectionSingleFieldElement> getFields() {
        return this.fields;
    }

    public final RowController getController() {
        return this.controller;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RowElement(IdentifierSpec identifierSpec, List<? extends SectionSingleFieldElement> list, RowController rowController) {
        super(identifierSpec, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(identifierSpec, "_identifier");
        Intrinsics.checkNotNullParameter(list, "fields");
        Intrinsics.checkNotNullParameter(rowController, "controller");
        this.fields = list;
        this.controller = rowController;
    }

    public Flow<List<Pair<IdentifierSpec, FormFieldEntry>>> getFormFieldValueFlow() {
        Iterable<SectionSingleFieldElement> iterable = this.fields;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (SectionSingleFieldElement formFieldValueFlow : iterable) {
            arrayList.add(formFieldValueFlow.getFormFieldValueFlow());
        }
        Object[] array = CollectionsKt.toList((List) arrayList).toArray(new Flow[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return new RowElement$getFormFieldValueFlow$$inlined$combine$1((Flow[]) array);
    }

    public RowController sectionFieldErrorController() {
        return this.controller;
    }

    public void setRawValue(Map<IdentifierSpec, String> map) {
        Intrinsics.checkNotNullParameter(map, "rawValuesMap");
        for (SectionSingleFieldElement rawValue : this.fields) {
            rawValue.setRawValue(map);
        }
    }

    public Flow<List<IdentifierSpec>> getTextFieldIdentifiers() {
        Iterable<SectionSingleFieldElement> iterable = this.fields;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (SectionSingleFieldElement textFieldIdentifiers : iterable) {
            arrayList.add(textFieldIdentifiers.getTextFieldIdentifiers());
        }
        return (Flow) CollectionsKt.last((List) arrayList);
    }
}
