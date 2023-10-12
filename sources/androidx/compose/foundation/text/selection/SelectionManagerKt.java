package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.text.AnnotatedString;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0000\u001a!\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a\f\u0010\u0010\u001a\u00020\u000b*\u00020\u0011H\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"getCurrentSelectedText", "Landroidx/compose/ui/text/AnnotatedString;", "selectable", "Landroidx/compose/foundation/text/selection/Selectable;", "selection", "Landroidx/compose/foundation/text/selection/Selection;", "merge", "lhs", "rhs", "containsInclusive", "", "Landroidx/compose/ui/geometry/Rect;", "offset", "Landroidx/compose/ui/geometry/Offset;", "containsInclusive-Uv8p0NA", "(Landroidx/compose/ui/geometry/Rect;J)Z", "visibleBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: SelectionManager.kt */
public final class SelectionManagerKt {
    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0003, code lost:
        r0 = r0.merge(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.foundation.text.selection.Selection merge(androidx.compose.foundation.text.selection.Selection r0, androidx.compose.foundation.text.selection.Selection r1) {
        /*
            if (r0 != 0) goto L_0x0003
            goto L_0x000b
        L_0x0003:
            androidx.compose.foundation.text.selection.Selection r0 = r0.merge(r1)
            if (r0 != 0) goto L_0x000a
            goto L_0x000b
        L_0x000a:
            r1 = r0
        L_0x000b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.selection.SelectionManagerKt.merge(androidx.compose.foundation.text.selection.Selection, androidx.compose.foundation.text.selection.Selection):androidx.compose.foundation.text.selection.Selection");
    }

    public static final AnnotatedString getCurrentSelectedText(Selectable selectable, Selection selection) {
        Intrinsics.checkNotNullParameter(selectable, "selectable");
        Intrinsics.checkNotNullParameter(selection, "selection");
        AnnotatedString text = selectable.getText();
        if (selectable.getSelectableId() != selection.getStart().getSelectableId() && selectable.getSelectableId() != selection.getEnd().getSelectableId()) {
            return text;
        }
        if (selectable.getSelectableId() == selection.getStart().getSelectableId() && selectable.getSelectableId() == selection.getEnd().getSelectableId()) {
            if (selection.getHandlesCrossed()) {
                return text.subSequence(selection.getEnd().getOffset(), selection.getStart().getOffset());
            }
            return text.subSequence(selection.getStart().getOffset(), selection.getEnd().getOffset());
        } else if (selectable.getSelectableId() == selection.getStart().getSelectableId()) {
            if (selection.getHandlesCrossed()) {
                return text.subSequence(0, selection.getStart().getOffset());
            }
            return text.subSequence(selection.getStart().getOffset(), text.length());
        } else if (selection.getHandlesCrossed()) {
            return text.subSequence(selection.getEnd().getOffset(), text.length());
        } else {
            return text.subSequence(0, selection.getEnd().getOffset());
        }
    }

    public static final Rect visibleBounds(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        Rect boundsInWindow = LayoutCoordinatesKt.boundsInWindow(layoutCoordinates);
        return RectKt.m1391Rect0a9Yr6o(layoutCoordinates.m3144windowToLocalMKHz9U(boundsInWindow.m1388getTopLeftF1C5BW0()), layoutCoordinates.m3144windowToLocalMKHz9U(boundsInWindow.m1382getBottomRightF1C5BW0()));
    }

    /* renamed from: containsInclusive-Uv8p0NA  reason: not valid java name */
    public static final boolean m793containsInclusiveUv8p0NA(Rect rect, long j) {
        Intrinsics.checkNotNullParameter(rect, "$this$containsInclusive");
        float left = rect.getLeft();
        float right = rect.getRight();
        float r2 = Offset.m1353getXimpl(j);
        if (left <= r2 && r2 <= right) {
            float top = rect.getTop();
            float bottom = rect.getBottom();
            float r6 = Offset.m1354getYimpl(j);
            if (top <= r6 && r6 <= bottom) {
                return true;
            }
        }
        return false;
    }
}
