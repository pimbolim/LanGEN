package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/foundation/lazy/layout/NoItemsProvider;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyLayoutState.kt */
final class LazyLayoutState$itemsProvider$1 extends Lambda implements Function0<NoItemsProvider> {
    public static final LazyLayoutState$itemsProvider$1 INSTANCE = new LazyLayoutState$itemsProvider$1();

    LazyLayoutState$itemsProvider$1() {
        super(0);
    }

    public final NoItemsProvider invoke() {
        return NoItemsProvider.INSTANCE;
    }
}
