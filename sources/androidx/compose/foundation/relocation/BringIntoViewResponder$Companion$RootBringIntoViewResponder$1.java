package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"androidx/compose/foundation/relocation/BringIntoViewResponder$Companion$RootBringIntoViewResponder$1", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "bringIntoView", "", "rect", "Landroidx/compose/ui/geometry/Rect;", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toLocalRect", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BringIntoViewResponder.kt */
public final class BringIntoViewResponder$Companion$RootBringIntoViewResponder$1 implements BringIntoViewResponder {
    BringIntoViewResponder$Companion$RootBringIntoViewResponder$1() {
    }

    public Object bringIntoView(Rect rect, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    public Rect toLocalRect(Rect rect, LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        Intrinsics.checkNotNullParameter(layoutCoordinates, "layoutCoordinates");
        return RectKt.m1393Recttz77jQw(layoutCoordinates.m3142localToRootMKHz9U(rect.m1388getTopLeftF1C5BW0()), rect.m1386getSizeNHjbRc());
    }
}
