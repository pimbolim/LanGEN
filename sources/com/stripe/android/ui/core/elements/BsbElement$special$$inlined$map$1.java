package com.stripe.android.ui.core.elements;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class BsbElement$special$$inlined$map$1 implements Flow<String> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ BsbElement this$0;

    public BsbElement$special$$inlined$map$1(Flow flow, BsbElement bsbElement) {
        this.$this_unsafeTransform$inlined = flow;
        this.this$0 = bsbElement;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Flow flow = this.$this_unsafeTransform$inlined;
        final BsbElement bsbElement = this.this$0;
        Object collect = flow.collect(new Object() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r11, kotlin.coroutines.Continuation r12) {
                /*
                    r10 = this;
                    boolean r0 = r12 instanceof com.stripe.android.ui.core.elements.BsbElement$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0014
                    r0 = r12
                    com.stripe.android.ui.core.elements.BsbElement$special$$inlined$map$1$2$1 r0 = (com.stripe.android.ui.core.elements.BsbElement$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r12 = r0.label
                    int r12 = r12 - r2
                    r0.label = r12
                    goto L_0x0019
                L_0x0014:
                    com.stripe.android.ui.core.elements.BsbElement$special$$inlined$map$1$2$1 r0 = new com.stripe.android.ui.core.elements.BsbElement$special$$inlined$map$1$2$1
                    r0.<init>(r10, r12)
                L_0x0019:
                    java.lang.Object r12 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0033
                    if (r2 != r3) goto L_0x002b
                    kotlin.ResultKt.throwOnFailure(r12)
                    goto L_0x00a6
                L_0x002b:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r12)
                    throw r11
                L_0x0033:
                    kotlin.ResultKt.throwOnFailure(r12)
                    kotlinx.coroutines.flow.FlowCollector r12 = r4
                    r2 = r0
                    kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                    java.lang.String r11 = (java.lang.String) r11
                    com.stripe.android.ui.core.elements.BsbElement r2 = r2
                    java.util.List r2 = r2.banks
                    java.lang.Iterable r2 = (java.lang.Iterable) r2
                    java.util.ArrayList r4 = new java.util.ArrayList
                    r4.<init>()
                    java.util.Collection r4 = (java.util.Collection) r4
                    java.util.Iterator r2 = r2.iterator()
                L_0x0050:
                    boolean r5 = r2.hasNext()
                    if (r5 == 0) goto L_0x006e
                    java.lang.Object r5 = r2.next()
                    r6 = r5
                    com.stripe.android.view.BecsDebitBanks$Bank r6 = (com.stripe.android.view.BecsDebitBanks.Bank) r6
                    java.lang.String r6 = r6.getPrefix()
                    r7 = 0
                    r8 = 2
                    r9 = 0
                    boolean r6 = kotlin.text.StringsKt.startsWith$default(r11, r6, r7, r8, r9)
                    if (r6 == 0) goto L_0x0050
                    r4.add(r5)
                    goto L_0x0050
                L_0x006e:
                    java.util.List r4 = (java.util.List) r4
                    java.lang.Iterable r4 = (java.lang.Iterable) r4
                    java.util.ArrayList r11 = new java.util.ArrayList
                    r2 = 10
                    int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r2)
                    r11.<init>(r2)
                    java.util.Collection r11 = (java.util.Collection) r11
                    java.util.Iterator r2 = r4.iterator()
                L_0x0083:
                    boolean r4 = r2.hasNext()
                    if (r4 == 0) goto L_0x0097
                    java.lang.Object r4 = r2.next()
                    com.stripe.android.view.BecsDebitBanks$Bank r4 = (com.stripe.android.view.BecsDebitBanks.Bank) r4
                    java.lang.String r4 = r4.getName()
                    r11.add(r4)
                    goto L_0x0083
                L_0x0097:
                    java.util.List r11 = (java.util.List) r11
                    java.lang.Object r11 = kotlin.collections.CollectionsKt.firstOrNull(r11)
                    r0.label = r3
                    java.lang.Object r11 = r12.emit(r11, r0)
                    if (r11 != r1) goto L_0x00a6
                    return r1
                L_0x00a6:
                    kotlin.Unit r11 = kotlin.Unit.INSTANCE
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.elements.BsbElement$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
