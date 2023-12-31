package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001JK\u0010\u0002\u001a\u00020\u00032\u001b\b\u0002\u0010\u0004\u001a\u0015\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b\b2\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\b\u000b¢\u0006\u0002\b\bH&ø\u0001\u0000¢\u0006\u0002\u0010\fJ}\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f20\b\u0002\u0010\u0004\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0010¢\u0006\u0002\b\b21\u0010\u0014\u001a-\u0012\u0004\u0012\u00020\n\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\u0002\b\u000b¢\u0006\u0002\b\bH&ø\u0001\u0000¢\u0006\u0002\u0010\u0015\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/lazy/LazyGridScope;", "", "item", "", "span", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyGridItemSpanScope;", "Landroidx/compose/foundation/lazy/GridItemSpan;", "Lkotlin/ExtensionFunctionType;", "content", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "items", "count", "", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "itemContent", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function4;)V", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ExperimentalFoundationApi
/* compiled from: LazyGrid.kt */
public interface LazyGridScope {
    void item(Function1<? super LazyGridItemSpanScope, GridItemSpan> function1, Function3<? super LazyItemScope, ? super Composer, ? super Integer, Unit> function3);

    void items(int i, Function2<? super LazyGridItemSpanScope, ? super Integer, GridItemSpan> function2, Function4<? super LazyItemScope, ? super Integer, ? super Composer, ? super Integer, Unit> function4);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LazyGrid.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void item$default(LazyGridScope lazyGridScope, Function1 function1, Function3 function3, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    function1 = null;
                }
                lazyGridScope.item(function1, function3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: item");
        }

        public static /* synthetic */ void items$default(LazyGridScope lazyGridScope, int i, Function2 function2, Function4 function4, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    function2 = null;
                }
                lazyGridScope.items(i, function2, function4);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: items");
        }
    }
}
