package com.stripe.android.ui.core.elements;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class CardNumberController$special$$inlined$map$3 implements Flow<TextFieldIcon> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ CardNumberController this$0;

    public CardNumberController$special$$inlined$map$3(Flow flow, CardNumberController cardNumberController) {
        this.$this_unsafeTransform$inlined = flow;
        this.this$0 = cardNumberController;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Flow flow = this.$this_unsafeTransform$inlined;
        final CardNumberController cardNumberController = this.this$0;
        Object collect = flow.collect(new Object() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r20, kotlin.coroutines.Continuation r21) {
                /*
                    r19 = this;
                    r0 = r19
                    r1 = r21
                    boolean r2 = r1 instanceof com.stripe.android.ui.core.elements.CardNumberController$special$$inlined$map$3.AnonymousClass2.AnonymousClass1
                    if (r2 == 0) goto L_0x0018
                    r2 = r1
                    com.stripe.android.ui.core.elements.CardNumberController$special$$inlined$map$3$2$1 r2 = (com.stripe.android.ui.core.elements.CardNumberController$special$$inlined$map$3.AnonymousClass2.AnonymousClass1) r2
                    int r3 = r2.label
                    r4 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r3 & r4
                    if (r3 == 0) goto L_0x0018
                    int r1 = r2.label
                    int r1 = r1 - r4
                    r2.label = r1
                    goto L_0x001d
                L_0x0018:
                    com.stripe.android.ui.core.elements.CardNumberController$special$$inlined$map$3$2$1 r2 = new com.stripe.android.ui.core.elements.CardNumberController$special$$inlined$map$3$2$1
                    r2.<init>(r0, r1)
                L_0x001d:
                    java.lang.Object r1 = r2.result
                    java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r4 = r2.label
                    r5 = 1
                    if (r4 == 0) goto L_0x0037
                    if (r4 != r5) goto L_0x002f
                    kotlin.ResultKt.throwOnFailure(r1)
                    goto L_0x00ad
                L_0x002f:
                    java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                    java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                    r1.<init>(r2)
                    throw r1
                L_0x0037:
                    kotlin.ResultKt.throwOnFailure(r1)
                    kotlinx.coroutines.flow.FlowCollector r1 = r4
                    r4 = r2
                    kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                    r4 = r20
                    java.lang.String r4 = (java.lang.String) r4
                    com.stripe.android.model.CardBrand$Companion r6 = com.stripe.android.model.CardBrand.Companion
                    java.util.List r4 = r6.getCardBrands(r4)
                    com.stripe.android.ui.core.elements.CardNumberController r6 = r2
                    com.stripe.android.cards.CardAccountRangeService r6 = r6.getAccountRangeService()
                    com.stripe.android.model.AccountRange r6 = r6.getAccountRange()
                    if (r6 == 0) goto L_0x0075
                    com.stripe.android.ui.core.elements.TextFieldIcon r4 = new com.stripe.android.ui.core.elements.TextFieldIcon
                    com.stripe.android.ui.core.elements.CardNumberController r6 = r2
                    com.stripe.android.cards.CardAccountRangeService r6 = r6.getAccountRangeService()
                    com.stripe.android.model.AccountRange r6 = r6.getAccountRange()
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
                    com.stripe.android.model.CardBrand r6 = r6.getBrand()
                    int r8 = r6.getIcon()
                    r9 = 0
                    r10 = 0
                    r11 = 2
                    r12 = 0
                    r7 = r4
                    r7.<init>(r8, r9, r10, r11, r12)
                    goto L_0x00a4
                L_0x0075:
                    int r6 = r4.size()
                    if (r6 != r5) goto L_0x0091
                    com.stripe.android.ui.core.elements.TextFieldIcon r6 = new com.stripe.android.ui.core.elements.TextFieldIcon
                    java.lang.Object r4 = kotlin.collections.CollectionsKt.first(r4)
                    com.stripe.android.model.CardBrand r4 = (com.stripe.android.model.CardBrand) r4
                    int r8 = r4.getIcon()
                    r9 = 0
                    r10 = 0
                    r11 = 2
                    r12 = 0
                    r7 = r6
                    r7.<init>(r8, r9, r10, r11, r12)
                    r4 = r6
                    goto L_0x00a4
                L_0x0091:
                    com.stripe.android.ui.core.elements.TextFieldIcon r4 = new com.stripe.android.ui.core.elements.TextFieldIcon
                    com.stripe.android.model.CardBrand r6 = com.stripe.android.model.CardBrand.Unknown
                    int r14 = r6.getIcon()
                    r15 = 0
                    r16 = 0
                    r17 = 2
                    r18 = 0
                    r13 = r4
                    r13.<init>(r14, r15, r16, r17, r18)
                L_0x00a4:
                    r2.label = r5
                    java.lang.Object r1 = r1.emit(r4, r2)
                    if (r1 != r3) goto L_0x00ad
                    return r3
                L_0x00ad:
                    kotlin.Unit r1 = kotlin.Unit.INSTANCE
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.stripe.android.ui.core.elements.CardNumberController$special$$inlined$map$3.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
