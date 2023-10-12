package com.stripe.android.ui.core.elements;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stripe/android/ui/core/elements/RowController;", "Lcom/stripe/android/ui/core/elements/SectionFieldErrorController;", "fields", "", "Lcom/stripe/android/ui/core/elements/SectionSingleFieldElement;", "(Ljava/util/List;)V", "error", "Lkotlinx/coroutines/flow/Flow;", "Lcom/stripe/android/ui/core/elements/FieldError;", "getError", "()Lkotlinx/coroutines/flow/Flow;", "getFields", "()Ljava/util/List;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RowController.kt */
public final class RowController implements SectionFieldErrorController {
    public static final int $stable = 8;
    private final Flow<FieldError> error;
    private final List<SectionSingleFieldElement> fields;

    public RowController(List<? extends SectionSingleFieldElement> list) {
        Intrinsics.checkNotNullParameter(list, "fields");
        this.fields = list;
        Iterable<SectionSingleFieldElement> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (SectionSingleFieldElement sectionFieldErrorController : iterable) {
            arrayList.add(sectionFieldErrorController.sectionFieldErrorController().getError());
        }
        Object[] array = CollectionsKt.toList((List) arrayList).toArray(new Flow[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.error = new RowController$special$$inlined$combine$1((Flow[]) array);
    }

    public final List<SectionSingleFieldElement> getFields() {
        return this.fields;
    }

    public Flow<FieldError> getError() {
        return this.error;
    }
}
