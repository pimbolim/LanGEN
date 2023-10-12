package androidx.compose.foundation.lazy.list;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001b\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/lazy/list/MutableIntervalList;", "T", "Landroidx/compose/foundation/lazy/list/IntervalList;", "()V", "_intervals", "", "Landroidx/compose/foundation/lazy/list/IntervalHolder;", "intervals", "", "getIntervals", "()Ljava/util/List;", "<set-?>", "", "totalSize", "getTotalSize", "()I", "add", "", "size", "content", "(ILjava/lang/Object;)V", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IntervalList.kt */
public final class MutableIntervalList<T> implements IntervalList<T> {
    private final List<IntervalHolder<T>> _intervals;
    private final List<IntervalHolder<T>> intervals;
    private int totalSize;

    public MutableIntervalList() {
        List<IntervalHolder<T>> arrayList = new ArrayList<>();
        this._intervals = arrayList;
        this.intervals = arrayList;
    }

    public List<IntervalHolder<T>> getIntervals() {
        return this.intervals;
    }

    public int getTotalSize() {
        return this.totalSize;
    }

    public final void add(int i, T t) {
        if (i != 0) {
            IntervalHolder intervalHolder = new IntervalHolder(getTotalSize(), i, t);
            this.totalSize = getTotalSize() + i;
            this._intervals.add(intervalHolder);
        }
    }
}
