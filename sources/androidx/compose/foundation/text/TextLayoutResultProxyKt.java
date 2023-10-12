package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, d2 = {"coerceIn", "Landroidx/compose/ui/geometry/Offset;", "rect", "Landroidx/compose/ui/geometry/Rect;", "coerceIn-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)J", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextLayoutResultProxy.kt */
public final class TextLayoutResultProxyKt {
    /* access modifiers changed from: private */
    /* renamed from: coerceIn-3MmeM6k  reason: not valid java name */
    public static final long m733coerceIn3MmeM6k(long j, Rect rect) {
        float f;
        float f2;
        if (Offset.m1353getXimpl(j) < rect.getLeft()) {
            f = rect.getLeft();
        } else if (Offset.m1353getXimpl(j) > rect.getRight()) {
            f = rect.getRight();
        } else {
            f = Offset.m1353getXimpl(j);
        }
        if (Offset.m1354getYimpl(j) < rect.getTop()) {
            f2 = rect.getTop();
        } else if (Offset.m1354getYimpl(j) > rect.getBottom()) {
            f2 = rect.getBottom();
        } else {
            f2 = Offset.m1354getYimpl(j);
        }
        return OffsetKt.Offset(f, f2);
    }
}
