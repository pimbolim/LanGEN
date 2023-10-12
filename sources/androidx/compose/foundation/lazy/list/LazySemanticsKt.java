package androidx.compose.foundation.lazy.list;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import com.braintreepayments.api.models.PostalAddressParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a:\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0000¨\u0006\f"}, d2 = {"lazyListSemantics", "Landroidx/compose/ui/Modifier;", "stateOfItemsProvider", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/lazy/list/LazyListItemsProvider;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isVertical", "", "reverseScrolling", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazySemantics.kt */
public final class LazySemanticsKt {
    public static final Modifier lazyListSemantics(Modifier modifier, State<? extends LazyListItemsProvider> state, LazyListState lazyListState, CoroutineScope coroutineScope, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "stateOfItemsProvider");
        Intrinsics.checkNotNullParameter(lazyListState, PostalAddressParser.REGION_KEY);
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        return SemanticsModifierKt.semantics$default(modifier, false, new LazySemanticsKt$lazyListSemantics$1(z2, z, state, lazyListState, coroutineScope), 1, (Object) null);
    }
}
