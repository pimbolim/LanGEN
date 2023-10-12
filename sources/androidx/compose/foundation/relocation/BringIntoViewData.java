package androidx.compose.foundation.relocation;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewData;", "", "bringRectangleOnScreenRequester", "Landroidx/compose/foundation/relocation/BringRectangleOnScreenRequester;", "parent", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Landroidx/compose/foundation/relocation/BringRectangleOnScreenRequester;Landroidx/compose/foundation/relocation/BringIntoViewResponder;Landroidx/compose/ui/layout/LayoutCoordinates;)V", "getBringRectangleOnScreenRequester", "()Landroidx/compose/foundation/relocation/BringRectangleOnScreenRequester;", "getLayoutCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "setLayoutCoordinates", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", "getParent", "()Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "setParent", "(Landroidx/compose/foundation/relocation/BringIntoViewResponder;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ExperimentalFoundationApi
/* compiled from: BringIntoViewRequester.kt */
final class BringIntoViewData {
    private final BringRectangleOnScreenRequester bringRectangleOnScreenRequester;
    private LayoutCoordinates layoutCoordinates;
    private BringIntoViewResponder parent;

    public static /* synthetic */ BringIntoViewData copy$default(BringIntoViewData bringIntoViewData, BringRectangleOnScreenRequester bringRectangleOnScreenRequester2, BringIntoViewResponder bringIntoViewResponder, LayoutCoordinates layoutCoordinates2, int i, Object obj) {
        if ((i & 1) != 0) {
            bringRectangleOnScreenRequester2 = bringIntoViewData.bringRectangleOnScreenRequester;
        }
        if ((i & 2) != 0) {
            bringIntoViewResponder = bringIntoViewData.parent;
        }
        if ((i & 4) != 0) {
            layoutCoordinates2 = bringIntoViewData.layoutCoordinates;
        }
        return bringIntoViewData.copy(bringRectangleOnScreenRequester2, bringIntoViewResponder, layoutCoordinates2);
    }

    public final BringRectangleOnScreenRequester component1() {
        return this.bringRectangleOnScreenRequester;
    }

    public final BringIntoViewResponder component2() {
        return this.parent;
    }

    public final LayoutCoordinates component3() {
        return this.layoutCoordinates;
    }

    public final BringIntoViewData copy(BringRectangleOnScreenRequester bringRectangleOnScreenRequester2, BringIntoViewResponder bringIntoViewResponder, LayoutCoordinates layoutCoordinates2) {
        Intrinsics.checkNotNullParameter(bringRectangleOnScreenRequester2, "bringRectangleOnScreenRequester");
        Intrinsics.checkNotNullParameter(bringIntoViewResponder, "parent");
        return new BringIntoViewData(bringRectangleOnScreenRequester2, bringIntoViewResponder, layoutCoordinates2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BringIntoViewData)) {
            return false;
        }
        BringIntoViewData bringIntoViewData = (BringIntoViewData) obj;
        return Intrinsics.areEqual((Object) this.bringRectangleOnScreenRequester, (Object) bringIntoViewData.bringRectangleOnScreenRequester) && Intrinsics.areEqual((Object) this.parent, (Object) bringIntoViewData.parent) && Intrinsics.areEqual((Object) this.layoutCoordinates, (Object) bringIntoViewData.layoutCoordinates);
    }

    public int hashCode() {
        int hashCode = ((this.bringRectangleOnScreenRequester.hashCode() * 31) + this.parent.hashCode()) * 31;
        LayoutCoordinates layoutCoordinates2 = this.layoutCoordinates;
        return hashCode + (layoutCoordinates2 == null ? 0 : layoutCoordinates2.hashCode());
    }

    public String toString() {
        return "BringIntoViewData(bringRectangleOnScreenRequester=" + this.bringRectangleOnScreenRequester + ", parent=" + this.parent + ", layoutCoordinates=" + this.layoutCoordinates + ')';
    }

    public BringIntoViewData(BringRectangleOnScreenRequester bringRectangleOnScreenRequester2, BringIntoViewResponder bringIntoViewResponder, LayoutCoordinates layoutCoordinates2) {
        Intrinsics.checkNotNullParameter(bringRectangleOnScreenRequester2, "bringRectangleOnScreenRequester");
        Intrinsics.checkNotNullParameter(bringIntoViewResponder, "parent");
        this.bringRectangleOnScreenRequester = bringRectangleOnScreenRequester2;
        this.parent = bringIntoViewResponder;
        this.layoutCoordinates = layoutCoordinates2;
    }

    public final BringRectangleOnScreenRequester getBringRectangleOnScreenRequester() {
        return this.bringRectangleOnScreenRequester;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BringIntoViewData(BringRectangleOnScreenRequester bringRectangleOnScreenRequester2, BringIntoViewResponder bringIntoViewResponder, LayoutCoordinates layoutCoordinates2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bringRectangleOnScreenRequester2, (i & 2) != 0 ? BringIntoViewResponder.Companion.getRootBringIntoViewResponder() : bringIntoViewResponder, (i & 4) != 0 ? null : layoutCoordinates2);
    }

    public final BringIntoViewResponder getParent() {
        return this.parent;
    }

    public final void setParent(BringIntoViewResponder bringIntoViewResponder) {
        Intrinsics.checkNotNullParameter(bringIntoViewResponder, "<set-?>");
        this.parent = bringIntoViewResponder;
    }

    public final LayoutCoordinates getLayoutCoordinates() {
        return this.layoutCoordinates;
    }

    public final void setLayoutCoordinates(LayoutCoordinates layoutCoordinates2) {
        this.layoutCoordinates = layoutCoordinates2;
    }
}
