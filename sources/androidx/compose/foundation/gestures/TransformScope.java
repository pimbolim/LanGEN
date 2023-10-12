package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J3\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"Landroidx/compose/foundation/gestures/TransformScope;", "", "transformBy", "", "zoomChange", "", "panChange", "Landroidx/compose/ui/geometry/Offset;", "rotationChange", "transformBy-d-4ec7I", "(FJF)V", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TransformableState.kt */
public interface TransformScope {
    /* renamed from: transformBy-d-4ec7I  reason: not valid java name */
    void m323transformByd4ec7I(float f, long j, float f2);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TransformableState.kt */
    public static final class DefaultImpls {
        /* renamed from: transformBy-d-4ec7I$default  reason: not valid java name */
        public static /* synthetic */ void m324transformByd4ec7I$default(TransformScope transformScope, float f, long j, float f2, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    f = 1.0f;
                }
                if ((i & 2) != 0) {
                    j = Offset.Companion.m1369getZeroF1C5BW0();
                }
                if ((i & 4) != 0) {
                    f2 = 0.0f;
                }
                transformScope.m323transformByd4ec7I(f, j, f2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transformBy-d-4ec7I");
        }
    }
}