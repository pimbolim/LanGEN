package com.stripe.android.ui.core.elements;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\u0002\u0010\u0006R\u001c\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/stripe/android/ui/core/elements/AddressController;", "Lcom/stripe/android/ui/core/elements/SectionFieldErrorController;", "fieldsFlowable", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/stripe/android/ui/core/elements/SectionFieldElement;", "(Lkotlinx/coroutines/flow/Flow;)V", "error", "Lcom/stripe/android/ui/core/elements/FieldError;", "getError", "()Lkotlinx/coroutines/flow/Flow;", "getFieldsFlowable", "label", "", "getLabel", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "payments-ui-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AddressController.kt */
public final class AddressController implements SectionFieldErrorController {
    public static final int $stable = 8;
    private final Flow<FieldError> error;
    private final Flow<List<SectionFieldElement>> fieldsFlowable;
    private final Integer label;

    public AddressController(Flow<? extends List<? extends SectionFieldElement>> flow) {
        Intrinsics.checkNotNullParameter(flow, "fieldsFlowable");
        this.fieldsFlowable = flow;
        this.error = FlowKt.transformLatest(flow, new AddressController$special$$inlined$flatMapLatest$1((Continuation) null));
    }

    public final Flow<List<SectionFieldElement>> getFieldsFlowable() {
        return this.fieldsFlowable;
    }

    public final Integer getLabel() {
        return this.label;
    }

    public Flow<FieldError> getError() {
        return this.error;
    }
}
