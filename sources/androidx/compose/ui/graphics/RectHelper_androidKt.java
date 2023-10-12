package androidx.compose.ui.graphics;

import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0006"}, d2 = {"toAndroidRect", "Landroid/graphics/Rect;", "Landroidx/compose/ui/geometry/Rect;", "toAndroidRectF", "Landroid/graphics/RectF;", "toComposeRect", "ui-graphics_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: RectHelper.android.kt */
public final class RectHelper_androidKt {
    public static final Rect toAndroidRect(androidx.compose.ui.geometry.Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<this>");
        return new Rect((int) rect.getLeft(), (int) rect.getTop(), (int) rect.getRight(), (int) rect.getBottom());
    }

    public static final RectF toAndroidRectF(androidx.compose.ui.geometry.Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<this>");
        return new RectF(rect.getLeft(), rect.getTop(), rect.getRight(), rect.getBottom());
    }

    public static final androidx.compose.ui.geometry.Rect toComposeRect(Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "<this>");
        return new androidx.compose.ui.geometry.Rect((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
    }
}
