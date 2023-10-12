package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a0\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"getSelectionHandleCoordinates", "Landroidx/compose/ui/geometry/Offset;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "offset", "", "isStart", "", "areHandlesCrossed", "(Landroidx/compose/ui/text/TextLayoutResult;IZZ)J", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextSelectionDelegate.kt */
public final class TextSelectionDelegateKt {
    public static final long getSelectionHandleCoordinates(TextLayoutResult textLayoutResult, int i, boolean z, boolean z2) {
        int i2;
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        int lineForOffset = textLayoutResult.getLineForOffset(i);
        boolean z3 = false;
        if ((!z || z2) && (z || !z2)) {
            i2 = Math.max(i - 1, 0);
        } else {
            i2 = i;
        }
        if (textLayoutResult.getBidiRunDirection(i2) == textLayoutResult.getParagraphDirection(i)) {
            z3 = true;
        }
        return OffsetKt.Offset(textLayoutResult.getHorizontalPosition(i, z3), textLayoutResult.getLineBottom(lineForOffset));
    }
}
