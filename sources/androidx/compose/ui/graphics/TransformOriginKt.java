package androidx.compose.ui.graphics;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"TransformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "pivotFractionX", "", "pivotFractionY", "(FF)J", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TransformOrigin.kt */
public final class TransformOriginKt {
    public static final long TransformOrigin(float f, float f2) {
        long floatToIntBits = (long) Float.floatToIntBits(f);
        return TransformOrigin.m1945constructorimpl((((long) Float.floatToIntBits(f2)) & 4294967295L) | (floatToIntBits << 32));
    }
}
