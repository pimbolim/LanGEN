package com.stripe.android.ui.core.elements;

import com.brentvatne.react.ReactVideoView;
import com.stripe.android.ui.core.forms.FormFieldEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\nHÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J-\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J \u0010\u001a\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001d0\u001c0\n0\u001bH\u0016J\u0014\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\n0\u001bH\u0016J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Lcom/stripe/android/ui/core/elements/SectionElement;", "Lcom/stripe/android/ui/core/elements/FormElement;", "identifier", "Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "field", "Lcom/stripe/android/ui/core/elements/SectionFieldElement;", "controller", "Lcom/stripe/android/ui/core/elements/SectionController;", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;Lcom/stripe/android/ui/core/elements/SectionFieldElement;Lcom/stripe/android/ui/core/elements/SectionController;)V", "fields", "", "(Lcom/stripe/android/ui/core/elements/IdentifierSpec;Ljava/util/List;Lcom/stripe/android/ui/core/elements/SectionController;)V", "getController", "()Lcom/stripe/android/ui/core/elements/SectionController;", "getFields", "()Ljava/util/List;", "getIdentifier", "()Lcom/stripe/android/ui/core/elements/IdentifierSpec;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "getFormFieldValueFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Pair;", "Lcom/stripe/android/ui/core/forms/FormFieldEntry;", "getTextFieldIdentifiers", "hashCode", "", "toString", "", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SectionElement.kt */
public final class SectionElement extends FormElement {
    public static final int $stable = 8;
    private final SectionController controller;
    private final List<SectionFieldElement> fields;
    private final IdentifierSpec identifier;

    public static /* synthetic */ SectionElement copy$default(SectionElement sectionElement, IdentifierSpec identifierSpec, List<SectionFieldElement> list, SectionController sectionController, int i, Object obj) {
        if ((i & 1) != 0) {
            identifierSpec = sectionElement.getIdentifier();
        }
        if ((i & 2) != 0) {
            list = sectionElement.fields;
        }
        if ((i & 4) != 0) {
            sectionController = sectionElement.getController();
        }
        return sectionElement.copy(identifierSpec, list, sectionController);
    }

    public final IdentifierSpec component1() {
        return getIdentifier();
    }

    public final List<SectionFieldElement> component2() {
        return this.fields;
    }

    public final SectionController component3() {
        return getController();
    }

    public final SectionElement copy(IdentifierSpec identifierSpec, List<? extends SectionFieldElement> list, SectionController sectionController) {
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        Intrinsics.checkNotNullParameter(list, "fields");
        Intrinsics.checkNotNullParameter(sectionController, "controller");
        return new SectionElement(identifierSpec, list, sectionController);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SectionElement)) {
            return false;
        }
        SectionElement sectionElement = (SectionElement) obj;
        return Intrinsics.areEqual((Object) getIdentifier(), (Object) sectionElement.getIdentifier()) && Intrinsics.areEqual((Object) this.fields, (Object) sectionElement.fields) && Intrinsics.areEqual((Object) getController(), (Object) sectionElement.getController());
    }

    public int hashCode() {
        return (((getIdentifier().hashCode() * 31) + this.fields.hashCode()) * 31) + getController().hashCode();
    }

    public String toString() {
        return "SectionElement(identifier=" + getIdentifier() + ", fields=" + this.fields + ", controller=" + getController() + ')';
    }

    public IdentifierSpec getIdentifier() {
        return this.identifier;
    }

    public final List<SectionFieldElement> getFields() {
        return this.fields;
    }

    public SectionController getController() {
        return this.controller;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SectionElement(IdentifierSpec identifierSpec, List<? extends SectionFieldElement> list, SectionController sectionController) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        Intrinsics.checkNotNullParameter(list, "fields");
        Intrinsics.checkNotNullParameter(sectionController, "controller");
        this.identifier = identifierSpec;
        this.fields = list;
        this.controller = sectionController;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SectionElement(IdentifierSpec identifierSpec, SectionFieldElement sectionFieldElement, SectionController sectionController) {
        this(identifierSpec, (List<? extends SectionFieldElement>) CollectionsKt.listOf(sectionFieldElement), sectionController);
        Intrinsics.checkNotNullParameter(identifierSpec, ReactVideoView.EVENT_PROP_METADATA_IDENTIFIER);
        Intrinsics.checkNotNullParameter(sectionFieldElement, "field");
        Intrinsics.checkNotNullParameter(sectionController, "controller");
    }

    public Flow<List<Pair<IdentifierSpec, FormFieldEntry>>> getFormFieldValueFlow() {
        Iterable<SectionFieldElement> iterable = this.fields;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (SectionFieldElement formFieldValueFlow : iterable) {
            arrayList.add(formFieldValueFlow.getFormFieldValueFlow());
        }
        Object[] array = CollectionsKt.toList((List) arrayList).toArray(new Flow[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return new SectionElement$getFormFieldValueFlow$$inlined$combine$1((Flow[]) array);
    }

    public Flow<List<IdentifierSpec>> getTextFieldIdentifiers() {
        Iterable<SectionFieldElement> iterable = this.fields;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (SectionFieldElement textFieldIdentifiers : iterable) {
            arrayList.add(textFieldIdentifiers.getTextFieldIdentifiers());
        }
        Object[] array = CollectionsKt.toList((List) arrayList).toArray(new Flow[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return new SectionElement$getTextFieldIdentifiers$$inlined$combine$1((Flow[]) array);
    }
}
