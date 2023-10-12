package com.stripe.android.ui.core.elements;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stripe/android/ui/core/elements/SectionController;", "Lcom/stripe/android/ui/core/elements/Controller;", "label", "", "sectionFieldErrorControllers", "", "Lcom/stripe/android/ui/core/elements/SectionFieldErrorController;", "(Ljava/lang/Integer;Ljava/util/List;)V", "error", "Lkotlinx/coroutines/flow/Flow;", "Lcom/stripe/android/ui/core/elements/FieldError;", "getError", "()Lkotlinx/coroutines/flow/Flow;", "getLabel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSectionFieldErrorControllers", "()Ljava/util/List;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SectionController.kt */
public final class SectionController implements Controller {
    public static final int $stable = 8;
    private final Flow<FieldError> error;
    private final Integer label;
    private final List<SectionFieldErrorController> sectionFieldErrorControllers;

    public SectionController(Integer num, List<? extends SectionFieldErrorController> list) {
        Intrinsics.checkNotNullParameter(list, "sectionFieldErrorControllers");
        this.label = num;
        this.sectionFieldErrorControllers = list;
        Iterable<SectionFieldErrorController> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (SectionFieldErrorController error2 : iterable) {
            arrayList.add(error2.getError());
        }
        Object[] array = CollectionsKt.toList((List) arrayList).toArray(new Flow[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        this.error = new SectionController$special$$inlined$combine$1((Flow[]) array);
    }

    public final Integer getLabel() {
        return this.label;
    }

    public final List<SectionFieldErrorController> getSectionFieldErrorControllers() {
        return this.sectionFieldErrorControllers;
    }

    public final Flow<FieldError> getError() {
        return this.error;
    }
}
