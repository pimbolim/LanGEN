package androidx.compose.foundation.gestures;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Scrollable.kt */
final class ScrollableKt$touchScrollable$1 extends Lambda implements Function2<Composer, Integer, PointerAwareDraggableState> {
    final /* synthetic */ ScrollDraggableState $draggableState;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScrollableKt$touchScrollable$1(ScrollDraggableState scrollDraggableState) {
        super(2);
        this.$draggableState = scrollDraggableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((Composer) obj, ((Number) obj2).intValue());
    }

    public final PointerAwareDraggableState invoke(Composer composer, int i) {
        composer.startReplaceableGroup(-971263152);
        ScrollDraggableState scrollDraggableState = this.$draggableState;
        composer.endReplaceableGroup();
        return scrollDraggableState;
    }
}
