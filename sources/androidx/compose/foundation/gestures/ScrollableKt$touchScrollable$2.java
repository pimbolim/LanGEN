package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: Scrollable.kt */
final class ScrollableKt$touchScrollable$2 extends Lambda implements Function1<PointerInputChange, Boolean> {
    public static final ScrollableKt$touchScrollable$2 INSTANCE = new ScrollableKt$touchScrollable$2();

    ScrollableKt$touchScrollable$2() {
        super(1);
    }

    public final Boolean invoke(PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "down");
        return Boolean.valueOf(!PointerType.m3037equalsimpl0(pointerInputChange.m2981getTypeT8wyACA(), PointerType.Companion.m3042getMouseT8wyACA()));
    }
}
