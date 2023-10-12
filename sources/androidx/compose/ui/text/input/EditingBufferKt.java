package androidx.compose.ui.text.input;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", "target", "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "ui-text_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: EditingBuffer.kt */
public final class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M  reason: not valid java name */
    public static final long m3634updateRangeAfterDeletepWDy79M(long j, long j2) {
        int i;
        int r0 = TextRange.m3569getMinimpl(j);
        int r1 = TextRange.m3568getMaximpl(j);
        if (TextRange.m3573intersects5zctL8(j2, j)) {
            if (TextRange.m3561contains5zctL8(j2, j)) {
                r0 = TextRange.m3569getMinimpl(j2);
                r1 = r0;
            } else if (TextRange.m3561contains5zctL8(j, j2)) {
                i = TextRange.m3567getLengthimpl(j2);
            } else if (TextRange.m3562containsimpl(j2, r0)) {
                r0 = TextRange.m3569getMinimpl(j2);
                i = TextRange.m3567getLengthimpl(j2);
            } else {
                r1 = TextRange.m3569getMinimpl(j2);
            }
            return TextRangeKt.TextRange(r0, r1);
        }
        if (r1 > TextRange.m3569getMinimpl(j2)) {
            r0 -= TextRange.m3567getLengthimpl(j2);
            i = TextRange.m3567getLengthimpl(j2);
        }
        return TextRangeKt.TextRange(r0, r1);
        r1 -= i;
        return TextRangeKt.TextRange(r0, r1);
    }
}
