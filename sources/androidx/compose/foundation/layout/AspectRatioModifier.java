package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B.\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0019\u0010\u0018\u001a\u00020\u0019*\u00020\u001aH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001c\u0010\u001d\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015H\u0016J\u001c\u0010\"\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0015H\u0016J)\u0010$\u001a\u00020%*\u00020&2\u0006\u0010\u001f\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001aH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*J\u001c\u0010+\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015H\u0016J\u001c\u0010,\u001a\u00020\u0015*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0015H\u0016J#\u0010-\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b/\u00100J#\u00101\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00100J#\u00103\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00100J#\u00105\u001a\u00020\u0019*\u00020\u001a2\b\b\u0002\u0010.\u001a\u00020\u0006H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u00100R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00067"}, d2 = {"Landroidx/compose/foundation/layout/AspectRatioModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "aspectRatio", "", "matchHeightConstraintsFirst", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FZLkotlin/jvm/functions/Function1;)V", "getAspectRatio", "()F", "getMatchHeightConstraintsFirst", "()Z", "equals", "other", "", "hashCode", "", "toString", "", "findSize", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/Constraints;", "findSize-ToXhtMw", "(J)J", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "tryMaxHeight", "enforceConstraints", "tryMaxHeight-JN-0ABg", "(JZ)J", "tryMaxWidth", "tryMaxWidth-JN-0ABg", "tryMinHeight", "tryMinHeight-JN-0ABg", "tryMinWidth", "tryMinWidth-JN-0ABg", "foundation-layout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AspectRatio.kt */
final class AspectRatioModifier extends InspectorValueInfo implements LayoutModifier {
    private final float aspectRatio;
    private final boolean matchHeightConstraintsFirst;

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

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AspectRatioModifier(float f, boolean z, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.aspectRatio = f;
        this.matchHeightConstraintsFirst = z;
        if (!(f > 0.0f)) {
            throw new IllegalArgumentException(("aspectRatio " + getAspectRatio() + " must be > 0").toString());
        }
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m386measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$receiver");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        long r0 = m377findSizeToXhtMw(j);
        if (!IntSize.m4017equalsimpl0(r0, IntSize.Companion.m4024getZeroYbymL2g())) {
            j = Constraints.Companion.m3811fixedJhjzzOo(IntSize.m4019getWidthimpl(r0), IntSize.m4018getHeightimpl(r0));
        }
        Placeable r9 = measurable.m3151measureBRTryo0(j);
        return MeasureScope.DefaultImpls.layout$default(measureScope, r9.getWidth(), r9.getHeight(), (Map) null, new AspectRatioModifier$measure$1(r9), 4, (Object) null);
    }

    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(((float) i) * this.aspectRatio);
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(((float) i) * this.aspectRatio);
        }
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(((float) i) / this.aspectRatio);
        }
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "measurable");
        if (i != Integer.MAX_VALUE) {
            return MathKt.roundToInt(((float) i) / this.aspectRatio);
        }
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    /* renamed from: findSize-ToXhtMw  reason: not valid java name */
    private final long m377findSizeToXhtMw(long j) {
        if (!this.matchHeightConstraintsFirst) {
            long r2 = m381tryMaxWidthJN0ABg$default(this, j, false, 1, (Object) null);
            if (!IntSize.m4017equalsimpl0(r2, IntSize.Companion.m4024getZeroYbymL2g())) {
                return r2;
            }
            long r22 = m379tryMaxHeightJN0ABg$default(this, j, false, 1, (Object) null);
            if (!IntSize.m4017equalsimpl0(r22, IntSize.Companion.m4024getZeroYbymL2g())) {
                return r22;
            }
            long r23 = m385tryMinWidthJN0ABg$default(this, j, false, 1, (Object) null);
            if (!IntSize.m4017equalsimpl0(r23, IntSize.Companion.m4024getZeroYbymL2g())) {
                return r23;
            }
            long r24 = m383tryMinHeightJN0ABg$default(this, j, false, 1, (Object) null);
            if (!IntSize.m4017equalsimpl0(r24, IntSize.Companion.m4024getZeroYbymL2g())) {
                return r24;
            }
            long r25 = m380tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m4017equalsimpl0(r25, IntSize.Companion.m4024getZeroYbymL2g())) {
                return r25;
            }
            long r26 = m378tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m4017equalsimpl0(r26, IntSize.Companion.m4024getZeroYbymL2g())) {
                return r26;
            }
            long r27 = m384tryMinWidthJN0ABg(j, false);
            if (!IntSize.m4017equalsimpl0(r27, IntSize.Companion.m4024getZeroYbymL2g())) {
                return r27;
            }
            long r11 = m382tryMinHeightJN0ABg(j, false);
            if (!IntSize.m4017equalsimpl0(r11, IntSize.Companion.m4024getZeroYbymL2g())) {
                return r11;
            }
        } else {
            long r28 = m379tryMaxHeightJN0ABg$default(this, j, false, 1, (Object) null);
            if (!IntSize.m4017equalsimpl0(r28, IntSize.Companion.m4024getZeroYbymL2g())) {
                return r28;
            }
            long r29 = m381tryMaxWidthJN0ABg$default(this, j, false, 1, (Object) null);
            if (!IntSize.m4017equalsimpl0(r29, IntSize.Companion.m4024getZeroYbymL2g())) {
                return r29;
            }
            long r210 = m383tryMinHeightJN0ABg$default(this, j, false, 1, (Object) null);
            if (!IntSize.m4017equalsimpl0(r210, IntSize.Companion.m4024getZeroYbymL2g())) {
                return r210;
            }
            long r211 = m385tryMinWidthJN0ABg$default(this, j, false, 1, (Object) null);
            if (!IntSize.m4017equalsimpl0(r211, IntSize.Companion.m4024getZeroYbymL2g())) {
                return r211;
            }
            long r212 = m378tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m4017equalsimpl0(r212, IntSize.Companion.m4024getZeroYbymL2g())) {
                return r212;
            }
            long r213 = m380tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m4017equalsimpl0(r213, IntSize.Companion.m4024getZeroYbymL2g())) {
                return r213;
            }
            long r214 = m382tryMinHeightJN0ABg(j, false);
            if (!IntSize.m4017equalsimpl0(r214, IntSize.Companion.m4024getZeroYbymL2g())) {
                return r214;
            }
            long r112 = m384tryMinWidthJN0ABg(j, false);
            if (!IntSize.m4017equalsimpl0(r112, IntSize.Companion.m4024getZeroYbymL2g())) {
                return r112;
            }
        }
        return IntSize.Companion.m4024getZeroYbymL2g();
    }

    /* renamed from: tryMaxWidth-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m381tryMaxWidthJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m380tryMaxWidthJN0ABg(j, z);
    }

    /* renamed from: tryMaxWidth-JN-0ABg  reason: not valid java name */
    private final long m380tryMaxWidthJN0ABg(long j, boolean z) {
        int roundToInt;
        int r0 = Constraints.m3803getMaxWidthimpl(j);
        if (r0 != Integer.MAX_VALUE && (roundToInt = MathKt.roundToInt(((float) r0) / this.aspectRatio)) > 0) {
            long IntSize = IntSizeKt.IntSize(r0, roundToInt);
            if (!z || ConstraintsKt.m3818isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m4024getZeroYbymL2g();
    }

    /* renamed from: tryMaxHeight-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m379tryMaxHeightJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m378tryMaxHeightJN0ABg(j, z);
    }

    /* renamed from: tryMaxHeight-JN-0ABg  reason: not valid java name */
    private final long m378tryMaxHeightJN0ABg(long j, boolean z) {
        int roundToInt;
        int r0 = Constraints.m3802getMaxHeightimpl(j);
        if (r0 != Integer.MAX_VALUE && (roundToInt = MathKt.roundToInt(((float) r0) * this.aspectRatio)) > 0) {
            long IntSize = IntSizeKt.IntSize(roundToInt, r0);
            if (!z || ConstraintsKt.m3818isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m4024getZeroYbymL2g();
    }

    /* renamed from: tryMinWidth-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m385tryMinWidthJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m384tryMinWidthJN0ABg(j, z);
    }

    /* renamed from: tryMinWidth-JN-0ABg  reason: not valid java name */
    private final long m384tryMinWidthJN0ABg(long j, boolean z) {
        int r0 = Constraints.m3805getMinWidthimpl(j);
        int roundToInt = MathKt.roundToInt(((float) r0) / this.aspectRatio);
        if (roundToInt > 0) {
            long IntSize = IntSizeKt.IntSize(r0, roundToInt);
            if (!z || ConstraintsKt.m3818isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m4024getZeroYbymL2g();
    }

    /* renamed from: tryMinHeight-JN-0ABg$default  reason: not valid java name */
    static /* synthetic */ long m383tryMinHeightJN0ABg$default(AspectRatioModifier aspectRatioModifier, long j, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return aspectRatioModifier.m382tryMinHeightJN0ABg(j, z);
    }

    /* renamed from: tryMinHeight-JN-0ABg  reason: not valid java name */
    private final long m382tryMinHeightJN0ABg(long j, boolean z) {
        int r0 = Constraints.m3804getMinHeightimpl(j);
        int roundToInt = MathKt.roundToInt(((float) r0) * this.aspectRatio);
        if (roundToInt > 0) {
            long IntSize = IntSizeKt.IntSize(roundToInt, r0);
            if (!z || ConstraintsKt.m3818isSatisfiedBy4WqzIAM(j, IntSize)) {
                return IntSize;
            }
        }
        return IntSize.Companion.m4024getZeroYbymL2g();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        AspectRatioModifier aspectRatioModifier = obj instanceof AspectRatioModifier ? (AspectRatioModifier) obj : null;
        if (aspectRatioModifier == null) {
            return false;
        }
        if (!(this.aspectRatio == aspectRatioModifier.aspectRatio) || this.matchHeightConstraintsFirst != ((AspectRatioModifier) obj).matchHeightConstraintsFirst) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.aspectRatio) * 31) + C$r8$backportedMethods$utility$Boolean$1$hashCode.hashCode(this.matchHeightConstraintsFirst);
    }

    public String toString() {
        return "AspectRatioModifier(aspectRatio=" + this.aspectRatio + ')';
    }
}
