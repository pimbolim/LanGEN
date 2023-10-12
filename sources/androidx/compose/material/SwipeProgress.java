package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ExperimentalMaterialApi
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000b¨\u0006\u0015"}, d2 = {"Landroidx/compose/material/SwipeProgress;", "T", "", "from", "to", "fraction", "", "(Ljava/lang/Object;Ljava/lang/Object;F)V", "getFraction", "()F", "getFrom", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTo", "equals", "", "other", "hashCode", "", "toString", "", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Swipeable.kt */
public final class SwipeProgress<T> {
    private final float fraction;
    private final T from;
    private final T to;

    public SwipeProgress(T t, T t2, float f) {
        this.from = t;
        this.to = t2;
        this.fraction = f;
    }

    public final T getFrom() {
        return this.from;
    }

    public final T getTo() {
        return this.to;
    }

    public final float getFraction() {
        return this.fraction;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwipeProgress)) {
            return false;
        }
        SwipeProgress swipeProgress = (SwipeProgress) obj;
        if (!Intrinsics.areEqual((Object) this.from, (Object) swipeProgress.from) || !Intrinsics.areEqual((Object) this.to, (Object) swipeProgress.to)) {
            return false;
        }
        return (this.fraction > swipeProgress.fraction ? 1 : (this.fraction == swipeProgress.fraction ? 0 : -1)) == 0;
    }

    public int hashCode() {
        T t = this.from;
        int i = 0;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        T t2 = this.to;
        if (t2 != null) {
            i = t2.hashCode();
        }
        return ((hashCode + i) * 31) + Float.floatToIntBits(this.fraction);
    }

    public String toString() {
        return "SwipeProgress(from=" + this.from + ", to=" + this.to + ", fraction=" + this.fraction + ')';
    }
}
