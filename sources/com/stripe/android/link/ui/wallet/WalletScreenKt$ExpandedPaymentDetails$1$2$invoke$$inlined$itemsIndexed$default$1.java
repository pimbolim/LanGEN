package com.stripe.android.link.ui.wallet;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "T", "index", "", "invoke", "androidx/compose/foundation/lazy/LazyDslKt$itemsIndexed$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyDsl.kt */
public final class WalletScreenKt$ExpandedPaymentDetails$1$2$invoke$$inlined$itemsIndexed$default$1 extends Lambda implements Function1<Integer, Object> {
    final /* synthetic */ List $items;
    final /* synthetic */ Function2 $key;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletScreenKt$ExpandedPaymentDetails$1$2$invoke$$inlined$itemsIndexed$default$1(Function2 function2, List list) {
        super(1);
        this.$key = function2;
        this.$items = list;
    }

    public final Object invoke(int i) {
        return this.$key.invoke(Integer.valueOf(i), this.$items.get(i));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
