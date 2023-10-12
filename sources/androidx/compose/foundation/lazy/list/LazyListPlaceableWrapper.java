package androidx.compose.foundation.lazy.list;

import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\"\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/lazy/list/LazyListPlaceableWrapper;", "", "offset", "Landroidx/compose/ui/unit/IntOffset;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "parentData", "(JLandroidx/compose/ui/layout/Placeable;Ljava/lang/Object;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getOffset-nOcc-ac", "()J", "J", "getParentData", "()Ljava/lang/Object;", "getPlaceable", "()Landroidx/compose/ui/layout/Placeable;", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyMeasuredItem.kt */
public final class LazyListPlaceableWrapper {
    private final long offset;
    private final Object parentData;
    private final Placeable placeable;

    public /* synthetic */ LazyListPlaceableWrapper(long j, Placeable placeable2, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, placeable2, obj);
    }

    private LazyListPlaceableWrapper(long j, Placeable placeable2, Object obj) {
        this.offset = j;
        this.placeable = placeable2;
        this.parentData = obj;
    }

    /* renamed from: getOffset-nOcc-ac  reason: not valid java name */
    public final long m563getOffsetnOccac() {
        return this.offset;
    }

    public final Placeable getPlaceable() {
        return this.placeable;
    }

    public final Object getParentData() {
        return this.parentData;
    }
}
