package androidx.compose.foundation.lazy.list;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazySemantics.kt */
/* synthetic */ class LazySemanticsKt$lazyListSemantics$1$1$key$1 extends FunctionReferenceImpl implements Function1<Integer, Object> {
    LazySemanticsKt$lazyListSemantics$1$1$key$1(Object obj) {
        super(1, obj, LazyListItemsProvider.class, "getKey", "getKey(I)Ljava/lang/Object;", 0);
    }

    public final Object invoke(int i) {
        return ((LazyListItemsProvider) this.receiver).getKey(i);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
