package androidx.compose.foundation.lazy.list;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007R\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Landroidx/compose/foundation/lazy/list/IntervalHolder;", "T", "", "startIndex", "", "size", "content", "(IILjava/lang/Object;)V", "getContent", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSize", "()I", "getStartIndex", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IntervalList.kt */
public final class IntervalHolder<T> {
    private final T content;
    private final int size;
    private final int startIndex;

    public IntervalHolder(int i, int i2, T t) {
        this.startIndex = i;
        this.size = i2;
        this.content = t;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final int getSize() {
        return this.size;
    }

    public final T getContent() {
        return this.content;
    }
}
