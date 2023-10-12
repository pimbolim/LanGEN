package com.stripe.android.ui.core.elements;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H@¨\u0006\u0006"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.stripe.android.ui.core.elements.AddressController$special$$inlined$flatMapLatest$1", f = "AddressController.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Merge.kt */
public final class AddressController$special$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super FieldError>, List<? extends SectionFieldElement>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public AddressController$special$$inlined$flatMapLatest$1(Continuation continuation) {
        super(3, continuation);
    }

    public final Object invoke(FlowCollector<? super FieldError> flowCollector, List<? extends SectionFieldElement> list, Continuation<? super Unit> continuation) {
        AddressController$special$$inlined$flatMapLatest$1 addressController$special$$inlined$flatMapLatest$1 = new AddressController$special$$inlined$flatMapLatest$1(continuation);
        addressController$special$$inlined$flatMapLatest$1.L$0 = flowCollector;
        addressController$special$$inlined$flatMapLatest$1.L$1 = list;
        return addressController$special$$inlined$flatMapLatest$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Continuation continuation = this;
            Iterable<SectionFieldElement> iterable = (List) this.L$1;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (SectionFieldElement sectionFieldErrorController : iterable) {
                arrayList.add(sectionFieldErrorController.sectionFieldErrorController().getError());
            }
            Object[] array = CollectionsKt.toList((List) arrayList).toArray(new Flow[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            this.label = 1;
            if (FlowKt.emitAll(flowCollector, new AddressController$error$lambda2$$inlined$combine$1((Flow[]) array), (Continuation<? super Unit>) continuation) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
