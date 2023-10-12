package com.stripe.android.paymentsheet.forms;

import com.stripe.android.ui.core.elements.SaveForFutureUseElement;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class FormViewModel$special$$inlined$map$1 implements Flow<SaveForFutureUseElement> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;

    public FormViewModel$special$$inlined$map$1(Flow flow) {
        this.$this_unsafeTransform$inlined = flow;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Object collect = this.$this_unsafeTransform$inlined.collect(new Object() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof com.stripe.android.paymentsheet.forms.FormViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0014
                    r0 = r8
                    com.stripe.android.paymentsheet.forms.FormViewModel$special$$inlined$map$1$2$1 r0 = (com.stripe.android.paymentsheet.forms.FormViewModel$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r8 = r0.label
                    int r8 = r8 - r2
                    r0.label = r8
                    goto L_0x0019
                L_0x0014:
                    com.stripe.android.paymentsheet.forms.FormViewModel$special$$inlined$map$1$2$1 r0 = new com.stripe.android.paymentsheet.forms.FormViewModel$special$$inlined$map$1$2$1
                    r0.<init>(r6, r8)
                L_0x0019:
                    java.lang.Object r8 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0032
                    if (r2 != r3) goto L_0x002a
                    kotlin.ResultKt.throwOnFailure(r8)
                    goto L_0x006c
                L_0x002a:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L_0x0032:
                    kotlin.ResultKt.throwOnFailure(r8)
                    kotlinx.coroutines.flow.FlowCollector r8 = r3
                    r2 = r0
                    kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                    java.util.List r7 = (java.util.List) r7
                    r2 = 0
                    if (r7 != 0) goto L_0x0041
                    r4 = r2
                    goto L_0x005c
                L_0x0041:
                    java.lang.Iterable r7 = (java.lang.Iterable) r7
                    java.util.Iterator r7 = r7.iterator()
                L_0x0047:
                    boolean r4 = r7.hasNext()
                    if (r4 == 0) goto L_0x0059
                    java.lang.Object r4 = r7.next()
                    r5 = r4
                    com.stripe.android.ui.core.elements.FormElement r5 = (com.stripe.android.ui.core.elements.FormElement) r5
                    boolean r5 = r5 instanceof com.stripe.android.ui.core.elements.SaveForFutureUseElement
                    if (r5 == 0) goto L_0x0047
                    goto L_0x005a
                L_0x0059:
                    r4 = r2
                L_0x005a:
                    com.stripe.android.ui.core.elements.FormElement r4 = (com.stripe.android.ui.core.elements.FormElement) r4
                L_0x005c:
                    boolean r7 = r4 instanceof com.stripe.android.ui.core.elements.SaveForFutureUseElement
                    if (r7 == 0) goto L_0x0063
                    r2 = r4
                    com.stripe.android.ui.core.elements.SaveForFutureUseElement r2 = (com.stripe.android.ui.core.elements.SaveForFutureUseElement) r2
                L_0x0063:
                    r0.label = r3
                    java.lang.Object r7 = r8.emit(r2, r0)
                    if (r7 != r1) goto L_0x006c
                    return r1
                L_0x006c:
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.paymentsheet.forms.FormViewModel$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
