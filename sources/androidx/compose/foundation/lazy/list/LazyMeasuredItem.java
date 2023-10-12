package androidx.compose.foundation.lazy.list;

import androidx.compose.foundation.lazy.layout.LazyLayoutPlaceable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001Bz\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u001e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u0003R\u000e\u0010\u0011\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\"\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u000e\u0010\u0014\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0015\u001a\u00020\u0016X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010$\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006*"}, d2 = {"Landroidx/compose/foundation/lazy/list/LazyMeasuredItem;", "", "index", "", "placeables", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPlaceable;", "isVertical", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "reverseLayout", "beforeContentPadding", "afterContentPadding", "placementAnimator", "Landroidx/compose/foundation/lazy/list/LazyListItemPlacementAnimator;", "spacing", "visualOffset", "Landroidx/compose/ui/unit/IntOffset;", "key", "(I[Landroidx/compose/foundation/lazy/layout/LazyLayoutPlaceable;ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZIILandroidx/compose/foundation/lazy/list/LazyListItemPlacementAnimator;IJLjava/lang/Object;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "crossAxisSize", "getCrossAxisSize", "()I", "getIndex", "getKey", "()Ljava/lang/Object;", "[Landroidx/compose/foundation/lazy/layout/LazyLayoutPlaceable;", "size", "getSize", "sizeWithSpacings", "getSizeWithSpacings", "J", "position", "Landroidx/compose/foundation/lazy/list/LazyListPositionedItem;", "offset", "layoutWidth", "layoutHeight", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LazyMeasuredItem.kt */
public final class LazyMeasuredItem {
    private final int afterContentPadding;
    private final int beforeContentPadding;
    private final int crossAxisSize;
    private final Alignment.Horizontal horizontalAlignment;
    private final int index;
    private final boolean isVertical;
    private final Object key;
    private final LayoutDirection layoutDirection;
    private final LazyLayoutPlaceable[] placeables;
    private final LazyListItemPlacementAnimator placementAnimator;
    private final boolean reverseLayout;
    private final int size;
    private final int sizeWithSpacings;
    private final int spacing;
    private final Alignment.Vertical verticalAlignment;
    private final long visualOffset;

    public /* synthetic */ LazyMeasuredItem(int i, LazyLayoutPlaceable[] lazyLayoutPlaceableArr, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection2, boolean z2, int i2, int i3, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, int i4, long j, Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, lazyLayoutPlaceableArr, z, horizontal, vertical, layoutDirection2, z2, i2, i3, lazyListItemPlacementAnimator, i4, j, obj);
    }

    private LazyMeasuredItem(int i, LazyLayoutPlaceable[] lazyLayoutPlaceableArr, boolean z, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection2, boolean z2, int i2, int i3, LazyListItemPlacementAnimator lazyListItemPlacementAnimator, int i4, long j, Object obj) {
        this.index = i;
        this.placeables = lazyLayoutPlaceableArr;
        this.isVertical = z;
        this.horizontalAlignment = horizontal;
        this.verticalAlignment = vertical;
        this.layoutDirection = layoutDirection2;
        this.reverseLayout = z2;
        this.beforeContentPadding = i2;
        this.afterContentPadding = i3;
        this.placementAnimator = lazyListItemPlacementAnimator;
        this.spacing = i4;
        this.visualOffset = j;
        this.key = obj;
        int length = lazyLayoutPlaceableArr.length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < length) {
            LazyLayoutPlaceable lazyLayoutPlaceable = lazyLayoutPlaceableArr[i5];
            i5++;
            Placeable placeable = lazyLayoutPlaceable.getPlaceable();
            i6 += this.isVertical ? placeable.getHeight() : placeable.getWidth();
            i7 = Math.max(i7, !this.isVertical ? placeable.getHeight() : placeable.getWidth());
        }
        this.size = i6;
        this.sizeWithSpacings = i6 + this.spacing;
        this.crossAxisSize = i7;
    }

    public final int getIndex() {
        return this.index;
    }

    public final Object getKey() {
        return this.key;
    }

    public final int getSize() {
        return this.size;
    }

    public final int getSizeWithSpacings() {
        return this.sizeWithSpacings;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    public final LazyListPositionedItem position(int i, int i2, int i3) {
        long j;
        List arrayList = new ArrayList();
        int i4 = this.isVertical ? i3 : i2;
        boolean z = this.reverseLayout;
        int i5 = z ? (i4 - i) - this.size : i;
        int lastIndex = z ? ArraysKt.getLastIndex((T[]) this.placeables) : 0;
        while (true) {
            boolean z2 = this.reverseLayout;
            boolean z3 = true;
            if (!z2 ? lastIndex >= this.placeables.length : lastIndex < 0) {
                z3 = false;
            }
            if (z3) {
                Placeable placeable = this.placeables[lastIndex].getPlaceable();
                int size2 = this.reverseLayout ? 0 : arrayList.size();
                if (this.isVertical) {
                    Alignment.Horizontal horizontal = this.horizontalAlignment;
                    if (horizontal != null) {
                        j = IntOffsetKt.IntOffset(horizontal.align(placeable.getWidth(), i2, this.layoutDirection), i5);
                        int i6 = i3;
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                } else {
                    int i7 = i2;
                    Alignment.Vertical vertical = this.verticalAlignment;
                    if (vertical != null) {
                        j = IntOffsetKt.IntOffset(i5, vertical.align(placeable.getHeight(), i3));
                    } else {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                }
                long j2 = j;
                i5 += this.isVertical ? placeable.getHeight() : placeable.getWidth();
                arrayList.add(size2, new LazyListPlaceableWrapper(j2, placeable, this.placeables[lastIndex].getParentData(), (DefaultConstructorMarker) null));
                lastIndex = this.reverseLayout ? lastIndex - 1 : lastIndex + 1;
            } else {
                return new LazyListPositionedItem(i, this.index, this.key, this.size, this.sizeWithSpacings, -(!z2 ? this.beforeContentPadding : this.afterContentPadding), i4 + (!z2 ? this.afterContentPadding : this.beforeContentPadding), this.isVertical, arrayList, this.placementAnimator, this.visualOffset, (DefaultConstructorMarker) null);
            }
        }
    }
}
