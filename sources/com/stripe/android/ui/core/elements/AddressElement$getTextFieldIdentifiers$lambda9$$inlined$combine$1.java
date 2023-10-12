package com.stripe.android.ui.core.elements;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.CombineKt;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$$inlined$unsafeFlow$3"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: com.stripe.android.ui.core.elements.AddressElement$getTextFieldIdentifiers$lambda-9$$inlined$combine$1  reason: invalid class name */
/* compiled from: SafeCollector.common.kt */
public final class AddressElement$getTextFieldIdentifiers$lambda9$$inlined$combine$1 implements Flow<List<? extends IdentifierSpec>> {
    final /* synthetic */ Flow[] $flowArray$inlined;

    public AddressElement$getTextFieldIdentifiers$lambda9$$inlined$combine$1(Flow[] flowArr) {
        this.$flowArray$inlined = flowArr;
    }

    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        final Flow[] flowArr = this.$flowArray$inlined;
        Object combineInternal = CombineKt.combineInternal(flowCollector, flowArr, new Function0<List<? extends IdentifierSpec>[]>() {
            public final List<? extends IdentifierSpec>[] invoke() {
                return new List[flowArr.length];
            }
        }, new AnonymousClass3((Continuation) null), continuation);
        if (combineInternal == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return combineInternal;
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H@¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$2"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.stripe.android.ui.core.elements.AddressElement$getTextFieldIdentifiers$lambda-9$$inlined$combine$1$3", f = "AddressElement.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.stripe.android.ui.core.elements.AddressElement$getTextFieldIdentifiers$lambda-9$$inlined$combine$1$3  reason: invalid class name */
    /* compiled from: Zip.kt */
    public static final class AnonymousClass3 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends IdentifierSpec>>, List<? extends IdentifierSpec>[], Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        public final Object invoke(FlowCollector<? super List<? extends IdentifierSpec>> flowCollector, List<? extends IdentifierSpec>[] listArr, Continuation<? super Unit> continuation) {
            AnonymousClass3 r0 = new AnonymousClass3(continuation);
            r0.L$0 = flowCollector;
            r0.L$1 = listArr;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                List flatten = CollectionsKt.flatten(ArraysKt.toList((T[]) (List[]) ((Object[]) this.L$1)));
                this.label = 1;
                if (((FlowCollector) this.L$0).emit(flatten, this) == coroutine_suspended) {
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
}