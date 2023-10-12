package com.stripe.android.ui.core.elements;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class CardBillingAddressElement$special$$inlined$map$1 implements Flow<List<? extends IdentifierSpec>> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;

    public CardBillingAddressElement$special$$inlined$map$1(Flow flow) {
        this.$this_unsafeTransform$inlined = flow;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Object collect = this.$this_unsafeTransform$inlined.collect(new Object() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r10, kotlin.coroutines.Continuation r11) {
                /*
                    r9 = this;
                    boolean r0 = r11 instanceof com.stripe.android.ui.core.elements.CardBillingAddressElement$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0014
                    r0 = r11
                    com.stripe.android.ui.core.elements.CardBillingAddressElement$special$$inlined$map$1$2$1 r0 = (com.stripe.android.ui.core.elements.CardBillingAddressElement$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r11 = r0.label
                    int r11 = r11 - r2
                    r0.label = r11
                    goto L_0x0019
                L_0x0014:
                    com.stripe.android.ui.core.elements.CardBillingAddressElement$special$$inlined$map$1$2$1 r0 = new com.stripe.android.ui.core.elements.CardBillingAddressElement$special$$inlined$map$1$2$1
                    r0.<init>(r9, r11)
                L_0x0019:
                    java.lang.Object r11 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0033
                    if (r2 != r3) goto L_0x002b
                    kotlin.ResultKt.throwOnFailure(r11)
                    goto L_0x00df
                L_0x002b:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r11)
                    throw r10
                L_0x0033:
                    kotlin.ResultKt.throwOnFailure(r11)
                    kotlinx.coroutines.flow.FlowCollector r11 = r3
                    r2 = r0
                    kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                    java.lang.String r10 = (java.lang.String) r10
                    r2 = 0
                    if (r10 == 0) goto L_0x00b8
                    int r4 = r10.hashCode()
                    r5 = 2142(0x85e, float:3.002E-42)
                    if (r4 == r5) goto L_0x0063
                    r5 = 2267(0x8db, float:3.177E-42)
                    if (r4 == r5) goto L_0x005a
                    r5 = 2718(0xa9e, float:3.809E-42)
                    if (r4 == r5) goto L_0x0051
                    goto L_0x00b8
                L_0x0051:
                    java.lang.String r4 = "US"
                    boolean r10 = r10.equals(r4)
                    if (r10 != 0) goto L_0x006c
                    goto L_0x00b8
                L_0x005a:
                    java.lang.String r4 = "GB"
                    boolean r10 = r10.equals(r4)
                    if (r10 != 0) goto L_0x006c
                    goto L_0x00b8
                L_0x0063:
                    java.lang.String r4 = "CA"
                    boolean r10 = r10.equals(r4)
                    if (r10 != 0) goto L_0x006c
                    goto L_0x00b8
                L_0x006c:
                    com.stripe.android.ui.core.address.FieldType[] r10 = com.stripe.android.ui.core.address.FieldType.values()
                    java.util.ArrayList r4 = new java.util.ArrayList
                    r4.<init>()
                    java.util.Collection r4 = (java.util.Collection) r4
                    int r5 = r10.length
                    r6 = 0
                L_0x0079:
                    if (r6 >= r5) goto L_0x008c
                    r7 = r10[r6]
                    int r6 = r6 + 1
                    com.stripe.android.ui.core.address.FieldType r8 = com.stripe.android.ui.core.address.FieldType.PostalCode
                    if (r7 != r8) goto L_0x0085
                    r8 = 1
                    goto L_0x0086
                L_0x0085:
                    r8 = 0
                L_0x0086:
                    if (r8 != 0) goto L_0x0079
                    r4.add(r7)
                    goto L_0x0079
                L_0x008c:
                    java.util.List r4 = (java.util.List) r4
                    java.lang.Iterable r4 = (java.lang.Iterable) r4
                    java.util.ArrayList r10 = new java.util.ArrayList
                    r2 = 10
                    int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r2)
                    r10.<init>(r2)
                    java.util.Collection r10 = (java.util.Collection) r10
                    java.util.Iterator r2 = r4.iterator()
                L_0x00a1:
                    boolean r4 = r2.hasNext()
                    if (r4 == 0) goto L_0x00b5
                    java.lang.Object r4 = r2.next()
                    com.stripe.android.ui.core.address.FieldType r4 = (com.stripe.android.ui.core.address.FieldType) r4
                    com.stripe.android.ui.core.elements.IdentifierSpec r4 = r4.getIdentifierSpec()
                    r10.add(r4)
                    goto L_0x00a1
                L_0x00b5:
                    java.util.List r10 = (java.util.List) r10
                    goto L_0x00d6
                L_0x00b8:
                    com.stripe.android.ui.core.address.FieldType[] r10 = com.stripe.android.ui.core.address.FieldType.values()
                    java.util.ArrayList r4 = new java.util.ArrayList
                    int r5 = r10.length
                    r4.<init>(r5)
                    java.util.Collection r4 = (java.util.Collection) r4
                    int r5 = r10.length
                L_0x00c5:
                    if (r2 >= r5) goto L_0x00d3
                    r6 = r10[r2]
                    int r2 = r2 + 1
                    com.stripe.android.ui.core.elements.IdentifierSpec r6 = r6.getIdentifierSpec()
                    r4.add(r6)
                    goto L_0x00c5
                L_0x00d3:
                    r10 = r4
                    java.util.List r10 = (java.util.List) r10
                L_0x00d6:
                    r0.label = r3
                    java.lang.Object r10 = r11.emit(r10, r0)
                    if (r10 != r1) goto L_0x00df
                    return r1
                L_0x00df:
                    kotlin.Unit r10 = kotlin.Unit.INSTANCE
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.elements.CardBillingAddressElement$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
