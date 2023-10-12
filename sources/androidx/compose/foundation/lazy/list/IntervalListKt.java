package androidx.compose.foundation.lazy.list;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a*\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0000\u001a \u0010\n\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\u0006\u0010\t\u001a\u00020\u0001H\u0000¨\u0006\u000b"}, d2 = {"findIndexOfHighestValueLesserThan", "", "T", "list", "", "Landroidx/compose/foundation/lazy/list/IntervalHolder;", "value", "intervalForIndex", "Landroidx/compose/foundation/lazy/list/IntervalList;", "index", "intervalIndexForItemIndex", "foundation_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: IntervalList.kt */
public final class IntervalListKt {
    public static final <T> IntervalHolder<T> intervalForIndex(IntervalList<T> intervalList, int i) {
        Intrinsics.checkNotNullParameter(intervalList, "<this>");
        return intervalList.getIntervals().get(intervalIndexForItemIndex(intervalList, i));
    }

    public static final <T> int intervalIndexForItemIndex(IntervalList<T> intervalList, int i) {
        Intrinsics.checkNotNullParameter(intervalList, "<this>");
        if (i >= 0 && i < intervalList.getTotalSize()) {
            return findIndexOfHighestValueLesserThan(intervalList.getIntervals(), i);
        }
        throw new IndexOutOfBoundsException("Index " + i + ", size " + intervalList.getTotalSize());
    }

    private static final <T> int findIndexOfHighestValueLesserThan(List<IntervalHolder<T>> list, int i) {
        int lastIndex = CollectionsKt.getLastIndex(list);
        int i2 = 0;
        while (i2 < lastIndex) {
            int i3 = ((lastIndex - i2) / 2) + i2;
            int startIndex = list.get(i3).getStartIndex();
            if (startIndex == i) {
                return i3;
            }
            if (startIndex < i) {
                i2 = i3 + 1;
                if (i < list.get(i2).getStartIndex()) {
                    return i3;
                }
            } else {
                lastIndex = i3 - 1;
            }
        }
        return i2;
    }
}
