package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BF\u0012#\u0010\u0003\u001a\u001f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0002\b\t\u0012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\tø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J)\u0010\u0019\u001a\u00020\b*\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0007H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001dR1\u0010\u0003\u001a\u001f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0002\b\tø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/layout/LayoutModifierImpl;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "measureBlock", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;)V", "getMeasureBlock", "()Lkotlin/jvm/functions/Function3;", "equals", "", "other", "", "hashCode", "", "toString", "", "measure", "measurable", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LayoutModifier.kt */
final class LayoutModifierImpl extends InspectorValueInfo implements LayoutModifier {
    private final Function3<MeasureScope, Measurable, Constraints, MeasureResult> measureBlock;

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

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifier.DefaultImpls.maxIntrinsicHeight(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifier.DefaultImpls.maxIntrinsicWidth(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifier.DefaultImpls.minIntrinsicHeight(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return LayoutModifier.DefaultImpls.minIntrinsicWidth(this, intrinsicMeasureScope, intrinsicMeasurable, i);
    }

    public Modifier then(Modifier modifier) {
        return LayoutModifier.DefaultImpls.then(this, modifier);
    }

    public final Function3<MeasureScope, Measurable, Constraints, MeasureResult> getMeasureBlock() {
        return this.measureBlock;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutModifierImpl(Function3<? super MeasureScope, ? super Measurable, ? super Constraints, ? extends MeasureResult> function3, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(function3, "measureBlock");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.measureBlock = function3;
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m3150measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$receiver");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        return this.measureBlock.invoke(measureScope, measurable, Constraints.m3791boximpl(j));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        LayoutModifierImpl layoutModifierImpl = obj instanceof LayoutModifierImpl ? (LayoutModifierImpl) obj : null;
        if (layoutModifierImpl == null) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.measureBlock, (Object) layoutModifierImpl.measureBlock);
    }

    public int hashCode() {
        return this.measureBlock.hashCode();
    }

    public String toString() {
        return "LayoutModifierImpl(measureBlock=" + this.measureBlock + ')';
    }
}
