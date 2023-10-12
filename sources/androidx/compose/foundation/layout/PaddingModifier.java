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
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BQ\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J)\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010%R\u001c\u0010\u0007\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0016\u0010\u0011R\u001c\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0017\u0010\u0011\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, d2 = {"Landroidx/compose/foundation/layout/PaddingModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "rtlAware", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFFFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM", "()F", "F", "getEnd-D9Ej5fM", "getRtlAware", "()Z", "getStart-D9Ej5fM", "getTop-D9Ej5fM", "equals", "other", "", "hashCode", "", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Padding.kt */
final class PaddingModifier extends InspectorValueInfo implements LayoutModifier {
    private final float bottom;
    private final float end;
    private final boolean rtlAware;
    private final float start;
    private final float top;

    public /* synthetic */ PaddingModifier(float f, float f2, float f3, float f4, boolean z, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, f2, f3, f4, z, function1);
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

    /* renamed from: getStart-D9Ej5fM  reason: not valid java name */
    public final float m438getStartD9Ej5fM() {
        return this.start;
    }

    /* renamed from: getTop-D9Ej5fM  reason: not valid java name */
    public final float m439getTopD9Ej5fM() {
        return this.top;
    }

    /* renamed from: getEnd-D9Ej5fM  reason: not valid java name */
    public final float m437getEndD9Ej5fM() {
        return this.end;
    }

    /* renamed from: getBottom-D9Ej5fM  reason: not valid java name */
    public final float m436getBottomD9Ej5fM() {
        return this.bottom;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    private PaddingModifier(float f, float f2, float f3, float f4, boolean z, Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        this.start = f;
        this.top = f2;
        this.end = f3;
        this.bottom = f4;
        this.rtlAware = z;
        if (!((m438getStartD9Ej5fM() >= 0.0f || Dp.m3864equalsimpl0(m438getStartD9Ej5fM(), Dp.Companion.m3879getUnspecifiedD9Ej5fM())) && (m439getTopD9Ej5fM() >= 0.0f || Dp.m3864equalsimpl0(m439getTopD9Ej5fM(), Dp.Companion.m3879getUnspecifiedD9Ej5fM())) && ((m437getEndD9Ej5fM() >= 0.0f || Dp.m3864equalsimpl0(m437getEndD9Ej5fM(), Dp.Companion.m3879getUnspecifiedD9Ej5fM())) && (m436getBottomD9Ej5fM() >= 0.0f || Dp.m3864equalsimpl0(m436getBottomD9Ej5fM(), Dp.Companion.m3879getUnspecifiedD9Ej5fM()))))) {
            throw new IllegalArgumentException("Padding must be non-negative".toString());
        }
    }

    /* renamed from: measure-3p2s80s  reason: not valid java name */
    public MeasureResult m440measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        Intrinsics.checkNotNullParameter(measureScope, "$receiver");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        int r0 = measureScope.m3822roundToPx0680j_4(m438getStartD9Ej5fM()) + measureScope.m3822roundToPx0680j_4(m437getEndD9Ej5fM());
        int r1 = measureScope.m3822roundToPx0680j_4(m439getTopD9Ej5fM()) + measureScope.m3822roundToPx0680j_4(m436getBottomD9Ej5fM());
        Placeable r12 = measurable.m3151measureBRTryo0(ConstraintsKt.m3819offsetNN6EwU(j, -r0, -r1));
        return MeasureScope.DefaultImpls.layout$default(measureScope, ConstraintsKt.m3817constrainWidthK40F9xA(j, r12.getWidth() + r0), ConstraintsKt.m3816constrainHeightK40F9xA(j, r12.getHeight() + r1), (Map) null, new PaddingModifier$measure$1(this, r12, measureScope), 4, (Object) null);
    }

    public int hashCode() {
        return (((((((Dp.m3865hashCodeimpl(m438getStartD9Ej5fM()) * 31) + Dp.m3865hashCodeimpl(m439getTopD9Ej5fM())) * 31) + Dp.m3865hashCodeimpl(m437getEndD9Ej5fM())) * 31) + Dp.m3865hashCodeimpl(m436getBottomD9Ej5fM())) * 31) + C$r8$backportedMethods$utility$Boolean$1$hashCode.hashCode(this.rtlAware);
    }

    public boolean equals(Object obj) {
        PaddingModifier paddingModifier = obj instanceof PaddingModifier ? (PaddingModifier) obj : null;
        if (paddingModifier != null && Dp.m3864equalsimpl0(m438getStartD9Ej5fM(), paddingModifier.m438getStartD9Ej5fM()) && Dp.m3864equalsimpl0(m439getTopD9Ej5fM(), paddingModifier.m439getTopD9Ej5fM()) && Dp.m3864equalsimpl0(m437getEndD9Ej5fM(), paddingModifier.m437getEndD9Ej5fM()) && Dp.m3864equalsimpl0(m436getBottomD9Ej5fM(), paddingModifier.m436getBottomD9Ej5fM()) && this.rtlAware == paddingModifier.rtlAware) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaddingModifier(float r11, float r12, float r13, float r14, boolean r15, kotlin.jvm.functions.Function1 r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r10 = this;
            r0 = r17 & 1
            r1 = 0
            if (r0 == 0) goto L_0x000c
            float r0 = (float) r1
            float r0 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r0)
            r3 = r0
            goto L_0x000d
        L_0x000c:
            r3 = r11
        L_0x000d:
            r0 = r17 & 2
            if (r0 == 0) goto L_0x0018
            float r0 = (float) r1
            float r0 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r0)
            r4 = r0
            goto L_0x0019
        L_0x0018:
            r4 = r12
        L_0x0019:
            r0 = r17 & 4
            if (r0 == 0) goto L_0x0024
            float r0 = (float) r1
            float r0 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r0)
            r5 = r0
            goto L_0x0025
        L_0x0024:
            r5 = r13
        L_0x0025:
            r0 = r17 & 8
            if (r0 == 0) goto L_0x0030
            float r0 = (float) r1
            float r0 = androidx.compose.ui.unit.Dp.m3859constructorimpl(r0)
            r6 = r0
            goto L_0x0031
        L_0x0030:
            r6 = r14
        L_0x0031:
            r9 = 0
            r2 = r10
            r7 = r15
            r8 = r16
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.PaddingModifier.<init>(float, float, float, float, boolean, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
