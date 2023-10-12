package androidx.compose.foundation;

import androidx.compose.foundation.gestures.OverScrollController;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u001c\u0010\u001b\u001a\u00020\u0018*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\u001c\u0010 \u001a\u00020\u0018*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0018H\u0016J)\u0010\"\u001a\u00020#*\u00020$2\u0006\u0010\u001d\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)J\u001c\u0010*\u001a\u00020\u0018*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0018H\u0016J\u001c\u0010+\u001a\u00020\u0018*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0018H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\nR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006,"}, d2 = {"Landroidx/compose/foundation/ScrollingLayoutModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "scrollerState", "Landroidx/compose/foundation/ScrollState;", "isReversed", "", "isVertical", "overScrollController", "Landroidx/compose/foundation/gestures/OverScrollController;", "(Landroidx/compose/foundation/ScrollState;ZZLandroidx/compose/foundation/gestures/OverScrollController;)V", "()Z", "getOverScrollController", "()Landroidx/compose/foundation/gestures/OverScrollController;", "getScrollerState", "()Landroidx/compose/foundation/ScrollState;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Scroll.kt */
final class ScrollingLayoutModifier implements LayoutModifier {
    private final boolean isReversed;
    private final boolean isVertical;
    private final OverScrollController overScrollController;
    private final ScrollState scrollerState;

    public static /* synthetic */ ScrollingLayoutModifier copy$default(ScrollingLayoutModifier scrollingLayoutModifier, ScrollState scrollState, boolean z, boolean z2, OverScrollController overScrollController2, int i, Object obj) {
        if ((i & 1) != 0) {
            scrollState = scrollingLayoutModifier.scrollerState;
        }
        if ((i & 2) != 0) {
            z = scrollingLayoutModifier.isReversed;
        }
        if ((i & 4) != 0) {
            z2 = scrollingLayoutModifier.isVertical;
        }
        if ((i & 8) != 0) {
            overScrollController2 = scrollingLayoutModifier.overScrollController;
        }
        return scrollingLayoutModifier.copy(scrollState, z, z2, overScrollController2);
    }

    public final ScrollState component1() {
        return this.scrollerState;
    }

    public final boolean component2() {
        return this.isReversed;
    }

    public final boolean component3() {
        return this.isVertical;
    }

    public final OverScrollController component4() {
        return this.overScrollController;
    }

    public final ScrollingLayoutModifier copy(ScrollState scrollState, boolean z, boolean z2, OverScrollController overScrollController2) {
        Intrinsics.checkNotNullParameter(scrollState, "scrollerState");
        Intrinsics.checkNotNullParameter(overScrollController2, "overScrollController");
        return new ScrollingLayoutModifier(scrollState, z, z2, overScrollController2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScrollingLayoutModifier)) {
            return false;
        }
        ScrollingLayoutModifier scrollingLayoutModifier = (ScrollingLayoutModifier) obj;
        return Intrinsics.areEqual((Object) this.scrollerState, (Object) scrollingLayoutModifier.scrollerState) && this.isReversed == scrollingLayoutModifier.isReversed && this.isVertical == scrollingLayoutModifier.isVertical && Intrinsics.areEqual((Object) this.overScrollController, (Object) scrollingLayoutModifier.overScrollController);
    }

    public int hashCode() {
        int hashCode = this.scrollerState.hashCode() * 31;
        boolean z = this.isReversed;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        boolean z3 = this.isVertical;
        if (!z3) {
            z2 = z3;
        }
        return ((i + (z2 ? 1 : 0)) * 31) + this.overScrollController.hashCode();
    }

    public String toString() {
        return "ScrollingLayoutModifier(scrollerState=" + this.scrollerState + ", isReversed=" + this.isReversed + ", isVertical=" + this.isVertical + ", overScrollController=" + this.overScrollController + ')';
    }

    public ScrollingLayoutModifier(ScrollState scrollState, boolean z, boolean z2, OverScrollController overScrollController2) {
        Intrinsics.checkNotNullParameter(scrollState, "scrollerState");
        Intrinsics.checkNotNullParameter(overScrollController2, "overScrollController");
        this.scrollerState = scrollState;
        this.isReversed = z;
        this.isVertical = z2;
        this.overScrollController = overScrollController2;
    }

    public boolean all(Function1<? super Modifier.Element, Boolean> function1) {
        return LayoutModifier.DefaultImpls.all(this, function1);
    }

    public boolean any(Function1<? super Modifier.Element, Boolean> function1) {
        return LayoutModifier.DefaultImpls.any(this, function1);
    }

    public <R> R foldIn(R r, Function2<? super R, ? super Modifier.Element, ? extends R> function2) {
        return LayoutModifier.DefaultImpls.foldIn(this, r, function2);
    }

    public <R> R foldOut(R r, Function2<? super Modifier.Element, ? super R, ? extends R> function2) {
        return LayoutModifier.DefaultImpls.foldOut(this, r, function2);
    }

    public Modifier then(Modifier modifier) {
        return LayoutModifier.DefaultImpls.then(this, modifier);
    }

    public final ScrollState getScrollerState() {
        return this.scrollerState;
    }

    public final boolean isReversed() {
        return this.isReversed;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public final OverScrollController getOverScrollController() {
        return this.overScrollController;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m224measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$receiver");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        ScrollKt.m221assertNotNestingScrollableContainersK40F9xA(j, this.isVertical);
        Placeable r12 = measurable.m3151measureBRTryo0(Constraints.m3794copyZbe2FdA$default(j, 0, this.isVertical ? Constraints.m3803getMaxWidthimpl(j) : Integer.MAX_VALUE, 0, this.isVertical ? Integer.MAX_VALUE : Constraints.m3802getMaxHeightimpl(j), 5, (Object) null));
        int coerceAtMost = RangesKt.coerceAtMost(r12.getWidth(), Constraints.m3803getMaxWidthimpl(j));
        int coerceAtMost2 = RangesKt.coerceAtMost(r12.getHeight(), Constraints.m3802getMaxHeightimpl(j));
        int height = r12.getHeight() - coerceAtMost2;
        int width = r12.getWidth() - coerceAtMost;
        if (!this.isVertical) {
            height = width;
        }
        this.overScrollController.m282refreshContainerInfoTmRCtEA(SizeKt.Size((float) coerceAtMost, (float) coerceAtMost2), height != 0);
        return MeasureScope.DefaultImpls.layout$default(measureScope, coerceAtMost, coerceAtMost2, (Map) null, new ScrollingLayoutModifier$measure$1(this, height, r12), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }
}
